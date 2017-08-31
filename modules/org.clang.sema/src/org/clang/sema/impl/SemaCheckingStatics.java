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
import org.clang.basic.Builtin.*;
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
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.sema.*;
import org.clang.basic.target.*;;
import static org.clang.analysis.analyses.analyze_format_string.Analyze_format_stringGlobals.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.DeclContext.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.llvm.support.AdtsupportLlvmGlobals.$out_raw_ostream_APSInt$C;


//<editor-fold defaultstate="collapsed" desc="static type SemaCheckingStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=Tpl__ZL21CXXRecordMembersNamedN4llvm9StringRefERN5clang4SemaENS1_8QualTypeE;_ZL13checkArgCountRN5clang4SemaEPNS_8CallExprEj;_ZL13isNonNullTypeRN5clang10ASTContextENS_8QualTypeE;_ZL14getNeonEltTypeN5clang13NeonTypeFlagsERNS_10ASTContextEbb;_ZL14isBlockPointerPN5clang4ExprE;_ZL15emitReplacementRN5clang4SemaENS_14SourceLocationENS_11SourceRangeEjNS_8QualTypeE;_ZL16CheckNonNullExprRN5clang4SemaEPKNS_4ExprE;_ZL16IsFunctionStdAbsPKN5clang12FunctionDeclE;_ZL16IsInAnyMacroBodyRKN5clang13SourceManagerENS_14SourceLocationE;_ZL16considerVariablePN5clang7VarDeclEPNS_4ExprERN12_GLOBAL__N_116RetainCycleOwnerE;_ZL16getSizeOfArgTypePKN5clang4ExprE;_ZL16getSizeOfExprArgPKN5clang4ExprE;_ZL16getStrlenExprArgPKN5clang4ExprE;_ZL17CheckForReferenceRN5clang4SemaEPKNS_4ExprERKNS_17PartialDiagnosticE;_ZL17CheckFormatStringRN5clang4SemaEPKNS_13StringLiteralEPKNS_4ExprEN4llvm8ArrayRefIS7_EEbjjNS0_16FormatStringTypeEbNS0_16VariadicCallTypeERNS8_14SmallBitVectorERN12_GLOBAL__N_119UncoveredArgHandlerE;_ZL17SemaBuiltinRWPipeRN5clang4SemaEPNS_8CallExprE;_ZL17changeAbsFunctionj17AbsoluteValueKind;_ZL17findCapturingExprRN5clang4SemaEPNS_4ExprERN12_GLOBAL__N_116RetainCycleOwnerE;_ZL18checkOpenCLPipeArgRN5clang4SemaEPNS_8CallExprE;_ZL18getBestAbsFunctionRN5clang10ASTContextENS_8QualTypeEj;_ZL18getOpenCLArgAccessPKN5clang4DeclE;_ZL18referToTheSameDeclPKN5clang4ExprES2_;_ZL19SemaBuiltinOverflowRN5clang4SemaEPNS_8CallExprE;_ZL19diagnoseRetainCycleRN5clang4SemaEPNS_4ExprERN12_GLOBAL__N_116RetainCycleOwnerE;_ZL20CheckNonNullArgumentRN5clang4SemaEPKNS_4ExprENS_14SourceLocationE;_ZL20CheckReturnStackAddrRN5clang4SemaEPNS_4ExprENS_8QualTypeENS_14SourceLocationE;_ZL20SemaBuiltinAddressofRN5clang4SemaEPNS_8CallExprE;_ZL20checkBuiltinArgumentRN5clang4SemaEPNS_8CallExprEj;_ZL20checkOpenCLBlockArgsRN5clang4SemaEPNS_4ExprE;_ZL20findRetainCycleOwnerRN5clang4SemaEPNS_4ExprERN12_GLOBAL__N_116RetainCycleOwnerE;_ZL20getAbsoluteValueKindN5clang8QualTypeE;_ZL20isSetterLikeSelectorN5clang8SelectorE;_ZL20isValidOrderingForOpxN5clang10AtomicExpr8AtomicOpE;_ZL21CheckNonNullArgumentsRN5clang4SemaEPKNS_9NamedDeclEPKNS_17FunctionProtoTypeEN4llvm8ArrayRefIPKNS_4ExprEEENS_14SourceLocationE;_ZL21GetNSSetArgumentIndexRN5clang4SemaEPNS_15ObjCMessageExprE;_ZL21SemaBuiltinAnnotationRN5clang4SemaEPNS_8CallExprE;_ZL21SemaBuiltinMemChkCallRN5clang4SemaEPNS_12FunctionDeclEPNS_8CallExprEjj;_ZL21checkFormatStringExprRN5clang4SemaEPKNS_4ExprEN4llvm8ArrayRefIS4_EEbjjNS0_16FormatStringTypeENS0_16VariadicCallTypeEbRNS5_14SmallBitVectorERN12_GLOBAL__N_119UncoveredArgHandlerE;_ZL22SemaBuiltinCpuSupportsRN5clang4SemaEPNS_8CallExprE;_ZL22SemaBuiltinPipePacketsRN5clang4SemaEPNS_8CallExprE;_ZL22ignoreLiteralAdditionsPKN5clang4ExprERNS_10ASTContextE;_ZL22shouldNotPrintDirectlyRKN5clang10ASTContextENS_8QualTypeEPKNS_4ExprE;_ZL23IsTailPaddedMemberArrayRN5clang4SemaERKN4llvm5APIntEPKNS_9NamedDeclE;_ZL23SemaBuiltinCommitRWPipeRN5clang4SemaEPNS_8CallExprE;_ZL23SemaOpenCLBuiltinToAddrRN5clang4SemaEjPNS_8CallExprE;_ZL23checkUnsafeAssignObjectRN5clang4SemaENS_14SourceLocationENS_10Qualifiers12ObjCLifetimeEPNS_4ExprEb;_ZL23requiresParensToAddCastPKN5clang4ExprE;_ZL24SemaBuiltinReserveRWPipeRN5clang4SemaEPNS_8CallExprE;_ZL24SemaBuiltinSEHScopeCheckRN5clang4SemaEPNS_8CallExprENS_5Scope10ScopeFlagsEj;_ZL24checkUnsafeAssignLiteralRN5clang4SemaENS_14SourceLocationEPNS_4ExprEb;_ZL24getContainedDynamicClassN5clang8QualTypeERb;_ZL25checkOpenCLPipePacketTypeRN5clang4SemaEPNS_8CallExprEj;_ZL28diagnoseArrayStarInParamTypeRN5clang4SemaENS_8QualTypeENS_14SourceLocationE;_ZL28getAbsoluteValueArgumentTypeRN5clang10ASTContextEj;_ZL28getAbsoluteValueFunctionKindPKN5clang12FunctionDeclE;_ZL30CheckMemorySizeofForComparisonRN5clang4SemaEPKNS_4ExprEPNS_14IdentifierInfoENS_14SourceLocationES7_;_ZL30GetNSMutableArrayArgumentIndexRN5clang4SemaEPNS_15ObjCMessageExprE;_ZL30SemaBuiltinCallWithStaticChainRN5clang4SemaEPNS_8CallExprE;_ZL30SemaOpenCLBuiltinEnqueueKernelRN5clang4SemaEPNS_8CallExprE;_ZL30checkOpenCLEnqueueVariadicArgsRN5clang4SemaEPNS_8CallExprEPNS_4ExprEj;_ZL30getLargerAbsoluteValueFunctionj;_ZL31checkOpenCLEnqueueLocalSizeArgsRN5clang4SemaEPNS_8CallExprEjj;_ZL35GetNSMutableDictionaryArgumentIndexRN5clang4SemaEPNS_15ObjCMessageExprE;_ZL36SemaOpenCLBuiltinKernelWorkGroupSizeRN5clang4SemaEPNS_8CallExprE;_ZL37DiagnoseCStringFormatDirectiveInCFAPIRN5clang4SemaEPKNS_9NamedDeclEPPNS_4ExprEj;_ZL3RFTjbb;_ZL41isConstantSizeArrayWithMoreThanOneElementN5clang8QualTypeERNS_10ASTContextE;_ZL7EvalValPKN5clang4ExprERN4llvm15SmallVectorImplIPKNS_11DeclRefExprEEEPKNS_4DeclE;_ZL8EvalAddrPKN5clang4ExprERN4llvm15SmallVectorImplIPKNS_11DeclRefExprEEEPKNS_4DeclE;_ZN12_GLOBAL__N_111GetExprTypeEPKN5clang4ExprE;_ZN12_GLOBAL__N_111HasEnumTypeEPN5clang4ExprE;_ZN12_GLOBAL__N_112GetExprRangeERN5clang10ASTContextEPKNS0_4ExprE;_ZN12_GLOBAL__N_112GetExprRangeERN5clang10ASTContextEPKNS0_4ExprEj;_ZN12_GLOBAL__N_113GetValueRangeERN5clang10ASTContextERN4llvm6APSIntEj;_ZN12_GLOBAL__N_113GetValueRangeERN5clang10ASTContextERNS0_7APValueENS0_8QualTypeEj;_ZN12_GLOBAL__N_114IsSameCharTypeEN5clang8QualTypeES1_;_ZN12_GLOBAL__N_115DiagnoseImpCastERN5clang4SemaEPNS0_4ExprENS0_8QualTypeENS0_14SourceLocationEjb;_ZN12_GLOBAL__N_115DiagnoseImpCastERN5clang4SemaEPNS0_4ExprENS0_8QualTypeES5_NS0_14SourceLocationEjb;_ZN12_GLOBAL__N_115FindTypeTagExprEPKN5clang4ExprERKNS0_10ASTContextEPPKNS0_9ValueDeclEPy;_ZN12_GLOBAL__N_116GetMatchingCTypeEPKN5clang14IdentifierInfoEPKNS0_4ExprERKNS0_10ASTContextEPKN4llvm8DenseMapISt4pairIS3_yENS0_4Sema11TypeTagDataENSA_12DenseMapInfoISD_EENSA_6detail12DenseMapPairISD_SF_EEEERbRSF_;_ZN12_GLOBAL__N_117AnalyzeAssignmentERN5clang4SemaEPNS0_14BinaryOperatorE;_ZN12_GLOBAL__N_117AnalyzeComparisonERN5clang4SemaEPNS0_14BinaryOperatorE;_ZN12_GLOBAL__N_118PrettyPrintInRangeERKN4llvm6APSIntENS_8IntRangeE;_ZN12_GLOBAL__N_118isLayoutCompatibleERN5clang10ASTContextENS0_8QualTypeES3_;_ZN12_GLOBAL__N_118isLayoutCompatibleERN5clang10ASTContextEPNS0_10RecordDeclES4_;_ZN12_GLOBAL__N_118isLayoutCompatibleERN5clang10ASTContextEPNS0_8EnumDeclES4_;_ZN12_GLOBAL__N_118isLayoutCompatibleERN5clang10ASTContextEPNS0_9FieldDeclES4_;_ZN12_GLOBAL__N_120IsSameFloatAfterCastERKN4llvm7APFloatERKNS0_12fltSemanticsES6_;_ZN12_GLOBAL__N_120IsSameFloatAfterCastERKN5clang7APValueERKN4llvm12fltSemanticsES7_;_ZN12_GLOBAL__N_121checkObjCArrayLiteralERN5clang4SemaENS0_8QualTypeEPNS0_16ObjCArrayLiteralE;_ZN12_GLOBAL__N_122DiagnoseNullConversionERN5clang4SemaEPNS0_4ExprENS0_8QualTypeENS0_14SourceLocationE;_ZN12_GLOBAL__N_123CheckBoolLikeConversionERN5clang4SemaEPNS0_4ExprENS0_14SourceLocationE;_ZN12_GLOBAL__N_123CheckConditionalOperandERN5clang4SemaEPNS0_4ExprENS0_8QualTypeENS0_14SourceLocationERb;_ZN12_GLOBAL__N_123CheckImplicitConversionERN5clang4SemaEPNS0_4ExprENS0_8QualTypeENS0_14SourceLocationEPb;_ZN12_GLOBAL__N_123DiagnoseFloatingImpCastERN5clang4SemaEPNS0_4ExprENS0_8QualTypeENS0_14SourceLocationE;_ZN12_GLOBAL__N_123isLayoutCompatibleUnionERN5clang10ASTContextEPNS0_10RecordDeclES4_;_ZN12_GLOBAL__N_124CheckConditionalOperatorERN5clang4SemaEPNS0_19ConditionalOperatorENS0_14SourceLocationENS0_8QualTypeE;_ZN12_GLOBAL__N_124isLayoutCompatibleStructERN5clang10ASTContextEPNS0_10RecordDeclES4_;_ZN12_GLOBAL__N_125AnalyzeBitFieldAssignmentERN5clang4SemaEPNS0_9FieldDeclEPNS0_4ExprENS0_14SourceLocationE;_ZN12_GLOBAL__N_126AnalyzeImplicitConversionsERN5clang4SemaEPNS0_4ExprENS0_14SourceLocationE;_ZN12_GLOBAL__N_126checkObjCDictionaryLiteralERN5clang4SemaENS0_8QualTypeEPNS0_21ObjCDictionaryLiteralE;_ZN12_GLOBAL__N_127AnalyzeImpConvsInComparisonERN5clang4SemaEPNS0_14BinaryOperatorE;_ZN12_GLOBAL__N_127ShouldDiagnoseEmptyStmtBodyERKN5clang13SourceManagerENS0_14SourceLocationEPKNS0_8NullStmtE;_ZN12_GLOBAL__N_128DiagnoseOutOfRangeComparisonERN5clang4SemaEPNS0_14BinaryOperatorEPNS0_4ExprES6_RKN4llvm6APSIntEb;_ZN12_GLOBAL__N_129IsImplicitBoolFloatConversionERN5clang4SemaEPNS0_4ExprEb;_ZN12_GLOBAL__N_129isSameWidthConstantConversionERN5clang4SemaEPNS0_4ExprENS0_8QualTypeENS0_14SourceLocationE;_ZN12_GLOBAL__N_130CheckTrivialUnsignedComparisonERN5clang4SemaEPNS0_14BinaryOperatorE;_ZN12_GLOBAL__N_132CheckImplicitArgumentConversionsERN5clang4SemaEPNS0_8CallExprENS0_14SourceLocationE;_ZN12_GLOBAL__N_133checkObjCCollectionLiteralElementERN5clang4SemaENS0_8QualTypeEPNS0_4ExprEj;_ZN12_GLOBAL__N_16IsZeroERN5clang4SemaEPNS0_4ExprE; -static-type=SemaCheckingStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaCheckingStatics {


/// Checks that a call expression's argument count is the desired number.
/// This is useful when doing custom type-checking.  Returns true on error.
//<editor-fold defaultstate="collapsed" desc="checkArgCount">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 56,
 FQN="checkArgCount", NM="_ZL13checkArgCountRN5clang4SemaEPNS_8CallExprEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL13checkArgCountRN5clang4SemaEPNS_8CallExprEj")
//</editor-fold>
public static boolean checkArgCount(final Sema /*&*/ S, CallExpr /*P*/ call, /*uint*/int desiredArgCount) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    /*uint*/int argCount = call.getNumArgs();
    if (argCount == desiredArgCount) {
      return false;
    }
    if ($less_uint(argCount, desiredArgCount)) {
      return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_uint($out_SemaDiagnosticBuilder_uint($out_SemaDiagnosticBuilder_int($c$.track(S.Diag(call.getLocEnd(), diag.err_typecheck_call_too_few_args)), 
                      0/*function call*/), desiredArgCount), argCount), 
          call.getSourceRange()).$bool());
    }
    
    // Highlight all the excess arguments.
    SourceRange range/*J*/= new SourceRange(call.getArg(desiredArgCount).getLocStart(), 
        call.getArg(argCount - 1).getLocEnd());
    
    return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_uint($out_SemaDiagnosticBuilder_uint($out_SemaDiagnosticBuilder_int($c$.track(S.Diag(range.getBegin(), diag.err_typecheck_call_too_many_args)), 
                    0/*function call*/), desiredArgCount), argCount), 
        call.getArg(1).getSourceRange()).$bool());
  } finally {
    $c$.$destroy();
  }
}


/// Check that the first argument to __builtin_annotation is an integer
/// and the second argument is a non-wide string literal.
//<editor-fold defaultstate="collapsed" desc="SemaBuiltinAnnotation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 76,
 FQN="SemaBuiltinAnnotation", NM="_ZL21SemaBuiltinAnnotationRN5clang4SemaEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL21SemaBuiltinAnnotationRN5clang4SemaEPNS_8CallExprE")
//</editor-fold>
public static boolean SemaBuiltinAnnotation(final Sema /*&*/ S, CallExpr /*P*/ TheCall) {
  if (checkArgCount(S, TheCall, 2)) {
    return true;
  }
  
  // First argument should be an integer.
  Expr /*P*/ ValArg = TheCall.getArg(0);
  QualType Ty = ValArg.getType();
  if (!Ty.$arrow().isIntegerType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(ValArg.getLocStart(), diag.err_builtin_annotation_first_arg)), 
          ValArg.getSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Second argument should be a constant string.
  Expr /*P*/ StrArg = TheCall.getArg(1).IgnoreParenCasts();
  StringLiteral /*P*/ Literal = dyn_cast_StringLiteral(StrArg);
  if (!(Literal != null) || !Literal.isAscii()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(StrArg.getLocStart(), diag.err_builtin_annotation_second_arg)), 
          StrArg.getSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  TheCall.setType(new QualType(Ty));
  return false;
}


/// Check that the argument to __builtin_addressof is a glvalue, and set the
/// result type to the corresponding pointer type.
//<editor-fold defaultstate="collapsed" desc="SemaBuiltinAddressof">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 104,
 FQN="SemaBuiltinAddressof", NM="_ZL20SemaBuiltinAddressofRN5clang4SemaEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL20SemaBuiltinAddressofRN5clang4SemaEPNS_8CallExprE")
//</editor-fold>
public static boolean SemaBuiltinAddressof(final Sema /*&*/ S, CallExpr /*P*/ TheCall) {
  if (checkArgCount(S, TheCall, 1)) {
    return true;
  }
  
  ActionResultTTrue<Expr /*P*/ > Arg/*J*/= new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, TheCall.getArg(0));
  QualType ResultType = S.CheckAddressOfOperand(Arg, TheCall.getLocStart());
  if (ResultType.isNull()) {
    return true;
  }
  
  TheCall.setArg(0, Arg.get());
  TheCall.setType(new QualType(ResultType));
  return false;
}

//<editor-fold defaultstate="collapsed" desc="SemaBuiltinOverflow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 118,
 FQN="SemaBuiltinOverflow", NM="_ZL19SemaBuiltinOverflowRN5clang4SemaEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL19SemaBuiltinOverflowRN5clang4SemaEPNS_8CallExprE")
//</editor-fold>
public static boolean SemaBuiltinOverflow(final Sema /*&*/ S, CallExpr /*P*/ TheCall) {
  if (checkArgCount(S, TheCall, 3)) {
    return true;
  }
  
  // First two arguments should be integers.
  for (/*uint*/int I = 0; $less_uint(I, 2); ++I) {
    Expr /*P*/ Arg = TheCall.getArg(I);
    QualType Ty = Arg.getType();
    if (!Ty.$arrow().isIntegerType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getLocStart(), diag.err_overflow_builtin_must_be_int)), 
                Ty), Arg.getSourceRange()));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
  }
  {
    Expr /*P*/ Arg = TheCall.getArg(2);
    QualType Ty = Arg.getType();
    /*const*/ PointerType /*P*/ PtrTy = Ty.$arrow().getAs(PointerType.class);
    if (!((PtrTy != null) && PtrTy.getPointeeType().$arrow().isIntegerType()
       && !PtrTy.getPointeeType().isConstQualified())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg.getLocStart(), diag.err_overflow_builtin_must_be_ptr_int)), 
                Ty), Arg.getSourceRange()));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="SemaBuiltinMemChkCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 151,
 FQN="SemaBuiltinMemChkCall", NM="_ZL21SemaBuiltinMemChkCallRN5clang4SemaEPNS_12FunctionDeclEPNS_8CallExprEjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL21SemaBuiltinMemChkCallRN5clang4SemaEPNS_12FunctionDeclEPNS_8CallExprEjj")
//</editor-fold>
public static void SemaBuiltinMemChkCall(final Sema /*&*/ S, FunctionDecl /*P*/ FDecl, 
                     CallExpr /*P*/ TheCall, /*uint*/int SizeIdx, 
                     /*uint*/int DstSizeIdx) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if ($lesseq_uint(TheCall.getNumArgs(), SizeIdx)
       || $lesseq_uint(TheCall.getNumArgs(), DstSizeIdx)) {
      return;
    }
    
    /*const*/ Expr /*P*/ SizeArg = TheCall.getArg(SizeIdx);
    /*const*/ Expr /*P*/ DstSizeArg = TheCall.getArg(DstSizeIdx);
    
    APSInt Size/*J*/= new APSInt(), DstSize/*J*/= new APSInt();
    
    // find out if both sizes are known at compile time
    if (!SizeArg.EvaluateAsInt(Size, S.Context)
       || !DstSizeArg.EvaluateAsInt(DstSize, S.Context)) {
      return;
    }
    if (Size.ule(DstSize)) {
      return;
    }
    
    // confirmed overflow so generate the diagnostic.
    IdentifierInfo /*P*/ FnName = FDecl.getIdentifier();
    SourceLocation SL = TheCall.getLocStart();
    SourceRange SR = TheCall.getSourceRange();
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(SL), diag.warn_memcpy_chk_overflow)), SR), FnName));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="SemaBuiltinCallWithStaticChain">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 179,
 FQN="SemaBuiltinCallWithStaticChain", NM="_ZL30SemaBuiltinCallWithStaticChainRN5clang4SemaEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL30SemaBuiltinCallWithStaticChainRN5clang4SemaEPNS_8CallExprE")
//</editor-fold>
public static boolean SemaBuiltinCallWithStaticChain(final Sema /*&*/ S, CallExpr /*P*/ BuiltinCall) {
  if (checkArgCount(S, BuiltinCall, 2)) {
    return true;
  }
  
  SourceLocation BuiltinLoc = BuiltinCall.getLocStart();
  Expr /*P*/ Builtin = BuiltinCall.getCallee().IgnoreImpCasts();
  Expr /*P*/ Call = BuiltinCall.getArg(0);
  Expr /*P*/ Chain = BuiltinCall.getArg(1);
  if (Call.getStmtClass() != Stmt.StmtClass.CallExprClass) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(BuiltinLoc), diag.err_first_argument_to_cwsc_not_call)), 
          Call.getSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  CallExpr /*P*/ CE = cast_CallExpr(Call);
  if (CE.getCallee().getType().$arrow().isBlockPointerType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(BuiltinLoc), diag.err_first_argument_to_cwsc_block_call)), 
          Call.getSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  /*const*/ Decl /*P*/ TargetDecl = CE.getCalleeDecl();
  {
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(TargetDecl);
    if ((FD != null)) {
      if ((FD.getBuiltinID() != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(BuiltinLoc), diag.err_first_argument_to_cwsc_builtin_call)), 
              Call.getSourceRange()));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  if (isa_CXXPseudoDestructorExpr(CE.getCallee().IgnoreParens())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(BuiltinLoc), diag.err_first_argument_to_cwsc_pdtor_call)), 
          Call.getSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  ActionResultTTrue<Expr /*P*/ > ChainResult = S.UsualUnaryConversions(Chain);
  if (ChainResult.isInvalid()) {
    return true;
  }
  if (!ChainResult.get().getType().$arrow().isPointerType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(BuiltinLoc), diag.err_second_argument_to_cwsc_not_pointer)), 
          Chain.getSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  QualType ReturnTy = CE.getCallReturnType(S.Context);
  QualType ArgTys[/*2*/] = new QualType [/*2*/] {ReturnTy, ChainResult.get().getType()};
  QualType BuiltinTy = S.Context.getFunctionType(new QualType(ReturnTy), new ArrayRef<QualType>(ArgTys, false), new FunctionProtoType.ExtProtoInfo());
  QualType BuiltinPtrTy = S.Context.getPointerType(new QualType(BuiltinTy));
  
  Builtin
     = S.ImpCastExprToType(Builtin, new QualType(BuiltinPtrTy), CastKind.CK_BuiltinFnToFnPtr).get();
  
  BuiltinCall.setType(CE.getType());
  BuiltinCall.setValueKind(CE.getValueKind());
  BuiltinCall.setObjectKind(CE.getObjectKind());
  BuiltinCall.setCallee(Builtin);
  BuiltinCall.setArg(1, ChainResult.get());
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="SemaBuiltinSEHScopeCheck">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 242,
 FQN="SemaBuiltinSEHScopeCheck", NM="_ZL24SemaBuiltinSEHScopeCheckRN5clang4SemaEPNS_8CallExprENS_5Scope10ScopeFlagsEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL24SemaBuiltinSEHScopeCheckRN5clang4SemaEPNS_8CallExprENS_5Scope10ScopeFlagsEj")
//</editor-fold>
public static boolean SemaBuiltinSEHScopeCheck(final Sema /*&*/ SemaRef, CallExpr /*P*/ TheCall, 
                        /*Scope::ScopeFlags*//*uint*/int NeededScopeFlags, 
                        /*uint*/int DiagID) {
  // Scopes aren't available during instantiation. Fortunately, builtin
  // functions cannot be template args so they cannot be formed through template
  // instantiation. Therefore checking once during the parse is sufficient.
  if (!SemaRef.ActiveTemplateInstantiations.empty()) {
    return false;
  }
  
  Scope /*P*/ S = SemaRef.getCurScope();
  while ((S != null) && !S.isSEHExceptScope()) {
    S = S.getParent();
  }
  if (!(S != null) || !((S.getFlags() & NeededScopeFlags) != 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      DeclRefExpr /*P*/ DRE = cast_DeclRefExpr(TheCall.getCallee().IgnoreParenCasts());
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(TheCall.getExprLoc(), DiagID)), 
          DRE.getDecl().getIdentifier()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isBlockPointer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 264,
 FQN="isBlockPointer", NM="_ZL14isBlockPointerPN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL14isBlockPointerPN5clang4ExprE")
//</editor-fold>
public static /*inline*/ boolean isBlockPointer(Expr /*P*/ Arg) {
  return Arg.getType().$arrow().isBlockPointerType();
}


/// OpenCL C v2.0, s6.13.17.2 - Checks that the block parameters are all local
/// void*, which is a requirement of device side enqueue.
//<editor-fold defaultstate="collapsed" desc="checkOpenCLBlockArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 270,
 FQN="checkOpenCLBlockArgs", NM="_ZL20checkOpenCLBlockArgsRN5clang4SemaEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL20checkOpenCLBlockArgsRN5clang4SemaEPNS_4ExprE")
//</editor-fold>
public static boolean checkOpenCLBlockArgs(final Sema /*&*/ S, Expr /*P*/ BlockArg) {
  /*const*/ BlockPointerType /*P*/ BPT = cast_BlockPointerType(BlockArg.getType().getCanonicalType());
  ArrayRef<QualType> Params = BPT.getPointeeType().$arrow().getAs(FunctionProtoType.class).getParamTypes();
  /*uint*/int ArgCounter = 0;
  boolean IllegalParams = false;
  // Iterate through the block parameters until either one is found that is not
  // a local void*, or the block is valid.
  for (type$ptr<QualType> I = $tryClone(Params.begin()), /*P*/ E = $tryClone(Params.end());
       $noteq_ptr(I, E); I.$preInc() , ++ArgCounter) {
    if (!(I.$star()).$arrow().isPointerType() || !(I.$star()).$arrow().getPointeeType().$arrow().isVoidType()
       || (I.$star()).$arrow().getPointeeType().getQualifiers().getAddressSpace()
       != LangAS.ID.opencl_local) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Get the location of the error. If a block literal has been passed
        // (BlockExpr) then we can point straight to the offending argument,
        // else we just point to the variable reference.
        SourceLocation ErrorLoc/*J*/= new SourceLocation();
        if (isa_BlockExpr(BlockArg)) {
          BlockDecl /*P*/ BD = cast_BlockExpr(BlockArg).getBlockDecl();
          ErrorLoc.$assignMove(BD.getParamDecl(ArgCounter).getLocStart());
        } else if (isa_DeclRefExpr(BlockArg)) {
          ErrorLoc.$assignMove(cast_DeclRefExpr(BlockArg).getLocStart());
        }
        $c$.clean($c$.track(S.Diag(new SourceLocation(ErrorLoc), 
            diag.err_opencl_enqueue_kernel_blocks_non_local_void_args)));
        IllegalParams = true;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  return IllegalParams;
}


/// OpenCL C v2.0, s6.13.17.6 - Check the argument to the
/// get_kernel_work_group_size
/// and get_kernel_preferred_work_group_size_multiple builtin functions.
//<editor-fold defaultstate="collapsed" desc="SemaOpenCLBuiltinKernelWorkGroupSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 306,
 FQN="SemaOpenCLBuiltinKernelWorkGroupSize", NM="_ZL36SemaOpenCLBuiltinKernelWorkGroupSizeRN5clang4SemaEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL36SemaOpenCLBuiltinKernelWorkGroupSizeRN5clang4SemaEPNS_8CallExprE")
//</editor-fold>
public static boolean SemaOpenCLBuiltinKernelWorkGroupSize(final Sema /*&*/ S, CallExpr /*P*/ TheCall) {
  if (checkArgCount(S, TheCall, 1)) {
    return true;
  }
  
  Expr /*P*/ BlockArg = TheCall.getArg(0);
  if (!isBlockPointer(BlockArg)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(BlockArg.getLocStart(), 
              diag.err_opencl_enqueue_kernel_expected_type)), /*KEEP_STR*/"block"));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  return checkOpenCLBlockArgs(S, BlockArg);
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="checkOpenCLEnqueueLocalSizeArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8589,
 FQN="checkOpenCLEnqueueLocalSizeArgs", NM="_ZL31checkOpenCLEnqueueLocalSizeArgsRN5clang4SemaEPNS_8CallExprEjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL31checkOpenCLEnqueueLocalSizeArgsRN5clang4SemaEPNS_8CallExprEjj")
//</editor-fold>
public static boolean checkOpenCLEnqueueLocalSizeArgs(final Sema /*&*/ S, CallExpr /*P*/ TheCall, 
                               /*uint*/int Start, /*uint*/int End) {
  boolean IllegalParams = false;
  for (/*uint*/int I = Start; $lesseq_uint(I, End); ++I) {
    QualType Ty = TheCall.getArg(I).getType();
    // Taking into account implicit conversions,
    // allow any integer within 32 bits range
    if (!Ty.$arrow().isIntegerType()
       || S.Context.getTypeSizeInChars(new QualType(Ty)).getQuantity() > 4) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(TheCall.getArg(I).getLocStart(), 
            diag.err_opencl_enqueue_kernel_invalid_local_size_type)));
        IllegalParams = true;
      } finally {
        $c$.$destroy();
      }
    }
    // Potentially emit standard warnings for implicit conversions if enabled
    // using -Wconversion.
    CheckImplicitConversion(S, TheCall.getArg(I), S.Context.UnsignedIntTy.$QualType(), 
        TheCall.getArg(I).getLocStart());
  }
  return IllegalParams;
}


/// OpenCL v2.0, s6.13.17.1 - Check that sizes are provided for all
/// 'local void*' parameter of passed block.
//<editor-fold defaultstate="collapsed" desc="checkOpenCLEnqueueVariadicArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 324,
 FQN="checkOpenCLEnqueueVariadicArgs", NM="_ZL30checkOpenCLEnqueueVariadicArgsRN5clang4SemaEPNS_8CallExprEPNS_4ExprEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL30checkOpenCLEnqueueVariadicArgsRN5clang4SemaEPNS_8CallExprEPNS_4ExprEj")
//</editor-fold>
public static boolean checkOpenCLEnqueueVariadicArgs(final Sema /*&*/ S, CallExpr /*P*/ TheCall, 
                              Expr /*P*/ BlockArg, 
                              /*uint*/int NumNonVarArgs) {
  /*const*/ BlockPointerType /*P*/ BPT = cast_BlockPointerType(BlockArg.getType().getCanonicalType());
  /*uint*/int NumBlockParams = BPT.getPointeeType().$arrow().getAs(FunctionProtoType.class).getNumParams();
  /*uint*/int TotalNumArgs = TheCall.getNumArgs();
  
  // For each argument passed to the block, a corresponding uint needs to
  // be passed to describe the size of the local memory.
  if (TotalNumArgs != NumBlockParams + NumNonVarArgs) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(TheCall.getLocStart(), 
          diag.err_opencl_enqueue_kernel_local_size_args)));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Check that the sizes of the local memory are specified by integers.
  return checkOpenCLEnqueueLocalSizeArgs(S, TheCall, NumNonVarArgs, 
      TotalNumArgs - 1);
}


/// OpenCL C v2.0, s6.13.17 - Enqueue kernel function contains four different
/// overload formats specified in Table 6.13.17.1.
/// int enqueue_kernel(queue_t queue,
///                    kernel_enqueue_flags_t flags,
///                    const ndrange_t ndrange,
///                    void (^block)(void))
/// int enqueue_kernel(queue_t queue,
///                    kernel_enqueue_flags_t flags,
///                    const ndrange_t ndrange,
///                    uint num_events_in_wait_list,
///                    clk_event_t *event_wait_list,
///                    clk_event_t *event_ret,
///                    void (^block)(void))
/// int enqueue_kernel(queue_t queue,
///                    kernel_enqueue_flags_t flags,
///                    const ndrange_t ndrange,
///                    void (^block)(local void*, ...),
///                    uint size0, ...)
/// int enqueue_kernel(queue_t queue,
///                    kernel_enqueue_flags_t flags,
///                    const ndrange_t ndrange,
///                    uint num_events_in_wait_list,
///                    clk_event_t *event_wait_list,
///                    clk_event_t *event_ret,
///                    void (^block)(local void*, ...),
///                    uint size0, ...)
//<editor-fold defaultstate="collapsed" desc="SemaOpenCLBuiltinEnqueueKernel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 372,
 FQN="SemaOpenCLBuiltinEnqueueKernel", NM="_ZL30SemaOpenCLBuiltinEnqueueKernelRN5clang4SemaEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL30SemaOpenCLBuiltinEnqueueKernelRN5clang4SemaEPNS_8CallExprE")
//</editor-fold>
public static boolean SemaOpenCLBuiltinEnqueueKernel(final Sema /*&*/ S, CallExpr /*P*/ TheCall) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    /*uint*/int NumArgs = TheCall.getNumArgs();
    if ($less_uint(NumArgs, 4)) {
      $c$.clean($c$.track(S.Diag(TheCall.getLocStart(), diag.err_typecheck_call_too_few_args)));
      return true;
    }
    
    Expr /*P*/ Arg0 = TheCall.getArg(0);
    Expr /*P*/ Arg1 = TheCall.getArg(1);
    Expr /*P*/ Arg2 = TheCall.getArg(2);
    Expr /*P*/ Arg3 = TheCall.getArg(3);
    
    // First argument always needs to be a queue_t type.
    if (!Arg0.getType().$arrow().isQueueT()) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(TheCall.getArg(0).getLocStart(), 
              diag.err_opencl_enqueue_kernel_expected_type)), 
          S.Context.OCLQueueTy));
      return true;
    }
    
    // Second argument always needs to be a kernel_enqueue_flags_t enum value.
    if (!Arg1.getType().$arrow().isIntegerType()) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(TheCall.getArg(1).getLocStart(), 
              diag.err_opencl_enqueue_kernel_expected_type)), 
          /*KEEP_STR*/"'kernel_enqueue_flags_t' (i.e. uint)"));
      return true;
    }
    
    // Third argument is always an ndrange_t type.
    if (!Arg2.getType().$arrow().isNDRangeT()) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(TheCall.getArg(2).getLocStart(), 
              diag.err_opencl_enqueue_kernel_expected_type)), 
          S.Context.OCLNDRangeTy));
      return true;
    }
    
    // With four arguments, there is only one form that the function could be
    // called in: no events and no variable arguments.
    if (NumArgs == 4) {
      // check that the last argument is the right block type.
      if (!isBlockPointer(Arg3)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg3.getLocStart(), diag.err_opencl_enqueue_kernel_expected_type)), 
            /*KEEP_STR*/"block"));
        return true;
      }
      // we have a block type, check the prototype
      /*const*/ BlockPointerType /*P*/ BPT = cast_BlockPointerType(Arg3.getType().getCanonicalType());
      if ($greater_uint(BPT.getPointeeType().$arrow().getAs(FunctionProtoType.class).getNumParams(), 0)) {
        $c$.clean($c$.track(S.Diag(Arg3.getLocStart(), 
            diag.err_opencl_enqueue_kernel_blocks_no_args)));
        return true;
      }
      return false;
    }
    // we can have block + varargs.
    if (isBlockPointer(Arg3)) {
      return (checkOpenCLBlockArgs(S, Arg3)
         || checkOpenCLEnqueueVariadicArgs(S, TheCall, Arg3, 4));
    }
    // last two cases with either exactly 7 args or 7 args and varargs.
    if ($greatereq_uint(NumArgs, 7)) {
      // check common block argument.
      Expr /*P*/ Arg6 = TheCall.getArg(6);
      if (!isBlockPointer(Arg6)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg6.getLocStart(), diag.err_opencl_enqueue_kernel_expected_type)), 
            /*KEEP_STR*/"block"));
        return true;
      }
      if (checkOpenCLBlockArgs(S, Arg6)) {
        return true;
      }
      
      // Forth argument has to be any integer type.
      if (!Arg3.getType().$arrow().isIntegerType()) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(TheCall.getArg(3).getLocStart(), 
                diag.err_opencl_enqueue_kernel_expected_type)), 
            /*KEEP_STR*/"integer"));
        return true;
      }
      // check remaining common arguments.
      Expr /*P*/ Arg4 = TheCall.getArg(4);
      Expr /*P*/ Arg5 = TheCall.getArg(5);
      
      // Fith argument is always passed as pointers to clk_event_t.
      if (!Arg4.getType().$arrow().getPointeeOrArrayElementType().isClkEventT()) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(TheCall.getArg(4).getLocStart(), 
                diag.err_opencl_enqueue_kernel_expected_type)), 
            S.Context.getPointerType(/*NO_COPY*/S.Context.OCLClkEventTy)));
        return true;
      }
      
      // Sixth argument is always passed as pointers to clk_event_t.
      if (!(Arg5.getType().$arrow().isPointerType()
         && Arg5.getType().$arrow().getPointeeType().$arrow().isClkEventT())) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(TheCall.getArg(5).getLocStart(), 
                diag.err_opencl_enqueue_kernel_expected_type)), 
            S.Context.getPointerType(/*NO_COPY*/S.Context.OCLClkEventTy)));
        return true;
      }
      if (NumArgs == 7) {
        return false;
      }
      
      return checkOpenCLEnqueueVariadicArgs(S, TheCall, Arg6, 7);
    }
    
    // None of the specific case has been detected, give generic error
    $c$.clean($c$.track(S.Diag(TheCall.getLocStart(), 
        diag.err_opencl_enqueue_kernel_incorrect_args)));
    return true;
  } finally {
    $c$.$destroy();
  }
}


/// Returns OpenCL access qual.
//<editor-fold defaultstate="collapsed" desc="getOpenCLArgAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 485,
 FQN="getOpenCLArgAccess", NM="_ZL18getOpenCLArgAccessPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL18getOpenCLArgAccessPKN5clang4DeclE")
//</editor-fold>
public static OpenCLAccessAttr /*P*/ getOpenCLArgAccess(/*const*/ Decl /*P*/ D) {
  return D.getAttr(OpenCLAccessAttr.class);
}


/// Returns true if pipe element type is different from the pointer.
//<editor-fold defaultstate="collapsed" desc="checkOpenCLPipeArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 490,
 FQN="checkOpenCLPipeArg", NM="_ZL18checkOpenCLPipeArgRN5clang4SemaEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL18checkOpenCLPipeArgRN5clang4SemaEPNS_8CallExprE")
//</editor-fold>
public static boolean checkOpenCLPipeArg(final Sema /*&*/ S, CallExpr /*P*/ Call) {
  /*const*/ Expr /*P*/ Arg0 = Call.getArg(0);
  // First argument type should always be pipe.
  if (!Arg0.getType().$arrow().isPipeType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Call.getLocStart(), diag.err_opencl_builtin_pipe_first_arg)), 
              Call.getDirectCallee()), Arg0.getSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  OpenCLAccessAttr /*P*/ AccessQual = getOpenCLArgAccess(cast_DeclRefExpr(Arg0).getDecl$Const());
  // Validates the access qualifier is compatible with the call.
  // OpenCL v2.0 s6.13.16 - The access qualifiers for pipe should only be
  // read_only and write_only, and assumed to be read_only if no qualifier is
  // specified.
  switch (ID.valueOf(Call.getDirectCallee().getBuiltinID())) {
   case BIread_pipe:
   case BIreserve_read_pipe:
   case BIcommit_read_pipe:
   case BIwork_group_reserve_read_pipe:
   case BIsub_group_reserve_read_pipe:
   case BIwork_group_commit_read_pipe:
   case BIsub_group_commit_read_pipe:
    if (!(!(AccessQual != null) || AccessQual.isReadOnly())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg0.getLocStart(), 
                    diag.err_opencl_builtin_pipe_invalid_access_modifier)), 
                /*KEEP_STR*/"read_only"), Arg0.getSourceRange()));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    break;
   case BIwrite_pipe:
   case BIreserve_write_pipe:
   case BIcommit_write_pipe:
   case BIwork_group_reserve_write_pipe:
   case BIsub_group_reserve_write_pipe:
   case BIwork_group_commit_write_pipe:
   case BIsub_group_commit_write_pipe:
    if (!((AccessQual != null) && AccessQual.isWriteOnly())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Arg0.getLocStart(), 
                    diag.err_opencl_builtin_pipe_invalid_access_modifier)), 
                /*KEEP_STR*/"write_only"), Arg0.getSourceRange()));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    break;
   default:
    break;
  }
  return false;
}


/// Returns true if pipe element type is different from the pointer.
//<editor-fold defaultstate="collapsed" desc="checkOpenCLPipePacketType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 540,
 FQN="checkOpenCLPipePacketType", NM="_ZL25checkOpenCLPipePacketTypeRN5clang4SemaEPNS_8CallExprEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL25checkOpenCLPipePacketTypeRN5clang4SemaEPNS_8CallExprEj")
//</editor-fold>
public static boolean checkOpenCLPipePacketType(final Sema /*&*/ S, CallExpr /*P*/ Call, /*uint*/int Idx) {
  /*const*/ Expr /*P*/ Arg0 = Call.getArg(0);
  /*const*/ Expr /*P*/ ArgIdx = Call.getArg(Idx);
  /*const*/ PipeType /*P*/ PipeTy = cast_PipeType(Arg0.getType());
  /*const*/ QualType EltTy = PipeTy.getElementType();
  /*const*/ PointerType /*P*/ ArgTy = ArgIdx.getType().$arrow().getAs(PointerType.class);
  // The Idx argument should be a pointer and the type of the pointer and
  // the type of pipe element should also be the same.
  if (!(ArgTy != null)
     || !S.Context.hasSameType(new QualType(EltTy), ArgTy.getPointeeType().$arrow().getCanonicalTypeInternal())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Call.getLocStart(), diag.err_opencl_builtin_pipe_invalid_arg)), 
                      Call.getDirectCallee()), S.Context.getPointerType(new QualType(EltTy))), 
              ArgIdx.getType()), ArgIdx.getSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  return false;
}


// \brief Performs semantic analysis for the read/write_pipe call.
// \param S Reference to the semantic analyzer.
// \param Call A pointer to the builtin call.
// \return True if a semantic error has been found, false otherwise.
//<editor-fold defaultstate="collapsed" desc="SemaBuiltinRWPipe">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 563,
 FQN="SemaBuiltinRWPipe", NM="_ZL17SemaBuiltinRWPipeRN5clang4SemaEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL17SemaBuiltinRWPipeRN5clang4SemaEPNS_8CallExprE")
//</editor-fold>
public static boolean SemaBuiltinRWPipe(final Sema /*&*/ S, CallExpr /*P*/ Call) {
  // OpenCL v2.0 s6.13.16.2 - The built-in read/write
  // functions have two forms.
  switch (Call.getNumArgs()) {
   case 2:
    {
      if (checkOpenCLPipeArg(S, Call)) {
        return true;
      }
      // The call with 2 arguments should be
      // read/write_pipe(pipe T, T*).
      // Check packet type T.
      if (checkOpenCLPipePacketType(S, Call, 1)) {
        return true;
      }
    }
    break;
   case 4:
    {
      if (checkOpenCLPipeArg(S, Call)) {
        return true;
      }
      // The call with 4 arguments should be
      // read/write_pipe(pipe T, reserve_id_t, uint, T*).
      // Check reserve_id_t.
      if (!Call.getArg(1).getType().$arrow().isReserveIDT()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Call.getLocStart(), diag.err_opencl_builtin_pipe_invalid_arg)), 
                          Call.getDirectCallee()), S.Context.OCLReserveIDTy), 
                  Call.getArg(1).getType()), Call.getArg(1).getSourceRange()));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Check the index.
      /*const*/ Expr /*P*/ Arg2 = Call.getArg(2);
      if (!Arg2.getType().$arrow().isIntegerType()
         && !Arg2.getType().$arrow().isUnsignedIntegerType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Call.getLocStart(), diag.err_opencl_builtin_pipe_invalid_arg)), 
                          Call.getDirectCallee()), S.Context.UnsignedIntTy), 
                  Arg2.getType()), Arg2.getSourceRange()));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Check packet type T.
      if (checkOpenCLPipePacketType(S, Call, 3)) {
        return true;
      }
    }
    break;
   default:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Call.getLocStart(), diag.err_opencl_builtin_pipe_arg_num)), 
                Call.getDirectCallee()), Call.getSourceRange()));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  return false;
}


// \brief Performs a semantic analysis on the {work_group_/sub_group_
//        /_}reserve_{read/write}_pipe
// \param S Reference to the semantic analyzer.
// \param Call The call to the builtin function to be analyzed.
// \return True if a semantic error was found, false otherwise.
//<editor-fold defaultstate="collapsed" desc="SemaBuiltinReserveRWPipe">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 618,
 FQN="SemaBuiltinReserveRWPipe", NM="_ZL24SemaBuiltinReserveRWPipeRN5clang4SemaEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL24SemaBuiltinReserveRWPipeRN5clang4SemaEPNS_8CallExprE")
//</editor-fold>
public static boolean SemaBuiltinReserveRWPipe(final Sema /*&*/ S, CallExpr /*P*/ Call) {
  if (checkArgCount(S, Call, 2)) {
    return true;
  }
  if (checkOpenCLPipeArg(S, Call)) {
    return true;
  }
  
  // Check the reserve size.
  if (!Call.getArg(1).getType().$arrow().isIntegerType()
     && !Call.getArg(1).getType().$arrow().isUnsignedIntegerType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Call.getLocStart(), diag.err_opencl_builtin_pipe_invalid_arg)), 
                      Call.getDirectCallee()), S.Context.UnsignedIntTy), 
              Call.getArg(1).getType()), Call.getArg(1).getSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}


// \brief Performs a semantic analysis on {work_group_/sub_group_
//        /_}commit_{read/write}_pipe
// \param S Reference to the semantic analyzer.
// \param Call The call to the builtin function to be analyzed.
// \return True if a semantic error was found, false otherwise.
//<editor-fold defaultstate="collapsed" desc="SemaBuiltinCommitRWPipe">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 642,
 FQN="SemaBuiltinCommitRWPipe", NM="_ZL23SemaBuiltinCommitRWPipeRN5clang4SemaEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL23SemaBuiltinCommitRWPipeRN5clang4SemaEPNS_8CallExprE")
//</editor-fold>
public static boolean SemaBuiltinCommitRWPipe(final Sema /*&*/ S, CallExpr /*P*/ Call) {
  if (checkArgCount(S, Call, 2)) {
    return true;
  }
  if (checkOpenCLPipeArg(S, Call)) {
    return true;
  }
  
  // Check reserve_id_t.
  if (!Call.getArg(1).getType().$arrow().isReserveIDT()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Call.getLocStart(), diag.err_opencl_builtin_pipe_invalid_arg)), 
                      Call.getDirectCallee()), S.Context.OCLReserveIDTy), 
              Call.getArg(1).getType()), Call.getArg(1).getSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}


// \brief Performs a semantic analysis on the call to built-in Pipe
//        Query Functions.
// \param S Reference to the semantic analyzer.
// \param Call The call to the builtin function to be analyzed.
// \return True if a semantic error was found, false otherwise.
//<editor-fold defaultstate="collapsed" desc="SemaBuiltinPipePackets">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 665,
 FQN="SemaBuiltinPipePackets", NM="_ZL22SemaBuiltinPipePacketsRN5clang4SemaEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL22SemaBuiltinPipePacketsRN5clang4SemaEPNS_8CallExprE")
//</editor-fold>
public static boolean SemaBuiltinPipePackets(final Sema /*&*/ S, CallExpr /*P*/ Call) {
  if (checkArgCount(S, Call, 1)) {
    return true;
  }
  if (!Call.getArg(0).getType().$arrow().isPipeType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Call.getLocStart(), diag.err_opencl_builtin_pipe_first_arg)), 
              Call.getDirectCallee()), Call.getArg(0).getSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}

// \brief OpenCL v2.0 s6.13.9 - Address space qualifier functions.
// \brief Performs semantic analysis for the to_global/local/private call.
// \param S Reference to the semantic analyzer.
// \param BuiltinID ID of the builtin function.
// \param Call A pointer to the builtin call.
// \return True if a semantic error has been found, false otherwise.
//<editor-fold defaultstate="collapsed" desc="SemaOpenCLBuiltinToAddr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 683,
 FQN="SemaOpenCLBuiltinToAddr", NM="_ZL23SemaOpenCLBuiltinToAddrRN5clang4SemaEjPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL23SemaOpenCLBuiltinToAddrRN5clang4SemaEjPNS_8CallExprE")
//</editor-fold>
public static boolean SemaOpenCLBuiltinToAddr(final Sema /*&*/ S, /*uint*/int BuiltinID, 
                       CallExpr /*P*/ Call) {
  if (Call.getNumArgs() != 1) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Call.getLocStart(), diag.err_opencl_builtin_to_addr_arg_num)), 
              Call.getDirectCallee()), Call.getSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  QualType RT = Call.getArg(0).getType();
  if (!RT.$arrow().isPointerType() || RT.$arrow().getPointeeType().
      getAddressSpace() == LangAS.ID.opencl_constant) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Call.getLocStart(), diag.err_opencl_builtin_to_addr_invalid_arg)), 
                  Call.getArg(0)), Call.getDirectCallee()), Call.getSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  RT.$assignMove(RT.$arrow().getPointeeType());
  Qualifiers Qual = RT.getQualifiers();
  switch (ID.valueOf(BuiltinID)) {
   case BIto_global:
    Qual.setAddressSpace(LangAS.ID.opencl_global);
    break;
   case BIto_local:
    Qual.setAddressSpace(LangAS.ID.opencl_local);
    break;
   default:
    Qual.removeAddressSpace();
  }
  Call.setType(S.Context.getPointerType(S.Context.getQualifiedType(RT.getUnqualifiedType(), new Qualifiers(Qual))));
  
  return false;
}


// Get the valid immediate range for the specified NEON type code.
//<editor-fold defaultstate="collapsed" desc="RFT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 1116,
 FQN="RFT", NM="_ZL3RFTjbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL3RFTjbb")
//</editor-fold>
public static /*uint*/int RFT(/*uint*/int t) {
  return RFT(t, false, false);
}
public static /*uint*/int RFT(/*uint*/int t, boolean shift/*= false*/) {
  return RFT(t, shift, false);
}
public static /*uint*/int RFT(/*uint*/int t, boolean shift/*= false*/, boolean ForceQuad/*= false*/) {
  NeonTypeFlags Type/*J*/= new NeonTypeFlags(t);
  int IsQuad = ((ForceQuad ? true : Type.isQuad()) ? 1 : 0);
  switch (Type.getEltType()) {
   case Int8:
   case Poly8:
    return shift ? 7 : (8 << IsQuad) - 1;
   case Int16:
   case Poly16:
    return shift ? 15 : (4 << IsQuad) - 1;
   case Int32:
    return shift ? 31 : (2 << IsQuad) - 1;
   case Int64:
   case Poly64:
    return shift ? 63 : (1 << IsQuad) - 1;
   case Poly128:
    return shift ? 127 : (1 << IsQuad) - 1;
   case Float16:
    assert (!shift) : "cannot shift float types!";
    return (4 << IsQuad) - 1;
   case Float32:
    assert (!shift) : "cannot shift float types!";
    return (2 << IsQuad) - 1;
   case Float64:
    assert (!shift) : "cannot shift float types!";
    return (1 << IsQuad) - 1;
  }
  throw new llvm_unreachable("Invalid NeonTypeFlag!");
}


/// getNeonEltType - Return the QualType corresponding to the elements of
/// the vector type specified by the NeonTypeFlags.  This is used to check
/// the pointer arguments for Neon load/store intrinsics.
//<editor-fold defaultstate="collapsed" desc="getNeonEltType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 1149,
 FQN="getNeonEltType", NM="_ZL14getNeonEltTypeN5clang13NeonTypeFlagsERNS_10ASTContextEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL14getNeonEltTypeN5clang13NeonTypeFlagsERNS_10ASTContextEbb")
//</editor-fold>
public static QualType getNeonEltType(NeonTypeFlags Flags, final ASTContext /*&*/ Context, 
              boolean IsPolyUnsigned, boolean IsInt64Long) {
  switch (Flags.getEltType()) {
   case Int8:
    return (Flags.isUnsigned() ? Context.UnsignedCharTy : Context.SignedCharTy).$QualType();
   case Int16:
    return (Flags.isUnsigned() ? Context.UnsignedShortTy : Context.ShortTy).$QualType();
   case Int32:
    return (Flags.isUnsigned() ? Context.UnsignedIntTy : Context.IntTy).$QualType();
   case Int64:
    if (IsInt64Long) {
      return (Flags.isUnsigned() ? Context.UnsignedLongTy : Context.LongTy).$QualType();
    } else {
      return (Flags.isUnsigned() ? Context.UnsignedLongLongTy : Context.LongLongTy).$QualType();
    }
   case Poly8:
    return (IsPolyUnsigned ? Context.UnsignedCharTy : Context.SignedCharTy).$QualType();
   case Poly16:
    return (IsPolyUnsigned ? Context.UnsignedShortTy : Context.ShortTy).$QualType();
   case Poly64:
    if (IsInt64Long) {
      return Context.UnsignedLongTy.$QualType();
    } else {
      return Context.UnsignedLongLongTy.$QualType();
    }
   case Poly128:
    break;
   case Float16:
    return Context.HalfTy.$QualType();
   case Float32:
    return Context.FloatTy.$QualType();
   case Float64:
    return Context.DoubleTy.$QualType();
  }
  throw new llvm_unreachable("Invalid NeonTypeFlag!");
}


/// SemaBuiltinCpuSupports - Handle __builtin_cpu_supports(char *).
/// This checks that the target supports __builtin_cpu_supports and
/// that the string argument is constant and valid.
//<editor-fold defaultstate="collapsed" desc="SemaBuiltinCpuSupports">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 1575,
 FQN="SemaBuiltinCpuSupports", NM="_ZL22SemaBuiltinCpuSupportsRN5clang4SemaEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL22SemaBuiltinCpuSupportsRN5clang4SemaEPNS_8CallExprE")
//</editor-fold>
public static boolean SemaBuiltinCpuSupports(final Sema /*&*/ S, CallExpr /*P*/ TheCall) {
  Expr /*P*/ Arg = TheCall.getArg(0);
  
  // Check if the argument is a string literal.
  if (!isa_StringLiteral(Arg.IgnoreParenImpCasts())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(TheCall.getLocStart(), diag.err_expr_not_string_literal)), 
          Arg.getSourceRange()).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  // Check the contents of the string.
  StringRef Feature = cast_StringLiteral(Arg.IgnoreParenImpCasts()).getString();
  if (!S.Context.getTargetInfo().validateCpuSupports(new StringRef(Feature))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(TheCall.getLocStart(), diag.err_invalid_cpu_supports)), 
          Arg.getSourceRange()).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  return false;
}


/// Checks if a the given expression evaluates to null.
///
/// \brief Returns true if the value evaluates to null.
//<editor-fold defaultstate="collapsed" desc="CheckNonNullExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 1897,
 FQN="CheckNonNullExpr", NM="_ZL16CheckNonNullExprRN5clang4SemaEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL16CheckNonNullExprRN5clang4SemaEPKNS_4ExprE")
//</editor-fold>
public static boolean CheckNonNullExpr(final Sema /*&*/ S, /*const*/ Expr /*P*/ $Expr) {
  {
    // If the expression has non-null type, it doesn't evaluate to null.
    Optional<NullabilityKind> nullability = $Expr.IgnoreImplicit$Const().getType().$arrow().getNullability(S.Context);
    if (nullability.$bool()) {
      if (nullability.$star() == NullabilityKind.NonNull) {
        return false;
      }
    }
  }
  {
    
    // As a special case, transparent unions initialized with zero are
    // considered null for the purposes of the nonnull attribute.
    /*const*/ RecordType /*P*/ UT = $Expr.getType().$arrow().getAsUnionType();
    if ((UT != null)) {
      if (UT.getDecl().hasAttr(TransparentUnionAttr.class)) {
        {
          /*const*/ CompoundLiteralExpr /*P*/ CLE = dyn_cast_CompoundLiteralExpr($Expr);
          if ((CLE != null)) {
            {
              /*const*/ InitListExpr /*P*/ ILE = dyn_cast_InitListExpr(CLE.getInitializer$Const());
              if ((ILE != null)) {
                $Expr = ILE.getInit$Const(0);
              }
            }
          }
        }
      }
    }
  }
  
  bool$ref Result = create_bool$ref();
  return (!$Expr.isValueDependent()
     && $Expr.EvaluateAsBooleanCondition(Result, S.Context)
     && !Result.$deref());
}

//<editor-fold defaultstate="collapsed" desc="CheckNonNullArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 1922,
 FQN="CheckNonNullArgument", NM="_ZL20CheckNonNullArgumentRN5clang4SemaEPKNS_4ExprENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL20CheckNonNullArgumentRN5clang4SemaEPKNS_4ExprENS_14SourceLocationE")
//</editor-fold>
public static void CheckNonNullArgument(final Sema /*&*/ S, 
                    /*const*/ Expr /*P*/ ArgExpr, 
                    SourceLocation CallSiteLoc) {
  if (CheckNonNullExpr(S, ArgExpr)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(S.DiagRuntimeBehavior(new SourceLocation(CallSiteLoc), ArgExpr, 
          $out_PartialDiagnostic$C_SourceRange($c$.track(S.PDiag(diag.warn_null_arg)), ArgExpr.getSourceRange())));
    } finally {
      $c$.$destroy();
    }
  }
}

/// \brief Diagnose use of %s directive in an NSString which is being passed
/// as formatting string to formatting method.
//<editor-fold defaultstate="collapsed" desc="DiagnoseCStringFormatDirectiveInCFAPI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 1941,
 FQN="DiagnoseCStringFormatDirectiveInCFAPI", NM="_ZL37DiagnoseCStringFormatDirectiveInCFAPIRN5clang4SemaEPKNS_9NamedDeclEPPNS_4ExprEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL37DiagnoseCStringFormatDirectiveInCFAPIRN5clang4SemaEPKNS_9NamedDeclEPPNS_4ExprEj")
//</editor-fold>
public static void DiagnoseCStringFormatDirectiveInCFAPI(final Sema /*&*/ S, 
                                     /*const*/ NamedDecl /*P*/ FDecl, 
                                     type$ptr<Expr/*P*/> Args, 
                                     /*uint*/int NumArgs) {
  uint$ref Idx = create_uint$ref(0);
  boolean Format = false;
  ObjCStringFormatFamily SFFamily = FDecl.getObjCFStringFormattingFamily();
  if (SFFamily == ObjCStringFormatFamily.SFF_CFString) {
    Idx.$set(2);
    Format = true;
  } else {
    for (/*const*/ FormatAttr /*P*/ I : FDecl.specific_attrs(FormatAttr.class)) {
      if (S.GetFormatNSStringIdx(I, Idx)) {
        Format = true;
        break;
      }
    }
  }
  if (!Format || $lesseq_uint(NumArgs, Idx.$deref())) {
    return;
  }
  /*const*/ Expr /*P*/ FormatExpr = Args.$at(Idx.$deref());
  {
    /*const*/ CStyleCastExpr /*P*/ CSCE = dyn_cast_CStyleCastExpr(FormatExpr);
    if ((CSCE != null)) {
      FormatExpr = CSCE.getSubExpr$Const();
    }
  }
  /*const*/ StringLiteral /*P*/ FormatString;
  {
    /*const*/ ObjCStringLiteral /*P*/ OSL = dyn_cast_ObjCStringLiteral(FormatExpr.IgnoreParenImpCasts$Const());
    if ((OSL != null)) {
      FormatString = OSL.getString$Const();
    } else {
      FormatString = dyn_cast_StringLiteral(FormatExpr.IgnoreParenImpCasts$Const());
    }
  }
  if (!(FormatString != null)) {
    return;
  }
  if (S.FormatStringHasSArg(FormatString)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FormatExpr.getExprLoc(), diag.warn_objc_cdirective_format_string)), 
                  /*KEEP_STR*/"%s"), 1), 1));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FDecl.getLocation(), diag.note_entity_declared_at)), 
          FDecl.getDeclName()));
    } finally {
      $c$.$destroy();
    }
  }
}


/// Determine whether the given type has a non-null nullability annotation.
//<editor-fold defaultstate="collapsed" desc="isNonNullType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 1982,
 FQN="isNonNullType", NM="_ZL13isNonNullTypeRN5clang10ASTContextENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL13isNonNullTypeRN5clang10ASTContextENS_8QualTypeE")
//</editor-fold>
public static boolean isNonNullType(final ASTContext /*&*/ ctx, QualType type) {
  {
    Optional<NullabilityKind> nullability = type.$arrow().getNullability(ctx);
    if (nullability.$bool()) {
      return nullability.$star() == NullabilityKind.NonNull;
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="CheckNonNullArguments">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 1989,
 FQN="CheckNonNullArguments", NM="_ZL21CheckNonNullArgumentsRN5clang4SemaEPKNS_9NamedDeclEPKNS_17FunctionProtoTypeEN4llvm8ArrayRefIPKNS_4ExprEEENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL21CheckNonNullArgumentsRN5clang4SemaEPKNS_9NamedDeclEPKNS_17FunctionProtoTypeEN4llvm8ArrayRefIPKNS_4ExprEEENS_14SourceLocationE")
//</editor-fold>
public static void CheckNonNullArguments(final Sema /*&*/ S, 
                     /*const*/ NamedDecl /*P*/ FDecl, 
                     /*const*/ FunctionProtoType /*P*/ Proto, 
                     ArrayRef</*const*/ Expr /*P*/ > Args, 
                     SourceLocation CallSiteLoc) {
  assert (((FDecl != null) || (Proto != null))) : "Need a function declaration or prototype";

  // Check the attributes attached to the method/function itself.
  SmallBitVector NonNullArgs/*J*/= new SmallBitVector();
  if ((FDecl != null)) {
    // Handle the nonnull attribute on the function/method declaration itself.
    for (/*const*/ NonNullAttr /*P*/ NonNull : FDecl.specific_attrs(NonNullAttr.class)) {
      if (!(NonNull.args_size() != 0)) {
        // Easy case: all pointer arguments are nonnull.
        for (/*const*/ Expr /*P*/ Arg : Args)  {
          if (S.isValidPointerAttrType(Arg.getType())) {
            CheckNonNullArgument(S, Arg, new SourceLocation(CallSiteLoc));
          }
        }
        return;
      }

      for (/*uint*/int Val : NonNull.args()) {
        if ($greatereq_uint(Val, Args.size())) {
          continue;
        }
        if (NonNullArgs.empty()) {
          NonNullArgs.resize(Args.size());
        }
        NonNullArgs.set(Val);
      }
    }
  }
  if ((FDecl != null) && (isa_FunctionDecl(FDecl) || isa_ObjCMethodDecl(FDecl))) {
    // Handle the nonnull attribute on the parameters of the
    // function/method.
    ArrayRef<ParmVarDecl /*P*/ > parms/*J*/= new ArrayRef<ParmVarDecl /*P*/ >(true);
    {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(FDecl);
      if ((FD != null)) {
        parms.$assignMove(FD.parameters$Const());
      } else {
        parms.$assignMove(cast_ObjCMethodDecl(FDecl).parameters());
      }
    }

    /*uint*/int ParamIndex = 0;
    for (type$ptr<ParmVarDecl /*P*/ /*P*/> I = $tryClone(parms.begin()), /*P*/ E = $tryClone(parms.end());
         $noteq_ptr(I, E); I.$preInc() , ++ParamIndex) {
      /*const*/ ParmVarDecl /*P*/ PVD = I.$star();
      if (PVD.hasAttr(NonNullAttr.class)
         || isNonNullType(S.Context, PVD.getType())) {
        if (NonNullArgs.empty()) {
          NonNullArgs.resize(Args.size());
        }

        NonNullArgs.set(ParamIndex);
      }
    }
  } else {
    // If we have a non-function, non-method declaration but no
    // function prototype, try to dig out the function prototype.
    if (!(Proto != null)) {
      {
        /*const*/ ValueDecl /*P*/ VD = dyn_cast_ValueDecl(FDecl);
        if ((VD != null)) {
          QualType type = VD.getType().getNonReferenceType();
          {
            /*const*/ PointerType /*P*/ pointerType = type.$arrow().getAs(PointerType.class);
            if ((pointerType != null)) {
              type.$assignMove(pointerType.getPointeeType());
            } else {
              /*const*/ BlockPointerType /*P*/ blockType = type.$arrow().getAs(BlockPointerType.class);
              if ((blockType != null)) {
                type.$assignMove(blockType.getPointeeType());
              }
            }
          }
          // FIXME: data member pointers?

          // Dig out the function prototype, if there is one.
          Proto = type.$arrow().getAs(FunctionProtoType.class);
        }
      }
    }

    // Fill in non-null argument information from the nullability
    // information on the parameter types (if we have them).
    if ((Proto != null)) {
      /*uint*/int Index = 0;
      for (QualType paramType : Proto.getParamTypes()) {
        if (isNonNullType(S.Context, new QualType(paramType))) {
          if (NonNullArgs.empty()) {
            NonNullArgs.resize(Args.size());
          }

          NonNullArgs.set(Index);
        }

        ++Index;
      }
    }
  }

  // Check for non-null arguments.
  for (/*uint*/int ArgIndex = 0, ArgIndexEnd = NonNullArgs.size();
       ArgIndex != ArgIndexEnd; ++ArgIndex) {
    if (NonNullArgs.$at$Const(ArgIndex)) {
      CheckNonNullArgument(S, Args.$at(ArgIndex), new SourceLocation(CallSiteLoc));
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="isValidOrderingForOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 2250,
 FQN="isValidOrderingForOp", NM="_ZL20isValidOrderingForOpxN5clang10AtomicExpr8AtomicOpE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL20isValidOrderingForOpxN5clang10AtomicExpr8AtomicOpE")
//</editor-fold>
public static boolean isValidOrderingForOp(long/*int64_t*/ Ordering, AtomicExpr.AtomicOp Op) {
  if (!llvm.isValidAtomicOrderingCABI(Ordering)) {
    return false;
  }
  
  AtomicOrderingCABI OrderingCABI = AtomicOrderingCABI.valueOf(Ordering);
  switch (Op) {
   case AO__c11_atomic_init:
    throw new llvm_unreachable("There is no ordering argument for an init");
   case AO__c11_atomic_load:
   case AO__atomic_load_n:
   case AO__atomic_load:
    return OrderingCABI != AtomicOrderingCABI.release
       && OrderingCABI != AtomicOrderingCABI.acq_rel;
   case AO__c11_atomic_store:
   case AO__atomic_store:
   case AO__atomic_store_n:
    return OrderingCABI != AtomicOrderingCABI.consume
       && OrderingCABI != AtomicOrderingCABI.acquire
       && OrderingCABI != AtomicOrderingCABI.acq_rel;
   default:
    return true;
  }
}


/// checkBuiltinArgument - Given a call to a builtin function, perform
/// normal type-checking on the given argument, updating the call in
/// place.  This is useful when a builtin function requires custom
/// type-checking for some of its arguments but not necessarily all of
/// them.
///
/// Returns true on error.
//<editor-fold defaultstate="collapsed" desc="checkBuiltinArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 2628,
 FQN="checkBuiltinArgument", NM="_ZL20checkBuiltinArgumentRN5clang4SemaEPNS_8CallExprEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL20checkBuiltinArgumentRN5clang4SemaEPNS_8CallExprEj")
//</editor-fold>
public static boolean checkBuiltinArgument(final Sema /*&*/ S, CallExpr /*P*/ E, /*uint*/int ArgIndex) {
  FunctionDecl /*P*/ Fn = E.getDirectCallee();
  assert ((Fn != null)) : "builtin call without direct callee!";
  
  ParmVarDecl /*P*/ Param = Fn.getParamDecl(ArgIndex);
  InitializedEntity Entity = InitializedEntity.InitializeParameter(S.Context, Param);
  
  ActionResultTTrue<Expr /*P*/ > Arg = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E.getArg(0));
  Arg.$assignMove(S.PerformCopyInitialization(Entity, new SourceLocation(), new ActionResultTTrue<Expr /*P*/ >(Arg)));
  if (Arg.isInvalid()) {
    return true;
  }
  
  E.setArg(ArgIndex, Arg.get());
  return false;
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="CheckFormatString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 5546,
 FQN="CheckFormatString", NM="_ZL17CheckFormatStringRN5clang4SemaEPKNS_13StringLiteralEPKNS_4ExprEN4llvm8ArrayRefIS7_EEbjjNS0_16FormatStringTypeEbNS0_16VariadicCallTypeERNS8_14SmallBitVectorERN12_GLOBAL__N_119UncoveredArgHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL17CheckFormatStringRN5clang4SemaEPKNS_13StringLiteralEPKNS_4ExprEN4llvm8ArrayRefIS7_EEbjjNS0_16FormatStringTypeEbNS0_16VariadicCallTypeERNS8_14SmallBitVectorERN12_GLOBAL__N_119UncoveredArgHandlerE")
//</editor-fold>
public static void CheckFormatString(final Sema /*&*/ S, /*const*/ StringLiteral /*P*/ FExpr, 
                 /*const*/ Expr /*P*/ OrigFormatExpr, 
                 ArrayRef</*const*/ Expr /*P*/ > Args, 
                 boolean HasVAListArg, /*uint*/int format_idx, 
                 /*uint*/int firstDataArg, 
                 Sema.FormatStringType Type, 
                 boolean inFunctionCall, 
                 Sema.VariadicCallType CallType, 
                 final SmallBitVector /*&*/ CheckedVarArgs, 
                 final UncoveredArgHandler /*&*/ UncoveredArg) {
  // CHECK: is the format string a wide literal?
  if (!FExpr.isAscii() && !FExpr.isUTF8()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      CheckFormatHandler.EmitFormatDiagnostic(S, inFunctionCall, Args.$at(format_idx), 
          $c$.track(S.PDiag(diag.warn_format_string_is_wide_literal)), FExpr.getLocStart(), 
          /*IsStringLocation*/ true, OrigFormatExpr.getSourceRange()); $c$.clean();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Str - The format string.  NOTE: this is NOT null-terminated!
  StringRef StrRef = FExpr.getString();
  /*const*/char$ptr/*char P*/ Str = $tryClone(StrRef.data());
  // Account for cases where the string literal is truncated in a declaration.
  /*const*/ ConstantArrayType /*P*/ T = S.Context.getAsConstantArrayType(FExpr.getType());
  assert ((T != null)) : "String literal not of constant array type!";
  /*size_t*/int TypeSize = $ulong2uint(T.getSize().getZExtValue());
  /*size_t*/int StrLen = std.min_uint(std.max(TypeSize, ((/*size_t*/int)(1))) - 1, StrRef.size());
  /*const*//*uint*/int numDataArgs = Args.size() - firstDataArg;
  
  // Emit a warning if the string literal is truncated and does not contain an
  // embedded null character.
  if ($lesseq_uint(TypeSize, StrRef.size())
     && StrRef.substr(0, TypeSize).find($$TERM) == StringRef.npos) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      CheckFormatHandler.EmitFormatDiagnostic(S, inFunctionCall, Args.$at(format_idx), 
          $c$.track(S.PDiag(diag.warn_printf_format_string_not_null_terminated)), 
          FExpr.getLocStart(), 
          /*IsStringLocation=*/ true, OrigFormatExpr.getSourceRange()); $c$.clean();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // CHECK: empty format string?
  if (StrLen == 0 && $greater_uint(numDataArgs, 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      CheckFormatHandler.EmitFormatDiagnostic(S, inFunctionCall, Args.$at(format_idx), 
          $c$.track(S.PDiag(diag.warn_empty_format_string)), FExpr.getLocStart(), 
          /*IsStringLocation*/ true, OrigFormatExpr.getSourceRange()); $c$.clean();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (Type == Sema.FormatStringType.FST_Printf || Type == Sema.FormatStringType.FST_NSString
     || Type == Sema.FormatStringType.FST_FreeBSDKPrintf || Type == Sema.FormatStringType.FST_OSTrace) {
    CheckPrintfHandler H = null;
    try {
      H/*J*/= new CheckPrintfHandler(S, FExpr, OrigFormatExpr, firstDataArg, 
          numDataArgs, (Type == Sema.FormatStringType.FST_NSString
             || Type == Sema.FormatStringType.FST_OSTrace), 
          Str, HasVAListArg, new ArrayRef</*const*/ Expr /*P*/ >(Args), format_idx, 
          inFunctionCall, CallType, CheckedVarArgs, 
          UncoveredArg);
      if (!ParsePrintfString(H, Str, Str.$add(StrLen), 
          S.getLangOpts(), 
          S.Context.getTargetInfo(), 
          Type == Sema.FormatStringType.FST_FreeBSDKPrintf)) {
        H.DoneProcessing();
      }
    } finally {
      if (H != null) { H.$destroy(); }
    }
  } else if (Type == Sema.FormatStringType.FST_Scanf) {
    CheckScanfHandler H = null;
    try {
      H/*J*/= new CheckScanfHandler(S, FExpr, OrigFormatExpr, firstDataArg, numDataArgs, 
          Str, HasVAListArg, new ArrayRef</*const*/ Expr /*P*/ >(Args), format_idx, 
          inFunctionCall, CallType, CheckedVarArgs, 
          UncoveredArg);
      if (!ParseScanfString(H, Str, Str.$add(StrLen), 
          S.getLangOpts(), 
          S.Context.getTargetInfo())) {
        H.DoneProcessing();
      }
    } finally {
      if (H != null) { H.$destroy(); }
    }
  } // TODO: handle other formats
}


// Determine if an expression is a string literal or constant string.
// If this function returns false on the arguments to a function expecting a
// format string, we will usually need to emit a warning.
// True string literals are then checked by CheckFormatString.
//<editor-fold defaultstate="collapsed" desc="checkFormatStringExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3808,
 FQN="checkFormatStringExpr", NM="_ZL21checkFormatStringExprRN5clang4SemaEPKNS_4ExprEN4llvm8ArrayRefIS4_EEbjjNS0_16FormatStringTypeENS0_16VariadicCallTypeEbRNS5_14SmallBitVectorERN12_GLOBAL__N_119UncoveredArgHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL21checkFormatStringExprRN5clang4SemaEPKNS_4ExprEN4llvm8ArrayRefIS4_EEbjjNS0_16FormatStringTypeENS0_16VariadicCallTypeEbRNS5_14SmallBitVectorERN12_GLOBAL__N_119UncoveredArgHandlerE")
//</editor-fold>
public static StringLiteralCheckType checkFormatStringExpr(final Sema /*&*/ S, /*const*/ Expr /*P*/ E, ArrayRef</*const*/ Expr /*P*/ > Args, 
                     boolean HasVAListArg, /*uint*/int format_idx, 
                     /*uint*/int firstDataArg, Sema.FormatStringType Type, 
                     Sema.VariadicCallType CallType, boolean InFunctionCall, 
                     final SmallBitVector /*&*/ CheckedVarArgs, 
                     final UncoveredArgHandler /*&*/ UncoveredArg) {
 tryAgain: while(true) {
 
  if (E.isTypeDependent() || E.isValueDependent()) {
    return StringLiteralCheckType.SLCT_NotALiteral;
  }
  
  E = E.IgnoreParenCasts$Const();
  if ((E.isNullPointerConstant(S.Context, Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNotNull).getValue() != 0)) {
    // Technically -Wformat-nonliteral does not warn about this case.
    // The behavior of printf and friends in this case is implementation
    // dependent.  Ideally if the format string cannot be null then
    // it should have a 'nonnull' attribute in the function prototype.
    return StringLiteralCheckType.SLCT_UncheckedLiteral;
  }
  switch (E.getStmtClass()) {
   case BinaryConditionalOperatorClass:
   case ConditionalOperatorClass:
    {
      // The expression is a literal if both sub-expressions were, and it was
      // completely checked only if both sub-expressions were checked.
      /*const*/ AbstractConditionalOperator /*P*/ C = cast_AbstractConditionalOperator(E);
      
      // Determine whether it is necessary to check both sub-expressions, for
      // example, because the condition expression is a constant that can be
      // evaluated at compile time.
      boolean CheckLeft = true, CheckRight = true;
      
      bool$ref Cond = create_bool$ref();
      if (C.getCond().EvaluateAsBooleanCondition(Cond, S.getASTContext())) {
        if (Cond.$deref()) {
          CheckRight = false;
        } else {
          CheckLeft = false;
        }
      }
      
      StringLiteralCheckType Left;
      if (!CheckLeft) {
        Left = StringLiteralCheckType.SLCT_UncheckedLiteral;
      } else {
        Left = checkFormatStringExpr(S, C.getTrueExpr(), new ArrayRef</*const*/ Expr /*P*/ >(Args), 
            HasVAListArg, format_idx, firstDataArg, 
            Type, CallType, InFunctionCall, 
            CheckedVarArgs, UncoveredArg);
        if (Left == StringLiteralCheckType.SLCT_NotALiteral || !CheckRight) {
          return Left;
        }
      }
      
      StringLiteralCheckType Right = checkFormatStringExpr(S, C.getFalseExpr(), new ArrayRef</*const*/ Expr /*P*/ >(Args), 
          HasVAListArg, format_idx, firstDataArg, 
          Type, CallType, InFunctionCall, CheckedVarArgs, 
          UncoveredArg);
      
      return (CheckLeft && Left.getValue() < Right.getValue()) ? Left : Right;
    }
   case ImplicitCastExprClass:
    {
      E = cast_ImplicitCastExpr(E).getSubExpr$Const();
      continue tryAgain;
    }
   case OpaqueValueExprClass:
    {
      /*const*/ Expr /*P*/ src = cast_OpaqueValueExpr(E).getSourceExpr();
      if ((src != null)) {
        E = src;
        continue tryAgain;
      }
    }
    return StringLiteralCheckType.SLCT_NotALiteral;
   case PredefinedExprClass:
    // While __func__, etc., are technically not string literals, they
    // cannot contain format specifiers and thus are not a security
    // liability.
    return StringLiteralCheckType.SLCT_UncheckedLiteral;
   case DeclRefExprClass:
    {
      /*const*/ DeclRefExpr /*P*/ DR = cast_DeclRefExpr(E);
      {
        
        // As an exception, do not flag errors for variables binding to
        // const string literals.
        /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DR.getDecl$Const());
        if ((VD != null)) {
          boolean isConstant = false;
          QualType T = DR.getType();
          {
            
            /*const*/ ArrayType /*P*/ AT = S.Context.getAsArrayType(new QualType(T));
            if ((AT != null)) {
              isConstant = AT.getElementType().isConstant(S.Context);
            } else {
              /*const*/ PointerType /*P*/ PT = T.$arrow().getAs(PointerType.class);
              if ((PT != null)) {
                isConstant = T.isConstant(S.Context)
                   && PT.getPointeeType().isConstant(S.Context);
              } else if (T.$arrow().isObjCObjectPointerType()) {
                // In ObjC, there is usually no "const ObjectPointer" type,
                // so don't check if the pointee type is constant.
                isConstant = T.isConstant(S.Context);
              }
            }
          }
          if (isConstant) {
            {
              /*const*/ Expr /*P*/ Init = VD.getAnyInitializer();
              if ((Init != null)) {
                {
                  // Look through initializers like const char c[] = { "foo" }
                  /*const*/ InitListExpr /*P*/ InitList = dyn_cast_InitListExpr(Init);
                  if ((InitList != null)) {
                    if (InitList.isStringLiteralInit()) {
                      Init = InitList.getInit$Const(0).IgnoreParenImpCasts$Const();
                    }
                  }
                }
                return checkFormatStringExpr(S, Init, new ArrayRef</*const*/ Expr /*P*/ >(Args), 
                    HasVAListArg, format_idx, 
                    firstDataArg, Type, CallType, 
                    /*InFunctionCall*/ false, CheckedVarArgs, 
                    UncoveredArg);
              }
            }
          }
          
          // For vprintf* functions (i.e., HasVAListArg==true), we add a
          // special check to see if the format string is a function parameter
          // of the function calling the printf function.  If the function
          // has an attribute indicating it is a printf-like function, then we
          // should suppress warnings concerning non-literals being used in a call
          // to a vprintf function.  For example:
          //
          // void
          // logmessage(char const *fmt __attribute__ (format (printf, 1, 2)), ...){
          //      va_list ap;
          //      va_start(ap, fmt);
          //      vprintf(fmt, ap);  // Do NOT emit a warning about "fmt".
          //      ...
          // }
          if (HasVAListArg) {
            {
              /*const*/ ParmVarDecl /*P*/ PV = dyn_cast_ParmVarDecl(VD);
              if ((PV != null)) {
                {
                  /*const*/ NamedDecl /*P*/ ND = dyn_cast_NamedDecl(PV.getDeclContext$Const());
                  if ((ND != null)) {
                    int PVIndex = PV.getFunctionScopeIndex() + 1;
                    for (/*const*/ FormatAttr /*P*/ PVFormat : ND.specific_attrs(FormatAttr.class)) {
                      {
                        // adjust for implicit parameter
                        /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(ND);
                        if ((MD != null)) {
                          if (MD.isInstance()) {
                            ++PVIndex;
                          }
                        }
                      }
                      // We also check if the formats are compatible.
                      // We can't pass a 'scanf' string to a 'printf' function.
                      if (PVIndex == PVFormat.getFormatIdx()
                         && Type == S.GetFormatStringType(PVFormat)) {
                        return StringLiteralCheckType.SLCT_UncheckedLiteral;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      
      return StringLiteralCheckType.SLCT_NotALiteral;
    }
   case CallExprClass:
   case CXXMemberCallExprClass:
    {
      /*const*/ CallExpr /*P*/ CE = cast_CallExpr(E);
      {
        /*const*/ NamedDecl /*P*/ ND = dyn_cast_or_null_NamedDecl(CE.getCalleeDecl$Const());
        if ((ND != null)) {
          {
            /*const*/ FormatArgAttr /*P*/ FA = ND.getAttr(FormatArgAttr.class);
            if ((FA != null)) {
              /*uint*/int ArgIndex = FA.getFormatIdx();
              {
                /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(ND);
                if ((MD != null)) {
                  if (MD.isInstance()) {
                    --ArgIndex;
                  }
                }
              }
              /*const*/ Expr /*P*/ Arg = CE.getArg$Const(ArgIndex - 1);
              
              return checkFormatStringExpr(S, Arg, new ArrayRef</*const*/ Expr /*P*/ >(Args), 
                  HasVAListArg, format_idx, firstDataArg, 
                  Type, CallType, InFunctionCall, 
                  CheckedVarArgs, UncoveredArg);
            } else {
              /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(ND);
              if ((FD != null)) {
                /*uint*/int BuiltinID = FD.getBuiltinID();
                if (BuiltinID == Builtin.ID.BI__builtin___CFStringMakeConstantString.getValue()
                   || BuiltinID == Builtin.ID.BI__builtin___NSStringMakeConstantString.getValue()) {
                  /*const*/ Expr /*P*/ Arg = CE.getArg$Const(0);
                  return checkFormatStringExpr(S, Arg, new ArrayRef</*const*/ Expr /*P*/ >(Args), 
                      HasVAListArg, format_idx, 
                      firstDataArg, Type, CallType, 
                      InFunctionCall, CheckedVarArgs, 
                      UncoveredArg);
                }
              }
            }
          }
        }
      }
      
      return StringLiteralCheckType.SLCT_NotALiteral;
    }
   case ObjCStringLiteralClass:
   case StringLiteralClass:
    {
      /*const*/ StringLiteral /*P*/ StrE = null;
      {
        
        /*const*/ ObjCStringLiteral /*P*/ ObjCFExpr = dyn_cast_ObjCStringLiteral(E);
        if ((ObjCFExpr != null)) {
          StrE = ObjCFExpr.getString$Const();
        } else {
          StrE = cast_StringLiteral(E);
        }
      }
      if ((StrE != null)) {
        CheckFormatString(S, StrE, E, new ArrayRef</*const*/ Expr /*P*/ >(Args), HasVAListArg, format_idx, 
            firstDataArg, Type, InFunctionCall, CallType, 
            CheckedVarArgs, UncoveredArg);
        return StringLiteralCheckType.SLCT_CheckedLiteral;
      }
      
      return StringLiteralCheckType.SLCT_NotALiteral;
    }
   default:
    return StringLiteralCheckType.SLCT_NotALiteral;
  }
 }
}


// Determines if the specified is a C++ class or struct containing
// a member with the specified name and kind (e.g. a CXXMethodDecl named
// "c_str()").
/*template <typename MemberKind> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="CXXRecordMembersNamed">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4801,
 FQN="CXXRecordMembersNamed", NM="Tpl__ZL21CXXRecordMembersNamedN4llvm9StringRefERN5clang4SemaENS1_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=Tpl__ZL21CXXRecordMembersNamedN4llvm9StringRefERN5clang4SemaENS1_8QualTypeE")
//</editor-fold>
public static </*typename*/ MemberKind extends Decl> SmallPtrSet<MemberKind> CXXRecordMembersNamed(Class<MemberKind> clazz, StringRef Name, final Sema /*&*/ S, QualType Ty) {
  LookupResult R = null;
  try {
    /*const*/ RecordType /*P*/ RT = Ty.$arrow().<RecordType>getAs$RecordType();
    SmallPtrSet<MemberKind> Results = new SmallPtrSet<>(DenseMapInfo$LikePtr.$Info(), 1);
    if (!(RT != null)) {
      return Results;
    }
    /*const*/ CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(RT.getDecl());
    if (!(RD != null) || !(RD.getDefinition() != null)) {
      return Results;
    }
    
    R/*J*/= new LookupResult(S, new DeclarationName($AddrOf(S.Context.Idents.get(/*NO_COPY*/Name))), new SourceLocation(), 
        Sema.LookupNameKind.LookupMemberName);
    R.suppressDiagnostics();
    
    // We just need to include all members of the right kind turned up by the
    // filter, at this point.
    if (S.LookupQualifiedName(R, RT.getDecl())) {
      for (UnresolvedSetIterator I = R.begin(), E = R.end(); I.$noteq(E); I.$preInc()) {
        NamedDecl /*P*/ decl = (I.$star()).getUnderlyingDecl();
        {
          MemberKind /*P*/ FK = dyn_cast(clazz, decl);
          if (FK != null) {
            Results.insert(FK);
          }
        }
      }
    }
    return Results;
  } finally {
    if (R != null) { R.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="requiresParensToAddCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 5022,
 FQN="requiresParensToAddCast", NM="_ZL23requiresParensToAddCastPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL23requiresParensToAddCastPKN5clang4ExprE")
//</editor-fold>
public static boolean requiresParensToAddCast(/*const*/ Expr /*P*/ E) {
  // FIXME: We should have a general way to reason about operator
  // precedence and whether parens are actually needed here.
  // Take care of a few common cases where they aren't.
  /*const*/ Expr /*P*/ Inside = E.IgnoreImpCasts$Const();
  {
    /*const*/ PseudoObjectExpr /*P*/ POE = dyn_cast_PseudoObjectExpr(Inside);
    if ((POE != null)) {
      Inside = POE.getSyntacticForm$Const().IgnoreImpCasts$Const();
    }
  }
  switch (Inside.getStmtClass()) {
   case ArraySubscriptExprClass:
   case CallExprClass:
   case CharacterLiteralClass:
   case CXXBoolLiteralExprClass:
   case DeclRefExprClass:
   case FloatingLiteralClass:
   case IntegerLiteralClass:
   case MemberExprClass:
   case ObjCArrayLiteralClass:
   case ObjCBoolLiteralExprClass:
   case ObjCBoxedExprClass:
   case ObjCDictionaryLiteralClass:
   case ObjCEncodeExprClass:
   case ObjCIvarRefExprClass:
   case ObjCMessageExprClass:
   case ObjCPropertyRefExprClass:
   case ObjCStringLiteralClass:
   case ObjCSubscriptRefExprClass:
   case ParenExprClass:
   case StringLiteralClass:
   case UnaryOperatorClass:
    return false;
   default:
    return true;
  }
}

//<editor-fold defaultstate="collapsed" desc="shouldNotPrintDirectly">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 5058,
 FQN="shouldNotPrintDirectly", NM="_ZL22shouldNotPrintDirectlyRKN5clang10ASTContextENS_8QualTypeEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL22shouldNotPrintDirectlyRKN5clang10ASTContextENS_8QualTypeEPKNS_4ExprE")
//</editor-fold>
public static std.pair<QualType, StringRef> shouldNotPrintDirectly(final /*const*/ ASTContext /*&*/ Context, 
                      QualType IntendedTy, 
                      /*const*/ Expr /*P*/ E) {
  // Use a 'while' to peel off layers of typedefs.
  QualType TyTy = new QualType(IntendedTy);
  {
    /*const*/ TypedefType /*P*/ UserTy;
    while (((/*P*/ UserTy = TyTy.$arrow().<TypedefType>getAs$TypedefType()) != null)) {
      StringRef Name = UserTy.getDecl().getName();
      QualType CastTy = new StringSwitch<QualType>(/*NO_COPY*/Name).
          Case(/*KEEP_STR*/"NSInteger", Context.LongTy.$QualType()).
          Case(/*KEEP_STR*/"NSUInteger", Context.UnsignedLongTy.$QualType()).
          Case(/*KEEP_STR*/"SInt32", Context.IntTy.$QualType()).
          Case(/*KEEP_STR*/"UInt32", Context.UnsignedIntTy.$QualType()).
          Default(new QualType());
      if (!CastTy.isNull()) {
        return std.make_pair(CastTy, Name);
      }
      
      TyTy.$assignMove(UserTy.desugar());
    }
  }
  {
    
    // Strip parens if necessary.
    /*const*/ ParenExpr /*P*/ PE = dyn_cast_ParenExpr(E);
    if ((PE != null)) {
      return shouldNotPrintDirectly(Context, 
          PE.getSubExpr$Const().getType(), 
          PE.getSubExpr$Const());
    }
  }
  {
    
    // If this is a conditional expression, then its result type is constructed
    // via usual arithmetic conversions and thus there might be no necessary
    // typedef sugar there.  Recurse to operands to check for NSInteger &
    // Co. usage condition.
    /*const*/ ConditionalOperator /*P*/ CO = dyn_cast_ConditionalOperator(E);
    if ((CO != null)) {
      //JAVA: rewrite std.tie(TrueTy, TrueName).$assign(shouldNotPrintDirectly);
      pair<QualType, StringRef> pair = shouldNotPrintDirectly(Context, 
              CO.getTrueExpr().getType(),
              CO.getTrueExpr());
      QualType TrueTy/*J*/= pair.first;
      StringRef TrueName/*J*/= pair.second;
      //JAVA: rewrite std.tie(FalseTy, FalseName).$assign_pair$_U1$_U2(pair2);
      pair = shouldNotPrintDirectly(Context, 
              CO.getFalseExpr().getType(),
              CO.getFalseExpr());
      QualType FalseTy/*J*/= pair.first;
      StringRef FalseName/*J*/= pair.second;
      if ($eq_QualType$C(TrueTy, FalseTy)) {
        return std.make_pair(TrueTy, TrueName);
      } else if (TrueTy.isNull()) {
        return std.make_pair(FalseTy, FalseName);
      } else if (FalseTy.isNull()) {
        return std.make_pair(TrueTy, TrueName);
      }
    }
  }
  
  return std.make_pair(new QualType(), new StringRef());
}


//===--- CHECK: Warn on use of wrong absolute value function. -------------===//

// Returns the related absolute value function that is larger, of 0 if one
// does not exist.
//<editor-fold defaultstate="collapsed" desc="getLargerAbsoluteValueFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 5642,
 FQN="getLargerAbsoluteValueFunction", NM="_ZL30getLargerAbsoluteValueFunctionj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL30getLargerAbsoluteValueFunctionj")
//</editor-fold>
public static /*uint*/int getLargerAbsoluteValueFunction(/*uint*/int AbsFunction) {
  switch (ID.valueOf(AbsFunction)) {
   default:
    return 0;
   case BI__builtin_abs:
    return Builtin.ID.BI__builtin_labs.getValue();
   case BI__builtin_labs:
    return Builtin.ID.BI__builtin_llabs.getValue();
   case BI__builtin_llabs:
    return 0;
   case BI__builtin_fabsf:
    return Builtin.ID.BI__builtin_fabs.getValue();
   case BI__builtin_fabs:
    return Builtin.ID.BI__builtin_fabsl.getValue();
   case BI__builtin_fabsl:
    return 0;
   case BI__builtin_cabsf:
    return Builtin.ID.BI__builtin_cabs.getValue();
   case BI__builtin_cabs:
    return Builtin.ID.BI__builtin_cabsl.getValue();
   case BI__builtin_cabsl:
    return 0;
   case BIabs:
    return Builtin.ID.BIlabs.getValue();
   case BIlabs:
    return Builtin.ID.BIllabs.getValue();
   case BIllabs:
    return 0;
   case BIfabsf:
    return Builtin.ID.BIfabs.getValue();
   case BIfabs:
    return Builtin.ID.BIfabsl.getValue();
   case BIfabsl:
    return 0;
   case BIcabsf:
    return Builtin.ID.BIcabs.getValue();
   case BIcabs:
    return Builtin.ID.BIcabsl.getValue();
   case BIcabsl:
    return 0;
  }
}


// Returns the argument type of the absolute value function.
//<editor-fold defaultstate="collapsed" desc="getAbsoluteValueArgumentType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 5692,
 FQN="getAbsoluteValueArgumentType", NM="_ZL28getAbsoluteValueArgumentTypeRN5clang10ASTContextEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL28getAbsoluteValueArgumentTypeRN5clang10ASTContextEj")
//</editor-fold>
public static QualType getAbsoluteValueArgumentType(final ASTContext /*&*/ Context, 
                            /*uint*/int AbsType) {
  if (AbsType == 0) {
    return new QualType();
  }
  
  type$ref<ASTContext.GetBuiltinTypeError> Error = create_type$ref(ASTContext.GetBuiltinTypeError.GE_None);
  QualType BuiltinType = Context.GetBuiltinType(AbsType, Error);
  if (Error.$deref() != ASTContext.GetBuiltinTypeError.GE_None) {
    return new QualType();
  }
  
  /*const*/ FunctionProtoType /*P*/ FT = BuiltinType.$arrow().getAs(FunctionProtoType.class);
  if (!(FT != null)) {
    return new QualType();
  }
  if (FT.getNumParams() != 1) {
    return new QualType();
  }
  
  return FT.getParamType(0);
}


// Returns the best absolute value function, or zero, based on type and
// current absolute value function.
//<editor-fold defaultstate="collapsed" desc="getBestAbsFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 5714,
 FQN="getBestAbsFunction", NM="_ZL18getBestAbsFunctionRN5clang10ASTContextENS_8QualTypeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL18getBestAbsFunctionRN5clang10ASTContextENS_8QualTypeEj")
//</editor-fold>
public static /*uint*/int getBestAbsFunction(final ASTContext /*&*/ Context, QualType ArgType, 
                  /*uint*/int AbsFunctionKind) {
  /*uint*/int BestKind = 0;
  long/*uint64_t*/ ArgSize = Context.getTypeSize(new QualType(ArgType));
  for (/*uint*/int Kind = AbsFunctionKind; Kind != 0;
       Kind = getLargerAbsoluteValueFunction(Kind)) {
    QualType ParamType = getAbsoluteValueArgumentType(Context, Kind);
    if ($greatereq_ulong(Context.getTypeSize(new QualType(ParamType)), ArgSize)) {
      if (BestKind == 0) {
        BestKind = Kind;
      } else if (Context.hasSameType(new QualType(ParamType), new QualType(ArgType))) {
        BestKind = Kind;
        break;
      }
    }
  }
  return BestKind;
}

//<editor-fold defaultstate="collapsed" desc="getAbsoluteValueKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 5739,
 FQN="getAbsoluteValueKind", NM="_ZL20getAbsoluteValueKindN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL20getAbsoluteValueKindN5clang8QualTypeE")
//</editor-fold>
public static AbsoluteValueKind getAbsoluteValueKind(QualType T) {
  if (T.$arrow().isIntegralOrEnumerationType()) {
    return AbsoluteValueKind.AVK_Integer;
  }
  if (T.$arrow().isRealFloatingType()) {
    return AbsoluteValueKind.AVK_Floating;
  }
  if (T.$arrow().isAnyComplexType()) {
    return AbsoluteValueKind.AVK_Complex;
  }
  throw new llvm_unreachable("Type not integer, floating, or complex");
}


// Changes the absolute value function to a different type.  Preserves whether
// the function is a builtin.
//<editor-fold defaultstate="collapsed" desc="changeAbsFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 5752,
 FQN="changeAbsFunction", NM="_ZL17changeAbsFunctionj17AbsoluteValueKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL17changeAbsFunctionj17AbsoluteValueKind")
//</editor-fold>
public static /*uint*/int changeAbsFunction(/*uint*/int AbsKind, 
                 AbsoluteValueKind ValueKind) {
  switch (ValueKind) {
   case AVK_Integer:
    switch (ID.valueOf(AbsKind)) {
     default:
      return 0;
     case BI__builtin_fabsf:
     case BI__builtin_fabs:
     case BI__builtin_fabsl:
     case BI__builtin_cabsf:
     case BI__builtin_cabs:
     case BI__builtin_cabsl:
      return Builtin.ID.BI__builtin_abs.getValue();
     case BIfabsf:
     case BIfabs:
     case BIfabsl:
     case BIcabsf:
     case BIcabs:
     case BIcabsl:
      return Builtin.ID.BIabs.getValue();
    }
   case AVK_Floating:
    switch (ID.valueOf(AbsKind)) {
     default:
      return 0;
     case BI__builtin_abs:
     case BI__builtin_labs:
     case BI__builtin_llabs:
     case BI__builtin_cabsf:
     case BI__builtin_cabs:
     case BI__builtin_cabsl:
      return Builtin.ID.BI__builtin_fabsf.getValue();
     case BIabs:
     case BIlabs:
     case BIllabs:
     case BIcabsf:
     case BIcabs:
     case BIcabsl:
      return Builtin.ID.BIfabsf.getValue();
    }
   case AVK_Complex:
    switch (ID.valueOf(AbsKind)) {
     default:
      return 0;
     case BI__builtin_abs:
     case BI__builtin_labs:
     case BI__builtin_llabs:
     case BI__builtin_fabsf:
     case BI__builtin_fabs:
     case BI__builtin_fabsl:
      return Builtin.ID.BI__builtin_cabsf.getValue();
     case BIabs:
     case BIlabs:
     case BIllabs:
     case BIfabsf:
     case BIfabs:
     case BIfabsl:
      return Builtin.ID.BIcabsf.getValue();
    }
  }
  throw new llvm_unreachable("Unable to convert function");
}

//<editor-fold defaultstate="collapsed" desc="getAbsoluteValueFunctionKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 5816,
 FQN="getAbsoluteValueFunctionKind", NM="_ZL28getAbsoluteValueFunctionKindPKN5clang12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL28getAbsoluteValueFunctionKindPKN5clang12FunctionDeclE")
//</editor-fold>
public static /*uint*/int getAbsoluteValueFunctionKind(/*const*/ FunctionDecl /*P*/ FDecl) {
  /*const*/ IdentifierInfo /*P*/ FnInfo = FDecl.getIdentifier();
  if (!(FnInfo != null)) {
    return 0;
  }
  switch (ID.valueOf(FDecl.getBuiltinID())) {
   default:
    return 0;
   case BI__builtin_abs:
   case BI__builtin_fabs:
   case BI__builtin_fabsf:
   case BI__builtin_fabsl:
   case BI__builtin_labs:
   case BI__builtin_llabs:
   case BI__builtin_cabs:
   case BI__builtin_cabsf:
   case BI__builtin_cabsl:
   case BIabs:
   case BIlabs:
   case BIllabs:
   case BIfabs:
   case BIfabsf:
   case BIfabsl:
   case BIcabs:
   case BIcabsf:
   case BIcabsl:
    return FDecl.getBuiltinID();
  }
  //throw new llvm_unreachable("Unknown Builtin type");
}


// If the replacement is valid, emit a note with replacement function.
// Additionally, suggest including the proper header if not already included.
//<editor-fold defaultstate="collapsed" desc="emitReplacement">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 optimized = Converted.Optimization.VALUE_TYPE,       
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 5849,
 FQN="emitReplacement", NM="_ZL15emitReplacementRN5clang4SemaENS_14SourceLocationENS_11SourceRangeEjNS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL15emitReplacementRN5clang4SemaENS_14SourceLocationENS_11SourceRangeEjNS_8QualTypeE")
//</editor-fold>
public static void emitReplacement(final Sema /*&*/ S, SourceLocation Loc, SourceRange Range, 
               /*uint*/int AbsKind, QualType ArgType) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    boolean EmitHeaderHint = true;
    /*const*/char$ptr/*char P*/ HeaderName = null;
    /*const*/char$ptr/*char P*/ FunctionName = null;
    if (S.getLangOpts().CPlusPlus && !ArgType.$arrow().isAnyComplexType()) {
      FunctionName = $tryClone($("std::abs"));
      if (ArgType.$arrow().isIntegralOrEnumerationType()) {
        HeaderName = $tryClone($("cstdlib"));
      } else if (ArgType.$arrow().isRealFloatingType()) {
        HeaderName = $tryClone($("cmath"));
      } else {
        throw new llvm_unreachable("Invalid Type");
      }
      {
        
        // Lookup all std::abs
        NamespaceDecl /*P*/ Std = S.getStdNamespace();
        if ((Std != null)) {
          LookupResult R = null;
          try {
            R/*J*/= new LookupResult(S, new DeclarationName($AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"abs")))), new SourceLocation(Loc), Sema.LookupNameKind.LookupAnyName);
            R.suppressDiagnostics();
            S.LookupQualifiedName(R, Std);
            
            for (/*const*/ NamedDecl /*P*/ I : R) {
              /*const*/ FunctionDecl /*P*/ FDecl = null;
              {
                /*const*/ UsingShadowDecl /*P*/ UsingD = dyn_cast_UsingShadowDecl(I);
                if ((UsingD != null)) {
                  FDecl = dyn_cast_FunctionDecl(UsingD.getTargetDecl());
                } else {
                  FDecl = dyn_cast_FunctionDecl(I);
                }
              }
              if (!(FDecl != null)) {
                continue;
              }
              
              // Found std::abs(), check that they are the right ones.
              if (FDecl.getNumParams() != 1) {
                continue;
              }
              
              // Check that the parameter type can handle the argument.
              QualType ParamType = FDecl.getParamDecl$Const(0).getType();
              if (getAbsoluteValueKind(new QualType(ArgType)) == getAbsoluteValueKind(new QualType(ParamType))
                 && $lesseq_ulong(S.Context.getTypeSize(new QualType(ArgType))
                , S.Context.getTypeSize(new QualType(ParamType)))) {
                // Found a function, don't need the header hint.
                EmitHeaderHint = false;
                break;
              }
            }
          } finally {
            if (R != null) { R.$destroy(); }
          }
        }
      }
    } else {
      FunctionName = $tryClone(S.Context.BuiltinInfo.getName(AbsKind));
      HeaderName = $tryClone(S.Context.BuiltinInfo.getHeaderName(AbsKind));
      if ((HeaderName != null)) {
        LookupResult R = null;
        try {
          // JAVA PERF
          DeclarationName DN/*J*/= new DeclarationName($AddrOf(S.Context.Idents.get(FunctionName.$array(), FunctionName.$index(), std.strlen(FunctionName))));
          R/*J*/= new LookupResult(S, new DeclarationName(DN), new SourceLocation(Loc), Sema.LookupNameKind.LookupAnyName);
          R.suppressDiagnostics();
          S.LookupName(R, S.getCurScope());
          if (R.isSingleResult()) {
            FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(R.getFoundDecl());
            if ((FD != null) && FD.getBuiltinID() == AbsKind) {
              EmitHeaderHint = false;
            } else {
              return;
            }
          } else if (!R.empty()) {
            return;
          }
        } finally {
          if (R != null) { R.$destroy(); }
        }
      }
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.note_replace_abs_function)), 
            FunctionName), FixItHint.CreateReplacement(/*NO_COPY*/Range, new StringRef(FunctionName))));
    if (!(HeaderName != null)) {
      return;
    }
    if (!EmitHeaderHint) {
      return;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.note_include_header_or_declare)), HeaderName), 
        FunctionName));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="IsFunctionStdAbs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 5931,
 FQN="IsFunctionStdAbs", NM="_ZL16IsFunctionStdAbsPKN5clang12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL16IsFunctionStdAbsPKN5clang12FunctionDeclE")
//</editor-fold>
public static boolean IsFunctionStdAbs(/*const*/ FunctionDecl /*P*/ FDecl) {
  if (!(FDecl != null)) {
    return false;
  }
  if (!(FDecl.getIdentifier() != null) || !FDecl.getIdentifier().isStr(/*KEEP_STR*/"abs")) {
    return false;
  }
  
  /*const*/ NamespaceDecl /*P*/ ND = dyn_cast_NamespaceDecl(FDecl.getDeclContext$Const());
  while ((ND != null) && ND.isInlineNamespace()) {
    ND = dyn_cast_NamespaceDecl(ND.getDeclContext$Const());
  }
  if (!(ND != null) || !(ND.getIdentifier() != null) || !ND.getIdentifier().isStr(/*KEEP_STR*/"std")) {
    return false;
  }
  if (!isa_TranslationUnitDecl(ND.getDeclContext$Const())) {
    return false;
  }
  
  return true;
}


//===--- CHECK: Standard memory functions ---------------------------------===//

/// \brief Takes the expression passed to the size_t parameter of functions
/// such as memcmp, strncat, etc and warns if it's a comparison.
///
/// This is to catch typos like `if (memcmp(&a, &b, sizeof(a) > 0))`.
//<editor-fold defaultstate="collapsed" desc="CheckMemorySizeofForComparison">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 6040,
 FQN="CheckMemorySizeofForComparison", NM="_ZL30CheckMemorySizeofForComparisonRN5clang4SemaEPKNS_4ExprEPNS_14IdentifierInfoENS_14SourceLocationES7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL30CheckMemorySizeofForComparisonRN5clang4SemaEPKNS_4ExprEPNS_14IdentifierInfoENS_14SourceLocationES7_")
//</editor-fold>
public static boolean CheckMemorySizeofForComparison(final Sema /*&*/ S, /*const*/ Expr /*P*/ E, 
                              IdentifierInfo /*P*/ FnName, 
                              SourceLocation FnLoc, 
                              SourceLocation RParenLoc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    /*const*/ BinaryOperator /*P*/ Size = dyn_cast_BinaryOperator(E);
    if (!(Size != null)) {
      return false;
    }
    
    // if E is binop and op is >, <, >=, <=, ==, &&, ||:
    if (!Size.isComparisonOp() && !Size.isEqualityOp() && !Size.isLogicalOp()) {
      return false;
    }
    
    SourceRange SizeRange = Size.getSourceRange();
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Size.getOperatorLoc(), diag.warn_memsize_comparison)), 
            SizeRange), FnName));
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(FnLoc), diag.note_memsize_comparison_paren)), 
                FnName), FixItHint.CreateInsertion(S.getLocForEndOfToken(Size.getLHS().getLocEnd()), new StringRef(/*KEEP_STR*/$RPAREN))), 
        FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/RParenLoc))));
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(SizeRange.getBegin(), diag.note_memsize_comparison_cast_silence)), 
            FixItHint.CreateInsertion(SizeRange.getBegin(), new StringRef(/*KEEP_STR*/"(size_t)("))), 
        FixItHint.CreateInsertion(S.getLocForEndOfToken(SizeRange.getEnd()), 
            new StringRef(/*KEEP_STR*/$RPAREN))));
    
    return true;
  } finally {
    $c$.$destroy();
  }
}


/// \brief Determine whether the given type is or contains a dynamic class type
/// (e.g., whether it has a vtable).
//<editor-fold defaultstate="collapsed" desc="getContainedDynamicClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 6069,
 FQN="getContainedDynamicClass", NM="_ZL24getContainedDynamicClassN5clang8QualTypeERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL24getContainedDynamicClassN5clang8QualTypeERb")
//</editor-fold>
public static /*const*/ CXXRecordDecl /*P*/ getContainedDynamicClass(QualType T, 
                        final bool$ref/*bool &*/ IsContained) {
  // Look through array types while ignoring qualifiers.
  /*const*/ Type /*P*/ Ty = T.$arrow().getBaseElementTypeUnsafe();
  IsContained.$set(false);
  
  /*const*/ CXXRecordDecl /*P*/ RD = Ty.getAsCXXRecordDecl();
  RD = (RD != null) ? RD.getDefinition() : null;
  if (!(RD != null) || RD.isInvalidDecl()) {
    return null;
  }
  if (RD.isDynamicClass()) {
    return RD;
  }
  
  // Check all the fields.  If any bases were dynamic, the class is dynamic.
  // It's impossible for a class to transitively contain itself by value, so
  // infinite recursion is impossible.
  for (FieldDecl /*P*/ FD : RD.fields()) {
    bool$ref SubContained = create_bool$ref();
    {
      /*const*/ CXXRecordDecl /*P*/ ContainedRD = getContainedDynamicClass(FD.getType(), SubContained);
      if ((ContainedRD != null)) {
        IsContained.$set(true);
        return ContainedRD;
      }
    }
  }
  
  return null;
}


/// \brief If E is a sizeof expression, returns its argument expression,
/// otherwise returns NULL.
//<editor-fold defaultstate="collapsed" desc="getSizeOfExprArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 6100,
 FQN="getSizeOfExprArg", NM="_ZL16getSizeOfExprArgPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL16getSizeOfExprArgPKN5clang4ExprE")
//</editor-fold>
public static /*const*/ Expr /*P*/ getSizeOfExprArg(/*const*/ Expr /*P*/ E) {
  {
    /*const*/ UnaryExprOrTypeTraitExpr /*P*/ SizeOf = dyn_cast_UnaryExprOrTypeTraitExpr(E);
    if ((SizeOf != null)) {
      if (SizeOf.getKind() == UnaryExprOrTypeTrait.UETT_SizeOf && !SizeOf.isArgumentType()) {
        return SizeOf.getArgumentExpr$Const().IgnoreParenImpCasts$Const();
      }
    }
  }
  
  return null;
}


/// \brief If E is a sizeof expression, returns its argument type.
//<editor-fold defaultstate="collapsed" desc="getSizeOfArgType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 6110,
 FQN="getSizeOfArgType", NM="_ZL16getSizeOfArgTypePKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL16getSizeOfArgTypePKN5clang4ExprE")
//</editor-fold>
public static QualType getSizeOfArgType(/*const*/ Expr /*P*/ E) {
  {
    /*const*/ UnaryExprOrTypeTraitExpr /*P*/ SizeOf = dyn_cast_UnaryExprOrTypeTraitExpr(E);
    if ((SizeOf != null)) {
      if (SizeOf.getKind() == UnaryExprOrTypeTrait.UETT_SizeOf) {
        return SizeOf.getTypeOfArgument();
      }
    }
  }
  
  return new QualType();
}


// A little helper routine: ignore addition and subtraction of integer literals.
// This intentionally does not ignore all integer constant expressions because
// we don't want to remove sizeof().
//<editor-fold defaultstate="collapsed" desc="ignoreLiteralAdditions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 6289,
 FQN="ignoreLiteralAdditions", NM="_ZL22ignoreLiteralAdditionsPKN5clang4ExprERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL22ignoreLiteralAdditionsPKN5clang4ExprERNS_10ASTContextE")
//</editor-fold>
public static /*const*/ Expr /*P*/ ignoreLiteralAdditions(/*const*/ Expr /*P*/ Ex, final ASTContext /*&*/ Ctx) {
  Ex = Ex.IgnoreParenCasts$Const();
  
  for (;;) {
    /*const*/ BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(Ex);
    if (!(BO != null) || !BO.isAdditiveOp()) {
      break;
    }
    
    /*const*/ Expr /*P*/ RHS = BO.getRHS().IgnoreParenCasts();
    /*const*/ Expr /*P*/ LHS = BO.getLHS().IgnoreParenCasts();
    if (isa_IntegerLiteral(RHS)) {
      Ex = LHS;
    } else if (isa_IntegerLiteral(LHS)) {
      Ex = RHS;
    } else {
      break;
    }
  }
  
  return Ex;
}

//<editor-fold defaultstate="collapsed" desc="isConstantSizeArrayWithMoreThanOneElement">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 6311,
 FQN="isConstantSizeArrayWithMoreThanOneElement", NM="_ZL41isConstantSizeArrayWithMoreThanOneElementN5clang8QualTypeERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL41isConstantSizeArrayWithMoreThanOneElementN5clang8QualTypeERNS_10ASTContextE")
//</editor-fold>
public static boolean isConstantSizeArrayWithMoreThanOneElement(QualType Ty, 
                                         final ASTContext /*&*/ Context) {
  {
    // Only handle constant-sized or VLAs, but not flexible members.
    /*const*/ ConstantArrayType /*P*/ CAT = Context.getAsConstantArrayType(new QualType(Ty));
    if ((CAT != null)) {
      // Only issue the FIXIT for arrays of size > 1.
      if (CAT.getSize().getSExtValue() <= 1) {
        return false;
      }
    } else if (!Ty.$arrow().isVariableArrayType()) {
      return false;
    }
  }
  return true;
}


/// Check if two expressions refer to the same declaration.
//<editor-fold defaultstate="collapsed" desc="referToTheSameDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 6394,
 FQN="referToTheSameDecl", NM="_ZL18referToTheSameDeclPKN5clang4ExprES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL18referToTheSameDeclPKN5clang4ExprES2_")
//</editor-fold>
public static boolean referToTheSameDecl(/*const*/ Expr /*P*/ E1, /*const*/ Expr /*P*/ E2) {
  {
    /*const*/ DeclRefExpr /*P*/ D1 = dyn_cast_or_null_DeclRefExpr(E1);
    if ((D1 != null)) {
      {
        /*const*/ DeclRefExpr /*P*/ D2 = dyn_cast_or_null_DeclRefExpr(E2);
        if ((D2 != null)) {
          return D1.getDecl$Const() == D2.getDecl$Const();
        }
      }
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="getStrlenExprArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 6401,
 FQN="getStrlenExprArg", NM="_ZL16getStrlenExprArgPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL16getStrlenExprArgPKN5clang4ExprE")
//</editor-fold>
public static /*const*/ Expr /*P*/ getStrlenExprArg(/*const*/ Expr /*P*/ E) {
  {
    /*const*/ CallExpr /*P*/ CE = dyn_cast_CallExpr(E);
    if ((CE != null)) {
      /*const*/ FunctionDecl /*P*/ FD = CE.getDirectCallee$Const();
      if (!(FD != null) || FD.getMemoryFunctionKind() != Builtin.ID.BIstrlen.getValue()) {
        return null;
      }
      return CE.getArg$Const(0).IgnoreParenCasts$Const();
    }
  }
  return null;
}


//===--- CHECK: Return Address of Stack Variable --------------------------===//

///  EvalVal - This function is complements EvalAddr in the mutual recursion.
///   See the comments for EvalAddr for more details.
//<editor-fold defaultstate="collapsed" desc="EvalVal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 6761,
 FQN="EvalVal", NM="_ZL7EvalValPKN5clang4ExprERN4llvm15SmallVectorImplIPKNS_11DeclRefExprEEEPKNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL7EvalValPKN5clang4ExprERN4llvm15SmallVectorImplIPKNS_11DeclRefExprEEEPKNS_4DeclE")
//</editor-fold>
public static /*const*/ Expr /*P*/ EvalVal(/*const*/ Expr /*P*/ E, 
       final SmallVectorImpl</*const*/ DeclRefExpr /*P*/ > /*&*/ refVars, 
       /*const*/ Decl /*P*/ ParentDecl) {
  do {
    // We should only be called for evaluating non-pointer expressions, or
    // expressions with a pointer type that are not used as references but
    // instead
    // are l-values (e.g., DeclRefExpr with a pointer type).
    
    // Our "symbolic interpreter" is just a dispatch off the currently
    // viewed AST node.  We then recursively traverse the AST by calling
    // EvalAddr and EvalVal appropriately.
    E = E.IgnoreParens$Const();
    switch (E.getStmtClass()) {
     case ImplicitCastExprClass:
      {
        /*const*/ ImplicitCastExpr /*P*/ IE = cast_ImplicitCastExpr(E);
        if (IE.getValueKind() == ExprValueKind.VK_LValue) {
          E = IE.getSubExpr$Const();
          continue;
        }
        return null;
      }
     case ExprWithCleanupsClass:
      return EvalVal(cast_ExprWithCleanups(E).getSubExpr$Const(), refVars, 
          ParentDecl);
     case DeclRefExprClass:
      {
        // When we hit a DeclRefExpr we are looking at code that refers to a
        // variable's name. If it's not a reference variable we check if it has
        // local storage within the function, and if so, return the expression.
        /*const*/ DeclRefExpr /*P*/ DR = cast_DeclRefExpr(E);
        
        // If we leave the immediate function, the lifetime isn't about to end.
        if (DR.refersToEnclosingVariableOrCapture()) {
          return null;
        }
        {
          
          /*const*/ VarDecl /*P*/ V = dyn_cast_VarDecl(DR.getDecl$Const());
          if ((V != null)) {
            // Check if it refers to itself, e.g. "int& i = i;".
            if (V == ParentDecl) {
              return DR;
            }
            if (V.hasLocalStorage()) {
              if (!V.getType().$arrow().isReferenceType()) {
                return DR;
              }
              
              // Reference variable, follow through to the expression that
              // it points to.
              if (V.hasInit()) {
                // Add the reference variable to the "trail".
                refVars.push_back(DR);
                return EvalVal(V.getInit$Const(), refVars, V);
              }
            }
          }
        }
        
        return null;
      }
     case UnaryOperatorClass:
      {
        // The only unary operator that make sense to handle here
        // is Deref.  All others don't resolve to a "name."  This includes
        // handling all sorts of rvalues passed to a unary operator.
        /*const*/ UnaryOperator /*P*/ U = cast_UnaryOperator(E);
        if (U.getOpcode() == UnaryOperatorKind.UO_Deref) {
          return EvalAddr(U.getSubExpr(), refVars, ParentDecl);
        }
        
        return null;
      }
     case ArraySubscriptExprClass:
      {
        // Array subscripts are potential references to data on the stack.  We
        // retrieve the DeclRefExpr* for the array variable if it indeed
        // has local storage.
        /*const*/ ArraySubscriptExpr /*P*/ ASE = cast_ArraySubscriptExpr(E);
        if (ASE.isTypeDependent()) {
          return null;
        }
        return EvalAddr(ASE.getBase$Const(), refVars, ParentDecl);
      }
     case OMPArraySectionExprClass:
      {
        return EvalAddr(cast_OMPArraySectionExpr(E).getBase$Const(), refVars, 
            ParentDecl);
      }
     case ConditionalOperatorClass:
      {
        // For conditional operators we need to see if either the LHS or RHS are
        // non-NULL Expr's.  If one is non-NULL, we return it.
        /*const*/ ConditionalOperator /*P*/ C = cast_ConditionalOperator(E);
        {
          
          // Handle the GNU extension for missing LHS.
          /*const*/ Expr /*P*/ LHSExpr = C.getLHS();
          if ((LHSExpr != null)) {
            // In C++, we can have a throw-expression, which has 'void' type.
            if (!LHSExpr.getType().$arrow().isVoidType()) {
              {
                /*const*/ Expr /*P*/ LHS = EvalVal(LHSExpr, refVars, ParentDecl);
                if ((LHS != null)) {
                  return LHS;
                }
              }
            }
          }
        }
        
        // In C++, we can have a throw-expression, which has 'void' type.
        if (C.getRHS().getType().$arrow().isVoidType()) {
          return null;
        }
        
        return EvalVal(C.getRHS(), refVars, ParentDecl);
      }
     case MemberExprClass:
      {
        /*const*/ MemberExpr /*P*/ M = cast_MemberExpr(E);
        
        // Check for indirect access.  We only want direct field accesses.
        if (M.isArrow()) {
          return null;
        }
        
        // Check whether the member type is itself a reference, in which case
        // we're not going to refer to the member, but to what the member refers
        // to.
        if (M.getMemberDecl().getType().$arrow().isReferenceType()) {
          return null;
        }
        
        return EvalVal(M.getBase(), refVars, ParentDecl);
      }
     case MaterializeTemporaryExprClass:
      {
        /*const*/ Expr /*P*/ Result = EvalVal(cast_MaterializeTemporaryExpr(E).GetTemporaryExpr(), 
            refVars, ParentDecl);
        if ((Result != null)) {
          return Result;
        }
      }
      return E;
     default:
      // Check that we don't return or take the address of a reference to a
      // temporary. This is only useful in C++.
      if (!E.isTypeDependent() && E.isRValue()) {
        return E;
      }
      
      // Everything else: we simply don't reason about them.
      return null;
    }
  } while (true);
}


/// EvalAddr - EvalAddr and EvalVal are mutually recursive functions that
///  check if the expression in a return statement evaluates to an address
///  to a location on the stack, a local block, an address of a label, or a
///  reference to local temporary. The recursion is used to traverse the
///  AST of the return expression, with recursion backtracking when we
///  encounter a subexpression that (1) clearly does not lead to one of the
///  above problematic expressions (2) is something we cannot determine leads to
///  a problematic expression based on such local checking.
///
///  Both EvalAddr and EvalVal follow through reference variables to evaluate
///  the expression that they point to. Such variables are added to the
///  'refVars' vector so that we know what the reference variable "trail" was.
///
///  EvalAddr processes expressions that are pointers that are used as
///  references (and not L-values).  EvalVal handles all other values.
///  At the base case of the recursion is a check for the above problematic
///  expressions.
///
///  This implementation handles:
///
///   * pointer-to-pointer casts
///   * implicit conversions from array references to pointers
///   * taking the address of fields
///   * arbitrary interplay between "&" and "*" operators
///   * pointer arithmetic from an address of a stack variable
///   * taking the address of an array element where the array is on the stack
//<editor-fold defaultstate="collapsed" desc="EvalAddr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 6606,
 FQN="EvalAddr", NM="_ZL8EvalAddrPKN5clang4ExprERN4llvm15SmallVectorImplIPKNS_11DeclRefExprEEEPKNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL8EvalAddrPKN5clang4ExprERN4llvm15SmallVectorImplIPKNS_11DeclRefExprEEEPKNS_4DeclE")
//</editor-fold>
public static /*const*/ Expr /*P*/ EvalAddr(/*const*/ Expr /*P*/ E, 
        final SmallVectorImpl</*const*/ DeclRefExpr /*P*/ > /*&*/ refVars, 
        /*const*/ Decl /*P*/ ParentDecl) {
  if (E.isTypeDependent()) {
    return null;
  }
  
  // We should only be called for evaluating pointer expressions.
  assert ((E.getType().$arrow().isAnyPointerType() || E.getType().$arrow().isBlockPointerType() || E.getType().$arrow().isObjCQualifiedIdType())) : "EvalAddr only works on pointers";
  
  E = E.IgnoreParens$Const();
  
  // Our "symbolic interpreter" is just a dispatch off the currently
  // viewed AST node.  We then recursively traverse the AST by calling
  // EvalAddr and EvalVal appropriately.
  switch (E.getStmtClass()) {
   case DeclRefExprClass:
    {
      /*const*/ DeclRefExpr /*P*/ DR = cast_DeclRefExpr(E);
      
      // If we leave the immediate function, the lifetime isn't about to end.
      if (DR.refersToEnclosingVariableOrCapture()) {
        return null;
      }
      {
        
        /*const*/ VarDecl /*P*/ V = dyn_cast_VarDecl(DR.getDecl$Const());
        if ((V != null)) {
          // If this is a reference variable, follow through to the expression that
          // it points to.
          if (V.hasLocalStorage()
             && V.getType().$arrow().isReferenceType() && V.hasInit()) {
            // Add the reference variable to the "trail".
            refVars.push_back(DR);
            return EvalAddr(V.getInit$Const(), refVars, ParentDecl);
          }
        }
      }
      
      return null;
    }
   case UnaryOperatorClass:
    {
      // The only unary operator that make sense to handle here
      // is AddrOf.  All others don't make sense as pointers.
      /*const*/ UnaryOperator /*P*/ U = cast_UnaryOperator(E);
      if (U.getOpcode() == UnaryOperatorKind.UO_AddrOf) {
        return EvalVal(U.getSubExpr(), refVars, ParentDecl);
      }
      return null;
    }
   case BinaryOperatorClass:
    {
      // Handle pointer arithmetic.  All other binary operators are not valid
      // in this context.
      /*const*/ BinaryOperator /*P*/ B = cast_BinaryOperator(E);
      BinaryOperatorKind op = B.getOpcode();
      if (op != BinaryOperatorKind.BO_Add && op != BinaryOperatorKind.BO_Sub) {
        return null;
      }
      
      /*const*/ Expr /*P*/ Base = B.getLHS();
      
      // Determine which argument is the real pointer base.  It could be
      // the RHS argument instead of the LHS.
      if (!Base.getType().$arrow().isPointerType()) {
        Base = B.getRHS();
      }
      assert (Base.getType().$arrow().isPointerType());
      return EvalAddr(Base, refVars, ParentDecl);
    }
   case ConditionalOperatorClass:
    {
      /*const*/ ConditionalOperator /*P*/ C = cast_ConditionalOperator(E);
      {
        
        // Handle the GNU extension for missing LHS.
        // FIXME: That isn't a ConditionalOperator, so doesn't get here.
        /*const*/ Expr /*P*/ LHSExpr = C.getLHS();
        if ((LHSExpr != null)) {
          // In C++, we can have a throw-expression, which has 'void' type.
          if (!LHSExpr.getType().$arrow().isVoidType()) {
            {
              /*const*/ Expr /*P*/ LHS = EvalAddr(LHSExpr, refVars, ParentDecl);
              if ((LHS != null)) {
                return LHS;
              }
            }
          }
        }
      }
      
      // In C++, we can have a throw-expression, which has 'void' type.
      if (C.getRHS().getType().$arrow().isVoidType()) {
        return null;
      }
      
      return EvalAddr(C.getRHS(), refVars, ParentDecl);
    }
   case BlockExprClass:
    if (cast_BlockExpr(E).getBlockDecl$Const().hasCaptures()) {
      return E; // local block.
    }
    return null;
   case AddrLabelExprClass:
    return E; // address of label.
   case ExprWithCleanupsClass:
    return EvalAddr(cast_ExprWithCleanups(E).getSubExpr$Const(), refVars, 
        ParentDecl);
   case ImplicitCastExprClass:
   case CStyleCastExprClass:
   case CXXFunctionalCastExprClass:
   case ObjCBridgedCastExprClass:
   case CXXStaticCastExprClass:
   case CXXDynamicCastExprClass:
   case CXXConstCastExprClass:
   case CXXReinterpretCastExprClass:
    {
      /*const*/ Expr /*P*/ SubExpr = cast_CastExpr(E).getSubExpr$Const();
      switch (cast_CastExpr(E).getCastKind()) {
       case CK_LValueToRValue:
       case CK_NoOp:
       case CK_BaseToDerived:
       case CK_DerivedToBase:
       case CK_UncheckedDerivedToBase:
       case CK_Dynamic:
       case CK_CPointerToObjCPointerCast:
       case CK_BlockPointerToObjCPointerCast:
       case CK_AnyPointerToBlockPointerCast:
        return EvalAddr(SubExpr, refVars, ParentDecl);
       case CK_ArrayToPointerDecay:
        return EvalVal(SubExpr, refVars, ParentDecl);
       case CK_BitCast:
        if (SubExpr.getType().$arrow().isAnyPointerType()
           || SubExpr.getType().$arrow().isBlockPointerType()
           || SubExpr.getType().$arrow().isObjCQualifiedIdType()) {
          return EvalAddr(SubExpr, refVars, ParentDecl);
        } else {
          return null;
        }
       default:
        return null;
      }
    }
   case MaterializeTemporaryExprClass:
    {
      /*const*/ Expr /*P*/ Result = EvalAddr(cast_MaterializeTemporaryExpr(E).GetTemporaryExpr(), 
          refVars, ParentDecl);
      if ((Result != null)) {
        return Result;
      }
    }
    return E;
   default:
    
    // Everything else: we simply don't reason about them.
    return null;
  }
}


/// CheckReturnStackAddr - Check if a return statement returns the address
///   of a stack variable.
//<editor-fold defaultstate="collapsed" desc="CheckReturnStackAddr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 6507,
 FQN="CheckReturnStackAddr", NM="_ZL20CheckReturnStackAddrRN5clang4SemaEPNS_4ExprENS_8QualTypeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL20CheckReturnStackAddrRN5clang4SemaEPNS_4ExprENS_8QualTypeENS_14SourceLocationE")
//</editor-fold>
public static void CheckReturnStackAddr(final Sema /*&*/ S, Expr /*P*/ RetValExp, QualType lhsType, 
                    SourceLocation ReturnLoc) {
  
  /*const*/ Expr /*P*/ stackE = null;
  SmallVector</*const*/ DeclRefExpr /*P*/ > refVars/*J*/= new SmallVector</*const*/ DeclRefExpr /*P*/ >(8, (/*const*/ DeclRefExpr /*P*/ )null);
  
  // Perform checking for returned stack addresses, local blocks,
  // label addresses or references to temporaries.
  if (lhsType.$arrow().isPointerType()
     || (!S.getLangOpts().ObjCAutoRefCount && lhsType.$arrow().isBlockPointerType())) {
    stackE = EvalAddr(RetValExp, refVars, /*ParentDecl=*/ (/*const*/ Decl /*P*/ )null);
  } else if (lhsType.$arrow().isReferenceType()) {
    stackE = EvalVal(RetValExp, refVars, /*ParentDecl=*/ (/*const*/ Decl /*P*/ )null);
  }
  if (!(stackE != null)) {
    return; // Nothing suspicious was found.
  }
  
  // Parameters are initalized in the calling scope, so taking the address
  // of a parameter reference doesn't need a warning.
  for (/*const*/ DeclRefExpr /*P*/ DRE : refVars)  {
    if (isa_ParmVarDecl(DRE.getDecl$Const())) {
      return;
    }
  }
  
  SourceLocation diagLoc/*J*/= new SourceLocation();
  SourceRange diagRange/*J*/= new SourceRange();
  if (refVars.empty()) {
    diagLoc.$assignMove(stackE.getLocStart());
    diagRange.$assignMove(stackE.getSourceRange());
  } else {
    // We followed through a reference variable. 'stackE' contains the
    // problematic expression but we will warn at the return statement pointing
    // at the reference variable. We will later display the "trail" of
    // reference variables using notes.
    diagLoc.$assignMove(refVars.$at(0).getLocStart());
    diagRange.$assignMove(refVars.$at(0).getSourceRange());
  }
  {
    
    /*const*/ DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(stackE);
    if ((DR != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // address of local var
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(diagLoc), diag.warn_ret_stack_addr_ref)), lhsType.$arrow().isReferenceType()), 
                DR.getDecl$Const().getDeclName()), diagRange));
      } finally {
        $c$.$destroy();
      }
    } else if (isa_BlockExpr(stackE)) { // local block.
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(diagLoc), diag.err_ret_local_block)), diagRange));
      } finally {
        $c$.$destroy();
      }
    } else if (isa_AddrLabelExpr(stackE)) { // address of label.
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(diagLoc), diag.warn_ret_addr_label)), diagRange));
      } finally {
        $c$.$destroy();
      }
    } else { // local temporary.
// If there is an LValue->RValue conversion, then the value of the
// reference type is used, not the reference.
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        {
          ImplicitCastExpr /*P*/ ICE = dyn_cast_ImplicitCastExpr(RetValExp);
          if ((ICE != null)) {
            if (ICE.getCastKind() == CastKind.CK_LValueToRValue) {
              return;
            }
          }
        }
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(diagLoc), diag.warn_ret_local_temp_addr_ref)), 
                lhsType.$arrow().isReferenceType()), diagRange));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Display the "trail" of reference variables that we followed until we
  // found the problematic expression using notes.
  for (/*uint*/int i = 0, e = refVars.size(); i != e; ++i) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ VarDecl /*P*/ VD = cast_VarDecl(refVars.$at(i).getDecl$Const());
      // If this var binds to another reference var, show the range of the next
      // var, otherwise the var binds to the problematic expression, in which case
      // show the range of the expression.
      SourceRange range = ($less_uint(i, e - 1)) ? refVars.$at(i + 1).getSourceRange() : stackE.getSourceRange();
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(VD.getLocation(), diag.note_ref_var_local_bind)), 
              VD.getDeclName()), range));
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetValueRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7078,
 FQN="(anonymous namespace)::GetValueRange", NM="_ZN12_GLOBAL__N_113GetValueRangeERN5clang10ASTContextERN4llvm6APSIntEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_113GetValueRangeERN5clang10ASTContextERN4llvm6APSIntEj")
//</editor-fold>
public static IntRange GetValueRange(final ASTContext /*&*/ C, final APSInt /*&*/ value, /*uint*/int MaxWidth) {
  if (value.isSigned() && value.isNegative()) {
    return new IntRange(value.getMinSignedBits(), false);
  }
  if ($greater_uint(value.getBitWidth(), MaxWidth)) {
    value.$assignMove(value.trunc(MaxWidth));
  }
  
  // isNonNegative() just checks the sign bit without considering
  // signedness.
  return new IntRange(value.getActiveBits(), true);
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetValueRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7090,
 FQN="(anonymous namespace)::GetValueRange", NM="_ZN12_GLOBAL__N_113GetValueRangeERN5clang10ASTContextERNS0_7APValueENS0_8QualTypeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_113GetValueRangeERN5clang10ASTContextERNS0_7APValueENS0_8QualTypeEj")
//</editor-fold>
public static IntRange GetValueRange(final ASTContext /*&*/ C, final APValue /*&*/ result, QualType Ty, 
             /*uint*/int MaxWidth) {
  if (result.isInt()) {
    return GetValueRange(C, result.getInt(), MaxWidth);
  }
  if (result.isVector()) {
    IntRange R = GetValueRange(C, result.getVectorElt(0), new QualType(Ty), MaxWidth);
    for (/*uint*/int i = 1, e = result.getVectorLength(); i != e; ++i) {
      IntRange El = GetValueRange(C, result.getVectorElt(i), new QualType(Ty), MaxWidth);
      R.$assignMove(IntRange.join(new IntRange(R), new IntRange(El)));
    }
    return R;
  }
  if (result.isComplexInt()) {
    IntRange R = GetValueRange(C, result.getComplexIntReal(), MaxWidth);
    IntRange I = GetValueRange(C, result.getComplexIntImag(), MaxWidth);
    return IntRange.join(new IntRange(R), new IntRange(I));
  }
  
  // This can happen with lossless casts to intptr_t of "based" lvalues.
  // Assume it might use arbitrary bits.
  // FIXME: The only reason we need to pass the type in here is to get
  // the sign right on this one case.  It would be nice if APValue
  // preserved this.
  assert (result.isLValue() || result.isAddrLabelDiff());
  return new IntRange(MaxWidth, Ty.$arrow().isUnsignedIntegerOrEnumerationType());
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetExprType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7119,
 FQN="(anonymous namespace)::GetExprType", NM="_ZN12_GLOBAL__N_111GetExprTypeEPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_111GetExprTypeEPKN5clang4ExprE")
//</editor-fold>
public static QualType GetExprType(/*const*/ Expr /*P*/ E) {
  QualType Ty = E.getType();
  {
    /*const*/ AtomicType /*P*/ AtomicRHS = Ty.$arrow().getAs(AtomicType.class);
    if ((AtomicRHS != null)) {
      Ty.$assignMove(AtomicRHS.getValueType());
    }
  }
  return Ty;
}


/// Pseudo-evaluate the given integer expression, estimating the
/// range of values it might take.
///
/// \param MaxWidth - the width to which the value will be truncated
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetExprRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7130,
 FQN="(anonymous namespace)::GetExprRange", NM="_ZN12_GLOBAL__N_112GetExprRangeERN5clang10ASTContextEPKNS0_4ExprEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_112GetExprRangeERN5clang10ASTContextEPKNS0_4ExprEj")
//</editor-fold>
public static IntRange GetExprRange(final ASTContext /*&*/ C, /*const*/ Expr /*P*/ E, /*uint*/int MaxWidth) {
  Expr.EvalResult result = null;
  try {
    E = E.IgnoreParens$Const();
    
    // Try a full evaluation first.
    result/*J*/= new Expr.EvalResult();
    if (E.EvaluateAsRValue(result, C)) {
      return GetValueRange(C, result.Val, GetExprType(E), MaxWidth);
    }
    {
      
      // I think we only want to look through implicit casts here; if the
      // user has an explicit widening cast, we should treat the value as
      // being of the new, wider type.
      /*const*/ ImplicitCastExpr /*P*/ CE = dyn_cast_ImplicitCastExpr(E);
      if ((CE != null)) {
        if (CE.getCastKind() == CastKind.CK_NoOp || CE.getCastKind() == CastKind.CK_LValueToRValue) {
          return GetExprRange(C, CE.getSubExpr$Const(), MaxWidth);
        }
        
        IntRange OutputTypeRange = IntRange.forValueOfType(C, GetExprType(CE));
        
        boolean isIntegerCast = CE.getCastKind() == CastKind.CK_IntegralCast
           || CE.getCastKind() == CastKind.CK_BooleanToSignedIntegral;
        
        // Assume that non-integer casts can span the full range of the type.
        if (!isIntegerCast) {
          return OutputTypeRange;
        }
        
        IntRange SubRange = GetExprRange(C, CE.getSubExpr$Const(), 
            std.min_uint(MaxWidth, OutputTypeRange.Width));
        
        // Bail out if the subexpr's range is as wide as the cast type.
        if ($greatereq_uint(SubRange.Width, OutputTypeRange.Width)) {
          return OutputTypeRange;
        }
        
        // Otherwise, we take the smaller width, and we're non-negative if
        // either the output type or the subexpr is.
        return new IntRange(SubRange.Width, 
            SubRange.NonNegative || OutputTypeRange.NonNegative);
      }
    }
    {
      
      /*const*/ ConditionalOperator /*P*/ CO = dyn_cast_ConditionalOperator(E);
      if ((CO != null)) {
        // If we can fold the condition, just take that operand.
        bool$ref CondResult = create_bool$ref();
        if (CO.getCond().EvaluateAsBooleanCondition(CondResult, C)) {
          return GetExprRange(C, CondResult.$deref() ? CO.getTrueExpr() : CO.getFalseExpr(), 
              MaxWidth);
        }
        
        // Otherwise, conservatively merge.
        IntRange L = GetExprRange(C, CO.getTrueExpr(), MaxWidth);
        IntRange R = GetExprRange(C, CO.getFalseExpr(), MaxWidth);
        return IntRange.join(new IntRange(L), new IntRange(R));
      }
    }
    {
      
      /*const*/ BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(E);
      if ((BO != null)) {
        switch (BO.getOpcode()) {
         case BO_LAnd:
         case BO_LOr:
         case BO_LT:
         case BO_GT:
         case BO_LE:
         case BO_GE:
         case BO_EQ:
         case BO_NE:
          
          // Boolean-valued operations are single-bit and positive.
          return IntRange.forBoolType();
         case BO_MulAssign:
         case BO_DivAssign:
         case BO_RemAssign:
         case BO_AddAssign:
         case BO_SubAssign:
         case BO_XorAssign:
         case BO_OrAssign:
          // TODO: bitfields?
          return IntRange.forValueOfType(C, GetExprType(E));
         case BO_Assign:
          // TODO: bitfields?
          return GetExprRange(C, BO.getRHS(), MaxWidth);
         case BO_PtrMemD:
         case BO_PtrMemI:
          
          // Operations with opaque sources are black-listed.
          return IntRange.forValueOfType(C, GetExprType(E));
         case BO_And:
         case BO_AndAssign:
          
          // Bitwise-and uses the *infinum* of the two source ranges.
          return IntRange.meet(GetExprRange(C, BO.getLHS(), MaxWidth), 
              GetExprRange(C, BO.getRHS(), MaxWidth));
         case BO_Shl:
          {
            // ...except that we want to treat '1 << (blah)' as logically
            // positive.  It's an important idiom.
            IntegerLiteral /*P*/ I = dyn_cast_IntegerLiteral(BO.getLHS().IgnoreParenCasts());
            if ((I != null)) {
              if (I.getValue().$eq(1)) {
                IntRange R = IntRange.forValueOfType(C, GetExprType(E));
                return new IntRange(R.Width, /*NonNegative*/ true);
              }
            }
          }
         case BO_ShlAssign:
          // fallthrough
          return IntRange.forValueOfType(C, GetExprType(E));
         case BO_Shr:
         case BO_ShrAssign:
          {
            IntRange L = GetExprRange(C, BO.getLHS(), MaxWidth);
            
            // If the shift amount is a positive constant, drop the width by
            // that much.
            APSInt shift/*J*/= new APSInt();
            if (BO.getRHS().isIntegerConstantExpr(shift, C)
               && shift.isNonNegative()) {
              /*uint*/int zext = $ulong2uint(shift.getZExtValue());
              if ($greatereq_uint(zext, L.Width)) {
                L.Width = (L.NonNegative ? 0 : 1);
              } else {
                L.Width -= zext;
              }
            }
            
            return L;
          }
         case BO_Comma:
          
          // Comma acts as its right operand.
          return GetExprRange(C, BO.getRHS(), MaxWidth);
         case BO_Sub:
          
          // Black-list pointer subtractions.
          if (BO.getLHS().getType().$arrow().isPointerType()) {
            return IntRange.forValueOfType(C, GetExprType(E));
          }
          break;
         case BO_Div:
          {
            // Don't 'pre-truncate' the operands.
            /*uint*/int opWidth = C.getIntWidth(GetExprType(E));
            IntRange L = GetExprRange(C, BO.getLHS(), opWidth);
            
            // If the divisor is constant, use that.
            APSInt divisor/*J*/= new APSInt();
            if (BO.getRHS().isIntegerConstantExpr(divisor, C)) {
              /*uint*/int log2 = divisor.logBase2(); // floor(log_2(divisor))
              if ($greatereq_uint(log2, L.Width)) {
                L.Width = (L.NonNegative ? 0 : 1);
              } else {
                L.Width = std.min_uint(L.Width - log2, MaxWidth);
              }
              return L;
            }
            
            // Otherwise, just use the LHS's width.
            IntRange R = GetExprRange(C, BO.getRHS(), opWidth);
            return new IntRange(L.Width, L.NonNegative && R.NonNegative);
          }
         case BO_Rem:
          {
            // Don't 'pre-truncate' the operands.
            /*uint*/int opWidth = C.getIntWidth(GetExprType(E));
            IntRange L = GetExprRange(C, BO.getLHS(), opWidth);
            IntRange R = GetExprRange(C, BO.getRHS(), opWidth);
            
            IntRange meet = IntRange.meet(new IntRange(L), new IntRange(R));
            meet.Width = std.min_uint(meet.Width, MaxWidth);
            return meet;
          }
         case BO_Mul:
         case BO_Add:
         case BO_Xor:
         case BO_Or:
          
          // The default behavior is okay for these.
          break;
        }
        
        // The default case is to treat the operation as if it were closed
        // on the narrowest type that encompasses both operands.
        IntRange L = GetExprRange(C, BO.getLHS(), MaxWidth);
        IntRange R = GetExprRange(C, BO.getRHS(), MaxWidth);
        return IntRange.join(new IntRange(L), new IntRange(R));
      }
    }
    {
      
      /*const*/ UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(E);
      if ((UO != null)) {
        switch (UO.getOpcode()) {
         case UO_LNot:
          // Boolean-valued operations are white-listed.
          return IntRange.forBoolType();
         case UO_Deref:
         case UO_AddrOf: // should be impossible
          return IntRange.forValueOfType(C, GetExprType(E));
         default:
          return GetExprRange(C, UO.getSubExpr(), MaxWidth);
        }
      }
    }
    {
      
      /*const*/ OpaqueValueExpr /*P*/ OVE = dyn_cast_OpaqueValueExpr(E);
      if ((OVE != null)) {
        return GetExprRange(C, OVE.getSourceExpr(), MaxWidth);
      }
    }
    {
      
      /*const*/ FieldDecl /*P*/ BitField = E.getSourceBitField$Const();
      if ((BitField != null)) {
        return new IntRange(BitField.getBitWidthValue(C), 
            BitField.getType().$arrow().isUnsignedIntegerOrEnumerationType());
      }
    }
    
    return IntRange.forValueOfType(C, GetExprType(E));
  } finally {
    if (result != null) { result.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetExprRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7348,
 FQN="(anonymous namespace)::GetExprRange", NM="_ZN12_GLOBAL__N_112GetExprRangeERN5clang10ASTContextEPKNS0_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_112GetExprRangeERN5clang10ASTContextEPKNS0_4ExprE")
//</editor-fold>
public static IntRange GetExprRange(final ASTContext /*&*/ C, /*const*/ Expr /*P*/ E) {
  return GetExprRange(C, E, C.getIntWidth(GetExprType(E)));
}


/// Checks whether the given value, which currently has the given
/// source semantics, has the same value when coerced through the
/// target semantics.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IsSameFloatAfterCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7355,
 FQN="(anonymous namespace)::IsSameFloatAfterCast", NM="_ZN12_GLOBAL__N_120IsSameFloatAfterCastERKN4llvm7APFloatERKNS0_12fltSemanticsES6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_120IsSameFloatAfterCastERKN4llvm7APFloatERKNS0_12fltSemanticsES6_")
//</editor-fold>
public static boolean IsSameFloatAfterCast(final /*const*/ APFloat /*&*/ value, 
                    final /*const*/ fltSemantics /*&*/ Src, 
                    final /*const*/ fltSemantics /*&*/ Tgt) {
  APFloat truncated = new APFloat(value);
  
  bool$ptr ignored = create_bool$ptr();
  truncated.convert(Src, APFloat.roundingMode.rmNearestTiesToEven, ignored);
  truncated.convert(Tgt, APFloat.roundingMode.rmNearestTiesToEven, ignored);
  
  return truncated.bitwiseIsEqual(value);
}


/// Checks whether the given value, which currently has the given
/// source semantics, has the same value when coerced through the
/// target semantics.
///
/// The value might be a vector of floats (or a complex number).
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IsSameFloatAfterCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7372,
 FQN="(anonymous namespace)::IsSameFloatAfterCast", NM="_ZN12_GLOBAL__N_120IsSameFloatAfterCastERKN5clang7APValueERKN4llvm12fltSemanticsES7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_120IsSameFloatAfterCastERKN5clang7APValueERKN4llvm12fltSemanticsES7_")
//</editor-fold>
public static boolean IsSameFloatAfterCast(final /*const*/ APValue /*&*/ value, 
                    final /*const*/ fltSemantics /*&*/ Src, 
                    final /*const*/ fltSemantics /*&*/ Tgt) {
  if (value.isFloat()) {
    return IsSameFloatAfterCast(value.getFloat$Const(), Src, Tgt);
  }
  if (value.isVector()) {
    for (/*uint*/int i = 0, e = value.getVectorLength(); i != e; ++i)  {
      if (!IsSameFloatAfterCast(value.getVectorElt$Const(i), Src, Tgt)) {
        return false;
      }
    }
    return true;
  }
  assert (value.isComplexFloat());
  return (IsSameFloatAfterCast(value.getComplexFloatReal$Const(), Src, Tgt)
     && IsSameFloatAfterCast(value.getComplexFloatImag$Const(), Src, Tgt));
}


/// AnalyzeImplicitConversions - Find and report any interesting
/// implicit conversions in the given expression.  There are a couple
/// of competing diagnostics here, -Wconversion and -Wsign-compare.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalyzeImplicitConversions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8494,
 FQN="(anonymous namespace)::AnalyzeImplicitConversions", NM="_ZN12_GLOBAL__N_126AnalyzeImplicitConversionsERN5clang4SemaEPNS0_4ExprENS0_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_126AnalyzeImplicitConversionsERN5clang4SemaEPNS0_4ExprENS0_14SourceLocationE")
//</editor-fold>
public static void AnalyzeImplicitConversions(final Sema /*&*/ S, Expr /*P*/ OrigE, SourceLocation CC) {
  QualType T = OrigE.getType();
  Expr /*P*/ E = OrigE.IgnoreParenImpCasts();
  if (E.isTypeDependent() || E.isValueDependent()) {
    return;
  }
  
  // For conditional operators, we analyze the arguments as if they
  // were being fed directly into the output.
  if (isa_ConditionalOperator(E)) {
    ConditionalOperator /*P*/ CO = cast_ConditionalOperator(E);
    CheckConditionalOperator(S, CO, new SourceLocation(CC), new QualType(T));
    return;
  }
  {
    
    // Check implicit argument conversions for function calls.
    CallExpr /*P*/ Call = dyn_cast_CallExpr(E);
    if ((Call != null)) {
      CheckImplicitArgumentConversions(S, Call, new SourceLocation(CC));
    }
  }
  
  // Go ahead and check any implicit conversions we might have skipped.
  // The non-canonical typecheck is just an optimization;
  // CheckImplicitConversion will filter out dead implicit conversions.
  if ($noteq_QualType$C(E.getType(), T)) {
    CheckImplicitConversion(S, E, new QualType(T), new SourceLocation(CC));
  }
  {
    
    // Now continue drilling into this expression.
    PseudoObjectExpr /*P*/ POE = dyn_cast_PseudoObjectExpr(E);
    if ((POE != null)) {
      // The bound subexpressions in a PseudoObjectExpr are not reachable
      // as transitive children.
      // FIXME: Use a more uniform representation for this.
      for (Expr /*P*/ SE : POE.semantics())  {
        {
          OpaqueValueExpr /*P*/ OVE = dyn_cast_OpaqueValueExpr(SE);
          if ((OVE != null)) {
            AnalyzeImplicitConversions(S, OVE.getSourceExpr(), new SourceLocation(CC));
          }
        }
      }
    }
  }
  
  // Skip past explicit casts.
  if (isa_ExplicitCastExpr(E)) {
    E = cast_ExplicitCastExpr(E).getSubExpr().IgnoreParenImpCasts();
    AnalyzeImplicitConversions(S, E, new SourceLocation(CC));
    return;
  }
  {
    
    BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(E);
    if ((BO != null)) {
      // Do a somewhat different check with comparison operators.
      if (BO.isComparisonOp()) {
        AnalyzeComparison(S, BO);
        return;
      }
      
      // And with simple assignments.
      if (BO.getOpcode() == BinaryOperatorKind.BO_Assign) {
        AnalyzeAssignment(S, BO);
        return;
      }
    }
  }
  
  // These break the otherwise-useful invariant below.  Fortunately,
  // we don't really need to recurse into them, because any internal
  // expressions should have been analyzed already when they were
  // built into statements.
  if (isa_StmtExpr(E)) {
    return;
  }
  
  // Don't descend into unevaluated contexts.
  if (isa_UnaryExprOrTypeTraitExpr(E)) {
    return;
  }
  
  // Now just recurse over the expression's children.
  CC.$assignMove(E.getExprLoc());
  BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(E);
  boolean IsLogicalAndOperator = (BO != null) && BO.getOpcode() == BinaryOperatorKind.BO_LAnd;
  for (Stmt /*P*/ SubStmt : E.children()) {
    Expr /*P*/ ChildExpr = dyn_cast_or_null_Expr(SubStmt);
    if (!(ChildExpr != null)) {
      continue;
    }
    if (IsLogicalAndOperator
       && isa_StringLiteral(ChildExpr.IgnoreParenImpCasts())) {
      // Ignore checking string literals that are in logical and operators.
      // This is a common pattern for asserts.
      continue;
    }
    AnalyzeImplicitConversions(S, ChildExpr, new SourceLocation(CC));
  }
  if ((BO != null) && BO.isLogicalOp()) {
    Expr /*P*/ SubExpr = BO.getLHS().IgnoreParenImpCasts();
    if (!IsLogicalAndOperator || !isa_StringLiteral(SubExpr)) {
      /*::*/CheckBoolLikeConversion(S, SubExpr, BO.getExprLoc());
    }
    
    SubExpr = BO.getRHS().IgnoreParenImpCasts();
    if (!IsLogicalAndOperator || !isa_StringLiteral(SubExpr)) {
      /*::*/CheckBoolLikeConversion(S, SubExpr, BO.getExprLoc());
    }
  }
  {
    
    /*const*/ UnaryOperator /*P*/ U = dyn_cast_UnaryOperator(E);
    if ((U != null)) {
      if (U.getOpcode() == UnaryOperatorKind.UO_LNot) {
        /*::*/CheckBoolLikeConversion(S, U.getSubExpr(), new SourceLocation(CC));
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IsZero">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7392,
 FQN="(anonymous namespace)::IsZero", NM="_ZN12_GLOBAL__N_16IsZeroERN5clang4SemaEPNS0_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_16IsZeroERN5clang4SemaEPNS0_4ExprE")
//</editor-fold>
public static boolean IsZero(final Sema /*&*/ S, Expr /*P*/ E) {
  {
    // Suppress cases where we are comparing against an enum constant.
    /*const*/ DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(E.IgnoreParenImpCasts());
    if ((DR != null)) {
      if (isa_EnumConstantDecl(DR.getDecl$Const())) {
        return false;
      }
    }
  }
  
  // Suppress cases where the '0' value is expanded from a macro.
  if (E.getLocStart().isMacroID()) {
    return false;
  }
  
  APSInt Value/*J*/= new APSInt();
  return E.isIntegerConstantExpr(Value, S.Context) && Value.$eq(0);
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HasEnumType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7407,
 FQN="(anonymous namespace)::HasEnumType", NM="_ZN12_GLOBAL__N_111HasEnumTypeEPN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_111HasEnumTypeEPN5clang4ExprE")
//</editor-fold>
public static boolean HasEnumType(Expr /*P*/ E) {
  {
    // Strip off implicit integral promotions.
    ImplicitCastExpr /*P*/ ICE;
    while (((/*P*/ ICE = dyn_cast_ImplicitCastExpr(E)) != null)) {
      if (ICE.getCastKind() != CastKind.CK_IntegralCast
         && ICE.getCastKind() != CastKind.CK_NoOp) {
        break;
      }
      E = ICE.getSubExpr();
    }
  }
  
  return E.getType().$arrow().isEnumeralType();
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckTrivialUnsignedComparison">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7419,
 FQN="(anonymous namespace)::CheckTrivialUnsignedComparison", NM="_ZN12_GLOBAL__N_130CheckTrivialUnsignedComparisonERN5clang4SemaEPNS0_14BinaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_130CheckTrivialUnsignedComparisonERN5clang4SemaEPNS0_14BinaryOperatorE")
//</editor-fold>
public static void CheckTrivialUnsignedComparison(final Sema /*&*/ S, BinaryOperator /*P*/ E) {
  // Disable warning in template instantiations.
  if (!S.ActiveTemplateInstantiations.empty()) {
    return;
  }
  
  BinaryOperatorKind op = E.getOpcode();
  if (E.isValueDependent()) {
    return;
  }
  if (op == BinaryOperatorKind.BO_LT && IsZero(S, E.getRHS())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getOperatorLoc(), diag.warn_lunsigned_always_true_comparison)), 
                          /*KEEP_STR*/"< 0"), /*KEEP_STR*/"false"), HasEnumType(E.getLHS())), 
              E.getLHS().getSourceRange()), E.getRHS().getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  } else if (op == BinaryOperatorKind.BO_GE && IsZero(S, E.getRHS())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getOperatorLoc(), diag.warn_lunsigned_always_true_comparison)), 
                          /*KEEP_STR*/">= 0"), /*KEEP_STR*/"true"), HasEnumType(E.getLHS())), 
              E.getLHS().getSourceRange()), E.getRHS().getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  } else if (op == BinaryOperatorKind.BO_GT && IsZero(S, E.getLHS())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getOperatorLoc(), diag.warn_runsigned_always_true_comparison)), 
                          /*KEEP_STR*/"0 >"), /*KEEP_STR*/"false"), HasEnumType(E.getRHS())), 
              E.getLHS().getSourceRange()), E.getRHS().getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  } else if (op == BinaryOperatorKind.BO_LE && IsZero(S, E.getLHS())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getOperatorLoc(), diag.warn_runsigned_always_true_comparison)), 
                          /*KEEP_STR*/"0 <="), /*KEEP_STR*/"true"), HasEnumType(E.getRHS())), 
              E.getLHS().getSourceRange()), E.getRHS().getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DiagnoseOutOfRangeComparison">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7447,
 FQN="(anonymous namespace)::DiagnoseOutOfRangeComparison", NM="_ZN12_GLOBAL__N_128DiagnoseOutOfRangeComparisonERN5clang4SemaEPNS0_14BinaryOperatorEPNS0_4ExprES6_RKN4llvm6APSIntEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_128DiagnoseOutOfRangeComparisonERN5clang4SemaEPNS0_14BinaryOperatorEPNS0_4ExprES6_RKN4llvm6APSIntEb")
//</editor-fold>
public static void DiagnoseOutOfRangeComparison(final Sema /*&*/ S, BinaryOperator /*P*/ E, Expr /*P*/ Constant, 
                            Expr /*P*/ Other, final /*const*/ APSInt /*&*/ Value, 
                            boolean RhsConstant) {
  raw_svector_ostream OS = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Disable warning in template instantiations.
    if (!S.ActiveTemplateInstantiations.empty()) {
      return;
    }
    
    // TODO: Investigate using GetExprRange() to get tighter bounds
    // on the bit ranges.
    QualType OtherT = Other.getType();
    {
      /*const*/ AtomicType /*P*/ AT = OtherT.$arrow().getAs(AtomicType.class);
      if ((AT != null)) {
        OtherT.$assignMove(AT.getValueType());
      }
    }
    IntRange OtherRange = IntRange.forValueOfType(S.Context, new QualType(OtherT));
    /*uint*/int OtherWidth = OtherRange.Width;
    
    boolean OtherIsBooleanType = Other.isKnownToHaveBooleanValue();
    
    // 0 values are handled later by CheckTrivialUnsignedComparison().
    if ((Value.$eq(0)) && (!OtherIsBooleanType)) {
      return;
    }
    
    BinaryOperatorKind op = E.getOpcode();
    boolean IsTrue = true;
    
    // Used for diagnostic printout.
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      final /*uint*/int LiteralConstant = 0;
      final /*uint*/int CXXBoolLiteralTrue = LiteralConstant + 1;
      final /*uint*/int CXXBoolLiteralFalse = CXXBoolLiteralTrue + 1;
    /*}*//*Unnamed enum*//*uint*/int LiteralOrBoolConstant = LiteralConstant;
    if (!OtherIsBooleanType) {
      QualType ConstantT = Constant.getType();
      QualType CommonT = E.getLHS().getType();
      if (S.Context.hasSameUnqualifiedType(new QualType(OtherT), new QualType(ConstantT))) {
        return;
      }
      assert ((OtherT.$arrow().isIntegerType() && ConstantT.$arrow().isIntegerType())) : "comparison with non-integer type";
      
      boolean ConstantSigned = ConstantT.$arrow().isSignedIntegerType();
      boolean CommonSigned = CommonT.$arrow().isSignedIntegerType();
      
      boolean EqualityOnly = false;
      if (CommonSigned) {
        // The common type is signed, therefore no signed to unsigned conversion.
        if (!OtherRange.NonNegative) {
          // Check that the constant is representable in type OtherT.
          if (ConstantSigned) {
            if ($greatereq_uint(OtherWidth, Value.getMinSignedBits())) {
              return;
            }
          } else { // !ConstantSigned
            if ($greatereq_uint(OtherWidth, Value.getActiveBits() + 1)) {
              return;
            }
          }
        } else { // !OtherSigned
// Check that the constant is representable in type OtherT.
// Negative values are out of range.
          if (ConstantSigned) {
            if (Value.isNonNegative() && $greatereq_uint(OtherWidth, Value.getActiveBits())) {
              return;
            }
          } else { // !ConstantSigned
            if ($greatereq_uint(OtherWidth, Value.getActiveBits())) {
              return;
            }
          }
        }
      } else { // !CommonSigned
        if (OtherRange.NonNegative) {
          if ($greatereq_uint(OtherWidth, Value.getActiveBits())) {
            return;
          }
        } else { // OtherSigned
          assert (!ConstantSigned) : "Two signed types converted to unsigned types.";
          // Check to see if the constant is representable in OtherT.
          if ($greater_uint(OtherWidth, Value.getActiveBits())) {
            return;
          }
          // Check to see if the constant is equivalent to a negative value
          // cast to CommonT.
          if (S.Context.getIntWidth(new QualType(ConstantT))
             == S.Context.getIntWidth(new QualType(CommonT))
             && Value.isNegative() && $lesseq_uint(Value.getMinSignedBits(), OtherWidth)) {
            return;
          }
          // The constant value rests between values that OtherT can represent
          // after conversion.  Relational comparison still works, but equality
          // comparisons will be tautological.
          EqualityOnly = true;
        }
      }
      
      boolean PositiveConstant = !ConstantSigned || Value.isNonNegative();
      if (op == BinaryOperatorKind.BO_EQ || op == BinaryOperatorKind.BO_NE) {
        IsTrue = op == BinaryOperatorKind.BO_NE;
      } else if (EqualityOnly) {
        return;
      } else if (RhsConstant) {
        if (op == BinaryOperatorKind.BO_GT || op == BinaryOperatorKind.BO_GE) {
          IsTrue = !PositiveConstant;
        } else { // op == BO_LT || op == BO_LE
          IsTrue = PositiveConstant;
        }
      } else {
        if (op == BinaryOperatorKind.BO_LT || op == BinaryOperatorKind.BO_LE) {
          IsTrue = !PositiveConstant;
        } else { // op == BO_GT || op == BO_GE
          IsTrue = PositiveConstant;
        }
      }
    } else {
      // Other isKnownToHaveBooleanValue
      final class/*enum*/ CompareBoolWithConstantResult {
        private static final /*uint*/int AFals = 0;
        private static final /*uint*/int ATrue = AFals + 1;
        private static final /*uint*/int Unkwn = ATrue + 1;
      };
      final class/*enum*/ ConstantValue {
        private static final /*uint*/int LT_Zero = 0;
        private static final /*uint*/int Zero = LT_Zero + 1;
        private static final /*uint*/int One = Zero + 1;
        private static final /*uint*/int GT_One = One + 1;
        private static final /*uint*/int SizeOfConstVal = GT_One + 1;
      };
      final class/*enum*/ ConstantSide {
        private static final /*uint*/int Lhs = 0;
        private static final /*uint*/int Rhs = Lhs + 1;
        private static final /*uint*/int SizeOfConstSides = Rhs + 1;
      };
      
      //<editor-fold defaultstate="collapsed" desc="LinkedConditions">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7560,
       FQN="LinkedConditions", NM="_ZZN12_GLOBAL__N_128DiagnoseOutOfRangeComparisonERN5clang4SemaEPNS0_14BinaryOperatorEPNS0_4ExprES6_RKN4llvm6APSIntEbE16LinkedConditions",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZZN12_GLOBAL__N_128DiagnoseOutOfRangeComparisonERN5clang4SemaEPNS0_14BinaryOperatorEPNS0_4ExprES6_RKN4llvm6APSIntEbE16LinkedConditions")
      //</editor-fold>
       class/*struct*/ LinkedConditions {
        // Constant on LHS.              | Constant on RHS.              |
        // LT_Zero| Zero  | One   |GT_One| LT_Zero| Zero  | One   |GT_One|
        public int BO_LT_OP[/*2*/][/*4*/] = {{CompareBoolWithConstantResult.ATrue, CompareBoolWithConstantResult.Unkwn, CompareBoolWithConstantResult.AFals, CompareBoolWithConstantResult.AFals}, {CompareBoolWithConstantResult.AFals, CompareBoolWithConstantResult.AFals, CompareBoolWithConstantResult.Unkwn, CompareBoolWithConstantResult.ATrue}};
        public int BO_GT_OP[/*2*/][/*4*/] = {{CompareBoolWithConstantResult.AFals, CompareBoolWithConstantResult.AFals, CompareBoolWithConstantResult.Unkwn, CompareBoolWithConstantResult.ATrue}, {CompareBoolWithConstantResult.ATrue, CompareBoolWithConstantResult.Unkwn, CompareBoolWithConstantResult.AFals, CompareBoolWithConstantResult.AFals}};
        public int BO_LE_OP[/*2*/][/*4*/] = {{CompareBoolWithConstantResult.ATrue, CompareBoolWithConstantResult.ATrue, CompareBoolWithConstantResult.Unkwn, CompareBoolWithConstantResult.AFals}, {CompareBoolWithConstantResult.AFals, CompareBoolWithConstantResult.Unkwn, CompareBoolWithConstantResult.ATrue, CompareBoolWithConstantResult.ATrue}}; 
        public int BO_GE_OP[/*2*/][/*4*/] = {{CompareBoolWithConstantResult.AFals, CompareBoolWithConstantResult.Unkwn, CompareBoolWithConstantResult.ATrue, CompareBoolWithConstantResult.ATrue}, {CompareBoolWithConstantResult.ATrue, CompareBoolWithConstantResult.ATrue, CompareBoolWithConstantResult.Unkwn, CompareBoolWithConstantResult.AFals}}; 
        public int BO_EQ_OP[/*2*/][/*4*/] = {{CompareBoolWithConstantResult.AFals, CompareBoolWithConstantResult.Unkwn, CompareBoolWithConstantResult.Unkwn, CompareBoolWithConstantResult.AFals}, {CompareBoolWithConstantResult.AFals, CompareBoolWithConstantResult.Unkwn, CompareBoolWithConstantResult.Unkwn, CompareBoolWithConstantResult.AFals}}; 
        public int BO_NE_OP[/*2*/][/*4*/] = {{CompareBoolWithConstantResult.ATrue, CompareBoolWithConstantResult.Unkwn, CompareBoolWithConstantResult.Unkwn, CompareBoolWithConstantResult.ATrue}, {CompareBoolWithConstantResult.ATrue, CompareBoolWithConstantResult.Unkwn, CompareBoolWithConstantResult.Unkwn, CompareBoolWithConstantResult.ATrue}};
        
        @Override public String toString() {
          return "" + "BO_LT_OP=" + BO_LT_OP // NOI18N
                    + ", BO_GT_OP=" + BO_GT_OP // NOI18N
                    + ", BO_LE_OP=" + BO_LE_OP // NOI18N
                    + ", BO_GE_OP=" + BO_GE_OP // NOI18N
                    + ", BO_EQ_OP=" + BO_EQ_OP // NOI18N
                    + ", BO_NE_OP=" + BO_NE_OP; // NOI18N
        }
      }final/*static*/ /*const*/  LinkedConditions TruthTable = new LinkedConditions();
      
      boolean ConstantIsBoolLiteral = isa_CXXBoolLiteralExpr(Constant);
      
      /* ConstantValue*//*uint*/int ConstVal = ConstantValue.Zero;
      if (Value.isUnsigned() || Value.isNonNegative()) {
        if (Value.$eq(0)) {
          LiteralOrBoolConstant
             = ConstantIsBoolLiteral ? CXXBoolLiteralFalse : LiteralConstant;
          ConstVal = ConstantValue.Zero;
        } else if (Value.$eq(1)) {
          LiteralOrBoolConstant
             = ConstantIsBoolLiteral ? CXXBoolLiteralTrue : LiteralConstant;
          ConstVal = ConstantValue.One;
        } else {
          LiteralOrBoolConstant = LiteralConstant;
          ConstVal = ConstantValue.GT_One;
        }
      } else {
        ConstVal = ConstantValue.LT_Zero;
      }
      
      /*CompareBoolWithConstantResult*//*uint*/int CmpRes;
      switch (op) {
       case BO_LT:
        CmpRes = TruthTable.BO_LT_OP[RhsConstant?1:0][ConstVal];
        break;
       case BO_GT:
        CmpRes = TruthTable.BO_GT_OP[RhsConstant?1:0][ConstVal];
        break;
       case BO_LE:
        CmpRes = TruthTable.BO_LE_OP[RhsConstant?1:0][ConstVal];
        break;
       case BO_GE:
        CmpRes = TruthTable.BO_GE_OP[RhsConstant?1:0][ConstVal];
        break;
       case BO_EQ:
        CmpRes = TruthTable.BO_EQ_OP[RhsConstant?1:0][ConstVal];
        break;
       case BO_NE:
        CmpRes = TruthTable.BO_NE_OP[RhsConstant?1:0][ConstVal];
        break;
       default:
        CmpRes = CompareBoolWithConstantResult.Unkwn;
        break;
      }
      if (CmpRes == CompareBoolWithConstantResult.AFals) {
        IsTrue = false;
      } else if (CmpRes == CompareBoolWithConstantResult.ATrue) {
        IsTrue = true;
      } else {
        return;
      }
    }
    
    // If this is a comparison to an enum constant, include that
    // constant in the diagnostic.
    /*const*/ EnumConstantDecl /*P*/ ED = null;
    {
      /*const*/ DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(Constant);
      if ((DR != null)) {
        ED = dyn_cast_EnumConstantDecl(DR.getDecl$Const());
      }
    }
    
    SmallString/*64*/ PrettySourceValue/*J*/= new SmallString/*64*/(64);
    OS/*J*/= new raw_svector_ostream(PrettySourceValue);
    if ((ED != null)) {
      $out_raw_ostream_APSInt$C($out_raw_ostream_NamedDecl$C(OS.$out_char($$SGL_QUOTE), $Deref(ED)).$out(/*KEEP_STR*/"' ("), Value).$out(/*KEEP_STR*/$RPAREN);
    } else {
      $out_raw_ostream_APSInt$C(OS, Value);
    }
    
    $c$.clean(S.DiagRuntimeBehavior(E.getOperatorLoc(), E, 
        $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.warn_out_of_range_compare)), 
                                    OS.str()), LiteralOrBoolConstant), 
                            /*NO_COPY*/OtherT), ((OtherIsBooleanType && !OtherT.$arrow().isBooleanType()) ? 1 : 0)), (IsTrue ? 1 : 0)), 
                E.getLHS().getSourceRange()), E.getRHS().getSourceRange())));
  } finally {
    if (OS != null) { OS.$destroy(); }
    $c$.$destroy();
  }
}


/// Analyze the operands of the given comparison.  Implements the
/// fallback case from AnalyzeComparison.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalyzeImpConvsInComparison">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7657,
 FQN="(anonymous namespace)::AnalyzeImpConvsInComparison", NM="_ZN12_GLOBAL__N_127AnalyzeImpConvsInComparisonERN5clang4SemaEPNS0_14BinaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_127AnalyzeImpConvsInComparisonERN5clang4SemaEPNS0_14BinaryOperatorE")
//</editor-fold>
public static void AnalyzeImpConvsInComparison(final Sema /*&*/ S, BinaryOperator /*P*/ E) {
  AnalyzeImplicitConversions(S, E.getLHS(), E.getOperatorLoc());
  AnalyzeImplicitConversions(S, E.getRHS(), E.getOperatorLoc());
}


/// \brief Implements -Wsign-compare.
///
/// \param E the binary operator to check for warnings
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalyzeComparison">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7665,
 FQN="(anonymous namespace)::AnalyzeComparison", NM="_ZN12_GLOBAL__N_117AnalyzeComparisonERN5clang4SemaEPNS0_14BinaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_117AnalyzeComparisonERN5clang4SemaEPNS0_14BinaryOperatorE")
//</editor-fold>
public static void AnalyzeComparison(final Sema /*&*/ S, BinaryOperator /*P*/ E) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // The type the comparison is being performed in.
    QualType T = E.getLHS().getType();
    
    // Only analyze comparison operators where both sides have been converted to
    // the same type.
    if (!S.Context.hasSameUnqualifiedType(new QualType(T), E.getRHS().getType())) {
      AnalyzeImpConvsInComparison(S, E);
      return;
    }
    
    // Don't analyze value-dependent comparisons directly.
    if (E.isValueDependent()) {
      AnalyzeImpConvsInComparison(S, E);
      return;
    }
    
    Expr /*P*/ LHS = E.getLHS().IgnoreParenImpCasts();
    Expr /*P*/ RHS = E.getRHS().IgnoreParenImpCasts();
    
    boolean IsComparisonConstant = false;
    
    // Check whether an integer constant comparison results in a value
    // of 'true' or 'false'.
    if (T.$arrow().isIntegralType(S.Context)) {
      APSInt RHSValue/*J*/= new APSInt();
      boolean IsRHSIntegralLiteral = RHS.isIntegerConstantExpr(RHSValue, S.Context);
      APSInt LHSValue/*J*/= new APSInt();
      boolean IsLHSIntegralLiteral = LHS.isIntegerConstantExpr(LHSValue, S.Context);
      if (IsRHSIntegralLiteral && !IsLHSIntegralLiteral) {
        DiagnoseOutOfRangeComparison(S, E, RHS, LHS, RHSValue, true);
      } else if (!IsRHSIntegralLiteral && IsLHSIntegralLiteral) {
        DiagnoseOutOfRangeComparison(S, E, LHS, RHS, LHSValue, false);
      } else {
        IsComparisonConstant
           = (IsRHSIntegralLiteral && IsLHSIntegralLiteral);
      }
    } else if (!T.$arrow().hasUnsignedIntegerRepresentation()) {
      IsComparisonConstant = E.isIntegerConstantExpr(S.Context);
    }
    
    // We don't do anything special if this isn't an unsigned integral
    // comparison:  we're only interested in integral comparisons, and
    // signed comparisons only happen in cases we don't care to warn about.
    //
    // We also don't care about value-dependent expressions or expressions
    // whose result is a constant.
    if (!T.$arrow().hasUnsignedIntegerRepresentation() || IsComparisonConstant) {
      AnalyzeImpConvsInComparison(S, E);
      return;
    }
    
    // Check to see if one of the (unmodified) operands is of different
    // signedness.
    Expr /*P*/ signedOperand, /*P*/ unsignedOperand;
    if (LHS.getType().$arrow().hasSignedIntegerRepresentation()) {
      assert (!RHS.getType().$arrow().hasSignedIntegerRepresentation()) : "unsigned comparison between two signed integer expressions?";
      signedOperand = LHS;
      unsignedOperand = RHS;
    } else if (RHS.getType().$arrow().hasSignedIntegerRepresentation()) {
      signedOperand = RHS;
      unsignedOperand = LHS;
    } else {
      CheckTrivialUnsignedComparison(S, E);
      AnalyzeImpConvsInComparison(S, E);
      return;
    }
    
    // Otherwise, calculate the effective range of the signed operand.
    IntRange signedRange = GetExprRange(S.Context, signedOperand);
    
    // Go ahead and analyze implicit conversions in the operands.  Note
    // that we skip the implicit conversions on both sides.
    AnalyzeImplicitConversions(S, LHS, E.getOperatorLoc());
    AnalyzeImplicitConversions(S, RHS, E.getOperatorLoc());
    
    // If the signed range is non-negative, -Wsign-compare won't fire,
    // but we should still check for comparisons which are always true
    // or false.
    if (signedRange.NonNegative) {
      CheckTrivialUnsignedComparison(S, E);
      return;
    }
    
    // For (in)equality comparisons, if the unsigned operand is a
    // constant which cannot collide with a overflowed signed operand,
    // then reinterpreting the signed operand as unsigned will not
    // change the result of the comparison.
    if (E.isEqualityOp()) {
      /*uint*/int comparisonWidth = S.Context.getIntWidth(new QualType(T));
      IntRange unsignedRange = GetExprRange(S.Context, unsignedOperand);
      
      // We should never be unable to prove that the unsigned operand is
      // non-negative.
      assert (unsignedRange.NonNegative) : "unsigned range includes negative?";
      if ($less_uint(unsignedRange.Width, comparisonWidth)) {
        return;
      }
    }
    
    $c$.clean(S.DiagRuntimeBehavior(E.getOperatorLoc(), E, 
        $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_QualType($c$.track(S.PDiag(diag.warn_mixed_sign_comparison)), 
                        LHS.getType()), RHS.getType()), 
                LHS.getSourceRange()), RHS.getSourceRange())));
  } finally {
    $c$.$destroy();
  }
}


/// Analyzes an attempt to assign the given value to a bitfield.
///
/// Returns true if there was something fishy about the attempt.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalyzeBitFieldAssignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7766,
 FQN="(anonymous namespace)::AnalyzeBitFieldAssignment", NM="_ZN12_GLOBAL__N_125AnalyzeBitFieldAssignmentERN5clang4SemaEPNS0_9FieldDeclEPNS0_4ExprENS0_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_125AnalyzeBitFieldAssignmentERN5clang4SemaEPNS0_9FieldDeclEPNS0_4ExprENS0_14SourceLocationE")
//</editor-fold>
public static boolean AnalyzeBitFieldAssignment(final Sema /*&*/ S, FieldDecl /*P*/ Bitfield, Expr /*P*/ Init, 
                         SourceLocation InitLoc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert (Bitfield.isBitField());
    if (Bitfield.isInvalidDecl()) {
      return false;
    }
    
    // White-list bool bitfields.
    if (Bitfield.getType().$arrow().isBooleanType()) {
      return false;
    }
    
    // Ignore value- or type-dependent expressions.
    if (Bitfield.getBitWidth().isValueDependent()
       || Bitfield.getBitWidth().isTypeDependent()
       || Init.isValueDependent()
       || Init.isTypeDependent()) {
      return false;
    }
    
    Expr /*P*/ OriginalInit = Init.IgnoreParenImpCasts();
    
    APSInt Value/*J*/= new APSInt();
    if (!OriginalInit.EvaluateAsInt(Value, S.Context, Expr.SideEffectsKind.SE_AllowSideEffects)) {
      return false;
    }
    
    /*uint*/int OriginalWidth = Value.getBitWidth();
    /*uint*/int FieldWidth = Bitfield.getBitWidthValue(S.Context);
    if (Value.isSigned() && Value.isNegative()) {
      {
        UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(OriginalInit);
        if ((UO != null)) {
          if (UO.getOpcode() == UnaryOperatorKind.UO_Minus) {
            if (isa_IntegerLiteral(UO.getSubExpr())) {
              OriginalWidth = Value.getMinSignedBits();
            }
          }
        }
      }
    }
    if ($lesseq_uint(OriginalWidth, FieldWidth)) {
      return false;
    }
    
    // Compute the value which the bitfield will contain.
    APSInt TruncatedValue = Value.trunc(FieldWidth);
    TruncatedValue.setIsSigned(Bitfield.getType().$arrow().isSignedIntegerType());
    
    // Check whether the stored value is equal to the original value.
    TruncatedValue.$assignMove(TruncatedValue.extend(OriginalWidth));
    if (APSInt.isSameValue(Value, TruncatedValue)) {
      return false;
    }
    
    // Special-case bitfields of width 1: booleans are naturally 0/1, and
    // therefore don't strictly fit into a signed bitfield of width 1.
    if (FieldWidth == 1 && Value.$eq(1)) {
      return false;
    }
    
    std.string PrettyValue = Value.__toString(10);
    std.string PrettyTrunc = TruncatedValue.__toString(10);
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(InitLoc), diag.warn_impcast_bitfield_precision_constant)), 
                    PrettyValue), PrettyTrunc), OriginalInit.getType()), 
        Init.getSourceRange()));
    
    return true;
  } finally {
    $c$.$destroy();
  }
}


/// Analyze the given simple or compound assignment for warning-worthy
/// operations.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AnalyzeAssignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7827,
 FQN="(anonymous namespace)::AnalyzeAssignment", NM="_ZN12_GLOBAL__N_117AnalyzeAssignmentERN5clang4SemaEPNS0_14BinaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_117AnalyzeAssignmentERN5clang4SemaEPNS0_14BinaryOperatorE")
//</editor-fold>
public static void AnalyzeAssignment(final Sema /*&*/ S, BinaryOperator /*P*/ E) {
  // Just recurse on the LHS.
  AnalyzeImplicitConversions(S, E.getLHS(), E.getOperatorLoc());
  {
    
    // We want to recurse on the RHS as normal unless we're assigning to
    // a bitfield.
    FieldDecl /*P*/ Bitfield = E.getLHS().getSourceBitField();
    if ((Bitfield != null)) {
      if (AnalyzeBitFieldAssignment(S, Bitfield, E.getRHS(), 
          E.getOperatorLoc())) {
        // Recurse, ignoring any implicit conversions on the RHS.
        AnalyzeImplicitConversions(S, E.getRHS().IgnoreParenImpCasts(), 
            E.getOperatorLoc());
        return;
      }
    }
  }
  
  AnalyzeImplicitConversions(S, E.getRHS(), E.getOperatorLoc());
}


/// Diagnose an implicit cast;  purely a helper for CheckImplicitConversion.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DiagnoseImpCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7846,
 FQN="(anonymous namespace)::DiagnoseImpCast", NM="_ZN12_GLOBAL__N_115DiagnoseImpCastERN5clang4SemaEPNS0_4ExprENS0_8QualTypeES5_NS0_14SourceLocationEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115DiagnoseImpCastERN5clang4SemaEPNS0_4ExprENS0_8QualTypeES5_NS0_14SourceLocationEjb")
//</editor-fold>
public static void DiagnoseImpCast(final Sema /*&*/ S, Expr /*P*/ E, QualType SourceType, QualType T, 
               SourceLocation CContext, /*uint*/int diag) {
  DiagnoseImpCast(S, E, SourceType, T, 
               CContext, diag, 
               false);
}
public static void DiagnoseImpCast(final Sema /*&*/ S, Expr /*P*/ E, QualType SourceType, QualType T, 
               SourceLocation CContext, /*uint*/int diag, 
               boolean pruneControlFlow/*= false*/) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (pruneControlFlow) {
      $c$.clean(S.DiagRuntimeBehavior(E.getExprLoc(), E, 
          $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_QualType($c$.track(S.PDiag(diag)), 
                          /*NO_COPY*/SourceType), /*NO_COPY*/T), E.getSourceRange()), 
              new SourceRange(/*NO_COPY*/CContext))));
      return;
    }
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getExprLoc(), diag)), 
                    SourceType), T), E.getSourceRange()), new SourceRange(/*NO_COPY*/CContext)));
  } finally {
    $c$.$destroy();
  }
}


/// Diagnose an implicit cast;  purely a helper for CheckImplicitConversion.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DiagnoseImpCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7861,
 FQN="(anonymous namespace)::DiagnoseImpCast", NM="_ZN12_GLOBAL__N_115DiagnoseImpCastERN5clang4SemaEPNS0_4ExprENS0_8QualTypeENS0_14SourceLocationEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115DiagnoseImpCastERN5clang4SemaEPNS0_4ExprENS0_8QualTypeENS0_14SourceLocationEjb")
//</editor-fold>
public static void DiagnoseImpCast(final Sema /*&*/ S, Expr /*P*/ E, QualType T, SourceLocation CContext, 
               /*uint*/int diag) {
  DiagnoseImpCast(S, E, T, CContext, 
               diag, false);
}
public static void DiagnoseImpCast(final Sema /*&*/ S, Expr /*P*/ E, QualType T, SourceLocation CContext, 
               /*uint*/int diag, boolean pruneControlFlow/*= false*/) {
  DiagnoseImpCast(S, E, E.getType(), new QualType(T), new SourceLocation(CContext), diag, pruneControlFlow);
}


/// Diagnose an implicit cast from a floating point value to an integer value.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DiagnoseFloatingImpCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7868,
 FQN="(anonymous namespace)::DiagnoseFloatingImpCast", NM="_ZN12_GLOBAL__N_123DiagnoseFloatingImpCastERN5clang4SemaEPNS0_4ExprENS0_8QualTypeENS0_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_123DiagnoseFloatingImpCastERN5clang4SemaEPNS0_4ExprENS0_8QualTypeENS0_14SourceLocationE")
//</editor-fold>
public static void DiagnoseFloatingImpCast(final Sema /*&*/ S, Expr /*P*/ E, QualType T, 
                       SourceLocation CContext) {
  APFloat Value = null;
  try {
    /*const*/boolean IsBool = T.$arrow().isSpecificBuiltinType(BuiltinType.Kind.Bool.getValue());
    /*const*/boolean PruneWarnings = !S.ActiveTemplateInstantiations.empty();
    
    Expr /*P*/ InnerE = E.IgnoreParenImpCasts();
    {
      // We also want to warn on, e.g., "int i = -1.234"
      UnaryOperator /*P*/ UOp = dyn_cast_UnaryOperator(InnerE);
      if ((UOp != null)) {
        if (UOp.getOpcode() == UnaryOperatorKind.UO_Minus || UOp.getOpcode() == UnaryOperatorKind.UO_Plus) {
          InnerE = UOp.getSubExpr().IgnoreParenImpCasts();
        }
      }
    }
    
    /*const*/boolean IsLiteral = isa_FloatingLiteral(E) || isa_FloatingLiteral(InnerE);
    
    Value/*J*/= new APFloat(0.);
    boolean IsConstant = E.EvaluateAsFloat(Value, S.Context, Expr.SideEffectsKind.SE_AllowSideEffects);
    if (!IsConstant) {
      DiagnoseImpCast(S, E, new QualType(T), new SourceLocation(CContext), 
          diag.warn_impcast_float_integer, PruneWarnings);
      return;
    }
    
    bool$ptr isExact = create_bool$ptr(false);
    
    APSInt IntegerValue/*J*/= new APSInt(S.Context.getIntWidth(new QualType(T)), 
        T.$arrow().hasUnsignedIntegerRepresentation());
    if (Value.convertToInteger(IntegerValue, APFloat.roundingMode.rmTowardZero, 
        isExact) == APFloat.opStatus.opOK
       && isExact.$star()) {
      if (IsLiteral) {
        return;
      }
      DiagnoseImpCast(S, E, new QualType(T), new SourceLocation(CContext), diag.warn_impcast_float_integer, 
          PruneWarnings);
      return;
    }
    
    /*uint*/int DiagID = 0;
    if (IsLiteral) {
      // Warn on floating point literal to integer.
      DiagID = diag.warn_impcast_literal_float_to_integer;
    } else if (IntegerValue.$eq(0)) {
      if (Value.isZero()) { // Skip -0.0 to 0 conversion.
        DiagnoseImpCast(S, E, new QualType(T), new SourceLocation(CContext), 
            diag.warn_impcast_float_integer, PruneWarnings);
        return;
      }
      // Warn on non-zero to zero conversion.
      DiagID = diag.warn_impcast_float_to_integer_zero;
    } else {
      if (IntegerValue.isUnsigned()) {
        if (!IntegerValue.isMaxValue()) {
          DiagnoseImpCast(S, E, new QualType(T), new SourceLocation(CContext), 
              diag.warn_impcast_float_integer, PruneWarnings);
          return;
        }
      } else { // IntegerValue.isSigned()
        if (!IntegerValue.isMaxSignedValue()
           && !IntegerValue.isMinSignedValue()) {
          DiagnoseImpCast(S, E, new QualType(T), new SourceLocation(CContext), 
              diag.warn_impcast_float_integer, PruneWarnings);
          return;
        }
      }
      // Warn on evaluatable floating point expression to integer conversion.
      DiagID = diag.warn_impcast_float_to_integer;
    }
    
    // FIXME: Force the precision of the source value down so we don't print
    // digits which are usually useless (we don't really care here if we
    // truncate a digit by accident in edge cases).  Ideally, APFloat::toString
    // would automatically print the shortest representation, but it's a bit
    // tricky to implement.
    SmallString/*16*/ PrettySourceValue/*J*/= new SmallString/*16*/(16);
    /*uint*/int precision = APFloat.semanticsPrecision(Value.getSemantics());
    precision = $div_uint((precision * 59 + 195), 196);
    Value.__toString(PrettySourceValue, precision);
    
    SmallString/*16*/ PrettyTargetValue/*J*/= new SmallString/*16*/(16);
    if (IsBool) {
      PrettyTargetValue.$assign(/*STRINGREF_STR*/Value.isZero() ? $false : $true);
    } else {
      IntegerValue.__toString(PrettyTargetValue);
    }
    if (PruneWarnings) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(S.DiagRuntimeBehavior(E.getExprLoc(), E, 
            $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_StringRef($out_PartialDiagnostic$C_StringRef($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_QualType($c$.track(S.PDiag(DiagID)), 
                                    E.getType()), T.getUnqualifiedType()), 
                            PrettySourceValue.$StringRef()), PrettyTargetValue.$StringRef()), 
                    E.getSourceRange()), new SourceRange(/*NO_COPY*/CContext))));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getExprLoc(), DiagID)), 
                                E.getType()), T.getUnqualifiedType()), PrettySourceValue), 
                    PrettyTargetValue), E.getSourceRange()), new SourceRange(/*NO_COPY*/CContext)));
      } finally {
        $c$.$destroy();
      }
    }
  } finally {
    if (Value != null) { Value.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrettyPrintInRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7960,
 FQN="(anonymous namespace)::PrettyPrintInRange", NM="_ZN12_GLOBAL__N_118PrettyPrintInRangeERKN4llvm6APSIntENS_8IntRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118PrettyPrintInRangeERKN4llvm6APSIntENS_8IntRangeE")
//</editor-fold>
public static std.string PrettyPrintInRange(final /*const*/ APSInt /*&*/ Value, IntRange Range) {
  if (!(Range.Width != 0)) {
    return new std.string(/*KEEP_STR*/$0);
  }
  
  APSInt ValueInRange = new APSInt(Value);
  ValueInRange.setIsSigned(!Range.NonNegative);
  ValueInRange.$assignMove(ValueInRange.trunc(Range.Width));
  return ValueInRange.__toString(10);
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IsImplicitBoolFloatConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7969,
 FQN="(anonymous namespace)::IsImplicitBoolFloatConversion", NM="_ZN12_GLOBAL__N_129IsImplicitBoolFloatConversionERN5clang4SemaEPNS0_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_129IsImplicitBoolFloatConversionERN5clang4SemaEPNS0_4ExprEb")
//</editor-fold>
public static boolean IsImplicitBoolFloatConversion(final Sema /*&*/ S, Expr /*P*/ Ex, boolean ToBool) {
  if (!isa_ImplicitCastExpr(Ex)) {
    return false;
  }
  
  Expr /*P*/ InnerE = Ex.IgnoreParenImpCasts();
  /*const*/ Type /*P*/ Target = S.Context.getCanonicalType(Ex.getType()).getTypePtr();
  /*const*/ Type /*P*/ Source = S.Context.getCanonicalType(InnerE.getType()).getTypePtr();
  if (Target.isDependentType()) {
    return false;
  }
  
  /*const*/ BuiltinType /*P*/ FloatCandidateBT = dyn_cast_BuiltinType(ToBool ? Source : Target);
  /*const*/ Type /*P*/ BoolCandidateType = ToBool ? Target : Source;
  
  return (BoolCandidateType.isSpecificBuiltinType(BuiltinType.Kind.Bool.getValue())
     && (FloatCandidateBT != null) && (FloatCandidateBT.isFloatingPoint()));
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckImplicitArgumentConversions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 7988,
 FQN="(anonymous namespace)::CheckImplicitArgumentConversions", NM="_ZN12_GLOBAL__N_132CheckImplicitArgumentConversionsERN5clang4SemaEPNS0_8CallExprENS0_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_132CheckImplicitArgumentConversionsERN5clang4SemaEPNS0_8CallExprENS0_14SourceLocationE")
//</editor-fold>
public static void CheckImplicitArgumentConversions(final Sema /*&*/ S, CallExpr /*P*/ TheCall, 
                                SourceLocation CC) {
  /*uint*/int NumArgs = TheCall.getNumArgs();
  for (/*uint*/int i = 0; $less_uint(i, NumArgs); ++i) {
    Expr /*P*/ CurrA = TheCall.getArg(i);
    if (!IsImplicitBoolFloatConversion(S, CurrA, true)) {
      continue;
    }
    
    boolean IsSwapped = (($greater_uint(i, 0))
       && IsImplicitBoolFloatConversion(S, TheCall.getArg(i - 1), false));
    IsSwapped |= (($less_uint(i, (NumArgs - 1)))
       && IsImplicitBoolFloatConversion(S, TheCall.getArg(i + 1), false));
    if (IsSwapped) {
      // Warn on this floating-point to bool conversion.
      DiagnoseImpCast(S, CurrA.IgnoreParenImpCasts(), 
          CurrA.getType(), new SourceLocation(CC), 
          diag.warn_impcast_floating_point_to_bool);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DiagnoseNullConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8009,
 FQN="(anonymous namespace)::DiagnoseNullConversion", NM="_ZN12_GLOBAL__N_122DiagnoseNullConversionERN5clang4SemaEPNS0_4ExprENS0_8QualTypeENS0_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_122DiagnoseNullConversionERN5clang4SemaEPNS0_4ExprENS0_8QualTypeENS0_14SourceLocationE")
//</editor-fold>
public static void DiagnoseNullConversion(final Sema /*&*/ S, Expr /*P*/ E, QualType T, SourceLocation CC) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (S.Diags.isIgnored(diag.warn_impcast_null_pointer_to_integer, 
        E.getExprLoc())) {
      return;
    }
    
    // Don't warn on functions which have return type nullptr_t.
    if (isa_CallExpr(E)) {
      return;
    }
    
    // Check for NULL (GNUNull) or nullptr (CXX11_nullptr).
    /*const*/ Expr.NullPointerConstantKind NullKind = E.isNullPointerConstant(S.Context, Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNotNull);
    if (NullKind != Expr.NullPointerConstantKind.NPCK_GNUNull && NullKind != Expr.NullPointerConstantKind.NPCK_CXX11_nullptr) {
      return;
    }
    
    // Return if target type is a safe conversion.
    if (T.$arrow().isAnyPointerType() || T.$arrow().isBlockPointerType()
       || T.$arrow().isMemberPointerType() || !T.$arrow().isScalarType() || T.$arrow().isNullPtrType()) {
      return;
    }
    
    SourceLocation Loc = E.getSourceRange().getBegin();
    
    // Venture through the macro stacks to get to the source of macro arguments.
    // The new location is a better location than the complete location that was
    // passed in.
    while (S.SourceMgr.isMacroArgExpansion(/*NO_COPY*/Loc)) {
      Loc.$assignMove(S.SourceMgr.getImmediateMacroCallerLoc(/*NO_COPY*/Loc));
    }
    while (S.SourceMgr.isMacroArgExpansion(/*NO_COPY*/CC)) {
      CC.$assignMove(S.SourceMgr.getImmediateMacroCallerLoc(/*NO_COPY*/CC));
    }
    
    // __null is usually wrapped in a macro.  Go up a macro if that is the case.
    if (NullKind == Expr.NullPointerConstantKind.NPCK_GNUNull && Loc.isMacroID()) {
      StringRef MacroName = Lexer.getImmediateMacroNameForDiagnostics(/*NO_COPY*/Loc, S.SourceMgr, S.getLangOpts());
      if ($eq_StringRef(/*NO_COPY*/MacroName, /*STRINGREF_STR*/"NULL")) {
        Loc.$assignMove(S.SourceMgr.getImmediateExpansionRange(/*NO_COPY*/Loc).first);
      }
    }
    
    // Only warn if the null and context location are in the same macro expansion.
    if (S.SourceMgr.getFileID(/*NO_COPY*/Loc).$noteq(S.SourceMgr.getFileID(/*NO_COPY*/CC))) {
      return;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.warn_impcast_null_pointer_to_integer)), 
                    (NullKind == Expr.NullPointerConstantKind.NPCK_CXX11_nullptr)), T), new SourceRange(/*NO_COPY*/CC)), 
        FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/Loc), 
            new StringRef(S.getFixItZeroLiteralForType(new QualType(T), new SourceLocation(Loc))))));
  } finally {
    $c$.$destroy();
  }
}


/// Check an Objective-C array literal being converted to the given
/// target type.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkObjCArrayLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8095,
 FQN="(anonymous namespace)::checkObjCArrayLiteral", NM="_ZN12_GLOBAL__N_121checkObjCArrayLiteralERN5clang4SemaENS0_8QualTypeEPNS0_16ObjCArrayLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_121checkObjCArrayLiteralERN5clang4SemaENS0_8QualTypeEPNS0_16ObjCArrayLiteralE")
//</editor-fold>
public static void checkObjCArrayLiteral(final Sema /*&*/ S, QualType TargetType, 
                     ObjCArrayLiteral /*P*/ ArrayLiteral) {
  if (!(S.NSArrayDecl != null)) {
    return;
  }
  
  /*const*/ ObjCObjectPointerType /*P*/ TargetObjCPtr = TargetType.$arrow().getAs(ObjCObjectPointerType.class);
  if (!(TargetObjCPtr != null)) {
    return;
  }
  if (TargetObjCPtr.isUnspecialized()
     || TargetObjCPtr.getInterfaceDecl().getCanonicalDecl()
     != S.NSArrayDecl.getCanonicalDecl()) {
    return;
  }
  
  ArrayRef<QualType> TypeArgs = TargetObjCPtr.getTypeArgs();
  if (TypeArgs.size() != 1) {
    return;
  }
  
  QualType TargetElementType = new QualType(TypeArgs.$at(0));
  for (/*uint*/int I = 0, N = ArrayLiteral.getNumElements(); I != N; ++I) {
    checkObjCCollectionLiteralElement(S, new QualType(TargetElementType), 
        ArrayLiteral.getElement(I), 
        0);
  }
}


/// Check an Objective-C dictionary literal being converted to the given
/// target type.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkObjCDictionaryLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8123,
 FQN="(anonymous namespace)::checkObjCDictionaryLiteral", NM="_ZN12_GLOBAL__N_126checkObjCDictionaryLiteralERN5clang4SemaENS0_8QualTypeEPNS0_21ObjCDictionaryLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_126checkObjCDictionaryLiteralERN5clang4SemaENS0_8QualTypeEPNS0_21ObjCDictionaryLiteralE")
//</editor-fold>
public static void checkObjCDictionaryLiteral(final Sema /*&*/ S, QualType TargetType, 
                          ObjCDictionaryLiteral /*P*/ DictionaryLiteral) {
  if (!(S.NSDictionaryDecl != null)) {
    return;
  }
  
  /*const*/ ObjCObjectPointerType /*P*/ TargetObjCPtr = TargetType.$arrow().getAs(ObjCObjectPointerType.class);
  if (!(TargetObjCPtr != null)) {
    return;
  }
  if (TargetObjCPtr.isUnspecialized()
     || TargetObjCPtr.getInterfaceDecl().getCanonicalDecl()
     != S.NSDictionaryDecl.getCanonicalDecl()) {
    return;
  }
  
  ArrayRef<QualType> TypeArgs = TargetObjCPtr.getTypeArgs();
  if (TypeArgs.size() != 2) {
    return;
  }
  
  QualType TargetKeyType = new QualType(TypeArgs.$at(0));
  QualType TargetObjectType = new QualType(TypeArgs.$at(1));
  for (/*uint*/int I = 0, N = DictionaryLiteral.getNumElements(); I != N; ++I) {
    ObjCDictionaryElement Element = null;
    try {
      Element = DictionaryLiteral.getKeyValueElement(I);
      checkObjCCollectionLiteralElement(S, new QualType(TargetKeyType), Element.Key, 1);
      checkObjCCollectionLiteralElement(S, new QualType(TargetObjectType), Element.Value, 2);
    } finally {
      if (Element != null) { Element.$destroy(); }
    }
  }
}


/// Check a single element within a collection literal against the
/// target element type.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkObjCCollectionLiteralElement">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8065,
 FQN="(anonymous namespace)::checkObjCCollectionLiteralElement", NM="_ZN12_GLOBAL__N_133checkObjCCollectionLiteralElementERN5clang4SemaENS0_8QualTypeEPNS0_4ExprEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_133checkObjCCollectionLiteralElementERN5clang4SemaENS0_8QualTypeEPNS0_4ExprEj")
//</editor-fold>
public static void checkObjCCollectionLiteralElement(final Sema /*&*/ S, QualType TargetElementType, 
                                 Expr /*P*/ Element, /*uint*/int ElementKind) {
  {
    // Skip a bitcast to 'id' or qualified 'id'.
    ImplicitCastExpr /*P*/ ICE = dyn_cast_ImplicitCastExpr(Element);
    if ((ICE != null)) {
      if (ICE.getCastKind() == CastKind.CK_BitCast
         && (ICE.getSubExpr().getType().$arrow().getAs(ObjCObjectPointerType.class) != null)) {
        Element = ICE.getSubExpr();
      }
    }
  }
  
  QualType ElementType = Element.getType();
  ActionResultTTrue<Expr /*P*/ > ElementResult/*J*/= new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Element);
  if ((ElementType.$arrow().getAs(ObjCObjectPointerType.class) != null)
     && S.CheckSingleAssignmentConstraints(new QualType(TargetElementType), 
      ElementResult, 
      false, false)
     != Sema.AssignConvertType.Compatible) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Element.getLocStart(), 
                          diag.warn_objc_collection_literal_element)), 
                      ElementType), ElementKind), TargetElementType), 
          Element.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
  {
    
    ObjCArrayLiteral /*P*/ ArrayLiteral = dyn_cast_ObjCArrayLiteral(Element);
    if ((ArrayLiteral != null)) {
      checkObjCArrayLiteral(S, new QualType(TargetElementType), ArrayLiteral);
    } else {
      ObjCDictionaryLiteral /*P*/ DictionaryLiteral = dyn_cast_ObjCDictionaryLiteral(Element);
      if ((DictionaryLiteral != null)) {
        checkObjCDictionaryLiteral(S, new QualType(TargetElementType), DictionaryLiteral);
      }
    }
  }
}


// Helper function to filter out cases for constant width constant conversion.
// Don't warn on char array initialization or for non-decimal values.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isSameWidthConstantConversion">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*PERF*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8152,
 FQN="(anonymous namespace)::isSameWidthConstantConversion", NM="_ZN12_GLOBAL__N_129isSameWidthConstantConversionERN5clang4SemaEPNS0_4ExprENS0_8QualTypeENS0_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_129isSameWidthConstantConversionERN5clang4SemaEPNS0_4ExprENS0_8QualTypeENS0_14SourceLocationE")
//</editor-fold>
public static boolean isSameWidthConstantConversion(final Sema /*&*/ S, Expr /*P*/ E, QualType T, 
                             SourceLocation CC) {
  {
    // If initializing from a constant, and the constant starts with '0',
    // then it is a binary, octal, or hexadecimal.  Allow these constants
    // to fill all the bits, even if there is a sign change.
    IntegerLiteral /*P*/ IntLit = dyn_cast_IntegerLiteral(E.IgnoreParenImpCasts());
    if ((IntLit != null)) {
      /*const*//*char*/byte FirstLiteralCharacter = S.getSourceManager().getCharacterData_FirstChar(IntLit.getLocStart().getRawEncoding(), null);
      if (FirstLiteralCharacter == $$0) {
        return false;
      }
    }
  }
  
  // If the CC location points to a '{', and the type is char, then assume
  // assume it is an array initialization.
  if (CC.isValid() && T.$arrow().isCharType()) {
    /*const*//*char*/byte FirstContextCharacter = S.getSourceManager().getCharacterData_FirstChar(/*NO_COPY*/CC.getRawEncoding(), null);
    if (FirstContextCharacter == $$LCURLY) {
      return false;
    }
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckImplicitConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8176,
 FQN="(anonymous namespace)::CheckImplicitConversion", NM="_ZN12_GLOBAL__N_123CheckImplicitConversionERN5clang4SemaEPNS0_4ExprENS0_8QualTypeENS0_14SourceLocationEPb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_123CheckImplicitConversionERN5clang4SemaEPNS0_4ExprENS0_8QualTypeENS0_14SourceLocationEPb")
//</editor-fold>
public static void CheckImplicitConversion(final Sema /*&*/ S, Expr /*P*/ E, QualType T, 
                       SourceLocation CC) {
  CheckImplicitConversion(S, E, T, 
                       CC, (bool$ptr/*bool P*/ )null);
}
public static void CheckImplicitConversion(final Sema /*&*/ S, Expr /*P*/ E, QualType T, 
                       SourceLocation CC, bool$ptr/*bool P*/ ICContext/*= null*/) {
  if (E.isTypeDependent() || E.isValueDependent()) {
    return;
  }
  
  /*const*/ Type /*P*/ Source = S.Context.getCanonicalType(E.getType()).getTypePtr();
  /*const*/ Type /*P*/ Target = S.Context.getCanonicalType(new QualType(T)).getTypePtr();
  if (Source == Target) {
    return;
  }
  if (Target.isDependentType()) {
    return;
  }
  
  // If the conversion context location is invalid don't complain. We also
  // don't want to emit a warning if the issue occurs from the expansion of
  // a system macro. The problem is that 'getSpellingLoc()' is slow, so we
  // delay this check as long as possible. Once we detect we are in that
  // scenario, we just return.
  if (CC.isInvalid()) {
    return;
  }
  
  // Diagnose implicit casts to bool.
  if (Target.isSpecificBuiltinType(BuiltinType.Kind.Bool.getValue())) {
    if (isa_StringLiteral(E)) {
      // Warn on string literal to bool.  Checks for string literals in logical
      // and expressions, for instance, assert(0 && "error here"), are
      // prevented by a check in AnalyzeImplicitConversions().
      DiagnoseImpCast(S, E, new QualType(T), new SourceLocation(CC), 
          diag.warn_impcast_string_literal_to_bool);
      return;
    }
    if (isa_ObjCStringLiteral(E) || isa_ObjCArrayLiteral(E)
       || isa_ObjCDictionaryLiteral(E) || isa_ObjCBoxedExpr(E)) {
      // This covers the literal expressions that evaluate to Objective-C
      // objects.
      DiagnoseImpCast(S, E, new QualType(T), new SourceLocation(CC), 
          diag.warn_impcast_objective_c_literal_to_bool);
      return;
    }
    if (Source.isPointerType() || Source.canDecayToPointerType()) {
      // Warn on pointer to bool conversion that is always true.
      S.DiagnoseAlwaysNonNullPointer(E, Expr.NullPointerConstantKind.NPCK_NotNull, /*IsEqual*/ false, 
          new SourceRange(/*NO_COPY*/CC));
    }
  }
  {
    
    // Check implicit casts from Objective-C collection literals to specialized
    // collection types, e.g., NSArray<NSString *> *.
    ObjCArrayLiteral /*P*/ ArrayLiteral = dyn_cast_ObjCArrayLiteral(E);
    if ((ArrayLiteral != null)) {
      checkObjCArrayLiteral(S, new QualType(Target, 0), ArrayLiteral);
    } else {
      ObjCDictionaryLiteral /*P*/ DictionaryLiteral = dyn_cast_ObjCDictionaryLiteral(E);
      if ((DictionaryLiteral != null)) {
        checkObjCDictionaryLiteral(S, new QualType(Target, 0), DictionaryLiteral);
      }
    }
  }
  
  // Strip vector types.
  if (isa_VectorType(Source)) {
    if (!isa_VectorType(Target)) {
      if (S.SourceMgr.isInSystemMacro(/*NO_COPY*/CC)) {
        return;
      }
      DiagnoseImpCast(S, E, new QualType(T), new SourceLocation(CC), diag.warn_impcast_vector_scalar);
      return;
    }
    
    // If the vector cast is cast between two vectors of the same size, it is
    // a bitcast, not a conversion.
    if (S.Context.getTypeSize(Source) == S.Context.getTypeSize(Target)) {
      return;
    }
    
    Source = cast_VectorType(Source).getElementType().getTypePtr();
    Target = cast_VectorType(Target).getElementType().getTypePtr();
  }
  {
    /*const*/ VectorType /*P*/ VecTy = dyn_cast_VectorType(Target);
    if ((VecTy != null)) {
      Target = VecTy.getElementType().getTypePtr();
    }
  }
  
  // Strip complex types.
  if (isa_ComplexType(Source)) {
    if (!isa_ComplexType(Target)) {
      if (S.SourceMgr.isInSystemMacro(/*NO_COPY*/CC)) {
        return;
      }
      
      DiagnoseImpCast(S, E, new QualType(T), new SourceLocation(CC), diag.warn_impcast_complex_scalar);
      return;
    }
    
    Source = cast_ComplexType(Source).getElementType().getTypePtr();
    Target = cast_ComplexType(Target).getElementType().getTypePtr();
  }
  
  /*const*/ BuiltinType /*P*/ SourceBT = dyn_cast_BuiltinType(Source);
  /*const*/ BuiltinType /*P*/ TargetBT = dyn_cast_BuiltinType(Target);
  
  // If the source is floating point...
  if ((SourceBT != null) && SourceBT.isFloatingPoint()) {
    // ...and the target is floating point...
    if ((TargetBT != null) && TargetBT.isFloatingPoint()) {
      // ...then warn if we're dropping FP rank.
      
      // Builtin FP kinds are ordered by increasing FP rank.
      if (SourceBT.getKind().getValue() > TargetBT.getKind().getValue()) {
        Expr.EvalResult result = null;
        try {
          // Don't warn about float constants that are precisely
          // representable in the target type.
          result/*J*/= new Expr.EvalResult();
          if (E.EvaluateAsRValue(result, S.Context)) {
            // Value might be a float, a float vector, or a float complex.
            if (IsSameFloatAfterCast(result.Val, 
                S.Context.getFloatTypeSemantics(new QualType(TargetBT, 0)), 
                S.Context.getFloatTypeSemantics(new QualType(SourceBT, 0)))) {
              return;
            }
          }
          if (S.SourceMgr.isInSystemMacro(/*NO_COPY*/CC)) {
            return;
          }
          
          DiagnoseImpCast(S, E, new QualType(T), new SourceLocation(CC), diag.warn_impcast_float_precision);
        } finally {
          if (result != null) { result.$destroy(); }
        }
      } else // ... or possibly if we're increasing rank, too
      if (TargetBT.getKind().getValue() > SourceBT.getKind().getValue()) {
        if (S.SourceMgr.isInSystemMacro(/*NO_COPY*/CC)) {
          return;
        }
        
        DiagnoseImpCast(S, E, new QualType(T), new SourceLocation(CC), diag.warn_impcast_double_promotion);
      }
      return;
    }
    
    // If the target is integral, always warn.
    if ((TargetBT != null) && TargetBT.isInteger()) {
      if (S.SourceMgr.isInSystemMacro(/*NO_COPY*/CC)) {
        return;
      }
      
      DiagnoseFloatingImpCast(S, E, new QualType(T), new SourceLocation(CC));
    }
    
    // Detect the case where a call result is converted from floating-point to
    // to bool, and the final argument to the call is converted from bool, to
    // discover this typo:
    //
    //    bool b = fabs(x < 1.0);  // should be "bool b = fabs(x) < 1.0;"
    //
    // FIXME: This is an incredibly special case; is there some more general
    // way to detect this class of misplaced-parentheses bug?
    if (Target.isBooleanType() && isa_CallExpr(E)) {
      // Check last argument of function call to see if it is an
      // implicit cast from a type matching the type the result
      // is being cast to.
      CallExpr /*P*/ CEx = cast_CallExpr(E);
      {
        /*uint*/int NumArgs = CEx.getNumArgs();
        if ((NumArgs != 0)) {
          Expr /*P*/ LastA = CEx.getArg(NumArgs - 1);
          Expr /*P*/ InnerE = LastA.IgnoreParenImpCasts();
          if (isa_ImplicitCastExpr(LastA)
             && InnerE.getType().$arrow().isBooleanType()) {
            // Warn on this floating-point to bool conversion
            DiagnoseImpCast(S, E, new QualType(T), new SourceLocation(CC), 
                diag.warn_impcast_floating_point_to_bool);
          }
        }
      }
    }
    return;
  }
  
  DiagnoseNullConversion(S, E, new QualType(T), new SourceLocation(CC));
  if (!Source.isIntegerType() || !Target.isIntegerType()) {
    return;
  }
  
  // TODO: remove this early return once the false positives for constant->bool
  // in templates, macros, etc, are reduced or removed.
  if (Target.isSpecificBuiltinType(BuiltinType.Kind.Bool.getValue())) {
    return;
  }
  
  IntRange SourceRange = GetExprRange(S.Context, E);
  IntRange TargetRange = IntRange.forTargetOfCanonicalType(S.Context, Target);
  if ($greater_uint(SourceRange.Width, TargetRange.Width)) {
    // If the source is a constant, use a default-on diagnostic.
    // TODO: this should happen for bitfield stores, too.
    APSInt Value/*J*/= new APSInt(32);
    if (E.EvaluateAsInt(Value, S.Context, Expr.SideEffectsKind.SE_AllowSideEffects)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        if (S.SourceMgr.isInSystemMacro(/*NO_COPY*/CC)) {
          return;
        }
        
        std.string PrettySourceValue = Value.__toString(10);
        std.string PrettyTargetValue = PrettyPrintInRange(Value, new IntRange(TargetRange));
        
        $c$.clean(S.DiagRuntimeBehavior(E.getExprLoc(), E, 
            $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_StringRef($out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.warn_impcast_integer_precision_constant)), 
                                    new StringRef(PrettySourceValue)), new StringRef(PrettyTargetValue)), 
                            E.getType()), /*NO_COPY*/T), E.getSourceRange()), 
                new SourceRange(/*NO_COPY*/CC))));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // People want to build with -Wshorten-64-to-32 and not -Wconversion.
    if (S.SourceMgr.isInSystemMacro(/*NO_COPY*/CC)) {
      return;
    }
    if (TargetRange.Width == 32 && S.Context.getIntWidth(E.getType()) == 64) {
      DiagnoseImpCast(S, E, new QualType(T), new SourceLocation(CC), diag.warn_impcast_integer_64_32, 
          /* pruneControlFlow */ true);
      return;
    }
    DiagnoseImpCast(S, E, new QualType(T), new SourceLocation(CC), diag.warn_impcast_integer_precision);
    return;
  }
  if (TargetRange.Width == SourceRange.Width && !TargetRange.NonNegative
     && SourceRange.NonNegative && Source.isSignedIntegerType()) {
    // Warn when doing a signed to signed conversion, warn if the positive
    // source value is exactly the width of the target type, which will
    // cause a negative value to be stored.
    APSInt Value/*J*/= new APSInt();
    if (E.EvaluateAsInt(Value, S.Context, Expr.SideEffectsKind.SE_AllowSideEffects)
       && !S.SourceMgr.isInSystemMacro(/*NO_COPY*/CC)) {
      if (isSameWidthConstantConversion(S, E, new QualType(T), new SourceLocation(CC))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          std.string PrettySourceValue = Value.__toString(10);
          std.string PrettyTargetValue = PrettyPrintInRange(Value, new IntRange(TargetRange));
          
          $c$.clean(S.DiagRuntimeBehavior(E.getExprLoc(), E, 
              $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_StringRef($out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.warn_impcast_integer_precision_constant)), 
                                      new StringRef(PrettySourceValue)), new StringRef(PrettyTargetValue)), E.getType()), /*NO_COPY*/T), 
                      E.getSourceRange()), new SourceRange(/*NO_COPY*/CC))));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
    // Fall through for non-constants to give a sign conversion warning.
  }
  if ((TargetRange.NonNegative && !SourceRange.NonNegative)
     || (!TargetRange.NonNegative && SourceRange.NonNegative
     && SourceRange.Width == TargetRange.Width)) {
    if (S.SourceMgr.isInSystemMacro(/*NO_COPY*/CC)) {
      return;
    }
    
    /*uint*/int DiagID = diag.warn_impcast_integer_sign;
    
    // Traditionally, gcc has warned about this under -Wsign-compare.
    // We also want to warn about it in -Wconversion.
    // So if -Wconversion is off, use a completely identical diagnostic
    // in the sign-compare group.
    // The conditional-checking code will 
    if ((ICContext != null)) {
      DiagID = diag.warn_impcast_integer_sign_conditional;
      ICContext.$set(true);
    }
    
    DiagnoseImpCast(S, E, new QualType(T), new SourceLocation(CC), DiagID);
    return;
  }
  
  // Diagnose conversions between different enumeration types.
  // In C, we pretend that the type of an EnumConstantDecl is its enumeration
  // type, to give us better diagnostics.
  QualType SourceType = E.getType();
  if (!S.getLangOpts().CPlusPlus) {
    {
      DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
      if ((DRE != null)) {
        {
          EnumConstantDecl /*P*/ ECD = dyn_cast_EnumConstantDecl(DRE.getDecl());
          if ((ECD != null)) {
            EnumDecl /*P*/ Enum = cast_EnumDecl(ECD.getDeclContext());
            SourceType.$assignMove(S.Context.getTypeDeclType(Enum));
            Source = S.Context.getCanonicalType(new QualType(SourceType)).getTypePtr();
          }
        }
      }
    }
  }
  {
    
    /*const*/ EnumType /*P*/ SourceEnum = Source.<EnumType>getAs$EnumType();
    if ((SourceEnum != null)) {
      {
        /*const*/ EnumType /*P*/ TargetEnum = Target.<EnumType>getAs$EnumType();
        if ((TargetEnum != null)) {
          if (SourceEnum.getDecl().hasNameForLinkage()
             && TargetEnum.getDecl().hasNameForLinkage()
             && SourceEnum != TargetEnum) {
            if (S.SourceMgr.isInSystemMacro(/*NO_COPY*/CC)) {
              return;
            }
            
            DiagnoseImpCast(S, E, new QualType(SourceType), new QualType(T), new SourceLocation(CC), 
                diag.warn_impcast_different_enum_types);
            return;
          }
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckConditionalOperator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8455,
 FQN="(anonymous namespace)::CheckConditionalOperator", NM="_ZN12_GLOBAL__N_124CheckConditionalOperatorERN5clang4SemaEPNS0_19ConditionalOperatorENS0_14SourceLocationENS0_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_124CheckConditionalOperatorERN5clang4SemaEPNS0_19ConditionalOperatorENS0_14SourceLocationENS0_8QualTypeE")
//</editor-fold>
public static void CheckConditionalOperator(final Sema /*&*/ S, ConditionalOperator /*P*/ E, 
                        SourceLocation CC, QualType T) {
  AnalyzeImplicitConversions(S, E.getCond(), E.getQuestionLoc());
  
  bool$ptr Suspicious = create_bool$ptr(false);
  CheckConditionalOperand(S, E.getTrueExpr(), new QualType(T), new SourceLocation(CC), Suspicious);
  CheckConditionalOperand(S, E.getFalseExpr(), new QualType(T), new SourceLocation(CC), Suspicious);
  
  // If -Wconversion would have warned about either of the candidates
  // for a signedness conversion to the context type...
  if (!Suspicious.$star()) {
    return;
  }
  
  // ...but it's currently ignored...
  if (!S.Diags.isIgnored(diag.warn_impcast_integer_sign_conditional, /*NO_COPY*/CC)) {
    return;
  }
  
  // ...then check whether it would have warned about either of the
  // candidates for a signedness conversion to the condition type.
  if ($eq_QualType$C(E.getType(), T)) {
    return;
  }
  
  Suspicious.$set(false);
  CheckImplicitConversion(S, E.getTrueExpr().IgnoreParenImpCasts(), 
      E.getType(), new SourceLocation(CC), Suspicious);
  if (!Suspicious.$star()) {
    CheckImplicitConversion(S, E.getFalseExpr().IgnoreParenImpCasts(), 
        E.getType(), new SourceLocation(CC), Suspicious);
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckConditionalOperand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8443,
 FQN="(anonymous namespace)::CheckConditionalOperand", NM="_ZN12_GLOBAL__N_123CheckConditionalOperandERN5clang4SemaEPNS0_4ExprENS0_8QualTypeENS0_14SourceLocationERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_123CheckConditionalOperandERN5clang4SemaEPNS0_4ExprENS0_8QualTypeENS0_14SourceLocationERb")
//</editor-fold>
public static void CheckConditionalOperand(final Sema /*&*/ S, Expr /*P*/ E, QualType T, 
                       SourceLocation CC, final bool$ptr/*bool &*/ ICContext) {
  E = E.IgnoreParenImpCasts();
  if (isa_ConditionalOperator(E)) {
    CheckConditionalOperator(S, cast_ConditionalOperator(E), new SourceLocation(CC), new QualType(T));
    return;
  }
  
  AnalyzeImplicitConversions(S, E, new SourceLocation(CC));
  if ($noteq_QualType$C(E.getType(), T)) {
    CheckImplicitConversion(S, E, new QualType(T), new SourceLocation(CC), ICContext);
    return;
  }
}


/// CheckBoolLikeConversion - Check conversion of given expression to boolean.
/// Input argument E is a logical expression.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckBoolLikeConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8485,
 FQN="(anonymous namespace)::CheckBoolLikeConversion", NM="_ZN12_GLOBAL__N_123CheckBoolLikeConversionERN5clang4SemaEPNS0_4ExprENS0_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_123CheckBoolLikeConversionERN5clang4SemaEPNS0_4ExprENS0_14SourceLocationE")
//</editor-fold>
public static void CheckBoolLikeConversion(final Sema /*&*/ S, Expr /*P*/ E, SourceLocation CC) {
  if (S.getLangOpts().Bool) {
    return;
  }
  CheckImplicitConversion(S, E.IgnoreParenImpCasts(), S.Context.BoolTy.$QualType(), new SourceLocation(CC));
}


// Helper function for Sema::DiagnoseAlwaysNonNullPointer.
// Returns true when emitting a warning about taking the address of a reference.
//<editor-fold defaultstate="collapsed" desc="CheckForReference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8612,
 FQN="CheckForReference", NM="_ZL17CheckForReferenceRN5clang4SemaEPKNS_4ExprERKNS_17PartialDiagnosticE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL17CheckForReferenceRN5clang4SemaEPKNS_4ExprERKNS_17PartialDiagnosticE")
//</editor-fold>
public static boolean CheckForReference(final Sema /*&*/ SemaRef, /*const*/ Expr /*P*/ E, 
                 final /*const*/ PartialDiagnostic /*&*/ PD) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    E = E.IgnoreParenImpCasts$Const();
    
    /*const*/ FunctionDecl /*P*/ FD = null;
    {
      
      /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
      if ((DRE != null)) {
        if (!DRE.getDecl$Const().getType().$arrow().isReferenceType()) {
          return false;
        }
      } else {
        /*const*/ MemberExpr /*P*/ M = dyn_cast_MemberExpr(E);
        if ((M != null)) {
          if (!M.getMemberDecl().getType().$arrow().isReferenceType()) {
            return false;
          }
        } else {
          /*const*/ CallExpr /*P*/ Call = dyn_cast_CallExpr(E);
          if ((Call != null)) {
            if (!Call.getCallReturnType(SemaRef.Context).$arrow().isReferenceType()) {
              return false;
            }
            FD = Call.getDirectCallee$Const();
          } else {
            return false;
          }
        }
      }
    }
    
    $c$.clean($c$.track(SemaRef.Diag(E.getExprLoc(), PD)));
    
    // If possible, point to location of function.
    if ((FD != null)) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(FD.getLocation(), diag.note_reference_is_return_value)), FD));
    }
    
    return true;
  } finally {
    $c$.$destroy();
  }
}


// Returns true if the SourceLocation is expanded from any macro body.
// Returns false if the SourceLocation is invalid, is from not in a macro
// expansion, or is from expanded from a top-level macro argument.
//<editor-fold defaultstate="collapsed" desc="IsInAnyMacroBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8645,
 FQN="IsInAnyMacroBody", NM="_ZL16IsInAnyMacroBodyRKN5clang13SourceManagerENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL16IsInAnyMacroBodyRKN5clang13SourceManagerENS_14SourceLocationE")
//</editor-fold>
public static boolean IsInAnyMacroBody(final /*const*/ SourceManager /*&*/ SM, SourceLocation Loc) {
  if (Loc.isInvalid()) {
    return false;
  }
  while (Loc.isMacroID()) {
    if (SM.isMacroBodyExpansion(/*NO_COPY*/Loc)) {
      return true;
    }
    Loc.$assignMove(SM.getImmediateMacroCallerLoc(/*NO_COPY*/Loc));
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="diagnoseArrayStarInParamType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9406,
 FQN="diagnoseArrayStarInParamType", NM="_ZL28diagnoseArrayStarInParamTypeRN5clang4SemaENS_8QualTypeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL28diagnoseArrayStarInParamTypeRN5clang4SemaENS_8QualTypeENS_14SourceLocationE")
//</editor-fold>
public static void diagnoseArrayStarInParamType(final Sema /*&*/ S, QualType PType, 
                            SourceLocation Loc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (!PType.$arrow().isVariablyModifiedType()) {
      return;
    }
    {
      /*const*/ PointerType /*P*/ PointerTy = dyn_cast_PointerType(PType);
      if ((PointerTy != null)) {
        diagnoseArrayStarInParamType(S, PointerTy.getPointeeType(), new SourceLocation(Loc));
        return;
      }
    }
    {
      /*const*/ ReferenceType /*P*/ ReferenceTy = dyn_cast_ReferenceType(PType);
      if ((ReferenceTy != null)) {
        diagnoseArrayStarInParamType(S, ReferenceTy.getPointeeType(), new SourceLocation(Loc));
        return;
      }
    }
    {
      /*const*/ ParenType /*P*/ ParenTy = dyn_cast_ParenType(PType);
      if ((ParenTy != null)) {
        diagnoseArrayStarInParamType(S, ParenTy.getInnerType(), new SourceLocation(Loc));
        return;
      }
    }
    
    /*const*/ ArrayType /*P*/ AT = S.Context.getAsArrayType(new QualType(PType));
    if (!(AT != null)) {
      return;
    }
    if (AT.getSizeModifier() != ArrayType.ArraySizeModifier.Star) {
      diagnoseArrayStarInParamType(S, AT.getElementType(), new SourceLocation(Loc));
      return;
    }
    
    $c$.clean($c$.track(S.Diag(new SourceLocation(Loc), diag.err_array_star_in_function_definition)));
  } finally {
    $c$.$destroy();
  }
}


/// \brief Check whether this array fits the idiom of a size-one tail padded
/// array member of a struct.
///
/// We avoid emitting out-of-bounds access warnings for such arrays as they are
/// commonly used to emulate flexible arrays in C89 code.
//<editor-fold defaultstate="collapsed" desc="IsTailPaddedMemberArray">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9556,
 FQN="IsTailPaddedMemberArray", NM="_ZL23IsTailPaddedMemberArrayRN5clang4SemaERKN4llvm5APIntEPKNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL23IsTailPaddedMemberArrayRN5clang4SemaERKN4llvm5APIntEPKNS_9NamedDeclE")
//</editor-fold>
public static boolean IsTailPaddedMemberArray(final Sema /*&*/ S, final /*const*/ APInt /*&*/ Size, 
                       /*const*/ NamedDecl /*P*/ ND) {
  if (Size.$noteq(1) || !(ND != null)) {
    return false;
  }
  
  /*const*/ FieldDecl /*P*/ FD = dyn_cast_FieldDecl(ND);
  if (!(FD != null)) {
    return false;
  }
  
  // Don't consider sizes resulting from macro expansions or template argument
  // substitution to form C89 tail-padded arrays.
  TypeSourceInfo /*P*/ TInfo = FD.getTypeSourceInfo();
  while ((TInfo != null)) {
    TypeLoc TL = TInfo.getTypeLoc();
    {
      // Look through typedefs.
      TypedefTypeLoc TTL = TL.getAs(TypedefTypeLoc.class);
      if (TTL.$bool()) {
        /*const*/ TypedefNameDecl /*P*/ TDL = TTL.getTypedefNameDecl();
        TInfo = TDL.getTypeSourceInfo();
        continue;
      }
    }
    {
      ConstantArrayTypeLoc CTL = TL.getAs(ConstantArrayTypeLoc.class);
      if (CTL.$bool()) {
        /*const*/ Expr /*P*/ SizeExpr = dyn_cast_IntegerLiteral(CTL.getSizeExpr());
        if (!(SizeExpr != null) || SizeExpr.getExprLoc().isMacroID()) {
          return false;
        }
      }
    }
    break;
  }
  
  /*const*/ RecordDecl /*P*/ RD = dyn_cast_RecordDecl(FD.getDeclContext$Const());
  if (!(RD != null)) {
    return false;
  }
  if (RD.isUnion()) {
    return false;
  }
  {
    /*const*/ CXXRecordDecl /*P*/ CRD = dyn_cast_CXXRecordDecl(RD);
    if ((CRD != null)) {
      if (!CRD.isStandardLayout()) {
        return false;
      }
    }
  }
  
  // See if this is the last field decl in the record.
  /*const*/ Decl /*P*/ D = FD;
  while (((D = D.getNextDeclInContext$Const()) != null)) {
    if (isa_FieldDecl(D)) {
      return false;
    }
  }
  return true;
}

// end anonymous namespace

/// Consider whether capturing the given variable can possibly lead to
/// a retain cycle.
//<editor-fold defaultstate="collapsed" desc="considerVariable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9784,
 FQN="considerVariable", NM="_ZL16considerVariablePN5clang7VarDeclEPNS_4ExprERN12_GLOBAL__N_116RetainCycleOwnerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL16considerVariablePN5clang7VarDeclEPNS_4ExprERN12_GLOBAL__N_116RetainCycleOwnerE")
//</editor-fold>
public static boolean considerVariable(VarDecl /*P*/ var, Expr /*P*/ ref, final RetainCycleOwner /*&*/ owner) {
  // In ARC, it's captured strongly iff the variable has __strong
  // lifetime.  In MRR, it's captured strongly if the variable is
  // __block and has an appropriate type.
  if (var.getType().getObjCLifetime() != Qualifiers.ObjCLifetime.OCL_Strong) {
    return false;
  }
  
  owner.Variable = var;
  if ((ref != null)) {
    owner.setLocsFrom(ref);
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="findRetainCycleOwner">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9797,
 FQN="findRetainCycleOwner", NM="_ZL20findRetainCycleOwnerRN5clang4SemaEPNS_4ExprERN12_GLOBAL__N_116RetainCycleOwnerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL20findRetainCycleOwnerRN5clang4SemaEPNS_4ExprERN12_GLOBAL__N_116RetainCycleOwnerE")
//</editor-fold>
public static boolean findRetainCycleOwner(final Sema /*&*/ S, Expr /*P*/ e, final RetainCycleOwner /*&*/ owner) {
  while (true) {
    e = e.IgnoreParens();
    {
      CastExpr /*P*/ cast = dyn_cast_CastExpr(e);
      if ((cast != null)) {
        switch (cast.getCastKind()) {
         case CK_BitCast:
         case CK_LValueBitCast:
         case CK_LValueToRValue:
         case CK_ARCReclaimReturnedObject:
          e = cast.getSubExpr();
          continue;
         default:
          return false;
        }
      }
    }
    {
      
      ObjCIvarRefExpr /*P*/ ref = dyn_cast_ObjCIvarRefExpr(e);
      if ((ref != null)) {
        ObjCIvarDecl /*P*/ ivar = ref.getDecl();
        if (ivar.getType().getObjCLifetime() != Qualifiers.ObjCLifetime.OCL_Strong) {
          return false;
        }
        
        // Try to find a retain cycle in the base.
        if (!findRetainCycleOwner(S, ref.getBase(), owner)) {
          return false;
        }
        if (ref.isFreeIvar()) {
          owner.setLocsFrom(ref);
        }
        owner.Indirect = true;
        return true;
      }
    }
    {
      
      DeclRefExpr /*P*/ ref = dyn_cast_DeclRefExpr(e);
      if ((ref != null)) {
        VarDecl /*P*/ var = dyn_cast_VarDecl(ref.getDecl());
        if (!(var != null)) {
          return false;
        }
        return considerVariable(var, ref, owner);
      }
    }
    {
      
      MemberExpr /*P*/ member = dyn_cast_MemberExpr(e);
      if ((member != null)) {
        if (member.isArrow()) {
          return false;
        }
        
        // Don't count this as an indirect ownership.
        e = member.getBase();
        continue;
      }
    }
    {
      
      PseudoObjectExpr /*P*/ pseudo = dyn_cast_PseudoObjectExpr(e);
      if ((pseudo != null)) {
        // Only pay attention to pseudo-objects on property references.
        ObjCPropertyRefExpr /*P*/ pre = dyn_cast_ObjCPropertyRefExpr(pseudo.getSyntacticForm().
    IgnoreParens());
        if (!(pre != null)) {
          return false;
        }
        if (pre.isImplicitProperty()) {
          return false;
        }
        ObjCPropertyDecl /*P*/ property = pre.getExplicitProperty();
        if (!property.isRetaining()
           && !((property.getPropertyIvarDecl() != null)
           && property.getPropertyIvarDecl().getType().
            getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Strong)) {
          return false;
        }
        
        owner.Indirect = true;
        if (pre.isSuperReceiver()) {
          owner.Variable = S.getCurMethodDecl().getSelfDecl();
          if (!(owner.Variable != null)) {
            return false;
          }
          owner.Loc.$assignMove(pre.getLocation());
          owner.Range.$assignMove(pre.getSourceRange());
          return true;
        }
        e = ((/*const_cast*/Expr /*P*/ )(cast_OpaqueValueExpr(pre.getBase()).
            getSourceExpr()));
        continue;
      }
    }
    
    // Array ivars?
    return false;
  }
}

// end anonymous namespace

/// Check whether the given argument is a block which captures a
/// variable.
//<editor-fold defaultstate="collapsed" desc="findCapturingExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9930,
 FQN="findCapturingExpr", NM="_ZL17findCapturingExprRN5clang4SemaEPNS_4ExprERN12_GLOBAL__N_116RetainCycleOwnerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL17findCapturingExprRN5clang4SemaEPNS_4ExprERN12_GLOBAL__N_116RetainCycleOwnerE")
//</editor-fold>
public static Expr /*P*/ findCapturingExpr(final Sema /*&*/ S, Expr /*P*/ e, final RetainCycleOwner /*&*/ owner) {
  assert ((owner.Variable != null) && owner.Loc.isValid());
  
  e = e.IgnoreParenCasts();
  {
    
    // Look through [^{...} copy] and Block_copy(^{...}).
    ObjCMessageExpr /*P*/ ME = dyn_cast_ObjCMessageExpr(e);
    if ((ME != null)) {
      Selector Cmd = ME.getSelector();
      if (Cmd.isUnarySelector() && $eq_StringRef(Cmd.getNameForSlot(0), /*STRINGREF_STR*/"copy")) {
        e = ME.getInstanceReceiver();
        if (!(e != null)) {
          return null;
        }
        e = e.IgnoreParenCasts();
      }
    } else {
      CallExpr /*P*/ CE = dyn_cast_CallExpr(e);
      if ((CE != null)) {
        if (CE.getNumArgs() == 1) {
          FunctionDecl /*P*/ Fn = dyn_cast_or_null_FunctionDecl(CE.getCalleeDecl());
          if ((Fn != null)) {
            /*const*/ IdentifierInfo /*P*/ FnI = Fn.getIdentifier();
            if ((FnI != null) && FnI.isStr(/*KEEP_STR*/"_Block_copy")) {
              e = CE.getArg(0).IgnoreParenCasts();
            }
          }
        }
      }
    }
  }
  
  BlockExpr /*P*/ block = dyn_cast_BlockExpr(e);
  if (!(block != null) || !block.getBlockDecl().capturesVariable(owner.Variable)) {
    return null;
  }
  
  FindCaptureVisitor visitor/*J*/= new FindCaptureVisitor(S.Context, owner.Variable);
  visitor.Visit(block.getBlockDecl().getBody());
  return visitor.VarWillBeReased ? null : visitor.Capturer;
}

//<editor-fold defaultstate="collapsed" desc="diagnoseRetainCycle">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9965,
 FQN="diagnoseRetainCycle", NM="_ZL19diagnoseRetainCycleRN5clang4SemaEPNS_4ExprERN12_GLOBAL__N_116RetainCycleOwnerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL19diagnoseRetainCycleRN5clang4SemaEPNS_4ExprERN12_GLOBAL__N_116RetainCycleOwnerE")
//</editor-fold>
public static void diagnoseRetainCycle(final Sema /*&*/ S, Expr /*P*/ capturer, 
                   final RetainCycleOwner /*&*/ owner) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert Native.$bool(capturer);
    assert ((owner.Variable != null) && owner.Loc.isValid());
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(capturer.getExprLoc(), diag.warn_arc_retain_cycle)), 
            owner.Variable), capturer.getSourceRange()));
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(owner.Loc), diag.note_arc_retain_cycle_owner)), 
            owner.Indirect), owner.Range));
  } finally {
    $c$.$destroy();
  }
}


/// Check for a keyword selector that starts with the word 'add' or
/// 'set'.
//<editor-fold defaultstate="collapsed" desc="isSetterLikeSelector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9978,
 FQN="isSetterLikeSelector", NM="_ZL20isSetterLikeSelectorN5clang8SelectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL20isSetterLikeSelectorN5clang8SelectorE")
//</editor-fold>
public static boolean isSetterLikeSelector(Selector sel) {
  if (sel.isUnarySelector()) {
    return false;
  }
  
  StringRef str = sel.getNameForSlot(0);
  while (!str.empty() && str.front() == $$UNDERSCORE) {
    str.$assignMove(str.substr(1));
  }
  if (str.startswith(/*STRINGREF_STR*/"set")) {
    str.$assignMove(str.substr(3));
  } else if (str.startswith(/*STRINGREF_STR*/"add")) {
    // Specially whitelist 'addOperationWithBlock:'.
    if (sel.getNumArgs() == 1 && str.startswith(/*STRINGREF_STR*/"addOperationWithBlock")) {
      return false;
    }
    str.$assignMove(str.substr(3));
  } else {
    return false;
  }
  if (str.empty()) {
    return true;
  }
  return !isLowercase(str.front());
}

//<editor-fold defaultstate="collapsed" desc="GetNSMutableArrayArgumentIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9998,
 FQN="GetNSMutableArrayArgumentIndex", NM="_ZL30GetNSMutableArrayArgumentIndexRN5clang4SemaEPNS_15ObjCMessageExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL30GetNSMutableArrayArgumentIndexRN5clang4SemaEPNS_15ObjCMessageExprE")
//</editor-fold>
public static OptionalInt GetNSMutableArrayArgumentIndex(final Sema /*&*/ S, 
                              ObjCMessageExpr /*P*/ Message) {
  boolean IsMutableArray = S.NSAPIObj.$arrow().isSubclassOfNSClass(Message.getReceiverInterface(), 
      NSAPI.NSClassIdKindKind.ClassId_NSMutableArray);
  if (!IsMutableArray) {
    return new OptionalInt(None);
  }
  
  Selector Sel = Message.getSelector();
  
  Optional<NSAPI.NSArrayMethodKind> MKOpt = S.NSAPIObj.$arrow().getNSArrayMethodKind(new Selector(Sel));
  if (!MKOpt.$bool()) {
    return new OptionalInt(None);
  }
  
  NSAPI.NSArrayMethodKind MK = MKOpt.$star();
  switch (MK) {
   case NSMutableArr_addObject:
   case NSMutableArr_insertObjectAtIndex:
   case NSMutableArr_setObjectAtIndexedSubscript:
    return new OptionalInt(JD$T$RR.INSTANCE, 0);
   case NSMutableArr_replaceObjectAtIndex:
    return new OptionalInt(JD$T$RR.INSTANCE, 1);
   default:
    return new OptionalInt(None);
  }
  
  //return new OptionalInt(None);
}

//<editor-fold defaultstate="collapsed" desc="GetNSMutableDictionaryArgumentIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10032,
 FQN="GetNSMutableDictionaryArgumentIndex", NM="_ZL35GetNSMutableDictionaryArgumentIndexRN5clang4SemaEPNS_15ObjCMessageExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL35GetNSMutableDictionaryArgumentIndexRN5clang4SemaEPNS_15ObjCMessageExprE")
//</editor-fold>
public static OptionalInt GetNSMutableDictionaryArgumentIndex(final Sema /*&*/ S, 
                                   ObjCMessageExpr /*P*/ Message) {
  boolean IsMutableDictionary = S.NSAPIObj.$arrow().isSubclassOfNSClass(Message.getReceiverInterface(), 
      NSAPI.NSClassIdKindKind.ClassId_NSMutableDictionary);
  if (!IsMutableDictionary) {
    return new OptionalInt(None);
  }
  
  Selector Sel = Message.getSelector();
  
  Optional<NSAPI.NSDictionaryMethodKind> MKOpt = S.NSAPIObj.$arrow().getNSDictionaryMethodKind(new Selector(Sel));
  if (!MKOpt.$bool()) {
    return new OptionalInt(None);
  }
  
  NSAPI.NSDictionaryMethodKind MK = MKOpt.$star();
  switch (MK) {
   case NSMutableDict_setObjectForKey:
   case NSMutableDict_setValueForKey:
   case NSMutableDict_setObjectForKeyedSubscript:
    return new OptionalInt(JD$T$RR.INSTANCE, 0);
   default:
    return new OptionalInt(None);
  }
  
  //return new OptionalInt(None);
}

//<editor-fold defaultstate="collapsed" desc="GetNSSetArgumentIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10065,
 FQN="GetNSSetArgumentIndex", NM="_ZL21GetNSSetArgumentIndexRN5clang4SemaEPNS_15ObjCMessageExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL21GetNSSetArgumentIndexRN5clang4SemaEPNS_15ObjCMessageExprE")
//</editor-fold>
public static OptionalInt GetNSSetArgumentIndex(final Sema /*&*/ S, ObjCMessageExpr /*P*/ Message) {
  boolean IsMutableSet = S.NSAPIObj.$arrow().isSubclassOfNSClass(Message.getReceiverInterface(), 
      NSAPI.NSClassIdKindKind.ClassId_NSMutableSet);
  
  boolean IsMutableOrderedSet = S.NSAPIObj.$arrow().isSubclassOfNSClass(Message.getReceiverInterface(), 
      NSAPI.NSClassIdKindKind.ClassId_NSMutableOrderedSet);
  if (!IsMutableSet && !IsMutableOrderedSet) {
    return new OptionalInt(None);
  }
  
  Selector Sel = Message.getSelector();
  
  Optional<NSAPI.NSSetMethodKind> MKOpt = S.NSAPIObj.$arrow().getNSSetMethodKind(new Selector(Sel));
  if (!MKOpt.$bool()) {
    return new OptionalInt(None);
  }
  
  NSAPI.NSSetMethodKind MK = MKOpt.$star();
  switch (MK) {
   case NSMutableSet_addObject:
   case NSOrderedSet_setObjectAtIndex:
   case NSOrderedSet_setObjectAtIndexedSubscript:
   case NSOrderedSet_insertObjectAtIndex:
    return new OptionalInt(JD$T$RR.INSTANCE, 0);
   case NSOrderedSet_replaceObjectAtIndexWithObject:
    return new OptionalInt(JD$T$RR.INSTANCE, 1);
  }
  
  return new OptionalInt(None);
}

//<editor-fold defaultstate="collapsed" desc="checkUnsafeAssignLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10212,
 FQN="checkUnsafeAssignLiteral", NM="_ZL24checkUnsafeAssignLiteralRN5clang4SemaENS_14SourceLocationEPNS_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL24checkUnsafeAssignLiteralRN5clang4SemaENS_14SourceLocationEPNS_4ExprEb")
//</editor-fold>
public static boolean checkUnsafeAssignLiteral(final Sema /*&*/ S, SourceLocation Loc, 
                        Expr /*P*/ RHS, boolean isProperty) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Check if RHS is an Objective-C object literal, which also can get
    // immediately zapped in a weak reference.  Note that we explicitly
    // allow ObjCStringLiterals, since those are designed to never really die.
    RHS = RHS.IgnoreParenImpCasts();
    
    // This enum needs to match with the 'select' in
    // warn_objc_arc_literal_assign (off-by-1).
    Sema.ObjCLiteralKind Kind = S.CheckLiteralKind(RHS);
    if (Kind == Sema.ObjCLiteralKind.LK_String || Kind == Sema.ObjCLiteralKind.LK_None) {
      return false;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.warn_arc_literal_assign)), 
                (/*uint*/int)Kind.getValue()), 
            (isProperty ? 0 : 1)), 
        RHS.getSourceRange()));
    
    return true;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="checkUnsafeAssignObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10233,
 FQN="checkUnsafeAssignObject", NM="_ZL23checkUnsafeAssignObjectRN5clang4SemaENS_14SourceLocationENS_10Qualifiers12ObjCLifetimeEPNS_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZL23checkUnsafeAssignObjectRN5clang4SemaENS_14SourceLocationENS_10Qualifiers12ObjCLifetimeEPNS_4ExprEb")
//</editor-fold>
public static boolean checkUnsafeAssignObject(final Sema /*&*/ S, SourceLocation Loc, 
                       Qualifiers.ObjCLifetime LT, 
                       Expr /*P*/ RHS, boolean isProperty) {
  {
    // Strip off any implicit cast added to get to the one ARC-specific.
    ImplicitCastExpr /*P*/ cast;
    while (((/*P*/ cast = dyn_cast_ImplicitCastExpr(RHS)) != null)) {
      if (cast.getCastKind() == CastKind.CK_ARCConsumeObject) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.warn_arc_retained_assign)), 
                      (LT == Qualifiers.ObjCLifetime.OCL_ExplicitNone)), 
                  (isProperty ? 0 : 1)), 
              RHS.getSourceRange()));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
      RHS = cast.getSubExpr();
    }
  }
  if (LT == Qualifiers.ObjCLifetime.OCL_Weak
     && checkUnsafeAssignLiteral(S, new SourceLocation(Loc), RHS, isProperty)) {
    return true;
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ShouldDiagnoseEmptyStmtBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10334,
 FQN="(anonymous namespace)::ShouldDiagnoseEmptyStmtBody", NM="_ZN12_GLOBAL__N_127ShouldDiagnoseEmptyStmtBodyERKN5clang13SourceManagerENS0_14SourceLocationEPKNS0_8NullStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_127ShouldDiagnoseEmptyStmtBodyERKN5clang13SourceManagerENS0_14SourceLocationEPKNS0_8NullStmtE")
//</editor-fold>
public static boolean ShouldDiagnoseEmptyStmtBody(final /*const*/ SourceManager /*&*/ SourceMgr, 
                           SourceLocation StmtLoc, 
                           /*const*/ NullStmt /*P*/ Body) {
  // Do not warn if the body is a macro that expands to nothing, e.g:
  //
  // #define CALL(x)
  // if (condition)
  //   CALL(0);
  //
  if (Body.hasLeadingEmptyMacro()) {
    return false;
  }
  
  // Get line numbers of statement and body.
  bool$ptr StmtLineInvalid = create_bool$ptr();
  /*uint*/int StmtLine = SourceMgr.getPresumedLineNumber(/*NO_COPY*/StmtLoc, 
      StmtLineInvalid);
  if (StmtLineInvalid.$star()) {
    return false;
  }
  
  bool$ptr BodyLineInvalid = create_bool$ptr();
  /*uint*/int BodyLine = SourceMgr.getSpellingLineNumber(Body.getSemiLoc(), 
      BodyLineInvalid);
  if (BodyLineInvalid.$star()) {
    return false;
  }
  
  // Warn if null statement and body are on the same line.
  if (StmtLine != BodyLine) {
    return false;
  }
  
  return true;
}


/// \brief Check if two types are layout-compatible in C++11 sense.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isLayoutCompatible">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10665,
 FQN="(anonymous namespace)::isLayoutCompatible", NM="_ZN12_GLOBAL__N_118isLayoutCompatibleERN5clang10ASTContextENS0_8QualTypeES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118isLayoutCompatibleERN5clang10ASTContextENS0_8QualTypeES3_")
//</editor-fold>
public static boolean isLayoutCompatible(final ASTContext /*&*/ C, QualType T1, QualType T2) {
  if (T1.isNull() || T2.isNull()) {
    return false;
  }
  
  // C++11 [basic.types] p11:
  // If two types T1 and T2 are the same type, then T1 and T2 are
  // layout-compatible types.
  if (C.hasSameType(new QualType(T1), new QualType(T2))) {
    return true;
  }
  
  T1.$assignMove(T1.getCanonicalType().getUnqualifiedType());
  T2.$assignMove(T2.getCanonicalType().getUnqualifiedType());
  
  /*const*/ Type.TypeClass TC1 = T1.$arrow().getTypeClass();
  /*const*/ Type.TypeClass TC2 = T2.$arrow().getTypeClass();
  if (TC1 != TC2) {
    return false;
  }
  if (TC1 == Type.TypeClass.Enum) {
    return isLayoutCompatible(C, 
        cast_EnumType(T1).getDecl(), 
        cast_EnumType(T2).getDecl());
  } else if (TC1 == Type.TypeClass.Record) {
    if (!T1.$arrow().isStandardLayoutType() || !T2.$arrow().isStandardLayoutType()) {
      return false;
    }
    
    return isLayoutCompatible(C, 
        cast_RecordType(T1).getDecl(), 
        cast_RecordType(T2).getDecl());
  }
  
  return false;
}


/// \brief Check if two enumeration types are layout-compatible.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isLayoutCompatible">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10552,
 FQN="(anonymous namespace)::isLayoutCompatible", NM="_ZN12_GLOBAL__N_118isLayoutCompatibleERN5clang10ASTContextEPNS0_8EnumDeclES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118isLayoutCompatibleERN5clang10ASTContextEPNS0_8EnumDeclES4_")
//</editor-fold>
public static boolean isLayoutCompatible(final ASTContext /*&*/ C, EnumDecl /*P*/ ED1, EnumDecl /*P*/ ED2) {
  // C++11 [dcl.enum] p8:
  // Two enumeration types are layout-compatible if they have the same
  // underlying type.
  return ED1.isComplete() && ED2.isComplete()
     && C.hasSameType(ED1.getIntegerType(), ED2.getIntegerType());
}


/// \brief Check if two fields are layout-compatible.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isLayoutCompatible">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10561,
 FQN="(anonymous namespace)::isLayoutCompatible", NM="_ZN12_GLOBAL__N_118isLayoutCompatibleERN5clang10ASTContextEPNS0_9FieldDeclES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118isLayoutCompatibleERN5clang10ASTContextEPNS0_9FieldDeclES4_")
//</editor-fold>
public static boolean isLayoutCompatible(final ASTContext /*&*/ C, FieldDecl /*P*/ Field1, FieldDecl /*P*/ Field2) {
  if (!isLayoutCompatible(C, Field1.getType(), Field2.getType())) {
    return false;
  }
  if (Field1.isBitField() != Field2.isBitField()) {
    return false;
  }
  if (Field1.isBitField()) {
    // Make sure that the bit-fields are the same length.
    /*uint*/int Bits1 = Field1.getBitWidthValue(C);
    /*uint*/int Bits2 = Field2.getBitWidthValue(C);
    if (Bits1 != Bits2) {
      return false;
    }
  }
  
  return true;
}


/// \brief Check if two standard-layout structs are layout-compatible.
/// (C++11 [class.mem] p17)
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isLayoutCompatibleStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10582,
 FQN="(anonymous namespace)::isLayoutCompatibleStruct", NM="_ZN12_GLOBAL__N_124isLayoutCompatibleStructERN5clang10ASTContextEPNS0_10RecordDeclES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_124isLayoutCompatibleStructERN5clang10ASTContextEPNS0_10RecordDeclES4_")
//</editor-fold>
public static boolean isLayoutCompatibleStruct(final ASTContext /*&*/ C, 
                        RecordDecl /*P*/ RD1, 
                        RecordDecl /*P*/ RD2) {
  {
    // If both records are C++ classes, check that base classes match.
    /*const*/ CXXRecordDecl /*P*/ D1CXX = dyn_cast_CXXRecordDecl(RD1);
    if ((D1CXX != null)) {
      // If one of records is a CXXRecordDecl we are in C++ mode,
      // thus the other one is a CXXRecordDecl, too.
      /*const*/ CXXRecordDecl /*P*/ D2CXX = cast_CXXRecordDecl(RD2);
      // Check number of base classes.
      if (D1CXX.getNumBases() != D2CXX.getNumBases()) {
        return false;
      }
      
      // Check the base classes.
      for (type$ptr</*const*/ CXXBaseSpecifier /*P*/ > Base1 = $tryClone(D1CXX.bases_begin$Const()), 
          /*P*/ BaseEnd1 = $tryClone(D1CXX.bases_end$Const()), 
          /*P*/ Base2 = $tryClone(D2CXX.bases_begin$Const());
           $noteq_ptr(Base1, BaseEnd1);
           Base1.$preInc() , Base2.$preInc()) {
        if (!isLayoutCompatible(C, Base1./*->*/$star().getType(), Base2./*->*/$star().getType())) {
          return false;
        }
      }
    } else {
      /*const*/ CXXRecordDecl /*P*/ D2CXX = dyn_cast_CXXRecordDecl(RD2);
      if ((D2CXX != null)) {
        // If only RD2 is a C++ class, it should have zero base classes.
        if ($greater_uint(D2CXX.getNumBases(), 0)) {
          return false;
        }
      }
    }
  }
  
  // Check the fields.
  specific_decl_iterator<FieldDecl> Field2 = RD2.field_begin(), 
      Field2End = RD2.field_end(), 
      Field1 = RD1.field_begin(), 
      Field1End = RD1.field_end();
  for (; $noteq_specific_decl_iterator$SpecificDecl$C(Field1, Field1End) && $noteq_specific_decl_iterator$SpecificDecl$C(Field2, Field2End); Field1.$preInc() , Field2.$preInc()) {
    if (!isLayoutCompatible(C, Field1.$star(), Field2.$star())) {
      return false;
    }
  }
  if ($noteq_specific_decl_iterator$SpecificDecl$C(Field1, Field1End) || $noteq_specific_decl_iterator$SpecificDecl$C(Field2, Field2End)) {
    return false;
  }
  
  return true;
}


/// \brief Check if two standard-layout unions are layout-compatible.
/// (C++11 [class.mem] p18)
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isLayoutCompatibleUnion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10627,
 FQN="(anonymous namespace)::isLayoutCompatibleUnion", NM="_ZN12_GLOBAL__N_123isLayoutCompatibleUnionERN5clang10ASTContextEPNS0_10RecordDeclES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_123isLayoutCompatibleUnionERN5clang10ASTContextEPNS0_10RecordDeclES4_")
//</editor-fold>
public static boolean isLayoutCompatibleUnion(final ASTContext /*&*/ C, 
                       RecordDecl /*P*/ RD1, 
                       RecordDecl /*P*/ RD2) {
  SmallPtrSet<FieldDecl /*P*/ > UnmatchedFields/*J*/= new SmallPtrSet<FieldDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
  for (FieldDecl /*P*/ Field2 : RD2.fields())  {
    UnmatchedFields.insert(Field2);
  }
  
  for (FieldDecl /*P*/ Field1 : RD1.fields()) {
    SmallPtrSetIterator<FieldDecl /*P*/ > I = UnmatchedFields.begin(), 
        E = UnmatchedFields.end();
    
    for (; I.$noteq(E); I.$preInc()) {
      if (isLayoutCompatible(C, Field1, I.$star())) {
        boolean Result = UnmatchedFields.erase(I.$star());
        //(void)Result;
        assert (Result);
        break;
      }
    }
    if (I.$eq(E)) {
      return false;
    }
  }
  
  return UnmatchedFields.empty();
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isLayoutCompatible">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10654,
 FQN="(anonymous namespace)::isLayoutCompatible", NM="_ZN12_GLOBAL__N_118isLayoutCompatibleERN5clang10ASTContextEPNS0_10RecordDeclES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118isLayoutCompatibleERN5clang10ASTContextEPNS0_10RecordDeclES4_")
//</editor-fold>
public static boolean isLayoutCompatible(final ASTContext /*&*/ C, RecordDecl /*P*/ RD1, RecordDecl /*P*/ RD2) {
  if (RD1.isUnion() != RD2.isUnion()) {
    return false;
  }
  if (RD1.isUnion()) {
    return isLayoutCompatibleUnion(C, RD1, RD2);
  } else {
    return isLayoutCompatibleStruct(C, RD1, RD2);
  }
}

/// \brief Given a type tag expression find the type tag itself.
///
/// \param TypeExpr Type tag expression, as it appears in user's code.
///
/// \param VD Declaration of an identifier that appears in a type tag.
///
/// \param MagicValue Type tag magic value.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindTypeTagExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10711,
 FQN="(anonymous namespace)::FindTypeTagExpr", NM="_ZN12_GLOBAL__N_115FindTypeTagExprEPKN5clang4ExprERKNS0_10ASTContextEPPKNS0_9ValueDeclEPy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115FindTypeTagExprEPKN5clang4ExprERKNS0_10ASTContextEPPKNS0_9ValueDeclEPy")
//</editor-fold>
public static boolean FindTypeTagExpr(/*const*/ Expr /*P*/ TypeExpr, final /*const*/ ASTContext /*&*/ Ctx, 
               /*const*/type$ptr</*const*/ ValueDecl /*P*/ > VD, ulong$ptr/*uint64_t P*/ MagicValue) {
  while (true) {
    if (!(TypeExpr != null)) {
      return false;
    }
    
    TypeExpr = TypeExpr.IgnoreParenImpCasts$Const().IgnoreParenCasts$Const();
    switch (TypeExpr.getStmtClass()) {
     case UnaryOperatorClass:
      {
        /*const*/ UnaryOperator /*P*/ UO = cast_UnaryOperator(TypeExpr);
        if (UO.getOpcode() == UnaryOperatorKind.UO_AddrOf || UO.getOpcode() == UnaryOperatorKind.UO_Deref) {
          TypeExpr = UO.getSubExpr();
          continue;
        }
        return false;
      }
     case DeclRefExprClass:
      {
        /*const*/ DeclRefExpr /*P*/ DRE = cast_DeclRefExpr(TypeExpr);
        VD.$set(DRE.getDecl$Const());
        return true;
      }
     case IntegerLiteralClass:
      {
        /*const*/ IntegerLiteral /*P*/ IL = cast_IntegerLiteral(TypeExpr);
        APInt MagicValueAPInt = IL.getValue();
        if ($lesseq_uint(MagicValueAPInt.getActiveBits(), 64)) {
          MagicValue.$set(MagicValueAPInt.getZExtValue());
          return true;
        } else {
          return false;
        }
      }
     case BinaryConditionalOperatorClass:
     case ConditionalOperatorClass:
      {
        /*const*/ AbstractConditionalOperator /*P*/ ACO = cast_AbstractConditionalOperator(TypeExpr);
        bool$ref Result = create_bool$ref();
        if (ACO.getCond().EvaluateAsBooleanCondition(Result, Ctx)) {
          if (Result.$deref()) {
            TypeExpr = ACO.getTrueExpr();
          } else {
            TypeExpr = ACO.getFalseExpr();
          }
          continue;
        }
        return false;
      }
     case BinaryOperatorClass:
      {
        /*const*/ BinaryOperator /*P*/ BO = cast_BinaryOperator(TypeExpr);
        if (BO.getOpcode() == BinaryOperatorKind.BO_Comma) {
          TypeExpr = BO.getRHS();
          continue;
        }
        return false;
      }
     default:
      return false;
    }
  }
}


/// \brief Retrieve the C type corresponding to type tag TypeExpr.
///
/// \param TypeExpr Expression that specifies a type tag.
///
/// \param MagicValues Registered magic values.
///
/// \param FoundWrongKind Set to true if a type tag was found, but of a wrong
///        kind.
///
/// \param TypeInfo Information about the corresponding C type.
///
/// \returns true if the corresponding C type was found.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetMatchingCType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10787,
 FQN="(anonymous namespace)::GetMatchingCType", NM="_ZN12_GLOBAL__N_116GetMatchingCTypeEPKN5clang14IdentifierInfoEPKNS0_4ExprERKNS0_10ASTContextEPKN4llvm8DenseMapISt4pairIS3_yENS0_4Sema11TypeTagDataENSA_12DenseMapInfoISD_EENSA_6detail12DenseMapPairISD_SF_EEEERbRSF_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_116GetMatchingCTypeEPKN5clang14IdentifierInfoEPKNS0_4ExprERKNS0_10ASTContextEPKN4llvm8DenseMapISt4pairIS3_yENS0_4Sema11TypeTagDataENSA_12DenseMapInfoISD_EENSA_6detail12DenseMapPairISD_SF_EEEERbRSF_")
//</editor-fold>
public static boolean GetMatchingCType(/*const*/ IdentifierInfo /*P*/ ArgumentKind, 
                /*const*/ Expr /*P*/ TypeExpr, final /*const*/ ASTContext /*&*/ Ctx, 
                /*const*/DenseMap<std.pairTypeULong</*const*/ IdentifierInfo /*P*/ >, Sema.TypeTagData> /*P*/ MagicValues, 
                final bool$ref/*bool &*/ FoundWrongKind, 
                final Sema.TypeTagData /*&*/ TypeInfo) {
  FoundWrongKind.$set(false);
  
  // Variable declaration that has type_tag_for_datatype attribute.
  type$ptr</*const*/ ValueDecl /*P*/ > VD = create_type$ptr((ValueDecl)null);
  
  ulong$ptr MagicValue = create_ulong$ptr();
  if (!FindTypeTagExpr(TypeExpr, Ctx, VD, MagicValue)) {
    return false;
  }
  if ((VD.$star() != null)) {
    {
      TypeTagForDatatypeAttr /*P*/ I = VD.$star().getAttr(TypeTagForDatatypeAttr.class);
      if ((I != null)) {
        if (I.getArgumentKind() != ArgumentKind) {
          FoundWrongKind.$set(true);
          return false;
        }
        TypeInfo.Type.$assignMove(I.getMatchingCType());
        TypeInfo.LayoutCompatible = I.getLayoutCompatible();
        TypeInfo.MustBeNull = I.getMustBeNull();
        return true;
      }
    }
    return false;
  }
  if (!(MagicValues != null)) {
    return false;
  }

  DenseMapIterator<std.pairTypeULong</*const*/ IdentifierInfo /*P*/ >, Sema.TypeTagData> I = MagicValues.find$Const(std.make_pair_Ptr_ulong(ArgumentKind, MagicValue.$star()));
  if (I.$eq(MagicValues.end$Const())) {
    return false;
  }
  
  TypeInfo.$assign(I.$arrow().second);
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IsSameCharType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10846,
 FQN="(anonymous namespace)::IsSameCharType", NM="_ZN12_GLOBAL__N_114IsSameCharTypeEN5clang8QualTypeES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_114IsSameCharTypeEN5clang8QualTypeES1_")
//</editor-fold>
public static boolean IsSameCharType(QualType T1, QualType T2) {
  /*const*/ BuiltinType /*P*/ BT1 = T1.$arrow().<BuiltinType>getAs$BuiltinType();
  if (!(BT1 != null)) {
    return false;
  }
  
  /*const*/ BuiltinType /*P*/ BT2 = T2.$arrow().<BuiltinType>getAs$BuiltinType();
  if (!(BT2 != null)) {
    return false;
  }
  
  BuiltinType.Kind T1Kind = BT1.getKind();
  BuiltinType.Kind T2Kind = BT2.getKind();
  
  return (T1Kind == BuiltinType.Kind.SChar && T2Kind == BuiltinType.Kind.Char_S)
     || (T1Kind == BuiltinType.Kind.UChar && T2Kind == BuiltinType.Kind.Char_U)
     || (T1Kind == BuiltinType.Kind.Char_U && T2Kind == BuiltinType.Kind.UChar)
     || (T1Kind == BuiltinType.Kind.Char_S && T2Kind == BuiltinType.Kind.SChar);
}

} // END OF class SemaCheckingStatics
