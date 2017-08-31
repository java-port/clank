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
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.aliases.*;
import org.clang.ast.llvm.*;
import org.clang.ast.FunctionProtoType.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.llvm.*;
import org.clang.sema.impl.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import static org.clang.ast.DeclContext.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.sema.impl.SemaDeclCXXStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstAttributesRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import org.clang.basic.java.OptionalNotes;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaDeclCXX">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.sema.Sema_SemaDeclCXX",        
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaDeclAttr ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema13IsDerivedFromENS_14SourceLocationENS_8QualTypeES2_;_ZN5clang4Sema13IsDerivedFromENS_14SourceLocationENS_8QualTypeES2_RNS_12CXXBasePathsE;_ZN5clang4Sema14MarkVTableUsedENS_14SourceLocationEPNS_13CXXRecordDeclEb;_ZN5clang4Sema14SetDeclDeletedEPNS_4DeclENS_14SourceLocationE;_ZN5clang4Sema14isAbstractTypeENS_14SourceLocationENS_8QualTypeE;_ZN5clang4Sema15CheckDestructorEPNS_17CXXDestructorDeclE;_ZN5clang4Sema15CheckPureMethodEPNS_13CXXMethodDeclENS_11SourceRangeE;_ZN5clang4Sema16CheckConstructorEPNS_18CXXConstructorDeclE;_ZN5clang4Sema16HandleMSPropertyEPNS_5ScopeEPNS_10RecordDeclENS_14SourceLocationERNS_10DeclaratorEPNS_4ExprENS_16InClassInitStyleENS_15AccessSpecifierEPNS_13AttributeListE;_ZN5clang4Sema16SetDeclDefaultedEPNS_4DeclENS_14SourceLocationE;_ZN5clang4Sema17DefineUsedVTablesEv;_ZN5clang4Sema18ActOnBaseSpecifierEPNS_4DeclENS_11SourceRangeERNS_16ParsedAttributesEbNS_15AccessSpecifierENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationESA_;_ZN5clang4Sema18ActOnPureSpecifierEPNS_4DeclENS_14SourceLocationE;_ZN5clang4Sema18BuildBasePathArrayERKNS_12CXXBasePathsERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEE;_ZN5clang4Sema18CheckBaseSpecifierEPNS_13CXXRecordDeclENS_11SourceRangeEbNS_15AccessSpecifierEPNS_14TypeSourceInfoENS_14SourceLocationE;_ZN5clang4Sema18DiagnoseNontrivialEPKNS_13CXXRecordDeclENS0_16CXXSpecialMemberE;_ZN5clang4Sema18PushUsingDirectiveEPNS_5ScopeEPNS_18UsingDirectiveDeclE;_ZN5clang4Sema18isCurrentClassNameERKNS_14IdentifierInfoEPNS_5ScopeEPKNS_12CXXScopeSpecE;_ZN5clang4Sema19ActOnBaseSpecifiersEPNS_4DeclEN4llvm15MutableArrayRefIPNS_16CXXBaseSpecifierEEE;_ZN5clang4Sema19ActOnFriendTypeDeclEPNS_5ScopeERKNS_8DeclSpecEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEE;_ZN5clang4Sema19ActOnMemInitializerEPNS_4DeclEPNS_5ScopeERNS_12CXXScopeSpecEPNS_14IdentifierInfoENS_9OpaquePtrINS_8QualTypeEEERKNS_8DeclSpecENS_14SourceLocationEPNS_4ExprESF_;_ZN5clang4Sema19ActOnMemInitializerEPNS_4DeclEPNS_5ScopeERNS_12CXXScopeSpecEPNS_14IdentifierInfoENS_9OpaquePtrINS_8QualTypeEEERKNS_8DeclSpecENS_14SourceLocationESF_N4llvm8ArrayRefIPNS_4ExprEEESF_SF_;_ZN5clang4Sema19ActOnUsingDirectiveEPNS_5ScopeENS_14SourceLocationES3_RNS_12CXXScopeSpecES3_PNS_14IdentifierInfoEPNS_13AttributeListE;_ZN5clang4Sema19BuildMemInitializerEPNS_4DeclEPNS_5ScopeERNS_12CXXScopeSpecEPNS_14IdentifierInfoENS_9OpaquePtrINS_8QualTypeEEERKNS_8DeclSpecENS_14SourceLocationEPNS_4ExprESF_;_ZN5clang4Sema19CheckFriendTypeDeclENS_14SourceLocationES1_PNS_14TypeSourceInfoE;_ZN5clang4Sema19HideUsingShadowDeclEPNS_5ScopeEPNS_15UsingShadowDeclE;_ZN5clang4Sema19SetCtorInitializersEPNS_18CXXConstructorDeclEbN4llvm8ArrayRefIPNS_18CXXCtorInitializerEEE;_ZN5clang4Sema19SetIvarInitializersEPNS_22ObjCImplementationDeclE;_ZN5clang4Sema19isImplicitlyDeletedEPNS_12FunctionDeclE;_ZN5clang4Sema20ActOnAccessSpecifierENS_15AccessSpecifierENS_14SourceLocationES2_PNS_13AttributeListE;_ZN5clang4Sema20ActOnMemInitializersEPNS_4DeclENS_14SourceLocationEN4llvm8ArrayRefIPNS_18CXXCtorInitializerEEEb;_ZN5clang4Sema20AttachBaseSpecifiersEPNS_13CXXRecordDeclEN4llvm15MutableArrayRefIPNS_16CXXBaseSpecifierEEE;_ZN5clang4Sema20BuildBaseInitializerENS_8QualTypeEPNS_14TypeSourceInfoEPNS_4ExprEPNS_13CXXRecordDeclENS_14SourceLocationE;_ZN5clang4Sema20BuildUsingShadowDeclEPNS_5ScopeEPNS_9UsingDeclEPNS_9NamedDeclEPNS_15UsingShadowDeclE;_ZN5clang4Sema20CheckOverrideControlEPNS_9NamedDeclE;_ZN5clang4Sema20CheckUsingShadowDeclEPNS_9UsingDeclEPNS_9NamedDeclERKNS_12LookupResultERPNS_15UsingShadowDeclE;_ZN5clang4Sema20DiagnoseAbstractTypeEPKNS_13CXXRecordDeclE;_ZN5clang4Sema20MergeCXXFunctionDeclEPNS_12FunctionDeclES2_PNS_5ScopeE;_ZN5clang4Sema20isStdInitializerListENS_8QualTypeEPS1_;_ZN5clang4Sema21ActOnAliasDeclarationEPNS_5ScopeENS_15AccessSpecifierEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEENS_14SourceLocationERNS_13UnqualifiedIdEPNS_13AttributeListENS_12ActionResultINS_9OpaquePtrINS_8QualTypeEEELb0EEEPNS_4DeclE;_ZN5clang4Sema21ActOnEmptyDeclarationEPNS_5ScopeEPNS_13AttributeListENS_14SourceLocationE;_ZN5clang4Sema21ActOnUsingDeclarationEPNS_5ScopeENS_15AccessSpecifierEbNS_14SourceLocationERNS_12CXXScopeSpecERNS_13UnqualifiedIdEPNS_13AttributeListEbS4_;_ZN5clang4Sema21BuildCXXConstructExprENS_14SourceLocationENS_8QualTypeEPNS_18CXXConstructorDeclEbN4llvm15MutableArrayRefIPNS_4ExprEEEbbbbjNS_11SourceRangeE;_ZN5clang4Sema21BuildCXXConstructExprENS_14SourceLocationENS_8QualTypeEPNS_9NamedDeclEPNS_18CXXConstructorDeclEN4llvm15MutableArrayRefIPNS_4ExprEEEbbbbjNS_11SourceRangeE;_ZN5clang4Sema21BuildCXXConstructExprENS_14SourceLocationENS_8QualTypeEPNS_9NamedDeclEPNS_18CXXConstructorDeclEbN4llvm15MutableArrayRefIPNS_4ExprEEEbbbbjNS_11SourceRangeE;_ZN5clang4Sema21BuildUsingDeclarationEPNS_5ScopeENS_15AccessSpecifierENS_14SourceLocationERNS_12CXXScopeSpecENS_19DeclarationNameInfoEPNS_13AttributeListEbbS4_;_ZN5clang4Sema21isInitListConstructorEPKNS_18CXXConstructorDeclE;_ZN5clang4Sema22ActOnNamespaceAliasDefEPNS_5ScopeENS_14SourceLocationES3_PNS_14IdentifierInfoERNS_12CXXScopeSpecES3_S5_;_ZN5clang4Sema22ActOnStartNamespaceDefEPNS_5ScopeENS_14SourceLocationES3_S3_PNS_14IdentifierInfoES3_PNS_13AttributeListERPNS_18UsingDirectiveDeclE;_ZN5clang4Sema22BuildMemberInitializerEPNS_9ValueDeclEPNS_4ExprENS_14SourceLocationE;_ZN5clang4Sema22CheckCompletedCXXClassEPNS_13CXXRecordDeclE;_ZN5clang4Sema22LoadExternalVTableUsesEv;_ZN5clang4Sema22RequireNonAbstractTypeENS_14SourceLocationENS_8QualTypeERNS0_13TypeDiagnoserE;_ZN5clang4Sema22SpecialMemberIsTrivialEPNS_13CXXMethodDeclENS0_16CXXSpecialMemberEb;_ZN5clang4Sema22isCurrentClassNameTypoERPNS_14IdentifierInfoEPKNS_12CXXScopeSpecE;_ZN5clang4Sema23ActOnFinishNamespaceDefEPNS_4DeclENS_14SourceLocationE;_ZN5clang4Sema23ActOnFriendFunctionDeclEPNS_5ScopeERNS_10DeclaratorEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEE;_ZN5clang4Sema23ActOnTemplatedFriendTagEPNS_5ScopeENS_14SourceLocationEjS3_RNS_12CXXScopeSpecEPNS_14IdentifierInfoES3_PNS_13AttributeListEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEE;_ZN5clang4Sema23BuildCXXDefaultInitExprENS_14SourceLocationEPNS_9FieldDeclE;_ZN5clang4Sema23BuildStdInitializerListENS_8QualTypeENS_14SourceLocationE;_ZN5clang4Sema23CheckUsingDeclQualifierENS_14SourceLocationERKNS_12CXXScopeSpecERKNS_19DeclarationNameInfoES1_;_ZN5clang4Sema23CompleteConstructorCallEPNS_18CXXConstructorDeclEN4llvm15MutableArrayRefIPNS_4ExprEEENS_14SourceLocationERNS3_15SmallVectorImplIS6_EEbb;_ZN5clang4Sema23SetParamDefaultArgumentEPNS_11ParmVarDeclEPNS_4ExprENS_14SourceLocationE;_ZN5clang4Sema23getOrCreateStdNamespaceEv;_ZN5clang4Sema24ActOnCXXMemberDeclaratorEPNS_5ScopeENS_15AccessSpecifierERNS_10DeclaratorEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEEPNS_4ExprERKNS_14VirtSpecifiersENS_16InClassInitStyleE;_ZN5clang4Sema24ActOnExceptionDeclaratorEPNS_5ScopeERNS_10DeclaratorE;_ZN5clang4Sema24CheckCXXDefaultArgumentsEPNS_12FunctionDeclE;_ZN5clang4Sema24DefineImplicitDestructorENS_14SourceLocationEPNS_17CXXDestructorDeclE;_ZN5clang4Sema24FindHiddenVirtualMethodsEPNS_13CXXMethodDeclERN4llvm15SmallVectorImplIS2_EE;_ZN5clang4Sema24NoteHiddenVirtualMethodsEPNS_13CXXMethodDeclERN4llvm15SmallVectorImplIS2_EE;_ZN5clang4Sema24SetDelegatingInitializerEPNS_18CXXConstructorDeclEPNS_18CXXCtorInitializerE;_ZN5clang4Sema25ActOnConversionDeclaratorEPNS_17CXXConversionDeclE;_ZN5clang4Sema25ActOnFinishCXXMemberDeclsEv;_ZN5clang4Sema25ActOnParamDefaultArgumentEPNS_4DeclENS_14SourceLocationEPNS_4ExprE;_ZN5clang4Sema25ActOnReenterTemplateScopeEPNS_5ScopeEPNS_4DeclE;_ZN5clang4Sema25BuildExceptionDeclarationEPNS_5ScopeEPNS_14TypeSourceInfoENS_14SourceLocationES5_PNS_14IdentifierInfoE;_ZN5clang4Sema25CheckConversionDeclaratorERNS_10DeclaratorERNS_8QualTypeERNS_12StorageClassE;_ZN5clang4Sema25CheckDelegatingCtorCyclesEv;_ZN5clang4Sema25CheckDestructorDeclaratorERNS_10DeclaratorENS_8QualTypeERNS_12StorageClassE;_ZN5clang4Sema25DeclareImplicitDestructorEPNS_13CXXRecordDeclE;_ZN5clang4Sema25FinalizeVarWithDestructorEPNS_7VarDeclEPKNS_10RecordTypeE;_ZN5clang4Sema25ShouldDeleteSpecialMemberEPNS_13CXXMethodDeclENS0_16CXXSpecialMemberEPNS0_24InheritedConstructorInfoEb;_ZN5clang4Sema25findInheritingConstructorENS_14SourceLocationEPNS_18CXXConstructorDeclEPNS_26ConstructorUsingShadowDeclE;_ZN5clang4Sema26BuildDelegatingInitializerEPNS_14TypeSourceInfoEPNS_4ExprEPNS_13CXXRecordDeclE;_ZN5clang4Sema26CheckConstexprFunctionBodyEPKNS_12FunctionDeclEPNS_4StmtE;_ZN5clang4Sema26CheckConstexprFunctionDeclEPKNS_12FunctionDeclE;_ZN5clang4Sema26CheckConstructorDeclaratorERNS_10DeclaratorENS_8QualTypeERNS_12StorageClassE;_ZN5clang4Sema26MergeVarDeclExceptionSpecsEPNS_7VarDeclES2_;_ZN5clang4Sema27ActOnCXXExitDeclInitializerEPNS_5ScopeEPNS_4DeclE;_ZN5clang4Sema27CheckUsingDeclRedeclarationENS_14SourceLocationEbRKNS_12CXXScopeSpecES1_RKNS_12LookupResultE;_ZN5clang4Sema27DefineInheritingConstructorENS_14SourceLocationEPNS_18CXXConstructorDeclE;_ZN5clang4Sema27checkClassLevelDLLAttributeEPNS_13CXXRecordDeclE;_ZN5clang4Sema27checkExceptionSpecificationEbNS_26ExceptionSpecificationTypeEN4llvm8ArrayRefINS_9OpaquePtrINS_8QualTypeEEEEENS3_INS_11SourceRangeEEEPNS_4ExprERNS2_15SmallVectorImplIS5_EERNS_17FunctionProtoType17ExceptionSpecInfoE;_ZN5clang4Sema28ActOnCXXConditionDeclarationEPNS_5ScopeERNS_10DeclaratorE;_ZN5clang4Sema28ActOnCXXEnterDeclInitializerEPNS_5ScopeEPNS_4DeclE;_ZN5clang4Sema28ActOnDefaultCtorInitializersEPNS_4DeclE;_ZN5clang4Sema28ActOnFinishCXXNonNestedClassEPNS_4DeclE;_ZN5clang4Sema28ActOnStaticAssertDeclarationENS_14SourceLocationEPNS_4ExprES3_S1_;_ZN5clang4Sema28BuildStaticAssertDeclarationENS_14SourceLocationEPNS_4ExprEPNS_13StringLiteralES1_b;_ZN5clang4Sema28CheckDerivedToBaseConversionENS_8QualTypeES1_NS_14SourceLocationENS_11SourceRangeEPN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEEb;_ZN5clang4Sema28CheckDerivedToBaseConversionENS_8QualTypeES1_jjNS_14SourceLocationENS_11SourceRangeENS_15DeclarationNameEPN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEEb;_ZN5clang4Sema28DefineImplicitCopyAssignmentENS_14SourceLocationEPNS_13CXXMethodDeclE;_ZN5clang4Sema28DefineImplicitMoveAssignmentENS_14SourceLocationEPNS_13CXXMethodDeclE;_ZN5clang4Sema28DiagnoseHiddenVirtualMethodsEPNS_13CXXMethodDeclE;_ZN5clang4Sema28MarkVirtualMembersReferencedENS_14SourceLocationEPKNS_13CXXRecordDeclE;_ZN5clang4Sema29AdjustDestructorExceptionSpecEPNS_13CXXRecordDeclEPNS_17CXXDestructorDeclE;_ZN5clang4Sema29CheckExtraCXXDefaultArgumentsERNS_10DeclaratorE;_ZN5clang4Sema29DeclareImplicitCopyAssignmentEPNS_13CXXRecordDeclE;_ZN5clang4Sema29DeclareImplicitMoveAssignmentEPNS_13CXXRecordDeclE;_ZN5clang4Sema29DefineImplicitCopyConstructorENS_14SourceLocationEPNS_18CXXConstructorDeclE;_ZN5clang4Sema29DefineImplicitMoveConstructorENS_14SourceLocationEPNS_18CXXConstructorDeclE;_ZN5clang4Sema29EvaluateImplicitExceptionSpecENS_14SourceLocationEPNS_13CXXMethodDeclE;_ZN5clang4Sema30ActOnDelayedCXXMethodParameterEPNS_5ScopeEPNS_4DeclE;_ZN5clang4Sema30ActOnParamDefaultArgumentErrorEPNS_4DeclENS_14SourceLocationE;_ZN5clang4Sema30ActOnReenterCXXMethodParameterEPNS_5ScopeEPNS_11ParmVarDeclE;_ZN5clang4Sema30ActOnStartLinkageSpecificationEPNS_5ScopeENS_14SourceLocationEPNS_4ExprES3_;_ZN5clang4Sema30DeclareImplicitCopyConstructorEPNS_13CXXRecordDeclE;_ZN5clang4Sema30DeclareImplicitMoveConstructorEPNS_13CXXRecordDeclE;_ZN5clang4Sema30getAmbiguousPathsDisplayStringERNS_12CXXBasePathsE;_ZN5clang4Sema31ActOnFinishLinkageSpecificationEPNS_5ScopeEPNS_4DeclENS_14SourceLocationE;_ZN5clang4Sema31CheckLiteralOperatorDeclarationEPNS_12FunctionDeclE;_ZN5clang4Sema32CheckDelayedMemberExceptionSpecsEv;_ZN5clang4Sema32DefineImplicitDefaultConstructorENS_14SourceLocationEPNS_18CXXConstructorDeclE;_ZN5clang4Sema32DiagnoseAbsenceOfOverrideControlEPNS_9NamedDeclE;_ZN5clang4Sema32NoteDeletedInheritingConstructorEPNS_18CXXConstructorDeclE;_ZN5clang4Sema32referenceDLLExportedClassMethodsEv;_ZN5clang4Sema33ActOnFinishCXXMemberSpecificationEPNS_5ScopeENS_14SourceLocationEPNS_4DeclES3_S3_PNS_13AttributeListE;_ZN5clang4Sema33ActOnParamUnparsedDefaultArgumentEPNS_4DeclENS_14SourceLocationES3_;_ZN5clang4Sema33CheckOverridingFunctionAttributesEPKNS_13CXXMethodDeclES3_;_ZN5clang4Sema33CheckOverridingFunctionReturnTypeEPKNS_13CXXMethodDeclES3_;_ZN5clang4Sema33ComputeDefaultedDtorExceptionSpecEPNS_13CXXMethodDeclE;_ZN5clang4Sema33DeclareImplicitDefaultConstructorEPNS_13CXXRecordDeclE;_ZN5clang4Sema34CheckOverloadedOperatorDeclarationEPNS_12FunctionDeclE;_ZN5clang4Sema34ComputeInheritingCtorExceptionSpecENS_14SourceLocationEPNS_18CXXConstructorDeclE;_ZN5clang4Sema34actOnDelayedExceptionSpecificationEPNS_4DeclENS_26ExceptionSpecificationTypeENS_11SourceRangeEN4llvm8ArrayRefINS_9OpaquePtrINS_8QualTypeEEEEENS6_IS4_EEPNS_4ExprE;_ZN5clang4Sema35ActOnStartDelayedMemberDeclarationsEPNS_5ScopeEPNS_4DeclE;_ZN5clang4Sema35AddImplicitlyDeclaredMembersToClassEPNS_13CXXRecordDeclE;_ZN5clang4Sema35CheckInheritingConstructorUsingDeclEPNS_9UsingDeclE;_ZN5clang4Sema35checkThisInStaticMemberFunctionTypeEPNS_13CXXMethodDeclE;_ZN5clang4Sema35propagateDLLAttrToBaseClassTemplateEPNS_13CXXRecordDeclEPNS_4AttrEPNS_31ClassTemplateSpecializationDeclENS_14SourceLocationE;_ZN5clang4Sema36ActOnFinishDelayedMemberDeclarationsEPNS_5ScopeEPNS_4DeclE;_ZN5clang4Sema36ActOnFinishDelayedMemberInitializersEPNS_4DeclE;_ZN5clang4Sema37ActOnStartCXXInClassMemberInitializerEv;_ZN5clang4Sema37ActOnStartDelayedCXXMethodDeclarationEPNS_5ScopeEPNS_4DeclE;_ZN5clang4Sema37CheckExplicitlyDefaultedSpecialMemberEPNS_13CXXMethodDeclE;_ZN5clang4Sema37CheckImplicitSpecialMemberDeclarationEPNS_5ScopeEPNS_12FunctionDeclE;_ZN5clang4Sema37ComputeDefaultedCopyCtorExceptionSpecEPNS_13CXXMethodDeclE;_ZN5clang4Sema37ComputeDefaultedMoveCtorExceptionSpecEPNS_13CXXMethodDeclE;_ZN5clang4Sema37MarkVirtualMemberExceptionSpecsNeededENS_14SourceLocationEPKNS_13CXXRecordDeclE;_ZN5clang4Sema38ActOnFinishCXXInClassMemberInitializerEPNS_4DeclENS_14SourceLocationEPNS_4ExprE;_ZN5clang4Sema38ActOnFinishDelayedCXXMethodDeclarationEPNS_5ScopeEPNS_4DeclE;_ZN5clang4Sema38CheckIfOverriddenFunctionIsMarkedFinalEPKNS_13CXXMethodDeclES3_;_ZN5clang4Sema38MarkBaseAndMemberDestructorsReferencedENS_14SourceLocationEPNS_13CXXRecordDeclE;_ZN5clang4Sema40ComputeDefaultedDefaultCtorExceptionSpecENS_14SourceLocationEPNS_13CXXMethodDeclE;_ZN5clang4Sema41checkThisInStaticMemberFunctionAttributesEPNS_13CXXMethodDeclE;_ZN5clang4Sema43CheckExplicitlyDefaultedMemberExceptionSpecEPNS_13CXXMethodDeclEPKNS_17FunctionProtoTypeE;_ZN5clang4Sema43ComputeDefaultedCopyAssignmentExceptionSpecEPNS_13CXXMethodDeclE;_ZN5clang4Sema43ComputeDefaultedMoveAssignmentExceptionSpecEPNS_13CXXMethodDeclE;_ZN5clang4Sema43DiagnoseReturnInConstructorExceptionHandlerEPNS_10CXXTryStmtE;_ZN5clang4Sema44DefineImplicitLambdaToBlockPointerConversionENS_14SourceLocationEPNS_17CXXConversionDeclE;_ZN5clang4Sema44checkThisInStaticMemberFunctionExceptionSpecEPNS_13CXXMethodDeclE;_ZN5clang4Sema47DefineImplicitLambdaToFunctionPointerConversionENS_14SourceLocationEPNS_17CXXConversionDeclE;_ZN5clang4Sema5PDiagEj;_ZNK5clang4Sema14getStdBadAllocEv;_ZNK5clang4Sema15getStdNamespaceEv; -static-type=Sema_SemaDeclCXX -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaDeclCXX extends Sema_SemaDeclAttr {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }


/// \brief Build a partial diagnostic.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PDiag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 25,
 FQN="clang::Sema::PDiag", NM="_ZN5clang4Sema5PDiagEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema5PDiagEj")
//</editor-fold>
public final /*inline*/ PartialDiagnostic PDiag() {
  return PDiag(0);
}
public final /*inline*/ PartialDiagnostic PDiag(/*uint*/int DiagID/*= 0*/) {
  return new PartialDiagnostic(DiagID, $this().Context.getDiagAllocator());
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckDelegatingCtorCycles">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13701,
 FQN="clang::Sema::CheckDelegatingCtorCycles", NM="_ZN5clang4Sema25CheckDelegatingCtorCyclesEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema25CheckDelegatingCtorCyclesEv")
//</editor-fold>
public final void CheckDelegatingCtorCycles() {
  SmallSetT$PLess$T$P<CXXConstructorDecl /*P*/ > Valid = null;
  SmallSetT$PLess$T$P<CXXConstructorDecl /*P*/ > Invalid = null;
  SmallSetT$PLess$T$P<CXXConstructorDecl /*P*/ > Current = null;
  try {
    Valid/*J*/= new SmallSetT$PLess$T$P<CXXConstructorDecl /*P*/ >(4);
    Invalid/*J*/= new SmallSetT$PLess$T$P<CXXConstructorDecl /*P*/ >(4);
    Current/*J*/= new SmallSetT$PLess$T$P<CXXConstructorDecl /*P*/ >(4);
    
    for (LazyVector.iterator<CXXConstructorDecl, ExternalSemaSource> I = $this().DelegatingCtorDecls.begin($this().ExternalSource), 
        E = $this().DelegatingCtorDecls.end();
         I.$noteq(E); I.$preInc())  {
      DelegatingCycleHelper(I.$star(), Valid, Invalid, Current, /*Deref*/$this());
    }
    
    for (SmallPtrSetIterator<CXXConstructorDecl /*P*/ > CI = Invalid.begin(), 
        CE = Invalid.end();
         CI.$noteq(CE); CI.$preInc())  {
      (CI.$star()).setInvalidDecl();
    }
  } finally {
    if (Current != null) { Current.$destroy(); }
    if (Invalid != null) { Invalid.$destroy(); }
    if (Valid != null) { Valid.$destroy(); }
  }
}


// CheckConstexprFunctionDecl - Check whether a function declaration satisfies
// the requirements of a constexpr function definition or a constexpr
// constructor definition. If so, return true. If not, produce appropriate
// diagnostics and return false.
//
// This implements C++11 [dcl.constexpr]p3,4, as amended by DR1360.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckConstexprFunctionDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 803,
 FQN="clang::Sema::CheckConstexprFunctionDecl", NM="_ZN5clang4Sema26CheckConstexprFunctionDeclEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema26CheckConstexprFunctionDeclEPKNS_12FunctionDeclE")
//</editor-fold>
public final boolean CheckConstexprFunctionDecl(/*const*/ FunctionDecl /*P*/ NewFD) {
  /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(NewFD);
  if ((MD != null) && MD.isInstance()) {
    // C++11 [dcl.constexpr]p4:
    //  The definition of a constexpr constructor shall satisfy the following
    //  constraints:
    //  - the class shall not have any virtual base classes;
    /*const*/ CXXRecordDecl /*P*/ RD = MD.getParent$Const();
    if ((RD.getNumVBases() != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder_uint($out_SemaDiagnosticBuilder_uint($out_SemaDiagnosticBuilder_bool($c$.track($this().Diag(NewFD.getLocation(), diag.err_constexpr_virtual_base)), 
                    isa_CXXConstructorDecl(NewFD)), 
                getRecordDiagFromTagKind(RD.getTagKind())), RD.getNumVBases()));
        for (final /*const*/ CXXBaseSpecifier /*&*/ I : RD.vbases$Const())  {
          $c$.clean($out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(I.getLocStart(), 
                  diag.note_constexpr_virtual_base_here)), I.getSourceRange()));
        }
        return false;
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (!isa_CXXConstructorDecl(NewFD)) {
    // C++11 [dcl.constexpr]p3:
    //  The definition of a constexpr function shall satisfy the following
    //  constraints:
    // - it shall not be virtual;
    /*const*/ CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(NewFD);
    if ((Method != null) && Method.isVirtual()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Method = Method.getCanonicalDecl$Const();
        $c$.clean($c$.track($this().Diag(Method.getLocation(), diag.err_constexpr_virtual)));
        
        // If it's not obvious why this function is virtual, find an overridden
        // function which uses the 'virtual' keyword.
        /*const*/ CXXMethodDecl /*P*/ WrittenVirtual = Method;
        while (!WrittenVirtual.isVirtualAsWritten()) {
          WrittenVirtual = WrittenVirtual.begin_overridden_methods().$star();
        }
        if (WrittenVirtual != Method) {
          $c$.clean($c$.track($this().Diag(WrittenVirtual.getLocation(), 
              diag.note_overridden_virtual_function)));
        }
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    
    // - its return type shall be a literal type;
    QualType RT = NewFD.getReturnType();
    if (!RT.$arrow().isDependentType()
       && $this().RequireLiteralType(NewFD.getLocation(), new QualType(RT), 
        diag.err_constexpr_non_literal_return)) {
      return false;
    }
  }
  
  // - each of its parameter types shall be a literal type;
  if (!CheckConstexprParameterTypes(/*Deref*/$this(), NewFD)) {
    return false;
  }
  
  return true;
}


/// Check the body for the given constexpr function declaration only contains
/// the permitted types of statement. C++11 [dcl.constexpr]p3,p4.
///
/// \return true if the body is OK, false if we have diagnosed a problem.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckConstexprFunctionBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 1133,
 FQN="clang::Sema::CheckConstexprFunctionBody", NM="_ZN5clang4Sema26CheckConstexprFunctionBodyEPKNS_12FunctionDeclEPNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema26CheckConstexprFunctionBodyEPKNS_12FunctionDeclEPNS_4StmtE")
//</editor-fold>
public final boolean CheckConstexprFunctionBody(/*const*/ FunctionDecl /*P*/ Dcl, Stmt /*P*/ Body) {
  OptionalNotes Diags = null;
  try {
    if (isa_CXXTryStmt(Body)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // C++11 [dcl.constexpr]p3:
        //  The definition of a constexpr function shall satisfy the following
        //  constraints: [...]
        // - its function-body shall be = delete, = default, or a
        //   compound-statement
        //
        // C++11 [dcl.constexpr]p4:
        //  In the definition of a constexpr constructor, [...]
        // - its function-body shall not be a function-try-block;
        $c$.clean($out_SemaDiagnosticBuilder_bool($c$.track($this().Diag(Body.getLocStart(), diag.err_constexpr_function_try_block)), 
            isa_CXXConstructorDecl(Dcl)));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    
    SmallVector<SourceLocation> ReturnStmts/*J*/= new SmallVector<SourceLocation>(4, new SourceLocation());
    
    // - its function-body shall be [...] a compound-statement that contains only
    //   [... list of cases ...]
    CompoundStmt /*P*/ CompBody = cast_CompoundStmt(Body);
    SourceLocation Cxx1yLoc/*J*/= new SourceLocation();
    for (Stmt /*P*/ BodyIt : CompBody.body()) {
      if (!CheckConstexprFunctionStmt(/*Deref*/$this(), Dcl, BodyIt, ReturnStmts, Cxx1yLoc)) {
        return false;
      }
    }
    if (Cxx1yLoc.isValid()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder_bool($c$.track($this().Diag(new SourceLocation(Cxx1yLoc), 
                $this().getLangOpts().CPlusPlus14 ? diag.warn_cxx11_compat_constexpr_body_invalid_stmt : diag.ext_constexpr_body_invalid_stmt)), 
            isa_CXXConstructorDecl(Dcl)));
      } finally {
        $c$.$destroy();
      }
    }
    {
      
      /*const*/ CXXConstructorDecl /*P*/ Constructor = dyn_cast_CXXConstructorDecl(Dcl);
      if ((Constructor != null)) {
        /*const*/ CXXRecordDecl /*P*/ RD = Constructor.getParent$Const();
        // DR1359:
        // - every non-variant non-static data member and base class sub-object
        //   shall be initialized;
        // DR1460:
        // - if the class is a union having variant members, exactly one of them
        //   shall be initialized;
        if (RD.isUnion()) {
          if (Constructor.getNumCtorInitializers() == 0
             && RD.hasVariantMembers()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(Dcl.getLocation(), diag.err_constexpr_union_ctor_no_init)));
              return false;
            } finally {
              $c$.$destroy();
            }
          }
        } else if (!Constructor.isDependentContext()
           && !Constructor.isDelegatingConstructor()) {
          assert (RD.getNumVBases() == 0) : "constexpr ctor with virtual bases";
          
          // Skip detailed checking if we have enough initializers, and we would
          // allow at most one initializer per member.
          boolean AnyAnonStructUnionMembers = false;
          /*uint*/int Fields = 0;
          for (specific_decl_iterator<FieldDecl> I = RD.field_begin(), 
              E = RD.field_end(); $noteq_specific_decl_iterator$SpecificDecl$C(I, E); I.$preInc() , ++Fields) {
            if (I.$arrow().isAnonymousStructOrUnion()) {
              AnyAnonStructUnionMembers = true;
              break;
            }
          }
          // DR1460:
          // - if the class is a union-like class, but is not a union, for each of
          //   its anonymous union members having variant members, exactly one of
          //   them shall be initialized;
          if (AnyAnonStructUnionMembers
             || Constructor.getNumCtorInitializers() != RD.getNumBases() + Fields) {
            SmallSetT$PLess$T$P<Decl /*P*/ > Inits = null;
            try {
              // Check initialization of non-static data members. Base classes are
              // always initialized so do not need to be checked. Dependent bases
              // might not have initializers in the member initializer list.
              Inits/*J*/= new SmallSetT$PLess$T$P<Decl /*P*/ >(16);
              for (/*const*/ CXXCtorInitializer /*P*/ I : Constructor.inits$Const()) {
                {
                  FieldDecl /*P*/ FD = I.getMember();
                  if ((FD != null)) {
                    Inits.insert(FD);
                  } else {
                    IndirectFieldDecl /*P*/ ID = I.getIndirectMember();
                    if ((ID != null)) {
                      Inits.insert$T(ID.chain_begin(), ID.chain_end());
                    }
                  }
                }
              }
              
              bool$ref Diagnosed = create_bool$ref(false);
              for (FieldDecl /*P*/ I : RD.fields())  {
                CheckConstexprCtorInitializer(/*Deref*/$this(), Dcl, I, Inits, Diagnosed);
              }
              if (Diagnosed.$deref()) {
                return false;
              }
            } finally {
              if (Inits != null) { Inits.$destroy(); }
            }
          }
        }
      } else {
        if (ReturnStmts.empty()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // C++1y doesn't require constexpr functions to contain a 'return'
            // statement. We still do, unless the return type might be void, because
            // otherwise if there's no return statement, the function cannot
            // be used in a core constant expression.
            boolean OK = $this().getLangOpts().CPlusPlus14
               && (Dcl.getReturnType().$arrow().isVoidType()
               || Dcl.getReturnType().$arrow().isDependentType());
            $c$.clean($c$.track($this().Diag(Dcl.getLocation(), 
                OK ? diag.warn_cxx11_compat_constexpr_body_no_return : diag.err_constexpr_body_no_return)));
            if (!OK) {
              return false;
            }
          } finally {
            $c$.$destroy();
          }
        } else if ($greater_uint(ReturnStmts.size(), 1)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(ReturnStmts.back()), 
                $this().getLangOpts().CPlusPlus14 ? diag.warn_cxx11_compat_constexpr_body_multiple_return : diag.ext_constexpr_body_multiple_return)));
            for (/*uint*/int I = 0; $less_uint(I, ReturnStmts.size() - 1); ++I)  {
              $c$.clean($c$.track($this().Diag(new SourceLocation(ReturnStmts.$at(I)), diag.note_constexpr_body_previous_return)));
            }
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    // C++11 [dcl.constexpr]p5:
    //   if no function argument values exist such that the function invocation
    //   substitution would produce a constant expression, the program is
    //   ill-formed; no diagnostic required.
    // C++11 [dcl.constexpr]p3:
    //   - every constructor call and implicit conversion used in initializing the
    //     return value shall be one of those allowed in a constant expression.
    // C++11 [dcl.constexpr]p4:
    //   - every constructor involved in initializing non-static data members and
    //     base class sub-objects shall be a constexpr constructor.
    Diags/*J*/= new OptionalNotes(8);
    if (!Expr.isPotentialConstantExpr(Dcl, Diags)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder_bool($c$.track($this().Diag(Dcl.getLocation(), diag.ext_constexpr_function_never_constant_expr)), 
            isa_CXXConstructorDecl(Dcl)));
        for (/*size_t*/int I = 0, N = Diags.size(); I != N; ++I)  {
          $c$.clean($c$.track($this().Diag(new SourceLocation(Diags.$at(I).first), Diags.$at(I).second)));
        }
      } finally {
        $c$.$destroy();
      }
      // Don't return false here: we allow this for compatibility in
      // system headers.
    }
    
    return true;
  } finally {
    if (Diags != null) { Diags.$destroy(); }
  }
}


/// \brief Diagnose methods which overload virtual methods in a base class
/// without overriding any.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseHiddenVirtualMethods">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6555,
 FQN="clang::Sema::DiagnoseHiddenVirtualMethods", NM="_ZN5clang4Sema28DiagnoseHiddenVirtualMethodsEPNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema28DiagnoseHiddenVirtualMethodsEPNS_13CXXMethodDeclE")
//</editor-fold>
public final void DiagnoseHiddenVirtualMethods(CXXMethodDecl /*P*/ MD) {
  if (MD.isInvalidDecl()) {
    return;
  }
  if ($this().Diags.isIgnored(diag.warn_overloaded_virtual, MD.getLocation())) {
    return;
  }
  
  SmallVector<CXXMethodDecl /*P*/ > OverloadedMethods/*J*/= new SmallVector<CXXMethodDecl /*P*/ >(8, (CXXMethodDecl /*P*/ )null);
  $this().FindHiddenVirtualMethods(MD, OverloadedMethods);
  if (!OverloadedMethods.empty()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder_bool($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MD.getLocation(), diag.warn_overloaded_virtual)), 
              MD), ($greater_uint(OverloadedMethods.size(), 1))));
      
      $this().NoteHiddenVirtualMethods(MD, OverloadedMethods);
    } finally {
      $c$.$destroy();
    }
  }
}


/// \brief Check if a method overloads virtual methods in a base class without
/// overriding any.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FindHiddenVirtualMethods">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6514,
 FQN="clang::Sema::FindHiddenVirtualMethods", NM="_ZN5clang4Sema24FindHiddenVirtualMethodsEPNS_13CXXMethodDeclERN4llvm15SmallVectorImplIS2_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema24FindHiddenVirtualMethodsEPNS_13CXXMethodDeclERN4llvm15SmallVectorImplIS2_EE")
//</editor-fold>
public final void FindHiddenVirtualMethods(CXXMethodDecl /*P*/ MD, 
                        final SmallVectorImpl<CXXMethodDecl /*P*/ > /*&*/ OverloadedMethods) {
  CXXBasePaths Paths = null;
  FindHiddenVirtualMethod FHVM = null;
  try {
    if (!MD.getDeclName().isIdentifier()) {
      return;
    }
    
    Paths/*J*/= new CXXBasePaths(/*FindAmbiguities=*/ true,  // true to look in all bases.
        /*bool RecordPaths=*/ false, 
        /*bool DetectVirtual=*/ false);
    FHVM/*J*/= new FindHiddenVirtualMethod();
    FHVM.Method = MD;
    FHVM.S = $this();
    
    // Keep the base methods that were overriden or introduced in the subclass
    // by 'using' in a set. A base method not in this set is hidden.
    CXXRecordDecl /*P*/ DC = MD.getParent();
    DeclContextLookupResult R = DC.lookup(MD.getDeclName());
    for (DeclContextLookupResult.iterator I = R.begin(), E = R.end(); I.$noteq(E); I.$preInc()) {
      NamedDecl /*P*/ ND = I.$star();
      {
        UsingShadowDecl /*P*/ shad = dyn_cast_UsingShadowDecl(I.$star());
        if ((shad != null)) {
          ND = shad.getTargetDecl();
        }
      }
      {
        CXXMethodDecl /*P*/ MD$1 = dyn_cast_CXXMethodDecl(ND);
        if ((MD$1 != null)) {
          AddMostOverridenMethods(MD$1, FHVM.OverridenAndUsingBaseMethods);
        }
      }
    }
    if (DC.lookupInBases(/*FuncArg*/FHVM, Paths)) {
      OverloadedMethods.$assign(FHVM.OverloadedMethods);
    }
  } finally {
    if (FHVM != null) { FHVM.$destroy(); }
    if (Paths != null) { Paths.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::NoteHiddenVirtualMethods">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6542,
 FQN="clang::Sema::NoteHiddenVirtualMethods", NM="_ZN5clang4Sema24NoteHiddenVirtualMethodsEPNS_13CXXMethodDeclERN4llvm15SmallVectorImplIS2_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema24NoteHiddenVirtualMethodsEPNS_13CXXMethodDeclERN4llvm15SmallVectorImplIS2_EE")
//</editor-fold>
public final void NoteHiddenVirtualMethods(CXXMethodDecl /*P*/ MD, 
                        final SmallVectorImpl<CXXMethodDecl /*P*/ > /*&*/ OverloadedMethods) {
  for (/*uint*/int i = 0, e = OverloadedMethods.size(); i != e; ++i) {
    PartialDiagnostic PD = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      CXXMethodDecl /*P*/ overloadedMD = OverloadedMethods.$at(i);
      PD = $c$.clean(new PartialDiagnostic($out_PartialDiagnostic$C_NamedDecl$C$P($c$.track($this().PDiag(diag.note_hidden_overloaded_virtual_declared_here)), overloadedMD)));
      $this().HandleFunctionTypeMismatch(PD, MD.getType(), overloadedMD.getType());
      $c$.clean($c$.track($this().Diag(overloadedMD.getLocation(), PD)));
    } finally {
      if (PD != null) { PD.$destroy(); }
      $c$.$destroy();
    }
  }
}


/// ActOnParamDefaultArgument - Check whether the default argument
/// provided for a function parameter is well-formed. If so, attach it
/// to the parameter declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnParamDefaultArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 296,
 FQN="clang::Sema::ActOnParamDefaultArgument", NM="_ZN5clang4Sema25ActOnParamDefaultArgumentEPNS_4DeclENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema25ActOnParamDefaultArgumentEPNS_4DeclENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public final void ActOnParamDefaultArgument(Decl /*P*/ param, SourceLocation EqualLoc, 
                         Expr /*P*/ DefaultArg) {
  if (!(param != null) || !(DefaultArg != null)) {
    return;
  }
  
  ParmVarDecl /*P*/ Param = cast_ParmVarDecl(param);
  $this().UnparsedDefaultArgLocs.erase(Param);
  
  // Default arguments are only permitted in C++
  if (!$this().getLangOpts().CPlusPlus) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(EqualLoc), diag.err_param_default_argument)), 
          DefaultArg.getSourceRange()));
      Param.setInvalidDecl();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Check for unexpanded parameter packs.
  if ($this().DiagnoseUnexpandedParameterPack(DefaultArg, UnexpandedParameterPackContext.UPPC_DefaultArgument)) {
    Param.setInvalidDecl();
    return;
  }
  
  // C++11 [dcl.fct.default]p3
  //   A default argument expression [...] shall not be specified for a
  //   parameter pack.
  if (Param.isParameterPack()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(EqualLoc), diag.err_param_default_argument_on_parameter_pack)), 
          DefaultArg.getSourceRange()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Check that the default argument is well-formed
  CheckDefaultArgumentVisitor DefaultArgChecker/*J*/= new CheckDefaultArgumentVisitor(DefaultArg, $this());
  if (DefaultArgChecker.Visit(DefaultArg)) {
    Param.setInvalidDecl();
    return;
  }
  
  $this().SetParamDefaultArgument(Param, DefaultArg, new SourceLocation(EqualLoc));
}


/// ActOnParamUnparsedDefaultArgument - We've seen a default
/// argument for a function parameter, but we can't parse it yet
/// because we're inside a class definition. Note that this default
/// argument will be parsed later.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnParamUnparsedDefaultArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 342,
 FQN="clang::Sema::ActOnParamUnparsedDefaultArgument", NM="_ZN5clang4Sema33ActOnParamUnparsedDefaultArgumentEPNS_4DeclENS_14SourceLocationES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema33ActOnParamUnparsedDefaultArgumentEPNS_4DeclENS_14SourceLocationES3_")
//</editor-fold>
public final void ActOnParamUnparsedDefaultArgument(Decl /*P*/ param, 
                                 SourceLocation EqualLoc, 
                                 SourceLocation ArgLoc) {
  if (!(param != null)) {
    return;
  }
  
  ParmVarDecl /*P*/ Param = cast_ParmVarDecl(param);
  Param.setUnparsedDefaultArg();
  $this().UnparsedDefaultArgLocs.$at_T1$C$R(Param).$assign(ArgLoc);
}


/// ActOnParamDefaultArgumentError - Parsing or semantic analysis of
/// the default argument for the parameter param failed.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnParamDefaultArgumentError">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 355,
 FQN="clang::Sema::ActOnParamDefaultArgumentError", NM="_ZN5clang4Sema30ActOnParamDefaultArgumentErrorEPNS_4DeclENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema30ActOnParamDefaultArgumentErrorEPNS_4DeclENS_14SourceLocationE")
//</editor-fold>
public final void ActOnParamDefaultArgumentError(Decl /*P*/ param, 
                              SourceLocation EqualLoc) {
  if (!(param != null)) {
    return;
  }
  
  ParmVarDecl /*P*/ Param = cast_ParmVarDecl(param);
  Param.setInvalidDecl();
  $this().UnparsedDefaultArgLocs.erase(Param);
  Param.setDefaultArg(/*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new OpaqueValueExpr(new SourceLocation(EqualLoc), 
                  Param.getType().getNonReferenceType(), 
                  ExprValueKind.VK_RValue);
       }));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::SetParamDefaultArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 247,
 FQN="clang::Sema::SetParamDefaultArgument", NM="_ZN5clang4Sema23SetParamDefaultArgumentEPNS_11ParmVarDeclEPNS_4ExprENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema23SetParamDefaultArgumentEPNS_11ParmVarDeclEPNS_4ExprENS_14SourceLocationE")
//</editor-fold>
public final boolean SetParamDefaultArgument(ParmVarDecl /*P*/ Param, Expr /*P*/ Arg, 
                       SourceLocation EqualLoc) {
  InitializationSequence InitSeq = null;
  try {
    if ($this().RequireCompleteType(Param.getLocation(), Param.getType(), 
        diag.err_typecheck_decl_incomplete_type)) {
      Param.setInvalidDecl();
      return true;
    }
    
    // C++ [dcl.fct.default]p5
    //   A default argument expression is implicitly converted (clause
    //   4) to the parameter type. The default argument expression has
    //   the same semantic constraints as the initializer expression in
    //   a declaration of a variable of the parameter type, using the
    //   copy-initialization semantics (8.5).
    InitializedEntity Entity = InitializedEntity.InitializeParameter($this().Context, 
        Param);
    InitializationKind Kind = InitializationKind.CreateCopy(Param.getLocation(), 
        new SourceLocation(EqualLoc));
    InitSeq/*J*/= new InitializationSequence(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(Arg, true));
    ActionResultTTrue<Expr /*P*/ > Result = InitSeq.Perform(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(Arg, true));
    if (Result.isInvalid()) {
      return true;
    }
    Arg = Result.getAs(Expr.class);
    
    $this().CheckCompletedExpr(Arg, new SourceLocation(EqualLoc));
    Arg = $this().MaybeCreateExprWithCleanups(Arg);
    
    // Okay: add the default argument to the parameter
    Param.setDefaultArg(Arg);
    
    // We have already instantiated this parameter; provide each of the 
    // instantiations with the uninstantiated default argument.
    DenseMapIterator<ParmVarDecl /*P*/ , TinyPtrVector<ParmVarDecl /*P*/ >> InstPos = $this().UnparsedDefaultArgInstantiations.find(Param);
    if (InstPos.$noteq(/*NO_ITER_COPY*/$this().UnparsedDefaultArgInstantiations.end())) {
      for (/*uint*/int I = 0, N = InstPos.$arrow().second.size(); I != N; ++I)  {
        InstPos.$arrow().second.$at(I).setUninstantiatedDefaultArg(Arg);
      }
      
      // We're done tracking this parameter's instantiations.
      $this().UnparsedDefaultArgInstantiations.erase(new DenseMapIterator<ParmVarDecl /*P*/ , TinyPtrVector<ParmVarDecl /*P*/ >>(InstPos));
    }
    
    return false;
  } finally {
    if (InitSeq != null) { InitSeq.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPureSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13292,
 FQN="clang::Sema::ActOnPureSpecifier", NM="_ZN5clang4Sema18ActOnPureSpecifierEPNS_4DeclENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema18ActOnPureSpecifierEPNS_4DeclENS_14SourceLocationE")
//</editor-fold>
public final void ActOnPureSpecifier(Decl /*P*/ D, SourceLocation ZeroLoc) {
  if ((D.getFriendObjectKind().getValue() != 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(D.getLocation(), diag.err_pure_friend)));
    } finally {
      $c$.$destroy();
    }
  } else {
    CXXMethodDecl /*P*/ M = dyn_cast_CXXMethodDecl(D);
    if ((M != null)) {
      $this().CheckPureMethod(M, new SourceRange(/*NO_COPY*/ZeroLoc));
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(D.getLocation(), diag.err_illegal_initializer)));
      } finally {
        $c$.$destroy();
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::SetDeclDeleted">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13019,
 FQN="clang::Sema::SetDeclDeleted", NM="_ZN5clang4Sema14SetDeclDeletedEPNS_4DeclENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema14SetDeclDeletedEPNS_4DeclENS_14SourceLocationE")
//</editor-fold>
public final void SetDeclDeleted(Decl /*P*/ _Dcl, SourceLocation DelLoc) {
  type$ref<Decl /*P*/> Dcl = create_type$ref(_Dcl);
  $this().AdjustDeclIfTemplate(Dcl);
  
  FunctionDecl /*P*/ Fn = dyn_cast_or_null_FunctionDecl(Dcl.$deref());
  if (!(Fn != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(DelLoc), diag.err_deleted_non_function)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  {
    
    /*const*/ FunctionDecl /*P*/ Prev = Fn.getPreviousDecl$Redeclarable();
    if ((Prev != null)) {
      // Don't consider the implicit declaration we generate for explicit
      // specializations. FIXME: Do not generate these implicit declarations.
      if ((Prev.getTemplateSpecializationKind() != TemplateSpecializationKind.TSK_ExplicitSpecialization
         || (Prev.getPreviousDecl$Redeclarable$Const() != null))
         && !Prev.isDefined()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(DelLoc), diag.err_deleted_decl_not_first)));
          $c$.clean($c$.track($this().Diag(Prev.getLocation().isInvalid() ? new SourceLocation(DelLoc) : Prev.getLocation(), 
              Prev.isImplicit() ? diag.note_previous_implicit_declaration : diag.note_previous_declaration)));
        } finally {
          $c$.$destroy();
        }
      }
      // If the declaration wasn't the first, we delete the function anyway for
      // recovery.
      Fn = Fn.getCanonicalDecl();
    }
  }
  {
    
    // dllimport/dllexport cannot be deleted.
    /*const*/ InheritableAttr /*P*/ DLLAttr = getDLLAttr(Fn);
    if ((DLLAttr != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder_Attr($c$.track($this().Diag(Fn.getLocation(), diag.err_attribute_dll_deleted)), DLLAttr));
        Fn.setInvalidDecl();
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (Fn.isDeleted()) {
    return;
  }
  {
    
    // See if we're deleting a function which is already known to override a
    // non-deleted virtual function.
    /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(Fn);
    if ((MD != null)) {
      boolean IssuedDiagnostic = false;
      for (type$ptr<CXXMethodDecl>/*method_iterator*/ I = $tryClone(MD.begin_overridden_methods()), 
          /*P*/ /*const*/ /*P*/ E = $tryClone(MD.end_overridden_methods());
           $noteq_ptr(I, E); I.$preInc()) {
        if (!(MD.begin_overridden_methods().$star()).isDeleted()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            if (!IssuedDiagnostic) {
              $c$.clean($out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag(new SourceLocation(DelLoc), diag.err_deleted_override)), MD.getDeclName()));
              IssuedDiagnostic = true;
            }
            $c$.clean($c$.track($this().Diag((I.$star()).getLocation(), diag.note_overridden_virtual_function)));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  
  // C++11 [basic.start.main]p3:
  //   A program that defines main as deleted [...] is ill-formed.
  if (Fn.isMain()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(DelLoc), diag.err_deleted_main)));
    } finally {
      $c$.$destroy();
    }
  }
  
  Fn.setDeletedAsWritten();
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::SetDeclDefaulted">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13078,
 FQN="clang::Sema::SetDeclDefaulted", NM="_ZN5clang4Sema16SetDeclDefaultedEPNS_4DeclENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema16SetDeclDefaultedEPNS_4DeclENS_14SourceLocationE")
//</editor-fold>
public final void SetDeclDefaulted(Decl /*P*/ Dcl, SourceLocation DefaultLoc) {
  CXXMethodDecl /*P*/ MD = dyn_cast_or_null_CXXMethodDecl(Dcl);
  if ((MD != null)) {
    if (MD.getParent().isDependentType()) {
      MD.setDefaulted();
      MD.setExplicitlyDefaulted();
      return;
    }
    
    CXXSpecialMember Member = $this().getSpecialMember(MD);
    if (Member == CXXSpecialMember.CXXInvalid) {
      if (!MD.isInvalidDecl()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(DefaultLoc), diag.err_default_special_members)));
        } finally {
          $c$.$destroy();
        }
      }
      return;
    }
    
    MD.setDefaulted();
    MD.setExplicitlyDefaulted();
    
    // If this definition appears within the record, do the checking when
    // the record is complete.
    /*const*/ FunctionDecl /*P*/ Primary = MD;
    {
      /*const*/ FunctionDecl /*P*/ Pattern = MD.getTemplateInstantiationPattern();
      if ((Pattern != null)) {
        // Ask the template instantiation pattern that actually had the
        // '= default' on it.
        Primary = Pattern;
      }
    }
    
    // If the method was defaulted on its first declaration, we will have
    // already performed the checking in CheckCompletedCXXClass. Such a
    // declaration doesn't trigger an implicit definition.
    if (Primary.getCanonicalDecl$Const().isDefaulted()) {
      return;
    }
    
    $this().CheckExplicitlyDefaultedSpecialMember(MD);
    if (!MD.isInvalidDecl()) {
      DefineImplicitSpecialMember(/*Deref*/$this(), MD, new SourceLocation(DefaultLoc));
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(DefaultLoc), diag.err_default_special_members)));
    } finally {
      $c$.$destroy();
    }
  }
}


/// \brief Handle a C++11 empty-declaration and attribute-declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnEmptyDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 12168,
 FQN="clang::Sema::ActOnEmptyDeclaration", NM="_ZN5clang4Sema21ActOnEmptyDeclarationEPNS_5ScopeEPNS_13AttributeListENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema21ActOnEmptyDeclarationEPNS_5ScopeEPNS_13AttributeListENS_14SourceLocationE")
//</editor-fold>
public final Decl /*P*/ ActOnEmptyDeclaration(Scope /*P*/ S, 
                     AttributeList /*P*/ AttrList, 
                     SourceLocation SemiLoc) {
  Decl /*P*/ ED = EmptyDecl.Create($this().Context, $this().CurContext, new SourceLocation(SemiLoc));
  // Attribute declarations appertain to empty declaration so we handle
  // them here.
  if ((AttrList != null)) {
    $this().ProcessDeclAttributeList(S, ED, AttrList);
  }
  
  $this().CurContext.addDecl(ED);
  return ED;
}


/// Handle a friend tag declaration where the scope specifier was
/// templated.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnTemplatedFriendTag">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 12491,
 FQN="clang::Sema::ActOnTemplatedFriendTag", NM="_ZN5clang4Sema23ActOnTemplatedFriendTagEPNS_5ScopeENS_14SourceLocationEjS3_RNS_12CXXScopeSpecEPNS_14IdentifierInfoES3_PNS_13AttributeListEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema23ActOnTemplatedFriendTagEPNS_5ScopeENS_14SourceLocationEjS3_RNS_12CXXScopeSpecEPNS_14IdentifierInfoES3_PNS_13AttributeListEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEE")
//</editor-fold>
public final Decl /*P*/ ActOnTemplatedFriendTag(Scope /*P*/ S, SourceLocation FriendLoc, 
                       /*uint*/int TagSpec, SourceLocation TagLoc, 
                       final CXXScopeSpec /*&*/ SS, 
                       IdentifierInfo /*P*/ Name, 
                       SourceLocation NameLoc, 
                       AttributeList /*P*/ Attr, 
                       MutableArrayRef<TemplateParameterList /*P*/ > TempParamLists) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    TagTypeKind Kind = TypeWithKeyword.getTagTypeKindForTypeSpec(TagSpec);
    
    bool$ref isExplicitSpecialization = create_bool$ref(false);
    bool$ref Invalid = create_bool$ref(false);
    {
      
      TemplateParameterList /*P*/ TemplateParams = $this().MatchTemplateParametersToScopeSpecifier(new SourceLocation(TagLoc), new SourceLocation(NameLoc), SS, (TemplateIdAnnotation /*P*/ )null, new ArrayRef<TemplateParameterList /*P*/ >(TempParamLists), /*friend*/ true, 
          isExplicitSpecialization, Invalid);
      if ((TemplateParams != null)) {
        if ($greater_uint(TemplateParams.size(), 0)) {
          // This is a declaration of a class template.
          if (Invalid.$deref()) {
            return null;
          }
          
          return $this().CheckClassTemplate(S, TagSpec, TagUseKind.TUK_Friend, new SourceLocation(TagLoc), SS, Name, 
              new SourceLocation(NameLoc), Attr, TemplateParams, AccessSpecifier.AS_public, 
              /*ModulePrivateLoc=*/ new SourceLocation(), 
              new SourceLocation(FriendLoc), TempParamLists.size() - 1, 
              TempParamLists.data()).get();
        } else {
          // The "template<>" header is extraneous.
          $c$.clean($out_SemaDiagnosticBuilder_II($out_SemaDiagnosticBuilder_StringRef($c$.track($this().Diag(TemplateParams.getTemplateLoc(), diag.err_template_tag_noparams)), 
                  TypeWithKeyword.getTagTypeKindName(Kind)), Name));
          isExplicitSpecialization.$set(true);
        }
      }
    }
    if (Invalid.$deref()) {
      return null;
    }
    
    boolean isAllExplicitSpecializations = true;
    for (/*uint*/int I = TempParamLists.size(); $greater_uint(I--, 0);) {
      if ((TempParamLists.$at(I).size() != 0)) {
        isAllExplicitSpecializations = false;
        break;
      }
    }
    
    // FIXME: don't ignore attributes.
    
    // If it's explicit specializations all the way down, just forget
    // about the template header and build an appropriate non-templated
    // friend.  TODO: for source fidelity, remember the headers.
    if (isAllExplicitSpecializations) {
      if (SS.isEmpty()) {
        bool$ref Owned = create_bool$ref(false);
        bool$ref IsDependent = create_bool$ref(false);
        return $this().ActOnTag(S, TagSpec, TagUseKind.TUK_Friend, new SourceLocation(TagLoc), SS, Name, new SourceLocation(NameLoc), 
            Attr, AccessSpecifier.AS_public, 
            /*ModulePrivateLoc=*/ new SourceLocation(), 
            new MutableArrayRef<TemplateParameterList /*P*/ >(true), Owned, IsDependent, 
            /*ScopedEnumKWLoc=*/ new SourceLocation(), 
            /*ScopedEnumUsesClassTag=*/ false, 
            /*UnderlyingType=*/ new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, new OpaquePtr<QualType>()), // ActionResult for POD type must be initied
            /*IsTypeSpecifier=*/ false);
      }
      
      NestedNameSpecifierLoc QualifierLoc = SS.getWithLocInContext($this().Context);
      ElaboratedTypeKeyword Keyword = TypeWithKeyword.getKeywordForTagTypeKind(Kind);
      QualType T = $this().CheckTypenameType(Keyword, new SourceLocation(TagLoc), new NestedNameSpecifierLoc(QualifierLoc), 
          $Deref(Name), new SourceLocation(NameLoc));
      if (T.isNull()) {
        return null;
      }
      
      TypeSourceInfo /*P*/ TSI = $this().Context.CreateTypeSourceInfo(new QualType(T));
      if (isa_DependentNameType(T)) {
        DependentNameTypeLoc TL = TSI.getTypeLoc().castAs(DependentNameTypeLoc.class);
        TL.setElaboratedKeywordLoc(/*NO_COPY*/TagLoc);
        TL.setQualifierLoc(/*NO_COPY*/QualifierLoc);
        TL.setNameLoc(/*NO_COPY*/NameLoc);
      } else {
        ElaboratedTypeLoc TL = TSI.getTypeLoc().castAs(ElaboratedTypeLoc.class);
        TL.setElaboratedKeywordLoc(/*NO_COPY*/TagLoc);
        TL.setQualifierLoc(/*NO_COPY*/QualifierLoc);
        TL.getNamedTypeLoc().castAs(TypeSpecTypeLoc.class).setNameLoc(/*NO_COPY*/NameLoc);
      }
      
      FriendDecl /*P*/ Friend = FriendDecl.Create($this().Context, $this().CurContext, new SourceLocation(NameLoc), 
          new PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ >(JD$T1.INSTANCE, TypeSourceInfo /*P*/.class, TSI), new SourceLocation(FriendLoc), new ArrayRef<TemplateParameterList /*P*/ >(TempParamLists));
      Friend.setAccess(AccessSpecifier.AS_public);
      $this().CurContext.addDecl(Friend);
      return Friend;
    }
    assert (SS.isNotEmpty()) : "valid templated tag with no SS and no direct?";
    
    // Handle the case of a templated-scope friend class.  e.g.
    //   template <class T> class A<T>::B;
    // FIXME: we don't support these right now.
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_SourceRange($out_SemaDiagnosticBuilder_NestedNameSpec($c$.track($this().Diag(new SourceLocation(NameLoc), diag.warn_template_qualified_friend_unsupported)), 
                SS.getScopeRep()), SS.getRange()), cast_CXXRecordDecl($this().CurContext)));
    ElaboratedTypeKeyword ETK = TypeWithKeyword.getKeywordForTagTypeKind(Kind);
    QualType T = $this().Context.getDependentNameType(ETK, SS.getScopeRep(), Name);
    TypeSourceInfo /*P*/ TSI = $this().Context.CreateTypeSourceInfo(new QualType(T));
    DependentNameTypeLoc TL = TSI.getTypeLoc().castAs(DependentNameTypeLoc.class);
    TL.setElaboratedKeywordLoc(/*NO_COPY*/TagLoc);
    TL.setQualifierLoc(SS.getWithLocInContext($this().Context));
    TL.setNameLoc(/*NO_COPY*/NameLoc);
    
    FriendDecl /*P*/ Friend = FriendDecl.Create($this().Context, $this().CurContext, new SourceLocation(NameLoc), 
        new PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ >(JD$T1.INSTANCE, TypeSourceInfo /*P*/.class, TSI), new SourceLocation(FriendLoc), new ArrayRef<TemplateParameterList /*P*/ >(TempParamLists));
    Friend.setAccess(AccessSpecifier.AS_public);
    Friend.setUnsupportedFriend(true);
    $this().CurContext.addDecl(Friend);
    return Friend;
  } finally {
    $c$.$destroy();
  }
}


/// HandleMSProperty - Analyze a __delcspec(property) field of a C++ class.
///
//<editor-fold defaultstate="collapsed" desc="clang::Sema::HandleMSProperty">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13947,
 FQN="clang::Sema::HandleMSProperty", NM="_ZN5clang4Sema16HandleMSPropertyEPNS_5ScopeEPNS_10RecordDeclENS_14SourceLocationERNS_10DeclaratorEPNS_4ExprENS_16InClassInitStyleENS_15AccessSpecifierEPNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema16HandleMSPropertyEPNS_5ScopeEPNS_10RecordDeclENS_14SourceLocationERNS_10DeclaratorEPNS_4ExprENS_16InClassInitStyleENS_15AccessSpecifierEPNS_13AttributeListE")
//</editor-fold>
public final MSPropertyDecl /*P*/ HandleMSProperty(Scope /*P*/ S, RecordDecl /*P*/ Record, 
                SourceLocation DeclStart, 
                final Declarator /*&*/ D, Expr /*P*/ BitWidth, 
                InClassInitStyle InitStyle, 
                AccessSpecifier AS, 
                AttributeList /*P*/ MSPropertyAttr) {
  LookupResult Previous = null;
  try {
    IdentifierInfo /*P*/ II = D.getIdentifier();
    if (!(II != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(DeclStart), diag.err_anonymous_property)));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    SourceLocation Loc = D.getIdentifierLoc();
    
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
    
    $this().DiagnoseFunctionSpecifiers(D.getDeclSpec());
    if (D.getDeclSpec().isInlineSpecified()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder_uint($c$.track($this().Diag(D.getDeclSpec().getInlineSpecLoc(), diag.err_inline_non_function)), 
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
          $c$.clean($out_SemaDiagnosticBuilder_char$ptr$C($c$.track($this().Diag(D.getDeclSpec().getThreadStorageClassSpecLoc(), 
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
    if ((PrevDecl != null) && PrevDecl.isTemplateParameter()) {
      // Maybe we will complain about the shadowed template parameter.
      $this().DiagnoseTemplateParameterShadow(D.getIdentifierLoc(), PrevDecl);
      // Just pretend that we didn't see the previous declaration.
      PrevDecl = null;
    }
    if ((PrevDecl != null) && !$this().isDeclInScope(PrevDecl, Record, S)) {
      PrevDecl = null;
    }
    
    SourceLocation TSSL = D.getLocStart();
    final /*const*/ AttributeList.PropertyData /*&*/ Data = MSPropertyAttr.getPropertyData();
    MSPropertyDecl /*P*/ NewPD = MSPropertyDecl.Create($this().Context, Record, new SourceLocation(Loc), new DeclarationName(II), new QualType(T), TInfo, new SourceLocation(TSSL), Data.GetterId, Data.SetterId);
    $this().ProcessDeclAttributes($this().TUScope, NewPD, D);
    NewPD.setAccess(AS);
    if (NewPD.isInvalidDecl()) {
      Record.setInvalidDecl();
    }
    if (D.getDeclSpec().isModulePrivateSpecified()) {
      NewPD.setModulePrivate();
    }
    if (NewPD.isInvalidDecl() && (PrevDecl != null)) {
      // Don't introduce NewFD into scope; there's already something
      // with the same name in the same scope.
    } else if ((II != null)) {
      $this().PushOnScopeChains(NewPD, S);
    } else {
      Record.addDecl(NewPD);
    }
    
    return NewPD;
  } finally {
    if (Previous != null) { Previous.$destroy(); }
  }
}


/// Diagnose why the specified class does not have a trivial special member of
/// the given kind.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseNontrivial">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6283,
 FQN="clang::Sema::DiagnoseNontrivial", NM="_ZN5clang4Sema18DiagnoseNontrivialEPKNS_13CXXRecordDeclENS0_16CXXSpecialMemberE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema18DiagnoseNontrivialEPKNS_13CXXRecordDeclENS0_16CXXSpecialMemberE")
//</editor-fold>
public final void DiagnoseNontrivial(/*const*/ CXXRecordDecl /*P*/ RD, CXXSpecialMember CSM) {
  QualType Ty = $this().Context.getRecordType(RD);
  
  boolean ConstArg = (CSM == CXXSpecialMember.CXXCopyConstructor || CSM == CXXSpecialMember.CXXCopyAssignment);
  checkTrivialSubobjectCall(/*Deref*/$this(), RD.getLocation(), new QualType(Ty), ConstArg, CSM, 
      TrivialSubobjectKind.TSK_CompleteObject, /*Diagnose*/ true);
}


/// Determine whether a defaulted or deleted special member function is trivial,
/// as specified in C++11 [class.ctor]p5, C++11 [class.copy]p12,
/// C++11 [class.copy]p25, and C++11 [class.dtor]p5.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SpecialMemberIsTrivial">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6294,
 FQN="clang::Sema::SpecialMemberIsTrivial", NM="_ZN5clang4Sema22SpecialMemberIsTrivialEPNS_13CXXMethodDeclENS0_16CXXSpecialMemberEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema22SpecialMemberIsTrivialEPNS_13CXXMethodDeclENS0_16CXXSpecialMemberEb")
//</editor-fold>
public final boolean SpecialMemberIsTrivial(CXXMethodDecl /*P*/ MD, CXXSpecialMember CSM) {
  return SpecialMemberIsTrivial(MD, CSM, 
                      false);
}
public final boolean SpecialMemberIsTrivial(CXXMethodDecl /*P*/ MD, CXXSpecialMember CSM, 
                      boolean Diagnose/*= false*/) {
  assert (!MD.isUserProvided() && CSM != CXXSpecialMember.CXXInvalid) : "not special enough";
  
  CXXRecordDecl /*P*/ RD = MD.getParent();
  
  boolean ConstArg = false;
  
  // C++11 [class.copy]p12, p25: [DR1593]
  //   A [special member] is trivial if [...] its parameter-type-list is
  //   equivalent to the parameter-type-list of an implicit declaration [...]
  switch (CSM) {
   case CXXDefaultConstructor:
   case CXXDestructor:
    // Trivial default constructors and destructors cannot have parameters.
    break;
   case CXXCopyConstructor:
   case CXXCopyAssignment:
    {
      // Trivial copy operations always have const, non-volatile parameter types.
      ConstArg = true;
      /*const*/ ParmVarDecl /*P*/ Param0 = MD.getParamDecl(0);
      /*const*/ ReferenceType /*P*/ RT = Param0.getType().$arrow().getAs(ReferenceType.class);
      if (!(RT != null) || RT.getPointeeType().getCVRQualifiers() != Qualifiers.TQ.Const) {
        if (Diagnose) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder_CanQual($out_SemaDiagnosticBuilder_CanQual($out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(Param0.getLocation(), diag.note_nontrivial_param_type)), 
                        Param0.getSourceRange()), Param0.getType()), 
                $this().Context.getLValueReferenceType($this().Context.getRecordType(RD).withConst())));
          } finally {
            $c$.$destroy();
          }
        }
        return false;
      }
      break;
    }
   case CXXMoveConstructor:
   case CXXMoveAssignment:
    {
      // Trivial move operations always have non-cv-qualified parameters.
      /*const*/ ParmVarDecl /*P*/ Param0 = MD.getParamDecl(0);
      /*const*/ RValueReferenceType /*P*/ RT = Param0.getType().$arrow().getAs(RValueReferenceType.class);
      if (!(RT != null) || (RT.getPointeeType().getCVRQualifiers() != 0)) {
        if (Diagnose) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder_CanQual($out_SemaDiagnosticBuilder_CanQual($out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(Param0.getLocation(), diag.note_nontrivial_param_type)), 
                        Param0.getSourceRange()), Param0.getType()), 
                $this().Context.getRValueReferenceType($this().Context.getRecordType(RD))));
          } finally {
            $c$.$destroy();
          }
        }
        return false;
      }
      break;
    }
   case CXXInvalid:
    throw new llvm_unreachable("not a special member");
  }
  if ($less_uint(MD.getMinRequiredArguments(), MD.getNumParams())) {
    if (Diagnose) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(MD.getParamDecl(MD.getMinRequiredArguments()).getLocation(), 
                diag.note_nontrivial_default_arg)), 
            MD.getParamDecl(MD.getMinRequiredArguments()).getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  if (MD.isVariadic()) {
    if (Diagnose) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(MD.getLocation(), diag.note_nontrivial_variadic)));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  
  // C++11 [class.ctor]p5, C++11 [class.dtor]p5:
  //   A copy/move [constructor or assignment operator] is trivial if
  //    -- the [member] selected to copy/move each direct base class subobject
  //       is trivial
  //
  // C++11 [class.copy]p12, C++11 [class.copy]p25:
  //   A [default constructor or destructor] is trivial if
  //    -- all the direct base classes have trivial [default constructors or
  //       destructors]
  for (final /*const*/ CXXBaseSpecifier /*&*/ BI : RD.bases())  {
    if (!checkTrivialSubobjectCall(/*Deref*/$this(), BI.getLocStart(), BI.getType(), 
        ConstArg, CSM, TrivialSubobjectKind.TSK_BaseClass, Diagnose)) {
      return false;
    }
  }
  
  // C++11 [class.ctor]p5, C++11 [class.dtor]p5:
  //   A copy/move [constructor or assignment operator] for a class X is
  //   trivial if
  //    -- for each non-static data member of X that is of class type (or array
  //       thereof), the constructor selected to copy/move that member is
  //       trivial
  //
  // C++11 [class.copy]p12, C++11 [class.copy]p25:
  //   A [default constructor or destructor] is trivial if
  //    -- for all of the non-static data members of its class that are of class
  //       type (or array thereof), each such class has a trivial [default
  //       constructor or destructor]
  if (!checkTrivialClassMembers(/*Deref*/$this(), RD, CSM, ConstArg, Diagnose)) {
    return false;
  }
  
  // C++11 [class.dtor]p5:
  //   A destructor is trivial if [...]
  //    -- the destructor is not virtual
  if (CSM == CXXSpecialMember.CXXDestructor && MD.isVirtual()) {
    if (Diagnose) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MD.getLocation(), diag.note_nontrivial_virtual_dtor)), RD));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  
  // C++11 [class.ctor]p5, C++11 [class.copy]p12, C++11 [class.copy]p25:
  //   A [special member] for class X is trivial if [...]
  //    -- class X has no virtual functions and no virtual base classes
  if (CSM != CXXSpecialMember.CXXDestructor && MD.getParent().isDynamicClass()) {
    if (!Diagnose) {
      return false;
    }
    if ((RD.getNumVBases() != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Check for virtual bases. We already know that the corresponding
        // member in all bases is trivial, so vbases must all be direct.
        final CXXBaseSpecifier /*&*/ BS = RD.vbases_begin().$star();
        assert (BS.isVirtual());
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(BS.getLocStart(), diag.note_nontrivial_has_virtual)), RD), 1));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Must have a virtual method.
    for (/*const*/ CXXMethodDecl /*P*/ MI : RD.methods()) {
      if (MI.isVirtual()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SourceLocation MLoc = MI.getLocStart();
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(MLoc), diag.note_nontrivial_has_virtual)), RD), 0));
          return false;
        } finally {
          $c$.$destroy();
        }
      }
    }
    throw new llvm_unreachable("dynamic class with no vbases and no virtual functions");
  }
  
  // Looks like it's trivial!
  return true;
}


/// \brief Merge the exception specifications of two variable declarations.
///
/// This is called when there's a redeclaration of a VarDecl. The function
/// checks if the redeclaration might have an exception specification and
/// validates compatibility and merges the specs if necessary.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MergeVarDeclExceptionSpecs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 672,
 FQN="clang::Sema::MergeVarDeclExceptionSpecs", NM="_ZN5clang4Sema26MergeVarDeclExceptionSpecsEPNS_7VarDeclES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema26MergeVarDeclExceptionSpecsEPNS_7VarDeclES2_")
//</editor-fold>
public final void MergeVarDeclExceptionSpecs(VarDecl /*P*/ New, VarDecl /*P*/ Old) {
  // Shortcut if exceptions are disabled.
  if (!$this().getLangOpts().CXXExceptions) {
    return;
  }
  assert ($this().Context.hasSameType(New.getType(), Old.getType())) : "Should only be called if types are otherwise the same.";
  
  QualType NewType = New.getType();
  QualType OldType = Old.getType();
  {
    
    // We're only interested in pointers and references to functions, as well
    // as pointers to member functions.
    /*const*/ ReferenceType /*P*/ R = NewType.$arrow().getAs(ReferenceType.class);
    if ((R != null)) {
      NewType.$assignMove(R.getPointeeType());
      OldType.$assignMove(OldType.$arrow().getAs(ReferenceType.class).getPointeeType());
    } else {
      /*const*/ PointerType /*P*/ P = NewType.$arrow().getAs(PointerType.class);
      if ((P != null)) {
        NewType.$assignMove(P.getPointeeType());
        OldType.$assignMove(OldType.$arrow().getAs(PointerType.class).getPointeeType());
      } else {
        /*const*/ MemberPointerType /*P*/ M = NewType.$arrow().getAs(MemberPointerType.class);
        if ((M != null)) {
          NewType.$assignMove(M.getPointeeType());
          OldType.$assignMove(OldType.$arrow().getAs(MemberPointerType.class).getPointeeType());
        }
      }
    }
  }
  if (!NewType.$arrow().isFunctionProtoType()) {
    return;
  }
  
  // There's lots of special cases for functions. For function pointers, system
  // libraries are hopefully not as broken so that we don't need these
  // workarounds.
  if ($this().CheckEquivalentExceptionSpec(OldType.$arrow().getAs(FunctionProtoType.class), Old.getLocation(), 
      NewType.$arrow().getAs(FunctionProtoType.class), New.getLocation())) {
    New.setInvalidDecl();
  }
}


/// MergeCXXFunctionDecl - Merge two declarations of the same C++
/// function, once we already know that they have the same
/// type. Subroutine of MergeFunctionDecl. Returns true if there was an
/// error, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MergeCXXFunctionDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 435,
 FQN="clang::Sema::MergeCXXFunctionDecl", NM="_ZN5clang4Sema20MergeCXXFunctionDeclEPNS_12FunctionDeclES2_PNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema20MergeCXXFunctionDeclEPNS_12FunctionDeclES2_PNS_5ScopeE")
//</editor-fold>
public final boolean MergeCXXFunctionDecl(FunctionDecl /*P*/ New, FunctionDecl /*P*/ Old, 
                    Scope /*P*/ S) {
  boolean Invalid = false;
  
  // The declaration context corresponding to the scope is the semantic
  // parent, unless this is a local function declaration, in which case
  // it is that surrounding function.
  DeclContext /*P*/ ScopeDC = New.isLocalExternDecl() ? New.getLexicalDeclContext() : New.getDeclContext();
  
  // Find the previous declaration for the purpose of default arguments.
  FunctionDecl /*P*/ PrevForDefaultArgs = Old;
  for (; (PrevForDefaultArgs != null);
      // Don't bother looking back past the latest decl if this is a local
      // extern declaration; nothing else could work.
       PrevForDefaultArgs = New.isLocalExternDecl() ? null : PrevForDefaultArgs.getPreviousDecl$Redeclarable()) {
    // Ignore hidden declarations.
    if (!LookupResult.isVisible(/*Deref*/$this(), PrevForDefaultArgs)) {
      continue;
    }
    if ((S != null) && !$this().isDeclInScope(PrevForDefaultArgs, ScopeDC, S)
       && !New.isCXXClassMember()) {
      // Ignore default arguments of old decl if they are not in
      // the same scope and this is not an out-of-line definition of
      // a member function.
      continue;
    }
    if (PrevForDefaultArgs.isLocalExternDecl() != New.isLocalExternDecl()) {
      // If only one of these is a local function declaration, then they are
      // declared in different scopes, even though isDeclInScope may think
      // they're in the same scope. (If both are local, the scope check is
      // sufficent, and if neither is local, then they are in the same scope.)
      continue;
    }
    
    // We found the right previous declaration.
    break;
  }
  
  // C++ [dcl.fct.default]p4:
  //   For non-template functions, default arguments can be added in
  //   later declarations of a function in the same
  //   scope. Declarations in different scopes have completely
  //   distinct sets of default arguments. That is, declarations in
  //   inner scopes do not acquire default arguments from
  //   declarations in outer scopes, and vice versa. In a given
  //   function declaration, all parameters subsequent to a
  //   parameter with a default argument shall have default
  //   arguments supplied in this or previous declarations. A
  //   default argument shall not be redefined by a later
  //   declaration (not even to the same value).
  //
  // C++ [dcl.fct.default]p6:
  //   Except for member functions of class templates, the default arguments
  //   in a member function definition that appears outside of the class
  //   definition are added to the set of default arguments provided by the
  //   member function declaration in the class definition.
  for (/*uint*/int p = 0, NumParams = (PrevForDefaultArgs != null) ? PrevForDefaultArgs.getNumParams() : 0;
       $less_uint(p, NumParams); ++p) {
    ParmVarDecl /*P*/ OldParam = PrevForDefaultArgs.getParamDecl(p);
    ParmVarDecl /*P*/ NewParam = New.getParamDecl(p);
    
    boolean OldParamHasDfl = (OldParam != null) ? OldParam.hasDefaultArg() : false;
    boolean NewParamHasDfl = NewParam.hasDefaultArg();
    if (OldParamHasDfl && NewParamHasDfl) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*uint*/int DiagDefaultParamID = diag.err_param_default_argument_redefinition;
        
        // MSVC accepts that default parameters be redefined for member functions
        // of template class. The new default parameter's value is ignored.
        Invalid = true;
        if ($this().getLangOpts().MicrosoftExt) {
          CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(New);
          if ((MD != null) && (MD.getParent().getDescribedClassTemplate() != null)) {
            // Merge the old default argument into the new parameter.
            NewParam.setHasInheritedDefaultArg();
            if (OldParam.hasUninstantiatedDefaultArg()) {
              NewParam.setUninstantiatedDefaultArg(OldParam.getUninstantiatedDefaultArg());
            } else {
              NewParam.setDefaultArg(OldParam.getInit());
            }
            DiagDefaultParamID = diag.ext_param_default_argument_redefinition;
            Invalid = false;
          }
        }
        
        // FIXME: If we knew where the '=' was, we could easily provide a fix-it 
        // hint here. Alternatively, we could walk the type-source information
        // for NewParam to find the last source location in the type... but it
        // isn't worth the effort right now. This is the kind of test case that
        // is hard to get right:
        //   int f(int);
        //   void g(int (*fp)(int) = f);
        //   void g(int (*fp)(int) = &f);
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(NewParam.getLocation(), DiagDefaultParamID)), 
            NewParam.getDefaultArgRange()));
        
        // Look for the function declaration where the default argument was
        // actually written, which may be a declaration prior to Old.
        for (FunctionDecl /*P*/ Older = PrevForDefaultArgs;
             OldParam.hasInheritedDefaultArg();) {
          Older = Older.getPreviousDecl$Redeclarable();
          OldParam = Older.getParamDecl(p);
        }
        
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(OldParam.getLocation(), diag.note_previous_definition)), 
            OldParam.getDefaultArgRange()));
      } finally {
        $c$.$destroy();
      }
    } else if (OldParamHasDfl) {
      // Merge the old default argument into the new parameter.
      // It's important to use getInit() here;  getDefaultArg()
      // strips off any top-level ExprWithCleanups.
      NewParam.setHasInheritedDefaultArg();
      if (OldParam.hasUnparsedDefaultArg()) {
        NewParam.setUnparsedDefaultArg();
      } else if (OldParam.hasUninstantiatedDefaultArg()) {
        NewParam.setUninstantiatedDefaultArg(OldParam.getUninstantiatedDefaultArg());
      } else {
        NewParam.setDefaultArg(OldParam.getInit());
      }
    } else if (NewParamHasDfl) {
      if ((New.getDescribedFunctionTemplate() != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Paragraph 4, quoted above, only applies to non-template functions.
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(NewParam.getLocation(), 
                  diag.err_param_default_argument_template_redecl)), 
              NewParam.getDefaultArgRange()));
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_bool($c$.track($this().Diag(PrevForDefaultArgs.getLocation(), 
                  diag.note_template_prev_declaration)), 
              false));
        } finally {
          $c$.$destroy();
        }
      } else if (New.getTemplateSpecializationKind()
         != TemplateSpecializationKind.TSK_ImplicitInstantiation
         && New.getTemplateSpecializationKind() != TemplateSpecializationKind.TSK_Undeclared) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C++ [temp.expr.spec]p21:
          //   Default function arguments shall not be specified in a declaration
          //   or a definition for one of the following explicit specializations:
          //     - the explicit specialization of a function template;
          //     - the explicit specialization of a member function template;
          //     - the explicit specialization of a member function of a class 
          //       template where the class template specialization to which the
          //       member function specialization belongs is implicitly 
          //       instantiated.
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_bool($c$.track($this().Diag(NewParam.getLocation(), diag.err_template_spec_default_arg)), 
                      (New.getTemplateSpecializationKind() == TemplateSpecializationKind.TSK_ExplicitSpecialization)), 
                  New.getDeclName()), 
              NewParam.getDefaultArgRange()));
        } finally {
          $c$.$destroy();
        }
      } else if (New.getDeclContext().isDependentContext()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C++ [dcl.fct.default]p6 (DR217):
          //   Default arguments for a member function of a class template shall 
          //   be specified on the initial declaration of the member function 
          //   within the class template.
          //
          // Reading the tea leaves a bit in DR217 and its reference to DR205 
          // leads me to the conclusion that one cannot add default function 
          // arguments for an out-of-line definition of a member function of a 
          // dependent type.
          int WhichKind = 2;
          {
            CXXRecordDecl /*P*/ Record = dyn_cast_CXXRecordDecl(New.getDeclContext());
            if ((Record != null)) {
              if ((Record.getDescribedClassTemplate() != null)) {
                WhichKind = 0;
              } else if (isa_ClassTemplatePartialSpecializationDecl(Record)) {
                WhichKind = 1;
              } else {
                WhichKind = 2;
              }
            }
          }
          
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(NewParam.getLocation(), 
                      diag.err_param_default_argument_member_template_redecl)), 
                  WhichKind), 
              NewParam.getDefaultArgRange()));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // DR1344: If a default argument is added outside a class definition and that
  // default argument makes the function a special member function, the program
  // is ill-formed. This can only happen for constructors.
  if (isa_CXXConstructorDecl(New)
     && $less_uint(New.getMinRequiredArguments(), Old.getMinRequiredArguments())) {
    CXXSpecialMember NewSM = $this().getSpecialMember(cast_CXXMethodDecl(New));
    CXXSpecialMember OldSM = $this().getSpecialMember(cast_CXXMethodDecl(Old));
    if (NewSM != OldSM) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        ParmVarDecl /*P*/ NewParam = New.getParamDecl(New.getMinRequiredArguments());
        assert (NewParam.hasDefaultArg());
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(NewParam.getLocation(), diag.err_default_arg_makes_ctor_special)), 
                NewParam.getDefaultArgRange()), NewSM));
        $c$.clean($c$.track($this().Diag(Old.getLocation(), diag.note_previous_declaration)));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  type$ref</*const*/ FunctionDecl /*P*/ > Def = create_type$ref();
  // C++11 [dcl.constexpr]p1: If any declaration of a function or function
  // template has a constexpr specifier then all its declarations shall
  // contain the constexpr specifier.
  if (New.isConstexpr() != Old.isConstexpr()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_bool(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_NamedDecl($c$.track($this().Diag(New.getLocation(), diag.err_constexpr_redecl_mismatch)), 
              New), New.isConstexpr()));
      $c$.clean($c$.track($this().Diag(Old.getLocation(), diag.note_previous_declaration)));
      Invalid = true;
    } finally {
      $c$.$destroy();
    }
  } else if (!Old.getMostRecentDecl$Redeclarable().isInlined() && New.isInlined()
     && Old.isDefined(Def)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // C++11 [dcl.fcn.spec]p4:
      //   If the definition of a function appears in a translation unit before its
      //   first declaration as inline, the program is ill-formed.
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_NamedDecl($c$.track($this().Diag(New.getLocation(), diag.err_inline_decl_follows_def)), New));
      $c$.clean($c$.track($this().Diag(Def.$deref().getLocation(), diag.note_previous_definition)));
      Invalid = true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // C++11 [dcl.fct.default]p4: If a friend declaration specifies a default
  // argument expression, that declaration shall be a definition and shall be
  // the only declaration of the function or function template in the
  // translation unit.
  if (Old.getFriendObjectKind() == Decl.FriendObjectKind.FOK_Undeclared
     && SemaDeclCXXStatics.functionDeclHasDefaultArgument(Old)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(New.getLocation(), diag.err_friend_decl_with_def_arg_redeclared)));
      $c$.clean($c$.track($this().Diag(Old.getLocation(), diag.note_previous_declaration)));
      Invalid = true;
    } finally {
      $c$.$destroy();
    }
  }
  if ($this().CheckEquivalentExceptionSpec(Old, New)) {
    Invalid = true;
  }
  
  return Invalid;
}


/// CheckCXXDefaultArguments - Verify that the default arguments for a
/// function declaration are well-formed according to C++
/// [dcl.fct.default].
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckCXXDefaultArguments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 712,
 FQN="clang::Sema::CheckCXXDefaultArguments", NM="_ZN5clang4Sema24CheckCXXDefaultArgumentsEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema24CheckCXXDefaultArgumentsEPNS_12FunctionDeclE")
//</editor-fold>
public final void CheckCXXDefaultArguments(FunctionDecl /*P*/ FD) {
  /*uint*/int NumParams = FD.getNumParams();
  /*uint*/int p;
  
  // Find first parameter with a default argument
  for (p = 0; $less_uint(p, NumParams); ++p) {
    ParmVarDecl /*P*/ Param = FD.getParamDecl(p);
    if (Param.hasDefaultArg()) {
      break;
    }
  }
  
  // C++11 [dcl.fct.default]p4:
  //   In a given function declaration, each parameter subsequent to a parameter
  //   with a default argument shall have a default argument supplied in this or
  //   a previous declaration or shall be a function parameter pack. A default
  //   argument shall not be redefined by a later declaration (not even to the
  //   same value).
  /*uint*/int LastMissingDefaultArg = 0;
  for (; $less_uint(p, NumParams); ++p) {
    ParmVarDecl /*P*/ Param = FD.getParamDecl(p);
    if (!Param.hasDefaultArg() && !Param.isParameterPack()) {
      if (Param.isInvalidDecl()) {
/* We already complained about this parameter. */         ;
      } else if ((Param.getIdentifier() != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_II($c$.track($this().Diag(Param.getLocation(), 
                  diag.err_param_default_argument_missing_name)), 
              Param.getIdentifier()));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(Param.getLocation(), 
              diag.err_param_default_argument_missing)));
        } finally {
          $c$.$destroy();
        }
      }
      
      LastMissingDefaultArg = p;
    }
  }
  if ($greater_uint(LastMissingDefaultArg, 0)) {
    // Some default arguments were missing. Clear out all of the
    // default arguments up to (and including) the last missing
    // default argument, so that we leave the function parameters
    // in a semantically valid state.
    for (p = 0; $lesseq_uint(p, LastMissingDefaultArg); ++p) {
      ParmVarDecl /*P*/ Param = FD.getParamDecl(p);
      if (Param.hasDefaultArg()) {
        Param.setDefaultArg((Expr /*P*/ )null);
      }
    }
  }
}


/// CheckExtraCXXDefaultArguments - Check for any extra default
/// arguments in the declarator, which is not a function declaration
/// or definition and therefore is not permitted to have default
/// arguments. This routine should be invoked for every declarator
/// that is not a function declaration or definition.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckExtraCXXDefaultArguments">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 374,
 FQN="clang::Sema::CheckExtraCXXDefaultArguments", NM="_ZN5clang4Sema29CheckExtraCXXDefaultArgumentsERNS_10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema29CheckExtraCXXDefaultArgumentsERNS_10DeclaratorE")
//</editor-fold>
public final void CheckExtraCXXDefaultArguments(final Declarator /*&*/ D) {
  // C++ [dcl.fct.default]p3
  //   A default argument expression shall be specified only in the
  //   parameter-declaration-clause of a function declaration or in a
  //   template-parameter (14.1). It shall not be specified for a
  //   parameter pack. If it is specified in a
  //   parameter-declaration-clause, it shall not occur within a
  //   declarator or abstract-declarator of a parameter-declaration.
  boolean MightBeFunction = D.isFunctionDeclarationContext();
  for (/*uint*/int i = 0, e = D.getNumTypeObjects(); i != e; ++i) {
    final DeclaratorChunk /*&*/ chunk = D.getTypeObject(i);
    if (chunk.Kind == DeclaratorChunk.Unnamed_enum.Function) {
      if (MightBeFunction) {
        // This is a function declaration. It can have default arguments, but
        // keep looking in case its return type is a function type with default
        // arguments.
        MightBeFunction = false;
        continue;
      }
      for (/*uint*/int argIdx = 0, e$1 = chunk.Unnamed_field3.Fun.NumParams; argIdx != e$1;
           ++argIdx) {
        ParmVarDecl /*P*/ Param = cast_ParmVarDecl(chunk.Unnamed_field3.Fun.Params.$at(argIdx).Param);
        if (Param.hasUnparsedDefaultArg()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            SmallVectorToken /*P*/ Toks = chunk.Unnamed_field3.Fun.Params.$at(argIdx).DefaultArgTokens;
            SourceRange SR/*J*/= new SourceRange();
            if ($greater_uint(Toks.size(), 1)) {
              SR.$assignMove(new SourceRange((/*Deref*/Toks).$at(1).getLocation(), 
                      Toks.back().getLocation()));
            } else {
              SR.$assignMove(new SourceRange(/*NO_COPY*/$this().UnparsedDefaultArgLocs.$at_T1$C$R(Param)));
            }
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Param.getLocation(), diag.err_param_default_argument_nonfunc)), 
                SR));
            if (Toks != null) { Toks.$destroy();};
            chunk.Unnamed_field3.Fun.Params.$at(argIdx).DefaultArgTokens = null;
          } finally {
            $c$.$destroy();
          }
        } else if ((Param.getDefaultArg() != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Param.getLocation(), diag.err_param_default_argument_nonfunc)), 
                Param.getDefaultArg().getSourceRange()));
            Param.setDefaultArg((Expr /*P*/ )null);
          } finally {
            $c$.$destroy();
          }
        }
      }
    } else if (chunk.Kind != DeclaratorChunk.Unnamed_enum.Paren) {
      MightBeFunction = false;
    }
  }
}


/// \brief Perform semantic analysis for the variable declaration that
/// occurs within a C++ catch clause, returning the newly-created
/// variable.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildExceptionDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 12184,
 FQN="clang::Sema::BuildExceptionDeclaration", NM="_ZN5clang4Sema25BuildExceptionDeclarationEPNS_5ScopeEPNS_14TypeSourceInfoENS_14SourceLocationES5_PNS_14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema25BuildExceptionDeclarationEPNS_5ScopeEPNS_14TypeSourceInfoENS_14SourceLocationES5_PNS_14IdentifierInfoE")
//</editor-fold>
public final VarDecl /*P*/ BuildExceptionDeclaration(Scope /*P*/ S, 
                         TypeSourceInfo /*P*/ TInfo, 
                         SourceLocation StartLoc, 
                         SourceLocation Loc, 
                         IdentifierInfo /*P*/ Name) {
  boolean Invalid = false;
  QualType ExDeclType = TInfo.getType();
  
  // Arrays and functions decay.
  if (ExDeclType.$arrow().isArrayType()) {
    ExDeclType.$assignMove($this().Context.getArrayDecayedType(new QualType(ExDeclType)));
  } else if (ExDeclType.$arrow().isFunctionType()) {
    ExDeclType.$assignMove($this().Context.getPointerType(new QualType(ExDeclType)));
  }
  
  // C++ 15.3p1: The exception-declaration shall not denote an incomplete type.
  // The exception-declaration shall not denote a pointer or reference to an
  // incomplete type, other than [cv] void*.
  // N2844 forbids rvalue references.
  if (!ExDeclType.$arrow().isDependentType() && ExDeclType.$arrow().isRValueReferenceType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_catch_rvalue_ref)));
      Invalid = true;
    } finally {
      $c$.$destroy();
    }
  }
  if (ExDeclType.$arrow().isVariablyModifiedType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_catch_variably_modified)), ExDeclType));
      Invalid = true;
    } finally {
      $c$.$destroy();
    }
  }
  
  QualType BaseType = new QualType(ExDeclType);
  int Mode = 0; // 0 for direct type, 1 for pointer, 2 for reference
  /*uint*/int DK = diag.err_catch_incomplete;
  {
    /*const*/ PointerType /*P*/ Ptr = BaseType.$arrow().getAs(PointerType.class);
    if ((Ptr != null)) {
      BaseType.$assignMove(Ptr.getPointeeType());
      Mode = 1;
      DK = diag.err_catch_incomplete_ptr;
    } else {
      /*const*/ ReferenceType /*P*/ Ref = BaseType.$arrow().getAs(ReferenceType.class);
      if ((Ref != null)) {
        // For the purpose of error recovery, we treat rvalue refs like lvalue refs.
        BaseType.$assignMove(Ref.getPointeeType());
        Mode = 2;
        DK = diag.err_catch_incomplete_ref;
      }
    }
  }
  if (!Invalid && (Mode == 0 || !BaseType.$arrow().isVoidType())
     && !BaseType.$arrow().isDependentType() && $this().RequireCompleteType(new SourceLocation(Loc), new QualType(BaseType), DK)) {
    Invalid = true;
  }
  if (!Invalid && !ExDeclType.$arrow().isDependentType()
     && $this().RequireNonAbstractType$T(new SourceLocation(Loc), new QualType(ExDeclType), 
      diag.err_abstract_type_in_decl, 
      AbstractDiagSelID.AbstractVariableType)) {
    Invalid = true;
  }
  
  // Only the non-fragile NeXT runtime currently supports C++ catches
  // of ObjC types, and no runtime supports catching ObjC types by value.
  if (!Invalid && $this().getLangOpts().ObjC1) {
    QualType T = new QualType(ExDeclType);
    {
      /*const*/ ReferenceType /*P*/ RT = T.$arrow().getAs(ReferenceType.class);
      if ((RT != null)) {
        T.$assignMove(RT.getPointeeType());
      }
    }
    if (T.$arrow().isObjCObjectType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_object_catch)));
        Invalid = true;
      } finally {
        $c$.$destroy();
      }
    } else if (T.$arrow().isObjCObjectPointerType()) {
      // FIXME: should this be a test for macosx-fragile specifically?
      if ($this().getLangOpts().ObjCRuntime.isFragile()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_objc_pointer_cxx_catch_fragile)));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  VarDecl /*P*/ ExDecl = VarDecl.Create($this().Context, $this().CurContext, new SourceLocation(StartLoc), new SourceLocation(Loc), Name, 
      new QualType(ExDeclType), TInfo, StorageClass.SC_None);
  ExDecl.setExceptionVariable(true);
  
  // In ARC, infer 'retaining' for variables of retainable type.
  if ($this().getLangOpts().ObjCAutoRefCount && $this().inferObjCARCLifetime(ExDecl)) {
    Invalid = true;
  }
  if (!Invalid && !ExDeclType.$arrow().isDependentType()) {
    {
      /*const*/ RecordType /*P*/ recordType = ExDeclType.$arrow().getAs$RecordType();
      if ((recordType != null)) {
        EnterExpressionEvaluationContext scope = null;
        InitializationSequence sequence = null;
        try {
          // Insulate this from anything else we might currently be parsing.
          scope/*J*/= new EnterExpressionEvaluationContext(/*Deref*/$this(), ExpressionEvaluationContext.PotentiallyEvaluated);
          
          // C++ [except.handle]p16:
          //   The object declared in an exception-declaration or, if the
          //   exception-declaration does not specify a name, a temporary (12.2) is
          //   copy-initialized (8.5) from the exception object. [...]
          //   The object is destroyed when the handler exits, after the destruction
          //   of any automatic objects initialized within the handler.
          //
          // We just pretend to initialize the object with itself, then make sure
          // it can be destroyed later.
          QualType initType = $this().Context.getExceptionObjectType(new QualType(ExDeclType));
          
          InitializedEntity entity = InitializedEntity.InitializeVariable(ExDecl);
          InitializationKind initKind = InitializationKind.CreateCopy(new SourceLocation(Loc), new SourceLocation());
          
          Expr /*P*/ opaqueValue = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
              return new OpaqueValueExpr(new SourceLocation(Loc), new QualType(initType), ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary);
           });
          sequence/*J*/= new InitializationSequence(/*Deref*/$this(), entity, initKind, new MutableArrayRef<Expr /*P*/ >(opaqueValue, true));
          ActionResultTTrue<Expr /*P*/ > result = sequence.Perform(/*Deref*/$this(), entity, initKind, new MutableArrayRef<Expr /*P*/ >(opaqueValue, true));
          if (result.isInvalid()) {
            Invalid = true;
          } else {
            // If the constructor used was non-trivial, set this as the
            // "initializer".
            CXXConstructExpr /*P*/ construct = result.getAs(CXXConstructExpr.class);
            if (!construct.getConstructor().isTrivial()) {
              Expr /*P*/ init = $this().MaybeCreateExprWithCleanups(construct);
              ExDecl.setInit(init);
            }
            
            // And make sure it's destructable.
            $this().FinalizeVarWithDestructor(ExDecl, recordType);
          }
        } finally {
          if (sequence != null) { sequence.$destroy(); }
          if (scope != null) { scope.$destroy(); }
        }
      }
    }
  }
  if (Invalid) {
    ExDecl.setInvalidDecl();
  }
  
  return ExDecl;
}


/// ActOnExceptionDeclarator - Parsed the exception-declarator in a C++ catch
/// handler.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnExceptionDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 12310,
 FQN="clang::Sema::ActOnExceptionDeclarator", NM="_ZN5clang4Sema24ActOnExceptionDeclaratorEPNS_5ScopeERNS_10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema24ActOnExceptionDeclaratorEPNS_5ScopeERNS_10DeclaratorE")
//</editor-fold>
public final Decl /*P*/ ActOnExceptionDeclarator(Scope /*P*/ S, final Declarator /*&*/ D) {
  TypeSourceInfo /*P*/ TInfo = $this().GetTypeForDeclarator(D, S);
  boolean Invalid = D.isInvalidType();
  
  // Check for unexpanded parameter packs.
  if ($this().DiagnoseUnexpandedParameterPack(D.getIdentifierLoc(), TInfo, 
      UnexpandedParameterPackContext.UPPC_ExceptionType)) {
    TInfo = $this().Context.getTrivialTypeSourceInfo($this().Context.IntTy.$QualType(), 
        D.getIdentifierLoc());
    Invalid = true;
  }
  
  IdentifierInfo /*P*/ II = D.getIdentifier();
  {
    NamedDecl /*P*/ PrevDecl = $this().LookupSingleName(S, new DeclarationName(II), D.getIdentifierLoc(), 
        LookupNameKind.LookupOrdinaryName, 
        RedeclarationKind.ForRedeclaration);
    if ((PrevDecl != null)) {
      // The scope should be freshly made just for us. There is just no way
      // it contains any previous declaration, except for function parameters in
      // a function-try-block's catch statement.
      assert (!S.isDeclScope(PrevDecl));
      if ($this().isDeclInScope(PrevDecl, $this().CurContext, S)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_redefinition)), 
              D.getIdentifier()));
          $c$.clean($c$.track($this().Diag(PrevDecl.getLocation(), diag.note_previous_definition)));
          Invalid = true;
        } finally {
          $c$.$destroy();
        }
      } else if (PrevDecl.isTemplateParameter()) {
        // Maybe we will complain about the shadowed template parameter.
        $this().DiagnoseTemplateParameterShadow(D.getIdentifierLoc(), PrevDecl);
      }
    }
  }
  if (D.getCXXScopeSpec().isSet() && !Invalid) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_qualified_catch_declarator)), 
          D.getCXXScopeSpec().getRange()));
      Invalid = true;
    } finally {
      $c$.$destroy();
    }
  }
  
  VarDecl /*P*/ ExDecl = $this().BuildExceptionDeclaration(S, TInfo, 
      D.getLocStart(), 
      D.getIdentifierLoc(), 
      D.getIdentifier());
  if (Invalid) {
    ExDecl.setInvalidDecl();
  }
  
  // Add the exception declaration into this scope.
  if ((II != null)) {
    $this().PushOnScopeChains(ExDecl, S);
  } else {
    $this().CurContext.addDecl(ExDecl);
  }
  
  $this().ProcessDeclAttributes(S, ExDecl, D);
  return ExDecl;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseReturnInConstructorExceptionHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13133,
 FQN="clang::Sema::DiagnoseReturnInConstructorExceptionHandler", NM="_ZN5clang4Sema43DiagnoseReturnInConstructorExceptionHandlerEPNS_10CXXTryStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema43DiagnoseReturnInConstructorExceptionHandlerEPNS_10CXXTryStmtE")
//</editor-fold>
public final void DiagnoseReturnInConstructorExceptionHandler(CXXTryStmt /*P*/ TryBlock) {
  for (/*uint*/int I = 0, E = TryBlock.getNumHandlers(); I != E; ++I) {
    CXXCatchStmt /*P*/ Handler = TryBlock.getHandler(I);
    SearchForReturnInStmt(/*Deref*/$this(), Handler);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::NoteDeletedInheritingConstructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9322,
 FQN="clang::Sema::NoteDeletedInheritingConstructor", NM="_ZN5clang4Sema32NoteDeletedInheritingConstructorEPNS_18CXXConstructorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema32NoteDeletedInheritingConstructorEPNS_18CXXConstructorDeclE")
//</editor-fold>
public final void NoteDeletedInheritingConstructor(CXXConstructorDecl /*P*/ Ctor) {
  InheritedConstructorInfo ICI = null;
  try {
    ICI/*J*/= new InheritedConstructorInfo(/*Deref*/$this(), Ctor.getLocation(), 
        Ctor.getInheritedConstructor().getShadowDecl());
    $this().ShouldDeleteSpecialMember(Ctor, CXXSpecialMember.CXXDefaultConstructor, $AddrOf(ICI), 
        /*Diagnose*/ true);
  } finally {
    if (ICI != null) { ICI.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnDefaultCtorInitializers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4388,
 FQN="clang::Sema::ActOnDefaultCtorInitializers", NM="_ZN5clang4Sema28ActOnDefaultCtorInitializersEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema28ActOnDefaultCtorInitializersEPNS_4DeclE")
//</editor-fold>
public final void ActOnDefaultCtorInitializers(Decl /*P*/ CDtorDecl) {
  if (!(CDtorDecl != null)) {
    return;
  }
  {
    
    CXXConstructorDecl /*P*/ Constructor = dyn_cast_CXXConstructorDecl(CDtorDecl);
    if ((Constructor != null)) {
      $this().SetCtorInitializers(Constructor, /*AnyErrors=*/ false);
      DiagnoseUninitializedFields(/*Deref*/$this(), Constructor);
    }
  }
}


//===---------------------------- C++ Features --------------------------===//

// Act on C++ namespaces

/// ActOnStartNamespaceDef - This is called at the start of a namespace
/// definition.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStartNamespaceDef">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 7331,
 FQN="clang::Sema::ActOnStartNamespaceDef", NM="_ZN5clang4Sema22ActOnStartNamespaceDefEPNS_5ScopeENS_14SourceLocationES3_S3_PNS_14IdentifierInfoES3_PNS_13AttributeListERPNS_18UsingDirectiveDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema22ActOnStartNamespaceDefEPNS_5ScopeENS_14SourceLocationES3_S3_PNS_14IdentifierInfoES3_PNS_13AttributeListERPNS_18UsingDirectiveDeclE")
//</editor-fold>
public final Decl /*P*/ ActOnStartNamespaceDef(Scope /*P*/ NamespcScope, 
                      SourceLocation InlineLoc, 
                      SourceLocation NamespaceLoc, 
                      SourceLocation IdentLoc, 
                      IdentifierInfo /*P*/ II, 
                      SourceLocation LBrace, 
                      AttributeList /*P*/ AttrList, 
                      final type$ref<UsingDirectiveDecl /*P*/ /*&*/> UD) {
  SourceLocation StartLoc = new SourceLocation(InlineLoc.isValid() ? InlineLoc : NamespaceLoc);
  // For anonymous namespace, take the location of the left brace.
  SourceLocation Loc = new SourceLocation((II != null) ? IdentLoc : LBrace);
  bool$ptr IsInline = create_bool$ptr(InlineLoc.isValid());
  boolean IsInvalid = false;
  boolean IsStd = false;
  boolean AddToKnown = false;
  Scope /*P*/ DeclRegionScope = NamespcScope.getParent();
  
  NamespaceDecl /*P*/ PrevNS = null;
  if ((II != null)) {
    LookupResult R = null;
    try {
      // C++ [namespace.def]p2:
      //   The identifier in an original-namespace-definition shall not
      //   have been previously defined in the declarative region in
      //   which the original-namespace-definition appears. The
      //   identifier in an original-namespace-definition is the name of
      //   the namespace. Subsequently in that declarative region, it is
      //   treated as an original-namespace-name.
      //
      // Since namespace names are unique in their scope, and we don't
      // look through using directives, just look for any ordinary names
      // as if by qualified name lookup.
      R/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(II), new SourceLocation(IdentLoc), LookupNameKind.LookupOrdinaryName, RedeclarationKind.ForRedeclaration);
      $this().LookupQualifiedName(R, $this().CurContext.getRedeclContext());
      NamedDecl /*P*/ PrevDecl = R.isSingleResult() ? R.getRepresentativeDecl() : null;
      PrevNS = dyn_cast_or_null_NamespaceDecl(PrevDecl);
      if ((PrevNS != null)) {
        // This is an extended namespace definition.
        if (IsInline.$star() != PrevNS.isInline()) {
          DiagnoseNamespaceInlineMismatch(/*Deref*/$this(), new SourceLocation(NamespaceLoc), new SourceLocation(Loc), II, 
              $AddrOf(IsInline), PrevNS);
        }
      } else if ((PrevDecl != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // This is an invalid name redefinition.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_redefinition_different_kind)), 
              II));
          $c$.clean($c$.track($this().Diag(PrevDecl.getLocation(), diag.note_previous_definition)));
          IsInvalid = true;
        } finally {
          $c$.$destroy();
        }
        // Continue on to push Namespc as current DeclContext and return it.
      } else if (II.isStr(/*KEEP_STR*/"std")
         && $this().CurContext.getRedeclContext().isTranslationUnit()) {
        // This is the first "real" definition of the namespace "std", so update
        // our cache of the "std" namespace to point at this definition.
        PrevNS = $this().getStdNamespace();
        IsStd = true;
        AddToKnown = !IsInline.$star();
      } else {
        // We've seen this namespace for the first time.
        AddToKnown = !IsInline.$star();
      }
    } finally {
      if (R != null) { R.$destroy(); }
    }
  } else {
    // Anonymous namespaces.
    
    // Determine whether the parent already has an anonymous namespace.
    DeclContext /*P*/ Parent = $this().CurContext.getRedeclContext();
    {
      TranslationUnitDecl /*P*/ TU = dyn_cast_TranslationUnitDecl(Parent);
      if ((TU != null)) {
        PrevNS = TU.getAnonymousNamespace();
      } else {
        NamespaceDecl /*P*/ ND = cast_NamespaceDecl(Parent);
        PrevNS = ND.getAnonymousNamespace();
      }
    }
    if ((PrevNS != null) && IsInline.$star() != PrevNS.isInline()) {
      DiagnoseNamespaceInlineMismatch(/*Deref*/$this(), new SourceLocation(NamespaceLoc), new SourceLocation(NamespaceLoc), II, 
          $AddrOf(IsInline), PrevNS);
    }
  }
  
  NamespaceDecl /*P*/ Namespc = NamespaceDecl.Create($this().Context, $this().CurContext, IsInline.$star(), 
      new SourceLocation(StartLoc), new SourceLocation(Loc), II, PrevNS);
  if (IsInvalid) {
    Namespc.setInvalidDecl();
  }
  
  $this().ProcessDeclAttributeList(DeclRegionScope, Namespc, AttrList);
  {
    
    // FIXME: Should we be merging attributes?
    /*const*/ VisibilityAttr /*P*/ Attr = Namespc.getAttr(VisibilityAttr.class);
    if ((Attr != null)) {
      $this().PushNamespaceVisibilityAttr(Attr, new SourceLocation(Loc));
    }
  }
  if (IsStd) {
    $this().StdNamespace.$assign(Namespc);
  }
  if (AddToKnown) {
    $this().KnownNamespaces.ref$at(Namespc).$set(false);
  }
  if ((II != null)) {
    $this().PushOnScopeChains(Namespc, DeclRegionScope);
  } else {
    // Link the anonymous namespace into its parent.
    DeclContext /*P*/ Parent = $this().CurContext.getRedeclContext();
    {
      TranslationUnitDecl /*P*/ TU = dyn_cast_TranslationUnitDecl(Parent);
      if ((TU != null)) {
        TU.setAnonymousNamespace(Namespc);
      } else {
        cast_NamespaceDecl(Parent).setAnonymousNamespace(Namespc);
      }
    }
    
    $this().CurContext.addDecl(Namespc);
    
    // C++ [namespace.unnamed]p1.  An unnamed-namespace-definition
    //   behaves as if it were replaced by
    //     namespace unique { /* empty body */ }
    //     using namespace unique;
    //     namespace unique { namespace-body }
    //   where all occurrences of 'unique' in a translation unit are
    //   replaced by the same identifier and this identifier differs
    //   from all other identifiers in the entire program.
    
    // We just create the namespace with an empty name and then add an
    // implicit using declaration, just like the standard suggests.
    //
    // CodeGen enforces the "universally unique" aspect by giving all
    // declarations semantically contained within an anonymous
    // namespace internal linkage.
    if (!(PrevNS != null)) {
      UD.$set(UsingDirectiveDecl.Create($this().Context, Parent, 
          /* 'using' */ new SourceLocation(LBrace), 
          /* 'namespace' */ new SourceLocation(), 
          /* qualifier */ new NestedNameSpecifierLoc(), 
          /* identifier */ new SourceLocation(), 
          Namespc, 
          /* Ancestor */ Parent));
      UD.$deref().setImplicit();
      Parent.addDecl(UD.$deref());
    }
  }
  
  $this().ActOnDocumentableDecl(Namespc);
  
  // Although we could have an invalid decl (i.e. the namespace name is a
  // redefinition), push it as current DeclContext and try to continue parsing.
  // FIXME: We should be able to push Namespc here, so that the each DeclContext
  // for the namespace has the declarations that showed up in that particular
  // namespace definition.
  $this().PushDeclContext(NamespcScope, Namespc);
  return Namespc;
}


/// ActOnFinishNamespaceDef - This callback is called after a namespace is
/// exited. Decl is the DeclTy returned by ActOnStartNamespaceDef.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFinishNamespaceDef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 7486,
 FQN="clang::Sema::ActOnFinishNamespaceDef", NM="_ZN5clang4Sema23ActOnFinishNamespaceDefEPNS_4DeclENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema23ActOnFinishNamespaceDefEPNS_4DeclENS_14SourceLocationE")
//</editor-fold>
public final void ActOnFinishNamespaceDef(Decl /*P*/ Dcl, SourceLocation RBrace) {
  NamespaceDecl /*P*/ Namespc = dyn_cast_or_null_NamespaceDecl(Dcl);
  assert ((Namespc != null)) : "Invalid parameter, expected NamespaceDecl";
  Namespc.setRBraceLoc(new SourceLocation(RBrace));
  $this().PopDeclContext();
  if (Namespc.hasAttr(VisibilityAttr.class)) {
    $this().PopPragmaVisibility(true, new SourceLocation(RBrace));
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::getStdNamespace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 7500,
 FQN="clang::Sema::getStdNamespace", NM="_ZNK5clang4Sema15getStdNamespaceEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZNK5clang4Sema15getStdNamespaceEv")
//</editor-fold>
public final NamespaceDecl /*P*/ getStdNamespace() /*const*/ {
  return cast_or_null_NamespaceDecl($this().StdNamespace.get($this().Context.getExternalSource()));
}


/// \brief Retrieve the special "std" namespace, which may require us to 
/// implicitly define the namespace.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getOrCreateStdNamespace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 7507,
 FQN="clang::Sema::getOrCreateStdNamespace", NM="_ZN5clang4Sema23getOrCreateStdNamespaceEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema23getOrCreateStdNamespaceEv")
//</editor-fold>
public final NamespaceDecl /*P*/ getOrCreateStdNamespace() {
  if (!$this().StdNamespace.$bool()) {
    // The "std" namespace has not yet been defined, so build one implicitly.
    $this().StdNamespace.$assign(NamespaceDecl.Create($this().Context, 
            $this().Context.getTranslationUnitDecl(), 
            /*Inline=*/ false, 
            new SourceLocation(), new SourceLocation(), 
            $AddrOf($this().PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"std"))), 
            /*PrevDecl=*/ (NamespaceDecl /*P*/ )null));
    $this().getStdNamespace().setImplicit(true);
  }
  
  return $this().getStdNamespace();
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::getStdBadAlloc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 7495,
 FQN="clang::Sema::getStdBadAlloc", NM="_ZNK5clang4Sema14getStdBadAllocEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZNK5clang4Sema14getStdBadAllocEv")
//</editor-fold>
public final CXXRecordDecl /*P*/ getStdBadAlloc() /*const*/ {
  return cast_or_null_CXXRecordDecl($this().StdBadAlloc.get($this().Context.getExternalSource()));
}


/// \brief Tests whether Ty is an instance of std::initializer_list and, if
/// it is and Element is not NULL, assigns the element type to Element.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isStdInitializerList">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 7522,
 FQN="clang::Sema::isStdInitializerList", NM="_ZN5clang4Sema20isStdInitializerListENS_8QualTypeEPS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema20isStdInitializerListENS_8QualTypeEPS1_")
//</editor-fold>
public final boolean isStdInitializerList(QualType Ty, type$ptr<QualType /*P*/> Element) {
  assert ($this().getLangOpts().CPlusPlus) : "Looking for std::initializer_list outside of C++.";
  
  // We're looking for implicit instantiations of
  // template <typename E> class std::initializer_list.
  if (!$this().StdNamespace.$bool()) { // If we haven't seen namespace std yet, this can't be it.
    return false;
  }
  
  ClassTemplateDecl /*P*/ Template = null;
  /*const*/ type$ptr<TemplateArgument/*P*/> Arguments = null;
  {
    
    /*const*/ RecordType /*P*/ RT = Ty.$arrow().getAs$RecordType();
    if ((RT != null)) {
      
      ClassTemplateSpecializationDecl /*P*/ Specialization = dyn_cast_ClassTemplateSpecializationDecl(RT.getDecl());
      if (!(Specialization != null)) {
        return false;
      }
      
      Template = Specialization.getSpecializedTemplate();
      Arguments = Specialization.getTemplateArgs().data();
    } else {
      /*const*/ TemplateSpecializationType /*P*/ TST = Ty.$arrow().getAs$TemplateSpecializationType();
      if ((TST != null)) {
        Template = dyn_cast_or_null_ClassTemplateDecl(TST.getTemplateName().getAsTemplateDecl());
        Arguments = TST.getArgs();
      }
    }
  }
  if (!(Template != null)) {
    return false;
  }
  if (!($this().StdInitializerList != null)) {
    // Haven't recognized std::initializer_list yet, maybe this is it.
    CXXRecordDecl /*P*/ TemplateClass = Template.getTemplatedDecl();
    if (TemplateClass.getIdentifier()
       != $AddrOf($this().PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"initializer_list")))
       || !$this().getStdNamespace().InEnclosingNamespaceSetOf(TemplateClass.getDeclContext())) {
      return false;
    }
    // This is a template called std::initializer_list, but is it the right
    // template?
    TemplateParameterList /*P*/ Params = Template.getTemplateParameters();
    if (Params.getMinRequiredArguments() != 1) {
      return false;
    }
    if (!isa_TemplateTypeParmDecl(Params.getParam(0))) {
      return false;
    }
    
    // It's the right template.
    $this().StdInitializerList = Template;
  }
  if (Template.getCanonicalDecl() != $this().StdInitializerList.getCanonicalDecl()) {
    return false;
  }
  
  // This is an instance of std::initializer_list. Find the argument type.
  if (Native.$bool(Element)) {
    Element.$star().$assignMove(Arguments.$at(0).getAsType());
  }
  return true;
}


/// \brief Looks for the std::initializer_list template and instantiates it
/// with Element, or emits an error if it's not found.
///
/// \returns The instantiated template, or null on error.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildStdInitializerList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 7616,
 FQN="clang::Sema::BuildStdInitializerList", NM="_ZN5clang4Sema23BuildStdInitializerListENS_8QualTypeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema23BuildStdInitializerListENS_8QualTypeENS_14SourceLocationE")
//</editor-fold>
public final QualType BuildStdInitializerList(QualType Element, SourceLocation Loc) {
  TemplateArgumentListInfo Args = null;
  try {
    if (!($this().StdInitializerList != null)) {
      $this().StdInitializerList = LookupStdInitializerList(/*Deref*/$this(), new SourceLocation(Loc));
      if (!($this().StdInitializerList != null)) {
        return new QualType();
      }
    }
    
    Args/*J*/= new TemplateArgumentListInfo(new SourceLocation(Loc), new SourceLocation(Loc));
    Args.addArgument(new TemplateArgumentLoc(new TemplateArgument(new QualType(Element)), 
            $this().Context.getTrivialTypeSourceInfo(/*NO_COPY*/Element, 
                /*NO_COPY*/Loc)));
    return $this().Context.getCanonicalType($this().CheckTemplateIdType(new TemplateName($this().StdInitializerList), new SourceLocation(Loc), Args)).$QualType();
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}


/// \brief Determine whether Ctor is an initializer-list constructor, as
/// defined in [dcl.init.list]p2.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isInitListConstructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 7631,
 FQN="clang::Sema::isInitListConstructor", NM="_ZN5clang4Sema21isInitListConstructorEPKNS_18CXXConstructorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema21isInitListConstructorEPKNS_18CXXConstructorDeclE")
//</editor-fold>
public final boolean isInitListConstructor(/*const*/ CXXConstructorDecl /*P*/ Ctor) {
  // C++ [dcl.init.list]p2:
  //   A constructor is an initializer-list constructor if its first parameter
  //   is of type std::initializer_list<E> or reference to possibly cv-qualified
  //   std::initializer_list<E> for some type E, and either there are no other
  //   parameters or else all other parameters have default arguments.
  if ($less_uint(Ctor.getNumParams(), 1)
     || ($greater_uint(Ctor.getNumParams(), 1) && !Ctor.getParamDecl$Const(1).hasDefaultArg())) {
    return false;
  }
  
  QualType ArgType = Ctor.getParamDecl$Const(0).getType();
  {
    /*const*/ ReferenceType /*P*/ RT = ArgType.$arrow().getAs(ReferenceType.class);
    if ((RT != null)) {
      ArgType.$assignMove(RT.getPointeeType().getUnqualifiedType());
    }
  }
  
  return $this().isStdInitializerList(new QualType(ArgType), (type$ptr<QualType /*P*/> )null);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnUsingDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 7703,
 FQN="clang::Sema::ActOnUsingDirective", NM="_ZN5clang4Sema19ActOnUsingDirectiveEPNS_5ScopeENS_14SourceLocationES3_RNS_12CXXScopeSpecES3_PNS_14IdentifierInfoEPNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema19ActOnUsingDirectiveEPNS_5ScopeENS_14SourceLocationES3_RNS_12CXXScopeSpecES3_PNS_14IdentifierInfoEPNS_13AttributeListE")
//</editor-fold>
public final Decl /*P*/ ActOnUsingDirective(Scope /*P*/ S, 
                   SourceLocation UsingLoc, 
                   SourceLocation NamespcLoc, 
                   final CXXScopeSpec /*&*/ SS, 
                   SourceLocation IdentLoc, 
                   IdentifierInfo /*P*/ NamespcName, 
                   AttributeList /*P*/ AttrList) {
  LookupResult R = null;
  try {
    assert (!SS.isInvalid()) : "Invalid CXXScopeSpec.";
    assert ((NamespcName != null)) : "Invalid NamespcName.";
    assert (IdentLoc.isValid()) : "Invalid NamespceName location.";
    
    // This can only happen along a recovery path.
    while (S.isTemplateParamScope()) {
      S = S.getParent();
    }
    assert (((S.getFlags() & Scope.ScopeFlags.DeclScope) != 0)) : "Invalid Scope.";
    
    UsingDirectiveDecl /*P*/ UDir = null;
    NestedNameSpecifier /*P*/ Qualifier = null;
    if (SS.isSet()) {
      Qualifier = SS.getScopeRep();
    }
    
    // Lookup namespace name.
    R/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(NamespcName), new SourceLocation(IdentLoc), LookupNameKind.LookupNamespaceName);
    $this().LookupParsedName(R, S, $AddrOf(SS));
    if (R.isAmbiguous()) {
      return null;
    }
    if (R.empty()) {
      R.clear();
      // Allow "using namespace std;" or "using namespace ::std;" even if 
      // "std" hasn't been defined yet, for GCC compatibility.
      if ((!(Qualifier != null) || Qualifier.getKind() == NestedNameSpecifier.SpecifierKind.Global)
         && NamespcName.isStr(/*KEEP_STR*/"std")) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(IdentLoc), diag.ext_using_undefined_std)));
          R.addDecl($this().getOrCreateStdNamespace());
          R.resolveKind();
        } finally {
          $c$.$destroy();
        }
      } else {
        // Otherwise, attempt typo correction.
        TryNamespaceTypoCorrection(/*Deref*/$this(), R, S, SS, new SourceLocation(IdentLoc), NamespcName);
      }
    }
    if (!R.empty()) {
      NamedDecl /*P*/ Named = R.getRepresentativeDecl();
      NamespaceDecl /*P*/ NS = R.<NamespaceDecl>getAsSingle(NamespaceDecl.class);
      assert ((NS != null)) : "expected namespace decl";
      
      // The use of a nested name specifier may trigger deprecation warnings.
      $this().DiagnoseUseOfDecl(Named, new SourceLocation(IdentLoc));
      
      // C++ [namespace.udir]p1:
      //   A using-directive specifies that the names in the nominated
      //   namespace can be used in the scope in which the
      //   using-directive appears after the using-directive. During
      //   unqualified name lookup (3.4.1), the names appear as if they
      //   were declared in the nearest enclosing namespace which
      //   contains both the using-directive and the nominated
      //   namespace. [Note: in this context, "contains" means "contains
      //   directly or indirectly". ]
      
      // Find enclosing context containing both using-directive and
      // nominated namespace.
      DeclContext /*P*/ CommonAncestor = cast_DeclContext(NS);
      while ((CommonAncestor != null) && !CommonAncestor.Encloses($this().CurContext)) {
        CommonAncestor = CommonAncestor.getParent();
      }
      
      UDir = UsingDirectiveDecl.Create($this().Context, $this().CurContext, new SourceLocation(UsingLoc), new SourceLocation(NamespcLoc), 
          SS.getWithLocInContext($this().Context), 
          new SourceLocation(IdentLoc), Named, CommonAncestor);
      if (IsUsingDirectiveInToplevelContext($this().CurContext)
         && !$this().SourceMgr.isInMainFile($this().SourceMgr.getExpansionLoc(/*NO_COPY*/IdentLoc))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(IdentLoc), diag.warn_using_directive_in_header)));
        } finally {
          $c$.$destroy();
        }
      }
      
      $this().PushUsingDirective(S, UDir);
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IdentLoc), diag.err_expected_namespace_name)), SS.getRange()));
      } finally {
        $c$.$destroy();
      }
    }
    if ((UDir != null)) {
      $this().ProcessDeclAttributeList(S, UDir, AttrList);
    }
    
    return UDir;
  } finally {
    if (R != null) { R.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::PushUsingDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 7788,
 FQN="clang::Sema::PushUsingDirective", NM="_ZN5clang4Sema18PushUsingDirectiveEPNS_5ScopeEPNS_18UsingDirectiveDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema18PushUsingDirectiveEPNS_5ScopeEPNS_18UsingDirectiveDeclE")
//</editor-fold>
public final void PushUsingDirective(Scope /*P*/ S, UsingDirectiveDecl /*P*/ UDir) {
  // If the scope has an associated entity and the using directive is at
  // namespace or translation unit scope, add the UsingDirectiveDecl into
  // its lookup structure so qualified name lookup can find it.
  DeclContext /*P*/ Ctx = S.getEntity();
  if ((Ctx != null) && !Ctx.isFunctionOrMethod()) {
    Ctx.addDecl(UDir);
  } else {
    // Otherwise, it is at block scope. The using-directives will affect lookup
    // only to the end of the scope.
    S.PushUsingDirective(UDir);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnNamespaceAliasDef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 8893,
 FQN="clang::Sema::ActOnNamespaceAliasDef", NM="_ZN5clang4Sema22ActOnNamespaceAliasDefEPNS_5ScopeENS_14SourceLocationES3_PNS_14IdentifierInfoERNS_12CXXScopeSpecES3_S5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema22ActOnNamespaceAliasDefEPNS_5ScopeENS_14SourceLocationES3_PNS_14IdentifierInfoERNS_12CXXScopeSpecES3_S5_")
//</editor-fold>
public final Decl /*P*/ ActOnNamespaceAliasDef(Scope /*P*/ S, SourceLocation NamespaceLoc, 
                      SourceLocation AliasLoc, 
                      IdentifierInfo /*P*/ Alias, final CXXScopeSpec /*&*/ SS, 
                      SourceLocation IdentLoc, 
                      IdentifierInfo /*P*/ Ident) {
  LookupResult R = null;
  LookupResult PrevR = null;
  try {
    
    // Lookup the namespace name.
    R/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(Ident), new SourceLocation(IdentLoc), LookupNameKind.LookupNamespaceName);
    $this().LookupParsedName(R, S, $AddrOf(SS));
    if (R.isAmbiguous()) {
      return null;
    }
    if (R.empty()) {
      if (!TryNamespaceTypoCorrection(/*Deref*/$this(), R, S, SS, new SourceLocation(IdentLoc), Ident)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IdentLoc), diag.err_expected_namespace_name)), SS.getRange()));
          return null;
        } finally {
          $c$.$destroy();
        }
      }
    }
    assert (!R.isAmbiguous() && !R.empty());
    NamedDecl /*P*/ ND = R.getRepresentativeDecl();
    
    // Check if we have a previous declaration with the same name.
    PrevR/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(Alias), new SourceLocation(AliasLoc), LookupNameKind.LookupOrdinaryName, 
        RedeclarationKind.ForRedeclaration);
    $this().LookupName(PrevR, S);
    
    // Check we're not shadowing a template parameter.
    if (PrevR.isSingleResult() && PrevR.getFoundDecl().isTemplateParameter()) {
      $this().DiagnoseTemplateParameterShadow(new SourceLocation(AliasLoc), PrevR.getFoundDecl());
      PrevR.clear();
    }
    
    // Filter out any other lookup result from an enclosing scope.
    $this().FilterLookupForScope(PrevR, $this().CurContext, S, /*ConsiderLinkage*/ false, 
        /*AllowInlineNamespace*/ false);
    
    // Find the previous declaration and check that we can redeclare it.
    NamespaceAliasDecl /*P*/ Prev = null;
    if (PrevR.isSingleResult()) {
      NamedDecl /*P*/ PrevDecl = PrevR.getRepresentativeDecl();
      {
        NamespaceAliasDecl /*P*/ AD = dyn_cast_NamespaceAliasDecl(PrevDecl);
        if ((AD != null)) {
          // We already have an alias with the same name that points to the same
          // namespace; check that it matches.
          if (AD.getNamespace().Equals(getNamespaceDecl(ND))) {
            Prev = AD;
          } else if ($this().isVisible(PrevDecl)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AliasLoc), diag.err_redefinition_different_namespace_alias)), 
                  Alias));
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(AD.getLocation(), diag.note_previous_namespace_alias)), 
                  AD.getNamespace()));
              return null;
            } finally {
              $c$.$destroy();
            }
          }
        } else if ($this().isVisible(PrevDecl)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*uint*/int DiagID = isa_NamespaceDecl(PrevDecl.getUnderlyingDecl()) ? diag.err_redefinition : diag.err_redefinition_different_kind;
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AliasLoc), DiagID)), Alias));
            $c$.clean($c$.track($this().Diag(PrevDecl.getLocation(), diag.note_previous_definition)));
            return null;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    // The use of a nested name specifier may trigger deprecation warnings.
    $this().DiagnoseUseOfDecl(ND, new SourceLocation(IdentLoc));
    
    NamespaceAliasDecl /*P*/ AliasDecl = NamespaceAliasDecl.Create($this().Context, $this().CurContext, new SourceLocation(NamespaceLoc), new SourceLocation(AliasLoc), 
        Alias, SS.getWithLocInContext($this().Context), 
        new SourceLocation(IdentLoc), ND);
    if ((Prev != null)) {
      AliasDecl.setPreviousDecl(Prev);
    }
    
    $this().PushOnScopeChains(AliasDecl, S);
    return AliasDecl;
  } finally {
    if (PrevR != null) { PrevR.$destroy(); }
    if (R != null) { R.$destroy(); }
  }
}


/// Hides a using shadow declaration.  This is required by the current
/// using-decl implementation when a resolvable using declaration in a
/// class is followed by a declaration which would hide or override
/// one or more of the using decl's targets; for example:
///
///   struct Base { void foo(int); };
///   struct Derived : Base {
///     using Base::foo;
///     void foo(int);
///   };
///
/// The governing language is C++03 [namespace.udecl]p12:
///
///   When a using-declaration brings names from a base class into a
///   derived class scope, member functions in the derived class
///   override and/or hide member functions with the same name and
///   parameter types in a base class (rather than conflicting).
///
/// There are two ways to implement this:
///   (1) optimistically create shadow decls when they're not hidden
///       by existing declarations, or
///   (2) don't create any shadow decls (or at least don't make them
///       visible) until we've fully parsed/instantiated the class.
/// The problem with (1) is that we might have to retroactively remove
/// a shadow decl, which requires several O(n) operations because the
/// decl structures are (very reasonably) not designed for removal.
/// (2) avoids this but is very fiddly and phase-dependent.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::HideUsingShadowDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 8111,
 FQN="clang::Sema::HideUsingShadowDecl", NM="_ZN5clang4Sema19HideUsingShadowDeclEPNS_5ScopeEPNS_15UsingShadowDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema19HideUsingShadowDeclEPNS_5ScopeEPNS_15UsingShadowDeclE")
//</editor-fold>
public final void HideUsingShadowDecl(Scope /*P*/ S, UsingShadowDecl /*P*/ Shadow) {
  if (Shadow.getDeclName().getNameKind()
     == DeclarationName.NameKind.CXXConversionFunctionName) {
    cast_CXXRecordDecl(Shadow.getDeclContext()).removeConversion(Shadow);
  }
  
  // Remove it from the DeclContext...
  Shadow.getDeclContext().removeDecl(Shadow);
  
  // ...and the scope, if applicable...
  if ((S != null)) {
    S.RemoveDecl(Shadow);
    $this().IdResolver.RemoveDecl(Shadow);
  }
  
  // ...and the using decl.
  Shadow.getUsingDecl().removeShadowDecl(Shadow);
  // TODO: complain somehow if Shadow was used.  It shouldn't
  // be possible for this to happen, because...?
}


/// Determines whether to create a using shadow decl for a particular
/// decl, given the set of decls existing prior to this using lookup.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckUsingShadowDecl">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 7891,
 FQN="clang::Sema::CheckUsingShadowDecl", NM="_ZN5clang4Sema20CheckUsingShadowDeclEPNS_9UsingDeclEPNS_9NamedDeclERKNS_12LookupResultERPNS_15UsingShadowDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema20CheckUsingShadowDeclEPNS_9UsingDeclEPNS_9NamedDeclERKNS_12LookupResultERPNS_15UsingShadowDeclE")
//</editor-fold>
public final boolean CheckUsingShadowDecl(UsingDecl /*P*/ Using, NamedDecl /*P*/ Orig, 
                    final /*const*/ LookupResult /*&*/ Previous, 
                    final type$ref<UsingShadowDecl /*P*/ /*&*/> PrevShadow) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Diagnose finding a decl which is not from a base class of the
    // current class.  We do this now because there are cases where this
    // function will silently decide not to build a shadow decl, which
    // will pre-empt further diagnostics.
    //
    // We don't need to do this in C++11 because we do the check once on
    // the qualifier.
    //
    // FIXME: diagnose the following if we care enough:
    //   struct A { int foo; };
    //   struct B : A { using A::foo; };
    //   template <class T> struct C : A {};
    //   template <class T> struct D : C<T> { using B::foo; } // <---
    // This is invalid (during instantiation) in C++03 because B::foo
    // resolves to the using decl in B, which is not a base class of D<T>.
    // We can't diagnose it immediately because C<T> is an unknown
    // specialization.  The UsingShadowDecl in D<T> then points directly
    // to A::foo, which will look well-formed when we instantiate.
    // The right solution is to not collapse the shadow-decl chain.
    if (!$this().getLangOpts().CPlusPlus11 && $this().CurContext.isRecord()) {
      DeclContext /*P*/ OrigDC = Orig.getDeclContext();
      
      // Handle enums and anonymous structs.
      if (isa_EnumDecl(OrigDC)) {
        OrigDC = OrigDC.getParent();
      }
      CXXRecordDecl /*P*/ OrigRec = cast_CXXRecordDecl(OrigDC);
      while (OrigRec.isAnonymousStructOrUnion()) {
        OrigRec = cast_CXXRecordDecl(OrigRec.getDeclContext());
      }
      if (cast_CXXRecordDecl($this().CurContext).isProvablyNotDerivedFrom(OrigRec)) {
        if (OrigDC == $this().CurContext) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Using.getLocation(), 
                  diag.err_using_decl_nested_name_specifier_is_current_class)), 
              Using.getQualifierLoc().getSourceRange()));
          $c$.clean($c$.track($this().Diag(Orig.getLocation(), diag.note_using_decl_target)));
          return true;
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_NestedNameSpec($c$.track($this().Diag(Using.getQualifierLoc().getBeginLoc(), 
                        diag.err_using_decl_nested_name_specifier_is_not_base_class)), 
                    Using.getQualifier()), 
                cast_CXXRecordDecl($this().CurContext)), 
            Using.getQualifierLoc().getSourceRange()));
        $c$.clean($c$.track($this().Diag(Orig.getLocation(), diag.note_using_decl_target)));
        return true;
      }
    }
    if (Previous.empty()) {
      return false;
    }
    
    NamedDecl /*P*/ Target = Orig;
    if (isa_UsingShadowDecl(Target)) {
      Target = cast_UsingShadowDecl(Target).getTargetDecl();
    }
    
    // If the target happens to be one of the previous declarations, we
    // don't have a conflict.
    // 
    // FIXME: but we might be increasing its access, in which case we
    // should redeclare it.
    NamedDecl /*P*/ NonTag = null;
    NamedDecl /*P*/ Tag = null;
    boolean FoundEquivalentDecl = false;
    for (UnresolvedSetIterator I = Previous.begin(), E = Previous.end();
         I.$noteq(E); I.$preInc()) {
      NamedDecl /*P*/ D = (I.$star()).getUnderlyingDecl();
      // We can have UsingDecls in our Previous results because we use the same
      // LookupResult for checking whether the UsingDecl itself is a valid
      // redeclaration.
      if (isa_UsingDecl(D)) {
        continue;
      }
      if (IsEquivalentForUsingDecl($this().Context, D, Target)) {
        {
          UsingShadowDecl /*P*/ Shadow = dyn_cast_UsingShadowDecl(I.$star());
          if ((Shadow != null)) {
            PrevShadow.$set(Shadow);
          }
        }
        FoundEquivalentDecl = true;
      } else if ($this().isEquivalentInternalLinkageDeclaration(D, Target)) {
        // We don't conflict with an existing using shadow decl of an equivalent
        // declaration, but we're not a redeclaration of it.
        FoundEquivalentDecl = true;
      }
      if ($this().isVisible(D)) {
        //(isa_TagDecl(D) ? Tag : NonTag) = D;
        if (isa_TagDecl(D)) {
          Tag = D;
        } else {
          NonTag = D;
        }
      }
    }
    if (FoundEquivalentDecl) {
      return false;
    }
    {
      
      FunctionDecl /*P*/ FD = Target.getAsFunction();
      if ((FD != null)) {
        type$ref<NamedDecl /*P*/ > OldDecl = create_type$null$ref(null);
        switch ($this().CheckOverload((Scope /*P*/ )null, FD, Previous, OldDecl, 
            /*IsForUsingDecl*/ true)) {
         case Ovl_Overload:
          return false;
         case Ovl_NonFunction:
          $c$.clean($c$.track($this().Diag(Using.getLocation(), diag.err_using_decl_conflict)));
          break;
         case Ovl_Match:
          // If we're in a record, we want to hide the target, so we
          // return true (without a diagnostic) to tell the caller not to
          // build a shadow decl.
          if ($this().CurContext.isRecord()) {
            return true;
          }
          
          // If we're not in a record, this is an error.
          $c$.clean($c$.track($this().Diag(Using.getLocation(), diag.err_using_decl_conflict)));
          break;
        }
        
        $c$.clean($c$.track($this().Diag(Target.getLocation(), diag.note_using_decl_target)));
        $c$.clean($c$.track($this().Diag(OldDecl.$deref().getLocation(), diag.note_using_decl_conflict)));
        return true;
      }
    }
    
    // Target is not a function.
    if (isa_TagDecl(Target)) {
      // No conflict between a tag and a non-tag.
      if (!(Tag != null)) {
        return false;
      }
      
      $c$.clean($c$.track($this().Diag(Using.getLocation(), diag.err_using_decl_conflict)));
      $c$.clean($c$.track($this().Diag(Target.getLocation(), diag.note_using_decl_target)));
      $c$.clean($c$.track($this().Diag(Tag.getLocation(), diag.note_using_decl_conflict)));
      return true;
    }
    
    // No conflict between a tag and a non-tag.
    if (!(NonTag != null)) {
      return false;
    }
    
    $c$.clean($c$.track($this().Diag(Using.getLocation(), diag.err_using_decl_conflict)));
    $c$.clean($c$.track($this().Diag(Target.getLocation(), diag.note_using_decl_target)));
    $c$.clean($c$.track($this().Diag(NonTag.getLocation(), diag.note_using_decl_conflict)));
    return true;
  } finally {
    $c$.$destroy();
  }
}


/// Builds a shadow declaration corresponding to a 'using' declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildUsingShadowDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 8041,
 FQN="clang::Sema::BuildUsingShadowDecl", NM="_ZN5clang4Sema20BuildUsingShadowDeclEPNS_5ScopeEPNS_9UsingDeclEPNS_9NamedDeclEPNS_15UsingShadowDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema20BuildUsingShadowDeclEPNS_5ScopeEPNS_9UsingDeclEPNS_9NamedDeclEPNS_15UsingShadowDeclE")
//</editor-fold>
public final UsingShadowDecl /*P*/ BuildUsingShadowDecl(Scope /*P*/ S, 
                    UsingDecl /*P*/ UD, 
                    NamedDecl /*P*/ Orig, 
                    UsingShadowDecl /*P*/ PrevDecl) {
  // If we resolved to another shadow declaration, just coalesce them.
  NamedDecl /*P*/ Target = Orig;
  if (isa_UsingShadowDecl(Target)) {
    Target = cast_UsingShadowDecl(Target).getTargetDecl();
    assert (!isa_UsingShadowDecl(Target)) : "nested shadow declaration";
  }
  
  NamedDecl /*P*/ NonTemplateTarget = Target;
  {
    TemplateDecl /*P*/ TargetTD = dyn_cast_TemplateDecl(Target);
    if ((TargetTD != null)) {
      NonTemplateTarget = TargetTD.getTemplatedDecl();
    }
  }
  
  UsingShadowDecl /*P*/ Shadow;
  if (isa_CXXConstructorDecl(NonTemplateTarget)) {
    boolean IsVirtualBase = isVirtualDirectBase(cast_CXXRecordDecl($this().CurContext), 
        UD.getQualifier().getAsRecordDecl());
    Shadow = ConstructorUsingShadowDecl.Create($this().Context, $this().CurContext, UD.getLocation(), UD, Orig, IsVirtualBase);
  } else {
    Shadow = UsingShadowDecl.Create($this().Context, $this().CurContext, UD.getLocation(), UD, 
        Target);
  }
  UD.addShadowDecl(Shadow);
  
  Shadow.setAccess(UD.getAccess());
  if (Orig.isInvalidDecl() || UD.isInvalidDecl()) {
    Shadow.setInvalidDecl();
  }
  
  Shadow.setPreviousDecl(PrevDecl);
  if ((S != null)) {
    $this().PushOnScopeChains(Shadow, S);
  } else {
    $this().CurContext.addDecl(Shadow);
  }
  
  return Shadow;
}


/// Checks that the given using declaration is not an invalid
/// redeclaration.  Note that this is checking only for the using decl
/// itself, not for any ill-formedness among the UsingShadowDecls.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckUsingDeclRedeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 8500,
 FQN="clang::Sema::CheckUsingDeclRedeclaration", NM="_ZN5clang4Sema27CheckUsingDeclRedeclarationENS_14SourceLocationEbRKNS_12CXXScopeSpecES1_RKNS_12LookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema27CheckUsingDeclRedeclarationENS_14SourceLocationEbRKNS_12CXXScopeSpecES1_RKNS_12LookupResultE")
//</editor-fold>
public final boolean CheckUsingDeclRedeclaration(SourceLocation UsingLoc, 
                           boolean HasTypenameKeyword, 
                           final /*const*/ CXXScopeSpec /*&*/ SS, 
                           SourceLocation NameLoc, 
                           final /*const*/ LookupResult /*&*/ Prev) {
  // C++03 [namespace.udecl]p8:
  // C++0x [namespace.udecl]p10:
  //   A using-declaration is a declaration and can therefore be used
  //   repeatedly where (and only where) multiple declarations are
  //   allowed.
  //
  // That's in non-member contexts.
  if (!$this().CurContext.getRedeclContext().isRecord()) {
    return false;
  }
  
  NestedNameSpecifier /*P*/ Qual = SS.getScopeRep();
  
  for (UnresolvedSetIterator I = Prev.begin(), E = Prev.end(); I.$noteq(E); I.$preInc()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      NamedDecl /*P*/ D = I.$star();
      
      boolean DTypename;
      NestedNameSpecifier /*P*/ DQual;
      {
        UsingDecl /*P*/ UD = dyn_cast_UsingDecl(D);
        if ((UD != null)) {
          DTypename = UD.hasTypename();
          DQual = UD.getQualifier();
        } else {
          UnresolvedUsingValueDecl /*P*/ UD$1 = dyn_cast_UnresolvedUsingValueDecl(D);
          if ((UD$1 != null)) {
            DTypename = false;
            DQual = UD$1.getQualifier();
          } else {
            UnresolvedUsingTypenameDecl /*P*/ UD$2 = dyn_cast_UnresolvedUsingTypenameDecl(D);
            if ((UD$2 != null)) {
              DTypename = true;
              DQual = UD$2.getQualifier();
            } else {
              continue;
            }
          }
        }
      }
      
      // using decls differ if one says 'typename' and the other doesn't.
      // FIXME: non-dependent using decls?
      if (HasTypenameKeyword != DTypename) {
        continue;
      }
      
      // using decls differ if they name different scopes (but note that
      // template instantiation can cause this check to trigger when it
      // didn't before instantiation).
      if ($this().Context.getCanonicalNestedNameSpecifier(Qual)
         != $this().Context.getCanonicalNestedNameSpecifier(DQual)) {
        continue;
      }
      
      $c$.clean($out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_using_decl_redeclaration)), SS.getRange()));
      $c$.clean($out_SemaDiagnosticBuilder_int($c$.track($this().Diag(D.getLocation(), diag.note_using_decl)), 1));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}


/// Checks that the given nested-name qualifier used in a using decl
/// in the current context is appropriately related to the current
/// scope.  If an error is found, diagnoses it and returns true.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckUsingDeclQualifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 8558,
 FQN="clang::Sema::CheckUsingDeclQualifier", NM="_ZN5clang4Sema23CheckUsingDeclQualifierENS_14SourceLocationERKNS_12CXXScopeSpecERKNS_19DeclarationNameInfoES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema23CheckUsingDeclQualifierENS_14SourceLocationERKNS_12CXXScopeSpecERKNS_19DeclarationNameInfoES1_")
//</editor-fold>
public final boolean CheckUsingDeclQualifier(SourceLocation UsingLoc, 
                       final /*const*/ CXXScopeSpec /*&*/ SS, 
                       final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
                       SourceLocation NameLoc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    DeclContext /*P*/ NamedContext = $this().computeDeclContext(SS);
    if (!$this().CurContext.isRecord()) {
      // C++03 [namespace.udecl]p3:
      // C++0x [namespace.udecl]p8:
      //   A using-declaration for a class member shall be a member-declaration.
      
      // If we weren't able to compute a valid scope, it must be a
      // dependent class scope.
      if (!(NamedContext != null) || NamedContext.getRedeclContext().isRecord()) {
        LookupResult R = null;
        try {
          CXXRecordDecl /*P*/ RD = (NamedContext != null) ? cast_CXXRecordDecl(NamedContext.getRedeclContext()) : null;
          if ((RD != null) && $this().RequireCompleteDeclContext(((/*const_cast*/CXXScopeSpec /*&*/ )(SS)), RD)) {
            RD = null;
          }
          
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_using_decl_can_not_refer_to_class_member)), 
              SS.getRange()));
          
          // If we have a complete, non-dependent source type, try to suggest a
          // way to get the same effect.
          if (!(RD != null)) {
            return true;
          }
          
          // Find what this using-declaration was referring to.
          R/*J*/= new LookupResult(/*Deref*/$this(), NameInfo, LookupNameKind.LookupOrdinaryName);
          R.setHideTags(false);
          R.suppressDiagnostics();
          $this().LookupQualifiedName(R, RD);
          if ((R.<TypeDecl>getAsSingle(TypeDecl.class) != null)) {
            if ($this().getLangOpts().CPlusPlus11) {
              // Convert 'using X::Y;' to 'using Y = X::Y;'.
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SS.getBeginLoc(), diag.note_using_decl_class_member_workaround)), 
                      0),  // alias declaration
                  FixItHint.CreateInsertion(SS.getBeginLoc(), 
                      new StringRef($add_string_T$C$P(NameInfo.getName().getAsString(), 
                              /*KEEP_STR*/" = ")))));
            } else {
              // Convert 'using X::Y;' to 'typedef X::Y Y;'.
              SourceLocation InsertLoc = $this().getLocForEndOfToken(NameInfo.getLocEnd());
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(InsertLoc), diag.note_using_decl_class_member_workaround)), 
                          1),  // typedef declaration
                      FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/UsingLoc), new StringRef(/*KEEP_STR*/$typedef))), 
                  FixItHint.CreateInsertion(/*NO_COPY*/InsertLoc, new StringRef($add_T$C$P_string(/*KEEP_STR*/" ", NameInfo.getName().getAsString())))));
            }
          } else if ((R.<VarDecl>getAsSingle(VarDecl.class) != null)) {
            // Don't provide a fixit outside C++11 mode; we don't want to suggest
            // repeating the type of the static data member here.
            FixItHint FixIt/*J*/= new FixItHint();
            if ($this().getLangOpts().CPlusPlus11) {
              // Convert 'using X::Y;' to 'auto &Y = X::Y;'.
              FixIt.$assignMove(FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/UsingLoc), new StringRef($add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"auto &", NameInfo.getName().getAsString()), /*KEEP_STR*/" = "))));
            }
            
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(UsingLoc), diag.note_using_decl_class_member_workaround)), 
                    2),  // reference declaration
                FixIt));
          } else if ((R.<EnumConstantDecl>getAsSingle(EnumConstantDecl.class) != null)) {
            // Don't provide a fixit outside C++11 mode; we don't want to suggest
            // repeating the type of the enumeration here, and we can't do so if
            // the type is anonymous.
            FixItHint FixIt/*J*/= new FixItHint();
            if ($this().getLangOpts().CPlusPlus11) {
              // Convert 'using X::Y;' to 'auto &Y = X::Y;'.
              FixIt.$assignMove(FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/UsingLoc), new StringRef($add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"constexpr auto ", NameInfo.getName().getAsString()), /*KEEP_STR*/" = "))));
            }
            
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(UsingLoc), diag.note_using_decl_class_member_workaround)), 
                    ($this().getLangOpts().CPlusPlus11 ? 4 : 3)),  // const[expr] variable
                FixIt));
          }
          return true;
        } finally {
          if (R != null) { R.$destroy(); }
        }
      }
      
      // Otherwise, everything is known to be fine.
      return false;
    }
    
    // The current scope is a record.
    
    // If the named context is dependent, we can't decide much.
    if (!(NamedContext != null)) {
      // FIXME: in C++0x, we can diagnose if we can prove that the
      // nested-name-specifier does not refer to a base class, which is
      // still possible in some cases.
      
      // Otherwise we have to conservatively report that things might be
      // okay.
      return false;
    }
    if (!NamedContext.isRecord()) {
      // Ideally this would point at the last name in the specifier,
      // but we don't have that level of source info.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_NestedNameSpec($c$.track($this().Diag(SS.getRange().getBegin(), 
                  diag.err_using_decl_nested_name_specifier_is_not_class)), 
              SS.getScopeRep()), SS.getRange()));
      return true;
    }
    if (!NamedContext.isDependentContext()
       && $this().RequireCompleteDeclContext(((/*const_cast*/CXXScopeSpec /*&*/ )(SS)), NamedContext)) {
      return true;
    }
    if ($this().getLangOpts().CPlusPlus11) {
      // C++11 [namespace.udecl]p3:
      //   In a using-declaration used as a member-declaration, the
      //   nested-name-specifier shall name a base class of the class
      //   being defined.
      if (cast_CXXRecordDecl($this().CurContext).isProvablyNotDerivedFrom(cast_CXXRecordDecl(NamedContext))) {
        if ($this().CurContext == NamedContext) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NameLoc), 
                  diag.err_using_decl_nested_name_specifier_is_current_class)), 
              SS.getRange()));
          return true;
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_NestedNameSpec($c$.track($this().Diag(SS.getRange().getBegin(), 
                        diag.err_using_decl_nested_name_specifier_is_not_base_class)), 
                    SS.getScopeRep()), 
                cast_CXXRecordDecl($this().CurContext)), 
            SS.getRange()));
        return true;
      }
      
      return false;
    }
    
    // C++03 [namespace.udecl]p4:
    //   A using-declaration used as a member-declaration shall refer
    //   to a member of a base class of the class being defined [etc.].
    
    // Salient point: SS doesn't have to name a base class as long as
    // lookup only finds members from base classes.  Therefore we can
    // diagnose here only if we can prove that that can't happen,
    // i.e. if the class hierarchies provably don't intersect.
    
    // TODO: it would be nice if "definitely valid" results were cached
    // in the UsingDecl and UsingShadowDecl so that these checks didn't
    // need to be repeated.
    SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > Bases/*J*/= new SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    ForallBasesCallback Collect = /*[&Bases]*/ (/*const*/ CXXRecordDecl /*P*/ Base) -> {
          Bases.insert(Base);
          return true;
        };
    
    // Collect all bases. Return false if we find a dependent base.
    if (!cast_CXXRecordDecl($this().CurContext).forallBases(/*FuncArg*/Collect)) {
      return false;
    }
    
    // Returns true if the base is dependent or is one of the accumulated base
    // classes.
    ForallBasesCallback IsNotBase = /*[&Bases]*/ (/*const*/ CXXRecordDecl /*P*/ Base) -> {
          return !(Bases.count(Base) != 0);
        };
    
    // Return false if the class has a dependent base or if it or one
    // of its bases is present in the base set of the current context.
    if ((Bases.count(cast_CXXRecordDecl(NamedContext)) != 0)
       || !cast_CXXRecordDecl(NamedContext).forallBases(/*FuncArg*/IsNotBase)) {
      return false;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_NestedNameSpec($c$.track($this().Diag(SS.getRange().getBegin(), 
                    diag.err_using_decl_nested_name_specifier_is_not_base_class)), 
                SS.getScopeRep()), 
            cast_CXXRecordDecl($this().CurContext)), 
        SS.getRange()));
    
    return true;
  } finally {
    $c$.$destroy();
  }
}

// end anonymous namespace

/// Builds a using declaration.
///
/// \param IsInstantiation - Whether this call arises from an
///   instantiation of an unresolved using declaration.  We treat
///   the lookup differently for these declarations.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildUsingDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 8232,
 FQN="clang::Sema::BuildUsingDeclaration", NM="_ZN5clang4Sema21BuildUsingDeclarationEPNS_5ScopeENS_15AccessSpecifierENS_14SourceLocationERNS_12CXXScopeSpecENS_19DeclarationNameInfoEPNS_13AttributeListEbbS4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema21BuildUsingDeclarationEPNS_5ScopeENS_15AccessSpecifierENS_14SourceLocationERNS_12CXXScopeSpecENS_19DeclarationNameInfoEPNS_13AttributeListEbbS4_")
//</editor-fold>
public final NamedDecl /*P*/ BuildUsingDeclaration(Scope /*P*/ S, AccessSpecifier AS, 
                     SourceLocation UsingLoc, 
                     final CXXScopeSpec /*&*/ SS, 
                     DeclarationNameInfo NameInfo, 
                     AttributeList /*P*/ AttrList, 
                     boolean IsInstantiation, 
                     boolean HasTypenameKeyword, 
                     SourceLocation TypenameLoc) {
  LookupResult Previous = null;
  LookupResult R = null;
  try {
    assert (!SS.isInvalid()) : "Invalid CXXScopeSpec.";
    SourceLocation IdentLoc = NameInfo.getLoc();
    assert (IdentLoc.isValid()) : "Invalid TargetName location.";
    
    // FIXME: We ignore attributes for now.
    if (SS.isEmpty()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(IdentLoc), diag.err_using_requires_qualname)));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    
    // For an inheriting constructor declaration, the name of the using
    // declaration is the name of a constructor in this class, not in the
    // base class.
    DeclarationNameInfo UsingName = new DeclarationNameInfo(NameInfo);
    if (UsingName.getName().getNameKind() == DeclarationName.NameKind.CXXConstructorName) {
      {
        CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl($this().CurContext);
        if ((RD != null)) {
          UsingName.setName($this().Context.DeclarationNames.getCXXConstructorName($this().Context.getCanonicalType($this().Context.getRecordType(RD))));
        }
      }
    }
    
    // Do the redeclaration lookup in the current scope.
    Previous/*J*/= new LookupResult(/*Deref*/$this(), UsingName, LookupNameKind.LookupUsingDeclName, 
        RedeclarationKind.ForRedeclaration);
    Previous.setHideTags(false);
    if ((S != null)) {
      LookupResult.Filter F = null;
      try {
        $this().LookupName(Previous, S);
        
        // It is really dumb that we have to do this.
        F = Previous.makeFilter();
        while (F.hasNext()) {
          NamedDecl /*P*/ D = F.next();
          if (!$this().isDeclInScope(D, $this().CurContext, S)) {
            F.erase();
          } else // If we found a local extern declaration that's not ordinarily visible,
          // and this declaration is being added to a non-block scope, ignore it.
          // We're only checking for scope conflicts here, not also for violations
          // of the linkage rules.
          if (!$this().CurContext.isFunctionOrMethod() && D.isLocalExternDecl()
             && !((D.getIdentifierNamespace() & Decl.IdentifierNamespace.IDNS_Ordinary) != 0)) {
            F.erase();
          }
        }
        F.done();
      } finally {
        if (F != null) { F.$destroy(); }
      }
    } else {
      assert (IsInstantiation) : "no scope in non-instantiation";
      assert ($this().CurContext.isRecord()) : "scope not record in instantiation";
      $this().LookupQualifiedName(Previous, $this().CurContext);
    }
    
    // Check for invalid redeclarations.
    if ($this().CheckUsingDeclRedeclaration(new SourceLocation(UsingLoc), HasTypenameKeyword, 
        SS, new SourceLocation(IdentLoc), Previous)) {
      return null;
    }
    
    // Check for bad qualifiers.
    if ($this().CheckUsingDeclQualifier(new SourceLocation(UsingLoc), SS, NameInfo, new SourceLocation(IdentLoc))) {
      return null;
    }
    
    DeclContext /*P*/ LookupContext = $this().computeDeclContext(SS);
    NamedDecl /*P*/ D;
    NestedNameSpecifierLoc QualifierLoc = SS.getWithLocInContext($this().Context);
    if (!(LookupContext != null)) {
      if (HasTypenameKeyword) {
        // FIXME: not all declaration name kinds are legal here
        D = UnresolvedUsingTypenameDecl.Create($this().Context, $this().CurContext, 
            new SourceLocation(UsingLoc), new SourceLocation(TypenameLoc), 
            new NestedNameSpecifierLoc(QualifierLoc), 
            new SourceLocation(IdentLoc), NameInfo.getName());
      } else {
        D = UnresolvedUsingValueDecl.Create($this().Context, $this().CurContext, new SourceLocation(UsingLoc), 
            new NestedNameSpecifierLoc(QualifierLoc), NameInfo);
      }
      D.setAccess(AS);
      $this().CurContext.addDecl(D);
      return D;
    }
    
    Bool2UsingDecl Build = /*[&, this, &UsingLoc, &QualifierLoc, &UsingName, &HasTypenameKeyword, &AS]*/ (boolean Invalid) -> {
          UsingDecl /*P*/ UD = UsingDecl.Create($this().Context, $this().CurContext, new SourceLocation(UsingLoc), new NestedNameSpecifierLoc(QualifierLoc), 
              UsingName, HasTypenameKeyword);
          UD.setAccess(AS);
          $this().CurContext.addDecl(UD);
          UD.setInvalidDecl(Invalid);
          return UD;
        };
    Void2UsingDecl BuildInvalid = /*[&, &Build]*/() -> {
          return Build.$call(/*KEEP_BOOL*/true);
        };
    Void2UsingDecl BuildValid = /*[&, &Build]*/() -> {
          return Build.$call(/*KEEP_BOOL*/false);
        };
    if ($this().RequireCompleteDeclContext(SS, LookupContext)) {
      return BuildInvalid.$call();
    }
    
    // Look up the target name.
    R/*J*/= new LookupResult(/*Deref*/$this(), NameInfo, LookupNameKind.LookupOrdinaryName);
    
    // Unlike most lookups, we don't always want to hide tag
    // declarations: tag names are visible through the using declaration
    // even if hidden by ordinary names, *except* in a dependent context
    // where it's important for the sanity of two-phase lookup.
    if (!IsInstantiation) {
      R.setHideTags(false);
    }
    
    // For the purposes of this lookup, we have a base object type
    // equal to that of the current context.
    if ($this().CurContext.isRecord()) {
      R.setBaseObjectType($this().Context.getTypeDeclType(cast_CXXRecordDecl($this().CurContext)));
    }
    
    $this().LookupQualifiedName(R, LookupContext);
    
    // Try to correct typos if possible. If constructor name lookup finds no
    // results, that means the named class has no explicit constructors, and we
    // suppressed declaring implicit ones (probably because it's dependent or
    // invalid).
    if (R.empty()
       && NameInfo.getName().getNameKind() != DeclarationName.NameKind.CXXConstructorName) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        {
          TypoCorrection Corrected = $c$.clean($this().CorrectTypo(R.getLookupNameInfo(), R.getLookupKind(), S, $AddrOf(SS), 
              $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new UsingValidatorCCC(HasTypenameKeyword, IsInstantiation, SS.getScopeRep(), 
                      dyn_cast_CXXRecordDecl($this().CurContext)))))), 
              CorrectTypoKind.CTK_ErrorRecovery));
          if (Corrected.$bool()) {
            // We reject any correction for which ND would be NULL.
            NamedDecl /*P*/ ND = Corrected.getCorrectionDecl();

            // We reject candidates where DroppedSpecifier == true, hence the
            // literal '0' below.
            $this().diagnoseTypo(Corrected, $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_int($out$Same2DeclContext($out_PartialDiagnostic$C_DeclarationName($c$.track($this().PDiag(diag.err_no_member_suggest)), 
                                NameInfo.getName()), LookupContext), 0), 
                    SS.getRange())); $c$.clean();

            // If we corrected to an inheriting constructor, handle it as one.
            CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(ND);
            if ((RD != null) && RD.isInjectedClassName()) {
              // The parent of the injected class name is the class itself.
              RD = cast_CXXRecordDecl(RD.getParent());

              // Fix up the information we'll use to build the using declaration.
              if (Corrected.WillReplaceSpecifier()) {
                NestedNameSpecifierLocBuilder Builder = null;
                try {
                  Builder/*J*/= new NestedNameSpecifierLocBuilder();
                  Builder.MakeTrivial($this().Context, Corrected.getCorrectionSpecifier(), 
                      QualifierLoc.getSourceRange());
                  QualifierLoc.$assignMove(Builder.getWithLocInContext($this().Context));
                } finally {
                  if (Builder != null) { Builder.$destroy(); }
                }
              }

              // In this case, the name we introduce is the name of a derived class
              // constructor.
              CXXRecordDecl /*P*/ CurClass = cast_CXXRecordDecl($this().CurContext);
              UsingName.setName($this().Context.DeclarationNames.getCXXConstructorName($this().Context.getCanonicalType($this().Context.getRecordType(CurClass))));
              UsingName.setNamedTypeInfo((TypeSourceInfo /*P*/ )null);
              for (NamedDecl /*P*/ Ctor : $this().LookupConstructors(RD))  {
                R.addDecl(Ctor);
              }
              R.resolveKind();
            } else {
              // FIXME: Pick up all the declarations if we found an overloaded
              // function.
              UsingName.setName(ND.getDeclName());
              R.addDecl(ND);
            }
          } else {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IdentLoc), diag.err_no_member)), 
                        NameInfo.getName()), LookupContext), SS.getRange()));
            return BuildInvalid.$call();
          }
        }
      } finally {
        $c$.$destroy();
      }
    }
    if (R.isAmbiguous()) {
      return BuildInvalid.$call();
    }
    if (HasTypenameKeyword) {
      // If we asked for a typename and got a non-type decl, error out.
      if (!(R.<TypeDecl>getAsSingle(TypeDecl.class) != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(IdentLoc), diag.err_using_typename_non_type)));
          for (UnresolvedSetIterator I = R.begin(), E = R.end(); I.$noteq(E); I.$preInc())  {
            $c$.clean($c$.track($this().Diag((I.$star()).getUnderlyingDecl().getLocation(), 
                diag.note_using_decl_target)));
          }
          return BuildInvalid.$call();
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      // If we asked for a non-typename and we got a type, error out,
      // but only if this is an instantiation of an unresolved using
      // decl.  Otherwise just silently find the type name.
      if (IsInstantiation && (R.<TypeDecl>getAsSingle(TypeDecl.class) != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(IdentLoc), diag.err_using_dependent_value_is_type)));
          $c$.clean($c$.track($this().Diag(R.getFoundDecl().getLocation(), diag.note_using_decl_target)));
          return BuildInvalid.$call();
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // C++14 [namespace.udecl]p6:
    // A using-declaration shall not name a namespace.
    if ((R.<NamespaceDecl>getAsSingle(NamespaceDecl.class) != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IdentLoc), diag.err_using_decl_can_not_refer_to_namespace)), 
            SS.getRange()));
        return BuildInvalid.$call();
      } finally {
        $c$.$destroy();
      }
    }
    {
      
      // C++14 [namespace.udecl]p7:
      // A using-declaration shall not name a scoped enumerator.
      EnumConstantDecl /*P*/ ED = R.<EnumConstantDecl>getAsSingle(EnumConstantDecl.class);
      if ((ED != null)) {
        if (cast_EnumDecl(ED.getDeclContext()).isScoped()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IdentLoc), diag.err_using_decl_can_not_refer_to_scoped_enum)), 
                SS.getRange()));
            return BuildInvalid.$call();
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    UsingDecl /*P*/ UD = BuildValid.$call();
    
    // Some additional rules apply to inheriting constructors.
    if (UsingName.getName().getNameKind()
       == DeclarationName.NameKind.CXXConstructorName) {
      // Suppress access diagnostics; the access check is instead performed at the
      // point of use for an inheriting constructor.
      R.suppressDiagnostics();
      if ($this().CheckInheritingConstructorUsingDecl(UD)) {
        return UD;
      }
    }
    
    for (UnresolvedSetIterator I = R.begin(), E = R.end(); I.$noteq(E); I.$preInc()) {
      type$ref<UsingShadowDecl /*P*/ > PrevDecl = create_type$null$ref(null);
      if (!$this().CheckUsingShadowDecl(UD, I.$star(), Previous, PrevDecl)) {
        $this().BuildUsingShadowDecl(S, UD, I.$star(), PrevDecl.$deref());
      }
    }
    
    return UD;
  } finally {
    if (R != null) { R.$destroy(); }
    if (Previous != null) { Previous.$destroy(); }
  }
}


/// Additional checks for a using declaration referring to a constructor name.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckInheritingConstructorUsingDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 8470,
 FQN="clang::Sema::CheckInheritingConstructorUsingDecl", NM="_ZN5clang4Sema35CheckInheritingConstructorUsingDeclEPNS_9UsingDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema35CheckInheritingConstructorUsingDeclEPNS_9UsingDeclE")
//</editor-fold>
public final boolean CheckInheritingConstructorUsingDecl(UsingDecl /*P*/ UD) {
  assert (!UD.hasTypename()) : "expecting a constructor name";
  
  /*const*/ Type /*P*/ SourceType = UD.getQualifier().getAsType();
  assert ((SourceType != null)) : "Using decl naming constructor doesn't have type in scope spec.";
  CXXRecordDecl /*P*/ TargetClass = cast_CXXRecordDecl($this().CurContext);
  
  // Check whether the named type is a direct base class.
  bool$ref AnyDependentBases = create_bool$ref(false);
  CXXBaseSpecifier /*P*/ Base = findDirectBaseWithType(TargetClass, new QualType(SourceType, 0), 
      AnyDependentBases);
  if (!(Base != null) && !AnyDependentBases.$deref()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(UD.getUsingLoc(), 
                      diag.err_using_decl_constructor_not_in_direct_base)), 
                  UD.getNameInfo().getSourceRange()), 
              new QualType(SourceType, 0)), TargetClass));
      UD.setInvalidDecl();
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  if ((Base != null)) {
    Base.setInheritConstructors();
  }
  
  return false;
}


/// Given a derived-class using shadow declaration for a constructor and the
/// correspnding base class constructor, find or create the implicit
/// synthesized derived class constructor to use for this initialization.

/// Find or create the fake constructor we synthesize to model constructing an
/// object of a derived class via a constructor of a base class.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::findInheritingConstructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9241,
 FQN="clang::Sema::findInheritingConstructor", NM="_ZN5clang4Sema25findInheritingConstructorENS_14SourceLocationEPNS_18CXXConstructorDeclEPNS_26ConstructorUsingShadowDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema25findInheritingConstructorENS_14SourceLocationEPNS_18CXXConstructorDeclEPNS_26ConstructorUsingShadowDeclE")
//</editor-fold>
public final CXXConstructorDecl /*P*/ findInheritingConstructor(SourceLocation Loc, 
                         CXXConstructorDecl /*P*/ BaseCtor, 
                         ConstructorUsingShadowDecl /*P*/ Shadow) {
  InheritedConstructorInfo ICI = null;
  try {
    CXXRecordDecl /*P*/ Derived = Shadow.getParent();
    SourceLocation UsingLoc = Shadow.getLocation();
    
    // FIXME: Add a new kind of DeclarationName for an inherited constructor.
    // For now we use the name of the base class constructor as a member of the
    // derived class to indicate a (fake) inherited constructor name.
    DeclarationName Name = BaseCtor.getDeclName();
    
    // Check to see if we already have a fake constructor for this inherited
    // constructor call.
    for (NamedDecl /*P*/ Ctor : Derived.lookup(new DeclarationName(Name)))  {
      if (declaresSameEntity(cast_CXXConstructorDecl(Ctor).
              getInheritedConstructor().
              getConstructor(), 
          BaseCtor)) {
        return cast_CXXConstructorDecl(Ctor);
      }
    }
    
    DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo(new DeclarationName(Name), new SourceLocation(UsingLoc));
    TypeSourceInfo /*P*/ TInfo = $this().Context.getTrivialTypeSourceInfo(BaseCtor.getType(), /*NO_COPY*/UsingLoc);
    FunctionProtoTypeLoc ProtoLoc = TInfo.getTypeLoc().IgnoreParens().castAs(FunctionProtoTypeLoc.class);
    
    // Check the inherited constructor is valid and find the list of base classes
    // from which it was inherited.
    ICI/*J*/= new InheritedConstructorInfo(/*Deref*/$this(), new SourceLocation(Loc), Shadow);
    
    boolean Constexpr = BaseCtor.isConstexpr()
       && defaultedSpecialMemberIsConstexpr(/*Deref*/$this(), Derived, CXXSpecialMember.CXXDefaultConstructor, 
        false, BaseCtor, $AddrOf(ICI));
    
    CXXConstructorDecl /*P*/ DerivedCtor = CXXConstructorDecl.Create($this().Context, Derived, new SourceLocation(UsingLoc), NameInfo, TInfo.getType(), TInfo, 
        BaseCtor.isExplicit(), /*Inline=*/ true, 
        /*ImplicitlyDeclared=*/ true, Constexpr, 
        new InheritedConstructor(Shadow, BaseCtor));
    if (Shadow.isInvalidDecl()) {
      DerivedCtor.setInvalidDecl();
    }
    
    // Build an unevaluated exception specification for this fake constructor.
    /*const*/ FunctionProtoType /*P*/ FPT = TInfo.getType().$arrow().castAs(FunctionProtoType.class);
    FunctionProtoType.ExtProtoInfo EPI = FPT.getExtProtoInfo();
    EPI.ExceptionSpec.Type = ExceptionSpecificationType.EST_Unevaluated;
    EPI.ExceptionSpec.SourceDecl = DerivedCtor;
    DerivedCtor.setType($this().Context.getFunctionType(FPT.getReturnType(), 
            FPT.getParamTypes(), EPI));
    
    // Build the parameter declarations.
    SmallVector<ParmVarDecl /*P*/ > ParamDecls/*J*/= new SmallVector<ParmVarDecl /*P*/ >(16, (ParmVarDecl /*P*/ )null);
    for (/*uint*/int I = 0, N = FPT.getNumParams(); I != N; ++I) {
      TypeSourceInfo /*P*/ TInfo$1 = $this().Context.getTrivialTypeSourceInfo(FPT.getParamType(I), /*NO_COPY*/UsingLoc);
      ParmVarDecl /*P*/ PD = ParmVarDecl.Create($this().Context, DerivedCtor, new SourceLocation(UsingLoc), new SourceLocation(UsingLoc), /*IdentifierInfo=*/ (IdentifierInfo /*P*/ )null, 
          FPT.getParamType(I), TInfo$1, StorageClass.SC_None, /*DefaultArg=*/ (Expr /*P*/ )null);
      PD.setScopeInfo(0, I);
      PD.setImplicit();
      // Ensure attributes are propagated onto parameters (this matters for
      // format, pass_object_size, ...).
      $this().mergeDeclAttributes(PD, BaseCtor.getParamDecl(I));
      ParamDecls.push_back(PD);
      ProtoLoc.setParam(I, PD);
    }
    
    // Set up the new constructor.
    assert (!BaseCtor.isDeleted()) : "should not use deleted constructor";
    DerivedCtor.setAccess(BaseCtor.getAccess());
    DerivedCtor.setParams(new ArrayRef<ParmVarDecl /*P*/ >(ParamDecls, true));
    Derived.addDecl(DerivedCtor);
    if ($this().ShouldDeleteSpecialMember(DerivedCtor, CXXSpecialMember.CXXDefaultConstructor, $AddrOf(ICI))) {
      $this().SetDeclDeleted(DerivedCtor, new SourceLocation(UsingLoc));
    }
    
    return DerivedCtor;
  } finally {
    if (ICI != null) { ICI.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnUsingDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 7802,
 FQN="clang::Sema::ActOnUsingDeclaration", NM="_ZN5clang4Sema21ActOnUsingDeclarationEPNS_5ScopeENS_15AccessSpecifierEbNS_14SourceLocationERNS_12CXXScopeSpecERNS_13UnqualifiedIdEPNS_13AttributeListEbS4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema21ActOnUsingDeclarationEPNS_5ScopeENS_15AccessSpecifierEbNS_14SourceLocationERNS_12CXXScopeSpecERNS_13UnqualifiedIdEPNS_13AttributeListEbS4_")
//</editor-fold>
public final Decl /*P*/ ActOnUsingDeclaration(Scope /*P*/ S, 
                     AccessSpecifier AS, 
                     boolean HasUsingKeyword, 
                     SourceLocation UsingLoc, 
                     final CXXScopeSpec /*&*/ SS, 
                     final UnqualifiedId /*&*/ Name, 
                     AttributeList /*P*/ AttrList, 
                     boolean HasTypenameKeyword, 
                     SourceLocation TypenameLoc) {
  assert (((S.getFlags() & Scope.ScopeFlags.DeclScope) != 0)) : "Invalid Scope.";
  switch (Name.getKind()) {
   case IK_ImplicitSelfParam:
   case IK_Identifier:
   case IK_OperatorFunctionId:
   case IK_LiteralOperatorId:
   case IK_ConversionFunctionId:
    break;
   case IK_ConstructorName:
   case IK_ConstructorTemplateId:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // C++11 inheriting constructors.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Name.getLocStart(), 
                $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_using_decl_constructor : diag.err_using_decl_constructor)), 
            SS.getRange()));
        if ($this().getLangOpts().CPlusPlus11) {
          break;
        }
        
        return null;
      } finally {
        $c$.$destroy();
      }
    }
   case IK_DestructorName:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Name.getLocStart(), diag.err_using_decl_destructor)), 
            SS.getRange()));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
   case IK_TemplateId:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Name.getLocStart(), diag.err_using_decl_template_id)), 
            new SourceRange(/*NO_COPY*/Name.Unnamed_field1.TemplateId.LAngleLoc, /*NO_COPY*/Name.Unnamed_field1.TemplateId.RAngleLoc)));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  DeclarationNameInfo TargetNameInfo = $this().GetNameFromUnqualifiedId(Name);
  DeclarationName TargetName = TargetNameInfo.getName();
  if (!TargetName.$bool()) {
    return null;
  }
  
  // Warn about access declarations.
  if (!HasUsingKeyword) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Name.getLocStart(), 
              $this().getLangOpts().CPlusPlus11 ? diag.err_access_decl : diag.warn_access_decl_deprecated)), 
          FixItHint.CreateInsertion(SS.getRange().getBegin(), new StringRef(/*KEEP_STR*/"using "))));
    } finally {
      $c$.$destroy();
    }
  }
  if ($this().DiagnoseUnexpandedParameterPack(SS, UnexpandedParameterPackContext.UPPC_UsingDeclaration)
     || $this().DiagnoseUnexpandedParameterPack(TargetNameInfo, UnexpandedParameterPackContext.UPPC_UsingDeclaration)) {
    return null;
  }
  
  NamedDecl /*P*/ UD = $this().BuildUsingDeclaration(S, AS, new SourceLocation(UsingLoc), SS, 
      new DeclarationNameInfo(TargetNameInfo), AttrList, 
      /* IsInstantiation */ false, 
      HasTypenameKeyword, new SourceLocation(TypenameLoc));
  if ((UD != null)) {
    $this().PushOnScopeChains(UD, S, /*AddToContext*/ false);
  }
  
  return UD;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnAliasDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 8741,
 FQN="clang::Sema::ActOnAliasDeclaration", NM="_ZN5clang4Sema21ActOnAliasDeclarationEPNS_5ScopeENS_15AccessSpecifierEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEENS_14SourceLocationERNS_13UnqualifiedIdEPNS_13AttributeListENS_12ActionResultINS_9OpaquePtrINS_8QualTypeEEELb0EEEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema21ActOnAliasDeclarationEPNS_5ScopeENS_15AccessSpecifierEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEENS_14SourceLocationERNS_13UnqualifiedIdEPNS_13AttributeListENS_12ActionResultINS_9OpaquePtrINS_8QualTypeEEELb0EEEPNS_4DeclE")
//</editor-fold>
public final Decl /*P*/ ActOnAliasDeclaration(Scope /*P*/ S, 
                     AccessSpecifier AS, 
                     MutableArrayRef<TemplateParameterList /*P*/ > TemplateParamLists, 
                     SourceLocation UsingLoc, 
                     final UnqualifiedId /*&*/ Name, 
                     AttributeList /*P*/ AttrList, 
                     ActionResult<OpaquePtr<QualType> > Type, 
                     Decl /*P*/ DeclFromDeclSpec) {
  LookupResult Previous = null;
  try {
    // Skip up to the relevant declaration scope.
    while (S.isTemplateParamScope()) {
      S = S.getParent();
    }
    assert (((S.getFlags() & Scope.ScopeFlags.DeclScope) != 0)) : "got alias-declaration outside of declaration scope";
    if (Type.isInvalid()) {
      return null;
    }
    
    boolean Invalid = false;
    DeclarationNameInfo NameInfo = $this().GetNameFromUnqualifiedId(Name);
    type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr(null);
    GetTypeFromParser(Type.get(), $AddrOf(TInfo));
    if ($this().DiagnoseClassNameShadow($this().CurContext, new DeclarationNameInfo(NameInfo))) {
      return null;
    }
    if ($this().DiagnoseUnexpandedParameterPack(new SourceLocation(Name.StartLocation), TInfo.$star(), 
        UnexpandedParameterPackContext.UPPC_DeclarationType)) {
      Invalid = true;
      TInfo.$set($this().Context.getTrivialTypeSourceInfo($this().Context.IntTy.$QualType(), 
          TInfo.$star().getTypeLoc().getBeginLoc()));
    }
    
    Previous/*J*/= new LookupResult(/*Deref*/$this(), NameInfo, LookupNameKind.LookupOrdinaryName, RedeclarationKind.ForRedeclaration);
    $this().LookupName(Previous, S);
    
    // Warn about shadowing the name of a template parameter.
    if (Previous.isSingleResult()
       && Previous.getFoundDecl().isTemplateParameter()) {
      $this().DiagnoseTemplateParameterShadow(new SourceLocation(Name.StartLocation), Previous.getFoundDecl());
      Previous.clear();
    }
    assert (Name.Kind == UnqualifiedId.IdKind.IK_Identifier) : "name in alias declaration must be an identifier";
    TypeAliasDecl /*P*/ NewTD = TypeAliasDecl.Create($this().Context, $this().CurContext, new SourceLocation(UsingLoc), 
        new SourceLocation(Name.StartLocation), 
        Name.Unnamed_field1.Identifier, TInfo.$star());
    
    NewTD.setAccess(AS);
    if (Invalid) {
      NewTD.setInvalidDecl();
    }
    
    $this().ProcessDeclAttributeList(S, NewTD, AttrList);
    
    $this().CheckTypedefForVariablyModifiedType(S, NewTD);
    Invalid |= NewTD.isInvalidDecl();
    
    bool$ref Redeclaration = create_bool$ref(false);
    
    NamedDecl /*P*/ NewND;
    if ((TemplateParamLists.size() != 0)) {
      TypeAliasTemplateDecl /*P*/ OldDecl = null;
      TemplateParameterList /*P*/ OldTemplateParams = null;
      if (TemplateParamLists.size() != 1) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(UsingLoc), diag.err_alias_template_extra_headers)), 
              new SourceRange(TemplateParamLists.$at(1).getTemplateLoc(), 
                  TemplateParamLists.$at(TemplateParamLists.size() - 1).getRAngleLoc())));
        } finally {
          $c$.$destroy();
        }
      }
      TemplateParameterList /*P*/ TemplateParams = TemplateParamLists.$at(0);
      
      // Check that we can declare a template here.
      if ($this().CheckTemplateDeclScope(S, TemplateParams)) {
        return null;
      }
      
      // Only consider previous declarations in the same scope.
      $this().FilterLookupForScope(Previous, $this().CurContext, S, /*ConsiderLinkage*/ false, 
          /*ExplicitInstantiationOrSpecialization*/ false);
      if (!Previous.empty()) {
        Redeclaration.$set(true);
        
        OldDecl = Previous.<TypeAliasTemplateDecl>getAsSingle(TypeAliasTemplateDecl.class);
        if (!(OldDecl != null) && !Invalid) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(UsingLoc), diag.err_redefinition_different_kind)), 
                Name.Unnamed_field1.Identifier));
            
            NamedDecl /*P*/ OldD = Previous.getRepresentativeDecl();
            if (OldD.getLocation().isValid()) {
              $c$.clean($c$.track($this().Diag(OldD.getLocation(), diag.note_previous_definition)));
            }
            
            Invalid = true;
          } finally {
            $c$.$destroy();
          }
        }
        if (!Invalid && (OldDecl != null) && !OldDecl.isInvalidDecl()) {
          if ($this().TemplateParameterListsAreEqual(TemplateParams, 
              OldDecl.getTemplateParameters(), 
              /*Complain=*/ true, 
              TemplateParameterListEqualKind.TPL_TemplateMatch)) {
            OldTemplateParams = OldDecl.getTemplateParameters();
          } else {
            Invalid = true;
          }
          
          TypeAliasDecl /*P*/ OldTD = OldDecl.getTemplatedDecl();
          if (!Invalid
             && !$this().Context.hasSameType(OldTD.getUnderlyingType(), 
              NewTD.getUnderlyingType())) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // FIXME: The C++0x standard does not clearly say this is ill-formed,
              // but we can't reasonably accept it.
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewTD.getLocation(), diag.err_redefinition_different_typedef)), 
                          2), NewTD.getUnderlyingType()), OldTD.getUnderlyingType()));
              if (OldTD.getLocation().isValid()) {
                $c$.clean($c$.track($this().Diag(OldTD.getLocation(), diag.note_previous_definition)));
              }
              Invalid = true;
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
      
      // Merge any previous default template arguments into our parameters,
      // and check the parameter list.
      if ($this().CheckTemplateParameterList(TemplateParams, OldTemplateParams, 
          TemplateParamListContext.TPC_TypeAliasTemplate)) {
        return null;
      }
      
      TypeAliasTemplateDecl /*P*/ NewDecl = TypeAliasTemplateDecl.Create($this().Context, $this().CurContext, new SourceLocation(UsingLoc), 
          new DeclarationName(Name.Unnamed_field1.Identifier), TemplateParams, 
          NewTD);
      NewTD.setDescribedAliasTemplate(NewDecl);
      
      NewDecl.setAccess(AS);
      if (Invalid) {
        NewDecl.setInvalidDecl();
      } else if ((OldDecl != null)) {
        NewDecl.setPreviousDecl(OldDecl);
      }
      
      NewND = NewDecl;
    } else {
      {
        TagDecl /*P*/ TD = dyn_cast_or_null_TagDecl(DeclFromDeclSpec);
        if ((TD != null)) {
          $this().setTagNameForLinkagePurposes(TD, NewTD);
          $this().handleTagNumbering(TD, S);
        }
      }
      $this().ActOnTypedefNameDecl(S, $this().CurContext, NewTD, Previous, Redeclaration);
      NewND = NewTD;
    }
    
    $this().PushOnScopeChains(NewND, S);
    $this().ActOnDocumentableDecl(NewND);
    return NewND;
  } finally {
    if (Previous != null) { Previous.$destroy(); }
  }
}


/// BuildCXXConstructExpr - Creates a complete call to a constructor,
/// including handling of its default argument expressions.
///
/// \param ConstructKind - a CXXConstructExpr::ConstructionKind
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXConstructExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 11429,
 FQN="clang::Sema::BuildCXXConstructExpr", NM="_ZN5clang4Sema21BuildCXXConstructExprENS_14SourceLocationENS_8QualTypeEPNS_9NamedDeclEPNS_18CXXConstructorDeclEN4llvm15MutableArrayRefIPNS_4ExprEEEbbbbjNS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema21BuildCXXConstructExprENS_14SourceLocationENS_8QualTypeEPNS_9NamedDeclEPNS_18CXXConstructorDeclEN4llvm15MutableArrayRefIPNS_4ExprEEEbbbbjNS_11SourceRangeE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCXXConstructExpr(SourceLocation ConstructLoc, QualType DeclInitType, 
                     NamedDecl /*P*/ FoundDecl, 
                     CXXConstructorDecl /*P*/ Constructor, 
                     MutableArrayRef<Expr /*P*/ > ExprArgs, 
                     boolean HadMultipleCandidates, 
                     boolean IsListInitialization, 
                     boolean IsStdInitListInitialization, 
                     boolean RequiresZeroInit, 
                     /*uint*/int ConstructKind, 
                     SourceRange ParenRange) {
  boolean Elidable = false;
  
  // C++0x [class.copy]p34:
  //   When certain criteria are met, an implementation is allowed to
  //   omit the copy/move construction of a class object, even if the
  //   copy/move constructor and/or destructor for the object have
  //   side effects. [...]
  //     - when a temporary class object that has not been bound to a
  //       reference (12.2) would be copied/moved to a class object
  //       with the same cv-unqualified type, the copy/move operation
  //       can be omitted by constructing the temporary object
  //       directly into the target of the omitted copy/move
  if (ConstructKind == CXXConstructExpr.ConstructionKind.CK_Complete.getValue() && (Constructor != null)
     && Constructor.isCopyOrMoveConstructor() && hasOneRealArgument(new MutableArrayRef<Expr /*P*/ >(ExprArgs))) {
    Expr /*P*/ SubExpr = ExprArgs.$at(0);
    Elidable = SubExpr.isTemporaryObject($this().Context, cast_CXXRecordDecl(FoundDecl.getDeclContext()));
  }
  
  return $this().BuildCXXConstructExpr(new SourceLocation(ConstructLoc), new QualType(DeclInitType), 
      FoundDecl, Constructor, 
      Elidable, new MutableArrayRef<Expr /*P*/ >(ExprArgs), HadMultipleCandidates, 
      IsListInitialization, 
      IsStdInitListInitialization, RequiresZeroInit, 
      ConstructKind, new SourceRange(ParenRange));
}


/// Build a CXXConstructExpr whose constructor has already been resolved if
/// it denotes an inherited constructor.

/// BuildCXXConstructExpr - Creates a complete call to a constructor,
/// including handling of its default argument expressions.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXConstructExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 11493,
 FQN="clang::Sema::BuildCXXConstructExpr", NM="_ZN5clang4Sema21BuildCXXConstructExprENS_14SourceLocationENS_8QualTypeEPNS_18CXXConstructorDeclEbN4llvm15MutableArrayRefIPNS_4ExprEEEbbbbjNS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema21BuildCXXConstructExprENS_14SourceLocationENS_8QualTypeEPNS_18CXXConstructorDeclEbN4llvm15MutableArrayRefIPNS_4ExprEEEbbbbjNS_11SourceRangeE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCXXConstructExpr(SourceLocation ConstructLoc, QualType DeclInitType, 
                     CXXConstructorDecl /*P*/ Constructor, 
                     boolean Elidable, 
                     MutableArrayRef<Expr /*P*/ > ExprArgs, 
                     boolean HadMultipleCandidates, 
                     boolean IsListInitialization, 
                     boolean IsStdInitListInitialization, 
                     boolean RequiresZeroInit, 
                     /*uint*/int ConstructKind, 
                     SourceRange ParenRange) {
  assert (declaresSameEntity(Constructor.getParent(), DeclInitType.$arrow().getBaseElementTypeUnsafe().getAsCXXRecordDecl())) : "given constructor for wrong type";
  $this().MarkFunctionReferenced(new SourceLocation(ConstructLoc), Constructor);
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, CXXConstructExpr.Create($this().Context, new QualType(DeclInitType), new SourceLocation(ConstructLoc), Constructor, Elidable, 
          new ArrayRef<Expr /*P*/ >(ExprArgs), HadMultipleCandidates, IsListInitialization, 
          IsStdInitListInitialization, RequiresZeroInit, 
          /*static_cast*/CXXConstructExpr.ConstructionKind.valueOf(ConstructKind), 
          new SourceRange(ParenRange)));
}


// FIXME: Can we remove this and have the above BuildCXXConstructExpr check if
// the constructor can be elidable?
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXConstructExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 11467,
 FQN="clang::Sema::BuildCXXConstructExpr", NM="_ZN5clang4Sema21BuildCXXConstructExprENS_14SourceLocationENS_8QualTypeEPNS_9NamedDeclEPNS_18CXXConstructorDeclEbN4llvm15MutableArrayRefIPNS_4ExprEEEbbbbjNS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema21BuildCXXConstructExprENS_14SourceLocationENS_8QualTypeEPNS_9NamedDeclEPNS_18CXXConstructorDeclEbN4llvm15MutableArrayRefIPNS_4ExprEEEbbbbjNS_11SourceRangeE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCXXConstructExpr(SourceLocation ConstructLoc, QualType DeclInitType, 
                     NamedDecl /*P*/ FoundDecl, 
                     CXXConstructorDecl /*P*/ Constructor, 
                     boolean Elidable, 
                     MutableArrayRef<Expr /*P*/ > ExprArgs, 
                     boolean HadMultipleCandidates, 
                     boolean IsListInitialization, 
                     boolean IsStdInitListInitialization, 
                     boolean RequiresZeroInit, 
                     /*uint*/int ConstructKind, 
                     SourceRange ParenRange) {
  {
    ConstructorUsingShadowDecl /*P*/ Shadow = dyn_cast_ConstructorUsingShadowDecl(FoundDecl);
    if ((Shadow != null)) {
      Constructor = $this().findInheritingConstructor(new SourceLocation(ConstructLoc), Constructor, Shadow);
      if ($this().DiagnoseUseOfDecl(Constructor, new SourceLocation(ConstructLoc))) {
        return ExprError();
      }
    }
  }
  
  return $this().BuildCXXConstructExpr(new SourceLocation(ConstructLoc), new QualType(DeclInitType), Constructor, Elidable, new MutableArrayRef<Expr /*P*/ >(ExprArgs), 
      HadMultipleCandidates, IsListInitialization, IsStdInitListInitialization, 
      RequiresZeroInit, ConstructKind, new SourceRange(ParenRange));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXDefaultInitExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 11518,
 FQN="clang::Sema::BuildCXXDefaultInitExpr", NM="_ZN5clang4Sema23BuildCXXDefaultInitExprENS_14SourceLocationEPNS_9FieldDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema23BuildCXXDefaultInitExprENS_14SourceLocationEPNS_9FieldDeclE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCXXDefaultInitExpr(SourceLocation Loc, FieldDecl /*P*/ Field) {
  assert (Field.hasInClassInitializer());
  
  // If we already have the in-class initializer nothing needs to be done.
  if ((Field.getInClassInitializer() != null)) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, CXXDefaultInitExpr.Create($this().Context, new SourceLocation(Loc), Field));
  }
  
  // Maybe we haven't instantiated the in-class initializer. Go check the
  // pattern FieldDecl to see if it has one.
  CXXRecordDecl /*P*/ ParentRD = cast_CXXRecordDecl(Field.getParent());
  if (isTemplateInstantiation(ParentRD.getTemplateSpecializationKind())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      CXXRecordDecl /*P*/ ClassPattern = ParentRD.getTemplateInstantiationPattern();
      DeclContextLookupResult Lookup = ClassPattern.lookup(Field.getDeclName());
      
      // Lookup can return at most two results: the pattern for the field, or the
      // injected class name of the parent record. No other member can have the
      // same name as the field.
      assert (!Lookup.empty() && $lesseq_uint(Lookup.size(), 2)) : "more than two lookup results for field name";
      FieldDecl /*P*/ Pattern = dyn_cast_FieldDecl(Lookup.$at(0));
      if (!(Pattern != null)) {
        assert (isa_CXXRecordDecl(Lookup.$at(0))) : "cannot have other non-field member with same name";
        Pattern = cast_FieldDecl(Lookup.$at(1));
      }
      if ($c$.clean($this().InstantiateInClassInitializer(new SourceLocation(Loc), Field, Pattern, 
          $c$.track($this().getTemplateInstantiationArgs(Field))))) {
        return ExprError();
      }
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, CXXDefaultInitExpr.Create($this().Context, new SourceLocation(Loc), Field));
    } finally {
      $c$.$destroy();
    }
  }
  
  // DR1351:
  //   If the brace-or-equal-initializer of a non-static data member
  //   invokes a defaulted default constructor of its class or of an
  //   enclosing class in a potentially evaluated subexpression, the
  //   program is ill-formed.
  //
  // This resolution is unworkable: the exception specification of the
  // default constructor can be needed in an unevaluated context, in
  // particular, in the operand of a noexcept-expression, and we can be
  // unable to compute an exception specification for an enclosed class.
  //
  // Any attempt to resolve the exception specification of a defaulted default
  // constructor before the initializer is lexically complete will ultimately
  // come here at which point we can diagnose it.
  RecordDecl /*P*/ OutermostClass = ParentRD.getOuterLexicalRecordContext();
  if (OutermostClass == ParentRD) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Field.getLocEnd(), diag.err_in_class_initializer_not_yet_parsed)), 
              ParentRD), Field));
    } finally {
      $c$.$destroy();
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Field.getLocEnd(), 
                      diag.err_in_class_initializer_not_yet_parsed_outer_class)), 
                  ParentRD), OutermostClass), Field));
    } finally {
      $c$.$destroy();
    }
  }
  
  return ExprError();
}


/// FinalizeVarWithDestructor - Prepare for calling destructor on the
/// constructed variable.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FinalizeVarWithDestructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 11579,
 FQN="clang::Sema::FinalizeVarWithDestructor", NM="_ZN5clang4Sema25FinalizeVarWithDestructorEPNS_7VarDeclEPKNS_10RecordTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema25FinalizeVarWithDestructorEPNS_7VarDeclEPKNS_10RecordTypeE")
//</editor-fold>
public final void FinalizeVarWithDestructor(VarDecl /*P*/ VD, /*const*/ RecordType /*P*/ Record) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (VD.isInvalidDecl()) {
      return;
    }
    
    CXXRecordDecl /*P*/ ClassDecl = cast_CXXRecordDecl(Record.getDecl());
    if (ClassDecl.isInvalidDecl()) {
      return;
    }
    if (ClassDecl.hasIrrelevantDestructor()) {
      return;
    }
    if (ClassDecl.isDependentContext()) {
      return;
    }
    
    CXXDestructorDecl /*P*/ Destructor = $this().LookupDestructor(ClassDecl);
    $this().MarkFunctionReferenced(VD.getLocation(), Destructor);
    $c$.clean($this().CheckDestructorAccess(VD.getLocation(), Destructor, 
        $out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_DeclarationName($c$.track($this().PDiag(diag.err_access_dtor_var)), 
                VD.getDeclName()), 
            VD.getType())));
    $this().DiagnoseUseOfDecl(Destructor, VD.getLocation());
    if (Destructor.isTrivial()) {
      return;
    }
    if (!VD.hasGlobalStorage()) {
      return;
    }
    
    // Emit warning for non-trivial dtor in global scope (a real global,
    // class-static, function-static).
    $c$.clean($c$.track($this().Diag(VD.getLocation(), diag.warn_exit_time_destructor)));
    
    // TODO: this should be re-enabled for static locals by !CXAAtExit
    if (!VD.isStaticLocal()) {
      $c$.clean($c$.track($this().Diag(VD.getLocation(), diag.warn_global_destructor)));
    }
  } finally {
    $c$.$destroy();
  }
}


/// \brief Determine what sort of exception specification a defaulted
/// copy constructor of a class will have.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ComputeDefaultedDefaultCtorExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 8970,
 FQN="clang::Sema::ComputeDefaultedDefaultCtorExceptionSpec", NM="_ZN5clang4Sema40ComputeDefaultedDefaultCtorExceptionSpecENS_14SourceLocationEPNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema40ComputeDefaultedDefaultCtorExceptionSpecENS_14SourceLocationEPNS_13CXXMethodDeclE")
//</editor-fold>
public final Sema.ImplicitExceptionSpecification ComputeDefaultedDefaultCtorExceptionSpec(SourceLocation Loc, 
                                        CXXMethodDecl /*P*/ MD) {
  ImplicitExceptionSpecification ExceptSpec = null;
  try {
    CXXRecordDecl /*P*/ ClassDecl = MD.getParent();
    
    // C++ [except.spec]p14:
    //   An implicitly declared special member function (Clause 12) shall have an 
    //   exception-specification. [...]
    ExceptSpec/*J*/= new ImplicitExceptionSpecification(/*Deref*/$this());
    if (ClassDecl.isInvalidDecl()) {
      return new Sema.ImplicitExceptionSpecification(JD$Move.INSTANCE, ExceptSpec);
    }
    
    // Direct base-class constructors.
    for (final /*const*/ CXXBaseSpecifier /*&*/ B : ClassDecl.bases()) {
      if (B.isVirtual()) { // Handled below.
        continue;
      }
      {
        
        /*const*/ RecordType /*P*/ BaseType = B.getType().$arrow().getAs$RecordType();
        if ((BaseType != null)) {
          CXXRecordDecl /*P*/ BaseClassDecl = cast_CXXRecordDecl(BaseType.getDecl());
          CXXConstructorDecl /*P*/ Constructor = $this().LookupDefaultConstructor(BaseClassDecl);
          // If this is a deleted function, add it anyway. This might be conformant
          // with the standard. This might not. I'm not sure. It might not matter.
          if ((Constructor != null)) {
            ExceptSpec.CalledDecl(B.getLocStart(), Constructor);
          }
        }
      }
    }
    
    // Virtual base-class constructors.
    for (final /*const*/ CXXBaseSpecifier /*&*/ B : ClassDecl.vbases()) {
      {
        /*const*/ RecordType /*P*/ BaseType = B.getType().$arrow().getAs$RecordType();
        if ((BaseType != null)) {
          CXXRecordDecl /*P*/ BaseClassDecl = cast_CXXRecordDecl(BaseType.getDecl());
          CXXConstructorDecl /*P*/ Constructor = $this().LookupDefaultConstructor(BaseClassDecl);
          // If this is a deleted function, add it anyway. This might be conformant
          // with the standard. This might not. I'm not sure. It might not matter.
          if ((Constructor != null)) {
            ExceptSpec.CalledDecl(B.getLocStart(), Constructor);
          }
        }
      }
    }
    
    // Field constructors.
    for (/*const*/ FieldDecl /*P*/ F : ClassDecl.fields()) {
      if (F.hasInClassInitializer()) {
        {
          Expr /*P*/ E = F.getInClassInitializer();
          if ((E != null)) {
            ExceptSpec.CalledExpr(E);
          }
        }
      } else {
        /*const*/ RecordType /*P*/ RecordTy = $this().Context.getBaseElementType(F.getType()).$arrow().getAs$RecordType();
        if ((RecordTy != null)) {
          CXXRecordDecl /*P*/ FieldRecDecl = cast_CXXRecordDecl(RecordTy.getDecl());
          CXXConstructorDecl /*P*/ Constructor = $this().LookupDefaultConstructor(FieldRecDecl);
          // If this is a deleted function, add it anyway. This might be conformant
          // with the standard. This might not. I'm not sure. It might not matter.
          // In particular, the problem is that this function never gets called. It
          // might just be ill-formed because this function attempts to refer to
          // a deleted function here.
          if ((Constructor != null)) {
            ExceptSpec.CalledDecl(F.getLocation(), Constructor);
          }
        }
      }
    }
    
    return new Sema.ImplicitExceptionSpecification(JD$Move.INSTANCE, ExceptSpec);
  } finally {
    if (ExceptSpec != null) { ExceptSpec.$destroy(); }
  }
}


/// \brief Determine what sort of exception specification a defaulted
/// default constructor of a class will have, and whether the parameter
/// will be const.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ComputeDefaultedCopyCtorExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 10926,
 FQN="clang::Sema::ComputeDefaultedCopyCtorExceptionSpec", NM="_ZN5clang4Sema37ComputeDefaultedCopyCtorExceptionSpecEPNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema37ComputeDefaultedCopyCtorExceptionSpecEPNS_13CXXMethodDeclE")
//</editor-fold>
public final Sema.ImplicitExceptionSpecification ComputeDefaultedCopyCtorExceptionSpec(CXXMethodDecl /*P*/ MD) {
  ImplicitExceptionSpecification ExceptSpec = null;
  try {
    CXXRecordDecl /*P*/ ClassDecl = MD.getParent();
    
    ExceptSpec/*J*/= new ImplicitExceptionSpecification(/*Deref*/$this());
    if (ClassDecl.isInvalidDecl()) {
      return new Sema.ImplicitExceptionSpecification(JD$Move.INSTANCE, ExceptSpec);
    }
    
    /*const*/ FunctionProtoType /*P*/ T = MD.getType().$arrow().castAs(FunctionProtoType.class);
    assert ($greatereq_uint(T.getNumParams(), 1)) : "not a copy ctor";
    /*uint*/int Quals = T.getParamType(0).getNonReferenceType().getCVRQualifiers();
    
    // C++ [except.spec]p14:
    //   An implicitly declared special member function (Clause 12) shall have an 
    //   exception-specification. [...]
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : ClassDecl.bases()) {
      // Virtual bases are handled below.
      if (Base.isVirtual()) {
        continue;
      }
      
      CXXRecordDecl /*P*/ BaseClassDecl = cast_CXXRecordDecl(Base.getType().$arrow().getAs$RecordType().getDecl());
      {
        CXXConstructorDecl /*P*/ CopyConstructor = $this().LookupCopyingConstructor(BaseClassDecl, Quals);
        if ((CopyConstructor != null)) {
          ExceptSpec.CalledDecl(Base.getLocStart(), CopyConstructor);
        }
      }
    }
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : ClassDecl.vbases()) {
      CXXRecordDecl /*P*/ BaseClassDecl = cast_CXXRecordDecl(Base.getType().$arrow().getAs$RecordType().getDecl());
      {
        CXXConstructorDecl /*P*/ CopyConstructor = $this().LookupCopyingConstructor(BaseClassDecl, Quals);
        if ((CopyConstructor != null)) {
          ExceptSpec.CalledDecl(Base.getLocStart(), CopyConstructor);
        }
      }
    }
    for (/*const*/ FieldDecl /*P*/ Field : ClassDecl.fields()) {
      QualType FieldType = $this().Context.getBaseElementType(Field.getType());
      {
        CXXRecordDecl /*P*/ FieldClassDecl = FieldType.$arrow().getAsCXXRecordDecl();
        if ((FieldClassDecl != null)) {
          {
            CXXConstructorDecl /*P*/ CopyConstructor = $this().LookupCopyingConstructor(FieldClassDecl, 
                Quals | FieldType.getCVRQualifiers());
            if ((CopyConstructor != null)) {
              ExceptSpec.CalledDecl(Field.getLocation(), CopyConstructor);
            }
          }
        }
      }
    }
    
    return new Sema.ImplicitExceptionSpecification(JD$Move.INSTANCE, ExceptSpec);
  } finally {
    if (ExceptSpec != null) { ExceptSpec.$destroy(); }
  }
}


/// \brief Determine what sort of exception specification a defautled
/// copy assignment operator of a class will have, and whether the
/// parameter will be const.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ComputeDefaultedCopyAssignmentExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 10090,
 FQN="clang::Sema::ComputeDefaultedCopyAssignmentExceptionSpec", NM="_ZN5clang4Sema43ComputeDefaultedCopyAssignmentExceptionSpecEPNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema43ComputeDefaultedCopyAssignmentExceptionSpecEPNS_13CXXMethodDeclE")
//</editor-fold>
public final Sema.ImplicitExceptionSpecification ComputeDefaultedCopyAssignmentExceptionSpec(CXXMethodDecl /*P*/ MD) {
  ImplicitExceptionSpecification ExceptSpec = null;
  try {
    CXXRecordDecl /*P*/ ClassDecl = MD.getParent();
    
    ExceptSpec/*J*/= new ImplicitExceptionSpecification(/*Deref*/$this());
    if (ClassDecl.isInvalidDecl()) {
      return new Sema.ImplicitExceptionSpecification(JD$Move.INSTANCE, ExceptSpec);
    }
    
    /*const*/ FunctionProtoType /*P*/ T = MD.getType().$arrow().castAs(FunctionProtoType.class);
    assert (T.getNumParams() == 1) : "not a copy assignment op";
    /*uint*/int ArgQuals = T.getParamType(0).getNonReferenceType().getCVRQualifiers();
    
    // C++ [except.spec]p14:
    //   An implicitly declared special member function (Clause 12) shall have an
    //   exception-specification. [...]
    
    // It is unspecified whether or not an implicit copy assignment operator
    // attempts to deduplicate calls to assignment operators of virtual bases are
    // made. As such, this exception specification is effectively unspecified.
    // Based on a similar decision made for constness in C++0x, we're erring on
    // the side of assuming such calls to be made regardless of whether they
    // actually happen.
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : ClassDecl.bases()) {
      if (Base.isVirtual()) {
        continue;
      }
      
      CXXRecordDecl /*P*/ BaseClassDecl = cast_CXXRecordDecl(Base.getType().$arrow().getAs$RecordType().getDecl());
      {
        CXXMethodDecl /*P*/ CopyAssign = $this().LookupCopyingAssignment(BaseClassDecl, 
            ArgQuals, false, 0);
        if ((CopyAssign != null)) {
          ExceptSpec.CalledDecl(Base.getLocStart(), CopyAssign);
        }
      }
    }
    
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : ClassDecl.vbases()) {
      CXXRecordDecl /*P*/ BaseClassDecl = cast_CXXRecordDecl(Base.getType().$arrow().getAs$RecordType().getDecl());
      {
        CXXMethodDecl /*P*/ CopyAssign = $this().LookupCopyingAssignment(BaseClassDecl, 
            ArgQuals, false, 0);
        if ((CopyAssign != null)) {
          ExceptSpec.CalledDecl(Base.getLocStart(), CopyAssign);
        }
      }
    }
    
    for (/*const*/ FieldDecl /*P*/ Field : ClassDecl.fields()) {
      QualType FieldType = $this().Context.getBaseElementType(Field.getType());
      {
        CXXRecordDecl /*P*/ FieldClassDecl = FieldType.$arrow().getAsCXXRecordDecl();
        if ((FieldClassDecl != null)) {
          {
            CXXMethodDecl /*P*/ CopyAssign = $this().LookupCopyingAssignment(FieldClassDecl, 
                ArgQuals | FieldType.getCVRQualifiers(), 
                false, 0);
            if ((CopyAssign != null)) {
              ExceptSpec.CalledDecl(Field.getLocation(), CopyAssign);
            }
          }
        }
      }
    }
    
    return new Sema.ImplicitExceptionSpecification(JD$Move.INSTANCE, ExceptSpec);
  } finally {
    if (ExceptSpec != null) { ExceptSpec.$destroy(); }
  }
}


/// \brief Determine what sort of exception specification a defaulted move
/// constructor of a class will have.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ComputeDefaultedMoveCtorExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 11099,
 FQN="clang::Sema::ComputeDefaultedMoveCtorExceptionSpec", NM="_ZN5clang4Sema37ComputeDefaultedMoveCtorExceptionSpecEPNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema37ComputeDefaultedMoveCtorExceptionSpecEPNS_13CXXMethodDeclE")
//</editor-fold>
public final Sema.ImplicitExceptionSpecification ComputeDefaultedMoveCtorExceptionSpec(CXXMethodDecl /*P*/ MD) {
  ImplicitExceptionSpecification ExceptSpec = null;
  try {
    CXXRecordDecl /*P*/ ClassDecl = MD.getParent();
    
    // C++ [except.spec]p14:
    //   An implicitly declared special member function (Clause 12) shall have an 
    //   exception-specification. [...]
    ExceptSpec/*J*/= new ImplicitExceptionSpecification(/*Deref*/$this());
    if (ClassDecl.isInvalidDecl()) {
      return new Sema.ImplicitExceptionSpecification(JD$Move.INSTANCE, ExceptSpec);
    }
    
    // Direct base-class constructors.
    for (final /*const*/ CXXBaseSpecifier /*&*/ B : ClassDecl.bases()) {
      if (B.isVirtual()) { // Handled below.
        continue;
      }
      {
        
        /*const*/ RecordType /*P*/ BaseType = B.getType().$arrow().getAs$RecordType();
        if ((BaseType != null)) {
          CXXRecordDecl /*P*/ BaseClassDecl = cast_CXXRecordDecl(BaseType.getDecl());
          CXXConstructorDecl /*P*/ Constructor = $this().LookupMovingConstructor(BaseClassDecl, 0);
          // If this is a deleted function, add it anyway. This might be conformant
          // with the standard. This might not. I'm not sure. It might not matter.
          if ((Constructor != null)) {
            ExceptSpec.CalledDecl(B.getLocStart(), Constructor);
          }
        }
      }
    }
    
    // Virtual base-class constructors.
    for (final /*const*/ CXXBaseSpecifier /*&*/ B : ClassDecl.vbases()) {
      {
        /*const*/ RecordType /*P*/ BaseType = B.getType().$arrow().getAs$RecordType();
        if ((BaseType != null)) {
          CXXRecordDecl /*P*/ BaseClassDecl = cast_CXXRecordDecl(BaseType.getDecl());
          CXXConstructorDecl /*P*/ Constructor = $this().LookupMovingConstructor(BaseClassDecl, 0);
          // If this is a deleted function, add it anyway. This might be conformant
          // with the standard. This might not. I'm not sure. It might not matter.
          if ((Constructor != null)) {
            ExceptSpec.CalledDecl(B.getLocStart(), Constructor);
          }
        }
      }
    }
    
    // Field constructors.
    for (/*const*/ FieldDecl /*P*/ F : ClassDecl.fields()) {
      QualType FieldType = $this().Context.getBaseElementType(F.getType());
      {
        CXXRecordDecl /*P*/ FieldRecDecl = FieldType.$arrow().getAsCXXRecordDecl();
        if ((FieldRecDecl != null)) {
          CXXConstructorDecl /*P*/ Constructor = $this().LookupMovingConstructor(FieldRecDecl, FieldType.getCVRQualifiers());
          // If this is a deleted function, add it anyway. This might be conformant
          // with the standard. This might not. I'm not sure. It might not matter.
          // In particular, the problem is that this function never gets called. It
          // might just be ill-formed because this function attempts to refer to
          // a deleted function here.
          if ((Constructor != null)) {
            ExceptSpec.CalledDecl(F.getLocation(), Constructor);
          }
        }
      }
    }
    
    return new Sema.ImplicitExceptionSpecification(JD$Move.INSTANCE, ExceptSpec);
  } finally {
    if (ExceptSpec != null) { ExceptSpec.$destroy(); }
  }
}


/// \brief Determine what sort of exception specification a defaulted move
/// assignment operator of a class will have.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ComputeDefaultedMoveAssignmentExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 10489,
 FQN="clang::Sema::ComputeDefaultedMoveAssignmentExceptionSpec", NM="_ZN5clang4Sema43ComputeDefaultedMoveAssignmentExceptionSpecEPNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema43ComputeDefaultedMoveAssignmentExceptionSpecEPNS_13CXXMethodDeclE")
//</editor-fold>
public final Sema.ImplicitExceptionSpecification ComputeDefaultedMoveAssignmentExceptionSpec(CXXMethodDecl /*P*/ MD) {
  ImplicitExceptionSpecification ExceptSpec = null;
  try {
    CXXRecordDecl /*P*/ ClassDecl = MD.getParent();
    
    ExceptSpec/*J*/= new ImplicitExceptionSpecification(/*Deref*/$this());
    if (ClassDecl.isInvalidDecl()) {
      return new Sema.ImplicitExceptionSpecification(JD$Move.INSTANCE, ExceptSpec);
    }
    
    // C++0x [except.spec]p14:
    //   An implicitly declared special member function (Clause 12) shall have an 
    //   exception-specification. [...]
    
    // It is unspecified whether or not an implicit move assignment operator
    // attempts to deduplicate calls to assignment operators of virtual bases are
    // made. As such, this exception specification is effectively unspecified.
    // Based on a similar decision made for constness in C++0x, we're erring on
    // the side of assuming such calls to be made regardless of whether they
    // actually happen.
    // Note that a move constructor is not implicitly declared when there are
    // virtual bases, but it can still be user-declared and explicitly defaulted.
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : ClassDecl.bases()) {
      if (Base.isVirtual()) {
        continue;
      }
      
      CXXRecordDecl /*P*/ BaseClassDecl = cast_CXXRecordDecl(Base.getType().$arrow().getAs$RecordType().getDecl());
      {
        CXXMethodDecl /*P*/ MoveAssign = $this().LookupMovingAssignment(BaseClassDecl, 
            0, false, 0);
        if ((MoveAssign != null)) {
          ExceptSpec.CalledDecl(Base.getLocStart(), MoveAssign);
        }
      }
    }
    
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : ClassDecl.vbases()) {
      CXXRecordDecl /*P*/ BaseClassDecl = cast_CXXRecordDecl(Base.getType().$arrow().getAs$RecordType().getDecl());
      {
        CXXMethodDecl /*P*/ MoveAssign = $this().LookupMovingAssignment(BaseClassDecl, 
            0, false, 0);
        if ((MoveAssign != null)) {
          ExceptSpec.CalledDecl(Base.getLocStart(), MoveAssign);
        }
      }
    }
    
    for (/*const*/ FieldDecl /*P*/ Field : ClassDecl.fields()) {
      QualType FieldType = $this().Context.getBaseElementType(Field.getType());
      {
        CXXRecordDecl /*P*/ FieldClassDecl = FieldType.$arrow().getAsCXXRecordDecl();
        if ((FieldClassDecl != null)) {
          {
            CXXMethodDecl /*P*/ MoveAssign = $this().LookupMovingAssignment(FieldClassDecl, 
                FieldType.getCVRQualifiers(), 
                false, 0);
            if ((MoveAssign != null)) {
              ExceptSpec.CalledDecl(Field.getLocation(), MoveAssign);
            }
          }
        }
      }
    }
    
    return new Sema.ImplicitExceptionSpecification(JD$Move.INSTANCE, ExceptSpec);
  } finally {
    if (ExceptSpec != null) { ExceptSpec.$destroy(); }
  }
}


/// \brief Determine what sort of exception specification a defaulted
/// destructor of a class will have.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ComputeDefaultedDtorExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9411,
 FQN="clang::Sema::ComputeDefaultedDtorExceptionSpec", NM="_ZN5clang4Sema33ComputeDefaultedDtorExceptionSpecEPNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema33ComputeDefaultedDtorExceptionSpecEPNS_13CXXMethodDeclE")
//</editor-fold>
public final Sema.ImplicitExceptionSpecification ComputeDefaultedDtorExceptionSpec(CXXMethodDecl /*P*/ MD) {
  ImplicitExceptionSpecification ExceptSpec = null;
  try {
    CXXRecordDecl /*P*/ ClassDecl = MD.getParent();
    
    // C++ [except.spec]p14: 
    //   An implicitly declared special member function (Clause 12) shall have 
    //   an exception-specification.
    ExceptSpec/*J*/= new ImplicitExceptionSpecification(/*Deref*/$this());
    if (ClassDecl.isInvalidDecl()) {
      return new Sema.ImplicitExceptionSpecification(JD$Move.INSTANCE, ExceptSpec);
    }
    
    // Direct base-class destructors.
    for (final /*const*/ CXXBaseSpecifier /*&*/ B : ClassDecl.bases()) {
      if (B.isVirtual()) { // Handled below.
        continue;
      }
      {
        
        /*const*/ RecordType /*P*/ BaseType = B.getType().$arrow().getAs$RecordType();
        if ((BaseType != null)) {
          ExceptSpec.CalledDecl(B.getLocStart(), 
              $this().LookupDestructor(cast_CXXRecordDecl(BaseType.getDecl())));
        }
      }
    }
    
    // Virtual base-class destructors.
    for (final /*const*/ CXXBaseSpecifier /*&*/ B : ClassDecl.vbases()) {
      {
        /*const*/ RecordType /*P*/ BaseType = B.getType().$arrow().getAs$RecordType();
        if ((BaseType != null)) {
          ExceptSpec.CalledDecl(B.getLocStart(), 
              $this().LookupDestructor(cast_CXXRecordDecl(BaseType.getDecl())));
        }
      }
    }
    
    // Field destructors.
    for (/*const*/ FieldDecl /*P*/ F : ClassDecl.fields()) {
      {
        /*const*/ RecordType /*P*/ RecordTy = $this().Context.getBaseElementType(F.getType()).$arrow().getAs$RecordType();
        if ((RecordTy != null)) {
          ExceptSpec.CalledDecl(F.getLocation(), 
              $this().LookupDestructor(cast_CXXRecordDecl(RecordTy.getDecl())));
        }
      }
    }
    
    return new Sema.ImplicitExceptionSpecification(JD$Move.INSTANCE, ExceptSpec);
  } finally {
    if (ExceptSpec != null) { ExceptSpec.$destroy(); }
  }
}


/// \brief Determine what sort of exception specification an inheriting
/// constructor of a class will have.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ComputeInheritingCtorExceptionSpec">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9031,
 FQN="clang::Sema::ComputeInheritingCtorExceptionSpec", NM="_ZN5clang4Sema34ComputeInheritingCtorExceptionSpecENS_14SourceLocationEPNS_18CXXConstructorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema34ComputeInheritingCtorExceptionSpecENS_14SourceLocationEPNS_18CXXConstructorDeclE")
//</editor-fold>
public final Sema.ImplicitExceptionSpecification ComputeInheritingCtorExceptionSpec(SourceLocation Loc, 
                                  CXXConstructorDecl /*P*/ CD) {
  ImplicitExceptionSpecification ExceptSpec = null;
  InheritedConstructorInfo ICI = null;
  try {
    CXXRecordDecl /*P*/ ClassDecl = CD.getParent();
    
    // C++ [except.spec]p14:
    //   An inheriting constructor [...] shall have an exception-specification. [...]
    ExceptSpec/*J*/= new ImplicitExceptionSpecification(/*Deref*/$this());
    if (ClassDecl.isInvalidDecl()) {
      return new Sema.ImplicitExceptionSpecification(JD$Move.INSTANCE, ExceptSpec);
    }
    
    InheritedConstructor Inherited = CD.getInheritedConstructor();
    ICI/*J*/= new InheritedConstructorInfo(/*Deref*/$this(), new SourceLocation(Loc), Inherited.getShadowDecl());
    
    // Direct and virtual base-class constructors.
    for (boolean VBase : new boolean[]{false, true}) {
      for (final CXXBaseSpecifier /*&*/ B : VBase ? ClassDecl.vbases() : ClassDecl.bases()) {
        // Don't visit direct vbases twice.
        if (B.isVirtual() != VBase) {
          continue;
        }
        
        CXXRecordDecl /*P*/ BaseClass = B.getType().$arrow().getAsCXXRecordDecl();
        if (!(BaseClass != null)) {
          continue;
        }
        
        CXXConstructorDecl /*P*/ Constructor = ICI.findConstructorForBase(BaseClass, Inherited.getConstructor()).
            first;
        if (!(Constructor != null)) {
          Constructor = $this().LookupDefaultConstructor(BaseClass);
        }
        if ((Constructor != null)) {
          ExceptSpec.CalledDecl(B.getLocStart(), Constructor);
        }
      }
    }
    
    // Field constructors.
    for (/*const*/ FieldDecl /*P*/ F : ClassDecl.fields()) {
      if (F.hasInClassInitializer()) {
        {
          Expr /*P*/ E = F.getInClassInitializer();
          if ((E != null)) {
            ExceptSpec.CalledExpr(E);
          }
        }
      } else {
        /*const*/ RecordType /*P*/ RecordTy = $this().Context.getBaseElementType(F.getType()).$arrow().getAs$RecordType();
        if ((RecordTy != null)) {
          CXXRecordDecl /*P*/ FieldRecDecl = cast_CXXRecordDecl(RecordTy.getDecl());
          CXXConstructorDecl /*P*/ Constructor = $this().LookupDefaultConstructor(FieldRecDecl);
          if ((Constructor != null)) {
            ExceptSpec.CalledDecl(F.getLocation(), Constructor);
          }
        }
      }
    }
    
    return new Sema.ImplicitExceptionSpecification(JD$Move.INSTANCE, ExceptSpec);
  } finally {
    if (ICI != null) { ICI.$destroy(); }
    if (ExceptSpec != null) { ExceptSpec.$destroy(); }
  }
}


/// \brief Evaluate the implicit exception specification for a defaulted
/// special member function.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::EvaluateImplicitExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5330,
 FQN="clang::Sema::EvaluateImplicitExceptionSpec", NM="_ZN5clang4Sema29EvaluateImplicitExceptionSpecENS_14SourceLocationEPNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema29EvaluateImplicitExceptionSpecENS_14SourceLocationEPNS_13CXXMethodDeclE")
//</editor-fold>
public final void EvaluateImplicitExceptionSpec(SourceLocation Loc, CXXMethodDecl /*P*/ MD) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    /*const*/ FunctionProtoType /*P*/ FPT = MD.getType().$arrow().castAs(FunctionProtoType.class);
    if (FPT.getExceptionSpecType() != ExceptionSpecificationType.EST_Unevaluated) {
      return;
    }
    
    // Evaluate the exception specification.
    ExceptionSpecInfo ESI = $c$.clean($c$.track(computeImplicitExceptionSpec(/*Deref*/$this(), new SourceLocation(Loc), MD)).getExceptionSpec());
    
    // Update the type of the special member to use it.
    $this().UpdateExceptionSpec(MD, ESI);
    
    // A user-provided destructor can be defined outside the class. When that
    // happens, be sure to update the exception specification on both
    // declarations.
    /*const*/ FunctionProtoType /*P*/ CanonicalFPT = MD.getCanonicalDecl().getType().$arrow().castAs(FunctionProtoType.class);
    if (CanonicalFPT.getExceptionSpecType() == ExceptionSpecificationType.EST_Unevaluated) {
      $this().UpdateExceptionSpec(MD.getCanonicalDecl(), ESI);
    }
  } finally {
    $c$.$destroy();
  }
}


/// \brief Check the given exception-specification and update the
/// exception specification information with the results.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkExceptionSpecification">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13849,
 FQN="clang::Sema::checkExceptionSpecification", NM="_ZN5clang4Sema27checkExceptionSpecificationEbNS_26ExceptionSpecificationTypeEN4llvm8ArrayRefINS_9OpaquePtrINS_8QualTypeEEEEENS3_INS_11SourceRangeEEEPNS_4ExprERNS2_15SmallVectorImplIS5_EERNS_17FunctionProtoType17ExceptionSpecInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema27checkExceptionSpecificationEbNS_26ExceptionSpecificationTypeEN4llvm8ArrayRefINS_9OpaquePtrINS_8QualTypeEEEEENS3_INS_11SourceRangeEEEPNS_4ExprERNS2_15SmallVectorImplIS5_EERNS_17FunctionProtoType17ExceptionSpecInfoE")
//</editor-fold>
public final void checkExceptionSpecification(boolean IsTopLevel, ExceptionSpecificationType EST, 
                           ArrayRef<OpaquePtr<QualType>> DynamicExceptions, 
                           ArrayRef<SourceRange> DynamicExceptionRanges, Expr /*P*/ NoexceptExpr, 
                           final SmallVectorImpl<QualType> /*&*/ Exceptions, 
                           final FunctionProtoType.ExceptionSpecInfo /*&*/ ESI) {
  Exceptions.clear();
  ESI.Type = EST;
  if (EST == ExceptionSpecificationType.EST_Dynamic) {
    Exceptions.reserve(DynamicExceptions.size());
    for (/*uint*/int ei = 0, ee = DynamicExceptions.size(); ei != ee; ++ei) {
      // FIXME: Preserve type source info.
      QualType ET = GetTypeFromParser(new OpaquePtr<QualType>(DynamicExceptions.$at(ei)));
      if (IsTopLevel) {
        SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(2, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
        $this().collectUnexpandedParameterPacks_QualType(new QualType(ET), Unexpanded);
        if (!Unexpanded.empty()) {
          $this().DiagnoseUnexpandedParameterPacks(DynamicExceptionRanges.$at(ei).getBegin(), UnexpandedParameterPackContext.UPPC_ExceptionType, 
              new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false));
          continue;
        }
      }
      
      // Check that the type is valid for an exception spec, and
      // drop it if not.
      if (!$this().CheckSpecifiedExceptionType(ET, new SourceRange(DynamicExceptionRanges.$at(ei)))) {
        Exceptions.push_back(ET);
      }
    }
    ESI.Exceptions.$assignMove(new ArrayRef<QualType>(Exceptions, false));
    return;
  }
  if (EST == ExceptionSpecificationType.EST_ComputedNoexcept) {
    // If an error occurred, there's no expression here.
    if ((NoexceptExpr != null)) {
      assert ((NoexceptExpr.isTypeDependent() || $eq_CanQual$T_CanQual$U(NoexceptExpr.getType().$arrow().getCanonicalTypeUnqualified(), /*NO_COPY*/$this().Context.BoolTy))) : "Parser should have made sure that the expression is boolean";
      if (IsTopLevel && (NoexceptExpr != null)
         && $this().DiagnoseUnexpandedParameterPack(NoexceptExpr)) {
        ESI.Type = ExceptionSpecificationType.EST_BasicNoexcept;
        return;
      }
      if (!NoexceptExpr.isValueDependent()) {
        NoexceptExpr = $this().VerifyIntegerConstantExpression(NoexceptExpr, (APSInt /*P*/ )null, 
            diag.err_noexcept_needs_constant_expression, 
            /*AllowFold*/ false).get();
      }
      ESI.NoexceptExpr = NoexceptExpr;
    }
    return;
  }
}


/// \brief Add an exception-specification to the given member function
/// (or member function template). The exception-specification was parsed
/// after the method itself was declared.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::actOnDelayedExceptionSpecification">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13906,
 FQN="clang::Sema::actOnDelayedExceptionSpecification", NM="_ZN5clang4Sema34actOnDelayedExceptionSpecificationEPNS_4DeclENS_26ExceptionSpecificationTypeENS_11SourceRangeEN4llvm8ArrayRefINS_9OpaquePtrINS_8QualTypeEEEEENS6_IS4_EEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema34actOnDelayedExceptionSpecificationEPNS_4DeclENS_26ExceptionSpecificationTypeENS_11SourceRangeEN4llvm8ArrayRefINS_9OpaquePtrINS_8QualTypeEEEEENS6_IS4_EEPNS_4ExprE")
//</editor-fold>
public final void actOnDelayedExceptionSpecification(Decl /*P*/ MethodD, 
                                  ExceptionSpecificationType EST, 
                                  SourceRange SpecificationRange, 
                                  ArrayRef<OpaquePtr<QualType>> DynamicExceptions, 
                                  ArrayRef<SourceRange> DynamicExceptionRanges, 
                                  Expr /*P*/ NoexceptExpr) {
  if (!(MethodD != null)) {
    return;
  }
  {
    
    // Dig out the method we're referring to.
    FunctionTemplateDecl /*P*/ FunTmpl = dyn_cast_FunctionTemplateDecl(MethodD);
    if ((FunTmpl != null)) {
      MethodD = FunTmpl.getTemplatedDecl();
    }
  }
  
  CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(MethodD);
  if (!(Method != null)) {
    return;
  }
  
  // Check the exception specification.
  SmallVector<QualType> Exceptions/*J*/= new SmallVector<QualType>(4, new QualType());
  FunctionProtoType.ExceptionSpecInfo ESI/*J*/= new FunctionProtoType.ExceptionSpecInfo();
  $this().checkExceptionSpecification(/*IsTopLevel*/ true, EST, new ArrayRef<OpaquePtr<QualType>>(DynamicExceptions), 
      new ArrayRef<SourceRange>(DynamicExceptionRanges), NoexceptExpr, Exceptions, 
      ESI);
  
  // Update the exception specification on the function type.
  $this().Context.adjustExceptionSpec(Method, ESI, /*AsWritten*/ true);
  if (Method.isStatic()) {
    $this().checkThisInStaticMemberFunctionExceptionSpec(Method);
  }
  if (Method.isVirtual()) {
    // Check overrides, which we previously had to delay.
    for (type$ptr<CXXMethodDecl>/*method_iterator*/ O = $tryClone(Method.begin_overridden_methods()), 
        /*P*/ /*const*/ /*P*/ OEnd = $tryClone(Method.end_overridden_methods());
         $noteq_ptr(O, OEnd); O.$preInc())  {
      $this().CheckOverridingFunctionExceptionSpec(Method, O.$star());
    }
  }
}


/// \brief Determine if a special member function should have a deleted
/// definition when it is defaulted.

/// Determine whether a defaulted special member function should be defined as
/// deleted, as specified in C++11 [class.ctor]p5, C++11 [class.copy]p11,
/// C++11 [class.copy]p23, and C++11 [class.dtor]p5.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ShouldDeleteSpecialMember">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5906,
 FQN="clang::Sema::ShouldDeleteSpecialMember", NM="_ZN5clang4Sema25ShouldDeleteSpecialMemberEPNS_13CXXMethodDeclENS0_16CXXSpecialMemberEPNS0_24InheritedConstructorInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema25ShouldDeleteSpecialMemberEPNS_13CXXMethodDeclENS0_16CXXSpecialMemberEPNS0_24InheritedConstructorInfoEb")
//</editor-fold>
public final boolean ShouldDeleteSpecialMember(CXXMethodDecl /*P*/ MD, CXXSpecialMember CSM) {
  return ShouldDeleteSpecialMember(MD, CSM, 
                         (InheritedConstructorInfo /*P*/ )null, 
                         false);
}
public final boolean ShouldDeleteSpecialMember(CXXMethodDecl /*P*/ MD, CXXSpecialMember CSM, 
                         InheritedConstructorInfo /*P*/ ICI/*= null*/) {
  return ShouldDeleteSpecialMember(MD, CSM, 
                         ICI, 
                         false);
}
public final boolean ShouldDeleteSpecialMember(CXXMethodDecl /*P*/ MD, CXXSpecialMember CSM, 
                         InheritedConstructorInfo /*P*/ ICI/*= null*/, 
                         boolean Diagnose/*= false*/) {
  ContextRAII MethodContext = null;
  try {
    if (MD.isInvalidDecl()) {
      return false;
    }
    CXXRecordDecl /*P*/ RD = MD.getParent();
    assert (!RD.isDependentType()) : "do deletion after instantiation";
    if (!$this().LangOpts.CPlusPlus11 || RD.isInvalidDecl()) {
      return false;
    }
    
    // C++11 [expr.lambda.prim]p19:
    //   The closure type associated with a lambda-expression has a
    //   deleted (8.4.3) default constructor and a deleted copy
    //   assignment operator.
    if (RD.isLambda()
       && (CSM == CXXSpecialMember.CXXDefaultConstructor || CSM == CXXSpecialMember.CXXCopyAssignment)) {
      if (Diagnose) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(RD.getLocation(), diag.note_lambda_decl)));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
    
    // For an anonymous struct or union, the copy and assignment special members
    // will never be used, so skip the check. For an anonymous union declared at
    // namespace scope, the constructor and destructor are used.
    if (CSM != CXXSpecialMember.CXXDefaultConstructor && CSM != CXXSpecialMember.CXXDestructor
       && RD.isAnonymousStructOrUnion()) {
      return false;
    }
    
    // C++11 [class.copy]p7, p18:
    //   If the class definition declares a move constructor or move assignment
    //   operator, an implicitly declared copy constructor or copy assignment
    //   operator is defined as deleted.
    if (MD.isImplicit()
       && (CSM == CXXSpecialMember.CXXCopyConstructor || CSM == CXXSpecialMember.CXXCopyAssignment)) {
      CXXMethodDecl /*P*/ UserDeclaredMove = null;
      
      // In Microsoft mode, a user-declared move only causes the deletion of the
      // corresponding copy operation, not both copy operations.
      if (RD.hasUserDeclaredMoveConstructor()
         && (!$this().getLangOpts().MSVCCompat || CSM == CXXSpecialMember.CXXCopyConstructor)) {
        if (!Diagnose) {
          return true;
        }
        
        // Find any user-declared move constructor.
        for (CXXConstructorDecl /*P*/ I : RD.ctors()) {
          if (I.isMoveConstructor()) {
            UserDeclaredMove = I;
            break;
          }
        }
        assert Native.$bool(UserDeclaredMove);
      } else if (RD.hasUserDeclaredMoveAssignment()
         && (!$this().getLangOpts().MSVCCompat || CSM == CXXSpecialMember.CXXCopyAssignment)) {
        if (!Diagnose) {
          return true;
        }
        
        // Find any user-declared move assignment operator.
        for (CXXMethodDecl /*P*/ I : RD.methods()) {
          if (I.isMoveAssignmentOperator()) {
            UserDeclaredMove = I;
            break;
          }
        }
        assert Native.$bool(UserDeclaredMove);
      }
      if ((UserDeclaredMove != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(UserDeclaredMove.getLocation(), 
                          diag.note_deleted_copy_user_declared_move)), 
                      (CSM == CXXSpecialMember.CXXCopyAssignment)), RD), 
              UserDeclaredMove.isMoveAssignmentOperator()));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Do access control from the special member function
    MethodContext/*J*/= new ContextRAII(/*Deref*/$this(), MD);
    
    // C++11 [class.dtor]p5:
    // -- for a virtual destructor, lookup of the non-array deallocation function
    //    results in an ambiguity or in a function that is deleted or inaccessible
    if (CSM == CXXSpecialMember.CXXDestructor && MD.isVirtual()) {
      type$ref<FunctionDecl /*P*/ > OperatorDelete = create_type$null$ref(null);
      DeclarationName Name = $this().Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_Delete);
      if ($this().FindDeallocationFunction(MD.getLocation(), MD.getParent(), new DeclarationName(Name), 
          OperatorDelete, false)) {
        if (Diagnose) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(RD.getLocation(), diag.note_deleted_dtor_no_operator_delete)));
          } finally {
            $c$.$destroy();
          }
        }
        return true;
      }
    }
    
    SpecialMemberDeletionInfo SMI/*J*/= new SpecialMemberDeletionInfo(/*Deref*/$this(), MD, CSM, ICI, Diagnose);
    
    for (final CXXBaseSpecifier /*&*/ BI : RD.bases())  {
      if (!BI.isVirtual()
         && SMI.shouldDeleteForBase($AddrOf(BI))) {
        return true;
      }
    }
    
    // Per DR1611, do not consider virtual bases of constructors of abstract
    // classes, since we are not going to construct them.
    if (!RD.isAbstract() || !SMI.IsConstructor) {
      for (final CXXBaseSpecifier /*&*/ BI : RD.vbases())  {
        if (SMI.shouldDeleteForBase($AddrOf(BI))) {
          return true;
        }
      }
    }
    
    for (FieldDecl /*P*/ FI : RD.fields())  {
      if (!FI.isInvalidDecl() && !FI.isUnnamedBitfield()
         && SMI.shouldDeleteForField(FI)) {
        return true;
      }
    }
    if (SMI.shouldDeleteForAllConstMembers()) {
      return true;
    }
    if ($this().getLangOpts().CUDA) {
      // We should delete the special member in CUDA mode if target inference
      // failed.
      return $this().inferCUDATargetForImplicitSpecialMember(RD, CSM, MD, SMI.ConstArg, 
          Diagnose);
    }
    
    return false;
  } finally {
    if (MethodContext != null) { MethodContext.$destroy(); }
  }
}


/// \brief Declare the implicit default constructor for the given class.
///
/// \param ClassDecl The class declaration into which the implicit
/// default constructor will be added.
///
/// \returns The implicitly-declared default constructor.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DeclareImplicitDefaultConstructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9130,
 FQN="clang::Sema::DeclareImplicitDefaultConstructor", NM="_ZN5clang4Sema33DeclareImplicitDefaultConstructorEPNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema33DeclareImplicitDefaultConstructorEPNS_13CXXRecordDeclE")
//</editor-fold>
public final CXXConstructorDecl /*P*/ DeclareImplicitDefaultConstructor(CXXRecordDecl /*P*/ ClassDecl) {
  DeclaringSpecialMember DSM = null;
  try {
    // C++ [class.ctor]p5:
    //   A default constructor for a class X is a constructor of class X
    //   that can be called without an argument. If there is no
    //   user-declared constructor for class X, a default constructor is
    //   implicitly declared. An implicitly-declared default constructor
    //   is an inline public member of its class.
    assert (ClassDecl.needsImplicitDefaultConstructor()) : "Should not build implicit default constructor!";
    
    DSM/*J*/= new DeclaringSpecialMember(/*Deref*/$this(), ClassDecl, CXXSpecialMember.CXXDefaultConstructor);
    if (DSM.isAlreadyBeingDeclared()) {
      return null;
    }
    
    boolean Constexpr = defaultedSpecialMemberIsConstexpr(/*Deref*/$this(), ClassDecl, 
        CXXSpecialMember.CXXDefaultConstructor, 
        false);
    
    // Create the actual constructor declaration.
    CanQual<Type> ClassType = $this().Context.getCanonicalType($this().Context.getTypeDeclType(ClassDecl));
    SourceLocation ClassLoc = ClassDecl.getLocation();
    DeclarationName Name = $this().Context.DeclarationNames.getCXXConstructorName(new CanQual<Type>(ClassType));
    DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo(new DeclarationName(Name), new SourceLocation(ClassLoc));
    CXXConstructorDecl /*P*/ DefaultCon = CXXConstructorDecl.Create($this().Context, ClassDecl, new SourceLocation(ClassLoc), NameInfo, /*Type*/ new QualType(), 
        /*TInfo=*/ (TypeSourceInfo /*P*/ )null, /*isExplicit=*/ false, /*isInline=*/ true, 
        /*isImplicitlyDeclared=*/ true, Constexpr);
    DefaultCon.setAccess(AccessSpecifier.AS_public);
    DefaultCon.setDefaulted();
    if ($this().getLangOpts().CUDA) {
      $this().inferCUDATargetForImplicitSpecialMember(ClassDecl, CXXSpecialMember.CXXDefaultConstructor, 
          DefaultCon, 
          /* ConstRHS */ false, 
          /* Diagnose */ false);
    }
    
    // Build an exception specification pointing back at this constructor.
    FunctionProtoType.ExtProtoInfo EPI = getImplicitMethodEPI(/*Deref*/$this(), DefaultCon);
    DefaultCon.setType($this().Context.getFunctionType($this().Context.VoidTy.$QualType(), new ArrayRef<QualType>(None, false), EPI));
    
    // We don't need to use SpecialMemberIsTrivial here; triviality for default
    // constructors is easy to compute.
    DefaultCon.setTrivial(ClassDecl.hasTrivialDefaultConstructor());
    
    // Note that we have declared this constructor.
    ++ASTContext.NumImplicitDefaultConstructorsDeclared;
    
    Scope /*P*/ S = $this().getScopeForContext(ClassDecl);
    $this().CheckImplicitSpecialMemberDeclaration(S, DefaultCon);
    if ($this().ShouldDeleteSpecialMember(DefaultCon, CXXSpecialMember.CXXDefaultConstructor)) {
      $this().SetDeclDeleted(DefaultCon, new SourceLocation(ClassLoc));
    }
    if ((S != null)) {
      $this().PushOnScopeChains(DefaultCon, S, false);
    }
    ClassDecl.addDecl(DefaultCon);
    
    return DefaultCon;
  } finally {
    if (DSM != null) { DSM.$destroy(); }
  }
}


/// DefineImplicitDefaultConstructor - Checks for feasibility of
/// defining this constructor as the default constructor.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DefineImplicitDefaultConstructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9194,
 FQN="clang::Sema::DefineImplicitDefaultConstructor", NM="_ZN5clang4Sema32DefineImplicitDefaultConstructorENS_14SourceLocationEPNS_18CXXConstructorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema32DefineImplicitDefaultConstructorENS_14SourceLocationEPNS_18CXXConstructorDeclE")
//</editor-fold>
public final void DefineImplicitDefaultConstructor(SourceLocation CurrentLocation, 
                                CXXConstructorDecl /*P*/ Constructor) {
  SynthesizedFunctionScope Scope = null;
  try {
    assert ((Constructor.isDefaulted() && Constructor.isDefaultConstructor() && !Constructor.doesThisDeclarationHaveABody() && !Constructor.isDeleted())) : "DefineImplicitDefaultConstructor - call it for implicit default ctor";
    
    CXXRecordDecl /*P*/ ClassDecl = Constructor.getParent();
    assert ((ClassDecl != null)) : "DefineImplicitDefaultConstructor - invalid constructor";
    
    Scope/*J*/= new SynthesizedFunctionScope(/*Deref*/$this(), Constructor);
    DiagnosticErrorTrap Trap/*J*/= new DiagnosticErrorTrap($this().Diags);
    if ($this().SetCtorInitializers(Constructor, /*AnyErrors=*/ false)
       || Trap.hasErrorOccurred()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(CurrentLocation), diag.note_member_synthesized_at)), 
                CXXSpecialMember.CXXDefaultConstructor), $this().Context.getTagDeclType(ClassDecl)));
        Constructor.setInvalidDecl();
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // The exception specification is needed because we are defining the
    // function.
    $this().ResolveExceptionSpec(new SourceLocation(CurrentLocation), 
        Constructor.getType().$arrow().castAs(FunctionProtoType.class));
    
    SourceLocation Loc = Constructor.getLocEnd().isValid() ? Constructor.getLocEnd() : Constructor.getLocation();
    Constructor.setBody(/*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
            return new CompoundStmt(new SourceLocation(Loc));
         }));
    
    Constructor.markUsed($this().Context);
    $this().MarkVTableUsed(new SourceLocation(CurrentLocation), ClassDecl);
    {
      
      ASTMutationListener /*P*/ L = $this().getASTMutationListener();
      if ((L != null)) {
        L.CompletedImplicitDefinition(Constructor);
      }
    }
    
    DiagnoseUninitializedFields(/*Deref*/$this(), Constructor);
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}


/// \brief Declare the implicit destructor for the given class.
///
/// \param ClassDecl The class declaration into which the implicit
/// destructor will be added.
///
/// \returns The implicitly-declared destructor.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DeclareImplicitDestructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9450,
 FQN="clang::Sema::DeclareImplicitDestructor", NM="_ZN5clang4Sema25DeclareImplicitDestructorEPNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema25DeclareImplicitDestructorEPNS_13CXXRecordDeclE")
//</editor-fold>
public final CXXDestructorDecl /*P*/ DeclareImplicitDestructor(CXXRecordDecl /*P*/ ClassDecl) {
  DeclaringSpecialMember DSM = null;
  try {
    // C++ [class.dtor]p2:
    //   If a class has no user-declared destructor, a destructor is
    //   declared implicitly. An implicitly-declared destructor is an
    //   inline public member of its class.
    assert (ClassDecl.needsImplicitDestructor());
    
    DSM/*J*/= new DeclaringSpecialMember(/*Deref*/$this(), ClassDecl, CXXSpecialMember.CXXDestructor);
    if (DSM.isAlreadyBeingDeclared()) {
      return null;
    }
    
    // Create the actual destructor declaration.
    CanQual<Type> ClassType = $this().Context.getCanonicalType($this().Context.getTypeDeclType(ClassDecl));
    SourceLocation ClassLoc = ClassDecl.getLocation();
    DeclarationName Name = $this().Context.DeclarationNames.getCXXDestructorName(new CanQual<Type>(ClassType));
    DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo(new DeclarationName(Name), new SourceLocation(ClassLoc));
    CXXDestructorDecl /*P*/ Destructor = CXXDestructorDecl.Create($this().Context, ClassDecl, new SourceLocation(ClassLoc), NameInfo, 
        new QualType(), (TypeSourceInfo /*P*/ )null, /*isInline=*/ true, 
        /*isImplicitlyDeclared=*/ true);
    Destructor.setAccess(AccessSpecifier.AS_public);
    Destructor.setDefaulted();
    if ($this().getLangOpts().CUDA) {
      $this().inferCUDATargetForImplicitSpecialMember(ClassDecl, CXXSpecialMember.CXXDestructor, 
          Destructor, 
          /* ConstRHS */ false, 
          /* Diagnose */ false);
    }
    
    // Build an exception specification pointing back at this destructor.
    FunctionProtoType.ExtProtoInfo EPI = getImplicitMethodEPI(/*Deref*/$this(), Destructor);
    Destructor.setType($this().Context.getFunctionType($this().Context.VoidTy.$QualType(), new ArrayRef<QualType>(None, false), EPI));
    
    // We don't need to use SpecialMemberIsTrivial here; triviality for
    // destructors is easy to compute.
    Destructor.setTrivial(ClassDecl.hasTrivialDestructor());
    
    // Note that we have declared this destructor.
    ++ASTContext.NumImplicitDestructorsDeclared;
    
    Scope /*P*/ S = $this().getScopeForContext(ClassDecl);
    $this().CheckImplicitSpecialMemberDeclaration(S, Destructor);
    if ($this().ShouldDeleteSpecialMember(Destructor, CXXSpecialMember.CXXDestructor)) {
      $this().SetDeclDeleted(Destructor, new SourceLocation(ClassLoc));
    }
    
    // Introduce this destructor into its scope.
    if ((S != null)) {
      $this().PushOnScopeChains(Destructor, S, false);
    }
    ClassDecl.addDecl(Destructor);
    
    return Destructor;
  } finally {
    if (DSM != null) { DSM.$destroy(); }
  }
}


/// DefineImplicitDestructor - Checks for feasibility of
/// defining this destructor as the default destructor.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DefineImplicitDestructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9507,
 FQN="clang::Sema::DefineImplicitDestructor", NM="_ZN5clang4Sema24DefineImplicitDestructorENS_14SourceLocationEPNS_17CXXDestructorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema24DefineImplicitDestructorENS_14SourceLocationEPNS_17CXXDestructorDeclE")
//</editor-fold>
public final void DefineImplicitDestructor(SourceLocation CurrentLocation, 
                        CXXDestructorDecl /*P*/ Destructor) {
  SynthesizedFunctionScope Scope = null;
  try {
    assert ((Destructor.isDefaulted() && !Destructor.doesThisDeclarationHaveABody() && !Destructor.isDeleted())) : "DefineImplicitDestructor - call it for implicit default dtor";
    CXXRecordDecl /*P*/ ClassDecl = Destructor.getParent();
    assert ((ClassDecl != null)) : "DefineImplicitDestructor - invalid destructor";
    if (Destructor.isInvalidDecl()) {
      return;
    }
    
    Scope/*J*/= new SynthesizedFunctionScope(/*Deref*/$this(), Destructor);
    
    DiagnosticErrorTrap Trap/*J*/= new DiagnosticErrorTrap($this().Diags);
    $this().MarkBaseAndMemberDestructorsReferenced(Destructor.getLocation(), 
        Destructor.getParent());
    if ($this().CheckDestructor(Destructor) || Trap.hasErrorOccurred()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(CurrentLocation), diag.note_member_synthesized_at)), 
                CXXSpecialMember.CXXDestructor), $this().Context.getTagDeclType(ClassDecl)));
        
        Destructor.setInvalidDecl();
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // The exception specification is needed because we are defining the
    // function.
    $this().ResolveExceptionSpec(new SourceLocation(CurrentLocation), 
        Destructor.getType().$arrow().castAs(FunctionProtoType.class));
    
    SourceLocation Loc = Destructor.getLocEnd().isValid() ? Destructor.getLocEnd() : Destructor.getLocation();
    Destructor.setBody(/*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
            return new CompoundStmt(new SourceLocation(Loc));
         }));
    Destructor.markUsed($this().Context);
    $this().MarkVTableUsed(new SourceLocation(CurrentLocation), ClassDecl);
    {
      
      ASTMutationListener /*P*/ L = $this().getASTMutationListener();
      if ((L != null)) {
        L.CompletedImplicitDefinition(Destructor);
      }
    }
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}


/// \brief Build an exception spec for destructors that don't have one.
///
/// C++11 says that user-defined destructors with no exception spec get one
/// that looks as if the destructor was implicitly declared.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AdjustDestructorExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9637,
 FQN="clang::Sema::AdjustDestructorExceptionSpec", NM="_ZN5clang4Sema29AdjustDestructorExceptionSpecEPNS_13CXXRecordDeclEPNS_17CXXDestructorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema29AdjustDestructorExceptionSpecEPNS_13CXXRecordDeclEPNS_17CXXDestructorDeclE")
//</editor-fold>
public final void AdjustDestructorExceptionSpec(CXXRecordDecl /*P*/ ClassDecl, 
                             CXXDestructorDecl /*P*/ Destructor) {
  assert ($this().getLangOpts().CPlusPlus11) : "adjusting dtor exception specs was introduced in c++11";
  
  // C++11 [class.dtor]p3:
  //   A declaration of a destructor that does not have an exception-
  //   specification is implicitly considered to have the same exception-
  //   specification as an implicit declaration.
  /*const*/ FunctionProtoType /*P*/ DtorType = Destructor.getType().$arrow().getAs(FunctionProtoType.class);
  if (DtorType.hasExceptionSpec()) {
    return;
  }
  
  // Replace the destructor's type, building off the existing one. Fortunately,
  // the only thing of interest in the destructor type is its extended info.
  // The return and arguments are fixed.
  FunctionProtoType.ExtProtoInfo EPI = DtorType.getExtProtoInfo();
  EPI.ExceptionSpec.Type = ExceptionSpecificationType.EST_Unevaluated;
  EPI.ExceptionSpec.SourceDecl = Destructor;
  Destructor.setType($this().Context.getFunctionType($this().Context.VoidTy.$QualType(), new ArrayRef<QualType>(None, false), EPI));
  // FIXME: If the destructor has a body that could throw, and the newly created
  // spec doesn't allow exceptions, we should emit a warning, because this
  // change in behavior can break conforming C++03 programs at runtime.
  // However, we don't have a body or an exception specification yet, so it
  // needs to be done somewhere else.
}


/// \brief Define the specified inheriting constructor.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DefineInheritingConstructor">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9329,
 FQN="clang::Sema::DefineInheritingConstructor", NM="_ZN5clang4Sema27DefineInheritingConstructorENS_14SourceLocationEPNS_18CXXConstructorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema27DefineInheritingConstructorENS_14SourceLocationEPNS_18CXXConstructorDeclE")
//</editor-fold>
public final void DefineInheritingConstructor(SourceLocation CurrentLocation, 
                           CXXConstructorDecl /*P*/ Constructor) {
  InheritedConstructorInfo ICI = null;
  SynthesizedFunctionScope Scope = null;
  try {
    CXXRecordDecl /*P*/ ClassDecl = Constructor.getParent();
    assert (Constructor.getInheritedConstructor().$bool() && !Constructor.doesThisDeclarationHaveABody() && !Constructor.isDeleted());
    if (Constructor.isInvalidDecl()) {
      return;
    }
    
    ConstructorUsingShadowDecl /*P*/ Shadow = Constructor.getInheritedConstructor().getShadowDecl();
    CXXConstructorDecl /*P*/ InheritedCtor = Constructor.getInheritedConstructor().getConstructor();
    
    // [class.inhctor.init]p1:
    //   initialization proceeds as if a defaulted default constructor is used to
    //   initialize the D object and each base class subobject from which the
    //   constructor was inherited
    ICI/*J*/= new InheritedConstructorInfo(/*Deref*/$this(), new SourceLocation(CurrentLocation), Shadow);
    CXXRecordDecl /*P*/ RD = Shadow.getParent();
    SourceLocation InitLoc = Shadow.getLocation();
    
    // Initializations are performed "as if by a defaulted default constructor",
    // so enter the appropriate scope.
    Scope/*J*/= new SynthesizedFunctionScope(/*Deref*/$this(), Constructor);
    DiagnosticErrorTrap Trap/*J*/= new DiagnosticErrorTrap($this().Diags);
    
    // Build explicit initializers for all base classes from which the
    // constructor was inherited.
    SmallVector<CXXCtorInitializer /*P*/ > Inits/*J*/= new SmallVector<CXXCtorInitializer /*P*/ >(8, (CXXCtorInitializer /*P*/ )null);
    for (boolean VBase : new boolean[]{false, true}) {
      for (final CXXBaseSpecifier /*&*/ B : VBase ? RD.vbases() : RD.bases()) {
        if (B.isVirtual() != VBase) {
          continue;
        }
        
        CXXRecordDecl /*P*/ BaseRD = B.getType().$arrow().getAsCXXRecordDecl();
        if (!(BaseRD != null)) {
          continue;
        }
        
        std.pairTypeBool<CXXConstructorDecl /*P*/ > BaseCtor = ICI.findConstructorForBase(BaseRD, InheritedCtor);
        if (!(BaseCtor.first != null)) {
          continue;
        }
        
        $this().MarkFunctionReferenced(new SourceLocation(CurrentLocation), BaseCtor.first);
        ActionResultTTrue<Expr /*P*/ > Init = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
                return new CXXInheritedCtorInitExpr(new SourceLocation(InitLoc), B.getType(), BaseCtor.first, VBase, BaseCtor.second);
             }));
        
        TypeSourceInfo /*P*/ TInfo = $this().Context.getTrivialTypeSourceInfo(B.getType(), /*NO_COPY*/InitLoc);
        Inits.push_back(/*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
            /*new (Context)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
                return new CXXCtorInitializer($this().Context, TInfo, VBase, new SourceLocation(InitLoc), Init.get(), new SourceLocation(InitLoc), 
                        new SourceLocation());
             }));
      }
    }
    
    // We now proceed as if for a defaulted default constructor, with the relevant
    // initializers replaced.
    boolean HadError = $this().SetCtorInitializers(Constructor, /*AnyErrors*/ false, new ArrayRef<CXXCtorInitializer /*P*/ >(Inits, true));
    if (HadError || Trap.hasErrorOccurred()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(CurrentLocation), diag.note_inhctor_synthesized_at)), RD));
        Constructor.setInvalidDecl();
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // The exception specification is needed because we are defining the
    // function.
    $this().ResolveExceptionSpec(new SourceLocation(CurrentLocation), 
        Constructor.getType().$arrow().castAs(FunctionProtoType.class));
    
    Constructor.setBody(/*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
            return new CompoundStmt(new SourceLocation(InitLoc));
         }));
    
    Constructor.markUsed($this().Context);
    $this().MarkVTableUsed(new SourceLocation(CurrentLocation), ClassDecl);
    {
      
      ASTMutationListener /*P*/ L = $this().getASTMutationListener();
      if ((L != null)) {
        L.CompletedImplicitDefinition(Constructor);
      }
    }
    
    DiagnoseUninitializedFields(/*Deref*/$this(), Constructor);
  } finally {
    if (Scope != null) { Scope.$destroy(); }
    if (ICI != null) { ICI.$destroy(); }
  }
}


/// \brief Declare the implicit copy constructor for the given class.
///
/// \param ClassDecl The class declaration into which the implicit
/// copy constructor will be added.
///
/// \returns The implicitly-declared copy constructor.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DeclareImplicitCopyConstructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 10972,
 FQN="clang::Sema::DeclareImplicitCopyConstructor", NM="_ZN5clang4Sema30DeclareImplicitCopyConstructorEPNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema30DeclareImplicitCopyConstructorEPNS_13CXXRecordDeclE")
//</editor-fold>
public final CXXConstructorDecl /*P*/ DeclareImplicitCopyConstructor(CXXRecordDecl /*P*/ ClassDecl) {
  DeclaringSpecialMember DSM = null;
  try {
    // C++ [class.copy]p4:
    //   If the class definition does not explicitly declare a copy
    //   constructor, one is declared implicitly.
    assert (ClassDecl.needsImplicitCopyConstructor());
    
    DSM/*J*/= new DeclaringSpecialMember(/*Deref*/$this(), ClassDecl, CXXSpecialMember.CXXCopyConstructor);
    if (DSM.isAlreadyBeingDeclared()) {
      return null;
    }
    
    QualType ClassType = $this().Context.getTypeDeclType(ClassDecl);
    QualType ArgType = new QualType(ClassType);
    boolean Const = ClassDecl.implicitCopyConstructorHasConstParam();
    if (Const) {
      ArgType.$assignMove(ArgType.withConst());
    }
    ArgType.$assignMove($this().Context.getLValueReferenceType(new QualType(ArgType)));
    
    boolean Constexpr = defaultedSpecialMemberIsConstexpr(/*Deref*/$this(), ClassDecl, 
        CXXSpecialMember.CXXCopyConstructor, 
        Const);
    
    DeclarationName Name = $this().Context.DeclarationNames.getCXXConstructorName($this().Context.getCanonicalType(new QualType(ClassType)));
    SourceLocation ClassLoc = ClassDecl.getLocation();
    DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo(new DeclarationName(Name), new SourceLocation(ClassLoc));
    
    //   An implicitly-declared copy constructor is an inline public
    //   member of its class.
    CXXConstructorDecl /*P*/ CopyConstructor = CXXConstructorDecl.Create($this().Context, ClassDecl, new SourceLocation(ClassLoc), NameInfo, new QualType(), /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
        /*isExplicit=*/ false, /*isInline=*/ true, /*isImplicitlyDeclared=*/ true, 
        Constexpr);
    CopyConstructor.setAccess(AccessSpecifier.AS_public);
    CopyConstructor.setDefaulted();
    if ($this().getLangOpts().CUDA) {
      $this().inferCUDATargetForImplicitSpecialMember(ClassDecl, CXXSpecialMember.CXXCopyConstructor, 
          CopyConstructor, 
          /* ConstRHS */ Const, 
          /* Diagnose */ false);
    }
    
    // Build an exception specification pointing back at this member.
    FunctionProtoType.ExtProtoInfo EPI = getImplicitMethodEPI(/*Deref*/$this(), CopyConstructor);
    CopyConstructor.setType($this().Context.getFunctionType($this().Context.VoidTy.$QualType(), new ArrayRef<QualType>(ArgType, false), EPI));
    
    // Add the parameter to the constructor.
    ParmVarDecl /*P*/ FromParam = ParmVarDecl.Create($this().Context, CopyConstructor, 
        new SourceLocation(ClassLoc), new SourceLocation(ClassLoc), 
        /*IdentifierInfo=*/ (IdentifierInfo /*P*/ )null, 
        new QualType(ArgType), /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
        StorageClass.SC_None, (Expr /*P*/ )null);
    CopyConstructor.setParams(new ArrayRef<ParmVarDecl /*P*/ >(FromParam, true));
    
    CopyConstructor.setTrivial(ClassDecl.needsOverloadResolutionForCopyConstructor() ? $this().SpecialMemberIsTrivial(CopyConstructor, CXXSpecialMember.CXXCopyConstructor) : ClassDecl.hasTrivialCopyConstructor());
    
    // Note that we have declared this constructor.
    ++ASTContext.NumImplicitCopyConstructorsDeclared;
    
    Scope /*P*/ S = $this().getScopeForContext(ClassDecl);
    $this().CheckImplicitSpecialMemberDeclaration(S, CopyConstructor);
    if ($this().ShouldDeleteSpecialMember(CopyConstructor, CXXSpecialMember.CXXCopyConstructor)) {
      $this().SetDeclDeleted(CopyConstructor, new SourceLocation(ClassLoc));
    }
    if ((S != null)) {
      $this().PushOnScopeChains(CopyConstructor, S, false);
    }
    ClassDecl.addDecl(CopyConstructor);
    
    return CopyConstructor;
  } finally {
    if (DSM != null) { DSM.$destroy(); }
  }
}


/// DefineImplicitCopyConstructor - Checks for feasibility of
/// defining this constructor as the copy constructor.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DefineImplicitCopyConstructor">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 11051,
 FQN="clang::Sema::DefineImplicitCopyConstructor", NM="_ZN5clang4Sema29DefineImplicitCopyConstructorENS_14SourceLocationEPNS_18CXXConstructorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema29DefineImplicitCopyConstructorENS_14SourceLocationEPNS_18CXXConstructorDeclE")
//</editor-fold>
public final void DefineImplicitCopyConstructor(SourceLocation CurrentLocation, 
                             CXXConstructorDecl /*P*/ CopyConstructor) {
  SynthesizedFunctionScope Scope = null;
  try {
    assert ((CopyConstructor.isDefaulted() && CopyConstructor.isCopyConstructor() && !CopyConstructor.doesThisDeclarationHaveABody() && !CopyConstructor.isDeleted())) : "DefineImplicitCopyConstructor - call it for implicit copy ctor";
    
    CXXRecordDecl /*P*/ ClassDecl = CopyConstructor.getParent();
    assert ((ClassDecl != null)) : "DefineImplicitCopyConstructor - invalid constructor";
    
    // C++11 [class.copy]p7:
    //   The [definition of an implicitly declared copy constructor] is
    //   deprecated if the class has a user-declared copy assignment operator
    //   or a user-declared destructor.
    if ($this().getLangOpts().CPlusPlus11 && CopyConstructor.isImplicit()) {
      diagnoseDeprecatedCopyOperation(/*Deref*/$this(), CopyConstructor, new SourceLocation(CurrentLocation));
    }
    
    Scope/*J*/= new SynthesizedFunctionScope(/*Deref*/$this(), CopyConstructor);
    DiagnosticErrorTrap Trap/*J*/= new DiagnosticErrorTrap($this().Diags);
    if ($this().SetCtorInitializers(CopyConstructor, /*AnyErrors=*/ false)
       || Trap.hasErrorOccurred()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(CurrentLocation), diag.note_member_synthesized_at)), 
                CXXSpecialMember.CXXCopyConstructor), $this().Context.getTagDeclType(ClassDecl)));
        CopyConstructor.setInvalidDecl();
      } finally {
        $c$.$destroy();
      }
    } else {
      Sema.CompoundScopeRAII CompoundScope = null;
      try {
        SourceLocation Loc = CopyConstructor.getLocEnd().isValid() ? CopyConstructor.getLocEnd() : CopyConstructor.getLocation();
        CompoundScope/*J*/= new Sema.CompoundScopeRAII(/*Deref*/$this());
        CopyConstructor.setBody((Stmt)$this().ActOnCompoundStmt(new SourceLocation(Loc), new SourceLocation(Loc), new ArrayRef(None), /*isStmtExpr=*/ false).getAs(Stmt.class));
      } finally {
        if (CompoundScope != null) { CompoundScope.$destroy(); }
      }
    }
    
    // The exception specification is needed because we are defining the
    // function.
    $this().ResolveExceptionSpec(new SourceLocation(CurrentLocation), 
        CopyConstructor.getType().$arrow().castAs(FunctionProtoType.class));
    
    CopyConstructor.markUsed($this().Context);
    $this().MarkVTableUsed(new SourceLocation(CurrentLocation), ClassDecl);
    {
      
      ASTMutationListener /*P*/ L = $this().getASTMutationListener();
      if ((L != null)) {
        L.CompletedImplicitDefinition(CopyConstructor);
      }
    }
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}


/// \brief Declare the implicit move constructor for the given class.
///
/// \param ClassDecl The Class declaration into which the implicit
/// move constructor will be added.
///
/// \returns The implicitly-declared move constructor, or NULL if it wasn't
/// declared.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DeclareImplicitMoveConstructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 11158,
 FQN="clang::Sema::DeclareImplicitMoveConstructor", NM="_ZN5clang4Sema30DeclareImplicitMoveConstructorEPNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema30DeclareImplicitMoveConstructorEPNS_13CXXRecordDeclE")
//</editor-fold>
public final CXXConstructorDecl /*P*/ DeclareImplicitMoveConstructor(CXXRecordDecl /*P*/ ClassDecl) {
  DeclaringSpecialMember DSM = null;
  try {
    assert (ClassDecl.needsImplicitMoveConstructor());
    
    DSM/*J*/= new DeclaringSpecialMember(/*Deref*/$this(), ClassDecl, CXXSpecialMember.CXXMoveConstructor);
    if (DSM.isAlreadyBeingDeclared()) {
      return null;
    }
    
    QualType ClassType = $this().Context.getTypeDeclType(ClassDecl);
    QualType ArgType = $this().Context.getRValueReferenceType(new QualType(ClassType));
    
    boolean Constexpr = defaultedSpecialMemberIsConstexpr(/*Deref*/$this(), ClassDecl, 
        CXXSpecialMember.CXXMoveConstructor, 
        false);
    
    DeclarationName Name = $this().Context.DeclarationNames.getCXXConstructorName($this().Context.getCanonicalType(new QualType(ClassType)));
    SourceLocation ClassLoc = ClassDecl.getLocation();
    DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo(new DeclarationName(Name), new SourceLocation(ClassLoc));
    
    // C++11 [class.copy]p11:
    //   An implicitly-declared copy/move constructor is an inline public
    //   member of its class.
    CXXConstructorDecl /*P*/ MoveConstructor = CXXConstructorDecl.Create($this().Context, ClassDecl, new SourceLocation(ClassLoc), NameInfo, new QualType(), /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
        /*isExplicit=*/ false, /*isInline=*/ true, /*isImplicitlyDeclared=*/ true, 
        Constexpr);
    MoveConstructor.setAccess(AccessSpecifier.AS_public);
    MoveConstructor.setDefaulted();
    if ($this().getLangOpts().CUDA) {
      $this().inferCUDATargetForImplicitSpecialMember(ClassDecl, CXXSpecialMember.CXXMoveConstructor, 
          MoveConstructor, 
          /* ConstRHS */ false, 
          /* Diagnose */ false);
    }
    
    // Build an exception specification pointing back at this member.
    FunctionProtoType.ExtProtoInfo EPI = getImplicitMethodEPI(/*Deref*/$this(), MoveConstructor);
    MoveConstructor.setType($this().Context.getFunctionType($this().Context.VoidTy.$QualType(), new ArrayRef<QualType>(ArgType, false), EPI));
    
    // Add the parameter to the constructor.
    ParmVarDecl /*P*/ FromParam = ParmVarDecl.Create($this().Context, MoveConstructor, 
        new SourceLocation(ClassLoc), new SourceLocation(ClassLoc), 
        /*IdentifierInfo=*/ (IdentifierInfo /*P*/ )null, 
        new QualType(ArgType), /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
        StorageClass.SC_None, (Expr /*P*/ )null);
    MoveConstructor.setParams(new ArrayRef<ParmVarDecl /*P*/ >(FromParam, true));
    
    MoveConstructor.setTrivial(ClassDecl.needsOverloadResolutionForMoveConstructor() ? $this().SpecialMemberIsTrivial(MoveConstructor, CXXSpecialMember.CXXMoveConstructor) : ClassDecl.hasTrivialMoveConstructor());
    
    // Note that we have declared this constructor.
    ++ASTContext.NumImplicitMoveConstructorsDeclared;
    
    Scope /*P*/ S = $this().getScopeForContext(ClassDecl);
    $this().CheckImplicitSpecialMemberDeclaration(S, MoveConstructor);
    if ($this().ShouldDeleteSpecialMember(MoveConstructor, CXXSpecialMember.CXXMoveConstructor)) {
      ClassDecl.setImplicitMoveConstructorIsDeleted();
      $this().SetDeclDeleted(MoveConstructor, new SourceLocation(ClassLoc));
    }
    if ((S != null)) {
      $this().PushOnScopeChains(MoveConstructor, S, false);
    }
    ClassDecl.addDecl(MoveConstructor);
    
    return MoveConstructor;
  } finally {
    if (DSM != null) { DSM.$destroy(); }
  }
}


/// DefineImplicitMoveConstructor - Checks for feasibility of
/// defining this constructor as the move constructor.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DefineImplicitMoveConstructor">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 11233,
 FQN="clang::Sema::DefineImplicitMoveConstructor", NM="_ZN5clang4Sema29DefineImplicitMoveConstructorENS_14SourceLocationEPNS_18CXXConstructorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema29DefineImplicitMoveConstructorENS_14SourceLocationEPNS_18CXXConstructorDeclE")
//</editor-fold>
public final void DefineImplicitMoveConstructor(SourceLocation CurrentLocation, 
                             CXXConstructorDecl /*P*/ MoveConstructor) {
  SynthesizedFunctionScope Scope = null;
  try {
    assert ((MoveConstructor.isDefaulted() && MoveConstructor.isMoveConstructor() && !MoveConstructor.doesThisDeclarationHaveABody() && !MoveConstructor.isDeleted())) : "DefineImplicitMoveConstructor - call it for implicit move ctor";
    
    CXXRecordDecl /*P*/ ClassDecl = MoveConstructor.getParent();
    assert ((ClassDecl != null)) : "DefineImplicitMoveConstructor - invalid constructor";
    
    Scope/*J*/= new SynthesizedFunctionScope(/*Deref*/$this(), MoveConstructor);
    DiagnosticErrorTrap Trap/*J*/= new DiagnosticErrorTrap($this().Diags);
    if ($this().SetCtorInitializers(MoveConstructor, /*AnyErrors=*/ false)
       || Trap.hasErrorOccurred()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(CurrentLocation), diag.note_member_synthesized_at)), 
                CXXSpecialMember.CXXMoveConstructor), $this().Context.getTagDeclType(ClassDecl)));
        MoveConstructor.setInvalidDecl();
      } finally {
        $c$.$destroy();
      }
    } else {
      Sema.CompoundScopeRAII CompoundScope = null;
      try {
        SourceLocation Loc = MoveConstructor.getLocEnd().isValid() ? MoveConstructor.getLocEnd() : MoveConstructor.getLocation();
        CompoundScope/*J*/= new Sema.CompoundScopeRAII(/*Deref*/$this());
        MoveConstructor.setBody((Stmt)$this().ActOnCompoundStmt(new SourceLocation(Loc), new SourceLocation(Loc), new ArrayRef(None), /*isStmtExpr=*/ false).getAs(Stmt.class));
      } finally {
        if (CompoundScope != null) { CompoundScope.$destroy(); }
      }
    }
    
    // The exception specification is needed because we are defining the
    // function.
    $this().ResolveExceptionSpec(new SourceLocation(CurrentLocation), 
        MoveConstructor.getType().$arrow().castAs(FunctionProtoType.class));
    
    MoveConstructor.markUsed($this().Context);
    $this().MarkVTableUsed(new SourceLocation(CurrentLocation), ClassDecl);
    {
      
      ASTMutationListener /*P*/ L = $this().getASTMutationListener();
      if ((L != null)) {
        L.CompletedImplicitDefinition(MoveConstructor);
      }
    }
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}


/// \brief Declare the implicit copy assignment operator for the given class.
///
/// \param ClassDecl The class declaration into which the implicit
/// copy assignment operator will be added.
///
/// \returns The implicitly-declared copy assignment operator.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DeclareImplicitCopyAssignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 10146,
 FQN="clang::Sema::DeclareImplicitCopyAssignment", NM="_ZN5clang4Sema29DeclareImplicitCopyAssignmentEPNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema29DeclareImplicitCopyAssignmentEPNS_13CXXRecordDeclE")
//</editor-fold>
public final CXXMethodDecl /*P*/ DeclareImplicitCopyAssignment(CXXRecordDecl /*P*/ ClassDecl) {
  DeclaringSpecialMember DSM = null;
  try {
    // Note: The following rules are largely analoguous to the copy
    // constructor rules. Note that virtual bases are not taken into account
    // for determining the argument type of the operator. Note also that
    // operators taking an object instead of a reference are allowed.
    assert (ClassDecl.needsImplicitCopyAssignment());
    
    DSM/*J*/= new DeclaringSpecialMember(/*Deref*/$this(), ClassDecl, CXXSpecialMember.CXXCopyAssignment);
    if (DSM.isAlreadyBeingDeclared()) {
      return null;
    }
    
    QualType ArgType = $this().Context.getTypeDeclType(ClassDecl);
    QualType RetType = $this().Context.getLValueReferenceType(new QualType(ArgType));
    boolean Const = ClassDecl.implicitCopyAssignmentHasConstParam();
    if (Const) {
      ArgType.$assignMove(ArgType.withConst());
    }
    ArgType.$assignMove($this().Context.getLValueReferenceType(new QualType(ArgType)));
    
    boolean Constexpr = defaultedSpecialMemberIsConstexpr(/*Deref*/$this(), ClassDecl, 
        CXXSpecialMember.CXXCopyAssignment, 
        Const);
    
    //   An implicitly-declared copy assignment operator is an inline public
    //   member of its class.
    DeclarationName Name = $this().Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_Equal);
    SourceLocation ClassLoc = ClassDecl.getLocation();
    DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo(new DeclarationName(Name), new SourceLocation(ClassLoc));
    CXXMethodDecl /*P*/ CopyAssignment = CXXMethodDecl.Create($this().Context, ClassDecl, new SourceLocation(ClassLoc), NameInfo, new QualType(), 
        /*TInfo=*/ (TypeSourceInfo /*P*/ )null, /*StorageClass=*/ StorageClass.SC_None, 
        /*isInline=*/ true, Constexpr, new SourceLocation());
    CopyAssignment.setAccess(AccessSpecifier.AS_public);
    CopyAssignment.setDefaulted();
    CopyAssignment.setImplicit();
    if ($this().getLangOpts().CUDA) {
      $this().inferCUDATargetForImplicitSpecialMember(ClassDecl, CXXSpecialMember.CXXCopyAssignment, 
          CopyAssignment, 
          /* ConstRHS */ Const, 
          /* Diagnose */ false);
    }
    
    // Build an exception specification pointing back at this member.
    FunctionProtoType.ExtProtoInfo EPI = getImplicitMethodEPI(/*Deref*/$this(), CopyAssignment);
    CopyAssignment.setType($this().Context.getFunctionType(new QualType(RetType), new ArrayRef<QualType>(ArgType, false), EPI));
    
    // Add the parameter to the operator.
    ParmVarDecl /*P*/ FromParam = ParmVarDecl.Create($this().Context, CopyAssignment, 
        new SourceLocation(ClassLoc), new SourceLocation(ClassLoc), 
        /*Id=*/ (IdentifierInfo /*P*/ )null, new QualType(ArgType), 
        /*TInfo=*/ (TypeSourceInfo /*P*/ )null, StorageClass.SC_None, 
        (Expr /*P*/ )null);
    CopyAssignment.setParams(new ArrayRef<ParmVarDecl /*P*/ >(FromParam, true));
    
    CopyAssignment.setTrivial(ClassDecl.needsOverloadResolutionForCopyAssignment() ? $this().SpecialMemberIsTrivial(CopyAssignment, CXXSpecialMember.CXXCopyAssignment) : ClassDecl.hasTrivialCopyAssignment());
    
    // Note that we have added this copy-assignment operator.
    ++ASTContext.NumImplicitCopyAssignmentOperatorsDeclared;
    
    Scope /*P*/ S = $this().getScopeForContext(ClassDecl);
    $this().CheckImplicitSpecialMemberDeclaration(S, CopyAssignment);
    if ($this().ShouldDeleteSpecialMember(CopyAssignment, CXXSpecialMember.CXXCopyAssignment)) {
      $this().SetDeclDeleted(CopyAssignment, new SourceLocation(ClassLoc));
    }
    if ((S != null)) {
      $this().PushOnScopeChains(CopyAssignment, S, false);
    }
    ClassDecl.addDecl(CopyAssignment);
    
    return CopyAssignment;
  } finally {
    if (DSM != null) { DSM.$destroy(); }
  }
}


/// \brief Defines an implicitly-declared copy assignment operator.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DefineImplicitCopyAssignment">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 10272,
 FQN="clang::Sema::DefineImplicitCopyAssignment", NM="_ZN5clang4Sema28DefineImplicitCopyAssignmentENS_14SourceLocationEPNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema28DefineImplicitCopyAssignmentENS_14SourceLocationEPNS_13CXXMethodDeclE")
//</editor-fold>
public final void DefineImplicitCopyAssignment(SourceLocation CurrentLocation, 
                            CXXMethodDecl /*P*/ CopyAssignOperator) {
  SynthesizedFunctionScope Scope = null;
  RefBuilder OtherRef = null;
  ThisBuilder This = null;
  try {
    assert ((CopyAssignOperator.isDefaulted() && CopyAssignOperator.isOverloadedOperator() && CopyAssignOperator.getOverloadedOperator() == OverloadedOperatorKind.OO_Equal && !CopyAssignOperator.doesThisDeclarationHaveABody() && !CopyAssignOperator.isDeleted())) : "DefineImplicitCopyAssignment called for wrong function";
    
    CXXRecordDecl /*P*/ ClassDecl = CopyAssignOperator.getParent();
    if (ClassDecl.isInvalidDecl() || CopyAssignOperator.isInvalidDecl()) {
      CopyAssignOperator.setInvalidDecl();
      return;
    }
    
    // C++11 [class.copy]p18:
    //   The [definition of an implicitly declared copy assignment operator] is
    //   deprecated if the class has a user-declared copy constructor or a
    //   user-declared destructor.
    if ($this().getLangOpts().CPlusPlus11 && CopyAssignOperator.isImplicit()) {
      diagnoseDeprecatedCopyOperation(/*Deref*/$this(), CopyAssignOperator, new SourceLocation(CurrentLocation));
    }
    
    CopyAssignOperator.markUsed($this().Context);
    
    Scope/*J*/= new SynthesizedFunctionScope(/*Deref*/$this(), CopyAssignOperator);
    DiagnosticErrorTrap Trap/*J*/= new DiagnosticErrorTrap($this().Diags);
    
    // C++0x [class.copy]p30:
    //   The implicitly-defined or explicitly-defaulted copy assignment operator
    //   for a non-union class X performs memberwise copy assignment of its 
    //   subobjects. The direct base classes of X are assigned first, in the 
    //   order of their declaration in the base-specifier-list, and then the 
    //   immediate non-static data members of X are assigned, in the order in 
    //   which they were declared in the class definition.
    
    // The statements that form the synthesized function body.
    SmallVector<Stmt /*P*/ > Statements/*J*/= new SmallVector<Stmt /*P*/ >(8, (Stmt /*P*/ )null);
    
    // The parameter for the "other" object, which we are copying from.
    ParmVarDecl /*P*/ Other = CopyAssignOperator.getParamDecl(0);
    Qualifiers OtherQuals = Other.getType().getQualifiers();
    QualType OtherRefType = Other.getType();
    {
      /*const*/ LValueReferenceType /*P*/ OtherRef$1 = OtherRefType.$arrow().getAs(LValueReferenceType.class);
      if ((OtherRef$1 != null)) {
        OtherRefType.$assignMove(OtherRef$1.getPointeeType());
        OtherQuals.$assignMove(OtherRefType.getQualifiers());
      }
    }
    
    // Our location for everything implicitly-generated.
    SourceLocation Loc = CopyAssignOperator.getLocEnd().isValid() ? CopyAssignOperator.getLocEnd() : CopyAssignOperator.getLocation();
    
    // Builds a DeclRefExpr for the "other" object.
    OtherRef/*J*/= new RefBuilder(Other, new QualType(OtherRefType));
    
    // Builds the "this" pointer.
    This/*J*/= new ThisBuilder();
    
    // Assign base classes.
    boolean Invalid = false;
    for (final CXXBaseSpecifier /*&*/ Base : ClassDecl.bases()) {
      CastBuilder From = null;
      DerefBuilder DerefThis = null;
      CastBuilder To = null;
      try {
        // Form the assignment:
        //   static_cast<Base*>(this)->Base::operator=(static_cast<Base&>(other));
        QualType BaseType = Base.getType().getUnqualifiedType();
        if (!BaseType.$arrow().isRecordType()) {
          Invalid = true;
          continue;
        }
        
        SmallVector<CXXBaseSpecifier /*P*/> BasePath/*J*/= new SmallVector<CXXBaseSpecifier /*P*/>(4, null);
        BasePath.push_back($AddrOf(Base));
        
        // Construct the "from" expression, which is an implicit cast to the
        // appropriately-qualified base type.
        From/*J*/= new CastBuilder(OtherRef, $this().Context.getQualifiedType(new QualType(BaseType), new Qualifiers(OtherQuals)), 
            ExprValueKind.VK_LValue, BasePath);
        
        // Dereference "this".
        DerefThis/*J*/= new DerefBuilder(This);
        To/*J*/= new CastBuilder(DerefThis, 
            $this().Context.getCVRQualifiedType(new QualType(BaseType), CopyAssignOperator.getTypeQualifiers()), 
            ExprValueKind.VK_LValue, BasePath);
        
        // Build the copy.
        ActionResultTTrue<Stmt /*P*/ > Copy = buildSingleCopyAssign(/*Deref*/$this(), new SourceLocation(Loc), new QualType(BaseType), 
            To, From, 
            /*CopyingBaseSubobject=*/ true, 
            /*Copying=*/ true);
        if (Copy.isInvalid()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(CurrentLocation), diag.note_member_synthesized_at)), 
                    CXXSpecialMember.CXXCopyAssignment), $this().Context.getTagDeclType(ClassDecl)));
            CopyAssignOperator.setInvalidDecl();
            return;
          } finally {
            $c$.$destroy();
          }
        }
        
        // Success! Record the copy.
        Statements.push_back(Copy.getAs(Expr.class));
      } finally {
        if (To != null) { To.$destroy(); }
        if (DerefThis != null) { DerefThis.$destroy(); }
        if (From != null) { From.$destroy(); }
      }
    }
    
    // Assign non-static members.
    for (FieldDecl /*P*/ Field : ClassDecl.fields()) {
      CXXScopeSpec SS = null;
      LookupResult MemberLookup = null;
      MemberBuilder From = null;
      MemberBuilder To = null;
      try {
        // FIXME: We should form some kind of AST representation for the implied
        // memcpy in a union copy operation.
        if (Field.isUnnamedBitfield() || Field.getParent().isUnion()) {
          continue;
        }
        if (Field.isInvalidDecl()) {
          Invalid = true;
          continue;
        }
        
        // Check for members of reference type; we can't copy those.
        if (Field.getType().$arrow().isReferenceType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ClassDecl.getLocation(), diag.err_uninitialized_member_for_assign)), 
                        $this().Context.getTagDeclType(ClassDecl)), 0), Field.getDeclName()));
            $c$.clean($c$.track($this().Diag(Field.getLocation(), diag.note_declared_at)));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(CurrentLocation), diag.note_member_synthesized_at)), 
                    CXXSpecialMember.CXXCopyAssignment), $this().Context.getTagDeclType(ClassDecl)));
            Invalid = true;
            continue;
          } finally {
            $c$.$destroy();
          }
        }
        
        // Check for members of const-qualified, non-class type.
        QualType BaseType = $this().Context.getBaseElementType(Field.getType());
        if (!(BaseType.$arrow().getAs$RecordType() != null) && BaseType.isConstQualified()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ClassDecl.getLocation(), diag.err_uninitialized_member_for_assign)), 
                        $this().Context.getTagDeclType(ClassDecl)), 1), Field.getDeclName()));
            $c$.clean($c$.track($this().Diag(Field.getLocation(), diag.note_declared_at)));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(CurrentLocation), diag.note_member_synthesized_at)), 
                    CXXSpecialMember.CXXCopyAssignment), $this().Context.getTagDeclType(ClassDecl)));
            Invalid = true;
            continue;
          } finally {
            $c$.$destroy();
          }
        }
        
        // Suppress assigning zero-width bitfields.
        if (Field.isBitField() && Field.getBitWidthValue($this().Context) == 0) {
          continue;
        }
        
        QualType FieldType = Field.getType().getNonReferenceType();
        if (FieldType.$arrow().isIncompleteArrayType()) {
          assert (ClassDecl.hasFlexibleArrayMember()) : "Incomplete array type is not valid";
          continue;
        }
        
        // Build references to the field in the object we're copying from and to.
        SS/*J*/= new CXXScopeSpec(); // Intentionally empty
        MemberLookup/*J*/= new LookupResult(/*Deref*/$this(), Field.getDeclName(), new SourceLocation(Loc), 
            LookupNameKind.LookupMemberName);
        MemberLookup.addDecl(Field);
        MemberLookup.resolveKind();
        
        From/*J*/= new MemberBuilder(OtherRef, new QualType(OtherRefType), /*IsArrow=*/ false, MemberLookup);
        
        To/*J*/= new MemberBuilder(This, $this().getCurrentThisType(), /*IsArrow=*/ true, MemberLookup);
        
        // Build the copy of this field.
        ActionResultTTrue<Stmt /*P*/ > Copy = buildSingleCopyAssign(/*Deref*/$this(), new SourceLocation(Loc), new QualType(FieldType), 
            To, From, 
            /*CopyingBaseSubobject=*/ false, 
            /*Copying=*/ true);
        if (Copy.isInvalid()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(CurrentLocation), diag.note_member_synthesized_at)), 
                    CXXSpecialMember.CXXCopyAssignment), $this().Context.getTagDeclType(ClassDecl)));
            CopyAssignOperator.setInvalidDecl();
            return;
          } finally {
            $c$.$destroy();
          }
        }
        
        // Success! Record the copy.
        Statements.push_back(Copy.getAs(Stmt.class));
      } finally {
        if (To != null) { To.$destroy(); }
        if (From != null) { From.$destroy(); }
        if (MemberLookup != null) { MemberLookup.$destroy(); }
        if (SS != null) { SS.$destroy(); }
      }
    }
    if (!Invalid) {
      // Add a "return *this;"
      ActionResultTTrue<Expr /*P*/ > ThisObj = $this().CreateBuiltinUnaryOp(new SourceLocation(Loc), UnaryOperatorKind.UO_Deref, This.build(/*Deref*/$this(), new SourceLocation(Loc)));
      
      ActionResultTTrue<Stmt /*P*/ > Return = $this().BuildReturnStmt(new SourceLocation(Loc), create_type$ptr(ThisObj.get()));
      if (Return.isInvalid()) {
        Invalid = true;
      } else {
        Statements.push_back(Return.getAs(Stmt.class));
        if (Trap.hasErrorOccurred()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(CurrentLocation), diag.note_member_synthesized_at)), 
                    CXXSpecialMember.CXXCopyAssignment), $this().Context.getTagDeclType(ClassDecl)));
            Invalid = true;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    // The exception specification is needed because we are defining the
    // function.
    $this().ResolveExceptionSpec(new SourceLocation(CurrentLocation), 
        CopyAssignOperator.getType().$arrow().castAs(FunctionProtoType.class));
    if (Invalid) {
      CopyAssignOperator.setInvalidDecl();
      return;
    }
    
    ActionResultTTrue<Stmt /*P*/ > Body/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
    {
      CompoundScopeRAII CompoundScope = null;
      try {
        CompoundScope/*J*/= new CompoundScopeRAII(/*Deref*/$this());
        Body.$assignMove($this().ActOnCompoundStmt(new SourceLocation(Loc), new SourceLocation(Loc), new ArrayRef<Stmt /*P*/ >(Statements, true), 
                /*isStmtExpr=*/ false));
        assert (!Body.isInvalid()) : "Compound statement creation cannot fail";
      } finally {
        if (CompoundScope != null) { CompoundScope.$destroy(); }
      }
    }
    CopyAssignOperator.setBody(Body.getAs(Stmt.class));
    {
      
      ASTMutationListener /*P*/ L = $this().getASTMutationListener();
      if ((L != null)) {
        L.CompletedImplicitDefinition(CopyAssignOperator);
      }
    }
  } finally {
    if (This != null) { This.$destroy(); }
    if (OtherRef != null) { OtherRef.$destroy(); }
    if (Scope != null) { Scope.$destroy(); }
  }
}


/// \brief Declare the implicit move assignment operator for the given class.
///
/// \param ClassDecl The Class declaration into which the implicit
/// move assignment operator will be added.
///
/// \returns The implicitly-declared move assignment operator, or NULL if it
/// wasn't declared.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DeclareImplicitMoveAssignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 10542,
 FQN="clang::Sema::DeclareImplicitMoveAssignment", NM="_ZN5clang4Sema29DeclareImplicitMoveAssignmentEPNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema29DeclareImplicitMoveAssignmentEPNS_13CXXRecordDeclE")
//</editor-fold>
public final CXXMethodDecl /*P*/ DeclareImplicitMoveAssignment(CXXRecordDecl /*P*/ ClassDecl) {
  DeclaringSpecialMember DSM = null;
  try {
    assert (ClassDecl.needsImplicitMoveAssignment());
    
    DSM/*J*/= new DeclaringSpecialMember(/*Deref*/$this(), ClassDecl, CXXSpecialMember.CXXMoveAssignment);
    if (DSM.isAlreadyBeingDeclared()) {
      return null;
    }
    
    // Note: The following rules are largely analoguous to the move
    // constructor rules.
    QualType ArgType = $this().Context.getTypeDeclType(ClassDecl);
    QualType RetType = $this().Context.getLValueReferenceType(new QualType(ArgType));
    ArgType.$assignMove($this().Context.getRValueReferenceType(new QualType(ArgType)));
    
    boolean Constexpr = defaultedSpecialMemberIsConstexpr(/*Deref*/$this(), ClassDecl, 
        CXXSpecialMember.CXXMoveAssignment, 
        false);
    
    //   An implicitly-declared move assignment operator is an inline public
    //   member of its class.
    DeclarationName Name = $this().Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_Equal);
    SourceLocation ClassLoc = ClassDecl.getLocation();
    DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo(new DeclarationName(Name), new SourceLocation(ClassLoc));
    CXXMethodDecl /*P*/ MoveAssignment = CXXMethodDecl.Create($this().Context, ClassDecl, new SourceLocation(ClassLoc), NameInfo, new QualType(), 
        /*TInfo=*/ (TypeSourceInfo /*P*/ )null, /*StorageClass=*/ StorageClass.SC_None, 
        /*isInline=*/ true, Constexpr, new SourceLocation());
    MoveAssignment.setAccess(AccessSpecifier.AS_public);
    MoveAssignment.setDefaulted();
    MoveAssignment.setImplicit();
    if ($this().getLangOpts().CUDA) {
      $this().inferCUDATargetForImplicitSpecialMember(ClassDecl, CXXSpecialMember.CXXMoveAssignment, 
          MoveAssignment, 
          /* ConstRHS */ false, 
          /* Diagnose */ false);
    }
    
    // Build an exception specification pointing back at this member.
    FunctionProtoType.ExtProtoInfo EPI = getImplicitMethodEPI(/*Deref*/$this(), MoveAssignment);
    MoveAssignment.setType($this().Context.getFunctionType(new QualType(RetType), new ArrayRef<QualType>(ArgType, false), EPI));
    
    // Add the parameter to the operator.
    ParmVarDecl /*P*/ FromParam = ParmVarDecl.Create($this().Context, MoveAssignment, 
        new SourceLocation(ClassLoc), new SourceLocation(ClassLoc), 
        /*Id=*/ (IdentifierInfo /*P*/ )null, new QualType(ArgType), 
        /*TInfo=*/ (TypeSourceInfo /*P*/ )null, StorageClass.SC_None, 
        (Expr /*P*/ )null);
    MoveAssignment.setParams(new ArrayRef<ParmVarDecl /*P*/ >(FromParam, true));
    
    MoveAssignment.setTrivial(ClassDecl.needsOverloadResolutionForMoveAssignment() ? $this().SpecialMemberIsTrivial(MoveAssignment, CXXSpecialMember.CXXMoveAssignment) : ClassDecl.hasTrivialMoveAssignment());
    
    // Note that we have added this copy-assignment operator.
    ++ASTContext.NumImplicitMoveAssignmentOperatorsDeclared;
    
    Scope /*P*/ S = $this().getScopeForContext(ClassDecl);
    $this().CheckImplicitSpecialMemberDeclaration(S, MoveAssignment);
    if ($this().ShouldDeleteSpecialMember(MoveAssignment, CXXSpecialMember.CXXMoveAssignment)) {
      ClassDecl.setImplicitMoveAssignmentIsDeleted();
      $this().SetDeclDeleted(MoveAssignment, new SourceLocation(ClassLoc));
    }
    if ((S != null)) {
      $this().PushOnScopeChains(MoveAssignment, S, false);
    }
    ClassDecl.addDecl(MoveAssignment);
    
    return MoveAssignment;
  } finally {
    if (DSM != null) { DSM.$destroy(); }
  }
}


/// \brief Defines an implicitly-declared move assignment operator.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DefineImplicitMoveAssignment">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 10700,
 FQN="clang::Sema::DefineImplicitMoveAssignment", NM="_ZN5clang4Sema28DefineImplicitMoveAssignmentENS_14SourceLocationEPNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema28DefineImplicitMoveAssignmentENS_14SourceLocationEPNS_13CXXMethodDeclE")
//</editor-fold>
public final void DefineImplicitMoveAssignment(SourceLocation CurrentLocation, 
                            CXXMethodDecl /*P*/ MoveAssignOperator) {
  SynthesizedFunctionScope Scope = null;
  RefBuilder OtherRef = null;
  MoveCastBuilder MoveOther = null;
  ThisBuilder This = null;
  try {
    assert ((MoveAssignOperator.isDefaulted() && MoveAssignOperator.isOverloadedOperator() && MoveAssignOperator.getOverloadedOperator() == OverloadedOperatorKind.OO_Equal && !MoveAssignOperator.doesThisDeclarationHaveABody() && !MoveAssignOperator.isDeleted())) : "DefineImplicitMoveAssignment called for wrong function";
    
    CXXRecordDecl /*P*/ ClassDecl = MoveAssignOperator.getParent();
    if (ClassDecl.isInvalidDecl() || MoveAssignOperator.isInvalidDecl()) {
      MoveAssignOperator.setInvalidDecl();
      return;
    }
    
    MoveAssignOperator.markUsed($this().Context);
    
    Scope/*J*/= new SynthesizedFunctionScope(/*Deref*/$this(), MoveAssignOperator);
    DiagnosticErrorTrap Trap/*J*/= new DiagnosticErrorTrap($this().Diags);
    
    // C++0x [class.copy]p28:
    //   The implicitly-defined or move assignment operator for a non-union class
    //   X performs memberwise move assignment of its subobjects. The direct base
    //   classes of X are assigned first, in the order of their declaration in the
    //   base-specifier-list, and then the immediate non-static data members of X
    //   are assigned, in the order in which they were declared in the class
    //   definition.
    
    // Issue a warning if our implicit move assignment operator will move
    // from a virtual base more than once.
    checkMoveAssignmentForRepeatedMove(/*Deref*/$this(), ClassDecl, new SourceLocation(CurrentLocation));
    
    // The statements that form the synthesized function body.
    SmallVector<Stmt /*P*/ > Statements/*J*/= new SmallVector<Stmt /*P*/ >(8, (Stmt /*P*/ )null);
    
    // The parameter for the "other" object, which we are move from.
    ParmVarDecl /*P*/ Other = MoveAssignOperator.getParamDecl(0);
    QualType OtherRefType = Other.getType().$arrow().getAs(RValueReferenceType.class).getPointeeType();
    assert (!OtherRefType.getQualifiers().$bool()) : "Bad argument type of defaulted move assignment";
    
    // Our location for everything implicitly-generated.
    SourceLocation Loc = MoveAssignOperator.getLocEnd().isValid() ? MoveAssignOperator.getLocEnd() : MoveAssignOperator.getLocation();
    
    // Builds a reference to the "other" object.
    OtherRef/*J*/= new RefBuilder(Other, new QualType(OtherRefType));
    // Cast to rvalue.
    MoveOther/*J*/= new MoveCastBuilder(OtherRef);
    
    // Builds the "this" pointer.
    This/*J*/= new ThisBuilder();
    
    // Assign base classes.
    boolean Invalid = false;
    for (final CXXBaseSpecifier /*&*/ Base : ClassDecl.bases()) {
      CastBuilder From = null;
      DerefBuilder DerefThis = null;
      CastBuilder To = null;
      try {
        // C++11 [class.copy]p28:
        //   It is unspecified whether subobjects representing virtual base classes
        //   are assigned more than once by the implicitly-defined copy assignment
        //   operator.
        // FIXME: Do not assign to a vbase that will be assigned by some other base
        // class. For a move-assignment, this can result in the vbase being moved
        // multiple times.
        
        // Form the assignment:
        //   static_cast<Base*>(this)->Base::operator=(static_cast<Base&&>(other));
        QualType BaseType = Base.getType().getUnqualifiedType();
        if (!BaseType.$arrow().isRecordType()) {
          Invalid = true;
          continue;
        }
        
        SmallVector<CXXBaseSpecifier /*P*/> BasePath/*J*/= new SmallVector<CXXBaseSpecifier /*P*/>(4, null);
        BasePath.push_back($AddrOf(Base));
        
        // Construct the "from" expression, which is an implicit cast to the
        // appropriately-qualified base type.
        From/*J*/= new CastBuilder(OtherRef, new QualType(BaseType), ExprValueKind.VK_XValue, BasePath);
        
        // Dereference "this".
        DerefThis/*J*/= new DerefBuilder(This);
        
        // Implicitly cast "this" to the appropriately-qualified base type.
        To/*J*/= new CastBuilder(DerefThis, 
            $this().Context.getCVRQualifiedType(new QualType(BaseType), MoveAssignOperator.getTypeQualifiers()), 
            ExprValueKind.VK_LValue, BasePath);
        
        // Build the move.
        ActionResultTTrue<Stmt /*P*/ > Move = buildSingleCopyAssign(/*Deref*/$this(), new SourceLocation(Loc), new QualType(BaseType), 
            To, From, 
            /*CopyingBaseSubobject=*/ true, 
            /*Copying=*/ false);
        if (Move.isInvalid()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(CurrentLocation), diag.note_member_synthesized_at)), 
                    CXXSpecialMember.CXXMoveAssignment), $this().Context.getTagDeclType(ClassDecl)));
            MoveAssignOperator.setInvalidDecl();
            return;
          } finally {
            $c$.$destroy();
          }
        }
        
        // Success! Record the move.
        Statements.push_back(Move.getAs(Expr.class));
      } finally {
        if (To != null) { To.$destroy(); }
        if (DerefThis != null) { DerefThis.$destroy(); }
        if (From != null) { From.$destroy(); }
      }
    }
    
    // Assign non-static members.
    for (FieldDecl /*P*/ Field : ClassDecl.fields()) {
      LookupResult MemberLookup = null;
      MemberBuilder From = null;
      MemberBuilder To = null;
      try {
        // FIXME: We should form some kind of AST representation for the implied
        // memcpy in a union copy operation.
        if (Field.isUnnamedBitfield() || Field.getParent().isUnion()) {
          continue;
        }
        if (Field.isInvalidDecl()) {
          Invalid = true;
          continue;
        }
        
        // Check for members of reference type; we can't move those.
        if (Field.getType().$arrow().isReferenceType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ClassDecl.getLocation(), diag.err_uninitialized_member_for_assign)), 
                        $this().Context.getTagDeclType(ClassDecl)), 0), Field.getDeclName()));
            $c$.clean($c$.track($this().Diag(Field.getLocation(), diag.note_declared_at)));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(CurrentLocation), diag.note_member_synthesized_at)), 
                    CXXSpecialMember.CXXMoveAssignment), $this().Context.getTagDeclType(ClassDecl)));
            Invalid = true;
            continue;
          } finally {
            $c$.$destroy();
          }
        }
        
        // Check for members of const-qualified, non-class type.
        QualType BaseType = $this().Context.getBaseElementType(Field.getType());
        if (!(BaseType.$arrow().getAs$RecordType() != null) && BaseType.isConstQualified()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ClassDecl.getLocation(), diag.err_uninitialized_member_for_assign)), 
                        $this().Context.getTagDeclType(ClassDecl)), 1), Field.getDeclName()));
            $c$.clean($c$.track($this().Diag(Field.getLocation(), diag.note_declared_at)));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(CurrentLocation), diag.note_member_synthesized_at)), 
                    CXXSpecialMember.CXXMoveAssignment), $this().Context.getTagDeclType(ClassDecl)));
            Invalid = true;
            continue;
          } finally {
            $c$.$destroy();
          }
        }
        
        // Suppress assigning zero-width bitfields.
        if (Field.isBitField() && Field.getBitWidthValue($this().Context) == 0) {
          continue;
        }
        
        QualType FieldType = Field.getType().getNonReferenceType();
        if (FieldType.$arrow().isIncompleteArrayType()) {
          assert (ClassDecl.hasFlexibleArrayMember()) : "Incomplete array type is not valid";
          continue;
        }
        
        // Build references to the field in the object we're copying from and to.
        MemberLookup/*J*/= new LookupResult(/*Deref*/$this(), Field.getDeclName(), new SourceLocation(Loc), 
            LookupNameKind.LookupMemberName);
        MemberLookup.addDecl(Field);
        MemberLookup.resolveKind();
        From/*J*/= new MemberBuilder(MoveOther, new QualType(OtherRefType), 
            /*IsArrow=*/ false, MemberLookup);
        To/*J*/= new MemberBuilder(This, $this().getCurrentThisType(), 
            /*IsArrow=*/ true, MemberLookup);
        assert (!From.build(/*Deref*/$this(), new SourceLocation(Loc)).isLValue()) : "Member reference with rvalue base must be rvalue except for reference members, which aren't allowed for move assignment.";
        
        // Build the move of this field.
        ActionResultTTrue<Stmt /*P*/ > Move = buildSingleCopyAssign(/*Deref*/$this(), new SourceLocation(Loc), new QualType(FieldType), 
            To, From, 
            /*CopyingBaseSubobject=*/ false, 
            /*Copying=*/ false);
        if (Move.isInvalid()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(CurrentLocation), diag.note_member_synthesized_at)), 
                    CXXSpecialMember.CXXMoveAssignment), $this().Context.getTagDeclType(ClassDecl)));
            MoveAssignOperator.setInvalidDecl();
            return;
          } finally {
            $c$.$destroy();
          }
        }
        
        // Success! Record the copy.
        Statements.push_back(Move.getAs(Stmt.class));
      } finally {
        if (To != null) { To.$destroy(); }
        if (From != null) { From.$destroy(); }
        if (MemberLookup != null) { MemberLookup.$destroy(); }
      }
    }
    if (!Invalid) {
      // Add a "return *this;"
      ActionResultTTrue<Expr /*P*/ > ThisObj = $this().CreateBuiltinUnaryOp(new SourceLocation(Loc), UnaryOperatorKind.UO_Deref, This.build(/*Deref*/$this(), new SourceLocation(Loc)));
      
      ActionResultTTrue<Stmt /*P*/ > Return = $this().BuildReturnStmt(new SourceLocation(Loc), create_type$ptr(ThisObj.get()));
      if (Return.isInvalid()) {
        Invalid = true;
      } else {
        Statements.push_back(Return.getAs(Stmt.class));
        if (Trap.hasErrorOccurred()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(CurrentLocation), diag.note_member_synthesized_at)), 
                    CXXSpecialMember.CXXMoveAssignment), $this().Context.getTagDeclType(ClassDecl)));
            Invalid = true;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    // The exception specification is needed because we are defining the
    // function.
    $this().ResolveExceptionSpec(new SourceLocation(CurrentLocation), 
        MoveAssignOperator.getType().$arrow().castAs(FunctionProtoType.class));
    if (Invalid) {
      MoveAssignOperator.setInvalidDecl();
      return;
    }
    
    ActionResultTTrue<Stmt /*P*/ > Body/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
    {
      CompoundScopeRAII CompoundScope = null;
      try {
        CompoundScope/*J*/= new CompoundScopeRAII(/*Deref*/$this());
        Body.$assignMove($this().ActOnCompoundStmt(new SourceLocation(Loc), new SourceLocation(Loc), new ArrayRef<Stmt /*P*/ >(Statements, true), 
                /*isStmtExpr=*/ false));
        assert (!Body.isInvalid()) : "Compound statement creation cannot fail";
      } finally {
        if (CompoundScope != null) { CompoundScope.$destroy(); }
      }
    }
    MoveAssignOperator.setBody(Body.getAs(Stmt.class));
    {
      
      ASTMutationListener /*P*/ L = $this().getASTMutationListener();
      if ((L != null)) {
        L.CompletedImplicitDefinition(MoveAssignOperator);
      }
    }
  } finally {
    if (This != null) { This.$destroy(); }
    if (MoveOther != null) { MoveOther.$destroy(); }
    if (OtherRef != null) { OtherRef.$destroy(); }
    if (Scope != null) { Scope.$destroy(); }
  }
}


/// \brief Check a completed declaration of an implicit special member.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckImplicitSpecialMemberDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9115,
 FQN="clang::Sema::CheckImplicitSpecialMemberDeclaration", NM="_ZN5clang4Sema37CheckImplicitSpecialMemberDeclarationEPNS_5ScopeEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema37CheckImplicitSpecialMemberDeclarationEPNS_5ScopeEPNS_12FunctionDeclE")
//</editor-fold>
public final void CheckImplicitSpecialMemberDeclaration(Scope /*P*/ S, FunctionDecl /*P*/ FD) {
  LookupResult R = null;
  try {
    // Look up any existing declarations, but don't trigger declaration of all
    // implicit special members with this name.
    DeclarationName Name = FD.getDeclName();
    R/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(Name), new SourceLocation(), LookupNameKind.LookupOrdinaryName, 
        RedeclarationKind.ForRedeclaration);
    for (NamedDecl /*P*/ D : FD.getParent().lookup(new DeclarationName(Name)))  {
      {
        NamedDecl /*P*/ Acceptable = R.getAcceptableDecl(D);
        if ((Acceptable != null)) {
          R.addDecl(Acceptable);
        }
      }
    }
    R.resolveKind();
    R.suppressDiagnostics();
    
    $this().CheckFunctionDeclaration(S, FD, R, /*IsExplicitSpecialization*/ false);
  } finally {
    if (R != null) { R.$destroy(); }
  }
}


/// \brief Determine whether the given function is an implicitly-deleted
/// special member function.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isImplicitlyDeleted">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 11274,
 FQN="clang::Sema::isImplicitlyDeleted", NM="_ZN5clang4Sema19isImplicitlyDeletedEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema19isImplicitlyDeletedEPNS_12FunctionDeclE")
//</editor-fold>
public final boolean isImplicitlyDeleted(FunctionDecl /*P*/ FD) {
  return FD.isDeleted() && FD.isDefaulted() && isa_CXXMethodDecl(FD);
}


/// \brief Check whether 'this' shows up in the type of a static member
/// function after the (naturally empty) cv-qualifier-seq would be.
///
/// \returns true if an error occurred.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkThisInStaticMemberFunctionType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13732,
 FQN="clang::Sema::checkThisInStaticMemberFunctionType", NM="_ZN5clang4Sema35checkThisInStaticMemberFunctionTypeEPNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema35checkThisInStaticMemberFunctionTypeEPNS_13CXXMethodDeclE")
//</editor-fold>
public final boolean checkThisInStaticMemberFunctionType(CXXMethodDecl /*P*/ Method) {
  TypeSourceInfo /*P*/ TSInfo = Method.getTypeSourceInfo();
  if (!(TSInfo != null)) {
    return false;
  }
  
  TypeLoc TL = TSInfo.getTypeLoc();
  FunctionProtoTypeLoc ProtoTL = TL.getAs(FunctionProtoTypeLoc.class);
  if (!ProtoTL.$bool()) {
    return false;
  }
  
  // C++11 [expr.prim.general]p3:
  //   [The expression this] shall not appear before the optional 
  //   cv-qualifier-seq and it shall not appear within the declaration of a 
  //   static member function (although its type and value category are defined
  //   within a static member function as they are within a non-static member
  //   function). [ Note: this is because declaration matching does not occur
  //  until the complete declarator is known. - end note ]
  /*const*/ FunctionProtoType /*P*/ Proto = ProtoTL.getTypePtr();
  FindCXXThisExpr Finder/*J*/= new FindCXXThisExpr(/*Deref*/$this());
  
  // If the return type came after the cv-qualifier-seq, check it now.
  if (Proto.hasTrailingReturn()
     && !Finder.TraverseTypeLoc(ProtoTL.getReturnLoc())) {
    return true;
  }
  
  // Check the exception specification.
  if ($this().checkThisInStaticMemberFunctionExceptionSpec(Method)) {
    return true;
  }
  
  return $this().checkThisInStaticMemberFunctionAttributes(Method);
}


/// \brief Whether this' shows up in the exception specification of a static
/// member function.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkThisInStaticMemberFunctionExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13764,
 FQN="clang::Sema::checkThisInStaticMemberFunctionExceptionSpec", NM="_ZN5clang4Sema44checkThisInStaticMemberFunctionExceptionSpecEPNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema44checkThisInStaticMemberFunctionExceptionSpecEPNS_13CXXMethodDeclE")
//</editor-fold>
public final boolean checkThisInStaticMemberFunctionExceptionSpec(CXXMethodDecl /*P*/ Method) {
  TypeSourceInfo /*P*/ TSInfo = Method.getTypeSourceInfo();
  if (!(TSInfo != null)) {
    return false;
  }
  
  TypeLoc TL = TSInfo.getTypeLoc();
  FunctionProtoTypeLoc ProtoTL = TL.getAs(FunctionProtoTypeLoc.class);
  if (!ProtoTL.$bool()) {
    return false;
  }
  
  /*const*/ FunctionProtoType /*P*/ Proto = ProtoTL.getTypePtr();
  FindCXXThisExpr Finder/*J*/= new FindCXXThisExpr(/*Deref*/$this());
  switch (Proto.getExceptionSpecType()) {
   case EST_Unparsed:
   case EST_Uninstantiated:
   case EST_Unevaluated:
   case EST_BasicNoexcept:
   case EST_DynamicNone:
   case EST_MSAny:
   case EST_None:
    break;
   case EST_ComputedNoexcept:
    if (!Finder.TraverseStmt(Proto.getNoexceptExpr())) {
      return true;
    }
   case EST_Dynamic:
    for (final /*const*/ QualType /*&*/ E : Proto.exceptions()) {
      if (!Finder.TraverseType(new QualType(E))) {
        return true;
      }
    }
    break;
  }
  
  return false;
}


/// \brief Check whether 'this' shows up in the attributes of the given
/// static member function.
///
/// \returns true if an error occurred.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkThisInStaticMemberFunctionAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13802,
 FQN="clang::Sema::checkThisInStaticMemberFunctionAttributes", NM="_ZN5clang4Sema41checkThisInStaticMemberFunctionAttributesEPNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema41checkThisInStaticMemberFunctionAttributesEPNS_13CXXMethodDeclE")
//</editor-fold>
public final boolean checkThisInStaticMemberFunctionAttributes(CXXMethodDecl /*P*/ Method) {
  FindCXXThisExpr Finder/*J*/= new FindCXXThisExpr(/*Deref*/$this());
  
  // Check attributes.
  for (/*const*/ Attr /*P*/ A : Method.attrs()) {
    // FIXME: This should be emitted by tblgen.
    Expr /*P*/ Arg = null;
    ArrayRef<Expr /*P*/ > Args/*J*/= new ArrayRef<Expr /*P*/ >(true);
    {
      /*const*/ GuardedByAttr /*P*/ G = dyn_cast_GuardedByAttr(A);
      if ((G != null)) {
        Arg = G.getArg();
      } else {
        /*const*/ PtGuardedByAttr /*P*/ G$1 = dyn_cast_PtGuardedByAttr(A);
        if ((G$1 != null)) {
          Arg = G$1.getArg();
        } else {
          /*const*/ AcquiredAfterAttr /*P*/ AA = dyn_cast_AcquiredAfterAttr(A);
          if ((AA != null)) {
            Args.$assignMove(llvm.makeArrayRef(AA.args_begin(), AA.args_size()));
          } else {
            /*const*/ AcquiredBeforeAttr /*P*/ AB = dyn_cast_AcquiredBeforeAttr(A);
            if ((AB != null)) {
              Args.$assignMove(llvm.makeArrayRef(AB.args_begin(), AB.args_size()));
            } else {
              /*const*/ ExclusiveTrylockFunctionAttr /*P*/ ETLF = dyn_cast_ExclusiveTrylockFunctionAttr(A);
              if ((ETLF != null)) {
                Arg = ETLF.getSuccessValue();
                Args.$assignMove(llvm.makeArrayRef(ETLF.args_begin(), ETLF.args_size()));
              } else {
                /*const*/ SharedTrylockFunctionAttr /*P*/ STLF = dyn_cast_SharedTrylockFunctionAttr(A);
                if ((STLF != null)) {
                  Arg = STLF.getSuccessValue();
                  Args.$assignMove(llvm.makeArrayRef(STLF.args_begin(), STLF.args_size()));
                } else {
                  /*const*/ LockReturnedAttr /*P*/ LR = dyn_cast_LockReturnedAttr(A);
                  if ((LR != null)) {
                    Arg = LR.getArg();
                  } else {
                    /*const*/ LocksExcludedAttr /*P*/ LE = dyn_cast_LocksExcludedAttr(A);
                    if ((LE != null)) {
                      Args.$assignMove(llvm.makeArrayRef(LE.args_begin(), LE.args_size()));
                    } else {
                      /*const*/ RequiresCapabilityAttr /*P*/ RC = dyn_cast_RequiresCapabilityAttr(A);
                      if ((RC != null)) {
                        Args.$assignMove(llvm.makeArrayRef(RC.args_begin(), RC.args_size()));
                      } else {
                        /*const*/ AcquireCapabilityAttr /*P*/ AC = dyn_cast_AcquireCapabilityAttr(A);
                        if ((AC != null)) {
                          Args.$assignMove(llvm.makeArrayRef(AC.args_begin(), AC.args_size()));
                        } else {
                          /*const*/ TryAcquireCapabilityAttr /*P*/ AC$1 = dyn_cast_TryAcquireCapabilityAttr(A);
                          if ((AC$1 != null)) {
                            Args.$assignMove(llvm.makeArrayRef(AC$1.args_begin(), AC$1.args_size()));
                          } else {
                            /*const*/ ReleaseCapabilityAttr /*P*/ RC$1 = dyn_cast_ReleaseCapabilityAttr(A);
                            if ((RC$1 != null)) {
                              Args.$assignMove(llvm.makeArrayRef(RC$1.args_begin(), RC$1.args_size()));
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
    if ((Arg != null) && !Finder.TraverseStmt(Arg)) {
      return true;
    }
    
    for (/*uint*/int I = 0, N = Args.size(); I != N; ++I) {
      if (!Finder.TraverseStmt(Args.$at(I))) {
        return true;
      }
    }
  }
  
  return false;
}


/// \brief Given a constructor and the set of arguments provided for the
/// constructor, convert the arguments and add any required default arguments
/// to form a proper call to this constructor.
///
/// \returns true if an error occurred, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CompleteConstructorCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 11612,
 FQN="clang::Sema::CompleteConstructorCall", NM="_ZN5clang4Sema23CompleteConstructorCallEPNS_18CXXConstructorDeclEN4llvm15MutableArrayRefIPNS_4ExprEEENS_14SourceLocationERNS3_15SmallVectorImplIS6_EEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema23CompleteConstructorCallEPNS_18CXXConstructorDeclEN4llvm15MutableArrayRefIPNS_4ExprEEENS_14SourceLocationERNS3_15SmallVectorImplIS6_EEbb")
//</editor-fold>
public final boolean CompleteConstructorCall(CXXConstructorDecl /*P*/ Constructor, 
                       MutableArrayRef<Expr /*P*/ > ArgsPtr, 
                       SourceLocation Loc, 
                       final SmallVectorImpl<Expr /*P*/ > /*&*/ ConvertedArgs) {
  return CompleteConstructorCall(Constructor, 
                       ArgsPtr, 
                       Loc, 
                       ConvertedArgs, 
                       false, 
                       false);
}
public final boolean CompleteConstructorCall(CXXConstructorDecl /*P*/ Constructor, 
                       MutableArrayRef<Expr /*P*/ > ArgsPtr, 
                       SourceLocation Loc, 
                       final SmallVectorImpl<Expr /*P*/ > /*&*/ ConvertedArgs, 
                       boolean AllowExplicit/*= false*/) {
  return CompleteConstructorCall(Constructor, 
                       ArgsPtr, 
                       Loc, 
                       ConvertedArgs, 
                       AllowExplicit, 
                       false);
}
public final boolean CompleteConstructorCall(CXXConstructorDecl /*P*/ Constructor, 
                       MutableArrayRef<Expr /*P*/ > ArgsPtr, 
                       SourceLocation Loc, 
                       final SmallVectorImpl<Expr /*P*/ > /*&*/ ConvertedArgs, 
                       boolean AllowExplicit/*= false*/, 
                       boolean IsListInitialization/*= false*/) {
  // FIXME: This duplicates a lot of code from Sema::ConvertArgumentsForCall.
  /*uint*/int NumArgs = ArgsPtr.size();
  type$ptr<Expr /*P*/ /*P*/> Args = $tryClone(ArgsPtr.data());
  
  /*const*/ FunctionProtoType /*P*/ Proto = Constructor.getType().$arrow().getAs(FunctionProtoType.class);
  assert ((Proto != null)) : "Constructor without a prototype?";
  /*uint*/int NumParams = Proto.getNumParams();
  
  // If too few arguments are available, we'll fill in the rest with defaults.
  if ($less_uint(NumArgs, NumParams)) {
    ConvertedArgs.reserve(NumParams);
  } else {
    ConvertedArgs.reserve(NumArgs);
  }
  
  VariadicCallType CallType = Proto.isVariadic() ? VariadicCallType.VariadicConstructor : VariadicCallType.VariadicDoesNotApply;
  SmallVector<Expr /*P*/ > AllArgs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  boolean Invalid = $this().GatherArgumentsForCall(new SourceLocation(Loc), Constructor, 
      Proto, 0, 
      llvm.makeArrayRef(Args, NumArgs), 
      AllArgs, 
      CallType, AllowExplicit, 
      IsListInitialization);
  ConvertedArgs.append_T(AllArgs.begin(), AllArgs.end());
  
  $this().DiagnoseSentinelCalls(Constructor, new SourceLocation(Loc), new ArrayRef<Expr /*P*/ >(AllArgs, true));
  
  $this().CheckConstructorCall(Constructor, 
      new ArrayRef</*const*/ Expr /*P*/ >(JD$Convertible.INSTANCE, llvm.makeArrayRef(AllArgs.data(), AllArgs.size()), true), 
      Proto, new SourceLocation(Loc));
  
  return Invalid;
}


/// ActOnCXXEnterDeclInitializer - Invoked when we are about to parse an
/// initializer for the declaration 'Dcl'.
/// After this method is called, according to [C++ 3.4.1p13], if 'Dcl' is a
/// static data member of class X, names should be looked up in the scope of
/// class X.

/// ActOnCXXEnterDeclInitializer - Invoked when we are about to parse
/// an initializer for the out-of-line declaration 'Dcl'.  The scope
/// is a fresh scope pushed for just this purpose.
///
/// After this method is called, according to [C++ 3.4.1p13], if 'Dcl' is a
/// static data member of class X, names should be looked up in the scope of
/// class X.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXEnterDeclInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13316,
 FQN="clang::Sema::ActOnCXXEnterDeclInitializer", NM="_ZN5clang4Sema28ActOnCXXEnterDeclInitializerEPNS_5ScopeEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema28ActOnCXXEnterDeclInitializerEPNS_5ScopeEPNS_4DeclE")
//</editor-fold>
public final void ActOnCXXEnterDeclInitializer(Scope /*P*/ S, Decl /*P*/ D) {
  // If there is no declaration, there was an error parsing it.
  if (!(D != null) || D.isInvalidDecl()) {
    return;
  }
  
  // We will always have a nested name specifier here, but this declaration
  // might not be out of line if the specifier names the current namespace:
  //   extern int n;
  //   int ::n = 0;
  if (D.isOutOfLine()) {
    $this().EnterDeclaratorContext(S, D.getDeclContext());
  }
  
  // If we are parsing the initializer for a static data member, push a
  // new expression evaluation context that is associated with this static
  // data member.
  if (isStaticDataMember(D)) {
    $this().PushExpressionEvaluationContext(ExpressionEvaluationContext.PotentiallyEvaluated, D);
  }
}


/// ActOnCXXExitDeclInitializer - Invoked after we are finished parsing an
/// initializer for the declaration 'Dcl'.

/// ActOnCXXExitDeclInitializer - Invoked after we are finished parsing an
/// initializer for the out-of-line declaration 'D'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXExitDeclInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13337,
 FQN="clang::Sema::ActOnCXXExitDeclInitializer", NM="_ZN5clang4Sema27ActOnCXXExitDeclInitializerEPNS_5ScopeEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema27ActOnCXXExitDeclInitializerEPNS_5ScopeEPNS_4DeclE")
//</editor-fold>
public final void ActOnCXXExitDeclInitializer(Scope /*P*/ S, Decl /*P*/ D) {
  // If there is no declaration, there was an error parsing it.
  if (!(D != null) || D.isInvalidDecl()) {
    return;
  }
  if (isStaticDataMember(D)) {
    $this().PopExpressionEvaluationContext();
  }
  if (D.isOutOfLine()) {
    $this().ExitDeclaratorContext(S);
  }
}


/// \brief Define the "body" of the conversion from a lambda object to a
/// function pointer.
///
/// This routine doesn't actually define a sensible body; rather, it fills
/// in the initialization expression needed to copy the lambda object into
/// the block, and IR generation actually generates the real body of the
/// block pointer conversion.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DefineImplicitLambdaToFunctionPointerConversion">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 11278,
 FQN="clang::Sema::DefineImplicitLambdaToFunctionPointerConversion", NM="_ZN5clang4Sema47DefineImplicitLambdaToFunctionPointerConversionENS_14SourceLocationEPNS_17CXXConversionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema47DefineImplicitLambdaToFunctionPointerConversionENS_14SourceLocationEPNS_17CXXConversionDeclE")
//</editor-fold>
public final void DefineImplicitLambdaToFunctionPointerConversion(SourceLocation CurrentLocation, 
                                               CXXConversionDecl /*P*/ Conv) {
  SynthesizedFunctionScope Scope = null;
  try {
    CXXRecordDecl /*P*/ Lambda = Conv.getParent();
    CXXMethodDecl /*P*/ CallOp = Lambda.getLambdaCallOperator();
    // If we are defining a specialization of a conversion to function-ptr
    // cache the deduced template arguments for this specialization
    // so that we can use them to retrieve the corresponding call-operator
    // and static-invoker. 
    /*const*/ TemplateArgumentList /*P*/ DeducedTemplateArgs = null;
    
    // Retrieve the corresponding call-operator specialization.
    if (Lambda.isGenericLambda()) {
      assert (Conv.isFunctionTemplateSpecialization());
      FunctionTemplateDecl /*P*/ CallOpTemplate = CallOp.getDescribedFunctionTemplate();
      DeducedTemplateArgs = Conv.getTemplateSpecializationArgs();
      final type$ref<type$ptr<FunctionTemplateSpecializationInfo /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
      FunctionDecl /*P*/ CallOpSpec = CallOpTemplate.findSpecialization(DeducedTemplateArgs.asArray(), 
          InsertPos);
      assert ((CallOpSpec != null)) : "Conversion operator must have a corresponding call operator";
      CallOp = cast_CXXMethodDecl(CallOpSpec);
    }
    // Mark the call operator referenced (and add to pending instantiations
    // if necessary).
    // For both the conversion and static-invoker template specializations
    // we construct their body's in this function, so no need to add them
    // to the PendingInstantiations.
    $this().MarkFunctionReferenced(new SourceLocation(CurrentLocation), CallOp);
    
    Scope/*J*/= new SynthesizedFunctionScope(/*Deref*/$this(), Conv);
    DiagnosticErrorTrap Trap/*J*/= new DiagnosticErrorTrap($this().Diags);
    
    // Retrieve the static invoker...
    CXXMethodDecl /*P*/ Invoker = Lambda.getLambdaStaticInvoker();
    // ... and get the corresponding specialization for a generic lambda.
    if (Lambda.isGenericLambda()) {
      assert ((DeducedTemplateArgs != null)) : "Must have deduced template arguments from Conversion Operator";
      FunctionTemplateDecl /*P*/ InvokeTemplate = Invoker.getDescribedFunctionTemplate();
      final type$ref<type$ptr<FunctionTemplateSpecializationInfo /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
      FunctionDecl /*P*/ InvokeSpec = InvokeTemplate.findSpecialization(DeducedTemplateArgs.asArray(), 
          InsertPos);
      assert ((InvokeSpec != null)) : "Must have a corresponding static invoker specialization";
      Invoker = cast_CXXMethodDecl(InvokeSpec);
    }
    // Construct the body of the conversion function { return __invoke; }.
    Expr /*P*/ FunctionRef = $this().BuildDeclRefExpr(Invoker, Invoker.getType(), 
        ExprValueKind.VK_LValue, Conv.getLocation()).get();
    assert ((FunctionRef != null)) : "Can't refer to __invoke function?";
    Stmt /*P*/ Return = $this().BuildReturnStmt(Conv.getLocation(), create_type$ptr(FunctionRef)).get();
    Conv.setBody(/*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
            return new CompoundStmt($this().Context, new ArrayRef<Stmt /*P*/ >(Return, true), 
                    Conv.getLocation(), 
                    Conv.getLocation());
         }));
    
    Conv.markUsed($this().Context);
    Conv.setReferenced();
    
    // Fill in the __invoke function with a dummy implementation. IR generation
    // will fill in the actual details.
    Invoker.markUsed($this().Context);
    Invoker.setReferenced();
    Invoker.setBody(/*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
            return new CompoundStmt(Conv.getLocation());
         }));
    {
      
      ASTMutationListener /*P*/ L = $this().getASTMutationListener();
      if ((L != null)) {
        L.CompletedImplicitDefinition(Conv);
        L.CompletedImplicitDefinition(Invoker);
      }
    }
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}


/// \brief Define the "body" of the conversion from a lambda object to a
/// block pointer.
///
/// This routine doesn't actually define a sensible body; rather, it fills
/// in the initialization expression needed to copy the lambda object into
/// the block, and IR generation actually generates the real body of the
/// block pointer conversion.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DefineImplicitLambdaToBlockPointerConversion">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 11355,
 FQN="clang::Sema::DefineImplicitLambdaToBlockPointerConversion", NM="_ZN5clang4Sema44DefineImplicitLambdaToBlockPointerConversionENS_14SourceLocationEPNS_17CXXConversionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema44DefineImplicitLambdaToBlockPointerConversionENS_14SourceLocationEPNS_17CXXConversionDeclE")
//</editor-fold>
public final void DefineImplicitLambdaToBlockPointerConversion(SourceLocation CurrentLocation, 
                                            CXXConversionDecl /*P*/ Conv) {
  SynthesizedFunctionScope Scope = null;
  try {
    assert (!Conv.getParent().isGenericLambda());
    
    Conv.markUsed($this().Context);
    
    Scope/*J*/= new SynthesizedFunctionScope(/*Deref*/$this(), Conv);
    DiagnosticErrorTrap Trap/*J*/= new DiagnosticErrorTrap($this().Diags);
    
    // Copy-initialize the lambda object as needed to capture it.
    Expr /*P*/ This = $this().ActOnCXXThis(new SourceLocation(CurrentLocation)).get();
    Expr /*P*/ DerefThis = $this().CreateBuiltinUnaryOp(new SourceLocation(CurrentLocation), UnaryOperatorKind.UO_Deref, This).get();
    
    ActionResultTTrue<Expr /*P*/ > BuildBlock = $this().BuildBlockForLambdaConversion(new SourceLocation(CurrentLocation), 
        Conv.getLocation(), 
        Conv, DerefThis);
    
    // If we're not under ARC, make sure we still get the _Block_copy/autorelease
    // behavior.  Note that only the general conversion function does this
    // (since it's unusable otherwise); in the case where we inline the
    // block literal, it has block literal lifetime semantics.
    if (!BuildBlock.isInvalid() && !$this().getLangOpts().ObjCAutoRefCount) {
      BuildBlock.$assign(ImplicitCastExpr.Create($this().Context, BuildBlock.get().getType(), 
              CastKind.CK_CopyAndAutoreleaseBlockObject, 
              BuildBlock.get(), (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, ExprValueKind.VK_RValue));
    }
    if (BuildBlock.isInvalid()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(CurrentLocation), diag.note_lambda_to_block_conv)));
        Conv.setInvalidDecl();
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Create the return statement that returns the block from the conversion
    // function.
    ActionResultTTrue<Stmt /*P*/ > Return = $this().BuildReturnStmt(Conv.getLocation(), create_type$ptr(BuildBlock.get()));
    if (Return.isInvalid()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(CurrentLocation), diag.note_lambda_to_block_conv)));
        Conv.setInvalidDecl();
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Set the body of the conversion function.
    Stmt /*P*/ ReturnS = Return.get();
    Conv.setBody(/*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
            return new CompoundStmt($this().Context, new ArrayRef<Stmt /*P*/ >(ReturnS, true), 
                    Conv.getLocation(), 
                    Conv.getLocation());
         }));
    {
      
      // We're done; notify the mutation listener, if any.
      ASTMutationListener /*P*/ L = $this().getASTMutationListener();
      if ((L != null)) {
        L.CompletedImplicitDefinition(Conv);
      }
    }
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}


//===--------------------------------------------------------------------===//
// C++ Declarations
//

/// ActOnStartLinkageSpecification - Parsed the beginning of a C++
/// linkage specification, including the language and (if present)
/// the '{'. ExternLoc is the location of the 'extern', Lang is the
/// language string literal. LBraceLoc, if valid, provides the location of
/// the '{' brace. Otherwise, this linkage specification does not
/// have any braces.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStartLinkageSpecification">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 12121,
 FQN="clang::Sema::ActOnStartLinkageSpecification", NM="_ZN5clang4Sema30ActOnStartLinkageSpecificationEPNS_5ScopeENS_14SourceLocationEPNS_4ExprES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema30ActOnStartLinkageSpecificationEPNS_5ScopeENS_14SourceLocationEPNS_4ExprES3_")
//</editor-fold>
public final Decl /*P*/ ActOnStartLinkageSpecification(Scope /*P*/ S, SourceLocation ExternLoc, 
                              Expr /*P*/ LangStr, 
                              SourceLocation LBraceLoc) {
  StringLiteral /*P*/ Lit = cast_StringLiteral(LangStr);
  if (!Lit.isAscii()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(LangStr.getExprLoc(), diag.err_language_linkage_spec_not_ascii)), 
          LangStr.getSourceRange()));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  
  StringRef Lang = Lit.getString();
  /*LinkageSpecDecl::LanguageIDs*//*uint*/int Language;
  if ($eq_StringRef(/*NO_COPY*/Lang, /*STRINGREF_STR*/"C")) {
    Language = LinkageSpecDecl.LanguageIDs.lang_c;
  } else if ($eq_StringRef(/*NO_COPY*/Lang, /*STRINGREF_STR*/"C++")) {
    Language = LinkageSpecDecl.LanguageIDs.lang_cxx;
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(LangStr.getExprLoc(), diag.err_language_linkage_spec_unknown)), 
          LangStr.getSourceRange()));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  
  // FIXME: Add all the various semantics of linkage specifications
  LinkageSpecDecl /*P*/ D = LinkageSpecDecl.Create($this().Context, $this().CurContext, new SourceLocation(ExternLoc), 
      LangStr.getExprLoc(), Language, 
      LBraceLoc.isValid());
  $this().CurContext.addDecl(D);
  $this().PushDeclContext(S, D);
  return D;
}


/// ActOnFinishLinkageSpecification - Complete the definition of
/// the C++ linkage specification LinkageSpec. If RBraceLoc is
/// valid, it's the position of the closing '}' brace in a linkage
/// specification that uses braces.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFinishLinkageSpecification">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 12157,
 FQN="clang::Sema::ActOnFinishLinkageSpecification", NM="_ZN5clang4Sema31ActOnFinishLinkageSpecificationEPNS_5ScopeEPNS_4DeclENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema31ActOnFinishLinkageSpecificationEPNS_5ScopeEPNS_4DeclENS_14SourceLocationE")
//</editor-fold>
public final Decl /*P*/ ActOnFinishLinkageSpecification(Scope /*P*/ S, 
                               Decl /*P*/ LinkageSpec, 
                               SourceLocation RBraceLoc) {
  if (RBraceLoc.isValid()) {
    LinkageSpecDecl /*P*/ LSDecl = cast_LinkageSpecDecl(LinkageSpec);
    LSDecl.setRBraceLoc(new SourceLocation(RBraceLoc));
  }
  $this().PopDeclContext();
  return LinkageSpec;
}


//===--------------------------------------------------------------------===//
// C++ Classes
//

/// isCurrentClassName - Determine whether the identifier II is the
/// name of the class type currently being defined. In the case of
/// nested classes, this will only return true if II is the name of
/// the innermost class.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isCurrentClassName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 1272,
 FQN="clang::Sema::isCurrentClassName", NM="_ZN5clang4Sema18isCurrentClassNameERKNS_14IdentifierInfoEPNS_5ScopeEPKNS_12CXXScopeSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema18isCurrentClassNameERKNS_14IdentifierInfoEPNS_5ScopeEPKNS_12CXXScopeSpecE")
//</editor-fold>
public final boolean isCurrentClassName(final /*const*/ IdentifierInfo /*&*/ II, Scope /*P*/ $Prm1) {
  return isCurrentClassName(II, $Prm1, 
                  (/*const*/ CXXScopeSpec /*P*/ )null);
}
public final boolean isCurrentClassName(final /*const*/ IdentifierInfo /*&*/ II, Scope /*P*/ $Prm1, 
                  /*const*/ CXXScopeSpec /*P*/ SS/*= null*/) {
  assert ($this().getLangOpts().CPlusPlus) : "No class names in C!";
  
  CXXRecordDecl /*P*/ CurDecl;
  if ((SS != null) && SS.isSet() && !SS.isInvalid()) {
    DeclContext /*P*/ DC = $this().computeDeclContext($Deref(SS), true);
    CurDecl = dyn_cast_or_null_CXXRecordDecl(DC);
  } else {
    CurDecl = dyn_cast_or_null_CXXRecordDecl($this().CurContext);
  }
  if ((CurDecl != null) && (CurDecl.getIdentifier() != null)) {
    return $AddrOf(II) == CurDecl.getIdentifier();
  }
  return false;
}


/// \brief Determine whether the identifier II is a typo for the name of
/// the class type currently being defined. If so, update it to the identifier
/// that should have been used.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isCurrentClassNameTypo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 1291,
 FQN="clang::Sema::isCurrentClassNameTypo", NM="_ZN5clang4Sema22isCurrentClassNameTypoERPNS_14IdentifierInfoEPKNS_12CXXScopeSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema22isCurrentClassNameTypoERPNS_14IdentifierInfoEPKNS_12CXXScopeSpecE")
//</editor-fold>
public final boolean isCurrentClassNameTypo(final type$ref<IdentifierInfo /*P*/ /*&*/> II, /*const*/ CXXScopeSpec /*P*/ SS) {
  assert ($this().getLangOpts().CPlusPlus) : "No class names in C!";
  if (!$this().getLangOpts().SpellChecking) {
    return false;
  }
  
  CXXRecordDecl /*P*/ CurDecl;
  if ((SS != null) && SS.isSet() && !SS.isInvalid()) {
    DeclContext /*P*/ DC = $this().computeDeclContext($Deref(SS), true);
    CurDecl = dyn_cast_or_null_CXXRecordDecl(DC);
  } else {
    CurDecl = dyn_cast_or_null_CXXRecordDecl($this().CurContext);
  }
  if ((CurDecl != null) && (CurDecl.getIdentifier() != null) && II.$deref() != CurDecl.getIdentifier()
     && $less_uint(3 * II.$deref().getName().edit_distance(CurDecl.getIdentifier().getName())
    , II.$deref().getLength())) {
    II.$set(CurDecl.getIdentifier());
    return true;
  }
  
  return false;
}


//===----------------------------------------------------------------------===//
// C++ class member Handling
//===----------------------------------------------------------------------===//

/// ActOnAccessSpecifier - Parsed an access specifier followed by a colon.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnAccessSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 1861,
 FQN="clang::Sema::ActOnAccessSpecifier", NM="_ZN5clang4Sema20ActOnAccessSpecifierENS_15AccessSpecifierENS_14SourceLocationES2_PNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema20ActOnAccessSpecifierENS_15AccessSpecifierENS_14SourceLocationES2_PNS_13AttributeListE")
//</editor-fold>
public final boolean ActOnAccessSpecifier(AccessSpecifier Access, 
                    SourceLocation ASLoc, 
                    SourceLocation ColonLoc) {
  return ActOnAccessSpecifier(Access, 
                    ASLoc, 
                    ColonLoc, 
                    (AttributeList /*P*/ )null);
}
public final boolean ActOnAccessSpecifier(AccessSpecifier Access, 
                    SourceLocation ASLoc, 
                    SourceLocation ColonLoc, 
                    AttributeList /*P*/ Attrs/*= null*/) {
  assert (Access != AccessSpecifier.AS_none) : "Invalid kind for syntactic access specifier!";
  AccessSpecDecl /*P*/ ASDecl = AccessSpecDecl.Create($this().Context, Access, $this().CurContext, 
      new SourceLocation(ASLoc), new SourceLocation(ColonLoc));
  $this().CurContext.addHiddenDecl(ASDecl);
  return $this().ProcessAccessDeclAttributeList(ASDecl, Attrs);
}


/// ActOnCXXMemberDeclarator - This is invoked when a C++ class member
/// declarator is parsed. 'AS' is the access specifier, 'BW' specifies the
/// bitfield width if there is one, 'InitExpr' specifies the initializer if
/// one has been parsed, and 'InitStyle' is set if an in-class initializer is
/// present (but parsing it has been deferred).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXMemberDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2004,
 FQN="clang::Sema::ActOnCXXMemberDeclarator", NM="_ZN5clang4Sema24ActOnCXXMemberDeclaratorEPNS_5ScopeENS_15AccessSpecifierERNS_10DeclaratorEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEEPNS_4ExprERKNS_14VirtSpecifiersENS_16InClassInitStyleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema24ActOnCXXMemberDeclaratorEPNS_5ScopeENS_15AccessSpecifierERNS_10DeclaratorEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEEPNS_4ExprERKNS_14VirtSpecifiersENS_16InClassInitStyleE")
//</editor-fold>
public final NamedDecl /*P*/ ActOnCXXMemberDeclarator(Scope /*P*/ S, AccessSpecifier AS, final Declarator /*&*/ D, 
                        MutableArrayRef<TemplateParameterList /*P*/ > TemplateParameterLists, 
                        Expr /*P*/ BW, final /*const*/ VirtSpecifiers /*&*/ VS, 
                        InClassInitStyle InitStyle) {
  final /*const*/ DeclSpec /*&*/ DS = D.getDeclSpec();
  DeclarationNameInfo NameInfo = $this().GetNameForDeclarator(D);
  DeclarationName Name = NameInfo.getName();
  SourceLocation Loc = NameInfo.getLoc();
  
  // For anonymous bitfields, the location should point to the type.
  if (Loc.isInvalid()) {
    Loc.$assignMove(D.getLocStart());
  }
  
  Expr /*P*/ BitWidth = ((/*static_cast*/Expr /*P*/ )(BW));
  assert (isa_CXXRecordDecl($this().CurContext));
  assert (!DS.isFriendSpecified());
  
  boolean isFunc = D.isDeclarationOfFunction();
  if (cast_CXXRecordDecl($this().CurContext).isInterface()) {
    // The Microsoft extension __interface only permits public member functions
    // and prohibits constructors, destructors, operators, non-public member
    // functions, static methods and data members.
    /*uint*/int InvalidDecl;
    boolean ShowDeclName = true;
    if (!isFunc) {
      InvalidDecl = (DS.getStorageClassSpec() == DeclSpec.SCS.SCS_typedef) ? 0 : 1;
    } else if (AS != AccessSpecifier.AS_public) {
      InvalidDecl = 2;
    } else if (DS.getStorageClassSpec() == DeclSpec.SCS.SCS_static) {
      InvalidDecl = 3;
    } else {
      switch (Name.getNameKind()) {
       case CXXConstructorName:
        InvalidDecl = 4;
        ShowDeclName = false;
        break;
       case CXXDestructorName:
        InvalidDecl = 5;
        ShowDeclName = false;
        break;
       case CXXOperatorName:
       case CXXConversionFunctionName:
        InvalidDecl = 6;
        break;
       default:
        InvalidDecl = 0;
        break;
      }
    }
    if ((InvalidDecl != 0)) {
      if (ShowDeclName) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_invalid_member_in_interface)), 
                  (InvalidDecl - 1)), Name));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_invalid_member_in_interface)), 
                  (InvalidDecl - 1)), /*KEEP_STR*/""));
        } finally {
          $c$.$destroy();
        }
      }
      return null;
    }
  }
  
  // C++ 9.2p6: A member shall not be declared to have automatic storage
  // duration (auto, register) or with the extern storage-class-specifier.
  // C++ 7.1.1p8: The mutable specifier can be applied only to names of class
  // data members and cannot be applied to names declared const or static,
  // and cannot be applied to reference members.
  switch (DS.getStorageClassSpec()) {
   case SCS_unspecified:
   case SCS_typedef:
   case SCS_static:
    break;
   case SCS_mutable:
    if (isFunc) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(DS.getStorageClassSpecLoc(), diag.err_mutable_function)));
        
        // FIXME: It would be nicer if the keyword was ignored only for this
        // declarator. Otherwise we could get follow-up errors.
        D.getMutableDeclSpec().ClearStorageClassSpecs();
      } finally {
        $c$.$destroy();
      }
    }
    break;
   default:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(DS.getStorageClassSpecLoc(), 
            diag.err_storageclass_invalid_for_member)));
        D.getMutableDeclSpec().ClearStorageClassSpecs();
        break;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  boolean isInstField = ((DS.getStorageClassSpec() == DeclSpec.SCS.SCS_unspecified
     || DS.getStorageClassSpec() == DeclSpec.SCS.SCS_mutable)
     && !isFunc);
  if (DS.isConstexprSpecified() && isInstField) {
    SemaDiagnosticBuilder B = null;
    try {
      B = $this().Diag(DS.getConstexprSpecLoc(), diag.err_invalid_constexpr_member);
      SourceLocation ConstexprLoc = DS.getConstexprSpecLoc();
      if (InitStyle == InClassInitStyle.ICIS_NoInit) {
        $out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R(B, 0), 0);
        if (((D.getDeclSpec().getTypeQualifiers() & DeclSpec.TQ.TQ_const.getValue()) != 0)) {
          $out_SemaDiagnosticBuilder$C_T$C$R(B, FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/ConstexprLoc)));
        } else {
          $out_SemaDiagnosticBuilder$C_T$C$R(B, FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/ConstexprLoc), new StringRef(/*KEEP_STR*/$const)));
          D.getMutableDeclSpec().ClearConstexprSpec();
          /*const*/char$ptr/*char P*/ PrevSpec = create_char$ptr();
          uint$ref DiagID = create_uint$ref();
          boolean Failed = D.getMutableDeclSpec().SetTypeQual(DeclSpec.TQ.TQ_const, new SourceLocation(ConstexprLoc), PrevSpec, DiagID, $this().getLangOpts());
          ///*J:(void)*/Failed;
          assert (!Failed) : "Making a constexpr member const shouldn't fail";
        }
      } else {
        $out_SemaDiagnosticBuilder$C_T$C$R(B, 1);
        /*const*/char$ptr/*char P*/ PrevSpec = create_char$ptr();
        uint$ref DiagID = create_uint$ref();
        if (D.getMutableDeclSpec().SetStorageClassSpec(/*Deref*/$this(), DeclSpec.SCS.SCS_static, new SourceLocation(ConstexprLoc), PrevSpec, DiagID, 
            $this().Context.getPrintingPolicy())) {
          assert (DS.getStorageClassSpec() == DeclSpec.SCS.SCS_mutable) : "This is the only DeclSpec that should fail to be applied";
          $out_SemaDiagnosticBuilder$C_T$C$R(B, 1);
        } else {
          $out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R(B, 0), FixItHint.CreateInsertion(/*NO_COPY*/ConstexprLoc, new StringRef(/*KEEP_STR*/"static ")));
          isInstField = false;
        }
      }
    } finally {
      if (B != null) { B.$destroy(); }
    }
  }
  
  NamedDecl /*P*/ Member;
  if (isInstField) {
    final CXXScopeSpec /*&*/ SS = D.getCXXScopeSpec();
    
    // Data members must have identifiers for names.
    if (!Name.isIdentifier()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_bad_variable_name)), 
            Name));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    
    IdentifierInfo /*P*/ II = Name.getAsIdentifierInfo();
    
    // Member field could not be with "template" keyword.
    // So TemplateParameterLists should be empty in this case.
    if ((TemplateParameterLists.size() != 0)) {
      TemplateParameterList /*P*/ TemplateParams = TemplateParameterLists.$at(0);
      if ((TemplateParams.size() != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // There is no such thing as a member field template.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_template_member)), 
                  II), 
              new SourceRange(TemplateParams.getTemplateLoc(), 
                  TemplateParams.getRAngleLoc())));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // There is an extraneous 'template<>' for this member.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(TemplateParams.getTemplateLoc(), 
                      diag.err_template_member_noparams)), 
                  II), 
              new SourceRange(TemplateParams.getTemplateLoc(), 
                  TemplateParams.getRAngleLoc())));
        } finally {
          $c$.$destroy();
        }
      }
      return null;
    }
    if (SS.isSet() && !SS.isInvalid()) {
      {
        // The user provided a superfluous scope specifier inside a class
        // definition:
        //
        // class X {
        //   int X::member;
        // };
        DeclContext /*P*/ DC = $this().computeDeclContext(SS, false);
        if ((DC != null)) {
          $this().diagnoseQualifiedDeclaration(SS, DC, new DeclarationName(Name), D.getIdentifierLoc());
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_member_qualification)), 
                    Name), SS.getRange()));
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      SS.clear();
    }
    
    AttributeList /*P*/ MSPropertyAttr = getMSPropertyAttr(D.getDeclSpec().getAttributes$Const().getList());
    if ((MSPropertyAttr != null)) {
      Member = $this().HandleMSProperty(S, cast_CXXRecordDecl($this().CurContext), new SourceLocation(Loc), D, 
          BitWidth, InitStyle, AS, MSPropertyAttr);
      if (!(Member != null)) {
        return null;
      }
      isInstField = false;
    } else {
      Member = $this().HandleField(S, cast_CXXRecordDecl($this().CurContext), new SourceLocation(Loc), D, 
          BitWidth, InitStyle, AS);
      assert ((Member != null)) : "HandleField never returns null";
    }
  } else {
    Member = $this().HandleDeclarator(S, D, new MutableArrayRef<TemplateParameterList /*P*/ >(TemplateParameterLists));
    if (!(Member != null)) {
      return null;
    }
    
    // Non-instance-fields can't have a bitfield.
    if ((BitWidth != null)) {
      if (Member.isInvalidDecl()) {
        // don't emit another diagnostic.
      } else if (isa_VarDecl(Member) || isa_VarTemplateDecl(Member)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C++ 9.6p3: A bit-field shall not be a static member.
          // "static member 'A' cannot be a bit-field"
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_static_not_bitfield)), 
                  Name), BitWidth.getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      } else if (isa_TypedefDecl(Member)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // "typedef member 'x' cannot be a bit-field"
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_typedef_not_bitfield)), 
                  Name), BitWidth.getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // A function typedef ("typedef int f(); f a;").
          // C++ 9.6p3: A bit-field shall have integral or enumeration type.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_not_integral_type_bitfield)), 
                      Name), cast_ValueDecl(Member).getType()), 
              BitWidth.getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
      
      BitWidth = null;
      Member.setInvalidDecl();
    }
    
    Member.setAccess(AS);
    {
      
      // If we have declared a member function template or static data member
      // template, set the access of the templated declaration as well.
      FunctionTemplateDecl /*P*/ FunTmpl = dyn_cast_FunctionTemplateDecl(Member);
      if ((FunTmpl != null)) {
        FunTmpl.getTemplatedDecl().setAccess(AS);
      } else {
        VarTemplateDecl /*P*/ VarTmpl = dyn_cast_VarTemplateDecl(Member);
        if ((VarTmpl != null)) {
          VarTmpl.getTemplatedDecl().setAccess(AS);
        }
      }
    }
  }
  if (VS.isOverrideSpecified()) {
    Member.addAttr(/*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new($this().Context, (type$ptr<?> New$Mem)->{
            return new OverrideAttr(new SourceRange(VS.getOverrideLoc()), $this().Context, 0);
         }));
  }
  if (VS.isFinalSpecified()) {
    Member.addAttr(/*NEW_EXPR [Attr::new]*//*new (Context)*/ Attr.$new($this().Context, (type$ptr<?> New$Mem)->{
            return new FinalAttr(new SourceRange(VS.getFinalLoc()), $this().Context, 
                    (VS.isFinalSpelledSealed() ? 1 : 0));
         }));
  }
  if (VS.getLastLocation().isValid()) {
    {
      // Update the end location of a method that has a virt-specifiers.
      CXXMethodDecl /*P*/ MD = dyn_cast_or_null_CXXMethodDecl(Member);
      if ((MD != null)) {
        MD.setRangeEnd(VS.getLastLocation());
      }
    }
  }
  
  $this().CheckOverrideControl(Member);
  assert ((Name.$bool() || isInstField)) : "No identifier for non-field ?";
  if (isInstField) {
    FieldDecl /*P*/ FD = cast_FieldDecl(Member);
    $this().FieldCollector.$arrow().Add(FD);
    if (!$this().Diags.isIgnored(diag.warn_unused_private_field, FD.getLocation())) {
      // Remember all explicit private FieldDecls that have a name, no side
      // effects and are not part of a dependent type declaration.
      if (!FD.isImplicit() && FD.getDeclName().$bool()
         && FD.getAccess() == AccessSpecifier.AS_private
         && !FD.hasAttr(UnusedAttr.class)
         && !FD.getParent().isDependentContext()
         && !InitializationHasSideEffects($Deref(FD))) {
        $this().UnusedPrivateFields.insert(FD);
      }
    }
  }
  
  return Member;
}

// namespace

/// \brief Enter a new C++ default initializer scope. After calling this, the
/// caller must call \ref ActOnFinishCXXInClassMemberInitializer, even if
/// parsing or instantiating the initializer failed.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStartCXXInClassMemberInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2683,
 FQN="clang::Sema::ActOnStartCXXInClassMemberInitializer", NM="_ZN5clang4Sema37ActOnStartCXXInClassMemberInitializerEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema37ActOnStartCXXInClassMemberInitializerEv")
//</editor-fold>
public final void ActOnStartCXXInClassMemberInitializer() {
  // Create a synthetic function scope to represent the call to the constructor
  // that notionally surrounds a use of this initializer.
  $this().PushFunctionScope();
}


/// \brief This is invoked after parsing an in-class initializer for a
/// non-static C++ class member, and after instantiating an in-class initializer
/// in a class template. Such actions are deferred until the class is complete.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFinishCXXInClassMemberInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2692,
 FQN="clang::Sema::ActOnFinishCXXInClassMemberInitializer", NM="_ZN5clang4Sema38ActOnFinishCXXInClassMemberInitializerEPNS_4DeclENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema38ActOnFinishCXXInClassMemberInitializerEPNS_4DeclENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public final void ActOnFinishCXXInClassMemberInitializer(Decl /*P*/ D, 
                                      SourceLocation InitLoc, 
                                      Expr /*P*/ InitExpr) {
  // Pop the notional constructor scope we created earlier.
  $this().PopFunctionScopeInfo((/*const*/ AnalysisBasedWarnings.Policy /*P*/ )null, D);
  
  FieldDecl /*P*/ FD = dyn_cast_FieldDecl(D);
  assert ((isa_MSPropertyDecl(D) || FD.getInClassInitStyle() != InClassInitStyle.ICIS_NoInit)) : "must set init style when field is created";
  if (!(InitExpr != null)) {
    D.setInvalidDecl();
    if ((FD != null)) {
      FD.removeInClassInitializer();
    }
    return;
  }
  if ($this().DiagnoseUnexpandedParameterPack(InitExpr, UnexpandedParameterPackContext.UPPC_Initializer)) {
    FD.setInvalidDecl();
    FD.removeInClassInitializer();
    return;
  }
  
  ActionResultTTrue<Expr /*P*/ > Init = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, InitExpr);
  if (!FD.getType().$arrow().isDependentType() && !InitExpr.isTypeDependent()) {
    InitializationSequence Seq = null;
    try {
      InitializedEntity Entity = InitializedEntity.InitializeMember(FD);
      InitializationKind Kind = FD.getInClassInitStyle() == InClassInitStyle.ICIS_ListInit ? InitializationKind.CreateDirectList(InitExpr.getLocStart()) : InitializationKind.CreateCopy(InitExpr.getLocStart(), new SourceLocation(InitLoc));
      Seq/*J*/= new InitializationSequence(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(InitExpr, true));
      Init.$assignMove(Seq.Perform(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(InitExpr, true)));
      if (Init.isInvalid()) {
        FD.setInvalidDecl();
        return;
      }
    } finally {
      if (Seq != null) { Seq.$destroy(); }
    }
  }
  
  // C++11 [class.base.init]p7:
  //   The initialization of each base and member constitutes a
  //   full-expression.
  Init.$assignMove($this().ActOnFinishFullExpr(Init.get(), new SourceLocation(InitLoc)));
  if (Init.isInvalid()) {
    FD.setInvalidDecl();
    return;
  }
  
  InitExpr = Init.get();
  
  FD.setInClassInitializer(InitExpr);
}


/// \brief Handle a C++ member initializer using parentheses syntax.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnMemInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2804,
 FQN="clang::Sema::ActOnMemInitializer", NM="_ZN5clang4Sema19ActOnMemInitializerEPNS_4DeclEPNS_5ScopeERNS_12CXXScopeSpecEPNS_14IdentifierInfoENS_9OpaquePtrINS_8QualTypeEEERKNS_8DeclSpecENS_14SourceLocationESF_N4llvm8ArrayRefIPNS_4ExprEEESF_SF_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema19ActOnMemInitializerEPNS_4DeclEPNS_5ScopeERNS_12CXXScopeSpecEPNS_14IdentifierInfoENS_9OpaquePtrINS_8QualTypeEEERKNS_8DeclSpecENS_14SourceLocationESF_N4llvm8ArrayRefIPNS_4ExprEEESF_SF_")
//</editor-fold>
public final ActionResultTTrue<CXXCtorInitializer /*P*/ > ActOnMemInitializer(Decl /*P*/ ConstructorD, 
                   Scope /*P*/ S, 
                   final CXXScopeSpec /*&*/ SS, 
                   IdentifierInfo /*P*/ MemberOrBase, 
                   OpaquePtr<QualType> TemplateTypeTy, 
                   final /*const*/ DeclSpec /*&*/ DS, 
                   SourceLocation IdLoc, 
                   SourceLocation LParenLoc, 
                   ArrayRef<Expr /*P*/ > Args, 
                   SourceLocation RParenLoc, 
                   SourceLocation EllipsisLoc) {
  Expr /*P*/ List = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
      return new ParenListExpr($this().Context, new SourceLocation(LParenLoc), 
              new ArrayRef<Expr /*P*/ >(Args), new SourceLocation(RParenLoc));
   });
  return $this().BuildMemInitializer(ConstructorD, S, SS, MemberOrBase, new OpaquePtr<QualType>(TemplateTypeTy), 
      DS, new SourceLocation(IdLoc), List, new SourceLocation(EllipsisLoc));
}


/// \brief Handle a C++ member initializer using braced-init-list syntax.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnMemInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2788,
 FQN="clang::Sema::ActOnMemInitializer", NM="_ZN5clang4Sema19ActOnMemInitializerEPNS_4DeclEPNS_5ScopeERNS_12CXXScopeSpecEPNS_14IdentifierInfoENS_9OpaquePtrINS_8QualTypeEEERKNS_8DeclSpecENS_14SourceLocationEPNS_4ExprESF_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema19ActOnMemInitializerEPNS_4DeclEPNS_5ScopeERNS_12CXXScopeSpecEPNS_14IdentifierInfoENS_9OpaquePtrINS_8QualTypeEEERKNS_8DeclSpecENS_14SourceLocationEPNS_4ExprESF_")
//</editor-fold>
public final ActionResultTTrue<CXXCtorInitializer /*P*/ > ActOnMemInitializer(Decl /*P*/ ConstructorD, 
                   Scope /*P*/ S, 
                   final CXXScopeSpec /*&*/ SS, 
                   IdentifierInfo /*P*/ MemberOrBase, 
                   OpaquePtr<QualType> TemplateTypeTy, 
                   final /*const*/ DeclSpec /*&*/ DS, 
                   SourceLocation IdLoc, 
                   Expr /*P*/ InitList, 
                   SourceLocation EllipsisLoc) {
  return $this().BuildMemInitializer(ConstructorD, S, SS, MemberOrBase, new OpaquePtr<QualType>(TemplateTypeTy), 
      DS, new SourceLocation(IdLoc), InitList, 
      new SourceLocation(EllipsisLoc));
}


/// \brief Handle a C++ member initializer.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildMemInitializer">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2847,
 FQN="clang::Sema::BuildMemInitializer", NM="_ZN5clang4Sema19BuildMemInitializerEPNS_4DeclEPNS_5ScopeERNS_12CXXScopeSpecEPNS_14IdentifierInfoENS_9OpaquePtrINS_8QualTypeEEERKNS_8DeclSpecENS_14SourceLocationEPNS_4ExprESF_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema19BuildMemInitializerEPNS_4DeclEPNS_5ScopeERNS_12CXXScopeSpecEPNS_14IdentifierInfoENS_9OpaquePtrINS_8QualTypeEEERKNS_8DeclSpecENS_14SourceLocationEPNS_4ExprESF_")
//</editor-fold>
public final ActionResultTTrue<CXXCtorInitializer /*P*/ > BuildMemInitializer(Decl /*P*/ _ConstructorD, 
                   Scope /*P*/ S, 
                   final CXXScopeSpec /*&*/ SS, 
                   IdentifierInfo /*P*/ MemberOrBase, 
                   OpaquePtr<QualType> TemplateTypeTy, 
                   final /*const*/ DeclSpec /*&*/ DS, 
                   SourceLocation IdLoc, 
                   Expr /*P*/ Init, 
                   SourceLocation EllipsisLoc) {
  type$ref<Decl /*P*/ > ConstructorD = create_type$ref(_ConstructorD);
  ActionResultTTrue<Expr /*P*/ > Res = $this().CorrectDelayedTyposInExpr(Init);
  if (!Res.isUsable()) {
    return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(true);
  }
  Init = Res.get();
  if (!(ConstructorD.$deref() != null)) {
    return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(true);
  }
  
  $this().AdjustDeclIfTemplate(ConstructorD);
  
  CXXConstructorDecl /*P*/ Constructor = dyn_cast_CXXConstructorDecl(ConstructorD.$deref());
  if (!(Constructor != null)) {
    // The user wrote a constructor initializer on a function that is
    // not a C++ constructor. Ignore the error for now, because we may
    // have more member initializers coming; we'll diagnose it just
    // once in ActOnMemInitializers.
    return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(true);
  }
  
  CXXRecordDecl /*P*/ ClassDecl = Constructor.getParent();
  
  // C++ [class.base.init]p2:
  //   Names in a mem-initializer-id are looked up in the scope of the
  //   constructor's class and, if not found in that scope, are looked
  //   up in the scope containing the constructor's definition.
  //   [Note: if the constructor's class contains a member with the
  //   same name as a direct or virtual base class of the class, a
  //   mem-initializer-id naming the member or base class and composed
  //   of a single identifier refers to the class member. A
  //   mem-initializer-id for the hidden base class may be specified
  //   using a qualified name. ]
  if (!(SS.getScopeRep() != null) && !TemplateTypeTy.$bool()) {
    // Look for a member, first.
    DeclContextLookupResult Result = ClassDecl.lookup(new DeclarationName(MemberOrBase));
    if (!Result.empty()) {
      ValueDecl /*P*/ Member;
      if (((Member = dyn_cast_FieldDecl(Result.front())) != null)
         || ((Member = dyn_cast_IndirectFieldDecl(Result.front())) != null)) {
        if (EllipsisLoc.isValid()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(EllipsisLoc), diag.err_pack_expansion_member_init)), 
                    MemberOrBase), 
                new SourceRange(/*NO_COPY*/IdLoc, Init.getSourceRange().getEnd())));
          } finally {
            $c$.$destroy();
          }
        }
        
        return $this().BuildMemberInitializer(Member, Init, new SourceLocation(IdLoc));
      }
    }
  }
  // It didn't name a member, so see if it names a class.
  QualType BaseType/*J*/= new QualType();
  type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr(null);
  if (TemplateTypeTy.$bool()) {
    BaseType.$assignMove(GetTypeFromParser(new OpaquePtr<QualType>(TemplateTypeTy), $AddrOf(TInfo)));
  } else if (DS.getTypeSpecType() == TypeSpecifierType.TST_decltype) {
    BaseType.$assignMove($this().BuildDecltypeType(DS.getRepAsExpr(), DS.getTypeSpecTypeLoc()));
  } else {
    LookupResult R = null;
    try {
      R/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(MemberOrBase), new SourceLocation(IdLoc), LookupNameKind.LookupOrdinaryName);
      $this().LookupParsedName(R, S, $AddrOf(SS));
      
      TypeDecl /*P*/ TyD = R.<TypeDecl>getAsSingle(TypeDecl.class);
      if (!(TyD != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if (R.isAmbiguous()) {
            return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(true);
          }
          
          // We don't want access-control diagnostics here.
          R.suppressDiagnostics();
          if (SS.isSet() && $this().isDependentScopeSpecifier(SS)) {
            boolean NotUnknownSpecialization = false;
            DeclContext /*P*/ DC = $this().computeDeclContext(SS, false);
            {
              CXXRecordDecl /*P*/ Record = dyn_cast_or_null_CXXRecordDecl(DC);
              if ((Record != null)) {
                NotUnknownSpecialization = !Record.hasAnyDependentBases();
              }
            }
            if (!NotUnknownSpecialization) {
              // When the scope specifier can refer to a member of an unknown
              // specialization, we take it as a type name.
              BaseType.$assignMove($this().CheckTypenameType(ElaboratedTypeKeyword.ETK_None, new SourceLocation(), 
                      SS.getWithLocInContext($this().Context), 
                      $Deref(MemberOrBase), new SourceLocation(IdLoc)));
              if (BaseType.isNull()) {
                return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(true);
              }
              
              R.clear();
              R.setLookupName(new DeclarationName(MemberOrBase));
            }
          }
          
          // If no results were found, try to correct typos.
          TypoCorrection Corr/*J*/= new TypoCorrection();
          if ($c$.clean(R.empty() && BaseType.isNull()
             && (Corr.$assignMove($this().CorrectTypo(R.getLookupNameInfo(), R.getLookupKind(), S, $AddrOf(SS), 
                  $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new MemInitializerValidatorCCC(ClassDecl))))), 
                  CorrectTypoKind.CTK_ErrorRecovery, ClassDecl))).$bool())) {
            {
              FieldDecl /*P*/ Member = Corr.getCorrectionDeclAs(FieldDecl.class);
              if ((Member != null)) {
                // We have found a non-static data member with a similar
                // name to what was typed; complain and initialize that
                // member.
                $this().diagnoseTypo(Corr, 
                    $out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_IdentifierInfo$C$P($c$.track($this().PDiag(diag.err_mem_init_not_member_or_class_suggest)), 
                            MemberOrBase), /*true*/1)); $c$.clean();
                return $this().BuildMemberInitializer(Member, Init, new SourceLocation(IdLoc));
              } else {
                TypeDecl /*P*/ Type = Corr.getCorrectionDeclAs(TypeDecl.class);
                if ((Type != null)) {
                  type$ref</*const*/ CXXBaseSpecifier /*P*/ > DirectBaseSpec = create_type$ref();
                  type$ref</*const*/ CXXBaseSpecifier /*P*/ > VirtualBaseSpec = create_type$ref();
                  if (FindBaseInitializer(/*Deref*/$this(), ClassDecl, 
                      $this().Context.getTypeDeclType(Type), 
                      DirectBaseSpec, VirtualBaseSpec)) {
                    // We have found a direct or virtual base class with a
                    // similar name to what was typed; complain and initialize
                    // that base class.
                    $this().diagnoseTypo(Corr, 
                        $out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_IdentifierInfo$C$P($c$.track($this().PDiag(diag.err_mem_init_not_member_or_class_suggest)), 
                                MemberOrBase), /*false*/0), 
                        $c$.track($this().PDiag()/*Suppress note, we provide our own.*/)); $c$.clean();
                    
                    /*const*/ CXXBaseSpecifier /*P*/ BaseSpec = (DirectBaseSpec.$deref() != null) ? DirectBaseSpec.$deref() : VirtualBaseSpec.$deref();
                    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(BaseSpec.getLocStart(), 
                                diag.note_base_class_specified_here)), 
                            BaseSpec.getType()), 
                        BaseSpec.getSourceRange()));
                    
                    TyD = Type;
                  }
                }
              }
            }
          }
          if (!(TyD != null) && BaseType.isNull()) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IdLoc), diag.err_mem_init_not_member_or_class)), 
                    MemberOrBase), new SourceRange(/*NO_COPY*/IdLoc, Init.getSourceRange().getEnd())));
            return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(true);
          }
        } finally {
          $c$.$destroy();
        }
      }
      if (BaseType.isNull()) {
        BaseType.$assignMove($this().Context.getTypeDeclType(TyD));
        $this().MarkAnyDeclReferenced(TyD.getLocation(), TyD, /*OdrUse=*/ false);
        if (SS.isSet()) {
          BaseType.$assignMove($this().Context.getElaboratedType(ElaboratedTypeKeyword.ETK_None, SS.getScopeRep(), 
                  new QualType(BaseType)));
          TInfo.$set($this().Context.CreateTypeSourceInfo(new QualType(BaseType)));
          ElaboratedTypeLoc TL = TInfo.$star().getTypeLoc().castAs(ElaboratedTypeLoc.class);
          TL.getNamedTypeLoc().castAs(TypeSpecTypeLoc.class).setNameLoc(/*NO_COPY*/IdLoc);
          TL.setElaboratedKeywordLoc(new SourceLocation());
          TL.setQualifierLoc(SS.getWithLocInContext($this().Context));
        }
      }
    } finally {
      if (R != null) { R.$destroy(); }
    }
  }
  if (!(TInfo.$star() != null)) {
    TInfo.$set($this().Context.getTrivialTypeSourceInfo(/*NO_COPY*/BaseType, /*NO_COPY*/IdLoc));
  }
  
  return $this().BuildBaseInitializer(new QualType(BaseType), TInfo.$star(), Init, ClassDecl, new SourceLocation(EllipsisLoc));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildMemberInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 3060,
 FQN="clang::Sema::BuildMemberInitializer", NM="_ZN5clang4Sema22BuildMemberInitializerEPNS_9ValueDeclEPNS_4ExprENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema22BuildMemberInitializerEPNS_9ValueDeclEPNS_4ExprENS_14SourceLocationE")
//</editor-fold>
public final ActionResultTTrue<CXXCtorInitializer /*P*/ > BuildMemberInitializer(ValueDecl /*P*/ Member, Expr /*P*/ Init, 
                      SourceLocation IdLoc) {
  FieldDecl /*P*/ DirectMember = dyn_cast_FieldDecl(Member);
  IndirectFieldDecl /*P*/ IndirectMember = dyn_cast_IndirectFieldDecl(Member);
  assert (((DirectMember != null) || (IndirectMember != null))) : "Member must be a FieldDecl or IndirectFieldDecl";
  if ($this().DiagnoseUnexpandedParameterPack(Init, UnexpandedParameterPackContext.UPPC_Initializer)) {
    return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(true);
  }
  if (Member.isInvalidDecl()) {
    return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(true);
  }
  
  MutableArrayRef<Expr /*P*/ > Args/*J*/= new MutableArrayRef<Expr /*P*/ >(true);
  {
    ParenListExpr /*P*/ ParenList = dyn_cast_ParenListExpr(Init);
    if ((ParenList != null)) {
      Args.$assignMove(new MutableArrayRef<Expr /*P*/ >(ParenList.getExprs(), ParenList.getNumExprs(), true));
    } else {
      InitListExpr /*P*/ InitList = dyn_cast_InitListExpr(Init);
      if ((InitList != null)) {
        Args.$assignMove(new MutableArrayRef<Expr /*P*/ >(InitList.getInits(), InitList.getNumInits(), true));
      } else {
        // Template instantiation doesn't reconstruct ParenListExprs for us.
        Args.$assignMove(new MutableArrayRef<Expr /*P*/ >(Init, true));
      }
    }
  }
  
  SourceRange InitRange = Init.getSourceRange();
  if (Member.getType().$arrow().isDependentType() || Init.isTypeDependent()) {
    // Can't check initialization for a member of dependent type or when
    // any of the arguments are type-dependent expressions.
    $this().DiscardCleanupsInEvaluationContext();
  } else {
    InitializationSequence InitSeq = null;
    try {
      boolean InitList = false;
      if (isa_InitListExpr(Init)) {
        InitList = true;
        Args.$assignMove(new MutableArrayRef<Expr /*P*/ >(Init, true));
      }
      
      // Initialize the member.
      InitializedEntity MemberEntity = (DirectMember != null) ? InitializedEntity.InitializeMember(DirectMember, (/*const*/ InitializedEntity /*P*/ )null) : InitializedEntity.InitializeMember(IndirectMember, 
          (/*const*/ InitializedEntity /*P*/ )null);
      InitializationKind Kind = InitList ? InitializationKind.CreateDirectList(new SourceLocation(IdLoc)) : InitializationKind.CreateDirect(new SourceLocation(IdLoc), InitRange.getBegin(), 
          InitRange.getEnd());
      
      InitSeq/*J*/= new InitializationSequence(/*Deref*/$this(), MemberEntity, Kind, new MutableArrayRef<Expr /*P*/ >(Args));
      ActionResultTTrue<Expr /*P*/ > MemberInit = InitSeq.Perform(/*Deref*/$this(), MemberEntity, Kind, new MutableArrayRef<Expr /*P*/ >(Args), 
          (type$ptr<QualType /*P*/> )null);
      if (MemberInit.isInvalid()) {
        return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(true);
      }
      
      CheckForDanglingReferenceOrPointer(/*Deref*/$this(), Member, MemberInit.get(), new SourceLocation(IdLoc));
      
      // C++11 [class.base.init]p7:
      //   The initialization of each base and member constitutes a
      //   full-expression.
      MemberInit.$assignMove($this().ActOnFinishFullExpr(MemberInit.get(), InitRange.getBegin()));
      if (MemberInit.isInvalid()) {
        return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(true);
      }
      
      Init = MemberInit.get();
    } finally {
      if (InitSeq != null) { InitSeq.$destroy(); }
    }
  }
  Expr /*P*/ L$Init = Init;
  if ((DirectMember != null)) {
    return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (Context)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
            return new CXXCtorInitializer($this().Context, DirectMember, new SourceLocation(IdLoc), 
                    InitRange.getBegin(), L$Init, 
                    InitRange.getEnd());
         }));
  } else {
    return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (Context)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
            return new CXXCtorInitializer($this().Context, IndirectMember, new SourceLocation(IdLoc), 
                    InitRange.getBegin(), L$Init, 
                    InitRange.getEnd());
         }));
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildBaseInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 3192,
 FQN="clang::Sema::BuildBaseInitializer", NM="_ZN5clang4Sema20BuildBaseInitializerENS_8QualTypeEPNS_14TypeSourceInfoEPNS_4ExprEPNS_13CXXRecordDeclENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema20BuildBaseInitializerENS_8QualTypeEPNS_14TypeSourceInfoEPNS_4ExprEPNS_13CXXRecordDeclENS_14SourceLocationE")
//</editor-fold>
public final ActionResultTTrue<CXXCtorInitializer /*P*/ > BuildBaseInitializer(QualType BaseType, TypeSourceInfo /*P*/ BaseTInfo, 
                    Expr /*P*/ Init, CXXRecordDecl /*P*/ ClassDecl, 
                    SourceLocation EllipsisLoc) {
  InitializationSequence InitSeq = null;
  try {
    SourceLocation BaseLoc = BaseTInfo.getTypeLoc().getLocalSourceRange().getBegin();
    if (!BaseType.$arrow().isDependentType() && !BaseType.$arrow().isRecordType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new ActionResultTTrue<CXXCtorInitializer /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(BaseLoc), diag.err_base_init_does_not_name_class)), 
                    BaseType), BaseTInfo.getTypeLoc().getLocalSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
    
    // C++ [class.base.init]p2:
    //   [...] Unless the mem-initializer-id names a nonstatic data
    //   member of the constructor's class or a direct or virtual base
    //   of that class, the mem-initializer is ill-formed. A
    //   mem-initializer-list can initialize a base class using any
    //   name that denotes that base class type.
    boolean Dependent = BaseType.$arrow().isDependentType() || Init.isTypeDependent();
    
    SourceRange InitRange = Init.getSourceRange();
    if (EllipsisLoc.isValid()) {
      // This is a pack expansion.
      if (!BaseType.$arrow().containsUnexpandedParameterPack()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(EllipsisLoc), diag.err_pack_expansion_without_parameter_packs)), 
              new SourceRange(/*NO_COPY*/BaseLoc, InitRange.getEnd())));
          
          EllipsisLoc.$assignMove(new SourceLocation());
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      // Check for any unexpanded parameter packs.
      if ($this().DiagnoseUnexpandedParameterPack(new SourceLocation(BaseLoc), BaseTInfo, UnexpandedParameterPackContext.UPPC_Initializer)) {
        return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(true);
      }
      if ($this().DiagnoseUnexpandedParameterPack(Init, UnexpandedParameterPackContext.UPPC_Initializer)) {
        return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(true);
      }
    }
    
    // Check for direct and virtual base classes.
    type$ref</*const*/ CXXBaseSpecifier /*P*/ > DirectBaseSpec = create_type$null$ref(null);
    type$ref</*const*/ CXXBaseSpecifier /*P*/ > VirtualBaseSpec = create_type$null$ref(null);
    if (!Dependent) {
      if ($this().Context.hasSameUnqualifiedType(new QualType(ClassDecl.getTypeForDecl(), 0), 
          new QualType(BaseType))) {
        return $this().BuildDelegatingInitializer(BaseTInfo, Init, ClassDecl);
      }
      
      FindBaseInitializer(/*Deref*/$this(), ClassDecl, new QualType(BaseType), DirectBaseSpec, 
          VirtualBaseSpec);
      
      // C++ [base.class.init]p2:
      // Unless the mem-initializer-id names a nonstatic data member of the
      // constructor's class or a direct or virtual base of that class, the
      // mem-initializer is ill-formed.
      if (!(DirectBaseSpec.$deref() != null) && !(VirtualBaseSpec.$deref() != null)) {
        // If the class has any dependent bases, then it's possible that
        // one of those types will resolve to the same type as
        // BaseType. Therefore, just treat this as a dependent base
        // class initialization.  FIXME: Should we try to check the
        // initialization anyway? It seems odd.
        if (ClassDecl.hasAnyDependentBases()) {
          Dependent = true;
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean(new ActionResultTTrue<CXXCtorInitializer /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(BaseLoc), diag.err_not_direct_base_or_virtual)), 
                            BaseType), $this().Context.getTypeDeclType(ClassDecl)), 
                    BaseTInfo.getTypeLoc().getLocalSourceRange())));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    if (Dependent) {
      $this().DiscardCleanupsInEvaluationContext();
      
      return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
          /*new (Context)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
              return new CXXCtorInitializer($this().Context, BaseTInfo, 
                      /*IsVirtual=*/ false, 
                      InitRange.getBegin(), Init, 
                      InitRange.getEnd(), new SourceLocation(EllipsisLoc));
           }));
    }
    
    // C++ [base.class.init]p2:
    //   If a mem-initializer-id is ambiguous because it designates both
    //   a direct non-virtual base class and an inherited virtual base
    //   class, the mem-initializer is ill-formed.
    if ((DirectBaseSpec.$deref() != null) && (VirtualBaseSpec.$deref() != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new ActionResultTTrue<CXXCtorInitializer /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(BaseLoc), diag.err_base_init_direct_and_virtual)), 
                    BaseType), BaseTInfo.getTypeLoc().getLocalSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
    
    /*const*/ CXXBaseSpecifier /*P*/ BaseSpec = DirectBaseSpec.$deref();
    if (!(BaseSpec != null)) {
      BaseSpec = VirtualBaseSpec.$deref();
    }
    
    // Initialize the base.
    boolean InitList = true;
    MutableArrayRef<Expr /*P*/ > Args = new MutableArrayRef<Expr /*P*/ >(Init, true);
    {
      ParenListExpr /*P*/ ParenList = dyn_cast_ParenListExpr(Init);
      if ((ParenList != null)) {
        InitList = false;
        Args.$assignMove(new MutableArrayRef<Expr /*P*/ >(ParenList.getExprs(), ParenList.getNumExprs(), true));
      }
    }
    
    InitializedEntity BaseEntity = InitializedEntity.InitializeBase($this().Context, BaseSpec, (VirtualBaseSpec.$deref() != null));
    InitializationKind Kind = InitList ? InitializationKind.CreateDirectList(new SourceLocation(BaseLoc)) : InitializationKind.CreateDirect(new SourceLocation(BaseLoc), InitRange.getBegin(), 
        InitRange.getEnd());
    InitSeq/*J*/= new InitializationSequence(/*Deref*/$this(), BaseEntity, Kind, new MutableArrayRef<Expr /*P*/ >(Args));
    ActionResultTTrue<Expr /*P*/ > BaseInit = InitSeq.Perform(/*Deref*/$this(), BaseEntity, Kind, new MutableArrayRef<Expr /*P*/ >(Args), (type$ptr<QualType /*P*/> )null);
    if (BaseInit.isInvalid()) {
      return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(true);
    }
    
    // C++11 [class.base.init]p7:
    //   The initialization of each base and member constitutes a
    //   full-expression.
    BaseInit.$assignMove($this().ActOnFinishFullExpr(BaseInit.get(), InitRange.getBegin()));
    if (BaseInit.isInvalid()) {
      return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(true);
    }
    
    // If we are in a dependent context, template instantiation will
    // perform this type-checking again. Just save the arguments that we
    // received in a ParenListExpr.
    // FIXME: This isn't quite ideal, since our ASTs don't capture all
    // of the information that we have about the base
    // initializer. However, deconstructing the ASTs is a dicey process,
    // and this approach is far more likely to get the corner cases right.
    if ($this().CurContext.isDependentContext()) {
      BaseInit.$assign(Init);
    }
    final CXXBaseSpecifier /*P*/ L$BaseSpec = BaseSpec;
    return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (Context)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
            return new CXXCtorInitializer($this().Context, BaseTInfo, 
                    L$BaseSpec.isVirtual(), 
                    InitRange.getBegin(), 
                    BaseInit.getAs(Expr.class), 
                    InitRange.getEnd(), new SourceLocation(EllipsisLoc));
         }));
  } finally {
    if (InitSeq != null) { InitSeq.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildDelegatingInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 3136,
 FQN="clang::Sema::BuildDelegatingInitializer", NM="_ZN5clang4Sema26BuildDelegatingInitializerEPNS_14TypeSourceInfoEPNS_4ExprEPNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema26BuildDelegatingInitializerEPNS_14TypeSourceInfoEPNS_4ExprEPNS_13CXXRecordDeclE")
//</editor-fold>
public final ActionResultTTrue<CXXCtorInitializer /*P*/ > BuildDelegatingInitializer(TypeSourceInfo /*P*/ TInfo, Expr /*P*/ Init, 
                          CXXRecordDecl /*P*/ ClassDecl) {
  InitializationSequence InitSeq = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    SourceLocation NameLoc = TInfo.getTypeLoc().getLocalSourceRange().getBegin();
    if (!$this().LangOpts.CPlusPlus11) {
      return $c$.clean(new ActionResultTTrue<CXXCtorInitializer /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_delegating_ctor)), 
              TInfo.getTypeLoc().getLocalSourceRange())));
    }
    $c$.clean($c$.track($this().Diag(new SourceLocation(NameLoc), diag.warn_cxx98_compat_delegating_ctor)));
    
    boolean InitList = true;
    MutableArrayRef<Expr /*P*/ > Args = new MutableArrayRef<Expr /*P*/ >(Init, true);
    {
      ParenListExpr /*P*/ ParenList = dyn_cast_ParenListExpr(Init);
      if ((ParenList != null)) {
        InitList = false;
        Args.$assignMove(new MutableArrayRef<Expr /*P*/ >(ParenList.getExprs(), ParenList.getNumExprs(), true));
      }
    }
    
    SourceRange InitRange = Init.getSourceRange();
    // Initialize the object.
    InitializedEntity DelegationEntity = InitializedEntity.InitializeDelegation(new QualType(ClassDecl.getTypeForDecl(), 0));
    InitializationKind Kind = InitList ? InitializationKind.CreateDirectList(new SourceLocation(NameLoc)) : InitializationKind.CreateDirect(new SourceLocation(NameLoc), InitRange.getBegin(), 
        InitRange.getEnd());
    InitSeq/*J*/= new InitializationSequence(/*Deref*/$this(), DelegationEntity, Kind, new MutableArrayRef<Expr /*P*/ >(Args));
    ActionResultTTrue<Expr /*P*/ > DelegationInit = InitSeq.Perform(/*Deref*/$this(), DelegationEntity, Kind, 
        new MutableArrayRef<Expr /*P*/ >(Args), (type$ptr<QualType /*P*/> )null);
    if (DelegationInit.isInvalid()) {
      return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(true);
    }
    assert ((cast_CXXConstructExpr(DelegationInit.get()).getConstructor() != null)) : "Delegating constructor with no target?";
    
    // C++11 [class.base.init]p7:
    //   The initialization of each base and member constitutes a
    //   full-expression.
    DelegationInit.$assignMove($this().ActOnFinishFullExpr(DelegationInit.get(), 
            InitRange.getBegin()));
    if (DelegationInit.isInvalid()) {
      return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(true);
    }
    
    // If we are in a dependent context, template instantiation will
    // perform this type-checking again. Just save the arguments that we
    // received in a ParenListExpr.
    // FIXME: This isn't quite ideal, since our ASTs don't capture all
    // of the information that we have about the base
    // initializer. However, deconstructing the ASTs is a dicey process,
    // and this approach is far more likely to get the corner cases right.
    if ($this().CurContext.isDependentContext()) {
      DelegationInit.$assign(Init);
    }
    
    return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (Context)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
            return new CXXCtorInitializer($this().Context, TInfo, InitRange.getBegin(), 
                    DelegationInit.getAs(Expr.class), 
                    InitRange.getEnd());
         }));
  } finally {
    if (InitSeq != null) { InitSeq.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::SetDelegatingInitializer">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 3827,
 FQN="clang::Sema::SetDelegatingInitializer", NM="_ZN5clang4Sema24SetDelegatingInitializerEPNS_18CXXConstructorDeclEPNS_18CXXCtorInitializerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema24SetDelegatingInitializerEPNS_18CXXConstructorDeclEPNS_18CXXCtorInitializerE")
//</editor-fold>
public final boolean SetDelegatingInitializer(CXXConstructorDecl /*P*/ Constructor, 
                        CXXCtorInitializer /*P*/ Initializer) {
  assert (Initializer.isDelegatingInitializer());
  Constructor.setNumCtorInitializers(1);
  type$ptr<CXXCtorInitializer /*P*/ /*P*/> initializer = create_const_type$ptr(/*FIXME:NEW_EXPR*//*new (Context)*/ new CXXCtorInitializer /*P*/ [1]);
  memcpy(initializer, create_type$ptr($AddrOf(Initializer)), (true ? 1 : $sizeof_ptr(/*CXXCtorInitializer  */)), true);
  Constructor.setCtorInitializers(initializer);
  {
    
    CXXDestructorDecl /*P*/ Dtor = $this().LookupDestructor(Constructor.getParent());
    if ((Dtor != null)) {
      $this().MarkFunctionReferenced(Initializer.getSourceLocation(), Dtor);
      $this().DiagnoseUseOfDecl(Dtor, Initializer.getSourceLocation());
    }
  }
  
  $this().DelegatingCtorDecls.push_back(Constructor);
  
  DiagnoseUninitializedFields(/*Deref*/$this(), Constructor);
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::SetCtorInitializers">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 3849,
 FQN="clang::Sema::SetCtorInitializers", NM="_ZN5clang4Sema19SetCtorInitializersEPNS_18CXXConstructorDeclEbN4llvm8ArrayRefIPNS_18CXXCtorInitializerEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema19SetCtorInitializersEPNS_18CXXConstructorDeclEbN4llvm8ArrayRefIPNS_18CXXCtorInitializerEEE")
//</editor-fold>
public final boolean SetCtorInitializers(CXXConstructorDecl /*P*/ Constructor, boolean AnyErrors) {
  return SetCtorInitializers(Constructor, AnyErrors, 
                   new ArrayRef<CXXCtorInitializer /*P*/ >(None, true));
}
public final boolean SetCtorInitializers(CXXConstructorDecl /*P*/ Constructor, boolean AnyErrors, 
                   ArrayRef<CXXCtorInitializer /*P*/ > Initializers/*= None*/) {
  BaseAndFieldInfo Info = null;
  try {
    if (Constructor.isDependentContext()) {
      // Just store the initializers as written, they will be checked during
      // instantiation.
      if (!Initializers.empty()) {
        Constructor.setNumCtorInitializers(Initializers.size());
        type$ptr<CXXCtorInitializer /*P*/ /*P*/> baseOrMemberInitializers = create_const_type$ptr(/*FIXME:NEW_EXPR*//*new (Context)*/ new CXXCtorInitializer /*P*/ [Initializers.size()]);
        memcpy(baseOrMemberInitializers, Initializers.data(), 
            Initializers.size() * (true ? 1 : $sizeof_ptr(/*CXXCtorInitializer  */)), true);
        Constructor.setCtorInitializers(baseOrMemberInitializers);
      }
      
      // Let template instantiation know whether we had errors.
      if (AnyErrors) {
        Constructor.setInvalidDecl();
      }
      
      return false;
    }
    
    Info/*J*/= new BaseAndFieldInfo(/*Deref*/$this(), Constructor, AnyErrors);
    
    // We need to build the initializer AST according to order of construction
    // and not what user specified in the Initializers list.
    CXXRecordDecl /*P*/ ClassDecl = Constructor.getParent().getDefinition();
    if (!(ClassDecl != null)) {
      return true;
    }
    
    boolean HadError = false;
    
    for (/*uint*/int i = 0; $less_uint(i, Initializers.size()); i++) {
      CXXCtorInitializer /*P*/ Member = Initializers.$at(i);
      if (Member.isBaseInitializer()) {
        Info.AllBaseFields.$set(Member.getBaseClass().getAs$RecordType(), Member);
      } else {
        Info.AllBaseFields.$set(Member.getAnyMember().getCanonicalDecl(), Member);
        {
          
          IndirectFieldDecl /*P*/ F = Member.getIndirectMember();
          if ((F != null)) {
            for (NamedDecl /*P*/ C : F.chain()) {
              FieldDecl /*P*/ FD = dyn_cast_FieldDecl(C);
              if ((FD != null) && FD.getParent().isUnion()) {
                Info.ActiveUnionMember.insert_pair$KeyT$ValueT(std.make_pair_Ptr_Ptr(FD.getParent().getCanonicalDecl(), FD.getCanonicalDecl()));
              }
            }
          } else {
            FieldDecl /*P*/ FD = Member.getMember();
            if ((FD != null)) {
              if (FD.getParent().isUnion()) {
                Info.ActiveUnionMember.insert_pair$KeyT$ValueT(std.make_pair_Ptr_Ptr(FD.getParent().getCanonicalDecl(), FD.getCanonicalDecl()));
              }
            }
          }
        }
      }
    }
    
    // Keep track of the direct virtual bases.
    SmallPtrSet<CXXBaseSpecifier /*P*/ > DirectVBases/*J*/= new SmallPtrSet<CXXBaseSpecifier /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
    for (final CXXBaseSpecifier /*&*/ I : ClassDecl.bases()) {
      if (I.isVirtual()) {
        DirectVBases.insert($AddrOf(I));
      }
    }
    
    // Push virtual bases before others.
    for (final CXXBaseSpecifier /*&*/ VBase : ClassDecl.vbases()) {
      {
        CXXCtorInitializer /*P*/ Value = Info.AllBaseFields.lookup(VBase.getType().$arrow().getAs$RecordType());
        if ((Value != null)) {
          // [class.base.init]p7, per DR257:
          //   A mem-initializer where the mem-initializer-id names a virtual base
          //   class is ignored during execution of a constructor of any class that
          //   is not the most derived class.
          if (ClassDecl.isAbstract()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // FIXME: Provide a fixit to remove the base specifier. This requires
              // tracking the location of the associated comma for a base specifier.
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Value.getSourceLocation(), diag.warn_abstract_vbase_init_ignored)), 
                      VBase.getType()), ClassDecl));
              $this().DiagnoseAbstractType(ClassDecl);
            } finally {
              $c$.$destroy();
            }
          }
          
          Info.AllToInit.push_back(Value);
        } else if (!AnyErrors && !ClassDecl.isAbstract()) {
          // [class.base.init]p8, per DR257:
          //   If a given [...] base class is not named by a mem-initializer-id
          //   [...] and the entity is not a virtual base class of an abstract
          //   class, then [...] the entity is default-initialized.
          boolean IsInheritedVirtualBase = !(DirectVBases.count($AddrOf(VBase)) != 0);
          type$ref<CXXCtorInitializer /*P*/ > CXXBaseInit = create_type$ref();
          if (BuildImplicitBaseInitializer(/*Deref*/$this(), Constructor, Info.IIK, 
              $AddrOf(VBase), IsInheritedVirtualBase, 
              CXXBaseInit)) {
            HadError = true;
            continue;
          }
          
          Info.AllToInit.push_back(CXXBaseInit.$deref());
        }
      }
    }
    
    // Non-virtual bases.
    for (final CXXBaseSpecifier /*&*/ Base : ClassDecl.bases()) {
      // Virtuals are in the virtual base list and already constructed.
      if (Base.isVirtual()) {
        continue;
      }
      {
        
        CXXCtorInitializer /*P*/ Value = Info.AllBaseFields.lookup(Base.getType().$arrow().getAs$RecordType());
        if ((Value != null)) {
          Info.AllToInit.push_back(Value);
        } else if (!AnyErrors) {
          type$ref<CXXCtorInitializer /*P*/ > CXXBaseInit = create_type$ref();
          if (BuildImplicitBaseInitializer(/*Deref*/$this(), Constructor, Info.IIK, 
              $AddrOf(Base), /*IsInheritedVirtualBase=*/ false, 
              CXXBaseInit)) {
            HadError = true;
            continue;
          }
          
          Info.AllToInit.push_back(CXXBaseInit.$deref());
        }
      }
    }
    
    // Fields.
    for (Decl /*P*/ Mem : ClassDecl.decls()) {
      {
        FieldDecl /*P*/ F = dyn_cast_FieldDecl(Mem);
        if ((F != null)) {
          // C++ [class.bit]p2:
          //   A declaration for a bit-field that omits the identifier declares an
          //   unnamed bit-field. Unnamed bit-fields are not members and cannot be
          //   initialized.
          if (F.isUnnamedBitfield()) {
            continue;
          }
          
          // If we're not generating the implicit copy/move constructor, then we'll
          // handle anonymous struct/union fields based on their individual
          // indirect fields.
          if (F.isAnonymousStructOrUnion() && !Info.isImplicitCopyOrMove()) {
            continue;
          }
          if (CollectFieldInitializer(/*Deref*/$this(), Info, F)) {
            HadError = true;
          }
          continue;
        }
      }
      
      // Beyond this point, we only consider default initialization.
      if (Info.isImplicitCopyOrMove()) {
        continue;
      }
      {
        
        IndirectFieldDecl /*P*/ F = dyn_cast_IndirectFieldDecl(Mem);
        if ((F != null)) {
          if (F.getType().$arrow().isIncompleteArrayType()) {
            assert (ClassDecl.hasFlexibleArrayMember()) : "Incomplete array type is not valid";
            continue;
          }
          
          // Initialize each field of an anonymous struct individually.
          if (CollectFieldInitializer(/*Deref*/$this(), Info, F.getAnonField(), F)) {
            HadError = true;
          }
          
          continue;
        }
      }
    }
    
    /*uint*/int NumInitializers = Info.AllToInit.size();
    if ($greater_uint(NumInitializers, 0)) {
      Constructor.setNumCtorInitializers(NumInitializers);
      type$ptr<CXXCtorInitializer /*P*/ /*P*/> baseOrMemberInitializers = create_const_type$ptr(/*FIXME:NEW_EXPR*//*new (Context)*/ new CXXCtorInitializer /*P*/ [NumInitializers]);
      memcpy(baseOrMemberInitializers, Info.AllToInit.data(), 
          NumInitializers * (true ? 1 : $sizeof_ptr(/*CXXCtorInitializer  */)), true);
      Constructor.setCtorInitializers(baseOrMemberInitializers);
      
      // Constructors implicitly reference the base and member
      // destructors.
      $this().MarkBaseAndMemberDestructorsReferenced(Constructor.getLocation(), 
          Constructor.getParent());
    }
    
    return HadError;
  } finally {
    if (Info != null) { Info.$destroy(); }
  }
}


/// SetIvarInitializers - This routine builds initialization ASTs for the
/// Objective-C implementation whose ivars need be initialized.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SetIvarInitializers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13583,
 FQN="clang::Sema::SetIvarInitializers", NM="_ZN5clang4Sema19SetIvarInitializersEPNS_22ObjCImplementationDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema19SetIvarInitializersEPNS_22ObjCImplementationDeclE")
//</editor-fold>
public final void SetIvarInitializers(ObjCImplementationDecl /*P*/ ObjCImplementation) {
  if (!$this().getLangOpts().CPlusPlus) {
    return;
  }
  {
    ObjCInterfaceDecl /*P*/ OID = ObjCImplementation.getClassInterface();
    if ((OID != null)) {
      SmallVector<ObjCIvarDecl /*P*/ > ivars/*J*/= new SmallVector<ObjCIvarDecl /*P*/ >(8, (ObjCIvarDecl /*P*/ )null);
      $this().CollectIvarsToConstructOrDestruct(OID, ivars);
      if (ivars.empty()) {
        return;
      }
      SmallVector<CXXCtorInitializer /*P*/ > AllToInit/*J*/= new SmallVector<CXXCtorInitializer /*P*/ >(32, (CXXCtorInitializer /*P*/ )null);
      for (/*uint*/int i = 0; $less_uint(i, ivars.size()); i++) {
        InitializationSequence InitSeq = null;
        try {
          FieldDecl /*P*/ Field = ivars.$at(i);
          if (Field.isInvalidDecl()) {
            continue;
          }
          
          CXXCtorInitializer /*P*/ Member;
          InitializedEntity InitEntity = InitializedEntity.InitializeMember(Field);
          InitializationKind InitKind = InitializationKind.CreateDefault(ObjCImplementation.getLocation());
          
          InitSeq/*J*/= new InitializationSequence(/*Deref*/$this(), InitEntity, InitKind, new MutableArrayRef<Expr /*P*/ >(None, true));
          ActionResultTTrue<Expr /*P*/ > MemberInit = InitSeq.Perform(/*Deref*/$this(), InitEntity, InitKind, new MutableArrayRef<Expr /*P*/ >(None, true));
          MemberInit.$assignMove($this().MaybeCreateExprWithCleanups(new ActionResultTTrue<Expr /*P*/ >(MemberInit)));
          // Note, MemberInit could actually come back empty if no initialization 
          // is required (e.g., because it would call a trivial default constructor)
          if (!(MemberInit.get() != null) || MemberInit.isInvalid()) {
            continue;
          }
          
          Member
             = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
          /*new (Context)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
              return new CXXCtorInitializer($this().Context, Field, new SourceLocation(), 
                      new SourceLocation(), 
                      MemberInit.getAs(Expr.class), 
                      new SourceLocation());
           });
          AllToInit.push_back(Member);
          {
            
            // Be sure that the destructor is accessible and is marked as referenced.
            /*const*/ RecordType /*P*/ RecordTy = $this().Context.getBaseElementType(Field.getType()).$arrow().
                getAs$RecordType();
            if ((RecordTy != null)) {
              CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(RecordTy.getDecl());
              {
                CXXDestructorDecl /*P*/ Destructor = $this().LookupDestructor(RD);
                if ((Destructor != null)) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    $this().MarkFunctionReferenced(Field.getLocation(), Destructor);
                    $c$.clean($this().CheckDestructorAccess(Field.getLocation(), Destructor, 
                        $out_PartialDiagnostic$C_QualType($c$.track($this().PDiag(diag.err_access_dtor_ivar)), 
                            $this().Context.getBaseElementType(Field.getType()))));
                  } finally {
                    $c$.$destroy();
                  }
                }
              }
            }
          }
        } finally {
          if (InitSeq != null) { InitSeq.$destroy(); }
        }
      }
      ObjCImplementation.setIvarInitializers($this().Context, 
          AllToInit.data(), AllToInit.size());
    }
  }
}


/// MarkBaseAndMemberDestructorsReferenced - Given a record decl,
/// mark all the non-trivial destructors of its members and bases as
/// referenced.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MarkBaseAndMemberDestructorsReferenced">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4273,
 FQN="clang::Sema::MarkBaseAndMemberDestructorsReferenced", NM="_ZN5clang4Sema38MarkBaseAndMemberDestructorsReferencedENS_14SourceLocationEPNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema38MarkBaseAndMemberDestructorsReferencedENS_14SourceLocationEPNS_13CXXRecordDeclE")
//</editor-fold>
public final void MarkBaseAndMemberDestructorsReferenced(SourceLocation Location, 
                                      CXXRecordDecl /*P*/ ClassDecl) {
  // Ignore dependent contexts. Also ignore unions, since their members never
  // have destructors implicitly called.
  if (ClassDecl.isDependentContext() || ClassDecl.isUnion()) {
    return;
  }
  
  // FIXME: all the access-control diagnostics are positioned on the
  // field/base declaration.  That's probably good; that said, the
  // user might reasonably want to know why the destructor is being
  // emitted, and we currently don't say.
  
  // Non-static data members.
  for (FieldDecl /*P*/ Field : ClassDecl.fields()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (Field.isInvalidDecl()) {
        continue;
      }
      
      // Don't destroy incomplete or zero-length arrays.
      if (isIncompleteOrZeroLengthArrayType($this().Context, Field.getType())) {
        continue;
      }
      
      QualType FieldType = $this().Context.getBaseElementType(Field.getType());
      
      /*const*/ RecordType /*P*/ RT = FieldType.$arrow().getAs$RecordType();
      if (!(RT != null)) {
        continue;
      }
      
      CXXRecordDecl /*P*/ FieldClassDecl = cast_CXXRecordDecl(RT.getDecl());
      if (FieldClassDecl.isInvalidDecl()) {
        continue;
      }
      if (FieldClassDecl.hasIrrelevantDestructor()) {
        continue;
      }
      // The destructor for an implicit anonymous union member is never invoked.
      if (FieldClassDecl.isUnion() && FieldClassDecl.isAnonymousStructOrUnion()) {
        continue;
      }
      
      CXXDestructorDecl /*P*/ Dtor = $this().LookupDestructor(FieldClassDecl);
      assert ((Dtor != null)) : "No dtor found for FieldClassDecl!";
      $c$.clean($this().CheckDestructorAccess(Field.getLocation(), Dtor, 
          $out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_DeclarationName($c$.track($this().PDiag(diag.err_access_dtor_field)), 
                  Field.getDeclName()), 
              /*NO_COPY*/FieldType)));
      
      $this().MarkFunctionReferenced(new SourceLocation(Location), Dtor);
      $this().DiagnoseUseOfDecl(Dtor, new SourceLocation(Location));
    } finally {
      $c$.$destroy();
    }
  }
  
  SmallPtrSet</*const*/ RecordType /*P*/ > DirectVirtualBases/*J*/= new SmallPtrSet</*const*/ RecordType /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
  
  // Bases.
  for (final /*const*/ CXXBaseSpecifier /*&*/ Base : ClassDecl.bases()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Bases are always records in a well-formed non-dependent class.
      /*const*/ RecordType /*P*/ RT = Base.getType().$arrow().getAs$RecordType();
      
      // Remember direct virtual bases.
      if (Base.isVirtual()) {
        DirectVirtualBases.insert(RT);
      }
      
      CXXRecordDecl /*P*/ BaseClassDecl = cast_CXXRecordDecl(RT.getDecl());
      // If our base class is invalid, we probably can't get its dtor anyway.
      if (BaseClassDecl.isInvalidDecl()) {
        continue;
      }
      if (BaseClassDecl.hasIrrelevantDestructor()) {
        continue;
      }
      
      CXXDestructorDecl /*P*/ Dtor = $this().LookupDestructor(BaseClassDecl);
      assert ((Dtor != null)) : "No dtor found for BaseClassDecl!";
      
      // FIXME: caret should be on the start of the class name
      $c$.clean($this().CheckDestructorAccess(Base.getLocStart(), Dtor, 
          $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_QualType($c$.track($this().PDiag(diag.err_access_dtor_base)), 
                  Base.getType()), 
              Base.getSourceRange()), 
          $this().Context.getTypeDeclType(ClassDecl)));
      
      $this().MarkFunctionReferenced(new SourceLocation(Location), Dtor);
      $this().DiagnoseUseOfDecl(Dtor, new SourceLocation(Location));
    } finally {
      $c$.$destroy();
    }
  }
  
  // Virtual bases.
  for (final /*const*/ CXXBaseSpecifier /*&*/ VBase : ClassDecl.vbases()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Bases are always records in a well-formed non-dependent class.
      /*const*/ RecordType /*P*/ RT = VBase.getType().$arrow().castAs$RecordType();
      
      // Ignore direct virtual bases.
      if ((DirectVirtualBases.count(RT) != 0)) {
        continue;
      }
      
      CXXRecordDecl /*P*/ BaseClassDecl = cast_CXXRecordDecl(RT.getDecl());
      // If our base class is invalid, we probably can't get its dtor anyway.
      if (BaseClassDecl.isInvalidDecl()) {
        continue;
      }
      if (BaseClassDecl.hasIrrelevantDestructor()) {
        continue;
      }
      
      CXXDestructorDecl /*P*/ Dtor = $this().LookupDestructor(BaseClassDecl);
      assert ((Dtor != null)) : "No dtor found for BaseClassDecl!";
      if ($c$.clean($this().CheckDestructorAccess(ClassDecl.getLocation(), Dtor, 
          $out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_QualType($c$.track($this().PDiag(diag.err_access_dtor_vbase)), 
                  $this().Context.getTypeDeclType(ClassDecl)), VBase.getType()), 
          $this().Context.getTypeDeclType(ClassDecl))
         == AccessResult.AR_accessible)) {
        $this().CheckDerivedToBaseConversion($this().Context.getTypeDeclType(ClassDecl), VBase.getType(), 
            diag.err_access_dtor_vbase, 0, ClassDecl.getLocation(), 
            new SourceRange(), new DeclarationName(), (SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null);
      }
      
      $this().MarkFunctionReferenced(new SourceLocation(Location), Dtor);
      $this().DiagnoseUseOfDecl(Dtor, new SourceLocation(Location));
    } finally {
      $c$.$destroy();
    }
  }
}


/// \brief Load any externally-stored vtable uses.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LoadExternalVTableUses">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13373,
 FQN="clang::Sema::LoadExternalVTableUses", NM="_ZN5clang4Sema22LoadExternalVTableUsesEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema22LoadExternalVTableUsesEv")
//</editor-fold>
public final void LoadExternalVTableUses() {
  if (!($this().ExternalSource != null)) {
    return;
  }
  
  SmallVector<ExternalVTableUse> VTables/*J*/= new SmallVector<ExternalVTableUse>(4, new ExternalVTableUse());
  $this().ExternalSource.ReadUsedVTables(VTables);
  SmallVector<std.pair<CXXRecordDecl /*P*/ , SourceLocation>> NewUses/*J*/= new SmallVector<std.pair<CXXRecordDecl /*P*/ , SourceLocation>>(4, new std.pairPtrType<CXXRecordDecl /*P*/ , SourceLocation>(null, new SourceLocation()));
  for (/*uint*/int I = 0, N = VTables.size(); I != N; ++I) {
    DenseMapIteratorTypeBool<CXXRecordDecl /*P*/ /*P*/> Pos = $this().VTablesUsed.find(VTables.$at(I).Record);
    // Even if a definition wasn't required before, it may be required now.
    if (Pos.$noteq(/*NO_ITER_COPY*/$this().VTablesUsed.end())) {
      if (!Pos.$arrow().second && VTables.$at(I).DefinitionRequired) {
        Pos.$arrow().second = true;
      }
      continue;
    }
    
    $this().VTablesUsed.$set(VTables.$at(I).Record, VTables.$at(I).DefinitionRequired);
    NewUses.push_back(new std.pairPtrType<CXXRecordDecl /*P*/ , SourceLocation>(JD$T$RR_T1$RR.INSTANCE, VTables.$at(I).Record, VTables.$at(I).Location));
  }
  
  $this().VTableUses.insert$T$value_T($this().VTableUses.begin(), NewUses.begin(), NewUses.end());
}


/// \brief Note that the vtable for the given class was used at the
/// given location.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MarkVTableUsed">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13397,
 FQN="clang::Sema::MarkVTableUsed", NM="_ZN5clang4Sema14MarkVTableUsedENS_14SourceLocationEPNS_13CXXRecordDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema14MarkVTableUsedENS_14SourceLocationEPNS_13CXXRecordDeclEb")
//</editor-fold>
public final void MarkVTableUsed(SourceLocation Loc, CXXRecordDecl /*P*/ Class) {
  MarkVTableUsed(Loc, Class, 
              false);
}
public final void MarkVTableUsed(SourceLocation Loc, CXXRecordDecl /*P*/ Class, 
              boolean DefinitionRequired/*= false*/) {
  // Ignore any vtable uses in unevaluated operands or for classes that do
  // not have a vtable.
  if (!Class.isDynamicClass() || Class.isDependentContext()
     || $this().CurContext.isDependentContext() || $this().isUnevaluatedContext()) {
    return;
  }
  
  // Try to insert this class into the map.
  $this().LoadExternalVTableUses();
  Class = cast_CXXRecordDecl(Class.getCanonicalDecl());
  std.pairTypeBool<DenseMapIteratorTypeBool<CXXRecordDecl /*P*/ /*P*/>> Pos = $this().VTablesUsed.insert_pair$KeyT$ValueT(std.make_pair_Ptr_bool(Class, DefinitionRequired));
  if (!Pos.second) {
    // If we already had an entry, check to see if we are promoting this vtable
    // to require a definition. If so, we need to reappend to the VTableUses
    // list, since we may have already processed the first entry.
    if (DefinitionRequired && !Pos.first.$arrow().second) {
      Pos.first.$arrow().second = true;
    } else {
      // Otherwise, we can early exit.
      return;
    }
  } else {
    // The Microsoft ABI requires that we perform the destructor body
    // checks (i.e. operator delete() lookup) when the vtable is marked used, as
    // the deleting destructor is emitted with the vtable, not with the
    // destructor definition as in the Itanium ABI.
    if ($this().Context.getTargetInfo().getCXXABI().isMicrosoft()) {
      CXXDestructorDecl /*P*/ DD = Class.getDestructor();
      if ((DD != null) && DD.isVirtual() && !DD.isDeleted()) {
        if (Class.hasUserDeclaredDestructor() && !DD.isDefined()) {
          ContextRAII SavedContext = null;
          try {
            // If this is an out-of-line declaration, marking it referenced will
            // not do anything. Manually call CheckDestructor to look up operator
            // delete().
            SavedContext/*J*/= new ContextRAII(/*Deref*/$this(), DD);
            $this().CheckDestructor(DD);
          } finally {
            if (SavedContext != null) { SavedContext.$destroy(); }
          }
        } else {
          $this().MarkFunctionReferenced(new SourceLocation(Loc), Class.getDestructor());
        }
      }
    }
  }
  
  // Local classes need to have their virtual members marked
  // immediately. For all other classes, we mark their virtual members
  // at the end of the translation unit.
  if ((Class.isLocalClass() != null)) {
    $this().MarkVirtualMembersReferenced(new SourceLocation(Loc), Class);
  } else {
    $this().VTableUses.push_back(std.make_pair_Ptr_T(Class, $Clone(Loc)));
  }
}


/// \brief Mark the exception specifications of all virtual member functions
/// in the given class as needed.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MarkVirtualMemberExceptionSpecsNeeded">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13540,
 FQN="clang::Sema::MarkVirtualMemberExceptionSpecsNeeded", NM="_ZN5clang4Sema37MarkVirtualMemberExceptionSpecsNeededENS_14SourceLocationEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema37MarkVirtualMemberExceptionSpecsNeededENS_14SourceLocationEPKNS_13CXXRecordDeclE")
//</editor-fold>
public final void MarkVirtualMemberExceptionSpecsNeeded(SourceLocation Loc, 
                                     /*const*/ CXXRecordDecl /*P*/ RD) {
  for (/*const*/ CXXMethodDecl /*P*/ I : RD.methods())  {
    if (I.isVirtual() && !I.isPure()) {
      $this().ResolveExceptionSpec(new SourceLocation(Loc), I.getType().$arrow().castAs(FunctionProtoType.class));
    }
  }
}


/// MarkVirtualMembersReferenced - Will mark all members of the given
/// CXXRecordDecl referenced.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MarkVirtualMembersReferenced">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13547,
 FQN="clang::Sema::MarkVirtualMembersReferenced", NM="_ZN5clang4Sema28MarkVirtualMembersReferencedENS_14SourceLocationEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema28MarkVirtualMembersReferencedENS_14SourceLocationEPKNS_13CXXRecordDeclE")
//</editor-fold>
public final void MarkVirtualMembersReferenced(SourceLocation Loc, 
                            /*const*/ CXXRecordDecl /*P*/ RD) {
  CXXFinalOverriderMap FinalOverriders = null;
  try {
    // Mark all functions which will appear in RD's vtable as used.
    FinalOverriders/*J*/= new CXXFinalOverriderMap();
    RD.getFinalOverriders(FinalOverriders);
    for (std.vector.iterator<std.pairPtrType</*const*/ CXXMethodDecl /*P*/ , OverridingMethods> > I = FinalOverriders.begin(), 
        E = FinalOverriders.end();
         $noteq___normal_iterator$C(I, E); I.$preInc()) {
      for (std.vector.iterator<pairUIntType<SmallVector<UniqueVirtualMethod>>> OI = I.$arrow().second.begin$Const(), 
          OE = I.$arrow().second.end$Const();
           $noteq___normal_iterator$C(OI, OE); OI.$preInc()) {
        assert ($greater_uint(OI.$arrow().second.size(), 0)) : "no final overrider";
        CXXMethodDecl /*P*/ Overrider = OI.$arrow().second.front$Const().Method;
        
        // C++ [basic.def.odr]p2:
        //   [...] A virtual member function is used if it is not pure. [...]
        if (!Overrider.isPure()) {
          $this().MarkFunctionReferenced(new SourceLocation(Loc), Overrider);
        }
      }
    }
    
    // Only classes that have virtual bases need a VTT.
    if (RD.getNumVBases() == 0) {
      return;
    }
    
    for (final /*const*/ CXXBaseSpecifier /*&*/ I : RD.bases$Const()) {
      /*const*/ CXXRecordDecl /*P*/ Base = cast_CXXRecordDecl(I.getType().$arrow().getAs$RecordType().getDecl());
      if (Base.getNumVBases() == 0) {
        continue;
      }
      $this().MarkVirtualMembersReferenced(new SourceLocation(Loc), Base);
    }
  } finally {
    if (FinalOverriders != null) { FinalOverriders.$destroy(); }
  }
}


/// \brief Define all of the vtables that have been used in this
/// translation unit and reference any virtual members used by those
/// vtables.
///
/// \returns true if any work was done, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DefineUsedVTables">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13450,
 FQN="clang::Sema::DefineUsedVTables", NM="_ZN5clang4Sema17DefineUsedVTablesEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema17DefineUsedVTablesEv")
//</editor-fold>
public final boolean DefineUsedVTables() {
  $this().LoadExternalVTableUses();
  if ($this().VTableUses.empty()) {
    return false;
  }
  
  // Note: The VTableUses vector could grow as a result of marking
  // the members of a class as "used", so we check the size each
  // time through the loop and prefer indices (which are stable) to
  // iterators (which are not).
  boolean DefinedAnything = false;
  for (/*uint*/int I = 0; I != $this().VTableUses.size(); ++I) {
    CXXRecordDecl /*P*/ Class = $this().VTableUses.$at(I).first.getDefinition();
    if (!(Class != null)) {
      continue;
    }
    
    SourceLocation Loc = new SourceLocation($this().VTableUses.$at(I).second);
    
    boolean DefineVTable = true;
    
    // If this class has a key function, but that key function is
    // defined in another translation unit, we don't need to emit the
    // vtable even though we're using it.
    /*const*/ CXXMethodDecl /*P*/ KeyFunction = $this().Context.getCurrentKeyFunction(Class);
    if ((KeyFunction != null) && !KeyFunction.hasBody()) {
      // The key function is in another translation unit.
      DefineVTable = false;
      TemplateSpecializationKind TSK = KeyFunction.getTemplateSpecializationKind();
      assert (TSK != TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition && TSK != TemplateSpecializationKind.TSK_ImplicitInstantiation) : "Instantiations don't have key functions";
      ///*J:(void)*/TSK;
    } else if (!(KeyFunction != null)) {
      // If we have a class with no key function that is the subject
      // of an explicit instantiation declaration, suppress the
      // vtable; it will live with the explicit instantiation
      // definition.
      boolean IsExplicitInstantiationDeclaration = Class.getTemplateSpecializationKind()
         == TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration;
      for (TagDecl /*P*/ R : Class.redeclarable_redecls()) {
        TemplateSpecializationKind TSK = cast_CXXRecordDecl(R).getTemplateSpecializationKind();
        if (TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration) {
          IsExplicitInstantiationDeclaration = true;
        } else if (TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition) {
          IsExplicitInstantiationDeclaration = false;
          break;
        }
      }
      if (IsExplicitInstantiationDeclaration) {
        DefineVTable = false;
      }
    }
    
    // The exception specifications for all virtual members may be needed even
    // if we are not providing an authoritative form of the vtable in this TU.
    // We may choose to emit it available_externally anyway.
    if (!DefineVTable) {
      $this().MarkVirtualMemberExceptionSpecsNeeded(new SourceLocation(Loc), Class);
      continue;
    }
    
    // Mark all of the virtual members of this class as referenced, so
    // that we can build a vtable. Then, tell the AST consumer that a
    // vtable for this class is required.
    DefinedAnything = true;
    $this().MarkVirtualMembersReferenced(new SourceLocation(Loc), Class);
    CXXRecordDecl /*P*/ Canonical = cast_CXXRecordDecl(Class.getCanonicalDecl());
    if ($this().VTablesUsed.$at_T1$C$R(Canonical)) {
      $this().Consumer.HandleVTable(Class);
    }
    
    // Optionally warn if we're emitting a weak vtable.
    if (Class.isExternallyVisible()
       && Class.getTemplateSpecializationKind() != TemplateSpecializationKind.TSK_ImplicitInstantiation) {
      type$ref</*const*/ FunctionDecl /*P*/ > KeyFunctionDef = create_type$null$ref(null);
      if (!(KeyFunction != null)
         || (KeyFunction.hasBody(KeyFunctionDef)
         && KeyFunctionDef.$deref().isInlined())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Class.getLocation(), Class.getTemplateSpecializationKind()
                     == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition ? diag.warn_weak_template_vtable : diag.warn_weak_vtable)), 
              Class));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  $this().VTableUses.clear();
  
  return DefinedAnything;
}


/// AddImplicitlyDeclaredMembersToClass - Adds any implicitly-declared
/// special functions, such as the default constructor, copy
/// constructor, or destructor, to the given C++ class (C++
/// [special]p1).  This routine can only be executed just before the
/// definition of the class is complete.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddImplicitlyDeclaredMembersToClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6604,
 FQN="clang::Sema::AddImplicitlyDeclaredMembersToClass", NM="_ZN5clang4Sema35AddImplicitlyDeclaredMembersToClassEPNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema35AddImplicitlyDeclaredMembersToClassEPNS_13CXXRecordDeclE")
//</editor-fold>
public final void AddImplicitlyDeclaredMembersToClass(CXXRecordDecl /*P*/ ClassDecl) {
  if (ClassDecl.needsImplicitDefaultConstructor()) {
    ++ASTContext.NumImplicitDefaultConstructors;
    if (ClassDecl.hasInheritedConstructor()) {
      $this().DeclareImplicitDefaultConstructor(ClassDecl);
    }
  }
  if (ClassDecl.needsImplicitCopyConstructor()) {
    ++ASTContext.NumImplicitCopyConstructors;
    
    // If the properties or semantics of the copy constructor couldn't be
    // determined while the class was being declared, force a declaration
    // of it now.
    if (ClassDecl.needsOverloadResolutionForCopyConstructor()
       || ClassDecl.hasInheritedConstructor()) {
      $this().DeclareImplicitCopyConstructor(ClassDecl);
    }
  }
  if ($this().getLangOpts().CPlusPlus11 && ClassDecl.needsImplicitMoveConstructor()) {
    ++ASTContext.NumImplicitMoveConstructors;
    if (ClassDecl.needsOverloadResolutionForMoveConstructor()
       || ClassDecl.hasInheritedConstructor()) {
      $this().DeclareImplicitMoveConstructor(ClassDecl);
    }
  }
  if (ClassDecl.needsImplicitCopyAssignment()) {
    ++ASTContext.NumImplicitCopyAssignmentOperators;
    
    // If we have a dynamic class, then the copy assignment operator may be
    // virtual, so we have to declare it immediately. This ensures that, e.g.,
    // it shows up in the right place in the vtable and that we diagnose
    // problems with the implicit exception specification.
    if (ClassDecl.isDynamicClass()
       || ClassDecl.needsOverloadResolutionForCopyAssignment()
       || ClassDecl.hasInheritedAssignment()) {
      $this().DeclareImplicitCopyAssignment(ClassDecl);
    }
  }
  if ($this().getLangOpts().CPlusPlus11 && ClassDecl.needsImplicitMoveAssignment()) {
    ++ASTContext.NumImplicitMoveAssignmentOperators;
    
    // Likewise for the move assignment operator.
    if (ClassDecl.isDynamicClass()
       || ClassDecl.needsOverloadResolutionForMoveAssignment()
       || ClassDecl.hasInheritedAssignment()) {
      $this().DeclareImplicitMoveAssignment(ClassDecl);
    }
  }
  if (ClassDecl.needsImplicitDestructor()) {
    ++ASTContext.NumImplicitDestructors;
    
    // If we have a dynamic class, then the destructor may be virtual, so we
    // have to declare the destructor immediately. This ensures that, e.g., it
    // shows up in the right place in the vtable and that we diagnose problems
    // with the implicit exception specification.
    if (ClassDecl.isDynamicClass()
       || ClassDecl.needsOverloadResolutionForDestructor()) {
      $this().DeclareImplicitDestructor(ClassDecl);
    }
  }
}


/// ActOnMemInitializers - Handle the member initializers for a constructor.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnMemInitializers">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*ref$at*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4207,
 FQN="clang::Sema::ActOnMemInitializers", NM="_ZN5clang4Sema20ActOnMemInitializersEPNS_4DeclENS_14SourceLocationEN4llvm8ArrayRefIPNS_18CXXCtorInitializerEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema20ActOnMemInitializersEPNS_4DeclENS_14SourceLocationEN4llvm8ArrayRefIPNS_18CXXCtorInitializerEEEb")
//</editor-fold>
public final void ActOnMemInitializers(Decl /*P*/ _ConstructorDecl, 
                    SourceLocation ColonLoc, 
                    ArrayRef<CXXCtorInitializer /*P*/ > MemInits, 
                    boolean AnyErrors) {
  type$ref<Decl /*P*/> ConstructorDecl = create_type$ref(_ConstructorDecl);
  if (!(ConstructorDecl.$deref() != null)) {
    return;
  }
  
  $this().AdjustDeclIfTemplate(ConstructorDecl);
  
  CXXConstructorDecl /*P*/ Constructor = dyn_cast_CXXConstructorDecl(ConstructorDecl.$deref());
  if (!(Constructor != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(ColonLoc), diag.err_only_constructors_take_base_inits)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Mapping for the duplicate initializers check.
  // For member initializers, this is keyed with a FieldDecl*.
  // For base initializers, this is keyed with a Type*.
  DenseMap</*const*/Object/*void P*/, CXXCtorInitializer /*P*/ > Members/*J*/= new DenseMap</*const*/Object/*void P*/, CXXCtorInitializer /*P*/ >(DenseMapInfo$LikePtr.$Info(), (CXXCtorInitializer /*P*/ )null);
  
  // Mapping for the inconsistent anonymous-union initializers check.
  DenseMap<RecordDecl /*P*/ , std.pair<NamedDecl /*P*/ , CXXCtorInitializer /*P*/ >> MemberUnions/*J*/= new DenseMap<RecordDecl /*P*/ , std.pair<NamedDecl /*P*/ , CXXCtorInitializer /*P*/ >>(DenseMapInfo$LikePtr.$Info(), new std.pairPtrPtr<NamedDecl /*P*/ , CXXCtorInitializer /*P*/ >());
  
  boolean HadError = false;
  for (/*uint*/int i = 0; $less_uint(i, MemInits.size()); i++) {
    CXXCtorInitializer /*P*/ Init = MemInits.$at(i);
    
    // Set the source order index.
    Init.setSourceOrder(i);
    if (Init.isAnyMemberInitializer()) {
      /*const*/Object/*void P*/ Key = GetKeyForMember($this().Context, Init);
      if (CheckRedundantInit(/*Deref*/$this(), Init, Members.ref$at(Key))
         || CheckRedundantUnionInit(/*Deref*/$this(), Init, MemberUnions)) {
        HadError = true;
      }
    } else if (Init.isBaseInitializer()) {
      /*const*/Object/*void P*/ Key = GetKeyForMember($this().Context, Init);
      if (CheckRedundantInit(/*Deref*/$this(), Init, Members.ref$at(Key))) {
        HadError = true;
      }
    } else {
      assert (Init.isDelegatingInitializer());
      // This must be the only initializer
      if (MemInits.size() != 1) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Init.getSourceLocation(), 
                      diag.err_delegating_initializer_alone)), 
                  Init.getSourceRange()), MemInits.$at((i != 0) ? 0 : 1).getSourceRange()));
        } finally {
          $c$.$destroy();
        }
        // We will treat this as being the only initializer.
      }
      $this().SetDelegatingInitializer(Constructor, MemInits.$at(i));
      // Return immediately as the initializer is set.
      return;
    }
  }
  if (HadError) {
    return;
  }
  
  DiagnoseBaseOrMemInitializerOrder(/*Deref*/$this(), Constructor, new ArrayRef<CXXCtorInitializer /*P*/ >(MemInits));
  
  $this().SetCtorInitializers(Constructor, AnyErrors, new ArrayRef<CXXCtorInitializer /*P*/ >(MemInits));
  
  DiagnoseUninitializedFields(/*Deref*/$this(), Constructor);
}


/// \brief Check class-level dllimport/dllexport attribute. The caller must
/// ensure that referenceDLLExportedClassMethods is called some point later
/// when all outer classes of Class are complete.

/// \brief Check class-level dllimport/dllexport attribute.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkClassLevelDLLAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4702,
 FQN="clang::Sema::checkClassLevelDLLAttribute", NM="_ZN5clang4Sema27checkClassLevelDLLAttributeEPNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema27checkClassLevelDLLAttributeEPNS_13CXXRecordDeclE")
//</editor-fold>
public final void checkClassLevelDLLAttribute(CXXRecordDecl /*P*/ Class) {
  Attr /*P*/ ClassAttr = getDLLAttr(Class);
  
  // MSVC inherits DLL attributes to partial class template specializations.
  if ($this().Context.getTargetInfo().getCXXABI().isMicrosoft() && !(ClassAttr != null)) {
    {
      ClassTemplatePartialSpecializationDecl /*P*/ Spec = dyn_cast_ClassTemplatePartialSpecializationDecl(Class);
      if ((Spec != null)) {
        {
          Attr /*P*/ TemplateAttr = getDLLAttr(Spec.getSpecializedTemplate().getTemplatedDecl());
          if ((TemplateAttr != null)) {
            InheritableAttr /*P*/ A = cast_InheritableAttr(TemplateAttr.clone($this().getASTContext()));
            A.setInherited(true);
            ClassAttr = A;
          }
        }
      }
    }
  }
  if (!(ClassAttr != null)) {
    return;
  }
  if (!Class.isExternallyVisible()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Class.getLocation(), diag.err_attribute_dll_not_extern)), 
              Class), ClassAttr));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if ($this().Context.getTargetInfo().getCXXABI().isMicrosoft()
     && !ClassAttr.isInherited()) {
    // Diagnose dll attributes on members of class with dll attribute.
    for (Decl /*P*/ Member : Class.decls()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        if (!isa_VarDecl(Member) && !isa_CXXMethodDecl(Member)) {
          continue;
        }
        InheritableAttr /*P*/ MemberAttr = getDLLAttr(Member);
        if (!(MemberAttr != null) || MemberAttr.isInherited() || Member.isInvalidDecl()) {
          continue;
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MemberAttr.getLocation(), 
                    diag.err_attribute_dll_member_of_dll_class)), 
                MemberAttr), ClassAttr));
        $c$.clean($c$.track($this().Diag(ClassAttr.getLocation(), diag.note_previous_attribute)));
        Member.setInvalidDecl();
      } finally {
        $c$.$destroy();
      }
    }
  }
  if ((Class.getDescribedClassTemplate() != null)) {
    // Don't inherit dll attribute until the template is instantiated.
    return;
  }
  
  // The class is either imported or exported.
  /*const*/boolean ClassExported = ClassAttr.getKind() == attr.Kind.DLLExport;
  
  TemplateSpecializationKind TSK = Class.getTemplateSpecializationKind();
  
  // Ignore explicit dllexport on explicit class template instantiation declarations.
  if (ClassExported && !ClassAttr.isInherited()
     && TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration) {
    Class.dropAttr(DLLExportAttr.class);
    return;
  }
  
  // Force declaration of implicit members so they can inherit the attribute.
  $this().ForceDeclarationOfImplicitMembers(Class);
  
  // FIXME: MSVC's docs say all bases must be exportable, but this doesn't
  // seem to be true in practice?
  for (Decl /*P*/ Member : Class.decls()) {
    VarDecl /*P*/ VD = dyn_cast_VarDecl(Member);
    CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(Member);
    
    // Only methods and static fields inherit the attributes.
    if (!(VD != null) && !(MD != null)) {
      continue;
    }
    if ((MD != null)) {
      // Don't process deleted methods.
      if (MD.isDeleted()) {
        continue;
      }
      if (MD.isInlined()) {
        // MinGW does not import or export inline methods.
        if (!$this().Context.getTargetInfo().getCXXABI().isMicrosoft()) {
          continue;
        }
        
        // MSVC versions before 2015 don't export the move assignment operators
        // and move constructor, so don't attempt to import/export them if
        // we have a definition.
        CXXConstructorDecl /*P*/ Ctor = dyn_cast_CXXConstructorDecl(MD);
        if ((MD.isMoveAssignmentOperator()
           || ((Ctor != null) && Ctor.isMoveConstructor()))
           && !$this().getLangOpts().isCompatibleWithMSVC(LangOptions.MSVCMajorVersion.MSVC2015)) {
          continue;
        }
        
        // MSVC2015 doesn't export trivial defaulted x-tor but copy assign
        // operator is exported anyway.
        if ($this().getLangOpts().isCompatibleWithMSVC(LangOptions.MSVCMajorVersion.MSVC2015)
           && ((Ctor != null) || isa_CXXDestructorDecl(MD)) && MD.isTrivial()) {
          continue;
        }
      }
    }
    if (!cast_NamedDecl(Member).isExternallyVisible()) {
      continue;
    }
    if (!(getDLLAttr(Member) != null)) {
      InheritableAttr /*P*/ NewAttr = cast_InheritableAttr(ClassAttr.clone($this().getASTContext()));
      NewAttr.setInherited(true);
      Member.addAttr(NewAttr);
    }
  }
  if (ClassExported) {
    $this().DelayedDllExportClasses.push_back(Class);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::referenceDLLExportedClassMethods">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9626,
 FQN="clang::Sema::referenceDLLExportedClassMethods", NM="_ZN5clang4Sema32referenceDLLExportedClassMethodsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema32referenceDLLExportedClassMethodsEv")
//</editor-fold>
public final void referenceDLLExportedClassMethods() {
  if (!$this().DelayedDllExportClasses.empty()) {
    // Calling ReferenceDllExportedMethods might cause the current function to
    // be called again, so use a local copy of DelayedDllExportClasses.
    SmallVector<CXXRecordDecl /*P*/ > WorkList/*J*/= new SmallVector<CXXRecordDecl /*P*/ >(4, (CXXRecordDecl /*P*/ )null);
    std.swap($this().DelayedDllExportClasses, WorkList);
    for (CXXRecordDecl /*P*/ Class : WorkList)  {
      ReferenceDllExportedMethods(/*Deref*/$this(), Class);
    }
  }
}


/// \brief Perform propagation of DLL attributes from a derived class to a
/// templated base class for MS compatibility.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::propagateDLLAttrToBaseClassTemplate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4818,
 FQN="clang::Sema::propagateDLLAttrToBaseClassTemplate", NM="_ZN5clang4Sema35propagateDLLAttrToBaseClassTemplateEPNS_13CXXRecordDeclEPNS_4AttrEPNS_31ClassTemplateSpecializationDeclENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema35propagateDLLAttrToBaseClassTemplateEPNS_13CXXRecordDeclEPNS_4AttrEPNS_31ClassTemplateSpecializationDeclENS_14SourceLocationE")
//</editor-fold>
public final void propagateDLLAttrToBaseClassTemplate(CXXRecordDecl /*P*/ Class, Attr /*P*/ ClassAttr, 
                                   ClassTemplateSpecializationDecl /*P*/ BaseTemplateSpec, SourceLocation BaseLoc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if ((getDLLAttr(BaseTemplateSpec.getSpecializedTemplate().getTemplatedDecl()) != null)) {
      // If the base class template has a DLL attribute, don't try to change it.
      return;
    }
    
    TemplateSpecializationKind TSK = BaseTemplateSpec.getSpecializationKind();
    if (!(getDLLAttr(BaseTemplateSpec) != null)
       && (TSK == TemplateSpecializationKind.TSK_Undeclared || TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration
       || TSK == TemplateSpecializationKind.TSK_ImplicitInstantiation)) {
      // The template hasn't been instantiated yet (or it has, but only as an
      // explicit instantiation declaration or implicit instantiation, which means
      // we haven't codegenned any members yet), so propagate the attribute.
      InheritableAttr /*P*/ NewAttr = cast_InheritableAttr(ClassAttr.clone($this().getASTContext()));
      NewAttr.setInherited(true);
      BaseTemplateSpec.addAttr(NewAttr);
      
      // If the template is already instantiated, checkDLLAttributeRedeclaration()
      // needs to be run again to work see the new attribute. Otherwise this will
      // get run whenever the template is instantiated.
      if (TSK != TemplateSpecializationKind.TSK_Undeclared) {
        $this().checkClassLevelDLLAttribute(BaseTemplateSpec);
      }
      
      return;
    }
    if ((getDLLAttr(BaseTemplateSpec) != null)) {
      // The template has already been specialized or instantiated with an
      // attribute, explicitly or through propagation. We should not try to change
      // it.
      return;
    }
    
    // The template was previously instantiated or explicitly specialized without
    // a dll attribute, It's too late for us to add an attribute, so warn that
    // this is unsupported.
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(BaseLoc), diag.warn_attribute_dll_instantiated_base_class)), 
        BaseTemplateSpec.isExplicitSpecialization()));
    $c$.clean($c$.track($this().Diag(ClassAttr.getLocation(), diag.note_attribute)));
    if (BaseTemplateSpec.isExplicitSpecialization()) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(BaseTemplateSpec.getLocation(), 
              diag.note_template_class_explicit_specialization_was_here)), 
          BaseTemplateSpec));
    } else {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(BaseTemplateSpec.getPointOfInstantiation(), 
              diag.note_template_class_instantiation_was_here)), 
          BaseTemplateSpec));
    }
  } finally {
    $c$.$destroy();
  }
}


/// \brief Perform semantic checks on a class definition that has been
/// completing, introducing implicitly-declared members, checking for
/// abstract types, etc.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckCompletedCXXClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4901,
 FQN="clang::Sema::CheckCompletedCXXClass", NM="_ZN5clang4Sema22CheckCompletedCXXClassEPNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema22CheckCompletedCXXClassEPNS_13CXXRecordDeclE")
//</editor-fold>
public final void CheckCompletedCXXClass(CXXRecordDecl /*P*/ Record) {
  if (!(Record != null)) {
    return;
  }
  if (Record.isAbstract() && !Record.isInvalidDecl()) {
    AbstractUsageInfo Info/*J*/= new AbstractUsageInfo(/*Deref*/$this(), Record);
    CheckAbstractClassUsage(Info, Record);
  }
  
  // If this is not an aggregate type and has no user-declared constructor,
  // complain about any non-static data members of reference or const scalar
  // type, since they will never get initializers.
  if (!Record.isInvalidDecl() && !Record.isDependentType()
     && !Record.isAggregate() && !Record.hasUserDeclaredConstructor()
     && !Record.isLambda()) {
    boolean Complained = false;
    for (/*const*/ FieldDecl /*P*/ F : Record.fields()) {
      if (F.hasInClassInitializer() || F.isUnnamedBitfield()) {
        continue;
      }
      if (F.getType().$arrow().isReferenceType()
         || (F.getType().isConstQualified() && F.getType().$arrow().isScalarType())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if (!Complained) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Record.getLocation(), diag.warn_no_constructor_for_refconst)), 
                    Record.getTagKind()), Record));
            Complained = true;
          }
          
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(F.getLocation(), diag.note_refconst_member_not_initialized)), 
                  F.getType().$arrow().isReferenceType()), 
              F.getDeclName()));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  if ((Record.getIdentifier() != null)) {
    // C++ [class.mem]p13:
    //   If T is the name of a class, then each of the following shall have a 
    //   name different from T:
    //     - every member of every anonymous union that is a member of class T.
    //
    // C++ [class.mem]p14:
    //   In addition, if class T has a user-declared constructor (12.1), every 
    //   non-static data member of class T shall have a name different from T.
    DeclContextLookupResult R = Record.lookup(Record.getDeclName());
    for (DeclContextLookupResult.iterator I = R.begin(), E = R.end(); I.$noteq(E);
         I.$preInc()) {
      NamedDecl /*P*/ D = I.$star();
      if ((isa_FieldDecl(D) && Record.hasUserDeclaredConstructor())
         || isa_IndirectFieldDecl(D)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), diag.err_member_name_of_class)), 
              D.getDeclName()));
          break;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // Warn if the class has virtual methods but non-virtual public destructor.
  if (Record.isPolymorphic() && !Record.isDependentType()) {
    CXXDestructorDecl /*P*/ dtor = Record.getDestructor();
    if ((!(dtor != null) || (!dtor.isVirtual() && dtor.getAccess() == AccessSpecifier.AS_public))
       && !Record.hasAttr(FinalAttr.class)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag((dtor != null) ? dtor.getLocation() : Record.getLocation(), 
                diag.warn_non_virtual_dtor)), $this().Context.getRecordType(Record)));
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (Record.isAbstract()) {
    {
      FinalAttr /*P*/ FA = Record.getAttr(FinalAttr.class);
      if ((FA != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Record.getLocation(), diag.warn_abstract_final_class)), 
              FA.isSpelledAsSealed()));
          $this().DiagnoseAbstractType(Record);
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  boolean HasMethodWithOverrideControl = false;
  boolean HasOverridingMethodWithoutOverrideControl = false;
  if (!Record.isDependentType()) {
    for (CXXMethodDecl /*P*/ M : Record.methods()) {
      // See if a method overloads virtual methods in a base
      // class without overriding any.
      if (!M.isStatic()) {
        $this().DiagnoseHiddenVirtualMethods(M);
      }
      if (M.hasAttr(OverrideAttr.class)) {
        HasMethodWithOverrideControl = true;
      } else if ($greater_uint(M.size_overridden_methods(), 0)) {
        HasOverridingMethodWithoutOverrideControl = true;
      }
      // Check whether the explicitly-defaulted special members are valid.
      if (!M.isInvalidDecl() && M.isExplicitlyDefaulted()) {
        $this().CheckExplicitlyDefaultedSpecialMember(M);
      }
      
      // For an explicitly defaulted or deleted special member, we defer
      // determining triviality until the class is complete. That time is now!
      CXXSpecialMember CSM = $this().getSpecialMember(M);
      if (!M.isImplicit() && !M.isUserProvided()) {
        if (CSM != CXXSpecialMember.CXXInvalid) {
          M.setTrivial($this().SpecialMemberIsTrivial(M, CSM));
          
          // Inform the class that we've finished declaring this member.
          Record.finishedDefaultedOrDeletedMember(M);
        }
      }
      if (!M.isInvalidDecl() && M.isExplicitlyDefaulted()
         && M.hasAttr(DLLExportAttr.class)) {
        if ($this().getLangOpts().isCompatibleWithMSVC(LangOptions.MSVCMajorVersion.MSVC2015)
           && M.isTrivial()
           && (CSM == CXXSpecialMember.CXXDefaultConstructor || CSM == CXXSpecialMember.CXXCopyConstructor
           || CSM == CXXSpecialMember.CXXDestructor)) {
          M.dropAttr(DLLExportAttr.class);
        }
        if (M.hasAttr(DLLExportAttr.class)) {
          DefineImplicitSpecialMember(/*Deref*/$this(), M, M.getLocation());
          $this().ActOnFinishInlineFunctionDef(M);
        }
      }
    }
  }
  if (HasMethodWithOverrideControl
     && HasOverridingMethodWithoutOverrideControl) {
    // At least one method has the 'override' control declared.
    // Diagnose all other overridden methods which do not have 'override' specified on them.
    for (CXXMethodDecl /*P*/ M : Record.methods())  {
      $this().DiagnoseAbsenceOfOverrideControl(M);
    }
  }
  
  // ms_struct is a request to use the same ABI rules as MSVC.  Check
  // whether this class uses any C++ features that are implemented
  // completely differently in MSVC, and if so, emit a diagnostic.
  // That diagnostic defaults to an error, but we allow projects to
  // map it down to a warning (or ignore it).  It's a fairly common
  // practice among users of the ms_struct pragma to mass-annotate
  // headers, sweeping up a bunch of types that the project doesn't
  // really rely on MSVC-compatible layout for.  We must therefore
  // support "ms_struct except for C++ stuff" as a secondary ABI.
  if (Record.isMsStruct($this().Context)
     && (Record.isPolymorphic() || (Record.getNumBases() != 0))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(Record.getLocation(), diag.warn_cxx_ms_struct)));
    } finally {
      $c$.$destroy();
    }
  }
  
  $this().checkClassLevelDLLAttribute(Record);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFinishCXXMemberSpecification">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6572,
 FQN="clang::Sema::ActOnFinishCXXMemberSpecification", NM="_ZN5clang4Sema33ActOnFinishCXXMemberSpecificationEPNS_5ScopeENS_14SourceLocationEPNS_4DeclES3_S3_PNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema33ActOnFinishCXXMemberSpecificationEPNS_5ScopeENS_14SourceLocationEPNS_4DeclES3_S3_PNS_13AttributeListE")
//</editor-fold>
public final void ActOnFinishCXXMemberSpecification(Scope /*P*/ S, SourceLocation RLoc, 
                                 Decl /*P*/ _TagDecl, 
                                 SourceLocation LBrac, 
                                 SourceLocation RBrac, 
                                 AttributeList /*P*/ AttrList) {
  type$ref<Decl /*P*/> TagDecl = create_type$ref(_TagDecl);
  if (!(TagDecl.$deref() != null)) {
    return;
  }
  
  $this().AdjustDeclIfTemplate(TagDecl);
  
  for (/*const*/ AttributeList /*P*/ l = AttrList; (l != null); l = l.getNext()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (l.getKind() != AttributeList.Kind.AT_Visibility) {
        continue;
      }
      l.setInvalid();
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(l.getLoc(), diag.warn_attribute_after_definition_ignored)), 
          l.getName()));
    } finally {
      $c$.$destroy();
    }
  }
  
  $this().ActOnFields(S, new SourceLocation(RLoc), TagDecl.$deref(), 
          (ArrayRef<Decl>) (Object) llvm.<FieldDecl>makeArrayRef(// strict aliasing violation!
            $this().FieldCollector.$arrow().getCurFields(), 
            $this().FieldCollector.$arrow().getCurNumFields()
          ), new SourceLocation(LBrac), new SourceLocation(RBrac), AttrList);
  
  $this().CheckCompletedCXXClass(dyn_cast_or_null_CXXRecordDecl(TagDecl.$deref()));
}


/// \brief Perform any semantic analysis which needs to be delayed until all
/// pending class member declarations have been parsed.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFinishCXXMemberDecls">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9552,
 FQN="clang::Sema::ActOnFinishCXXMemberDecls", NM="_ZN5clang4Sema25ActOnFinishCXXMemberDeclsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema25ActOnFinishCXXMemberDeclsEv")
//</editor-fold>
public final void ActOnFinishCXXMemberDecls() {
  {
    // If the context is an invalid C++ class, just suppress these checks.
    CXXRecordDecl /*P*/ Record = dyn_cast_CXXRecordDecl($this().CurContext);
    if ((Record != null)) {
      if (Record.isInvalidDecl()) {
        $this().DelayedDefaultedMemberExceptionSpecs.clear();
        $this().DelayedExceptionSpecChecks.clear();
        return;
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFinishCXXNonNestedClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9614,
 FQN="clang::Sema::ActOnFinishCXXNonNestedClass", NM="_ZN5clang4Sema28ActOnFinishCXXNonNestedClassEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema28ActOnFinishCXXNonNestedClassEPNS_4DeclE")
//</editor-fold>
public final void ActOnFinishCXXNonNestedClass(Decl /*P*/ D) {
  CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(D);
  
  // Default constructors that are annotated with __declspec(dllexport) which
  // have default arguments or don't use the standard calling convention are
  // wrapped with a thunk called the default constructor closure.
  if ((RD != null) && $this().Context.getTargetInfo().getCXXABI().isMicrosoft()) {
    getDefaultArgExprsForConstructors(/*Deref*/$this(), RD);
  }
  
  $this().referenceDLLExportedClassMethods();
}


/// This is used to implement the constant expression evaluation part of the
/// attribute enable_if extension. There is nothing in standard C++ which would
/// require reentering parameters.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnReenterCXXMethodParameter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6733,
 FQN="clang::Sema::ActOnReenterCXXMethodParameter", NM="_ZN5clang4Sema30ActOnReenterCXXMethodParameterEPNS_5ScopeEPNS_11ParmVarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema30ActOnReenterCXXMethodParameterEPNS_5ScopeEPNS_11ParmVarDeclE")
//</editor-fold>
public final void ActOnReenterCXXMethodParameter(Scope /*P*/ S, ParmVarDecl /*P*/ Param) {
  if (!(Param != null)) {
    return;
  }
  
  S.AddDecl(Param);
  if (Param.getDeclName().$bool()) {
    $this().IdResolver.AddDecl(Param);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnReenterTemplateScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6667,
 FQN="clang::Sema::ActOnReenterTemplateScope", NM="_ZN5clang4Sema25ActOnReenterTemplateScopeEPNS_5ScopeEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema25ActOnReenterTemplateScopeEPNS_5ScopeEPNS_4DeclE")
//</editor-fold>
public final /*uint*/int ActOnReenterTemplateScope(Scope /*P*/ S, Decl /*P*/ D) {
  if (!(D != null)) {
    return 0;
  }
  
  // The order of template parameters is not important here. All names
  // get added to the same scope.
  SmallVector<TemplateParameterList /*P*/> ParameterLists/*J*/= new SmallVector<TemplateParameterList /*P*/>(4, null);
  {
    
    TemplateDecl /*P*/ TD = dyn_cast_TemplateDecl(D);
    if ((TD != null)) {
      D = TD.getTemplatedDecl();
    }
  }
  {
    
    ClassTemplatePartialSpecializationDecl /*P*/ PSD = dyn_cast_ClassTemplatePartialSpecializationDecl(D);
    if ((PSD != null)) {
      ParameterLists.push_back(PSD.getTemplateParameters());
    }
  }
  {
    
    DeclaratorDecl /*P*/ DD = dyn_cast_DeclaratorDecl(D);
    if ((DD != null)) {
      for (/*uint*/int i = 0; $less_uint(i, DD.getNumTemplateParameterLists()); ++i)  {
        ParameterLists.push_back(DD.getTemplateParameterList(i));
      }
      {
        
        FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
        if ((FD != null)) {
          {
            FunctionTemplateDecl /*P*/ FTD = FD.getDescribedFunctionTemplate();
            if ((FTD != null)) {
              ParameterLists.push_back(FTD.getTemplateParameters());
            }
          }
        }
      }
    }
  }
  {
    
    TagDecl /*P*/ TD = dyn_cast_TagDecl(D);
    if ((TD != null)) {
      for (/*uint*/int i = 0; $less_uint(i, TD.getNumTemplateParameterLists()); ++i)  {
        ParameterLists.push_back(TD.getTemplateParameterList(i));
      }
      {
        
        CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(TD);
        if ((RD != null)) {
          {
            ClassTemplateDecl /*P*/ CTD = RD.getDescribedClassTemplate();
            if ((CTD != null)) {
              ParameterLists.push_back(CTD.getTemplateParameters());
            }
          }
        }
      }
    }
  }
  
  /*uint*/int Count = 0;
  for (TemplateParameterList /*P*/ Params : ParameterLists) {
    if ($greater_uint(Params.size(), 0)) {
      // Ignore explicit specializations; they don't contribute to the template
      // depth.
      ++Count;
    }
    for (NamedDecl /*P*/ Param : $Deref(Params)) {
      if (Param.getDeclName().$bool()) {
        S.AddDecl(Param);
        $this().IdResolver.AddDecl(Param);
      }
    }
  }
  
  return Count;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStartDelayedMemberDeclarations">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6718,
 FQN="clang::Sema::ActOnStartDelayedMemberDeclarations", NM="_ZN5clang4Sema35ActOnStartDelayedMemberDeclarationsEPNS_5ScopeEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema35ActOnStartDelayedMemberDeclarationsEPNS_5ScopeEPNS_4DeclE")
//</editor-fold>
public final void ActOnStartDelayedMemberDeclarations(Scope /*P*/ S, Decl /*P*/ _RecordD) {
  type$ref<Decl /*P*/> RecordD = create_type$ref(_RecordD);
  if (!(RecordD.$deref() != null)) {
    return;
  }
  $this().AdjustDeclIfTemplate(RecordD);
  CXXRecordDecl /*P*/ Record = cast_CXXRecordDecl(RecordD.$deref());
  $this().PushDeclContext(S, Record);
}


/// ActOnStartDelayedCXXMethodDeclaration - We have completed
/// parsing a top-level (non-nested) C++ class, and we are now
/// parsing those parts of the given Method declaration that could
/// not be parsed earlier (C++ [class.mem]p2), such as default
/// arguments. This action should enter the scope of the given
/// Method declaration as if we had just parsed the qualified method
/// name. However, it should not bring the parameters into scope;
/// that will be performed by ActOnDelayedCXXMethodParameter.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStartDelayedCXXMethodDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6750,
 FQN="clang::Sema::ActOnStartDelayedCXXMethodDeclaration", NM="_ZN5clang4Sema37ActOnStartDelayedCXXMethodDeclarationEPNS_5ScopeEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema37ActOnStartDelayedCXXMethodDeclarationEPNS_5ScopeEPNS_4DeclE")
//</editor-fold>
public final void ActOnStartDelayedCXXMethodDeclaration(Scope /*P*/ S, Decl /*P*/ MethodD) {
}


/// ActOnDelayedCXXMethodParameter - We've already started a delayed
/// C++ method declaration. We're (re-)introducing the given
/// function parameter into scope for use in parsing later parts of
/// the method declaration. For example, we could see an
/// ActOnParamDefaultArgument event for this parameter.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnDelayedCXXMethodParameter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6758,
 FQN="clang::Sema::ActOnDelayedCXXMethodParameter", NM="_ZN5clang4Sema30ActOnDelayedCXXMethodParameterEPNS_5ScopeEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema30ActOnDelayedCXXMethodParameterEPNS_5ScopeEPNS_4DeclE")
//</editor-fold>
public final void ActOnDelayedCXXMethodParameter(Scope /*P*/ S, Decl /*P*/ ParamD) {
  if (!(ParamD != null)) {
    return;
  }
  
  ParmVarDecl /*P*/ Param = cast_ParmVarDecl(ParamD);
  
  // If this parameter has an unparsed default argument, clear it out
  // to make way for the parsed default argument.
  if (Param.hasUnparsedDefaultArg()) {
    Param.setDefaultArg((Expr /*P*/ )null);
  }
  
  S.AddDecl(Param);
  if (Param.getDeclName().$bool()) {
    $this().IdResolver.AddDecl(Param);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFinishDelayedMemberDeclarations">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6725,
 FQN="clang::Sema::ActOnFinishDelayedMemberDeclarations", NM="_ZN5clang4Sema36ActOnFinishDelayedMemberDeclarationsEPNS_5ScopeEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema36ActOnFinishDelayedMemberDeclarationsEPNS_5ScopeEPNS_4DeclE")
//</editor-fold>
public final void ActOnFinishDelayedMemberDeclarations(Scope /*P*/ S, Decl /*P*/ RecordD) {
  if (!(RecordD != null)) {
    return;
  }
  $this().PopDeclContext();
}


/// ActOnFinishDelayedCXXMethodDeclaration - We have finished
/// processing the delayed method declaration for Method. The method
/// declaration is now considered finished. There may be a separate
/// ActOnStartOfFunctionDef action later (not necessarily
/// immediately!) for this method, if it was also defined inside the
/// class body.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFinishDelayedCXXMethodDeclaration">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6780,
 FQN="clang::Sema::ActOnFinishDelayedCXXMethodDeclaration", NM="_ZN5clang4Sema38ActOnFinishDelayedCXXMethodDeclarationEPNS_5ScopeEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema38ActOnFinishDelayedCXXMethodDeclarationEPNS_5ScopeEPNS_4DeclE")
//</editor-fold>
public final void ActOnFinishDelayedCXXMethodDeclaration(Scope /*P*/ S, Decl /*P*/ _MethodD) {
  type$ref<Decl /*P*/> MethodD = create_type$ref(_MethodD);
  if (!(MethodD.$deref() != null)) {
    return;
  }
  
  $this().AdjustDeclIfTemplate(MethodD);
  
  FunctionDecl /*P*/ Method = cast_FunctionDecl(MethodD.$deref());
  {
    
    // Now that we have our default arguments, check the constructor
    // again. It could produce additional diagnostics or affect whether
    // the class has implicitly-declared destructors, among other
    // things.
    CXXConstructorDecl /*P*/ Constructor = dyn_cast_CXXConstructorDecl(Method);
    if ((Constructor != null)) {
      $this().CheckConstructor(Constructor);
    }
  }
  
  // Check the default arguments, which we may have added.
  if (!Method.isInvalidDecl()) {
    $this().CheckCXXDefaultArguments(Method);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFinishDelayedMemberInitializers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9234,
 FQN="clang::Sema::ActOnFinishDelayedMemberInitializers", NM="_ZN5clang4Sema36ActOnFinishDelayedMemberInitializersEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema36ActOnFinishDelayedMemberInitializersEPNS_4DeclE")
//</editor-fold>
public final void ActOnFinishDelayedMemberInitializers(Decl /*P*/ D) {
  // Perform any delayed checks on exception specifications.
  $this().CheckDelayedMemberExceptionSpecs();
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStaticAssertDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 12363,
 FQN="clang::Sema::ActOnStaticAssertDeclaration", NM="_ZN5clang4Sema28ActOnStaticAssertDeclarationENS_14SourceLocationEPNS_4ExprES3_S1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema28ActOnStaticAssertDeclarationENS_14SourceLocationEPNS_4ExprES3_S1_")
//</editor-fold>
public final Decl /*P*/ ActOnStaticAssertDeclaration(SourceLocation StaticAssertLoc, 
                            Expr /*P*/ AssertExpr, 
                            Expr /*P*/ AssertMessageExpr, 
                            SourceLocation RParenLoc) {
  StringLiteral /*P*/ AssertMessage = (AssertMessageExpr != null) ? cast_StringLiteral(AssertMessageExpr) : null;
  if ($this().DiagnoseUnexpandedParameterPack(AssertExpr, UnexpandedParameterPackContext.UPPC_StaticAssertExpression)) {
    return null;
  }
  
  return $this().BuildStaticAssertDeclaration(new SourceLocation(StaticAssertLoc), AssertExpr, 
      AssertMessage, new SourceLocation(RParenLoc), false);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildStaticAssertDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 12377,
 FQN="clang::Sema::BuildStaticAssertDeclaration", NM="_ZN5clang4Sema28BuildStaticAssertDeclarationENS_14SourceLocationEPNS_4ExprEPNS_13StringLiteralES1_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema28BuildStaticAssertDeclarationENS_14SourceLocationEPNS_4ExprEPNS_13StringLiteralES1_b")
//</editor-fold>
public final Decl /*P*/ BuildStaticAssertDeclaration(SourceLocation StaticAssertLoc, 
                            Expr /*P*/ AssertExpr, 
                            StringLiteral /*P*/ AssertMessage, 
                            SourceLocation RParenLoc, 
                            boolean Failed) {
  assert (AssertExpr != null) : "Expected non-null condition";
  if (!AssertExpr.isTypeDependent() && !AssertExpr.isValueDependent()
     && !Failed) {
    // In a static_assert-declaration, the constant-expression shall be a
    // constant expression that can be contextually converted to bool.
    ActionResultTTrue<Expr /*P*/ > _Converted = $this().PerformContextuallyConvertToBool(AssertExpr);
    if (_Converted.isInvalid()) {
      Failed = true;
    }
    
    APSInt Cond/*J*/= new APSInt();
    if (!Failed && $this().VerifyIntegerConstantExpression(_Converted.get(), $AddrOf(Cond), 
        diag.err_static_assert_expression_is_not_constant, 
        /*AllowFold=*/ false).isInvalid()) {
      Failed = true;
    }
    if (!Failed && Cond.$not()) {
      raw_svector_ostream Msg = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        SmallString/*<256>*/ MsgBuffer/*J*/= new SmallString/*<256>*/(256);
        Msg/*J*/= new raw_svector_ostream(MsgBuffer);
        if ((AssertMessage != null)) {
          AssertMessage.printPretty(Msg, (PrinterHelper /*P*/ )null, $this().getPrintingPolicy());
        }
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(StaticAssertLoc), diag.err_static_assert_failed)), 
                    !(AssertMessage != null)), Msg.str()), AssertExpr.getSourceRange()));
        Failed = true;
      } finally {
        if (Msg != null) { Msg.$destroy(); }
        $c$.$destroy();
      }
    }
  }
  
  Decl /*P*/ $Decl = StaticAssertDecl.Create($this().Context, $this().CurContext, new SourceLocation(StaticAssertLoc), 
      AssertExpr, AssertMessage, new SourceLocation(RParenLoc), 
      Failed);
  
  $this().CurContext.addDecl($Decl);
  return $Decl;
}


/// \brief Perform semantic analysis of the given friend type declaration.
///
/// \returns A friend declaration that.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckFriendTypeDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 12419,
 FQN="clang::Sema::CheckFriendTypeDecl", NM="_ZN5clang4Sema19CheckFriendTypeDeclENS_14SourceLocationES1_PNS_14TypeSourceInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema19CheckFriendTypeDeclENS_14SourceLocationES1_PNS_14TypeSourceInfoE")
//</editor-fold>
public final FriendDecl /*P*/ CheckFriendTypeDecl(SourceLocation LocStart, 
                   SourceLocation FriendLoc, 
                   TypeSourceInfo /*P*/ TSInfo) {
  assert ((TSInfo != null)) : "NULL TypeSourceInfo for friend type declaration";
  
  QualType T = TSInfo.getType();
  SourceRange TypeRange = TSInfo.getTypeLoc().getLocalSourceRange();
  
  // C++03 [class.friend]p2:
  //   An elaborated-type-specifier shall be used in a friend declaration
  //   for a class.*
  //
  //   * The class-key of the elaborated-type-specifier is required.
  if (!$this().ActiveTemplateInstantiations.empty()) {
    // Do not complain about the form of friend template types during
    // template instantiation; we will already have complained when the
    // template was declared.
  } else {
    if (!T.$arrow().isElaboratedTypeSpecifier()) {
      {
        // If we evaluated the type to a record type, suggest putting
        // a tag in front.
        /*const*/ RecordType /*P*/ RT = T.$arrow().getAs$RecordType();
        if ((RT != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            RecordDecl /*P*/ RD = RT.getDecl();
            
            SmallString/*<16>*/ InsertionText/*J*/= new SmallString/*<16>*/(16, new StringRef(/*KEEP_STR*/$SPACE));
            InsertionText.$addassign(RD.getKindName());
            
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(TypeRange.getBegin(), 
                            $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_unelaborated_friend_type : diag.ext_unelaborated_friend_type)), 
                        (/*uint*/int)RD.getTagKind().getValue()), 
                    T), 
                FixItHint.CreateInsertion($this().getLocForEndOfToken(new SourceLocation(FriendLoc)), 
                    InsertionText.$StringRef())));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(FriendLoc), 
                        $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_nonclass_type_friend : diag.ext_nonclass_type_friend)), 
                    T), 
                TypeRange));
          } finally {
            $c$.$destroy();
          }
        }
      }
    } else if ((T.$arrow().getAs$EnumType() != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(FriendLoc), 
                    $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_enum_friend : diag.ext_enum_friend)), 
                T), 
            TypeRange));
      } finally {
        $c$.$destroy();
      }
    }
    
    // C++11 [class.friend]p3:
    //   A friend declaration that does not declare a function shall have one
    //   of the following forms:
    //     friend elaborated-type-specifier ;
    //     friend simple-type-specifier ;
    //     friend typename-specifier ;
    if ($this().getLangOpts().CPlusPlus11 && $noteq_SourceLocation$C(LocStart, FriendLoc)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(FriendLoc), diag.err_friend_not_first_in_declaration)), T));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  //   If the type specifier in a friend declaration designates a (possibly
  //   cv-qualified) class type, that class is declared as a friend; otherwise,
  //   the friend declaration is ignored.
  return FriendDecl.Create($this().Context, $this().CurContext, 
      TSInfo.getTypeLoc().getLocStart(), new PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ >(JD$T1.INSTANCE, TypeSourceInfo /*P*/ .class, TSInfo), 
      new SourceLocation(FriendLoc));
}


/// Handle a friend type declaration.  This works in tandem with
/// ActOnTag.
///
/// Notes on friend class templates:
///
/// We generally treat friend class declarations as if they were
/// declaring a class.  So, for example, the elaborated type specifier
/// in a friend declaration is required to obey the restrictions of a
/// class-head (i.e. no typedefs in the scope chain), template
/// parameters are required to match up with simple template-ids, &c.
/// However, unlike when declaring a template specialization, it's
/// okay to refer to a template specialization without an empty
/// template parameter declaration, e.g.
///   friend class A<T>::B<unsigned>;
/// We permit this as a special case; if there are any template
/// parameters present at all, require proper matching, i.e.
///   template <> template \<class T> friend class A<int>::B;
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFriendTypeDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 12626,
 FQN="clang::Sema::ActOnFriendTypeDecl", NM="_ZN5clang4Sema19ActOnFriendTypeDeclEPNS_5ScopeERKNS_8DeclSpecEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema19ActOnFriendTypeDeclEPNS_5ScopeERKNS_8DeclSpecEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEE")
//</editor-fold>
public final Decl /*P*/ ActOnFriendTypeDecl(Scope /*P*/ S, final /*const*/ DeclSpec /*&*/ DS, 
                   MutableArrayRef<TemplateParameterList /*P*/ > TempParams) {
  Declarator TheDeclarator = null;
  try {
    SourceLocation Loc = DS.getLocStart();
    assert (DS.isFriendSpecified());
    assert (DS.getStorageClassSpec() == DeclSpec.SCS.SCS_unspecified);
    
    // Try to convert the decl specifier to a type.  This works for
    // friend templates because ActOnTag never produces a ClassTemplateDecl
    // for a TUK_Friend.
    TheDeclarator/*J*/= new Declarator(DS, Declarator.TheContext.MemberContext);
    TypeSourceInfo /*P*/ TSI = $this().GetTypeForDeclarator(TheDeclarator, S);
    QualType T = TSI.getType();
    if (TheDeclarator.isInvalidType()) {
      return null;
    }
    if ($this().DiagnoseUnexpandedParameterPack(new SourceLocation(Loc), TSI, UnexpandedParameterPackContext.UPPC_FriendDeclaration)) {
      return null;
    }
    
    // This is definitely an error in C++98.  It's probably meant to
    // be forbidden in C++0x, too, but the specification is just
    // poorly written.
    //
    // The problem is with declarations like the following:
    //   template <T> friend A<T>::foo;
    // where deciding whether a class C is a friend or not now hinges
    // on whether there exists an instantiation of A that causes
    // 'foo' to equal C.  There are restrictions on class-heads
    // (which we declare (by fiat) elaborated friend declarations to
    // be) that makes this tractable.
    //
    // FIXME: handle "template <> friend class A<T>;", which
    // is possibly well-formed?  Who even knows?
    if ((TempParams.size() != 0) && !T.$arrow().isElaboratedTypeSpecifier()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_tagless_friend_type_template)), 
            DS.getSourceRange()));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    
    // C++98 [class.friend]p1: A friend of a class is a function
    //   or class that is not a member of the class . . .
    // This is fixed in DR77, which just barely didn't make the C++03
    // deadline.  It's also a very silly restriction that seriously
    // affects inner classes and which nobody else seems to implement;
    // thus we never diagnose it, not even in -pedantic.
    //
    // But note that we could warn about it: it's always useless to
    // friend one of your own members (it's not, however, worthless to
    // friend a member of an arbitrary specialization of your template).
    Decl /*P*/ D;
    if (!TempParams.empty()) {
      D = FriendTemplateDecl.Create($this().Context, $this().CurContext, new SourceLocation(Loc), 
          new MutableArrayRef<TemplateParameterList /*P*/ >(TempParams), 
          new PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ >(JD$T1.INSTANCE, TypeSourceInfo /*P*/.class, TSI), 
          DS.getFriendSpecLoc());
    } else {
      D = $this().CheckFriendTypeDecl(new SourceLocation(Loc), DS.getFriendSpecLoc(), TSI);
    }
    if (!(D != null)) {
      return null;
    }
    
    D.setAccess(AccessSpecifier.AS_public);
    $this().CurContext.addDecl(D);
    
    return D;
  } finally {
    if (TheDeclarator != null) { TheDeclarator.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFriendFunctionDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 12694,
 FQN="clang::Sema::ActOnFriendFunctionDecl", NM="_ZN5clang4Sema23ActOnFriendFunctionDeclEPNS_5ScopeERNS_10DeclaratorEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema23ActOnFriendFunctionDeclEPNS_5ScopeERNS_10DeclaratorEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEE")
//</editor-fold>
public final NamedDecl /*P*/ ActOnFriendFunctionDecl(Scope /*P*/ S, final Declarator /*&*/ D, 
                       MutableArrayRef<TemplateParameterList /*P*/ > TemplateParams) {
  LookupResult Previous = null;
  Scope FakeDCScope = null;
  try {
    final /*const*/ DeclSpec /*&*/ DS = D.getDeclSpec();
    assert (DS.isFriendSpecified());
    assert (DS.getStorageClassSpec() == DeclSpec.SCS.SCS_unspecified);
    
    SourceLocation Loc = D.getIdentifierLoc();
    TypeSourceInfo /*P*/ TInfo = $this().GetTypeForDeclarator(D, S);
    
    // C++ [class.friend]p1
    //   A friend of a class is a function or class....
    // Note that this sees through typedefs, which is intended.
    // It *doesn't* see through dependent types, which is correct
    // according to [temp.arg.type]p3:
    //   If a declaration acquires a function type through a
    //   type dependent on a template-parameter and this causes
    //   a declaration that does not use the syntactic form of a
    //   function declarator to have a function type, the program
    //   is ill-formed.
    if (!TInfo.getType().$arrow().isFunctionType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_unexpected_friend)));
        
        // It might be worthwhile to try to recover by creating an
        // appropriate declaration.
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    
    // C++ [namespace.memdef]p3
    //  - If a friend declaration in a non-local class first declares a
    //    class or function, the friend class or function is a member
    //    of the innermost enclosing namespace.
    //  - The name of the friend is not found by simple name lookup
    //    until a matching declaration is provided in that namespace
    //    scope (either before or after the class declaration granting
    //    friendship).
    //  - If a friend function is called, its name may be found by the
    //    name lookup that considers functions from namespaces and
    //    classes associated with the types of the function arguments.
    //  - When looking for a prior declaration of a class or a function
    //    declared as a friend, scopes outside the innermost enclosing
    //    namespace scope are not considered.
    final CXXScopeSpec /*&*/ SS = D.getCXXScopeSpec();
    DeclarationNameInfo NameInfo = $this().GetNameForDeclarator(D);
    DeclarationName Name = NameInfo.getName();
    assert ((Name).$bool());
    
    // Check for unexpanded parameter packs.
    if ($this().DiagnoseUnexpandedParameterPack(new SourceLocation(Loc), TInfo, UnexpandedParameterPackContext.UPPC_FriendDeclaration)
       || $this().DiagnoseUnexpandedParameterPack(NameInfo, UnexpandedParameterPackContext.UPPC_FriendDeclaration)
       || $this().DiagnoseUnexpandedParameterPack(SS, UnexpandedParameterPackContext.UPPC_FriendDeclaration)) {
      return null;
    }
    
    // The context we found the declaration in, or in which we should
    // create the declaration.
    type$ref<DeclContext /*P*/ > DC = create_type$ref();
    Scope /*P*/ DCScope = S;
    Previous/*J*/= new LookupResult(/*Deref*/$this(), NameInfo, LookupNameKind.LookupOrdinaryName, 
        RedeclarationKind.ForRedeclaration);
    
    // There are five cases here.
    //   - There's no scope specifier and we're in a local class. Only look
    //     for functions declared in the immediately-enclosing block scope.
    // We recover from invalid scope qualifiers as if they just weren't there.
    FunctionDecl /*P*/ FunctionContainingLocalClass = null;
    if ((SS.isInvalid() || !SS.isSet())
       && ((FunctionContainingLocalClass
       = cast_CXXRecordDecl($this().CurContext).isLocalClass()) != null)) {
      // C++11 [class.friend]p11:
      //   If a friend declaration appears in a local class and the name
      //   specified is an unqualified name, a prior declaration is
      //   looked up without considering scopes that are outside the
      //   innermost enclosing non-class scope. For a friend function
      //   declaration, if there is no prior declaration, the program is
      //   ill-formed.
      
      // Find the innermost enclosing non-class scope. This is the block
      // scope containing the local class definition (or for a nested class,
      // the outer local class).
      DCScope = S.getFnParent();
      
      // Look up the function name in the scope.
      Previous.clear(LookupNameKind.LookupLocalFriendName);
      $this().LookupName(Previous, S, /*AllowBuiltinCreation*/ false);
      if (!Previous.empty()) {
        // All possible previous declarations must have the same context:
        // either they were declared at block scope or they are members of
        // one of the enclosing local classes.
        DC.$set(Previous.getRepresentativeDecl().getDeclContext());
      } else {
        // This is ill-formed, but provide the context that we would have
        // declared the function in, if we were permitted to, for error recovery.
        DC.$set(FunctionContainingLocalClass);
      }
      adjustContextForLocalExternDecl(DC);
      
      // C++ [class.friend]p6:
      //   A function can be defined in a friend declaration of a class if and
      //   only if the class is a non-local class (9.8), the function name is
      //   unqualified, and the function has namespace scope.
      if (D.isFunctionDefinition()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(NameInfo.getBeginLoc(), diag.err_friend_def_in_local_class)));
        } finally {
          $c$.$destroy();
        }
      }
      //   - There's no scope specifier, in which case we just go to the
      //     appropriate scope and look for a function or function template
      //     there as appropriate.
    } else if (SS.isInvalid() || !SS.isSet()) {
      // C++11 [namespace.memdef]p3:
      //   If the name in a friend declaration is neither qualified nor
      //   a template-id and the declaration is a function or an
      //   elaborated-type-specifier, the lookup to determine whether
      //   the entity has been previously declared shall not consider
      //   any scopes outside the innermost enclosing namespace.
      boolean isTemplateId = D.getName().getKind() == UnqualifiedId.IdKind.IK_TemplateId;
      
      // Find the appropriate context according to the above.
      DC.$set($this().CurContext);
      
      // Skip class contexts.  If someone can cite chapter and verse
      // for this behavior, that would be nice --- it's what GCC and
      // EDG do, and it seems like a reasonable intent, but the spec
      // really only says that checks for unqualified existing
      // declarations should stop at the nearest enclosing namespace,
      // not that they should only consider the nearest enclosing
      // namespace.
      while (DC.$deref().isRecord()) {
        DC.$set(DC.$deref().getParent());
      }
      
      DeclContext /*P*/ LookupDC = DC.$deref();
      while (LookupDC.isTransparentContext()) {
        LookupDC = LookupDC.getParent();
      }
      while (true) {
        $this().LookupQualifiedName(Previous, LookupDC);
        if (!Previous.empty()) {
          DC.$set(LookupDC);
          break;
        }
        if (isTemplateId) {
          if (isa_TranslationUnitDecl(LookupDC)) {
            break;
          }
        } else {
          if (LookupDC.isFileContext()) {
            break;
          }
        }
        LookupDC = LookupDC.getParent();
      }
      
      DCScope = getScopeForDeclContext(S, DC.$deref());
      //   - There's a non-dependent scope specifier, in which case we
      //     compute it and do a previous lookup there for a function
      //     or function template.
    } else if (!SS.getScopeRep().isDependent()) {
      LookupResult.Filter F = null;
      try {
        DC.$set($this().computeDeclContext(SS));
        if (!(DC.$deref() != null)) {
          return null;
        }
        if ($this().RequireCompleteDeclContext(SS, DC.$deref())) {
          return null;
        }
        
        $this().LookupQualifiedName(Previous, DC.$deref());
        
        // Ignore things found implicitly in the wrong scope.
        // TODO: better diagnostics for this case.  Suggesting the right
        // qualified scope would be nice...
        F = Previous.makeFilter();
        while (F.hasNext()) {
          NamedDecl /*P*/ D$1 = F.next();
          if (!DC.$deref().InEnclosingNamespaceSetOf(D$1.getDeclContext().getRedeclContext())) {
            F.erase();
          }
        }
        F.done();
        if (Previous.empty()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            D.setInvalidType();
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_qualified_friend_not_found)), 
                    Name), TInfo.getType()));
            return null;
          } finally {
            $c$.$destroy();
          }
        }
        
        // C++ [class.friend]p1: A friend of a class is a function or
        //   class that is not a member of the class . . .
        if (DC.$deref().Equals($this().CurContext)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(DS.getFriendSpecLoc(), 
                $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_friend_is_member : diag.err_friend_is_member)));
          } finally {
            $c$.$destroy();
          }
        }
        if (D.isFunctionDefinition()) {
          SemaDiagnosticBuilder DB = null;
          try {
            // C++ [class.friend]p6:
            //   A function can be defined in a friend declaration of a class if and 
            //   only if the class is a non-local class (9.8), the function name is
            //   unqualified, and the function has namespace scope.
            DB = $this().Diag(SS.getRange().getBegin(), diag.err_qualified_friend_def);
            
            $out_SemaDiagnosticBuilder_NestedNameSpec(DB, SS.getScopeRep());
            if (DC.$deref().isFileContext()) {
              $out_SemaDiagnosticBuilder$C_T$C$R(DB, FixItHint.CreateRemoval(SS.getRange()));
            }
            SS.clear();
          } finally {
            if (DB != null) { DB.$destroy(); }
          }
        }
      } finally {
        if (F != null) { F.$destroy(); }
      }
      //   - There's a scope specifier that does not match any template
      //     parameter lists, in which case we use some arbitrary context,
      //     create a method or method template, and wait for instantiation.
      //   - There's a scope specifier that does match some template
      //     parameter lists, which we don't handle right now.
    } else {
      if (D.isFunctionDefinition()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C++ [class.friend]p6:
          //   A function can be defined in a friend declaration of a class if and 
          //   only if the class is a non-local class (9.8), the function name is
          //   unqualified, and the function has namespace scope.
          $c$.clean($out_SemaDiagnosticBuilder_NestedNameSpec($c$.track($this().Diag(SS.getRange().getBegin(), diag.err_qualified_friend_def)), 
              SS.getScopeRep()));
        } finally {
          $c$.$destroy();
        }
      }
      
      DC.$set($this().CurContext);
      assert (isa_CXXRecordDecl(DC)) : "friend declaration not in class?";
    }
    if (!DC.$deref().isRecord()) {
      int DiagArg = -1;
      switch (D.getName().getKind()) {
       case IK_ConstructorTemplateId:
       case IK_ConstructorName:
        DiagArg = 0;
        break;
       case IK_DestructorName:
        DiagArg = 1;
        break;
       case IK_ConversionFunctionId:
        DiagArg = 2;
        break;
       case IK_Identifier:
       case IK_ImplicitSelfParam:
       case IK_LiteralOperatorId:
       case IK_OperatorFunctionId:
       case IK_TemplateId:
        break;
      }
      // This implies that it has to be an operator or function.
      if (DiagArg >= 0) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_introducing_special_friend)), DiagArg));
          return null;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // FIXME: This is an egregious hack to cope with cases where the scope stack
    // does not contain the declaration context, i.e., in an out-of-line 
    // definition of a class.
    FakeDCScope/*J*/= new Scope(S, Scope.ScopeFlags.DeclScope, $this().Diags);
    if (!(DCScope != null)) {
      FakeDCScope.setEntity(DC.$deref());
      DCScope = $AddrOf(FakeDCScope);
    }
    
    bool$ref AddToScope = create_bool$ref(true);
    NamedDecl /*P*/ ND = $this().ActOnFunctionDeclarator(DCScope, D, DC.$deref(), TInfo, Previous, 
        new MutableArrayRef<TemplateParameterList /*P*/ >(TemplateParams), AddToScope);
    if (!(ND != null)) {
      return null;
    }
    assert (ND.getLexicalDeclContext() == $this().CurContext);
    
    // If we performed typo correction, we might have added a scope specifier
    // and changed the decl context.
    DC.$set(ND.getDeclContext());
    
    // Add the function declaration to the appropriate lookup tables,
    // adjusting the redeclarations list as necessary.  We don't
    // want to do this yet if the friending class is dependent.
    //
    // Also update the scope-based lookup if the target context's
    // lookup context is in lexical scope.
    if (!$this().CurContext.isDependentContext()) {
      DC.$set(DC.$deref().getRedeclContext());
      DC.$deref().makeDeclVisibleInContext(ND);
      {
        Scope /*P*/ EnclosingScope = getScopeForDeclContext(S, DC.$deref());
        if ((EnclosingScope != null)) {
          $this().PushOnScopeChains(ND, EnclosingScope, /*AddToContext=*/ false);
        }
      }
    }
    
    FriendDecl /*P*/ FrD = FriendDecl.Create($this().Context, $this().CurContext, 
        D.getIdentifierLoc(), new PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ >(JD$T.INSTANCE, NamedDecl /*P*/.class, ND), 
        DS.getFriendSpecLoc());
    FrD.setAccess(AccessSpecifier.AS_public);
    $this().CurContext.addDecl(FrD);
    if (ND.isInvalidDecl()) {
      FrD.setInvalidDecl();
    } else {
      if (DC.$deref().isRecord()) {
        $this().CheckFriendAccess(ND);
      }
      
      FunctionDecl /*P*/ FD;
      {
        FunctionTemplateDecl /*P*/ FTD = dyn_cast_FunctionTemplateDecl(ND);
        if ((FTD != null)) {
          FD = FTD.getTemplatedDecl();
        } else {
          FD = cast_FunctionDecl(ND);
        }
      }
      
      // C++11 [dcl.fct.default]p4: If a friend declaration specifies a
      // default argument expression, that declaration shall be a definition
      // and shall be the only declaration of the function or function
      // template in the translation unit.
      if (functionDeclHasDefaultArgument(FD)) {
        {
          FunctionDecl /*P*/ OldFD = FD.getPreviousDecl$Redeclarable();
          if ((OldFD != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(FD.getLocation(), diag.err_friend_decl_with_def_arg_redeclared)));
              $c$.clean($c$.track($this().Diag(OldFD.getLocation(), diag.note_previous_declaration)));
            } finally {
              $c$.$destroy();
            }
          } else if (!D.isFunctionDefinition()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(FD.getLocation(), diag.err_friend_decl_with_def_arg_must_be_def)));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
      
      // Mark templated-scope function declarations as unsupported.
      if ((FD.getNumTemplateParameterLists() != 0) && SS.isValid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_NestedNameSpec($c$.track($this().Diag(FD.getLocation(), diag.warn_template_qualified_friend_unsupported)), 
                      SS.getScopeRep()), SS.getRange()), 
              cast_CXXRecordDecl($this().CurContext)));
          FrD.setUnsupportedFriend(true);
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    return ND;
  } finally {
    if (FakeDCScope != null) { FakeDCScope.$destroy(); }
    if (Previous != null) { Previous.$destroy(); }
  }
}


/// CheckConstructorDeclarator - Called by ActOnDeclarator to check
/// the well-formedness of the constructor declarator @p D with type @p
/// R. If there are any errors in the declarator, this routine will
/// emit diagnostics and set the invalid bit to true.  In any case, the type
/// will be updated to reflect a well-formed type for the constructor and
/// returned.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckConstructorDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6806,
 FQN="clang::Sema::CheckConstructorDeclarator", NM="_ZN5clang4Sema26CheckConstructorDeclaratorERNS_10DeclaratorENS_8QualTypeERNS_12StorageClassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema26CheckConstructorDeclaratorERNS_10DeclaratorENS_8QualTypeERNS_12StorageClassE")
//</editor-fold>
public final QualType CheckConstructorDeclarator(final Declarator /*&*/ D, QualType R, 
                          final type$ref<StorageClass /*&*/> SC) {
  boolean isVirtual = D.getDeclSpec().isVirtualSpecified();
  
  // C++ [class.ctor]p3:
  //   A constructor shall not be virtual (10.3) or static (9.4). A
  //   constructor can be invoked for a const, volatile or const
  //   volatile object. A constructor shall not be declared const,
  //   volatile, or const volatile (9.3.2).
  if (isVirtual) {
    if (!D.isInvalidType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_constructor_cannot_be)), 
                    /*KEEP_STR*/"virtual"), new SourceRange(D.getDeclSpec().getVirtualSpecLoc())), 
            new SourceRange(D.getIdentifierLoc())));
      } finally {
        $c$.$destroy();
      }
    }
    D.setInvalidType();
  }
  if (SC.$deref() == StorageClass.SC_Static) {
    if (!D.isInvalidType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_constructor_cannot_be)), 
                    /*KEEP_STR*/"static"), new SourceRange(D.getDeclSpec().getStorageClassSpecLoc())), 
            new SourceRange(D.getIdentifierLoc())));
      } finally {
        $c$.$destroy();
      }
    }
    D.setInvalidType();
    SC.$set(StorageClass.SC_None);
  }
  {
    
    /*uint*/int TypeQuals = D.getDeclSpec().getTypeQualifiers();
    if ((TypeQuals != 0)) {
      $this().diagnoseIgnoredQualifiers(diag.err_constructor_return_type, TypeQuals, new SourceLocation(), 
          D.getDeclSpec().getConstSpecLoc(), D.getDeclSpec().getVolatileSpecLoc(), 
          D.getDeclSpec().getRestrictSpecLoc(), 
          D.getDeclSpec().getAtomicSpecLoc());
      D.setInvalidType();
    }
  }
  
  final DeclaratorChunk.FunctionTypeInfo /*&*/ FTI = D.getFunctionTypeInfo();
  if ($4bits_uint2uint(FTI.TypeQuals) != 0) {
    if ((($4bits_uint2uint(FTI.TypeQuals) & Qualifiers.TQ.Const) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_invalid_qualified_constructor)), 
                /*KEEP_STR*/"const"), new SourceRange(D.getIdentifierLoc())));
      } finally {
        $c$.$destroy();
      }
    }
    if ((($4bits_uint2uint(FTI.TypeQuals) & Qualifiers.TQ.Volatile) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_invalid_qualified_constructor)), 
                /*KEEP_STR*/"volatile"), new SourceRange(D.getIdentifierLoc())));
      } finally {
        $c$.$destroy();
      }
    }
    if ((($4bits_uint2uint(FTI.TypeQuals) & Qualifiers.TQ.Restrict) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_invalid_qualified_constructor)), 
                /*KEEP_STR*/"restrict"), new SourceRange(D.getIdentifierLoc())));
      } finally {
        $c$.$destroy();
      }
    }
    D.setInvalidType();
  }
  
  // C++0x [class.ctor]p4:
  //   A constructor shall not be declared with a ref-qualifier.
  if (FTI.hasRefQualifier()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FTI.getRefQualifierLoc(), diag.err_ref_qualifier_constructor)), 
              FTI.RefQualifierIsLValueRef), 
          FixItHint.CreateRemoval(new SourceRange(FTI.getRefQualifierLoc()))));
      D.setInvalidType();
    } finally {
      $c$.$destroy();
    }
  }
  
  // Rebuild the function type "R" without any type qualifiers (in
  // case any of the errors above fired) and with "void" as the
  // return type, since constructors don't have return types.
  /*const*/ FunctionProtoType /*P*/ Proto = R.$arrow().getAs(FunctionProtoType.class);
  if ($eq_QualType$C(Proto.getReturnType(), $this().Context.VoidTy.$QualType()) && !D.isInvalidType()) {
    return new QualType(JD$Move.INSTANCE, R);
  }
  
  FunctionProtoType.ExtProtoInfo EPI = Proto.getExtProtoInfo();
  EPI.TypeQuals = 0;
  EPI.RefQualifier = RefQualifierKind.RQ_None;
  
  return $this().Context.getFunctionType($this().Context.VoidTy.$QualType(), Proto.getParamTypes(), EPI);
}


/// CheckConstructor - Checks a fully-formed constructor for
/// well-formedness, issuing any diagnostics required. Returns true if
/// the constructor declarator is invalid.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckConstructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6880,
 FQN="clang::Sema::CheckConstructor", NM="_ZN5clang4Sema16CheckConstructorEPNS_18CXXConstructorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema16CheckConstructorEPNS_18CXXConstructorDeclE")
//</editor-fold>
public final void CheckConstructor(CXXConstructorDecl /*P*/ Constructor) {
  CXXRecordDecl /*P*/ ClassDecl = dyn_cast_CXXRecordDecl(Constructor.getDeclContext());
  if (!(ClassDecl != null)) {
    Constructor.setInvalidDecl();
    /*JAVA:return*/return;
  }
  
  // C++ [class.copy]p3:
  //   A declaration of a constructor for a class X is ill-formed if
  //   its first parameter is of type (optionally cv-qualified) X and
  //   either there are no other parameters or else all other
  //   parameters have default arguments.
  if (!Constructor.isInvalidDecl()
     && ((Constructor.getNumParams() == 1)
     || ($greater_uint(Constructor.getNumParams(), 1)
     && Constructor.getParamDecl(1).hasDefaultArg()))
     && Constructor.getTemplateSpecializationKind()
     != TemplateSpecializationKind.TSK_ImplicitInstantiation) {
    QualType ParamType = Constructor.getParamDecl(0).getType();
    QualType ClassTy = $this().Context.getTagDeclType(ClassDecl);
    if (QualType.$eq_QualType$C($this().Context.getCanonicalType(/*NO_COPY*/ParamType).getUnqualifiedType().$QualType(), ClassTy)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        SourceLocation ParamLoc = Constructor.getParamDecl(0).getLocation();
        /*const*/char$ptr/*char P*/ ConstRef = $tryClone((Constructor.getParamDecl(0).getIdentifier() != null) ? $("const &") : $(" const &"));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ParamLoc), diag.err_constructor_byvalue_arg)), 
            FixItHint.CreateInsertion(/*NO_COPY*/ParamLoc, new StringRef(ConstRef))));
        
        // FIXME: Rather that making the constructor invalid, we should endeavor
        // to fix the type.
        Constructor.setInvalidDecl();
      } finally {
        $c$.$destroy();
      }
    }
  }
}


/// CheckDestructorDeclarator - Called by ActOnDeclarator to check
/// the well-formednes of the destructor declarator @p D with type @p
/// R. If there are any errors in the declarator, this routine will
/// emit diagnostics and set the declarator to invalid.  Even if this happens,
/// will be updated to reflect a well-formed type for the destructor and
/// returned.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckDestructorDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6953,
 FQN="clang::Sema::CheckDestructorDeclarator", NM="_ZN5clang4Sema25CheckDestructorDeclaratorERNS_10DeclaratorENS_8QualTypeERNS_12StorageClassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema25CheckDestructorDeclaratorERNS_10DeclaratorENS_8QualTypeERNS_12StorageClassE")
//</editor-fold>
public final QualType CheckDestructorDeclarator(final Declarator /*&*/ D, QualType R, 
                         final type$ref<StorageClass /*&*/> SC) {
  // C++ [class.dtor]p1:
  //   [...] A typedef-name that names a class is a class-name
  //   (7.1.3); however, a typedef-name that names a class shall not
  //   be used as the identifier in the declarator for a destructor
  //   declaration.
  QualType DeclaratorType = GetTypeFromParser(D.getName().Unnamed_field1.DestructorName.$OpaquePtr$T());
  {
    /*const*/ TypedefType /*P*/ TT = DeclaratorType.$arrow().getAs$TypedefType();
    if ((TT != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_destructor_typedef_name)), 
                DeclaratorType), isa_TypeAliasDecl(TT.getDecl())));
      } finally {
        $c$.$destroy();
      }
    } else {
      /*const*/ TemplateSpecializationType /*P*/ TST = DeclaratorType.$arrow().getAs$TemplateSpecializationType();
      if ((TST != null)) {
        if (TST.isTypeAlias()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_destructor_typedef_name)), 
                    DeclaratorType), 1));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  
  // C++ [class.dtor]p2:
  //   A destructor is used to destroy objects of its class type. A
  //   destructor takes no parameters, and no return type can be
  //   specified for it (not even void). The address of a destructor
  //   shall not be taken. A destructor shall not be static. A
  //   destructor can be invoked for a const, volatile or const
  //   volatile object. A destructor shall not be declared const,
  //   volatile or const volatile (9.3.2).
  if (SC.$deref() == StorageClass.SC_Static) {
    if (!D.isInvalidType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_destructor_cannot_be)), 
                        /*KEEP_STR*/"static"), new SourceRange(D.getDeclSpec().getStorageClassSpecLoc())), 
                new SourceRange(D.getIdentifierLoc())), 
            FixItHint.CreateRemoval(new SourceRange(D.getDeclSpec().getStorageClassSpecLoc()))));
      } finally {
        $c$.$destroy();
      }
    }
    
    SC.$set(StorageClass.SC_None);
  }
  if (!D.isInvalidType()) {
    // Destructors don't have return types, but the parser will
    // happily parse something like:
    //
    //   class X {
    //     float ~X();
    //   };
    //
    // The return type will be eliminated later.
    if (D.getDeclSpec().hasTypeSpecifier()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_destructor_return_type)), 
                new SourceRange(D.getDeclSpec().getTypeSpecTypeLoc())), 
            new SourceRange(D.getIdentifierLoc())));
      } finally {
        $c$.$destroy();
      }
    } else {
      /*uint*/int TypeQuals = D.getDeclSpec().getTypeQualifiers();
      if ((TypeQuals != 0)) {
        $this().diagnoseIgnoredQualifiers(diag.err_destructor_return_type, TypeQuals, 
            new SourceLocation(), 
            D.getDeclSpec().getConstSpecLoc(), 
            D.getDeclSpec().getVolatileSpecLoc(), 
            D.getDeclSpec().getRestrictSpecLoc(), 
            D.getDeclSpec().getAtomicSpecLoc());
        D.setInvalidType();
      }
    }
  }
  
  final DeclaratorChunk.FunctionTypeInfo /*&*/ FTI = D.getFunctionTypeInfo();
  if ($4bits_uint2uint(FTI.TypeQuals) != 0 && !D.isInvalidType()) {
    if ((($4bits_uint2uint(FTI.TypeQuals) & Qualifiers.TQ.Const) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_invalid_qualified_destructor)), 
                /*KEEP_STR*/"const"), new SourceRange(D.getIdentifierLoc())));
      } finally {
        $c$.$destroy();
      }
    }
    if ((($4bits_uint2uint(FTI.TypeQuals) & Qualifiers.TQ.Volatile) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_invalid_qualified_destructor)), 
                /*KEEP_STR*/"volatile"), new SourceRange(D.getIdentifierLoc())));
      } finally {
        $c$.$destroy();
      }
    }
    if ((($4bits_uint2uint(FTI.TypeQuals) & Qualifiers.TQ.Restrict) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_invalid_qualified_destructor)), 
                /*KEEP_STR*/"restrict"), new SourceRange(D.getIdentifierLoc())));
      } finally {
        $c$.$destroy();
      }
    }
    D.setInvalidType();
  }
  
  // C++0x [class.dtor]p2:
  //   A destructor shall not be declared with a ref-qualifier.
  if (FTI.hasRefQualifier()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FTI.getRefQualifierLoc(), diag.err_ref_qualifier_destructor)), 
              FTI.RefQualifierIsLValueRef), 
          FixItHint.CreateRemoval(new SourceRange(FTI.getRefQualifierLoc()))));
      D.setInvalidType();
    } finally {
      $c$.$destroy();
    }
  }
  
  // Make sure we don't have any parameters.
  if (FTIHasNonVoidParameters(FTI)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_destructor_with_params)));
      
      // Delete the parameters.
      FTI.freeParams();
      D.setInvalidType();
    } finally {
      $c$.$destroy();
    }
  }
  
  // Make sure the destructor isn't variadic.
  if (FTI.isVariadic) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_destructor_variadic)));
      D.setInvalidType();
    } finally {
      $c$.$destroy();
    }
  }
  
  // Rebuild the function type "R" without any type qualifiers or
  // parameters (in case any of the errors above fired) and with
  // "void" as the return type, since destructors don't have return
  // types. 
  if (!D.isInvalidType()) {
    return new QualType(JD$Move.INSTANCE, R);
  }
  
  /*const*/ FunctionProtoType /*P*/ Proto = R.$arrow().getAs(FunctionProtoType.class);
  FunctionProtoType.ExtProtoInfo EPI = Proto.getExtProtoInfo();
  EPI.Variadic = false;
  EPI.TypeQuals = 0;
  EPI.RefQualifier = RefQualifierKind.RQ_None;
  return $this().Context.getFunctionType($this().Context.VoidTy.$QualType(), new ArrayRef<QualType>(None, false), EPI);
}


/// CheckDestructor - Checks a fully-formed destructor definition for
/// well-formedness, issuing any diagnostics required.  Returns true
/// on error.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckDestructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6917,
 FQN="clang::Sema::CheckDestructor", NM="_ZN5clang4Sema15CheckDestructorEPNS_17CXXDestructorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema15CheckDestructorEPNS_17CXXDestructorDeclE")
//</editor-fold>
public final boolean CheckDestructor(CXXDestructorDecl /*P*/ Destructor) {
  CXXRecordDecl /*P*/ RD = Destructor.getParent();
  if (!(Destructor.getOperatorDelete() != null) && Destructor.isVirtual()) {
    SourceLocation Loc/*J*/= new SourceLocation();
    if (!Destructor.isImplicit()) {
      Loc.$assignMove(Destructor.getLocation());
    } else {
      Loc.$assignMove(RD.getLocation());
    }
    
    // If we have a virtual destructor, look up the deallocation function
    type$ref<FunctionDecl /*P*/ > OperatorDelete = create_type$null$ref(null);
    DeclarationName Name = $this().Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_Delete);
    if ($this().FindDeallocationFunction(new SourceLocation(Loc), RD, new DeclarationName(Name), OperatorDelete)) {
      return true;
    }
    // If there's no class-specific operator delete, look up the global
    // non-array delete.
    if (!(OperatorDelete.$deref() != null)) {
      OperatorDelete.$set($this().FindUsualDeallocationFunction(new SourceLocation(Loc), true, new DeclarationName(Name)));
    }
    
    $this().MarkFunctionReferenced(new SourceLocation(Loc), OperatorDelete.$deref());
    
    Destructor.setOperatorDelete(OperatorDelete.$deref());
  }
  
  return false;
}


/// CheckConversionDeclarator - Called by ActOnDeclarator to check the
/// well-formednes of the conversion function declarator @p D with
/// type @p R. If there are any errors in the declarator, this routine
/// will emit diagnostics and return true. Otherwise, it will return
/// false. Either way, the type @p R will be updated to reflect a
/// well-formed type for the conversion operator.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckConversionDeclarator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 7086,
 FQN="clang::Sema::CheckConversionDeclarator", NM="_ZN5clang4Sema25CheckConversionDeclaratorERNS_10DeclaratorERNS_8QualTypeERNS_12StorageClassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema25CheckConversionDeclaratorERNS_10DeclaratorERNS_8QualTypeERNS_12StorageClassE")
//</editor-fold>
public final void CheckConversionDeclarator(final Declarator /*&*/ D, final QualType /*&*/ R, 
                         final type$ref<StorageClass /*&*/> SC) {
  // C++ [class.conv.fct]p1:
  //   Neither parameter types nor return type can be specified. The
  //   type of a conversion function (8.3.5) is "function taking no
  //   parameter returning conversion-type-id."
  if (SC.$deref() == StorageClass.SC_Static) {
    if (!D.isInvalidType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_conv_function_not_member)), 
                new SourceRange(D.getDeclSpec().getStorageClassSpecLoc())), 
            D.getName().getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
    D.setInvalidType();
    SC.$set(StorageClass.SC_None);
  }
  
  type$ptr<TypeSourceInfo /*P*/ > ConvTSI = create_type$null$ptr(null);
  QualType ConvType = GetTypeFromParser(D.getName().Unnamed_field1.ConversionFunctionId.$OpaquePtr$T(), $AddrOf(ConvTSI));
  if (D.getDeclSpec().hasTypeSpecifier() && !D.isInvalidType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Conversion functions don't have return types, but the parser will
      // happily parse something like:
      //
      //   class X {
      //     float operator bool();
      //   };
      //
      // The return type will be changed later anyway.
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_conv_function_return_type)), 
              new SourceRange(D.getDeclSpec().getTypeSpecTypeLoc())), 
          new SourceRange(D.getIdentifierLoc())));
      D.setInvalidType();
    } finally {
      $c$.$destroy();
    }
  }
  
  /*const*/ FunctionProtoType /*P*/ Proto = R.$arrow().getAs(FunctionProtoType.class);
  
  // Make sure we don't have any parameters.
  if ($greater_uint(Proto.getNumParams(), 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_conv_function_with_params)));
      
      // Delete the parameters.
      D.getFunctionTypeInfo().freeParams();
      D.setInvalidType();
    } finally {
      $c$.$destroy();
    }
  } else if (Proto.isVariadic()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_conv_function_variadic)));
      D.setInvalidType();
    } finally {
      $c$.$destroy();
    }
  }
  
  // Diagnose "&operator bool()" and other such nonsense.  This
  // is actually a gcc extension which we don't support.
  if (QualType.$noteq_QualType$C(Proto.getReturnType(), ConvType)) {
    boolean NeedsTypedef = false;
    SourceRange Before/*J*/= new SourceRange();
    SourceRange After/*J*/= new SourceRange();
    
    // Walk the chunks and extract information on them for our diagnostic.
    boolean PastFunctionChunk = false;
    for (final /*const*/ DeclaratorChunk /*&*/ Chunk : D.type_objects()) {
      switch (Chunk.Kind) {
       case Function:
        if (!PastFunctionChunk) {
          if (Chunk.Unnamed_field3.Fun.HasTrailingReturnType) {
            type$ptr<TypeSourceInfo /*P*/ > TRT = create_type$null$ptr(null);
            GetTypeFromParser(Chunk.Unnamed_field3.Fun.getTrailingReturnType(), $AddrOf(TRT));
            if ((TRT.$star() != null)) {
              SemaDeclCXXStatics.extendRight(After, TRT.$star().getTypeLoc().getSourceRange());
            }
          }
          PastFunctionChunk = true;
          break;
        }
       case Array:
        // Fall through.
        NeedsTypedef = true;
        SemaDeclCXXStatics.extendRight(After, Chunk.getSourceRange());
        break;
       case Pointer:
       case BlockPointer:
       case Reference:
       case MemberPointer:
       case Pipe:
        SemaDeclCXXStatics.extendLeft(Before, Chunk.getSourceRange());
        break;
       case Paren:
        SemaDeclCXXStatics.extendLeft(Before, new SourceRange(/*NO_COPY*/Chunk.Loc));
        SemaDeclCXXStatics.extendRight(After, new SourceRange(/*NO_COPY*/Chunk.EndLoc));
        break;
      }
    }
    
    SourceLocation Loc = Before.isValid() ? Before.getBegin() : After.isValid() ? After.getBegin() : D.getIdentifierLoc();
    /*final*/ SemaDiagnosticBuilder /*&&*/DB = null; // WHY MANUAL???
    try {
      /*final*/DB = $this().Diag(new SourceLocation(Loc), diag.err_conv_function_with_complex_decl);
      SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(DB, Before), After);
      if (!NeedsTypedef) {
        SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(DB, /*don't need a typedef*/ 0);

        // If we can provide a correct fix-it hint, do so.
        if (After.isInvalid() && (ConvTSI.$star() != null)) {
          SourceLocation InsertLoc = $this().getLocForEndOfToken(ConvTSI.$star().getTypeLoc().getLocEnd());
          SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint(DB, FixItHint.CreateInsertion(/*NO_COPY*/InsertLoc, new StringRef(/*KEEP_STR*/$SPACE))), 
                  FixItHint.CreateInsertionFromRange(/*NO_COPY*/InsertLoc, CharSourceRange.getTokenRange(/*NO_COPY*/Before))), 
              FixItHint.CreateRemoval(/*NO_COPY*/Before));
        }
      } else if (!Proto.getReturnType().$arrow().isDependentType()) {
        SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(DB, /*typedef*/ 1), Proto.getReturnType());
      } else if ($this().getLangOpts().CPlusPlus11) {
        SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(DB, /*alias template*/ 2), Proto.getReturnType());
      } else {
        SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(DB, /*might not be fixable*/ 3);
      }
    } finally {
      if (DB != null) { DB.$destroy(); }
    }
    // Recover by incorporating the other type chunks into the result type.
    // Note, this does *not* change the name of the function. This is compatible
    // with the GCC extension:
    //   struct S { &operator int(); } s;
    //   int &r = s.operator int(); // ok in GCC
    //   S::operator int&() {} // error in GCC, function name is 'operator int'.
    ConvType.$assignMove(Proto.getReturnType());
  }
  
  // C++ [class.conv.fct]p4:
  //   The conversion-type-id shall not represent a function type nor
  //   an array type.
  if (ConvType.$arrow().isArrayType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_conv_function_to_array)));
      ConvType.$assignMove($this().Context.getPointerType(/*NO_COPY*/ConvType));
      D.setInvalidType();
    } finally {
      $c$.$destroy();
    }
  } else if (ConvType.$arrow().isFunctionType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_conv_function_to_function)));
      ConvType.$assignMove($this().Context.getPointerType(/*NO_COPY*/ConvType));
      D.setInvalidType();
    } finally {
      $c$.$destroy();
    }
  }
  
  // Rebuild the function type "R" without any parameters (in case any
  // of the errors above fired) and with the conversion type as the
  // return type.
  if (D.isInvalidType()) {
    R.$assignMove($this().Context.getFunctionType(new QualType(ConvType), new ArrayRef<QualType>(None, false), Proto.getExtProtoInfo()));
  }
  
  // C++0x explicit conversion operators.
  if (D.getDeclSpec().isExplicitSpecified()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(D.getDeclSpec().getExplicitSpecLoc(), 
              $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_explicit_conversion_functions : diag.ext_explicit_conversion_functions)), 
          new SourceRange(D.getDeclSpec().getExplicitSpecLoc())));
    } finally {
      $c$.$destroy();
    }
  }
}


/// ActOnConversionDeclarator - Called by ActOnDeclarator to complete
/// the declaration of the given C++ conversion function. This routine
/// is responsible for recording the conversion function in the C++
/// class, if possible.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnConversionDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 7242,
 FQN="clang::Sema::ActOnConversionDeclarator", NM="_ZN5clang4Sema25ActOnConversionDeclaratorEPNS_17CXXConversionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema25ActOnConversionDeclaratorEPNS_17CXXConversionDeclE")
//</editor-fold>
public final Decl /*P*/ ActOnConversionDeclarator(CXXConversionDecl /*P*/ Conversion) {
  assert ((Conversion != null)) : "Expected to receive a conversion function declaration";
  
  CXXRecordDecl /*P*/ ClassDecl = cast_CXXRecordDecl(Conversion.getDeclContext());
  
  // Make sure we aren't redeclaring the conversion function.
  QualType ConvType = $this().Context.getCanonicalType(Conversion.getConversionType()).$QualType();
  
  // C++ [class.conv.fct]p1:
  //   [...] A conversion function is never used to convert a
  //   (possibly cv-qualified) object to the (possibly cv-qualified)
  //   same object type (or a reference to it), to a (possibly
  //   cv-qualified) base class of that type (or a reference to it),
  //   or to (possibly cv-qualified) void.
  // FIXME: Suppress this warning if the conversion function ends up being a
  // virtual function that overrides a virtual function in a base class.
  QualType ClassType = $this().Context.getCanonicalType($this().Context.getTypeDeclType(ClassDecl)).$QualType();
  {
    /*const*/ ReferenceType /*P*/ ConvTypeRef = ConvType.$arrow().getAs(ReferenceType.class);
    if ((ConvTypeRef != null)) {
      ConvType.$assignMove(ConvTypeRef.getPointeeType());
    }
  }
  if (Conversion.getTemplateSpecializationKind() != TemplateSpecializationKind.TSK_Undeclared
     && Conversion.getTemplateSpecializationKind() != TemplateSpecializationKind.TSK_ExplicitSpecialization) {
/* Suppress diagnostics for instantiations. */     ;
  } else if (ConvType.$arrow().isRecordType()) {
    ConvType.$assignMove($this().Context.getCanonicalType(/*NO_COPY*/ConvType).getUnqualifiedType().$QualType());
    if (QualType.$eq_QualType$C(ConvType, ClassType)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Conversion.getLocation(), diag.warn_conv_to_self_not_used)), 
            ClassType));
      } finally {
        $c$.$destroy();
      }
    } else if ($this().IsDerivedFrom(Conversion.getLocation(), new QualType(ClassType), new QualType(ConvType))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Conversion.getLocation(), diag.warn_conv_to_base_not_used)), 
                ClassType), ConvType));
      } finally {
        $c$.$destroy();
      }
    }
  } else if (ConvType.$arrow().isVoidType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Conversion.getLocation(), diag.warn_conv_to_void_not_used)), 
              ClassType), ConvType));
    } finally {
      $c$.$destroy();
    }
  }
  {
    
    FunctionTemplateDecl /*P*/ ConversionTemplate = Conversion.getDescribedFunctionTemplate();
    if ((ConversionTemplate != null)) {
      return ConversionTemplate;
    }
  }
  
  return Conversion;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckExplicitlyDefaultedSpecialMember">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5350,
 FQN="clang::Sema::CheckExplicitlyDefaultedSpecialMember", NM="_ZN5clang4Sema37CheckExplicitlyDefaultedSpecialMemberEPNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema37CheckExplicitlyDefaultedSpecialMemberEPNS_13CXXMethodDeclE")
//</editor-fold>
public final void CheckExplicitlyDefaultedSpecialMember(CXXMethodDecl /*P*/ MD) {
  CXXRecordDecl /*P*/ RD = MD.getParent();
  CXXSpecialMember CSM = $this().getSpecialMember(MD);
  assert (MD.isExplicitlyDefaulted() && CSM != CXXSpecialMember.CXXInvalid) : "not an explicitly-defaulted special member";
  
  // Whether this was the first-declared instance of the constructor.
  // This affects whether we implicitly add an exception spec and constexpr.
  boolean First = MD == MD.getCanonicalDecl();
  
  boolean HadError = false;
  
  // C++11 [dcl.fct.def.default]p1:
  //   A function that is explicitly defaulted shall
  //     -- be a special member function (checked elsewhere),
  //     -- have the same type (except for ref-qualifiers, and except that a
  //        copy operation can take a non-const reference) as an implicit
  //        declaration, and
  //     -- not have default arguments.
  /*uint*/int ExpectedParams = 1;
  if (CSM == CXXSpecialMember.CXXDefaultConstructor || CSM == CXXSpecialMember.CXXDestructor) {
    ExpectedParams = 0;
  }
  if (MD.getNumParams() != ExpectedParams) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // This also checks for default arguments: a copy or move constructor with a
      // default argument is classified as a default constructor, and assignment
      // operations and destructors can't have default arguments.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MD.getLocation(), diag.err_defaulted_special_member_params)), 
              CSM), MD.getSourceRange()));
      HadError = true;
    } finally {
      $c$.$destroy();
    }
  } else if (MD.isVariadic()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MD.getLocation(), diag.err_defaulted_special_member_variadic)), 
              CSM), MD.getSourceRange()));
      HadError = true;
    } finally {
      $c$.$destroy();
    }
  }
  
  /*const*/ FunctionProtoType /*P*/ Type = MD.getType().$arrow().getAs(FunctionProtoType.class);
  
  boolean CanHaveConstParam = false;
  if (CSM == CXXSpecialMember.CXXCopyConstructor) {
    CanHaveConstParam = RD.implicitCopyConstructorHasConstParam();
  } else if (CSM == CXXSpecialMember.CXXCopyAssignment) {
    CanHaveConstParam = RD.implicitCopyAssignmentHasConstParam();
  }
  
  QualType ReturnType = $this().Context.VoidTy.$QualType();
  if (CSM == CXXSpecialMember.CXXCopyAssignment || CSM == CXXSpecialMember.CXXMoveAssignment) {
    // Check for return type matching.
    ReturnType.$assignMove(Type.getReturnType());
    QualType ExpectedReturnType = $this().Context.getLValueReferenceType($this().Context.getTypeDeclType(RD));
    if (!$this().Context.hasSameType(new QualType(ReturnType), new QualType(ExpectedReturnType))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MD.getLocation(), diag.err_defaulted_special_member_return_type)), 
                (CSM == CXXSpecialMember.CXXMoveAssignment)), ExpectedReturnType));
        HadError = true;
      } finally {
        $c$.$destroy();
      }
    }
    
    // A defaulted special member cannot have cv-qualifiers.
    if ((Type.getTypeQuals() != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MD.getLocation(), diag.err_defaulted_special_member_quals)), 
                (CSM == CXXSpecialMember.CXXMoveAssignment)), $this().getLangOpts().CPlusPlus14));
        HadError = true;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Check for parameter type matching.
  QualType ArgType = (ExpectedParams != 0) ? Type.getParamType(0) : new QualType();
  boolean HasConstParam = false;
  if ((ExpectedParams != 0) && ArgType.$arrow().isReferenceType()) {
    // Argument must be reference to possibly-const T.
    QualType ReferentType = ArgType.$arrow().getPointeeType();
    HasConstParam = ReferentType.isConstQualified();
    if (ReferentType.isVolatileQualified()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MD.getLocation(), 
                diag.err_defaulted_special_member_volatile_param)), CSM));
        HadError = true;
      } finally {
        $c$.$destroy();
      }
    }
    if (HasConstParam && !CanHaveConstParam) {
      if (CSM == CXXSpecialMember.CXXCopyConstructor || CSM == CXXSpecialMember.CXXCopyAssignment) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MD.getLocation(), 
                  diag.err_defaulted_special_member_copy_const_param)), 
              (CSM == CXXSpecialMember.CXXCopyAssignment)));
        } finally {
          $c$.$destroy();
        }
        // FIXME: Explain why this special member can't be const.
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MD.getLocation(), 
                  diag.err_defaulted_special_member_move_const_param)), 
              (CSM == CXXSpecialMember.CXXMoveAssignment)));
        } finally {
          $c$.$destroy();
        }
      }
      HadError = true;
    }
  } else if ((ExpectedParams != 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // A copy assignment operator can take its argument by value, but a
      // defaulted one cannot.
      assert (CSM == CXXSpecialMember.CXXCopyAssignment) : "unexpected non-ref argument";
      $c$.clean($c$.track($this().Diag(MD.getLocation(), diag.err_defaulted_copy_assign_not_ref)));
      HadError = true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // C++11 [dcl.fct.def.default]p2:
  //   An explicitly-defaulted function may be declared constexpr only if it
  //   would have been implicitly declared as constexpr,
  // Do not apply this rule to members of class templates, since core issue 1358
  // makes such functions always instantiate to constexpr functions. For
  // functions which cannot be constexpr (for non-constructors in C++11 and for
  // destructors in C++1y), this is checked elsewhere.
  boolean Constexpr = defaultedSpecialMemberIsConstexpr(/*Deref*/$this(), RD, CSM, 
      HasConstParam);
  if (($this().getLangOpts().CPlusPlus14 ? !isa_CXXDestructorDecl(MD) : isa_CXXConstructorDecl(MD))
     && MD.isConstexpr() && !Constexpr
     && MD.getTemplatedKind() == FunctionDecl.TemplatedKind.TK_NonTemplate) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MD.getLocStart(), diag.err_incorrect_defaulted_constexpr)), CSM));
      // FIXME: Explain why the special member can't be constexpr.
      HadError = true;
    } finally {
      $c$.$destroy();
    }
  }
  
  //   and may have an explicit exception-specification only if it is compatible
  //   with the exception-specification on the implicit declaration.
  if (Type.hasExceptionSpec()) {
    // Delay the check if this is the first declaration of the special member,
    // since we may not have parsed some necessary in-class initializers yet.
    if (First) {
      // If the exception specification needs to be instantiated, do so now,
      // before we clobber it with an EST_Unevaluated specification below.
      if (Type.getExceptionSpecType() == ExceptionSpecificationType.EST_Uninstantiated) {
        $this().InstantiateExceptionSpec(MD.getLocStart(), MD);
        Type = MD.getType().$arrow().getAs(FunctionProtoType.class);
      }
      $this().DelayedDefaultedMemberExceptionSpecs.push_back(std.make_pair_Ptr_Ptr(MD, Type));
    } else {
      $this().CheckExplicitlyDefaultedMemberExceptionSpec(MD, Type);
    }
  }
  
  //   If a function is explicitly defaulted on its first declaration,
  if (First) {
    //  -- it is implicitly considered to be constexpr if the implicit
    //     definition would be,
    MD.setConstexpr(Constexpr);
    
    //  -- it is implicitly considered to have the same exception-specification
    //     as if it had been implicitly declared,
    FunctionProtoType.ExtProtoInfo EPI = Type.getExtProtoInfo();
    EPI.ExceptionSpec.Type = ExceptionSpecificationType.EST_Unevaluated;
    EPI.ExceptionSpec.SourceDecl = MD;
    MD.setType($this().Context.getFunctionType(new QualType(ReturnType), 
            llvm.makeArrayRef($AddrOf(ArgType), 
                ExpectedParams), 
            EPI));
  }
  if ($this().ShouldDeleteSpecialMember(MD, CSM)) {
    if (First) {
      $this().SetDeclDeleted(MD, MD.getLocation());
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // C++11 [dcl.fct.def.default]p4:
        //   [For a] user-provided explicitly-defaulted function [...] if such a
        //   function is implicitly defined as deleted, the program is ill-formed.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MD.getLocation(), diag.err_out_of_line_default_deletes)), CSM));
        $this().ShouldDeleteSpecialMember(MD, CSM, (InheritedConstructorInfo /*P*/ )null, /*Diagnose*/ true);
        HadError = true;
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (HadError) {
    MD.setInvalidDecl();
  }
}


/// Check whether the exception specification provided for an
/// explicitly-defaulted special member matches the exception specification
/// that would have been generated for an implicit special member, per
/// C++11 [dcl.fct.def.default]p2.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckExplicitlyDefaultedMemberExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5522,
 FQN="clang::Sema::CheckExplicitlyDefaultedMemberExceptionSpec", NM="_ZN5clang4Sema43CheckExplicitlyDefaultedMemberExceptionSpecEPNS_13CXXMethodDeclEPKNS_17FunctionProtoTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema43CheckExplicitlyDefaultedMemberExceptionSpecEPNS_13CXXMethodDeclEPKNS_17FunctionProtoTypeE")
//</editor-fold>
public final void CheckExplicitlyDefaultedMemberExceptionSpec(CXXMethodDecl /*P*/ MD, /*const*/ FunctionProtoType /*P*/ SpecifiedType) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // If the exception specification was explicitly specified but hadn't been
    // parsed when the method was defaulted, grab it now.
    if (SpecifiedType.getExceptionSpecType() == ExceptionSpecificationType.EST_Unparsed) {
      SpecifiedType
         = MD.getTypeSourceInfo().getType().$arrow().castAs(FunctionProtoType.class);
    }
    
    // Compute the implicit exception specification.
    CallingConv CC = $this().Context.getDefaultCallingConvention(/*IsVariadic=*/ false, 
        /*IsCXXMethod=*/ true);
    FunctionProtoType.ExtProtoInfo EPI/*J*/= new FunctionProtoType.ExtProtoInfo(CC);
    $c$.clean(EPI.ExceptionSpec.$assignMove($c$.track(computeImplicitExceptionSpec(/*Deref*/$this(), MD.getLocation(), MD)).
            getExceptionSpec()));
    /*const*/ FunctionProtoType /*P*/ ImplicitType = cast_FunctionProtoType($this().Context.getFunctionType($this().Context.VoidTy.$QualType(), new ArrayRef<QualType>(None, false), EPI));
    
    // Ensure that it matches.
    $c$.clean($this().CheckEquivalentExceptionSpec($out_PartialDiagnostic$C_int($c$.track($this().PDiag(diag.err_incorrect_defaulted_exception_spec)), 
            $this().getSpecialMember(MD).getValue()), $c$.track($this().PDiag()), 
        ImplicitType, new SourceLocation(), 
        SpecifiedType, MD.getLocation()));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckDelayedMemberExceptionSpecs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5547,
 FQN="clang::Sema::CheckDelayedMemberExceptionSpecs", NM="_ZN5clang4Sema32CheckDelayedMemberExceptionSpecsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema32CheckDelayedMemberExceptionSpecsEv")
//</editor-fold>
public final void CheckDelayedMemberExceptionSpecs() {
  SmallVector<std.pair</*const*/ CXXMethodDecl /*P*/ , /*const*/ CXXMethodDecl /*P*/ >> Checks/*J*/= new SmallVector<std.pair</*const*/ CXXMethodDecl /*P*/ , /*const*/ CXXMethodDecl /*P*/ >>(2, new std.pairPtrPtr</*const*/ CXXMethodDecl /*P*/ , /*const*/ CXXMethodDecl /*P*/ >());
  SmallVector<std.pair<CXXMethodDecl /*P*/ , /*const*/ FunctionProtoType /*P*/ >> Specs/*J*/= new SmallVector<std.pair<CXXMethodDecl /*P*/ , /*const*/ FunctionProtoType /*P*/ >>(2, new std.pairPtrPtr<CXXMethodDecl /*P*/ , /*const*/ FunctionProtoType /*P*/ >());
  
  std.swap(Checks, $this().DelayedExceptionSpecChecks);
  std.swap(Specs, $this().DelayedDefaultedMemberExceptionSpecs);
  
  // Perform any deferred checking of exception specifications for virtual
  // destructors.
  for (final pair</*const*/ CXXMethodDecl /*P*/ , /*const*/ CXXMethodDecl /*P*/ > /*&*/ Check : Checks)  {
    $this().CheckOverridingFunctionExceptionSpec(Check.first, Check.second);
  }
  
  // Check that any explicitly-defaulted methods have exception specifications
  // compatible with their implicit exception specifications.
  for (final pair<CXXMethodDecl /*P*/ , /*const*/ FunctionProtoType /*P*/ > /*&*/ Spec : Specs)  {
    $this().CheckExplicitlyDefaultedMemberExceptionSpec(Spec.first, Spec.second);
  }
}


//===--------------------------------------------------------------------===//
// C++ Derived Classes
//

/// ActOnBaseSpecifier - Parsed a base specifier

/// \brief Check the validity of a C++ base class specifier.
///
/// \returns a new CXXBaseSpecifier if well-formed, emits diagnostics
/// and returns NULL otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckBaseSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 1350,
 FQN="clang::Sema::CheckBaseSpecifier", NM="_ZN5clang4Sema18CheckBaseSpecifierEPNS_13CXXRecordDeclENS_11SourceRangeEbNS_15AccessSpecifierEPNS_14TypeSourceInfoENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema18CheckBaseSpecifierEPNS_13CXXRecordDeclENS_11SourceRangeEbNS_15AccessSpecifierEPNS_14TypeSourceInfoENS_14SourceLocationE")
//</editor-fold>
public final CXXBaseSpecifier /*P*/ CheckBaseSpecifier(CXXRecordDecl /*P*/ Class, 
                  SourceRange SpecifierRange, 
                  boolean Virtual, AccessSpecifier Access, 
                  TypeSourceInfo /*P*/ TInfo, 
                  SourceLocation EllipsisLoc) {
  QualType BaseType = TInfo.getType();
  
  // C++ [class.union]p1:
  //   A union shall not have base classes.
  if (Class.isUnion()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Class.getLocation(), diag.err_base_clause_on_union)), 
          SpecifierRange));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  if (EllipsisLoc.isValid()
     && !TInfo.getType().$arrow().containsUnexpandedParameterPack()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(EllipsisLoc), diag.err_pack_expansion_without_parameter_packs)), 
          TInfo.getTypeLoc().getSourceRange()));
      EllipsisLoc.$assignMove(new SourceLocation());
    } finally {
      $c$.$destroy();
    }
  }
  
  SourceLocation BaseLoc = TInfo.getTypeLoc().getBeginLoc();
  if (BaseType.$arrow().isDependentType()) {
    {
      // Make sure that we don't have circular inheritance among our dependent
      // bases. For non-dependent bases, the check for completeness below handles
      // this.
      CXXRecordDecl /*P*/ BaseDecl = BaseType.$arrow().getAsCXXRecordDecl();
      if ((BaseDecl != null)) {
        if (BaseDecl.getCanonicalDecl() == Class.getCanonicalDecl()
           || (((BaseDecl = BaseDecl.getDefinition()) != null)
           && findCircularInheritance(Class, BaseDecl))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(BaseLoc), diag.err_circular_inheritance)), 
                    BaseType), $this().Context.getTypeDeclType(Class)));
            if (BaseDecl.getCanonicalDecl() != Class.getCanonicalDecl()) {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(BaseDecl.getLocation(), diag.note_previous_decl)), 
                  BaseType));
            }
            
            return null;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    return /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (Context)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
        return new CXXBaseSpecifier(new SourceRange(SpecifierRange), Virtual, 
                Class.getTagKind() == TagTypeKind.TTK_Class, 
                Access, TInfo, new SourceLocation(EllipsisLoc));
     });
  }
  
  // Base specifiers must be record types.
  if (!BaseType.$arrow().isRecordType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(BaseLoc), diag.err_base_must_be_class)), SpecifierRange));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  
  // C++ [class.union]p1:
  //   A union shall not be used as a base class.
  if (BaseType.$arrow().isUnionType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(BaseLoc), diag.err_union_as_base_class)), SpecifierRange));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  
  // For the MS ABI, propagate DLL attributes to base class templates.
  if ($this().Context.getTargetInfo().getCXXABI().isMicrosoft()) {
    {
      Attr /*P*/ ClassAttr = getDLLAttr(Class);
      if ((ClassAttr != null)) {
        {
          ClassTemplateSpecializationDecl /*P*/ BaseTemplate = dyn_cast_or_null_ClassTemplateSpecializationDecl(BaseType.$arrow().getAsCXXRecordDecl());
          if ((BaseTemplate != null)) {
            $this().propagateDLLAttrToBaseClassTemplate(Class, ClassAttr, BaseTemplate, 
                new SourceLocation(BaseLoc));
          }
        }
      }
    }
  }
  
  // C++ [class.derived]p2:
  //   The class-name in a base-specifier shall not be an incompletely
  //   defined class.
  if ($this().RequireCompleteType$T(new SourceLocation(BaseLoc), new QualType(BaseType), 
      diag.err_incomplete_base_class, SpecifierRange)) {
    Class.setInvalidDecl();
    return null;
  }
  
  // If the base class is polymorphic or isn't empty, the new one is/isn't, too.
  RecordDecl /*P*/ BaseDecl = BaseType.$arrow().getAs$RecordType().getDecl();
  assert ((BaseDecl != null)) : "Record type has no declaration";
  BaseDecl = BaseDecl.getDefinition();
  assert ((BaseDecl != null)) : "Base type is not incomplete, but has no definition";
  CXXRecordDecl /*P*/ CXXBaseDecl = cast_CXXRecordDecl(BaseDecl);
  assert ((CXXBaseDecl != null)) : "Base type is not a C++ type";
  
  // A class which contains a flexible array member is not suitable for use as a
  // base class:
  //   - If the layout determines that a base comes before another base,
  //     the flexible array member would index into the subsequent base.
  //   - If the layout determines that base comes before the derived class,
  //     the flexible array member would index into the derived class.
  if (CXXBaseDecl.hasFlexibleArrayMember()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(BaseLoc), diag.err_base_class_has_flexible_array_member)), 
          CXXBaseDecl.getDeclName()));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  {
    
    // C++ [class]p3:
    //   If a class is marked final and it appears as a base-type-specifier in
    //   base-clause, the program is ill-formed.
    FinalAttr /*P*/ FA = CXXBaseDecl.getAttr(FinalAttr.class);
    if ((FA != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(BaseLoc), diag.err_class_marked_final_used_as_base)), 
                CXXBaseDecl.getDeclName()), 
            FA.isSpelledAsSealed()));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(CXXBaseDecl.getLocation(), diag.note_entity_declared_at)), 
                CXXBaseDecl.getDeclName()), FA.getRange()));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (BaseDecl.isInvalidDecl()) {
    Class.setInvalidDecl();
  }
  
  // Create the base specifier.
  return /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
  /*new (Context)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
      return new CXXBaseSpecifier(new SourceRange(SpecifierRange), Virtual, 
              Class.getTagKind() == TagTypeKind.TTK_Class, 
              Access, TInfo, new SourceLocation(EllipsisLoc));
   });
}


/// ActOnBaseSpecifier - Parsed a base specifier. A base specifier is
/// one entry in the base class list of a class specifier, for
/// example:
///    class foo : public bar, virtual private baz {
/// 'public bar' and 'virtual private baz' are each base-specifiers.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnBaseSpecifier">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 1478,
 FQN="clang::Sema::ActOnBaseSpecifier", NM="_ZN5clang4Sema18ActOnBaseSpecifierEPNS_4DeclENS_11SourceRangeERNS_16ParsedAttributesEbNS_15AccessSpecifierENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationESA_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema18ActOnBaseSpecifierEPNS_4DeclENS_11SourceRangeERNS_16ParsedAttributesEbNS_15AccessSpecifierENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationESA_")
//</editor-fold>
public final ActionResultTTrue<CXXBaseSpecifier /*P*/ > ActOnBaseSpecifier(Decl /*P*/ _classdecl, SourceRange SpecifierRange, 
                  final ParsedAttributes /*&*/ Attributes, 
                  boolean Virtual, AccessSpecifier Access, 
                  OpaquePtr<QualType> basetype, SourceLocation BaseLoc, 
                  SourceLocation EllipsisLoc) {
  type$ref<Decl /*P*/> classdecl = create_type$ref(_classdecl);
  if (!(classdecl.$deref() != null)) {
    return new ActionResultTTrue<CXXBaseSpecifier /*P*/ >(true);
  }
  
  $this().AdjustDeclIfTemplate(classdecl);
  CXXRecordDecl /*P*/ Class = dyn_cast_CXXRecordDecl(classdecl.$deref());
  if (!(Class != null)) {
    return new ActionResultTTrue<CXXBaseSpecifier /*P*/ >(true);
  }
  
  // We haven't yet attached the base specifiers.
  Class.setIsParsingBaseSpecifiers();
  
  // We do not support any C++11 attributes on base-specifiers yet.
  // Diagnose any attributes we see.
  if (!Attributes.empty()) {
    for (AttributeList /*P*/ Attr = Attributes.getList(); (Attr != null);
         Attr = Attr.getNext()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        if (Attr.isInvalid()
           || Attr.getKind() == AttributeList.Kind.IgnoredAttribute) {
          continue;
        }
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Attr.getLoc(), 
                Attr.getKind() == AttributeList.Kind.UnknownAttribute ? diag.warn_unknown_attribute_ignored : diag.err_base_specifier_attribute)), 
            Attr.getName()));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr(null);
  GetTypeFromParser(new OpaquePtr<QualType>(basetype), $AddrOf(TInfo));
  if (EllipsisLoc.isInvalid()
     && $this().DiagnoseUnexpandedParameterPack(SpecifierRange.getBegin(), TInfo.$star(), 
      UnexpandedParameterPackContext.UPPC_BaseType)) {
    return new ActionResultTTrue<CXXBaseSpecifier /*P*/ >(true);
  }
  {
    
    CXXBaseSpecifier /*P*/ BaseSpec = $this().CheckBaseSpecifier(Class, new SourceRange(SpecifierRange), 
        Virtual, Access, TInfo.$star(), 
        new SourceLocation(EllipsisLoc));
    if ((BaseSpec != null)) {
      return new ActionResultTTrue<CXXBaseSpecifier /*P*/ >(JD$T.INSTANCE, BaseSpec);
    } else {
      Class.setInvalidDecl();
    }
  }
  
  return new ActionResultTTrue<CXXBaseSpecifier /*P*/ >(true);
}


/// \brief Performs the actual work of attaching the given base class
/// specifiers to a C++ class.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AttachBaseSpecifiers">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 1556,
 FQN="clang::Sema::AttachBaseSpecifiers", NM="_ZN5clang4Sema20AttachBaseSpecifiersEPNS_13CXXRecordDeclEN4llvm15MutableArrayRefIPNS_16CXXBaseSpecifierEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema20AttachBaseSpecifiersEPNS_13CXXRecordDeclEN4llvm15MutableArrayRefIPNS_16CXXBaseSpecifierEEE")
//</editor-fold>
public final boolean AttachBaseSpecifiers(CXXRecordDecl /*P*/ Class, 
                    MutableArrayRef<CXXBaseSpecifier /*P*/ > Bases) {
  std.mapTypePtr<QualType, CXXBaseSpecifier /*P*/ > KnownBaseTypes = null;
  try {
    if (Bases.empty()) {
      return false;
    }
    
    // Used to keep track of which base types we have already seen, so
    // that we can properly diagnose redundant direct base types. Note
    // that the key is always the unqualified canonical type of the base
    // class.
    KnownBaseTypes/*J*/= new std.mapTypePtr<QualType, CXXBaseSpecifier /*P*/ >(new QualTypeOrdering());
    
    // Used to track indirect bases so we can see if a direct base is
    // ambiguous.
    SmallPtrSet<QualType> IndirectBaseTypes/*J*/= new SmallPtrSet<QualType>(DenseMapInfoQualType.$Info(), 4);
    
    // Copy non-redundant base specifiers into permanent storage.
    /*uint*/int NumGoodBases = 0;
    boolean Invalid = false;
    for (/*uint*/int idx = 0; $less_uint(idx, Bases.size()); ++idx) {
      QualType NewBaseType = $this().Context.getCanonicalType(Bases.$at(idx).getType()).$QualType();
      NewBaseType.$assignMove(NewBaseType.getLocalUnqualifiedType());
      
      final type$ref<CXXBaseSpecifier /*P*/ /*&*/> KnownBase = KnownBaseTypes.ref$at(NewBaseType);
      if ((KnownBase.$deref() != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C++ [class.mi]p3:
          //   A class shall not be specified as a direct base class of a
          //   derived class more than once.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Bases.$at(idx).getLocStart(), 
                      diag.err_duplicate_base_class)), 
                  KnownBase.$deref().getType()), 
              Bases.$at(idx).getSourceRange()));
          
          // Delete the duplicate base class specifier; we're going to
          // overwrite its pointer later.
          $this().Context.Deallocate(Bases.$at(idx));
          
          Invalid = true;
        } finally {
          $c$.$destroy();
        }
      } else {
        // Okay, add this new base class.
        KnownBase.$set(Bases.$at(idx));
        Bases.$set(NumGoodBases++, Bases.$at(idx));
        
        // Note this base's direct & indirect bases, if there could be ambiguity.
        if ($greater_uint(Bases.size(), 1)) {
          NoteIndirectBases($this().Context, IndirectBaseTypes, NewBaseType);
        }
        {
          
          /*const*/ RecordType /*P*/ Record = NewBaseType.$arrow().getAs$RecordType();
          if ((Record != null)) {
            /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(Record.getDecl());
            if (Class.isInterface()
               && (!RD.isInterface()
               || KnownBase.$deref().getAccessSpecifier() != AccessSpecifier.AS_public)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                // The Microsoft extension __interface does not permit bases that
                // are not themselves public interfaces.
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(KnownBase.$deref().getLocStart(), diag.err_invalid_base_in_interface)), 
                            getRecordDiagFromTagKind(RD.getTagKind())), RD.getName()), 
                    RD.getSourceRange()));
                Invalid = true;
              } finally {
                $c$.$destroy();
              }
            }
            if (RD.hasAttr(WeakAttr.class)) {
              Class.addAttr(WeakAttr.CreateImplicit($this().Context));
            }
          }
        }
      }
    }
    
    // Attach the remaining base class specifiers to the derived class.
    Class.setBases(Bases.data(), NumGoodBases);
    
    for (/*uint*/int idx = 0; $less_uint(idx, NumGoodBases); ++idx) {
      // Check whether this direct base is inaccessible due to ambiguity.
      QualType BaseType = Bases.$at(idx).getType();
      CanQual<Type> CanonicalBase = $this().Context.getCanonicalType(/*NO_COPY*/BaseType).
          getUnqualifiedType();
      if ((IndirectBaseTypes.count(CanonicalBase.$QualType()) != 0)) {
        CXXBasePaths Paths = null;
        try {
          Paths/*J*/= new CXXBasePaths(/*FindAmbiguities=*/ true, /*RecordPaths=*/ true, 
              /*DetectVirtual=*/ true);
          boolean found = Class.isDerivedFrom(((CanProxyType)CanonicalBase.$arrow()).$arrow().getAsCXXRecordDecl(), Paths);
          assert (found);
          ///*J:(void)*/found;
          if (Paths.isAmbiguous(new CanQual<Type>(CanonicalBase))) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Bases.$at(idx).getLocStart(), diag.warn_inaccessible_base_class)), 
                          BaseType), $this().getAmbiguousPathsDisplayString(Paths)), 
                  Bases.$at(idx).getSourceRange()));
            } finally {
              $c$.$destroy();
            }
          } else {
            assert (Bases.$at(idx).isVirtual());
          }
        } finally {
          if (Paths != null) { Paths.$destroy(); }
        }
      }
      
      // Delete the base class specifier, since its data has been copied
      // into the CXXRecordDecl.
      $this().Context.Deallocate(Bases.$at(idx));
    }
    
    return Invalid;
  } finally {
    if (KnownBaseTypes != null) { KnownBaseTypes.$destroy(); }
  }
}


/// ActOnBaseSpecifiers - Attach the given base specifiers to the
/// class, after checking whether there are any duplicate base
/// classes.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnBaseSpecifiers">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 1657,
 FQN="clang::Sema::ActOnBaseSpecifiers", NM="_ZN5clang4Sema19ActOnBaseSpecifiersEPNS_4DeclEN4llvm15MutableArrayRefIPNS_16CXXBaseSpecifierEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema19ActOnBaseSpecifiersEPNS_4DeclEN4llvm15MutableArrayRefIPNS_16CXXBaseSpecifierEEE")
//</editor-fold>
public final void ActOnBaseSpecifiers(Decl /*P*/ _ClassDecl, 
                   MutableArrayRef<CXXBaseSpecifier /*P*/ > Bases) {
  type$ref<Decl /*P*/> ClassDecl = create_type$ref(_ClassDecl);
  if (!(ClassDecl.$deref() != null) || Bases.empty()) {
    return;
  }
  
  $this().AdjustDeclIfTemplate(ClassDecl);
  $this().AttachBaseSpecifiers(cast_CXXRecordDecl(ClassDecl.$deref()), new MutableArrayRef<CXXBaseSpecifier /*P*/ >(Bases));
}


/// \brief Determine whether the type \p Derived is a C++ class that is
/// derived from the type \p Base.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::IsDerivedFrom">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 1668,
 FQN="clang::Sema::IsDerivedFrom", NM="_ZN5clang4Sema13IsDerivedFromENS_14SourceLocationENS_8QualTypeES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema13IsDerivedFromENS_14SourceLocationENS_8QualTypeES2_")
//</editor-fold>
public final boolean IsDerivedFrom(SourceLocation Loc, QualType Derived, QualType Base) {
  if (!$this().getLangOpts().CPlusPlus) {
    return false;
  }
  
  CXXRecordDecl /*P*/ DerivedRD = Derived.$arrow().getAsCXXRecordDecl();
  if (!(DerivedRD != null)) {
    return false;
  }
  
  CXXRecordDecl /*P*/ BaseRD = Base.$arrow().getAsCXXRecordDecl();
  if (!(BaseRD != null)) {
    return false;
  }
  
  // If either the base or the derived type is invalid, don't try to
  // check whether one is derived from the other.
  if (BaseRD.isInvalidDecl() || DerivedRD.isInvalidDecl()) {
    return false;
  }
  
  // FIXME: In a modules build, do we need the entire path to be visible for us
  // to be able to use the inheritance relationship?
  if (!$this().isCompleteType(new SourceLocation(Loc), new QualType(Derived)) && !DerivedRD.isBeingDefined()) {
    return false;
  }
  
  return DerivedRD.isDerivedFrom(BaseRD);
}


/// \brief Determine whether the type \p Derived is a C++ class that is
/// derived from the type \p Base.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::IsDerivedFrom">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 1695,
 FQN="clang::Sema::IsDerivedFrom", NM="_ZN5clang4Sema13IsDerivedFromENS_14SourceLocationENS_8QualTypeES2_RNS_12CXXBasePathsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema13IsDerivedFromENS_14SourceLocationENS_8QualTypeES2_RNS_12CXXBasePathsE")
//</editor-fold>
public final boolean IsDerivedFrom(SourceLocation Loc, QualType Derived, QualType Base, 
             final CXXBasePaths /*&*/ Paths) {
  if (!$this().getLangOpts().CPlusPlus) {
    return false;
  }
  
  CXXRecordDecl /*P*/ DerivedRD = Derived.$arrow().getAsCXXRecordDecl();
  if (!(DerivedRD != null)) {
    return false;
  }
  
  CXXRecordDecl /*P*/ BaseRD = Base.$arrow().getAsCXXRecordDecl();
  if (!(BaseRD != null)) {
    return false;
  }
  if (!$this().isCompleteType(new SourceLocation(Loc), new QualType(Derived)) && !DerivedRD.isBeingDefined()) {
    return false;
  }
  
  return DerivedRD.isDerivedFrom(BaseRD, Paths);
}


// FIXME: I don't like this name.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildBasePathArray">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 1714,
 FQN="clang::Sema::BuildBasePathArray", NM="_ZN5clang4Sema18BuildBasePathArrayERKNS_12CXXBasePathsERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema18BuildBasePathArrayERKNS_12CXXBasePathsERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEE")
//</editor-fold>
public final void BuildBasePathArray(final /*const*/ CXXBasePaths /*&*/ Paths, 
                  final SmallVector<CXXBaseSpecifier /*P*/> /*&*/ BasePathArray) {
  assert (BasePathArray.empty()) : "Base path array must be empty!";
  assert (Paths.isRecordingPaths()) : "Must record paths!";
  
  final /*const*/ CXXBasePath /*&*/ Path = Paths.front$Const();
  
  // We first go backward and check if we have a virtual base.
  // FIXME: It would be better if CXXBasePath had the base specifier for
  // the nearest virtual base.
  /*uint*/int Start = 0;
  for (/*uint*/int I = Path.size(); I != 0; --I) {
    if (Path.$at$Const(I - 1).Base.isVirtual()) {
      Start = I - 1;
      break;
    }
  }
  
  // Now add all bases.
  for (/*uint*/int I = Start, E = Path.size(); I != E; ++I)  {
    BasePathArray.push_back(((/*const_cast*/CXXBaseSpecifier /*P*/ )(Path.$at$Const(I).Base)));
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckDerivedToBaseConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 1813,
 FQN="clang::Sema::CheckDerivedToBaseConversion", NM="_ZN5clang4Sema28CheckDerivedToBaseConversionENS_8QualTypeES1_NS_14SourceLocationENS_11SourceRangeEPN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema28CheckDerivedToBaseConversionENS_8QualTypeES1_NS_14SourceLocationENS_11SourceRangeEPN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEEb")
//</editor-fold>
public final boolean CheckDerivedToBaseConversion(QualType Derived, QualType Base, 
                            SourceLocation Loc, SourceRange Range) {
  return CheckDerivedToBaseConversion(Derived, Base, 
                            Loc, Range, 
                            (SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, 
                            false);
}
public final boolean CheckDerivedToBaseConversion(QualType Derived, QualType Base, 
                            SourceLocation Loc, SourceRange Range, 
                            SmallVector<CXXBaseSpecifier /*P*/> /*P*/ BasePath/*= null*/) {
  return CheckDerivedToBaseConversion(Derived, Base, 
                            Loc, Range, 
                            BasePath, 
                            false);
}
public final boolean CheckDerivedToBaseConversion(QualType Derived, QualType Base, 
                            SourceLocation Loc, SourceRange Range, 
                            SmallVector<CXXBaseSpecifier /*P*/> /*P*/ BasePath/*= null*/, 
                            boolean IgnoreAccess/*= false*/) {
  return $this().CheckDerivedToBaseConversion(new QualType(Derived), new QualType(Base), diag.err_upcast_to_inaccessible_base, 
      diag.err_ambiguous_derived_to_base_conv, new SourceLocation(Loc), new SourceRange(Range), new DeclarationName(), 
      BasePath, IgnoreAccess);
}


/// CheckDerivedToBaseConversion - Check whether the Derived-to-Base
/// conversion (where Derived and Base are class types) is
/// well-formed, meaning that the conversion is unambiguous (and
/// that all of the base classes are accessible). Returns true
/// and emits a diagnostic if the code is ill-formed, returns false
/// otherwise. Loc is the location where this routine should point to
/// if there is an error, and Range is the source range to highlight
/// if there is an error.
///
/// If either InaccessibleBaseID or AmbigiousBaseConvID are 0, then the
/// diagnostic for the respective type of error will be suppressed, but the
/// check for ill-formed code will still be performed.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckDerivedToBaseConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 1749,
 FQN="clang::Sema::CheckDerivedToBaseConversion", NM="_ZN5clang4Sema28CheckDerivedToBaseConversionENS_8QualTypeES1_jjNS_14SourceLocationENS_11SourceRangeENS_15DeclarationNameEPN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema28CheckDerivedToBaseConversionENS_8QualTypeES1_jjNS_14SourceLocationENS_11SourceRangeENS_15DeclarationNameEPN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEEb")
//</editor-fold>
public final boolean CheckDerivedToBaseConversion(QualType Derived, QualType Base, 
                            /*uint*/int InaccessibleBaseID, 
                            /*uint*/int AmbigiousBaseConvID, 
                            SourceLocation Loc, SourceRange Range, 
                            DeclarationName Name, 
                            SmallVector<CXXBaseSpecifier /*P*/> /*P*/ BasePath) {
  return CheckDerivedToBaseConversion(Derived, Base, 
                            InaccessibleBaseID, 
                            AmbigiousBaseConvID, 
                            Loc, Range, 
                            Name, 
                            BasePath, 
                            false);
}
public final boolean CheckDerivedToBaseConversion(QualType Derived, QualType Base, 
                            /*uint*/int InaccessibleBaseID, 
                            /*uint*/int AmbigiousBaseConvID, 
                            SourceLocation Loc, SourceRange Range, 
                            DeclarationName Name, 
                            SmallVector<CXXBaseSpecifier /*P*/> /*P*/ BasePath, 
                            boolean IgnoreAccess/*= false*/) {
  CXXBasePaths Paths = null;
  try {
    // First, determine whether the path from Derived to Base is
    // ambiguous. This is slightly more expensive than checking whether
    // the Derived to Base conversion exists, because here we need to
    // explore multiple paths to determine if there is an ambiguity.
    Paths/*J*/= new CXXBasePaths(/*FindAmbiguities=*/ true, /*RecordPaths=*/ true, 
        /*DetectVirtual=*/ false);
    boolean DerivationOkay = $this().IsDerivedFrom(new SourceLocation(Loc), new QualType(Derived), new QualType(Base), Paths);
    assert (DerivationOkay) : "Can only be used with a derived-to-base conversion";
    ///*J:(void)*/DerivationOkay;
    if (!Paths.isAmbiguous($this().Context.getCanonicalType(/*NO_COPY*/Base).getUnqualifiedType())) {
      if (!IgnoreAccess) {
        // Check that the base class can be accessed.
        switch ($this().CheckBaseClassAccess(new SourceLocation(Loc), new QualType(Base), new QualType(Derived), Paths.front(), 
            InaccessibleBaseID)) {
         case AR_inaccessible:
          return true;
         case AR_accessible:
         case AR_dependent:
         case AR_delayed:
          break;
        }
      }
      
      // Build a base path if necessary.
      if ((BasePath != null)) {
        $this().BuildBasePathArray(Paths, $Deref(BasePath));
      }
      return false;
    }
    if ((AmbigiousBaseConvID != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // We know that the derived-to-base conversion is ambiguous, and
        // we're going to produce a diagnostic. Perform the derived-to-base
        // search just one more time to compute all of the possible paths so
        // that we can print them out. This is more expensive than any of
        // the previous derived-to-base checks we've done, but at this point
        // performance isn't as much of an issue.
        Paths.clear();
        Paths.setRecordingPaths(true);
        boolean StillOkay = $this().IsDerivedFrom(new SourceLocation(Loc), new QualType(Derived), new QualType(Base), Paths);
        assert (StillOkay) : "Can only be used with a derived-to-base conversion";
        ///*J:(void)*/StillOkay;
        
        // Build up a textual representation of the ambiguous paths, e.g.,
        // D -> B -> A, that will be used to illustrate the ambiguous
        // conversions in the diagnostic. We only print one of the paths
        // to each base class subobject.
        std.string PathDisplayStr = $this().getAmbiguousPathsDisplayString(Paths);
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), AmbigiousBaseConvID)), 
                            Derived), Base), PathDisplayStr), Range), Name));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  } finally {
    if (Paths != null) { Paths.$destroy(); }
  }
}


/// @brief Builds a string representing ambiguous paths from a
/// specific derived class to different subobjects of the same base
/// class.
///
/// This function builds a string that can be used in error messages
/// to show the different paths that one can take through the
/// inheritance hierarchy to go from the derived class to different
/// subobjects of a base class. The result looks something like this:
/// @code
/// struct D -> struct B -> struct A
/// struct D -> struct C -> struct A
/// @endcode
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getAmbiguousPathsDisplayString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 1837,
 FQN="clang::Sema::getAmbiguousPathsDisplayString", NM="_ZN5clang4Sema30getAmbiguousPathsDisplayStringERNS_12CXXBasePathsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema30getAmbiguousPathsDisplayStringERNS_12CXXBasePathsE")
//</editor-fold>
public final std.string getAmbiguousPathsDisplayString(final CXXBasePaths /*&*/ Paths) {
  std.setUInt DisplayedPaths = null;
  try {
    std.string PathDisplayStr/*J*/= new std.string();
    DisplayedPaths/*J*/= new std.setUInt();
    for (std.list.iterator<CXXBasePath> Path = Paths.begin();
         Path.$noteq(Paths.end()); Path.$preInc()) {
      if (DisplayedPaths.insert_T$RR(Path.$arrow().back().SubobjectNumber).second) {
        // We haven't displayed a path to this particular base
        // class subobject yet.
        PathDisplayStr.$addassign_T$C$P(/*KEEP_STR*/"\n    ");
        PathDisplayStr.$addassign($this().Context.getTypeDeclType(Paths.getOrigin()).getAsString());
        for (type$ptr</*const*/ CXXBasePathElement /*P*/ > Element = $tryClone(Path.$arrow().begin());
             Element.$noteq(Path.$arrow().end()); Element.$preInc())  {
          PathDisplayStr.$addassign($add_T$C$P_string(/*KEEP_STR*/" -> ", Element./*->*/$star().Base.getType().getAsString()));
        }
      }
    }
    
    return PathDisplayStr;
  } finally {
    if (DisplayedPaths != null) { DisplayedPaths.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckOverridingFunctionAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13140,
 FQN="clang::Sema::CheckOverridingFunctionAttributes", NM="_ZN5clang4Sema33CheckOverridingFunctionAttributesEPKNS_13CXXMethodDeclES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema33CheckOverridingFunctionAttributesEPKNS_13CXXMethodDeclES3_")
//</editor-fold>
public final boolean CheckOverridingFunctionAttributes(/*const*/ CXXMethodDecl /*P*/ New, 
                                 /*const*/ CXXMethodDecl /*P*/ Old) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    /*const*/ FunctionType /*P*/ NewFT = New.getType().$arrow().getAs(FunctionType.class);
    /*const*/ FunctionType /*P*/ OldFT = Old.getType().$arrow().getAs(FunctionType.class);
    
    CallingConv NewCC = NewFT.getCallConv();
    CallingConv OldCC = OldFT.getCallConv();
    
    // If the calling conventions match, everything is fine
    if (NewCC == OldCC) {
      return false;
    }
    
    // If the calling conventions mismatch because the new function is static,
    // suppress the calling convention mismatch error; the error about static
    // function override (err_static_overrides_virtual from
    // Sema::CheckFunctionDeclaration) is more clear.
    if (New.getStorageClass() == StorageClass.SC_Static) {
      return false;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), 
                    diag.err_conflicting_overriding_cc_attributes)), 
                New.getDeclName()), New.getType()), Old.getType()));
    $c$.clean($c$.track($this().Diag(Old.getLocation(), diag.note_overridden_virtual_function)));
    return true;
  } finally {
    $c$.$destroy();
  }
}


/// CheckOverridingFunctionReturnType - Checks whether the return types are
/// covariant, according to C++ [class.virtual]p5.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckOverridingFunctionReturnType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13165,
 FQN="clang::Sema::CheckOverridingFunctionReturnType", NM="_ZN5clang4Sema33CheckOverridingFunctionReturnTypeEPKNS_13CXXMethodDeclES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema33CheckOverridingFunctionReturnTypeEPKNS_13CXXMethodDeclES3_")
//</editor-fold>
public final boolean CheckOverridingFunctionReturnType(/*const*/ CXXMethodDecl /*P*/ New, 
                                 /*const*/ CXXMethodDecl /*P*/ Old) {
  QualType NewTy = New.getType().$arrow().getAs(FunctionType.class).getReturnType();
  QualType OldTy = Old.getType().$arrow().getAs(FunctionType.class).getReturnType();
  if ($this().Context.hasSameType(new QualType(NewTy), new QualType(OldTy))
     || NewTy.$arrow().isDependentType() || OldTy.$arrow().isDependentType()) {
    return false;
  }
  
  // Check if the return types are covariant
  QualType NewClassTy/*J*/= new QualType();
  QualType OldClassTy/*J*/= new QualType();
  {
    
    /// Both types must be pointers or references to classes.
    /*const*/ PointerType /*P*/ NewPT = NewTy.$arrow().getAs(PointerType.class);
    if ((NewPT != null)) {
      {
        /*const*/ PointerType /*P*/ OldPT = OldTy.$arrow().getAs(PointerType.class);
        if ((OldPT != null)) {
          NewClassTy.$assignMove(NewPT.getPointeeType());
          OldClassTy.$assignMove(OldPT.getPointeeType());
        }
      }
    } else {
      /*const*/ ReferenceType /*P*/ NewRT = NewTy.$arrow().getAs(ReferenceType.class);
      if ((NewRT != null)) {
        {
          /*const*/ ReferenceType /*P*/ OldRT = OldTy.$arrow().getAs(ReferenceType.class);
          if ((OldRT != null)) {
            if (NewRT.getTypeClass() == OldRT.getTypeClass()) {
              NewClassTy.$assignMove(NewRT.getPointeeType());
              OldClassTy.$assignMove(OldRT.getPointeeType());
            }
          }
        }
      }
    }
  }
  
  // The return types aren't either both pointers or references to a class type.
  if (NewClassTy.isNull()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), 
                          diag.err_different_return_type_for_overriding_virtual_function)), 
                      New.getDeclName()), NewTy), OldTy), 
          New.getReturnTypeSourceRange()));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Old.getLocation(), diag.note_overridden_virtual_function)), 
          Old.getReturnTypeSourceRange()));
      
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  if (!$this().Context.hasSameUnqualifiedType(new QualType(NewClassTy), new QualType(OldClassTy))) {
    {
      // C++14 [class.virtual]p8:
      //   If the class type in the covariant return type of D::f differs from
      //   that of B::f, the class type in the return type of D::f shall be
      //   complete at the point of declaration of D::f or shall be the class
      //   type D.
      /*const*/ RecordType /*P*/ RT = NewClassTy.$arrow().getAs$RecordType();
      if ((RT != null)) {
        if (!RT.isBeingDefined()
           && $this().RequireCompleteType$T(New.getLocation(), new QualType(NewClassTy), 
            diag.err_covariant_return_incomplete, 
            New.getDeclName())) {
          return true;
        }
      }
    }
    
    // Check if the new class derives from the old class.
    if (!$this().IsDerivedFrom(New.getLocation(), new QualType(NewClassTy), new QualType(OldClassTy))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_covariant_return_not_derived)), 
                        New.getDeclName()), NewTy), OldTy), 
            New.getReturnTypeSourceRange()));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Old.getLocation(), diag.note_overridden_virtual_function)), 
            Old.getReturnTypeSourceRange()));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Check if we the conversion from derived to base is valid.
    if ($this().CheckDerivedToBaseConversion(new QualType(NewClassTy), new QualType(OldClassTy), 
        diag.err_covariant_return_inaccessible_base, 
        diag.err_covariant_return_ambiguous_derived_to_base_conv, 
        New.getLocation(), New.getReturnTypeSourceRange(), 
        New.getDeclName(), (SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // FIXME: this note won't trigger for delayed access control
        // diagnostics, and it's impossible to get an undelayed error
        // here from access control during the original parse because
        // the ParsingDeclSpec/ParsingDeclarator are still in scope.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Old.getLocation(), diag.note_overridden_virtual_function)), 
            Old.getReturnTypeSourceRange()));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // The qualifiers of the return types must be the same.
  if (NewTy.getLocalCVRQualifiers() != OldTy.getLocalCVRQualifiers()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), 
                          diag.err_covariant_return_type_different_qualifications)), 
                      New.getDeclName()), NewTy), OldTy), 
          New.getReturnTypeSourceRange()));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Old.getLocation(), diag.note_overridden_virtual_function)), 
          Old.getReturnTypeSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // The new class type must have the same or less qualifiers as the old type.
  if (NewClassTy.isMoreQualifiedThan(new QualType(OldClassTy))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), 
                          diag.err_covariant_return_type_class_type_more_qualified)), 
                      New.getDeclName()), NewTy), OldTy), 
          New.getReturnTypeSourceRange()));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Old.getLocation(), diag.note_overridden_virtual_function)), 
          Old.getReturnTypeSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}


/// \brief Mark the given method pure.
///
/// \param Method the method to be marked pure.
///
/// \param InitRange the source range that covers the "0" initializer.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckPureMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13276,
 FQN="clang::Sema::CheckPureMethod", NM="_ZN5clang4Sema15CheckPureMethodEPNS_13CXXMethodDeclENS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema15CheckPureMethodEPNS_13CXXMethodDeclENS_11SourceRangeE")
//</editor-fold>
public final boolean CheckPureMethod(CXXMethodDecl /*P*/ Method, SourceRange InitRange) {
  SourceLocation EndLoc = InitRange.getEnd();
  if (EndLoc.isValid()) {
    Method.setRangeEnd(new SourceLocation(EndLoc));
  }
  if (Method.isVirtual() || Method.getParent().isDependentContext()) {
    Method.setPure();
    return false;
  }
  if (!Method.isInvalidDecl()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Method.getLocation(), diag.err_non_virtual_pure)), 
              Method.getDeclName()), InitRange));
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}


/// CheckOverrideControl - Check C++11 override control semantics.

/// CheckOverrideControl - Check C++11 override control semantics.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckOverrideControl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 1873,
 FQN="clang::Sema::CheckOverrideControl", NM="_ZN5clang4Sema20CheckOverrideControlEPNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema20CheckOverrideControlEPNS_9NamedDeclE")
//</editor-fold>
public final void CheckOverrideControl(NamedDecl /*P*/ D) {
  if (D.isInvalidDecl()) {
    return;
  }
  
  // We only care about "override" and "final" declarations.
  if (!D.hasAttr(OverrideAttr.class) && !D.hasAttr(FinalAttr.class)) {
    return;
  }
  
  CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(D);
  
  // We can't check dependent instance methods.
  if ((MD != null) && MD.isInstance()
     && (MD.getParent().hasAnyDependentBases()
     || MD.getType().$arrow().isDependentType())) {
    return;
  }
  if ((MD != null) && !MD.isVirtual()) {
    // If we have a non-virtual method, check if if hides a virtual method.
    // (In that case, it's most likely the method has the wrong type.)
    SmallVector<CXXMethodDecl /*P*/ > OverloadedMethods/*J*/= new SmallVector<CXXMethodDecl /*P*/ >(8, (CXXMethodDecl /*P*/ )null);
    $this().FindHiddenVirtualMethods(MD, OverloadedMethods);
    if (!OverloadedMethods.empty()) {
      {
        OverrideAttr /*P*/ OA = D.getAttr(OverrideAttr.class);
        if ((OA != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(OA.getLocation(), 
                        diag.override_keyword_hides_virtual_member_function)), 
                    /*KEEP_STR*/"override"), ($greater_uint(OverloadedMethods.size(), 1))));
          } finally {
            $c$.$destroy();
          }
        } else {
          FinalAttr /*P*/ FA = D.getAttr(FinalAttr.class);
          if ((FA != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FA.getLocation(), 
                          diag.override_keyword_hides_virtual_member_function)), 
                      (FA.isSpelledAsSealed() ? $("sealed") : $("final"))), 
                  ($greater_uint(OverloadedMethods.size(), 1))));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
      $this().NoteHiddenVirtualMethods(MD, OverloadedMethods);
      MD.setInvalidDecl();
      return;
    }
    // Fall through into the general case diagnostic.
    // FIXME: We might want to attempt typo correction here.
  }
  if (!(MD != null) || !MD.isVirtual()) {
    {
      OverrideAttr /*P*/ OA = D.getAttr(OverrideAttr.class);
      if ((OA != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(OA.getLocation(), 
                      diag.override_keyword_only_allowed_on_virtual_member_functions)), 
                  /*KEEP_STR*/"override"), FixItHint.CreateRemoval(new SourceRange(OA.getLocation()))));
          D.dropAttr(OverrideAttr.class);
        } finally {
          $c$.$destroy();
        }
      }
    }
    {
      FinalAttr /*P*/ FA = D.getAttr(FinalAttr.class);
      if ((FA != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FA.getLocation(), 
                      diag.override_keyword_only_allowed_on_virtual_member_functions)), 
                  (FA.isSpelledAsSealed() ? $("sealed") : $("final"))), 
              FixItHint.CreateRemoval(new SourceRange(FA.getLocation()))));
          D.dropAttr(FinalAttr.class);
        } finally {
          $c$.$destroy();
        }
      }
    }
    return;
  }
  
  // C++11 [class.virtual]p5:
  //   If a function is marked with the virt-specifier override and
  //   does not override a member function of a base class, the program is
  //   ill-formed.
  boolean HasOverriddenMethods = $noteq_ptr(MD.begin_overridden_methods(), MD.end_overridden_methods());
  if (MD.hasAttr(OverrideAttr.class) && !HasOverriddenMethods) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MD.getLocation(), diag.err_function_marked_override_not_overriding)), 
          MD.getDeclName()));
    } finally {
      $c$.$destroy();
    }
  }
}


/// DiagnoseAbsenceOfOverrideControl - Diagnose if 'override' keyword was
/// not used in the declaration of an overriding method.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseAbsenceOfOverrideControl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 1942,
 FQN="clang::Sema::DiagnoseAbsenceOfOverrideControl", NM="_ZN5clang4Sema32DiagnoseAbsenceOfOverrideControlEPNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema32DiagnoseAbsenceOfOverrideControlEPNS_9NamedDeclE")
//</editor-fold>
public final void DiagnoseAbsenceOfOverrideControl(NamedDecl /*P*/ D) {
  if (D.isInvalidDecl() || D.hasAttr(OverrideAttr.class)) {
    return;
  }
  CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(D);
  if (!(MD != null) || MD.isImplicit() || MD.hasAttr(FinalAttr.class)
     || isa_CXXDestructorDecl(MD)) {
    return;
  }
  
  SourceLocation Loc = MD.getLocation();
  SourceLocation SpellingLoc = new SourceLocation(Loc);
  if ($this().getSourceManager().isMacroArgExpansion(/*NO_COPY*/Loc)) {
    SpellingLoc.$assignMove($this().getSourceManager().getImmediateExpansionRange(/*NO_COPY*/Loc).first);
  }
  SpellingLoc.$assignMove($this().getSourceManager().getSpellingLoc(/*NO_COPY*/SpellingLoc));
  if (SpellingLoc.isValid() && $this().getSourceManager().isInSystemHeader(/*NO_COPY*/SpellingLoc)) {
    return;
  }
  if ($greater_uint(MD.size_overridden_methods(), 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MD.getLocation(), diag.warn_function_marked_not_override_overriding)), 
          MD.getDeclName()));
      /*const*/ CXXMethodDecl /*P*/ OMD = MD.begin_overridden_methods().$star();
      $c$.clean($c$.track($this().Diag(OMD.getLocation(), diag.note_overridden_virtual_function)));
    } finally {
      $c$.$destroy();
    }
  }
}


/// CheckForFunctionMarkedFinal - Checks whether a virtual member function
/// overrides a virtual member function marked 'final', according to
/// C++11 [class.virtual]p4.

/// CheckIfOverriddenFunctionIsMarkedFinal - Checks whether a virtual member
/// function overrides a virtual member function marked 'final', according to
/// C++11 [class.virtual]p4.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckIfOverriddenFunctionIsMarkedFinal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 1969,
 FQN="clang::Sema::CheckIfOverriddenFunctionIsMarkedFinal", NM="_ZN5clang4Sema38CheckIfOverriddenFunctionIsMarkedFinalEPKNS_13CXXMethodDeclES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema38CheckIfOverriddenFunctionIsMarkedFinalEPKNS_13CXXMethodDeclES3_")
//</editor-fold>
public final boolean CheckIfOverriddenFunctionIsMarkedFinal(/*const*/ CXXMethodDecl /*P*/ New, 
                                      /*const*/ CXXMethodDecl /*P*/ Old) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FinalAttr /*P*/ FA = Old.getAttr(FinalAttr.class);
    if (!(FA != null)) {
      return false;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.err_final_function_overridden)), 
            New.getDeclName()), 
        FA.isSpelledAsSealed()));
    $c$.clean($c$.track($this().Diag(Old.getLocation(), diag.note_overridden_virtual_function)));
    return true;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::isAbstractType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4399,
 FQN="clang::Sema::isAbstractType", NM="_ZN5clang4Sema14isAbstractTypeENS_14SourceLocationENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema14isAbstractTypeENS_14SourceLocationENS_8QualTypeE")
//</editor-fold>
public final boolean isAbstractType(SourceLocation Loc, QualType T) {
  if (!$this().getLangOpts().CPlusPlus) {
    return false;
  }
  
  /*const*/ CXXRecordDecl /*P*/ RD = $this().Context.getBaseElementType(new QualType(T)).$arrow().getAsCXXRecordDecl();
  if (!(RD != null)) {
    return false;
  }
  
  // FIXME: Per [temp.inst]p1, we are supposed to trigger instantiation of a
  // class template specialization here, but doing so breaks a lot of code.
  
  // We can't answer whether something is abstract until it has a
  // definition. If it's currently being defined, we'll walk back
  // over all the declarations when we have a full definition.
  /*const*/ CXXRecordDecl /*P*/ Def = RD.getDefinition();
  if (!(Def != null) || Def.isBeingDefined()) {
    return false;
  }
  
  return RD.isAbstract();
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::RequireNonAbstractType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4420,
 FQN="clang::Sema::RequireNonAbstractType", NM="_ZN5clang4Sema22RequireNonAbstractTypeENS_14SourceLocationENS_8QualTypeERNS0_13TypeDiagnoserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema22RequireNonAbstractTypeENS_14SourceLocationENS_8QualTypeERNS0_13TypeDiagnoserE")
//</editor-fold>
public final boolean RequireNonAbstractType(SourceLocation Loc, QualType T, 
                      final TypeDiagnoser /*&*/ Diagnoser) {
  if (!$this().isAbstractType(new SourceLocation(Loc), new QualType(T))) {
    return false;
  }
  
  T.$assignMove($this().Context.getBaseElementType(new QualType(T)));
  Diagnoser.diagnose(/*Deref*/$this(), new SourceLocation(Loc), new QualType(T));
  $this().DiagnoseAbstractType(T.$arrow().getAsCXXRecordDecl());
  return true;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseAbstractType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4431,
 FQN="clang::Sema::DiagnoseAbstractType", NM="_ZN5clang4Sema20DiagnoseAbstractTypeEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema20DiagnoseAbstractTypeEPKNS_13CXXRecordDeclE")
//</editor-fold>
public final void DiagnoseAbstractType(/*const*/ CXXRecordDecl /*P*/ RD) {
  CXXFinalOverriderMap FinalOverriders = null;
  try {
    // Check if we've already emitted the list of pure virtual functions
    // for this class.
    if ($this().PureVirtualClassDiagSet.$bool() && ($this().PureVirtualClassDiagSet.$arrow().count(RD) != 0)) {
      return;
    }
    
    // If the diagnostic is suppressed, don't emit the notes. We're only
    // going to emit them once, so try to attach them to a diagnostic we're
    // actually going to show.
    if ($this().Diags.isLastDiagnosticIgnored()) {
      return;
    }
    
    FinalOverriders/*J*/= new CXXFinalOverriderMap();
    RD.getFinalOverriders(FinalOverriders);
    
    // Keep a set of seen pure methods so we won't diagnose the same method
    // more than once.
    SmallPtrSet</*const*/ CXXMethodDecl /*P*/ > SeenPureMethods/*J*/= new SmallPtrSet</*const*/ CXXMethodDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    
    for (std.vector.iterator<pairPtrType</*const*/ CXXMethodDecl/*P*/, OverridingMethods>> M = FinalOverriders.begin(), 
        MEnd = FinalOverriders.end();
         $noteq___normal_iterator$C(M, MEnd);
         M.$preInc()) {
      for (std.vector.iterator<std.pairUIntType<SmallVector<UniqueVirtualMethod>>> SO = M.$arrow().second.begin(), 
          SOEnd = M.$arrow().second.end();
           $noteq___normal_iterator$C(SO, SOEnd); SO.$preInc()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C++ [class.abstract]p4:
          //   A class is abstract if it contains or inherits at least one
          //   pure virtual function for which the final overrider is pure
          //   virtual.
          
          // 
          if (SO.$arrow().second.size() != 1) {
            continue;
          }
          if (!SO.$arrow().second.front().Method.isPure()) {
            continue;
          }
          if (!SeenPureMethods.insert(SO.$arrow().second.front().Method).second) {
            continue;
          }
          
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SO.$arrow().second.front().Method.getLocation(), 
                      diag.note_pure_virtual_function)), 
                  SO.$arrow().second.front().Method.getDeclName()), RD.getDeclName()));
        } finally {
          $c$.$destroy();
        }
      }
    }
    if (!$this().PureVirtualClassDiagSet.$bool()) {
      $this().PureVirtualClassDiagSet.reset(new SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8));
    }
    $this().PureVirtualClassDiagSet.$arrow().insert(RD);
  } finally {
    if (FinalOverriders != null) { FinalOverriders.$destroy(); }
  }
}


//===--------------------------------------------------------------------===//
// C++ Overloaded Operators [C++ 13.5]
//

/// CheckOverloadedOperatorDeclaration - Check whether the declaration
/// of this overloaded operator is well-formed. If so, returns false;
/// otherwise, emits appropriate diagnostics and returns true.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckOverloadedOperatorDeclaration">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 11777,
 FQN="clang::Sema::CheckOverloadedOperatorDeclaration", NM="_ZN5clang4Sema34CheckOverloadedOperatorDeclarationEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema34CheckOverloadedOperatorDeclarationEPNS_12FunctionDeclE")
//</editor-fold>
public final boolean CheckOverloadedOperatorDeclaration(FunctionDecl /*P*/ FnDecl) {
  assert ((FnDecl != null) && FnDecl.isOverloadedOperator()) : "Expected an overloaded operator declaration";
  
  OverloadedOperatorKind Op = FnDecl.getOverloadedOperator();
  
  // C++ [over.oper]p5:
  //   The allocation and deallocation functions, operator new,
  //   operator new[], operator delete and operator delete[], are
  //   described completely in 3.7.3. The attributes and restrictions
  //   found in the rest of this subclause do not apply to them unless
  //   explicitly stated in 3.7.3.
  if (Op == OverloadedOperatorKind.OO_Delete || Op == OverloadedOperatorKind.OO_Array_Delete) {
    return CheckOperatorDeleteDeclaration(/*Deref*/$this(), FnDecl);
  }
  if (Op == OverloadedOperatorKind.OO_New || Op == OverloadedOperatorKind.OO_Array_New) {
    return CheckOperatorNewDeclaration(/*Deref*/$this(), FnDecl);
  }
  {
    
    // C++ [over.oper]p6:
    //   An operator function shall either be a non-static member
    //   function or be a non-member function and have at least one
    //   parameter whose type is a class, a reference to a class, an
    //   enumeration, or a reference to an enumeration.
    CXXMethodDecl /*P*/ MethodDecl = dyn_cast_CXXMethodDecl(FnDecl);
    if ((MethodDecl != null)) {
      if (MethodDecl.isStatic()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FnDecl.getLocation(), 
                  diag.err_operator_overload_static)), FnDecl.getDeclName()).$bool());
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      boolean ClassOrEnumParam = false;
      for (ParmVarDecl /*P*/ Param : FnDecl.parameters()) {
        QualType ParamType = Param.getType().getNonReferenceType();
        if (ParamType.$arrow().isDependentType() || ParamType.$arrow().isRecordType()
           || ParamType.$arrow().isEnumeralType()) {
          ClassOrEnumParam = true;
          break;
        }
      }
      if (!ClassOrEnumParam) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FnDecl.getLocation(), 
                  diag.err_operator_overload_needs_class_or_enum)), 
              FnDecl.getDeclName()).$bool());
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // C++ [over.oper]p8:
  //   An operator function cannot have default arguments (8.3.6),
  //   except where explicitly stated below.
  //
  // Only the function-call operator allows default arguments
  // (C++ [over.call]p1).
  if (Op != OverloadedOperatorKind.OO_Call) {
    for (ParmVarDecl /*P*/ Param : FnDecl.parameters()) {
      if (Param.hasDefaultArg()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Param.getLocation(), 
                      diag.err_operator_overload_default_arg)), 
                  FnDecl.getDeclName()), Param.getDefaultArgRange()).$bool());
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  final/*static*/ /*const*/boolean OperatorUses[/*45*/][/*3*/] = CheckOverloadedOperatorDeclaration$$.OperatorUses;
  
  boolean CanBeUnaryOperator = OperatorUses[Op.getValue()][0];
  boolean CanBeBinaryOperator = OperatorUses[Op.getValue()][1];
  boolean MustBeMemberOperator = OperatorUses[Op.getValue()][2];
  
  // C++ [over.oper]p8:
  //   [...] Operator functions cannot have more or fewer parameters
  //   than the number required for the corresponding operator, as
  //   described in the rest of this subclause.
  /*uint*/int NumParams = FnDecl.getNumParams()
     + (isa_CXXMethodDecl(FnDecl) ? 1 : 0);
  if (Op != OverloadedOperatorKind.OO_Call
     && ((NumParams == 1 && !CanBeUnaryOperator)
     || (NumParams == 2 && !CanBeBinaryOperator)
     || ($less_uint(NumParams, 1)) || ($greater_uint(NumParams, 2)))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // We have the wrong number of parameters.
      /*uint*/int ErrorKind;
      if (CanBeUnaryOperator && CanBeBinaryOperator) {
        ErrorKind = 2; // 2 -> unary or binary.
      } else if (CanBeUnaryOperator) {
        ErrorKind = 0; // 0 -> unary
      } else {
        assert (CanBeBinaryOperator) : "All non-call overloaded operators are unary or binary!";
        ErrorKind = 1; // 1 -> binary
      }
      
      return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FnDecl.getLocation(), diag.err_operator_overload_must_be)), 
                  FnDecl.getDeclName()), NumParams), ErrorKind).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  // Overloaded operators other than operator() cannot be variadic.
  if (Op != OverloadedOperatorKind.OO_Call
     && FnDecl.getType().$arrow().getAs(FunctionProtoType.class).isVariadic()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FnDecl.getLocation(), diag.err_operator_overload_variadic)), 
          FnDecl.getDeclName()).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  // Some operators must be non-static member functions.
  if (MustBeMemberOperator && !isa_CXXMethodDecl(FnDecl)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FnDecl.getLocation(), 
              diag.err_operator_overload_must_be_member)), 
          FnDecl.getDeclName()).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  // C++ [over.inc]p1:
  //   The user-defined function called operator++ implements the
  //   prefix and postfix ++ operator. If this function is a member
  //   function with no parameters, or a non-member function with one
  //   parameter of class or enumeration type, it defines the prefix
  //   increment operator ++ for objects of that type. If the function
  //   is a member function with one parameter (which shall be of type
  //   int) or a non-member function with two parameters (the second
  //   of which shall be of type int), it defines the postfix
  //   increment operator ++ for objects of that type.
  if ((Op == OverloadedOperatorKind.OO_PlusPlus || Op == OverloadedOperatorKind.OO_MinusMinus) && NumParams == 2) {
    ParmVarDecl /*P*/ LastParam = FnDecl.getParamDecl(FnDecl.getNumParams() - 1);
    QualType ParamType = LastParam.getType();
    if (!ParamType.$arrow().isSpecificBuiltinType(BuiltinType.Kind.Int.getValue())
       && !ParamType.$arrow().isDependentType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(LastParam.getLocation(), 
                    diag.err_operator_overload_post_incdec_must_be_int)), 
                LastParam.getType()), (Op == OverloadedOperatorKind.OO_MinusMinus)).$bool());
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  return false;
}
private static final class CheckOverloadedOperatorDeclaration$$ {
  static final/*static*/ /*const*/boolean OperatorUses[/*45*/][/*3*/] = new /*const*/boolean [/*3*/] [/*45*/] {
    {false, false, false}, 
    {true, true, false},
    {true, true, false},
    {true, true, false},
    {true, true, false},
    {true, true, false},
    {true, true, false},
    {true, true, false},
    {false, true, false},
    {false, true, false},
    {false, true, false},
    {true, true, false},
    {false, true, false},
    {true, false, false},
    {true, false, false},
    {false, true, true},
    {false, true, false},
    {false, true, false},
    {false, true, false},
    {false, true, false},
    {false, true, false},
    {false, true, false},
    {false, true, false},
    {false, true, false},
    {false, true, false},
    {false, true, false},
    {false, true, false},
    {false, true, false},
    {false, true, false},
    {false, true, false},
    {false, true, false},
    {false, true, false},
    {false, true, false},
    {false, true, false},
    {false, true, false},
    {false, true, false},
    {true, true, false},
    {true, true, false},
    {false, true, false},
    {false, true, false},
    {true, false, true},
    {true, true, true},
    {false, true, true},
  // ?: can *not* be overloaded, but we need the overload
  // resolution machinery for it.
    {false, true, false},
    {true, false, false}
};
}


/// CheckLiteralOperatorDeclaration - Check whether the declaration
/// of this literal operator function is well-formed. If so, returns
/// false; otherwise, emits appropriate diagnostics and returns true.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckLiteralOperatorDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 11957,
 FQN="clang::Sema::CheckLiteralOperatorDeclaration", NM="_ZN5clang4Sema31CheckLiteralOperatorDeclarationEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema31CheckLiteralOperatorDeclarationEPNS_12FunctionDeclE")
//</editor-fold>
public final boolean CheckLiteralOperatorDeclaration(FunctionDecl /*P*/ FnDecl) {
  if (isa_CXXMethodDecl(FnDecl)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FnDecl.getLocation(), diag.err_literal_operator_outside_namespace)), 
          FnDecl.getDeclName()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  if (FnDecl.isExternC()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(FnDecl.getLocation(), diag.err_literal_operator_extern_c)));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // This might be the definition of a literal operator template.
  FunctionTemplateDecl /*P*/ TpDecl = FnDecl.getDescribedFunctionTemplate();
  
  // This might be a specialization of a literal operator template.
  if (!(TpDecl != null)) {
    TpDecl = FnDecl.getPrimaryTemplate();
  }
  
  // template <char...> type operator "" name() and
  // template <class T, T...> type operator "" name() are the only valid
  // template signatures, and the only valid signatures with no parameters.
  if ((TpDecl != null)) {
    if (FnDecl.param_size() != 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(FnDecl.getLocation(), 
            diag.err_literal_operator_template_with_params)));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    if (checkLiteralOperatorTemplateParameterList(/*Deref*/$this(), TpDecl)) {
      return true;
    }
  } else if (FnDecl.param_size() == 1) {
    /*const*/ ParmVarDecl /*P*/ Param = FnDecl.getParamDecl(0);
    
    QualType ParamType = Param.getType().getUnqualifiedType();
    
    // Only unsigned long long int, long double, any character type, and const
    // char * are allowed as the only parameters.
    if (ParamType.$arrow().isSpecificBuiltinType(BuiltinType.Kind.ULongLong.getValue())
       || ParamType.$arrow().isSpecificBuiltinType(BuiltinType.Kind.LongDouble.getValue())
       || $this().Context.hasSameType(new QualType(ParamType), $this().Context.CharTy.$QualType())
       || $this().Context.hasSameType(new QualType(ParamType), $this().Context.WideCharTy.$QualType())
       || $this().Context.hasSameType(new QualType(ParamType), $this().Context.Char16Ty.$QualType())
       || $this().Context.hasSameType(new QualType(ParamType), $this().Context.Char32Ty.$QualType())) {
    } else {
      /*const*/ PointerType /*P*/ Ptr = ParamType.$arrow().getAs(PointerType.class);
      if ((Ptr != null)) {
        QualType InnerType = Ptr.getPointeeType();
        
        // Pointer parameter must be a const char *.
        if (!($this().Context.hasSameType(InnerType.getUnqualifiedType(), 
            $this().Context.CharTy.$QualType())
           && InnerType.isConstQualified() && !InnerType.isVolatileQualified())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Param.getSourceRange().getBegin(), 
                            diag.err_literal_operator_param)), 
                        ParamType), /*KEEP_STR*/"'const char *'"), Param.getSourceRange()));
            return true;
          } finally {
            $c$.$destroy();
          }
        }
      } else if (ParamType.$arrow().isRealFloatingType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Param.getSourceRange().getBegin(), diag.err_literal_operator_param)), 
                      ParamType), $this().Context.LongDoubleTy), Param.getSourceRange()));
          return true;
        } finally {
          $c$.$destroy();
        }
      } else if (ParamType.$arrow().isIntegerType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Param.getSourceRange().getBegin(), diag.err_literal_operator_param)), 
                      ParamType), $this().Context.UnsignedLongLongTy), Param.getSourceRange()));
          return true;
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Param.getSourceRange().getBegin(), 
                      diag.err_literal_operator_invalid_param)), 
                  ParamType), Param.getSourceRange()));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
    }
  } else if (FnDecl.param_size() == 2) {
    type$ptr<ParmVarDecl /*P*/ /*P*/> Param = $tryClone(FnDecl.param_begin());
    
    // First, verify that the first parameter is correct.
    QualType FirstParamType = (Param.$star()).getType().getUnqualifiedType();
    
    // Two parameter function must have a pointer to const as a
    // first parameter; let's strip those qualifiers.
    /*const*/ PointerType /*P*/ PT = FirstParamType.$arrow().getAs(PointerType.class);
    if (!(PT != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag((Param.$star()).getSourceRange().getBegin(), 
                        diag.err_literal_operator_param)), 
                    FirstParamType), /*KEEP_STR*/"'const char *'"), (Param.$star()).getSourceRange()));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    QualType PointeeType = PT.getPointeeType();
    // First parameter must be const
    if (!PointeeType.isConstQualified() || PointeeType.isVolatileQualified()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag((Param.$star()).getSourceRange().getBegin(), 
                        diag.err_literal_operator_param)), 
                    FirstParamType), /*KEEP_STR*/"'const char *'"), (Param.$star()).getSourceRange()));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    QualType InnerType = PointeeType.getUnqualifiedType();
    // Only const char *, const wchar_t*, const char16_t*, and const char32_t*
    // are allowed as the first parameter to a two-parameter function
    if (!($this().Context.hasSameType(new QualType(InnerType), $this().Context.CharTy.$QualType())
       || $this().Context.hasSameType(new QualType(InnerType), $this().Context.WideCharTy.$QualType())
       || $this().Context.hasSameType(new QualType(InnerType), $this().Context.Char16Ty.$QualType())
       || $this().Context.hasSameType(new QualType(InnerType), $this().Context.Char32Ty.$QualType()))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag((Param.$star()).getSourceRange().getBegin(), 
                        diag.err_literal_operator_param)), 
                    FirstParamType), /*KEEP_STR*/"'const char *'"), (Param.$star()).getSourceRange()));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Move on to the second and final parameter.
    Param.$preInc();
    
    // The second parameter must be a std::size_t.
    QualType SecondParamType = (Param.$star()).getType().getUnqualifiedType();
    if (!$this().Context.hasSameType(new QualType(SecondParamType), $this().Context.getSizeType().$QualType())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag((Param.$star()).getSourceRange().getBegin(), 
                        diag.err_literal_operator_param)), 
                    SecondParamType), $this().Context.getSizeType()), 
            (Param.$star()).getSourceRange()));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(FnDecl.getLocation(), diag.err_literal_operator_bad_param_count)));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Parameters are good.
  
  // A parameter-declaration-clause containing a default argument is not
  // equivalent to any of the permitted forms.
  for (ParmVarDecl /*P*/ Param : FnDecl.parameters()) {
    if (Param.hasDefaultArg()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Param.getDefaultArgRange().getBegin(), 
                diag.err_literal_operator_default_argument)), 
            Param.getDefaultArgRange()));
        break;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  StringRef LiteralName = FnDecl.getDeclName().getCXXLiteralIdentifier().getName();
  if (LiteralName.$at(0) != $$UNDERSCORE) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // C++11 [usrlit.suffix]p1:
      //   Literal suffix identifiers that do not start with an underscore
      //   are reserved for future standardization.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FnDecl.getLocation(), diag.warn_user_literal_reserved)), 
          NumericLiteralParser.isValidUDSuffix($this().getLangOpts(), new StringRef(LiteralName))));
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}


/// ActOnCXXConditionDeclarationExpr - Parsed a condition declaration of a
/// C++ if/switch/while/for statement.
/// e.g: "if (int x = f()) {...}"
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXConditionDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13352,
 FQN="clang::Sema::ActOnCXXConditionDeclaration", NM="_ZN5clang4Sema28ActOnCXXConditionDeclarationEPNS_5ScopeERNS_10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN5clang4Sema28ActOnCXXConditionDeclarationEPNS_5ScopeERNS_10DeclaratorE")
//</editor-fold>
public final ActionResult<Decl /*P*/ > ActOnCXXConditionDeclaration(Scope /*P*/ S, final Declarator /*&*/ D) {
  // C++ 6.4p2:
  // The declarator shall not specify a function or an array.
  // The type-specifier-seq shall not contain typedef and shall not declare a
  // new class or enumeration.
  assert (D.getDeclSpec().getStorageClassSpec() != DeclSpec.SCS.SCS_typedef) : "Parser allowed 'typedef' as storage class of condition decl.";
  
  Decl /*P*/ Dcl = $this().ActOnDeclarator(S, D);
  if (!(Dcl != null)) {
    return new ActionResult<Decl /*P*/ >(true);
  }
  if (isa_FunctionDecl(Dcl)) { // The declarator shall not specify a function.
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Dcl.getLocation(), diag.err_invalid_use_of_function_type)), 
          D.getSourceRange()));
      return new ActionResult<Decl /*P*/ >(true);
    } finally {
      $c$.$destroy();
    }
  }
  
  return new ActionResult<Decl /*P*/ >(JD$T.INSTANCE, Dcl);
}

} // END OF class Sema_SemaDeclCXX
