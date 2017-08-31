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
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.sema.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.java.SemaFunctionPointers.*;
import static org.clang.sema.java.SemaRTTI.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaExprStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=Tpl__ZL23handleIntegerConversionRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_8QualTypeES7_b;_SemaExpr_cpp_Unnamed_enum;_ZL14IsArithmeticOpN5clang18BinaryOperatorKindE;_ZL14captureInBlockPN5clang4sema14BlockScopeInfoEPNS_7VarDeclENS_14SourceLocationEbRNS_8QualTypeES7_bRNS_4SemaE;_ZL14checkBlockTypeRN5clang4SemaEPKNS_4ExprE;_ZL14checkConditionRN5clang4SemaEPNS_4ExprENS_14SourceLocationE;_ZL14getCompareDeclPN5clang4ExprE;_ZL14getPrimaryDeclPN5clang4ExprE;_ZL14getUDSuffixLocRN5clang4SemaENS_14SourceLocationEj;_ZL15CheckDeclInExprRN5clang4SemaENS_14SourceLocationEPNS_9NamedDeclE;_ZL15EvaluatesAsTrueRN5clang4SemaEPNS_4ExprE;_ZL15captureInLambdaPN5clang4sema15LambdaScopeInfoEPNS_7VarDeclENS_14SourceLocationEbRNS_8QualTypeES7_bNS_4Sema14TryCaptureKindES5_bRS8_;_ZL15getDeclFromExprPN5clang4ExprE;_ZL16CheckAlignOfExprRN5clang4SemaEPNS_4ExprE;_ZL16EvaluatesAsFalseRN5clang4SemaEPNS_4ExprE;_ZL16ExprLooksBooleanPN5clang4ExprE;_ZL16IsTypeModifiableN5clang8QualTypeEb;_ZL16hasIsEqualMethodRN5clang4SemaEPKNS_4ExprES4_;_ZL17IsReadonlyMessagePN5clang4ExprERNS_4SemaE;_ZL17checkVectorResultRN5clang4SemaENS_8QualTypeES2_NS_14SourceLocationE;_ZL18CheckCommaOperandsRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationE;_ZL18IgnoreCommaOperandPKN5clang4ExprE;_ZL18MarkExprReferencedRN5clang4SemaENS_14SourceLocationEPNS_4DeclEPNS_4ExprEb;_ZL18SuggestParenthesesRN5clang4SemaENS_14SourceLocationERKNS_17PartialDiagnosticENS_11SourceRangeE;_ZL19breakDownVectorTypeN5clang8QualTypeERyRS0_;_ZL19checkArithmeticNullRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationEb;_ZL19checkEnumComparisonRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_;_ZL19isObjCObjectLiteralRN5clang12ActionResultIPNS_4ExprELb1EEE;_ZL20BuildFloatingLiteralRN5clang4SemaERNS_20NumericLiteralParserENS_8QualTypeENS_14SourceLocationE;_ZL20BuildOverloadedBinOpRN5clang4SemaEPNS_5ScopeENS_14SourceLocationENS_18BinaryOperatorKindEPNS_4ExprES7_;_ZL20CheckRealImagOperandRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_14SourceLocationEb;_ZL20DiagnoseShiftCompareRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_;_ZL20DiagnoseUnusedOfDeclRN5clang4SemaEPNS_9NamedDeclENS_14SourceLocationE;_ZL20isVariableCapturablePN5clang4sema18CapturingScopeInfoEPNS_7VarDeclENS_14SourceLocationEbRNS_4SemaE;_ZL21diagnoseStringPlusIntRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_;_ZL21handleFloatConversionRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_8QualTypeES7_b;_ZL22DiagnoseBadShiftValuesRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationENS_18BinaryOperatorKindENS_8QualTypeE;_ZL22DiagnoseSelfAssignmentRN5clang4SemaEPNS_4ExprES3_NS_14SourceLocationE;_ZL22IsArithmeticBinaryExprPN5clang4ExprEPNS_18BinaryOperatorKindEPS1_;_ZL22checkOpenCLVectorShiftRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationEb;_ZL22diagnoseStringPlusCharRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_;_ZL22diagnoseUnknownAnyExprRN5clang4SemaEPNS_4ExprE;_ZL23CheckIndirectionOperandRN5clang4SemaEPNS_4ExprERNS_13ExprValueKindENS_14SourceLocationE;_ZL23ConvertUTF8ToWideStringjN4llvm9StringRefERNS_11SmallStringILj32EEE;_ZL23DiagnoseAdditionInShiftRN5clang4SemaENS_14SourceLocationEPNS_4ExprEN4llvm9StringRefE;_ZL23DiagnoseBinOpPrecedenceRN5clang4SemaENS_18BinaryOperatorKindENS_14SourceLocationEPNS_4ExprES5_;_ZL23DiagnoseConstAssignmentRN5clang4SemaEPKNS_4ExprENS_14SourceLocationE;_ZL23DiagnoseDirectIsaAccessRN5clang4SemaEPKNS_15ObjCIvarRefExprENS_14SourceLocationEPKNS_4ExprE;_ZL23DoMarkVarDeclReferencedRN5clang4SemaENS_14SourceLocationEPNS_7VarDeclEPNS_4ExprE;_ZL23addAsFieldToClosureTypeRN5clang4SemaEPNS_4sema15LambdaScopeInfoENS_8QualTypeES5_NS_14SourceLocationEb;_ZL23captureInCapturedRegionPN5clang4sema23CapturedRegionScopeInfoEPNS_7VarDeclENS_14SourceLocationEbRNS_8QualTypeES7_bRNS_4SemaE;_ZL23isQualifiedMemberAccessPN5clang4ExprE;_ZL23isScopedEnumerationTypeN5clang8QualTypeE;_ZL24CheckForModifiableLvaluePN5clang4ExprENS_14SourceLocationERNS_4SemaE;_ZL24TryTypoCorrectionForCallRN5clang4SemaEPNS_4ExprEPNS_12FunctionDeclEN4llvm8ArrayRefIS3_EE;_ZL24checkArgsForPlaceholdersRN5clang4SemaEN4llvm15MutableArrayRefIPNS_4ExprEEE;_ZL24checkConditionalVoidTypeRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_;_ZL24tryVectorConvertAndSplatRN5clang4SemaEPNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeES7_S7_;_ZL24warnOnSizeofOnArrayDecayRN5clang4SemaENS_14SourceLocationENS_8QualTypeEPNS_4ExprE;_ZL25ConstructTransparentUnionRN5clang4SemaERNS_10ASTContextERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeEPNS_9FieldDeclE;_ZL25DiagnoseBitwisePrecedenceRN5clang4SemaENS_18BinaryOperatorKindENS_14SourceLocationEPNS_4ExprES5_;_ZL25isMSPropertySubscriptExprRN5clang4SemaEPNS_4ExprE;_ZL25rebuildUnknownAnyFunctionRN5clang4SemaEPNS_4ExprE;_ZL25unsupportedTypeConversionRKN5clang4SemaENS_8QualTypeES3_;_ZL26DiagnoseAvailabilityOfDeclRN5clang4SemaEPNS_9NamedDeclENS_14SourceLocationEPKNS_17ObjCInterfaceDeclEb;_ZL26checkOpenCLConditionVectorRN5clang4SemaEPNS_4ExprENS_14SourceLocationE;_ZL26handleComplexIntConversionRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_8QualTypeES7_b;_ZL26handleIntToFloatConversionRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_8QualTypeES7_bb;_ZL26hasAnyExplicitStorageClassPKN5clang12FunctionDeclE;_ZL26isNumberOfArgsValidForCallRN5clang4SemaEPKNS_12FunctionDeclEj;_ZL26isPlaceholderToRemoveAsArgN5clang8QualTypeE;_ZL26rewriteBuiltinFunctionDeclPN5clang4SemaERNS_10ASTContextEPKNS_12FunctionDeclEN4llvm15MutableArrayRefIPNS_4ExprEEE;_ZL27OpenCLArithmeticConversionsRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationE;_ZL27captureVariablyModifiedTypeRN5clang10ASTContextENS_8QualTypeEPNS_4sema18CapturingScopeInfoE;_ZL27checkConditionalNullPointerRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeE;_ZL27checkPointerIntegerMismatchRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES4_NS_14SourceLocationEb;_ZL28CheckIdentityFieldAssignmentPN5clang4ExprES1_NS_14SourceLocationERNS_4SemaE;_ZL28CheckVecStepTraitOperandTypeRN5clang4SemaENS_8QualTypeENS_14SourceLocationENS_11SourceRangeE;_ZL28DiagnoseBitwiseOpInBitwiseOpRN5clang4SemaENS_18BinaryOperatorKindENS_14SourceLocationEPNS_4ExprE;_ZL28OpenCLCheckVectorConditionalRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_S6_NS_14SourceLocationE;_ZL28RecordModifiableNonNullParamRN5clang4SemaEPKNS_4ExprE;_ZL28checkArithmeticOnObjCPointerRN5clang4SemaENS_14SourceLocationEPNS_4ExprE;_ZL28diagnoseAddressOfInvalidTypeRN5clang4SemaENS_14SourceLocationEPNS_4ExprEj;_ZL28handleComplexFloatConversionRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_8QualTypeES7_b;_ZL28isReferenceToNonConstCaptureRN5clang4SemaEPNS_4ExprE;_ZL28maybeRebuildARCConsumingStmtPN5clang4StmtE;_ZL29ConvertTokenKindToUnaryOpcodeN5clang3tok9TokenKindE;_ZL29DiagnoseConditionalPrecedenceRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_S4_;_ZL29IsPotentiallyEvaluatedContextRN5clang4SemaE;_ZL29OpenCLConvertScalarsToVectorsRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_8QualTypeENS_14SourceLocationE;_ZL29checkObjCPointerIntrospectionRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationE;_ZL29diagnoseObjCLiteralComparisonRN5clang4SemaENS_14SourceLocationERNS_12ActionResultIPNS_4ExprELb1EEES7_NS_18BinaryOperatorKindE;_ZL29emitEmptyLookupTypoDiagnosticRKN5clang14TypoCorrectionERNS_4SemaERKNS_12CXXScopeSpecENS_15DeclarationNameENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEEjj;_ZL30BuildCookedLiteralOperatorCallRN5clang4SemaEPNS_5ScopeEPNS_14IdentifierInfoENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEES6_;_ZL30CheckExtensionTraitOperandTypeRN5clang4SemaENS_8QualTypeENS_14SourceLocationENS_11SourceRangeENS_20UnaryExprOrTypeTraitE;_ZL30CheckForNullPointerDereferenceRN5clang4SemaEPNS_4ExprE;_ZL30CheckIncrementDecrementOperandRN5clang4SemaEPNS_4ExprERNS_13ExprValueKindERNS_14ExprObjectKindENS_14SourceLocationEbb;_ZL30DiagnoseCalleeStaticArrayParamRN5clang4SemaEPNS_11ParmVarDeclE;_ZL30IsWithinTemplateSpecializationPN5clang4DeclE;_ZL30checkPointerTypesForAssignmentRN5clang4SemaENS_8QualTypeES2_;_ZL30convertPointersToCompositeTypeRN5clang4SemaENS_14SourceLocationERNS_12ActionResultIPNS_4ExprELb1EEES7_;_ZL30diagnosePointerIncompatibilityRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_;_ZL30recoverFromMSUnqualifiedLookupRN5clang4SemaERNS_10ASTContextERNS_19DeclarationNameInfoENS_14SourceLocationEPKNS_24TemplateArgumentListInfoE;_ZL31checkArithmeticOpPointerOperandRN5clang4SemaENS_14SourceLocationEPNS_4ExprE;_ZL31diagnoseArithmeticOnVoidPointerRN5clang4SemaENS_14SourceLocationEPNS_4ExprE;_ZL32CheckObjCTraitOperandConstraintsRN5clang4SemaENS_8QualTypeENS_14SourceLocationENS_11SourceRangeENS_20UnaryExprOrTypeTraitE;_ZL32DiagnoseLogicalAndInLogicalOrLHSRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_;_ZL32DiagnoseLogicalAndInLogicalOrRHSRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_;_ZL33diagnoseDistinctPointerComparisonRN5clang4SemaENS_14SourceLocationERNS_12ActionResultIPNS_4ExprELb1EEES7_b;_ZL33getParentOfCapturingContextOrNullPN5clang11DeclContextEPNS_7VarDeclENS_14SourceLocationEbRNS_4SemaE;_ZL33maybeDiagnoseAssignmentToFunctionRN5clang4SemaENS_8QualTypeEPKNS_4ExprE;_ZL34DiagnoseBadDivideOrRemainderValuesRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationEb;_ZL34checkObjCPointerTypesForAssignmentRN5clang4SemaENS_8QualTypeES2_;_ZL34diagnoseUncapturableValueReferenceRN5clang4SemaENS_14SourceLocationEPNS_7VarDeclEPNS_11DeclContextE;_ZL35checkArithmeticBinOpPointerOperandsRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_;_ZL35checkBlockPointerTypesForAssignmentRN5clang4SemaENS_8QualTypeES2_;_ZL35diagnoseArithmeticOnFunctionPointerRN5clang4SemaENS_14SourceLocationEPNS_4ExprE;_ZL35diagnoseArithmeticOnTwoVoidPointersRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_;_ZL35diagnoseLogicalNotOnLHSofComparisonRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationENS_18BinaryOperatorKindE;_ZL36checkArithmeticIncompletePointerTypeRN5clang4SemaENS_14SourceLocationEPNS_4ExprE;_ZL36checkConditionalPointerCompatibilityRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationE;_ZL36isVariableAlreadyCapturedInScopeInfoPN5clang4sema18CapturingScopeInfoEPNS_7VarDeclERbRNS_8QualTypeES7_;_ZL37handleIntegerToComplexFloatConversionRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_8QualTypeES7_b;_ZL38EmitDiagnosticForLogicalAndInLogicalOrRN5clang4SemaENS_14SourceLocationEPNS_14BinaryOperatorE;_ZL39diagnoseArithmeticOnTwoFunctionPointersRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_;_ZL39diagnoseFunctionPointerToVoidComparisonRN5clang4SemaENS_14SourceLocationERNS_12ActionResultIPNS_4ExprELb1EEES7_b;_ZL41checkConditionalBlockPointerCompatibilityRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationE;_ZL41diagnoseUseOfInternalDeclInInlineFunctionRN5clang4SemaEPKNS_9NamedDeclENS_14SourceLocationE;_ZL43checkConditionalObjectPointersCompatibilityRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationE;_ZL44IsVariableNonDependentAndAConstantExpressionPN5clang7VarDeclERNS_10ASTContextE;_ZL45HasRedeclarationWithoutAvailabilityInCategoryPKN5clang4DeclE;_ZN12_GLOBAL__N_114doIntegralCastERN5clang4SemaEPNS0_4ExprENS0_8QualTypeE;_ZN12_GLOBAL__N_121doComplexIntegralCastERN5clang4SemaEPNS0_4ExprENS0_8QualTypeE; -static-type=SemaExprStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaExprStatics {

//<editor-fold defaultstate="collapsed" desc="DiagnoseUnusedOfDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 77,
 FQN="DiagnoseUnusedOfDecl", NM="_ZL20DiagnoseUnusedOfDeclRN5clang4SemaEPNS_9NamedDeclENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL20DiagnoseUnusedOfDeclRN5clang4SemaEPNS_9NamedDeclENS_14SourceLocationE")
//</editor-fold>
public static void DiagnoseUnusedOfDecl(final Sema /*&*/ S, NamedDecl /*P*/ D, SourceLocation Loc) {
  {
    // Warn if this is used but marked unused.
    /*const*/ UnusedAttr /*P*/ A = D.getAttr(UnusedAttr.class);
    if ((A != null)) {
      // [[maybe_unused]] should not diagnose uses, but __attribute__((unused))
      // should diagnose them.
      if (A.getSemanticSpelling() != UnusedAttr.Spelling.CXX11_maybe_unused) {
        /*const*/ Decl /*P*/ DC = cast_or_null_Decl(S.getCurObjCLexicalContext());
        if ((DC != null) && !DC.hasAttr(UnusedAttr.class)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.warn_used_but_marked_unused)), D.getDeclName()));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="HasRedeclarationWithoutAvailabilityInCategory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 90,
 FQN="HasRedeclarationWithoutAvailabilityInCategory", NM="_ZL45HasRedeclarationWithoutAvailabilityInCategoryPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL45HasRedeclarationWithoutAvailabilityInCategoryPKN5clang4DeclE")
//</editor-fold>
public static boolean HasRedeclarationWithoutAvailabilityInCategory(/*const*/ Decl /*P*/ D) {
  /*const*/ ObjCMethodDecl /*P*/ OMD = dyn_cast_ObjCMethodDecl(D);
  if (!(OMD != null)) {
    return false;
  }
  /*const*/ ObjCInterfaceDecl /*P*/ OID = OMD.getClassInterface$Const();
  if (!(OID != null)) {
    return false;
  }
  
  for (/*const*/ ObjCCategoryDecl /*P*/ Cat : OID.visible_categories())  {
    {
      ObjCMethodDecl /*P*/ CatMeth = Cat.getMethod(OMD.getSelector(), OMD.isInstanceMethod());
      if ((CatMeth != null)) {
        if (!CatMeth.hasAttr(AvailabilityAttr.class)) {
          return true;
        }
      }
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="DiagnoseAvailabilityOfDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 106,
 FQN="DiagnoseAvailabilityOfDecl", NM="_ZL26DiagnoseAvailabilityOfDeclRN5clang4SemaEPNS_9NamedDeclENS_14SourceLocationEPKNS_17ObjCInterfaceDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL26DiagnoseAvailabilityOfDeclRN5clang4SemaEPNS_9NamedDeclENS_14SourceLocationEPKNS_17ObjCInterfaceDeclEb")
//</editor-fold>
public static AvailabilityResult DiagnoseAvailabilityOfDecl(final Sema /*&*/ S, NamedDecl /*P*/ D, SourceLocation Loc, 
                          /*const*/ ObjCInterfaceDecl /*P*/ UnknownObjCClass, 
                          boolean ObjCPropertyAccess) {
  // See if this declaration is unavailable or deprecated.
  std.string Message/*J*/= new std.string();
  AvailabilityResult Result = D.getAvailability($AddrOf(Message));
  {
    
    // For typedefs, if the typedef declaration appears available look
    // to the underlying type to see if it is more restrictive.
    /*const*/ TypedefNameDecl /*P*/ TD;
    while (((/*P*/ TD = dyn_cast_TypedefNameDecl(D)) != null)) {
      if (Result == AvailabilityResult.AR_Available) {
        {
          /*const*/ TagType /*P*/ TT = TD.getUnderlyingType().$arrow().getAs(TagType.class);
          if ((TT != null)) {
            D = TT.getDecl();
            Result = D.getAvailability($AddrOf(Message));
            continue;
          }
        }
      }
      break;
    }
  }
  {
    
    // Forward class declarations get their attributes from their definition.
    ObjCInterfaceDecl /*P*/ IDecl = dyn_cast_ObjCInterfaceDecl(D);
    if ((IDecl != null)) {
      if ((IDecl.getDefinition() != null)) {
        D = IDecl.getDefinition();
        Result = D.getAvailability($AddrOf(Message));
      }
    }
  }
  {
    
    /*const*/ EnumConstantDecl /*P*/ ECD = dyn_cast_EnumConstantDecl(D);
    if ((ECD != null)) {
      if (Result == AvailabilityResult.AR_Available) {
        /*const*/ DeclContext /*P*/ DC = ECD.getDeclContext$Const();
        {
          /*const*/ EnumDecl /*P*/ TheEnumDecl = dyn_cast_EnumDecl(DC);
          if ((TheEnumDecl != null)) {
            Result = TheEnumDecl.getAvailability($AddrOf(Message));
          }
        }
      }
    }
  }
  
  /*const*/ ObjCPropertyDecl /*P*/ ObjCPDecl = null;
  if (Result == AvailabilityResult.AR_Deprecated || Result == AvailabilityResult.AR_Unavailable
     || Result == AvailabilityResult.AR_NotYetIntroduced) {
    {
      /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(D);
      if ((MD != null)) {
        {
          /*const*/ ObjCPropertyDecl /*P*/ PD = MD.findPropertyDecl();
          if ((PD != null)) {
            AvailabilityResult PDeclResult = PD.getAvailability((std.string/*P*/ )null);
            if (PDeclResult == Result) {
              ObjCPDecl = PD;
            }
          }
        }
      }
    }
  }
  switch (Result) {
   case AR_Available:
    break;
   case AR_Deprecated:
    if (S.getCurContextAvailability() != AvailabilityResult.AR_Deprecated) {
      S.EmitAvailabilityWarning(Sema.AvailabilityDiagnostic.AD_Deprecation, 
          D, new StringRef(Message), new SourceLocation(Loc), UnknownObjCClass, ObjCPDecl, 
          ObjCPropertyAccess);
    }
    break;
   case AR_NotYetIntroduced:
    {
      // Don't do this for enums, they can't be redeclared.
      if (isa_EnumConstantDecl(D) || isa_EnumDecl(D)) {
        break;
      }
      
      boolean Warn = !D.getAttr(AvailabilityAttr.class).isInherited();
      // Objective-C method declarations in categories are not modelled as
      // redeclarations, so manually look for a redeclaration in a category
      // if necessary.
      if (Warn && HasRedeclarationWithoutAvailabilityInCategory(D)) {
        Warn = false;
      }
      // In general, D will point to the most recent redeclaration. However,
      // for `@class A;` decls, this isn't true -- manually go through the
      // redecl chain in that case.
      if (Warn && isa_ObjCInterfaceDecl(D)) {
        for (Decl /*P*/ Redecl = D.getMostRecentDecl(); (Redecl != null) && Warn;
             Redecl = Redecl.getPreviousDecl())  {
          if (!Redecl.hasAttr(AvailabilityAttr.class)
             || Redecl.getAttr(AvailabilityAttr.class).isInherited()) {
            Warn = false;
          }
        }
      }
      if (Warn) {
        S.EmitAvailabilityWarning(Sema.AvailabilityDiagnostic.AD_Partial, D, new StringRef(Message), new SourceLocation(Loc), 
            UnknownObjCClass, ObjCPDecl, 
            ObjCPropertyAccess);
      }
      break;
    }
   case AR_Unavailable:
    if (S.getCurContextAvailability() != AvailabilityResult.AR_Unavailable) {
      S.EmitAvailabilityWarning(Sema.AvailabilityDiagnostic.AD_Unavailable, 
          D, new StringRef(Message), new SourceLocation(Loc), UnknownObjCClass, ObjCPDecl, 
          ObjCPropertyAccess);
    }
    break;
  }
  return Result;
}


/// \brief Determine whether a FunctionDecl was ever declared with an
/// explicit storage class.
//<editor-fold defaultstate="collapsed" desc="hasAnyExplicitStorageClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 234,
 FQN="hasAnyExplicitStorageClass", NM="_ZL26hasAnyExplicitStorageClassPKN5clang12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL26hasAnyExplicitStorageClassPKN5clang12FunctionDeclE")
//</editor-fold>
public static boolean hasAnyExplicitStorageClass(/*const*/ FunctionDecl /*P*/ D) {
  for (FunctionDecl /*P*/ I : D.redeclarable_redecls()) {
    if (I.getStorageClass() != StorageClass.SC_None) {
      return true;
    }
  }
  return false;
}


/// \brief Check whether we're in an extern inline function and referring to a
/// variable or function with internal linkage (C11 6.7.4p3).
///
/// This is only a warning because we used to silently accept this code, but
/// in many cases it will not behave correctly. This is not enabled in C++ mode
/// because the restriction language is a bit weaker (C++11 [basic.def.odr]p6)
/// and so while there may still be user mistakes, most of the time we can't
/// prove that there are errors.
//<editor-fold defaultstate="collapsed" desc="diagnoseUseOfInternalDeclInInlineFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 250,
 FQN="diagnoseUseOfInternalDeclInInlineFunction", NM="_ZL41diagnoseUseOfInternalDeclInInlineFunctionRN5clang4SemaEPKNS_9NamedDeclENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL41diagnoseUseOfInternalDeclInInlineFunctionRN5clang4SemaEPKNS_9NamedDeclENS_14SourceLocationE")
//</editor-fold>
public static void diagnoseUseOfInternalDeclInInlineFunction(final Sema /*&*/ S, 
                                         /*const*/ NamedDecl /*P*/ D, 
                                         SourceLocation Loc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // This is disabled under C++; there are too many ways for this to fire in
    // contexts where the warning is a false positive, or where it is technically
    // correct but benign.
    if (S.getLangOpts().CPlusPlus) {
      return;
    }
    
    // Check if this is an inlined function or method.
    FunctionDecl /*P*/ Current = S.getCurFunctionDecl();
    if (!(Current != null)) {
      return;
    }
    if (!Current.isInlined()) {
      return;
    }
    if (!Current.isExternallyVisible()) {
      return;
    }
    
    // Check if the decl has internal linkage.
    if (D.getFormalLinkage() != Linkage.InternalLinkage) {
      return;
    }
    
    // Downgrade from ExtWarn to Extension if
    //  (1) the supposedly external inline function is in the main file,
    //      and probably won't be included anywhere else.
    //  (2) the thing we're referencing is a pure function.
    //  (3) the thing we're referencing is another inline function.
    // This last can give us false negatives, but it's better than warning on
    // wrappers for simple C library functions.
    /*const*/ FunctionDecl /*P*/ UsedFn = dyn_cast_FunctionDecl(D);
    boolean DowngradeWarning = S.getSourceManager().isInMainFile(/*NO_COPY*/Loc);
    if (!DowngradeWarning && (UsedFn != null)) {
      DowngradeWarning = UsedFn.isInlined() || UsedFn.hasAttr(ConstAttr.class);
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), DowngradeWarning ? diag.ext_internal_in_extern_inline_quiet : diag.ext_internal_in_extern_inline)), 
            /*IsVar=*/ !(UsedFn != null)), D));
    
    S.MaybeSuggestAddingStaticToDecl(Current);
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getCanonicalDecl$Const().getLocation(), diag.note_entity_declared_at)), 
        D));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="CheckForNullPointerDereference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 555,
 FQN="CheckForNullPointerDereference", NM="_ZL30CheckForNullPointerDereferenceRN5clang4SemaEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL30CheckForNullPointerDereferenceRN5clang4SemaEPNS_4ExprE")
//</editor-fold>
public static void CheckForNullPointerDereference(final Sema /*&*/ S, Expr /*P*/ E) {
  {
    // Check to see if we are dereferencing a null pointer.  If so,
    // and if not volatile-qualified, this is undefined behavior that the
    // optimizer will delete, so warn about it.  People sometimes try to use this
    // to get a deterministic trap and are surprised by clang's behavior.  This
    // only handles the pattern "*null", which is a very syntactic check.
    UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(E.IgnoreParenCasts());
    if ((UO != null)) {
      if (UO.getOpcode() == UnaryOperatorKind.UO_Deref
         && (UO.getSubExpr().IgnoreParenCasts().
          isNullPointerConstant(S.Context, Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNotNull).getValue() != 0)
         && !UO.getType().isVolatileQualified()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(S.DiagRuntimeBehavior(UO.getOperatorLoc(), UO, 
              $out_PartialDiagnostic$C_SourceRange($c$.track(S.PDiag(diag.warn_indirection_through_null)), 
                  UO.getSubExpr().getSourceRange())));
          $c$.clean(S.DiagRuntimeBehavior(UO.getOperatorLoc(), UO, 
              $c$.track(S.PDiag(diag.note_indirection_through_null))));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="DiagnoseDirectIsaAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 574,
 FQN="DiagnoseDirectIsaAccess", NM="_ZL23DiagnoseDirectIsaAccessRN5clang4SemaEPKNS_15ObjCIvarRefExprENS_14SourceLocationEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL23DiagnoseDirectIsaAccessRN5clang4SemaEPKNS_15ObjCIvarRefExprENS_14SourceLocationEPKNS_4ExprE")
//</editor-fold>
public static void DiagnoseDirectIsaAccess(final Sema /*&*/ S, /*const*/ ObjCIvarRefExpr /*P*/ OIRE, 
                       SourceLocation AssignLoc, 
                       /*const*/ Expr /*P*/ RHS) {
  /*const*/ ObjCIvarDecl /*P*/ IV = OIRE.getDecl$Const();
  if (!(IV != null)) {
    return;
  }
  
  DeclarationName MemberName = IV.getDeclName();
  IdentifierInfo /*P*/ Member = MemberName.getAsIdentifierInfo();
  if (!(Member != null) || !Member.isStr(/*KEEP_STR*/"isa")) {
    return;
  }
  
  /*const*/ Expr /*P*/ Base = OIRE.getBase$Const();
  QualType BaseType = Base.getType();
  if (OIRE.isArrow()) {
    BaseType.$assignMove(BaseType.$arrow().getPointeeType());
  }
  {
    /*const*/ ObjCObjectType /*P*/ OTy = BaseType.$arrow().getAs(ObjCObjectType.class);
    if ((OTy != null)) {
      {
        ObjCInterfaceDecl /*P*/ IDecl = OTy.getInterface();
        if ((IDecl != null)) {
          type$ref<ObjCInterfaceDecl /*P*/ > ClassDeclared = create_type$null$ref(null);
          ObjCIvarDecl /*P*/ IV$1 = IDecl.lookupInstanceVariable(Member, ClassDeclared);
          if (!(ClassDeclared.$deref().getSuperClass() != null)
             && (ClassDeclared.$deref().ivar_begin().$star()) == IV$1) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              if ((RHS != null)) {
                NamedDecl /*P*/ ObjectSetClass = S.LookupSingleName(S.TUScope, 
                    new DeclarationName($AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"object_setClass")))), 
                    new SourceLocation(), Sema.LookupNameKind.LookupOrdinaryName);
                if ((ObjectSetClass != null)) {
                  SourceLocation RHSLocEnd = S.getLocForEndOfToken(RHS.getLocEnd());
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(OIRE.getExprLoc(), diag.warn_objc_isa_assign)), 
                              FixItHint.CreateInsertion(OIRE.getLocStart(), new StringRef(/*KEEP_STR*/"object_setClass("))), 
                          FixItHint.CreateReplacement(new SourceRange(OIRE.getOpLoc(), 
                                  /*NO_COPY*/AssignLoc), new StringRef(/*KEEP_STR*/$COMMA))), 
                      FixItHint.CreateInsertion(/*NO_COPY*/RHSLocEnd, new StringRef(/*KEEP_STR*/$RPAREN))));
                } else {
                  $c$.clean($c$.track(S.Diag(OIRE.getLocation(), diag.warn_objc_isa_assign)));
                }
              } else {
                NamedDecl /*P*/ ObjectGetClass = S.LookupSingleName(S.TUScope, 
                    new DeclarationName($AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"object_getClass")))), 
                    new SourceLocation(), Sema.LookupNameKind.LookupOrdinaryName);
                if ((ObjectGetClass != null)) {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(OIRE.getExprLoc(), diag.warn_objc_isa_use)), 
                          FixItHint.CreateInsertion(OIRE.getLocStart(), new StringRef(/*KEEP_STR*/"object_getClass("))), 
                      FixItHint.CreateReplacement(new SourceRange(OIRE.getOpLoc(), 
                              OIRE.getLocEnd()), new StringRef(/*KEEP_STR*/$RPAREN))));
                } else {
                  $c$.clean($c$.track(S.Diag(OIRE.getLocation(), diag.warn_objc_isa_use)));
                }
              }
              $c$.clean($c$.track(S.Diag(IV$1.getLocation(), diag.note_ivar_decl)));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
  }
}


/// \brief Converts an integer to complex float type.  Helper function of
/// UsualArithmeticConversions()
///
/// \return false if the integer expression is an integer type and is
/// successfully converted to the complex type.
//<editor-fold defaultstate="collapsed" desc="handleIntegerToComplexFloatConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 1008,
 FQN="handleIntegerToComplexFloatConversion", NM="_ZL37handleIntegerToComplexFloatConversionRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_8QualTypeES7_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL37handleIntegerToComplexFloatConversionRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_8QualTypeES7_b")
//</editor-fold>
public static boolean handleIntegerToComplexFloatConversion(final Sema /*&*/ S, final ActionResultTTrue<Expr /*P*/ > /*&*/ IntExpr, 
                                     final ActionResultTTrue<Expr /*P*/ > /*&*/ ComplexExpr, 
                                     QualType IntTy, 
                                     QualType ComplexTy, 
                                     boolean SkipCast) {
  if (IntTy.$arrow().isComplexType() || IntTy.$arrow().isRealFloatingType()) {
    return true;
  }
  if (SkipCast) {
    return false;
  }
  if (IntTy.$arrow().isIntegerType()) {
    QualType fpTy = cast_ComplexType(ComplexTy).getElementType();
    IntExpr.$assignMove(S.ImpCastExprToType(IntExpr.get(), new QualType(fpTy), CastKind.CK_IntegralToFloating));
    IntExpr.$assignMove(S.ImpCastExprToType(IntExpr.get(), new QualType(ComplexTy), 
            CastKind.CK_FloatingRealToComplex));
  } else {
    assert (IntTy.$arrow().isComplexIntegerType());
    IntExpr.$assignMove(S.ImpCastExprToType(IntExpr.get(), new QualType(ComplexTy), 
            CastKind.CK_IntegralComplexToFloatingComplex));
  }
  return false;
}


/// \brief Handle arithmetic conversion with complex types.  Helper function of
/// UsualArithmeticConversions()
//<editor-fold defaultstate="collapsed" desc="handleComplexFloatConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 1030,
 FQN="handleComplexFloatConversion", NM="_ZL28handleComplexFloatConversionRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_8QualTypeES7_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL28handleComplexFloatConversionRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_8QualTypeES7_b")
//</editor-fold>
public static QualType handleComplexFloatConversion(final Sema /*&*/ S, final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, 
                            final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, QualType LHSType, 
                            QualType RHSType, 
                            boolean IsCompAssign) {
  // if we have an integer operand, the result is the complex type.
  if (!handleIntegerToComplexFloatConversion(S, RHS, LHS, new QualType(RHSType), new QualType(LHSType), 
      /*skipCast*/ false)) {
    return new QualType(JD$Move.INSTANCE, LHSType);
  }
  if (!handleIntegerToComplexFloatConversion(S, LHS, RHS, new QualType(LHSType), new QualType(RHSType), 
      /*skipCast*/ IsCompAssign)) {
    return new QualType(JD$Move.INSTANCE, RHSType);
  }
  
  // This handles complex/complex, complex/float, or float/complex.
  // When both operands are complex, the shorter operand is converted to the
  // type of the longer, and that is the type of the result. This corresponds
  // to what is done when combining two real floating-point operands.
  // The fun begins when size promotion occur across type domains.
  // From H&S 6.3.4: When one operand is complex and the other is a real
  // floating-point type, the less precise type is converted, within it's
  // real or complex domain, to the precision of the other type. For example,
  // when combining a "long double" with a "double _Complex", the
  // "double _Complex" is promoted to "long double _Complex".
  
  // Compute the rank of the two types, regardless of whether they are complex.
  int Order = S.Context.getFloatingTypeOrder(new QualType(LHSType), new QualType(RHSType));
  
  /*const*/ ComplexType /*P*/ LHSComplexType = dyn_cast_ComplexType(LHSType);
  /*const*/ ComplexType /*P*/ RHSComplexType = dyn_cast_ComplexType(RHSType);
  QualType LHSElementType = (LHSComplexType != null) ? LHSComplexType.getElementType() : new QualType(LHSType);
  QualType RHSElementType = (RHSComplexType != null) ? RHSComplexType.getElementType() : new QualType(RHSType);
  
  QualType ResultType = S.Context.getComplexType(new QualType(LHSElementType));
  if (Order < 0) {
    // Promote the precision of the LHS if not an assignment.
    ResultType.$assignMove(S.Context.getComplexType(new QualType(RHSElementType)));
    if (!IsCompAssign) {
      if ((LHSComplexType != null)) {
        LHS.$assignMove(
            S.ImpCastExprToType(LHS.get(), new QualType(ResultType), CastKind.CK_FloatingComplexCast)
        );
      } else {
        LHS.$assignMove(S.ImpCastExprToType(LHS.get(), new QualType(RHSElementType), CastKind.CK_FloatingCast));
      }
    }
  } else if (Order > 0) {
    // Promote the precision of the RHS.
    if ((RHSComplexType != null)) {
      RHS.$assignMove(S.ImpCastExprToType(RHS.get(), new QualType(ResultType), CastKind.CK_FloatingComplexCast));
    } else {
      RHS.$assignMove(S.ImpCastExprToType(RHS.get(), new QualType(LHSElementType), CastKind.CK_FloatingCast));
    }
  }
  return ResultType;
}


/// \brief Hande arithmetic conversion from integer to float.  Helper function
/// of UsualArithmeticConversions()
//<editor-fold defaultstate="collapsed" desc="handleIntToFloatConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 1086,
 FQN="handleIntToFloatConversion", NM="_ZL26handleIntToFloatConversionRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_8QualTypeES7_bb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL26handleIntToFloatConversionRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_8QualTypeES7_bb")
//</editor-fold>
public static QualType handleIntToFloatConversion(final Sema /*&*/ S, final ActionResultTTrue<Expr /*P*/ > /*&*/ FloatExpr, 
                          final ActionResultTTrue<Expr /*P*/ > /*&*/ IntExpr, 
                          QualType FloatTy, QualType IntTy, 
                          boolean ConvertFloat, boolean ConvertInt) {
  if (IntTy.$arrow().isIntegerType()) {
    if (ConvertInt) {
      // Convert intExpr to the lhs floating point type.
      IntExpr.$assignMove(S.ImpCastExprToType(IntExpr.get(), new QualType(FloatTy), 
              CastKind.CK_IntegralToFloating));
    }
    return new QualType(JD$Move.INSTANCE, FloatTy);
  }
  
  // Convert both sides to the appropriate complex float.
  assert (IntTy.$arrow().isComplexIntegerType());
  QualType result = S.Context.getComplexType(new QualType(FloatTy));
  
  // _Complex int -> _Complex float
  if (ConvertInt) {
    IntExpr.$assignMove(S.ImpCastExprToType(IntExpr.get(), new QualType(result), 
            CastKind.CK_IntegralComplexToFloatingComplex));
  }
  
  // float -> _Complex float
  if (ConvertFloat) {
    FloatExpr.$assignMove(S.ImpCastExprToType(FloatExpr.get(), new QualType(result), 
            CastKind.CK_FloatingRealToComplex));
  }
  
  return result;
}


/// \brief Handle arithmethic conversion with floating point types.  Helper
/// function of UsualArithmeticConversions()
//<editor-fold defaultstate="collapsed" desc="handleFloatConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 1117,
 FQN="handleFloatConversion", NM="_ZL21handleFloatConversionRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_8QualTypeES7_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL21handleFloatConversionRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_8QualTypeES7_b")
//</editor-fold>
public static QualType handleFloatConversion(final Sema /*&*/ S, final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, 
                     final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, QualType LHSType, 
                     QualType RHSType, boolean IsCompAssign) {
  boolean LHSFloat = LHSType.$arrow().isRealFloatingType();
  boolean RHSFloat = RHSType.$arrow().isRealFloatingType();
  
  // If we have two real floating types, convert the smaller operand
  // to the bigger result.
  if (LHSFloat && RHSFloat) {
    int order = S.Context.getFloatingTypeOrder(new QualType(LHSType), new QualType(RHSType));
    if (order > 0) {
      RHS.$assignMove(S.ImpCastExprToType(RHS.get(), new QualType(LHSType), CastKind.CK_FloatingCast));
      return new QualType(JD$Move.INSTANCE, LHSType);
    }
    assert (order < 0) : "illegal float comparison";
    if (!IsCompAssign) {
      LHS.$assignMove(S.ImpCastExprToType(LHS.get(), new QualType(RHSType), CastKind.CK_FloatingCast));
    }
    return new QualType(JD$Move.INSTANCE, RHSType);
  }
  if (LHSFloat) {
    // Half FP has to be promoted to float unless it is natively supported
    if (LHSType.$arrow().isHalfType() && !S.getLangOpts().NativeHalfType) {
      LHSType.$assignMove(S.Context.FloatTy.$QualType());
    }
    
    return handleIntToFloatConversion(S, LHS, RHS, new QualType(LHSType), new QualType(RHSType), 
        /*convertFloat=*/ !IsCompAssign, 
        /*convertInt=*/ true);
  }
  assert (RHSFloat);
  return handleIntToFloatConversion(S, RHS, LHS, new QualType(RHSType), new QualType(LHSType), 
      /*convertInt=*/ true, 
      /*convertFloat=*/ !IsCompAssign);
}


/// \brief Diagnose attempts to convert between __float128 and long double if
/// there is no support for such conversion. Helper function of
/// UsualArithmeticConversions().
//<editor-fold defaultstate="collapsed" desc="unsupportedTypeConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 1156,
 FQN="unsupportedTypeConversion", NM="_ZL25unsupportedTypeConversionRKN5clang4SemaENS_8QualTypeES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL25unsupportedTypeConversionRKN5clang4SemaENS_8QualTypeES3_")
//</editor-fold>
public static boolean unsupportedTypeConversion(final /*const*/ Sema /*&*/ S, QualType LHSType, 
                         QualType RHSType) {
  /*  No issue converting if at least one of the types is not a floating point
  type or the two types have the same rank.
  */
  if (!LHSType.$arrow().isFloatingType() || !RHSType.$arrow().isFloatingType()
     || S.Context.getFloatingTypeOrder(new QualType(LHSType), new QualType(RHSType)) == 0) {
    return false;
  }
  assert (LHSType.$arrow().isFloatingType() && RHSType.$arrow().isFloatingType()) : "The remaining types must be floating point types.";
  
  /*const*/ ComplexType /*P*/ LHSComplex = LHSType.$arrow().getAs(ComplexType.class);
  /*const*/ ComplexType /*P*/ RHSComplex = RHSType.$arrow().getAs(ComplexType.class);
  
  QualType LHSElemType = (LHSComplex != null) ? LHSComplex.getElementType() : new QualType(LHSType);
  QualType RHSElemType = (RHSComplex != null) ? RHSComplex.getElementType() : new QualType(RHSType);
  
  // No issue if the two types have the same representation
  if ($AddrOf(S.Context.getFloatTypeSemantics(new QualType(LHSElemType)))
     == $AddrOf(S.Context.getFloatTypeSemantics(new QualType(RHSElemType)))) {
    return false;
  }
  
  boolean Float128AndLongDouble = ($eq_QualType$C(LHSElemType, S.Context.Float128Ty.$QualType())
     && $eq_QualType$C(RHSElemType, S.Context.LongDoubleTy.$QualType()));
  Float128AndLongDouble |= ($eq_QualType$C(LHSElemType, S.Context.LongDoubleTy.$QualType())
     && $eq_QualType$C(RHSElemType, S.Context.Float128Ty.$QualType()));
  
  /* We've handled the situation where __float128 and long double have the same
  representation. The only other allowable conversion is if long double is
  really just double.
  */
  return Float128AndLongDouble
     && ($AddrOf(S.Context.getFloatTypeSemantics(S.Context.LongDoubleTy.$QualType()))
     != $AddrOf(APFloat.IEEEdouble));
}

/// These helper callbacks are placed in an anonymous namespace to
/// permit their use as function template parameters.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::doIntegralCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 1200,
 FQN="(anonymous namespace)::doIntegralCast", NM="_ZN12_GLOBAL__N_114doIntegralCastERN5clang4SemaEPNS0_4ExprENS0_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_114doIntegralCastERN5clang4SemaEPNS0_4ExprENS0_8QualTypeE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > doIntegralCast(final Sema /*&*/ S, Expr /*P*/ op, QualType toType) {
  return S.ImpCastExprToType(op, new QualType(toType), CastKind.CK_IntegralCast);
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::doComplexIntegralCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 1204,
 FQN="(anonymous namespace)::doComplexIntegralCast", NM="_ZN12_GLOBAL__N_121doComplexIntegralCastERN5clang4SemaEPNS0_4ExprENS0_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_121doComplexIntegralCastERN5clang4SemaEPNS0_4ExprENS0_8QualTypeE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > doComplexIntegralCast(final Sema /*&*/ S, Expr /*P*/ op, QualType toType) {
  return S.ImpCastExprToType(op, S.Context.getComplexType(new QualType(toType)), 
      CastKind.CK_IntegralComplexCast);
}


/// \brief Handle integer arithmetic conversions.  Helper function of
/// UsualArithmeticConversions()
/*template <PerformCastFn * doLHSCast, PerformCastFn * doRHSCast> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="handleIntegerConversion">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 1213,
 FQN="handleIntegerConversion", NM="Tpl__ZL23handleIntegerConversionRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_8QualTypeES7_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=Tpl__ZL23handleIntegerConversionRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_8QualTypeES7_b")
//</editor-fold>
public static QualType handleIntegerConversion(SemaExprQualType2ExprResult doLHSCast, SemaExprQualType2ExprResult doRHSCast,
                final Sema /*&*/ S, final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, 
                final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, QualType LHSType, 
                QualType RHSType, boolean IsCompAssign) {
  // The rules for this case are in C99 6.3.1.8
  int order = S.Context.getIntegerTypeOrder(new QualType(LHSType), new QualType(RHSType));
  boolean LHSSigned = LHSType.$arrow().hasSignedIntegerRepresentation();
  boolean RHSSigned = RHSType.$arrow().hasSignedIntegerRepresentation();
  if (LHSSigned == RHSSigned) {
    // Same signedness; use the higher-ranked type
    if (order >= 0) {
      RHS.$assignMove((/*Deref*/doRHSCast).$call(S, RHS.get(), new QualType(LHSType)));
      return new QualType(JD$Move.INSTANCE, LHSType);
    } else if (!IsCompAssign) {
      LHS.$assignMove((/*Deref*/doLHSCast).$call(S, LHS.get(), new QualType(RHSType)));
    }
    return new QualType(JD$Move.INSTANCE, RHSType);
  } else if (order != (LHSSigned ? 1 : -1)) {
    // The unsigned type has greater than or equal rank to the
    // signed type, so use the unsigned type
    if (RHSSigned) {
      RHS.$assignMove((/*Deref*/doRHSCast).$call(S, RHS.get(), new QualType(LHSType)));
      return new QualType(JD$Move.INSTANCE, LHSType);
    } else if (!IsCompAssign) {
      LHS.$assignMove((/*Deref*/doLHSCast).$call(S, LHS.get(), new QualType(RHSType)));
    }
    return new QualType(JD$Move.INSTANCE, RHSType);
  } else if (S.Context.getIntWidth(new QualType(LHSType)) != S.Context.getIntWidth(new QualType(RHSType))) {
    // The two types are different widths; if we are here, that
    // means the signed type is larger than the unsigned type, so
    // use the signed type.
    if (LHSSigned) {
      RHS.$assignMove((/*Deref*/doRHSCast).$call(S, RHS.get(), new QualType(LHSType)));
      return new QualType(JD$Move.INSTANCE, LHSType);
    } else if (!IsCompAssign) {
      LHS.$assignMove((/*Deref*/doLHSCast).$call(S, LHS.get(), new QualType(RHSType)));
    }
    return new QualType(JD$Move.INSTANCE, RHSType);
  } else {
    // The signed type is higher-ranked than the unsigned type,
    // but isn't actually any bigger (like unsigned int and long
    // on most 32-bit systems).  Use the unsigned type corresponding
    // to the signed type.
    QualType result = S.Context.getCorrespondingUnsignedType(new QualType(LHSSigned ? LHSType : RHSType));
    RHS.$assignMove((/*Deref*/doRHSCast).$call(S, RHS.get(), new QualType(result)));
    if (!IsCompAssign) {
      LHS.$assignMove((/*Deref*/doLHSCast).$call(S, LHS.get(), new QualType(result)));
    }
    return result;
  }
}


/// \brief Handle conversions with GCC complex int extension.  Helper function
/// of UsualArithmeticConversions()
//<editor-fold defaultstate="collapsed" desc="handleComplexIntConversion">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 1263,
 FQN="handleComplexIntConversion", NM="_ZL26handleComplexIntConversionRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_8QualTypeES7_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL26handleComplexIntConversionRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_8QualTypeES7_b")
//</editor-fold>
public static QualType handleComplexIntConversion(final Sema /*&*/ S, final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, 
                          final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, QualType LHSType, 
                          QualType RHSType, 
                          boolean IsCompAssign) {
  /*const*/ ComplexType /*P*/ LHSComplexInt = LHSType.$arrow().getAsComplexIntegerType();
  /*const*/ ComplexType /*P*/ RHSComplexInt = RHSType.$arrow().getAsComplexIntegerType();
  if ((LHSComplexInt != null) && (RHSComplexInt != null)) {
    QualType LHSEltType = LHSComplexInt.getElementType();
    QualType RHSEltType = RHSComplexInt.getElementType();
    QualType ScalarType = handleIntegerConversion/*<doComplexIntegralCast, doComplexIntegralCast>*/(SemaExprStatics::doComplexIntegralCast, SemaExprStatics::doComplexIntegralCast, S, LHS, RHS, new QualType(LHSEltType), new QualType(RHSEltType), IsCompAssign);
    
    return S.Context.getComplexType(new QualType(ScalarType));
  }
  if ((LHSComplexInt != null)) {
    QualType LHSEltType = LHSComplexInt.getElementType();
    QualType ScalarType = handleIntegerConversion/*<doComplexIntegralCast, doIntegralCast>*/(SemaExprStatics::doComplexIntegralCast,SemaExprStatics::doIntegralCast,S, LHS, RHS, new QualType(LHSEltType), new QualType(RHSType), IsCompAssign);
    QualType ComplexType = S.Context.getComplexType(new QualType(ScalarType));
    RHS.$assignMove(S.ImpCastExprToType(RHS.get(), new QualType(ComplexType), 
            CastKind.CK_IntegralRealToComplex));
    
    return ComplexType;
  }
  assert Native.$bool(RHSComplexInt);
  
  QualType RHSEltType = RHSComplexInt.getElementType();
  QualType ScalarType = handleIntegerConversion/*<doIntegralCast, doComplexIntegralCast>*/(SemaExprStatics::doIntegralCast,SemaExprStatics::doComplexIntegralCast,S, LHS, RHS, new QualType(LHSType), new QualType(RHSEltType), IsCompAssign);
  QualType ComplexType = S.Context.getComplexType(new QualType(ScalarType));
  if (!IsCompAssign) {
    LHS.$assignMove(S.ImpCastExprToType(LHS.get(), new QualType(ComplexType), 
            CastKind.CK_IntegralRealToComplex));
  }
  return ComplexType;
}


/// getUDSuffixLoc - Create a SourceLocation for a ud-suffix, given the
/// location of the token and the offset of the ud-suffix within it.
//<editor-fold defaultstate="collapsed" desc="getUDSuffixLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 1561,
 FQN="getUDSuffixLoc", NM="_ZL14getUDSuffixLocRN5clang4SemaENS_14SourceLocationEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL14getUDSuffixLocRN5clang4SemaENS_14SourceLocationEj")
//</editor-fold>
public static SourceLocation getUDSuffixLoc(final Sema /*&*/ S, SourceLocation TokLoc, 
              /*uint*/int Offset) {
  return Lexer.AdvanceToTokenCharacter(/*NO_COPY*/TokLoc, Offset, S.getSourceManager(), 
      S.getLangOpts());
}


/// BuildCookedLiteralOperatorCall - A user-defined literal was found. Look up
/// the corresponding cooked (non-raw) literal operator, and build a call to it.
//<editor-fold defaultstate="collapsed" desc="BuildCookedLiteralOperatorCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 1569,
 FQN="BuildCookedLiteralOperatorCall", NM="_ZL30BuildCookedLiteralOperatorCallRN5clang4SemaEPNS_5ScopeEPNS_14IdentifierInfoENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEES6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL30BuildCookedLiteralOperatorCallRN5clang4SemaEPNS_5ScopeEPNS_14IdentifierInfoENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEES6_")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > BuildCookedLiteralOperatorCall(final Sema /*&*/ S, Scope /*P*/ $Scope, 
                              IdentifierInfo /*P*/ UDSuffix, 
                              SourceLocation UDSuffixLoc, 
                              ArrayRef<Expr /*P*/ > Args, 
                              SourceLocation LitEndLoc) {
  LookupResult R = null;
  try {
    assert ($lesseq_uint(Args.size(), 2)) : "too many arguments for literal operator";
    
    QualType ArgTy[/*2*/]/*J*/= new$T(new QualType [2], ()->new QualType());
    for (/*uint*/int ArgIdx = 0; ArgIdx != Args.size(); ++ArgIdx) {
      ArgTy[ArgIdx].$assignMove(Args.$at(ArgIdx).getType());
      if (ArgTy[ArgIdx].$arrow().isArrayType()) {
        ArgTy[ArgIdx].$assignMove(S.Context.getArrayDecayedType(new QualType(ArgTy[ArgIdx])));
      }
    }
    
    DeclarationName OpName = S.Context.DeclarationNames.getCXXLiteralOperatorName(UDSuffix);
    DeclarationNameInfo OpNameInfo/*J*/= new DeclarationNameInfo(new DeclarationName(OpName), new SourceLocation(UDSuffixLoc));
    OpNameInfo.setCXXLiteralOperatorNameLoc(new SourceLocation(UDSuffixLoc));
    
    R/*J*/= new LookupResult(S, new DeclarationName(OpName), new SourceLocation(UDSuffixLoc), Sema.LookupNameKind.LookupOrdinaryName);
    if (S.LookupLiteralOperator($Scope, R, llvm.makeArrayRef(ArgTy, Args.size()), 
        /*AllowRaw*/ false, /*AllowTemplate*/ false, 
        /*AllowStringTemplate*/ false) == Sema.LiteralOperatorLookupResult.LOLR_Error) {
      return ExprError();
    }
    
    return S.BuildLiteralOperatorCall(R, OpNameInfo, new ArrayRef<Expr /*P*/ >(Args), new SourceLocation(LitEndLoc));
  } finally {
    if (R != null) { R.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="emitEmptyLookupTypoDiagnostic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 1823,
 FQN="emitEmptyLookupTypoDiagnostic", NM="_ZL29emitEmptyLookupTypoDiagnosticRKN5clang14TypoCorrectionERNS_4SemaERKNS_12CXXScopeSpecENS_15DeclarationNameENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEEjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL29emitEmptyLookupTypoDiagnosticRKN5clang14TypoCorrectionERNS_4SemaERKNS_12CXXScopeSpecENS_15DeclarationNameENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEEjj")
//</editor-fold>
public static void emitEmptyLookupTypoDiagnostic(final /*const*/ TypoCorrection /*&*/ TC, final Sema /*&*/ SemaRef, final /*const*/ CXXScopeSpec /*&*/ SS, 
                             DeclarationName Typo, SourceLocation TypoLoc, ArrayRef<Expr /*P*/ > Args, 
                             /*uint*/int DiagnosticID, /*uint*/int DiagnosticSuggestID) {
  DeclContext /*P*/ Ctx = SS.isEmpty() ? null : SemaRef.computeDeclContext(SS, false);
  if (!TC.$bool()) {
    // Emit a special diagnostic for failed member lookups.
    // FIXME: computing the declaration context might fail here (?)
    if ((Ctx != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(TypoLoc), diag.err_no_member)), Typo), Ctx), 
            SS.getRange()));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(TypoLoc), DiagnosticID)), Typo));
      } finally {
        $c$.$destroy();
      }
    }
    return;
  }
  
  std.string CorrectedStr = TC.getAsString(SemaRef.getLangOpts());
  boolean DroppedSpecifier = TC.WillReplaceSpecifier() && $eq_str$C(Typo.getAsString(), CorrectedStr);
  /*uint*/int NoteID = (TC.getCorrectionDeclAs(ImplicitParamDecl.class) != null) ? diag.note_implicit_param_decl : diag.note_previous_decl;
  if (!(Ctx != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SemaRef.diagnoseTypo(TC, $out_PartialDiagnostic$C_DeclarationName($c$.track(SemaRef.PDiag(DiagnosticSuggestID)), /*NO_COPY*/Typo), 
          $c$.track(SemaRef.PDiag(NoteID))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SemaRef.diagnoseTypo(TC, $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_int($out$Same2DeclContext($out_PartialDiagnostic$C_DeclarationName($c$.track(SemaRef.PDiag(diag.err_no_member_suggest)), 
                          /*NO_COPY*/Typo), Ctx), (DroppedSpecifier ? 1 : 0)), 
              SS.getRange()), 
          $c$.track(SemaRef.PDiag(NoteID))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }
}


/// In Microsoft mode, if we are inside a template class whose parent class has
/// dependent base classes, and we can't resolve an unqualified identifier, then
/// assume the identifier is a member of a dependent base class.  We can only
/// recover successfully in static methods, instance methods, and other contexts
/// where 'this' is available.  This doesn't precisely match MSVC's
/// instantiation model, but it's close enough.
//<editor-fold defaultstate="collapsed" desc="recoverFromMSUnqualifiedLookup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 2065,
 FQN="recoverFromMSUnqualifiedLookup", NM="_ZL30recoverFromMSUnqualifiedLookupRN5clang4SemaERNS_10ASTContextERNS_19DeclarationNameInfoENS_14SourceLocationEPKNS_24TemplateArgumentListInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL30recoverFromMSUnqualifiedLookupRN5clang4SemaERNS_10ASTContextERNS_19DeclarationNameInfoENS_14SourceLocationEPKNS_24TemplateArgumentListInfoE")
//</editor-fold>
public static Expr /*P*/ recoverFromMSUnqualifiedLookup(final Sema /*&*/ S, final ASTContext /*&*/ Context, 
                              final DeclarationNameInfo /*&*/ NameInfo, 
                              SourceLocation TemplateKWLoc, 
                              /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs) {
  Sema_NestedClasses.SemaDiagnosticBuilder DB = null;
  CXXScopeSpec SS = null;
  try {
    // Only try to recover from lookup into dependent bases in static methods or
    // contexts where 'this' is available.
    QualType ThisType = S.getCurrentThisType();
    /*const*/ CXXRecordDecl /*P*/ RD = null;
    if (!ThisType.isNull()) {
      RD = ThisType.$arrow().getPointeeType().$arrow().getAsCXXRecordDecl();
    } else {
      CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(S.CurContext);
      if ((MD != null)) {
        RD = MD.getParent();
      }
    }
    if (!(RD != null) || !RD.hasAnyDependentBases()) {
      return null;
    }
    
    // Diagnose this as unqualified lookup into a dependent base class.  If 'this'
    // is available, suggest inserting 'this->' as a fixit.
    SourceLocation Loc = NameInfo.getLoc();
    DB = S.Diag(new SourceLocation(Loc), diag.ext_undeclared_unqual_id_with_dependent_base);
    $out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R(DB, NameInfo.getName()), RD);
    if (!ThisType.isNull()) {
      $out_SemaDiagnosticBuilder$C_T$C$R(DB, FixItHint.CreateInsertion(/*NO_COPY*/Loc, new StringRef(/*KEEP_STR*/"this->")));
      return CXXDependentScopeMemberExpr.Create(Context, /*This=*/ (Expr /*P*/ )null, new QualType(ThisType), /*IsArrow=*/ true, 
          /*Op=*/ new SourceLocation(), new NestedNameSpecifierLoc(), new SourceLocation(TemplateKWLoc), 
          /*FirstQualifierInScope=*/ (NamedDecl /*P*/ )null, new DeclarationNameInfo(NameInfo), TemplateArgs);
    }
    
    // Synthesize a fake NNS that points to the derived class.  This will
    // perform name lookup during template instantiation.
    SS/*J*/= new CXXScopeSpec();
    NestedNameSpecifier /*P*/ NNS = NestedNameSpecifier.Create(Context, (NestedNameSpecifier /*P*/ )null, true, RD.getTypeForDecl());
    SS.MakeTrivial(Context, NNS, new SourceRange(/*NO_COPY*/Loc, /*NO_COPY*/Loc));
    return DependentScopeDeclRefExpr.Create(Context, SS.getWithLocInContext(Context), new SourceLocation(TemplateKWLoc), NameInfo, 
        TemplateArgs);
  } finally {
    if (SS != null) { SS.$destroy(); }
    if (DB != null) { DB.$destroy(); }
  }
}


/// Diagnoses obvious problems with the use of the given declaration
/// as an expression.  This is only actually called for lookups that
/// were not overloaded, and it doesn't promise that the declaration
/// will in fact be used.
//<editor-fold defaultstate="collapsed" desc="CheckDeclInExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 2781,
 FQN="CheckDeclInExpr", NM="_ZL15CheckDeclInExprRN5clang4SemaENS_14SourceLocationEPNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL15CheckDeclInExprRN5clang4SemaENS_14SourceLocationEPNS_9NamedDeclE")
//</editor-fold>
public static boolean CheckDeclInExpr(final Sema /*&*/ S, SourceLocation Loc, NamedDecl /*P*/ D) {
  if (isa_TypedefNameDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_unexpected_typedef)), D.getDeclName()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  if (isa_ObjCInterfaceDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_unexpected_interface)), D.getDeclName()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  if (isa_NamespaceDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_unexpected_namespace)), D.getDeclName()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="ConvertUTF8ToWideString">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 3045,
 FQN="ConvertUTF8ToWideString", NM="_ZL23ConvertUTF8ToWideStringjN4llvm9StringRefERNS_11SmallStringILj32EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL23ConvertUTF8ToWideStringjN4llvm9StringRefERNS_11SmallStringILj32EEE")
//</editor-fold>
public static void ConvertUTF8ToWideString(/*uint*/int CharByteWidth, StringRef Source, 
                       final SmallString/*32*/ /*&*/ Target) {
  Target.resize(CharByteWidth * (Source.size() + 1));
  char$ptr/*char P*/ ResultPtr = $tryClone($AddrOf(Target.c_str()));
  /*const*/char$ptr/*UTF8 P*/ ErrorPtr = create_char$null$ptr();
  boolean success = ConvertUTF8toWide(CharByteWidth, /*NO_COPY*/Source, ResultPtr.$addr().star$ref(), ErrorPtr.$addr().star$ref());
  ///*J:(void)*/success;
  assert (success);
  Target.resize(ResultPtr.$sub($AddrOf(Target.c_str())));
}

//<editor-fold defaultstate="collapsed" desc="BuildFloatingLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 3183,
 FQN="BuildFloatingLiteral", NM="_ZL20BuildFloatingLiteralRN5clang4SemaERNS_20NumericLiteralParserENS_8QualTypeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL20BuildFloatingLiteralRN5clang4SemaERNS_20NumericLiteralParserENS_8QualTypeENS_14SourceLocationE")
//</editor-fold>
public static Expr /*P*/ BuildFloatingLiteral(final Sema /*&*/ S, final NumericLiteralParser /*&*/ Literal, 
                    QualType Ty, SourceLocation Loc) {
  final /*const*/ fltSemantics /*&*/ Format = S.Context.getFloatTypeSemantics(new QualType(Ty));

  //JAVA: using llvm::APFloat;
  APFloat Val/*J*/= new APFloat(Format);

  /*APFloat::opStatus*//*uint*/int result = Literal.GetFloatValue(Val);

  // Overflow is always an error, but underflow is only an error if
  // we underflowed to zero (APFloat reports denormals as underflow).
  if (((result & APFloat.opStatus.opOverflow) != 0)
     || (((result & APFloat.opStatus.opUnderflow) != 0) && Val.isZero())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*uint*/int diagnostic;
      SmallString/*20*/ buffer/*J*/= new SmallString/*20*/(20);
      if (((result & APFloat.opStatus.opOverflow) != 0)) {
        diagnostic = diag.warn_float_overflow;
        $c$.track(APFloat.getLargest(Format)).__toString(buffer); $c$.clean();
      } else {
        diagnostic = diag.warn_float_underflow;
        $c$.track(APFloat.getSmallest(Format)).__toString(buffer); $c$.clean();
      }

      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diagnostic)), 
              Ty), 
          new StringRef(buffer.data(), buffer.size())));
    } finally {
      $c$.$destroy();
    }
  }

  boolean isExact = (result == APFloat.opStatus.opOK);
  return FloatingLiteral.Create(S.Context, Val, isExact, new QualType(Ty), new SourceLocation(Loc));
}

//<editor-fold defaultstate="collapsed" desc="CheckVecStepTraitOperandType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 3531,
 FQN="CheckVecStepTraitOperandType", NM="_ZL28CheckVecStepTraitOperandTypeRN5clang4SemaENS_8QualTypeENS_14SourceLocationENS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL28CheckVecStepTraitOperandTypeRN5clang4SemaENS_8QualTypeENS_14SourceLocationENS_11SourceRangeE")
//</editor-fold>
public static boolean CheckVecStepTraitOperandType(final Sema /*&*/ S, QualType T, 
                            SourceLocation Loc, 
                            SourceRange ArgRange) {
  // [OpenCL 1.1 6.11.12] "The vec_step built-in function takes a built-in
  // scalar or vector data type argument..."
  // Every built-in scalar type (OpenCL 1.1 6.1.1) is either an arithmetic
  // type (C99 6.2.5p18) or void.
  if (!(T.$arrow().isArithmeticType() || T.$arrow().isVoidType() || T.$arrow().isVectorType())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_vecstep_non_scalar_vector_type)), 
              T), ArgRange));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  assert ((T.$arrow().isVoidType() || !T.$arrow().isIncompleteType())) : "Scalar types should always be complete";
  return false;
}

//<editor-fold defaultstate="collapsed" desc="CheckExtensionTraitOperandType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 3549,
 FQN="CheckExtensionTraitOperandType", NM="_ZL30CheckExtensionTraitOperandTypeRN5clang4SemaENS_8QualTypeENS_14SourceLocationENS_11SourceRangeENS_20UnaryExprOrTypeTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL30CheckExtensionTraitOperandTypeRN5clang4SemaENS_8QualTypeENS_14SourceLocationENS_11SourceRangeENS_20UnaryExprOrTypeTraitE")
//</editor-fold>
public static boolean CheckExtensionTraitOperandType(final Sema /*&*/ S, QualType T, 
                              SourceLocation Loc, 
                              SourceRange ArgRange, 
                              UnaryExprOrTypeTrait TraitKind) {
  // Invalid types must be hard errors for SFINAE in C++.
  if (S.LangOpts.CPlusPlus) {
    return true;
  }
  
  // C99 6.5.3.4p1:
  if (T.$arrow().isFunctionType()
     && (TraitKind == UnaryExprOrTypeTrait.UETT_SizeOf || TraitKind == UnaryExprOrTypeTrait.UETT_AlignOf)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // sizeof(function)/alignof(function) is allowed as an extension.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.ext_sizeof_alignof_function_type)), 
              TraitKind), ArgRange));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Allow sizeof(void)/alignof(void) as an extension, unless in OpenCL where
  // this is an error (OpenCL v1.1 s6.3.k)
  if (T.$arrow().isVoidType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*uint*/int DiagID = S.LangOpts.OpenCL ? diag.err_opencl_sizeof_alignof_type : diag.ext_sizeof_alignof_void_type;
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), DiagID)), TraitKind), ArgRange));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="CheckObjCTraitOperandConstraints">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 3578,
 FQN="CheckObjCTraitOperandConstraints", NM="_ZL32CheckObjCTraitOperandConstraintsRN5clang4SemaENS_8QualTypeENS_14SourceLocationENS_11SourceRangeENS_20UnaryExprOrTypeTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL32CheckObjCTraitOperandConstraintsRN5clang4SemaENS_8QualTypeENS_14SourceLocationENS_11SourceRangeENS_20UnaryExprOrTypeTraitE")
//</editor-fold>
public static boolean CheckObjCTraitOperandConstraints(final Sema /*&*/ S, QualType T, 
                                SourceLocation Loc, 
                                SourceRange ArgRange, 
                                UnaryExprOrTypeTrait TraitKind) {
  // Reject sizeof(interface) and sizeof(interface<proto>) if the
  // runtime doesn't allow it.
  if (!S.LangOpts.ObjCRuntime.allowsSizeofAlignof() && T.$arrow().isObjCObjectType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_sizeof_nonfragile_interface)), 
                  T), (TraitKind == UnaryExprOrTypeTrait.UETT_SizeOf)), 
          ArgRange));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}


/// \brief Check whether E is a pointer from a decayed array type (the decayed
/// pointer type is equal to T) and emit a warning if it is.
//<editor-fold defaultstate="collapsed" desc="warnOnSizeofOnArrayDecay">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 3596,
 FQN="warnOnSizeofOnArrayDecay", NM="_ZL24warnOnSizeofOnArrayDecayRN5clang4SemaENS_14SourceLocationENS_8QualTypeEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL24warnOnSizeofOnArrayDecayRN5clang4SemaENS_14SourceLocationENS_8QualTypeEPNS_4ExprE")
//</editor-fold>
public static void warnOnSizeofOnArrayDecay(final Sema /*&*/ S, SourceLocation Loc, QualType T, 
                        Expr /*P*/ E) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Don't warn if the operation changed the type.
    if ($noteq_QualType$C(T, E.getType())) {
      return;
    }
    
    // Now look for array decays.
    ImplicitCastExpr /*P*/ ICE = dyn_cast_ImplicitCastExpr(E);
    if (!(ICE != null) || ICE.getCastKind() != CastKind.CK_ArrayToPointerDecay) {
      return;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.warn_sizeof_array_decay)), ICE.getSourceRange()), 
            ICE.getType()), 
        ICE.getSubExpr().getType()));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="CheckAlignOfExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 3759,
 FQN="CheckAlignOfExpr", NM="_ZL16CheckAlignOfExprRN5clang4SemaEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL16CheckAlignOfExprRN5clang4SemaEPNS_4ExprE")
//</editor-fold>
public static boolean CheckAlignOfExpr(final Sema /*&*/ S, Expr /*P*/ E) {
  E = E.IgnoreParens();
  
  // Cannot know anything else if the expression is dependent.
  if (E.isTypeDependent()) {
    return false;
  }
  if (E.getObjectKind() == ExprObjectKind.OK_BitField) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getExprLoc(), diag.err_sizeof_alignof_typeof_bitfield)), 
              1), E.getSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  ValueDecl /*P*/ D = null;
  {
    DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
    if ((DRE != null)) {
      D = DRE.getDecl();
    } else {
      MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E);
      if ((ME != null)) {
        D = ME.getMemberDecl();
      }
    }
  }
  {
    
    // If it's a field, require the containing struct to have a
    // complete definition so that we can compute the layout.
    //
    // This can happen in C++11 onwards, either by naming the member
    // in a way that is not transformed into a member access expression
    // (in an unevaluated operand, for instance), or by naming the member
    // in a trailing-return-type.
    //
    // For the record, since __alignof__ on expressions is a GCC
    // extension, GCC seems to permit this but always gives the
    // nonsensical answer 0.
    //
    // We don't really need the layout here --- we could instead just
    // directly check for all the appropriate alignment-lowing
    // attributes --- but that would require duplicating a lot of
    // logic that just isn't worth duplicating for such a marginal
    // use-case.
    FieldDecl /*P*/ FD = dyn_cast_or_null_FieldDecl(D);
    if ((FD != null)) {
      // Fast path this check, since we at least know the record has a
      // definition if we can find a member of it.
      if (!FD.getParent().isCompleteDefinition()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getExprLoc(), diag.err_alignof_member_of_incomplete_type)), 
              E.getSourceRange()));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Otherwise, if it's a field, and the field doesn't have
      // reference type, then it must have a complete type (or be a
      // flexible array member, which we explicitly want to
      // white-list anyway), which makes the following checks trivial.
      if (!FD.getType().$arrow().isReferenceType()) {
        return false;
      }
    }
  }
  
  return S.CheckUnaryExprOrTypeTraitOperand(E, UnaryExprOrTypeTrait.UETT_AlignOf);
}

//<editor-fold defaultstate="collapsed" desc="captureVariablyModifiedType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 3826,
 FQN="captureVariablyModifiedType", NM="_ZL27captureVariablyModifiedTypeRN5clang10ASTContextENS_8QualTypeEPNS_4sema18CapturingScopeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL27captureVariablyModifiedTypeRN5clang10ASTContextENS_8QualTypeEPNS_4sema18CapturingScopeInfoE")
//</editor-fold>
public static void captureVariablyModifiedType(final ASTContext /*&*/ Context, QualType T, 
                           CapturingScopeInfo /*P*/ CSI) {
  assert (T.$arrow().isVariablyModifiedType());
  assert (CSI != null);
  
  // We're going to walk down into the type and look for VLA expressions.
  do {
    /*const*/ Type /*P*/ Ty = T.getTypePtr();
    switch (Ty.getTypeClass()) {
     case DependentSizedArray:
     case DependentSizedExtVector:
     case UnresolvedUsing:
     case TemplateTypeParm:
     case SubstTemplateTypeParmPack:
     case InjectedClassName:
     case DependentName:
     case DependentTemplateSpecialization:
      T.$assignMove(new QualType());
      break;
     case Builtin:
     case Complex:
     case Vector:
     case ExtVector:
     case Record:
     case Enum:
     case Elaborated:
     case TemplateSpecialization:
     case ObjCObject:
     case ObjCInterface:
     case ObjCObjectPointer:
     case Pipe:
      // These types are never variably-modified.
      throw new llvm_unreachable("type class is never variably-modified!");
     case Adjusted:
      T.$assignMove(cast_AdjustedType(Ty).getOriginalType());
      break;
     case Decayed:
      T.$assignMove(cast_DecayedType(Ty).getPointeeType());
      break;
     case Pointer:
      T.$assignMove(cast_PointerType(Ty).getPointeeType());
      break;
     case BlockPointer:
      T.$assignMove(cast_BlockPointerType(Ty).getPointeeType());
      break;
     case LValueReference:
     case RValueReference:
      T.$assignMove(cast_ReferenceType(Ty).getPointeeType());
      break;
     case MemberPointer:
      T.$assignMove(cast_MemberPointerType(Ty).getPointeeType());
      break;
     case ConstantArray:
     case IncompleteArray:
      // Losing element qualification here is fine.
      T.$assignMove(cast_ArrayType(Ty).getElementType());
      break;
     case VariableArray:
      {
        // Losing element qualification here is fine.
        /*const*/ VariableArrayType /*P*/ VAT = cast_VariableArrayType(Ty);
        {
          
          // Unknown size indication requires no size computation.
          // Otherwise, evaluate and record it.
          Expr /*P*/ Size = VAT.getSizeExpr();
          if ((Size != null)) {
            if (!CSI.isVLATypeCaptured(VAT)) {
              RecordDecl /*P*/ CapRecord = null;
              {
                LambdaScopeInfo /*P*/ LSI = dyn_cast_LambdaScopeInfo(CSI);
                if ((LSI != null)) {
                  CapRecord = LSI.Lambda;
                } else {
                  CapturedRegionScopeInfo /*P*/ CRSI = dyn_cast_CapturedRegionScopeInfo(CSI);
                  if ((CRSI != null)) {
                    CapRecord = CRSI.TheRecordDecl;
                  }
                }
              }
              if ((CapRecord != null)) {
                SourceLocation ExprLoc = Size.getExprLoc();
                CanQual<Type> SizeType = Context.getSizeType();
                // Build the non-static data member.
                FieldDecl /*P*/ Field = FieldDecl.Create(Context, CapRecord, new SourceLocation(ExprLoc), new SourceLocation(ExprLoc), 
                    /*Id*/ (IdentifierInfo /*P*/ )null, SizeType.$QualType(), /*TInfo*/ (TypeSourceInfo /*P*/ )null, 
                    /*BW*/ (Expr /*P*/ )null, /*Mutable*/ false, 
                    /*InitStyle*/ InClassInitStyle.ICIS_NoInit);
                Field.setImplicit(true);
                Field.setAccess(AccessSpecifier.AS_private);
                Field.setCapturedVLAType(VAT);
                CapRecord.addDecl(Field);
                
                CSI.addVLATypeCapture(new SourceLocation(ExprLoc), SizeType.$QualType());
              }
            }
          }
        }
        T.$assignMove(VAT.getElementType());
        break;
      }
     case FunctionProto:
     case FunctionNoProto:
      T.$assignMove(cast_FunctionType(Ty).getReturnType());
      break;
     case Paren:
     case TypeOf:
     case UnaryTransform:
     case Attributed:
     case SubstTemplateTypeParm:
     case PackExpansion:
      // Keep walking after single level desugaring.
      T.$assignMove(T.getSingleStepDesugaredType(Context));
      break;
     case Typedef:
      T.$assignMove(cast_TypedefType(Ty).desugar());
      break;
     case Decltype:
      T.$assignMove(cast_DecltypeType(Ty).desugar());
      break;
     case Auto:
      T.$assignMove(cast_AutoType(Ty).getDeducedType());
      break;
     case TypeOfExpr:
      T.$assignMove(cast_TypeOfExprType(Ty).getUnderlyingExpr().getType());
      break;
     case Atomic:
      T.$assignMove(cast_AtomicType(Ty).getValueType());
      break;
    }
  } while (!T.isNull() && T.$arrow().isVariablyModifiedType());
}

//<editor-fold defaultstate="collapsed" desc="CheckRealImagOperand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 4056,
 FQN="CheckRealImagOperand", NM="_ZL20CheckRealImagOperandRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL20CheckRealImagOperandRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_14SourceLocationEb")
//</editor-fold>
public static QualType CheckRealImagOperand(final Sema /*&*/ S, final ActionResultTTrue<Expr /*P*/ > /*&*/ V, SourceLocation Loc, 
                    boolean IsReal) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (V.get().isTypeDependent()) {
      return S.Context.DependentTy.$QualType();
    }
    
    // _Real and _Imag are only l-values for normal l-values.
    if (V.get().getObjectKind() != ExprObjectKind.OK_Ordinary) {
      V.$assignMove(S.DefaultLvalueConversion(V.get()));
      if (V.isInvalid()) {
        return new QualType();
      }
    }
    {
      
      // These operators return the element type of a complex type.
      /*const*/ ComplexType /*P*/ CT = V.get().getType().$arrow().getAs(ComplexType.class);
      if ((CT != null)) {
        return CT.getElementType();
      }
    }
    
    // Otherwise they pass through real integer and floating point types here.
    if (V.get().getType().$arrow().isArithmeticType()) {
      return V.get().getType();
    }
    
    // Test for placeholders.
    ActionResultTTrue<Expr /*P*/ > PR = S.CheckPlaceholderExpr(V.get());
    if (PR.isInvalid()) {
      return new QualType();
    }
    if (PR.get() != V.get()) {
      V.$assign(PR);
      return CheckRealImagOperand(S, V, new SourceLocation(Loc), IsReal);
    }
    
    // Reject anything else.
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_realimag_invalid_type)), V.get().getType()), 
        (IsReal ? $__real : $__imag)));
    return new QualType();
  } finally {
    $c$.$destroy();
  }
}


/// \brief Diagnose if arithmetic on the given ObjC pointer is illegal.
///
/// \return true on error
//<editor-fold defaultstate="collapsed" desc="checkArithmeticOnObjCPointer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 4113,
 FQN="checkArithmeticOnObjCPointer", NM="_ZL28checkArithmeticOnObjCPointerRN5clang4SemaENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL28checkArithmeticOnObjCPointerRN5clang4SemaENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public static boolean checkArithmeticOnObjCPointer(final Sema /*&*/ S, 
                            SourceLocation opLoc, 
                            Expr /*P*/ op) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert (op.getType().$arrow().isObjCObjectPointerType());
    if (S.LangOpts.ObjCRuntime.allowsPointerArithmetic()
       && !S.LangOpts.ObjCSubscriptingLegacyRuntime) {
      return false;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(opLoc), diag.err_arithmetic_nonfragile_interface)), 
            op.getType().$arrow().castAs(ObjCObjectPointerType.class).getPointeeType()), 
        op.getSourceRange()));
    return true;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="isMSPropertySubscriptExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 4127,
 FQN="isMSPropertySubscriptExpr", NM="_ZL25isMSPropertySubscriptExprRN5clang4SemaEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL25isMSPropertySubscriptExprRN5clang4SemaEPNS_4ExprE")
//</editor-fold>
public static boolean isMSPropertySubscriptExpr(final Sema /*&*/ S, Expr /*P*/ Base) {
  Expr /*P*/ BaseNoParens = Base.IgnoreParens();
  {
    MSPropertyRefExpr /*P*/ MSProp = dyn_cast_MSPropertyRefExpr(BaseNoParens);
    if ((MSProp != null)) {
      return MSProp.getPropertyDecl().getType().$arrow().isArrayType();
    }
  }
  return isa_MSPropertySubscriptExpr(BaseNoParens);
}

//<editor-fold defaultstate="collapsed" desc="TryTypoCorrectionForCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 4640,
 FQN="TryTypoCorrectionForCall", NM="_ZL24TryTypoCorrectionForCallRN5clang4SemaEPNS_4ExprEPNS_12FunctionDeclEN4llvm8ArrayRefIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL24TryTypoCorrectionForCallRN5clang4SemaEPNS_4ExprEPNS_12FunctionDeclEN4llvm8ArrayRefIS3_EE")
//</editor-fold>
public static TypoCorrection TryTypoCorrectionForCall(final Sema /*&*/ S, Expr /*P*/ Fn, 
                        FunctionDecl /*P*/ FDecl, 
                        ArrayRef<Expr /*P*/ > Args) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    MemberExpr /*P*/ ME = dyn_cast_MemberExpr(Fn);
    DeclarationName FuncName = FDecl.getDeclName();
    SourceLocation NameLoc = (ME != null) ? ME.getMemberLoc() : Fn.getLocStart();
    {
      TypoCorrection Corrected = null;
      try {
        
        Corrected = $c$.clean(S.CorrectTypo(new DeclarationNameInfo(new DeclarationName(FuncName), new SourceLocation(NameLoc)), Sema.LookupNameKind.LookupOrdinaryName, 
            S.getScopeForContext(S.CurContext), (CXXScopeSpec /*P*/ )null, 
            $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new FunctionCallCCC(S, FuncName.getAsIdentifierInfo(), 
                    Args.size(), ME))))), 
            Sema.CorrectTypoKind.CTK_ErrorRecovery));
        if (Corrected.$bool()) {
          {
            NamedDecl /*P*/ ND = Corrected.getFoundDecl();
            if ((ND != null)) {
              if (Corrected.isOverloaded()) {
                OverloadCandidateSet OCS = null;
                try {
                  OCS/*J*/= new OverloadCandidateSet(new SourceLocation(NameLoc), OverloadCandidateSet.CandidateSetKind.CSK_Normal);
                  final type$ptr<OverloadCandidate> Best = create_type$ptr();
                  for (NamedDecl /*P*/ CD : Corrected) {
                    {
                      FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(CD);
                      if ((FD != null)) {
                        S.AddOverloadCandidate(FD, DeclAccessPair.make(FD, AccessSpecifier.AS_none), new ArrayRef<Expr /*P*/ >(Args), 
                            OCS);
                      }
                    }
                  }
                  switch (OCS.BestViableFunction(S, new SourceLocation(NameLoc), Best)) {
                   case OR_Success:
                    ND = Best.$star().FoundDecl.$NamedDecl$P();
                    Corrected.setCorrectionDecl(ND);
                    break;
                   default:
                    break;
                  }
                } finally {
                  if (OCS != null) { OCS.$destroy(); }
                }
              }
              ND = ND.getUnderlyingDecl();
              if (isa_ValueDecl(ND) || isa_FunctionTemplateDecl(ND)) {
                return new TypoCorrection(JD$Move.INSTANCE, Corrected);
              }
            }
          }
        }
      } finally {
        if (Corrected != null) { Corrected.$destroy(); }
      }
    }
    return new TypoCorrection();
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="DiagnoseCalleeStaticArrayParam">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 4902,
 FQN="DiagnoseCalleeStaticArrayParam", NM="_ZL30DiagnoseCalleeStaticArrayParamRN5clang4SemaEPNS_11ParmVarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL30DiagnoseCalleeStaticArrayParamRN5clang4SemaEPNS_11ParmVarDeclE")
//</editor-fold>
public static void DiagnoseCalleeStaticArrayParam(final Sema /*&*/ S, ParmVarDecl /*P*/ PVD) {
  TypeLoc TL = PVD.getTypeSourceInfo().getTypeLoc();
  {
    DecayedTypeLoc DTL = TL.getAs(DecayedTypeLoc.class);
    if (DTL.$bool()) {
      TL.$assignMove(DTL.getOriginalLoc());
    }
  }
  {
    ArrayTypeLoc ATL = TL.getAs(ArrayTypeLoc.class);
    if (ATL.$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(PVD.getLocation(), diag.note_callee_static_array)), 
            ATL.getLocalSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
  }
}


/// Given a function expression of unknown-any type, try to rebuild it
/// to have a function type.

/// Given a function expression of unknown-any type, try to rebuild it
/// to have a function type.
//<editor-fold defaultstate="collapsed" desc="rebuildUnknownAnyFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14514,
 FQN="rebuildUnknownAnyFunction", NM="_ZL25rebuildUnknownAnyFunctionRN5clang4SemaEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL25rebuildUnknownAnyFunctionRN5clang4SemaEPNS_4ExprE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > rebuildUnknownAnyFunction(final Sema /*&*/ S, Expr /*P*/ FunctionExpr) {
  ActionResultTTrue<Expr /*P*/ > Result = new RebuildUnknownAnyFunction(S).Visit(FunctionExpr);
  if (Result.isInvalid()) {
    return ExprError();
  }
  return S.DefaultFunctionArrayConversion(Result.get());
}


/// Is the given type a placeholder that we need to lower out
/// immediately during argument processing?
//<editor-fold defaultstate="collapsed" desc="isPlaceholderToRemoveAsArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 4964,
 FQN="isPlaceholderToRemoveAsArg", NM="_ZL26isPlaceholderToRemoveAsArgN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL26isPlaceholderToRemoveAsArgN5clang8QualTypeE")
//</editor-fold>
public static boolean isPlaceholderToRemoveAsArg(QualType type) {
  // Placeholders are never sugared.
  /*const*/ BuiltinType /*P*/ placeholder = dyn_cast_BuiltinType(type);
  if (!(placeholder != null)) {
    return false;
  }
  switch (placeholder.getKind()) {
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
    return false;
   case Overload:
    
    // We cannot lower out overload sets; they might validly be resolved
    // by the call machinery.
    return false;
   case ARCUnbridgedCast:
    
    // Unbridged casts in ARC can be handled in some call positions and
    // should be left in place.
    return false;
   case PseudoObject:
    
    // Pseudo-objects should be converted as soon as possible.
    return true;
   case UnknownAny:
    
    // The debugger mode could theoretically but currently does not try
    // to resolve unknown-typed arguments based on known parameter types.
    return true;
   case BoundMember:
   case BuiltinFn:
   case OMPArraySection:
    
    // These are always invalid as call arguments and should be reported.
    return true;
  }
  throw new llvm_unreachable("bad builtin type kind");
}


/// Check an argument list for placeholders that we won't try to
/// handle later.
//<editor-fold defaultstate="collapsed" desc="checkArgsForPlaceholders">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 5010,
 FQN="checkArgsForPlaceholders", NM="_ZL24checkArgsForPlaceholdersRN5clang4SemaEN4llvm15MutableArrayRefIPNS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL24checkArgsForPlaceholdersRN5clang4SemaEN4llvm15MutableArrayRefIPNS_4ExprEEE")
//</editor-fold>
public static boolean checkArgsForPlaceholders(final Sema /*&*/ S, MutableArrayRef<Expr /*P*/ > args) {
  // Apply this processing to all the arguments at once instead of
  // dying at the first failure.
  boolean hasInvalid = false;
  for (/*size_t*/int i = 0, e = args.size(); i != e; i++) {
    if (isPlaceholderToRemoveAsArg(args.$at(i).getType())) {
      ActionResultTTrue<Expr /*P*/ > result = S.CheckPlaceholderExpr(args.$at(i));
      if (result.isInvalid()) {
        hasInvalid = true;
      } else {
        args.$set(i, result.get());
      }
    } else if (hasInvalid) {
      /*J:(void)*/S.CorrectDelayedTyposInExpr(args.$at(i));
    }
  }
  return hasInvalid;
}


/// If a builtin function has a pointer argument with no explicit address
/// space, then it should be able to accept a pointer to any address
/// space as input.  In order to do this, we need to replace the
/// standard builtin declaration with one that uses the same address space
/// as the call.
///
/// \returns nullptr If this builtin is not a candidate for a rewrite i.e.
///                  it does not contain any pointer arguments without
///                  an address space qualifer.  Otherwise the rewritten
///                  FunctionDecl is returned.
/// TODO: Handle pointer return types.
//<editor-fold defaultstate="collapsed" desc="rewriteBuiltinFunctionDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 5037,
 FQN="rewriteBuiltinFunctionDecl", NM="_ZL26rewriteBuiltinFunctionDeclPN5clang4SemaERNS_10ASTContextEPKNS_12FunctionDeclEN4llvm15MutableArrayRefIPNS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL26rewriteBuiltinFunctionDeclPN5clang4SemaERNS_10ASTContextEPKNS_12FunctionDeclEN4llvm15MutableArrayRefIPNS_4ExprEEE")
//</editor-fold>
public static FunctionDecl /*P*/ rewriteBuiltinFunctionDecl(Sema /*P*/ $Sema, final ASTContext /*&*/ Context, 
                          /*const*/ FunctionDecl /*P*/ FDecl, 
                          MutableArrayRef<Expr /*P*/ > ArgExprs) {
  
  QualType DeclType = FDecl.getType();
  /*const*/ FunctionProtoType /*P*/ FT = dyn_cast_FunctionProtoType(DeclType);
  if (!Context.BuiltinInfo.hasPtrArgsOrResult(FDecl.getBuiltinID())
     || !(FT != null) || FT.isVariadic() || ArgExprs.size() != FT.getNumParams()) {
    return null;
  }
  
  boolean NeedsNewDecl = false;
  /*uint*/int i = 0;
  SmallVector<QualType> OverloadParams/*J*/= new SmallVector<QualType>(8, new QualType());
  
  for (QualType ParamType : FT.param_types()) {
    
    // Convert array arguments to pointer to simplify type lookup.
    Expr /*P*/ Arg = $Sema.DefaultFunctionArrayLvalueConversion(ArgExprs.$at(i++)).get();
    QualType ArgType = Arg.getType();
    if (!ParamType.$arrow().isPointerType()
       || ParamType.getQualifiers().hasAddressSpace()
       || !ArgType.$arrow().isPointerType()
       || !ArgType.$arrow().getPointeeType().getQualifiers().hasAddressSpace()) {
      OverloadParams.push_back(ParamType);
      continue;
    }
    
    NeedsNewDecl = true;
    /*uint*/int AS = ArgType.$arrow().getPointeeType().getQualifiers().getAddressSpace();
    
    QualType PointeeType = ParamType.$arrow().getPointeeType();
    PointeeType.$assignMove(Context.getAddrSpaceQualType(new QualType(PointeeType), AS));
    OverloadParams.push_back(Context.getPointerType(new QualType(PointeeType)));
  }
  if (!NeedsNewDecl) {
    return null;
  }
  
  FunctionProtoType.ExtProtoInfo EPI/*J*/= new FunctionProtoType.ExtProtoInfo();
  QualType OverloadTy = Context.getFunctionType(FT.getReturnType(), 
      new ArrayRef<QualType>(OverloadParams, false), EPI);
  DeclContext /*P*/ Parent = Context.getTranslationUnitDecl();
  FunctionDecl /*P*/ OverloadDecl = FunctionDecl.Create(Context, Parent, 
      FDecl.getLocation(), 
      FDecl.getLocation(), 
      new DeclarationName(FDecl.getIdentifier()), 
      new QualType(OverloadTy), 
      /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
      StorageClass.SC_Extern, false, 
      /*hasPrototype=*/ true);
  SmallVector<ParmVarDecl /*P*/ > Params/*J*/= new SmallVector<ParmVarDecl /*P*/ >(16, (ParmVarDecl /*P*/ )null);
  FT = cast_FunctionProtoType(OverloadTy);
  for (/*uint*/int i$1 = 0, e = FT.getNumParams(); i$1 != e; ++i$1) {
    QualType ParamType = FT.getParamType(i$1);
    ParmVarDecl /*P*/ Parm = ParmVarDecl.Create(Context, OverloadDecl, new SourceLocation(), 
        new SourceLocation(), (IdentifierInfo /*P*/ )null, new QualType(ParamType), 
        /*TInfo=*/ (TypeSourceInfo /*P*/ )null, StorageClass.SC_None, (Expr /*P*/ )null);
    Parm.setScopeInfo(0, i$1);
    Params.push_back(Parm);
  }
  OverloadDecl.setParams(new ArrayRef<ParmVarDecl /*P*/ >(Params, true));
  return OverloadDecl;
}

//<editor-fold defaultstate="collapsed" desc="isNumberOfArgsValidForCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 5103,
 FQN="isNumberOfArgsValidForCall", NM="_ZL26isNumberOfArgsValidForCallRN5clang4SemaEPKNS_12FunctionDeclEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL26isNumberOfArgsValidForCallRN5clang4SemaEPKNS_12FunctionDeclEj")
//</editor-fold>
public static boolean isNumberOfArgsValidForCall(final Sema /*&*/ S, /*const*/ FunctionDecl /*P*/ Callee, 
                          /*uint*/int NumArgs) {
  if (S.TooManyArguments(Callee.getNumParams(), NumArgs, 
      /*PartialOverloading=*/ false)) {
    return Callee.isVariadic();
  }
  return $lesseq_uint(Callee.getMinRequiredArguments(), NumArgs);
}

//<editor-fold defaultstate="collapsed" desc="breakDownVectorType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 5787,
 FQN="breakDownVectorType", NM="_ZL19breakDownVectorTypeN5clang8QualTypeERyRS0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL19breakDownVectorTypeN5clang8QualTypeERyRS0_")
//</editor-fold>
public static boolean breakDownVectorType(QualType type, final ulong$ref/*uint64_t &*/ len, 
                   final QualType /*&*/ eltType) {
  {
    // Vectors are simple.
    /*const*/ VectorType /*P*/ vecType = type.$arrow().getAs(VectorType.class);
    if ((vecType != null)) {
      len.$set($uint2ulong(vecType.getNumElements()));
      eltType.$assignMove(vecType.getElementType());
      assert (eltType.$arrow().isScalarType());
      return true;
    }
  }
  
  // We allow lax conversion to and from non-vector types, but only if
  // they're real types (i.e. non-complex, non-pointer scalar types).
  if (!type.$arrow().isRealType()) {
    return false;
  }
  
  len.$set(1);
  eltType.$assign(type);
  return true;
}


/// \brief Return false if the condition expression is valid, true otherwise.
//<editor-fold defaultstate="collapsed" desc="checkCondition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6156,
 FQN="checkCondition", NM="_ZL14checkConditionRN5clang4SemaEPNS_4ExprENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL14checkConditionRN5clang4SemaEPNS_4ExprENS_14SourceLocationE")
//</editor-fold>
public static boolean checkCondition(final Sema /*&*/ S, Expr /*P*/ Cond, SourceLocation QuestionLoc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    QualType CondTy = Cond.getType();
    
    // OpenCL v1.1 s6.3.i says the condition cannot be a floating point type.
    if (S.getLangOpts().OpenCL && CondTy.$arrow().isFloatingType()) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(QuestionLoc), diag.err_typecheck_cond_expect_nonfloat)), 
              CondTy), Cond.getSourceRange()));
      return true;
    }
    
    // C99 6.5.15p2
    if (CondTy.$arrow().isScalarType()) {
      return false;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(QuestionLoc), diag.err_typecheck_cond_expect_scalar)), 
            CondTy), Cond.getSourceRange()));
    return true;
  } finally {
    $c$.$destroy();
  }
}


/// \brief Handle when one or both operands are void type.
//<editor-fold defaultstate="collapsed" desc="checkConditionalVoidType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6175,
 FQN="checkConditionalVoidType", NM="_ZL24checkConditionalVoidTypeRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL24checkConditionalVoidTypeRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_")
//</editor-fold>
public static QualType checkConditionalVoidType(final Sema /*&*/ S, final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, 
                        final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS) {
  Expr /*P*/ LHSExpr = LHS.get();
  Expr /*P*/ RHSExpr = RHS.get();
  if (!LHSExpr.getType().$arrow().isVoidType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(RHSExpr.getLocStart(), diag.ext_typecheck_cond_one_void)), 
          RHSExpr.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
  if (!RHSExpr.getType().$arrow().isVoidType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(LHSExpr.getLocStart(), diag.ext_typecheck_cond_one_void)), 
          LHSExpr.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
  LHS.$assignMove(S.ImpCastExprToType(LHS.get(), S.Context.VoidTy.$QualType(), CastKind.CK_ToVoid));
  RHS.$assignMove(S.ImpCastExprToType(RHS.get(), S.Context.VoidTy.$QualType(), CastKind.CK_ToVoid));
  return S.Context.VoidTy.$QualType();
}


/// \brief Return false if the NullExpr can be promoted to PointerTy,
/// true otherwise.
//<editor-fold defaultstate="collapsed" desc="checkConditionalNullPointer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6193,
 FQN="checkConditionalNullPointer", NM="_ZL27checkConditionalNullPointerRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL27checkConditionalNullPointerRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeE")
//</editor-fold>
public static boolean checkConditionalNullPointer(final Sema /*&*/ S, final ActionResultTTrue<Expr /*P*/ > /*&*/ NullExpr, 
                           QualType PointerTy) {
  if ((!PointerTy.$arrow().isAnyPointerType() && !PointerTy.$arrow().isBlockPointerType())
     || !(NullExpr.get().isNullPointerConstant(S.Context, 
      Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNull).getValue() != 0)) {
    return true;
  }
  
  NullExpr.$assignMove(S.ImpCastExprToType(NullExpr.get(), new QualType(PointerTy), CastKind.CK_NullToPointer));
  return false;
}


/// \brief Checks compatibility between two pointers and return the resulting
/// type.
//<editor-fold defaultstate="collapsed" desc="checkConditionalPointerCompatibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6206,
 FQN="checkConditionalPointerCompatibility", NM="_ZL36checkConditionalPointerCompatibilityRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL36checkConditionalPointerCompatibilityRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationE")
//</editor-fold>
public static QualType checkConditionalPointerCompatibility(final Sema /*&*/ S, final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, 
                                    final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                                    SourceLocation Loc) {
  QualType LHSTy = LHS.get().getType();
  QualType RHSTy = RHS.get().getType();
  if (S.Context.hasSameType(new QualType(LHSTy), new QualType(RHSTy))) {
    // Two identical pointers types are always compatible.
    return LHSTy;
  }
  
  QualType lhptee/*J*/= new QualType(), rhptee/*J*/= new QualType();
  
  // Get the pointee types.
  boolean IsBlockPointer = false;
  {
    /*const*/ BlockPointerType /*P*/ LHSBTy = LHSTy.$arrow().getAs(BlockPointerType.class);
    if ((LHSBTy != null)) {
      lhptee.$assignMove(LHSBTy.getPointeeType());
      rhptee.$assignMove(RHSTy.$arrow().castAs(BlockPointerType.class).getPointeeType());
      IsBlockPointer = true;
    } else {
      lhptee.$assignMove(LHSTy.$arrow().castAs(PointerType.class).getPointeeType());
      rhptee.$assignMove(RHSTy.$arrow().castAs(PointerType.class).getPointeeType());
    }
  }
  
  // C99 6.5.15p6: If both operands are pointers to compatible types or to
  // differently qualified versions of compatible types, the result type is
  // a pointer to an appropriately qualified version of the composite
  // type.
  
  // Only CVR-qualifiers exist in the standard, and the differently-qualified
  // clause doesn't make sense for our extensions. E.g. address space 2 should
  // be incompatible with address space 3: they may live on different devices or
  // anything.
  Qualifiers lhQual = lhptee.getQualifiers();
  Qualifiers rhQual = rhptee.getQualifiers();
  
  /*uint*/int MergedCVRQual = lhQual.getCVRQualifiers() | rhQual.getCVRQualifiers();
  lhQual.removeCVRQualifiers();
  rhQual.removeCVRQualifiers();
  
  lhptee.$assignMove(S.Context.getQualifiedType(lhptee.getUnqualifiedType(), new Qualifiers(lhQual)));
  rhptee.$assignMove(S.Context.getQualifiedType(rhptee.getUnqualifiedType(), new Qualifiers(rhQual)));
  
  // For OpenCL:
  // 1. If LHS and RHS types match exactly and:
  //  (a) AS match => use standard C rules, no bitcast or addrspacecast
  //  (b) AS overlap => generate addrspacecast
  //  (c) AS don't overlap => give an error
  // 2. if LHS and RHS types don't match:
  //  (a) AS match => use standard C rules, generate bitcast
  //  (b) AS overlap => generate addrspacecast instead of bitcast
  //  (c) AS don't overlap => give an error
  
  // For OpenCL, non-null composite type is returned only for cases 1a and 1b.
  QualType CompositeTy = S.Context.mergeTypes(new QualType(lhptee), new QualType(rhptee));
  
  // OpenCL cases 1c, 2a, 2b, and 2c.
  if (CompositeTy.isNull()) {
    // In this situation, we assume void* type. No especially good
    // reason, but this is what gcc does, and we do have to pick
    // to get a consistent AST.
    QualType incompatTy/*J*/= new QualType();
    if (S.getLangOpts().OpenCL) {
      // OpenCL v1.1 s6.5 - Conversion between pointers to distinct address
      // spaces is disallowed.
      /*uint*/int ResultAddrSpace;
      if (lhQual.isAddressSpaceSupersetOf(new Qualifiers(rhQual))) {
        // Cases 2a and 2b.
        ResultAddrSpace = lhQual.getAddressSpace();
      } else if (rhQual.isAddressSpaceSupersetOf(new Qualifiers(lhQual))) {
        // Cases 2a and 2b.
        ResultAddrSpace = rhQual.getAddressSpace();
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Cases 1c and 2c.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), 
                                  diag.err_typecheck_op_on_nonoverlapping_address_space_pointers)), 
                              LHSTy), RHSTy), 2), LHS.get().getSourceRange()), 
              RHS.get().getSourceRange()));
          return new QualType();
        } finally {
          $c$.$destroy();
        }
      }
      
      // Continue handling cases 2a and 2b.
      incompatTy.$assignMove(S.Context.getPointerType(S.Context.getAddrSpaceQualType(S.Context.VoidTy.$QualType(), ResultAddrSpace)));
      LHS.$assignMove(S.ImpCastExprToType(LHS.get(), new QualType(incompatTy), 
              (lhQual.getAddressSpace() != ResultAddrSpace) ? CastKind.CK_AddressSpaceConversion/* 2b */ : CastKind.CK_BitCast/* 2a */));
      RHS.$assignMove(S.ImpCastExprToType(RHS.get(), new QualType(incompatTy), 
              (rhQual.getAddressSpace() != ResultAddrSpace) ? CastKind.CK_AddressSpaceConversion/* 2b */ : CastKind.CK_BitCast/* 2a */));
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.ext_typecheck_cond_incompatible_pointers)), 
                        LHSTy), RHSTy), LHS.get().getSourceRange()), 
            RHS.get().getSourceRange()));
        incompatTy.$assignMove(S.Context.getPointerType(new CanQual<Type>(S.Context.VoidTy)).$QualType());
        LHS.$assignMove(S.ImpCastExprToType(LHS.get(), new QualType(incompatTy), CastKind.CK_BitCast));
        RHS.$assignMove(S.ImpCastExprToType(RHS.get(), new QualType(incompatTy), CastKind.CK_BitCast));
      } finally {
        $c$.$destroy();
      }
    }
    return incompatTy;
  }
  
  // The pointer types are compatible.
  QualType ResultTy = CompositeTy.withCVRQualifiers(MergedCVRQual);
  CastKind LHSCastKind = CastKind.CK_BitCast, RHSCastKind = CastKind.CK_BitCast;
  if (IsBlockPointer) {
    ResultTy.$assignMove(S.Context.getBlockPointerType(new QualType(ResultTy)));
  } else {
    // Cases 1a and 1b for OpenCL.
    /*uint*/int ResultAddrSpace = ResultTy.getQualifiers().getAddressSpace();
    LHSCastKind = lhQual.getAddressSpace() == ResultAddrSpace ? CastKind.CK_BitCast/* 1a */ : CastKind.CK_AddressSpaceConversion/* 1b */;
    RHSCastKind = rhQual.getAddressSpace() == ResultAddrSpace ? CastKind.CK_BitCast/* 1a */ : CastKind.CK_AddressSpaceConversion/* 1b */;
    ResultTy.$assignMove(S.Context.getPointerType(new QualType(ResultTy)));
  }
  
  // For case 1a of OpenCL, S.ImpCastExprToType will not insert bitcast
  // if the target type does not change.
  LHS.$assignMove(S.ImpCastExprToType(LHS.get(), new QualType(ResultTy), LHSCastKind));
  RHS.$assignMove(S.ImpCastExprToType(RHS.get(), new QualType(ResultTy), RHSCastKind));
  return ResultTy;
}


/// \brief Return the resulting type when the operands are both block pointers.
//<editor-fold defaultstate="collapsed" desc="checkConditionalBlockPointerCompatibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6334,
 FQN="checkConditionalBlockPointerCompatibility", NM="_ZL41checkConditionalBlockPointerCompatibilityRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL41checkConditionalBlockPointerCompatibilityRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationE")
//</editor-fold>
public static QualType checkConditionalBlockPointerCompatibility(final Sema /*&*/ S, 
                                         final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, 
                                         final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                                         SourceLocation Loc) {
  QualType LHSTy = LHS.get().getType();
  QualType RHSTy = RHS.get().getType();
  if (!LHSTy.$arrow().isBlockPointerType() || !RHSTy.$arrow().isBlockPointerType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (LHSTy.$arrow().isVoidPointerType() || RHSTy.$arrow().isVoidPointerType()) {
        QualType destType = S.Context.getPointerType(new CanQual<Type>(S.Context.VoidTy)).$QualType();
        LHS.$assignMove(S.ImpCastExprToType(LHS.get(), new QualType(destType), CastKind.CK_BitCast));
        RHS.$assignMove(S.ImpCastExprToType(RHS.get(), new QualType(destType), CastKind.CK_BitCast));
        return destType;
      }
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_typecheck_cond_incompatible_operands)), 
                      LHSTy), RHSTy), LHS.get().getSourceRange()), 
          RHS.get().getSourceRange()));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  
  // We have 2 block pointer types.
  return checkConditionalPointerCompatibility(S, LHS, RHS, new SourceLocation(Loc));
}


/// \brief Return the resulting type when the operands are both pointers.
//<editor-fold defaultstate="collapsed" desc="checkConditionalObjectPointersCompatibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6359,
 FQN="checkConditionalObjectPointersCompatibility", NM="_ZL43checkConditionalObjectPointersCompatibilityRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL43checkConditionalObjectPointersCompatibilityRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationE")
//</editor-fold>
public static QualType checkConditionalObjectPointersCompatibility(final Sema /*&*/ S, final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, 
                                           final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                                           SourceLocation Loc) {
  // get the pointer types
  QualType LHSTy = LHS.get().getType();
  QualType RHSTy = RHS.get().getType();
  
  // get the "pointed to" types
  QualType lhptee = LHSTy.$arrow().getAs(PointerType.class).getPointeeType();
  QualType rhptee = RHSTy.$arrow().getAs(PointerType.class).getPointeeType();
  
  // ignore qualifiers on void (C99 6.5.15p3, clause 6)
  if (lhptee.$arrow().isVoidType() && rhptee.$arrow().isIncompleteOrObjectType()) {
    // Figure out necessary qualifiers (C99 6.5.15p6)
    QualType destPointee = S.Context.getQualifiedType(new QualType(lhptee), rhptee.getQualifiers());
    QualType destType = S.Context.getPointerType(new QualType(destPointee));
    // Add qualifiers if necessary.
    LHS.$assignMove(S.ImpCastExprToType(LHS.get(), new QualType(destType), CastKind.CK_NoOp));
    // Promote to void*.
    RHS.$assignMove(S.ImpCastExprToType(RHS.get(), new QualType(destType), CastKind.CK_BitCast));
    return destType;
  }
  if (rhptee.$arrow().isVoidType() && lhptee.$arrow().isIncompleteOrObjectType()) {
    QualType destPointee = S.Context.getQualifiedType(new QualType(rhptee), lhptee.getQualifiers());
    QualType destType = S.Context.getPointerType(new QualType(destPointee));
    // Add qualifiers if necessary.
    RHS.$assignMove(S.ImpCastExprToType(RHS.get(), new QualType(destType), CastKind.CK_NoOp));
    // Promote to void*.
    LHS.$assignMove(S.ImpCastExprToType(LHS.get(), new QualType(destType), CastKind.CK_BitCast));
    return destType;
  }
  
  return checkConditionalPointerCompatibility(S, LHS, RHS, new SourceLocation(Loc));
}


/// \brief Return false if the first expression is not an integer and the second
/// expression is not a pointer, true otherwise.
//<editor-fold defaultstate="collapsed" desc="checkPointerIntegerMismatch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6399,
 FQN="checkPointerIntegerMismatch", NM="_ZL27checkPointerIntegerMismatchRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES4_NS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL27checkPointerIntegerMismatchRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES4_NS_14SourceLocationEb")
//</editor-fold>
public static boolean checkPointerIntegerMismatch(final Sema /*&*/ S, final ActionResultTTrue<Expr /*P*/ > /*&*/ Int, 
                           Expr /*P*/ PointerExpr, SourceLocation Loc, 
                           boolean IsIntFirstExpr) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (!PointerExpr.getType().$arrow().isPointerType()
       || !Int.get().getType().$arrow().isIntegerType()) {
      return false;
    }
    
    Expr /*P*/ Expr1 = IsIntFirstExpr ? Int.get() : PointerExpr;
    Expr /*P*/ Expr2 = IsIntFirstExpr ? PointerExpr : Int.get();
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.ext_typecheck_cond_pointer_integer_mismatch)), 
                    Expr1.getType()), Expr2.getType()), 
            Expr1.getSourceRange()), Expr2.getSourceRange()));
    Int.$assignMove(S.ImpCastExprToType(Int.get(), PointerExpr.getType(), 
            CastKind.CK_IntegralToPointer));
    return true;
  } finally {
    $c$.$destroy();
  }
}


/// \brief Simple conversion between integer and floating point types.
///
/// Used when handling the OpenCL conditional operator where the
/// condition is a vector while the other operands are scalar.
///
/// OpenCL v1.1 s6.3.i and s6.11.6 together require that the scalar
/// types are either integer or floating type. Between the two
/// operands, the type with the higher rank is defined as the "result
/// type". The other operand needs to be promoted to the same type. No
/// other type promotion is allowed. We cannot use
/// UsualArithmeticConversions() for this purpose, since it always
/// promotes promotable types.
//<editor-fold defaultstate="collapsed" desc="OpenCLArithmeticConversions">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6429,
 FQN="OpenCLArithmeticConversions", NM="_ZL27OpenCLArithmeticConversionsRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL27OpenCLArithmeticConversionsRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationE")
//</editor-fold>
public static QualType OpenCLArithmeticConversions(final Sema /*&*/ S, final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, 
                           final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                           SourceLocation QuestionLoc) {
  LHS.$assignMove(S.DefaultFunctionArrayLvalueConversion(LHS.get()));
  if (LHS.isInvalid()) {
    return new QualType();
  }
  RHS.$assignMove(S.DefaultFunctionArrayLvalueConversion(RHS.get()));
  if (RHS.isInvalid()) {
    return new QualType();
  }
  
  // For conversion purposes, we ignore any qualifiers.
  // For example, "const float" and "float" are equivalent.
  QualType LHSType = S.Context.getCanonicalType(LHS.get().getType()).getUnqualifiedType().$QualType();
  QualType RHSType = S.Context.getCanonicalType(RHS.get().getType()).getUnqualifiedType().$QualType();
  if (!LHSType.$arrow().isIntegerType() && !LHSType.$arrow().isRealFloatingType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(QuestionLoc), diag.err_typecheck_cond_expect_int_float)), 
              LHSType), LHS.get().getSourceRange()));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  if (!RHSType.$arrow().isIntegerType() && !RHSType.$arrow().isRealFloatingType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(QuestionLoc), diag.err_typecheck_cond_expect_int_float)), 
              RHSType), RHS.get().getSourceRange()));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  
  // If both types are identical, no conversion is needed.
  if ($eq_QualType$C(LHSType, RHSType)) {
    return LHSType;
  }
  
  // Now handle "real" floating types (i.e. float, double, long double).
  if (LHSType.$arrow().isRealFloatingType() || RHSType.$arrow().isRealFloatingType()) {
    return handleFloatConversion(S, LHS, RHS, new QualType(LHSType), new QualType(RHSType), 
        /*IsCompAssign = */ false);
  }
  
  // Finally, we have two differing integer types.
  return handleIntegerConversion/*<doIntegralCast, doIntegralCast>*/(SemaExprStatics::doIntegralCast, SemaExprStatics::doIntegralCast, S, LHS, RHS, new QualType(LHSType), new QualType(RHSType), /*IsCompAssign = */ false);
}


/// \brief Convert scalar operands to a vector that matches the
///        condition in length.
///
/// Used when handling the OpenCL conditional operator where the
/// condition is a vector while the other operands are scalar.
///
/// We first compute the "result type" for the scalar operands
/// according to OpenCL v1.1 s6.3.i. Both operands are then converted
/// into a vector of that type where the length matches the condition
/// vector type. s6.11.6 requires that the element types of the result
/// and the condition must have the same number of bits.
//<editor-fold defaultstate="collapsed" desc="OpenCLConvertScalarsToVectors">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6483,
 FQN="OpenCLConvertScalarsToVectors", NM="_ZL29OpenCLConvertScalarsToVectorsRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_8QualTypeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL29OpenCLConvertScalarsToVectorsRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_8QualTypeENS_14SourceLocationE")
//</editor-fold>
public static QualType OpenCLConvertScalarsToVectors(final Sema /*&*/ S, final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                             QualType CondTy, SourceLocation QuestionLoc) {
  QualType ResTy = OpenCLArithmeticConversions(S, LHS, RHS, new SourceLocation(QuestionLoc));
  if (ResTy.isNull()) {
    return new QualType();
  }
  
  /*const*/ VectorType /*P*/ CV = CondTy.$arrow().getAs(VectorType.class);
  assert Native.$bool(CV);
  
  // Determine the vector result type
  /*uint*/int NumElements = CV.getNumElements();
  QualType VectorTy = S.Context.getExtVectorType(new QualType(ResTy), NumElements);
  
  // Ensure that all types have the same number of bits
  if (S.Context.getTypeSize(CV.getElementType())
     != S.Context.getTypeSize(new QualType(ResTy))) {
    raw_svector_ostream OS = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Since VectorTy is created internally, it does not pretty print
      // with an OpenCL name. Instead, we just print a description.
      std.string EleTyName = ResTy.getUnqualifiedType().getAsString();
      SmallString/*64*/ Str/*J*/= new SmallString/*64*/(64);
      OS/*J*/= new raw_svector_ostream(Str);
      OS.$out(/*KEEP_STR*/"(vector of ").$out_uint(NumElements).$out(/*KEEP_STR*/" '").$out(EleTyName).$out(/*KEEP_STR*/"' values)");
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(QuestionLoc), diag.err_conditional_vector_element_size)), 
              CondTy), OS.str()));
      return new QualType();
    } finally {
      if (OS != null) { OS.$destroy(); }
      $c$.$destroy();
    }
  }
  
  // Convert operands to the vector result type
  LHS.$assignMove(S.ImpCastExprToType(LHS.get(), new QualType(VectorTy), CastKind.CK_VectorSplat));
  RHS.$assignMove(S.ImpCastExprToType(RHS.get(), new QualType(VectorTy), CastKind.CK_VectorSplat));
  
  return VectorTy;
}


/// \brief Return false if this is a valid OpenCL condition vector
//<editor-fold defaultstate="collapsed" desc="checkOpenCLConditionVector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6518,
 FQN="checkOpenCLConditionVector", NM="_ZL26checkOpenCLConditionVectorRN5clang4SemaEPNS_4ExprENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL26checkOpenCLConditionVectorRN5clang4SemaEPNS_4ExprENS_14SourceLocationE")
//</editor-fold>
public static boolean checkOpenCLConditionVector(final Sema /*&*/ S, Expr /*P*/ Cond, 
                          SourceLocation QuestionLoc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // OpenCL v1.1 s6.11.6 says the elements of the vector must be of
    // integral type.
    /*const*/ VectorType /*P*/ CondTy = Cond.getType().$arrow().getAs(VectorType.class);
    assert Native.$bool(CondTy);
    QualType EleTy = CondTy.getElementType();
    if (EleTy.$arrow().isIntegerType()) {
      return false;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(QuestionLoc), diag.err_typecheck_cond_expect_nonfloat)), 
            Cond.getType()), Cond.getSourceRange()));
    return true;
  } finally {
    $c$.$destroy();
  }
}


/// \brief Return false if the vector condition type and the vector
///        result type are compatible.
///
/// OpenCL v1.1 s6.11.6 requires that both vector types have the same
/// number of elements, and their element types have the same number
/// of bits.
//<editor-fold defaultstate="collapsed" desc="checkVectorResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6538,
 FQN="checkVectorResult", NM="_ZL17checkVectorResultRN5clang4SemaENS_8QualTypeES2_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL17checkVectorResultRN5clang4SemaENS_8QualTypeES2_NS_14SourceLocationE")
//</editor-fold>
public static boolean checkVectorResult(final Sema /*&*/ S, QualType CondTy, QualType VecResTy, 
                 SourceLocation QuestionLoc) {
  /*const*/ VectorType /*P*/ CV = CondTy.$arrow().getAs(VectorType.class);
  /*const*/ VectorType /*P*/ RV = VecResTy.$arrow().getAs(VectorType.class);
  assert ((CV != null) && (RV != null));
  if (CV.getNumElements() != RV.getNumElements()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(QuestionLoc), diag.err_conditional_vector_size)), 
              CondTy), VecResTy));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  QualType CVE = CV.getElementType();
  QualType RVE = RV.getElementType();
  if (S.Context.getTypeSize(new QualType(CVE)) != S.Context.getTypeSize(new QualType(RVE))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(QuestionLoc), diag.err_conditional_vector_element_size)), 
              CondTy), VecResTy));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}


/// \brief Return the resulting type for the conditional operator in
///        OpenCL (aka "ternary selection operator", OpenCL v1.1
///        s6.3.i) when the condition is a vector type.
//<editor-fold defaultstate="collapsed" desc="OpenCLCheckVectorConditional">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6565,
 FQN="OpenCLCheckVectorConditional", NM="_ZL28OpenCLCheckVectorConditionalRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_S6_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL28OpenCLCheckVectorConditionalRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_S6_NS_14SourceLocationE")
//</editor-fold>
public static QualType OpenCLCheckVectorConditional(final Sema /*&*/ S, final ActionResultTTrue<Expr /*P*/ > /*&*/ Cond, 
                            final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                            SourceLocation QuestionLoc) {
  Cond.$assignMove(S.DefaultFunctionArrayLvalueConversion(Cond.get()));
  if (Cond.isInvalid()) {
    return new QualType();
  }
  QualType CondTy = Cond.get().getType();
  if (checkOpenCLConditionVector(S, Cond.get(), new SourceLocation(QuestionLoc))) {
    return new QualType();
  }
  
  // If either operand is a vector then find the vector type of the
  // result as specified in OpenCL v1.1 s6.3.i.
  if (LHS.get().getType().$arrow().isVectorType()
     || RHS.get().getType().$arrow().isVectorType()) {
    QualType VecResTy = S.CheckVectorOperands(LHS, RHS, new SourceLocation(QuestionLoc), 
        /*isCompAssign*/ false, 
        /*AllowBothBool*/ true, 
        /*AllowBoolConversions*/ false);
    if (VecResTy.isNull()) {
      return new QualType();
    }
    // The result type must match the condition type as specified in
    // OpenCL v1.1 s6.11.6.
    if (checkVectorResult(S, new QualType(CondTy), new QualType(VecResTy), new SourceLocation(QuestionLoc))) {
      return new QualType();
    }
    return VecResTy;
  }
  
  // Both operands are scalar.
  return OpenCLConvertScalarsToVectors(S, LHS, RHS, new QualType(CondTy), new SourceLocation(QuestionLoc));
}


/// \brief Return true if the Expr is block type
//<editor-fold defaultstate="collapsed" desc="checkBlockType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6598,
 FQN="checkBlockType", NM="_ZL14checkBlockTypeRN5clang4SemaEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL14checkBlockTypeRN5clang4SemaEPKNS_4ExprE")
//</editor-fold>
public static boolean checkBlockType(final Sema /*&*/ S, /*const*/ Expr /*P*/ E) {
  {
    /*const*/ CallExpr /*P*/ CE = dyn_cast_CallExpr(E);
    if ((CE != null)) {
      QualType Ty = CE.getCallee$Const().getType();
      if (Ty.$arrow().isBlockPointerType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(E.getExprLoc(), diag.err_opencl_ternary_with_block)));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  return false;
}


/// SuggestParentheses - Emit a note with a fixit hint that wraps
/// ParenRange in parentheses.
//<editor-fold defaultstate="collapsed" desc="SuggestParentheses">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6889,
 FQN="SuggestParentheses", NM="_ZL18SuggestParenthesesRN5clang4SemaENS_14SourceLocationERKNS_17PartialDiagnosticENS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL18SuggestParenthesesRN5clang4SemaENS_14SourceLocationERKNS_17PartialDiagnosticENS_11SourceRangeE")
//</editor-fold>
public static void SuggestParentheses(final Sema /*&*/ Self, SourceLocation Loc, 
                  final /*const*/ PartialDiagnostic /*&*/ Note, 
                  SourceRange ParenRange) {
  SourceLocation EndLoc = Self.getLocForEndOfToken(ParenRange.getEnd());
  if (ParenRange.getBegin().isFileID() && ParenRange.getEnd().isFileID()
     && EndLoc.isValid()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(new SourceLocation(Loc), Note)), 
              FixItHint.CreateInsertion(ParenRange.getBegin(), new StringRef(/*KEEP_STR*/$LPAREN))), 
          FixItHint.CreateInsertion(/*NO_COPY*/EndLoc, new StringRef(/*KEEP_STR*/$RPAREN))));
    } finally {
      $c$.$destroy();
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // We can't display the parentheses, so just show the bare note.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(new SourceLocation(Loc), Note)), ParenRange));
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="IsArithmeticOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6904,
 FQN="IsArithmeticOp", NM="_ZL14IsArithmeticOpN5clang18BinaryOperatorKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL14IsArithmeticOpN5clang18BinaryOperatorKindE")
//</editor-fold>
public static boolean IsArithmeticOp(BinaryOperatorKind Opc) {
  return BinaryOperator.isAdditiveOp(Opc)
     || BinaryOperator.isMultiplicativeOp(Opc)
     || BinaryOperator.isShiftOp(Opc);
}


/// IsArithmeticBinaryExpr - Returns true if E is an arithmetic binary
/// expression, either using a built-in or overloaded operator,
/// and sets *OpCode to the opcode and *RHSExprs to the right-hand side
/// expression.
//<editor-fold defaultstate="collapsed" desc="IsArithmeticBinaryExpr">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6914,
 FQN="IsArithmeticBinaryExpr", NM="_ZL22IsArithmeticBinaryExprPN5clang4ExprEPNS_18BinaryOperatorKindEPS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL22IsArithmeticBinaryExprPN5clang4ExprEPNS_18BinaryOperatorKindEPS1_")
//</editor-fold>
public static boolean IsArithmeticBinaryExpr(Expr /*P*/ E, type$ptr<BinaryOperatorKind /*P*/> Opcode, 
                      type$ptr<Expr/*P*/> RHSExprs) {
  // Don't strip parenthesis: we should not warn if E is in parenthesis.
  E = E.IgnoreImpCasts();
  E = E.IgnoreConversionOperator();
  E = E.IgnoreImpCasts();
  {
    
    // Built-in binary operator.
    BinaryOperator /*P*/ OP = dyn_cast_BinaryOperator(E);
    if ((OP != null)) {
      if (IsArithmeticOp(OP.getOpcode())) {
        Opcode.$set(OP.getOpcode());
        RHSExprs.$set(OP.getRHS());
        return true;
      }
    }
  }
  {
    
    // Overloaded operator.
    CXXOperatorCallExpr /*P*/ Call = dyn_cast_CXXOperatorCallExpr(E);
    if ((Call != null)) {
      if (Call.getNumArgs() != 2) {
        return false;
      }
      
      // Make sure this is really a binary operator that is safe to pass into
      // BinaryOperator::getOverloadedOpcode(), e.g. it's not a subscript op.
      OverloadedOperatorKind OO = Call.getOperator();
      if (OO.getValue() < OverloadedOperatorKind.OO_Plus.getValue() || OO.getValue() > OverloadedOperatorKind.OO_Arrow.getValue()
         || OO == OverloadedOperatorKind.OO_PlusPlus || OO == OverloadedOperatorKind.OO_MinusMinus) {
        return false;
      }
      
      BinaryOperatorKind OpKind = BinaryOperator.getOverloadedOpcode(OO);
      if (IsArithmeticOp(OpKind)) {
        Opcode.$set(OpKind);
        RHSExprs.$set(Call.getArg(1));
        return true;
      }
    }
  }
  
  return false;
}


/// ExprLooksBoolean - Returns true if E looks boolean, i.e. it has boolean type
/// or is a logical expression such as (x==y) which has int type, but is
/// commonly interpreted as boolean.
//<editor-fold defaultstate="collapsed" desc="ExprLooksBoolean">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6956,
 FQN="ExprLooksBoolean", NM="_ZL16ExprLooksBooleanPN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL16ExprLooksBooleanPN5clang4ExprE")
//</editor-fold>
public static boolean ExprLooksBoolean(Expr /*P*/ E) {
  E = E.IgnoreParenImpCasts();
  if (E.getType().$arrow().isBooleanType()) {
    return true;
  }
  {
    BinaryOperator /*P*/ OP = dyn_cast_BinaryOperator(E);
    if ((OP != null)) {
      return OP.isComparisonOp() || OP.isLogicalOp();
    }
  }
  {
    UnaryOperator /*P*/ OP = dyn_cast_UnaryOperator(E);
    if ((OP != null)) {
      return OP.getOpcode() == UnaryOperatorKind.UO_LNot;
    }
  }
  if (E.getType().$arrow().isPointerType()) {
    return true;
  }
  
  return false;
}


/// DiagnoseConditionalPrecedence - Emit a warning when a conditional operator
/// and binary operator are mixed in a way that suggests the programmer assumed
/// the conditional operator has higher precedence, for example:
/// "int x = a + someBinaryCondition ? 1 : 2".
//<editor-fold defaultstate="collapsed" desc="DiagnoseConditionalPrecedence">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 6975,
 FQN="DiagnoseConditionalPrecedence", NM="_ZL29DiagnoseConditionalPrecedenceRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_S4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL29DiagnoseConditionalPrecedenceRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_S4_")
//</editor-fold>
public static void DiagnoseConditionalPrecedence(final Sema /*&*/ Self, 
                             SourceLocation OpLoc, 
                             Expr /*P*/ Condition, 
                             Expr /*P*/ LHSExpr, 
                             Expr /*P*/ RHSExpr) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    type$ptr<BinaryOperatorKind> CondOpcode = create_type$null$ptr();
    type$ptr<Expr /*P*/ > CondRHS = create_type$null$ptr();
    if (!IsArithmeticBinaryExpr(Condition, $AddrOf(CondOpcode), $AddrOf(CondRHS))) {
      return;
    }
    if (!ExprLooksBoolean(CondRHS.$star())) {
      return;
    }
    
    // The condition is an arithmetic binary expression, with a right-
    // hand side that looks boolean, so warn.
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(new SourceLocation(OpLoc), diag.warn_precedence_conditional)), 
            Condition.getSourceRange()), 
        BinaryOperator.getOpcodeStr(CondOpcode.$star())));
    
    SuggestParentheses(Self, new SourceLocation(OpLoc), 
        $out_PartialDiagnostic$C_StringRef($c$.track(Self.PDiag(diag.note_precedence_silence)), 
            BinaryOperator.getOpcodeStr(CondOpcode.$star())), 
        new SourceRange(Condition.getLocStart(), Condition.getLocEnd())); $c$.clean();
    
    SuggestParentheses(Self, new SourceLocation(OpLoc), 
        $c$.track(Self.PDiag(diag.note_precedence_conditional_first)), 
        new SourceRange(CondRHS.$star().getLocStart(), RHSExpr.getLocEnd())); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}


// checkPointerTypesForAssignment - This is a very tricky routine (despite
// being closely modeled after the C99 spec:-). The odd characteristic of this
// routine is it effectively iqnores the qualifiers on the top level pointee.
// This circumvents the usual type rules specified in 6.2.7p1 & 6.7.5.[1-3].
// FIXME: add a couple examples in this comment.
//<editor-fold defaultstate="collapsed" desc="checkPointerTypesForAssignment">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 7101,
 FQN="checkPointerTypesForAssignment", NM="_ZL30checkPointerTypesForAssignmentRN5clang4SemaENS_8QualTypeES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL30checkPointerTypesForAssignmentRN5clang4SemaENS_8QualTypeES2_")
//</editor-fold>
public static Sema.AssignConvertType checkPointerTypesForAssignment(final Sema /*&*/ S, QualType LHSType, QualType RHSType) {
  assert (LHSType.isCanonical()) : "LHS not canonicalized!";
  assert (RHSType.isCanonical()) : "RHS not canonicalized!";
  
  // get the "pointed to" type (ignoring qualifiers at the top level)
  pair<Type, Qualifiers> LPair = cast_PointerType(LHSType).getPointeeType().split().asPair();
  pair<Type, Qualifiers> RPair = cast_PointerType(RHSType).getPointeeType().split().asPair();
  Type /*P*/ lhptee = LPair.first, /*P*/ rhptee = RPair.first;
  Qualifiers lhq/*J*/= LPair.second, rhq/*J*/= RPair.second;
  //std.tie(lhptee, lhq).$assign_pair$_U1$_U2(
  //    cast_PointerType(LHSType).getPointeeType().split().asPair()
  //);
  //std.tie(rhptee, rhq).$assign_pair$_U1$_U2(
  //    cast_PointerType(RHSType).getPointeeType().split().asPair()
  //);
  
  Sema.AssignConvertType ConvTy = Sema.AssignConvertType.Compatible;
  
  // C99 6.5.16.1p1: This following citation is common to constraints
  // 3 & 4 (below). ...and the type *pointed to* by the left has all the
  // qualifiers of the type *pointed to* by the right;
  
  // As a special case, 'non-__weak A *' -> 'non-__weak const *' is okay.
  if (lhq.getObjCLifetime() != rhq.getObjCLifetime()
     && lhq.compatiblyIncludesObjCLifetime(new Qualifiers(rhq))) {
    // Ignore lifetime for further calculation.
    lhq.removeObjCLifetime();
    rhq.removeObjCLifetime();
  }
  if (!lhq.compatiblyIncludes(new Qualifiers(rhq))) {
    // Treat address-space mismatches as fatal.  TODO: address subspaces
    if (!lhq.isAddressSpaceSupersetOf(new Qualifiers(rhq))) {
      ConvTy = Sema.AssignConvertType.IncompatiblePointerDiscardsQualifiers;
    } else 
    // It's okay to add or remove GC or lifetime qualifiers when converting to
    // and from void*.
    if (lhq.withoutObjCGCAttr().withoutObjCLifetime().
        compatiblyIncludes(rhq.withoutObjCGCAttr().withoutObjCLifetime())
       && (lhptee.isVoidType() || rhptee.isVoidType())) {
      ; // keep old
    } else 
    // Treat lifetime mismatches as fatal.
    if (lhq.getObjCLifetime() != rhq.getObjCLifetime()) {
      ConvTy = Sema.AssignConvertType.IncompatiblePointerDiscardsQualifiers;
    } else {
      
      // For GCC/MS compatibility, other qualifier mismatches are treated
      // as still compatible in C.
      ConvTy = Sema.AssignConvertType.CompatiblePointerDiscardsQualifiers;
    }
  }
  
  // C99 6.5.16.1p1 (constraint 4): If one operand is a pointer to an object or
  // incomplete type and the other is a pointer to a qualified or unqualified
  // version of void...
  if (lhptee.isVoidType()) {
    if (rhptee.isIncompleteOrObjectType()) {
      return ConvTy;
    }
    
    // As an extension, we allow cast to/from void* to function pointer.
    assert (rhptee.isFunctionType());
    return Sema.AssignConvertType.FunctionVoidPointer;
  }
  if (rhptee.isVoidType()) {
    if (lhptee.isIncompleteOrObjectType()) {
      return ConvTy;
    }
    
    // As an extension, we allow cast to/from void* to function pointer.
    assert (lhptee.isFunctionType());
    return Sema.AssignConvertType.FunctionVoidPointer;
  }
  
  // C99 6.5.16.1p1 (constraint 3): both operands are pointers to qualified or
  // unqualified versions of compatible types, ...
  QualType ltrans = new QualType(lhptee, 0), rtrans = new QualType(rhptee, 0);
  if (!S.Context.typesAreCompatible(new QualType(ltrans), new QualType(rtrans))) {
    // Check if the pointee types are compatible ignoring the sign.
    // We explicitly check for char so that we catch "char" vs
    // "unsigned char" on systems where "char" is unsigned.
    if (lhptee.isCharType()) {
      ltrans.$assignMove(S.Context.UnsignedCharTy.$QualType());
    } else if (lhptee.hasSignedIntegerRepresentation()) {
      ltrans.$assignMove(S.Context.getCorrespondingUnsignedType(new QualType(ltrans)));
    }
    if (rhptee.isCharType()) {
      rtrans.$assignMove(S.Context.UnsignedCharTy.$QualType());
    } else if (rhptee.hasSignedIntegerRepresentation()) {
      rtrans.$assignMove(S.Context.getCorrespondingUnsignedType(new QualType(rtrans)));
    }
    if ($eq_QualType$C(ltrans, rtrans)) {
      // Types are compatible ignoring the sign. Qualifier incompatibility
      // takes priority over sign incompatibility because the sign
      // warning can be disabled.
      if (ConvTy != Sema.AssignConvertType.Compatible) {
        return ConvTy;
      }
      
      return Sema.AssignConvertType.IncompatiblePointerSign;
    }
    
    // If we are a multi-level pointer, it's possible that our issue is simply
    // one of qualification - e.g. char ** -> const char ** is not allowed. If
    // the eventual target type is the same and the pointers have the same
    // level of indirection, this must be the issue.
    if (isa_PointerType(lhptee) && isa_PointerType(rhptee)) {
      do {
        lhptee = cast_PointerType(lhptee).getPointeeType().getTypePtr();
        rhptee = cast_PointerType(rhptee).getPointeeType().getTypePtr();
      } while (isa_PointerType(lhptee) && isa_PointerType(rhptee));
      if (lhptee == rhptee) {
        return Sema.AssignConvertType.IncompatibleNestedPointerQualifiers;
      }
    }
    
    // General pointer incompatibility takes priority over qualifiers.
    return Sema.AssignConvertType.IncompatiblePointer;
  }
  if (!S.getLangOpts().CPlusPlus
     && S.IsNoReturnConversion(new QualType(ltrans), new QualType(rtrans), ltrans)) {
    return Sema.AssignConvertType.IncompatiblePointer;
  }
  return ConvTy;
}


/// checkBlockPointerTypesForAssignment - This routine determines whether two
/// block pointer types are compatible or whether a block and normal pointer
/// are compatible. It is more restrict than comparing two function pointer
// types.
//<editor-fold defaultstate="collapsed" desc="checkBlockPointerTypesForAssignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 7225,
 FQN="checkBlockPointerTypesForAssignment", NM="_ZL35checkBlockPointerTypesForAssignmentRN5clang4SemaENS_8QualTypeES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL35checkBlockPointerTypesForAssignmentRN5clang4SemaENS_8QualTypeES2_")
//</editor-fold>
public static Sema.AssignConvertType checkBlockPointerTypesForAssignment(final Sema /*&*/ S, QualType LHSType, 
                                   QualType RHSType) {
  assert (LHSType.isCanonical()) : "LHS not canonicalized!";
  assert (RHSType.isCanonical()) : "RHS not canonicalized!";
  
  QualType lhptee/*J*/= new QualType(), rhptee/*J*/= new QualType();
  
  // get the "pointed to" type (ignoring qualifiers at the top level)
  lhptee.$assignMove(cast_BlockPointerType(LHSType).getPointeeType());
  rhptee.$assignMove(cast_BlockPointerType(RHSType).getPointeeType());
  
  // In C++, the types have to match exactly.
  if (S.getLangOpts().CPlusPlus) {
    return Sema.AssignConvertType.IncompatibleBlockPointer;
  }
  
  Sema.AssignConvertType ConvTy = Sema.AssignConvertType.Compatible;
  
  // For blocks we enforce that qualifiers are identical.
  if (lhptee.getLocalQualifiers().$noteq(rhptee.getLocalQualifiers())) {
    ConvTy = Sema.AssignConvertType.CompatiblePointerDiscardsQualifiers;
  }
  if (!S.Context.typesAreBlockPointerCompatible(new QualType(LHSType), new QualType(RHSType))) {
    return Sema.AssignConvertType.IncompatibleBlockPointer;
  }
  
  return ConvTy;
}


/// checkObjCPointerTypesForAssignment - Compares two objective-c pointer types
/// for assignment compatibility.
//<editor-fold defaultstate="collapsed" desc="checkObjCPointerTypesForAssignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 7255,
 FQN="checkObjCPointerTypesForAssignment", NM="_ZL34checkObjCPointerTypesForAssignmentRN5clang4SemaENS_8QualTypeES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL34checkObjCPointerTypesForAssignmentRN5clang4SemaENS_8QualTypeES2_")
//</editor-fold>
public static Sema.AssignConvertType checkObjCPointerTypesForAssignment(final Sema /*&*/ S, QualType LHSType, 
                                  QualType RHSType) {
  assert (LHSType.isCanonical()) : "LHS was not canonicalized!";
  assert (RHSType.isCanonical()) : "RHS was not canonicalized!";
  if (LHSType.$arrow().isObjCBuiltinType()) {
    // Class is not compatible with ObjC object pointers.
    if (LHSType.$arrow().isObjCClassType() && !RHSType.$arrow().isObjCBuiltinType()
       && !RHSType.$arrow().isObjCQualifiedClassType()) {
      return Sema.AssignConvertType.IncompatiblePointer;
    }
    return Sema.AssignConvertType.Compatible;
  }
  if (RHSType.$arrow().isObjCBuiltinType()) {
    if (RHSType.$arrow().isObjCClassType() && !LHSType.$arrow().isObjCBuiltinType()
       && !LHSType.$arrow().isObjCQualifiedClassType()) {
      return Sema.AssignConvertType.IncompatiblePointer;
    }
    return Sema.AssignConvertType.Compatible;
  }
  QualType lhptee = LHSType.$arrow().getAs(ObjCObjectPointerType.class).getPointeeType();
  QualType rhptee = RHSType.$arrow().getAs(ObjCObjectPointerType.class).getPointeeType();
  if (!lhptee.isAtLeastAsQualifiedAs(new QualType(rhptee))
    // make an exception for id<P>
     && !LHSType.$arrow().isObjCQualifiedIdType()) {
    return Sema.AssignConvertType.CompatiblePointerDiscardsQualifiers;
  }
  if (S.Context.typesAreCompatible(new QualType(LHSType), new QualType(RHSType))) {
    return Sema.AssignConvertType.Compatible;
  }
  if (LHSType.$arrow().isObjCQualifiedIdType() || RHSType.$arrow().isObjCQualifiedIdType()) {
    return Sema.AssignConvertType.IncompatibleObjCQualifiedId;
  }
  return Sema.AssignConvertType.IncompatiblePointer;
}


/// \brief Constructs a transparent union from an expression that is
/// used to initialize the transparent union.
//<editor-fold defaultstate="collapsed" desc="ConstructTransparentUnion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 7606,
 FQN="ConstructTransparentUnion", NM="_ZL25ConstructTransparentUnionRN5clang4SemaERNS_10ASTContextERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeEPNS_9FieldDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL25ConstructTransparentUnionRN5clang4SemaERNS_10ASTContextERNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeEPNS_9FieldDeclE")
//</editor-fold>
public static void ConstructTransparentUnion(final Sema /*&*/ S, final ASTContext /*&*/ C, 
                         final ActionResultTTrue<Expr /*P*/ > /*&*/ EResult, QualType UnionType, 
                         FieldDecl /*P*/ Field) {
  // Build an initializer list that designates the appropriate member
  // of the transparent union.
  Expr /*P*/ E = EResult.get();
  InitListExpr /*P*/ Initializer = /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->new InitListExpr(C, new SourceLocation(), 
      new ArrayRef<Expr /*P*/ >(E, true), new SourceLocation()));
  Initializer.setType(new QualType(UnionType));
  Initializer.setInitializedFieldInUnion(Field);
  
  // Build a compound literal constructing a value of the transparent
  // union type from this initializer list.
  TypeSourceInfo /*P*/ unionTInfo = C.getTrivialTypeSourceInfo(new QualType(UnionType));
  EResult.$assign(/*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->new CompoundLiteralExpr(new SourceLocation(), unionTInfo, new QualType(UnionType), 
          ExprValueKind.VK_RValue, Initializer, false)));
}


/// Try to convert a value of non-vector type to a vector type by converting
/// the type to the element type of the vector and then performing a splat.
/// If the language is OpenCL, we only use conversions that promote scalar
/// rank; for C, Obj-C, and C++ we allow any real scalar conversion except
/// for float->int.
///
/// \param scalar - if non-null, actually perform the conversions
/// \return true if the operation fails (but without diagnosing the failure)
//<editor-fold defaultstate="collapsed" desc="tryVectorConvertAndSplat">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 7831,
 FQN="tryVectorConvertAndSplat", NM="_ZL24tryVectorConvertAndSplatRN5clang4SemaEPNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeES7_S7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL24tryVectorConvertAndSplatRN5clang4SemaEPNS_12ActionResultIPNS_4ExprELb1EEENS_8QualTypeES7_S7_")
//</editor-fold>
public static boolean tryVectorConvertAndSplat(final Sema /*&*/ S, ActionResultTTrue<Expr /*P*/ > /*P*/ scalar, 
                        QualType scalarTy, 
                        QualType vectorEltTy, 
                        QualType vectorTy) {
  // The conversion to apply to the scalar before splatting it,
  // if necessary.
  CastKind scalarCast = CK_Invalid;
  if (vectorEltTy.$arrow().isIntegralType(S.Context)) {
    if (!scalarTy.$arrow().isIntegralType(S.Context)) {
      return true;
    }
    if (S.getLangOpts().OpenCL
       && S.Context.getIntegerTypeOrder(new QualType(vectorEltTy), new QualType(scalarTy)) < 0) {
      return true;
    }
    scalarCast = CastKind.CK_IntegralCast;
  } else if (vectorEltTy.$arrow().isRealFloatingType()) {
    if (scalarTy.$arrow().isRealFloatingType()) {
      if (S.getLangOpts().OpenCL
         && S.Context.getFloatingTypeOrder(new QualType(vectorEltTy), new QualType(scalarTy)) < 0) {
        return true;
      }
      scalarCast = CastKind.CK_FloatingCast;
    } else if (scalarTy.$arrow().isIntegralType(S.Context)) {
      scalarCast = CastKind.CK_IntegralToFloating;
    } else {
      return true;
    }
  } else {
    return true;
  }
  
  // Adjust scalar if desired.
  if ((scalar != null)) {
    if (scalarCast != CK_Invalid) {
      /*Deref*/scalar.$assignMove(S.ImpCastExprToType(scalar.get(), new QualType(vectorEltTy), scalarCast));
    }
    /*Deref*/scalar.$assignMove(S.ImpCastExprToType(scalar.get(), new QualType(vectorTy), CastKind.CK_VectorSplat));
  }
  return false;
}


// checkArithmeticNull - Detect when a NULL constant is used improperly in an
// expression.  These are mainly cases where the null pointer is used as an
// integer instead of a pointer.
//<editor-fold defaultstate="collapsed" desc="checkArithmeticNull">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 7997,
 FQN="checkArithmeticNull", NM="_ZL19checkArithmeticNullRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL19checkArithmeticNullRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationEb")
//</editor-fold>
public static void checkArithmeticNull(final Sema /*&*/ S, final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                   SourceLocation Loc, boolean IsCompare) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // The canonical way to check for a GNU null is with isNullPointerConstant,
    // but we use a bit of a hack here for speed; this is a relatively
    // hot path, and isNullPointerConstant is slow.
    boolean LHSNull = isa_GNUNullExpr(LHS.get().IgnoreParenImpCasts());
    boolean RHSNull = isa_GNUNullExpr(RHS.get().IgnoreParenImpCasts());
    
    QualType NonNullType = LHSNull ? RHS.get().getType() : LHS.get().getType();
    
    // Avoid analyzing cases where the result will either be invalid (and
    // diagnosed as such) or entirely valid and not something to warn about.
    if ((!LHSNull && !RHSNull) || NonNullType.$arrow().isBlockPointerType()
       || NonNullType.$arrow().isMemberPointerType() || NonNullType.$arrow().isFunctionType()) {
      return;
    }
    
    // Comparison operations would not make sense with a null pointer no matter
    // what the other expression is.
    if (!IsCompare) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.warn_null_in_arithmetic_operation)), 
              (LHSNull ? LHS.get().getSourceRange() : new SourceRange())), 
          (RHSNull ? RHS.get().getSourceRange() : new SourceRange())));
      return;
    }
    
    // The rest of the operations only make sense with a null pointer
    // if the other expression is a pointer.
    if (LHSNull == RHSNull || NonNullType.$arrow().isAnyPointerType()
       || NonNullType.$arrow().canDecayToPointerType()) {
      return;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.warn_null_in_comparison_operation)), 
                    LHSNull/* LHS is NULL */), NonNullType), 
            LHS.get().getSourceRange()), RHS.get().getSourceRange()));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="DiagnoseBadDivideOrRemainderValues">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8033,
 FQN="DiagnoseBadDivideOrRemainderValues", NM="_ZL34DiagnoseBadDivideOrRemainderValuesRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL34DiagnoseBadDivideOrRemainderValuesRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationEb")
//</editor-fold>
public static void DiagnoseBadDivideOrRemainderValues(final Sema /*&*/ S, final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, 
                                  final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                                  SourceLocation Loc, boolean IsDiv) {
  // Check for division/remainder by zero.
  APSInt RHSValue/*J*/= new APSInt();
  if (!RHS.get().isValueDependent()
     && RHS.get().EvaluateAsInt(RHSValue, S.Context) && RHSValue.$eq(0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(S.DiagRuntimeBehavior(new SourceLocation(Loc), RHS.get(), 
          $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_int($c$.track(S.PDiag(diag.warn_remainder_division_by_zero)), 
                  (IsDiv ? 1 : 0)), RHS.get().getSourceRange())));
    } finally {
      $c$.$destroy();
    }
  }
}


/// \brief Diagnose invalid arithmetic on two void pointers.
//<editor-fold defaultstate="collapsed" desc="diagnoseArithmeticOnTwoVoidPointers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8093,
 FQN="diagnoseArithmeticOnTwoVoidPointers", NM="_ZL35diagnoseArithmeticOnTwoVoidPointersRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL35diagnoseArithmeticOnTwoVoidPointersRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_")
//</editor-fold>
public static void diagnoseArithmeticOnTwoVoidPointers(final Sema /*&*/ S, SourceLocation Loc, 
                                   Expr /*P*/ LHSExpr, Expr /*P*/ RHSExpr) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), S.getLangOpts().CPlusPlus ? diag.err_typecheck_pointer_arith_void_type : diag.ext_gnu_void_ptr)), 
                1/* two pointers */), LHSExpr.getSourceRange()), 
        RHSExpr.getSourceRange()));
  } finally {
    $c$.$destroy();
  }
}


/// \brief Diagnose invalid arithmetic on a void pointer.
//<editor-fold defaultstate="collapsed" desc="diagnoseArithmeticOnVoidPointer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8103,
 FQN="diagnoseArithmeticOnVoidPointer", NM="_ZL31diagnoseArithmeticOnVoidPointerRN5clang4SemaENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL31diagnoseArithmeticOnVoidPointerRN5clang4SemaENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public static void diagnoseArithmeticOnVoidPointer(final Sema /*&*/ S, SourceLocation Loc, 
                               Expr /*P*/ Pointer) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), S.getLangOpts().CPlusPlus ? diag.err_typecheck_pointer_arith_void_type : diag.ext_gnu_void_ptr)), 
            0/* one pointer */), Pointer.getSourceRange()));
  } finally {
    $c$.$destroy();
  }
}


/// \brief Diagnose invalid arithmetic on two function pointers.
//<editor-fold defaultstate="collapsed" desc="diagnoseArithmeticOnTwoFunctionPointers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8112,
 FQN="diagnoseArithmeticOnTwoFunctionPointers", NM="_ZL39diagnoseArithmeticOnTwoFunctionPointersRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL39diagnoseArithmeticOnTwoFunctionPointersRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_")
//</editor-fold>
public static void diagnoseArithmeticOnTwoFunctionPointers(final Sema /*&*/ S, SourceLocation Loc, 
                                       Expr /*P*/ LHS, Expr /*P*/ RHS) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert (LHS.getType().$arrow().isAnyPointerType());
    assert (RHS.getType().$arrow().isAnyPointerType());
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), S.getLangOpts().CPlusPlus ? diag.err_typecheck_pointer_arith_function_type : diag.ext_gnu_ptr_func_arith)), 
                            1/* two pointers */), LHS.getType().$arrow().getPointeeType()), 
                    // We only show the second type if it differs from the first.
                    (/*uint*/int)((!S.Context.hasSameUnqualifiedType(LHS.getType(), 
                        RHS.getType())) ? 1 : 0)), 
                RHS.getType().$arrow().getPointeeType()), 
            LHS.getSourceRange()), RHS.getSourceRange()));
  } finally {
    $c$.$destroy();
  }
}


/// \brief Diagnose invalid arithmetic on a function pointer.
//<editor-fold defaultstate="collapsed" desc="diagnoseArithmeticOnFunctionPointer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8128,
 FQN="diagnoseArithmeticOnFunctionPointer", NM="_ZL35diagnoseArithmeticOnFunctionPointerRN5clang4SemaENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL35diagnoseArithmeticOnFunctionPointerRN5clang4SemaENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public static void diagnoseArithmeticOnFunctionPointer(final Sema /*&*/ S, SourceLocation Loc, 
                                   Expr /*P*/ Pointer) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert (Pointer.getType().$arrow().isAnyPointerType());
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), S.getLangOpts().CPlusPlus ? diag.err_typecheck_pointer_arith_function_type : diag.ext_gnu_ptr_func_arith)), 
                    0/* one pointer */), Pointer.getType().$arrow().getPointeeType()), 
            0/* one pointer, so only one type */), 
        Pointer.getSourceRange()));
  } finally {
    $c$.$destroy();
  }
}


/// \brief Emit error if Operand is incomplete pointer type
///
/// \returns True if pointer has incomplete type
//<editor-fold defaultstate="collapsed" desc="checkArithmeticIncompletePointerType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8142,
 FQN="checkArithmeticIncompletePointerType", NM="_ZL36checkArithmeticIncompletePointerTypeRN5clang4SemaENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL36checkArithmeticIncompletePointerTypeRN5clang4SemaENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public static boolean checkArithmeticIncompletePointerType(final Sema /*&*/ S, SourceLocation Loc, 
                                    Expr /*P*/ Operand) {
  QualType ResType = Operand.getType();
  {
    /*const*/ AtomicType /*P*/ ResAtomicType = ResType.$arrow().getAs(AtomicType.class);
    if ((ResAtomicType != null)) {
      ResType.$assignMove(ResAtomicType.getValueType());
    }
  }
  assert (ResType.$arrow().isAnyPointerType() && !ResType.$arrow().isDependentType());
  QualType PointeeTy = ResType.$arrow().getPointeeType();
  return S.RequireCompleteType$T(new SourceLocation(Loc), new QualType(PointeeTy), 
      diag.err_typecheck_arithmetic_incomplete_type, 
      PointeeTy, Operand.getSourceRange());
}


/// \brief Check the validity of an arithmetic pointer operand.
///
/// If the operand has pointer type, this code will check for pointer types
/// which are invalid in arithmetic operations. These will be diagnosed
/// appropriately, including whether or not the use is supported as an
/// extension.
///
/// \returns True when the operand is valid to use (even if as an extension).
//<editor-fold defaultstate="collapsed" desc="checkArithmeticOpPointerOperand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8163,
 FQN="checkArithmeticOpPointerOperand", NM="_ZL31checkArithmeticOpPointerOperandRN5clang4SemaENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL31checkArithmeticOpPointerOperandRN5clang4SemaENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public static boolean checkArithmeticOpPointerOperand(final Sema /*&*/ S, SourceLocation Loc, 
                               Expr /*P*/ Operand) {
  QualType ResType = Operand.getType();
  {
    /*const*/ AtomicType /*P*/ ResAtomicType = ResType.$arrow().getAs(AtomicType.class);
    if ((ResAtomicType != null)) {
      ResType.$assignMove(ResAtomicType.getValueType());
    }
  }
  if (!ResType.$arrow().isAnyPointerType()) {
    return true;
  }
  
  QualType PointeeTy = ResType.$arrow().getPointeeType();
  if (PointeeTy.$arrow().isVoidType()) {
    diagnoseArithmeticOnVoidPointer(S, new SourceLocation(Loc), Operand);
    return !S.getLangOpts().CPlusPlus;
  }
  if (PointeeTy.$arrow().isFunctionType()) {
    diagnoseArithmeticOnFunctionPointer(S, new SourceLocation(Loc), Operand);
    return !S.getLangOpts().CPlusPlus;
  }
  if (checkArithmeticIncompletePointerType(S, new SourceLocation(Loc), Operand)) {
    return false;
  }
  
  return true;
}


/// \brief Check the validity of a binary arithmetic operation w.r.t. pointer
/// operands.
///
/// This routine will diagnose any invalid arithmetic on pointer operands much
/// like \see checkArithmeticOpPointerOperand. However, it has special logic
/// for emitting a single diagnostic even for operations where both LHS and RHS
/// are (potentially problematic) pointers.
///
/// \returns True when the operand is valid to use (even if as an extension).
//<editor-fold defaultstate="collapsed" desc="checkArithmeticBinOpPointerOperands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8195,
 FQN="checkArithmeticBinOpPointerOperands", NM="_ZL35checkArithmeticBinOpPointerOperandsRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL35checkArithmeticBinOpPointerOperandsRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_")
//</editor-fold>
public static boolean checkArithmeticBinOpPointerOperands(final Sema /*&*/ S, SourceLocation Loc, 
                                   Expr /*P*/ LHSExpr, Expr /*P*/ RHSExpr) {
  boolean isLHSPointer = LHSExpr.getType().$arrow().isAnyPointerType();
  boolean isRHSPointer = RHSExpr.getType().$arrow().isAnyPointerType();
  if (!isLHSPointer && !isRHSPointer) {
    return true;
  }
  
  QualType LHSPointeeTy/*J*/= new QualType(), RHSPointeeTy/*J*/= new QualType();
  if (isLHSPointer) {
    LHSPointeeTy.$assignMove(LHSExpr.getType().$arrow().getPointeeType());
  }
  if (isRHSPointer) {
    RHSPointeeTy.$assignMove(RHSExpr.getType().$arrow().getPointeeType());
  }
  
  // if both are pointers check if operation is valid wrt address spaces
  if (S.getLangOpts().OpenCL && isLHSPointer && isRHSPointer) {
    /*const*/ PointerType /*P*/ lhsPtr = LHSExpr.getType().$arrow().getAs(PointerType.class);
    /*const*/ PointerType /*P*/ rhsPtr = RHSExpr.getType().$arrow().getAs(PointerType.class);
    if (!lhsPtr.isAddressSpaceOverlapping($Deref(rhsPtr))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), 
                                diag.err_typecheck_op_on_nonoverlapping_address_space_pointers)), 
                            LHSExpr.getType()), RHSExpr.getType()), 1/*arithmetic op*/), 
                LHSExpr.getSourceRange()), RHSExpr.getSourceRange()));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Check for arithmetic on pointers to incomplete types.
  boolean isLHSVoidPtr = isLHSPointer && LHSPointeeTy.$arrow().isVoidType();
  boolean isRHSVoidPtr = isRHSPointer && RHSPointeeTy.$arrow().isVoidType();
  if (isLHSVoidPtr || isRHSVoidPtr) {
    if (!isRHSVoidPtr) {
      diagnoseArithmeticOnVoidPointer(S, new SourceLocation(Loc), LHSExpr);
    } else if (!isLHSVoidPtr) {
      diagnoseArithmeticOnVoidPointer(S, new SourceLocation(Loc), RHSExpr);
    } else {
      diagnoseArithmeticOnTwoVoidPointers(S, new SourceLocation(Loc), LHSExpr, RHSExpr);
    }
    
    return !S.getLangOpts().CPlusPlus;
  }
  
  boolean isLHSFuncPtr = isLHSPointer && LHSPointeeTy.$arrow().isFunctionType();
  boolean isRHSFuncPtr = isRHSPointer && RHSPointeeTy.$arrow().isFunctionType();
  if (isLHSFuncPtr || isRHSFuncPtr) {
    if (!isRHSFuncPtr) {
      diagnoseArithmeticOnFunctionPointer(S, new SourceLocation(Loc), LHSExpr);
    } else if (!isLHSFuncPtr) {
      diagnoseArithmeticOnFunctionPointer(S, new SourceLocation(Loc), 
          RHSExpr);
    } else {
      diagnoseArithmeticOnTwoFunctionPointers(S, new SourceLocation(Loc), LHSExpr, RHSExpr);
    }
    
    return !S.getLangOpts().CPlusPlus;
  }
  if (isLHSPointer && checkArithmeticIncompletePointerType(S, new SourceLocation(Loc), LHSExpr)) {
    return false;
  }
  if (isRHSPointer && checkArithmeticIncompletePointerType(S, new SourceLocation(Loc), RHSExpr)) {
    return false;
  }
  
  return true;
}


/// diagnoseStringPlusInt - Emit a warning when adding an integer to a string
/// literal.
//<editor-fold defaultstate="collapsed" desc="diagnoseStringPlusInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8250,
 FQN="diagnoseStringPlusInt", NM="_ZL21diagnoseStringPlusIntRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL21diagnoseStringPlusIntRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_")
//</editor-fold>
public static void diagnoseStringPlusInt(final Sema /*&*/ Self, SourceLocation OpLoc, 
                     Expr /*P*/ LHSExpr, Expr /*P*/ RHSExpr) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    StringLiteral /*P*/ StrExpr = dyn_cast_StringLiteral(LHSExpr.IgnoreImpCasts());
    Expr /*P*/ IndexExpr = RHSExpr;
    if (!(StrExpr != null)) {
      StrExpr = dyn_cast_StringLiteral(RHSExpr.IgnoreImpCasts());
      IndexExpr = LHSExpr;
    }
    
    boolean IsStringPlusInt = (StrExpr != null)
       && IndexExpr.getType().$arrow().isIntegralOrUnscopedEnumerationType();
    if (!IsStringPlusInt || IndexExpr.isValueDependent()) {
      return;
    }
    
    APSInt index/*J*/= new APSInt();
    if (IndexExpr.EvaluateAsInt(index, Self.getASTContext())) {
      /*uint*/int StrLenWithNull = StrExpr.getLength() + 1;
      if (index.isNonNegative()
         && index.$lesseq(new APSInt(new APInt(index.getBitWidth(), $uint2ulong(StrLenWithNull)), 
              index.isUnsigned()))) {
        return;
      }
    }
    
    SourceRange DiagRange/*J*/= new SourceRange(LHSExpr.getLocStart(), RHSExpr.getLocEnd());
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(new SourceLocation(OpLoc), diag.warn_string_plus_int)), 
            DiagRange), IndexExpr.IgnoreImpCasts().getType()));
    
    // Only print a fixit for "str" + int, not for int + "str".
    if (IndexExpr == RHSExpr) {
      SourceLocation EndLoc = Self.getLocForEndOfToken(RHSExpr.getLocEnd());
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(new SourceLocation(OpLoc), diag.note_string_plus_scalar_silence)), 
                  FixItHint.CreateInsertion(LHSExpr.getLocStart(), new StringRef(/*KEEP_STR*/$AMP))), 
              FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/OpLoc), new StringRef(/*KEEP_STR*/$LSQUARE))), 
          FixItHint.CreateInsertion(/*NO_COPY*/EndLoc, new StringRef(/*KEEP_STR*/$RSQUARE))));
    } else {
      $c$.clean($c$.track(Self.Diag(new SourceLocation(OpLoc), diag.note_string_plus_scalar_silence)));
    }
  } finally {
    $c$.$destroy();
  }
}


/// \brief Emit a warning when adding a char literal to a string.
//<editor-fold defaultstate="collapsed" desc="diagnoseStringPlusChar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8289,
 FQN="diagnoseStringPlusChar", NM="_ZL22diagnoseStringPlusCharRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL22diagnoseStringPlusCharRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_")
//</editor-fold>
public static void diagnoseStringPlusChar(final Sema /*&*/ Self, SourceLocation OpLoc, 
                      Expr /*P*/ LHSExpr, Expr /*P*/ RHSExpr) {
  /*const*/ Expr /*P*/ StringRefExpr = LHSExpr;
  /*const*/ CharacterLiteral /*P*/ CharExpr = dyn_cast_CharacterLiteral(RHSExpr.IgnoreImpCasts());
  if (!(CharExpr != null)) {
    CharExpr = dyn_cast_CharacterLiteral(LHSExpr.IgnoreImpCasts());
    StringRefExpr = RHSExpr;
  }
  if (!(CharExpr != null) || !(StringRefExpr != null)) {
    return;
  }
  
  /*const*/ QualType StringType = StringRefExpr.getType();
  
  // Return if not a PointerType.
  if (!StringType.$arrow().isAnyPointerType()) {
    return;
  }
  
  // Return if not a CharacterType.
  if (!StringType.$arrow().getPointeeType().$arrow().isAnyCharacterType()) {
    return;
  }
  
  final ASTContext /*&*/ Ctx = Self.getASTContext();
  SourceRange DiagRange/*J*/= new SourceRange(LHSExpr.getLocStart(), RHSExpr.getLocEnd());
  
  /*const*/ QualType CharType = CharExpr.getType();
  if (!CharType.$arrow().isAnyCharacterType()
     && CharType.$arrow().isIntegerType()
     && llvm.isUIntN($ulong2uint(Ctx.getCharWidth()), $uint2ulong(CharExpr.getValue()))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(new SourceLocation(OpLoc), diag.warn_string_plus_char)), 
              DiagRange), Ctx.CharTy));
    } finally {
      $c$.$destroy();
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(new SourceLocation(OpLoc), diag.warn_string_plus_char)), 
              DiagRange), CharExpr.getType()));
    } finally {
      $c$.$destroy();
    }
  }
  
  // Only print a fixit for str + char, not for char + str.
  if (isa_CharacterLiteral(RHSExpr.IgnoreImpCasts())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SourceLocation EndLoc = Self.getLocForEndOfToken(RHSExpr.getLocEnd());
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(new SourceLocation(OpLoc), diag.note_string_plus_scalar_silence)), 
                  FixItHint.CreateInsertion(LHSExpr.getLocStart(), new StringRef(/*KEEP_STR*/$AMP))), 
              FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/OpLoc), new StringRef(/*KEEP_STR*/$LSQUARE))), 
          FixItHint.CreateInsertion(/*NO_COPY*/EndLoc, new StringRef(/*KEEP_STR*/$RSQUARE))));
    } finally {
      $c$.$destroy();
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(Self.Diag(new SourceLocation(OpLoc), diag.note_string_plus_scalar_silence)));
    } finally {
      $c$.$destroy();
    }
  }
}


/// \brief Emit error when two pointers are incompatible.
//<editor-fold defaultstate="collapsed" desc="diagnosePointerIncompatibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8340,
 FQN="diagnosePointerIncompatibility", NM="_ZL30diagnosePointerIncompatibilityRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL30diagnosePointerIncompatibilityRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_")
//</editor-fold>
public static void diagnosePointerIncompatibility(final Sema /*&*/ S, SourceLocation Loc, 
                              Expr /*P*/ LHSExpr, Expr /*P*/ RHSExpr) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert (LHSExpr.getType().$arrow().isAnyPointerType());
    assert (RHSExpr.getType().$arrow().isAnyPointerType());
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_typecheck_sub_ptr_compatible)), 
                    LHSExpr.getType()), RHSExpr.getType()), LHSExpr.getSourceRange()), 
        RHSExpr.getSourceRange()));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="isScopedEnumerationType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8521,
 FQN="isScopedEnumerationType", NM="_ZL23isScopedEnumerationTypeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL23isScopedEnumerationTypeN5clang8QualTypeE")
//</editor-fold>
public static boolean isScopedEnumerationType(QualType T) {
  {
    /*const*/ EnumType /*P*/ ET = T.$arrow().<EnumType>getAs$EnumType();
    if ((ET != null)) {
      return ET.getDecl().isScoped();
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="DiagnoseBadShiftValues">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8527,
 FQN="DiagnoseBadShiftValues", NM="_ZL22DiagnoseBadShiftValuesRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationENS_18BinaryOperatorKindENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL22DiagnoseBadShiftValuesRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationENS_18BinaryOperatorKindENS_8QualTypeE")
//</editor-fold>
public static void DiagnoseBadShiftValues(final Sema /*&*/ S, final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                      SourceLocation Loc, BinaryOperatorKind Opc, 
                      QualType LHSType) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // OpenCL 6.3j: shift values are effectively % word size of LHS (more defined),
    // so skip remaining warnings as we don't want to modify values within Sema.
    if (S.getLangOpts().OpenCL) {
      return;
    }
    
    APSInt Right/*J*/= new APSInt();
    // Check right/shifter operand
    if (RHS.get().isValueDependent()
       || !RHS.get().EvaluateAsInt(Right, S.Context)) {
      return;
    }
    if (Right.isNegative()) {
      $c$.clean(S.DiagRuntimeBehavior(new SourceLocation(Loc), RHS.get(), 
          $out_PartialDiagnostic$C_SourceRange($c$.track(S.PDiag(diag.warn_shift_negative)), 
              RHS.get().getSourceRange())));
      return;
    }
    APInt LeftBits/*J*/= new APInt(Right.getBitWidth(), 
        S.Context.getTypeSize(LHS.get().getType()));
    if (Right.uge(LeftBits)) {
      $c$.clean(S.DiagRuntimeBehavior(new SourceLocation(Loc), RHS.get(), 
          $out_PartialDiagnostic$C_SourceRange($c$.track(S.PDiag(diag.warn_shift_gt_typewidth)), 
              RHS.get().getSourceRange())));
      return;
    }
    if (Opc != BinaryOperatorKind.BO_Shl) {
      return;
    }
    
    // When left shifting an ICE which is signed, we can check for overflow which
    // according to C++ has undefined behavior ([expr.shift] 5.8/2). Unsigned
    // integers have defined behavior modulo one more than the maximum value
    // representable in the result type, so never warn for those.
    APSInt Left/*J*/= new APSInt();
    if (LHS.get().isValueDependent()
       || LHSType.$arrow().hasUnsignedIntegerRepresentation()
       || !LHS.get().EvaluateAsInt(Left, S.Context)) {
      return;
    }
    
    // If LHS does not have a signed type and non-negative value
    // then, the behavior is undefined. Warn about it.
    if (Left.isNegative() && !S.getLangOpts().isSignedOverflowDefined()) {
      $c$.clean(S.DiagRuntimeBehavior(new SourceLocation(Loc), LHS.get(), 
          $out_PartialDiagnostic$C_SourceRange($c$.track(S.PDiag(diag.warn_shift_lhs_negative)), 
              LHS.get().getSourceRange())));
      return;
    }
    
    APInt ResultBits = ((/*static_cast*/APInt /*&*/ )(Right)).$add($uint2ulong(Left.getMinSignedBits()));
    if (LeftBits.uge(ResultBits)) {
      return;
    }
    APSInt Result = Left.extend($ulong2uint(ResultBits.getLimitedValue()));
    Result.$assign(Result.shl(Right));
    
    // Print the bit representation of the signed integer as an unsigned
    // hexadecimal number.
    SmallString/*40*/ HexResult/*J*/= new SmallString/*40*/(40);
    Result.__toString(HexResult, 16, /*Signed =*/ false, /*Literal =*/ true);
    
    // If we are only missing a sign bit, this is less likely to result in actual
    // bugs -- if the result is cast back to an unsigned type, it will have the
    // expected value. Thus we place this behind a different warning that can be
    // turned off separately if needed.
    if (LeftBits.$eq(ResultBits.$sub(1))) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.warn_shift_result_sets_sign_bit)), 
                      HexResult), LHSType), 
              LHS.get().getSourceRange()), RHS.get().getSourceRange()));
      return;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.warn_shift_result_gt_typewidth)), 
                            HexResult.str()), Result.getMinSignedBits()), LHSType), 
                Left.getBitWidth()), LHS.get().getSourceRange()), 
        RHS.get().getSourceRange()));
  } finally {
    $c$.$destroy();
  }
}


/// \brief Return the resulting type when an OpenCL vector is shifted
///        by a scalar or vector shift amount.
//<editor-fold defaultstate="collapsed" desc="checkOpenCLVectorShift">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8608,
 FQN="checkOpenCLVectorShift", NM="_ZL22checkOpenCLVectorShiftRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL22checkOpenCLVectorShiftRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationEb")
//</editor-fold>
public static QualType checkOpenCLVectorShift(final Sema /*&*/ S, 
                      final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                      SourceLocation Loc, boolean IsCompAssign) {
  // OpenCL v1.1 s6.3.j says RHS can be a vector only if LHS is a vector.
  if (!LHS.get().getType().$arrow().isVectorType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_shift_rhs_only_vector)), 
                      RHS.get().getType()), LHS.get().getType()), 
              LHS.get().getSourceRange()), RHS.get().getSourceRange()));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  if (!IsCompAssign) {
    LHS.$assignMove(S.UsualUnaryConversions(LHS.get()));
    if (LHS.isInvalid()) {
      return new QualType();
    }
  }
  
  RHS.$assignMove(S.UsualUnaryConversions(RHS.get()));
  if (RHS.isInvalid()) {
    return new QualType();
  }
  
  QualType LHSType = LHS.get().getType();
  /*const*/ VectorType /*P*/ LHSVecTy = LHSType.$arrow().castAs(VectorType.class);
  QualType LHSEleType = LHSVecTy.getElementType();
  
  // Note that RHS might not be a vector.
  QualType RHSType = RHS.get().getType();
  /*const*/ VectorType /*P*/ RHSVecTy = RHSType.$arrow().getAs(VectorType.class);
  QualType RHSEleType = (RHSVecTy != null) ? RHSVecTy.getElementType() : new QualType(RHSType);
  
  // OpenCL v1.1 s6.3.j says that the operands need to be integers.
  if (!LHSEleType.$arrow().isIntegerType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_typecheck_expect_int)), 
              LHS.get().getType()), LHS.get().getSourceRange()));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  if (!RHSEleType.$arrow().isIntegerType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_typecheck_expect_int)), 
              RHS.get().getType()), RHS.get().getSourceRange()));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  if ((RHSVecTy != null)) {
    // OpenCL v1.1 s6.3.j says that for vector types, the operators
    // are applied component-wise. So if RHS is a vector, then ensure
    // that the number of elements is the same as LHS...
    if (RHSVecTy.getNumElements() != LHSVecTy.getNumElements()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_typecheck_vector_lengths_not_equal)), 
                        LHS.get().getType()), RHS.get().getType()), 
                LHS.get().getSourceRange()), RHS.get().getSourceRange()));
        return new QualType();
      } finally {
        $c$.$destroy();
      }
    }
  } else {
    // ...else expand RHS to match the number of elements in LHS.
    QualType VecTy = S.Context.getExtVectorType(new QualType(RHSEleType), LHSVecTy.getNumElements());
    RHS.$assignMove(S.ImpCastExprToType(RHS.get(), new QualType(VecTy), CastKind.CK_VectorSplat));
  }
  
  return LHSType;
}

//<editor-fold defaultstate="collapsed" desc="IsWithinTemplateSpecialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8733,
 FQN="IsWithinTemplateSpecialization", NM="_ZL30IsWithinTemplateSpecializationPN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL30IsWithinTemplateSpecializationPN5clang4DeclE")
//</editor-fold>
public static boolean IsWithinTemplateSpecialization(Decl /*P*/ D) {
  {
    DeclContext /*P*/ DC = D.getDeclContext();
    if ((DC != null)) {
      if (isa_ClassTemplateSpecializationDecl(DC)) {
        return true;
      }
      {
        FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(DC);
        if ((FD != null)) {
          return FD.isFunctionTemplateSpecialization();
        }
      }
    }
  }
  return false;
}


/// If two different enums are compared, raise a warning.
//<editor-fold defaultstate="collapsed" desc="checkEnumComparison">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8744,
 FQN="checkEnumComparison", NM="_ZL19checkEnumComparisonRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL19checkEnumComparisonRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_")
//</editor-fold>
public static void checkEnumComparison(final Sema /*&*/ S, SourceLocation Loc, Expr /*P*/ LHS, 
                   Expr /*P*/ RHS) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    QualType LHSStrippedType = LHS.IgnoreParenImpCasts().getType();
    QualType RHSStrippedType = RHS.IgnoreParenImpCasts().getType();
    
    /*const*/ EnumType /*P*/ LHSEnumType = LHSStrippedType.$arrow().<EnumType>getAs$EnumType();
    if (!(LHSEnumType != null)) {
      return;
    }
    /*const*/ EnumType /*P*/ RHSEnumType = RHSStrippedType.$arrow().<EnumType>getAs$EnumType();
    if (!(RHSEnumType != null)) {
      return;
    }
    
    // Ignore anonymous enums.
    if (!(LHSEnumType.getDecl().getIdentifier() != null)) {
      return;
    }
    if (!(RHSEnumType.getDecl().getIdentifier() != null)) {
      return;
    }
    if (S.Context.hasSameUnqualifiedType(new QualType(LHSStrippedType), new QualType(RHSStrippedType))) {
      return;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.warn_comparison_of_mixed_enum_types)), 
                    LHSStrippedType), RHSStrippedType), 
            LHS.getSourceRange()), RHS.getSourceRange()));
  } finally {
    $c$.$destroy();
  }
}


/// \brief Diagnose bad pointer comparisons.
//<editor-fold defaultstate="collapsed" desc="diagnoseDistinctPointerComparison">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8771,
 FQN="diagnoseDistinctPointerComparison", NM="_ZL33diagnoseDistinctPointerComparisonRN5clang4SemaENS_14SourceLocationERNS_12ActionResultIPNS_4ExprELb1EEES7_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL33diagnoseDistinctPointerComparisonRN5clang4SemaENS_14SourceLocationERNS_12ActionResultIPNS_4ExprELb1EEES7_b")
//</editor-fold>
public static void diagnoseDistinctPointerComparison(final Sema /*&*/ S, SourceLocation Loc, 
                                 final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                                 boolean IsError) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), IsError ? diag.err_typecheck_comparison_of_distinct_pointers : diag.ext_typecheck_comparison_of_distinct_pointers)), 
                    LHS.get().getType()), RHS.get().getType()), 
            LHS.get().getSourceRange()), RHS.get().getSourceRange()));
  } finally {
    $c$.$destroy();
  }
}


/// \brief Returns false if the pointers are converted to a composite type,
/// true otherwise.
//<editor-fold defaultstate="collapsed" desc="convertPointersToCompositeType">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8782,
 FQN="convertPointersToCompositeType", NM="_ZL30convertPointersToCompositeTypeRN5clang4SemaENS_14SourceLocationERNS_12ActionResultIPNS_4ExprELb1EEES7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL30convertPointersToCompositeTypeRN5clang4SemaENS_14SourceLocationERNS_12ActionResultIPNS_4ExprELb1EEES7_")
//</editor-fold>
public static boolean convertPointersToCompositeType(final Sema /*&*/ S, SourceLocation Loc, 
                              final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS) {
  // C++ [expr.rel]p2:
  //   [...] Pointer conversions (4.10) and qualification
  //   conversions (4.4) are performed on pointer operands (or on
  //   a pointer operand and a null pointer constant) to bring
  //   them to their composite pointer type. [...]
  //
  // C++ [expr.eq]p1 uses the same notion for (in)equality
  // comparisons of pointers.
  
  // C++ [expr.eq]p2:
  //   In addition, pointers to members can be compared, or a pointer to
  //   member and a null pointer constant. Pointer to member conversions
  //   (4.11) and qualification conversions (4.4) are performed to bring
  //   them to a common type. If one operand is a null pointer constant,
  //   the common type is the type of the other operand. Otherwise, the
  //   common type is a pointer to member type similar (4.4) to the type
  //   of one of the operands, with a cv-qualification signature (4.4)
  //   that is the union of the cv-qualification signatures of the operand
  //   types.
  QualType LHSType = LHS.get().getType();
  QualType RHSType = RHS.get().getType();
  assert ((LHSType.$arrow().isPointerType() && RHSType.$arrow().isPointerType()) || (LHSType.$arrow().isMemberPointerType() && RHSType.$arrow().isMemberPointerType()));
  
  bool$ptr NonStandardCompositeType = create_bool$ptr(false);
  bool$ptr/*bool P*/ BoolPtr = S.isSFINAEContext().$bool() ? null : $AddrOf(NonStandardCompositeType);
  QualType T = S.FindCompositePointerType(new SourceLocation(Loc), LHS, RHS, BoolPtr);
  if (T.isNull()) {
    diagnoseDistinctPointerComparison(S, new SourceLocation(Loc), LHS, RHS, /*isError*/ true);
    return true;
  }
  if (NonStandardCompositeType.$star()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.ext_typecheck_comparison_of_distinct_pointers_nonstandard)), 
                          LHSType), RHSType), T), LHS.get().getSourceRange()), 
          RHS.get().getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
  
  LHS.$assignMove(S.ImpCastExprToType(LHS.get(), new QualType(T), CastKind.CK_BitCast));
  RHS.$assignMove(S.ImpCastExprToType(RHS.get(), new QualType(T), CastKind.CK_BitCast));
  return false;
}

//<editor-fold defaultstate="collapsed" desc="diagnoseFunctionPointerToVoidComparison">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8827,
 FQN="diagnoseFunctionPointerToVoidComparison", NM="_ZL39diagnoseFunctionPointerToVoidComparisonRN5clang4SemaENS_14SourceLocationERNS_12ActionResultIPNS_4ExprELb1EEES7_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL39diagnoseFunctionPointerToVoidComparisonRN5clang4SemaENS_14SourceLocationERNS_12ActionResultIPNS_4ExprELb1EEES7_b")
//</editor-fold>
public static void diagnoseFunctionPointerToVoidComparison(final Sema /*&*/ S, SourceLocation Loc, 
                                       final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, 
                                       final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                                       boolean IsError) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), IsError ? diag.err_typecheck_comparison_of_fptr_to_void : diag.ext_typecheck_comparison_of_fptr_to_void)), 
                    LHS.get().getType()), RHS.get().getType()), 
            LHS.get().getSourceRange()), RHS.get().getSourceRange()));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="isObjCObjectLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8837,
 FQN="isObjCObjectLiteral", NM="_ZL19isObjCObjectLiteralRN5clang12ActionResultIPNS_4ExprELb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL19isObjCObjectLiteralRN5clang12ActionResultIPNS_4ExprELb1EEE")
//</editor-fold>
public static boolean isObjCObjectLiteral(final ActionResultTTrue<Expr /*P*/ > /*&*/ E) {
  switch (E.get().IgnoreParenImpCasts().getStmtClass()) {
   case ObjCArrayLiteralClass:
   case ObjCDictionaryLiteralClass:
   case ObjCStringLiteralClass:
   case ObjCBoxedExprClass:
    return true;
   default:
    // Note that ObjCBoolLiteral is NOT an object literal!
    return false;
  }
}

//<editor-fold defaultstate="collapsed" desc="hasIsEqualMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8850,
 FQN="hasIsEqualMethod", NM="_ZL16hasIsEqualMethodRN5clang4SemaEPKNS_4ExprES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL16hasIsEqualMethodRN5clang4SemaEPKNS_4ExprES4_")
//</editor-fold>
public static boolean hasIsEqualMethod(final Sema /*&*/ S, /*const*/ Expr /*P*/ LHS, /*const*/ Expr /*P*/ RHS) {
  /*const*/ ObjCObjectPointerType /*P*/ Type = LHS.getType().$arrow().getAs(ObjCObjectPointerType.class);
  
  // If this is not actually an Objective-C object, bail out.
  if (!(Type != null)) {
    return false;
  }
  
  // Get the LHS object's interface type.
  QualType InterfaceType = Type.getPointeeType();
  
  // If the RHS isn't an Objective-C object, bail out.
  if (!RHS.getType().$arrow().isObjCObjectPointerType()) {
    return false;
  }
  
  // Try to find the -isEqual: method.
  Selector IsEqualSel = S.NSAPIObj.$arrow().getIsEqualSelector();
  ObjCMethodDecl /*P*/ Method = S.LookupMethodInObjectType(new Selector(IsEqualSel), 
      new QualType(InterfaceType), 
      /*instance=*/ true);
  if (!(Method != null)) {
    if (Type.isObjCIdType()) {
      // For 'id', just check the global pool.
      Method = S.LookupInstanceMethodInGlobalPool(new Selector(IsEqualSel), new SourceRange(), 
          /*receiverId=*/ true);
    } else {
      // Check protocols.
      Method = S.LookupMethodInQualifiedType(new Selector(IsEqualSel), Type, 
          /*instance=*/ true);
    }
  }
  if (!(Method != null)) {
    return false;
  }
  
  QualType T = Method.parameters().$at(0).getType();
  if (!T.$arrow().isObjCObjectPointerType()) {
    return false;
  }
  
  QualType R = Method.getReturnType();
  if (!R.$arrow().isScalarType()) {
    return false;
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="diagnoseObjCLiteralComparison">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8938,
 FQN="diagnoseObjCLiteralComparison", NM="_ZL29diagnoseObjCLiteralComparisonRN5clang4SemaENS_14SourceLocationERNS_12ActionResultIPNS_4ExprELb1EEES7_NS_18BinaryOperatorKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL29diagnoseObjCLiteralComparisonRN5clang4SemaENS_14SourceLocationERNS_12ActionResultIPNS_4ExprELb1EEES7_NS_18BinaryOperatorKindE")
//</editor-fold>
public static void diagnoseObjCLiteralComparison(final Sema /*&*/ S, SourceLocation Loc, 
                             final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                             BinaryOperatorKind Opc) {
  Expr /*P*/ Literal;
  Expr /*P*/ Other;
  if (isObjCObjectLiteral(LHS)) {
    Literal = LHS.get();
    Other = RHS.get();
  } else {
    Literal = RHS.get();
    Other = LHS.get();
  }
  
  // Don't warn on comparisons against nil.
  Other = Other.IgnoreParenCasts();
  if ((Other.isNullPointerConstant(S.getASTContext(), 
      Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNotNull).getValue() != 0)) {
    return;
  }
  
  // This should be kept in sync with warn_objc_literal_comparison.
  // LK_String should always be after the other literals, since it has its own
  // warning flag.
  Sema.ObjCLiteralKind LiteralKind = S.CheckLiteralKind(Literal);
  assert (LiteralKind != Sema.ObjCLiteralKind.LK_Block);
  if (LiteralKind == Sema.ObjCLiteralKind.LK_None) {
    throw new llvm_unreachable("Unknown Objective-C object literal kind");
  }
  if (LiteralKind == Sema.ObjCLiteralKind.LK_String) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.warn_objc_string_literal_comparison)), 
          Literal.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.warn_objc_literal_comparison)), 
              LiteralKind), Literal.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
  if (BinaryOperator.isEqualityOp(Opc)
     && hasIsEqualMethod(S, LHS.get(), RHS.get())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SourceLocation Start = LHS.get().getLocStart();
      SourceLocation End = S.getLocForEndOfToken(RHS.get().getLocEnd());
      CharSourceRange OpRange = CharSourceRange.getCharRange(/*NO_COPY*/Loc, S.getLocForEndOfToken(new SourceLocation(Loc)));
      
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.note_objc_literal_comparison_isequal)), 
                  FixItHint.CreateInsertion(/*NO_COPY*/Start, new StringRef(Opc == BinaryOperatorKind.BO_EQ ? $LSQUARE : $("![")))), 
              FixItHint.CreateReplacement(/*NO_COPY*/OpRange, new StringRef(/*KEEP_STR*/" isEqual:"))), 
          FixItHint.CreateInsertion(/*NO_COPY*/End, new StringRef(/*KEEP_STR*/$RSQUARE))));
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="diagnoseLogicalNotOnLHSofComparison">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 8987,
 FQN="diagnoseLogicalNotOnLHSofComparison", NM="_ZL35diagnoseLogicalNotOnLHSofComparisonRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationENS_18BinaryOperatorKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL35diagnoseLogicalNotOnLHSofComparisonRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationENS_18BinaryOperatorKindE")
//</editor-fold>
public static void diagnoseLogicalNotOnLHSofComparison(final Sema /*&*/ S, final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, 
                                   final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                                   SourceLocation Loc, 
                                   BinaryOperatorKind Opc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Check that left hand side is !something.
    UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(LHS.get().IgnoreImpCasts());
    if (!(UO != null) || UO.getOpcode() != UnaryOperatorKind.UO_LNot) {
      return;
    }
    
    // Only check if the right hand side is non-bool arithmetic type.
    if (RHS.get().isKnownToHaveBooleanValue()) {
      return;
    }
    
    // Make sure that the something in !something is not bool.
    Expr /*P*/ SubExpr = UO.getSubExpr().IgnoreImpCasts();
    if (SubExpr.isKnownToHaveBooleanValue()) {
      return;
    }
    
    // Emit warning.
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(UO.getOperatorLoc(), diag.warn_logical_not_on_lhs_of_comparison)), 
        Loc));
    
    // First note suggest !(x < y)
    SourceLocation FirstOpen = SubExpr.getLocStart();
    SourceLocation FirstClose = RHS.get().getLocEnd();
    FirstClose.$assignMove(S.getLocForEndOfToken(new SourceLocation(FirstClose)));
    if (FirstClose.isInvalid()) {
      FirstOpen.$assignMove(new SourceLocation());
    }
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(UO.getOperatorLoc(), diag.note_logical_not_fix)), 
            FixItHint.CreateInsertion(/*NO_COPY*/FirstOpen, new StringRef(/*KEEP_STR*/$LPAREN))), 
        FixItHint.CreateInsertion(/*NO_COPY*/FirstClose, new StringRef(/*KEEP_STR*/$RPAREN))));
    
    // Second note suggests (!x) < y
    SourceLocation SecondOpen = LHS.get().getLocStart();
    SourceLocation SecondClose = LHS.get().getLocEnd();
    SecondClose.$assignMove(S.getLocForEndOfToken(new SourceLocation(SecondClose)));
    if (SecondClose.isInvalid()) {
      SecondOpen.$assignMove(new SourceLocation());
    }
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(UO.getOperatorLoc(), diag.note_logical_not_silence_with_parens)), 
            FixItHint.CreateInsertion(/*NO_COPY*/SecondOpen, new StringRef(/*KEEP_STR*/$LPAREN))), 
        FixItHint.CreateInsertion(/*NO_COPY*/SecondClose, new StringRef(/*KEEP_STR*/$RPAREN))));
  } finally {
    $c$.$destroy();
  }
}


// Get the decl for a simple expression: a reference to a variable,
// an implicit C++ field reference, or an implicit ObjC ivar reference.
//<editor-fold defaultstate="collapsed" desc="getCompareDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 9029,
 FQN="getCompareDecl", NM="_ZL14getCompareDeclPN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL14getCompareDeclPN5clang4ExprE")
//</editor-fold>
public static ValueDecl /*P*/ getCompareDecl(Expr /*P*/ E) {
  {
    DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(E);
    if ((DR != null)) {
      return DR.getDecl();
    }
  }
  {
    ObjCIvarRefExpr /*P*/ Ivar = dyn_cast_ObjCIvarRefExpr(E);
    if ((Ivar != null)) {
      if (Ivar.isFreeIvar()) {
        return Ivar.getDecl();
      }
    }
  }
  {
    MemberExpr /*P*/ Mem = dyn_cast_MemberExpr(E);
    if ((Mem != null)) {
      if (Mem.isImplicitAccess()) {
        return Mem.getMemberDecl();
      }
    }
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="IsReadonlyMessage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 9641,
 FQN="IsReadonlyMessage", NM="_ZL17IsReadonlyMessagePN5clang4ExprERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL17IsReadonlyMessagePN5clang4ExprERNS_4SemaE")
//</editor-fold>
public static boolean IsReadonlyMessage(Expr /*P*/ E, final Sema /*&*/ S) {
  /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E);
  if (!(ME != null)) {
    return false;
  }
  if (!isa_FieldDecl(ME.getMemberDecl())) {
    return false;
  }
  ObjCMessageExpr /*P*/ Base = dyn_cast_ObjCMessageExpr(ME.getBase().IgnoreParenImpCasts());
  if (!(Base != null)) {
    return false;
  }
  return Base.getMethodDecl() != null;
}

//<editor-fold defaultstate="collapsed" desc="isReferenceToNonConstCapture">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 9655,
 FQN="isReferenceToNonConstCapture", NM="_ZL28isReferenceToNonConstCaptureRN5clang4SemaEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL28isReferenceToNonConstCaptureRN5clang4SemaEPNS_4ExprE")
//</editor-fold>
public static NonConstCaptureKind isReferenceToNonConstCapture(final Sema /*&*/ S, Expr /*P*/ E) {
  assert (E.isLValue() && E.getType().isConstQualified());
  E = E.IgnoreParens();
  
  // Must be a reference to a declaration from an enclosing scope.
  DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
  if (!(DRE != null)) {
    return NonConstCaptureKind.NCCK_None;
  }
  if (!DRE.refersToEnclosingVariableOrCapture()) {
    return NonConstCaptureKind.NCCK_None;
  }
  
  // The declaration must be a variable which is not declared 'const'.
  VarDecl /*P*/ var = dyn_cast_VarDecl(DRE.getDecl());
  if (!(var != null)) {
    return NonConstCaptureKind.NCCK_None;
  }
  if (var.getType().isConstQualified()) {
    return NonConstCaptureKind.NCCK_None;
  }
  assert (var.hasLocalStorage()) : "capture added 'const' to non-local?";
  
  // Decide whether the first capture was for a block or a lambda.
  DeclContext /*P*/ DC = S.CurContext, /*P*/ Prev = null;
  // Decide whether the first capture was for a block or a lambda.
  while ((DC != null)) {
    {
      // For init-capture, it is possible that the variable belongs to the
      // template pattern of the current context.
      FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(DC);
      if ((FD != null)) {
        if (var.isInitCapture()
           && FD.getTemplateInstantiationPattern() == var.getDeclContext()) {
          break;
        }
      }
    }
    if (DC == var.getDeclContext()) {
      break;
    }
    Prev = DC;
    DC = DC.getParent();
  }
  // Unless we have an init-capture, we've gone one step too far.
  if (!var.isInitCapture()) {
    DC = Prev;
  }
  return (isa_BlockDecl(DC) ? NonConstCaptureKind.NCCK_Block : NonConstCaptureKind.NCCK_Lambda);
}

//<editor-fold defaultstate="collapsed" desc="IsTypeModifiable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 9691,
 FQN="IsTypeModifiable", NM="_ZL16IsTypeModifiableN5clang8QualTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL16IsTypeModifiableN5clang8QualTypeEb")
//</editor-fold>
public static boolean IsTypeModifiable(QualType Ty, boolean IsDereference) {
  Ty.$assignMove(Ty.getNonReferenceType());
  if (IsDereference && Ty.$arrow().isPointerType()) {
    Ty.$assignMove(Ty.$arrow().getPointeeType());
  }
  return !Ty.isConstQualified();
}


/// Emit the "read-only variable not assignable" error and print notes to give
/// more information about why the variable is not assignable, such as pointing
/// to the declaration of a const variable, showing that a method is const, or
/// that the function is returning a const reference.
//<editor-fold defaultstate="collapsed" desc="DiagnoseConstAssignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 9702,
 FQN="DiagnoseConstAssignment", NM="_ZL23DiagnoseConstAssignmentRN5clang4SemaEPKNS_4ExprENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL23DiagnoseConstAssignmentRN5clang4SemaEPKNS_4ExprENS_14SourceLocationE")
//</editor-fold>
public static void DiagnoseConstAssignment(final Sema /*&*/ S, /*const*/ Expr /*P*/ E, 
                       SourceLocation Loc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Update err_typecheck_assign_const and note_typecheck_assign_const
    // when this enum is changed.
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      final /*uint*/int ConstFunction = 0;
      final /*uint*/int ConstVariable = ConstFunction + 1;
      final /*uint*/int ConstMember = ConstVariable + 1;
      final /*uint*/int ConstMethod = ConstMember + 1;
      final /*uint*/int ConstUnknown = ConstMethod + 1; // Keep as last element
    /*}*/;
    
    SourceRange ExprRange = E.getSourceRange();
    
    // Only emit one error on the first const found.  All other consts will emit
    // a note to the error.
    boolean DiagnosticEmitted = false;
    
    // Track if the current expression is the result of a derefence, and if the
    // next checked expression is the result of a derefence.
    boolean IsDereference = false;
    boolean NextIsDereference = false;
    
    // Loop to process MemberExpr chains.
    while (true) {
      IsDereference = NextIsDereference;
      NextIsDereference = false;
      
      E = E.IgnoreParenImpCasts$Const();
      {
        /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E);
        if ((ME != null)) {
          NextIsDereference = ME.isArrow();
          /*const*/ ValueDecl /*P*/ VD = ME.getMemberDecl();
          {
            /*const*/ FieldDecl /*P*/ Field = dyn_cast_FieldDecl(VD);
            if ((Field != null)) {
              // Mutable fields can be modified even if the class is const.
              if (Field.isMutable()) {
                assert (DiagnosticEmitted) : "Expected diagnostic not emitted.";
                break;
              }
              if (!IsTypeModifiable(Field.getType(), IsDereference)) {
                if (!DiagnosticEmitted) {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_typecheck_assign_const)), 
                                      ExprRange), ConstMember), false/*static*/), Field), 
                      Field.getType()));
                  DiagnosticEmitted = true;
                }
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(VD.getLocation(), diag.note_typecheck_assign_const)), 
                                    ConstMember), false/*static*/), Field), Field.getType()), 
                    Field.getSourceRange()));
              }
              E = ME.getBase();
              continue;
            } else {
              /*const*/ VarDecl /*P*/ VDecl = dyn_cast_VarDecl(VD);
              if ((VDecl != null)) {
                if (VDecl.getType().isConstQualified()) {
                  if (!DiagnosticEmitted) {
                    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_typecheck_assign_const)), 
                                        ExprRange), ConstMember), true/*static*/), VDecl), 
                        VDecl.getType()));
                    DiagnosticEmitted = true;
                  }
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(VD.getLocation(), diag.note_typecheck_assign_const)), 
                                      ConstMember), true/*static*/), VDecl), VDecl.getType()), 
                      VDecl.getSourceRange()));
                }
                // Static fields do not inherit constness from parents.
                break;
              }
            }
          }
          break;
        } // End MemberExpr
      }
      break;
    }
    {
      
      /*const*/ CallExpr /*P*/ CE = dyn_cast_CallExpr(E);
      if ((CE != null)) {
        // Function calls
        /*const*/ FunctionDecl /*P*/ FD = CE.getDirectCallee$Const();
        if ((FD != null) && !IsTypeModifiable(FD.getReturnType(), IsDereference)) {
          if (!DiagnosticEmitted) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_typecheck_assign_const)), ExprRange), 
                    ConstFunction), FD));
            DiagnosticEmitted = true;
          }
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FD.getReturnTypeSourceRange().getBegin(), 
                              diag.note_typecheck_assign_const)), 
                          ConstFunction), FD), FD.getReturnType()), 
              FD.getReturnTypeSourceRange()));
        }
      } else {
        /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
        if ((DRE != null)) {
          {
            // Point to variable declaration.
            /*const*/ ValueDecl /*P*/ VD = DRE.getDecl$Const();
            if ((VD != null)) {
              if (!IsTypeModifiable(VD.getType(), IsDereference)) {
                if (!DiagnosticEmitted) {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_typecheck_assign_const)), 
                                  ExprRange), ConstVariable), VD), VD.getType()));
                  DiagnosticEmitted = true;
                }
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(VD.getLocation(), diag.note_typecheck_assign_const)), 
                                ConstVariable), VD), VD.getType()), VD.getSourceRange()));
              }
            }
          }
        } else if (isa_CXXThisExpr(E)) {
          {
            /*const*/ DeclContext /*P*/ DC = S.getFunctionLevelDeclContext();
            if ((DC != null)) {
              {
                /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(DC);
                if ((MD != null)) {
                  if (MD.isConst()) {
                    if (!DiagnosticEmitted) {
                      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_typecheck_assign_const)), ExprRange), 
                              ConstMethod), MD));
                      DiagnosticEmitted = true;
                    }
                    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(MD.getLocation(), diag.note_typecheck_assign_const)), 
                                ConstMethod), MD), MD.getSourceRange()));
                  }
                }
              }
            }
          }
        }
      }
    }
    if (DiagnosticEmitted) {
      return;
    }
    
    // Can't determine a more specific message, so display the generic error.
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_typecheck_assign_const)), ExprRange), ConstUnknown));
  } finally {
    $c$.$destroy();
  }
}


/// CheckForModifiableLvalue - Verify that E is a modifiable lvalue.  If not,
/// emit an error and return true.  If so, return false.
//<editor-fold defaultstate="collapsed" desc="CheckForModifiableLvalue">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 9826,
 FQN="CheckForModifiableLvalue", NM="_ZL24CheckForModifiableLvaluePN5clang4ExprENS_14SourceLocationERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL24CheckForModifiableLvaluePN5clang4ExprENS_14SourceLocationERNS_4SemaE")
//</editor-fold>
public static boolean CheckForModifiableLvalue(Expr /*P*/ E, SourceLocation _Loc, final Sema /*&*/ S) {
  assert (!E.hasPlaceholderType(BuiltinType.Kind.PseudoObject));
  
  type$ptr<SourceLocation> Loc = create_type$ptr(_Loc);
  S.CheckShadowingDeclModification(E, new SourceLocation(_Loc));
  SourceLocation OrigLoc = new SourceLocation(_Loc);
  Expr.isModifiableLvalueResult IsLV = E.isModifiableLvalue(S.Context, 
      $AddrOf(Loc));
  if (IsLV == Expr.isModifiableLvalueResult.MLV_ClassTemporary && IsReadonlyMessage(E, S)) {
    IsLV = Expr.isModifiableLvalueResult.MLV_InvalidMessageExpression;
  }
  if (IsLV == Expr.isModifiableLvalueResult.MLV_Valid) {
    return false;
  }
  
  /*uint*/int DiagID = 0;
  boolean NeedType = false;
  switch (IsLV) { // C99 6.5.16p2
   case MLV_ConstQualified:
    {
      // Use a specialized diagnostic when we're assigning to an object
      // from an enclosing function or block.
      NonConstCaptureKind NCCK = isReferenceToNonConstCapture(S, E);
      if ((NCCK.getValue() != 0)) {
        if (NCCK == NonConstCaptureKind.NCCK_Block) {
          DiagID = diag.err_block_decl_ref_not_modifiable_lvalue;
        } else {
          DiagID = diag.err_lambda_decl_ref_not_modifiable_lvalue;
        }
        break;
      }
    }
    
    // In ARC, use some specialized diagnostics for occasions where we
    // infer 'const'.  These are always pseudo-strong variables.
    if (S.getLangOpts().ObjCAutoRefCount) {
      DeclRefExpr /*P*/ declRef = dyn_cast_DeclRefExpr(E.IgnoreParenCasts());
      if ((declRef != null) && isa_VarDecl(declRef.getDecl())) {
        VarDecl /*P*/ var = cast_VarDecl(declRef.getDecl());
        
        // Use the normal diagnostic if it's pseudo-__strong but the
        // user actually wrote 'const'.
        if (var.isARCPseudoStrong()
           && (!(var.getTypeSourceInfo() != null)
           || !var.getTypeSourceInfo().getType().isConstQualified())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // There are two pseudo-strong cases:
            //  - self
            ObjCMethodDecl /*P*/ method = S.getCurMethodDecl();
            if ((method != null) && var == method.getSelfDecl()) {
              DiagID = method.isClassMethod() ? diag.err_typecheck_arc_assign_self_class_method : diag.err_typecheck_arc_assign_self;
            } else {
              
              //  - fast enumeration variables
              DiagID = diag.err_typecheck_arr_assign_enumeration;
            }
            
            SourceRange Assign/*J*/= new SourceRange();
            if ($noteq_SourceLocation$C(Loc.$star(), OrigLoc)) {
              Assign.$assignMove(new SourceRange(/*NO_COPY*/OrigLoc, /*NO_COPY*/OrigLoc));
            }
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc.$star()), DiagID)), E.getSourceRange()), Assign));
            // We need to preserve the AST regardless, so migration tool
            // can do its job.
            return false;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    // If none of the special cases above are triggered, then this is a
    // simple const assignment.
    if (DiagID == 0) {
      DiagnoseConstAssignment(S, E, new SourceLocation(Loc.$star()));
      return true;
    }
    
    break;
   case MLV_ConstAddrSpace:
    DiagnoseConstAssignment(S, E, new SourceLocation(Loc.$star()));
    return true;
   case MLV_ArrayType:
   case MLV_ArrayTemporary:
    DiagID = diag.err_typecheck_array_not_modifiable_lvalue;
    NeedType = true;
    break;
   case MLV_NotObjectType:
    DiagID = diag.err_typecheck_non_object_not_modifiable_lvalue;
    NeedType = true;
    break;
   case MLV_LValueCast:
    DiagID = diag.err_typecheck_lvalue_casts_not_supported;
    break;
   case MLV_Valid:
    throw new llvm_unreachable("did not take early return for MLV_Valid");
   case MLV_InvalidExpression:
   case MLV_MemberFunction:
   case MLV_ClassTemporary:
    DiagID = diag.err_typecheck_expression_not_modifiable_lvalue;
    break;
   case MLV_IncompleteType:
   case MLV_IncompleteVoidType:
    return S.RequireCompleteType$T(new SourceLocation(Loc.$star()), E.getType(), 
        diag.err_typecheck_incomplete_type_not_modifiable_lvalue, E);
   case MLV_DuplicateVectorComponents:
    DiagID = diag.err_typecheck_duplicate_vector_components_not_mlvalue;
    break;
   case MLV_NoSetterProperty:
    throw new llvm_unreachable("readonly properties should be processed differently");
   case MLV_InvalidMessageExpression:
    DiagID = diag.error_readonly_message_assignment;
    break;
   case MLV_SubObjCPropertySetting:
    DiagID = diag.error_no_subobject_property_setting;
    break;
  }
  
  SourceRange Assign/*J*/= new SourceRange();
  if ($noteq_SourceLocation$C(Loc.$star(), OrigLoc)) {
    Assign.$assignMove(new SourceRange(/*NO_COPY*/OrigLoc, /*NO_COPY*/OrigLoc));
  }
  if (NeedType) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc.$star()), DiagID)), E.getType()), E.getSourceRange()), Assign));
    } finally {
      $c$.$destroy();
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc.$star()), DiagID)), E.getSourceRange()), Assign));
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="CheckIdentityFieldAssignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 9945,
 FQN="CheckIdentityFieldAssignment", NM="_ZL28CheckIdentityFieldAssignmentPN5clang4ExprES1_NS_14SourceLocationERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL28CheckIdentityFieldAssignmentPN5clang4ExprES1_NS_14SourceLocationERNS_4SemaE")
//</editor-fold>
public static void CheckIdentityFieldAssignment(Expr /*P*/ LHSExpr, Expr /*P*/ RHSExpr, 
                            SourceLocation Loc, 
                            final Sema /*&*/ $Sema) {
  // C / C++ fields
  MemberExpr /*P*/ ML = dyn_cast_MemberExpr(LHSExpr);
  MemberExpr /*P*/ MR = dyn_cast_MemberExpr(RHSExpr);
  if ((ML != null) && (MR != null) && ML.getMemberDecl() == MR.getMemberDecl()) {
    if (isa_CXXThisExpr(ML.getBase()) && isa_CXXThisExpr(MR.getBase())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($Sema.Diag(new SourceLocation(Loc), diag.warn_identity_field_assign)), 0));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Objective-C instance variables
  ObjCIvarRefExpr /*P*/ OL = dyn_cast_ObjCIvarRefExpr(LHSExpr);
  ObjCIvarRefExpr /*P*/ OR = dyn_cast_ObjCIvarRefExpr(RHSExpr);
  if ((OL != null) && (OR != null) && OL.getDecl() == OR.getDecl()) {
    DeclRefExpr /*P*/ RL = dyn_cast_DeclRefExpr(OL.getBase().IgnoreImpCasts());
    DeclRefExpr /*P*/ RR = dyn_cast_DeclRefExpr(OR.getBase().IgnoreImpCasts());
    if ((RL != null) && (RR != null) && RL.getDecl() == RR.getDecl()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($Sema.Diag(new SourceLocation(Loc), diag.warn_identity_field_assign)), 1));
      } finally {
        $c$.$destroy();
      }
    }
  }
}


// Only ignore explicit casts to void.
//<editor-fold defaultstate="collapsed" desc="IgnoreCommaOperand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 10072,
 FQN="IgnoreCommaOperand", NM="_ZL18IgnoreCommaOperandPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL18IgnoreCommaOperandPKN5clang4ExprE")
//</editor-fold>
public static boolean IgnoreCommaOperand(/*const*/ Expr /*P*/ E) {
  E = E.IgnoreParens$Const();
  {
    
    /*const*/ CastExpr /*P*/ CE = dyn_cast_CastExpr(E);
    if ((CE != null)) {
      if (CE.getCastKind() == CastKind.CK_ToVoid) {
        return true;
      }
    }
  }
  
  return false;
}


// C99 6.5.17
//<editor-fold defaultstate="collapsed" desc="CheckCommaOperands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 10133,
 FQN="CheckCommaOperands", NM="_ZL18CheckCommaOperandsRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL18CheckCommaOperandsRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationE")
//</editor-fold>
public static QualType CheckCommaOperands(final Sema /*&*/ S, final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                  SourceLocation Loc) {
  LHS.$assignMove(S.CheckPlaceholderExpr(LHS.get()));
  RHS.$assignMove(S.CheckPlaceholderExpr(RHS.get()));
  if (LHS.isInvalid() || RHS.isInvalid()) {
    return new QualType();
  }
  
  // C's comma performs lvalue conversion (C99 6.3.2.1) on both its
  // operands, but not unary promotions.
  // C++'s comma does not do any conversions at all (C++ [expr.comma]p1).
  
  // So we treat the LHS as a ignored value, and in C++ we allow the
  // containing site to determine what should be done with the RHS.
  LHS.$assignMove(S.IgnoredValueConversions(LHS.get()));
  if (LHS.isInvalid()) {
    return new QualType();
  }
  
  S.DiagnoseUnusedExprResult(LHS.get());
  if (!S.getLangOpts().CPlusPlus) {
    RHS.$assignMove(S.DefaultFunctionArrayLvalueConversion(RHS.get()));
    if (RHS.isInvalid()) {
      return new QualType();
    }
    if (!RHS.get().getType().$arrow().isVoidType()) {
      S.RequireCompleteType(new SourceLocation(Loc), RHS.get().getType(), 
          diag.err_incomplete_type);
    }
  }
  if (!S.getDiagnostics().isIgnored(diag.warn_comma_operator, /*NO_COPY*/Loc)) {
    S.DiagnoseCommaOperator(LHS.get(), new SourceLocation(Loc));
  }
  
  return RHS.get().getType();
}


/// CheckIncrementDecrementOperand - unlike most "Check" methods, this routine
/// doesn't need to call UsualUnaryConversions or UsualArithmeticConversions.
//<editor-fold defaultstate="collapsed" desc="CheckIncrementDecrementOperand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 10169,
 FQN="CheckIncrementDecrementOperand", NM="_ZL30CheckIncrementDecrementOperandRN5clang4SemaEPNS_4ExprERNS_13ExprValueKindERNS_14ExprObjectKindENS_14SourceLocationEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL30CheckIncrementDecrementOperandRN5clang4SemaEPNS_4ExprERNS_13ExprValueKindERNS_14ExprObjectKindENS_14SourceLocationEbb")
//</editor-fold>
public static QualType CheckIncrementDecrementOperand(final Sema /*&*/ S, Expr /*P*/ Op, 
                              final type$ref<ExprValueKind /*&*/> VK, 
                              final type$ref<ExprObjectKind /*&*/> OK, 
                              SourceLocation OpLoc, 
                              boolean IsInc, boolean IsPrefix) {
  if (Op.isTypeDependent()) {
    return S.Context.DependentTy.$QualType();
  }
  
  QualType ResType = Op.getType();
  {
    // Atomic types can be used for increment / decrement where the non-atomic
    // versions can, so ignore the _Atomic() specifier for the purpose of
    // checking.
    /*const*/ AtomicType /*P*/ ResAtomicType = ResType.$arrow().getAs(AtomicType.class);
    if ((ResAtomicType != null)) {
      ResType.$assignMove(ResAtomicType.getValueType());
    }
  }
  assert (!ResType.isNull()) : "no type for increment/decrement expression";
  if (S.getLangOpts().CPlusPlus && ResType.$arrow().isBooleanType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Decrement of bool is not allowed.
      if (!IsInc) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(OpLoc), diag.err_decrement_bool)), Op.getSourceRange()));
        return new QualType();
      }
      // Increment of bool sets it to true, but is deprecated.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(OpLoc), S.getLangOpts().CPlusPlus1z ? diag.ext_increment_bool : diag.warn_increment_bool)), 
          Op.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  } else if (S.getLangOpts().CPlusPlus && ResType.$arrow().isEnumeralType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Error on enum increments and decrements in C++ mode
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(OpLoc), diag.err_increment_decrement_enum)), IsInc), ResType));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  } else if (ResType.$arrow().isRealType()) {
    // OK!
  } else if (ResType.$arrow().isPointerType()) {
    // C99 6.5.2.4p2, 6.5.6p2
    if (!checkArithmeticOpPointerOperand(S, new SourceLocation(OpLoc), Op)) {
      return new QualType();
    }
  } else if (ResType.$arrow().isObjCObjectPointerType()) {
    // On modern runtimes, ObjC pointer arithmetic is forbidden.
    // Otherwise, we just need a complete type.
    if (checkArithmeticIncompletePointerType(S, new SourceLocation(OpLoc), Op)
       || checkArithmeticOnObjCPointer(S, new SourceLocation(OpLoc), Op)) {
      return new QualType();
    }
  } else if (ResType.$arrow().isAnyComplexType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // C99 does not support ++/-- on complex types, we allow as an extension.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(OpLoc), diag.ext_integer_increment_complex)), 
              ResType), Op.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  } else if (ResType.$arrow().isPlaceholderType()) {
    ActionResultTTrue<Expr /*P*/ > PR = S.CheckPlaceholderExpr(Op);
    if (PR.isInvalid()) {
      return new QualType();
    }
    return CheckIncrementDecrementOperand(S, PR.get(), VK, OK, new SourceLocation(OpLoc), 
        IsInc, IsPrefix);
  } else if (S.getLangOpts().AltiVec && ResType.$arrow().isVectorType()) {
    // OK! ( C/C++ Language Extensions for CBEA(Version 2.6) 10.3 )
  } else if (S.getLangOpts().ZVector && ResType.$arrow().isVectorType()
     && (ResType.$arrow().getAs(VectorType.class).getVectorKind()
     != VectorType.VectorKind.AltiVecBool)) {
    // The z vector extensions allow ++ and -- for non-bool vectors.
  } else if (S.getLangOpts().OpenCL && ResType.$arrow().isVectorType()
     && ResType.$arrow().getAs(VectorType.class).getElementType().$arrow().isIntegerType()) {
    // OpenCL V1.2 6.3 says dec/inc ops operate on integer vector types.
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(OpLoc), diag.err_typecheck_illegal_increment_decrement)), 
                  ResType), ((int)((IsInc ? 1 : 0)))), Op.getSourceRange()));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  // At this point, we know we have a real, complex or pointer type.
  // Now make sure the operand is a modifiable lvalue.
  if (CheckForModifiableLvalue(Op, new SourceLocation(OpLoc), S)) {
    return new QualType();
  }
  // In C++, a prefix increment is the same type as the operand. Otherwise
  // (in C or with postfix), the increment is the unqualified type of the
  // operand.
  if (IsPrefix && S.getLangOpts().CPlusPlus) {
    VK.$set(ExprValueKind.VK_LValue);
    OK.$set(Op.getObjectKind());
    return ResType;
  } else {
    VK.$set(ExprValueKind.VK_RValue);
    return ResType.getUnqualifiedType();
  }
}


/// getPrimaryDecl - Helper function for CheckAddressOfOperand().
/// This routine allows us to typecheck complex/recursive expressions
/// where the declaration is needed for type checking. We only need to
/// handle cases when the expression references a function designator
/// or is an lvalue. Here are some examples:
///  - &(x) => x
///  - &*****f => f for f a function designator.
///  - &s.xx => s
///  - &s.zz[1].yy -> s, if zz is an array
///  - *(x + 1) -> x, if x is an array
///  - &"123"[2] -> 0
///  - & __real__ x -> x
//<editor-fold defaultstate="collapsed" desc="getPrimaryDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 10265,
 FQN="getPrimaryDecl", NM="_ZL14getPrimaryDeclPN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL14getPrimaryDeclPN5clang4ExprE")
//</editor-fold>
public static ValueDecl /*P*/ getPrimaryDecl(Expr /*P*/ E) {
  switch (E.getStmtClass()) {
   case DeclRefExprClass:
    return cast_DeclRefExpr(E).getDecl();
   case MemberExprClass:
    // If this is an arrow operator, the address is an offset from
    // the base's value, so the object the base refers to is
    // irrelevant.
    if (cast_MemberExpr(E).isArrow()) {
      return null;
    }
    // Otherwise, the expression refers to a part of the base
    return getPrimaryDecl(cast_MemberExpr(E).getBase());
   case ArraySubscriptExprClass:
    {
      // FIXME: This code shouldn't be necessary!  We should catch the implicit
      // promotion of register arrays earlier.
      Expr /*P*/ Base = cast_ArraySubscriptExpr(E).getBase();
      {
        ImplicitCastExpr /*P*/ ICE = dyn_cast_ImplicitCastExpr(Base);
        if ((ICE != null)) {
          if (ICE.getSubExpr().getType().$arrow().isArrayType()) {
            return getPrimaryDecl(ICE.getSubExpr());
          }
        }
      }
      return null;
    }
   case UnaryOperatorClass:
    {
      UnaryOperator /*P*/ UO = cast_UnaryOperator(E);
      switch (UO.getOpcode()) {
       case UO_Real:
       case UO_Imag:
       case UO_Extension:
        return getPrimaryDecl(UO.getSubExpr());
       default:
        return null;
      }
    }
   case ParenExprClass:
    return getPrimaryDecl(cast_ParenExpr(E).getSubExpr());
   case ImplicitCastExprClass:
    // If the result of an implicit cast is an l-value, we care about
    // the sub-expression; otherwise, the result here doesn't matter.
    return getPrimaryDecl(cast_ImplicitCastExpr(E).getSubExpr());
   default:
    return null;
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 10311,
 FQN="(anonymous namespace)::(anonymous)", NM="_SemaExpr_cpp_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_SemaExpr_cpp_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int AO_Bit_Field = 0;
  public static final /*uint*/int AO_Vector_Element = 1;
  public static final /*uint*/int AO_Property_Expansion = 2;
  public static final /*uint*/int AO_Register_Variable = 3;
  public static final /*uint*/int AO_No_Error = 4;
/*}*/
/// \brief Diagnose invalid operand for address of operations.
///
/// \param Type The type of operand which cannot have its address taken.
//<editor-fold defaultstate="collapsed" desc="diagnoseAddressOfInvalidType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 10322,
 FQN="diagnoseAddressOfInvalidType", NM="_ZL28diagnoseAddressOfInvalidTypeRN5clang4SemaENS_14SourceLocationEPNS_4ExprEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL28diagnoseAddressOfInvalidTypeRN5clang4SemaENS_14SourceLocationEPNS_4ExprEj")
//</editor-fold>
public static void diagnoseAddressOfInvalidType(final Sema /*&*/ S, SourceLocation Loc, 
                            Expr /*P*/ E, /*uint*/int Type) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_typecheck_address_of)), Type), E.getSourceRange()));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="RecordModifiableNonNullParam">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 10540,
 FQN="RecordModifiableNonNullParam", NM="_ZL28RecordModifiableNonNullParamRN5clang4SemaEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL28RecordModifiableNonNullParamRN5clang4SemaEPKNS_4ExprE")
//</editor-fold>
public static void RecordModifiableNonNullParam(final Sema /*&*/ S, /*const*/ Expr /*P*/ Exp) {
  /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(Exp);
  if (!(DRE != null)) {
    return;
  }
  /*const*/ Decl /*P*/ D = DRE.getDecl$Const();
  if (!(D != null)) {
    return;
  }
  /*const*/ ParmVarDecl /*P*/ Param = dyn_cast_ParmVarDecl(D);
  if (!(Param != null)) {
    return;
  }
  {
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(Param.getDeclContext$Const());
    if ((FD != null)) {
      if (!FD.hasAttr(NonNullAttr.class) && !Param.hasAttr(NonNullAttr.class)) {
        return;
      }
    }
  }
  {
    FunctionScopeInfo /*P*/ FD = S.getCurFunction();
    if ((FD != null)) {
      if (!(FD.ModifiedNonNullParams.count(Param) != 0)) {
        FD.ModifiedNonNullParams.insert(Param);
      }
    }
  }
}


/// CheckIndirectionOperand - Type check unary indirection (prefix '*').
//<editor-fold defaultstate="collapsed" desc="CheckIndirectionOperand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 10559,
 FQN="CheckIndirectionOperand", NM="_ZL23CheckIndirectionOperandRN5clang4SemaEPNS_4ExprERNS_13ExprValueKindENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL23CheckIndirectionOperandRN5clang4SemaEPNS_4ExprERNS_13ExprValueKindENS_14SourceLocationE")
//</editor-fold>
public static QualType CheckIndirectionOperand(final Sema /*&*/ S, Expr /*P*/ Op, final type$ref<ExprValueKind /*&*/> VK, 
                       SourceLocation OpLoc) {
  if (Op.isTypeDependent()) {
    return S.Context.DependentTy.$QualType();
  }
  
  ActionResultTTrue<Expr /*P*/ > ConvResult = S.UsualUnaryConversions(Op);
  if (ConvResult.isInvalid()) {
    return new QualType();
  }
  Op = ConvResult.get();
  QualType OpTy = Op.getType();
  QualType Result/*J*/= new QualType();
  if (isa_CXXReinterpretCastExpr(Op)) {
    QualType OpOrigType = Op.IgnoreParenCasts().getType();
    S.CheckCompatibleReinterpretCast(new QualType(OpOrigType), new QualType(OpTy), /*IsDereference*/ true, 
        Op.getSourceRange());
  }
  {
    
    /*const*/ PointerType /*P*/ PT = OpTy.$arrow().getAs(PointerType.class);
    if ((PT != null)) {
      Result.$assignMove(PT.getPointeeType());
    } else {
      /*const*/ ObjCObjectPointerType /*P*/ OPT = OpTy.$arrow().getAs(ObjCObjectPointerType.class);
      if ((OPT != null)) {
        Result.$assignMove(OPT.getPointeeType());
      } else {
        ActionResultTTrue<Expr /*P*/ > PR = S.CheckPlaceholderExpr(Op);
        if (PR.isInvalid()) {
          return new QualType();
        }
        if (PR.get() != Op) {
          return CheckIndirectionOperand(S, PR.get(), VK, new SourceLocation(OpLoc));
        }
      }
    }
  }
  if (Result.isNull()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(OpLoc), diag.err_typecheck_indirection_requires_pointer)), 
              OpTy), Op.getSourceRange()));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  
  // Note that per both C89 and C99, indirection is always legal, even if Result
  // is an incomplete type or void.  It would be possible to warn about
  // dereferencing a void pointer, but it's completely well-defined, and such a
  // warning is unlikely to catch any mistakes. In C++, indirection is not valid
  // for pointers to 'void' but is fine for any other pointer type:
  //
  // C++ [expr.unary.op]p1:
  //   [...] the expression to which [the unary * operator] is applied shall
  //   be a pointer to an object type, or a pointer to a function type
  if (S.getLangOpts().CPlusPlus && Result.$arrow().isVoidType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(OpLoc), diag.ext_typecheck_indirection_through_void_pointer)), 
              OpTy), Op.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
  
  // Dereferences are usually l-values...
  VK.$set(ExprValueKind.VK_LValue);
  
  // ...except that certain expressions are never l-values in C.
  if (!S.getLangOpts().CPlusPlus && Result.isCForbiddenLValueType()) {
    VK.$set(ExprValueKind.VK_RValue);
  }
  
  return Result;
}

//<editor-fold defaultstate="collapsed" desc="ConvertTokenKindToUnaryOpcode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 10660,
 FQN="ConvertTokenKindToUnaryOpcode", NM="_ZL29ConvertTokenKindToUnaryOpcodeN5clang3tok9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL29ConvertTokenKindToUnaryOpcodeN5clang3tok9TokenKindE")
//</editor-fold>
public static /*inline*/ UnaryOperatorKind ConvertTokenKindToUnaryOpcode(/*tok.TokenKind*/char Kind) {
  UnaryOperatorKind Opc;
  switch (Kind) {
   default:
    throw new llvm_unreachable("Unknown unary op!");
   case tok.TokenKind.plusplus:
    Opc = UnaryOperatorKind.UO_PreInc;
    break;
   case tok.TokenKind.minusminus:
    Opc = UnaryOperatorKind.UO_PreDec;
    break;
   case tok.TokenKind.amp:
    Opc = UnaryOperatorKind.UO_AddrOf;
    break;
   case tok.TokenKind.star:
    Opc = UnaryOperatorKind.UO_Deref;
    break;
   case tok.TokenKind.plus:
    Opc = UnaryOperatorKind.UO_Plus;
    break;
   case tok.TokenKind.minus:
    Opc = UnaryOperatorKind.UO_Minus;
    break;
   case tok.TokenKind.tilde:
    Opc = UnaryOperatorKind.UO_Not;
    break;
   case tok.TokenKind.exclaim:
    Opc = UnaryOperatorKind.UO_LNot;
    break;
   case tok.TokenKind.kw___real:
    Opc = UnaryOperatorKind.UO_Real;
    break;
   case tok.TokenKind.kw___imag:
    Opc = UnaryOperatorKind.UO_Imag;
    break;
   case tok.TokenKind.kw___extension__:
    Opc = UnaryOperatorKind.UO_Extension;
    break;
  }
  return Opc;
}


/// DiagnoseSelfAssignment - Emits a warning if a value is assigned to itself.
/// This warning is only emitted for builtin assignment operations. It is also
/// suppressed in the event of macro expansions.
//<editor-fold defaultstate="collapsed" desc="DiagnoseSelfAssignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 10683,
 FQN="DiagnoseSelfAssignment", NM="_ZL22DiagnoseSelfAssignmentRN5clang4SemaEPNS_4ExprES3_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL22DiagnoseSelfAssignmentRN5clang4SemaEPNS_4ExprES3_NS_14SourceLocationE")
//</editor-fold>
public static void DiagnoseSelfAssignment(final Sema /*&*/ S, Expr /*P*/ LHSExpr, Expr /*P*/ RHSExpr, 
                      SourceLocation OpLoc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (!S.ActiveTemplateInstantiations.empty()) {
      return;
    }
    if (OpLoc.isInvalid() || OpLoc.isMacroID()) {
      return;
    }
    LHSExpr = LHSExpr.IgnoreParenImpCasts();
    RHSExpr = RHSExpr.IgnoreParenImpCasts();
    /*const*/ DeclRefExpr /*P*/ LHSDeclRef = dyn_cast_DeclRefExpr(LHSExpr);
    /*const*/ DeclRefExpr /*P*/ RHSDeclRef = dyn_cast_DeclRefExpr(RHSExpr);
    if (!(LHSDeclRef != null) || !(RHSDeclRef != null)
       || LHSDeclRef.getLocation().isMacroID()
       || RHSDeclRef.getLocation().isMacroID()) {
      return;
    }
    /*const*/ ValueDecl /*P*/ LHSDecl = cast_ValueDecl(LHSDeclRef.getDecl$Const().getCanonicalDecl$Const());
    /*const*/ ValueDecl /*P*/ RHSDecl = cast_ValueDecl(RHSDeclRef.getDecl$Const().getCanonicalDecl$Const());
    if (LHSDecl != RHSDecl) {
      return;
    }
    if (LHSDecl.getType().isVolatileQualified()) {
      return;
    }
    {
      /*const*/ ReferenceType /*P*/ RefTy = LHSDecl.getType().$arrow().getAs(ReferenceType.class);
      if ((RefTy != null)) {
        if (RefTy.getPointeeType().isVolatileQualified()) {
          return;
        }
      }
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(OpLoc), diag.warn_self_assignment)), 
                LHSDeclRef.getType()), 
            LHSExpr.getSourceRange()), RHSExpr.getSourceRange()));
  } finally {
    $c$.$destroy();
  }
}


/// Check if a bitwise-& is performed on an Objective-C pointer.  This
/// is usually indicative of introspection within the Objective-C pointer.
//<editor-fold defaultstate="collapsed" desc="checkObjCPointerIntrospection">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 10716,
 FQN="checkObjCPointerIntrospection", NM="_ZL29checkObjCPointerIntrospectionRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL29checkObjCPointerIntrospectionRN5clang4SemaERNS_12ActionResultIPNS_4ExprELb1EEES6_NS_14SourceLocationE")
//</editor-fold>
public static void checkObjCPointerIntrospection(final Sema /*&*/ S, final ActionResultTTrue<Expr /*P*/ > /*&*/ L, final ActionResultTTrue<Expr /*P*/ > /*&*/ R, 
                             SourceLocation OpLoc) {
  if (!S.getLangOpts().ObjC1) {
    return;
  }
  
  /*const*/ Expr /*P*/ ObjCPointerExpr = null, /*P*/ OtherExpr = null;
  /*const*/ Expr /*P*/ LHS = L.get();
  /*const*/ Expr /*P*/ RHS = R.get();
  if (LHS.IgnoreParenCasts$Const().getType().$arrow().isObjCObjectPointerType()) {
    ObjCPointerExpr = LHS;
    OtherExpr = RHS;
  } else if (RHS.IgnoreParenCasts$Const().getType().$arrow().isObjCObjectPointerType()) {
    ObjCPointerExpr = RHS;
    OtherExpr = LHS;
  }
  
  // This warning is deliberately made very specific to reduce false
  // positives with logic that uses '&' for hashing.  This logic mainly
  // looks for code trying to introspect into tagged pointers, which
  // code should generally never do.
  if ((ObjCPointerExpr != null) && isa_IntegerLiteral(OtherExpr.IgnoreParenCasts$Const())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*uint*/int Diag = diag.warn_objc_pointer_masking;
      // Determine if we are introspecting the result of performSelectorXXX.
      /*const*/ Expr /*P*/ Ex = ObjCPointerExpr.IgnoreParenCasts$Const();
      {
        // Special case messages to -performSelector and friends, which
        // can return non-pointer values boxed in a pointer value.
        // Some clients may wish to silence warnings in this subcase.
        /*const*/ ObjCMessageExpr /*P*/ ME = dyn_cast_ObjCMessageExpr(Ex);
        if ((ME != null)) {
          Selector S$1 = ME.getSelector();
          StringRef SelArg0 = S$1.getNameForSlot(0);
          if (SelArg0.startswith(/*STRINGREF_STR*/"performSelector")) {
            Diag = diag.warn_objc_pointer_masking_performSelector;
          }
        }
      }
      
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(OpLoc), Diag)), 
          ObjCPointerExpr.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="getDeclFromExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 10757,
 FQN="getDeclFromExpr", NM="_ZL15getDeclFromExprPN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL15getDeclFromExprPN5clang4ExprE")
//</editor-fold>
public static NamedDecl /*P*/ getDeclFromExpr(Expr /*P*/ E) {
  if (!(E != null)) {
    return null;
  }
  {
    DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
    if ((DRE != null)) {
      return DRE.getDecl();
    }
  }
  {
    MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E);
    if ((ME != null)) {
      return ME.getMemberDecl();
    }
  }
  {
    ObjCIvarRefExpr /*P*/ IRE = dyn_cast_ObjCIvarRefExpr(E);
    if ((IRE != null)) {
      return IRE.getDecl();
    }
  }
  return null;
}


/// DiagnoseBitwisePrecedence - Emit a warning when bitwise and comparison
/// operators are mixed in a way that suggests that the programmer forgot that
/// comparison operators have higher precedence. The most typical example of
/// such code is "flags & 0x0020 != 0", which is equivalent to "flags & 1".
//<editor-fold defaultstate="collapsed" desc="DiagnoseBitwisePrecedence">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 10989,
 FQN="DiagnoseBitwisePrecedence", NM="_ZL25DiagnoseBitwisePrecedenceRN5clang4SemaENS_18BinaryOperatorKindENS_14SourceLocationEPNS_4ExprES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL25DiagnoseBitwisePrecedenceRN5clang4SemaENS_18BinaryOperatorKindENS_14SourceLocationEPNS_4ExprES5_")
//</editor-fold>
public static void DiagnoseBitwisePrecedence(final Sema /*&*/ Self, BinaryOperatorKind Opc, 
                         SourceLocation OpLoc, Expr /*P*/ LHSExpr, 
                         Expr /*P*/ RHSExpr) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    BinaryOperator /*P*/ LHSBO = dyn_cast_BinaryOperator(LHSExpr);
    BinaryOperator /*P*/ RHSBO = dyn_cast_BinaryOperator(RHSExpr);
    
    // Check that one of the sides is a comparison operator and the other isn't.
    boolean isLeftComp = (LHSBO != null) && LHSBO.isComparisonOp();
    boolean isRightComp = (RHSBO != null) && RHSBO.isComparisonOp();
    if (isLeftComp == isRightComp) {
      return;
    }
    
    // Bitwise operations are sometimes used as eager logical ops.
    // Don't diagnose this.
    boolean isLeftBitwise = (LHSBO != null) && LHSBO.isBitwiseOp();
    boolean isRightBitwise = (RHSBO != null) && RHSBO.isBitwiseOp();
    if (isLeftBitwise || isRightBitwise) {
      return;
    }
    
    SourceRange DiagRange = isLeftComp ? new SourceRange(LHSExpr.getLocStart(), 
        /*NO_COPY*/OpLoc) : new SourceRange(/*NO_COPY*/OpLoc, RHSExpr.getLocEnd());
    StringRef OpStr = isLeftComp ? LHSBO.getOpcodeStr() : RHSBO.getOpcodeStr();
    SourceRange ParensRange = isLeftComp ? new SourceRange(LHSBO.getRHS().getLocStart(), RHSExpr.getLocEnd()) : new SourceRange(LHSExpr.getLocStart(), RHSBO.getLHS().getLocEnd());
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(new SourceLocation(OpLoc), diag.warn_precedence_bitwise_rel)), 
                DiagRange), BinaryOperator.getOpcodeStr(Opc)), OpStr));
    SuggestParentheses(Self, new SourceLocation(OpLoc), 
        $out_PartialDiagnostic$C_StringRef($c$.track(Self.PDiag(diag.note_precedence_silence)), /*NO_COPY*/OpStr), 
        (isLeftComp ? LHSExpr : RHSExpr).getSourceRange()); $c$.clean();
    SuggestParentheses(Self, new SourceLocation(OpLoc), 
        $out_PartialDiagnostic$C_StringRef($c$.track(Self.PDiag(diag.note_precedence_bitwise_first)), 
            BinaryOperator.getOpcodeStr(Opc)), 
        new SourceRange(ParensRange)); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}


/// \brief It accepts a '&&' expr that is inside a '||' one.
/// Emit a diagnostic together with a fixit hint that wraps the '&&' expression
/// in parentheses.
//<editor-fold defaultstate="collapsed" desc="EmitDiagnosticForLogicalAndInLogicalOr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11030,
 FQN="EmitDiagnosticForLogicalAndInLogicalOr", NM="_ZL38EmitDiagnosticForLogicalAndInLogicalOrRN5clang4SemaENS_14SourceLocationEPNS_14BinaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL38EmitDiagnosticForLogicalAndInLogicalOrRN5clang4SemaENS_14SourceLocationEPNS_14BinaryOperatorE")
//</editor-fold>
public static void EmitDiagnosticForLogicalAndInLogicalOr(final Sema /*&*/ Self, SourceLocation OpLoc, 
                                      BinaryOperator /*P*/ Bop) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert (Bop.getOpcode() == BinaryOperatorKind.BO_LAnd);
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Self.Diag(Bop.getOperatorLoc(), diag.warn_logical_and_in_logical_or)), 
            Bop.getSourceRange()), OpLoc));
    SuggestParentheses(Self, Bop.getOperatorLoc(), 
        $out_PartialDiagnostic$C_StringRef($c$.track(Self.PDiag(diag.note_precedence_silence)), 
            Bop.getOpcodeStr()), 
        Bop.getSourceRange()); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}


/// \brief Returns true if the given expression can be evaluated as a constant
/// 'true'.
//<editor-fold defaultstate="collapsed" desc="EvaluatesAsTrue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11044,
 FQN="EvaluatesAsTrue", NM="_ZL15EvaluatesAsTrueRN5clang4SemaEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL15EvaluatesAsTrueRN5clang4SemaEPNS_4ExprE")
//</editor-fold>
public static boolean EvaluatesAsTrue(final Sema /*&*/ S, Expr /*P*/ E) {
  bool$ref Res = create_bool$ref();
  return !E.isValueDependent()
     && E.EvaluateAsBooleanCondition(Res, S.getASTContext()) && Res.$deref();
}


/// \brief Returns true if the given expression can be evaluated as a constant
/// 'false'.
//<editor-fold defaultstate="collapsed" desc="EvaluatesAsFalse">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11052,
 FQN="EvaluatesAsFalse", NM="_ZL16EvaluatesAsFalseRN5clang4SemaEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL16EvaluatesAsFalseRN5clang4SemaEPNS_4ExprE")
//</editor-fold>
public static boolean EvaluatesAsFalse(final Sema /*&*/ S, Expr /*P*/ E) {
  bool$ref Res = create_bool$ref();
  return !E.isValueDependent()
     && E.EvaluateAsBooleanCondition(Res, S.getASTContext()) && !Res.$deref();
}


/// \brief Look for '&&' in the left hand of a '||' expr.
//<editor-fold defaultstate="collapsed" desc="DiagnoseLogicalAndInLogicalOrLHS">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11059,
 FQN="DiagnoseLogicalAndInLogicalOrLHS", NM="_ZL32DiagnoseLogicalAndInLogicalOrLHSRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL32DiagnoseLogicalAndInLogicalOrLHSRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_")
//</editor-fold>
public static void DiagnoseLogicalAndInLogicalOrLHS(final Sema /*&*/ S, SourceLocation OpLoc, 
                                Expr /*P*/ LHSExpr, Expr /*P*/ RHSExpr) {
  {
    BinaryOperator /*P*/ Bop = dyn_cast_BinaryOperator(LHSExpr);
    if ((Bop != null)) {
      if (Bop.getOpcode() == BinaryOperatorKind.BO_LAnd) {
        // If it's "a && b || 0" don't warn since the precedence doesn't matter.
        if (EvaluatesAsFalse(S, RHSExpr)) {
          return;
        }
        // If it's "1 && a || b" don't warn since the precedence doesn't matter.
        if (!EvaluatesAsTrue(S, Bop.getLHS())) {
          EmitDiagnosticForLogicalAndInLogicalOr(S, new SourceLocation(OpLoc), Bop);
          /*JAVA:return*/return;
        }
      } else if (Bop.getOpcode() == BinaryOperatorKind.BO_LOr) {
        {
          BinaryOperator /*P*/ RBop = dyn_cast_BinaryOperator(Bop.getRHS());
          if ((RBop != null)) {
            // If it's "a || b && 1 || c" we didn't warn earlier for
            // "a || b && 1", but warn now.
            if (RBop.getOpcode() == BinaryOperatorKind.BO_LAnd && EvaluatesAsTrue(S, RBop.getRHS())) {
              EmitDiagnosticForLogicalAndInLogicalOr(S, new SourceLocation(OpLoc), RBop);
              /*JAVA:return*/return;
            }
          }
        }
      }
    }
  }
}


/// \brief Look for '&&' in the right hand of a '||' expr.
//<editor-fold defaultstate="collapsed" desc="DiagnoseLogicalAndInLogicalOrRHS">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11081,
 FQN="DiagnoseLogicalAndInLogicalOrRHS", NM="_ZL32DiagnoseLogicalAndInLogicalOrRHSRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL32DiagnoseLogicalAndInLogicalOrRHSRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_")
//</editor-fold>
public static void DiagnoseLogicalAndInLogicalOrRHS(final Sema /*&*/ S, SourceLocation OpLoc, 
                                Expr /*P*/ LHSExpr, Expr /*P*/ RHSExpr) {
  {
    BinaryOperator /*P*/ Bop = dyn_cast_BinaryOperator(RHSExpr);
    if ((Bop != null)) {
      if (Bop.getOpcode() == BinaryOperatorKind.BO_LAnd) {
        // If it's "0 || a && b" don't warn since the precedence doesn't matter.
        if (EvaluatesAsFalse(S, LHSExpr)) {
          return;
        }
        // If it's "a || b && 1" don't warn since the precedence doesn't matter.
        if (!EvaluatesAsTrue(S, Bop.getRHS())) {
          EmitDiagnosticForLogicalAndInLogicalOr(S, new SourceLocation(OpLoc), Bop);
          /*JAVA:return*/return;
        }
      }
    }
  }
}


/// \brief Look for bitwise op in the left or right hand of a bitwise op with
/// lower precedence and emit a diagnostic together with a fixit hint that wraps
/// the '&' expression in parentheses.
//<editor-fold defaultstate="collapsed" desc="DiagnoseBitwiseOpInBitwiseOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11098,
 FQN="DiagnoseBitwiseOpInBitwiseOp", NM="_ZL28DiagnoseBitwiseOpInBitwiseOpRN5clang4SemaENS_18BinaryOperatorKindENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL28DiagnoseBitwiseOpInBitwiseOpRN5clang4SemaENS_18BinaryOperatorKindENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public static void DiagnoseBitwiseOpInBitwiseOp(final Sema /*&*/ S, BinaryOperatorKind Opc, 
                            SourceLocation OpLoc, Expr /*P*/ SubExpr) {
  {
    BinaryOperator /*P*/ Bop = dyn_cast_BinaryOperator(SubExpr);
    if ((Bop != null)) {
      if (Bop.isBitwiseOp() && Bop.getOpcode().getValue() < Opc.getValue()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Bop.getOperatorLoc(), diag.warn_bitwise_op_in_bitwise_op)), 
                          Bop.getOpcodeStr()), BinaryOperator.getOpcodeStr(Opc)), 
                  Bop.getSourceRange()), OpLoc));
          SuggestParentheses(S, Bop.getOperatorLoc(), 
              $out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.note_precedence_silence)), 
                  Bop.getOpcodeStr()), 
              Bop.getSourceRange()); $c$.clean();
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="DiagnoseAdditionInShift">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11113,
 FQN="DiagnoseAdditionInShift", NM="_ZL23DiagnoseAdditionInShiftRN5clang4SemaENS_14SourceLocationEPNS_4ExprEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL23DiagnoseAdditionInShiftRN5clang4SemaENS_14SourceLocationEPNS_4ExprEN4llvm9StringRefE")
//</editor-fold>
public static void DiagnoseAdditionInShift(final Sema /*&*/ S, SourceLocation OpLoc, 
                       Expr /*P*/ SubExpr, StringRef Shift) {
  {
    BinaryOperator /*P*/ Bop = dyn_cast_BinaryOperator(SubExpr);
    if ((Bop != null)) {
      if (Bop.getOpcode() == BinaryOperatorKind.BO_Add || Bop.getOpcode() == BinaryOperatorKind.BO_Sub) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          StringRef Op = Bop.getOpcodeStr();
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Bop.getOperatorLoc(), diag.warn_addition_in_bitshift)), 
                          Bop.getSourceRange()), OpLoc), Shift), Op));
          SuggestParentheses(S, Bop.getOperatorLoc(), 
              $out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.note_precedence_silence)), /*NO_COPY*/Op), 
              Bop.getSourceRange()); $c$.clean();
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="DiagnoseShiftCompare">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11127,
 FQN="DiagnoseShiftCompare", NM="_ZL20DiagnoseShiftCompareRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL20DiagnoseShiftCompareRN5clang4SemaENS_14SourceLocationEPNS_4ExprES4_")
//</editor-fold>
public static void DiagnoseShiftCompare(final Sema /*&*/ S, SourceLocation OpLoc, 
                    Expr /*P*/ LHSExpr, Expr /*P*/ RHSExpr) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    CXXOperatorCallExpr /*P*/ OCE = dyn_cast_CXXOperatorCallExpr(LHSExpr);
    if (!(OCE != null)) {
      return;
    }
    
    FunctionDecl /*P*/ FD = OCE.getDirectCallee();
    if (!(FD != null) || !FD.isOverloadedOperator()) {
      return;
    }
    
    OverloadedOperatorKind Kind = FD.getOverloadedOperator();
    if (Kind != OverloadedOperatorKind.OO_LessLess && Kind != OverloadedOperatorKind.OO_GreaterGreater) {
      return;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(OpLoc), diag.warn_overloaded_shift_in_comparison)), 
                LHSExpr.getSourceRange()), RHSExpr.getSourceRange()), 
        (Kind == OverloadedOperatorKind.OO_LessLess)));
    SuggestParentheses(S, OCE.getOperatorLoc(), 
        $out_PartialDiagnostic$C_char$ptr$C($c$.track(S.PDiag(diag.note_precedence_silence)), 
            (Kind == OverloadedOperatorKind.OO_LessLess ? $LT_LT : $GT_GT)), 
        OCE.getSourceRange()); $c$.clean();
    SuggestParentheses(S, new SourceLocation(OpLoc), 
        $c$.track(S.PDiag(diag.note_evaluate_comparison_first)), 
        new SourceRange(OCE.getArg(1).getLocStart(), 
            RHSExpr.getLocEnd())); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}


/// DiagnoseBinOpPrecedence - Emit warnings for expressions with tricky
/// precedence.
//<editor-fold defaultstate="collapsed" desc="DiagnoseBinOpPrecedence">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11156,
 FQN="DiagnoseBinOpPrecedence", NM="_ZL23DiagnoseBinOpPrecedenceRN5clang4SemaENS_18BinaryOperatorKindENS_14SourceLocationEPNS_4ExprES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL23DiagnoseBinOpPrecedenceRN5clang4SemaENS_18BinaryOperatorKindENS_14SourceLocationEPNS_4ExprES5_")
//</editor-fold>
public static void DiagnoseBinOpPrecedence(final Sema /*&*/ Self, BinaryOperatorKind Opc, 
                       SourceLocation OpLoc, Expr /*P*/ LHSExpr, 
                       Expr /*P*/ RHSExpr) {
  // Diagnose "arg1 'bitwise' arg2 'eq' arg3".
  if (BinaryOperator.isBitwiseOp(Opc)) {
    DiagnoseBitwisePrecedence(Self, Opc, new SourceLocation(OpLoc), LHSExpr, RHSExpr);
  }
  
  // Diagnose "arg1 & arg2 | arg3"
  if ((Opc == BinaryOperatorKind.BO_Or || Opc == BinaryOperatorKind.BO_Xor)
     && !OpLoc.isMacroID()/* Don't warn in macros. */) {
    DiagnoseBitwiseOpInBitwiseOp(Self, Opc, new SourceLocation(OpLoc), LHSExpr);
    DiagnoseBitwiseOpInBitwiseOp(Self, Opc, new SourceLocation(OpLoc), RHSExpr);
  }
  
  // Warn about arg1 || arg2 && arg3, as GCC 4.3+ does.
  // We don't warn for 'assert(a || b && "bad")' since this is safe.
  if (Opc == BinaryOperatorKind.BO_LOr && !OpLoc.isMacroID()/* Don't warn in macros. */) {
    DiagnoseLogicalAndInLogicalOrLHS(Self, new SourceLocation(OpLoc), LHSExpr, RHSExpr);
    DiagnoseLogicalAndInLogicalOrRHS(Self, new SourceLocation(OpLoc), LHSExpr, RHSExpr);
  }
  if ((Opc == BinaryOperatorKind.BO_Shl && LHSExpr.getType().$arrow().isIntegralType(Self.getASTContext()))
     || Opc == BinaryOperatorKind.BO_Shr) {
    StringRef Shift = BinaryOperator.getOpcodeStr(Opc);
    DiagnoseAdditionInShift(Self, new SourceLocation(OpLoc), LHSExpr, new StringRef(Shift));
    DiagnoseAdditionInShift(Self, new SourceLocation(OpLoc), RHSExpr, new StringRef(Shift));
  }
  
  // Warn on overloaded shift operators and comparisons, such as:
  // cout << 5 == 4;
  if (BinaryOperator.isComparisonOp(Opc)) {
    DiagnoseShiftCompare(Self, new SourceLocation(OpLoc), LHSExpr, RHSExpr);
  }
}


/// Build an overloaded binary operator expression in the given scope.
//<editor-fold defaultstate="collapsed" desc="BuildOverloadedBinOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11205,
 FQN="BuildOverloadedBinOp", NM="_ZL20BuildOverloadedBinOpRN5clang4SemaEPNS_5ScopeENS_14SourceLocationENS_18BinaryOperatorKindEPNS_4ExprES7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL20BuildOverloadedBinOpRN5clang4SemaEPNS_5ScopeENS_14SourceLocationENS_18BinaryOperatorKindEPNS_4ExprES7_")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > BuildOverloadedBinOp(final Sema /*&*/ S, Scope /*P*/ Sc, SourceLocation OpLoc, 
                    BinaryOperatorKind Opc, 
                    Expr /*P*/ LHS, Expr /*P*/ RHS) {
  // Find all of the overloaded operators visible from this
  // point. We perform both an operator-name lookup from the local
  // scope and an argument-dependent lookup based on the types of
  // the arguments.
  UnresolvedSet Functions/*J*/= new UnresolvedSet(16);
  OverloadedOperatorKind OverOp = BinaryOperator.getOverloadedOperator(Opc);
  if ((Sc != null) && OverOp != OverloadedOperatorKind.OO_None && OverOp != OverloadedOperatorKind.OO_Equal) {
    S.LookupOverloadedOperatorName(OverOp, Sc, LHS.getType(), 
        RHS.getType(), Functions);
  }
  
  // Build the (potentially-overloaded, potentially-dependent)
  // binary operation.
  return S.CreateOverloadedBinOp(new SourceLocation(OpLoc), Opc, Functions, LHS, RHS);
}


/// \brief Determine whether the given expression is a qualified member
/// access expression, of a form that could be turned into a pointer to member
/// with the address-of operator.
//<editor-fold defaultstate="collapsed" desc="isQualifiedMemberAccess">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11487,
 FQN="isQualifiedMemberAccess", NM="_ZL23isQualifiedMemberAccessPN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL23isQualifiedMemberAccessPN5clang4ExprE")
//</editor-fold>
public static boolean isQualifiedMemberAccess(Expr /*P*/ E) {
  {
    DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
    if ((DRE != null)) {
      if (!(DRE.getQualifier() != null)) {
        return false;
      }
      
      ValueDecl /*P*/ VD = DRE.getDecl();
      if (!VD.isCXXClassMember()) {
        return false;
      }
      if (isa_FieldDecl(VD) || isa_IndirectFieldDecl(VD)) {
        return true;
      }
      {
        CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(VD);
        if ((Method != null)) {
          return Method.isInstance();
        }
      }
      
      return false;
    }
  }
  {
    
    UnresolvedLookupExpr /*P*/ ULE = dyn_cast_UnresolvedLookupExpr(E);
    if ((ULE != null)) {
      if (!(ULE.getQualifier() != null)) {
        return false;
      }

      for (NamedDecl /*P*/ D : ULE.decls()) {
        {
          CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(D);
          if ((Method != null)) {
            if (Method.isInstance()) {
              return true;
            }
          } else {
            // Overload set does not contain methods.
            break;
          }
        }
      }
      
      return false;
    }
  }
  
  return false;
}


/// Given the last statement in a statement-expression, check whether
/// the result is a producing expression (like a call to an
/// ns_returns_retained function) and, if so, rebuild it to hoist the
/// release out of the full-expression.  Otherwise, return null.
/// Cannot fail.
//<editor-fold defaultstate="collapsed" desc="maybeRebuildARCConsumingStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 11591,
 FQN="maybeRebuildARCConsumingStmt", NM="_ZL28maybeRebuildARCConsumingStmtPN5clang4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL28maybeRebuildARCConsumingStmtPN5clang4StmtE")
//</editor-fold>
public static Expr /*P*/ maybeRebuildARCConsumingStmt(Stmt /*P*/ Statement) {
  // Should always be wrapped with one of these.
  ExprWithCleanups /*P*/ cleanups = dyn_cast_ExprWithCleanups(Statement);
  if (!(cleanups != null)) {
    return null;
  }
  
  ImplicitCastExpr /*P*/ cast = dyn_cast_ImplicitCastExpr(cleanups.getSubExpr());
  if (!(cast != null) || cast.getCastKind() != CastKind.CK_ARCConsumeObject) {
    return null;
  }
  
  // Splice out the cast.  This shouldn't modify any interesting
  // features of the statement.
  Expr /*P*/ producer = cast.getSubExpr();
  assert ($eq_QualType$C(producer.getType(), cast.getType()));
  assert (producer.getValueKind() == cast.getValueKind());
  cleanups.setSubExpr(producer);
  return cleanups;
}

//<editor-fold defaultstate="collapsed" desc="maybeDiagnoseAssignmentToFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12372,
 FQN="maybeDiagnoseAssignmentToFunction", NM="_ZL33maybeDiagnoseAssignmentToFunctionRN5clang4SemaENS_8QualTypeEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL33maybeDiagnoseAssignmentToFunctionRN5clang4SemaENS_8QualTypeEPKNS_4ExprE")
//</editor-fold>
public static boolean maybeDiagnoseAssignmentToFunction(final Sema /*&*/ S, QualType DstType, 
                                 /*const*/ Expr /*P*/ SrcExpr) {
  if (!DstType.$arrow().isFunctionPointerType()
     || !SrcExpr.getType().$arrow().isFunctionType()) {
    return false;
  }
  
  /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(SrcExpr.IgnoreParenImpCasts$Const());
  if (!(DRE != null)) {
    return false;
  }
  
  /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(DRE.getDecl$Const());
  if (!(FD != null)) {
    return false;
  }
  
  return !S.checkAddressOfFunctionIsAvailable(FD, 
      /*Complain=*/ true, 
      SrcExpr.getLocStart());
}

//<editor-fold defaultstate="collapsed" desc="IsPotentiallyEvaluatedContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 12912,
 FQN="IsPotentiallyEvaluatedContext", NM="_ZL29IsPotentiallyEvaluatedContextRN5clang4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL29IsPotentiallyEvaluatedContextRN5clang4SemaE")
//</editor-fold>
public static boolean IsPotentiallyEvaluatedContext(final Sema /*&*/ SemaRef) {
  // Do not mark anything as "used" within a dependent context; wait for
  // an instantiation.
  if (SemaRef.CurContext.isDependentContext()) {
    return false;
  }
  switch (SemaRef.ExprEvalContexts.back().Context) {
   case Unevaluated:
   case UnevaluatedAbstract:
    // We are in an expression that is not potentially evaluated; do nothing.
    // (Depending on how you read the standard, we actually do need to do
    // something here for null pointer constants, but the standard's
    // definition of a null pointer constant is completely crazy.)
    return false;
   case DiscardedStatement:
    // These are technically a potentially evaluated but they have the effect
    // of suppressing use marking.
    return false;
   case ConstantEvaluated:
   case PotentiallyEvaluated:
    // We are in a potentially evaluated expression (or a constant-expression
    // in C++03); we need to do implicit template instantiation, implicitly
    // define class members, and mark most declarations as used.
    return true;
   case PotentiallyEvaluatedIfUsed:
    // Referenced declarations will only be used if the construct in the
    // containing expression is used.
    return false;
  }
  throw new llvm_unreachable("Invalid context");
}

//<editor-fold defaultstate="collapsed" desc="diagnoseUncapturableValueReference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 13133,
 FQN="diagnoseUncapturableValueReference", NM="_ZL34diagnoseUncapturableValueReferenceRN5clang4SemaENS_14SourceLocationEPNS_7VarDeclEPNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL34diagnoseUncapturableValueReferenceRN5clang4SemaENS_14SourceLocationEPNS_7VarDeclEPNS_11DeclContextE")
//</editor-fold>
public static void diagnoseUncapturableValueReference(final Sema /*&*/ S, SourceLocation loc, 
                                  VarDecl /*P*/ var, DeclContext /*P*/ DC) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    DeclContext /*P*/ VarDC = var.getDeclContext();
    
    //  If the parameter still belongs to the translation unit, then
    //  we're actually just using one parameter in the declaration of
    //  the next.
    if (isa_ParmVarDecl(var)
       && isa_TranslationUnitDecl(VarDC)) {
      return;
    }
    
    // For C code, don't diagnose about capture if we're not actually in code
    // right now; it's impossible to write a non-constant expression outside of
    // function context, so we'll get other (more useful) diagnostics later.
    //
    // For C++, things get a bit more nasty... it would be nice to suppress this
    // diagnostic for certain cases like using a local variable in an array bound
    // for a member of a local class, but the correct predicate is not obvious.
    if (!S.getLangOpts().CPlusPlus && !S.CurContext.isFunctionOrMethod()) {
      return;
    }
    if (isa_CXXMethodDecl(VarDC)
       && cast_CXXRecordDecl(VarDC.getParent()).isLambda()) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(loc), diag.err_reference_to_local_var_in_enclosing_lambda)), 
          var.getIdentifier()));
    } else {
      FunctionDecl /*P*/ fn = dyn_cast_FunctionDecl(VarDC);
      if ((fn != null)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(loc), diag.err_reference_to_local_var_in_enclosing_function)), 
                var.getIdentifier()), fn.getDeclName()));
      } else if (isa_BlockDecl(VarDC)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(loc), diag.err_reference_to_local_var_in_enclosing_block)), 
            var.getIdentifier()));
      } else {
        // FIXME: Is there any other context where a local variable can be
        // declared?
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(loc), diag.err_reference_to_local_var_in_enclosing_context)), 
            var.getIdentifier()));
      }
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(var.getLocation(), diag.note_entity_declared_at)), 
        var.getIdentifier()));
  } finally {
    $c$.$destroy();
  }
  // FIXME: Add additional diagnostic info about class etc. which prevents
  // capture.
}

//<editor-fold defaultstate="collapsed" desc="isVariableAlreadyCapturedInScopeInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 13180,
 FQN="isVariableAlreadyCapturedInScopeInfo", NM="_ZL36isVariableAlreadyCapturedInScopeInfoPN5clang4sema18CapturingScopeInfoEPNS_7VarDeclERbRNS_8QualTypeES7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL36isVariableAlreadyCapturedInScopeInfoPN5clang4sema18CapturingScopeInfoEPNS_7VarDeclERbRNS_8QualTypeES7_")
//</editor-fold>
public static boolean isVariableAlreadyCapturedInScopeInfo(CapturingScopeInfo /*P*/ CSI, VarDecl /*P*/ Var, 
                                    final bool$ref/*bool &*/ SubCapturesAreNested, 
                                    final QualType /*&*/ CaptureType, 
                                    final QualType /*&*/ DeclRefType) {
  // Check whether we've already captured it.
  if ((CSI.CaptureMap.count(Var) != 0)) {
    // If we found a capture, any subcaptures are nested.
    SubCapturesAreNested.$set(true);
    
    // Retrieve the capture type for this variable.
    CaptureType.$assignMove(CSI.getCapture(Var).getCaptureType());
    
    // Compute the type of an expression that refers to this variable.
    DeclRefType.$assignMove(CaptureType.getNonReferenceType());
    
    // Similarly to mutable captures in lambda, all the OpenMP captures by copy
    // are mutable in the sense that user can change their value - they are
    // private instances of the captured declarations.
    final /*const*/ CapturingScopeInfo.Capture /*&*/ Cap = CSI.getCapture(Var);
    if (Cap.isCopyCapture()
       && !(isa_LambdaScopeInfo(CSI) && cast_LambdaScopeInfo(CSI).Mutable)
       && !(isa_CapturedRegionScopeInfo(CSI)
       && $ushort2int(cast_CapturedRegionScopeInfo(CSI).CapRegionKind) == CapturedRegionKind.CR_OpenMP.getValue())) {
      DeclRefType.addConst();
    }
    return true;
  }
  return false;
}


// Only block literals, captured statements, and lambda expressions can
// capture; other scopes don't work.
//<editor-fold defaultstate="collapsed" desc="getParentOfCapturingContextOrNull">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 13211,
 FQN="getParentOfCapturingContextOrNull", NM="_ZL33getParentOfCapturingContextOrNullPN5clang11DeclContextEPNS_7VarDeclENS_14SourceLocationEbRNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL33getParentOfCapturingContextOrNullPN5clang11DeclContextEPNS_7VarDeclENS_14SourceLocationEbRNS_4SemaE")
//</editor-fold>
public static DeclContext /*P*/ getParentOfCapturingContextOrNull(DeclContext /*P*/ DC, VarDecl /*P*/ Var, 
                                 SourceLocation Loc, 
                                 /*const*/boolean Diagnose, final Sema /*&*/ S) {
  if (isa_BlockDecl(DC) || isa_CapturedDecl(DC) || isLambdaCallOperator(DC)) {
    return getLambdaAwareParentOfDeclContext(DC);
  } else if (Var.hasLocalStorage()) {
    if (Diagnose) {
      diagnoseUncapturableValueReference(S, new SourceLocation(Loc), Var, DC);
    }
  }
  return null;
}


// Certain capturing entities (lambdas, blocks etc.) are not allowed to capture 
// certain types of variables (unnamed, variably modified types etc.)
// so check for eligibility.
//<editor-fold defaultstate="collapsed" desc="isVariableCapturable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 13226,
 FQN="isVariableCapturable", NM="_ZL20isVariableCapturablePN5clang4sema18CapturingScopeInfoEPNS_7VarDeclENS_14SourceLocationEbRNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL20isVariableCapturablePN5clang4sema18CapturingScopeInfoEPNS_7VarDeclENS_14SourceLocationEbRNS_4SemaE")
//</editor-fold>
public static boolean isVariableCapturable(CapturingScopeInfo /*P*/ CSI, VarDecl /*P*/ Var, 
                    SourceLocation Loc, 
                    /*const*/boolean Diagnose, final Sema /*&*/ S) {
  
  boolean IsBlock = isa_BlockScopeInfo(CSI);
  boolean IsLambda = isa_LambdaScopeInfo(CSI);
  
  // Lambdas are not allowed to capture unnamed variables
  // (e.g. anonymous unions).
  // FIXME: The C++11 rule don't actually state this explicitly, but I'm
  // assuming that's the intent.
  if (IsLambda && !Var.getDeclName().$bool()) {
    if (Diagnose) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(new SourceLocation(Loc), diag.err_lambda_capture_anonymous_var)));
        $c$.clean($c$.track(S.Diag(Var.getLocation(), diag.note_declared_at)));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  
  // Prohibit variably-modified types in blocks; they're difficult to deal with.
  if (Var.getType().$arrow().isVariablyModifiedType() && IsBlock) {
    if (Diagnose) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(new SourceLocation(Loc), diag.err_ref_vm_type)));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Var.getLocation(), diag.note_previous_decl)), 
            Var.getDeclName()));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  {
    // Prohibit structs with flexible array members too.
    // We cannot capture what is in the tail end of the struct.
    /*const*/ RecordType /*P*/ VTTy = Var.getType().$arrow().<RecordType>getAs$RecordType();
    if ((VTTy != null)) {
      if (VTTy.getDecl().hasFlexibleArrayMember()) {
        if (Diagnose) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            if (IsBlock) {
              $c$.clean($c$.track(S.Diag(new SourceLocation(Loc), diag.err_ref_flexarray_type)));
            } else {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_lambda_capture_flexarray_type)), 
                  Var.getDeclName()));
            }
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Var.getLocation(), diag.note_previous_decl)), 
                Var.getDeclName()));
          } finally {
            $c$.$destroy();
          }
        }
        return false;
      }
    }
  }
  /*const*/boolean HasBlocksAttr = Var.hasAttr(BlocksAttr.class);
  // Lambdas and captured statements are not allowed to capture __block
  // variables; they don't support the expected semantics.
  if (HasBlocksAttr && (IsLambda || isa_CapturedRegionScopeInfo(CSI))) {
    if (Diagnose) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_capture_block_variable)), 
                Var.getDeclName()), !IsLambda));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Var.getLocation(), diag.note_previous_decl)), 
            Var.getDeclName()));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  
  return true;
}


// Returns true if the capture by block was successful.
//<editor-fold defaultstate="collapsed" desc="captureInBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 13287,
 FQN="captureInBlock", NM="_ZL14captureInBlockPN5clang4sema14BlockScopeInfoEPNS_7VarDeclENS_14SourceLocationEbRNS_8QualTypeES7_bRNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL14captureInBlockPN5clang4sema14BlockScopeInfoEPNS_7VarDeclENS_14SourceLocationEbRNS_8QualTypeES7_bRNS_4SemaE")
//</editor-fold>
public static boolean captureInBlock(BlockScopeInfo /*P*/ BSI, VarDecl /*P*/ Var, 
              SourceLocation Loc, 
              /*const*/boolean BuildAndDiagnose, 
              final QualType /*&*/ CaptureType, 
              final QualType /*&*/ DeclRefType, 
              /*const*/boolean Nested, 
              final Sema /*&*/ S) {
  Expr /*P*/ CopyExpr = null;
  boolean ByRef = false;
  
  // Blocks are not allowed to capture arrays.
  if (CaptureType.$arrow().isArrayType()) {
    if (BuildAndDiagnose) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(new SourceLocation(Loc), diag.err_ref_array_type)));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Var.getLocation(), diag.note_previous_decl)), 
            Var.getDeclName()));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  
  // Forbid the block-capture of autoreleasing variables.
  if (CaptureType.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Autoreleasing) {
    if (BuildAndDiagnose) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_arc_autoreleasing_capture)), 
            /*block*/ 0));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Var.getLocation(), diag.note_previous_decl)), 
            Var.getDeclName()));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  /*const*/boolean HasBlocksAttr = Var.hasAttr(BlocksAttr.class);
  if (HasBlocksAttr || CaptureType.$arrow().isReferenceType()
     || ((S.getLangOpts().OpenMP != 0) && (S.IsOpenMPCapturedDecl(Var) != null))) {
    // Block capture by reference does not change the capture or
    // declaration reference types.
    ByRef = true;
  } else {
    // Block capture by copy introduces 'const'.
    CaptureType.$assignMove(CaptureType.getNonReferenceType().withConst());
    DeclRefType.$assign(CaptureType);
    if (S.getLangOpts().CPlusPlus && BuildAndDiagnose) {
      {
        /*const*/ RecordType /*P*/ Record = DeclRefType.$arrow().<RecordType>getAs$RecordType();
        if ((Record != null)) {
          EnterExpressionEvaluationContext scope = null;
          try {
            // The capture logic needs the destructor, so make sure we mark it.
            // Usually this is unnecessary because most local variables have
            // their destructors marked at declaration time, but parameters are
            // an exception because it's technically only the call site that
            // actually requires the destructor.
            if (isa_ParmVarDecl(Var)) {
              S.FinalizeVarWithDestructor(Var, Record);
            }
            
            // Enter a new evaluation context to insulate the copy
            // full-expression.
            scope/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.PotentiallyEvaluated);
            
            // According to the blocks spec, the capture of a variable from
            // the stack requires a const copy constructor.  This is not true
            // of the copy/move done to move a __block variable to the heap.
            Expr /*P*/ DeclRef = /*FIXME:NEW_EXPR*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C$P_uint(S.Context, (type$ptr<?> Mem)->
                    new DeclRefExpr(Var, Nested, 
                DeclRefType.withConst(), 
                ExprValueKind.VK_LValue, new SourceLocation(Loc))
            );
            
            ActionResultTTrue<Expr /*P*/ > Result = S.PerformCopyInitialization(InitializedEntity.InitializeBlock(Var.getLocation(), 
                    new QualType(CaptureType), false), 
                new SourceLocation(Loc), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, DeclRef));
            
            // Build a full-expression copy expression if initialization
            // succeeded and used a non-trivial constructor.  Recover from
            // errors by pretending that the copy isn't necessary.
            if (!Result.isInvalid()
               && !cast_CXXConstructExpr(Result.get()).getConstructor().
                isTrivial()) {
              Result.$assignMove(S.MaybeCreateExprWithCleanups(new ActionResultTTrue<Expr /*P*/ >(Result)));
              CopyExpr = Result.get();
            }
          } finally {
            if (scope != null) { scope.$destroy(); }
          }
        }
      }
    }
  }
  
  // Actually capture the variable.
  if (BuildAndDiagnose) {
    BSI.addCapture(Var, HasBlocksAttr, ByRef, Nested, new SourceLocation(Loc), 
        new SourceLocation(), new QualType(CaptureType), CopyExpr);
  }
  
  return true;
}


/// \brief Capture the given variable in the captured region.
//<editor-fold defaultstate="collapsed" desc="captureInCapturedRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 13379,
 FQN="captureInCapturedRegion", NM="_ZL23captureInCapturedRegionPN5clang4sema23CapturedRegionScopeInfoEPNS_7VarDeclENS_14SourceLocationEbRNS_8QualTypeES7_bRNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL23captureInCapturedRegionPN5clang4sema23CapturedRegionScopeInfoEPNS_7VarDeclENS_14SourceLocationEbRNS_8QualTypeES7_bRNS_4SemaE")
//</editor-fold>
public static boolean captureInCapturedRegion(CapturedRegionScopeInfo /*P*/ RSI, 
                       VarDecl /*P*/ Var, 
                       SourceLocation Loc, 
                       /*const*/boolean BuildAndDiagnose, 
                       final QualType /*&*/ CaptureType, 
                       final QualType /*&*/ DeclRefType, 
                       /*const*/boolean RefersToCapturedVariable, 
                       final Sema /*&*/ S) {
  // By default, capture variables by reference.
  boolean ByRef = true;
  // Using an LValue reference type is consistent with Lambdas (see below).
  if ((S.getLangOpts().OpenMP != 0) && $ushort2int(RSI.CapRegionKind) == CapturedRegionKind.CR_OpenMP.getValue()) {
    if ((S.IsOpenMPCapturedDecl(Var) != null)) {
      DeclRefType.$assignMove(DeclRefType.getUnqualifiedType());
    }
    ByRef = S.IsOpenMPCapturedByRef(Var, $ushort2uint(RSI.OpenMPLevel));
  }
  if (ByRef) {
    CaptureType.$assignMove(S.Context.getLValueReferenceType(new QualType(DeclRefType)));
  } else {
    CaptureType.$assign(DeclRefType);
  }
  
  Expr /*P*/ CopyExpr = null;
  if (BuildAndDiagnose) {
    // The current implementation assumes that all variables are captured
    // by references. Since there is no capture by copy, no expression
    // evaluation will be needed.
    RecordDecl /*P*/ RD = RSI.TheRecordDecl;
    
    FieldDecl /*P*/ Field = FieldDecl.Create(S.Context, RD, new SourceLocation(Loc), new SourceLocation(Loc), (IdentifierInfo /*P*/ )null, new QualType(CaptureType), 
        S.Context.getTrivialTypeSourceInfo(new QualType(CaptureType), new SourceLocation(Loc)), 
        (Expr /*P*/ )null, false, InClassInitStyle.ICIS_NoInit);
    Field.setImplicit(true);
    Field.setAccess(AccessSpecifier.AS_private);
    RD.addDecl(Field);
    
    CopyExpr = /*FIXME:NEW_EXPR*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C$P_uint(S.Context, (type$ptr<?> Mem)->
            new DeclRefExpr(Var, RefersToCapturedVariable, 
        new QualType(DeclRefType), ExprValueKind.VK_LValue, new SourceLocation(Loc))
    );
    Var.setReferenced(true);
    Var.markUsed(S.Context);
  }
  
  // Actually capture the variable.
  if (BuildAndDiagnose) {
    RSI.addCapture(Var, /*isBlock*/ false, ByRef, RefersToCapturedVariable, new SourceLocation(Loc), 
        new SourceLocation(), new QualType(CaptureType), CopyExpr);
  }
  
  return true;
}


/// \brief Create a field within the lambda class for the variable
/// being captured.
//<editor-fold defaultstate="collapsed" desc="addAsFieldToClosureType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 13433,
 FQN="addAsFieldToClosureType", NM="_ZL23addAsFieldToClosureTypeRN5clang4SemaEPNS_4sema15LambdaScopeInfoENS_8QualTypeES5_NS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL23addAsFieldToClosureTypeRN5clang4SemaEPNS_4sema15LambdaScopeInfoENS_8QualTypeES5_NS_14SourceLocationEb")
//</editor-fold>
public static void addAsFieldToClosureType(final Sema /*&*/ S, LambdaScopeInfo /*P*/ LSI, 
                       QualType FieldType, QualType DeclRefType, 
                       SourceLocation Loc, 
                       boolean RefersToCapturedVariable) {
  CXXRecordDecl /*P*/ Lambda = LSI.Lambda;
  
  // Build the non-static data member.
  FieldDecl /*P*/ Field = FieldDecl.Create(S.Context, Lambda, new SourceLocation(Loc), new SourceLocation(Loc), (IdentifierInfo /*P*/ )null, new QualType(FieldType), 
      S.Context.getTrivialTypeSourceInfo(new QualType(FieldType), new SourceLocation(Loc)), 
      (Expr /*P*/ )null, false, InClassInitStyle.ICIS_NoInit);
  Field.setImplicit(true);
  Field.setAccess(AccessSpecifier.AS_private);
  Lambda.addDecl(Field);
}


/// \brief Capture the given variable in the lambda.
//<editor-fold defaultstate="collapsed" desc="captureInLambda">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 13450,
 FQN="captureInLambda", NM="_ZL15captureInLambdaPN5clang4sema15LambdaScopeInfoEPNS_7VarDeclENS_14SourceLocationEbRNS_8QualTypeES7_bNS_4Sema14TryCaptureKindES5_bRS8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL15captureInLambdaPN5clang4sema15LambdaScopeInfoEPNS_7VarDeclENS_14SourceLocationEbRNS_8QualTypeES7_bNS_4Sema14TryCaptureKindES5_bRS8_")
//</editor-fold>
public static boolean captureInLambda(LambdaScopeInfo /*P*/ LSI, 
               VarDecl /*P*/ Var, 
               SourceLocation Loc, 
               /*const*/boolean BuildAndDiagnose, 
               final QualType /*&*/ CaptureType, 
               final QualType /*&*/ DeclRefType, 
               /*const*/boolean RefersToCapturedVariable, 
               /*const*/ Sema.TryCaptureKind Kind, 
               SourceLocation EllipsisLoc, 
               /*const*/boolean IsTopScope, 
               final Sema /*&*/ S) {
  
  // Determine whether we are capturing by reference or by value.
  boolean ByRef = false;
  if (IsTopScope && Kind != Sema.TryCaptureKind.TryCapture_Implicit) {
    ByRef = (Kind == Sema.TryCaptureKind.TryCapture_ExplicitByRef);
  } else {
    ByRef = (LSI.ImpCaptureStyle == LambdaScopeInfo.ImplicitCaptureStyle.ImpCap_LambdaByref);
  }
  
  // Compute the type of the field that will capture this variable.
  if (ByRef) {
    // C++11 [expr.prim.lambda]p15:
    //   An entity is captured by reference if it is implicitly or
    //   explicitly captured but not captured by copy. It is
    //   unspecified whether additional unnamed non-static data
    //   members are declared in the closure type for entities
    //   captured by reference.
    //
    // FIXME: It is not clear whether we want to build an lvalue reference
    // to the DeclRefType or to CaptureType.getNonReferenceType(). GCC appears
    // to do the former, while EDG does the latter. Core issue 1249 will 
    // clarify, but for now we follow GCC because it's a more permissive and
    // easily defensible position.
    CaptureType.$assignMove(S.Context.getLValueReferenceType(new QualType(DeclRefType)));
  } else {
    {
      // C++11 [expr.prim.lambda]p14:
      //   For each entity captured by copy, an unnamed non-static
      //   data member is declared in the closure type. The
      //   declaration order of these members is unspecified. The type
      //   of such a data member is the type of the corresponding
      //   captured entity if the entity is not a reference to an
      //   object, or the referenced type otherwise. [Note: If the
      //   captured entity is a reference to a function, the
      //   corresponding data member is also a reference to a
      //   function. - end note ]
      /*const*/ ReferenceType /*P*/ RefType = CaptureType.$arrow().getAs(ReferenceType.class);
      if ((RefType != null)) {
        if (!RefType.getPointeeType().$arrow().isFunctionType()) {
          CaptureType.$assignMove(RefType.getPointeeType());
        }
      }
    }
    
    // Forbid the lambda copy-capture of autoreleasing variables.
    if (CaptureType.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Autoreleasing) {
      if (BuildAndDiagnose) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_arc_autoreleasing_capture)), /*lambda*/ 1));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Var.getLocation(), diag.note_previous_decl)), 
              Var.getDeclName()));
        } finally {
          $c$.$destroy();
        }
      }
      return false;
    }
    
    // Make sure that by-copy captures are of a complete and non-abstract type.
    if (BuildAndDiagnose) {
      if (!CaptureType.$arrow().isDependentType()
         && S.RequireCompleteType$T(new SourceLocation(Loc), new QualType(CaptureType), 
          diag.err_capture_of_incomplete_type, 
          Var.getDeclName())) {
        return false;
      }
      if (S.RequireNonAbstractType$T(new SourceLocation(Loc), new QualType(CaptureType), 
          diag.err_capture_of_abstract_type)) {
        return false;
      }
    }
  }
  
  // Capture this variable in the lambda.
  if (BuildAndDiagnose) {
    addAsFieldToClosureType(S, LSI, new QualType(CaptureType), new QualType(DeclRefType), new SourceLocation(Loc), 
        RefersToCapturedVariable);
  }
  
  // Compute the type of a reference to this captured variable.
  if (ByRef) {
    DeclRefType.$assignMove(CaptureType.getNonReferenceType());
  } else {
    // C++ [expr.prim.lambda]p5:
    //   The closure type for a lambda-expression has a public inline 
    //   function call operator [...]. This function call operator is 
    //   declared const (9.3.1) if and only if the lambda-expression���s 
    //   parameter-declaration-clause is not followed by mutable.
    DeclRefType.$assignMove(CaptureType.getNonReferenceType());
    if (!LSI.Mutable && !CaptureType.$arrow().isReferenceType()) {
      DeclRefType.addConst();
    }
  }
  
  // Add the capture.
  if (BuildAndDiagnose) {
    LSI.addCapture(Var, /*IsBlock=*/ false, ByRef, RefersToCapturedVariable, 
        new SourceLocation(Loc), new SourceLocation(EllipsisLoc), new QualType(CaptureType), /*CopyExpr=*/ (Expr /*P*/ )null);
  }
  
  return true;
}


// If either the type of the variable or the initializer is dependent, 
// return false. Otherwise, determine whether the variable is a constant
// expression. Use this if you need to know if a variable that might or
// might not be dependent is truly a constant expression.
//<editor-fold defaultstate="collapsed" desc="IsVariableNonDependentAndAConstantExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 13780,
 FQN="IsVariableNonDependentAndAConstantExpression", NM="_ZL44IsVariableNonDependentAndAConstantExpressionPN5clang7VarDeclERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL44IsVariableNonDependentAndAConstantExpressionPN5clang7VarDeclERNS_10ASTContextE")
//</editor-fold>
public static /*inline*/ boolean IsVariableNonDependentAndAConstantExpression(VarDecl /*P*/ Var, 
                                            final ASTContext /*&*/ Context) {
  if (Var.getType().$arrow().isDependentType()) {
    return false;
  }
  type$ref</*const*/ VarDecl /*P*/ > DefVD = create_type$ref();
  Var.getAnyInitializer(DefVD);
  if (!(DefVD.$deref() != null)) {
    return false;
  }
  EvaluatedStmt /*P*/ Eval = DefVD.$deref().ensureEvaluatedStmt();
  Expr /*P*/ Init = cast_Expr(Eval.Value);
  if (Init.isValueDependent()) {
    return false;
  }
  return IsVariableAConstantExpression(Var, Context);
}

//<editor-fold defaultstate="collapsed" desc="DoMarkVarDeclReferenced">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 13858,
 FQN="DoMarkVarDeclReferenced", NM="_ZL23DoMarkVarDeclReferencedRN5clang4SemaENS_14SourceLocationEPNS_7VarDeclEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL23DoMarkVarDeclReferencedRN5clang4SemaENS_14SourceLocationEPNS_7VarDeclEPNS_4ExprE")
//</editor-fold>
public static void DoMarkVarDeclReferenced(final Sema /*&*/ SemaRef, SourceLocation Loc, 
                       VarDecl /*P*/ Var, Expr /*P*/ E) {
  assert ((!(E != null) || isa_DeclRefExpr(E) || isa_MemberExpr(E))) : "Invalid Expr argument to DoMarkVarDeclReferenced";
  Var.setReferenced();
  
  TemplateSpecializationKind TSK = Var.getTemplateSpecializationKind();
  boolean MarkODRUsed = true;
  
  // If the context is not potentially evaluated, this is not an odr-use and
  // does not trigger instantiation.
  if (!IsPotentiallyEvaluatedContext(SemaRef)) {
    if (SemaRef.isUnevaluatedContext()) {
      return;
    }
    
    // If we don't yet know whether this context is going to end up being an
    // evaluated context, and we're referencing a variable from an enclosing
    // scope, add a potential capture.
    //
    // FIXME: Is this necessary? These contexts are only used for default
    // arguments, where local variables can't be used.
    /*const*/boolean RefersToEnclosingScope = (SemaRef.CurContext != Var.getDeclContext()
       && Var.getDeclContext().isFunctionOrMethod() && Var.hasLocalStorage());
    if (RefersToEnclosingScope) {
      {
        LambdaScopeInfo /*P*/ /*const*/ LSI = SemaRef.getCurLambda();
        if ((LSI != null)) {
          // If a variable could potentially be odr-used, defer marking it so
          // until we finish analyzing the full expression for any
          // lvalue-to-rvalue
          // or discarded value conversions that would obviate odr-use.
          // Add it to the list of potential captures that will be analyzed
          // later (ActOnFinishFullExpr) for eventual capture and odr-use marking
          // unless the variable is a reference that was initialized by a constant
          // expression (this will never need to be captured or odr-used).
          assert ((E != null)) : "Capture variable should be used in an expression.";
          if (!Var.getType().$arrow().isReferenceType()
             || !IsVariableNonDependentAndAConstantExpression(Var, SemaRef.Context)) {
            LSI.addPotentialCapture(E.IgnoreParens());
          }
        }
      }
    }
    if (!isTemplateInstantiation(TSK)) {
      return;
    }
    
    // Instantiate, but do not mark as odr-used, variable templates.
    MarkODRUsed = false;
  }
  
  VarTemplateSpecializationDecl /*P*/ VarSpec = dyn_cast_VarTemplateSpecializationDecl(Var);
  assert (!isa_VarTemplatePartialSpecializationDecl(Var)) : "Can't instantiate a partial template specialization.";
  
  // If this might be a member specialization of a static data member, check
  // the specialization is visible. We already did the checks for variable
  // template specializations when we created them.
  if (TSK != TemplateSpecializationKind.TSK_Undeclared && !isa_VarTemplateSpecializationDecl(Var)) {
    SemaRef.checkSpecializationVisibility(new SourceLocation(Loc), Var);
  }
  
  // Perform implicit instantiation of static data members, static data member
  // templates of class templates, and variable template specializations. Delay
  // instantiations of variable templates, except for those that could be used
  // in a constant expression.
  if (isTemplateInstantiation(TSK)) {
    boolean TryInstantiating = TSK == TemplateSpecializationKind.TSK_ImplicitInstantiation;
    if (TryInstantiating && !isa_VarTemplateSpecializationDecl(Var)) {
      if (Var.getPointOfInstantiation().isInvalid()) {
        {
          // This is a modification of an existing AST node. Notify listeners.
          ASTMutationListener /*P*/ L = SemaRef.getASTMutationListener();
          if ((L != null)) {
            L.StaticDataMemberInstantiated(Var);
          }
        }
      } else if (!Var.isUsableInConstantExpressions(SemaRef.Context)) {
        // Don't bother trying to instantiate it again, unless we might need
        // its initializer before we get to the end of the TU.
        TryInstantiating = false;
      }
    }
    if (Var.getPointOfInstantiation().isInvalid()) {
      Var.setTemplateSpecializationKind(TSK, new SourceLocation(Loc));
    }
    if (TryInstantiating) {
      SourceLocation PointOfInstantiation = Var.getPointOfInstantiation();
      bool$ref InstantiationDependent = create_bool$ref(false);
      boolean IsNonDependent = (VarSpec != null) ? !TemplateSpecializationType.anyDependentTemplateArguments(VarSpec.getTemplateArgsInfo(), InstantiationDependent) : true;
      
      // Do not instantiate specializations that are still type-dependent.
      if (IsNonDependent) {
        if (Var.isUsableInConstantExpressions(SemaRef.Context)) {
          // Do not defer instantiations of variables which could be used in a
          // constant expression.
          SemaRef.InstantiateVariableDefinition(new SourceLocation(PointOfInstantiation), Var);
        } else {
          SemaRef.PendingInstantiations.
              push_back_T$RR(std.make_pair_Ptr_T(Var, new SourceLocation(PointOfInstantiation)));
        }
      }
    }
  }
  if (!MarkODRUsed) {
    return;
  }
  
  // Per C++11 [basic.def.odr], a variable is odr-used "unless it satisfies
  // the requirements for appearing in a constant expression (5.19) and, if
  // it is an object, the lvalue-to-rvalue conversion (4.1)
  // is immediately applied."  We check the first part here, and
  // Sema::UpdateMarkingForLValueToRValue deals with the second part.
  // Note that we use the C++11 definition everywhere because nothing in
  // C++03 depends on whether we get the C++03 version correct. The second
  // part does not apply to references, since they are not objects.
  if ((E != null) && IsVariableAConstantExpression(Var, SemaRef.Context)) {
    // A reference initialized by a constant expression can never be
    // odr-used, so simply ignore it.
    if (!Var.getType().$arrow().isReferenceType()) {
      SemaRef.MaybeODRUseExprs.insert(E);
    }
  } else {
    MarkVarDeclODRUsed(Var, new SourceLocation(Loc), SemaRef, 
        /*MaxFunctionScopeIndex ptr*/ (/*const*/uint$ptr/*uint P*/ )null);
  }
}

//<editor-fold defaultstate="collapsed" desc="MarkExprReferenced">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 13988,
 FQN="MarkExprReferenced", NM="_ZL18MarkExprReferencedRN5clang4SemaENS_14SourceLocationEPNS_4DeclEPNS_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL18MarkExprReferencedRN5clang4SemaENS_14SourceLocationEPNS_4DeclEPNS_4ExprEb")
//</editor-fold>
public static void MarkExprReferenced(final Sema /*&*/ SemaRef, SourceLocation Loc, 
                  Decl /*P*/ D, Expr /*P*/ E, boolean MightBeOdrUse) {
  if (SemaRef.isInOpenMPDeclareTargetContext()) {
    SemaRef.checkDeclIsAllowedInOpenMPTarget(E, D);
  }
  {
    
    VarDecl /*P*/ Var = dyn_cast_VarDecl(D);
    if ((Var != null)) {
      DoMarkVarDeclReferenced(SemaRef, new SourceLocation(Loc), Var, E);
      return;
    }
  }
  
  SemaRef.MarkAnyDeclReferenced(new SourceLocation(Loc), D, MightBeOdrUse);
  
  // If this is a call to a method via a cast, also mark the method in the
  // derived class used in case codegen can devirtualize the call.
  /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E);
  if (!(ME != null)) {
    return;
  }
  CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(ME.getMemberDecl());
  if (!(MD != null)) {
    return;
  }
  // Only attempt to devirtualize if this is truly a virtual call.
  boolean IsVirtualCall = MD.isVirtual()
     && ME.performsVirtualDispatch(SemaRef.getLangOpts());
  if (!IsVirtualCall) {
    return;
  }
  /*const*/ Expr /*P*/ Base = ME.getBase();
  /*const*/ CXXRecordDecl /*P*/ MostDerivedClassDecl = Base.getBestDynamicClassType();
  if (!(MostDerivedClassDecl != null)) {
    return;
  }
  CXXMethodDecl /*P*/ DM = MD.getCorrespondingMethodInClass(MostDerivedClassDecl);
  if (!(DM != null) || DM.isPure()) {
    return;
  }
  SemaRef.MarkAnyDeclReferenced(new SourceLocation(Loc), DM, MightBeOdrUse);
}

//<editor-fold defaultstate="collapsed" desc="diagnoseUnknownAnyExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14910,
 FQN="diagnoseUnknownAnyExpr", NM="_ZL22diagnoseUnknownAnyExprRN5clang4SemaEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZL22diagnoseUnknownAnyExprRN5clang4SemaEPNS_4ExprE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > diagnoseUnknownAnyExpr(final Sema /*&*/ S, Expr /*P*/ E) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Expr /*P*/ orig = E;
    /*uint*/int diagID = diag.err_uncasted_use_of_unknown_any;
    while (true) {
      E = E.IgnoreParenImpCasts();
      {
        CallExpr /*P*/ call = dyn_cast_CallExpr(E);
        if ((call != null)) {
          E = call.getCallee();
          diagID = diag.err_uncasted_call_of_unknown_any;
        } else {
          break;
        }
      }
    }
    
    SourceLocation loc/*J*/= new SourceLocation();
    NamedDecl /*P*/ d;
    {
      DeclRefExpr /*P*/ ref = dyn_cast_DeclRefExpr(E);
      if ((ref != null)) {
        loc.$assignMove(ref.getLocation());
        d = ref.getDecl();
      } else {
        MemberExpr /*P*/ mem = dyn_cast_MemberExpr(E);
        if ((mem != null)) {
          loc.$assignMove(mem.getMemberLoc());
          d = mem.getMemberDecl();
        } else {
          ObjCMessageExpr /*P*/ msg = dyn_cast_ObjCMessageExpr(E);
          if ((msg != null)) {
            diagID = diag.err_uncasted_call_of_unknown_any;
            loc.$assignMove(msg.getSelectorStartLoc());
            d = msg.getMethodDecl();
            if (!(d != null)) {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(loc), diag.err_uncasted_send_to_unknown_any_method)), 
                          ((/*static_cast*//*uint*/int)((msg.isClassMessage() ? 1 : 0)))), msg.getSelector()), 
                  orig.getSourceRange()));
              return ExprError();
            }
          } else {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getExprLoc(), diag.err_unsupported_unknown_any_expr)), 
                E.getSourceRange()));
            return ExprError();
          }
        }
      }
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(loc), diagID)), d), orig.getSourceRange()));
    
    // Never recoverable.
    return ExprError();
  } finally {
    $c$.$destroy();
  }
}

} // END OF class SemaExprStatics
