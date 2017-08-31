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
import org.clang.ast.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.llvm.*;
import org.clang.sema.impl.*;
import org.clang.basic.target.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.java.SemaRTTI.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import org.clang.sema.java.SemaJavaDifferentiators.*;
import static org.clang.sema.impl.SemaExprStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import org.clang.basic.java.OptionalNotes;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaExpr">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.sema.Sema_SemaExpr",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaExceptionSpec ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema10ActOnBinOpEPNS_5ScopeENS_14SourceLocationENS_3tok9TokenKindEPNS_4ExprES7_;_ZN5clang4Sema10ActOnVAArgENS_14SourceLocationEPNS_4ExprENS_9OpaquePtrINS_8QualTypeEEES1_;_ZN5clang4Sema10BuildBinOpEPNS_5ScopeENS_14SourceLocationENS_18BinaryOperatorKindEPNS_4ExprES6_;_ZN5clang4Sema10CanUseDeclEPNS_9NamedDeclEb;_ZN5clang4Sema12ActOnUnaryOpEPNS_5ScopeENS_14SourceLocationENS_3tok9TokenKindEPNS_4ExprE;_ZN5clang4Sema12BuildUnaryOpEPNS_5ScopeENS_14SourceLocationENS_17UnaryOperatorKindEPNS_4ExprE;_ZN5clang4Sema13ActOnCallExprEPNS_5ScopeEPNS_4ExprENS_14SourceLocationEN4llvm15MutableArrayRefIS4_EES5_S4_b;_ZN5clang4Sema13ActOnCastExprEPNS_5ScopeENS_14SourceLocationERNS_10DeclaratorERNS_9OpaquePtrINS_8QualTypeEEES3_PNS_4ExprE;_ZN5clang4Sema13ActOnInitListENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES1_;_ZN5clang4Sema13ActOnStmtExprENS_14SourceLocationEPNS_4StmtES1_;_ZN5clang4Sema14ActOnAddrLabelENS_14SourceLocationES1_PNS_9LabelDeclE;_ZN5clang4Sema14ActOnConditionEPNS_5ScopeENS_14SourceLocationEPNS_4ExprENS0_13ConditionKindE;_ZN5clang4Sema14ActOnParenExprENS_14SourceLocationES1_PNS_4ExprE;_ZN5clang4Sema14BuildVAArgExprENS_14SourceLocationEPNS_4ExprEPNS_14TypeSourceInfoES1_;_ZN5clang4Sema15ActOnAsTypeExprEPNS_4ExprENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationES6_;_ZN5clang4Sema15ActOnBlockErrorENS_14SourceLocationEPNS_5ScopeE;_ZN5clang4Sema15ActOnBlockStartENS_14SourceLocationEPNS_5ScopeE;_ZN5clang4Sema15ActOnChooseExprENS_14SourceLocationEPNS_4ExprES3_S3_S1_;_ZN5clang4Sema15CheckVectorCastENS_11SourceRangeENS_8QualTypeES2_RNS_8CastKindE;_ZN5clang4Sema15InvalidOperandsENS_14SourceLocationERNS_12ActionResultIPNS_4ExprELb1EEES6_;_ZN5clang4Sema16ActOnGNUNullExprENS_14SourceLocationE;_ZN5clang4Sema16BuildDeclRefExprEPNS_9ValueDeclENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationEPKNS_12CXXScopeSpecE;_ZN5clang4Sema16BuildDeclRefExprEPNS_9ValueDeclENS_8QualTypeENS_13ExprValueKindERKNS_19DeclarationNameInfoEPKNS_12CXXScopeSpecEPNS_9NamedDeclEPKNS_24TemplateArgumentListInfoE;_ZN5clang4Sema16CheckLiteralKindEPNS_4ExprE;_ZN5clang4Sema16CheckVecStepExprEPNS_4ExprE;_ZN5clang4Sema17ActOnIdExpressionEPNS_5ScopeERNS_12CXXScopeSpecENS_14SourceLocationERNS_13UnqualifiedIdEbbSt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteIS9_EEbPNS_5TokenE;_ZN5clang4Sema17CheckLoopHintExprEPNS_4ExprENS_14SourceLocationE;_ZN5clang4Sema17DiagnoseUseOfDeclEPNS_9NamedDeclENS_14SourceLocationEPKNS_17ObjCInterfaceDeclEb;_ZN5clang4Sema17PrepareScalarCastERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeE;_ZN5clang4Sema17isValidVarArgTypeERKNS_8QualTypeE;_ZN5clang4Sema18ActOnBlockStmtExprENS_14SourceLocationEPNS_4StmtEPNS_5ScopeE;_ZN5clang4Sema18ActOnConditionalOpENS_14SourceLocationES1_PNS_4ExprES3_S3_;_ZN5clang4Sema18ActOnParenListExprENS_14SourceLocationES1_N4llvm15MutableArrayRefIPNS_4ExprEEE;_ZN5clang4Sema18ActOnStartStmtExprEv;_ZN5clang4Sema18ActOnStmtExprErrorEv;_ZN5clang4Sema18ActOnStringLiteralEN4llvm8ArrayRefINS_5TokenEEEPNS_5ScopeE;_ZN5clang4Sema18BuildVectorLiteralENS_14SourceLocationES1_PNS_4ExprEPNS_14TypeSourceInfoE;_ZN5clang4Sema18CheckExtVectorCastENS_11SourceRangeENS_8QualTypeEPNS_4ExprERNS_8CastKindE;_ZN5clang4Sema18CheckShiftOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationENS_18BinaryOperatorKindEb;_ZN5clang4Sema18CreateBuiltinBinOpENS_14SourceLocationENS_18BinaryOperatorKindEPNS_4ExprES4_;_ZN5clang4Sema18LookupInObjCMethodERNS_12LookupResultEPNS_5ScopeEPNS_14IdentifierInfoEb;_ZN5clang4Sema18checkUnknownAnyArgENS_14SourceLocationEPNS_4ExprERNS_8QualTypeE;_ZN5clang4Sema18prepareVectorSplatENS_8QualTypeEPNS_4ExprE;_ZN5clang4Sema18tryCaptureVariableEPNS_7VarDeclENS_14SourceLocationENS0_14TryCaptureKindES3_;_ZN5clang4Sema18tryCaptureVariableEPNS_7VarDeclENS_14SourceLocationENS0_14TryCaptureKindES3_bRNS_8QualTypeES6_PKj;_ZN5clang4Sema19ActOnBlockArgumentsENS_14SourceLocationERNS_10DeclaratorEPNS_5ScopeE;_ZN5clang4Sema19ActOnPostfixUnaryOpEPNS_5ScopeENS_14SourceLocationENS_3tok9TokenKindEPNS_4ExprE;_ZN5clang4Sema19ActOnPredefinedExprENS_14SourceLocationENS_3tok9TokenKindE;_ZN5clang4Sema19BuildPredefinedExprENS_14SourceLocationENS_14PredefinedExpr9IdentTypeE;_ZN5clang4Sema19CheckCallReturnTypeENS_8QualTypeENS_14SourceLocationEPNS_8CallExprEPNS_12FunctionDeclE;_ZN5clang4Sema19CheckCaseExpressionEPNS_4ExprE;_ZN5clang4Sema19CheckVectorOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationEbbb;_ZN5clang4Sema19DiagRuntimeBehaviorENS_14SourceLocationEPKNS_4StmtERKNS_17PartialDiagnosticE;_ZN5clang4Sema19DiagnoseEmptyLookupEPNS_5ScopeERNS_12CXXScopeSpecERNS_12LookupResultESt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteIS8_EEPNS_24TemplateArgumentListInfoEN4llvm8ArrayRefIPNS_4ExprEEEPPNS_8TypoExprE;_ZN5clang4Sema19GetSignedVectorTypeENS_8QualTypeE;_ZN5clang4Sema19NoteDeletedFunctionEPNS_12FunctionDeclE;_ZN5clang4Sema19checkUnknownAnyCastENS_11SourceRangeENS_8QualTypeEPNS_4ExprERNS_8CastKindERNS_13ExprValueKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEE;_ZN5clang4Sema19getVariadicCallTypeEPNS_12FunctionDeclEPKNS_17FunctionProtoTypeEPNS_4ExprE;_ZN5clang4Sema20ActOnBuiltinOffsetOfEPNS_5ScopeENS_14SourceLocationES3_NS_9OpaquePtrINS_8QualTypeEEEN4llvm8ArrayRefINS0_17OffsetOfComponentEEES3_;_ZN5clang4Sema20ActOnCompoundLiteralENS_14SourceLocationENS_9OpaquePtrINS_8QualTypeEEES1_PNS_4ExprE;_ZN5clang4Sema20ActOnIntegerConstantENS_14SourceLocationEy;_ZN5clang4Sema20ActOnNumericConstantERKNS_5TokenEPNS_5ScopeE;_ZN5clang4Sema20ActOnObjCBoolLiteralENS_14SourceLocationENS_3tok9TokenKindE;_ZN5clang4Sema20BuildBuiltinOffsetOfENS_14SourceLocationEPNS_14TypeSourceInfoEN4llvm8ArrayRefINS0_17OffsetOfComponentEEES1_;_ZN5clang4Sema20CheckBitwiseOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationEb;_ZN5clang4Sema20CheckCompareOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationENS_18BinaryOperatorKindEb;_ZN5clang4Sema20CheckLogicalOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationENS_18BinaryOperatorKindE;_ZN5clang4Sema20CheckPlaceholderExprEPNS_4ExprE;_ZN5clang4Sema20CreateBuiltinUnaryOpENS_14SourceLocationENS_17UnaryOperatorKindEPNS_4ExprE;_ZN5clang4Sema20MarkMemberReferencedEPNS_10MemberExprE;_ZN5clang4Sema21BuildResolvedCallExprEPNS_4ExprEPNS_9NamedDeclENS_14SourceLocationEN4llvm8ArrayRefIS2_EES5_S2_b;_ZN5clang4Sema21CheckAdditionOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationENS_18BinaryOperatorKindEPNS_8QualTypeE;_ZN5clang4Sema21CheckAddressOfOperandERNS_12ActionResultIPNS_4ExprELb1EEENS_14SourceLocationE;_ZN5clang4Sema21CheckBooleanConditionENS_14SourceLocationEPNS_4ExprEb;_ZN5clang4Sema21CleanupVarDeclMarkingEv;_ZN5clang4Sema21DiagnoseCommaOperatorEPKNS_4ExprENS_14SourceLocationE;_ZN5clang4Sema21DiagnoseSentinelCallsEPNS_9NamedDeclENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEE;_ZN5clang4Sema21MarkAnyDeclReferencedENS_14SourceLocationEPNS_4DeclEb;_ZN5clang4Sema21MarkDeclRefReferencedEPNS_11DeclRefExprE;_ZN5clang4Sema21NeedToCaptureVariableEPNS_7VarDeclENS_14SourceLocationE;_ZN5clang4Sema21UsualUnaryConversionsEPNS_4ExprE;_ZN5clang4Sema21checkVariadicArgumentEPKNS_4ExprENS0_16VariadicCallTypeE;_ZN5clang4Sema21forceUnknownAnyToTypeEPNS_4ExprENS_8QualTypeE;_ZN5clang4Sema21isLaxVectorConversionENS_8QualTypeES1_;_ZN5clang4Sema22ActOnCharacterConstantERKNS_5TokenEPNS_5ScopeE;_ZN5clang4Sema22ActOnConvertVectorExprEPNS_4ExprENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationES6_;_ZN5clang4Sema22BuildCXXDefaultArgExprENS_14SourceLocationEPNS_12FunctionDeclEPNS_11ParmVarDeclE;_ZN5clang4Sema22CheckRemainderOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationEb;_ZN5clang4Sema22DecomposeUnqualifiedIdERKNS_13UnqualifiedIdERNS_24TemplateArgumentListInfoERNS_19DeclarationNameInfoERPKS4_;_ZN5clang4Sema22GatherArgumentsForCallENS_14SourceLocationEPNS_12FunctionDeclEPKNS_17FunctionProtoTypeEjN4llvm8ArrayRefIPNS_4ExprEEERNS7_15SmallVectorImplISA_EENS0_16VariadicCallTypeEbb;_ZN5clang4Sema22MarkFunctionReferencedENS_14SourceLocationEPNS_12FunctionDeclEb;_ZN5clang4Sema22MarkVariableReferencedENS_14SourceLocationEPNS_7VarDeclE;_ZN5clang4Sema22getCapturedDeclRefTypeEPNS_7VarDeclENS_14SourceLocationE;_ZN5clang4Sema22maybeExtendBlockObjectERNS_12ActionResultIPNS_4ExprELb1EEE;_ZN5clang4Sema23ActOnArraySubscriptExprEPNS_5ScopeEPNS_4ExprENS_14SourceLocationES4_S5_;_ZN5clang4Sema23ActOnConstantExpressionENS_12ActionResultIPNS_4ExprELb1EEE;_ZN5clang4Sema23CheckAssignmentOperandsEPNS_4ExprERNS_12ActionResultIS2_Lb1EEENS_14SourceLocationENS_8QualTypeE;_ZN5clang4Sema23ConvertArgumentsForCallEPNS_8CallExprEPNS_4ExprEPNS_12FunctionDeclEPKNS_17FunctionProtoTypeEN4llvm8ArrayRefIS4_EENS_14SourceLocationEb;_ZN5clang4Sema23DefaultLvalueConversionEPNS_4ExprE;_ZN5clang4Sema24ActOnOMPArraySectionExprEPNS_4ExprENS_14SourceLocationES2_S3_S2_S3_;_ZN5clang4Sema24BuildCompoundLiteralExprENS_14SourceLocationEPNS_14TypeSourceInfoES1_PNS_4ExprE;_ZN5clang4Sema24BuildDeclarationNameExprERKNS_12CXXScopeSpecERKNS_19DeclarationNameInfoEPNS_9NamedDeclES8_PKNS_24TemplateArgumentListInfoEb;_ZN5clang4Sema24BuildDeclarationNameExprERKNS_12CXXScopeSpecERNS_12LookupResultEbb;_ZN5clang4Sema24CallExprUnaryConversionsEPNS_4ExprE;_ZN5clang4Sema24CheckConditionalOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_S5_RNS_13ExprValueKindERNS_14ExprObjectKindENS_14SourceLocationE;_ZN5clang4Sema24CheckStaticArrayArgumentENS_14SourceLocationEPNS_11ParmVarDeclEPKNS_4ExprE;_ZN5clang4Sema24CheckSubtractionOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationEPNS_8QualTypeE;_ZN5clang4Sema24DefaultArgumentPromotionEPNS_4ExprE;_ZN5clang4Sema24DiagnoseAssignmentResultENS0_17AssignConvertTypeENS_14SourceLocationENS_8QualTypeES3_PNS_4ExprENS0_16AssignmentActionEPb;_ZN5clang4Sema25ActOnGenericSelectionExprENS_14SourceLocationES1_S1_PNS_4ExprEN4llvm8ArrayRefINS_9OpaquePtrINS_8QualTypeEEEEENS5_IS3_EE;_ZN5clang4Sema26CheckAssignmentConstraintsENS_14SourceLocationENS_8QualTypeES2_;_ZN5clang4Sema26CheckAssignmentConstraintsENS_8QualTypeERNS_12ActionResultIPNS_4ExprELb1EEERNS_8CastKindEb;_ZN5clang4Sema26CheckVectorCompareOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationEb;_ZN5clang4Sema26CheckVectorLogicalOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationE;_ZN5clang4Sema26CreateGenericSelectionExprENS_14SourceLocationES1_S1_PNS_4ExprEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEENS5_IS3_EE;_ZN5clang4Sema26DiagnoseConditionalForNullEPNS_4ExprES2_NS_14SourceLocationE;_ZN5clang4Sema26UseArgumentDependentLookupERKNS_12CXXScopeSpecERKNS_12LookupResultEb;_ZN5clang4Sema26UsualArithmeticConversionsERNS_12ActionResultIPNS_4ExprELb1EEES5_b;_ZN5clang4Sema27CheckMultiplyDivideOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationEbb;_ZN5clang4Sema27areLaxCompatibleVectorTypesENS_8QualTypeES1_;_ZN5clang4Sema28FindCompositeObjCPointerTypeERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationE;_ZN5clang4Sema29ActOnUnaryExprOrTypeTraitExprENS_14SourceLocationENS_20UnaryExprOrTypeTraitEbPvNS_11SourceRangeE;_ZN5clang4Sema29DiagnoseAssignmentAsConditionEPNS_4ExprE;_ZN5clang4Sema29PerformObjectMemberConversionEPNS_4ExprEPNS_19NestedNameSpecifierEPNS_9NamedDeclES6_;_ZN5clang4Sema29getDeletedOrUnavailableSuffixEPKNS_12FunctionDeclE;_ZN5clang4Sema30ActOnObjCAvailabilityCheckExprEN4llvm8ArrayRefINS_16AvailabilitySpecEEENS_14SourceLocationES5_;_ZN5clang4Sema30ConvertTokenKindToBinaryOpcodeENS_3tok9TokenKindE;_ZN5clang4Sema30CreateUnaryExprOrTypeTraitExprEPNS_14TypeSourceInfoENS_14SourceLocationENS_20UnaryExprOrTypeTraitENS_11SourceRangeE;_ZN5clang4Sema30CreateUnaryExprOrTypeTraitExprEPNS_4ExprENS_14SourceLocationENS_20UnaryExprOrTypeTraitE;_ZN5clang4Sema30DefaultFunctionArrayConversionEPNS_4ExprEb;_ZN5clang4Sema30MaybeSuggestAddingStaticToDeclEPKNS_12FunctionDeclE;_ZN5clang4Sema30PopExpressionEvaluationContextEv;_ZN5clang4Sema30PrepareCastToObjCObjectPointerERNS_12ActionResultIPNS_4ExprELb1EEE;_ZN5clang4Sema30UpdateMarkingForLValueToRValueEPNS_4ExprE;_ZN5clang4Sema31CreateBuiltinArraySubscriptExprEPNS_4ExprENS_14SourceLocationES2_S3_;_ZN5clang4Sema31DiagnoseEqualityWithExtraParensEPNS_9ParenExprE;_ZN5clang4Sema31PushExpressionEvaluationContextENS0_27ExpressionEvaluationContextENS0_24ReuseLambdaContextDecl_tEb;_ZN5clang4Sema31PushExpressionEvaluationContextENS0_27ExpressionEvaluationContextEPNS_4DeclEb;_ZN5clang4Sema31TransformToPotentiallyEvaluatedEPNS_4ExprE;_ZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntE;_ZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEb;_ZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntEjb;_ZN5clang4Sema32CheckSingleAssignmentConstraintsENS_8QualTypeERNS_12ActionResultIPNS_4ExprELb1EEEbbb;_ZN5clang4Sema32CheckUnaryExprOrTypeTraitOperandENS_8QualTypeENS_14SourceLocationENS_11SourceRangeENS_20UnaryExprOrTypeTraitE;_ZN5clang4Sema32CheckUnaryExprOrTypeTraitOperandEPNS_4ExprENS_20UnaryExprOrTypeTraitE;_ZN5clang4Sema32DefaultVariadicArgumentPromotionEPNS_4ExprENS0_16VariadicCallTypeEPNS_12FunctionDeclE;_ZN5clang4Sema32MarkDeclarationsReferencedInExprEPNS_4ExprEb;_ZN5clang4Sema32MarkDeclarationsReferencedInTypeENS_14SourceLocationENS_8QualTypeE;_ZN5clang4Sema33BuildQualifiedDeclarationNameExprERNS_12CXXScopeSpecERKNS_19DeclarationNameInfoEbPKNS_5ScopeEPPNS_14TypeSourceInfoE;_ZN5clang4Sema34ConversionToObjCStringLiteralCheckENS_8QualTypeERPNS_4ExprEb;_ZN5clang4Sema34DiscardCleanupsInEvaluationContextEv;_ZN5clang4Sema36DefaultFunctionArrayLvalueConversionEPNS_4ExprEb;_ZN5clang4Sema36HandleExprEvaluationContextForTypeofEPNS_4ExprE;_ZN5clang4Sema36MaybeConvertParenListExprToParenExprEPNS_5ScopeEPNS_4ExprE;_ZN5clang4Sema40CheckTransparentUnionArgumentConstraintsENS_8QualTypeERNS_12ActionResultIPNS_4ExprELb1EEE;_ZNK5clang4Sema12getExprRangeEPNS_4ExprE; -static-type=Sema_SemaExpr -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaExpr extends Sema_SemaExceptionSpec {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }

//<editor-fold defaultstate="collapsed" desc="clang::Sema::MaybeSuggestAddingStaticToDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 294,
 FQN="clang::Sema::MaybeSuggestAddingStaticToDecl", NM="_ZN5clang4Sema30MaybeSuggestAddingStaticToDeclEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema30MaybeSuggestAddingStaticToDeclEPKNS_12FunctionDeclE")
//</editor-fold>
public final void MaybeSuggestAddingStaticToDecl(/*const*/ FunctionDecl /*P*/ Cur) {
  /*const*/ FunctionDecl /*P*/ First = Cur.getFirstDecl$Const();
  
  // Suggest "static" on the function, if possible.
  if (!hasAnyExplicitStorageClass(First)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SourceLocation DeclBegin = First.getSourceRange().getBegin();
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(DeclBegin), diag.note_convert_inline_to_static)), 
              Cur), FixItHint.CreateInsertion(/*NO_COPY*/DeclBegin, new StringRef(/*KEEP_STR*/"static "))));
    } finally {
      $c$.$destroy();
    }
  }
}


/// Do an explicit extend of the given block pointer if we're in ARC.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::maybeExtendBlockObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 5591,
 FQN="clang::Sema::maybeExtendBlockObject", NM="_ZN5clang4Sema22maybeExtendBlockObjectERNS_12ActionResultIPNS_4ExprELb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema22maybeExtendBlockObjectERNS_12ActionResultIPNS_4ExprELb1EEE")
//</editor-fold>
public final void maybeExtendBlockObject(final ActionResultTTrue<Expr /*P*/ > /*&*/ E) {
  assert (E.get().getType().$arrow().isBlockPointerType());
  assert (E.get().isRValue());
  
  // Only do this in an r-value context.
  if (!$this().getLangOpts().ObjCAutoRefCount) {
    return;
  }
  
  E.$assign(ImplicitCastExpr.Create($this().Context, E.get().getType(), 
          CastKind.CK_ARCExtendBlockObject, E.get(), 
          /*base path*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, ExprValueKind.VK_RValue));
  $this().Cleanup.setExprNeedsCleanups(true);
}


/// Prepare a conversion of the given expression to an ObjC object
/// pointer type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PrepareCastToObjCObjectPointer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 5606,
 FQN="clang::Sema::PrepareCastToObjCObjectPointer", NM="_ZN5clang4Sema30PrepareCastToObjCObjectPointerERNS_12ActionResultIPNS_4ExprELb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema30PrepareCastToObjCObjectPointerERNS_12ActionResultIPNS_4ExprELb1EEE")
//</editor-fold>
public final CastKind PrepareCastToObjCObjectPointer(final ActionResultTTrue<Expr /*P*/ > /*&*/ E) {
  QualType type = E.get().getType();
  if (type.$arrow().isObjCObjectPointerType()) {
    return CastKind.CK_BitCast;
  } else if (type.$arrow().isBlockPointerType()) {
    $this().maybeExtendBlockObject(E);
    return CastKind.CK_BlockPointerToObjCPointerCast;
  } else {
    assert (type.$arrow().isPointerType());
    return CastKind.CK_CPointerToObjCPointerCast;
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckLiteralKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8896,
 FQN="clang::Sema::CheckLiteralKind", NM="_ZN5clang4Sema16CheckLiteralKindEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema16CheckLiteralKindEPNS_4ExprE")
//</editor-fold>
public final Sema.ObjCLiteralKind CheckLiteralKind(Expr /*P*/ FromE) {
  FromE = FromE.IgnoreParenImpCasts();
  switch (FromE.getStmtClass()) {
   default:
    break;
   case ObjCStringLiteralClass:
    // "string literal"
    return ObjCLiteralKind.LK_String;
   case ObjCArrayLiteralClass:
    // "array literal"
    return ObjCLiteralKind.LK_Array;
   case ObjCDictionaryLiteralClass:
    // "dictionary literal"
    return ObjCLiteralKind.LK_Dictionary;
   case BlockExprClass:
    return ObjCLiteralKind.LK_Block;
   case ObjCBoxedExprClass:
    {
      Expr /*P*/ Inner = cast_ObjCBoxedExpr(FromE).getSubExpr().IgnoreParens();
      switch (Inner.getStmtClass()) {
       case IntegerLiteralClass:
       case FloatingLiteralClass:
       case CharacterLiteralClass:
       case ObjCBoolLiteralExprClass:
       case CXXBoolLiteralExprClass:
        // "numeric literal"
        return ObjCLiteralKind.LK_Numeric;
       case ImplicitCastExprClass:
        {
          CastKind CK = cast_CastExpr(Inner).getCastKind();
          // Boolean literals can be represented by implicit casts.
          if (CK == CastKind.CK_IntegralToBoolean || CK == CastKind.CK_IntegralCast) {
            return ObjCLiteralKind.LK_Numeric;
          }
          break;
        }
       default:
        break;
      }
      return ObjCLiteralKind.LK_Boxed;
    }
  }
  return ObjCLiteralKind.LK_None;
}


/// \brief Cast a base object to a member's actual type.
///
/// Logically this happens in three phases:
///
/// * First we cast from the base type to the naming class.
///   The naming class is the class into which we were looking
///   when we found the member;  it's the qualifier type if a
///   qualifier was provided, and otherwise it's the base type.
///
/// * Next we cast from the naming class to the declaring class.
///   If the member we found was brought into a class's scope by
///   a using declaration, this is that class;  otherwise it's
///   the class declaring the member.
///
/// * Finally we cast from the declaring class to the "true"
///   declaring class of the member.  This conversion does not
///   obey access control.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformObjectMemberConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 2574,
 FQN="clang::Sema::PerformObjectMemberConversion", NM="_ZN5clang4Sema29PerformObjectMemberConversionEPNS_4ExprEPNS_19NestedNameSpecifierEPNS_9NamedDeclES6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema29PerformObjectMemberConversionEPNS_4ExprEPNS_19NestedNameSpecifierEPNS_9NamedDeclES6_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > PerformObjectMemberConversion(Expr /*P*/ From, 
                             NestedNameSpecifier /*P*/ Qualifier, 
                             NamedDecl /*P*/ FoundDecl, 
                             NamedDecl /*P*/ Member) {
  CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(Member.getDeclContext());
  if (!(RD != null)) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, From);
  }
  
  QualType DestRecordType/*J*/= new QualType();
  QualType DestType/*J*/= new QualType();
  QualType FromRecordType/*J*/= new QualType();
  QualType FromType = From.getType();
  boolean PointerConversions = false;
  if (isa_FieldDecl(Member)) {
    DestRecordType.$assignMove($this().Context.getCanonicalType($this().Context.getTypeDeclType(RD)).$QualType());
    if ((FromType.$arrow().getAs(PointerType.class) != null)) {
      DestType.$assignMove($this().Context.getPointerType(new QualType(DestRecordType)));
      FromRecordType.$assignMove(FromType.$arrow().getPointeeType());
      PointerConversions = true;
    } else {
      DestType.$assign(DestRecordType);
      FromRecordType.$assign(FromType);
    }
  } else {
    CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(Member);
    if ((Method != null)) {
      if (Method.isStatic()) {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, From);
      }
      
      DestType.$assignMove(Method.getThisType($this().Context));
      DestRecordType.$assignMove(DestType.$arrow().getPointeeType());
      if ((FromType.$arrow().getAs(PointerType.class) != null)) {
        FromRecordType.$assignMove(FromType.$arrow().getPointeeType());
        PointerConversions = true;
      } else {
        FromRecordType.$assign(FromType);
        DestType.$assign(DestRecordType);
      }
    } else {
      // No conversion necessary.
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, From);
    }
  }
  if (DestType.$arrow().isDependentType() || FromType.$arrow().isDependentType()) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, From);
  }
  
  // If the unqualified types are the same, no conversion is necessary.
  if ($this().Context.hasSameUnqualifiedType(new QualType(FromRecordType), new QualType(DestRecordType))) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, From);
  }
  
  SourceRange FromRange = From.getSourceRange();
  SourceLocation FromLoc = FromRange.getBegin();
  
  ExprValueKind VK = From.getValueKind();
  
  // C++ [class.member.lookup]p8:
  //   [...] Ambiguities can often be resolved by qualifying a name with its
  //   class name.
  //
  // If the member was a qualified name and the qualified referred to a
  // specific base subobject type, we'll cast to that intermediate type
  // first and then to the object in which the member is declared. That allows
  // one to resolve ambiguities in, e.g., a diamond-shaped hierarchy such as:
  //
  //   class Base { public: int x; };
  //   class Derived1 : public Base { };
  //   class Derived2 : public Base { };
  //   class VeryDerived : public Derived1, public Derived2 { void f(); };
  //
  //   void VeryDerived::f() {
  //     x = 17; // error: ambiguous base subobjects
  //     Derived1::x = 17; // okay, pick the Base subobject of Derived1
  //   }
  if ((Qualifier != null) && (Qualifier.getAsType() != null)) {
    QualType QType = new QualType(Qualifier.getAsType(), 0);
    assert (QType.$arrow().isRecordType()) : "lookup done with non-record type";
    
    QualType QRecordType = new QualType(QType.$arrow().getAs$RecordType(), 0);
    
    // In C++98, the qualifier type doesn't actually have to be a base
    // type of the object type, in which case we just ignore it.
    // Otherwise build the appropriate casts.
    if ($this().IsDerivedFrom(new SourceLocation(FromLoc), new QualType(FromRecordType), new QualType(QRecordType))) {
      SmallVector<CXXBaseSpecifier /*P*/> BasePath/*J*/= new SmallVector<CXXBaseSpecifier /*P*/>(4, null);
      if ($this().CheckDerivedToBaseConversion(new QualType(FromRecordType), new QualType(QRecordType), 
          new SourceLocation(FromLoc), new SourceRange(FromRange), $AddrOf(BasePath))) {
        return ExprError();
      }
      if (PointerConversions) {
        QType.$assignMove($this().Context.getPointerType(new QualType(QType)));
      }
      From = $this().ImpCastExprToType(From, new QualType(QType), CastKind.CK_UncheckedDerivedToBase, 
          VK, $AddrOf(BasePath)).get();
      
      FromType.$assign(QType);
      FromRecordType.$assign(QRecordType);
      
      // If the qualifier type was the same as the destination type,
      // we're done.
      if ($this().Context.hasSameUnqualifiedType(new QualType(FromRecordType), new QualType(DestRecordType))) {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, From);
      }
    }
  }
  
  boolean IgnoreAccess = false;
  
  // If we actually found the member through a using declaration, cast
  // down to the using declaration's type.
  //
  // Pointer equality is fine here because only one declaration of a
  // class ever has member declarations.
  if (FoundDecl.getDeclContext() != Member.getDeclContext()) {
    assert (isa_UsingShadowDecl(FoundDecl));
    QualType URecordType = $this().Context.getTypeDeclType(cast_CXXRecordDecl(FoundDecl.getDeclContext()));
    
    // We only need to do this if the naming-class to declaring-class
    // conversion is non-trivial.
    if (!$this().Context.hasSameUnqualifiedType(new QualType(FromRecordType), new QualType(URecordType))) {
      assert ($this().IsDerivedFrom(new SourceLocation(FromLoc), new QualType(FromRecordType), new QualType(URecordType)));
      SmallVector<CXXBaseSpecifier /*P*/> BasePath/*J*/= new SmallVector<CXXBaseSpecifier /*P*/>(4, null);
      if ($this().CheckDerivedToBaseConversion(new QualType(FromRecordType), new QualType(URecordType), 
          new SourceLocation(FromLoc), new SourceRange(FromRange), $AddrOf(BasePath))) {
        return ExprError();
      }
      
      QualType UType = new QualType(URecordType);
      if (PointerConversions) {
        UType.$assignMove($this().Context.getPointerType(new QualType(UType)));
      }
      From = $this().ImpCastExprToType(From, new QualType(UType), CastKind.CK_UncheckedDerivedToBase, 
          VK, $AddrOf(BasePath)).get();
      FromType.$assign(UType);
      FromRecordType.$assign(URecordType);
    }
    
    // We don't do access control for the conversion from the
    // declaring class to the true declaring class.
    IgnoreAccess = true;
  }
  
  SmallVector<CXXBaseSpecifier /*P*/> BasePath/*J*/= new SmallVector<CXXBaseSpecifier /*P*/>(4, null);
  if ($this().CheckDerivedToBaseConversion(new QualType(FromRecordType), new QualType(DestRecordType), 
      new SourceLocation(FromLoc), new SourceRange(FromRange), $AddrOf(BasePath), 
      IgnoreAccess)) {
    return ExprError();
  }
  
  return $this().ImpCastExprToType(From, new QualType(DestType), CastKind.CK_UncheckedDerivedToBase, 
      VK, $AddrOf(BasePath));
}


/// CheckCallReturnType - Checks that a call expression's return type is
/// complete. Returns true on failure. The location passed in is the location
/// that best represents the call.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckCallReturnType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14244,
 FQN="clang::Sema::CheckCallReturnType", NM="_ZN5clang4Sema19CheckCallReturnTypeENS_8QualTypeENS_14SourceLocationEPNS_8CallExprEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema19CheckCallReturnTypeENS_8QualTypeENS_14SourceLocationEPNS_8CallExprEPNS_12FunctionDeclE")
//</editor-fold>
public final boolean CheckCallReturnType(QualType ReturnType, SourceLocation Loc, 
                   CallExpr /*P*/ CE, FunctionDecl /*P*/ FD) {
  //<editor-fold defaultstate="collapsed" desc="CallReturnIncompleteDiagnoser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14256,
   FQN="CallReturnIncompleteDiagnoser", NM="_ZZN5clang4Sema19CheckCallReturnTypeENS_8QualTypeENS_14SourceLocationEPNS_8CallExprEPNS_12FunctionDeclEE29CallReturnIncompleteDiagnoser",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZZN5clang4Sema19CheckCallReturnTypeENS_8QualTypeENS_14SourceLocationEPNS_8CallExprEPNS_12FunctionDeclEE29CallReturnIncompleteDiagnoser")
  //</editor-fold>
   class CallReturnIncompleteDiagnoser extends /*public*/ TypeDiagnoser implements Destructors.ClassWithDestructor {
    protected/*private*/ FunctionDecl /*P*/ FD;
    protected/*private*/ CallExpr /*P*/ CE;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckCallReturnType(QualType, SourceLocation, CallExpr * , FunctionDecl * )::CallReturnIncompleteDiagnoser::CallReturnIncompleteDiagnoser">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14261,
     FQN="clang::Sema::CheckCallReturnType(QualType, SourceLocation, CallExpr * , FunctionDecl * )::CallReturnIncompleteDiagnoser::CallReturnIncompleteDiagnoser", NM="_ZZN5clang4Sema19CheckCallReturnTypeENS_8QualTypeENS_14SourceLocationEPNS_8CallExprEPNS_12FunctionDeclEEN29CallReturnIncompleteDiagnoserC1ES6_S4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZZN5clang4Sema19CheckCallReturnTypeENS_8QualTypeENS_14SourceLocationEPNS_8CallExprEPNS_12FunctionDeclEEN29CallReturnIncompleteDiagnoserC1ES6_S4_")
    //</editor-fold>
    public CallReturnIncompleteDiagnoser(FunctionDecl /*P*/ FD, CallExpr /*P*/ CE) {
      // : TypeDiagnoser(), FD(FD), CE(CE) 
      //START JInit
      super();
      this.FD = FD;
      this.CE = CE;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckCallReturnType(QualType, SourceLocation, CallExpr * , FunctionDecl * )::CallReturnIncompleteDiagnoser::diagnose">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14264,
     FQN="clang::Sema::CheckCallReturnType(QualType, SourceLocation, CallExpr * , FunctionDecl * )::CallReturnIncompleteDiagnoser::diagnose", NM="_ZZN5clang4Sema19CheckCallReturnTypeENS_8QualTypeENS_14SourceLocationEPNS_8CallExprEPNS_12FunctionDeclEEN29CallReturnIncompleteDiagnoser8diagnoseERS0_S2_S1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZZN5clang4Sema19CheckCallReturnTypeENS_8QualTypeENS_14SourceLocationEPNS_8CallExprEPNS_12FunctionDeclEEN29CallReturnIncompleteDiagnoser8diagnoseERS0_S2_S1_")
    //</editor-fold>
    @Override public void diagnose(final Sema /*&*/ S, SourceLocation Loc, QualType T)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        if (!(FD != null)) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_call_incomplete_return)), 
                  T), CE.getSourceRange()));
          return;
        }

        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_call_function_incomplete_return)), 
                    CE.getSourceRange()), FD.getDeclName()), T));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FD.getLocation(), diag.note_entity_declared_at)), 
            FD.getDeclName()));
      } finally {
        $c$.$destroy();
      }
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckCallReturnType(QualType, SourceLocation, CallExpr * , FunctionDecl * )::CallReturnIncompleteDiagnoser::~CallReturnIncompleteDiagnoser">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14256,
     FQN="clang::Sema::CheckCallReturnType(QualType, SourceLocation, CallExpr * , FunctionDecl * )::CallReturnIncompleteDiagnoser::~CallReturnIncompleteDiagnoser", NM="_ZZN5clang4Sema19CheckCallReturnTypeENS_8QualTypeENS_14SourceLocationEPNS_8CallExprEPNS_12FunctionDeclEEN29CallReturnIncompleteDiagnoserD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZZN5clang4Sema19CheckCallReturnTypeENS_8QualTypeENS_14SourceLocationEPNS_8CallExprEPNS_12FunctionDeclEEN29CallReturnIncompleteDiagnoserD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      super.$destroy();
    }


    @Override public String toString() {
      return "" + "FD=" + FD // NOI18N
                + ", CE=" + CE // NOI18N
                + super.toString(); // NOI18N
    }
  }
  CallReturnIncompleteDiagnoser Diagnoser = null;
  try {
    if (ReturnType.$arrow().isVoidType() || !ReturnType.$arrow().isIncompleteType()) {
      return false;
    }
    
    // If we're inside a decltype's expression, don't check for a valid return
    // type or construct temporaries until we know whether this is the last call.
    if ($this().ExprEvalContexts.back().IsDecltype) {
      $this().ExprEvalContexts.back().DelayedDecltypeCalls.push_back(CE);
      return false;
    }
    
    Diagnoser/*J*/= new  CallReturnIncompleteDiagnoser(FD, CE);
    if ($this().RequireCompleteType(new SourceLocation(Loc), new QualType(ReturnType), Diagnoser)) {
      return true;
    }
    
    return false;
  } finally {
    if (Diagnoser != null) { Diagnoser.$destroy(); }
  }
}


//===--------------------------------------------------------------------===//
// Expression Parsing Callbacks: SemaExpr.cpp.

/// \brief Determine whether the use of this declaration is valid, without
/// emitting diagnostics.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CanUseDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 52,
 FQN="clang::Sema::CanUseDecl", NM="_ZN5clang4Sema10CanUseDeclEPNS_9NamedDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema10CanUseDeclEPNS_9NamedDeclEb")
//</editor-fold>
public final boolean CanUseDecl(NamedDecl /*P*/ D, boolean TreatUnavailableAsInvalid) {
  // See if this is an auto-typed variable whose initializer we are parsing.
  if (($this().ParsingInitForAutoVars.count(D) != 0)) {
    return false;
  }
  {
    
    // See if this is a deleted function.
    FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
    if ((FD != null)) {
      if (FD.isDeleted()) {
        return false;
      }
      
      // If the function has a deduced return type, and we can't deduce it,
      // then we can't use it either.
      if ($this().getLangOpts().CPlusPlus14 && FD.getReturnType().$arrow().isUndeducedType()
         && $this().DeduceReturnType(FD, new SourceLocation(), /*Diagnose*/ false)) {
        return false;
      }
    }
  }
  
  // See if this function is unavailable.
  if (TreatUnavailableAsInvalid && D.getAvailability() == AvailabilityResult.AR_Unavailable
     && cast_Decl($this().CurContext).getAvailability() != AvailabilityResult.AR_Unavailable) {
    return false;
  }
  
  return true;
}


/// \brief Determine whether the use of this declaration is valid, and
/// emit any corresponding diagnostics.
///
/// This routine diagnoses various problems with referencing
/// declarations that can occur when using a declaration. For example,
/// it might warn if a deprecated or unavailable declaration is being
/// used, or produce an error (and return true) if a C++0x deleted
/// function is being used.
///
/// \returns true if there was an error (this declaration cannot be
/// referenced), false otherwise.
///
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseUseOfDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 317,
 FQN="clang::Sema::DiagnoseUseOfDecl", NM="_ZN5clang4Sema17DiagnoseUseOfDeclEPNS_9NamedDeclENS_14SourceLocationEPKNS_17ObjCInterfaceDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema17DiagnoseUseOfDeclEPNS_9NamedDeclENS_14SourceLocationEPKNS_17ObjCInterfaceDeclEb")
//</editor-fold>
public final boolean DiagnoseUseOfDecl(NamedDecl /*P*/ D, SourceLocation Loc) {
  return DiagnoseUseOfDecl(D, Loc, 
                 (/*const*/ ObjCInterfaceDecl /*P*/ )null, 
                 false);
}
public final boolean DiagnoseUseOfDecl(NamedDecl /*P*/ D, SourceLocation Loc, 
                 /*const*/ ObjCInterfaceDecl /*P*/ UnknownObjCClass/*= null*/) {
  return DiagnoseUseOfDecl(D, Loc, 
                 UnknownObjCClass, 
                 false);
}
public final boolean DiagnoseUseOfDecl(NamedDecl /*P*/ D, SourceLocation Loc, 
                 /*const*/ ObjCInterfaceDecl /*P*/ UnknownObjCClass/*= null*/, 
                 boolean ObjCPropertyAccess/*= false*/) {
  if ($this().getLangOpts().CPlusPlus && isa_FunctionDecl(D)) {
    // If there were any diagnostics suppressed by template argument deduction,
    // emit them now.
    DenseMapIterator<Decl /*P*/ , OptionalNotes> Pos = $this().SuppressedDiagnostics.find(D.getCanonicalDecl());
    if (Pos.$noteq(/*NO_ITER_COPY*/$this().SuppressedDiagnostics.end())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        for (final /*const*/ std.pair<SourceLocation, PartialDiagnostic> /*&*/ Suppressed : Pos.$arrow().second)  {
          $c$.clean($c$.track($this().Diag(new SourceLocation(Suppressed.first), Suppressed.second)));
        }
        
        // Clear out the list of suppressed diagnostics, so that we don't emit
        // them again for this specialization. However, we don't obsolete this
        // entry from the table, because we want to avoid ever emitting these
        // diagnostics again.
        Pos.$arrow().second.clear();
      } finally {
        $c$.$destroy();
      }
    }
    
    // C++ [basic.start.main]p3:
    //   The function 'main' shall not be used within a program.
    if (cast_FunctionDecl(D).isMain()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.ext_main_used)));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // See if this is an auto-typed variable whose initializer we are parsing.
  if (($this().ParsingInitForAutoVars.count(D) != 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ AutoType /*P*/ AT = cast_VarDecl(D).getType().$arrow().getContainedAutoType();
      
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_auto_variable_cannot_appear_in_own_initializer)), 
              D.getDeclName()), ((/*uint*/int)AT.getKeyword().getValue())));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  {
    
    // See if this is a deleted function.
    FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
    if ((FD != null)) {
      if (FD.isDeleted()) {
        CXXConstructorDecl /*P*/ Ctor = dyn_cast_CXXConstructorDecl(FD);
        if ((Ctor != null) && Ctor.isInheritingConstructor()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_deleted_inherited_ctor_use)), 
                    Ctor.getParent()), 
                Ctor.getInheritedConstructor().getConstructor().getParent()));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_deleted_function_use)));
          } finally {
            $c$.$destroy();
          }
        }
        $this().NoteDeletedFunction(FD);
        return true;
      }
      
      // If the function has a deduced return type, and we can't deduce it,
      // then we can't use it either.
      if ($this().getLangOpts().CPlusPlus14 && FD.getReturnType().$arrow().isUndeducedType()
         && $this().DeduceReturnType(FD, new SourceLocation(Loc))) {
        return true;
      }
    }
  }
  
  // [OpenMP 4.0], 2.15 declare reduction Directive, Restrictions
  // Only the variables omp_in and omp_out are allowed in the combiner.
  // Only the variables omp_priv and omp_orig are allowed in the
  // initializer-clause.
  OMPDeclareReductionDecl /*P*/ DRD = dyn_cast_OMPDeclareReductionDecl($this().CurContext);
  if (($this().LangOpts.OpenMP != 0) && (DRD != null) && !$this().CurContext.containsDecl(D)
     && isa_VarDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_omp_wrong_var_in_declare_reduction)), 
          $this().getCurFunction().HasOMPDeclareReductionCombiner));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), diag.note_entity_declared_at)), D));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  DiagnoseAvailabilityOfDecl(/*Deref*/$this(), D, new SourceLocation(Loc), UnknownObjCClass, 
      ObjCPropertyAccess);
  
  DiagnoseUnusedOfDecl(/*Deref*/$this(), D, new SourceLocation(Loc));
  
  diagnoseUseOfInternalDeclInInlineFunction(/*Deref*/$this(), D, new SourceLocation(Loc));
  
  return false;
}


/// \brief Emit a note explaining that this function is deleted.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::NoteDeletedFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 205,
 FQN="clang::Sema::NoteDeletedFunction", NM="_ZN5clang4Sema19NoteDeletedFunctionEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema19NoteDeletedFunctionEPNS_12FunctionDeclE")
//</editor-fold>
public final void NoteDeletedFunction(FunctionDecl /*P*/ Decl) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert (Decl.isDeleted());
    
    CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(Decl);
    if ((Method != null) && Method.isDeleted() && Method.isDefaulted()) {
      // If the method was explicitly defaulted, point at that declaration.
      if (!Method.isImplicit()) {
        $c$.clean($c$.track($this().Diag(Decl.getLocation(), diag.note_implicitly_deleted)));
      }
      
      // Try to diagnose why this special member function was implicitly
      // deleted. This might fail, if that reason no longer applies.
      CXXSpecialMember CSM = $this().getSpecialMember(Method);
      if (CSM != CXXSpecialMember.CXXInvalid) {
        $this().ShouldDeleteSpecialMember(Method, CSM, (InheritedConstructorInfo /*P*/ )null, /*Diagnose=*/ true);
      }
      
      return;
    }
    
    CXXConstructorDecl /*P*/ Ctor = dyn_cast_CXXConstructorDecl(Decl);
    if ((Ctor != null) && Ctor.isInheritingConstructor()) {
      $this().NoteDeletedInheritingConstructor(Ctor);
      /*JAVA:return*/return;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Decl.getLocation(), diag.note_availability_specified_here)), 
            Decl), true));
  } finally {
    $c$.$destroy();
  }
}


/// \brief Retrieve the message suffix that should be added to a
/// diagnostic complaining about the given function being deleted or
/// unavailable.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getDeletedOrUnavailableSuffix">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 396,
 FQN="clang::Sema::getDeletedOrUnavailableSuffix", NM="_ZN5clang4Sema29getDeletedOrUnavailableSuffixEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema29getDeletedOrUnavailableSuffixEPKNS_12FunctionDeclE")
//</editor-fold>
public final std.string getDeletedOrUnavailableSuffix(/*const*/ FunctionDecl /*P*/ FD) {
  std.string Message/*J*/= new std.string();
  if ((FD.getAvailability($AddrOf(Message)).getValue() != 0)) {
    return $add_T$C$P_string$C(/*KEEP_STR*/": ", Message);
  }
  
  return new std.string();
}


/// DiagnoseSentinelCalls - This routine checks whether a call or
/// message-send is to a declaration with the sentinel attribute, and
/// if so, it checks that the requirements of the sentinel are
/// satisfied.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseSentinelCalls">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 408,
 FQN="clang::Sema::DiagnoseSentinelCalls", NM="_ZN5clang4Sema21DiagnoseSentinelCallsEPNS_9NamedDeclENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema21DiagnoseSentinelCallsEPNS_9NamedDeclENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEE")
//</editor-fold>
public final void DiagnoseSentinelCalls(NamedDecl /*P*/ D, SourceLocation Loc, 
                     ArrayRef<Expr /*P*/ > Args) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    /*const*/ SentinelAttr /*P*/ attr = D.getAttr(SentinelAttr.class);
    if (!(attr != null)) {
      return;
    }
    
    // The number of formal parameters of the declaration.
    /*uint*/int numFormalParams;
    
    // The kind of declaration.  This is also an index into a %select in
    // the diagnostic.
    final class/*enum*/ CalleeType {
      private static final /*uint*/int CT_Function = 0;
      private static final /*uint*/int CT_Method = CT_Function + 1;
      private static final /*uint*/int CT_Block = CT_Method + 1;
    }/* CalleeType*//*uint*/int calleeType;
    {
      
      ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(D);
      if ((MD != null)) {
        numFormalParams = MD.param_size();
        calleeType = CalleeType.CT_Method;
      } else {
        FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
        if ((FD != null)) {
          numFormalParams = FD.param_size();
          calleeType = CalleeType.CT_Function;
        } else if (isa_VarDecl(D)) {
          QualType type = cast_ValueDecl(D).getType();
          /*const*/ FunctionType /*P*/ fn = null;
          {
            /*const*/ PointerType /*P*/ ptr = type.$arrow().getAs(PointerType.class);
            if ((ptr != null)) {
              fn = ptr.getPointeeType().$arrow().getAs(FunctionType.class);
              if (!(fn != null)) {
                return;
              }
              calleeType = CalleeType.CT_Function;
            } else {
              /*const*/ BlockPointerType /*P*/ ptr$1 = type.$arrow().getAs(BlockPointerType.class);
              if ((ptr$1 != null)) {
                fn = ptr$1.getPointeeType().$arrow().castAs(FunctionType.class);
                calleeType = CalleeType.CT_Block;
              } else {
                return;
              }
            }
          }
          {
            
            /*const*/ FunctionProtoType /*P*/ proto = dyn_cast_FunctionProtoType(fn);
            if ((proto != null)) {
              numFormalParams = proto.getNumParams();
            } else {
              numFormalParams = 0;
            }
          }
        } else {
          return;
        }
      }
    }
    
    // "nullPos" is the number of formal parameters at the end which
    // effectively count as part of the variadic arguments.  This is
    // useful if you would prefer to not have *any* formal parameters,
    // but the language forces you to have at least one.
    /*uint*/int nullPos = attr.getNullPos();
    assert ((nullPos == 0 || nullPos == 1)) : "invalid null position on sentinel";
    numFormalParams = ($greater_uint(nullPos, numFormalParams) ? 0 : numFormalParams - nullPos);
    
    // The number of arguments which should follow the sentinel.
    /*uint*/int numArgsAfterSentinel = attr.getSentinel();
    
    // If there aren't enough arguments for all the formal parameters,
    // the sentinel, and the args after the sentinel, complain.
    if ($less_uint(Args.size(), numFormalParams + numArgsAfterSentinel + 1)) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_not_enough_argument)), D.getDeclName()));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), diag.note_sentinel_here)), ((int)(calleeType))));
      return;
    }
    
    // Otherwise, find the sentinel expression.
    Expr /*P*/ sentinelExpr = Args.$at(Args.size() - numArgsAfterSentinel - 1);
    if (!(sentinelExpr != null)) {
      return;
    }
    if (sentinelExpr.isValueDependent()) {
      return;
    }
    if ($this().Context.isSentinelNullExpr(sentinelExpr)) {
      return;
    }
    
    // Pick a reasonable string to insert.  Optimistically use 'nil', 'nullptr',
    // or 'NULL' if those are actually defined in the context.  Only use
    // 'nil' for ObjC methods, where it's much more likely that the
    // variadic arguments form a list of object pointers.
    SourceLocation MissingNilLoc = $this().getLocForEndOfToken(sentinelExpr.getLocEnd());
    std.string NullValue/*J*/= new std.string();
    if (calleeType == CalleeType.CT_Method && $this().PP.isMacroDefined(new StringRef(/*KEEP_STR*/"nil"))) {
      NullValue.$assign_T$C$P(/*KEEP_STR*/"nil");
    } else if ($this().getLangOpts().CPlusPlus11) {
      NullValue.$assign_T$C$P(/*KEEP_STR*/"nullptr");
    } else if ($this().PP.isMacroDefined(new StringRef(/*KEEP_STR*/"NULL"))) {
      NullValue.$assign_T$C$P(/*KEEP_STR*/"NULL");
    } else {
      NullValue.$assign_T$C$P(/*KEEP_STR*/"(void*) 0");
    }
    if (MissingNilLoc.isInvalid()) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_missing_sentinel)), ((int)(calleeType))));
    } else {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(MissingNilLoc), diag.warn_missing_sentinel)), 
              ((int)(calleeType))), 
          FixItHint.CreateInsertion(/*NO_COPY*/MissingNilLoc, new StringRef($add_T$C$P_string$C(/*KEEP_STR*/", ", NullValue)))));
    }
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), diag.note_sentinel_here)), ((int)(calleeType))));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::PushExpressionEvaluationContext">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12821,
 FQN="clang::Sema::PushExpressionEvaluationContext", NM="_ZN5clang4Sema31PushExpressionEvaluationContextENS0_27ExpressionEvaluationContextEPNS_4DeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema31PushExpressionEvaluationContextENS0_27ExpressionEvaluationContextEPNS_4DeclEb")
//</editor-fold>
public final void PushExpressionEvaluationContext(ExpressionEvaluationContext NewContext) {
  PushExpressionEvaluationContext(NewContext, 
                               (Decl /*P*/ )null, 
                               false);
}
public final void PushExpressionEvaluationContext(ExpressionEvaluationContext NewContext, 
                               Decl /*P*/ LambdaContextDecl/*= null*/) {
  PushExpressionEvaluationContext(NewContext, 
                               LambdaContextDecl, 
                               false);
}
public final void PushExpressionEvaluationContext(ExpressionEvaluationContext NewContext, 
                               Decl /*P*/ LambdaContextDecl/*= null*/, 
                               boolean IsDecltype/*= false*/) {
  $this().ExprEvalContexts.emplace_back(new ExpressionEvaluationContextRecord(NewContext, $this().ExprCleanupObjects.size(), $this().Cleanup, 
      LambdaContextDecl, IsDecltype));
  $this().Cleanup.reset();
  if (!$this().MaybeODRUseExprs.empty()) {
    std.swap($this().MaybeODRUseExprs, $this().ExprEvalContexts.back().SavedMaybeODRUseExprs);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::PushExpressionEvaluationContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12832,
 FQN="clang::Sema::PushExpressionEvaluationContext", NM="_ZN5clang4Sema31PushExpressionEvaluationContextENS0_27ExpressionEvaluationContextENS0_24ReuseLambdaContextDecl_tEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema31PushExpressionEvaluationContextENS0_27ExpressionEvaluationContextENS0_24ReuseLambdaContextDecl_tEb")
//</editor-fold>
public final void PushExpressionEvaluationContext(ExpressionEvaluationContext NewContext, 
                               ReuseLambdaContextDecl_t $Prm1) {
  PushExpressionEvaluationContext(NewContext, 
                               $Prm1, 
                               false);
}
public final void PushExpressionEvaluationContext(ExpressionEvaluationContext NewContext, 
                               ReuseLambdaContextDecl_t $Prm1, 
                               boolean IsDecltype/*= false*/) {
  Decl /*P*/ ClosureContextDecl = $this().ExprEvalContexts.back().ManglingContextDecl;
  $this().PushExpressionEvaluationContext(NewContext, ClosureContextDecl, IsDecltype);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::PopExpressionEvaluationContext">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12840,
 FQN="clang::Sema::PopExpressionEvaluationContext", NM="_ZN5clang4Sema30PopExpressionEvaluationContextEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema30PopExpressionEvaluationContextEv")
//</editor-fold>
public final void PopExpressionEvaluationContext() {
  final ExpressionEvaluationContextRecord /*&*/ Rec = $this().ExprEvalContexts.back();
  /*uint*/int NumTypos = Rec.NumTypos;
  if (!Rec.Lambdas.empty()) {
    if (Rec.isUnevaluated() || Rec.Context == ExpressionEvaluationContext.ConstantEvaluated) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*uint*/int D;
        if (Rec.isUnevaluated()) {
          // C++11 [expr.prim.lambda]p2:
          //   A lambda-expression shall not appear in an unevaluated operand
          //   (Clause 5).
          D = diag.err_lambda_unevaluated_operand;
        } else {
          // C++1y [expr.const]p2:
          //   A conditional-expression e is a core constant expression unless the
          //   evaluation of e, following the rules of the abstract machine, would
          //   evaluate [...] a lambda-expression.
          D = diag.err_lambda_in_constant_expression;
        }
        for (/*const*/ LambdaExpr /*P*/ L : Rec.Lambdas)  {
          $c$.clean($c$.track($this().Diag(L.getLocStart(), D)));
        }
      } finally {
        $c$.$destroy();
      }
    } else {
      // Mark the capture expressions odr-used. This was deferred
      // during lambda expression creation.
      for (LambdaExpr /*P*/ Lambda : Rec.Lambdas) {
        for (Expr /*P*/ C : Lambda.capture_inits())  {
          $this().MarkDeclarationsReferencedInExpr(C);
        }
      }
    }
  }
  
  // When are coming out of an unevaluated context, clear out any
  // temporaries that we may have created as part of the evaluation of
  // the expression in that context: they aren't relevant because they
  // will never be constructed.
  if (Rec.isUnevaluated() || Rec.Context == ExpressionEvaluationContext.ConstantEvaluated) {
    $this().ExprCleanupObjects.erase($this().ExprCleanupObjects.begin().$add(Rec.NumCleanupObjects), 
        $this().ExprCleanupObjects.end());
    $this().Cleanup.$assign(Rec.ParentCleanup);
    $this().CleanupVarDeclMarking();
    std.swap($this().MaybeODRUseExprs, Rec.SavedMaybeODRUseExprs);
    // Otherwise, merge the contexts together.
  } else {
    $this().Cleanup.mergeFrom(new CleanupInfo(Rec.ParentCleanup));
    $this().MaybeODRUseExprs.insert$T(Rec.SavedMaybeODRUseExprs.begin(), 
        Rec.SavedMaybeODRUseExprs.end());
  }
  
  // Pop the current expression evaluation context off the stack.
  $this().ExprEvalContexts.pop_back();
  if (!$this().ExprEvalContexts.empty()) {
    $this().ExprEvalContexts.back().NumTypos += NumTypos;
  } else {
    assert (NumTypos == 0) : "There are outstanding typos after popping the last ExpressionEvaluationContextRecord";
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiscardCleanupsInEvaluationContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12898,
 FQN="clang::Sema::DiscardCleanupsInEvaluationContext", NM="_ZN5clang4Sema34DiscardCleanupsInEvaluationContextEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema34DiscardCleanupsInEvaluationContextEv")
//</editor-fold>
public final void DiscardCleanupsInEvaluationContext() {
  $this().ExprCleanupObjects.erase($this().ExprCleanupObjects.begin().$add($this().ExprEvalContexts.back().NumCleanupObjects), 
      $this().ExprCleanupObjects.end());
  $this().Cleanup.reset();
  $this().MaybeODRUseExprs.clear();
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::TransformToPotentiallyEvaluated">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12811,
 FQN="clang::Sema::TransformToPotentiallyEvaluated", NM="_ZN5clang4Sema31TransformToPotentiallyEvaluatedEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema31TransformToPotentiallyEvaluatedEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > TransformToPotentiallyEvaluated(Expr /*P*/ E) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert ($this().isUnevaluatedContext()) : "Should only transform unevaluated expressions";
    $this().ExprEvalContexts.back().Context
       = $this().ExprEvalContexts.$at($this().ExprEvalContexts.size() - 2).Context;
    if ($this().isUnevaluatedContext()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    return $c$.clean($c$.track(new TransformToPE(/*Deref*/$this())).TransformExpr(E));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::HandleExprEvaluationContextForTypeof">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12906,
 FQN="clang::Sema::HandleExprEvaluationContextForTypeof", NM="_ZN5clang4Sema36HandleExprEvaluationContextForTypeofEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema36HandleExprEvaluationContextForTypeofEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > HandleExprEvaluationContextForTypeof(Expr /*P*/ E) {
  if (!E.getType().$arrow().isVariablyModifiedType()) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }
  return $this().TransformToPotentiallyEvaluated(E);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnConstantExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 13822,
 FQN="clang::Sema::ActOnConstantExpression", NM="_ZN5clang4Sema23ActOnConstantExpressionENS_12ActionResultIPNS_4ExprELb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema23ActOnConstantExpressionENS_12ActionResultIPNS_4ExprELb1EEE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnConstantExpression(ActionResultTTrue<Expr /*P*/ > Res) {
  Res.$assignMove($this().CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(Res)));
  if (!Res.isUsable()) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$Move.INSTANCE, Res);
  }
  
  // If a constant-expression is a reference to a variable where we delay
  // deciding whether it is an odr-use, just assume we will apply the
  // lvalue-to-rvalue conversion.  In the one case where this doesn't happen
  // (a non-type template argument), we have special handling anyway.
  $this().UpdateMarkingForLValueToRValue(Res.get());
  return new ActionResultTTrue<Expr /*P*/ >(JD$Move.INSTANCE, Res);
}


// Functions for marking a declaration referenced.  These functions also
// contain the relevant logic for marking if a reference to a function or
// variable is an odr-use (in the C++11 sense).  There are separate variants
// for expressions referring to a decl; these exist because odr-use marking
// needs to be delayed for some constant variables when we build one of the
// named expressions.
//
// MightBeOdrUse indicates whether the use could possibly be an odr-use, and
// should usually be true. This only needs to be set to false if the lack of
// odr-use cannot be determined from the current context (for instance,
// because the name denotes a virtual function and was written without an
// explicit nested-name-specifier).

/// \brief Perform marking for a reference to an arbitrary declaration.  It
/// marks the declaration referenced, and performs odr-use checking for
/// functions and variables. This method should not be used when building a
/// normal expression which refers to a variable.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MarkAnyDeclReferenced">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14058,
 FQN="clang::Sema::MarkAnyDeclReferenced", NM="_ZN5clang4Sema21MarkAnyDeclReferencedENS_14SourceLocationEPNS_4DeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema21MarkAnyDeclReferencedENS_14SourceLocationEPNS_4DeclEb")
//</editor-fold>
public final void MarkAnyDeclReferenced(SourceLocation Loc, Decl /*P*/ D, 
                     boolean MightBeOdrUse) {
  if (MightBeOdrUse) {
    {
      VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
      if ((VD != null)) {
        $this().MarkVariableReferenced(new SourceLocation(Loc), VD);
        return;
      }
    }
  }
  {
    FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
    if ((FD != null)) {
      $this().MarkFunctionReferenced(new SourceLocation(Loc), FD, MightBeOdrUse);
      return;
    }
  }
  D.setReferenced();
}


/// \brief Mark a function referenced, and check whether it is odr-used
/// (C++ [basic.def.odr]p2, C99 6.9p3)
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MarkFunctionReferenced">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12949,
 FQN="clang::Sema::MarkFunctionReferenced", NM="_ZN5clang4Sema22MarkFunctionReferencedENS_14SourceLocationEPNS_12FunctionDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema22MarkFunctionReferencedENS_14SourceLocationEPNS_12FunctionDeclEb")
//</editor-fold>
public final void MarkFunctionReferenced(SourceLocation Loc, FunctionDecl /*P*/ Func) {
  MarkFunctionReferenced(Loc, Func, 
                      true);
}
public final void MarkFunctionReferenced(SourceLocation Loc, FunctionDecl /*P*/ Func, 
                      boolean MightBeOdrUse/*= true*/) {
  assert ((Func != null)) : "No function?";
  
  Func.setReferenced();
  
  // C++11 [basic.def.odr]p3:
  //   A function whose name appears as a potentially-evaluated expression is
  //   odr-used if it is the unique lookup result or the selected member of a
  //   set of overloaded functions [...].
  //
  // We (incorrectly) mark overload resolution as an unevaluated context, so we
  // can just check that here.
  boolean OdrUse = MightBeOdrUse && IsPotentiallyEvaluatedContext(/*Deref*/$this());
  
  // Determine whether we require a function definition to exist, per
  // C++11 [temp.inst]p3:
  //   Unless a function template specialization has been explicitly
  //   instantiated or explicitly specialized, the function template
  //   specialization is implicitly instantiated when the specialization is
  //   referenced in a context that requires a function definition to exist.
  //
  // We consider constexpr function templates to be referenced in a context
  // that requires a definition to exist whenever they are referenced.
  //
  // FIXME: This instantiates constexpr functions too frequently. If this is
  // really an unevaluated context (and we're not just in the definition of a
  // function template or overload resolution or other cases which we
  // incorrectly consider to be unevaluated contexts), and we're not in a
  // subexpression which we actually need to evaluate (for instance, a
  // template argument, array bound or an expression in a braced-init-list),
  // we are not permitted to instantiate this constexpr function definition.
  //
  // FIXME: This also implicitly defines special members too frequently. They
  // are only supposed to be implicitly defined if they are odr-used, but they
  // are not odr-used from constant expressions in unevaluated contexts.
  // However, they cannot be referenced if they are deleted, and they are
  // deleted whenever the implicit definition of the special member would
  // fail (with very few exceptions).
  CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(Func);
  boolean NeedDefinition = OdrUse || (Func.isConstexpr() && (Func.isImplicitlyInstantiable()
     || ((MD != null) && !MD.isUserProvided())));
  
  // C++14 [temp.expl.spec]p6:
  //   If a template [...] is explicitly specialized then that specialization
  //   shall be declared before the first use of that specialization that would
  //   cause an implicit instantiation to take place, in every translation unit
  //   in which such a use occurs
  if (NeedDefinition
     && (Func.getTemplateSpecializationKind() != TemplateSpecializationKind.TSK_Undeclared
     || (Func.getMemberSpecializationInfo() != null))) {
    $this().checkSpecializationVisibility(new SourceLocation(Loc), Func);
  }
  
  // If we don't need to mark the function as used, and we don't need to
  // try to provide a definition, there's nothing more to do.
  if ((Func.isUsed(/*CheckUsedAttr=*/ false) || !OdrUse)
     && (!NeedDefinition || (Func.getBody() != null))) {
    return;
  }
  {
    
    // Note that this declaration has been used.
    CXXConstructorDecl /*P*/ Constructor = dyn_cast_CXXConstructorDecl(Func);
    if ((Constructor != null)) {
      Constructor = cast_CXXConstructorDecl(Constructor.getFirstDecl());
      if (Constructor.isDefaulted() && !Constructor.isDeleted()) {
        if (Constructor.isDefaultConstructor()) {
          if (Constructor.isTrivial() && !Constructor.hasAttr(DLLExportAttr.class)) {
            return;
          }
          $this().DefineImplicitDefaultConstructor(new SourceLocation(Loc), Constructor);
        } else if (Constructor.isCopyConstructor()) {
          $this().DefineImplicitCopyConstructor(new SourceLocation(Loc), Constructor);
        } else if (Constructor.isMoveConstructor()) {
          $this().DefineImplicitMoveConstructor(new SourceLocation(Loc), Constructor);
        }
      } else if (Constructor.getInheritedConstructor().$bool()) {
        $this().DefineInheritingConstructor(new SourceLocation(Loc), Constructor);
      }
    } else {
      CXXDestructorDecl /*P*/ Destructor = dyn_cast_CXXDestructorDecl(Func);
      if ((Destructor != null)) {
        Destructor = cast_CXXDestructorDecl(Destructor.getFirstDecl());
        if (Destructor.isDefaulted() && !Destructor.isDeleted()) {
          if (Destructor.isTrivial() && !Destructor.hasAttr(DLLExportAttr.class)) {
            return;
          }
          $this().DefineImplicitDestructor(new SourceLocation(Loc), Destructor);
        }
        if (Destructor.isVirtual() && $this().getLangOpts().AppleKext) {
          $this().MarkVTableUsed(new SourceLocation(Loc), Destructor.getParent());
        }
      } else {
        CXXMethodDecl /*P*/ MethodDecl = dyn_cast_CXXMethodDecl(Func);
        if ((MethodDecl != null)) {
          if (MethodDecl.isOverloadedOperator()
             && MethodDecl.getOverloadedOperator() == OverloadedOperatorKind.OO_Equal) {
            MethodDecl = cast_CXXMethodDecl(MethodDecl.getFirstDecl());
            if (MethodDecl.isDefaulted() && !MethodDecl.isDeleted()) {
              if (MethodDecl.isCopyAssignmentOperator()) {
                $this().DefineImplicitCopyAssignment(new SourceLocation(Loc), MethodDecl);
              } else if (MethodDecl.isMoveAssignmentOperator()) {
                $this().DefineImplicitMoveAssignment(new SourceLocation(Loc), MethodDecl);
              }
            }
          } else if (isa_CXXConversionDecl(MethodDecl)
             && MethodDecl.getParent().isLambda()) {
            CXXConversionDecl /*P*/ Conversion = cast_CXXConversionDecl(MethodDecl.getFirstDecl());
            if (Conversion.isLambdaToBlockPointerConversion()) {
              $this().DefineImplicitLambdaToBlockPointerConversion(new SourceLocation(Loc), Conversion);
            } else {
              $this().DefineImplicitLambdaToFunctionPointerConversion(new SourceLocation(Loc), Conversion);
            }
          } else if (MethodDecl.isVirtual() && $this().getLangOpts().AppleKext) {
            $this().MarkVTableUsed(new SourceLocation(Loc), MethodDecl.getParent());
          }
        }
      }
    }
  }
  
  // Recursive functions should be marked when used from another function.
  // FIXME: Is this really right?
  if ($this().CurContext == Func) {
    return;
  }
  
  // Resolve the exception specification for any function which is
  // used: CodeGen will need it.
  /*const*/ FunctionProtoType /*P*/ FPT = Func.getType().$arrow().getAs(FunctionProtoType.class);
  if ((FPT != null) && isUnresolvedExceptionSpec(FPT.getExceptionSpecType())) {
    $this().ResolveExceptionSpec(new SourceLocation(Loc), FPT);
  }
  
  // Implicit instantiation of function templates and member functions of
  // class templates.
  if (Func.isImplicitlyInstantiable()) {
    boolean AlreadyInstantiated = false;
    SourceLocation PointOfInstantiation = new SourceLocation(Loc);
    {
      FunctionTemplateSpecializationInfo /*P*/ SpecInfo = Func.getTemplateSpecializationInfo();
      if ((SpecInfo != null)) {
        if (SpecInfo.getPointOfInstantiation().isInvalid()) {
          SpecInfo.setPointOfInstantiation(new SourceLocation(Loc));
        } else if (SpecInfo.getTemplateSpecializationKind()
           == TemplateSpecializationKind.TSK_ImplicitInstantiation) {
          AlreadyInstantiated = true;
          PointOfInstantiation.$assignMove(SpecInfo.getPointOfInstantiation());
        }
      } else {
        MemberSpecializationInfo /*P*/ MSInfo = Func.getMemberSpecializationInfo();
        if ((MSInfo != null)) {
          if (MSInfo.getPointOfInstantiation().isInvalid()) {
            MSInfo.setPointOfInstantiation(new SourceLocation(Loc));
          } else if (MSInfo.getTemplateSpecializationKind()
             == TemplateSpecializationKind.TSK_ImplicitInstantiation) {
            AlreadyInstantiated = true;
            PointOfInstantiation.$assignMove(MSInfo.getPointOfInstantiation());
          }
        }
      }
    }
    if (!AlreadyInstantiated || Func.isConstexpr()) {
      if (isa_CXXRecordDecl(Func.getDeclContext())
         && (cast_CXXRecordDecl(Func.getDeclContext()).isLocalClass() != null)
         && ($this().ActiveTemplateInstantiations.size() != 0)) {
        $this().PendingLocalImplicitInstantiations.push_back_T$RR(new std.pairPtrType<ValueDecl /*P*/ , SourceLocation>(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/Func, new SourceLocation(JD$Move.INSTANCE, /*Fwd*/new SourceLocation(/*Fwd2*/PointOfInstantiation))));
      } else if (Func.isConstexpr()) {
        // Do not defer instantiations of constexpr functions, to avoid the
        // expression evaluator needing to call back into Sema if it sees a
        // call to such a function.
        $this().InstantiateFunctionDefinition(new SourceLocation(PointOfInstantiation), Func);
      } else {
        $this().PendingInstantiations.push_back_T$RR(new std.pairPtrType<ValueDecl /*P*/ , SourceLocation>(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/Func, new SourceLocation(JD$Move.INSTANCE, /*Fwd*/new SourceLocation(/*Fwd2*/PointOfInstantiation))));
        // Notify the consumer that a function was implicitly instantiated.
        $this().Consumer.HandleCXXImplicitFunctionInstantiation(Func);
      }
    }
  } else {
    // Walk redefinitions, as some of them may be instantiable.
    for (FunctionDecl /*P*/ i : Func.redeclarable_redecls()) {
      if (!i.isUsed(false) && i.isImplicitlyInstantiable()) {
        $this().MarkFunctionReferenced(new SourceLocation(Loc), i, OdrUse);
      }
    }
  }
  if (!OdrUse) {
    return;
  }
  
  // Keep track of used but undefined functions.
  if (!Func.isDefined()) {
    if (mightHaveNonExternalLinkage(Func)) {
      $this().UndefinedButUsed.insert(new std.pairPtrType<NamedDecl /*P*/ , SourceLocation>(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/Func.getCanonicalDecl(), new SourceLocation(JD$Move.INSTANCE, /*Fwd*/new SourceLocation(/*Fwd2*/Loc))));
    } else if (Func.getMostRecentDecl$Redeclarable().isInlined()
       && !$this().LangOpts.GNUInline
       && !Func.getMostRecentDecl$Redeclarable().hasAttr(GNUInlineAttr.class)) {
      $this().UndefinedButUsed.insert(new std.pairPtrType<NamedDecl /*P*/ , SourceLocation>(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/Func.getCanonicalDecl(), new SourceLocation(JD$Move.INSTANCE, /*Fwd*/new SourceLocation(/*Fwd2*/Loc))));
    }
  }
  
  Func.markUsed($this().Context);
}


/// \brief Mark a variable referenced, and check whether it is odr-used
/// (C++ [basic.def.odr]p2, C99 6.9p3).  Note that this should not be
/// used directly for normal expressions referring to VarDecl.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MarkVariableReferenced">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 13984,
 FQN="clang::Sema::MarkVariableReferenced", NM="_ZN5clang4Sema22MarkVariableReferencedENS_14SourceLocationEPNS_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema22MarkVariableReferencedENS_14SourceLocationEPNS_7VarDeclE")
//</editor-fold>
public final void MarkVariableReferenced(SourceLocation Loc, VarDecl /*P*/ Var) {
  DoMarkVarDeclReferenced(/*Deref*/$this(), new SourceLocation(Loc), Var, (Expr /*P*/ )null);
}


/// \brief Perform reference-marking and odr-use handling for a DeclRefExpr.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MarkDeclRefReferenced">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14024,
 FQN="clang::Sema::MarkDeclRefReferenced", NM="_ZN5clang4Sema21MarkDeclRefReferencedEPNS_11DeclRefExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema21MarkDeclRefReferencedEPNS_11DeclRefExprE")
//</editor-fold>
public final void MarkDeclRefReferenced(DeclRefExpr /*P*/ E) {
  // TODO: update this with DR# once a defect report is filed.
  // C++11 defect. The address of a pure member should not be an ODR use, even
  // if it's a qualified reference.
  boolean OdrUse = true;
  {
    CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(E.getDecl());
    if ((Method != null)) {
      if (Method.isVirtual()) {
        OdrUse = false;
      }
    }
  }
  MarkExprReferenced(/*Deref*/$this(), E.getLocation(), E.getDecl(), E, OdrUse);
}


/// \brief Perform reference-marking and odr-use handling for a MemberExpr.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MarkMemberReferenced">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14036,
 FQN="clang::Sema::MarkMemberReferenced", NM="_ZN5clang4Sema20MarkMemberReferencedEPNS_10MemberExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema20MarkMemberReferencedEPNS_10MemberExprE")
//</editor-fold>
public final void MarkMemberReferenced(MemberExpr /*P*/ E) {
  // C++11 [basic.def.odr]p2:
  //   A non-overloaded function whose name appears as a potentially-evaluated
  //   expression or a member of a set of candidate functions, if selected by
  //   overload resolution when referred to from a potentially-evaluated
  //   expression, is odr-used, unless it is a pure virtual function and its
  //   name is not explicitly qualified.
  boolean MightBeOdrUse = true;
  if (E.performsVirtualDispatch($this().getLangOpts())) {
    {
      CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(E.getMemberDecl());
      if ((Method != null)) {
        if (Method.isPure()) {
          MightBeOdrUse = false;
        }
      }
    }
  }
  SourceLocation Loc = E.getMemberLoc().isValid() ? E.getMemberLoc() : E.getLocStart();
  MarkExprReferenced(/*Deref*/$this(), new SourceLocation(Loc), E.getMemberDecl(), E, MightBeOdrUse);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::UpdateMarkingForLValueToRValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 13797,
 FQN="clang::Sema::UpdateMarkingForLValueToRValue", NM="_ZN5clang4Sema30UpdateMarkingForLValueToRValueEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema30UpdateMarkingForLValueToRValueEPNS_4ExprE")
//</editor-fold>
public final void UpdateMarkingForLValueToRValue(Expr /*P*/ E) {
  // Per C++11 [basic.def.odr], a variable is odr-used "unless it is 
  // an object that satisfies the requirements for appearing in a
  // constant expression (5.19) and the lvalue-to-rvalue conversion (4.1)
  // is immediately applied."  This function handles the lvalue-to-rvalue
  // conversion part.
  $this().MaybeODRUseExprs.erase(E.IgnoreParens());
  {
    
    // If we are in a lambda, check if this DeclRefExpr or MemberExpr refers
    // to a variable that is a constant expression, and if so, identify it as
    // a reference to a variable that does not involve an odr-use of that 
    // variable. 
    LambdaScopeInfo /*P*/ LSI = $this().getCurLambda();
    if ((LSI != null)) {
      Expr /*P*/ SansParensExpr = E.IgnoreParens();
      VarDecl /*P*/ Var = null;
      {
        DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(SansParensExpr);
        if ((DRE != null)) {
          Var = dyn_cast_VarDecl(DRE.getFoundDecl());
        } else {
          MemberExpr /*P*/ ME = dyn_cast_MemberExpr(SansParensExpr);
          if ((ME != null)) {
            Var = dyn_cast_VarDecl(ME.getMemberDecl());
          }
        }
      }
      if ((Var != null) && IsVariableNonDependentAndAConstantExpression(Var, $this().Context)) {
        LSI.markVariableExprAsNonODRUsed(SansParensExpr);
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CleanupVarDeclMarking">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 13836,
 FQN="clang::Sema::CleanupVarDeclMarking", NM="_ZN5clang4Sema21CleanupVarDeclMarkingEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema21CleanupVarDeclMarkingEv")
//</editor-fold>
public final void CleanupVarDeclMarking() {
  for (Expr /*P*/ E : $this().MaybeODRUseExprs) {
    VarDecl /*P*/ Var;
    SourceLocation Loc/*J*/= new SourceLocation();
    {
      DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
      if ((DRE != null)) {
        Var = cast_VarDecl(DRE.getDecl());
        Loc.$assignMove(DRE.getLocation());
      } else {
        MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E);
        if ((ME != null)) {
          Var = cast_VarDecl(ME.getMemberDecl());
          Loc.$assignMove(ME.getMemberLoc());
        } else {
          throw new llvm_unreachable("Unexpected expression");
        }
      }
    }
    
    MarkVarDeclODRUsed(Var, new SourceLocation(Loc), /*Deref*/$this(), 
        /*MaxFunctionScopeIndex Pointer*/ (/*const*/uint$ptr/*uint P*/ )null);
  }
  
  $this().MaybeODRUseExprs.clear();
}


/// \brief Try to capture the given variable.
///
/// \param Var The variable to capture.
///
/// \param Loc The location at which the capture occurs.
///
/// \param Kind The kind of capture, which may be implicit (for either a
/// block or a lambda), or explicit by-value or by-reference (for a lambda).
///
/// \param EllipsisLoc The location of the ellipsis, if one is provided in
/// an explicit lambda capture.
///
/// \param BuildAndDiagnose Whether we are actually supposed to add the
/// captures or diagnose errors. If false, this routine merely check whether
/// the capture can occur without performing the capture itself or complaining
/// if the variable cannot be captured.
///
/// \param CaptureType Will be set to the type of the field used to capture
/// this variable in the innermost block or lambda. Only valid when the
/// variable can be captured.
///
/// \param DeclRefType Will be set to the type of a reference to the capture
/// from within the current scope. Only valid when the variable can be
/// captured.
///
/// \param FunctionScopeIndexToStopAt If non-null, it points to the index
/// of the FunctionScopeInfo stack beyond which we do not attempt to capture.
/// This is useful when enclosing lambdas must speculatively capture 
/// variables that may or may not be used in certain specializations of
/// a nested generic lambda.
/// 
/// \returns true if an error occurred (i.e., the variable cannot be
/// captured) and false if the capture succeeded.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::tryCaptureVariable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 13552,
 FQN="clang::Sema::tryCaptureVariable", NM="_ZN5clang4Sema18tryCaptureVariableEPNS_7VarDeclENS_14SourceLocationENS0_14TryCaptureKindES3_bRNS_8QualTypeES6_PKj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema18tryCaptureVariableEPNS_7VarDeclENS_14SourceLocationENS0_14TryCaptureKindES3_bRNS_8QualTypeES6_PKj")
//</editor-fold>
public final boolean tryCaptureVariable(VarDecl /*P*/ Var, SourceLocation ExprLoc, TryCaptureKind Kind, 
                  SourceLocation EllipsisLoc, boolean BuildAndDiagnose, final QualType /*&*/ CaptureType, 
                  final QualType /*&*/ DeclRefType, /*const*/uint$ptr/*uint P*//*const*/ FunctionScopeIndexToStopAt) {
  // An init-capture is notionally from the context surrounding its
  // declaration, but its parent DC is the lambda class.
  DeclContext /*P*/ VarDC = Var.getDeclContext();
  if (Var.isInitCapture()) {
    VarDC = VarDC.getParent();
  }
  
  DeclContext /*P*/ DC = $this().CurContext;
  /*const*//*uint*/int MaxFunctionScopesIndex = Native.$bool(FunctionScopeIndexToStopAt) ? FunctionScopeIndexToStopAt.$star() : $this().FunctionScopes.size() - 1;
  // We need to sync up the Declaration Context with the
  // FunctionScopeIndexToStopAt
  if (Native.$bool(FunctionScopeIndexToStopAt)) {
    /*uint*/int FSIndex = $this().FunctionScopes.size() - 1;
    while (FSIndex != MaxFunctionScopesIndex) {
      DC = getLambdaAwareParentOfDeclContext(DC);
      --FSIndex;
    }
  }
  
  // If the variable is declared in the current context, there is no need to
  // capture it.
  if (VarDC == DC) {
    return true;
  }
  
  // Capture global variables if it is required to use private copy of this
  // variable.
  boolean IsGlobal = !Var.hasLocalStorage();
  if (IsGlobal && !(($this().LangOpts.OpenMP != 0) && ($this().IsOpenMPCapturedDecl(Var) != null))) {
    return true;
  }
  
  // Walk up the stack to determine whether we can capture the variable,
  // performing the "simple" checks that don't depend on type. We stop when
  // we've either hit the declared scope of the variable or find an existing
  // capture of that variable.  We start from the innermost capturing-entity
  // (the DC) and ensure that all intervening capturing-entities 
  // (blocks/lambdas etc.) between the innermost capturer and the variable`s
  // declcontext can either capture the variable or have already captured
  // the variable.
  CaptureType.$assignMove(Var.getType());
  DeclRefType.$assignMove(CaptureType.getNonReferenceType());
  bool$ref Nested = create_bool$ref(false);
  boolean Explicit = (Kind != TryCaptureKind.TryCapture_Implicit);
  /*uint*/int FunctionScopesIndex = MaxFunctionScopesIndex;
  do {
    // Only block literals, captured statements, and lambda expressions can
    // capture; other scopes don't work.
    DeclContext /*P*/ ParentDC = getParentOfCapturingContextOrNull(DC, Var, 
        new SourceLocation(ExprLoc), 
        BuildAndDiagnose, 
        /*Deref*/$this());
    // We need to check for the parent *first* because, if we *have*
    // private-captured a global variable, we need to recursively capture it in
    // intermediate blocks, lambdas, etc.
    if (!(ParentDC != null)) {
      if (IsGlobal) {
        FunctionScopesIndex = MaxFunctionScopesIndex - 1;
        break;
      }
      return true;
    }
    
    FunctionScopeInfo /*P*/ FSI = $this().FunctionScopes.$at(FunctionScopesIndex);
    CapturingScopeInfo /*P*/ CSI = cast_CapturingScopeInfo(FSI);
    
    // Check whether we've already captured it.
    if (isVariableAlreadyCapturedInScopeInfo(CSI, Var, Nested, CaptureType, 
        DeclRefType)) {
      break;
    }
    // If we are instantiating a generic lambda call operator body, 
    // we do not want to capture new variables.  What was captured
    // during either a lambdas transformation or initial parsing
    // should be used. 
    if (isGenericLambdaCallOperatorSpecialization(DC)) {
      if (BuildAndDiagnose) {
        LambdaScopeInfo /*P*/ LSI = cast_LambdaScopeInfo(CSI);
        if (LSI.ImpCaptureStyle == CapturingScopeInfo.ImplicitCaptureStyle.ImpCap_None) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ExprLoc), diag.err_lambda_impcap)), Var.getDeclName()));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Var.getLocation(), diag.note_previous_decl)), 
                Var.getDeclName()));
            $c$.clean($c$.track($this().Diag(LSI.Lambda.getLocStart(), diag.note_lambda_decl)));
          } finally {
            $c$.$destroy();
          }
        } else {
          diagnoseUncapturableValueReference(/*Deref*/$this(), new SourceLocation(ExprLoc), Var, DC);
        }
      }
      return true;
    }
    // Certain capturing entities (lambdas, blocks etc.) are not allowed to capture 
    // certain types of variables (unnamed, variably modified types etc.)
    // so check for eligibility.
    if (!isVariableCapturable(CSI, Var, new SourceLocation(ExprLoc), BuildAndDiagnose, /*Deref*/$this())) {
      return true;
    }
    
    // Try to capture variable-length arrays types.
    if (Var.getType().$arrow().isVariablyModifiedType()) {
      // We're going to walk down into the type and look for VLA
      // expressions.
      QualType QTy = Var.getType();
      {
        ParmVarDecl /*P*/ PVD = dyn_cast_or_null_ParmVarDecl(Var);
        if ((PVD != null)) {
          QTy.$assignMove(PVD.getOriginalType());
        }
      }
      captureVariablyModifiedType($this().Context, new QualType(QTy), CSI);
    }
    if (($this().getLangOpts().OpenMP != 0)) {
      {
        CapturedRegionScopeInfo /*P*/ RSI = dyn_cast_CapturedRegionScopeInfo(CSI);
        if ((RSI != null)) {
          // OpenMP private variables should not be captured in outer scope, so
          // just break here. Similarly, global variables that are captured in a
          // target region should not be captured outside the scope of the region.
          if ($ushort2int(RSI.CapRegionKind) == CapturedRegionKind.CR_OpenMP.getValue()) {
            boolean IsTargetCap = $this().isOpenMPTargetCapturedDecl(Var, $ushort2uint(RSI.OpenMPLevel));
            // When we detect target captures we are looking from inside the
            // target region, therefore we need to propagate the capture from the
            // enclosing region. Therefore, the capture is not initially nested.
            if (IsTargetCap) {
              FunctionScopesIndex--;
            }
            if (IsTargetCap || $this().isOpenMPPrivateDecl(Var, $ushort2uint(RSI.OpenMPLevel))) {
              Nested.$set(!IsTargetCap);
              DeclRefType.$assignMove(DeclRefType.getUnqualifiedType());
              CaptureType.$assignMove($this().Context.getLValueReferenceType(new QualType(DeclRefType)));
              break;
            }
          }
        }
      }
    }
    if (CSI.ImpCaptureStyle == CapturingScopeInfo.ImplicitCaptureStyle.ImpCap_None && !Explicit) {
      // No capture-default, and this is not an explicit capture 
      // so cannot capture this variable.  
      if (BuildAndDiagnose) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ExprLoc), diag.err_lambda_impcap)), Var.getDeclName()));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Var.getLocation(), diag.note_previous_decl)), 
              Var.getDeclName()));
          if ((cast_LambdaScopeInfo(CSI).Lambda != null)) {
            $c$.clean($c$.track($this().Diag(cast_LambdaScopeInfo(CSI).Lambda.getLocStart(), 
                diag.note_lambda_decl)));
          }
        } finally {
          $c$.$destroy();
        }
        // FIXME: If we error out because an outer lambda can not implicitly
        // capture a variable that an inner lambda explicitly captures, we
        // should have the inner lambda do the explicit capture - because
        // it makes for cleaner diagnostics later.  This would purely be done
        // so that the diagnostic does not misleadingly claim that a variable 
        // can not be captured by a lambda implicitly even though it is captured 
        // explicitly.  Suggestion:
        //  - create const bool VariableCaptureWasInitiallyExplicit = Explicit 
        //    at the function head
        //  - cache the StartingDeclContext - this must be a lambda 
        //  - captureInLambda in the innermost lambda the variable.
      }
      return true;
    }
    
    FunctionScopesIndex--;
    DC = ParentDC;
    Explicit = false;
  } while (!VarDC.Equals(DC));
  
  // Walk back down the scope stack, (e.g. from outer lambda to inner lambda)
  // computing the type of the capture at each step, checking type-specific 
  // requirements, and adding captures if requested. 
  // If the variable had already been captured previously, we start capturing 
  // at the lambda nested within that one.   
  for (/*uint*/int I = ++FunctionScopesIndex, N = MaxFunctionScopesIndex + 1; I != N;
       ++I) {
    CapturingScopeInfo /*P*/ CSI = cast_CapturingScopeInfo($this().FunctionScopes.$at(I));
    {
      
      BlockScopeInfo /*P*/ BSI = dyn_cast_BlockScopeInfo(CSI);
      if ((BSI != null)) {
        if (!captureInBlock(BSI, Var, new SourceLocation(ExprLoc), 
            BuildAndDiagnose, CaptureType, 
            DeclRefType, Nested.$deref(), /*Deref*/$this())) {
          return true;
        }
        Nested.$set(true);
      } else {
        CapturedRegionScopeInfo /*P*/ RSI = dyn_cast_CapturedRegionScopeInfo(CSI);
        if ((RSI != null)) {
          if (!captureInCapturedRegion(RSI, Var, new SourceLocation(ExprLoc), 
              BuildAndDiagnose, CaptureType, 
              DeclRefType, Nested.$deref(), /*Deref*/$this())) {
            return true;
          }
          Nested.$set(true);
        } else {
          LambdaScopeInfo /*P*/ LSI = cast_LambdaScopeInfo(CSI);
          if (!captureInLambda(LSI, Var, new SourceLocation(ExprLoc), 
              BuildAndDiagnose, CaptureType, 
              DeclRefType, Nested.$deref(), Kind, new SourceLocation(EllipsisLoc), 
              /*IsTopScope*/ I == N - 1, /*Deref*/$this())) {
            return true;
          }
          Nested.$set(true);
        }
      }
    }
  }
  return false;
}


/// \brief Try to capture the given variable.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::tryCaptureVariable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 13744,
 FQN="clang::Sema::tryCaptureVariable", NM="_ZN5clang4Sema18tryCaptureVariableEPNS_7VarDeclENS_14SourceLocationENS0_14TryCaptureKindES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema18tryCaptureVariableEPNS_7VarDeclENS_14SourceLocationENS0_14TryCaptureKindES3_")
//</editor-fold>
public final boolean tryCaptureVariable(VarDecl /*P*/ Var, SourceLocation Loc) {
  return tryCaptureVariable(Var, Loc, 
                  TryCaptureKind.TryCapture_Implicit, new SourceLocation());
}
public final boolean tryCaptureVariable(VarDecl /*P*/ Var, SourceLocation Loc, 
                  TryCaptureKind Kind/*= TryCapture_Implicit*/) {
  return tryCaptureVariable(Var, Loc, 
                  Kind, new SourceLocation());
}
public final boolean tryCaptureVariable(VarDecl /*P*/ Var, SourceLocation Loc, 
                  TryCaptureKind Kind/*= TryCapture_Implicit*/, SourceLocation EllipsisLoc/*= SourceLocation()*/) {
  QualType CaptureType/*J*/= new QualType();
  QualType DeclRefType/*J*/= new QualType();
  return $this().tryCaptureVariable(Var, new SourceLocation(Loc), Kind, new SourceLocation(EllipsisLoc), 
      /*BuildAndDiagnose=*/ true, CaptureType, 
      DeclRefType, (/*const*/uint$ptr/*uint P*/ )null);
}


/// \brief Checks if the variable must be captured.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::NeedToCaptureVariable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 13753,
 FQN="clang::Sema::NeedToCaptureVariable", NM="_ZN5clang4Sema21NeedToCaptureVariableEPNS_7VarDeclENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema21NeedToCaptureVariableEPNS_7VarDeclENS_14SourceLocationE")
//</editor-fold>
public final boolean NeedToCaptureVariable(VarDecl /*P*/ Var, SourceLocation Loc) {
  QualType CaptureType/*J*/= new QualType();
  QualType DeclRefType/*J*/= new QualType();
  return !$this().tryCaptureVariable(Var, new SourceLocation(Loc), TryCaptureKind.TryCapture_Implicit, new SourceLocation(), 
      /*BuildAndDiagnose=*/ false, CaptureType, 
      DeclRefType, (/*const*/uint$ptr/*uint P*/ )null);
}


/// \brief Given a variable, determine the type that a reference to that
/// variable will have in the given scope.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getCapturedDeclRefType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 13761,
 FQN="clang::Sema::getCapturedDeclRefType", NM="_ZN5clang4Sema22getCapturedDeclRefTypeEPNS_7VarDeclENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema22getCapturedDeclRefTypeEPNS_7VarDeclENS_14SourceLocationE")
//</editor-fold>
public final QualType getCapturedDeclRefType(VarDecl /*P*/ Var, SourceLocation Loc) {
  QualType CaptureType/*J*/= new QualType();
  QualType DeclRefType/*J*/= new QualType();
  
  // Determine whether we can capture this variable.
  if ($this().tryCaptureVariable(Var, new SourceLocation(Loc), TryCaptureKind.TryCapture_Implicit, new SourceLocation(), 
      /*BuildAndDiagnose=*/ false, CaptureType, 
      DeclRefType, (/*const*/uint$ptr/*uint P*/ )null)) {
    return new QualType();
  }
  
  return DeclRefType;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::MarkDeclarationsReferencedInType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14111,
 FQN="clang::Sema::MarkDeclarationsReferencedInType", NM="_ZN5clang4Sema32MarkDeclarationsReferencedInTypeENS_14SourceLocationENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema32MarkDeclarationsReferencedInTypeENS_14SourceLocationENS_8QualTypeE")
//</editor-fold>
public final void MarkDeclarationsReferencedInType(SourceLocation Loc, QualType T) {
  MarkReferencedDecls Marker/*J*/= new MarkReferencedDecls(/*Deref*/$this(), new SourceLocation(Loc));
  Marker.TraverseType($this().Context.getCanonicalType(new QualType(T)).$QualType());
}


/// \brief Mark any declarations that appear within this expression or any
/// potentially-evaluated subexpressions as "referenced".
///
/// \param SkipLocalVariables If true, don't mark local variables as 
/// 'referenced'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MarkDeclarationsReferencedInExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14195,
 FQN="clang::Sema::MarkDeclarationsReferencedInExpr", NM="_ZN5clang4Sema32MarkDeclarationsReferencedInExprEPNS_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema32MarkDeclarationsReferencedInExprEPNS_4ExprEb")
//</editor-fold>
public final void MarkDeclarationsReferencedInExpr(Expr /*P*/ E) {
  MarkDeclarationsReferencedInExpr(E, 
                                false);
}
public final void MarkDeclarationsReferencedInExpr(Expr /*P*/ E, 
                                boolean SkipLocalVariables/*= false*/) {
  new EvaluatedExprMarker(/*Deref*/$this(), SkipLocalVariables).Visit(E);
}


/// \brief Conditionally issue a diagnostic based on the current
/// evaluation context.
///
/// \param Statement If Statement is non-null, delay reporting the
/// diagnostic until the function body is parsed, and then do a basic
/// reachability analysis to determine if the statement is reachable.
/// If it is unreachable, the diagnostic will not be emitted.

/// \brief Emit a diagnostic that describes an effect on the run-time behavior
/// of the program being compiled.
///
/// This routine emits the given diagnostic when the code currently being
/// type-checked is "potentially evaluated", meaning that there is a
/// possibility that the code will actually be executable. Code in sizeof()
/// expressions, code used only during overload resolution, etc., are not
/// potentially evaluated. This routine will suppress such diagnostics or,
/// in the absolutely nutty case of potentially potentially evaluated
/// expressions (C++ typeid), queue the diagnostic to potentially emit it
/// later.
///
/// This routine should be used for all diagnostics that describe the run-time
/// behavior of a program, such as passing a non-POD value through an ellipsis.
/// Failure to do so will likely result in spurious diagnostics or failures
/// during overload resolution or within sizeof/alignof/typeof/typeid.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagRuntimeBehavior">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14216,
 FQN="clang::Sema::DiagRuntimeBehavior", NM="_ZN5clang4Sema19DiagRuntimeBehaviorENS_14SourceLocationEPKNS_4StmtERKNS_17PartialDiagnosticE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema19DiagRuntimeBehaviorENS_14SourceLocationEPKNS_4StmtERKNS_17PartialDiagnosticE")
//</editor-fold>
public final boolean DiagRuntimeBehavior(SourceLocation Loc, /*const*/ Stmt /*P*/ Statement, 
                   final /*const*/ PartialDiagnostic /*&*/ PD) {
  switch ($this().ExprEvalContexts.back().Context) {
   case Unevaluated:
   case UnevaluatedAbstract:
   case DiscardedStatement:
    // The argument will never be evaluated, so don't complain.
    break;
   case ConstantEvaluated:
    // Relevant diagnostics should be produced by constant evaluation.
    break;
   case PotentiallyEvaluated:
   case PotentiallyEvaluatedIfUsed:
    if ((Statement != null) && ($this().getCurFunctionOrMethodDecl() != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $this().FunctionScopes.back().PossiblyUnreachableDiags.
            push_back_T$RR($c$.track(new PossiblyUnreachableDiag(PD, new SourceLocation(Loc), Statement))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), PD)));
      } finally {
        $c$.$destroy();
      }
    }
    
    return true;
  }
  
  return false;
}


// Primary Expressions.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getExprRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 500,
 FQN="clang::Sema::getExprRange", NM="_ZNK5clang4Sema12getExprRangeEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang4Sema12getExprRangeEPNS_4ExprE")
//</editor-fold>
public final SourceRange getExprRange(Expr /*P*/ E) /*const*/ {
  return (E != null) ? E.getSourceRange() : new SourceRange();
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnIdExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 2106,
 FQN="clang::Sema::ActOnIdExpression", NM="_ZN5clang4Sema17ActOnIdExpressionEPNS_5ScopeERNS_12CXXScopeSpecENS_14SourceLocationERNS_13UnqualifiedIdEbbSt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteIS9_EEbPNS_5TokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema17ActOnIdExpressionEPNS_5ScopeERNS_12CXXScopeSpecENS_14SourceLocationERNS_13UnqualifiedIdEbbSt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteIS9_EEbPNS_5TokenE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnIdExpression(Scope /*P*/ S, final CXXScopeSpec /*&*/ SS, 
                 SourceLocation TemplateKWLoc, final UnqualifiedId /*&*/ Id, 
                 boolean HasTrailingLParen, boolean IsAddressOfOperand) {
  return ActOnIdExpression(S, SS, 
                 TemplateKWLoc, Id, 
                 HasTrailingLParen, IsAddressOfOperand, 
                 /*$c$.track(*/new std.unique_ptr<CorrectionCandidateCallback>(JD$NullPtr.INSTANCE, null)/*)*/, 
                 false, (Token /*P*/ )null);
}
public final ActionResultTTrue<Expr /*P*/ > ActOnIdExpression(Scope /*P*/ S, final CXXScopeSpec /*&*/ SS, 
                 SourceLocation TemplateKWLoc, final UnqualifiedId /*&*/ Id, 
                 boolean HasTrailingLParen, boolean IsAddressOfOperand, 
                 std.unique_ptr<CorrectionCandidateCallback> CCC/*= null*/) {
  return ActOnIdExpression(S, SS, 
                 TemplateKWLoc, Id, 
                 HasTrailingLParen, IsAddressOfOperand, 
                 CCC, 
                 false, (Token /*P*/ )null);
}
public final ActionResultTTrue<Expr /*P*/ > ActOnIdExpression(Scope /*P*/ S, final CXXScopeSpec /*&*/ SS, 
                 SourceLocation TemplateKWLoc, final UnqualifiedId /*&*/ Id, 
                 boolean HasTrailingLParen, boolean IsAddressOfOperand, 
                 std.unique_ptr<CorrectionCandidateCallback> CCC/*= null*/, 
                 boolean IsInlineAsmIdentifier/*= false*/) {
  return ActOnIdExpression(S, SS, 
                 TemplateKWLoc, Id, 
                 HasTrailingLParen, IsAddressOfOperand, 
                 CCC, 
                 IsInlineAsmIdentifier, (Token /*P*/ )null);
}
public final ActionResultTTrue<Expr /*P*/ > ActOnIdExpression(Scope /*P*/ S, final CXXScopeSpec /*&*/ SS, 
                 SourceLocation TemplateKWLoc, final UnqualifiedId /*&*/ Id, 
                 boolean HasTrailingLParen, boolean IsAddressOfOperand, 
                 std.unique_ptr<CorrectionCandidateCallback> CCC/*= null*/, 
                 boolean IsInlineAsmIdentifier/*= false*/, Token /*P*/ KeywordReplacement/*= null*/) {
  TemplateArgumentListInfo TemplateArgsBuffer = null;
  LookupResult R = null;
  try {
    assert (!(IsAddressOfOperand && HasTrailingLParen)) : "cannot be direct & operand and have a trailing lparen";
    if (SS.isInvalid()) {
      return ExprError();
    }
    
    TemplateArgsBuffer/*J*/= new TemplateArgumentListInfo();
    
    // Decompose the UnqualifiedId into the following data.
    DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo();
    type$ref</*const*/ TemplateArgumentListInfo /*P*/ > TemplateArgs = create_type$ref();
    $this().DecomposeUnqualifiedId(Id, TemplateArgsBuffer, NameInfo, TemplateArgs);
    
    DeclarationName Name = NameInfo.getName();
    IdentifierInfo /*P*/ II = Name.getAsIdentifierInfo();
    SourceLocation NameLoc = NameInfo.getLoc();
    
    // C++ [temp.dep.expr]p3:
    //   An id-expression is type-dependent if it contains:
    //     -- an identifier that was declared with a dependent type,
    //        (note: handled after lookup)
    //     -- a template-id that is dependent,
    //        (note: handled in BuildTemplateIdExpr)
    //     -- a conversion-function-id that specifies a dependent type,
    //     -- a nested-name-specifier that contains a class-name that
    //        names a dependent type.
    // Determine whether this is a member of an unknown specialization;
    // we need to handle these differently.
    boolean DependentID = false;
    if (Name.getNameKind() == DeclarationName.NameKind.CXXConversionFunctionName
       && Name.getCXXNameType().$arrow().isDependentType()) {
      DependentID = true;
    } else if (SS.isSet()) {
      {
        DeclContext /*P*/ DC = $this().computeDeclContext(SS, false);
        if ((DC != null)) {
          if ($this().RequireCompleteDeclContext(SS, DC)) {
            return ExprError();
          }
        } else {
          DependentID = true;
        }
      }
    }
    if (DependentID) {
      return $this().ActOnDependentIdExpression(SS, new SourceLocation(TemplateKWLoc), NameInfo, 
          IsAddressOfOperand, TemplateArgs.$deref());
    }
    
    // Perform the required lookup.
    R/*J*/= new LookupResult(/*Deref*/$this(), NameInfo, 
        (Id.getKind() == UnqualifiedId.IdKind.IK_ImplicitSelfParam) ? LookupNameKind.LookupObjCImplicitSelfParam : LookupNameKind.LookupOrdinaryName);
    if ((TemplateArgs.$deref() != null)) {
      // Lookup the template name again to correctly establish the context in
      // which it was found. This is really unfortunate as we already did the
      // lookup to determine that it was a template name in the first place. If
      // this becomes a performance hit, we can work harder to preserve those
      // results until we get here but it's likely not worth it.
      bool$ref MemberOfUnknownSpecialization = create_bool$ref();
      $this().LookupTemplateName(R, S, SS, new QualType(), /*EnteringContext=*/ false, 
          MemberOfUnknownSpecialization);
      if (MemberOfUnknownSpecialization.$deref()
         || (R.getResultKind() == LookupResult.LookupResultKind.NotFoundInCurrentInstantiation)) {
        return $this().ActOnDependentIdExpression(SS, new SourceLocation(TemplateKWLoc), NameInfo, 
            IsAddressOfOperand, TemplateArgs.$deref());
      }
    } else {
      boolean IvarLookupFollowUp = (II != null) && !SS.isSet() && ($this().getCurMethodDecl() != null);
      $this().LookupParsedName(R, S, $AddrOf(SS), !IvarLookupFollowUp);
      
      // If the result might be in a dependent base class, this is a dependent 
      // id-expression.
      if (R.getResultKind() == LookupResult.LookupResultKind.NotFoundInCurrentInstantiation) {
        return $this().ActOnDependentIdExpression(SS, new SourceLocation(TemplateKWLoc), NameInfo, 
            IsAddressOfOperand, TemplateArgs.$deref());
      }
      
      // If this reference is in an Objective-C method, then we need to do
      // some special Objective-C lookup, too.
      if (IvarLookupFollowUp) {
        ActionResultTTrue<Expr /*P*/ > E/*J*/= $this().LookupInObjCMethod(R, S, II, true);
        if (E.isInvalid()) {
          return ExprError();
        }
        {
          
          Expr /*P*/ Ex = E.getAs(Expr.class);
          if ((Ex != null)) {
            return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Ex);
          }
        }
      }
    }
    if (R.isAmbiguous()) {
      return ExprError();
    }
    
    // This could be an implicitly declared function reference (legal in C90,
    // extension in C99, forbidden in C++).
    if (R.empty() && HasTrailingLParen && (II != null) && !$this().getLangOpts().CPlusPlus) {
      NamedDecl /*P*/ D = $this().ImplicitlyDefineFunction(new SourceLocation(NameLoc), $Deref(II), S);
      if ((D != null)) {
        R.addDecl(D);
      }
    }
    
    // Determine whether this name might be a candidate for
    // argument-dependent lookup.
    boolean ADL = $this().UseArgumentDependentLookup(SS, R, HasTrailingLParen);
    if (R.empty() && !ADL) {
      unique_ptr<CorrectionCandidateCallback> DefaultValidator = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        if (SS.isEmpty() && $this().getLangOpts().MSVCCompat) {
          {
            Expr /*P*/ E = recoverFromMSUnqualifiedLookup(/*Deref*/$this(), $this().Context, NameInfo, 
                new SourceLocation(TemplateKWLoc), TemplateArgs.$deref());
            if ((E != null)) {
              return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
            }
          }
        }
        
        // Don't diagnose an empty lookup for inline assembly.
        if (IsInlineAsmIdentifier) {
          return ExprError();
        }
        
        // If this name wasn't predeclared and if this is not a function
        // call, diagnose the problem.
        type$ptr<TypoExpr /*P*/ > TE = create_type$null$ptr(null);
        DefaultValidator = llvm.make_unique(new CorrectionCandidateCallback(II, SS.isValid() ? SS.getScopeRep() : (NestedNameSpecifier /*P*/ )null));
        DefaultValidator.$arrow().IsAddressOfOperand = IsAddressOfOperand;
        assert ((!CCC.$bool() || CCC.$arrow().IsAddressOfOperand == IsAddressOfOperand)) : "Typo correction callback misconfigured";
        if (CCC.$bool()) {
          // Make sure the callback knows what the typo being diagnosed is.
          CCC.$arrow().setTypoName(II);
          if (SS.isValid()) {
            CCC.$arrow().setTypoNNS(SS.getScopeRep());
          }
        }
        if ($c$.clean($this().DiagnoseEmptyLookup(S, SS, R, 
            $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Move.INSTANCE, CCC.$bool() ? std.move(CCC) : std.move(DefaultValidator))), 
            (TemplateArgumentListInfo /*P*/ )null, ArrayRef.<Expr /*P*/ >None(), $AddrOf(TE)))) {
          if ((TE.$star() != null) && (KeywordReplacement != null)) {
            final /*const*/ TypoExprState /*&*/ State = $this().getTypoExprState(TE.$star());
            TypoCorrection BestTC = new TypoCorrection(State.Consumer.$arrow().getNextCorrection());
            if (BestTC.isKeyword()) {
              IdentifierInfo /*P*/ II$1 = BestTC.getCorrectionAsIdentifierInfo();
              if (State.DiagHandler != null/*.$bool()*/) {
                State.DiagHandler.$call(BestTC);
              }
              KeywordReplacement.startToken();
              KeywordReplacement.setKind(II$1.getTokenID());
              KeywordReplacement.setIdentifierInfo(II$1);
              KeywordReplacement.setLocation(BestTC.getCorrectionRange().getBegin());
              // Clean up the state associated with the TypoExpr, since it has
              // now been diagnosed (without a call to CorrectDelayedTyposInExpr).
              $this().clearDelayedTypo(TE.$star());
              // Signal that a correction to a keyword was performed by returning a
              // valid-but-null ExprResult.
              return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, (Expr /*P*/ )(Expr /*P*/ )null);
            }
            State.Consumer.$arrow().resetCorrectionStream();
          }
          return (TE.$star() != null) ? new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, TE.$star()) : ExprError();
        }
        assert (!R.empty()) : "DiagnoseEmptyLookup returned false but added no results";
        {
          
          // If we found an Objective-C instance variable, let
          // LookupInObjCMethod build the appropriate expression to
          // reference the ivar.
          ObjCIvarDecl /*P*/ Ivar = R.<ObjCIvarDecl>getAsSingle(ObjCIvarDecl.class);
          if ((Ivar != null)) {
            R.clear();
            ActionResultTTrue<Expr /*P*/ > E/*J*/= $this().LookupInObjCMethod(R, S, Ivar.getIdentifier());
            // In a hopelessly buggy code, Objective-C instance variable
            // lookup fails and no expression will be built to reference it.
            if (!E.isInvalid() && !(E.get() != null)) {
              return ExprError();
            }
            return E;
          }
        }
      } finally {
        if (DefaultValidator != null) { DefaultValidator.$destroy(); }
        $c$.$destroy();
      }
    }
    
    // This is guaranteed from this point on.
    assert (!R.empty() || ADL);
    
    // Check whether this might be a C++ implicit instance member access.
    // C++ [class.mfct.non-static]p3:
    //   When an id-expression that is not part of a class member access
    //   syntax and not used to form a pointer to member is used in the
    //   body of a non-static member function of class X, if name lookup
    //   resolves the name in the id-expression to a non-static non-type
    //   member of some class C, the id-expression is transformed into a
    //   class member access expression using (*this) as the
    //   postfix-expression to the left of the . operator.
    //
    // But we don't actually need to do this for '&' operands if R
    // resolved to a function or overloaded function set, because the
    // expression is ill-formed if it actually works out to be a
    // non-static member function:
    //
    // C++ [expr.ref]p4:
    //   Otherwise, if E1.E2 refers to a non-static member function. . .
    //   [t]he expression can be used only as the left-hand operand of a
    //   member function call.
    //
    // There are other safeguards against such uses, but it's important
    // to get this right here so that we don't end up making a
    // spuriously dependent expression if we're inside a dependent
    // instance method.
    if (!R.empty() && (R.begin().$star()).isCXXClassMember()) {
      boolean MightBeImplicitMember;
      if (!IsAddressOfOperand) {
        MightBeImplicitMember = true;
      } else if (!SS.isEmpty()) {
        MightBeImplicitMember = false;
      } else if (R.isOverloadedResult()) {
        MightBeImplicitMember = false;
      } else if (R.isUnresolvableResult()) {
        MightBeImplicitMember = true;
      } else {
        MightBeImplicitMember = isa_FieldDecl(R.getFoundDecl())
           || isa_IndirectFieldDecl(R.getFoundDecl())
           || isa_MSPropertyDecl(R.getFoundDecl());
      }
      if (MightBeImplicitMember) {
        return $this().BuildPossibleImplicitMemberExpr(SS, new SourceLocation(TemplateKWLoc), 
            R, TemplateArgs.$deref(), S);
      }
    }
    if ((TemplateArgs.$deref() != null) || TemplateKWLoc.isValid()) {
      
      // In C++1y, if this is a variable template id, then check it
      // in BuildTemplateIdExpr().
      // The single lookup result must be a variable template declaration.
      if (Id.getKind() == UnqualifiedId.IdKind.IK_TemplateId && (Id.Unnamed_field1.TemplateId != null)
         && Id.Unnamed_field1.TemplateId.Kind == TemplateNameKind.TNK_Var_template) {
        assert ((R.<VarTemplateDecl>getAsSingle(VarTemplateDecl.class) != null)) : "There should only be one declaration found.";
      }
      
      return $this().BuildTemplateIdExpr(SS, new SourceLocation(TemplateKWLoc), R, ADL, TemplateArgs.$deref());
    }
    
    return $this().BuildDeclarationNameExpr(SS, R, ADL);
  } finally {
    if (R != null) { R.$destroy(); }
    if (TemplateArgsBuffer != null) { TemplateArgsBuffer.$destroy(); }
  }
}


/// Decomposes the given name into a DeclarationNameInfo, its location, and
/// possibly a list of template arguments.
///
/// If this produces template arguments, it is permitted to call
/// DecomposeTemplateName.
///
/// This actually loses a lot of source location information for
/// non-standard name kinds; we should consider preserving that in
/// some way.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DecomposeUnqualifiedId">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 1800,
 FQN="clang::Sema::DecomposeUnqualifiedId", NM="_ZN5clang4Sema22DecomposeUnqualifiedIdERKNS_13UnqualifiedIdERNS_24TemplateArgumentListInfoERNS_19DeclarationNameInfoERPKS4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema22DecomposeUnqualifiedIdERKNS_13UnqualifiedIdERNS_24TemplateArgumentListInfoERNS_19DeclarationNameInfoERPKS4_")
//</editor-fold>
public final void DecomposeUnqualifiedId(final /*const*/ UnqualifiedId /*&*/ Id, 
                      final TemplateArgumentListInfo /*&*/ Buffer, 
                      final DeclarationNameInfo /*&*/ NameInfo, 
                      final type$ref</*const*/ TemplateArgumentListInfo /*P*/ /*&*/> TemplateArgs) {
  if (Id.getKind() == UnqualifiedId.IdKind.IK_TemplateId) {
    Buffer.setLAngleLoc(new SourceLocation(Id.Unnamed_field1.TemplateId.LAngleLoc));
    Buffer.setRAngleLoc(new SourceLocation(Id.Unnamed_field1.TemplateId.RAngleLoc));
    
    MutableArrayRef<ParsedTemplateArgument> TemplateArgsPtr/*J*/= new MutableArrayRef<ParsedTemplateArgument>(Id.Unnamed_field1.TemplateId.getTemplateArgs(), 
        Id.Unnamed_field1.TemplateId.NumArgs, false);
    $this().translateTemplateArguments(TemplateArgsPtr, Buffer);
    
    TemplateName TName = Id.Unnamed_field1.TemplateId.Template.getTemplateName();
    SourceLocation TNameLoc = new SourceLocation(Id.Unnamed_field1.TemplateId.TemplateNameLoc);
    NameInfo.$assignMove($this().Context.getNameForTemplate(new TemplateName(TName), new SourceLocation(TNameLoc)));
    TemplateArgs.$set($AddrOf(Buffer));
  } else {
    NameInfo.$assignMove($this().GetNameFromUnqualifiedId(Id));
    TemplateArgs.$set(null);
  }
}


/// Diagnose an empty lookup.
///
/// \return false if new lookup candidates were found
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseEmptyLookup">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 1859,
 FQN="clang::Sema::DiagnoseEmptyLookup", NM="_ZN5clang4Sema19DiagnoseEmptyLookupEPNS_5ScopeERNS_12CXXScopeSpecERNS_12LookupResultESt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteIS8_EEPNS_24TemplateArgumentListInfoEN4llvm8ArrayRefIPNS_4ExprEEEPPNS_8TypoExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema19DiagnoseEmptyLookupEPNS_5ScopeERNS_12CXXScopeSpecERNS_12LookupResultESt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteIS8_EEPNS_24TemplateArgumentListInfoEN4llvm8ArrayRefIPNS_4ExprEEEPPNS_8TypoExprE")
//</editor-fold>
public final boolean DiagnoseEmptyLookup(Scope /*P*/ S, final CXXScopeSpec /*&*/ SS, final LookupResult /*&*/ R, 
                   std.unique_ptr<CorrectionCandidateCallback> CCC) {
  return DiagnoseEmptyLookup(S, SS, R, 
                   CCC, 
                   (TemplateArgumentListInfo /*P*/ )null, 
                   new ArrayRef<Expr /*P*/ >(None, true), (type$ptr<TypoExpr /*P*/ /*P*/>)null);
}
public final boolean DiagnoseEmptyLookup(Scope /*P*/ S, final CXXScopeSpec /*&*/ SS, final LookupResult /*&*/ R, 
                   std.unique_ptr<CorrectionCandidateCallback> CCC, 
                   TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs/*= null*/) {
  return DiagnoseEmptyLookup(S, SS, R, 
                   CCC, 
                   ExplicitTemplateArgs, 
                   new ArrayRef<Expr /*P*/ >(None, true), (type$ptr<TypoExpr /*P*/ /*P*/>)null);
}
public final boolean DiagnoseEmptyLookup(Scope /*P*/ S, final CXXScopeSpec /*&*/ SS, final LookupResult /*&*/ R, 
                   std.unique_ptr<CorrectionCandidateCallback> CCC, 
                   TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs/*= null*/, 
                   ArrayRef<Expr /*P*/ > Args/*= None*/) {
  return DiagnoseEmptyLookup(S, SS, R, 
                   CCC, 
                   ExplicitTemplateArgs, 
                   Args, (type$ptr<TypoExpr /*P*/ /*P*/>)null);
}
public final boolean DiagnoseEmptyLookup(Scope /*P*/ S, final CXXScopeSpec /*&*/ SS, final LookupResult /*&*/ R, 
                   std.unique_ptr<CorrectionCandidateCallback> CCC, 
                   TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs/*= null*/, 
                   ArrayRef<Expr /*P*/ > Args/*= None*/, type$ptr<TypoExpr /*P*/ /*P*/> Out/*= null*/) {
  TypoCorrection Corrected = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    DeclarationName Name = R.getLookupName();
    
    /*uint*/int diagnostic = diag.err_undeclared_var_use;
    /*uint*/int diagnostic_suggest = diag.err_undeclared_var_use_suggest;
    if (Name.getNameKind() == DeclarationName.NameKind.CXXOperatorName
       || Name.getNameKind() == DeclarationName.NameKind.CXXLiteralOperatorName
       || Name.getNameKind() == DeclarationName.NameKind.CXXConversionFunctionName) {
      diagnostic = diag.err_undeclared_use;
      diagnostic_suggest = diag.err_undeclared_use_suggest;
    }
    
    // If the original lookup was an unqualified lookup, fake an
    // unqualified lookup.  This is useful when (for example) the
    // original lookup would not have found something because it was a
    // dependent name.
    DeclContext /*P*/ DC = SS.isEmpty() ? $this().CurContext : null;
    while ((DC != null)) {
      if (isa_CXXRecordDecl(DC)) {
        $this().LookupQualifiedName(R, DC);
        if (!R.empty()) {
          // Don't give errors about ambiguities in this lookup.
          R.suppressDiagnostics();
          
          // During a default argument instantiation the CurContext points
          // to a CXXMethodDecl; but we can't apply a this-> fixit inside a
          // function parameter list, hence add an explicit check.
          boolean isDefaultArgument = !$this().ActiveTemplateInstantiations.empty()
             && $this().ActiveTemplateInstantiations.back().Kind
             == ActiveTemplateInstantiation.InstantiationKind.DefaultFunctionArgumentInstantiation;
          CXXMethodDecl /*P*/ CurMethod = dyn_cast_CXXMethodDecl($this().CurContext);
          boolean isInstance = (CurMethod != null)
             && CurMethod.isInstance()
             && DC == CurMethod.getParent() && !isDefaultArgument;
          
          // Give a code modification hint to insert 'this->'.
          // TODO: fixit for inserting 'Base<T>::' in the other cases.
          // Actually quite difficult!
          if ($this().getLangOpts().MSVCCompat) {
            diagnostic = diag.ext_found_via_dependent_bases_lookup;
          }
          if (isInstance) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(R.getNameLoc(), diagnostic)), Name), 
                FixItHint.CreateInsertion(R.getNameLoc(), new StringRef(/*KEEP_STR*/"this->"))));
            $this().CheckCXXThisCapture(R.getNameLoc());
          } else {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(R.getNameLoc(), diagnostic)), Name));
          }
          
          // Do we really want to note all of these?
          for (NamedDecl /*P*/ D : R)  {
            $c$.clean($c$.track($this().Diag(D.getLocation(), diag.note_dependent_var_use)));
          }
          
          // Return true if we are inside a default argument instantiation
          // and the found name refers to an instance member function, otherwise
          // the function calling DiagnoseEmptyLookup will try to create an
          // implicit member call and this is wrong for default argument.
          if (isDefaultArgument && ((R.begin().$star()).isCXXInstanceMember())) {
            $c$.clean($c$.track($this().Diag(R.getNameLoc(), diag.err_member_call_without_object)));
            return true;
          }
          
          // Tell the callee to try to recover.
          return false;
        }
        
        R.clear();
      }
      
      // In Microsoft mode, if we are performing lookup from within a friend
      // function definition declared at class scope then we must set
      // DC to the lexical parent to be able to search into the parent
      // class.
      if ($this().getLangOpts().MSVCCompat && isa_FunctionDecl(DC)
         && (cast_FunctionDecl(DC).getFriendObjectKind().getValue() != 0)
         && DC.getLexicalParent().isRecord()) {
        DC = DC.getLexicalParent();
      } else {
        DC = DC.getParent();
      }
    }
    
    // We didn't find anything, so try to correct for a typo.
    Corrected/*J*/= new TypoCorrection();
    if ((S != null) && (Out != null)) {
      SourceLocation TypoLoc = R.getNameLoc();
      assert (!(ExplicitTemplateArgs != null)) : "Diagnosing an empty lookup with explicit template args!";
      CXXScopeSpec /*&*/ L$SS = SS;
      DeclarationName L$Name = Name;
      SourceLocation L$TypoLoc = TypoLoc;
      ArrayRef<Expr /*P*/ > L$Args = Args;
      /*uint*/int L$diagnostic = diagnostic;
      /*uint*/int L$diagnostic_suggest = diagnostic_suggest;
      $c$.clean(Out.$set($this().CorrectTypoDelayed(R.getLookupNameInfo(), R.getLookupKind(), S, $AddrOf(SS), $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Move.INSTANCE, std.move(CCC))), 
          /*FuncArg*//*[=, this, =L$SS(SS), =L$Name(Name), =L$TypoLoc(TypoLoc), =L$Args(Args), =L$diagnostic(diagnostic), =L$diagnostic_suggest(diagnostic_suggest)]*/ (final /*const*/ TypoCorrection /*&*/ TC) -> {
                emitEmptyLookupTypoDiagnostic(TC, /*Deref*/$this(), L$SS, new DeclarationName(L$Name), new SourceLocation(L$TypoLoc), new ArrayRef<Expr /*P*/ >(L$Args), 
                    L$diagnostic, L$diagnostic_suggest);
              }, 
          /*FuncArg*/null, CorrectTypoKind.CTK_ErrorRecovery)));
      if ((Out.$star() != null)) {
        return true;
      }
    } else if ($c$.clean((S != null) && (Corrected.$assignMove(
        $c$.track($this().CorrectTypo(R.getLookupNameInfo(), R.getLookupKind(), S, 
            $AddrOf(SS), $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Move.INSTANCE, std.move(CCC))), CorrectTypoKind.CTK_ErrorRecovery))
    )).$bool())) {
      std.string CorrectedStr/*J*/= Corrected.getAsString($this().getLangOpts());
      boolean DroppedSpecifier = Corrected.WillReplaceSpecifier() && $eq_str$C(Name.getAsString(), CorrectedStr);
      R.setLookupName(Corrected.getCorrection());
      
      boolean AcceptableWithRecovery = false;
      boolean AcceptableWithoutRecovery = false;
      NamedDecl /*P*/ ND = Corrected.getFoundDecl();
      if ((ND != null)) {
        if (Corrected.isOverloaded()) {
          OverloadCandidateSet OCS = null;
          try {
            OCS/*J*/= new OverloadCandidateSet(R.getNameLoc(), 
                OverloadCandidateSet.CandidateSetKind.CSK_Normal);
            type$ptr<OverloadCandidate> Best = create_type$ptr();
            for (NamedDecl /*P*/ CD : Corrected) {
              {
                FunctionTemplateDecl /*P*/ FTD = dyn_cast_FunctionTemplateDecl(CD);
                if ((FTD != null)) {
                  $this().AddTemplateOverloadCandidate(FTD, DeclAccessPair.make(FTD, AccessSpecifier.AS_none), ExplicitTemplateArgs, 
                      new ArrayRef<Expr /*P*/ >(Args), OCS);
                } else {
                  FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(CD);
                  if ((FD != null)) {
                    if (!(ExplicitTemplateArgs != null) || ExplicitTemplateArgs.size() == 0) {
                      $this().AddOverloadCandidate(FD, DeclAccessPair.make(FD, AccessSpecifier.AS_none), 
                          new ArrayRef<Expr /*P*/ >(Args), OCS);
                    }
                  }
                }
              }
            }
            switch (OCS.BestViableFunction(/*Deref*/$this(), R.getNameLoc(), Best)) {
             case OR_Success:
              ND = Best./*->*/$star().FoundDecl.$NamedDecl$P();
              Corrected.setCorrectionDecl(ND);
              break;
             default:
              // FIXME: Arbitrarily pick the first declaration for the note.
              Corrected.setCorrectionDecl(ND);
              break;
            }
          } finally {
            if (OCS != null) { OCS.$destroy(); }
          }
        }
        R.addDecl(ND);
        if ($this().getLangOpts().CPlusPlus && ND.isCXXClassMember()) {
          CXXRecordDecl /*P*/ Record = null;
          if ((Corrected.getCorrectionSpecifier() != null)) {
            /*const*/ Type /*P*/ Ty = Corrected.getCorrectionSpecifier().getAsType();
            Record = Ty.getAsCXXRecordDecl();
          }
          if (!(Record != null)) {
            Record = cast_CXXRecordDecl(ND.getDeclContext().getRedeclContext());
          }
          R.setNamingClass(Record);
        }
        
        NamedDecl /*P*/ UnderlyingND = ND.getUnderlyingDecl();
        AcceptableWithRecovery = isa_ValueDecl(UnderlyingND)
           || isa_FunctionTemplateDecl(UnderlyingND);
        // FIXME: If we ended up with a typo for a type name or
        // Objective-C class name, we're in trouble because the parser
        // is in the wrong place to recover. Suggest the typo
        // correction, but don't make it a fix-it since we're not going
        // to recover well anyway.
        AcceptableWithoutRecovery
           = isa_TypeDecl(UnderlyingND) || isa_ObjCInterfaceDecl(UnderlyingND);
      } else {
        // FIXME: We found a keyword. Suggest it, but don't provide a fix-it
        // because we aren't able to recover.
        AcceptableWithoutRecovery = true;
      }
      if (AcceptableWithRecovery || AcceptableWithoutRecovery) {
        /*uint*/int NoteID = (Corrected.getCorrectionDeclAs(ImplicitParamDecl.class) != null) ? diag.note_implicit_param_decl : diag.note_previous_decl;
        if (SS.isEmpty()) {
          $this().diagnoseTypo(Corrected, $out_PartialDiagnostic$C_DeclarationName($c$.track($this().PDiag(diagnostic_suggest)), /*NO_COPY*/Name), 
              $c$.track($this().PDiag(NoteID)), AcceptableWithRecovery); $c$.clean();
        } else {
          $this().diagnoseTypo(Corrected, $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_int($out$Same2DeclContext($out_PartialDiagnostic$C_DeclarationName($c$.track($this().PDiag(diag.err_no_member_suggest)), 
                              /*NO_COPY*/Name), $this().computeDeclContext(SS, false)), 
                      (DroppedSpecifier ? 1 : 0)), SS.getRange()), 
              $c$.track($this().PDiag(NoteID)), AcceptableWithRecovery); $c$.clean();
        }
        
        // Tell the callee whether to try to recover.
        return !AcceptableWithRecovery;
      }
    }
    R.clear();
    
    // Emit a special diagnostic for failed member lookups.
    // FIXME: computing the declaration context might fail here (?)
    if (!SS.isEmpty()) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(R.getNameLoc(), diag.err_no_member)), 
                  Name), $this().computeDeclContext(SS, false)), 
          SS.getRange()));
      return true;
    }
    
    // Give up, we can't recover.
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(R.getNameLoc(), diagnostic)), Name));
    return true;
  } finally {
    if (Corrected != null) { Corrected.$destroy(); }
    $c$.$destroy();
  }
}


/// LookupInObjCMethod - The parser has read a name in, and Sema has
/// detected that we're currently inside an ObjC method.  Perform some
/// additional lookup.
///
/// Ideally, most of this would be done by lookup, but there's
/// actually quite a lot of extra work involved.
///
/// Returns a null sentinel to indicate trivial success.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupInObjCMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 2428,
 FQN="clang::Sema::LookupInObjCMethod", NM="_ZN5clang4Sema18LookupInObjCMethodERNS_12LookupResultEPNS_5ScopeEPNS_14IdentifierInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema18LookupInObjCMethodERNS_12LookupResultEPNS_5ScopeEPNS_14IdentifierInfoEb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > LookupInObjCMethod(final LookupResult /*&*/ Lookup, Scope /*P*/ S, 
                  IdentifierInfo /*P*/ II) {
  return LookupInObjCMethod(Lookup, S, 
                  II, false);
}
public final ActionResultTTrue<Expr /*P*/ > LookupInObjCMethod(final LookupResult /*&*/ Lookup, Scope /*P*/ S, 
                  IdentifierInfo /*P*/ II, boolean AllowBuiltinCreation/*= false*/) {
  SourceLocation Loc = Lookup.getNameLoc();
  ObjCMethodDecl /*P*/ CurMethod = $this().getCurMethodDecl();
  
  // Check for error condition which is already reported.
  if (!(CurMethod != null)) {
    return ExprError();
  }
  
  // There are two cases to handle here.  1) scoped lookup could have failed,
  // in which case we should look for an ivar.  2) scoped lookup could have
  // found a decl, but that decl is outside the current instance method (i.e.
  // a global variable).  In these two cases, we do a lookup for an ivar with
  // this name, if the lookup sucedes, we replace it our current decl.
  
  // If we're in a class method, we don't normally want to look for
  // ivars.  But if we don't find anything else, and there's an
  // ivar, that's an error.
  boolean IsClassMethod = CurMethod.isClassMethod();
  
  boolean LookForIvars;
  if (Lookup.empty()) {
    LookForIvars = true;
  } else if (IsClassMethod) {
    LookForIvars = false;
  } else {
    LookForIvars = (Lookup.isSingleResult()
       && Lookup.getFoundDecl().isDefinedOutsideFunctionOrMethod());
  }
  ObjCInterfaceDecl /*P*/ IFace = null;
  if (LookForIvars) {
    IFace = CurMethod.getClassInterface();
    type$ref<ObjCInterfaceDecl /*P*/ > ClassDeclared = create_type$ref();
    ObjCIvarDecl /*P*/ IV = null;
    if ((IFace != null) && ((IV = IFace.lookupInstanceVariable(II, ClassDeclared)) != null)) {
      CXXScopeSpec SelfScopeSpec = null;
      try {
        // Diagnose using an ivar in a class method.
        if (IsClassMethod) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.error_ivar_use_in_class_method)), 
                    IV.getDeclName())));
          } finally {
            $c$.$destroy();
          }
        }
        
        // If we're referencing an invalid decl, just return this as a silent
        // error node.  The error diagnostic was already emitted on the decl.
        if (IV.isInvalidDecl()) {
          return ExprError();
        }
        
        // Check if referencing a field with __attribute__((deprecated)).
        if ($this().DiagnoseUseOfDecl(IV, new SourceLocation(Loc))) {
          return ExprError();
        }
        
        // Diagnose the use of an ivar outside of the declaring class.
        if (IV.getAccessControl() == ObjCIvarDecl.AccessControl.Private
           && !declaresSameEntity(ClassDeclared.$deref(), IFace)
           && !$this().getLangOpts().DebuggerSupport) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.error_private_ivar_access)), IV.getDeclName()));
          } finally {
            $c$.$destroy();
          }
        }
        
        // FIXME: This should use a new expr for a direct reference, don't
        // turn this into Self->ivar, just return a BareIVarExpr or something.
        final IdentifierInfo /*&*/ II$1 = $this().Context.Idents.get(new StringRef(/*KEEP_STR*/"self"));
        UnqualifiedId SelfName/*J*/= new UnqualifiedId();
        SelfName.setIdentifier($AddrOf(II$1), new SourceLocation());
        SelfName.setKind(UnqualifiedId.IdKind.IK_ImplicitSelfParam);
        SelfScopeSpec/*J*/= new CXXScopeSpec();
        SourceLocation TemplateKWLoc/*J*/= new SourceLocation();
        ActionResultTTrue<Expr /*P*/ > SelfExpr = $this().ActOnIdExpression(S, SelfScopeSpec, new SourceLocation(TemplateKWLoc), 
            SelfName, false, false);
        if (SelfExpr.isInvalid()) {
          return ExprError();
        }
        
        SelfExpr.$assignMove($this().DefaultLvalueConversion(SelfExpr.get()));
        if (SelfExpr.isInvalid()) {
          return ExprError();
        }
        
        $this().MarkAnyDeclReferenced(new SourceLocation(Loc), IV, true);
        
        ObjCMethodFamily MF = CurMethod.getMethodFamily();
        if (MF != ObjCMethodFamily.OMF_init && MF != ObjCMethodFamily.OMF_dealloc && MF != ObjCMethodFamily.OMF_finalize
           && !$this().IvarBacksCurrentMethodAccessor(IFace, CurMethod, IV)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_direct_ivar_access)), IV.getDeclName()));
          } finally {
            $c$.$destroy();
          }
        }
        
        final ObjCIvarDecl /*P*/ L$IV = IV;
        ObjCIvarRefExpr /*P*/ Result = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
                return new ObjCIvarRefExpr(L$IV, L$IV.getUsageType(SelfExpr.get().getType()), new SourceLocation(Loc), 
            L$IV.getLocation(), SelfExpr.get(), true, true);
        });
        if ($this().getLangOpts().ObjCAutoRefCount) {
          if (IV.getType().getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Weak) {
            if (!$this().Diags.isIgnored(diag.warn_arc_repeated_use_of_weak, /*NO_COPY*/Loc)) {
              $this().recordUseOfEvaluatedWeak(Result);
            }
          }
          if ($this().CurContext.isClosure()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_implicitly_retains_self)), 
                  FixItHint.CreateInsertion(/*NO_COPY*/Loc, new StringRef(/*KEEP_STR*/"self->"))));
            } finally {
              $c$.$destroy();
            }
          }
        }
        
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Result);
      } finally {
        if (SelfScopeSpec != null) { SelfScopeSpec.$destroy(); }
      }
    }
  } else if (CurMethod.isInstanceMethod()) {
    {
      // We should warn if a local variable hides an ivar.
      ObjCInterfaceDecl /*P*/ IFace$1 = CurMethod.getClassInterface();
      if ((IFace$1 != null)) {
        type$ref<ObjCInterfaceDecl /*P*/ > ClassDeclared = create_type$ref();
        {
          ObjCIvarDecl /*P*/ IV = IFace$1.lookupInstanceVariable(II, ClassDeclared);
          if ((IV != null)) {
            if (IV.getAccessControl() != ObjCIvarDecl.AccessControl.Private
               || declaresSameEntity(IFace$1, ClassDeclared.$deref())) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_ivar_use_hidden)), IV.getDeclName()));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      }
    }
  } else if (Lookup.isSingleResult()
     && Lookup.getFoundDecl().isDefinedOutsideFunctionOrMethod()) {
    {
      // If accessing a stand-alone ivar in a class method, this is an error.
      /*const*/ ObjCIvarDecl /*P*/ IV = dyn_cast_ObjCIvarDecl(Lookup.getFoundDecl());
      if ((IV != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.error_ivar_use_in_class_method)), 
                  IV.getDeclName())));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  if (Lookup.empty() && (II != null) && AllowBuiltinCreation) {
    {
      // FIXME. Consolidate this with similar code in LookupName.
      /*uint*/int BuiltinID = II.getBuiltinID();
      if ((BuiltinID != 0)) {
        if (!($this().getLangOpts().CPlusPlus
           && $this().Context.BuiltinInfo.isPredefinedLibFunction(BuiltinID))) {
          NamedDecl /*P*/ D = $this().LazilyCreateBuiltin((IdentifierInfo /*P*/ )II, BuiltinID, 
              S, Lookup.isForRedeclaration(), 
              Lookup.getNameLoc());
          if ((D != null)) {
            Lookup.addDecl(D);
          }
        }
      }
    }
  }
  // Sentinel value saying that we didn't do anything special.
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, (Expr /*P*/ )(Expr /*P*/ )null);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildDeclRefExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 1723,
 FQN="clang::Sema::BuildDeclRefExpr", NM="_ZN5clang4Sema16BuildDeclRefExprEPNS_9ValueDeclENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationEPKNS_12CXXScopeSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema16BuildDeclRefExprEPNS_9ValueDeclENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationEPKNS_12CXXScopeSpecE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildDeclRefExpr(ValueDecl /*P*/ D, QualType Ty, ExprValueKind VK, 
                SourceLocation Loc) {
  return BuildDeclRefExpr(D, Ty, VK, 
                Loc, 
                (/*const*/ CXXScopeSpec /*P*/ )null);
}
public final ActionResultTTrue<Expr /*P*/ > BuildDeclRefExpr(ValueDecl /*P*/ D, QualType Ty, ExprValueKind VK, 
                SourceLocation Loc, 
                /*const*/ CXXScopeSpec /*P*/ SS/*= null*/) {
  DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo(D.getDeclName(), new SourceLocation(Loc));
  return $this().BuildDeclRefExpr(D, new QualType(Ty), VK, NameInfo, SS);
}


/// BuildDeclRefExpr - Build an expression that references a
/// declaration that does not require a closure capture.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildDeclRefExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 1733,
 FQN="clang::Sema::BuildDeclRefExpr", NM="_ZN5clang4Sema16BuildDeclRefExprEPNS_9ValueDeclENS_8QualTypeENS_13ExprValueKindERKNS_19DeclarationNameInfoEPKNS_12CXXScopeSpecEPNS_9NamedDeclEPKNS_24TemplateArgumentListInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema16BuildDeclRefExprEPNS_9ValueDeclENS_8QualTypeENS_13ExprValueKindERKNS_19DeclarationNameInfoEPKNS_12CXXScopeSpecEPNS_9NamedDeclEPKNS_24TemplateArgumentListInfoE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildDeclRefExpr(ValueDecl /*P*/ D, QualType Ty, ExprValueKind VK, 
                final /*const*/ DeclarationNameInfo /*&*/ NameInfo) {
  return BuildDeclRefExpr(D, Ty, VK, 
                NameInfo, 
                (/*const*/ CXXScopeSpec /*P*/ )null, (NamedDecl /*P*/ )null, 
                (/*const*/ TemplateArgumentListInfo /*P*/ )null);
}
public final ActionResultTTrue<Expr /*P*/ > BuildDeclRefExpr(ValueDecl /*P*/ D, QualType Ty, ExprValueKind VK, 
                final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
                /*const*/ CXXScopeSpec /*P*/ SS/*= null*/) {
  return BuildDeclRefExpr(D, Ty, VK, 
                NameInfo, 
                SS, (NamedDecl /*P*/ )null, 
                (/*const*/ TemplateArgumentListInfo /*P*/ )null);
}
public final ActionResultTTrue<Expr /*P*/ > BuildDeclRefExpr(ValueDecl /*P*/ D, QualType Ty, ExprValueKind VK, 
                final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
                /*const*/ CXXScopeSpec /*P*/ SS/*= null*/, NamedDecl /*P*/ FoundD/*= null*/) {
  return BuildDeclRefExpr(D, Ty, VK, 
                NameInfo, 
                SS, FoundD, 
                (/*const*/ TemplateArgumentListInfo /*P*/ )null);
}
public final ActionResultTTrue<Expr /*P*/ > BuildDeclRefExpr(ValueDecl /*P*/ D, QualType Ty, ExprValueKind VK, 
                final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
                /*const*/ CXXScopeSpec /*P*/ SS/*= null*/, NamedDecl /*P*/ FoundD/*= null*/, 
                /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs/*= null*/) {
  if ($this().getLangOpts().CUDA) {
    {
      /*const*/ FunctionDecl /*P*/ Caller = dyn_cast_FunctionDecl($this().CurContext);
      if ((Caller != null)) {
        {
          /*const*/ FunctionDecl /*P*/ Callee = dyn_cast_FunctionDecl(D);
          if ((Callee != null)) {
            if ($this().CheckCUDATarget(Caller, Callee)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NameInfo.getLoc(), diag.err_ref_bad_target)), 
                            $this().IdentifyCUDATarget(Callee)), D.getIdentifier()), 
                    $this().IdentifyCUDATarget(Caller)));
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), diag.note_previous_decl)), 
                    D.getIdentifier()));
                return ExprError();
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      }
    }
  }
  
  boolean RefersToCapturedVariable = isa_VarDecl(D)
     && $this().NeedToCaptureVariable(cast_VarDecl(D), NameInfo.getLoc());
  
  DeclRefExpr /*P*/ E;
  if (isa_VarTemplateSpecializationDecl(D)) {
    VarTemplateSpecializationDecl /*P*/ VarSpec = cast_VarTemplateSpecializationDecl(D);
    
    E = DeclRefExpr.Create($this().Context, (SS != null) ? SS.getWithLocInContext($this().Context) : new NestedNameSpecifierLoc(), 
        VarSpec.getTemplateKeywordLoc(), D, 
        RefersToCapturedVariable, NameInfo.getLoc(), new QualType(Ty), VK, 
        FoundD, TemplateArgs);
  } else {
    assert (!(TemplateArgs != null)) : "No template arguments for non-variable template specialization references";
    E = DeclRefExpr.Create($this().Context, (SS != null) ? SS.getWithLocInContext($this().Context) : new NestedNameSpecifierLoc(), 
        new SourceLocation(), D, RefersToCapturedVariable, 
        NameInfo, new QualType(Ty), VK, FoundD);
  }
  
  $this().MarkDeclRefReferenced(E);
  if ($this().getLangOpts().ObjCWeak && isa_VarDecl(D)
     && Ty.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Weak
     && !$this().Diags.isIgnored(diag.warn_arc_repeated_use_of_weak, E.getLocStart())) {
    $this().recordUseOfEvaluatedWeak(E);
  }
  {
    
    FieldDecl /*P*/ FD = dyn_cast_FieldDecl(D);
    if ((FD != null)) {
      $this().UnusedPrivateFields.remove(FD);
      // Just in case we're building an illegal pointer-to-member.
      if (FD.isBitField()) {
        E.setObjectKind(ExprObjectKind.OK_BitField);
      }
    }
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::UseArgumentDependentLookup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 2723,
 FQN="clang::Sema::UseArgumentDependentLookup", NM="_ZN5clang4Sema26UseArgumentDependentLookupERKNS_12CXXScopeSpecERKNS_12LookupResultEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema26UseArgumentDependentLookupERKNS_12CXXScopeSpecERKNS_12LookupResultEb")
//</editor-fold>
public final boolean UseArgumentDependentLookup(final /*const*/ CXXScopeSpec /*&*/ SS, 
                          final /*const*/ LookupResult /*&*/ R, 
                          boolean HasTrailingLParen) {
  // Only when used directly as the postfix-expression of a call.
  if (!HasTrailingLParen) {
    return false;
  }
  
  // Never if a scope specifier was provided.
  if (SS.isSet()) {
    return false;
  }
  
  // Only in C++ or ObjC++.
  if (!$this().getLangOpts().CPlusPlus) {
    return false;
  }
  
  // Turn off ADL when we find certain kinds of declarations during
  // normal lookup:
  for (NamedDecl /*P*/ D : R) {
    // C++0x [basic.lookup.argdep]p3:
    //     -- a declaration of a class member
    // Since using decls preserve this property, we check this on the
    // original decl.
    if (D.isCXXClassMember()) {
      return false;
    }
    
    // C++0x [basic.lookup.argdep]p3:
    //     -- a block-scope function declaration that is not a
    //        using-declaration
    // NOTE: we also trigger this for function templates (in fact, we
    // don't check the decl type at all, since all other decl types
    // turn off ADL anyway).
    if (isa_UsingShadowDecl(D)) {
      D = cast_UsingShadowDecl(D).getTargetDecl();
    } else if (D.getLexicalDeclContext().isFunctionOrMethod()) {
      return false;
    }
    
    // C++0x [basic.lookup.argdep]p3:
    //     -- a declaration that is neither a function or a function
    //        template
    // And also for builtin functions.
    if (isa_FunctionDecl(D)) {
      FunctionDecl /*P*/ FDecl = cast_FunctionDecl(D);
      
      // But also builtin functions.
      if ((FDecl.getBuiltinID() != 0) && FDecl.isImplicit()) {
        return false;
      }
    } else if (!isa_FunctionTemplateDecl(D)) {
      return false;
    }
  }
  
  return true;
}


/// BuildQualifiedDeclarationNameExpr - Build a C++ qualified
/// declaration name, generally during template instantiation.
/// There's a large number of things which don't need to be done along
/// this path.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildQualifiedDeclarationNameExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 2346,
 FQN="clang::Sema::BuildQualifiedDeclarationNameExpr", NM="_ZN5clang4Sema33BuildQualifiedDeclarationNameExprERNS_12CXXScopeSpecERKNS_19DeclarationNameInfoEbPKNS_5ScopeEPPNS_14TypeSourceInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema33BuildQualifiedDeclarationNameExprERNS_12CXXScopeSpecERKNS_19DeclarationNameInfoEbPKNS_5ScopeEPPNS_14TypeSourceInfoE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildQualifiedDeclarationNameExpr(final CXXScopeSpec /*&*/ SS, final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
                                 boolean IsAddressOfOperand, /*const*/ Scope /*P*/ S) {
  return BuildQualifiedDeclarationNameExpr(SS, NameInfo, 
                                 IsAddressOfOperand, S, (type$ptr<TypeSourceInfo /*P*/ /*P*/>)null);
}
public final ActionResultTTrue<Expr /*P*/ > BuildQualifiedDeclarationNameExpr(final CXXScopeSpec /*&*/ SS, final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
                                 boolean IsAddressOfOperand, /*const*/ Scope /*P*/ S, type$ptr<TypeSourceInfo /*P*/ /*P*/> RecoveryTSI/*= null*/) {
  LookupResult R = null;
  try {
    DeclContext /*P*/ DC = $this().computeDeclContext(SS, false);
    if (!(DC != null)) {
      return $this().BuildDependentDeclRefExpr(SS, /*TemplateKWLoc=*/ new SourceLocation(), 
          NameInfo, /*TemplateArgs=*/ (/*const*/ TemplateArgumentListInfo /*P*/ )null);
    }
    if ($this().RequireCompleteDeclContext(SS, DC)) {
      return ExprError();
    }
    
    R/*J*/= new LookupResult(/*Deref*/$this(), NameInfo, LookupNameKind.LookupOrdinaryName);
    $this().LookupQualifiedName(R, DC);
    if (R.isAmbiguous()) {
      return ExprError();
    }
    if (R.getResultKind() == LookupResult.LookupResultKind.NotFoundInCurrentInstantiation) {
      return $this().BuildDependentDeclRefExpr(SS, /*TemplateKWLoc=*/ new SourceLocation(), 
          NameInfo, /*TemplateArgs=*/ (/*const*/ TemplateArgumentListInfo /*P*/ )null);
    }
    if (R.empty()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NameInfo.getLoc(), diag.err_no_member)), 
                    NameInfo.getName()), DC), SS.getRange()));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    {
      
      /*const*/ TypeDecl /*P*/ TD = R.<TypeDecl>getAsSingle(TypeDecl.class);
      if ((TD != null)) {
        SemaDiagnosticBuilder D = null;
        TypeLocBuilder TLB = null;
        try {
          // Diagnose a missing typename if this resolved unambiguously to a type in
          // a dependent context.  If we can recover with a type, downgrade this to
          // a warning in Microsoft compatibility mode.
          /*uint*/int DiagID = diag.err_typename_missing;
          if (Native.$bool(RecoveryTSI) && $this().getLangOpts().MSVCCompat) {
            DiagID = diag.ext_typename_missing;
          }
          SourceLocation Loc = SS.getBeginLoc();
          D = $this().Diag(new SourceLocation(Loc), DiagID);
          $out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_NestedNameSpec(D, SS.getScopeRep()), NameInfo.getName().getAsString()), 
              new SourceRange(/*NO_COPY*/Loc, NameInfo.getEndLoc()));
          
          // Don't recover if the caller isn't expecting us to or if we're in a SFINAE
          // context.
          if (!Native.$bool(RecoveryTSI)) {
            return ExprError();
          }
          
          // Only issue the fixit if we're prepared to recover.
          $out_SemaDiagnosticBuilder$C_T$C$R(D, FixItHint.CreateInsertion(/*NO_COPY*/Loc, new StringRef(/*KEEP_STR*/"typename ")));
          
          // Recover by pretending this was an elaborated type.
          QualType Ty = $this().Context.getTypeDeclType(TD);
          TLB/*J*/= new TypeLocBuilder();
          TLB.pushTypeSpec(new QualType(Ty)).setNameLoc(NameInfo.getLoc());
          
          QualType ET = $this().getElaboratedType(ElaboratedTypeKeyword.ETK_None, SS, new QualType(Ty));
          ElaboratedTypeLoc QTL = TLB.push(ElaboratedTypeLoc.class, new QualType(ET));
          QTL.setElaboratedKeywordLoc(new SourceLocation());
          QTL.setQualifierLoc(SS.getWithLocInContext($this().Context));
          
          RecoveryTSI.$set(TLB.getTypeSourceInfo($this().Context, new QualType(ET)));
          
          return ExprEmpty();
        } finally {
          if (TLB != null) { TLB.$destroy(); }
          if (D != null) { D.$destroy(); }
        }
      }
    }
    
    // Defend against this resolving to an implicit member access. We usually
    // won't get here if this might be a legitimate a class member (we end up in
    // BuildMemberReferenceExpr instead), but this can be valid if we're forming
    // a pointer-to-member or in an unevaluated context in C++11.
    if (!R.empty() && (R.begin().$star()).isCXXClassMember() && !IsAddressOfOperand) {
      return $this().BuildPossibleImplicitMemberExpr(SS, 
          /*TemplateKWLoc=*/ new SourceLocation(), 
          R, /*TemplateArgs=*/ (/*const*/ TemplateArgumentListInfo /*P*/ )null, S);
    }
    
    return $this().BuildDeclarationNameExpr(SS, R, /* ADL */ false);
  } finally {
    if (R != null) { R.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildDeclarationNameExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 2800,
 FQN="clang::Sema::BuildDeclarationNameExpr", NM="_ZN5clang4Sema24BuildDeclarationNameExprERKNS_12CXXScopeSpecERNS_12LookupResultEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema24BuildDeclarationNameExprERKNS_12CXXScopeSpecERNS_12LookupResultEbb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildDeclarationNameExpr(final /*const*/ CXXScopeSpec /*&*/ SS, 
                        final LookupResult /*&*/ R, boolean NeedsADL) {
  return BuildDeclarationNameExpr(SS, 
                        R, NeedsADL, 
                        false);
}
public final ActionResultTTrue<Expr /*P*/ > BuildDeclarationNameExpr(final /*const*/ CXXScopeSpec /*&*/ SS, 
                        final LookupResult /*&*/ R, boolean NeedsADL, 
                        boolean AcceptInvalidDecl/*= false*/) {
  // If this is a single, fully-resolved result and we don't need ADL,
  // just build an ordinary singleton decl ref.
  if (!NeedsADL && R.isSingleResult() && !(R.<FunctionTemplateDecl>getAsSingle(FunctionTemplateDecl.class) != null)) {
    return $this().BuildDeclarationNameExpr(SS, R.getLookupNameInfo(), R.getFoundDecl(), 
        R.getRepresentativeDecl(), (/*const*/ TemplateArgumentListInfo /*P*/ )null, 
        AcceptInvalidDecl);
  }
  
  // We only need to check the declaration if there's exactly one
  // result, because in the overloaded case the results can only be
  // functions and function templates.
  if (R.isSingleResult()
     && CheckDeclInExpr(/*Deref*/$this(), R.getNameLoc(), R.getFoundDecl())) {
    return ExprError();
  }
  
  // Otherwise, just build an unresolved lookup expression.  Suppress
  // any lookup-related diagnostics; we'll hash these out later, when
  // we've picked a target.
  R.suppressDiagnostics();
  
  UnresolvedLookupExpr /*P*/ ULE = UnresolvedLookupExpr.Create($this().Context, R.getNamingClass(), 
      SS.getWithLocInContext($this().Context), 
      R.getLookupNameInfo(), 
      NeedsADL, R.isOverloadedResult(), 
      R.begin(), R.end());
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, ULE);
}


/// \brief Complete semantic analysis for a reference to the given declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildDeclarationNameExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 2833,
 FQN="clang::Sema::BuildDeclarationNameExpr", NM="_ZN5clang4Sema24BuildDeclarationNameExprERKNS_12CXXScopeSpecERKNS_19DeclarationNameInfoEPNS_9NamedDeclES8_PKNS_24TemplateArgumentListInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema24BuildDeclarationNameExprERKNS_12CXXScopeSpecERKNS_19DeclarationNameInfoEPNS_9NamedDeclES8_PKNS_24TemplateArgumentListInfoEb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildDeclarationNameExpr(final /*const*/ CXXScopeSpec /*&*/ SS, final /*const*/ DeclarationNameInfo /*&*/ NameInfo, NamedDecl /*P*/ D) {
  return BuildDeclarationNameExpr(SS, NameInfo, D, 
                        (NamedDecl /*P*/ )null, (/*const*/ TemplateArgumentListInfo /*P*/ )null, 
                        false);
}
public final ActionResultTTrue<Expr /*P*/ > BuildDeclarationNameExpr(final /*const*/ CXXScopeSpec /*&*/ SS, final /*const*/ DeclarationNameInfo /*&*/ NameInfo, NamedDecl /*P*/ D, 
                        NamedDecl /*P*/ FoundD/*= null*/) {
  return BuildDeclarationNameExpr(SS, NameInfo, D, 
                        FoundD, (/*const*/ TemplateArgumentListInfo /*P*/ )null, 
                        false);
}
public final ActionResultTTrue<Expr /*P*/ > BuildDeclarationNameExpr(final /*const*/ CXXScopeSpec /*&*/ SS, final /*const*/ DeclarationNameInfo /*&*/ NameInfo, NamedDecl /*P*/ D, 
                        NamedDecl /*P*/ FoundD/*= null*/, /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs/*= null*/) {
  return BuildDeclarationNameExpr(SS, NameInfo, D, 
                        FoundD, TemplateArgs, 
                        false);
}
public final ActionResultTTrue<Expr /*P*/ > BuildDeclarationNameExpr(final /*const*/ CXXScopeSpec /*&*/ SS, final /*const*/ DeclarationNameInfo /*&*/ NameInfo, NamedDecl /*P*/ D, 
                        NamedDecl /*P*/ FoundD/*= null*/, /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs/*= null*/, 
                        boolean AcceptInvalidDecl/*= false*/) {
  assert ((D != null)) : "Cannot refer to a NULL declaration";
  assert (!isa_FunctionTemplateDecl(D)) : "Cannot refer unambiguously to a function template";
  
  SourceLocation Loc = NameInfo.getLoc();
  if (CheckDeclInExpr(/*Deref*/$this(), new SourceLocation(Loc), D)) {
    return ExprError();
  }
  {
    
    TemplateDecl /*P*/ Template = dyn_cast_TemplateDecl(D);
    if ((Template != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Specifically diagnose references to class templates that are missing
        // a template argument list.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_template_decl_ref)), (isa_VarTemplateDecl(D) ? 1 : 0)), 
                Template), SS.getRange()));
        $c$.clean($c$.track($this().Diag(Template.getLocation(), diag.note_template_decl_here)));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Make sure that we're referring to a value.
  ValueDecl /*P*/ VD = dyn_cast_ValueDecl(D);
  if (!(VD != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_ref_non_value)), 
              D), SS.getRange()));
      $c$.clean($c$.track($this().Diag(D.getLocation(), diag.note_declared_at)));
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  
  // Check whether this declaration can be used. Note that we suppress
  // this check when we're going to perform argument-dependent lookup
  // on this function name, because this might not be the function
  // that overload resolution actually selects.
  if ($this().DiagnoseUseOfDecl(VD, new SourceLocation(Loc))) {
    return ExprError();
  }
  
  // Only create DeclRefExpr's for valid Decl's.
  if (VD.isInvalidDecl() && !AcceptInvalidDecl) {
    return ExprError();
  }
  {
    
    // Handle members of anonymous structs and unions.  If we got here,
    // and the reference is to a class member indirect field, then this
    // must be the subject of a pointer-to-member expression.
    IndirectFieldDecl /*P*/ indirectField = dyn_cast_IndirectFieldDecl(VD);
    if ((indirectField != null)) {
      if (!indirectField.isCXXClassMember()) {
        return $this().BuildAnonymousStructUnionMemberReference(SS, NameInfo.getLoc(), 
            indirectField);
      }
    }
  }
  {
    QualType type = VD.getType();
    ExprValueKind valueKind = ExprValueKind.VK_RValue;
    switch (D.getKind()) {
     case AccessSpec:
     case Block:
     case Captured:
     case ClassScopeFunctionSpecialization:
     case Empty:
     case ExternCContext:
     case FileScopeAsm:
     case Friend:
     case FriendTemplate:
     case Import:
     case LinkageSpec:
     case Label:
     case Namespace:
     case NamespaceAlias:
     case ObjCCompatibleAlias:
     case ObjCCategory:
     case ObjCCategoryImpl:
     case ObjCImplementation:
     case ObjCInterface:
     case ObjCProtocol:
     case ObjCMethod:
     case ObjCProperty:
     case BuiltinTemplate:
     case ClassTemplate:
     case FunctionTemplate:
     case TypeAliasTemplate:
     case VarTemplate:
     case TemplateTemplateParm:
     case Enum:
     case Record:
     case CXXRecord:
     case ClassTemplateSpecialization:
     case ClassTemplatePartialSpecialization:
     case TemplateTypeParm:
     case ObjCTypeParam:
     case TypeAlias:
     case Typedef:
     case UnresolvedUsingTypename:
     case Using:
     case UsingDirective:
     case UsingShadow:
     case ConstructorUsingShadow:
     case OMPThreadPrivate:
     case ObjCPropertyImpl:
     case PragmaComment:
     case PragmaDetectMismatch:
     case StaticAssert:
     case TranslationUnit:
      throw new llvm_unreachable("invalid value decl kind");
     case ObjCAtDefsField:
     case ObjCIvar:
      
      // These shouldn't make it here.
      throw new llvm_unreachable("forming non-member reference to ivar?");
     case EnumConstant:
     case UnresolvedUsingValue:
     case OMPDeclareReduction:
      
      // Enum constants are always r-values and never references.
      // Unresolved using declarations are dependent.
      valueKind = ExprValueKind.VK_RValue;
      break;
     case Field:
     case IndirectField:
      
      // Fields and indirect fields that got here must be for
      // pointer-to-member expressions; we just call them l-values for
      // internal consistency, because this subexpression doesn't really
      // exist in the high-level semantics.
      assert ($this().getLangOpts().CPlusPlus) : "building reference to field in C?";
      
      // These can't have reference type in well-formed programs, but
      // for internal consistency we do this anyway.
      type.$assignMove(type.getNonReferenceType());
      valueKind = ExprValueKind.VK_LValue;
      break;
     case NonTypeTemplateParm:
      {
        {
          /*const*/ ReferenceType /*P*/ reftype = type.$arrow().getAs(ReferenceType.class);
          if ((reftype != null)) {
            type.$assignMove(reftype.getPointeeType());
            valueKind = ExprValueKind.VK_LValue; // even if the parameter is an r-value reference
            break;
          }
        }
        
        // For non-references, we need to strip qualifiers just in case
        // the template parameter was declared as 'const int' or whatever.
        valueKind = ExprValueKind.VK_RValue;
        type.$assignMove(type.getUnqualifiedType());
        break;
      }
     case Var:
     case VarTemplateSpecialization:
     case VarTemplatePartialSpecialization:
     case OMPCapturedExpr:
      // In C, "extern void blah;" is valid and is an r-value.
      if (!$this().getLangOpts().CPlusPlus
         && !type.hasQualifiers()
         && type.$arrow().isVoidType()) {
        valueKind = ExprValueKind.VK_RValue;
        break;
      }
     case ImplicitParam:
     case ParmVar:
      {
        // These are always l-values.
        valueKind = ExprValueKind.VK_LValue;
        type.$assignMove(type.getNonReferenceType());
        
        // FIXME: Does the addition of const really only apply in
        // potentially-evaluated contexts? Since the variable isn't actually
        // captured in an unevaluated context, it seems that the answer is no.
        if (!$this().isUnevaluatedContext()) {
          QualType CapturedType = $this().getCapturedDeclRefType(cast_VarDecl(VD), new SourceLocation(Loc));
          if (!CapturedType.isNull()) {
            type.$assign(CapturedType);
          }
        }
        
        break;
      }
     case Function:
      {
        {
          /*uint*/int BID = cast_FunctionDecl(VD).getBuiltinID();
          if ((BID != 0)) {
            if (!$this().Context.BuiltinInfo.isPredefinedLibFunction(BID)) {
              type.$assignMove($this().Context.BuiltinFnTy.$QualType());
              valueKind = ExprValueKind.VK_RValue;
              break;
            }
          }
        }
        
        /*const*/ FunctionType /*P*/ fty = type.$arrow().castAs(FunctionType.class);
        
        // If we're referring to a function with an __unknown_anytype
        // result type, make the entire expression __unknown_anytype.
        if ($eq_QualType$C(fty.getReturnType(), $this().Context.UnknownAnyTy.$QualType())) {
          type.$assignMove($this().Context.UnknownAnyTy.$QualType());
          valueKind = ExprValueKind.VK_RValue;
          break;
        }
        
        // Functions are l-values in C++.
        if ($this().getLangOpts().CPlusPlus) {
          valueKind = ExprValueKind.VK_LValue;
          break;
        }
        
        // C99 DR 316 says that, if a function type comes from a
        // function definition (without a prototype), that type is only
        // used for checking compatibility. Therefore, when referencing
        // the function, we pretend that we don't have the full function
        // type.
        if (!cast_FunctionDecl(VD).hasPrototype()
           && isa_FunctionProtoType(fty)) {
          type.$assignMove($this().Context.getFunctionNoProtoType(fty.getReturnType(), 
                  fty.getExtInfo()));
        }
        
        // Functions are r-values in C.
        valueKind = ExprValueKind.VK_RValue;
        break;
      }
     case MSProperty:
      valueKind = ExprValueKind.VK_LValue;
      break;
     case CXXMethod:
      {
        // If we're referring to a method with an __unknown_anytype
        // result type, make the entire expression __unknown_anytype.
        // This should only be possible with a type written directly.
        /*const*/ FunctionProtoType /*P*/ proto = dyn_cast_FunctionProtoType(VD.getType());
        if ((proto != null)) {
          if ($eq_QualType$C(proto.getReturnType(), $this().Context.UnknownAnyTy.$QualType())) {
            type.$assignMove($this().Context.UnknownAnyTy.$QualType());
            valueKind = ExprValueKind.VK_RValue;
            break;
          }
        }
      }
      
      // C++ methods are l-values if static, r-values if non-static.
      if (cast_CXXMethodDecl(VD).isStatic()) {
        valueKind = ExprValueKind.VK_LValue;
        break;
      }
     case CXXConversion:
     case CXXDestructor:
     case CXXConstructor:
      // fallthrough
      valueKind = ExprValueKind.VK_RValue;
      break;
    }
    
    return $this().BuildDeclRefExpr(VD, new QualType(type), valueKind, NameInfo, $AddrOf(SS), FoundD, 
        TemplateArgs);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildPredefinedExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 3056,
 FQN="clang::Sema::BuildPredefinedExpr", NM="_ZN5clang4Sema19BuildPredefinedExprENS_14SourceLocationENS_14PredefinedExpr9IdentTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema19BuildPredefinedExprENS_14SourceLocationENS_14PredefinedExpr9IdentTypeE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildPredefinedExpr(SourceLocation Loc, 
                   PredefinedExpr.IdentType IT) {
  // Pick the current block, lambda, captured statement or function.
  Decl /*P*/ currentDecl = null;
  {
    /*const*/ BlockScopeInfo /*P*/ BSI = $this().getCurBlock();
    if ((BSI != null)) {
      currentDecl = BSI.TheDecl;
    } else {
      /*const*/ LambdaScopeInfo /*P*/ LSI = $this().getCurLambda();
      if ((LSI != null)) {
        currentDecl = LSI.CallOperator;
      } else {
        /*const*/ CapturedRegionScopeInfo /*P*/ CSI = $this().getCurCapturedRegion();
        if ((CSI != null)) {
          currentDecl = CSI.TheCapturedDecl;
        } else {
          currentDecl = $this().getCurFunctionOrMethodDecl();
        }
      }
    }
  }
  if (!(currentDecl != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.ext_predef_outside_function)));
      currentDecl = $this().Context.getTranslationUnitDecl();
    } finally {
      $c$.$destroy();
    }
  }
  
  QualType ResTy/*J*/= new QualType();
  StringLiteral /*P*/ SL = null;
  if (cast_DeclContext(currentDecl).isDependentContext()) {
    ResTy.$assignMove($this().Context.DependentTy.$QualType());
  } else {
    // Pre-defined identifiers are of type char[x], where x is the length of
    // the string.
    std.string Str = PredefinedExpr.ComputeName(IT, currentDecl);
    /*uint*/int Length = Str.length();
    
    APInt LengthI/*J*/= new APInt(JD$UInt_ULong.INSTANCE, 32, $uint2ulong(Length + 1));
    if (IT == PredefinedExpr.IdentType.LFunction) {
      ResTy.$assignMove($this().Context.WideCharTy.withConst());
      SmallString/*<32>*/ RawChars/*J*/= new SmallString/*<32>*/(32);
      SemaExprStatics.ConvertUTF8ToWideString($long2uint($this().Context.getTypeSizeInChars(/*NO_COPY*/ResTy).getQuantity()), 
          new StringRef(Str), RawChars);
      ResTy.$assignMove($this().Context.getConstantArrayType(new QualType(ResTy), LengthI, ArrayType.ArraySizeModifier.Normal, 
              /*IndexTypeQuals*/ 0));
      SL = StringLiteral.Create($this().Context, RawChars.$StringRef(), StringLiteral.StringKind.Wide, 
          /*Pascal*/ false, new QualType(ResTy), new SourceLocation(Loc));
    } else {
      ResTy.$assignMove($this().Context.CharTy.withConst());
      ResTy.$assignMove($this().Context.getConstantArrayType(new QualType(ResTy), LengthI, ArrayType.ArraySizeModifier.Normal, 
              /*IndexTypeQuals*/ 0));
      SL = StringLiteral.Create($this().Context, new StringRef(Str), StringLiteral.StringKind.Ascii, 
          /*Pascal*/ false, new QualType(ResTy), new SourceLocation(Loc));
    }
  }
  final StringLiteral /*P*/ L$SL = SL;
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new PredefinedExpr(new SourceLocation(Loc), new QualType(ResTy), IT, L$SL);
       }));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPredefinedExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 3106,
 FQN="clang::Sema::ActOnPredefinedExpr", NM="_ZN5clang4Sema19ActOnPredefinedExprENS_14SourceLocationENS_3tok9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema19ActOnPredefinedExprENS_14SourceLocationENS_3tok9TokenKindE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnPredefinedExpr(SourceLocation Loc, /*tok.TokenKind*/char Kind) {
  PredefinedExpr.IdentType IT;
  switch (Kind) {
   default:
    throw new llvm_unreachable("Unknown simple primary expr!");
   case tok.TokenKind.kw___func__:
    IT = PredefinedExpr.IdentType.Func;
    break; // [C99 6.4.2.2]
   case tok.TokenKind.kw___FUNCTION__:
    IT = PredefinedExpr.IdentType.Function;
    break;
   case tok.TokenKind.kw___FUNCDNAME__:
    IT = PredefinedExpr.IdentType.FuncDName;
    break; // [MS]
   case tok.TokenKind.kw___FUNCSIG__:
    IT = PredefinedExpr.IdentType.FuncSig;
    break; // [MS]
   case tok.TokenKind.kw_L__FUNCTION__:
    IT = PredefinedExpr.IdentType.LFunction;
    break;
   case tok.TokenKind.kw___PRETTY_FUNCTION__:
    IT = PredefinedExpr.IdentType.PrettyFunction;
    break;
  }
  
  return $this().BuildPredefinedExpr(new SourceLocation(Loc), IT);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnIntegerConstant">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 3177,
 FQN="clang::Sema::ActOnIntegerConstant", NM="_ZN5clang4Sema20ActOnIntegerConstantENS_14SourceLocationEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema20ActOnIntegerConstantENS_14SourceLocationEy")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnIntegerConstant(SourceLocation Loc, long/*uint64_t*/ Val) {
  /*uint*/int IntSize = $this().Context.getTargetInfo().getIntWidth();
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, IntegerLiteral.Create($this().Context, new APInt(IntSize, Val), 
          $this().Context.IntTy.$QualType(), new SourceLocation(Loc)));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckLoopHintExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 3215,
 FQN="clang::Sema::CheckLoopHintExpr", NM="_ZN5clang4Sema17CheckLoopHintExprEPNS_4ExprENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema17CheckLoopHintExprEPNS_4ExprENS_14SourceLocationE")
//</editor-fold>
public final boolean CheckLoopHintExpr(Expr /*P*/ E, SourceLocation Loc) {
  assert ((E != null)) : "Invalid expression";
  if (E.isValueDependent()) {
    return false;
  }
  
  QualType QT = E.getType();
  if (!QT.$arrow().isIntegerType() || QT.$arrow().isBooleanType() || QT.$arrow().isCharType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.err_pragma_loop_invalid_argument_type)), QT));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  APSInt ValueAPS/*J*/= new APSInt();
  ActionResultTTrue<Expr /*P*/ > R = $this().VerifyIntegerConstantExpression(E, $AddrOf(ValueAPS));
  if (R.isInvalid()) {
    return true;
  }
  
  boolean ValueIsPositive = ValueAPS.isStrictlyPositive();
  if (!ValueIsPositive || $greater_uint(ValueAPS.getActiveBits(), 31)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.err_pragma_loop_invalid_argument_value)), 
              ValueAPS.__toString(10)), ValueIsPositive));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnNumericConstant">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 3243,
 FQN="clang::Sema::ActOnNumericConstant", NM="_ZN5clang4Sema20ActOnNumericConstantERKNS_5TokenEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema20ActOnNumericConstantERKNS_5TokenEPNS_5ScopeE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnNumericConstant(final /*const*/ Token /*&*/ Tok) {
  return ActOnNumericConstant(Tok, (Scope /*P*/ )null);
}
public final ActionResultTTrue<Expr /*P*/ > ActOnNumericConstant(final /*const*/ Token /*&*/ Tok, Scope /*P*/ UDLScope/*= null*/) {
  NumericLiteralParser Literal = null;
  try {
    // Fast path for a single digit (which is quite common).  A single digit
    // cannot have a trigraph, escaped newline, radix prefix, or suffix.
    if (Tok.getLength() == 1) {
      /*const*//*char*/byte Val = $this().PP.getSpellingOfSingleCharacterNumericConstant(Tok);
      return $this().ActOnIntegerConstant(Tok.getLocation(), $int2ulong($uchar2int(Val) - $uchar2int($$0)));
    }
    
    SmallString/*128*/ SpellingBuffer/*J*/= new SmallString/*128*/(128);
    // NumericLiteralParser wants to overread by one character.  Add padding to
    // the buffer in case the token is copied to the buffer.  If getSpelling()
    // returns a StringRef to the memory buffer, it should have a null char at
    // the EOF, so it is also safe.
    SpellingBuffer.resize(Tok.getLength() + 1);
    
    // Get the spelling of the token, which eliminates trigraphs, etc.
    bool$ptr Invalid = create_bool$ptr(false);
    StringRef TokSpelling = $this().PP.getSpelling(Tok, SpellingBuffer, $AddrOf(Invalid));
    if (Invalid.$star()) {
      return ExprError();
    }
    
    Literal/*J*/= new NumericLiteralParser(/*NO_COPY*/TokSpelling, Tok.getLocation(), $this().PP);
    if (Literal.hadError) {
      return ExprError();
    }
    if (Literal.hasUDSuffix()) {
      LookupResult R = null;
      try {
        // We're building a user-defined literal.
        IdentifierInfo /*P*/ UDSuffix = $AddrOf($this().Context.Idents.get(Literal.$getUDSuffix()));
        SourceLocation UDSuffixLoc = getUDSuffixLoc(/*Deref*/$this(), Tok.getLocation(), Literal.getUDSuffixOffset());
        
        // Make sure we're allowed user-defined literals here.
        if (!(UDLScope != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean(ExprError($c$.track($this().Diag(new SourceLocation(UDSuffixLoc), diag.err_invalid_numeric_udl))));
          } finally {
            $c$.$destroy();
          }
        }
        
        QualType CookedTy/*J*/= new QualType();
        if (Literal.isFloatingLiteral()) {
          // C++11 [lex.ext]p4: If S contains a literal operator with parameter type
          // long double, the literal is treated as a call of the form
          //   operator "" X (f L)
          CookedTy.$assignMove($this().Context.LongDoubleTy.$QualType());
        } else {
          // C++11 [lex.ext]p3: If S contains a literal operator with parameter type
          // unsigned long long, the literal is treated as a call of the form
          //   operator "" X (n ULL)
          CookedTy.$assignMove($this().Context.UnsignedLongLongTy.$QualType());
        }
        
        DeclarationName OpName = $this().Context.DeclarationNames.getCXXLiteralOperatorName(UDSuffix);
        DeclarationNameInfo OpNameInfo/*J*/= new DeclarationNameInfo(new DeclarationName(OpName), new SourceLocation(UDSuffixLoc));
        OpNameInfo.setCXXLiteralOperatorNameLoc(new SourceLocation(UDSuffixLoc));
        
        SourceLocation TokLoc = Tok.getLocation();
        
        // Perform literal operator lookup to determine if we're building a raw
        // literal or a cooked one.
        R/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(OpName), new SourceLocation(UDSuffixLoc), LookupNameKind.LookupOrdinaryName);
        switch ($this().LookupLiteralOperator(UDLScope, R, new ArrayRef<QualType>(CookedTy, false), 
            /*AllowRaw*/ true, /*AllowTemplate*/ true, 
            /*AllowStringTemplate*/ false)) {
         case LOLR_Error:
          return ExprError();
         case LOLR_Cooked:
          {
            Expr /*P*/ Lit;
            if (Literal.isFloatingLiteral()) {
              Lit = BuildFloatingLiteral(/*Deref*/$this(), Literal, new QualType(CookedTy), Tok.getLocation());
            } else {
              APInt ResultVal/*J*/= new APInt($this().Context.getTargetInfo().getLongLongWidth(), 0);
              if (Literal.GetIntegerValue(ResultVal)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Tok.getLocation(), diag.err_integer_literal_too_large)), 
                      /* Unsigned */ 1));
                } finally {
                  $c$.$destroy();
                }
              }
              Lit = IntegerLiteral.Create($this().Context, ResultVal, new QualType(CookedTy), 
                  Tok.getLocation());
            }
            return $this().BuildLiteralOperatorCall(R, OpNameInfo, new ArrayRef<Expr /*P*/ >(Lit, true), new SourceLocation(TokLoc));
          }
         case LOLR_Raw:
          {
            // C++11 [lit.ext]p3, p4: If S contains a raw literal operator, the
            // literal is treated as a call of the form
            //   operator "" X ("n")
            /*uint*/int Length = Literal.getUDSuffixOffset();
            QualType StrTy = $this().Context.getConstantArrayType($this().Context.CharTy.withConst(), new APInt(32, $uint2ulong(Length + 1)), 
                ArrayType.ArraySizeModifier.Normal, 0);
            Expr /*P*/ Lit = StringLiteral.Create($this().Context, new StringRef(TokSpelling.data(), Length), StringLiteral.StringKind.Ascii, 
                /*Pascal*/ false, new QualType(StrTy), create_type$ptr($AddrOf(TokLoc)), 1);
            return $this().BuildLiteralOperatorCall(R, OpNameInfo, new ArrayRef<Expr /*P*/ >(Lit, true), new SourceLocation(TokLoc));
          }
         case LOLR_Template:
          {
            TemplateArgumentListInfo ExplicitArgs = null;
            try {
              // C++11 [lit.ext]p3, p4: Otherwise (S contains a literal operator
              // template), L is treated as a call fo the form
              //   operator "" X <'c1', 'c2', ... 'ck'>()
              // where n is the source character sequence c1 c2 ... ck.
              ExplicitArgs/*J*/= new TemplateArgumentListInfo();
              /*uint*/int CharBits = $this().Context.getIntWidth($this().Context.CharTy.$QualType());
              boolean CharIsUnsigned = ((CanProxyType)$this().Context.CharTy.$arrow()).$arrow().isUnsignedIntegerType();
              APSInt Value/*J*/= new APSInt(CharBits, CharIsUnsigned);
              for (/*uint*/int I = 0, N = Literal.getUDSuffixOffset(); I != N; ++I) {
                Value.$assign($char2ulong(TokSpelling.$at(I)));
                TemplateArgument Arg/*J*/= new TemplateArgument($this().Context, Value, $this().Context.CharTy.$QualType());
                TemplateArgumentLocInfo ArgInfo/*J*/= new TemplateArgumentLocInfo();
                ExplicitArgs.addArgument(new TemplateArgumentLoc(Arg, new TemplateArgumentLocInfo(ArgInfo)));
              }
              return $this().BuildLiteralOperatorCall(R, OpNameInfo, new ArrayRef<Expr /*P*/ >(None, true), new SourceLocation(TokLoc), 
                  $AddrOf(ExplicitArgs));
            } finally {
              if (ExplicitArgs != null) { ExplicitArgs.$destroy(); }
            }
          }
         case LOLR_StringTemplate:
          throw new llvm_unreachable("unexpected literal operator lookup result");
        }
      } finally {
        if (R != null) { R.$destroy(); }
      }
    }
    
    Expr /*P*/ Res;
    if (Literal.isFloatingLiteral()) {
      QualType Ty/*J*/= new QualType();
      if (Literal.isHalf) {
        if ($this().getOpenCLOptions().cl_khr_fp16) {
          Ty.$assignMove($this().Context.HalfTy.$QualType());
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(Tok.getLocation(), diag.err_half_const_requires_fp16)));
            return ExprError();
          } finally {
            $c$.$destroy();
          }
        }
      } else if (Literal.isFloat) {
        Ty.$assignMove($this().Context.FloatTy.$QualType());
      } else if (Literal.isLong) {
        Ty.$assignMove($this().Context.LongDoubleTy.$QualType());
      } else if (Literal.isFloat128) {
        Ty.$assignMove($this().Context.Float128Ty.$QualType());
      } else {
        Ty.$assignMove($this().Context.DoubleTy.$QualType());
      }
      
      Res = BuildFloatingLiteral(/*Deref*/$this(), Literal, new QualType(Ty), Tok.getLocation());
      if ($eq_QualType$C(Ty, $this().Context.DoubleTy.$QualType())) {
        if ($this().getLangOpts().SinglePrecisionConstants) {
          Res = $this().ImpCastExprToType(Res, $this().Context.FloatTy.$QualType(), CastKind.CK_FloatingCast).get();
        } else if ($this().getLangOpts().OpenCL
           && !(($greatereq_uint($this().getLangOpts().OpenCLVersion, 120))
           || $this().getOpenCLOptions().cl_khr_fp64)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(Tok.getLocation(), diag.warn_double_const_requires_fp64)));
            Res = $this().ImpCastExprToType(Res, $this().Context.FloatTy.$QualType(), CastKind.CK_FloatingCast).get();
          } finally {
            $c$.$destroy();
          }
        }
      }
    } else if (!Literal.isIntegerLiteral()) {
      return ExprError();
    } else {
      QualType Ty/*J*/= new QualType();
      
      // 'long long' is a C99 or C++11 feature.
      if (!$this().getLangOpts().C99 && Literal.isLongLong) {
        if ($this().getLangOpts().CPlusPlus) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(Tok.getLocation(), 
                $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_longlong : diag.ext_cxx11_longlong)));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(Tok.getLocation(), diag.ext_c99_longlong)));
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      // Get the value in the widest-possible width.
      /*uint*/int MaxWidth = $this().Context.getTargetInfo().getIntMaxTWidth();
      APInt ResultVal/*J*/= new APInt(MaxWidth, 0);
      if (Literal.GetIntegerValue(ResultVal)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // If this value didn't fit into uintmax_t, error and force to ull.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Tok.getLocation(), diag.err_integer_literal_too_large)), 
              /* Unsigned */ 1));
          Ty.$assignMove($this().Context.UnsignedLongLongTy.$QualType());
          assert ($this().Context.getTypeSize(new QualType(Ty)) == $uint2ullong(ResultVal.getBitWidth())) : "long long is not intmax_t?";
        } finally {
          $c$.$destroy();
        }
      } else {
        // If this value fits into a ULL, try to figure out what else it fits into
        // according to the rules of C99 6.4.4.1p5.
        
        // Octal, Hexadecimal, and integers with a U suffix are allowed to
        // be an unsigned int.
        boolean AllowUnsigned = Literal.isUnsigned || Literal.getRadix() != 10;
        
        // Check from smallest to largest, picking the smallest type we can.
        /*uint*/int Width = 0;
        
        // Microsoft specific integer suffixes are explicitly sized.
        if ((Literal.MicrosoftInteger != 0)) {
          if ($uchar2int(Literal.MicrosoftInteger) == 8 && !Literal.isUnsigned) {
            Width = 8;
            Ty.$assignMove($this().Context.CharTy.$QualType());
          } else {
            Width = $uchar2uint(Literal.MicrosoftInteger);
            Ty.$assignMove($this().Context.getIntTypeForBitwidth(Width, 
                    /*Signed=*/ ((!Literal.isUnsigned) ? 1 : 0)));
          }
        }
        if (Ty.isNull() && !Literal.isLong && !Literal.isLongLong) {
          // Are int/unsigned possibilities?
          /*uint*/int IntSize = $this().Context.getTargetInfo().getIntWidth();
          
          // Does it fit in a unsigned int?
          if (ResultVal.isIntN(IntSize)) {
            // Does it fit in a signed int?
            if (!Literal.isUnsigned && ResultVal.$at(IntSize - 1) == false) {
              Ty.$assignMove($this().Context.IntTy.$QualType());
            } else if (AllowUnsigned) {
              Ty.$assignMove($this().Context.UnsignedIntTy.$QualType());
            }
            Width = IntSize;
          }
        }
        
        // Are long/unsigned long possibilities?
        if (Ty.isNull() && !Literal.isLongLong) {
          /*uint*/int LongSize = $this().Context.getTargetInfo().getLongWidth();
          
          // Does it fit in a unsigned long?
          if (ResultVal.isIntN(LongSize)) {
            // Does it fit in a signed long?
            if (!Literal.isUnsigned && ResultVal.$at(LongSize - 1) == false) {
              Ty.$assignMove($this().Context.LongTy.$QualType());
            } else if (AllowUnsigned) {
              Ty.$assignMove($this().Context.UnsignedLongTy.$QualType());
            } else // Check according to the rules of C90 6.1.3.2p5. C++03 [lex.icon]p2
            // is compatible.
            if (!$this().getLangOpts().C99 && !$this().getLangOpts().CPlusPlus11) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                /*const*//*uint*/int LongLongSize = $this().Context.getTargetInfo().getLongLongWidth();
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Tok.getLocation(), 
                        $this().getLangOpts().CPlusPlus ? Literal.isLong ? diag.warn_old_implicitly_unsigned_long_cxx : /*C++98 UB*/ diag.ext_old_implicitly_unsigned_long_cxx : diag.warn_old_implicitly_unsigned_long)), 
                    ($greater_uint(LongLongSize, LongSize) ? /*will have type 'long long'*/ 0 : /*will be ill-formed*/ 1)));
                Ty.$assignMove($this().Context.UnsignedLongTy.$QualType());
              } finally {
                $c$.$destroy();
              }
            }
            Width = LongSize;
          }
        }
        
        // Check long long if needed.
        if (Ty.isNull()) {
          /*uint*/int LongLongSize = $this().Context.getTargetInfo().getLongLongWidth();
          
          // Does it fit in a unsigned long long?
          if (ResultVal.isIntN(LongLongSize)) {
            // Does it fit in a signed long long?
            // To be compatible with MSVC, hex integer literals ending with the
            // LL or i64 suffix are always signed in Microsoft mode.
            if (!Literal.isUnsigned && (ResultVal.$at(LongLongSize - 1) == false
               || ($this().getLangOpts().MicrosoftExt && Literal.isLongLong))) {
              Ty.$assignMove($this().Context.LongLongTy.$QualType());
            } else if (AllowUnsigned) {
              Ty.$assignMove($this().Context.UnsignedLongLongTy.$QualType());
            }
            Width = LongLongSize;
          }
        }
        
        // If we still couldn't decide a type, we probably have something that
        // does not fit in a signed long long, but has no U suffix.
        if (Ty.isNull()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(Tok.getLocation(), diag.ext_integer_literal_too_large_for_signed)));
            Ty.$assignMove($this().Context.UnsignedLongLongTy.$QualType());
            Width = $this().Context.getTargetInfo().getLongLongWidth();
          } finally {
            $c$.$destroy();
          }
        }
        if (ResultVal.getBitWidth() != Width) {
          ResultVal.$assignMove(ResultVal.trunc(Width));
        }
      }
      Res = IntegerLiteral.Create($this().Context, ResultVal, new QualType(Ty), Tok.getLocation());
    }
    
    // If this is an imaginary literal, create the ImaginaryLiteral wrapper.
    if (Literal.isImaginary) {
      final Expr /*P*/ L$Res = Res;
      Res = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new ImaginaryLiteral(L$Res, 
                  $this().Context.getComplexType(L$Res.getType()));
       });
    }
    
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Res);
  } finally {
    if (Literal != null) { Literal.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCharacterConstant">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 3122,
 FQN="clang::Sema::ActOnCharacterConstant", NM="_ZN5clang4Sema22ActOnCharacterConstantERKNS_5TokenEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema22ActOnCharacterConstantERKNS_5TokenEPNS_5ScopeE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnCharacterConstant(final /*const*/ Token /*&*/ Tok) {
  return ActOnCharacterConstant(Tok, (Scope /*P*/ )null);
}
public final ActionResultTTrue<Expr /*P*/ > ActOnCharacterConstant(final /*const*/ Token /*&*/ Tok, Scope /*P*/ UDLScope/*= null*/) {
  CharLiteralParser Literal = null;
  try {
    SmallString/*16*/ CharBuffer/*J*/= new SmallString/*16*/(16);
    bool$ptr Invalid = create_bool$ptr(false);
    StringRef ThisTok = $this().PP.getSpelling(Tok, CharBuffer, $AddrOf(Invalid));
    if (Invalid.$star()) {
      return ExprError();
    }
    
    Literal/*J*/= new CharLiteralParser(ThisTok.begin(), ThisTok.end(), Tok.getLocation(), 
        $this().PP, Tok.getKind());
    if (Literal.hadError()) {
      return ExprError();
    }
    
    QualType Ty/*J*/= new QualType();
    if (Literal.isWide()) {
      Ty.$assignMove($this().Context.WideCharTy.$QualType()); // L'x' -> wchar_t in C and C++.
    } else if (Literal.isUTF16()) {
      Ty.$assignMove($this().Context.Char16Ty.$QualType()); // u'x' -> char16_t in C11 and C++11.
    } else if (Literal.isUTF32()) {
      Ty.$assignMove($this().Context.Char32Ty.$QualType()); // U'x' -> char32_t in C11 and C++11.
    } else if (!$this().getLangOpts().CPlusPlus || Literal.isMultiChar()) {
      Ty.$assignMove($this().Context.IntTy.$QualType()); // 'x' -> int in C, 'wxyz' -> int in C++.
    } else {
      Ty.$assignMove($this().Context.CharTy.$QualType()); // 'x' -> char in C++
    }
    
    CharacterLiteral.CharacterKind Kind = CharacterLiteral.CharacterKind.Ascii;
    if (Literal.isWide()) {
      Kind = CharacterLiteral.CharacterKind.Wide;
    } else if (Literal.isUTF16()) {
      Kind = CharacterLiteral.CharacterKind.UTF16;
    } else if (Literal.isUTF32()) {
      Kind = CharacterLiteral.CharacterKind.UTF32;
    } else if (Literal.isUTF8()) {
      Kind = CharacterLiteral.CharacterKind.UTF8;
    }
    
    final CharacterLiteral.CharacterKind L$Kind = Kind;
    final CharLiteralParser L$Literal = Literal;
    Expr /*P*/ Lit = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
        return new CharacterLiteral($ulong2uint(L$Literal.getValue()), L$Kind, new QualType(Ty), 
                Tok.getLocation());
     });
    if (Literal.getUDSuffix().empty()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Lit);
    }
    
    // We're building a user-defined literal.
    IdentifierInfo /*P*/ UDSuffix = $AddrOf($this().Context.Idents.get(Literal.$getUDSuffix()));
    SourceLocation UDSuffixLoc = getUDSuffixLoc(/*Deref*/$this(), Tok.getLocation(), Literal.getUDSuffixOffset());
    
    // Make sure we're allowed user-defined literals here.
    if (!(UDLScope != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(ExprError($c$.track($this().Diag(new SourceLocation(UDSuffixLoc), diag.err_invalid_character_udl))));
      } finally {
        $c$.$destroy();
      }
    }
    
    // C++11 [lex.ext]p6: The literal L is treated as a call of the form
    //   operator "" X (ch)
    return BuildCookedLiteralOperatorCall(/*Deref*/$this(), UDLScope, UDSuffix, new SourceLocation(UDSuffixLoc), 
        new ArrayRef<Expr /*P*/ >(Lit, true), Tok.getLocation());
  } finally {
    if (Literal != null) { Literal.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnParenExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 3526,
 FQN="clang::Sema::ActOnParenExpr", NM="_ZN5clang4Sema14ActOnParenExprENS_14SourceLocationES1_PNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema14ActOnParenExprENS_14SourceLocationES1_PNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnParenExpr(SourceLocation L, SourceLocation R, Expr /*P*/ E) {
  assert ((E != null)) : "ActOnParenExpr() missing expr";
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new ParenExpr(new SourceLocation(L), new SourceLocation(R), E);
       }));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnParenListExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6107,
 FQN="clang::Sema::ActOnParenListExpr", NM="_ZN5clang4Sema18ActOnParenListExprENS_14SourceLocationES1_N4llvm15MutableArrayRefIPNS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema18ActOnParenListExprENS_14SourceLocationES1_N4llvm15MutableArrayRefIPNS_4ExprEEE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnParenListExpr(SourceLocation L, 
                  SourceLocation R, 
                  MutableArrayRef<Expr /*P*/ > Val) {
  Expr /*P*/ expr = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
      return new ParenListExpr($this().Context, new SourceLocation(L), new ArrayRef<Expr /*P*/ >(Val), new SourceLocation(R));
   });
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, expr);
}


/// ActOnStringLiteral - The specified tokens were lexed as pasted string
/// fragments (e.g. "foo" "bar" L"baz").

/// ActOnStringLiteral - The specified tokens were lexed as pasted string
/// fragments (e.g. "foo" "bar" L"baz").  The result string has to handle string
/// concatenation ([C99 5.1.1.2, translation phase #6]), so it may come from
/// multiple tokens.  However, the common case is that StringToks points to one
/// string.
///
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStringLiteral">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 1603,
 FQN="clang::Sema::ActOnStringLiteral", NM="_ZN5clang4Sema18ActOnStringLiteralEN4llvm8ArrayRefINS_5TokenEEEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema18ActOnStringLiteralEN4llvm8ArrayRefINS_5TokenEEEPNS_5ScopeE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnStringLiteral(ArrayRefToken StringToks) {
  return ActOnStringLiteral(StringToks, (Scope /*P*/ )null);
}
public final ActionResultTTrue<Expr /*P*/ > ActOnStringLiteral(ArrayRefToken StringToks, Scope /*P*/ UDLScope/*= null*/) {
  LookupResult R = null;
  try {
    assert (!StringToks.empty()) : "Must have at least one string!";
    
    StringLiteralParser Literal/*J*/= new StringLiteralParser(new ArrayRefToken(StringToks), $this().PP);
    if (Literal.hadError()) {
      return ExprError();
    }
    
    SmallVector<SourceLocation> StringTokLocs/*J*/= new SmallVector<SourceLocation>(4, new SourceLocation());
    for (final /*const*/ Token /*&*/ Tok : StringToks)  {
      StringTokLocs.push_back(Tok.getLocation());
    }
    
    QualType CharTy = $this().Context.CharTy.$QualType();
    StringLiteral.StringKind Kind = StringLiteral.StringKind.Ascii;
    if (Literal.isWide()) {
      CharTy.$assignMove($this().Context.getWideCharType());
      Kind = StringLiteral.StringKind.Wide;
    } else if (Literal.isUTF8()) {
      Kind = StringLiteral.StringKind.UTF8;
    } else if (Literal.isUTF16()) {
      CharTy.$assignMove($this().Context.Char16Ty.$QualType());
      Kind = StringLiteral.StringKind.UTF16;
    } else if (Literal.isUTF32()) {
      CharTy.$assignMove($this().Context.Char32Ty.$QualType());
      Kind = StringLiteral.StringKind.UTF32;
    } else if (Literal.isPascal()) {
      CharTy.$assignMove($this().Context.UnsignedCharTy.$QualType());
    }
    
    QualType CharTyConst = new QualType(CharTy);
    // A C++ string literal has a const-qualified element type (C++ 2.13.4p1).
    if ($this().getLangOpts().CPlusPlus || $this().getLangOpts().ConstStrings) {
      CharTyConst.addConst();
    }
    
    // Get an array type for the string, according to C99 6.4.5.  This includes
    // the nul terminator character as well as the string length for pascal
    // strings.
    QualType StrTy = $this().Context.getConstantArrayType(new QualType(CharTyConst), 
        new APInt(32, $uint2ulong(Literal.GetNumStringChars() + 1)), 
        ArrayType.ArraySizeModifier.Normal, 0);
    
    // OpenCL v1.1 s6.5.3: a string literal is in the constant address space.
    if ($this().getLangOpts().OpenCL) {
      StrTy.$assignMove($this().Context.getAddrSpaceQualType(new QualType(StrTy), LangAS.ID.opencl_constant));
    }
    
    // Pass &StringTokLocs[0], StringTokLocs.size() to factory!
    StringLiteral /*P*/ Lit = StringLiteral.Create($this().Context, Literal.GetString(), 
        Kind, Literal.Pascal, new QualType(StrTy), 
        $AddrOf(StringTokLocs.ptr$at(0)), 
        StringTokLocs.size());
    if (Literal.getUDSuffix().empty()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Lit);
    }
    
    // We're building a user-defined literal.
    IdentifierInfo /*P*/ UDSuffix = $AddrOf($this().Context.Idents.get(Literal.$getUDSuffix()));
    SourceLocation UDSuffixLoc = getUDSuffixLoc(/*Deref*/$this(), new SourceLocation(StringTokLocs.$at(Literal.getUDSuffixToken())), 
        Literal.getUDSuffixOffset());
    
    // Make sure we're allowed user-defined literals here.
    if (!(UDLScope != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(ExprError($c$.track($this().Diag(new SourceLocation(UDSuffixLoc), diag.err_invalid_string_udl))));
      } finally {
        $c$.$destroy();
      }
    }
    
    // C++11 [lex.ext]p5: The literal L is treated as a call of the form
    //   operator "" X (str, len)
    QualType SizeType = $this().Context.getSizeType().$QualType();
    
    DeclarationName OpName = $this().Context.DeclarationNames.getCXXLiteralOperatorName(UDSuffix);
    DeclarationNameInfo OpNameInfo/*J*/= new DeclarationNameInfo(new DeclarationName(OpName), new SourceLocation(UDSuffixLoc));
    OpNameInfo.setCXXLiteralOperatorNameLoc(new SourceLocation(UDSuffixLoc));
    
    QualType ArgTy[/*2*/] = new QualType [/*2*/] {
      $this().Context.getArrayDecayedType(new QualType(StrTy)), SizeType
    };
    
    R/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(OpName), new SourceLocation(UDSuffixLoc), LookupNameKind.LookupOrdinaryName);
    switch ($this().LookupLiteralOperator(UDLScope, R, new ArrayRef<QualType>(ArgTy, false), 
        /*AllowRaw*/ false, /*AllowTemplate*/ false, 
        /*AllowStringTemplate*/ true)) {
     case LOLR_Cooked:
      {
        APInt Len/*J*/= new APInt($this().Context.getIntWidth(new QualType(SizeType)), $uint2ulong(Literal.GetNumStringChars()));
        IntegerLiteral /*P*/ LenArg = IntegerLiteral.Create($this().Context, Len, new QualType(SizeType), 
            new SourceLocation(StringTokLocs.$at(0)));
        Expr /*P*/ Args[/*2*/] = new Expr /*P*/  [/*2*/] {Lit, LenArg};
        
        return $this().BuildLiteralOperatorCall(R, OpNameInfo, new ArrayRef<Expr /*P*/ >(Args, true), new SourceLocation(StringTokLocs.back()));
      }
     case LOLR_StringTemplate:
      {
        TemplateArgumentListInfo ExplicitArgs = null;
        try {
          ExplicitArgs/*J*/= new TemplateArgumentListInfo();
          
          /*uint*/int CharBits = $this().Context.getIntWidth(new QualType(CharTy));
          boolean CharIsUnsigned = CharTy.$arrow().isUnsignedIntegerType();
          APSInt Value/*J*/= new APSInt(CharBits, CharIsUnsigned);
          
          TemplateArgument TypeArg/*J*/= new TemplateArgument(new QualType(CharTy));
          TemplateArgumentLocInfo TypeArgInfo/*J*/= new TemplateArgumentLocInfo($this().Context.getTrivialTypeSourceInfo(new QualType(CharTy)));
          ExplicitArgs.addArgument(new TemplateArgumentLoc(TypeArg, new TemplateArgumentLocInfo(TypeArgInfo)));
          
          for (/*uint*/int I = 0, N = Lit.getLength(); I != N; ++I) {
            Value.$assign($uint2ulong(Lit.getCodeUnit(I)));
            TemplateArgument Arg/*J*/= new TemplateArgument($this().Context, Value, new QualType(CharTy));
            TemplateArgumentLocInfo ArgInfo/*J*/= new TemplateArgumentLocInfo();
            ExplicitArgs.addArgument(new TemplateArgumentLoc(Arg, new TemplateArgumentLocInfo(ArgInfo)));
          }
          return $this().BuildLiteralOperatorCall(R, OpNameInfo, new ArrayRef<Expr /*P*/ >(None, true), new SourceLocation(StringTokLocs.back()), 
              $AddrOf(ExplicitArgs));
        } finally {
          if (ExplicitArgs != null) { ExplicitArgs.$destroy(); }
        }
      }
     case LOLR_Raw:
     case LOLR_Template:
      throw new llvm_unreachable("unexpected literal operator lookup result");
     case LOLR_Error:
      return ExprError();
    }
    throw new llvm_unreachable("unexpected literal operator lookup result");
  } finally {
    if (R != null) { R.$destroy(); }
  }
}


//===----------------------------------------------------------------------===//
//  Semantic Analysis for various Expression Types
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnGenericSelectionExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 1389,
 FQN="clang::Sema::ActOnGenericSelectionExpr", NM="_ZN5clang4Sema25ActOnGenericSelectionExprENS_14SourceLocationES1_S1_PNS_4ExprEN4llvm8ArrayRefINS_9OpaquePtrINS_8QualTypeEEEEENS5_IS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema25ActOnGenericSelectionExprENS_14SourceLocationES1_S1_PNS_4ExprEN4llvm8ArrayRefINS_9OpaquePtrINS_8QualTypeEEEEENS5_IS3_EE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnGenericSelectionExpr(SourceLocation KeyLoc, 
                         SourceLocation DefaultLoc, 
                         SourceLocation RParenLoc, 
                         Expr /*P*/ ControllingExpr, 
                         ArrayRef<OpaquePtr<QualType>> ArgTypes, 
                         ArrayRef<Expr /*P*/ > ArgExprs) {
  /*uint*/int NumAssocs = ArgTypes.size();
  assert (NumAssocs == ArgExprs.size());
  
  type$ptr<TypeSourceInfo /*P*/ /*P*/> Types = create_const_type$ptr(new TypeSourceInfo /*P*/ [NumAssocs]);
  for (/*uint*/int i = 0; $less_uint(i, NumAssocs); ++i) {
    if (ArgTypes.$at(i).$bool()) {
      /*J:(void)*/GetTypeFromParser(new OpaquePtr<QualType>(ArgTypes.$at(i)), Types.$add(i));
    } else {
      Types.$set(i, null);
    }
  }
  
  ActionResultTTrue<Expr /*P*/ > ER = $this().CreateGenericSelectionExpr(new SourceLocation(KeyLoc), new SourceLocation(DefaultLoc), new SourceLocation(RParenLoc), 
      ControllingExpr, 
      llvm.makeArrayRef(Types, NumAssocs), 
      new ArrayRef<Expr /*P*/ >(ArgExprs));
  /*delete[]*/Destructors.$destroyArray(Types);
  return ER;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CreateGenericSelectionExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 1415,
 FQN="clang::Sema::CreateGenericSelectionExpr", NM="_ZN5clang4Sema26CreateGenericSelectionExprENS_14SourceLocationES1_S1_PNS_4ExprEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEENS5_IS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema26CreateGenericSelectionExprENS_14SourceLocationES1_S1_PNS_4ExprEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEENS5_IS3_EE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CreateGenericSelectionExpr(SourceLocation KeyLoc, 
                          SourceLocation DefaultLoc, 
                          SourceLocation RParenLoc, 
                          Expr /*P*/ ControllingExpr, 
                          ArrayRef<TypeSourceInfo /*P*/ > Types, 
                          ArrayRef<Expr /*P*/ > Exprs) {
  /*uint*/int NumAssocs = Types.size();
  assert (NumAssocs == Exprs.size());
  {
    EnterExpressionEvaluationContext Unevaluated = null;
    try {
      Unevaluated/*J*/= new EnterExpressionEvaluationContext(/*Deref*/$this(), Sema.ExpressionEvaluationContext.Unevaluated);
      ActionResultTTrue<Expr /*P*/ > R = $this().DefaultFunctionArrayLvalueConversion(ControllingExpr);
      if (R.isInvalid()) {
        return ExprError();
      }
      ControllingExpr = R.get();
    } finally {
      if (Unevaluated != null) { Unevaluated.$destroy(); }
    }
  }
  
  // The controlling expression is an unevaluated operand, so side effects are
  // likely unintended.
  if ($this().ActiveTemplateInstantiations.empty()
     && ControllingExpr.HasSideEffects($this().Context, false)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(ControllingExpr.getExprLoc(), 
          diag.warn_side_effects_unevaluated_context)));
    } finally {
      $c$.$destroy();
    }
  }
  
  boolean TypeErrorFound = false;
  boolean IsResultDependent = ControllingExpr.isTypeDependent();
  boolean ContainsUnexpandedParameterPack = ControllingExpr.containsUnexpandedParameterPack();
  
  for (/*uint*/int i = 0; $less_uint(i, NumAssocs); ++i) {
    if (Exprs.$at(i).containsUnexpandedParameterPack()) {
      ContainsUnexpandedParameterPack = true;
    }
    if ((Types.$at(i) != null)) {
      if (Types.$at(i).getType().$arrow().containsUnexpandedParameterPack()) {
        ContainsUnexpandedParameterPack = true;
      }
      if (Types.$at(i).getType().$arrow().isDependentType()) {
        IsResultDependent = true;
      } else {
        // C11 6.5.1.1p2 "The type name in a generic association shall specify a
        // complete object type other than a variably modified type."
        /*uint*/int D = 0;
        if (Types.$at(i).getType().$arrow().isIncompleteType()) {
          D = diag.err_assoc_type_incomplete;
        } else if (!Types.$at(i).getType().$arrow().isObjectType()) {
          D = diag.err_assoc_type_nonobject;
        } else if (Types.$at(i).getType().$arrow().isVariablyModifiedType()) {
          D = diag.err_assoc_type_variably_modified;
        }
        if (D != 0) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Types.$at(i).getTypeLoc().getBeginLoc(), D)), 
                    Types.$at(i).getTypeLoc().getSourceRange()), 
                Types.$at(i).getType()));
            TypeErrorFound = true;
          } finally {
            $c$.$destroy();
          }
        }
        
        // C11 6.5.1.1p2 "No two generic associations in the same generic
        // selection shall specify compatible types."
        for (/*uint*/int j = i + 1; $less_uint(j, NumAssocs); ++j)  {
          if ((Types.$at(j) != null) && !Types.$at(j).getType().$arrow().isDependentType()
             && $this().Context.typesAreCompatible(Types.$at(i).getType(), 
              Types.$at(j).getType())) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Types.$at(j).getTypeLoc().getBeginLoc(), 
                              diag.err_assoc_compatible_types)), 
                          Types.$at(j).getTypeLoc().getSourceRange()), 
                      Types.$at(j).getType()), 
                  Types.$at(i).getType()));
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Types.$at(i).getTypeLoc().getBeginLoc(), 
                          diag.note_compat_assoc)), 
                      Types.$at(i).getTypeLoc().getSourceRange()), 
                  Types.$at(i).getType()));
              TypeErrorFound = true;
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
  }
  if (TypeErrorFound) {
    return ExprError();
  }
  
  // If we determined that the generic selection is result-dependent, don't
  // try to compute the result expression.
  if (IsResultDependent) {
    final Expr /*P*/ L$ControllingExpr = ControllingExpr;
    final boolean L$ContainsUnexpandedParameterPack = ContainsUnexpandedParameterPack;
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
            return new GenericSelectionExpr($this().Context, new SourceLocation(KeyLoc), L$ControllingExpr, new ArrayRef<TypeSourceInfo /*P*/ >(Types), new ArrayRef<Expr /*P*/ >(Exprs), new SourceLocation(DefaultLoc), new SourceLocation(RParenLoc), 
                    L$ContainsUnexpandedParameterPack);
         }));
  }
  
  SmallVectorUInt CompatIndices/*J*/= new SmallVectorUInt(1, 0);
  /*uint*/int DefaultIndex = -1/*U*/;
  for (/*uint*/int i = 0; $less_uint(i, NumAssocs); ++i) {
    if (!(Types.$at(i) != null)) {
      DefaultIndex = i;
    } else if ($this().Context.typesAreCompatible(ControllingExpr.getType(), 
        Types.$at(i).getType())) {
      CompatIndices.push_back(i);
    }
  }
  
  // C11 6.5.1.1p2 "The controlling expression of a generic selection shall have
  // type compatible with at most one of the types named in its generic
  // association list."
  if ($greater_uint(CompatIndices.size(), 1)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // We strip parens here because the controlling expression is typically
      // parenthesized in macro definitions.
      ControllingExpr = ControllingExpr.IgnoreParens();
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ControllingExpr.getLocStart(), diag.err_generic_sel_multi_match)), 
                  ControllingExpr.getSourceRange()), ControllingExpr.getType()), 
          (/*uint*/int)CompatIndices.size()));
      for (/*uint*/int I : CompatIndices) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Types.$at(I).getTypeLoc().getBeginLoc(), 
                    diag.note_compat_assoc)), 
                Types.$at(I).getTypeLoc().getSourceRange()), 
            Types.$at(I).getType()));
      }
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  
  // C11 6.5.1.1p2 "If a generic selection has no default generic association,
  // its controlling expression shall have type compatible with exactly one of
  // the types named in its generic association list."
  if (DefaultIndex == -1/*U*/ && CompatIndices.size() == 0) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // We strip parens here because the controlling expression is typically
      // parenthesized in macro definitions.
      ControllingExpr = ControllingExpr.IgnoreParens();
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ControllingExpr.getLocStart(), diag.err_generic_sel_no_match)), 
              ControllingExpr.getSourceRange()), ControllingExpr.getType()));
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  
  // C11 6.5.1.1p3 "If a generic selection has a generic association with a
  // type name that is compatible with the type of the controlling expression,
  // then the result expression of the generic selection is the expression
  // in that generic association. Otherwise, the result expression of the
  // generic selection is the expression in the default generic association."
  /*uint*/int ResultIndex = (CompatIndices.size() != 0) ? CompatIndices.$at(0) : DefaultIndex;
  
  final Expr /*P*/ L$ControllingExpr = ControllingExpr;
  final boolean L$ContainsUnexpandedParameterPack = ContainsUnexpandedParameterPack;  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new GenericSelectionExpr($this().Context, new SourceLocation(KeyLoc), L$ControllingExpr, new ArrayRef<TypeSourceInfo /*P*/ >(Types), new ArrayRef<Expr /*P*/ >(Exprs), new SourceLocation(DefaultLoc), new SourceLocation(RParenLoc), 
                  L$ContainsUnexpandedParameterPack, ResultIndex);
       }));
}


// Binary/Unary Operators.  'Tok' is the token for the operator.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CreateBuiltinUnaryOp">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11302,
 FQN="clang::Sema::CreateBuiltinUnaryOp", NM="_ZN5clang4Sema20CreateBuiltinUnaryOpENS_14SourceLocationENS_17UnaryOperatorKindEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema20CreateBuiltinUnaryOpENS_14SourceLocationENS_17UnaryOperatorKindEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CreateBuiltinUnaryOp(SourceLocation OpLoc, 
                    UnaryOperatorKind Opc, 
                    Expr /*P*/ InputExpr) {
  ActionResultTTrue<Expr /*P*/ > Input = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, InputExpr);
  type$ref<ExprValueKind> VK = create_type$ref(ExprValueKind.VK_RValue);
  type$ref<ExprObjectKind> OK = create_type$ref(ExprObjectKind.OK_Ordinary);
  QualType resultType/*J*/= new QualType();
  if ($this().getLangOpts().OpenCL) {
    QualType Ty = InputExpr.getType();
    // The only legal unary operation for atomics is '&'.
    if ((Opc != UnaryOperatorKind.UO_AddrOf && Ty.$arrow().isAtomicType())
      // OpenCL special types - image, sampler, pipe, and blocks are to be used
      // only with a builtin functions and therefore should be disallowed here.
       || (Ty.$arrow().isImageType() || Ty.$arrow().isSamplerT() || Ty.$arrow().isPipeType()
       || Ty.$arrow().isBlockPointerType())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_typecheck_unary_expr)), 
                    InputExpr.getType()), 
                Input.get().getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
  }
  switch (Opc) {
   case UO_PreInc:
   case UO_PreDec:
   case UO_PostInc:
   case UO_PostDec:
    resultType.$assignMove(CheckIncrementDecrementOperand(/*Deref*/$this(), Input.get(), VK, OK, 
            new SourceLocation(OpLoc), 
            Opc == UnaryOperatorKind.UO_PreInc
               || Opc == UnaryOperatorKind.UO_PostInc, 
            Opc == UnaryOperatorKind.UO_PreInc
               || Opc == UnaryOperatorKind.UO_PreDec));
    break;
   case UO_AddrOf:
    resultType.$assignMove($this().CheckAddressOfOperand(Input, new SourceLocation(OpLoc)));
    RecordModifiableNonNullParam(/*Deref*/$this(), InputExpr);
    break;
   case UO_Deref:
    {
      Input.$assignMove($this().DefaultFunctionArrayLvalueConversion(Input.get()));
      if (Input.isInvalid()) {
        return ExprError();
      }
      resultType.$assignMove(CheckIndirectionOperand(/*Deref*/$this(), Input.get(), VK, new SourceLocation(OpLoc)));
      break;
    }
   case UO_Plus:
   case UO_Minus:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Input.$assignMove($this().UsualUnaryConversions(Input.get()));
        if (Input.isInvalid()) {
          return ExprError();
        }
        resultType.$assignMove(Input.get().getType());
        if (resultType.$arrow().isDependentType()) {
          break;
        }
        if (resultType.$arrow().isArithmeticType()) { // C99 6.5.3.3p1
          break;
        } else if (resultType.$arrow().isVectorType()
          // The z vector extensions don't allow + or - with bool vectors.
           && (!$this().Context.getLangOpts().ZVector
           || resultType.$arrow().getAs(VectorType.class).getVectorKind()
           != VectorType.VectorKind.AltiVecBool)) {
          break;
        } else if ($this().getLangOpts().CPlusPlus // C++ [expr.unary.op]p6
           && Opc == UnaryOperatorKind.UO_Plus
           && resultType.$arrow().isPointerType()) {
          break;
        }
        
        return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_typecheck_unary_expr)), 
                    resultType), Input.get().getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
   case UO_Not: // bitwise complement
    Input.$assignMove($this().UsualUnaryConversions(Input.get()));
    if (Input.isInvalid()) {
      return ExprError();
    }
    resultType.$assignMove(Input.get().getType());
    if (resultType.$arrow().isDependentType()) {
      break;
    }
    // C99 6.5.3.3p1. We allow complex int and float as a GCC extension.
    if (resultType.$arrow().isComplexType() || resultType.$arrow().isComplexIntegerType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // C99 does not support '~' for complex conjugation.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.ext_integer_complement_complex)), 
                resultType), Input.get().getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    } else if (resultType.$arrow().hasIntegerRepresentation()) {
      break;
    } else if (resultType.$arrow().isExtVectorType()) {
      if ($this().Context.getLangOpts().OpenCL) {
        // OpenCL v1.1 s6.3.f: The bitwise operator not (~) does not operate
        // on vector float types.
        QualType T = resultType.$arrow().getAs(ExtVectorType.class).getElementType();
        if (!T.$arrow().isIntegerType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_typecheck_unary_expr)), 
                        resultType), Input.get().getSourceRange())));
          } finally {
            $c$.$destroy();
          }
        }
      }
      break;
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_typecheck_unary_expr)), 
                    resultType), Input.get().getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
    break;
   case UO_LNot: // logical negation
    // Unlike +/-/~, integer promotions aren't done here (C99 6.5.3.3p5).
    Input.$assignMove($this().DefaultFunctionArrayLvalueConversion(Input.get()));
    if (Input.isInvalid()) {
      return ExprError();
    }
    resultType.$assignMove(Input.get().getType());
    
    // Though we still have to promote half FP to float...
    if (resultType.$arrow().isHalfType() && !$this().Context.getLangOpts().NativeHalfType) {
      Input.$assign($this().ImpCastExprToType(Input.get(), $this().Context.FloatTy.$QualType(), CastKind.CK_FloatingCast).get());
      resultType.$assignMove($this().Context.FloatTy.$QualType());
    }
    if (resultType.$arrow().isDependentType()) {
      break;
    }
    if (resultType.$arrow().isScalarType() && !isScopedEnumerationType(new QualType(resultType))) {
      // C99 6.5.3.3p1: ok, fallthrough;
      if ($this().Context.getLangOpts().CPlusPlus) {
        // C++03 [expr.unary.op]p8, C++0x [expr.unary.op]p9:
        // operand contextually converted to bool.
        Input.$assignMove($this().ImpCastExprToType(Input.get(), $this().Context.BoolTy.$QualType(), 
                ScalarTypeToBooleanCastKind(new QualType(resultType))));
      } else if ($this().Context.getLangOpts().OpenCL
         && $less_uint($this().Context.getLangOpts().OpenCLVersion, 120)) {
        // OpenCL v1.1 6.3.h: The logical operator not (!) does not
        // operate on scalar float types.
        if (!resultType.$arrow().isIntegerType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_typecheck_unary_expr)), 
                        resultType), Input.get().getSourceRange())));
          } finally {
            $c$.$destroy();
          }
        }
      }
    } else if (resultType.$arrow().isExtVectorType()) {
      if ($this().Context.getLangOpts().OpenCL
         && $less_uint($this().Context.getLangOpts().OpenCLVersion, 120)) {
        // OpenCL v1.1 6.3.h: The logical operator not (!) does not
        // operate on vector float types.
        QualType T = resultType.$arrow().getAs(ExtVectorType.class).getElementType();
        if (!T.$arrow().isIntegerType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_typecheck_unary_expr)), 
                        resultType), Input.get().getSourceRange())));
          } finally {
            $c$.$destroy();
          }
        }
      }
      // Vector logical not returns the signed variant of the operand type.
      resultType.$assignMove($this().GetSignedVectorType(new QualType(resultType)));
      break;
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_typecheck_unary_expr)), 
                    resultType), Input.get().getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
    
    // LNot always has type int. C99 6.5.3.3p5.
    // In C++, it's bool. C++ 5.3.1p8
    resultType.$assignMove($this().Context.getLogicalOperationType());
    break;
   case UO_Real:
   case UO_Imag:
    resultType.$assignMove(CheckRealImagOperand(/*Deref*/$this(), Input, new SourceLocation(OpLoc), Opc == UnaryOperatorKind.UO_Real));
    // _Real maps ordinary l-values into ordinary l-values. _Imag maps ordinary
    // complex l-values to ordinary l-values and all other values to r-values.
    if (Input.isInvalid()) {
      return ExprError();
    }
    if (Opc == UnaryOperatorKind.UO_Real || Input.get().getType().$arrow().isAnyComplexType()) {
      if (Input.get().getValueKind() != ExprValueKind.VK_RValue
         && Input.get().getObjectKind() == ExprObjectKind.OK_Ordinary) {
        VK.$set(Input.get().getValueKind());
      }
    } else if (!$this().getLangOpts().CPlusPlus) {
      // In C, a volatile scalar is read by __imag. In C++, it is not.
      Input.$assignMove($this().DefaultLvalueConversion(Input.get()));
    }
    break;
   case UO_Extension:
   case UO_Coawait:
    resultType.$assignMove(Input.get().getType());
    VK.$set(Input.get().getValueKind());
    OK.$set(Input.get().getObjectKind());
    break;
  }
  if (resultType.isNull() || Input.isInvalid()) {
    return ExprError();
  }
  
  // Check for array bounds violations in the operand of the UnaryOperator,
  // except for the '*' and '&' operators that have to be handled specially
  // by CheckArrayAccess (as there are special cases like &array[arraysize]
  // that are explicitly defined as valid by the standard).
  if (Opc != UnaryOperatorKind.UO_AddrOf && Opc != UnaryOperatorKind.UO_Deref) {
    $this().CheckArrayAccess(Input.get());
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ (Expr /*P*/)Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
            return new UnaryOperator(Input.get(), Opc, new QualType(resultType), VK.$deref(), OK.$deref(), new SourceLocation(OpLoc));
        }));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildUnaryOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11524,
 FQN="clang::Sema::BuildUnaryOp", NM="_ZN5clang4Sema12BuildUnaryOpEPNS_5ScopeENS_14SourceLocationENS_17UnaryOperatorKindEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema12BuildUnaryOpEPNS_5ScopeENS_14SourceLocationENS_17UnaryOperatorKindEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildUnaryOp(Scope /*P*/ S, SourceLocation OpLoc, 
            UnaryOperatorKind Opc, Expr /*P*/ Input) {
  {
    // First things first: handle placeholders so that the
    // overloaded-operator check considers the right type.
    /*const*/ BuiltinType /*P*/ pty = Input.getType().$arrow().getAsPlaceholderType();
    if ((pty != null)) {
      // Increment and decrement of pseudo-object references.
      if (pty.getKind() == BuiltinType.Kind.PseudoObject
         && UnaryOperator.isIncrementDecrementOp(Opc)) {
        return $this().checkPseudoObjectIncDec(S, new SourceLocation(OpLoc), Opc, Input);
      }
      
      // extension is always a builtin operator.
      if (Opc == UnaryOperatorKind.UO_Extension) {
        return $this().CreateBuiltinUnaryOp(new SourceLocation(OpLoc), Opc, Input);
      }
      
      // & gets special logic for several kinds of placeholder.
      // The builtin code knows what to do.
      if (Opc == UnaryOperatorKind.UO_AddrOf
         && (pty.getKind() == BuiltinType.Kind.Overload
         || pty.getKind() == BuiltinType.Kind.UnknownAny
         || pty.getKind() == BuiltinType.Kind.BoundMember)) {
        return $this().CreateBuiltinUnaryOp(new SourceLocation(OpLoc), Opc, Input);
      }
      
      // Anything else needs to be handled now.
      ActionResultTTrue<Expr /*P*/ > Result = $this().CheckPlaceholderExpr(Input);
      if (Result.isInvalid()) {
        return ExprError();
      }
      Input = Result.get();
    }
  }
  if ($this().getLangOpts().CPlusPlus && Input.getType().$arrow().isOverloadableType()
     && UnaryOperator.getOverloadedOperator(Opc) != OverloadedOperatorKind.OO_None
     && !(Opc == UnaryOperatorKind.UO_AddrOf && isQualifiedMemberAccess(Input))) {
    // Find all of the overloaded operators visible from this
    // point. We perform both an operator-name lookup from the local
    // scope and an argument-dependent lookup based on the types of
    // the arguments.
    UnresolvedSet Functions/*J*/= new UnresolvedSet(16);
    OverloadedOperatorKind OverOp = UnaryOperator.getOverloadedOperator(Opc);
    if ((S != null) && OverOp != OverloadedOperatorKind.OO_None) {
      $this().LookupOverloadedOperatorName(OverOp, S, Input.getType(), new QualType(), 
          Functions);
    }
    
    return $this().CreateOverloadedUnaryOp(new SourceLocation(OpLoc), Opc, Functions, Input);
  }
  
  return $this().CreateBuiltinUnaryOp(new SourceLocation(OpLoc), Opc, Input);
}


// Unary Operators.  'Tok' is the token for the operator.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnUnaryOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11572,
 FQN="clang::Sema::ActOnUnaryOp", NM="_ZN5clang4Sema12ActOnUnaryOpEPNS_5ScopeENS_14SourceLocationENS_3tok9TokenKindEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema12ActOnUnaryOpEPNS_5ScopeENS_14SourceLocationENS_3tok9TokenKindEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnUnaryOp(Scope /*P*/ S, SourceLocation OpLoc, 
            /*tok.TokenKind*/char Op, Expr /*P*/ Input) {
  return $this().BuildUnaryOp(S, new SourceLocation(OpLoc), ConvertTokenKindToUnaryOpcode(Op), Input);
}


/// CheckAddressOfOperand - The operand of & must be either a function
/// designator or an lvalue designating an object. If it is an lvalue, the
/// object cannot be declared with storage class register or be a bit field.
/// Note: The usual conversions are *not* applied to the operand of the &
/// operator (C99 6.3.2.1p[2-4]), and its result is never an lvalue.
/// In C++, the operand might be an overloaded function name, in which case
/// we allow the '&' but retain the overloaded-function type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckAddressOfOperand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 10334,
 FQN="clang::Sema::CheckAddressOfOperand", NM="_ZN5clang4Sema21CheckAddressOfOperandERNS_12ActionResultIPNS_4ExprELb1EEENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema21CheckAddressOfOperandERNS_12ActionResultIPNS_4ExprELb1EEENS_14SourceLocationE")
//</editor-fold>
public final QualType CheckAddressOfOperand(final ActionResultTTrue<Expr /*P*/ > /*&*/ OrigOp, SourceLocation OpLoc) {
  {
    /*const*/ BuiltinType /*P*/ PTy = OrigOp.get().getType().$arrow().getAsPlaceholderType();
    if ((PTy != null)) {
      if (PTy.getKind() == BuiltinType.Kind.Overload) {
        Expr /*P*/ E = OrigOp.get().IgnoreParens();
        if (!isa_OverloadExpr(E)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            assert (cast_UnaryOperator(E).getOpcode() == UnaryOperatorKind.UO_AddrOf);
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_typecheck_invalid_lvalue_addrof_addrof_function)), 
                OrigOp.get().getSourceRange()));
            return new QualType();
          } finally {
            $c$.$destroy();
          }
        }
        
        OverloadExpr /*P*/ Ovl = cast_OverloadExpr(E);
        if (isa_UnresolvedMemberExpr(Ovl)) {
          if (!($this().ResolveSingleFunctionTemplateSpecialization(Ovl) != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_invalid_form_pointer_member_function)), 
                  OrigOp.get().getSourceRange()));
              return new QualType();
            } finally {
              $c$.$destroy();
            }
          }
        }
        
        return $this().Context.OverloadTy.$QualType();
      }
      if (PTy.getKind() == BuiltinType.Kind.UnknownAny) {
        return $this().Context.UnknownAnyTy.$QualType();
      }
      if (PTy.getKind() == BuiltinType.Kind.BoundMember) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_invalid_form_pointer_member_function)), 
              OrigOp.get().getSourceRange()));
          return new QualType();
        } finally {
          $c$.$destroy();
        }
      }
      
      OrigOp.$assignMove($this().CheckPlaceholderExpr(OrigOp.get()));
      if (OrigOp.isInvalid()) {
        return new QualType();
      }
    }
  }
  if (OrigOp.get().isTypeDependent()) {
    return $this().Context.DependentTy.$QualType();
  }
  assert (!OrigOp.get().getType().$arrow().isPlaceholderType());
  
  // Make sure to ignore parentheses in subsequent checks
  Expr /*P*/ op = OrigOp.get().IgnoreParens();
  
  // OpenCL v1.0 s6.8.a.3: Pointers to functions are not allowed.
  if ($this().LangOpts.OpenCL && op.getType().$arrow().isFunctionType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(op.getExprLoc(), diag.err_opencl_taking_function_address)));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  if ($this().getLangOpts().C99) {
    {
      // Implement C99-only parts of addressof rules.
      UnaryOperator /*P*/ uOp = dyn_cast_UnaryOperator(op);
      if ((uOp != null)) {
        if (uOp.getOpcode() == UnaryOperatorKind.UO_Deref) {
          // Per C99 6.5.3.2, the address of a deref always returns a valid result
          // (assuming the deref expression is valid).
          return uOp.getSubExpr().getType();
        }
      }
    }
    // Technically, there should be a check for array subscript
    // expressions here, but the result of one is always an lvalue anyway.
  }
  ValueDecl /*P*/ dcl = getPrimaryDecl(op);
  {
    
    FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(dcl);
    if ((FD != null)) {
      if (!$this().checkAddressOfFunctionIsAvailable(FD, /*Complain=*/ true, 
          op.getLocStart())) {
        return new QualType();
      }
    }
  }
  
  Expr.LValueClassification lval = op.ClassifyLValue($this().Context);
  /*uint*/int AddressOfError = AO_No_Error;
  if (lval == Expr.LValueClassification.LV_ClassTemporary || lval == Expr.LValueClassification.LV_ArrayTemporary) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      boolean sfinae = (boolean)$this().isSFINAEContext().$bool();
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), $this().isSFINAEContext().$bool() ? diag.err_typecheck_addrof_temporary : diag.ext_typecheck_addrof_temporary)), 
              op.getType()), op.getSourceRange()));
      if (sfinae) {
        return new QualType();
      }
      // Materialize the temporary as an lvalue so that we can take its address.
      OrigOp.$assign(op
             = $this().CreateMaterializeTemporaryExpr(op.getType(), OrigOp.get(), true));
    } finally {
      $c$.$destroy();
    }
  } else if (isa_ObjCSelectorExpr(op)) {
    return $this().Context.getPointerType(op.getType());
  } else if (lval == Expr.LValueClassification.LV_MemberFunction) {
    // If it's an instance method, make a member pointer.
    // The expression must have exactly the form &A::foo.
    
    // If the underlying expression isn't a decl ref, give up.
    if (!isa_DeclRefExpr(op)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_invalid_form_pointer_member_function)), 
            OrigOp.get().getSourceRange()));
        return new QualType();
      } finally {
        $c$.$destroy();
      }
    }
    DeclRefExpr /*P*/ DRE = cast_DeclRefExpr(op);
    CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(DRE.getDecl());
    
    // The id-expression was parenthesized.
    if (OrigOp.get() != DRE) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_parens_pointer_member_function)), 
            OrigOp.get().getSourceRange()));
      } finally {
        $c$.$destroy();
      }
      // The method was named without a qualifier.
    } else if (!(DRE.getQualifier() != null)) {
      if (MD.getParent().getName().empty()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_unqualified_pointer_member_function)), 
              op.getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SmallString/*32*/ Str/*J*/= new SmallString/*32*/(32);
          StringRef Qual = ($add_StringRef$C_char$ptr$C(MD.getParent().getName(), /*KEEP_STR*/$COLON_COLON)).toStringRef(Str);
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_unqualified_pointer_member_function)), 
                  op.getSourceRange()), 
              FixItHint.CreateInsertion(op.getSourceRange().getBegin(), /*NO_COPY*/Qual)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Taking the address of a dtor is illegal per C++ [class.dtor]p2.
    if (isa_CXXDestructorDecl(MD)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_typecheck_addrof_dtor)), op.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
    
    QualType MPTy = $this().Context.getMemberPointerType(op.getType(), $this().Context.getTypeDeclType(MD.getParent()).getTypePtr());
    // Under the MS ABI, lock down the inheritance model now.
    if ($this().Context.getTargetInfo().getCXXABI().isMicrosoft()) {
      /*J:(void)*/$this().isCompleteType(new SourceLocation(OpLoc), new QualType(MPTy));
    }
    return MPTy;
  } else if (lval != Expr.LValueClassification.LV_Valid && lval != Expr.LValueClassification.LV_IncompleteVoidType) {
    // C99 6.5.3.2p1
    // The operand must be either an l-value or a function designator
    if (!op.getType().$arrow().isFunctionType()) {
      // Use a special diagnostic for loads from property references.
      if (isa_PseudoObjectExpr(op)) {
        AddressOfError = AO_Property_Expansion;
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_typecheck_invalid_lvalue_addrof)), 
                  op.getType()), op.getSourceRange()));
          return new QualType();
        } finally {
          $c$.$destroy();
        }
      }
    }
  } else if (op.getObjectKind() == ExprObjectKind.OK_BitField) { // C99 6.5.3.2p1
// The operand cannot be a bit-field
    AddressOfError = AO_Bit_Field;
  } else if (op.getObjectKind() == ExprObjectKind.OK_VectorComponent) {
    // The operand cannot be an element of a vector
    AddressOfError = AO_Vector_Element;
  } else if ((dcl != null)) { // C99 6.5.3.2p1
// We have an lvalue with a decl. Make sure the decl is not declared
// with the register storage-class specifier.
    {
      /*const*/ VarDecl /*P*/ vd = dyn_cast_VarDecl(dcl);
      if ((vd != null)) {
        // in C++ it is not error to take address of a register
        // variable (c++03 7.1.1P3)
        if (vd.getStorageClass() == StorageClass.SC_Register
           && !$this().getLangOpts().CPlusPlus) {
          AddressOfError = AO_Register_Variable;
        }
      } else if (isa_MSPropertyDecl(dcl)) {
        AddressOfError = AO_Property_Expansion;
      } else if (isa_FunctionTemplateDecl(dcl)) {
        return $this().Context.OverloadTy.$QualType();
      } else if (isa_FieldDecl(dcl) || isa_IndirectFieldDecl(dcl)) {
        // Okay: we can take the address of a field.
        // Could be a pointer to member, though, if there is an explicit
        // scope qualifier for the class.
        if (isa_DeclRefExpr(op) && (cast_DeclRefExpr(op).getQualifier() != null)) {
          DeclContext /*P*/ Ctx = dcl.getDeclContext();
          if ((Ctx != null) && Ctx.isRecord()) {
            if (dcl.getType().$arrow().isReferenceType()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), 
                            diag.err_cannot_form_pointer_to_member_of_reference_type)), 
                        dcl.getDeclName()), dcl.getType()));
                return new QualType();
              } finally {
                $c$.$destroy();
              }
            }
            while (cast_RecordDecl(Ctx).isAnonymousStructOrUnion()) {
              Ctx = Ctx.getParent();
            }
            
            QualType MPTy = $this().Context.getMemberPointerType(op.getType(), 
                $this().Context.getTypeDeclType(cast_RecordDecl(Ctx)).getTypePtr());
            // Under the MS ABI, lock down the inheritance model now.
            if ($this().Context.getTargetInfo().getCXXABI().isMicrosoft()) {
              /*J:(void)*/$this().isCompleteType(new SourceLocation(OpLoc), new QualType(MPTy));
            }
            return MPTy;
          }
        }
      } else if (!isa_FunctionDecl(dcl) && !isa_NonTypeTemplateParmDecl(dcl)) {
        throw new llvm_unreachable("Unknown/unexpected decl type");
      }
    }
  }
  if (AddressOfError != AO_No_Error) {
    diagnoseAddressOfInvalidType(/*Deref*/$this(), new SourceLocation(OpLoc), op, AddressOfError);
    return new QualType();
  }
  if (lval == Expr.LValueClassification.LV_IncompleteVoidType) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Taking the address of a void variable is technically illegal, but we
      // allow it in cases which are otherwise valid.
      // Example: "extern void x; void* y = &x;".
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.ext_typecheck_addrof_void)), op.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
  
  // If the operand has type "type", the result has type "pointer to type".
  if (op.getType().$arrow().isObjCObjectType()) {
    return $this().Context.getObjCObjectPointerType(op.getType());
  }
  
  return $this().Context.getPointerType(op.getType());
}


/// \brief Build a sizeof or alignof expression given a type operand.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CreateUnaryExprOrTypeTraitExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 3949,
 FQN="clang::Sema::CreateUnaryExprOrTypeTraitExpr", NM="_ZN5clang4Sema30CreateUnaryExprOrTypeTraitExprEPNS_14TypeSourceInfoENS_14SourceLocationENS_20UnaryExprOrTypeTraitENS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema30CreateUnaryExprOrTypeTraitExprEPNS_14TypeSourceInfoENS_14SourceLocationENS_20UnaryExprOrTypeTraitENS_11SourceRangeE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CreateUnaryExprOrTypeTraitExpr(TypeSourceInfo /*P*/ TInfo, 
                              SourceLocation OpLoc, 
                              UnaryExprOrTypeTrait ExprKind, 
                              SourceRange R) {
  if (!(TInfo != null)) {
    return ExprError();
  }
  
  QualType T = TInfo.getType();
  if (!T.$arrow().isDependentType()
     && $this().CheckUnaryExprOrTypeTraitOperand(new QualType(T), new SourceLocation(OpLoc), new SourceRange(R), ExprKind)) {
    return ExprError();
  }
  if (T.$arrow().isVariablyModifiedType() && $greater_uint($this().FunctionScopes.size(), 1)) {
    {
      /*const*/ TypedefType /*P*/ TT = T.$arrow().getAs$TypedefType();
      if ((TT != null)) {
        for (reverse_iterator<FunctionScopeInfo /*P*/ > I = $this().FunctionScopes.rbegin(), 
            E = std.prev($this().FunctionScopes.rend());
             $noteq_reverse_iterator$C(I, E); I.$preInc()) {
          CapturingScopeInfo /*P*/ CSI = dyn_cast_CapturingScopeInfo(I.$star());
          if (CSI == null) {
            break;
          }
          DeclContext /*P*/ DC = null;
          {
            LambdaScopeInfo /*P*/ LSI = dyn_cast_LambdaScopeInfo(CSI);
            if ((LSI != null)) {
              DC = LSI.CallOperator;
            } else {
              CapturedRegionScopeInfo /*P*/ CRSI = dyn_cast_CapturedRegionScopeInfo(CSI);
              if ((CRSI != null)) {
                DC = CRSI.TheCapturedDecl;
              } else {
                BlockScopeInfo /*P*/ BSI = dyn_cast_BlockScopeInfo(CSI);
                if ((BSI != null)) {
                  DC = BSI.TheDecl;
                }
              }
            }
          }
          if ((DC != null)) {
            if (DC.containsDecl(TT.getDecl())) {
              break;
            }
            captureVariablyModifiedType($this().Context, new QualType(T), CSI);
          }
        }
      }
    }
  }
  
  // C99 6.5.3.4p4: the type (an unsigned integer type) is size_t.
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new UnaryExprOrTypeTraitExpr(ExprKind, TInfo, $this().Context.getSizeType().$QualType(), new SourceLocation(OpLoc), R.getEnd());
       }));
}


/// \brief Build a sizeof or alignof expression given an expression
/// operand.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CreateUnaryExprOrTypeTraitExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 3994,
 FQN="clang::Sema::CreateUnaryExprOrTypeTraitExpr", NM="_ZN5clang4Sema30CreateUnaryExprOrTypeTraitExprEPNS_4ExprENS_14SourceLocationENS_20UnaryExprOrTypeTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema30CreateUnaryExprOrTypeTraitExprEPNS_4ExprENS_14SourceLocationENS_20UnaryExprOrTypeTraitE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CreateUnaryExprOrTypeTraitExpr(Expr /*P*/ E, SourceLocation OpLoc, 
                              UnaryExprOrTypeTrait ExprKind) {
  ActionResultTTrue<Expr /*P*/ > PE = $this().CheckPlaceholderExpr(E);
  if (PE.isInvalid()) {
    return ExprError();
  }
  
  E = PE.get();
  
  // Verify that the operand is valid.
  boolean isInvalid = false;
  if (E.isTypeDependent()) {
    // Delay type-checking for type-dependent expressions.
  } else if (ExprKind == UnaryExprOrTypeTrait.UETT_AlignOf) {
    isInvalid = CheckAlignOfExpr(/*Deref*/$this(), E);
  } else if (ExprKind == UnaryExprOrTypeTrait.UETT_VecStep) {
    isInvalid = $this().CheckVecStepExpr(E);
  } else if (ExprKind == UnaryExprOrTypeTrait.UETT_OpenMPRequiredSimdAlign) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(E.getExprLoc(), diag.err_openmp_default_simd_align_expr)));
      isInvalid = true;
    } finally {
      $c$.$destroy();
    }
  } else if (E.refersToBitField()) { // C99 6.5.3.4p1.
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.err_sizeof_alignof_typeof_bitfield)), 0));
      isInvalid = true;
    } finally {
      $c$.$destroy();
    }
  } else {
    isInvalid = $this().CheckUnaryExprOrTypeTraitOperand(E, UnaryExprOrTypeTrait.UETT_SizeOf);
  }
  if (isInvalid) {
    return ExprError();
  }
  if (ExprKind == UnaryExprOrTypeTrait.UETT_SizeOf && E.getType().$arrow().isVariableArrayType()) {
    PE.$assignMove($this().TransformToPotentiallyEvaluated(E));
    if (PE.isInvalid()) {
      return ExprError();
    }
    E = PE.get();
  }
  
  // C99 6.5.3.4p4: the type (an unsigned integer type) is size_t.
  final Expr /*P*/ L$E = E;
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new UnaryExprOrTypeTraitExpr(ExprKind, L$E, $this().Context.getSizeType().$QualType(), new SourceLocation(OpLoc), L$E.getSourceRange().getEnd());
       }));
}


/// ActOnUnaryExprOrTypeTraitExpr - Handle @c sizeof(type) and @c sizeof @c
/// expr and the same for @c alignof and @c __alignof
/// Note that the ArgRange is invalid if isType is false.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnUnaryExprOrTypeTraitExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 4038,
 FQN="clang::Sema::ActOnUnaryExprOrTypeTraitExpr", NM="_ZN5clang4Sema29ActOnUnaryExprOrTypeTraitExprENS_14SourceLocationENS_20UnaryExprOrTypeTraitEbPvNS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema29ActOnUnaryExprOrTypeTraitExprENS_14SourceLocationENS_20UnaryExprOrTypeTraitEbPvNS_11SourceRangeE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnUnaryExprOrTypeTraitExpr(SourceLocation OpLoc, 
                             UnaryExprOrTypeTrait ExprKind, boolean IsType, 
                             Object/*void P*/ TyOrEx, SourceRange ArgRange) {
  // If error parsing type, ignore.
  if (!(TyOrEx != null)) {
    return ExprError();
  }
  if (IsType) {
    type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr();
    /*J:(void)*/GetTypeFromParser(OpaquePtr.<QualType>getFromOpaquePtr(TyOrEx), $AddrOf(TInfo));
    return $this().CreateUnaryExprOrTypeTraitExpr(TInfo.$star(), new SourceLocation(OpLoc), ExprKind, new SourceRange(ArgRange));
  }
  
  Expr /*P*/ ArgEx = (Expr /*P*/ )TyOrEx;
  ActionResultTTrue<Expr /*P*/ > Result = $this().CreateUnaryExprOrTypeTraitExpr(ArgEx, new SourceLocation(OpLoc), ExprKind);
  return Result;
}


/// Check for operands with placeholder types and complain if found.
/// Returns true if there was an error and no recovery was possible.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckPlaceholderExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14955,
 FQN="clang::Sema::CheckPlaceholderExpr", NM="_ZN5clang4Sema20CheckPlaceholderExprEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema20CheckPlaceholderExprEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CheckPlaceholderExpr(Expr /*P*/ E) {
  if (!$this().getLangOpts().CPlusPlus) {
    // C cannot handle TypoExpr nodes on either side of a binop because it
    // doesn't handle dependent types properly, so make sure any TypoExprs have
    // been dealt with before checking the operands.
    ActionResultTTrue<Expr /*P*/ > Result = $this().CorrectDelayedTyposInExpr(E);
    if (!Result.isUsable()) {
      return ExprError();
    }
    E = Result.get();
  }
  
  /*const*/ BuiltinType /*P*/ placeholderType = E.getType().$arrow().getAsPlaceholderType();
  if (!(placeholderType != null)) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }
  switch (placeholderType.getKind()) {
   case Overload:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Try to resolve a single function template specialization.
        // This is obligatory.
        ActionResultTTrue<Expr /*P*/ > Result = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
        if ($this().ResolveAndFixSingleFunctionTemplateSpecialization(Result, false)) {
          return Result;
        }
        
        // No guarantees that ResolveAndFixSingleFunctionTemplateSpecialization
        // leaves Result unchanged on failure.
        Result.$assign(E);
        if ($this().resolveAndFixAddressOfOnlyViableOverloadCandidate(Result)) {
          return Result;
        }
        
        // If that failed, try to recover with a call.
        $c$.clean($this().tryToRecoverWithCall(Result, $c$.track($this().PDiag(diag.err_ovl_unresolvable)), 
            /*complain*/ true));
        return Result;
      } finally {
        $c$.$destroy();
      }
    }
   case BoundMember:
    {
      PartialDiagnostic PD = null;
      try {
        ActionResultTTrue<Expr /*P*/ > result = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
        /*const*/ Expr /*P*/ BME = E.IgnoreParens();
        PD = $this().PDiag(diag.err_bound_member_function);
        // Try to give a nicer diagnostic if it is a bound member that we recognize.
        if (isa_CXXPseudoDestructorExpr(BME)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(PD.$assign($out_PartialDiagnostic$C_int($c$.track($this().PDiag(diag.err_dtor_expr_without_call)), /*pseudo-destructor*/ 1)));
          } finally {
            $c$.$destroy();
          }
        } else {
          /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(BME);
          if ((ME != null)) {
            if (ME.getMemberNameInfo().getName().getNameKind()
               == DeclarationName.NameKind.CXXDestructorName) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean(PD.$assign($out_PartialDiagnostic$C_int($c$.track($this().PDiag(diag.err_dtor_expr_without_call)), /*destructor*/ 0)));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
        $this().tryToRecoverWithCall(result, PD, 
            /*complain*/ true);
        return result;
      } finally {
        if (PD != null) { PD.$destroy(); }
      }
    }
   case ARCUnbridgedCast:
    {
      Expr /*P*/ realCast = $this().stripARCUnbridgedCast(E);
      $this().diagnoseARCUnbridgedCast(realCast);
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, realCast);
    }
   case UnknownAny:
    
    // Expressions of unknown type.
    return diagnoseUnknownAnyExpr(/*Deref*/$this(), E);
   case PseudoObject:
    
    // Pseudo-objects.
    return $this().checkPseudoObjectRValue(E);
   case BuiltinFn:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Accept __noop without parens by implicitly converting it to a call expr.
        DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E.IgnoreParenImpCasts());
        if ((DRE != null)) {
          FunctionDecl /*P*/ FD = cast_FunctionDecl(DRE.getDecl());
          if (FD.getBuiltinID() == Builtin.ID.BI__noop.getValue()) {
            E = $this().ImpCastExprToType(E, $this().Context.getPointerType(FD.getType()), 
                CastKind.CK_BuiltinFnToFnPtr).get();
            final Expr /*P*/ L$E = E;
            return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
              
                    return new CallExpr($this().Context, L$E, new ArrayRef<Expr /*P*/ >(None, true), $this().Context.IntTy.$QualType(), 
                            ExprValueKind.VK_RValue, new SourceLocation());
                 }));
          }
        }
        
        $c$.clean($c$.track($this().Diag(E.getLocStart(), diag.err_builtin_fn_use)));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
   case OMPArraySection:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        
        // Expressions of unknown type.
        $c$.clean($c$.track($this().Diag(E.getLocStart(), diag.err_omp_array_section_use)));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
   case OCLImage1dRO:
   case OCLImage1dArrayRO:
   case OCLImage1dBufferRO:
   case OCLImage2dRO:
   case OCLImage2dArrayRO:
   case OCLImage2dDepthRO:
   case OCLImage2dArrayDepthRO:
   case OCLImage2dMSAARO:
   case OCLImage2dArrayMSAARO:
   case OCLImage2dMSAADepthRO:
   case OCLImage2dArrayMSAADepthRO:
   case OCLImage3dRO:
   case OCLImage1dWO:
   case OCLImage1dArrayWO:
   case OCLImage1dBufferWO:
   case OCLImage2dWO:
   case OCLImage2dArrayWO:
   case OCLImage2dDepthWO:
   case OCLImage2dArrayDepthWO:
   case OCLImage2dMSAAWO:
   case OCLImage2dArrayMSAAWO:
   case OCLImage2dMSAADepthWO:
   case OCLImage2dArrayMSAADepthWO:
   case OCLImage3dWO:
   case OCLImage1dRW:
   case OCLImage1dArrayRW:
   case OCLImage1dBufferRW:
   case OCLImage2dRW:
   case OCLImage2dArrayRW:
   case OCLImage2dDepthRW:
   case OCLImage2dArrayDepthRW:
   case OCLImage2dMSAARW:
   case OCLImage2dArrayMSAARW:
   case OCLImage2dMSAADepthRW:
   case OCLImage2dArrayMSAADepthRW:
   case OCLImage3dRW:
   case Void:
   case Bool:
   case Char_U:
   case UChar:
   case WChar_U:
   case Char16:
   case Char32:
   case UShort:
   case UInt:
   case ULong:
   case ULongLong:
   case UInt128:
   case Char_S:
   case SChar:
   case WChar_S:
   case Short:
   case Int:
   case Long:
   case LongLong:
   case Int128:
   case Half:
   case Float:
   case Double:
   case LongDouble:
   case Float128:
   case NullPtr:
   case ObjCId:
   case ObjCClass:
   case ObjCSel:
   case OCLSampler:
   case OCLEvent:
   case OCLClkEvent:
   case OCLQueue:
   case OCLNDRange:
   case OCLReserveID:
   case Dependent:
    break;
  }
  throw new llvm_unreachable("invalid placeholder type!");
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckVecStepExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 3816,
 FQN="clang::Sema::CheckVecStepExpr", NM="_ZN5clang4Sema16CheckVecStepExprEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema16CheckVecStepExprEPNS_4ExprE")
//</editor-fold>
public final boolean CheckVecStepExpr(Expr /*P*/ E) {
  E = E.IgnoreParens();
  
  // Cannot know anything else if the expression is dependent.
  if (E.isTypeDependent()) {
    return false;
  }
  
  return $this().CheckUnaryExprOrTypeTraitOperand(E, UnaryExprOrTypeTrait.UETT_VecStep);
}


/// \brief Check the constraints on expression operands to unary type expression
/// and type traits.
///
/// Completes any types necessary and validates the constraints on the operand
/// expression. The logic mostly mirrors the type-based overload, but may modify
/// the expression as it completes the type for that expression through template
/// instantiation, etc.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckUnaryExprOrTypeTraitOperand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 3619,
 FQN="clang::Sema::CheckUnaryExprOrTypeTraitOperand", NM="_ZN5clang4Sema32CheckUnaryExprOrTypeTraitOperandEPNS_4ExprENS_20UnaryExprOrTypeTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema32CheckUnaryExprOrTypeTraitOperandEPNS_4ExprENS_20UnaryExprOrTypeTraitE")
//</editor-fold>
public final boolean CheckUnaryExprOrTypeTraitOperand(Expr /*P*/ E, 
                                UnaryExprOrTypeTrait ExprKind) {
  QualType ExprTy = E.getType();
  assert (!ExprTy.$arrow().isReferenceType());
  if (ExprKind == UnaryExprOrTypeTrait.UETT_VecStep) {
    return CheckVecStepTraitOperandType(/*Deref*/$this(), new QualType(ExprTy), E.getExprLoc(), 
        E.getSourceRange());
  }
  
  // Whitelist some types as extensions
  if (!CheckExtensionTraitOperandType(/*Deref*/$this(), new QualType(ExprTy), E.getExprLoc(), 
      E.getSourceRange(), ExprKind)) {
    return false;
  }
  
  // 'alignof' applied to an expression only requires the base element type of
  // the expression to be complete. 'sizeof' requires the expression's type to
  // be complete (and will attempt to complete it if it's an array of unknown
  // bound).
  if (ExprKind == UnaryExprOrTypeTrait.UETT_AlignOf) {
    if ($this().RequireCompleteType$T(E.getExprLoc(), 
        $this().Context.getBaseElementType(E.getType()), 
        diag.err_sizeof_alignof_incomplete_type, ExprKind, 
        E.getSourceRange())) {
      return true;
    }
  } else {
    if ($this().RequireCompleteExprType$T(E, diag.err_sizeof_alignof_incomplete_type, 
        ExprKind, E.getSourceRange())) {
      return true;
    }
  }
  
  // Completing the expression's type may have changed it.
  ExprTy.$assignMove(E.getType());
  assert (!ExprTy.$arrow().isReferenceType());
  if (ExprTy.$arrow().isFunctionType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.err_sizeof_alignof_function_type)), 
              ExprKind), E.getSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // The operand for sizeof and alignof is in an unevaluated expression context,
  // so side effects could result in unintended consequences.
  if ((ExprKind == UnaryExprOrTypeTrait.UETT_SizeOf || ExprKind == UnaryExprOrTypeTrait.UETT_AlignOf)
     && $this().ActiveTemplateInstantiations.empty() && E.HasSideEffects($this().Context, false)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(E.getExprLoc(), diag.warn_side_effects_unevaluated_context)));
    } finally {
      $c$.$destroy();
    }
  }
  if (CheckObjCTraitOperandConstraints(/*Deref*/$this(), new QualType(ExprTy), E.getExprLoc(), 
      E.getSourceRange(), ExprKind)) {
    return true;
  }
  if (ExprKind == UnaryExprOrTypeTrait.UETT_SizeOf) {
    {
      DeclRefExpr /*P*/ DeclRef = dyn_cast_DeclRefExpr(E.IgnoreParens());
      if ((DeclRef != null)) {
        {
          ParmVarDecl /*P*/ PVD = dyn_cast_ParmVarDecl(DeclRef.getFoundDecl());
          if ((PVD != null)) {
            QualType OType = PVD.getOriginalType();
            QualType Type = PVD.getType();
            if (Type.$arrow().isPointerType() && OType.$arrow().isArrayType()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.warn_sizeof_array_param)), 
                        Type), OType));
                $c$.clean($c$.track($this().Diag(PVD.getLocation(), diag.note_declared_at)));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      }
    }
    {
      
      // Warn on "sizeof(array op x)" and "sizeof(x op array)", where the array
      // decays into a pointer and returns an unintended result. This is most
      // likely a typo for "sizeof(array) op x".
      BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(E.IgnoreParens());
      if ((BO != null)) {
        warnOnSizeofOnArrayDecay(/*Deref*/$this(), BO.getOperatorLoc(), BO.getType(), 
            BO.getLHS());
        warnOnSizeofOnArrayDecay(/*Deref*/$this(), BO.getOperatorLoc(), BO.getType(), 
            BO.getRHS());
      }
    }
  }
  
  return false;
}


/// \brief Check the constraints on operands to unary expression and type
/// traits.
///
/// This will complete any types necessary, and validate the various constraints
/// on those operands.
///
/// The UsualUnaryConversions() function is *not* called by this routine.
/// C99 6.3.2.1p[2-4] all state:
///   Except when it is the operand of the sizeof operator ...
///
/// C++ [expr.sizeof]p4
///   The lvalue-to-rvalue, array-to-pointer, and function-to-pointer
///   standard conversions are not applied to the operand of sizeof.
///
/// This policy is followed for all of the unary trait expressions.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckUnaryExprOrTypeTraitOperand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 3711,
 FQN="clang::Sema::CheckUnaryExprOrTypeTraitOperand", NM="_ZN5clang4Sema32CheckUnaryExprOrTypeTraitOperandENS_8QualTypeENS_14SourceLocationENS_11SourceRangeENS_20UnaryExprOrTypeTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema32CheckUnaryExprOrTypeTraitOperandENS_8QualTypeENS_14SourceLocationENS_11SourceRangeENS_20UnaryExprOrTypeTraitE")
//</editor-fold>
public final boolean CheckUnaryExprOrTypeTraitOperand(QualType ExprType, 
                                SourceLocation OpLoc, 
                                SourceRange ExprRange, 
                                UnaryExprOrTypeTrait ExprKind) {
  if (ExprType.$arrow().isDependentType()) {
    return false;
  }
  {
    
    // C++ [expr.sizeof]p2:
    //     When applied to a reference or a reference type, the result
    //     is the size of the referenced type.
    // C++11 [expr.alignof]p3:
    //     When alignof is applied to a reference type, the result
    //     shall be the alignment of the referenced type.
    /*const*/ ReferenceType /*P*/ Ref = ExprType.$arrow().getAs(ReferenceType.class);
    if ((Ref != null)) {
      ExprType.$assignMove(Ref.getPointeeType());
    }
  }
  
  // C11 6.5.3.4/3, C++11 [expr.alignof]p3:
  //   When alignof or _Alignof is applied to an array type, the result
  //   is the alignment of the element type.
  if (ExprKind == UnaryExprOrTypeTrait.UETT_AlignOf || ExprKind == UnaryExprOrTypeTrait.UETT_OpenMPRequiredSimdAlign) {
    ExprType.$assignMove($this().Context.getBaseElementType(new QualType(ExprType)));
  }
  if (ExprKind == UnaryExprOrTypeTrait.UETT_VecStep) {
    return CheckVecStepTraitOperandType(/*Deref*/$this(), new QualType(ExprType), new SourceLocation(OpLoc), new SourceRange(ExprRange));
  }
  
  // Whitelist some types as extensions
  if (!CheckExtensionTraitOperandType(/*Deref*/$this(), new QualType(ExprType), new SourceLocation(OpLoc), new SourceRange(ExprRange), 
      ExprKind)) {
    return false;
  }
  if ($this().RequireCompleteType$T(new SourceLocation(OpLoc), new QualType(ExprType), 
      diag.err_sizeof_alignof_incomplete_type, 
      ExprKind, ExprRange)) {
    return true;
  }
  if (ExprType.$arrow().isFunctionType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_sizeof_alignof_function_type)), 
              ExprKind), ExprRange));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  if (CheckObjCTraitOperandConstraints(/*Deref*/$this(), new QualType(ExprType), new SourceLocation(OpLoc), new SourceRange(ExprRange), 
      ExprKind)) {
    return true;
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPostfixUnaryOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 4092,
 FQN="clang::Sema::ActOnPostfixUnaryOp", NM="_ZN5clang4Sema19ActOnPostfixUnaryOpEPNS_5ScopeENS_14SourceLocationENS_3tok9TokenKindEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema19ActOnPostfixUnaryOpEPNS_5ScopeENS_14SourceLocationENS_3tok9TokenKindEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnPostfixUnaryOp(Scope /*P*/ S, SourceLocation OpLoc, 
                   /*tok.TokenKind*/char Kind, Expr /*P*/ Input) {
  UnaryOperatorKind Opc;
  switch (Kind) {
   default:
    throw new llvm_unreachable("Unknown unary op!");
   case tok.TokenKind.plusplus:
    Opc = UnaryOperatorKind.UO_PostInc;
    break;
   case tok.TokenKind.minusminus:
    Opc = UnaryOperatorKind.UO_PostDec;
    break;
  }
  
  // Since this might is a postfix expression, get rid of ParenListExprs.
  ActionResultTTrue<Expr /*P*/ > Result = $this().MaybeConvertParenListExprToParenExpr(S, Input);
  if (Result.isInvalid()) {
    return ExprError();
  }
  Input = Result.get();
  
  return $this().BuildUnaryOp(S, new SourceLocation(OpLoc), Opc, Input);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnArraySubscriptExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 4134,
 FQN="clang::Sema::ActOnArraySubscriptExpr", NM="_ZN5clang4Sema23ActOnArraySubscriptExprEPNS_5ScopeEPNS_4ExprENS_14SourceLocationES4_S5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema23ActOnArraySubscriptExprEPNS_5ScopeEPNS_4ExprENS_14SourceLocationES4_S5_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnArraySubscriptExpr(Scope /*P*/ S, Expr /*P*/ base, SourceLocation lbLoc, 
                       Expr /*P*/ idx, SourceLocation rbLoc) {
  if ((base != null) && !base.getType().isNull()
     && base.getType().$arrow().isSpecificPlaceholderType(BuiltinType.Kind.OMPArraySection.getValue())) {
    return $this().ActOnOMPArraySectionExpr(base, new SourceLocation(lbLoc), idx, new SourceLocation(), 
        /*Length=*/ (Expr /*P*/ )null, new SourceLocation(rbLoc));
  }
  
  // Since this might be a postfix expression, get rid of ParenListExprs.
  if (isa_ParenListExpr(base)) {
    ActionResultTTrue<Expr /*P*/ > result = $this().MaybeConvertParenListExprToParenExpr(S, base);
    if (result.isInvalid()) {
      return ExprError();
    }
    base = result.get();
  }
  
  // Handle any non-overload placeholder types in the base and index
  // expressions.  We can't handle overloads here because the other
  // operand might be an overloadable type, in which case the overload
  // resolution for the operator overload should get the first crack
  // at the overload.
  boolean IsMSPropertySubscript = false;
  if (base.getType().$arrow().isNonOverloadPlaceholderType()) {
    IsMSPropertySubscript = isMSPropertySubscriptExpr(/*Deref*/$this(), base);
    if (!IsMSPropertySubscript) {
      ActionResultTTrue<Expr /*P*/ > result = $this().CheckPlaceholderExpr(base);
      if (result.isInvalid()) {
        return ExprError();
      }
      base = result.get();
    }
  }
  if (idx.getType().$arrow().isNonOverloadPlaceholderType()) {
    ActionResultTTrue<Expr /*P*/ > result = $this().CheckPlaceholderExpr(idx);
    if (result.isInvalid()) {
      return ExprError();
    }
    idx = result.get();
  }
  
  // Build an unanalyzed expression if either operand is type-dependent.
  if ($this().getLangOpts().CPlusPlus
     && (base.isTypeDependent() || idx.isTypeDependent())) {
    final Expr /*P*/ L$base = base;
    final Expr /*P*/ L$idx = idx;
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
            return new ArraySubscriptExpr(L$base, L$idx, $this().Context.DependentTy.$QualType(), 
                    ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, new SourceLocation(rbLoc));
         }));
  }
  
  // MSDN, property (C++)
  // https://msdn.microsoft.com/en-us/library/yhfk0thd(v=vs.120).aspx
  // This attribute can also be used in the declaration of an empty array in a
  // class or structure definition. For example:
  // __declspec(property(get=GetX, put=PutX)) int x[];
  // The above statement indicates that x[] can be used with one or more array
  // indices. In this case, i=p->x[a][b] will be turned into i=p->GetX(a, b),
  // and p->x[a][b] = i will be turned into p->PutX(a, b, i);
  if (IsMSPropertySubscript) {
    // Build MS property subscript expression if base is MS property reference
    // or MS property subscript.
    final Expr /*P*/ L$base = base;
    final Expr /*P*/ L$idx = idx;    
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
            return new MSPropertySubscriptExpr(L$base, L$idx, $this().Context.PseudoObjectTy.$QualType(), ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, new SourceLocation(rbLoc));
         }));
  }
  
  // Use C++ overloaded-operator rules if either operand has record
  // type.  The spec says to do this if either type is *overloadable*,
  // but enum types can't declare subscript operators or conversion
  // operators, so there's nothing interesting for overload resolution
  // to do if there aren't any record types involved.
  //
  // ObjC pointers have their own subscripting logic that is not tied
  // to overload resolution and so should not take this path.
  if ($this().getLangOpts().CPlusPlus
     && (base.getType().$arrow().isRecordType()
     || (!base.getType().$arrow().isObjCObjectPointerType()
     && idx.getType().$arrow().isRecordType()))) {
    return $this().CreateOverloadedArraySubscriptExpr(new SourceLocation(lbLoc), new SourceLocation(rbLoc), base, idx);
  }
  
  return $this().CreateBuiltinArraySubscriptExpr(base, new SourceLocation(lbLoc), idx, new SourceLocation(rbLoc));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CreateBuiltinArraySubscriptExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 4356,
 FQN="clang::Sema::CreateBuiltinArraySubscriptExpr", NM="_ZN5clang4Sema31CreateBuiltinArraySubscriptExprEPNS_4ExprENS_14SourceLocationES2_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema31CreateBuiltinArraySubscriptExprEPNS_4ExprENS_14SourceLocationES2_S3_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CreateBuiltinArraySubscriptExpr(Expr /*P*/ Base, SourceLocation LLoc, 
                               Expr /*P*/ Idx, SourceLocation RLoc) {
  Expr /*P*/ LHSExp = Base;
  Expr /*P*/ RHSExp = Idx;
  
  // Perform default conversions.
  if (!(LHSExp.getType().$arrow().getAs(VectorType.class) != null)) {
    ActionResultTTrue<Expr /*P*/ > Result = $this().DefaultFunctionArrayLvalueConversion(LHSExp);
    if (Result.isInvalid()) {
      return ExprError();
    }
    LHSExp = Result.get();
  }
  ActionResultTTrue<Expr /*P*/ > Result = $this().DefaultFunctionArrayLvalueConversion(RHSExp);
  if (Result.isInvalid()) {
    return ExprError();
  }
  RHSExp = Result.get();
  
  QualType LHSTy = LHSExp.getType();
  QualType RHSTy = RHSExp.getType();
  ExprValueKind VK = ExprValueKind.VK_LValue;
  ExprObjectKind OK = ExprObjectKind.OK_Ordinary;
  
  // C99 6.5.2.1p2: the expression e1[e2] is by definition precisely equivalent
  // to the expression *((e1)+(e2)). This means the array "Base" may actually be
  // in the subscript position. As a result, we need to derive the array base
  // and index from the expression types.
  Expr /*P*/ BaseExpr;
  Expr /*P*/ IndexExpr;
  QualType ResultType/*J*/= new QualType();
  if (LHSTy.$arrow().isDependentType() || RHSTy.$arrow().isDependentType()) {
    BaseExpr = LHSExp;
    IndexExpr = RHSExp;
    ResultType.$assignMove($this().Context.DependentTy.$QualType());
  } else {
    /*const*/ PointerType /*P*/ PTy = LHSTy.$arrow().getAs(PointerType.class);
    if ((PTy != null)) {
      BaseExpr = LHSExp;
      IndexExpr = RHSExp;
      ResultType.$assignMove(PTy.getPointeeType());
    } else {
      /*const*/ ObjCObjectPointerType /*P*/ PTy$1 = LHSTy.$arrow().getAs(ObjCObjectPointerType.class);
      if ((PTy$1 != null)) {
        BaseExpr = LHSExp;
        IndexExpr = RHSExp;
        
        // Use custom logic if this should be the pseudo-object subscript
        // expression.
        if (!$this().LangOpts.isSubscriptPointerArithmetic()) {
          return $this().BuildObjCSubscriptExpression(new SourceLocation(RLoc), BaseExpr, IndexExpr, (ObjCMethodDecl /*P*/ )null, 
              (ObjCMethodDecl /*P*/ )null);
        }
        
        ResultType.$assignMove(PTy$1.getPointeeType());
      } else {
        /*const*/ PointerType /*P*/ PTy$2 = RHSTy.$arrow().getAs(PointerType.class);
        if ((PTy$2 != null)) {
          // Handle the uncommon case of "123[Ptr]".
          BaseExpr = RHSExp;
          IndexExpr = LHSExp;
          ResultType.$assignMove(PTy$2.getPointeeType());
        } else {
          /*const*/ ObjCObjectPointerType /*P*/ PTy$3 = RHSTy.$arrow().getAs(ObjCObjectPointerType.class);
          if ((PTy$3 != null)) {
            // Handle the uncommon case of "123[Ptr]".
            BaseExpr = RHSExp;
            IndexExpr = LHSExp;
            ResultType.$assignMove(PTy$3.getPointeeType());
            if (!$this().LangOpts.isSubscriptPointerArithmetic()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LLoc), diag.err_subscript_nonfragile_interface)), 
                        ResultType), BaseExpr.getSourceRange()));
                return ExprError();
              } finally {
                $c$.$destroy();
              }
            }
          } else {
            /*const*/ VectorType /*P*/ VTy = LHSTy.$arrow().getAs(VectorType.class);
            if ((VTy != null)) {
              BaseExpr = LHSExp; // vectors: V[123]
              IndexExpr = RHSExp;
              VK = LHSExp.getValueKind();
              if (VK != ExprValueKind.VK_RValue) {
                OK = ExprObjectKind.OK_VectorComponent;
              }
              
              // FIXME: need to deal with const...
              ResultType.$assignMove(VTy.getElementType());
            } else if (LHSTy.$arrow().isArrayType()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                // If we see an array that wasn't promoted by
                // DefaultFunctionArrayLvalueConversion, it must be an array that
                // wasn't promoted because of the C90 rule that doesn't
                // allow promoting non-lvalue arrays.  Warn, then
                // force the promotion here.
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(LHSExp.getLocStart(), diag.ext_subscript_non_lvalue)), 
                    LHSExp.getSourceRange()));
                LHSExp = $this().ImpCastExprToType(LHSExp, $this().Context.getArrayDecayedType(new QualType(LHSTy)), 
                    CastKind.CK_ArrayToPointerDecay).get();
                LHSTy.$assignMove(LHSExp.getType());
                
                BaseExpr = LHSExp;
                IndexExpr = RHSExp;
                ResultType.$assignMove(LHSTy.$arrow().getAs(PointerType.class).getPointeeType());
              } finally {
                $c$.$destroy();
              }
            } else if (RHSTy.$arrow().isArrayType()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                // Same as previous, except for 123[f().a] case
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(RHSExp.getLocStart(), diag.ext_subscript_non_lvalue)), 
                    RHSExp.getSourceRange()));
                RHSExp = $this().ImpCastExprToType(RHSExp, $this().Context.getArrayDecayedType(new QualType(RHSTy)), 
                    CastKind.CK_ArrayToPointerDecay).get();
                RHSTy.$assignMove(RHSExp.getType());
                
                BaseExpr = RHSExp;
                IndexExpr = LHSExp;
                ResultType.$assignMove(RHSTy.$arrow().getAs(PointerType.class).getPointeeType());
              } finally {
                $c$.$destroy();
              }
            } else {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LLoc), diag.err_typecheck_subscript_value)), 
                            LHSExp.getSourceRange()), RHSExp.getSourceRange())));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      }
    }
  }
  // C99 6.5.2.1p1
  if (!IndexExpr.getType().$arrow().isIntegerType() && !IndexExpr.isTypeDependent()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LLoc), diag.err_typecheck_subscript_not_integer)), 
              IndexExpr.getSourceRange())));
    } finally {
      $c$.$destroy();
    }
  }
  if ((IndexExpr.getType().$arrow().isSpecificBuiltinType(BuiltinType.Kind.Char_S.getValue())
     || IndexExpr.getType().$arrow().isSpecificBuiltinType(BuiltinType.Kind.Char_U.getValue()))
     && !IndexExpr.isTypeDependent()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LLoc), diag.warn_subscript_is_char)), IndexExpr.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
  
  // C99 6.5.2.1p1: "shall have type "pointer to *object* type". Similarly,
  // C++ [expr.sub]p1: The type "T" shall be a completely-defined object
  // type. Note that Functions are not objects, and that (in C99 parlance)
  // incomplete types are not object types.
  if (ResultType.$arrow().isFunctionType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(BaseExpr.getLocStart(), diag.err_subscript_function_type)), 
              ResultType), BaseExpr.getSourceRange()));
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  if (ResultType.$arrow().isVoidType() && !$this().getLangOpts().CPlusPlus) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // GNU extension: subscripting on pointer to void
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LLoc), diag.ext_gnu_subscript_void_type)), 
          BaseExpr.getSourceRange()));
      
      // C forbids expressions of unqualified void type from being l-values.
      // See IsCForbiddenLValueType.
      if (!ResultType.hasQualifiers()) {
        VK = ExprValueKind.VK_RValue;
      }
    } finally {
      $c$.$destroy();
    }
  } else if (!ResultType.$arrow().isDependentType()
     && $this().RequireCompleteType$T(new SourceLocation(LLoc), new QualType(ResultType), 
      diag.err_subscript_incomplete_type, BaseExpr)) {
    return ExprError();
  }
  assert (VK == ExprValueKind.VK_RValue || $this().LangOpts.CPlusPlus || !ResultType.isCForbiddenLValueType());
  
  final Expr /*P*/ L$LHSExp = LHSExp;
  final Expr /*P*/ L$RHSExp = RHSExp;  
  final ExprValueKind L$VK = VK;
  final ExprObjectKind L$OK = OK;
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new ArraySubscriptExpr(L$LHSExp, L$RHSExp, new QualType(ResultType), L$VK, L$OK, new SourceLocation(RLoc));
       }));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOMPArraySectionExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 4210,
 FQN="clang::Sema::ActOnOMPArraySectionExpr", NM="_ZN5clang4Sema24ActOnOMPArraySectionExprEPNS_4ExprENS_14SourceLocationES2_S3_S2_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema24ActOnOMPArraySectionExprEPNS_4ExprENS_14SourceLocationES2_S3_S2_S3_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnOMPArraySectionExpr(Expr /*P*/ Base, SourceLocation LBLoc, 
                        Expr /*P*/ LowerBound, 
                        SourceLocation ColonLoc, Expr /*P*/ Length, 
                        SourceLocation RBLoc) {
  if (Base.getType().$arrow().isPlaceholderType()
     && !Base.getType().$arrow().isSpecificPlaceholderType(BuiltinType.Kind.OMPArraySection.getValue())) {
    ActionResultTTrue<Expr /*P*/ > Result = $this().CheckPlaceholderExpr(Base);
    if (Result.isInvalid()) {
      return ExprError();
    }
    Base = Result.get();
  }
  if ((LowerBound != null) && LowerBound.getType().$arrow().isNonOverloadPlaceholderType()) {
    ActionResultTTrue<Expr /*P*/ > Result = $this().CheckPlaceholderExpr(LowerBound);
    if (Result.isInvalid()) {
      return ExprError();
    }
    Result.$assignMove($this().DefaultLvalueConversion(Result.get()));
    if (Result.isInvalid()) {
      return ExprError();
    }
    LowerBound = Result.get();
  }
  if ((Length != null) && Length.getType().$arrow().isNonOverloadPlaceholderType()) {
    ActionResultTTrue<Expr /*P*/ > Result = $this().CheckPlaceholderExpr(Length);
    if (Result.isInvalid()) {
      return ExprError();
    }
    Result.$assignMove($this().DefaultLvalueConversion(Result.get()));
    if (Result.isInvalid()) {
      return ExprError();
    }
    Length = Result.get();
  }
  
  // Build an unanalyzed expression if either operand is type-dependent.
  if (Base.isTypeDependent()
     || ((LowerBound != null)
     && (LowerBound.isTypeDependent() || LowerBound.isValueDependent()))
     || ((Length != null) && (Length.isTypeDependent() || Length.isValueDependent()))) {
    final Expr /*P*/ L$Base = Base;
    final Expr /*P*/ L$LowerBound = LowerBound;
    final Expr /*P*/ L$Length = Length;
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
            return new OMPArraySectionExpr(L$Base, L$LowerBound, L$Length, $this().Context.DependentTy.$QualType(), 
                    ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, new SourceLocation(ColonLoc), new SourceLocation(RBLoc));
         }));
  }
  
  // Perform default conversions.
  QualType OriginalTy = OMPArraySectionExpr.getBaseOriginalType(Base);
  QualType ResultTy/*J*/= new QualType();
  if (OriginalTy.$arrow().isAnyPointerType()) {
    ResultTy.$assignMove(OriginalTy.$arrow().getPointeeType());
  } else if (OriginalTy.$arrow().isArrayType()) {
    ResultTy.$assignMove(OriginalTy.$arrow().getAsArrayTypeUnsafe().getElementType());
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Base.getExprLoc(), diag.err_omp_typecheck_section_value)), 
              Base.getSourceRange())));
    } finally {
      $c$.$destroy();
    }
  }
  // C99 6.5.2.1p1
  if ((LowerBound != null)) {
    ActionResultTTrue<Expr /*P*/ > Res = $this().PerformOpenMPImplicitIntegerConversion(LowerBound.getExprLoc(), 
        LowerBound);
    if (Res.isInvalid()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(LowerBound.getExprLoc(), 
                        diag.err_omp_typecheck_section_not_integer)), 
                    0), LowerBound.getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
    LowerBound = Res.get();
    if (LowerBound.getType().$arrow().isSpecificBuiltinType(BuiltinType.Kind.Char_S.getValue())
       || LowerBound.getType().$arrow().isSpecificBuiltinType(BuiltinType.Kind.Char_U.getValue())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(LowerBound.getExprLoc(), diag.warn_omp_section_is_char)), 
                0), LowerBound.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
  }
  if ((Length != null)) {
    ActionResultTTrue<Expr /*P*/ > Res = $this().PerformOpenMPImplicitIntegerConversion(Length.getExprLoc(), Length);
    if (Res.isInvalid()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Length.getExprLoc(), 
                        diag.err_omp_typecheck_section_not_integer)), 
                    1), Length.getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
    Length = Res.get();
    if (Length.getType().$arrow().isSpecificBuiltinType(BuiltinType.Kind.Char_S.getValue())
       || Length.getType().$arrow().isSpecificBuiltinType(BuiltinType.Kind.Char_U.getValue())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Length.getExprLoc(), diag.warn_omp_section_is_char)), 
                1), Length.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // C99 6.5.2.1p1: "shall have type "pointer to *object* type". Similarly,
  // C++ [expr.sub]p1: The type "T" shall be a completely-defined object
  // type. Note that functions are not objects, and that (in C99 parlance)
  // incomplete types are not object types.
  if (ResultTy.$arrow().isFunctionType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Base.getExprLoc(), diag.err_omp_section_function_type)), 
              ResultTy), Base.getSourceRange()));
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  if ($this().RequireCompleteType$T(Base.getExprLoc(), new QualType(ResultTy), 
      diag.err_omp_section_incomplete_type, Base)) {
    return ExprError();
  }
  if ((LowerBound != null)) {
    APSInt LowerBoundValue/*J*/= new APSInt();
    if (LowerBound.EvaluateAsInt(LowerBoundValue, $this().Context)) {
      // OpenMP 4.0, [2.4 Array Sections]
      // The lower-bound and length must evaluate to non-negative integers.
      if (LowerBoundValue.isNegative()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(LowerBound.getExprLoc(), diag.err_omp_section_negative)), 
                      0), LowerBoundValue.__toString(/*Radix=*/ 10, /*Signed=*/ true)), 
              LowerBound.getSourceRange()));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  if ((Length != null)) {
    APSInt LengthValue/*J*/= new APSInt();
    if (Length.EvaluateAsInt(LengthValue, $this().Context)) {
      // OpenMP 4.0, [2.4 Array Sections]
      // The lower-bound and length must evaluate to non-negative integers.
      if (LengthValue.isNegative()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Length.getExprLoc(), diag.err_omp_section_negative)), 
                      1), LengthValue.__toString(/*Radix=*/ 10, /*Signed=*/ true)), 
              Length.getSourceRange()));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
    }
  } else if (ColonLoc.isValid()
     && (OriginalTy.isNull() || (!OriginalTy.$arrow().isConstantArrayType()
     && !OriginalTy.$arrow().isVariableArrayType()))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // OpenMP 4.0, [2.4 Array Sections]
      // When the size of the array dimension is not known, the length must be
      // specified explicitly.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ColonLoc), diag.err_omp_section_length_undefined)), 
          (!OriginalTy.isNull() && OriginalTy.$arrow().isArrayType())));
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  if (!Base.getType().$arrow().isSpecificPlaceholderType(BuiltinType.Kind.OMPArraySection.getValue())) {
    ActionResultTTrue<Expr /*P*/ > Result = $this().DefaultFunctionArrayLvalueConversion(Base);
    if (Result.isInvalid()) {
      return ExprError();
    }
    Base = Result.get();
  }
    final Expr /*P*/ L$Base = Base;
    final Expr /*P*/ L$LowerBound = LowerBound;
    final Expr /*P*/ L$Length = Length;  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new OMPArraySectionExpr(L$Base, L$LowerBound, L$Length, $this().Context.OMPArraySectionTy.$QualType(), 
                  ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, new SourceLocation(ColonLoc), new SourceLocation(RBLoc));
       }));
}


/// ConvertArgumentsForCall - Converts the arguments specified in
/// Args/NumArgs to the parameter types of the function FDecl with
/// function prototype Proto. Call is the call expression itself, and
/// Fn is the function expression. For a C++ member function, this
/// routine does not attempt to convert the object argument. Returns
/// true if the call is ill-formed.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ConvertArgumentsForCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 4685,
 FQN="clang::Sema::ConvertArgumentsForCall", NM="_ZN5clang4Sema23ConvertArgumentsForCallEPNS_8CallExprEPNS_4ExprEPNS_12FunctionDeclEPKNS_17FunctionProtoTypeEN4llvm8ArrayRefIS4_EENS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema23ConvertArgumentsForCallEPNS_8CallExprEPNS_4ExprEPNS_12FunctionDeclEPKNS_17FunctionProtoTypeEN4llvm8ArrayRefIS4_EENS_14SourceLocationEb")
//</editor-fold>
public final boolean ConvertArgumentsForCall(CallExpr /*P*/ Call, Expr /*P*/ Fn, 
                       FunctionDecl /*P*/ FDecl, 
                       /*const*/ FunctionProtoType /*P*/ Proto, 
                       ArrayRef<Expr /*P*/ > Args, 
                       SourceLocation RParenLoc) {
  return ConvertArgumentsForCall(Call, Fn, 
                       FDecl, 
                       Proto, 
                       Args, 
                       RParenLoc, 
                       false);
}
public final boolean ConvertArgumentsForCall(CallExpr /*P*/ Call, Expr /*P*/ Fn, 
                       FunctionDecl /*P*/ FDecl, 
                       /*const*/ FunctionProtoType /*P*/ Proto, 
                       ArrayRef<Expr /*P*/ > Args, 
                       SourceLocation RParenLoc, 
                       boolean IsExecConfig/*= false*/) {
  // Bail out early if calling a builtin with custom typechecking.
  if ((FDecl != null)) {
    {
      /*uint*/int ID = FDecl.getBuiltinID();
      if ((ID != 0)) {
        if ($this().Context.BuiltinInfo.hasCustomTypechecking(ID)) {
          return false;
        }
      }
    }
  }
  
  // C99 6.5.2.2p7 - the arguments are implicitly converted, as if by
  // assignment, to the types of the corresponding parameter, ...
  /*uint*/int NumParams = Proto.getNumParams();
  boolean Invalid = false;
  /*uint*/int MinArgs = (FDecl != null) ? FDecl.getMinRequiredArguments() : NumParams;
  /*uint*/int FnKind = Fn.getType().$arrow().isBlockPointerType() ? 1/* block */ : (IsExecConfig ? 3/* kernel function (exec config) */ : 0/* function */);
  
  // If too few arguments are available (and we don't have default
  // arguments for the remaining parameters), don't make the call.
  if ($less_uint(Args.size(), NumParams)) {
    if ($less_uint(Args.size(), MinArgs)) {
      TypoCorrection TC = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        TC/*J*/= new TypoCorrection();
        if ($c$.clean((FDecl != null) && (TC.$assignMove($c$.track(TryTypoCorrectionForCall(/*Deref*/$this(), Fn, FDecl, new ArrayRef<Expr /*P*/ >(Args))))).$bool())) {
          /*uint*/int diag_id = MinArgs == NumParams && !Proto.isVariadic() ? diag.err_typecheck_call_too_few_args_suggest : diag.err_typecheck_call_too_few_args_at_least_suggest;
          $this().diagnoseTypo(TC, $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_uint($out_PartialDiagnostic$C_uint($out_PartialDiagnostic$C_uint($c$.track($this().PDiag(diag_id)), FnKind), MinArgs), 
                      ((/*static_cast*//*uint*/int)(Args.size()))), 
                  TC.getCorrectionRange())); $c$.clean();
        } else if (MinArgs == 1 && (FDecl != null) && FDecl.getParamDecl(0).getDeclName().$bool()) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(RParenLoc), 
                          MinArgs == NumParams && !Proto.isVariadic() ? diag.err_typecheck_call_too_few_args_one : diag.err_typecheck_call_too_few_args_at_least_one)), 
                      FnKind), FDecl.getParamDecl(0)), Fn.getSourceRange()));
        } else {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(RParenLoc), MinArgs == NumParams && !Proto.isVariadic() ? diag.err_typecheck_call_too_few_args : diag.err_typecheck_call_too_few_args_at_least)), 
                          FnKind), MinArgs), ((/*static_cast*//*uint*/int)(Args.size()))), 
              Fn.getSourceRange()));
        }
        
        // Emit the location of the prototype.
        if (!TC.$bool() && (FDecl != null) && !(FDecl.getBuiltinID() != 0) && !IsExecConfig) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FDecl.getLocStart(), diag.note_callee_decl)), 
              FDecl));
        }
        
        return true;
      } finally {
        if (TC != null) { TC.$destroy(); }
        $c$.$destroy();
      }
    }
    Call.setNumArgs($this().Context, NumParams);
  }
  
  // If too many are passed and not variadic, error on the extras and drop
  // them.
  if ($greater_uint(Args.size(), NumParams)) {
    if (!Proto.isVariadic()) {
      TypoCorrection TC = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        TC/*J*/= new TypoCorrection();
        if ($c$.clean((FDecl != null) && (TC.$assignMove($c$.track(TryTypoCorrectionForCall(/*Deref*/$this(), Fn, FDecl, new ArrayRef<Expr /*P*/ >(Args))))).$bool())) {
          /*uint*/int diag_id = MinArgs == NumParams && !Proto.isVariadic() ? diag.err_typecheck_call_too_many_args_suggest : diag.err_typecheck_call_too_many_args_at_most_suggest;
          $this().diagnoseTypo(TC, $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_uint($out_PartialDiagnostic$C_uint($out_PartialDiagnostic$C_uint($c$.track($this().PDiag(diag_id)), FnKind), NumParams), 
                      ((/*static_cast*//*uint*/int)(Args.size()))), 
                  TC.getCorrectionRange())); $c$.clean();
        } else if (NumParams == 1 && (FDecl != null)
           && FDecl.getParamDecl(0).getDeclName().$bool()) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Args.$at(NumParams).getLocStart(), 
                                  MinArgs == NumParams ? diag.err_typecheck_call_too_many_args_one : diag.err_typecheck_call_too_many_args_at_most_one)), 
                              FnKind), FDecl.getParamDecl(0)), 
                      ((/*static_cast*//*uint*/int)(Args.size()))), Fn.getSourceRange()), 
              new SourceRange(Args.$at(NumParams).getLocStart(), 
                  Args.back().getLocEnd())));
        } else {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Args.$at(NumParams).getLocStart(), 
                                  MinArgs == NumParams ? diag.err_typecheck_call_too_many_args : diag.err_typecheck_call_too_many_args_at_most)), 
                              FnKind), NumParams), ((/*static_cast*//*uint*/int)(Args.size()))), 
                  Fn.getSourceRange()), 
              new SourceRange(Args.$at(NumParams).getLocStart(), 
                  Args.back().getLocEnd())));
        }
        
        // Emit the location of the prototype.
        if (!TC.$bool() && (FDecl != null) && !(FDecl.getBuiltinID() != 0) && !IsExecConfig) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FDecl.getLocStart(), diag.note_callee_decl)), 
              FDecl));
        }
        
        // This deletes the extra arguments.
        Call.setNumArgs($this().Context, NumParams);
        return true;
      } finally {
        if (TC != null) { TC.$destroy(); }
        $c$.$destroy();
      }
    }
  }
  SmallVector<Expr /*P*/ > AllArgs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  VariadicCallType CallType = $this().getVariadicCallType(FDecl, Proto, Fn);
  
  Invalid = $this().GatherArgumentsForCall(Call.getLocStart(), FDecl, 
      Proto, 0, new ArrayRef<Expr /*P*/ >(Args), AllArgs, CallType);
  if (Invalid) {
    return true;
  }
  /*uint*/int TotalNumArgs = AllArgs.size();
  for (/*uint*/int i = 0; $less_uint(i, TotalNumArgs); ++i)  {
    Call.setArg(i, AllArgs.$at(i));
  }
  
  return false;
}


/// CheckStaticArrayArgument - If the given argument corresponds to a static
/// array parameter, check that it is non-null, and that if it is formed by
/// array-to-pointer decay, the underlying array is sufficiently large.
///
/// C99 6.7.5.3p7: If the keyword static also appears within the [ and ] of the
/// array type derivation, then for each call to the function, the value of the
/// corresponding actual argument shall provide access to the first element of
/// an array with at least as many elements as specified by the size expression.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckStaticArrayArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 4919,
 FQN="clang::Sema::CheckStaticArrayArgument", NM="_ZN5clang4Sema24CheckStaticArrayArgumentENS_14SourceLocationEPNS_11ParmVarDeclEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema24CheckStaticArrayArgumentENS_14SourceLocationEPNS_11ParmVarDeclEPKNS_4ExprE")
//</editor-fold>
public final void CheckStaticArrayArgument(SourceLocation CallLoc, 
                        ParmVarDecl /*P*/ Param, 
                        /*const*/ Expr /*P*/ ArgExpr) {
  // Static array parameters are not supported in C++.
  if (!(Param != null) || $this().getLangOpts().CPlusPlus) {
    return;
  }
  
  QualType OrigTy = Param.getOriginalType();
  
  /*const*/ ArrayType /*P*/ AT = $this().Context.getAsArrayType(new QualType(OrigTy));
  if (!(AT != null) || AT.getSizeModifier() != ArrayType.ArraySizeModifier.Static) {
    return;
  }
  if ((ArgExpr.isNullPointerConstant($this().Context, 
      Expr.NullPointerConstantValueDependence.NPC_NeverValueDependent).getValue() != 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(CallLoc), diag.warn_null_arg)), ArgExpr.getSourceRange()));
      DiagnoseCalleeStaticArrayParam(/*Deref*/$this(), Param);
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  /*const*/ ConstantArrayType /*P*/ CAT = dyn_cast_ConstantArrayType(AT);
  if (!(CAT != null)) {
    return;
  }
  
  /*const*/ ConstantArrayType /*P*/ ArgCAT = $this().Context.getAsConstantArrayType(ArgExpr.IgnoreParenImpCasts$Const().getType());
  if (!(ArgCAT != null)) {
    return;
  }
  if (ArgCAT.getSize().ult(CAT.getSize())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(CallLoc), diag.warn_static_array_too_small)), 
                  ArgExpr.getSourceRange()), 
              (/*uint*/int)$ulong2uint(ArgCAT.getSize().getZExtValue())), 
          (/*uint*/int)$ulong2uint(CAT.getSize().getZExtValue())));
      DiagnoseCalleeStaticArrayParam(/*Deref*/$this(), Param);
    } finally {
      $c$.$destroy();
    }
  }
}


/// ActOnCallExpr - Handle a call to Fn with the specified array of arguments.
/// This provides the location of the left/right parens and a list of comma
/// locations.

/// ActOnCallExpr - Handle a call to Fn with the specified array of arguments.
/// This provides the location of the left/right parens and a list of comma
/// locations.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCallExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 5114,
 FQN="clang::Sema::ActOnCallExpr", NM="_ZN5clang4Sema13ActOnCallExprEPNS_5ScopeEPNS_4ExprENS_14SourceLocationEN4llvm15MutableArrayRefIS4_EES5_S4_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema13ActOnCallExprEPNS_5ScopeEPNS_4ExprENS_14SourceLocationEN4llvm15MutableArrayRefIS4_EES5_S4_b")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnCallExpr(Scope /*P*/ S, Expr /*P*/ Fn, SourceLocation LParenLoc, 
             MutableArrayRef<Expr /*P*/ > ArgExprs, SourceLocation RParenLoc) {
  return ActOnCallExpr(S, Fn, LParenLoc, 
             ArgExprs, RParenLoc, 
             (Expr /*P*/ )null, false);
}
public final ActionResultTTrue<Expr /*P*/ > ActOnCallExpr(Scope /*P*/ S, Expr /*P*/ Fn, SourceLocation LParenLoc, 
             MutableArrayRef<Expr /*P*/ > ArgExprs, SourceLocation RParenLoc, 
             Expr /*P*/ ExecConfig/*= null*/) {
  return ActOnCallExpr(S, Fn, LParenLoc, 
             ArgExprs, RParenLoc, 
             ExecConfig, false);
}
public final ActionResultTTrue<Expr /*P*/ > ActOnCallExpr(Scope /*P*/ S, Expr /*P*/ Fn, SourceLocation LParenLoc, 
             MutableArrayRef<Expr /*P*/ > ArgExprs, SourceLocation RParenLoc, 
             Expr /*P*/ ExecConfig/*= null*/, boolean IsExecConfig/*= false*/) {
  // Since this might be a postfix expression, get rid of ParenListExprs.
  ActionResultTTrue<Expr /*P*/ > Result = $this().MaybeConvertParenListExprToParenExpr(S, Fn);
  if (Result.isInvalid()) {
    return ExprError();
  }
  Fn = Result.get();
  if (checkArgsForPlaceholders(/*Deref*/$this(), new MutableArrayRef<Expr /*P*/ >(ArgExprs))) {
    return ExprError();
  }
  if ($this().getLangOpts().CPlusPlus) {
    // If this is a pseudo-destructor expression, build the call immediately.
    if (isa_CXXPseudoDestructorExpr(Fn)) {
      if (!ArgExprs.empty()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Pseudo-destructor calls should not have any arguments.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Fn.getLocStart(), diag.err_pseudo_dtor_call_with_args)), 
              FixItHint.CreateRemoval(new SourceRange(ArgExprs.front().getLocStart(), 
                      ArgExprs.back().getLocEnd()))));
        } finally {
          $c$.$destroy();
        }
      }
      
      final Expr /*P*/ L$Fn = Fn;
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
              return new CallExpr($this().Context, L$Fn, new ArrayRef<Expr /*P*/ >(None, true), $this().Context.VoidTy.$QualType(), ExprValueKind.VK_RValue, new SourceLocation(RParenLoc));
           }));
    }
    if ($eq_QualType$C(Fn.getType(), $this().Context.PseudoObjectTy.$QualType())) {
      ActionResultTTrue<Expr /*P*/ > result = $this().CheckPlaceholderExpr(Fn);
      if (result.isInvalid()) {
        return ExprError();
      }
      Fn = result.get();
    }
    
    // Determine whether this is a dependent call inside a C++ template,
    // in which case we won't do any semantic analysis now.
    boolean Dependent = false;
    if (Fn.isTypeDependent()) {
      Dependent = true;
    } else if (Expr.hasAnyTypeDependentArguments(new ArrayRef<Expr /*P*/ >(ArgExprs))) {
      Dependent = true;
    }
    if (Dependent) {
      final Expr /*P*/ L$Fn = Fn;
      if ((ExecConfig != null)) {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
                return new CUDAKernelCallExpr($this().Context, L$Fn, cast_CallExpr(ExecConfig), new ArrayRef<Expr /*P*/ >(ArgExprs), 
                        $this().Context.DependentTy.$QualType(), ExprValueKind.VK_RValue, new SourceLocation(RParenLoc));
             }));
      } else {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
                return new CallExpr($this().Context, L$Fn, new ArrayRef<Expr /*P*/ >(ArgExprs), $this().Context.DependentTy.$QualType(), ExprValueKind.VK_RValue, new SourceLocation(RParenLoc));
             }));
      }
    }
    
    // Determine whether this is a call to an object (C++ [over.call.object]).
    if (Fn.getType().$arrow().isRecordType()) {
      return $this().BuildCallToObjectOfClassType(S, Fn, new SourceLocation(LParenLoc), new MutableArrayRef<Expr /*P*/ >(ArgExprs), 
          new SourceLocation(RParenLoc));
    }
    if ($eq_QualType$C(Fn.getType(), $this().Context.UnknownAnyTy.$QualType())) {
      ActionResultTTrue<Expr /*P*/ > result = rebuildUnknownAnyFunction(/*Deref*/$this(), Fn);
      if (result.isInvalid()) {
        return ExprError();
      }
      Fn = result.get();
    }
    if ($eq_QualType$C(Fn.getType(), $this().Context.BoundMemberTy.$QualType())) {
      return $this().BuildCallToMemberFunction(S, Fn, new SourceLocation(LParenLoc), new MutableArrayRef<Expr /*P*/ >(ArgExprs), new SourceLocation(RParenLoc));
    }
  }
  
  // Check for overloaded calls.  This can happen even in C due to extensions.
  if ($eq_QualType$C(Fn.getType(), $this().Context.OverloadTy.$QualType())) {
    OverloadExpr.FindResult find = OverloadExpr.find(Fn);
    
    // We aren't supposed to apply this logic for if there's an '&' involved.
    if (!find.HasFormOfMemberPointer) {
      OverloadExpr /*P*/ ovl = find.Expression;
      {
        UnresolvedLookupExpr /*P*/ ULE = dyn_cast_UnresolvedLookupExpr(ovl);
        if ((ULE != null)) {
          return $this().BuildOverloadedCallExpr(S, Fn, ULE, new SourceLocation(LParenLoc), new MutableArrayRef<Expr /*P*/ >(ArgExprs), 
              new SourceLocation(RParenLoc), ExecConfig, 
              /*AllowTypoCorrection=*/ true, 
              find.IsAddressOfOperand);
        }
      }
      return $this().BuildCallToMemberFunction(S, Fn, new SourceLocation(LParenLoc), new MutableArrayRef<Expr /*P*/ >(ArgExprs), new SourceLocation(RParenLoc));
    }
  }
  
  // If we're directly calling a function, get the appropriate declaration.
  if ($eq_QualType$C(Fn.getType(), $this().Context.UnknownAnyTy.$QualType())) {
    ActionResultTTrue<Expr /*P*/ > result = rebuildUnknownAnyFunction(/*Deref*/$this(), Fn);
    if (result.isInvalid()) {
      return ExprError();
    }
    Fn = result.get();
  }
  
  Expr /*P*/ NakedFn = Fn.IgnoreParens();
  
  boolean CallingNDeclIndirectly = false;
  NamedDecl /*P*/ NDecl = null;
  {
    UnaryOperator /*P*/ UnOp = dyn_cast_UnaryOperator(NakedFn);
    if ((UnOp != null)) {
      if (UnOp.getOpcode() == UnaryOperatorKind.UO_AddrOf) {
        CallingNDeclIndirectly = true;
        NakedFn = UnOp.getSubExpr().IgnoreParens();
      }
    }
  }
  if (isa_DeclRefExpr(NakedFn)) {
    NDecl = cast_DeclRefExpr(NakedFn).getDecl();
    
    FunctionDecl /*P*/ FDecl = dyn_cast_FunctionDecl(NDecl);
    if ((FDecl != null) && (FDecl.getBuiltinID() != 0)) {
      // Rewrite the function decl for this builtin by replacing parameters
      // with no explicit address space with the address space of the arguments
      // in ArgExprs.
      if (((FDecl = rewriteBuiltinFunctionDecl($this(), $this().Context, FDecl, new MutableArrayRef<Expr /*P*/ >(ArgExprs))) != null)) {
        NDecl = FDecl;
        Fn = DeclRefExpr.Create($this().Context, FDecl.getQualifierLoc(), 
            new SourceLocation(), FDecl, false, 
            new SourceLocation(), FDecl.getType(), 
            Fn.getValueKind(), FDecl);
      }
    }
  } else if (isa_MemberExpr(NakedFn)) {
    NDecl = cast_MemberExpr(NakedFn).getMemberDecl();
  }
  {
    
    FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(NDecl);
    if ((FD != null)) {
      if (CallingNDeclIndirectly
         && !$this().checkAddressOfFunctionIsAvailable(FD, /*Complain=*/ true, 
          Fn.getLocStart())) {
        return ExprError();
      }
      
      // CheckEnableIf assumes that the we're passing in a sane number of args for
      // FD, but that doesn't always hold true here. This is because, in some
      // cases, we'll emit a diag about an ill-formed function call, but then
      // we'll continue on as if the function call wasn't ill-formed. So, if the
      // number of args looks incorrect, don't do enable_if checks; we should've
      // already emitted an error about the bad call.
      if (FD.hasAttr(EnableIfAttr.class)
         && isNumberOfArgsValidForCall(/*Deref*/$this(), FD, ArgExprs.size())) {
        {
          /*const*/ EnableIfAttr /*P*/ Attr = $this().CheckEnableIf(FD, new ArrayRef<Expr /*P*/ >(ArgExprs), true);
          if ((Attr != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Fn.getLocStart(), 
                          isa_CXXMethodDecl(FD) ? diag.err_ovl_no_viable_member_function_in_call : diag.err_ovl_no_viable_function_in_call)), 
                      FD), FD.getSourceRange()));
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getLocation(), 
                          diag.note_ovl_candidate_disabled_by_enable_if_attr)), 
                      Attr.getCond().getSourceRange()), Attr.getMessage()));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
  }
  
  return $this().BuildResolvedCallExpr(Fn, NDecl, new SourceLocation(LParenLoc), new ArrayRef<Expr /*P*/ >(ArgExprs), new SourceLocation(RParenLoc), 
      ExecConfig, IsExecConfig);
}


/// BuildResolvedCallExpr - Build a call to a resolved expression,
/// i.e. an expression not of \p OverloadTy.  The expression should
/// unary-convert to an expression of function-pointer or
/// block-pointer type.
///
/// \param NDecl the declaration being called, if available
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildResolvedCallExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 5304,
 FQN="clang::Sema::BuildResolvedCallExpr", NM="_ZN5clang4Sema21BuildResolvedCallExprEPNS_4ExprEPNS_9NamedDeclENS_14SourceLocationEN4llvm8ArrayRefIS2_EES5_S2_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema21BuildResolvedCallExprEPNS_4ExprEPNS_9NamedDeclENS_14SourceLocationEN4llvm8ArrayRefIS2_EES5_S2_b")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildResolvedCallExpr(Expr /*P*/ Fn, NamedDecl /*P*/ NDecl, 
                     SourceLocation LParenLoc, 
                     ArrayRef<Expr /*P*/ > Args, 
                     SourceLocation RParenLoc) {
  return BuildResolvedCallExpr(Fn, NDecl, 
                     LParenLoc, 
                     Args, 
                     RParenLoc, 
                     (Expr /*P*/ )null, false);
}
public final ActionResultTTrue<Expr /*P*/ > BuildResolvedCallExpr(Expr /*P*/ Fn, NamedDecl /*P*/ NDecl, 
                     SourceLocation LParenLoc, 
                     ArrayRef<Expr /*P*/ > Args, 
                     SourceLocation RParenLoc, 
                     Expr /*P*/ Config/*= null*/) {
  return BuildResolvedCallExpr(Fn, NDecl, 
                     LParenLoc, 
                     Args, 
                     RParenLoc, 
                     Config, false);
}
public final ActionResultTTrue<Expr /*P*/ > BuildResolvedCallExpr(Expr /*P*/ Fn, NamedDecl /*P*/ NDecl, 
                     SourceLocation LParenLoc, 
                     ArrayRef<Expr /*P*/ > Args, 
                     SourceLocation RParenLoc, 
                     Expr /*P*/ Config/*= null*/, boolean IsExecConfig/*= false*/) {
  FunctionDecl /*P*/ FDecl = dyn_cast_or_null_FunctionDecl(NDecl);
  /*uint*/int BuiltinID = ((FDecl != null) ? FDecl.getBuiltinID() : 0);
  
  // Functions with 'interrupt' attribute cannot be called directly.
  if ((FDecl != null) && FDecl.hasAttr(AnyX86InterruptAttr.class)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(Fn.getExprLoc(), diag.err_anyx86_interrupt_called)));
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  
  // Promote the function operand.
  // We special-case function promotion here because we only allow promoting
  // builtin functions to function pointers in the callee of a call.
  ActionResultTTrue<Expr /*P*/ > Result/*J*/= new ActionResultTTrue<Expr /*P*/ >();
  if ((BuiltinID != 0)
     && Fn.getType().$arrow().isSpecificBuiltinType(BuiltinType.Kind.BuiltinFn.getValue())) {
    Result.$assign($this().ImpCastExprToType(Fn, $this().Context.getPointerType(FDecl.getType()), 
            CastKind.CK_BuiltinFnToFnPtr).get());
  } else {
    Result.$assignMove($this().CallExprUnaryConversions(Fn));
  }
  if (Result.isInvalid()) {
    return ExprError();
  }
  Fn = Result.get();
  
  // Make the call expr early, before semantic checks.  This guarantees cleanup
  // of arguments and function on error.
  CallExpr /*P*/ TheCall;
  final Expr /*P*/ L$Fn = Fn;
  if ((Config != null)) {
    TheCall = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
        return new CUDAKernelCallExpr($this().Context, L$Fn, 
                cast_CallExpr(Config), new ArrayRef<Expr /*P*/ >(Args), 
                $this().Context.BoolTy.$QualType(), ExprValueKind.VK_RValue, 
                new SourceLocation(RParenLoc));
     });
  } else {
    TheCall = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
        return new CallExpr($this().Context, L$Fn, new ArrayRef<Expr /*P*/ >(Args), $this().Context.BoolTy.$QualType(), 
                ExprValueKind.VK_RValue, new SourceLocation(RParenLoc));
     });
  }
  if (!$this().getLangOpts().CPlusPlus) {
    // C cannot always handle TypoExpr nodes in builtin calls and direct
    // function calls as their argument checking don't necessarily handle
    // dependent types properly, so make sure any TypoExprs have been
    // dealt with.
    ActionResultTTrue<Expr /*P*/ > Result$1 = $this().CorrectDelayedTyposInExpr(TheCall);
    if (!Result$1.isUsable()) {
      return ExprError();
    }
    TheCall = dyn_cast_CallExpr(Result$1.get());
    if (!(TheCall != null)) {
      return Result$1;
    }
    Args.$assignMove(llvm.makeArrayRef(TheCall.getArgs(), TheCall.getNumArgs()));
  }
  
  // Bail out early if calling a builtin with custom typechecking.
  if ((BuiltinID != 0) && $this().Context.BuiltinInfo.hasCustomTypechecking(BuiltinID)) {
    return $this().CheckBuiltinFunctionCall(FDecl, BuiltinID, TheCall);
  }
 //retry:
  /*const*/ FunctionType /*P*/ FuncT;
  while(true) {
    /*const*/ PointerType /*P*/ PT = Fn.getType().$arrow().getAs(PointerType.class);
    if ((PT != null)) {
      // C99 6.5.2.2p1 - "The expression that denotes the called function shall
      // have type pointer to function".
      FuncT = PT.getPointeeType().$arrow().getAs(FunctionType.class);
      if (!(FuncT != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LParenLoc), diag.err_typecheck_call_not_function)), 
                      Fn.getType()), Fn.getSourceRange())));
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      /*const*/ BlockPointerType /*P*/ BPT = Fn.getType().$arrow().getAs(BlockPointerType.class);
      if ((BPT != null)) {
        FuncT = BPT.getPointeeType().$arrow().castAs(FunctionType.class);
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Handle calls to expressions of unknown-any type.
          if ($eq_QualType$C(Fn.getType(), $this().Context.UnknownAnyTy.$QualType())) {
            ActionResultTTrue<Expr /*P*/ > rewrite = rebuildUnknownAnyFunction(/*Deref*/$this(), Fn);
            if (rewrite.isInvalid()) {
              return ExprError();
            }
            Fn = rewrite.get();
            TheCall.setCallee(Fn);
            continue;//goto retry;
          }
          
          return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LParenLoc), diag.err_typecheck_call_not_function)), 
                      Fn.getType()), Fn.getSourceRange())));
        } finally {
          $c$.$destroy();
        }
      }
    }
    break;
  }
  if ($this().getLangOpts().CUDA) {
    if ((Config != null)) {
      // CUDA: Kernel calls must be to global functions
      if ((FDecl != null) && !FDecl.hasAttr(CUDAGlobalAttr.class)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LParenLoc), diag.err_kern_call_not_global_function)), 
                      FDecl.getName()), Fn.getSourceRange())));
        } finally {
          $c$.$destroy();
        }
      }
      
      // CUDA: Kernel function must have 'void' return type
      if (!FuncT.getReturnType().$arrow().isVoidType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LParenLoc), diag.err_kern_type_not_void_return)), 
                      Fn.getType()), Fn.getSourceRange())));
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      // CUDA: Calls to global functions must be configured
      if ((FDecl != null) && FDecl.hasAttr(CUDAGlobalAttr.class)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LParenLoc), diag.err_global_call_not_config)), 
                      FDecl.getName()), Fn.getSourceRange())));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // Check for a valid return type
  if ($this().CheckCallReturnType(FuncT.getReturnType(), Fn.getLocStart(), TheCall, 
      FDecl)) {
    return ExprError();
  }
  
  // We know the result type of the call, set it.
  TheCall.setType(FuncT.getCallResultType($this().Context));
  TheCall.setValueKind(Expr.getValueKindForType(FuncT.getReturnType()));
  
  /*const*/ FunctionProtoType /*P*/ Proto = dyn_cast_FunctionProtoType(FuncT);
  if ((Proto != null)) {
    if ($this().ConvertArgumentsForCall(TheCall, Fn, FDecl, Proto, new ArrayRef<Expr /*P*/ >(Args), new SourceLocation(RParenLoc), 
        IsExecConfig)) {
      return ExprError();
    }
  } else {
    assert (isa_FunctionNoProtoType(FuncT)) : "Unknown FunctionType!";
    if ((FDecl != null)) {
      // Check if we have too few/too many template arguments, based
      // on our knowledge of the function definition.
      type$ref</*const*/ FunctionDecl /*P*/ > Def = create_type$null$ref(null);
      if (FDecl.hasBody(Def) && Args.size() != Def.$deref().param_size()) {
        Proto = Def.$deref().getType().$arrow().getAs(FunctionProtoType.class);
        if (!(Proto != null) || !(Proto.isVariadic() && $greatereq_uint(Args.size(), Def.$deref().param_size()))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(RParenLoc), diag.warn_call_wrong_number_of_arguments)), 
                        ($greater_uint(Args.size(), Def.$deref().param_size()))), FDecl), Fn.getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      // If the function we're calling isn't a function prototype, but we have
      // a function prototype from a prior declaratiom, use that prototype.
      if (!FDecl.hasPrototype()) {
        Proto = FDecl.getType().$arrow().getAs(FunctionProtoType.class);
      }
    }
    
    // Promote the arguments (C99 6.5.2.2p6).
    for (/*uint*/int i = 0, e = Args.size(); i != e; i++) {
      Expr /*P*/ Arg = Args.$at(i);
      if ((Proto != null) && $less_uint(i, Proto.getNumParams())) {
        InitializedEntity Entity = InitializedEntity.InitializeParameter($this().Context, Proto.getParamType(i), Proto.isParamConsumed(i));
        ActionResultTTrue<Expr /*P*/ > ArgE = $this().PerformCopyInitialization(Entity, new SourceLocation(), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Arg));
        if (ArgE.isInvalid()) {
          return new ActionResultTTrue<Expr /*P*/ >(true);
        }
        
        Arg = ArgE.getAs(Expr.class);
      } else {
        ActionResultTTrue<Expr /*P*/ > ArgE = $this().DefaultArgumentPromotion(Arg);
        if (ArgE.isInvalid()) {
          return new ActionResultTTrue<Expr /*P*/ >(true);
        }
        
        Arg = ArgE.getAs(Expr.class);
      }
      if ($this().RequireCompleteType$T(Arg.getLocStart(), 
          Arg.getType(), 
          diag.err_call_incomplete_argument, Arg)) {
        return ExprError();
      }
      
      TheCall.setArg(i, Arg);
    }
  }
  {
    
    CXXMethodDecl /*P*/ Method = dyn_cast_or_null_CXXMethodDecl(FDecl);
    if ((Method != null)) {
      if (!Method.isStatic()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LParenLoc), diag.err_member_call_without_object)), 
                  Fn.getSourceRange())));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // Check for sentinels
  if ((NDecl != null)) {
    $this().DiagnoseSentinelCalls(NDecl, new SourceLocation(LParenLoc), new ArrayRef<Expr /*P*/ >(Args));
  }
  
  // Do special checking on direct calls to functions.
  if ((FDecl != null)) {
    if ($this().CheckFunctionCall(FDecl, TheCall, Proto)) {
      return ExprError();
    }
    if ((BuiltinID != 0)) {
      return $this().CheckBuiltinFunctionCall(FDecl, BuiltinID, TheCall);
    }
  } else if ((NDecl != null)) {
    if ($this().CheckPointerCall(NDecl, TheCall, Proto)) {
      return ExprError();
    }
  } else {
    if ($this().CheckOtherCall(TheCall, Proto)) {
      return ExprError();
    }
  }
  
  return $this().MaybeBindToTemporary(TheCall);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCastExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 5935,
 FQN="clang::Sema::ActOnCastExpr", NM="_ZN5clang4Sema13ActOnCastExprEPNS_5ScopeENS_14SourceLocationERNS_10DeclaratorERNS_9OpaquePtrINS_8QualTypeEEES3_PNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema13ActOnCastExprEPNS_5ScopeENS_14SourceLocationERNS_10DeclaratorERNS_9OpaquePtrINS_8QualTypeEEES3_PNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnCastExpr(Scope /*P*/ S, SourceLocation LParenLoc, 
             final Declarator /*&*/ D, final OpaquePtr<QualType> /*&*/ Ty, 
             SourceLocation RParenLoc, Expr /*P*/ CastExpr) {
  assert (!D.isInvalidType() && (CastExpr != null)) : "ActOnCastExpr(): missing type or expr";
  
  TypeSourceInfo /*P*/ castTInfo = $this().GetTypeForDeclaratorCast(D, CastExpr.getType());
  if (D.isInvalidType()) {
    return ExprError();
  }
  if ($this().getLangOpts().CPlusPlus) {
    // Check that there are no default arguments (C++ only).
    $this().CheckExtraCXXDefaultArguments(D);
  } else {
    // Make sure any TypoExprs have been dealt with.
    ActionResultTTrue<Expr /*P*/ > Res = $this().CorrectDelayedTyposInExpr(CastExpr);
    if (!Res.isUsable()) {
      return ExprError();
    }
    CastExpr = Res.get();
  }
  
  $this().checkUnusedDeclAttributes(D);
  
  QualType castType = castTInfo.getType();
  Ty.$assignMove($this().CreateParsedType(new QualType(castType), castTInfo));
  
  boolean isVectorLiteral = false;
  
  // Check for an altivec or OpenCL literal,
  // i.e. all the elements are integer constants.
  ParenExpr /*P*/ PE = dyn_cast_ParenExpr(CastExpr);
  ParenListExpr /*P*/ PLE = dyn_cast_ParenListExpr(CastExpr);
  if (($this().getLangOpts().AltiVec || $this().getLangOpts().ZVector || $this().getLangOpts().OpenCL)
     && castType.$arrow().isVectorType() && ((PE != null) || (PLE != null))) {
    if ((PLE != null) && PLE.getNumExprs() == 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(PLE.getExprLoc(), diag.err_altivec_empty_initializer)));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    if ((PE != null) || PLE.getNumExprs() == 1) {
      Expr /*P*/ E = ((PE != null) ? PE.getSubExpr() : PLE.getExpr(0));
      if (!E.getType().$arrow().isVectorType()) {
        isVectorLiteral = true;
      }
    } else {
      isVectorLiteral = true;
    }
  }
  
  // If this is a vector initializer, '(' type ')' '(' init, ..., init ')'
  // then handle it as such.
  if (isVectorLiteral) {
    return $this().BuildVectorLiteral(new SourceLocation(LParenLoc), new SourceLocation(RParenLoc), CastExpr, castTInfo);
  }
  
  // If the Expr being casted is a ParenListExpr, handle it specially.
  // This is not an AltiVec-style cast, so turn the ParenListExpr into a
  // sequence of BinOp comma operators.
  if (isa_ParenListExpr(CastExpr)) {
    ActionResultTTrue<Expr /*P*/ > Result = $this().MaybeConvertParenListExprToParenExpr(S, CastExpr);
    if (Result.isInvalid()) {
      return ExprError();
    }
    CastExpr = Result.get();
  }
  if ($this().getLangOpts().CPlusPlus && !castType.$arrow().isVoidType()
     && !$this().getSourceManager().isInSystemMacro(/*NO_COPY*/LParenLoc)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LParenLoc), diag.warn_old_style_cast)), CastExpr.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
  
  $this().CheckTollFreeBridgeCast(new QualType(castType), CastExpr);
  
  $this().CheckObjCBridgeRelatedCast(new QualType(castType), CastExpr);
  
  return $this().BuildCStyleCastExpr(new SourceLocation(LParenLoc), castTInfo, new SourceLocation(RParenLoc), CastExpr);
}


/// Prepares for a scalar cast, performing all the necessary stages
/// except the final cast and returning the kind required.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PrepareScalarCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 5621,
 FQN="clang::Sema::PrepareScalarCast", NM="_ZN5clang4Sema17PrepareScalarCastERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema17PrepareScalarCastERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeE")
//</editor-fold>
public final CastKind PrepareScalarCast(final ActionResultTTrue<Expr /*P*/ > /*&*/ Src, QualType DestTy) {
  // Both Src and Dest are scalar types, i.e. arithmetic or pointer.
  // Also, callers should have filtered out the invalid cases with
  // pointers.  Everything else should be possible.
  QualType SrcTy = Src.get().getType();
  if ($this().Context.hasSameUnqualifiedType(new QualType(SrcTy), new QualType(DestTy))) {
    return CastKind.CK_NoOp;
  }
  {
    
    Type.ScalarTypeKind SrcKind = SrcTy.$arrow().getScalarTypeKind();
    switch (SrcKind) {
     case STK_MemberPointer:
      throw new llvm_unreachable("member pointer type in C");
     case STK_CPointer:
     case STK_BlockPointer:
     case STK_ObjCObjectPointer:
      switch (DestTy.$arrow().getScalarTypeKind()) {
       case STK_CPointer:
        {
          /*uint*/int SrcAS = SrcTy.$arrow().getPointeeType().getAddressSpace();
          /*uint*/int DestAS = DestTy.$arrow().getPointeeType().getAddressSpace();
          if (SrcAS != DestAS) {
            return CastKind.CK_AddressSpaceConversion;
          }
          return CastKind.CK_BitCast;
        }
       case STK_BlockPointer:
        return (SrcKind == Type.ScalarTypeKind.STK_BlockPointer ? CastKind.CK_BitCast : CastKind.CK_AnyPointerToBlockPointerCast);
       case STK_ObjCObjectPointer:
        if (SrcKind == Type.ScalarTypeKind.STK_ObjCObjectPointer) {
          return CastKind.CK_BitCast;
        }
        if (SrcKind == Type.ScalarTypeKind.STK_CPointer) {
          return CastKind.CK_CPointerToObjCPointerCast;
        }
        $this().maybeExtendBlockObject(Src);
        return CastKind.CK_BlockPointerToObjCPointerCast;
       case STK_Bool:
        return CastKind.CK_PointerToBoolean;
       case STK_Integral:
        return CastKind.CK_PointerToIntegral;
       case STK_Floating:
       case STK_FloatingComplex:
       case STK_IntegralComplex:
       case STK_MemberPointer:
        throw new llvm_unreachable("illegal cast from pointer");
      }
      throw new llvm_unreachable("Should have returned before this");
     case STK_Bool: // casting from bool is like casting from an integer
     case STK_Integral:
      switch (DestTy.$arrow().getScalarTypeKind()) {
       case STK_CPointer:
       case STK_ObjCObjectPointer:
       case STK_BlockPointer:
        if ((Src.get().isNullPointerConstant($this().Context, 
            Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNull).getValue() != 0)) {
          return CastKind.CK_NullToPointer;
        }
        return CastKind.CK_IntegralToPointer;
       case STK_Bool:
        return CastKind.CK_IntegralToBoolean;
       case STK_Integral:
        return CastKind.CK_IntegralCast;
       case STK_Floating:
        return CastKind.CK_IntegralToFloating;
       case STK_IntegralComplex:
        Src.$assignMove($this().ImpCastExprToType(Src.get(), 
                DestTy.$arrow().castAs(ComplexType.class).getElementType(), 
                CastKind.CK_IntegralCast));
        return CastKind.CK_IntegralRealToComplex;
       case STK_FloatingComplex:
        Src.$assignMove($this().ImpCastExprToType(Src.get(), 
                DestTy.$arrow().castAs(ComplexType.class).getElementType(), 
                CastKind.CK_IntegralToFloating));
        return CastKind.CK_FloatingRealToComplex;
       case STK_MemberPointer:
        throw new llvm_unreachable("member pointer type in C");
      }
      throw new llvm_unreachable("Should have returned before this");
     case STK_Floating:
      switch (DestTy.$arrow().getScalarTypeKind()) {
       case STK_Floating:
        return CastKind.CK_FloatingCast;
       case STK_Bool:
        return CastKind.CK_FloatingToBoolean;
       case STK_Integral:
        return CastKind.CK_FloatingToIntegral;
       case STK_FloatingComplex:
        Src.$assignMove($this().ImpCastExprToType(Src.get(), 
                DestTy.$arrow().castAs(ComplexType.class).getElementType(), 
                CastKind.CK_FloatingCast));
        return CastKind.CK_FloatingRealToComplex;
       case STK_IntegralComplex:
        Src.$assignMove($this().ImpCastExprToType(Src.get(), 
                DestTy.$arrow().castAs(ComplexType.class).getElementType(), 
                CastKind.CK_FloatingToIntegral));
        return CastKind.CK_IntegralRealToComplex;
       case STK_CPointer:
       case STK_ObjCObjectPointer:
       case STK_BlockPointer:
        throw new llvm_unreachable("valid float->pointer cast?");
       case STK_MemberPointer:
        throw new llvm_unreachable("member pointer type in C");
      }
      throw new llvm_unreachable("Should have returned before this");
     case STK_FloatingComplex:
      switch (DestTy.$arrow().getScalarTypeKind()) {
       case STK_FloatingComplex:
        return CastKind.CK_FloatingComplexCast;
       case STK_IntegralComplex:
        return CastKind.CK_FloatingComplexToIntegralComplex;
       case STK_Floating:
        {
          QualType ET = SrcTy.$arrow().castAs(ComplexType.class).getElementType();
          if ($this().Context.hasSameType(new QualType(ET), new QualType(DestTy))) {
            return CastKind.CK_FloatingComplexToReal;
          }
          Src.$assignMove($this().ImpCastExprToType(Src.get(), new QualType(ET), CastKind.CK_FloatingComplexToReal));
          return CastKind.CK_FloatingCast;
        }
       case STK_Bool:
        return CastKind.CK_FloatingComplexToBoolean;
       case STK_Integral:
        Src.$assignMove($this().ImpCastExprToType(Src.get(), 
                SrcTy.$arrow().castAs(ComplexType.class).getElementType(), 
                CastKind.CK_FloatingComplexToReal));
        return CastKind.CK_FloatingToIntegral;
       case STK_CPointer:
       case STK_ObjCObjectPointer:
       case STK_BlockPointer:
        throw new llvm_unreachable("valid complex float->pointer cast?");
       case STK_MemberPointer:
        throw new llvm_unreachable("member pointer type in C");
      }
      throw new llvm_unreachable("Should have returned before this");
     case STK_IntegralComplex:
      switch (DestTy.$arrow().getScalarTypeKind()) {
       case STK_FloatingComplex:
        return CastKind.CK_IntegralComplexToFloatingComplex;
       case STK_IntegralComplex:
        return CastKind.CK_IntegralComplexCast;
       case STK_Integral:
        {
          QualType ET = SrcTy.$arrow().castAs(ComplexType.class).getElementType();
          if ($this().Context.hasSameType(new QualType(ET), new QualType(DestTy))) {
            return CastKind.CK_IntegralComplexToReal;
          }
          Src.$assignMove($this().ImpCastExprToType(Src.get(), new QualType(ET), CastKind.CK_IntegralComplexToReal));
          return CastKind.CK_IntegralCast;
        }
       case STK_Bool:
        return CastKind.CK_IntegralComplexToBoolean;
       case STK_Floating:
        Src.$assignMove($this().ImpCastExprToType(Src.get(), 
                SrcTy.$arrow().castAs(ComplexType.class).getElementType(), 
                CastKind.CK_IntegralComplexToReal));
        return CastKind.CK_IntegralToFloating;
       case STK_CPointer:
       case STK_ObjCObjectPointer:
       case STK_BlockPointer:
        throw new llvm_unreachable("valid complex int->pointer cast?");
       case STK_MemberPointer:
        throw new llvm_unreachable("member pointer type in C");
      }
      throw new llvm_unreachable("Should have returned before this");
    }
  }
  throw new llvm_unreachable("Unhandled scalar cast");
}


/// \brief Build an altivec or OpenCL literal.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildVectorLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6008,
 FQN="clang::Sema::BuildVectorLiteral", NM="_ZN5clang4Sema18BuildVectorLiteralENS_14SourceLocationES1_PNS_4ExprEPNS_14TypeSourceInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema18BuildVectorLiteralENS_14SourceLocationES1_PNS_4ExprEPNS_14TypeSourceInfoE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildVectorLiteral(SourceLocation LParenLoc, 
                  SourceLocation RParenLoc, Expr /*P*/ E, 
                  TypeSourceInfo /*P*/ TInfo) {
  assert ((isa_ParenListExpr(E) || isa_ParenExpr(E))) : "Expected paren or paren list expression";
  
  type$ptr<Expr /*P*/ /*P*/> exprs = create_type$ptr();
  /*uint*/int numExprs;
  type$ptr<Expr /*P*/ > subExpr = create_type$null$ptr();
  SourceLocation LiteralLParenLoc/*J*/= new SourceLocation();
  SourceLocation LiteralRParenLoc/*J*/= new SourceLocation();
  {
    ParenListExpr /*P*/ PE = dyn_cast_ParenListExpr(E);
    if ((PE != null)) {
      LiteralLParenLoc.$assignMove(PE.getLParenLoc());
      LiteralRParenLoc.$assignMove(PE.getRParenLoc());
      exprs = $tryClone(PE.getExprs());
      numExprs = PE.getNumExprs();
    } else { // isa<ParenExpr> by assertion at function entrance
      LiteralLParenLoc.$assignMove(cast_ParenExpr(E).getLParen());
      LiteralRParenLoc.$assignMove(cast_ParenExpr(E).getRParen());
      subExpr.$set(cast_ParenExpr(E).getSubExpr());
      exprs = $tryClone($AddrOf(subExpr));
      numExprs = 1;
    }
  }
  
  QualType Ty = TInfo.getType();
  assert (Ty.$arrow().isVectorType()) : "Expected vector type";
  
  SmallVector<Expr /*P*/ > initExprs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  /*const*/ VectorType /*P*/ VTy = Ty.$arrow().getAs(VectorType.class);
  /*uint*/int numElems = Ty.$arrow().getAs(VectorType.class).getNumElements();
  
  // '(...)' form of vector initialization in AltiVec: the number of
  // initializers must be one or must match the size of the vector.
  // If a single value is specified in the initializer then it will be
  // replicated to all the components of the vector
  if (VTy.getVectorKind() == VectorType.VectorKind.AltiVecVector) {
    // The number of initializers must be one or must match the size of the
    // vector. If a single value is specified in the initializer then it will
    // be replicated to all the components of the vector
    if (numExprs == 1) {
      QualType ElemTy = Ty.$arrow().getAs(VectorType.class).getElementType();
      ActionResultTTrue<Expr /*P*/ > Literal = $this().DefaultLvalueConversion(exprs.$at(0));
      if (Literal.isInvalid()) {
        return ExprError();
      }
      Literal.$assignMove($this().ImpCastExprToType(Literal.get(), new QualType(ElemTy), 
              $this().PrepareScalarCast(Literal, new QualType(ElemTy))));
      return $this().BuildCStyleCastExpr(new SourceLocation(LParenLoc), TInfo, new SourceLocation(RParenLoc), Literal.get());
    } else if ($less_uint(numExprs, numElems)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(E.getExprLoc(), 
            diag.err_incorrect_number_of_vector_initializers)));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    } else {
      initExprs.append_T(exprs, exprs.$add(numExprs));
    }
  } else {
    // For OpenCL, when the number of initializers is a single value,
    // it will be replicated to all components of the vector.
    if ($this().getLangOpts().OpenCL
       && VTy.getVectorKind() == VectorType.VectorKind.GenericVector
       && numExprs == 1) {
      QualType ElemTy = Ty.$arrow().getAs(VectorType.class).getElementType();
      ActionResultTTrue<Expr /*P*/ > Literal = $this().DefaultLvalueConversion(exprs.$at(0));
      if (Literal.isInvalid()) {
        return ExprError();
      }
      Literal.$assignMove($this().ImpCastExprToType(Literal.get(), new QualType(ElemTy), 
              $this().PrepareScalarCast(Literal, new QualType(ElemTy))));
      return $this().BuildCStyleCastExpr(new SourceLocation(LParenLoc), TInfo, new SourceLocation(RParenLoc), Literal.get());
    }
    
    initExprs.append_T(exprs, exprs.$add(numExprs));
  }
  // FIXME: This means that pretty-printing the final AST will produce curly
  // braces instead of the original commas.
  InitListExpr /*P*/ initE = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
      return new InitListExpr($this().Context, new SourceLocation(LiteralLParenLoc), 
              new ArrayRef<Expr /*P*/ >(initExprs, true), new SourceLocation(LiteralRParenLoc));
   });
  initE.setType(new QualType(Ty));
  return $this().BuildCompoundLiteralExpr(new SourceLocation(LParenLoc), TInfo, new SourceLocation(RParenLoc), initE);
}


/// This is not an AltiVec-style cast or or C++ direct-initialization, so turn
/// the ParenListExpr into a sequence of comma binary operators.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MaybeConvertParenListExprToParenExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6090,
 FQN="clang::Sema::MaybeConvertParenListExprToParenExpr", NM="_ZN5clang4Sema36MaybeConvertParenListExprToParenExprEPNS_5ScopeEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema36MaybeConvertParenListExprToParenExprEPNS_5ScopeEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > MaybeConvertParenListExprToParenExpr(Scope /*P*/ S, Expr /*P*/ OrigExpr) {
  ParenListExpr /*P*/ E = dyn_cast_ParenListExpr(OrigExpr);
  if (!(E != null)) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, OrigExpr);
  }
  
  ActionResultTTrue<Expr /*P*/ > Result/*J*/= new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E.getExpr(0));
  
  for (/*uint*/int i = 1, e = E.getNumExprs(); i != e && !Result.isInvalid(); ++i)  {
    Result.$assignMove($this().ActOnBinOp(S, E.getExprLoc(), tok.TokenKind.comma, Result.get(), 
            E.getExpr(i)));
  }
  if (Result.isInvalid()) {
    return ExprError();
  }
  
  return $this().ActOnParenExpr(E.getLParenLoc(), E.getRParenLoc(), Result.get());
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCompoundLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 5500,
 FQN="clang::Sema::ActOnCompoundLiteral", NM="_ZN5clang4Sema20ActOnCompoundLiteralENS_14SourceLocationENS_9OpaquePtrINS_8QualTypeEEES1_PNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema20ActOnCompoundLiteralENS_14SourceLocationENS_9OpaquePtrINS_8QualTypeEEES1_PNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnCompoundLiteral(SourceLocation LParenLoc, OpaquePtr<QualType> Ty, 
                    SourceLocation RParenLoc, Expr /*P*/ InitExpr) {
  assert (Ty.$bool()) : "ActOnCompoundLiteral(): missing type";
  assert ((InitExpr != null)) : "ActOnCompoundLiteral(): missing expression";
  
  type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr();
  QualType literalType = GetTypeFromParser(new OpaquePtr<QualType>(Ty), $AddrOf(TInfo));
  if (!(TInfo.$star() != null)) {
    TInfo.$set($this().Context.getTrivialTypeSourceInfo(new QualType(literalType)));
  }
  
  return $this().BuildCompoundLiteralExpr(new SourceLocation(LParenLoc), TInfo.$star(), new SourceLocation(RParenLoc), InitExpr);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCompoundLiteralExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 5514,
 FQN="clang::Sema::BuildCompoundLiteralExpr", NM="_ZN5clang4Sema24BuildCompoundLiteralExprENS_14SourceLocationEPNS_14TypeSourceInfoES1_PNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema24BuildCompoundLiteralExprENS_14SourceLocationEPNS_14TypeSourceInfoES1_PNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCompoundLiteralExpr(SourceLocation LParenLoc, TypeSourceInfo /*P*/ TInfo, 
                        SourceLocation RParenLoc, Expr /*P*/ LiteralExpr) {
  InitializationSequence InitSeq = null;
  try {
    QualType literalType = TInfo.getType();
    if (literalType.$arrow().isArrayType()) {
      if ($this().RequireCompleteType$T(new SourceLocation(LParenLoc), $this().Context.getBaseElementType(new QualType(literalType)), 
          diag.err_illegal_decl_array_incomplete_type, 
          new SourceRange(/*NO_COPY*/LParenLoc, 
              LiteralExpr.getSourceRange().getEnd()))) {
        return ExprError();
      }
      if (literalType.$arrow().isVariableArrayType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LParenLoc), diag.err_variable_object_no_init)), 
                  new SourceRange(/*NO_COPY*/LParenLoc, LiteralExpr.getSourceRange().getEnd()))));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (!literalType.$arrow().isDependentType()
       && $this().RequireCompleteType$T(new SourceLocation(LParenLoc), new QualType(literalType), 
        diag.err_typecheck_decl_incomplete_type, 
        new SourceRange(/*NO_COPY*/LParenLoc, LiteralExpr.getSourceRange().getEnd()))) {
      return ExprError();
    }
    
    InitializedEntity Entity = InitializedEntity.InitializeCompoundLiteralInit(TInfo);
    InitializationKind Kind = InitializationKind.CreateCStyleCast(new SourceLocation(LParenLoc), 
        new SourceRange(/*NO_COPY*/LParenLoc, /*NO_COPY*/RParenLoc), 
        /*InitList=*/ true);
    InitSeq/*J*/= new InitializationSequence(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(LiteralExpr, true));
    ActionResultTTrue<Expr /*P*/ > Result = InitSeq.Perform(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(LiteralExpr, true), 
        create_type$ptr($AddrOf(literalType)));
    if (Result.isInvalid()) {
      return ExprError();
    }
    LiteralExpr = Result.get();
    
    boolean isFileScope = $this().getCurFunctionOrMethodDecl() == null;
    if (isFileScope
       && !LiteralExpr.isTypeDependent()
       && !LiteralExpr.isValueDependent()
       && !literalType.$arrow().isDependentType()) { // 6.5.2.5p3
      if ($this().CheckForConstantInitializer(LiteralExpr, new QualType(literalType))) {
        return ExprError();
      }
    }
    
    // In C, compound literals are l-values for some reason.
    ExprValueKind VK = $this().getLangOpts().CPlusPlus ? ExprValueKind.VK_RValue : ExprValueKind.VK_LValue;
    
    final Expr /*P*/ L$LiteralExpr = LiteralExpr;
    return $this().MaybeBindToTemporary(/*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
            return new CompoundLiteralExpr(new SourceLocation(LParenLoc), TInfo, new QualType(literalType), 
                    VK, L$LiteralExpr, isFileScope);
         }));
  } finally {
    if (InitSeq != null) { InitSeq.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnInitList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 5564,
 FQN="clang::Sema::ActOnInitList", NM="_ZN5clang4Sema13ActOnInitListENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema13ActOnInitListENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES1_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnInitList(SourceLocation LBraceLoc, MutableArrayRef<Expr /*P*/ > InitArgList, 
             SourceLocation RBraceLoc) {
  // Immediately handle non-overload placeholders.  Overloads can be
  // resolved contextually, but everything else here can't.
  for (/*uint*/int I = 0, E = InitArgList.size(); I != E; ++I) {
    if (InitArgList.$at(I).getType().$arrow().isNonOverloadPlaceholderType()) {
      ActionResultTTrue<Expr /*P*/ > result = $this().CheckPlaceholderExpr(InitArgList.$at(I));
      
      // Ignore failures; dropping the entire initializer list because
      // of one failure would be terrible for indexing/etc.
      if (result.isInvalid()) {
        continue;
      }
      
      InitArgList.$set(I, result.get());
    }
  }
  
  // Semantic analysis for initializers is done by ActOnDeclarator() and
  // CheckInitializer() - it requires knowledge of the object being intialized.
  InitListExpr /*P*/ E = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
      return new InitListExpr($this().Context, new SourceLocation(LBraceLoc), new ArrayRef<Expr /*P*/ >(InitArgList), 
              new SourceLocation(RBraceLoc));
   });
  E.setType($this().Context.VoidTy.$QualType()); // FIXME: just a place holder for now.
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ConvertTokenKindToBinaryOpcode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 10620,
 FQN="clang::Sema::ConvertTokenKindToBinaryOpcode", NM="_ZN5clang4Sema30ConvertTokenKindToBinaryOpcodeENS_3tok9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema30ConvertTokenKindToBinaryOpcodeENS_3tok9TokenKindE")
//</editor-fold>
protected/*private*/ static BinaryOperatorKind ConvertTokenKindToBinaryOpcode(/*tok.TokenKind*/char Kind) {
  BinaryOperatorKind Opc;
  switch (Kind) {
   default:
    throw new llvm_unreachable("Unknown binop!");
   case tok.TokenKind.periodstar:
    Opc = BinaryOperatorKind.BO_PtrMemD;
    break;
   case tok.TokenKind.arrowstar:
    Opc = BinaryOperatorKind.BO_PtrMemI;
    break;
   case tok.TokenKind.star:
    Opc = BinaryOperatorKind.BO_Mul;
    break;
   case tok.TokenKind.slash:
    Opc = BinaryOperatorKind.BO_Div;
    break;
   case tok.TokenKind.percent:
    Opc = BinaryOperatorKind.BO_Rem;
    break;
   case tok.TokenKind.plus:
    Opc = BinaryOperatorKind.BO_Add;
    break;
   case tok.TokenKind.minus:
    Opc = BinaryOperatorKind.BO_Sub;
    break;
   case tok.TokenKind.lessless:
    Opc = BinaryOperatorKind.BO_Shl;
    break;
   case tok.TokenKind.greatergreater:
    Opc = BinaryOperatorKind.BO_Shr;
    break;
   case tok.TokenKind.lessequal:
    Opc = BinaryOperatorKind.BO_LE;
    break;
   case tok.TokenKind.less:
    Opc = BinaryOperatorKind.BO_LT;
    break;
   case tok.TokenKind.greaterequal:
    Opc = BinaryOperatorKind.BO_GE;
    break;
   case tok.TokenKind.greater:
    Opc = BinaryOperatorKind.BO_GT;
    break;
   case tok.TokenKind.exclaimequal:
    Opc = BinaryOperatorKind.BO_NE;
    break;
   case tok.TokenKind.equalequal:
    Opc = BinaryOperatorKind.BO_EQ;
    break;
   case tok.TokenKind.amp:
    Opc = BinaryOperatorKind.BO_And;
    break;
   case tok.TokenKind.caret:
    Opc = BinaryOperatorKind.BO_Xor;
    break;
   case tok.TokenKind.pipe:
    Opc = BinaryOperatorKind.BO_Or;
    break;
   case tok.TokenKind.ampamp:
    Opc = BinaryOperatorKind.BO_LAnd;
    break;
   case tok.TokenKind.pipepipe:
    Opc = BinaryOperatorKind.BO_LOr;
    break;
   case tok.TokenKind.equal:
    Opc = BinaryOperatorKind.BO_Assign;
    break;
   case tok.TokenKind.starequal:
    Opc = BinaryOperatorKind.BO_MulAssign;
    break;
   case tok.TokenKind.slashequal:
    Opc = BinaryOperatorKind.BO_DivAssign;
    break;
   case tok.TokenKind.percentequal:
    Opc = BinaryOperatorKind.BO_RemAssign;
    break;
   case tok.TokenKind.plusequal:
    Opc = BinaryOperatorKind.BO_AddAssign;
    break;
   case tok.TokenKind.minusequal:
    Opc = BinaryOperatorKind.BO_SubAssign;
    break;
   case tok.TokenKind.lesslessequal:
    Opc = BinaryOperatorKind.BO_ShlAssign;
    break;
   case tok.TokenKind.greatergreaterequal:
    Opc = BinaryOperatorKind.BO_ShrAssign;
    break;
   case tok.TokenKind.ampequal:
    Opc = BinaryOperatorKind.BO_AndAssign;
    break;
   case tok.TokenKind.caretequal:
    Opc = BinaryOperatorKind.BO_XorAssign;
    break;
   case tok.TokenKind.pipeequal:
    Opc = BinaryOperatorKind.BO_OrAssign;
    break;
   case tok.TokenKind.comma:
    Opc = BinaryOperatorKind.BO_Comma;
    break;
  }
  return Opc;
}


// Binary Operators.  'Tok' is the token for the operator.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnBinOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11191,
 FQN="clang::Sema::ActOnBinOp", NM="_ZN5clang4Sema10ActOnBinOpEPNS_5ScopeENS_14SourceLocationENS_3tok9TokenKindEPNS_4ExprES7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema10ActOnBinOpEPNS_5ScopeENS_14SourceLocationENS_3tok9TokenKindEPNS_4ExprES7_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnBinOp(Scope /*P*/ S, SourceLocation TokLoc, 
          /*tok.TokenKind*/char Kind, 
          Expr /*P*/ LHSExpr, Expr /*P*/ RHSExpr) {
  BinaryOperatorKind Opc = ConvertTokenKindToBinaryOpcode(Kind);
  assert ((LHSExpr != null)) : "ActOnBinOp(): missing left expression";
  assert ((RHSExpr != null)) : "ActOnBinOp(): missing right expression";
  
  // Emit warnings for tricky precedence issues, e.g. "bitfield & 0x4 == 0"
  DiagnoseBinOpPrecedence(/*Deref*/$this(), Opc, new SourceLocation(TokLoc), LHSExpr, RHSExpr);
  
  return $this().BuildBinOp(S, new SourceLocation(TokLoc), Opc, LHSExpr, RHSExpr);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildBinOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11224,
 FQN="clang::Sema::BuildBinOp", NM="_ZN5clang4Sema10BuildBinOpEPNS_5ScopeENS_14SourceLocationENS_18BinaryOperatorKindEPNS_4ExprES6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema10BuildBinOpEPNS_5ScopeENS_14SourceLocationENS_18BinaryOperatorKindEPNS_4ExprES6_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildBinOp(Scope /*P*/ S, SourceLocation OpLoc, 
          BinaryOperatorKind Opc, 
          Expr /*P*/ LHSExpr, Expr /*P*/ RHSExpr) {
  {
    // We want to end up calling one of checkPseudoObjectAssignment
    // (if the LHS is a pseudo-object), BuildOverloadedBinOp (if
    // both expressions are overloadable or either is type-dependent),
    // or CreateBuiltinBinOp (in any other case).  We also want to get
    // any placeholder types out of the way.
    
    // Handle pseudo-objects in the LHS.
    /*const*/ BuiltinType /*P*/ pty = LHSExpr.getType().$arrow().getAsPlaceholderType();
    if ((pty != null)) {
      // Assignments with a pseudo-object l-value need special analysis.
      if (pty.getKind() == BuiltinType.Kind.PseudoObject
         && BinaryOperator.isAssignmentOp(Opc)) {
        return $this().checkPseudoObjectAssignment(S, new SourceLocation(OpLoc), Opc, LHSExpr, RHSExpr);
      }
      
      // Don't resolve overloads if the other type is overloadable.
      if (pty.getKind() == BuiltinType.Kind.Overload) {
        // We can't actually test that if we still have a placeholder,
        // though.  Fortunately, none of the exceptions we see in that
        // code below are valid when the LHS is an overload set.  Note
        // that an overload set can be dependently-typed, but it never
        // instantiates to having an overloadable type.
        ActionResultTTrue<Expr /*P*/ > resolvedRHS = $this().CheckPlaceholderExpr(RHSExpr);
        if (resolvedRHS.isInvalid()) {
          return ExprError();
        }
        RHSExpr = resolvedRHS.get();
        if (RHSExpr.isTypeDependent()
           || RHSExpr.getType().$arrow().isOverloadableType()) {
          return BuildOverloadedBinOp(/*Deref*/$this(), S, new SourceLocation(OpLoc), Opc, LHSExpr, RHSExpr);
        }
      }
      
      ActionResultTTrue<Expr /*P*/ > LHS = $this().CheckPlaceholderExpr(LHSExpr);
      if (LHS.isInvalid()) {
        return ExprError();
      }
      LHSExpr = LHS.get();
    }
  }
  {
    
    // Handle pseudo-objects in the RHS.
    /*const*/ BuiltinType /*P*/ pty = RHSExpr.getType().$arrow().getAsPlaceholderType();
    if ((pty != null)) {
      // An overload in the RHS can potentially be resolved by the type
      // being assigned to.
      if (Opc == BinaryOperatorKind.BO_Assign && pty.getKind() == BuiltinType.Kind.Overload) {
        if (LHSExpr.isTypeDependent() || RHSExpr.isTypeDependent()) {
          return BuildOverloadedBinOp(/*Deref*/$this(), S, new SourceLocation(OpLoc), Opc, LHSExpr, RHSExpr);
        }
        if (LHSExpr.getType().$arrow().isOverloadableType()) {
          return BuildOverloadedBinOp(/*Deref*/$this(), S, new SourceLocation(OpLoc), Opc, LHSExpr, RHSExpr);
        }
        
        return $this().CreateBuiltinBinOp(new SourceLocation(OpLoc), Opc, LHSExpr, RHSExpr);
      }
      
      // Don't resolve overloads if the other type is overloadable.
      if (pty.getKind() == BuiltinType.Kind.Overload
         && LHSExpr.getType().$arrow().isOverloadableType()) {
        return BuildOverloadedBinOp(/*Deref*/$this(), S, new SourceLocation(OpLoc), Opc, LHSExpr, RHSExpr);
      }
      
      ActionResultTTrue<Expr /*P*/ > resolvedRHS = $this().CheckPlaceholderExpr(RHSExpr);
      if (!resolvedRHS.isUsable()) {
        return ExprError();
      }
      RHSExpr = resolvedRHS.get();
    }
  }
  if ($this().getLangOpts().CPlusPlus) {
    // If either expression is type-dependent, always build an
    // overloaded op.
    if (LHSExpr.isTypeDependent() || RHSExpr.isTypeDependent()) {
      return BuildOverloadedBinOp(/*Deref*/$this(), S, new SourceLocation(OpLoc), Opc, LHSExpr, RHSExpr);
    }
    
    // Otherwise, build an overloaded op if either expression has an
    // overloadable type.
    if (LHSExpr.getType().$arrow().isOverloadableType()
       || RHSExpr.getType().$arrow().isOverloadableType()) {
      return BuildOverloadedBinOp(/*Deref*/$this(), S, new SourceLocation(OpLoc), Opc, LHSExpr, RHSExpr);
    }
  }
  
  // Build a built-in binary operation.
  return $this().CreateBuiltinBinOp(new SourceLocation(OpLoc), Opc, LHSExpr, RHSExpr);
}


/// CreateBuiltinBinOp - Creates a new built-in binary operation with
/// operator @p Opc at location @c TokLoc. This routine only supports
/// built-in operations; ActOnBinOp handles overloaded operators.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CreateBuiltinBinOp">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 10772,
 FQN="clang::Sema::CreateBuiltinBinOp", NM="_ZN5clang4Sema18CreateBuiltinBinOpENS_14SourceLocationENS_18BinaryOperatorKindEPNS_4ExprES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema18CreateBuiltinBinOpENS_14SourceLocationENS_18BinaryOperatorKindEPNS_4ExprES4_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CreateBuiltinBinOp(SourceLocation OpLoc, 
                  BinaryOperatorKind Opc, 
                  Expr /*P*/ LHSExpr, Expr /*P*/ RHSExpr) {
  if ($this().getLangOpts().CPlusPlus11 && isa_InitListExpr(RHSExpr)) {
    InitializationSequence InitSeq = null;
    try {
      // The syntax only allows initializer lists on the RHS of assignment,
      // so we don't need to worry about accepting invalid code for
      // non-assignment operators.
      // C++11 5.17p9:
      //   The meaning of x = {v} [...] is that of x = T(v) [...]. The meaning
      //   of x = {} is x = T().
      InitializationKind Kind = InitializationKind.CreateDirectList(RHSExpr.getLocStart());
      InitializedEntity Entity = InitializedEntity.InitializeTemporary(LHSExpr.getType());
      InitSeq/*J*/= new InitializationSequence(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(RHSExpr, true));
      ActionResultTTrue<Expr /*P*/ > Init = InitSeq.Perform(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(RHSExpr, true));
      if (Init.isInvalid()) {
        return Init;
      }
      RHSExpr = Init.get();
    } finally {
      if (InitSeq != null) { InitSeq.$destroy(); }
    }
  }
  
  ActionResultTTrue<Expr /*P*/ > LHS = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, LHSExpr);
  ActionResultTTrue<Expr /*P*/ > RHS = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, RHSExpr);
  QualType ResultTy/*J*/= new QualType(); // Result type of the binary operator.
  // The following two variables are used for compound assignment operators
  type$ptr<QualType> CompLHSTy/*J*/= create_type$ptr(new QualType()); // Type of LHS after promotions for computation
  QualType CompResultTy/*J*/= new QualType(); // Type of computation result
  type$ref<ExprValueKind> VK = create_type$ref(ExprValueKind.VK_RValue);
  type$ref<ExprObjectKind> OK = create_type$ref(ExprObjectKind.OK_Ordinary);
  if (!$this().getLangOpts().CPlusPlus) {
    // C cannot handle TypoExpr nodes on either side of a binop because it
    // doesn't handle dependent types properly, so make sure any TypoExprs have
    // been dealt with before checking the operands.
    LHS.$assignMove($this().CorrectDelayedTyposInExpr(LHSExpr));
    BinaryOperatorKind L$Opc = Opc;
    ActionResultTTrue<Expr /*P*/ >L$LHS = LHS;
    RHS.$assignMove($this().CorrectDelayedTyposInExpr(RHSExpr, /*FuncArg*//*[=L$Opc(Opc), =L$LHS(LHS)]*/ (Expr /*P*/ E) -> {
                  if (L$Opc != BinaryOperatorKind.BO_Assign) {
                    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
                  }
                  // Avoid correcting the RHS to the same Expr as the LHS.
                  Decl /*P*/ D = getDeclFromExpr(E);
                  return ((D != null) && D == getDeclFromExpr(L$LHS.get())) ? ExprError() : new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
                }));
    if (!LHS.isUsable() || !RHS.isUsable()) {
      return ExprError();
    }
  }
  if ($this().getLangOpts().OpenCL) {
    QualType LHSTy = LHSExpr.getType();
    QualType RHSTy = RHSExpr.getType();
    // OpenCLC v2.0 s6.13.11.1 allows atomic variables to be initialized by
    // the ATOMIC_VAR_INIT macro.
    if (LHSTy.$arrow().isAtomicType() || RHSTy.$arrow().isAtomicType()) {
      SourceRange SR/*J*/= new SourceRange(LHSExpr.getLocStart(), RHSExpr.getLocEnd());
      if (BinaryOperatorKind.BO_Assign == Opc) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_atomic_init_constant)), SR));
        } finally {
          $c$.$destroy();
        }
      } else {
        ResultTy.$assignMove($this().InvalidOperands(new SourceLocation(OpLoc), LHS, RHS));
      }
      return ExprError();
    }
    
    // OpenCL special types - image, sampler, pipe, and blocks are to be used
    // only with a builtin functions and therefore should be disallowed here.
    if (LHSTy.$arrow().isImageType() || RHSTy.$arrow().isImageType()
       || LHSTy.$arrow().isSamplerT() || RHSTy.$arrow().isSamplerT()
       || LHSTy.$arrow().isPipeType() || RHSTy.$arrow().isPipeType()
       || LHSTy.$arrow().isBlockPointerType() || RHSTy.$arrow().isBlockPointerType()) {
      ResultTy.$assignMove($this().InvalidOperands(new SourceLocation(OpLoc), LHS, RHS));
      return ExprError();
    }
  }
  switch (Opc) {
   case BO_Assign:
    ResultTy.$assignMove($this().CheckAssignmentOperands(LHS.get(), RHS, new SourceLocation(OpLoc), new QualType()));
    if ($this().getLangOpts().CPlusPlus
       && LHS.get().getObjectKind() != ExprObjectKind.OK_ObjCProperty) {
      VK.$set(LHS.get().getValueKind());
      OK.$set(LHS.get().getObjectKind());
    }
    if (!ResultTy.isNull()) {
      DiagnoseSelfAssignment(/*Deref*/$this(), LHS.get(), RHS.get(), new SourceLocation(OpLoc));
      $this().DiagnoseSelfMove(LHS.get(), RHS.get(), new SourceLocation(OpLoc));
    }
    RecordModifiableNonNullParam(/*Deref*/$this(), LHS.get());
    break;
   case BO_PtrMemD:
   case BO_PtrMemI:
    ResultTy.$assignMove($this().CheckPointerToMemberOperands(LHS, RHS, VK, new SourceLocation(OpLoc), 
            Opc == BinaryOperatorKind.BO_PtrMemI));
    break;
   case BO_Mul:
   case BO_Div:
    ResultTy.$assignMove($this().CheckMultiplyDivideOperands(LHS, RHS, new SourceLocation(OpLoc), false, 
            Opc == BinaryOperatorKind.BO_Div));
    break;
   case BO_Rem:
    ResultTy.$assignMove($this().CheckRemainderOperands(LHS, RHS, new SourceLocation(OpLoc)));
    break;
   case BO_Add:
    ResultTy.$assignMove($this().CheckAdditionOperands(LHS, RHS, new SourceLocation(OpLoc), Opc));
    break;
   case BO_Sub:
    ResultTy.$assignMove($this().CheckSubtractionOperands(LHS, RHS, new SourceLocation(OpLoc)));
    break;
   case BO_Shl:
   case BO_Shr:
    ResultTy.$assignMove($this().CheckShiftOperands(LHS, RHS, new SourceLocation(OpLoc), Opc));
    break;
   case BO_LE:
   case BO_LT:
   case BO_GE:
   case BO_GT:
    ResultTy.$assignMove($this().CheckCompareOperands(LHS, RHS, new SourceLocation(OpLoc), Opc, true));
    break;
   case BO_EQ:
   case BO_NE:
    ResultTy.$assignMove($this().CheckCompareOperands(LHS, RHS, new SourceLocation(OpLoc), Opc, false));
    break;
   case BO_And:
    checkObjCPointerIntrospection(/*Deref*/$this(), LHS, RHS, new SourceLocation(OpLoc));
   case BO_Xor:
   case BO_Or:
    ResultTy.$assignMove($this().CheckBitwiseOperands(LHS, RHS, new SourceLocation(OpLoc)));
    break;
   case BO_LAnd:
   case BO_LOr:
    ResultTy.$assignMove($this().CheckLogicalOperands(LHS, RHS, new SourceLocation(OpLoc), Opc));
    break;
   case BO_MulAssign:
   case BO_DivAssign:
    CompResultTy.$assignMove($this().CheckMultiplyDivideOperands(LHS, RHS, new SourceLocation(OpLoc), true, 
            Opc == BinaryOperatorKind.BO_DivAssign));
    CompLHSTy.$set(CompResultTy);
    if (!CompResultTy.isNull() && !LHS.isInvalid() && !RHS.isInvalid()) {
      ResultTy.$assignMove($this().CheckAssignmentOperands(LHS.get(), RHS, new SourceLocation(OpLoc), new QualType(CompResultTy)));
    }
    break;
   case BO_RemAssign:
    CompResultTy.$assignMove($this().CheckRemainderOperands(LHS, RHS, new SourceLocation(OpLoc), true));
    CompLHSTy.$set(CompResultTy);
    if (!CompResultTy.isNull() && !LHS.isInvalid() && !RHS.isInvalid()) {
      ResultTy.$assignMove($this().CheckAssignmentOperands(LHS.get(), RHS, new SourceLocation(OpLoc), new QualType(CompResultTy)));
    }
    break;
   case BO_AddAssign:
    CompResultTy.$assignMove($this().CheckAdditionOperands(LHS, RHS, new SourceLocation(OpLoc), Opc, $AddrOf(CompLHSTy)));
    if (!CompResultTy.isNull() && !LHS.isInvalid() && !RHS.isInvalid()) {
      ResultTy.$assignMove($this().CheckAssignmentOperands(LHS.get(), RHS, new SourceLocation(OpLoc), new QualType(CompResultTy)));
    }
    break;
   case BO_SubAssign:
    CompResultTy.$assignMove($this().CheckSubtractionOperands(LHS, RHS, new SourceLocation(OpLoc), $AddrOf(CompLHSTy)));
    if (!CompResultTy.isNull() && !LHS.isInvalid() && !RHS.isInvalid()) {
      ResultTy.$assignMove($this().CheckAssignmentOperands(LHS.get(), RHS, new SourceLocation(OpLoc), new QualType(CompResultTy)));
    }
    break;
   case BO_ShlAssign:
   case BO_ShrAssign:
    CompResultTy.$assignMove($this().CheckShiftOperands(LHS, RHS, new SourceLocation(OpLoc), Opc, true));
    CompLHSTy.$set(CompResultTy);
    if (!CompResultTy.isNull() && !LHS.isInvalid() && !RHS.isInvalid()) {
      ResultTy.$assignMove($this().CheckAssignmentOperands(LHS.get(), RHS, new SourceLocation(OpLoc), new QualType(CompResultTy)));
    }
    break;
   case BO_AndAssign:
   case BO_OrAssign: // fallthrough
    DiagnoseSelfAssignment(/*Deref*/$this(), LHS.get(), RHS.get(), new SourceLocation(OpLoc));
   case BO_XorAssign:
    CompResultTy.$assignMove($this().CheckBitwiseOperands(LHS, RHS, new SourceLocation(OpLoc), true));
    CompLHSTy.$set(CompResultTy);
    if (!CompResultTy.isNull() && !LHS.isInvalid() && !RHS.isInvalid()) {
      ResultTy.$assignMove($this().CheckAssignmentOperands(LHS.get(), RHS, new SourceLocation(OpLoc), new QualType(CompResultTy)));
    }
    break;
   case BO_Comma:
    ResultTy.$assignMove(CheckCommaOperands(/*Deref*/$this(), LHS, RHS, new SourceLocation(OpLoc)));
    if ($this().getLangOpts().CPlusPlus && !RHS.isInvalid()) {
      VK.$set(RHS.get().getValueKind());
      OK.$set(RHS.get().getObjectKind());
    }
    break;
  }
  if (ResultTy.isNull() || LHS.isInvalid() || RHS.isInvalid()) {
    return ExprError();
  }
  
  // Check for array bounds violations for both sides of the BinaryOperator
  $this().CheckArrayAccess(LHS.get());
  $this().CheckArrayAccess(RHS.get());
  {
    
    /*const*/ ObjCIsaExpr /*P*/ OISA = dyn_cast_ObjCIsaExpr(LHS.get().IgnoreParenCasts());
    if ((OISA != null)) {
      NamedDecl /*P*/ ObjectSetClass = $this().LookupSingleName($this().TUScope, 
          new DeclarationName($AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"object_setClass")))), 
          new SourceLocation(), LookupNameKind.LookupOrdinaryName);
      if ((ObjectSetClass != null) && isa_ObjCIsaExpr(LHS.get())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SourceLocation RHSLocEnd = $this().getLocForEndOfToken(RHS.get().getLocEnd());
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(LHS.get().getExprLoc(), diag.warn_objc_isa_assign)), 
                      FixItHint.CreateInsertion(LHS.get().getLocStart(), new StringRef(/*KEEP_STR*/"object_setClass("))), 
                  FixItHint.CreateReplacement(new SourceRange(OISA.getOpLoc(), /*NO_COPY*/OpLoc), new StringRef(/*KEEP_STR*/$COMMA))), 
              FixItHint.CreateInsertion(/*NO_COPY*/RHSLocEnd, new StringRef(/*KEEP_STR*/$RPAREN))));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(LHS.get().getExprLoc(), diag.warn_objc_isa_assign)));
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      /*const*/ ObjCIvarRefExpr /*P*/ OIRE = dyn_cast_ObjCIvarRefExpr(LHS.get().IgnoreParenCasts());
      if ((OIRE != null)) {
        DiagnoseDirectIsaAccess(/*Deref*/$this(), OIRE, new SourceLocation(OpLoc), RHS.get());
      }
    }
  }
  if (CompResultTy.isNull()) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ (Expr /*P*/)Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
            return new BinaryOperator(LHS.get(), RHS.get(), Opc, new QualType(ResultTy), VK.$deref(), 
                    OK.$deref(), new SourceLocation(OpLoc), $this().FPFeatures.fp_contract);
         }));
  }
  if ($this().getLangOpts().CPlusPlus && LHS.get().getObjectKind()
     != ExprObjectKind.OK_ObjCProperty) {
    VK.$set(ExprValueKind.VK_LValue);
    OK.$set(LHS.get().getObjectKind());
  }
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ (Expr /*P*/)Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new CompoundAssignOperator(LHS.get(), RHS.get(), Opc, new QualType(ResultTy), VK.$deref(), OK.$deref(), new QualType(CompLHSTy.$star()), new QualType(CompResultTy), 
                  new SourceLocation(OpLoc), $this().FPFeatures.fp_contract);
       }));
}


// Look for instances where it is likely the comma operator is confused with
// another operator.  There is a whitelist of acceptable expressions for the
// left hand side of the comma operator, otherwise emit a warning.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseCommaOperator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 10087,
 FQN="clang::Sema::DiagnoseCommaOperator", NM="_ZN5clang4Sema21DiagnoseCommaOperatorEPKNS_4ExprENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema21DiagnoseCommaOperatorEPKNS_4ExprENS_14SourceLocationE")
//</editor-fold>
public final void DiagnoseCommaOperator(/*const*/ Expr /*P*/ LHS, SourceLocation Loc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // No warnings in macros
    if (Loc.isMacroID()) {
      return;
    }
    
    // Don't warn in template instantiations.
    if (!$this().ActiveTemplateInstantiations.empty()) {
      return;
    }
    
    // Scope isn't fine-grained enough to whitelist the specific cases, so
    // instead, skip more than needed, then call back into here with the
    // CommaVisitor in SemaStmt.cpp.
    // The whitelisted locations are the initialization and increment portions
    // of a for loop.  The additional checks are on the condition of
    // if statements, do/while loops, and for loops.
    /*const*//*uint*/int ForIncrementFlags = Scope.ScopeFlags.ControlScope | Scope.ScopeFlags.ContinueScope | Scope.ScopeFlags.BreakScope;
    /*const*//*uint*/int ForInitFlags = Scope.ScopeFlags.ControlScope | Scope.ScopeFlags.DeclScope;
    /*const*//*uint*/int ScopeFlags = $this().getCurScope().getFlags();
    if ((ScopeFlags & ForIncrementFlags) == ForIncrementFlags
       || (ScopeFlags & ForInitFlags) == ForInitFlags) {
      return;
    }
    {
      
      // If there are multiple comma operators used together, get the RHS of the
      // of the comma operator as the LHS.
      /*const*/ BinaryOperator /*P*/ BO;
      while (((/*P*/ BO = dyn_cast_BinaryOperator(LHS)) != null)) {
        if (BO.getOpcode() != BinaryOperatorKind.BO_Comma) {
          break;
        }
        LHS = BO.getRHS();
      }
    }
    
    // Only allow some expressions on LHS to not warn.
    if (IgnoreCommaOperand(LHS)) {
      return;
    }
    
    $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_comma_operator)));
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(LHS.getLocStart(), diag.note_cast_to_void)), 
                LHS.getSourceRange()), 
            FixItHint.CreateInsertion(LHS.getLocStart(), 
                new StringRef($this().LangOpts.CPlusPlus ? $("static_cast<void>(") : $("(void)(")))), 
        FixItHint.CreateInsertion($this().PP.getLocForEndOfToken(LHS.getLocEnd()), 
            new StringRef(/*KEEP_STR*/$RPAREN))));
  } finally {
    $c$.$destroy();
  }
}


/// ActOnConditionalOp - Parse a ?: operation.  Note that 'LHS' may be null
/// in the case of a the GNU conditional expr extension.

/// ActOnConditionalOp - Parse a ?: operation.  Note that 'LHS' may be null
/// in the case of a the GNU conditional expr extension.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnConditionalOp">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 7007,
 FQN="clang::Sema::ActOnConditionalOp", NM="_ZN5clang4Sema18ActOnConditionalOpENS_14SourceLocationES1_PNS_4ExprES3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema18ActOnConditionalOpENS_14SourceLocationES1_PNS_4ExprES3_S3_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnConditionalOp(SourceLocation QuestionLoc, 
                  SourceLocation ColonLoc, 
                  Expr /*P*/ CondExpr, Expr /*P*/ LHSExpr, 
                  Expr /*P*/ RHSExpr) {
  if (!$this().getLangOpts().CPlusPlus) {
    // C cannot handle TypoExpr nodes in the condition because it
    // doesn't handle dependent types properly, so make sure any TypoExprs have
    // been dealt with before checking the operands.
    ActionResultTTrue<Expr /*P*/ > CondResult = $this().CorrectDelayedTyposInExpr(CondExpr);
    ActionResultTTrue<Expr /*P*/ > LHSResult = $this().CorrectDelayedTyposInExpr(LHSExpr);
    ActionResultTTrue<Expr /*P*/ > RHSResult = $this().CorrectDelayedTyposInExpr(RHSExpr);
    if (!CondResult.isUsable()) {
      return ExprError();
    }
    if ((LHSExpr != null)) {
      if (!LHSResult.isUsable()) {
        return ExprError();
      }
    }
    if (!RHSResult.isUsable()) {
      return ExprError();
    }
    
    CondExpr = CondResult.get();
    LHSExpr = LHSResult.get();
    RHSExpr = RHSResult.get();
  }
  
  // If this is the gnu "x ?: y" extension, analyze the types as though the LHS
  // was the condition.
  OpaqueValueExpr /*P*/ opaqueValue = null;
  Expr /*P*/ commonExpr = null;
  if (!(LHSExpr != null)) {
    commonExpr = CondExpr;
    // Lower out placeholder types first.  This is important so that we don't
    // try to capture a placeholder. This happens in few cases in C++; such
    // as Objective-C++'s dictionary subscripting syntax.
    if (commonExpr.hasPlaceholderType()) {
      ActionResultTTrue<Expr /*P*/ > result = $this().CheckPlaceholderExpr(commonExpr);
      if (!result.isUsable()) {
        return ExprError();
      }
      commonExpr = result.get();
    }
    // We usually want to apply unary conversions *before* saving, except
    // in the special case of a C++ l-value conditional.
    if (!($this().getLangOpts().CPlusPlus
       && !commonExpr.isTypeDependent()
       && commonExpr.getValueKind() == RHSExpr.getValueKind()
       && commonExpr.isGLValue()
       && commonExpr.isOrdinaryOrBitFieldObject()
       && RHSExpr.isOrdinaryOrBitFieldObject()
       && $this().Context.hasSameType(commonExpr.getType(), RHSExpr.getType()))) {
      ActionResultTTrue<Expr /*P*/ > commonRes = $this().UsualUnaryConversions(commonExpr);
      if (commonRes.isInvalid()) {
        return ExprError();
      }
      commonExpr = commonRes.get();
    }
    
    final Expr /*P*/ L$commonExpr = commonExpr;
    opaqueValue = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
        return new OpaqueValueExpr(L$commonExpr.getExprLoc(), 
                L$commonExpr.getType(), 
                L$commonExpr.getValueKind(), 
                L$commonExpr.getObjectKind(), 
                L$commonExpr);
     });
    LHSExpr = CondExpr = opaqueValue;
  }
  
  type$ref<ExprValueKind> VK = create_type$ref(ExprValueKind.VK_RValue);
  type$ref<ExprObjectKind> OK = create_type$ref(ExprObjectKind.OK_Ordinary);
  ActionResultTTrue<Expr /*P*/ > Cond = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, CondExpr);
  ActionResultTTrue<Expr /*P*/ > LHS = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, LHSExpr);
  ActionResultTTrue<Expr /*P*/ > RHS = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, RHSExpr);
  QualType result = $this().CheckConditionalOperands(Cond, LHS, RHS, 
      VK, OK, new SourceLocation(QuestionLoc));
  if (result.isNull() || Cond.isInvalid() || LHS.isInvalid()
     || RHS.isInvalid()) {
    return ExprError();
  }
  
  DiagnoseConditionalPrecedence(/*Deref*/$this(), new SourceLocation(QuestionLoc), Cond.get(), LHS.get(), 
      RHS.get());
  
  $this().CheckBoolLikeConversion(Cond.get(), new SourceLocation(QuestionLoc));
  if (!(commonExpr != null)) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
            return new ConditionalOperator(Cond.get(), new SourceLocation(QuestionLoc), LHS.get(), new SourceLocation(ColonLoc), 
                    RHS.get(), new QualType(result), VK.$deref(), OK.$deref());
         }));
  }
  
  final Expr /*P*/ L$commonExpr = commonExpr;
  final OpaqueValueExpr /*P*/ L$opaqueValue = opaqueValue;
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new BinaryConditionalOperator(L$commonExpr, L$opaqueValue, Cond.get(), LHS.get(), RHS.get(), new SourceLocation(QuestionLoc), 
                  new SourceLocation(ColonLoc), new QualType(result), VK.$deref(), OK.$deref());
       }));
}


/// ActOnAddrLabel - Parse the GNU address of label extension: "&&foo".

/// ActOnAddrLabel - Parse the GNU address of label extension: "&&foo".
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnAddrLabel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11578,
 FQN="clang::Sema::ActOnAddrLabel", NM="_ZN5clang4Sema14ActOnAddrLabelENS_14SourceLocationES1_PNS_9LabelDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema14ActOnAddrLabelENS_14SourceLocationES1_PNS_9LabelDeclE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnAddrLabel(SourceLocation OpLoc, SourceLocation LabLoc, 
              LabelDecl /*P*/ TheDecl) {
  TheDecl.markUsed($this().Context);
  // Create the AST node.  The address of a label always has type 'void*'.
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new AddrLabelExpr(new SourceLocation(OpLoc), new SourceLocation(LabLoc), TheDecl, 
                  $this().Context.getPointerType(/*NO_COPY*/$this().Context.VoidTy).$QualType());
       }));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStartStmtExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11609,
 FQN="clang::Sema::ActOnStartStmtExpr", NM="_ZN5clang4Sema18ActOnStartStmtExprEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema18ActOnStartStmtExprEv")
//</editor-fold>
public final void ActOnStartStmtExpr() {
  $this().PushExpressionEvaluationContext($this().ExprEvalContexts.back().Context);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStmtExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11621,
 FQN="clang::Sema::ActOnStmtExpr", NM="_ZN5clang4Sema13ActOnStmtExprENS_14SourceLocationEPNS_4StmtES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema13ActOnStmtExprENS_14SourceLocationEPNS_4StmtES1_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnStmtExpr(SourceLocation LPLoc, Stmt /*P*/ SubStmt, 
             SourceLocation RPLoc) {
  // "({..})"
  assert ((SubStmt != null) && isa_CompoundStmt(SubStmt)) : "Invalid action invocation!";
  CompoundStmt /*P*/ Compound = cast_CompoundStmt(SubStmt);
  if ($this().hasAnyUnrecoverableErrorsInThisFunction()) {
    $this().DiscardCleanupsInEvaluationContext();
  }
  assert (!$this().Cleanup.exprNeedsCleanups()) : "cleanups within StmtExpr not correctly bound!";
  $this().PopExpressionEvaluationContext();
  
  // FIXME: there are a variety of strange constraints to enforce here, for
  // example, it is not possible to goto into a stmt expression apparently.
  // More semantic analysis is needed.
  
  // If there are sub-stmts in the compound stmt, take the type of the last one
  // as the type of the stmtexpr.
  QualType Ty = $this().Context.VoidTy.$QualType();
  boolean StmtExprMayBindToTemp = false;
  if (!Compound.body_empty()) {
    Stmt /*P*/ LastStmt = Compound.body_back();
    LabelStmt /*P*/ LastLabelStmt = null;
    {
      // If LastStmt is a label, skip down through into the body.
      LabelStmt /*P*/ Label;
      while (((/*P*/ Label = dyn_cast_LabelStmt(LastStmt)) != null)) {
        LastLabelStmt = Label;
        LastStmt = Label.getSubStmt();
      }
    }
    {
      
      Expr /*P*/ LastE = dyn_cast_Expr(LastStmt);
      if ((LastE != null)) {
        // Do function/array conversion on the last expression, but not
        // lvalue-to-rvalue.  However, initialize an unqualified type.
        ActionResultTTrue<Expr /*P*/ > LastExpr = $this().DefaultFunctionArrayConversion(LastE);
        if (LastExpr.isInvalid()) {
          return ExprError();
        }
        Ty.$assignMove(LastExpr.get().getType().getUnqualifiedType());
        if (!Ty.$arrow().isDependentType() && !LastExpr.get().isTypeDependent()) {
          {
            // In ARC, if the final expression ends in a consume, splice
            // the consume out and bind it later.  In the alternate case
            // (when dealing with a retainable type), the result
            // initialization will create a produce.  In both cases the
            // result will be +1, and we'll need to balance that out with
            // a bind.
            Expr /*P*/ rebuiltLastStmt = maybeRebuildARCConsumingStmt(LastExpr.get());
            if ((rebuiltLastStmt != null)) {
              LastExpr.$assign(rebuiltLastStmt);
            } else {
              LastExpr.$assignMove($this().PerformCopyInitialization(InitializedEntity.InitializeResult(new SourceLocation(LPLoc), 
                          new QualType(Ty), 
                          false), 
                      new SourceLocation(), 
                      new ActionResultTTrue<Expr /*P*/ >(LastExpr)));
            }
          }
          if (LastExpr.isInvalid()) {
            return ExprError();
          }
          if (LastExpr.get() != null) {
            if (!(LastLabelStmt != null)) {
              Compound.setLastStmt(LastExpr.get());
            } else {
              LastLabelStmt.setSubStmt(LastExpr.get());
            }
            StmtExprMayBindToTemp = true;
          }
        }
      }
    }
  }
  
  // FIXME: Check that expression type is complete/non-abstract; statement
  // expressions are not lvalues.
  Expr /*P*/ ResStmtExpr = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
      return new StmtExpr(Compound, new QualType(Ty), new SourceLocation(LPLoc), new SourceLocation(RPLoc));
   });
  if (StmtExprMayBindToTemp) {
    return $this().MaybeBindToTemporary(ResStmtExpr);
  }
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, ResStmtExpr);
}

// "({..})"
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStmtExprError">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11613,
 FQN="clang::Sema::ActOnStmtExprError", NM="_ZN5clang4Sema18ActOnStmtExprErrorEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema18ActOnStmtExprErrorEv")
//</editor-fold>
public final void ActOnStmtExprError() {
  // Note that function is also called by TreeTransform when leaving a
  // StmtExpr scope without rebuilding anything.
  $this().DiscardCleanupsInEvaluationContext();
  $this().PopExpressionEvaluationContext();
}


/// __builtin_offsetof(type, a.b[123][456].c)
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildBuiltinOffsetOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11698,
 FQN="clang::Sema::BuildBuiltinOffsetOf", NM="_ZN5clang4Sema20BuildBuiltinOffsetOfENS_14SourceLocationEPNS_14TypeSourceInfoEN4llvm8ArrayRefINS0_17OffsetOfComponentEEES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema20BuildBuiltinOffsetOfENS_14SourceLocationEPNS_14TypeSourceInfoEN4llvm8ArrayRefINS0_17OffsetOfComponentEEES1_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildBuiltinOffsetOf(SourceLocation BuiltinLoc, 
                    TypeSourceInfo /*P*/ TInfo, 
                    ArrayRef<OffsetOfComponent> Components, 
                    SourceLocation RParenLoc) {
  QualType ArgTy = TInfo.getType();
  boolean Dependent = ArgTy.$arrow().isDependentType();
  SourceRange TypeRange = TInfo.getTypeLoc().getLocalSourceRange();
  
  // We must have at least one component that refers to the type, and the first
  // one is known to be a field designator.  Verify that the ArgTy represents
  // a struct/union/class.
  if (!Dependent && !ArgTy.$arrow().isRecordType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(BuiltinLoc), diag.err_offsetof_record_type)), 
                  ArgTy), TypeRange)));
    } finally {
      $c$.$destroy();
    }
  }
  
  // Type must be complete per C99 7.17p3 because a declaring a variable
  // with an incomplete type would be ill-formed.
  if (!Dependent
     && $this().RequireCompleteType$T(new SourceLocation(BuiltinLoc), new QualType(ArgTy), 
      diag.err_offsetof_incomplete_type, TypeRange)) {
    return ExprError();
  }
  
  // offsetof with non-identifier designators (e.g. "offsetof(x, a.b[c])") are a
  // GCC extension, diagnose them.
  // FIXME: This diagnostic isn't actually visible because the location is in
  // a system header!
  if (Components.size() != 1) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(BuiltinLoc), diag.ext_offsetof_extended_field_designator)), 
          new SourceRange(/*NO_COPY*/Components.$at(1).LocStart, /*NO_COPY*/Components.back().LocEnd)));
    } finally {
      $c$.$destroy();
    }
  }
  
  boolean DidWarnAboutNonPOD = false;
  QualType CurrentType = new QualType(ArgTy);
  SmallVector<OffsetOfNode> Comps/*J*/= new SmallVector<OffsetOfNode>(4, new OffsetOfNode());
  SmallVector<Expr /*P*/ > Exprs/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
  for (final /*const*/ OffsetOfComponent /*&*/ OC : Components) {
    LookupResult R = null;
    CXXBasePaths Paths = null;
    try {
      if (OC.isBrackets) {
        // Offset of an array sub-field.  TODO: Should we allow vector elements?
        if (!CurrentType.$arrow().isDependentType()) {
          /*const*/ ArrayType /*P*/ AT = $this().Context.getAsArrayType(new QualType(CurrentType));
          if (!(AT != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OC.LocEnd), diag.err_offsetof_array_type)), 
                      CurrentType)));
            } finally {
              $c$.$destroy();
            }
          }
          CurrentType.$assignMove(AT.getElementType());
        } else {
          CurrentType.$assignMove($this().Context.DependentTy.$QualType());
        }
        
        ActionResultTTrue<Expr /*P*/ > IdxRval = $this().DefaultLvalueConversion(((/*static_cast*/Expr /*P*/ )(OC.U.E)));
        if (IdxRval.isInvalid()) {
          return ExprError();
        }
        Expr /*P*/ Idx = IdxRval.get();
        
        // The expression must be an integral expression.
        // FIXME: An integral constant expression?
        if (!Idx.isTypeDependent() && !Idx.isValueDependent()
           && !Idx.getType().$arrow().isIntegerType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Idx.getLocStart(), 
                        diag.err_typecheck_subscript_not_integer)), 
                    Idx.getSourceRange())));
          } finally {
            $c$.$destroy();
          }
        }
        
        // Record this array index.
        Comps.push_back(new OffsetOfNode(new SourceLocation(OC.LocStart), Exprs.size(), new SourceLocation(OC.LocEnd)));
        Exprs.push_back(Idx);
        continue;
      }
      
      // Offset of a field.
      if (CurrentType.$arrow().isDependentType()) {
        // We have the offset of a field, but we can't look into the dependent
        // type. Just record the identifier of the field.
        Comps.push_back(new OffsetOfNode(new SourceLocation(OC.LocStart), OC.U.IdentInfo, new SourceLocation(OC.LocEnd)));
        CurrentType.$assignMove($this().Context.DependentTy.$QualType());
        continue;
      }
      
      // We need to have a complete type to look into.
      if ($this().RequireCompleteType(new SourceLocation(OC.LocStart), new QualType(CurrentType), 
          diag.err_offsetof_incomplete_type)) {
        return ExprError();
      }
      
      // Look for the designated field.
      /*const*/ RecordType /*P*/ RC = CurrentType.$arrow().getAs$RecordType();
      if (!(RC != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OC.LocEnd), diag.err_offsetof_record_type)), 
                  CurrentType)));
        } finally {
          $c$.$destroy();
        }
      }
      RecordDecl /*P*/ RD = RC.getDecl();
      {
        
        // C++ [lib.support.types]p5:
        //   The macro offsetof accepts a restricted set of type arguments in this
        //   International Standard. type shall be a POD structure or a POD union
        //   (clause 9).
        // C++11 [support.types]p4:
        //   If type is not a standard-layout class (Clause 9), the results are
        //   undefined.
        CXXRecordDecl /*P*/ CRD = dyn_cast_CXXRecordDecl(RD);
        if ((CRD != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            boolean IsSafe = $this().LangOpts.CPlusPlus11 ? CRD.isStandardLayout() : CRD.isPOD();
            /*uint*/int DiagID = $this().LangOpts.CPlusPlus11 ? diag.ext_offsetof_non_standardlayout_type : diag.ext_offsetof_non_pod_type;
            if ($c$.clean(!IsSafe && !DidWarnAboutNonPOD
               && $this().DiagRuntimeBehavior(new SourceLocation(BuiltinLoc), (/*const*/ Stmt /*P*/ )null, 
                $out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_SourceRange($c$.track($this().PDiag(DiagID)), 
                        new SourceRange(/*NO_COPY*/Components.$at(0).LocStart, /*NO_COPY*/OC.LocEnd)), 
                    /*NO_COPY*/CurrentType)))) {
              DidWarnAboutNonPOD = true;
            }
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      // Look for the field.
      R/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(OC.U.IdentInfo), new SourceLocation(OC.LocStart), LookupNameKind.LookupMemberName);
      $this().LookupQualifiedName(R, RD);
      FieldDecl /*P*/ MemberDecl = R.<FieldDecl>getAsSingle(FieldDecl.class);
      IndirectFieldDecl /*P*/ IndirectMemberDecl = null;
      if (!(MemberDecl != null)) {
        if (((IndirectMemberDecl = R.<IndirectFieldDecl>getAsSingle(IndirectFieldDecl.class)) != null)) {
          MemberDecl = IndirectMemberDecl.getAnonField();
        }
      }
      if (!(MemberDecl != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(BuiltinLoc), diag.err_no_member)), 
                          OC.U.IdentInfo), RD), new SourceRange(/*NO_COPY*/OC.LocStart, 
                      /*NO_COPY*/OC.LocEnd))));
        } finally {
          $c$.$destroy();
        }
      }
      
      // C99 7.17p3:
      //   (If the specified member is a bit-field, the behavior is undefined.)
      //
      // We diagnose this as an error.
      if (MemberDecl.isBitField()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OC.LocEnd), diag.err_offsetof_bitfield)), 
                  MemberDecl.getDeclName()), 
              new SourceRange(/*NO_COPY*/BuiltinLoc, /*NO_COPY*/RParenLoc)));
          $c$.clean($c$.track($this().Diag(MemberDecl.getLocation(), diag.note_bitfield_decl)));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
      
      RecordDecl /*P*/ Parent = MemberDecl.getParent();
      if ((IndirectMemberDecl != null)) {
        Parent = cast_RecordDecl(IndirectMemberDecl.getDeclContext());
      }
      
      // If the member was found in a base class, introduce OffsetOfNodes for
      // the base class indirections.
      Paths/*J*/= new CXXBasePaths();
      if ($this().IsDerivedFrom(new SourceLocation(OC.LocStart), new QualType(CurrentType), $this().Context.getTypeDeclType(Parent), 
          Paths)) {
        if ((Paths.getDetectedVirtual() != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OC.LocEnd), diag.err_offsetof_field_of_virtual_base)), 
                    MemberDecl.getDeclName()), 
                new SourceRange(/*NO_COPY*/BuiltinLoc, /*NO_COPY*/RParenLoc)));
            return ExprError();
          } finally {
            $c$.$destroy();
          }
        }
        
        final CXXBasePath /*&*/ Path = Paths.front();
        for (final /*const*/ CXXBasePathElement /*&*/ B : Path)  {
          Comps.push_back(new OffsetOfNode(B.Base));
        }
      }
      if ((IndirectMemberDecl != null)) {
        for (NamedDecl /*P*/ FI : IndirectMemberDecl.chain()) {
          assert (isa_FieldDecl(FI));
          Comps.push_back(new OffsetOfNode(new SourceLocation(OC.LocStart), 
                  cast_FieldDecl(FI), new SourceLocation(OC.LocEnd)));
        }
      } else {
        Comps.push_back(new OffsetOfNode(new SourceLocation(OC.LocStart), MemberDecl, new SourceLocation(OC.LocEnd)));
      }
      
      CurrentType.$assignMove(MemberDecl.getType().getNonReferenceType());
    } finally {
      if (Paths != null) { Paths.$destroy(); }
      if (R != null) { R.$destroy(); }
    }
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, OffsetOfExpr.Create($this().Context, $this().Context.getSizeType().$QualType(), new SourceLocation(BuiltinLoc), TInfo, 
          new ArrayRef<OffsetOfNode>(Comps, false), new ArrayRef<Expr /*P*/ >(Exprs, true), new SourceLocation(RParenLoc)));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnBuiltinOffsetOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11869,
 FQN="clang::Sema::ActOnBuiltinOffsetOf", NM="_ZN5clang4Sema20ActOnBuiltinOffsetOfEPNS_5ScopeENS_14SourceLocationES3_NS_9OpaquePtrINS_8QualTypeEEEN4llvm8ArrayRefINS0_17OffsetOfComponentEEES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema20ActOnBuiltinOffsetOfEPNS_5ScopeENS_14SourceLocationES3_NS_9OpaquePtrINS_8QualTypeEEEN4llvm8ArrayRefINS0_17OffsetOfComponentEEES3_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnBuiltinOffsetOf(Scope /*P*/ S, 
                    SourceLocation BuiltinLoc, 
                    SourceLocation TypeLoc, 
                    OpaquePtr<QualType> ParsedArgTy, 
                    ArrayRef<OffsetOfComponent> Components, 
                    SourceLocation RParenLoc) {
  
  type$ptr<TypeSourceInfo /*P*/ > ArgTInfo = create_type$null$ptr();
  QualType ArgTy = GetTypeFromParser(new OpaquePtr<QualType>(ParsedArgTy), $AddrOf(ArgTInfo));
  if (ArgTy.isNull()) {
    return ExprError();
  }
  if (!(ArgTInfo.$star() != null)) {
    ArgTInfo.$set($this().Context.getTrivialTypeSourceInfo(new QualType(ArgTy), new SourceLocation(TypeLoc)));
  }
  
  return $this().BuildBuiltinOffsetOf(new SourceLocation(BuiltinLoc), ArgTInfo.$star(), new ArrayRef<OffsetOfComponent>(Components), new SourceLocation(RParenLoc));
}


// __builtin_choose_expr(constExpr, expr1, expr2)
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnChooseExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11888,
 FQN="clang::Sema::ActOnChooseExpr", NM="_ZN5clang4Sema15ActOnChooseExprENS_14SourceLocationEPNS_4ExprES3_S3_S1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema15ActOnChooseExprENS_14SourceLocationEPNS_4ExprES3_S3_S1_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnChooseExpr(SourceLocation BuiltinLoc, 
               Expr /*P*/ CondExpr, 
               Expr /*P*/ LHSExpr, Expr /*P*/ RHSExpr, 
               SourceLocation RPLoc) {
  assert (((CondExpr != null) && (LHSExpr != null) && (RHSExpr != null))) : "Missing type argument(s)";
  
  ExprValueKind VK = ExprValueKind.VK_RValue;
  ExprObjectKind OK = ExprObjectKind.OK_Ordinary;
  QualType resType/*J*/= new QualType();
  boolean ValueDependent = false;
  boolean CondIsTrue = false;
  if (CondExpr.isTypeDependent() || CondExpr.isValueDependent()) {
    resType.$assignMove($this().Context.DependentTy.$QualType());
    ValueDependent = true;
  } else {
    // The conditional expression is required to be a constant expression.
    APSInt condEval/*J*/= new APSInt(32);
    ActionResultTTrue<Expr /*P*/ > CondICE = $this().VerifyIntegerConstantExpression(CondExpr, $AddrOf(condEval), 
        diag.err_typecheck_choose_expr_requires_constant, false);
    if (CondICE.isInvalid()) {
      return ExprError();
    }
    CondExpr = CondICE.get();
    CondIsTrue = (condEval.getZExtValue() != 0);
    
    // If the condition is > zero, then the AST type is the same as the LSHExpr.
    Expr /*P*/ ActiveExpr = CondIsTrue ? LHSExpr : RHSExpr;
    
    resType.$assignMove(ActiveExpr.getType());
    ValueDependent = ActiveExpr.isValueDependent();
    VK = ActiveExpr.getValueKind();
    OK = ActiveExpr.getObjectKind();
  }
  
  final Expr /*P*/ L$CondExpr = CondExpr;
  final ExprValueKind L$VK = VK;
  final ExprObjectKind L$OK = OK;  
  final boolean L$ValueDependent = ValueDependent;
  final boolean L$CondIsTrue = CondIsTrue;
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new ChooseExpr(new SourceLocation(BuiltinLoc), L$CondExpr, LHSExpr, RHSExpr, new QualType(resType), L$VK, L$OK, new SourceLocation(RPLoc), 
                  L$CondIsTrue, resType.$arrow().isDependentType(), L$ValueDependent);
       }));
}


// __builtin_va_arg(expr, type)
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnVAArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12204,
 FQN="clang::Sema::ActOnVAArg", NM="_ZN5clang4Sema10ActOnVAArgENS_14SourceLocationEPNS_4ExprENS_9OpaquePtrINS_8QualTypeEEES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema10ActOnVAArgENS_14SourceLocationEPNS_4ExprENS_9OpaquePtrINS_8QualTypeEEES1_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnVAArg(SourceLocation BuiltinLoc, Expr /*P*/ E, OpaquePtr<QualType> Ty, 
          SourceLocation RPLoc) {
  type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr();
  GetTypeFromParser(new OpaquePtr<QualType>(Ty), $AddrOf(TInfo));
  return $this().BuildVAArgExpr(new SourceLocation(BuiltinLoc), E, TInfo.$star(), new SourceLocation(RPLoc));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildVAArgExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12211,
 FQN="clang::Sema::BuildVAArgExpr", NM="_ZN5clang4Sema14BuildVAArgExprENS_14SourceLocationEPNS_4ExprEPNS_14TypeSourceInfoES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema14BuildVAArgExprENS_14SourceLocationEPNS_4ExprEPNS_14TypeSourceInfoES1_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildVAArgExpr(SourceLocation BuiltinLoc, 
              Expr /*P*/ E, TypeSourceInfo /*P*/ TInfo, 
              SourceLocation RPLoc) {
  Expr /*P*/ OrigExpr = E;
  boolean IsMS = false;
  
  // CUDA device code does not support varargs.
  if ($this().getLangOpts().CUDA && $this().getLangOpts().CUDAIsDevice) {
    {
      /*const*/ FunctionDecl /*P*/ F = dyn_cast_FunctionDecl($this().CurContext);
      if ((F != null)) {
        CUDAFunctionTarget T = $this().IdentifyCUDATarget(F);
        if (T == CUDAFunctionTarget.CFT_Global || T == CUDAFunctionTarget.CFT_Device || T == CUDAFunctionTarget.CFT_HostDevice) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean(ExprError($c$.track($this().Diag(E.getLocStart(), diag.err_va_arg_in_device))));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  
  // It might be a __builtin_ms_va_list. (But don't ever mark a va_arg()
  // as Microsoft ABI on an actual Microsoft platform, where
  // __builtin_ms_va_list and __builtin_va_list are the same.)
  if (!E.isTypeDependent() && $this().Context.getTargetInfo().hasBuiltinMSVaList()
     && $this().Context.getTargetInfo().getBuiltinVaListKind() != TargetInfo.BuiltinVaListKind.CharPtrBuiltinVaList) {
    QualType MSVaListType = $this().Context.getBuiltinMSVaListType();
    if ($this().Context.hasSameType(new QualType(MSVaListType), E.getType())) {
      if (CheckForModifiableLvalue(E, new SourceLocation(BuiltinLoc), /*Deref*/$this())) {
        return ExprError();
      }
      IsMS = true;
    }
  }
  
  // Get the va_list type
  QualType VaListType = $this().Context.getBuiltinVaListType();
  if (!IsMS) {
    if (VaListType.$arrow().isArrayType()) {
      // Deal with implicit array decay; for example, on x86-64,
      // va_list is an array, but it's supposed to decay to
      // a pointer for va_arg.
      VaListType.$assignMove($this().Context.getArrayDecayedType(new QualType(VaListType)));
      // Make sure the input expression also decays appropriately.
      ActionResultTTrue<Expr /*P*/ > Result = $this().UsualUnaryConversions(E);
      if (Result.isInvalid()) {
        return ExprError();
      }
      E = Result.get();
    } else if (VaListType.$arrow().isRecordType() && $this().getLangOpts().CPlusPlus) {
      // If va_list is a record type and we are compiling in C++ mode,
      // check the argument using reference binding.
      InitializedEntity Entity = InitializedEntity.InitializeParameter($this().Context, $this().Context.getLValueReferenceType(new QualType(VaListType)), false);
      ActionResultTTrue<Expr /*P*/ > Init = $this().PerformCopyInitialization(Entity, new SourceLocation(), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E));
      if (Init.isInvalid()) {
        return ExprError();
      }
      E = Init.getAs(Expr.class);
    } else {
      // Otherwise, the va_list argument must be an l-value because
      // it is modified by va_arg.
      if (!E.isTypeDependent()
         && CheckForModifiableLvalue(E, new SourceLocation(BuiltinLoc), /*Deref*/$this())) {
        return ExprError();
      }
    }
  }
  if (!IsMS && !E.isTypeDependent()
     && !$this().Context.hasSameType(new QualType(VaListType), E.getType())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getLocStart(), 
                      diag.err_first_argument_to_va_arg_not_of_type_va_list)), 
                  OrigExpr.getType()), E.getSourceRange())));
    } finally {
      $c$.$destroy();
    }
  }
  if (!TInfo.getType().$arrow().isDependentType()) {
    if ($this().RequireCompleteType$T(TInfo.getTypeLoc().getBeginLoc(), TInfo.getType(), 
        diag.err_second_parameter_to_va_arg_incomplete, 
        TInfo.getTypeLoc())) {
      return ExprError();
    }
    if ($this().RequireNonAbstractType$T(TInfo.getTypeLoc().getBeginLoc(), 
        TInfo.getType(), 
        diag.err_second_parameter_to_va_arg_abstract, 
        TInfo.getTypeLoc())) {
      return ExprError();
    }
    if (!TInfo.getType().isPODType($this().Context)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(TInfo.getTypeLoc().getBeginLoc(), 
                    TInfo.getType().$arrow().isObjCLifetimeType() ? diag.warn_second_parameter_to_va_arg_ownership_qualified : diag.warn_second_parameter_to_va_arg_not_pod)), 
                TInfo.getType()), 
            TInfo.getTypeLoc().getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Check for va_arg where arguments of the given type will be promoted
    // (i.e. this va_arg is guaranteed to have undefined behavior).
    QualType PromoteType/*J*/= new QualType();
    if (TInfo.getType().$arrow().isPromotableIntegerType()) {
      PromoteType.$assignMove($this().Context.getPromotedIntegerType(TInfo.getType()));
      if ($this().Context.typesAreCompatible(new QualType(PromoteType), TInfo.getType())) {
        PromoteType.$assignMove(new QualType());
      }
    }
    if (TInfo.getType().$arrow().isSpecificBuiltinType(BuiltinType.Kind.Float.getValue())) {
      PromoteType.$assignMove($this().Context.DoubleTy.$QualType());
    }
    if (!PromoteType.isNull()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($this().DiagRuntimeBehavior(TInfo.getTypeLoc().getBeginLoc(), E, 
            $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_QualType($c$.track($this().PDiag(diag.warn_second_parameter_to_va_arg_never_compatible)), 
                        TInfo.getType()), 
                    /*NO_COPY*/PromoteType), 
                TInfo.getTypeLoc().getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  QualType T = TInfo.getType().getNonLValueExprType($this().Context);
  final Expr /*P*/ L$E = E;
  final boolean L$IsMS = IsMS;
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new VAArgExpr(new SourceLocation(BuiltinLoc), L$E, TInfo, new SourceLocation(RPLoc), new QualType(T), L$IsMS);
       }));
}


// __null
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnGNUNullExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12319,
 FQN="clang::Sema::ActOnGNUNullExpr", NM="_ZN5clang4Sema16ActOnGNUNullExprENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema16ActOnGNUNullExprENS_14SourceLocationE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnGNUNullExpr(SourceLocation TokenLoc) {
  // The type of __null will be int or long, depending on the size of
  // pointers on the target.
  QualType Ty/*J*/= new QualType();
  /*uint*/int pw = $ulong2uint($this().Context.getTargetInfo().getPointerWidth(0));
  if (pw == $this().Context.getTargetInfo().getIntWidth()) {
    Ty.$assignMove($this().Context.IntTy.$QualType());
  } else if (pw == $this().Context.getTargetInfo().getLongWidth()) {
    Ty.$assignMove($this().Context.LongTy.$QualType());
  } else if (pw == $this().Context.getTargetInfo().getLongLongWidth()) {
    Ty.$assignMove($this().Context.LongLongTy.$QualType());
  } else {
    throw new llvm_unreachable("I don't know size of pointer!");
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new GNUNullExpr(new QualType(Ty), new SourceLocation(TokenLoc));
       }));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckCaseExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 15058,
 FQN="clang::Sema::CheckCaseExpression", NM="_ZN5clang4Sema19CheckCaseExpressionEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema19CheckCaseExpressionEPNS_4ExprE")
//</editor-fold>
public final boolean CheckCaseExpression(Expr /*P*/ E) {
  if (E.isTypeDependent()) {
    return true;
  }
  if (E.isValueDependent() || E.isIntegerConstantExpr($this().Context)) {
    return E.getType().$arrow().isIntegralOrEnumerationType();
  }
  return false;
}


//===------------------------- "Block" Extension ------------------------===//

/// ActOnBlockStart - This callback is invoked when a block literal is
/// started.

//===----------------------------------------------------------------------===//
// Clang Extensions.
//===----------------------------------------------------------------------===//

/// ActOnBlockStart - This callback is invoked when a block literal is started.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnBlockStart">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11932,
 FQN="clang::Sema::ActOnBlockStart", NM="_ZN5clang4Sema15ActOnBlockStartENS_14SourceLocationEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema15ActOnBlockStartENS_14SourceLocationEPNS_5ScopeE")
//</editor-fold>
public final void ActOnBlockStart(SourceLocation CaretLoc, Scope /*P*/ CurScope) {
  BlockDecl /*P*/ Block = BlockDecl.Create($this().Context, $this().CurContext, new SourceLocation(CaretLoc));
  if ($this().LangOpts.CPlusPlus) {
    type$ref<Decl /*P*/ > ManglingContextDecl = create_type$ref();
    {
      MangleNumberingContext /*P*/ MCtx = $this().getCurrentMangleNumberContext(Block.getDeclContext(), 
          ManglingContextDecl);
      if ((MCtx != null)) {
        /*uint*/int ManglingNumber = MCtx.getManglingNumber(Block);
        Block.setBlockMangling(ManglingNumber, ManglingContextDecl.$deref());
      }
    }
  }
  
  $this().PushBlockScope(CurScope, Block);
  $this().CurContext.addDecl(Block);
  if ((CurScope != null)) {
    $this().PushDeclContext(CurScope, Block);
  } else {
    $this().CurContext = Block;
  }
  
  $this().getCurBlock().HasImplicitReturnType = true;
  
  // Enter a new evaluation context to insulate the block from any
  // cleanups from the enclosing full-expression.
  $this().PushExpressionEvaluationContext(ExpressionEvaluationContext.PotentiallyEvaluated);
}


/// ActOnBlockArguments - This callback allows processing of block arguments.
/// If there are no arguments, this is still invoked.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnBlockArguments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11959,
 FQN="clang::Sema::ActOnBlockArguments", NM="_ZN5clang4Sema19ActOnBlockArgumentsENS_14SourceLocationERNS_10DeclaratorEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema19ActOnBlockArgumentsENS_14SourceLocationERNS_10DeclaratorEPNS_5ScopeE")
//</editor-fold>
public final void ActOnBlockArguments(SourceLocation CaretLoc, final Declarator /*&*/ ParamInfo, 
                   Scope /*P*/ CurScope) {
  assert (ParamInfo.getIdentifier() == null) : "block-id should have no identifier!";
  assert (ParamInfo.getContext() == Declarator.TheContext.BlockLiteralContext);
  BlockScopeInfo /*P*/ CurBlock = $this().getCurBlock();
  
  TypeSourceInfo /*P*/ Sig = $this().GetTypeForDeclarator(ParamInfo, CurScope);
  QualType T = Sig.getType();
  
  // FIXME: We should allow unexpanded parameter packs here, but that would,
  // in turn, make the block expression contain unexpanded parameter packs.
  if ($this().DiagnoseUnexpandedParameterPack(new SourceLocation(CaretLoc), Sig, UnexpandedParameterPackContext.UPPC_Block)) {
    // Drop the parameters.
    FunctionProtoType.ExtProtoInfo EPI/*J*/= new FunctionProtoType.ExtProtoInfo();
    EPI.HasTrailingReturn = false;
    EPI.TypeQuals |= DeclSpec.TQ.TQ_const.getValue();
    T.$assignMove($this().Context.getFunctionType($this().Context.DependentTy.$QualType(), new ArrayRef<QualType>(None, false), EPI));
    Sig = $this().Context.getTrivialTypeSourceInfo(new QualType(T));
  }
  
  // GetTypeForDeclarator always produces a function type for a block
  // literal signature.  Furthermore, it is always a FunctionProtoType
  // unless the function was written with a typedef.
  assert (T.$arrow().isFunctionType()) : "GetTypeForDeclarator made a non-function block signature";
  
  // Look for an explicit signature in that function type.
  FunctionProtoTypeLoc ExplicitSignature/*J*/= new FunctionProtoTypeLoc();
  
  TypeLoc tmp = Sig.getTypeLoc().IgnoreParens();
  if ((ExplicitSignature.$assignMove(tmp.getAs(FunctionProtoTypeLoc.class))).$bool()) {
    
    // Check whether that explicit signature was synthesized by
    // GetTypeForDeclarator.  If so, don't save that as part of the
    // written signature.
    if ($eq_SourceLocation$C(ExplicitSignature.getLocalRangeBegin(), 
        ExplicitSignature.getLocalRangeEnd())) {
      // This would be much cheaper if we stored TypeLocs instead of
      // TypeSourceInfos.
      TypeLoc Result = ExplicitSignature.getReturnLoc();
      /*uint*/int Size = Result.getFullDataSize();
      Sig = $this().Context.CreateTypeSourceInfo(Result.getType(), Size);
      Sig.getTypeLoc().initializeFullCopy(new TypeLoc(Result), Size);
      
      ExplicitSignature.$assignMove(new FunctionProtoTypeLoc());
    }
  }
  
  CurBlock.TheDecl.setSignatureAsWritten(Sig);
  CurBlock.FunctionType.$assign(T);
  
  /*const*/ FunctionType /*P*/ Fn = T.$arrow().getAs(FunctionType.class);
  QualType RetTy = Fn.getReturnType();
  boolean isVariadic = (isa_FunctionProtoType(Fn) && cast_FunctionProtoType(Fn).isVariadic());
  
  CurBlock.TheDecl.setIsVariadic(isVariadic);
  
  // Context.DependentTy is used as a placeholder for a missing block
  // return type.  TODO:  what should we do with declarators like:
  //   ^ * { ... }
  // If the answer is "apply template argument deduction"....
  if ($noteq_QualType$C(RetTy, $this().Context.DependentTy.$QualType())) {
    CurBlock.ReturnType.$assign(RetTy);
    CurBlock.TheDecl.setBlockMissingReturnType(false);
    CurBlock.HasImplicitReturnType = false;
  }
  
  // Push block parameters from the declarator if we had them.
  SmallVector<ParmVarDecl /*P*/ > Params/*J*/= new SmallVector<ParmVarDecl /*P*/ >(8, (ParmVarDecl /*P*/ )null);
  if (ExplicitSignature.$bool()) {
    for (/*uint*/int I = 0, E = ExplicitSignature.getNumParams(); I != E; ++I) {
      ParmVarDecl /*P*/ Param = ExplicitSignature.getParam(I);
      if (Param.getIdentifier() == null
         && !Param.isImplicit()
         && !Param.isInvalidDecl()
         && !$this().getLangOpts().CPlusPlus) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(Param.getLocation(), diag.err_parameter_name_omitted)));
        } finally {
          $c$.$destroy();
        }
      }
      Params.push_back(Param);
    }
    // Fake up parameter variables if we have a typedef, like
    //   ^ fntype { ... }
  } else {
    /*const*/ FunctionProtoType /*P*/ Fn$1 = T.$arrow().getAs(FunctionProtoType.class);
    if ((Fn$1 != null)) {
      for (final /*const*/ QualType /*&*/ I : Fn$1.param_types()) {
        ParmVarDecl /*P*/ Param = $this().BuildParmVarDeclForTypedef(CurBlock.TheDecl, ParamInfo.getLocStart(), new QualType(I));
        Params.push_back(Param);
      }
    }
  }
  
  // Set the parameters on the block decl.
  if (!Params.empty()) {
    CurBlock.TheDecl.setParams(new ArrayRef<ParmVarDecl /*P*/ >(Params, true));
    $this().CheckParmsForFunctionDef(new ArrayRef<ParmVarDecl /*P*/ >(JD$Move.INSTANCE, CurBlock.TheDecl.parameters()), 
        /*CheckParameterNames=*/ false);
  }
  
  // Finally we can process decl attributes.
  $this().ProcessDeclAttributes(CurScope, CurBlock.TheDecl, ParamInfo);
  
  // Put the parameter variables in scope.
  for (ParmVarDecl /*P*/ AI : CurBlock.TheDecl.parameters()) {
    AI.setOwningFunction(CurBlock.TheDecl);
    
    // If this has an identifier, add it to the scope stack.
    if ((AI.getIdentifier() != null)) {
      $this().CheckShadow(CurBlock.TheScope, AI);
      
      $this().PushOnScopeChains(AI, CurBlock.TheScope);
    }
  }
}


/// ActOnBlockError - If there is an error parsing a block, this callback
/// is invoked to pop the information about the block from the action impl.

/// ActOnBlockError - If there is an error parsing a block, this callback
/// is invoked to pop the information about the block from the action impl.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnBlockError">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12076,
 FQN="clang::Sema::ActOnBlockError", NM="_ZN5clang4Sema15ActOnBlockErrorENS_14SourceLocationEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema15ActOnBlockErrorENS_14SourceLocationEPNS_5ScopeE")
//</editor-fold>
public final void ActOnBlockError(SourceLocation CaretLoc, Scope /*P*/ CurScope) {
  // Leave the expression-evaluation context.
  $this().DiscardCleanupsInEvaluationContext();
  $this().PopExpressionEvaluationContext();
  
  // Pop off CurBlock, handle nested blocks.
  $this().PopDeclContext();
  $this().PopFunctionScopeInfo();
}


/// ActOnBlockStmtExpr - This is called when the body of a block statement
/// literal was successfully completed.  ^(int x){...}

/// ActOnBlockStmtExpr - This is called when the body of a block statement
/// literal was successfully completed.  ^(int x){...}
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnBlockStmtExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12088,
 FQN="clang::Sema::ActOnBlockStmtExpr", NM="_ZN5clang4Sema18ActOnBlockStmtExprENS_14SourceLocationEPNS_4StmtEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema18ActOnBlockStmtExprENS_14SourceLocationEPNS_4StmtEPNS_5ScopeE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnBlockStmtExpr(SourceLocation CaretLoc, 
                  Stmt /*P*/ Body, Scope /*P*/ CurScope) {
  // If blocks are disabled, emit an error.
  if (!$this().LangOpts.Blocks) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(CaretLoc), diag.err_blocks_disable)), $this().LangOpts.OpenCL));
    } finally {
      $c$.$destroy();
    }
  }
  
  // Leave the expression-evaluation context.
  if ($this().hasAnyUnrecoverableErrorsInThisFunction()) {
    $this().DiscardCleanupsInEvaluationContext();
  }
  assert (!$this().Cleanup.exprNeedsCleanups()) : "cleanups within block not correctly bound!";
  $this().PopExpressionEvaluationContext();
  
  BlockScopeInfo /*P*/ BSI = cast_BlockScopeInfo($this().FunctionScopes.back());
  if (BSI.HasImplicitReturnType) {
    $this().deduceClosureReturnType($Deref(BSI));
  }
  
  $this().PopDeclContext();
  
  QualType RetTy = $this().Context.VoidTy.$QualType();
  if (!BSI.ReturnType.isNull()) {
    RetTy.$assign(BSI.ReturnType);
  }
  
  boolean NoReturn = BSI.TheDecl.hasAttr(NoReturnAttr.class);
  QualType BlockTy/*J*/= new QualType();
  
  // Set the captured variables on the block.
  // FIXME: Share capture structure between BlockDecl and CapturingScopeInfo!
  SmallVector<BlockDecl.Capture> Captures/*J*/= new SmallVector<BlockDecl.Capture>(4, new BlockDecl.Capture());
  for (final CapturingScopeInfo.Capture /*&*/ Cap : BSI.Captures) {
    if (Cap.isThisCapture()) {
      continue;
    }
    BlockDecl.Capture NewCap/*J*/= new BlockDecl.Capture(Cap.getVariable(), Cap.isBlockCapture(), 
        Cap.isNested(), Cap.getInitExpr());
    Captures.push_back(NewCap);
  }
  BSI.TheDecl.setCaptures($this().Context, new ArrayRef<BlockDecl.Capture>(Captures, false), BSI.CXXThisCaptureIndex != 0);
  
  // If the user wrote a function type in some form, try to use that.
  if (!BSI.FunctionType.isNull()) {
    /*const*/ FunctionType /*P*/ FTy = BSI.FunctionType.$arrow().getAs(FunctionType.class);
    
    FunctionType.ExtInfo Ext = FTy.getExtInfo();
    if (NoReturn && !Ext.getNoReturn()) {
      Ext.$assignMove(Ext.withNoReturn(true));
    }
    
    // Turn protoless block types into nullary block types.
    if (isa_FunctionNoProtoType(FTy)) {
      FunctionProtoType.ExtProtoInfo EPI/*J*/= new FunctionProtoType.ExtProtoInfo();
      EPI.ExtInfo.$assign(Ext);
      BlockTy.$assignMove($this().Context.getFunctionType(new QualType(RetTy), new ArrayRef<QualType>(None, false), EPI));
      // Otherwise, if we don't need to change anything about the function type,
      // preserve its sugar structure.
    } else if ($eq_QualType$C(FTy.getReturnType(), RetTy)
       && (!NoReturn || FTy.getNoReturnAttr())) {
      BlockTy.$assign(BSI.FunctionType);
      // Otherwise, make the minimal modifications to the function type.
    } else {
      /*const*/ FunctionProtoType /*P*/ FPT = cast_FunctionProtoType(FTy);
      FunctionProtoType.ExtProtoInfo EPI = FPT.getExtProtoInfo();
      EPI.TypeQuals = 0; // FIXME: silently?
      EPI.ExtInfo.$assign(Ext);
      BlockTy.$assignMove($this().Context.getFunctionType(new QualType(RetTy), FPT.getParamTypes(), EPI));
    }
    // If we don't have a function type, just build one from nothing.
  } else {
    FunctionProtoType.ExtProtoInfo EPI/*J*/= new FunctionProtoType.ExtProtoInfo();
    EPI.ExtInfo.$assignMove(new FunctionType.ExtInfo().withNoReturn(NoReturn));
    BlockTy.$assignMove($this().Context.getFunctionType(new QualType(RetTy), new ArrayRef<QualType>(None, false), EPI));
  }
  
  $this().DiagnoseUnusedParameters(new ArrayRef<ParmVarDecl /*P*/ >(JD$Move.INSTANCE, BSI.TheDecl.parameters()));
  BlockTy.$assignMove($this().Context.getBlockPointerType(new QualType(BlockTy)));
  
  // If needed, diagnose invalid gotos and switches in the block.
  if ($this().getCurFunction().NeedsScopeChecking()
     && !$this().PP.isCodeCompletionEnabled()) {
    $this().DiagnoseInvalidJumps(cast_CompoundStmt(Body));
  }
  
  BSI.TheDecl.setBody(cast_CompoundStmt(Body));
  
  // Try to apply the named return value optimization. We have to check again
  // if we can do this, though, because blocks keep return statements around
  // to deduce an implicit return type.
  if ($this().getLangOpts().CPlusPlus && RetTy.$arrow().isRecordType()
     && !BSI.TheDecl.isDependentContext()) {
    $this().computeNRVO(Body, BSI);
  }
  
  BlockExpr /*P*/ Result = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
      return new BlockExpr(BSI.TheDecl, new QualType(BlockTy));
   });
  AnalysisBasedWarnings.Policy WP = $this().AnalysisWarnings.getDefaultPolicy();
  $this().PopFunctionScopeInfo($AddrOf(WP), Result.getBlockDecl(), Result);
  
  // If the block isn't obviously global, i.e. it captures anything at
  // all, then we need to do a few things in the surrounding context:
  if (Result.getBlockDecl().hasCaptures()) {
    // First, this expression has a new cleanup object.
    $this().ExprCleanupObjects.push_back(Result.getBlockDecl());
    $this().Cleanup.setExprNeedsCleanups(true);
    
    // It also gets a branch-protected scope if any of the captured
    // variables needs destruction.
    for (final /*const*/ BlockDecl.Capture /*&*/ CI : Result.getBlockDecl().captures()) {
      /*const*/ VarDecl /*P*/ var = CI.getVariable();
      if (var.getType().isDestructedType() != QualType.DestructionKind.DK_none) {
        $this().getCurFunction().setHasBranchProtectedScope();
        break;
      }
    }
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Result);
}


//===---------------------------- Clang Extensions ----------------------===//

/// __builtin_convertvector(...)

/// ActOnConvertVectorExpr - create a new convert-vector expression from the
/// provided arguments.
///
/// __builtin_convertvector( value, dst type )
///
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnConvertVectorExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 5290,
 FQN="clang::Sema::ActOnConvertVectorExpr", NM="_ZN5clang4Sema22ActOnConvertVectorExprEPNS_4ExprENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationES6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema22ActOnConvertVectorExprEPNS_4ExprENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationES6_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnConvertVectorExpr(Expr /*P*/ E, OpaquePtr<QualType> ParsedDestTy, 
                      SourceLocation BuiltinLoc, 
                      SourceLocation RParenLoc) {
  type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr();
  GetTypeFromParser(new OpaquePtr<QualType>(ParsedDestTy), $AddrOf(TInfo));
  return $this().SemaConvertVectorExpr(E, TInfo.$star(), new SourceLocation(BuiltinLoc), new SourceLocation(RParenLoc));
}


//===---------------------------- OpenCL Features -----------------------===//

/// __builtin_astype(...)

/// ActOnAsTypeExpr - create a new asType (bitcast) from the arguments.
///
/// __builtin_astype( value, dst type )
///
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnAsTypeExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 5269,
 FQN="clang::Sema::ActOnAsTypeExpr", NM="_ZN5clang4Sema15ActOnAsTypeExprEPNS_4ExprENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationES6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema15ActOnAsTypeExprEPNS_4ExprENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationES6_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnAsTypeExpr(Expr /*P*/ E, OpaquePtr<QualType> ParsedDestTy, 
               SourceLocation BuiltinLoc, 
               SourceLocation RParenLoc) {
  ExprValueKind VK = ExprValueKind.VK_RValue;
  ExprObjectKind OK = ExprObjectKind.OK_Ordinary;
  QualType DstTy = GetTypeFromParser(new OpaquePtr<QualType>(ParsedDestTy));
  QualType SrcTy = E.getType();
  if ($this().Context.getTypeSize(new QualType(DstTy)) != $this().Context.getTypeSize(new QualType(SrcTy))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(ExprError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(BuiltinLoc), 
                          diag.err_invalid_astype_of_different_size)), 
                      DstTy), 
                  SrcTy), 
              E.getSourceRange())));
    } finally {
      $c$.$destroy();
    }
  }
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new AsTypeExpr(E, new QualType(DstTy), VK, OK, new SourceLocation(BuiltinLoc), new SourceLocation(RParenLoc));
       }));
}


/// BuildCXXDefaultArgExpr - Creates a CXXDefaultArgExpr, instantiating
/// the default expr if needed.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXDefaultArgExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 4499,
 FQN="clang::Sema::BuildCXXDefaultArgExpr", NM="_ZN5clang4Sema22BuildCXXDefaultArgExprENS_14SourceLocationEPNS_12FunctionDeclEPNS_11ParmVarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema22BuildCXXDefaultArgExprENS_14SourceLocationEPNS_12FunctionDeclEPNS_11ParmVarDeclE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCXXDefaultArgExpr(SourceLocation CallLoc, 
                      FunctionDecl /*P*/ FD, 
                      ParmVarDecl /*P*/ Param) {
  if (Param.hasUnparsedDefaultArg()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(CallLoc), 
                  diag.err_use_of_default_argument_to_function_declared_later)), 
              FD), cast_CXXRecordDecl(FD.getDeclContext()).getDeclName()));
      $c$.clean($c$.track($this().Diag(new SourceLocation($this().UnparsedDefaultArgLocs.$at_T1$C$R(Param)), 
          diag.note_default_argument_declared_here)));
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  if (Param.hasUninstantiatedDefaultArg()) {
    EnterExpressionEvaluationContext EvalContext = null;
    MultiLevelTemplateArgumentList MutiLevelArgList = null;
    InstantiatingTemplate Inst = null;
    InitializationSequence InitSeq = null;
    try {
      Expr /*P*/ UninstExpr = Param.getUninstantiatedDefaultArg();
      
      EvalContext/*J*/= new EnterExpressionEvaluationContext(/*Deref*/$this(), ExpressionEvaluationContext.PotentiallyEvaluated, 
          Param);
      
      // Instantiate the expression.
      MutiLevelArgList = $this().getTemplateInstantiationArgs(FD, (/*const*/ TemplateArgumentList /*P*/ )null, /*RelativeToPrimary=*/ true);
      
      Inst/*J*/= new InstantiatingTemplate(JD$Sema_SourceLocation_ParmVarDecl$P_ArrayRef$TemplateArgument_SourceRange.INSTANCE, /*Deref*/$this(), new SourceLocation(CallLoc), Param, 
          new ArrayRef<TemplateArgument>(MutiLevelArgList.getInnermost()));
      if (Inst.isInvalid()) {
        return ExprError();
      }
      
      ActionResultTTrue<Expr /*P*/ > Result/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      {
        ContextRAII SavedContext = null;
        LocalInstantiationScope Local = null;
        try {
          // C++ [dcl.fct.default]p5:
          //   The names in the [default argument] expression are bound, and
          //   the semantic constraints are checked, at the point where the
          //   default argument expression appears.
          SavedContext/*J*/= new ContextRAII(/*Deref*/$this(), FD);
          Local/*J*/= new LocalInstantiationScope(/*Deref*/$this());
          Result.$assignMove($this().SubstExpr(UninstExpr, MutiLevelArgList));
        } finally {
          if (Local != null) { Local.$destroy(); }
          if (SavedContext != null) { SavedContext.$destroy(); }
        }
      }
      if (Result.isInvalid()) {
        return ExprError();
      }
      
      // Check the expression as an initializer for the parameter.
      InitializedEntity Entity = InitializedEntity.InitializeParameter($this().Context, Param);
      InitializationKind Kind = InitializationKind.CreateCopy(Param.getLocation(), 
          /*FIXME:EqualLoc*/ UninstExpr.getLocStart());
      Expr /*P*/ ResultE = Result.getAs(Expr.class);
      
      InitSeq/*J*/= new InitializationSequence(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(ResultE, true));
      Result.$assignMove(InitSeq.Perform(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(ResultE, true)));
      if (Result.isInvalid()) {
        return ExprError();
      }
      
      Result.$assignMove($this().ActOnFinishFullExpr(Result.getAs(Expr.class), 
              Param.getOuterLocStart()));
      if (Result.isInvalid()) {
        return ExprError();
      }
      
      // Remember the instantiated default argument.
      Param.setDefaultArg(Result.getAs(Expr.class));
      {
        ASTMutationListener /*P*/ L = $this().getASTMutationListener();
        if ((L != null)) {
          L.DefaultArgumentInstantiated(Param);
        }
      }
    } finally {
      if (InitSeq != null) { InitSeq.$destroy(); }
      if (Inst != null) { Inst.$destroy(); }
      if (MutiLevelArgList != null) { MutiLevelArgList.$destroy(); }
      if (EvalContext != null) { EvalContext.$destroy(); }
    }
  }
  
  // If the default argument expression is not set yet, we are building it now.
  if (!Param.hasInit()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Param.getLocStart(), diag.err_recursive_default_argument)), FD));
      Param.setInvalidDecl();
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  {
    
    // If the default expression creates temporaries, we need to
    // push them to the current stack of expression temporaries so they'll
    // be properly destroyed.
    // FIXME: We should really be rebuilding the default argument with new
    // bound temporaries; see the comment in PR5810.
    // We don't need to do that with block decls, though, because
    // blocks in default argument expression can never capture anything.
    ExprWithCleanups /*P*/ Init = dyn_cast_ExprWithCleanups(Param.getInit());
    if ((Init != null)) {
      // Set the "needs cleanups" bit regardless of whether there are
      // any explicit objects.
      $this().Cleanup.setExprNeedsCleanups(Init.cleanupsHaveSideEffects());
      
      // Append all the objects to the cleanup list.  Right now, this
      // should always be a no-op, because blocks in default argument
      // expressions should never be able to capture anything.
      assert (!(Init.getNumObjects() != 0)) : "default argument expression has capturing blocks?";
    }
  }
  
  // We already type-checked the argument, so we know it works. 
  // Just mark all of the declarations in this potentially-evaluated expression
  // as being "referenced".
  $this().MarkDeclarationsReferencedInExpr(Param.getDefaultArg(), 
      /*SkipLocalVariables=*/ true);
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, CXXDefaultArgExpr.Create($this().Context, new SourceLocation(CallLoc), Param));
}


/// ActOnObjCBoolLiteral - Parse {__objc_yes,__objc_no} literals.

/// ActOnObjCBoolLiteral - Parse {__objc_yes,__objc_no} literals.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnObjCBoolLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 15067,
 FQN="clang::Sema::ActOnObjCBoolLiteral", NM="_ZN5clang4Sema20ActOnObjCBoolLiteralENS_14SourceLocationENS_3tok9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema20ActOnObjCBoolLiteralENS_14SourceLocationENS_3tok9TokenKindE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnObjCBoolLiteral(SourceLocation OpLoc, /*tok.TokenKind*/char Kind) {
  assert ((Kind == tok.TokenKind.kw___objc_yes || Kind == tok.TokenKind.kw___objc_no)) : "Unknown Objective-C Boolean value!";
  QualType BoolT = $this().Context.ObjCBuiltinBoolTy.$QualType();
  if (!($this().Context.getBOOLDecl() != null)) {
    LookupResult Result = null;
    try {
      Result/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName($AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"BOOL")))), new SourceLocation(OpLoc), 
          Sema.LookupNameKind.LookupOrdinaryName);
      if ($this().LookupName(Result, $this().getCurScope()) && Result.isSingleResult()) {
        NamedDecl /*P*/ ND = Result.getFoundDecl();
        {
          TypedefDecl /*P*/ TD = dyn_cast_TypedefDecl(ND);
          if ((TD != null)) {
            $this().Context.setBOOLDecl(TD);
          }
        }
      }
    } finally {
      if (Result != null) { Result.$destroy(); }
    }
  }
  if (($this().Context.getBOOLDecl() != null)) {
    BoolT.$assignMove($this().Context.getBOOLType());
  }
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new ObjCBoolLiteralExpr(Kind == tok.TokenKind.kw___objc_yes, new QualType(BoolT), new SourceLocation(OpLoc));
       }));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnObjCAvailabilityCheckExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 15087,
 FQN="clang::Sema::ActOnObjCAvailabilityCheckExpr", NM="_ZN5clang4Sema30ActOnObjCAvailabilityCheckExprEN4llvm8ArrayRefINS_16AvailabilitySpecEEENS_14SourceLocationES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema30ActOnObjCAvailabilityCheckExprEN4llvm8ArrayRefINS_16AvailabilitySpecEEENS_14SourceLocationES5_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnObjCAvailabilityCheckExpr(ArrayRef<AvailabilitySpec> AvailSpecs, SourceLocation AtLoc, 
                              SourceLocation RParen) {
  
  StringRef Platform = $this().getASTContext().getTargetInfo().getPlatformName();
  
  /*const*/ type$ptr<AvailabilitySpec> /*P*/ Spec = std.find_if(AvailSpecs.begin(), AvailSpecs.end(), 
      /*[&, &Platform]*/ (final /*const*/ AvailabilitySpec /*&*/ Spec$1) -> {
            return $eq_StringRef(Spec$1.getPlatform(), /*NO_COPY*/Platform);
          });
  
  VersionTuple Version/*J*/= new VersionTuple();
  if ($noteq_ptr(Spec, AvailSpecs.end())) {
    Version.$assignMove(Spec.$star().getVersion());
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // This is the '*' case in @available. We should diagnose this; the
      // programmer should explicitly account for this case if they target this
      // platform.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AtLoc), diag.warn_available_using_star_case)), RParen), Platform));
    } finally {
      $c$.$destroy();
    }
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new ObjCAvailabilityCheckExpr(new VersionTuple(Version), new SourceLocation(AtLoc), new SourceLocation(RParen), $this().Context.BoolTy.$QualType());
       }));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ConversionToObjCStringLiteralCheck">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12337,
 FQN="clang::Sema::ConversionToObjCStringLiteralCheck", NM="_ZN5clang4Sema34ConversionToObjCStringLiteralCheckENS_8QualTypeERPNS_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema34ConversionToObjCStringLiteralCheckENS_8QualTypeERPNS_4ExprEb")
//</editor-fold>
public final boolean ConversionToObjCStringLiteralCheck(QualType DstType, final type$ref<Expr /*P*/ /*&*/> Exp) {
  return ConversionToObjCStringLiteralCheck(DstType, Exp, 
                                  true);
}
public final boolean ConversionToObjCStringLiteralCheck(QualType DstType, final type$ref<Expr /*P*/ /*&*/> Exp, 
                                  boolean Diagnose/*= true*/) {
  if (!$this().getLangOpts().ObjC1) {
    return false;
  }
  
  /*const*/ ObjCObjectPointerType /*P*/ PT = DstType.$arrow().getAs(ObjCObjectPointerType.class);
  if (!(PT != null)) {
    return false;
  }
  if (!PT.isObjCIdType()) {
    // Check if the destination is the 'NSString' interface.
    /*const*/ ObjCInterfaceDecl /*P*/ ID = PT.getInterfaceDecl();
    if (!(ID != null) || !ID.getIdentifier().isStr(/*KEEP_STR*/"NSString")) {
      return false;
    }
  }
  
  // Ignore any parens, implicit casts (should only be
  // array-to-pointer decays), and not-so-opaque values.  The last is
  // important for making this trigger for property assignments.
  Expr /*P*/ SrcExpr = Exp.$deref().IgnoreParenImpCasts();
  {
    OpaqueValueExpr /*P*/ OV = dyn_cast_OpaqueValueExpr(SrcExpr);
    if ((OV != null)) {
      if ((OV.getSourceExpr() != null)) {
        SrcExpr = OV.getSourceExpr().IgnoreParenImpCasts();
      }
    }
  }
  
  StringLiteral /*P*/ SL = dyn_cast_StringLiteral(SrcExpr);
  if (!(SL != null) || !SL.isAscii()) {
    return false;
  }
  if (Diagnose) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SL.getLocStart(), diag.err_missing_atsign_prefix)), 
          FixItHint.CreateInsertion(SL.getLocStart(), new StringRef(/*KEEP_STR*/$AT))));
      Exp.$set($this().BuildObjCStringLiteral(SL.getLocStart(), SL).get());
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}


// UsualUnaryConversions - promotes integers (C99 6.3.1.1p2) and converts
// functions and arrays to their respective pointers (C99 6.3.2.1).

/// UsualUnaryConversions - Performs various conversions that are common to most
/// operators (C99 6.3). The conversions of array and function types are
/// sometimes suppressed. For example, the array->pointer conversion doesn't
/// apply if the array is an argument to the sizeof or address (&) operators.
/// In these instances, this routine should *not* be called.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::UsualUnaryConversions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 761,
 FQN="clang::Sema::UsualUnaryConversions", NM="_ZN5clang4Sema21UsualUnaryConversionsEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema21UsualUnaryConversionsEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > UsualUnaryConversions(Expr /*P*/ E) {
  // First, convert to an r-value.
  ActionResultTTrue<Expr /*P*/ > Res = $this().DefaultFunctionArrayLvalueConversion(E);
  if (Res.isInvalid()) {
    return ExprError();
  }
  E = Res.get();
  
  QualType Ty = E.getType();
  assert (!Ty.isNull()) : "UsualUnaryConversions - missing type";
  
  // Half FP have to be promoted to float unless it is natively supported
  if (Ty.$arrow().isHalfType() && !$this().getLangOpts().NativeHalfType) {
    return $this().ImpCastExprToType(Res.get(), $this().Context.FloatTy.$QualType(), CastKind.CK_FloatingCast);
  }
  
  // Try to perform integral promotions if the object has a theoretically
  // promotable type.
  if (Ty.$arrow().isIntegralOrUnscopedEnumerationType()) {
    // C99 6.3.1.1p2:
    //
    //   The following may be used in an expression wherever an int or
    //   unsigned int may be used:
    //     - an object or expression with an integer type whose integer
    //       conversion rank is less than or equal to the rank of int
    //       and unsigned int.
    //     - A bit-field of type _Bool, int, signed int, or unsigned int.
    //
    //   If an int can represent all values of the original type, the
    //   value is converted to an int; otherwise, it is converted to an
    //   unsigned int. These are called the integer promotions. All
    //   other types are unchanged by the integer promotions.
    QualType PTy = $this().Context.isPromotableBitField(E);
    if (!PTy.isNull()) {
      E = $this().ImpCastExprToType(E, new QualType(PTy), CastKind.CK_IntegralCast).get();
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    if (Ty.$arrow().isPromotableIntegerType()) {
      QualType PT = $this().Context.getPromotedIntegerType(new QualType(Ty));
      E = $this().ImpCastExprToType(E, new QualType(PT), CastKind.CK_IntegralCast).get();
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
  }
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
}


/// CallExprUnaryConversions - a special case of an unary conversion
/// performed on a function designator of a call expression.

/// CallExprUnaryConversions - a special case of an unary conversion
/// performed on a function designator of a call expression.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CallExprUnaryConversions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 739,
 FQN="clang::Sema::CallExprUnaryConversions", NM="_ZN5clang4Sema24CallExprUnaryConversionsEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema24CallExprUnaryConversionsEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CallExprUnaryConversions(Expr /*P*/ E) {
  QualType Ty = E.getType();
  ActionResultTTrue<Expr /*P*/ > Res = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  // Only do implicit cast for a function type, but not for a pointer
  // to function type.
  if (Ty.$arrow().isFunctionType()) {
    Res.$assign($this().ImpCastExprToType(E, $this().Context.getPointerType(new QualType(Ty)), 
            CastKind.CK_FunctionToPointerDecay).get());
    if (Res.isInvalid()) {
      return ExprError();
    }
  }
  Res.$assignMove($this().DefaultLvalueConversion(Res.get()));
  if (Res.isInvalid()) {
    return ExprError();
  }
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Res.get());
}


// DefaultFunctionArrayConversion - converts functions and arrays
// to their respective pointers (C99 6.3.2.1).

//===----------------------------------------------------------------------===//
//  Standard Promotions and Conversions
//===----------------------------------------------------------------------===//

/// DefaultFunctionArrayConversion (C99 6.3.2.1p3, C99 6.3.2.1p4).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DefaultFunctionArrayConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 509,
 FQN="clang::Sema::DefaultFunctionArrayConversion", NM="_ZN5clang4Sema30DefaultFunctionArrayConversionEPNS_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema30DefaultFunctionArrayConversionEPNS_4ExprEb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > DefaultFunctionArrayConversion(Expr /*P*/ E) {
  return DefaultFunctionArrayConversion(E, true);
}
public final ActionResultTTrue<Expr /*P*/ > DefaultFunctionArrayConversion(Expr /*P*/ E, boolean Diagnose/*= true*/) {
  // Handle any placeholder expressions which made it here.
  if (E.getType().$arrow().isPlaceholderType()) {
    ActionResultTTrue<Expr /*P*/ > result = $this().CheckPlaceholderExpr(E);
    if (result.isInvalid()) {
      return ExprError();
    }
    E = result.get();
  }
  
  QualType Ty = E.getType();
  assert (!Ty.isNull()) : "DefaultFunctionArrayConversion - missing type";
  if (Ty.$arrow().isFunctionType()) {
    // If we are here, we are not calling a function but taking
    // its address (which is not allowed in OpenCL v1.0 s6.8.a.3).
    if ($this().getLangOpts().OpenCL) {
      if (Diagnose) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(E.getExprLoc(), diag.err_opencl_taking_function_address)));
        } finally {
          $c$.$destroy();
        }
      }
      return ExprError();
    }
    {
      
      DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E.IgnoreParenCasts());
      if ((DRE != null)) {
        {
          FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(DRE.getDecl());
          if ((FD != null)) {
            if (!$this().checkAddressOfFunctionIsAvailable(FD, Diagnose, E.getExprLoc())) {
              return ExprError();
            }
          }
        }
      }
    }
    
    E = $this().ImpCastExprToType(E, $this().Context.getPointerType(new QualType(Ty)), 
        CastKind.CK_FunctionToPointerDecay).get();
  } else if (Ty.$arrow().isArrayType()) {
    // In C90 mode, arrays only promote to pointers if the array expression is
    // an lvalue.  The relevant legalese is C90 6.2.2.1p3: "an lvalue that has
    // type 'array of type' is converted to an expression that has type 'pointer
    // to type'...".  In C99 this was changed to: C99 6.3.2.1p3: "an expression
    // that has type 'array of type' ...".  The relevant change is "an lvalue"
    // (C90) to "an expression" (C99).
    //
    // C++ 4.2p1:
    // An lvalue or rvalue of type "array of N T" or "array of unknown bound of
    // T" can be converted to an rvalue of type "pointer to T".
    //
    if ($this().getLangOpts().C99 || $this().getLangOpts().CPlusPlus || E.isLValue()) {
      E = $this().ImpCastExprToType(E, $this().Context.getArrayDecayedType(new QualType(Ty)), 
          CastKind.CK_ArrayToPointerDecay).get();
    }
  }
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
}


// DefaultFunctionArrayLvalueConversion - converts functions and
// arrays to their respective pointers and performs the
// lvalue-to-rvalue conversion.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DefaultFunctionArrayLvalueConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 727,
 FQN="clang::Sema::DefaultFunctionArrayLvalueConversion", NM="_ZN5clang4Sema36DefaultFunctionArrayLvalueConversionEPNS_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema36DefaultFunctionArrayLvalueConversionEPNS_4ExprEb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > DefaultFunctionArrayLvalueConversion(Expr /*P*/ E) {
  return DefaultFunctionArrayLvalueConversion(E, true);
}
public final ActionResultTTrue<Expr /*P*/ > DefaultFunctionArrayLvalueConversion(Expr /*P*/ E, boolean Diagnose/*= true*/) {
  ActionResultTTrue<Expr /*P*/ > Res = $this().DefaultFunctionArrayConversion(E, Diagnose);
  if (Res.isInvalid()) {
    return ExprError();
  }
  Res.$assignMove($this().DefaultLvalueConversion(Res.get()));
  if (Res.isInvalid()) {
    return ExprError();
  }
  return Res;
}


// DefaultLvalueConversion - performs lvalue-to-rvalue conversion on
// the operand.  This is DefaultFunctionArrayLvalueConversion,
// except that it assumes the operand isn't of function or array
// type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DefaultLvalueConversion">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 630,
 FQN="clang::Sema::DefaultLvalueConversion", NM="_ZN5clang4Sema23DefaultLvalueConversionEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema23DefaultLvalueConversionEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > DefaultLvalueConversion(Expr /*P*/ E) {
  // Handle any placeholder expressions which made it here.
  if (E.getType().$arrow().isPlaceholderType()) {
    ActionResultTTrue<Expr /*P*/ > result = $this().CheckPlaceholderExpr(E);
    if (result.isInvalid()) {
      return ExprError();
    }
    E = result.get();
  }
  
  // C++ [conv.lval]p1:
  //   A glvalue of a non-function, non-array type T can be
  //   converted to a prvalue.
  if (!E.isGLValue()) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }
  
  QualType T = E.getType();
  assert (!T.isNull()) : "r-value conversion on typeless expression?";
  
  // We don't want to throw lvalue-to-rvalue casts on top of
  // expressions of certain types in C++.
  if ($this().getLangOpts().CPlusPlus
     && ($eq_QualType$C(E.getType(), $this().Context.OverloadTy.$QualType())
     || T.$arrow().isDependentType()
     || T.$arrow().isRecordType())) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }
  
  // The C standard is actually really unclear on this point, and
  // DR106 tells us what the result should be but not why.  It's
  // generally best to say that void types just doesn't undergo
  // lvalue-to-rvalue at all.  Note that expressions of unqualified
  // 'void' type are never l-values, but qualified void can be.
  if (T.$arrow().isVoidType()) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }
  
  // OpenCL usually rejects direct accesses to values of 'half' type.
  if ($this().getLangOpts().OpenCL && !$this().getOpenCLOptions().cl_khr_fp16
     && T.$arrow().isHalfType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.err_opencl_half_load_store)), 
              0), T));
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  
  SemaExprStatics.CheckForNullPointerDereference(/*Deref*/$this(), E);
  {
    /*const*/ ObjCIsaExpr /*P*/ OISA = dyn_cast_ObjCIsaExpr(E.IgnoreParenCasts());
    if ((OISA != null)) {
      NamedDecl /*P*/ ObjectGetClass = $this().LookupSingleName($this().TUScope, 
          new DeclarationName($AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"object_getClass")))), 
          new SourceLocation(), LookupNameKind.LookupOrdinaryName);
      if ((ObjectGetClass != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.warn_objc_isa_use)), 
                  FixItHint.CreateInsertion(OISA.getLocStart(), new StringRef(/*KEEP_STR*/"object_getClass("))), 
              FixItHint.CreateReplacement(new SourceRange(OISA.getOpLoc(), OISA.getIsaMemberLoc()), new StringRef(/*KEEP_STR*/$RPAREN))));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(E.getExprLoc(), diag.warn_objc_isa_use)));
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      /*const*/ ObjCIvarRefExpr /*P*/ OIRE = dyn_cast_ObjCIvarRefExpr(E.IgnoreParenCasts());
      if ((OIRE != null)) {
        DiagnoseDirectIsaAccess(/*Deref*/$this(), OIRE, new SourceLocation(), /* Expr*/ (/*const*/ Expr /*P*/ )null);
      }
    }
  }
  
  // C++ [conv.lval]p1:
  //   [...] If T is a non-class type, the type of the prvalue is the
  //   cv-unqualified version of T. Otherwise, the type of the
  //   rvalue is T.
  //
  // C99 6.3.2.1p2:
  //   If the lvalue has qualified type, the value has the unqualified
  //   version of the type of the lvalue; otherwise, the value has the
  //   type of the lvalue.
  if (T.hasQualifiers()) {
    T.$assignMove(T.getUnqualifiedType());
  }
  
  // Under the MS ABI, lock down the inheritance model now.
  if (T.$arrow().isMemberPointerType()
     && $this().Context.getTargetInfo().getCXXABI().isMicrosoft()) {
    /*J:(void)*/$this().isCompleteType(E.getExprLoc(), new QualType(T));
  }
  
  $this().UpdateMarkingForLValueToRValue(E);
  
  // Loading a __weak object implicitly retains the value, so we need a cleanup to 
  // balance that.
  if ($this().getLangOpts().ObjCAutoRefCount
     && E.getType().getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Weak) {
    $this().Cleanup.setExprNeedsCleanups(true);
  }
  
  ActionResultTTrue<Expr /*P*/ > Res = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, ImplicitCastExpr.Create($this().Context, new QualType(T), CastKind.CK_LValueToRValue, E, 
          (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, ExprValueKind.VK_RValue));
  {
    
    // C11 6.3.2.1p2:
    //   ... if the lvalue has atomic type, the value has the non-atomic version 
    //   of the type of the lvalue ...
    /*const*/ AtomicType /*P*/ Atomic = T.$arrow().getAs(AtomicType.class);
    if ((Atomic != null)) {
      T.$assignMove(Atomic.getValueType().getUnqualifiedType());
      Res.$assign(ImplicitCastExpr.Create($this().Context, new QualType(T), CastKind.CK_AtomicToNonAtomic, Res.get(), 
              (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, ExprValueKind.VK_RValue));
    }
  }
  
  return Res;
}


// DefaultArgumentPromotion (C99 6.5.2.2p6). Used for function calls that
// do not have a prototype. Integer promotions are performed on each
// argument, and arguments that have type float are promoted to double.

/// DefaultArgumentPromotion (C99 6.5.2.2p6). Used for function calls that
/// do not have a prototype. Arguments that have type float or __fp16
/// are promoted to double. All other argument types are converted by
/// UsualUnaryConversions().
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DefaultArgumentPromotion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 810,
 FQN="clang::Sema::DefaultArgumentPromotion", NM="_ZN5clang4Sema24DefaultArgumentPromotionEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema24DefaultArgumentPromotionEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > DefaultArgumentPromotion(Expr /*P*/ E) {
  QualType Ty = E.getType();
  assert (!Ty.isNull()) : "DefaultArgumentPromotion - missing type";
  
  ActionResultTTrue<Expr /*P*/ > Res = $this().UsualUnaryConversions(E);
  if (Res.isInvalid()) {
    return ExprError();
  }
  E = Res.get();
  
  // If this is a 'float' or '__fp16' (CVR qualified or typedef) promote to
  // double.
  /*const*/ BuiltinType /*P*/ BTy = Ty.$arrow().getAs$BuiltinType();
  if ((BTy != null) && (BTy.getKind() == BuiltinType.Kind.Half
     || BTy.getKind() == BuiltinType.Kind.Float)) {
    E = $this().ImpCastExprToType(E, $this().Context.DoubleTy.$QualType(), CastKind.CK_FloatingCast).get();
  }
  
  // C++ performs lvalue-to-rvalue conversion as a default argument
  // promotion, even on class types, but note:
  //   C++11 [conv.lval]p2:
  //     When an lvalue-to-rvalue conversion occurs in an unevaluated
  //     operand or a subexpression thereof the value contained in the
  //     referenced object is not accessed. Otherwise, if the glvalue
  //     has a class type, the conversion copy-initializes a temporary
  //     of type T from the glvalue and the result of the conversion
  //     is a prvalue for the temporary.
  // FIXME: add some way to gate this entire thing for correctness in
  // potentially potentially evaluated contexts.
  if ($this().getLangOpts().CPlusPlus && E.isGLValue() && !$this().isUnevaluatedContext()) {
    ActionResultTTrue<Expr /*P*/ > Temp = $this().PerformCopyInitialization(InitializedEntity.InitializeTemporary(E.getType()), 
        E.getExprLoc(), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E));
    if (Temp.isInvalid()) {
      return ExprError();
    }
    E = Temp.get();
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::getVariadicCallType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 4599,
 FQN="clang::Sema::getVariadicCallType", NM="_ZN5clang4Sema19getVariadicCallTypeEPNS_12FunctionDeclEPKNS_17FunctionProtoTypeEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema19getVariadicCallTypeEPNS_12FunctionDeclEPKNS_17FunctionProtoTypeEPNS_4ExprE")
//</editor-fold>
public final Sema.VariadicCallType getVariadicCallType(FunctionDecl /*P*/ FDecl, /*const*/ FunctionProtoType /*P*/ Proto, 
                   Expr /*P*/ Fn) {
  if ((Proto != null) && Proto.isVariadic()) {
    if ((dyn_cast_or_null_CXXConstructorDecl(FDecl) != null)) {
      return VariadicCallType.VariadicConstructor;
    } else if ((Fn != null) && Fn.getType().$arrow().isBlockPointerType()) {
      return VariadicCallType.VariadicBlock;
    } else if ((FDecl != null)) {
      {
        CXXMethodDecl /*P*/ Method = dyn_cast_or_null_CXXMethodDecl(FDecl);
        if ((Method != null)) {
          if (Method.isInstance()) {
            return VariadicCallType.VariadicMethod;
          }
        }
      }
    } else if ((Fn != null) && $eq_QualType$C(Fn.getType(), $this().Context.BoundMemberTy.$QualType())) {
      return VariadicCallType.VariadicMethod;
    }
    return VariadicCallType.VariadicFunction;
  }
  return VariadicCallType.VariadicDoesNotApply;
}


// Determines which VarArgKind fits an expression.

/// Determine the degree of POD-ness for an expression.
/// Incomplete types are considered POD, since this check can be performed
/// when we're in an unevaluated context.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isValidVarArgType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 852,
 FQN="clang::Sema::isValidVarArgType", NM="_ZN5clang4Sema17isValidVarArgTypeERKNS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema17isValidVarArgTypeERKNS_8QualTypeE")
//</editor-fold>
public final Sema.VarArgKind isValidVarArgType(final /*const*/ QualType /*&*/ Ty) {
  if (Ty.$arrow().isIncompleteType()) {
    // C++11 [expr.call]p7:
    //   After these conversions, if the argument does not have arithmetic,
    //   enumeration, pointer, pointer to member, or class type, the program
    //   is ill-formed.
    //
    // Since we've already performed array-to-pointer and function-to-pointer
    // decay, the only such type in C++ is cv void. This also handles
    // initializer lists as variadic arguments.
    if (Ty.$arrow().isVoidType()) {
      return VarArgKind.VAK_Invalid;
    }
    if (Ty.$arrow().isObjCObjectType()) {
      return VarArgKind.VAK_Invalid;
    }
    return VarArgKind.VAK_Valid;
  }
  if (Ty.isCXX98PODType($this().Context)) {
    return VarArgKind.VAK_Valid;
  }
  
  // C++11 [expr.call]p7:
  //   Passing a potentially-evaluated argument of class type (Clause 9)
  //   having a non-trivial copy constructor, a non-trivial move constructor,
  //   or a non-trivial destructor, with no corresponding parameter,
  //   is conditionally-supported with implementation-defined semantics.
  if ($this().getLangOpts().CPlusPlus11 && !Ty.$arrow().isDependentType()) {
    {
      CXXRecordDecl /*P*/ Record = Ty.$arrow().getAsCXXRecordDecl();
      if ((Record != null)) {
        if (!Record.hasNonTrivialCopyConstructor()
           && !Record.hasNonTrivialMoveConstructor()
           && !Record.hasNonTrivialDestructor()) {
          return VarArgKind.VAK_ValidInCXX11;
        }
      }
    }
  }
  if ($this().getLangOpts().ObjCAutoRefCount && Ty.$arrow().isObjCLifetimeType()) {
    return VarArgKind.VAK_Valid;
  }
  if (Ty.$arrow().isObjCObjectType()) {
    return VarArgKind.VAK_Invalid;
  }
  if ($this().getLangOpts().MSVCCompat) {
    return VarArgKind.VAK_MSVCUndefined;
  }
  
  // FIXME: In C++11, these cases are conditionally-supported, meaning we're
  // permitted to reject them. We should consider doing so.
  return VarArgKind.VAK_Undefined;
}


/// Check to see if the given expression is a valid argument to a variadic
/// function, issuing a diagnostic if not.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkVariadicArgument">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 899,
 FQN="clang::Sema::checkVariadicArgument", NM="_ZN5clang4Sema21checkVariadicArgumentEPKNS_4ExprENS0_16VariadicCallTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema21checkVariadicArgumentEPKNS_4ExprENS0_16VariadicCallTypeE")
//</editor-fold>
public final void checkVariadicArgument(/*const*/ Expr /*P*/ E, VariadicCallType CT) {
  // Don't allow one to pass an Objective-C interface to a vararg.
  final /*const*/ QualType /*&*/ Ty = E.getType();
  VarArgKind VAK = $this().isValidVarArgType(Ty);
  
  // Complain about passing non-POD types through varargs.
  switch (VAK) {
   case VAK_ValidInCXX11:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($this().DiagRuntimeBehavior(E.getLocStart(), (/*const*/ Stmt /*P*/ )null, 
            $out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_QualType($c$.track($this().PDiag(diag.warn_cxx98_compat_pass_non_pod_arg_to_vararg)), 
                    /*NO_COPY*/Ty), CT.getValue())));
      } finally {
        $c$.$destroy();
      }
    }
   case VAK_Valid:
    // Fall through.
    if (Ty.$arrow().isRecordType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // This is unlikely to be what the user intended. If the class has a
        // 'c_str' member function, the user probably meant to call that.
        $c$.clean($this().DiagRuntimeBehavior(E.getLocStart(), (/*const*/ Stmt /*P*/ )null, 
            $out_PartialDiagnostic$C_char$ptr$C($out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_QualType($c$.track($this().PDiag(diag.warn_pass_class_arg_to_vararg)), 
                            /*NO_COPY*/Ty), CT.getValue()), ($this().hasCStrMethod(E) ? 1 : 0)), $(".c_str()"))));///*KEEP_STR*/".c_str()")));
      } finally {
        $c$.$destroy();
      }
    }
    break;
   case VAK_Undefined:
   case VAK_MSVCUndefined:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($this().DiagRuntimeBehavior(E.getLocStart(), (/*const*/ Stmt /*P*/ )null, 
            $out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_uint($c$.track($this().PDiag(diag.warn_cannot_pass_non_pod_arg_to_vararg)), 
                        $this().getLangOpts().CPlusPlus11?0:1), /*NO_COPY*/Ty), CT.getValue())));
        break;
      } finally {
        $c$.$destroy();
      }
    }
   case VAK_Invalid:
    if (Ty.$arrow().isObjCObjectType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($this().DiagRuntimeBehavior(E.getLocStart(), (/*const*/ Stmt /*P*/ )null, 
            $out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_QualType($c$.track($this().PDiag(diag.err_cannot_pass_objc_interface_to_vararg)), 
                    /*NO_COPY*/Ty), CT.getValue())));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getLocStart(), diag.err_cannot_pass_to_vararg)), 
                    isa_InitListExpr(E)), Ty), CT));
      } finally {
        $c$.$destroy();
      }
    }
    break;
  }
}


/// GatherArgumentsForCall - Collector argument expressions for various
/// form of call prototypes.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::GatherArgumentsForCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 4801,
 FQN="clang::Sema::GatherArgumentsForCall", NM="_ZN5clang4Sema22GatherArgumentsForCallENS_14SourceLocationEPNS_12FunctionDeclEPKNS_17FunctionProtoTypeEjN4llvm8ArrayRefIPNS_4ExprEEERNS7_15SmallVectorImplISA_EENS0_16VariadicCallTypeEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema22GatherArgumentsForCallENS_14SourceLocationEPNS_12FunctionDeclEPKNS_17FunctionProtoTypeEjN4llvm8ArrayRefIPNS_4ExprEEERNS7_15SmallVectorImplISA_EENS0_16VariadicCallTypeEbb")
//</editor-fold>
public final boolean GatherArgumentsForCall(SourceLocation CallLoc, FunctionDecl /*P*/ FDecl, 
                      /*const*/ FunctionProtoType /*P*/ Proto, 
                      /*uint*/int FirstParam, ArrayRef<Expr /*P*/ > Args, 
                      final SmallVectorImpl<Expr /*P*/ > /*&*/ AllArgs) {
  return GatherArgumentsForCall(CallLoc, FDecl, 
                      Proto, 
                      FirstParam, Args, 
                      AllArgs, 
                      VariadicCallType.VariadicDoesNotApply, false, 
                      false);
}
public final boolean GatherArgumentsForCall(SourceLocation CallLoc, FunctionDecl /*P*/ FDecl, 
                      /*const*/ FunctionProtoType /*P*/ Proto, 
                      /*uint*/int FirstParam, ArrayRef<Expr /*P*/ > Args, 
                      final SmallVectorImpl<Expr /*P*/ > /*&*/ AllArgs, 
                      VariadicCallType CallType/*= VariadicDoesNotApply*/) {
  return GatherArgumentsForCall(CallLoc, FDecl, 
                      Proto, 
                      FirstParam, Args, 
                      AllArgs, 
                      CallType, false, 
                      false);
}
public final boolean GatherArgumentsForCall(SourceLocation CallLoc, FunctionDecl /*P*/ FDecl, 
                      /*const*/ FunctionProtoType /*P*/ Proto, 
                      /*uint*/int FirstParam, ArrayRef<Expr /*P*/ > Args, 
                      final SmallVectorImpl<Expr /*P*/ > /*&*/ AllArgs, 
                      VariadicCallType CallType/*= VariadicDoesNotApply*/, boolean AllowExplicit/*= false*/) {
  return GatherArgumentsForCall(CallLoc, FDecl, 
                      Proto, 
                      FirstParam, Args, 
                      AllArgs, 
                      CallType, AllowExplicit, 
                      false);
}
public final boolean GatherArgumentsForCall(SourceLocation CallLoc, FunctionDecl /*P*/ FDecl, 
                      /*const*/ FunctionProtoType /*P*/ Proto, 
                      /*uint*/int FirstParam, ArrayRef<Expr /*P*/ > Args, 
                      final SmallVectorImpl<Expr /*P*/ > /*&*/ AllArgs, 
                      VariadicCallType CallType/*= VariadicDoesNotApply*/, boolean AllowExplicit/*= false*/, 
                      boolean IsListInitialization/*= false*/) {
  /*uint*/int NumParams = Proto.getNumParams();
  boolean Invalid = false;
  /*size_t*/int ArgIx = 0;
  // Continue to check argument types (even if we have too few/many args).
  for (/*uint*/int i = FirstParam; $less_uint(i, NumParams); i++) {
    QualType ProtoArgType = Proto.getParamType(i);
    
    Expr /*P*/ Arg;
    ParmVarDecl /*P*/ Param = (FDecl != null) ? FDecl.getParamDecl(i) : null;
    if ($less_uint(ArgIx, Args.size())) {
      Arg = Args.$at(ArgIx++);
      if ($this().RequireCompleteType$T(Arg.getLocStart(), 
          new QualType(ProtoArgType), 
          diag.err_call_incomplete_argument, Arg)) {
        return true;
      }
      
      // Strip the unbridged-cast placeholder expression off, if applicable.
      boolean CFAudited = false;
      if ($eq_QualType$C(Arg.getType(), $this().Context.ARCUnbridgedCastTy.$QualType())
         && (FDecl != null) && FDecl.hasAttr(CFAuditedTransferAttr.class)
         && (!(Param != null) || !Param.hasAttr(CFConsumedAttr.class))) {
        Arg = $this().stripARCUnbridgedCast(Arg);
      } else if ($this().getLangOpts().ObjCAutoRefCount
         && (FDecl != null) && FDecl.hasAttr(CFAuditedTransferAttr.class)
         && (!(Param != null) || !Param.hasAttr(CFConsumedAttr.class))) {
        CFAudited = true;
      }
      
      InitializedEntity Entity = (Param != null) ? InitializedEntity.InitializeParameter($this().Context, Param, 
          new QualType(ProtoArgType)) : InitializedEntity.InitializeParameter($this().Context, new QualType(ProtoArgType), Proto.isParamConsumed(i));
      
      // Remember that parameter belongs to a CF audited API.
      if (CFAudited) {
        Entity.setParameterCFAudited();
      }
      
      ActionResultTTrue<Expr /*P*/ > ArgE = $this().PerformCopyInitialization(Entity, new SourceLocation(), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Arg), IsListInitialization, AllowExplicit);
      if (ArgE.isInvalid()) {
        return true;
      }
      
      Arg = ArgE.getAs(Expr.class);
    } else {
      assert ((Param != null)) : "can't use default arguments without a known callee";
      
      ActionResultTTrue<Expr /*P*/ > ArgExpr = $this().BuildCXXDefaultArgExpr(new SourceLocation(CallLoc), FDecl, Param);
      if (ArgExpr.isInvalid()) {
        return true;
      }
      
      Arg = ArgExpr.getAs(Expr.class);
    }
    
    // Check for array bounds violations for each argument to the call. This
    // check only triggers warnings when the argument isn't a more complex Expr
    // with its own checking, such as a BinaryOperator.
    $this().CheckArrayAccess(Arg);
    
    // Check for violations of C99 static array rules (C99 6.7.5.3p7).
    $this().CheckStaticArrayArgument(new SourceLocation(CallLoc), Param, Arg);
    
    AllArgs.push_back(Arg);
  }
  
  // If this is a variadic call, handle args passed through "...".
  if (CallType != VariadicCallType.VariadicDoesNotApply) {
    // Assume that extern "C" functions with variadic arguments that
    // return __unknown_anytype aren't *really* variadic.
    if ($eq_QualType$C(Proto.getReturnType(), $this().Context.UnknownAnyTy.$QualType()) && (FDecl != null)
       && FDecl.isExternC()) {
      for (Expr /*P*/ A : Args.slice(ArgIx)) {
        QualType paramType/*J*/= new QualType(); // ignored
        ActionResultTTrue<Expr /*P*/ > arg = $this().checkUnknownAnyArg(new SourceLocation(CallLoc), A, paramType);
        Invalid |= arg.isInvalid();
        AllArgs.push_back(arg.get());
      }
      // Otherwise do argument promotion, (C99 6.5.2.2p7).
    } else {
      for (Expr /*P*/ A : Args.slice(ArgIx)) {
        ActionResultTTrue<Expr /*P*/ > Arg = $this().DefaultVariadicArgumentPromotion(A, CallType, FDecl);
        Invalid |= Arg.isInvalid();
        AllArgs.push_back(Arg.get());
      }
    }
    
    // Check for array bounds violations.
    for (Expr /*P*/ A : Args.slice(ArgIx))  {
      $this().CheckArrayAccess(A);
    }
  }
  return Invalid;
}


// DefaultVariadicArgumentPromotion - Like DefaultArgumentPromotion, but
// will create a runtime trap if the resulting type is not a POD type.

/// DefaultVariadicArgumentPromotion - Like DefaultArgumentPromotion, but
/// will create a trap if the resulting type is not a POD type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DefaultVariadicArgumentPromotion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 945,
 FQN="clang::Sema::DefaultVariadicArgumentPromotion", NM="_ZN5clang4Sema32DefaultVariadicArgumentPromotionEPNS_4ExprENS0_16VariadicCallTypeEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema32DefaultVariadicArgumentPromotionEPNS_4ExprENS0_16VariadicCallTypeEPNS_12FunctionDeclE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > DefaultVariadicArgumentPromotion(Expr /*P*/ E, VariadicCallType CT, 
                                FunctionDecl /*P*/ FDecl) {
  {
    /*const*/ BuiltinType /*P*/ PlaceholderTy = E.getType().$arrow().getAsPlaceholderType();
    if ((PlaceholderTy != null)) {
      // Strip the unbridged-cast placeholder expression off, if applicable.
      if (PlaceholderTy.getKind() == BuiltinType.Kind.ARCUnbridgedCast
         && (CT == VariadicCallType.VariadicMethod
         || ((FDecl != null) && FDecl.hasAttr(CFAuditedTransferAttr.class)))) {
        E = $this().stripARCUnbridgedCast(E);
        // Otherwise, do normal placeholder checking.
      } else {
        ActionResultTTrue<Expr /*P*/ > ExprRes = $this().CheckPlaceholderExpr(E);
        if (ExprRes.isInvalid()) {
          return ExprError();
        }
        E = ExprRes.get();
      }
    }
  }
  
  ActionResultTTrue<Expr /*P*/ > ExprRes = $this().DefaultArgumentPromotion(E);
  if (ExprRes.isInvalid()) {
    return ExprError();
  }
  E = ExprRes.get();
  
  // Diagnostics regarding non-POD argument types are
  // emitted along with format string checking in Sema::CheckFunctionCall().
  if ($this().isValidVarArgType(E.getType()) == VarArgKind.VAK_Undefined) {
    CXXScopeSpec SS = null;
    try {
      // Turn this into a trap.
      SS/*J*/= new CXXScopeSpec();
      SourceLocation TemplateKWLoc/*J*/= new SourceLocation();
      UnqualifiedId Name/*J*/= new UnqualifiedId();
      Name.setIdentifier($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"__builtin_trap")), 
          E.getLocStart());
      ActionResultTTrue<Expr /*P*/ > TrapFn = $this().ActOnIdExpression($this().TUScope, SS, new SourceLocation(TemplateKWLoc), 
          Name, true, false);
      if (TrapFn.isInvalid()) {
        return ExprError();
      }
      
      ActionResultTTrue<Expr /*P*/ > Call = $this().ActOnCallExpr($this().TUScope, TrapFn.get(), 
          E.getLocStart(), new MutableArrayRef<Expr /*P*/ >(None, true), 
          E.getLocEnd());
      if (Call.isInvalid()) {
        return ExprError();
      }
      
      ActionResultTTrue<Expr /*P*/ > Comma = $this().ActOnBinOp($this().TUScope, E.getLocStart(), tok.TokenKind.comma, 
          Call.get(), E);
      if (Comma.isInvalid()) {
        return ExprError();
      }
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Comma.get());
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }
  if (!$this().getLangOpts().CPlusPlus
     && $this().RequireCompleteType(E.getExprLoc(), E.getType(), 
      diag.err_call_incomplete_argument)) {
    return ExprError();
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
}


// UsualArithmeticConversions - performs the UsualUnaryConversions on it's
// operands and then handles various conversions that are common to binary
// operators (C99 6.3.1.8). If both operands aren't arithmetic, this
// routine returns the first non-arithmetic type found. The client is
// responsible for emitting appropriate error diagnostics.

/// UsualArithmeticConversions - Performs various conversions that are common to
/// binary operators (C99 6.3.1.8). If both operands aren't arithmetic, this
/// routine returns the first non-arithmetic type found. The client is
/// responsible for emitting appropriate error diagnostics.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::UsualArithmeticConversions">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 1310,
 FQN="clang::Sema::UsualArithmeticConversions", NM="_ZN5clang4Sema26UsualArithmeticConversionsERNS_12ActionResultIPNS_4ExprELb1EEES5_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema26UsualArithmeticConversionsERNS_12ActionResultIPNS_4ExprELb1EEES5_b")
//</editor-fold>
public final QualType UsualArithmeticConversions(final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS) {
  return UsualArithmeticConversions(LHS, RHS, 
                          false);
}
public final QualType UsualArithmeticConversions(final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                          boolean IsCompAssign/*= false*/) {
  if (!IsCompAssign) {
    LHS.$assignMove($this().UsualUnaryConversions(LHS.get()));
    if (LHS.isInvalid()) {
      return new QualType();
    }
  }
  
  RHS.$assignMove($this().UsualUnaryConversions(RHS.get()));
  if (RHS.isInvalid()) {
    return new QualType();
  }
  
  // For conversion purposes, we ignore any qualifiers.
  // For example, "const float" and "float" are equivalent.
  QualType LHSType = $this().Context.getCanonicalType(LHS.get().getType()).getUnqualifiedType().$QualType();
  QualType RHSType = $this().Context.getCanonicalType(RHS.get().getType()).getUnqualifiedType().$QualType();
  {
    
    // For conversion purposes, we ignore any atomic qualifier on the LHS.
    /*const*/ AtomicType /*P*/ AtomicLHS = LHSType.$arrow().getAs(AtomicType.class);
    if ((AtomicLHS != null)) {
      LHSType.$assignMove(AtomicLHS.getValueType());
    }
  }
  
  // If both types are identical, no conversion is needed.
  if ($eq_QualType$C(LHSType, RHSType)) {
    return LHSType;
  }
  
  // If either side is a non-arithmetic type (e.g. a pointer), we are done.
  // The caller can deal with this (e.g. pointer + int).
  if (!LHSType.$arrow().isArithmeticType() || !RHSType.$arrow().isArithmeticType()) {
    return new QualType();
  }
  
  // Apply unary and bitfield promotions to the LHS's type.
  QualType LHSUnpromotedType = new QualType(LHSType);
  if (LHSType.$arrow().isPromotableIntegerType()) {
    LHSType.$assignMove($this().Context.getPromotedIntegerType(new QualType(LHSType)));
  }
  QualType LHSBitfieldPromoteTy = $this().Context.isPromotableBitField(LHS.get());
  if (!LHSBitfieldPromoteTy.isNull()) {
    LHSType.$assign(LHSBitfieldPromoteTy);
  }
  if ($noteq_QualType$C(LHSType, LHSUnpromotedType) && !IsCompAssign) {
    LHS.$assignMove($this().ImpCastExprToType(LHS.get(), new QualType(LHSType), CastKind.CK_IntegralCast));
  }
  
  // If both types are identical, no conversion is needed.
  if ($eq_QualType$C(LHSType, RHSType)) {
    return LHSType;
  }
  
  // At this point, we have two different arithmetic types.
  
  // Diagnose attempts to convert between __float128 and long double where
  // such conversions currently can't be handled.
  if (unsupportedTypeConversion(/*Deref*/$this(), new QualType(LHSType), new QualType(RHSType))) {
    return new QualType();
  }
  
  // Handle complex types first (C99 6.3.1.8p1).
  if (LHSType.$arrow().isComplexType() || RHSType.$arrow().isComplexType()) {
    return handleComplexFloatConversion(/*Deref*/$this(), LHS, RHS, new QualType(LHSType), new QualType(RHSType), 
        IsCompAssign);
  }
  
  // Now handle "real" floating types (i.e. float, double, long double).
  if (LHSType.$arrow().isRealFloatingType() || RHSType.$arrow().isRealFloatingType()) {
    return handleFloatConversion(/*Deref*/$this(), LHS, RHS, new QualType(LHSType), new QualType(RHSType), 
        IsCompAssign);
  }
  
  // Handle GCC complex int extension.
  if (LHSType.$arrow().isComplexIntegerType() || RHSType.$arrow().isComplexIntegerType()) {
    return handleComplexIntConversion(/*Deref*/$this(), LHS, RHS, new QualType(LHSType), new QualType(RHSType), 
        IsCompAssign);
  }
  
  // Finally, we have two differing integer types.
  return SemaExprStatics./*<doIntegralCast, doIntegralCast>*/handleIntegerConversion(SemaExprStatics::doIntegralCast, SemaExprStatics::doIntegralCast, /*Deref*/$this(), LHS, RHS, new QualType(LHSType), new QualType(RHSType), IsCompAssign);
}


/// DiagnoseAssignmentResult - Emit a diagnostic, if required, for the
/// assignment conversion type specified by ConvTy.  This returns true if the
/// conversion was invalid or false if the conversion was accepted.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseAssignmentResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12391,
 FQN="clang::Sema::DiagnoseAssignmentResult", NM="_ZN5clang4Sema24DiagnoseAssignmentResultENS0_17AssignConvertTypeENS_14SourceLocationENS_8QualTypeES3_PNS_4ExprENS0_16AssignmentActionEPb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema24DiagnoseAssignmentResultENS0_17AssignConvertTypeENS_14SourceLocationENS_8QualTypeES3_PNS_4ExprENS0_16AssignmentActionEPb")
//</editor-fold>
public final boolean DiagnoseAssignmentResult(AssignConvertType ConvTy, 
                        SourceLocation Loc, 
                        QualType DstType, QualType SrcType, 
                        Expr /*P*/ SrcExpr, AssignmentAction Action) {
  return DiagnoseAssignmentResult(ConvTy, 
                        Loc, 
                        DstType, SrcType, 
                        SrcExpr, Action, 
                        (bool$ptr/*bool P*/ )null);
}
public final boolean DiagnoseAssignmentResult(AssignConvertType ConvTy, 
                        SourceLocation Loc, 
                        QualType DstType, QualType SrcType, 
                        Expr /*P*/ SrcExpr, AssignmentAction Action, 
                        bool$ptr/*bool P*/ Complained/*= null*/) {
  ConversionFixItGenerator ConvHints = null;
  PartialDiagnostic FDiag = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (Native.$bool(Complained)) {
      Complained.$set(false);
    }
    
    // Decode the result (notice that AST's are still created for extensions).
    boolean CheckInferredResultType = false;
    boolean isInvalid = false;
    /*uint*/int DiagKind = 0;
    FixItHint Hint/*J*/= new FixItHint();
    ConvHints/*J*/= new ConversionFixItGenerator();
    boolean MayHaveConvFixit = false;
    boolean MayHaveFunctionDiff = false;
    /*const*/ ObjCInterfaceDecl /*P*/ IFace = null;
    /*const*/ ObjCProtocolDecl /*P*/ PDecl = null;
    switch (ConvTy) {
     case Compatible:
      $this().DiagnoseAssignmentEnum(new QualType(DstType), new QualType(SrcType), SrcExpr);
      return false;
     case PointerToInt:
      DiagKind = diag.ext_typecheck_convert_pointer_int;
      ConvHints.tryToFixConversion(SrcExpr, new QualType(SrcType), new QualType(DstType), /*Deref*/$this());
      MayHaveConvFixit = true;
      break;
     case IntToPointer:
      DiagKind = diag.ext_typecheck_convert_int_pointer;
      ConvHints.tryToFixConversion(SrcExpr, new QualType(SrcType), new QualType(DstType), /*Deref*/$this());
      MayHaveConvFixit = true;
      break;
     case IncompatiblePointer:
      DiagKind
         = (Action == AssignmentAction.AA_Passing_CFAudited ? diag.err_arc_typecheck_convert_incompatible_pointer : diag.ext_typecheck_convert_incompatible_pointer);
      CheckInferredResultType = DstType.$arrow().isObjCObjectPointerType()
         && SrcType.$arrow().isObjCObjectPointerType();
      if (Hint.isNull() && !CheckInferredResultType) {
        ConvHints.tryToFixConversion(SrcExpr, new QualType(SrcType), new QualType(DstType), /*Deref*/$this());
      } else if (CheckInferredResultType) {
        SrcType.$assignMove(SrcType.getUnqualifiedType());
        DstType.$assignMove(DstType.getUnqualifiedType());
      }
      MayHaveConvFixit = true;
      break;
     case IncompatiblePointerSign:
      DiagKind = diag.ext_typecheck_convert_incompatible_pointer_sign;
      break;
     case FunctionVoidPointer:
      DiagKind = diag.ext_typecheck_convert_pointer_void_func;
      break;
     case IncompatiblePointerDiscardsQualifiers:
      {
        // Perform array-to-pointer decay if necessary.
        if (SrcType.$arrow().isArrayType()) {
          SrcType.$assignMove($this().Context.getArrayDecayedType(new QualType(SrcType)));
        }
        
        Qualifiers lhq = SrcType.$arrow().getPointeeType().getQualifiers();
        Qualifiers rhq = DstType.$arrow().getPointeeType().getQualifiers();
        if (lhq.getAddressSpace() != rhq.getAddressSpace()) {
          DiagKind = diag.err_typecheck_incompatible_address_space;
          break;
        } else if (lhq.getObjCLifetime() != rhq.getObjCLifetime()) {
          DiagKind = diag.err_typecheck_incompatible_ownership;
          break;
        }
        throw new llvm_unreachable("unknown error case for discarding qualifiers!");
        // fallthrough
      }
     case CompatiblePointerDiscardsQualifiers:
      // If the qualifiers lost were because we were applying the
      // (deprecated) C++ conversion from a string literal to a char*
      // (or wchar_t*), then there was no error (C++ 4.2p2).  FIXME:
      // Ideally, this check would be performed in
      // checkPointerTypesForAssignment. However, that would require a
      // bit of refactoring (so that the second argument is an
      // expression, rather than a type), which should be done as part
      // of a larger effort to fix checkPointerTypesForAssignment for
      // C++ semantics.
      if ($this().getLangOpts().CPlusPlus
         && $this().IsStringLiteralToNonConstPointerConversion(SrcExpr, new QualType(DstType))) {
        return false;
      }
      DiagKind = diag.ext_typecheck_convert_discards_qualifiers;
      break;
     case IncompatibleNestedPointerQualifiers:
      DiagKind = diag.ext_nested_pointer_qualifier_mismatch;
      break;
     case IntToBlockPointer:
      DiagKind = diag.err_int_to_block_pointer;
      break;
     case IncompatibleBlockPointer:
      DiagKind = diag.err_typecheck_convert_incompatible_block_pointer;
      break;
     case IncompatibleObjCQualifiedId:
      {
        if (SrcType.$arrow().isObjCQualifiedIdType()) {
          /*const*/ ObjCObjectPointerType /*P*/ srcOPT = SrcType.$arrow().getAs(ObjCObjectPointerType.class);
          for (ObjCProtocolDecl /*P*/ srcProto : srcOPT.quals()) {
            PDecl = srcProto;
            break;
          }
          {
            /*const*/ ObjCInterfaceType /*P*/ IFaceT = DstType.$arrow().getAs(ObjCObjectPointerType.class).getInterfaceType();
            if ((IFaceT != null)) {
              IFace = IFaceT.getDecl();
            }
          }
        } else if (DstType.$arrow().isObjCQualifiedIdType()) {
          /*const*/ ObjCObjectPointerType /*P*/ dstOPT = DstType.$arrow().getAs(ObjCObjectPointerType.class);
          for (ObjCProtocolDecl /*P*/ dstProto : dstOPT.quals()) {
            PDecl = dstProto;
            break;
          }
          {
            /*const*/ ObjCInterfaceType /*P*/ IFaceT = SrcType.$arrow().getAs(ObjCObjectPointerType.class).getInterfaceType();
            if ((IFaceT != null)) {
              IFace = IFaceT.getDecl();
            }
          }
        }
        DiagKind = diag.warn_incompatible_qualified_id;
        break;
      }
     case IncompatibleVectors:
      DiagKind = diag.warn_incompatible_vectors;
      break;
     case IncompatibleObjCWeakRef:
      DiagKind = diag.err_arc_weak_unavailable_assign;
      break;
     case Incompatible:
      if (maybeDiagnoseAssignmentToFunction(/*Deref*/$this(), new QualType(DstType), SrcExpr)) {
        if (Native.$bool(Complained)) {
          Complained.$set(true);
        }
        return true;
      }
      
      DiagKind = diag.err_typecheck_convert_incompatible;
      ConvHints.tryToFixConversion(SrcExpr, new QualType(SrcType), new QualType(DstType), /*Deref*/$this());
      MayHaveConvFixit = true;
      isInvalid = true;
      MayHaveFunctionDiff = true;
      break;
    }
    
    QualType FirstType/*J*/= new QualType();
    QualType SecondType/*J*/= new QualType();
    switch (Action) {
     case AA_Assigning:
     case AA_Initializing:
      // The destination type comes first.
      FirstType.$assign(DstType);
      SecondType.$assign(SrcType);
      break;
     case AA_Returning:
     case AA_Passing:
     case AA_Passing_CFAudited:
     case AA_Converting:
     case AA_Sending:
     case AA_Casting:
      // The source type comes first.
      FirstType.$assign(SrcType);
      SecondType.$assign(DstType);
      break;
    }
    
    FDiag = $this().PDiag(DiagKind);
    if (Action == AssignmentAction.AA_Passing_CFAudited) {
      $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_QualType(FDiag, /*NO_COPY*/FirstType), /*NO_COPY*/SecondType), AssignmentAction.AA_Passing.getValue()), SrcExpr.getSourceRange());
    } else {
      $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_QualType(FDiag, /*NO_COPY*/FirstType), /*NO_COPY*/SecondType), Action.getValue()), SrcExpr.getSourceRange());
    }
    
    // If we can fix the conversion, suggest the FixIts.
    assert (ConvHints.isNull() || Hint.isNull());
    if (!ConvHints.isNull()) {
      for (final FixItHint /*&*/ H : ConvHints.Hints)  {
        $out_PartialDiagnostic$C_FixItHint$C(FDiag, H);
      }
    } else {
      $out_PartialDiagnostic$C_FixItHint$C(FDiag, Hint);
    }
    if (MayHaveConvFixit) {
      $out_PartialDiagnostic$C_uint(FDiag, (/*uint*/int)(ConvHints.Kind).getValue());
    }
    if (MayHaveFunctionDiff) {
      $this().HandleFunctionTypeMismatch(FDiag, new QualType(SecondType), new QualType(FirstType));
    }
    
    $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), FDiag)));
    if (DiagKind == diag.warn_incompatible_qualified_id
       && (PDecl != null) && (IFace != null) && !IFace.hasDefinition()) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(IFace.getLocation(), diag.not_incomplete_class_and_qualified_id)), 
              IFace.getName()), PDecl.getName()));
    }
    if ($eq_QualType$C(SecondType, $this().Context.OverloadTy.$QualType())) {
      $this().NoteAllOverloadCandidates(OverloadExpr.find(SrcExpr).Expression, 
          new QualType(FirstType), /*TakingAddress=*/ true);
    }
    if (CheckInferredResultType) {
      $this().EmitRelatedResultTypeNote(SrcExpr);
    }
    if (Action == AssignmentAction.AA_Returning && ConvTy == AssignConvertType.IncompatiblePointer) {
      $this().EmitRelatedResultTypeNoteForReturn(new QualType(DstType));
    }
    if (Native.$bool(Complained)) {
      Complained.$set(true);
    }
    return isInvalid;
  } finally {
    if (FDiag != null) { FDiag.$destroy(); }
    if (ConvHints != null) { ConvHints.$destroy(); }
    $c$.$destroy();
  }
}


/// CheckAssignmentConstraints - Perform type checking for assignment,
/// argument passing, variable initialization, and function return values.
/// C99 6.5.16.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckAssignmentConstraints">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 7289,
 FQN="clang::Sema::CheckAssignmentConstraints", NM="_ZN5clang4Sema26CheckAssignmentConstraintsENS_14SourceLocationENS_8QualTypeES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema26CheckAssignmentConstraintsENS_14SourceLocationENS_8QualTypeES2_")
//</editor-fold>
public final Sema.AssignConvertType CheckAssignmentConstraints(SourceLocation Loc, 
                          QualType LHSType, QualType RHSType) {
  // Fake up an opaque expression.  We don't actually care about what
  // cast operations are required, so if CheckAssignmentConstraints
  // adds casts to this they'll be wasted, but fortunately that doesn't
  // usually happen on valid code.
  OpaqueValueExpr RHSExpr/*J*/= new OpaqueValueExpr(new SourceLocation(Loc), new QualType(RHSType), ExprValueKind.VK_RValue);
  ActionResultTTrue<Expr /*P*/ > RHSPtr = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, $AddrOf(RHSExpr));
  type$ref<CastKind> K = create_type$ref(CK_Invalid);
  
  return $this().CheckAssignmentConstraints(new QualType(LHSType), RHSPtr, K, /*ConvertRHS=*/ false);
}


/// Check assignment constraints and optionally prepare for a conversion of
/// the RHS to the LHS type. The conversion is prepared for if ConvertRHS
/// is true.

/// CheckAssignmentConstraints (C99 6.5.16) - This routine currently
/// has code to accommodate several GCC extensions when type checking
/// pointers. Here are some objectionable examples that GCC considers warnings:
///
///  int a, *pint;
///  short *pshort;
///  struct foo *pfoo;
///
///  pint = pshort; // warning: assignment from incompatible pointer type
///  a = pint; // warning: assignment makes integer from pointer without a cast
///  pint = a; // warning: assignment makes pointer from integer without a cast
///  pint = pfoo; // warning: assignment from incompatible pointer type
///
/// As a result, the code for dealing with pointers is more complex than the
/// C99 spec dictates.
///
/// Sets 'Kind' for any result kind except Incompatible.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckAssignmentConstraints">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 7320,
 FQN="clang::Sema::CheckAssignmentConstraints", NM="_ZN5clang4Sema26CheckAssignmentConstraintsENS_8QualTypeERNS_12ActionResultIPNS_4ExprELb1EEERNS_8CastKindEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema26CheckAssignmentConstraintsENS_8QualTypeERNS_12ActionResultIPNS_4ExprELb1EEERNS_8CastKindEb")
//</editor-fold>
public final Sema.AssignConvertType CheckAssignmentConstraints(QualType LHSType, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                          final type$ref<CastKind /*&*/> Kind) {
  return CheckAssignmentConstraints(LHSType, RHS, 
                          Kind, true);
}
public final Sema.AssignConvertType CheckAssignmentConstraints(QualType LHSType, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                          final type$ref<CastKind /*&*/> Kind, boolean ConvertRHS/*= true*/) {
  QualType RHSType = RHS.get().getType();
  QualType OrigLHSType = new QualType(LHSType);
  
  // Get canonical types.  We're not formatting these types, just comparing
  // them.
  LHSType.$assignMove($this().Context.getCanonicalType(new QualType(LHSType)).getUnqualifiedType().$QualType());
  RHSType.$assignMove($this().Context.getCanonicalType(new QualType(RHSType)).getUnqualifiedType().$QualType());
  
  // Common case: no conversion required.
  if ($eq_QualType$C(LHSType, RHSType)) {
    Kind.$set(CastKind.CK_NoOp);
    return AssignConvertType.Compatible;
  }
  {
    
    // If we have an atomic type, try a non-atomic assignment, then just add an
    // atomic qualification step.
    /*const*/ AtomicType /*P*/ AtomicTy = dyn_cast_AtomicType(LHSType);
    if ((AtomicTy != null)) {
      Sema.AssignConvertType result = $this().CheckAssignmentConstraints(AtomicTy.getValueType(), RHS, Kind);
      if (result != AssignConvertType.Compatible) {
        return result;
      }
      if (Kind.$deref() != CastKind.CK_NoOp && ConvertRHS) {
        RHS.$assignMove($this().ImpCastExprToType(RHS.get(), AtomicTy.getValueType(), Kind.$deref()));
      }
      Kind.$set(CastKind.CK_NonAtomicToAtomic);
      return AssignConvertType.Compatible;
    }
  }
  {
    
    // If the left-hand side is a reference type, then we are in a
    // (rare!) case where we've allowed the use of references in C,
    // e.g., as a parameter type in a built-in function. In this case,
    // just make sure that the type referenced is compatible with the
    // right-hand side type. The caller is responsible for adjusting
    // LHSType so that the resulting expression does not have reference
    // type.
    /*const*/ ReferenceType /*P*/ LHSTypeRef = LHSType.$arrow().getAs(ReferenceType.class);
    if ((LHSTypeRef != null)) {
      if ($this().Context.typesAreCompatible(LHSTypeRef.getPointeeType(), new QualType(RHSType))) {
        Kind.$set(CastKind.CK_LValueBitCast);
        return AssignConvertType.Compatible;
      }
      return AssignConvertType.Incompatible;
    }
  }
  
  // Allow scalar to ExtVector assignments, and assignments of an ExtVector type
  // to the same ExtVector type.
  if (LHSType.$arrow().isExtVectorType()) {
    if (RHSType.$arrow().isExtVectorType()) {
      return AssignConvertType.Incompatible;
    }
    if (RHSType.$arrow().isArithmeticType()) {
      // CK_VectorSplat does T -> vector T, so first cast to the element type.
      if (ConvertRHS) {
        RHS.$assignMove($this().prepareVectorSplat(new QualType(LHSType), RHS.get()));
      }
      Kind.$set(CastKind.CK_VectorSplat);
      return AssignConvertType.Compatible;
    }
  }
  
  // Conversions to or from vector type.
  if (LHSType.$arrow().isVectorType() || RHSType.$arrow().isVectorType()) {
    if (LHSType.$arrow().isVectorType() && RHSType.$arrow().isVectorType()) {
      // Allow assignments of an AltiVec vector type to an equivalent GCC
      // vector type and vice versa
      if ($this().Context.areCompatibleVectorTypes(new QualType(LHSType), new QualType(RHSType))) {
        Kind.$set(CastKind.CK_BitCast);
        return AssignConvertType.Compatible;
      }
      
      // If we are allowing lax vector conversions, and LHS and RHS are both
      // vectors, the total size only needs to be the same. This is a bitcast;
      // no bits are changed but the result type is different.
      if ($this().isLaxVectorConversion(new QualType(RHSType), new QualType(LHSType))) {
        Kind.$set(CastKind.CK_BitCast);
        return AssignConvertType.IncompatibleVectors;
      }
    }
    
    // When the RHS comes from another lax conversion (e.g. binops between
    // scalars and vectors) the result is canonicalized as a vector. When the
    // LHS is also a vector, the lax is allowed by the condition above. Handle
    // the case where LHS is a scalar.
    if (LHSType.$arrow().isScalarType()) {
      /*const*/ VectorType /*P*/ VecType = RHSType.$arrow().getAs(VectorType.class);
      if ((VecType != null) && VecType.getNumElements() == 1
         && $this().isLaxVectorConversion(new QualType(RHSType), new QualType(LHSType))) {
        ActionResultTTrue<Expr /*P*/ > /*P*/ VecExpr = $AddrOf(RHS);
        /*Deref*/VecExpr.$assignMove($this().ImpCastExprToType(VecExpr.get(), new QualType(LHSType), CastKind.CK_BitCast));
        Kind.$set(CastKind.CK_BitCast);
        return AssignConvertType.Compatible;
      }
    }
    
    return AssignConvertType.Incompatible;
  }
  
  // Diagnose attempts to convert between __float128 and long double where
  // such conversions currently can't be handled.
  if (unsupportedTypeConversion(/*Deref*/$this(), new QualType(LHSType), new QualType(RHSType))) {
    return AssignConvertType.Incompatible;
  }
  
  // Arithmetic conversions.
  if (LHSType.$arrow().isArithmeticType() && RHSType.$arrow().isArithmeticType()
     && !($this().getLangOpts().CPlusPlus && LHSType.$arrow().isEnumeralType())) {
    if (ConvertRHS) {
      Kind.$set($this().PrepareScalarCast(RHS, new QualType(LHSType)));
    }
    return AssignConvertType.Compatible;
  }
  {
    
    // Conversions to normal pointers.
    /*const*/ PointerType /*P*/ LHSPointer = dyn_cast_PointerType(LHSType);
    if ((LHSPointer != null)) {
      // U* -> T*
      if (isa_PointerType(RHSType)) {
        /*uint*/int AddrSpaceL = LHSPointer.getPointeeType().getAddressSpace();
        /*uint*/int AddrSpaceR = RHSType.$arrow().getPointeeType().getAddressSpace();
        Kind.$set(AddrSpaceL != AddrSpaceR ? CastKind.CK_AddressSpaceConversion : CastKind.CK_BitCast);
        return checkPointerTypesForAssignment(/*Deref*/$this(), new QualType(LHSType), new QualType(RHSType));
      }
      
      // int -> T*
      if (RHSType.$arrow().isIntegerType()) {
        Kind.$set(CastKind.CK_IntegralToPointer); // FIXME: null?
        return AssignConvertType.IntToPointer;
      }
      
      // C pointers are not compatible with ObjC object pointers,
      // with two exceptions:
      if (isa_ObjCObjectPointerType(RHSType)) {
        //  - conversions to void*
        if (LHSPointer.getPointeeType().$arrow().isVoidType()) {
          Kind.$set(CastKind.CK_BitCast);
          return AssignConvertType.Compatible;
        }
        
        //  - conversions from 'Class' to the redefinition type
        if (RHSType.$arrow().isObjCClassType()
           && $this().Context.hasSameType(new QualType(LHSType), 
            $this().Context.getObjCClassRedefinitionType())) {
          Kind.$set(CastKind.CK_BitCast);
          return AssignConvertType.Compatible;
        }
        
        Kind.$set(CastKind.CK_BitCast);
        return AssignConvertType.IncompatiblePointer;
      }
      
      // U^ -> void*
      if ((RHSType.$arrow().getAs(BlockPointerType.class) != null)) {
        if (LHSPointer.getPointeeType().$arrow().isVoidType()) {
          Kind.$set(CastKind.CK_BitCast);
          return AssignConvertType.Compatible;
        }
      }
      
      return AssignConvertType.Incompatible;
    }
  }
  
  // Conversions to block pointers.
  if (isa_BlockPointerType(LHSType)) {
    // U^ -> T^
    if (RHSType.$arrow().isBlockPointerType()) {
      Kind.$set(CastKind.CK_BitCast);
      return checkBlockPointerTypesForAssignment(/*Deref*/$this(), new QualType(LHSType), new QualType(RHSType));
    }
    
    // int or null -> T^
    if (RHSType.$arrow().isIntegerType()) {
      Kind.$set(CastKind.CK_IntegralToPointer); // FIXME: null
      return AssignConvertType.IntToBlockPointer;
    }
    
    // id -> T^
    if ($this().getLangOpts().ObjC1 && RHSType.$arrow().isObjCIdType()) {
      Kind.$set(CastKind.CK_AnyPointerToBlockPointerCast);
      return AssignConvertType.Compatible;
    }
    {
      
      // void* -> T^
      /*const*/ PointerType /*P*/ RHSPT = RHSType.$arrow().getAs(PointerType.class);
      if ((RHSPT != null)) {
        if (RHSPT.getPointeeType().$arrow().isVoidType()) {
          Kind.$set(CastKind.CK_AnyPointerToBlockPointerCast);
          return AssignConvertType.Compatible;
        }
      }
    }
    
    return AssignConvertType.Incompatible;
  }
  
  // Conversions to Objective-C pointers.
  if (isa_ObjCObjectPointerType(LHSType)) {
    // A* -> B*
    if (RHSType.$arrow().isObjCObjectPointerType()) {
      Kind.$set(CastKind.CK_BitCast);
      Sema.AssignConvertType result = checkObjCPointerTypesForAssignment(/*Deref*/$this(), new QualType(LHSType), new QualType(RHSType));
      if ($this().getLangOpts().ObjCAutoRefCount
         && result == AssignConvertType.Compatible
         && !$this().CheckObjCARCUnavailableWeakConversion(new QualType(OrigLHSType), new QualType(RHSType))) {
        result = AssignConvertType.IncompatibleObjCWeakRef;
      }
      return result;
    }
    
    // int or null -> A*
    if (RHSType.$arrow().isIntegerType()) {
      Kind.$set(CastKind.CK_IntegralToPointer); // FIXME: null
      return AssignConvertType.IntToPointer;
    }
    
    // In general, C pointers are not compatible with ObjC object pointers,
    // with two exceptions:
    if (isa_PointerType(RHSType)) {
      Kind.$set(CastKind.CK_CPointerToObjCPointerCast);
      
      //  - conversions from 'void*'
      if (RHSType.$arrow().isVoidPointerType()) {
        return AssignConvertType.Compatible;
      }
      
      //  - conversions to 'Class' from its redefinition type
      if (LHSType.$arrow().isObjCClassType()
         && $this().Context.hasSameType(new QualType(RHSType), 
          $this().Context.getObjCClassRedefinitionType())) {
        return AssignConvertType.Compatible;
      }
      
      return AssignConvertType.IncompatiblePointer;
    }
    
    // Only under strict condition T^ is compatible with an Objective-C pointer.
    if (RHSType.$arrow().isBlockPointerType()
       && LHSType.$arrow().isBlockCompatibleObjCPointerType($this().Context)) {
      if (ConvertRHS) {
        $this().maybeExtendBlockObject(RHS);
      }
      Kind.$set(CastKind.CK_BlockPointerToObjCPointerCast);
      return AssignConvertType.Compatible;
    }
    
    return AssignConvertType.Incompatible;
  }
  
  // Conversions from pointers that are not covered by the above.
  if (isa_PointerType(RHSType)) {
    // T* -> _Bool
    if ($eq_QualType$C(LHSType, $this().Context.BoolTy.$QualType())) {
      Kind.$set(CastKind.CK_PointerToBoolean);
      return AssignConvertType.Compatible;
    }
    
    // T* -> int
    if (LHSType.$arrow().isIntegerType()) {
      Kind.$set(CastKind.CK_PointerToIntegral);
      return AssignConvertType.PointerToInt;
    }
    
    return AssignConvertType.Incompatible;
  }
  
  // Conversions from Objective-C pointers that are not covered by the above.
  if (isa_ObjCObjectPointerType(RHSType)) {
    // T* -> _Bool
    if ($eq_QualType$C(LHSType, $this().Context.BoolTy.$QualType())) {
      Kind.$set(CastKind.CK_PointerToBoolean);
      return AssignConvertType.Compatible;
    }
    
    // T* -> int
    if (LHSType.$arrow().isIntegerType()) {
      Kind.$set(CastKind.CK_PointerToIntegral);
      return AssignConvertType.PointerToInt;
    }
    
    return AssignConvertType.Incompatible;
  }
  
  // struct A -> struct B
  if (isa_TagType(LHSType) && isa_TagType(RHSType)) {
    if ($this().Context.typesAreCompatible(new QualType(LHSType), new QualType(RHSType))) {
      Kind.$set(CastKind.CK_NoOp);
      return AssignConvertType.Compatible;
    }
  }
  
  return AssignConvertType.Incompatible;
}


// CheckSingleAssignmentConstraints - Currently used by
// CheckAssignmentOperands, and ActOnReturnStmt. Prior to type checking,
// this routine performs the default function/array converions, if ConvertRHS
// is true.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckSingleAssignmentConstraints">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 7676,
 FQN="clang::Sema::CheckSingleAssignmentConstraints", NM="_ZN5clang4Sema32CheckSingleAssignmentConstraintsENS_8QualTypeERNS_12ActionResultIPNS_4ExprELb1EEEbbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema32CheckSingleAssignmentConstraintsENS_8QualTypeERNS_12ActionResultIPNS_4ExprELb1EEEbbb")
//</editor-fold>
public final Sema.AssignConvertType CheckSingleAssignmentConstraints(QualType LHSType, final ActionResultTTrue<Expr /*P*/ > /*&*/ CallerRHS) {
  return CheckSingleAssignmentConstraints(LHSType, CallerRHS, 
                                true, 
                                false, 
                                true);
}
public final Sema.AssignConvertType CheckSingleAssignmentConstraints(QualType LHSType, final ActionResultTTrue<Expr /*P*/ > /*&*/ CallerRHS, 
                                boolean Diagnose/*= true*/) {
  return CheckSingleAssignmentConstraints(LHSType, CallerRHS, 
                                Diagnose, 
                                false, 
                                true);
}
public final Sema.AssignConvertType CheckSingleAssignmentConstraints(QualType LHSType, final ActionResultTTrue<Expr /*P*/ > /*&*/ CallerRHS, 
                                boolean Diagnose/*= true*/, 
                                boolean DiagnoseCFAudited/*= false*/) {
  return CheckSingleAssignmentConstraints(LHSType, CallerRHS, 
                                Diagnose, 
                                DiagnoseCFAudited, 
                                true);
}
public final Sema.AssignConvertType CheckSingleAssignmentConstraints(QualType LHSType, final ActionResultTTrue<Expr /*P*/ > /*&*/ CallerRHS, 
                                boolean Diagnose/*= true*/, 
                                boolean DiagnoseCFAudited/*= false*/, 
                                boolean ConvertRHS/*= true*/) {
  // If ConvertRHS is false, we want to leave the caller's RHS untouched. Sadly,
  // we can't avoid *all* modifications at the moment, so we need some somewhere
  // to put the updated value.
  ActionResultTTrue<Expr /*P*/ > LocalRHS = new ActionResultTTrue<Expr /*P*/ >(CallerRHS);
  final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS = ConvertRHS ? CallerRHS : LocalRHS;
  if ($this().getLangOpts().CPlusPlus) {
    if (!LHSType.$arrow().isRecordType() && !LHSType.$arrow().isAtomicType()) {
      // C++ 5.17p3: If the left operand is not of class type, the
      // expression is implicitly converted (C++ 4) to the
      // cv-unqualified type of the left operand.
      ActionResultTTrue<Expr /*P*/ > Res/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      if (Diagnose) {
        Res.$assignMove($this().PerformImplicitConversion(RHS.get(), LHSType.getUnqualifiedType(), 
                AssignmentAction.AA_Assigning));
      } else {
        ImplicitConversionSequence ICS = null;
        try {
          ICS = $this().TryImplicitConversion(RHS.get(), LHSType.getUnqualifiedType(), 
              /*SuppressUserConversions=*/ false, 
              /*AllowExplicit=*/ false, 
              /*InOverloadResolution=*/ false, 
              /*CStyle=*/ false, 
              /*AllowObjCWritebackConversion=*/ false);
          if (ICS.isFailure()) {
            return AssignConvertType.Incompatible;
          }
          Res.$assignMove($this().PerformImplicitConversion(RHS.get(), LHSType.getUnqualifiedType(), 
                  ICS, AssignmentAction.AA_Assigning));
        } finally {
          if (ICS != null) { ICS.$destroy(); }
        }
      }
      if (Res.isInvalid()) {
        return AssignConvertType.Incompatible;
      }
      Sema.AssignConvertType result = AssignConvertType.Compatible;
      if ($this().getLangOpts().ObjCAutoRefCount
         && !$this().CheckObjCARCUnavailableWeakConversion(new QualType(LHSType), 
          RHS.get().getType())) {
        result = AssignConvertType.IncompatibleObjCWeakRef;
      }
      RHS.$assign(Res);
      return result;
    }
    // FIXME: Currently, we fall through and treat C++ classes like C
    // structures.
    // FIXME: We also fall through for atomics; not sure what should
    // happen there, though.
  } else if ($eq_QualType$C(RHS.get().getType(), $this().Context.OverloadTy.$QualType())) {
    // As a set of extensions to C, we support overloading on functions. These
    // functions need to be resolved here.
    DeclAccessPair DAP/*J*/= new DeclAccessPair();
    {
      FunctionDecl /*P*/ FD = $this().ResolveAddressOfOverloadedFunction(RHS.get(), new QualType(LHSType), /*Complain=*/ false, DAP);
      if ((FD != null)) {
        RHS.$assign($this().FixOverloadedFunctionReference(RHS.get(), new DeclAccessPair(DAP), FD));
      } else {
        return AssignConvertType.Incompatible;
      }
    }
  }
  
  // C99 6.5.16.1p1: the left operand is a pointer and the right is
  // a null pointer constant.
  if ((LHSType.$arrow().isPointerType() || LHSType.$arrow().isObjCObjectPointerType()
     || LHSType.$arrow().isBlockPointerType())
     && (RHS.get().isNullPointerConstant($this().Context, 
      Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNull).getValue() != 0)) {
    if (Diagnose || ConvertRHS) {
      type$ref<CastKind> Kind = create_type$ref();
      SmallVector<CXXBaseSpecifier /*P*/> Path/*J*/= new SmallVector<CXXBaseSpecifier /*P*/>(4, null);
      $this().CheckPointerConversion(RHS.get(), new QualType(LHSType), Kind, Path, 
          /*IgnoreBaseAccess=*/ false, Diagnose);
      if (ConvertRHS) {
        RHS.$assignMove($this().ImpCastExprToType(RHS.get(), new QualType(LHSType), Kind.$deref(), ExprValueKind.VK_RValue, $AddrOf(Path)));
      }
    }
    return AssignConvertType.Compatible;
  }
  
  // This check seems unnatural, however it is necessary to ensure the proper
  // conversion of functions/arrays. If the conversion were done for all
  // DeclExpr's (created by ActOnIdExpression), it would mess up the unary
  // expressions that suppress this implicit conversion (&, sizeof).
  //
  // Suppress this for references: C++ 8.5.3p5.
  if (!LHSType.$arrow().isReferenceType()) {
    // FIXME: We potentially allocate here even if ConvertRHS is false.
    RHS.$assignMove($this().DefaultFunctionArrayLvalueConversion(RHS.get(), Diagnose));
    if (RHS.isInvalid()) {
      return AssignConvertType.Incompatible;
    }
  }
  
  Expr /*P*/ PRE = RHS.get().IgnoreParenCasts();
  if (Diagnose && isa_ObjCProtocolExpr(PRE)) {
    ObjCProtocolDecl /*P*/ PDecl = cast_ObjCProtocolExpr(PRE).getProtocol();
    if ((PDecl != null) && !PDecl.hasDefinition()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(PRE.getExprLoc(), diag.warn_atprotocol_protocol)), PDecl.getName()));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(PDecl.getLocation(), diag.note_entity_declared_at)), PDecl));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  type$ref<CastKind> Kind = create_type$ref(CK_Invalid);
  Sema.AssignConvertType result = $this().CheckAssignmentConstraints(new QualType(LHSType), RHS, Kind, ConvertRHS);
  
  // C99 6.5.16.1p2: The value of the right operand is converted to the
  // type of the assignment expression.
  // CheckAssignmentConstraints allows the left-hand side to be a reference,
  // so that we can use references in built-in functions even in C.
  // The getNonReferenceType() call makes sure that the resulting expression
  // does not have reference type.
  if (result != AssignConvertType.Incompatible && $noteq_QualType$C(RHS.get().getType(), LHSType)) {
    QualType Ty = LHSType.getNonLValueExprType($this().Context);
    type$ref<Expr /*P*/ > E = create_type$ref(RHS.get());
    
    // Check for various Objective-C errors. If we are not reporting
    // diagnostics and just checking for errors, e.g., during overload
    // resolution, return Incompatible to indicate the failure.
    if ($this().getLangOpts().ObjCAutoRefCount
       && $this().CheckObjCARCConversion(new SourceRange(), new QualType(Ty), E, CheckedConversionKind.CCK_ImplicitConversion, 
        Diagnose, DiagnoseCFAudited) != ARCConversionResult.ACR_okay) {
      if (!Diagnose) {
        return AssignConvertType.Incompatible;
      }
    }
    if ($this().getLangOpts().ObjC1
       && ($this().CheckObjCBridgeRelatedConversions(E.$deref().getLocStart(), new QualType(LHSType), 
        E.$deref().getType(), E, Diagnose)
       || $this().ConversionToObjCStringLiteralCheck(new QualType(LHSType), E, Diagnose))) {
      if (!Diagnose) {
        return AssignConvertType.Incompatible;
      }
      // Replace the expression with a corrected version and continue so we
      // can find further errors.
      RHS.$assign(E.$deref());
      return AssignConvertType.Compatible;
    }
    if (ConvertRHS) {
      RHS.$assignMove($this().ImpCastExprToType(E.$deref(), new QualType(Ty), Kind.$deref()));
    }
  }
  return result;
}


// \brief If the lhs type is a transparent union, check whether we
// can initialize the transparent union with the given expression.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckTransparentUnionArgumentConstraints">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 7624,
 FQN="clang::Sema::CheckTransparentUnionArgumentConstraints", NM="_ZN5clang4Sema40CheckTransparentUnionArgumentConstraintsENS_8QualTypeERNS_12ActionResultIPNS_4ExprELb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema40CheckTransparentUnionArgumentConstraintsENS_8QualTypeERNS_12ActionResultIPNS_4ExprELb1EEE")
//</editor-fold>
public final Sema.AssignConvertType CheckTransparentUnionArgumentConstraints(QualType ArgType, 
                                        final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS) {
  QualType RHSType = RHS.get().getType();
  
  // If the ArgType is a Union type, we want to handle a potential
  // transparent_union GCC extension.
  /*const*/ RecordType /*P*/ UT = ArgType.$arrow().getAsUnionType();
  if (!(UT != null) || !UT.getDecl().hasAttr(TransparentUnionAttr.class)) {
    return AssignConvertType.Incompatible;
  }
  
  // The field to initialize within the transparent union.
  RecordDecl /*P*/ UD = UT.getDecl();
  FieldDecl /*P*/ InitField = null;
  // It's compatible if the expression matches any of the fields.
  for (FieldDecl /*P*/ it : UD.fields()) {
    if (it.getType().$arrow().isPointerType()) {
      // If the transparent union contains a pointer type, we allow:
      // 1) void pointer
      // 2) null pointer constant
      if (RHSType.$arrow().isPointerType()) {
        if (RHSType.$arrow().castAs(PointerType.class).getPointeeType().$arrow().isVoidType()) {
          RHS.$assignMove($this().ImpCastExprToType(RHS.get(), it.getType(), CastKind.CK_BitCast));
          InitField = it;
          break;
        }
      }
      if ((RHS.get().isNullPointerConstant($this().Context, 
          Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNull).getValue() != 0)) {
        RHS.$assignMove($this().ImpCastExprToType(RHS.get(), it.getType(), 
                CastKind.CK_NullToPointer));
        InitField = it;
        break;
      }
    }
    
    type$ref<CastKind> Kind = create_type$ref(CK_Invalid);
    if ($this().CheckAssignmentConstraints(it.getType(), RHS, Kind)
       == AssignConvertType.Compatible) {
      RHS.$assignMove($this().ImpCastExprToType(RHS.get(), it.getType(), Kind.$deref()));
      InitField = it;
      break;
    }
  }
  if (!(InitField != null)) {
    return AssignConvertType.Incompatible;
  }
  
  ConstructTransparentUnion(/*Deref*/$this(), $this().Context, RHS, new QualType(ArgType), InitField);
  return AssignConvertType.Compatible;
}


/// the following "Check" methods will return a valid/converted QualType
/// or a null QualType (indicating an error diagnostic was issued).

/// type checking binary operators (subroutines of CreateBuiltinBinOp).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::InvalidOperands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 7815,
 FQN="clang::Sema::InvalidOperands", NM="_ZN5clang4Sema15InvalidOperandsENS_14SourceLocationERNS_12ActionResultIPNS_4ExprELb1EEES6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema15InvalidOperandsENS_14SourceLocationERNS_12ActionResultIPNS_4ExprELb1EEES6_")
//</editor-fold>
public final QualType InvalidOperands(SourceLocation Loc, final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, 
               final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_typecheck_invalid_operands)), 
                    LHS.get().getType()), RHS.get().getType()), 
            LHS.get().getSourceRange()), RHS.get().getSourceRange()));
    return new QualType();
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckMultiplyDivideOperands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8045,
 FQN="clang::Sema::CheckMultiplyDivideOperands", NM="_ZN5clang4Sema27CheckMultiplyDivideOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema27CheckMultiplyDivideOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationEbb")
//</editor-fold>
public final QualType CheckMultiplyDivideOperands(final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                           SourceLocation Loc, 
                           boolean IsCompAssign, boolean IsDiv) {
  checkArithmeticNull(/*Deref*/$this(), LHS, RHS, new SourceLocation(Loc), /*isCompare=*/ false);
  if (LHS.get().getType().$arrow().isVectorType()
     || RHS.get().getType().$arrow().isVectorType()) {
    return $this().CheckVectorOperands(LHS, RHS, new SourceLocation(Loc), IsCompAssign, 
        /*AllowBothBool*/ $this().getLangOpts().AltiVec, 
        /*AllowBoolConversions*/ false);
  }
  
  QualType compType = $this().UsualArithmeticConversions(LHS, RHS, IsCompAssign);
  if (LHS.isInvalid() || RHS.isInvalid()) {
    return new QualType();
  }
  if (compType.isNull() || !compType.$arrow().isArithmeticType()) {
    return $this().InvalidOperands(new SourceLocation(Loc), LHS, RHS);
  }
  if (IsDiv) {
    DiagnoseBadDivideOrRemainderValues(/*Deref*/$this(), LHS, RHS, new SourceLocation(Loc), IsDiv);
  }
  return compType;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckRemainderOperands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8068,
 FQN="clang::Sema::CheckRemainderOperands", NM="_ZN5clang4Sema22CheckRemainderOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema22CheckRemainderOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationEb")
//</editor-fold>
public final QualType CheckRemainderOperands(final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, SourceLocation Loc) {
  return CheckRemainderOperands(LHS, RHS, Loc, false);
}
public final QualType CheckRemainderOperands(final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, SourceLocation Loc, boolean IsCompAssign/*= false*/) {
  checkArithmeticNull(/*Deref*/$this(), LHS, RHS, new SourceLocation(Loc), /*isCompare=*/ false);
  if (LHS.get().getType().$arrow().isVectorType()
     || RHS.get().getType().$arrow().isVectorType()) {
    if (LHS.get().getType().$arrow().hasIntegerRepresentation()
       && RHS.get().getType().$arrow().hasIntegerRepresentation()) {
      return $this().CheckVectorOperands(LHS, RHS, new SourceLocation(Loc), IsCompAssign, 
          /*AllowBothBool*/ $this().getLangOpts().AltiVec, 
          /*AllowBoolConversions*/ false);
    }
    return $this().InvalidOperands(new SourceLocation(Loc), LHS, RHS);
  }
  
  QualType compType = $this().UsualArithmeticConversions(LHS, RHS, IsCompAssign);
  if (LHS.isInvalid() || RHS.isInvalid()) {
    return new QualType();
  }
  if (compType.isNull() || !compType.$arrow().isIntegerType()) {
    return $this().InvalidOperands(new SourceLocation(Loc), LHS, RHS);
  }
  DiagnoseBadDivideOrRemainderValues(/*Deref*/$this(), LHS, RHS, new SourceLocation(Loc), false/* IsDiv */);
  return compType;
}


// C99 6.5.6
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckAdditionOperands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8350,
 FQN="clang::Sema::CheckAdditionOperands", NM="_ZN5clang4Sema21CheckAdditionOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationENS_18BinaryOperatorKindEPNS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema21CheckAdditionOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationENS_18BinaryOperatorKindEPNS_8QualTypeE")
//</editor-fold>
public final QualType CheckAdditionOperands(final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                     SourceLocation Loc, BinaryOperatorKind Opc) {
  return CheckAdditionOperands(LHS, RHS, 
                     Loc, Opc, 
                     (type$ptr<QualType /*P*/> )null);
}
public final QualType CheckAdditionOperands(final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                     SourceLocation Loc, BinaryOperatorKind Opc, 
                     type$ptr<QualType /*P*/> CompLHSTy/*= null*/) {
  checkArithmeticNull(/*Deref*/$this(), LHS, RHS, new SourceLocation(Loc), /*isCompare=*/ false);
  if (LHS.get().getType().$arrow().isVectorType()
     || RHS.get().getType().$arrow().isVectorType()) {
    QualType compType = $this().CheckVectorOperands(LHS, RHS, new SourceLocation(Loc), Native.$bool(CompLHSTy), 
        /*AllowBothBool*/ $this().getLangOpts().AltiVec, 
        /*AllowBoolConversions*/ $this().getLangOpts().ZVector);
    if (Native.$bool(CompLHSTy)) {
      CompLHSTy.$star().$assign(compType);
    }
    return compType;
  }
  
  QualType compType = $this().UsualArithmeticConversions(LHS, RHS, Native.$bool(CompLHSTy));
  if (LHS.isInvalid() || RHS.isInvalid()) {
    return new QualType();
  }
  
  // Diagnose "string literal" '+' int and string '+' "char literal".
  if (Opc == BinaryOperatorKind.BO_Add) {
    diagnoseStringPlusInt(/*Deref*/$this(), new SourceLocation(Loc), LHS.get(), RHS.get());
    diagnoseStringPlusChar(/*Deref*/$this(), new SourceLocation(Loc), LHS.get(), RHS.get());
  }
  
  // handle the common case first (both operands are arithmetic).
  if (!compType.isNull() && compType.$arrow().isArithmeticType()) {
    if (Native.$bool(CompLHSTy)) {
      CompLHSTy.$star().$assign(compType);
    }
    return compType;
  }
  
  // Type-checking.  Ultimately the pointer's going to be in PExp;
  // note that we bias towards the LHS being the pointer.
  type$ref<Expr /*P*/ > PExp = create_type$ref(LHS.get());
  type$ref<Expr /*P*/ > IExp = create_type$ref(RHS.get());
  
  boolean isObjCPointer;
  if (PExp.$deref().getType().$arrow().isPointerType()) {
    isObjCPointer = false;
  } else if (PExp.$deref().getType().$arrow().isObjCObjectPointerType()) {
    isObjCPointer = true;
  } else {
    std.swap(PExp, IExp);
    if (PExp.$deref().getType().$arrow().isPointerType()) {
      isObjCPointer = false;
    } else if (PExp.$deref().getType().$arrow().isObjCObjectPointerType()) {
      isObjCPointer = true;
    } else {
      return $this().InvalidOperands(new SourceLocation(Loc), LHS, RHS);
    }
  }
  assert (PExp.$deref().getType().$arrow().isAnyPointerType());
  if (!IExp.$deref().getType().$arrow().isIntegerType()) {
    return $this().InvalidOperands(new SourceLocation(Loc), LHS, RHS);
  }
  if (!checkArithmeticOpPointerOperand(/*Deref*/$this(), new SourceLocation(Loc), PExp.$deref())) {
    return new QualType();
  }
  if (isObjCPointer && checkArithmeticOnObjCPointer(/*Deref*/$this(), new SourceLocation(Loc), PExp.$deref())) {
    return new QualType();
  }
  
  // Check array bounds for pointer arithemtic
  $this().CheckArrayAccess(PExp.$deref(), IExp.$deref());
  if (Native.$bool(CompLHSTy)) {
    QualType LHSTy = $this().Context.isPromotableBitField(LHS.get());
    if (LHSTy.isNull()) {
      LHSTy.$assignMove(LHS.get().getType());
      if (LHSTy.$arrow().isPromotableIntegerType()) {
        LHSTy.$assignMove($this().Context.getPromotedIntegerType(new QualType(LHSTy)));
      }
    }
    CompLHSTy.$star().$assign(LHSTy);
  }
  
  return PExp.$deref().getType();
}


// C99 6.5.6
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckSubtractionOperands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8428,
 FQN="clang::Sema::CheckSubtractionOperands", NM="_ZN5clang4Sema24CheckSubtractionOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationEPNS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema24CheckSubtractionOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationEPNS_8QualTypeE")
//</editor-fold>
public final QualType CheckSubtractionOperands(final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                        SourceLocation Loc) {
  return CheckSubtractionOperands(LHS, RHS, 
                        Loc, 
                        (type$ptr<QualType /*P*/> )null);
}
public final QualType CheckSubtractionOperands(final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                        SourceLocation Loc, 
                        type$ptr<QualType /*P*/> CompLHSTy/*= null*/) {
  checkArithmeticNull(/*Deref*/$this(), LHS, RHS, new SourceLocation(Loc), /*isCompare=*/ false);
  if (LHS.get().getType().$arrow().isVectorType()
     || RHS.get().getType().$arrow().isVectorType()) {
    QualType compType = $this().CheckVectorOperands(LHS, RHS, new SourceLocation(Loc), Native.$bool(CompLHSTy), 
        /*AllowBothBool*/ $this().getLangOpts().AltiVec, 
        /*AllowBoolConversions*/ $this().getLangOpts().ZVector);
    if (Native.$bool(CompLHSTy)) {
      CompLHSTy.$star().$assign(compType);
    }
    return compType;
  }
  
  QualType compType = $this().UsualArithmeticConversions(LHS, RHS, Native.$bool(CompLHSTy));
  if (LHS.isInvalid() || RHS.isInvalid()) {
    return new QualType();
  }
  
  // Enforce type constraints: C99 6.5.6p3.
  
  // Handle the common case first (both operands are arithmetic).
  if (!compType.isNull() && compType.$arrow().isArithmeticType()) {
    if (Native.$bool(CompLHSTy)) {
      CompLHSTy.$star().$assign(compType);
    }
    return compType;
  }
  
  // Either ptr - int   or   ptr - ptr.
  if (LHS.get().getType().$arrow().isAnyPointerType()) {
    QualType lpointee = LHS.get().getType().$arrow().getPointeeType();
    
    // Diagnose bad cases where we step over interface counts.
    if (LHS.get().getType().$arrow().isObjCObjectPointerType()
       && checkArithmeticOnObjCPointer(/*Deref*/$this(), new SourceLocation(Loc), LHS.get())) {
      return new QualType();
    }
    
    // The result type of a pointer-int computation is the pointer type.
    if (RHS.get().getType().$arrow().isIntegerType()) {
      if (!checkArithmeticOpPointerOperand(/*Deref*/$this(), new SourceLocation(Loc), LHS.get())) {
        return new QualType();
      }
      
      // Check array bounds for pointer arithemtic
      $this().CheckArrayAccess(LHS.get(), RHS.get(), /*ArraySubscriptExpr*/ (/*const*/ ArraySubscriptExpr /*P*/ )null, 
          /*AllowOnePastEnd*/ true, /*IndexNegated*/ true);
      if (Native.$bool(CompLHSTy)) {
        CompLHSTy.$star().$assignMove(LHS.get().getType());
      }
      return LHS.get().getType();
    }
    {
      
      // Handle pointer-pointer subtractions.
      /*const*/ PointerType /*P*/ RHSPTy = RHS.get().getType().$arrow().getAs(PointerType.class);
      if ((RHSPTy != null)) {
        QualType rpointee = RHSPTy.getPointeeType();
        if ($this().getLangOpts().CPlusPlus) {
          // Pointee types must be the same: C++ [expr.add]
          if (!$this().Context.hasSameUnqualifiedType(new QualType(lpointee), new QualType(rpointee))) {
            diagnosePointerIncompatibility(/*Deref*/$this(), new SourceLocation(Loc), LHS.get(), RHS.get());
          }
        } else {
          // Pointee types must be compatible C99 6.5.6p3
          if (!$this().Context.typesAreCompatible($this().Context.getCanonicalType(new QualType(lpointee)).getUnqualifiedType().$QualType(), 
              $this().Context.getCanonicalType(new QualType(rpointee)).getUnqualifiedType().$QualType())) {
            diagnosePointerIncompatibility(/*Deref*/$this(), new SourceLocation(Loc), LHS.get(), RHS.get());
            return new QualType();
          }
        }
        if (!checkArithmeticBinOpPointerOperands(/*Deref*/$this(), new SourceLocation(Loc), 
            LHS.get(), RHS.get())) {
          return new QualType();
        }
        
        // The pointee type may have zero size.  As an extension, a structure or
        // union may have zero size or an array may have zero length.  In this
        // case subtraction does not make sense.
        if (!rpointee.$arrow().isVoidType() && !rpointee.$arrow().isFunctionType()) {
          CharUnits ElementSize = $this().Context.getTypeSizeInChars(new QualType(rpointee));
          if (ElementSize.isZero()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_sub_ptr_zero_size_types)), 
                          rpointee.getUnqualifiedType()), 
                      LHS.get().getSourceRange()), RHS.get().getSourceRange()));
            } finally {
              $c$.$destroy();
            }
          }
        }
        if (Native.$bool(CompLHSTy)) {
          CompLHSTy.$star().$assignMove(LHS.get().getType());
        }
        return $this().Context.getPointerDiffType();
      }
    }
  }
  
  return $this().InvalidOperands(new SourceLocation(Loc), LHS, RHS);
}


// C99 6.5.7
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckShiftOperands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8670,
 FQN="clang::Sema::CheckShiftOperands", NM="_ZN5clang4Sema18CheckShiftOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationENS_18BinaryOperatorKindEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema18CheckShiftOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationENS_18BinaryOperatorKindEb")
//</editor-fold>
public final QualType CheckShiftOperands(final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                  SourceLocation Loc, BinaryOperatorKind Opc) {
  return CheckShiftOperands(LHS, RHS, 
                  Loc, Opc, 
                  false);
}
public final QualType CheckShiftOperands(final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                  SourceLocation Loc, BinaryOperatorKind Opc, 
                  boolean IsCompAssign/*= false*/) {
  checkArithmeticNull(/*Deref*/$this(), LHS, RHS, new SourceLocation(Loc), /*isCompare=*/ false);
  
  // Vector shifts promote their scalar inputs to vector type.
  if (LHS.get().getType().$arrow().isVectorType()
     || RHS.get().getType().$arrow().isVectorType()) {
    if ($this().LangOpts.OpenCL) {
      return checkOpenCLVectorShift(/*Deref*/$this(), LHS, RHS, new SourceLocation(Loc), IsCompAssign);
    }
    if ($this().LangOpts.ZVector) {
      {
        // The shift operators for the z vector extensions work basically
        // like OpenCL shifts, except that neither the LHS nor the RHS is
        // allowed to be a "vector bool".
        /*const*/ VectorType /*P*/ LHSVecType = LHS.get().getType().$arrow().getAs(VectorType.class);
        if ((LHSVecType != null)) {
          if (LHSVecType.getVectorKind() == VectorType.VectorKind.AltiVecBool) {
            return $this().InvalidOperands(new SourceLocation(Loc), LHS, RHS);
          }
        }
      }
      {
        /*const*/ VectorType /*P*/ RHSVecType = RHS.get().getType().$arrow().getAs(VectorType.class);
        if ((RHSVecType != null)) {
          if (RHSVecType.getVectorKind() == VectorType.VectorKind.AltiVecBool) {
            return $this().InvalidOperands(new SourceLocation(Loc), LHS, RHS);
          }
        }
      }
      return checkOpenCLVectorShift(/*Deref*/$this(), LHS, RHS, new SourceLocation(Loc), IsCompAssign);
    }
    return $this().CheckVectorOperands(LHS, RHS, new SourceLocation(Loc), IsCompAssign, 
        /*AllowBothBool*/ true, 
        /*AllowBoolConversions*/ false);
  }
  
  // Shifts don't perform usual arithmetic conversions, they just do integer
  // promotions on each operand. C99 6.5.7p3
  
  // For the LHS, do usual unary conversions, but then reset them away
  // if this is a compound assignment.
  ActionResultTTrue<Expr /*P*/ > OldLHS = new ActionResultTTrue<Expr /*P*/ >(LHS);
  LHS.$assignMove($this().UsualUnaryConversions(LHS.get()));
  if (LHS.isInvalid()) {
    return new QualType();
  }
  QualType LHSType = LHS.get().getType();
  if (IsCompAssign) {
    LHS.$assign(OldLHS);
  }
  
  // The RHS is simpler.
  RHS.$assignMove($this().UsualUnaryConversions(RHS.get()));
  if (RHS.isInvalid()) {
    return new QualType();
  }
  QualType RHSType = RHS.get().getType();
  
  // C99 6.5.7p2: Each of the operands shall have integer type.
  if (!LHSType.$arrow().hasIntegerRepresentation()
     || !RHSType.$arrow().hasIntegerRepresentation()) {
    return $this().InvalidOperands(new SourceLocation(Loc), LHS, RHS);
  }
  
  // C++0x: Don't allow scoped enums. FIXME: Use something better than
  // hasIntegerRepresentation() above instead of this.
  if (isScopedEnumerationType(new QualType(LHSType))
     || isScopedEnumerationType(new QualType(RHSType))) {
    return $this().InvalidOperands(new SourceLocation(Loc), LHS, RHS);
  }
  // Sanity-check shift operands
  DiagnoseBadShiftValues(/*Deref*/$this(), LHS, RHS, new SourceLocation(Loc), Opc, new QualType(LHSType));
  
  // "The type of the result is that of the promoted left operand."
  return LHSType;
}


// C99 6.5.8, C++ [expr.rel]
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckCompareOperands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 9044,
 FQN="clang::Sema::CheckCompareOperands", NM="_ZN5clang4Sema20CheckCompareOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationENS_18BinaryOperatorKindEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema20CheckCompareOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationENS_18BinaryOperatorKindEb")
//</editor-fold>
public final QualType CheckCompareOperands(final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                    SourceLocation Loc, BinaryOperatorKind Opc, 
                    boolean IsRelational) {
  checkArithmeticNull(/*Deref*/$this(), LHS, RHS, new SourceLocation(Loc), /*isCompare=*/ true);
  
  // Handle vector comparisons separately.
  if (LHS.get().getType().$arrow().isVectorType()
     || RHS.get().getType().$arrow().isVectorType()) {
    return $this().CheckVectorCompareOperands(LHS, RHS, new SourceLocation(Loc), IsRelational);
  }
  
  QualType LHSType = LHS.get().getType();
  QualType RHSType = RHS.get().getType();
  
  Expr /*P*/ LHSStripped = LHS.get().IgnoreParenImpCasts();
  Expr /*P*/ RHSStripped = RHS.get().IgnoreParenImpCasts();
  
  checkEnumComparison(/*Deref*/$this(), new SourceLocation(Loc), LHS.get(), RHS.get());
  diagnoseLogicalNotOnLHSofComparison(/*Deref*/$this(), LHS, RHS, new SourceLocation(Loc), Opc);
  if (!LHSType.$arrow().hasFloatingRepresentation()
     && !(LHSType.$arrow().isBlockPointerType() && IsRelational)
     && !LHS.get().getLocStart().isMacroID()
     && !RHS.get().getLocStart().isMacroID()
     && $this().ActiveTemplateInstantiations.empty()) {
    // For non-floating point types, check for self-comparisons of the form
    // x == x, x != x, x < x, etc.  These always evaluate to a constant, and
    // often indicate logic errors in the program.
    //
    // NOTE: Don't warn about comparison expressions resulting from macro
    // expansion. Also don't warn about comparisons which are only self
    // comparisons within a template specialization. The warnings should catch
    // obvious cases in the definition of the template anyways. The idea is to
    // warn when the typed comparison operator will always evaluate to the same
    // result.
    ValueDecl /*P*/ DL = getCompareDecl(LHSStripped);
    ValueDecl /*P*/ DR = getCompareDecl(RHSStripped);
    if ((DL != null) && (DR != null) && DL == DR && !IsWithinTemplateSpecialization(DL)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($this().DiagRuntimeBehavior(new SourceLocation(Loc), (/*const*/ Stmt /*P*/ )null, $out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_int($c$.track($this().PDiag(diag.warn_comparison_always)), 
                    0),  // self-
                ((Opc == BinaryOperatorKind.BO_EQ
                   || Opc == BinaryOperatorKind.BO_LE
                   || Opc == BinaryOperatorKind.BO_GE) ? 1 : 0))));
      } finally {
        $c$.$destroy();
      }
    } else if ((DL != null) && (DR != null) && LHSType.$arrow().isArrayType() && RHSType.$arrow().isArrayType()
       && !DL.getType().$arrow().isReferenceType()
       && !DR.getType().$arrow().isReferenceType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // what is it always going to eval to?
        /*char*/byte always_evals_to;
        switch (Opc) {
         case BO_EQ: // e.g. array1 == array2
          always_evals_to = 0; // false
          break;
         case BO_NE: // e.g. array1 != array2
          always_evals_to = 1; // true
          break;
         default:
          // best we can say is 'a constant'
          always_evals_to = 2; // e.g. array1 <= array2
          break;
        }
        $c$.clean($this().DiagRuntimeBehavior(new SourceLocation(Loc), (/*const*/ Stmt /*P*/ )null, $out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_int($c$.track($this().PDiag(diag.warn_comparison_always)), 
                    1),  // array
                always_evals_to)));
      } finally {
        $c$.$destroy();
      }
    }
    if (isa_CastExpr(LHSStripped)) {
      LHSStripped = LHSStripped.IgnoreParenCasts();
    }
    if (isa_CastExpr(RHSStripped)) {
      RHSStripped = RHSStripped.IgnoreParenCasts();
    }
    
    // Warn about comparisons against a string constant (unless the other
    // operand is null), the user probably wants strcmp.
    Expr /*P*/ literalString = null;
    Expr /*P*/ literalStringStripped = null;
    if ((isa_StringLiteral(LHSStripped) || isa_ObjCEncodeExpr(LHSStripped))
       && !(RHSStripped.isNullPointerConstant($this().Context, 
        Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNull).getValue() != 0)) {
      literalString = LHS.get();
      literalStringStripped = LHSStripped;
    } else if ((isa_StringLiteral(RHSStripped)
       || isa_ObjCEncodeExpr(RHSStripped))
       && !(LHSStripped.isNullPointerConstant($this().Context, 
        Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNull).getValue() != 0)) {
      literalString = RHS.get();
      literalStringStripped = RHSStripped;
    }
    if ((literalString != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($this().DiagRuntimeBehavior(new SourceLocation(Loc), (/*const*/ Stmt /*P*/ )null, 
            $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_int($c$.track($this().PDiag(diag.warn_stringcompare)), 
                    (isa_ObjCEncodeExpr(literalStringStripped) ? 1 : 0)), 
                literalString.getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // C99 6.5.8p3 / C99 6.5.9p4
  $this().UsualArithmeticConversions(LHS, RHS);
  if (LHS.isInvalid() || RHS.isInvalid()) {
    return new QualType();
  }
  
  LHSType.$assignMove(LHS.get().getType());
  RHSType.$assignMove(RHS.get().getType());
  
  // The result of comparisons is 'bool' in C++, 'int' in C.
  QualType ResultTy = $this().Context.getLogicalOperationType();
  if (IsRelational) {
    if (LHSType.$arrow().isRealType() && RHSType.$arrow().isRealType()) {
      return ResultTy;
    }
  } else {
    // Check for comparisons of floating point operands using != and ==.
    if (LHSType.$arrow().hasFloatingRepresentation()) {
      $this().CheckFloatComparison(new SourceLocation(Loc), LHS.get(), RHS.get());
    }
    if (LHSType.$arrow().isArithmeticType() && RHSType.$arrow().isArithmeticType()) {
      return ResultTy;
    }
  }
  
  /*const*/ Expr.NullPointerConstantKind LHSNullKind = LHS.get().isNullPointerConstant($this().Context, Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNull);
  /*const*/ Expr.NullPointerConstantKind RHSNullKind = RHS.get().isNullPointerConstant($this().Context, Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNull);
  boolean LHSIsNull = LHSNullKind != Expr.NullPointerConstantKind.NPCK_NotNull;
  boolean RHSIsNull = RHSNullKind != Expr.NullPointerConstantKind.NPCK_NotNull;
  if (!IsRelational && LHSIsNull != RHSIsNull) {
    boolean IsEquality = Opc == BinaryOperatorKind.BO_EQ;
    if (RHSIsNull) {
      $this().DiagnoseAlwaysNonNullPointer(LHS.get(), RHSNullKind, IsEquality, 
          RHS.get().getSourceRange());
    } else {
      $this().DiagnoseAlwaysNonNullPointer(RHS.get(), LHSNullKind, IsEquality, 
          LHS.get().getSourceRange());
    }
  }
  
  // All of the following pointer-related warnings are GCC extensions, except
  // when handling null pointer constants. 
  if (LHSType.$arrow().isPointerType() && RHSType.$arrow().isPointerType()) { // C99 6.5.8p2
    QualType LCanPointeeTy = LHSType.$arrow().castAs(PointerType.class).getPointeeType().getCanonicalType();
    QualType RCanPointeeTy = RHSType.$arrow().castAs(PointerType.class).getPointeeType().getCanonicalType();
    if ($this().getLangOpts().CPlusPlus) {
      if ($eq_QualType$C(LCanPointeeTy, RCanPointeeTy)) {
        return ResultTy;
      }
      if (!IsRelational
         && (LCanPointeeTy.$arrow().isVoidType() || RCanPointeeTy.$arrow().isVoidType())) {
        // Valid unless comparison between non-null pointer and function pointer
        // This is a gcc extension compatibility comparison.
        // In a SFINAE context, we treat this as a hard error to maintain
        // conformance with the C++ standard.
        if ((LCanPointeeTy.$arrow().isFunctionType() || RCanPointeeTy.$arrow().isFunctionType())
           && !LHSIsNull && !RHSIsNull) {
          diagnoseFunctionPointerToVoidComparison(/*Deref*/$this(), new SourceLocation(Loc), LHS, RHS, /*isError*/ (boolean)$this().isSFINAEContext().$bool());
          if ($this().isSFINAEContext().$bool()) {
            return new QualType();
          }
          
          RHS.$assignMove($this().ImpCastExprToType(RHS.get(), new QualType(LHSType), CastKind.CK_BitCast));
          return ResultTy;
        }
      }
      if (convertPointersToCompositeType(/*Deref*/$this(), new SourceLocation(Loc), LHS, RHS)) {
        return new QualType();
      } else {
        return ResultTy;
      }
    }
    // C99 6.5.9p2 and C99 6.5.8p2
    if ($this().Context.typesAreCompatible(LCanPointeeTy.getUnqualifiedType(), 
        RCanPointeeTy.getUnqualifiedType())) {
      // Valid unless a relational comparison of function pointers
      if (IsRelational && LCanPointeeTy.$arrow().isFunctionType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.ext_typecheck_ordered_comparison_of_function_pointers)), 
                          LHSType), RHSType), LHS.get().getSourceRange()), 
              RHS.get().getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (!IsRelational
       && (LCanPointeeTy.$arrow().isVoidType() || RCanPointeeTy.$arrow().isVoidType())) {
      // Valid unless comparison between non-null pointer and function pointer
      if ((LCanPointeeTy.$arrow().isFunctionType() || RCanPointeeTy.$arrow().isFunctionType())
         && !LHSIsNull && !RHSIsNull) {
        diagnoseFunctionPointerToVoidComparison(/*Deref*/$this(), new SourceLocation(Loc), LHS, RHS, 
            /*isError*/ false);
      }
    } else {
      // Invalid
      diagnoseDistinctPointerComparison(/*Deref*/$this(), new SourceLocation(Loc), LHS, RHS, /*isError*/ false);
    }
    if ($noteq_QualType$C(LCanPointeeTy, RCanPointeeTy)) {
      // Treat NULL constant as a special case in OpenCL.
      if ($this().getLangOpts().OpenCL && !LHSIsNull && !RHSIsNull) {
        /*const*/ PointerType /*P*/ LHSPtr = LHSType.$arrow().getAs(PointerType.class);
        if (!LHSPtr.isAddressSpaceOverlapping($Deref(RHSType.$arrow().getAs(PointerType.class)))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), 
                                    diag.err_typecheck_op_on_nonoverlapping_address_space_pointers)), 
                                LHSType), RHSType), 0/* comparison */), 
                    LHS.get().getSourceRange()), RHS.get().getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        }
      }
      /*uint*/int AddrSpaceL = LCanPointeeTy.getAddressSpace();
      /*uint*/int AddrSpaceR = RCanPointeeTy.getAddressSpace();
      CastKind Kind = AddrSpaceL != AddrSpaceR ? CastKind.CK_AddressSpaceConversion : CastKind.CK_BitCast;
      if (LHSIsNull && !RHSIsNull) {
        LHS.$assignMove($this().ImpCastExprToType(LHS.get(), new QualType(RHSType), Kind));
      } else {
        RHS.$assignMove($this().ImpCastExprToType(RHS.get(), new QualType(LHSType), Kind));
      }
    }
    return ResultTy;
  }
  if ($this().getLangOpts().CPlusPlus) {
    // Comparison of nullptr_t with itself.
    if (LHSType.$arrow().isNullPtrType() && RHSType.$arrow().isNullPtrType()) {
      return ResultTy;
    }
    
    // Comparison of pointers with null pointer constants and equality
    // comparisons of member pointers to null pointer constants.
    if (RHSIsNull
       && ((LHSType.$arrow().isAnyPointerType() || LHSType.$arrow().isNullPtrType())
       || (!IsRelational
       && (LHSType.$arrow().isMemberPointerType() || LHSType.$arrow().isBlockPointerType())))) {
      RHS.$assignMove($this().ImpCastExprToType(RHS.get(), new QualType(LHSType), 
              LHSType.$arrow().isMemberPointerType() ? CastKind.CK_NullToMemberPointer : CastKind.CK_NullToPointer));
      return ResultTy;
    }
    if (LHSIsNull
       && ((RHSType.$arrow().isAnyPointerType() || RHSType.$arrow().isNullPtrType())
       || (!IsRelational
       && (RHSType.$arrow().isMemberPointerType() || RHSType.$arrow().isBlockPointerType())))) {
      LHS.$assignMove($this().ImpCastExprToType(LHS.get(), new QualType(RHSType), 
              RHSType.$arrow().isMemberPointerType() ? CastKind.CK_NullToMemberPointer : CastKind.CK_NullToPointer));
      return ResultTy;
    }
    
    // Comparison of member pointers.
    if (!IsRelational
       && LHSType.$arrow().isMemberPointerType() && RHSType.$arrow().isMemberPointerType()) {
      if (convertPointersToCompositeType(/*Deref*/$this(), new SourceLocation(Loc), LHS, RHS)) {
        return new QualType();
      } else {
        return ResultTy;
      }
    }
    
    // Handle scoped enumeration types specifically, since they don't promote
    // to integers.
    if (LHS.get().getType().$arrow().isEnumeralType()
       && $this().Context.hasSameUnqualifiedType(LHS.get().getType(), 
        RHS.get().getType())) {
      return ResultTy;
    }
  }
  
  // Handle block pointer types.
  if (!IsRelational && LHSType.$arrow().isBlockPointerType()
     && RHSType.$arrow().isBlockPointerType()) {
    QualType lpointee = LHSType.$arrow().castAs(BlockPointerType.class).getPointeeType();
    QualType rpointee = RHSType.$arrow().castAs(BlockPointerType.class).getPointeeType();
    if (!LHSIsNull && !RHSIsNull
       && !$this().Context.typesAreCompatible(new QualType(lpointee), new QualType(rpointee))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_typecheck_comparison_of_distinct_blocks)), 
                        LHSType), RHSType), LHS.get().getSourceRange()), 
            RHS.get().getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
    RHS.$assignMove($this().ImpCastExprToType(RHS.get(), new QualType(LHSType), CastKind.CK_BitCast));
    return ResultTy;
  }
  
  // Allow block pointers to be compared with null pointer constants.
  if (!IsRelational
     && ((LHSType.$arrow().isBlockPointerType() && RHSType.$arrow().isPointerType())
     || (LHSType.$arrow().isPointerType() && RHSType.$arrow().isBlockPointerType()))) {
    if (!LHSIsNull && !RHSIsNull) {
      if (!((RHSType.$arrow().isPointerType() && RHSType.$arrow().castAs(PointerType.class).
          getPointeeType().$arrow().isVoidType())
         || (LHSType.$arrow().isPointerType() && LHSType.$arrow().castAs(PointerType.class).
          getPointeeType().$arrow().isVoidType()))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_typecheck_comparison_of_distinct_blocks)), 
                          LHSType), RHSType), LHS.get().getSourceRange()), 
              RHS.get().getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
    }
    if (LHSIsNull && !RHSIsNull) {
      LHS.$assignMove($this().ImpCastExprToType(LHS.get(), new QualType(RHSType), 
              RHSType.$arrow().isPointerType() ? CastKind.CK_BitCast : CastKind.CK_AnyPointerToBlockPointerCast));
    } else {
      RHS.$assignMove($this().ImpCastExprToType(RHS.get(), new QualType(LHSType), 
              LHSType.$arrow().isPointerType() ? CastKind.CK_BitCast : CastKind.CK_AnyPointerToBlockPointerCast));
    }
    return ResultTy;
  }
  if (LHSType.$arrow().isObjCObjectPointerType()
     || RHSType.$arrow().isObjCObjectPointerType()) {
    /*const*/ PointerType /*P*/ LPT = LHSType.$arrow().getAs(PointerType.class);
    /*const*/ PointerType /*P*/ RPT = RHSType.$arrow().getAs(PointerType.class);
    if ((LPT != null) || (RPT != null)) {
      boolean LPtrToVoid = (LPT != null) ? LPT.getPointeeType().$arrow().isVoidType() : false;
      boolean RPtrToVoid = (RPT != null) ? RPT.getPointeeType().$arrow().isVoidType() : false;
      if (!LPtrToVoid && !RPtrToVoid
         && !$this().Context.typesAreCompatible(new QualType(LHSType), new QualType(RHSType))) {
        diagnoseDistinctPointerComparison(/*Deref*/$this(), new SourceLocation(Loc), LHS, RHS, 
            /*isError*/ false);
      }
      if (LHSIsNull && !RHSIsNull) {
        type$ref<Expr /*P*/ > E = create_type$ref(LHS.get());
        if ($this().getLangOpts().ObjCAutoRefCount) {
          $this().CheckObjCARCConversion(new SourceRange(), new QualType(RHSType), E, CheckedConversionKind.CCK_ImplicitConversion);
        }
        LHS.$assignMove($this().ImpCastExprToType(E.$deref(), new QualType(RHSType), 
                (RPT != null) ? CastKind.CK_BitCast : CastKind.CK_CPointerToObjCPointerCast));
      } else {
        type$ref<Expr /*P*/ > E = create_type$ref(RHS.get());
        if ($this().getLangOpts().ObjCAutoRefCount) {
          $this().CheckObjCARCConversion(new SourceRange(), new QualType(LHSType), E, 
              CheckedConversionKind.CCK_ImplicitConversion, /*Diagnose=*/ true, 
              /*DiagnoseCFAudited=*/ false, Opc);
        }
        RHS.$assignMove($this().ImpCastExprToType(E.$deref(), new QualType(LHSType), 
                (LPT != null) ? CastKind.CK_BitCast : CastKind.CK_CPointerToObjCPointerCast));
      }
      return ResultTy;
    }
    if (LHSType.$arrow().isObjCObjectPointerType()
       && RHSType.$arrow().isObjCObjectPointerType()) {
      if (!$this().Context.areComparableObjCPointerTypes(new QualType(LHSType), new QualType(RHSType))) {
        diagnoseDistinctPointerComparison(/*Deref*/$this(), new SourceLocation(Loc), LHS, RHS, 
            /*isError*/ false);
      }
      if (isObjCObjectLiteral(LHS) || isObjCObjectLiteral(RHS)) {
        diagnoseObjCLiteralComparison(/*Deref*/$this(), new SourceLocation(Loc), LHS, RHS, Opc);
      }
      if (LHSIsNull && !RHSIsNull) {
        LHS.$assignMove($this().ImpCastExprToType(LHS.get(), new QualType(RHSType), CastKind.CK_BitCast));
      } else {
        RHS.$assignMove($this().ImpCastExprToType(RHS.get(), new QualType(LHSType), CastKind.CK_BitCast));
      }
      return ResultTy;
    }
  }
  if ((LHSType.$arrow().isAnyPointerType() && RHSType.$arrow().isIntegerType())
     || (LHSType.$arrow().isIntegerType() && RHSType.$arrow().isAnyPointerType())) {
    /*uint*/int DiagID = 0;
    boolean isError = false;
    if ($this().LangOpts.DebuggerSupport) {
      // Under a debugger, allow the comparison of pointers to integers,
      // since users tend to want to compare addresses.
    } else if ((LHSIsNull && LHSType.$arrow().isIntegerType())
       || (RHSIsNull && RHSType.$arrow().isIntegerType())) {
      if (IsRelational && !$this().getLangOpts().CPlusPlus) {
        DiagID = diag.ext_typecheck_ordered_comparison_of_pointer_and_zero;
      }
    } else if (IsRelational && !$this().getLangOpts().CPlusPlus) {
      DiagID = diag.ext_typecheck_ordered_comparison_of_pointer_integer;
    } else if ($this().getLangOpts().CPlusPlus) {
      DiagID = diag.err_typecheck_comparison_of_pointer_integer;
      isError = true;
    } else {
      DiagID = diag.ext_typecheck_comparison_of_pointer_integer;
    }
    if ((DiagID != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), DiagID)), 
                        LHSType), RHSType), LHS.get().getSourceRange()), 
            RHS.get().getSourceRange()));
        if (isError) {
          return new QualType();
        }
      } finally {
        $c$.$destroy();
      }
    }
    if (LHSType.$arrow().isIntegerType()) {
      LHS.$assignMove($this().ImpCastExprToType(LHS.get(), new QualType(RHSType), 
              LHSIsNull ? CastKind.CK_NullToPointer : CastKind.CK_IntegralToPointer));
    } else {
      RHS.$assignMove($this().ImpCastExprToType(RHS.get(), new QualType(LHSType), 
              RHSIsNull ? CastKind.CK_NullToPointer : CastKind.CK_IntegralToPointer));
    }
    return ResultTy;
  }
  
  // Handle block pointers.
  if (!IsRelational && RHSIsNull
     && LHSType.$arrow().isBlockPointerType() && RHSType.$arrow().isIntegerType()) {
    RHS.$assignMove($this().ImpCastExprToType(RHS.get(), new QualType(LHSType), CastKind.CK_NullToPointer));
    return ResultTy;
  }
  if (!IsRelational && LHSIsNull
     && LHSType.$arrow().isIntegerType() && RHSType.$arrow().isBlockPointerType()) {
    LHS.$assignMove($this().ImpCastExprToType(LHS.get(), new QualType(RHSType), CastKind.CK_NullToPointer));
    return ResultTy;
  }
  
  return $this().InvalidOperands(new SourceLocation(Loc), LHS, RHS);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckBitwiseOperands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 9524,
 FQN="clang::Sema::CheckBitwiseOperands", NM="_ZN5clang4Sema20CheckBitwiseOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema20CheckBitwiseOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationEb")
//</editor-fold>
public final /*inline*/ QualType CheckBitwiseOperands(final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, SourceLocation Loc) {
  return CheckBitwiseOperands(LHS, RHS, Loc, false);
}
public final /*inline*/ QualType CheckBitwiseOperands(final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, SourceLocation Loc, boolean IsCompAssign/*= false*/) {
  checkArithmeticNull(/*Deref*/$this(), LHS, RHS, new SourceLocation(Loc), /*isCompare=*/ false);
  if (LHS.get().getType().$arrow().isVectorType()
     || RHS.get().getType().$arrow().isVectorType()) {
    if (LHS.get().getType().$arrow().hasIntegerRepresentation()
       && RHS.get().getType().$arrow().hasIntegerRepresentation()) {
      return $this().CheckVectorOperands(LHS, RHS, new SourceLocation(Loc), IsCompAssign, 
          /*AllowBothBool*/ true, 
          /*AllowBoolConversions*/ $this().getLangOpts().ZVector);
    }
    return $this().InvalidOperands(new SourceLocation(Loc), LHS, RHS);
  }
  
  ActionResultTTrue<Expr /*P*/ > LHSResult = new ActionResultTTrue<Expr /*P*/ >(LHS);
  ActionResultTTrue<Expr /*P*/ > RHSResult = new ActionResultTTrue<Expr /*P*/ >(RHS);
  QualType compType = $this().UsualArithmeticConversions(LHSResult, RHSResult, 
      IsCompAssign);
  if (LHSResult.isInvalid() || RHSResult.isInvalid()) {
    return new QualType();
  }
  LHS.$assign(LHSResult.get());
  RHS.$assign(RHSResult.get());
  if (!compType.isNull() && compType.$arrow().isIntegralOrUnscopedEnumerationType()) {
    return compType;
  }
  return $this().InvalidOperands(new SourceLocation(Loc), LHS, RHS);
}


// C99 6.5.[13,14]
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckLogicalOperands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 9552,
 FQN="clang::Sema::CheckLogicalOperands", NM="_ZN5clang4Sema20CheckLogicalOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationENS_18BinaryOperatorKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema20CheckLogicalOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationENS_18BinaryOperatorKindE")
//</editor-fold>
public final /*inline*/ QualType CheckLogicalOperands(final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                    SourceLocation Loc, 
                    BinaryOperatorKind Opc) {
  // Check vector operands differently.
  if (LHS.get().getType().$arrow().isVectorType() || RHS.get().getType().$arrow().isVectorType()) {
    return $this().CheckVectorLogicalOperands(LHS, RHS, new SourceLocation(Loc));
  }
  
  // Diagnose cases where the user write a logical and/or but probably meant a
  // bitwise one.  We do this when the LHS is a non-bool integer and the RHS
  // is a constant.
  if (LHS.get().getType().$arrow().isIntegerType()
     && !LHS.get().getType().$arrow().isBooleanType()
     && RHS.get().getType().$arrow().isIntegerType() && !RHS.get().isValueDependent()
    // Don't warn in macros or template instantiations.
     && !Loc.isMacroID() && $this().ActiveTemplateInstantiations.empty()) {
    // If the RHS can be constant folded, and if it constant folds to something
    // that isn't 0 or 1 (which indicate a potential logical operation that
    // happened to fold to true/false) then warn.
    // Parens on the RHS are ignored.
    APSInt Result/*J*/= new APSInt();
    if (RHS.get().EvaluateAsInt(Result, $this().Context)) {
      if (($this().getLangOpts().Bool && !RHS.get().getType().$arrow().isBooleanType()
         && !RHS.get().getExprLoc().isMacroID())
         || (Result.$noteq(0) && Result.$noteq(1))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_logical_instead_of_bitwise)), 
                  RHS.get().getSourceRange()), 
              (Opc == BinaryOperatorKind.BO_LAnd ? $AMP_AMP : $PIPE_PIPE)));
          // Suggest replacing the logical operator with the bitwise version
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.note_logical_instead_of_bitwise_change_operator)), 
                  (Opc == BinaryOperatorKind.BO_LAnd ? $AMP : $PIPE)), 
              FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/Loc, $this().getLocForEndOfToken(new SourceLocation(Loc))), 
                  new StringRef(Opc == BinaryOperatorKind.BO_LAnd ? $AMP : $PIPE))));
          if (Opc == BinaryOperatorKind.BO_LAnd) {
            // Suggest replacing "Foo() && kNonZero" with "Foo()"
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.note_logical_instead_of_bitwise_remove_constant)), 
                FixItHint.CreateRemoval(new SourceRange($this().getLocForEndOfToken(LHS.get().getLocEnd()), 
                        RHS.get().getLocEnd()))));
          }
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  if (!$this().Context.getLangOpts().CPlusPlus) {
    // OpenCL v1.1 s6.3.g: The logical operators and (&&), or (||) do
    // not operate on the built-in scalar and vector float types.
    if ($this().Context.getLangOpts().OpenCL
       && $less_uint($this().Context.getLangOpts().OpenCLVersion, 120)) {
      if (LHS.get().getType().$arrow().isFloatingType()
         || RHS.get().getType().$arrow().isFloatingType()) {
        return $this().InvalidOperands(new SourceLocation(Loc), LHS, RHS);
      }
    }
    
    LHS.$assignMove($this().UsualUnaryConversions(LHS.get()));
    if (LHS.isInvalid()) {
      return new QualType();
    }
    
    RHS.$assignMove($this().UsualUnaryConversions(RHS.get()));
    if (RHS.isInvalid()) {
      return new QualType();
    }
    if (!LHS.get().getType().$arrow().isScalarType()
       || !RHS.get().getType().$arrow().isScalarType()) {
      return $this().InvalidOperands(new SourceLocation(Loc), LHS, RHS);
    }
    
    return $this().Context.IntTy.$QualType();
  }
  
  // The following is safe because we only use this method for
  // non-overloadable operands.
  
  // C++ [expr.log.and]p1
  // C++ [expr.log.or]p1
  // The operands are both contextually converted to type bool.
  ActionResultTTrue<Expr /*P*/ > LHSRes = $this().PerformContextuallyConvertToBool(LHS.get());
  if (LHSRes.isInvalid()) {
    return $this().InvalidOperands(new SourceLocation(Loc), LHS, RHS);
  }
  LHS.$assign(LHSRes);
  
  ActionResultTTrue<Expr /*P*/ > RHSRes = $this().PerformContextuallyConvertToBool(RHS.get());
  if (RHSRes.isInvalid()) {
    return $this().InvalidOperands(new SourceLocation(Loc), LHS, RHS);
  }
  RHS.$assign(RHSRes);
  
  // C++ [expr.log.and]p2
  // C++ [expr.log.or]p2
  // The result is a bool.
  return $this().Context.BoolTy.$QualType();
}

// CheckAssignmentOperands is used for both simple and compound assignment.
// For simple assignment, pass both expressions and a null converted type.
// For compound assignment, pass both expressions and the converted type.

// C99 6.5.16.1
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckAssignmentOperands">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 9968,
 FQN="clang::Sema::CheckAssignmentOperands", NM="_ZN5clang4Sema23CheckAssignmentOperandsEPNS_4ExprERNS_12ActionResultIS2_Lb1EEENS_14SourceLocationENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema23CheckAssignmentOperandsEPNS_4ExprERNS_12ActionResultIS2_Lb1EEENS_14SourceLocationENS_8QualTypeE")
//</editor-fold>
public final QualType CheckAssignmentOperands(Expr /*P*/ LHSExpr, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                       SourceLocation Loc, 
                       QualType CompoundType) {
  assert (!LHSExpr.hasPlaceholderType(BuiltinType.Kind.PseudoObject));
  
  // Verify that LHS is a modifiable lvalue, and emit error if not.
  if (CheckForModifiableLvalue(LHSExpr, new SourceLocation(Loc), /*Deref*/$this())) {
    return new QualType();
  }
  
  QualType LHSType = LHSExpr.getType();
  QualType RHSType = CompoundType.isNull() ? RHS.get().getType() : new QualType(CompoundType);
  AssignConvertType ConvTy;
  if (CompoundType.isNull()) {
    Expr /*P*/ RHSCheck = RHS.get();
    
    CheckIdentityFieldAssignment(LHSExpr, RHSCheck, new SourceLocation(Loc), /*Deref*/$this());
    
    QualType LHSTy/*J*/= new QualType(LHSType);
    ConvTy = $this().CheckSingleAssignmentConstraints(new QualType(LHSTy), RHS);
    if (RHS.isInvalid()) {
      return new QualType();
    }
    // Special case of NSObject attributes on c-style pointer types.
    if (ConvTy == AssignConvertType.IncompatiblePointer
       && (($this().Context.isObjCNSObjectType(new QualType(LHSType))
       && RHSType.$arrow().isObjCObjectPointerType())
       || ($this().Context.isObjCNSObjectType(new QualType(RHSType))
       && LHSType.$arrow().isObjCObjectPointerType()))) {
      ConvTy = AssignConvertType.Compatible;
    }
    if (ConvTy == AssignConvertType.Compatible
       && LHSType.$arrow().isObjCObjectType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_object_assignment)), 
            LHSType));
      } finally {
        $c$.$destroy();
      }
    }
    {
      
      // If the RHS is a unary plus or minus, check to see if they = and + are
      // right next to each other.  If so, the user may have typo'd "x =+ 4"
      // instead of "x += 4".
      ImplicitCastExpr /*P*/ ICE = dyn_cast_ImplicitCastExpr(RHSCheck);
      if ((ICE != null)) {
        RHSCheck = ICE.getSubExpr();
      }
    }
    {
      UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(RHSCheck);
      if ((UO != null)) {
        if ((UO.getOpcode() == UnaryOperatorKind.UO_Plus
           || UO.getOpcode() == UnaryOperatorKind.UO_Minus)
           && Loc.isFileID() && UO.getOperatorLoc().isFileID()
          // Only if the two operators are exactly adjacent.
           && $eq_SourceLocation$C(Loc.getLocWithOffset(1), UO.getOperatorLoc())
          // And there is a space or other character before the subexpr of the
          // unary +/-.  We don't want to warn on "x=-1".
           && $noteq_SourceLocation$C(Loc.getLocWithOffset(2), UO.getSubExpr().getLocStart())
           && UO.getSubExpr().getLocStart().isFileID()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_not_compound_assign)), 
                    (UO.getOpcode() == UnaryOperatorKind.UO_Plus ? $PLUS : $MINUS)), 
                new SourceRange(UO.getOperatorLoc(), UO.getOperatorLoc())));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    if (ConvTy == AssignConvertType.Compatible) {
      if (LHSType.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Strong) {
        // Warn about retain cycles where a block captures the LHS, but
        // not if the LHS is a simple variable into which the block is
        // being stored...unless that variable can be captured by reference!
        /*const*/ Expr /*P*/ InnerLHS = LHSExpr.IgnoreParenCasts();
        /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(InnerLHS);
        if (!(DRE != null) || DRE.getDecl$Const().hasAttr(BlocksAttr.class)) {
          $this().checkRetainCycles(LHSExpr, RHS.get());
        }
        
        // It is safe to assign a weak reference into a strong variable.
        // Although this code can still have problems:
        //   id x = self.weakProp;
        //   id y = self.weakProp;
        // we do not warn to warn spuriously when 'x' and 'y' are on separate
        // paths through the function. This should be revisited if
        // -Wrepeated-use-of-weak is made flow-sensitive.
        if (!$this().Diags.isIgnored(diag.warn_arc_repeated_use_of_weak, 
            RHS.get().getLocStart())) {
          $this().getCurFunction().markSafeWeakUse(RHS.get());
        }
      } else if ($this().getLangOpts().ObjCAutoRefCount) {
        $this().checkUnsafeExprAssigns(new SourceLocation(Loc), LHSExpr, RHS.get());
      }
    }
  } else {
    // Compound assignment "x += y"
    ConvTy = $this().CheckAssignmentConstraints(new SourceLocation(Loc), new QualType(LHSType), new QualType(RHSType));
  }
  if ($this().DiagnoseAssignmentResult(ConvTy, new SourceLocation(Loc), new QualType(LHSType), new QualType(RHSType), 
      RHS.get(), AssignmentAction.AA_Assigning)) {
    return new QualType();
  }
  
  SemaExprStatics.CheckForNullPointerDereference(/*Deref*/$this(), LHSExpr);
  
  // C99 6.5.16p3: The type of an assignment expression is the type of the
  // left operand unless the left operand has qualified type, in which case
  // it is the unqualified version of the type of the left operand.
  // C99 6.5.16.1p2: In simple assignment, the value of the right operand
  // is converted to the type of the assignment expression (above).
  // C++ 5.17p1: the type of the assignment expression is that of its left
  // operand.
  return ($this().getLangOpts().CPlusPlus ? new QualType(LHSType) : LHSType.getUnqualifiedType());
}


/// Note that LHS is not null here, even if this is the gnu "x ?: y" extension.
/// In that case, LHS = cond.
/// C99 6.5.15
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckConditionalOperands">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6612,
 FQN="clang::Sema::CheckConditionalOperands", NM="_ZN5clang4Sema24CheckConditionalOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_S5_RNS_13ExprValueKindERNS_14ExprObjectKindENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema24CheckConditionalOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_S5_RNS_13ExprValueKindERNS_14ExprObjectKindENS_14SourceLocationE")
//</editor-fold>
public final QualType CheckConditionalOperands(final ActionResultTTrue<Expr /*P*/ > /*&*/ Cond, final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, 
                        final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, final type$ref<ExprValueKind /*&*/> VK, 
                        final type$ref<ExprObjectKind /*&*/> OK, 
                        SourceLocation QuestionLoc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    
    ActionResultTTrue<Expr /*P*/ > LHSResult = $this().CheckPlaceholderExpr(LHS.get());
    if (!LHSResult.isUsable()) {
      return new QualType();
    }
    LHS.$assign(LHSResult);
    
    ActionResultTTrue<Expr /*P*/ > RHSResult = $this().CheckPlaceholderExpr(RHS.get());
    if (!RHSResult.isUsable()) {
      return new QualType();
    }
    RHS.$assign(RHSResult);
    
    // C++ is sufficiently different to merit its own checker.
    if ($this().getLangOpts().CPlusPlus) {
      return $this().CXXCheckConditionalOperands(Cond, LHS, RHS, VK, OK, new SourceLocation(QuestionLoc));
    }
    
    VK.$set(ExprValueKind.VK_RValue);
    OK.$set(ExprObjectKind.OK_Ordinary);
    
    // The OpenCL operator with a vector condition is sufficiently
    // different to merit its own checker.
    if ($this().getLangOpts().OpenCL && Cond.get().getType().$arrow().isVectorType()) {
      return OpenCLCheckVectorConditional(/*Deref*/$this(), Cond, LHS, RHS, new SourceLocation(QuestionLoc));
    }
    
    // First, check the condition.
    Cond.$assignMove($this().UsualUnaryConversions(Cond.get()));
    if (Cond.isInvalid()) {
      return new QualType();
    }
    if (checkCondition(/*Deref*/$this(), Cond.get(), new SourceLocation(QuestionLoc))) {
      return new QualType();
    }
    
    // Now check the two expressions.
    if (LHS.get().getType().$arrow().isVectorType()
       || RHS.get().getType().$arrow().isVectorType()) {
      return $this().CheckVectorOperands(LHS, RHS, new SourceLocation(QuestionLoc), /*isCompAssign*/ false, 
          /*AllowBothBool*/ true, 
          /*AllowBoolConversions*/ false);
    }
    
    QualType ResTy = $this().UsualArithmeticConversions(LHS, RHS);
    if (LHS.isInvalid() || RHS.isInvalid()) {
      return new QualType();
    }
    
    QualType LHSTy = LHS.get().getType();
    QualType RHSTy = RHS.get().getType();
    
    // Diagnose attempts to convert between __float128 and long double where
    // such conversions currently can't be handled.
    if (unsupportedTypeConversion(/*Deref*/$this(), new QualType(LHSTy), new QualType(RHSTy))) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(QuestionLoc), 
                          diag.err_typecheck_cond_incompatible_operands)), LHSTy), RHSTy), 
              LHS.get().getSourceRange()), RHS.get().getSourceRange()));
      return new QualType();
    }
    
    // OpenCL v2.0 s6.12.5 - Blocks cannot be used as expressions of the ternary
    // selection operator (?:).
    if ($this().getLangOpts().OpenCL
       && ((checkBlockType(/*Deref*/$this(), LHS.get()) | checkBlockType(/*Deref*/$this(), RHS.get())))) {
      return new QualType();
    }
    
    // If both operands have arithmetic type, do the usual arithmetic conversions
    // to find a common type: C99 6.5.15p3,5.
    if (LHSTy.$arrow().isArithmeticType() && RHSTy.$arrow().isArithmeticType()) {
      LHS.$assignMove($this().ImpCastExprToType(LHS.get(), new QualType(ResTy), $this().PrepareScalarCast(LHS, new QualType(ResTy))));
      RHS.$assignMove($this().ImpCastExprToType(RHS.get(), new QualType(ResTy), $this().PrepareScalarCast(RHS, new QualType(ResTy))));
      
      return ResTy;
    }
    {
      
      // If both operands are the same structure or union type, the result is that
      // type.
      /*const*/ RecordType /*P*/ LHSRT = LHSTy.$arrow().getAs$RecordType();
      if ((LHSRT != null)) { // C99 6.5.15p3
        {
          /*const*/ RecordType /*P*/ RHSRT = RHSTy.$arrow().getAs$RecordType();
          if ((RHSRT != null)) {
            if (LHSRT.getDecl() == RHSRT.getDecl()) {
              // "If both the operands have structure or union type, the result has
              // that type."  This implies that CV qualifiers are dropped.
              return LHSTy.getUnqualifiedType();
            }
          }
        }
        // FIXME: Type of conditional expression must be complete in C mode.
      }
    }
    
    // C99 6.5.15p5: "If both operands have void type, the result has void type."
    // The following || allows only one side to be void (a GCC-ism).
    if (LHSTy.$arrow().isVoidType() || RHSTy.$arrow().isVoidType()) {
      return checkConditionalVoidType(/*Deref*/$this(), LHS, RHS);
    }
    
    // C99 6.5.15p6 - "if one operand is a null pointer constant, the result has
    // the type of the other operand."
    if (!checkConditionalNullPointer(/*Deref*/$this(), RHS, new QualType(LHSTy))) {
      return LHSTy;
    }
    if (!checkConditionalNullPointer(/*Deref*/$this(), LHS, new QualType(RHSTy))) {
      return RHSTy;
    }
    
    // All objective-c pointer type analysis is done here.
    QualType compositeType = $this().FindCompositeObjCPointerType(LHS, RHS, 
        new SourceLocation(QuestionLoc));
    if (LHS.isInvalid() || RHS.isInvalid()) {
      return new QualType();
    }
    if (!compositeType.isNull()) {
      return compositeType;
    }
    
    // Handle block pointer types.
    if (LHSTy.$arrow().isBlockPointerType() || RHSTy.$arrow().isBlockPointerType()) {
      return checkConditionalBlockPointerCompatibility(/*Deref*/$this(), LHS, RHS, 
          new SourceLocation(QuestionLoc));
    }
    
    // Check constraints for C object pointers types (C99 6.5.15p3,6).
    if (LHSTy.$arrow().isPointerType() && RHSTy.$arrow().isPointerType()) {
      return checkConditionalObjectPointersCompatibility(/*Deref*/$this(), LHS, RHS, 
          new SourceLocation(QuestionLoc));
    }
    
    // GCC compatibility: soften pointer/integer mismatch.  Note that
    // null pointers have been filtered out by this point.
    if (checkPointerIntegerMismatch(/*Deref*/$this(), LHS, RHS.get(), new SourceLocation(QuestionLoc), 
        /*isIntFirstExpr=*/ true)) {
      return RHSTy;
    }
    if (checkPointerIntegerMismatch(/*Deref*/$this(), RHS, LHS.get(), new SourceLocation(QuestionLoc), 
        /*isIntFirstExpr=*/ false)) {
      return LHSTy;
    }
    
    // Emit a better diagnostic if one of the expressions is a null pointer
    // constant and the other is not a pointer type. In this case, the user most
    // likely forgot to take the address of the other expression.
    if ($this().DiagnoseConditionalForNull(LHS.get(), RHS.get(), new SourceLocation(QuestionLoc))) {
      return new QualType();
    }
    
    // Otherwise, the operands are not compatible.
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(QuestionLoc), diag.err_typecheck_cond_incompatible_operands)), 
                    LHSTy), RHSTy), LHS.get().getSourceRange()), 
        RHS.get().getSourceRange()));
    return new QualType();
  } finally {
    $c$.$destroy();
  }
}


/// FindCompositeObjCPointerType - Helper method to find composite type of
/// two objective-c pointer types of the two input expressions.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FindCompositeObjCPointerType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6748,
 FQN="clang::Sema::FindCompositeObjCPointerType", NM="_ZN5clang4Sema28FindCompositeObjCPointerTypeERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema28FindCompositeObjCPointerTypeERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationE")
//</editor-fold>
public final QualType FindCompositeObjCPointerType(final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                            SourceLocation QuestionLoc) {
  QualType LHSTy = LHS.get().getType();
  QualType RHSTy = RHS.get().getType();
  
  // Handle things like Class and struct objc_class*.  Here we case the result
  // to the pseudo-builtin, because that will be implicitly cast back to the
  // redefinition type if an attempt is made to access its fields.
  if (LHSTy.$arrow().isObjCClassType()
     && ($this().Context.hasSameType(new QualType(RHSTy), $this().Context.getObjCClassRedefinitionType()))) {
    RHS.$assignMove($this().ImpCastExprToType(RHS.get(), new QualType(LHSTy), CastKind.CK_CPointerToObjCPointerCast));
    return LHSTy;
  }
  if (RHSTy.$arrow().isObjCClassType()
     && ($this().Context.hasSameType(new QualType(LHSTy), $this().Context.getObjCClassRedefinitionType()))) {
    LHS.$assignMove($this().ImpCastExprToType(LHS.get(), new QualType(RHSTy), CastKind.CK_CPointerToObjCPointerCast));
    return RHSTy;
  }
  // And the same for struct objc_object* / id
  if (LHSTy.$arrow().isObjCIdType()
     && ($this().Context.hasSameType(new QualType(RHSTy), $this().Context.getObjCIdRedefinitionType()))) {
    RHS.$assignMove($this().ImpCastExprToType(RHS.get(), new QualType(LHSTy), CastKind.CK_CPointerToObjCPointerCast));
    return LHSTy;
  }
  if (RHSTy.$arrow().isObjCIdType()
     && ($this().Context.hasSameType(new QualType(LHSTy), $this().Context.getObjCIdRedefinitionType()))) {
    LHS.$assignMove($this().ImpCastExprToType(LHS.get(), new QualType(RHSTy), CastKind.CK_CPointerToObjCPointerCast));
    return RHSTy;
  }
  // And the same for struct objc_selector* / SEL
  if ($this().Context.isObjCSelType(new QualType(LHSTy))
     && ($this().Context.hasSameType(new QualType(RHSTy), $this().Context.getObjCSelRedefinitionType()))) {
    RHS.$assignMove($this().ImpCastExprToType(RHS.get(), new QualType(LHSTy), CastKind.CK_BitCast));
    return LHSTy;
  }
  if ($this().Context.isObjCSelType(new QualType(RHSTy))
     && ($this().Context.hasSameType(new QualType(LHSTy), $this().Context.getObjCSelRedefinitionType()))) {
    LHS.$assignMove($this().ImpCastExprToType(LHS.get(), new QualType(RHSTy), CastKind.CK_BitCast));
    return RHSTy;
  }
  // Check constraints for Objective-C object pointers types.
  if (LHSTy.$arrow().isObjCObjectPointerType() && RHSTy.$arrow().isObjCObjectPointerType()) {
    if ($eq_CanQual$T_CanQual$U($this().Context.getCanonicalType(new QualType(LHSTy)), $this().Context.getCanonicalType(new QualType(RHSTy)))) {
      // Two identical object pointer types are always compatible.
      return LHSTy;
    }
    /*const*/ ObjCObjectPointerType /*P*/ LHSOPT = LHSTy.$arrow().castAs(ObjCObjectPointerType.class);
    /*const*/ ObjCObjectPointerType /*P*/ RHSOPT = RHSTy.$arrow().castAs(ObjCObjectPointerType.class);
    QualType compositeType = new QualType(LHSTy);
    
    // If both operands are interfaces and either operand can be
    // assigned to the other, use that type as the composite
    // type. This allows
    //   xxx ? (A*) a : (B*) b
    // where B is a subclass of A.
    //
    // Additionally, as for assignment, if either type is 'id'
    // allow silent coercion. Finally, if the types are
    // incompatible then make sure to use 'id' as the composite
    // type so the result is acceptable for sending messages to.
    
    // FIXME: Consider unifying with 'areComparableObjCPointerTypes'.
    // It could return the composite type.
    if (!(compositeType.$assignMove(
        $this().Context.areCommonBaseCompatible(LHSOPT, RHSOPT)
    )).isNull()) {
      // Nothing more to do.
    } else if ($this().Context.canAssignObjCInterfaces(LHSOPT, RHSOPT)) {
      compositeType.$assign(RHSOPT.isObjCBuiltinType() ? RHSTy : LHSTy);
    } else if ($this().Context.canAssignObjCInterfaces(RHSOPT, LHSOPT)) {
      compositeType.$assign(LHSOPT.isObjCBuiltinType() ? LHSTy : RHSTy);
    } else if ((LHSTy.$arrow().isObjCQualifiedIdType()
       || RHSTy.$arrow().isObjCQualifiedIdType())
       && $this().Context.ObjCQualifiedIdTypesAreCompatible(new QualType(LHSTy), new QualType(RHSTy), true)) {
      // Need to handle "id<xx>" explicitly.
      // GCC allows qualified id and any Objective-C type to devolve to
      // id. Currently localizing to here until clear this should be
      // part of ObjCQualifiedIdTypesAreCompatible.
      compositeType.$assignMove($this().Context.getObjCIdType());
    } else if (LHSTy.$arrow().isObjCIdType() || RHSTy.$arrow().isObjCIdType()) {
      compositeType.$assignMove($this().Context.getObjCIdType());
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(QuestionLoc), diag.ext_typecheck_cond_incompatible_operands)), 
                        LHSTy), RHSTy), 
                LHS.get().getSourceRange()), RHS.get().getSourceRange()));
        QualType incompatTy = $this().Context.getObjCIdType();
        LHS.$assignMove($this().ImpCastExprToType(LHS.get(), new QualType(incompatTy), CastKind.CK_BitCast));
        RHS.$assignMove($this().ImpCastExprToType(RHS.get(), new QualType(incompatTy), CastKind.CK_BitCast));
        return incompatTy;
      } finally {
        $c$.$destroy();
      }
    }
    // The object pointer types are compatible.
    LHS.$assignMove($this().ImpCastExprToType(LHS.get(), new QualType(compositeType), CastKind.CK_BitCast));
    RHS.$assignMove($this().ImpCastExprToType(RHS.get(), new QualType(compositeType), CastKind.CK_BitCast));
    return compositeType;
  }
  // Check Objective-C object pointer types and 'void *'
  if (LHSTy.$arrow().isVoidPointerType() && RHSTy.$arrow().isObjCObjectPointerType()) {
    if ($this().getLangOpts().ObjCAutoRefCount) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // ARC forbids the implicit conversion of object pointers to 'void *',
        // so these types are not compatible.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(QuestionLoc), diag.err_cond_voidptr_arc)), LHSTy), RHSTy), 
                LHS.get().getSourceRange()), RHS.get().getSourceRange()));
        LHS.$assign(RHS.$assignMove(new ActionResultTTrue<Expr /*P*/ >(true)));
        return new QualType();
      } finally {
        $c$.$destroy();
      }
    }
    QualType lhptee = LHSTy.$arrow().getAs(PointerType.class).getPointeeType();
    QualType rhptee = RHSTy.$arrow().getAs(ObjCObjectPointerType.class).getPointeeType();
    QualType destPointee = $this().Context.getQualifiedType(new QualType(lhptee), rhptee.getQualifiers());
    QualType destType = $this().Context.getPointerType(new QualType(destPointee));
    // Add qualifiers if necessary.
    LHS.$assignMove($this().ImpCastExprToType(LHS.get(), new QualType(destType), CastKind.CK_NoOp));
    // Promote to void*.
    RHS.$assignMove($this().ImpCastExprToType(RHS.get(), new QualType(destType), CastKind.CK_BitCast));
    return destType;
  }
  if (LHSTy.$arrow().isObjCObjectPointerType() && RHSTy.$arrow().isVoidPointerType()) {
    if ($this().getLangOpts().ObjCAutoRefCount) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // ARC forbids the implicit conversion of object pointers to 'void *',
        // so these types are not compatible.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(QuestionLoc), diag.err_cond_voidptr_arc)), LHSTy), RHSTy), 
                LHS.get().getSourceRange()), RHS.get().getSourceRange()));
        LHS.$assign(RHS.$assignMove(new ActionResultTTrue<Expr /*P*/ >(true)));
        return new QualType();
      } finally {
        $c$.$destroy();
      }
    }
    QualType lhptee = LHSTy.$arrow().getAs(ObjCObjectPointerType.class).getPointeeType();
    QualType rhptee = RHSTy.$arrow().getAs(PointerType.class).getPointeeType();
    QualType destPointee = $this().Context.getQualifiedType(new QualType(rhptee), lhptee.getQualifiers());
    QualType destType = $this().Context.getPointerType(new QualType(destPointee));
    // Add qualifiers if necessary.
    RHS.$assignMove($this().ImpCastExprToType(RHS.get(), new QualType(destType), CastKind.CK_NoOp));
    // Promote to void*.
    LHS.$assignMove($this().ImpCastExprToType(LHS.get(), new QualType(destType), CastKind.CK_BitCast));
    return destType;
  }
  return new QualType();
}


/// \brief Emit a specialized diagnostic when one expression is a null pointer
/// constant and the other is not a pointer.  Returns true if a diagnostic is
/// emitted.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseConditionalForNull">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6117,
 FQN="clang::Sema::DiagnoseConditionalForNull", NM="_ZN5clang4Sema26DiagnoseConditionalForNullEPNS_4ExprES2_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema26DiagnoseConditionalForNullEPNS_4ExprES2_NS_14SourceLocationE")
//</editor-fold>
public final boolean DiagnoseConditionalForNull(Expr /*P*/ LHSExpr, Expr /*P*/ RHSExpr, 
                          SourceLocation QuestionLoc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Expr /*P*/ NullExpr = LHSExpr;
    Expr /*P*/ NonPointerExpr = RHSExpr;
    Expr.NullPointerConstantKind NullKind = NullExpr.isNullPointerConstant($this().Context, 
        Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNotNull);
    if (NullKind == Expr.NullPointerConstantKind.NPCK_NotNull) {
      NullExpr = RHSExpr;
      NonPointerExpr = LHSExpr;
      NullKind
         = NullExpr.isNullPointerConstant($this().Context, 
          Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNotNull);
    }
    if (NullKind == Expr.NullPointerConstantKind.NPCK_NotNull) {
      return false;
    }
    if (NullKind == Expr.NullPointerConstantKind.NPCK_ZeroExpression) {
      return false;
    }
    if (NullKind == Expr.NullPointerConstantKind.NPCK_ZeroLiteral) {
      // In this case, check to make sure that we got here from a "NULL"
      // string in the source code.
      NullExpr = NullExpr.IgnoreParenImpCasts();
      SourceLocation loc = NullExpr.getExprLoc();
      if (!$this().findMacroSpelling(loc, new StringRef(/*KEEP_STR*/"NULL"))) {
        return false;
      }
    }
    
    int DiagType = ((NullKind == Expr.NullPointerConstantKind.NPCK_CXX11_nullptr) ? 1 : 0);
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(QuestionLoc), diag.err_typecheck_cond_incompatible_operands_null)), 
                NonPointerExpr.getType()), DiagType), 
        NonPointerExpr.getSourceRange()));
    return true;
  } finally {
    $c$.$destroy();
  }
}


/// type checking for vector binary operators.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckVectorOperands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 7870,
 FQN="clang::Sema::CheckVectorOperands", NM="_ZN5clang4Sema19CheckVectorOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationEbbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema19CheckVectorOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationEbbb")
//</editor-fold>
public final QualType CheckVectorOperands(final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                   SourceLocation Loc, boolean IsCompAssign, 
                   boolean AllowBothBool, 
                   boolean AllowBoolConversions) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (!IsCompAssign) {
      LHS.$assignMove($this().DefaultFunctionArrayLvalueConversion(LHS.get()));
      if (LHS.isInvalid()) {
        return new QualType();
      }
    }
    RHS.$assignMove($this().DefaultFunctionArrayLvalueConversion(RHS.get()));
    if (RHS.isInvalid()) {
      return new QualType();
    }
    
    // For conversion purposes, we ignore any qualifiers.
    // For example, "const float" and "float" are equivalent.
    QualType LHSType = LHS.get().getType().getUnqualifiedType();
    QualType RHSType = RHS.get().getType().getUnqualifiedType();
    
    /*const*/ VectorType /*P*/ LHSVecType = LHSType.$arrow().getAs(VectorType.class);
    /*const*/ VectorType /*P*/ RHSVecType = RHSType.$arrow().getAs(VectorType.class);
    assert ((LHSVecType != null) || (RHSVecType != null));
    
    // AltiVec-style "vector bool op vector bool" combinations are allowed
    // for some operators but not others.
    if (!AllowBothBool
       && (LHSVecType != null) && LHSVecType.getVectorKind() == VectorType.VectorKind.AltiVecBool
       && (RHSVecType != null) && RHSVecType.getVectorKind() == VectorType.VectorKind.AltiVecBool) {
      return $this().InvalidOperands(new SourceLocation(Loc), LHS, RHS);
    }
    
    // If the vector types are identical, return.
    if ($this().Context.hasSameType(new QualType(LHSType), new QualType(RHSType))) {
      return LHSType;
    }
    
    // If we have compatible AltiVec and GCC vector types, use the AltiVec type.
    if ((LHSVecType != null) && (RHSVecType != null)
       && $this().Context.areCompatibleVectorTypes(new QualType(LHSType), new QualType(RHSType))) {
      if (isa_ExtVectorType(LHSVecType)) {
        RHS.$assignMove($this().ImpCastExprToType(RHS.get(), new QualType(LHSType), CastKind.CK_BitCast));
        return LHSType;
      }
      if (!IsCompAssign) {
        LHS.$assignMove($this().ImpCastExprToType(LHS.get(), new QualType(RHSType), CastKind.CK_BitCast));
      }
      return RHSType;
    }
    
    // AllowBoolConversions says that bool and non-bool AltiVec vectors
    // can be mixed, with the result being the non-bool type.  The non-bool
    // operand must have integer element type.
    if (AllowBoolConversions && (LHSVecType != null) && (RHSVecType != null)
       && LHSVecType.getNumElements() == RHSVecType.getNumElements()
       && ($this().Context.getTypeSize(LHSVecType.getElementType())
       == $this().Context.getTypeSize(RHSVecType.getElementType()))) {
      if (LHSVecType.getVectorKind() == VectorType.VectorKind.AltiVecVector
         && LHSVecType.getElementType().$arrow().isIntegerType()
         && RHSVecType.getVectorKind() == VectorType.VectorKind.AltiVecBool) {
        RHS.$assignMove($this().ImpCastExprToType(RHS.get(), new QualType(LHSType), CastKind.CK_BitCast));
        return LHSType;
      }
      if (!IsCompAssign
         && LHSVecType.getVectorKind() == VectorType.VectorKind.AltiVecBool
         && RHSVecType.getVectorKind() == VectorType.VectorKind.AltiVecVector
         && RHSVecType.getElementType().$arrow().isIntegerType()) {
        LHS.$assignMove($this().ImpCastExprToType(LHS.get(), new QualType(RHSType), CastKind.CK_BitCast));
        return RHSType;
      }
    }
    
    // If there's an ext-vector type and a scalar, try to convert the scalar to
    // the vector element type and splat.
    if (!(RHSVecType != null) && isa_ExtVectorType(LHSVecType)) {
      if (!tryVectorConvertAndSplat(/*Deref*/$this(), $AddrOf(RHS), new QualType(RHSType), 
          LHSVecType.getElementType(), new QualType(LHSType))) {
        return LHSType;
      }
    }
    if (!(LHSVecType != null) && isa_ExtVectorType(RHSVecType)) {
      if (!tryVectorConvertAndSplat(/*Deref*/$this(), (IsCompAssign ? (ActionResultTTrue<Expr /*P*/ > /*P*/ )null : $AddrOf(LHS)), 
          new QualType(LHSType), RHSVecType.getElementType(), 
          new QualType(RHSType))) {
        return RHSType;
      }
    }
    
    // If we're allowing lax vector conversions, only the total (data) size needs
    // to be the same. If one of the types is scalar, the result is always the
    // vector type. Don't allow this if the scalar operand is an lvalue.
    QualType VecType = new QualType((LHSVecType != null) ? LHSType : RHSType);
    QualType ScalarType = new QualType((LHSVecType != null) ? RHSType : LHSType);
    ActionResultTTrue<Expr /*P*/ > /*P*/ ScalarExpr = (LHSVecType != null) ? $AddrOf(RHS) : $AddrOf(LHS);
    if ($this().isLaxVectorConversion(new QualType(ScalarType), new QualType(VecType))
       && !ScalarExpr.get().isLValue()) {
      /*Deref*/ScalarExpr.$assignMove($this().ImpCastExprToType(ScalarExpr.get(), new QualType(VecType), CastKind.CK_BitCast));
      return VecType;
    }
    
    // Okay, the expression is invalid.
    
    // If there's a non-vector, non-real operand, diagnose that.
    if ((!(RHSVecType != null) && !RHSType.$arrow().isRealType())
       || (!(LHSVecType != null) && !LHSType.$arrow().isRealType())) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_typecheck_vector_not_convertable_non_scalar)), 
                      LHSType), RHSType), 
              LHS.get().getSourceRange()), RHS.get().getSourceRange()));
      return new QualType();
    }
    
    // OpenCL V1.1 6.2.6.p1:
    // If the operands are of more than one vector type, then an error shall
    // occur. Implicit conversions between vector types are not permitted, per
    // section 6.2.1.
    if ($this().getLangOpts().OpenCL
       && (RHSVecType != null) && isa_ExtVectorType(RHSVecType)
       && (LHSVecType != null) && isa_ExtVectorType(LHSVecType)) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_opencl_implicit_vector_conversion)), LHSType), 
          RHSType));
      return new QualType();
    }
    
    // Otherwise, use the generic diagnostic.
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_typecheck_vector_not_convertable)), 
                    LHSType), RHSType), 
            LHS.get().getSourceRange()), RHS.get().getSourceRange()));
    return new QualType();
  } finally {
    $c$.$destroy();
  }
}


// Return a signed type that is of identical size and number of elements.
// For floating point vectors, return an integer type of identical size 
// and number of elements.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::GetSignedVectorType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 9442,
 FQN="clang::Sema::GetSignedVectorType", NM="_ZN5clang4Sema19GetSignedVectorTypeENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema19GetSignedVectorTypeENS_8QualTypeE")
//</editor-fold>
public final QualType GetSignedVectorType(QualType V) {
  /*const*/ VectorType /*P*/ VTy = V.$arrow().getAs(VectorType.class);
  /*uint*/int TypeSize = $ulong2uint($this().Context.getTypeSize(VTy.getElementType()));
  if ($uint2ullong(TypeSize) == $this().Context.getTypeSize($this().Context.CharTy.$QualType())) {
    return $this().Context.getExtVectorType($this().Context.CharTy.$QualType(), VTy.getNumElements());
  } else if ($uint2ullong(TypeSize) == $this().Context.getTypeSize($this().Context.ShortTy.$QualType())) {
    return $this().Context.getExtVectorType($this().Context.ShortTy.$QualType(), VTy.getNumElements());
  } else if ($uint2ullong(TypeSize) == $this().Context.getTypeSize($this().Context.IntTy.$QualType())) {
    return $this().Context.getExtVectorType($this().Context.IntTy.$QualType(), VTy.getNumElements());
  } else if ($uint2ullong(TypeSize) == $this().Context.getTypeSize($this().Context.LongTy.$QualType())) {
    return $this().Context.getExtVectorType($this().Context.LongTy.$QualType(), VTy.getNumElements());
  }
  assert ($uint2ullong(TypeSize) == $this().Context.getTypeSize($this().Context.LongLongTy.$QualType())) : "Unhandled vector element size in vector compare";
  return $this().Context.getExtVectorType($this().Context.LongLongTy.$QualType(), VTy.getNumElements());
}


/// CheckVectorCompareOperands - vector comparisons are a clang extension that
/// operates on extended vector types.  Instead of producing an IntTy result,
/// like a scalar comparison, a vector comparison produces a vector of integer
/// types.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckVectorCompareOperands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 9462,
 FQN="clang::Sema::CheckVectorCompareOperands", NM="_ZN5clang4Sema26CheckVectorCompareOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema26CheckVectorCompareOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationEb")
//</editor-fold>
public final QualType CheckVectorCompareOperands(final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                          SourceLocation Loc, 
                          boolean IsRelational) {
  // Check to make sure we're operating on vectors of the same type and width,
  // Allowing one side to be a scalar of element type.
  QualType vType = $this().CheckVectorOperands(LHS, RHS, new SourceLocation(Loc), /*isCompAssign*/ false, 
      /*AllowBothBool*/ true, 
      /*AllowBoolConversions*/ $this().getLangOpts().ZVector);
  if (vType.isNull()) {
    return vType;
  }
  
  QualType LHSType = LHS.get().getType();
  
  // If AltiVec, the comparison results in a numeric type, i.e.
  // bool for C++, int for C
  if ($this().getLangOpts().AltiVec
     && vType.$arrow().getAs(VectorType.class).getVectorKind() == VectorType.VectorKind.AltiVecVector) {
    return $this().Context.getLogicalOperationType();
  }
  
  // For non-floating point types, check for self-comparisons of the form
  // x == x, x != x, x < x, etc.  These always evaluate to a constant, and
  // often indicate logic errors in the program.
  if (!LHSType.$arrow().hasFloatingRepresentation()
     && $this().ActiveTemplateInstantiations.empty()) {
    {
      DeclRefExpr /*P*/ DRL = dyn_cast_DeclRefExpr(LHS.get().IgnoreParenImpCasts());
      if ((DRL != null)) {
        {
          DeclRefExpr /*P*/ DRR = dyn_cast_DeclRefExpr(RHS.get().IgnoreParenImpCasts());
          if ((DRR != null)) {
            if (DRL.getDecl() == DRR.getDecl()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($this().DiagRuntimeBehavior(new SourceLocation(Loc), (/*const*/ Stmt /*P*/ )null, 
                    $out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_int($c$.track($this().PDiag(diag.warn_comparison_always)), 
                            0),  // self-
                        2)));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      }
    }
  }
  
  // Check for comparisons of floating point operands using != and ==.
  if (!IsRelational && LHSType.$arrow().hasFloatingRepresentation()) {
    assert (RHS.get().getType().$arrow().hasFloatingRepresentation());
    $this().CheckFloatComparison(new SourceLocation(Loc), LHS.get(), RHS.get());
  }
  
  // Return a signed type for the vector.
  return $this().GetSignedVectorType(new QualType(vType));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckVectorLogicalOperands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 9508,
 FQN="clang::Sema::CheckVectorLogicalOperands", NM="_ZN5clang4Sema26CheckVectorLogicalOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema26CheckVectorLogicalOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_NS_14SourceLocationE")
//</editor-fold>
public final QualType CheckVectorLogicalOperands(final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                          SourceLocation Loc) {
  // Ensure that either both operands are of the same vector type, or
  // one operand is of a vector type and the other is of its element type.
  QualType vType = $this().CheckVectorOperands(LHS, RHS, new SourceLocation(Loc), false, 
      /*AllowBothBool*/ true, 
      /*AllowBoolConversions*/ false);
  if (vType.isNull()) {
    return $this().InvalidOperands(new SourceLocation(Loc), LHS, RHS);
  }
  if ($this().getLangOpts().OpenCL && $less_uint($this().getLangOpts().OpenCLVersion, 120)
     && vType.$arrow().hasFloatingRepresentation()) {
    return $this().InvalidOperands(new SourceLocation(Loc), LHS, RHS);
  }
  
  return $this().GetSignedVectorType(LHS.get().getType());
}


/// Are the two types lax-compatible vector types?  That is, given
/// that one of them is a vector, do they have equal storage sizes,
/// where the storage size is the number of elements times the element
/// size?
///
/// This will also return false if either of the types is neither a
/// vector nor a real type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::areLaxCompatibleVectorTypes">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 5813,
 FQN="clang::Sema::areLaxCompatibleVectorTypes", NM="_ZN5clang4Sema27areLaxCompatibleVectorTypesENS_8QualTypeES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema27areLaxCompatibleVectorTypesENS_8QualTypeES1_")
//</editor-fold>
public final boolean areLaxCompatibleVectorTypes(QualType srcTy, QualType destTy) {
  assert (destTy.$arrow().isVectorType() || srcTy.$arrow().isVectorType());
  
  // Disallow lax conversions between scalars and ExtVectors (these
  // conversions are allowed for other vector types because common headers
  // depend on them).  Most scalar OP ExtVector cases are handled by the
  // splat path anyway, which does what we want (convert, not bitcast).
  // What this rules out for ExtVectors is crazy things like char4*float.
  if (srcTy.$arrow().isScalarType() && destTy.$arrow().isExtVectorType()) {
    return false;
  }
  if (destTy.$arrow().isScalarType() && srcTy.$arrow().isExtVectorType()) {
    return false;
  }
  
  ulong$ref srcLen = create_ulong$ref(0);
  ulong$ref destLen = create_ulong$ref(0);
  QualType srcEltTy/*J*/= new QualType();
  QualType destEltTy/*J*/= new QualType();
  if (!breakDownVectorType(new QualType(srcTy), srcLen, srcEltTy)) {
    return false;
  }
  if (!breakDownVectorType(new QualType(destTy), destLen, destEltTy)) {
    return false;
  }
  
  // ASTContext::getTypeSize will return the size rounded up to a
  // power of 2, so instead of using that, we need to use the raw
  // element size multiplied by the element count.
  long/*uint64_t*/ srcEltSize = $this().Context.getTypeSize(new QualType(srcEltTy));
  long/*uint64_t*/ destEltSize = $this().Context.getTypeSize(new QualType(destEltTy));
  
  return (srcLen.$deref() * srcEltSize == destLen.$deref() * destEltSize);
}


/// Is this a legal conversion between two types, one of which is
/// known to be a vector type?
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isLaxVectorConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 5840,
 FQN="clang::Sema::isLaxVectorConversion", NM="_ZN5clang4Sema21isLaxVectorConversionENS_8QualTypeES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema21isLaxVectorConversionENS_8QualTypeES1_")
//</editor-fold>
public final boolean isLaxVectorConversion(QualType srcTy, QualType destTy) {
  assert (destTy.$arrow().isVectorType() || srcTy.$arrow().isVectorType());
  if (!$this().Context.getLangOpts().LaxVectorConversions) {
    return false;
  }
  return $this().areLaxCompatibleVectorTypes(new QualType(srcTy), new QualType(destTy));
}


/// Check a cast of an unknown-any type.  We intentionally only
/// trigger this for C-style casts.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkUnknownAnyCast">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14863,
 FQN="clang::Sema::checkUnknownAnyCast", NM="_ZN5clang4Sema19checkUnknownAnyCastENS_11SourceRangeENS_8QualTypeEPNS_4ExprERNS_8CastKindERNS_13ExprValueKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema19checkUnknownAnyCastENS_11SourceRangeENS_8QualTypeEPNS_4ExprERNS_8CastKindERNS_13ExprValueKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > checkUnknownAnyCast(SourceRange TypeRange, QualType CastType, 
                   Expr /*P*/ CastExpr, final type$ref<CastKind /*&*/> _CastKind, 
                   final type$ref<ExprValueKind /*&*/> VK, final SmallVector<CXXBaseSpecifier /*P*/> /*&*/ Path) {
  // The type we're casting to must be either void or complete.
  if (!CastType.$arrow().isVoidType()
     && $this().RequireCompleteType(TypeRange.getBegin(), new QualType(CastType), 
      diag.err_typecheck_cast_to_incomplete)) {
    return ExprError();
  }
  
  // Rewrite the casted expression from scratch.
  ActionResultTTrue<Expr /*P*/ > result = new RebuildUnknownAnyExpr(/*Deref*/$this(), new QualType(CastType)).Visit(CastExpr);
  if (!result.isUsable()) {
    return ExprError();
  }
  
  CastExpr = result.get();
  VK.$set(CastExpr.getValueKind());
  _CastKind.$set(CastKind.CK_NoOp);
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, CastExpr);
}


/// \brief Force an expression with unknown-type to an expression of the
/// given type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::forceUnknownAnyToType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14883,
 FQN="clang::Sema::forceUnknownAnyToType", NM="_ZN5clang4Sema21forceUnknownAnyToTypeEPNS_4ExprENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema21forceUnknownAnyToTypeEPNS_4ExprENS_8QualTypeE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > forceUnknownAnyToType(Expr /*P*/ E, QualType ToType) {
  return new RebuildUnknownAnyExpr(/*Deref*/$this(), new QualType(ToType)).Visit(E);
}


/// \brief Type-check an expression that's being passed to an
/// __unknown_anytype parameter.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkUnknownAnyArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14887,
 FQN="clang::Sema::checkUnknownAnyArg", NM="_ZN5clang4Sema18checkUnknownAnyArgENS_14SourceLocationEPNS_4ExprERNS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema18checkUnknownAnyArgENS_14SourceLocationEPNS_4ExprERNS_8QualTypeE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > checkUnknownAnyArg(SourceLocation callLoc, 
                  Expr /*P*/ arg, final QualType /*&*/ paramType) {
  // If the syntactic form of the argument is not an explicit cast of
  // any sort, just do default argument promotion.
  ExplicitCastExpr /*P*/ castArg = dyn_cast_ExplicitCastExpr(arg.IgnoreParens());
  if (!(castArg != null)) {
    ActionResultTTrue<Expr /*P*/ > result = $this().DefaultArgumentPromotion(arg);
    if (result.isInvalid()) {
      return ExprError();
    }
    paramType.$assignMove(result.get().getType());
    return result;
  }
  
  // Otherwise, use the type that was written in the explicit cast.
  assert (!arg.hasPlaceholderType());
  paramType.$assignMove(castArg.getTypeAsWritten());
  
  // Copy-initialize a parameter of that type.
  InitializedEntity entity = InitializedEntity.InitializeParameter($this().Context, new QualType(paramType), 
      /*consumed*/ false);
  return $this().PerformCopyInitialization(entity, new SourceLocation(callLoc), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, arg));
}


// CheckVectorCast - check type constraints for vectors.
// Since vectors are an extension, there are no C standard reference for this.
// We allow casting between vectors and integer datatypes of the same size.
// returns true if the cast is invalid
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckVectorCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 5848,
 FQN="clang::Sema::CheckVectorCast", NM="_ZN5clang4Sema15CheckVectorCastENS_11SourceRangeENS_8QualTypeES2_RNS_8CastKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema15CheckVectorCastENS_11SourceRangeENS_8QualTypeES2_RNS_8CastKindE")
//</editor-fold>
public final boolean CheckVectorCast(SourceRange R, QualType VectorTy, QualType Ty, 
               final type$ref<CastKind /*&*/> Kind) {
  assert (VectorTy.$arrow().isVectorType()) : "Not a vector type!";
  if (Ty.$arrow().isVectorType() || Ty.$arrow().isIntegralType($this().Context)) {
    if (!$this().areLaxCompatibleVectorTypes(new QualType(Ty), new QualType(VectorTy))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(R.getBegin(), 
                        Ty.$arrow().isVectorType() ? diag.err_invalid_conversion_between_vectors : diag.err_invalid_conversion_between_vector_and_integer)), 
                    VectorTy), Ty), R).$bool());
      } finally {
        $c$.$destroy();
      }
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(R.getBegin(), 
                      diag.err_invalid_conversion_between_vector_and_scalar)), 
                  VectorTy), Ty), R).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  Kind.$set(CastKind.CK_BitCast);
  return false;
}


/// \brief Prepare `SplattedExpr` for a vector splat operation, adding
/// implicit casts if necessary.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::prepareVectorSplat">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 5868,
 FQN="clang::Sema::prepareVectorSplat", NM="_ZN5clang4Sema18prepareVectorSplatENS_8QualTypeEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema18prepareVectorSplatENS_8QualTypeEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > prepareVectorSplat(QualType VectorTy, Expr /*P*/ SplattedExpr) {
  QualType DestElemTy = VectorTy.$arrow().castAs(VectorType.class).getElementType();
  if ($eq_QualType$C(DestElemTy, SplattedExpr.getType())) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, SplattedExpr);
  }
  assert (DestElemTy.$arrow().isFloatingType() || DestElemTy.$arrow().isIntegralOrEnumerationType());
  
  CastKind CK;
  if (VectorTy.$arrow().isExtVectorType() && SplattedExpr.getType().$arrow().isBooleanType()) {
    // OpenCL requires that we convert `true` boolean expressions to -1, but
    // only when splatting vectors.
    if (DestElemTy.$arrow().isFloatingType()) {
      // To avoid having to have a CK_BooleanToSignedFloating cast kind, we cast
      // in two steps: boolean to signed integral, then to floating.
      ActionResultTTrue<Expr /*P*/ > CastExprRes = $this().ImpCastExprToType(SplattedExpr, $this().Context.IntTy.$QualType(), 
          CastKind.CK_BooleanToSignedIntegral);
      SplattedExpr = CastExprRes.get();
      CK = CastKind.CK_IntegralToFloating;
    } else {
      CK = CastKind.CK_BooleanToSignedIntegral;
    }
  } else {
    ActionResultTTrue<Expr /*P*/ > CastExprRes = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, SplattedExpr);
    CK = $this().PrepareScalarCast(CastExprRes, new QualType(DestElemTy));
    if (CastExprRes.isInvalid()) {
      return ExprError();
    }
    SplattedExpr = CastExprRes.get();
  }
  return $this().ImpCastExprToType(SplattedExpr, new QualType(DestElemTy), CK);
}


// CheckExtVectorCast - check type constraints for extended vectors.
// Since vectors are an extension, there are no C standard reference for this.
// We allow casting between vectors and integer datatypes of the same size,
// or vectors and the element type of that vector.
// returns the cast expr
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckExtVectorCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 5901,
 FQN="clang::Sema::CheckExtVectorCast", NM="_ZN5clang4Sema18CheckExtVectorCastENS_11SourceRangeENS_8QualTypeEPNS_4ExprERNS_8CastKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema18CheckExtVectorCastENS_11SourceRangeENS_8QualTypeEPNS_4ExprERNS_8CastKindE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CheckExtVectorCast(SourceRange R, QualType DestTy, 
                  Expr /*P*/ CastExpr, final type$ref<CastKind /*&*/> Kind) {
  assert (DestTy.$arrow().isExtVectorType()) : "Not an extended vector type!";
  
  QualType SrcTy = CastExpr.getType();
  
  // If SrcTy is a VectorType, the total size must match to explicitly cast to
  // an ExtVectorType.
  // In OpenCL, casts between vectors of different types are not allowed.
  // (See OpenCL 6.2).
  if (SrcTy.$arrow().isVectorType()) {
    if (!$this().areLaxCompatibleVectorTypes(new QualType(SrcTy), new QualType(DestTy))
       || ($this().getLangOpts().OpenCL
       && ($noteq_QualType$C(DestTy.getCanonicalType(), SrcTy.getCanonicalType())))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(R.getBegin(), diag.err_invalid_conversion_between_ext_vectors)), 
                    DestTy), SrcTy), R));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    Kind.$set(CastKind.CK_BitCast);
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, CastExpr);
  }
  
  // All non-pointer scalars can be cast to ExtVector type.  The appropriate
  // conversion will take place first from scalar to elt type, and then
  // splat from elt type to vector.
  if (SrcTy.$arrow().isPointerType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(R.getBegin(), 
                          diag.err_invalid_conversion_between_vector_and_scalar)), 
                      DestTy), SrcTy), R)));
    } finally {
      $c$.$destroy();
    }
  }
  
  Kind.$set(CastKind.CK_VectorSplat);
  return $this().prepareVectorSplat(new QualType(DestTy), CastExpr);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCondition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14402,
 FQN="clang::Sema::ActOnCondition", NM="_ZN5clang4Sema14ActOnConditionEPNS_5ScopeENS_14SourceLocationEPNS_4ExprENS0_13ConditionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema14ActOnConditionEPNS_5ScopeENS_14SourceLocationEPNS_4ExprENS0_13ConditionKindE")
//</editor-fold>
public final Sema.ConditionResult ActOnCondition(Scope /*P*/ S, SourceLocation Loc, 
              Expr /*P*/ SubExpr, ConditionKind CK) {
  // Empty conditions are valid in for-statements.
  if (!(SubExpr != null)) {
    return new ConditionResult();
  }
  
  ActionResultTTrue<Expr /*P*/ > Cond/*J*/= new ActionResultTTrue<Expr /*P*/ >();
  switch (CK) {
   case Boolean:
    Cond.$assignMove($this().CheckBooleanCondition(new SourceLocation(Loc), SubExpr));
    break;
   case ConstexprIf:
    Cond.$assignMove($this().CheckBooleanCondition(new SourceLocation(Loc), SubExpr, true));
    break;
   case Switch:
    Cond.$assignMove($this().CheckSwitchCondition(new SourceLocation(Loc), SubExpr));
    break;
  }
  if (Cond.isInvalid()) {
    return ConditionError();
  }
  
  // FIXME: FullExprArg doesn't have an invalid bit, so check nullness instead.
  FullExprArg FullExpr = $this().MakeFullExpr(Cond.get(), new SourceLocation(Loc));
  if (!(FullExpr.get() != null)) {
    return ConditionError();
  }
  
  return new ConditionResult(/*Deref*/$this(), (Decl /*P*/ )null, new FullExprArg(FullExpr), 
      CK == ConditionKind.ConstexprIf);
}


/// CheckBooleanCondition - Diagnose problems involving the use of
/// the given expression as a boolean condition (e.g. in an if
/// statement).  Also performs the standard function and array
/// decays, possibly changing the input variable.
///
/// \param Loc - A location associated with the condition, e.g. the
/// 'if' keyword.
/// \return true iff there were any errors
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckBooleanCondition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14371,
 FQN="clang::Sema::CheckBooleanCondition", NM="_ZN5clang4Sema21CheckBooleanConditionENS_14SourceLocationEPNS_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema21CheckBooleanConditionENS_14SourceLocationEPNS_4ExprEb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CheckBooleanCondition(SourceLocation Loc, Expr /*P*/ E) {
  return CheckBooleanCondition(Loc, E, 
                     false);
}
public final ActionResultTTrue<Expr /*P*/ > CheckBooleanCondition(SourceLocation Loc, Expr /*P*/ E, 
                     boolean IsConstexpr/*= false*/) {
  $this().DiagnoseAssignmentAsCondition(E);
  {
    ParenExpr /*P*/ parenE = dyn_cast_ParenExpr(E);
    if ((parenE != null)) {
      $this().DiagnoseEqualityWithExtraParens(parenE);
    }
  }
  
  ActionResultTTrue<Expr /*P*/ > result = $this().CheckPlaceholderExpr(E);
  if (result.isInvalid()) {
    return ExprError();
  }
  E = result.get();
  if (!E.isTypeDependent()) {
    if ($this().getLangOpts().CPlusPlus) {
      return $this().CheckCXXBooleanCondition(E, IsConstexpr); // C++ 6.4p4
    }
    
    ActionResultTTrue<Expr /*P*/ > ERes = $this().DefaultFunctionArrayLvalueConversion(E);
    if (ERes.isInvalid()) {
      return ExprError();
    }
    E = ERes.get();
    
    QualType T = E.getType();
    if (!T.$arrow().isScalarType()) { // C99 6.8.4.1p1
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_typecheck_statement_requires_scalar)), 
                T), E.getSourceRange()));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    $this().CheckBoolLikeConversion(E, new SourceLocation(Loc));
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
}


/// DiagnoseAssignmentAsCondition - Given that an expression is
/// being used as a boolean condition, warn if it's an assignment.

// Diagnose the s/=/==/ and s/\|=/!=/ typos. Note that adding parentheses
// will prevent this condition from triggering, which is what we want.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseAssignmentAsCondition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14286,
 FQN="clang::Sema::DiagnoseAssignmentAsCondition", NM="_ZN5clang4Sema29DiagnoseAssignmentAsConditionEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema29DiagnoseAssignmentAsConditionEPNS_4ExprE")
//</editor-fold>
public final void DiagnoseAssignmentAsCondition(Expr /*P*/ E) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    SourceLocation Loc/*J*/= new SourceLocation();
    
    /*uint*/int diagnostic = diag.warn_condition_is_assignment;
    boolean IsOrAssign = false;
    {
      
      BinaryOperator /*P*/ Op = dyn_cast_BinaryOperator(E);
      if ((Op != null)) {
        if (Op.getOpcode() != BinaryOperatorKind.BO_Assign && Op.getOpcode() != BinaryOperatorKind.BO_OrAssign) {
          return;
        }
        
        IsOrAssign = Op.getOpcode() == BinaryOperatorKind.BO_OrAssign;
        {
          
          // Greylist some idioms by putting them into a warning subcategory.
          ObjCMessageExpr /*P*/ ME = dyn_cast_ObjCMessageExpr(Op.getRHS().IgnoreParenCasts());
          if ((ME != null)) {
            Selector Sel = ME.getSelector();
            
            // self = [<foo> init...]
            if ($this().isSelfExpr(Op.getLHS()) && ME.getMethodFamily() == ObjCMethodFamily.OMF_init) {
              diagnostic = diag.warn_condition_is_idiomatic_assignment;
            } else 
            // <foo> = [<bar> nextObject]
            if (Sel.isUnarySelector() && $eq_StringRef(Sel.getNameForSlot(0), /*STRINGREF_STR*/"nextObject")) {
              diagnostic = diag.warn_condition_is_idiomatic_assignment;
            }
          }
        }
        
        Loc.$assignMove(Op.getOperatorLoc());
      } else {
        CXXOperatorCallExpr /*P*/ Op$1 = dyn_cast_CXXOperatorCallExpr(E);
        if ((Op$1 != null)) {
          if (Op$1.getOperator() != OverloadedOperatorKind.OO_Equal && Op$1.getOperator() != OverloadedOperatorKind.OO_PipeEqual) {
            return;
          }
          
          IsOrAssign = Op$1.getOperator() == OverloadedOperatorKind.OO_PipeEqual;
          Loc.$assignMove(Op$1.getOperatorLoc());
        } else {
          PseudoObjectExpr /*P*/ POE = dyn_cast_PseudoObjectExpr(E);
          if ((POE != null)) {
            $this().DiagnoseAssignmentAsCondition(POE.getSyntacticForm());
            /*JAVA:return*/return;
          } else {
            // Not an assignment.
            return;
          }
        }
      }
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diagnostic)), E.getSourceRange()));
    
    SourceLocation Open = E.getLocStart();
    SourceLocation Close = $this().getLocForEndOfToken(E.getSourceRange().getEnd());
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.note_condition_assign_silence)), 
            FixItHint.CreateInsertion(/*NO_COPY*/Open, new StringRef(/*KEEP_STR*/$LPAREN))), 
        FixItHint.CreateInsertion(/*NO_COPY*/Close, new StringRef(/*KEEP_STR*/$RPAREN))));
    if (IsOrAssign) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.note_condition_or_assign_to_comparison)), 
          FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/Loc), new StringRef(/*KEEP_STR*/$EXCLAIM_EQ))));
    } else {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.note_condition_assign_to_comparison)), 
          FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/Loc), new StringRef(/*KEEP_STR*/$EQ_EQ))));
    }
  } finally {
    $c$.$destroy();
  }
}


/// \brief Redundant parentheses over an equality comparison can indicate
/// that the user intended an assignment used as condition.

/// \brief Redundant parentheses over an equality comparison can indicate
/// that the user intended an assignment used as condition.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseEqualityWithExtraParens">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14344,
 FQN="clang::Sema::DiagnoseEqualityWithExtraParens", NM="_ZN5clang4Sema31DiagnoseEqualityWithExtraParensEPNS_9ParenExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema31DiagnoseEqualityWithExtraParensEPNS_9ParenExprE")
//</editor-fold>
public final void DiagnoseEqualityWithExtraParens(ParenExpr /*P*/ ParenE) {
  // Don't warn if the parens came from a macro.
  SourceLocation parenLoc = ParenE.getLocStart();
  if (parenLoc.isInvalid() || parenLoc.isMacroID()) {
    return;
  }
  // Don't warn for dependent expressions.
  if (ParenE.isTypeDependent()) {
    return;
  }
  
  Expr /*P*/ E = ParenE.IgnoreParens();
  {
    
    BinaryOperator /*P*/ opE = dyn_cast_BinaryOperator(E);
    if ((opE != null)) {
      if (opE.getOpcode() == BinaryOperatorKind.BO_EQ
         && opE.getLHS().IgnoreParenImpCasts().isModifiableLvalue($this().Context)
         == Expr.isModifiableLvalueResult.MLV_Valid) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SourceLocation Loc = opE.getOperatorLoc();
          
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_equality_with_extra_parens)), E.getSourceRange()));
          SourceRange ParenERange = ParenE.getSourceRange();
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.note_equality_comparison_silence)), 
                  FixItHint.CreateRemoval(new SourceRange(ParenERange.getBegin()))), 
              FixItHint.CreateRemoval(new SourceRange(ParenERange.getEnd()))));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.note_equality_comparison_to_assign)), 
              FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/Loc), new StringRef(/*KEEP_STR*/$EQ))));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
}


/// VerifyIntegerConstantExpression - Verifies that an expression is an ICE,
/// and reports the appropriate diagnostics. Returns false on success.
/// Can optionally return the value of the expression.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyIntegerConstantExpression">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12634,
 FQN="clang::Sema::VerifyIntegerConstantExpression", NM="_ZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > VerifyIntegerConstantExpression(Expr /*P*/ E, APSInt /*P*/ Result, 
                               final VerifyICEDiagnoser /*&*/ Diagnoser) {
  return VerifyIntegerConstantExpression(E, Result, 
                               Diagnoser, 
                               true);
}
public final ActionResultTTrue<Expr /*P*/ > VerifyIntegerConstantExpression(Expr /*P*/ E, APSInt /*P*/ Result, 
                               final VerifyICEDiagnoser /*&*/ Diagnoser, 
                               boolean AllowFold/*= true*/) {
  Expr.EvalResult EvalResult = null;
  OptionalNotes Notes = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    SourceLocation DiagLoc = E.getLocStart();
    if ($this().getLangOpts().CPlusPlus11) {
      //<editor-fold defaultstate="collapsed" desc="CXX11ConvertDiagnoser">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12647,
       FQN="CXX11ConvertDiagnoser", NM="_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEbE21CXX11ConvertDiagnoser",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEbE21CXX11ConvertDiagnoser")
      //</editor-fold>
       class CXX11ConvertDiagnoser extends /*public*/ ICEConvertDiagnoser implements Destructors.ClassWithDestructor {
      /*public:*/
        //<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , VerifyICEDiagnoser & , bool)::CXX11ConvertDiagnoser::CXX11ConvertDiagnoser">
        @Converted(kind = Converted.Kind.AUTO,
         source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12649,
         FQN="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , VerifyICEDiagnoser & , bool)::CXX11ConvertDiagnoser::CXX11ConvertDiagnoser", NM="_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEbEN21CXX11ConvertDiagnoserC1Eb",
         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEbEN21CXX11ConvertDiagnoserC1Eb")
        //</editor-fold>
        public CXX11ConvertDiagnoser(boolean Silent) {
          // : ICEConvertDiagnoser(/*AllowScopedEnumerations*/ false, Silent, true) 
          //START JInit
          super(false, 
              Silent, true);
          //END JInit
        }


        //<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , VerifyICEDiagnoser & , bool)::CXX11ConvertDiagnoser::diagnoseNotInt">
        @Converted(kind = Converted.Kind.AUTO,
         source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12653,
         FQN="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , VerifyICEDiagnoser & , bool)::CXX11ConvertDiagnoser::diagnoseNotInt", NM="_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEbEN21CXX11ConvertDiagnoser14diagnoseNotIntERS0_NS_14SourceLocationENS_8QualTypeE",
         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEbEN21CXX11ConvertDiagnoser14diagnoseNotIntERS0_NS_14SourceLocationENS_8QualTypeE")
        //</editor-fold>
        @Override public SemaDiagnosticBuilder diagnoseNotInt(final Sema /*&*/ S, SourceLocation Loc, 
                      QualType T)/* override*/ {
          return $c$.clean(new SemaDiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_ice_not_integral)), T)));
        }


        //<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , VerifyICEDiagnoser & , bool)::CXX11ConvertDiagnoser::diagnoseIncomplete">
        @Converted(kind = Converted.Kind.AUTO,
         source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12658,
         FQN="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , VerifyICEDiagnoser & , bool)::CXX11ConvertDiagnoser::diagnoseIncomplete", NM="_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEbEN21CXX11ConvertDiagnoser18diagnoseIncompleteERS0_NS_14SourceLocationENS_8QualTypeE",
         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEbEN21CXX11ConvertDiagnoser18diagnoseIncompleteERS0_NS_14SourceLocationENS_8QualTypeE")
        //</editor-fold>
        @Override public SemaDiagnosticBuilder diagnoseIncomplete(final Sema /*&*/ S, SourceLocation Loc, QualType T)/* override*/ {
          return $c$.clean(new SemaDiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_ice_incomplete_type)), T)));
        }


        //<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , VerifyICEDiagnoser & , bool)::CXX11ConvertDiagnoser::diagnoseExplicitConv">
        @Converted(kind = Converted.Kind.AUTO,
         source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12663,
         FQN="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , VerifyICEDiagnoser & , bool)::CXX11ConvertDiagnoser::diagnoseExplicitConv", NM="_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEbEN21CXX11ConvertDiagnoser20diagnoseExplicitConvERS0_NS_14SourceLocationENS_8QualTypeESB_",
         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEbEN21CXX11ConvertDiagnoser20diagnoseExplicitConvERS0_NS_14SourceLocationENS_8QualTypeESB_")
        //</editor-fold>
        @Override public SemaDiagnosticBuilder diagnoseExplicitConv(final Sema /*&*/ S, SourceLocation Loc, QualType T, QualType ConvTy)/* override*/ {
          return $c$.clean(new SemaDiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_ice_explicit_conversion)), T), ConvTy)));
        }


        //<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , VerifyICEDiagnoser & , bool)::CXX11ConvertDiagnoser::noteExplicitConv">
        @Converted(kind = Converted.Kind.AUTO,
         source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12668,
         FQN="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , VerifyICEDiagnoser & , bool)::CXX11ConvertDiagnoser::noteExplicitConv", NM="_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEbEN21CXX11ConvertDiagnoser16noteExplicitConvERS0_PNS_17CXXConversionDeclENS_8QualTypeE",
         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEbEN21CXX11ConvertDiagnoser16noteExplicitConvERS0_PNS_17CXXConversionDeclENS_8QualTypeE")
        //</editor-fold>
        @Override public SemaDiagnosticBuilder noteExplicitConv(final Sema /*&*/ S, CXXConversionDecl /*P*/ Conv, QualType ConvTy)/* override*/ {
          return $c$.clean(new SemaDiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Conv.getLocation(), diag.note_ice_conversion_here)), 
                      ConvTy.$arrow().isEnumeralType()), ConvTy)));
        }


        //<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , VerifyICEDiagnoser & , bool)::CXX11ConvertDiagnoser::diagnoseAmbiguous">
        @Converted(kind = Converted.Kind.AUTO,
         source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12674,
         FQN="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , VerifyICEDiagnoser & , bool)::CXX11ConvertDiagnoser::diagnoseAmbiguous", NM="_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEbEN21CXX11ConvertDiagnoser17diagnoseAmbiguousERS0_NS_14SourceLocationENS_8QualTypeE",
         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEbEN21CXX11ConvertDiagnoser17diagnoseAmbiguousERS0_NS_14SourceLocationENS_8QualTypeE")
        //</editor-fold>
        @Override public SemaDiagnosticBuilder diagnoseAmbiguous(final Sema /*&*/ S, SourceLocation Loc, QualType T)/* override*/ {
          return $c$.clean(new SemaDiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_ice_ambiguous_conversion)), T)));
        }


        //<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , VerifyICEDiagnoser & , bool)::CXX11ConvertDiagnoser::noteAmbiguous">
        @Converted(kind = Converted.Kind.AUTO,
         source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12679,
         FQN="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , VerifyICEDiagnoser & , bool)::CXX11ConvertDiagnoser::noteAmbiguous", NM="_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEbEN21CXX11ConvertDiagnoser13noteAmbiguousERS0_PNS_17CXXConversionDeclENS_8QualTypeE",
         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEbEN21CXX11ConvertDiagnoser13noteAmbiguousERS0_PNS_17CXXConversionDeclENS_8QualTypeE")
        //</editor-fold>
        @Override public SemaDiagnosticBuilder noteAmbiguous(final Sema /*&*/ S, CXXConversionDecl /*P*/ Conv, QualType ConvTy)/* override*/ {
          return $c$.clean(new SemaDiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Conv.getLocation(), diag.note_ice_conversion_here)), 
                      ConvTy.$arrow().isEnumeralType()), ConvTy)));
        }


        //<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , VerifyICEDiagnoser & , bool)::CXX11ConvertDiagnoser::diagnoseConversion">
        @Converted(kind = Converted.Kind.AUTO,
         source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12685,
         FQN="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , VerifyICEDiagnoser & , bool)::CXX11ConvertDiagnoser::diagnoseConversion", NM="_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEbEN21CXX11ConvertDiagnoser18diagnoseConversionERS0_NS_14SourceLocationENS_8QualTypeESB_",
         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEbEN21CXX11ConvertDiagnoser18diagnoseConversionERS0_NS_14SourceLocationENS_8QualTypeESB_")
        //</editor-fold>
        @Override public SemaDiagnosticBuilder diagnoseConversion(final Sema /*&*/ S, SourceLocation Loc, QualType T, QualType ConvTy)/* override*/ {
          throw new llvm_unreachable("conversion functions are permitted");
        }

        //<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , VerifyICEDiagnoser & , bool)::CXX11ConvertDiagnoser::~CXX11ConvertDiagnoser">
        @Converted(kind = Converted.Kind.AUTO,
         source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12647,
         FQN="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , VerifyICEDiagnoser & , bool)::CXX11ConvertDiagnoser::~CXX11ConvertDiagnoser", NM="_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEbEN21CXX11ConvertDiagnoserD0Ev",
         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntERNS0_18VerifyICEDiagnoserEbEN21CXX11ConvertDiagnoserD0Ev")
        //</editor-fold>
        @Override public /*inline*/ void $destroy() {
          super.$destroy();
        }


        @Override public String toString() {
          return "" + super.toString(); // NOI18N
        }
      }
      CXX11ConvertDiagnoser ConvertDiagnoser = null;
      try {
        // C++11 [expr.const]p5:
        //   If an expression of literal class type is used in a context where an
        //   integral constant expression is required, then that class type shall
        //   have a single non-explicit conversion function to an integral or
        //   unscoped enumeration type
        ActionResultTTrue<Expr /*P*/ > _Converted/*J*/= new ActionResultTTrue<Expr /*P*/ >();
        ConvertDiagnoser/*J*/= new  CXX11ConvertDiagnoser(Diagnoser.Suppress);
        
        _Converted.$assignMove($this().PerformContextualImplicitConversion(new SourceLocation(DiagLoc), E, 
                ConvertDiagnoser));
        if (_Converted.isInvalid()) {
          return _Converted;
        }
        E = _Converted.get();
        if (!E.getType().$arrow().isIntegralOrUnscopedEnumerationType()) {
          return ExprError();
        }
      } finally {
        if (ConvertDiagnoser != null) { ConvertDiagnoser.$destroy(); }
      }
    } else if (!E.getType().$arrow().isIntegralOrUnscopedEnumerationType()) {
      // An ICE must be of integral or unscoped enumeration type.
      if (!Diagnoser.Suppress) {
        Diagnoser.diagnoseNotICE(/*Deref*/$this(), new SourceLocation(DiagLoc), E.getSourceRange());
      }
      return ExprError();
    }
    
    // Circumvent ICE checking in C++11 to avoid evaluating the expression twice
    // in the non-ICE case.
    if (!$this().getLangOpts().CPlusPlus11 && E.isIntegerConstantExpr($this().Context)) {
      if ((Result != null)) {
        /*Deref*/Result.$assignMove(E.EvaluateKnownConstInt($this().Context));
      }
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    EvalResult/*J*/= new Expr.EvalResult();
    Notes/*J*/= new OptionalNotes(8);
    EvalResult.Diag = $AddrOf(Notes);
    
    // Try to evaluate the expression, and produce diagnostics explaining why it's
    // not a constant expression as a side-effect.
    boolean Folded = E.EvaluateAsRValue(EvalResult, $this().Context)
       && EvalResult.Val.isInt() && !EvalResult.HasSideEffects;
    
    // In C++11, we can rely on diagnostics being produced for any expression
    // which is not a constant expression. If no diagnostics were produced, then
    // this is a constant expression.
    if (Folded && $this().getLangOpts().CPlusPlus11 && Notes.empty()) {
      if ((Result != null)) {
        /*Deref*/Result.$assign(EvalResult.Val.getInt());
      }
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    // If our only note is the usual "invalid subexpression" note, just point
    // the caret at its location rather than producing an essentially
    // redundant note.
    if (Notes.size() == 1 && Notes.$at(0).second.getDiagID()
       == diag.note_invalid_subexpr_in_const_expr) {
      DiagLoc.$assign(Notes.$at(0).first);
      Notes.clear();
    }
    if (!Folded || !AllowFold) {
      if (!Diagnoser.Suppress) {
        Diagnoser.diagnoseNotICE(/*Deref*/$this(), new SourceLocation(DiagLoc), E.getSourceRange());
        for (final /*const*/ std.pair<SourceLocation, PartialDiagnostic> /*&*/ Note : Notes)  {
          $c$.clean($c$.track($this().Diag(new SourceLocation(Note.first), Note.second)));
        }
      }
      
      return ExprError();
    }
    
    Diagnoser.diagnoseFold(/*Deref*/$this(), new SourceLocation(DiagLoc), E.getSourceRange());
    for (final /*const*/ std.pair<SourceLocation, PartialDiagnostic> /*&*/ Note : Notes)  {
      $c$.clean($c$.track($this().Diag(new SourceLocation(Note.first), Note.second)));
    }
    if ((Result != null)) {
      /*Deref*/Result.$assign(EvalResult.Val.getInt());
    }
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  } finally {
    if (Notes != null) { Notes.$destroy(); }
    if (EvalResult != null) { EvalResult.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyIntegerConstantExpression">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12610,
 FQN="clang::Sema::VerifyIntegerConstantExpression", NM="_ZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntEjb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > VerifyIntegerConstantExpression(Expr /*P*/ E, 
                               APSInt /*P*/ Result, 
                               /*uint*/int DiagID) {
  return VerifyIntegerConstantExpression(E, 
                               Result, 
                               DiagID, 
                               true);
}
public final ActionResultTTrue<Expr /*P*/ > VerifyIntegerConstantExpression(Expr /*P*/ E, 
                               APSInt /*P*/ Result, 
                               /*uint*/int DiagID, 
                               boolean AllowFold/*= true*/) {
  //<editor-fold defaultstate="collapsed" desc="IDDiagnoser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12614,
   FQN="IDDiagnoser", NM="_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntEjbE11IDDiagnoser",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntEjbE11IDDiagnoser")
  //</editor-fold>
   class IDDiagnoser extends /*public*/ VerifyICEDiagnoser implements Destructors.ClassWithDestructor {
    protected/*private*/ /*uint*/int DiagID;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , unsigned int, bool)::IDDiagnoser::IDDiagnoser">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12618,
     FQN="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , unsigned int, bool)::IDDiagnoser::IDDiagnoser", NM="_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntEjbEN11IDDiagnoserC1Ej",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntEjbEN11IDDiagnoserC1Ej")
    //</editor-fold>
    public IDDiagnoser(/*uint*/int DiagID) {
      // : VerifyICEDiagnoser(DiagID == 0), DiagID(DiagID) 
      //START JInit
      super(DiagID == 0);
      this.DiagID = DiagID;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , unsigned int, bool)::IDDiagnoser::diagnoseNotICE">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12621,
     FQN="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , unsigned int, bool)::IDDiagnoser::diagnoseNotICE", NM="_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntEjbEN11IDDiagnoser14diagnoseNotICEERS0_NS_14SourceLocationENS_11SourceRangeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntEjbEN11IDDiagnoser14diagnoseNotICEERS0_NS_14SourceLocationENS_11SourceRangeE")
    //</editor-fold>
    @Override public void diagnoseNotICE(final Sema /*&*/ S, SourceLocation Loc, SourceRange SR)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), DiagID)), SR));
      } finally {
        $c$.$destroy();
      }
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , unsigned int, bool)::IDDiagnoser::~IDDiagnoser">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12614,
     FQN="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * , unsigned int, bool)::IDDiagnoser::~IDDiagnoser", NM="_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntEjbEN11IDDiagnoserD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntEjbEN11IDDiagnoserD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      super.$destroy();
    }


    @Override public String toString() {
      return "" + "DiagID=" + DiagID // NOI18N
                + super.toString(); // NOI18N
    }
  }
  IDDiagnoser Diagnoser = null;
  try {
    Diagnoser/*J*/= new  IDDiagnoser(DiagID);
    
    return $this().VerifyIntegerConstantExpression(E, Result, Diagnoser, AllowFold);
  } finally {
    if (Diagnoser != null) { Diagnoser.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyIntegerConstantExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12598,
 FQN="clang::Sema::VerifyIntegerConstantExpression", NM="_ZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > VerifyIntegerConstantExpression(Expr /*P*/ E) {
  return VerifyIntegerConstantExpression(E, 
                               (APSInt /*P*/ )null);
}
public final ActionResultTTrue<Expr /*P*/ > VerifyIntegerConstantExpression(Expr /*P*/ E, 
                               APSInt /*P*/ Result/*= null*/) {
  //<editor-fold defaultstate="collapsed" desc="SimpleICEDiagnoser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12600,
   FQN="SimpleICEDiagnoser", NM="_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntEE18SimpleICEDiagnoser",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntEE18SimpleICEDiagnoser")
  //</editor-fold>
   class SimpleICEDiagnoser extends /*public*/ VerifyICEDiagnoser implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * )::SimpleICEDiagnoser::diagnoseNotICE">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12602,
     FQN="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * )::SimpleICEDiagnoser::diagnoseNotICE", NM="_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntEEN18SimpleICEDiagnoser14diagnoseNotICEERS0_NS_14SourceLocationENS_11SourceRangeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntEEN18SimpleICEDiagnoser14diagnoseNotICEERS0_NS_14SourceLocationENS_11SourceRangeE")
    //</editor-fold>
    @Override public void diagnoseNotICE(final Sema /*&*/ S, SourceLocation Loc, SourceRange SR)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_expr_not_ice)), S.LangOpts.CPlusPlus), SR));
      } finally {
        $c$.$destroy();
      }
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * )::SimpleICEDiagnoser::~SimpleICEDiagnoser">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12600,
     FQN="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * )::SimpleICEDiagnoser::~SimpleICEDiagnoser", NM="_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntEEN18SimpleICEDiagnoserD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntEEN18SimpleICEDiagnoserD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      super.$destroy();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * )::SimpleICEDiagnoser::SimpleICEDiagnoser">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12600,
     FQN="clang::Sema::VerifyIntegerConstantExpression(Expr * , APSInt * )::SimpleICEDiagnoser::SimpleICEDiagnoser", NM="_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntEEN18SimpleICEDiagnoserC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZZN5clang4Sema31VerifyIntegerConstantExpressionEPNS_4ExprEPN4llvm6APSIntEEN18SimpleICEDiagnoserC1Ev")
    //</editor-fold>
    public /*inline*/ SimpleICEDiagnoser() {
      // : VerifyICEDiagnoser() 
      //START JInit
      super();
      //END JInit
    }


    @Override public String toString() {
      return "" + super.toString(); // NOI18N
    }
  }
  SimpleICEDiagnoser Diagnoser = null;
  try {
    Diagnoser/*J*/= new  SimpleICEDiagnoser();
    
    return $this().VerifyIntegerConstantExpression(E, Result, Diagnoser);
  } finally {
    if (Diagnoser != null) { Diagnoser.$destroy(); }
  }
}

} // END OF class Sema_SemaExpr
