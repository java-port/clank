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
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.FunctionProtoType.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.llvm.*;
import org.clang.sema.impl.*;
import org.clank.java.stdimpl.aliases.*;
import org.clang.basic.target.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.DeclContext.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.DeclarationName.*;
import static org.clang.sema.impl.SemaDeclStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.sema.DeclaratorChunk.ParamInfo;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstAttributesRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import org.clang.basic.java.OptionalNotes;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaDecl">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.sema.Sema_SemaDecl",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaCoroutine ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema10ActOnFieldEPNS_5ScopeEPNS_4DeclENS_14SourceLocationERNS_10DeclaratorEPNS_4ExprE;_ZN5clang4Sema11ActOnFieldsEPNS_5ScopeENS_14SourceLocationEPNS_4DeclEN4llvm8ArrayRefIS5_EES3_S3_PNS_13AttributeListE;_ZN5clang4Sema11CheckShadowEPNS_5ScopeEPNS_7VarDeclE;_ZN5clang4Sema11CheckShadowEPNS_5ScopeEPNS_7VarDeclERKNS_12LookupResultE;_ZN5clang4Sema11HandleFieldEPNS_5ScopeEPNS_10RecordDeclENS_14SourceLocationERNS_10DeclaratorEPNS_4ExprENS_16InClassInitStyleENS_15AccessSpecifierE;_ZN5clang4Sema11computeNRVOEPNS_4StmtEPNS_4sema17FunctionScopeInfoE;_ZN5clang4Sema11getTypeNameERKNS_14IdentifierInfoENS_14SourceLocationEPNS_5ScopeEPNS_12CXXScopeSpecEbbNS_9OpaquePtrINS_8QualTypeEEEbbPPS1_;_ZN5clang4Sema12ClassifyNameEPNS_5ScopeERNS_12CXXScopeSpecERPNS_14IdentifierInfoENS_14SourceLocationERKNS_5TokenEbSt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteISD_EE;_ZN5clang4Sema12MergeVarDeclEPNS_7VarDeclERNS_12LookupResultE;_ZN5clang4Sema13ActOnEnumBodyENS_14SourceLocationENS_11SourceRangeEPNS_4DeclEN4llvm8ArrayRefIS4_EEPNS_5ScopeEPNS_13AttributeListE;_ZN5clang4Sema13ActOnPopScopeENS_14SourceLocationEPNS_5ScopeE;_ZN5clang4Sema13isDeclInScopeEPNS_9NamedDeclEPNS_11DeclContextEPNS_5ScopeEb;_ZN5clang4Sema14ActOnModuleEndENS_14SourceLocationEPNS_6ModuleE;_ZN5clang4Sema14CheckFieldDeclENS_15DeclarationNameENS_8QualTypeEPNS_14TypeSourceInfoEPNS_10RecordDeclENS_14SourceLocationEbPNS_4ExprENS_16InClassInitStyleES7_NS_15AccessSpecifierEPNS_9NamedDeclEPNS_10DeclaratorE;_ZN5clang4Sema14CheckParameterEPNS_11DeclContextENS_14SourceLocationES3_PNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassE;_ZN5clang4Sema14PopDeclContextEv;_ZN5clang4Sema14VerifyBitFieldENS_14SourceLocationEPNS_14IdentifierInfoENS_8QualTypeEbPNS_4ExprEPb;_ZN5clang4Sema15ActOnDeclaratorEPNS_5ScopeERNS_10DeclaratorE;_ZN5clang4Sema15PushDeclContextEPNS_5ScopeEPNS_11DeclContextE;_ZN5clang4Sema15getContainingDCEPNS_11DeclContextE;_ZN5clang4Sema16ActOnModuleBeginENS_14SourceLocationEPNS_6ModuleE;_ZN5clang4Sema16HandleDeclaratorEPNS_5ScopeERNS_10DeclaratorEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEE;_ZN5clang4Sema16ParseTypedefDeclEPNS_5ScopeERNS_10DeclaratorENS_8QualTypeEPNS_14TypeSourceInfoE;_ZN5clang4Sema16getSpecialMemberEPKNS_13CXXMethodDeclE;_ZN5clang4Sema17ActOnEnumConstantEPNS_5ScopeEPNS_4DeclES4_NS_14SourceLocationEPNS_14IdentifierInfoEPNS_13AttributeListES5_PNS_4ExprE;_ZN5clang4Sema17ActOnLastBitfieldENS_14SourceLocationERN4llvm15SmallVectorImplIPNS_4DeclEEE;_ZN5clang4Sema17ActOnModuleImportENS_14SourceLocationES1_N4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoES1_EEE;_ZN5clang4Sema17ActOnPragmaWeakIDEPNS_14IdentifierInfoENS_14SourceLocationES3_;_ZN5clang4Sema17CheckEnumConstantEPNS_8EnumDeclEPNS_16EnumConstantDeclENS_14SourceLocationEPNS_14IdentifierInfoEPNS_4ExprE;_ZN5clang4Sema17MergeFunctionDeclEPNS_12FunctionDeclERPNS_9NamedDeclEPNS_5ScopeEb;_ZN5clang4Sema17MergeVarDeclTypesEPNS_7VarDeclES2_b;_ZN5clang4Sema17PushOnScopeChainsEPNS_9NamedDeclEPNS_5ScopeEb;_ZN5clang4Sema18ActOnModuleIncludeENS_14SourceLocationEPNS_6ModuleE;_ZN5clang4Sema18DiagnoseUnusedDeclEPKNS_9NamedDeclE;_ZN5clang4Sema18handleTagNumberingEPKNS_7TagDeclEPNS_5ScopeE;_ZN5clang4Sema19FinalizeDeclarationEPNS_4DeclE;_ZN5clang4Sema19LazilyCreateBuiltinEPNS_14IdentifierInfoEjPNS_5ScopeEbNS_14SourceLocationE;_ZN5clang4Sema19canSkipFunctionBodyEPNS_4DeclE;_ZN5clang4Sema19mergeDeclAttributesEPNS_9NamedDeclEPNS_4DeclENS0_21AvailabilityMergeKindE;_ZN5clang4Sema20ActOnCXXForRangeDeclEPNS_4DeclE;_ZN5clang4Sema20ActOnParamDeclaratorEPNS_5ScopeERNS_10DeclaratorE;_ZN5clang4Sema20ActOnPragmaWeakAliasEPNS_14IdentifierInfoES2_NS_14SourceLocationES3_S3_;_ZN5clang4Sema20ActOnTypedefNameDeclEPNS_5ScopeEPNS_11DeclContextEPNS_15TypedefNameDeclERNS_12LookupResultERb;_ZN5clang4Sema20AddInitializerToDeclEPNS_4DeclEPNS_4ExprEbb;_ZN5clang4Sema20AddOverriddenMethodsEPNS_13CXXRecordDeclEPNS_13CXXMethodDeclE;_ZN5clang4Sema20BuildDeclaratorGroupEN4llvm15MutableArrayRefIPNS_4DeclEEEb;_ZN5clang4Sema20CheckNontrivialFieldEPNS_9FieldDeclE;_ZN5clang4Sema20FilterLookupForScopeERNS_12LookupResultEPNS_11DeclContextEPNS_5ScopeEbb;_ZN5clang4Sema20GetNameForDeclaratorERNS_10DeclaratorE;_ZN5clang4Sema20MergeTypedefNameDeclEPNS_5ScopeEPNS_15TypedefNameDeclERNS_12LookupResultE;_ZN5clang4Sema20canDelayFunctionBodyERKNS_10DeclaratorE;_ZN5clang4Sema20getNonFieldDeclScopeEPNS_5ScopeE;_ZN5clang4Sema20getObjCInterfaceDeclERPNS_14IdentifierInfoENS_14SourceLocationEb;_ZN5clang4Sema20inferObjCARCLifetimeEPNS_9ValueDeclE;_ZN5clang4Sema20mergeObjCMethodDeclsEPNS_14ObjCMethodDeclES2_;_ZN5clang4Sema21ActOnDocumentableDeclEPNS_4DeclE;_ZN5clang4Sema21ActOnFileScopeAsmDeclEPNS_4ExprENS_14SourceLocationES3_;_ZN5clang4Sema21ActOnInitializerErrorEPNS_4DeclE;_ZN5clang4Sema21CheckMSVCRTEntryPointEPNS_12FunctionDeclE;_ZN5clang4Sema21ExitDeclaratorContextEPNS_5ScopeE;_ZN5clang4Sema21isIncompatibleTypedefEPNS_8TypeDeclEPNS_15TypedefNameDeclE;_ZN5clang4Sema22ActOnDocumentableDeclsEN4llvm8ArrayRefIPNS_4DeclEEE;_ZN5clang4Sema22ActOnTypedefDeclaratorEPNS_5ScopeERNS_10DeclaratorEPNS_11DeclContextEPNS_14TypeSourceInfoERNS_12LookupResultE;_ZN5clang4Sema22ActOnUninitializedDeclEPNS_4DeclEb;_ZN5clang4Sema22CheckEnumRedeclarationENS_14SourceLocationEbNS_8QualTypeEbPKNS_8EnumDeclE;_ZN5clang4Sema22ConvertDeclToDeclGroupEPNS_4DeclES2_;_ZN5clang4Sema22EnterDeclaratorContextEPNS_5ScopeEPNS_11DeclContextE;_ZN5clang4Sema22getScopeForDeclContextEPNS_5ScopeEPNS_11DeclContextE;_ZN5clang4Sema22shouldSkipAnonEnumBodyEPNS_5ScopeEPNS_14IdentifierInfoENS_14SourceLocationE;_ZN5clang4Sema23ActOnFinishFunctionBodyEPNS_4DeclEPNS_4StmtE;_ZN5clang4Sema23ActOnFinishFunctionBodyEPNS_4DeclEPNS_4StmtEb;_ZN5clang4Sema23ActOnFunctionDeclaratorEPNS_5ScopeERNS_10DeclaratorEPNS_11DeclContextEPNS_14TypeSourceInfoERNS_12LookupResultEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEERb;_ZN5clang4Sema23ActOnStartOfFunctionDefEPNS_5ScopeEPNS_4DeclEPNS0_12SkipBodyInfoE;_ZN5clang4Sema23ActOnStartOfFunctionDefEPNS_5ScopeERNS_10DeclaratorEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEEPNS0_12SkipBodyInfoE;_ZN5clang4Sema23ActOnTagDefinitionErrorEPNS_5ScopeEPNS_4DeclE;_ZN5clang4Sema23ActOnTagStartDefinitionEPNS_5ScopeEPNS_4DeclE;_ZN5clang4Sema23ActOnVariableDeclaratorEPNS_5ScopeERNS_10DeclaratorEPNS_11DeclContextEPNS_14TypeSourceInfoERNS_12LookupResultEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEERb;_ZN5clang4Sema23CheckEnumUnderlyingTypeEPNS_14TypeSourceInfoE;_ZN5clang4Sema23DiagnoseClassNameShadowEPNS_11DeclContextENS_19DeclarationNameInfoE;_ZN5clang4Sema23DiagnoseUnknownTypeNameERPNS_14IdentifierInfoENS_14SourceLocationEPNS_5ScopeEPNS_12CXXScopeSpecERNS_9OpaquePtrINS_8QualTypeEEEb;_ZN5clang4Sema23FinalizeDeclaratorGroupEPNS_5ScopeERKNS_8DeclSpecEN4llvm8ArrayRefIPNS_4DeclEEE;_ZN5clang4Sema24ActOnExitFunctionContextEv;_ZN5clang4Sema24ActOnMSVCUnknownTypeNameERKNS_14IdentifierInfoENS_14SourceLocationEb;_ZN5clang4Sema24ActOnSkippedFunctionBodyEPNS_4DeclE;_ZN5clang4Sema24ActOnTagFinishDefinitionEPNS_5ScopeEPNS_4DeclENS_11SourceRangeE;_ZN5clang4Sema24CheckFunctionDeclarationEPNS_5ScopeEPNS_12FunctionDeclERNS_12LookupResultEb;_ZN5clang4Sema24CheckVariableDeclarationEPNS_7VarDeclERNS_12LookupResultE;_ZN5clang4Sema24DiagnoseUnusedParametersEN4llvm8ArrayRefIPNS_11ParmVarDeclEEE;_ZN5clang4Sema24GetNameFromUnqualifiedIdERKNS_13UnqualifiedIdE;_ZN5clang4Sema24ImplicitlyDefineFunctionENS_14SourceLocationERNS_14IdentifierInfoEPNS_5ScopeE;_ZN5clang4Sema24MarkUnusedFileScopedDeclEPKNS_14DeclaratorDeclE;_ZN5clang4Sema25pushExternalDeclIntoScopeEPNS_9NamedDeclENS_15DeclarationNameE;_ZN5clang4Sema26ActOnCXXForRangeIdentifierEPNS_5ScopeENS_14SourceLocationEPNS_14IdentifierInfoERNS_16ParsedAttributesES3_;_ZN5clang4Sema26ActOnPragmaRedefineExtnameEPNS_14IdentifierInfoES2_NS_14SourceLocationES3_S3_;_ZN5clang4Sema26AddKnownFunctionAttributesEPNS_12FunctionDeclE;_ZN5clang4Sema26BuildParmVarDeclForTypedefEPNS_11DeclContextENS_14SourceLocationENS_8QualTypeE;_ZN5clang4Sema26DiagnoseFunctionSpecifiersERKNS_8DeclSpecE;_ZN5clang4Sema26ParsedFreeStandingDeclSpecEPNS_5ScopeENS_15AccessSpecifierERNS_8DeclSpecEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEEbRPNS_10RecordDeclE;_ZN5clang4Sema26ParsedFreeStandingDeclSpecEPNS_5ScopeENS_15AccessSpecifierERNS_8DeclSpecERPNS_10RecordDeclE;_ZN5clang4Sema26isMicrosoftMissingTypenameEPKNS_12CXXScopeSpecEPNS_5ScopeE;_ZN5clang4Sema27ActOnFinishDelayedAttributeEPNS_5ScopeEPNS_4DeclERNS_16ParsedAttributesE;_ZN5clang4Sema27ActOnReenterFunctionContextEPNS_5ScopeEPNS_4DeclE;_ZN5clang4Sema27BuildAnonymousStructOrUnionEPNS_5ScopeERNS_8DeclSpecENS_15AccessSpecifierEPNS_10RecordDeclERKNS_14PrintingPolicyE;_ZN5clang4Sema27CheckForConstantInitializerEPNS_4ExprENS_8QualTypeE;_ZN5clang4Sema27mightHaveNonExternalLinkageEPKNS_14DeclaratorDeclE;_ZN5clang4Sema28ActOnFinishInlineFunctionDefEPNS_12FunctionDeclE;_ZN5clang4Sema28CheckForFunctionRedefinitionEPNS_12FunctionDeclEPKS1_PNS0_12SkipBodyInfoE;_ZN5clang4Sema28CheckVariableDeclarationTypeEPNS_7VarDeclE;_ZN5clang4Sema28DiagnoseUnusedNestedTypedefsEPKNS_10RecordDeclE;_ZN5clang4Sema28MergeCompatibleFunctionDeclsEPNS_12FunctionDeclES2_PNS_5ScopeEb;_ZN5clang4Sema28deduceVarTypeFromInitializerEPNS_7VarDeclENS_15DeclarationNameENS_8QualTypeEPNS_14TypeSourceInfoENS_11SourceRangeEbPNS_4ExprE;_ZN5clang4Sema28diagnoseQualifiedDeclarationERNS_12CXXScopeSpecEPNS_11DeclContextENS_15DeclarationNameENS_14SourceLocationE;_ZN5clang4Sema28findLocallyScopedExternCDeclENS_15DeclarationNameE;_ZN5clang4Sema28isAcceptableTagRedeclarationEPKNS_7TagDeclENS_11TagTypeKindEbNS_14SourceLocationEPKNS_14IdentifierInfoE;_ZN5clang4Sema28setTagNameForLinkagePurposesEPNS_7TagDeclEPNS_15TypedefNameDeclE;_ZN5clang4Sema29diagnoseMisplacedModuleImportEPNS_6ModuleENS_14SourceLocationE;_ZN5clang4Sema30ActOnTagStartSkippedDefinitionEPNS_5ScopeEPNS_4DeclE;_ZN5clang4Sema30BuildMicrosoftCAnonymousStructEPNS_5ScopeERNS_8DeclSpecEPNS_10RecordDeclE;_ZN5clang4Sema30CheckShadowingDeclModificationEPNS_4ExprENS_14SourceLocationE;_ZN5clang4Sema31ActOnFinishKNRParamDeclarationsEPNS_5ScopeERNS_10DeclaratorENS_14SourceLocationE;_ZN5clang4Sema31ActOnStartCXXMemberDeclarationsEPNS_5ScopeEPNS_4DeclENS_14SourceLocationEbS5_;_ZN5clang4Sema31ActOnTagFinishSkippedDefinitionEPv;_ZN5clang4Sema31adjustContextForLocalExternDeclERPNS_11DeclContextE;_ZN5clang4Sema32ActOnObjCReenterContainerContextEPNS_11DeclContextE;_ZN5clang4Sema32CheckCompleteVariableDeclarationEPNS_7VarDeclE;_ZN5clang4Sema32RegisterLocallyScopedExternCDeclEPNS_9NamedDeclEPNS_5ScopeE;_ZN5clang4Sema33ActOnObjCContainerStartDefinitionEPNS_4DeclE;_ZN5clang4Sema34ActOnObjCContainerFinishDefinitionEv;_ZN5clang4Sema35CheckTypedefForVariablyModifiedTypeEPNS_5ScopeEPNS_15TypedefNameDeclE;_ZN5clang4Sema38ActOnObjCTemporaryExitContainerContextEPNS_11DeclContextE;_ZN5clang4Sema38DiagnoseSizeOfParametersAndReturnValueEN4llvm8ArrayRefIPNS_11ParmVarDeclEEENS_8QualTypeEPNS_9NamedDeclE;_ZN5clang4Sema42createImplicitModuleImportForErrorRecoveryENS_14SourceLocationEPNS_6ModuleE;_ZN5clang4Sema8ActOnTagEPNS_5ScopeEjNS0_10TagUseKindENS_14SourceLocationERNS_12CXXScopeSpecEPNS_14IdentifierInfoES4_PNS_13AttributeListENS_15AccessSpecifierES4_N4llvm15MutableArrayRefIPNS_21TemplateParameterListEEERbSH_S4_bNS_12ActionResultINS_9OpaquePtrINS_8QualTypeEEELb0EEEbPNS0_12SkipBodyInfoE;_ZN5clang4Sema9ActOnIvarEPNS_5ScopeENS_14SourceLocationERNS_10DeclaratorEPNS_4ExprENS_3tok15ObjCKeywordKindE;_ZN5clang4Sema9CheckMainEPNS_12FunctionDeclERKNS_8DeclSpecE;_ZN5clang4Sema9isTagNameERNS_14IdentifierInfoEPNS_5ScopeE;_ZNK5clang4Sema17IsValueInFlagEnumEPKNS_8EnumDeclERKN4llvm5APIntEb;_ZNK5clang4Sema18getObjCDeclContextEv;_ZNK5clang4Sema21isSimpleTypeSpecifierENS_3tok9TokenKindE;_ZNK5clang4Sema25getCurContextAvailabilityEv;_ZNK5clang4Sema28getCallingConvAttributedTypeENS_8QualTypeE;_ZNK5clang4Sema32ShouldWarnIfUnusedFileScopedDeclEPKNS_14DeclaratorDeclE; -static-type=Sema_SemaDecl -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaDecl extends Sema_SemaCoroutine {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }


// We need this to handle
//
// typedef struct {
//   void *foo() { return 0; }
// } A;
//
// When we see foo we don't know if after the typedef we will get 'A' or '*A'
// for example. If 'A', foo will have external linkage. If we have '*A',
// foo will have no linkage. Since we can't know until we get to the end
// of the typedef, this function finds out if D might have non-external linkage.
// Callers should verify at the end of the TU if it D has external linkage or
// not.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::mightHaveNonExternalLinkage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1398,
 FQN="clang::Sema::mightHaveNonExternalLinkage", NM="_ZN5clang4Sema27mightHaveNonExternalLinkageEPKNS_14DeclaratorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema27mightHaveNonExternalLinkageEPKNS_14DeclaratorDeclE")
//</editor-fold>
protected/*private*/ static boolean mightHaveNonExternalLinkage(/*const*/ DeclaratorDecl /*P*/ D) {
  /*const*/ DeclContext /*P*/ DC = D.getDeclContext$Const();
  while (!DC.isTranslationUnit()) {
    {
      /*const*/ RecordDecl /*P*/ RD = dyn_cast_RecordDecl(DC);
      if ((RD != null)) {
        if (!RD.hasNameForLinkage()) {
          return true;
        }
      }
    }
    DC = DC.getParent$Const();
  }
  
  return !D.isExternallyVisible();
}


/// \brief Look for a locally scoped extern "C" declaration by the given name.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::findLocallyScopedExternCDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5284,
 FQN="clang::Sema::findLocallyScopedExternCDecl", NM="_ZN5clang4Sema28findLocallyScopedExternCDeclENS_15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema28findLocallyScopedExternCDeclENS_15DeclarationNameE")
//</editor-fold>
public final NamedDecl /*P*/ findLocallyScopedExternCDecl(DeclarationName Name) {
  // FIXME: We can have multiple results via __attribute__((overloadable)).
  DeclContextLookupResult Result = $this().Context.getExternCContextDecl().lookup(new DeclarationName(Name));
  return Result.empty() ? null : Result.begin().$star();
}


/// GetNameForDeclarator - Determine the full declaration name for the
/// given Declarator.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::GetNameForDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 4561,
 FQN="clang::Sema::GetNameForDeclarator", NM="_ZN5clang4Sema20GetNameForDeclaratorERNS_10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema20GetNameForDeclaratorERNS_10DeclaratorE")
//</editor-fold>
public final DeclarationNameInfo GetNameForDeclarator(final Declarator /*&*/ D) {
  return $this().GetNameFromUnqualifiedId(D.getName());
}


/// \brief Retrieves the declaration name from a parsed unqualified-id.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::GetNameFromUnqualifiedId">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 4566,
 FQN="clang::Sema::GetNameFromUnqualifiedId", NM="_ZN5clang4Sema24GetNameFromUnqualifiedIdERKNS_13UnqualifiedIdE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema24GetNameFromUnqualifiedIdERKNS_13UnqualifiedIdE")
//</editor-fold>
public final DeclarationNameInfo GetNameFromUnqualifiedId(final /*const*/ UnqualifiedId /*&*/ Name) {
  DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo();
  NameInfo.setLoc(/*NO_COPY*/Name.StartLocation);
  switch (Name.getKind()) {
   case IK_ImplicitSelfParam:
   case IK_Identifier:
    NameInfo.setName(new DeclarationName(Name.Unnamed_field1.Identifier));
    NameInfo.setLoc(/*NO_COPY*/Name.StartLocation);
    return NameInfo;
   case IK_OperatorFunctionId:
    NameInfo.setName($this().Context.DeclarationNames.getCXXOperatorName(Name.Unnamed_field1.OperatorFunctionId.Operator));
    NameInfo.setLoc(/*NO_COPY*/Name.StartLocation);
    NameInfo.getInfo().Unnamed_field.CXXOperatorName.BeginOpNameLoc
       = Name.Unnamed_field1.OperatorFunctionId.SymbolLocations[0];
    NameInfo.getInfo().Unnamed_field.CXXOperatorName.EndOpNameLoc
       = Name.EndLocation.getRawEncoding();
    return NameInfo;
   case IK_LiteralOperatorId:
    NameInfo.setName($this().Context.DeclarationNames.getCXXLiteralOperatorName(Name.Unnamed_field1.Identifier));
    NameInfo.setLoc(/*NO_COPY*/Name.StartLocation);
    NameInfo.setCXXLiteralOperatorNameLoc(new SourceLocation(Name.EndLocation));
    return NameInfo;
   case IK_ConversionFunctionId:
    {
      type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr();
      QualType Ty = GetTypeFromParser(Name.Unnamed_field1.ConversionFunctionId.$OpaquePtr$T(), $AddrOf(TInfo));
      if (Ty.isNull()) {
        return new DeclarationNameInfo();
      }
      NameInfo.setName($this().Context.DeclarationNames.getCXXConversionFunctionName($this().Context.getCanonicalType(/*NO_COPY*/Ty)));
      NameInfo.setLoc(/*NO_COPY*/Name.StartLocation);
      NameInfo.setNamedTypeInfo(TInfo.$star());
      return NameInfo;
    }
   case IK_ConstructorName:
    {
      type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr();
      QualType Ty = GetTypeFromParser(Name.Unnamed_field1.ConstructorName.$OpaquePtr$T(), $AddrOf(TInfo));
      if (Ty.isNull()) {
        return new DeclarationNameInfo();
      }
      NameInfo.setName($this().Context.DeclarationNames.getCXXConstructorName($this().Context.getCanonicalType(/*NO_COPY*/Ty)));
      NameInfo.setLoc(/*NO_COPY*/Name.StartLocation);
      NameInfo.setNamedTypeInfo(TInfo.$star());
      return NameInfo;
    }
   case IK_ConstructorTemplateId:
    {
      // In well-formed code, we can only have a constructor
      // template-id that refers to the current context, so go there
      // to find the actual type being constructed.
      CXXRecordDecl /*P*/ CurClass = dyn_cast_CXXRecordDecl($this().CurContext);
      if (!(CurClass != null) || CurClass.getIdentifier() != Name.Unnamed_field1.TemplateId.Name) {
        return new DeclarationNameInfo();
      }
      
      // Determine the type of the class being constructed.
      QualType CurClassType = $this().Context.getTypeDeclType(CurClass);
      
      // FIXME: Check two things: that the template-id names the same type as
      // CurClassType, and that the template-id does not occur when the name
      // was qualified.
      NameInfo.setName($this().Context.DeclarationNames.getCXXConstructorName($this().Context.getCanonicalType(/*NO_COPY*/CurClassType)));
      NameInfo.setLoc(/*NO_COPY*/Name.StartLocation);
      // FIXME: should we retrieve TypeSourceInfo?
      NameInfo.setNamedTypeInfo((TypeSourceInfo /*P*/ )null);
      return NameInfo;
    }
   case IK_DestructorName:
    {
      type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr();
      QualType Ty = GetTypeFromParser(Name.Unnamed_field1.DestructorName.$OpaquePtr$T(), $AddrOf(TInfo));
      if (Ty.isNull()) {
        return new DeclarationNameInfo();
      }
      NameInfo.setName($this().Context.DeclarationNames.getCXXDestructorName($this().Context.getCanonicalType(/*NO_COPY*/Ty)));
      NameInfo.setLoc(/*NO_COPY*/Name.StartLocation);
      NameInfo.setNamedTypeInfo(TInfo.$star());
      return NameInfo;
    }
   case IK_TemplateId:
    {
      TemplateName TName = Name.Unnamed_field1.TemplateId.Template.getTemplateName();
      SourceLocation TNameLoc = new SourceLocation(Name.Unnamed_field1.TemplateId.TemplateNameLoc);
      return $this().Context.getNameForTemplate(new TemplateName(TName), new SourceLocation(TNameLoc));
    }
  } // switch (Name.getKind())
  throw new llvm_unreachable("Unknown name kind");
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ConvertDeclToDeclGroup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 54,
 FQN="clang::Sema::ConvertDeclToDeclGroup", NM="_ZN5clang4Sema22ConvertDeclToDeclGroupEPNS_4DeclES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema22ConvertDeclToDeclGroupEPNS_4DeclES2_")
//</editor-fold>
public final OpaquePtr<DeclGroupRef> ConvertDeclToDeclGroup(Decl /*P*/ Ptr) {
  return ConvertDeclToDeclGroup(Ptr, (Decl /*P*/ )null);
}
public final OpaquePtr<DeclGroupRef> ConvertDeclToDeclGroup(Decl /*P*/ Ptr, Decl /*P*/ OwnedType/*= null*/) {
  if ((OwnedType != null)) {
    Decl /*P*/ Group[/*2*/] = new Decl /*P*/  [/*2*/] {OwnedType, Ptr};
    return OpaquePtr.<DeclGroupRef>make(DeclGroupRef.Create($this().Context, create_type$ptr(Group), 2));
  }
  
  return OpaquePtr.<DeclGroupRef>make(new DeclGroupRef(Ptr));
}

// end anonymous namespace

/// \brief Determine whether the token kind starts a simple-type-specifier.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isSimpleTypeSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 95,
 FQN="clang::Sema::isSimpleTypeSpecifier", NM="_ZNK5clang4Sema21isSimpleTypeSpecifierENS_3tok9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZNK5clang4Sema21isSimpleTypeSpecifierENS_3tok9TokenKindE")
//</editor-fold>
public final boolean isSimpleTypeSpecifier(/*tok.TokenKind*/char Kind) /*const*/ {
  switch (Kind) {
   case tok.TokenKind.kw_short:
   case tok.TokenKind.kw_long:
   case tok.TokenKind.kw___int64:
   case tok.TokenKind.kw___int128:
   case tok.TokenKind.kw_signed:
   case tok.TokenKind.kw_unsigned:
   case tok.TokenKind.kw_void:
   case tok.TokenKind.kw_char:
   case tok.TokenKind.kw_int:
   case tok.TokenKind.kw_half:
   case tok.TokenKind.kw_float:
   case tok.TokenKind.kw_double:
   case tok.TokenKind.kw___float128:
   case tok.TokenKind.kw_wchar_t:
   case tok.TokenKind.kw_bool:
   case tok.TokenKind.kw___underlying_type:
   case tok.TokenKind.kw___auto_type:
    // FIXME: Take into account the current language when deciding whether a
    // token kind is a valid type specifier
    return true;
   case tok.TokenKind.annot_typename:
   case tok.TokenKind.kw_char16_t:
   case tok.TokenKind.kw_char32_t:
   case tok.TokenKind.kw_typeof:
   case tok.TokenKind.annot_decltype:
   case tok.TokenKind.kw_decltype:
    return $this().getLangOpts().CPlusPlus;
   default:
    break;
  }
  
  return false;
}


/// \brief If the identifier refers to a type name within this scope,
/// return the declaration of that type.
///
/// This routine performs ordinary name lookup of the identifier II
/// within the given scope, with optional C++ scope specifier SS, to
/// determine whether the name refers to a type. If so, returns an
/// opaque pointer (actually a QualType) corresponding to that
/// type. Otherwise, returns NULL.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getTypeName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 249,
 FQN="clang::Sema::getTypeName", NM="_ZN5clang4Sema11getTypeNameERKNS_14IdentifierInfoENS_14SourceLocationEPNS_5ScopeEPNS_12CXXScopeSpecEbbNS_9OpaquePtrINS_8QualTypeEEEbbPPS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema11getTypeNameERKNS_14IdentifierInfoENS_14SourceLocationEPNS_5ScopeEPNS_12CXXScopeSpecEbbNS_9OpaquePtrINS_8QualTypeEEEbbPPS1_")
//</editor-fold>
public final OpaquePtr<QualType> getTypeName(final /*const*/ IdentifierInfo /*&*/ II, SourceLocation NameLoc, 
           Scope /*P*/ S) {
  return getTypeName(II, NameLoc, 
           S, (CXXScopeSpec /*P*/ )null, 
           false, false, 
           new OpaquePtr<QualType>(null), 
           false, 
           false, 
           (type$ptr<IdentifierInfo /*P*/ /*P*/>)null);
}
public final OpaquePtr<QualType> getTypeName(final /*const*/ IdentifierInfo /*&*/ II, SourceLocation NameLoc, 
           Scope /*P*/ S, CXXScopeSpec /*P*/ SS/*= null*/) {
  return getTypeName(II, NameLoc, 
           S, SS, 
           false, false, 
           new OpaquePtr<QualType>(null), 
           false, 
           false, 
           (type$ptr<IdentifierInfo /*P*/ /*P*/>)null);
}
public final OpaquePtr<QualType> getTypeName(final /*const*/ IdentifierInfo /*&*/ II, SourceLocation NameLoc, 
           Scope /*P*/ S, CXXScopeSpec /*P*/ SS/*= null*/, 
           boolean isClassName/*= false*/) {
  return getTypeName(II, NameLoc, 
           S, SS, 
           isClassName, false, 
           new OpaquePtr<QualType>(null), 
           false, 
           false, 
           (type$ptr<IdentifierInfo /*P*/ /*P*/>)null);
}
public final OpaquePtr<QualType> getTypeName(final /*const*/ IdentifierInfo /*&*/ II, SourceLocation NameLoc, 
           Scope /*P*/ S, CXXScopeSpec /*P*/ SS/*= null*/, 
           boolean isClassName/*= false*/, boolean HasTrailingDot/*= false*/) {
  return getTypeName(II, NameLoc, 
           S, SS, 
           isClassName, HasTrailingDot, 
           new OpaquePtr<QualType>(null), 
           false, 
           false, 
           (type$ptr<IdentifierInfo /*P*/ /*P*/>)null);
}
public final OpaquePtr<QualType> getTypeName(final /*const*/ IdentifierInfo /*&*/ II, SourceLocation NameLoc, 
           Scope /*P*/ S, CXXScopeSpec /*P*/ SS/*= null*/, 
           boolean isClassName/*= false*/, boolean HasTrailingDot/*= false*/, 
           OpaquePtr<QualType> ObjectTypePtr/*= null*/) {
  return getTypeName(II, NameLoc, 
           S, SS, 
           isClassName, HasTrailingDot, 
           ObjectTypePtr, 
           false, 
           false, 
           (type$ptr<IdentifierInfo /*P*/ /*P*/>)null);
}
public final OpaquePtr<QualType> getTypeName(final /*const*/ IdentifierInfo /*&*/ II, SourceLocation NameLoc, 
           Scope /*P*/ S, CXXScopeSpec /*P*/ SS/*= null*/, 
           boolean isClassName/*= false*/, boolean HasTrailingDot/*= false*/, 
           OpaquePtr<QualType> ObjectTypePtr/*= null*/, 
           boolean IsCtorOrDtorName/*= false*/) {
  return getTypeName(II, NameLoc, 
           S, SS, 
           isClassName, HasTrailingDot, 
           ObjectTypePtr, 
           IsCtorOrDtorName, 
           false, 
           (type$ptr<IdentifierInfo /*P*/ /*P*/>)null);
}
public final OpaquePtr<QualType> getTypeName(final /*const*/ IdentifierInfo /*&*/ II, SourceLocation NameLoc, 
           Scope /*P*/ S, CXXScopeSpec /*P*/ SS/*= null*/, 
           boolean isClassName/*= false*/, boolean HasTrailingDot/*= false*/, 
           OpaquePtr<QualType> ObjectTypePtr/*= null*/, 
           boolean IsCtorOrDtorName/*= false*/, 
           boolean WantNontrivialTypeSourceInfo/*= false*/) {
  return getTypeName(II, NameLoc, 
           S, SS, 
           isClassName, HasTrailingDot, 
           ObjectTypePtr, 
           IsCtorOrDtorName, 
           WantNontrivialTypeSourceInfo, 
           (type$ptr<IdentifierInfo /*P*/ /*P*/>)null);
}
public final OpaquePtr<QualType> getTypeName(final /*const*/ IdentifierInfo /*&*/ II, SourceLocation NameLoc, 
           Scope /*P*/ S, CXXScopeSpec /*P*/ SS/*= null*/, 
           boolean isClassName/*= false*/, boolean HasTrailingDot/*= false*/, 
           OpaquePtr<QualType> ObjectTypePtr/*= null*/, 
           boolean IsCtorOrDtorName/*= false*/, 
           boolean WantNontrivialTypeSourceInfo/*= false*/, 
           type$ptr<IdentifierInfo /*P*/ /*P*/> CorrectedII/*= null*/) {
  LookupResult Result = null;
  try {
    // Determine where we will perform name lookup.
    DeclContext /*P*/ LookupCtx = null;
    if (ObjectTypePtr.$bool()) {
      QualType ObjectType = ObjectTypePtr.getQualType();
      if (ObjectType.$arrow().isRecordType()) {
        LookupCtx = $this().computeDeclContext(new QualType(ObjectType));
      }
    } else if ((SS != null) && SS.isNotEmpty()) {
      LookupCtx = $this().computeDeclContext($Deref(SS), false);
      if (!(LookupCtx != null)) {
        if ($this().isDependentScopeSpecifier($Deref(SS))) {
          // C++ [temp.res]p3:
          //   A qualified-id that refers to a type and in which the
          //   nested-name-specifier depends on a template-parameter (14.6.2)
          //   shall be prefixed by the keyword typename to indicate that the
          //   qualified-id denotes a type, forming an
          //   elaborated-type-specifier (7.1.5.3).
          //
          // We therefore do not perform any name lookup if the result would
          // refer to a member of an unknown specialization.
          if (!isClassName && !IsCtorOrDtorName) {
            return new OpaquePtr<QualType>(null);
          }
          
          // We know from the grammar that this name refers to a type,
          // so build a dependent node to describe the type.
          if (WantNontrivialTypeSourceInfo) {
            return $this().ActOnTypenameType(S, new SourceLocation(), $Deref(SS), II, new SourceLocation(NameLoc)).get();
          }
          
          NestedNameSpecifierLoc QualifierLoc = SS.getWithLocInContext($this().Context);
          QualType T = $this().CheckTypenameType(ElaboratedTypeKeyword.ETK_None, new SourceLocation(), new NestedNameSpecifierLoc(QualifierLoc), 
              II, new SourceLocation(NameLoc));
          return OpaquePtr.<QualType>make(new QualType(T));
        }
        
        return new OpaquePtr<QualType>(null);
      }
      if (!LookupCtx.isDependentContext()
         && $this().RequireCompleteDeclContext($Deref(SS), LookupCtx)) {
        return new OpaquePtr<QualType>(null);
      }
    }
    
    // FIXME: LookupNestedNameSpecifierName isn't the right kind of
    // lookup for class-names.
    LookupNameKind Kind = isClassName ? LookupNameKind.LookupNestedNameSpecifierName : LookupNameKind.LookupOrdinaryName;
    Result/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName($AddrOf(II)), new SourceLocation(NameLoc), Kind);
    if ((LookupCtx != null)) {
      // Perform "qualified" name lookup into the declaration context we
      // computed, which is either the type of the base of a member access
      // expression or the declaration context associated with a prior
      // nested-name-specifier.
      $this().LookupQualifiedName(Result, LookupCtx);
      if (ObjectTypePtr.$bool() && Result.empty()) {
        // C++ [basic.lookup.classref]p3:
        //   If the unqualified-id is ~type-name, the type-name is looked up
        //   in the context of the entire postfix-expression. If the type T of
        //   the object expression is of a class type C, the type-name is also
        //   looked up in the scope of class C. At least one of the lookups shall
        //   find a name that refers to (possibly cv-qualified) T.
        $this().LookupName(Result, S);
      }
    } else {
      // Perform unqualified name lookup.
      $this().LookupName(Result, S);
      
      // For unqualified lookup in a class template in MSVC mode, look into
      // dependent base classes where the primary class template is known.
      if (Result.empty() && $this().getLangOpts().MSVCCompat && (!(SS != null) || SS.isEmpty())) {
        {
          OpaquePtr<QualType> TypeInBase = recoverFromTypeInKnownDependentBase(/*Deref*/$this(), II, new SourceLocation(NameLoc));
          if (TypeInBase.$bool()) {
            return TypeInBase;
          }
        }
      }
    }
    
    NamedDecl /*P*/ IIDecl = null;
    switch (Result.getResultKind()) {
     case NotFound:
     case NotFoundInCurrentInstantiation:
      if (Native.$bool(CorrectedII)) {
        TypoCorrection Correction = null;
        CXXScopeSpec NewSS = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          Correction = $c$.clean($this().CorrectTypo(Result.getLookupNameInfo(), Kind, S, SS, 
              $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new TypeNameValidatorCCC(true, isClassName))))), 
              CorrectTypoKind.CTK_ErrorRecovery));
          IdentifierInfo /*P*/ NewII = Correction.getCorrectionAsIdentifierInfo();
          OpaquePtr<TemplateName> Template/*J*/= new OpaquePtr<TemplateName>();
          bool$ref MemberOfUnknownSpecialization = create_bool$ref();
          UnqualifiedId TemplateName/*J*/= new UnqualifiedId();
          TemplateName.setIdentifier(NewII, new SourceLocation(NameLoc));
          NestedNameSpecifier /*P*/ NNS = Correction.getCorrectionSpecifier();
          NewSS/*J*/= new CXXScopeSpec();
          CXXScopeSpec /*P*/ NewSSPtr = SS;
          if ((SS != null) && (NNS != null)) {
            NewSS.MakeTrivial($this().Context, NNS, new SourceRange(/*NO_COPY*/NameLoc));
            NewSSPtr = $AddrOf(NewSS);
          }
          if (Correction.$bool() && ((NNS != null) || NewII != $AddrOf(II))
            // Ignore a correction to a template type as the to-be-corrected
            // identifier is not a template (typo correction for template names
            // is handled elsewhere).
             && !($this().getLangOpts().CPlusPlus && (NewSSPtr != null)
             && ($this().isTemplateName(S, $Deref(NewSSPtr), false, TemplateName, new OpaquePtr<QualType>(null), false, 
              Template, MemberOfUnknownSpecialization).getValue() != 0))) {
            OpaquePtr<QualType> Ty = $this().getTypeName($Deref(NewII), new SourceLocation(NameLoc), S, NewSSPtr, 
                isClassName, HasTrailingDot, new OpaquePtr<QualType>(ObjectTypePtr), 
                IsCtorOrDtorName, 
                WantNontrivialTypeSourceInfo);
            if (Ty.$bool()) {
              $this().diagnoseTypo(Correction, 
                  $out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_DeclarationName($c$.track($this().PDiag(diag.err_unknown_type_or_class_name_suggest)), 
                          Result.getLookupName()), (isClassName ? 1 : 0))); $c$.clean();
              if ((SS != null) && (NNS != null)) {
                SS.MakeTrivial($this().Context, NNS, new SourceRange(/*NO_COPY*/NameLoc));
              }
              CorrectedII.$set(NewII);
              return Ty;
            }
          }
        } finally {
          if (NewSS != null) { NewSS.$destroy(); }
          if (Correction != null) { Correction.$destroy(); }
          $c$.$destroy();
        }
      }
     case FoundOverloaded:
     case FoundUnresolvedValue:
      // If typo correction failed or was not performed, fall through
      Result.suppressDiagnostics();
      return new OpaquePtr<QualType>(null);
     case Ambiguous:
      // Recover from type-hiding ambiguities by hiding the type.  We'll
      // do the lookup again when looking for an object, and we can
      // diagnose the error then.  If we don't do this, then the error
      // about hiding the type will be immediately followed by an error
      // that only makes sense if the identifier was treated like a type.
      if (Result.getAmbiguityKind() == LookupResult.AmbiguityKind.AmbiguousTagHiding) {
        Result.suppressDiagnostics();
        return new OpaquePtr<QualType>(null);
      }
      
      // Look to see if we have a type anywhere in the list of results.
      for (UnresolvedSetIterator Res = Result.begin(), ResEnd = Result.end();
           Res.$noteq(ResEnd); Res.$preInc()) {
        if (isa_TypeDecl(Res.$star()) || isa_ObjCInterfaceDecl(Res.$star())) {
          if (!(IIDecl != null)
             || $less_uint((Res.$star()).getLocation().getRawEncoding()
            , IIDecl.getLocation().getRawEncoding())) {
            IIDecl = Res.$star();
          }
        }
      }
      if (!(IIDecl != null)) {
        // None of the entities we found is a type, so there is no way
        // to even assume that the result is a type. In this case, don't
        // complain about the ambiguity. The parser will either try to
        // perform this lookup again (e.g., as an object name), which
        // will produce the ambiguity, or will complain that it expected
        // a type name.
        Result.suppressDiagnostics();
        return new OpaquePtr<QualType>(null);
      }
      
      // We found a type within the ambiguous lookup; diagnose the
      // ambiguity and then return that type. This might be the right
      // answer, or it might not be, but it suppresses any attempt to
      // perform the name lookup again.
      break;
     case Found:
      IIDecl = Result.getFoundDecl();
      break;
    }
    assert ((IIDecl != null)) : "Didn't find decl";
    
    QualType T/*J*/= new QualType();
    {
      TypeDecl /*P*/ TD = dyn_cast_TypeDecl(IIDecl);
      if ((TD != null)) {
        $this().DiagnoseUseOfDecl(IIDecl, new SourceLocation(NameLoc));
        
        T.$assignMove($this().Context.getTypeDeclType(TD));
        $this().MarkAnyDeclReferenced(TD.getLocation(), TD, /*OdrUse=*/ false);
        
        // NOTE: avoid constructing an ElaboratedType(Loc) if this is a
        // constructor or destructor name (in such a case, the scope specifier
        // will be attached to the enclosing Expr or Decl node).
        if ((SS != null) && SS.isNotEmpty() && !IsCtorOrDtorName) {
          if (WantNontrivialTypeSourceInfo) {
            TypeLocBuilder Builder = null;
            try {
              // Construct a type with type-source information.
              Builder/*J*/= new TypeLocBuilder();
              Builder.pushTypeSpec(new QualType(T)).setNameLoc(new SourceLocation(NameLoc));
              
              T.$assignMove($this().getElaboratedType(ElaboratedTypeKeyword.ETK_None, $Deref(SS), new QualType(T)));
              ElaboratedTypeLoc ElabTL = Builder.push(ElaboratedTypeLoc.class, new QualType(T));
              ElabTL.setElaboratedKeywordLoc(new SourceLocation());
              ElabTL.setQualifierLoc(SS.getWithLocInContext($this().Context));
              return $this().CreateParsedType(new QualType(T), Builder.getTypeSourceInfo($this().Context, new QualType(T)));
            } finally {
              if (Builder != null) { Builder.$destroy(); }
            }
          } else {
            T.$assignMove($this().getElaboratedType(ElaboratedTypeKeyword.ETK_None, $Deref(SS), new QualType(T)));
          }
        }
      } else {
        ObjCInterfaceDecl /*P*/ IDecl = dyn_cast_ObjCInterfaceDecl(IIDecl);
        if ((IDecl != null)) {
          /*J:(void)*/$this().DiagnoseUseOfDecl(IDecl, new SourceLocation(NameLoc));
          if (!HasTrailingDot) {
            T.$assignMove($this().Context.getObjCInterfaceType(IDecl));
          }
        }
      }
    }
    if (T.isNull()) {
      // If it's not plausibly a type, suppress diagnostics.
      Result.suppressDiagnostics();
      return new OpaquePtr<QualType>(null);
    }
    return OpaquePtr.<QualType>make(new QualType(T));
  } finally {
    if (Result != null) { Result.$destroy(); }
  }
}


/// isTagName() - This method is called *for error recovery purposes only*
/// to determine if the specified name is a valid tag name ("struct foo").  If
/// so, this returns the TST for the tag corresponding to it (TST_enum,
/// TST_union, TST_struct, TST_interface, TST_class).  This is used to diagnose
/// cases in C where the user forgot to specify the tag.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isTagName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 550,
 FQN="clang::Sema::isTagName", NM="_ZN5clang4Sema9isTagNameERNS_14IdentifierInfoEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema9isTagNameERNS_14IdentifierInfoEPNS_5ScopeE")
//</editor-fold>
public final TypeSpecifierType isTagName(final IdentifierInfo /*&*/ II, Scope /*P*/ S) {
  LookupResult R = null;
  try {
    // Do a tag name lookup in this scope.
    R/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName($AddrOf(II)), new SourceLocation(), LookupNameKind.LookupTagName);
    $this().LookupName(R, S, false);
    R.suppressDiagnostics();
    if (R.getResultKind() == LookupResult.LookupResultKind.Found) {
      {
        /*const*/ TagDecl /*P*/ TD = R.<TagDecl>getAsSingle(TagDecl.class);
        if ((TD != null)) {
          switch (TD.getTagKind()) {
           case TTK_Struct:
            return DeclSpec.TST_struct;
           case TTK_Interface:
            return DeclSpec.TST_interface;
           case TTK_Union:
            return DeclSpec.TST_union;
           case TTK_Class:
            return DeclSpec.TST_class;
           case TTK_Enum:
            return DeclSpec.TST_enum;
          }
        }
      }
    }
    
    return DeclSpec.TST_unspecified;
  } finally {
    if (R != null) { R.$destroy(); }
  }
}


/// isMicrosoftMissingTypename - In Microsoft mode, within class scope,
/// if a CXXScopeSpec's type is equal to the type of one of the base classes
/// then downgrade the missing typename error to a warning.
/// This is needed for MSVC compatibility; Example:
/// @code
/// template<class T> class A {
/// public:
///   typedef int TYPE;
/// };
/// template<class T> class B : public A<T> {
/// public:
///   A<T>::TYPE a; // no typename required because A<T> is a base class.
/// };
/// @endcode
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isMicrosoftMissingTypename">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 583,
 FQN="clang::Sema::isMicrosoftMissingTypename", NM="_ZN5clang4Sema26isMicrosoftMissingTypenameEPKNS_12CXXScopeSpecEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema26isMicrosoftMissingTypenameEPKNS_12CXXScopeSpecEPNS_5ScopeE")
//</editor-fold>
public final boolean isMicrosoftMissingTypename(/*const*/ CXXScopeSpec /*P*/ SS, Scope /*P*/ S) {
  if ($this().CurContext.isRecord()) {
    if (SS.getScopeRep().getKind() == NestedNameSpecifier.SpecifierKind.Super) {
      return true;
    }
    
    /*const*/ Type /*P*/ Ty = SS.getScopeRep().getAsType();
    
    CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl($this().CurContext);
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.bases())  {
      if ($this().Context.hasSameUnqualifiedType(new QualType(Ty, 1), Base.getType())) {
        return true;
      }
    }
    return S.isFunctionPrototypeScope();
  }
  return $this().CurContext.isFunctionOrMethod() || S.isFunctionPrototypeScope();
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseUnknownTypeName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 599,
 FQN="clang::Sema::DiagnoseUnknownTypeName", NM="_ZN5clang4Sema23DiagnoseUnknownTypeNameERPNS_14IdentifierInfoENS_14SourceLocationEPNS_5ScopeEPNS_12CXXScopeSpecERNS_9OpaquePtrINS_8QualTypeEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema23DiagnoseUnknownTypeNameERPNS_14IdentifierInfoENS_14SourceLocationEPNS_5ScopeEPNS_12CXXScopeSpecERNS_9OpaquePtrINS_8QualTypeEEEb")
//</editor-fold>
public final void DiagnoseUnknownTypeName(final type$ref<IdentifierInfo /*P*/ /*&*/> II, 
                       SourceLocation IILoc, 
                       Scope /*P*/ S, 
                       CXXScopeSpec /*P*/ SS, 
                       final OpaquePtr<QualType> /*&*/ SuggestedType) {
  DiagnoseUnknownTypeName(II, 
                       IILoc, 
                       S, 
                       SS, 
                       SuggestedType, 
                       false);
}
public final void DiagnoseUnknownTypeName(final type$ref<IdentifierInfo /*P*/ /*&*/> II, 
                       SourceLocation IILoc, 
                       Scope /*P*/ S, 
                       CXXScopeSpec /*P*/ SS, 
                       final OpaquePtr<QualType> /*&*/ SuggestedType, 
                       boolean AllowClassTemplates/*= false*/) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // We don't have anything to suggest (yet).
    SuggestedType.$assignMove(new OpaquePtr<QualType>(null));
    {
      TypoCorrection Corrected = null;
      try {
        
        // There may have been a typo in the name of the type. Look up typo
        // results, in case we have something that we can suggest.
        Corrected = $c$.clean($this().CorrectTypo(new DeclarationNameInfo(new DeclarationName(II.$deref()), new SourceLocation(IILoc)), LookupNameKind.LookupOrdinaryName, S, SS, 
            $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new TypeNameValidatorCCC(false, false, AllowClassTemplates))))), 
            CorrectTypoKind.CTK_ErrorRecovery));
        if (Corrected.$bool()) {
          if (Corrected.isKeyword()) {
            // We corrected to a keyword.
            $this().diagnoseTypo(Corrected, $out_PartialDiagnostic$C_IdentifierInfo$C$P($c$.track($this().PDiag(diag.err_unknown_typename_suggest)), II.$deref())); $c$.clean();
            II.$set(Corrected.getCorrectionAsIdentifierInfo());
          } else {
            CXXScopeSpec tmpSS = null;
            try {
              // We found a similarly-named type or interface; suggest that.
              if (!(SS != null) || !SS.isSet()) {
                $this().diagnoseTypo(Corrected, 
                    $out_PartialDiagnostic$C_IdentifierInfo$C$P($c$.track($this().PDiag(diag.err_unknown_typename_suggest)), II.$deref())); $c$.clean();
              } else {
                DeclContext /*P*/ DC = $this().computeDeclContext($Deref(SS), false);
                if ((DC != null)) {
                  std.string CorrectedStr/*J*/= Corrected.getAsString($this().getLangOpts());
                  boolean DroppedSpecifier = Corrected.WillReplaceSpecifier()
                     && II.$deref().getName().equals(new StringRef(CorrectedStr));
                  $this().diagnoseTypo(Corrected, 
                      $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_int($out$Same2DeclContext($out_PartialDiagnostic$C_IdentifierInfo$C$P($c$.track($this().PDiag(diag.err_unknown_nested_typename_suggest)), 
                                      II.$deref()), DC), (DroppedSpecifier ? 1 : 0)), SS.getRange())); $c$.clean();
                } else {
                  throw new llvm_unreachable("could not have corrected a typo here");
                }
              }
              
              tmpSS/*J*/= new CXXScopeSpec();
              if ((Corrected.getCorrectionSpecifier() != null)) {
                tmpSS.MakeTrivial($this().Context, Corrected.getCorrectionSpecifier(), 
                    new SourceRange(/*NO_COPY*/IILoc));
              }
              SuggestedType.$assignMove(
                  $this().getTypeName($Deref(Corrected.getCorrectionAsIdentifierInfo()), new SourceLocation(IILoc), S, 
                      tmpSS.isSet() ? $AddrOf(tmpSS) : SS, false, false, new OpaquePtr<QualType>(null), 
                      /*IsCtorOrDtorName=*/ false, 
                      /*NonTrivialTypeSourceInfo=*/ true)
              );
            } finally {
              if (tmpSS != null) { tmpSS.$destroy(); }
            }
          }
          return;
        }
      } finally {
        if (Corrected != null) { Corrected.$destroy(); }
      }
    }
    if ($this().getLangOpts().CPlusPlus) {
      CXXScopeSpec EmptySS = null;
      try {
        // See if II is a class template that the user forgot to pass arguments to.
        UnqualifiedId Name/*J*/= new UnqualifiedId();
        Name.setIdentifier(II.$deref(), new SourceLocation(IILoc));
        EmptySS/*J*/= new CXXScopeSpec();
        OpaquePtr<TemplateName> TemplateResult/*J*/= new OpaquePtr<TemplateName>();
        bool$ref MemberOfUnknownSpecialization = create_bool$ref();
        if ($this().isTemplateName(S, (SS != null) ? $Deref(SS) : EmptySS, /*hasTemplateKeyword=*/ false, 
            Name, new OpaquePtr<QualType>(null), true, TemplateResult, 
            MemberOfUnknownSpecialization) == TemplateNameKind.TNK_Type_template) {
          TemplateName TplName = TemplateResult.getTemplateName();
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IILoc), diag.err_template_missing_args)), TplName));
          {
            TemplateDecl /*P*/ TplDecl = TplName.getAsTemplateDecl();
            if ((TplDecl != null)) {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(TplDecl.getLocation(), diag.note_template_decl_here)), 
                  TplDecl.getTemplateParameters().getSourceRange()));
            }
          }
          return;
        }
      } finally {
        if (EmptySS != null) { EmptySS.$destroy(); }
      }
    }
    
    // FIXME: Should we move the logic that tries to recover from a missing tag
    // (struct, union, enum) from Parser::ParseImplicitInt here, instead?
    if (!(SS != null) || (!SS.isSet() && !SS.isInvalid())) {
      $c$.clean($out_SemaDiagnosticBuilder_II($c$.track($this().Diag(new SourceLocation(IILoc), diag.err_unknown_typename)), II));
    } else {
      DeclContext /*P*/ DC = $this().computeDeclContext($Deref(SS), false);
      if ((DC != null)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder_II($c$.track($this().Diag(new SourceLocation(IILoc), diag.err_typename_nested_not_found)), 
                    II), DC), SS.getRange()));
      } else if ($this().isDependentScopeSpecifier($Deref(SS))) {
        /*uint*/int DiagID = diag.err_typename_missing;
        if ($this().getLangOpts().MSVCCompat && $this().isMicrosoftMissingTypename(SS, S)) {
          DiagID = diag.ext_typename_missing;
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_NestedNameSpec($c$.track($this().Diag(SS.getRange().getBegin(), DiagID)), 
                        SS.getScopeRep()), II.$deref().getName()), 
                new SourceRange(SS.getRange().getBegin(), /*NO_COPY*/IILoc)), 
            FixItHint.CreateInsertion(SS.getRange().getBegin(), new StringRef(/*KEEP_STR*/"typename "))));
        SuggestedType.$assignMove($this().ActOnTypenameType(S, new SourceLocation(), 
                $Deref(SS), $Deref(II.$deref()), new SourceLocation(IILoc)).get());
      } else {
        assert ((SS != null) && SS.isInvalid()) : "Invalid scope specifier has already been diagnosed";
      }
    }
  } finally {
    $c$.$destroy();
  }
}


/// Attempt to behave like MSVC in situations where lookup of an unqualified
/// type name has failed in a dependent context. In these situations, we
/// automatically form a DependentTypeName that will retry lookup in a related
/// scope during instantiation.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnMSVCUnknownTypeName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 497,
 FQN="clang::Sema::ActOnMSVCUnknownTypeName", NM="_ZN5clang4Sema24ActOnMSVCUnknownTypeNameERKNS_14IdentifierInfoENS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema24ActOnMSVCUnknownTypeNameERKNS_14IdentifierInfoENS_14SourceLocationEb")
//</editor-fold>
public final OpaquePtr<QualType> ActOnMSVCUnknownTypeName(final /*const*/ IdentifierInfo /*&*/ II, 
                        SourceLocation NameLoc, 
                        boolean IsTemplateTypeArg) {
  NestedNameSpecifierLocBuilder NNSLocBuilder = null;
  TypeLocBuilder Builder = null;
  try {
    assert ($this().getLangOpts().MSVCCompat) : "shouldn't be called in non-MSVC mode";
    
    NestedNameSpecifier /*P*/ NNS = null;
    if (IsTemplateTypeArg && $this().getCurScope().isTemplateParamScope()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // If we weren't able to parse a default template argument, delay lookup
        // until instantiation time by making a non-dependent DependentTypeName. We
        // pretend we saw a NestedNameSpecifier referring to the current scope, and
        // lookup is retried.
        // FIXME: This hurts our diagnostic quality, since we get errors like "no
        // type named 'Foo' in 'current_namespace'" when the user didn't write any
        // name specifiers.
        NNS = synthesizeCurrentNestedNameSpecifier($this().Context, $this().CurContext);
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NameLoc), diag.ext_ms_delayed_template_argument)), $AddrOf(II)));
      } finally {
        $c$.$destroy();
      }
    } else {
      /*const*/ CXXRecordDecl /*P*/ RD = findRecordWithDependentBasesOfEnclosingMethod($this().CurContext);
      if ((RD != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Build a DependentNameType that will perform lookup into RD at
          // instantiation time.
          NNS = NestedNameSpecifier.Create($this().Context, (NestedNameSpecifier /*P*/ )null, RD.isTemplateDecl(), 
              RD.getTypeForDecl());
          
          // Diagnose that this identifier was undeclared, and retry the lookup during
          // template instantiation.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NameLoc), diag.ext_undeclared_unqual_id_with_dependent_base)), $AddrOf(II)), 
              RD));
        } finally {
          $c$.$destroy();
        }
      } else {
        // This is not a situation that we should recover from.
        return new OpaquePtr<QualType>();
      }
    }
    
    QualType T = $this().Context.getDependentNameType(ElaboratedTypeKeyword.ETK_None, NNS, $AddrOf(II));
    
    // Build type location information.  We synthesized the qualifier, so we have
    // to build a fake NestedNameSpecifierLoc.
    NNSLocBuilder/*J*/= new NestedNameSpecifierLocBuilder();
    NNSLocBuilder.MakeTrivial($this().Context, NNS, new SourceRange(/*NO_COPY*/NameLoc));
    NestedNameSpecifierLoc QualifierLoc = NNSLocBuilder.getWithLocInContext($this().Context);
    
    Builder/*J*/= new TypeLocBuilder();
    DependentNameTypeLoc DepTL = Builder.push(DependentNameTypeLoc.class, new QualType(T));
    DepTL.setNameLoc(/*NO_COPY*/NameLoc);
    DepTL.setElaboratedKeywordLoc(new SourceLocation());
    DepTL.setQualifierLoc(/*NO_COPY*/QualifierLoc);
    return $this().CreateParsedType(new QualType(T), Builder.getTypeSourceInfo($this().Context, new QualType(T)));
  } finally {
    if (Builder != null) { Builder.$destroy(); }
    if (NNSLocBuilder != null) { NNSLocBuilder.$destroy(); }
  }
}


/// \brief Perform name lookup on the given name, classifying it based on
/// the results of name lookup and the following token.
///
/// This routine is used by the parser to resolve identifiers and help direct
/// parsing. When the identifier cannot be found, this routine will attempt
/// to correct the typo and classify based on the resulting name.
///
/// \param S The scope in which we're performing name lookup.
///
/// \param SS The nested-name-specifier that precedes the name.
///
/// \param Name The identifier. If typo correction finds an alternative name,
/// this pointer parameter will be updated accordingly.
///
/// \param NameLoc The location of the identifier.
///
/// \param NextToken The token following the identifier. Used to help
/// disambiguate the name.
///
/// \param IsAddressOfOperand True if this name is the operand of a unary
///        address of ('&') expression, assuming it is classified as an
///        expression.
///
/// \param CCC The correction callback, if typo correction is desired.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ClassifyName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 774,
 FQN="clang::Sema::ClassifyName", NM="_ZN5clang4Sema12ClassifyNameEPNS_5ScopeERNS_12CXXScopeSpecERPNS_14IdentifierInfoENS_14SourceLocationERKNS_5TokenEbSt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteISD_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema12ClassifyNameEPNS_5ScopeERNS_12CXXScopeSpecERPNS_14IdentifierInfoENS_14SourceLocationERKNS_5TokenEbSt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteISD_EE")
//</editor-fold>
public final Sema.NameClassification ClassifyName(Scope /*P*/ S, final CXXScopeSpec /*&*/ SS, final type$ref<IdentifierInfo /*P*/ /*&*/> Name, 
            SourceLocation NameLoc, final /*const*/ Token /*&*/ NextToken, 
            boolean IsAddressOfOperand) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    return $c$.clean(ClassifyName(S, SS, Name, 
            NameLoc, NextToken, 
            IsAddressOfOperand, 
            $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$NullPtr.INSTANCE, null))));
  } finally {
    $c$.$destroy();
  }
}
public final Sema.NameClassification ClassifyName(Scope /*P*/ S, final CXXScopeSpec /*&*/ SS, final type$ref<IdentifierInfo /*P*/ /*&*/> Name, 
            SourceLocation NameLoc, final /*const*/ Token /*&*/ NextToken, 
            boolean IsAddressOfOperand, 
            std.unique_ptr<CorrectionCandidateCallback> CCC/*= $c$.track(null)*/) {
  LookupResult Result = null;
  try {
    DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo(new DeclarationName(Name.$deref()), new SourceLocation(NameLoc));
    ObjCMethodDecl /*P*/ CurMethod = $this().getCurMethodDecl();
    if (NextToken.is(tok.TokenKind.coloncolon)) {
      $this().BuildCXXNestedNameSpecifier(S, $Deref(Name.$deref()), new SourceLocation(NameLoc), NextToken.getLocation(), 
          new QualType(), false, SS, (NamedDecl /*P*/ )null, false);
    }
    
    Result/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(Name.$deref()), new SourceLocation(NameLoc), LookupNameKind.LookupOrdinaryName);
    $this().LookupParsedName(Result, S, $AddrOf(SS), !(CurMethod != null));
    
    // For unqualified lookup in a class template in MSVC mode, look into
    // dependent base classes where the primary class template is known.
    if (Result.empty() && SS.isEmpty() && $this().getLangOpts().MSVCCompat) {
      {
        OpaquePtr<QualType> TypeInBase = recoverFromTypeInKnownDependentBase(/*Deref*/$this(), $Deref(Name.$deref()), new SourceLocation(NameLoc));
        if (TypeInBase.$bool()) {
          return new Sema.NameClassification(new OpaquePtr<QualType>(TypeInBase));
        }
      }
    }
    
    // Perform lookup for Objective-C instance variables (including automatically
    // synthesized instance variables), if we're in an Objective-C method.
    // FIXME: This lookup really, really needs to be folded in to the normal
    // unqualified lookup mechanism.
    if (!SS.isSet() && (CurMethod != null) && !isResultTypeOrTemplate(Result, NextToken)) {
      ActionResultTTrue<Expr /*P*/ > E = $this().LookupInObjCMethod(Result, S, Name.$deref(), true);
      if ((E.get() != null) || E.isInvalid()) {
        return new Sema.NameClassification(new ActionResultTTrue<Expr /*P*/ >(E));
      }
    }
    
    boolean SecondTry = false;
    boolean IsFilteredTemplateName = false;
   Corrected:
    do {   
      switch (Result.getResultKind()) {
       case NotFound:
        // If an unqualified-id is followed by a '(', then we have a function
        // call.
        if (!SS.isSet() && NextToken.is(tok.TokenKind.l_paren)) {
          // In C++, this is an ADL-only call.
          // FIXME: Reference?
          if ($this().getLangOpts().CPlusPlus) {
            return new Sema.NameClassification($this().BuildDeclarationNameExpr(SS, Result, /*ADL=*/ true));
          }
          {

            // C90 6.3.2.2:
            //   If the expression that precedes the parenthesized argument list in a
            //   function call consists solely of an identifier, and if no
            //   declaration is visible for this identifier, the identifier is
            //   implicitly declared exactly as if, in the innermost block containing
            //   the function call, the declaration
            //
            //     extern int identifier ();
            //
            //   appeared.
            //
            // We also allow this in C99 as an extension.
            NamedDecl /*P*/ D = $this().ImplicitlyDefineFunction(new SourceLocation(NameLoc), $Deref(Name.$deref()), S);
            if ((D != null)) {
              Result.addDecl(D);
              Result.resolveKind();
              return new Sema.NameClassification($this().BuildDeclarationNameExpr(SS, Result, /*ADL=*/ false));
            }
          }
        }

        // In C, we first see whether there is a tag type by the same name, in
        // which case it's likely that the user just forgot to write "enum",
        // "struct", or "union".
        if (!$this().getLangOpts().CPlusPlus && !SecondTry
           && isTagTypeWithMissingTag(/*Deref*/$this(), Result, S, SS, Name, new SourceLocation(NameLoc))) {
          break;
        }

        // Perform typo correction to determine if there is another name that is
        // close to this name.
        if (!SecondTry && CCC.$bool()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            SecondTry = true;
            {
              TypoCorrection Corrected = null;
              try {
                Corrected = $c$.clean($this().CorrectTypo(Result.getLookupNameInfo(), 
                    Result.getLookupKind(), S, 
                    $AddrOf(SS), $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Move.INSTANCE, std.move(CCC))), 
                    CorrectTypoKind.CTK_ErrorRecovery));
                if (Corrected.$bool()) {
                  /*uint*/int UnqualifiedDiag = diag.err_undeclared_var_use_suggest;
                  /*uint*/int QualifiedDiag = diag.err_no_member_suggest;

                  NamedDecl /*P*/ FirstDecl = Corrected.getFoundDecl();
                  NamedDecl /*P*/ UnderlyingFirstDecl = Corrected.getCorrectionDecl();
                  if ($this().getLangOpts().CPlusPlus && NextToken.is(tok.TokenKind.less)
                     && (UnderlyingFirstDecl != null) && isa_TemplateDecl(UnderlyingFirstDecl)) {
                    UnqualifiedDiag = diag.err_no_template_suggest;
                    QualifiedDiag = diag.err_no_member_template_suggest;
                  } else if ((UnderlyingFirstDecl != null)
                     && (isa_TypeDecl(UnderlyingFirstDecl)
                     || isa_ObjCInterfaceDecl(UnderlyingFirstDecl)
                     || isa_ObjCCompatibleAliasDecl(UnderlyingFirstDecl))) {
                    UnqualifiedDiag = diag.err_unknown_typename_suggest;
                    QualifiedDiag = diag.err_unknown_nested_typename_suggest;
                  }
                  if (SS.isEmpty()) {
                    $this().diagnoseTypo(Corrected, $out_PartialDiagnostic$C_IdentifierInfo$C$P($c$.track($this().PDiag(UnqualifiedDiag)), Name.$deref())); $c$.clean();
                  } else { // FIXME: is this even reachable? Test it.
                    std.string CorrectedStr/*J*/= Corrected.getAsString($this().getLangOpts());
                    boolean DroppedSpecifier = Corrected.WillReplaceSpecifier()
                       && Name.$deref().getName().equals(new StringRef(CorrectedStr));
                    $this().diagnoseTypo(Corrected, $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_int($out$Same2DeclContext($out_PartialDiagnostic$C_IdentifierInfo$C$P($c$.track($this().PDiag(QualifiedDiag)), 
                                        Name.$deref()), $this().computeDeclContext(SS, false)), 
                                (DroppedSpecifier ? 1 : 0)), SS.getRange())); $c$.clean();
                  }

                  // Update the name, so that the caller has the new name.
                  Name.$set(Corrected.getCorrectionAsIdentifierInfo());

                  // Typo correction corrected to a keyword.
                  if (Corrected.isKeyword()) {
                    return new Sema.NameClassification(Name.$deref());
                  }

                  // Also update the LookupResult...
                  // FIXME: This should probably go away at some point
                  Result.clear();
                  Result.setLookupName(Corrected.getCorrection());
                  if ((FirstDecl != null)) {
                    Result.addDecl(FirstDecl);
                  }
                  {

                    // If we found an Objective-C instance variable, let
                    // LookupInObjCMethod build the appropriate expression to
                    // reference the ivar.
                    // FIXME: This is a gross hack.
                    ObjCIvarDecl /*P*/ Ivar = Result.<ObjCIvarDecl>getAsSingle(ObjCIvarDecl.class);
                    if ((Ivar != null)) {
                      Result.clear();
                      ActionResultTTrue<Expr /*P*/ > E/*J*/= $this().LookupInObjCMethod(Result, S, Ivar.getIdentifier());
                      return new Sema.NameClassification(new ActionResultTTrue<Expr /*P*/ >(E));
                    }
                  }

                  continue Corrected;
                }
              } finally {
                if (Corrected != null) { Corrected.$destroy(); }
              }
            }
          } finally {
            $c$.$destroy();
          }
        }

        // We failed to correct; just fall through and let the parser deal with it.
        Result.suppressDiagnostics();
        return NameClassification.Unknown();
       case NotFoundInCurrentInstantiation:
        {
          // We performed name lookup into the current instantiation, and there were
          // dependent bases, so we treat this result the same way as any other
          // dependent nested-name-specifier.

          // C++ [temp.res]p2:
          //   A name used in a template declaration or definition and that is
          //   dependent on a template-parameter is assumed not to name a type
          //   unless the applicable name lookup finds a type name or the name is
          //   qualified by the keyword typename.
          //
          // FIXME: If the next token is '<', we might want to ask the parser to
          // perform some heroics to see if we actually have a
          // template-argument-list, which would indicate a missing 'template'
          // keyword here.
          return new Sema.NameClassification($this().ActOnDependentIdExpression(SS, /*TemplateKWLoc=*/ new SourceLocation(), 
                  NameInfo, IsAddressOfOperand, 
                  /*TemplateArgs=*/ (/*const*/ TemplateArgumentListInfo /*P*/ )null));
        }
       case Found:
       case FoundOverloaded:
       case FoundUnresolvedValue:
        break;
       case Ambiguous:
        if ($this().getLangOpts().CPlusPlus && NextToken.is(tok.TokenKind.less)
           && $this().hasAnyAcceptableTemplateNames(Result)) {
          // C++ [temp.local]p3:
          //   A lookup that finds an injected-class-name (10.2) can result in an
          //   ambiguity in certain cases (for example, if it is found in more than
          //   one base class). If all of the injected-class-names that are found
          //   refer to specializations of the same class template, and if the name
          //   is followed by a template-argument-list, the reference refers to the
          //   class template itself and not a specialization thereof, and is not
          //   ambiguous.
          //
          // This filtering can make an ambiguous result into an unambiguous one,
          // so try again after filtering out template names.
          $this().FilterAcceptableTemplateNames(Result);
          if (!Result.isAmbiguous()) {
            IsFilteredTemplateName = true;
            break;
          }
        }

        // Diagnose the ambiguity and return an error.
        return NameClassification.Error();
      }
      break;
    } while (true);
    if ($this().getLangOpts().CPlusPlus && NextToken.is(tok.TokenKind.less)
       && (IsFilteredTemplateName || $this().hasAnyAcceptableTemplateNames(Result))) {
      // C++ [temp.names]p3:
      //   After name lookup (3.4) finds that a name is a template-name or that
      //   an operator-function-id or a literal- operator-id refers to a set of
      //   overloaded functions any member of which is a function template if
      //   this is followed by a <, the < is always taken as the delimiter of a
      //   template-argument-list and never as the less-than operator.
      if (!IsFilteredTemplateName) {
        $this().FilterAcceptableTemplateNames(Result);
      }
      if (!Result.empty()) {
        boolean IsFunctionTemplate;
        boolean IsVarTemplate = false;
        TemplateName Template/*J*/= new TemplateName();
        if (Result.end().$sub(Result.begin()) > 1) {
          IsFunctionTemplate = true;
          Template.$assignMove($this().Context.getOverloadedTemplateName(Result.begin(), 
                  Result.end()));
        } else {
          TemplateDecl /*P*/ TD = cast_TemplateDecl((Result.begin().$star()).getUnderlyingDecl());
          IsFunctionTemplate = isa_FunctionTemplateDecl(TD);
          IsVarTemplate = isa_VarTemplateDecl(TD);
          if (SS.isSet() && !SS.isInvalid()) {
            Template.$assignMove($this().Context.getQualifiedTemplateName(SS.getScopeRep(), 
                    /*TemplateKeyword=*/ false, 
                    TD));
          } else {
            Template.$assignMove(new TemplateName(TD));
          }
        }
        if (IsFunctionTemplate) {
          // Function templates always go through overload resolution, at which
          // point we'll perform the various checks (e.g., accessibility) we need
          // to based on which function we selected.
          Result.suppressDiagnostics();
          
          return NameClassification.FunctionTemplate(new TemplateName(Template));
        }
        
        return IsVarTemplate ? NameClassification.VarTemplate(new TemplateName(Template)) : NameClassification.TypeTemplate(new TemplateName(Template));
      }
    }
    
    NamedDecl /*P*/ FirstDecl = (Result.begin().$star()).getUnderlyingDecl();
    {
      TypeDecl /*P*/ Type = dyn_cast_TypeDecl(FirstDecl);
      if ((Type != null)) {
        $this().DiagnoseUseOfDecl(Type, new SourceLocation(NameLoc));
        $this().MarkAnyDeclReferenced(Type.getLocation(), Type, /*OdrUse=*/ false);
        QualType T = $this().Context.getTypeDeclType(Type);
        if (SS.isNotEmpty()) {
          return new Sema.NameClassification(buildNestedType(/*Deref*/$this(), SS, new QualType(T), new SourceLocation(NameLoc)));
        }
        return new Sema.NameClassification(OpaquePtr.<QualType>make(new QualType(T)));
      }
    }
    
    ObjCInterfaceDecl /*P*/ Class = dyn_cast_ObjCInterfaceDecl(FirstDecl);
    if (!(Class != null)) {
      {
        // FIXME: It's unfortunate that we don't have a Type node for handling this.
        ObjCCompatibleAliasDecl /*P*/ Alias = dyn_cast_ObjCCompatibleAliasDecl(FirstDecl);
        if ((Alias != null)) {
          Class = Alias.getClassInterface();
        }
      }
    }
    if ((Class != null)) {
      $this().DiagnoseUseOfDecl(Class, new SourceLocation(NameLoc));
      if (NextToken.is(tok.TokenKind.period)) {
        // Interface. <something> is parsed as a property reference expression.
        // Just return "unknown" as a fall-through for now.
        Result.suppressDiagnostics();
        return NameClassification.Unknown();
      }
      
      QualType T = $this().Context.getObjCInterfaceType(Class);
      return new Sema.NameClassification(OpaquePtr.<QualType>make(new QualType(T)));
    }
    
    // We can have a type template here if we're classifying a template argument.
    if (isa_TemplateDecl(FirstDecl) && !isa_FunctionTemplateDecl(FirstDecl)) {
      return NameClassification.TypeTemplate(new TemplateName(cast_TemplateDecl(FirstDecl)));
    }
    
    // Check for a tag type hidden by a non-type decl in a few cases where it
    // seems likely a type is wanted instead of the non-type that was found.
    boolean NextIsOp = NextToken.isOneOf(tok.TokenKind.amp, tok.TokenKind.star);
    if ((NextToken.is(tok.TokenKind.identifier)
       || (NextIsOp
       && FirstDecl.getUnderlyingDecl().isFunctionOrFunctionTemplate()))
       && isTagTypeWithMissingTag(/*Deref*/$this(), Result, S, SS, Name, new SourceLocation(NameLoc))) {
      TypeDecl /*P*/ Type = Result.<TypeDecl>getAsSingle(TypeDecl.class);
      $this().DiagnoseUseOfDecl(Type, new SourceLocation(NameLoc));
      QualType T = $this().Context.getTypeDeclType(Type);
      if (SS.isNotEmpty()) {
        return new Sema.NameClassification(buildNestedType(/*Deref*/$this(), SS, new QualType(T), new SourceLocation(NameLoc)));
      }
      return new Sema.NameClassification(OpaquePtr.<QualType>make(new QualType(T)));
    }
    if (FirstDecl.isCXXClassMember()) {
      return new Sema.NameClassification($this().BuildPossibleImplicitMemberExpr(SS, new SourceLocation(), Result, 
              (/*const*/ TemplateArgumentListInfo /*P*/ )null, S));
    }
    
    boolean ADL = $this().UseArgumentDependentLookup(SS, Result, NextToken.is(tok.TokenKind.l_paren));
    return new Sema.NameClassification($this().BuildDeclarationNameExpr(SS, Result, ADL));
  } finally {
    if (Result != null) { Result.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnDeclarator">
@Converted(kind = Converted.Kind.MANUAL,
 optimized = Converted.Optimization.VALUE_TYPE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 4788,
 FQN="clang::Sema::ActOnDeclarator", NM="_ZN5clang4Sema15ActOnDeclaratorEPNS_5ScopeERNS_10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema15ActOnDeclaratorEPNS_5ScopeERNS_10DeclaratorE")
//</editor-fold>
public final Decl /*P*/ ActOnDeclarator(Scope /*P*/ S, final Declarator /*&*/ D) {
  D.setFunctionDefinitionKind(FunctionDefinitionKind.FDK_Declaration);
  Decl /*P*/ Dcl = $this().HandleDeclarator(S, D, MutableArrayRef.<TemplateParameterList /*P*/ >None());
  if (($this().OriginalLexicalContext != null) && $this().OriginalLexicalContext.isObjCContainer()
     && (Dcl != null) && Dcl.getDeclContext().isFileContext()) {
    Dcl.setTopLevelDeclInObjCContainer();
  }
  
  return Dcl;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::HandleDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 4916,
 FQN="clang::Sema::HandleDeclarator", NM="_ZN5clang4Sema16HandleDeclaratorEPNS_5ScopeERNS_10DeclaratorEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema16HandleDeclaratorEPNS_5ScopeERNS_10DeclaratorEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEE")
//</editor-fold>
public final NamedDecl /*P*/ HandleDeclarator(Scope /*P*/ S, final Declarator /*&*/ D, 
                MutableArrayRef<TemplateParameterList /*P*/ > TemplateParamLists) {
  LookupResult Previous = null;
  try {
    // TODO: consider using NameInfo for diagnostic.
    DeclarationNameInfo NameInfo = $this().GetNameForDeclarator(D);
    DeclarationName Name = NameInfo.getName();
    
    // All of these full declarators require an identifier.  If it doesn't have
    // one, the ParsedFreeStandingDeclSpec action should be used.
    if (!Name.$bool()) {
      if (!D.isInvalidType()) { // Reject this if we think it is valid.
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getLocStart(), 
                      diag.err_declarator_need_ident)), 
                  D.getDeclSpec().getSourceRange()), D.getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
      return null;
    } else if ($this().DiagnoseUnexpandedParameterPack(NameInfo, UnexpandedParameterPackContext.UPPC_DeclarationType)) {
      return null;
    }
    
    // The scope passed in may not be a decl scope.  Zip up the scope tree until
    // we find one that is.
    while ((S.getFlags() & Scope.ScopeFlags.DeclScope) == 0
       || (S.getFlags() & Scope.ScopeFlags.TemplateParamScope) != 0) {
      S = S.getParent();
    }
    
    DeclContext /*P*/ DC = $this().CurContext;
    if (D.getCXXScopeSpec().isInvalid()) {
      D.setInvalidType();
    } else if (D.getCXXScopeSpec().isSet()) {
      if ($this().DiagnoseUnexpandedParameterPack(D.getCXXScopeSpec(), 
          UnexpandedParameterPackContext.UPPC_DeclarationQualifier)) {
        return null;
      }
      
      boolean EnteringContext = !D.getDeclSpec().isFriendSpecified();
      DC = $this().computeDeclContext(D.getCXXScopeSpec(), EnteringContext);
      if (!(DC != null) || isa_EnumDecl(DC)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // If we could not compute the declaration context, it's because the
          // declaration context is dependent but does not refer to a class,
          // class template, or class template partial specialization. Complain
          // and return early, to avoid the coming semantic disaster.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_NestedNameSpec($c$.track($this().Diag(D.getIdentifierLoc(), 
                      diag.err_template_qualified_declarator_no_match)), 
                  D.getCXXScopeSpec().getScopeRep()), 
              D.getCXXScopeSpec().getRange()));
          return null;
        } finally {
          $c$.$destroy();
        }
      }
      boolean IsDependentContext = DC.isDependentContext();
      if (!IsDependentContext
         && $this().RequireCompleteDeclContext(D.getCXXScopeSpec(), DC)) {
        return null;
      }
      
      // If a class is incomplete, do not parse entities inside it.
      if (isa_CXXRecordDecl(DC) && !cast_CXXRecordDecl(DC).hasDefinition()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), 
                          diag.err_member_def_undefined_record)), 
                      Name), DC), D.getCXXScopeSpec().getRange()));
          return null;
        } finally {
          $c$.$destroy();
        }
      }
      if (!D.getDeclSpec().isFriendSpecified()) {
        if ($this().diagnoseQualifiedDeclaration(D.getCXXScopeSpec(), DC, 
            new DeclarationName(Name), D.getIdentifierLoc())) {
          if (DC.isRecord()) {
            return null;
          }
          
          D.setInvalidType();
        }
      }
      
      // Check whether we need to rebuild the type of the given
      // declaration in the current instantiation.
      if (EnteringContext && IsDependentContext
         && TemplateParamLists.size() != 0) {
        ContextRAII SavedContext = null;
        try {
          SavedContext/*J*/= new ContextRAII(/*Deref*/$this(), DC);
          if (RebuildDeclaratorInCurrentInstantiation(/*Deref*/$this(), D, new DeclarationName(Name))) {
            D.setInvalidType();
          }
        } finally {
          if (SavedContext != null) { SavedContext.$destroy(); }
        }
      }
    }
    
    TypeSourceInfo /*P*/ TInfo = $this().GetTypeForDeclarator(D, S);
    QualType R = TInfo.getType();
    if (!R.$arrow().isFunctionType() && $this().DiagnoseClassNameShadow(DC, new DeclarationNameInfo(NameInfo))) {
      // If this is a typedef, we'll end up spewing multiple diagnostics.
      // Just return early; it's safer. If this is a function, let the
      // "constructor cannot have a return type" diagnostic handle it.
      if (D.getDeclSpec().getStorageClassSpec() == DeclSpec.SCS.SCS_typedef) {
        return null;
      }
    }
    if ($this().DiagnoseUnexpandedParameterPack(D.getIdentifierLoc(), TInfo, 
        UnexpandedParameterPackContext.UPPC_DeclarationType)) {
      D.setInvalidType();
    }
    
    Previous/*J*/= new LookupResult(/*Deref*/$this(), NameInfo, LookupNameKind.LookupOrdinaryName, 
        RedeclarationKind.ForRedeclaration);
    
    // See if this is a redefinition of a variable in the same scope.
    if (!D.getCXXScopeSpec().isSet()) {
      boolean IsLinkageLookup = false;
      boolean CreateBuiltins = false;
      
      // If the declaration we're planning to build will be a function
      // or object with linkage, then look for another declaration with
      // linkage (C99 6.2.2p4-5 and C++ [basic.link]p6).
      //
      // If the declaration we're planning to build will be declared with
      // external linkage in the translation unit, create any builtin with
      // the same name.
      if (D.getDeclSpec().getStorageClassSpec() == DeclSpec.SCS.SCS_typedef) {
/* Do nothing*/         ;
      } else if ($this().CurContext.isFunctionOrMethod()
         && (D.getDeclSpec().getStorageClassSpec() == DeclSpec.SCS.SCS_extern
         || R.$arrow().isFunctionType())) {
        IsLinkageLookup = true;
        CreateBuiltins
           = $this().CurContext.getEnclosingNamespaceContext().isTranslationUnit();
      } else if ($this().CurContext.getRedeclContext().isTranslationUnit()
         && D.getDeclSpec().getStorageClassSpec() != DeclSpec.SCS.SCS_static) {
        CreateBuiltins = true;
      }
      if (IsLinkageLookup) {
        Previous.clear(LookupNameKind.LookupRedeclarationWithLinkage);
      }
      
      $this().LookupName(Previous, S, CreateBuiltins);
    } else { // Something like "int foo::x;"
      $this().LookupQualifiedName(Previous, DC);
      
      // C++ [dcl.meaning]p1:
      //   When the declarator-id is qualified, the declaration shall refer to a
      //  previously declared member of the class or namespace to which the
      //  qualifier refers (or, in the case of a namespace, of an element of the
      //  inline namespace set of that namespace (7.3.1)) or to a specialization
      //  thereof; [...]
      //
      // Note that we already checked the context above, and that we do not have
      // enough information to make sure that Previous contains the declaration
      // we want to match. For example, given:
      //
      //   class X {
      //     void f();
      //     void f(float);
      //   };
      //
      //   void X::f(int) { } // ill-formed
      //
      // In this case, Previous will point to the overload set
      // containing the two f's declared in X, but neither of them
      // matches.
      
      // C++ [dcl.meaning]p1:
      //   [...] the member shall not merely have been introduced by a
      //   using-declaration in the scope of the class or namespace nominated by
      //   the nested-name-specifier of the declarator-id.
      SemaDeclStatics.RemoveUsingDecls(Previous);
    }
    if (Previous.isSingleResult()
       && Previous.getFoundDecl().isTemplateParameter()) {
      // Maybe we will complain about the shadowed template parameter.
      if (!D.isInvalidType()) {
        $this().DiagnoseTemplateParameterShadow(D.getIdentifierLoc(), 
            Previous.getFoundDecl());
      }
      
      // Just pretend that we didn't see the previous declaration.
      Previous.clear();
    }
    
    // In C++, the previous declaration we find might be a tag type
    // (class or enum). In this case, the new declaration will hide the
    // tag type. Note that this does does not apply if we're declaring a
    // typedef (C++ [dcl.typedef]p4).
    if (Previous.isSingleTagDecl()
       && D.getDeclSpec().getStorageClassSpec() != DeclSpec.SCS.SCS_typedef) {
      Previous.clear();
    }
    
    // Check that there are no default arguments other than in the parameters
    // of a function declaration (C++ only).
    if ($this().getLangOpts().CPlusPlus) {
      $this().CheckExtraCXXDefaultArguments(D);
    }
    if (D.getDeclSpec().isConceptSpecified()) {
      // C++ Concepts TS [dcl.spec.concept]p1: The concept specifier shall be
      // applied only to the definition of a function template or variable
      // template, declared in namespace scope
      if (!(TemplateParamLists.size() != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(D.getDeclSpec().getConceptSpecLoc(), 
              diag.err_concept_wrong_decl_kind)));
          return null;
        } finally {
          $c$.$destroy();
        }
      }
      if (!DC.getRedeclContext().isFileContext()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(D.getIdentifierLoc(), 
              diag.err_concept_decls_may_only_appear_in_namespace_scope)));
          return null;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    NamedDecl /*P*/ New;
    
    bool$ref AddToScope = create_bool$ref(true);
    if (D.getDeclSpec().getStorageClassSpec() == DeclSpec.SCS.SCS_typedef) {
      if ((TemplateParamLists.size() != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_template_typedef)));
          return null;
        } finally {
          $c$.$destroy();
        }
      }
      
      New = $this().ActOnTypedefDeclarator(S, D, DC, TInfo, Previous);
    } else if (R.$arrow().isFunctionType()) {
      New = $this().ActOnFunctionDeclarator(S, D, DC, TInfo, Previous, 
          new MutableArrayRef<TemplateParameterList /*P*/ >(TemplateParamLists), 
          AddToScope);
    } else {
      New = $this().ActOnVariableDeclarator(S, D, DC, TInfo, Previous, new MutableArrayRef<TemplateParameterList /*P*/ >(TemplateParamLists), 
          AddToScope);
    }
    if (!(New != null)) {
      return null;
    }
    
    // If this has an identifier and is not a function template specialization,
    // add it to the scope stack.
    if (New.getDeclName().$bool() && AddToScope.$deref()) {
      // Only make a locally-scoped extern declaration visible if it is the first
      // declaration of this entity. Qualified lookup for such an entity should
      // only find this declaration if there is no visible declaration of it.
      boolean AddToContext = !D.isRedeclaration() || !New.isLocalExternDecl();
      $this().PushOnScopeChains(New, S, AddToContext);
      if (!AddToContext) {
        $this().CurContext.addHiddenDecl(New);
      }
    }
    if ($this().isInOpenMPDeclareTargetContext()) {
      $this().checkDeclIsAllowedInOpenMPTarget((Expr /*P*/ )null, New);
    }
    
    return New;
  } finally {
    if (Previous != null) { Previous.$destroy(); }
  }
}


/// \brief Register the given locally-scoped extern "C" declaration so
/// that it can be found later for redeclarations. We include any extern "C"
/// declaration that is not visible in the translation unit here, not just
/// function-scope declarations.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::RegisterLocallyScopedExternCDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5273,
 FQN="clang::Sema::RegisterLocallyScopedExternCDecl", NM="_ZN5clang4Sema32RegisterLocallyScopedExternCDeclEPNS_9NamedDeclEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema32RegisterLocallyScopedExternCDeclEPNS_9NamedDeclEPNS_5ScopeE")
//</editor-fold>
public final void RegisterLocallyScopedExternCDecl(NamedDecl /*P*/ ND, Scope /*P*/ S) {
  if (!$this().getLangOpts().CPlusPlus
     && ND.getLexicalDeclContext().getRedeclContext().isTranslationUnit()) {
    // Don't need to track declarations in the TU in C.
    return;
  }
  
  // Note that we have a locally-scoped external with this name.
  $this().Context.getExternCContextDecl().makeDeclVisibleInContext(ND);
}


/// DiagnoseClassNameShadow - Implement C++ [class.mem]p13:
///   If T is the name of a class, then each of the following shall have a
///   name different from T:
///     - every static data member of class T;
///     - every member function of class T
///     - every member of class T that is itself a type;
/// \returns true if the declaration name violates these rules.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseClassNameShadow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 4806,
 FQN="clang::Sema::DiagnoseClassNameShadow", NM="_ZN5clang4Sema23DiagnoseClassNameShadowEPNS_11DeclContextENS_19DeclarationNameInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema23DiagnoseClassNameShadowEPNS_11DeclContextENS_19DeclarationNameInfoE")
//</editor-fold>
public final boolean DiagnoseClassNameShadow(DeclContext /*P*/ DC, 
                       DeclarationNameInfo NameInfo) {
  DeclarationName Name = NameInfo.getName();
  
  CXXRecordDecl /*P*/ Record = dyn_cast_CXXRecordDecl(DC);
  while ((Record != null) && Record.isAnonymousStructOrUnion()) {
    Record = dyn_cast_CXXRecordDecl(Record.getParent());
  }
  if ((Record != null) && (Record.getIdentifier() != null) && $eq_DeclarationName(Record.getDeclName(), /*NO_COPY*/Name)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NameInfo.getLoc(), diag.err_member_name_of_class)), Name));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}


/// \brief Diagnose a declaration whose declarator-id has the given
/// nested-name-specifier.
///
/// \param SS The nested-name-specifier of the declarator-id.
///
/// \param DC The declaration context to which the nested-name-specifier
/// resolves.
///
/// \param Name The name of the entity being declared.
///
/// \param Loc The location of the name of the entity being declared.
///
/// \returns true if we cannot safely recover from this error, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::diagnoseQualifiedDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 4834,
 FQN="clang::Sema::diagnoseQualifiedDeclaration", NM="_ZN5clang4Sema28diagnoseQualifiedDeclarationERNS_12CXXScopeSpecEPNS_11DeclContextENS_15DeclarationNameENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema28diagnoseQualifiedDeclarationERNS_12CXXScopeSpecEPNS_11DeclContextENS_15DeclarationNameENS_14SourceLocationE")
//</editor-fold>
public final boolean diagnoseQualifiedDeclaration(final CXXScopeSpec /*&*/ SS, DeclContext /*P*/ DC, 
                            DeclarationName Name, 
                            SourceLocation Loc) {
  DeclContext /*P*/ Cur = $this().CurContext;
  while (isa_LinkageSpecDecl(Cur) || isa_CapturedDecl(Cur)) {
    Cur = Cur.getParent();
  }
  
  // If the user provided a superfluous scope specifier that refers back to the
  // class in which the entity is already declared, diagnose and ignore it.
  //
  // class X {
  //   void X::f();
  // };
  //
  // Note, it was once ill-formed to give redundant qualification in all
  // contexts, but that rule was removed by DR482.
  if (Cur.Equals(DC)) {
    if (Cur.isRecord()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), $this().LangOpts.MicrosoftExt ? diag.warn_member_extra_qualification : diag.err_member_extra_qualification)), 
                Name), FixItHint.CreateRemoval(SS.getRange())));
        SS.clear();
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_namespace_member_extra_qualification)), Name));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  
  // Check whether the qualifying scope encloses the scope of the original
  // declaration.
  if (!Cur.Encloses(DC)) {
    if (Cur.isRecord()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_member_qualification)), 
                Name), SS.getRange()));
      } finally {
        $c$.$destroy();
      }
    } else if (isa_TranslationUnitDecl(DC)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_invalid_declarator_global_scope)), 
                Name), SS.getRange()));
      } finally {
        $c$.$destroy();
      }
    } else if (isa_FunctionDecl(Cur)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_invalid_declarator_in_function)), 
                Name), SS.getRange()));
      } finally {
        $c$.$destroy();
      }
    } else if (isa_BlockDecl(Cur)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_invalid_declarator_in_block)), 
                Name), SS.getRange()));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_invalid_declarator_scope)), 
                        Name), cast_NamedDecl(Cur)), cast_NamedDecl(DC)), SS.getRange()));
      } finally {
        $c$.$destroy();
      }
    }
    
    return true;
  }
  if (Cur.isRecord()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Cannot qualify members within a class.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_member_qualification)), 
              Name), SS.getRange()));
      SS.clear();
      
      // C++ constructors and destructors with incorrect scopes can break
      // our AST invariants by having the wrong underlying types. If
      // that's the case, then drop this declaration entirely.
      if ((Name.getNameKind() == DeclarationName.NameKind.CXXConstructorName
         || Name.getNameKind() == DeclarationName.NameKind.CXXDestructorName)
         && !$this().Context.hasSameType(Name.getCXXNameType(), 
          $this().Context.getTypeDeclType(cast_CXXRecordDecl(Cur)))) {
        return true;
      }
      
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  
  // C++11 [dcl.meaning]p1:
  //   [...] "The nested-name-specifier of the qualified declarator-id shall
  //   not begin with a decltype-specifer"
  NestedNameSpecifierLoc SpecLoc/*J*/= new NestedNameSpecifierLoc(SS.getScopeRep(), SS.location_data());
  while (SpecLoc.getPrefix().$bool()) {
    SpecLoc.$assignMove(SpecLoc.getPrefix());
  }
  if ((dyn_cast_or_null_DecltypeType(SpecLoc.getNestedNameSpecifier().getAsType()) != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_decltype_in_declarator)), 
          SpecLoc.getTypeLoc().getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}


/// Adjust the \c DeclContext for a function or variable that might be a
/// function-local external declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::adjustContextForLocalExternDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5816,
 FQN="clang::Sema::adjustContextForLocalExternDecl", NM="_ZN5clang4Sema31adjustContextForLocalExternDeclERPNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema31adjustContextForLocalExternDeclERPNS_11DeclContextE")
//</editor-fold>
public static boolean adjustContextForLocalExternDecl(final type$ref<DeclContext /*P*/ /*&*/> DC) {
  if (!DC.$deref().isFunctionOrMethod()) {
    return false;
  }
  
  // If this is a local extern function or variable declared within a function
  // template, don't add it into the enclosing namespace scope until it is
  // instantiated; it might have a dependent type right now.
  if (DC.$deref().isDependentContext()) {
    return true;
  }
  
  // C++11 [basic.link]p7:
  //   When a block scope declaration of an entity with linkage is not found to
  //   refer to some other declaration, then that entity is a member of the
  //   innermost enclosing namespace.
  //
  // Per C++11 [namespace.def]p6, the innermost enclosing namespace is a
  // semantically-enclosing namespace, not a lexically-enclosing one.
  while (!DC.$deref().isFileContext() && !isa_LinkageSpecDecl(DC)) {
    DC.$set(DC.$deref().getParent());
  }
  return true;
}


/// \brief Diagnose function specifiers on a declaration of an identifier that
/// does not identify a function.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseFunctionSpecifiers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5292,
 FQN="clang::Sema::DiagnoseFunctionSpecifiers", NM="_ZN5clang4Sema26DiagnoseFunctionSpecifiersERKNS_8DeclSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema26DiagnoseFunctionSpecifiersERKNS_8DeclSpecE")
//</editor-fold>
public final void DiagnoseFunctionSpecifiers(final /*const*/ DeclSpec /*&*/ DS) {
  // FIXME: We should probably indicate the identifier in question to avoid
  // confusion for constructs like "virtual int a(), b;"
  if (DS.isVirtualSpecified()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(DS.getVirtualSpecLoc(), 
          diag.err_virtual_non_function)));
    } finally {
      $c$.$destroy();
    }
  }
  if (DS.isExplicitSpecified()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(DS.getExplicitSpecLoc(), 
          diag.err_explicit_non_function)));
    } finally {
      $c$.$destroy();
    }
  }
  if (DS.isNoreturnSpecified()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(DS.getNoreturnSpecLoc(), 
          diag.err_noreturn_non_function)));
    } finally {
      $c$.$destroy();
    }
  }
}


/// \brief Diagnose variable or built-in function shadowing.  Implements
/// -Wshadow.
///
/// This method is called whenever a VarDecl is added to a "useful"
/// scope.
///
/// \param S the scope in which the shadowing name is being declared
/// \param R the lookup of the name
///
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckShadow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 6534,
 FQN="clang::Sema::CheckShadow", NM="_ZN5clang4Sema11CheckShadowEPNS_5ScopeEPNS_7VarDeclERKNS_12LookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema11CheckShadowEPNS_5ScopeEPNS_7VarDeclERKNS_12LookupResultE")
//</editor-fold>
public final void CheckShadow(Scope /*P*/ S, VarDecl /*P*/ D, final /*const*/ LookupResult /*&*/ R) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Return if warning is ignored.
    if ($this().Diags.isIgnored(diag.warn_decl_shadow, R.getNameLoc())) {
      return;
    }
    
    // Don't diagnose declarations at file scope.
    if (D.hasGlobalStorage()) {
      return;
    }
    
    DeclContext /*P*/ NewDC = D.getDeclContext();
    
    // Only diagnose if we're shadowing an unambiguous field or variable.
    if (R.getResultKind() != LookupResult.LookupResultKind.Found) {
      return;
    }
    
    NamedDecl /*P*/ ShadowedDecl = R.getFoundDecl();
    if (!isa_VarDecl(ShadowedDecl) && !isa_FieldDecl(ShadowedDecl)) {
      return;
    }
    {
      
      FieldDecl /*P*/ FD = dyn_cast_FieldDecl(ShadowedDecl);
      if ((FD != null)) {
        {
          // Fields are not shadowed by variables in C++ static methods.
          CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(NewDC);
          if ((MD != null)) {
            if (MD.isStatic()) {
              return;
            }
          }
        }
        
        // Fields shadowed by constructor parameters are a special case. Usually
        // the constructor initializes the field with the parameter.
        if (isa_CXXConstructorDecl(NewDC) && isa_ParmVarDecl(D)) {
          // Remember that this was shadowed so we can either warn about its
          // modification or its existence depending on warning settings.
          D = D.getCanonicalDecl();
          $this().ShadowingDecls.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrPtr</*const*/ NamedDecl /*P*/ , /*const*/ NamedDecl /*P*/ >(JD$T$RR_T1$RR.INSTANCE, D, FD)/* }*/);
          return;
        }
      }
    }
    {
      
      VarDecl /*P*/ shadowedVar = dyn_cast_VarDecl(ShadowedDecl);
      if ((shadowedVar != null)) {
        if (shadowedVar.isExternC()) {
          // For shadowing external vars, make sure that we point to the global
          // declaration, not a locally scoped extern declaration.
          for (VarDecl /*P*/ I : shadowedVar.redeclarable_redecls())  {
            if (I.isFileVarDecl()) {
              ShadowedDecl = I;
              break;
            }
          }
        }
      }
    }
    
    DeclContext /*P*/ OldDC = ShadowedDecl.getDeclContext();
    
    // Only warn about certain kinds of shadowing for class members.
    if ((NewDC != null) && NewDC.isRecord()) {
      // In particular, don't warn about shadowing non-class members.
      if (!OldDC.isRecord()) {
        return;
      }

      // TODO: should we warn about static data members shadowing
      // static data members from base classes?

      // TODO: don't diagnose for inaccessible shadowed members.
      // This is hard to do perfectly because we might friend the
      // shadowing context, but that's just a false negative.
    }
    
    DeclarationName Name = R.getLookupName();
    
    // Emit warning and note.
    if ($this().getSourceManager().isInSystemMacro(R.getNameLoc())) {
      return;
    }
    ShadowedDeclKind Kind = computeShadowedDeclKind(ShadowedDecl, OldDC);
    $c$.clean($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(R.getNameLoc(), diag.warn_decl_shadow)), Name), Kind), OldDC));
    $c$.clean($c$.track($this().Diag(ShadowedDecl.getLocation(), diag.note_previous_declaration)));
  } finally {
    $c$.$destroy();
  }
}


/// \brief Check -Wshadow without the advantage of a previous lookup.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckShadow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 6609,
 FQN="clang::Sema::CheckShadow", NM="_ZN5clang4Sema11CheckShadowEPNS_5ScopeEPNS_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema11CheckShadowEPNS_5ScopeEPNS_7VarDeclE")
//</editor-fold>
public final void CheckShadow(Scope /*P*/ S, VarDecl /*P*/ D) {
  LookupResult R = null;
  try {
    if ($this().Diags.isIgnored(diag.warn_decl_shadow, D.getLocation())) {
      return;
    }
    
    R/*J*/= new LookupResult(/*Deref*/$this(), D.getDeclName(), D.getLocation(), 
        Sema.LookupNameKind.LookupOrdinaryName, Sema.RedeclarationKind.ForRedeclaration);
    $this().LookupName(R, S);
    $this().CheckShadow(S, D, R);
  } finally {
    if (R != null) { R.$destroy(); }
  }
}


/// Warn if 'E', which is an expression that is about to be modified, refers
/// to a shadowing declaration.

/// Check if 'E', which is an expression that is about to be modified, refers
/// to a constructor parameter that shadows a field.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckShadowingDeclModification">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 6621,
 FQN="clang::Sema::CheckShadowingDeclModification", NM="_ZN5clang4Sema30CheckShadowingDeclModificationEPNS_4ExprENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema30CheckShadowingDeclModificationEPNS_4ExprENS_14SourceLocationE")
//</editor-fold>
public final void CheckShadowingDeclModification(Expr /*P*/ E, SourceLocation Loc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Quickly ignore expressions that can't be shadowing ctor parameters.
    if (!$this().getLangOpts().CPlusPlus || $this().ShadowingDecls.empty()) {
      return;
    }
    E = E.IgnoreParenImpCasts();
    DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
    if (!(DRE != null)) {
      return;
    }
    /*const*/ NamedDecl /*P*/ D = cast_NamedDecl(DRE.getDecl().getCanonicalDecl());
    DenseMapIterator</*const*/ NamedDecl /*P*/ , /*const*/ NamedDecl /*P*/ > I = $this().ShadowingDecls.find(D);
    if (I.$eq(/*NO_ITER_COPY*/$this().ShadowingDecls.end())) {
      return;
    }
    /*const*/ NamedDecl /*P*/ ShadowedDecl = I.$arrow().second;
    /*const*/ DeclContext /*P*/ OldDC = ShadowedDecl.getDeclContext$Const();
    $c$.clean($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_modifying_shadowing_decl)), D), OldDC));
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), diag.note_var_declared_here)), D));
    $c$.clean($c$.track($this().Diag(ShadowedDecl.getLocation(), diag.note_previous_declaration)));
    
    // Avoid issuing multiple warnings about the same decl.
    $this().ShadowingDecls.erase(new DenseMapIterator</*const*/ NamedDecl /*P*/ , /*const*/ NamedDecl /*P*/ >(I));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::handleTagNumbering">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 3732,
 FQN="clang::Sema::handleTagNumbering", NM="_ZN5clang4Sema18handleTagNumberingEPKNS_7TagDeclEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema18handleTagNumberingEPKNS_7TagDeclEPNS_5ScopeE")
//</editor-fold>
public final void handleTagNumbering(/*const*/ TagDecl /*P*/ Tag, Scope /*P*/ TagScope) {
  if (!$this().Context.getLangOpts().CPlusPlus) {
    return;
  }
  if (isa_CXXRecordDecl(Tag.getParent$Const())) {
    // If this tag is the direct child of a class, number it if
    // it is anonymous.
    if (!Tag.getName().empty() || (Tag.getTypedefNameForAnonDecl() != null)) {
      return;
    }
    final MangleNumberingContext /*&*/ MCtx = $this().Context.getManglingNumberContext(Tag.getParent$Const());
    $this().Context.setManglingNumber(Tag, MCtx.getManglingNumber(Tag, getMSManglingNumber($this().getLangOpts(), TagScope)));
    return;
  }
  
  // If this tag isn't a direct child of a class, number it if it is local.
  type$ref<Decl /*P*/ > ManglingContextDecl = create_type$null$ref();
  {
    MangleNumberingContext /*P*/ MCtx = $this().getCurrentMangleNumberContext(Tag.getDeclContext$Const(), ManglingContextDecl);
    if ((MCtx != null)) {
      $this().Context.setManglingNumber(Tag, MCtx.getManglingNumber(Tag, getMSManglingNumber($this().getLangOpts(), TagScope)));
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::setTagNameForLinkagePurposes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 3759,
 FQN="clang::Sema::setTagNameForLinkagePurposes", NM="_ZN5clang4Sema28setTagNameForLinkagePurposesEPNS_7TagDeclEPNS_15TypedefNameDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema28setTagNameForLinkagePurposesEPNS_7TagDeclEPNS_15TypedefNameDeclE")
//</editor-fold>
public final void setTagNameForLinkagePurposes(TagDecl /*P*/ TagFromDeclSpec, 
                            TypedefNameDecl /*P*/ NewTD) {
  if (TagFromDeclSpec.isInvalidDecl()) {
    return;
  }
  
  // Do nothing if the tag already has a name for linkage purposes.
  if (TagFromDeclSpec.hasNameForLinkage()) {
    return;
  }
  
  // A well-formed anonymous tag must always be a TUK_Definition.
  assert (TagFromDeclSpec.isThisDeclarationADefinition());
  
  // The type must match the tag exactly;  no qualifiers allowed.
  if (!$this().Context.hasSameType(NewTD.getUnderlyingType(), 
      $this().Context.getTagDeclType(TagFromDeclSpec))) {
    if ($this().getLangOpts().CPlusPlus) {
      $this().Context.addTypedefNameForUnnamedTagDecl(TagFromDeclSpec, NewTD);
    }
    return;
  }
  
  // If we've already computed linkage for the anonymous tag, then
  // adding a typedef name for the anonymous decl can change that
  // linkage, which might be a serious problem.  Diagnose this as
  // unsupported and ignore the typedef name.  TODO: we should
  // pursue this as a language defect and establish a formal rule
  // for how to handle it.
  if (TagFromDeclSpec.hasLinkageBeenComputed()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(NewTD.getLocation(), diag.err_typedef_changes_linkage)));
      
      SourceLocation tagLoc = TagFromDeclSpec.getInnerLocStart();
      tagLoc.$assignMove($this().getLocForEndOfToken(new SourceLocation(tagLoc)));
      
      SmallString/*<40>*/ textToInsert/*J*/= new SmallString/*<40>*/(40);
      textToInsert.$addassign($$SPACE);
      textToInsert.$addassign(NewTD.getIdentifier().getName());
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(tagLoc), diag.note_typedef_changes_linkage)), 
          FixItHint.CreateInsertion(/*NO_COPY*/tagLoc, textToInsert.$StringRef())));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Otherwise, set this is the anon-decl typedef for the tag.
  TagFromDeclSpec.setTypedefNameForAnonDecl(NewTD);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckTypedefForVariablyModifiedType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5353,
 FQN="clang::Sema::CheckTypedefForVariablyModifiedType", NM="_ZN5clang4Sema35CheckTypedefForVariablyModifiedTypeEPNS_5ScopeEPNS_15TypedefNameDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema35CheckTypedefForVariablyModifiedTypeEPNS_5ScopeEPNS_15TypedefNameDeclE")
//</editor-fold>
public final void CheckTypedefForVariablyModifiedType(Scope /*P*/ S, TypedefNameDecl /*P*/ NewTD) {
  // C99 6.7.7p2: If a typedef name specifies a variably modified type
  // then it shall have block scope.
  // Note that variably modified types must be fixed before merging the decl so
  // that redeclarations will match.
  TypeSourceInfo /*P*/ TInfo = NewTD.getTypeSourceInfo();
  QualType T = TInfo.getType();
  if (T.$arrow().isVariablyModifiedType()) {
    $this().getCurFunction().setHasBranchProtectedScope();
    if (S.getFnParent() == null) {
      bool$ref SizeIsNegative = create_bool$ref();
      APSInt Oversized/*J*/= new APSInt();
      TypeSourceInfo /*P*/ FixedTInfo = TryToFixInvalidVariablyModifiedTypeSourceInfo(TInfo, $this().Context, 
          SizeIsNegative, 
          Oversized);
      if ((FixedTInfo != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(NewTD.getLocation(), diag.warn_illegal_constant_array_size)));
          NewTD.setTypeSourceInfo(FixedTInfo);
        } finally {
          $c$.$destroy();
        }
      } else {
        if (SizeIsNegative.$deref()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(NewTD.getLocation(), diag.err_typecheck_negative_array_size)));
          } finally {
            $c$.$destroy();
          }
        } else if (T.$arrow().isVariableArrayType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(NewTD.getLocation(), diag.err_vla_decl_in_file_scope)));
          } finally {
            $c$.$destroy();
          }
        } else if (Oversized.getBoolValue()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewTD.getLocation(), diag.err_array_too_large)), 
                Oversized.__toString(10)));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(NewTD.getLocation(), diag.err_vm_decl_in_file_scope)));
          } finally {
            $c$.$destroy();
          }
        }
        NewTD.setInvalidDecl();
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnTypedefDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5308,
 FQN="clang::Sema::ActOnTypedefDeclarator", NM="_ZN5clang4Sema22ActOnTypedefDeclaratorEPNS_5ScopeERNS_10DeclaratorEPNS_11DeclContextEPNS_14TypeSourceInfoERNS_12LookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema22ActOnTypedefDeclaratorEPNS_5ScopeERNS_10DeclaratorEPNS_11DeclContextEPNS_14TypeSourceInfoERNS_12LookupResultE")
//</editor-fold>
public final NamedDecl /*P*/ ActOnTypedefDeclarator(Scope /*P*/ S, final Declarator /*&*/ D, DeclContext /*P*/ DC, 
                      TypeSourceInfo /*P*/ TInfo, final LookupResult /*&*/ Previous) {
  // Typedef declarators cannot be qualified (C++ [dcl.meaning]p1).
  if (D.getCXXScopeSpec().isSet()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_qualified_typedef_declarator)), 
          D.getCXXScopeSpec().getRange()));
      D.setInvalidType();
      // Pretend we didn't see the scope specifier.
      DC = $this().CurContext;
      Previous.clear();
    } finally {
      $c$.$destroy();
    }
  }
  
  $this().DiagnoseFunctionSpecifiers(D.getDeclSpec());
  if (D.getDeclSpec().isInlineSpecified()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint($c$.track($this().Diag(D.getDeclSpec().getInlineSpecLoc(), diag.err_inline_non_function)), 
          $this().getLangOpts().CPlusPlus1z));
    } finally {
      $c$.$destroy();
    }
  }
  if (D.getDeclSpec().isConstexprSpecified()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(D.getDeclSpec().getConstexprSpecLoc(), diag.err_invalid_constexpr)), 
          1));
    } finally {
      $c$.$destroy();
    }
  }
  if (D.getDeclSpec().isConceptSpecified()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(D.getDeclSpec().getConceptSpecLoc(), 
          diag.err_concept_wrong_decl_kind)));
    } finally {
      $c$.$destroy();
    }
  }
  if (D.getName().Kind != UnqualifiedId.IdKind.IK_Identifier) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(D.getName().StartLocation), diag.err_typedef_not_identifier)), 
          D.getName().getSourceRange()));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  
  TypedefDecl /*P*/ NewTD = $this().ParseTypedefDecl(S, D, TInfo.getType(), TInfo);
  if (!(NewTD != null)) {
    return null;
  }
  
  // Handle attributes prior to checking for duplicates in MergeVarDecl
  $this().ProcessDeclAttributes(S, NewTD, D);
  
  $this().CheckTypedefForVariablyModifiedType(S, NewTD);
  
  bool$ref Redeclaration = create_bool$ref(D.isRedeclaration());
  NamedDecl /*P*/ ND = $this().ActOnTypedefNameDecl(S, DC, NewTD, Previous, Redeclaration);
  D.setRedeclaration(Redeclaration.$deref());
  return ND;
}


/// ActOnTypedefNameDecl - Perform semantic checking for a declaration which
/// declares a typedef-name, either using the 'typedef' type specifier or via
/// a C++0x [dcl.typedef]p2 alias-declaration: 'using T = A;'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnTypedefNameDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5393,
 FQN="clang::Sema::ActOnTypedefNameDecl", NM="_ZN5clang4Sema20ActOnTypedefNameDeclEPNS_5ScopeEPNS_11DeclContextEPNS_15TypedefNameDeclERNS_12LookupResultERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema20ActOnTypedefNameDeclEPNS_5ScopeEPNS_11DeclContextEPNS_15TypedefNameDeclERNS_12LookupResultERb")
//</editor-fold>
public final NamedDecl /*P*/ ActOnTypedefNameDecl(Scope /*P*/ S, DeclContext /*P*/ DC, TypedefNameDecl /*P*/ NewTD, 
                    final LookupResult /*&*/ Previous, final bool$ref/*bool &*/ Redeclaration) {
  // Merge the decl with the existing one if appropriate. If the decl is
  // in an outer scope, it isn't the same thing.
  $this().FilterLookupForScope(Previous, DC, S, /*ConsiderLinkage*/ false, 
      /*AllowInlineNamespace*/ false);
  filterNonConflictingPreviousTypedefDecls(/*Deref*/$this(), NewTD, Previous);
  if (!Previous.empty()) {
    Redeclaration.$set(true);
    $this().MergeTypedefNameDecl(S, NewTD, Previous);
  }
  {
    
    // If this is the C FILE type, notify the AST context.
    IdentifierInfo /*P*/ II = NewTD.getIdentifier();
    if ((II != null)) {
      if (!NewTD.isInvalidDecl()
         && NewTD.getDeclContext().getRedeclContext().isTranslationUnit()) {
        if (II.isStr(/*KEEP_STR*/"FILE")) {
          $this().Context.setFILEDecl(NewTD);
        } else if (II.isStr(/*KEEP_STR*/"jmp_buf")) {
          $this().Context.setjmp_bufDecl(NewTD);
        } else if (II.isStr(/*KEEP_STR*/"sigjmp_buf")) {
          $this().Context.setsigjmp_bufDecl(NewTD);
        } else if (II.isStr(/*KEEP_STR*/"ucontext_t")) {
          $this().Context.setucontext_tDecl(NewTD);
        }
      }
    }
  }
  
  return NewTD;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnVariableDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5848,
 FQN="clang::Sema::ActOnVariableDeclarator", NM="_ZN5clang4Sema23ActOnVariableDeclaratorEPNS_5ScopeERNS_10DeclaratorEPNS_11DeclContextEPNS_14TypeSourceInfoERNS_12LookupResultEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema23ActOnVariableDeclaratorEPNS_5ScopeERNS_10DeclaratorEPNS_11DeclContextEPNS_14TypeSourceInfoERNS_12LookupResultEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEERb")
//</editor-fold>
public final NamedDecl /*P*/ ActOnVariableDeclarator(Scope /*P*/ S, final Declarator /*&*/ D, DeclContext /*P*/ _DC, 
                       TypeSourceInfo /*P*/ TInfo, final LookupResult /*&*/ Previous, 
                       MutableArrayRef<TemplateParameterList /*P*/ > TemplateParamLists, 
                       final bool$ref/*bool &*/ AddToScope) {
  final type$ref<DeclContext> DC = create_type$ref(_DC);
  QualType R = TInfo.getType();
  DeclarationName Name = $this().GetNameForDeclarator(D).getName();
  
  // OpenCL v2.0 s6.9.b - Image type can only be used as a function argument.
  // OpenCL v2.0 s6.13.16.1 - Pipe type can only be used as a function
  // argument.
  if ($this().getLangOpts().OpenCL && (R.$arrow().isImageType() || R.$arrow().isPipeType())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), 
              diag.err_opencl_type_can_only_be_used_as_function_parameter)), 
          R));
      D.setInvalidType();
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  
  DeclSpec.SCS SCSpec = D.getDeclSpec().getStorageClassSpec();
  StorageClass SC = StorageClassSpecToVarDeclStorageClass(D.getDeclSpec());
  
  // dllimport globals without explicit storage class are treated as extern. We
  // have to change the storage class this early to get the right DeclContext.
  if (SC == StorageClass.SC_None && !DC.$deref().isRecord()
     && hasParsedAttr(S, D, AttributeList.Kind.AT_DLLImport)
     && !hasParsedAttr(S, D, AttributeList.Kind.AT_DLLExport)) {
    SC = StorageClass.SC_Extern;
  }
  
  DeclContext /*P*/ OriginalDC = DC.$deref();
  boolean IsLocalExternDecl = SC == StorageClass.SC_Extern
     && adjustContextForLocalExternDecl(DC);
  if ($this().getLangOpts().OpenCL) {
    // OpenCL v1.0 s6.8.a.3: Pointers to functions are not allowed.
    QualType NR = new QualType(R);
    while (NR.$arrow().isPointerType()) {
      if (NR.$arrow().isFunctionPointerType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_opencl_function_pointer_variable)));
          D.setInvalidType();
          break;
        } finally {
          $c$.$destroy();
        }
      }
      NR.$assignMove(NR.$arrow().getPointeeType());
    }
    if (!$this().getOpenCLOptions().cl_khr_fp16) {
      // OpenCL v1.2 s6.1.1.1: reject declaring variables of the half and
      // half array type (unless the cl_khr_fp16 extension is enabled).
      if ($this().Context.getBaseElementType(new QualType(R)).$arrow().isHalfType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_opencl_half_declaration)), R));
          D.setInvalidType();
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  if (SCSpec == DeclSpec.SCS.SCS_mutable) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // mutable can only appear on non-static class members, so it's always
      // an error here
      $c$.clean($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_mutable_nonmember)));
      D.setInvalidType();
      SC = StorageClass.SC_None;
    } finally {
      $c$.$destroy();
    }
  }
  if ($this().getLangOpts().CPlusPlus11 && SCSpec == DeclSpec.SCS.SCS_register
     && !(D.getAsmLabel() != null) && !$this().getSourceManager().isInSystemMacro(D.getDeclSpec().getStorageClassSpecLoc())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // In C++11, the 'register' storage class specifier is deprecated.
      // Suppress the warning in system macros, it's used in macros in some
      // popular C system headers, such as in glibc's htonl() macro.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getStorageClassSpecLoc(), 
              $this().getLangOpts().CPlusPlus1z ? diag.ext_register_storage_class : diag.warn_deprecated_register)), 
          FixItHint.CreateRemoval(new SourceRange(D.getDeclSpec().getStorageClassSpecLoc()))));
    } finally {
      $c$.$destroy();
    }
  }
  
  IdentifierInfo /*P*/ II = Name.getAsIdentifierInfo();
  if (!(II != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_bad_variable_name)), 
          Name));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  
  $this().DiagnoseFunctionSpecifiers(D.getDeclSpec());
  if (!DC.$deref().isRecord() && S.getFnParent() == null) {
    // C99 6.9p2: The storage-class specifiers auto and register shall not
    // appear in the declaration specifiers in an external declaration.
    // Global Register+Asm is a GNU extension we support.
    if (SC == StorageClass.SC_Auto || (SC == StorageClass.SC_Register && !(D.getAsmLabel() != null))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_typecheck_sclass_fscope)));
        D.setInvalidType();
      } finally {
        $c$.$destroy();
      }
    }
  }
  if ($this().getLangOpts().OpenCL) {
    // OpenCL v1.2 s6.9.b p4:
    // The sampler type cannot be used with the __local and __global address
    // space qualifiers.
    if (R.$arrow().isSamplerT() && (R.getAddressSpace() == LangAS.ID.opencl_local
       || R.getAddressSpace() == LangAS.ID.opencl_global)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_wrong_sampler_addressspace)));
      } finally {
        $c$.$destroy();
      }
    }
    
    // OpenCL 1.2 spec, p6.9 r:
    // The event type cannot be used to declare a program scope variable.
    // The event type cannot be used with the __local, __constant and __global
    // address space qualifiers.
    if (R.$arrow().isEventT()) {
      if (S.getParent() == null) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(D.getLocStart(), diag.err_event_t_global_var)));
          D.setInvalidType();
        } finally {
          $c$.$destroy();
        }
      }
      if ((R.getAddressSpace() != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(D.getLocStart(), diag.err_event_t_addr_space_qual)));
          D.setInvalidType();
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  bool$ref IsExplicitSpecialization = create_bool$ref(false);
  boolean IsVariableTemplateSpecialization = false;
  boolean IsPartialSpecialization = false;
  boolean IsVariableTemplate = false;
  VarDecl /*P*/ NewVD = null;
  VarTemplateDecl /*P*/ NewTemplate = null;
  TemplateParameterList /*P*/ TemplateParams = null;
  if (!$this().getLangOpts().CPlusPlus) {
    NewVD = VarDecl.Create($this().Context, DC.$deref(), D.getLocStart(), 
        D.getIdentifierLoc(), II, 
        new QualType(R), TInfo, SC);
    if (D.getDeclSpec().containsPlaceholderType() && (R.$arrow().getContainedAutoType() != null)) {
      $this().ParsingInitForAutoVars.insert(NewVD);
    }
    if (D.isInvalidType()) {
      NewVD.setInvalidDecl();
    }
  } else {
    bool$ref Invalid = create_bool$ref(false);
    if (DC.$deref().isRecord() && !$this().CurContext.isRecord()) {
      // This is an out-of-line definition of a static data member.
      switch (SC) {
       case SC_None:
        break;
       case SC_Static:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getStorageClassSpecLoc(), 
                    diag.err_static_out_of_line)), 
                FixItHint.CreateRemoval(new SourceRange(D.getDeclSpec().getStorageClassSpecLoc()))));
            break;
          } finally {
            $c$.$destroy();
          }
        }
       case SC_Auto:
       case SC_Register:
       case SC_Extern:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // [dcl.stc] p2: The auto or register specifiers shall be applied only
            // to names of variables declared in a block or to function parameters.
            // [dcl.stc] p6: The extern specifier cannot be used in the declaration
            // of class members
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getStorageClassSpecLoc(), 
                    diag.err_storage_class_for_static_member)), 
                FixItHint.CreateRemoval(new SourceRange(D.getDeclSpec().getStorageClassSpecLoc()))));
            break;
          } finally {
            $c$.$destroy();
          }
        }
       case SC_PrivateExtern:
        throw new llvm_unreachable("C storage class in c++!");
      }
    }
    if (SC == StorageClass.SC_Static && $this().CurContext.isRecord()) {
      {
        /*const*/ CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(DC.$deref());
        if ((RD != null)) {
          if ((RD.isLocalClass$Const() != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), 
                          diag.err_static_data_member_not_allowed_in_local_class)), 
                      Name), RD.getDeclName()));
            } finally {
              $c$.$destroy();
            }
          }
          
          // C++98 [class.union]p1: If a union contains a static data member,
          // the program is ill-formed. C++11 drops this restriction.
          if (RD.isUnion()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), 
                      $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_static_data_member_in_union : diag.ext_static_data_member_in_union)), Name));
            } finally {
              $c$.$destroy();
            }
          } else // We conservatively disallow static data members in anonymous structs.
          if (!RD.getDeclName().$bool()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), 
                          diag.err_static_data_member_not_allowed_in_anon_struct)), 
                      Name), RD.isUnion()));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
    
    // Match up the template parameter lists with the scope specifier, then
    // determine whether we have a template or a template specialization.
    TemplateParams = $this().MatchTemplateParametersToScopeSpecifier(D.getDeclSpec().getLocStart(), D.getIdentifierLoc(), 
        D.getCXXScopeSpec(), 
        D.getName().getKind() == UnqualifiedId.IdKind.IK_TemplateId ? D.getName().Unnamed_field1.TemplateId : (TemplateIdAnnotation /*P*/ )null, 
        new ArrayRef<TemplateParameterList /*P*/ >(TemplateParamLists), 
        /*never a friend*/ false, IsExplicitSpecialization, Invalid);
    if ((TemplateParams != null)) {
      if (!(TemplateParams.size() != 0)
         && D.getName().getKind() != UnqualifiedId.IdKind.IK_TemplateId) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // There is an extraneous 'template<>' for this variable. Complain
          // about it, but allow the declaration of the variable.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(TemplateParams.getTemplateLoc(), 
                      diag.err_template_variable_noparams)), 
                  II), 
              new SourceRange(TemplateParams.getTemplateLoc(), 
                  TemplateParams.getRAngleLoc())));
          TemplateParams = null;
        } finally {
          $c$.$destroy();
        }
      } else {
        if (D.getName().getKind() == UnqualifiedId.IdKind.IK_TemplateId) {
          // This is an explicit specialization or a partial specialization.
          // FIXME: Check that we can declare a specialization here.
          IsVariableTemplateSpecialization = true;
          IsPartialSpecialization = $greater_uint(TemplateParams.size(), 0);
        } else { // if (TemplateParams->size() > 0)
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // This is a template declaration.
            IsVariableTemplate = true;
            
            // Check that we can declare a template here.
            if ($this().CheckTemplateDeclScope(S, TemplateParams)) {
              return null;
            }
            
            // Only C++1y supports variable templates (N3651).
            $c$.clean($c$.track($this().Diag(D.getIdentifierLoc(), 
                $this().getLangOpts().CPlusPlus14 ? diag.warn_cxx11_compat_variable_template : diag.ext_variable_template)));
          } finally {
            $c$.$destroy();
          }
        }
      }
    } else {
      assert ((Invalid.$deref() || D.getName().getKind() != UnqualifiedId.IdKind.IK_TemplateId)) : "should have a 'template<>' for this decl";
    }
    if (IsVariableTemplateSpecialization) {
      SourceLocation TemplateKWLoc = $greater_uint(TemplateParamLists.size(), 0) ? TemplateParamLists.$at(0).getTemplateLoc() : new SourceLocation();
      ActionResult<Decl /*P*/ > Res = $this().ActOnVarTemplateSpecialization(S, D, TInfo, new SourceLocation(TemplateKWLoc), TemplateParams, SC, 
          IsPartialSpecialization);
      if (Res.isInvalid()) {
        return null;
      }
      NewVD = cast_VarDecl(Res.get());
      AddToScope.$set(false);
    } else {
      NewVD = VarDecl.Create($this().Context, DC.$deref(), D.getLocStart(), 
          D.getIdentifierLoc(), II, new QualType(R), TInfo, SC);
    }
    
    // If this is supposed to be a variable template, create it as such.
    if (IsVariableTemplate) {
      NewTemplate
         = VarTemplateDecl.Create($this().Context, DC.$deref(), D.getIdentifierLoc(), new DeclarationName(Name), 
          TemplateParams, NewVD);
      NewVD.setDescribedVarTemplate(NewTemplate);
    }
    
    // If this decl has an auto type in need of deduction, make a note of the
    // Decl so we can diagnose uses of it in its own initializer.
    if (D.getDeclSpec().containsPlaceholderType() && (R.$arrow().getContainedAutoType() != null)) {
      $this().ParsingInitForAutoVars.insert(NewVD);
    }
    if (D.isInvalidType() || Invalid.$deref()) {
      NewVD.setInvalidDecl();
      if ((NewTemplate != null)) {
        NewTemplate.setInvalidDecl();
      }
    }
    
    SetNestedNameSpecifier(NewVD, D);
    
    // If we have any template parameter lists that don't directly belong to
    // the variable (matching the scope specifier), store them.
    /*uint*/int VDTemplateParamLists = (TemplateParams != null) ? 1 : 0;
    if ($greater_uint(TemplateParamLists.size(), VDTemplateParamLists)) {
      NewVD.setTemplateParameterListsInfo($this().Context, new ArrayRef<TemplateParameterList /*P*/ >(JD$Move.INSTANCE, TemplateParamLists.drop_back(VDTemplateParamLists)));
    }
    if (D.getDeclSpec().isConstexprSpecified()) {
      NewVD.setConstexpr(true);
      // C++1z [dcl.spec.constexpr]p1:
      //   A static data member declared with the constexpr specifier is
      //   implicitly an inline variable.
      if (NewVD.isStaticDataMember() && $this().getLangOpts().CPlusPlus1z) {
        NewVD.setImplicitlyInline();
      }
    }
    if (D.getDeclSpec().isConceptSpecified()) {
      {
        VarTemplateDecl /*P*/ VTD = NewVD.getDescribedVarTemplate();
        if ((VTD != null)) {
          VTD.setConcept();
        }
      }
      
      // C++ Concepts TS [dcl.spec.concept]p2: A concept definition shall not
      // be declared with the thread_local, inline, friend, or constexpr
      // specifiers, [...]
      if (D.getDeclSpec().getThreadStorageClassSpec() == ThreadStorageClassSpecifier.TSCS_thread_local) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getThreadStorageClassSpecLoc(), 
                      diag.err_concept_decl_invalid_specifiers)), 
                  0), 0));
          NewVD.setInvalidDecl(true);
        } finally {
          $c$.$destroy();
        }
      }
      if (D.getDeclSpec().isConstexprSpecified()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getConstexprSpecLoc(), 
                      diag.err_concept_decl_invalid_specifiers)), 
                  0), 3));
          NewVD.setInvalidDecl(true);
        } finally {
          $c$.$destroy();
        }
      }
      
      // C++ Concepts TS [dcl.spec.concept]p1: The concept specifier shall be
      // applied only to the definition of a function template or variable
      // template, declared in namespace scope.
      if (IsVariableTemplateSpecialization) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getConceptSpecLoc(), 
                  diag.err_concept_specified_specialization)), 
              (IsPartialSpecialization ? 2 : 1)));
        } finally {
          $c$.$destroy();
        }
      }
      
      // C++ Concepts TS [dcl.spec.concept]p6: A variable concept has the
      // following restrictions:
      // - The declared type shall have the type bool.
      if (!$this().Context.hasSameType(NewVD.getType(), $this().Context.BoolTy.$QualType())
         && !NewVD.isInvalidDecl()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_variable_concept_bool_decl)));
          NewVD.setInvalidDecl(true);
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  if (D.getDeclSpec().isInlineSpecified()) {
    if (!$this().getLangOpts().CPlusPlus) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getInlineSpecLoc(), diag.err_inline_non_function)), 
            0));
      } finally {
        $c$.$destroy();
      }
    } else if ($this().CurContext.isFunctionOrMethod()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // 'inline' is not allowed on block scope variable declaration.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getInlineSpecLoc(), 
                    diag.err_inline_declaration_block_scope)), Name), 
            FixItHint.CreateRemoval(new SourceRange(D.getDeclSpec().getInlineSpecLoc()))));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(D.getDeclSpec().getInlineSpecLoc(), 
            $this().getLangOpts().CPlusPlus1z ? diag.warn_cxx14_compat_inline_variable : diag.ext_inline_variable)));
        NewVD.setInlineSpecified();
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Set the lexical context. If the declarator has a C++ scope specifier, the
  // lexical context will be different from the semantic context.
  NewVD.setLexicalDeclContext($this().CurContext);
  if ((NewTemplate != null)) {
    NewTemplate.setLexicalDeclContext($this().CurContext);
  }
  if (IsLocalExternDecl) {
    NewVD.setLocalExternDecl();
  }
  
  boolean EmitTLSUnsupportedError = false;
  {
    ThreadStorageClassSpecifier TSCS = D.getDeclSpec().getThreadStorageClassSpec();
    if ((TSCS.getValue() != 0)) {
      // C++11 [dcl.stc]p4:
      //   When thread_local is applied to a variable of block scope the
      //   storage-class-specifier static is implied if it does not appear
      //   explicitly.
      // Core issue: 'static' is not implied if the variable is declared
      //   'extern'.
      if (NewVD.hasLocalStorage()
         && (SCSpec != DeclSpec.SCS.SCS_unspecified
         || TSCS != DeclSpec.TSCS_thread_local
         || !DC.$deref().isFunctionOrMethod())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getThreadStorageClassSpecLoc(), 
                  diag.err_thread_non_global)), 
              DeclSpec.getSpecifierName_ThreadStorageClassSpecifier(TSCS)));
        } finally {
          $c$.$destroy();
        }
      } else if (!$this().Context.getTargetInfo().isTLSSupported()) {
        if ($this().getLangOpts().CUDA) {
          // Postpone error emission until we've collected attributes required to
          // figure out whether it's a host or device variable and whether the
          // error should be ignored.
          EmitTLSUnsupportedError = true;
          // We still need to mark the variable as TLS so it shows up in AST with
          // proper storage class for other tools to use even if we're not going
          // to emit any code for it.
          NewVD.setTSCSpec(TSCS);
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(D.getDeclSpec().getThreadStorageClassSpecLoc(), 
                diag.err_thread_unsupported)));
          } finally {
            $c$.$destroy();
          }
        }
      } else {
        NewVD.setTSCSpec(TSCS);
      }
    }
  }
  
  // C99 6.7.4p3
  //   An inline definition of a function with external linkage shall
  //   not contain a definition of a modifiable object with static or
  //   thread storage duration...
  // We only apply this when the function is required to be defined
  // elsewhere, i.e. when the function is not 'extern inline'.  Note
  // that a local variable with thread storage duration still has to
  // be marked 'static'.  Also note that it's possible to get these
  // semantics in C++ using __attribute__((gnu_inline)).
  if (SC == StorageClass.SC_Static && S.getFnParent() != null
     && !NewVD.getType().isConstQualified()) {
    FunctionDecl /*P*/ CurFD = $this().getCurFunctionDecl();
    if ((CurFD != null) && isFunctionDefinitionDiscarded(/*Deref*/$this(), CurFD)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(D.getDeclSpec().getStorageClassSpecLoc(), 
            diag.warn_static_local_in_extern_inline)));
        $this().MaybeSuggestAddingStaticToDecl(CurFD);
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (D.getDeclSpec().isModulePrivateSpecified()) {
    if (IsVariableTemplateSpecialization) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewVD.getLocation(), diag.err_module_private_specialization)), 
                (IsPartialSpecialization ? 1 : 0)), 
            FixItHint.CreateRemoval(new SourceRange(D.getDeclSpec().getModulePrivateSpecLoc()))));
      } finally {
        $c$.$destroy();
      }
    } else if (IsExplicitSpecialization.$deref()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewVD.getLocation(), diag.err_module_private_specialization)), 
                2), 
            FixItHint.CreateRemoval(new SourceRange(D.getDeclSpec().getModulePrivateSpecLoc()))));
      } finally {
        $c$.$destroy();
      }
    } else if (NewVD.hasLocalStorage()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewVD.getLocation(), diag.err_module_private_local)), 
                        0), NewVD.getDeclName()), 
                new SourceRange(D.getDeclSpec().getModulePrivateSpecLoc())), 
            FixItHint.CreateRemoval(new SourceRange(D.getDeclSpec().getModulePrivateSpecLoc()))));
      } finally {
        $c$.$destroy();
      }
    } else {
      NewVD.setModulePrivate();
      if ((NewTemplate != null)) {
        NewTemplate.setModulePrivate();
      }
    }
  }
  
  // Handle attributes prior to checking for duplicates in MergeVarDecl
  $this().ProcessDeclAttributes(S, NewVD, D);
  if ($this().getLangOpts().CUDA) {
    if (EmitTLSUnsupportedError && DeclAttrsMatchCUDAMode($this().getLangOpts(), NewVD)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(D.getDeclSpec().getThreadStorageClassSpecLoc(), 
            diag.err_thread_unsupported)));
      } finally {
        $c$.$destroy();
      }
    }
    // CUDA B.2.5: "__shared__ and __constant__ variables have implied static
    // storage [duration]."
    if (SC == StorageClass.SC_None && S.getFnParent() != null
       && (NewVD.hasAttr(CUDASharedAttr.class)
       || NewVD.hasAttr(CUDAConstantAttr.class))) {
      NewVD.setStorageClass(StorageClass.SC_Static);
    }
  }
  
  // Ensure that dllimport globals without explicit storage class are treated as
  // extern. The storage class is set above using parsed attributes. Now we can
  // check the VarDecl itself.
  assert (!NewVD.hasAttr(DLLImportAttr.class) || NewVD.getAttr(DLLImportAttr.class).isInherited() || NewVD.isStaticDataMember() || NewVD.getStorageClass() != StorageClass.SC_None);
  
  // In auto-retain/release, infer strong retension for variables of
  // retainable type.
  if ($this().getLangOpts().ObjCAutoRefCount && $this().inferObjCARCLifetime(NewVD)) {
    NewVD.setInvalidDecl();
  }
  {
    
    // Handle GNU asm-label extension (encoded as an attribute).
    Expr /*P*/ E = (Expr /*P*/ )D.getAsmLabel();
    if ((E != null)) {
      // The parser guarantees this is a string.
      StringLiteral /*P*/ SE = cast_StringLiteral(E);
      StringRef Label = SE.getString();
      if (S.getFnParent() != null) {
        switch (SC) {
         case SC_None:
         case SC_Auto:
          {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.warn_asm_label_on_auto_decl)), Label));
              break;
            } finally {
              $c$.$destroy();
            }
          }
         case SC_Register:
          // Local Named register
          if (!$this().Context.getTargetInfo().isValidGCCRegisterName(new StringRef(Label))
             && DeclAttrsMatchCUDAMode($this().getLangOpts(), $this().getCurFunctionDecl())) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.err_asm_unknown_register_name)), Label));
            } finally {
              $c$.$destroy();
            }
          }
          break;
         case SC_Static:
         case SC_Extern:
         case SC_PrivateExtern:
          break;
        }
      } else if (SC == StorageClass.SC_Register) {
        // Global Named register
        if (DeclAttrsMatchCUDAMode($this().getLangOpts(), NewVD)) {
          final /*const*/ TargetInfo /*&*/ TI = $this().Context.getTargetInfo();
          bool$ref HasSizeMismatch = create_bool$ref();
          if (!TI.isValidGCCRegisterName(new StringRef(Label))) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.err_asm_unknown_register_name)), Label));
            } finally {
              $c$.$destroy();
            }
          } else if (!TI.validateGlobalRegisterVariable(new StringRef(Label), 
              $ulong2uint($this().Context.getTypeSize(new QualType(R))), 
              HasSizeMismatch)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.err_asm_invalid_global_var_reg)), Label));
            } finally {
              $c$.$destroy();
            }
          } else if (HasSizeMismatch.$deref()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.err_asm_register_size_mismatch)), Label));
            } finally {
              $c$.$destroy();
            }
          }
        }
        if (!R.$arrow().isIntegralType($this().Context) && !R.$arrow().isPointerType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(D.getLocStart(), diag.err_asm_bad_register_type)));
            NewVD.setInvalidDecl(true);
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      NewVD.addAttr(/*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
          /*::*//*new (Context)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
              return new AsmLabelAttr(new SourceRange(SE.getStrTokenLoc(0)), 
                      $this().Context, new StringRef(Label), 0);
           }));
    } else if (!$this().ExtnameUndeclaredIdentifiers.empty()) {
      DenseMapIterator<IdentifierInfo /*P*/ , AsmLabelAttr /*P*/ > I = $this().ExtnameUndeclaredIdentifiers.find(NewVD.getIdentifier());
      if (I.$noteq(/*NO_ITER_COPY*/$this().ExtnameUndeclaredIdentifiers.end())) {
        if (isDeclExternC(NewVD)) {
          NewVD.addAttr(I.$arrow().second);
          $this().ExtnameUndeclaredIdentifiers.erase(new DenseMapIterator<IdentifierInfo /*P*/ , AsmLabelAttr /*P*/ >(I));
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewVD.getLocation(), diag.warn_redefine_extname_not_applied)), 
                    /*Variable*/ 1), NewVD));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  
  // Diagnose shadowed variables before filtering for scope.
  if (D.getCXXScopeSpec().isEmpty()) {
    $this().CheckShadow(S, NewVD, Previous);
  }
  
  // Don't consider existing declarations that are in a different
  // scope and are out-of-semantic-context declarations (if the new
  // declaration has linkage).
  $this().FilterLookupForScope(Previous, OriginalDC, S, shouldConsiderLinkage(NewVD), 
      D.getCXXScopeSpec().isNotEmpty()
         || IsExplicitSpecialization.$deref()
         || IsVariableTemplateSpecialization);
  
  // Check whether the previous declaration is in the same block scope. This
  // affects whether we merge types with it, per C++11 [dcl.array]p3.
  if ($this().getLangOpts().CPlusPlus
     && NewVD.isLocalVarDecl() && NewVD.hasExternalStorage()) {
    NewVD.setPreviousDeclInSameBlockScope(Previous.isSingleResult() && !Previous.isShadowed()
           && $this().isDeclInScope(Previous.getFoundDecl(), OriginalDC, S, false));
  }
  if (!$this().getLangOpts().CPlusPlus) {
    D.setRedeclaration($this().CheckVariableDeclaration(NewVD, Previous));
  } else {
    // If this is an explicit specialization of a static data member, check it.
    if (IsExplicitSpecialization.$deref() && !NewVD.isInvalidDecl()
       && $this().CheckMemberSpecialization(NewVD, Previous)) {
      NewVD.setInvalidDecl();
    }
    
    // Merge the decl with the existing one if appropriate.
    if (!Previous.empty()) {
      if (Previous.isSingleResult()
         && isa_FieldDecl(Previous.getFoundDecl())
         && D.getCXXScopeSpec().isSet()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // The user tried to define a non-static data member
          // out-of-line (C++ [dcl.meaning]p1).
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewVD.getLocation(), diag.err_nonstatic_member_out_of_line)), 
              D.getCXXScopeSpec().getRange()));
          Previous.clear();
          NewVD.setInvalidDecl();
        } finally {
          $c$.$destroy();
        }
      }
    } else if (D.getCXXScopeSpec().isSet()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // No previous declaration in the qualifying scope.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_no_member)), 
                    Name), $this().computeDeclContext(D.getCXXScopeSpec(), true)), 
            D.getCXXScopeSpec().getRange()));
        NewVD.setInvalidDecl();
      } finally {
        $c$.$destroy();
      }
    }
    if (!IsVariableTemplateSpecialization) {
      D.setRedeclaration($this().CheckVariableDeclaration(NewVD, Previous));
    }
    
    // C++ Concepts TS [dcl.spec.concept]p7: A program shall not declare [...]
    // an explicit specialization (14.8.3) or a partial specialization of a
    // concept definition.
    if (IsVariableTemplateSpecialization
       && !D.getDeclSpec().isConceptSpecified() && !Previous.empty()
       && Previous.isSingleResult()) {
      NamedDecl /*P*/ PreviousDecl = Previous.getFoundDecl();
      {
        VarTemplateDecl /*P*/ VarTmpl = dyn_cast_VarTemplateDecl(PreviousDecl);
        if ((VarTmpl != null)) {
          if (VarTmpl.isConcept()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewVD.getLocation(), diag.err_concept_specialized)), 
                      1/*variable*/), 
                  (IsPartialSpecialization ? 2/*partially specialized*/ : 1/*explicitly specialized*/)));
              $c$.clean($c$.track($this().Diag(VarTmpl.getLocation(), diag.note_previous_declaration)));
              NewVD.setInvalidDecl();
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
    if ((NewTemplate != null)) {
      VarTemplateDecl /*P*/ PrevVarTemplate = (NewVD.getPreviousDecl$Redeclarable() != null) ? NewVD.getPreviousDecl$Redeclarable().getDescribedVarTemplate() : null;
      
      // Check the template parameter list of this declaration, possibly
      // merging in the template parameter list from the previous variable
      // template declaration.
      if ($this().CheckTemplateParameterList(TemplateParams, 
          (PrevVarTemplate != null) ? PrevVarTemplate.getTemplateParameters() : (TemplateParameterList /*P*/ )null, 
          (D.getCXXScopeSpec().isSet() && (DC.$deref() != null) && DC.$deref().isRecord()
             && DC.$deref().isDependentContext()) ? TemplateParamListContext.TPC_ClassTemplateMember : TemplateParamListContext.TPC_VarTemplate)) {
        NewVD.setInvalidDecl();
      }
      
      // If we are providing an explicit specialization of a static variable
      // template, make a note of that.
      if ((PrevVarTemplate != null)
         && (PrevVarTemplate.getInstantiatedFromMemberTemplate() != null)) {
        PrevVarTemplate.setMemberSpecialization();
      }
    }
  }
  
  $this().ProcessPragmaWeak(S, NewVD);
  
  // If this is the first declaration of an extern C variable, update
  // the map of such variables.
  if (NewVD.isFirstDecl$Redeclarable() && !NewVD.isInvalidDecl()
     && SemaDeclStatics.isIncompleteDeclExternC(/*Deref*/$this(), NewVD)) {
    $this().RegisterLocallyScopedExternCDecl(NewVD, S);
  }
  if ($this().getLangOpts().CPlusPlus && NewVD.isStaticLocal()) {
    type$ref<Decl /*P*/ > ManglingContextDecl = create_type$null$ref();
    {
      MangleNumberingContext /*P*/ MCtx = $this().getCurrentMangleNumberContext(NewVD.getDeclContext(), ManglingContextDecl);
      if ((MCtx != null)) {
        $this().Context.setManglingNumber(NewVD, MCtx.getManglingNumber(NewVD, getMSManglingNumber($this().getLangOpts(), S)));
        $this().Context.setStaticLocalNumber(NewVD, MCtx.getStaticLocalNumber(NewVD));
      }
    }
  }
  
  // Special handling of variable named 'main'.
  if (Name.isIdentifier() && Name.getAsIdentifierInfo().isStr(/*KEEP_STR*/"main")
     && NewVD.getDeclContext().getRedeclContext().isTranslationUnit()
     && !$this().getLangOpts().Freestanding && !(NewVD.getDescribedVarTemplate() != null)) {
    
    // C++ [basic.start.main]p3
    // A program that declares a variable main at global scope is ill-formed.
    if ($this().getLangOpts().CPlusPlus) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(D.getLocStart(), diag.err_main_global_variable)));
      } finally {
        $c$.$destroy();
      }
    } else 
    // In C, and external-linkage variable named main results in undefined
    // behavior.
    if (NewVD.hasExternalFormalLinkage()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(D.getLocStart(), diag.warn_main_redefined)));
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (D.isRedeclaration() && !Previous.empty()) {
    checkDLLAttributeRedeclaration(/*Deref*/$this(), dyn_cast_NamedDecl(Previous.getRepresentativeDecl()), NewVD, 
        IsExplicitSpecialization.$deref(), D.isFunctionDefinition());
  }
  if ((NewTemplate != null)) {
    if (NewVD.isInvalidDecl()) {
      NewTemplate.setInvalidDecl();
    }
    $this().ActOnDocumentableDecl(NewTemplate);
    return NewTemplate;
  }
  
  return NewVD;
}

// Returns true if the variable declaration is a redeclaration

/// \brief Perform semantic checking on a newly-created variable
/// declaration.
///
/// This routine performs all of the type-checking required for a
/// variable declaration once it has been built. It is used both to
/// check variables after they have been parsed and their declarators
/// have been translated into a declaration, and to check variables
/// that have been instantiated from a template.
///
/// Sets NewVD->isInvalidDecl() if an error was encountered.
///
/// Returns true if the variable declaration is a redeclaration.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckVariableDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 6981,
 FQN="clang::Sema::CheckVariableDeclaration", NM="_ZN5clang4Sema24CheckVariableDeclarationEPNS_7VarDeclERNS_12LookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema24CheckVariableDeclarationEPNS_7VarDeclERNS_12LookupResultE")
//</editor-fold>
public final boolean CheckVariableDeclaration(VarDecl /*P*/ NewVD, final LookupResult /*&*/ Previous) {
  $this().CheckVariableDeclarationType(NewVD);
  
  // If the decl is already known invalid, don't check it.
  if (NewVD.isInvalidDecl()) {
    return false;
  }
  
  // If we did not find anything by this name, look for a non-visible
  // extern "C" declaration with the same name.
  if (Previous.empty()
     && checkForConflictWithNonVisibleExternC(/*Deref*/$this(), NewVD, Previous)) {
    Previous.setShadowed();
  }
  if (!Previous.empty()) {
    $this().MergeVarDecl(NewVD, Previous);
    return true;
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckVariableDeclarationType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 6760,
 FQN="clang::Sema::CheckVariableDeclarationType", NM="_ZN5clang4Sema28CheckVariableDeclarationTypeEPNS_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema28CheckVariableDeclarationTypeEPNS_7VarDeclE")
//</editor-fold>
public final void CheckVariableDeclarationType(VarDecl /*P*/ NewVD) {
  // If the decl is already known invalid, don't check it.
  if (NewVD.isInvalidDecl()) {
    return;
  }
  
  TypeSourceInfo /*P*/ TInfo = NewVD.getTypeSourceInfo();
  QualType T = TInfo.getType();
  
  // Defer checking an 'auto' type until its initializer is attached.
  if (T.$arrow().isUndeducedType()) {
    return;
  }
  if (NewVD.hasAttrs()) {
    $this().CheckAlignasUnderalignment(NewVD);
  }
  if (T.$arrow().isObjCObjectType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewVD.getLocation(), diag.err_statically_allocated_object)), 
          FixItHint.CreateInsertion(NewVD.getLocation(), new StringRef(/*KEEP_STR*/$STAR))));
      T.$assignMove($this().Context.getObjCObjectPointerType(new QualType(T)));
      NewVD.setType(new QualType(T));
    } finally {
      $c$.$destroy();
    }
  }
  
  // Emit an error if an address space was applied to decl with local storage.
  // This includes arrays of objects with address space qualifiers, but not
  // automatic variables that point to other address spaces.
  // ISO/IEC TR 18037 S5.1.2
  if (!$this().getLangOpts().OpenCL
     && NewVD.hasLocalStorage() && T.getAddressSpace() != 0) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(NewVD.getLocation(), diag.err_as_qualified_auto_decl)));
      NewVD.setInvalidDecl();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // OpenCL v1.2 s6.8 - The static qualifier is valid only in program
  // scope.
  if ($this().getLangOpts().OpenCLVersion == 120
     && !$this().getOpenCLOptions().cl_clang_storage_class_specifiers
     && NewVD.isStaticLocal()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(NewVD.getLocation(), diag.err_static_function_scope)));
      NewVD.setInvalidDecl();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if ($this().getLangOpts().OpenCL) {
    // OpenCL v2.0 s6.12.5 - The __block storage type is not supported.
    if (NewVD.hasAttr(BlocksAttr.class)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(NewVD.getLocation(), diag.err_opencl_block_storage_type)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    if (T.$arrow().isBlockPointerType()) {
      // OpenCL v2.0 s6.12.5 - Any block declaration must be const qualified and
      // can't use 'extern' storage class.
      if (!T.isConstQualified()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewVD.getLocation(), diag.err_opencl_invalid_block_declaration)), 
              0/*const*/));
          NewVD.setInvalidDecl();
          return;
        } finally {
          $c$.$destroy();
        }
      }
      if (NewVD.hasExternalStorage()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(NewVD.getLocation(), diag.err_opencl_extern_block_declaration)));
          NewVD.setInvalidDecl();
          return;
        } finally {
          $c$.$destroy();
        }
      }
      // OpenCL v2.0 s6.12.5 - Blocks with variadic arguments are not supported.
      // TODO: this check is not enough as it doesn't diagnose the typedef
      /*const*/ BlockPointerType /*P*/ BlkTy = T.$arrow().getAs(BlockPointerType.class);
      /*const*/ FunctionProtoType /*P*/ FTy = BlkTy.getPointeeType().$arrow().getAs(FunctionProtoType.class);
      if ((FTy != null) && FTy.isVariadic()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewVD.getLocation(), diag.err_opencl_block_proto_variadic)), 
                  T), NewVD.getSourceRange()));
          NewVD.setInvalidDecl();
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
    // OpenCL v1.2 s6.5 - All program scope variables must be declared in the
    // __constant address space.
    // OpenCL v2.0 s6.5.1 - Variables defined at program scope and static
    // variables inside a function can also be declared in the global
    // address space.
    if (NewVD.isFileVarDecl() || NewVD.isStaticLocal()
       || NewVD.hasExternalStorage()) {
      if (!T.$arrow().isSamplerT()
         && !(T.getAddressSpace() == LangAS.ID.opencl_constant
         || (T.getAddressSpace() == LangAS.ID.opencl_global
         && $this().getLangOpts().OpenCLVersion == 200))) {
        int Scope = (NewVD.isStaticLocal() ? 1 : 0) | (NewVD.hasExternalStorage() ? 1 : 0) << 1;
        if ($this().getLangOpts().OpenCLVersion == 200) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewVD.getLocation(), diag.err_opencl_global_invalid_addr_space)), 
                    Scope), /*KEEP_STR*/"global or constant"));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewVD.getLocation(), diag.err_opencl_global_invalid_addr_space)), 
                    Scope), /*KEEP_STR*/"constant"));
          } finally {
            $c$.$destroy();
          }
        }
        NewVD.setInvalidDecl();
        return;
      }
    } else {
      if (T.getAddressSpace() == LangAS.ID.opencl_global) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewVD.getLocation(), diag.err_opencl_function_variable)), 
                  1/*is any function*/), /*KEEP_STR*/"global"));
          NewVD.setInvalidDecl();
          return;
        } finally {
          $c$.$destroy();
        }
      }
      // OpenCL v1.1 s6.5.2 and s6.5.3 no local or constant variables
      // in functions.
      if (T.getAddressSpace() == LangAS.ID.opencl_constant
         || T.getAddressSpace() == LangAS.ID.opencl_local) {
        FunctionDecl /*P*/ FD = $this().getCurFunctionDecl();
        if ((FD != null) && !FD.hasAttr(OpenCLKernelAttr.class)) {
          if (T.getAddressSpace() == LangAS.ID.opencl_constant) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewVD.getLocation(), diag.err_opencl_function_variable)), 
                      0/*non-kernel only*/), /*KEEP_STR*/"constant"));
            } finally {
              $c$.$destroy();
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewVD.getLocation(), diag.err_opencl_function_variable)), 
                      0/*non-kernel only*/), /*KEEP_STR*/"local"));
            } finally {
              $c$.$destroy();
            }
          }
          NewVD.setInvalidDecl();
          return;
        }
      }
    }
  }
  if (NewVD.hasLocalStorage() && T.isObjCGCWeak()
     && !NewVD.hasAttr(BlocksAttr.class)) {
    if ($this().getLangOpts().getGC() != LangOptions.GCMode.NonGC) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(NewVD.getLocation(), diag.warn_gc_attribute_weak_on_local)));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        assert (!$this().getLangOpts().ObjCAutoRefCount);
        $c$.clean($c$.track($this().Diag(NewVD.getLocation(), diag.warn_attribute_weak_on_local)));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  boolean isVM = T.$arrow().isVariablyModifiedType();
  if (isVM || NewVD.hasAttr(CleanupAttr.class)
     || NewVD.hasAttr(BlocksAttr.class)) {
    $this().getCurFunction().setHasBranchProtectedScope();
  }
  if ((isVM && NewVD.hasLinkage())
     || (T.$arrow().isVariableArrayType() && NewVD.hasGlobalStorage())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      bool$ref SizeIsNegative = create_bool$ref();
      APSInt Oversized/*J*/= new APSInt();
      TypeSourceInfo /*P*/ FixedTInfo = TryToFixInvalidVariablyModifiedTypeSourceInfo(TInfo, $this().Context, 
          SizeIsNegative, Oversized);
      if (!(FixedTInfo != null) && T.$arrow().isVariableArrayType()) {
        /*const*/ VariableArrayType /*P*/ VAT = $this().Context.getAsVariableArrayType(new QualType(T));
        // FIXME: This won't give the correct result for
        // int a[10][n];
        SourceRange SizeRange = VAT.getSizeExpr().getSourceRange();
        if (NewVD.isFileVarDecl()) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewVD.getLocation(), diag.err_vla_decl_in_file_scope)), 
              SizeRange));
        } else if (NewVD.isStaticLocal()) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewVD.getLocation(), diag.err_vla_decl_has_static_storage)), 
              SizeRange));
        } else {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewVD.getLocation(), diag.err_vla_decl_has_extern_linkage)), 
              SizeRange));
        }
        NewVD.setInvalidDecl();
        return;
      }
      if (!(FixedTInfo != null)) {
        if (NewVD.isFileVarDecl()) {
          $c$.clean($c$.track($this().Diag(NewVD.getLocation(), diag.err_vm_decl_in_file_scope)));
        } else {
          $c$.clean($c$.track($this().Diag(NewVD.getLocation(), diag.err_vm_decl_has_extern_linkage)));
        }
        NewVD.setInvalidDecl();
        return;
      }
      
      $c$.clean($c$.track($this().Diag(NewVD.getLocation(), diag.warn_illegal_constant_array_size)));
      NewVD.setType(FixedTInfo.getType());
      NewVD.setTypeSourceInfo(FixedTInfo);
    } finally {
      $c$.$destroy();
    }
  }
  if (T.$arrow().isVoidType()) {
    // C++98 [dcl.stc]p5: The extern specifier can be applied only to the names
    //                    of objects and functions.
    if ((NewVD.isThisDeclarationADefinition().getValue() != 0) || $this().getLangOpts().CPlusPlus) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewVD.getLocation(), diag.err_typecheck_decl_incomplete_type)), 
            T));
        NewVD.setInvalidDecl();
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (!NewVD.hasLocalStorage() && NewVD.hasAttr(BlocksAttr.class)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(NewVD.getLocation(), diag.err_block_on_nonlocal)));
      NewVD.setInvalidDecl();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (isVM && NewVD.hasAttr(BlocksAttr.class)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(NewVD.getLocation(), diag.err_block_on_vm)));
      NewVD.setInvalidDecl();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (NewVD.isConstexpr() && !T.$arrow().isDependentType()
     && $this().RequireLiteralType(NewVD.getLocation(), new QualType(T), 
      diag.err_constexpr_var_non_literal)) {
    NewVD.setInvalidDecl();
    return;
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckCompleteVariableDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 10295,
 FQN="clang::Sema::CheckCompleteVariableDeclaration", NM="_ZN5clang4Sema32CheckCompleteVariableDeclarationEPNS_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema32CheckCompleteVariableDeclarationEPNS_7VarDeclE")
//</editor-fold>
public final void CheckCompleteVariableDeclaration(VarDecl /*P*/ var) {
  if (var.isInvalidDecl()) {
    return;
  }
  if ($this().getLangOpts().OpenCL) {
    // OpenCL v2.0 s6.12.5 - Every block variable declaration must have an
    // initialiser
    if (var.getTypeSourceInfo().getType().$arrow().isBlockPointerType()
       && !var.hasInit()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(var.getLocation(), diag.err_opencl_invalid_block_declaration)), 
            1/*Init*/));
        var.setInvalidDecl();
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // In Objective-C, don't allow jumps past the implicit initialization of a
  // local retaining variable.
  if ($this().getLangOpts().ObjC1
     && var.hasLocalStorage()) {
    switch (var.getType().getObjCLifetime()) {
     case OCL_None:
     case OCL_ExplicitNone:
     case OCL_Autoreleasing:
      break;
     case OCL_Weak:
     case OCL_Strong:
      $this().getCurFunction().setHasBranchProtectedScope();
      break;
    }
  }
  
  // Warn about externally-visible variables being defined without a
  // prior declaration.  We only want to do this for global
  // declarations, but we also specifically need to avoid doing it for
  // class members because the linkage of an anonymous class can
  // change if it's later given a typedef name.
  if ((var.isThisDeclarationADefinition().getValue() != 0)
     && var.getDeclContext().getRedeclContext().isFileContext()
     && var.isExternallyVisible() && var.hasLinkage()
     && !$this().getDiagnostics().isIgnored(diag.warn_missing_variable_declarations, 
      var.getLocation())) {
    // Find a previous declaration that's not a definition.
    VarDecl /*P*/ prev = var.getPreviousDecl$Redeclarable();
    while ((prev != null) && (prev.isThisDeclarationADefinition().getValue() != 0)) {
      prev = prev.getPreviousDecl$Redeclarable();
    }
    if (!(prev != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(var.getLocation(), diag.warn_missing_variable_declarations)), var));
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (var.getTLSKind() == VarDecl.TLSKind.TLS_Static) {
    type$ptr</*const*/ Expr /*P*/ > Culprit = create_type$null$ptr();
    if ((var.getType().isDestructedType().getValue() != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // GNU C++98 edits for __thread, [basic.start.term]p3:
        //   The type of an object with thread storage duration shall not
        //   have a non-trivial destructor.
        $c$.clean($c$.track($this().Diag(var.getLocation(), diag.err_thread_nontrivial_dtor)));
        if ($this().getLangOpts().CPlusPlus11) {
          $c$.clean($c$.track($this().Diag(var.getLocation(), diag.note_use_thread_local)));
        }
      } finally {
        $c$.$destroy();
      }
    } else if ($this().getLangOpts().CPlusPlus && var.hasInit()
       && !var.getInit().isConstantInitializer($this().Context, var.getType().$arrow().isReferenceType(), $AddrOf(Culprit))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // GNU C++98 edits for __thread, [basic.start.init]p4:
        //   An object of thread storage duration shall not require dynamic
        //   initialization.
        // FIXME: Need strict checking here.
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(Culprit.$star().getExprLoc(), diag.err_thread_dynamic_init)), 
            Culprit.$star().getSourceRange()));
        if ($this().getLangOpts().CPlusPlus11) {
          $c$.clean($c$.track($this().Diag(var.getLocation(), diag.note_use_thread_local)));
        }
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Apply section attributes and pragmas to global variables.
  boolean GlobalStorage = var.hasGlobalStorage();
  if (GlobalStorage && (var.isThisDeclarationADefinition().getValue() != 0)
     && $this().ActiveTemplateInstantiations.empty()) {
    PragmaStack<StringLiteral /*P*/ > /*P*/ Stack = null;
    int SectionFlags = ASTContext.PragmaSectionFlag.PSF_Implicit | ASTContext.PragmaSectionFlag.PSF_Read;
    if (var.getType().isConstQualified()) {
      Stack = $AddrOf($this().ConstSegStack);
    } else if (!(var.getInit() != null)) {
      Stack = $AddrOf($this().BSSSegStack);
      SectionFlags |= ASTContext.PragmaSectionFlag.PSF_Write;
    } else {
      Stack = $AddrOf($this().DataSegStack);
      SectionFlags |= ASTContext.PragmaSectionFlag.PSF_Write;
    }
    if ((Stack.CurrentValue != null) && !var.hasAttr(SectionAttr.class)) {
      var.addAttr(SectionAttr.CreateImplicit($this().Context, SectionAttr.Spelling.Declspec_allocate, 
              Stack.CurrentValue.getString(), new SourceRange(/*NO_COPY*/Stack.CurrentPragmaLocation)));
    }
    {
      /*const*/ SectionAttr /*P*/ SA = var.getAttr(SectionAttr.class);
      if ((SA != null)) {
        if ($this().UnifySection(SA.getName(), SectionFlags, var)) {
          var.dropAttr(SectionAttr.class);
        }
      }
    }
    
    // Apply the init_seg attribute if this has an initializer.  If the
    // initializer turns out to not be dynamic, we'll end up ignoring this
    // attribute.
    if (($this().CurInitSeg != null) && (var.getInit() != null)) {
      var.addAttr(InitSegAttr.CreateImplicit($this().Context, $this().CurInitSeg.getString(), 
              new SourceRange(/*NO_COPY*/$this().CurInitSegLoc)));
    }
  }
  
  // All the following checks are C++ only.
  if (!$this().getLangOpts().CPlusPlus) {
    return;
  }
  
  QualType type = var.getType();
  if (type.$arrow().isDependentType()) {
    return;
  }
  
  // __block variables might require us to capture a copy-initializer.
  if (var.hasAttr(BlocksAttr.class)) {
    // It's currently invalid to ever have a __block variable with an
    // array type; should we diagnose that here?
    
    // Regardless, we don't want to ignore array nesting when
    // constructing this copy.
    if (type.$arrow().isStructureOrClassType()) {
      EnterExpressionEvaluationContext scope = null;
      try {
        scope/*J*/= new EnterExpressionEvaluationContext(/*Deref*/$this(), ExpressionEvaluationContext.PotentiallyEvaluated);
        SourceLocation poi = var.getLocation();
        Expr /*P*/ varRef = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
            return new DeclRefExpr(var, false, new QualType(type), ExprValueKind.VK_LValue, new SourceLocation(poi));
         });
        ActionResultTTrue<Expr /*P*/ > result = $this().PerformMoveOrCopyInitialization(InitializedEntity.InitializeBlock(new SourceLocation(poi), new QualType(type), false), 
            var, var.getType(), varRef, /*AllowNRVO=*/ true);
        if (!result.isInvalid()) {
          result.$assignMove($this().MaybeCreateExprWithCleanups(new ActionResultTTrue<Expr /*P*/ >(result)));
          Expr /*P*/ init = result.getAs(Expr.class);
          $this().Context.setBlockVarCopyInits(var, init);
        }
      } finally {
        if (scope != null) { scope.$destroy(); }
      }
    }
  }
  
  Expr /*P*/ Init = var.getInit();
  boolean IsGlobal = GlobalStorage && !var.isStaticLocal();
  QualType baseType = $this().Context.getBaseElementType(new QualType(type));
  if (!var.getDeclContext().isDependentContext()
     && (Init != null) && !Init.isValueDependent()) {
    if (IsGlobal && !var.isConstexpr()
       && !$this().getDiagnostics().isIgnored(diag.warn_global_constructor, 
        var.getLocation())) {
      // Warn about globals which don't have a constant initializer.  Don't
      // warn about globals with a non-trivial destructor because we already
      // warned about them.
      CXXRecordDecl /*P*/ RD = baseType.$arrow().getAsCXXRecordDecl();
      if (!((RD != null) && !RD.hasTrivialDestructor())
         && !Init.isConstantInitializer($this().Context, baseType.$arrow().isReferenceType())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(var.getLocation(), diag.warn_global_constructor)), 
              Init.getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
    }
    if (var.isConstexpr()) {
      OptionalNotes Notes = null;
      try {
        Notes/*J*/= new OptionalNotes(8);
        if (!(var.evaluateValue(Notes) != null) || !var.isInitICE()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            SourceLocation DiagLoc = var.getLocation();
            // If the note doesn't add any useful information other than a source
            // location, fold it into the primary diagnostic.
            if (Notes.size() == 1 && Notes.$at(0).second.getDiagID()
               == diag.note_invalid_subexpr_in_const_expr) {
              DiagLoc.$assign(Notes.$at(0).first);
              Notes.clear();
            }
            $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(DiagLoc), diag.err_constexpr_var_requires_const_init)), 
                    var), Init.getSourceRange()));
            for (/*uint*/int I = 0, N = Notes.size(); I != N; ++I)  {
              $c$.clean($c$.track($this().Diag(new SourceLocation(Notes.$at(I).first), Notes.$at(I).second)));
            }
          } finally {
            $c$.$destroy();
          }
        }
      } finally {
        if (Notes != null) { Notes.$destroy(); }
      }
    } else if (var.isUsableInConstantExpressions($this().Context)) {
      // Check whether the initializer of a const variable of integral or
      // enumeration type is an ICE now, since we can't tell whether it was
      // initialized by a constant expression if we check later.
      var.checkInitIsICE();
    }
  }
  {
    
    // Require the destructor.
    /*const*/ RecordType /*P*/ recordType = baseType.$arrow().getAs$RecordType();
    if ((recordType != null)) {
      $this().FinalizeVarWithDestructor(var, recordType);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFunctionDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 7660,
 FQN="clang::Sema::ActOnFunctionDeclarator", NM="_ZN5clang4Sema23ActOnFunctionDeclaratorEPNS_5ScopeERNS_10DeclaratorEPNS_11DeclContextEPNS_14TypeSourceInfoERNS_12LookupResultEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema23ActOnFunctionDeclaratorEPNS_5ScopeERNS_10DeclaratorEPNS_11DeclContextEPNS_14TypeSourceInfoERNS_12LookupResultEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEERb")
//</editor-fold>
public final NamedDecl /*P*/ ActOnFunctionDeclarator(Scope /*P*/ S, final Declarator /*&*/ D, DeclContext /*P*/ _DC, 
                       TypeSourceInfo /*P*/ TInfo, final LookupResult /*&*/ Previous, 
                       MutableArrayRef<TemplateParameterList /*P*/ > TemplateParamLists, 
                       final bool$ref/*bool &*/ AddToScope) {
  final type$ref<DeclContext> DC = create_type$ref(_DC);
  TemplateArgumentListInfo TemplateArgs = null;
  try {
    QualType R = TInfo.getType();
    assert (R.getTypePtr().isFunctionType());
    
    // TODO: consider using NameInfo for diagnostic.
    DeclarationNameInfo NameInfo = $this().GetNameForDeclarator(D);
    DeclarationName Name = NameInfo.getName();
    StorageClass SC = getFunctionStorageClass(/*Deref*/$this(), D);
    {
      
      ThreadStorageClassSpecifier TSCS = D.getDeclSpec().getThreadStorageClassSpec();
      if ((TSCS.getValue() != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getThreadStorageClassSpecLoc(), 
                  diag.err_invalid_thread)), 
              DeclSpec.getSpecifierName_ThreadStorageClassSpecifier(TSCS)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    if (D.isFirstDeclarationOfMember()) {
      $this().adjustMemberFunctionCC(R, D.isStaticMember(), D.isCtorOrDtor(), 
          D.getIdentifierLoc());
    }
    
    boolean isFriend = false;
    FunctionTemplateDecl /*P*/ FunctionTemplate = null;
    bool$ref isExplicitSpecialization = create_bool$ref(false);
    boolean isFunctionTemplateSpecialization = false;
    
    boolean isDependentClassScopeExplicitSpecialization = false;
    boolean HasExplicitTemplateArgs = false;
    TemplateArgs/*J*/= new TemplateArgumentListInfo();
    
    bool$ref isVirtualOkay = create_bool$ref(false);
    
    DeclContext /*P*/ OriginalDC = DC.$deref();
    boolean IsLocalExternDecl = adjustContextForLocalExternDecl(DC);
    
    FunctionDecl /*P*/ NewFD = CreateNewFunctionDecl(/*Deref*/$this(), D, DC.$deref(), R, TInfo, SC, 
        isVirtualOkay);
    if (!(NewFD != null)) {
      return null;
    }
    if (($this().OriginalLexicalContext != null) && $this().OriginalLexicalContext.isObjCContainer()) {
      NewFD.setTopLevelDeclInObjCContainer();
    }
    
    // Set the lexical context. If this is a function-scope declaration, or has a
    // C++ scope specifier, or is the object of a friend declaration, the lexical
    // context will be different from the semantic context.
    NewFD.setLexicalDeclContext($this().CurContext);
    if (IsLocalExternDecl) {
      NewFD.setLocalExternDecl();
    }
    if ($this().getLangOpts().CPlusPlus) {
      boolean isInline = D.getDeclSpec().isInlineSpecified();
      boolean isVirtual = D.getDeclSpec().isVirtualSpecified();
      boolean isExplicit = D.getDeclSpec().isExplicitSpecified();
      boolean isConstexpr = D.getDeclSpec().isConstexprSpecified();
      boolean isConcept = D.getDeclSpec().isConceptSpecified();
      isFriend = D.getDeclSpec().isFriendSpecified();
      if (isFriend && !isInline && D.isFunctionDefinition()) {
        // C++ [class.friend]p5
        //   A function can be defined in a friend declaration of a
        //   class . . . . Such a function is implicitly inline.
        NewFD.setImplicitlyInline();
      }
      {
        
        // If this is a method defined in an __interface, and is not a constructor
        // or an overloaded operator, then set the pure flag (isVirtual will already
        // return true).
        /*const*/ CXXRecordDecl /*P*/ Parent = dyn_cast_CXXRecordDecl(NewFD.getDeclContext());
        if ((Parent != null)) {
          if (Parent.isInterface() && cast_CXXMethodDecl(NewFD).isUserProvided()) {
            NewFD.setPure(true);
          }
          
          // C++ [class.union]p2
          //   A union can have member functions, but not virtual functions.
          if (isVirtual && Parent.isUnion()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(D.getDeclSpec().getVirtualSpecLoc(), diag.err_virtual_in_union)));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
      
      SetNestedNameSpecifier(NewFD, D);
      isExplicitSpecialization.$set(false);
      isFunctionTemplateSpecialization = false;
      if (D.isInvalidType()) {
        NewFD.setInvalidDecl();
      }
      
      // Match up the template parameter lists with the scope specifier, then
      // determine whether we have a template or a template specialization.
      bool$ref Invalid = create_bool$ref(false);
      {
        TemplateParameterList /*P*/ TemplateParams = $this().MatchTemplateParametersToScopeSpecifier(D.getDeclSpec().getLocStart(), D.getIdentifierLoc(), 
            D.getCXXScopeSpec(), 
            D.getName().getKind() == UnqualifiedId.IdKind.IK_TemplateId ? D.getName().Unnamed_field1.TemplateId : (TemplateIdAnnotation /*P*/ )null, 
            new ArrayRef<TemplateParameterList /*P*/ >(TemplateParamLists), isFriend, isExplicitSpecialization, 
            Invalid);
        if ((TemplateParams != null)) {
          if ($greater_uint(TemplateParams.size(), 0)) {
            // This is a function template
            
            // Check that we can declare a template here.
            if ($this().CheckTemplateDeclScope(S, TemplateParams)) {
              NewFD.setInvalidDecl();
            }
            
            // A destructor cannot be a template.
            if (Name.getNameKind() == DeclarationName.NameKind.CXXDestructorName) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track($this().Diag(NewFD.getLocation(), diag.err_destructor_template)));
                NewFD.setInvalidDecl();
              } finally {
                $c$.$destroy();
              }
            }
            
            // If we're adding a template to a dependent context, we may need to
            // rebuilding some of the types used within the template parameter list,
            // now that we know what the current instantiation is.
            if (DC.$deref().isDependentContext()) {
              ContextRAII SavedContext = null;
              try {
                SavedContext/*J*/= new ContextRAII(/*Deref*/$this(), DC.$deref());
                if ($this().RebuildTemplateParamsInCurrentInstantiation(TemplateParams)) {
                  Invalid.$set(true);
                }
              } finally {
                if (SavedContext != null) { SavedContext.$destroy(); }
              }
            }
            
            FunctionTemplate = FunctionTemplateDecl.Create($this().Context, DC.$deref(), 
                NewFD.getLocation(), 
                new DeclarationName(Name), TemplateParams, 
                NewFD);
            FunctionTemplate.setLexicalDeclContext($this().CurContext);
            NewFD.setDescribedFunctionTemplate(FunctionTemplate);
            
            // For source fidelity, store the other template param lists.
            if ($greater_uint(TemplateParamLists.size(), 1)) {
              NewFD.setTemplateParameterListsInfo($this().Context, 
                  new ArrayRef<TemplateParameterList /*P*/ >(JD$Move.INSTANCE, TemplateParamLists.drop_back(1)));
            }
          } else {
            // This is a function template specialization.
            isFunctionTemplateSpecialization = true;
            // For source fidelity, store all the template param lists.
            if ($greater_uint(TemplateParamLists.size(), 0)) {
              NewFD.setTemplateParameterListsInfo($this().Context, new ArrayRef<TemplateParameterList /*P*/ >(TemplateParamLists));
            }
            
            // C++0x [temp.expl.spec]p20 forbids "template<> friend void foo(int);".
            if (isFriend) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                // We want to remove the "template<>", found here.
                SourceRange RemoveRange = TemplateParams.getSourceRange();
                
                // If we remove the template<> and the name is not a
                // template-id, we're actually silently creating a problem:
                // the friend declaration will refer to an untemplated decl,
                // and clearly the user wants a template specialization.  So
                // we need to insert '<>' after the name.
                SourceLocation InsertLoc/*J*/= new SourceLocation();
                if (D.getName().getKind() != UnqualifiedId.IdKind.IK_TemplateId) {
                  InsertLoc.$assignMove(D.getName().getSourceRange().getEnd());
                  InsertLoc.$assignMove($this().getLocForEndOfToken(new SourceLocation(InsertLoc)));
                }
                
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_template_spec_decl_friend)), 
                                Name), RemoveRange), 
                        FixItHint.CreateRemoval(/*NO_COPY*/RemoveRange)), 
                    FixItHint.CreateInsertion(/*NO_COPY*/InsertLoc, new StringRef(/*KEEP_STR*/"<>"))));
              } finally {
                $c$.$destroy();
              }
            }
          }
        } else {
          // All template param lists were matched against the scope specifier:
          // this is NOT (an explicit specialization of) a template.
          if ($greater_uint(TemplateParamLists.size(), 0)) {
            // For source fidelity, store all the template param lists.
            NewFD.setTemplateParameterListsInfo($this().Context, new ArrayRef<TemplateParameterList /*P*/ >(TemplateParamLists));
          }
        }
      }
      if (Invalid.$deref()) {
        NewFD.setInvalidDecl();
        if ((FunctionTemplate != null)) {
          FunctionTemplate.setInvalidDecl();
        }
      }
      
      // C++ [dcl.fct.spec]p5:
      //   The virtual specifier shall only be used in declarations of
      //   nonstatic class member functions that appear within a
      //   member-specification of a class declaration; see 10.3.
      //
      if (isVirtual && !NewFD.isInvalidDecl()) {
        if (!isVirtualOkay.$deref()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(D.getDeclSpec().getVirtualSpecLoc(), 
                diag.err_virtual_non_function)));
          } finally {
            $c$.$destroy();
          }
        } else if (!$this().CurContext.isRecord()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // 'virtual' was specified outside of the class.
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getVirtualSpecLoc(), 
                    diag.err_virtual_out_of_class)), 
                FixItHint.CreateRemoval(new SourceRange(D.getDeclSpec().getVirtualSpecLoc()))));
          } finally {
            $c$.$destroy();
          }
        } else if ((NewFD.getDescribedFunctionTemplate() != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // C++ [temp.mem]p3:
            //  A member function template shall not be virtual.
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getVirtualSpecLoc(), 
                    diag.err_virtual_member_function_template)), 
                FixItHint.CreateRemoval(new SourceRange(D.getDeclSpec().getVirtualSpecLoc()))));
          } finally {
            $c$.$destroy();
          }
        } else {
          // Okay: Add virtual to the method.
          NewFD.setVirtualAsWritten(true);
        }
        if ($this().getLangOpts().CPlusPlus14
           && NewFD.getReturnType().$arrow().isUndeducedType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(D.getDeclSpec().getVirtualSpecLoc(), diag.err_auto_fn_virtual)));
          } finally {
            $c$.$destroy();
          }
        }
      }
      if ($this().getLangOpts().CPlusPlus14
         && (NewFD.isDependentContext()
         || (isFriend && $this().CurContext.isDependentContext()))
         && NewFD.getReturnType().$arrow().isUndeducedType()) {
        // If the function template is referenced directly (for instance, as a
        // member of the current instantiation), pretend it has a dependent type.
        // This is not really justified by the standard, but is the only sane
        // thing to do.
        // FIXME: For a friend function, we have not marked the function as being
        // a friend yet, so 'isDependentContext' on the FD doesn't work.
        /*const*/ FunctionProtoType /*P*/ FPT = NewFD.getType().$arrow().castAs(FunctionProtoType.class);
        QualType Result = $this().SubstAutoType(FPT.getReturnType(), $this().Context.DependentTy.$QualType());
        NewFD.setType($this().Context.getFunctionType(new QualType(Result), FPT.getParamTypes(), 
                FPT.getExtProtoInfo()));
      }
      
      // C++ [dcl.fct.spec]p3:
      //  The inline specifier shall not appear on a block scope function
      //  declaration.
      if (isInline && !NewFD.isInvalidDecl()) {
        if ($this().CurContext.isFunctionOrMethod()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // 'inline' is not allowed on block scope function declaration.
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getInlineSpecLoc(), 
                        diag.err_inline_declaration_block_scope)), Name), 
                FixItHint.CreateRemoval(new SourceRange(D.getDeclSpec().getInlineSpecLoc()))));
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      // C++ [dcl.fct.spec]p6:
      //  The explicit specifier shall be used only in the declaration of a
      //  constructor or conversion function within its class definition;
      //  see 12.3.1 and 12.3.2.
      if (isExplicit && !NewFD.isInvalidDecl()) {
        if (!$this().CurContext.isRecord()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // 'explicit' was specified outside of the class.
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getExplicitSpecLoc(), 
                    diag.err_explicit_out_of_class)), 
                FixItHint.CreateRemoval(new SourceRange(D.getDeclSpec().getExplicitSpecLoc()))));
          } finally {
            $c$.$destroy();
          }
        } else if (!isa_CXXConstructorDecl(NewFD)
           && !isa_CXXConversionDecl(NewFD)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // 'explicit' was specified on a function that wasn't a constructor
            // or conversion function.
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getExplicitSpecLoc(), 
                    diag.err_explicit_non_ctor_or_conv_function)), 
                FixItHint.CreateRemoval(new SourceRange(D.getDeclSpec().getExplicitSpecLoc()))));
          } finally {
            $c$.$destroy();
          }
        }
      }
      if (isConstexpr) {
        // C++11 [dcl.constexpr]p2: constexpr functions and constexpr constructors
        // are implicitly inline.
        NewFD.setImplicitlyInline();
        
        // C++11 [dcl.constexpr]p3: functions declared constexpr are required to
        // be either constructors or to return a literal type. Therefore,
        // destructors cannot be declared constexpr.
        if (isa_CXXDestructorDecl(NewFD)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(D.getDeclSpec().getConstexprSpecLoc(), diag.err_constexpr_dtor)));
          } finally {
            $c$.$destroy();
          }
        }
      }
      if (isConcept) {
        {
          // This is a function concept.
          FunctionTemplateDecl /*P*/ FTD = NewFD.getDescribedFunctionTemplate();
          if ((FTD != null)) {
            FTD.setConcept();
          }
        }
        
        // C++ Concepts TS [dcl.spec.concept]p1: The concept specifier shall be
        // applied only to the definition of a function template [...]
        if (!D.isFunctionDefinition()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(D.getDeclSpec().getConceptSpecLoc(), 
                diag.err_function_concept_not_defined)));
            NewFD.setInvalidDecl();
          } finally {
            $c$.$destroy();
          }
        }
        {
          
          // C++ Concepts TS [dcl.spec.concept]p1: [...] A function concept shall
          // have no exception-specification and is treated as if it were specified
          // with noexcept(true) (15.4). [...]
          /*const*/ FunctionProtoType /*P*/ FPT = R.$arrow().getAs(FunctionProtoType.class);
          if ((FPT != null)) {
            if (FPT.hasExceptionSpec()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                SourceRange Range/*J*/= new SourceRange();
                if (D.isFunctionDeclarator()) {
                  Range.$assignMove(D.getFunctionTypeInfo().getExceptionSpecRange());
                }
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewFD.getLocation(), diag.err_function_concept_exception_spec)), 
                    FixItHint.CreateRemoval(/*NO_COPY*/Range)));
                NewFD.setInvalidDecl();
              } finally {
                $c$.$destroy();
              }
            } else {
              $this().Context.adjustExceptionSpec(NewFD, new FunctionProtoType.ExceptionSpecInfo(ExceptionSpecificationType.EST_BasicNoexcept));
            }
            
            // C++ Concepts TS [dcl.spec.concept]p5: A function concept has the
            // following restrictions:
            // - The declared return type shall have the type bool.
            if (!$this().Context.hasSameType(FPT.getReturnType(), $this().Context.BoolTy.$QualType())) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_function_concept_bool_ret)));
                NewFD.setInvalidDecl();
              } finally {
                $c$.$destroy();
              }
            }
            
            // C++ Concepts TS [dcl.spec.concept]p5: A function concept has the
            // following restrictions:
            // - The declaration's parameter list shall be equivalent to an empty
            //   parameter list.
            if ($greater_uint(FPT.getNumParams(), 0) || FPT.isVariadic()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track($this().Diag(NewFD.getLocation(), diag.err_function_concept_with_params)));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
        
        // C++ Concepts TS [dcl.spec.concept]p2: Every concept definition is
        // implicity defined to be a constexpr declaration (implicitly inline)
        NewFD.setImplicitlyInline();
        
        // C++ Concepts TS [dcl.spec.concept]p2: A concept definition shall not
        // be declared with the thread_local, inline, friend, or constexpr
        // specifiers, [...]
        if (isInline) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getInlineSpecLoc(), 
                        diag.err_concept_decl_invalid_specifiers)), 
                    1), 1));
            NewFD.setInvalidDecl(true);
          } finally {
            $c$.$destroy();
          }
        }
        if (isFriend) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getFriendSpecLoc(), 
                        diag.err_concept_decl_invalid_specifiers)), 
                    1), 2));
            NewFD.setInvalidDecl(true);
          } finally {
            $c$.$destroy();
          }
        }
        if (isConstexpr) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getConstexprSpecLoc(), 
                        diag.err_concept_decl_invalid_specifiers)), 
                    1), 3));
            NewFD.setInvalidDecl(true);
          } finally {
            $c$.$destroy();
          }
        }
        
        // C++ Concepts TS [dcl.spec.concept]p1: The concept specifier shall be
        // applied only to the definition of a function template or variable
        // template, declared in namespace scope.
        if (isFunctionTemplateSpecialization) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getConceptSpecLoc(), 
                    diag.err_concept_specified_specialization)), 1));
            NewFD.setInvalidDecl(true);
            return NewFD;
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      // If __module_private__ was specified, mark the function accordingly.
      if (D.getDeclSpec().isModulePrivateSpecified()) {
        if (isFunctionTemplateSpecialization) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            SourceLocation ModulePrivateLoc = D.getDeclSpec().getModulePrivateSpecLoc();
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ModulePrivateLoc), diag.err_module_private_specialization)), 
                    0), 
                FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/ModulePrivateLoc))));
          } finally {
            $c$.$destroy();
          }
        } else {
          NewFD.setModulePrivate();
          if ((FunctionTemplate != null)) {
            FunctionTemplate.setModulePrivate();
          }
        }
      }
      if (isFriend) {
        if ((FunctionTemplate != null)) {
          FunctionTemplate.setObjectOfFriendDecl();
          FunctionTemplate.setAccess(AccessSpecifier.AS_public);
        }
        NewFD.setObjectOfFriendDecl();
        NewFD.setAccess(AccessSpecifier.AS_public);
      }
      
      // If a function is defined as defaulted or deleted, mark it as such now.
      // FIXME: Does this ever happen? ActOnStartOfFunctionDef forces the function
      // definition kind to FDK_Definition.
      switch (D.getFunctionDefinitionKind()) {
       case FDK_Declaration:
       case FDK_Definition:
        break;
       case FDK_Defaulted:
        NewFD.setDefaulted();
        break;
       case FDK_Deleted:
        NewFD.setDeletedAsWritten();
        break;
      }
      if (isa_CXXMethodDecl(NewFD) && DC.$deref() == $this().CurContext
         && D.isFunctionDefinition()) {
        // C++ [class.mfct]p2:
        //   A member function may be defined (8.4) in its class definition, in
        //   which case it is an inline member function (7.1.2)
        NewFD.setImplicitlyInline();
      }
      if (SC == StorageClass.SC_Static && isa_CXXMethodDecl(NewFD)
         && !$this().CurContext.isRecord()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C++ [class.static]p1:
          //   A data or function member of a class may be declared static
          //   in a class definition, in which case it is a static member of
          //   the class.
          
          // Complain about the 'static' specifier if it's on an out-of-line
          // member function definition.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getStorageClassSpecLoc(), 
                  diag.err_static_out_of_line)), 
              FixItHint.CreateRemoval(new SourceRange(D.getDeclSpec().getStorageClassSpecLoc()))));
        } finally {
          $c$.$destroy();
        }
      }
      
      // C++11 [except.spec]p15:
      //   A deallocation function with no exception-specification is treated
      //   as if it were specified with noexcept(true).
      /*const*/ FunctionProtoType /*P*/ FPT = R.$arrow().getAs(FunctionProtoType.class);
      if ((Name.getCXXOverloadedOperator() == OverloadedOperatorKind.OO_Delete
         || Name.getCXXOverloadedOperator() == OverloadedOperatorKind.OO_Array_Delete)
         && $this().getLangOpts().CPlusPlus11 && (FPT != null) && !FPT.hasExceptionSpec()) {
        NewFD.setType($this().Context.getFunctionType(FPT.getReturnType(), FPT.getParamTypes(), 
                FPT.getExtProtoInfo().withExceptionSpec(new ExceptionSpecInfo(ExceptionSpecificationType.EST_BasicNoexcept))));
      }
    }
    
    // Filter out previous declarations that don't match the scope.
    $this().FilterLookupForScope(Previous, OriginalDC, S, shouldConsiderLinkage(NewFD), 
        D.getCXXScopeSpec().isNotEmpty()
           || isExplicitSpecialization.$deref()
           || isFunctionTemplateSpecialization);
    {
      
      // Handle GNU asm-label extension (encoded as an attribute).
      Expr /*P*/ E = (Expr /*P*/ )D.getAsmLabel();
      if ((E != null)) {
        // The parser guarantees this is a string.
        StringLiteral /*P*/ SE = cast_StringLiteral(E);
        NewFD.addAttr(/*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
            /*::*//*new (Context)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
                return new AsmLabelAttr(new SourceRange(SE.getStrTokenLoc(0)), $this().Context, 
                        SE.getString(), 0);
             }));
      } else if (!$this().ExtnameUndeclaredIdentifiers.empty()) {
        DenseMapIterator<IdentifierInfo /*P*/ , AsmLabelAttr /*P*/ > I = $this().ExtnameUndeclaredIdentifiers.find(NewFD.getIdentifier());
        if (I.$noteq(/*NO_ITER_COPY*/$this().ExtnameUndeclaredIdentifiers.end())) {
          if (SemaDeclStatics.isDeclExternC(NewFD)) {
            NewFD.addAttr(I.$arrow().second);
            $this().ExtnameUndeclaredIdentifiers.erase(new DenseMapIterator<IdentifierInfo /*P*/ , AsmLabelAttr /*P*/ >(I));
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_NamedDecl(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(NewFD.getLocation(), diag.warn_redefine_extname_not_applied)), 
                      /*Variable*/ 0), NewFD));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
    
    // Copy the parameter declarations from the declarator D to the function
    // declaration NewFD, if they are available.  First scavenge them into Params.
    SmallVector<ParmVarDecl /*P*/ > Params/*J*/= new SmallVector<ParmVarDecl /*P*/ >(16, (ParmVarDecl /*P*/ )null);
    if (D.isFunctionDeclarator()) {
      final DeclaratorChunk.FunctionTypeInfo /*&*/ FTI = D.getFunctionTypeInfo();
      
      // Check for C99 6.7.5.3p10 - foo(void) is a non-varargs
      // function that takes no arguments, not a function that takes a
      // single void argument.
      // We let through "const void" here because Sema::GetTypeForDeclarator
      // already checks for that case.
      if (FTIHasNonVoidParameters(FTI) && (FTI.Params.$at(0).Param != null)) {
        for (/*uint*/int i = 0, e = FTI.NumParams; i != e; ++i) {
          ParmVarDecl /*P*/ Param = cast_ParmVarDecl(FTI.Params.$at(i).Param);
          assert (Param.getDeclContext() != NewFD) : "Was set before ?";
          Param.setDeclContext(NewFD);
          Params.push_back(Param);
          if (Param.isInvalidDecl()) {
            NewFD.setInvalidDecl();
          }
        }
      }
    } else {
      /*const*/ FunctionProtoType /*P*/ FT = R.$arrow().getAs(FunctionProtoType.class);
      if ((FT != null)) {
        // When we're declaring a function with a typedef, typeof, etc as in the
        // following example, we'll need to synthesize (unnamed)
        // parameters for use in the declaration.
        //
        // @code
        // typedef void fn(int);
        // fn f;
        // @endcode
        
        // Synthesize a parameter for each argument type.
        for (final /*const*/ QualType /*&*/ AI : FT.param_types()) {
          ParmVarDecl /*P*/ Param = $this().BuildParmVarDeclForTypedef(NewFD, D.getIdentifierLoc(), new QualType(AI));
          Param.setScopeInfo(0, Params.size());
          Params.push_back(Param);
        }
      } else {
        assert (R.$arrow().isFunctionNoProtoType() && NewFD.getNumParams() == 0) : "Should not need args for typedef of non-prototype fn";
      }
    }
    
    // Finally, we know we have the right number of parameters, install them.
    NewFD.setParams(new ArrayRef<ParmVarDecl /*P*/ >(Params, true));
    
    // Find all anonymous symbols defined during the declaration of this function
    // and add to NewFD. This lets us track decls such 'enum Y' in:
    //
    //   void f(enum Y {AA} x) {}
    //
    // which would otherwise incorrectly end up in the translation unit scope.
    NewFD.setDeclsInPrototypeScope(new ArrayRef<NamedDecl /*P*/ >($this().DeclsInPrototypeScope, true));
    $this().DeclsInPrototypeScope.clear();
    if (D.getDeclSpec().isNoreturnSpecified()) {
      NewFD.addAttr(/*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
          /*::*//*new (Context)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
              return new C11NoReturnAttr(new SourceRange(D.getDeclSpec().getNoreturnSpecLoc()), 
                      $this().Context, 0);
           }));
    }
    
    // Functions returning a variably modified type violate C99 6.7.5.2p2
    // because all functions have linkage.
    if (!NewFD.isInvalidDecl()
       && NewFD.getReturnType().$arrow().isVariablyModifiedType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(NewFD.getLocation(), diag.err_vm_func_decl)));
        NewFD.setInvalidDecl();
      } finally {
        $c$.$destroy();
      }
    }
    
    // Apply an implicit SectionAttr if #pragma code_seg is active.
    if (($this().CodeSegStack.CurrentValue != null) && D.isFunctionDefinition()
       && !NewFD.hasAttr(SectionAttr.class)) {
      NewFD.addAttr(SectionAttr.CreateImplicit($this().Context, SectionAttr.Spelling.Declspec_allocate, 
              $this().CodeSegStack.CurrentValue.getString(), 
              new SourceRange(/*NO_COPY*/$this().CodeSegStack.CurrentPragmaLocation)));
      if ($this().UnifySection($this().CodeSegStack.CurrentValue.getString(), 
          ASTContext.PragmaSectionFlag.PSF_Implicit | ASTContext.PragmaSectionFlag.PSF_Execute
             | ASTContext.PragmaSectionFlag.PSF_Read, 
          NewFD)) {
        NewFD.dropAttr(SectionAttr.class);
      }
    }
    
    // Handle attributes.
    $this().ProcessDeclAttributes(S, NewFD, D);
    if ($this().getLangOpts().CUDA) {
      $this().maybeAddCUDAHostDeviceAttrs(S, NewFD, Previous);
    }
    if ($this().getLangOpts().OpenCL) {
      // OpenCL v1.1 s6.5: Using an address space qualifier in a function return
      // type declaration will generate a compilation error.
      /*uint*/int AddressSpace = NewFD.getReturnType().getAddressSpace();
      if (AddressSpace == LangAS.ID.opencl_local
         || AddressSpace == LangAS.ID.opencl_global
         || AddressSpace == LangAS.ID.opencl_constant) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(NewFD.getLocation(), 
              diag.err_opencl_return_value_with_address_space)));
          NewFD.setInvalidDecl();
        } finally {
          $c$.$destroy();
        }
      }
    }
    if (!$this().getLangOpts().CPlusPlus) {
      // Perform semantic checking on the function declaration.
      boolean isExplicitSpecialization$1 = false;
      if (!NewFD.isInvalidDecl() && NewFD.isMain()) {
        $this().CheckMain(NewFD, D.getDeclSpec());
      }
      if (!NewFD.isInvalidDecl() && NewFD.isMSVCRTEntryPoint()) {
        $this().CheckMSVCRTEntryPoint(NewFD);
      }
      if (!NewFD.isInvalidDecl()) {
        D.setRedeclaration($this().CheckFunctionDeclaration(S, NewFD, Previous, 
                isExplicitSpecialization$1));
      } else if (!Previous.empty()) {
        // Recover gracefully from an invalid redeclaration.
        D.setRedeclaration(true);
      }
      assert ((NewFD.isInvalidDecl() || !D.isRedeclaration() || Previous.getResultKind() != LookupResult.LookupResultKind.FoundOverloaded)) : "previous declaration set still overloaded";
      
      // Diagnose no-prototype function declarations with calling conventions that
      // don't support variadic calls. Only do this in C and do it after merging
      // possibly prototyped redeclarations.
      /*const*/ FunctionType /*P*/ FT = NewFD.getType().$arrow().castAs(FunctionType.class);
      if (isa_FunctionNoProtoType(FT) && !D.isFunctionDefinition()) {
        CallingConv CC = FT.getExtInfo().getCC();
        if (!supportsVariadicCall(CC)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Windows system headers sometimes accidentally use stdcall without
            // (void) parameters, so we relax this to a warning.
            int DiagID = CC == CallingConv.CC_X86StdCall ? diag.warn_cconv_knr : diag.err_cconv_knr;
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewFD.getLocation(), DiagID)), 
                FunctionType.getNameForCallConv(CC)));
          } finally {
            $c$.$destroy();
          }
        }
      }
    } else {
      // C++11 [replacement.functions]p3:
      //  The program's definitions shall not be specified as inline.
      //
      // N.B. We diagnose declarations instead of definitions per LWG issue 2340.
      //
      // Suppress the diagnostic if the function is __attribute__((used)), since
      // that forces an external definition to be emitted.
      if (D.getDeclSpec().isInlineSpecified()
         && NewFD.isReplaceableGlobalAllocationFunction()
         && !NewFD.hasAttr(UsedAttr.class)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getInlineSpecLoc(), 
                  diag.ext_operator_new_delete_declared_inline)), 
              NewFD.getDeclName()));
        } finally {
          $c$.$destroy();
        }
      }
      
      // If the declarator is a template-id, translate the parser's template
      // argument list into our AST format.
      if (D.getName().getKind() == UnqualifiedId.IdKind.IK_TemplateId) {
        TemplateIdAnnotation /*P*/ TemplateId = D.getName().Unnamed_field1.TemplateId;
        TemplateArgs.setLAngleLoc(new SourceLocation(TemplateId.LAngleLoc));
        TemplateArgs.setRAngleLoc(new SourceLocation(TemplateId.RAngleLoc));
        MutableArrayRef<ParsedTemplateArgument> TemplateArgsPtr/*J*/= new MutableArrayRef<ParsedTemplateArgument>(TemplateId.getTemplateArgs(), 
            TemplateId.NumArgs, false);
        $this().translateTemplateArguments(TemplateArgsPtr, 
            TemplateArgs);
        
        HasExplicitTemplateArgs = true;
        if (NewFD.isInvalidDecl()) {
          HasExplicitTemplateArgs = false;
        } else if ((FunctionTemplate != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Function template with explicit template arguments.
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_function_template_partial_spec)), 
                new SourceRange(/*NO_COPY*/TemplateId.LAngleLoc, /*NO_COPY*/TemplateId.RAngleLoc)));
            
            HasExplicitTemplateArgs = false;
          } finally {
            $c$.$destroy();
          }
        } else {
          assert ((isFunctionTemplateSpecialization || D.getDeclSpec().isFriendSpecified())) : "should have a 'template<>' for this decl";
          // "friend void foo<>(int);" is an implicit specialization decl.
          isFunctionTemplateSpecialization = true;
        }
      } else if (isFriend && isFunctionTemplateSpecialization) {
        // This combination is only possible in a recovery case;  the user
        // wrote something like:
        //   template <> friend void foo(int);
        // which we're recovering from as if the user had written:
        //   friend void foo<>(int);
        // Go ahead and fake up a template id.
        HasExplicitTemplateArgs = true;
        TemplateArgs.setLAngleLoc(D.getIdentifierLoc());
        TemplateArgs.setRAngleLoc(D.getIdentifierLoc());
      }
      
      // If it's a friend (and only if it's a friend), it's possible
      // that either the specialized function type or the specialized
      // template is dependent, and therefore matching will fail.  In
      // this case, don't check the specialization yet.
      bool$ref InstantiationDependent = create_bool$ref(false);
      if (isFunctionTemplateSpecialization && isFriend
         && (NewFD.getType().$arrow().isDependentType() || DC.$deref().isDependentContext()
         || TemplateSpecializationType.anyDependentTemplateArguments(TemplateArgs, 
          InstantiationDependent))) {
        assert (HasExplicitTemplateArgs) : "friend function specialization without template args";
        if ($this().CheckDependentFunctionTemplateSpecialization(NewFD, TemplateArgs, 
            Previous)) {
          NewFD.setInvalidDecl();
        }
      } else if (isFunctionTemplateSpecialization) {
        if ($this().CurContext.isDependentContext() && $this().CurContext.isRecord()
           && !isFriend) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            isDependentClassScopeExplicitSpecialization = true;
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewFD.getLocation(), $this().getLangOpts().MicrosoftExt ? diag.ext_function_specialization_in_class : diag.err_function_specialization_in_class)), 
                NewFD.getDeclName()));
          } finally {
            $c$.$destroy();
          }
        } else if ($this().CheckFunctionTemplateSpecialization(NewFD, 
            (HasExplicitTemplateArgs ? $AddrOf(TemplateArgs) : (TemplateArgumentListInfo /*P*/ )null), 
            Previous)) {
          NewFD.setInvalidDecl();
        }
        
        // C++ [dcl.stc]p1:
        //   A storage-class-specifier shall not be specified in an explicit
        //   specialization (14.7.3)
        FunctionTemplateSpecializationInfo /*P*/ Info = NewFD.getTemplateSpecializationInfo();
        if ((Info != null) && SC != StorageClass.SC_None) {
          if (SC != Info.getTemplate().getTemplatedDecl().getStorageClass()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewFD.getLocation(), 
                          diag.err_explicit_specialization_inconsistent_storage_class)), 
                      SC), 
                  FixItHint.CreateRemoval(new SourceRange(D.getDeclSpec().getStorageClassSpecLoc()))));
            } finally {
              $c$.$destroy();
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewFD.getLocation(), 
                      diag.ext_explicit_specialization_storage_class)), 
                  FixItHint.CreateRemoval(new SourceRange(D.getDeclSpec().getStorageClassSpecLoc()))));
            } finally {
              $c$.$destroy();
            }
          }
        }
      } else if (isExplicitSpecialization.$deref() && isa_CXXMethodDecl(NewFD)) {
        if ($this().CheckMemberSpecialization(NewFD, Previous)) {
          NewFD.setInvalidDecl();
        }
      }
      
      // Perform semantic checking on the function declaration.
      if (!isDependentClassScopeExplicitSpecialization) {
        if (!NewFD.isInvalidDecl() && NewFD.isMain()) {
          $this().CheckMain(NewFD, D.getDeclSpec());
        }
        if (!NewFD.isInvalidDecl() && NewFD.isMSVCRTEntryPoint()) {
          $this().CheckMSVCRTEntryPoint(NewFD);
        }
        if (!NewFD.isInvalidDecl()) {
          D.setRedeclaration($this().CheckFunctionDeclaration(S, NewFD, Previous, 
                  isExplicitSpecialization.$deref()));
        } else if (!Previous.empty()) {
          // Recover gracefully from an invalid redeclaration.
          D.setRedeclaration(true);
        }
      }
      assert ((NewFD.isInvalidDecl() || !D.isRedeclaration() || Previous.getResultKind() != LookupResult.LookupResultKind.FoundOverloaded)) : "previous declaration set still overloaded";
      
      NamedDecl /*P*/ PrincipalDecl = ((FunctionTemplate != null) ? cast_NamedDecl(FunctionTemplate) : NewFD);
      if (isFriend && D.isRedeclaration()) {
        AccessSpecifier Access = AccessSpecifier.AS_public;
        if (!NewFD.isInvalidDecl()) {
          Access = NewFD.getPreviousDecl().getAccess();
        }
        
        NewFD.setAccess(Access);
        if ((FunctionTemplate != null)) {
          FunctionTemplate.setAccess(Access);
        }
      }
      if (NewFD.isOverloadedOperator() && !DC.$deref().isRecord()
         && PrincipalDecl.isInIdentifierNamespace(Decl.IdentifierNamespace.IDNS_Ordinary)) {
        PrincipalDecl.setNonMemberOperator();
      }
      
      // If we have a function template, check the template parameter
      // list. This will check and merge default template arguments.
      if ((FunctionTemplate != null)) {
        FunctionTemplateDecl /*P*/ PrevTemplate = FunctionTemplate.getPreviousDecl();
        $this().CheckTemplateParameterList(FunctionTemplate.getTemplateParameters(), 
            (PrevTemplate != null) ? PrevTemplate.getTemplateParameters() : (TemplateParameterList /*P*/ )null, 
            D.getDeclSpec().isFriendSpecified() ? (D.isFunctionDefinition() ? TemplateParamListContext.TPC_FriendFunctionTemplateDefinition : TemplateParamListContext.TPC_FriendFunctionTemplate) : (D.getCXXScopeSpec().isSet()
               && (DC.$deref() != null) && DC.$deref().isRecord()
               && DC.$deref().isDependentContext()) ? TemplateParamListContext.TPC_ClassTemplateMember : TemplateParamListContext.TPC_FunctionTemplate);
      }
      if (NewFD.isInvalidDecl()) {
        // Ignore all the rest of this.
      } else if (!D.isRedeclaration()) {
         ActOnFDArgs ExtraArgs = new  ActOnFDArgs(
          S, D, TemplateParamLists, 
          AddToScope.$deref());
        // Fake up an access specifier if it's supposed to be a class member.
        if (isa_CXXRecordDecl(NewFD.getDeclContext())) {
          NewFD.setAccess(AccessSpecifier.AS_public);
        }
        
        // Qualified decls generally require a previous declaration.
        if (D.getCXXScopeSpec().isSet()) {
          // ...with the major exception of templated-scope or
          // dependent-scope friend declarations.
          
          // TODO: we currently also suppress this check in dependent
          // contexts because (1) the parameter depth will be off when
          // matching friend templates and (2) we might actually be
          // selecting a friend based on a dependent factor.  But there
          // are situations where these conditions don't apply and we
          // can actually do this check immediately.
          if (isFriend
             && ((TemplateParamLists.size() != 0)
             || D.getCXXScopeSpec().getScopeRep().isDependent()
             || $this().CurContext.isDependentContext())) {
            // ignore these
          } else {
            {
              // The user tried to provide an out-of-line definition for a
              // function that is a member of a class or namespace, but there
              // was no such member function declared (C++ [class.mfct]p2,
              // C++ [namespace.memdef]p2). For example:
              //
              // class X {
              //   void f() const;
              // };
              //
              // void X::f() { } // ill-formed
              //
              // Complain about this problem, and attempt to suggest close
              // matches (e.g., those that differ only in cv-qualifiers and
              // whether the parameter types are references).
              NamedDecl /*P*/ Result = DiagnoseInvalidRedeclaration(/*Deref*/$this(), Previous, NewFD, ExtraArgs, false, (Scope /*P*/ )null);
              if ((Result != null)) {
                AddToScope.$set(ExtraArgs.AddToScope);
                return Result;
              }
            }
          }
          // Unqualified local friend declarations are required to resolve
          // to something.
        } else if (isFriend && (cast_CXXRecordDecl($this().CurContext).isLocalClass() != null)) {
          {
            NamedDecl /*P*/ Result = DiagnoseInvalidRedeclaration(/*Deref*/$this(), Previous, NewFD, ExtraArgs, true, S);
            if ((Result != null)) {
              AddToScope.$set(ExtraArgs.AddToScope);
              return Result;
            }
          }
        }
      } else if (!D.isFunctionDefinition()
         && isa_CXXMethodDecl(NewFD) && NewFD.isOutOfLine()
         && !isFriend && !isFunctionTemplateSpecialization
         && !isExplicitSpecialization.$deref()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // An out-of-line member function declaration must also be a
          // definition (C++ [class.mfct]p2).
          // Note that this is not the case for explicit specializations of
          // function templates or member functions of class templates, per
          // C++ [temp.expl.spec]p2. We also allow these declarations as an
          // extension for compatibility with old SWIG code which likes to
          // generate them.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewFD.getLocation(), diag.ext_out_of_line_declaration)), 
              D.getCXXScopeSpec().getRange()));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    $this().ProcessPragmaWeak(S, NewFD);
    checkAttributesAfterMerging(/*Deref*/$this(), $Deref(NewFD));
    
    $this().AddKnownFunctionAttributes(NewFD);
    if (NewFD.hasAttr(OverloadableAttr.class)
       && !(NewFD.getType().$arrow().getAs(FunctionProtoType.class) != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewFD.getLocation(), 
                diag.err_attribute_overloadable_no_prototype)), 
            NewFD));
        
        // Turn this into a variadic function with no parameters.
        /*const*/ FunctionType /*P*/ FT = NewFD.getType().$arrow().getAs(FunctionType.class);
        FunctionProtoType.ExtProtoInfo EPI/*J*/= new FunctionProtoType.ExtProtoInfo($this().Context.getDefaultCallingConvention(true, false));
        EPI.Variadic = true;
        EPI.ExtInfo.$assignMove(FT.getExtInfo());
        
        QualType R$1 = $this().Context.getFunctionType(FT.getReturnType(), new ArrayRef<QualType>(None, false), EPI);
        NewFD.setType(new QualType(R$1));
      } finally {
        $c$.$destroy();
      }
    }
    
    // If there's a #pragma GCC visibility in scope, and this isn't a class
    // member, set the visibility of this function.
    if (!DC.$deref().isRecord() && NewFD.isExternallyVisible()) {
      $this().AddPushedVisibilityAttribute(NewFD);
    }
    
    // If there's a #pragma clang arc_cf_code_audited in scope, consider
    // marking the function.
    $this().AddCFAuditedAttribute(NewFD);
    
    // If this is a function definition, check if we have to apply optnone due to
    // a pragma.
    if (D.isFunctionDefinition()) {
      $this().AddRangeBasedOptnone(NewFD);
    }
    
    // If this is the first declaration of an extern C variable, update
    // the map of such variables.
    if (NewFD.isFirstDecl$Redeclarable() && !NewFD.isInvalidDecl()
       && SemaDeclStatics.isIncompleteDeclExternC(/*Deref*/$this(), NewFD)) {
      $this().RegisterLocallyScopedExternCDecl(NewFD, S);
    }
    
    // Set this FunctionDecl's range up to the right paren.
    NewFD.setRangeEnd(D.getSourceRange().getEnd());
    if (D.isRedeclaration() && !Previous.empty()) {
      checkDLLAttributeRedeclaration(/*Deref*/$this(), dyn_cast_NamedDecl(Previous.getRepresentativeDecl()), NewFD, 
          isExplicitSpecialization.$deref() || isFunctionTemplateSpecialization, 
          D.isFunctionDefinition());
    }
    if ($this().getLangOpts().CUDA) {
      IdentifierInfo /*P*/ II = NewFD.getIdentifier();
      if ((II != null) && II.isStr(/*KEEP_STR*/"cudaConfigureCall") && !NewFD.isInvalidDecl()
         && NewFD.getDeclContext().getRedeclContext().isTranslationUnit()) {
        if (!R.$arrow().getAs(FunctionType.class).getReturnType().$arrow().isScalarType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(NewFD.getLocation(), diag.err_config_scalar_return)));
          } finally {
            $c$.$destroy();
          }
        }
        
        $this().Context.setcudaConfigureCallDecl(NewFD);
      }
      
      // Variadic functions, other than a *declaration* of printf, are not allowed
      // in device-side CUDA code, unless someone passed
      // -fcuda-allow-variadic-functions.
      if (!$this().getLangOpts().CUDAAllowVariadicFunctions && NewFD.isVariadic()
         && (NewFD.hasAttr(CUDADeviceAttr.class)
         || NewFD.hasAttr(CUDAGlobalAttr.class))
         && !((II != null) && II.isStr(/*KEEP_STR*/"printf") && NewFD.isExternC()
         && !D.isFunctionDefinition())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(NewFD.getLocation(), diag.err_variadic_device_fn)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    if ($this().getLangOpts().CPlusPlus) {
      if ((FunctionTemplate != null)) {
        if (NewFD.isInvalidDecl()) {
          FunctionTemplate.setInvalidDecl();
        }
        return FunctionTemplate;
      }
    }
    if (NewFD.hasAttr(OpenCLKernelAttr.class)) {
      // OpenCL v1.2 s6.8 static is invalid for kernel functions.
      if (($greatereq_uint($this().getLangOpts().OpenCLVersion, 120))
         && (SC == StorageClass.SC_Static)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_static_kernel)));
          D.setInvalidType();
        } finally {
          $c$.$destroy();
        }
      }
      
      // OpenCL v1.2, s6.9 -- Kernels can only have return type void.
      if (!NewFD.getReturnType().$arrow().isVoidType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SourceRange RTRange = NewFD.getReturnTypeSourceRange();
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_expected_kernel_void_return_type)), 
              (RTRange.isValid() ? FixItHint.CreateReplacement(/*NO_COPY*/RTRange, new StringRef(/*KEEP_STR*/$void)) : new FixItHint())));
          D.setInvalidType();
        } finally {
          $c$.$destroy();
        }
      }
      
      SmallPtrSet</*const*/ Type /*P*/ > ValidTypes/*J*/= new SmallPtrSet</*const*/ Type /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
      for (ParmVarDecl /*P*/ Param : NewFD.parameters())  {
        SemaDeclStatics.checkIsValidOpenCLKernelParameter(/*Deref*/$this(), D, Param, ValidTypes);
      }
    }
    for (/*const*/ ParmVarDecl /*P*/ Param : NewFD.parameters()) {
      QualType PT = Param.getType();
      
      // OpenCL 2.0 pipe restrictions forbids pipe packet types to be non-value
      // types.
      if ($greatereq_uint($this().getLangOpts().OpenCLVersion, 200)) {
        {
          /*const*/ PipeType /*P*/ PipeTy = PT.$arrow().getAs(PipeType.class);
          if ((PipeTy != null)) {
            QualType ElemTy = PipeTy.getElementType();
            if (ElemTy.$arrow().isReferenceType() || ElemTy.$arrow().isPointerType()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track($this().Diag(Param.getTypeSpecStartLoc(), diag.err_reference_pipe_type)));
                D.setInvalidType();
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      }
    }
    
    $this().MarkUnusedFileScopedDecl(NewFD);
    
    // Here we have an function template explicit specialization at class scope.
    // The actually specialization will be postponed to template instatiation
    // time via the ClassScopeFunctionSpecializationDecl node.
    if (isDependentClassScopeExplicitSpecialization) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        ClassScopeFunctionSpecializationDecl /*P*/ NewSpec = $c$.clean(ClassScopeFunctionSpecializationDecl.Create($this().Context, $this().CurContext, new SourceLocation(), 
            cast_CXXMethodDecl(NewFD), 
            HasExplicitTemplateArgs, $c$.track(new TemplateArgumentListInfo(TemplateArgs))));
        $this().CurContext.addDecl(NewSpec);
        AddToScope.$set(false);
      } finally {
        $c$.$destroy();
      }
    }
    
    return NewFD;
  } finally {
    if (TemplateArgs != null) { TemplateArgs.$destroy(); }
  }
}


/// AddOverriddenMethods - See if a method overrides any in the base classes,
/// and if so, check that it's a valid override and remember it.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddOverriddenMethods">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 7064,
 FQN="clang::Sema::AddOverriddenMethods", NM="_ZN5clang4Sema20AddOverriddenMethodsEPNS_13CXXRecordDeclEPNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema20AddOverriddenMethodsEPNS_13CXXRecordDeclEPNS_13CXXMethodDeclE")
//</editor-fold>
public final boolean AddOverriddenMethods(CXXRecordDecl /*P*/ DC, CXXMethodDecl /*P*/ MD) {
  CXXBasePaths Paths = null;
  try {
    // Look for methods in base classes that this method might override.
    Paths/*J*/= new CXXBasePaths();
    FindOverriddenMethod FOM/*J*/= new FindOverriddenMethod();
    FOM.Method = MD;
    FOM.S = $this();
    boolean hasDeletedOverridenMethods = false;
    boolean hasNonDeletedOverridenMethods = false;
    boolean AddedAny = false;
    if (DC.lookupInBases(/*FuncArg*/FOM, Paths)) {
      for (NamedDecl /*P*/ I : Paths.found_decls()) {
        {
          CXXMethodDecl /*P*/ OldMD = dyn_cast_CXXMethodDecl(I);
          if ((OldMD != null)) {
            MD.addOverriddenMethod(OldMD.getCanonicalDecl());
            if (!$this().CheckOverridingFunctionReturnType(MD, OldMD)
               && !$this().CheckOverridingFunctionAttributes(MD, OldMD)
               && !$this().CheckOverridingFunctionExceptionSpec(MD, OldMD)
               && !$this().CheckIfOverriddenFunctionIsMarkedFinal(MD, OldMD)) {
              hasDeletedOverridenMethods |= OldMD.isDeleted();
              hasNonDeletedOverridenMethods |= !OldMD.isDeleted();
              AddedAny = true;
            }
          }
        }
      }
    }
    if (hasDeletedOverridenMethods && !MD.isDeleted()) {
      ReportOverrides(/*Deref*/$this(), diag.err_non_deleted_override, MD, OverrideErrorKind.OEK_Deleted);
    }
    if (hasNonDeletedOverridenMethods && MD.isDeleted()) {
      ReportOverrides(/*Deref*/$this(), diag.err_deleted_override, MD, OverrideErrorKind.OEK_NonDeleted);
    }
    
    return AddedAny;
  } finally {
    if (Paths != null) { Paths.$destroy(); }
  }
}

// Returns true if the function declaration is a redeclaration

/// \brief Perform semantic checking of a new function declaration.
///
/// Performs semantic analysis of the new function declaration
/// NewFD. This routine performs all semantic checking that does not
/// require the actual declarator involved in the declaration, and is
/// used both for the declaration of functions as they are parsed
/// (called via ActOnDeclarator) and for the declaration of functions
/// that have been instantiated via C++ template instantiation (called
/// via InstantiateDecl).
///
/// \param IsExplicitSpecialization whether this new function declaration is
/// an explicit specialization of the previous declaration.
///
/// This sets NewFD->isInvalidDecl() to true if there was an error.
///
/// \returns true if the function declaration is a redeclaration.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckFunctionDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 8637,
 FQN="clang::Sema::CheckFunctionDeclaration", NM="_ZN5clang4Sema24CheckFunctionDeclarationEPNS_5ScopeEPNS_12FunctionDeclERNS_12LookupResultEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema24CheckFunctionDeclarationEPNS_5ScopeEPNS_12FunctionDeclERNS_12LookupResultEb")
//</editor-fold>
public final boolean CheckFunctionDeclaration(Scope /*P*/ S, FunctionDecl /*P*/ NewFD, 
                        final LookupResult /*&*/ Previous, 
                        boolean IsExplicitSpecialization) {
  assert (!NewFD.getReturnType().$arrow().isVariablyModifiedType()) : "Variably modified return types are not handled here";
  
  // Determine whether the type of this function should be merged with
  // a previous visible declaration. This never happens for functions in C++,
  // and always happens in C if the previous declaration was visible.
  boolean MergeTypeWithPrevious = !$this().getLangOpts().CPlusPlus
     && !Previous.isShadowed();
  
  boolean Redeclaration = false;
  type$ref<NamedDecl /*P*/ > OldDecl = create_type$null$ref(null);
  
  // Merge or overload the declaration with an existing declaration of
  // the same name, if appropriate.
  if (!Previous.empty()) {
    // Determine whether NewFD is an overload of PrevDecl or
    // a declaration that requires merging. If it's an overload,
    // there's no more work to do here; we'll just add the new
    // function to the scope.
    if (!AllowOverloadingOfFunction(Previous, $this().Context)) {
      NamedDecl /*P*/ Candidate = Previous.getRepresentativeDecl();
      if ($this().shouldLinkPossiblyHiddenDecl(Candidate, NewFD)) {
        Redeclaration = true;
        OldDecl.$set(Candidate);
      }
    } else {
      switch ($this().CheckOverload(S, NewFD, Previous, OldDecl, 
          /*NewIsUsingDecl*/ false)) {
       case Ovl_Match:
        Redeclaration = true;
        break;
       case Ovl_NonFunction:
        Redeclaration = true;
        break;
       case Ovl_Overload:
        Redeclaration = false;
        break;
      }
      if (!$this().getLangOpts().CPlusPlus && !NewFD.hasAttr(OverloadableAttr.class)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // If a function name is overloadable in C, then every function
          // with that name must be marked "overloadable".
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewFD.getLocation(), diag.err_attribute_overloadable_missing)), 
                  Redeclaration), NewFD));
          NamedDecl /*P*/ OverloadedDecl = null;
          if (Redeclaration) {
            OverloadedDecl = OldDecl.$deref();
          } else if (!Previous.empty()) {
            OverloadedDecl = Previous.getRepresentativeDecl();
          }
          if ((OverloadedDecl != null)) {
            $c$.clean($c$.track($this().Diag(OverloadedDecl.getLocation(), 
                diag.note_attribute_overloadable_prev_overload)));
          }
          NewFD.addAttr(OverloadableAttr.CreateImplicit($this().Context));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // Check for a previous extern "C" declaration with this name.
  if (!Redeclaration
     && checkForConflictWithNonVisibleExternC(/*Deref*/$this(), NewFD, Previous)) {
    if (!Previous.empty()) {
      // This is an extern "C" declaration with the same name as a previous
      // declaration, and thus redeclares that entity...
      Redeclaration = true;
      OldDecl.$set(Previous.getFoundDecl());
      MergeTypeWithPrevious = false;
      
      // ... except in the presence of __attribute__((overloadable)).
      if (OldDecl.$deref().hasAttr(OverloadableAttr.class)) {
        if (!$this().getLangOpts().CPlusPlus && !NewFD.hasAttr(OverloadableAttr.class)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewFD.getLocation(), diag.err_attribute_overloadable_missing)), 
                    Redeclaration), NewFD));
            $c$.clean($c$.track($this().Diag(Previous.getFoundDecl().getLocation(), 
                diag.note_attribute_overloadable_prev_overload)));
            NewFD.addAttr(OverloadableAttr.CreateImplicit($this().Context));
          } finally {
            $c$.$destroy();
          }
        }
        if ($this().IsOverload(NewFD, cast_FunctionDecl(OldDecl.$deref()), false)) {
          Redeclaration = false;
          OldDecl.$set(null);
        }
      }
    }
  }
  
  // C++11 [dcl.constexpr]p8:
  //   A constexpr specifier for a non-static member function that is not
  //   a constructor declares that member function to be const.
  //
  // This needs to be delayed until we know whether this is an out-of-line
  // definition of a static member function.
  //
  // This rule is not present in C++1y, so we produce a backwards
  // compatibility warning whenever it happens in C++11.
  CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(NewFD);
  if (!$this().getLangOpts().CPlusPlus14 && (MD != null) && MD.isConstexpr()
     && !MD.isStatic() && !isa_CXXConstructorDecl(MD)
     && (MD.getTypeQualifiers() & Qualifiers.TQ.Const) == 0) {
    CXXMethodDecl /*P*/ OldMD = null;
    if ((OldDecl.$deref() != null)) {
      OldMD = dyn_cast_or_null_CXXMethodDecl(OldDecl.$deref().getAsFunction());
    }
    if (!(OldMD != null) || !OldMD.isStatic()) {
      /*const*/ FunctionProtoType /*P*/ FPT = MD.getType().$arrow().castAs(FunctionProtoType.class);
      FunctionProtoType.ExtProtoInfo EPI = FPT.getExtProtoInfo();
      EPI.TypeQuals |= Qualifiers.TQ.Const;
      MD.setType($this().Context.getFunctionType(FPT.getReturnType(), 
              FPT.getParamTypes(), EPI));
      
      // Warn that we did this, if we're not performing template instantiation.
      // In that case, we'll have warned already when the template was defined.
      if ($this().ActiveTemplateInstantiations.empty()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SourceLocation AddConstLoc/*J*/= new SourceLocation();
          {
            FunctionTypeLoc FTL = MD.getTypeSourceInfo().getTypeLoc().
    IgnoreParens().getAs(FunctionTypeLoc.class);
            if (FTL.$bool()) {
              AddConstLoc.$assignMove($this().getLocForEndOfToken(FTL.getRParenLoc()));
            }
          }
          
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MD.getLocation(), diag.warn_cxx14_compat_constexpr_not_const)), 
              FixItHint.CreateInsertion(/*NO_COPY*/AddConstLoc, new StringRef(/*KEEP_STR*/" const"))));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  if (Redeclaration) {
    // NewFD and OldDecl represent declarations that need to be
    // merged.
    if ($this().MergeFunctionDecl(NewFD, OldDecl, S, MergeTypeWithPrevious)) {
      NewFD.setInvalidDecl();
      return Redeclaration;
    }
    
    Previous.clear();
    Previous.addDecl(OldDecl.$deref());
    {
      
      FunctionTemplateDecl /*P*/ OldTemplateDecl = dyn_cast_FunctionTemplateDecl(OldDecl.$deref());
      if ((OldTemplateDecl != null)) {
        NewFD.setPreviousDeclaration(OldTemplateDecl.getTemplatedDecl());
        FunctionTemplateDecl /*P*/ NewTemplateDecl = NewFD.getDescribedFunctionTemplate();
        assert ((NewTemplateDecl != null)) : "Template/non-template mismatch";
        {
          CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(NewTemplateDecl.getTemplatedDecl());
          if ((Method != null)) {
            Method.setAccess(OldTemplateDecl.getAccess());
            NewTemplateDecl.setAccess(OldTemplateDecl.getAccess());
          }
        }
        
        // If this is an explicit specialization of a member that is a function
        // template, mark it as a member specialization.
        if (IsExplicitSpecialization
           && (NewTemplateDecl.getInstantiatedFromMemberTemplate() != null)) {
          NewTemplateDecl.setMemberSpecialization();
          assert (OldTemplateDecl.isMemberSpecialization());
          // Explicit specializations of a member template do not inherit deleted
          // status from the parent member template that they are specializing.
          if (OldTemplateDecl.getTemplatedDecl().isDeleted()) {
            FunctionDecl /*P*/ /*const*/ OldTemplatedDecl = OldTemplateDecl.getTemplatedDecl();
            assert (OldTemplatedDecl.getCanonicalDecl() == OldTemplatedDecl);
            OldTemplatedDecl.setDeletedAsWritten(false);
          }
        }
      } else {
        // This needs to happen first so that 'inline' propagates.
        NewFD.setPreviousDeclaration(cast_FunctionDecl(OldDecl.$deref()));
        if (isa_CXXMethodDecl(NewFD)) {
          NewFD.setAccess(OldDecl.$deref().getAccess());
        }
      }
    }
  }
  
  // Semantic checking for this function declaration (in isolation).
  if ($this().getLangOpts().CPlusPlus) {
    {
      // C++-specific checks.
      CXXConstructorDecl /*P*/ Constructor = dyn_cast_CXXConstructorDecl(NewFD);
      if ((Constructor != null)) {
        $this().CheckConstructor(Constructor);
      } else {
        CXXDestructorDecl /*P*/ Destructor = dyn_cast_CXXDestructorDecl(NewFD);
        if ((Destructor != null)) {
          CXXRecordDecl /*P*/ Record = Destructor.getParent();
          QualType ClassType = $this().Context.getTypeDeclType(Record);
          
          // FIXME: Shouldn't we be able to perform this check even when the class
          // type is dependent? Both gcc and edg can handle that.
          if (!ClassType.$arrow().isDependentType()) {
            DeclarationName Name = $this().Context.DeclarationNames.getCXXDestructorName($this().Context.getCanonicalType(new QualType(ClassType)));
            if ($noteq_DeclarationName(NewFD.getDeclName(), /*NO_COPY*/Name)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track($this().Diag(NewFD.getLocation(), diag.err_destructor_name)));
                NewFD.setInvalidDecl();
                return Redeclaration;
              } finally {
                $c$.$destroy();
              }
            }
          }
        } else {
          CXXConversionDecl /*P*/ Conversion = dyn_cast_CXXConversionDecl(NewFD);
          if ((Conversion != null)) {
            $this().ActOnConversionDeclarator(Conversion);
          }
        }
      }
    }
    {
      
      // Find any virtual functions that this function overrides.
      CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(NewFD);
      if ((Method != null)) {
        if (!Method.isFunctionTemplateSpecialization()
           && !(Method.getDescribedFunctionTemplate() != null)
           && Method.isCanonicalDecl()) {
          if ($this().AddOverriddenMethods(Method.getParent(), Method)) {
            // If the function was marked as "static", we have a problem.
            if (NewFD.getStorageClass() == StorageClass.SC_Static) {
              ReportOverrides(/*Deref*/$this(), diag.err_static_overrides_virtual, Method);
            }
          }
        }
        if (Method.isStatic()) {
          $this().checkThisInStaticMemberFunctionType(Method);
        }
      }
    }
    
    // Extra checking for C++ overloaded operators (C++ [over.oper]).
    if (NewFD.isOverloadedOperator()
       && $this().CheckOverloadedOperatorDeclaration(NewFD)) {
      NewFD.setInvalidDecl();
      return Redeclaration;
    }
    
    // Extra checking for C++0x literal operators (C++0x [over.literal]).
    if ((NewFD.getLiteralIdentifier() != null)
       && $this().CheckLiteralOperatorDeclaration(NewFD)) {
      NewFD.setInvalidDecl();
      return Redeclaration;
    }
    
    // In C++, check default arguments now that we have merged decls. Unless
    // the lexical context is the class, because in this case this is done
    // during delayed parsing anyway.
    if (!$this().CurContext.isRecord()) {
      $this().CheckCXXDefaultArguments(NewFD);
    }
    {
      
      // If this function declares a builtin function, check the type of this
      // declaration against the expected type for the builtin.
      /*uint*/int BuiltinID = NewFD.getBuiltinID();
      if ((BuiltinID != 0)) {
        type$ref<ASTContext.GetBuiltinTypeError> Error = create_type$null$ref();
        LookupPredefedObjCSuperType(/*Deref*/$this(), S, NewFD.getIdentifier());
        QualType T = $this().Context.GetBuiltinType(BuiltinID, Error);
        if (!T.isNull() && !$this().Context.hasSameType(new QualType(T), NewFD.getType())) {
          // The type of this function differs from the type of the builtin,
          // so forget about the builtin entirely.
          $this().Context.BuiltinInfo.forgetBuiltin(BuiltinID, $this().Context.Idents);
        }
      }
    }
    
    // If this function is declared as being extern "C", then check to see if
    // the function returns a UDT (class, struct, or union type) that is not C
    // compatible, and if it does, warn the user.
    // But, issue any diagnostic on the first declaration only.
    if (Previous.empty() && NewFD.isExternC()) {
      QualType R = NewFD.getReturnType();
      if (R.$arrow().isIncompleteType() && !R.$arrow().isVoidType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewFD.getLocation(), diag.warn_return_value_udt_incomplete)), 
                  NewFD), R));
        } finally {
          $c$.$destroy();
        }
      } else if (!R.isPODType($this().Context) && !R.$arrow().isVoidType()
         && !R.$arrow().isObjCObjectPointerType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewFD.getLocation(), diag.warn_return_value_udt)), NewFD), R));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  return Redeclaration;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckMain">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 8907,
 FQN="clang::Sema::CheckMain", NM="_ZN5clang4Sema9CheckMainEPNS_12FunctionDeclERKNS_8DeclSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema9CheckMainEPNS_12FunctionDeclERKNS_8DeclSpecE")
//</editor-fold>
public final void CheckMain(FunctionDecl /*P*/ FD, final /*const*/ DeclSpec /*&*/ DS) {
  // C++11 [basic.start.main]p3:
  //   A program that [...] declares main to be inline, static or
  //   constexpr is ill-formed.
  // C11 6.7.4p4:  In a hosted environment, no function specifier(s) shall
  //   appear in a declaration of main.
  // static main is not an error under C99, but we should warn about it.
  // We accept _Noreturn main as an extension.
  if (FD.getStorageClass() == StorageClass.SC_Static) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getStorageClassSpecLoc(), $this().getLangOpts().CPlusPlus ? diag.err_static_main : diag.warn_static_main)), 
          FixItHint.CreateRemoval(new SourceRange(DS.getStorageClassSpecLoc()))));
    } finally {
      $c$.$destroy();
    }
  }
  if (FD.isInlineSpecified()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getInlineSpecLoc(), diag.err_inline_main)), 
          FixItHint.CreateRemoval(new SourceRange(DS.getInlineSpecLoc()))));
    } finally {
      $c$.$destroy();
    }
  }
  if (DS.isNoreturnSpecified()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SourceLocation NoreturnLoc = DS.getNoreturnSpecLoc();
      SourceRange NoreturnRange/*J*/= new SourceRange(/*NO_COPY*/NoreturnLoc, $this().getLocForEndOfToken(new SourceLocation(NoreturnLoc)));
      $c$.clean($c$.track($this().Diag(new SourceLocation(NoreturnLoc), diag.ext_noreturn_main)));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NoreturnLoc), diag.note_main_remove_noreturn)), 
          FixItHint.CreateRemoval(/*NO_COPY*/NoreturnRange)));
    } finally {
      $c$.$destroy();
    }
  }
  if (FD.isConstexpr()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getConstexprSpecLoc(), diag.err_constexpr_main)), 
          FixItHint.CreateRemoval(new SourceRange(DS.getConstexprSpecLoc()))));
      FD.setConstexpr(false);
    } finally {
      $c$.$destroy();
    }
  }
  if ($this().getLangOpts().OpenCL) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getLocation(), diag.err_opencl_no_main)), 
          FD.hasAttr(OpenCLKernelAttr.class)));
      FD.setInvalidDecl();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  QualType T = FD.getType();
  assert (T.$arrow().isFunctionType()) : "function decl is not of function type";
  /*const*/ FunctionType /*P*/ FT = T.$arrow().castAs(FunctionType.class);
  if ($this().getLangOpts().GNUMode && !$this().getLangOpts().CPlusPlus) {
    // In C with GNU extensions we allow main() to have non-integer return
    // type, but we should warn about the extension, and we disable the
    // implicit-return-zero rule.
    
    // GCC in C mode accepts qualified 'int'.
    if ($this().Context.hasSameUnqualifiedType(FT.getReturnType(), $this().Context.IntTy.$QualType())) {
      FD.setHasImplicitReturnZero(true);
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(FD.getTypeSpecStartLoc(), diag.ext_main_returns_nonint)));
        SourceRange RTRange = FD.getReturnTypeSourceRange();
        if (RTRange.isValid()) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(RTRange.getBegin(), diag.note_main_change_return_type)), 
              FixItHint.CreateReplacement(/*NO_COPY*/RTRange, new StringRef(/*KEEP_STR*/$int))));
        }
      } finally {
        $c$.$destroy();
      }
    }
  } else {
    // In C and C++, main magically returns 0 if you fall off the end;
    // set the flag which tells us that.
    // This is C++ [basic.start.main]p5 and C99 5.1.2.2.3.
    
    // All the standards say that main() should return 'int'.
    if ($this().Context.hasSameType(FT.getReturnType(), $this().Context.IntTy.$QualType())) {
      FD.setHasImplicitReturnZero(true);
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Otherwise, this is just a flat-out error.
        SourceRange RTRange = FD.getReturnTypeSourceRange();
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getTypeSpecStartLoc(), diag.err_main_returns_nonint)), 
            (RTRange.isValid() ? FixItHint.CreateReplacement(/*NO_COPY*/RTRange, new StringRef(/*KEEP_STR*/$int)) : new FixItHint())));
        FD.setInvalidDecl(true);
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Treat protoless main() as nullary.
  if (isa_FunctionNoProtoType(FT)) {
    return;
  }
  
  /*const*/ FunctionProtoType /*P*/ FTP = cast_FunctionProtoType(FT);
  /*uint*/int nparams = FTP.getNumParams();
  assert (FD.getNumParams() == nparams);
  
  boolean HasExtraParameters = ($greater_uint(nparams, 3));
  if (FTP.isVariadic()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(FD.getLocation(), diag.ext_variadic_main)));
    } finally {
      $c$.$destroy();
    }
    // FIXME: if we had information about the location of the ellipsis, we
    // could add a FixIt hint to remove it as a parameter.
  }
  
  // Darwin passes an undocumented fourth argument of type char**.  If
  // other platforms start sprouting these, the logic below will start
  // getting shifty.
  if (nparams == 4 && $this().Context.getTargetInfo().getTriple().isOSDarwin()) {
    HasExtraParameters = false;
  }
  if (HasExtraParameters) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getLocation(), diag.err_main_surplus_args)), nparams));
      FD.setInvalidDecl(true);
      nparams = 3;
    } finally {
      $c$.$destroy();
    }
  }
  
  // FIXME: a lot of the following diagnostics would be improved
  // if we had some location information about types.
  QualType CharPP = $this().Context.getPointerType($this().Context.getPointerType(new CanQual<Type>($this().Context.CharTy))).$QualType();
  QualType Expected[/*4*/] = new QualType [/*4*/] {$this().Context.IntTy.$QualType(), CharPP, CharPP, CharPP};
  
  for (/*uint*/int i = 0; $less_uint(i, nparams); ++i) {
    QualType AT = FTP.getParamType(i);
    
    boolean mismatch = true;
    if ($this().Context.hasSameUnqualifiedType(new QualType(AT), new QualType(Expected[i]))) {
      mismatch = false;
    } else if ($eq_QualType$C(Expected[i], CharPP)) {
      // As an extension, the following forms are okay:
      //   char const **
      //   char const * const *
      //   char * const *
      QualifierCollector qs/*J*/= new QualifierCollector();
      /*const*/ PointerType /*P*/ PT;
      if (((PT = qs.strip(new QualType(AT)).getAs(PointerType.class)) != null)
         && ((PT = qs.strip(PT.getPointeeType()).getAs(PointerType.class)) != null)
         && $this().Context.hasSameType(new QualType(qs.strip(PT.getPointeeType()), 0), 
          $this().Context.CharTy.$QualType())) {
        qs.removeConst();
        mismatch = !qs.empty();
      }
    }
    if (mismatch) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getLocation(), diag.err_main_arg_wrong)), i), Expected[i]));
        // TODO: suggest replacing given type with expected type
        FD.setInvalidDecl(true);
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (nparams == 1 && !FD.isInvalidDecl()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(FD.getLocation(), diag.warn_main_one_arg)));
    } finally {
      $c$.$destroy();
    }
  }
  if (!FD.isInvalidDecl() && (FD.getDescribedFunctionTemplate() != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getLocation(), diag.err_mainlike_template_decl)), FD));
      FD.setInvalidDecl();
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckMSVCRTEntryPoint">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9054,
 FQN="clang::Sema::CheckMSVCRTEntryPoint", NM="_ZN5clang4Sema21CheckMSVCRTEntryPointEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema21CheckMSVCRTEntryPointEPNS_12FunctionDeclE")
//</editor-fold>
public final void CheckMSVCRTEntryPoint(FunctionDecl /*P*/ FD) {
  QualType T = FD.getType();
  assert (T.$arrow().isFunctionType()) : "function decl is not of function type";
  /*const*/ FunctionType /*P*/ FT = T.$arrow().castAs(FunctionType.class);
  
  // Set an implicit return of 'zero' if the function can return some integral,
  // enumeration, pointer or nullptr type.
  if (FT.getReturnType().$arrow().isIntegralOrEnumerationType()
     || FT.getReturnType().$arrow().isAnyPointerType()
     || FT.getReturnType().$arrow().isNullPtrType()) {
    // DllMain is exempt because a return value of zero means it failed.
    if ($noteq_StringRef(FD.getName(), /*STRINGREF_STR*/"DllMain")) {
      FD.setHasImplicitReturnZero(true);
    }
  }
  if (!FD.isInvalidDecl() && (FD.getDescribedFunctionTemplate() != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getLocation(), diag.err_mainlike_template_decl)), FD));
      FD.setInvalidDecl();
    } finally {
      $c$.$destroy();
    }
  }
}


/// ActOnParamDeclarator - Called from Parser::ParseFunctionDeclarator()
/// to introduce parameters into function prototype scope.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnParamDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 10795,
 FQN="clang::Sema::ActOnParamDeclarator", NM="_ZN5clang4Sema20ActOnParamDeclaratorEPNS_5ScopeERNS_10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema20ActOnParamDeclaratorEPNS_5ScopeERNS_10DeclaratorE")
//</editor-fold>
public final Decl /*P*/ ActOnParamDeclarator(Scope /*P*/ S, final Declarator /*&*/ D) {
  final /*const*/ DeclSpec /*&*/ DS = D.getDeclSpec();
  
  // Verify C99 6.7.5.3p2: The only SCS allowed is 'register'.
  
  // C++03 [dcl.stc]p2 also permits 'auto'.
  StorageClass SC = StorageClass.SC_None;
  if (DS.getStorageClassSpec() == DeclSpec.SCS.SCS_register) {
    SC = StorageClass.SC_Register;
  } else if ($this().getLangOpts().CPlusPlus
     && DS.getStorageClassSpec() == DeclSpec.SCS.SCS_auto) {
    SC = StorageClass.SC_Auto;
  } else if (DS.getStorageClassSpec() != DeclSpec.SCS.SCS_unspecified) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(DS.getStorageClassSpecLoc(), 
          diag.err_invalid_storage_class_in_func_decl)));
      D.getMutableDeclSpec().ClearStorageClassSpecs();
    } finally {
      $c$.$destroy();
    }
  }
  {
    
    ThreadStorageClassSpecifier TSCS = DS.getThreadStorageClassSpec();
    if ((TSCS.getValue() != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getThreadStorageClassSpecLoc(), diag.err_invalid_thread)), 
            DeclSpec.getSpecifierName_ThreadStorageClassSpecifier(TSCS)));
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (DS.isInlineSpecified()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getInlineSpecLoc(), diag.err_inline_non_function)), 
          $this().getLangOpts().CPlusPlus1z));
    } finally {
      $c$.$destroy();
    }
  }
  if (DS.isConstexprSpecified()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getConstexprSpecLoc(), diag.err_invalid_constexpr)), 
          0));
    } finally {
      $c$.$destroy();
    }
  }
  if (DS.isConceptSpecified()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(DS.getConceptSpecLoc(), diag.err_concept_wrong_decl_kind)));
    } finally {
      $c$.$destroy();
    }
  }
  
  $this().DiagnoseFunctionSpecifiers(DS);
  
  TypeSourceInfo /*P*/ TInfo = $this().GetTypeForDeclarator(D, S);
  QualType parmDeclType = TInfo.getType();
  if ($this().getLangOpts().CPlusPlus) {
    // Check that there are no default arguments inside the type of this
    // parameter.
    $this().CheckExtraCXXDefaultArguments(D);
    
    // Parameter declarators cannot be qualified (C++ [dcl.meaning]p1).
    if (D.getCXXScopeSpec().isSet()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_qualified_param_declarator)), 
            D.getCXXScopeSpec().getRange()));
        D.getCXXScopeSpec().clear();
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Ensure we have a valid name
  IdentifierInfo /*P*/ II = null;
  if (D.hasName()) {
    II = D.getIdentifier();
    if (!(II != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_bad_parameter_name)), 
            $this().GetNameForDeclarator(D).getName()));
        D.setInvalidType(true);
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Check for redeclaration of parameters, e.g. int foo(int x, int x);
  if ((II != null)) {
    LookupResult R = null;
    try {
      R/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(II), D.getIdentifierLoc(), LookupNameKind.LookupOrdinaryName, 
          RedeclarationKind.ForRedeclaration);
      $this().LookupName(R, S);
      if (R.isSingleResult()) {
        NamedDecl /*P*/ PrevDecl = R.getFoundDecl();
        if (PrevDecl.isTemplateParameter()) {
          // Maybe we will complain about the shadowed template parameter.
          $this().DiagnoseTemplateParameterShadow(D.getIdentifierLoc(), PrevDecl);
          // Just pretend that we didn't see the previous declaration.
          PrevDecl = null;
        } else if (S.isDeclScope(PrevDecl)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_param_redefinition)), II));
            $c$.clean($c$.track($this().Diag(PrevDecl.getLocation(), diag.note_previous_declaration)));
            
            // Recover by removing the name
            II = null;
            D.SetIdentifier((IdentifierInfo /*P*/ )null, D.getIdentifierLoc());
            D.setInvalidType(true);
          } finally {
            $c$.$destroy();
          }
        }
      }
    } finally {
      if (R != null) { R.$destroy(); }
    }
  }
  
  // Temporarily put parameter variables in the translation unit, not
  // the enclosing context.  This prevents them from accidentally
  // looking like class members in C++.
  ParmVarDecl /*P*/ New = $this().CheckParameter($this().Context.getTranslationUnitDecl(), 
      D.getLocStart(), 
      D.getIdentifierLoc(), II, 
      new QualType(parmDeclType), TInfo, 
      SC);
  if (D.isInvalidType()) {
    New.setInvalidDecl();
  }
  assert (S.isFunctionPrototypeScope());
  assert ($greatereq_uint(S.getFunctionPrototypeDepth(), 1));
  New.setScopeInfo(S.getFunctionPrototypeDepth() - 1, 
      S.getNextFunctionPrototypeIndex());
  
  // Add the parameter declaration into this scope.
  S.AddDecl(New);
  if ((II != null)) {
    $this().IdResolver.AddDecl(New);
  }
  
  $this().ProcessDeclAttributes(S, New, D);
  if (D.getDeclSpec().isModulePrivateSpecified()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_module_private_local)), 
                      1), New.getDeclName()), 
              new SourceRange(D.getDeclSpec().getModulePrivateSpecLoc())), 
          FixItHint.CreateRemoval(new SourceRange(D.getDeclSpec().getModulePrivateSpecLoc()))));
    } finally {
      $c$.$destroy();
    }
  }
  if (New.hasAttr(BlocksAttr.class)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(New.getLocation(), diag.err_block_on_nonlocal)));
    } finally {
      $c$.$destroy();
    }
  }
  return New;
}


/// \brief Synthesizes a variable for a parameter arising from a
/// typedef.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildParmVarDeclForTypedef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 10916,
 FQN="clang::Sema::BuildParmVarDeclForTypedef", NM="_ZN5clang4Sema26BuildParmVarDeclForTypedefEPNS_11DeclContextENS_14SourceLocationENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema26BuildParmVarDeclForTypedefEPNS_11DeclContextENS_14SourceLocationENS_8QualTypeE")
//</editor-fold>
public final ParmVarDecl /*P*/ BuildParmVarDeclForTypedef(DeclContext /*P*/ DC, 
                          SourceLocation Loc, 
                          QualType T) {
  /* FIXME: setting StartLoc == Loc.
  Would it be worth to modify callers so as to provide proper source
  location for the unnamed parameters, embedding the parameter's type? */
  ParmVarDecl /*P*/ Param = ParmVarDecl.Create($this().Context, DC, new SourceLocation(Loc), new SourceLocation(Loc), (IdentifierInfo /*P*/ )null, 
      new QualType(T), $this().Context.getTrivialTypeSourceInfo(/*NO_COPY*/T, /*NO_COPY*/Loc), 
      StorageClass.SC_None, (Expr /*P*/ )null);
  Param.setImplicit();
  return Param;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckParameter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 10971,
 FQN="clang::Sema::CheckParameter", NM="_ZN5clang4Sema14CheckParameterEPNS_11DeclContextENS_14SourceLocationES3_PNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema14CheckParameterEPNS_11DeclContextENS_14SourceLocationES3_PNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassE")
//</editor-fold>
public final ParmVarDecl /*P*/ CheckParameter(DeclContext /*P*/ DC, SourceLocation StartLoc, 
              SourceLocation NameLoc, IdentifierInfo /*P*/ Name, 
              QualType T, TypeSourceInfo /*P*/ TSInfo, 
              StorageClass SC) {
  // In ARC, infer a lifetime qualifier for appropriate parameter types.
  if ($this().getLangOpts().ObjCAutoRefCount
     && T.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_None
     && T.$arrow().isObjCLifetimeType()) {
    
    Qualifiers.ObjCLifetime lifetime;
    
    // Special cases for arrays:
    //   - if it's const, use __unsafe_unretained
    //   - otherwise, it's an error
    if (T.$arrow().isArrayType()) {
      if (!T.isConstQualified()) {
        $this().DelayedDiagnostics.add(DelayedDiagnostic.makeForbiddenType(new SourceLocation(NameLoc), diag.err_arc_array_param_no_ownership, new QualType(T), /*false*/0));
      }
      lifetime = Qualifiers.ObjCLifetime.OCL_ExplicitNone;
    } else {
      lifetime = T.$arrow().getObjCARCImplicitLifetime();
    }
    T.$assignMove($this().Context.getLifetimeQualifiedType(new QualType(T), lifetime));
  }
  
  ParmVarDecl /*P*/ New = ParmVarDecl.Create($this().Context, DC, new SourceLocation(StartLoc), new SourceLocation(NameLoc), Name, 
      $this().Context.getAdjustedParameterType(new QualType(T)), 
      TSInfo, SC, (Expr /*P*/ )null);
  
  // Parameters can not be abstract class types.
  // For record types, this is done by the AbstractClassUsageDiagnoser once
  // the class has been completely parsed.
  if (!$this().CurContext.isRecord()
     && $this().RequireNonAbstractType$T(new SourceLocation(NameLoc), new QualType(T), diag.err_abstract_type_in_decl, 
      AbstractDiagSelID.AbstractParamType)) {
    New.setInvalidDecl();
  }
  
  // Parameter declarators cannot be interface types. All ObjC objects are
  // passed by reference.
  if (T.$arrow().isObjCObjectType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SourceLocation TypeEndLoc = $this().getLocForEndOfToken(TSInfo.getTypeLoc().getLocEnd());
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(new SourceLocation(NameLoc), 
                      diag.err_object_cannot_be_passed_returned_by_value)), 1), T), 
          FixItHint.CreateInsertion(/*NO_COPY*/TypeEndLoc, new StringRef(/*KEEP_STR*/$STAR))));
      T.$assignMove($this().Context.getObjCObjectPointerType(new QualType(T)));
      New.setType(new QualType(T));
    } finally {
      $c$.$destroy();
    }
  }
  
  // ISO/IEC TR 18037 S6.7.3: "The type of an object with automatic storage
  // duration shall not be qualified by an address-space qualifier."
  // Since all parameters have automatic store duration, they can not have
  // an address space.
  if (T.getAddressSpace() != 0) {
    // OpenCL allows function arguments declared to be an array of a type
    // to be qualified with an address space.
    if (!($this().getLangOpts().OpenCL && T.$arrow().isArrayType())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_arg_with_address_space)));
        New.setInvalidDecl();
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  return New;
}


/// AddInitializerToDecl - Adds the initializer Init to the
/// declaration dcl. If DirectInit is true, this is C++ direct
/// initialization rather than copy initialization.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddInitializerToDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9517,
 FQN="clang::Sema::AddInitializerToDecl", NM="_ZN5clang4Sema20AddInitializerToDeclEPNS_4DeclEPNS_4ExprEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema20AddInitializerToDeclEPNS_4DeclEPNS_4ExprEbb")
//</editor-fold>
public final void AddInitializerToDecl(Decl /*P*/ RealDecl, Expr /*P*/ Init, 
                    boolean DirectInit, boolean TypeMayContainAuto) {
  // If there is no declaration, there was an error parsing it.  Just ignore
  // the initializer.
  if (!(RealDecl != null) || RealDecl.isInvalidDecl()) {
    $this().CorrectDelayedTyposInExpr(Init, dyn_cast_or_null_VarDecl(RealDecl));
    return;
  }
  {
    
    CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(RealDecl);
    if ((Method != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Pure-specifiers are handled in ActOnPureSpecifier.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Method.getLocation(), diag.err_member_function_initialization)), 
                Method.getDeclName()), Init.getSourceRange()));
        Method.setInvalidDecl();
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  VarDecl /*P*/ VDecl = dyn_cast_VarDecl(RealDecl);
  if (!(VDecl != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (!isa_FieldDecl(RealDecl)) : "field init shouldn't get here";
      $c$.clean($c$.track($this().Diag(RealDecl.getLocation(), diag.err_illegal_initializer)));
      RealDecl.setInvalidDecl();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // C++11 [decl.spec.auto]p6. Deduce the type which 'auto' stands in for.
  if (TypeMayContainAuto && VDecl.getType().$arrow().isUndeducedType()) {
    // Attempt typo correction early so that the type of the init expression can
    // be deduced based on the chosen correction if the original init contains a
    // TypoExpr.
    ActionResultTTrue<Expr /*P*/ > Res = $this().CorrectDelayedTyposInExpr(Init, VDecl);
    if (!Res.isUsable()) {
      RealDecl.setInvalidDecl();
      return;
    }
    Init = Res.get();
    
    QualType DeducedType = $this().deduceVarTypeFromInitializer(VDecl, VDecl.getDeclName(), VDecl.getType(), 
        VDecl.getTypeSourceInfo(), VDecl.getSourceRange(), DirectInit, Init);
    if (DeducedType.isNull()) {
      RealDecl.setInvalidDecl();
      return;
    }
    
    VDecl.setType(new QualType(DeducedType));
    assert (VDecl.isLinkageValid());
    
    // In ARC, infer lifetime.
    if ($this().getLangOpts().ObjCAutoRefCount && $this().inferObjCARCLifetime(VDecl)) {
      VDecl.setInvalidDecl();
    }
    {
      
      // If this is a redeclaration, check that the type we just deduced matches
      // the previously declared type.
      VarDecl /*P*/ Old = VDecl.getPreviousDecl$Redeclarable();
      if ((Old != null)) {
        // We never need to merge the type, because we cannot form an incomplete
        // array of auto, nor deduce such a type.
        $this().MergeVarDeclTypes(VDecl, Old, /*MergeTypeWithPrevious*/ false);
      }
    }
    
    // Check the deduced type is valid for a variable declaration.
    $this().CheckVariableDeclarationType(VDecl);
    if (VDecl.isInvalidDecl()) {
      return;
    }
  }
  
  // dllimport cannot be used on variable definitions.
  if (VDecl.hasAttr(DLLImportAttr.class) && !VDecl.isStaticDataMember()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(VDecl.getLocation(), diag.err_attribute_dllimport_data_definition)));
      VDecl.setInvalidDecl();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (VDecl.isLocalVarDecl() && VDecl.hasExternalStorage()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // C99 6.7.8p5. C++ has no such restriction, but that is a defect.
      $c$.clean($c$.track($this().Diag(VDecl.getLocation(), diag.err_block_extern_cant_init)));
      VDecl.setInvalidDecl();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (!VDecl.getType().$arrow().isDependentType()) {
    // A definition must end up with a complete type, which means it must be
    // complete with the restriction that an array type might be completed by
    // the initializer; note that later code assumes this restriction.
    QualType BaseDeclType = VDecl.getType();
    {
      /*const*/ ArrayType /*P*/ Array = $this().Context.getAsIncompleteArrayType(new QualType(BaseDeclType));
      if ((Array != null)) {
        BaseDeclType.$assignMove(Array.getElementType());
      }
    }
    if ($this().RequireCompleteType(VDecl.getLocation(), new QualType(BaseDeclType), 
        diag.err_typecheck_decl_incomplete_type)) {
      RealDecl.setInvalidDecl();
      return;
    }
    
    // The variable can not have an abstract class type.
    if ($this().RequireNonAbstractType$T(VDecl.getLocation(), VDecl.getType(), 
        diag.err_abstract_type_in_decl, 
        AbstractDiagSelID.AbstractVariableType)) {
      VDecl.setInvalidDecl();
    }
  }
  
  VarDecl /*P*/ Def;
  if (((Def = VDecl.getDefinition()) != null) && Def != VDecl) {
    type$ptr<NamedDecl /*P*/ > Hidden = create_type$null$ptr(null);
    if (!$this().hasVisibleDefinition(Def, $AddrOf(Hidden))
       && (VDecl.getFormalLinkage() == Linkage.InternalLinkage
       || (VDecl.getDescribedVarTemplate() != null)
       || (VDecl.getNumTemplateParameterLists() != 0)
       || VDecl.getDeclContext().isDependentContext())) {
      // The previous definition is hidden, and multiple definitions are
      // permitted (in separate TUs). Form another definition of it.
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag(VDecl.getLocation(), diag.err_redefinition)), 
            VDecl.getDeclName()));
        $c$.clean($c$.track($this().Diag(Def.getLocation(), diag.note_previous_definition)));
        VDecl.setInvalidDecl();
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  if ($this().getLangOpts().CPlusPlus) {
    // C++ [class.static.data]p4
    //   If a static data member is of const integral or const
    //   enumeration type, its declaration in the class definition can
    //   specify a constant-initializer which shall be an integral
    //   constant expression (5.19). In that case, the member can appear
    //   in integral constant expressions. The member shall still be
    //   defined in a namespace scope if it is used in the program and the
    //   namespace scope definition shall not contain an initializer.
    //
    // We already performed a redefinition check above, but for static
    // data members we also need to check whether there was an in-class
    // declaration with an initializer.
    if (VDecl.isStaticDataMember() && VDecl.getCanonicalDecl().hasInit()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag(Init.getExprLoc(), diag.err_static_data_member_reinitialization)), 
            VDecl.getDeclName()));
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(VDecl.getCanonicalDecl().getInit().getExprLoc(), 
                diag.note_previous_initializer)), 
            0));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    if (VDecl.hasLocalStorage()) {
      $this().getCurFunction().setHasBranchProtectedScope();
    }
    if ($this().DiagnoseUnexpandedParameterPack(Init, UnexpandedParameterPackContext.UPPC_Initializer)) {
      VDecl.setInvalidDecl();
      return;
    }
  }
  
  // OpenCL 1.1 6.5.2: "Variables allocated in the __local address space inside
  // a kernel function cannot be initialized."
  if (VDecl.getType().getAddressSpace() == LangAS.ID.opencl_local) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(VDecl.getLocation(), diag.err_local_cant_init)));
      VDecl.setInvalidDecl();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Get the decls type and save a reference for later, since
  // CheckInitializerTypes may change it.
  QualType DclT = VDecl.getType();
  QualType SavT = new QualType(DclT);
  
  // Expressions default to 'id' when we're in a debugger
  // and we are assigning it to a variable of Objective-C pointer type.
  if ($this().getLangOpts().DebuggerCastResultToId && DclT.$arrow().isObjCObjectPointerType()
     && $eq_QualType$C(Init.getType(), $this().Context.UnknownAnyTy.$QualType())) {
    ActionResultTTrue<Expr /*P*/ > Result = $this().forceUnknownAnyToType(Init, $this().Context.getObjCIdType());
    if (Result.isInvalid()) {
      VDecl.setInvalidDecl();
      return;
    }
    Init = Result.get();
  }
  
  // Perform the initialization.
  ParenListExpr /*P*/ CXXDirectInit = dyn_cast_ParenListExpr(Init);
  if (!VDecl.isInvalidDecl()) {
    InitializationSequence InitSeq = null;
    try {
      InitializedEntity Entity = InitializedEntity.InitializeVariable(VDecl);
      InitializationKind Kind = DirectInit ? (CXXDirectInit != null) ? InitializationKind.CreateDirect(VDecl.getLocation(), 
          Init.getLocStart(), 
          Init.getLocEnd()) : InitializationKind.CreateDirectList(VDecl.getLocation()) : InitializationKind.CreateCopy(VDecl.getLocation(), 
          Init.getLocStart());
      
      MutableArrayRef<Expr /*P*/ > Args = new MutableArrayRef<Expr /*P*/ >(Init, true);
      if ((CXXDirectInit != null)) {
        Args.$assignMove(new MutableArrayRef<Expr /*P*/ >(CXXDirectInit.getExprs(), 
                CXXDirectInit.getNumExprs(), true));
      }
      
      // Try to correct any TypoExprs in the initialization arguments.
      for (/*size_t*/int Idx = 0; $less_uint(Idx, Args.size()); ++Idx) {
        ActionResultTTrue<Expr /*P*/ > Res = $this().CorrectDelayedTyposInExpr(Args.$at(Idx), VDecl, /*FuncArg*//*[this, =L$Entity(Entity), =L$Kind(Kind)]*/ (Expr /*P*/ E) -> {
                  InitializationSequence Init$1 = null;
                  try {
                    Init$1/*J*/= new InitializationSequence(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(E, true));
                    return Init$1.Failed() ? ExprError() : new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
                  } finally {
                    if (Init$1 != null) { Init$1.$destroy(); }
                  }
                });
        if (Res.isInvalid()) {
          VDecl.setInvalidDecl();
        } else if (Res.get() != Args.$at(Idx)) {
          Args.$set(Idx, Res.get());
        }
      }
      if (VDecl.isInvalidDecl()) {
        return;
      }
      
      InitSeq/*J*/= new InitializationSequence(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(Args), 
          /*TopLevelOfInitList=*/ false, 
          /*TreatUnavailableAsInvalid=*/ false);
      ActionResultTTrue<Expr /*P*/ > Result = InitSeq.Perform(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(Args), create_type$ptr($AddrOf(DclT)));
      if (Result.isInvalid()) {
        VDecl.setInvalidDecl();
        return;
      }
      
      Init = Result.getAs(Expr.class);
    } finally {
      if (InitSeq != null) { InitSeq.$destroy(); }
    }
  }
  
  // Check for self-references within variable initializers.
  // Variables declared within a function/method body (except for references)
  // are handled by a dataflow analysis.
  if (!VDecl.hasLocalStorage() || VDecl.getType().$arrow().isRecordType()
     || VDecl.getType().$arrow().isReferenceType()) {
    CheckSelfReference(/*Deref*/$this(), RealDecl, Init, DirectInit);
  }
  
  // If the type changed, it means we had an incomplete type that was
  // completed by the initializer. For example:
  //   int ary[] = { 1, 3, 5 };
  // "ary" transitions from an IncompleteArrayType to a ConstantArrayType.
  if (!VDecl.isInvalidDecl() && ($noteq_QualType$C(DclT, SavT))) {
    VDecl.setType(new QualType(DclT));
  }
  if (!VDecl.isInvalidDecl()) {
    $this().checkUnsafeAssigns(VDecl.getLocation(), VDecl.getType(), Init);
    if (VDecl.hasAttr(BlocksAttr.class)) {
      $this().checkRetainCycles(VDecl, Init);
    }
    
    // It is safe to assign a weak reference into a strong variable.
    // Although this code can still have problems:
    //   id x = self.weakProp;
    //   id y = self.weakProp;
    // we do not warn to warn spuriously when 'x' and 'y' are on separate
    // paths through the function. This should be revisited if
    // -Wrepeated-use-of-weak is made flow-sensitive.
    if (VDecl.getType().getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Strong
       && !$this().Diags.isIgnored(diag.warn_arc_repeated_use_of_weak, 
        Init.getLocStart())) {
      $this().getCurFunction().markSafeWeakUse(Init);
    }
  }
  
  // The initialization is usually a full-expression.
  //
  // FIXME: If this is a braced initialization of an aggregate, it is not
  // an expression, and each individual field initializer is a separate
  // full-expression. For instance, in:
  //
  //   struct Temp { ~Temp(); };
  //   struct S { S(Temp); };
  //   struct T { S a, b; } t = { Temp(), Temp() }
  //
  // we should destroy the first Temp before constructing the second.
  ActionResultTTrue<Expr /*P*/ > Result = $this().ActOnFinishFullExpr(Init, VDecl.getLocation(), 
      false, 
      VDecl.isConstexpr());
  if (Result.isInvalid()) {
    VDecl.setInvalidDecl();
    return;
  }
  Init = Result.get();
  
  // Attach the initializer to the decl.
  VDecl.setInit(Init);
  if (VDecl.isLocalVarDecl()) {
    // C99 6.7.8p4: All the expressions in an initializer for an object that has
    // static storage duration shall be constant expressions or string literals.
    // C++ does not have this restriction.
    if (!$this().getLangOpts().CPlusPlus && !VDecl.isInvalidDecl()) {
      type$ptr</*const*/ Expr /*P*/ > Culprit = create_type$null$ptr();
      if (VDecl.getStorageClass() == StorageClass.SC_Static) {
        $this().CheckForConstantInitializer(Init, new QualType(DclT));
      } else // C89 is stricter than C99 for non-static aggregate types.
      // C89 6.5.7p3: All the expressions [...] in an initializer list
      // for an object that has aggregate or union type shall be
      // constant expressions.
      if (!$this().getLangOpts().C99 && VDecl.getType().$arrow().isAggregateType()
         && isa_InitListExpr(Init)
         && !Init.isConstantInitializer($this().Context, false, $AddrOf(Culprit))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Culprit.$star().getExprLoc(), 
                  diag.ext_aggregate_init_not_constant)), 
              Culprit.$star().getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
    }
  } else if (VDecl.isStaticDataMember() && !VDecl.isInline()
     && VDecl.getLexicalDeclContext().isRecord()) {
    // This is an in-class initialization for a static data member, e.g.,
    //
    // struct S {
    //   static const int value = 17;
    // };
    
    // C++ [class.mem]p4:
    //   A member-declarator can contain a constant-initializer only
    //   if it declares a static member (9.4) of const integral or
    //   const enumeration type, see 9.4.2.
    //
    // C++11 [class.static.data]p3:
    //   If a non-volatile non-inline const static data member is of integral
    //   or enumeration type, its declaration in the class definition can
    //   specify a brace-or-equal-initializer in which every initalizer-clause
    //   that is an assignment-expression is a constant expression. A static
    //   data member of literal type can be declared in the class definition
    //   with the constexpr specifier; if so, its declaration shall specify a
    //   brace-or-equal-initializer in which every initializer-clause that is
    //   an assignment-expression is a constant expression.
    
    // Do nothing on dependent types.
    if (DclT.$arrow().isDependentType()) {
      // Allow any 'static constexpr' members, whether or not they are of literal
      // type. We separately check that every constexpr variable is of literal
      // type.
    } else if (VDecl.isConstexpr()) {
      // Require constness.
    } else if (!DclT.isConstQualified()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(VDecl.getLocation(), diag.err_in_class_initializer_non_const)), 
            Init.getSourceRange()));
        VDecl.setInvalidDecl();
      } finally {
        $c$.$destroy();
      }
      // We allow integer constant expressions in all cases.
    } else if (DclT.$arrow().isIntegralOrEnumerationType()) {
      // Check whether the expression is a constant expression.
      SourceLocation Loc/*J*/= new SourceLocation();
      if ($this().getLangOpts().CPlusPlus11 && DclT.isVolatileQualified()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // In C++11, a non-constexpr const static data member with an
          // in-class initializer cannot be volatile.
          $c$.clean($c$.track($this().Diag(VDecl.getLocation(), diag.err_in_class_initializer_volatile)));
        } finally {
          $c$.$destroy();
        }
      } else if (Init.isValueDependent()) {
        ; // Nothing to check.
      } else if (Init.isIntegerConstantExpr($this().Context, $AddrOf(create_type$ptr(Loc)))) {
        ; // Ok, it's an ICE!
      } else if (Init.isEvaluatable($this().Context)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // If we can constant fold the initializer through heroics, accept it,
          // but report this as a use of an extension for -pedantic.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.ext_in_class_initializer_non_constant)), 
              Init.getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Otherwise, this is some crazy unknown case.  Report the issue at the
          // location provided by the isIntegerConstantExpr failed check.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_in_class_initializer_non_constant)), 
              Init.getSourceRange()));
          VDecl.setInvalidDecl();
        } finally {
          $c$.$destroy();
        }
      }
      // We allow foldable floating-point constants as an extension.
    } else if (DclT.$arrow().isFloatingType()) { // also permits complex, which is ok
// In C++98, this is a GNU extension. In C++11, it is not, but we support
// it anyway and provide a fixit to add the 'constexpr'.
      if ($this().getLangOpts().CPlusPlus11) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(VDecl.getLocation(), 
                      diag.ext_in_class_initializer_float_type_cxx11)), 
                  DclT), Init.getSourceRange()));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(VDecl.getLocStart(), 
                  diag.note_in_class_initializer_float_type_cxx11)), 
              FixItHint.CreateInsertion(VDecl.getLocStart(), new StringRef(/*KEEP_STR*/"constexpr "))));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(VDecl.getLocation(), diag.ext_in_class_initializer_float_type)), 
                  DclT), Init.getSourceRange()));
          if (!Init.isValueDependent() && !Init.isEvaluatable($this().Context)) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Init.getExprLoc(), diag.err_in_class_initializer_non_constant)), 
                Init.getSourceRange()));
            VDecl.setInvalidDecl();
          }
        } finally {
          $c$.$destroy();
        }
      }
      // Suggest adding 'constexpr' in C++11 for literal types.
    } else if ($this().getLangOpts().CPlusPlus11 && DclT.$arrow().isLiteralType($this().Context)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(VDecl.getLocation(), diag.err_in_class_initializer_literal_type)), 
                    DclT), Init.getSourceRange()), 
            FixItHint.CreateInsertion(VDecl.getLocStart(), new StringRef(/*KEEP_STR*/"constexpr "))));
        VDecl.setConstexpr(true);
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(VDecl.getLocation(), diag.err_in_class_initializer_bad_type)), 
                DclT), Init.getSourceRange()));
        VDecl.setInvalidDecl();
      } finally {
        $c$.$destroy();
      }
    }
  } else if (VDecl.isFileVarDecl()) {
    if (VDecl.getStorageClass() == StorageClass.SC_Extern
       && (!$this().getLangOpts().CPlusPlus
       || !($this().Context.getBaseElementType(VDecl.getType()).isConstQualified()
       || VDecl.isExternC()))
       && !isTemplateInstantiation(VDecl.getTemplateSpecializationKind())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(VDecl.getLocation(), diag.warn_extern_init)));
      } finally {
        $c$.$destroy();
      }
    }
    
    // C99 6.7.8p4. All file scoped initializers need to be constant.
    if (!$this().getLangOpts().CPlusPlus && !VDecl.isInvalidDecl()) {
      $this().CheckForConstantInitializer(Init, new QualType(DclT));
    }
  }
  
  // We will represent direct-initialization similarly to copy-initialization:
  //    int x(1);  -as-> int x = 1;
  //    ClassType x(a,b,c); -as-> ClassType x = ClassType(a,b,c);
  //
  // Clients that want to distinguish between the two forms, can check for
  // direct initializer using VarDecl::getInitStyle().
  // A major benefit is that clients that don't particularly care about which
  // exactly form was it (like the CodeGen) can handle both cases without
  // special case code.
  
  // C++ 8.5p11:
  // The form of initialization (using parentheses or '=') is generally
  // insignificant, but does matter when the entity being initialized has a
  // class type.
  if ((CXXDirectInit != null)) {
    assert (DirectInit) : "Call-style initializer must be direct init.";
    VDecl.setInitStyle(VarDecl.InitializationStyle.CallInit);
  } else if (DirectInit) {
    // This must be list-initialization. No other way is direct-initialization.
    VDecl.setInitStyle(VarDecl.InitializationStyle.ListInit);
  }
  
  $this().CheckCompleteVariableDeclaration(VDecl);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnUninitializedDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9988,
 FQN="clang::Sema::ActOnUninitializedDecl", NM="_ZN5clang4Sema22ActOnUninitializedDeclEPNS_4DeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema22ActOnUninitializedDeclEPNS_4DeclEb")
//</editor-fold>
public final void ActOnUninitializedDecl(Decl /*P*/ RealDecl, 
                      boolean TypeMayContainAuto) {
  // If there is no declaration, there was an error parsing it. Just ignore it.
  if (!(RealDecl != null)) {
    return;
  }
  {
    
    VarDecl /*P*/ Var = dyn_cast_VarDecl(RealDecl);
    if ((Var != null)) {
      InitializationSequence InitSeq = null;
      try {
        QualType Type = Var.getType();
        
        // C++11 [dcl.spec.auto]p3
        if (TypeMayContainAuto && (Type.$arrow().getContainedAutoType() != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Var.getLocation(), diag.err_auto_var_requires_init)), 
                    Var.getDeclName()), Type));
            Var.setInvalidDecl();
            return;
          } finally {
            $c$.$destroy();
          }
        }
        
        // C++11 [class.static.data]p3: A static data member can be declared with
        // the constexpr specifier; if so, its declaration shall specify
        // a brace-or-equal-initializer.
        // C++11 [dcl.constexpr]p1: The constexpr specifier shall be applied only to
        // the definition of a variable [...] or the declaration of a static data
        // member.
        if (Var.isConstexpr() && !(Var.isThisDeclarationADefinition().getValue() != 0)) {
          if (Var.isStaticDataMember()) {
            // C++1z removes the relevant rule; the in-class declaration is always
            // a definition there.
            if (!$this().getLangOpts().CPlusPlus1z) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Var.getLocation(), 
                        diag.err_constexpr_static_mem_var_requires_init)), 
                    Var.getDeclName()));
                Var.setInvalidDecl();
                return;
              } finally {
                $c$.$destroy();
              }
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(Var.getLocation(), diag.err_invalid_constexpr_var_decl)));
              Var.setInvalidDecl();
              return;
            } finally {
              $c$.$destroy();
            }
          }
        }
        {
          
          // C++ Concepts TS [dcl.spec.concept]p1: [...]  A variable template
          // definition having the concept specifier is called a variable concept. A
          // concept definition refers to [...] a variable concept and its initializer.
          VarTemplateDecl /*P*/ VTD = Var.getDescribedVarTemplate();
          if ((VTD != null)) {
            if (VTD.isConcept()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track($this().Diag(Var.getLocation(), diag.err_var_concept_not_initialized)));
                Var.setInvalidDecl();
                return;
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
        
        // OpenCL v1.1 s6.5.3: variables declared in the constant address space must
        // be initialized.
        if (!Var.isInvalidDecl()
           && Var.getType().getAddressSpace() == LangAS.ID.opencl_constant
           && Var.getStorageClass() != StorageClass.SC_Extern && !(Var.getInit() != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(Var.getLocation(), diag.err_opencl_constant_no_init)));
            Var.setInvalidDecl();
            return;
          } finally {
            $c$.$destroy();
          }
        }
        switch (Var.isThisDeclarationADefinition()) {
         case Definition:
          if (!Var.isStaticDataMember() || !(Var.getAnyInitializer() != null)) {
            break;
          }
         case DeclarationOnly:
          // It's only a declaration.
          
          // Block scope. C99 6.7p7: If an identifier for an object is
          // declared with no linkage (C99 6.2.2p6), the type for the
          // object shall be complete.
          if (!Type.$arrow().isDependentType() && Var.isLocalVarDecl()
             && !Var.hasLinkage() && !Var.isInvalidDecl()
             && $this().RequireCompleteType(Var.getLocation(), new QualType(Type), 
              diag.err_typecheck_decl_incomplete_type)) {
            Var.setInvalidDecl();
          }
          
          // Make sure that the type is not abstract.
          if (!Type.$arrow().isDependentType() && !Var.isInvalidDecl()
             && $this().RequireNonAbstractType$T(Var.getLocation(), new QualType(Type), 
              diag.err_abstract_type_in_decl, 
              AbstractDiagSelID.AbstractVariableType)) {
            Var.setInvalidDecl();
          }
          if (!Type.$arrow().isDependentType() && !Var.isInvalidDecl()
             && Var.getStorageClass() == StorageClass.SC_PrivateExtern) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(Var.getLocation(), diag.warn_private_extern)));
              $c$.clean($c$.track($this().Diag(Var.getLocation(), diag.note_private_extern)));
            } finally {
              $c$.$destroy();
            }
          }
          
          return;
         case TentativeDefinition:
          // File scope. C99 6.9.2p2: A declaration of an identifier for an
          // object that has file scope without an initializer, and without a
          // storage-class specifier or with the storage-class specifier "static",
          // constitutes a tentative definition. Note: A tentative definition with
          // external linkage is valid (C99 6.2.2p5).
          if (!Var.isInvalidDecl()) {
            {
              /*const*/ IncompleteArrayType /*P*/ ArrayT = $this().Context.getAsIncompleteArrayType(new QualType(Type));
              if ((ArrayT != null)) {
                if ($this().RequireCompleteType(Var.getLocation(), 
                    ArrayT.getElementType(), 
                    diag.err_illegal_decl_array_incomplete_type)) {
                  Var.setInvalidDecl();
                }
              } else if (Var.getStorageClass() == StorageClass.SC_Static) {
                // C99 6.9.2p3: If the declaration of an identifier for an object is
                // a tentative definition and has internal linkage (C99 6.2.2p3), the
                // declared type shall not be an incomplete type.
                // NOTE: code such as the following
                //     static struct s;
                //     struct s { int a; };
                // is accepted by gcc. Hence here we issue a warning instead of
                // an error and we do not invalidate the static declaration.
                // NOTE: to avoid multiple warnings, only check the first declaration.
                if (Var.isFirstDecl$Redeclarable()) {
                  $this().RequireCompleteType(Var.getLocation(), new QualType(Type), 
                      diag.ext_typecheck_decl_incomplete_type);
                }
              }
            }
          }
          
          // Record the tentative definition; we're done.
          if (!Var.isInvalidDecl()) {
            $this().TentativeDefinitions.push_back(Var);
          }
          return;
        }
        
        // Provide a specific diagnostic for uninitialized variable
        // definitions with incomplete array type.
        if (Type.$arrow().isIncompleteArrayType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(Var.getLocation(), 
                diag.err_typecheck_incomplete_array_needs_initializer)));
            Var.setInvalidDecl();
            return;
          } finally {
            $c$.$destroy();
          }
        }
        
        // Provide a specific diagnostic for uninitialized variable
        // definitions with reference type.
        if (Type.$arrow().isReferenceType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag(Var.getLocation(), diag.err_reference_var_requires_init)), 
                    Var.getDeclName()), 
                new SourceRange(Var.getLocation(), Var.getLocation())));
            Var.setInvalidDecl();
            return;
          } finally {
            $c$.$destroy();
          }
        }
        
        // Do not attempt to type-check the default initializer for a
        // variable with dependent type.
        if (Type.$arrow().isDependentType()) {
          return;
        }
        if (Var.isInvalidDecl()) {
          return;
        }
        if (!Var.hasAttr(AliasAttr.class)) {
          if ($this().RequireCompleteType(Var.getLocation(), 
              $this().Context.getBaseElementType(new QualType(Type)), 
              diag.err_typecheck_decl_incomplete_type)) {
            Var.setInvalidDecl();
            return;
          }
        } else {
          return;
        }
        
        // The variable can not have an abstract class type.
        if ($this().RequireNonAbstractType$T(Var.getLocation(), new QualType(Type), 
            diag.err_abstract_type_in_decl, 
            AbstractDiagSelID.AbstractVariableType)) {
          Var.setInvalidDecl();
          return;
        }
        
        // Check for jumps past the implicit initializer.  C++0x
        // clarifies that this applies to a "variable with automatic
        // storage duration", not a "local variable".
        // C++11 [stmt.dcl]p3
        //   A program that jumps from a point where a variable with automatic
        //   storage duration is not in scope to a point where it is in scope is
        //   ill-formed unless the variable has scalar type, class type with a
        //   trivial default constructor and a trivial destructor, a cv-qualified
        //   version of one of these types, or an array of one of the preceding
        //   types and is declared without an initializer.
        if ($this().getLangOpts().CPlusPlus && Var.hasLocalStorage()) {
          {
            /*const*/ RecordType /*P*/ Record = $this().Context.getBaseElementType(new QualType(Type)).$arrow().getAs$RecordType();
            if ((Record != null)) {
              CXXRecordDecl /*P*/ CXXRecord = cast_CXXRecordDecl(Record.getDecl());
              // Mark the function for further checking even if the looser rules of
              // C++11 do not require such checks, so that we can diagnose
              // incompatibilities with C++98.
              if (!CXXRecord.isPOD()) {
                $this().getCurFunction().setHasBranchProtectedScope();
              }
            }
          }
        }
        
        // C++03 [dcl.init]p9:
        //   If no initializer is specified for an object, and the
        //   object is of (possibly cv-qualified) non-POD class type (or
        //   array thereof), the object shall be default-initialized; if
        //   the object is of const-qualified type, the underlying class
        //   type shall have a user-declared default
        //   constructor. Otherwise, if no initializer is specified for
        //   a non- static object, the object and its subobjects, if
        //   any, have an indeterminate initial value); if the object
        //   or any of its subobjects are of const-qualified type, the
        //   program is ill-formed.
        // C++0x [dcl.init]p11:
        //   If no initializer is specified for an object, the object is
        //   default-initialized; [...].
        InitializedEntity Entity = InitializedEntity.InitializeVariable(Var);
        InitializationKind Kind = InitializationKind.CreateDefault(Var.getLocation());
        
        InitSeq/*J*/= new InitializationSequence(/*Deref*/$this(), Entity, Kind, MutableArrayRef.<Expr /*P*/ >None());
        ActionResultTTrue<Expr /*P*/ > Init = InitSeq.Perform(/*Deref*/$this(), Entity, Kind, MutableArrayRef.<Expr /*P*/ >None());
        if (Init.isInvalid()) {
          Var.setInvalidDecl();
        } else if ((Init.get() != null)) {
          Var.setInit($this().MaybeCreateExprWithCleanups(Init.get()));
          // This is important for template substitution.
          Var.setInitStyle(VarDecl.InitializationStyle.CallInit);
        }
        
        $this().CheckCompleteVariableDeclaration(Var);
      } finally {
        if (InitSeq != null) { InitSeq.$destroy(); }
      }
    }
  }
}


/// ActOnInitializerError - Given that there was an error parsing an
/// initializer for the given declaration, try to return to some form
/// of sanity.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnInitializerError">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9951,
 FQN="clang::Sema::ActOnInitializerError", NM="_ZN5clang4Sema21ActOnInitializerErrorEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema21ActOnInitializerErrorEPNS_4DeclE")
//</editor-fold>
public final void ActOnInitializerError(Decl /*P*/ D) {
  // Our main concern here is re-establishing invariants like "a
  // variable's type is either dependent or complete".
  if (!(D != null) || D.isInvalidDecl()) {
    return;
  }
  
  VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
  if (!(VD != null)) {
    return;
  }
  
  // Auto types are meaningless if we can't make sense of the initializer.
  if (($this().ParsingInitForAutoVars.count(D) != 0)) {
    D.setInvalidDecl();
    return;
  }
  
  QualType Ty = VD.getType();
  if (Ty.$arrow().isDependentType()) {
    return;
  }
  
  // Require a complete type.
  if ($this().RequireCompleteType(VD.getLocation(), 
      $this().Context.getBaseElementType(new QualType(Ty)), 
      diag.err_typecheck_decl_incomplete_type)) {
    VD.setInvalidDecl();
    return;
  }
  
  // Require a non-abstract type.
  if ($this().RequireNonAbstractType$T(VD.getLocation(), new QualType(Ty), 
      diag.err_abstract_type_in_decl, 
      AbstractDiagSelID.AbstractVariableType)) {
    VD.setInvalidDecl();
    return;
  }
  // Don't bother complaining about constructors or destructors,
  // though.
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXForRangeDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 10222,
 FQN="clang::Sema::ActOnCXXForRangeDecl", NM="_ZN5clang4Sema20ActOnCXXForRangeDeclEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema20ActOnCXXForRangeDeclEPNS_4DeclE")
//</editor-fold>
public final void ActOnCXXForRangeDecl(Decl /*P*/ D) {
  // If there is no declaration, there was an error parsing it. Ignore it.
  if (!(D != null)) {
    return;
  }
  
  VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
  if (!(VD != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(D.getLocation(), diag.err_for_range_decl_must_be_var)));
      D.setInvalidDecl();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  VD.setCXXForRangeDecl(true);
  
  // for-range-declaration cannot be given a storage class specifier.
  int Error = -1;
  switch (VD.getStorageClass()) {
   case SC_None:
    break;
   case SC_Extern:
    Error = 0;
    break;
   case SC_Static:
    Error = 1;
    break;
   case SC_PrivateExtern:
    Error = 2;
    break;
   case SC_Auto:
    Error = 3;
    break;
   case SC_Register:
    Error = 4;
    break;
  }
  if (Error != -1) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(VD.getOuterLocStart(), diag.err_for_range_storage_class)), 
              VD.getDeclName()), Error));
      D.setInvalidDecl();
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXForRangeIdentifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 10264,
 FQN="clang::Sema::ActOnCXXForRangeIdentifier", NM="_ZN5clang4Sema26ActOnCXXForRangeIdentifierEPNS_5ScopeENS_14SourceLocationEPNS_14IdentifierInfoERNS_16ParsedAttributesES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema26ActOnCXXForRangeIdentifierEPNS_5ScopeENS_14SourceLocationEPNS_14IdentifierInfoERNS_16ParsedAttributesES3_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnCXXForRangeIdentifier(Scope /*P*/ S, SourceLocation IdentLoc, 
                          IdentifierInfo /*P*/ Ident, 
                          final ParsedAttributes /*&*/ Attrs, 
                          SourceLocation AttrEnd) {
  DeclSpec DS = null;
  Declarator D = null;
  ParsedAttributes EmptyAttrs = null;
  try {
    // C++1y [stmt.iter]p1:
    //   A range-based for statement of the form
    //      for ( for-range-identifier : for-range-initializer ) statement
    //   is equivalent to
    //      for ( auto&& for-range-identifier : for-range-initializer ) statement
    DS/*J*/= new DeclSpec(Attrs.getPool().getFactory());
    
    /*const*/char$ptr/*char P*/ PrevSpec = create_char$ptr();
    uint$ref DiagID = create_uint$ref();
    DS.SetTypeSpecType(DeclSpec.TST_auto, new SourceLocation(IdentLoc), PrevSpec, DiagID, 
        $this().getPrintingPolicy());
    
    D/*J*/= new Declarator(DS, Declarator.TheContext.ForContext);
    D.SetIdentifier(Ident, new SourceLocation(IdentLoc));
    D.takeAttributes(Attrs, new SourceLocation(AttrEnd));
    
    EmptyAttrs/*J*/= new ParsedAttributes(Attrs.getPool().getFactory());
    D.AddTypeInfo(DeclaratorChunk.getReference(0, new SourceLocation(IdentLoc), /*lvalue*/ false), 
        EmptyAttrs, new SourceLocation(IdentLoc));
    Decl /*P*/ Var = $this().ActOnDeclarator(S, D);
    cast_VarDecl(Var).setCXXForRangeDecl(true);
    $this().FinalizeDeclaration(Var);
    return $this().ActOnDeclStmt($this().FinalizeDeclaratorGroup(S, DS, new ArrayRef<Decl /*P*/ >(Var, true)), new SourceLocation(IdentLoc), 
        new SourceLocation(AttrEnd.isValid() ? AttrEnd : IdentLoc));
  } finally {
    if (EmptyAttrs != null) { EmptyAttrs.$destroy(); }
    if (D != null) { D.$destroy(); }
    if (DS != null) { DS.$destroy(); }
  }
}


/// FinalizeDeclaration - called by ParseDeclarationAfterDeclarator to perform
/// any semantic actions necessary after any initializer has been attached.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FinalizeDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 10490,
 FQN="clang::Sema::FinalizeDeclaration", NM="_ZN5clang4Sema19FinalizeDeclarationEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema19FinalizeDeclarationEPNS_4DeclE")
//</editor-fold>
public final void FinalizeDeclaration(Decl /*P*/ ThisDecl) {
  // Note that we are no longer parsing the initializer for this declaration.
  $this().ParsingInitForAutoVars.erase(ThisDecl);
  
  VarDecl /*P*/ VD = dyn_cast_or_null_VarDecl(ThisDecl);
  if (!(VD != null)) {
    return;
  }
  
  checkAttributesAfterMerging(/*Deref*/$this(), $Deref(VD));
  {
    
    // Perform TLS alignment check here after attributes attached to the variable
    // which may affect the alignment have been processed. Only perform the check
    // if the target has a maximum TLS alignment (zero means no constraints).
    /*uint*/int MaxAlign = $ushort2uint($this().Context.getTargetInfo().getMaxTLSAlign());
    if ((MaxAlign != 0)) {
      // Protect the check so that it's not performed on dependent types and
      // dependent alignments (we can't determine the alignment in that case).
      if ((VD.getTLSKind().getValue() != 0) && !hasDependentAlignment(VD)) {
        CharUnits MaxAlignChars = $this().Context.toCharUnitsFromBits($uint2long(MaxAlign));
        if ($this().Context.getDeclAlign(VD).$greater(MaxAlignChars)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(VD.getLocation(), diag.err_tls_var_aligned_over_maximum)), 
                        (/*uint*/int)$long2uint($this().Context.getDeclAlign(VD).getQuantity())), VD), 
                (/*uint*/int)$long2uint(MaxAlignChars.getQuantity())));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  if (VD.isStaticLocal()) {
    {
      FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(VD.getParentFunctionOrMethod());
      if ((FD != null)) {
        {
          // Static locals inherit dll attributes from their function.
          Attr /*P*/ A = getDLLAttr(FD);
          if ((A != null)) {
            InheritableAttr /*P*/ NewAttr = cast_InheritableAttr(A.clone($this().getASTContext()));
            NewAttr.setInherited(true);
            VD.addAttr(NewAttr);
          }
        }
        // CUDA E.2.9.4: Within the body of a __device__ or __global__
        // function, only __shared__ variables may be declared with
        // static storage class.
        if ($this().getLangOpts().CUDA && $this().getLangOpts().CUDAIsDevice
           && (FD.hasAttr(CUDADeviceAttr.class) || FD.hasAttr(CUDAGlobalAttr.class))
           && !VD.hasAttr(CUDASharedAttr.class)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(VD.getLocation(), diag.err_device_static_local_var)));
            VD.setInvalidDecl();
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  
  // Perform check for initializers of device-side global variables.
  // CUDA allows empty constructors as initializers (see E.2.3.1, CUDA
  // 7.5). We must also apply the same checks to all __shared__
  // variables whether they are local or not. CUDA also allows
  // constant initializers for __constant__ and __device__ variables.
  if ($this().getLangOpts().CUDA && $this().getLangOpts().CUDAIsDevice) {
    /*const*/ Expr /*P*/ Init = VD.getInit();
    if ((Init != null) && VD.hasGlobalStorage()
       && (VD.hasAttr(CUDADeviceAttr.class) || VD.hasAttr(CUDAConstantAttr.class)
       || VD.hasAttr(CUDASharedAttr.class))) {
      assert (!VD.isStaticLocal() || VD.hasAttr(CUDASharedAttr.class));
      boolean AllowedInit = false;
      {
        /*const*/ CXXConstructExpr /*P*/ CE = dyn_cast_CXXConstructExpr(Init);
        if ((CE != null)) {
          AllowedInit
             = $this().isEmptyCudaConstructor(VD.getLocation(), CE.getConstructor());
        }
      }
      // We'll allow constant initializers even if it's a non-empty
      // constructor according to CUDA rules. This deviates from NVCC,
      // but allows us to handle things like constexpr constructors.
      if (!AllowedInit
         && (VD.hasAttr(CUDADeviceAttr.class) || VD.hasAttr(CUDAConstantAttr.class))) {
        AllowedInit = VD.getInit().isConstantInitializer($this().Context, VD.getType().$arrow().isReferenceType());
      }
      
      // Also make sure that destructor, if there is one, is empty.
      if (AllowedInit) {
        {
          CXXRecordDecl /*P*/ RD = VD.getType().$arrow().getAsCXXRecordDecl();
          if ((RD != null)) {
            AllowedInit
               = $this().isEmptyCudaDestructor(VD.getLocation(), RD.getDestructor());
          }
        }
      }
      if (!AllowedInit) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(VD.getLocation(), VD.hasAttr(CUDASharedAttr.class) ? diag.err_shared_var_init : diag.err_dynamic_var_init)), 
              Init.getSourceRange()));
          VD.setInvalidDecl();
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // Grab the dllimport or dllexport attribute off of the VarDecl.
  /*const*/ InheritableAttr /*P*/ DLLAttr = getDLLAttr(VD);
  {
    
    // Imported static data members cannot be defined out-of-line.
    /*const*/ DLLImportAttr /*P*/ IA = dyn_cast_or_null_DLLImportAttr(DLLAttr);
    if ((IA != null)) {
      if (VD.isStaticDataMember() && VD.isOutOfLine()
         && (VD.isThisDeclarationADefinition().getValue() != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // We allow definitions of dllimport class template static data members
          // with a warning.
          CXXRecordDecl /*P*/ Context = cast_CXXRecordDecl(VD.getFirstDecl().getDeclContext());
          boolean IsClassTemplateMember = isa_ClassTemplatePartialSpecializationDecl(Context)
             || (Context.getDescribedClassTemplate() != null);
          
          $c$.clean($c$.track($this().Diag(VD.getLocation(), 
              IsClassTemplateMember ? diag.warn_attribute_dllimport_static_field_definition : diag.err_attribute_dllimport_static_field_definition)));
          $c$.clean($c$.track($this().Diag(IA.getLocation(), diag.note_attribute)));
          if (!IsClassTemplateMember) {
            VD.setInvalidDecl();
          }
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // dllimport/dllexport variables cannot be thread local, their TLS index
  // isn't exported with the variable.
  if ((DLLAttr != null) && (VD.getTLSKind().getValue() != 0)) {
    FunctionDecl /*P*/ F = dyn_cast_or_null_FunctionDecl(VD.getParentFunctionOrMethod());
    if ((F != null) && (getDLLAttr(F) != null)) {
      assert (VD.isStaticLocal());
      // But if this is a static local in a dlimport/dllexport function, the
      // function will never be inlined, which means the var would never be
      // imported, so having it marked import/export is safe.
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(VD.getLocation(), diag.err_attribute_dll_thread_local)), VD), 
            DLLAttr));
        VD.setInvalidDecl();
      } finally {
        $c$.$destroy();
      }
    }
  }
  {
    
    UsedAttr /*P*/ Attr = VD.getAttr(UsedAttr.class);
    if ((Attr != null)) {
      if (!Attr.isInherited() && !(VD.isThisDeclarationADefinition().getValue() != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Attr.getLocation(), diag.warn_attribute_ignored)), Attr));
          VD.dropAttr(UsedAttr.class);
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  /*const*/ DeclContext /*P*/ DC = VD.getDeclContext();
  // If there's a #pragma GCC visibility in scope, and this isn't a class
  // member, set the visibility of this variable.
  if (DC.getRedeclContext$Const().isFileContext() && VD.isExternallyVisible()) {
    $this().AddPushedVisibilityAttribute(VD);
  }
  
  // FIXME: Warn on unused templates.
  if (VD.isFileVarDecl() && !(VD.getDescribedVarTemplate() != null)
     && !isa_VarTemplatePartialSpecializationDecl(VD)) {
    $this().MarkUnusedFileScopedDecl(VD);
  }
  
  // Now we have parsed the initializer and can update the table of magic
  // tag values.
  if (!VD.hasAttr(TypeTagForDatatypeAttr.class)
     || !VD.getType().$arrow().isIntegralOrEnumerationType()) {
    return;
  }
  
  for (/*const*/ TypeTagForDatatypeAttr /*P*/ I : ThisDecl.specific_attrs(TypeTagForDatatypeAttr.class)) {
    /*const*/ Expr /*P*/ MagicValueExpr = VD.getInit();
    if (!(MagicValueExpr != null)) {
      continue;
    }
    APSInt MagicValueInt/*J*/= new APSInt();
    if (!MagicValueExpr.isIntegerConstantExpr(MagicValueInt, $this().Context)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(I.getRange().getBegin(), 
                    diag.err_type_tag_for_datatype_not_ice)), 
                $this().LangOpts.CPlusPlus), MagicValueExpr.getSourceRange()));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    if ($greater_uint(MagicValueInt.getActiveBits(), 64)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(I.getRange().getBegin(), 
                    diag.err_type_tag_for_datatype_too_large)), 
                $this().LangOpts.CPlusPlus), MagicValueExpr.getSourceRange()));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    long/*uint64_t*/ MagicValue = MagicValueInt.getZExtValue();
    $this().RegisterTypeTagForDatatype(I.getArgumentKind(), 
        MagicValue, 
        I.getMatchingCType(), 
        I.getLayoutCompatible(), 
        I.getMustBeNull());
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::FinalizeDeclaratorGroup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 10669,
 FQN="clang::Sema::FinalizeDeclaratorGroup", NM="_ZN5clang4Sema23FinalizeDeclaratorGroupEPNS_5ScopeERKNS_8DeclSpecEN4llvm8ArrayRefIPNS_4DeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema23FinalizeDeclaratorGroupEPNS_5ScopeERKNS_8DeclSpecEN4llvm8ArrayRefIPNS_4DeclEEE")
//</editor-fold>
public final OpaquePtr<DeclGroupRef> FinalizeDeclaratorGroup(Scope /*P*/ S, final /*const*/ DeclSpec /*&*/ DS, 
                       ArrayRef<Decl /*P*/ > Group) {
  SmallVector<Decl /*P*/> Decls/*J*/= new SmallVector<Decl /*P*/>(8, null);
  if (DS.isTypeSpecOwned()) {
    Decls.push_back(DS.getRepAsDecl());
  }
  
  DeclaratorDecl /*P*/ FirstDeclaratorInGroup = null;
  for (/*uint*/int i = 0, e = Group.size(); i != e; ++i)  {
    {
      Decl /*P*/ D = Group.$at(i);
      if ((D != null)) {
        {
          DeclaratorDecl /*P*/ DD = dyn_cast_DeclaratorDecl(D);
          if ((DD != null)) {
            if (!(FirstDeclaratorInGroup != null)) {
              FirstDeclaratorInGroup = DD;
            }
          }
        }
        Decls.push_back(D);
      }
    }
  }
  if (DeclSpec.isDeclRep(DS.getTypeSpecType())) {
    {
      TagDecl /*P*/ Tag = dyn_cast_or_null_TagDecl(DS.getRepAsDecl());
      if ((Tag != null)) {
        $this().handleTagNumbering(Tag, S);
        if ((FirstDeclaratorInGroup != null) && !Tag.hasNameForLinkage()
           && $this().getLangOpts().CPlusPlus) {
          $this().Context.addDeclaratorForUnnamedTagDecl(Tag, FirstDeclaratorInGroup);
        }
      }
    }
  }
  
  return $this().BuildDeclaratorGroup(new MutableArrayRef<Decl /*P*/ >(Decls, true), DS.containsPlaceholderType());
}


/// BuildDeclaratorGroup - convert a list of declarations into a declaration
/// group, performing any necessary semantic checking.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildDeclaratorGroup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 10699,
 FQN="clang::Sema::BuildDeclaratorGroup", NM="_ZN5clang4Sema20BuildDeclaratorGroupEN4llvm15MutableArrayRefIPNS_4DeclEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema20BuildDeclaratorGroupEN4llvm15MutableArrayRefIPNS_4DeclEEEb")
//</editor-fold>
public final OpaquePtr<DeclGroupRef> BuildDeclaratorGroup(MutableArrayRef<Decl /*P*/ > Group) {
  return BuildDeclaratorGroup(Group, 
                    true);
}
public final OpaquePtr<DeclGroupRef> BuildDeclaratorGroup(MutableArrayRef<Decl /*P*/ > Group, 
                    boolean TypeMayContainAuto/*= true*/) {
  // C++0x [dcl.spec.auto]p7:
  //   If the type deduced for the template parameter U is not the same in each
  //   deduction, the program is ill-formed.
  // FIXME: When initializer-list support is added, a distinction is needed
  // between the deduced type U and the deduced type which 'auto' stands for.
  //   auto a = 0, b = { 1, 2, 3 };
  // is legal because the deduced type U is 'int' in both cases.
  if (TypeMayContainAuto && $greater_uint(Group.size(), 1)) {
    QualType Deduced/*J*/= new QualType();
    CanQual<Type> DeducedCanon/*J*/= new CanQual<Type>();
    VarDecl /*P*/ DeducedDecl = null;
    for (/*uint*/int i = 0, e = Group.size(); i != e; ++i) {
      {
        VarDecl /*P*/ D = dyn_cast_VarDecl(Group.$at(i));
        if ((D != null)) {
          AutoType /*P*/ AT = D.getType().$arrow().getContainedAutoType();
          // Don't reissue diagnostics when instantiating a template.
          if ((AT != null) && D.isInvalidDecl()) {
            break;
          }
          QualType U = (AT != null) ? AT.getDeducedType() : new QualType();
          if (!U.isNull()) {
            CanQual<Type> UCanon = $this().Context.getCanonicalType(/*NO_COPY*/U);
            if (Deduced.isNull()) {
              Deduced.$assign(U);
              DeducedCanon.$assign(UCanon);
              DeducedDecl = D;
            } else if ($noteq_CanQual$T_CanQual$U(/*NO_COPY*/DeducedCanon, /*NO_COPY*/UCanon)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint($c$.track($this().Diag(D.getTypeSourceInfo().getTypeLoc().getBeginLoc(), 
                                                diag.err_auto_different_deductions)), 
                                            ((/*uint*/int)AT.getKeyword().getValue())), 
                                        Deduced), DeducedDecl.getDeclName()), 
                                U), D.getDeclName()), 
                        DeducedDecl.getInit().getSourceRange()), 
                    D.getInit().getSourceRange()));
                D.setInvalidDecl();
                break;
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      }
    }
  }
  
  $this().ActOnDocumentableDecls(new ArrayRef<Decl /*P*/ >(Group));
  
  return OpaquePtr.<DeclGroupRef>make(DeclGroupRef.Create($this().Context, Group.data(), Group.size()));
}


/// Should be called on all declarations that might have attached
/// documentation comments.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnDocumentableDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 10748,
 FQN="clang::Sema::ActOnDocumentableDecl", NM="_ZN5clang4Sema21ActOnDocumentableDeclEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema21ActOnDocumentableDeclEPNS_4DeclE")
//</editor-fold>
public final void ActOnDocumentableDecl(Decl /*P*/ D) {
  $this().ActOnDocumentableDecls(new ArrayRef<Decl /*P*/ >(D, true));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnDocumentableDecls">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 10752,
 FQN="clang::Sema::ActOnDocumentableDecls", NM="_ZN5clang4Sema22ActOnDocumentableDeclsEN4llvm8ArrayRefIPNS_4DeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema22ActOnDocumentableDeclsEN4llvm8ArrayRefIPNS_4DeclEEE")
//</editor-fold>
public final void ActOnDocumentableDecls(ArrayRef<Decl /*P*/ > Group) {
  // Don't parse the comment if Doxygen diagnostics are ignored.
  if (Group.empty() || !(Group.$at(0) != null)) {
    return;
  }
  if ($this().Diags.isIgnored(diag.warn_doc_param_not_found, 
      Group.$at(0).getLocation())
     && $this().Diags.isIgnored(diag.warn_unknown_comment_command_name, 
      Group.$at(0).getLocation())) {
    return;
  }
  if ($greatereq_uint(Group.size(), 2)) {
    // This is a decl group.  Normally it will contain only declarations
    // produced from declarator list.  But in case we have any definitions or
    // additional declaration references:
    //   'typedef struct S {} S;'
    //   'typedef struct S *S;'
    //   'struct S *pS;'
    // FinalizeDeclaratorGroup adds these as separate declarations.
    Decl /*P*/ MaybeTagDecl = Group.$at(0);
    if ((MaybeTagDecl != null) && isa_TagDecl(MaybeTagDecl)) {
      Group.$assignMove(Group.slice(1));
    }
  }
  
  // See if there are any new comments that are not attached to a decl.
  ArrayRef<RawComment /*P*/ > Comments = $this().Context.getRawCommentList().getComments();
  if (!Comments.empty()
     && !Comments.back().isAttached()) {
    // There is at least one comment that not attached to a decl.
    // Maybe it should be attached to one of these decls?
    //
    // Note that this way we pick up not only comments that precede the
    // declaration, but also comments that *follow* the declaration -- thanks to
    // the lookahead in the lexer: we've consumed the semicolon and looked
    // ahead through comments.
    for (/*uint*/int i = 0, e = Group.size(); i != e; ++i)  {
      $this().Context.getCommentForDecl(Group.$at(i), $AddrOf($this().PP));
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFinishKNRParamDeclarations">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 11038,
 FQN="clang::Sema::ActOnFinishKNRParamDeclarations", NM="_ZN5clang4Sema31ActOnFinishKNRParamDeclarationsEPNS_5ScopeERNS_10DeclaratorENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema31ActOnFinishKNRParamDeclarationsEPNS_5ScopeERNS_10DeclaratorENS_14SourceLocationE")
//</editor-fold>
public final void ActOnFinishKNRParamDeclarations(Scope /*P*/ S, final Declarator /*&*/ D, 
                               SourceLocation LocAfterDecls) {
  final DeclaratorChunk.FunctionTypeInfo /*&*/ FTI = D.getFunctionTypeInfo();
  
  // Verify 6.9.1p6: 'every identifier in the identifier list shall be declared'
  // for a K&R function.
  if (!FTI.hasPrototype) {
    for (int i = FTI.NumParams; i != 0;) {
      --i;
      if (FTI.Params.$at(i).Param == null) {
        AttributeFactory attrs = null;
        DeclSpec DS = null;
        Declarator ParamD = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SmallString/*<256>*/ Code/*J*/= new SmallString/*<256>*/(256);
          $c$.clean($c$.track(new raw_svector_ostream(Code)).$out(
              /*KEEP_STR*/"  int "
          ).$out(FTI.Params.$at(i).Ident.getName()).$out(/*KEEP_STR*/";\n"));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(FTI.Params.$at(i).IdentLoc), diag.ext_param_not_declared)), 
                  FTI.Params.$at(i).Ident), 
              FixItHint.CreateInsertion(/*NO_COPY*/LocAfterDecls, Code.$StringRef())));
          
          // Implicitly declare the argument as type 'int' for lack of a better
          // type.
          attrs/*J*/= new AttributeFactory();
          DS/*J*/= new DeclSpec(attrs);
          /*const*/char$ptr/*char P*/ PrevSpec = create_char$ptr(); // unused
          uint$ref DiagID = create_uint$ref(); // unused
          DS.SetTypeSpecType(DeclSpec.TST_int, new SourceLocation(FTI.Params.$at(i).IdentLoc), PrevSpec, 
              DiagID, $this().Context.getPrintingPolicy());
          // Use the identifier location for the type source range.
          DS.SetRangeStart(new SourceLocation(FTI.Params.$at(i).IdentLoc));
          DS.SetRangeEnd(new SourceLocation(FTI.Params.$at(i).IdentLoc));
          ParamD/*J*/= new Declarator(DS, Declarator.TheContext.KNRTypeListContext);
          ParamD.SetIdentifier(FTI.Params.$at(i).Ident, new SourceLocation(FTI.Params.$at(i).IdentLoc));
          FTI.Params.$at(i).Param = $this().ActOnParamDeclarator(S, ParamD);
        } finally {
          if (ParamD != null) { ParamD.$destroy(); }
          if (DS != null) { DS.$destroy(); }
          if (attrs != null) { attrs.$destroy(); }
          $c$.$destroy();
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckForFunctionRedefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 11146,
 FQN="clang::Sema::CheckForFunctionRedefinition", NM="_ZN5clang4Sema28CheckForFunctionRedefinitionEPNS_12FunctionDeclEPKS1_PNS0_12SkipBodyInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema28CheckForFunctionRedefinitionEPNS_12FunctionDeclEPKS1_PNS0_12SkipBodyInfoE")
//</editor-fold>
public final void CheckForFunctionRedefinition(FunctionDecl /*P*/ FD) {
  CheckForFunctionRedefinition(FD, 
                            (/*const*/ FunctionDecl /*P*/ )null, 
                            (SkipBodyInfo /*P*/ )null);
}
public final void CheckForFunctionRedefinition(FunctionDecl /*P*/ FD, 
                            /*const*/ FunctionDecl /*P*/ EffectiveDefinition/*= null*/) {
  CheckForFunctionRedefinition(FD, 
                            EffectiveDefinition, 
                            (SkipBodyInfo /*P*/ )null);
}
public final void CheckForFunctionRedefinition(FunctionDecl /*P*/ FD, 
                            /*const*/ FunctionDecl /*P*/ EffectiveDefinition/*= null*/, 
                            SkipBodyInfo /*P*/ SkipBody/*= null*/) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Don't complain if we're in GNU89 mode and the previous definition
    // was an extern inline function.
    type$ref</*const*/ FunctionDecl /*P*/ > Definition = create_type$ref(EffectiveDefinition);
    if (!(Definition.$deref() != null)) {
      if (!FD.isDefined(Definition)) {
        return;
      }
    }
    if (canRedefineFunction(Definition.$deref(), $this().getLangOpts())) {
      return;
    }
    
    // If we don't have a visible definition of the function, and it's inline or
    // a template, skip the new definition.
    if ((SkipBody != null) && !$this().hasVisibleDefinition(Definition.$deref())
       && (Definition.$deref().getFormalLinkage() == Linkage.InternalLinkage
       || Definition.$deref().isInlined()
       || (Definition.$deref().getDescribedFunctionTemplate() != null)
       || (Definition.$deref().getNumTemplateParameterLists() != 0))) {
      SkipBody.ShouldSkip = true;
      {
        FunctionTemplateDecl /*P*/ TD = Definition.$deref().getDescribedFunctionTemplate();
        if ((TD != null)) {
          $this().makeMergedDefinitionVisible(TD, FD.getLocation());
        } else {
          $this().makeMergedDefinitionVisible(((/*const_cast*/FunctionDecl /*P*/ )(Definition.$deref())), 
              FD.getLocation());
        }
      }
      return;
    }
    if ($this().getLangOpts().GNUMode && Definition.$deref().isInlineSpecified()
       && Definition.$deref().getStorageClass() == StorageClass.SC_Extern) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getLocation(), diag.err_redefinition_extern_inline)), 
              FD.getDeclName()), $this().getLangOpts().CPlusPlus));
    } else {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getLocation(), diag.err_redefinition)), FD.getDeclName()));
    }
    
    $c$.clean($c$.track($this().Diag(Definition.$deref().getLocation(), diag.note_previous_definition)));
    FD.setInvalidDecl();
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStartOfFunctionDef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 11074,
 FQN="clang::Sema::ActOnStartOfFunctionDef", NM="_ZN5clang4Sema23ActOnStartOfFunctionDefEPNS_5ScopeERNS_10DeclaratorEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEEPNS0_12SkipBodyInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema23ActOnStartOfFunctionDefEPNS_5ScopeERNS_10DeclaratorEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEEPNS0_12SkipBodyInfoE")
//</editor-fold>
public final Decl /*P*/ ActOnStartOfFunctionDef(Scope /*P*/ FnBodyScope, final Declarator /*&*/ D, 
                       MutableArrayRef<TemplateParameterList /*P*/ > TemplateParameterLists) {
  return ActOnStartOfFunctionDef(FnBodyScope, D, 
                       TemplateParameterLists, 
                       (SkipBodyInfo /*P*/ )null);
}
public final Decl /*P*/ ActOnStartOfFunctionDef(Scope /*P*/ FnBodyScope, final Declarator /*&*/ D, 
                       MutableArrayRef<TemplateParameterList /*P*/ > TemplateParameterLists, 
                       SkipBodyInfo /*P*/ SkipBody/*= null*/) {
  assert ($this().getCurFunctionDecl() == null) : "Function parsing confused";
  assert (D.isFunctionDeclarator()) : "Not a function declarator!";
  Scope /*P*/ ParentScope = FnBodyScope.getParent();
  
  D.setFunctionDefinitionKind(FunctionDefinitionKind.FDK_Definition);
  Decl /*P*/ DP = $this().HandleDeclarator(ParentScope, D, new MutableArrayRef<TemplateParameterList /*P*/ >(TemplateParameterLists));
  return $this().ActOnStartOfFunctionDef(FnBodyScope, DP, SkipBody);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStartOfFunctionDef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 11235,
 FQN="clang::Sema::ActOnStartOfFunctionDef", NM="_ZN5clang4Sema23ActOnStartOfFunctionDefEPNS_5ScopeEPNS_4DeclEPNS0_12SkipBodyInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema23ActOnStartOfFunctionDefEPNS_5ScopeEPNS_4DeclEPNS0_12SkipBodyInfoE")
//</editor-fold>
public final Decl /*P*/ ActOnStartOfFunctionDef(Scope /*P*/ FnBodyScope, Decl /*P*/ D) {
  return ActOnStartOfFunctionDef(FnBodyScope, D, 
                       (SkipBodyInfo /*P*/ )null);
}
public final Decl /*P*/ ActOnStartOfFunctionDef(Scope /*P*/ FnBodyScope, Decl /*P*/ D, 
                       SkipBodyInfo /*P*/ SkipBody/*= null*/) {
  // Clear the last template instantiation error context.
  $this().LastTemplateInstantiationErrorContext.$assignMove(new ActiveTemplateInstantiation());
  if (!(D != null)) {
    return D;
  }
  FunctionDecl /*P*/ FD = null;
  {
    
    FunctionTemplateDecl /*P*/ FunTmpl = dyn_cast_FunctionTemplateDecl(D);
    if ((FunTmpl != null)) {
      FD = FunTmpl.getTemplatedDecl();
    } else {
      FD = cast_FunctionDecl(D);
    }
  }
  
  // See if this is a redefinition.
  if (!FD.isLateTemplateParsed()) {
    $this().CheckForFunctionRedefinition(FD, (/*const*/ FunctionDecl /*P*/ )null, SkipBody);
    
    // If we're skipping the body, we're done. Don't enter the scope.
    if ((SkipBody != null) && SkipBody.ShouldSkip) {
      return D;
    }
  }
  
  // If we are instantiating a generic lambda call operator, push
  // a LambdaScopeInfo onto the function stack.  But use the information
  // that's already been calculated (ActOnLambdaExpr) to prime the current
  // LambdaScopeInfo.
  // When the template operator is being specialized, the LambdaScopeInfo,
  // has to be properly restored so that tryCaptureVariable doesn't try
  // and capture any new variables. In addition when calculating potential
  // captures during transformation of nested lambdas, it is necessary to
  // have the LSI properly restored.
  if (isGenericLambdaCallOperatorSpecialization(FD)) {
    assert (($this().ActiveTemplateInstantiations.size() != 0)) : "There should be an active template instantiation on the stack when instantiating a generic lambda!";
    RebuildLambdaScopeInfo(cast_CXXMethodDecl(D), /*Deref*/$this());
  } else {
    // Enter a new function scope
    $this().PushFunctionScope();
  }
  {
    
    // Builtin functions cannot be defined.
    /*uint*/int BuiltinID = FD.getBuiltinID();
    if ((BuiltinID != 0)) {
      if (!$this().Context.BuiltinInfo.isPredefinedLibFunction(BuiltinID)
         && !$this().Context.BuiltinInfo.isPredefinedRuntimeFunction(BuiltinID)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getLocation(), diag.err_builtin_definition)), FD));
          FD.setInvalidDecl();
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // The return type of a function definition must be complete
  // (C99 6.9.1p3, C++ [dcl.fct]p6).
  QualType ResultType = FD.getReturnType();
  if (!ResultType.$arrow().isDependentType() && !ResultType.$arrow().isVoidType()
     && !FD.isInvalidDecl()
     && $this().RequireCompleteType(FD.getLocation(), new QualType(ResultType), 
      diag.err_func_def_incomplete_result)) {
    FD.setInvalidDecl();
  }
  if ((FnBodyScope != null)) {
    $this().PushDeclContext(FnBodyScope, FD);
  }
  
  // Check the validity of our function parameters
  $this().CheckParmsForFunctionDef(new ArrayRef<ParmVarDecl /*P*/ >(JD$Move.INSTANCE, FD.parameters()), 
      /*CheckParameterNames=*/ true);
  
  // Introduce our parameters into the function scope
  for (ParmVarDecl /*P*/ Param : FD.parameters()) {
    Param.setOwningFunction(FD);
    
    // If this has an identifier, add it to the scope stack.
    if ((Param.getIdentifier() != null) && (FnBodyScope != null)) {
      $this().CheckShadow(FnBodyScope, Param);
      
      $this().PushOnScopeChains(Param, FnBodyScope);
    }
  }
  
  // If we had any tags defined in the function prototype,
  // introduce them into the function scope.
  if ((FnBodyScope != null)) {
    for (type$ptr<NamedDecl /*P*/ /*P*/> I = $tryClone(FD.getDeclsInPrototypeScope().begin()), 
        /*P*/ E = $tryClone(FD.getDeclsInPrototypeScope().end());
         $noteq_ptr(I, E); I.$preInc()) {
      NamedDecl /*P*/ D$1 = I.$star();
      
      // Some of these decls (like enums) may have been pinned to the
      // translation unit for lack of a real context earlier. If so, remove
      // from the translation unit and reattach to the current context.
      if (D$1.getLexicalDeclContext() == $this().Context.getTranslationUnitDecl()) {
        // Is the decl actually in the context?
        if ($this().Context.getTranslationUnitDecl().containsDecl(D$1)) {
          $this().Context.getTranslationUnitDecl().removeDecl(D$1);
        }
        // Either way, reassign the lexical decl context to our FunctionDecl.
        D$1.setLexicalDeclContext($this().CurContext);
      }
      
      // If the decl has a non-null name, make accessible in the current scope.
      if (!D$1.getName().empty()) {
        $this().PushOnScopeChains(D$1, FnBodyScope, /*AddToContext=*/ false);
      }
      {
        
        // Similarly, dive into enums and fish their constants out, making them
        // accessible in this scope.
        EnumDecl /*P*/ ED = dyn_cast_EnumDecl(D$1);
        if ((ED != null)) {
          for (EnumConstantDecl /*P*/ EI : ED.enumerators())  {
            $this().PushOnScopeChains(EI, FnBodyScope, /*AddToContext=*/ false);
          }
        }
      }
    }
  }
  {
    
    // Ensure that the function's exception specification is instantiated.
    /*const*/ FunctionProtoType /*P*/ FPT = FD.getType().$arrow().getAs(FunctionProtoType.class);
    if ((FPT != null)) {
      $this().ResolveExceptionSpec(D.getLocation(), FPT);
    }
  }
  
  // dllimport cannot be applied to non-inline function definitions.
  if (FD.hasAttr(DLLImportAttr.class) && !FD.isInlined()
     && !FD.isTemplateInstantiation()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (!FD.hasAttr(DLLExportAttr.class));
      $c$.clean($c$.track($this().Diag(FD.getLocation(), diag.err_attribute_dllimport_function_definition)));
      FD.setInvalidDecl();
      return D;
    } finally {
      $c$.$destroy();
    }
  }
  // We want to attach documentation to original Decl (which might be
  // a function template).
  $this().ActOnDocumentableDecl(D);
  if ($this().getCurLexicalContext().isObjCContainer()
     && $this().getCurLexicalContext().getDeclKind() != Decl.Kind.ObjCCategoryImpl
     && $this().getCurLexicalContext().getDeclKind() != Decl.Kind.ObjCImplementation) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(FD.getLocation(), diag.warn_function_def_in_objc_container)));
    } finally {
      $c$.$destroy();
    }
  }
  
  return D;
}


/// \brief Determine whether we can delay parsing the body of a function or
/// function template until it is used, assuming we don't care about emitting
/// code for that function.
///
/// This will be \c false if we may need the body of the function in the
/// middle of parsing an expression (where it's impractical to switch to
/// parsing a different function), for instance, if it's constexpr in C++11
/// or has an 'auto' return type in C++14. These cases are essentially bugs.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::canDelayFunctionBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 11393,
 FQN="clang::Sema::canDelayFunctionBody", NM="_ZN5clang4Sema20canDelayFunctionBodyERKNS_10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema20canDelayFunctionBodyERKNS_10DeclaratorE")
//</editor-fold>
public final boolean canDelayFunctionBody(final /*const*/ Declarator /*&*/ D) {
  // We can't delay parsing the body of a constexpr function template (yet).
  if (D.getDeclSpec().isConstexprSpecified()) {
    return false;
  }
  
  // We can't delay parsing the body of a function template with a deduced
  // return type (yet).
  if (D.getDeclSpec().containsPlaceholderType()) {
    // If the placeholder introduces a non-deduced trailing return type,
    // we can still delay parsing it.
    if ((D.getNumTypeObjects() != 0)) {
      final /*const*/ DeclaratorChunk /*&*/ Outer = D.getTypeObject$Const(D.getNumTypeObjects() - 1);
      if (Outer.Kind == DeclaratorChunk.Unnamed_enum.Function
         && Outer.Unnamed_field3.Fun.hasTrailingReturnType()) {
        QualType Ty = GetTypeFromParser(Outer.Unnamed_field3.Fun.getTrailingReturnType());
        return Ty.isNull() || !Ty.$arrow().isUndeducedType();
      }
    }
    return false;
  }
  
  return true;
}


/// \brief Determine whether we can skip parsing the body of a function
/// definition, assuming we don't care about analyzing its body or emitting
/// code for that function.
///
/// This will be \c false only if we may need the body of the function in
/// order to parse the rest of the program (for instance, if it is
/// \c constexpr in C++11 or has an 'auto' return type in C++14).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::canSkipFunctionBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 11417,
 FQN="clang::Sema::canSkipFunctionBody", NM="_ZN5clang4Sema19canSkipFunctionBodyEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema19canSkipFunctionBodyEPNS_4DeclE")
//</editor-fold>
public final boolean canSkipFunctionBody(Decl /*P*/ D) {
  {
    // We cannot skip the body of a function (or function template) which is
    // constexpr, since we may need to evaluate its body in order to parse the
    // rest of the file.
    // We cannot skip the body of a function with an undeduced return type,
    // because any callers of that function need to know the type.
    /*const*/ FunctionDecl /*P*/ FD = D.getAsFunction();
    if ((FD != null)) {
      if (FD.isConstexpr() || FD.getReturnType().$arrow().isUndeducedType()) {
        return false;
      }
    }
  }
  return $this().Consumer.shouldSkipFunctionBody(D);
}


/// \brief Given the set of return statements within a function body,
/// compute the variables that are subject to the named return value
/// optimization.
///
/// Each of the variables that is subject to the named return value
/// optimization will be marked as NRVO variables in the AST, and any
/// return statement that has a marked NRVO variable as its NRVO candidate can
/// use the named return value optimization.
///
/// This function applies a very simplistic algorithm for NRVO: if every return
/// statement in the scope of a variable has the same NRVO candidate, that
/// candidate is an NRVO variable.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::computeNRVO">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 11382,
 FQN="clang::Sema::computeNRVO", NM="_ZN5clang4Sema11computeNRVOEPNS_4StmtEPNS_4sema17FunctionScopeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema11computeNRVOEPNS_4StmtEPNS_4sema17FunctionScopeInfoE")
//</editor-fold>
public final void computeNRVO(Stmt /*P*/ Body, FunctionScopeInfo /*P*/ Scope) {
  type$ptr<ReturnStmt /*P*/ /*P*/> Returns = Scope.Returns.data();
  
  for (/*uint*/int I = 0, E = Scope.Returns.size(); I != E; ++I) {
    {
      /*const*/ VarDecl /*P*/ NRVOCandidate = Returns.$at(I).getNRVOCandidate();
      if ((NRVOCandidate != null)) {
        if (!NRVOCandidate.isNRVOVariable()) {
          Returns.$at(I).setNRVOCandidate((/*const*/ VarDecl /*P*/ )null);
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFinishFunctionBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 11437,
 FQN="clang::Sema::ActOnFinishFunctionBody", NM="_ZN5clang4Sema23ActOnFinishFunctionBodyEPNS_4DeclEPNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema23ActOnFinishFunctionBodyEPNS_4DeclEPNS_4StmtE")
//</editor-fold>
public final Decl /*P*/ ActOnFinishFunctionBody(Decl /*P*/ D, Stmt /*P*/ BodyArg) {
  return $this().ActOnFinishFunctionBody(D, BodyArg, false);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFinishFunctionBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 11441,
 FQN="clang::Sema::ActOnFinishFunctionBody", NM="_ZN5clang4Sema23ActOnFinishFunctionBodyEPNS_4DeclEPNS_4StmtEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema23ActOnFinishFunctionBodyEPNS_4DeclEPNS_4StmtEb")
//</editor-fold>
public final Decl /*P*/ ActOnFinishFunctionBody(Decl /*P*/ dcl, Stmt /*P*/ _Body, 
                       boolean IsInstantiation) {
  type$ref<Stmt> Body = create_type$ref(_Body);
  FunctionDecl /*P*/ FD = (dcl != null) ? dcl.getAsFunction() : null;
  
  AnalysisBasedWarnings.Policy WP = $this().AnalysisWarnings.getDefaultPolicy();
  AnalysisBasedWarnings.Policy /*P*/ ActivePolicy = null;
  if ($this().getLangOpts().Coroutines && !$this().getCurFunction().CoroutineStmts.empty()) {
    $this().CheckCompletedCoroutineBody(FD, Body);
  }
  if ((FD != null)) {
    FD.setBody(Body.$deref());
    if ($this().getLangOpts().CPlusPlus14) {
      if (!FD.isInvalidDecl() && (Body.$deref() != null) && !FD.isDependentContext()
         && FD.getReturnType().$arrow().isUndeducedType()) {
        // If the function has a deduced result type but contains no 'return'
        // statements, the result type as written must be exactly 'auto', and
        // the deduced result type is 'void'.
        if (!(FD.getReturnType().$arrow().getAs(AutoType.class) != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(dcl.getLocation(), diag.err_auto_fn_no_return_but_not_auto)), 
                FD.getReturnType()));
            FD.setInvalidDecl();
          } finally {
            $c$.$destroy();
          }
        } else {
          // Substitute 'void' for the 'auto' in the type.
          TypeLoc ResultType = $this().getReturnTypeLoc(FD);
          $this().Context.adjustDeducedFunctionResultType(FD, $this().SubstAutoType(ResultType.getType(), $this().Context.VoidTy.$QualType()));
        }
      }
    } else if ($this().getLangOpts().CPlusPlus11 && isLambdaCallOperator(FD)) {
      // In C++11, we don't use 'auto' deduction rules for lambda call
      // operators because we don't support return type deduction.
      LambdaScopeInfo /*P*/ LSI = $this().getCurLambda();
      if (LSI.HasImplicitReturnType) {
        $this().deduceClosureReturnType($Deref(LSI));
        
        // C++11 [expr.prim.lambda]p4:
        //   [...] if there are no return statements in the compound-statement
        //   [the deduced type is] the type void
        QualType RetType = LSI.ReturnType.isNull() ? $this().Context.VoidTy.$QualType() : new QualType(LSI.ReturnType);
        
        // Update the return type to the deduced type.
        /*const*/ FunctionProtoType /*P*/ Proto = FD.getType().$arrow().getAs(FunctionProtoType.class);
        FD.setType($this().Context.getFunctionType(new QualType(RetType), Proto.getParamTypes(), 
                Proto.getExtProtoInfo()));
      }
    }
    
    // The only way to be included in UndefinedButUsed is if there is an
    // ODR use before the definition. Avoid the expensive map lookup if this
    // is the first declaration.
    if (!FD.isFirstDecl$Redeclarable() && FD.getPreviousDecl$Redeclarable().isUsed()) {
      if (!FD.isExternallyVisible()) {
        $this().UndefinedButUsed.erase(FD);
      } else if (FD.isInlined()
         && !$this().LangOpts.GNUInline
         && (!FD.getPreviousDecl$Redeclarable().hasAttr(GNUInlineAttr.class))) {
        $this().UndefinedButUsed.erase(FD);
      }
    }
    
    // If the function implicitly returns zero (like 'main') or is naked,
    // don't complain about missing return statements.
    if (FD.hasImplicitReturnZero() || FD.hasAttr(NakedAttr.class)) {
      WP.disableCheckFallThrough();
    }
    
    // MSVC permits the use of pure specifier (=0) on function definition,
    // defined at class scope, warn about this non-standard construct.
    if ($this().getLangOpts().MicrosoftExt && FD.isPure() && FD.isCanonicalDecl()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(FD.getLocation(), diag.ext_pure_function_definition)));
      } finally {
        $c$.$destroy();
      }
    }
    if (!FD.isInvalidDecl()) {
      // Don't diagnose unused parameters of defaulted or deleted functions.
      if (!FD.isDeleted() && !FD.isDefaulted()) {
        $this().DiagnoseUnusedParameters(new ArrayRef<ParmVarDecl /*P*/ >(JD$Move.INSTANCE, FD.parameters()));
      }
      $this().DiagnoseSizeOfParametersAndReturnValue(new ArrayRef<ParmVarDecl /*P*/ >(JD$Move.INSTANCE, FD.parameters()), 
          FD.getReturnType(), FD);
      {
        
        // If this is a structor, we need a vtable.
        CXXConstructorDecl /*P*/ Constructor = dyn_cast_CXXConstructorDecl(FD);
        if ((Constructor != null)) {
          $this().MarkVTableUsed(FD.getLocation(), Constructor.getParent());
        } else {
          CXXDestructorDecl /*P*/ Destructor = dyn_cast_CXXDestructorDecl(FD);
          if ((Destructor != null)) {
            $this().MarkVTableUsed(FD.getLocation(), Destructor.getParent());
          }
        }
      }
      
      // Try to apply the named return value optimization. We have to check
      // if we can do this here because lambdas keep return statements around
      // to deduce an implicit return type.
      if ($this().getLangOpts().CPlusPlus && FD.getReturnType().$arrow().isRecordType()
         && !FD.isDependentContext()) {
        $this().computeNRVO(Body.$deref(), $this().getCurFunction());
      }
    }
    
    // GNU warning -Wmissing-prototypes:
    //   Warn if a global function is defined without a previous
    //   prototype declaration. This warning is issued even if the
    //   definition itself provides a prototype. The aim is to detect
    //   global functions that fail to be declared in header files.
    type$ref</*const*/ FunctionDecl /*P*/ > PossibleZeroParamPrototype = create_type$null$ref(null);
    if (ShouldWarnAboutMissingPrototype(FD, PossibleZeroParamPrototype)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getLocation(), diag.warn_missing_prototype)), FD));
        if ((PossibleZeroParamPrototype.$deref() != null)) {
          {
            // We found a declaration that is not a prototype,
            // but that could be a zero-parameter prototype
            TypeSourceInfo /*P*/ TI = PossibleZeroParamPrototype.$deref().getTypeSourceInfo();
            if ((TI != null)) {
              TypeLoc TL = TI.getTypeLoc();
              {
                FunctionNoProtoTypeLoc FTL = TL.getAs(FunctionNoProtoTypeLoc.class);
                if (FTL.$bool()) {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_NamedDecl($c$.track($this().Diag(PossibleZeroParamPrototype.$deref().getLocation(), 
                              diag.note_declaration_not_a_prototype)), 
                          PossibleZeroParamPrototype), 
                      FixItHint.CreateInsertion(FTL.getRParenLoc(), new StringRef(/*KEEP_STR*/$void))));
                }
              }
            }
          }
        }
      } finally {
        $c$.$destroy();
      }
    }
    {
      
      CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(FD);
      if ((MD != null)) {
        /*const*/ CXXMethodDecl /*P*/ KeyFunction;
        if (MD.isOutOfLine() && ((MD = MD.getCanonicalDecl()) != null)
           && MD.isVirtual()
           && ((KeyFunction = $this().Context.getCurrentKeyFunction(MD.getParent())) != null)
           && MD == KeyFunction.getCanonicalDecl$Const()) {
          // Update the key-function state if necessary for this ABI.
          if (FD.isInlined()
             && !$this().Context.getTargetInfo().getCXXABI().canKeyFunctionBeInline()) {
            $this().Context.setNonKeyFunction(MD);
            
            // If the newly-chosen key function is already defined, then we
            // need to mark the vtable as used retroactively.
            KeyFunction = $this().Context.getCurrentKeyFunction(MD.getParent());
            type$ref</*const*/ FunctionDecl /*P*/ > Definition = create_type$ref();
            if ((KeyFunction != null) && KeyFunction.isDefined(Definition)) {
              $this().MarkVTableUsed(Definition.$deref().getLocation(), MD.getParent(), true);
            }
          } else {
            // We just defined they key function; mark the vtable as used.
            $this().MarkVTableUsed(FD.getLocation(), MD.getParent(), true);
          }
        }
      }
    }
    assert ((FD == $this().getCurFunctionDecl() || $this().getCurLambda().CallOperator == FD)) : "Function parsing confused";
  } else {
    ObjCMethodDecl /*P*/ MD = dyn_cast_or_null_ObjCMethodDecl(dcl);
    if ((MD != null)) {
      assert (MD == $this().getCurMethodDecl()) : "Method parsing confused";
      MD.setBody(Body.$deref());
      if (!MD.isInvalidDecl()) {
        $this().DiagnoseUnusedParameters(MD.parameters());
        $this().DiagnoseSizeOfParametersAndReturnValue(MD.parameters(), 
            MD.getReturnType(), MD);
        if ((Body.$deref() != null)) {
          $this().computeNRVO(Body.$deref(), $this().getCurFunction());
        }
      }
      if ($this().getCurFunction().ObjCShouldCallSuper) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MD.getLocEnd(), diag.warn_objc_missing_super_call)), 
              MD.getSelector().getAsString()));
          $this().getCurFunction().ObjCShouldCallSuper = false;
        } finally {
          $c$.$destroy();
        }
      }
      if ($this().getCurFunction().ObjCWarnForNoDesignatedInitChain) {
        type$ptr</*const*/ ObjCMethodDecl /*P*/ > InitMethod = create_type$null$ptr(null);
        boolean isDesignated = MD.isDesignatedInitializerForTheInterface($AddrOf(InitMethod));
        assert (isDesignated && (InitMethod.$star() != null));
        ///*J:(void)*/isDesignated;
        
        BoolPredicate<ObjCMethodDecl> superIsNSObject = /*[&, this]*/ (/*const*/ ObjCMethodDecl /*P*/ MD$1) -> {
              /*const*/ ObjCInterfaceDecl /*P*/ IFace = MD$1.getClassInterface$Const();
              if (!(IFace != null)) {
                return false;
              }
              ObjCInterfaceDecl /*P*/ SuperD = IFace.getSuperClass();
              if (!(SuperD != null)) {
                return false;
              }
              return SuperD.getIdentifier()
                 == $this().NSAPIObj.$arrow().getNSClassId(NSAPI.NSClassIdKindKind.ClassId_NSObject);
            };
        // Don't issue this warning for unavailable inits or direct subclasses
        // of NSObject.
        if (!MD.isUnavailable() && !superIsNSObject.$call(MD)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(MD.getLocation(), 
                diag.warn_objc_designated_init_missing_super_call)));
            $c$.clean($c$.track($this().Diag(InitMethod.$star().getLocation(), 
                diag.note_objc_designated_init_marked_here)));
          } finally {
            $c$.$destroy();
          }
        }
        $this().getCurFunction().ObjCWarnForNoDesignatedInitChain = false;
      }
      if ($this().getCurFunction().ObjCWarnForNoInitDelegation) {
        // Don't issue this warning for unavaialable inits.
        if (!MD.isUnavailable()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(MD.getLocation(), 
                diag.warn_objc_secondary_init_missing_init_call)));
          } finally {
            $c$.$destroy();
          }
        }
        $this().getCurFunction().ObjCWarnForNoInitDelegation = false;
      }
    } else {
      return null;
    }
  }
  assert (!$this().getCurFunction().ObjCShouldCallSuper) : "This should only be set for ObjC methods, which should have been handled in the block above.";
  
  // Verify and clean out per-function state.
  if ((Body.$deref() != null) && (!(FD != null) || !FD.isDefaulted())) {
    // C++ constructors that have function-try-blocks can't have return
    // statements in the handlers of that block. (C++ [except.handle]p14)
    // Verify this.
    if ((FD != null) && isa_CXXConstructorDecl(FD) && isa_CXXTryStmt(Body)) {
      $this().DiagnoseReturnInConstructorExceptionHandler(cast_CXXTryStmt(Body.$deref()));
    }
    
    // Verify that gotos and switch cases don't jump into scopes illegally.
    if ($this().getCurFunction().NeedsScopeChecking()
       && !$this().PP.isCodeCompletionEnabled()) {
      $this().DiagnoseInvalidJumps(Body.$deref());
    }
    {
      
      CXXDestructorDecl /*P*/ Destructor = dyn_cast_CXXDestructorDecl(dcl);
      if ((Destructor != null)) {
        if (!Destructor.getParent().isDependentType()) {
          $this().CheckDestructor(Destructor);
        }
        
        $this().MarkBaseAndMemberDestructorsReferenced(Destructor.getLocation(), 
            Destructor.getParent());
      }
    }
    
    // If any errors have occurred, clear out any temporaries that may have
    // been leftover. This ensures that these temporaries won't be picked up for
    // deletion in some later function.
    if ($this().getDiagnostics().hasErrorOccurred()
       || $this().getDiagnostics().getSuppressAllDiagnostics()) {
      $this().DiscardCleanupsInEvaluationContext();
    }
    if (!$this().getDiagnostics().hasUncompilableErrorOccurred()
       && !isa_FunctionTemplateDecl(dcl)) {
      // Since the body is valid, issue any analysis-based warnings that are
      // enabled.
      ActivePolicy = $AddrOf(WP);
    }
    if (!IsInstantiation && (FD != null) && FD.isConstexpr() && !FD.isInvalidDecl()
       && (!$this().CheckConstexprFunctionDecl(FD)
       || !$this().CheckConstexprFunctionBody(FD, Body.$deref()))) {
      FD.setInvalidDecl();
    }
    if ((FD != null) && FD.hasAttr(NakedAttr.class)) {
      for (/*const*/ Stmt /*P*/ S : Body.$deref().children()) {
        if (!isa_AsmStmt(S) && !isa_NullStmt(S)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(S.getLocStart(), diag.err_non_asm_stmt_in_naked_function)));
            $c$.clean($c$.track($this().Diag(FD.getAttr(NakedAttr.class).getLocation(), diag.note_attribute)));
            FD.setInvalidDecl();
            break;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    assert ($this().ExprCleanupObjects.size() == $this().ExprEvalContexts.back().NumCleanupObjects) : "Leftover temporaries in function";
    assert (!$this().Cleanup.exprNeedsCleanups()) : "Unaccounted cleanups in function";
    assert ($this().MaybeODRUseExprs.empty()) : "Leftover expressions for odr-use checking";
  }
  if (!IsInstantiation) {
    $this().PopDeclContext();
  }
  
  $this().PopFunctionScopeInfo(ActivePolicy, dcl);
  // If any errors have occurred, clear out any temporaries that may have
  // been leftover. This ensures that these temporaries won't be picked up for
  // deletion in some later function.
  if ($this().getDiagnostics().hasErrorOccurred()) {
    $this().DiscardCleanupsInEvaluationContext();
  }
  
  return dcl;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnSkippedFunctionBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 11429,
 FQN="clang::Sema::ActOnSkippedFunctionBody", NM="_ZN5clang4Sema24ActOnSkippedFunctionBodyEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema24ActOnSkippedFunctionBodyEPNS_4DeclE")
//</editor-fold>
public final Decl /*P*/ ActOnSkippedFunctionBody(Decl /*P*/ $Decl) {
  {
    FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl($Decl);
    if ((FD != null)) {
      FD.setHasSkippedBody();
    } else {
      ObjCMethodDecl /*P*/ MD = dyn_cast_or_null_ObjCMethodDecl($Decl);
      if ((MD != null)) {
        MD.setHasSkippedBody();
      }
    }
  }
  return $Decl;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFinishInlineFunctionDef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 11087,
 FQN="clang::Sema::ActOnFinishInlineFunctionDef", NM="_ZN5clang4Sema28ActOnFinishInlineFunctionDefEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema28ActOnFinishInlineFunctionDefEPNS_12FunctionDeclE")
//</editor-fold>
public final void ActOnFinishInlineFunctionDef(FunctionDecl /*P*/ D) {
  $this().Consumer.HandleInlineFunctionDefinition(D);
}


/// ActOnFinishDelayedAttribute - Invoked when we have finished parsing an
/// attribute for which parsing is delayed.

/// When we finish delayed parsing of an attribute, we must attach it to the
/// relevant Decl.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFinishDelayedAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 11718,
 FQN="clang::Sema::ActOnFinishDelayedAttribute", NM="_ZN5clang4Sema27ActOnFinishDelayedAttributeEPNS_5ScopeEPNS_4DeclERNS_16ParsedAttributesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema27ActOnFinishDelayedAttributeEPNS_5ScopeEPNS_4DeclERNS_16ParsedAttributesE")
//</editor-fold>
public final void ActOnFinishDelayedAttribute(Scope /*P*/ S, Decl /*P*/ D, 
                           final ParsedAttributes /*&*/ Attrs) {
  {
    // Always attach attributes to the underlying decl.
    TemplateDecl /*P*/ TD = dyn_cast_TemplateDecl(D);
    if ((TD != null)) {
      D = TD.getTemplatedDecl();
    }
  }
  $this().ProcessDeclAttributeList(S, D, Attrs.getList());
  {
    
    CXXMethodDecl /*P*/ Method = dyn_cast_or_null_CXXMethodDecl(D);
    if ((Method != null)) {
      if (Method.isStatic()) {
        $this().checkThisInStaticMemberFunctionAttributes(Method);
      }
    }
  }
}


/// \brief Diagnose any unused parameters in the given sequence of
/// ParmVarDecl pointers.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseUnusedParameters">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 10929,
 FQN="clang::Sema::DiagnoseUnusedParameters", NM="_ZN5clang4Sema24DiagnoseUnusedParametersEN4llvm8ArrayRefIPNS_11ParmVarDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema24DiagnoseUnusedParametersEN4llvm8ArrayRefIPNS_11ParmVarDeclEEE")
//</editor-fold>
public final void DiagnoseUnusedParameters(ArrayRef<ParmVarDecl /*P*/ > Parameters) {
  // Don't diagnose unused-parameter errors in template instantiations; we
  // will already have done so in the template itself.
  if (!$this().ActiveTemplateInstantiations.empty()) {
    return;
  }
  
  for (/*const*/ ParmVarDecl /*P*/ Parameter : Parameters) {
    if (!Parameter.isReferenced() && Parameter.getDeclName().$bool()
       && !Parameter.hasAttr(UnusedAttr.class)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag(Parameter.getLocation(), diag.warn_unused_parameter)), 
            Parameter.getDeclName()));
      } finally {
        $c$.$destroy();
      }
    }
  }
}


/// \brief Diagnose whether the size of parameters or return value of a
/// function or obj-c method definition is pass-by-value and larger than a
/// specified threshold.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseSizeOfParametersAndReturnValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 10944,
 FQN="clang::Sema::DiagnoseSizeOfParametersAndReturnValue", NM="_ZN5clang4Sema38DiagnoseSizeOfParametersAndReturnValueEN4llvm8ArrayRefIPNS_11ParmVarDeclEEENS_8QualTypeEPNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema38DiagnoseSizeOfParametersAndReturnValueEN4llvm8ArrayRefIPNS_11ParmVarDeclEEENS_8QualTypeEPNS_9NamedDeclE")
//</editor-fold>
public final void DiagnoseSizeOfParametersAndReturnValue(ArrayRef<ParmVarDecl /*P*/ > Parameters, QualType ReturnTy, NamedDecl /*P*/ D) {
  if ($this().LangOpts.NumLargeByValueCopy == 0) { // No check.
    return;
  }
  
  // Warn if the return value is pass-by-value and larger than the specified
  // threshold.
  if (!ReturnTy.$arrow().isDependentType() && ReturnTy.isPODType($this().Context)) {
    /*uint*/int Size = $long2uint($this().Context.getTypeSizeInChars(/*NO_COPY*/ReturnTy).getQuantity());
    if ($greater_uint(Size, $this().LangOpts.NumLargeByValueCopy)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag(D.getLocation(), diag.warn_return_value_size)), 
                D.getDeclName()), Size));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Warn if any parameter is pass-by-value and larger than the specified
  // threshold.
  for (/*const*/ ParmVarDecl /*P*/ Parameter : Parameters) {
    QualType T = Parameter.getType();
    if (T.$arrow().isDependentType() || !T.isPODType($this().Context)) {
      continue;
    }
    /*uint*/int Size = $long2uint($this().Context.getTypeSizeInChars(new QualType(T)).getQuantity());
    if ($greater_uint(Size, $this().LangOpts.NumLargeByValueCopy)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Parameter.getLocation(), diag.warn_parameter_size)), 
                Parameter.getDeclName()), Size));
      } finally {
        $c$.$destroy();
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFileScopeAsmDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 15014,
 FQN="clang::Sema::ActOnFileScopeAsmDecl", NM="_ZN5clang4Sema21ActOnFileScopeAsmDeclEPNS_4ExprENS_14SourceLocationES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema21ActOnFileScopeAsmDeclEPNS_4ExprENS_14SourceLocationES3_")
//</editor-fold>
public final Decl /*P*/ ActOnFileScopeAsmDecl(Expr /*P*/ expr, 
                     SourceLocation StartLoc, 
                     SourceLocation EndLoc) {
  StringLiteral /*P*/ AsmString = cast_StringLiteral(expr);
  
  FileScopeAsmDecl /*P*/ New = FileScopeAsmDecl.Create($this().Context, $this().CurContext, 
      AsmString, new SourceLocation(StartLoc), 
      new SourceLocation(EndLoc));
  $this().CurContext.addDecl(New);
  return New;
}


/// \brief The parser has processed a module import declaration.
///
/// \param AtLoc The location of the '@' symbol, if any.
///
/// \param ImportLoc The location of the 'import' keyword.
///
/// \param Path The module access path.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnModuleImport">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 15064,
 FQN="clang::Sema::ActOnModuleImport", NM="_ZN5clang4Sema17ActOnModuleImportENS_14SourceLocationES1_N4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoES1_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema17ActOnModuleImportENS_14SourceLocationES1_N4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoES1_EEE")
//</editor-fold>
public final ActionResult<Decl /*P*/ > ActOnModuleImport(SourceLocation AtLoc, 
                 SourceLocation ImportLoc, 
                 ModuleIdPath Path) {
  Module /*P*/ Mod = $this().getModuleLoader().loadModule(/*NO_COPY*/ImportLoc, /*NO_COPY*/Path, Module.NameVisibilityKind.AllVisible, 
      /*IsIncludeDirective=*/ false).$ModulePtr();
  if (!(Mod != null)) {
    return new ActionResult<Decl /*P*/ >(true);
  }
  
  $this().VisibleModules.setVisible(Mod, /*NO_COPY*/ImportLoc);
  
  checkModuleImportContext(/*Deref*/$this(), Mod, new SourceLocation(ImportLoc), $this().CurContext);
  
  // FIXME: we should support importing a submodule within a different submodule
  // of the same top-level module. Until we do, make it an error rather than
  // silently ignoring the import.
  if ($eq_StringRef(Mod.getTopLevelModuleName(), new StringRef($this().getLangOpts().CurrentModule))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ImportLoc), $this().getLangOpts().CompilingModule ? diag.err_module_self_import : diag.err_module_import_in_implementation)), 
              Mod.getFullModuleName()), $this().getLangOpts().CurrentModule));
    } finally {
      $c$.$destroy();
    }
  }
  
  SmallVector<SourceLocation> IdentifierLocs/*J*/= new SmallVector<SourceLocation>(2, new SourceLocation());
  Module /*P*/ ModCheck = Mod;
  for (/*uint*/int I = 0, N = Path.size(); I != N; ++I) {
    // If we've run out of module parents, just drop the remaining identifiers.
    // We need the length to be consistent.
    if (!(ModCheck != null)) {
      break;
    }
    ModCheck = ModCheck.Parent;
    
    IdentifierLocs.push_back(Path.$at(I).second);
  }
  
  ImportDecl /*P*/ Import = ImportDecl.Create($this().Context, 
      $this().Context.getTranslationUnitDecl(), 
      new SourceLocation(AtLoc.isValid() ? AtLoc : ImportLoc), 
      Mod, new ArrayRef<SourceLocation>(IdentifierLocs, false));
  $this().Context.getTranslationUnitDecl().addDecl(Import);
  return new ActionResult<Decl /*P*/ >(JD$T.INSTANCE, false, Import);
}


/// \brief The parser has processed a module import translated from a
/// #include or similar preprocessing directive.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnModuleInclude">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 15106,
 FQN="clang::Sema::ActOnModuleInclude", NM="_ZN5clang4Sema18ActOnModuleIncludeENS_14SourceLocationEPNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema18ActOnModuleIncludeENS_14SourceLocationEPNS_6ModuleE")
//</editor-fold>
public final void ActOnModuleInclude(SourceLocation DirectiveLoc, Module /*P*/ Mod) {
  checkModuleImportContext(/*Deref*/$this(), Mod, new SourceLocation(DirectiveLoc), $this().CurContext, true);
  
  // Determine whether we're in the #include buffer for a module. The #includes
  // in that buffer do not qualify as module imports; they're just an
  // implementation detail of us building the module.
  //
  // FIXME: Should we even get ActOnModuleInclude calls for those?
  boolean IsInModuleIncludes = $this().TUKind == TranslationUnitKind.TU_Module
     && $this().getSourceManager().isWrittenInMainFile(/*NO_COPY*/DirectiveLoc);
  
  // Similarly, if we're in the implementation of a module, don't
  // synthesize an illegal module import. FIXME: Why not?
  boolean ShouldAddImport = !IsInModuleIncludes
     && ($this().getLangOpts().CompilingModule
     || $this().getLangOpts().CurrentModule.empty()
     || $noteq_StringRef(new StringRef($this().getLangOpts().CurrentModule), Mod.getTopLevelModuleName()));
  
  // If this module import was due to an inclusion directive, create an
  // implicit import declaration to capture it in the AST.
  if (ShouldAddImport) {
    TranslationUnitDecl /*P*/ TU = $this().getASTContext().getTranslationUnitDecl();
    ImportDecl /*P*/ ImportD = ImportDecl.CreateImplicit($this().getASTContext(), TU, 
        new SourceLocation(DirectiveLoc), Mod, 
        new SourceLocation(DirectiveLoc));
    TU.addDecl(ImportD);
    $this().Consumer.HandleImplicitImportDecl(ImportD);
  }
  
  $this().getModuleLoader().makeModuleVisible(Mod, Module.NameVisibilityKind.AllVisible, /*NO_COPY*/DirectiveLoc);
  $this().VisibleModules.setVisible(Mod, /*NO_COPY*/DirectiveLoc);
}


/// \brief The parsed has entered a submodule.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnModuleBegin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 15141,
 FQN="clang::Sema::ActOnModuleBegin", NM="_ZN5clang4Sema16ActOnModuleBeginENS_14SourceLocationEPNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema16ActOnModuleBeginENS_14SourceLocationEPNS_6ModuleE")
//</editor-fold>
public final void ActOnModuleBegin(SourceLocation DirectiveLoc, Module /*P*/ Mod) {
  checkModuleImportContext(/*Deref*/$this(), Mod, new SourceLocation(DirectiveLoc), $this().CurContext);
  if ($this().getLangOpts().ModulesLocalVisibility) {
    $this().VisibleModulesStack.push_back_T$RR(std.move($this().VisibleModules));
  }
  $this().VisibleModules.setVisible(Mod, /*NO_COPY*/DirectiveLoc);
}

/// \brief The parser has left a submodule.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnModuleEnd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 15149,
 FQN="clang::Sema::ActOnModuleEnd", NM="_ZN5clang4Sema14ActOnModuleEndENS_14SourceLocationEPNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema14ActOnModuleEndENS_14SourceLocationEPNS_6ModuleE")
//</editor-fold>
public final void ActOnModuleEnd(SourceLocation DirectiveLoc, Module /*P*/ Mod) {
  checkModuleImportContext(/*Deref*/$this(), Mod, new SourceLocation(DirectiveLoc), $this().CurContext);
  if ($this().getLangOpts().ModulesLocalVisibility) {
    $this().VisibleModules.$assignMove(std.move($this().VisibleModulesStack.back()));
    $this().VisibleModulesStack.pop_back();
    $this().VisibleModules.setVisible(Mod, /*NO_COPY*/DirectiveLoc);
    // Leaving a module hides namespace names, so our visible namespace cache
    // is now out of date.
    $this().VisibleNamespaceCache.clear();
  }
}


/// \brief Check if module import may be found in the current context,
/// emit error if not.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::diagnoseMisplacedModuleImport">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 15060,
 FQN="clang::Sema::diagnoseMisplacedModuleImport", NM="_ZN5clang4Sema29diagnoseMisplacedModuleImportEPNS_6ModuleENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema29diagnoseMisplacedModuleImportEPNS_6ModuleENS_14SourceLocationE")
//</editor-fold>
public final void diagnoseMisplacedModuleImport(Module /*P*/ M, SourceLocation ImportLoc) {
  checkModuleImportContext(/*Deref*/$this(), M, new SourceLocation(ImportLoc), $this().CurContext);
  /*JAVA:return*/return;
}


/// \brief Create an implicit import of the given module at the given
/// source location, for error recovery, if possible.
///
/// This routine is typically used when an entity found by name lookup
/// is actually hidden within a module that we know about but the user
/// has forgotten to import.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::createImplicitModuleImportForErrorRecovery">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 15162,
 FQN="clang::Sema::createImplicitModuleImportForErrorRecovery", NM="_ZN5clang4Sema42createImplicitModuleImportForErrorRecoveryENS_14SourceLocationEPNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema42createImplicitModuleImportForErrorRecoveryENS_14SourceLocationEPNS_6ModuleE")
//</editor-fold>
public final void createImplicitModuleImportForErrorRecovery(SourceLocation Loc, 
                                          Module /*P*/ Mod) {
  // Bail if we're not allowed to implicitly import a module here.
  if ($this().isSFINAEContext().$bool() || !$this().getLangOpts().ModulesErrorRecovery) {
    return;
  }
  
  // Create the implicit import declaration.
  TranslationUnitDecl /*P*/ TU = $this().getASTContext().getTranslationUnitDecl();
  ImportDecl /*P*/ ImportD = ImportDecl.CreateImplicit($this().getASTContext(), TU, 
      new SourceLocation(Loc), Mod, new SourceLocation(Loc));
  TU.addDecl(ImportD);
  $this().Consumer.HandleImplicitImportDecl(ImportD);
  
  // Make the module visible.
  $this().getModuleLoader().makeModuleVisible(Mod, Module.NameVisibilityKind.AllVisible, /*NO_COPY*/Loc);
  $this().VisibleModules.setVisible(Mod, /*NO_COPY*/Loc);
}


/// Scope actions.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPopScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1633,
 FQN="clang::Sema::ActOnPopScope", NM="_ZN5clang4Sema13ActOnPopScopeENS_14SourceLocationEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema13ActOnPopScopeENS_14SourceLocationEPNS_5ScopeE")
//</editor-fold>
public final void ActOnPopScope(SourceLocation Loc, Scope /*P*/ S) {
  S.mergeNRVOIntoParent();
  if (S.decl_empty()) {
    return;
  }
  assert (((S.getFlags() & (Scope.ScopeFlags.DeclScope | Scope.ScopeFlags.TemplateParamScope)) != 0)) : "Scope shouldn't contain decls!";
  
  for (Decl /*P*/ TmpD : S.decls()) {
    assert ((TmpD != null)) : "This decl didn't get pushed??";
    assert (isa_NamedDecl(TmpD)) : "Decl isn't NamedDecl?";
    NamedDecl /*P*/ D = cast_NamedDecl(TmpD);
    if (!D.getDeclName().$bool()) {
      continue;
    }
    
    // Diagnose unused variables in this scope.
    if (!S.hasUnrecoverableErrorOccurred()) {
      $this().DiagnoseUnusedDecl(D);
      {
        /*const*/ RecordDecl /*P*/ RD = dyn_cast_RecordDecl(D);
        if ((RD != null)) {
          $this().DiagnoseUnusedNestedTypedefs(RD);
        }
      }
    }
    {
      
      // If this was a forward reference to a label, verify it was defined.
      LabelDecl /*P*/ LD = dyn_cast_LabelDecl(D);
      if ((LD != null)) {
        CheckPoppedLabel(LD, /*Deref*/$this());
      }
    }
    
    // Remove this name from our lexical scope, and warn on it if we haven't
    // already.
    $this().IdResolver.RemoveDecl(D);
    DenseMapIterator</*const*/ NamedDecl /*P*/ , /*const*/ NamedDecl /*P*/ > ShadowI = $this().ShadowingDecls.find(D);
    if (ShadowI.$noteq(/*NO_ITER_COPY*/$this().ShadowingDecls.end())) {
      {
        /*const*/ FieldDecl /*P*/ FD = dyn_cast_FieldDecl(ShadowI.$arrow().second);
        if ((FD != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), diag.warn_ctor_parm_shadows_field)), 
                        D), FD), FD.getParent$Const()));
            $c$.clean($c$.track($this().Diag(FD.getLocation(), diag.note_previous_declaration)));
          } finally {
            $c$.$destroy();
          }
        }
      }
      $this().ShadowingDecls.erase(new DenseMapIterator</*const*/ NamedDecl /*P*/ , /*const*/ NamedDecl /*P*/ >(ShadowI));
    }
  }
}


/// ParsedFreeStandingDeclSpec - This method is invoked when a declspec with
/// no declarator (e.g. "struct foo;") is parsed.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ParsedFreeStandingDeclSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 3713,
 FQN="clang::Sema::ParsedFreeStandingDeclSpec", NM="_ZN5clang4Sema26ParsedFreeStandingDeclSpecEPNS_5ScopeENS_15AccessSpecifierERNS_8DeclSpecERPNS_10RecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema26ParsedFreeStandingDeclSpecEPNS_5ScopeENS_15AccessSpecifierERNS_8DeclSpecERPNS_10RecordDeclE")
//</editor-fold>
public final Decl /*P*/ ParsedFreeStandingDeclSpec(Scope /*P*/ S, AccessSpecifier AS, final DeclSpec /*&*/ DS, 
                          final type$ref<RecordDecl /*P*/ /*&*/> AnonRecord) {
  return $this().ParsedFreeStandingDeclSpec(S, AS, DS, new MutableArrayRef<TemplateParameterList /*P*/ >(true), false, 
      AnonRecord);
}


/// ParsedFreeStandingDeclSpec - This method is invoked when a declspec with
/// no declarator (e.g. "struct foo;") is parsed. It also accepts template
/// parameters to cope with template friend declarations.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ParsedFreeStandingDeclSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 3823,
 FQN="clang::Sema::ParsedFreeStandingDeclSpec", NM="_ZN5clang4Sema26ParsedFreeStandingDeclSpecEPNS_5ScopeENS_15AccessSpecifierERNS_8DeclSpecEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEEbRPNS_10RecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema26ParsedFreeStandingDeclSpecEPNS_5ScopeENS_15AccessSpecifierERNS_8DeclSpecEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEEbRPNS_10RecordDeclE")
//</editor-fold>
public final Decl /*P*/ ParsedFreeStandingDeclSpec(Scope /*P*/ S, AccessSpecifier AS, final DeclSpec /*&*/ DS, 
                          MutableArrayRef<TemplateParameterList /*P*/ > TemplateParams, 
                          boolean IsExplicitInstantiation, 
                          final type$ref<RecordDecl /*P*/ /*&*/> AnonRecord) {
  Decl /*P*/ TagD = null;
  TagDecl /*P*/ Tag = null;
  if (DS.getTypeSpecType() == DeclSpec.TST_class
     || DS.getTypeSpecType() == DeclSpec.TST_struct
     || DS.getTypeSpecType() == DeclSpec.TST_interface
     || DS.getTypeSpecType() == DeclSpec.TST_union
     || DS.getTypeSpecType() == DeclSpec.TST_enum) {
    TagD = DS.getRepAsDecl();
    if (!(TagD != null)) { // We probably had an error
      return null;
    }
    
    // Note that the above type specs guarantee that the
    // type rep is a Decl, whereas in many of the others
    // it's a Type.
    if (isa_TagDecl(TagD)) {
      Tag = cast_TagDecl(TagD);
    } else {
      ClassTemplateDecl /*P*/ CTD = dyn_cast_ClassTemplateDecl(TagD);
      if ((CTD != null)) {
        Tag = CTD.getTemplatedDecl();
      }
    }
  }
  if ((Tag != null)) {
    $this().handleTagNumbering(Tag, S);
    Tag.setFreeStanding();
    if (Tag.isInvalidDecl()) {
      return Tag;
    }
  }
  {
    
    /*uint*/int TypeQuals = DS.getTypeQualifiers();
    if ((TypeQuals != 0)) {
      // Enforce C99 6.7.3p2: "Types other than pointer types derived from object
      // or incomplete types shall not be restrict-qualified."
      if (((TypeQuals & DeclSpec.TQ.TQ_restrict.getValue()) != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getRestrictSpecLoc(), 
                  diag.err_typecheck_invalid_restrict_not_pointer_noarg)), 
              DS.getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  if (DS.isInlineSpecified()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getInlineSpecLoc(), diag.err_inline_non_function)), 
          $this().getLangOpts().CPlusPlus1z));
    } finally {
      $c$.$destroy();
    }
  }
  if (DS.isConstexprSpecified()) {
    // C++0x [dcl.constexpr]p1: constexpr can only be applied to declarations
    // and definitions of functions and variables.
    if ((Tag != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getConstexprSpecLoc(), diag.err_constexpr_tag)), 
            GetDiagnosticTypeSpecifierID(DS.getTypeSpecType())));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(DS.getConstexprSpecLoc(), diag.err_constexpr_no_declarators)));
      } finally {
        $c$.$destroy();
      }
    }
    // Don't emit warnings after this error.
    return TagD;
  }
  if (DS.isConceptSpecified()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // C++ Concepts TS [dcl.spec.concept]p1: A concept definition refers to
      // either a function concept and its definition or a variable concept and
      // its initializer.
      $c$.clean($c$.track($this().Diag(DS.getConceptSpecLoc(), diag.err_concept_wrong_decl_kind)));
      return TagD;
    } finally {
      $c$.$destroy();
    }
  }
  
  $this().DiagnoseFunctionSpecifiers(DS);
  if (DS.isFriendSpecified()) {
    // If we're dealing with a decl but not a TagDecl, assume that
    // whatever routines created it handled the friendship aspect.
    if ((TagD != null) && !(Tag != null)) {
      return null;
    }
    return $this().ActOnFriendTypeDecl(S, DS, new MutableArrayRef<TemplateParameterList /*P*/ >(TemplateParams));
  }
  
  final /*const*/ CXXScopeSpec /*&*/ SS = DS.getTypeSpecScope();
  boolean IsExplicitSpecialization = !TemplateParams.empty() && TemplateParams.back().size() == 0;
  if ((Tag != null) && SS.isNotEmpty() && !Tag.isCompleteDefinition()
     && !IsExplicitInstantiation && !IsExplicitSpecialization
     && !isa_ClassTemplatePartialSpecializationDecl(Tag)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Per C++ [dcl.type.elab]p1, a class declaration cannot have a
      // nested-name-specifier unless it is an explicit instantiation
      // or an explicit specialization.
      //
      // FIXME: We allow class template partial specializations here too, per the
      // obvious intent of DR1819.
      //
      // Per C++ [dcl.enum]p1, an opaque-enum-declaration can't either.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SS.getBeginLoc(), diag.err_standalone_class_nested_name_specifier)), 
              GetDiagnosticTypeSpecifierID(DS.getTypeSpecType())), SS.getRange()));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Track whether this decl-specifier declares anything.
  boolean DeclaresAnything = true;
  {
    
    // Handle anonymous struct definitions.
    RecordDecl /*P*/ Record = dyn_cast_or_null_RecordDecl(Tag);
    if ((Record != null)) {
      if (!Record.getDeclName().$bool() && Record.isCompleteDefinition()
         && DS.getStorageClassSpec() != DeclSpec.SCS.SCS_typedef) {
        if ($this().getLangOpts().CPlusPlus
           || Record.getDeclContext().isRecord()) {
          // If CurContext is a DeclContext that can contain statements,
          // RecursiveASTVisitor won't visit the decls that
          // BuildAnonymousStructOrUnion() will put into CurContext.
          // Also store them here so that they can be part of the
          // DeclStmt that gets created in this case.
          // FIXME: Also return the IndirectFieldDecls created by
          // BuildAnonymousStructOr union, for the same reason?
          if ($this().CurContext.isFunctionOrMethod()) {
            AnonRecord.$set(Record);
          }
          return $this().BuildAnonymousStructOrUnion(S, DS, AS, Record, 
              $this().Context.getPrintingPolicy());
        }
        
        DeclaresAnything = false;
      }
    }
  }
  
  // C11 6.7.2.1p2:
  //   A struct-declaration that does not declare an anonymous structure or
  //   anonymous union shall contain a struct-declarator-list.
  //
  // This rule also existed in C89 and C99; the grammar for struct-declaration
  // did not permit a struct-declaration without a struct-declarator-list.
  if (!$this().getLangOpts().CPlusPlus && $this().CurContext.isRecord()
     && DS.getStorageClassSpec() == DeclSpec.SCS.SCS_unspecified) {
    // Check for Microsoft C extension: anonymous struct/union member.
    // Handle 2 kinds of anonymous struct/union:
    //   struct STRUCT;
    //   union UNION;
    // and
    //   STRUCT_TYPE;  <- where STRUCT_TYPE is a typedef struct.
    //   UNION_TYPE;   <- where UNION_TYPE is a typedef union.
    if (((Tag != null) && Tag.getDeclName().$bool())
       || DS.getTypeSpecType() == DeclSpec.TST_typename) {
      RecordDecl /*P*/ Record = null;
      if ((Tag != null)) {
        Record = dyn_cast_RecordDecl(Tag);
      } else {
        /*const*/ RecordType /*P*/ RT = DS.getRepAsType().getQualType().$arrow().getAsStructureType();
        if ((RT != null)) {
          Record = RT.getDecl();
        } else {
          /*const*/ RecordType /*P*/ UT = DS.getRepAsType().getQualType().$arrow().getAsUnionType();
          if ((UT != null)) {
            Record = UT.getDecl();
          }
        }
      }
      if ((Record != null) && $this().getLangOpts().MicrosoftExt) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getLocStart(), diag.ext_ms_anonymous_record)), 
                  Record.isUnion()), DS.getSourceRange()));
          return $this().BuildMicrosoftCAnonymousStruct(S, DS, Record);
        } finally {
          $c$.$destroy();
        }
      }
      
      DeclaresAnything = false;
    }
  }
  
  // Skip all the checks below if we have a type error.
  if (DS.getTypeSpecType() == DeclSpec.TST_error
     || ((TagD != null) && TagD.isInvalidDecl())) {
    return TagD;
  }
  if ($this().getLangOpts().CPlusPlus
     && DS.getStorageClassSpec() != DeclSpec.SCS.SCS_typedef) {
    {
      EnumDecl /*P*/ Enum = dyn_cast_or_null_EnumDecl(Tag);
      if ((Enum != null)) {
        if ($eq_specific_decl_iterator$SpecificDecl$C(Enum.enumerator_begin(), Enum.enumerator_end())
           && !(Enum.getIdentifier() != null) && !Enum.isInvalidDecl()) {
          DeclaresAnything = false;
        }
      }
    }
  }
  if (!DS.isMissingDeclaratorOk()) {
    // Customize diagnostic for a typedef missing a name.
    if (DS.getStorageClassSpec() == DeclSpec.SCS.SCS_typedef) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getLocStart(), diag.ext_typedef_without_a_name)), 
            DS.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    } else {
      DeclaresAnything = false;
    }
  }
  if (DS.isModulePrivateSpecified()
     && (Tag != null) && Tag.getDeclContext().isFunctionOrMethod()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getModulePrivateSpecLoc(), diag.err_module_private_local_class)), 
              Tag.getTagKind()), 
          FixItHint.CreateRemoval(new SourceRange(DS.getModulePrivateSpecLoc()))));
    } finally {
      $c$.$destroy();
    }
  }
  
  $this().ActOnDocumentableDecl(TagD);
  
  // C 6.7/2:
  //   A declaration [...] shall declare at least a declarator [...], a tag,
  //   or the members of an enumeration.
  // C++ [dcl.dcl]p3:
  //   [If there are no declarators], and except for the declaration of an
  //   unnamed bit-field, the decl-specifier-seq shall introduce one or more
  //   names into the program, or shall redeclare a name introduced by a
  //   previous declaration.
  if (!DeclaresAnything) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // In C, we allow this as a (popular) extension / bug. Don't bother
      // producing further diagnostics for redundant qualifiers after this.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getLocStart(), diag.ext_no_declarators)), DS.getSourceRange()));
      return TagD;
    } finally {
      $c$.$destroy();
    }
  }
  
  // C++ [dcl.stc]p1:
  //   If a storage-class-specifier appears in a decl-specifier-seq, [...] the
  //   init-declarator-list of the declaration shall not be empty.
  // C++ [dcl.fct.spec]p1:
  //   If a cv-qualifier appears in a decl-specifier-seq, the
  //   init-declarator-list of the declaration shall not be empty.
  //
  // Spurious qualifiers here appear to be valid in C.
  /*uint*/int DiagID = diag.warn_standalone_specifier;
  if ($this().getLangOpts().CPlusPlus) {
    DiagID = diag.ext_standalone_specifier;
  }
  {
    
    // Note that a linkage-specification sets a storage class, but
    // 'extern "C" struct foo;' is actually valid and not theoretically
    // useless.
    DeclSpec.SCS SCS = DS.getStorageClassSpec();
    if ((SCS.getValue() != 0)) {
      if (SCS == DeclSpec.SCS.SCS_mutable) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Since mutable is not a viable storage class specifier in C, there is
          // no reason to treat it as an extension. Instead, diagnose as an error.
          $c$.clean($c$.track($this().Diag(DS.getStorageClassSpecLoc(), diag.err_mutable_nonmember)));
        } finally {
          $c$.$destroy();
        }
      } else if (!DS.isExternInLinkageSpec() && SCS != DeclSpec.SCS.SCS_typedef) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getStorageClassSpecLoc(), DiagID)), 
              DeclSpec.getSpecifierName_SCS(SCS)));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  {
    
    ThreadStorageClassSpecifier TSCS = DS.getThreadStorageClassSpec();
    if ((TSCS.getValue() != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getThreadStorageClassSpecLoc(), DiagID)), 
            DeclSpec.getSpecifierName_ThreadStorageClassSpecifier(TSCS)));
      } finally {
        $c$.$destroy();
      }
    }
  }
  if ((DS.getTypeQualifiers() != 0)) {
    if (((DS.getTypeQualifiers() & DeclSpec.TQ.TQ_const.getValue()) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getConstSpecLoc(), DiagID)), /*KEEP_STR*/"const"));
      } finally {
        $c$.$destroy();
      }
    }
    if (((DS.getTypeQualifiers() & DeclSpec.TQ.TQ_volatile.getValue()) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getConstSpecLoc(), DiagID)), /*KEEP_STR*/"volatile"));
      } finally {
        $c$.$destroy();
      }
    }
    // Restrict is covered above.
    if (((DS.getTypeQualifiers() & DeclSpec.TQ.TQ_atomic.getValue()) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getAtomicSpecLoc(), DiagID)), /*KEEP_STR*/"_Atomic"));
      } finally {
        $c$.$destroy();
      }
    }
    if (((DS.getTypeQualifiers() & DeclSpec.TQ.TQ_unaligned.getValue()) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getUnalignedSpecLoc(), DiagID)), /*KEEP_STR*/"__unaligned"));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Warn about ignored type attributes, for example:
  // __attribute__((aligned)) struct A;
  // Attributes should be placed after tag to apply to type declaration.
  if (!DS.getAttributes().empty()) {
    TypeSpecifierType TypeSpecType = DS.getTypeSpecType();
    if (TypeSpecType == DeclSpec.TST_class
       || TypeSpecType == DeclSpec.TST_struct
       || TypeSpecType == DeclSpec.TST_interface
       || TypeSpecType == DeclSpec.TST_union
       || TypeSpecType == DeclSpec.TST_enum) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        for (AttributeList /*P*/ attrs = DS.getAttributes().getList(); (attrs != null);
             attrs = attrs.getNext())  {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(attrs.getLoc(), diag.warn_declspec_attribute_ignored)), 
                  attrs.getName()), GetDiagnosticTypeSpecifierID(TypeSpecType)));
        }
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  return TagD;
}


/// BuildAnonymousStructOrUnion - Handle the declaration of an
/// anonymous structure or union. Anonymous unions are a C++ feature
/// (C++ [class.union]) and a C11 feature; anonymous structures
/// are a C11 feature and GNU C++ extension.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildAnonymousStructOrUnion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 4247,
 FQN="clang::Sema::BuildAnonymousStructOrUnion", NM="_ZN5clang4Sema27BuildAnonymousStructOrUnionEPNS_5ScopeERNS_8DeclSpecENS_15AccessSpecifierEPNS_10RecordDeclERKNS_14PrintingPolicyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema27BuildAnonymousStructOrUnionEPNS_5ScopeERNS_8DeclSpecENS_15AccessSpecifierEPNS_10RecordDeclERKNS_14PrintingPolicyE")
//</editor-fold>
public final Decl /*P*/ BuildAnonymousStructOrUnion(Scope /*P*/ S, final DeclSpec /*&*/ DS, 
                           AccessSpecifier AS, 
                           RecordDecl /*P*/ Record, 
                           final /*const*/ PrintingPolicy /*&*/ Policy) {
  Declarator Dc = null;
  try {
    DeclContext /*P*/ Owner = Record.getDeclContext();
    
    // Diagnose whether this anonymous struct/union is an extension.
    if (Record.isUnion() && !$this().getLangOpts().CPlusPlus && !$this().getLangOpts().C11) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(Record.getLocation(), diag.ext_anonymous_union)));
      } finally {
        $c$.$destroy();
      }
    } else if (!Record.isUnion() && $this().getLangOpts().CPlusPlus) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(Record.getLocation(), diag.ext_gnu_anonymous_struct)));
      } finally {
        $c$.$destroy();
      }
    } else if (!Record.isUnion() && !$this().getLangOpts().C11) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(Record.getLocation(), diag.ext_c11_anonymous_struct)));
      } finally {
        $c$.$destroy();
      }
    }
    
    // C and C++ require different kinds of checks for anonymous
    // structs/unions.
    boolean Invalid = false;
    if ($this().getLangOpts().CPlusPlus) {
      /*const*/char$ptr/*char P*/ PrevSpec = create_char$ptr();
      uint$ref DiagID = create_uint$ref();
      if (Record.isUnion()) {
        // C++ [class.union]p6:
        //   Anonymous unions declared in a named namespace or in the
        //   global namespace shall be declared static.
        if (DS.getStorageClassSpec() != DeclSpec.SCS.SCS_static
           && (isa_TranslationUnitDecl(Owner)
           || (isa_NamespaceDecl(Owner)
           && cast_NamespaceDecl(Owner).getDeclName().$bool()))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Record.getLocation(), diag.err_anonymous_union_not_static)), 
                FixItHint.CreateInsertion(Record.getLocation(), new StringRef(/*KEEP_STR*/"static "))));
            
            // Recover by adding 'static'.
            DS.SetStorageClassSpec(/*Deref*/$this(), DeclSpec.SCS.SCS_static, new SourceLocation(), 
                PrevSpec, DiagID, Policy);
          } finally {
            $c$.$destroy();
          }
        } else // C++ [class.union]p6:
        //   A storage class is not allowed in a declaration of an
        //   anonymous union in a class scope.
        if (DS.getStorageClassSpec() != DeclSpec.SCS.SCS_unspecified
           && isa_RecordDecl(Owner)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getStorageClassSpecLoc(), 
                    diag.err_anonymous_union_with_storage_spec)), 
                FixItHint.CreateRemoval(new SourceRange(DS.getStorageClassSpecLoc()))));
            
            // Recover by removing the storage specifier.
            DS.SetStorageClassSpec(/*Deref*/$this(), DeclSpec.SCS.SCS_unspecified, 
                new SourceLocation(), 
                PrevSpec, DiagID, $this().Context.getPrintingPolicy());
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      // Ignore const/volatile/restrict qualifiers.
      if ((DS.getTypeQualifiers() != 0)) {
        if (((DS.getTypeQualifiers() & DeclSpec.TQ.TQ_const.getValue()) != 0)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getConstSpecLoc(), diag.ext_anonymous_struct_union_qualified)), 
                        Record.isUnion()), /*KEEP_STR*/"const"), 
                FixItHint.CreateRemoval(new SourceRange(DS.getConstSpecLoc()))));
          } finally {
            $c$.$destroy();
          }
        }
        if (((DS.getTypeQualifiers() & DeclSpec.TQ.TQ_volatile.getValue()) != 0)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getVolatileSpecLoc(), 
                            diag.ext_anonymous_struct_union_qualified)), 
                        Record.isUnion()), /*KEEP_STR*/"volatile"), 
                FixItHint.CreateRemoval(new SourceRange(DS.getVolatileSpecLoc()))));
          } finally {
            $c$.$destroy();
          }
        }
        if (((DS.getTypeQualifiers() & DeclSpec.TQ.TQ_restrict.getValue()) != 0)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getRestrictSpecLoc(), 
                            diag.ext_anonymous_struct_union_qualified)), 
                        Record.isUnion()), /*KEEP_STR*/"restrict"), 
                FixItHint.CreateRemoval(new SourceRange(DS.getRestrictSpecLoc()))));
          } finally {
            $c$.$destroy();
          }
        }
        if (((DS.getTypeQualifiers() & DeclSpec.TQ.TQ_atomic.getValue()) != 0)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getAtomicSpecLoc(), 
                            diag.ext_anonymous_struct_union_qualified)), 
                        Record.isUnion()), /*KEEP_STR*/"_Atomic"), 
                FixItHint.CreateRemoval(new SourceRange(DS.getAtomicSpecLoc()))));
          } finally {
            $c$.$destroy();
          }
        }
        if (((DS.getTypeQualifiers() & DeclSpec.TQ.TQ_unaligned.getValue()) != 0)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DS.getUnalignedSpecLoc(), 
                            diag.ext_anonymous_struct_union_qualified)), 
                        Record.isUnion()), /*KEEP_STR*/"__unaligned"), 
                FixItHint.CreateRemoval(new SourceRange(DS.getUnalignedSpecLoc()))));
          } finally {
            $c$.$destroy();
          }
        }
        
        DS.ClearTypeQualifiers();
      }
      
      // C++ [class.union]p2:
      //   The member-specification of an anonymous union shall only
      //   define non-static data members. [Note: nested types and
      //   functions cannot be declared within an anonymous union. ]
      for (Decl /*P*/ Mem : Record.decls()) {
        {
          FieldDecl /*P*/ FD = dyn_cast_FieldDecl(Mem);
          if ((FD != null)) {
            // C++ [class.union]p3:
            //   An anonymous union shall not have private or protected
            //   members (clause 11).
            assert (FD.getAccess() != AccessSpecifier.AS_none);
            if (FD.getAccess() != AccessSpecifier.AS_public) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getLocation(), diag.err_anonymous_record_nonpublic_member)), 
                        Record.isUnion()), (FD.getAccess() == AccessSpecifier.AS_protected)));
                Invalid = true;
              } finally {
                $c$.$destroy();
              }
            }
            
            // C++ [class.union]p1
            //   An object of a class with a non-trivial constructor, a non-trivial
            //   copy constructor, a non-trivial destructor, or a non-trivial copy
            //   assignment operator cannot be a member of a union, nor can an
            //   array of such objects.
            if ($this().CheckNontrivialField(FD)) {
              Invalid = true;
            }
          } else if (Mem.isImplicit()) {
            // Any implicit members are fine.
          } else if (isa_TagDecl(Mem) && Mem.getDeclContext() != Record) {
            // This is a type that showed up in an
            // elaborated-type-specifier inside the anonymous struct or
            // union, but which actually declares a type outside of the
            // anonymous struct or union. It's okay.
          } else {
            RecordDecl /*P*/ MemRecord = dyn_cast_RecordDecl(Mem);
            if ((MemRecord != null)) {
              if (!MemRecord.isAnonymousStructOrUnion()
                 && MemRecord.getDeclName().$bool()) {
                // Visual C++ allows type definition in anonymous struct or union.
                if ($this().getLangOpts().MicrosoftExt) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MemRecord.getLocation(), diag.ext_anonymous_record_with_type)), 
                        Record.isUnion()));
                  } finally {
                    $c$.$destroy();
                  }
                } else {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    // This is a nested type declaration.
                    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MemRecord.getLocation(), diag.err_anonymous_record_with_type)), 
                        Record.isUnion()));
                    Invalid = true;
                  } finally {
                    $c$.$destroy();
                  }
                }
              } else {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  // This is an anonymous type definition within another anonymous type.
                  // This is a popular extension, provided by Plan9, MSVC and GCC, but
                  // not part of standard C++.
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MemRecord.getLocation(), 
                          diag.ext_anonymous_record_with_anonymous_type)), 
                      Record.isUnion()));
                } finally {
                  $c$.$destroy();
                }
              }
            } else if (isa_AccessSpecDecl(Mem)) {
              // Any access specifier is fine.
            } else if (isa_StaticAssertDecl(Mem)) {
              // In C++1z, static_assert declarations are also fine.
            } else {
              // We have something that isn't a non-static data
              // member. Complain about it.
              /*uint*/int DK = diag.err_anonymous_record_bad_member;
              if (isa_TypeDecl(Mem)) {
                DK = diag.err_anonymous_record_with_type;
              } else if (isa_FunctionDecl(Mem)) {
                DK = diag.err_anonymous_record_with_function;
              } else if (isa_VarDecl(Mem)) {
                DK = diag.err_anonymous_record_with_static;
              }
              
              // Visual C++ allows type definition in anonymous struct or union.
              if ($this().getLangOpts().MicrosoftExt
                 && DK == diag.err_anonymous_record_with_type) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Mem.getLocation(), diag.ext_anonymous_record_with_type)), 
                      Record.isUnion()));
                } finally {
                  $c$.$destroy();
                }
              } else {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Mem.getLocation(), DK)), Record.isUnion()));
                  Invalid = true;
                } finally {
                  $c$.$destroy();
                }
              }
            }
          }
        }
      }
      
      // C++11 [class.union]p8 (DR1460):
      //   At most one variant member of a union may have a
      //   brace-or-equal-initializer.
      if (cast_CXXRecordDecl(Record).hasInClassInitializer()
         && Owner.isRecord()) {
        checkDuplicateDefaultInit(/*Deref*/$this(), cast_CXXRecordDecl(Owner), 
            cast_CXXRecordDecl(Record));
      }
    }
    if (!Record.isUnion() && !Owner.isRecord()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Record.getLocation(), diag.err_anonymous_struct_not_member)), 
            $this().getLangOpts().CPlusPlus));
        Invalid = true;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Mock up a declarator.
    Dc/*J*/= new Declarator(DS, Declarator.TheContext.MemberContext);
    TypeSourceInfo /*P*/ TInfo = $this().GetTypeForDeclarator(Dc, S);
    assert ((TInfo != null)) : "couldn't build declarator info for anonymous struct/union";
    
    // Create a declaration for this anonymous struct/union.
    NamedDecl /*P*/ Anon = null;
    {
      RecordDecl /*P*/ OwningClass = dyn_cast_RecordDecl(Owner);
      if ((OwningClass != null)) {
        Anon = FieldDecl.Create($this().Context, OwningClass, 
            DS.getLocStart(), 
            Record.getLocation(), 
            /*IdentifierInfo=*/ (IdentifierInfo /*P*/ )null, 
            $this().Context.getTypeDeclType(Record), 
            TInfo, 
            /*BitWidth=*/ (Expr /*P*/ )null, /*Mutable=*/ false, 
            /*InitStyle=*/ InClassInitStyle.ICIS_NoInit);
        Anon.setAccess(AS);
        if ($this().getLangOpts().CPlusPlus) {
          $this().FieldCollector.$arrow().Add(cast_FieldDecl(Anon));
        }
      } else {
        DeclSpec.SCS SCSpec = DS.getStorageClassSpec();
        StorageClass SC = StorageClassSpecToVarDeclStorageClass(DS);
        if (SCSpec == DeclSpec.SCS.SCS_mutable) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // mutable can only appear on non-static class members, so it's always
            // an error here
            $c$.clean($c$.track($this().Diag(Record.getLocation(), diag.err_mutable_nonmember)));
            Invalid = true;
            SC = StorageClass.SC_None;
          } finally {
            $c$.$destroy();
          }
        }
        
        Anon = VarDecl.Create($this().Context, Owner, 
            DS.getLocStart(), 
            Record.getLocation(), /*IdentifierInfo=*/ (IdentifierInfo /*P*/ )null, 
            $this().Context.getTypeDeclType(Record), 
            TInfo, SC);
        
        // Default-initialize the implicit variable. This initialization will be
        // trivial in almost all cases, except if a union member has an in-class
        // initializer:
        //   union { int n = 0; };
        $this().ActOnUninitializedDecl(Anon, /*TypeMayContainAuto=*/ false);
      }
    }
    Anon.setImplicit();
    
    // Mark this as an anonymous struct/union type.
    Record.setAnonymousStructOrUnion(true);
    
    // Add the anonymous struct/union object to the current
    // context. We'll be referencing this object when we refer to one of
    // its members.
    Owner.addDecl(Anon);
    
    // Inject the members of the anonymous struct/union into the owning
    // context and into the identifier resolver chain for name lookup
    // purposes.
    SmallVector<NamedDecl /*P*/ > Chain/*J*/= new SmallVector<NamedDecl /*P*/ >(2, (NamedDecl /*P*/ )null);
    Chain.push_back(Anon);
    if (InjectAnonymousStructOrUnionMembers(/*Deref*/$this(), S, Owner, Record, AS, Chain)) {
      Invalid = true;
    }
    {
      
      VarDecl /*P*/ NewVD = dyn_cast_VarDecl(Anon);
      if ((NewVD != null)) {
        if ($this().getLangOpts().CPlusPlus && NewVD.isStaticLocal()) {
          type$ref<Decl /*P*/ > ManglingContextDecl = create_type$ref();
          {
            MangleNumberingContext /*P*/ MCtx = $this().getCurrentMangleNumberContext(NewVD.getDeclContext(), ManglingContextDecl);
            if ((MCtx != null)) {
              $this().Context.setManglingNumber(NewVD, MCtx.getManglingNumber(NewVD, getMSManglingNumber($this().getLangOpts(), S)));
              $this().Context.setStaticLocalNumber(NewVD, MCtx.getStaticLocalNumber(NewVD));
            }
          }
        }
      }
    }
    if (Invalid) {
      Anon.setInvalidDecl();
    }
    
    return Anon;
  } finally {
    if (Dc != null) { Dc.$destroy(); }
  }
}


/// BuildMicrosoftCAnonymousStruct - Handle the declaration of an
/// Microsoft C anonymous structure.
/// Ref: http://msdn.microsoft.com/en-us/library/z2cx9y4f.aspx
/// Example:
///
/// struct A { int a; };
/// struct B { struct A; int b; };
///
/// void foo() {
///   B var;
///   var.a = 3;
/// }
///
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildMicrosoftCAnonymousStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 4514,
 FQN="clang::Sema::BuildMicrosoftCAnonymousStruct", NM="_ZN5clang4Sema30BuildMicrosoftCAnonymousStructEPNS_5ScopeERNS_8DeclSpecEPNS_10RecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema30BuildMicrosoftCAnonymousStructEPNS_5ScopeERNS_8DeclSpecEPNS_10RecordDeclE")
//</editor-fold>
public final Decl /*P*/ BuildMicrosoftCAnonymousStruct(Scope /*P*/ S, final DeclSpec /*&*/ DS, 
                              RecordDecl /*P*/ Record) {
  Declarator Dc = null;
  try {
    assert ((Record != null)) : "expected a record!";
    
    // Mock up a declarator.
    Dc/*J*/= new Declarator(DS, Declarator.TheContext.TypeNameContext);
    TypeSourceInfo /*P*/ TInfo = $this().GetTypeForDeclarator(Dc, S);
    assert ((TInfo != null)) : "couldn't build declarator info for anonymous struct";
    
    RecordDecl /*P*/ ParentDecl = cast_RecordDecl($this().CurContext);
    QualType RecTy = $this().Context.getTypeDeclType(Record);
    
    // Create a declaration for this anonymous struct.
    NamedDecl /*P*/ Anon = FieldDecl.Create($this().Context, 
        ParentDecl, 
        DS.getLocStart(), 
        DS.getLocStart(), 
        /*IdentifierInfo=*/ (IdentifierInfo /*P*/ )null, 
        new QualType(RecTy), 
        TInfo, 
        /*BitWidth=*/ (Expr /*P*/ )null, /*Mutable=*/ false, 
        /*InitStyle=*/ InClassInitStyle.ICIS_NoInit);
    Anon.setImplicit();
    
    // Add the anonymous struct object to the current context.
    $this().CurContext.addDecl(Anon);
    
    // Inject the members of the anonymous struct into the current
    // context and into the identifier resolver chain for name lookup
    // purposes.
    SmallVector<NamedDecl /*P*/ > Chain/*J*/= new SmallVector<NamedDecl /*P*/ >(2, (NamedDecl /*P*/ )null);
    Chain.push_back(Anon);
    
    RecordDecl /*P*/ RecordDef = Record.getDefinition();
    if ($this().RequireCompleteType(Anon.getLocation(), new QualType(RecTy), 
        diag.err_field_incomplete)
       || InjectAnonymousStructOrUnionMembers(/*Deref*/$this(), S, $this().CurContext, RecordDef, 
        AccessSpecifier.AS_none, Chain)) {
      Anon.setInvalidDecl();
      ParentDecl.setInvalidDecl();
    }
    
    return Anon;
  } finally {
    if (Dc != null) { Dc.$destroy(); }
  }
}


/// \brief Determine whether a tag with a given kind is acceptable
/// as a redeclaration of the given tag declaration.
///
/// \returns true if the new tag kind is acceptable, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isAcceptableTagRedeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 12075,
 FQN="clang::Sema::isAcceptableTagRedeclaration", NM="_ZN5clang4Sema28isAcceptableTagRedeclarationEPKNS_7TagDeclENS_11TagTypeKindEbNS_14SourceLocationEPKNS_14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema28isAcceptableTagRedeclarationEPKNS_7TagDeclENS_11TagTypeKindEbNS_14SourceLocationEPKNS_14IdentifierInfoE")
//</editor-fold>
public final boolean isAcceptableTagRedeclaration(/*const*/ TagDecl /*P*/ Previous, 
                            TagTypeKind NewTag, boolean isDefinition, 
                            SourceLocation NewTagLoc, 
                            /*const*/ IdentifierInfo /*P*/ Name) {
  // C++ [dcl.type.elab]p3:
  //   The class-key or enum keyword present in the
  //   elaborated-type-specifier shall agree in kind with the
  //   declaration to which the name in the elaborated-type-specifier
  //   refers. This rule also applies to the form of
  //   elaborated-type-specifier that declares a class-name or
  //   friend class since it can be construed as referring to the
  //   definition of the class. Thus, in any
  //   elaborated-type-specifier, the enum keyword shall be used to
  //   refer to an enumeration (7.2), the union class-key shall be
  //   used to refer to a union (clause 9), and either the class or
  //   struct class-key shall be used to refer to a class (clause 9)
  //   declared using the class or struct class-key.
  TagTypeKind OldTag = Previous.getTagKind();
  if (!isDefinition || !isClassCompatTagKind(NewTag)) {
    if (OldTag == NewTag) {
      return true;
    }
  }
  if (isClassCompatTagKind(OldTag) && isClassCompatTagKind(NewTag)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Warn about the struct/class tag mismatch.
      boolean isTemplate = false;
      {
        /*const*/ CXXRecordDecl /*P*/ Record = dyn_cast_CXXRecordDecl(Previous);
        if ((Record != null)) {
          isTemplate = (Record.getDescribedClassTemplate() != null);
        }
      }
      if (!$this().ActiveTemplateInstantiations.empty()) {
        // In a template instantiation, do not offer fix-its for tag mismatches
        // since they usually mess up the template instead of fixing the problem.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NewTagLoc), diag.warn_struct_class_tag_mismatch)), 
                        getRedeclDiagFromTagKind(NewTag)), isTemplate), Name), 
            getRedeclDiagFromTagKind(OldTag)));
        return true;
      }
      if (isDefinition) {
        // On definitions, check previous tags and issue a fix-it for each
        // one that doesn't match the current tag.
        if ((Previous.getDefinition() != null)) {
          // Don't suggest fix-its for redefinitions.
          return true;
        }
        
        boolean previousMismatch = false;
        for (TagDecl /*P*/ I : Previous.redeclarable_redecls()) {
          if (I.getTagKind() != NewTag) {
            if (!previousMismatch) {
              previousMismatch = true;
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NewTagLoc), diag.warn_struct_class_previous_tag_mismatch)), 
                              getRedeclDiagFromTagKind(NewTag)), isTemplate), Name), 
                  getRedeclDiagFromTagKind(I.getTagKind())));
            }
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(I.getInnerLocStart(), diag.note_struct_class_suggestion)), 
                    getRedeclDiagFromTagKind(NewTag)), 
                FixItHint.CreateReplacement(new SourceRange(I.getInnerLocStart()), 
                    TypeWithKeyword.getTagTypeKindName(NewTag))));
          }
        }
        return true;
      }
      
      // Check for a previous definition.  If current tag and definition
      // are same type, do nothing.  If no definition, but disagree with
      // with previous tag type, give a warning, but no fix-it.
      /*const*/ TagDecl /*P*/ Redecl = (Previous.getDefinition() != null) ? Previous.getDefinition() : Previous;
      if (Redecl.getTagKind() == NewTag) {
        return true;
      }
      
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NewTagLoc), diag.warn_struct_class_tag_mismatch)), 
                      getRedeclDiagFromTagKind(NewTag)), isTemplate), Name), 
          getRedeclDiagFromTagKind(OldTag)));
      $c$.clean($c$.track($this().Diag(Redecl.getLocation(), diag.note_previous_use)));
      
      // If there is a previous definition, suggest a fix-it.
      if ((Previous.getDefinition() != null)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NewTagLoc), diag.note_struct_class_suggestion)), 
                getRedeclDiagFromTagKind(Redecl.getTagKind())), 
            FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/NewTagLoc), 
                TypeWithKeyword.getTagTypeKindName(Redecl.getTagKind()))));
      }
      
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  return false;
}


/// \brief This is invoked when we see 'struct foo' or 'struct {'.  In the
/// former case, Name will be non-null.  In the later case, Name will be null.
/// TagSpec indicates what kind of tag this is. TUK indicates whether this is a
/// reference/declaration/definition of a tag.
///
/// \param IsTypeSpecifier \c true if this is a type-specifier (or
/// trailing-type-specifier) other than one in an alias-declaration.
///
/// \param SkipBody If non-null, will be set to indicate if the caller should
/// skip the definition of this tag and treat it as if it were a declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnTag">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 12260,
 FQN="clang::Sema::ActOnTag", NM="_ZN5clang4Sema8ActOnTagEPNS_5ScopeEjNS0_10TagUseKindENS_14SourceLocationERNS_12CXXScopeSpecEPNS_14IdentifierInfoES4_PNS_13AttributeListENS_15AccessSpecifierES4_N4llvm15MutableArrayRefIPNS_21TemplateParameterListEEERbSH_S4_bNS_12ActionResultINS_9OpaquePtrINS_8QualTypeEEELb0EEEbPNS0_12SkipBodyInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema8ActOnTagEPNS_5ScopeEjNS0_10TagUseKindENS_14SourceLocationERNS_12CXXScopeSpecEPNS_14IdentifierInfoES4_PNS_13AttributeListENS_15AccessSpecifierES4_N4llvm15MutableArrayRefIPNS_21TemplateParameterListEEERbSH_S4_bNS_12ActionResultINS_9OpaquePtrINS_8QualTypeEEELb0EEEbPNS0_12SkipBodyInfoE")
//</editor-fold>
public final Decl /*P*/ ActOnTag(Scope /*P*/ S, /*uint*/int TagSpec, TagUseKind TUK, 
        SourceLocation KWLoc, final CXXScopeSpec /*&*/ SS, 
        IdentifierInfo /*P*/ Name, SourceLocation NameLoc, 
        AttributeList /*P*/ Attr, AccessSpecifier AS, 
        SourceLocation ModulePrivateLoc, 
        MutableArrayRef<TemplateParameterList /*P*/ > TemplateParameterLists, 
        final bool$ref/*bool &*/ OwnedDecl, final bool$ref/*bool &*/ IsDependent, 
        SourceLocation ScopedEnumKWLoc, 
        boolean ScopedEnumUsesClassTag, 
        ActionResult<OpaquePtr<QualType> > UnderlyingType, 
        boolean IsTypeSpecifier) {
  return ActOnTag(S, TagSpec, TUK, 
        KWLoc, SS, 
        Name, NameLoc, 
        Attr, AS, 
        ModulePrivateLoc, 
        TemplateParameterLists, 
        OwnedDecl, IsDependent, 
        ScopedEnumKWLoc, 
        ScopedEnumUsesClassTag, 
        UnderlyingType, 
        IsTypeSpecifier, (SkipBodyInfo /*P*/ )null);
}
public final Decl /*P*/ ActOnTag(Scope /*P*/ S, /*uint*/int TagSpec, TagUseKind TUK, 
        SourceLocation KWLoc, final CXXScopeSpec /*&*/ SS, 
        IdentifierInfo /*P*/ Name, SourceLocation NameLoc, 
        AttributeList /*P*/ Attr, AccessSpecifier AS, 
        SourceLocation ModulePrivateLoc, 
        MutableArrayRef<TemplateParameterList /*P*/ > TemplateParameterLists, 
        final bool$ref/*bool &*/ OwnedDecl, final bool$ref/*bool &*/ IsDependent, 
        SourceLocation ScopedEnumKWLoc, 
        boolean ScopedEnumUsesClassTag, 
        ActionResult<OpaquePtr<QualType> > UnderlyingType, 
        boolean IsTypeSpecifier, SkipBodyInfo /*P*/ SkipBody/*= null*/) {
  LookupResult Previous = null;
  try {
    // If this is not a definition, it must have a name.
    IdentifierInfo /*P*/ OrigName = Name;
    assert ((Name != null || TUK == TagUseKind.TUK_Definition)) : "Nameless record must be a definition!";
    assert (TemplateParameterLists.size() == 0 || TUK != TagUseKind.TUK_Reference);
    
    OwnedDecl.$set(false);
    TagTypeKind Kind = TypeWithKeyword.getTagTypeKindForTypeSpec(TagSpec);
    boolean ScopedEnum = ScopedEnumKWLoc.isValid();
    
    // FIXME: Check explicit specializations more carefully.
    bool$ref isExplicitSpecialization = create_bool$ref(false);
    bool$ref Invalid = create_bool$ref(false);
    
    // We only need to do this matching if we have template parameters
    // or a scope specifier, which also conveniently avoids this work
    // for non-C++ cases.
    if ($greater_uint(TemplateParameterLists.size(), 0)
       || (SS.isNotEmpty() && TUK != TagUseKind.TUK_Reference)) {
      {
        TemplateParameterList /*P*/ TemplateParams = $this().MatchTemplateParametersToScopeSpecifier(new SourceLocation(KWLoc), new SourceLocation(NameLoc), SS, (TemplateIdAnnotation /*P*/ )null, new ArrayRef<TemplateParameterList /*P*/ >(TemplateParameterLists), 
            TUK == TagUseKind.TUK_Friend, isExplicitSpecialization, Invalid);
        if ((TemplateParams != null)) {
          if (Kind == TagTypeKind.TTK_Enum) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(new SourceLocation(KWLoc), diag.err_enum_template)));
              return null;
            } finally {
              $c$.$destroy();
            }
          }
          if ($greater_uint(TemplateParams.size(), 0)) {
            // This is a declaration or definition of a class template (which may
            // be a member of another template).
            if (Invalid.$deref()) {
              return null;
            }
            
            OwnedDecl.$set(false);
            ActionResult<Decl /*P*/ > Result = $this().CheckClassTemplate(S, TagSpec, TUK, new SourceLocation(KWLoc), 
                SS, Name, new SourceLocation(NameLoc), Attr, 
                TemplateParams, AS, 
                new SourceLocation(ModulePrivateLoc), 
                /*FriendLoc*/ new SourceLocation(), 
                TemplateParameterLists.size() - 1, 
                TemplateParameterLists.data(), 
                SkipBody);
            return Result.get();
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // The "template<>" header is extraneous.
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(TemplateParams.getTemplateLoc(), diag.err_template_tag_noparams)), 
                      TypeWithKeyword.getTagTypeKindName(Kind)), Name));
              isExplicitSpecialization.$set(true);
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
    
    // Figure out the underlying type if this a enum declaration. We need to do
    // this early, because it's needed to detect if this is an incompatible
    // redeclaration.
    PointerUnion</*const*/ Type /*P*/ , TypeSourceInfo /*P*/ > EnumUnderlying/*J*/= new PointerUnion</*const*/ Type /*P*/ , TypeSourceInfo /*P*/ >(/*const*/ Type /*P*/ .class);
    boolean EnumUnderlyingIsImplicit = false;
    if (Kind == TagTypeKind.TTK_Enum) {
      if (UnderlyingType.isInvalid() || (!UnderlyingType.get().$bool() && ScopedEnum)) {
        // No underlying type explicitly specified, or we failed to parse the
        // type, default to int.
        EnumUnderlying.$assign_T$C$R(Type /*P*/.class, $this().Context.IntTy.getTypePtr());
      } else if (UnderlyingType.get().$bool()) {
        // C++0x 7.2p2: The type-specifier-seq of an enum-base shall name an
        // integral type; any cv-qualification is ignored.
        type$ptr<TypeSourceInfo /*P*/ > TI = create_type$null$ptr(null);
        GetTypeFromParser(UnderlyingType.get(), $AddrOf(TI));
        EnumUnderlying.$assign_T1$C$R(TypeSourceInfo /*P*/.class, TI.$star());
        if ($this().CheckEnumUnderlyingType(TI.$star())) {
          // Recover by falling back to int.
          EnumUnderlying.$assign_T$C$R(Type /*P*/.class, $this().Context.IntTy.getTypePtr());
        }
        if ($this().DiagnoseUnexpandedParameterPack(TI.$star().getTypeLoc().getBeginLoc(), TI.$star(), 
            UnexpandedParameterPackContext.UPPC_FixedUnderlyingType)) {
          EnumUnderlying.$assign_T$C$R(Type /*P*/.class, $this().Context.IntTy.getTypePtr());
        }
      } else if ($this().Context.getTargetInfo().getCXXABI().isMicrosoft()) {
        if ($this().getLangOpts().MSVCCompat || TUK == TagUseKind.TUK_Definition) {
          // Microsoft enums are always of int type.
          EnumUnderlying.$assign_T$C$R(Type /*P*/.class, $this().Context.IntTy.getTypePtr());
          EnumUnderlyingIsImplicit = true;
        }
      }
    }
    
    DeclContext /*P*/ SearchDC = $this().CurContext;
    DeclContext /*P*/ DC = $this().CurContext;
    boolean isStdBadAlloc = false;
    
    RedeclarationKind Redecl = RedeclarationKind.ForRedeclaration;
    if (TUK == TagUseKind.TUK_Friend || TUK == TagUseKind.TUK_Reference) {
      Redecl = RedeclarationKind.NotForRedeclaration;
    }
    
    Previous/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(Name), new SourceLocation(NameLoc), LookupNameKind.LookupTagName, Redecl);
    CreateNewDecl:
    do {
      if ((Name != null) && SS.isNotEmpty()) {
        // We have a nested-name tag ('struct foo::bar').

        // Check for invalid 'foo::'.
        if (SS.isInvalid()) {
          Name = null;
          break CreateNewDecl;
        }

        // If this is a friend or a reference to a class in a dependent
        // context, don't try to make a decl for it.
        if (TUK == TagUseKind.TUK_Friend || TUK == TagUseKind.TUK_Reference) {
          DC = $this().computeDeclContext(SS, false);
          if (!(DC != null)) {
            IsDependent.$set(true);
            return null;
          }
        } else {
          DC = $this().computeDeclContext(SS, true);
          if (!(DC != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SS.getRange().getBegin(), diag.err_dependent_nested_name_spec)), 
                  SS.getRange()));
              return null;
            } finally {
              $c$.$destroy();
            }
          }
        }
        if ($this().RequireCompleteDeclContext(SS, DC)) {
          return null;
        }

        SearchDC = DC;
        // Look-up name inside 'foo::'.
        $this().LookupQualifiedName(Previous, DC);
        if (Previous.isAmbiguous()) {
          return null;
        }
        if (Previous.empty()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Name lookup did not find anything. However, if the
            // nested-name-specifier refers to the current instantiation,
            // and that current instantiation has any dependent base
            // classes, we might find something at instantiation time: treat
            // this as a dependent elaborated-type-specifier.
            // But this only makes any sense for reference-like lookups.
            if (Previous.wasNotFoundInCurrentInstantiation()
               && (TUK == TagUseKind.TUK_Reference || TUK == TagUseKind.TUK_Friend)) {
              IsDependent.$set(true);
              return null;
            }

            // A tag 'foo::bar' must already exist.
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_not_tag_in_scope)), 
                            Kind), Name), DC), SS.getRange()));
            Name = null;
            Invalid.$set(true);
            break CreateNewDecl;
          } finally {
            $c$.$destroy();
          }
        }
      } else if ((Name != null)) {
        // C++14 [class.mem]p14:
        //   If T is the name of a class, then each of the following shall have a
        //   name different from T:
        //    -- every member of class T that is itself a type
        if (TUK != TagUseKind.TUK_Reference && TUK != TagUseKind.TUK_Friend
           && $this().DiagnoseClassNameShadow(SearchDC, new DeclarationNameInfo(new DeclarationName(Name), new SourceLocation(NameLoc)))) {
          return null;
        }

        // If this is a named struct, check to see if there was a previous forward
        // declaration or definition.
        // FIXME: We're looking into outer scopes here, even when we
        // shouldn't be. Doing so can result in ambiguities that we
        // shouldn't be diagnosing.
        $this().LookupName(Previous, S);

        // When declaring or defining a tag, ignore ambiguities introduced
        // by types using'ed into this scope.
        if (Previous.isAmbiguous()
           && (TUK == TagUseKind.TUK_Definition || TUK == TagUseKind.TUK_Declaration)) {
          LookupResult.Filter F = null;
          try {
            F = Previous.makeFilter();
            while (F.hasNext()) {
              NamedDecl /*P*/ ND = F.next();
              if (!ND.getDeclContext().getRedeclContext().Equals(SearchDC.getRedeclContext())) {
                F.erase();
              }
            }
            F.done();
          } finally {
            if (F != null) { F.$destroy(); }
          }
        }

        // C++11 [namespace.memdef]p3:
        //   If the name in a friend declaration is neither qualified nor
        //   a template-id and the declaration is a function or an
        //   elaborated-type-specifier, the lookup to determine whether
        //   the entity has been previously declared shall not consider
        //   any scopes outside the innermost enclosing namespace.
        //
        // MSVC doesn't implement the above rule for types, so a friend tag
        // declaration may be a redeclaration of a type declared in an enclosing
        // scope.  They do implement this rule for friend functions.
        //
        // Does it matter that this should be by scope instead of by
        // semantic context?
        if (!Previous.empty() && TUK == TagUseKind.TUK_Friend) {
          LookupResult.Filter F = null;
          try {
            DeclContext /*P*/ EnclosingNS = SearchDC.getEnclosingNamespaceContext();
            F = Previous.makeFilter();
            boolean FriendSawTagOutsideEnclosingNamespace = false;
            while (F.hasNext()) {
              NamedDecl /*P*/ ND = F.next();
              DeclContext /*P*/ DC$1 = ND.getDeclContext().getRedeclContext();
              if (DC$1.isFileContext()
                 && !EnclosingNS.Encloses(ND.getDeclContext())) {
                if ($this().getLangOpts().MSVCCompat) {
                  FriendSawTagOutsideEnclosingNamespace = true;
                } else {
                  F.erase();
                }
              }
            }
            F.done();

            // Diagnose this MSVC extension in the easy case where lookup would have
            // unambiguously found something outside the enclosing namespace.
            if (Previous.isSingleResult() && FriendSawTagOutsideEnclosingNamespace) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                NamedDecl /*P*/ ND = Previous.getFoundDecl();
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NameLoc), diag.ext_friend_tag_redecl_outside_namespace)), 
                    createFriendTagNNSFixIt(/*Deref*/$this(), ND, S, new SourceLocation(NameLoc))));
              } finally {
                $c$.$destroy();
              }
            }
          } finally {
            if (F != null) { F.$destroy(); }
          }
        }

        // Note:  there used to be some attempt at recovery here.
        if (Previous.isAmbiguous()) {
          return null;
        }
        if (!$this().getLangOpts().CPlusPlus && TUK != TagUseKind.TUK_Reference) {
          // FIXME: This makes sure that we ignore the contexts associated
          // with C structs, unions, and enums when looking for a matching
          // tag declaration or definition. See the similar lookup tweak
          // in Sema::LookupName; is there a better way to deal with this?
          while (isa_RecordDecl(SearchDC) || isa_EnumDecl(SearchDC)) {
            SearchDC = SearchDC.getParent();
          }
        }
      }
      if (Previous.isSingleResult()
         && Previous.getFoundDecl().isTemplateParameter()) {
        // Maybe we will complain about the shadowed template parameter.
        $this().DiagnoseTemplateParameterShadow(new SourceLocation(NameLoc), Previous.getFoundDecl());
        // Just pretend that we didn't see the previous declaration.
        Previous.clear();
      }
      if ($this().getLangOpts().CPlusPlus && (Name != null) && (DC != null) && $this().StdNamespace.$bool()
         && DC.Equals($this().getStdNamespace()) && Name.isStr(/*KEEP_STR*/"bad_alloc")) {
        // This is a declaration of or a reference to "std::bad_alloc".
        isStdBadAlloc = true;
        if (Previous.empty() && $this().StdBadAlloc.$bool()) {
          // std::bad_alloc has been implicitly declared (but made invisible to
          // name lookup). Fill in this implicit declaration as the previous
          // declaration, so that the declarations get chained appropriately.
          Previous.addDecl($this().getStdBadAlloc());
        }
      }

      // If we didn't find a previous declaration, and this is a reference
      // (or friend reference), move to the correct scope.  In C++, we
      // also need to do a redeclaration lookup there, just in case
      // there's a shadow friend decl.
      if ((Name != null) && Previous.empty()
         && (TUK == TagUseKind.TUK_Reference || TUK == TagUseKind.TUK_Friend)) {
        if (Invalid.$deref()) {
        break CreateNewDecl;
        }
        assert (SS.isEmpty());
        if (TUK == TagUseKind.TUK_Reference) {
          // C++ [basic.scope.pdecl]p5:
          //   -- for an elaborated-type-specifier of the form
          //
          //          class-key identifier
          //
          //      if the elaborated-type-specifier is used in the
          //      decl-specifier-seq or parameter-declaration-clause of a
          //      function defined in namespace scope, the identifier is
          //      declared as a class-name in the namespace that contains
          //      the declaration; otherwise, except as a friend
          //      declaration, the identifier is declared in the smallest
          //      non-class, non-function-prototype scope that contains the
          //      declaration.
          //
          // C99 6.7.2.3p8 has a similar (but not identical!) provision for
          // C structs and unions.
          //
          // It is an error in C++ to declare (rather than define) an enum
          // type, including via an elaborated type specifier.  We'll
          // diagnose that later; for now, declare the enum in the same
          // scope as we would have picked for any other tag type.
          //
          // GNU C also supports this behavior as part of its incomplete
          // enum types extension, while GNU C++ does not.
          //
          // Find the context where we'll be declaring the tag.
          // FIXME: We would like to maintain the current DeclContext as the
          // lexical context,
          SearchDC = getTagInjectionContext(SearchDC);

          // Find the scope where we'll be declaring the tag.
          S = getTagInjectionScope(S, $this().getLangOpts());
        } else {
          assert (TUK == TagUseKind.TUK_Friend);
          // C++ [namespace.memdef]p3:
          //   If a friend declaration in a non-local class first declares a
          //   class or function, the friend class or function is a member of
          //   the innermost enclosing namespace.
          SearchDC = SearchDC.getEnclosingNamespaceContext();
        }

        // In C++, we need to do a redeclaration lookup to properly
        // diagnose some problems.
        // FIXME: redeclaration lookup is also used (with and without C++) to find a
        // hidden declaration so that we don't get ambiguity errors when using a
        // type declared by an elaborated-type-specifier.  In C that is not correct
        // and we should instead merge compatible types found by lookup.
        if ($this().getLangOpts().CPlusPlus) {
          Previous.setRedeclarationKind(RedeclarationKind.ForRedeclaration);
          $this().LookupQualifiedName(Previous, SearchDC);
        } else {
          Previous.setRedeclarationKind(RedeclarationKind.ForRedeclaration);
          $this().LookupName(Previous, S);
        }
      }

      // If we have a known previous declaration to use, then use it.
      if (Previous.empty() && (SkipBody != null) && (SkipBody.Previous != null)) {
        Previous.addDecl(SkipBody.Previous);
      }
      if (!Previous.empty()) {
        NamedDecl /*P*/ PrevDecl = Previous.getFoundDecl();
        NamedDecl /*P*/ DirectPrevDecl = Previous.getRepresentativeDecl();

        // It's okay to have a tag decl in the same scope as a typedef
        // which hides a tag decl in the same scope.  Finding this
        // insanity with a redeclaration lookup can only actually happen
        // in C++.
        //
        // This is also okay for elaborated-type-specifiers, which is
        // technically forbidden by the current standard but which is
        // okay according to the likely resolution of an open issue;
        // see http://www.open-std.org/jtc1/sc22/wg21/docs/cwg_active.html#407
        if ($this().getLangOpts().CPlusPlus) {
          {
            TypedefNameDecl /*P*/ TD = dyn_cast_TypedefNameDecl(PrevDecl);
            if ((TD != null)) {
              {
                /*const*/ TagType /*P*/ TT = TD.getUnderlyingType().$arrow().getAs(TagType.class);
                if ((TT != null)) {
                  TagDecl /*P*/ Tag = TT.getDecl();
                  if ($eq_DeclarationName(Tag.getDeclName(), new DeclarationName(Name))
                     && Tag.getDeclContext().getRedeclContext().
                      Equals(TD.getDeclContext().getRedeclContext())) {
                    PrevDecl = Tag;
                    Previous.clear();
                    Previous.addDecl(Tag);
                    Previous.resolveKind();
                  }
                }
              }
            }
          }
        }
        {

          // If this is a redeclaration of a using shadow declaration, it must
          // declare a tag in the same context. In MSVC mode, we allow a
          // redefinition if either context is within the other.
          UsingShadowDecl /*P*/ Shadow = dyn_cast_UsingShadowDecl(DirectPrevDecl);
          if ((Shadow != null)) {
            TagDecl /*P*/ OldTag = dyn_cast_TagDecl(PrevDecl);
            if (SS.isEmpty() && TUK != TagUseKind.TUK_Reference && TUK != TagUseKind.TUK_Friend
               && $this().isDeclInScope(Shadow, SearchDC, S, isExplicitSpecialization.$deref())
               && !((OldTag != null) && isAcceptableTagRedeclContext(/*Deref*/$this(), OldTag.getDeclContext(), SearchDC))) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track($this().Diag(new SourceLocation(KWLoc), diag.err_using_decl_conflict_reverse)));
                $c$.clean($c$.track($this().Diag(Shadow.getTargetDecl().getLocation(), 
                    diag.note_using_decl_target)));
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Shadow.getUsingDecl().getLocation(), diag.note_using_decl)), 
                    0));
                // Recover by ignoring the old declaration.
                Previous.clear();
                break CreateNewDecl;
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
        {

          TagDecl /*P*/ PrevTagDecl = dyn_cast_TagDecl(PrevDecl);
          if ((PrevTagDecl != null)) {
            // If this is a use of a previous tag, or if the tag is already declared
            // in the same scope (so that the definition/declaration completes or
            // rementions the tag), reuse the decl.
            if (TUK == TagUseKind.TUK_Reference || TUK == TagUseKind.TUK_Friend
               || $this().isDeclInScope(DirectPrevDecl, SearchDC, S, 
                SS.isNotEmpty() || isExplicitSpecialization.$deref())) {
              // Make sure that this wasn't declared as an enum and now used as a
              // struct or something similar.
              if (!$this().isAcceptableTagRedeclaration(PrevTagDecl, Kind, 
                  TUK == TagUseKind.TUK_Definition, new SourceLocation(KWLoc), 
                  Name)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  boolean SafeToContinue = (PrevTagDecl.getTagKind() != TagTypeKind.TTK_Enum
                     && Kind != TagTypeKind.TTK_Enum);
                  if (SafeToContinue) {
                    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(KWLoc), diag.err_use_with_wrong_tag)), 
                            Name), 
                        FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/KWLoc), 
                            PrevTagDecl.getKindName())));
                  } else {
                    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(KWLoc), diag.err_use_with_wrong_tag)), Name));
                  }
                  $c$.clean($c$.track($this().Diag(PrevTagDecl.getLocation(), diag.note_previous_use)));
                  if (SafeToContinue) {
                    Kind = PrevTagDecl.getTagKind();
                  } else {
                    // Recover by making this an anonymous redefinition.
                    Name = null;
                    Previous.clear();
                    Invalid.$set(true);
                  }
                } finally {
                  $c$.$destroy();
                }
              }
              if (Kind == TagTypeKind.TTK_Enum && PrevTagDecl.getTagKind() == TagTypeKind.TTK_Enum) {
                /*const*/ EnumDecl /*P*/ PrevEnum = cast_EnumDecl(PrevTagDecl);

                // If this is an elaborated-type-specifier for a scoped enumeration,
                // the 'class' keyword is not necessary and not permitted.
                if (TUK == TagUseKind.TUK_Reference || TUK == TagUseKind.TUK_Friend) {
                  if (ScopedEnum) {
                    JavaCleaner $c$ = $createJavaCleaner();
                    try {
                      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ScopedEnumKWLoc), diag.err_enum_class_reference)), 
                              PrevEnum.isScoped()), 
                          FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/ScopedEnumKWLoc))));
                    } finally {
                      $c$.$destroy();
                    }
                  }
                  return PrevTagDecl;
                }

                QualType EnumUnderlyingTy/*J*/= new QualType();
                {
                  TypeSourceInfo /*P*/ TI = EnumUnderlying.dyn_cast(TypeSourceInfo /*P*/.class);
                  if ((TI != null)) {
                    EnumUnderlyingTy.$assignMove(TI.getType().getUnqualifiedType());
                  } else {
                    /*const*/ Type /*P*/ T = EnumUnderlying.dyn_cast(/*const*/ Type /*P*/.class);
                    if ((T != null)) {
                      EnumUnderlyingTy.$assignMove(new QualType(T, 0));
                    }
                  }
                }

                // All conflicts with previous declarations are recovered by
                // returning the previous declaration, unless this is a definition,
                // in which case we want the caller to bail out.
                if ($this().CheckEnumRedeclaration(new SourceLocation(NameLoc.isValid() ? NameLoc : KWLoc), 
                    ScopedEnum, new QualType(EnumUnderlyingTy), 
                    EnumUnderlyingIsImplicit, PrevEnum)) {
                  return TUK == TagUseKind.TUK_Declaration ? PrevTagDecl : null;
                }
              }

              // C++11 [class.mem]p1:
              //   A member shall not be declared twice in the member-specification,
              //   except that a nested class or member class template can be declared
              //   and then later defined.
              if (TUK == TagUseKind.TUK_Declaration && PrevDecl.isCXXClassMember()
                 && S.isDeclScope(PrevDecl)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($c$.track($this().Diag(new SourceLocation(NameLoc), diag.ext_member_redeclared)));
                  $c$.clean($c$.track($this().Diag(PrevTagDecl.getLocation(), diag.note_previous_declaration)));
                } finally {
                  $c$.$destroy();
                }
              }
              if (!Invalid.$deref()) {
                // If this is a use, just return the declaration we found, unless
                // we have attributes.
                if (TUK == TagUseKind.TUK_Reference || TUK == TagUseKind.TUK_Friend) {
                  if ((Attr != null)) {
                    // FIXME: Diagnose these attributes. For now, we create a new
                    // declaration to hold them.
                  } else if (TUK == TagUseKind.TUK_Reference
                     && (PrevTagDecl.getFriendObjectKind()
                     == Decl.FriendObjectKind.FOK_Undeclared
                     || $this().PP.getModuleContainingLocation(PrevDecl.getLocation())
                     != $this().PP.getModuleContainingLocation(/*NO_COPY*/KWLoc))
                     && SS.isEmpty()) {
                    // This declaration is a reference to an existing entity, but
                    // has different visibility from that entity: it either makes
                    // a friend visible or it makes a type visible in a new module.
                    // In either case, create a new declaration. We only do this if
                    // the declaration would have meant the same thing if no prior
                    // declaration were found, that is, if it was found in the same
                    // scope where we would have injected a declaration.
                    if (!getTagInjectionContext($this().CurContext).getRedeclContext().
                        Equals(PrevDecl.getDeclContext().getRedeclContext())) {
                      return PrevTagDecl;
                    }
                    // This is in the injected scope, create a new declaration in
                    // that scope.
                    S = getTagInjectionScope(S, $this().getLangOpts());
                  } else {
                    return PrevTagDecl;
                  }
                }

                // Diagnose attempts to redefine a tag.
                if (TUK == TagUseKind.TUK_Definition) {
                  {
                    NamedDecl /*P*/ Def = PrevTagDecl.getDefinition();
                    if ((Def != null)) {
                      // If we're defining a specialization and the previous definition
                      // is from an implicit instantiation, don't emit an error
                      // here; we'll catch this in the general case below.
                      boolean IsExplicitSpecializationAfterInstantiation = false;
                      if (isExplicitSpecialization.$deref()) {
                        {
                          CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(Def);
                          if ((RD != null)) {
                            IsExplicitSpecializationAfterInstantiation
                               = RD.getTemplateSpecializationKind()
                               != TemplateSpecializationKind.TSK_ExplicitSpecialization;
                          } else {
                            EnumDecl /*P*/ ED = dyn_cast_EnumDecl(Def);
                            if ((ED != null)) {
                              IsExplicitSpecializationAfterInstantiation
                                 = ED.getTemplateSpecializationKind()
                                 != TemplateSpecializationKind.TSK_ExplicitSpecialization;
                            }
                          }
                        }
                      }

                      type$ptr<NamedDecl /*P*/ > Hidden = create_type$null$ptr(null);
                      if ((SkipBody != null) && $this().getLangOpts().CPlusPlus
                         && !$this().hasVisibleDefinition(Def, $AddrOf(Hidden))) {
                        // There is a definition of this tag, but it is not visible. We
                        // explicitly make use of C++'s one definition rule here, and
                        // assume that this definition is identical to the hidden one
                        // we already have. Make the existing definition visible and
                        // use it in place of this one.
                        SkipBody.ShouldSkip = true;
                        $this().makeMergedDefinitionVisible(Hidden.$star(), new SourceLocation(KWLoc));
                        return Def;
                      } else if (!IsExplicitSpecializationAfterInstantiation) {
                        JavaCleaner $c$ = $createJavaCleaner();
                        try {
                          // A redeclaration in function prototype scope in C isn't
                          // visible elsewhere, so merely issue a warning.
                          if (!$this().getLangOpts().CPlusPlus && S.containedInPrototypeScope()) {
                            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NameLoc), diag.warn_redefinition_in_param_list)), Name));
                          } else {
                            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_redefinition)), Name));
                          }
                          $c$.clean($c$.track($this().Diag(Def.getLocation(), diag.note_previous_definition)));
                          // If this is a redefinition, recover by making this
                          // struct be anonymous, which will make any later
                          // references get the previous definition.
                          Name = null;
                          Previous.clear();
                          Invalid.$set(true);
                        } finally {
                          $c$.$destroy();
                        }
                      }
                    } else {
                      // If the type is currently being defined, complain
                      // about a nested redefinition.
                      TagDecl /*P*/ TD = $this().Context.getTagDeclType(PrevTagDecl).$arrow().getAsTagDecl();
                      if (TD.isBeingDefined()) {
                        JavaCleaner $c$ = $createJavaCleaner();
                        try {
                          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_nested_redefinition)), Name));
                          $c$.clean($c$.track($this().Diag(PrevTagDecl.getLocation(), 
                              diag.note_previous_definition)));
                          Name = null;
                          Previous.clear();
                          Invalid.$set(true);
                        } finally {
                          $c$.$destroy();
                        }
                      }
                    }
                  }
                  // Okay, this is definition of a previously declared or referenced
                  // tag. We're going to create a new Decl for it.
                }

                // Okay, we're going to make a redeclaration.  If this is some kind
                // of reference, make sure we build the redeclaration in the same DC
                // as the original, and ignore the current access specifier.
                if (TUK == TagUseKind.TUK_Friend || TUK == TagUseKind.TUK_Reference) {
                  SearchDC = PrevTagDecl.getDeclContext();
                  AS = AccessSpecifier.AS_none;
                }
              }
              // If we get here we have (another) forward declaration or we
              // have a definition.  Just create a new decl.
            } else {
              // If we get here, this is a definition of a new tag type in a nested
              // scope, e.g. "struct foo; void bar() { struct foo; }", just create a
              // new decl/type.  We set PrevDecl to NULL so that the entities
              // have distinct types.
              Previous.clear();
            }

            // If we get here, we're going to create a new Decl. If PrevDecl
            // is non-NULL, it's a definition of the tag declared by
            // PrevDecl. If it's NULL, we have a new definition.

            // Otherwise, PrevDecl is not a tag, but was found with tag
            // lookup.  This is only actually possible in C++, where a few
            // things like templates still live in the tag namespace.
          } else {
            // Use a better diagnostic if an elaborated-type-specifier
            // found the wrong kind of type on the first
            // (non-redeclaration) lookup.
            if ((TUK == TagUseKind.TUK_Reference || TUK == TagUseKind.TUK_Friend)
               && !Previous.isForRedeclaration()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                /*uint*/int Kind$1 = 0;
                if (isa_TypedefDecl(PrevDecl)) {
                  Kind$1 = 1;
                } else if (isa_TypeAliasDecl(PrevDecl)) {
                  Kind$1 = 2;
                } else if (isa_ClassTemplateDecl(PrevDecl)) {
                  Kind$1 = 3;
                }
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_tag_reference_non_tag)), Kind$1));
                $c$.clean($c$.track($this().Diag(PrevDecl.getLocation(), diag.note_declared_at)));
                Invalid.$set(true);
              } finally {
                $c$.$destroy();
              }
              // Otherwise, only diagnose if the declaration is in scope.
            } else if (!$this().isDeclInScope(DirectPrevDecl, SearchDC, S, 
                SS.isNotEmpty() || isExplicitSpecialization.$deref())) {

              // do nothing

              // Diagnose implicit declarations introduced by elaborated types.
            } else if (TUK == TagUseKind.TUK_Reference || TUK == TagUseKind.TUK_Friend) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                /*uint*/int Kind$1 = 0;
                if (isa_TypedefDecl(PrevDecl)) {
                  Kind$1 = 1;
                } else if (isa_TypeAliasDecl(PrevDecl)) {
                  Kind$1 = 2;
                } else if (isa_ClassTemplateDecl(PrevDecl)) {
                  Kind$1 = 3;
                }
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_tag_reference_conflict)), Kind$1));
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(PrevDecl.getLocation(), diag.note_previous_decl)), PrevDecl));
                Invalid.$set(true);
              } finally {
                $c$.$destroy();
              }
              // Otherwise it's a declaration.  Call out a particularly common
              // case here.
            } else {
              TypedefNameDecl /*P*/ TND = dyn_cast_TypedefNameDecl(PrevDecl);
              if ((TND != null)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  /*uint*/int Kind$1 = 0;
                  if (isa_TypeAliasDecl(PrevDecl)) {
                    Kind$1 = 1;
                  }
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_tag_definition_of_typedef)), 
                              Name), Kind$1), TND.getUnderlyingType()));
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(PrevDecl.getLocation(), diag.note_previous_decl)), PrevDecl));
                  Invalid.$set(true);
                } finally {
                  $c$.$destroy();
                }
                // Otherwise, diagnose.
              } else {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  // The tag name clashes with something else in the target scope,
                  // issue an error and recover by making this tag be anonymous.
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_redefinition_different_kind)), Name));
                  $c$.clean($c$.track($this().Diag(PrevDecl.getLocation(), diag.note_previous_definition)));
                  Name = null;
                  Invalid.$set(true);
                } finally {
                  $c$.$destroy();
                }
              }
            }

            // The existing declaration isn't relevant to us; we're in a
            // new scope, so clear out the previous declaration.
            Previous.clear();
          }
        }
      }
    } while (false);
   //CreateNewDecl:
    
    TagDecl /*P*/ PrevDecl = null;
    if (Previous.isSingleResult()) {
      PrevDecl = cast_TagDecl(Previous.getFoundDecl());
    }
    
    // If there is an identifier, use the location of the identifier as the
    // location of the decl, otherwise use the location of the struct/union
    // keyword.
    SourceLocation Loc = new SourceLocation(NameLoc.isValid() ? NameLoc : KWLoc);
    
    // Otherwise, create a new declaration. If there is a previous
    // declaration of the same entity, the two will be linked via
    // PrevDecl.
    TagDecl /*P*/ New;
    
    boolean IsForwardReference = false;
    if (Kind == TagTypeKind.TTK_Enum) {
      // FIXME: Tag decls should be chained to any simultaneous vardecls, e.g.:
      // enum X { A, B, C } D;    D should chain to X.
      New = EnumDecl.Create($this().Context, SearchDC, new SourceLocation(KWLoc), new SourceLocation(Loc), Name, 
          cast_or_null_EnumDecl(PrevDecl), ScopedEnum, 
          ScopedEnumUsesClassTag, !EnumUnderlying.isNull());
      // If this is an undefined enum, warn.
      if (TUK != TagUseKind.TUK_Definition && !Invalid.$deref()) {
        TagDecl /*P*/ Def;
        if (($this().getLangOpts().CPlusPlus11 || $this().getLangOpts().ObjC2)
           && cast_EnumDecl(New).isFixed()) {
          // C++0x: 7.2p2: opaque-enum-declaration.
          // Conflicts are diagnosed above. Do nothing.
        } else if ((PrevDecl != null) && ((Def = cast_EnumDecl(PrevDecl).getDefinition()) != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.ext_forward_ref_enum_def)), 
                New));
            $c$.clean($c$.track($this().Diag(Def.getLocation(), diag.note_previous_definition)));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*uint*/int DiagID = diag.ext_forward_ref_enum;
            if ($this().getLangOpts().MSVCCompat) {
              DiagID = diag.ext_ms_forward_ref_enum;
            } else if ($this().getLangOpts().CPlusPlus) {
              DiagID = diag.err_forward_ref_enum;
            }
            $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), DiagID)));
            
            // If this is a forward-declared reference to an enumeration, make a
            // note of it; we won't actually be introducing the declaration into
            // the declaration context.
            if (TUK == TagUseKind.TUK_Reference) {
              IsForwardReference = true;
            }
          } finally {
            $c$.$destroy();
          }
        }
      }
      if (EnumUnderlying.$bool()) {
        EnumDecl /*P*/ ED = cast_EnumDecl(New);
        {
          TypeSourceInfo /*P*/ TI = EnumUnderlying.dyn_cast(TypeSourceInfo /*P*/.class);
          if ((TI != null)) {
            ED.setIntegerTypeSourceInfo(TI);
          } else {
            ED.setIntegerType(new QualType(EnumUnderlying.get(/*const*/ Type /*P*/.class), 0));
          }
        }
        ED.setPromotionType(ED.getIntegerType());
      }
    } else {
      // struct/union/class
      
      // FIXME: Tag decls should be chained to any simultaneous vardecls, e.g.:
      // struct X { int A; } D;    D should chain to X.
      if ($this().getLangOpts().CPlusPlus) {
        // FIXME: Look for a way to use RecordDecl for simple structs.
        New = CXXRecordDecl.Create($this().Context, Kind, SearchDC, new SourceLocation(KWLoc), new SourceLocation(Loc), Name, 
            cast_or_null_CXXRecordDecl(PrevDecl));
        if (isStdBadAlloc && (!$this().StdBadAlloc.$bool() || $this().getStdBadAlloc().isImplicit())) {
          $this().StdBadAlloc.$assign(cast_CXXRecordDecl(New));
        }
      } else {
        New = RecordDecl.Create($this().Context, Kind, SearchDC, new SourceLocation(KWLoc), new SourceLocation(Loc), Name, 
            cast_or_null_RecordDecl(PrevDecl));
      }
    }
    
    // C++11 [dcl.type]p3:
    //   A type-specifier-seq shall not define a class or enumeration [...].
    if ($this().getLangOpts().CPlusPlus && IsTypeSpecifier && TUK == TagUseKind.TUK_Definition) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_type_defined_in_type_specifier)), 
            $this().Context.getTagDeclType(New)));
        Invalid.$set(true);
      } finally {
        $c$.$destroy();
      }
    }
    
    // Maybe add qualifier info.
    if (SS.isNotEmpty()) {
      if (SS.isSet()) {
        // If this is either a declaration or a definition, check the
        // nested-name-specifier against the current context. We don't do this
        // for explicit specializations, because they have similar checking
        // (with more specific diagnostics) in the call to
        // CheckMemberSpecialization, below.
        if (!isExplicitSpecialization.$deref()
           && (TUK == TagUseKind.TUK_Definition || TUK == TagUseKind.TUK_Declaration)
           && $this().diagnoseQualifiedDeclaration(SS, DC, new DeclarationName(OrigName), new SourceLocation(Loc))) {
          Invalid.$set(true);
        }
        
        New.setQualifierInfo(SS.getWithLocInContext($this().Context));
        if ($greater_uint(TemplateParameterLists.size(), 0)) {
          New.setTemplateParameterListsInfo($this().Context, new ArrayRef<TemplateParameterList /*P*/ >(TemplateParameterLists));
        }
      } else {
        Invalid.$set(true);
      }
    }
    {
      
      RecordDecl /*P*/ RD = dyn_cast_RecordDecl(New);
      if ((RD != null)) {
        // Add alignment attributes if necessary; these attributes are checked when
        // the ASTContext lays out the structure.
        //
        // It is important for implementing the correct semantics that this
        // happen here (in act on tag decl). The #pragma pack stack is
        // maintained as a result of parser callbacks which can occur at
        // many points during the parsing of a struct declaration (because
        // the #pragma tokens are effectively skipped over during the
        // parsing of the struct).
        if (TUK == TagUseKind.TUK_Definition) {
          $this().AddAlignmentAttributesForRecord(RD);
          $this().AddMsStructLayoutForRecord(RD);
        }
      }
    }
    if (ModulePrivateLoc.isValid()) {
      if (isExplicitSpecialization.$deref()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_module_private_specialization)), 
                  2), 
              FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/ModulePrivateLoc))));
        } finally {
          $c$.$destroy();
        }
      } else // __module_private__ does not apply to local classes. However, we only
      // diagnose this as an error when the declaration specifiers are
      // freestanding. Here, we just ignore the __module_private__.
      if (!SearchDC.isFunctionOrMethod()) {
        New.setModulePrivate();
      }
    }
    
    // If this is a specialization of a member class (of a class template),
    // check the specialization.
    if (isExplicitSpecialization.$deref() && $this().CheckMemberSpecialization(New, Previous)) {
      Invalid.$set(true);
    }
    
    // If we're declaring or defining a tag in function prototype scope in C,
    // note that this type can only be used within the function and add it to
    // the list of decls to inject into the function definition scope.
    if (((Name != null) || Kind == TagTypeKind.TTK_Enum)
       && $this().getNonFieldDeclScope(S).isFunctionPrototypeScope()) {
      if ($this().getLangOpts().CPlusPlus) {
        // C++ [dcl.fct]p6:
        //   Types shall not be defined in return or parameter types.
        if (TUK == TagUseKind.TUK_Definition && !IsTypeSpecifier) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_type_defined_in_param_type)), 
                Name));
            Invalid.$set(true);
          } finally {
            $c$.$destroy();
          }
        }
      } else if (!(PrevDecl != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_decl_in_param_list)), $this().Context.getTagDeclType(New)));
        } finally {
          $c$.$destroy();
        }
      }
      $this().DeclsInPrototypeScope.push_back_T$RR(New);
    }
    if (Invalid.$deref()) {
      New.setInvalidDecl();
    }
    if ((Attr != null)) {
      $this().ProcessDeclAttributeList(S, New, Attr);
    }
    
    // Set the lexical context. If the tag has a C++ scope specifier, the
    // lexical context will be different from the semantic context.
    New.setLexicalDeclContext($this().CurContext);
    
    // Mark this as a friend decl if applicable.
    // In Microsoft mode, a friend declaration also acts as a forward
    // declaration so we always pass true to setObjectOfFriendDecl to make
    // the tag name visible.
    if (TUK == TagUseKind.TUK_Friend) {
      New.setObjectOfFriendDecl($this().getLangOpts().MSVCCompat);
    }
    
    // Set the access specifier.
    if (!Invalid.$deref() && SearchDC.isRecord()) {
      $this().SetMemberAccessSpecifier(New, PrevDecl, AS);
    }
    if (TUK == TagUseKind.TUK_Definition) {
      New.startDefinition();
    }
    
    // If this has an identifier, add it to the scope stack.
    if (TUK == TagUseKind.TUK_Friend) {
      // We might be replacing an existing declaration in the lookup tables;
      // if so, borrow its access specifier.
      if ((PrevDecl != null)) {
        New.setAccess(PrevDecl.getAccess());
      }
      
      DeclContext /*P*/ DC$1 = New.getDeclContext().getRedeclContext();
      DC$1.makeDeclVisibleInContext(New);
      if ((Name != null)) { // can be null along some error paths
        {
          Scope /*P*/ EnclosingScope = getScopeForDeclContext(S, DC$1);
          if ((EnclosingScope != null)) {
            $this().PushOnScopeChains(New, EnclosingScope, /* AddToContext = */ false);
          }
        }
      }
    } else if ((Name != null)) {
      S = $this().getNonFieldDeclScope(S);
      $this().PushOnScopeChains(New, S, !IsForwardReference);
      if (IsForwardReference) {
        SearchDC.makeDeclVisibleInContext(New);
      }
    } else {
      $this().CurContext.addDecl(New);
    }
    {
      
      // If this is the C FILE type, notify the AST context.
      IdentifierInfo /*P*/ II = New.getIdentifier();
      if ((II != null)) {
        if (!New.isInvalidDecl()
           && New.getDeclContext().getRedeclContext().isTranslationUnit()
           && II.isStr(/*KEEP_STR*/"FILE")) {
          $this().Context.setFILEDecl(New);
        }
      }
    }
    if ((PrevDecl != null)) {
      $this().mergeDeclAttributes(New, PrevDecl);
    }
    
    // If there's a #pragma GCC visibility in scope, set the visibility of this
    // record.
    $this().AddPushedVisibilityAttribute(New);
    
    OwnedDecl.$set(true);
    // In C++, don't return an invalid declaration. We can't recover well from
    // the cases where we make the type anonymous.
    return (Invalid.$deref() && $this().getLangOpts().CPlusPlus) ? null : New;
  } finally {
    if (Previous != null) { Previous.$destroy(); }
  }
}


/// ActOnField - Each field of a C struct/union is passed into this in order
/// to create a FieldDecl object for it.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnField">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 13334,
 FQN="clang::Sema::ActOnField", NM="_ZN5clang4Sema10ActOnFieldEPNS_5ScopeEPNS_4DeclENS_14SourceLocationERNS_10DeclaratorEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema10ActOnFieldEPNS_5ScopeEPNS_4DeclENS_14SourceLocationERNS_10DeclaratorEPNS_4ExprE")
//</editor-fold>
public final Decl /*P*/ ActOnField(Scope /*P*/ S, Decl /*P*/ TagD, SourceLocation DeclStart, 
          final Declarator /*&*/ D, Expr /*P*/ BitfieldWidth) {
  FieldDecl /*P*/ Res = $this().HandleField(S, cast_or_null_RecordDecl(TagD), 
      new SourceLocation(DeclStart), D, ((/*static_cast*/Expr /*P*/ )(BitfieldWidth)), 
      /*InitStyle=*/ InClassInitStyle.ICIS_NoInit, AccessSpecifier.AS_public);
  return Res;
}


/// HandleField - Analyze a field of a C struct or a C++ data member.
///
//<editor-fold defaultstate="collapsed" desc="clang::Sema::HandleField">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 13344,
 FQN="clang::Sema::HandleField", NM="_ZN5clang4Sema11HandleFieldEPNS_5ScopeEPNS_10RecordDeclENS_14SourceLocationERNS_10DeclaratorEPNS_4ExprENS_16InClassInitStyleENS_15AccessSpecifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema11HandleFieldEPNS_5ScopeEPNS_10RecordDeclENS_14SourceLocationERNS_10DeclaratorEPNS_4ExprENS_16InClassInitStyleENS_15AccessSpecifierE")
//</editor-fold>
public final FieldDecl /*P*/ HandleField(Scope /*P*/ S, RecordDecl /*P*/ Record, 
           SourceLocation DeclStart, 
           final Declarator /*&*/ D, Expr /*P*/ BitWidth, 
           InClassInitStyle InitStyle, 
           AccessSpecifier AS) {
  LookupResult Previous = null;
  try {
    IdentifierInfo /*P*/ II = D.getIdentifier();
    SourceLocation Loc = new SourceLocation(DeclStart);
    if ((II != null)) {
      Loc.$assignMove(D.getIdentifierLoc());
    }
    
    TypeSourceInfo /*P*/ TInfo = $this().GetTypeForDeclarator(D, S);
    QualType T = TInfo.getType();
    if ($this().getLangOpts().CPlusPlus) {
      $this().CheckExtraCXXDefaultArguments(D);
      if ($this().DiagnoseUnexpandedParameterPack(D.getIdentifierLoc(), TInfo, 
          UnexpandedParameterPackContext.UPPC_DataMemberType)) {
        D.setInvalidType();
        T.$assignMove($this().Context.IntTy.$QualType());
        TInfo = $this().Context.getTrivialTypeSourceInfo(/*NO_COPY*/T, /*NO_COPY*/Loc);
      }
    }
    
    // TR 18037 does not allow fields to be declared with address spaces.
    if (T.getQualifiers().hasAddressSpace()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_field_with_address_space)));
        D.setInvalidType();
      } finally {
        $c$.$destroy();
      }
    }
    
    // OpenCL v1.2 s6.9b,r & OpenCL v2.0 s6.12.5 - The following types cannot be
    // used as structure or union field: image, sampler, event or block types.
    if ($this().LangOpts.OpenCL && (T.$arrow().isEventT() || T.$arrow().isImageType()
       || T.$arrow().isSamplerT() || T.$arrow().isBlockPointerType())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_opencl_type_struct_or_union_field)), T));
        D.setInvalidType();
      } finally {
        $c$.$destroy();
      }
    }
    
    $this().DiagnoseFunctionSpecifiers(D.getDeclSpec());
    if (D.getDeclSpec().isInlineSpecified()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getInlineSpecLoc(), diag.err_inline_non_function)), 
            $this().getLangOpts().CPlusPlus1z));
      } finally {
        $c$.$destroy();
      }
    }
    {
      ThreadStorageClassSpecifier TSCS = D.getDeclSpec().getThreadStorageClassSpec();
      if ((TSCS.getValue() != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getThreadStorageClassSpecLoc(), 
                  diag.err_invalid_thread)), 
              DeclSpec.getSpecifierName_ThreadStorageClassSpecifier(TSCS)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Check to see if this name was declared as a member previously
    NamedDecl /*P*/ PrevDecl = null;
    Previous/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(II), new SourceLocation(Loc), LookupNameKind.LookupMemberName, RedeclarationKind.ForRedeclaration);
    $this().LookupName(Previous, S);
    switch (Previous.getResultKind()) {
     case Found:
     case FoundUnresolvedValue:
      PrevDecl = Previous.<NamedDecl>getAsSingle(NamedDecl.class);
      break;
     case FoundOverloaded:
      PrevDecl = Previous.getRepresentativeDecl();
      break;
     case NotFound:
     case NotFoundInCurrentInstantiation:
     case Ambiguous:
      break;
    }
    Previous.suppressDiagnostics();
    if ((PrevDecl != null) && PrevDecl.isTemplateParameter()) {
      // Maybe we will complain about the shadowed template parameter.
      $this().DiagnoseTemplateParameterShadow(D.getIdentifierLoc(), PrevDecl);
      // Just pretend that we didn't see the previous declaration.
      PrevDecl = null;
    }
    if ((PrevDecl != null) && !$this().isDeclInScope(PrevDecl, Record, S)) {
      PrevDecl = null;
    }
    
    boolean Mutable = (D.getDeclSpec().getStorageClassSpec() == DeclSpec.SCS.SCS_mutable);
    SourceLocation TSSL = D.getLocStart();
    FieldDecl /*P*/ NewFD = $this().CheckFieldDecl(new DeclarationName(II), new QualType(T), TInfo, Record, new SourceLocation(Loc), Mutable, BitWidth, InitStyle, 
        new SourceLocation(TSSL), AS, PrevDecl, $AddrOf(D));
    if (NewFD.isInvalidDecl()) {
      Record.setInvalidDecl();
    }
    if (D.getDeclSpec().isModulePrivateSpecified()) {
      NewFD.setModulePrivate();
    }
    if (NewFD.isInvalidDecl() && (PrevDecl != null)) {
      // Don't introduce NewFD into scope; there's already something
      // with the same name in the same scope.
    } else if ((II != null)) {
      $this().PushOnScopeChains(NewFD, S);
    } else {
      Record.addDecl(NewFD);
    }
    
    return NewFD;
  } finally {
    if (Previous != null) { Previous.$destroy(); }
  }
}


/// \brief Build a new FieldDecl and check its well-formedness.
///
/// This routine builds a new FieldDecl given the fields name, type,
/// record, etc. \p PrevDecl should refer to any previous declaration
/// with the same name and in the same scope as the field to be
/// created.
///
/// \returns a new FieldDecl.
///
/// \todo The Declarator argument is a hack. It will be removed once
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckFieldDecl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 13455,
 FQN="clang::Sema::CheckFieldDecl", NM="_ZN5clang4Sema14CheckFieldDeclENS_15DeclarationNameENS_8QualTypeEPNS_14TypeSourceInfoEPNS_10RecordDeclENS_14SourceLocationEbPNS_4ExprENS_16InClassInitStyleES7_NS_15AccessSpecifierEPNS_9NamedDeclEPNS_10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema14CheckFieldDeclENS_15DeclarationNameENS_8QualTypeEPNS_14TypeSourceInfoEPNS_10RecordDeclENS_14SourceLocationEbPNS_4ExprENS_16InClassInitStyleES7_NS_15AccessSpecifierEPNS_9NamedDeclEPNS_10DeclaratorE")
//</editor-fold>
public final FieldDecl /*P*/ CheckFieldDecl(DeclarationName Name, QualType T, 
              TypeSourceInfo /*P*/ TInfo, 
              RecordDecl /*P*/ Record, SourceLocation Loc, 
              boolean Mutable, Expr /*P*/ BitWidth, 
              InClassInitStyle InitStyle, 
              SourceLocation TSSL, 
              AccessSpecifier AS, NamedDecl /*P*/ PrevDecl) {
  return CheckFieldDecl(Name, T, 
              TInfo, 
              Record, Loc, 
              Mutable, BitWidth, 
              InitStyle, 
              TSSL, 
              AS, PrevDecl, 
              (Declarator /*P*/ )null);
}
public final FieldDecl /*P*/ CheckFieldDecl(DeclarationName Name, QualType T, 
              TypeSourceInfo /*P*/ TInfo, 
              RecordDecl /*P*/ Record, SourceLocation Loc, 
              boolean Mutable, Expr /*P*/ BitWidth, 
              InClassInitStyle InitStyle, 
              SourceLocation TSSL, 
              AccessSpecifier AS, NamedDecl /*P*/ PrevDecl, 
              Declarator /*P*/ D/*= null*/) {
  IdentifierInfo /*P*/ II = Name.getAsIdentifierInfo();
  boolean InvalidDecl = false;
  if ((D != null)) {
    InvalidDecl = D.isInvalidType();
  }
  
  // If we receive a broken type, recover by assuming 'int' and
  // marking this declaration as invalid.
  if (T.isNull()) {
    InvalidDecl = true;
    T.$assignMove($this().Context.IntTy.$QualType());
  }
  
  QualType EltTy = $this().Context.getBaseElementType(new QualType(T));
  if (!EltTy.$arrow().isDependentType()) {
    if ($this().RequireCompleteType(new SourceLocation(Loc), new QualType(EltTy), diag.err_field_incomplete)) {
      // Fields of incomplete type force their record to be invalid.
      Record.setInvalidDecl();
      InvalidDecl = true;
    } else {
      // JAVA: single pointer is needed here to be passed into isIncompleteType
      type$ptr<NamedDecl /*P*/ > Def = create_type$ptr((NamedDecl)null);
      EltTy.$arrow().isIncompleteType($AddrOf(Def));
      if ((Def.$star() != null) && Def.$star().isInvalidDecl()) {
        Record.setInvalidDecl();
        InvalidDecl = true;
      }
    }
  }
  
  // OpenCL v1.2 s6.9.c: bitfields are not supported.
  if ((BitWidth != null) && $this().getLangOpts().OpenCL) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_opencl_bitfields)));
      InvalidDecl = true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // C99 6.7.2.1p8: A member of a structure or union may have any type other
  // than a variably modified type.
  if (!InvalidDecl && T.$arrow().isVariablyModifiedType()) {
    bool$ref SizeIsNegative = create_bool$ref();
    APSInt Oversized/*J*/= new APSInt();
    
    TypeSourceInfo /*P*/ FixedTInfo = TryToFixInvalidVariablyModifiedTypeSourceInfo(TInfo, $this().Context, 
        SizeIsNegative, 
        Oversized);
    if ((FixedTInfo != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_illegal_constant_array_size)));
        TInfo = FixedTInfo;
        T.$assignMove(FixedTInfo.getType());
      } finally {
        $c$.$destroy();
      }
    } else {
      if (SizeIsNegative.$deref()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_typecheck_negative_array_size)));
        } finally {
          $c$.$destroy();
        }
      } else if (Oversized.getBoolValue()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_array_too_large)), 
              Oversized.__toString(10)));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_typecheck_field_variable_size)));
        } finally {
          $c$.$destroy();
        }
      }
      InvalidDecl = true;
    }
  }
  
  // Fields can not have abstract class types
  if (!InvalidDecl && $this().RequireNonAbstractType$T(new SourceLocation(Loc), new QualType(T), 
      diag.err_abstract_type_in_decl, 
      AbstractDiagSelID.AbstractFieldType)) {
    InvalidDecl = true;
  }
  
  bool$ptr ZeroWidth = create_bool$ptr(false);
  if (InvalidDecl) {
    BitWidth = null;
  }
  // If this is declared as a bit-field, check the bit-field.
  if ((BitWidth != null)) {
    BitWidth = $this().VerifyBitField(new SourceLocation(Loc), II, new QualType(T), Record.isMsStruct($this().Context), BitWidth, 
        $AddrOf(ZeroWidth)).get();
    if (!(BitWidth != null)) {
      InvalidDecl = true;
      BitWidth = null;
      ZeroWidth.$set(false);
    }
  }
  
  // Check that 'mutable' is consistent with the type of the declaration.
  if (!InvalidDecl && Mutable) {
    /*uint*/int DiagID = 0;
    if (T.$arrow().isReferenceType()) {
      DiagID = $this().getLangOpts().MSVCCompat ? diag.ext_mutable_reference : diag.err_mutable_reference;
    } else if (T.isConstQualified()) {
      DiagID = diag.err_mutable_const;
    }
    if ((DiagID != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        SourceLocation ErrLoc = new SourceLocation(Loc);
        if ((D != null) && D.getDeclSpec().getStorageClassSpecLoc().isValid()) {
          ErrLoc.$assignMove(D.getDeclSpec().getStorageClassSpecLoc());
        }
        $c$.clean($c$.track($this().Diag(new SourceLocation(ErrLoc), DiagID)));
        if (DiagID != diag.ext_mutable_reference) {
          Mutable = false;
          InvalidDecl = true;
        }
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // C++11 [class.union]p8 (DR1460):
  //   At most one variant member of a union may have a
  //   brace-or-equal-initializer.
  if (InitStyle != InClassInitStyle.ICIS_NoInit) {
    checkDuplicateDefaultInit(/*Deref*/$this(), cast_CXXRecordDecl(Record), new SourceLocation(Loc));
  }
  
  FieldDecl /*P*/ NewFD = FieldDecl.Create($this().Context, Record, new SourceLocation(TSSL), new SourceLocation(Loc), II, new QualType(T), TInfo, 
      BitWidth, Mutable, InitStyle);
  if (InvalidDecl) {
    NewFD.setInvalidDecl();
  }
  if ((PrevDecl != null) && !isa_TagDecl(PrevDecl)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_duplicate_member)), II));
      $c$.clean($c$.track($this().Diag(PrevDecl.getLocation(), diag.note_previous_declaration)));
      NewFD.setInvalidDecl();
    } finally {
      $c$.$destroy();
    }
  }
  if (!InvalidDecl && $this().getLangOpts().CPlusPlus) {
    if (Record.isUnion()) {
      {
        /*const*/ RecordType /*P*/ RT = EltTy.$arrow().getAs$RecordType();
        if ((RT != null)) {
          CXXRecordDecl /*P*/ RDecl = cast_CXXRecordDecl(RT.getDecl());
          if ((RDecl.getDefinition() != null)) {
            // C++ [class.union]p1: An object of a class with a non-trivial
            // constructor, a non-trivial copy constructor, a non-trivial
            // destructor, or a non-trivial copy assignment operator
            // cannot be a member of a union, nor can an array of such
            // objects.
            if ($this().CheckNontrivialField(NewFD)) {
              NewFD.setInvalidDecl();
            }
          }
        }
      }
      
      // C++ [class.union]p1: If a union contains a member of reference type,
      // the program is ill-formed, except when compiling with MSVC extensions
      // enabled.
      if (EltTy.$arrow().isReferenceType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewFD.getLocation(), $this().getLangOpts().MicrosoftExt ? diag.ext_union_member_of_reference_type : diag.err_union_member_of_reference_type)), 
                  NewFD.getDeclName()), EltTy));
          if (!$this().getLangOpts().MicrosoftExt) {
            NewFD.setInvalidDecl();
          }
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // FIXME: We need to pass in the attributes given an AST
  // representation, not a parser representation.
  if ((D != null)) {
    // FIXME: The current scope is almost... but not entirely... correct here.
    $this().ProcessDeclAttributes($this().getCurScope(), NewFD, $Deref(D));
    if (NewFD.hasAttrs()) {
      $this().CheckAlignasUnderalignment(NewFD);
    }
  }
  
  // In auto-retain/release, infer strong retension for fields of
  // retainable type.
  if ($this().getLangOpts().ObjCAutoRefCount && $this().inferObjCARCLifetime(NewFD)) {
    NewFD.setInvalidDecl();
  }
  if (T.isObjCGCWeak()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_attribute_weak_on_field)));
    } finally {
      $c$.$destroy();
    }
  }
  
  NewFD.setAccess(AS);
  return NewFD;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckNontrivialField">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 13631,
 FQN="clang::Sema::CheckNontrivialField", NM="_ZN5clang4Sema20CheckNontrivialFieldEPNS_9FieldDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema20CheckNontrivialFieldEPNS_9FieldDeclE")
//</editor-fold>
public final boolean CheckNontrivialField(FieldDecl /*P*/ FD) {
  assert Native.$bool(FD);
  assert ($this().getLangOpts().CPlusPlus) : "valid check only for C++";
  if (FD.isInvalidDecl() || FD.getType().$arrow().isDependentType()) {
    return false;
  }
  
  QualType EltTy = $this().Context.getBaseElementType(FD.getType());
  {
    /*const*/ RecordType /*P*/ RT = EltTy.$arrow().getAs$RecordType();
    if ((RT != null)) {
      CXXRecordDecl /*P*/ RDecl = cast_CXXRecordDecl(RT.getDecl());
      if ((RDecl.getDefinition() != null)) {
        // We check for copy constructors before constructors
        // because otherwise we'll never get complaints about
        // copy constructors.
        CXXSpecialMember member = CXXSpecialMember.CXXInvalid;
        // We're required to check for any non-trivial constructors. Since the
        // implicit default constructor is suppressed if there are any
        // user-declared constructors, we just need to check that there is a
        // trivial default constructor and a trivial copy constructor. (We don't
        // worry about move constructors here, since this is a C++98 check.)
        if (RDecl.hasNonTrivialCopyConstructor()) {
          member = CXXSpecialMember.CXXCopyConstructor;
        } else if (!RDecl.hasTrivialDefaultConstructor()) {
          member = CXXSpecialMember.CXXDefaultConstructor;
        } else if (RDecl.hasNonTrivialCopyAssignment()) {
          member = CXXSpecialMember.CXXCopyAssignment;
        } else if (RDecl.hasNonTrivialDestructor()) {
          member = CXXSpecialMember.CXXDestructor;
        }
        if (member != CXXSpecialMember.CXXInvalid) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            if (!$this().getLangOpts().CPlusPlus11
               && $this().getLangOpts().ObjCAutoRefCount && RDecl.hasObjectMember()) {
              // Objective-C++ ARC: it is an error to have a non-trivial field of
              // a union. However, system headers in Objective-C programs
              // occasionally have Objective-C lifetime objects within unions,
              // and rather than cause the program to fail, we make those
              // members unavailable.
              SourceLocation Loc = FD.getLocation();
              if ($this().getSourceManager().isInSystemHeader(/*NO_COPY*/Loc)) {
                if (!FD.hasAttr(UnavailableAttr.class)) {
                  FD.addAttr(UnavailableAttr.CreateImplicit($this().Context, new StringRef(/*KEEP_STR*/$EMPTY), 
                          UnavailableAttr.ImplicitReason.IR_ARCFieldWithOwnership, new SourceRange(/*NO_COPY*/Loc)));
                }
                return false;
              }
            }
            
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getLocation(), $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_nontrivial_union_or_anon_struct_member : diag.err_illegal_union_or_anon_struct_member)), 
                        FD.getParent().isUnion()), FD.getDeclName()), member));
            $this().DiagnoseNontrivial(RDecl, member);
            return !$this().getLangOpts().CPlusPlus11;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  
  return false;
}

// end anonymous namespace

/// getSpecialMember - get the special member enum for a method.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getSpecialMember">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 2600,
 FQN="clang::Sema::getSpecialMember", NM="_ZN5clang4Sema16getSpecialMemberEPKNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema16getSpecialMemberEPKNS_13CXXMethodDeclE")
//</editor-fold>
public final Sema.CXXSpecialMember getSpecialMember(/*const*/ CXXMethodDecl /*P*/ MD) {
  {
    /*const*/ CXXConstructorDecl /*P*/ Ctor = dyn_cast_CXXConstructorDecl(MD);
    if ((Ctor != null)) {
      if (Ctor.isDefaultConstructor()) {
        return Sema.CXXSpecialMember.CXXDefaultConstructor;
      }
      if (Ctor.isCopyConstructor()) {
        return Sema.CXXSpecialMember.CXXCopyConstructor;
      }
      if (Ctor.isMoveConstructor()) {
        return Sema.CXXSpecialMember.CXXMoveConstructor;
      }
    } else if (isa_CXXDestructorDecl(MD)) {
      return Sema.CXXSpecialMember.CXXDestructor;
    } else if (MD.isCopyAssignmentOperator()) {
      return Sema.CXXSpecialMember.CXXCopyAssignment;
    } else if (MD.isMoveAssignmentOperator()) {
      return Sema.CXXSpecialMember.CXXMoveAssignment;
    }
  }
  
  return Sema.CXXSpecialMember.CXXInvalid;
}


/// ActOnLastBitfield - This routine handles synthesized bitfields rules for
/// class and class extensions. For every class \@interface and class
/// extension \@interface, if the last ivar is a bitfield of any type,
/// then add an implicit `char :0` ivar to the end of that interface.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnLastBitfield">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 13820,
 FQN="clang::Sema::ActOnLastBitfield", NM="_ZN5clang4Sema17ActOnLastBitfieldENS_14SourceLocationERN4llvm15SmallVectorImplIPNS_4DeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema17ActOnLastBitfieldENS_14SourceLocationERN4llvm15SmallVectorImplIPNS_4DeclEEE")
//</editor-fold>
public final void ActOnLastBitfield(SourceLocation DeclLoc, 
                 final SmallVectorImpl<Decl /*P*/ > /*&*/ AllIvarDecls) {
  if ($this().LangOpts.ObjCRuntime.isFragile() || AllIvarDecls.empty()) {
    return;
  }
  
  Decl /*P*/ ivarDecl = AllIvarDecls.$at(AllIvarDecls.size() - 1);
  ObjCIvarDecl /*P*/ Ivar = cast_ObjCIvarDecl(ivarDecl);
  if (!Ivar.isBitField() || Ivar.getBitWidthValue($this().Context) == 0) {
    return;
  }
  ObjCInterfaceDecl /*P*/ ID = dyn_cast_ObjCInterfaceDecl($this().CurContext);
  if (!(ID != null)) {
    {
      ObjCCategoryDecl /*P*/ CD = dyn_cast_ObjCCategoryDecl($this().CurContext);
      if ((CD != null)) {
        if (!CD.IsClassExtension()) {
          return;
        }
      } else {
        // No need to add this to end of @implementation.
        return;
      }
    }
  }
  // All conditions are met. Add a new bitfield to the tail end of ivars.
  APInt Zero/*J*/= new APInt(JD$UInt_ULong.INSTANCE, $ulong2uint($this().Context.getTypeSize($this().Context.IntTy.$QualType())), $int2ulong(0));
  Expr /*P*/ BW = IntegerLiteral.Create($this().Context, Zero, $this().Context.IntTy.$QualType(), new SourceLocation(DeclLoc));
  
  Ivar = ObjCIvarDecl.Create($this().Context, cast_ObjCContainerDecl($this().CurContext), 
      new SourceLocation(DeclLoc), new SourceLocation(DeclLoc), (IdentifierInfo /*P*/ )null, 
      $this().Context.CharTy.$QualType(), 
      $this().Context.getTrivialTypeSourceInfo($this().Context.CharTy.$QualType(), 
          /*NO_COPY*/DeclLoc), 
      ObjCIvarDecl.AccessControl.Private, BW, 
      true);
  AllIvarDecls.push_back(Ivar);
}


/// ActOnIvar - Each ivar field of an objective-c class is passed into this
/// in order to create an IvarDecl object for it.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnIvar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 13706,
 FQN="clang::Sema::ActOnIvar", NM="_ZN5clang4Sema9ActOnIvarEPNS_5ScopeENS_14SourceLocationERNS_10DeclaratorEPNS_4ExprENS_3tok15ObjCKeywordKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema9ActOnIvarEPNS_5ScopeENS_14SourceLocationERNS_10DeclaratorEPNS_4ExprENS_3tok15ObjCKeywordKindE")
//</editor-fold>
public final Decl /*P*/ ActOnIvar(Scope /*P*/ S, 
         SourceLocation DeclStart, 
         final Declarator /*&*/ D, Expr /*P*/ BitfieldWidth, 
         /*tok.ObjCKeywordKind*/char Visibility) {
  
  IdentifierInfo /*P*/ II = D.getIdentifier();
  Expr /*P*/ BitWidth = (Expr /*P*/ )BitfieldWidth;
  SourceLocation Loc = new SourceLocation(DeclStart);
  if ((II != null)) {
    Loc.$assignMove(D.getIdentifierLoc());
  }
  
  // FIXME: Unnamed fields can be handled in various different ways, for
  // example, unnamed unions inject all members into the struct namespace!
  TypeSourceInfo /*P*/ TInfo = $this().GetTypeForDeclarator(D, S);
  QualType T = TInfo.getType();
  if ((BitWidth != null)) {
    // 6.7.2.1p3, 6.7.2.1p4
    BitWidth = $this().VerifyBitField(new SourceLocation(Loc), II, new QualType(T), /*IsMsStruct*/ false, BitWidth).get();
    if (!(BitWidth != null)) {
      D.setInvalidType();
    }
  } else {

    // Not a bitfield.

    // validate II.
  }
  if (T.$arrow().isReferenceType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_ivar_reference_type)));
      D.setInvalidType();
    } finally {
      $c$.$destroy();
    }
  } else // C99 6.7.2.1p8: A member of a structure or union may have any type other
  // than a variably modified type.
  if (T.$arrow().isVariablyModifiedType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_typecheck_ivar_variable_size)));
      D.setInvalidType();
    } finally {
      $c$.$destroy();
    }
  }
  
  // Get the visibility (access control) for this ivar.
  ObjCIvarDecl.AccessControl ac = Visibility != tok.ObjCKeywordKind.objc_not_keyword ? TranslateIvarVisibility(Visibility) : ObjCIvarDecl.AccessControl.None;
  // Must set ivar's DeclContext to its enclosing interface.
  ObjCContainerDecl /*P*/ EnclosingDecl = cast_ObjCContainerDecl($this().CurContext);
  if (!(EnclosingDecl != null) || EnclosingDecl.isInvalidDecl()) {
    return null;
  }
  ObjCContainerDecl /*P*/ EnclosingContext;
  {
    ObjCImplementationDecl /*P*/ IMPDecl = dyn_cast_ObjCImplementationDecl(EnclosingDecl);
    if ((IMPDecl != null)) {
      if ($this().LangOpts.ObjCRuntime.isFragile()) {
        // Case of ivar declared in an implementation. Context is that of its class.
        EnclosingContext = IMPDecl.getClassInterface();
        assert ((EnclosingContext != null)) : "Implementation has no class interface!";
      } else {
        EnclosingContext = EnclosingDecl;
      }
    } else {
      {
        ObjCCategoryDecl /*P*/ CDecl = dyn_cast_ObjCCategoryDecl(EnclosingDecl);
        if ((CDecl != null)) {
          if ($this().LangOpts.ObjCRuntime.isFragile() || !CDecl.IsClassExtension()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_misplaced_ivar)), CDecl.IsClassExtension()));
              return null;
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
      EnclosingContext = EnclosingDecl;
    }
  }
  
  // Construct the decl.
  ObjCIvarDecl /*P*/ NewID = ObjCIvarDecl.Create($this().Context, EnclosingContext, 
      new SourceLocation(DeclStart), new SourceLocation(Loc), II, new QualType(T), 
      TInfo, ac, (Expr /*P*/ )BitfieldWidth);
  if ((II != null)) {
    NamedDecl /*P*/ PrevDecl = $this().LookupSingleName(S, new DeclarationName(II), new SourceLocation(Loc), LookupNameKind.LookupMemberName, 
        RedeclarationKind.ForRedeclaration);
    if ((PrevDecl != null) && $this().isDeclInScope(PrevDecl, EnclosingContext, S)
       && !isa_TagDecl(PrevDecl)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_duplicate_member)), II));
        $c$.clean($c$.track($this().Diag(PrevDecl.getLocation(), diag.note_previous_declaration)));
        NewID.setInvalidDecl();
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Process attributes attached to the ivar.
  $this().ProcessDeclAttributes(S, NewID, D);
  if (D.isInvalidType()) {
    NewID.setInvalidDecl();
  }
  
  // In ARC, infer 'retaining' for ivars of retainable type.
  if ($this().getLangOpts().ObjCAutoRefCount && $this().inferObjCARCLifetime(NewID)) {
    NewID.setInvalidDecl();
  }
  if (D.getDeclSpec().isModulePrivateSpecified()) {
    NewID.setModulePrivate();
  }
  if ((II != null)) {
    // FIXME: When interfaces are DeclContexts, we'll need to add
    // these to the interface.
    S.AddDecl(NewID);
    $this().IdResolver.AddDecl(NewID);
  }
  if ($this().LangOpts.ObjCRuntime.isNonFragile()
     && !NewID.isInvalidDecl() && isa_ObjCInterfaceDecl(EnclosingDecl)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_ivars_in_interface)));
    } finally {
      $c$.$destroy();
    }
  }
  
  return NewID;
}


// This is used for both record definitions and ObjC interface declarations.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFields">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 13854,
 FQN="clang::Sema::ActOnFields", NM="_ZN5clang4Sema11ActOnFieldsEPNS_5ScopeENS_14SourceLocationEPNS_4DeclEN4llvm8ArrayRefIS5_EES3_S3_PNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema11ActOnFieldsEPNS_5ScopeENS_14SourceLocationEPNS_4DeclEN4llvm8ArrayRefIS5_EES3_S3_PNS_13AttributeListE")
//</editor-fold>
public final void ActOnFields(Scope /*P*/ S, SourceLocation RecLoc, Decl /*P*/ EnclosingDecl, 
           ArrayRef<Decl /*P*/ > Fields, SourceLocation LBrac, 
           SourceLocation RBrac, AttributeList /*P*/ Attr) {
  assert ((EnclosingDecl != null)) : "missing record or interface decl";
  
  // If this is an Objective-C @implementation or category and we have
  // new fields here we should reset the layout of the interface since
  // it will now change.
  if (!Fields.empty() && isa_ObjCContainerDecl(EnclosingDecl)) {
    ObjCContainerDecl /*P*/ DC = cast_ObjCContainerDecl(EnclosingDecl);
    switch (DC.getKind()) {
     default:
      break;
     case ObjCCategory:
      $this().Context.ResetObjCLayout(cast_ObjCCategoryDecl(DC).getClassInterface());
      break;
     case ObjCImplementation:
      $this().Context.
          ResetObjCLayout(cast_ObjCImplementationDecl(DC).getClassInterface());
      break;
    }
  }
  
  RecordDecl /*P*/ Record = dyn_cast_RecordDecl(EnclosingDecl);
  
  // Start counting up the number of named members; make sure to include
  // members of anonymous structs and unions in the total.
  /*uint*/int NumNamedMembers = 0;
  if ((Record != null)) {
    for (/*const*/ Decl /*P*/ I : Record.decls()) {
      {
        /*const*/ IndirectFieldDecl /*P*/ IFD = dyn_cast_IndirectFieldDecl(I);
        if ((IFD != null)) {
          if (IFD.getDeclName().$bool()) {
            ++NumNamedMembers;
          }
        }
      }
    }
  }
  
  // Verify that all the fields are okay.
  SmallVector<FieldDecl /*P*/ > RecFields/*J*/= new SmallVector<FieldDecl /*P*/ >(32, (FieldDecl /*P*/ )null);
  
  boolean ARCErrReported = false;
  for (type$ptr<Decl /*P*/ /*P*/> i = $tryClone(Fields.begin()), /*P*/ end = $tryClone(Fields.end());
       $noteq_ptr(i, end); i.$preInc()) {
    FieldDecl /*P*/ FD = cast_FieldDecl(i.$star());
    
    // Get the type for the field.
    /*const*/ Type /*P*/ FDTy = FD.getType().getTypePtr();
    if (!FD.isAnonymousStructOrUnion()) {
      // Remember all fields written by the user.
      RecFields.push_back(FD);
    }
    
    // If the field is already invalid for some reason, don't emit more
    // diagnostics about it.
    if (FD.isInvalidDecl()) {
      EnclosingDecl.setInvalidDecl();
      continue;
    }
    
    // C99 6.7.2.1p2:
    //   A structure or union shall not contain a member with
    //   incomplete or function type (hence, a structure shall not
    //   contain an instance of itself, but may contain a pointer to
    //   an instance of itself), except that the last member of a
    //   structure with more than one named member may have incomplete
    //   array type; such a structure (and any union containing,
    //   possibly recursively, a member that is such a structure)
    //   shall not be a member of a structure or an element of an
    //   array.
    if (FDTy.isFunctionType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Field declared as a function.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getLocation(), diag.err_field_declared_as_function)), 
            FD.getDeclName()));
        FD.setInvalidDecl();
        EnclosingDecl.setInvalidDecl();
        continue;
      } finally {
        $c$.$destroy();
      }
    } else if (FDTy.isIncompleteArrayType() && (Record != null)
       && (($eq_ptr(i.$add(1), Fields.end()) && !Record.isUnion())
       || (($this().getLangOpts().MicrosoftExt
       || $this().getLangOpts().CPlusPlus)
       && ($eq_ptr(i.$add(1), Fields.end()) || Record.isUnion())))) {
      // Flexible array member.
      // Microsoft and g++ is more permissive regarding flexible array.
      // It will accept flexible array in union and also
      // as the sole element of a struct/class.
      /*uint*/int DiagID = 0;
      if (Record.isUnion()) {
        DiagID = $this().getLangOpts().MicrosoftExt ? diag.ext_flexible_array_union_ms : $this().getLangOpts().CPlusPlus ? diag.ext_flexible_array_union_gnu : diag.err_flexible_array_union;
      } else if ($less_uint(NumNamedMembers, 1)) {
        DiagID = $this().getLangOpts().MicrosoftExt ? diag.ext_flexible_array_empty_aggregate_ms : $this().getLangOpts().CPlusPlus ? diag.ext_flexible_array_empty_aggregate_gnu : diag.err_flexible_array_empty_aggregate;
      }
      if ((DiagID != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getLocation(), DiagID)), FD.getDeclName()), 
              Record.getTagKind()));
        } finally {
          $c$.$destroy();
        }
      }
      {
        // While the layout of types that contain virtual bases is not specified
        // by the C++ standard, both the Itanium and Microsoft C++ ABIs place
        // virtual bases after the derived members.  This would make a flexible
        // array member declared at the end of an object not adjacent to the end
        // of the type.
        CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(Record);
        if ((RD != null)) {
          if (RD.getNumVBases() != 0) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getLocation(), diag.err_flexible_array_virtual_base)), 
                      FD.getDeclName()), Record.getTagKind()));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
      if (!$this().getLangOpts().C99) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getLocation(), diag.ext_c99_flexible_array_member)), 
                  FD.getDeclName()), Record.getTagKind()));
        } finally {
          $c$.$destroy();
        }
      }
      
      // If the element type has a non-trivial destructor, we would not
      // implicitly destroy the elements, so disallow it for now.
      //
      // FIXME: GCC allows this. We should probably either implicitly delete
      // the destructor of the containing class, or just allow this.
      QualType BaseElem = $this().Context.getBaseElementType(FD.getType());
      if (!BaseElem.$arrow().isDependentType() && (BaseElem.isDestructedType().getValue() != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getLocation(), diag.err_flexible_array_has_nontrivial_dtor)), 
                  FD.getDeclName()), FD.getType()));
          FD.setInvalidDecl();
          EnclosingDecl.setInvalidDecl();
          continue;
        } finally {
          $c$.$destroy();
        }
      }
      // Okay, we have a legal flexible array member at the end of the struct.
      Record.setHasFlexibleArrayMember(true);
    } else if (!FDTy.isDependentType()
       && $this().RequireCompleteType(FD.getLocation(), FD.getType(), 
        diag.err_field_incomplete)) {
      // Incomplete type
      FD.setInvalidDecl();
      EnclosingDecl.setInvalidDecl();
      continue;
    } else {
      /*const*/ RecordType /*P*/ FDTTy = FDTy.getAs$RecordType();
      if ((FDTTy != null)) {
        if ((Record != null) && FDTTy.getDecl().hasFlexibleArrayMember()) {
          // A type which contains a flexible array member is considered to be a
          // flexible array member.
          Record.setHasFlexibleArrayMember(true);
          if (!Record.isUnion()) {
            // If this is a struct/class and this is not the last element, reject
            // it.  Note that GCC supports variable sized arrays in the middle of
            // structures.
            if ($noteq_ptr(i.$add(1), Fields.end())) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getLocation(), diag.ext_variable_sized_type_in_struct)), 
                        FD.getDeclName()), FD.getType()));
              } finally {
                $c$.$destroy();
              }
            } else {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                // We support flexible arrays at the end of structs in
                // other structs as an extension.
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getLocation(), diag.ext_flexible_array_in_struct)), 
                    FD.getDeclName()));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
        if (isa_ObjCContainerDecl(EnclosingDecl)
           && $this().RequireNonAbstractType$T(FD.getLocation(), FD.getType(), 
            diag.err_abstract_type_in_decl, 
            AbstractDiagSelID.AbstractIvarType)) {
          // Ivars can not have abstract class types
          FD.setInvalidDecl();
        }
        if ((Record != null) && FDTTy.getDecl().hasObjectMember()) {
          Record.setHasObjectMember(true);
        }
        if ((Record != null) && FDTTy.getDecl().hasVolatileMember()) {
          Record.setHasVolatileMember(true);
        }
      } else if (FDTy.isObjCObjectType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          /// A field cannot be an Objective-c object
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getLocation(), diag.err_statically_allocated_object)), 
              FixItHint.CreateInsertion(FD.getLocation(), new StringRef(/*KEEP_STR*/$STAR))));
          QualType T = $this().Context.getObjCObjectPointerType(FD.getType());
          FD.setType(new QualType(T));
        } finally {
          $c$.$destroy();
        }
      } else if ($this().getLangOpts().ObjCAutoRefCount && (Record != null) && !ARCErrReported
         && (!$this().getLangOpts().CPlusPlus || Record.isUnion())) {
        // It's an error in ARC if a field has lifetime.
        // We don't want to report this in a system header, though,
        // so we just make the field unavailable.
        // FIXME: that's really not sufficient; we need to make the type
        // itself invalid to, say, initialize or copy.
        QualType T = FD.getType();
        Qualifiers.ObjCLifetime lifetime = T.getObjCLifetime();
        if ((lifetime.getValue() != 0) && lifetime != Qualifiers.ObjCLifetime.OCL_ExplicitNone) {
          SourceLocation loc = FD.getLocation();
          if ($this().getSourceManager().isInSystemHeader(/*NO_COPY*/loc)) {
            if (!FD.hasAttr(UnavailableAttr.class)) {
              FD.addAttr(UnavailableAttr.CreateImplicit($this().Context, new StringRef(/*KEEP_STR*/$EMPTY), 
                      UnavailableAttr.ImplicitReason.IR_ARCFieldWithOwnership, new SourceRange(/*NO_COPY*/loc)));
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getLocation(), diag.err_arc_objc_object_in_tag)), 
                      T.$arrow().isBlockPointerType()), Record.getTagKind()));
            } finally {
              $c$.$destroy();
            }
          }
          ARCErrReported = true;
        }
      } else if ($this().getLangOpts().ObjC1
         && $this().getLangOpts().getGC() != LangOptions.GCMode.NonGC
         && (Record != null) && !Record.hasObjectMember()) {
        if (FD.getType().$arrow().isObjCObjectPointerType()
           || FD.getType().isObjCGCStrong()) {
          Record.setHasObjectMember(true);
        } else if (($this().Context.getAsArrayType(FD.getType()) != null)) {
          QualType BaseType = $this().Context.getBaseElementType(FD.getType());
          if (BaseType.$arrow().isRecordType()
             && BaseType.$arrow().getAs$RecordType().getDecl().hasObjectMember()) {
            Record.setHasObjectMember(true);
          } else if (BaseType.$arrow().isObjCObjectPointerType()
             || BaseType.isObjCGCStrong()) {
            Record.setHasObjectMember(true);
          }
        }
      }
    }
    if ((Record != null) && FD.getType().isVolatileQualified()) {
      Record.setHasVolatileMember(true);
    }
    // Keep track of the number of named members.
    if ((FD.getIdentifier() != null)) {
      ++NumNamedMembers;
    }
  }
  
  // Okay, we successfully defined 'Record'.
  if ((Record != null)) {
    boolean Completed = false;
    {
      CXXRecordDecl /*P*/ CXXRecord = dyn_cast_CXXRecordDecl(Record);
      if ((CXXRecord != null)) {
        if (!CXXRecord.isInvalidDecl()) {
          // Set access bits correctly on the directly-declared conversions.
          for (UnresolvedSetIterator I = CXXRecord.conversion_begin(), 
              E = CXXRecord.conversion_end(); I.$noteq(E); I.$preInc())  {
            I.setAccess((I.$star()).getAccess());
          }
        }
        if (!CXXRecord.isDependentType()) {
          if (CXXRecord.hasUserDeclaredDestructor()) {
            // Adjust user-defined destructor exception spec.
            if ($this().getLangOpts().CPlusPlus11) {
              $this().AdjustDestructorExceptionSpec(CXXRecord, 
                  CXXRecord.getDestructor());
            }
          }
          if (!CXXRecord.isInvalidDecl()) {
            // Add any implicitly-declared members to this class.
            $this().AddImplicitlyDeclaredMembersToClass(CXXRecord);
            
            // If we have virtual base classes, we may end up finding multiple
            // final overriders for a given virtual function. Check for this
            // problem now.
            if ((CXXRecord.getNumVBases() != 0)) {
              CXXFinalOverriderMap FinalOverriders = null;
              try {
                FinalOverriders/*J*/= new CXXFinalOverriderMap();
                CXXRecord.getFinalOverriders(FinalOverriders);
                
                for (StdVector.iterator<pairPtrType</*const*/ CXXMethodDecl/*P*/, OverridingMethods/*P*/>> M = FinalOverriders.begin(), 
                    MEnd = FinalOverriders.end();
                     $noteq___normal_iterator$C(M, MEnd); M.$preInc()) {
                  for (StdVector.iterator<std.pairUIntType<SmallVector<UniqueVirtualMethod>> /*P*/> SO = M.$arrow().second.begin(), 
                      SOEnd = M.$arrow().second.end();
                       $noteq___normal_iterator$C(SO, SOEnd); SO.$preInc()) {
                    JavaCleaner $c$ = $createJavaCleaner();
                    try {
                      assert ($greater_uint(SO.$arrow().second.size(), 0)) : "Virtual function without overridding functions?";
                      if (SO.$arrow().second.size() == 1) {
                        continue;
                      }
                      
                      // C++ [class.virtual]p2:
                      //   In a derived class, if a virtual member function of a base
                      //   class subobject has more than one final overrider the
                      //   program is ill-formed.
                      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Record.getLocation(), diag.err_multiple_final_overriders)), 
                              (/*const*/ NamedDecl /*P*/ )M.$arrow().first), Record));
                      $c$.clean($c$.track($this().Diag(M.$arrow().first.getLocation(), 
                          diag.note_overridden_virtual_function)));
                      for (type$ptr<UniqueVirtualMethod> OM = $tryClone(SO.$arrow().second.begin()), 
                          /*P*/ OMEnd = $tryClone(SO.$arrow().second.end());
                           $noteq_ptr(OM, OMEnd); OM.$preInc())  {
                        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(OM./*->*/$star().Method.getLocation(), diag.note_final_overrider)), 
                                (/*const*/ NamedDecl /*P*/ )M.$arrow().first), OM./*->*/$star().Method.getParent()));
                      }
                      
                      Record.setInvalidDecl();
                    } finally {
                      $c$.$destroy();
                    }
                  }
                }
                CXXRecord.completeDefinition($AddrOf(FinalOverriders));
                Completed = true;
              } finally {
                if (FinalOverriders != null) { FinalOverriders.$destroy(); }
              }
            }
          }
        }
      }
    }
    if (!Completed) {
      Record.completeDefinition();
    }
    if (Record.hasAttrs()) {
      $this().CheckAlignasUnderalignment(Record);
      {
        
        /*const*/ MSInheritanceAttr /*P*/ IA = Record.getAttr(MSInheritanceAttr.class);
        if ((IA != null)) {
          $this().checkMSInheritanceAttrOnDefinition(cast_CXXRecordDecl(Record), 
              IA.getRange(), IA.getBestCase(), 
              IA.getSemanticSpelling());
        }
      }
    }
    
    // Check if the structure/union declaration is a type that can have zero
    // size in C. For C this is a language extension, for C++ it may cause
    // compatibility problems.
    boolean CheckForZeroSize;
    if (!$this().getLangOpts().CPlusPlus) {
      CheckForZeroSize = true;
    } else {
      // For C++ filter out types that cannot be referenced in C code.
      CXXRecordDecl /*P*/ CXXRecord = cast_CXXRecordDecl(Record);
      CheckForZeroSize
         = CXXRecord.getLexicalDeclContext().isExternCContext()
         && !CXXRecord.isDependentType()
         && CXXRecord.isCLike();
    }
    if (CheckForZeroSize) {
      boolean ZeroSize = true;
      boolean IsEmpty = true;
      /*uint*/int NonBitFields = 0;
      for (specific_decl_iterator<FieldDecl> I = Record.field_begin(), 
          E = Record.field_end();
           (NonBitFields == 0 || ZeroSize) && $noteq_specific_decl_iterator$SpecificDecl$C(I, E); I.$preInc()) {
        IsEmpty = false;
        if (I.$arrow().isUnnamedBitfield()) {
          if ($greater_uint(I.$arrow().getBitWidthValue($this().Context), 0)) {
            ZeroSize = false;
          }
        } else {
          ++NonBitFields;
          QualType FieldType = I.$arrow().getType();
          if (FieldType.$arrow().isIncompleteType()
             || !$this().Context.getTypeSizeInChars(new QualType(FieldType)).isZero()) {
            ZeroSize = false;
          }
        }
      }
      
      // Empty structs are an extension in C (C99 6.7.2.1p7). They are
      // allowed in C++, but warn if its declaration is inside
      // extern "C" block.
      if (ZeroSize) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(RecLoc), $this().getLangOpts().CPlusPlus ? diag.warn_zero_size_struct_union_in_extern_c : diag.warn_zero_size_struct_union_compat)), 
                      IsEmpty), Record.isUnion()), ($greater_uint(NonBitFields, 1))));
        } finally {
          $c$.$destroy();
        }
      }
      
      // Structs without named members are extension in C (C99 6.7.2.1p7),
      // but are accepted by GCC.
      if (NonBitFields == 0 && !$this().getLangOpts().CPlusPlus) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(RecLoc), IsEmpty ? diag.ext_empty_struct_union : diag.ext_no_named_members_in_struct_union)), 
              Record.isUnion()));
        } finally {
          $c$.$destroy();
        }
      }
    }
  } else {
    type$ptr<ObjCIvarDecl /*P*/ /*P*/> ClsFields = $tryClone(((type$ptr<ObjCIvarDecl /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, RecFields.data())));
    {
      ObjCInterfaceDecl /*P*/ ID = dyn_cast_ObjCInterfaceDecl(EnclosingDecl);
      if ((ID != null)) {
        ID.setEndOfDefinitionLoc(new SourceLocation(RBrac));
        // Add ivar's to class's DeclContext.
        for (/*uint*/int i = 0, e = RecFields.size(); i != e; ++i) {
          ClsFields.$at(i).setLexicalDeclContext(ID);
          ID.addDecl(ClsFields.$at(i));
        }
        // Must enforce the rule that ivars in the base classes may not be
        // duplicates.
        if ((ID.getSuperClass() != null)) {
          $this().DiagnoseDuplicateIvars(ID, ID.getSuperClass());
        }
      } else {
        ObjCImplementationDecl /*P*/ IMPDecl = dyn_cast_ObjCImplementationDecl(EnclosingDecl);
        if ((IMPDecl != null)) {
          assert ((IMPDecl != null)) : "ActOnFields - missing ObjCImplementationDecl";
          for (/*uint*/int I = 0, N = RecFields.size(); I != N; ++I)  {
            // Ivar declared in @implementation never belongs to the implementation.
            // Only it is in implementation's lexical context.
            ClsFields.$at(I).setLexicalDeclContext(IMPDecl);
          }
          $this().CheckImplementationIvars(IMPDecl, ClsFields, RecFields.size(), new SourceLocation(RBrac));
          IMPDecl.setIvarLBraceLoc(new SourceLocation(LBrac));
          IMPDecl.setIvarRBraceLoc(new SourceLocation(RBrac));
        } else {
          ObjCCategoryDecl /*P*/ CDecl = dyn_cast_ObjCCategoryDecl(EnclosingDecl);
          if ((CDecl != null)) {
            // case of ivars in class extension; all other cases have been
            // reported as errors elsewhere.
            // FIXME. Class extension does not have a LocEnd field.
            // CDecl->setLocEnd(RBrac);
            // Add ivar's to class extension's DeclContext.
            // Diagnose redeclaration of private ivars.
            ObjCInterfaceDecl /*P*/ IDecl = CDecl.getClassInterface();
            for (/*uint*/int i = 0, e = RecFields.size(); i != e; ++i) {
              if ((IDecl != null)) {
                {
                  /*const*/ ObjCIvarDecl /*P*/ ClsIvar = IDecl.getIvarDecl(ClsFields.$at(i).getIdentifier());
                  if ((ClsIvar != null)) {
                    JavaCleaner $c$ = $createJavaCleaner();
                    try {
                      $c$.clean($c$.track($this().Diag(ClsFields.$at(i).getLocation(), 
                          diag.err_duplicate_ivar_declaration)));
                      $c$.clean($c$.track($this().Diag(ClsIvar.getLocation(), diag.note_previous_definition)));
                      continue;
                    } finally {
                      $c$.$destroy();
                    }
                  }
                }
                for (/*const*/ ObjCCategoryDecl /*P*/ Ext : IDecl.known_extensions()) {
                  {
                    /*const*/ ObjCIvarDecl /*P*/ ClsExtIvar = Ext.getIvarDecl(ClsFields.$at(i).getIdentifier());
                    if ((ClsExtIvar != null)) {
                      JavaCleaner $c$ = $createJavaCleaner();
                      try {
                        $c$.clean($c$.track($this().Diag(ClsFields.$at(i).getLocation(), 
                            diag.err_duplicate_ivar_declaration)));
                        $c$.clean($c$.track($this().Diag(ClsExtIvar.getLocation(), diag.note_previous_definition)));
                        continue;
                      } finally {
                        $c$.$destroy();
                      }
                    }
                  }
                }
              }
              ClsFields.$at(i).setLexicalDeclContext(CDecl);
              CDecl.addDecl(ClsFields.$at(i));
            }
            CDecl.setIvarLBraceLoc(new SourceLocation(LBrac));
            CDecl.setIvarRBraceLoc(new SourceLocation(RBrac));
          }
        }
      }
    }
  }
  if ((Attr != null)) {
    $this().ProcessDeclAttributeList(S, Record, Attr);
  }
}


/// ActOnTagStartDefinition - Invoked when we have entered the
/// scope of a tag's definition (e.g., for an enumeration, class,
/// struct, or union).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnTagStartDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 13117,
 FQN="clang::Sema::ActOnTagStartDefinition", NM="_ZN5clang4Sema23ActOnTagStartDefinitionEPNS_5ScopeEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema23ActOnTagStartDefinitionEPNS_5ScopeEPNS_4DeclE")
//</editor-fold>
public final void ActOnTagStartDefinition(Scope /*P*/ S, Decl /*P*/ _TagD) {
  type$ref<Decl> TagD = create_type$ref(_TagD);
  $this().AdjustDeclIfTemplate(TagD);
  TagDecl /*P*/ Tag = cast_TagDecl(TagD.$deref());
  
  // Enter the tag context.
  $this().PushDeclContext(S, Tag);
  
  $this().ActOnDocumentableDecl(TagD.$deref());
  
  // If there's a #pragma GCC visibility in scope, set the visibility of this
  // record.
  $this().AddPushedVisibilityAttribute(Tag);
}


/// \brief Invoked when we enter a tag definition that we're skipping.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnTagStartSkippedDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1127,
 FQN="clang::Sema::ActOnTagStartSkippedDefinition", NM="_ZN5clang4Sema30ActOnTagStartSkippedDefinitionEPNS_5ScopeEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema30ActOnTagStartSkippedDefinitionEPNS_5ScopeEPNS_4DeclE")
//</editor-fold>
public final Object/*void P*/ ActOnTagStartSkippedDefinition(Scope /*P*/ S, 
                              Decl /*P*/ D) {
  // Unlike PushDeclContext, the context to which we return is not necessarily
  // the containing DC of TD, because the new context will be some pre-existing
  // TagDecl definition instead of a fresh one.
  Object/*void P*/ Result = (reinterpret_cast(/*static_cast*/Object/*void P*/ .class, ($this().CurContext)));
  $this().CurContext = cast_TagDecl(D).getDefinition();
  assert (($this().CurContext != null)) : "skipping definition of undefined tag";
  // Start lookups from the parent of the current context; we don't want to look
  // into the pre-existing complete definition.
  S.setEntity($this().CurContext.getLookupParent());
  return Result;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnObjCContainerStartDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 13131,
 FQN="clang::Sema::ActOnObjCContainerStartDefinition", NM="_ZN5clang4Sema33ActOnObjCContainerStartDefinitionEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema33ActOnObjCContainerStartDefinitionEPNS_4DeclE")
//</editor-fold>
public final Decl /*P*/ ActOnObjCContainerStartDefinition(Decl /*P*/ IDecl) {
  assert (isa_ObjCContainerDecl(IDecl)) : "ActOnObjCContainerStartDefinition - Not ObjCContainerDecl";
  DeclContext /*P*/ OCD = cast_DeclContext(IDecl);
  assert ($this().getContainingDC(OCD) == $this().CurContext) : "The next DeclContext should be lexically contained in the current one.";
  $this().CurContext = OCD;
  return IDecl;
}


/// ActOnStartCXXMemberDeclarations - Invoked when we have parsed a
/// C++ record definition's base-specifiers clause and are starting its
/// member declarations.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStartCXXMemberDeclarations">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 13141,
 FQN="clang::Sema::ActOnStartCXXMemberDeclarations", NM="_ZN5clang4Sema31ActOnStartCXXMemberDeclarationsEPNS_5ScopeEPNS_4DeclENS_14SourceLocationEbS5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema31ActOnStartCXXMemberDeclarationsEPNS_5ScopeEPNS_4DeclENS_14SourceLocationEbS5_")
//</editor-fold>
public final void ActOnStartCXXMemberDeclarations(Scope /*P*/ S, Decl /*P*/ _TagD, 
                               SourceLocation FinalLoc, 
                               boolean IsFinalSpelledSealed, 
                               SourceLocation LBraceLoc) {
  type$ref<Decl> TagD = create_type$ref(_TagD);  
  $this().AdjustDeclIfTemplate(TagD);
  CXXRecordDecl /*P*/ Record = cast_CXXRecordDecl(TagD.$deref());
  
  $this().FieldCollector.$arrow().StartClass();
  if (!(Record.getIdentifier() != null)) {
    return;
  }
  if (FinalLoc.isValid()) {
    Record.addAttr(/*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new($this().Context, (type$ptr<?> New$Mem)->{
            return new FinalAttr(new SourceRange(/*NO_COPY*/FinalLoc), $this().Context, (IsFinalSpelledSealed ? 1 : 0));
         }));
  }
  
  // C++ [class]p2:
  //   [...] The class-name is also inserted into the scope of the
  //   class itself; this is known as the injected-class-name. For
  //   purposes of access checking, the injected-class-name is treated
  //   as if it were a public member name.
  CXXRecordDecl /*P*/ InjectedClassName = CXXRecordDecl.Create($this().Context, Record.getTagKind(), $this().CurContext, 
      Record.getLocStart(), Record.getLocation(), 
      Record.getIdentifier(), 
      /*PrevDecl=*/ (CXXRecordDecl /*P*/ )null, 
      /*DelayTypeCreation=*/ true);
  $this().Context.getTypeDeclType(InjectedClassName, Record);
  InjectedClassName.setImplicit();
  InjectedClassName.setAccess(AccessSpecifier.AS_public);
  {
    ClassTemplateDecl /*P*/ Template = Record.getDescribedClassTemplate();
    if ((Template != null)) {
      InjectedClassName.setDescribedClassTemplate(Template);
    }
  }
  $this().PushOnScopeChains(InjectedClassName, S);
  assert (InjectedClassName.isInjectedClassName()) : "Broken injected-class-name";
}


/// ActOnTagFinishDefinition - Invoked once we have finished parsing
/// the definition of a tag (enumeration, class, struct, or union).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnTagFinishDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 13178,
 FQN="clang::Sema::ActOnTagFinishDefinition", NM="_ZN5clang4Sema24ActOnTagFinishDefinitionEPNS_5ScopeEPNS_4DeclENS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema24ActOnTagFinishDefinitionEPNS_5ScopeEPNS_4DeclENS_11SourceRangeE")
//</editor-fold>
public final void ActOnTagFinishDefinition(Scope /*P*/ S, Decl /*P*/ _TagD, 
                        SourceRange BraceRange) {
  type$ref<Decl> TagD = create_type$ref(_TagD);
  $this().AdjustDeclIfTemplate(TagD);
  TagDecl /*P*/ Tag = cast_TagDecl(TagD.$deref());
  Tag.setBraceRange(new SourceRange(BraceRange));
  
  // Make sure we "complete" the definition even it is invalid.
  if (Tag.isBeingDefined()) {
    assert (Tag.isInvalidDecl()) : "We should already have completed it";
    {
      RecordDecl /*P*/ RD = dyn_cast_RecordDecl(Tag);
      if ((RD != null)) {
        RD.completeDefinition();
      }
    }
  }
  if (isa_CXXRecordDecl(Tag)) {
    $this().FieldCollector.$arrow().FinishClass();
  }
  
  // Exit this scope of this tag's definition.
  $this().PopDeclContext();
  if ($this().getCurLexicalContext().isObjCContainer()
     && Tag.getDeclContext().isFileContext()) {
    Tag.setTopLevelDeclInObjCContainer();
  }
  
  // Notify the consumer that we've defined a tag.
  if (!Tag.isInvalidDecl()) {
    $this().Consumer.HandleTagDeclDefinition(Tag);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnTagFinishSkippedDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1141,
 FQN="clang::Sema::ActOnTagFinishSkippedDefinition", NM="_ZN5clang4Sema31ActOnTagFinishSkippedDefinitionEPv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema31ActOnTagFinishSkippedDefinitionEPv")
//</editor-fold>
public final void ActOnTagFinishSkippedDefinition(Object/*void P*/ Context) {
  $this().CurContext = (/*static_cast*/DeclContext) Context;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnObjCContainerFinishDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 13206,
 FQN="clang::Sema::ActOnObjCContainerFinishDefinition", NM="_ZN5clang4Sema34ActOnObjCContainerFinishDefinitionEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema34ActOnObjCContainerFinishDefinitionEv")
//</editor-fold>
public final void ActOnObjCContainerFinishDefinition() {
  // Exit this scope of this interface definition.
  $this().PopDeclContext();
}


/// \brief Invoked when we must temporarily exit the objective-c container
/// scope for parsing/looking-up C constructs.
///
/// Must be followed by a call to \see ActOnObjCReenterContainerContext
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnObjCTemporaryExitContainerContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 13211,
 FQN="clang::Sema::ActOnObjCTemporaryExitContainerContext", NM="_ZN5clang4Sema38ActOnObjCTemporaryExitContainerContextEPNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema38ActOnObjCTemporaryExitContainerContextEPNS_11DeclContextE")
//</editor-fold>
public final void ActOnObjCTemporaryExitContainerContext(DeclContext /*P*/ DC) {
  assert (DC == $this().CurContext) : "Mismatch of container contexts";
  $this().OriginalLexicalContext = DC;
  $this().ActOnObjCContainerFinishDefinition();
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnObjCReenterContainerContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 13217,
 FQN="clang::Sema::ActOnObjCReenterContainerContext", NM="_ZN5clang4Sema32ActOnObjCReenterContainerContextEPNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema32ActOnObjCReenterContainerContextEPNS_11DeclContextE")
//</editor-fold>
public final void ActOnObjCReenterContainerContext(DeclContext /*P*/ DC) {
  $this().ActOnObjCContainerStartDefinition(cast_Decl(DC));
  $this().OriginalLexicalContext = null;
}


/// ActOnTagDefinitionError - Invoked when there was an unrecoverable
/// error parsing the definition of a tag.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnTagDefinitionError">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 13222,
 FQN="clang::Sema::ActOnTagDefinitionError", NM="_ZN5clang4Sema23ActOnTagDefinitionErrorEPNS_5ScopeEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema23ActOnTagDefinitionErrorEPNS_5ScopeEPNS_4DeclE")
//</editor-fold>
public final void ActOnTagDefinitionError(Scope /*P*/ S, Decl /*P*/ _TagD) {
  type$ref<Decl> TagD = create_type$ref(_TagD); 
  $this().AdjustDeclIfTemplate(TagD);
  TagDecl /*P*/ Tag = cast_TagDecl(TagD.$deref());
  Tag.setInvalidDecl();
  
  // Make sure we "complete" the definition even it is invalid.
  if (Tag.isBeingDefined()) {
    {
      RecordDecl /*P*/ RD = dyn_cast_RecordDecl(Tag);
      if ((RD != null)) {
        RD.completeDefinition();
      }
    }
  }
  
  // We're undoing ActOnTagStartDefinition here, not
  // ActOnStartCXXMemberDeclarations, so we don't have to mess with
  // the FieldCollector.
  $this().PopDeclContext();
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckEnumConstant">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 14308,
 FQN="clang::Sema::CheckEnumConstant", NM="_ZN5clang4Sema17CheckEnumConstantEPNS_8EnumDeclEPNS_16EnumConstantDeclENS_14SourceLocationEPNS_14IdentifierInfoEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema17CheckEnumConstantEPNS_8EnumDeclEPNS_16EnumConstantDeclENS_14SourceLocationEPNS_14IdentifierInfoEPNS_4ExprE")
//</editor-fold>
public final EnumConstantDecl /*P*/ CheckEnumConstant(EnumDecl /*P*/ Enum, 
                 EnumConstantDecl /*P*/ LastEnumConst, 
                 SourceLocation IdLoc, 
                 IdentifierInfo /*P*/ Id, 
                 Expr /*P*/ Val) {
  /*uint*/int IntWidth = $this().Context.getTargetInfo().getIntWidth();
  APSInt EnumVal/*J*/= new APSInt(IntWidth);
  QualType EltTy/*J*/= new QualType();
  if ((Val != null) && $this().DiagnoseUnexpandedParameterPack(Val, UnexpandedParameterPackContext.UPPC_EnumeratorValue)) {
    Val = null;
  }
  if ((Val != null)) {
    Val = $this().DefaultLvalueConversion(Val).get();
  }
  if ((Val != null)) {
    if (Enum.isDependentType() || Val.isTypeDependent()) {
      EltTy.$assignMove($this().Context.DependentTy.$QualType());
    } else {
      SourceLocation ExpLoc/*J*/= new SourceLocation();
      if ($this().getLangOpts().CPlusPlus11 && Enum.isFixed()
         && !$this().getLangOpts().MSVCCompat) {
        // C++11 [dcl.enum]p5: If the underlying type is fixed, [...] the
        // constant-expression in the enumerator-definition shall be a converted
        // constant expression of the underlying type.
        EltTy.$assignMove(Enum.getIntegerType());
        ActionResultTTrue<Expr /*P*/ > _Converted = $this().CheckConvertedConstantExpression(Val, new QualType(EltTy), EnumVal, 
            CCEKind.CCEK_Enumerator);
        if (_Converted.isInvalid()) {
          Val = null;
        } else {
          Val = _Converted.get();
        }
      } else if (!Val.isValueDependent()
         && !((Val = $this().VerifyIntegerConstantExpression(Val, 
          $AddrOf(EnumVal)).get()) != null)) {
        // C99 6.7.2.2p2: Make sure we have an integer constant expression.
      } else {
        if (Enum.isFixed()) {
          EltTy.$assignMove(Enum.getIntegerType());
          
          // In Obj-C and Microsoft mode, require the enumeration value to be
          // representable in the underlying type of the enumeration. In C++11,
          // we perform a non-narrowing conversion as part of converted constant
          // expression checking.
          if (!isRepresentableIntegerValue($this().Context, EnumVal, new QualType(EltTy))) {
            if ($this().getLangOpts().MSVCCompat) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IdLoc), diag.ext_enumerator_too_large)), EltTy));
                Val = $this().ImpCastExprToType(Val, new QualType(EltTy), CastKind.CK_IntegralCast).get();
              } finally {
                $c$.$destroy();
              }
            } else {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IdLoc), diag.err_enumerator_too_large)), EltTy));
              } finally {
                $c$.$destroy();
              }
            }
          } else {
            Val = $this().ImpCastExprToType(Val, new QualType(EltTy), 
                EltTy.$arrow().isBooleanType() ? CastKind.CK_IntegralToBoolean : CastKind.CK_IntegralCast).
                get();
          }
        } else if ($this().getLangOpts().CPlusPlus) {
          // C++11 [dcl.enum]p5:
          //   If the underlying type is not fixed, the type of each enumerator
          //   is the type of its initializing value:
          //     - If an initializer is specified for an enumerator, the
          //       initializing value has the same type as the expression.
          EltTy.$assignMove(Val.getType());
        } else {
          // C99 6.7.2.2p2:
          //   The expression that defines the value of an enumeration constant
          //   shall be an integer constant expression that has a value
          //   representable as an int.
          
          // Complain if the value is not representable in an int.
          if (!isRepresentableIntegerValue($this().Context, EnumVal, $this().Context.IntTy.$QualType())) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IdLoc), diag.ext_enum_value_not_int)), 
                          EnumVal.__toString(10)), Val.getSourceRange()), 
                  (EnumVal.isUnsigned() || EnumVal.isNonNegative())));
            } finally {
              $c$.$destroy();
            }
          } else if (!$this().Context.hasSameType(Val.getType(), $this().Context.IntTy.$QualType())) {
            // Force the type of the expression to 'int'.
            Val = $this().ImpCastExprToType(Val, $this().Context.IntTy.$QualType(), CastKind.CK_IntegralCast).get();
          }
          EltTy.$assignMove(Val.getType());
        }
      }
    }
  }
  if (!(Val != null)) {
    if (Enum.isDependentType()) {
      EltTy.$assignMove($this().Context.DependentTy.$QualType());
    } else if (!(LastEnumConst != null)) {
      // C++0x [dcl.enum]p5:
      //   If the underlying type is not fixed, the type of each enumerator
      //   is the type of its initializing value:
      //     - If no initializer is specified for the first enumerator, the
      //       initializing value has an unspecified integral type.
      //
      // GCC uses 'int' for its unspecified integral type, as does
      // C99 6.7.2.2p3.
      if (Enum.isFixed()) {
        EltTy.$assignMove(Enum.getIntegerType());
      } else {
        EltTy.$assignMove($this().Context.IntTy.$QualType());
      }
    } else {
      // Assign the last value + 1.
      EnumVal.$assign(LastEnumConst.getInitVal());
      EnumVal.$preInc();
      EltTy.$assignMove(LastEnumConst.getType());
      
      // Check for overflow on increment.
      if (EnumVal.$less(LastEnumConst.getInitVal())) {
        // C++0x [dcl.enum]p5:
        //   If the underlying type is not fixed, the type of each enumerator
        //   is the type of its initializing value:
        //
        //     - Otherwise the type of the initializing value is the same as
        //       the type of the initializing value of the preceding enumerator
        //       unless the incremented value is not representable in that type,
        //       in which case the type is an unspecified integral type
        //       sufficient to contain the incremented value. If no such type
        //       exists, the program is ill-formed.
        QualType T = getNextLargerIntegralType($this().Context, new QualType(EltTy));
        if (T.isNull() || Enum.isFixed()) {
          // There is no integral type larger enough to represent this
          // value. Complain, then allow the value to wrap around.
          EnumVal.$assign(LastEnumConst.getInitVal());
          EnumVal.$assign(EnumVal.zext(EnumVal.getBitWidth() * 2));
          EnumVal.$preInc();
          if (Enum.isFixed()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // When the underlying type is fixed, this is ill-formed.
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IdLoc), diag.err_enumerator_wrapped)), 
                      EnumVal.__toString(10)), 
                  EltTy));
            } finally {
              $c$.$destroy();
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IdLoc), diag.ext_enumerator_increment_too_large)), 
                  EnumVal.__toString(10)));
            } finally {
              $c$.$destroy();
            }
          }
        } else {
          EltTy.$assign(T);
        }
        
        // Retrieve the last enumerator's value, extent that type to the
        // type that is supposed to be large enough to represent the incremented
        // value, then increment.
        EnumVal.$assign(LastEnumConst.getInitVal());
        EnumVal.setIsSigned(EltTy.$arrow().isSignedIntegerOrEnumerationType());
        EnumVal.$assign(EnumVal.zextOrTrunc($this().Context.getIntWidth(new QualType(EltTy))));
        EnumVal.$preInc();
        
        // If we're not in C++, diagnose the overflow of enumerator values,
        // which in C99 means that the enumerator value is not representable in
        // an int (C99 6.7.2.2p2). However, we support GCC's extension that
        // permits enumerator values that are representable in some larger
        // integral type.
        if (!$this().getLangOpts().CPlusPlus && !T.isNull()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(IdLoc), diag.warn_enum_value_overflow)));
          } finally {
            $c$.$destroy();
          }
        }
      } else if (!$this().getLangOpts().CPlusPlus
         && !isRepresentableIntegerValue($this().Context, EnumVal, new QualType(EltTy))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Enforce C99 6.7.2.2p2 even when we compute the next value.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IdLoc), diag.ext_enum_value_not_int)), 
                  EnumVal.__toString(10)), 1));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  if (!EltTy.$arrow().isDependentType()) {
    // Make the enumerator value match the signedness and size of the
    // enumerator's type.
    EnumVal.$assignMove(EnumVal.extOrTrunc($this().Context.getIntWidth(new QualType(EltTy))));
    EnumVal.setIsSigned(EltTy.$arrow().isSignedIntegerOrEnumerationType());
  }
  
  return EnumConstantDecl.Create($this().Context, Enum, new SourceLocation(IdLoc), Id, new QualType(EltTy), 
      Val, EnumVal);
}


/// \brief Check that this is a valid underlying type for an enum declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckEnumUnderlyingType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 11993,
 FQN="clang::Sema::CheckEnumUnderlyingType", NM="_ZN5clang4Sema23CheckEnumUnderlyingTypeEPNS_14TypeSourceInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema23CheckEnumUnderlyingTypeEPNS_14TypeSourceInfoE")
//</editor-fold>
public final boolean CheckEnumUnderlyingType(TypeSourceInfo /*P*/ TI) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    SourceLocation UnderlyingLoc = TI.getTypeLoc().getBeginLoc();
    QualType T = TI.getType();
    if (T.$arrow().isDependentType()) {
      return false;
    }
    {
      
      /*const*/ BuiltinType /*P*/ BT = T.$arrow().getAs$BuiltinType();
      if ((BT != null)) {
        if (BT.isInteger()) {
          return false;
        }
      }
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(UnderlyingLoc), diag.err_enum_invalid_underlying)), T));
    return true;
  } finally {
    $c$.$destroy();
  }
}


/// Check whether this is a valid redeclaration of a previous enumeration.
/// \return true if the redeclaration was invalid.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckEnumRedeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 12010,
 FQN="clang::Sema::CheckEnumRedeclaration", NM="_ZN5clang4Sema22CheckEnumRedeclarationENS_14SourceLocationEbNS_8QualTypeEbPKNS_8EnumDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema22CheckEnumRedeclarationENS_14SourceLocationEbNS_8QualTypeEbPKNS_8EnumDeclE")
//</editor-fold>
public final boolean CheckEnumRedeclaration(SourceLocation EnumLoc, boolean IsScoped, QualType EnumUnderlyingTy, 
                      boolean EnumUnderlyingIsImplicit, /*const*/ EnumDecl /*P*/ Prev) {
  boolean IsFixed = !EnumUnderlyingTy.isNull();
  if (IsScoped != Prev.isScoped()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(EnumLoc), diag.err_enum_redeclare_scoped_mismatch)), 
          Prev.isScoped()));
      $c$.clean($c$.track($this().Diag(Prev.getLocation(), diag.note_previous_declaration)));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  if (IsFixed && Prev.isFixed()) {
    if (!EnumUnderlyingTy.$arrow().isDependentType()
       && !Prev.getIntegerType().$arrow().isDependentType()
       && !$this().Context.hasSameUnqualifiedType(new QualType(EnumUnderlyingTy), 
        Prev.getIntegerType())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // TODO: Highlight the underlying type of the redeclaration.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(EnumLoc), diag.err_enum_redeclare_type_mismatch)), 
                EnumUnderlyingTy), Prev.getIntegerType()));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Prev.getLocation(), diag.note_previous_declaration)), 
            Prev.getIntegerTypeRange()));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
  } else if (IsFixed && !Prev.isFixed() && EnumUnderlyingIsImplicit) {
    ;
  } else if (!IsFixed && Prev.isFixed() && !(Prev.getIntegerTypeSourceInfo() != null)) {
    ;
  } else if (IsFixed != Prev.isFixed()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(EnumLoc), diag.err_enum_redeclare_fixed_mismatch)), 
          Prev.isFixed()));
      $c$.clean($c$.track($this().Diag(Prev.getLocation(), diag.note_previous_declaration)));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}


/// Determine whether the body of an anonymous enumeration should be skipped.
/// \param II The name of the first enumerator.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::shouldSkipAnonEnumBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 14482,
 FQN="clang::Sema::shouldSkipAnonEnumBody", NM="_ZN5clang4Sema22shouldSkipAnonEnumBodyEPNS_5ScopeEPNS_14IdentifierInfoENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema22shouldSkipAnonEnumBodyEPNS_5ScopeEPNS_14IdentifierInfoENS_14SourceLocationE")
//</editor-fold>
public final Sema.SkipBodyInfo shouldSkipAnonEnumBody(Scope /*P*/ S, IdentifierInfo /*P*/ II, 
                      SourceLocation IILoc) {
  if (!($this().getLangOpts().Modules || $this().getLangOpts().ModulesLocalVisibility)
     || !$this().getLangOpts().CPlusPlus) {
    return new SkipBodyInfo();
  }
  
  // We have an anonymous enum definition. Look up the first enumerator to
  // determine if we should merge the definition with an existing one and
  // skip the body.
  NamedDecl /*P*/ PrevDecl = $this().LookupSingleName(S, new DeclarationName(II), new SourceLocation(IILoc), LookupNameKind.LookupOrdinaryName, 
      RedeclarationKind.ForRedeclaration);
  EnumConstantDecl /*P*/ PrevECD = dyn_cast_or_null_EnumConstantDecl(PrevDecl);
  if (!(PrevECD != null)) {
    return new SkipBodyInfo();
  }
  
  EnumDecl /*P*/ PrevED = cast_EnumDecl(PrevECD.getDeclContext());
  type$ptr<NamedDecl /*P*/ > Hidden = create_type$null$ptr();
  if (!PrevED.getDeclName().$bool() && !$this().hasVisibleDefinition(PrevED, $AddrOf(Hidden))) {
    SkipBodyInfo Skip/*J*/= new SkipBodyInfo();
    Skip.Previous = Hidden.$star();
    return Skip;
  }
  
  return new SkipBodyInfo();
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnEnumConstant">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 14508,
 FQN="clang::Sema::ActOnEnumConstant", NM="_ZN5clang4Sema17ActOnEnumConstantEPNS_5ScopeEPNS_4DeclES4_NS_14SourceLocationEPNS_14IdentifierInfoEPNS_13AttributeListES5_PNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema17ActOnEnumConstantEPNS_5ScopeEPNS_4DeclES4_NS_14SourceLocationEPNS_14IdentifierInfoEPNS_13AttributeListES5_PNS_4ExprE")
//</editor-fold>
public final Decl /*P*/ ActOnEnumConstant(Scope /*P*/ S, Decl /*P*/ theEnumDecl, Decl /*P*/ lastEnumConst, 
                 SourceLocation IdLoc, IdentifierInfo /*P*/ Id, 
                 AttributeList /*P*/ Attr, 
                 SourceLocation EqualLoc, Expr /*P*/ Val) {
  EnumDecl /*P*/ TheEnumDecl = cast_EnumDecl(theEnumDecl);
  EnumConstantDecl /*P*/ LastEnumConst = cast_or_null_EnumConstantDecl(lastEnumConst);
  
  // The scope passed in may not be a decl scope.  Zip up the scope tree until
  // we find one that is.
  S = $this().getNonFieldDeclScope(S);
  
  // Verify that there isn't already something declared with this name in this
  // scope.
  NamedDecl /*P*/ PrevDecl = $this().LookupSingleName(S, new DeclarationName(Id), new SourceLocation(IdLoc), LookupNameKind.LookupOrdinaryName, 
      RedeclarationKind.ForRedeclaration);
  if ((PrevDecl != null) && PrevDecl.isTemplateParameter()) {
    // Maybe we will complain about the shadowed template parameter.
    $this().DiagnoseTemplateParameterShadow(new SourceLocation(IdLoc), PrevDecl);
    // Just pretend that we didn't see the previous declaration.
    PrevDecl = null;
  }
  
  // C++ [class.mem]p15:
  // If T is the name of a class, then each of the following shall have a name
  // different from T:
  // - every enumerator of every member of class T that is an unscoped
  // enumerated type
  if (!TheEnumDecl.isScoped()) {
    $this().DiagnoseClassNameShadow(TheEnumDecl.getDeclContext(), 
        new DeclarationNameInfo(new DeclarationName(Id), new SourceLocation(IdLoc)));
  }
  
  EnumConstantDecl /*P*/ New = $this().CheckEnumConstant(TheEnumDecl, LastEnumConst, new SourceLocation(IdLoc), Id, Val);
  if (!(New != null)) {
    return null;
  }
  if ((PrevDecl != null)) {
    // When in C++, we may get a TagDecl with the same name; in this case the
    // enum constant will 'hide' the tag.
    assert (($this().getLangOpts().CPlusPlus || !isa_TagDecl(PrevDecl))) : "Received TagDecl when not in C++!";
    if (!isa_TagDecl(PrevDecl) && $this().isDeclInScope(PrevDecl, $this().CurContext, S)
       && $this().shouldLinkPossiblyHiddenDecl(PrevDecl, New)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        if (isa_EnumConstantDecl(PrevDecl)) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IdLoc), diag.err_redefinition_of_enumerator)), Id));
        } else {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IdLoc), diag.err_redefinition)), Id));
        }
        $c$.clean($c$.track($this().Diag(PrevDecl.getLocation(), diag.note_previous_definition)));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Process attributes.
  if ((Attr != null)) {
    $this().ProcessDeclAttributeList(S, New, Attr);
  }
  
  // Register this decl in the current scope stack.
  New.setAccess(TheEnumDecl.getAccess());
  $this().PushOnScopeChains(New, S);
  
  $this().ActOnDocumentableDecl(New);
  
  return New;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnEnumBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 14778,
 FQN="clang::Sema::ActOnEnumBody", NM="_ZN5clang4Sema13ActOnEnumBodyENS_14SourceLocationENS_11SourceRangeEPNS_4DeclEN4llvm8ArrayRefIS4_EEPNS_5ScopeEPNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema13ActOnEnumBodyENS_14SourceLocationENS_11SourceRangeEPNS_4DeclEN4llvm8ArrayRefIS4_EEPNS_5ScopeEPNS_13AttributeListE")
//</editor-fold>
public final void ActOnEnumBody(SourceLocation EnumLoc, SourceRange BraceRange, 
             Decl /*P*/ EnumDeclX, 
             ArrayRef<Decl /*P*/ > Elements, 
             Scope /*P*/ S, AttributeList /*P*/ Attr) {
  EnumDecl /*P*/ Enum = cast_EnumDecl(EnumDeclX);
  QualType EnumType = $this().Context.getTypeDeclType(Enum);
  if ((Attr != null)) {
    $this().ProcessDeclAttributeList(S, Enum, Attr);
  }
  if (Enum.isDependentType()) {
    for (/*uint*/int i = 0, e = Elements.size(); i != e; ++i) {
      EnumConstantDecl /*P*/ ECD = cast_or_null_EnumConstantDecl(Elements.$at(i));
      if (!(ECD != null)) {
        continue;
      }
      
      ECD.setType(new QualType(EnumType));
    }
    
    Enum.completeDefinition($this().Context.DependentTy.$QualType(), $this().Context.DependentTy.$QualType(), 0, 0);
    return;
  }
  
  // TODO: If the result value doesn't fit in an int, it must be a long or long
  // long value.  ISO C does not support this, but GCC does as an extension,
  // emit a warning.
  /*uint*/int IntWidth = $this().Context.getTargetInfo().getIntWidth();
  /*uint*/int CharWidth = $this().Context.getTargetInfo().getCharWidth();
  /*uint*/int ShortWidth = $this().Context.getTargetInfo().getShortWidth();
  
  // Verify that all the values are okay, compute the size of the values, and
  // reverse the list.
  /*uint*/int NumNegativeBits = 0;
  /*uint*/int NumPositiveBits = 0;
  
  // Keep track of whether all elements have type int.
  boolean AllElementsInt = true;
  
  for (/*uint*/int i = 0, e = Elements.size(); i != e; ++i) {
    EnumConstantDecl /*P*/ ECD = cast_or_null_EnumConstantDecl(Elements.$at(i));
    if (!(ECD != null)) {
      continue; // Already issued a diagnostic.
    }
    
    final /*const*/ APSInt /*&*/ InitVal = ECD.getInitVal();
    
    // Keep track of the size of positive and negative values.
    if (InitVal.isUnsigned() || InitVal.isNonNegative()) {
      NumPositiveBits = std.max(NumPositiveBits, 
          (/*uint*/int)InitVal.getActiveBits());
    } else {
      NumNegativeBits = std.max(NumNegativeBits, 
          (/*uint*/int)InitVal.getMinSignedBits());
    }
    
    // Keep track of whether every enum element has type int (very commmon).
    if (AllElementsInt) {
      AllElementsInt = $eq_QualType$C(ECD.getType(), $this().Context.IntTy.$QualType());
    }
  }
  
  // Figure out the type that should be used for this enum.
  QualType BestType/*J*/= new QualType();
  /*uint*/int BestWidth;
  
  // C++0x N3000 [conv.prom]p3:
  //   An rvalue of an unscoped enumeration type whose underlying
  //   type is not fixed can be converted to an rvalue of the first
  //   of the following types that can represent all the values of
  //   the enumeration: int, unsigned int, long int, unsigned long
  //   int, long long int, or unsigned long long int.
  // C99 6.4.4.3p2:
  //   An identifier declared as an enumeration constant has type int.
  // The C99 rule is modified by a gcc extension
  QualType BestPromotionType/*J*/= new QualType();
  
  boolean Packed = Enum.hasAttr(PackedAttr.class);
  // -fshort-enums is the equivalent to specifying the packed attribute on all
  // enum definitions.
  if ($this().LangOpts.ShortEnums) {
    Packed = true;
  }
  if (Enum.isFixed()) {
    BestType.$assignMove(Enum.getIntegerType());
    if (BestType.$arrow().isPromotableIntegerType()) {
      BestPromotionType.$assignMove($this().Context.getPromotedIntegerType(new QualType(BestType)));
    } else {
      BestPromotionType.$assign(BestType);
    }
    
    BestWidth = $this().Context.getIntWidth(new QualType(BestType));
  } else if ((NumNegativeBits != 0)) {
    // If there is a negative value, figure out the smallest integer type (of
    // int/long/longlong) that fits.
    // If it's packed, check also if it fits a char or a short.
    if (Packed && $lesseq_uint(NumNegativeBits, CharWidth) && $less_uint(NumPositiveBits, CharWidth)) {
      BestType.$assignMove($this().Context.SignedCharTy.$QualType());
      BestWidth = CharWidth;
    } else if (Packed && $lesseq_uint(NumNegativeBits, ShortWidth)
       && $less_uint(NumPositiveBits, ShortWidth)) {
      BestType.$assignMove($this().Context.ShortTy.$QualType());
      BestWidth = ShortWidth;
    } else if ($lesseq_uint(NumNegativeBits, IntWidth) && $less_uint(NumPositiveBits, IntWidth)) {
      BestType.$assignMove($this().Context.IntTy.$QualType());
      BestWidth = IntWidth;
    } else {
      BestWidth = $this().Context.getTargetInfo().getLongWidth();
      if ($lesseq_uint(NumNegativeBits, BestWidth) && $less_uint(NumPositiveBits, BestWidth)) {
        BestType.$assignMove($this().Context.LongTy.$QualType());
      } else {
        BestWidth = $this().Context.getTargetInfo().getLongLongWidth();
        if ($greater_uint(NumNegativeBits, BestWidth) || $greatereq_uint(NumPositiveBits, BestWidth)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(Enum.getLocation(), diag.ext_enum_too_large)));
          } finally {
            $c$.$destroy();
          }
        }
        BestType.$assignMove($this().Context.LongLongTy.$QualType());
      }
    }
    BestPromotionType.$assignMove(($lesseq_uint(BestWidth, IntWidth) ? $this().Context.IntTy.$QualType() : new QualType(BestType)));
  } else {
    // If there is no negative value, figure out the smallest type that fits
    // all of the enumerator values.
    // If it's packed, check also if it fits a char or a short.
    if (Packed && $lesseq_uint(NumPositiveBits, CharWidth)) {
      BestType.$assignMove($this().Context.UnsignedCharTy.$QualType());
      BestPromotionType.$assignMove($this().Context.IntTy.$QualType());
      BestWidth = CharWidth;
    } else if (Packed && $lesseq_uint(NumPositiveBits, ShortWidth)) {
      BestType.$assignMove($this().Context.UnsignedShortTy.$QualType());
      BestPromotionType.$assignMove($this().Context.IntTy.$QualType());
      BestWidth = ShortWidth;
    } else if ($lesseq_uint(NumPositiveBits, IntWidth)) {
      BestType.$assignMove($this().Context.UnsignedIntTy.$QualType());
      BestWidth = IntWidth;
      BestPromotionType.$assignMove(
          ((NumPositiveBits == BestWidth || !$this().getLangOpts().CPlusPlus) ? $this().Context.UnsignedIntTy : $this().Context.IntTy).$QualType()
      );
    } else if ($lesseq_uint(NumPositiveBits
      , (BestWidth = $this().Context.getTargetInfo().getLongWidth()))) {
      BestType.$assignMove($this().Context.UnsignedLongTy.$QualType());
      BestPromotionType.$assignMove(
          ((NumPositiveBits == BestWidth || !$this().getLangOpts().CPlusPlus) ? $this().Context.UnsignedLongTy : $this().Context.LongTy).$QualType()
      );
    } else {
      BestWidth = $this().Context.getTargetInfo().getLongLongWidth();
      assert ($lesseq_uint(NumPositiveBits, BestWidth)) : "How could an initializer get larger than ULL?";
      BestType.$assignMove($this().Context.UnsignedLongLongTy.$QualType());
      BestPromotionType.$assignMove(
          ((NumPositiveBits == BestWidth || !$this().getLangOpts().CPlusPlus) ? $this().Context.UnsignedLongLongTy : $this().Context.LongLongTy).$QualType()
      );
    }
  }
  
  // Loop over all of the enumerator constants, changing their types to match
  // the type of the enum if needed.
  for (Decl /*P*/ D : Elements) {
    EnumConstantDecl /*P*/ ECD = cast_or_null_EnumConstantDecl(D);
    if (!(ECD != null)) {
      continue; // Already issued a diagnostic.
    }
    
    // Standard C says the enumerators have int type, but we allow, as an
    // extension, the enumerators to be larger than int size.  If each
    // enumerator value fits in an int, type it as an int, otherwise type it the
    // same as the enumerator decl itself.  This means that in "enum { X = 1U }"
    // that X has type 'int', not 'unsigned'.
    
    // Determine whether the value fits into an int.
    APSInt InitVal = new APSInt(ECD.getInitVal());
    
    // If it fits into an integer type, force it.  Otherwise force it to match
    // the enum decl type.
    QualType NewTy/*J*/= new QualType();
    /*uint*/int NewWidth;
    boolean NewSign;
    if (!$this().getLangOpts().CPlusPlus
       && !Enum.isFixed()
       && isRepresentableIntegerValue($this().Context, InitVal, $this().Context.IntTy.$QualType())) {
      NewTy.$assignMove($this().Context.IntTy.$QualType());
      NewWidth = IntWidth;
      NewSign = true;
    } else if ($eq_QualType$C(ECD.getType(), BestType)) {
      // Already the right type!
      if ($this().getLangOpts().CPlusPlus) {
        // C++ [dcl.enum]p4: Following the closing brace of an
        // enum-specifier, each enumerator has the type of its
        // enumeration.
        ECD.setType(new QualType(EnumType));
      }
      continue;
    } else {
      NewTy.$assign(BestType);
      NewWidth = BestWidth;
      NewSign = BestType.$arrow().isSignedIntegerOrEnumerationType();
    }
    
    // Adjust the APSInt value.
    InitVal.$assignMove(InitVal.extOrTrunc(NewWidth));
    InitVal.setIsSigned(NewSign);
    ECD.setInitVal(InitVal);
    
    // Adjust the Expr initializer and type.
    if ((ECD.getInitExpr() != null)
       && !$this().Context.hasSameType(new QualType(NewTy), ECD.getInitExpr().getType())) {
      ECD.setInitExpr(ImplicitCastExpr.Create($this().Context, new QualType(NewTy), 
              CastKind.CK_IntegralCast, 
              ECD.getInitExpr(), 
              /*base paths*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, 
              ExprValueKind.VK_RValue));
    }
    if ($this().getLangOpts().CPlusPlus) {
      // C++ [dcl.enum]p4: Following the closing brace of an
      // enum-specifier, each enumerator has the type of its
      // enumeration.
      ECD.setType(new QualType(EnumType));
    } else {
      ECD.setType(new QualType(NewTy));
    }
  }
  
  Enum.completeDefinition(new QualType(BestType), new QualType(BestPromotionType), 
      NumPositiveBits, NumNegativeBits);
  
  CheckForDuplicateEnumValues(/*Deref*/$this(), new ArrayRef<Decl /*P*/ >(Elements), Enum, new QualType(EnumType));
  if (Enum.hasAttr(FlagEnumAttr.class)) {
    for (Decl /*P*/ D : Elements) {
      EnumConstantDecl /*P*/ ECD = cast_or_null_EnumConstantDecl(D);
      if (!(ECD != null)) {
        continue; // Already issued a diagnostic.
      }
      
      APSInt InitVal = new APSInt(ECD.getInitVal());
      if (InitVal.$noteq(0) && !InitVal.isPowerOf2()
         && !$this().IsValueInFlagEnum(Enum, InitVal, true)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ECD.getLocation(), diag.warn_flag_enum_constant_out_of_range)), 
                  ECD), Enum));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // Now that the enum type is defined, ensure it's not been underaligned.
  if (Enum.hasAttrs()) {
    $this().CheckAlignasUnderalignment(Enum);
  }
}


// Determines the context to return to after temporarily entering a
// context.  This depends in an unnecessarily complicated way on the
// exact ordering of callbacks from the parser.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getContainingDC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1077,
 FQN="clang::Sema::getContainingDC", NM="_ZN5clang4Sema15getContainingDCEPNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema15getContainingDCEPNS_11DeclContextE")
//</editor-fold>
public final DeclContext /*P*/ getContainingDC(DeclContext /*P*/ DC) {
  
  // Functions defined inline within classes aren't parsed until we've
  // finished parsing the top-level class, so the top-level class is
  // the context we'll need to return to.
  // A Lambda call operator whose parent is a class must not be treated
  // as an inline member function.  A Lambda can be used legally
  // either as an in-class member initializer or a default argument.  These
  // are parsed once the class has been marked complete and so the containing
  // context would be the nested class (when the lambda is defined in one);
  // If the class is not complete, then the lambda is being used in an
  // ill-formed fashion (such as to specify the width of a bit-field, or
  // in an array-bound) - in which case we still want to return the
  // lexically containing DC (which could be a nested class).
  if (isa_FunctionDecl(DC) && !isLambdaCallOperator(DC)) {
    DC = DC.getLexicalParent();
    
    // A function not defined within a class will always return to its
    // lexical context.
    if (!isa_CXXRecordDecl(DC)) {
      return DC;
    }
    {
      
      // A C++ inline method/friend is parsed *after* the topmost class
      // it was declared in is fully parsed ("complete");  the topmost
      // class is the context we need to return to.
      CXXRecordDecl /*P*/ RD;
      while (((/*P*/ RD = dyn_cast_CXXRecordDecl(DC.getLexicalParent())) != null)) {
        DC = RD;
      }
    }
    
    // Return the declaration context of the topmost class the inline method is
    // declared in.
    return DC;
  }
  
  return DC.getLexicalParent();
}


/// Set the current declaration context until it gets popped.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PushDeclContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1113,
 FQN="clang::Sema::PushDeclContext", NM="_ZN5clang4Sema15PushDeclContextEPNS_5ScopeEPNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema15PushDeclContextEPNS_5ScopeEPNS_11DeclContextE")
//</editor-fold>
public final void PushDeclContext(Scope /*P*/ S, DeclContext /*P*/ DC) {
  assert ($this().getContainingDC(DC) == $this().CurContext) : "The next DeclContext should be lexically contained in the current one.";
  $this().CurContext = DC;
  S.setEntity(DC);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::PopDeclContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1120,
 FQN="clang::Sema::PopDeclContext", NM="_ZN5clang4Sema14PopDeclContextEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema14PopDeclContextEv")
//</editor-fold>
public final void PopDeclContext() {
  assert (($this().CurContext != null)) : "DeclContext imbalance!";
  
  $this().CurContext = $this().getContainingDC($this().CurContext);
  assert (($this().CurContext != null)) : "Popped translation unit!";
}


/// EnterDeclaratorContext - Used when we must lookup names in the context
/// of a declarator's nested name specifier.

/// EnterDeclaratorContext - Used when we must lookup names in the context
/// of a declarator's nested name specifier.
///
//<editor-fold defaultstate="collapsed" desc="clang::Sema::EnterDeclaratorContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1148,
 FQN="clang::Sema::EnterDeclaratorContext", NM="_ZN5clang4Sema22EnterDeclaratorContextEPNS_5ScopeEPNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema22EnterDeclaratorContextEPNS_5ScopeEPNS_11DeclContextE")
//</editor-fold>
public final void EnterDeclaratorContext(Scope /*P*/ S, DeclContext /*P*/ DC) {
  // C++0x [basic.lookup.unqual]p13:
  //   A name used in the definition of a static data member of class
  //   X (after the qualified-id of the static member) is looked up as
  //   if the name was used in a member function of X.
  // C++0x [basic.lookup.unqual]p14:
  //   If a variable member of a namespace is defined outside of the
  //   scope of its namespace then any name used in the definition of
  //   the variable member (after the declarator-id) is looked up as
  //   if the definition of the variable member occurred in its
  //   namespace.
  // Both of these imply that we should push a scope whose context
  // is the semantic context of the declaration.  We can't use
  // PushDeclContext here because that context is not necessarily
  // lexically contained in the current context.  Fortunately,
  // the containing scope should have the appropriate information.
  assert (!(S.getEntity() != null)) : "scope already has entity";
  Scope /*P*/ Ancestor = S.getParent();
  while (!(Ancestor.getEntity() != null)) {
    Ancestor = Ancestor.getParent();
  }
  assert (Ancestor.getEntity() == $this().CurContext) : "ancestor context mismatch";
  
  $this().CurContext = DC;
  S.setEntity(DC);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ExitDeclaratorContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1177,
 FQN="clang::Sema::ExitDeclaratorContext", NM="_ZN5clang4Sema21ExitDeclaratorContextEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema21ExitDeclaratorContextEPNS_5ScopeE")
//</editor-fold>
public final void ExitDeclaratorContext(Scope /*P*/ S) {
  assert (S.getEntity() == $this().CurContext) : "Context imbalance!";
  
  // Switch back to the lexical context.  The safety of this is
  // enforced by an assert in EnterDeclaratorContext.
  Scope /*P*/ Ancestor = S.getParent();
  while (!(Ancestor.getEntity() != null)) {
    Ancestor = Ancestor.getParent();
  }
  $this().CurContext = Ancestor.getEntity();
  // We don't need to do anything with the scope, which is going to
  // disappear.
}


/// Push the parameters of D, which must be a function, into scope.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnReenterFunctionContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1190,
 FQN="clang::Sema::ActOnReenterFunctionContext", NM="_ZN5clang4Sema27ActOnReenterFunctionContextEPNS_5ScopeEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema27ActOnReenterFunctionContextEPNS_5ScopeEPNS_4DeclE")
//</editor-fold>
public final void ActOnReenterFunctionContext(Scope /*P*/ S, Decl /*P*/ D) {
  // We assume that the caller has already called
  // ActOnReenterTemplateScope so getTemplatedDecl() works.
  FunctionDecl /*P*/ FD = D.getAsFunction();
  if (!(FD != null)) {
    return;
  }
  
  // Same implementation as PushDeclContext, but enters the context
  // from the lexical parent, rather than the top-level class.
  assert ($this().CurContext == FD.getLexicalParent()) : "The next DeclContext should be lexically contained in the current one.";
  $this().CurContext = FD;
  S.setEntity($this().CurContext);
  
  for (/*uint*/int P = 0, NumParams = FD.getNumParams(); $less_uint(P, NumParams); ++P) {
    ParmVarDecl /*P*/ Param = FD.getParamDecl(P);
    // If the parameter has an identifier, then add it to the scope
    if ((Param.getIdentifier() != null)) {
      S.AddDecl(Param);
      $this().IdResolver.AddDecl(Param);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnExitFunctionContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1214,
 FQN="clang::Sema::ActOnExitFunctionContext", NM="_ZN5clang4Sema24ActOnExitFunctionContextEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema24ActOnExitFunctionContextEv")
//</editor-fold>
public final void ActOnExitFunctionContext() {
  // Same implementation as PopDeclContext, but returns to the lexical parent,
  // rather than the top-level class.
  assert (($this().CurContext != null)) : "DeclContext imbalance!";
  $this().CurContext = $this().CurContext.getLexicalParent();
  assert (($this().CurContext != null)) : "Popped translation unit!";
}


/// Add this decl to the scope shadowed decl chains.

/// Add this decl to the scope shadowed decl chains.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PushOnScopeChains">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1244,
 FQN="clang::Sema::PushOnScopeChains", NM="_ZN5clang4Sema17PushOnScopeChainsEPNS_9NamedDeclEPNS_5ScopeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema17PushOnScopeChainsEPNS_9NamedDeclEPNS_5ScopeEb")
//</editor-fold>
public final void PushOnScopeChains(NamedDecl /*P*/ D, Scope /*P*/ S) {
  PushOnScopeChains(D, S, true);
}
public final void PushOnScopeChains(NamedDecl /*P*/ D, Scope /*P*/ S, boolean AddToContext/*= true*/) {
  // Move up the scope chain until we find the nearest enclosing
  // non-transparent context. The declaration will be introduced into this
  // scope.
  while ((S.getEntity() != null) && S.getEntity().isTransparentContext()) {
    S = S.getParent();
  }
  
  // Add scoped declarations into their context, so that they can be
  // found later. Declarations without a context won't be inserted
  // into any context.
  if (AddToContext) {
    $this().CurContext.addDecl(D);
  }
  
  // Out-of-line definitions shouldn't be pushed into scope in C++, unless they
  // are function-local declarations.
  if ($this().getLangOpts().CPlusPlus && D.isOutOfLine()
     && !D.getDeclContext().getRedeclContext().Equals(D.getLexicalDeclContext().getRedeclContext())
     && !D.getLexicalDeclContext().isFunctionOrMethod()) {
    return;
  }
  
  // Template instantiations should also not be pushed into scope.
  if (isa_FunctionDecl(D)
     && cast_FunctionDecl(D).isFunctionTemplateSpecialization()) {
    return;
  }
  
  // If this replaces anything in the current scope,
  IdentifierResolver.iterator I = $this().IdResolver.begin(D.getDeclName());
  IdentifierResolver.iterator IEnd = $this().IdResolver.end();
  for (; I.$noteq(IEnd); I.$preInc()) {
    if (S.isDeclScope(I.$star()) && D.declarationReplaces(I.$star())) {
      S.RemoveDecl(I.$star());
      $this().IdResolver.RemoveDecl(I.$star());
      
      // Should only need to replace one decl.
      break;
    }
  }
  
  S.AddDecl(D);
  if (isa_LabelDecl(D) && !cast_LabelDecl(D).isGnuLocal()) {
    // Implicitly-generated labels may end up getting generated in an order that
    // isn't strictly lexical, which breaks name lookup. Be careful to insert
    // the label at the appropriate place in the identifier chain.
    for (I.$assignMove($this().IdResolver.begin(D.getDeclName())); I.$noteq(IEnd); I.$preInc()) {
      DeclContext /*P*/ IDC = (I.$star()).getLexicalDeclContext().getRedeclContext();
      if (IDC == $this().CurContext) {
        if (!S.isDeclScope(I.$star())) {
          continue;
        }
      } else if (IDC.Encloses($this().CurContext)) {
        break;
      }
    }
    
    $this().IdResolver.InsertDeclAfter(new IdentifierResolver.iterator(I), D);
  } else {
    $this().IdResolver.AddDecl(D);
  }
}


/// \brief Make the given externally-produced declaration visible at the
/// top level scope.
///
/// \param D The externally-produced declaration to push.
///
/// \param Name The name of the externally-produced declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::pushExternalDeclIntoScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1304,
 FQN="clang::Sema::pushExternalDeclIntoScope", NM="_ZN5clang4Sema25pushExternalDeclIntoScopeEPNS_9NamedDeclENS_15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema25pushExternalDeclIntoScopeEPNS_9NamedDeclENS_15DeclarationNameE")
//</editor-fold>
public final void pushExternalDeclIntoScope(NamedDecl /*P*/ D, DeclarationName Name) {
  if ($this().IdResolver.tryAddTopLevelDecl(D, new DeclarationName(Name)) && ($this().TUScope != null)) {
    $this().TUScope.AddDecl(D);
  }
}


/// isDeclInScope - If 'Ctx' is a function/method, isDeclInScope returns true
/// if 'D' is in Scope 'S', otherwise 'S' is ignored and isDeclInScope returns
/// true if 'D' belongs to the given declaration context.
///
/// \param AllowInlineNamespace If \c true, allow the declaration to be in the
///        enclosing namespace set of the context, rather than contained
///        directly within it.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isDeclInScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1309,
 FQN="clang::Sema::isDeclInScope", NM="_ZN5clang4Sema13isDeclInScopeEPNS_9NamedDeclEPNS_11DeclContextEPNS_5ScopeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema13isDeclInScopeEPNS_9NamedDeclEPNS_11DeclContextEPNS_5ScopeEb")
//</editor-fold>
public final boolean isDeclInScope(NamedDecl /*P*/ D, DeclContext /*P*/ Ctx) {
  return isDeclInScope(D, Ctx, (Scope /*P*/ )null, 
             false);
}
public final boolean isDeclInScope(NamedDecl /*P*/ D, DeclContext /*P*/ Ctx, Scope /*P*/ S/*= null*/) {
  return isDeclInScope(D, Ctx, S, 
             false);
}
public final boolean isDeclInScope(NamedDecl /*P*/ D, DeclContext /*P*/ Ctx, Scope /*P*/ S/*= null*/, 
             boolean AllowInlineNamespace/*= false*/) {
  return $this().IdResolver.isDeclInScope(D, Ctx, S, AllowInlineNamespace);
}


/// Finds the scope corresponding to the given decl context, if it
/// happens to be an enclosing scope.  Otherwise return NULL.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getScopeForDeclContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1314,
 FQN="clang::Sema::getScopeForDeclContext", NM="_ZN5clang4Sema22getScopeForDeclContextEPNS_5ScopeEPNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema22getScopeForDeclContextEPNS_5ScopeEPNS_11DeclContextE")
//</editor-fold>
public static Scope /*P*/ getScopeForDeclContext(Scope /*P*/ S, DeclContext /*P*/ DC) {
  DeclContext /*P*/ TargetDC = DC.getPrimaryContext();
  do {
    {
      DeclContext /*P*/ ScopeDC = S.getEntity();
      if ((ScopeDC != null)) {
        if (ScopeDC.getPrimaryContext() == TargetDC) {
          return S;
        }
      }
    }
  } while (((S = S.getParent()) != null));
  
  return null;
}


/// Subroutines of ActOnDeclarator().
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ParseTypedefDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 11935,
 FQN="clang::Sema::ParseTypedefDecl", NM="_ZN5clang4Sema16ParseTypedefDeclEPNS_5ScopeERNS_10DeclaratorENS_8QualTypeEPNS_14TypeSourceInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema16ParseTypedefDeclEPNS_5ScopeERNS_10DeclaratorENS_8QualTypeEPNS_14TypeSourceInfoE")
//</editor-fold>
public final TypedefDecl /*P*/ ParseTypedefDecl(Scope /*P*/ S, final Declarator /*&*/ D, QualType T, 
                TypeSourceInfo /*P*/ TInfo) {
  assert ((D.getIdentifier() != null)) : "Wrong callback for declspec without declarator";
  assert (!T.isNull()) : "GetTypeForDeclarator() returned null type";
  if (!(TInfo != null)) {
    assert (D.isInvalidType()) : "no declarator info for valid type";
    TInfo = $this().Context.getTrivialTypeSourceInfo(/*NO_COPY*/T);
  }
  
  // Scope manipulation handled by caller.
  TypedefDecl /*P*/ NewTD = TypedefDecl.Create($this().Context, $this().CurContext, 
      D.getLocStart(), 
      D.getIdentifierLoc(), 
      D.getIdentifier(), 
      TInfo);
  
  // Bail out immediately if we have an invalid declaration.
  if (D.isInvalidType()) {
    NewTD.setInvalidDecl();
    return NewTD;
  }
  if (D.getDeclSpec().isModulePrivateSpecified()) {
    if ($this().CurContext.isFunctionOrMethod()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(NewTD.getLocation(), diag.err_module_private_local)), 
                        2), NewTD.getDeclName()), 
                new SourceRange(D.getDeclSpec().getModulePrivateSpecLoc())), 
            FixItHint.CreateRemoval(new SourceRange(D.getDeclSpec().getModulePrivateSpecLoc()))));
      } finally {
        $c$.$destroy();
      }
    } else {
      NewTD.setModulePrivate();
    }
  }
  
  // C++ [dcl.typedef]p8:
  //   If the typedef declaration defines an unnamed class (or
  //   enum), the first typedef-name declared by the declaration
  //   to be that class type (or enum type) is used to denote the
  //   class type (or enum type) for linkage purposes only.
  // We need to check whether the type was declared in the declaration.
  switch (D.getDeclSpec().getTypeSpecType()) {
   case TST_enum:
   case TST_struct:
   case TST_interface:
   case TST_union:
   case TST_class:
    {
      TagDecl /*P*/ tagFromDeclSpec = cast_TagDecl(D.getDeclSpec().getRepAsDecl());
      $this().setTagNameForLinkagePurposes(tagFromDeclSpec, NewTD);
      break;
    }
   default:
    break;
  }
  
  return NewTD;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::isIncompatibleTypedef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1898,
 FQN="clang::Sema::isIncompatibleTypedef", NM="_ZN5clang4Sema21isIncompatibleTypedefEPNS_8TypeDeclEPNS_15TypedefNameDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema21isIncompatibleTypedefEPNS_8TypeDeclEPNS_15TypedefNameDeclE")
//</editor-fold>
public final boolean isIncompatibleTypedef(TypeDecl /*P*/ Old, TypedefNameDecl /*P*/ New) {
  QualType OldType/*J*/= new QualType();
  {
    TypedefNameDecl /*P*/ OldTypedef = dyn_cast_TypedefNameDecl(Old);
    if ((OldTypedef != null)) {
      OldType.$assignMove(OldTypedef.getUnderlyingType());
    } else {
      OldType.$assignMove($this().Context.getTypeDeclType(Old));
    }
  }
  QualType NewType = New.getUnderlyingType();
  if (NewType.$arrow().isVariablyModifiedType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Must not redefine a typedef with a variably-modified type.
      int Kind = isa_TypeAliasDecl(Old) ? 1 : 0;
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_redefinition_variably_modified_typedef)), 
              Kind), NewType));
      if (Old.getLocation().isValid()) {
        $c$.clean($c$.track($this().Diag(Old.getLocation(), diag.note_previous_definition)));
      }
      New.setInvalidDecl();
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  if ($noteq_QualType$C(OldType, NewType)
     && !OldType.$arrow().isDependentType()
     && !NewType.$arrow().isDependentType()
     && !$this().Context.hasSameType(new QualType(OldType), new QualType(NewType))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      int Kind = isa_TypeAliasDecl(Old) ? 1 : 0;
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_redefinition_different_typedef)), 
                  Kind), NewType), OldType));
      if (Old.getLocation().isValid()) {
        $c$.clean($c$.track($this().Diag(Old.getLocation(), diag.note_previous_definition)));
      }
      New.setInvalidDecl();
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  return false;
}


/// mergeDeclAttributes - Copy attributes from the Old decl to the New one.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::mergeDeclAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 2427,
 FQN="clang::Sema::mergeDeclAttributes", NM="_ZN5clang4Sema19mergeDeclAttributesEPNS_9NamedDeclEPNS_4DeclENS0_21AvailabilityMergeKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema19mergeDeclAttributesEPNS_9NamedDeclEPNS_4DeclENS0_21AvailabilityMergeKindE")
//</editor-fold>
public final void mergeDeclAttributes(NamedDecl /*P*/ New, Decl /*P*/ Old) {
  mergeDeclAttributes(New, Old, 
                   AvailabilityMergeKind.AMK_Redeclaration);
}
public final void mergeDeclAttributes(NamedDecl /*P*/ New, Decl /*P*/ Old, 
                   AvailabilityMergeKind AMK/*= AMK_Redeclaration*/) {
  {
    UsedAttr /*P*/ OldAttr = Old.getMostRecentDecl$Decl().getAttr(UsedAttr.class);
    if ((OldAttr != null)) {
      UsedAttr /*P*/ NewAttr = OldAttr.clone($this().Context);
      NewAttr.setInherited(true);
      New.addAttr(NewAttr);
    }
  }
  if (!Old.hasAttrs() && !New.hasAttrs()) {
    return;
  }
  
  // Attributes declared post-definition are currently ignored.
  checkNewAttributesAfterDef(/*Deref*/$this(), New, Old);
  {
    
    AsmLabelAttr /*P*/ NewA = New.getAttr(AsmLabelAttr.class);
    if ((NewA != null)) {
      {
        AsmLabelAttr /*P*/ OldA = Old.getAttr(AsmLabelAttr.class);
        if ((OldA != null)) {
          if ($noteq_StringRef(OldA.getLabel(), NewA.getLabel())) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // This redeclaration changes __asm__ label.
              $c$.clean($c$.track($this().Diag(New.getLocation(), diag.err_different_asm_label)));
              $c$.clean($c$.track($this().Diag(OldA.getLocation(), diag.note_previous_declaration)));
            } finally {
              $c$.$destroy();
            }
          }
        } else if (Old.isUsed()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // This redeclaration adds an __asm__ label to a declaration that has
            // already been ODR-used.
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_late_asm_label_name)), 
                    isa_FunctionDecl(Old)), New.getAttr(AsmLabelAttr.class).getRange()));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  {
    
    // Re-declaration cannot add abi_tag's.
    /*const*/ AbiTagAttr /*P*/ NewAbiTagAttr = New.getAttr(AbiTagAttr.class);
    if ((NewAbiTagAttr != null)) {
      {
        /*const*/ AbiTagAttr /*P*/ OldAbiTagAttr = Old.getAttr(AbiTagAttr.class);
        if ((OldAbiTagAttr != null)) {
          for (final /*const*/ StringRef /*&*/ NewTag : NewAbiTagAttr.tags()) {
            if ($eq_ptr(std.find(OldAbiTagAttr.tags_begin(), OldAbiTagAttr.tags_end(), 
                NewTag), OldAbiTagAttr.tags_end())) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewAbiTagAttr.getLocation(), 
                        diag.err_new_abi_tag_on_redeclaration)), 
                    NewTag));
                $c$.clean($c$.track($this().Diag(OldAbiTagAttr.getLocation(), diag.note_previous_declaration)));
              } finally {
                $c$.$destroy();
              }
            }
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(NewAbiTagAttr.getLocation(), diag.err_abi_tag_on_redeclaration)));
            $c$.clean($c$.track($this().Diag(Old.getLocation(), diag.note_previous_declaration)));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  if (!Old.hasAttrs()) {
    return;
  }
  
  boolean foundAny = New.hasAttrs();
  
  // Ensure that any moving of objects within the allocated map is done before
  // we process them.
  if (!foundAny) {
    New.setAttrs(new SmallVector<Attr /*P*/>(4, null));
  }
  
  for (InheritableAttr /*P*/ I : Old.specific_attrs(InheritableAttr.class)) {
    // Ignore deprecated/unavailable/availability attributes if requested.
    AvailabilityMergeKind LocalAMK = AvailabilityMergeKind.AMK_None;
    if (isa_DeprecatedAttr(I)
       || isa_UnavailableAttr(I)
       || isa_AvailabilityAttr(I)) {
      switch (AMK) {
       case AMK_None:
        continue;
       case AMK_Redeclaration:
       case AMK_Override:
       case AMK_ProtocolImplementation:
        LocalAMK = AMK;
        break;
      }
    }
    
    // Already handled.
    if (isa_UsedAttr(I)) {
      continue;
    }
    if (mergeDeclAttribute(/*Deref*/$this(), New, I, LocalAMK)) {
      foundAny = true;
    }
  }
  if (mergeAlignedAttrs(/*Deref*/$this(), New, Old)) {
    foundAny = true;
  }
  if (!foundAny) {
    New.dropAttrs();
  }
}


/// MergeTypedefNameDecl - We just parsed a typedef 'New' which has the
/// same name and scope as a previous declaration 'Old'.  Figure out
/// how to resolve this situation, merging decls or emitting
/// diagnostics as appropriate. If there was an error, set New to be invalid.
///
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MergeTypedefNameDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1937,
 FQN="clang::Sema::MergeTypedefNameDecl", NM="_ZN5clang4Sema20MergeTypedefNameDeclEPNS_5ScopeEPNS_15TypedefNameDeclERNS_12LookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema20MergeTypedefNameDeclEPNS_5ScopeEPNS_15TypedefNameDeclERNS_12LookupResultE")
//</editor-fold>
public final void MergeTypedefNameDecl(Scope /*P*/ S, TypedefNameDecl /*P*/ New, 
                    final LookupResult /*&*/ OldDecls) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // If the new decl is known invalid already, don't bother doing any
    // merging checks.
    if (New.isInvalidDecl()) {
      return;
    }
    
    // Allow multiple definitions for ObjC built-in typedefs.
    // FIXME: Verify the underlying types are equivalent!
    if ($this().getLangOpts().ObjC1) {
      /*const*/ IdentifierInfo /*P*/ TypeID = New.getIdentifier();
      switch (TypeID.getLength()) {
       default:
        break;
       case 2:
        {
          if (!TypeID.isStr(/*KEEP_STR*/"id")) {
            break;
          }
          QualType T = New.getUnderlyingType();
          if (!T.$arrow().isPointerType()) {
            break;
          }
          if (!T.$arrow().isVoidPointerType()) {
            QualType PT = T.$arrow().getAs(PointerType.class).getPointeeType();
            if (!PT.$arrow().isStructureType()) {
              break;
            }
          }
          $this().Context.setObjCIdRedefinitionType(new QualType(T));
          // Install the built-in type for 'id', ignoring the current definition.
          New.setTypeForDecl($this().Context.getObjCIdType().getTypePtr());
          return;
        }
       case 5:
        if (!TypeID.isStr(/*KEEP_STR*/"Class")) {
          break;
        }
        $this().Context.setObjCClassRedefinitionType(New.getUnderlyingType());
        // Install the built-in type for 'Class', ignoring the current definition.
        New.setTypeForDecl($this().Context.getObjCClassType().getTypePtr());
        return;
       case 3:
        if (!TypeID.isStr(/*KEEP_STR*/"SEL")) {
          break;
        }
        $this().Context.setObjCSelRedefinitionType(New.getUnderlyingType());
        // Install the built-in type for 'SEL', ignoring the current definition.
        New.setTypeForDecl($this().Context.getObjCSelType().getTypePtr());
        return;
      }
      // Fall through - the typedef name was not a builtin type.
    }
    
    // Verify the old decl was also a type.
    TypeDecl /*P*/ Old = OldDecls.<TypeDecl>getAsSingle(TypeDecl.class);
    if (!(Old != null)) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_redefinition_different_kind)), 
          New.getDeclName()));
      
      NamedDecl /*P*/ OldD = OldDecls.getRepresentativeDecl();
      if (OldD.getLocation().isValid()) {
        $c$.clean($c$.track($this().Diag(OldD.getLocation(), diag.note_previous_definition)));
      }
      
      New.setInvalidDecl();
      /*JAVA:return*/return;
    }
    
    // If the old declaration is invalid, just give up here.
    if (Old.isInvalidDecl()) {
      New.setInvalidDecl();
      /*JAVA:return*/return;
    }
    {
      
      TypedefNameDecl /*P*/ OldTD = dyn_cast_TypedefNameDecl(Old);
      if ((OldTD != null)) {
        TagDecl /*P*/ OldTag = OldTD.getAnonDeclWithTypedefName(/*AnyRedecl*/ true);
        TagDecl /*P*/ NewTag = New.getAnonDeclWithTypedefName();
        type$ptr<NamedDecl /*P*/ > Hidden = create_type$null$ptr(null);
        if ($this().getLangOpts().CPlusPlus && (OldTag != null) && (NewTag != null)
           && OldTag.getCanonicalDecl() != NewTag.getCanonicalDecl()
           && !$this().hasVisibleDefinition(OldTag, $AddrOf(Hidden))) {
          // There is a definition of this tag, but it is not visible. Use it
          // instead of our tag.
          New.setTypeForDecl(OldTD.getTypeForDecl());
          if (OldTD.isModed()) {
            New.setModedTypeSourceInfo(OldTD.getTypeSourceInfo(), 
                OldTD.getUnderlyingType());
          } else {
            New.setTypeSourceInfo(OldTD.getTypeSourceInfo());
          }
          
          // Make the old tag definition visible.
          $this().makeMergedDefinitionVisible(Hidden.$star(), NewTag.getLocation());
          
          // If this was an unscoped enumeration, yank all of its enumerators
          // out of the scope.
          if (isa_EnumDecl(NewTag)) {
            Scope /*P*/ EnumScope = $this().getNonFieldDeclScope(S);
            for (Decl /*P*/ D : NewTag.decls()) {
              EnumConstantDecl /*P*/ ED = cast_EnumConstantDecl(D);
              assert (EnumScope.isDeclScope(ED));
              EnumScope.RemoveDecl(ED);
              $this().IdResolver.RemoveDecl(ED);
              ED.getLexicalDeclContext().removeDecl(ED);
            }
          }
        }
      }
    }
    
    // If the typedef types are not identical, reject them in all languages and
    // with any extensions enabled.
    if ($this().isIncompatibleTypedef(Old, New)) {
      return;
    }
    {
      
      // The types match.  Link up the redeclaration chain and merge attributes if
      // the old declaration was a typedef.
      TypedefNameDecl /*P*/ Typedef = dyn_cast_TypedefNameDecl(Old);
      if ((Typedef != null)) {
        New.setPreviousDecl(Typedef);
        $this().mergeDeclAttributes(New, Old);
      }
    }
    if ($this().getLangOpts().MicrosoftExt) {
      return;
    }
    if ($this().getLangOpts().CPlusPlus) {
      // C++ [dcl.typedef]p2:
      //   In a given non-class scope, a typedef specifier can be used to
      //   redefine the name of any type declared in that scope to refer
      //   to the type to which it already refers.
      if (!isa_CXXRecordDecl($this().CurContext)) {
        return;
      }
      
      // C++0x [dcl.typedef]p4:
      //   In a given class scope, a typedef specifier can be used to redefine
      //   any class-name declared in that scope that is not also a typedef-name
      //   to refer to the type to which it already refers.
      //
      // This wording came in via DR424, which was a correction to the
      // wording in DR56, which accidentally banned code like:
      //
      //   struct S {
      //     typedef struct A { } A;
      //   };
      //
      // in the C++03 standard. We implement the C++0x semantics, which
      // allow the above but disallow
      //
      //   struct S {
      //     typedef int I;
      //     typedef int I;
      //   };
      //
      // since that was the intent of DR56.
      if (!isa_TypedefNameDecl(Old)) {
        return;
      }
      
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_redefinition)), 
          New.getDeclName()));
      $c$.clean($c$.track($this().Diag(Old.getLocation(), diag.note_previous_definition)));
      New.setInvalidDecl();
      /*JAVA:return*/return;
    }
    
    // Modules always permit redefinition of typedefs, as does C11.
    if ($this().getLangOpts().Modules || $this().getLangOpts().C11) {
      return;
    }
    
    // If we have a redefinition of a typedef in C, emit a warning.  This warning
    // is normally mapped to an error, but can be controlled with
    // -Wtypedef-redefinition.  If either the original or the redefinition is
    // in a system header, don't emit this for compatibility with GCC.
    if ($this().getDiagnostics().getSuppressSystemWarnings()
       && ($this().Context.getSourceManager().isInSystemHeader(Old.getLocation())
       || $this().Context.getSourceManager().isInSystemHeader(New.getLocation()))) {
      return;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.ext_redefinition_of_typedef)), 
        New.getDeclName()));
    $c$.clean($c$.track($this().Diag(Old.getLocation(), diag.note_previous_definition)));
  } finally {
    $c$.$destroy();
  }
}


/// MergeFunctionDecl - We just parsed a function 'New' from
/// declarator D which has the same name and scope as a previous
/// declaration 'Old'.  Figure out how to resolve this situation,
/// merging decls or emitting diagnostics as appropriate.
///
/// In C++, New and Old must be declarations that are not
/// overloaded. Use IsOverload to determine whether New and Old are
/// overloaded, and to select the Old declaration that New should be
/// merged with.
///
/// Returns true if there was an error, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MergeFunctionDecl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*tie/make_pair*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 2739,
 FQN="clang::Sema::MergeFunctionDecl", NM="_ZN5clang4Sema17MergeFunctionDeclEPNS_12FunctionDeclERPNS_9NamedDeclEPNS_5ScopeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema17MergeFunctionDeclEPNS_12FunctionDeclERPNS_9NamedDeclEPNS_5ScopeEb")
//</editor-fold>
public final boolean MergeFunctionDecl(FunctionDecl /*P*/ New, final type$ref<NamedDecl /*P*/ /*&*/> OldD, 
                 Scope /*P*/ S, boolean MergeTypeWithOld) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Verify the old decl was also a function.
    FunctionDecl /*P*/ Old = OldD.$deref().getAsFunction();
    if (!(Old != null)) {
      {
        UsingShadowDecl /*P*/ Shadow = dyn_cast_UsingShadowDecl(OldD.$deref());
        if ((Shadow != null)) {
          if ((New.getFriendObjectKind().getValue() != 0)) {
            $c$.clean($c$.track($this().Diag(New.getLocation(), diag.err_using_decl_friend)));
            $c$.clean($c$.track($this().Diag(Shadow.getTargetDecl().getLocation(), 
                diag.note_using_decl_target)));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Shadow.getUsingDecl().getLocation(), 
                    diag.note_using_decl)), 0));
            return true;
          }
          
          // Check whether the two declarations might declare the same function.
          if (checkUsingShadowRedecl(FunctionDecl.class, /*Deref*/$this(), Shadow, New)) {
            return true;
          }
          OldD.$set(Old = cast_FunctionDecl(Shadow.getTargetDecl()));
        } else {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_redefinition_different_kind)), 
              New.getDeclName()));
          $c$.clean($c$.track($this().Diag(OldD.$deref().getLocation(), diag.note_previous_definition)));
          return true;
        }
      }
    }
    
    // If the old declaration is invalid, just give up here.
    if (Old.isInvalidDecl()) {
      return true;
    }
    
    // JAVA: unfold tie
//    std.tie_uint_type(PrevDiag, OldLocation).$assign(
    std.pairUIntType<SourceLocation> $pair = getNoteDiagForInvalidRedeclaration(Old, New);
    /*uint*/int PrevDiag = $pair.first;
    SourceLocation OldLocation/*J*/= new SourceLocation($pair.second);
    
    // Don't complain about this if we're in GNU89 mode and the old function
    // is an extern inline function.
    // Don't complain about specializations. They are not supposed to have
    // storage classes.
    if (!isa_CXXMethodDecl(New) && !isa_CXXMethodDecl(Old)
       && New.getStorageClass() == StorageClass.SC_Static
       && Old.hasExternalFormalLinkage()
       && !(New.getTemplateSpecializationInfo() != null)
       && !canRedefineFunction(Old, $this().getLangOpts())) {
      if ($this().getLangOpts().MicrosoftExt) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.ext_static_non_static)), New));
        $c$.clean($c$.track($this().Diag(new SourceLocation(OldLocation), PrevDiag)));
      } else {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_static_non_static)), New));
        $c$.clean($c$.track($this().Diag(new SourceLocation(OldLocation), PrevDiag)));
        return true;
      }
    }
    if (New.hasAttr(InternalLinkageAttr.class)
       && !Old.hasAttr(InternalLinkageAttr.class)) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_internal_linkage_redeclaration)), 
          New.getDeclName()));
      $c$.clean($c$.track($this().Diag(Old.getLocation(), diag.note_previous_definition)));
      New.dropAttr(InternalLinkageAttr.class);
    }
    
    // If a function is first declared with a calling convention, but is later
    // declared or defined without one, all following decls assume the calling
    // convention of the first.
    //
    // It's OK if a function is first declared without a calling convention,
    // but is later declared or defined with the default calling convention.
    //
    // To test if either decl has an explicit calling convention, we look for
    // AttributedType sugar nodes on the type as written.  If they are missing or
    // were canonicalized away, we assume the calling convention was implicit.
    //
    // Note also that we DO NOT return at this point, because we still have
    // other tests to run.
    QualType OldQType = $this().Context.getCanonicalType(Old.getType()).$QualType();
    QualType NewQType = $this().Context.getCanonicalType(New.getType()).$QualType();
    /*const*/ FunctionType /*P*/ OldType = cast_FunctionType(OldQType);
    /*const*/ FunctionType /*P*/ NewType = cast_FunctionType(NewQType);
    FunctionType.ExtInfo OldTypeInfo = OldType.getExtInfo();
    FunctionType.ExtInfo NewTypeInfo = NewType.getExtInfo();
    boolean RequiresAdjustment = false;
    if (OldTypeInfo.getCC() != NewTypeInfo.getCC()) {
      FunctionDecl /*P*/ First = Old.getFirstDecl();
      /*const*/ FunctionType /*P*/ FT = First.getType().getCanonicalType().$arrow().castAs(FunctionType.class);
      FunctionType.ExtInfo FI = FT.getExtInfo();
      boolean NewCCExplicit = ($this().getCallingConvAttributedType(New.getType()) != null);
      if (!NewCCExplicit) {
        // Inherit the CC from the previous declaration if it was specified
        // there but not here.
        NewTypeInfo.$assignMove(NewTypeInfo.withCallingConv(OldTypeInfo.getCC()));
        RequiresAdjustment = true;
      } else {
        // Calling conventions aren't compatible, so complain.
        boolean FirstCCExplicit = ($this().getCallingConvAttributedType(First.getType()) != null);
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_cconv_change)), 
                    FunctionType.getNameForCallConv(NewTypeInfo.getCC())), 
                !FirstCCExplicit), 
            (!FirstCCExplicit ? new StringRef(/*KEEP_STR*/$EMPTY) : FunctionType.getNameForCallConv(FI.getCC()))));
        
        // Put the note on the first decl, since it is the one that matters.
        $c$.clean($c$.track($this().Diag(First.getLocation(), diag.note_previous_declaration)));
        return true;
      }
    }
    
    // FIXME: diagnose the other way around?
    if (OldTypeInfo.getNoReturn() && !NewTypeInfo.getNoReturn()) {
      NewTypeInfo.$assignMove(NewTypeInfo.withNoReturn(true));
      RequiresAdjustment = true;
    }
    
    // Merge regparm attribute.
    if (OldTypeInfo.getHasRegParm() != NewTypeInfo.getHasRegParm()
       || OldTypeInfo.getRegParm() != NewTypeInfo.getRegParm()) {
      if (NewTypeInfo.getHasRegParm()) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_regparm_mismatch)), 
                NewType.getRegParmType()), 
            OldType.getRegParmType()));
        $c$.clean($c$.track($this().Diag(new SourceLocation(OldLocation), diag.note_previous_declaration)));
        return true;
      }
      
      NewTypeInfo.$assignMove(NewTypeInfo.withRegParm(OldTypeInfo.getRegParm()));
      RequiresAdjustment = true;
    }
    
    // Merge ns_returns_retained attribute.
    if (OldTypeInfo.getProducesResult() != NewTypeInfo.getProducesResult()) {
      if (NewTypeInfo.getProducesResult()) {
        $c$.clean($c$.track($this().Diag(New.getLocation(), diag.err_returns_retained_mismatch)));
        $c$.clean($c$.track($this().Diag(new SourceLocation(OldLocation), diag.note_previous_declaration)));
        return true;
      }
      
      NewTypeInfo.$assignMove(NewTypeInfo.withProducesResult(true));
      RequiresAdjustment = true;
    }
    if (RequiresAdjustment) {
      /*const*/ FunctionType /*P*/ AdjustedType = New.getType().$arrow().getAs(FunctionType.class);
      AdjustedType = $this().Context.adjustFunctionType(AdjustedType, new FunctionType.ExtInfo(NewTypeInfo));
      New.setType(new QualType(AdjustedType, 0));
      NewQType.$assignMove($this().Context.getCanonicalType(New.getType()).$QualType());
      NewType = cast_FunctionType(NewQType);
    }
    
    // If this redeclaration makes the function inline, we may need to add it to
    // UndefinedButUsed.
    if (!Old.isInlined() && New.isInlined()
       && !New.hasAttr(GNUInlineAttr.class)
       && !$this().getLangOpts().GNUInline
       && Old.isUsed(false)
       && !Old.isDefined() && !New.isThisDeclarationADefinition()) {
      $this().UndefinedButUsed.insert(new std.pairPtrType<NamedDecl /*P*/ , SourceLocation>(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/Old.getCanonicalDecl(), new SourceLocation(JD$Move.INSTANCE, /*Fwd*/new SourceLocation(JD$Move.INSTANCE, /*Fwd2*/new SourceLocation()))));
    }
    
    // If this redeclaration makes it newly gnu_inline, we don't want to warn
    // about it.
    if (New.hasAttr(GNUInlineAttr.class)
       && Old.isInlined() && !Old.hasAttr(GNUInlineAttr.class)) {
      $this().UndefinedButUsed.erase(Old.getCanonicalDecl());
    }
    
    // If pass_object_size params don't match up perfectly, this isn't a valid
    // redeclaration.
    if ($greater_uint(Old.getNumParams(), 0) && Old.getNumParams() == New.getNumParams()
       && !hasIdenticalPassObjectSizeAttrs(Old, New)) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_different_pass_object_size_params)), 
          New.getDeclName()));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OldLocation), PrevDiag)), Old), Old.getType()));
      return true;
    }
    if ($this().getLangOpts().CPlusPlus) {
      // (C++98 13.1p2):
      //   Certain function declarations cannot be overloaded:
      //     -- Function declarations that differ only in the return type
      //        cannot be overloaded.
      
      // Go back to the type source info to compare the declared return types,
      // per C++1y [dcl.type.auto]p13:
      //   Redeclarations or specializations of a function or function template
      //   with a declared return type that uses a placeholder type shall also
      //   use that placeholder, not a deduced type.
      QualType OldDeclaredReturnType = ((Old.getTypeSourceInfo() != null) ? Old.getTypeSourceInfo().getType().$arrow().castAs(FunctionType.class) : OldType).getReturnType();
      QualType NewDeclaredReturnType = ((New.getTypeSourceInfo() != null) ? New.getTypeSourceInfo().getType().$arrow().castAs(FunctionType.class) : NewType).getReturnType();
      QualType ResQT/*J*/= new QualType();
      if (!$this().Context.hasSameType(new QualType(OldDeclaredReturnType), new QualType(NewDeclaredReturnType))
         && !((NewQType.$arrow().isDependentType() || OldQType.$arrow().isDependentType())
         && New.isLocalExternDecl())) {
        if (NewDeclaredReturnType.$arrow().isObjCObjectPointerType()
           && OldDeclaredReturnType.$arrow().isObjCObjectPointerType()) {
          ResQT.$assignMove($this().Context.mergeObjCGCQualifiers(new QualType(NewQType), new QualType(OldQType)));
        }
        if (ResQT.isNull()) {
          if (New.isCXXClassMember() && New.isOutOfLine()) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_member_def_does_not_match_ret_type)), 
                    New), New.getReturnTypeSourceRange()));
          } else {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_ovl_diff_return_type)), 
                New.getReturnTypeSourceRange()));
          }
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OldLocation), PrevDiag)), Old), Old.getType()), 
              Old.getReturnTypeSourceRange()));
          return true;
        } else {
          NewQType.$assign(ResQT);
        }
      }
      
      QualType OldReturnType = OldType.getReturnType();
      QualType NewReturnType = cast_FunctionType(NewQType).getReturnType();
      if ($noteq_QualType$C(OldReturnType, NewReturnType)) {
        // If this function has a deduced return type and has already been
        // defined, copy the deduced value from the old declaration.
        AutoType /*P*/ OldAT = Old.getReturnType().$arrow().getContainedAutoType();
        if ((OldAT != null) && OldAT.isDeduced()) {
          New.setType($this().SubstAutoType(New.getType(), 
                  OldAT.isDependentType() ? $this().Context.DependentTy.$QualType() : OldAT.getDeducedType()));
          NewQType.$assignMove($this().Context.getCanonicalType($this().SubstAutoType(new QualType(NewQType), 
                      OldAT.isDependentType() ? $this().Context.DependentTy.$QualType() : OldAT.getDeducedType())).$QualType());
        }
      }
      
      /*const*/ CXXMethodDecl /*P*/ OldMethod = dyn_cast_CXXMethodDecl(Old);
      CXXMethodDecl /*P*/ NewMethod = dyn_cast_CXXMethodDecl(New);
      if ((OldMethod != null) && (NewMethod != null)) {
        // Preserve triviality.
        NewMethod.setTrivial(OldMethod.isTrivial());
        
        // MSVC allows explicit template specialization at class scope:
        // 2 CXXMethodDecls referring to the same function will be injected.
        // We don't want a redeclaration error.
        boolean IsClassScopeExplicitSpecialization = OldMethod.isFunctionTemplateSpecialization()
           && NewMethod.isFunctionTemplateSpecialization();
        boolean isFriend = (NewMethod.getFriendObjectKind().getValue() != 0);
        if (!isFriend && NewMethod.getLexicalDeclContext().isRecord()
           && !IsClassScopeExplicitSpecialization) {
          //    -- Member function declarations with the same name and the
          //       same parameter types cannot be overloaded if any of them
          //       is a static member function declaration.
          if (OldMethod.isStatic() != NewMethod.isStatic()) {
            $c$.clean($c$.track($this().Diag(New.getLocation(), diag.err_ovl_static_nonstatic_member)));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OldLocation), PrevDiag)), Old), Old.getType()));
            return true;
          }
          
          // C++ [class.mem]p1:
          //   [...] A member shall not be declared twice in the
          //   member-specification, except that a nested class or member
          //   class template can be declared and then later defined.
          if ($this().ActiveTemplateInstantiations.empty()) {
            /*uint*/int NewDiag;
            if (isa_CXXConstructorDecl(OldMethod)) {
              NewDiag = diag.err_constructor_redeclared;
            } else if (isa_CXXDestructorDecl(NewMethod)) {
              NewDiag = diag.err_destructor_redeclared;
            } else if (isa_CXXConversionDecl(NewMethod)) {
              NewDiag = diag.err_conv_function_redeclared;
            } else {
              NewDiag = diag.err_member_redeclared;
            }
            
            $c$.clean($c$.track($this().Diag(New.getLocation(), NewDiag)));
          } else {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_member_redeclared_in_instantiation)), 
                    New), New.getType()));
          }
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OldLocation), PrevDiag)), Old), Old.getType()));
          return true;
          // Complain if this is an explicit declaration of a special
          // member that was initially declared implicitly.
          //
          // As an exception, it's okay to befriend such methods in order
          // to permit the implicit constructor/destructor/operator calls.
        } else if (OldMethod.isImplicit()) {
          if (isFriend) {
            NewMethod.setImplicit();
          } else {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewMethod.getLocation(), 
                        diag.err_definition_of_implicitly_declared_member)), 
                    New), $this().getSpecialMember(OldMethod)));
            return true;
          }
        } else if (OldMethod.getFirstDecl$Const().isExplicitlyDefaulted() && !isFriend) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewMethod.getLocation(), 
                  diag.err_definition_of_explicitly_defaulted_member)), 
              $this().getSpecialMember(OldMethod)));
          return true;
        }
      }
      
      // C++11 [dcl.attr.noreturn]p1:
      //   The first declaration of a function shall specify the noreturn
      //   attribute if any declaration of that function specifies the noreturn
      //   attribute.
      /*const*/ CXX11NoReturnAttr /*P*/ NRA = New.getAttr(CXX11NoReturnAttr.class);
      if ((NRA != null) && !Old.hasAttr(CXX11NoReturnAttr.class)) {
        $c$.clean($c$.track($this().Diag(NRA.getLocation(), diag.err_noreturn_missing_on_first_decl)));
        $c$.clean($c$.track($this().Diag(Old.getFirstDecl().getLocation(), 
            diag.note_noreturn_missing_first_decl)));
      }
      
      // C++11 [dcl.attr.depend]p2:
      //   The first declaration of a function shall specify the
      //   carries_dependency attribute for its declarator-id if any declaration
      //   of the function specifies the carries_dependency attribute.
      /*const*/ CarriesDependencyAttr /*P*/ CDA = New.getAttr(CarriesDependencyAttr.class);
      if ((CDA != null) && !Old.hasAttr(CarriesDependencyAttr.class)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(CDA.getLocation(), 
                diag.err_carries_dependency_missing_on_first_decl)), 0/*Function*/));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Old.getFirstDecl().getLocation(), 
                diag.note_carries_dependency_missing_first_decl)), 0/*Function*/));
      }
      
      // (C++98 8.3.5p3):
      //   All declarations for a function shall agree exactly in both the
      //   return type and the parameter-type-list.
      // We also want to respect all the extended bits except noreturn.
      
      // noreturn should now match unless the old type info didn't have it.
      QualType OldQTypeForComparison = new QualType(OldQType);
      if (!OldTypeInfo.getNoReturn() && NewTypeInfo.getNoReturn()) {
        assert ($eq_QualType$C(OldQType, new QualType(OldType, 0)));
        /*const*/ FunctionType /*P*/ OldTypeForComparison = $this().Context.adjustFunctionType(OldType, OldTypeInfo.withNoReturn(true));
        OldQTypeForComparison.$assignMove(new QualType(OldTypeForComparison, 0));
        assert (OldQTypeForComparison.isCanonical());
      }
      if (haveIncompatibleLanguageLinkages(Old, New)) {
        // As a special case, retain the language linkage from previous
        // declarations of a friend function as an extension.
        //
        // This liberal interpretation of C++ [class.friend]p3 matches GCC/MSVC
        // and is useful because there's otherwise no way to specify language
        // linkage within class scope.
        //
        // Check cautiously as the friend object kind isn't yet complete.
        if (New.getFriendObjectKind() != Decl.FriendObjectKind.FOK_None) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.ext_retained_language_linkage)), New));
          $c$.clean($c$.track($this().Diag(new SourceLocation(OldLocation), PrevDiag)));
        } else {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_different_language_linkage)), New));
          $c$.clean($c$.track($this().Diag(new SourceLocation(OldLocation), PrevDiag)));
          return true;
        }
      }
      if ($eq_QualType$C(OldQTypeForComparison, NewQType)) {
        return $this().MergeCompatibleFunctionDecls(New, Old, S, MergeTypeWithOld);
      }
      if ((NewQType.$arrow().isDependentType() || OldQType.$arrow().isDependentType())
         && New.isLocalExternDecl()) {
        // It's OK if we couldn't merge types for a local function declaraton
        // if either the old or new type is dependent. We'll merge the types
        // when we instantiate the function.
        return false;
      }
      // Fall through for conflicting redeclarations and redefinitions.
    }
    
    // C: Function types need to be compatible, not identical. This handles
    // duplicate function decls like "void f(int); void f(enum X);" properly.
    if (!$this().getLangOpts().CPlusPlus
       && $this().Context.typesAreCompatible(new QualType(OldQType), new QualType(NewQType))) {
      /*const*/ FunctionType /*P*/ OldFuncType = OldQType.$arrow().getAs(FunctionType.class);
      /*const*/ FunctionType /*P*/ NewFuncType = NewQType.$arrow().getAs(FunctionType.class);
      /*const*/ FunctionProtoType /*P*/ OldProto = null;
      if (MergeTypeWithOld && isa_FunctionNoProtoType(NewFuncType)
         && ((OldProto = dyn_cast_FunctionProtoType(OldFuncType)) != null)) {
        // The old declaration provided a function prototype, but the
        // new declaration does not. Merge in the prototype.
        assert (!OldProto.hasExceptionSpec()) : "Exception spec in C";
        SmallVector<QualType> ParamTypes/*J*/= new SmallVector<QualType>(16, OldProto.param_types().begin(), OldProto.param_types().end(), new QualType());
        NewQType.$assignMove(
            $this().Context.getFunctionType(NewFuncType.getReturnType(), new ArrayRef<QualType>(ParamTypes, false), 
                OldProto.getExtProtoInfo())
        );
        New.setType(new QualType(NewQType));
        New.setHasInheritedPrototype();
        
        // Synthesize parameters with the same types.
        SmallVector<ParmVarDecl /*P*/ > Params/*J*/= new SmallVector<ParmVarDecl /*P*/ >(16, (ParmVarDecl /*P*/ )null);
        for (final /*const*/ QualType /*&*/ ParamType : OldProto.param_types()) {
          ParmVarDecl /*P*/ Param = ParmVarDecl.Create($this().Context, New, new SourceLocation(), 
              new SourceLocation(), (IdentifierInfo /*P*/ )null, 
              new QualType(ParamType), /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
              StorageClass.SC_None, (Expr /*P*/ )null);
          Param.setScopeInfo(0, Params.size());
          Param.setImplicit();
          Params.push_back(Param);
        }
        
        New.setParams(new ArrayRef<ParmVarDecl /*P*/ >(Params, true));
      }
      
      return $this().MergeCompatibleFunctionDecls(New, Old, S, MergeTypeWithOld);
    }
    
    // GNU C permits a K&R definition to follow a prototype declaration
    // if the declared types of the parameters in the K&R definition
    // match the types in the prototype declaration, even when the
    // promoted types of the parameters from the K&R definition differ
    // from the types in the prototype. GCC then keeps the types from
    // the prototype.
    //
    // If a variadic prototype is followed by a non-variadic K&R definition,
    // the K&R definition becomes variadic.  This is sort of an edge case, but
    // it's legal per the standard depending on how you read C99 6.7.5.3p15 and
    // C99 6.9.1p8.
    if (!$this().getLangOpts().CPlusPlus
       && Old.hasPrototype() && !New.hasPrototype()
       && (New.getType().$arrow().getAs(FunctionProtoType.class) != null)
       && Old.getNumParams() == New.getNumParams()) {
      SmallVector<QualType> ArgTypes/*J*/= new SmallVector<QualType>(16, new QualType());
      SmallVector<GNUCompatibleParamWarning> Warnings/*J*/= new SmallVector<GNUCompatibleParamWarning>(16, new GNUCompatibleParamWarning());
      /*const*/ FunctionProtoType /*P*/ OldProto = Old.getType().$arrow().getAs(FunctionProtoType.class);
      /*const*/ FunctionProtoType /*P*/ NewProto = New.getType().$arrow().getAs(FunctionProtoType.class);
      
      // Determine whether this is the GNU C extension.
      QualType MergedReturn = $this().Context.mergeTypes(OldProto.getReturnType(), 
          NewProto.getReturnType());
      boolean LooseCompatible = !MergedReturn.isNull();
      for (/*uint*/int Idx = 0, End = Old.getNumParams();
           LooseCompatible && Idx != End; ++Idx) {
        ParmVarDecl /*P*/ OldParm = Old.getParamDecl(Idx);
        ParmVarDecl /*P*/ NewParm = New.getParamDecl(Idx);
        if ($this().Context.typesAreCompatible(OldParm.getType(), 
            NewProto.getParamType(Idx))) {
          ArgTypes.push_back(NewParm.getType());
        } else if ($this().Context.typesAreCompatible(OldParm.getType(), 
            NewParm.getType(), 
            /*CompareUnqualified=*/ true)) {
          GNUCompatibleParamWarning Warn = new GNUCompatibleParamWarning(
            OldParm, NewParm, 
            NewProto.getParamType(Idx));
          Warnings.push_back(Warn);
          ArgTypes.push_back(NewParm.getType());
        } else {
          LooseCompatible = false;
        }
      }
      if (LooseCompatible) {
        for (/*uint*/int Warn = 0; $less_uint(Warn, Warnings.size()); ++Warn) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Warnings.$at(Warn).NewParm.getLocation(), 
                      diag.ext_param_promoted_not_compatible_with_prototype)), 
                  Warnings.$at(Warn).PromotedType), 
              Warnings.$at(Warn).OldParm.getType()));
          if (Warnings.$at(Warn).OldParm.getLocation().isValid()) {
            $c$.clean($c$.track($this().Diag(Warnings.$at(Warn).OldParm.getLocation(), 
                diag.note_previous_declaration)));
          }
        }
        if (MergeTypeWithOld) {
          New.setType($this().Context.getFunctionType(new QualType(MergedReturn), new ArrayRef<QualType>(ArgTypes, false), 
                  OldProto.getExtProtoInfo()));
        }
        return $this().MergeCompatibleFunctionDecls(New, Old, S, MergeTypeWithOld);
      }
      // Fall through to diagnose conflicting types.
    }
    
    // A function that has already been declared has been redeclared or
    // defined with a different type; show an appropriate diagnostic.
    
    // If the previous declaration was an implicitly-generated builtin
    // declaration, then at the very least we should use a specialized note.
    /*uint*/int BuiltinID;
    if (Old.isImplicit() && ((BuiltinID = Old.getBuiltinID()) != 0)) {
      // If it's actually a library-defined builtin function like 'malloc'
      // or 'printf', just warn about the incompatible redeclaration.
      if ($this().Context.BuiltinInfo.isPredefinedLibFunction(BuiltinID)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.warn_redecl_library_builtin)), New));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OldLocation), diag.note_previous_builtin_declaration)), 
                Old), Old.getType()));
        
        // If this is a global redeclaration, just forget hereafter
        // about the "builtin-ness" of the function.
        //
        // Doing this for local extern declarations is problematic.  If
        // the builtin declaration remains visible, a second invalid
        // local declaration will produce a hard error; if it doesn't
        // remain visible, a single bogus local redeclaration (which is
        // actually only a warning) could break all the downstream code.
        if (!New.getLexicalDeclContext().isFunctionOrMethod()) {
          New.getIdentifier().revertBuiltin();
        }
        
        return false;
      }
      
      PrevDiag = diag.note_previous_builtin_declaration;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_conflicting_types)), New.getDeclName()));
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OldLocation), PrevDiag)), Old), Old.getType()));
    return true;
  } finally {
    $c$.$destroy();
  }
}


/// \brief Completes the merge of two function declarations that are
/// known to be compatible.
///
/// This routine handles the merging of attributes and other
/// properties of function declarations from the old declaration to
/// the new declaration, once we know that New is in fact a
/// redeclaration of Old.
///
/// \returns false
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MergeCompatibleFunctionDecls">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 3263,
 FQN="clang::Sema::MergeCompatibleFunctionDecls", NM="_ZN5clang4Sema28MergeCompatibleFunctionDeclsEPNS_12FunctionDeclES2_PNS_5ScopeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema28MergeCompatibleFunctionDeclsEPNS_12FunctionDeclES2_PNS_5ScopeEb")
//</editor-fold>
public final boolean MergeCompatibleFunctionDecls(FunctionDecl /*P*/ New, FunctionDecl /*P*/ Old, 
                            Scope /*P*/ S, boolean MergeTypeWithOld) {
  // Merge the attributes
  $this().mergeDeclAttributes(New, Old);
  
  // Merge "pure" flag.
  if (Old.isPure()) {
    New.setPure();
  }
  
  // Merge "used" flag.
  if (Old.getMostRecentDecl$Redeclarable().isUsed(false)) {
    New.setIsUsed();
  }
  
  // Merge attributes from the parameters.  These can mismatch with K&R
  // declarations.
  if (New.getNumParams() == Old.getNumParams()) {
    for (/*uint*/int i = 0, e = New.getNumParams(); i != e; ++i) {
      ParmVarDecl /*P*/ NewParam = New.getParamDecl(i);
      ParmVarDecl /*P*/ OldParam = Old.getParamDecl(i);
      mergeParamDeclAttributes(NewParam, OldParam, /*Deref*/$this());
      mergeParamDeclTypes(NewParam, OldParam, /*Deref*/$this());
    }
  }
  if ($this().getLangOpts().CPlusPlus) {
    return $this().MergeCXXFunctionDecl(New, Old, S);
  }
  
  // Merge the function types so the we get the composite types for the return
  // and argument types. Per C11 6.2.7/4, only update the type if the old decl
  // was visible.
  QualType Merged = $this().Context.mergeTypes(Old.getType(), New.getType());
  if (!Merged.isNull() && MergeTypeWithOld) {
    New.setType(new QualType(Merged));
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::mergeObjCMethodDecls">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 3299,
 FQN="clang::Sema::mergeObjCMethodDecls", NM="_ZN5clang4Sema20mergeObjCMethodDeclsEPNS_14ObjCMethodDeclES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema20mergeObjCMethodDeclsEPNS_14ObjCMethodDeclES2_")
//</editor-fold>
public final void mergeObjCMethodDecls(ObjCMethodDecl /*P*/ newMethod, 
                    ObjCMethodDecl /*P*/ oldMethod) {
  // Merge the attributes, including deprecated/unavailable
  AvailabilityMergeKind MergeKind = isa_ObjCProtocolDecl(oldMethod.getDeclContext()) ? AvailabilityMergeKind.AMK_ProtocolImplementation : isa_ObjCImplDecl(newMethod.getDeclContext()) ? AvailabilityMergeKind.AMK_Redeclaration : AvailabilityMergeKind.AMK_Override;
  
  $this().mergeDeclAttributes(newMethod, oldMethod, MergeKind);
  
  // Merge attributes from the parameters.
  type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/> oi = $tryClone(oldMethod.param_begin());
  type$ptr</*const*/ ParmVarDecl /*P*/ /*const*/ /*P*/> oe = $tryClone(oldMethod.param_end());
  for (type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/> ni = $tryClone(newMethod.param_begin()), /*P*/ /*const*/ /*P*/ ne = $tryClone(newMethod.param_end());
       $noteq_ptr(ni, ne) && $noteq_ptr(oi, oe); ni.$preInc() , oi.$preInc())  {
    mergeParamDeclAttributes(ni.$star(), oi.$star(), /*Deref*/$this());
  }
  
  $this().CheckObjCMethodOverride(newMethod, oldMethod);
}


/// MergeVarDecl - We just parsed a variable 'New' which has the same name
/// and scope as a previous declaration 'Old'.  Figure out how to resolve this
/// situation, merging decls or emitting diagnostics as appropriate.
///
/// Tentative definition rules (C99 6.9.2p2) are checked by
/// FinalizeDeclaratorGroup. Unfortunately, we can't analyze tentative
/// definitions here, since the initializer hasn't been attached.
///
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MergeVarDecl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*tie/make_pair*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 3468,
 FQN="clang::Sema::MergeVarDecl", NM="_ZN5clang4Sema12MergeVarDeclEPNS_7VarDeclERNS_12LookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema12MergeVarDeclEPNS_7VarDeclERNS_12LookupResultE")
//</editor-fold>
public final void MergeVarDecl(VarDecl /*P*/ New, final LookupResult /*&*/ Previous) {
  // If the new decl is already invalid, don't do any other checking.
  if (New.isInvalidDecl()) {
    return;
  }
  if (!$this().shouldLinkPossiblyHiddenDecl(Previous, New)) {
    return;
  }
  
  VarTemplateDecl /*P*/ NewTemplate = New.getDescribedVarTemplate();
  
  // Verify the old decl was also a variable or variable template.
  VarDecl /*P*/ Old = null;
  VarTemplateDecl /*P*/ OldTemplate = null;
  if (Previous.isSingleResult()) {
    if ((NewTemplate != null)) {
      OldTemplate = dyn_cast_VarTemplateDecl(Previous.getFoundDecl());
      Old = (OldTemplate != null) ? OldTemplate.getTemplatedDecl() : null;
      {
        
        UsingShadowDecl /*P*/ Shadow = dyn_cast_UsingShadowDecl(Previous.getRepresentativeDecl());
        if ((Shadow != null)) {
          if (checkUsingShadowRedecl(VarTemplateDecl.class, /*Deref*/$this(), Shadow, NewTemplate)) {
            New.setInvalidDecl();
            /*JAVA:return*/return;
          }
        }
      }
    } else {
      Old = dyn_cast_VarDecl(Previous.getFoundDecl());
      {
        
        UsingShadowDecl /*P*/ Shadow = dyn_cast_UsingShadowDecl(Previous.getRepresentativeDecl());
        if ((Shadow != null)) {
          if (checkUsingShadowRedecl(VarDecl.class, /*Deref*/$this(), Shadow, New)) {
            New.setInvalidDecl();
            /*JAVA:return*/return;
          }
        }
      }
    }
  }
  if (!(Old != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_redefinition_different_kind)), 
          New.getDeclName()));
      $c$.clean($c$.track($this().Diag(Previous.getRepresentativeDecl().getLocation(), 
          diag.note_previous_definition)));
      New.setInvalidDecl();
      /*JAVA:return*/return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Ensure the template parameters are compatible.
  if ((NewTemplate != null)
     && !$this().TemplateParameterListsAreEqual(NewTemplate.getTemplateParameters(), 
      OldTemplate.getTemplateParameters(), 
      /*Complain=*/ true, TemplateParameterListEqualKind.TPL_TemplateMatch)) {
    New.setInvalidDecl();
    /*JAVA:return*/return;
  }
  
  // C++ [class.mem]p1:
  //   A member shall not be declared twice in the member-specification [...]
  //
  // Here, we need only consider static data members.
  if (Old.isStaticDataMember() && !New.isOutOfLine()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_duplicate_member)), 
          New.getIdentifier()));
      $c$.clean($c$.track($this().Diag(Old.getLocation(), diag.note_previous_declaration)));
      New.setInvalidDecl();
    } finally {
      $c$.$destroy();
    }
  }
  
  $this().mergeDeclAttributes(New, Old);
  // Warn if an already-declared variable is made a weak_import in a subsequent
  // declaration
  if (New.hasAttr(WeakImportAttr.class)
     && Old.getStorageClass() == StorageClass.SC_None
     && !Old.hasAttr(WeakImportAttr.class)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.warn_weak_import)), New.getDeclName()));
      $c$.clean($c$.track($this().Diag(Old.getLocation(), diag.note_previous_definition)));
      // Remove weak_import attribute on new declaration.
      New.dropAttr(WeakImportAttr.class);
    } finally {
      $c$.$destroy();
    }
  }
  if (New.hasAttr(InternalLinkageAttr.class)
     && !Old.hasAttr(InternalLinkageAttr.class)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_internal_linkage_redeclaration)), 
          New.getDeclName()));
      $c$.clean($c$.track($this().Diag(Old.getLocation(), diag.note_previous_definition)));
      New.dropAttr(InternalLinkageAttr.class);
    } finally {
      $c$.$destroy();
    }
  }
  
  // Merge the types.
  VarDecl /*P*/ MostRecent = Old.getMostRecentDecl();
  if (MostRecent != Old) {
    $this().MergeVarDeclTypes(New, MostRecent, 
        mergeTypeWithPrevious(/*Deref*/$this(), New, MostRecent, Previous));
    if (New.isInvalidDecl()) {
      return;
    }
  }
  
  $this().MergeVarDeclTypes(New, Old, mergeTypeWithPrevious(/*Deref*/$this(), New, Old, Previous));
  if (New.isInvalidDecl()) {
    return;
  }
  
    // JAVA: unfold tie
//    std.tie_uint_type(PrevDiag, OldLocation).$assign(
    std.pairUIntType<SourceLocation> $pair = getNoteDiagForInvalidRedeclaration(Old, New);
    /*uint*/int PrevDiag = $pair.first;
    SourceLocation OldLocation/*J*/= new SourceLocation($pair.second);
    
  // [dcl.stc]p8: Check if we have a non-static decl followed by a static.
  if (New.getStorageClass() == StorageClass.SC_Static
     && !New.isStaticDataMember()
     && Old.hasExternalFormalLinkage()) {
    if ($this().getLangOpts().MicrosoftExt) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.ext_static_non_static)), 
            New.getDeclName()));
        $c$.clean($c$.track($this().Diag(new SourceLocation(OldLocation), PrevDiag)));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_static_non_static)), 
            New.getDeclName()));
        $c$.clean($c$.track($this().Diag(new SourceLocation(OldLocation), PrevDiag)));
        New.setInvalidDecl();
        /*JAVA:return*/return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  // C99 6.2.2p4:
  //   For an identifier declared with the storage-class specifier
  //   extern in a scope in which a prior declaration of that
  //   identifier is visible,23) if the prior declaration specifies
  //   internal or external linkage, the linkage of the identifier at
  //   the later declaration is the same as the linkage specified at
  //   the prior declaration. If no prior declaration is visible, or
  //   if the prior declaration specifies no linkage, then the
  //   identifier has external linkage.
  if (New.hasExternalStorage() && Old.hasLinkage()) {
/* Okay */     ;
  } else if (New.getCanonicalDecl().getStorageClass() != StorageClass.SC_Static
     && !New.isStaticDataMember()
     && Old.getCanonicalDecl().getStorageClass() == StorageClass.SC_Static) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_non_static_static)), New.getDeclName()));
      $c$.clean($c$.track($this().Diag(new SourceLocation(OldLocation), PrevDiag)));
      New.setInvalidDecl();
      /*JAVA:return*/return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Check if extern is followed by non-extern and vice-versa.
  if (New.hasExternalStorage()
     && !Old.hasLinkage() && Old.isLocalVarDeclOrParm()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_extern_non_extern)), New.getDeclName()));
      $c$.clean($c$.track($this().Diag(new SourceLocation(OldLocation), PrevDiag)));
      New.setInvalidDecl();
      /*JAVA:return*/return;
    } finally {
      $c$.$destroy();
    }
  }
  if (Old.hasLinkage() && New.isLocalVarDeclOrParm()
     && !New.hasExternalStorage()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_non_extern_extern)), New.getDeclName()));
      $c$.clean($c$.track($this().Diag(new SourceLocation(OldLocation), PrevDiag)));
      New.setInvalidDecl();
      /*JAVA:return*/return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Variables with external linkage are analyzed in FinalizeDeclaratorGroup.
  
  // FIXME: The test for external storage here seems wrong? We still
  // need to check for mismatches.
  if (!New.hasExternalStorage() && !New.isFileVarDecl()
    // Don't complain about out-of-line definitions of static members.
     && !(Old.getLexicalDeclContext().isRecord()
     && !New.getLexicalDeclContext().isRecord())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_redefinition)), New.getDeclName()));
      $c$.clean($c$.track($this().Diag(new SourceLocation(OldLocation), PrevDiag)));
      New.setInvalidDecl();
      /*JAVA:return*/return;
    } finally {
      $c$.$destroy();
    }
  }
  if (New.isInline() && !Old.getMostRecentDecl$Redeclarable().isInline()) {
    {
      VarDecl /*P*/ Def = Old.getDefinition();
      if ((Def != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C++1z [dcl.fcn.spec]p4:
          //   If the definition of a variable appears in a translation unit before
          //   its first declaration as inline, the program is ill-formed.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_inline_decl_follows_def)), New));
          $c$.clean($c$.track($this().Diag(Def.getLocation(), diag.note_previous_definition)));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // If this redeclaration makes the function inline, we may need to add it to
  // UndefinedButUsed.
  if (!Old.isInline() && New.isInline() && Old.isUsed(false)
     && !(Old.getDefinition() != null) && !(New.isThisDeclarationADefinition().getValue() != 0)) {
    $this().UndefinedButUsed.insert(new std.pairPtrType<NamedDecl /*P*/ , SourceLocation>(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/Old.getCanonicalDecl(), new SourceLocation(JD$Move.INSTANCE, /*Fwd*/new SourceLocation(JD$Move.INSTANCE, /*Fwd2*/new SourceLocation()))));
  }
  if (New.getTLSKind() != Old.getTLSKind()) {
    if (!(Old.getTLSKind().getValue() != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_thread_non_thread)), New.getDeclName()));
        $c$.clean($c$.track($this().Diag(new SourceLocation(OldLocation), PrevDiag)));
      } finally {
        $c$.$destroy();
      }
    } else if (!(New.getTLSKind().getValue() != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_non_thread_thread)), New.getDeclName()));
        $c$.clean($c$.track($this().Diag(new SourceLocation(OldLocation), PrevDiag)));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Do not allow redeclaration to change the variable between requiring
        // static and dynamic initialization.
        // FIXME: GCC allows this, but uses the TLS keyword on the first
        // declaration to determine the kind. Do we need to be compatible here?
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_thread_thread_different_kind)), 
                New.getDeclName()), (New.getTLSKind() == VarDecl.TLSKind.TLS_Dynamic)));
        $c$.clean($c$.track($this().Diag(new SourceLocation(OldLocation), PrevDiag)));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // C++ doesn't have tentative definitions, so go right ahead and check here.
  VarDecl /*P*/ Def;
  if ($this().getLangOpts().CPlusPlus
     && New.isThisDeclarationADefinition() == VarDecl.DefinitionKind.Definition
     && ((Def = Old.getDefinition()) != null)) {
    type$ptr<NamedDecl /*P*/ > Hidden = create_type$null$ptr(null);
    if (!$this().hasVisibleDefinition(Def, $AddrOf(Hidden))
       && (New.getFormalLinkage() == Linkage.InternalLinkage
       || (New.getDescribedVarTemplate() != null)
       || (New.getNumTemplateParameterLists() != 0)
       || New.getDeclContext().isDependentContext())) {
      // The previous definition is hidden, and multiple definitions are
      // permitted (in separate TUs). Form another definition of it.
    } else if (Old.isStaticDataMember()
       && Old.getCanonicalDecl().isInline()
       && Old.getCanonicalDecl().isConstexpr()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // This definition won't be a definition any more once it's been merged.
        $c$.clean($c$.track($this().Diag(New.getLocation(), 
            diag.warn_deprecated_redundant_constexpr_static_def)));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_redefinition)), New));
        $c$.clean($c$.track($this().Diag(Def.getLocation(), diag.note_previous_definition)));
        New.setInvalidDecl();
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (haveIncompatibleLanguageLinkages(Old, New)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_different_language_linkage)), New));
      $c$.clean($c$.track($this().Diag(new SourceLocation(OldLocation), PrevDiag)));
      New.setInvalidDecl();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Merge "used" flag.
  if (Old.getMostRecentDecl$Redeclarable().isUsed(false)) {
    New.setIsUsed();
  }
  
  // Keep a chain of previous declarations.
  New.setPreviousDecl(Old);
  if ((NewTemplate != null)) {
    NewTemplate.setPreviousDecl(OldTemplate);
  }
  
  // Inherit access appropriately.
  New.setAccess(Old.getAccess());
  if ((NewTemplate != null)) {
    NewTemplate.setAccess(New.getAccess());
  }
  if (Old.isInline()) {
    New.setImplicitlyInline();
  }
}


/// MergeVarDeclTypes - We parsed a variable 'New' which has the same name and
/// scope as a previous declaration 'Old'.  Figure out how to merge their types,
/// emitting diagnostics as appropriate.
///
/// Declarations using the auto type specifier (C++ [decl.spec.auto]) call back
/// to here in AddInitializerToDecl. We can't check them before the initializer
/// is attached.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MergeVarDeclTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 3344,
 FQN="clang::Sema::MergeVarDeclTypes", NM="_ZN5clang4Sema17MergeVarDeclTypesEPNS_7VarDeclES2_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema17MergeVarDeclTypesEPNS_7VarDeclES2_b")
//</editor-fold>
public final void MergeVarDeclTypes(VarDecl /*P*/ New, VarDecl /*P*/ Old, 
                 boolean MergeTypeWithOld) {
  if (New.isInvalidDecl() || Old.isInvalidDecl()) {
    return;
  }
  
  QualType MergedT/*J*/= new QualType();
  if ($this().getLangOpts().CPlusPlus) {
    if (New.getType().$arrow().isUndeducedType()) {
      // We don't know what the new type is until the initializer is attached.
      return;
    } else if ($this().Context.hasSameType(New.getType(), Old.getType())) {
      // These could still be something that needs exception specs checked.
      $this().MergeVarDeclExceptionSpecs(New, Old);
      /*JAVA:return*/return;
    } else // C++ [basic.link]p10:
    //   [...] the types specified by all declarations referring to a given
    //   object or function shall be identical, except that declarations for an
    //   array object can specify array types that differ by the presence or
    //   absence of a major array bound (8.3.4).
    if (Old.getType().$arrow().isArrayType() && New.getType().$arrow().isArrayType()) {
      /*const*/ ArrayType /*P*/ OldArray = $this().Context.getAsArrayType(Old.getType());
      /*const*/ ArrayType /*P*/ NewArray = $this().Context.getAsArrayType(New.getType());
      
      // We are merging a variable declaration New into Old. If it has an array
      // bound, and that bound differs from Old's bound, we should diagnose the
      // mismatch.
      if (!NewArray.isIncompleteArrayType()) {
        for (VarDecl /*P*/ PrevVD = Old.getMostRecentDecl$Redeclarable(); (PrevVD != null);
             PrevVD = PrevVD.getPreviousDecl$Redeclarable()) {
          /*const*/ ArrayType /*P*/ PrevVDTy = $this().Context.getAsArrayType(PrevVD.getType());
          if (PrevVDTy.isIncompleteArrayType()) {
            continue;
          }
          if (!$this().Context.hasSameType(NewArray, PrevVDTy)) {
            SemaDeclStatics.diagnoseVarDeclTypeMismatch(/*Deref*/$this(), New, PrevVD);
            /*JAVA:return*/return;
          }
        }
      }
      if (OldArray.isIncompleteArrayType() && NewArray.isArrayType()) {
        if ($this().Context.hasSameType(OldArray.getElementType(), 
            NewArray.getElementType())) {
          MergedT.$assignMove(New.getType());
        }
      } else // FIXME: Check visibility. New is hidden but has a complete type. If New
      // has no array bound, it should not inherit one from Old, if Old is not
      // visible.
      if (OldArray.isArrayType() && NewArray.isIncompleteArrayType()) {
        if ($this().Context.hasSameType(OldArray.getElementType(), 
            NewArray.getElementType())) {
          MergedT.$assignMove(Old.getType());
        }
      }
    } else if (New.getType().$arrow().isObjCObjectPointerType()
       && Old.getType().$arrow().isObjCObjectPointerType()) {
      MergedT.$assignMove($this().Context.mergeObjCGCQualifiers(New.getType(), 
              Old.getType()));
    }
  } else {
    // C 6.2.7p2:
    //   All declarations that refer to the same object or function shall have
    //   compatible type.
    MergedT.$assignMove($this().Context.mergeTypes(New.getType(), Old.getType()));
  }
  if (MergedT.isNull()) {
    // It's OK if we couldn't merge types if either type is dependent, for a
    // block-scope variable. In other cases (static data members of class
    // templates, variable templates, ...), we require the types to be
    // equivalent.
    // FIXME: The C++ standard doesn't say anything about this.
    if ((New.getType().$arrow().isDependentType()
       || Old.getType().$arrow().isDependentType()) && New.isLocalVarDecl()) {
      // If the old type was dependent, we can't merge with it, so the new type
      // becomes dependent for now. We'll reproduce the original type when we
      // instantiate the TypeSourceInfo for the variable.
      if (!New.getType().$arrow().isDependentType() && MergeTypeWithOld) {
        New.setType($this().Context.DependentTy.$QualType());
      }
      return;
    }
    SemaDeclStatics.diagnoseVarDeclTypeMismatch(/*Deref*/$this(), New, Old);
    /*JAVA:return*/return;
  }
  
  // Don't actually update the type on the new declaration if the old
  // declaration was an extern declaration in a different scope.
  if (MergeTypeWithOld) {
    New.setType(new QualType(MergedT));
  }
}


/// getNonFieldDeclScope - Retrieves the innermost scope, starting
/// from S, where a non-field would be declared. This routine copes
/// with the difference between C and C++ scoping rules in structs and
/// unions. For example, the following code is well-formed in C but
/// ill-formed in C++:
/// @code
/// struct S6 {
///   enum { BAR } e;
/// };
///
/// void test_S6() {
///   struct S6 a;
///   a.e = BAR;
/// }
/// @endcode
/// For the declaration of BAR, this routine will return a different
/// scope. The scope S will be the scope of the unnamed enumeration
/// within S6. In C++, this routine will return the scope associated
/// with S6, because the enumeration's scope is a transparent
/// context but structures can contain non-field names. In C, this
/// routine will return the translation unit scope, since the
/// enumeration's scope is a transparent context and structures cannot
/// contain non-field names.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getNonFieldDeclScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1736,
 FQN="clang::Sema::getNonFieldDeclScope", NM="_ZN5clang4Sema20getNonFieldDeclScopeEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema20getNonFieldDeclScopeEPNS_5ScopeE")
//</editor-fold>
public final Scope /*P*/ getNonFieldDeclScope(Scope /*P*/ S) {
  while (((S.getFlags() & Scope.ScopeFlags.DeclScope) == 0)
     || ((S.getEntity() != null) && S.getEntity().isTransparentContext())
     || (S.isClassScope() && !$this().getLangOpts().CPlusPlus)) {
    S = S.getParent();
  }
  return S;
}


/// Filters out lookup results that don't fall within the given scope
/// as determined by isDeclInScope.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FilterLookupForScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1331,
 FQN="clang::Sema::FilterLookupForScope", NM="_ZN5clang4Sema20FilterLookupForScopeERNS_12LookupResultEPNS_11DeclContextEPNS_5ScopeEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema20FilterLookupForScopeERNS_12LookupResultEPNS_11DeclContextEPNS_5ScopeEbb")
//</editor-fold>
public final void FilterLookupForScope(final LookupResult /*&*/ R, DeclContext /*P*/ Ctx, Scope /*P*/ S, 
                    boolean ConsiderLinkage, 
                    boolean AllowInlineNamespace) {
  LookupResult.Filter F = null;
  try {
    F = R.makeFilter();
    while (F.hasNext()) {
      NamedDecl /*P*/ D = F.next();
      if ($this().isDeclInScope(D, Ctx, S, AllowInlineNamespace)) {
        continue;
      }
      if (ConsiderLinkage && isOutOfScopePreviousDeclaration(D, Ctx, $this().Context)) {
        continue;
      }
      
      F.erase();
    }
    
    F.done();
  } finally {
    if (F != null) { F.$destroy(); }
  }
}

//@}

/// \brief Look for an Objective-C class in the translation unit.
///
/// \param Id The name of the Objective-C class we're looking for. If
/// typo-correction fixes this name, the Id will be updated
/// to the fixed name.
///
/// \param IdLoc The location of the name in the translation unit.
///
/// \param DoTypoCorrection If true, this routine will attempt typo correction
/// if there is no class with the given name.
///
/// \returns The declaration of the named Objective-C class, or NULL if the
/// class could not be found.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getObjCInterfaceDecl">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1687,
 FQN="clang::Sema::getObjCInterfaceDecl", NM="_ZN5clang4Sema20getObjCInterfaceDeclERPNS_14IdentifierInfoENS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema20getObjCInterfaceDeclERPNS_14IdentifierInfoENS_14SourceLocationEb")
//</editor-fold>
public final ObjCInterfaceDecl /*P*/ getObjCInterfaceDecl(final type$ref<IdentifierInfo /*P*/ /*&*/> Id, 
                    SourceLocation IdLoc) {
  return getObjCInterfaceDecl(Id, 
                    IdLoc, 
                    false);
}
public final ObjCInterfaceDecl /*P*/ getObjCInterfaceDecl(final type$ref<IdentifierInfo /*P*/ /*&*/> Id, 
                    SourceLocation IdLoc, 
                    boolean DoTypoCorrection/*= false*/) {
  // The third "scope" argument is 0 since we aren't enabling lazy built-in
  // creation from this context.
  NamedDecl /*P*/ IDecl = $this().LookupSingleName($this().TUScope, new DeclarationName(Id.$deref()), new SourceLocation(IdLoc), LookupNameKind.LookupOrdinaryName);
  if (!(IDecl != null) && DoTypoCorrection) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      {
        TypoCorrection C = null;
        try {
          // Perform typo correction at the given location, but only if we
          // find an Objective-C class name.
          C = $c$.clean($this().CorrectTypo(new DeclarationNameInfo(new DeclarationName(Id.$deref()), new SourceLocation(IdLoc)), LookupNameKind.LookupOrdinaryName, $this().TUScope, (CXXScopeSpec /*P*/ )null, 
              $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new DeclFilterCCC<ObjCInterfaceDecl>(ObjCInterfaceDecl.class))))), 
              CorrectTypoKind.CTK_ErrorRecovery));
          if (C.$bool()) {
            $this().diagnoseTypo(C, $out_PartialDiagnostic$C_IdentifierInfo$C$P($c$.track($this().PDiag(diag.err_undef_interface_suggest)), Id.$deref())); $c$.clean();
            IDecl = C.getCorrectionDeclAs(ObjCInterfaceDecl.class);
            Id.$set(IDecl.getIdentifier());
          }
        } finally {
          if (C != null) { C.$destroy(); }
        }
      }
    } finally {
      $c$.$destroy();
    }
  }
  ObjCInterfaceDecl /*P*/ Def = dyn_cast_or_null_ObjCInterfaceDecl(IDecl);
  // This routine must always return a class definition, if any.
  if ((Def != null) && (Def.getDefinition() != null)) {
    Def = Def.getDefinition();
  }
  return Def;
}


/// LazilyCreateBuiltin - The specified Builtin-ID was first used at
/// file scope.  lazily create a decl for it. ForRedeclaration is true
/// if we're creating this built-in in anticipation of redeclaring the
/// built-in.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LazilyCreateBuiltin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1780,
 FQN="clang::Sema::LazilyCreateBuiltin", NM="_ZN5clang4Sema19LazilyCreateBuiltinEPNS_14IdentifierInfoEjPNS_5ScopeEbNS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema19LazilyCreateBuiltinEPNS_14IdentifierInfoEjPNS_5ScopeEbNS_14SourceLocationE")
//</editor-fold>
public final NamedDecl /*P*/ LazilyCreateBuiltin(IdentifierInfo /*P*/ II, /*uint*/int ID, 
                   Scope /*P*/ S, boolean ForRedeclaration, 
                   SourceLocation Loc) {
  LookupPredefedObjCSuperType(/*Deref*/$this(), S, II);
  
  type$ref<ASTContext.GetBuiltinTypeError> Error = create_type$null$ref();
  QualType R = $this().Context.GetBuiltinType(ID, Error);
  if ((Error.$deref().getValue() != 0)) {
    if (ForRedeclaration) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_implicit_decl_requires_sysheader)), 
                getHeaderName(Error.$deref())), $this().Context.BuiltinInfo.getName(ID)));
      } finally {
        $c$.$destroy();
      }
    }
    return null;
  }
  if (!ForRedeclaration && $this().Context.BuiltinInfo.isPredefinedLibFunction(ID)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.ext_implicit_lib_function_decl)), 
              $this().Context.BuiltinInfo.getName(ID)), R));
      if (Native.$bool($this().Context.BuiltinInfo.getHeaderName(ID))
         && !$this().Diags.isIgnored(diag.ext_implicit_lib_function_decl, /*NO_COPY*/Loc)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.note_include_header_or_declare)), 
                $this().Context.BuiltinInfo.getHeaderName(ID)), 
            $this().Context.BuiltinInfo.getName(ID)));
      }
    } finally {
      $c$.$destroy();
    }
  }
  if (R.isNull()) {
    return null;
  }
  
  DeclContext /*P*/ Parent = $this().Context.getTranslationUnitDecl();
  if ($this().getLangOpts().CPlusPlus) {
    LinkageSpecDecl /*P*/ CLinkageDecl = LinkageSpecDecl.Create($this().Context, Parent, new SourceLocation(Loc), new SourceLocation(Loc), 
        LinkageSpecDecl.LanguageIDs.lang_c, false);
    CLinkageDecl.setImplicit();
    Parent.addDecl(CLinkageDecl);
    Parent = CLinkageDecl;
  }
  
  FunctionDecl /*P*/ New = FunctionDecl.Create($this().Context, 
      Parent, 
      new SourceLocation(Loc), new SourceLocation(Loc), new DeclarationName(II), new QualType(R), /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
      StorageClass.SC_Extern, 
      false, 
      R.$arrow().isFunctionProtoType());
  New.setImplicit();
  {
    
    // Create Decl objects for each parameter, adding them to the
    // FunctionDecl.
    /*const*/ FunctionProtoType /*P*/ FT = dyn_cast_FunctionProtoType(R);
    if ((FT != null)) {
      SmallVector<ParmVarDecl /*P*/ > Params/*J*/= new SmallVector<ParmVarDecl /*P*/ >(16, (ParmVarDecl /*P*/ )null);
      for (/*uint*/int i = 0, e = FT.getNumParams(); i != e; ++i) {
        ParmVarDecl /*P*/ parm = ParmVarDecl.Create($this().Context, New, new SourceLocation(), new SourceLocation(), 
            (IdentifierInfo /*P*/ )null, FT.getParamType(i), /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
            StorageClass.SC_None, (Expr /*P*/ )null);
        parm.setScopeInfo(0, i);
        Params.push_back(parm);
      }
      New.setParams(new ArrayRef<ParmVarDecl /*P*/ >(Params, true));
    }
  }
  
  $this().AddKnownFunctionAttributes(New);
  $this().RegisterLocallyScopedExternCDecl(New, S);
  
  // TUScope is the translation-unit scope to insert this function into.
  // FIXME: This is hideous. We need to teach PushOnScopeChains to
  // relate Scopes to DeclContexts, and probably eliminate CurContext
  // entirely, but we're not there yet.
  DeclContext /*P*/ SavedContext = $this().CurContext;
  $this().CurContext = Parent;
  $this().PushOnScopeChains(New, $this().TUScope);
  $this().CurContext = SavedContext;
  return New;
}


/// ImplicitlyDefineFunction - An undeclared identifier was used in a function
/// call, forming a call to an implicitly defined function (per C99 6.5.1p2).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ImplicitlyDefineFunction">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 11732,
 FQN="clang::Sema::ImplicitlyDefineFunction", NM="_ZN5clang4Sema24ImplicitlyDefineFunctionENS_14SourceLocationERNS_14IdentifierInfoEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema24ImplicitlyDefineFunctionENS_14SourceLocationERNS_14IdentifierInfoEPNS_5ScopeE")
//</editor-fold>
public final NamedDecl /*P*/ ImplicitlyDefineFunction(SourceLocation Loc, 
                        final IdentifierInfo /*&*/ II, Scope /*P*/ S) {
  AttributeFactory attrFactory = null;
  DeclSpec DS = null;
  Declarator D = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    {
      // Before we produce a declaration for an implicitly defined
      // function, see whether there was a locally-scoped declaration of
      // this name as a function or variable. If so, use that
      // (non-visible) declaration, and complain about it.
      NamedDecl /*P*/ ExternCPrev = $this().findLocallyScopedExternCDecl(new DeclarationName($AddrOf(II)));
      if ((ExternCPrev != null)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_use_out_of_scope_declaration)), ExternCPrev));
        $c$.clean($c$.track($this().Diag(ExternCPrev.getLocation(), diag.note_previous_declaration)));
        return ExternCPrev;
      }
    }
    
    // Extension in C99.  Legal in C90, but warn about it.
    /*uint*/int diag_id;
    if (II.getName().startswith(/*STRINGREF_STR*/"__builtin_")) {
      diag_id = diag.warn_builtin_unknown;
    } else if ($this().getLangOpts().C99) {
      diag_id = diag.ext_implicit_function_decl;
    } else {
      diag_id = diag.warn_implicit_function_decl;
    }
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag_id)), $AddrOf(II)));
    
    // Because typo correction is expensive, only do it if the implicit
    // function declaration is going to be treated as an error.
    if ($this().Diags.getDiagnosticLevel(diag_id, /*NO_COPY*/Loc).getValue() >= DiagnosticsEngine.Level.Error.getValue()) {
      TypoCorrection Corrected = null;
      try {
        Corrected/*J*/= new TypoCorrection();
        if ($c$.clean((S != null)
           && (Corrected.$assignMove($c$.track($this().CorrectTypo(new DeclarationNameInfo(new DeclarationName($AddrOf(II)), new SourceLocation(Loc)), LookupNameKind.LookupOrdinaryName, S, (CXXScopeSpec /*P*/ )null, 
                $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new DeclFilterCCC<FunctionDecl>(FunctionDecl.class))))), CorrectTypoKind.CTK_NonError)))).$bool())) {
          $this().diagnoseTypo(Corrected, $c$.track($this().PDiag(diag.note_function_suggestion)), 
              /*ErrorRecovery*/ false); $c$.clean();
        }
      } finally {
        if (Corrected != null) { Corrected.$destroy(); }
      }
    }
    
    // Set a Declarator for the implicit definition: int foo();
    /*const*/char$ptr/*char P*/ Dummy = create_char$ptr();
    attrFactory/*J*/= new AttributeFactory();
    DS/*J*/= new DeclSpec(attrFactory);
    uint$ref DiagID = create_uint$ref();
    boolean Error = DS.SetTypeSpecType(DeclSpec.TST_int, new SourceLocation(Loc), Dummy, DiagID, 
        $this().Context.getPrintingPolicy());
    ///*J:(void)*/Error; // Silence warning.
    assert (!Error) : "Error setting up implicit decl!";
    SourceLocation NoLoc/*J*/= new SourceLocation();
    D/*J*/= new Declarator(DS, Declarator.TheContext.BlockContext);
    D.AddTypeInfo(DeclaratorChunk.getFunction(/*HasProto=*/ false, 
            /*IsAmbiguous=*/ false, 
            /*LParenLoc=*/ new SourceLocation(NoLoc), 
            /*Params=*/ (type$ptr<ParamInfo> /*P*/ )null, // probably create_null$ptr()... but NumParams == 0
            /*NumParams=*/ 0, 
            /*EllipsisLoc=*/ new SourceLocation(NoLoc), 
            /*RParenLoc=*/ new SourceLocation(NoLoc), 
            /*TypeQuals=*/ 0, 
            /*RefQualifierIsLvalueRef=*/ true, 
            /*RefQualifierLoc=*/ new SourceLocation(NoLoc), 
            /*ConstQualifierLoc=*/ new SourceLocation(NoLoc), 
            /*VolatileQualifierLoc=*/ new SourceLocation(NoLoc), 
            /*RestrictQualifierLoc=*/ new SourceLocation(NoLoc), 
            /*MutableLoc=*/ new SourceLocation(NoLoc), 
            ExceptionSpecificationType.EST_None, 
            /*ESpecRange=*/ new SourceRange(), 
            /*Exceptions=*/ (type$ptr<OpaquePtr<QualType>> /*P*/ )null, 
            /*ExceptionRanges=*/ (type$ptr<SourceRange> /*P*/ )null, 
            /*NumExceptions=*/ 0, 
            /*NoexceptExpr=*/ (Expr /*P*/ )null, 
            /*ExceptionSpecTokens=*/ (SmallVectorToken /*P*/)null, 
            new SourceLocation(Loc), new SourceLocation(Loc), D), 
        DS.getAttributes(), 
        new SourceLocation());
    D.SetIdentifier($AddrOf(II), new SourceLocation(Loc));
    
    // Insert this function into translation-unit scope.
    DeclContext /*P*/ PrevDC = $this().CurContext;
    $this().CurContext = $this().Context.getTranslationUnitDecl();
    
    FunctionDecl /*P*/ FD = cast_FunctionDecl($this().ActOnDeclarator($this().TUScope, D));
    FD.setImplicit();
    
    $this().CurContext = PrevDC;
    
    $this().AddKnownFunctionAttributes(FD);
    
    return FD;
  } finally {
    if (D != null) { D.$destroy(); }
    if (DS != null) { DS.$destroy(); }
    if (attrFactory != null) { attrFactory.$destroy(); }
    $c$.$destroy();
  }
}


/// \brief Adds any function attributes that we know a priori based on
/// the declaration of this function.
///
/// These attributes can apply both to implicitly-declared builtins
/// (like __builtin___printf_chk) or to library-declared functions
/// like NSLog or printf.
///
/// We need to check for duplicate attributes both here and where user-written
/// attributes are applied to declarations.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddKnownFunctionAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 11827,
 FQN="clang::Sema::AddKnownFunctionAttributes", NM="_ZN5clang4Sema26AddKnownFunctionAttributesEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema26AddKnownFunctionAttributesEPNS_12FunctionDeclE")
//</editor-fold>
public final void AddKnownFunctionAttributes(FunctionDecl /*P*/ FD) {
  if (FD.isInvalidDecl()) {
    return;
  }
  {
    
    // If this is a built-in function, map its builtin attributes to
    // actual attributes.
    /*uint*/int BuiltinID = FD.getBuiltinID();
    if ((BuiltinID != 0)) {
      // Handle printf-formatting attributes.
      uint$ref FormatIdx = create_uint$ref();
      bool$ref HasVAListArg = create_bool$ref();
      if ($this().Context.BuiltinInfo.isPrintfLike(BuiltinID, FormatIdx, HasVAListArg)) {
        if (!FD.hasAttr(FormatAttr.class)) {
          /*const*/char$ptr/*char P*/ fmt = $("printf");
          /*uint*/int NumParams = FD.getNumParams();
          if ($less_uint(FormatIdx.$deref(), NumParams) // NumParams may be 0 (e.g. vfprintf)
             && FD.getParamDecl(FormatIdx.$deref()).getType().$arrow().isObjCObjectPointerType()) {
            fmt = $("NSString");
          }
          FD.addAttr(FormatAttr.CreateImplicit($this().Context, 
                  $AddrOf($this().Context.Idents.get(new StringRef(fmt))), 
                  FormatIdx.$deref() + 1, 
                  HasVAListArg.$deref() ? 0 : FormatIdx.$deref() + 2, 
                  new SourceRange(FD.getLocation())));
        }
      }
      if ($this().Context.BuiltinInfo.isScanfLike(BuiltinID, FormatIdx, 
          HasVAListArg)) {
        if (!FD.hasAttr(FormatAttr.class)) {
          FD.addAttr(FormatAttr.CreateImplicit($this().Context, 
                  $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"scanf"))), 
                  FormatIdx.$deref() + 1, 
                  HasVAListArg.$deref() ? 0 : FormatIdx.$deref() + 2, 
                  new SourceRange(FD.getLocation())));
        }
      }
      
      // Mark const if we don't care about errno and that is the only
      // thing preventing the function from being const. This allows
      // IRgen to use LLVM intrinsics for such functions.
      if (!$this().getLangOpts().MathErrno
         && $this().Context.BuiltinInfo.isConstWithoutErrno(BuiltinID)) {
        if (!FD.hasAttr(ConstAttr.class)) {
          FD.addAttr(ConstAttr.CreateImplicit($this().Context, new SourceRange(FD.getLocation())));
        }
      }
      if ($this().Context.BuiltinInfo.isReturnsTwice(BuiltinID)
         && !FD.hasAttr(ReturnsTwiceAttr.class)) {
        FD.addAttr(ReturnsTwiceAttr.CreateImplicit($this().Context, 
                new SourceRange(FD.getLocation())));
      }
      if ($this().Context.BuiltinInfo.isNoThrow(BuiltinID) && !FD.hasAttr(NoThrowAttr.class)) {
        FD.addAttr(NoThrowAttr.CreateImplicit($this().Context, new SourceRange(FD.getLocation())));
      }
      if ($this().Context.BuiltinInfo.isPure(BuiltinID) && !FD.hasAttr(PureAttr.class)) {
        FD.addAttr(PureAttr.CreateImplicit($this().Context, new SourceRange(FD.getLocation())));
      }
      if ($this().Context.BuiltinInfo.isConst(BuiltinID) && !FD.hasAttr(ConstAttr.class)) {
        FD.addAttr(ConstAttr.CreateImplicit($this().Context, new SourceRange(FD.getLocation())));
      }
      if ($this().getLangOpts().CUDA && $this().Context.BuiltinInfo.isTSBuiltin(BuiltinID)
         && !FD.hasAttr(CUDADeviceAttr.class) && !FD.hasAttr(CUDAHostAttr.class)) {
        // Add the appropriate attribute, depending on the CUDA compilation mode
        // and which target the builtin belongs to. For example, during host
        // compilation, aux builtins are __device__, while the rest are __host__.
        if ($this().getLangOpts().CUDAIsDevice
           != $this().Context.BuiltinInfo.isAuxBuiltinID(BuiltinID)) {
          FD.addAttr(CUDADeviceAttr.CreateImplicit($this().Context, new SourceRange(FD.getLocation())));
        } else {
          FD.addAttr(CUDAHostAttr.CreateImplicit($this().Context, new SourceRange(FD.getLocation())));
        }
      }
    }
  }
  
  // If C++ exceptions are enabled but we are told extern "C" functions cannot
  // throw, add an implicit nothrow attribute to any extern "C" function we come
  // across.
  if ($this().getLangOpts().CXXExceptions && $this().getLangOpts().ExternCNoUnwind
     && FD.isExternC() && !FD.hasAttr(NoThrowAttr.class)) {
    /*const*/ FunctionProtoType /*P*/ FPT = FD.getType().$arrow().getAs(FunctionProtoType.class);
    if (!(FPT != null) || FPT.getExceptionSpecType() == ExceptionSpecificationType.EST_None) {
      FD.addAttr(NoThrowAttr.CreateImplicit($this().Context, new SourceRange(FD.getLocation())));
    }
  }
  
  IdentifierInfo /*P*/ Name = FD.getIdentifier();
  if (!(Name != null)) {
    return;
  }
  if ((!$this().getLangOpts().CPlusPlus
     && FD.getDeclContext().isTranslationUnit())
     || (isa_LinkageSpecDecl(FD.getDeclContext())
     && cast_LinkageSpecDecl(FD.getDeclContext()).getLanguage()
     == LinkageSpecDecl.LanguageIDs.lang_c)) {
    // Okay: this could be a libc/libm/Objective-C function we know
    // about.
  } else {
    return;
  }
  if (Name.isStr(/*KEEP_STR*/"asprintf") || Name.isStr(/*KEEP_STR*/"vasprintf")) {
    // FIXME: asprintf and vasprintf aren't C99 functions. Should they be
    // target-specific builtins, perhaps?
    if (!FD.hasAttr(FormatAttr.class)) {
      FD.addAttr(FormatAttr.CreateImplicit($this().Context, 
              $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"printf"))), 2, 
              Name.isStr(/*KEEP_STR*/"vasprintf") ? 0 : 3, 
              new SourceRange(FD.getLocation())));
    }
  }
  if (Name.isStr(/*KEEP_STR*/"__CFStringMakeConstantString")) {
    // We already have a __builtin___CFStringMakeConstantString,
    // but builds that use -fno-constant-cfstrings don't go through that.
    if (!FD.hasAttr(FormatArgAttr.class)) {
      FD.addAttr(FormatArgAttr.CreateImplicit($this().Context, 1, 
              new SourceRange(FD.getLocation())));
    }
  }
}


/// Get the outermost AttributedType node that sets a calling convention.
/// Valid types should not have multiple attributes with different CCs.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getCallingConvAttributedType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 2650,
 FQN="clang::Sema::getCallingConvAttributedType", NM="_ZNK5clang4Sema28getCallingConvAttributedTypeENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZNK5clang4Sema28getCallingConvAttributedTypeENS_8QualTypeE")
//</editor-fold>
public final /*const*/ AttributedType /*P*/ getCallingConvAttributedType(QualType T) /*const*/ {
  /*const*/ AttributedType /*P*/ AT = T.$arrow().getAs$AttributedType();
  while ((AT != null) && !AT.isCallingConv()) {
    AT = AT.getModifiedType().$arrow().getAs$AttributedType();
  }
  return AT;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ShouldWarnIfUnusedFileScopedDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1419,
 FQN="clang::Sema::ShouldWarnIfUnusedFileScopedDecl", NM="_ZNK5clang4Sema32ShouldWarnIfUnusedFileScopedDeclEPKNS_14DeclaratorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZNK5clang4Sema32ShouldWarnIfUnusedFileScopedDeclEPKNS_14DeclaratorDeclE")
//</editor-fold>
public final boolean ShouldWarnIfUnusedFileScopedDecl(/*const*/ DeclaratorDecl /*P*/ D) /*const*/ {
  assert Native.$bool(D);
  if (D.isInvalidDecl() || D.isUsed() || D.hasAttr(UnusedAttr.class)) {
    return false;
  }
  
  // Ignore all entities declared within templates, and out-of-line definitions
  // of members of class templates.
  if (D.getDeclContext$Const().isDependentContext()
     || D.getLexicalDeclContext$Const().isDependentContext()) {
    return false;
  }
  {
    
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
    if ((FD != null)) {
      if (FD.getTemplateSpecializationKind() == TemplateSpecializationKind.TSK_ImplicitInstantiation) {
        return false;
      }
      {
        
        /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(FD);
        if ((MD != null)) {
          if (MD.isVirtual() || IsDisallowedCopyOrAssign(MD)) {
            return false;
          }
        } else {
          // 'static inline' functions are defined in headers; don't warn.
          if (FD.isInlined() && !isMainFileLoc(/*Deref*/$this(), FD.getLocation())) {
            return false;
          }
        }
      }
      if (FD.doesThisDeclarationHaveABody()
         && $this().Context.DeclMustBeEmitted(FD)) {
        return false;
      }
    } else {
      /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
      if ((VD != null)) {
        // Constants and utility variables are defined in headers with internal
        // linkage; don't warn.  (Unlike functions, there isn't a convenient marker
        // like "inline".)
        if (!isMainFileLoc(/*Deref*/$this(), VD.getLocation())) {
          return false;
        }
        if ($this().Context.DeclMustBeEmitted(VD)) {
          return false;
        }
        if (VD.isStaticDataMember()
           && VD.getTemplateSpecializationKind() == TemplateSpecializationKind.TSK_ImplicitInstantiation) {
          return false;
        }
        if (VD.isInline() && !isMainFileLoc(/*Deref*/$this(), VD.getLocation())) {
          return false;
        }
      } else {
        return false;
      }
    }
  }
  
  // Only warn for unused decls internal to the translation unit.
  // FIXME: This seems like a bogus check; it suppresses -Wunused-function
  // for inline functions defined in the main source file, for instance.
  return mightHaveNonExternalLinkage(D);
}


/// \brief If it's a file scoped decl that must warn if not used, keep track
/// of it.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MarkUnusedFileScopedDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1473,
 FQN="clang::Sema::MarkUnusedFileScopedDecl", NM="_ZN5clang4Sema24MarkUnusedFileScopedDeclEPKNS_14DeclaratorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema24MarkUnusedFileScopedDeclEPKNS_14DeclaratorDeclE")
//</editor-fold>
public final void MarkUnusedFileScopedDecl(/*const*/ DeclaratorDecl /*P*/ D) {
  if (!(D != null)) {
    return;
  }
  {
    
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
    if ((FD != null)) {
      /*const*/ FunctionDecl /*P*/ First = FD.getFirstDecl$Const();
      if (FD != First && $this().ShouldWarnIfUnusedFileScopedDecl(First)) {
        return; // First should already be in the vector.
      }
    }
  }
  {
    
    /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    if ((VD != null)) {
      /*const*/ VarDecl /*P*/ First = VD.getFirstDecl$Const();
      if (VD != First && $this().ShouldWarnIfUnusedFileScopedDecl(First)) {
        return; // First should already be in the vector.
      }
    }
  }
  if ($this().ShouldWarnIfUnusedFileScopedDecl(D)) {
    $this().UnusedFileScopedDecls.push_back(D);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseUnusedNestedTypedefs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1580,
 FQN="clang::Sema::DiagnoseUnusedNestedTypedefs", NM="_ZN5clang4Sema28DiagnoseUnusedNestedTypedefsEPKNS_10RecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema28DiagnoseUnusedNestedTypedefsEPKNS_10RecordDeclE")
//</editor-fold>
public final void DiagnoseUnusedNestedTypedefs(/*const*/ RecordDecl /*P*/ D) {
  if (D.getTypeForDecl().isDependentType()) {
    return;
  }
  
  for (Decl /*P*/ TmpD : D.decls()) {
    {
      /*const*/ TypedefNameDecl /*P*/ T = dyn_cast_TypedefNameDecl(TmpD);
      if ((T != null)) {
        $this().DiagnoseUnusedDecl(T);
      } else {
        /*const*/ RecordDecl /*P*/ R = dyn_cast_RecordDecl(TmpD);
        if ((R != null)) {
          $this().DiagnoseUnusedNestedTypedefs(R);
        }
      }
    }
  }
}


/// DiagnoseUnusedDecl - Emit warnings about declarations that are not used
/// unless they are marked attr(unused).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseUnusedDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1594,
 FQN="clang::Sema::DiagnoseUnusedDecl", NM="_ZN5clang4Sema18DiagnoseUnusedDeclEPKNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema18DiagnoseUnusedDeclEPKNS_9NamedDeclE")
//</editor-fold>
public final void DiagnoseUnusedDecl(/*const*/ NamedDecl /*P*/ D) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (!ShouldDiagnoseUnusedDecl(D)) {
      return;
    }
    {
      
      /*const*/ TypedefNameDecl /*P*/ TD = dyn_cast_TypedefNameDecl(D);
      if ((TD != null)) {
        // typedefs can be referenced later on, so the diagnostics are emitted
        // at end-of-translation-unit.
        $this().UnusedLocalTypedefNameCandidates.insert(TD);
        return;
      }
    }
    
    FixItHint Hint/*J*/= new FixItHint();
    GenerateFixForUnusedDecl(D, $this().Context, Hint);
    
    /*uint*/int DiagID;
    if (isa_VarDecl(D) && cast_VarDecl(D).isExceptionVariable()) {
      DiagID = diag.warn_unused_exception_param;
    } else if (isa_LabelDecl(D)) {
      DiagID = diag.warn_unused_label;
    } else {
      DiagID = diag.warn_unused_variable;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), DiagID)), D.getDeclName()), Hint));
  } finally {
    $c$.$destroy();
  }
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::Sema::deduceVarTypeFromInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9424,
 FQN="clang::Sema::deduceVarTypeFromInitializer", NM="_ZN5clang4Sema28deduceVarTypeFromInitializerEPNS_7VarDeclENS_15DeclarationNameENS_8QualTypeEPNS_14TypeSourceInfoENS_11SourceRangeEbPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema28deduceVarTypeFromInitializerEPNS_7VarDeclENS_15DeclarationNameENS_8QualTypeEPNS_14TypeSourceInfoENS_11SourceRangeEbPNS_4ExprE")
//</editor-fold>
public final QualType deduceVarTypeFromInitializer(VarDecl /*P*/ VDecl, 
                            DeclarationName Name, QualType Type, 
                            TypeSourceInfo /*P*/ TSI, 
                            SourceRange Range, boolean DirectInit, 
                            Expr /*P*/ Init) {
  boolean IsInitCapture = !(VDecl != null);
  assert ((!(VDecl != null) || !VDecl.isInitCapture())) : "init captures are expected to be deduced prior to initialization";
  
  ArrayRef<Expr /*P*/ > DeduceInits = new ArrayRef<Expr /*P*/ >(Init, true);
  if (DirectInit) {
    {
      ParenListExpr /*P*/ PL = dyn_cast_ParenListExpr(Init);
      if ((PL != null)) {
        DeduceInits.$assignMove(PL.exprs());
      } else {
        InitListExpr /*P*/ IL = dyn_cast_InitListExpr(Init);
        if ((IL != null)) {
          DeduceInits.$assignMove(IL.inits());
        }
      }
    }
  }
  
  // Deduction only works if we have exactly one source expression.
  if (DeduceInits.empty()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // It isn't possible to write this directly, but it is possible to
      // end up in this situation with "auto x(some_pack...);"
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Init.getLocStart(), IsInitCapture ? diag.err_init_capture_no_expression : diag.err_auto_var_init_no_expression)), 
                  Name), Type), Range));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  if ($greater_uint(DeduceInits.size(), 1)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DeduceInits.$at(1).getLocStart(), 
                      IsInitCapture ? diag.err_init_capture_multiple_expressions : diag.err_auto_var_init_multiple_expressions)), 
                  Name), Type), Range));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  
  type$ref<Expr /*P*/ > DeduceInit = create_type$ref(DeduceInits.$at(0));
  if (DirectInit && isa_InitListExpr(DeduceInit)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Init.getLocStart(), IsInitCapture ? diag.err_init_capture_paren_braces : diag.err_auto_var_init_paren_braces)), 
                      isa_InitListExpr(Init)), Name), Type), Range));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  
  // Expressions default to 'id' when we're in a debugger.
  boolean DefaultedAnyToId = false;
  if ($this().getLangOpts().DebuggerCastResultToId
     && $eq_QualType$C(Init.getType(), $this().Context.UnknownAnyTy.$QualType()) && !IsInitCapture) {
    ActionResultTTrue<Expr /*P*/ > Result = $this().forceUnknownAnyToType(Init, $this().Context.getObjCIdType());
    if (Result.isInvalid()) {
      return new QualType();
    }
    Init = Result.get();
    DefaultedAnyToId = true;
  }
  
  QualType DeducedType/*J*/= new QualType();
  if ($this().DeduceAutoType(TSI, DeduceInit, DeducedType) == DeduceAutoResult.DAR_Failed) {
    if (!IsInitCapture) {
      $this().DiagnoseAutoDeductionFailure(VDecl, DeduceInit.$deref());
    } else if (isa_InitListExpr(Init)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Range.getBegin(), 
                        diag.err_init_capture_deduction_failure_from_init_list)), 
                    Name), 
                (DeduceInit.$deref().getType().isNull() ? TSI.getType() : DeduceInit.$deref().getType())), 
            DeduceInit.$deref().getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Range.getBegin(), diag.err_init_capture_deduction_failure)), 
                        Name), TSI.getType()), 
                (DeduceInit.$deref().getType().isNull() ? TSI.getType() : DeduceInit.$deref().getType())), 
            DeduceInit.$deref().getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Warn if we deduced 'id'. 'auto' usually implies type-safety, but using
  // 'id' instead of a specific object type prevents most of our usual
  // checks.
  // We only want to warn outside of template instantiations, though:
  // inside a template, the 'id' could have come from a parameter.
  if ($this().ActiveTemplateInstantiations.empty() && !DefaultedAnyToId
     && !IsInitCapture && !DeducedType.isNull() && DeducedType.$arrow().isObjCIdType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SourceLocation Loc = TSI.getTypeLoc().getBeginLoc();
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_auto_var_is_id)), Name), Range));
    } finally {
      $c$.$destroy();
    }
  }
  
  return DeducedType;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::inferObjCARCLifetime">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5487,
 FQN="clang::Sema::inferObjCARCLifetime", NM="_ZN5clang4Sema20inferObjCARCLifetimeEPNS_9ValueDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema20inferObjCARCLifetimeEPNS_9ValueDeclE")
//</editor-fold>
public final boolean inferObjCARCLifetime(ValueDecl /*P*/ decl) {
  QualType type = decl.getType();
  Qualifiers.ObjCLifetime lifetime = type.getObjCLifetime();
  if (lifetime == Qualifiers.ObjCLifetime.OCL_Autoreleasing) {
    // Various kinds of declaration aren't allowed to be __autoreleasing.
    /*uint*/int kind = -1/*U*/;
    {
      VarDecl /*P*/ var = dyn_cast_VarDecl(decl);
      if ((var != null)) {
        if (var.hasAttr(BlocksAttr.class)) {
          kind = 0; // __block
        } else if (!var.hasLocalStorage()) {
          kind = 1; // global
        }
      } else if (isa_ObjCIvarDecl(decl)) {
        kind = 3; // ivar
      } else if (isa_FieldDecl(decl)) {
        kind = 2; // field
      }
    }
    if (kind != -1/*U*/) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(decl.getLocation(), diag.err_arc_autoreleasing_var)), 
            kind));
      } finally {
        $c$.$destroy();
      }
    }
  } else if (lifetime == Qualifiers.ObjCLifetime.OCL_None) {
    // Try to infer lifetime.
    if (!type.$arrow().isObjCLifetimeType()) {
      return false;
    }
    
    lifetime = type.$arrow().getObjCARCImplicitLifetime();
    type.$assignMove($this().Context.getLifetimeQualifiedType(new QualType(type), lifetime));
    decl.setType(new QualType(type));
  }
  {
    
    VarDecl /*P*/ var = dyn_cast_VarDecl(decl);
    if ((var != null)) {
      // Thread-local variables cannot have lifetime.
      if ((lifetime.getValue() != 0) && lifetime != Qualifiers.ObjCLifetime.OCL_ExplicitNone
         && (var.getTLSKind().getValue() != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(var.getLocation(), diag.err_arc_thread_ownership)), 
              var.getType()));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  return false;
}


/// ActOnPragmaWeakID - Called on well formed \#pragma weak ident.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPragmaWeakID">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 15205,
 FQN="clang::Sema::ActOnPragmaWeakID", NM="_ZN5clang4Sema17ActOnPragmaWeakIDEPNS_14IdentifierInfoENS_14SourceLocationES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema17ActOnPragmaWeakIDEPNS_14IdentifierInfoENS_14SourceLocationES3_")
//</editor-fold>
public final void ActOnPragmaWeakID(IdentifierInfo /*P*/ Name, 
                 SourceLocation PragmaLoc, 
                 SourceLocation NameLoc) {
  Decl /*P*/ PrevDecl = $this().LookupSingleName($this().TUScope, new DeclarationName(Name), new SourceLocation(NameLoc), LookupNameKind.LookupOrdinaryName);
  if ((PrevDecl != null)) {
    PrevDecl.addAttr(WeakAttr.CreateImplicit($this().Context, new SourceRange(/*NO_COPY*/PragmaLoc)));
  } else {
    /*J:(void)*/$this().WeakUndeclaredIdentifiers.insert(new std.pairPtrType<IdentifierInfo /*P*/ , WeakInfo>(JD$T$RR_T1$RR.INSTANCE, Name, new WeakInfo(JD$Move.INSTANCE, /*Fwd*/new WeakInfo((IdentifierInfo /*P*/ )(IdentifierInfo /*P*/ )null, new SourceLocation(NameLoc)))));
  }
}


/// ActOnPragmaRedefineExtname - Called on well formed
/// \#pragma redefine_extname oldname newname.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPragmaRedefineExtname">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 15180,
 FQN="clang::Sema::ActOnPragmaRedefineExtname", NM="_ZN5clang4Sema26ActOnPragmaRedefineExtnameEPNS_14IdentifierInfoES2_NS_14SourceLocationES3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema26ActOnPragmaRedefineExtnameEPNS_14IdentifierInfoES2_NS_14SourceLocationES3_S3_")
//</editor-fold>
public final void ActOnPragmaRedefineExtname(IdentifierInfo /*P*/ Name, 
                          IdentifierInfo /*P*/ AliasName, 
                          SourceLocation PragmaLoc, 
                          SourceLocation NameLoc, 
                          SourceLocation AliasNameLoc) {
  NamedDecl /*P*/ PrevDecl = $this().LookupSingleName($this().TUScope, new DeclarationName(Name), new SourceLocation(NameLoc), 
      LookupNameKind.LookupOrdinaryName);
  AsmLabelAttr /*P*/ Attr = AsmLabelAttr.CreateImplicit($this().Context, AliasName.getName(), new SourceRange(/*NO_COPY*/AliasNameLoc));
  
  // If a declaration that:
  // 1) declares a function or a variable
  // 2) has external linkage
  // already exists, add a label attribute to it.
  if ((PrevDecl != null) && (isa_FunctionDecl(PrevDecl) || isa_VarDecl(PrevDecl))) {
    if (isDeclExternC(PrevDecl)) {
      PrevDecl.addAttr(Attr);
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(PrevDecl.getLocation(), diag.warn_redefine_extname_not_applied)), 
                /*Variable*/ (isa_FunctionDecl(PrevDecl) ? 0 : 1)), PrevDecl));
      } finally {
        $c$.$destroy();
      }
    }
    // Otherwise, add a label atttibute to ExtnameUndeclaredIdentifiers.
  } else {
    /*J:(void)*/$this().ExtnameUndeclaredIdentifiers.insert_pair$KeyT$ValueT(std.make_pair_Ptr_Ptr(Name, Attr));
  }
}


/// ActOnPragmaWeakAlias - Called on well formed \#pragma weak ident = ident.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPragmaWeakAlias">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 15219,
 FQN="clang::Sema::ActOnPragmaWeakAlias", NM="_ZN5clang4Sema20ActOnPragmaWeakAliasEPNS_14IdentifierInfoES2_NS_14SourceLocationES3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema20ActOnPragmaWeakAliasEPNS_14IdentifierInfoES2_NS_14SourceLocationES3_S3_")
//</editor-fold>
public final void ActOnPragmaWeakAlias(IdentifierInfo /*P*/ Name, 
                    IdentifierInfo /*P*/ AliasName, 
                    SourceLocation PragmaLoc, 
                    SourceLocation NameLoc, 
                    SourceLocation AliasNameLoc) {
  Decl /*P*/ PrevDecl = $this().LookupSingleName($this().TUScope, new DeclarationName(AliasName), new SourceLocation(AliasNameLoc), 
      LookupNameKind.LookupOrdinaryName);
  WeakInfo W = new WeakInfo(Name, new SourceLocation(NameLoc));
  if ((PrevDecl != null) && (isa_FunctionDecl(PrevDecl) || isa_VarDecl(PrevDecl))) {
    if (!PrevDecl.hasAttr(AliasAttr.class)) {
      {
        NamedDecl /*P*/ ND = dyn_cast_NamedDecl(PrevDecl);
        if ((ND != null)) {
          $this().DeclApplyPragmaWeak($this().TUScope, ND, W);
        }
      }
    }
  } else {
    /*J:(void)*/$this().WeakUndeclaredIdentifiers.insert(new std.pairPtrType<IdentifierInfo /*P*/ , WeakInfo>(JD$T$RR_T1$RR.INSTANCE, AliasName, new WeakInfo(/*Fwd*/W)));
  }
}


/// IsValueInFlagEnum - Determine if a value is allowed as part of a flag
/// enum. If AllowMask is true, then we also allow the complement of a valid
/// value, to be used as a mask.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::IsValueInFlagEnum">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 14749,
 FQN="clang::Sema::IsValueInFlagEnum", NM="_ZNK5clang4Sema17IsValueInFlagEnumEPKNS_8EnumDeclERKN4llvm5APIntEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZNK5clang4Sema17IsValueInFlagEnumEPKNS_8EnumDeclERKN4llvm5APIntEb")
//</editor-fold>
public final boolean IsValueInFlagEnum(/*const*/ EnumDecl /*P*/ ED, final /*const*/ APInt /*&*/ Val, 
                 boolean AllowMask) /*const*/ {
  assert (ED.hasAttr(FlagEnumAttr.class)) : "looking for value in non-flag enum";
  assert (ED.isCompleteDefinition()) : "expected enum definition";
  
  std.pairTypeBool<DenseMapIterator</*const*/ EnumDecl /*P*/ , APInt>> R = $this().FlagBitsCache.insert_pair$KeyT$ValueT(std.make_pair_Ptr_T(ED, $Move(new APInt())));
  final APInt /*&*/ FlagBits = R.first.$arrow().second;
  if (R.second) {
    for (EnumConstantDecl /*P*/ E : ED.enumerators()) {
      final /*const*/ APSInt /*&*/ EVal = E.getInitVal();
      // Only single-bit enumerators introduce new flag values.
      if (EVal.isPowerOf2()) {
        FlagBits.$assignMove(FlagBits.zextOrSelf(EVal.getBitWidth()).$bitor(EVal));
      }
    }
  }
  
  // A value is in a flag enum if either its bits are a subset of the enum's
  // flag bits (the first condition) or we are allowing masks and the same is
  // true of its complement (the second condition). When masks are allowed, we
  // allow the common idiom of ~(enum1 | enum2) to be a valid enum value.
  //
  // While it's true that any value could be used as a mask, the assumption is
  // that a mask will have all of the insignificant bits set. Anything else is
  // likely a logic error.
  APInt FlagMask = FlagBits.zextOrTrunc(Val.getBitWidth()).$bitnot();
  return (FlagMask.$bitand(Val)).$not() || (AllowMask && (FlagMask.$bitand(Val.$bitnot())).$not());
}


/// type checking declaration initializers (C99 6.7.8)
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckForConstantInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9074,
 FQN="clang::Sema::CheckForConstantInitializer", NM="_ZN5clang4Sema27CheckForConstantInitializerEPNS_4ExprENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema27CheckForConstantInitializerEPNS_4ExprENS_8QualTypeE")
//</editor-fold>
public final boolean CheckForConstantInitializer(Expr /*P*/ Init, QualType DclT) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // FIXME: Need strict checking.  In C89, we need to check for
    // any assignment, increment, decrement, function-calls, or
    // commas outside of a sizeof.  In C99, it's the same list,
    // except that the aforementioned are allowed in unevaluated
    // expressions.  Everything else falls under the
    // "may accept other forms of constant expressions" exception.
    // (We never end up here for C++, so the constant expression
    // rules there don't matter.)
    type$ptr</*const*/ Expr /*P*/ > Culprit = create_type$null$ptr();
    if (Init.isConstantInitializer($this().Context, false, $AddrOf(Culprit))) {
      return false;
    }
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Culprit.$star().getExprLoc(), diag.err_init_element_not_constant)), 
        Culprit.$star().getSourceRange()));
    return true;
  } finally {
    $c$.$destroy();
  }
}


/// VerifyBitField - verifies that a bit field expression is an ICE and has
/// the correct width, and that the field type is valid.
/// Returns false on success.
/// Can optionally return whether the bit-field is of width 0

// Note that FieldName may be null for anonymous bitfields.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyBitField">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 13241,
 FQN="clang::Sema::VerifyBitField", NM="_ZN5clang4Sema14VerifyBitFieldENS_14SourceLocationEPNS_14IdentifierInfoENS_8QualTypeEbPNS_4ExprEPb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4Sema14VerifyBitFieldENS_14SourceLocationEPNS_14IdentifierInfoENS_8QualTypeEbPNS_4ExprEPb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > VerifyBitField(SourceLocation FieldLoc, 
              IdentifierInfo /*P*/ FieldName, 
              QualType FieldTy, boolean IsMsStruct, 
              Expr /*P*/ BitWidth) {
  return VerifyBitField(FieldLoc, 
              FieldName, 
              FieldTy, IsMsStruct, 
              BitWidth, (bool$ptr/*bool P*/ )null);
}
public final ActionResultTTrue<Expr /*P*/ > VerifyBitField(SourceLocation FieldLoc, 
              IdentifierInfo /*P*/ FieldName, 
              QualType FieldTy, boolean IsMsStruct, 
              Expr /*P*/ BitWidth, bool$ptr/*bool P*/ ZeroWidth/*= null*/) {
  // Default to true; that shouldn't confuse checks for emptiness
  if (Native.$bool(ZeroWidth)) {
    ZeroWidth.$set(true);
  }
  
  // C99 6.7.2.1p4 - verify the field type.
  // C++ 9.6p3: A bit-field shall have integral or enumeration type.
  if (!FieldTy.$arrow().isDependentType() && !FieldTy.$arrow().isIntegralOrEnumerationType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Handle incomplete types with specific error.
      if ($this().RequireCompleteType(new SourceLocation(FieldLoc), new QualType(FieldTy), diag.err_field_incomplete)) {
        return ExprError();
      }
      if ((FieldName != null)) {
        return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(FieldLoc), diag.err_not_integral_type_bitfield)), 
                        FieldName), FieldTy), BitWidth.getSourceRange())));
      }
      return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(FieldLoc), diag.err_not_integral_type_anon_bitfield)), 
                  FieldTy), BitWidth.getSourceRange())));
    } finally {
      $c$.$destroy();
    }
  } else if ($this().DiagnoseUnexpandedParameterPack(((/*const_cast*/Expr /*P*/ )(BitWidth)), 
      UnexpandedParameterPackContext.UPPC_BitFieldWidth)) {
    return ExprError();
  }
  
  // If the bit-width is type- or value-dependent, don't try to check
  // it now.
  if (BitWidth.isValueDependent() || BitWidth.isTypeDependent()) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, BitWidth);
  }
  
  APSInt Value/*J*/= new APSInt();
  ActionResultTTrue<Expr /*P*/ > ICE = $this().VerifyIntegerConstantExpression(BitWidth, $AddrOf(Value));
  if (ICE.isInvalid()) {
    return ICE;
  }
  BitWidth = ICE.get();
  if (Value.$noteq(0) && Native.$bool(ZeroWidth)) {
    ZeroWidth.$set(false);
  }
  
  // Zero-width bitfield is ok for anonymous field.
  if (Value.$eq(0) && (FieldName != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(FieldLoc), diag.err_bitfield_has_zero_width)), FieldName)));
    } finally {
      $c$.$destroy();
    }
  }
  if (Value.isSigned() && Value.isNegative()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if ((FieldName != null)) {
        return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(FieldLoc), diag.err_bitfield_has_negative_width)), 
                    FieldName), Value.__toString(10))));
      }
      return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(FieldLoc), diag.err_anon_bitfield_has_negative_width)), 
              Value.__toString(10))));
    } finally {
      $c$.$destroy();
    }
  }
  if (!FieldTy.$arrow().isDependentType()) {
    long/*uint64_t*/ TypeStorageSize = $this().Context.getTypeSize(new QualType(FieldTy));
    long/*uint64_t*/ TypeWidth = $uint2ulong($this().Context.getIntWidth(new QualType(FieldTy)));
    boolean BitfieldIsOverwide = Value.ugt(TypeWidth);
    
    // Over-wide bitfields are an error in C or when using the MSVC bitfield
    // ABI.
    boolean CStdConstraintViolation = BitfieldIsOverwide && !$this().getLangOpts().CPlusPlus;
    boolean MSBitfieldViolation = Value.ugt(TypeStorageSize)
       && (IsMsStruct || $this().Context.getTargetInfo().getCXXABI().isMicrosoft());
    if (CStdConstraintViolation || MSBitfieldViolation) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*uint*/int DiagWidth = $ulong2uint(CStdConstraintViolation ? TypeWidth : TypeStorageSize);
        if ((FieldName != null)) {
          return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(FieldLoc), diag.err_bitfield_width_exceeds_type_width)), 
                              FieldName), (/*uint*/int)$ulong2uint(Value.getZExtValue())), 
                      !CStdConstraintViolation), DiagWidth)));
        }
        
        return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(FieldLoc), diag.err_anon_bitfield_width_exceeds_type_width)), 
                        (/*uint*/int)$ulong2uint(Value.getZExtValue())), !CStdConstraintViolation), 
                DiagWidth)));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Warn on types where the user might conceivably expect to get all
    // specified bits as value bits: that's all integral types other than
    // 'bool'.
    if (BitfieldIsOverwide && !FieldTy.$arrow().isBooleanType()) {
      if ((FieldName != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(FieldLoc), diag.warn_bitfield_width_exceeds_type_width)), 
                      FieldName), (/*uint*/int)$ulong2uint(Value.getZExtValue())), 
              (/*uint*/int)$ulong2uint(TypeWidth)));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(FieldLoc), diag.warn_anon_bitfield_width_exceeds_type_width)), 
                  (/*uint*/int)$ulong2uint(Value.getZExtValue())), (/*uint*/int)$ulong2uint(TypeWidth)));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, BitWidth);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::getObjCDeclContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 15238,
 FQN="clang::Sema::getObjCDeclContext", NM="_ZNK5clang4Sema18getObjCDeclContextEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZNK5clang4Sema18getObjCDeclContextEv")
//</editor-fold>
public final Decl /*P*/ getObjCDeclContext() /*const*/ {
  return (dyn_cast_or_null_ObjCContainerDecl($this().CurContext));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::getCurContextAvailability">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 15242,
 FQN="clang::Sema::getCurContextAvailability", NM="_ZNK5clang4Sema25getCurContextAvailabilityEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZNK5clang4Sema25getCurContextAvailabilityEv")
//</editor-fold>
public final AvailabilityResult getCurContextAvailability() /*const*/ {
  /*const*/ Decl /*P*/ D = cast_or_null_Decl($this().getCurObjCLexicalContext());
  if (!(D != null)) {
    return AvailabilityResult.AR_Available;
  }
  {
    
    // If we are within an Objective-C method, we should consult
    // both the availability of the method as well as the
    // enclosing class.  If the class is (say) deprecated,
    // the entire method is considered deprecated from the
    // purpose of checking if the current context is deprecated.
    /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(D);
    if ((MD != null)) {
      AvailabilityResult R = MD.getAvailability();
      if (R != AvailabilityResult.AR_Available) {
        return R;
      }
      D = MD.getClassInterface$Const();
    } else {
      // If we are within an Objective-c @implementation, it
      // gets the same availability context as the @interface.
      /*const*/ ObjCImplementationDecl /*P*/ ID = dyn_cast_ObjCImplementationDecl(D);
      if ((ID != null)) {
        D = ID.getClassInterface$Const();
      }
    }
  }
  // Recover from user error.
  return (D != null) ? D.getAvailability() : AvailabilityResult.AR_Available;
}

} // END OF class Sema_SemaDecl
