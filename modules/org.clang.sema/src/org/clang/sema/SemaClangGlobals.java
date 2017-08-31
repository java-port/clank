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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
;
import org.clang.basic.*;
import org.clang.clangc.*;
import static org.clang.sema.SemaClangGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_Z5clang_CodeCompleteConsumer_h_Unnamed_enum;_Z5clang_CodeCompleteConsumer_h_Unnamed_enum1;_Z5clang_CodeCompleteConsumer_h_Unnamed_enum2;_ZN5clang10getDLLAttrEPNS_4DeclE;_ZN5clang13AssertSuccessENS_12ActionResultIPNS_4ExprELb1EEE;_ZN5clang13AssertSuccessENS_12ActionResultIPNS_4StmtELb1EEE;_ZN5clang16getDeclUsageTypeERNS_10ASTContextEPKNS_9NamedDeclE;_ZN5clang17GetConversionRankENS_22ImplicitConversionKindE;_ZN5clang18MarkVarDeclODRUsedEPNS_7VarDeclENS_14SourceLocationERNS_4SemaEPKj;_ZN5clang18getConstructorInfoEPNS_9NamedDeclE;_ZN5clang20getCursorKindForDeclEPKNS_4DeclE;_ZN5clang21getMacroUsagePriorityEN4llvm9StringRefERKNS_11LangOptionsEb;_ZN5clang22DeclAttrsMatchCUDAModeERKNS_11LangOptionsEPNS_4DeclE;_ZN5clang22getSimplifiedTypeClassENS_7CanQualINS_4TypeEEE;_ZN5clang22getTemplateParamsRangeEPKPKNS_21TemplateParameterListEj;_ZN5clang23FTIHasNonVoidParametersERKNS_15DeclaratorChunk16FunctionTypeInfoE;_ZN5clang24MakeDeductionFailureInfoERNS_10ASTContextENS_4Sema23TemplateDeductionResultERNS_4sema21TemplateDeductionInfoE;_ZN5clang25FTIHasSingleVoidParameterERKNS_15DeclaratorChunk16FunctionTypeInfoE;_ZN5clang25isBetterOverloadCandidateERNS_4SemaERKNS_17OverloadCandidateES4_NS_14SourceLocationEb;_ZN5clang29IsVariableAConstantExpressionEPNS_7VarDeclERNS_10ASTContextE;_ZN5clang51getStackIndexOfNearestEnclosingCaptureCapableLambdaEN4llvm8ArrayRefIPKNS_4sema17FunctionScopeInfoEEEPNS_7VarDeclERNS_4SemaE;_ZN5clang9ExprEmptyEv;_ZN5clang9ExprErrorERKNS_17DiagnosticBuilderE;_ZN5clang9ExprErrorEv;_ZN5clang9StmtEmptyEv;_ZN5clang9StmtErrorERKNS_17DiagnosticBuilderE;_ZN5clang9StmtErrorEv;_ZN5clanggeERKNS_20CodeCompletionResultES2_;_ZN5clanggtERKNS_20CodeCompletionResultES2_;_ZN5clangleERKNS_20CodeCompletionResultES2_;_ZN5clangltERKNS_20CodeCompletionResultES2_; -static-type=SemaClangGlobals -package=org.clang.sema")
//</editor-fold>
public final class SemaClangGlobals {


/// \brief Default priority values for code-completion results based
/// on their kind.
//<editor-fold defaultstate="collapsed" desc="clang::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 34,
 FQN="clang::(anonymous)", NM="_Z5clang_CodeCompleteConsumer_h_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_Z5clang_CodeCompleteConsumer_h_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  /// \brief Priority for the next initialization in a constructor initializer
  /// list.
  public static final /*uint*/int CCP_NextInitializer = 7;
  /// \brief Priority for an enumeration constant inside a switch whose
  /// condition is of the enumeration type.
  public static final /*uint*/int CCP_EnumInCase = 7;
  /// \brief Priority for a send-to-super completion.
  public static final /*uint*/int CCP_SuperCompletion = 20;
  /// \brief Priority for a declaration that is in the local scope.
  public static final /*uint*/int CCP_LocalDeclaration = 34;
  /// \brief Priority for a member declaration found from the current
  /// method or member function.
  public static final /*uint*/int CCP_MemberDeclaration = 35;
  /// \brief Priority for a language keyword (that isn't any of the other
  /// categories).
  public static final /*uint*/int CCP_Keyword = 40;
  /// \brief Priority for a code pattern.
  public static final /*uint*/int CCP_CodePattern = 40;
  /// \brief Priority for a non-type declaration.
  public static final /*uint*/int CCP_Declaration = 50;
  /// \brief Priority for a type.
  public static final /*uint*/int CCP_Type = CCP_Declaration;
  /// \brief Priority for a constant value (e.g., enumerator).
  public static final /*uint*/int CCP_Constant = 65;
  /// \brief Priority for a preprocessor macro.
  public static final /*uint*/int CCP_Macro = 70;
  /// \brief Priority for a nested-name-specifier.
  public static final /*uint*/int CCP_NestedNameSpecifier = 75;
  /// \brief Priority for a result that isn't likely to be what the user wants,
  /// but is included for completeness.
  public static final /*uint*/int CCP_Unlikely = 80;
  
  /// \brief Priority for the Objective-C "_cmd" implicit parameter.
  public static final /*uint*/int CCP_ObjC_cmd = CCP_Unlikely;
/*}*/

/// \brief Priority value deltas that are added to code-completion results
/// based on the context of the result.
//<editor-fold defaultstate="collapsed" desc="clang::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 73,
 FQN="clang::(anonymous)", NM="_Z5clang_CodeCompleteConsumer_h_Unnamed_enum1",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_Z5clang_CodeCompleteConsumer_h_Unnamed_enum1")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  /// \brief The result is in a base class.
  public static final int CCD_InBaseClass = 2;
  /// \brief The result is a C++ non-static member function whose qualifiers
  /// exactly match the object type on which the member function can be called.
  public static final int CCD_ObjectQualifierMatch = -1;
  /// \brief The selector of the given message exactly matches the selector
  /// of the current method, which might imply that some kind of delegation
  /// is occurring.
  public static final int CCD_SelectorMatch = -3;
  
  /// \brief Adjustment to the "bool" type in Objective-C, where the typedef
  /// "BOOL" is preferred.
  public static final int CCD_bool_in_ObjC = 1;
  
  /// \brief Adjustment for KVC code pattern priorities when it doesn't look
  /// like the
  public static final int CCD_ProbablyNotObjCCollection = 15;
  
  /// \brief An Objective-C method being used as a property.
  public static final int CCD_MethodAsProperty = 2;
/*}*/

/// \brief Priority value factors by which we will divide or multiply the
/// priority of a code-completion result.
//<editor-fold defaultstate="collapsed" desc="clang::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 98,
 FQN="clang::(anonymous)", NM="_Z5clang_CodeCompleteConsumer_h_Unnamed_enum2",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_Z5clang_CodeCompleteConsumer_h_Unnamed_enum2")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  /// \brief Divide by this factor when a code-completion result's type exactly
  /// matches the type we expect.
  public static final /*uint*/int CCF_ExactTypeMatch = 4;
  /// \brief Divide by this factor when a code-completion result's type is
  /// similar to the type we expect (e.g., both arithmetic types, both
  /// Objective-C object pointer types).
  public static final /*uint*/int CCF_SimilarTypeMatch = 2;
/*}*/
//<editor-fold defaultstate="collapsed" desc="clang::operator<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 623,
 FQN="clang::operator<", NM="_ZN5clangltERKNS_20CodeCompletionResultES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clangltERKNS_20CodeCompletionResultES2_")
//</editor-fold>
public static boolean $less_CodeCompletionResult$C(final /*const*/ CodeCompletionResult /*&*/ X, 
                            final /*const*/ CodeCompletionResult /*&*/ Y) {
  return /*delegate*/org.clang.sema.impl.CodeCompleteConsumerClangGlobals.
    $less_CodeCompletionResult$C(X, 
                            Y);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator>">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 787,
 FQN="clang::operator>", NM="_ZN5clanggtERKNS_20CodeCompletionResultES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clanggtERKNS_20CodeCompletionResultES2_")
//</editor-fold>
public static /*inline*/ boolean $greater_CodeCompletionResult$C(final /*const*/ CodeCompletionResult /*&*/ X, 
                               final /*const*/ CodeCompletionResult /*&*/ Y) {
  return /*delegate*/org.clang.sema.impl.CodeCompleteConsumerClangGlobals.
    $greater_CodeCompletionResult$C(X, 
                               Y);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<=">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 792,
 FQN="clang::operator<=", NM="_ZN5clangleERKNS_20CodeCompletionResultES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clangleERKNS_20CodeCompletionResultES2_")
//</editor-fold>
public static /*inline*/ boolean $lesseq_CodeCompletionResult$C(final /*const*/ CodeCompletionResult /*&*/ X, 
                              final /*const*/ CodeCompletionResult /*&*/ Y) {
  return /*delegate*/org.clang.sema.impl.CodeCompleteConsumerClangGlobals.
    $lesseq_CodeCompletionResult$C(X, 
                              Y);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator>=">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 797,
 FQN="clang::operator>=", NM="_ZN5clanggeERKNS_20CodeCompletionResultES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clanggeERKNS_20CodeCompletionResultES2_")
//</editor-fold>
public static /*inline*/ boolean $greatereq_CodeCompletionResult$C(final /*const*/ CodeCompletionResult /*&*/ X, 
                                 final /*const*/ CodeCompletionResult /*&*/ Y) {
  return /*delegate*/org.clang.sema.impl.CodeCompleteConsumerClangGlobals.
    $greatereq_CodeCompletionResult$C(X, 
                                 Y);
}

//<editor-fold defaultstate="collapsed" desc="clang::ExprError">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 268,
 FQN="clang::ExprError", NM="_ZN5clang9ExprErrorEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang9ExprErrorEv")
//</editor-fold>
public static /*inline*/ ActionResultTTrue<Expr /*P*/ > ExprError() {
  return /*delegate*/org.clang.sema.impl.OwnershipClangGlobals.
    ExprError();
}

//<editor-fold defaultstate="collapsed" desc="clang::StmtError">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 269,
 FQN="clang::StmtError", NM="_ZN5clang9StmtErrorEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang9StmtErrorEv")
//</editor-fold>
public static /*inline*/ ActionResultTTrue<Stmt /*P*/ > StmtError() {
  return /*delegate*/org.clang.sema.impl.OwnershipClangGlobals.
    StmtError();
}

//<editor-fold defaultstate="collapsed" desc="clang::ExprError">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 271,
 FQN="clang::ExprError", NM="_ZN5clang9ExprErrorERKNS_17DiagnosticBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang9ExprErrorERKNS_17DiagnosticBuilderE")
//</editor-fold>
public static /*inline*/ ActionResultTTrue<Expr /*P*/ > ExprError(final /*const*/ DiagnosticBuilder /*&*/ $Prm0) {
  return /*delegate*/org.clang.sema.impl.OwnershipClangGlobals.
    ExprError($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="clang::StmtError">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 272,
 FQN="clang::StmtError", NM="_ZN5clang9StmtErrorERKNS_17DiagnosticBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang9StmtErrorERKNS_17DiagnosticBuilderE")
//</editor-fold>
public static /*inline*/ ActionResultTTrue<Stmt /*P*/ > StmtError(final /*const*/ DiagnosticBuilder /*&*/ $Prm0) {
  return /*delegate*/org.clang.sema.impl.OwnershipClangGlobals.
    StmtError($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="clang::ExprEmpty">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 274,
 FQN="clang::ExprEmpty", NM="_ZN5clang9ExprEmptyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang9ExprEmptyEv")
//</editor-fold>
public static /*inline*/ ActionResultTTrue<Expr /*P*/ > ExprEmpty() {
  return /*delegate*/org.clang.sema.impl.OwnershipClangGlobals.
    ExprEmpty();
}

//<editor-fold defaultstate="collapsed" desc="clang::StmtEmpty">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 275,
 FQN="clang::StmtEmpty", NM="_ZN5clang9StmtEmptyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang9StmtEmptyEv")
//</editor-fold>
public static /*inline*/ ActionResultTTrue<Stmt /*P*/ > StmtEmpty() {
  return /*delegate*/org.clang.sema.impl.OwnershipClangGlobals.
    StmtEmpty();
}

//<editor-fold defaultstate="collapsed" desc="clang::AssertSuccess">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 277,
 FQN="clang::AssertSuccess", NM="_ZN5clang13AssertSuccessENS_12ActionResultIPNS_4ExprELb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang13AssertSuccessENS_12ActionResultIPNS_4ExprELb1EEE")
//</editor-fold>
public static /*inline*/ Expr /*P*/ AssertSuccess_ActionResultTTrue$Expr$P(ActionResultTTrue<Expr /*P*/ > R) {
  return /*delegate*/org.clang.sema.impl.OwnershipClangGlobals.
    AssertSuccess_ActionResultTTrue$Expr$P(R);
}

//<editor-fold defaultstate="collapsed" desc="clang::AssertSuccess">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 282,
 FQN="clang::AssertSuccess", NM="_ZN5clang13AssertSuccessENS_12ActionResultIPNS_4StmtELb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang13AssertSuccessENS_12ActionResultIPNS_4StmtELb1EEE")
//</editor-fold>
public static /*inline*/ Stmt /*P*/ AssertSuccess_ActionResultTTrue$Stmt$P(ActionResultTTrue<Stmt /*P*/ > R) {
  return /*delegate*/org.clang.sema.impl.OwnershipClangGlobals.
    AssertSuccess_ActionResultTTrue$Stmt$P(R);
}

//<editor-fold defaultstate="collapsed" desc="clang::FTIHasSingleVoidParameter">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 29,
 FQN="clang::FTIHasSingleVoidParameter", NM="_ZN5clang25FTIHasSingleVoidParameterERKNS_15DeclaratorChunk16FunctionTypeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang25FTIHasSingleVoidParameterERKNS_15DeclaratorChunk16FunctionTypeInfoE")
//</editor-fold>
public static /*inline*/ boolean FTIHasSingleVoidParameter(final /*const*/ DeclaratorChunk.FunctionTypeInfo /*&*/ FTI) {
  return /*delegate*/org.clang.sema.impl.SemaInternalClangGlobals.
    FTIHasSingleVoidParameter(FTI);
}

//<editor-fold defaultstate="collapsed" desc="clang::FTIHasNonVoidParameters">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 36,
 FQN="clang::FTIHasNonVoidParameters", NM="_ZN5clang23FTIHasNonVoidParametersERKNS_15DeclaratorChunk16FunctionTypeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang23FTIHasNonVoidParametersERKNS_15DeclaratorChunk16FunctionTypeInfoE")
//</editor-fold>
public static /*inline*/ boolean FTIHasNonVoidParameters(final /*const*/ DeclaratorChunk.FunctionTypeInfo /*&*/ FTI) {
  return /*delegate*/org.clang.sema.impl.SemaInternalClangGlobals.
    FTIHasNonVoidParameters(FTI);
}


// This requires the variable to be non-dependent and the initializer
// to not be value dependent.
//<editor-fold defaultstate="collapsed" desc="clang::IsVariableAConstantExpression">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 44,
 FQN="clang::IsVariableAConstantExpression", NM="_ZN5clang29IsVariableAConstantExpressionEPNS_7VarDeclERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang29IsVariableAConstantExpressionEPNS_7VarDeclERNS_10ASTContextE")
//</editor-fold>
public static /*inline*/ boolean IsVariableAConstantExpression(VarDecl /*P*/ Var, final ASTContext /*&*/ Context) {
  return /*delegate*/org.clang.sema.impl.SemaInternalClangGlobals.
    IsVariableAConstantExpression(Var, Context);
}


// Helper function to check whether D's attributes match current CUDA mode.
// Decls with mismatched attributes and related diagnostics may have to be
// ignored during this CUDA compilation pass.
//<editor-fold defaultstate="collapsed" desc="clang::DeclAttrsMatchCUDAMode">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 54,
 FQN="clang::DeclAttrsMatchCUDAMode", NM="_ZN5clang22DeclAttrsMatchCUDAModeERKNS_11LangOptionsEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22DeclAttrsMatchCUDAModeERKNS_11LangOptionsEPNS_4DeclE")
//</editor-fold>
public static /*inline*/ boolean DeclAttrsMatchCUDAMode(final /*const*/ LangOptions /*&*/ LangOpts, Decl /*P*/ D) {
  return /*delegate*/org.clang.sema.impl.SemaInternalClangGlobals.
    DeclAttrsMatchCUDAMode(LangOpts, D);
}


// Directly mark a variable odr-used. Given a choice, prefer to use 
// MarkVariableReferenced since it does additional checks and then 
// calls MarkVarDeclODRUsed.
// If the variable must be captured:
//  - if FunctionScopeIndexToStopAt is null, capture it in the CurContext
//  - else capture it in the DeclContext that maps to the 
//    *FunctionScopeIndexToStopAt on the FunctionScopeInfo stack.  
//<editor-fold defaultstate="collapsed" desc="clang::MarkVarDeclODRUsed">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 70,
 FQN="clang::MarkVarDeclODRUsed", NM="_ZN5clang18MarkVarDeclODRUsedEPNS_7VarDeclENS_14SourceLocationERNS_4SemaEPKj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang18MarkVarDeclODRUsedEPNS_7VarDeclENS_14SourceLocationERNS_4SemaEPKj")
//</editor-fold>
public static /*inline*/ void MarkVarDeclODRUsed(VarDecl /*P*/ Var, 
                  SourceLocation Loc, final Sema /*&*/ SemaRef, 
                  /*const*/uint$ptr/*uint P*//*const*/ FunctionScopeIndexToStopAt) {
  /*delegate*/org.clang.sema.impl.SemaInternalClangGlobals.
    MarkVarDeclODRUsed(Var, 
                  Loc, SemaRef, 
                  FunctionScopeIndexToStopAt);
}


/// Return a DLL attribute from the declaration.
//<editor-fold defaultstate="collapsed" desc="clang::getDLLAttr">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 93,
 FQN="clang::getDLLAttr", NM="_ZN5clang10getDLLAttrEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang10getDLLAttrEPNS_4DeclE")
//</editor-fold>
public static /*inline*/ InheritableAttr /*P*/ getDLLAttr(Decl /*P*/ D) {
  return /*delegate*/org.clang.sema.impl.SemaInternalClangGlobals.
    getDLLAttr(D);
}


/// \brief Determine the simplified type class of the given canonical type.

/// \brief A simplified classification of types used to determine whether two
/// types are "similar enough" when adjusting priorities.
//<editor-fold defaultstate="collapsed" desc="clang::getSimplifiedTypeClass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 601,
 FQN="clang::getSimplifiedTypeClass", NM="_ZN5clang22getSimplifiedTypeClassENS_7CanQualINS_4TypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang22getSimplifiedTypeClassENS_7CanQualINS_4TypeEEE")
//</editor-fold>
public static SimplifiedTypeClass getSimplifiedTypeClass(CanQual<Type> T) {
  return /*delegate*/org.clang.sema.impl.SemaCodeCompleteClangGlobals.
    getSimplifiedTypeClass(T);
}


/// \brief Determine the type that this declaration will have if it is used
/// as a type or in an expression.

/// \brief Get the type that a given expression will have if this declaration
/// is used as an expression in its "typical" code-completion form.
//<editor-fold defaultstate="collapsed" desc="clang::getDeclUsageType">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 670,
 FQN="clang::getDeclUsageType", NM="_ZN5clang16getDeclUsageTypeERNS_10ASTContextEPKNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang16getDeclUsageTypeERNS_10ASTContextEPKNS_9NamedDeclE")
//</editor-fold>
public static QualType getDeclUsageType(final ASTContext /*&*/ C, /*const*/ NamedDecl /*P*/ ND) {
  return /*delegate*/org.clang.sema.impl.SemaCodeCompleteClangGlobals.
    getDeclUsageType(C, ND);
}


/// \brief Determine the priority to be given to a macro code completion result
/// with the given name.
///
/// \param MacroName The name of the macro.
///
/// \param LangOpts Options describing the current language dialect.
///
/// \param PreferredTypeIsPointer Whether the preferred type for the context
/// of this macro is a pointer type.
//<editor-fold defaultstate="collapsed" desc="clang::getMacroUsagePriority">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 2999,
 FQN="clang::getMacroUsagePriority", NM="_ZN5clang21getMacroUsagePriorityEN4llvm9StringRefERKNS_11LangOptionsEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang21getMacroUsagePriorityEN4llvm9StringRefERKNS_11LangOptionsEb")
//</editor-fold>
public static /*uint*/int getMacroUsagePriority(StringRef MacroName, 
                     final /*const*/ LangOptions /*&*/ LangOpts) {
  return getMacroUsagePriority(MacroName, 
                     LangOpts, 
                     false);
}
public static /*uint*/int getMacroUsagePriority(StringRef MacroName, 
                     final /*const*/ LangOptions /*&*/ LangOpts, 
                     boolean PreferredTypeIsPointer/*= false*/) {
  return /*delegate*/org.clang.sema.impl.SemaCodeCompleteClangGlobals.
    getMacroUsagePriority(MacroName, 
                     LangOpts, 
                     PreferredTypeIsPointer);
}


/// \brief Determine the libclang cursor kind associated with the given
/// declaration.
//<editor-fold defaultstate="collapsed" desc="clang::getCursorKindForDecl">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3023,
 FQN="clang::getCursorKindForDecl", NM="_ZN5clang20getCursorKindForDeclEPKNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang20getCursorKindForDeclEPKNS_4DeclE")
//</editor-fold>
public static CXCursorKind getCursorKindForDecl(/*const*/ Decl /*P*/ D) {
  return /*delegate*/org.clang.sema.impl.SemaCodeCompleteClangGlobals.
    getCursorKindForDecl(D);
}

// FIXME: Add an AddOverloadCandidate / AddTemplateOverloadCandidate overload
// that takes one of these.
//<editor-fold defaultstate="collapsed" desc="clang::getConstructorInfo">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 810,
 FQN="clang::getConstructorInfo", NM="_ZN5clang18getConstructorInfoEPNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang18getConstructorInfoEPNS_9NamedDeclE")
//</editor-fold>
public static /*inline*/ ConstructorInfo getConstructorInfo(NamedDecl /*P*/ ND) {
  return /*delegate*/org.clang.sema.impl.OverloadClangGlobals.
    getConstructorInfo(ND);
}


/// \brief Examines the FunctionScopeInfo stack to determine the nearest
/// enclosing lambda (to the current lambda) that is 'capture-capable' for 
/// the variable referenced in the current lambda (i.e. \p VarToCapture).
/// If successful, returns the index into Sema's FunctionScopeInfo stack
/// of the capture-capable lambda's LambdaScopeInfo. 
/// See Implementation for more detailed comments. 

/// \brief Examines the FunctionScopeInfo stack to determine the nearest
/// enclosing lambda (to the current lambda) that is 'capture-capable' for 
/// the variable referenced in the current lambda (i.e. \p VarToCapture).
/// If successful, returns the index into Sema's FunctionScopeInfo stack
/// of the capture-capable lambda's LambdaScopeInfo.
///
/// Given the current stack of lambdas being processed by Sema and
/// the variable of interest, to identify the nearest enclosing lambda (to the 
/// current lambda at the top of the stack) that can truly capture
/// a variable, it has to have the following two properties:
///  a) 'capture-ready' - be the innermost lambda that is 'capture-ready':
///     - climb down the stack (i.e. starting from the innermost and examining
///       each outer lambda step by step) checking if each enclosing
///       lambda can either implicitly or explicitly capture the variable.
///       Record the first such lambda that is enclosed in a non-dependent
///       context. If no such lambda currently exists return failure.
///  b) 'capture-capable' - make sure the 'capture-ready' lambda can truly
///  capture the variable by checking all its enclosing lambdas:
///     - check if all outer lambdas enclosing the 'capture-ready' lambda
///       identified above in 'a' can also capture the variable (this is done
///       via tryCaptureVariable for variables and CheckCXXThisCapture for
///       'this' by passing in the index of the Lambda identified in step 'a')
///
/// \param FunctionScopes - Sema's stack of nested FunctionScopeInfo's (which a
/// LambdaScopeInfo inherits from).  The current/deepest/innermost lambda
/// is at the top of the stack.
///
/// \param VarToCapture - the variable to capture.  If NULL, capture 'this'.
///
///
/// \returns An Optional<unsigned> Index that if evaluates to 'true' contains
/// the index (into Sema's FunctionScopeInfo stack) of the innermost lambda
/// which is capture-capable.  If the return value evaluates to 'false' then
/// no lambda is capture-capable for \p VarToCapture.
//<editor-fold defaultstate="collapsed" desc="clang::getStackIndexOfNearestEnclosingCaptureCapableLambda">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 170,
 FQN="clang::getStackIndexOfNearestEnclosingCaptureCapableLambda", NM="_ZN5clang51getStackIndexOfNearestEnclosingCaptureCapableLambdaEN4llvm8ArrayRefIPKNS_4sema17FunctionScopeInfoEEEPNS_7VarDeclERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang51getStackIndexOfNearestEnclosingCaptureCapableLambdaEN4llvm8ArrayRefIPKNS_4sema17FunctionScopeInfoEEEPNS_7VarDeclERNS_4SemaE")
//</editor-fold>
public static OptionalUInt getStackIndexOfNearestEnclosingCaptureCapableLambda(ArrayRef</*const*/ FunctionScopeInfo /*P*/ > FunctionScopes, 
                                                   VarDecl /*P*/ VarToCapture, final Sema /*&*/ S) {
  return /*delegate*/org.clang.sema.impl.SemaLambdaClangGlobals.
    getStackIndexOfNearestEnclosingCaptureCapableLambda(FunctionScopes, 
                                                   VarToCapture, S);
}


/// GetConversionRank - Retrieve the implicit conversion rank
/// corresponding to the given implicit conversion kind.
//<editor-fold defaultstate="collapsed" desc="clang::GetConversionRank">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 108,
 FQN="clang::GetConversionRank", NM="_ZN5clang17GetConversionRankENS_22ImplicitConversionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang17GetConversionRankENS_22ImplicitConversionKindE")
//</editor-fold>
public static ImplicitConversionRank GetConversionRank(ImplicitConversionKind Kind) {
  return /*delegate*/org.clang.sema.impl.SemaOverloadClangGlobals.
    GetConversionRank(Kind);
}


/// isBetterOverloadCandidate - Determines whether the first overload
/// candidate is a better candidate than the second (C++ 13.3.3p1).
//<editor-fold defaultstate="collapsed" desc="clang::isBetterOverloadCandidate">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 8548,
 FQN="clang::isBetterOverloadCandidate", NM="_ZN5clang25isBetterOverloadCandidateERNS_4SemaERKNS_17OverloadCandidateES4_NS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang25isBetterOverloadCandidateERNS_4SemaERKNS_17OverloadCandidateES4_NS_14SourceLocationEb")
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
  return /*delegate*/org.clang.sema.impl.SemaOverloadClangGlobals.
    isBetterOverloadCandidate(S, Cand1, 
                         Cand2, 
                         Loc, 
                         UserDefinedConversion);
}


/// \brief Convert from Sema's representation of template deduction information
/// to the form used in overload-candidate information.
//<editor-fold defaultstate="collapsed" desc="clang::MakeDeductionFailureInfo">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 564,
 FQN="clang::MakeDeductionFailureInfo", NM="_ZN5clang24MakeDeductionFailureInfoERNS_10ASTContextENS_4Sema23TemplateDeductionResultERNS_4sema21TemplateDeductionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang24MakeDeductionFailureInfoERNS_10ASTContextENS_4Sema23TemplateDeductionResultERNS_4sema21TemplateDeductionInfoE")
//</editor-fold>
public static DeductionFailureInfo MakeDeductionFailureInfo(final ASTContext /*&*/ Context, 
                        Sema.TemplateDeductionResult TDK, 
                        final TemplateDeductionInfo /*&*/ Info) {
  return /*delegate*/org.clang.sema.impl.SemaOverloadClangGlobals.
    MakeDeductionFailureInfo(Context, 
                        TDK, 
                        Info);
}


/// Retrieves the range of the given template parameter lists.

// Exported for use by Parser.
//<editor-fold defaultstate="collapsed" desc="clang::getTemplateParamsRange">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 41,
 FQN="clang::getTemplateParamsRange", NM="_ZN5clang22getTemplateParamsRangeEPKPKNS_21TemplateParameterListEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang22getTemplateParamsRangeEPKPKNS_21TemplateParameterListEj")
//</editor-fold>
public static SourceRange getTemplateParamsRange(/*const*/type$ptr<TemplateParameterList/*P const*/>/*P*/ Ps, 
                      /*uint*/int N) {
  return /*delegate*/org.clang.sema.impl.SemaTemplateClangGlobals.
    getTemplateParamsRange(Ps, 
                      N);
}

} // END OF class SemaClangGlobals
