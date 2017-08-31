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
package org.clang.astmatchers.ast_matchers;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.ast_type_traits.*;
import org.clang.astmatchers.ast_matchers.*;
import org.clang.astmatchers.ast_matchers.internal.*;
import org.clang.astmatchers.ast_matchers.internal.ASTMatchersInternalGlobals.TypeList;
import static org.clang.astmatchers.ast_matchers.internal.InternalGlobals.hasAnyNameFunc;
import org.clang.astmatchers.ast_matchers.internal.impl.*;
import org.clang.astmatchers.dynamic.ast_matchers.*;
import org.clang.astmatchers.dynamic.ast_matchers.impl.*;
import org.clang.astmatchers.dynamic.ast_matchers.internal.impl.*;
import org.clang.astmatchers.ast_matchers.java.AstMatchersFunctionPointers.*;
import org.clang.basic.UnaryExprOrTypeTrait;
import org.clang.basic.attr;
import org.clang.basic.java.*;
import org.clang.basic.llvm.*;
import org.clang.lex.*;
import org.clang.lex.java.*;
import org.clang.lex.llvm.*;


//<editor-fold defaultstate="collapsed" desc="static type Ast_matchersGlobals">
@Converted(kind = Converted.Kind.MANUAL_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=Tpl__ZN5clang12ast_matchers11selectFirstEN4llvm9StringRefERKNS1_15SmallVectorImplINS0_10BoundNodesEEE;Tpl__ZN5clang12ast_matchers2idEN4llvm9StringRefERKNS0_8internal15BindableMatcherIT_EE;Tpl__ZN5clang12ast_matchers5matchET_RKNS_15ast_type_traits12DynTypedNodeERNS_10ASTContextE;Tpl__ZN5clang12ast_matchers5matchET_RKT0_RNS_10ASTContextE;Tpl__ZN5clang12ast_matchers5matchET_RNS_10ASTContextE;Tpl__ZN5clang12ast_matchers6equalsERKT_;Tpl__ZN5clang12ast_matchers7findAllERKNS0_8internal7MatcherIT_EE;_ZN5clang12ast_matchers10equalsNodeERKPKNS_4DeclE;_ZN5clang12ast_matchers10equalsNodeERKPKNS_4StmtE;_ZN5clang12ast_matchers10equalsNodeERKPKNS_4TypeE;_ZN5clang12ast_matchers10hasTypeLocERKNS0_8internal7MatcherINS_7TypeLocEEE;_ZN5clang12ast_matchers10isBitFieldEv;_ZN5clang12ast_matchers10isCatchAllEv;_ZN5clang12ast_matchers10isExplicitEv;_ZN5clang12ast_matchers10isImplicitEv;_ZN5clang12ast_matchers10isIntegralEv;_ZN5clang12ast_matchers10isOverrideEv;_ZN5clang12ast_matchers10isVariadicEv;_ZN5clang12ast_matchers10referencesERKNS0_8internal7MatcherINS_4DeclEEE;_ZN5clang12ast_matchers10referencesERKNS0_8internal7MatcherINS_8QualTypeEEE;_ZN5clang12ast_matchers10sizeOfExprERKNS0_8internal7MatcherINS_24UnaryExprOrTypeTraitExprEEE;_ZN5clang12ast_matchers11alignOfExprERKNS0_8internal7MatcherINS_24UnaryExprOrTypeTraitExprEEE;_ZN5clang12ast_matchers11booleanTypeEv;_ZN5clang12ast_matchers11declCountIsERKj;_ZN5clang12ast_matchers11forFunctionERKNS0_8internal7MatcherINS_12FunctionDeclEEE;_ZN5clang12ast_matchers11hasArgumentERKjRKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers11hasBitWidthERKj;_ZN5clang12ast_matchers11hasCastKindERKNS_8CastKindE;_ZN5clang12ast_matchers11hasLoopInitERKNS0_8internal7MatcherINS_4StmtEEE;_ZN5clang12ast_matchers11hasSelectorERKSs;_ZN5clang12ast_matchers11hasSizeExprERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers11isAnonymousEv;_ZN5clang12ast_matchers11isConstexprEv;_ZN5clang12ast_matchers11isDefaultedEv;_ZN5clang12ast_matchers11isProtectedEv;_ZN5clang12ast_matchers11matchesNameERKSs;_ZN5clang12ast_matchers12hasConditionERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers12hasIncrementERKNS0_8internal7MatcherINS_4StmtEEE;_ZN5clang12ast_matchers12hasParameterERKjRKNS0_8internal7MatcherINS_11ParmVarDeclEEE;_ZN5clang12ast_matchers12hasQualifierERKNS0_8internal7MatcherINS_19NestedNameSpecifierEEE;_ZN5clang12ast_matchers12hasRangeInitERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers12isAnyPointerEv;_ZN5clang12ast_matchers12isDefinitionEv;_ZN5clang12ast_matchers12refersToTypeERKNS0_8internal7MatcherINS_8QualTypeEEE;_ZN5clang12ast_matchers13hasSingleDeclERKNS0_8internal7MatcherINS_4DeclEEE;_ZN5clang12ast_matchers13hasTargetDeclERKNS0_8internal7MatcherINS_9NamedDeclEEE;_ZN5clang12ast_matchers13isDerivedFromERKNS0_8internal7MatcherINS_9NamedDeclEEE;_ZN5clang12ast_matchers13isDerivedFromERKSs;_ZN5clang12ast_matchers13specifiesTypeERKNS0_8internal7MatcherINS_8QualTypeEEE;_ZN5clang12ast_matchers14hasAnyArgumentERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers14hasDecayedTypeERKNS0_8internal7MatcherINS_8QualTypeEEE;_ZN5clang12ast_matchers14hasDeclContextERKNS0_8internal7MatcherINS_4DeclEEE;_ZN5clang12ast_matchers14hasDeclarationERKNS0_8internal7MatcherINS_4DeclEEE;_ZN5clang12ast_matchers14hasInitializerERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers14hasReturnValueERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers14ignoringParensERKNS0_8internal7MatcherINS_8QualTypeEEE;_ZN5clang12ast_matchers14isAnyCharacterEv;_ZN5clang12ast_matchers14isInstantiatedEv;_ZN5clang12ast_matchers14isUserProvidedEv;_ZN5clang12ast_matchers15argumentCountIsERKj;_ZN5clang12ast_matchers15equalsBoundNodeERKSs;_ZN5clang12ast_matchers15hasAnyParameterERKNS0_8internal7MatcherINS_11ParmVarDeclEEE;_ZN5clang12ast_matchers15hasCaseConstantERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers15hasLocalStorageEv;_ZN5clang12ast_matchers15hasLoopVariableERKNS0_8internal7MatcherINS_7VarDeclEEE;_ZN5clang12ast_matchers15hasNullSelectorEv;_ZN5clang12ast_matchers15hasOperatorNameERKSs;_ZN5clang12ast_matchers15hasReceiverTypeERKNS0_8internal7MatcherINS_8QualTypeEEE;_ZN5clang12ast_matchers15hasUnaryOperandERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers15isSignedIntegerEv;_ZN5clang12ast_matchers15matchesSelectorERKSs;_ZN5clang12ast_matchers15numSelectorArgsERKj;_ZN5clang12ast_matchers15thisPointerTypeERKNS0_8internal7MatcherINS_4DeclEEE;_ZN5clang12ast_matchers15thisPointerTypeERKNS0_8internal7MatcherINS_8QualTypeEEE;_ZN5clang12ast_matchers15withInitializerERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers16hasCanonicalTypeERKNS0_8internal7MatcherINS_8QualTypeEEE;_ZN5clang12ast_matchers16hasEitherOperandERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers16hasGlobalStorageEv;_ZN5clang12ast_matchers16hasSyntacticFormERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers16hasUnarySelectorEv;_ZN5clang12ast_matchers16ignoringImpCastsERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers16ignoringImplicitERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers16isConstQualifiedEv;_ZN5clang12ast_matchers16parameterCountIsERKj;_ZN5clang12ast_matchers16specifiesTypeLocERKNS0_8internal7MatcherINS_7TypeLocEEE;_ZN5clang12ast_matchers16statementCountIsERKj;_ZN5clang12ast_matchers16throughUsingDeclERKNS0_8internal7MatcherINS_15UsingShadowDeclEEE;_ZN5clang12ast_matchers17designatorCountIsERKj;_ZN5clang12ast_matchers17forEachOverriddenERKNS0_8internal7MatcherINS_13CXXMethodDeclEEE;_ZN5clang12ast_matchers17forEachSwitchCaseERKNS0_8internal7MatcherINS_10SwitchCaseEEE;_ZN5clang12ast_matchers17hasArgumentOfTypeERKNS0_8internal7MatcherINS_8QualTypeEEE;_ZN5clang12ast_matchers17hasTrueExpressionERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers17isBaseInitializerEv;_ZN5clang12ast_matchers17isCopyConstructorEv;_ZN5clang12ast_matchers17isMoveConstructorEv;_ZN5clang12ast_matchers17isUnsignedIntegerEv;_ZN5clang12ast_matchers18hasAnySubstatementERKNS0_8internal7MatcherINS_4StmtEEE;_ZN5clang12ast_matchers18hasDestinationTypeERKNS0_8internal7MatcherINS_8QualTypeEEE;_ZN5clang12ast_matchers18hasFalseExpressionERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers18hasKeywordSelectorEv;_ZN5clang12ast_matchers18hasLocalQualifiersEv;_ZN5clang12ast_matchers18ignoringParenCastsERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers18isVirtualAsWrittenEv;_ZN5clang12ast_matchers18specifiesNamespaceERKNS0_8internal7MatcherINS_13NamespaceDeclEEE;_ZN5clang12ast_matchers19containsDeclarationERKjRKNS0_8internal7MatcherINS_4DeclEEE;_ZN5clang12ast_matchers19equalsIntegralValueERKSs;_ZN5clang12ast_matchers19hasObjectExpressionERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers19hasSourceExpressionERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers19hasTemplateArgumentERKjRKNS0_8internal7MatcherINS_16TemplateArgumentEEE;_ZN5clang12ast_matchers19isExceptionVariableEv;_ZN5clang12ast_matchers19isMemberInitializerEv;_ZN5clang12ast_matchers19isSameOrDerivedFromERKNS0_8internal7MatcherINS_9NamedDeclEEE;_ZN5clang12ast_matchers19isSameOrDerivedFromERKSs;_ZN5clang12ast_matchers19isVolatileQualifiedEv;_ZN5clang12ast_matchers19nullPointerConstantEv;_ZN5clang12ast_matchers19refersToDeclarationERKNS0_8internal7MatcherINS_4DeclEEE;_ZN5clang12ast_matchers20isDefaultConstructorEv;_ZN5clang12ast_matchers20isListInitializationEv;_ZN5clang12ast_matchers20refersToIntegralTypeERKNS0_8internal7MatcherINS_8QualTypeEEE;_ZN5clang12ast_matchers21hasAnyUsingShadowDeclERKNS0_8internal7MatcherINS_15UsingShadowDeclEEE;_ZN5clang12ast_matchers21ignoringParenImpCastsERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers21isExpansionInMainFileEv;_ZN5clang12ast_matchers21realFloatingPointTypeEv;_ZN5clang12ast_matchers22hasAnyTemplateArgumentERKNS0_8internal7MatcherINS_16TemplateArgumentEEE;_ZN5clang12ast_matchers23hasDynamicExceptionSpecEv;_ZN5clang12ast_matchers23isDelegatingConstructorEv;_ZN5clang12ast_matchers23isTemplateInstantiationEv;_ZN5clang12ast_matchers23templateArgumentCountIsERKj;_ZN5clang12ast_matchers24forEachArgumentWithParamERKNS0_8internal7MatcherINS_4ExprEEERKNS2_INS_11ParmVarDeclEEE;_ZN5clang12ast_matchers24hasStaticStorageDurationEv;_ZN5clang12ast_matchers24hasThreadStorageDurationEv;_ZN5clang12ast_matchers24isCopyAssignmentOperatorEv;_ZN5clang12ast_matchers24isMoveAssignmentOperatorEv;_ZN5clang12ast_matchers24onImplicitObjectArgumentERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers25hasOverloadedOperatorNameEN4llvm9StringRefE;_ZN5clang12ast_matchers25isExpansionInFileMatchingERKSs;_ZN5clang12ast_matchers25isExpansionInSystemHeaderEv;_ZN5clang12ast_matchers25isInTemplateInstantiationEv;_ZN5clang12ast_matchers26hasImplicitDestinationTypeERKNS0_8internal7MatcherINS_8QualTypeEEE;_ZN5clang12ast_matchers26isInstantiated_getInstanceEv;_ZN5clang12ast_matchers26requiresZeroInitializationEv;_ZN5clang12ast_matchers27hasAutomaticStorageDurationEv;_ZN5clang12ast_matchers28hasAnyConstructorInitializerERKNS0_8internal7MatcherINS_18CXXCtorInitializerEEE;_ZN5clang12ast_matchers29forEachConstructorInitializerERKNS0_8internal7MatcherINS_18CXXCtorInitializerEEE;_ZN5clang12ast_matchers29hasConditionVariableStatementERKNS0_8internal7MatcherINS_8DeclStmtEEE;_ZN5clang12ast_matchers2onERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers2toERKNS0_8internal7MatcherINS_4DeclEEE;_ZN5clang12ast_matchers31nullPointerConstant_getInstanceEv;_ZN5clang12ast_matchers32isExplicitTemplateSpecializationEv;_ZN5clang12ast_matchers37isInTemplateInstantiation_getInstanceEv;_ZN5clang12ast_matchers3locERKNS0_8internal7MatcherINS_19NestedNameSpecifierEEE;_ZN5clang12ast_matchers3locERKNS0_8internal7MatcherINS_8QualTypeEEE;_ZN5clang12ast_matchers6calleeERKNS0_8internal7MatcherINS_4DeclEEE;_ZN5clang12ast_matchers6calleeERKNS0_8internal7MatcherINS_4StmtEEE;_ZN5clang12ast_matchers6hasLHSERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers6hasRHSERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers6isExprERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers6isPureEv;_ZN5clang12ast_matchers6memberERKNS0_8internal7MatcherINS_9ValueDeclEEE;_ZN5clang12ast_matchers6ofKindERKNS_20UnaryExprOrTypeTraitE;_ZN5clang12ast_matchers7hasAttrERKNS_4attr4KindE;_ZN5clang12ast_matchers7hasBaseERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers7hasBodyERKNS0_8internal7MatcherINS_4StmtEEE;_ZN5clang12ast_matchers7hasElseERKNS0_8internal7MatcherINS_4StmtEEE;_ZN5clang12ast_matchers7hasNameERKSs;_ZN5clang12ast_matchers7hasSizeERKj;_ZN5clang12ast_matchers7hasThenERKNS0_8internal7MatcherINS_4StmtEEE;_ZN5clang12ast_matchers7hasTypeERKNS0_8internal7MatcherINS_4DeclEEE;_ZN5clang12ast_matchers7hasTypeERKNS0_8internal7MatcherINS_8QualTypeEEE;_ZN5clang12ast_matchers7isArrowEv;_ZN5clang12ast_matchers7isClassEv;_ZN5clang12ast_matchers7isConstEv;_ZN5clang12ast_matchers7isFinalEv;_ZN5clang12ast_matchers7isUnionEv;_ZN5clang12ast_matchers7ofClassERKNS0_8internal7MatcherINS_13CXXRecordDeclEEE;_ZN5clang12ast_matchers7returnsERKNS0_8internal7MatcherINS_8QualTypeEEE;_ZN5clang12ast_matchers8anythingEv;_ZN5clang12ast_matchers8asStringERKSs;_ZN5clang12ast_matchers8forFieldERKNS0_8internal7MatcherINS_9FieldDeclEEE;_ZN5clang12ast_matchers8hasIndexERKNS0_8internal7MatcherINS_4ExprEEE;_ZN5clang12ast_matchers8isInlineEv;_ZN5clang12ast_matchers8isLambdaEv;_ZN5clang12ast_matchers8isPublicEv;_ZN5clang12ast_matchers8isStructEv;_ZN5clang12ast_matchers8pointsToERKNS0_8internal7MatcherINS_4DeclEEE;_ZN5clang12ast_matchers8pointsToERKNS0_8internal7MatcherINS_8QualTypeEEE;_ZN5clang12ast_matchers8voidTypeEv;_ZN5clang12ast_matchers9hasMethodERKNS0_8internal7MatcherINS_13CXXMethodDeclEEE;_ZN5clang12ast_matchers9hasPrefixERKNS0_8internal7MatcherINS_19NestedNameSpecifierEEE;_ZN5clang12ast_matchers9hasPrefixERKNS0_8internal7MatcherINS_22NestedNameSpecifierLocEEE;_ZN5clang12ast_matchers9isDeletedEv;_ZN5clang12ast_matchers9isExternCEv;_ZN5clang12ast_matchers9isIntegerEv;_ZN5clang12ast_matchers9isNoThrowEv;_ZN5clang12ast_matchers9isPrivateEv;_ZN5clang12ast_matchers9isVirtualEv;_ZN5clang12ast_matchers9isWrittenEv;_ZN5clang12ast_matchers9namesTypeERKNS0_8internal7MatcherINS_8QualTypeEEE;_ZN5clang12ast_matchersL10atomicExprE;_ZN5clang12ast_matchersL10atomicTypeE;_ZN5clang12ast_matchersL10cxxNewExprE;_ZN5clang12ast_matchersL10cxxTryStmtE;_ZN5clang12ast_matchersL10friendDeclE;_ZN5clang12ast_matchersL10hasAnyNameE;_ZN5clang12ast_matchersL10lambdaExprE;_ZN5clang12ast_matchersL10memberExprE;_ZN5clang12ast_matchersL10pointeeLocE;_ZN5clang12ast_matchersL10recordDeclE;_ZN5clang12ast_matchersL10recordTypeE;_ZN5clang12ast_matchersL10returnStmtE;_ZN5clang12ast_matchersL10switchCaseE;_ZN5clang12ast_matchersL10switchStmtE;_ZN5clang12ast_matchersL11builtinTypeE;_ZN5clang12ast_matchersL11complexTypeE;_ZN5clang12ast_matchersL11cxxThisExprE;_ZN5clang12ast_matchersL11decayedTypeE;_ZN5clang12ast_matchersL11declRefExprE;_ZN5clang12ast_matchersL11defaultStmtE;_ZN5clang12ast_matchersL11gnuNullExprE;_ZN5clang12ast_matchersL11hasAncestorE;_ZN5clang12ast_matchersL11parmVarDeclE;_ZN5clang12ast_matchersL11pointerTypeE;_ZN5clang12ast_matchersL11typedefDeclE;_ZN5clang12ast_matchersL11typedefTypeE;_ZN5clang12ast_matchersL12compoundStmtE;_ZN5clang12ast_matchersL12continueStmtE;_ZN5clang12ast_matchersL12cxxCatchStmtE;_ZN5clang12ast_matchersL12cxxThrowExprE;_ZN5clang12ast_matchersL12floatLiteralE;_ZN5clang12ast_matchersL12functionDeclE;_ZN5clang12ast_matchersL12functionTypeE;_ZN5clang12ast_matchersL12hasValueTypeE;_ZN5clang12ast_matchersL12initListExprE;_ZN5clang12ast_matchersL13addrLabelExprE;_ZN5clang12ast_matchersL13cxxDeleteExprE;_ZN5clang12ast_matchersL13cxxMethodDeclE;_ZN5clang12ast_matchersL13cxxRecordDeclE;_ZN5clang12ast_matchersL13hasDescendantE;_ZN5clang12ast_matchersL13namespaceDeclE;_ZN5clang12ast_matchersL13parenListExprE;_ZN5clang12ast_matchersL13referenceTypeE;_ZN5clang12ast_matchersL13stringLiteralE;_ZN5clang12ast_matchersL13typeAliasDeclE;_ZN5clang12ast_matchersL13unaryOperatorE;_ZN5clang12ast_matchersL14accessSpecDeclE;_ZN5clang12ast_matchersL14binaryOperatorE;_ZN5clang12ast_matchersL14cStyleCastExprE;_ZN5clang12ast_matchersL14cxxBoolLiteralE;_ZN5clang12ast_matchersL14declaratorDeclE;_ZN5clang12ast_matchersL14elaboratedTypeE;_ZN5clang12ast_matchersL14hasDeducedTypeE;_ZN5clang12ast_matchersL14hasElementTypeE;_ZN5clang12ast_matchersL14integerLiteralE;_ZN5clang12ast_matchersL14predefinedExprE;_ZN5clang12ast_matchersL15cxxForRangeStmtE;_ZN5clang12ast_matchersL15hasValueTypeLocE;_ZN5clang12ast_matchersL15linkageSpecDeclE;_ZN5clang12ast_matchersL15objcMessageExprE;_ZN5clang12ast_matchersL15opaqueValueExprE;_ZN5clang12ast_matchersL15typedefNameDeclE;_ZN5clang12ast_matchersL16blockPointerTypeE;_ZN5clang12ast_matchersL16characterLiteralE;_ZN5clang12ast_matchersL16cxxConstCastExprE;_ZN5clang12ast_matchersL16cxxConstructExprE;_ZN5clang12ast_matchersL16enumConstantDeclE;_ZN5clang12ast_matchersL16explicitCastExprE;_ZN5clang12ast_matchersL16exprWithCleanupsE;_ZN5clang12ast_matchersL16implicitCastExprE;_ZN5clang12ast_matchersL16staticAssertDeclE;_ZN5clang12ast_matchersL16templateArgumentE;_ZN5clang12ast_matchersL17classTemplateDeclE;_ZN5clang12ast_matchersL17constantArrayTypeE;_ZN5clang12ast_matchersL17cxxConversionDeclE;_ZN5clang12ast_matchersL17cxxDefaultArgExprE;_ZN5clang12ast_matchersL17cxxDestructorDeclE;_ZN5clang12ast_matchersL17cxxMemberCallExprE;_ZN5clang12ast_matchersL17cxxStaticCastExprE;_ZN5clang12ast_matchersL17forEachDescendantE;_ZN5clang12ast_matchersL17functionProtoTypeE;_ZN5clang12ast_matchersL17hasElementTypeLocE;_ZN5clang12ast_matchersL17memberPointerTypeE;_ZN5clang12ast_matchersL17objcInterfaceDeclE;_ZN5clang12ast_matchersL17variableArrayTypeE;_ZN5clang12ast_matchersL18arraySubscriptExprE;_ZN5clang12ast_matchersL18cudaKernelCallExprE;_ZN5clang12ast_matchersL18cxxConstructorDeclE;_ZN5clang12ast_matchersL18cxxCtorInitializerE;_ZN5clang12ast_matchersL18cxxDynamicCastExprE;_ZN5clang12ast_matchersL18designatedInitExprE;_ZN5clang12ast_matchersL18namespaceAliasDeclE;_ZN5clang12ast_matchersL18unaryTransformTypeE;_ZN5clang12ast_matchersL18userDefinedLiteralE;_ZN5clang12ast_matchersL18usingDirectiveDeclE;_ZN5clang12ast_matchersL19compoundLiteralExprE;_ZN5clang12ast_matchersL19conditionalOperatorE;_ZN5clang12ast_matchersL19cxxOperatorCallExprE;_ZN5clang12ast_matchersL19incompleteArrayTypeE;_ZN5clang12ast_matchersL19lValueReferenceTypeE;_ZN5clang12ast_matchersL19nestedNameSpecifierE;_ZN5clang12ast_matchersL19rValueReferenceTypeE;_ZN5clang12ast_matchersL19translationUnitDeclE;_ZN5clang12ast_matchersL20cxxBindTemporaryExprE;_ZN5clang12ast_matchersL20functionTemplateDeclE;_ZN5clang12ast_matchersL20templateTypeParmDeclE;_ZN5clang12ast_matchersL20templateTypeParmTypeE;_ZN5clang12ast_matchersL20unresolvedLookupExprE;_ZN5clang12ast_matchersL21cxxFunctionalCastExprE;_ZN5clang12ast_matchersL21cxxNullPtrLiteralExprE;_ZN5clang12ast_matchersL21implicitValueInitExprE;_ZN5clang12ast_matchersL21injectedClassNameTypeE;_ZN5clang12ast_matchersL21objcObjectPointerTypeE;_ZN5clang12ast_matchersL22cxxReinterpretCastExprE;_ZN5clang12ast_matchersL22cxxTemporaryObjectExprE;_ZN5clang12ast_matchersL22nestedNameSpecifierLocE;_ZN5clang12ast_matchersL23dependentSizedArrayTypeE;_ZN5clang12ast_matchersL23nonTypeTemplateParmDeclE;_ZN5clang12ast_matchersL24materializeTemporaryExprE;_ZN5clang12ast_matchersL24unaryExprOrTypeTraitExprE;_ZN5clang12ast_matchersL24unresolvedUsingValueDeclE;_ZN5clang12ast_matchersL25binaryConditionalOperatorE;_ZN5clang12ast_matchersL25substTemplateTypeParmTypeE;_ZN5clang12ast_matchersL26cxxUnresolvedConstructExprE;_ZN5clang12ast_matchersL26templateSpecializationTypeE;_ZN5clang12ast_matchersL27unresolvedUsingTypenameDeclE;_ZN5clang12ast_matchersL28substNonTypeTemplateParmExprE;_ZN5clang12ast_matchersL31classTemplateSpecializationDeclE;_ZN5clang12ast_matchersL3hasE;_ZN5clang12ast_matchersL4declE;_ZN5clang12ast_matchersL4exprE;_ZN5clang12ast_matchersL4stmtE;_ZN5clang12ast_matchersL4typeE;_ZN5clang12ast_matchersL5allOfE;_ZN5clang12ast_matchersL5anyOfE;_ZN5clang12ast_matchersL6doStmtE;_ZN5clang12ast_matchersL6eachOfE;_ZN5clang12ast_matchersL6ifStmtE;_ZN5clang12ast_matchersL6unlessE;_ZN5clang12ast_matchersL7asmStmtE;_ZN5clang12ast_matchersL7forEachE;_ZN5clang12ast_matchersL7forStmtE;_ZN5clang12ast_matchersL7pointeeE;_ZN5clang12ast_matchersL7typeLocE;_ZN5clang12ast_matchersL7varDeclE;_ZN5clang12ast_matchersL8autoTypeE;_ZN5clang12ast_matchersL8callExprE;_ZN5clang12ast_matchersL8caseStmtE;_ZN5clang12ast_matchersL8castExprE;_ZN5clang12ast_matchersL8declStmtE;_ZN5clang12ast_matchersL8enumDeclE;_ZN5clang12ast_matchersL8enumTypeE;_ZN5clang12ast_matchersL8gotoStmtE;_ZN5clang12ast_matchersL8nullStmtE;_ZN5clang12ast_matchersL8qualTypeE;_ZN5clang12ast_matchersL8stmtExprE;_ZN5clang12ast_matchersL9arrayTypeE;_ZN5clang12ast_matchersL9breakStmtE;_ZN5clang12ast_matchersL9fieldDeclE;_ZN5clang12ast_matchersL9hasParentE;_ZN5clang12ast_matchersL9innerTypeE;_ZN5clang12ast_matchersL9labelDeclE;_ZN5clang12ast_matchersL9labelStmtE;_ZN5clang12ast_matchersL9namedDeclE;_ZN5clang12ast_matchersL9parenExprE;_ZN5clang12ast_matchersL9parenTypeE;_ZN5clang12ast_matchersL9usingDeclE;_ZN5clang12ast_matchersL9valueDeclE;_ZN5clang12ast_matchersL9whileStmtE; -static-type=Ast_matchersGlobals -package=org.clang.astmatchers.ast_matchers")
//</editor-fold>
public final class Ast_matchersGlobals {


/// \brief If the provided matcher matches a node, binds the node to \c ID.
///
/// FIXME: Do we want to support this now that we have bind()?
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::id">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 115,
 FQN="clang::ast_matchers::id", NM="Tpl__ZN5clang12ast_matchers2idEN4llvm9StringRefERKNS0_8internal15BindableMatcherIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=Tpl__ZN5clang12ast_matchers2idEN4llvm9StringRefERKNS0_8internal15BindableMatcherIT_EE")
//</editor-fold>
public static </*typename*/ T> Matcher<T> id(StringRef ID, 
  final /*const*/ BindableMatcher<T> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}

/// @}

/// \brief Matches any node.
///
/// Useful when another matcher requires a child matcher, but there's no
/// additional constraint. This will often be used with an explicit conversion
/// to an \c internal::Matcher<> type such as \c TypeMatcher.
///
/// Example: \c DeclarationMatcher(anything()) matches all declarations, e.g.,
/// \code
/// "int* p" and "void f()" in
///   int* p;
///   void f();
/// \endcode
///
/// Usable as: Any Matcher
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::anything">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 145,
 FQN="clang::ast_matchers::anything", NM="_ZN5clang12ast_matchers8anythingEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8anythingEv")
//</editor-fold>
public static /*inline*/ TrueMatcher anything() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the top declaration context.
///
/// Given
/// \code
///   int X;
///   namespace NS {
///   int Y;
///   }  // namespace NS
/// \endcode
/// decl(hasDeclContext(translationUnitDecl()))
///   matches "int X", but not "int Y".
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::translationUnitDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 158,
 FQN="clang::ast_matchers::translationUnitDecl", NM="_ZN5clang12ast_matchersL19translationUnitDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL19translationUnitDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, TranslationUnitDecl> translationUnitDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, TranslationUnitDecl>();

/// \brief Matches typedef declarations.
///
/// Given
/// \code
///   typedef int X;
///   using Y = int;
/// \endcode
/// typedefDecl()
///   matches "typedef int X", but not "using Y = int"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::typedefDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 170,
 FQN="clang::ast_matchers::typedefDecl", NM="_ZN5clang12ast_matchersL11typedefDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL11typedefDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, TypedefDecl> typedefDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, TypedefDecl>();

/// \brief Matches typedef name declarations.
///
/// Given
/// \code
///   typedef int X;
///   using Y = int;
/// \endcode
/// typedefNameDecl()
///   matches "typedef int X" and "using Y = int"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::typedefNameDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 181,
 FQN="clang::ast_matchers::typedefNameDecl", NM="_ZN5clang12ast_matchersL15typedefNameDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL15typedefNameDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, TypedefNameDecl> typedefNameDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, TypedefNameDecl>();

/// \brief Matches type alias declarations.
///
/// Given
/// \code
///   typedef int X;
///   using Y = int;
/// \endcode
/// typeAliasDecl()
///   matches "using Y = int", but not "typedef int X"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::typeAliasDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 193,
 FQN="clang::ast_matchers::typeAliasDecl", NM="_ZN5clang12ast_matchersL13typeAliasDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL13typeAliasDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, TypeAliasDecl> typeAliasDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, TypeAliasDecl>();

/// \brief Matches AST nodes that were expanded within the main-file.
///
/// Example matches X but not Y
///   (matcher = cxxRecordDecl(isExpansionInMainFile())
/// \code
///   #include <Y.h>
///   class X {};
/// \endcode
/// Y.h:
/// \code
///   class Y {};
/// \endcode
///
/// Usable as: Matcher<Decl>, Matcher<Stmt>, Matcher<TypeLoc>
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isExpansionInMainFile">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 209,
 FQN="clang::ast_matchers::isExpansionInMainFile", NM="_ZN5clang12ast_matchers21isExpansionInMainFileEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers21isExpansionInMainFileEv")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam0<matcher_isExpansionInMainFileMatcher/*, void (::TypeList<Decl, Stmt, TypeLoc>)*/> isExpansionInMainFile() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches AST nodes that were expanded within system-header-files.
///
/// Example matches Y but not X
///     (matcher = cxxRecordDecl(isExpansionInSystemHeader())
/// \code
///   #include <SystemHeader.h>
///   class X {};
/// \endcode
/// SystemHeader.h:
/// \code
///   class Y {};
/// \endcode
///
/// Usable as: Matcher<Decl>, Matcher<Stmt>, Matcher<TypeLoc>
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isExpansionInSystemHeader">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 230,
 FQN="clang::ast_matchers::isExpansionInSystemHeader", NM="_ZN5clang12ast_matchers25isExpansionInSystemHeaderEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers25isExpansionInSystemHeaderEv")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam0<matcher_isExpansionInMainFileMatcher/*, void (::TypeList<Decl, Stmt, TypeLoc>)*/> isExpansionInSystemHeader() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches AST nodes that were expanded within files whose name is
/// partially matching a given regex.
///
/// Example matches Y but not X
///     (matcher = cxxRecordDecl(isExpansionInFileMatching("AST.*"))
/// \code
///   #include "ASTMatcher.h"
///   class X {};
/// \endcode
/// ASTMatcher.h:
/// \code
///   class Y {};
/// \endcode
///
/// Usable as: Matcher<Decl>, Matcher<Stmt>, Matcher<TypeLoc>
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isExpansionInFileMatching">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 255,
 FQN="clang::ast_matchers::isExpansionInFileMatching", NM="_ZN5clang12ast_matchers25isExpansionInFileMatchingERKSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers25isExpansionInFileMatchingERKSs")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam1<matcher_isExpansionInFileMatching0Matcher, std.string/*, void (::TypeList<Decl, Stmt, TypeLoc>)*/> isExpansionInFileMatching(final /*const*/std.string/*&*/ RegExp) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches declarations.
///
/// Examples matches \c X, \c C, and the friend declaration inside \c C;
/// \code
///   void X();
///   class C {
///     friend X;
///   };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::decl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 283,
 FQN="clang::ast_matchers::decl", NM="_ZN5clang12ast_matchersL4declE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL4declE")
//</editor-fold>
public static /*const*/ VariadicAllOfMatcher<Decl> decl/*J*/= new VariadicAllOfMatcher<Decl>();

/// \brief Matches a declaration of a linkage specification.
///
/// Given
/// \code
///   extern "C" {}
/// \endcode
/// linkageSpecDecl()
///   matches "extern "C" {}"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::linkageSpecDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 293,
 FQN="clang::ast_matchers::linkageSpecDecl", NM="_ZN5clang12ast_matchersL15linkageSpecDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL15linkageSpecDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, LinkageSpecDecl> linkageSpecDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, LinkageSpecDecl>();

/// \brief Matches a declaration of anything that could have a name.
///
/// Example matches \c X, \c S, the anonymous union type, \c i, and \c U;
/// \code
///   typedef int X;
///   struct S {
///     union {
///       int i;
///     } U;
///   };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::namedDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 307,
 FQN="clang::ast_matchers::namedDecl", NM="_ZN5clang12ast_matchersL9namedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL9namedDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, NamedDecl> namedDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, NamedDecl>();

/// \brief Matches a declaration of label.
///
/// Given
/// \code
///   goto FOO;
///   FOO: bar();
/// \endcode
/// labelDecl()
///   matches 'FOO:'
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::labelDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 318,
 FQN="clang::ast_matchers::labelDecl", NM="_ZN5clang12ast_matchersL9labelDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL9labelDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, LabelDecl> labelDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, LabelDecl>();

/// \brief Matches a declaration of a namespace.
///
/// Given
/// \code
///   namespace {}
///   namespace test {}
/// \endcode
/// namespaceDecl()
///   matches "namespace {}" and "namespace test {}"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::namespaceDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 329,
 FQN="clang::ast_matchers::namespaceDecl", NM="_ZN5clang12ast_matchersL13namespaceDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL13namespaceDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, NamespaceDecl> namespaceDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, NamespaceDecl>();

/// \brief Matches a declaration of a namespace alias.
///
/// Given
/// \code
///   namespace test {}
///   namespace alias = ::test;
/// \endcode
/// namespaceAliasDecl()
///   matches "namespace alias" but not "namespace test"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::namespaceAliasDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 340,
 FQN="clang::ast_matchers::namespaceAliasDecl", NM="_ZN5clang12ast_matchersL18namespaceAliasDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL18namespaceAliasDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, NamespaceAliasDecl> namespaceAliasDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, NamespaceAliasDecl>();

/// \brief Matches class, struct, and union declarations.
///
/// Example matches \c X, \c Z, \c U, and \c S
/// \code
///   class X;
///   template<class T> class Z {};
///   struct S {};
///   union U {};
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::recordDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 352,
 FQN="clang::ast_matchers::recordDecl", NM="_ZN5clang12ast_matchersL10recordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL10recordDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, RecordDecl> recordDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, RecordDecl>();

/// \brief Matches C++ class declarations.
///
/// Example matches \c X, \c Z
/// \code
///   class X;
///   template<class T> class Z {};
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxRecordDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 363,
 FQN="clang::ast_matchers::cxxRecordDecl", NM="_ZN5clang12ast_matchersL13cxxRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL13cxxRecordDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, CXXRecordDecl> cxxRecordDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, CXXRecordDecl>();

/// \brief Matches C++ class template declarations.
///
/// Example matches \c Z
/// \code
///   template<class T> class Z {};
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::classTemplateDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 373,
 FQN="clang::ast_matchers::classTemplateDecl", NM="_ZN5clang12ast_matchersL17classTemplateDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL17classTemplateDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, ClassTemplateDecl> classTemplateDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, ClassTemplateDecl>();

/// \brief Matches C++ class template specializations.
///
/// Given
/// \code
///   template<typename T> class A {};
///   template<> class A<double> {};
///   A<int> a;
/// \endcode
/// classTemplateSpecializationDecl()
///   matches the specializations \c A<int> and \c A<double>
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::classTemplateSpecializationDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 387,
 FQN="clang::ast_matchers::classTemplateSpecializationDecl", NM="_ZN5clang12ast_matchersL31classTemplateSpecializationDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL31classTemplateSpecializationDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, ClassTemplateSpecializationDecl> classTemplateSpecializationDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, ClassTemplateSpecializationDecl>();

/// \brief Matches declarator declarations (field, variable, function
/// and non-type template parameter declarations).
///
/// Given
/// \code
///   class X { int y; };
/// \endcode
/// declaratorDecl()
///   matches \c int y.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::declaratorDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 400,
 FQN="clang::ast_matchers::declaratorDecl", NM="_ZN5clang12ast_matchersL14declaratorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL14declaratorDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, DeclaratorDecl> declaratorDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, DeclaratorDecl>();

/// \brief Matches parameter variable declarations.
///
/// Given
/// \code
///   void f(int x);
/// \endcode
/// parmVarDecl()
///   matches \c int x.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::parmVarDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 411,
 FQN="clang::ast_matchers::parmVarDecl", NM="_ZN5clang12ast_matchersL11parmVarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL11parmVarDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, ParmVarDecl> parmVarDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, ParmVarDecl>();

/// \brief Matches C++ access specifier declarations.
///
/// Given
/// \code
///   class C {
///   public:
///     int a;
///   };
/// \endcode
/// accessSpecDecl()
///   matches 'public:'
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::accessSpecDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 424,
 FQN="clang::ast_matchers::accessSpecDecl", NM="_ZN5clang12ast_matchersL14accessSpecDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL14accessSpecDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, AccessSpecDecl> accessSpecDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, AccessSpecDecl>();

/// \brief Matches constructor initializers.
///
/// Examples matches \c i(42).
/// \code
///   class C {
///     C() : i(42) {}
///     int i;
///   };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxCtorInitializer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 437,
 FQN="clang::ast_matchers::cxxCtorInitializer", NM="_ZN5clang12ast_matchersL18cxxCtorInitializerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL18cxxCtorInitializerE")
//</editor-fold>
public static /*const*/ VariadicAllOfMatcher<CXXCtorInitializer> cxxCtorInitializer/*J*/= new VariadicAllOfMatcher<CXXCtorInitializer>();

/// \brief Matches template arguments.
///
/// Given
/// \code
///   template <typename T> struct C {};
///   C<int> c;
/// \endcode
/// templateArgument()
///   matches 'int' in C<int>.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::templateArgument">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 448,
 FQN="clang::ast_matchers::templateArgument", NM="_ZN5clang12ast_matchersL16templateArgumentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL16templateArgumentE")
//</editor-fold>
public static /*const*/ VariadicAllOfMatcher<TemplateArgument> templateArgument/*J*/= new VariadicAllOfMatcher<TemplateArgument>();

/// \brief Matches non-type template parameter declarations.
///
/// Given
/// \code
///   template <typename T, int N> struct C {};
/// \endcode
/// nonTypeTemplateParmDecl()
///   matches 'N', but not 'T'.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::nonTypeTemplateParmDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 458,
 FQN="clang::ast_matchers::nonTypeTemplateParmDecl", NM="_ZN5clang12ast_matchersL23nonTypeTemplateParmDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL23nonTypeTemplateParmDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, NonTypeTemplateParmDecl> nonTypeTemplateParmDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, NonTypeTemplateParmDecl>();

/// \brief Matches template type parameter declarations.
///
/// Given
/// \code
///   template <typename T, int N> struct C {};
/// \endcode
/// templateTypeParmDecl()
///   matches 'T', but not 'N'.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::templateTypeParmDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 470,
 FQN="clang::ast_matchers::templateTypeParmDecl", NM="_ZN5clang12ast_matchersL20templateTypeParmDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL20templateTypeParmDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, TemplateTypeParmDecl> templateTypeParmDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, TemplateTypeParmDecl>();

/// \brief Matches public C++ declarations.
///
/// Given
/// \code
///   class C {
///   public:    int a;
///   protected: int b;
///   private:   int c;
///   };
/// \endcode
/// fieldDecl(isPublic())
///   matches 'int a;'
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isPublic">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 486,
 FQN="clang::ast_matchers::isPublic", NM="_ZN5clang12ast_matchers8isPublicEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8isPublicEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<Decl> isPublic() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches protected C++ declarations.
///
/// Given
/// \code
///   class C {
///   public:    int a;
///   protected: int b;
///   private:   int c;
///   };
/// \endcode
/// fieldDecl(isProtected())
///   matches 'int b;'
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isProtected">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 502,
 FQN="clang::ast_matchers::isProtected", NM="_ZN5clang12ast_matchers11isProtectedEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11isProtectedEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<Decl> isProtected() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches private C++ declarations.
///
/// Given
/// \code
///   class C {
///   public:    int a;
///   protected: int b;
///   private:   int c;
///   };
/// \endcode
/// fieldDecl(isPrivate())
///   matches 'int c;'
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isPrivate">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 518,
 FQN="clang::ast_matchers::isPrivate", NM="_ZN5clang12ast_matchers9isPrivateEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers9isPrivateEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<Decl> isPrivate() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches non-static data members that are bit-fields.
///
/// Given
/// \code
///   class C {
///     int a : 2;
///     int b;
///   };
/// \endcode
/// fieldDecl(isBitField())
///   matches 'int a;' but not 'int b;'.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isBitField">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 533,
 FQN="clang::ast_matchers::isBitField", NM="_ZN5clang12ast_matchers10isBitFieldEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers10isBitFieldEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<FieldDecl> isBitField() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches non-static data members that are bit-fields.
///
/// Given
/// \code
///   class C {
///     int a : 2;
///     int b : 4;
///     int c : 2;
///   };
/// \endcode
/// fieldDecl(isBitField())
///   matches 'int a;' and 'int c;' but not 'int b;'.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasBitWidth">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 549,
 FQN="clang::ast_matchers::hasBitWidth", NM="_ZN5clang12ast_matchers11hasBitWidthERKj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11hasBitWidthERKj")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<FieldDecl> hasBitWidth(final /*const*/uint$ref/*uint &*/ Width) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a declaration that has been implicitly added
/// by the compiler (eg. implicit default/copy constructors).
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isImplicit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 556,
 FQN="clang::ast_matchers::isImplicit", NM="_ZN5clang12ast_matchers10isImplicitEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers10isImplicitEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<Decl> isImplicit() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches classTemplateSpecializations that have at least one
/// TemplateArgument matching the given InnerMatcher.
///
/// Given
/// \code
///   template<typename T> class A {};
///   template<> class A<double> {};
///   A<int> a;
/// \endcode
/// classTemplateSpecializationDecl(hasAnyTemplateArgument(
///     refersToType(asString("int"))))
///   matches the specialization \c A<int>
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasAnyTemplateArgument">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 572,
 FQN="clang::ast_matchers::hasAnyTemplateArgument", NM="_ZN5clang12ast_matchers22hasAnyTemplateArgumentERKNS0_8internal7MatcherINS_16TemplateArgumentEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers22hasAnyTemplateArgumentERKNS0_8internal7MatcherINS_16TemplateArgumentEEE")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam1<matcher_hasAnyTemplateArgument0Matcher, Matcher<TemplateArgument>/*, void (::TypeList<ClassTemplateSpecializationDecl, TemplateSpecializationType>)*/> hasAnyTemplateArgument(final /*const*/ Matcher<TemplateArgument> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches expressions that match InnerMatcher after any implicit AST
/// nodes are stripped off.
///
/// Parentheses and explicit casts are not discarded.
/// Given
/// \code
///   class C {};
///   C a = C();
///   C b;
///   C c = b;
/// \endcode
/// The matchers
/// \code
///    varDecl(hasInitializer(ignoringImplicit(cxxConstructExpr())))
/// \endcode
/// would match the declarations for a, b, and c.
/// While
/// \code
///    varDecl(hasInitializer(cxxConstructExpr()))
/// \endcode
/// only match the declarations for b and c.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::ignoringImplicit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 604,
 FQN="clang::ast_matchers::ignoringImplicit", NM="_ZN5clang12ast_matchers16ignoringImplicitERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers16ignoringImplicitERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<Expr> ignoringImplicit(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches expressions that match InnerMatcher after any implicit casts
/// are stripped off.
///
/// Parentheses and explicit casts are not discarded.
/// Given
/// \code
///   int arr[5];
///   int a = 0;
///   char b = 0;
///   const int c = a;
///   int *d = arr;
///   long e = (long) 0l;
/// \endcode
/// The matchers
/// \code
///    varDecl(hasInitializer(ignoringImpCasts(integerLiteral())))
///    varDecl(hasInitializer(ignoringImpCasts(declRefExpr())))
/// \endcode
/// would match the declarations for a, b, c, and d, but not e.
/// While
/// \code
///    varDecl(hasInitializer(integerLiteral()))
///    varDecl(hasInitializer(declRefExpr()))
/// \endcode
/// only match the declarations for b, c, and d.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::ignoringImpCasts">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 634,
 FQN="clang::ast_matchers::ignoringImpCasts", NM="_ZN5clang12ast_matchers16ignoringImpCastsERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers16ignoringImpCastsERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<Expr> ignoringImpCasts(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches expressions that match InnerMatcher after parentheses and
/// casts are stripped off.
///
/// Implicit and non-C Style casts are also discarded.
/// Given
/// \code
///   int a = 0;
///   char b = (0);
///   void* c = reinterpret_cast<char*>(0);
///   char d = char(0);
/// \endcode
/// The matcher
///    varDecl(hasInitializer(ignoringParenCasts(integerLiteral())))
/// would match the declarations for a, b, c, and d.
/// while
///    varDecl(hasInitializer(integerLiteral()))
/// only match the declaration for a.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::ignoringParenCasts">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 656,
 FQN="clang::ast_matchers::ignoringParenCasts", NM="_ZN5clang12ast_matchers18ignoringParenCastsERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers18ignoringParenCastsERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<Expr> ignoringParenCasts(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches expressions that match InnerMatcher after implicit casts and
/// parentheses are stripped off.
///
/// Explicit casts are not discarded.
/// Given
/// \code
///   int arr[5];
///   int a = 0;
///   char b = (0);
///   const int c = a;
///   int *d = (arr);
///   long e = ((long) 0l);
/// \endcode
/// The matchers
///    varDecl(hasInitializer(ignoringParenImpCasts(integerLiteral())))
///    varDecl(hasInitializer(ignoringParenImpCasts(declRefExpr())))
/// would match the declarations for a, b, c, and d, but not e.
/// while
///    varDecl(hasInitializer(integerLiteral()))
///    varDecl(hasInitializer(declRefExpr()))
/// would only match the declaration for a.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::ignoringParenImpCasts">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 681,
 FQN="clang::ast_matchers::ignoringParenImpCasts", NM="_ZN5clang12ast_matchers21ignoringParenImpCastsERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers21ignoringParenImpCastsERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<Expr> ignoringParenImpCasts(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches types that match InnerMatcher after any parens are stripped.
///
/// Given
/// \code
///   void (*fp)(void);
/// \endcode
/// The matcher
/// \code
///   varDecl(hasType(pointerType(pointee(ignoringParens(functionType())))))
/// \endcode
/// would match the declaration for fp.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::ignoringParens">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 697,
 FQN="clang::ast_matchers::ignoringParens", NM="_ZN5clang12ast_matchers14ignoringParensERKNS0_8internal7MatcherINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers14ignoringParensERKNS0_8internal7MatcherINS_8QualTypeEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<QualType> ignoringParens(final /*const*/ Matcher<QualType> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches classTemplateSpecializations where the n'th TemplateArgument
/// matches the given InnerMatcher.
///
/// Given
/// \code
///   template<typename T, typename U> class A {};
///   A<bool, int> b;
///   A<int, bool> c;
/// \endcode
/// classTemplateSpecializationDecl(hasTemplateArgument(
///     1, refersToType(asString("int"))))
///   matches the specialization \c A<bool, int>
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasTemplateArgument">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 714,
 FQN="clang::ast_matchers::hasTemplateArgument", NM="_ZN5clang12ast_matchers19hasTemplateArgumentERKjRKNS0_8internal7MatcherINS_16TemplateArgumentEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers19hasTemplateArgumentERKjRKNS0_8internal7MatcherINS_16TemplateArgumentEEE")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam2<matcher_hasTemplateArgument0Matcher, /*uint*/Integer, Matcher<TemplateArgument>/*, void (::TypeList<ClassTemplateSpecializationDecl, TemplateSpecializationType>)*/> hasTemplateArgument(final /*const*/uint$ref/*uint &*/ N, final /*const*/ Matcher<TemplateArgument> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if the number of template arguments equals \p N.
///
/// Given
/// \code
///   template<typename T> struct C {};
///   C<int> c;
/// \endcode
/// classTemplateSpecializationDecl(templateArgumentCountIs(1))
///   matches C<int>.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::templateArgumentCountIs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 735,
 FQN="clang::ast_matchers::templateArgumentCountIs", NM="_ZN5clang12ast_matchers23templateArgumentCountIsERKj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers23templateArgumentCountIsERKj")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam1<matcher_templateArgumentCountIs0Matcher, /*uint*/Integer/*, void (::TypeList<ClassTemplateSpecializationDecl, TemplateSpecializationType>)*/> templateArgumentCountIs(final /*const*/uint$ref/*uint &*/ N) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a TemplateArgument that refers to a certain type.
///
/// Given
/// \code
///   struct X {};
///   template<typename T> struct A {};
///   A<X> a;
/// \endcode
/// classTemplateSpecializationDecl(hasAnyTemplateArgument(
///     refersToType(class(hasName("X")))))
///   matches the specialization \c A<X>
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::refersToType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 754,
 FQN="clang::ast_matchers::refersToType", NM="_ZN5clang12ast_matchers12refersToTypeERKNS0_8internal7MatcherINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers12refersToTypeERKNS0_8internal7MatcherINS_8QualTypeEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<TemplateArgument> refersToType(final /*const*/ Matcher<QualType> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a canonical TemplateArgument that refers to a certain
/// declaration.
///
/// Given
/// \code
///   template<typename T> struct A {};
///   struct B { B* next; };
///   A<&B::next> a;
/// \endcode
/// classTemplateSpecializationDecl(hasAnyTemplateArgument(
///     refersToDeclaration(fieldDecl(hasName("next"))))
///   matches the specialization \c A<&B::next> with \c fieldDecl(...) matching
///     \c B::next
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::refersToDeclaration">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 774,
 FQN="clang::ast_matchers::refersToDeclaration", NM="_ZN5clang12ast_matchers19refersToDeclarationERKNS0_8internal7MatcherINS_4DeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers19refersToDeclarationERKNS0_8internal7MatcherINS_4DeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<TemplateArgument> refersToDeclaration(final /*const*/ Matcher<Decl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a sugar TemplateArgument that refers to a certain expression.
///
/// Given
/// \code
///   template<typename T> struct A {};
///   struct B { B* next; };
///   A<&B::next> a;
/// \endcode
/// templateSpecializationType(hasAnyTemplateArgument(
///   isExpr(hasDescendant(declRefExpr(to(fieldDecl(hasName("next"))))))))
///   matches the specialization \c A<&B::next> with \c fieldDecl(...) matching
///     \c B::next
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 793,
 FQN="clang::ast_matchers::isExpr", NM="_ZN5clang12ast_matchers6isExprERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers6isExprERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<TemplateArgument> isExpr(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a TemplateArgument that is an integral value.
///
/// Given
/// \code
///   template<int T> struct A {};
///   C<42> c;
/// \endcode
/// classTemplateSpecializationDecl(
///   hasAnyTemplateArgument(isIntegral()))
///   matches the implicit instantiation of C in C<42>
///   with isIntegral() matching 42.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isIntegral">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 810,
 FQN="clang::ast_matchers::isIntegral", NM="_ZN5clang12ast_matchers10isIntegralEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers10isIntegralEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<TemplateArgument> isIntegral() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a TemplateArgument that referes to an integral type.
///
/// Given
/// \code
///   template<int T> struct A {};
///   C<42> c;
/// \endcode
/// classTemplateSpecializationDecl(
///   hasAnyTemplateArgument(refersToIntegralType(asString("int"))))
///   matches the implicit instantiation of C in C<42>.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::refersToIntegralType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 824,
 FQN="clang::ast_matchers::refersToIntegralType", NM="_ZN5clang12ast_matchers20refersToIntegralTypeERKNS0_8internal7MatcherINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers20refersToIntegralTypeERKNS0_8internal7MatcherINS_8QualTypeEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<TemplateArgument> refersToIntegralType(final /*const*/ Matcher<QualType> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a TemplateArgument of integral type with a given value.
///
/// Note that 'Value' is a string as the template argument's value is
/// an arbitrary precision integer. 'Value' must be euqal to the canonical
/// representation of that integral value in base 10.
///
/// Given
/// \code
///   template<int T> struct A {};
///   C<42> c;
/// \endcode
/// classTemplateSpecializationDecl(
///   hasAnyTemplateArgument(equalsIntegralValue("42")))
///   matches the implicit instantiation of C in C<42>.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::equalsIntegralValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 845,
 FQN="clang::ast_matchers::equalsIntegralValue", NM="_ZN5clang12ast_matchers19equalsIntegralValueERKSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers19equalsIntegralValueERKSs")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<TemplateArgument> equalsIntegralValue(final /*const*/std.string/*&*/ Value) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches any value declaration.
///
/// Example matches A, B, C and F
/// \code
///   enum X { A, B, C };
///   void F();
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::valueDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 859,
 FQN="clang::ast_matchers::valueDecl", NM="_ZN5clang12ast_matchersL9valueDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL9valueDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, ValueDecl> valueDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, ValueDecl>();

/// \brief Matches C++ constructor declarations.
///
/// Example matches Foo::Foo() and Foo::Foo(int)
/// \code
///   class Foo {
///    public:
///     Foo();
///     Foo(int);
///     int DoSomething();
///   };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxConstructorDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 872,
 FQN="clang::ast_matchers::cxxConstructorDecl", NM="_ZN5clang12ast_matchersL18cxxConstructorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL18cxxConstructorDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, CXXConstructorDecl> cxxConstructorDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, CXXConstructorDecl>();

/// \brief Matches explicit C++ destructor declarations.
///
/// Example matches Foo::~Foo()
/// \code
///   class Foo {
///    public:
///     virtual ~Foo();
///   };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxDestructorDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 885,
 FQN="clang::ast_matchers::cxxDestructorDecl", NM="_ZN5clang12ast_matchersL17cxxDestructorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL17cxxDestructorDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, CXXDestructorDecl> cxxDestructorDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, CXXDestructorDecl>();

/// \brief Matches enum declarations.
///
/// Example matches X
/// \code
///   enum X {
///     A, B, C
///   };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::enumDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 897,
 FQN="clang::ast_matchers::enumDecl", NM="_ZN5clang12ast_matchersL8enumDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL8enumDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, EnumDecl> enumDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, EnumDecl>();

/// \brief Matches enum constants.
///
/// Example matches A, B, C
/// \code
///   enum X {
///     A, B, C
///   };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::enumConstantDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 907,
 FQN="clang::ast_matchers::enumConstantDecl", NM="_ZN5clang12ast_matchersL16enumConstantDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL16enumConstantDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, EnumConstantDecl> enumConstantDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, EnumConstantDecl>();

/// \brief Matches method declarations.
///
/// Example matches y
/// \code
///   class X { void y(); };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxMethodDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 917,
 FQN="clang::ast_matchers::cxxMethodDecl", NM="_ZN5clang12ast_matchersL13cxxMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL13cxxMethodDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, CXXMethodDecl> cxxMethodDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, CXXMethodDecl>();

/// \brief Matches conversion operator declarations.
///
/// Example matches the operator.
/// \code
///   class X { operator int() const; };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxConversionDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 925,
 FQN="clang::ast_matchers::cxxConversionDecl", NM="_ZN5clang12ast_matchersL17cxxConversionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL17cxxConversionDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, CXXConversionDecl> cxxConversionDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, CXXConversionDecl>();

/// \brief Matches variable declarations.
///
/// Note: this does not match declarations of member variables, which are
/// "field" declarations in Clang parlance.
///
/// Example matches a
/// \code
///   int a;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::varDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 937,
 FQN="clang::ast_matchers::varDecl", NM="_ZN5clang12ast_matchersL7varDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL7varDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, VarDecl> varDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, VarDecl>();

/// \brief Matches field declarations.
///
/// Given
/// \code
///   class X { int m; };
/// \endcode
/// fieldDecl()
///   matches 'm'.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::fieldDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 947,
 FQN="clang::ast_matchers::fieldDecl", NM="_ZN5clang12ast_matchersL9fieldDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL9fieldDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, FieldDecl> fieldDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, FieldDecl>();

/// \brief Matches function declarations.
///
/// Example matches f
/// \code
///   void f();
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::functionDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 955,
 FQN="clang::ast_matchers::functionDecl", NM="_ZN5clang12ast_matchersL12functionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL12functionDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, FunctionDecl> functionDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, FunctionDecl>();

/// \brief Matches C++ function template declarations.
///
/// Example matches f
/// \code
///   template<class T> void f(T t) {}
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::functionTemplateDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 963,
 FQN="clang::ast_matchers::functionTemplateDecl", NM="_ZN5clang12ast_matchersL20functionTemplateDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL20functionTemplateDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, FunctionTemplateDecl> functionTemplateDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, FunctionTemplateDecl>();

/// \brief Matches friend declarations.
///
/// Given
/// \code
///   class X { friend void foo(); };
/// \endcode
/// friendDecl()
///   matches 'friend void foo()'.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::friendDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 975,
 FQN="clang::ast_matchers::friendDecl", NM="_ZN5clang12ast_matchersL10friendDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL10friendDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, FriendDecl> friendDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, FriendDecl>();

/// \brief Matches statements.
///
/// Given
/// \code
///   { ++a; }
/// \endcode
/// stmt()
///   matches both the compound statement '{ ++a; }' and '++a'.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::stmt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 985,
 FQN="clang::ast_matchers::stmt", NM="_ZN5clang12ast_matchersL4stmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL4stmtE")
//</editor-fold>
public static /*const*/ VariadicAllOfMatcher<Stmt> stmt/*J*/= new VariadicAllOfMatcher<Stmt>();

/// \brief Matches declaration statements.
///
/// Given
/// \code
///   int a;
/// \endcode
/// declStmt()
///   matches 'int a'.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::declStmt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 995,
 FQN="clang::ast_matchers::declStmt", NM="_ZN5clang12ast_matchersL8declStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL8declStmtE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, DeclStmt> declStmt/*J*/= new VariadicDynCastAllOfMatcher<Stmt, DeclStmt>();

/// \brief Matches member expressions.
///
/// Given
/// \code
///   class Y {
///     void x() { this->x(); x(); Y y; y.x(); a; this->b; Y::b; }
///     int a; static int b;
///   };
/// \endcode
/// memberExpr()
///   matches this->x, x, y.x, a, this->b
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::memberExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1010,
 FQN="clang::ast_matchers::memberExpr", NM="_ZN5clang12ast_matchersL10memberExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL10memberExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, MemberExpr> memberExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, MemberExpr>();

/// \brief Matches call expressions.
///
/// Example matches x.y() and y()
/// \code
///   X x;
///   x.y();
///   y();
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::callExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1020,
 FQN="clang::ast_matchers::callExpr", NM="_ZN5clang12ast_matchersL8callExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL8callExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CallExpr> callExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CallExpr>();

/// \brief Matches lambda expressions.
///
/// Example matches [&](){return 5;}
/// \code
///   [&](){return 5;}
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::lambdaExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1028,
 FQN="clang::ast_matchers::lambdaExpr", NM="_ZN5clang12ast_matchersL10lambdaExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL10lambdaExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, LambdaExpr> lambdaExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, LambdaExpr>();

/// \brief Matches member call expressions.
///
/// Example matches x.y()
/// \code
///   X x;
///   x.y();
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxMemberCallExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1037,
 FQN="clang::ast_matchers::cxxMemberCallExpr", NM="_ZN5clang12ast_matchersL17cxxMemberCallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL17cxxMemberCallExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CXXMemberCallExpr> cxxMemberCallExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CXXMemberCallExpr>();

/// \brief Matches ObjectiveC Message invocation expressions.
///
/// The innermost message send invokes the "alloc" class method on the
/// NSString class, while the outermost message send invokes the
/// "initWithString" instance method on the object returned from
/// NSString's "alloc". This matcher should match both message sends.
/// \code
///   [[NSString alloc] initWithString:@"Hello"]
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::objcMessageExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1050,
 FQN="clang::ast_matchers::objcMessageExpr", NM="_ZN5clang12ast_matchersL15objcMessageExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL15objcMessageExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, ObjCMessageExpr> objcMessageExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, ObjCMessageExpr>();

/// \brief Matches Objective-C interface declarations.
///
/// Example matches Foo
/// \code
///   @interface Foo
///   @end
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::objcInterfaceDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1061,
 FQN="clang::ast_matchers::objcInterfaceDecl", NM="_ZN5clang12ast_matchersL17objcInterfaceDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL17objcInterfaceDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, ObjCInterfaceDecl> objcInterfaceDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, ObjCInterfaceDecl>();

/// \brief Matches expressions that introduce cleanups to be run at the end
/// of the sub-expression's evaluation.
///
/// Example matches std::string()
/// \code
///   const std::string str = std::string();
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::exprWithCleanups">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1072,
 FQN="clang::ast_matchers::exprWithCleanups", NM="_ZN5clang12ast_matchersL16exprWithCleanupsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL16exprWithCleanupsE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, ExprWithCleanups> exprWithCleanups/*J*/= new VariadicDynCastAllOfMatcher<Stmt, ExprWithCleanups>();

/// \brief Matches init list expressions.
///
/// Given
/// \code
///   int a[] = { 1, 2 };
///   struct B { int x, y; };
///   B b = { 5, 6 };
/// \endcode
/// initListExpr()
///   matches "{ 1, 2 }" and "{ 5, 6 }"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::initListExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1086,
 FQN="clang::ast_matchers::initListExpr", NM="_ZN5clang12ast_matchersL12initListExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL12initListExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, InitListExpr> initListExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, InitListExpr>();

/// \brief Matches the syntactic form of init list expressions
/// (if expression have it).
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasSyntacticForm">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1090,
 FQN="clang::ast_matchers::hasSyntacticForm", NM="_ZN5clang12ast_matchers16hasSyntacticFormERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers16hasSyntacticFormERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<InitListExpr> hasSyntacticForm(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches implicit initializers of init list expressions.
///
/// Given
/// \code
///   point ptarray[10] = { [2].y = 1.0, [2].x = 2.0, [0].x = 1.0 };
/// \endcode
/// implicitValueInitExpr()
///   matches "[0].y" (implicitly)
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::implicitValueInitExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1105,
 FQN="clang::ast_matchers::implicitValueInitExpr", NM="_ZN5clang12ast_matchersL21implicitValueInitExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL21implicitValueInitExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, ImplicitValueInitExpr> implicitValueInitExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, ImplicitValueInitExpr>();

/// \brief Matches paren list expressions.
/// ParenListExprs don't have a predefined type and are used for late parsing.
/// In the final AST, they can be met in template declarations.
///
/// Given
/// \code
///   template<typename T> class X {
///     void f() {
///       X x(*this);
///       int a = 0, b = 1; int i = (a, b);
///     }
///   };
/// \endcode
/// parenListExpr() matches "*this" but NOT matches (a, b) because (a, b)
/// has a predefined type and is a ParenExpr, not a ParenListExpr.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::parenListExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1123,
 FQN="clang::ast_matchers::parenListExpr", NM="_ZN5clang12ast_matchersL13parenListExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL13parenListExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, ParenListExpr> parenListExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, ParenListExpr>();

/// \brief Matches substitutions of non-type template parameters.
///
/// Given
/// \code
///   template <int N>
///   struct A { static const int n = N; };
///   struct B : public A<42> {};
/// \endcode
/// substNonTypeTemplateParmExpr()
///   matches "N" in the right-hand side of "static const int n = N;"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::substNonTypeTemplateParmExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1135,
 FQN="clang::ast_matchers::substNonTypeTemplateParmExpr", NM="_ZN5clang12ast_matchersL28substNonTypeTemplateParmExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL28substNonTypeTemplateParmExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, SubstNonTypeTemplateParmExpr> substNonTypeTemplateParmExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, SubstNonTypeTemplateParmExpr>();

/// \brief Matches using declarations.
///
/// Given
/// \code
///   namespace X { int x; }
///   using X::x;
/// \endcode
/// usingDecl()
///   matches \code using X::x \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::usingDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1148,
 FQN="clang::ast_matchers::usingDecl", NM="_ZN5clang12ast_matchersL9usingDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL9usingDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, UsingDecl> usingDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, UsingDecl>();

/// \brief Matches using namespace declarations.
///
/// Given
/// \code
///   namespace X { int x; }
///   using namespace X;
/// \endcode
/// usingDirectiveDecl()
///   matches \code using namespace X \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::usingDirectiveDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1159,
 FQN="clang::ast_matchers::usingDirectiveDecl", NM="_ZN5clang12ast_matchersL18usingDirectiveDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL18usingDirectiveDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, UsingDirectiveDecl> usingDirectiveDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, UsingDirectiveDecl>();

/// \brief Matches reference to a name that can be looked up during parsing
/// but could not be resolved to a specific declaration.
///
/// Given
/// \code
///   template<typename T>
///   T foo() { T a; return a; }
///   template<typename T>
///   void bar() {
///     foo<T>();
///   }
/// \endcode
/// unresolvedLookupExpr()
///   matches \code foo<T>() \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::unresolvedLookupExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1177,
 FQN="clang::ast_matchers::unresolvedLookupExpr", NM="_ZN5clang12ast_matchersL20unresolvedLookupExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL20unresolvedLookupExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, UnresolvedLookupExpr> unresolvedLookupExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, UnresolvedLookupExpr>();

/// \brief Matches unresolved using value declarations.
///
/// Given
/// \code
///   template<typename X>
///   class C : private X {
///     using X::x;
///   };
/// \endcode
/// unresolvedUsingValueDecl()
///   matches \code using X::x \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::unresolvedUsingValueDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1192,
 FQN="clang::ast_matchers::unresolvedUsingValueDecl", NM="_ZN5clang12ast_matchersL24unresolvedUsingValueDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL24unresolvedUsingValueDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, UnresolvedUsingValueDecl> unresolvedUsingValueDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, UnresolvedUsingValueDecl>();

/// \brief Matches unresolved using value declarations that involve the
/// typename.
///
/// Given
/// \code
///   template <typename T>
///   struct Base { typedef T Foo; };
///
///   template<typename T>
///   struct S : private Base<T> {
///     using typename Base<T>::Foo;
///   };
/// \endcode
/// unresolvedUsingTypenameDecl()
///   matches \code using Base<T>::Foo \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::unresolvedUsingTypenameDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1211,
 FQN="clang::ast_matchers::unresolvedUsingTypenameDecl", NM="_ZN5clang12ast_matchersL27unresolvedUsingTypenameDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL27unresolvedUsingTypenameDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, UnresolvedUsingTypenameDecl> unresolvedUsingTypenameDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, UnresolvedUsingTypenameDecl>();

/// \brief Matches parentheses used in expressions.
///
/// Example matches (foo() + 1)
/// \code
///   int foo() { return 1; }
///   int a = (foo() + 1);
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::parenExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1222,
 FQN="clang::ast_matchers::parenExpr", NM="_ZN5clang12ast_matchersL9parenExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL9parenExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, ParenExpr> parenExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, ParenExpr>();

/// \brief Matches constructor call expressions (including implicit ones).
///
/// Example matches string(ptr, n) and ptr within arguments of f
///     (matcher = cxxConstructExpr())
/// \code
///   void f(const string &a, const string &b);
///   char *ptr;
///   int n;
///   f(string(ptr, n), ptr);
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxConstructExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1236,
 FQN="clang::ast_matchers::cxxConstructExpr", NM="_ZN5clang12ast_matchersL16cxxConstructExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL16cxxConstructExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CXXConstructExpr> cxxConstructExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CXXConstructExpr>();

/// \brief Matches unresolved constructor call expressions.
///
/// Example matches T(t) in return statement of f
///     (matcher = cxxUnresolvedConstructExpr())
/// \code
///   template <typename T>
///   void f(const T& t) { return T(t); }
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxUnresolvedConstructExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1248,
 FQN="clang::ast_matchers::cxxUnresolvedConstructExpr", NM="_ZN5clang12ast_matchersL26cxxUnresolvedConstructExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL26cxxUnresolvedConstructExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CXXUnresolvedConstructExpr> cxxUnresolvedConstructExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CXXUnresolvedConstructExpr>();

/// \brief Matches implicit and explicit this expressions.
///
/// Example matches the implicit this expression in "return i".
///     (matcher = cxxThisExpr())
/// \code
/// struct foo {
///   int i;
///   int f() { return i; }
/// };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxThisExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1262,
 FQN="clang::ast_matchers::cxxThisExpr", NM="_ZN5clang12ast_matchersL11cxxThisExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL11cxxThisExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CXXThisExpr> cxxThisExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CXXThisExpr>();

/// \brief Matches nodes where temporaries are created.
///
/// Example matches FunctionTakesString(GetStringByValue())
///     (matcher = cxxBindTemporaryExpr())
/// \code
///   FunctionTakesString(GetStringByValue());
///   FunctionTakesStringByPointer(GetStringPointer());
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxBindTemporaryExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1272,
 FQN="clang::ast_matchers::cxxBindTemporaryExpr", NM="_ZN5clang12ast_matchersL20cxxBindTemporaryExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL20cxxBindTemporaryExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CXXBindTemporaryExpr> cxxBindTemporaryExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CXXBindTemporaryExpr>();

/// \brief Matches nodes where temporaries are materialized.
///
/// Example: Given
/// \code
///   struct T {void func()};
///   T f();
///   void g(T);
/// \endcode
/// materializeTemporaryExpr() matches 'f()' in these statements
/// \code
///   T u(f());
///   g(f());
/// \endcode
/// but does not match
/// \code
///   f();
///   f().func();
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::materializeTemporaryExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1294,
 FQN="clang::ast_matchers::materializeTemporaryExpr", NM="_ZN5clang12ast_matchersL24materializeTemporaryExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL24materializeTemporaryExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, MaterializeTemporaryExpr> materializeTemporaryExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, MaterializeTemporaryExpr>();

/// \brief Matches new expressions.
///
/// Given
/// \code
///   new X;
/// \endcode
/// cxxNewExpr()
///   matches 'new X'.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxNewExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1306,
 FQN="clang::ast_matchers::cxxNewExpr", NM="_ZN5clang12ast_matchersL10cxxNewExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL10cxxNewExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CXXNewExpr> cxxNewExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CXXNewExpr>();

/// \brief Matches delete expressions.
///
/// Given
/// \code
///   delete X;
/// \endcode
/// cxxDeleteExpr()
///   matches 'delete X'.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxDeleteExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1316,
 FQN="clang::ast_matchers::cxxDeleteExpr", NM="_ZN5clang12ast_matchersL13cxxDeleteExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL13cxxDeleteExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CXXDeleteExpr> cxxDeleteExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CXXDeleteExpr>();

/// \brief Matches array subscript expressions.
///
/// Given
/// \code
///   int i = a[1];
/// \endcode
/// arraySubscriptExpr()
///   matches "a[1]"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::arraySubscriptExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1326,
 FQN="clang::ast_matchers::arraySubscriptExpr", NM="_ZN5clang12ast_matchersL18arraySubscriptExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL18arraySubscriptExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, ArraySubscriptExpr> arraySubscriptExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, ArraySubscriptExpr>();

/// \brief Matches the value of a default argument at the call site.
///
/// Example matches the CXXDefaultArgExpr placeholder inserted for the
///     default value of the second parameter in the call expression f(42)
///     (matcher = cxxDefaultArgExpr())
/// \code
///   void f(int x, int y = 0);
///   f(42);
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxDefaultArgExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1339,
 FQN="clang::ast_matchers::cxxDefaultArgExpr", NM="_ZN5clang12ast_matchersL17cxxDefaultArgExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL17cxxDefaultArgExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CXXDefaultArgExpr> cxxDefaultArgExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CXXDefaultArgExpr>();

/// \brief Matches overloaded operator calls.
///
/// Note that if an operator isn't overloaded, it won't match. Instead, use
/// binaryOperator matcher.
/// Currently it does not match operators such as new delete.
/// FIXME: figure out why these do not match?
///
/// Example matches both operator<<((o << b), c) and operator<<(o, b)
///     (matcher = cxxOperatorCallExpr())
/// \code
///   ostream &operator<< (ostream &out, int i) { };
///   ostream &o; int b = 1, c = 1;
///   o << b << c;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxOperatorCallExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1357,
 FQN="clang::ast_matchers::cxxOperatorCallExpr", NM="_ZN5clang12ast_matchersL19cxxOperatorCallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL19cxxOperatorCallExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CXXOperatorCallExpr> cxxOperatorCallExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CXXOperatorCallExpr>();

/// \brief Matches expressions.
///
/// Example matches x()
/// \code
///   void f() { x(); }
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::expr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1367,
 FQN="clang::ast_matchers::expr", NM="_ZN5clang12ast_matchersL4exprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL4exprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, Expr> expr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, Expr>();

/// \brief Matches expressions that refer to declarations.
///
/// Example matches x in if (x)
/// \code
///   bool x;
///   if (x) {}
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::declRefExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1376,
 FQN="clang::ast_matchers::declRefExpr", NM="_ZN5clang12ast_matchersL11declRefExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL11declRefExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, DeclRefExpr> declRefExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, DeclRefExpr>();

/// \brief Matches if statements.
///
/// Example matches 'if (x) {}'
/// \code
///   if (x) {}
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::ifStmt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1384,
 FQN="clang::ast_matchers::ifStmt", NM="_ZN5clang12ast_matchersL6ifStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL6ifStmtE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, IfStmt> ifStmt/*J*/= new VariadicDynCastAllOfMatcher<Stmt, IfStmt>();

/// \brief Matches for statements.
///
/// Example matches 'for (;;) {}'
/// \code
///   for (;;) {}
///   int i[] =  {1, 2, 3}; for (auto a : i);
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::forStmt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1393,
 FQN="clang::ast_matchers::forStmt", NM="_ZN5clang12ast_matchersL7forStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL7forStmtE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, ForStmt> forStmt/*J*/= new VariadicDynCastAllOfMatcher<Stmt, ForStmt>();

/// \brief Matches the increment statement of a for loop.
///
/// Example:
///     forStmt(hasIncrement(unaryOperator(hasOperatorName("++"))))
/// matches '++x' in
/// \code
///     for (x; x < N; ++x) { }
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasIncrement">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1403,
 FQN="clang::ast_matchers::hasIncrement", NM="_ZN5clang12ast_matchers12hasIncrementERKNS0_8internal7MatcherINS_4StmtEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers12hasIncrementERKNS0_8internal7MatcherINS_4StmtEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<ForStmt> hasIncrement(final /*const*/ Matcher<Stmt> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the initialization statement of a for loop.
///
/// Example:
///     forStmt(hasLoopInit(declStmt()))
/// matches 'int x = 0' in
/// \code
///     for (int x = 0; x < N; ++x) { }
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasLoopInit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1418,
 FQN="clang::ast_matchers::hasLoopInit", NM="_ZN5clang12ast_matchers11hasLoopInitERKNS0_8internal7MatcherINS_4StmtEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11hasLoopInitERKNS0_8internal7MatcherINS_4StmtEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<ForStmt> hasLoopInit(final /*const*/ Matcher<Stmt> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches range-based for statements.
///
/// cxxForRangeStmt() matches 'for (auto a : i)'
/// \code
///   int i[] =  {1, 2, 3}; for (auto a : i);
///   for(int j = 0; j < 5; ++j);
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxForRangeStmt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1431,
 FQN="clang::ast_matchers::cxxForRangeStmt", NM="_ZN5clang12ast_matchersL15cxxForRangeStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL15cxxForRangeStmtE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CXXForRangeStmt> cxxForRangeStmt/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CXXForRangeStmt>();

/// \brief Matches the initialization statement of a for loop.
///
/// Example:
///     forStmt(hasLoopVariable(anything()))
/// matches 'int x' in
/// \code
///     for (int x : a) { }
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasLoopVariable">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1443,
 FQN="clang::ast_matchers::hasLoopVariable", NM="_ZN5clang12ast_matchers15hasLoopVariableERKNS0_8internal7MatcherINS_7VarDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers15hasLoopVariableERKNS0_8internal7MatcherINS_7VarDeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXForRangeStmt> hasLoopVariable(final /*const*/ Matcher<VarDecl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the range initialization statement of a for loop.
///
/// Example:
///     forStmt(hasRangeInit(anything()))
/// matches 'a' in
/// \code
///     for (int x : a) { }
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasRangeInit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1457,
 FQN="clang::ast_matchers::hasRangeInit", NM="_ZN5clang12ast_matchers12hasRangeInitERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers12hasRangeInitERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXForRangeStmt> hasRangeInit(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches while statements.
///
/// Given
/// \code
///   while (true) {}
/// \endcode
/// whileStmt()
///   matches 'while (true) {}'.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::whileStmt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1471,
 FQN="clang::ast_matchers::whileStmt", NM="_ZN5clang12ast_matchersL9whileStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL9whileStmtE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, WhileStmt> whileStmt/*J*/= new VariadicDynCastAllOfMatcher<Stmt, WhileStmt>();

/// \brief Matches do statements.
///
/// Given
/// \code
///   do {} while (true);
/// \endcode
/// doStmt()
///   matches 'do {} while(true)'
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::doStmt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1481,
 FQN="clang::ast_matchers::doStmt", NM="_ZN5clang12ast_matchersL6doStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL6doStmtE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, DoStmt> doStmt/*J*/= new VariadicDynCastAllOfMatcher<Stmt, DoStmt>();

/// \brief Matches break statements.
///
/// Given
/// \code
///   while (true) { break; }
/// \endcode
/// breakStmt()
///   matches 'break'
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::breakStmt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1491,
 FQN="clang::ast_matchers::breakStmt", NM="_ZN5clang12ast_matchersL9breakStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL9breakStmtE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, BreakStmt> breakStmt/*J*/= new VariadicDynCastAllOfMatcher<Stmt, BreakStmt>();

/// \brief Matches continue statements.
///
/// Given
/// \code
///   while (true) { continue; }
/// \endcode
/// continueStmt()
///   matches 'continue'
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::continueStmt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1501,
 FQN="clang::ast_matchers::continueStmt", NM="_ZN5clang12ast_matchersL12continueStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL12continueStmtE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, ContinueStmt> continueStmt/*J*/= new VariadicDynCastAllOfMatcher<Stmt, ContinueStmt>();

/// \brief Matches return statements.
///
/// Given
/// \code
///   return 1;
/// \endcode
/// returnStmt()
///   matches 'return 1'
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::returnStmt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1511,
 FQN="clang::ast_matchers::returnStmt", NM="_ZN5clang12ast_matchersL10returnStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL10returnStmtE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, ReturnStmt> returnStmt/*J*/= new VariadicDynCastAllOfMatcher<Stmt, ReturnStmt>();

/// \brief Matches goto statements.
///
/// Given
/// \code
///   goto FOO;
///   FOO: bar();
/// \endcode
/// gotoStmt()
///   matches 'goto FOO'
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::gotoStmt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1522,
 FQN="clang::ast_matchers::gotoStmt", NM="_ZN5clang12ast_matchersL8gotoStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL8gotoStmtE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, GotoStmt> gotoStmt/*J*/= new VariadicDynCastAllOfMatcher<Stmt, GotoStmt>();

/// \brief Matches label statements.
///
/// Given
/// \code
///   goto FOO;
///   FOO: bar();
/// \endcode
/// labelStmt()
///   matches 'FOO:'
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::labelStmt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1533,
 FQN="clang::ast_matchers::labelStmt", NM="_ZN5clang12ast_matchersL9labelStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL9labelStmtE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, LabelStmt> labelStmt/*J*/= new VariadicDynCastAllOfMatcher<Stmt, LabelStmt>();

/// \brief Matches address of label statements (GNU extension).
///
/// Given
/// \code
///   FOO: bar();
///   void *ptr = &&FOO;
///   goto *bar;
/// \endcode
/// addrLabelExpr()
///   matches '&&FOO'
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::addrLabelExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1545,
 FQN="clang::ast_matchers::addrLabelExpr", NM="_ZN5clang12ast_matchersL13addrLabelExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL13addrLabelExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, AddrLabelExpr> addrLabelExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, AddrLabelExpr>();

/// \brief Matches switch statements.
///
/// Given
/// \code
///   switch(a) { case 42: break; default: break; }
/// \endcode
/// switchStmt()
///   matches 'switch(a)'.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::switchStmt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1555,
 FQN="clang::ast_matchers::switchStmt", NM="_ZN5clang12ast_matchersL10switchStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL10switchStmtE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, SwitchStmt> switchStmt/*J*/= new VariadicDynCastAllOfMatcher<Stmt, SwitchStmt>();

/// \brief Matches case and default statements inside switch statements.
///
/// Given
/// \code
///   switch(a) { case 42: break; default: break; }
/// \endcode
/// switchCase()
///   matches 'case 42: break;' and 'default: break;'.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::switchCase">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1565,
 FQN="clang::ast_matchers::switchCase", NM="_ZN5clang12ast_matchersL10switchCaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL10switchCaseE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, SwitchCase> switchCase/*J*/= new VariadicDynCastAllOfMatcher<Stmt, SwitchCase>();

/// \brief Matches case statements inside switch statements.
///
/// Given
/// \code
///   switch(a) { case 42: break; default: break; }
/// \endcode
/// caseStmt()
///   matches 'case 42: break;'.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::caseStmt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1575,
 FQN="clang::ast_matchers::caseStmt", NM="_ZN5clang12ast_matchersL8caseStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL8caseStmtE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CaseStmt> caseStmt/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CaseStmt>();

/// \brief Matches default statements inside switch statements.
///
/// Given
/// \code
///   switch(a) { case 42: break; default: break; }
/// \endcode
/// defaultStmt()
///   matches 'default: break;'.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::defaultStmt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1585,
 FQN="clang::ast_matchers::defaultStmt", NM="_ZN5clang12ast_matchersL11defaultStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL11defaultStmtE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, DefaultStmt> defaultStmt/*J*/= new VariadicDynCastAllOfMatcher<Stmt, DefaultStmt>();

/// \brief Matches compound statements.
///
/// Example matches '{}' and '{{}}'in 'for (;;) {{}}'
/// \code
///   for (;;) {{}}
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::compoundStmt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1593,
 FQN="clang::ast_matchers::compoundStmt", NM="_ZN5clang12ast_matchersL12compoundStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL12compoundStmtE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CompoundStmt> compoundStmt/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CompoundStmt>();

/// \brief Matches catch statements.
///
/// \code
///   try {} catch(int i) {}
/// \endcode
/// cxxCatchStmt()
///   matches 'catch(int i)'
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxCatchStmt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1602,
 FQN="clang::ast_matchers::cxxCatchStmt", NM="_ZN5clang12ast_matchersL12cxxCatchStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL12cxxCatchStmtE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CXXCatchStmt> cxxCatchStmt/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CXXCatchStmt>();

/// \brief Matches try statements.
///
/// \code
///   try {} catch(int i) {}
/// \endcode
/// cxxTryStmt()
///   matches 'try {}'
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxTryStmt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1611,
 FQN="clang::ast_matchers::cxxTryStmt", NM="_ZN5clang12ast_matchersL10cxxTryStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL10cxxTryStmtE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CXXTryStmt> cxxTryStmt/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CXXTryStmt>();

/// \brief Matches throw expressions.
///
/// \code
///   try { throw 5; } catch(int i) {}
/// \endcode
/// cxxThrowExpr()
///   matches 'throw 5'
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxThrowExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1620,
 FQN="clang::ast_matchers::cxxThrowExpr", NM="_ZN5clang12ast_matchersL12cxxThrowExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL12cxxThrowExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CXXThrowExpr> cxxThrowExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CXXThrowExpr>();

/// \brief Matches null statements.
///
/// \code
///   foo();;
/// \endcode
/// nullStmt()
///   matches the second ';'
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::nullStmt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1629,
 FQN="clang::ast_matchers::nullStmt", NM="_ZN5clang12ast_matchersL8nullStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL8nullStmtE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, NullStmt> nullStmt/*J*/= new VariadicDynCastAllOfMatcher<Stmt, NullStmt>();

/// \brief Matches asm statements.
///
/// \code
///  int i = 100;
///   __asm("mov al, 2");
/// \endcode
/// asmStmt()
///   matches '__asm("mov al, 2")'
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::asmStmt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1639,
 FQN="clang::ast_matchers::asmStmt", NM="_ZN5clang12ast_matchersL7asmStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL7asmStmtE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, AsmStmt> asmStmt/*J*/= new VariadicDynCastAllOfMatcher<Stmt, AsmStmt>();

/// \brief Matches bool literals.
///
/// Example matches true
/// \code
///   true
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxBoolLiteral">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1647,
 FQN="clang::ast_matchers::cxxBoolLiteral", NM="_ZN5clang12ast_matchersL14cxxBoolLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL14cxxBoolLiteralE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CXXBoolLiteralExpr> cxxBoolLiteral/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CXXBoolLiteralExpr>();

/// \brief Matches string literals (also matches wide string literals).
///
/// Example matches "abcd", L"abcd"
/// \code
///   char *s = "abcd";
///   wchar_t *ws = L"abcd";
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::stringLiteral">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1658,
 FQN="clang::ast_matchers::stringLiteral", NM="_ZN5clang12ast_matchersL13stringLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL13stringLiteralE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, StringLiteral> stringLiteral/*J*/= new VariadicDynCastAllOfMatcher<Stmt, StringLiteral>();

/// \brief Matches character literals (also matches wchar_t).
///
/// Not matching Hex-encoded chars (e.g. 0x1234, which is a IntegerLiteral),
/// though.
///
/// Example matches 'a', L'a'
/// \code
///   char ch = 'a';
///   wchar_t chw = L'a';
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::characterLiteral">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1672,
 FQN="clang::ast_matchers::characterLiteral", NM="_ZN5clang12ast_matchersL16characterLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL16characterLiteralE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CharacterLiteral> characterLiteral/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CharacterLiteral>();

/// \brief Matches integer literals of all sizes / encodings, e.g.
/// 1, 1L, 0x1 and 1U.
///
/// Does not match character-encoded integers such as L'a'.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::integerLiteral">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1680,
 FQN="clang::ast_matchers::integerLiteral", NM="_ZN5clang12ast_matchersL14integerLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL14integerLiteralE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, IntegerLiteral> integerLiteral/*J*/= new VariadicDynCastAllOfMatcher<Stmt, IntegerLiteral>();

/// \brief Matches float literals of all sizes / encodings, e.g.
/// 1.0, 1.0f, 1.0L and 1e10.
///
/// Does not match implicit conversions such as
/// \code
///   float a = 10;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::floatLiteral">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1691,
 FQN="clang::ast_matchers::floatLiteral", NM="_ZN5clang12ast_matchersL12floatLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL12floatLiteralE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, FloatingLiteral> floatLiteral/*J*/= new VariadicDynCastAllOfMatcher<Stmt, FloatingLiteral>();

/// \brief Matches user defined literal operator call.
///
/// Example match: "foo"_suffix
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::userDefinedLiteral">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1698,
 FQN="clang::ast_matchers::userDefinedLiteral", NM="_ZN5clang12ast_matchersL18userDefinedLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL18userDefinedLiteralE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, UserDefinedLiteral> userDefinedLiteral/*J*/= new VariadicDynCastAllOfMatcher<Stmt, UserDefinedLiteral>();

/// \brief Matches compound (i.e. non-scalar) literals
///
/// Example match: {1}, (1, 2)
/// \code
///   int array[4] = {1};
///   vector int myvec = (vector int)(1, 2);
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::compoundLiteralExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1709,
 FQN="clang::ast_matchers::compoundLiteralExpr", NM="_ZN5clang12ast_matchersL19compoundLiteralExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL19compoundLiteralExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CompoundLiteralExpr> compoundLiteralExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CompoundLiteralExpr>();

/// \brief Matches nullptr literal.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxNullPtrLiteralExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1714,
 FQN="clang::ast_matchers::cxxNullPtrLiteralExpr", NM="_ZN5clang12ast_matchersL21cxxNullPtrLiteralExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL21cxxNullPtrLiteralExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CXXNullPtrLiteralExpr> cxxNullPtrLiteralExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CXXNullPtrLiteralExpr>();

/// \brief Matches GNU __null expression.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::gnuNullExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1719,
 FQN="clang::ast_matchers::gnuNullExpr", NM="_ZN5clang12ast_matchersL11gnuNullExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL11gnuNullExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, GNUNullExpr> gnuNullExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, GNUNullExpr>();

/// \brief Matches atomic builtins.
/// Example matches __atomic_load_n(ptr, 1)
/// \code
///   void foo() { int *ptr; __atomic_load_n(ptr, 1); }
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::atomicExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1726,
 FQN="clang::ast_matchers::atomicExpr", NM="_ZN5clang12ast_matchersL10atomicExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL10atomicExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, AtomicExpr> atomicExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, AtomicExpr>();

/// \brief Matches statement expression (GNU extension).
///
/// Example match: ({ int X = 4; X; })
/// \code
///   int C = ({ int X = 4; X; });
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::stmtExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1734,
 FQN="clang::ast_matchers::stmtExpr", NM="_ZN5clang12ast_matchersL8stmtExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL8stmtExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, StmtExpr> stmtExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, StmtExpr>();

/// \brief Matches binary operator expressions.
///
/// Example matches a || b
/// \code
///   !(a || b)
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::binaryOperator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1742,
 FQN="clang::ast_matchers::binaryOperator", NM="_ZN5clang12ast_matchersL14binaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL14binaryOperatorE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, BinaryOperator> binaryOperator/*J*/= new VariadicDynCastAllOfMatcher<Stmt, BinaryOperator>();

/// \brief Matches unary operator expressions.
///
/// Example matches !a
/// \code
///   !a || b
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::unaryOperator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1752,
 FQN="clang::ast_matchers::unaryOperator", NM="_ZN5clang12ast_matchersL13unaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL13unaryOperatorE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, UnaryOperator> unaryOperator/*J*/= new VariadicDynCastAllOfMatcher<Stmt, UnaryOperator>();

/// \brief Matches conditional operator expressions.
///
/// Example matches a ? b : c
/// \code
///   (a ? b : c) + 42
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::conditionalOperator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1762,
 FQN="clang::ast_matchers::conditionalOperator", NM="_ZN5clang12ast_matchersL19conditionalOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL19conditionalOperatorE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, ConditionalOperator> conditionalOperator/*J*/= new VariadicDynCastAllOfMatcher<Stmt, ConditionalOperator>();

/// \brief Matches binary conditional operator expressions (GNU extension).
///
/// Example matches a ?: b
/// \code
///   (a ?: b) + 42;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::binaryConditionalOperator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1772,
 FQN="clang::ast_matchers::binaryConditionalOperator", NM="_ZN5clang12ast_matchersL25binaryConditionalOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL25binaryConditionalOperatorE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, BinaryConditionalOperator> binaryConditionalOperator/*J*/= new VariadicDynCastAllOfMatcher<Stmt, BinaryConditionalOperator>();

/// \brief Matches opaque value expressions. They are used as helpers
/// to reference another expressions and can be met
/// in BinaryConditionalOperators, for example.
///
/// Example matches 'a'
/// \code
///   (a ?: c) + 42;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::opaqueValueExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1784,
 FQN="clang::ast_matchers::opaqueValueExpr", NM="_ZN5clang12ast_matchersL15opaqueValueExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL15opaqueValueExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, OpaqueValueExpr> opaqueValueExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, OpaqueValueExpr>();

/// \brief Matches a C++ static_assert declaration.
///
/// Example:
///   staticAssertExpr()
/// matches
///   static_assert(sizeof(S) == sizeof(int))
/// in
/// \code
///   struct S {
///     int x;
///   };
///   static_assert(sizeof(S) == sizeof(int));
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::staticAssertDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1801,
 FQN="clang::ast_matchers::staticAssertDecl", NM="_ZN5clang12ast_matchersL16staticAssertDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL16staticAssertDeclE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Decl, StaticAssertDecl> staticAssertDecl/*J*/= new VariadicDynCastAllOfMatcher<Decl, StaticAssertDecl>();

/// \brief Matches a reinterpret_cast expression.
///
/// Either the source expression or the destination type can be matched
/// using has(), but hasDestinationType() is more specific and can be
/// more readable.
///
/// Example matches reinterpret_cast<char*>(&p) in
/// \code
///   void* p = reinterpret_cast<char*>(&p);
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxReinterpretCastExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1815,
 FQN="clang::ast_matchers::cxxReinterpretCastExpr", NM="_ZN5clang12ast_matchersL22cxxReinterpretCastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL22cxxReinterpretCastExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CXXReinterpretCastExpr> cxxReinterpretCastExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CXXReinterpretCastExpr>();

/// \brief Matches a C++ static_cast expression.
///
/// \see hasDestinationType
/// \see reinterpretCast
///
/// Example:
///   cxxStaticCastExpr()
/// matches
///   static_cast<long>(8)
/// in
/// \code
///   long eight(static_cast<long>(8));
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxStaticCastExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1832,
 FQN="clang::ast_matchers::cxxStaticCastExpr", NM="_ZN5clang12ast_matchersL17cxxStaticCastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL17cxxStaticCastExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CXXStaticCastExpr> cxxStaticCastExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CXXStaticCastExpr>();

/// \brief Matches a dynamic_cast expression.
///
/// Example:
///   cxxDynamicCastExpr()
/// matches
///   dynamic_cast<D*>(&b);
/// in
/// \code
///   struct B { virtual ~B() {} }; struct D : B {};
///   B b;
///   D* p = dynamic_cast<D*>(&b);
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxDynamicCastExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1848,
 FQN="clang::ast_matchers::cxxDynamicCastExpr", NM="_ZN5clang12ast_matchersL18cxxDynamicCastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL18cxxDynamicCastExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CXXDynamicCastExpr> cxxDynamicCastExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CXXDynamicCastExpr>();

/// \brief Matches a const_cast expression.
///
/// Example: Matches const_cast<int*>(&r) in
/// \code
///   int n = 42;
///   const int &r(n);
///   int* p = const_cast<int*>(&r);
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxConstCastExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1860,
 FQN="clang::ast_matchers::cxxConstCastExpr", NM="_ZN5clang12ast_matchersL16cxxConstCastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL16cxxConstCastExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CXXConstCastExpr> cxxConstCastExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CXXConstCastExpr>();

/// \brief Matches a C-style cast expression.
///
/// Example: Matches (int*) 2.2f in
/// \code
///   int i = (int) 2.2f;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cStyleCastExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1870,
 FQN="clang::ast_matchers::cStyleCastExpr", NM="_ZN5clang12ast_matchersL14cStyleCastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL14cStyleCastExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CStyleCastExpr> cStyleCastExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CStyleCastExpr>();

/// \brief Matches explicit cast expressions.
///
/// Matches any cast expression written in user code, whether it be a
/// C-style cast, a functional-style cast, or a keyword cast.
///
/// Does not match implicit conversions.
///
/// Note: the name "explicitCast" is chosen to match Clang's terminology, as
/// Clang uses the term "cast" to apply to implicit conversions as well as to
/// actual cast expressions.
///
/// \see hasDestinationType.
///
/// Example: matches all five of the casts in
/// \code
///   int((int)(reinterpret_cast<int>(static_cast<int>(const_cast<int>(42)))))
/// \endcode
/// but does not match the implicit conversion in
/// \code
///   long ell = 42;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::explicitCastExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1895,
 FQN="clang::ast_matchers::explicitCastExpr", NM="_ZN5clang12ast_matchersL16explicitCastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL16explicitCastExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, ExplicitCastExpr> explicitCastExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, ExplicitCastExpr>();

/// \brief Matches the implicit cast nodes of Clang's AST.
///
/// This matches many different places, including function call return value
/// eliding, as well as any type conversions.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::implicitCastExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1903,
 FQN="clang::ast_matchers::implicitCastExpr", NM="_ZN5clang12ast_matchersL16implicitCastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL16implicitCastExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, ImplicitCastExpr> implicitCastExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, ImplicitCastExpr>();

/// \brief Matches any cast nodes of Clang's AST.
///
/// Example: castExpr() matches each of the following:
/// \code
///   (int) 3;
///   const_cast<Expr *>(SubExpr);
///   char c = 0;
/// \endcode
/// but does not match
/// \code
///   int i = (0);
///   int k = 0;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::castExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1920,
 FQN="clang::ast_matchers::castExpr", NM="_ZN5clang12ast_matchersL8castExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL8castExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CastExpr> castExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CastExpr>();

/// \brief Matches functional cast expressions
///
/// Example: Matches Foo(bar);
/// \code
///   Foo f = bar;
///   Foo g = (Foo) bar;
///   Foo h = Foo(bar);
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxFunctionalCastExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1930,
 FQN="clang::ast_matchers::cxxFunctionalCastExpr", NM="_ZN5clang12ast_matchersL21cxxFunctionalCastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL21cxxFunctionalCastExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CXXFunctionalCastExpr> cxxFunctionalCastExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CXXFunctionalCastExpr>();

/// \brief Matches functional cast expressions having N != 1 arguments
///
/// Example: Matches Foo(bar, bar)
/// \code
///   Foo h = Foo(bar, bar);
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cxxTemporaryObjectExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1940,
 FQN="clang::ast_matchers::cxxTemporaryObjectExpr", NM="_ZN5clang12ast_matchersL22cxxTemporaryObjectExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL22cxxTemporaryObjectExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CXXTemporaryObjectExpr> cxxTemporaryObjectExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CXXTemporaryObjectExpr>();

/// \brief Matches predefined identifier expressions [C99 6.4.2.2].
///
/// Example: Matches __func__
/// \code
///   printf("%s", __func__);
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::predefinedExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1950,
 FQN="clang::ast_matchers::predefinedExpr", NM="_ZN5clang12ast_matchersL14predefinedExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL14predefinedExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, PredefinedExpr> predefinedExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, PredefinedExpr>();

/// \brief Matches C99 designated initializer expressions [C99 6.7.8].
///
/// Example: Matches { [2].y = 1.0, [0].x = 1.0 }
/// \code
///   point ptarray[10] = { [2].y = 1.0, [0].x = 1.0 };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::designatedInitExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1960,
 FQN="clang::ast_matchers::designatedInitExpr", NM="_ZN5clang12ast_matchersL18designatedInitExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL18designatedInitExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, DesignatedInitExpr> designatedInitExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, DesignatedInitExpr>();

/// \brief Matches designated initializer expressions that contain
/// a specific number of designators.
///
/// Example: Given
/// \code
///   point ptarray[10] = { [2].y = 1.0, [0].x = 1.0 };
///   point ptarray2[10] = { [2].y = 1.0, [2].x = 0.0, [0].x = 1.0 };
/// \endcode
/// designatorCountIs(2)
///   matches '{ [2].y = 1.0, [0].x = 1.0 }',
///   but not '{ [2].y = 1.0, [2].x = 0.0, [0].x = 1.0 }'.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::designatorCountIs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1975,
 FQN="clang::ast_matchers::designatorCountIs", NM="_ZN5clang12ast_matchers17designatorCountIsERKj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers17designatorCountIsERKj")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<DesignatedInitExpr> designatorCountIs(final /*const*/uint$ref/*uint &*/ N) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches \c QualTypes in the clang AST.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::qualType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1980,
 FQN="clang::ast_matchers::qualType", NM="_ZN5clang12ast_matchersL8qualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL8qualTypeE")
//</editor-fold>
public static /*const*/ VariadicAllOfMatcher<QualType> qualType/*J*/= new VariadicAllOfMatcher<QualType>();

/// \brief Matches \c Types in the clang AST.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::type">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1983,
 FQN="clang::ast_matchers::type", NM="_ZN5clang12ast_matchersL4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL4typeE")
//</editor-fold>
public static /*const*/ VariadicAllOfMatcher<Type> type/*J*/= new VariadicAllOfMatcher<Type>();

/// \brief Matches \c TypeLocs in the clang AST.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::typeLoc">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 1986,
 FQN="clang::ast_matchers::typeLoc", NM="_ZN5clang12ast_matchersL7typeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL7typeLocE")
//</editor-fold>
public static /*const*/ VariadicAllOfMatcher<TypeLoc> typeLoc/*J*/= new VariadicAllOfMatcher<TypeLoc>();

/// \brief Matches if any of the given matchers matches.
///
/// Unlike \c anyOf, \c eachOf will generate a match result for each
/// matching submatcher.
///
/// For example, in:
/// \code
///   class A { int a; int b; };
/// \endcode
/// The matcher:
/// \code
///   cxxRecordDecl(eachOf(has(fieldDecl(hasName("a")).bind("v")),
///                        has(fieldDecl(hasName("b")).bind("v"))))
/// \endcode
/// will generate two results binding "v", the first of which binds
/// the field declaration of \c a, the second the field declaration of
/// \c b.
///
/// Usable as: Any Matcher
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::eachOf">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2007,
 FQN="clang::ast_matchers::eachOf", NM="_ZN5clang12ast_matchersL6eachOfE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL6eachOfE")
//</editor-fold>
public static /*const*/ VariadicOperatorMatcherFunc/*<2, (2147483647 * 2U + 1U)>*/ eachOf = new VariadicOperatorMatcherFunc(
  DynTypedMatcher.VariadicOperator.VO_EachOf, 2, (2147483647 * 2/*U*/ + 1/*U*/)
);

/// \brief Matches if any of the given matchers matches.
///
/// Usable as: Any Matcher
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::anyOf">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2014,
 FQN="clang::ast_matchers::anyOf", NM="_ZN5clang12ast_matchersL5anyOfE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL5anyOfE")
//</editor-fold>
public static /*const*/ VariadicOperatorMatcherFunc/*<2, (2147483647 * 2U + 1U)>*/ anyOf = new VariadicOperatorMatcherFunc(
  DynTypedMatcher.VariadicOperator.VO_AnyOf, 2, (2147483647 * 2/*U*/ + 1/*U*/)
);

/// \brief Matches if all given matchers match.
///
/// Usable as: Any Matcher
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::allOf">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2021,
 FQN="clang::ast_matchers::allOf", NM="_ZN5clang12ast_matchersL5allOfE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL5allOfE")
//</editor-fold>
public static /*const*/ VariadicOperatorMatcherFunc/*<2, (2147483647 * 2U + 1U)>*/ allOf = new VariadicOperatorMatcherFunc(
  DynTypedMatcher.VariadicOperator.VO_AllOf, 2, (2147483647 * 2/*U*/ + 1/*U*/)
);

/// \brief Matches sizeof (C99), alignof (C++11) and vec_step (OpenCL)
///
/// Given
/// \code
///   Foo x = bar;
///   int y = sizeof(x) + alignof(x);
/// \endcode
/// unaryExprOrTypeTraitExpr()
///   matches \c sizeof(x) and \c alignof(x)
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::unaryExprOrTypeTraitExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2034,
 FQN="clang::ast_matchers::unaryExprOrTypeTraitExpr", NM="_ZN5clang12ast_matchersL24unaryExprOrTypeTraitExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL24unaryExprOrTypeTraitExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, UnaryExprOrTypeTraitExpr> unaryExprOrTypeTraitExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, UnaryExprOrTypeTraitExpr>();

/// \brief Matches unary expressions that have a specific type of argument.
///
/// Given
/// \code
///   int a, c; float b; int s = sizeof(a) + sizeof(b) + alignof(c);
/// \endcode
/// unaryExprOrTypeTraitExpr(hasArgumentOfType(asString("int"))
///   matches \c sizeof(a) and \c alignof(c)
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasArgumentOfType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2046,
 FQN="clang::ast_matchers::hasArgumentOfType", NM="_ZN5clang12ast_matchers17hasArgumentOfTypeERKNS0_8internal7MatcherINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers17hasArgumentOfTypeERKNS0_8internal7MatcherINS_8QualTypeEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<UnaryExprOrTypeTraitExpr> hasArgumentOfType(final /*const*/ Matcher<QualType> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches unary expressions of a certain kind.
///
/// Given
/// \code
///   int x;
///   int s = sizeof(x) + alignof(x)
/// \endcode
/// unaryExprOrTypeTraitExpr(ofKind(UETT_SizeOf))
///   matches \c sizeof(x)
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::ofKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2061,
 FQN="clang::ast_matchers::ofKind", NM="_ZN5clang12ast_matchers6ofKindERKNS_20UnaryExprOrTypeTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers6ofKindERKNS_20UnaryExprOrTypeTraitE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<UnaryExprOrTypeTraitExpr> ofKind(final /*const*/ type$ref<UnaryExprOrTypeTrait> /*&*/ Kind) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Same as unaryExprOrTypeTraitExpr, but only matching
/// alignof.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::alignOfExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2067,
 FQN="clang::ast_matchers::alignOfExpr", NM="_ZN5clang12ast_matchers11alignOfExprERKNS0_8internal7MatcherINS_24UnaryExprOrTypeTraitExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11alignOfExprERKNS0_8internal7MatcherINS_24UnaryExprOrTypeTraitExprEEE")
//</editor-fold>
public static /*inline*/ Matcher<Stmt> alignOfExpr(final /*const*/ Matcher<UnaryExprOrTypeTraitExpr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Same as unaryExprOrTypeTraitExpr, but only matching
/// sizeof.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::sizeOfExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2075,
 FQN="clang::ast_matchers::sizeOfExpr", NM="_ZN5clang12ast_matchers10sizeOfExprERKNS0_8internal7MatcherINS_24UnaryExprOrTypeTraitExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers10sizeOfExprERKNS0_8internal7MatcherINS_24UnaryExprOrTypeTraitExprEEE")
//</editor-fold>
public static /*inline*/ Matcher<Stmt> sizeOfExpr(final /*const*/ Matcher<UnaryExprOrTypeTraitExpr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches NamedDecl nodes that have the specified name.
///
/// Supports specifying enclosing namespaces or classes by prefixing the name
/// with '<enclosing>::'.
/// Does not match typedefs of an underlying type with the given name.
///
/// Example matches X (Name == "X")
/// \code
///   class X;
/// \endcode
///
/// Example matches X (Name is one of "::a::b::X", "a::b::X", "b::X", "X")
/// \code
///   namespace a { namespace b { class X; } }
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2096,
 FQN="clang::ast_matchers::hasName", NM="_ZN5clang12ast_matchers7hasNameERKSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers7hasNameERKSs")
//</editor-fold>
public static /*inline*/ Matcher<NamedDecl> hasName(final /*const*/std.string/*&*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches NamedDecl nodes that have any of the specified names.
///
/// This matcher is only provided as a performance optimization of hasName.
/// \code
///     hasAnyName(a, b, c)
/// \endcode
///  is equivalent to, but faster than
/// \code
///     anyOf(hasName(a), hasName(b), hasName(c))
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasAnyName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2112,
 FQN="clang::ast_matchers::hasAnyName", NM="_ZN5clang12ast_matchersL10hasAnyNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL10hasAnyNameE")
//</editor-fold>
public static /*const*/ VariadicFunction<Matcher<NamedDecl>, StringRef/*, hasAnyNameFunc*/> hasAnyName = new VariadicFunction<Matcher<NamedDecl>, StringRef/*, hasAnyNameFunc*/>(InternalGlobals::hasAnyNameFunc/*zero-init*/);

/// \brief Matches NamedDecl nodes whose fully qualified names contain
/// a substring matched by the given RegExp.
///
/// Supports specifying enclosing namespaces or classes by
/// prefixing the name with '<enclosing>::'.  Does not match typedefs
/// of an underlying type with the given name.
///
/// Example matches X (regexp == "::X")
/// \code
///   class X;
/// \endcode
///
/// Example matches X (regexp is one of "::X", "^foo::.*X", among others)
/// \code
///   namespace foo { namespace bar { class X; } }
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::matchesName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2132,
 FQN="clang::ast_matchers::matchesName", NM="_ZN5clang12ast_matchers11matchesNameERKSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11matchesNameERKSs")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<NamedDecl> matchesName(final /*const*/std.string/*&*/ RegExp) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches overloaded operator names.
///
/// Matches overloaded operator names specified in strings without the
/// "operator" prefix: e.g. "<<".
///
/// Given:
/// \code
///   class A { int operator*(); };
///   const A &operator<<(const A &a, const A &b);
///   A a;
///   a << a;   // <-- This matches
/// \endcode
///
/// \c cxxOperatorCallExpr(hasOverloadedOperatorName("<<"))) matches the
/// specified line and
/// \c cxxRecordDecl(hasMethod(hasOverloadedOperatorName("*")))
/// matches the declaration of \c A.
///
/// Usable as: Matcher<CXXOperatorCallExpr>, Matcher<FunctionDecl>
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasOverloadedOperatorName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2158,
 FQN="clang::ast_matchers::hasOverloadedOperatorName", NM="_ZN5clang12ast_matchers25hasOverloadedOperatorNameEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers25hasOverloadedOperatorNameEN4llvm9StringRefE")
//</editor-fold>
public static /*inline*/ PolymorphicMatcherWithParam1<HasOverloadedOperatorNameMatcher, StringRef/*, void (::TypeList<CXXOperatorCallExpr, FunctionDecl>)*/> hasOverloadedOperatorName(StringRef Name) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches C++ classes that are directly or indirectly derived from
/// a class matching \c Base.
///
/// Note that a class is not considered to be derived from itself.
///
/// Example matches Y, Z, C (Base == hasName("X"))
/// \code
///   class X;
///   class Y : public X {};  // directly derived
///   class Z : public Y {};  // indirectly derived
///   typedef X A;
///   typedef A B;
///   class C : public B {};  // derived from a typedef of X
/// \endcode
///
/// In the following example, Bar matches isDerivedFrom(hasName("X")):
/// \code
///   class Foo;
///   typedef Foo X;
///   class Bar : public Foo {};  // derived from a type that X is a typedef of
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isDerivedFrom">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2188,
 FQN="clang::ast_matchers::isDerivedFrom", NM="_ZN5clang12ast_matchers13isDerivedFromERKNS0_8internal7MatcherINS_9NamedDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers13isDerivedFromERKNS0_8internal7MatcherINS_9NamedDeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXRecordDecl> isDerivedFrom(final /*const*/ Matcher<NamedDecl> /*&*/ Base) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Overloaded method as shortcut for \c isDerivedFrom(hasName(...)).
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isDerivedFrom">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2194,
 FQN="clang::ast_matchers::isDerivedFrom", NM="_ZN5clang12ast_matchers13isDerivedFromERKSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers13isDerivedFromERKSs")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXRecordDecl> isDerivedFrom(final /*const*/std.string/*&*/ BaseName) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Similar to \c isDerivedFrom(), but also matches classes that directly
/// match \c Base.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isSameOrDerivedFrom">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2201,
 FQN="clang::ast_matchers::isSameOrDerivedFrom", NM="_ZN5clang12ast_matchers19isSameOrDerivedFromERKNS0_8internal7MatcherINS_9NamedDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers19isSameOrDerivedFromERKNS0_8internal7MatcherINS_9NamedDeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXRecordDecl> isSameOrDerivedFrom(final /*const*/ Matcher<NamedDecl> /*&*/ Base) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Overloaded method as shortcut for
/// \c isSameOrDerivedFrom(hasName(...)).
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isSameOrDerivedFrom">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2209,
 FQN="clang::ast_matchers::isSameOrDerivedFrom", NM="_ZN5clang12ast_matchers19isSameOrDerivedFromERKSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers19isSameOrDerivedFromERKSs")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXRecordDecl> isSameOrDerivedFrom(final /*const*/std.string/*&*/ BaseName) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the first method of a class or struct that satisfies \c
/// InnerMatcher.
///
/// Given:
/// \code
///   class A { void func(); };
///   class B { void member(); };
/// \endcode
///
/// \c cxxRecordDecl(hasMethod(hasName("func"))) matches the declaration of
/// \c A but not \c B.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasMethod">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2226,
 FQN="clang::ast_matchers::hasMethod", NM="_ZN5clang12ast_matchers9hasMethodERKNS0_8internal7MatcherINS_13CXXMethodDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers9hasMethodERKNS0_8internal7MatcherINS_13CXXMethodDeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXRecordDecl> hasMethod(final /*const*/ Matcher<CXXMethodDecl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the generated class of lambda expressions.
///
/// Given:
/// \code
///   auto x = []{};
/// \endcode
///
/// \c cxxRecordDecl(isLambda()) matches the implicit class declaration of
/// \c decltype(x)
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isLambda">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2241,
 FQN="clang::ast_matchers::isLambda", NM="_ZN5clang12ast_matchers8isLambdaEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8isLambdaEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXRecordDecl> isLambda() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches AST nodes that have child AST nodes that match the
/// provided matcher.
///
/// Example matches X, Y
///   (matcher = cxxRecordDecl(has(cxxRecordDecl(hasName("X")))
/// \code
///   class X {};  // Matches X, because X::X is a class of name X inside X.
///   class Y { class X {}; };
///   class Z { class Y { class X {}; }; };  // Does not match Z.
/// \endcode
///
/// ChildT must be an AST base type.
///
/// Usable as: Any Matcher
/// Note that has is direct matcher, so it also matches things like implicit
/// casts and paren casts. If you are matching with expr then you should
/// probably consider using ignoringParenImpCasts like:
/// has(ignoringParenImpCasts(expr())).
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::has">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2263,
 FQN="clang::ast_matchers::has", NM="_ZN5clang12ast_matchersL3hasE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL3hasE")
//</editor-fold>
public static /*const*/ ArgumentAdaptingMatcherFunc<HasMatcher, TypeList/*<Decl, Stmt, NestedNameSpecifier, NestedNameSpecifierLoc,
                 TypeLoc, QualType>*/, TypeList/*<Decl, Stmt, NestedNameSpecifier, NestedNameSpecifierLoc,
                 QualType, Type, TypeLoc, CXXCtorInitializer>*/> has = new ArgumentAdaptingMatcherFunc(/*zero-init*/)/* __attribute__((unused))*/;

/// \brief Matches AST nodes that have descendant AST nodes that match the
/// provided matcher.
///
/// Example matches X, Y, Z
///     (matcher = cxxRecordDecl(hasDescendant(cxxRecordDecl(hasName("X")))))
/// \code
///   class X {};  // Matches X, because X::X is a class of name X inside X.
///   class Y { class X {}; };
///   class Z { class Y { class X {}; }; };
/// \endcode
///
/// DescendantT must be an AST base type.
///
/// Usable as: Any Matcher
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasDescendant">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2280,
 FQN="clang::ast_matchers::hasDescendant", NM="_ZN5clang12ast_matchersL13hasDescendantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL13hasDescendantE")
//</editor-fold>
public static /*const*/ ArgumentAdaptingMatcherFunc<HasDescendantMatcher, TypeList/*<Decl, Stmt, NestedNameSpecifier, NestedNameSpecifierLoc,
                 TypeLoc, QualType>*/, TypeList/*<Decl, Stmt, NestedNameSpecifier, NestedNameSpecifierLoc,
                 QualType, Type, TypeLoc, CXXCtorInitializer>*/> hasDescendant = new ArgumentAdaptingMatcherFunc(/*zero-init*/)/* __attribute__((unused))*/;

/// \brief Matches AST nodes that have child AST nodes that match the
/// provided matcher.
///
/// Example matches X, Y
///   (matcher = cxxRecordDecl(forEach(cxxRecordDecl(hasName("X")))
/// \code
///   class X {};  // Matches X, because X::X is a class of name X inside X.
///   class Y { class X {}; };
///   class Z { class Y { class X {}; }; };  // Does not match Z.
/// \endcode
///
/// ChildT must be an AST base type.
///
/// As opposed to 'has', 'forEach' will cause a match for each result that
/// matches instead of only on the first one.
///
/// Usable as: Any Matcher
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::forEach">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2300,
 FQN="clang::ast_matchers::forEach", NM="_ZN5clang12ast_matchersL7forEachE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL7forEachE")
//</editor-fold>
public static /*const*/ ArgumentAdaptingMatcherFunc<ForEachMatcher, TypeList/*<Decl, Stmt, NestedNameSpecifier, NestedNameSpecifierLoc,
                 TypeLoc, QualType>*/, TypeList/*<Decl, Stmt, NestedNameSpecifier, NestedNameSpecifierLoc,
                 QualType, Type, TypeLoc, CXXCtorInitializer>*/> forEach = new ArgumentAdaptingMatcherFunc(/*zero-init*/)/* __attribute__((unused))*/;

/// \brief Matches AST nodes that have descendant AST nodes that match the
/// provided matcher.
///
/// Example matches X, A, B, C
///   (matcher = cxxRecordDecl(forEachDescendant(cxxRecordDecl(hasName("X")))))
/// \code
///   class X {};  // Matches X, because X::X is a class of name X inside X.
///   class A { class X {}; };
///   class B { class C { class X {}; }; };
/// \endcode
///
/// DescendantT must be an AST base type.
///
/// As opposed to 'hasDescendant', 'forEachDescendant' will cause a match for
/// each result that matches instead of only on the first one.
///
/// Note: Recursively combined ForEachDescendant can cause many matches:
///   cxxRecordDecl(forEachDescendant(cxxRecordDecl(
///     forEachDescendant(cxxRecordDecl())
///   )))
/// will match 10 times (plus injected class name matches) on:
/// \code
///   class A { class B { class C { class D { class E {}; }; }; }; };
/// \endcode
///
/// Usable as: Any Matcher
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::forEachDescendant">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2329,
 FQN="clang::ast_matchers::forEachDescendant", NM="_ZN5clang12ast_matchersL17forEachDescendantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL17forEachDescendantE")
//</editor-fold>
public static /*const*/ ArgumentAdaptingMatcherFunc<ForEachDescendantMatcher, TypeList/*<Decl, Stmt, NestedNameSpecifier, NestedNameSpecifierLoc,
                 TypeLoc, QualType>*/, TypeList/*<Decl, Stmt, NestedNameSpecifier, NestedNameSpecifierLoc,
                 QualType, Type, TypeLoc, CXXCtorInitializer>*/> forEachDescendant = new ArgumentAdaptingMatcherFunc(/*zero-init*/)/* __attribute__((unused))*/;

/// \brief Matches if the node or any descendant matches.
///
/// Generates results for each match.
///
/// For example, in:
/// \code
///   class A { class B {}; class C {}; };
/// \endcode
/// The matcher:
/// \code
///   cxxRecordDecl(hasName("::A"),
///                 findAll(cxxRecordDecl(isDefinition()).bind("m")))
/// \endcode
/// will generate results for \c A, \c B and \c C.
///
/// Usable as: Any Matcher
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::findAll">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2349,
 FQN="clang::ast_matchers::findAll", NM="Tpl__ZN5clang12ast_matchers7findAllERKNS0_8internal7MatcherIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=Tpl__ZN5clang12ast_matchers7findAllERKNS0_8internal7MatcherIT_EE")
//</editor-fold>
public static </*typename*/ T> Matcher<T> findAll(final /*const*/ Matcher<T> /*&*/ Matcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches AST nodes that have a parent that matches the provided
/// matcher.
///
/// Given
/// \code
/// void f() { for (;;) { int x = 42; if (true) { int x = 43; } } }
/// \endcode
/// \c compoundStmt(hasParent(ifStmt())) matches "{ int x = 43; }".
///
/// Usable as: Any Matcher
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasParent">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2363,
 FQN="clang::ast_matchers::hasParent", NM="_ZN5clang12ast_matchersL9hasParentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL9hasParentE")
//</editor-fold>
public static /*const*/ ArgumentAdaptingMatcherFunc<HasParentMatcher, TypeList/*<Decl, NestedNameSpecifierLoc, Stmt, TypeLoc>*/, TypeList/*<Decl, NestedNameSpecifierLoc, Stmt, TypeLoc>*/ > hasParent = new ArgumentAdaptingMatcherFunc(/*zero-init*/)/* __attribute__((unused))*/;

/// \brief Matches AST nodes that have an ancestor that matches the provided
/// matcher.
///
/// Given
/// \code
/// void f() { if (true) { int x = 42; } }
/// void g() { for (;;) { int x = 43; } }
/// \endcode
/// \c expr(integerLiteral(hasAncestor(ifStmt()))) matches \c 42, but not 43.
///
/// Usable as: Any Matcher
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasAncestor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2380,
 FQN="clang::ast_matchers::hasAncestor", NM="_ZN5clang12ast_matchersL11hasAncestorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL11hasAncestorE")
//</editor-fold>
public static /*const*/ ArgumentAdaptingMatcherFunc<HasAncestorMatcher, TypeList/*<Decl, NestedNameSpecifierLoc, Stmt, TypeLoc>*/, TypeList/*<Decl, NestedNameSpecifierLoc, Stmt, TypeLoc>*/ > 
        hasAncestor = new ArgumentAdaptingMatcherFunc(/*zero-init*/)/* __attribute__((unused))*/;

/// \brief Matches if the provided matcher does not match.
///
/// Example matches Y (matcher = cxxRecordDecl(unless(hasName("X"))))
/// \code
///   class X {};
///   class Y {};
/// \endcode
///
/// Usable as: Any Matcher
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::unless">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2395,
 FQN="clang::ast_matchers::unless", NM="_ZN5clang12ast_matchersL6unlessE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL6unlessE")
//</editor-fold>
public static /*const*/ VariadicOperatorMatcherFunc/*<1, 1>*/ unless = new VariadicOperatorMatcherFunc(
  DynTypedMatcher.VariadicOperator.VO_UnaryNot, 1, 1
);

/// \brief Matches a node if the declaration associated with that node
/// matches the given matcher.
///
/// The associated declaration is:
/// - for type nodes, the declaration of the underlying type
/// - for CallExpr, the declaration of the callee
/// - for MemberExpr, the declaration of the referenced member
/// - for CXXConstructExpr, the declaration of the constructor
///
/// Also usable as Matcher<T> for any T supporting the getDecl() member
/// function. e.g. various subtypes of clang::Type and various expressions.
///
/// Usable as: Matcher<CallExpr>, Matcher<CXXConstructExpr>,
///   Matcher<DeclRefExpr>, Matcher<EnumType>, Matcher<InjectedClassNameType>,
///   Matcher<LabelStmt>, Matcher<AddrLabelExpr>, Matcher<MemberExpr>,
///   Matcher<QualType>, Matcher<RecordType>, Matcher<TagType>,
///   Matcher<TemplateSpecializationType>, Matcher<TemplateTypeParmType>,
///   Matcher<TypedefType>, Matcher<UnresolvedUsingType>
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasDeclaration">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2417,
 FQN="clang::ast_matchers::hasDeclaration", NM="_ZN5clang12ast_matchers14hasDeclarationERKNS0_8internal7MatcherINS_4DeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers14hasDeclarationERKNS0_8internal7MatcherINS_4DeclEEE")
//</editor-fold>
public static /*inline*/ PolymorphicMatcherWithParam1<HasDeclarationMatcher, Matcher<Decl> 
      /*void (TypeList<CallExpr, CXXConstructExpr, DeclRefExpr, EnumType, InjectedClassNameType, LabelStmt, AddrLabelExpr, MemberExpr, QualType, RecordType, TagType, TemplateSpecializationType, TemplateTypeParmType, TypedefType, UnresolvedUsingType>)*/> hasDeclaration(final /*const*/ Matcher<Decl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches on the implicit object argument of a member call expression.
///
/// Example matches y.x()
///   (matcher = cxxMemberCallExpr(on(hasType(cxxRecordDecl(hasName("Y"))))))
/// \code
///   class Y { public: void x(); };
///   void z() { Y y; y.x(); }",
/// \endcode
///
/// FIXME: Overload to allow directly matching types?
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::on">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2436,
 FQN="clang::ast_matchers::on", NM="_ZN5clang12ast_matchers2onERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers2onERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXMemberCallExpr> on(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches on the receiver of an ObjectiveC Message expression.
///
/// Example
/// matcher = objCMessageExpr(hasRecieverType(asString("UIWebView *")));
/// matches the [webView ...] message invocation.
/// \code
///   NSString *webViewJavaScript = ...
///   UIWebView *webView = ...
///   [webView stringByEvaluatingJavaScriptFromString:webViewJavascript];
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasReceiverType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2455,
 FQN="clang::ast_matchers::hasReceiverType", NM="_ZN5clang12ast_matchers15hasReceiverTypeERKNS0_8internal7MatcherINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers15hasReceiverTypeERKNS0_8internal7MatcherINS_8QualTypeEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<ObjCMessageExpr> hasReceiverType(final /*const*/ Matcher<QualType> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches when BaseName == Selector.getAsString()
///
///  matcher = objCMessageExpr(hasSelector("loadHTMLString:baseURL:"));
///  matches the outer message expr in the code below, but NOT the message
///  invocation for self.bodyView.
/// \code
///     [self.bodyView loadHTMLString:html baseURL:NULL];
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasSelector">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2469,
 FQN="clang::ast_matchers::hasSelector", NM="_ZN5clang12ast_matchers11hasSelectorERKSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11hasSelectorERKSs")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<ObjCMessageExpr> hasSelector(final /*const*/std.string/*&*/ BaseName) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches ObjC selectors whose name contains
/// a substring matched by the given RegExp.
///  matcher = objCMessageExpr(matchesSelector("loadHTMLString\:baseURL?"));
///  matches the outer message expr in the code below, but NOT the message
///  invocation for self.bodyView.
/// \code
///     [self.bodyView loadHTMLString:html baseURL:NULL];
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::matchesSelector">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2483,
 FQN="clang::ast_matchers::matchesSelector", NM="_ZN5clang12ast_matchers15matchesSelectorERKSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers15matchesSelectorERKSs")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<ObjCMessageExpr> matchesSelector(final /*const*/std.string/*&*/ RegExp) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches when the selector is the empty selector
///
/// Matches only when the selector of the objCMessageExpr is NULL. This may
/// represent an error condition in the tree!
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasNullSelector">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2494,
 FQN="clang::ast_matchers::hasNullSelector", NM="_ZN5clang12ast_matchers15hasNullSelectorEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers15hasNullSelectorEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<ObjCMessageExpr> hasNullSelector() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches when the selector is a Unary Selector
///
///  matcher = objCMessageExpr(matchesSelector(hasUnarySelector());
///  matches self.bodyView in the code below, but NOT the outer message
///  invocation of "loadHTMLString:baseURL:".
/// \code
///     [self.bodyView loadHTMLString:html baseURL:NULL];
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasUnarySelector">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2506,
 FQN="clang::ast_matchers::hasUnarySelector", NM="_ZN5clang12ast_matchers16hasUnarySelectorEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers16hasUnarySelectorEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<ObjCMessageExpr> hasUnarySelector() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches when the selector is a keyword selector
///
/// objCMessageExpr(hasKeywordSelector()) matches the generated setFrame
/// message expression in
///
/// \code
///   UIWebView *webView = ...;
///   CGRect bodyFrame = webView.frame;
///   bodyFrame.size.height = self.bodyContentHeight;
///   webView.frame = bodyFrame;
///   //     ^---- matches here
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasKeywordSelector">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2522,
 FQN="clang::ast_matchers::hasKeywordSelector", NM="_ZN5clang12ast_matchers18hasKeywordSelectorEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers18hasKeywordSelectorEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<ObjCMessageExpr> hasKeywordSelector() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches when the selector has the specified number of arguments
///
///  matcher = objCMessageExpr(numSelectorArgs(0));
///  matches self.bodyView in the code below
///
///  matcher = objCMessageExpr(numSelectorArgs(2));
///  matches the invocation of "loadHTMLString:baseURL:" but not that
///  of self.bodyView
/// \code
///     [self.bodyView loadHTMLString:html baseURL:NULL];
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::numSelectorArgs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2537,
 FQN="clang::ast_matchers::numSelectorArgs", NM="_ZN5clang12ast_matchers15numSelectorArgsERKj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers15numSelectorArgsERKj")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<ObjCMessageExpr> numSelectorArgs(final /*const*/uint$ref/*uint &*/ N) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if the call expression's callee expression matches.
///
/// Given
/// \code
///   class Y { void x() { this->x(); x(); Y y; y.x(); } };
///   void f() { f(); }
/// \endcode
/// callExpr(callee(expr()))
///   matches this->x(), x(), y.x(), f()
/// with callee(...)
///   matching this->x, x, y.x, f respectively
///
/// Note: Callee cannot take the more general internal::Matcher<Expr>
/// because this introduces ambiguous overloads with calls to Callee taking a
/// internal::Matcher<Decl>, as the matcher hierarchy is purely
/// implemented in terms of implicit casts.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::callee">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2557,
 FQN="clang::ast_matchers::callee", NM="_ZN5clang12ast_matchers6calleeERKNS0_8internal7MatcherINS_4StmtEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers6calleeERKNS0_8internal7MatcherINS_4StmtEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CallExpr> callee_Matcher$Stmt$C(final /*const*/ Matcher<Stmt> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if the call expression's callee's declaration matches the
/// given matcher.
///
/// Example matches y.x() (matcher = callExpr(callee(
///                                    cxxMethodDecl(hasName("x")))))
/// \code
///   class Y { public: void x(); };
///   void z() { Y y; y.x(); }
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::callee">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2573,
 FQN="clang::ast_matchers::callee", NM="_ZN5clang12ast_matchers6calleeERKNS0_8internal7MatcherINS_4DeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers6calleeERKNS0_8internal7MatcherINS_4DeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CallExpr> callee_Matcher$Decl$C(final /*const*/ Matcher<Decl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if the expression's or declaration's type matches a type
/// matcher.
///
/// Example matches x (matcher = expr(hasType(cxxRecordDecl(hasName("X")))))
///             and z (matcher = varDecl(hasType(cxxRecordDecl(hasName("X")))))
///             and U (matcher = typedefDecl(hasType(asString("int")))
/// \code
///  class X {};
///  void y(X &x) { x; X z; }
///  typedef int U;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2589,
 FQN="clang::ast_matchers::hasType", NM="_ZN5clang12ast_matchers7hasTypeERKNS0_8internal7MatcherINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers7hasTypeERKNS0_8internal7MatcherINS_8QualTypeEEE")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam1<matcher_hasType0Matcher, Matcher<QualType>/*, void (::TypeList<Expr, TypedefNameDecl, ValueDecl>)*/> hasType_Matcher$QualType$C(final /*const*/ Matcher<QualType> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Overloaded to match the declaration of the expression's or value
/// declaration's type.
///
/// In case of a value declaration (for example a variable declaration),
/// this resolves one layer of indirection. For example, in the value
/// declaration "X x;", cxxRecordDecl(hasName("X")) matches the declaration of
/// X, while varDecl(hasType(cxxRecordDecl(hasName("X")))) matches the
/// declaration of x.
///
/// Example matches x (matcher = expr(hasType(cxxRecordDecl(hasName("X")))))
///             and z (matcher = varDecl(hasType(cxxRecordDecl(hasName("X")))))
/// \code
///  class X {};
///  void y(X &x) { x; X z; }
/// \endcode
///
/// Usable as: Matcher<Expr>, Matcher<ValueDecl>
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2613,
 FQN="clang::ast_matchers::hasType", NM="_ZN5clang12ast_matchers7hasTypeERKNS0_8internal7MatcherINS_4DeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers7hasTypeERKNS0_8internal7MatcherINS_4DeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam1<matcher_hasType1Matcher, Matcher<Decl>/*, void (::TypeList<Expr, ValueDecl>)*/> hasType_Matcher$Decl$C(final /*const*/ Matcher<Decl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if the type location of the declarator decl's type matches
/// the inner matcher.
///
/// Given
/// \code
///   int x;
/// \endcode
/// declaratorDecl(hasTypeLoc(loc(asString("int"))))
///   matches int x
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasTypeLoc">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2630,
 FQN="clang::ast_matchers::hasTypeLoc", NM="_ZN5clang12ast_matchers10hasTypeLocERKNS0_8internal7MatcherINS_7TypeLocEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers10hasTypeLocERKNS0_8internal7MatcherINS_7TypeLocEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<DeclaratorDecl> hasTypeLoc(final /*const*/ Matcher<TypeLoc> /*&*/ Inner) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if the matched type is represented by the given string.
///
/// Given
/// \code
///   class Y { public: void x(); };
///   void z() { Y* y; y->x(); }
/// \endcode
/// cxxMemberCallExpr(on(hasType(asString("class Y *"))))
///   matches y->x()
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::asString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2646,
 FQN="clang::ast_matchers::asString", NM="_ZN5clang12ast_matchers8asStringERKSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8asStringERKSs")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<QualType> asString(final /*const*/std.string/*&*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if the matched type is a pointer type and the pointee type
/// matches the specified matcher.
///
/// Example matches y->x()
///   (matcher = cxxMemberCallExpr(on(hasType(pointsTo
///      cxxRecordDecl(hasName("Y")))))))
/// \code
///   class Y { public: void x(); };
///   void z() { Y *y; y->x(); }
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::pointsTo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2660,
 FQN="clang::ast_matchers::pointsTo", NM="_ZN5clang12ast_matchers8pointsToERKNS0_8internal7MatcherINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8pointsToERKNS0_8internal7MatcherINS_8QualTypeEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<QualType> pointsTo_Matcher$QualType$C(final /*const*/ Matcher<QualType> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Overloaded to match the pointee type's declaration.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::pointsTo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2668,
 FQN="clang::ast_matchers::pointsTo", NM="_ZN5clang12ast_matchers8pointsToERKNS0_8internal7MatcherINS_4DeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8pointsToERKNS0_8internal7MatcherINS_4DeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<QualType> pointsTo_Matcher$Decl$C(final /*const*/ Matcher<Decl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if the matched type is a reference type and the referenced
/// type matches the specified matcher.
///
/// Example matches X &x and const X &y
///     (matcher = varDecl(hasType(references(cxxRecordDecl(hasName("X"))))))
/// \code
///   class X {
///     void a(X b) {
///       X &x = b;
///       const X &y = b;
///     }
///   };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::references">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2687,
 FQN="clang::ast_matchers::references", NM="_ZN5clang12ast_matchers10referencesERKNS0_8internal7MatcherINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers10referencesERKNS0_8internal7MatcherINS_8QualTypeEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<QualType> references_Matcher$QualType$C(final /*const*/ Matcher<QualType> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches QualTypes whose canonical type matches InnerMatcher.
///
/// Given:
/// \code
///   typedef int &int_ref;
///   int a;
///   int_ref b = a;
/// \endcode
///
/// \c varDecl(hasType(qualType(referenceType()))))) will not match the
/// declaration of b but \c
/// varDecl(hasType(qualType(hasCanonicalType(referenceType())))))) does.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasCanonicalType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2705,
 FQN="clang::ast_matchers::hasCanonicalType", NM="_ZN5clang12ast_matchers16hasCanonicalTypeERKNS0_8internal7MatcherINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers16hasCanonicalTypeERKNS0_8internal7MatcherINS_8QualTypeEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<QualType> hasCanonicalType(final /*const*/ Matcher<QualType> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Overloaded to match the referenced type's declaration.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::references">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2713,
 FQN="clang::ast_matchers::references", NM="_ZN5clang12ast_matchers10referencesERKNS0_8internal7MatcherINS_4DeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers10referencesERKNS0_8internal7MatcherINS_4DeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<QualType> references_Matcher$Decl$C(final /*const*/ Matcher<Decl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::onImplicitObjectArgument">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2719,
 FQN="clang::ast_matchers::onImplicitObjectArgument", NM="_ZN5clang12ast_matchers24onImplicitObjectArgumentERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers24onImplicitObjectArgumentERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXMemberCallExpr> onImplicitObjectArgument(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if the expression's type either matches the specified
/// matcher, or is a pointer to a type that matches the InnerMatcher.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::thisPointerType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2728,
 FQN="clang::ast_matchers::thisPointerType", NM="_ZN5clang12ast_matchers15thisPointerTypeERKNS0_8internal7MatcherINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers15thisPointerTypeERKNS0_8internal7MatcherINS_8QualTypeEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXMemberCallExpr> thisPointerType_Matcher$QualType$C(final /*const*/ Matcher<QualType> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Overloaded to match the type's declaration.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::thisPointerType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2736,
 FQN="clang::ast_matchers::thisPointerType", NM="_ZN5clang12ast_matchers15thisPointerTypeERKNS0_8internal7MatcherINS_4DeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers15thisPointerTypeERKNS0_8internal7MatcherINS_4DeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXMemberCallExpr> thisPointerType_Matcher$Decl$C(final /*const*/ Matcher<Decl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a DeclRefExpr that refers to a declaration that matches the
/// specified matcher.
///
/// Example matches x in if(x)
///     (matcher = declRefExpr(to(varDecl(hasName("x")))))
/// \code
///   bool x;
///   if (x) {}
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::to">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2752,
 FQN="clang::ast_matchers::to", NM="_ZN5clang12ast_matchers2toERKNS0_8internal7MatcherINS_4DeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers2toERKNS0_8internal7MatcherINS_4DeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<DeclRefExpr> to(final /*const*/ Matcher<Decl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a \c DeclRefExpr that refers to a declaration through a
/// specific using shadow declaration.
///
/// Given
/// \code
///   namespace a { void f() {} }
///   using a::f;
///   void g() {
///     f();     // Matches this ..
///     a::f();  // .. but not this.
///   }
/// \endcode
/// declRefExpr(throughUsingDecl(anything()))
///   matches \c f()
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::throughUsingDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2773,
 FQN="clang::ast_matchers::throughUsingDecl", NM="_ZN5clang12ast_matchers16throughUsingDeclERKNS0_8internal7MatcherINS_15UsingShadowDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers16throughUsingDeclERKNS0_8internal7MatcherINS_15UsingShadowDeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<DeclRefExpr> throughUsingDecl(final /*const*/ Matcher<UsingShadowDecl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the Decl of a DeclStmt which has a single declaration.
///
/// Given
/// \code
///   int a, b;
///   int c;
/// \endcode
/// declStmt(hasSingleDecl(anything()))
///   matches 'int c;' but not 'int a, b;'.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasSingleDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2790,
 FQN="clang::ast_matchers::hasSingleDecl", NM="_ZN5clang12ast_matchers13hasSingleDeclERKNS0_8internal7MatcherINS_4DeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers13hasSingleDeclERKNS0_8internal7MatcherINS_4DeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<DeclStmt> hasSingleDecl(final /*const*/ Matcher<Decl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a variable declaration that has an initializer expression
/// that matches the given matcher.
///
/// Example matches x (matcher = varDecl(hasInitializer(callExpr())))
/// \code
///   bool y() { return true; }
///   bool x = y();
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasInitializer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2806,
 FQN="clang::ast_matchers::hasInitializer", NM="_ZN5clang12ast_matchers14hasInitializerERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers14hasInitializerERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<VarDecl> hasInitializer(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a variable declaration that has function scope and is a
/// non-static local variable.
///
/// Example matches x (matcher = varDecl(hasLocalStorage())
/// \code
/// void f() {
///   int x;
///   static int y;
/// }
/// int z;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasLocalStorage">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2825,
 FQN="clang::ast_matchers::hasLocalStorage", NM="_ZN5clang12ast_matchers15hasLocalStorageEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers15hasLocalStorageEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<VarDecl> hasLocalStorage() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a variable declaration that does not have local storage.
///
/// Example matches y and z (matcher = varDecl(hasGlobalStorage())
/// \code
/// void f() {
///   int x;
///   static int y;
/// }
/// int z;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasGlobalStorage">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2839,
 FQN="clang::ast_matchers::hasGlobalStorage", NM="_ZN5clang12ast_matchers16hasGlobalStorageEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers16hasGlobalStorageEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<VarDecl> hasGlobalStorage() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a variable declaration that has automatic storage duration.
///
/// Example matches x, but not y, z, or a.
/// (matcher = varDecl(hasAutomaticStorageDuration())
/// \code
/// void f() {
///   int x;
///   static int y;
///   thread_local int z;
/// }
/// int a;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasAutomaticStorageDuration">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2855,
 FQN="clang::ast_matchers::hasAutomaticStorageDuration", NM="_ZN5clang12ast_matchers27hasAutomaticStorageDurationEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers27hasAutomaticStorageDurationEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<VarDecl> hasAutomaticStorageDuration() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a variable declaration that has static storage duration.
///
/// Example matches y and a, but not x or z.
/// (matcher = varDecl(hasStaticStorageDuration())
/// \code
/// void f() {
///   int x;
///   static int y;
///   thread_local int z;
/// }
/// int a;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasStaticStorageDuration">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2871,
 FQN="clang::ast_matchers::hasStaticStorageDuration", NM="_ZN5clang12ast_matchers24hasStaticStorageDurationEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers24hasStaticStorageDurationEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<VarDecl> hasStaticStorageDuration() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a variable declaration that has thread storage duration.
///
/// Example matches z, but not x, z, or a.
/// (matcher = varDecl(hasThreadStorageDuration())
/// \code
/// void f() {
///   int x;
///   static int y;
///   thread_local int z;
/// }
/// int a;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasThreadStorageDuration">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2887,
 FQN="clang::ast_matchers::hasThreadStorageDuration", NM="_ZN5clang12ast_matchers24hasThreadStorageDurationEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers24hasThreadStorageDurationEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<VarDecl> hasThreadStorageDuration() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a variable declaration that is an exception variable from
/// a C++ catch block, or an Objective-C \@catch statement.
///
/// Example matches x (matcher = varDecl(isExceptionVariable())
/// \code
/// void f(int y) {
///   try {
///   } catch (int x) {
///   }
/// }
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isExceptionVariable">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2902,
 FQN="clang::ast_matchers::isExceptionVariable", NM="_ZN5clang12ast_matchers19isExceptionVariableEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers19isExceptionVariableEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<VarDecl> isExceptionVariable() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Checks that a call expression or a constructor call expression has
/// a specific number of arguments (including absent default arguments).
///
/// Example matches f(0, 0) (matcher = callExpr(argumentCountIs(2)))
/// \code
///   void f(int x, int y);
///   f(0, 0);
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::argumentCountIs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2914,
 FQN="clang::ast_matchers::argumentCountIs", NM="_ZN5clang12ast_matchers15argumentCountIsERKj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers15argumentCountIsERKj")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam1<matcher_argumentCountIs0Matcher, /*uint*/Integer/*, void (::TypeList<CallExpr, CXXConstructExpr, ObjCMessageExpr>)*/> argumentCountIs(final /*const*/uint$ref/*uint &*/ N) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the n'th argument of a call expression or a constructor
/// call expression.
///
/// Example matches y in x(y)
///     (matcher = callExpr(hasArgument(0, declRefExpr())))
/// \code
///   void x(int) { int y; x(y); }
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasArgument">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2930,
 FQN="clang::ast_matchers::hasArgument", NM="_ZN5clang12ast_matchers11hasArgumentERKjRKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11hasArgumentERKjRKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam2<matcher_hasArgument0Matcher, /*uint*/Integer, Matcher<Expr>/*, void (::TypeList<CallExpr, CXXConstructExpr, ObjCMessageExpr>)*/> hasArgument(final /*const*/uint$ref/*uint &*/ N, final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches declaration statements that contain a specific number of
/// declarations.
///
/// Example: Given
/// \code
///   int a, b;
///   int c;
///   int d = 2, e;
/// \endcode
/// declCountIs(2)
///   matches 'int a, b;' and 'int d = 2, e;', but not 'int c;'.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::declCountIs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2951,
 FQN="clang::ast_matchers::declCountIs", NM="_ZN5clang12ast_matchers11declCountIsERKj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11declCountIsERKj")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<DeclStmt> declCountIs(final /*const*/uint$ref/*uint &*/ N) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the n'th declaration of a declaration statement.
///
/// Note that this does not work for global declarations because the AST
/// breaks up multiple-declaration DeclStmt's into multiple single-declaration
/// DeclStmt's.
/// Example: Given non-global declarations
/// \code
///   int a, b = 0;
///   int c;
///   int d = 2, e;
/// \endcode
/// declStmt(containsDeclaration(
///       0, varDecl(hasInitializer(anything()))))
///   matches only 'int d = 2, e;', and
/// declStmt(containsDeclaration(1, varDecl()))
/// \code
///   matches 'int a, b = 0' as well as 'int d = 2, e;'
///   but 'int c;' is not matched.
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::containsDeclaration">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2974,
 FQN="clang::ast_matchers::containsDeclaration", NM="_ZN5clang12ast_matchers19containsDeclarationERKjRKNS0_8internal7MatcherINS_4DeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers19containsDeclarationERKjRKNS0_8internal7MatcherINS_4DeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<DeclStmt> containsDeclaration(final /*const*/uint$ref/*uint &*/ N, final /*const*/ Matcher<Decl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a C++ catch statement that has a catch-all handler.
///
/// Given
/// \code
///   try {
///     // ...
///   } catch (int) {
///     // ...
///   } catch (...) {
///     // ...
///   }
/// /endcode
/// cxxCatchStmt(isCatchAll()) matches catch(...) but not catch(int).
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isCatchAll">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 2997,
 FQN="clang::ast_matchers::isCatchAll", NM="_ZN5clang12ast_matchers10isCatchAllEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers10isCatchAllEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXCatchStmt> isCatchAll() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a constructor initializer.
///
/// Given
/// \code
///   struct Foo {
///     Foo() : foo_(1) { }
///     int foo_;
///   };
/// \endcode
/// cxxRecordDecl(has(cxxConstructorDecl(
///   hasAnyConstructorInitializer(anything())
/// )))
///   record matches Foo, hasAnyConstructorInitializer matches foo_(1)
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasAnyConstructorInitializer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3014,
 FQN="clang::ast_matchers::hasAnyConstructorInitializer", NM="_ZN5clang12ast_matchers28hasAnyConstructorInitializerERKNS0_8internal7MatcherINS_18CXXCtorInitializerEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers28hasAnyConstructorInitializerERKNS0_8internal7MatcherINS_18CXXCtorInitializerEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXConstructorDecl> hasAnyConstructorInitializer(final /*const*/ Matcher<CXXCtorInitializer> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the field declaration of a constructor initializer.
///
/// Given
/// \code
///   struct Foo {
///     Foo() : foo_(1) { }
///     int foo_;
///   };
/// \endcode
/// cxxRecordDecl(has(cxxConstructorDecl(hasAnyConstructorInitializer(
///     forField(hasName("foo_"))))))
///   matches Foo
/// with forField matching foo_
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::forField">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3033,
 FQN="clang::ast_matchers::forField", NM="_ZN5clang12ast_matchers8forFieldERKNS0_8internal7MatcherINS_9FieldDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8forFieldERKNS0_8internal7MatcherINS_9FieldDeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXCtorInitializer> forField(final /*const*/ Matcher<FieldDecl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the initializer expression of a constructor initializer.
///
/// Given
/// \code
///   struct Foo {
///     Foo() : foo_(1) { }
///     int foo_;
///   };
/// \endcode
/// cxxRecordDecl(has(cxxConstructorDecl(hasAnyConstructorInitializer(
///     withInitializer(integerLiteral(equals(1)))))))
///   matches Foo
/// with withInitializer matching (1)
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::withInitializer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3053,
 FQN="clang::ast_matchers::withInitializer", NM="_ZN5clang12ast_matchers15withInitializerERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers15withInitializerERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXCtorInitializer> withInitializer(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a constructor initializer if it is explicitly written in
/// code (as opposed to implicitly added by the compiler).
///
/// Given
/// \code
///   struct Foo {
///     Foo() { }
///     Foo(int) : foo_("A") { }
///     string foo_;
///   };
/// \endcode
/// cxxConstructorDecl(hasAnyConstructorInitializer(isWritten()))
///   will match Foo(int), but not Foo()
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isWritten">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3073,
 FQN="clang::ast_matchers::isWritten", NM="_ZN5clang12ast_matchers9isWrittenEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers9isWrittenEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXCtorInitializer> isWritten() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a constructor initializer if it is initializing a base, as
/// opposed to a member.
///
/// Given
/// \code
///   struct B {};
///   struct D : B {
///     int I;
///     D(int i) : I(i) {}
///   };
///   struct E : B {
///     E() : B() {}
///   };
/// \endcode
/// cxxConstructorDecl(hasAnyConstructorInitializer(isBaseInitializer()))
///   will match E(), but not match D(int).
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isBaseInitializer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3093,
 FQN="clang::ast_matchers::isBaseInitializer", NM="_ZN5clang12ast_matchers17isBaseInitializerEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers17isBaseInitializerEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXCtorInitializer> isBaseInitializer() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a constructor initializer if it is initializing a member, as
/// opposed to a base.
///
/// Given
/// \code
///   struct B {};
///   struct D : B {
///     int I;
///     D(int i) : I(i) {}
///   };
///   struct E : B {
///     E() : B() {}
///   };
/// \endcode
/// cxxConstructorDecl(hasAnyConstructorInitializer(isMemberInitializer()))
///   will match D(int), but not match E().
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isMemberInitializer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3113,
 FQN="clang::ast_matchers::isMemberInitializer", NM="_ZN5clang12ast_matchers19isMemberInitializerEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers19isMemberInitializerEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXCtorInitializer> isMemberInitializer() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches any argument of a call expression or a constructor call
/// expression.
///
/// Given
/// \code
///   void x(int, int, int) { int y; x(1, y, 42); }
/// \endcode
/// callExpr(hasAnyArgument(declRefExpr()))
///   matches x(1, y, 42)
/// with hasAnyArgument(...)
///   matching y
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasAnyArgument">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3128,
 FQN="clang::ast_matchers::hasAnyArgument", NM="_ZN5clang12ast_matchers14hasAnyArgumentERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers14hasAnyArgumentERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam1<matcher_hasAnyArgument0Matcher, Matcher<Expr>/*, void (::TypeList<CallExpr, CXXConstructExpr>)*/> hasAnyArgument(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a constructor call expression which uses list initialization.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isListInitialization">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3143,
 FQN="clang::ast_matchers::isListInitialization", NM="_ZN5clang12ast_matchers20isListInitializationEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers20isListInitializationEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXConstructExpr> isListInitialization() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a constructor call expression which requires
/// zero initialization.
///
/// Given
/// \code
/// void foo() {
///   struct point { double x; double y; };
///   point pt[2] = { { 1.0, 2.0 } };
/// }
/// \endcode
/// initListExpr(has(cxxConstructExpr(requiresZeroInitialization()))
/// will match the implicit array filler for pt[1].
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::requiresZeroInitialization">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3159,
 FQN="clang::ast_matchers::requiresZeroInitialization", NM="_ZN5clang12ast_matchers26requiresZeroInitializationEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers26requiresZeroInitializationEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXConstructExpr> requiresZeroInitialization() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the n'th parameter of a function declaration.
///
/// Given
/// \code
///   class X { void f(int x) {} };
/// \endcode
/// cxxMethodDecl(hasParameter(0, hasType(varDecl())))
///   matches f(int x) {}
/// with hasParameter(...)
///   matching int x
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasParameter">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3173,
 FQN="clang::ast_matchers::hasParameter", NM="_ZN5clang12ast_matchers12hasParameterERKjRKNS0_8internal7MatcherINS_11ParmVarDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers12hasParameterERKjRKNS0_8internal7MatcherINS_11ParmVarDeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<FunctionDecl> hasParameter(final /*const*/uint$ref/*uint &*/ N, final /*const*/ Matcher<ParmVarDecl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches all arguments and their respective ParmVarDecl.
///
/// Given
/// \code
///   void f(int i);
///   int y;
///   f(y);
/// \endcode
/// callExpr(
///   forEachArgumentWithParam(
///     declRefExpr(to(varDecl(hasName("y")))),
///     parmVarDecl(hasType(isInteger()))
/// ))
///   matches f(y);
/// with declRefExpr(...)
///   matching int y
/// and parmVarDecl(...)
///   matching int i
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::forEachArgumentWithParam">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3199,
 FQN="clang::ast_matchers::forEachArgumentWithParam", NM="_ZN5clang12ast_matchers24forEachArgumentWithParamERKNS0_8internal7MatcherINS_4ExprEEERKNS2_INS_11ParmVarDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers24forEachArgumentWithParamERKNS0_8internal7MatcherINS_4ExprEEERKNS2_INS_11ParmVarDeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam2<matcher_forEachArgumentWithParam0Matcher, Matcher<Expr>, Matcher<ParmVarDecl>/*, void (::TypeList<CallExpr, CXXConstructExpr>)*/> forEachArgumentWithParam(final /*const*/ Matcher<Expr> /*&*/ ArgMatcher, final /*const*/ Matcher<ParmVarDecl> /*&*/ ParamMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches any parameter of a function declaration.
///
/// Does not match the 'this' parameter of a method.
///
/// Given
/// \code
///   class X { void f(int x, int y, int z) {} };
/// \endcode
/// cxxMethodDecl(hasAnyParameter(hasName("y")))
///   matches f(int x, int y, int z) {}
/// with hasAnyParameter(...)
///   matching int y
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasAnyParameter">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3247,
 FQN="clang::ast_matchers::hasAnyParameter", NM="_ZN5clang12ast_matchers15hasAnyParameterERKNS0_8internal7MatcherINS_11ParmVarDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers15hasAnyParameterERKNS0_8internal7MatcherINS_11ParmVarDeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<FunctionDecl> hasAnyParameter(final /*const*/ Matcher<ParmVarDecl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches \c FunctionDecls and \c FunctionProtoTypes that have a
/// specific parameter count.
///
/// Given
/// \code
///   void f(int i) {}
///   void g(int i, int j) {}
///   void h(int i, int j);
///   void j(int i);
///   void k(int x, int y, int z, ...);
/// \endcode
/// functionDecl(parameterCountIs(2))
///   matches void g(int i, int j) {}
/// functionProtoType(parameterCountIs(2))
///   matches void h(int i, int j)
/// functionProtoType(parameterCountIs(3))
///   matches void k(int x, int y, int z, ...);
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::parameterCountIs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3270,
 FQN="clang::ast_matchers::parameterCountIs", NM="_ZN5clang12ast_matchers16parameterCountIsERKj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers16parameterCountIsERKj")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam1<matcher_parameterCountIs0Matcher, /*uint*/Integer/*, void (::TypeList<FunctionDecl, FunctionProtoType>)*/> parameterCountIs(final /*const*/uint$ref/*uint &*/ N) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the return type of a function declaration.
///
/// Given:
/// \code
///   class X { int f() { return 1; } };
/// \endcode
/// cxxMethodDecl(returns(asString("int")))
///   matches int f() { return 1; }
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::returns">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3285,
 FQN="clang::ast_matchers::returns", NM="_ZN5clang12ast_matchers7returnsERKNS0_8internal7MatcherINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers7returnsERKNS0_8internal7MatcherINS_8QualTypeEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<FunctionDecl> returns(final /*const*/ Matcher<QualType> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches extern "C" function declarations.
///
/// Given:
/// \code
///   extern "C" void f() {}
///   extern "C" { void g() {} }
///   void h() {}
/// \endcode
/// functionDecl(isExternC())
///   matches the declaration of f and g, but not the declaration h
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isExternC">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3300,
 FQN="clang::ast_matchers::isExternC", NM="_ZN5clang12ast_matchers9isExternCEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers9isExternCEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<FunctionDecl> isExternC() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches deleted function declarations.
///
/// Given:
/// \code
///   void Func();
///   void DeletedFunc() = delete;
/// \endcode
/// functionDecl(isDeleted())
///   matches the declaration of DeletedFunc, but not Func.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isDeleted">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3313,
 FQN="clang::ast_matchers::isDeleted", NM="_ZN5clang12ast_matchers9isDeletedEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers9isDeletedEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<FunctionDecl> isDeleted() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches defaulted function declarations.
///
/// Given:
/// \code
///   class A { ~A(); };
///   class B { ~B() = default; };
/// \endcode
/// functionDecl(isDefaulted())
///   matches the declaration of ~B, but not ~A.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isDefaulted">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3326,
 FQN="clang::ast_matchers::isDefaulted", NM="_ZN5clang12ast_matchers11isDefaultedEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11isDefaultedEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<FunctionDecl> isDefaulted() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches functions that have a dynamic exception specification.
///
/// Given:
/// \code
///   void f();
///   void g() noexcept;
///   void h() noexcept(true);
///   void i() noexcept(false);
///   void j() throw();
///   void k() throw(int);
///   void l() throw(...);
/// \endcode
/// functionDecl(hasDynamicExceptionSpec()) and
///   functionProtoType(hasDynamicExceptionSpec())
///   match the declarations of j, k, and l, but not f, g, h, or i.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasDynamicExceptionSpec">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3345,
 FQN="clang::ast_matchers::hasDynamicExceptionSpec", NM="_ZN5clang12ast_matchers23hasDynamicExceptionSpecEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers23hasDynamicExceptionSpecEv")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam0<matcher_hasDynamicExceptionSpecMatcher/*, void (::TypeList<FunctionDecl, FunctionProtoType>)*/> hasDynamicExceptionSpec() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches functions that have a non-throwing exception specification.
///
/// Given:
/// \code
///   void f();
///   void g() noexcept;
///   void h() throw();
///   void i() throw(int);
///   void j() noexcept(false);
/// \endcode
/// functionDecl(isNoThrow()) and functionProtoType(isNoThrow())
///   match the declarations of g, and h, but not f, i or j.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isNoThrow">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3365,
 FQN="clang::ast_matchers::isNoThrow", NM="_ZN5clang12ast_matchers9isNoThrowEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers9isNoThrowEv")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam0<matcher_isNoThrowMatcher/*, void (::TypeList<FunctionDecl, FunctionProtoType>)*/> isNoThrow() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches constexpr variable and function declarations.
///
/// Given:
/// \code
///   constexpr int foo = 42;
///   constexpr int bar();
/// \endcode
/// varDecl(isConstexpr())
///   matches the declaration of foo.
/// functionDecl(isConstexpr())
///   matches the declaration of bar.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isConstexpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3394,
 FQN="clang::ast_matchers::isConstexpr", NM="_ZN5clang12ast_matchers11isConstexprEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11isConstexprEv")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam0<matcher_isConstexprMatcher/*, void (::TypeList<VarDecl, FunctionDecl>)*/> isConstexpr() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the condition expression of an if statement, for loop,
/// switch statement or conditional operator.
///
/// Example matches true (matcher = hasCondition(cxxBoolLiteral(equals(true))))
/// \code
///   if (true) {}
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasCondition">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3407,
 FQN="clang::ast_matchers::hasCondition", NM="_ZN5clang12ast_matchers12hasConditionERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers12hasConditionERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam1<matcher_hasCondition0Matcher, Matcher<Expr>/*, void (::TypeList<IfStmt, ForStmt, WhileStmt, DoStmt, SwitchStmt, AbstractConditionalOperator>)*/> hasCondition(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the then-statement of an if statement.
///
/// Examples matches the if statement
///   (matcher = ifStmt(hasThen(cxxBoolLiteral(equals(true)))))
/// \code
///   if (false) true; else false;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasThen">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3424,
 FQN="clang::ast_matchers::hasThen", NM="_ZN5clang12ast_matchers7hasThenERKNS0_8internal7MatcherINS_4StmtEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers7hasThenERKNS0_8internal7MatcherINS_4StmtEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<IfStmt> hasThen(final /*const*/ Matcher<Stmt> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the else-statement of an if statement.
///
/// Examples matches the if statement
///   (matcher = ifStmt(hasElse(cxxBoolLiteral(equals(true)))))
/// \code
///   if (false) false; else true;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasElse">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3436,
 FQN="clang::ast_matchers::hasElse", NM="_ZN5clang12ast_matchers7hasElseERKNS0_8internal7MatcherINS_4StmtEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers7hasElseERKNS0_8internal7MatcherINS_4StmtEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<IfStmt> hasElse(final /*const*/ Matcher<Stmt> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if a node equals a previously bound node.
///
/// Matches a node if it equals the node previously bound to \p ID.
///
/// Given
/// \code
///   class X { int a; int b; };
/// \endcode
/// cxxRecordDecl(
///     has(fieldDecl(hasName("a"), hasType(type().bind("t")))),
///     has(fieldDecl(hasName("b"), hasType(type(equalsBoundNode("t"))))))
///   matches the class \c X, as \c a and \c b have the same type.
///
/// Note that when multiple matches are involved via \c forEach* matchers,
/// \c equalsBoundNodes acts as a filter.
/// For example:
/// compoundStmt(
///     forEachDescendant(varDecl().bind("d")),
///     forEachDescendant(declRefExpr(to(decl(equalsBoundNode("d"))))))
/// will trigger a match for each combination of variable declaration
/// and reference to that variable declaration within a compound statement.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::equalsBoundNode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3462,
 FQN="clang::ast_matchers::equalsBoundNode", NM="_ZN5clang12ast_matchers15equalsBoundNodeERKSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers15equalsBoundNodeERKSs")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam1<matcher_equalsBoundNode0Matcher, std.string/*, void (::TypeList<Stmt, Decl, Type, QualType>)*/> equalsBoundNode(final /*const*/std.string/*&*/ ID) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the condition variable statement in an if statement.
///
/// Given
/// \code
///   if (A* a = GetAPointer()) {}
/// \endcode
/// hasConditionVariableStatement(...)
///   matches 'A* a = GetAPointer()'.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasConditionVariableStatement">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3486,
 FQN="clang::ast_matchers::hasConditionVariableStatement", NM="_ZN5clang12ast_matchers29hasConditionVariableStatementERKNS0_8internal7MatcherINS_8DeclStmtEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers29hasConditionVariableStatementERKNS0_8internal7MatcherINS_8DeclStmtEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<IfStmt> hasConditionVariableStatement(final /*const*/ Matcher<DeclStmt> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the index expression of an array subscript expression.
///
/// Given
/// \code
///   int i[5];
///   void f() { i[1] = 42; }
/// \endcode
/// arraySubscriptExpression(hasIndex(integerLiteral()))
///   matches \c i[1] with the \c integerLiteral() matching \c 1
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasIndex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3503,
 FQN="clang::ast_matchers::hasIndex", NM="_ZN5clang12ast_matchers8hasIndexERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8hasIndexERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<ArraySubscriptExpr> hasIndex(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the base expression of an array subscript expression.
///
/// Given
/// \code
///   int i[5];
///   void f() { i[1] = 42; }
/// \endcode
/// arraySubscriptExpression(hasBase(implicitCastExpr(
///     hasSourceExpression(declRefExpr()))))
///   matches \c i[1] with the \c declRefExpr() matching \c i
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasBase">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3520,
 FQN="clang::ast_matchers::hasBase", NM="_ZN5clang12ast_matchers7hasBaseERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers7hasBaseERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<ArraySubscriptExpr> hasBase(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a 'for', 'while', 'do while' statement or a function
/// definition that has a given body.
///
/// Given
/// \code
///   for (;;) {}
/// \endcode
/// hasBody(compoundStmt())
///   matches 'for (;;) {}'
/// with compoundStmt()
///   matching '{}'
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasBody">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3538,
 FQN="clang::ast_matchers::hasBody", NM="_ZN5clang12ast_matchers7hasBodyERKNS0_8internal7MatcherINS_4StmtEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers7hasBodyERKNS0_8internal7MatcherINS_4StmtEEE")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam1<matcher_hasBody0Matcher, Matcher<Stmt>/*, void (::TypeList<DoStmt, ForStmt, WhileStmt, CXXForRangeStmt, FunctionDecl>)*/> hasBody(final /*const*/ Matcher<Stmt> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches compound statements where at least one substatement matches
/// a given matcher. Also matches StmtExprs that have CompoundStmt as children.
///
/// Given
/// \code
///   { {}; 1+2; }
/// \endcode
/// hasAnySubstatement(compoundStmt())
///   matches '{ {}; 1+2; }'
/// with compoundStmt()
///   matching '{}'
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasAnySubstatement">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3560,
 FQN="clang::ast_matchers::hasAnySubstatement", NM="_ZN5clang12ast_matchers18hasAnySubstatementERKNS0_8internal7MatcherINS_4StmtEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers18hasAnySubstatementERKNS0_8internal7MatcherINS_4StmtEEE")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam1<matcher_hasAnySubstatement0Matcher, Matcher<Stmt>/*, void (::TypeList<CompoundStmt, StmtExpr>)*/> hasAnySubstatement(final /*const*/ Matcher<Stmt> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Checks that a compound statement contains a specific number of
/// child statements.
///
/// Example: Given
/// \code
///   { for (;;) {} }
/// \endcode
/// compoundStmt(statementCountIs(0)))
///   matches '{}'
///   but does not match the outer compound statement.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::statementCountIs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3579,
 FQN="clang::ast_matchers::statementCountIs", NM="_ZN5clang12ast_matchers16statementCountIsERKj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers16statementCountIsERKj")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CompoundStmt> statementCountIs(final /*const*/uint$ref/*uint &*/ N) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches literals that are equal to the given value.
///
/// Example matches true (matcher = cxxBoolLiteral(equals(true)))
/// \code
///   true
/// \endcode
///
/// Usable as: Matcher<CharacterLiteral>, Matcher<CXXBoolLiteral>,
///            Matcher<FloatingLiteral>, Matcher<IntegerLiteral>
/*template <typename ValueT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::equals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3593,
 FQN="clang::ast_matchers::equals", NM="Tpl__ZN5clang12ast_matchers6equalsERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=Tpl__ZN5clang12ast_matchers6equalsERKT_")
//</editor-fold>
public static </*typename*/ ValueT> PolymorphicMatcherWithParam1<ValueEqualsMatcher, ValueT> ast_matchers$equals(final /*const*/ ValueT /*&*/ Value) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the operator Name of operator expressions (binary or
/// unary).
///
/// Example matches a || b (matcher = binaryOperator(hasOperatorName("||")))
/// \code
///   !(a || b)
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasOperatorName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3607,
 FQN="clang::ast_matchers::hasOperatorName", NM="_ZN5clang12ast_matchers15hasOperatorNameERKSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers15hasOperatorNameERKSs")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam1<matcher_hasOperatorName0Matcher, std.string/*, void (::TypeList<BinaryOperator, UnaryOperator>)*/> hasOperatorName(final /*const*/std.string/*&*/ Name) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the left hand side of binary operator expressions.
///
/// Example matches a (matcher = binaryOperator(hasLHS()))
/// \code
///   a || b
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasLHS">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3620,
 FQN="clang::ast_matchers::hasLHS", NM="_ZN5clang12ast_matchers6hasLHSERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers6hasLHSERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam1<matcher_hasLHS0Matcher, Matcher<Expr>/*, void (::TypeList<BinaryOperator, ArraySubscriptExpr>)*/> hasLHS(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the right hand side of binary operator expressions.
///
/// Example matches b (matcher = binaryOperator(hasRHS()))
/// \code
///   a || b
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasRHS">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3635,
 FQN="clang::ast_matchers::hasRHS", NM="_ZN5clang12ast_matchers6hasRHSERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers6hasRHSERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam1<matcher_hasRHS0Matcher, Matcher<Expr>/*, void (::TypeList<BinaryOperator, ArraySubscriptExpr>)*/> hasRHS(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if either the left hand side or the right hand side of a
/// binary operator matches.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasEitherOperand">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3646,
 FQN="clang::ast_matchers::hasEitherOperand", NM="_ZN5clang12ast_matchers16hasEitherOperandERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers16hasEitherOperandERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ Matcher<BinaryOperator> hasEitherOperand(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if the operand of a unary operator matches.
///
/// Example matches true (matcher = hasUnaryOperand(
///                                   cxxBoolLiteral(equals(true))))
/// \code
///   !true
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasUnaryOperand">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3658,
 FQN="clang::ast_matchers::hasUnaryOperand", NM="_ZN5clang12ast_matchers15hasUnaryOperandERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers15hasUnaryOperandERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<UnaryOperator> hasUnaryOperand(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if the cast's source expression
/// or opaque value's source expression matches the given matcher.
///
/// Example 1: matches "a string"
/// (matcher = castExpr(hasSourceExpression(cxxConstructExpr())))
/// \code
/// class URL { URL(string); };
/// URL url = "a string";
/// \endcode
///
/// Example 2: matches 'b' (matcher =
/// opaqueValueExpr(hasSourceExpression(implicitCastExpr(declRefExpr())))
/// \code
/// int a = b ?: 1;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasSourceExpression">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3681,
 FQN="clang::ast_matchers::hasSourceExpression", NM="_ZN5clang12ast_matchers19hasSourceExpressionERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers19hasSourceExpressionERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam1<matcher_hasSourceExpression0Matcher, Matcher<Expr>/*, void (::TypeList<CastExpr, OpaqueValueExpr>)*/> hasSourceExpression(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches casts that has a given cast kind.
///
/// Example: matches the implicit cast around \c 0
/// (matcher = castExpr(hasCastKind(CK_NullToPointer)))
/// \code
///   int *p = 0;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasCastKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3698,
 FQN="clang::ast_matchers::hasCastKind", NM="_ZN5clang12ast_matchers11hasCastKindERKNS_8CastKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11hasCastKindERKNS_8CastKindE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CastExpr> hasCastKind(final /*const*/ CastKind /*&*/ Kind) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches casts whose destination type matches a given matcher.
///
/// (Note: Clang's AST refers to other conversions as "casts" too, and calls
/// actual casts "explicit" casts.)
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasDestinationType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3706,
 FQN="clang::ast_matchers::hasDestinationType", NM="_ZN5clang12ast_matchers18hasDestinationTypeERKNS0_8internal7MatcherINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers18hasDestinationTypeERKNS0_8internal7MatcherINS_8QualTypeEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<ExplicitCastExpr> hasDestinationType(final /*const*/ Matcher<QualType> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches implicit casts whose destination type matches a given
/// matcher.
///
/// FIXME: Unit test this matcher
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasImplicitDestinationType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3716,
 FQN="clang::ast_matchers::hasImplicitDestinationType", NM="_ZN5clang12ast_matchers26hasImplicitDestinationTypeERKNS0_8internal7MatcherINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers26hasImplicitDestinationTypeERKNS0_8internal7MatcherINS_8QualTypeEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<ImplicitCastExpr> hasImplicitDestinationType(final /*const*/ Matcher<QualType> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches RecordDecl object that are spelled with "struct."
///
/// Example matches S, but not C or U.
/// \code
///   struct S {};
///   class C {};
///   union U {};
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isStruct">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3729,
 FQN="clang::ast_matchers::isStruct", NM="_ZN5clang12ast_matchers8isStructEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8isStructEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<RecordDecl> isStruct() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches RecordDecl object that are spelled with "union."
///
/// Example matches U, but not C or S.
/// \code
///   struct S {};
///   class C {};
///   union U {};
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isUnion">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3741,
 FQN="clang::ast_matchers::isUnion", NM="_ZN5clang12ast_matchers7isUnionEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers7isUnionEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<RecordDecl> isUnion() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches RecordDecl object that are spelled with "class."
///
/// Example matches C, but not S or U.
/// \code
///   struct S {};
///   class C {};
///   union U {};
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isClass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3753,
 FQN="clang::ast_matchers::isClass", NM="_ZN5clang12ast_matchers7isClassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers7isClassEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<RecordDecl> isClass() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the true branch expression of a conditional operator.
///
/// Example 1 (conditional ternary operator): matches a
/// \code
///   condition ? a : b
/// \endcode
///
/// Example 2 (conditional binary operator): matches opaqueValueExpr(condition)
/// \code
///   condition ?: b
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasTrueExpression">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3768,
 FQN="clang::ast_matchers::hasTrueExpression", NM="_ZN5clang12ast_matchers17hasTrueExpressionERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers17hasTrueExpressionERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<AbstractConditionalOperator> hasTrueExpression(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the false branch expression of a conditional operator
/// (binary or ternary).
///
/// Example matches b
/// \code
///   condition ? a : b
///   condition ?: b
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasFalseExpression">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3783,
 FQN="clang::ast_matchers::hasFalseExpression", NM="_ZN5clang12ast_matchers18hasFalseExpressionERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers18hasFalseExpressionERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<AbstractConditionalOperator> hasFalseExpression(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if a declaration has a body attached.
///
/// Example matches A, va, fa
/// \code
///   class A {};
///   class B;  // Doesn't match, as it has no body.
///   int va;
///   extern int vb;  // Doesn't match, as it doesn't define the variable.
///   void fa() {}
///   void fb();  // Doesn't match, as it has no body.
/// \endcode
///
/// Usable as: Matcher<TagDecl>, Matcher<VarDecl>, Matcher<FunctionDecl>
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isDefinition">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3803,
 FQN="clang::ast_matchers::isDefinition", NM="_ZN5clang12ast_matchers12isDefinitionEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers12isDefinitionEv")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam0<matcher_isDefinitionMatcher/*, void (::TypeList<TagDecl, VarDecl, FunctionDecl>)*/> isDefinition() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if a function declaration is variadic.
///
/// Example matches f, but not g or h. The function i will not match, even when
/// compiled in C mode.
/// \code
///   void f(...);
///   void g(int);
///   template <typename... Ts> void h(Ts...);
///   void i();
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isVariadic">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3819,
 FQN="clang::ast_matchers::isVariadic", NM="_ZN5clang12ast_matchers10isVariadicEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers10isVariadicEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<FunctionDecl> isVariadic() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the class declaration that the given method declaration
/// belongs to.
///
/// FIXME: Generalize this for other kinds of declarations.
/// FIXME: What other kind of declarations would we need to generalize
/// this to?
///
/// Example matches A() in the last line
///     (matcher = cxxConstructExpr(hasDeclaration(cxxMethodDecl(
///         ofClass(hasName("A"))))))
/// \code
///   class A {
///    public:
///     A();
///   };
///   A a = A();
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::ofClass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3840,
 FQN="clang::ast_matchers::ofClass", NM="_ZN5clang12ast_matchers7ofClassERKNS0_8internal7MatcherINS_13CXXRecordDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers7ofClassERKNS0_8internal7MatcherINS_13CXXRecordDeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXMethodDecl> ofClass(final /*const*/ Matcher<CXXRecordDecl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches each method overriden by the given method. This matcher may
/// produce multiple matches.
///
/// Given
/// \code
///   class A { virtual void f(); };
///   class B : public A { void f(); };
///   class C : public B { void f(); };
/// \endcode
/// cxxMethodDecl(ofClass(hasName("C")),
///               forEachOverridden(cxxMethodDecl().bind("b"))).bind("d")
///   matches once, with "b" binding "A::f" and "d" binding "C::f" (Note
///   that B::f is not overridden by C::f).
///
/// The check can produce multiple matches in case of multiple inheritance, e.g.
/// \code
///   class A1 { virtual void f(); };
///   class A2 { virtual void f(); };
///   class C : public A1, public A2 { void f(); };
/// \endcode
/// cxxMethodDecl(ofClass(hasName("C")),
///               forEachOverridden(cxxMethodDecl().bind("b"))).bind("d")
///   matches twice, once with "b" binding "A1::f" and "d" binding "C::f", and
///   once with "b" binding "A2::f" and "d" binding "C::f".
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::forEachOverridden">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3871,
 FQN="clang::ast_matchers::forEachOverridden", NM="_ZN5clang12ast_matchers17forEachOverriddenERKNS0_8internal7MatcherINS_13CXXMethodDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers17forEachOverriddenERKNS0_8internal7MatcherINS_13CXXMethodDeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXMethodDecl> forEachOverridden(final /*const*/ Matcher<CXXMethodDecl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if the given method declaration is virtual.
///
/// Given
/// \code
///   class A {
///    public:
///     virtual void x();
///   };
/// \endcode
///   matches A::x
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isVirtual">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3898,
 FQN="clang::ast_matchers::isVirtual", NM="_ZN5clang12ast_matchers9isVirtualEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers9isVirtualEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXMethodDecl> isVirtual() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if the given method declaration has an explicit "virtual".
///
/// Given
/// \code
///   class A {
///    public:
///     virtual void x();
///   };
///   class B : public A {
///    public:
///     void x();
///   };
/// \endcode
///   matches A::x but not B::x
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isVirtualAsWritten">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3916,
 FQN="clang::ast_matchers::isVirtualAsWritten", NM="_ZN5clang12ast_matchers18isVirtualAsWrittenEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers18isVirtualAsWrittenEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXMethodDecl> isVirtualAsWritten() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if the given method or class declaration is final.
///
/// Given:
/// \code
///   class A final {};
///
///   struct B {
///     virtual void f();
///   };
///
///   struct C : B {
///     void f() final;
///   };
/// \endcode
/// matches A and C::f, but not B, C, or B::f
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isFinal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3935,
 FQN="clang::ast_matchers::isFinal", NM="_ZN5clang12ast_matchers7isFinalEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers7isFinalEv")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam0<matcher_isFinalMatcher/*, void (::TypeList<CXXRecordDecl, CXXMethodDecl>)*/> isFinal() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if the given method declaration is pure.
///
/// Given
/// \code
///   class A {
///    public:
///     virtual void x() = 0;
///   };
/// \endcode
///   matches A::x
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isPure">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3951,
 FQN="clang::ast_matchers::isPure", NM="_ZN5clang12ast_matchers6isPureEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers6isPureEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXMethodDecl> isPure() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if the given method declaration is const.
///
/// Given
/// \code
/// struct A {
///   void foo() const;
///   void bar();
/// };
/// \endcode
///
/// cxxMethodDecl(isConst()) matches A::foo() but not A::bar()
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isConst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3966,
 FQN="clang::ast_matchers::isConst", NM="_ZN5clang12ast_matchers7isConstEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers7isConstEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXMethodDecl> isConst() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if the given method declaration declares a copy assignment
/// operator.
///
/// Given
/// \code
/// struct A {
///   A &operator=(const A &);
///   A &operator=(A &&);
/// };
/// \endcode
///
/// cxxMethodDecl(isCopyAssignmentOperator()) matches the first method but not
/// the second one.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isCopyAssignmentOperator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3983,
 FQN="clang::ast_matchers::isCopyAssignmentOperator", NM="_ZN5clang12ast_matchers24isCopyAssignmentOperatorEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers24isCopyAssignmentOperatorEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXMethodDecl> isCopyAssignmentOperator() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if the given method declaration declares a move assignment
/// operator.
///
/// Given
/// \code
/// struct A {
///   A &operator=(const A &);
///   A &operator=(A &&);
/// };
/// \endcode
///
/// cxxMethodDecl(isMoveAssignmentOperator()) matches the second method but not
/// the first one.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isMoveAssignmentOperator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4000,
 FQN="clang::ast_matchers::isMoveAssignmentOperator", NM="_ZN5clang12ast_matchers24isMoveAssignmentOperatorEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers24isMoveAssignmentOperatorEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXMethodDecl> isMoveAssignmentOperator() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches if the given method declaration overrides another method.
///
/// Given
/// \code
///   class A {
///    public:
///     virtual void x();
///   };
///   class B : public A {
///    public:
///     virtual void x();
///   };
/// \endcode
///   matches B::x
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isOverride">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4018,
 FQN="clang::ast_matchers::isOverride", NM="_ZN5clang12ast_matchers10isOverrideEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers10isOverrideEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXMethodDecl> isOverride() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches method declarations that are user-provided.
///
/// Given
/// \code
///   struct S {
///     S(); // #1
///     S(const S &) = default; // #2
///     S(S &&) = delete; // #3
///   };
/// \endcode
/// cxxConstructorDecl(isUserProvided()) will match #1, but not #2 or #3.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isUserProvided">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4033,
 FQN="clang::ast_matchers::isUserProvided", NM="_ZN5clang12ast_matchers14isUserProvidedEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers14isUserProvidedEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXMethodDecl> isUserProvided() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches member expressions that are called with '->' as opposed
/// to '.'.
///
/// Member calls on the implicit this pointer match as called with '->'.
///
/// Given
/// \code
///   class Y {
///     void x() { this->x(); x(); Y y; y.x(); a; this->b; Y::b; }
///     int a;
///     static int b;
///   };
/// \endcode
/// memberExpr(isArrow())
///   matches this->x, x, y.x, a, this->b
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isArrow">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4052,
 FQN="clang::ast_matchers::isArrow", NM="_ZN5clang12ast_matchers7isArrowEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers7isArrowEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<MemberExpr> isArrow() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches QualType nodes that are of integer type.
///
/// Given
/// \code
///   void a(int);
///   void b(long);
///   void c(double);
/// \endcode
/// functionDecl(hasAnyParameter(hasType(isInteger())))
/// matches "a(int)", "b(long)", but not "c(double)".
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isInteger">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4066,
 FQN="clang::ast_matchers::isInteger", NM="_ZN5clang12ast_matchers9isIntegerEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers9isIntegerEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<QualType> isInteger() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches QualType nodes that are of unsigned integer type.
///
/// Given
/// \code
///   void a(int);
///   void b(unsigned long);
///   void c(double);
/// \endcode
/// functionDecl(hasAnyParameter(hasType(isInteger())))
/// matches "b(unsigned long)", but not "a(int)" and "c(double)".
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isUnsignedInteger">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4080,
 FQN="clang::ast_matchers::isUnsignedInteger", NM="_ZN5clang12ast_matchers17isUnsignedIntegerEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers17isUnsignedIntegerEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<QualType> isUnsignedInteger() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches QualType nodes that are of signed integer type.
///
/// Given
/// \code
///   void a(int);
///   void b(unsigned long);
///   void c(double);
/// \endcode
/// functionDecl(hasAnyParameter(hasType(isInteger())))
/// matches "a(int)", but not "b(unsigned long)" and "c(double)".
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isSignedInteger">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4094,
 FQN="clang::ast_matchers::isSignedInteger", NM="_ZN5clang12ast_matchers15isSignedIntegerEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers15isSignedIntegerEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<QualType> isSignedInteger() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches QualType nodes that are of character type.
///
/// Given
/// \code
///   void a(char);
///   void b(wchar_t);
///   void c(double);
/// \endcode
/// functionDecl(hasAnyParameter(hasType(isAnyCharacter())))
/// matches "a(char)", "b(wchar_t)", but not "c(double)".
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isAnyCharacter">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4108,
 FQN="clang::ast_matchers::isAnyCharacter", NM="_ZN5clang12ast_matchers14isAnyCharacterEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers14isAnyCharacterEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<QualType> isAnyCharacter() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches QualType nodes that are of any pointer type; this includes
/// the Objective-C object pointer type, which is different despite being
/// syntactically similar.
///
/// Given
/// \code
///   int *i = nullptr;
///
///   @interface Foo
///   @end
///   Foo *f;
///
///   int j;
/// \endcode
/// varDecl(hasType(isAnyPointer()))
///   matches "int *i" and "Foo *f", but not "int j".
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isAnyPointer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4128,
 FQN="clang::ast_matchers::isAnyPointer", NM="_ZN5clang12ast_matchers12isAnyPointerEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers12isAnyPointerEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<QualType> isAnyPointer() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches QualType nodes that are const-qualified, i.e., that
/// include "top-level" const.
///
/// Given
/// \code
///   void a(int);
///   void b(int const);
///   void c(const int);
///   void d(const int*);
///   void e(int const) {};
/// \endcode
/// functionDecl(hasAnyParameter(hasType(isConstQualified())))
///   matches "void b(int const)", "void c(const int)" and
///   "void e(int const) {}". It does not match d as there
///   is no top-level const on the parameter type "const int *".
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isConstQualified">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4147,
 FQN="clang::ast_matchers::isConstQualified", NM="_ZN5clang12ast_matchers16isConstQualifiedEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers16isConstQualifiedEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<QualType> isConstQualified() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches QualType nodes that are volatile-qualified, i.e., that
/// include "top-level" volatile.
///
/// Given
/// \code
///   void a(int);
///   void b(int volatile);
///   void c(volatile int);
///   void d(volatile int*);
///   void e(int volatile) {};
/// \endcode
/// functionDecl(hasAnyParameter(hasType(isVolatileQualified())))
///   matches "void b(int volatile)", "void c(volatile int)" and
///   "void e(int volatile) {}". It does not match d as there
///   is no top-level volatile on the parameter type "volatile int *".
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isVolatileQualified">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4166,
 FQN="clang::ast_matchers::isVolatileQualified", NM="_ZN5clang12ast_matchers19isVolatileQualifiedEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers19isVolatileQualifiedEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<QualType> isVolatileQualified() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches QualType nodes that have local CV-qualifiers attached to
/// the node, not hidden within a typedef.
///
/// Given
/// \code
///   typedef const int const_int;
///   const_int i;
///   int *const j;
///   int *volatile k;
///   int m;
/// \endcode
/// \c varDecl(hasType(hasLocalQualifiers())) matches only \c j and \c k.
/// \c i is const-qualified but the qualifier is not local.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasLocalQualifiers">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4183,
 FQN="clang::ast_matchers::hasLocalQualifiers", NM="_ZN5clang12ast_matchers18hasLocalQualifiersEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers18hasLocalQualifiersEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<QualType> hasLocalQualifiers() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a member expression where the member is matched by a
/// given matcher.
///
/// Given
/// \code
///   struct { int first, second; } first, second;
///   int i(second.first);
///   int j(first.second);
/// \endcode
/// memberExpr(member(hasName("first")))
///   matches second.first
///   but not first.second (because the member name there is "second").
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::member">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4199,
 FQN="clang::ast_matchers::member", NM="_ZN5clang12ast_matchers6memberERKNS0_8internal7MatcherINS_9ValueDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers6memberERKNS0_8internal7MatcherINS_9ValueDeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<MemberExpr> member(final /*const*/ Matcher<ValueDecl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a member expression where the object expression is
/// matched by a given matcher.
///
/// Given
/// \code
///   struct X { int m; };
///   void f(X x) { x.m; m; }
/// \endcode
/// memberExpr(hasObjectExpression(hasType(cxxRecordDecl(hasName("X")))))))
///   matches "x.m" and "m"
/// with hasObjectExpression(...)
///   matching "x" and the implicit object expression of "m" which has type X*.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasObjectExpression">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4216,
 FQN="clang::ast_matchers::hasObjectExpression", NM="_ZN5clang12ast_matchers19hasObjectExpressionERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers19hasObjectExpressionERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<MemberExpr> hasObjectExpression(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches any using shadow declaration.
///
/// Given
/// \code
///   namespace X { void b(); }
///   using X::b;
/// \endcode
/// usingDecl(hasAnyUsingShadowDecl(hasName("b"))))
///   matches \code using X::b \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasAnyUsingShadowDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4230,
 FQN="clang::ast_matchers::hasAnyUsingShadowDecl", NM="_ZN5clang12ast_matchers21hasAnyUsingShadowDeclERKNS0_8internal7MatcherINS_15UsingShadowDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers21hasAnyUsingShadowDeclERKNS0_8internal7MatcherINS_15UsingShadowDeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<UsingDecl> hasAnyUsingShadowDecl(final /*const*/ Matcher<UsingShadowDecl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches a using shadow declaration where the target declaration is
/// matched by the given matcher.
///
/// Given
/// \code
///   namespace X { int a; void b(); }
///   using X::a;
///   using X::b;
/// \endcode
/// usingDecl(hasAnyUsingShadowDecl(hasTargetDecl(functionDecl())))
///   matches \code using X::b \endcode
///   but not \code using X::a \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasTargetDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4248,
 FQN="clang::ast_matchers::hasTargetDecl", NM="_ZN5clang12ast_matchers13hasTargetDeclERKNS0_8internal7MatcherINS_9NamedDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers13hasTargetDeclERKNS0_8internal7MatcherINS_9NamedDeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<UsingShadowDecl> hasTargetDecl(final /*const*/ Matcher<NamedDecl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches template instantiations of function, class, or static
/// member variable template instantiations.
///
/// Given
/// \code
///   template <typename T> class X {}; class A {}; X<A> x;
/// \endcode
/// or
/// \code
///   template <typename T> class X {}; class A {}; template class X<A>;
/// \endcode
/// cxxRecordDecl(hasName("::X"), isTemplateInstantiation())
///   matches the template instantiation of X<A>.
///
/// But given
/// \code
///   template <typename T>  class X {}; class A {};
///   template <> class X<A> {}; X<A> x;
/// \endcode
/// cxxRecordDecl(hasName("::X"), isTemplateInstantiation())
///   does not match, as X<A> is an explicit template specialization.
///
/// Usable as: Matcher<FunctionDecl>, Matcher<VarDecl>, Matcher<CXXRecordDecl>
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isTemplateInstantiation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4276,
 FQN="clang::ast_matchers::isTemplateInstantiation", NM="_ZN5clang12ast_matchers23isTemplateInstantiationEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers23isTemplateInstantiationEv")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam0<matcher_isTemplateInstantiationMatcher/*, void (::TypeList<FunctionDecl, VarDecl, CXXRecordDecl>)*/> isTemplateInstantiation() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches declarations that are template instantiations or are inside
/// template instantiations.
///
/// Given
/// \code
///   template<typename T> void A(T t) { T i; }
///   A(0);
///   A(0U);
/// \endcode
/// functionDecl(isInstantiated())
///   matches 'A(int) {...};' and 'A(unsigned) {...}'.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isInstantiated_getInstance">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4295,
 FQN="clang::ast_matchers::isInstantiated_getInstance", NM="_ZN5clang12ast_matchers26isInstantiated_getInstanceEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers26isInstantiated_getInstanceEv")
//</editor-fold>
public static /*inline*/ Matcher<Decl> isInstantiated_getInstance() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isInstantiated">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4295,
 FQN="clang::ast_matchers::isInstantiated", NM="_ZN5clang12ast_matchers14isInstantiatedEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers14isInstantiatedEv")
//</editor-fold>
public static /*inline*/ Matcher<Decl> isInstantiated() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches statements inside of a template instantiation.
///
/// Given
/// \code
///   int j;
///   template<typename T> void A(T t) { T i; j += 42;}
///   A(0);
///   A(0U);
/// \endcode
/// declStmt(isInTemplateInstantiation())
///   matches 'int i;' and 'unsigned i'.
/// unless(stmt(isInTemplateInstantiation()))
///   will NOT match j += 42; as it's shared between the template definition and
///   instantiation.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isInTemplateInstantiation_getInstance">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4315,
 FQN="clang::ast_matchers::isInTemplateInstantiation_getInstance", NM="_ZN5clang12ast_matchers37isInTemplateInstantiation_getInstanceEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers37isInTemplateInstantiation_getInstanceEv")
//</editor-fold>
public static /*inline*/ Matcher<Stmt> isInTemplateInstantiation_getInstance() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isInTemplateInstantiation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4315,
 FQN="clang::ast_matchers::isInTemplateInstantiation", NM="_ZN5clang12ast_matchers25isInTemplateInstantiationEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers25isInTemplateInstantiationEv")
//</editor-fold>
public static /*inline*/ Matcher<Stmt> isInTemplateInstantiation() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches explicit template specializations of function, class, or
/// static member variable template instantiations.
///
/// Given
/// \code
///   template<typename T> void A(T t) { }
///   template<> void A(int N) { }
/// \endcode
/// functionDecl(isExplicitTemplateSpecialization())
///   matches the specialization A<int>().
///
/// Usable as: Matcher<FunctionDecl>, Matcher<VarDecl>, Matcher<CXXRecordDecl>
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isExplicitTemplateSpecialization">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4333,
 FQN="clang::ast_matchers::isExplicitTemplateSpecialization", NM="_ZN5clang12ast_matchers32isExplicitTemplateSpecializationEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers32isExplicitTemplateSpecializationEv")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam0<matcher_isExplicitTemplateSpecializationMatcher/*, void (::TypeList<FunctionDecl, VarDecl, CXXRecordDecl>)*/> isExplicitTemplateSpecialization() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches \c TypeLocs for which the given inner
/// QualType-matcher matches.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::loc">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4341,
 FQN="clang::ast_matchers::loc", NM="_ZN5clang12ast_matchers3locERKNS0_8internal7MatcherINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers3locERKNS0_8internal7MatcherINS_8QualTypeEEE")
//</editor-fold>
public static /*inline*/ BindableMatcher<TypeLoc> loc_Matcher$QualType$C(final /*const*/ Matcher<QualType> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches type \c bool.
///
/// Given
/// \code
///  struct S { bool func(); };
/// \endcode
/// functionDecl(returns(booleanType()))
///   matches "bool func();"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::booleanType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4355,
 FQN="clang::ast_matchers::booleanType", NM="_ZN5clang12ast_matchers11booleanTypeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11booleanTypeEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<Type> booleanType() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches type \c void.
///
/// Given
/// \code
///  struct S { void func(); };
/// \endcode
/// functionDecl(returns(voidType()))
///   matches "void func();"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::voidType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4367,
 FQN="clang::ast_matchers::voidType", NM="_ZN5clang12ast_matchers8voidTypeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8voidTypeEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<Type> voidType() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches builtin Types.
///
/// Given
/// \code
///   struct A {};
///   A a;
///   int b;
///   float c;
///   bool d;
/// \endcode
/// builtinType()
///   matches "int b", "float c" and "bool d"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::builtinType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4383,
 FQN="clang::ast_matchers::builtinType", NM="_ZN5clang12ast_matchersL11builtinTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL11builtinTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, BuiltinType> builtinType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, BuiltinType>();

/// \brief Matches all kinds of arrays.
///
/// Given
/// \code
///   int a[] = { 2, 3 };
///   int b[4];
///   void f() { int c[a[0]]; }
/// \endcode
/// arrayType()
///   matches "int a[]", "int b[4]" and "int c[a[0]]";
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::arrayType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4395,
 FQN="clang::ast_matchers::arrayType", NM="_ZN5clang12ast_matchersL9arrayTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL9arrayTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, ArrayType> arrayType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, ArrayType>();

/// \brief Matches C99 complex types.
///
/// Given
/// \code
///   _Complex float f;
/// \endcode
/// complexType()
///   matches "_Complex float f"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::complexType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4405,
 FQN="clang::ast_matchers::complexType", NM="_ZN5clang12ast_matchersL11complexTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL11complexTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, ComplexType> complexType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, ComplexType>();

/// \brief Matches any real floating-point type (float, double, long double).
///
/// Given
/// \code
///   int i;
///   float f;
/// \endcode
/// realFloatingPointType()
///   matches "float f" but not "int i"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::realFloatingPointType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4416,
 FQN="clang::ast_matchers::realFloatingPointType", NM="_ZN5clang12ast_matchers21realFloatingPointTypeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers21realFloatingPointTypeEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<Type> realFloatingPointType() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches arrays and C99 complex types that have a specific element
/// type.
///
/// Given
/// \code
///   struct A {};
///   A a[7];
///   int b[7];
/// \endcode
/// arrayType(hasElementType(builtinType()))
///   matches "int b[7]"
///
/// Usable as: Matcher<ArrayType>, Matcher<ComplexType>
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasElementTypeLoc">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4433,
 FQN="clang::ast_matchers::hasElementTypeLoc", NM="_ZN5clang12ast_matchersL17hasElementTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL17hasElementTypeLocE")
//</editor-fold>
public static /*const*/ /*::*/TypeTraversePolymorphicMatcher.Func<TypeLoc, TypeLocMatcherhasElementTypeGetter, TypeLocTraverseMatcher, TypeList/*void (::TypeList<ArrayType, ComplexType>)*/> hasElementTypeLoc/*J*/= new /*::*/TypeTraversePolymorphicMatcher.Func();
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasElementType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4433,
 FQN="clang::ast_matchers::hasElementType", NM="_ZN5clang12ast_matchersL14hasElementTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL14hasElementTypeE")
//</editor-fold>
public static /*const*/ /*::*/TypeTraversePolymorphicMatcher.Func<QualType, TypeMatcherhasElementTypeGetter, TypeTraverseMatcher, TypeList/*void (::TypeList<ArrayType, ComplexType>)*/> hasElementType/*J*/= new /*::*/TypeTraversePolymorphicMatcher.Func();

/// \brief Matches C arrays with a specified constant size.
///
/// Given
/// \code
///   void() {
///     int a[2];
///     int b[] = { 2, 3 };
///     int c[b[0]];
///   }
/// \endcode
/// constantArrayType()
///   matches "int a[2]"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::constantArrayType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4449,
 FQN="clang::ast_matchers::constantArrayType", NM="_ZN5clang12ast_matchersL17constantArrayTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL17constantArrayTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, ConstantArrayType> constantArrayType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, ConstantArrayType>();

/// \brief Matches nodes that have the specified size.
///
/// Given
/// \code
///   int a[42];
///   int b[2 * 21];
///   int c[41], d[43];
///   char *s = "abcd";
///   wchar_t *ws = L"abcd";
///   char *w = "a";
/// \endcode
/// constantArrayType(hasSize(42))
///   matches "int a[42]" and "int b[2 * 21]"
/// stringLiteral(hasSize(4))
///   matches "abcd", L"abcd"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasSize">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4466,
 FQN="clang::ast_matchers::hasSize", NM="_ZN5clang12ast_matchers7hasSizeERKj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers7hasSizeERKj")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam1<matcher_hasSize0Matcher, /*uint*/Integer/*, void (::TypeList<ConstantArrayType, StringLiteral>)*/> hasSize(final /*const*/uint$ref/*uint &*/ N) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches C++ arrays whose size is a value-dependent expression.
///
/// Given
/// \code
///   template<typename T, int Size>
///   class array {
///     T data[Size];
///   };
/// \endcode
/// dependentSizedArrayType
///   matches "T data[Size]"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dependentSizedArrayType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4484,
 FQN="clang::ast_matchers::dependentSizedArrayType", NM="_ZN5clang12ast_matchersL23dependentSizedArrayTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL23dependentSizedArrayTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, DependentSizedArrayType> dependentSizedArrayType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, DependentSizedArrayType>();

/// \brief Matches C arrays with unspecified size.
///
/// Given
/// \code
///   int a[] = { 2, 3 };
///   int b[42];
///   void f(int c[]) { int d[a[0]]; };
/// \endcode
/// incompleteArrayType()
///   matches "int a[]" and "int c[]"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::incompleteArrayType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4496,
 FQN="clang::ast_matchers::incompleteArrayType", NM="_ZN5clang12ast_matchersL19incompleteArrayTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL19incompleteArrayTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, IncompleteArrayType> incompleteArrayType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, IncompleteArrayType>();

/// \brief Matches C arrays with a specified size that is not an
/// integer-constant-expression.
///
/// Given
/// \code
///   void f() {
///     int a[] = { 2, 3 }
///     int b[42];
///     int c[a[0]];
///   }
/// \endcode
/// variableArrayType()
///   matches "int c[a[0]]"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::variableArrayType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4511,
 FQN="clang::ast_matchers::variableArrayType", NM="_ZN5clang12ast_matchersL17variableArrayTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL17variableArrayTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, VariableArrayType> variableArrayType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, VariableArrayType>();

/// \brief Matches \c VariableArrayType nodes that have a specific size
/// expression.
///
/// Given
/// \code
///   void f(int b) {
///     int a[b];
///   }
/// \endcode
/// variableArrayType(hasSizeExpr(ignoringImpCasts(declRefExpr(to(
///   varDecl(hasName("b")))))))
///   matches "int a[b]"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasSizeExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4525,
 FQN="clang::ast_matchers::hasSizeExpr", NM="_ZN5clang12ast_matchers11hasSizeExprERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11hasSizeExprERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<VariableArrayType> hasSizeExpr(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches atomic types.
///
/// Given
/// \code
///   _Atomic(int) i;
/// \endcode
/// atomicType()
///   matches "_Atomic(int) i"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::atomicType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4538,
 FQN="clang::ast_matchers::atomicType", NM="_ZN5clang12ast_matchersL10atomicTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL10atomicTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, AtomicType> atomicType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, AtomicType>();

/// \brief Matches atomic types with a specific value type.
///
/// Given
/// \code
///   _Atomic(int) i;
///   _Atomic(float) f;
/// \endcode
/// atomicType(hasValueType(isInteger()))
///  matches "_Atomic(int) i"
///
/// Usable as: Matcher<AtomicType>
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasValueTypeLoc">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4551,
 FQN="clang::ast_matchers::hasValueTypeLoc", NM="_ZN5clang12ast_matchersL15hasValueTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL15hasValueTypeLocE")
//</editor-fold>
public static /*const*/ /*::*/TypeTraversePolymorphicMatcher.Func<TypeLoc, TypeLocMatcherhasValueTypeGetter, TypeLocTraverseMatcher, TypeList/*void (::TypeList<AtomicType>)*/> hasValueTypeLoc/*J*/= new /*::*/TypeTraversePolymorphicMatcher.Func();
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasValueType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4551,
 FQN="clang::ast_matchers::hasValueType", NM="_ZN5clang12ast_matchersL12hasValueTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL12hasValueTypeE")
//</editor-fold>
public static /*const*/ /*::*/TypeTraversePolymorphicMatcher.Func<QualType, TypeMatcherhasValueTypeGetter, TypeTraverseMatcher, TypeList/*void (::TypeList<AtomicType>)*/> hasValueType/*J*/= new /*::*/TypeTraversePolymorphicMatcher.Func();

/// \brief Matches types nodes representing C++11 auto types.
///
/// Given:
/// \code
///   auto n = 4;
///   int v[] = { 2, 3 }
///   for (auto i : v) { }
/// \endcode
/// autoType()
///   matches "auto n" and "auto i"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::autoType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4564,
 FQN="clang::ast_matchers::autoType", NM="_ZN5clang12ast_matchersL8autoTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL8autoTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, AutoType> autoType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, AutoType>();

/// \brief Matches \c AutoType nodes where the deduced type is a specific type.
///
/// Note: There is no \c TypeLoc for the deduced type and thus no
/// \c getDeducedLoc() matcher.
///
/// Given
/// \code
///   auto a = 1;
///   auto b = 2.0;
/// \endcode
/// autoType(hasDeducedType(isInteger()))
///   matches "auto a"
///
/// Usable as: Matcher<AutoType>
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasDeducedType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4580,
 FQN="clang::ast_matchers::hasDeducedType", NM="_ZN5clang12ast_matchersL14hasDeducedTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL14hasDeducedTypeE")
//</editor-fold>
public static /*const*/ /*::*/TypeTraversePolymorphicMatcher.Func<QualType, TypeMatcherhasDeducedTypeGetter, TypeTraverseMatcher, TypeList/*void (::TypeList<AutoType>)*/> hasDeducedType/*J*/= new /*::*/TypeTraversePolymorphicMatcher.Func();

/// \brief Matches \c FunctionType nodes.
///
/// Given
/// \code
///   int (*f)(int);
///   void g();
/// \endcode
/// functionType()
///   matches "int (*f)(int)" and the type of "g".
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::functionType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4592,
 FQN="clang::ast_matchers::functionType", NM="_ZN5clang12ast_matchersL12functionTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL12functionTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, FunctionType> functionType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, FunctionType>();

/// \brief Matches \c FunctionProtoType nodes.
///
/// Given
/// \code
///   int (*f)(int);
///   void g();
/// \endcode
/// functionProtoType()
///   matches "int (*f)(int)" and the type of "g" in C++ mode.
///   In C mode, "g" is not matched because it does not contain a prototype.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::functionProtoType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4604,
 FQN="clang::ast_matchers::functionProtoType", NM="_ZN5clang12ast_matchersL17functionProtoTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL17functionProtoTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, FunctionProtoType> functionProtoType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, FunctionProtoType>();

/// \brief Matches \c ParenType nodes.
///
/// Given
/// \code
///   int (*ptr_to_array)[4];
///   int *array_of_ptrs[4];
/// \endcode
///
/// \c varDecl(hasType(pointsTo(parenType()))) matches \c ptr_to_array but not
/// \c array_of_ptrs.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::parenType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4616,
 FQN="clang::ast_matchers::parenType", NM="_ZN5clang12ast_matchersL9parenTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL9parenTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, ParenType> parenType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, ParenType>();

/// \brief Matches \c ParenType nodes where the inner type is a specific type.
///
/// Given
/// \code
///   int (*ptr_to_array)[4];
///   int (*ptr_to_func)(int);
/// \endcode
///
/// \c varDecl(hasType(pointsTo(parenType(innerType(functionType()))))) matches
/// \c ptr_to_func but not \c ptr_to_array.
///
/// Usable as: Matcher<ParenType>
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::innerType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4630,
 FQN="clang::ast_matchers::innerType", NM="_ZN5clang12ast_matchersL9innerTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL9innerTypeE")
//</editor-fold>
public static /*const*/ /*::*/TypeTraversePolymorphicMatcher.Func<QualType, TypeMatcherinnerTypeGetter, TypeTraverseMatcher, TypeList/*void (::TypeList<ParenType>)*/> innerType/*J*/= new /*::*/TypeTraversePolymorphicMatcher.Func();

/// \brief Matches block pointer types, i.e. types syntactically represented as
/// "void (^)(int)".
///
/// The \c pointee is always required to be a \c FunctionType.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::blockPointerType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4637,
 FQN="clang::ast_matchers::blockPointerType", NM="_ZN5clang12ast_matchersL16blockPointerTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL16blockPointerTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, BlockPointerType> blockPointerType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, BlockPointerType>();

/// \brief Matches member pointer types.
/// Given
/// \code
///   struct A { int i; }
///   A::* ptr = A::i;
/// \endcode
/// memberPointerType()
///   matches "A::* ptr"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::memberPointerType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4647,
 FQN="clang::ast_matchers::memberPointerType", NM="_ZN5clang12ast_matchersL17memberPointerTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL17memberPointerTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, MemberPointerType> memberPointerType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, MemberPointerType>();

/// \brief Matches pointer types, but does not match Objective-C object pointer
/// types.
///
/// Given
/// \code
///   int *a;
///   int &b = *a;
///   int c = 5;
///
///   @interface Foo
///   @end
///   Foo *f;
/// \endcode
/// pointerType()
///   matches "int *a", but does not match "Foo *f".
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::pointerType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4664,
 FQN="clang::ast_matchers::pointerType", NM="_ZN5clang12ast_matchersL11pointerTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL11pointerTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, PointerType> pointerType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, PointerType>();

/// \brief Matches an Objective-C object pointer type, which is different from
/// a pointer type, despite being syntactically similar.
///
/// Given
/// \code
///   int *a;
///
///   @interface Foo
///   @end
///   Foo *f;
/// \endcode
/// pointerType()
///   matches "Foo *f", but does not match "int *a".
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::objcObjectPointerType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4679,
 FQN="clang::ast_matchers::objcObjectPointerType", NM="_ZN5clang12ast_matchersL21objcObjectPointerTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL21objcObjectPointerTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, ObjCObjectPointerType> objcObjectPointerType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, ObjCObjectPointerType>();

/// \brief Matches both lvalue and rvalue reference types.
///
/// Given
/// \code
///   int *a;
///   int &b = *a;
///   int &&c = 1;
///   auto &d = b;
///   auto &&e = c;
///   auto &&f = 2;
///   int g = 5;
/// \endcode
///
/// \c referenceType() matches the types of \c b, \c c, \c d, \c e, and \c f.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::referenceType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4695,
 FQN="clang::ast_matchers::referenceType", NM="_ZN5clang12ast_matchersL13referenceTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL13referenceTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, ReferenceType> referenceType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, ReferenceType>();

/// \brief Matches lvalue reference types.
///
/// Given:
/// \code
///   int *a;
///   int &b = *a;
///   int &&c = 1;
///   auto &d = b;
///   auto &&e = c;
///   auto &&f = 2;
///   int g = 5;
/// \endcode
///
/// \c lValueReferenceType() matches the types of \c b, \c d, and \c e. \c e is
/// matched since the type is deduced as int& by reference collapsing rules.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::lValueReferenceType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4712,
 FQN="clang::ast_matchers::lValueReferenceType", NM="_ZN5clang12ast_matchersL19lValueReferenceTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL19lValueReferenceTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, LValueReferenceType> lValueReferenceType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, LValueReferenceType>();

/// \brief Matches rvalue reference types.
///
/// Given:
/// \code
///   int *a;
///   int &b = *a;
///   int &&c = 1;
///   auto &d = b;
///   auto &&e = c;
///   auto &&f = 2;
///   int g = 5;
/// \endcode
///
/// \c rValueReferenceType() matches the types of \c c and \c f. \c e is not
/// matched as it is deduced to int& by reference collapsing rules.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::rValueReferenceType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4729,
 FQN="clang::ast_matchers::rValueReferenceType", NM="_ZN5clang12ast_matchersL19rValueReferenceTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL19rValueReferenceTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, RValueReferenceType> rValueReferenceType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, RValueReferenceType>();

/// \brief Narrows PointerType (and similar) matchers to those where the
/// \c pointee matches a given matcher.
///
/// Given
/// \code
///   int *a;
///   int const *b;
///   float const *f;
/// \endcode
/// pointerType(pointee(isConstQualified(), isInteger()))
///   matches "int const *b"
///
/// Usable as: Matcher<BlockPointerType>, Matcher<MemberPointerType>,
///   Matcher<PointerType>, Matcher<ReferenceType>
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::pointeeLoc">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4745,
 FQN="clang::ast_matchers::pointeeLoc", NM="_ZN5clang12ast_matchersL10pointeeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL10pointeeLocE")
//</editor-fold>
public static /*const*/ /*::*/TypeTraversePolymorphicMatcher.Func<TypeLoc, TypeLocMatcherpointeeGetter, TypeLocTraverseMatcher, TypeList/*void (::TypeList<BlockPointerType, MemberPointerType, PointerType, ReferenceType>)*/> pointeeLoc/*J*/= new /*::*/TypeTraversePolymorphicMatcher.Func();
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::pointee">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4745,
 FQN="clang::ast_matchers::pointee", NM="_ZN5clang12ast_matchersL7pointeeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL7pointeeE")
//</editor-fold>
public static /*const*/ /*::*/TypeTraversePolymorphicMatcher.Func<QualType, TypeMatcherpointeeGetter, TypeTraverseMatcher, TypeList/*void (::TypeList<BlockPointerType, MemberPointerType, PointerType, ReferenceType>)*/> pointee/*J*/= new /*::*/TypeTraversePolymorphicMatcher.Func();

/// \brief Matches typedef types.
///
/// Given
/// \code
///   typedef int X;
/// \endcode
/// typedefType()
///   matches "typedef int X"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::typedefType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4759,
 FQN="clang::ast_matchers::typedefType", NM="_ZN5clang12ast_matchersL11typedefTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL11typedefTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, TypedefType> typedefType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, TypedefType>();

/// \brief Matches enum types.
///
/// Given
/// \code
///   enum C { Green };
///   enum class S { Red };
///
///   C c;
///   S s;
/// \endcode
//
/// \c enumType() matches the type of the variable declarations of both \c c and
/// \c s.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::enumType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4774,
 FQN="clang::ast_matchers::enumType", NM="_ZN5clang12ast_matchersL8enumTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL8enumTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, EnumType> enumType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, EnumType>();

/// \brief Matches template specialization types.
///
/// Given
/// \code
///   template <typename T>
///   class C { };
///
///   template class C<int>;  // A
///   C<char> var;            // B
/// \endcode
///
/// \c templateSpecializationType() matches the type of the explicit
/// instantiation in \c A and the type of the variable declaration in \c B.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::templateSpecializationType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4789,
 FQN="clang::ast_matchers::templateSpecializationType", NM="_ZN5clang12ast_matchersL26templateSpecializationTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL26templateSpecializationTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, TemplateSpecializationType> templateSpecializationType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, TemplateSpecializationType>();

/// \brief Matches types nodes representing unary type transformations.
///
/// Given:
/// \code
///   typedef __underlying_type(T) type;
/// \endcode
/// unaryTransformType()
///   matches "__underlying_type(T)"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::unaryTransformType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4799,
 FQN="clang::ast_matchers::unaryTransformType", NM="_ZN5clang12ast_matchersL18unaryTransformTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL18unaryTransformTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, UnaryTransformType> unaryTransformType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, UnaryTransformType>();

/// \brief Matches record types (e.g. structs, classes).
///
/// Given
/// \code
///   class C {};
///   struct S {};
///
///   C c;
///   S s;
/// \endcode
///
/// \c recordType() matches the type of the variable declarations of both \c c
/// and \c s.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::recordType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4814,
 FQN="clang::ast_matchers::recordType", NM="_ZN5clang12ast_matchersL10recordTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL10recordTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, RecordType> recordType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, RecordType>();

/// \brief Matches types specified with an elaborated type keyword or with a
/// qualified name.
///
/// Given
/// \code
///   namespace N {
///     namespace M {
///       class D {};
///     }
///   }
///   class C {};
///
///   class C c;
///   N::M::D d;
/// \endcode
///
/// \c elaboratedType() matches the type of the variable declarations of both
/// \c c and \c d.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::elaboratedType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4834,
 FQN="clang::ast_matchers::elaboratedType", NM="_ZN5clang12ast_matchersL14elaboratedTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL14elaboratedTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, ElaboratedType> elaboratedType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, ElaboratedType>();

/// \brief Matches ElaboratedTypes whose qualifier, a NestedNameSpecifier,
/// matches \c InnerMatcher if the qualifier exists.
///
/// Given
/// \code
///   namespace N {
///     namespace M {
///       class D {};
///     }
///   }
///   N::M::D d;
/// \endcode
///
/// \c elaboratedType(hasQualifier(hasPrefix(specifiesNamespace(hasName("N"))))
/// matches the type of the variable declaration of \c d.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasQualifier">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4851,
 FQN="clang::ast_matchers::hasQualifier", NM="_ZN5clang12ast_matchers12hasQualifierERKNS0_8internal7MatcherINS_19NestedNameSpecifierEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers12hasQualifierERKNS0_8internal7MatcherINS_19NestedNameSpecifierEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<ElaboratedType> hasQualifier(final /*const*/ Matcher<NestedNameSpecifier> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches ElaboratedTypes whose named type matches \c InnerMatcher.
///
/// Given
/// \code
///   namespace N {
///     namespace M {
///       class D {};
///     }
///   }
///   N::M::D d;
/// \endcode
///
/// \c elaboratedType(namesType(recordType(
/// hasDeclaration(namedDecl(hasName("D")))))) matches the type of the variable
/// declaration of \c d.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::namesType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4874,
 FQN="clang::ast_matchers::namesType", NM="_ZN5clang12ast_matchers9namesTypeERKNS0_8internal7MatcherINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers9namesTypeERKNS0_8internal7MatcherINS_8QualTypeEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<ElaboratedType> namesType(final /*const*/ Matcher<QualType> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches types that represent the result of substituting a type for a
/// template type parameter.
///
/// Given
/// \code
///   template <typename T>
///   void F(T t) {
///     int i = 1 + t;
///   }
/// \endcode
///
/// \c substTemplateTypeParmType() matches the type of 't' but not '1'
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::substTemplateTypeParmType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4891,
 FQN="clang::ast_matchers::substTemplateTypeParmType", NM="_ZN5clang12ast_matchersL25substTemplateTypeParmTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL25substTemplateTypeParmTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, SubstTemplateTypeParmType> substTemplateTypeParmType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, SubstTemplateTypeParmType>();

/// \brief Matches template type parameter types.
///
/// Example matches T, but not int.
///     (matcher = templateTypeParmType())
/// \code
///   template <typename T> void f(int i);
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::templateTypeParmType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4900,
 FQN="clang::ast_matchers::templateTypeParmType", NM="_ZN5clang12ast_matchersL20templateTypeParmTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL20templateTypeParmTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, TemplateTypeParmType> templateTypeParmType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, TemplateTypeParmType>();

/// \brief Matches injected class name types.
///
/// Example matches S s, but not S<T> s.
///     (matcher = parmVarDecl(hasType(injectedClassNameType())))
/// \code
///   template <typename T> struct S {
///     void f(S s);
///     void g(S<T> s);
///   };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::injectedClassNameType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4912,
 FQN="clang::ast_matchers::injectedClassNameType", NM="_ZN5clang12ast_matchersL21injectedClassNameTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL21injectedClassNameTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, InjectedClassNameType> injectedClassNameType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, InjectedClassNameType>();

/// \brief Matches decayed type
/// Example matches i[] in declaration of f.
///     (matcher = valueDecl(hasType(decayedType(hasDecayedType(pointerType())))))
/// Example matches i[1].
///     (matcher = expr(hasType(decayedType(hasDecayedType(pointerType())))))
/// \code
///   void f(int i[]) {
///     i[1] = 0;
///   }
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::decayedType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4924,
 FQN="clang::ast_matchers::decayedType", NM="_ZN5clang12ast_matchersL11decayedTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL11decayedTypeE")
//</editor-fold>
public static /*const*/ /*::*/VariadicDynCastAllOfMatcher<Type, DecayedType> decayedType/*J*/= new /*::*/VariadicDynCastAllOfMatcher<Type, DecayedType>();

/// \brief Matches the decayed type, whos decayed type matches \c InnerMatcher
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasDecayedType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4927,
 FQN="clang::ast_matchers::hasDecayedType", NM="_ZN5clang12ast_matchers14hasDecayedTypeERKNS0_8internal7MatcherINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers14hasDecayedTypeERKNS0_8internal7MatcherINS_8QualTypeEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<DecayedType> hasDecayedType(final /*const*/ Matcher<QualType> /*&*/ InnerType) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches declarations whose declaration context, interpreted as a
/// Decl, matches \c InnerMatcher.
///
/// Given
/// \code
///   namespace N {
///     namespace M {
///       class D {};
///     }
///   }
/// \endcode
///
/// \c cxxRcordDecl(hasDeclContext(namedDecl(hasName("M")))) matches the
/// declaration of \c class \c D.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasDeclContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4946,
 FQN="clang::ast_matchers::hasDeclContext", NM="_ZN5clang12ast_matchers14hasDeclContextERKNS0_8internal7MatcherINS_4DeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers14hasDeclContextERKNS0_8internal7MatcherINS_4DeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<Decl> hasDeclContext(final /*const*/ Matcher<Decl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches nested name specifiers.
///
/// Given
/// \code
///   namespace ns {
///     struct A { static void f(); };
///     void A::f() {}
///     void g() { A::f(); }
///   }
///   ns::A a;
/// \endcode
/// nestedNameSpecifier()
///   matches "ns::" and both "A::"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::nestedNameSpecifier">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4965,
 FQN="clang::ast_matchers::nestedNameSpecifier", NM="_ZN5clang12ast_matchersL19nestedNameSpecifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL19nestedNameSpecifierE")
//</editor-fold>
public static /*const*/ VariadicAllOfMatcher<NestedNameSpecifier> nestedNameSpecifier/*J*/= new VariadicAllOfMatcher<NestedNameSpecifier>();

/// \brief Same as \c nestedNameSpecifier but matches \c NestedNameSpecifierLoc.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::nestedNameSpecifierLoc">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4968,
 FQN="clang::ast_matchers::nestedNameSpecifierLoc", NM="_ZN5clang12ast_matchersL22nestedNameSpecifierLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL22nestedNameSpecifierLocE")
//</editor-fold>
public static /*const*/ VariadicAllOfMatcher<NestedNameSpecifierLoc> nestedNameSpecifierLoc/*J*/= new VariadicAllOfMatcher<NestedNameSpecifierLoc>();

/// \brief Matches \c NestedNameSpecifierLocs for which the given inner
/// NestedNameSpecifier-matcher matches.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::loc">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4973,
 FQN="clang::ast_matchers::loc", NM="_ZN5clang12ast_matchers3locERKNS0_8internal7MatcherINS_19NestedNameSpecifierEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers3locERKNS0_8internal7MatcherINS_19NestedNameSpecifierEEE")
//</editor-fold>
public static /*inline*/ BindableMatcher<NestedNameSpecifierLoc> loc_Matcher$NestedNameSpecifier$C(final /*const*/ Matcher<NestedNameSpecifier> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches nested name specifiers that specify a type matching the
/// given \c QualType matcher without qualifiers.
///
/// Given
/// \code
///   struct A { struct B { struct C {}; }; };
///   A::B::C c;
/// \endcode
/// nestedNameSpecifier(specifiesType(
///   hasDeclaration(cxxRecordDecl(hasName("A")))
/// ))
///   matches "A::"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::specifiesType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 4993,
 FQN="clang::ast_matchers::specifiesType", NM="_ZN5clang12ast_matchers13specifiesTypeERKNS0_8internal7MatcherINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers13specifiesTypeERKNS0_8internal7MatcherINS_8QualTypeEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<NestedNameSpecifier> specifiesType(final /*const*/ Matcher<QualType> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches nested name specifier locs that specify a type matching the
/// given \c TypeLoc.
///
/// Given
/// \code
///   struct A { struct B { struct C {}; }; };
///   A::B::C c;
/// \endcode
/// nestedNameSpecifierLoc(specifiesTypeLoc(loc(type(
///   hasDeclaration(cxxRecordDecl(hasName("A")))))))
///   matches "A::"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::specifiesTypeLoc">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5011,
 FQN="clang::ast_matchers::specifiesTypeLoc", NM="_ZN5clang12ast_matchers16specifiesTypeLocERKNS0_8internal7MatcherINS_7TypeLocEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers16specifiesTypeLocERKNS0_8internal7MatcherINS_7TypeLocEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<NestedNameSpecifierLoc> specifiesTypeLoc(final /*const*/ Matcher<TypeLoc> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches on the prefix of a \c NestedNameSpecifier.
///
/// Given
/// \code
///   struct A { struct B { struct C {}; }; };
///   A::B::C c;
/// \endcode
/// nestedNameSpecifier(hasPrefix(specifiesType(asString("struct A")))) and
///   matches "A::"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasPrefix">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5025,
 FQN="clang::ast_matchers::hasPrefix", NM="_ZN5clang12ast_matchers9hasPrefixERKNS0_8internal7MatcherINS_19NestedNameSpecifierEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers9hasPrefixERKNS0_8internal7MatcherINS_19NestedNameSpecifierEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<NestedNameSpecifier> hasPrefix_Matcher$NestedNameSpecifier$C(final /*const*/ Matcher<NestedNameSpecifier> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches on the prefix of a \c NestedNameSpecifierLoc.
///
/// Given
/// \code
///   struct A { struct B { struct C {}; }; };
///   A::B::C c;
/// \endcode
/// nestedNameSpecifierLoc(hasPrefix(loc(specifiesType(asString("struct A")))))
///   matches "A::"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasPrefix">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5043,
 FQN="clang::ast_matchers::hasPrefix", NM="_ZN5clang12ast_matchers9hasPrefixERKNS0_8internal7MatcherINS_22NestedNameSpecifierLocEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers9hasPrefixERKNS0_8internal7MatcherINS_22NestedNameSpecifierLocEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<NestedNameSpecifierLoc> hasPrefix_Matcher$NestedNameSpecifierLoc$C(final /*const*/ Matcher<NestedNameSpecifierLoc> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches nested name specifiers that specify a namespace matching the
/// given namespace matcher.
///
/// Given
/// \code
///   namespace ns { struct A {}; }
///   ns::A a;
/// \endcode
/// nestedNameSpecifier(specifiesNamespace(hasName("ns")))
///   matches "ns::"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::specifiesNamespace">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5062,
 FQN="clang::ast_matchers::specifiesNamespace", NM="_ZN5clang12ast_matchers18specifiesNamespaceERKNS0_8internal7MatcherINS_13NamespaceDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers18specifiesNamespaceERKNS0_8internal7MatcherINS_13NamespaceDeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<NestedNameSpecifier> specifiesNamespace(final /*const*/ Matcher<NamespaceDecl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Overloads for the \c equalsNode matcher.
/// FIXME: Implement for other node types.
/// @{

/// \brief Matches if a node equals another node.
///
/// \c Decl has pointer identity in the AST.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::equalsNode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5076,
 FQN="clang::ast_matchers::equalsNode", NM="_ZN5clang12ast_matchers10equalsNodeERKPKNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers10equalsNodeERKPKNS_4DeclE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<Decl> equalsNode(final /*const*/ Decl /*P*/ /*const*/ /*&*/ Other) {
  throw new UnsupportedOperationException("EmptyBody");
}

/// \brief Matches if a node equals another node.
///
/// \c Stmt has pointer identity in the AST.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::equalsNode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5082,
 FQN="clang::ast_matchers::equalsNode", NM="_ZN5clang12ast_matchers10equalsNodeERKPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers10equalsNodeERKPKNS_4StmtE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<Stmt> equalsNode(final /*const*/ Stmt /*P*/ /*const*/ /*&*/ Other) {
  throw new UnsupportedOperationException("EmptyBody");
}

/// \brief Matches if a node equals another node.
///
/// \c Type has pointer identity in the AST.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::equalsNode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5088,
 FQN="clang::ast_matchers::equalsNode", NM="_ZN5clang12ast_matchers10equalsNodeERKPKNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers10equalsNodeERKPKNS_4TypeE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<Type> equalsNode(final /*const*/ Type /*P*/ /*const*/ /*&*/ Other) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// @}

/// \brief Matches each case or default statement belonging to the given switch
/// statement. This matcher may produce multiple matches.
///
/// Given
/// \code
///   switch (1) { case 1: case 2: default: switch (2) { case 3: case 4: ; } }
/// \endcode
/// switchStmt(forEachSwitchCase(caseStmt().bind("c"))).bind("s")
///   matches four times, with "c" binding each of "case 1:", "case 2:",
/// "case 3:" and "case 4:", and "s" respectively binding "switch (1)",
/// "switch (1)", "switch (2)" and "switch (2)".
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::forEachSwitchCase">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5105,
 FQN="clang::ast_matchers::forEachSwitchCase", NM="_ZN5clang12ast_matchers17forEachSwitchCaseERKNS0_8internal7MatcherINS_10SwitchCaseEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers17forEachSwitchCaseERKNS0_8internal7MatcherINS_10SwitchCaseEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<SwitchStmt> forEachSwitchCase(final /*const*/ Matcher<SwitchCase> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches each constructor initializer in a constructor definition.
///
/// Given
/// \code
///   class A { A() : i(42), j(42) {} int i; int j; };
/// \endcode
/// cxxConstructorDecl(forEachConstructorInitializer(
///   forField(decl().bind("x"))
/// ))
///   will trigger two matches, binding for 'i' and 'j' respectively.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::forEachConstructorInitializer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5136,
 FQN="clang::ast_matchers::forEachConstructorInitializer", NM="_ZN5clang12ast_matchers29forEachConstructorInitializerERKNS0_8internal7MatcherINS_18CXXCtorInitializerEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers29forEachConstructorInitializerERKNS0_8internal7MatcherINS_18CXXCtorInitializerEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXConstructorDecl> forEachConstructorInitializer(final /*const*/ Matcher<CXXCtorInitializer> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches constructor declarations that are copy constructors.
///
/// Given
/// \code
///   struct S {
///     S(); // #1
///     S(const S &); // #2
///     S(S &&); // #3
///   };
/// \endcode
/// cxxConstructorDecl(isCopyConstructor()) will match #2, but not #1 or #3.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isCopyConstructor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5162,
 FQN="clang::ast_matchers::isCopyConstructor", NM="_ZN5clang12ast_matchers17isCopyConstructorEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers17isCopyConstructorEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXConstructorDecl> isCopyConstructor() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches constructor declarations that are move constructors.
///
/// Given
/// \code
///   struct S {
///     S(); // #1
///     S(const S &); // #2
///     S(S &&); // #3
///   };
/// \endcode
/// cxxConstructorDecl(isMoveConstructor()) will match #3, but not #1 or #2.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isMoveConstructor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5177,
 FQN="clang::ast_matchers::isMoveConstructor", NM="_ZN5clang12ast_matchers17isMoveConstructorEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers17isMoveConstructorEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXConstructorDecl> isMoveConstructor() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches constructor declarations that are default constructors.
///
/// Given
/// \code
///   struct S {
///     S(); // #1
///     S(const S &); // #2
///     S(S &&); // #3
///   };
/// \endcode
/// cxxConstructorDecl(isDefaultConstructor()) will match #1, but not #2 or #3.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isDefaultConstructor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5192,
 FQN="clang::ast_matchers::isDefaultConstructor", NM="_ZN5clang12ast_matchers20isDefaultConstructorEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers20isDefaultConstructorEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXConstructorDecl> isDefaultConstructor() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches constructors that delegate to another constructor.
///
/// Given
/// \code
///   struct S {
///     S(); // #1
///     S(int) {} // #2
///     S(S &&) : S() {} // #3
///   };
///   S::S() : S(0) {} // #4
/// \endcode
/// cxxConstructorDecl(isDelegatingConstructor()) will match #3 and #4, but not
/// #1 or #2.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isDelegatingConstructor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5209,
 FQN="clang::ast_matchers::isDelegatingConstructor", NM="_ZN5clang12ast_matchers23isDelegatingConstructorEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers23isDelegatingConstructorEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CXXConstructorDecl> isDelegatingConstructor() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches constructor and conversion declarations that are marked with
/// the explicit keyword.
///
/// Given
/// \code
///   struct S {
///     S(int); // #1
///     explicit S(double); // #2
///     operator int(); // #3
///     explicit operator bool(); // #4
///   };
/// \endcode
/// cxxConstructorDecl(isExplicit()) will match #2, but not #1.
/// cxxConversionDecl(isExplicit()) will match #4, but not #3.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isExplicit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5227,
 FQN="clang::ast_matchers::isExplicit", NM="_ZN5clang12ast_matchers10isExplicitEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers10isExplicitEv")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam0<matcher_isExplicitMatcher/*, void (::TypeList<CXXConstructorDecl, CXXConversionDecl>)*/> isExplicit() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches function and namespace declarations that are marked with
/// the inline keyword.
///
/// Given
/// \code
///   inline void f();
///   void g();
///   namespace n {
///   inline namespace m {}
///   }
/// \endcode
/// functionDecl(isInline()) will match ::f().
/// namespaceDecl(isInline()) will match n::m.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isInline">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5246,
 FQN="clang::ast_matchers::isInline", NM="_ZN5clang12ast_matchers8isInlineEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8isInlineEv")
//</editor-fold>
public static /*inline*/ /*::*/PolymorphicMatcherWithParam0<matcher_isInlineMatcher/*, void (::TypeList<NamespaceDecl, FunctionDecl>)*/> isInline() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches anonymous namespace declarations.
///
/// Given
/// \code
///   namespace n {
///   namespace {} // #1
///   }
/// \endcode
/// namespaceDecl(isAnonymous()) will match #1 but not ::n.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::isAnonymous">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5267,
 FQN="clang::ast_matchers::isAnonymous", NM="_ZN5clang12ast_matchers11isAnonymousEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11isAnonymousEv")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<NamespaceDecl> isAnonymous() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief If the given case statement does not use the GNU case range
/// extension, matches the constant given in the statement.
///
/// Given
/// \code
///   switch (1) { case 1: case 1+1: case 3 ... 4: ; }
/// \endcode
/// caseStmt(hasCaseConstant(integerLiteral()))
///   matches "case 1:"
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasCaseConstant">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5280,
 FQN="clang::ast_matchers::hasCaseConstant", NM="_ZN5clang12ast_matchers15hasCaseConstantERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers15hasCaseConstantERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<CaseStmt> hasCaseConstant(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches declaration that has a given attribute.
///
/// Given
/// \code
///   __attribute__((device)) void f() { ... }
/// \endcode
/// decl(hasAttr(clang::attr::CUDADevice)) matches the function declaration of
/// f. If the matcher is use from clang-query, attr::Kind parameter should be
/// passed as a quoted string. e.g., hasAttr("attr::CUDADevice").
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasAttr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5297,
 FQN="clang::ast_matchers::hasAttr", NM="_ZN5clang12ast_matchers7hasAttrERKNS_4attr4KindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers7hasAttrERKNS_4attr4KindE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<Decl> hasAttr(final /*const*/ attr.Kind /*&*/ AttrKind) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches the return value expression of a return statement
///
/// Given
/// \code
///   return a + b;
/// \endcode
/// hasReturnValue(binaryOperator())
///   matches 'return a + b'
/// with binaryOperator()
///   matching 'a + b'
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::hasReturnValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5315,
 FQN="clang::ast_matchers::hasReturnValue", NM="_ZN5clang12ast_matchers14hasReturnValueERKNS0_8internal7MatcherINS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers14hasReturnValueERKNS0_8internal7MatcherINS_4ExprEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<ReturnStmt> hasReturnValue(final /*const*/ Matcher<Expr> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches CUDA kernel call expression.
///
/// Example matches,
/// \code
///   kernel<<<i,j>>>();
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::cudaKernelCallExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5329,
 FQN="clang::ast_matchers::cudaKernelCallExpr", NM="_ZN5clang12ast_matchersL18cudaKernelCallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchersL18cudaKernelCallExprE")
//</editor-fold>
public static /*const*/ VariadicDynCastAllOfMatcher<Stmt, CUDAKernelCallExpr> cudaKernelCallExpr/*J*/= new VariadicDynCastAllOfMatcher<Stmt, CUDAKernelCallExpr>();

/// \brief Matches expressions that resolve to a null pointer constant, such as
/// GNU's __null, C++11's nullptr, or C's NULL macro.
///
/// Given:
/// \code
///   void *v1 = NULL;
///   void *v2 = nullptr;
///   void *v3 = __null; // GNU extension
///   char *cp = (char *)0;
///   int *ip = 0;
///   int i = 0;
/// \endcode
/// expr(nullPointerConstant())
///   matches the initializer for v1, v2, v3, cp, and ip. Does not match the
///   initializer for i.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::nullPointerConstant_getInstance">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5349,
 FQN="clang::ast_matchers::nullPointerConstant_getInstance", NM="_ZN5clang12ast_matchers31nullPointerConstant_getInstanceEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers31nullPointerConstant_getInstanceEv")
//</editor-fold>
public static /*inline*/ Matcher<Expr> nullPointerConstant_getInstance() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::nullPointerConstant">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5349,
 FQN="clang::ast_matchers::nullPointerConstant", NM="_ZN5clang12ast_matchers19nullPointerConstantEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers19nullPointerConstantEv")
//</editor-fold>
public static /*inline*/ Matcher<Expr> nullPointerConstant() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Matches declaration of the function the statemenet belongs to
///
/// Given:
/// \code
/// F& operator=(const F& o) {
///   std::copy_if(o.begin(), o.end(), begin(), [](V v) { return v > 0; });
///   return *this;
/// }
/// \endcode
/// returnStmt(forFunction(hasName("operator=")))
///   matches 'return *this'
///   but does match 'return > 0'
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::forFunction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 5367,
 FQN="clang::ast_matchers::forFunction", NM="_ZN5clang12ast_matchers11forFunctionERKNS0_8internal7MatcherINS_12FunctionDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers11forFunctionERKNS0_8internal7MatcherINS_12FunctionDeclEEE")
//</editor-fold>
public static /*inline*/ /*::*/Matcher<Stmt> forFunction(final /*const*/ Matcher<FunctionDecl> /*&*/ InnerMatcher) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Returns the results of matching \p Matcher on \p Node.
///
/// Collects the \c BoundNodes of all callback invocations when matching
/// \p Matcher on \p Node and returns the collected results.
///
/// Multiple results occur when using matchers like \c forEachDescendant,
/// which generate a result for each sub-match.
///
/// \see selectFirst
/// @{
/*template <typename MatcherT, typename NodeT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::match">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 291,
 FQN="clang::ast_matchers::match", NM="Tpl__ZN5clang12ast_matchers5matchET_RKT0_RNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=Tpl__ZN5clang12ast_matchers5matchET_RKT0_RNS_10ASTContextE")
//</editor-fold>
public static </*typename*/ MatcherT, /*typename*/ NodeT> SmallVector<BoundNodes> match_T_T1$C$R_ASTContext(MatcherT Matcher, final /*const*/ NodeT /*&*/ Node, final ASTContext /*&*/ Context) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename MatcherT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::match">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 280,
 FQN="clang::ast_matchers::match", NM="Tpl__ZN5clang12ast_matchers5matchET_RKNS_15ast_type_traits12DynTypedNodeERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=Tpl__ZN5clang12ast_matchers5matchET_RKNS_15ast_type_traits12DynTypedNodeERNS_10ASTContextE")
//</editor-fold>
public static </*typename*/ MatcherT> SmallVector<BoundNodes> match_T_DynTypedNode$C_ASTContext(MatcherT Matcher, final /*const*/ DynTypedNode /*&*/ Node, 
                                 final ASTContext /*&*/ Context) {
  throw new UnsupportedOperationException("EmptyBody");
}

/// @}

/// \brief Returns the results of matching \p Matcher on the translation unit of
/// \p Context and collects the \c BoundNodes of all callback invocations.
/*template <typename MatcherT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::match">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 297,
 FQN="clang::ast_matchers::match", NM="Tpl__ZN5clang12ast_matchers5matchET_RNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=Tpl__ZN5clang12ast_matchers5matchET_RNS_10ASTContextE")
//</editor-fold>
public static </*typename*/ MatcherT> SmallVector<BoundNodes> match(MatcherT Matcher, final ASTContext /*&*/ Context) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Returns the first result of type \c NodeT bound to \p BoundTo.
///
/// Returns \c NULL if there is no match, or if the matching node cannot be
/// casted to \c NodeT.
///
/// This is useful in combanation with \c match():
/// \code
///   const Decl *D = selectFirst<Decl>("id", match(Matcher.bind("id"),
///                                                 Node, Context));
/// \endcode
/*template <typename NodeT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::selectFirst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchFinder.h", line = 260,
 FQN="clang::ast_matchers::selectFirst", NM="Tpl__ZN5clang12ast_matchers11selectFirstEN4llvm9StringRefERKNS1_15SmallVectorImplINS0_10BoundNodesEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=Tpl__ZN5clang12ast_matchers11selectFirstEN4llvm9StringRefERKNS1_15SmallVectorImplINS0_10BoundNodesEEE")
//</editor-fold>
public static </*typename*/ NodeT> /*const*/ NodeT /*P*/ selectFirst(StringRef BoundTo, final /*const*/ SmallVectorImpl<BoundNodes> /*&*/ Results) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class Ast_matchersGlobals
