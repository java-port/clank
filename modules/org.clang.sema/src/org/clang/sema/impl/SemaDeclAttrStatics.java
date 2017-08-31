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

import static org.clank.support.Native.$AddrOf;
import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
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
import org.clang.basic.*;
import static org.clang.basic.VersionTuple.*;
import org.clang.basic.java.BasicFunctionPointers.*;
import org.clang.sema.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.DeclContext.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.sema.impl.AttributeLangSupportStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstAttributesRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import org.clang.basic.java.OptionalNotes;


//<editor-fold defaultstate="collapsed" desc="static type SemaDeclAttrStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=Tpl__ZL19handleWorkGroupSizeRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;Tpl__ZL19mergeVisibilityAttrRN5clang4SemaEPNS_4DeclENS_11SourceRangeENT_14VisibilityTypeEj;Tpl__ZL21handleAttrWithMessageRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;Tpl__ZL21handleSimpleAttributeRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;Tpl__ZL24checkAttrMutualExclusionRN5clang4SemaEPNS_4DeclENS_11SourceRangeEPNS_14IdentifierInfoE;Tpl__ZL25checkAttributeNumArgsImplRN5clang4SemaERKNS_13AttributeListEjjT_;Tpl__ZL35handleSimpleAttributeWithExclusionsRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;Tpl__ZL35handleSimpleAttributeWithExclusionsRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL11isIntOrBoolPN5clang4ExprE;_ZL13getRecordTypeN5clang8QualTypeE;_ZL13handleDLLAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL13handleHotAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL13hasDeclaratorPKN5clang4DeclE;_ZL13normalizeNameRN4llvm9StringRefE;_ZL13versionsMatchRKN5clang12VersionTupleES2_b;_ZL14handleColdAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL14handleIBOutletRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL14handleModeAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL14handleUsedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL14handleUuidAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL14isCFStringTypeN5clang8QualTypeERNS_10ASTContextE;_ZL14isNSStringTypeN5clang8QualTypeERNS_10ASTContextE;_ZL15handleAliasAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL15handleIFuncAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL15handleNakedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL16handleAbiTagAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL16handleBlocksAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL16handleCommonAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL16handleFormatAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL16handleGlobalAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL16handlePackedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL16handleTargetAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL16handleUnusedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL16hasFunctionProtoPKN5clang4DeclE;_ZL16isCapabilityExprRN5clang4SemaEPKNS_4ExprE;_ZL16isDeclDeprecatedPN5clang4DeclE;_ZL16isInstanceMethodPKN5clang4DeclE;_ZL16parseModeAttrArgRN5clang4SemaEN4llvm9StringRefERjRbS5_;_ZL17getFormatAttrKindN4llvm9StringRefE;_ZL17handleAlignedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL17handleCleanupAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL17handleMinSizeAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL17handleNoDebugAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL17handleNonNullAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL17handleObjCBoxableRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL17handleSectionAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL17handleVecTypeHintRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL17handleWeakRefAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL17isDeclUnavailablePN5clang4DeclE;_ZL17typeHasCapabilityRN5clang4SemaENS_8QualTypeE;_ZL18getAttrForPlatformRN5clang10ASTContextEPKNS_4DeclE;_ZL18handleAnnotateAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL18handleCallConvAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL18handleEnableIfAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL18handleNoReturnAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL18handleObjCNSObjectRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL18handleRestrictAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL18handleSentinelAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL18handleTLSModelAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL18isFunctionOrMethodPKN5clang4DeclE;_ZL19attrNonNullArgCheckRN5clang4SemaENS_8QualTypeERKNS_13AttributeListENS_11SourceRangeES6_b;_ZL19checkIBOutletCommonRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL19checkUInt32ArgumentRN5clang4SemaERKNS_13AttributeListEPKNS_4ExprERjj;_ZL19getNumAttributeArgsRKN5clang13AttributeListE;_ZL19handleFormatArgAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL19handleGNUInlineAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL19handleGuardedByAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL19handleInterruptAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL19handleLayoutVersionRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL19handleOwnershipAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL19handleVecReturnAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL20ProcessDeclAttributeRN5clang4SemaEPNS_5ScopeEPNS_4DeclERKNS_13AttributeListEb;_ZL20handleAlignValueAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL20handleCapabilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL20handleConsumableAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL20handleDependencyAttrRN5clang4SemaEPNS_5ScopeEPNS_4DeclERKNS_13AttributeListE;_ZL20handleDeprecatedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL20handleDestructorAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL20handleNSConsumedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL20handleNoSanitizeAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL20handleObjCBridgeAttrRN5clang4SemaEPNS_5ScopeEPNS_4DeclERKNS_13AttributeListE;_ZL20handleVisibilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListEb;_ZL20handleWeakImportAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL21checkAttributeNumArgsRN5clang4SemaERKNS_13AttributeListEj;_ZL21checkAvailabilityAttrRN5clang4SemaENS_11SourceRangeEPNS_14IdentifierInfoENS_12VersionTupleES5_S5_;_ZL21handleConstructorAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL21handleObjCRuntimeNameRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL21handleOpenCLNoSVMAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL21handlePtGuardedByAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL22checkLockFunAttrCommonRN5clang4SemaEPNS_4DeclERKNS_13AttributeListERN4llvm15SmallVectorImplIPNS_4ExprEEE;_ZL22handleARMInterruptAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL22handleAlwaysInlineAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL22handleAvailabilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL22handleCallableWhenAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL22handleInitPriorityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL22handleLaunchBoundsAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL22handleLockReturnedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL22handleOpenCLAccessAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL22handleOptimizeNoneAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL22handleParameterABIAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListENS_12ParameterABIE;_ZL22handlePtGuardedVarAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL22handleSetTypestateAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL22handleWarnUnusedResultRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL22isForbiddenTypeAllowedRN5clang4SemaEPNS_4DeclERKNS_4sema17DelayedDiagnosticERNS_15UnavailableAttr14ImplicitReasonE;_ZL23checkForConsumableClassRN5clang4SemaEPKNS_13CXXMethodDeclERKNS_13AttributeListE;_ZL23handleAMDGPUNumSGPRAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL23handleAMDGPUNumVGPRAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL23handleAcquiredAfterAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL23handleAssumeAlignedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL23handleExtVectorTypeAttrRN5clang4SemaEPNS_5ScopeEPNS_4DeclERKNS_13AttributeListE;_ZL23handleLocksExcludedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL23handleMSInheritanceAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL23handleMipsInterruptAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL23handleNotTailCalledAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL23handleObjCOwnershipAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL23handleTestTypestateAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL23isValidSwiftContextTypeN5clang8QualTypeE;_ZL23makeLaunchBoundsArgExprRN5clang4SemaEPNS_4ExprERKNS_20CUDALaunchBoundsAttrEj;_ZL24checkGuardedByAttrCommonRN5clang4SemaEPNS_4DeclERKNS_13AttributeListERPNS_4ExprE;_ZL24handleAcquiredBeforeAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL24handleDeclspecThreadAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL24handleIBOutletCollectionRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL24handleParamTypestateAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL24handlePassObjectSizeAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL24handleReturnsNonNullAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL25DoEmitAvailabilityWarningRN5clang4SemaENS0_22AvailabilityDiagnosticEPNS_4DeclEPKNS_9NamedDeclEN4llvm9StringRefENS_14SourceLocationEPKNS_17ObjCInterfaceDeclEPKNS_16ObjCPropertyDeclEb;_ZL25checkTryLockFunAttrCommonRN5clang4SemaEPNS_4DeclERKNS_13AttributeListERN4llvm15SmallVectorImplIPNS_4ExprEEE;_ZL25checkUnusedDeclAttributesRN5clang4SemaEPKNS_13AttributeListE;_ZL25handleAnyX86InterruptAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL25handleInternalLinkageAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL25handleMSP430InterruptAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL25handleReturnTypestateAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL25isFunctionOrMethodOrBlockPKN5clang4DeclE;_ZL26handleAnalyzerNoReturnAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL26handleAssertCapabilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL26handleAssertSharedLockAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL26handleDelayedForbiddenTypeRN5clang4SemaERNS_4sema17DelayedDiagnosticEPNS_4DeclE;_ZL26handleDisableTailCallsAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL26handleNonNullAttrParameterRN5clang4SemaEPNS_11ParmVarDeclERKNS_13AttributeListE;_ZL26handleObjCIndependentClassRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL26handleObjCMethodFamilyAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL26handleTransparentUnionAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL26isFunctionOrMethodVariadicPKN5clang4DeclE;_ZL26threadSafetyCheckIsPointerRN5clang4SemaEPKNS_4DeclERKNS_13AttributeListE;_ZL27checkAcquireOrderAttrCommonRN5clang4SemaEPNS_4DeclERKNS_13AttributeListERN4llvm15SmallVectorImplIPNS_4ExprEEE;_ZL27checkAttributeAtMostNumArgsRN5clang4SemaERKNS_13AttributeListEj;_ZL27handleAcquireCapabilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL27handleCFAuditedTransferAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL27handleCFUnknownTransferAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL27handleNSReturnsRetainedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL27handleObjCBridgeMutableAttrRN5clang4SemaEPNS_5ScopeEPNS_4DeclERKNS_13AttributeListE;_ZL27handleObjCBridgeRelatedAttrRN5clang4SemaEPNS_5ScopeEPNS_4DeclERKNS_13AttributeListE;_ZL27handleObjCRequiresSuperAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL27handleReleaseCapabilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL27isValidSubjectOfCFAttributeRN5clang4SemaENS_8QualTypeE;_ZL27isValidSubjectOfNSAttributeRN5clang4SemaENS_8QualTypeE;_ZL27isValidSwiftErrorResultTypeN5clang8QualTypeE;_ZL28checkAttributeAtLeastNumArgsRN5clang4SemaERKNS_13AttributeListEj;_ZL28checkRecordTypeForCapabilityRN5clang4SemaENS_8QualTypeE;_ZL28getFunctionOrMethodNumParamsPKN5clang4DeclE;_ZL28getFunctionOrMethodParamTypePKN5clang4DeclEj;_ZL28handleNoSanitizeSpecificAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL28handleRequiresCapabilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL28handleTypeTagForDatatypeAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL29checkTypedefTypeForCapabilityN5clang8QualTypeE;_ZL29getFunctionOrMethodParamRangePKN5clang4DeclEj;_ZL29getFunctionOrMethodResultTypePKN5clang4DeclE;_ZL29handleArgumentWithTypeTagAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL29handleAssertExclusiveLockAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL29handleCommonAttributeFeaturesRN5clang4SemaEPNS_5ScopeEPNS_4DeclERKNS_13AttributeListE;_ZL29handleObjCPreciseLifetimeAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL29handleObjCSuppresProtocolAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL30checkAttrArgsAreCapabilityObjsRN5clang4SemaEPNS_4DeclERKNS_13AttributeListERN4llvm15SmallVectorImplIPNS_4ExprEEEib;_ZL30handleDelayedAvailabilityCheckRN5clang4SemaERNS_4sema17DelayedDiagnosticEPNS_4DeclE;_ZL30handleTryAcquireCapabilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL30isValidSwiftIndirectResultTypeN5clang8QualTypeE;_ZL31handleObjCDesignatedInitializerRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL31handleSharedTrylockFunctionAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL31threadSafetyCheckIsSmartPointerRN5clang4SemaEPKNS_10RecordTypeE;_ZL33handleObjCReturnsInnerPointerAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL33handleX86ForceAlignArgPointerAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL34handleExclusiveTrylockFunctionAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE;_ZL35checkFunctionOrMethodParameterIndexRN5clang4SemaEPKNS_4DeclERKNS_13AttributeListEjPKNS_4ExprERy;_ZL36getFunctionOrMethodResultSourceRangePKN5clang4DeclE;_ZL42isValidSubjectOfNSReturnsRetainedAttributeN5clang8QualTypeE; -static-type=SemaDeclAttrStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaDeclAttrStatics {

// end namespace AttributeLangSupport

//===----------------------------------------------------------------------===//
//  Helper functions
//===----------------------------------------------------------------------===//

/// isFunctionOrMethod - Return true if the given decl has function
/// type (function or function-typed variable) or an Objective-C
/// method.
//<editor-fold defaultstate="collapsed" desc="isFunctionOrMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 55,
 FQN="isFunctionOrMethod", NM="_ZL18isFunctionOrMethodPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL18isFunctionOrMethodPKN5clang4DeclE")
//</editor-fold>
public static boolean isFunctionOrMethod(/*const*/ Decl /*P*/ D) {
  return (D.getFunctionType() != null) || isa_ObjCMethodDecl(D);
}


/// \brief Return true if the given decl has function type (function or
/// function-typed variable) or an Objective-C method or a block.
//<editor-fold defaultstate="collapsed" desc="isFunctionOrMethodOrBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 61,
 FQN="isFunctionOrMethodOrBlock", NM="_ZL25isFunctionOrMethodOrBlockPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL25isFunctionOrMethodOrBlockPKN5clang4DeclE")
//</editor-fold>
public static boolean isFunctionOrMethodOrBlock(/*const*/ Decl /*P*/ D) {
  return isFunctionOrMethod(D) || isa_BlockDecl(D);
}


/// Return true if the given decl has a declarator that should have
/// been processed by Sema::GetTypeForDeclarator.
//<editor-fold defaultstate="collapsed" desc="hasDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 67,
 FQN="hasDeclarator", NM="_ZL13hasDeclaratorPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL13hasDeclaratorPKN5clang4DeclE")
//</editor-fold>
public static boolean hasDeclarator(/*const*/ Decl /*P*/ D) {
  // In some sense, TypedefDecl really *ought* to be a DeclaratorDecl.
  return isa_DeclaratorDecl(D) || isa_BlockDecl(D) || isa_TypedefNameDecl(D)
     || isa_ObjCPropertyDecl(D);
}


/// hasFunctionProto - Return true if the given decl has a argument
/// information. This decl should have already passed
/// isFunctionOrMethod or isFunctionOrMethodOrBlock.
//<editor-fold defaultstate="collapsed" desc="hasFunctionProto">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 76,
 FQN="hasFunctionProto", NM="_ZL16hasFunctionProtoPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL16hasFunctionProtoPKN5clang4DeclE")
//</editor-fold>
public static boolean hasFunctionProto(/*const*/ Decl /*P*/ D) {
  {
    /*const*/ FunctionType /*P*/ FnTy = D.getFunctionType();
    if ((FnTy != null)) {
      return isa_FunctionProtoType(FnTy);
    }
  }
  return isa_ObjCMethodDecl(D) || isa_BlockDecl(D);
}


/// getFunctionOrMethodNumParams - Return number of function or method
/// parameters. It is an error to call this on a K&R function (use
/// hasFunctionProto first).
//<editor-fold defaultstate="collapsed" desc="getFunctionOrMethodNumParams">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 85,
 FQN="getFunctionOrMethodNumParams", NM="_ZL28getFunctionOrMethodNumParamsPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL28getFunctionOrMethodNumParamsPKN5clang4DeclE")
//</editor-fold>
public static /*uint*/int getFunctionOrMethodNumParams(/*const*/ Decl /*P*/ D) {
  {
    /*const*/ FunctionType /*P*/ FnTy = D.getFunctionType();
    if ((FnTy != null)) {
      return cast_FunctionProtoType(FnTy).getNumParams();
    }
  }
  {
    /*const*/ BlockDecl /*P*/ BD = dyn_cast_BlockDecl(D);
    if ((BD != null)) {
      return BD.getNumParams();
    }
  }
  return cast_ObjCMethodDecl(D).param_size();
}

//<editor-fold defaultstate="collapsed" desc="getFunctionOrMethodParamType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 93,
 FQN="getFunctionOrMethodParamType", NM="_ZL28getFunctionOrMethodParamTypePKN5clang4DeclEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL28getFunctionOrMethodParamTypePKN5clang4DeclEj")
//</editor-fold>
public static QualType getFunctionOrMethodParamType(/*const*/ Decl /*P*/ D, /*uint*/int Idx) {
  {
    /*const*/ FunctionType /*P*/ FnTy = D.getFunctionType();
    if ((FnTy != null)) {
      return cast_FunctionProtoType(FnTy).getParamType(Idx);
    }
  }
  {
    /*const*/ BlockDecl /*P*/ BD = dyn_cast_BlockDecl(D);
    if ((BD != null)) {
      return BD.getParamDecl$Const(Idx).getType();
    }
  }
  
  return cast_ObjCMethodDecl(D).parameters().$at(Idx).getType();
}

//<editor-fold defaultstate="collapsed" desc="getFunctionOrMethodParamRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 102,
 FQN="getFunctionOrMethodParamRange", NM="_ZL29getFunctionOrMethodParamRangePKN5clang4DeclEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL29getFunctionOrMethodParamRangePKN5clang4DeclEj")
//</editor-fold>
public static SourceRange getFunctionOrMethodParamRange(/*const*/ Decl /*P*/ D, /*uint*/int Idx) {
  {
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
    if ((FD != null)) {
      return FD.getParamDecl$Const(Idx).getSourceRange();
    }
  }
  {
    /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(D);
    if ((MD != null)) {
      return MD.parameters().$at(Idx).getSourceRange();
    }
  }
  {
    /*const*/ BlockDecl /*P*/ BD = dyn_cast_BlockDecl(D);
    if ((BD != null)) {
      return BD.getParamDecl$Const(Idx).getSourceRange();
    }
  }
  return new SourceRange();
}

//<editor-fold defaultstate="collapsed" desc="getFunctionOrMethodResultType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 112,
 FQN="getFunctionOrMethodResultType", NM="_ZL29getFunctionOrMethodResultTypePKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL29getFunctionOrMethodResultTypePKN5clang4DeclE")
//</editor-fold>
public static QualType getFunctionOrMethodResultType(/*const*/ Decl /*P*/ D) {
  {
    /*const*/ FunctionType /*P*/ FnTy = D.getFunctionType();
    if ((FnTy != null)) {
      return cast_FunctionType(FnTy).getReturnType();
    }
  }
  return cast_ObjCMethodDecl(D).getReturnType();
}

//<editor-fold defaultstate="collapsed" desc="getFunctionOrMethodResultSourceRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 118,
 FQN="getFunctionOrMethodResultSourceRange", NM="_ZL36getFunctionOrMethodResultSourceRangePKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL36getFunctionOrMethodResultSourceRangePKN5clang4DeclE")
//</editor-fold>
public static SourceRange getFunctionOrMethodResultSourceRange(/*const*/ Decl /*P*/ D) {
  {
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
    if ((FD != null)) {
      return FD.getReturnTypeSourceRange();
    }
  }
  {
    /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(D);
    if ((MD != null)) {
      return MD.getReturnTypeSourceRange();
    }
  }
  return new SourceRange();
}

//<editor-fold defaultstate="collapsed" desc="isFunctionOrMethodVariadic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 126,
 FQN="isFunctionOrMethodVariadic", NM="_ZL26isFunctionOrMethodVariadicPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL26isFunctionOrMethodVariadicPKN5clang4DeclE")
//</editor-fold>
public static boolean isFunctionOrMethodVariadic(/*const*/ Decl /*P*/ D) {
  {
    /*const*/ FunctionType /*P*/ FnTy = D.getFunctionType();
    if ((FnTy != null)) {
      /*const*/ FunctionProtoType /*P*/ proto = cast_FunctionProtoType(FnTy);
      return proto.isVariadic();
    }
  }
  {
    /*const*/ BlockDecl /*P*/ BD = dyn_cast_BlockDecl(D);
    if ((BD != null)) {
      return BD.isVariadic();
    }
  }
  
  return cast_ObjCMethodDecl(D).isVariadic();
}

//<editor-fold defaultstate="collapsed" desc="isInstanceMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 137,
 FQN="isInstanceMethod", NM="_ZL16isInstanceMethodPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL16isInstanceMethodPKN5clang4DeclE")
//</editor-fold>
public static boolean isInstanceMethod(/*const*/ Decl /*P*/ D) {
  {
    /*const*/ CXXMethodDecl /*P*/ MethodDecl = dyn_cast_CXXMethodDecl(D);
    if ((MethodDecl != null)) {
      return MethodDecl.isInstance();
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isNSStringType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 143,
 FQN="isNSStringType", NM="_ZL14isNSStringTypeN5clang8QualTypeERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL14isNSStringTypeN5clang8QualTypeERNS_10ASTContextE")
//</editor-fold>
public static /*inline*/ boolean isNSStringType(QualType T, final ASTContext /*&*/ Ctx) {
  /*const*/ ObjCObjectPointerType /*P*/ PT = T.$arrow().getAs(ObjCObjectPointerType.class);
  if (!(PT != null)) {
    return false;
  }
  
  ObjCInterfaceDecl /*P*/ Cls = PT.getObjectType().getInterface();
  if (!(Cls != null)) {
    return false;
  }
  
  IdentifierInfo /*P*/ ClsName = Cls.getIdentifier();
  
  // FIXME: Should we walk the chain of classes?
  return ClsName == $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSString")))
     || ClsName == $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSMutableString")));
}

//<editor-fold defaultstate="collapsed" desc="isCFStringType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 159,
 FQN="isCFStringType", NM="_ZL14isCFStringTypeN5clang8QualTypeERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL14isCFStringTypeN5clang8QualTypeERNS_10ASTContextE")
//</editor-fold>
public static /*inline*/ boolean isCFStringType(QualType T, final ASTContext /*&*/ Ctx) {
  /*const*/ PointerType /*P*/ PT = T.$arrow().getAs(PointerType.class);
  if (!(PT != null)) {
    return false;
  }
  
  /*const*/ RecordType /*P*/ RT = PT.getPointeeType().$arrow().<RecordType>getAs$RecordType();
  if (!(RT != null)) {
    return false;
  }
  
  /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
  if (RD.getTagKind() != TagTypeKind.TTK_Struct) {
    return false;
  }
  
  return RD.getIdentifier() == $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"__CFString")));
}

//<editor-fold defaultstate="collapsed" desc="getNumAttributeArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 175,
 FQN="getNumAttributeArgs", NM="_ZL19getNumAttributeArgsRKN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL19getNumAttributeArgsRKN5clang13AttributeListE")
//</editor-fold>
public static /*uint*/int getNumAttributeArgs(final /*const*/ AttributeList /*&*/ Attr) {
  // FIXME: Include the type in the argument list.
  return Attr.getNumArgs() + (Attr.hasParsedType() ? 1 : 0);
}

/*template <typename Compare> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="checkAttributeNumArgsImpl">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 181,
 FQN="checkAttributeNumArgsImpl", NM="Tpl__ZL25checkAttributeNumArgsImplRN5clang4SemaERKNS_13AttributeListEjjT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=Tpl__ZL25checkAttributeNumArgsImplRN5clang4SemaERKNS_13AttributeListEjjT_")
//</editor-fold>
public static </*typename*/ Compare extends UIntUIntBoolPredicate>  boolean checkAttributeNumArgsImpl(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, 
                         /*uint*/int Num, /*uint*/int Diag, 
                         Compare Comp) {
  if (Comp.$call(getNumAttributeArgs(Attr), Num)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), Diag)), Attr.getName()), Num));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  
  return true;
}


/// \brief Check if the attribute has exactly as many args as Num. May
/// output an error.
//<editor-fold defaultstate="collapsed" desc="checkAttributeNumArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 194,
 FQN="checkAttributeNumArgs", NM="_ZL21checkAttributeNumArgsRN5clang4SemaERKNS_13AttributeListEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL21checkAttributeNumArgsRN5clang4SemaERKNS_13AttributeListEj")
//</editor-fold>
public static boolean checkAttributeNumArgs(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, 
                     /*uint*/int Num) {
  return checkAttributeNumArgsImpl(S, Attr, Num, 
      diag.err_attribute_wrong_number_arguments, 
      new std.not_equal_to_uint());
}


/// \brief Check if the attribute has at least as many args as Num. May
/// output an error.
//<editor-fold defaultstate="collapsed" desc="checkAttributeAtLeastNumArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 203,
 FQN="checkAttributeAtLeastNumArgs", NM="_ZL28checkAttributeAtLeastNumArgsRN5clang4SemaERKNS_13AttributeListEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL28checkAttributeAtLeastNumArgsRN5clang4SemaERKNS_13AttributeListEj")
//</editor-fold>
public static boolean checkAttributeAtLeastNumArgs(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, 
                            /*uint*/int Num) {
  return checkAttributeNumArgsImpl(S, Attr, Num, 
      diag.err_attribute_too_few_arguments, 
      new std.less_uint());
}


/// \brief Check if the attribute has at most as many args as Num. May
/// output an error.
//<editor-fold defaultstate="collapsed" desc="checkAttributeAtMostNumArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 212,
 FQN="checkAttributeAtMostNumArgs", NM="_ZL27checkAttributeAtMostNumArgsRN5clang4SemaERKNS_13AttributeListEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL27checkAttributeAtMostNumArgsRN5clang4SemaERKNS_13AttributeListEj")
//</editor-fold>
public static boolean checkAttributeAtMostNumArgs(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, 
                           /*uint*/int Num) {
  return checkAttributeNumArgsImpl(S, Attr, Num, 
      diag.err_attribute_too_many_arguments, 
      new std.greater_uint());
}


/// \brief If Expr is a valid integer constant, get the value of the integer
/// expression and return success or failure. May output an error.
//<editor-fold defaultstate="collapsed" desc="checkUInt32Argument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 221,
 FQN="checkUInt32Argument", NM="_ZL19checkUInt32ArgumentRN5clang4SemaERKNS_13AttributeListEPKNS_4ExprERjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL19checkUInt32ArgumentRN5clang4SemaERKNS_13AttributeListEPKNS_4ExprERjj")
//</editor-fold>
public static boolean checkUInt32Argument(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, 
                   /*const*/ Expr /*P*/ $Expr, final /*uint32_t &*/uint$ref Val) {
  return checkUInt32Argument(S, Attr, 
                   $Expr, Val, 
                   UINT_MAX);
}
public static boolean checkUInt32Argument(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, 
                   /*const*/ Expr /*P*/ $Expr, final /*uint32_t &*/uint$ref Val, 
                   /*uint*/int Idx/*= (2147483647 * 2U + 1U)*/) {
  APSInt I/*J*/= new APSInt(32);
  if ($Expr.isTypeDependent() || $Expr.isValueDependent()
     || !$Expr.isIntegerConstantExpr(I, S.Context)) {
    if (Idx != UINT_MAX) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_n_type)), 
                        Attr.getName()), Idx), AttributeArgumentNType.AANT_ArgumentIntegerConstant), 
            $Expr.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_type)), 
                    Attr.getName()), AttributeArgumentNType.AANT_ArgumentIntegerConstant), 
            $Expr.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  if (!I.isIntN(32)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag($Expr.getExprLoc(), diag.err_ice_too_large)), 
                  I.__toString(10, false)), 32), /* Unsigned */ 1));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  
  Val.$set((/*uint32_t*/int)$ulong2uint(I.getZExtValue()));
  return true;
}


/// \brief Diagnose mutually exclusive attributes when present on a given
/// declaration. Returns true if diagnosed.
/*template <typename AttrTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="checkAttrMutualExclusion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 251,
 FQN="checkAttrMutualExclusion", NM="Tpl__ZL24checkAttrMutualExclusionRN5clang4SemaEPNS_4DeclENS_11SourceRangeEPNS_14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=Tpl__ZL24checkAttrMutualExclusionRN5clang4SemaEPNS_4DeclENS_11SourceRangeEPNS_14IdentifierInfoE")
//</editor-fold>
public static </*typename*/ AttrTy extends Attr> boolean checkAttrMutualExclusion(Class<AttrTy> clazz, final Sema /*&*/ S, Decl /*P*/ D, SourceRange Range, 
                        IdentifierInfo /*P*/ Ident) {
  {
    AttrTy /*P*/ A = D.<AttrTy>getAttr(clazz);
    if (A != null) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Range.getBegin(), diag.err_attributes_are_not_compatible)), Ident), 
            A));
        $c$.clean($c$.track(S.Diag(A.getLocation(), diag.note_conflicting_attribute)));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
  }
  return false;
}


/// \brief Check if IdxExpr is a valid parameter index for a function or
/// instance method D.  May output an error.
///
/// \returns true if IdxExpr is a valid index.
//<editor-fold defaultstate="collapsed" desc="checkFunctionOrMethodParameterIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 266,
 FQN="checkFunctionOrMethodParameterIndex", NM="_ZL35checkFunctionOrMethodParameterIndexRN5clang4SemaEPKNS_4DeclERKNS_13AttributeListEjPKNS_4ExprERy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL35checkFunctionOrMethodParameterIndexRN5clang4SemaEPKNS_4DeclERKNS_13AttributeListEjPKNS_4ExprERy")
//</editor-fold>
public static boolean checkFunctionOrMethodParameterIndex(final Sema /*&*/ S, /*const*/ Decl /*P*/ D, 
                                   final /*const*/ AttributeList /*&*/ Attr, 
                                   /*uint*/int AttrArgNum, 
                                   /*const*/ Expr /*P*/ IdxExpr, 
                                   final ulong$ref/*uint64_t &*/ Idx) {
  assert (isFunctionOrMethodOrBlock(D));
  
  // In C++ the implicit 'this' function parameter also counts.
  // Parameters are counted from one.
  boolean HP = hasFunctionProto(D);
  boolean HasImplicitThisParam = isInstanceMethod(D);
  boolean IV = HP && isFunctionOrMethodVariadic(D);
  /*uint*/int NumParams = (HP ? getFunctionOrMethodNumParams(D) : 0) + (HasImplicitThisParam ? 1 : 0);
  
  APSInt IdxInt/*J*/= new APSInt();
  if (IdxExpr.isTypeDependent() || IdxExpr.isValueDependent()
     || !IdxExpr.isIntegerConstantExpr(IdxInt, S.Context)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_n_type)), 
                      Attr.getName()), AttrArgNum), AttributeArgumentNType.AANT_ArgumentIntegerConstant), 
          IdxExpr.getSourceRange()));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  
  Idx.$set(IdxInt.getLimitedValue());
  if ($less_ulong_ullong(Idx.$deref(), 1) || (!IV && $greater_ulong_uint(Idx.$deref(), NumParams))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_out_of_bounds)), 
                  Attr.getName()), AttrArgNum), IdxExpr.getSourceRange()));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  Idx.$set$postDec(); // Convert to zero-based.
  if (HasImplicitThisParam) {
    if (Idx.$deref() == 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), 
                    diag.err_attribute_invalid_implicit_this_argument)), 
                Attr.getName()), IdxExpr.getSourceRange()));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    Idx.$set$preDec();
  }
  
  return true;
}


/// \brief Applies the given attribute to the Decl without performing any
/// additional semantic checking.
/*template <typename AttrType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="handleSimpleAttribute">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*extra Attr.class based param + create by reflection*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 349,
 FQN="handleSimpleAttribute", NM="Tpl__ZL21handleSimpleAttributeRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=Tpl__ZL21handleSimpleAttributeRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static </*typename*/ AttrType extends Attr> void handleSimpleAttribute(Class<AttrType> AttrTypeClass, final Sema /*&*/ S, Decl /*P*/ D, 
                     final /*const*/ AttributeList /*&*/ Attr) {
  try {
    // JAVA: create class by reflection
    Constructor<AttrType> constructor = AttrTypeClass.getConstructor(SourceRange.class, ASTContext.class, int.class);
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/constructor.newInstance(Attr.getRange(), S.Context, Attr.getAttributeSpellingListIndex()));
  } catch (Throwable ex) {
    Logger.getLogger(SemaDeclAttrStatics.class.getName()).log(Level.SEVERE, null, ex);
  }
}

/*template <typename AttrType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="handleSimpleAttributeWithExclusions">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*extra Attr.class based param*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 356,
 FQN="handleSimpleAttributeWithExclusions", NM="Tpl__ZL35handleSimpleAttributeWithExclusionsRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=Tpl__ZL35handleSimpleAttributeWithExclusionsRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static </*typename*/ AttrType extends Attr> void handleSimpleAttributeWithExclusions(Class<AttrType> AttrTypeClass, final Sema /*&*/ S, Decl /*P*/ D, 
                                   final /*const*/ AttributeList /*&*/ Attr) {
  handleSimpleAttribute(AttrTypeClass, S, D, Attr);
}


/// \brief Applies the given attribute to the Decl so long as the Decl doesn't
/// already have one of the given incompatible attributes.
/*template <typename AttrType, typename IncompatibleAttrType, typename ... IncompatibleAttrTypes> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="handleSimpleAttributeWithExclusions">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*extra Attr.class based param*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 365,
 FQN="handleSimpleAttributeWithExclusions", NM="Tpl__ZL35handleSimpleAttributeWithExclusionsRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=Tpl__ZL35handleSimpleAttributeWithExclusionsRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static </*typename*/ AttrType extends Attr, /*typename*/ IncompatibleAttrType extends Attr> void handleSimpleAttributeWithExclusions(
                                   Class<AttrType> AttrTypeClass, Class<IncompatibleAttrType> IncompatibleAttrTypeClass,
                                   final Sema /*&*/ S, Decl /*P*/ D, 
                                   final /*const*/ AttributeList /*&*/ Attr) {
  if (checkAttrMutualExclusion(IncompatibleAttrTypeClass, S, D, Attr.getRange(), 
      Attr.getName())) {
    return;
  }
  handleSimpleAttributeWithExclusions(AttrTypeClass, S, D, 
      Attr);
}


/// \brief Check if the passed-in expression is of type int or bool.
//<editor-fold defaultstate="collapsed" desc="isIntOrBool">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 375,
 FQN="isIntOrBool", NM="_ZL11isIntOrBoolPN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL11isIntOrBoolPN5clang4ExprE")
//</editor-fold>
public static boolean isIntOrBool(Expr /*P*/ Exp) {
  QualType QT = Exp.getType();
  return QT.$arrow().isBooleanType() || QT.$arrow().isIntegerType();
}


// Check to see if the type is a smart pointer of some kind.  We assume
// it's a smart pointer if it defines both operator-> and operator*.
//<editor-fold defaultstate="collapsed" desc="threadSafetyCheckIsSmartPointer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 383,
 FQN="threadSafetyCheckIsSmartPointer", NM="_ZL31threadSafetyCheckIsSmartPointerRN5clang4SemaEPKNS_10RecordTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL31threadSafetyCheckIsSmartPointerRN5clang4SemaEPKNS_10RecordTypeE")
//</editor-fold>
public static boolean threadSafetyCheckIsSmartPointer(final Sema /*&*/ S, /*const*/ RecordType /*P*/ RT) {
  DeclContextLookupResult Res1 = RT.getDecl().lookup(S.Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_Star));
  if (Res1.empty()) {
    return false;
  }
  
  DeclContextLookupResult Res2 = RT.getDecl().lookup(S.Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_Arrow));
  if (Res2.empty()) {
    return false;
  }
  
  return true;
}


/// \brief Check if passed in Decl is a pointer type.
/// Note that this function may produce an error message.
/// \return true if the Decl is a pointer type; false otherwise
//<editor-fold defaultstate="collapsed" desc="threadSafetyCheckIsPointer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 400,
 FQN="threadSafetyCheckIsPointer", NM="_ZL26threadSafetyCheckIsPointerRN5clang4SemaEPKNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL26threadSafetyCheckIsPointerRN5clang4SemaEPKNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static boolean threadSafetyCheckIsPointer(final Sema /*&*/ S, /*const*/ Decl /*P*/ D, 
                          final /*const*/ AttributeList /*&*/ Attr) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    /*const*/ ValueDecl /*P*/ vd = cast_ValueDecl(D);
    QualType QT = vd.getType();
    if (QT.$arrow().isAnyPointerType()) {
      return true;
    }
    {
      
      /*const*/ RecordType /*P*/ RT = QT.$arrow().<RecordType>getAs$RecordType();
      if ((RT != null)) {
        // If it's an incomplete type, it could be a smart pointer; skip it.
        // (We don't want to force template instantiation if we can avoid it,
        // since that would alter the order in which templates are instantiated.)
        if (RT.isIncompleteType()) {
          return true;
        }
        if (threadSafetyCheckIsSmartPointer(S, RT)) {
          return true;
        }
      }
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_thread_attribute_decl_not_pointer)), 
            Attr.getName()), QT));
    return false;
  } finally {
    $c$.$destroy();
  }
}


/// \brief Checks that the passed in QualType either is of RecordType or points
/// to RecordType. Returns the relevant RecordType, null if it does not exit.
//<editor-fold defaultstate="collapsed" desc="getRecordType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 425,
 FQN="getRecordType", NM="_ZL13getRecordTypeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL13getRecordTypeN5clang8QualTypeE")
//</editor-fold>
public static /*const*/ RecordType /*P*/ getRecordType(QualType QT) {
  {
    /*const*/ RecordType /*P*/ RT = QT.$arrow().<RecordType>getAs$RecordType();
    if ((RT != null)) {
      return RT;
    }
  }
  {
    
    // Now check if we point to record type.
    /*const*/ PointerType /*P*/ PT = QT.$arrow().getAs(PointerType.class);
    if ((PT != null)) {
      return PT.getPointeeType().$arrow().<RecordType>getAs$RecordType();
    }
  }
  
  return null;
}

//<editor-fold defaultstate="collapsed" desc="checkRecordTypeForCapability">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 436,
 FQN="checkRecordTypeForCapability", NM="_ZL28checkRecordTypeForCapabilityRN5clang4SemaENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL28checkRecordTypeForCapabilityRN5clang4SemaENS_8QualTypeE")
//</editor-fold>
public static boolean checkRecordTypeForCapability(final Sema /*&*/ S, QualType Ty) {
  /*const*/ RecordType /*P*/ RT = getRecordType(new QualType(Ty));
  if (!(RT != null)) {
    return false;
  }
  
  // Don't check for the capability if the class hasn't been defined yet.
  if (RT.isIncompleteType()) {
    return true;
  }
  
  // Allow smart pointers to be used as capability objects.
  // FIXME -- Check the type that the smart pointer points to.
  if (threadSafetyCheckIsSmartPointer(S, RT)) {
    return true;
  }
  
  // Check if the record itself has a capability.
  RecordDecl /*P*/ RD = RT.getDecl();
  if (RD.hasAttr(CapabilityAttr.class)) {
    return true;
  }
  {
    
    // Else check if any base classes have a capability.
    CXXRecordDecl /*P*/ CRD = dyn_cast_CXXRecordDecl(RD);
    if ((CRD != null)) {
      CXXBasePaths BPaths = null;
      try {
        BPaths/*J*/= new CXXBasePaths(false, false);
        if (CRD.lookupInBases((CXXBaseSpecifier BS, CXXBasePath unused) -> 
                  {
                    /*const*/ RecordType /*P*/ Type = BS.getType().$arrow().<RecordType>getAs$RecordType();
                    return Type.getDecl().hasAttr(CapabilityAttr.class);
                  }, BPaths)) {
          return true;
        }
      } finally {
        if (BPaths != null) { BPaths.$destroy(); }
      }
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="checkTypedefTypeForCapability">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 468,
 FQN="checkTypedefTypeForCapability", NM="_ZL29checkTypedefTypeForCapabilityN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL29checkTypedefTypeForCapabilityN5clang8QualTypeE")
//</editor-fold>
public static boolean checkTypedefTypeForCapability(QualType Ty) {
  /*const*/ TypedefType /*P*/ TD = Ty.$arrow().<TypedefType>getAs$TypedefType();
  if (!(TD != null)) {
    return false;
  }
  
  TypedefNameDecl /*P*/ TN = TD.getDecl();
  if (!(TN != null)) {
    return false;
  }
  
  return TN.hasAttr(CapabilityAttr.class);
}

//<editor-fold defaultstate="collapsed" desc="typeHasCapability">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 480,
 FQN="typeHasCapability", NM="_ZL17typeHasCapabilityRN5clang4SemaENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL17typeHasCapabilityRN5clang4SemaENS_8QualTypeE")
//</editor-fold>
public static boolean typeHasCapability(final Sema /*&*/ S, QualType Ty) {
  if (checkTypedefTypeForCapability(new QualType(Ty))) {
    return true;
  }
  if (checkRecordTypeForCapability(S, new QualType(Ty))) {
    return true;
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isCapabilityExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 490,
 FQN="isCapabilityExpr", NM="_ZL16isCapabilityExprRN5clang4SemaEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL16isCapabilityExprRN5clang4SemaEPKNS_4ExprE")
//</editor-fold>
public static boolean isCapabilityExpr(final Sema /*&*/ S, /*const*/ Expr /*P*/ Ex) {
  {
    // Capability expressions are simple expressions involving the boolean logic
    // operators &&, || or !, a simple DeclRefExpr, CastExpr or a ParenExpr. Once
    // a DeclRefExpr is found, its type should be checked to determine whether it
    // is a capability or not.
    /*const*/ DeclRefExpr /*P*/ E = dyn_cast_DeclRefExpr(Ex);
    if ((E != null)) {
      return typeHasCapability(S, E.getType());
    } else {
      /*const*/ CastExpr /*P*/ E$1 = dyn_cast_CastExpr(Ex);
      if ((E$1 != null)) {
        return isCapabilityExpr(S, E$1.getSubExpr$Const());
      } else {
        /*const*/ ParenExpr /*P*/ E$2 = dyn_cast_ParenExpr(Ex);
        if ((E$2 != null)) {
          return isCapabilityExpr(S, E$2.getSubExpr$Const());
        } else {
          /*const*/ UnaryOperator /*P*/ E$3 = dyn_cast_UnaryOperator(Ex);
          if ((E$3 != null)) {
            if (E$3.getOpcode() == UnaryOperatorKind.UO_LNot) {
              return isCapabilityExpr(S, E$3.getSubExpr());
            }
            return false;
          } else {
            /*const*/ BinaryOperator /*P*/ E$4 = dyn_cast_BinaryOperator(Ex);
            if ((E$4 != null)) {
              if (E$4.getOpcode() == BinaryOperatorKind.BO_LAnd || E$4.getOpcode() == BinaryOperatorKind.BO_LOr) {
                return isCapabilityExpr(S, E$4.getLHS())
                   && isCapabilityExpr(S, E$4.getRHS());
              }
              return false;
            }
          }
        }
      }
    }
  }
  
  return false;
}


/// \brief Checks that all attribute arguments, starting from Sidx, resolve to
/// a capability object.
/// \param Sidx The attribute argument index to start checking with.
/// \param ParamIdxOk Whether an argument can be indexing into a function
/// parameter list.
//<editor-fold defaultstate="collapsed" desc="checkAttrArgsAreCapabilityObjs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 521,
 FQN="checkAttrArgsAreCapabilityObjs", NM="_ZL30checkAttrArgsAreCapabilityObjsRN5clang4SemaEPNS_4DeclERKNS_13AttributeListERN4llvm15SmallVectorImplIPNS_4ExprEEEib",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL30checkAttrArgsAreCapabilityObjsRN5clang4SemaEPNS_4DeclERKNS_13AttributeListERN4llvm15SmallVectorImplIPNS_4ExprEEEib")
//</editor-fold>
public static void checkAttrArgsAreCapabilityObjs(final Sema /*&*/ S, Decl /*P*/ D, 
                              final /*const*/ AttributeList /*&*/ Attr, 
                              final SmallVectorImpl<Expr /*P*/ > /*&*/ Args) {
  checkAttrArgsAreCapabilityObjs(S, D, 
                              Attr, 
                              Args, 
                              0, 
                              false);
}
public static void checkAttrArgsAreCapabilityObjs(final Sema /*&*/ S, Decl /*P*/ D, 
                              final /*const*/ AttributeList /*&*/ Attr, 
                              final SmallVectorImpl<Expr /*P*/ > /*&*/ Args, 
                              int Sidx/*= 0*/) {
  checkAttrArgsAreCapabilityObjs(S, D, 
                              Attr, 
                              Args, 
                              Sidx, 
                              false);
}
public static void checkAttrArgsAreCapabilityObjs(final Sema /*&*/ S, Decl /*P*/ D, 
                              final /*const*/ AttributeList /*&*/ Attr, 
                              final SmallVectorImpl<Expr /*P*/ > /*&*/ Args, 
                              int Sidx/*= 0*/, 
                              boolean ParamIdxOk/*= false*/) {
  for (/*uint*/int Idx = Sidx; $less_uint(Idx, Attr.getNumArgs()); ++Idx) {
    Expr /*P*/ ArgExp = Attr.getArgAsExpr(Idx);
    if (ArgExp.isTypeDependent()) {
      // FIXME -- need to check this again on template instantiation
      Args.push_back(ArgExp);
      continue;
    }
    {
      
      StringLiteral /*P*/ StrLit = dyn_cast_StringLiteral(ArgExp);
      if ((StrLit != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if (StrLit.getLength() == 0
             || (StrLit.isAscii() && $eq_StringRef(StrLit.getString(), /*STRINGREF_STR*/"*"))) {
            // Pass empty strings to the analyzer without warnings.
            // Treat "*" as the universal lock.
            Args.push_back(ArgExp);
            continue;
          }
          
          // We allow constant strings to be used as a placeholder for expressions
          // that are not valid C++ syntax, but warn that they are ignored.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_thread_attribute_ignored)), 
              Attr.getName()));
          Args.push_back(ArgExp);
          continue;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    QualType ArgTy = ArgExp.getType();
    {
      
      // A pointer to member expression of the form  &MyClass::mu is treated
      // specially -- we need to look at the type of the member.
      UnaryOperator /*P*/ UOp = dyn_cast_UnaryOperator(ArgExp);
      if ((UOp != null)) {
        if (UOp.getOpcode() == UnaryOperatorKind.UO_AddrOf) {
          {
            DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(UOp.getSubExpr());
            if ((DRE != null)) {
              if (DRE.getDecl().isCXXInstanceMember()) {
                ArgTy.$assignMove(DRE.getDecl().getType());
              }
            }
          }
        }
      }
    }
    
    // First see if we can just cast to record type, or pointer to record type.
    /*const*/ RecordType /*P*/ RT = getRecordType(new QualType(ArgTy));
    
    // Now check if we index into a record type function param.
    if (!(RT != null) && ParamIdxOk) {
      FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
      IntegerLiteral /*P*/ IL = dyn_cast_IntegerLiteral(ArgExp);
      if ((FD != null) && (IL != null)) {
        /*uint*/int NumParams = FD.getNumParams();
        APInt ArgValue = IL.getValue();
        long/*uint64_t*/ ParamIdxFromOne = ArgValue.getZExtValue();
        long/*uint64_t*/ ParamIdxFromZero = ParamIdxFromOne - 1;
        if (!ArgValue.isStrictlyPositive() || $greater_ulong_uint(ParamIdxFromOne, NumParams)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_out_of_range)), 
                        Attr.getName()), Idx + 1), NumParams));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
        ArgTy.$assignMove(FD.getParamDecl($ulong2uint(ParamIdxFromZero)).getType());
      }
    }
    
    // If the type does not have a capability, see if the components of the
    // expression have capabilities. This allows for writing C code where the
    // capability may be on the type, and the expression is a capability
    // boolean logic expression. Eg) requires_capability(A || B && !C)
    if (!typeHasCapability(S, new QualType(ArgTy)) && !isCapabilityExpr(S, ArgExp)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_thread_attribute_argument_not_lockable)), 
                Attr.getName()), ArgTy));
      } finally {
        $c$.$destroy();
      }
    }
    
    Args.push_back(ArgExp);
  }
}


//===----------------------------------------------------------------------===//
// Attribute Implementations
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="handlePtGuardedVarAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 599,
 FQN="handlePtGuardedVarAttr", NM="_ZL22handlePtGuardedVarAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL22handlePtGuardedVarAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handlePtGuardedVarAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                      final /*const*/ AttributeList /*&*/ Attr) {
  if (!threadSafetyCheckIsPointer(S, D, Attr)) {
    return;
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new PtGuardedVarAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="checkGuardedByAttrCommon">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 609,
 FQN="checkGuardedByAttrCommon", NM="_ZL24checkGuardedByAttrCommonRN5clang4SemaEPNS_4DeclERKNS_13AttributeListERPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL24checkGuardedByAttrCommonRN5clang4SemaEPNS_4DeclERKNS_13AttributeListERPNS_4ExprE")
//</editor-fold>
public static boolean checkGuardedByAttrCommon(final Sema /*&*/ S, Decl /*P*/ D, 
                        final /*const*/ AttributeList /*&*/ Attr, 
                        final type$ref<Expr /*P*/ /*&*/> Arg) {
  SmallVector<Expr /*P*/ > Args/*J*/= new SmallVector<Expr /*P*/ >(1, (Expr /*P*/ )null);
  // check that all arguments are lockable objects
  checkAttrArgsAreCapabilityObjs(S, D, Attr, Args);
  /*uint*/int Size = Args.size();
  if (Size != 1) {
    return false;
  }
  
  Arg.$set(Args.$at(0));
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="handleGuardedByAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 624,
 FQN="handleGuardedByAttr", NM="_ZL19handleGuardedByAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL19handleGuardedByAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleGuardedByAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  type$ref<Expr /*P*/ > Arg = create_type$null$ref(null);
  if (!checkGuardedByAttrCommon(S, D, Attr, Arg)) {
    return;
  }
  
  D.addAttr(/*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*::*//*new (S.Context)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->{
          return new GuardedByAttr(Attr.getRange(), S.Context, Arg.$deref(), 
                  Attr.getAttributeSpellingListIndex());
       }));
}

//<editor-fold defaultstate="collapsed" desc="handlePtGuardedByAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 633,
 FQN="handlePtGuardedByAttr", NM="_ZL21handlePtGuardedByAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL21handlePtGuardedByAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handlePtGuardedByAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                     final /*const*/ AttributeList /*&*/ Attr) {
  type$ref<Expr /*P*/ > Arg = create_type$null$ref(null);
  if (!checkGuardedByAttrCommon(S, D, Attr, Arg)) {
    return;
  }
  if (!threadSafetyCheckIsPointer(S, D, Attr)) {
    return;
  }
  
  D.addAttr(/*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*::*//*new (S.Context)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->{
          return new PtGuardedByAttr(Attr.getRange(), 
                  S.Context, Arg.$deref(), 
                  Attr.getAttributeSpellingListIndex());
       }));
}

//<editor-fold defaultstate="collapsed" desc="checkAcquireOrderAttrCommon">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 647,
 FQN="checkAcquireOrderAttrCommon", NM="_ZL27checkAcquireOrderAttrCommonRN5clang4SemaEPNS_4DeclERKNS_13AttributeListERN4llvm15SmallVectorImplIPNS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL27checkAcquireOrderAttrCommonRN5clang4SemaEPNS_4DeclERKNS_13AttributeListERN4llvm15SmallVectorImplIPNS_4ExprEEE")
//</editor-fold>
public static boolean checkAcquireOrderAttrCommon(final Sema /*&*/ S, Decl /*P*/ D, 
                           final /*const*/ AttributeList /*&*/ Attr, 
                           final SmallVectorImpl<Expr /*P*/ > /*&*/ Args) {
  if (!checkAttributeAtLeastNumArgs(S, Attr, 1)) {
    return false;
  }
  
  // Check that this attribute only applies to lockable types.
  QualType QT = cast_ValueDecl(D).getType();
  if (!QT.$arrow().isDependentType() && !typeHasCapability(S, new QualType(QT))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_thread_attribute_decl_not_lockable)), 
          Attr.getName()));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Check that all arguments are lockable objects.
  checkAttrArgsAreCapabilityObjs(S, D, Attr, Args);
  if (Args.empty()) {
    return false;
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="handleAcquiredAfterAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 669,
 FQN="handleAcquiredAfterAttr", NM="_ZL23handleAcquiredAfterAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL23handleAcquiredAfterAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleAcquiredAfterAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                       final /*const*/ AttributeList /*&*/ Attr) {
  SmallVector<Expr /*P*/ > Args/*J*/= new SmallVector<Expr /*P*/ >(1, (Expr /*P*/ )null);
  if (!checkAcquireOrderAttrCommon(S, D, Attr, Args)) {
    return;
  }
  
  type$ptr<Expr /*P*/ /*P*/> StartArg = $tryClone($AddrOf(Args.ptr$at(0)));
  D.addAttr(/*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*::*//*new (S.Context)*/ ASTContextGlobals.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->{
          return new AcquiredAfterAttr(Attr.getRange(), S.Context, 
                  StartArg, Args.size(), 
                  Attr.getAttributeSpellingListIndex());
       }));
}

//<editor-fold defaultstate="collapsed" desc="handleAcquiredBeforeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 682,
 FQN="handleAcquiredBeforeAttr", NM="_ZL24handleAcquiredBeforeAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL24handleAcquiredBeforeAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleAcquiredBeforeAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                        final /*const*/ AttributeList /*&*/ Attr) {
  SmallVector<Expr /*P*/ > Args/*J*/= new SmallVector<Expr /*P*/ >(1, (Expr /*P*/ )null);
  if (!checkAcquireOrderAttrCommon(S, D, Attr, Args)) {
    return;
  }
  
  type$ptr<Expr/*P*/> StartArg = create_type$ptr($tryClone($AddrOf(Args.$at(0))));
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new AcquiredBeforeAttr(Attr.getRange(), S.Context, 
          StartArg, Args.size(), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="checkLockFunAttrCommon">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 695,
 FQN="checkLockFunAttrCommon", NM="_ZL22checkLockFunAttrCommonRN5clang4SemaEPNS_4DeclERKNS_13AttributeListERN4llvm15SmallVectorImplIPNS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL22checkLockFunAttrCommonRN5clang4SemaEPNS_4DeclERKNS_13AttributeListERN4llvm15SmallVectorImplIPNS_4ExprEEE")
//</editor-fold>
public static boolean checkLockFunAttrCommon(final Sema /*&*/ S, Decl /*P*/ D, 
                      final /*const*/ AttributeList /*&*/ Attr, 
                      final SmallVectorImpl<Expr /*P*/ > /*&*/ Args) {
  // zero or more arguments ok
  // check that all arguments are lockable objects
  checkAttrArgsAreCapabilityObjs(S, D, Attr, Args, 0, /*ParamIdxOk=*/ true);
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="handleAssertSharedLockAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 705,
 FQN="handleAssertSharedLockAttr", NM="_ZL26handleAssertSharedLockAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL26handleAssertSharedLockAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleAssertSharedLockAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                          final /*const*/ AttributeList /*&*/ Attr) {
  SmallVector<Expr /*P*/ > Args/*J*/= new SmallVector<Expr /*P*/ >(1, (Expr /*P*/ )null);
  if (!checkLockFunAttrCommon(S, D, Attr, Args)) {
    return;
  }
  
  /*uint*/int Size = Args.size();
  type$ptr<Expr/*P*/> StartArg = create_type$ptr($tryClone(Size == 0 ? null : $AddrOf(Args.$at(0))));
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new AssertSharedLockAttr(Attr.getRange(), S.Context, StartArg, Size, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleAssertExclusiveLockAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 718,
 FQN="handleAssertExclusiveLockAttr", NM="_ZL29handleAssertExclusiveLockAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL29handleAssertExclusiveLockAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleAssertExclusiveLockAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                             final /*const*/ AttributeList /*&*/ Attr) {
  SmallVector<Expr /*P*/ > Args/*J*/= new SmallVector<Expr /*P*/ >(1, (Expr /*P*/ )null);
  if (!checkLockFunAttrCommon(S, D, Attr, Args)) {
    return;
  }
  
  /*uint*/int Size = Args.size();
  type$ptr<Expr/*P*/> StartArg = create_type$ptr($tryClone(Size == 0 ? null : $AddrOf(Args.$at(0))));
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new AssertExclusiveLockAttr(Attr.getRange(), S.Context, 
          StartArg, Size, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="checkTryLockFunAttrCommon">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 733,
 FQN="checkTryLockFunAttrCommon", NM="_ZL25checkTryLockFunAttrCommonRN5clang4SemaEPNS_4DeclERKNS_13AttributeListERN4llvm15SmallVectorImplIPNS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL25checkTryLockFunAttrCommonRN5clang4SemaEPNS_4DeclERKNS_13AttributeListERN4llvm15SmallVectorImplIPNS_4ExprEEE")
//</editor-fold>
public static boolean checkTryLockFunAttrCommon(final Sema /*&*/ S, Decl /*P*/ D, 
                         final /*const*/ AttributeList /*&*/ Attr, 
                         final SmallVectorImpl<Expr /*P*/ > /*&*/ Args) {
  if (!checkAttributeAtLeastNumArgs(S, Attr, 1)) {
    return false;
  }
  if (!isIntOrBool(Attr.getArgAsExpr(0))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_n_type)), 
                  Attr.getName()), 1), AttributeArgumentNType.AANT_ArgumentIntOrBool));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  
  // check that all arguments are lockable objects
  checkAttrArgsAreCapabilityObjs(S, D, Attr, Args, 1);
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="handleSharedTrylockFunctionAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 751,
 FQN="handleSharedTrylockFunctionAttr", NM="_ZL31handleSharedTrylockFunctionAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL31handleSharedTrylockFunctionAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleSharedTrylockFunctionAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                               final /*const*/ AttributeList /*&*/ Attr) {
  SmallVector<Expr /*P*/ > Args/*J*/= new SmallVector<Expr /*P*/ >(2, (Expr /*P*/ )null);
  if (!checkTryLockFunAttrCommon(S, D, Attr, Args)) {
    return;
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new SharedTrylockFunctionAttr(Attr.getRange(), S.Context, 
          Attr.getArgAsExpr(0), 
          Args.data(), Args.size(), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleExclusiveTrylockFunctionAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 764,
 FQN="handleExclusiveTrylockFunctionAttr", NM="_ZL34handleExclusiveTrylockFunctionAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL34handleExclusiveTrylockFunctionAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleExclusiveTrylockFunctionAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                                  final /*const*/ AttributeList /*&*/ Attr) {
  SmallVector<Expr /*P*/ > Args/*J*/= new SmallVector<Expr /*P*/ >(2, (Expr /*P*/ )null);
  if (!checkTryLockFunAttrCommon(S, D, Attr, Args)) {
    return;
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ExclusiveTrylockFunctionAttr(Attr.getRange(), S.Context, Attr.getArgAsExpr(0), Args.data(), 
          Args.size(), Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleLockReturnedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 775,
 FQN="handleLockReturnedAttr", NM="_ZL22handleLockReturnedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL22handleLockReturnedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleLockReturnedAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                      final /*const*/ AttributeList /*&*/ Attr) {
  // check that the argument is lockable object
  SmallVector<Expr /*P*/ > Args/*J*/= new SmallVector<Expr /*P*/ >(1, (Expr /*P*/ )null);
  checkAttrArgsAreCapabilityObjs(S, D, Attr, Args);
  /*uint*/int Size = Args.size();
  if (Size == 0) {
    return;
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new LockReturnedAttr(Attr.getRange(), S.Context, Args.$at(0), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleLocksExcludedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 789,
 FQN="handleLocksExcludedAttr", NM="_ZL23handleLocksExcludedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL23handleLocksExcludedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleLocksExcludedAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                       final /*const*/ AttributeList /*&*/ Attr) {
  if (!SemaDeclAttrStatics.checkAttributeAtLeastNumArgs(S, Attr, 1)) {
    return;
  }
  
  // check that all arguments are lockable objects
  SmallVector<Expr /*P*/ > Args/*J*/= new SmallVector<Expr /*P*/ >(1, (Expr /*P*/ )null);
  SemaDeclAttrStatics.checkAttrArgsAreCapabilityObjs(S, D, Attr, Args);
  /*uint*/int Size = Args.size();
  if (Size == 0) {
    return;
  }
  type$ptr<Expr /*P*/ /*P*/> StartArg = $tryClone($AddrOf(Args.ptr$at(0)));
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new LocksExcludedAttr(Attr.getRange(), S.Context, StartArg, Size, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleEnableIfAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 807,
 FQN="handleEnableIfAttr", NM="_ZL18handleEnableIfAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL18handleEnableIfAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleEnableIfAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  OptionalNotes Diags = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.ext_clang_enable_if)));
    
    Expr /*P*/ Cond = Attr.getArgAsExpr(0);
    if (!Cond.isTypeDependent()) {
      ActionResultTTrue<Expr /*P*/ > Converted = S.PerformContextuallyConvertToBool(Cond);
      if (Converted.isInvalid()) {
        return;
      }
      Cond = Converted.get();
    }
    
    StringRef Msg/*J*/= new StringRef();
    if (!S.checkStringLiteralArgumentAttr(Attr, 1, Msg)) {
      return;
    }
    
    Diags/*J*/= new OptionalNotes(8);
    if (!Cond.isValueDependent()
       && !Expr.isPotentialConstantExprUnevaluated(Cond, cast_FunctionDecl(D), 
        Diags)) {
      $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.err_enable_if_never_constant_expr)));
      for (int I = 0, N = Diags.size(); I != N; ++I)  {
        $c$.clean($c$.track(S.Diag(new SourceLocation(Diags.$at(I).first), Diags.$at(I).second)));
      }
      return;
    }
    
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new EnableIfAttr(Attr.getRange(), S.Context, Cond, new StringRef(Msg), 
            Attr.getAttributeSpellingListIndex()));
  } finally {
    if (Diags != null) { Diags.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="handlePassObjectSizeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 837,
 FQN="handlePassObjectSizeAttr", NM="_ZL24handlePassObjectSizeAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL24handlePassObjectSizeAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handlePassObjectSizeAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                        final /*const*/ AttributeList /*&*/ Attr) {
  if (D.hasAttr(PassObjectSizeAttr.class)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getLocStart(), diag.err_attribute_only_once_per_parameter)), 
          Attr.getName()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  Expr /*P*/ E = Attr.getArgAsExpr(0);
  uint$ref Type = create_uint$ref();
  if (!checkUInt32Argument(S, Attr, E, Type, /*Idx=*/ 1)) {
    return;
  }
  
  // pass_object_size's argument is passed in as the second argument of
  // __builtin_object_size. So, it has the same constraints as that second
  // argument; namely, it must be in the range [0, 3].
  if ($greater_uint(Type.$deref(), 3)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getLocStart(), diag.err_attribute_argument_outof_range)), 
                      Attr.getName()), 0), 3), E.getSourceRange()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // pass_object_size is only supported on constant pointer parameters; as a
  // kindness to users, we allow the parameter to be non-const for declarations.
  // At this point, we have no clue if `D` belongs to a function declaration or
  // definition, so we defer the constness check until later.
  if (!cast_ParmVarDecl(D).getType().$arrow().isPointerType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getLocStart(), diag.err_attribute_pointers_only)), 
              Attr.getName()), 1));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new PassObjectSizeAttr(Attr.getRange(), S.Context, (int)Type.$deref(), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleConsumableAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 874,
 FQN="handleConsumableAttr", NM="_ZL20handleConsumableAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL20handleConsumableAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleConsumableAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  type$ref<ConsumableAttr.ConsumedState> DefaultState = create_type$ref();
  if (Attr.isArgIdent(0)) {
    IdentifierLoc /*P*/ IL = Attr.getArgAsIdent(0);
    if (!ConsumableAttr.ConvertStrToConsumedState(IL.Ident.getName(), 
        DefaultState)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(IL.Loc), diag.warn_attribute_type_not_supported)), 
                Attr.getName()), IL.Ident));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_type)), 
              Attr.getName()), AttributeArgumentNType.AANT_ArgumentIdentifier));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ConsumableAttr(Attr.getRange(), S.Context, DefaultState.$deref(), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="checkForConsumableClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 896,
 FQN="checkForConsumableClass", NM="_ZL23checkForConsumableClassRN5clang4SemaEPKNS_13CXXMethodDeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL23checkForConsumableClassRN5clang4SemaEPKNS_13CXXMethodDeclERKNS_13AttributeListE")
//</editor-fold>
public static boolean checkForConsumableClass(final Sema /*&*/ S, /*const*/ CXXMethodDecl /*P*/ MD, 
                       final /*const*/ AttributeList /*&*/ Attr) {
  final ASTContext /*&*/ CurrContext = S.getASTContext();
  QualType ThisType = MD.getThisType(CurrContext).$arrow().getPointeeType();
  {
    
    /*const*/ CXXRecordDecl /*P*/ RD = ThisType.$arrow().getAsCXXRecordDecl();
    if ((RD != null)) {
      if (!RD.hasAttr(ConsumableAttr.class)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attr_on_unconsumable_class)), 
              RD.getNameAsString()));
          
          return false;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="handleCallableWhenAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 913,
 FQN="handleCallableWhenAttr", NM="_ZL22handleCallableWhenAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL22handleCallableWhenAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleCallableWhenAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                      final /*const*/ AttributeList /*&*/ Attr) {
  if (!checkAttributeAtLeastNumArgs(S, Attr, 1)) {
    return;
  }
  if (!checkForConsumableClass(S, cast_CXXMethodDecl(D), Attr)) {
    return;
  }
  
  SmallVector<CallableWhenAttr.ConsumedState> States/*J*/= new SmallVector<CallableWhenAttr.ConsumedState>(3, CallableWhenAttr.ConsumedState.valueOf(0));
  for (/*uint*/int ArgIndex = 0; $less_uint(ArgIndex, Attr.getNumArgs()); ++ArgIndex) {
    type$ref<CallableWhenAttr.ConsumedState> CallableState = create_type$ref();
    
    StringRef StateString/*J*/= new StringRef();
    type$ptr<SourceLocation> Loc/*J*/= create_type$ptr(new SourceLocation());
    if (Attr.isArgIdent(ArgIndex)) {
      IdentifierLoc /*P*/ Ident = Attr.getArgAsIdent(ArgIndex);
      StateString.$assignMove(Ident.Ident.getName());
      Loc.$set(Ident.Loc);
    } else {
      if (!S.checkStringLiteralArgumentAttr(Attr, ArgIndex, StateString, $AddrOf(Loc))) {
        return;
      }
    }
    if (!CallableWhenAttr.ConvertStrToConsumedState(new StringRef(StateString), 
        CallableState)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc.$star()), diag.warn_attribute_type_not_supported)), 
                Attr.getName()), StateString));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    States.push_back(CallableState.$deref());
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new CallableWhenAttr(Attr.getRange(), S.Context, States.data(), 
          States.size(), Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleParamTypestateAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 951,
 FQN="handleParamTypestateAttr", NM="_ZL24handleParamTypestateAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL24handleParamTypestateAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleParamTypestateAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                        final /*const*/ AttributeList /*&*/ Attr) {
  type$ref<ParamTypestateAttr.ConsumedState> ParamState = create_type$ref();
  if (Attr.isArgIdent(0)) {
    IdentifierLoc /*P*/ Ident = Attr.getArgAsIdent(0);
    StringRef StateString = Ident.Ident.getName();
    if (!ParamTypestateAttr.ConvertStrToConsumedState(new StringRef(StateString), 
        ParamState)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Ident.Loc), diag.warn_attribute_type_not_supported)), 
                Attr.getName()), StateString));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_type)), 
              Attr.getName()), AttributeArgumentNType.AANT_ArgumentIdentifier));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // FIXME: This check is currently being done in the analysis.  It can be
  //        enabled here only after the parser propagates attributes at
  //        template specialization definition, not declaration.
  //QualType ReturnType = cast<ParmVarDecl>(D)->getType();
  //const CXXRecordDecl *RD = ReturnType->getAsCXXRecordDecl();
  //
  //if (!RD || !RD->hasAttr<ConsumableAttr>()) {
  //    S.Diag(Attr.getLoc(), diag::warn_return_state_for_unconsumable_type) <<
  //      ReturnType.getAsString();
  //    return;
  //}
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ParamTypestateAttr(Attr.getRange(), S.Context, ParamState.$deref(), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleReturnTypestateAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 988,
 FQN="handleReturnTypestateAttr", NM="_ZL25handleReturnTypestateAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL25handleReturnTypestateAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleReturnTypestateAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                         final /*const*/ AttributeList /*&*/ Attr) {
  type$ref<ReturnTypestateAttr.ConsumedState> ReturnState = create_type$ref();
  if (Attr.isArgIdent(0)) {
    IdentifierLoc /*P*/ IL = Attr.getArgAsIdent(0);
    if (!ReturnTypestateAttr.ConvertStrToConsumedState(IL.Ident.getName(), 
        ReturnState)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(IL.Loc), diag.warn_attribute_type_not_supported)), 
                Attr.getName()), IL.Ident));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_type)), 
              Attr.getName()), AttributeArgumentNType.AANT_ArgumentIdentifier));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // FIXME: This check is currently being done in the analysis.  It can be
  //        enabled here only after the parser propagates attributes at
  //        template specialization definition, not declaration.
  //QualType ReturnType;
  //
  //if (const ParmVarDecl *Param = dyn_cast<ParmVarDecl>(D)) {
  //  ReturnType = Param->getType();
  //
  //} else if (const CXXConstructorDecl *Constructor =
  //             dyn_cast<CXXConstructorDecl>(D)) {
  //  ReturnType = Constructor->getThisType(S.getASTContext())->getPointeeType();
  //  
  //} else {
  //  
  //  ReturnType = cast<FunctionDecl>(D)->getCallResultType();
  //}
  //
  //const CXXRecordDecl *RD = ReturnType->getAsCXXRecordDecl();
  //
  //if (!RD || !RD->hasAttr<ConsumableAttr>()) {
  //    S.Diag(Attr.getLoc(), diag::warn_return_state_for_unconsumable_type) <<
  //      ReturnType.getAsString();
  //    return;
  //}
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ReturnTypestateAttr(Attr.getRange(), S.Context, ReturnState.$deref(), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleSetTypestateAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1036,
 FQN="handleSetTypestateAttr", NM="_ZL22handleSetTypestateAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL22handleSetTypestateAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleSetTypestateAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  if (!checkForConsumableClass(S, cast_CXXMethodDecl(D), Attr)) {
    return;
  }
  
  type$ref<SetTypestateAttr.ConsumedState> NewState = create_type$ref();
  if (Attr.isArgIdent(0)) {
    IdentifierLoc /*P*/ Ident = Attr.getArgAsIdent(0);
    StringRef Param = Ident.Ident.getName();
    if (!SetTypestateAttr.ConvertStrToConsumedState(new StringRef(Param), NewState)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Ident.Loc), diag.warn_attribute_type_not_supported)), 
                Attr.getName()), Param));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_type)), 
              Attr.getName()), AttributeArgumentNType.AANT_ArgumentIdentifier));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new SetTypestateAttr(Attr.getRange(), S.Context, NewState.$deref(), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleTestTypestateAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1060,
 FQN="handleTestTypestateAttr", NM="_ZL23handleTestTypestateAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL23handleTestTypestateAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleTestTypestateAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                       final /*const*/ AttributeList /*&*/ Attr) {
  if (!checkForConsumableClass(S, cast_CXXMethodDecl(D), Attr)) {
    return;
  }
  
  type$ref<TestTypestateAttr.ConsumedState> TestState = create_type$ref();
  if (Attr.isArgIdent(0)) {
    IdentifierLoc /*P*/ Ident = Attr.getArgAsIdent(0);
    StringRef Param = Ident.Ident.getName();
    if (!TestTypestateAttr.ConvertStrToConsumedState(new StringRef(Param), TestState)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Ident.Loc), diag.warn_attribute_type_not_supported)), 
                Attr.getName()), Param));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_type)), 
              Attr.getName()), AttributeArgumentNType.AANT_ArgumentIdentifier));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new TestTypestateAttr(Attr.getRange(), S.Context, TestState.$deref(), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleExtVectorTypeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1085,
 FQN="handleExtVectorTypeAttr", NM="_ZL23handleExtVectorTypeAttrRN5clang4SemaEPNS_5ScopeEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL23handleExtVectorTypeAttrRN5clang4SemaEPNS_5ScopeEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleExtVectorTypeAttr(final Sema /*&*/ S, Scope /*P*/ scope, Decl /*P*/ D, 
                       final /*const*/ AttributeList /*&*/ Attr) {
  // Remember this typedef decl, we will need it later for diagnostics.
  S.ExtVectorDecls.push_back(cast_TypedefNameDecl(D));
}

//<editor-fold defaultstate="collapsed" desc="handlePackedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1091,
 FQN="handlePackedAttr", NM="_ZL16handlePackedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL16handlePackedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handlePackedAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  {
    TagDecl /*P*/ TD = dyn_cast_TagDecl(D);
    if ((TD != null)) {
      TD.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new PackedAttr(Attr.getRange(), S.Context, 
              Attr.getAttributeSpellingListIndex()));
    } else {
      FieldDecl /*P*/ FD = dyn_cast_FieldDecl(D);
      if ((FD != null)) {
        // Report warning about changed offset in the newer compiler versions.
        if (!FD.getType().$arrow().isDependentType()
           && !FD.getType().$arrow().isIncompleteType() && FD.isBitField()
           && $lesseq_uint(S.Context.getTypeAlign(FD.getType()), 8)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_packed_for_bitfield)));
          } finally {
            $c$.$destroy();
          }
        }
        
        FD.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new PackedAttr(Attr.getRange(), S.Context, Attr.getAttributeSpellingListIndex()));
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_ignored)), Attr.getName()));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="checkIBOutletCommon">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1108,
 FQN="checkIBOutletCommon", NM="_ZL19checkIBOutletCommonRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL19checkIBOutletCommonRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static boolean checkIBOutletCommon(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  {
    // The IBOutlet/IBOutletCollection attributes only apply to instance
    // variables or properties of Objective-C classes.  The outlet must also
    // have an object reference type.
    /*const*/ ObjCIvarDecl /*P*/ VD = dyn_cast_ObjCIvarDecl(D);
    if ((VD != null)) {
      if (!(VD.getType().$arrow().getAs(ObjCObjectPointerType.class) != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_iboutlet_object_type)), 
                      Attr.getName()), VD.getType()), 0));
          return false;
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      /*const*/ ObjCPropertyDecl /*P*/ PD = dyn_cast_ObjCPropertyDecl(D);
      if ((PD != null)) {
        if (!(PD.getType().$arrow().getAs(ObjCObjectPointerType.class) != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_iboutlet_object_type)), 
                        Attr.getName()), PD.getType()), 1));
            return false;
          } finally {
            $c$.$destroy();
          }
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_iboutlet)), Attr.getName()));
          return false;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="handleIBOutlet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1134,
 FQN="handleIBOutlet", NM="_ZL14handleIBOutletRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL14handleIBOutletRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleIBOutlet(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  if (!checkIBOutletCommon(S, D, Attr)) {
    return;
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new IBOutletAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleIBOutletCollection">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1143,
 FQN="handleIBOutletCollection", NM="_ZL24handleIBOutletCollectionRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL24handleIBOutletCollectionRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleIBOutletCollection(final Sema /*&*/ S, Decl /*P*/ D, 
                        final /*const*/ AttributeList /*&*/ Attr) {
  
  // The iboutletcollection attribute can have zero or one arguments.
  if ($greater_uint(Attr.getNumArgs(), 1)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_number_arguments)), 
              Attr.getName()), 1));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (!checkIBOutletCommon(S, D, Attr)) {
    return;
  }
  
  OpaquePtr<QualType> PT/*J*/= new OpaquePtr<QualType>();
  if (Attr.hasParsedType()) {
    PT.$assign(Attr.getTypeArg());
  } else {
    PT.$assignMove(S.getTypeName(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"NSObject")), Attr.getLoc(), 
            S.getScopeForContext(D.getDeclContext().getParent())));
    if (!PT.$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_iboutletcollection_type)), /*KEEP_STR*/"NSObject"));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  type$ptr<TypeSourceInfo /*P*/ > QTLoc = create_type$ptr((TypeSourceInfo)null);
  QualType QT = S.GetTypeFromParser(new OpaquePtr<QualType>(PT), QTLoc);
  if (!(QTLoc.$star() != null)) {
    QTLoc.$set(S.Context.getTrivialTypeSourceInfo(new QualType(QT), Attr.getLoc()));
  }
  
  // Diagnose use of non-object type in iboutletcollection attribute.
  // FIXME. Gnu attribute extension ignores use of builtin types in
  // attributes. So, __attribute__((iboutletcollection(char))) will be
  // treated as __attribute__((iboutletcollection())).
  if (!QT.$arrow().isObjCIdType() && !QT.$arrow().isObjCObjectType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), 
              QT.$arrow().isBuiltinType() ? diag.err_iboutletcollection_builtintype : diag.err_iboutletcollection_type)), QT));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new IBOutletCollectionAttr(Attr.getRange(), S.Context, QTLoc.$star(), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="attrNonNullArgCheck">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1214,
 FQN="attrNonNullArgCheck", NM="_ZL19attrNonNullArgCheckRN5clang4SemaENS_8QualTypeERKNS_13AttributeListENS_11SourceRangeES6_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL19attrNonNullArgCheckRN5clang4SemaENS_8QualTypeERKNS_13AttributeListENS_11SourceRangeES6_b")
//</editor-fold>
public static boolean attrNonNullArgCheck(final Sema /*&*/ S, QualType T, final /*const*/ AttributeList /*&*/ Attr, 
                   SourceRange AttrParmRange, 
                   SourceRange TypeRange) {
  return attrNonNullArgCheck(S, T, Attr, 
                   AttrParmRange, 
                   TypeRange, 
                   false);
}
public static boolean attrNonNullArgCheck(final Sema /*&*/ S, QualType T, final /*const*/ AttributeList /*&*/ Attr, 
                   SourceRange AttrParmRange, 
                   SourceRange TypeRange, 
                   boolean isReturnValue/*= false*/) {
  if (!S.isValidPointerAttrType(new QualType(T))) {
    if (isReturnValue) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_return_pointers_only)), 
                    Attr.getName()), AttrParmRange), TypeRange));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_pointers_only)), 
                        Attr.getName()), AttrParmRange), TypeRange), 0));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="handleNonNullAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1230,
 FQN="handleNonNullAttr", NM="_ZL17handleNonNullAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL17handleNonNullAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleNonNullAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  SmallVectorUInt NonNullArgs/*J*/= new SmallVectorUInt(8, 0);
  for (/*uint*/int I = 0; $less_uint(I, Attr.getNumArgs()); ++I) {
    Expr /*P*/ Ex = Attr.getArgAsExpr(I);
    ulong$ref Idx = create_ulong$ref(0);
    if (!checkFunctionOrMethodParameterIndex(S, D, Attr, I + 1, Ex, Idx)) {
      return;
    }
    
    // Is the function argument a pointer type?
    if ($less_ulong_uint(Idx.$deref(), getFunctionOrMethodNumParams(D))
       && !attrNonNullArgCheck(S, getFunctionOrMethodParamType(D, $ulong2uint(Idx.$deref())), Attr, 
        Ex.getSourceRange(), 
        getFunctionOrMethodParamRange(D, $ulong2uint(Idx.$deref())))) {
      continue;
    }
    
    NonNullArgs.push_back($ulong2uint(Idx.$deref()));
  }
  
  // If no arguments were specified to __attribute__((nonnull)) then all pointer
  // arguments have a nonnull attribute; warn if there aren't any. Skip this
  // check if the attribute came from a macro expansion or a template
  // instantiation.
  if (NonNullArgs.empty() && Attr.getLoc().isFileID()
     && S.ActiveTemplateInstantiations.empty()) {
    boolean AnyPointers = isFunctionOrMethodVariadic(D);
    for (/*uint*/int I = 0, E = getFunctionOrMethodNumParams(D);
         I != E && !AnyPointers; ++I) {
      QualType T = getFunctionOrMethodParamType(D, I);
      if (T.$arrow().isDependentType() || S.isValidPointerAttrType(new QualType(T))) {
        AnyPointers = true;
      }
    }
    if (!AnyPointers) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_nonnull_no_pointers)));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  uint$ptr/*uint P*/ Start = $tryClone(NonNullArgs.data());
  /*uint*/int Size = NonNullArgs.size();
  llvm.array_pod_sort(Start, Start.$add(Size));
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new NonNullAttr(Attr.getRange(), S.Context, Start, Size, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleNonNullAttrParameter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1274,
 FQN="handleNonNullAttrParameter", NM="_ZL26handleNonNullAttrParameterRN5clang4SemaEPNS_11ParmVarDeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL26handleNonNullAttrParameterRN5clang4SemaEPNS_11ParmVarDeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleNonNullAttrParameter(final Sema /*&*/ S, ParmVarDecl /*P*/ D, 
                          final /*const*/ AttributeList /*&*/ Attr) {
  if ($greater_uint(Attr.getNumArgs(), 0)) {
    if ((D.getFunctionType() != null)) {
      handleNonNullAttr(S, D, Attr);
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_nonnull_parm_no_args)), 
            D.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
    return;
  }
  
  // Is the argument a pointer type?
  if (!attrNonNullArgCheck(S, D.getType(), Attr, new SourceRange(), 
      D.getSourceRange())) {
    return;
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new NonNullAttr(Attr.getRange(), S.Context, (uint$ptr/*uint P*/ )null, 0, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleReturnsNonNullAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1296,
 FQN="handleReturnsNonNullAttr", NM="_ZL24handleReturnsNonNullAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL24handleReturnsNonNullAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleReturnsNonNullAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                        final /*const*/ AttributeList /*&*/ Attr) {
  QualType ResultType = getFunctionOrMethodResultType(D);
  SourceRange SR = getFunctionOrMethodResultSourceRange(D);
  if (!attrNonNullArgCheck(S, new QualType(ResultType), Attr, new SourceRange(), new SourceRange(SR), 
      /* isReturnValue */ true)) {
    return;
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ReturnsNonNullAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleAssumeAlignedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1309,
 FQN="handleAssumeAlignedAttr", NM="_ZL23handleAssumeAlignedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL23handleAssumeAlignedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleAssumeAlignedAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                       final /*const*/ AttributeList /*&*/ Attr) {
  Expr /*P*/ E = Attr.getArgAsExpr(0), 
      /*P*/ OE = $greater_uint(Attr.getNumArgs(), 1) ? Attr.getArgAsExpr(1) : null;
  S.AddAssumeAlignedAttr(Attr.getRange(), D, E, OE, 
      Attr.getAttributeSpellingListIndex());
}


/// Normalize the attribute, __foo__ becomes foo.
/// Returns true if normalization was applied.
//<editor-fold defaultstate="collapsed" desc="normalizeName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1370,
 FQN="normalizeName", NM="_ZL13normalizeNameRN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL13normalizeNameRN4llvm9StringRefE")
//</editor-fold>
public static boolean normalizeName(final StringRef /*&*/ AttrName) {
  if ($greater_uint(AttrName.size(), 4) && AttrName.startswith(/*STRINGREF_STR*/"__")
     && AttrName.endswith(/*STRINGREF_STR*/"__")) {
    AttrName.$assignMove(AttrName.drop_front(2).drop_back(2));
    return true;
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="handleOwnershipAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1379,
 FQN="handleOwnershipAttr", NM="_ZL19handleOwnershipAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL19handleOwnershipAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleOwnershipAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ AL) {
  // This attribute must be applied to a function declaration. The first
  // argument to the attribute must be an identifier, the name of the resource,
  // for example: malloc. The following arguments must be argument indexes, the
  // arguments must be of integer type for Returns, otherwise of pointer type.
  // The difference between Holds and Takes is that a pointer may still be used
  // after being held. free() should be __attribute((ownership_takes)), whereas
  // a list append function may well be __attribute((ownership_holds)).
  if (!AL.isArgIdent(0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(AL.getLoc(), diag.err_attribute_argument_n_type)), 
                  AL.getName()), 1), AttributeArgumentNType.AANT_ArgumentIdentifier));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Figure out our Kind.
  OwnershipAttr.OwnershipKind K = new OwnershipAttr(new SourceRange(AL.getLoc()), S.Context, (IdentifierInfo /*P*/ )null, (uint$ptr/*uint P*/ )null, 0, 
      AL.getAttributeSpellingListIndex()).getOwnKind();
  
  // Check arguments.
  switch (K) {
   case Takes:
   case Holds:
    if ($less_uint(AL.getNumArgs(), 2)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(AL.getLoc(), diag.err_attribute_too_few_arguments)), 
                AL.getName()), 2));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    break;
   case Returns:
    if ($greater_uint(AL.getNumArgs(), 2)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(AL.getLoc(), diag.err_attribute_too_many_arguments)), 
                AL.getName()), 1));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    break;
  }
  
  IdentifierInfo /*P*/ Module = AL.getArgAsIdent(0).Ident;
  
  StringRef ModuleName = Module.getName();
  if (normalizeName(ModuleName)) {
    Module = $AddrOf(S.PP.getIdentifierTable().get(/*NO_COPY*/ModuleName));
  }
  
  SmallVectorUInt OwnershipArgs/*J*/= new SmallVectorUInt(8, 0);
  for (/*uint*/int i = 1; $less_uint(i, AL.getNumArgs()); ++i) {
    Expr /*P*/ Ex = AL.getArgAsExpr(i);
    ulong$ref Idx = create_ulong$ref(0);
    if (!checkFunctionOrMethodParameterIndex(S, D, AL, i, Ex, Idx)) {
      return;
    }
    
    // Is the function argument a pointer type?
    QualType T = getFunctionOrMethodParamType(D, $ulong2uint(Idx.$deref()));
    int Err = -1; // No error
    switch (K) {
     case Takes:
     case Holds:
      if (!T.$arrow().isAnyPointerType() && !T.$arrow().isBlockPointerType()) {
        Err = 0;
      }
      break;
     case Returns:
      if (!T.$arrow().isIntegerType()) {
        Err = 1;
      }
      break;
    }
    if (-1 != Err) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(AL.getLoc(), diag.err_ownership_type)), AL.getName()), Err), 
            Ex.getSourceRange()));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Check we don't have a conflict with another ownership attribute.
    for (/*const*/ OwnershipAttr /*P*/ I : D.specific_attrs(OwnershipAttr.class)) {
      // Cannot have two ownership attributes of different kinds for the same
      // index.
      if (I.getOwnKind() != K && $noteq_ptr(I.args_end(), std.find(I.args_begin(), I.args_end(), $ulong2uint(Idx.$deref())))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(AL.getLoc(), diag.err_attributes_are_not_compatible)), 
                  AL.getName()), I));
          return;
        } finally {
          $c$.$destroy();
        }
      } else if (K == OwnershipAttr.OwnershipKind.Returns
         && I.getOwnKind() == OwnershipAttr.OwnershipKind.Returns) {
        // A returns attribute conflicts with any other returns attribute using
        // a different index. Note, diagnostic reporting is 1-based, but stored
        // argument indexes are 0-based.
        if ($eq_ptr(std.find(I.args_begin(), I.args_end(), $ulong2uint(Idx.$deref())), I.args_end())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(I.getLocation(), diag.err_ownership_returns_index_mismatch)), 
                (I.args_begin()).$star() + 1));
            if ((I.args_size() != 0)) {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(AL.getLoc(), diag.note_ownership_returns_index_mismatch)), 
                      (/*uint*/int)$ulong2uint(Idx.$deref()) + 1), Ex.getSourceRange()));
            }
            return;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    OwnershipArgs.push_back($ulong2uint(Idx.$deref()));
  }
  
  uint$ptr/*uint P*/ start = $tryClone(OwnershipArgs.data());
  /*uint*/int size = OwnershipArgs.size();
  llvm.array_pod_sort(start, start.$add(size));
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new OwnershipAttr(new SourceRange(AL.getLoc()), S.Context, Module, start, size, 
          AL.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleWeakRefAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1488,
 FQN="handleWeakRefAttr", NM="_ZL17handleWeakRefAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL17handleWeakRefAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleWeakRefAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  // Check the attribute arguments.
  if ($greater_uint(Attr.getNumArgs(), 1)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_number_arguments)), 
              Attr.getName()), 1));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  NamedDecl /*P*/ nd = cast_NamedDecl(D);
  
  // gcc rejects
  // class c {
  //   static int a __attribute__((weakref ("v2")));
  //   static int b() __attribute__((weakref ("f3")));
  // };
  // and ignores the attributes of
  // void f(void) {
  //   static int a __attribute__((weakref ("v2")));
  // }
  // we reject them
  /*const*/ DeclContext /*P*/ Ctx = D.getDeclContext().getRedeclContext();
  if (!Ctx.isFileContext()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_weakref_not_global_context)), 
          nd));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // The GCC manual says
  //
  // At present, a declaration to which `weakref' is attached can only
  // be `static'.
  //
  // It also says
  //
  // Without a TARGET,
  // given as an argument to `weakref' or to `alias', `weakref' is
  // equivalent to `weak'.
  //
  // gcc 4.4.1 will accept
  // int a7 __attribute__((weakref));
  // as
  // int a7 __attribute__((weak));
  // This looks like a bug in gcc. We reject that for now. We should revisit
  // it if this behaviour is actually used.
  
  // GCC rejects
  // static ((alias ("y"), weakref)).
  // Should we? How to check that weakref is before or after alias?
  
  // FIXME: it would be good for us to keep the WeakRefAttr as-written instead
  // of transforming it into an AliasAttr.  The WeakRefAttr never uses the
  // StringRef parameter it was given anyway.
  StringRef Str/*J*/= new StringRef();
  if ((Attr.getNumArgs() != 0) && S.checkStringLiteralArgumentAttr(Attr, 0, Str)) {
    // GCC will accept anything as the argument of weakref. Should we
    // check for an existing decl?
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new AliasAttr(Attr.getRange(), S.Context, new StringRef(Str), 
            Attr.getAttributeSpellingListIndex()));
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new WeakRefAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleIFuncAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1552,
 FQN="handleIFuncAttr", NM="_ZL15handleIFuncAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL15handleIFuncAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleIFuncAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  StringRef Str/*J*/= new StringRef();
  if (!S.checkStringLiteralArgumentAttr(Attr, 0, Str)) {
    return;
  }
  
  // Aliases should be on declarations, not definitions.
  /*const*/ FunctionDecl /*P*/ FD = cast_FunctionDecl(D);
  if (FD.isThisDeclarationADefinition()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_alias_is_definition)), FD), 1));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  // FIXME: it should be handled as a target specific attribute.
  if (S.Context.getTargetInfo().getTriple().getObjectFormat()
     != Triple.ObjectFormatType.ELF) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_ignored)), Attr.getName()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new IFuncAttr(Attr.getRange(), S.Context, new StringRef(Str), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleAliasAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1574,
 FQN="handleAliasAttr", NM="_ZL15handleAliasAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL15handleAliasAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleAliasAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  StringRef Str/*J*/= new StringRef();
  if (!S.checkStringLiteralArgumentAttr(Attr, 0, Str)) {
    return;
  }
  if (S.Context.getTargetInfo().getTriple().isOSDarwin()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.err_alias_not_supported_on_darwin)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (S.Context.getTargetInfo().getTriple().isNVPTX()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.err_alias_not_supported_on_nvptx)));
    } finally {
      $c$.$destroy();
    }
  }
  {
    
    // Aliases should be on declarations, not definitions.
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
    if ((FD != null)) {
      if (FD.isThisDeclarationADefinition()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_alias_is_definition)), FD), 0));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      /*const*/ VarDecl /*P*/ VD = cast_VarDecl(D);
      if ((VD.isThisDeclarationADefinition().getValue() != 0) && VD.isExternallyVisible()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_alias_is_definition)), VD), 0));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // FIXME: check if target symbol exists in current file
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new AliasAttr(Attr.getRange(), S.Context, new StringRef(Str), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleColdAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1607,
 FQN="handleColdAttr", NM="_ZL14handleColdAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL14handleColdAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleColdAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  if (checkAttrMutualExclusion(HotAttr.class, S, D, Attr.getRange(), Attr.getName())) {
    return;
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ColdAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleHotAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1615,
 FQN="handleHotAttr", NM="_ZL13handleHotAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL13handleHotAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleHotAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  if (checkAttrMutualExclusion(ColdAttr.class, S, D, Attr.getRange(), Attr.getName())) {
    return;
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new HotAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleTLSModelAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1623,
 FQN="handleTLSModelAttr", NM="_ZL18handleTLSModelAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL18handleTLSModelAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleTLSModelAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                  final /*const*/ AttributeList /*&*/ Attr) {
  StringRef Model/*J*/= new StringRef();
  type$ptr<SourceLocation> LiteralLoc/*J*/= create_type$ptr(new SourceLocation());
  // Check that it is a string.
  if (!S.checkStringLiteralArgumentAttr(Attr, 0, Model, $AddrOf(LiteralLoc))) {
    return;
  }
  
  // Check that the value.
  if ($noteq_StringRef(/*NO_COPY*/Model, /*STRINGREF_STR*/"global-dynamic") && $noteq_StringRef(/*NO_COPY*/Model, /*STRINGREF_STR*/"local-dynamic")
     && $noteq_StringRef(/*NO_COPY*/Model, /*STRINGREF_STR*/"initial-exec") && $noteq_StringRef(/*NO_COPY*/Model, /*STRINGREF_STR*/"local-exec")) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(new SourceLocation(LiteralLoc.$star()), diag.err_attr_tlsmodel_arg)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new TLSModelAttr(Attr.getRange(), S.Context, new StringRef(Model), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleRestrictAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1643,
 FQN="handleRestrictAttr", NM="_ZL18handleRestrictAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL18handleRestrictAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleRestrictAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    QualType ResultType = getFunctionOrMethodResultType(D);
    if (ResultType.$arrow().isAnyPointerType() || ResultType.$arrow().isBlockPointerType()) {
      D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new RestrictAttr(Attr.getRange(), S.Context, Attr.getAttributeSpellingListIndex()));
      return;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_return_pointers_only)), 
            Attr.getName()), getFunctionOrMethodResultSourceRange(D)));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="handleCommonAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1655,
 FQN="handleCommonAttr", NM="_ZL16handleCommonAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL16handleCommonAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleCommonAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  if (S.LangOpts.CPlusPlus) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_not_supported_in_lang)), 
              Attr.getName()), LANG.Cpp));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  {
    
    CommonAttr /*P*/ CA = S.mergeCommonAttr(D, Attr.getRange(), Attr.getName(), 
        Attr.getAttributeSpellingListIndex());
    if ((CA != null)) {
      D.addAttr(CA);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="handleNakedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1667,
 FQN="handleNakedAttr", NM="_ZL15handleNakedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL15handleNakedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleNakedAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  if (checkAttrMutualExclusion(DisableTailCallsAttr.class, S, D, Attr.getRange(), 
      Attr.getName())) {
    return;
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new NakedAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleNoReturnAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1676,
 FQN="handleNoReturnAttr", NM="_ZL18handleNoReturnAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL18handleNoReturnAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleNoReturnAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ attr) {
  if (hasDeclarator(D)) {
    return;
  }
  if (S.CheckNoReturnAttr(attr)) {
    return;
  }
  if (!isa_ObjCMethodDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              attr.getName()), AttributeDeclKind.ExpectedFunctionOrMethod));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new NoReturnAttr(attr.getRange(), S.Context, 
          attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleAnalyzerNoReturnAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1701,
 FQN="handleAnalyzerNoReturnAttr", NM="_ZL26handleAnalyzerNoReturnAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL26handleAnalyzerNoReturnAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleAnalyzerNoReturnAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                          final /*const*/ AttributeList /*&*/ Attr) {
  
  // The checking path for 'noreturn' and 'analyzer_noreturn' are different
  // because 'analyzer_noreturn' does not impact the type.
  if (!isFunctionOrMethodOrBlock(D)) {
    ValueDecl /*P*/ VD = dyn_cast_ValueDecl(D);
    if (!(VD != null) || (!VD.getType().$arrow().isBlockPointerType()
       && !VD.getType().$arrow().isFunctionPointerType())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), 
                    Attr.isCXX11Attribute() ? diag.err_attribute_wrong_decl_type : diag.warn_attribute_wrong_decl_type)), 
                Attr.getName()), AttributeDeclKind.ExpectedFunctionMethodOrBlock));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new AnalyzerNoReturnAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}


// PS3 PPU-specific.
//<editor-fold defaultstate="collapsed" desc="handleVecReturnAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1724,
 FQN="handleVecReturnAttr", NM="_ZL19handleVecReturnAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL19handleVecReturnAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleVecReturnAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  {
    /*
    Returning a Vector Class in Registers
    
    According to the PPU ABI specifications, a class with a single member of 
    vector type is returned in memory when used as the return value of a function.
    This results in inefficient code when implementing vector classes. To return
    the value in a single vector register, add the vecreturn attribute to the
    class definition. This attribute is also applicable to struct types.
    
    Example:
    
    struct Vector
    {
    __vector float xyzw;
    } __attribute__((vecreturn));
    
    Vector Add(Vector lhs, Vector rhs)
    {
    Vector result;
    result.xyzw = vec_add(lhs.xyzw, rhs.xyzw);
    return result; // This will be returned in a register
    }
    */
    VecReturnAttr /*P*/ A = D.getAttr(VecReturnAttr.class);
    if ((A != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_repeat_attribute)), A));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  RecordDecl /*P*/ record = cast_RecordDecl(D);
  int count = 0;
  if (!isa_CXXRecordDecl(record)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_vecreturn_only_vector_member)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (!cast_CXXRecordDecl(record).isPOD()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_vecreturn_only_pod_record)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  for (/*const*/ FieldDecl /*P*/ I : record.fields()) {
    if ((count == 1) || !I.getType().$arrow().isVectorType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_vecreturn_only_vector_member)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    count++;
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new VecReturnAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleDependencyAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1779,
 FQN="handleDependencyAttr", NM="_ZL20handleDependencyAttrRN5clang4SemaEPNS_5ScopeEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL20handleDependencyAttrRN5clang4SemaEPNS_5ScopeEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleDependencyAttr(final Sema /*&*/ S, Scope /*P*/ $Scope, Decl /*P*/ D, 
                    final /*const*/ AttributeList /*&*/ Attr) {
  if (isa_ParmVarDecl(D)) {
    // [[carries_dependency]] can only be applied to a parameter if it is a
    // parameter of a function declaration or lambda.
    if (!(($Scope.getFlags() & Scope.ScopeFlags.FunctionDeclarationScope) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(Attr.getLoc(), 
            diag.err_carries_dependency_param_not_function_decl)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new CarriesDependencyAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleNotTailCalledAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1796,
 FQN="handleNotTailCalledAttr", NM="_ZL23handleNotTailCalledAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL23handleNotTailCalledAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleNotTailCalledAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                       final /*const*/ AttributeList /*&*/ Attr) {
  if (checkAttrMutualExclusion(AlwaysInlineAttr.class, S, D, Attr.getRange(), 
      Attr.getName())) {
    return;
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new NotTailCalledAttr(Attr.getRange(), S.Context, Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleDisableTailCallsAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1806,
 FQN="handleDisableTailCallsAttr", NM="_ZL26handleDisableTailCallsAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL26handleDisableTailCallsAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleDisableTailCallsAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                          final /*const*/ AttributeList /*&*/ Attr) {
  if (checkAttrMutualExclusion(NakedAttr.class, S, D, Attr.getRange(), 
      Attr.getName())) {
    return;
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new DisableTailCallsAttr(Attr.getRange(), S.Context, Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleUsedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1816,
 FQN="handleUsedAttr", NM="_ZL14handleUsedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL14handleUsedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleUsedAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  {
    /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    if ((VD != null)) {
      if (VD.hasLocalStorage()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_ignored)), Attr.getName()));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    } else if (!isFunctionOrMethod(D)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
                Attr.getName()), AttributeDeclKind.ExpectedVariableOrFunction));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new UsedAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleUnusedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1833,
 FQN="handleUnusedAttr", NM="_ZL16handleUnusedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL16handleUnusedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleUnusedAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  boolean IsCXX1zAttr = Attr.isCXX11Attribute() && !(Attr.getScopeName() != null);
  if (IsCXX1zAttr && isa_VarDecl(D)) {
    // The C++1z spelling of this attribute cannot be applied to a static data
    // member per [dcl.attr.unused]p2.
    if (cast_VarDecl(D).isStaticDataMember()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
                Attr.getName()), AttributeDeclKind.ExpectedForMaybeUnused));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // If this is spelled as the standard C++1z attribute, but not in C++1z, warn
  // about using it as an extension.
  if (!S.getLangOpts().CPlusPlus1z && IsCXX1zAttr) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.ext_cxx1z_attr)), Attr.getName()));
    } finally {
      $c$.$destroy();
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new UnusedAttr(Attr.getRange(), S.Context, Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleConstructorAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1855,
 FQN="handleConstructorAttr", NM="_ZL21handleConstructorAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL21handleConstructorAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleConstructorAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  uint$ref priority = create_uint$ref(ConstructorAttr.DefaultPriority);
  if ((Attr.getNumArgs() != 0)
     && !checkUInt32Argument(S, Attr, Attr.getArgAsExpr(0), priority)) {
    return;
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ConstructorAttr(Attr.getRange(), S.Context, priority.$deref(), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleDestructorAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1866,
 FQN="handleDestructorAttr", NM="_ZL20handleDestructorAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL20handleDestructorAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleDestructorAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  uint$ref priority = create_uint$ref(DestructorAttr.DefaultPriority);
  if ((Attr.getNumArgs() != 0)
     && !checkUInt32Argument(S, Attr, Attr.getArgAsExpr(0), priority)) {
    return;
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new DestructorAttr(Attr.getRange(), S.Context, priority.$deref(), 
          Attr.getAttributeSpellingListIndex()));
}

/*template <typename AttrTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="handleAttrWithMessage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1878,
 FQN="handleAttrWithMessage", NM="Tpl__ZL21handleAttrWithMessageRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=Tpl__ZL21handleAttrWithMessageRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static </*typename*/ AttrTy> void handleAttrWithMessage(Class<AttrTy> AttrTyClass, final Sema /*&*/ S, Decl /*P*/ D, 
                     final /*const*/ AttributeList /*&*/ Attr) {
  // Handle the case where the attribute has a text message.
  StringRef Str/*J*/= new StringRef();
  if (Attr.getNumArgs() == 1 && !S.checkStringLiteralArgumentAttr(Attr, 0, Str)) {
    return;
  }
  if (AttrTyClass == UnavailableAttr.class) {
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new UnavailableAttr(Attr.getRange(), S.Context, Str, Attr.getAttributeSpellingListIndex()));
  } else {   
    throw new UnsupportedOperationException("Pleas add case for class "+AttrTyClass.getName());
  }
}

//<editor-fold defaultstate="collapsed" desc="handleObjCSuppresProtocolAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1889,
 FQN="handleObjCSuppresProtocolAttr", NM="_ZL29handleObjCSuppresProtocolAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL29handleObjCSuppresProtocolAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleObjCSuppresProtocolAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                             final /*const*/ AttributeList /*&*/ Attr) {
  if (!cast_ObjCProtocolDecl(D).isThisDeclarationADefinition()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_objc_attr_protocol_requires_definition)), 
              Attr.getName()), Attr.getRange()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ObjCExplicitProtocolImplAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="checkAvailabilityAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1902,
 FQN="checkAvailabilityAttr", NM="_ZL21checkAvailabilityAttrRN5clang4SemaENS_11SourceRangeEPNS_14IdentifierInfoENS_12VersionTupleES5_S5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL21checkAvailabilityAttrRN5clang4SemaENS_11SourceRangeEPNS_14IdentifierInfoENS_12VersionTupleES5_S5_")
//</editor-fold>
public static boolean checkAvailabilityAttr(final Sema /*&*/ S, SourceRange Range, 
                     IdentifierInfo /*P*/ Platform, 
                     VersionTuple Introduced, 
                     VersionTuple Deprecated, 
                     VersionTuple Obsoleted) {
  StringRef PlatformName = AvailabilityAttr.getPrettyPlatformName(Platform.getName());
  if (PlatformName.empty()) {
    PlatformName.$assignMove(Platform.getName());
  }
  
  // Ensure that Introduced <= Deprecated <= Obsoleted (although not all
  // of these steps are needed).
  if (!Introduced.empty() && !Deprecated.empty()
     && !($lesseq_VersionTuple$C(Introduced, Deprecated))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Range.getBegin(), diag.warn_availability_version_ordering)), 
                          1), PlatformName), Deprecated.getAsString()), 
              0), Introduced.getAsString()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  if (!Introduced.empty() && !Obsoleted.empty()
     && !($lesseq_VersionTuple$C(Introduced, Obsoleted))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Range.getBegin(), diag.warn_availability_version_ordering)), 
                          2), PlatformName), Obsoleted.getAsString()), 
              0), Introduced.getAsString()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  if (!Deprecated.empty() && !Obsoleted.empty()
     && !($lesseq_VersionTuple$C(Deprecated, Obsoleted))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Range.getBegin(), diag.warn_availability_version_ordering)), 
                          2), PlatformName), Obsoleted.getAsString()), 
              1), Deprecated.getAsString()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}


/// \brief Check whether the two versions match.
///
/// If either version tuple is empty, then they are assumed to match. If
/// \p BeforeIsOkay is true, then \p X can be less than or equal to \p Y.
//<editor-fold defaultstate="collapsed" desc="versionsMatch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1945,
 FQN="versionsMatch", NM="_ZL13versionsMatchRKN5clang12VersionTupleES2_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL13versionsMatchRKN5clang12VersionTupleES2_b")
//</editor-fold>
public static boolean versionsMatch(final /*const*/ VersionTuple /*&*/ X, final /*const*/ VersionTuple /*&*/ Y, 
             boolean BeforeIsOkay) {
  if (X.empty() || Y.empty()) {
    return true;
  }
  if ($eq_VersionTuple$C(X, Y)) {
    return true;
  }
  if (BeforeIsOkay && $less_VersionTuple$C(X, Y)) {
    return true;
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="handleAvailabilityAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2123,
 FQN="handleAvailabilityAttr", NM="_ZL22handleAvailabilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL22handleAvailabilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleAvailabilityAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                      final /*const*/ AttributeList /*&*/ Attr) {
  if (!checkAttributeNumArgs(S, Attr, 1)) {
    return;
  }
  IdentifierLoc /*P*/ Platform = Attr.getArgAsIdent(0);
  /*uint*/int Index = Attr.getAttributeSpellingListIndex();
  
  IdentifierInfo /*P*/ II = Platform.Ident;
  if (AvailabilityAttr.getPrettyPlatformName(II.getName()).empty()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Platform.Loc), diag.warn_availability_unknown_platform)), 
          Platform.Ident));
    } finally {
      $c$.$destroy();
    }
  }
  
  NamedDecl /*P*/ ND = dyn_cast_NamedDecl(D);
  if (!(ND != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_ignored)), Attr.getName()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  AvailabilityChange Introduced = new AvailabilityChange(Attr.getAvailabilityIntroduced());
  AvailabilityChange Deprecated = new AvailabilityChange(Attr.getAvailabilityDeprecated());
  AvailabilityChange Obsoleted = new AvailabilityChange(Attr.getAvailabilityObsoleted());
  boolean IsUnavailable = Attr.getUnavailableLoc().isValid();
  boolean IsStrict = Attr.getStrictLoc().isValid();
  StringRef Str/*J*/= new StringRef();
  {
    /*const*/ StringLiteral /*P*/ SE = dyn_cast_or_null_StringLiteral(Attr.getMessageExpr());
    if ((SE != null)) {
      Str.$assignMove(SE.getString());
    }
  }
  StringRef Replacement/*J*/= new StringRef();
  {
    /*const*/ StringLiteral /*P*/ SE = dyn_cast_or_null_StringLiteral(Attr.getReplacementExpr());
    if ((SE != null)) {
      Replacement.$assignMove(SE.getString());
    }
  }
  
  AvailabilityAttr /*P*/ NewAttr = S.mergeAvailabilityAttr(ND, Attr.getRange(), II, 
      false/*Implicit*/, 
      new VersionTuple(Introduced.Version), 
      new VersionTuple(Deprecated.Version), 
      new VersionTuple(Obsoleted.Version), 
      IsUnavailable, new StringRef(Str), 
      IsStrict, new StringRef(Replacement), 
      Sema.AvailabilityMergeKind.AMK_None, 
      Index);
  if ((NewAttr != null)) {
    D.addAttr(NewAttr);
  }
  
  // Transcribe "ios" to "watchos" (and add a new attribute) if the versioning
  // matches before the start of the watchOS platform.
  if (S.Context.getTargetInfo().getTriple().isWatchOS()) {
    IdentifierInfo /*P*/ NewII = null;
    if ($eq_StringRef(II.getName(), /*STRINGREF_STR*/"ios")) {
      NewII = $AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"watchos")));
    } else if ($eq_StringRef(II.getName(), /*STRINGREF_STR*/"ios_app_extension")) {
      NewII = $AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"watchos_app_extension")));
    }
    if ((NewII != null)) {
      VersionTuple2VersionTuple adjustWatchOSVersion =  (Version) -> 
        {
          if (Version.empty()) {
            return new VersionTuple(JD$Move.INSTANCE, Version);
          }
          /*uint*/int Major = Version.getMajor();
          /*uint*/int NewMajor = $greatereq_uint(Major, 9) ? Major - 7 : 0;
          if ($greatereq_uint(NewMajor, 2)) {
            if (Version.getMinor().hasValue()) {
              if (Version.getSubminor().hasValue()) {
                return new VersionTuple(NewMajor, Version.getMinor().getValue(), 
                    Version.getSubminor().getValue());
              } else {
                return new VersionTuple(NewMajor, Version.getMinor().getValue());
              }
            }
          }
          
          return new VersionTuple(2, 0);
        }
;
      
      VersionTuple NewIntroduced = adjustWatchOSVersion.$call(new VersionTuple(Introduced.Version));
      VersionTuple NewDeprecated = adjustWatchOSVersion.$call(new VersionTuple(Deprecated.Version));
      VersionTuple NewObsoleted = adjustWatchOSVersion.$call(new VersionTuple(Obsoleted.Version));
      
      AvailabilityAttr /*P*/ NewAttr$1 = S.mergeAvailabilityAttr(ND, 
          Attr.getRange(), 
          NewII, 
          true/*Implicit*/, 
          new VersionTuple(NewIntroduced), 
          new VersionTuple(NewDeprecated), 
          new VersionTuple(NewObsoleted), 
          IsUnavailable, new StringRef(Str), 
          IsStrict, 
          new StringRef(Replacement), 
          Sema.AvailabilityMergeKind.AMK_None, 
          Index);
      if ((NewAttr$1 != null)) {
        D.addAttr(NewAttr$1);
      }
    }
  } else if (S.Context.getTargetInfo().getTriple().isTvOS()) {
    // Transcribe "ios" to "tvos" (and add a new attribute) if the versioning
    // matches before the start of the tvOS platform.
    IdentifierInfo /*P*/ NewII = null;
    if ($eq_StringRef(II.getName(), /*STRINGREF_STR*/"ios")) {
      NewII = $AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"tvos")));
    } else if ($eq_StringRef(II.getName(), /*STRINGREF_STR*/"ios_app_extension")) {
      NewII = $AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"tvos_app_extension")));
    }
    if ((NewII != null)) {
      AvailabilityAttr /*P*/ NewAttr$1 = S.mergeAvailabilityAttr(ND, 
          Attr.getRange(), 
          NewII, 
          true/*Implicit*/, 
          new VersionTuple(Introduced.Version), 
          new VersionTuple(Deprecated.Version), 
          new VersionTuple(Obsoleted.Version), 
          IsUnavailable, new StringRef(Str), 
          IsStrict, 
          new StringRef(Replacement), 
          Sema.AvailabilityMergeKind.AMK_None, 
          Index);
      if ((NewAttr$1 != null)) {
        D.addAttr(NewAttr$1);
      }
    }
  }
}

/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="mergeVisibilityAttr">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*replaced by specializations*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2243,
 FQN="mergeVisibilityAttr", NM="Tpl__ZL19mergeVisibilityAttrRN5clang4SemaEPNS_4DeclENS_11SourceRangeENT_14VisibilityTypeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=Tpl__ZL19mergeVisibilityAttrRN5clang4SemaEPNS_4DeclENS_11SourceRangeENT_14VisibilityTypeEj")
//</editor-fold>
public static <T extends VisibilityAttr, T$VisibilityType> T mergeVisibilityAttr(final Sema /*&*/ S, Decl /*P*/ D, SourceRange range, 
                      T$VisibilityType value, 
                     /*uint*/int attrSpellingListIndex) {
  throw new UnsupportedOperationException("Specialization mergeVisibilityAttr$VisibilityAttr or mergeVisibilityAttr$TypeVisibilityAttr must be used. Or generate new specialization");
}
//<editor-fold defaultstate="collapsed" desc="mergeVisibilityAttr">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED/*specialization for VisibilityAttr*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2243,
 FQN="mergeVisibilityAttr", NM="_ZL19mergeVisibilityAttrIN5clang14VisibilityAttrEEPT_RNS0_4SemaEPNS0_4DeclENS0_11SourceRangeENS2_14VisibilityTypeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL19mergeVisibilityAttrIN5clang14VisibilityAttrEEPT_RNS0_4SemaEPNS0_4DeclENS0_11SourceRangeENS2_14VisibilityTypeEj")
//</editor-fold>
public static VisibilityAttr /*P*/ mergeVisibilityAttr$VisibilityAttr(final Sema /*&*/ S, Decl /*P*/ D, SourceRange range, 
                                   VisibilityAttr.VisibilityType value, 
                                  /*uint*/int attrSpellingListIndex) {
  VisibilityAttr /*P*/ existingAttr = D.getAttr(VisibilityAttr.class);
  if ((existingAttr != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
       VisibilityAttr.VisibilityType existingValue = existingAttr.getVisibility();
      if (existingValue == value) {
        return null;
      }
      $c$.clean($c$.track(S.Diag(existingAttr.getLocation(), diag.err_mismatched_visibility)));
      $c$.clean($c$.track(S.Diag(range.getBegin(), diag.note_previous_attribute)));
      D.dropAttr(VisibilityAttr.class);
    } finally {
      $c$.$destroy();
    }
  }
  return /*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new VisibilityAttr(new SourceRange(range), S.Context, value, attrSpellingListIndex);
}
//<editor-fold defaultstate="collapsed" desc="mergeVisibilityAttr">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED/*specialization for TypeVisibilityAttr*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2243,
 FQN="mergeVisibilityAttr", NM="_ZL19mergeVisibilityAttrIN5clang18TypeVisibilityAttrEEPT_RNS0_4SemaEPNS0_4DeclENS0_11SourceRangeENS2_14VisibilityTypeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL19mergeVisibilityAttrIN5clang18TypeVisibilityAttrEEPT_RNS0_4SemaEPNS0_4DeclENS0_11SourceRangeENS2_14VisibilityTypeEj")
//</editor-fold>
public static TypeVisibilityAttr /*P*/ mergeVisibilityAttr$TypeVisibilityAttr(final Sema /*&*/ S, Decl /*P*/ D, SourceRange range, 
                                       TypeVisibilityAttr.VisibilityType value, 
                                      /*uint*/int attrSpellingListIndex) {
  TypeVisibilityAttr /*P*/ existingAttr = D.getAttr(TypeVisibilityAttr.class);
  if ((existingAttr != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
       TypeVisibilityAttr.VisibilityType existingValue = existingAttr.getVisibility();
      if (existingValue == value) {
        return null;
      }
      $c$.clean($c$.track(S.Diag(existingAttr.getLocation(), diag.err_mismatched_visibility)));
      $c$.clean($c$.track(S.Diag(range.getBegin(), diag.note_previous_attribute)));
      D.dropAttr(TypeVisibilityAttr.class);
    } finally {
      $c$.$destroy();
    }
  }
  return /*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new TypeVisibilityAttr(new SourceRange(range), S.Context, value, attrSpellingListIndex);
}

//<editor-fold defaultstate="collapsed" desc="handleVisibilityAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2272,
 FQN="handleVisibilityAttr", NM="_ZL20handleVisibilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL20handleVisibilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListEb")
//</editor-fold>
public static void handleVisibilityAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr, 
                    boolean isTypeVisibility) {
  // Visibility attributes don't mean anything on a typedef.
  if (isa_TypedefNameDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getRange().getBegin(), diag.warn_attribute_ignored)), 
          Attr.getName()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // 'type_visibility' can only go on a type or namespace.
  if (isTypeVisibility
     && !(isa_TagDecl(D)
     || isa_ObjCInterfaceDecl(D)
     || isa_NamespaceDecl(D))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getRange().getBegin(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedTypeOrNamespace));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Check that the argument is a string literal.
  StringRef TypeStr/*J*/= new StringRef();
  type$ptr<SourceLocation> LiteralLoc/*J*/= create_type$ptr(new SourceLocation());
  if (!S.checkStringLiteralArgumentAttr(Attr, 0, TypeStr, $AddrOf(LiteralLoc))) {
    return;
  }
  
  type$ref<VisibilityAttr.VisibilityType> type = create_type$ref();
  if (!VisibilityAttr.ConvertStrToVisibilityType(new StringRef(TypeStr), type)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(LiteralLoc.$star()), diag.warn_attribute_type_not_supported)), 
              Attr.getName()), TypeStr));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Complain about attempts to use protected visibility on targets
  // (like Darwin) that don't support it.
  if (type.$deref() == VisibilityAttr.VisibilityType.Protected
     && !S.Context.getTargetInfo().hasProtectedVisibility()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_protected_visibility)));
      type.$set(VisibilityAttr.VisibilityType.Default);
    } finally {
      $c$.$destroy();
    }
  }
  
  /*uint*/int Index = Attr.getAttributeSpellingListIndex();
  Attr /*P*/ newAttr;
  if (isTypeVisibility) {
    newAttr = S.mergeTypeVisibilityAttr(D, Attr.getRange(), 
        TypeVisibilityAttr.VisibilityType.valueOf(type.$deref().getValue()), 
        Index);
  } else {
    newAttr = S.mergeVisibilityAttr(D, Attr.getRange(), type.$deref(), Index);
  }
  if ((newAttr != null)) {
    D.addAttr(newAttr);
  }
}

//<editor-fold defaultstate="collapsed" desc="handleObjCMethodFamilyAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2325,
 FQN="handleObjCMethodFamilyAttr", NM="_ZL26handleObjCMethodFamilyAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL26handleObjCMethodFamilyAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleObjCMethodFamilyAttr(final Sema /*&*/ S, Decl /*P*/ decl, 
                          final /*const*/ AttributeList /*&*/ Attr) {
  ObjCMethodDecl /*P*/ method = cast_ObjCMethodDecl(decl);
  if (!Attr.isArgIdent(0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_n_type)), 
                  Attr.getName()), 1), AttributeArgumentNType.AANT_ArgumentIdentifier));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  IdentifierLoc /*P*/ IL = Attr.getArgAsIdent(0);
  type$ref<ObjCMethodFamilyAttr.FamilyKind> F = create_type$ref();
  if (!ObjCMethodFamilyAttr.ConvertStrToFamilyKind(IL.Ident.getName(), F)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(IL.Loc), diag.warn_attribute_type_not_supported)), Attr.getName()), 
          IL.Ident));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (F.$deref() == ObjCMethodFamilyAttr.FamilyKind.OMF_init
     && !method.getReturnType().$arrow().isObjCObjectPointerType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(method.getLocation(), diag.err_init_method_bad_return_type)), 
          method.getReturnType()));
      // Ignore the attribute.
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  method.addAttr(/*FIXME:NEW_EXPR*//*new (S.Context)*/ new ObjCMethodFamilyAttr(Attr.getRange(), 
          S.Context, F.$deref(), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleObjCNSObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2355,
 FQN="handleObjCNSObject", NM="_ZL18handleObjCNSObjectRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL18handleObjCNSObjectRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleObjCNSObject(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  {
    TypedefNameDecl /*P*/ TD = dyn_cast_TypedefNameDecl(D);
    if ((TD != null)) {
      QualType T = TD.getUnderlyingType();
      if (!T.$arrow().isCARCBridgableType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(TD.getLocation(), diag.err_nsobject_attribute)));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      ObjCPropertyDecl /*P*/ PD = dyn_cast_ObjCPropertyDecl(D);
      if ((PD != null)) {
        QualType T = PD.getType();
        if (!T.$arrow().isCARCBridgableType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(S.Diag(PD.getLocation(), diag.err_nsobject_attribute)));
            return;
          } finally {
            $c$.$destroy();
          }
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // It is okay to include this attribute on properties, e.g.:
          //
          //  @property (retain, nonatomic) struct Bork *Q __attribute__((NSObject));
          //
          // In this case it follows tradition and suppresses an error in the above
          // case.    
          $c$.clean($c$.track(S.Diag(D.getLocation(), diag.warn_nsobject_attribute)));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ObjCNSObjectAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleObjCIndependentClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2384,
 FQN="handleObjCIndependentClass", NM="_ZL26handleObjCIndependentClassRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL26handleObjCIndependentClassRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleObjCIndependentClass(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  {
    TypedefNameDecl /*P*/ TD = dyn_cast_TypedefNameDecl(D);
    if ((TD != null)) {
      QualType T = TD.getUnderlyingType();
      if (!T.$arrow().isObjCObjectPointerType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(TD.getLocation(), diag.warn_ptr_independentclass_attribute)));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(D.getLocation(), diag.warn_independentclass_attribute)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ObjCIndependentClassAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleBlocksAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2400,
 FQN="handleBlocksAttr", NM="_ZL16handleBlocksAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL16handleBlocksAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleBlocksAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  if (!Attr.isArgIdent(0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_n_type)), 
                  Attr.getName()), 1), AttributeArgumentNType.AANT_ArgumentIdentifier));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  IdentifierInfo /*P*/ II = Attr.getArgAsIdent(0).Ident;
  type$ref<BlocksAttr.BlockType> type = create_type$ref();
  if (!BlocksAttr.ConvertStrToBlockType(II.getName(), type)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_type_not_supported)), 
              Attr.getName()), II));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new BlocksAttr(Attr.getRange(), S.Context, type.$deref(), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleSentinelAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2420,
 FQN="handleSentinelAttr", NM="_ZL18handleSentinelAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL18handleSentinelAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleSentinelAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  /*uint*/int sentinel = (/*uint*/int)SentinelAttr.DefaultSentinel;
  if ($greater_uint(Attr.getNumArgs(), 0)) {
    Expr /*P*/ E = Attr.getArgAsExpr(0);
    APSInt Idx/*J*/= new APSInt(32);
    if (E.isTypeDependent() || E.isValueDependent()
       || !E.isIntegerConstantExpr(Idx, S.Context)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_n_type)), 
                        Attr.getName()), 1), AttributeArgumentNType.AANT_ArgumentIntegerConstant), 
            E.getSourceRange()));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    if (Idx.isSigned() && Idx.isNegative()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_sentinel_less_than_zero)), 
            E.getSourceRange()));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    sentinel = $ulong2uint(Idx.getZExtValue());
  }
  
  /*uint*/int nullPos = (/*uint*/int)SentinelAttr.DefaultNullPos;
  if ($greater_uint(Attr.getNumArgs(), 1)) {
    Expr /*P*/ E = Attr.getArgAsExpr(1);
    APSInt Idx/*J*/= new APSInt(32);
    if (E.isTypeDependent() || E.isValueDependent()
       || !E.isIntegerConstantExpr(Idx, S.Context)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_n_type)), 
                        Attr.getName()), 2), AttributeArgumentNType.AANT_ArgumentIntegerConstant), 
            E.getSourceRange()));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    nullPos = $ulong2uint(Idx.getZExtValue());
    if ((Idx.isSigned() && Idx.isNegative()) || $greater_uint(nullPos, 1)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // FIXME: This error message could be improved, it would be nice
        // to say what the bounds actually are.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_sentinel_not_zero_or_one)), 
            E.getSourceRange()));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  {
    
    FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
    if ((FD != null)) {
      /*const*/ FunctionType /*P*/ FT = FD.getType().$arrow().castAs(FunctionType.class);
      if (isa_FunctionNoProtoType(FT)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_sentinel_named_arguments)));
          return;
        } finally {
          $c$.$destroy();
        }
      }
      if (!cast_FunctionProtoType(FT).isVariadic()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_sentinel_not_variadic)), 0));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(D);
      if ((MD != null)) {
        if (!MD.isVariadic()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_sentinel_not_variadic)), 0));
            return;
          } finally {
            $c$.$destroy();
          }
        }
      } else {
        BlockDecl /*P*/ BD = dyn_cast_BlockDecl(D);
        if ((BD != null)) {
          if (!BD.isVariadic()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_sentinel_not_variadic)), 1));
              return;
            } finally {
              $c$.$destroy();
            }
          }
        } else {
          /*const*/ VarDecl /*P*/ V = dyn_cast_VarDecl(D);
          if ((V != null)) {
            QualType Ty = V.getType();
            if (Ty.$arrow().isBlockPointerType() || Ty.$arrow().isFunctionPointerType()) {
              /*const*/ FunctionType /*P*/ FT = Ty.$arrow().isFunctionPointerType() ? D.getFunctionType() : Ty.$arrow().getAs(BlockPointerType.class).getPointeeType().$arrow().getAs(FunctionType.class);
              if (!cast_FunctionProtoType(FT).isVariadic()) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  int m = Ty.$arrow().isFunctionPointerType() ? 0 : 1;
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_sentinel_not_variadic)), m));
                  return;
                } finally {
                  $c$.$destroy();
                }
              }
            } else {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
                        Attr.getName()), AttributeDeclKind.ExpectedFunctionMethodOrBlock));
                return;
              } finally {
                $c$.$destroy();
              }
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
                      Attr.getName()), AttributeDeclKind.ExpectedFunctionMethodOrBlock));
              return;
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
  }
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new SentinelAttr(Attr.getRange(), S.Context, sentinel, nullPos, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleWarnUnusedResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2511,
 FQN="handleWarnUnusedResult", NM="_ZL22handleWarnUnusedResultRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL22handleWarnUnusedResultRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleWarnUnusedResult(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  if ((D.getFunctionType() != null)
     && D.getFunctionType().getReturnType().$arrow().isVoidType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_void_function_method)), 
              Attr.getName()), 0));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  {
    /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(D);
    if ((MD != null)) {
      if (MD.getReturnType().$arrow().isVoidType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_void_function_method)), 
                  Attr.getName()), 1));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // If this is spelled as the standard C++1z attribute, but not in C++1z, warn
  // about using it as an extension.
  if (!S.getLangOpts().CPlusPlus1z && Attr.isCXX11Attribute()
     && !(Attr.getScopeName() != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.ext_cxx1z_attr)), Attr.getName()));
    } finally {
      $c$.$destroy();
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new WarnUnusedResultAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleWeakImportAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2536,
 FQN="handleWeakImportAttr", NM="_ZL20handleWeakImportAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL20handleWeakImportAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleWeakImportAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  // weak_import only applies to variable & function declarations.
  bool$ref isDef = create_bool$ref(false);
  if (!D.canBeWeakImported(isDef)) {
    if (isDef.$deref()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_invalid_on_definition)), 
            /*KEEP_STR*/"weak_import"));
      } finally {
        $c$.$destroy();
      }
    } else if (isa_ObjCPropertyDecl(D) || isa_ObjCMethodDecl(D)
       || (S.Context.getTargetInfo().getTriple().isOSDarwin()
       && (isa_ObjCInterfaceDecl(D) || isa_EnumDecl(D)))) {
      // Nothing to warn about here.
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
                Attr.getName()), AttributeDeclKind.ExpectedVariableOrFunction));
      } finally {
        $c$.$destroy();
      }
    }
    
    return;
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new WeakImportAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}


// Handles reqd_work_group_size and work_group_size_hint.
/*template <typename WorkGroupAttr> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="handleWorkGroupSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2561,
 FQN="handleWorkGroupSize", NM="Tpl__ZL19handleWorkGroupSizeRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=Tpl__ZL19handleWorkGroupSizeRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static </*typename*/ WorkGroupAttr extends Attr> void handleWorkGroupSize(Class<WorkGroupAttr> WorkGroupAttrClass, final Sema /*&*/ S, Decl /*P*/ D, 
                   final /*const*/ AttributeList /*&*/ Attr) {
  /*uint32_t*/int WGSize[/*3*/] = {0,0,0};
  for (/*uint*/int i = 0; $less_uint(i, 3); ++i) {
    /*const*/ Expr /*P*/ E = Attr.getArgAsExpr(i);
    uint$ref c = create_uint$ref();
    if (!checkUInt32Argument(S, Attr, E, c, i)) {
      return;
    }
    WGSize[i] = c.$deref();
    if (WGSize[i] == 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_is_zero)), 
                Attr.getName()), E.getSourceRange()));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  WorkGroupAttr /*P*/ ExistingT = D.<WorkGroupAttr>getAttr(WorkGroupAttrClass);
  if (ExistingT instanceof WorkGroupSizeHintAttr) {
    WorkGroupSizeHintAttr Existing = (WorkGroupSizeHintAttr) ExistingT;
    if (Native.$bool(Existing) && Native.$not((Native.$bool(Native.$bool(Native.$eq(Existing.getXDim(), WGSize[0]))
       && Native.$bool(Native.$eq(Existing.getYDim(), WGSize[1])))
       && Native.$bool(Native.$eq(Existing.getZDim(), WGSize[2]))))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_duplicate_attribute)), Attr.getName()));
      } finally {
        $c$.$destroy();
      }
    }

    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new WorkGroupSizeHintAttr( Attr.getRange(), S.Context, WGSize[0], WGSize[1], WGSize[2], Attr.getAttributeSpellingListIndex() ));
    
  } else if (ExistingT instanceof ReqdWorkGroupSizeAttr) {
    ReqdWorkGroupSizeAttr Existing = (ReqdWorkGroupSizeAttr) ExistingT;
    if (Native.$bool(Existing) && Native.$not((Native.$bool(Native.$bool(Native.$eq(Existing.getXDim(), WGSize[0]))
       && Native.$bool(Native.$eq(Existing.getYDim(), WGSize[1])))
       && Native.$bool(Native.$eq(Existing.getZDim(), WGSize[2]))))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_duplicate_attribute)), Attr.getName()));
      } finally {
        $c$.$destroy();
      }
    }

    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ReqdWorkGroupSizeAttr( Attr.getRange(), S.Context, WGSize[0], WGSize[1], WGSize[2], Attr.getAttributeSpellingListIndex() ));
  }
}

//<editor-fold defaultstate="collapsed" desc="handleVecTypeHint">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2586,
 FQN="handleVecTypeHint", NM="_ZL17handleVecTypeHintRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL17handleVecTypeHintRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleVecTypeHint(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  if (!Attr.hasParsedType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_number_arguments)), 
              Attr.getName()), 1));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  type$ptr<TypeSourceInfo /*P*/ > ParmTSI = create_type$null$ptr();
  QualType ParmType = S.GetTypeFromParser(new OpaquePtr<QualType>(Attr.getTypeArg()), ParmTSI);
  assert ((ParmTSI.$star() != null)) : "no type source info for attribute argument";
  if (!ParmType.$arrow().isExtVectorType() && !ParmType.$arrow().isFloatingType()
     && (ParmType.$arrow().isBooleanType()
     || !ParmType.$arrow().isIntegralType(S.getASTContext()))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_vec_type_hint)), 
          ParmType));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  {
    
    VecTypeHintAttr /*P*/ A = D.getAttr(VecTypeHintAttr.class);
    if ((A != null)) {
      if (!S.Context.hasSameType(A.getTypeHint(), new QualType(ParmType))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_duplicate_attribute)), Attr.getName()));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new VecTypeHintAttr(new SourceRange(Attr.getLoc()), S.Context, 
          ParmTSI.$star(), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleSectionAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2640,
 FQN="handleSectionAttr", NM="_ZL17handleSectionAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL17handleSectionAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleSectionAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  // Make sure that there is a string literal as the sections's single
  // argument.
  StringRef Str/*J*/= new StringRef();
  type$ptr<SourceLocation> LiteralLoc/*J*/= create_type$ptr(new SourceLocation());
  if (!S.checkStringLiteralArgumentAttr(Attr, 0, Str, $AddrOf(LiteralLoc))) {
    return;
  }
  if (!S.checkSectionName(new SourceLocation(LiteralLoc.$star()), new StringRef(Str))) {
    return;
  }
  
  // If the target wants to validate the section specifier, make it happen.
  std.string Error = S.Context.getTargetInfo().isValidSectionSpecifier(new StringRef(Str));
  if (!Error.empty()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(LiteralLoc.$star()), diag.err_attribute_section_invalid_for_target)), 
          Error));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  /*uint*/int Index = Attr.getAttributeSpellingListIndex();
  SectionAttr /*P*/ NewAttr = S.mergeSectionAttr(D, Attr.getRange(), new StringRef(Str), Index);
  if ((NewAttr != null)) {
    D.addAttr(NewAttr);
  }
}

//<editor-fold defaultstate="collapsed" desc="handleTargetAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2675,
 FQN="handleTargetAttr", NM="_ZL16handleTargetAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL16handleTargetAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleTargetAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  StringRef Str/*J*/= new StringRef();
  type$ptr<SourceLocation> LiteralLoc/*J*/= create_type$ptr(new SourceLocation());
  if (!S.checkStringLiteralArgumentAttr(Attr, 0, Str, $AddrOf(LiteralLoc))) {
    return;
  }
  S.checkTargetAttr(new SourceLocation(LiteralLoc.$star()), new StringRef(Str));
  /*uint*/int Index = Attr.getAttributeSpellingListIndex();
  TargetAttr /*P*/ NewAttr = /*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new TargetAttr(Attr.getRange(), S.Context, new StringRef(Str), Index);
  D.addAttr(NewAttr);
}

//<editor-fold defaultstate="collapsed" desc="handleCleanupAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2687,
 FQN="handleCleanupAttr", NM="_ZL17handleCleanupAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL17handleCleanupAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleCleanupAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  VarDecl /*P*/ VD = cast_VarDecl(D);
  if (!VD.hasLocalStorage()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_ignored)), Attr.getName()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  Expr /*P*/ E = Attr.getArgAsExpr(0);
  SourceLocation Loc = E.getExprLoc();
  FunctionDecl /*P*/ FD = null;
  DeclarationNameInfo NI/*J*/= new DeclarationNameInfo();
  {
    
    // gcc only allows for simple identifiers. Since we support more than gcc, we
    // will warn the user.
    DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
    if ((DRE != null)) {
      if (DRE.hasQualifier()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(new SourceLocation(Loc), diag.warn_cleanup_ext)));
        } finally {
          $c$.$destroy();
        }
      }
      FD = dyn_cast_FunctionDecl(DRE.getDecl());
      NI.$assignMove(DRE.getNameInfo());
      if (!(FD != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_attribute_cleanup_arg_not_function)), 1), 
              NI.getName()));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      UnresolvedLookupExpr /*P*/ ULE = dyn_cast_UnresolvedLookupExpr(E);
      if ((ULE != null)) {
        if (ULE.hasExplicitTemplateArgs()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(S.Diag(new SourceLocation(Loc), diag.warn_cleanup_ext)));
          } finally {
            $c$.$destroy();
          }
        }
        FD = S.ResolveSingleFunctionTemplateSpecialization(ULE, true);
        NI.$assign(ULE.getNameInfo());
        if (!(FD != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_attribute_cleanup_arg_not_function)), 2), 
                NI.getName()));
            if ($eq_QualType$C(ULE.getType(), S.Context.OverloadTy.$QualType())) {
              S.NoteAllOverloadCandidates(ULE);
            }
            return;
          } finally {
            $c$.$destroy();
          }
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_attribute_cleanup_arg_not_function)), 0));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  if (FD.getNumParams() != 1) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_attribute_cleanup_func_must_take_one_arg)), 
          NI.getName()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // We're currently more strict than GCC about what function types we accept.
  // If this ever proves to be a problem it should be easy to fix.
  QualType Ty = S.Context.getPointerType(VD.getType());
  QualType ParamTy = FD.getParamDecl(0).getType();
  if (S.CheckAssignmentConstraints(FD.getParamDecl(0).getLocation(), 
      new QualType(ParamTy), new QualType(Ty)) != Sema.AssignConvertType.Compatible) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_attribute_cleanup_func_arg_incompatible_type)), 
                  NI.getName()), ParamTy), Ty));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new CleanupAttr(Attr.getRange(), S.Context, FD, 
          Attr.getAttributeSpellingListIndex()));
}


/// Handle __attribute__((format_arg((idx)))) attribute based on
/// http://gcc.gnu.org/onlinedocs/gcc/Function-Attributes.html
//<editor-fold defaultstate="collapsed" desc="handleFormatArgAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2752,
 FQN="handleFormatArgAttr", NM="_ZL19handleFormatArgAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL19handleFormatArgAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleFormatArgAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  Expr /*P*/ IdxExpr = Attr.getArgAsExpr(0);
  ulong$ref Idx = create_ulong$ref(0);
  if (!checkFunctionOrMethodParameterIndex(S, D, Attr, 1, IdxExpr, Idx)) {
    return;
  }
  
  // Make sure the format string is really a string.
  QualType Ty = getFunctionOrMethodParamType(D, $ulong2uint(Idx.$deref()));
  
  boolean NotNSStringTy = !isNSStringType(new QualType(Ty), S.Context);
  if (NotNSStringTy
     && !isCFStringType(new QualType(Ty), S.Context)
     && (!Ty.$arrow().isPointerType()
     || !Ty.$arrow().getAs(PointerType.class).getPointeeType().$arrow().isCharType())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_format_attribute_not)), 
                  /*KEEP_STR*/"a string type"), IdxExpr.getSourceRange()), 
          getFunctionOrMethodParamRange(D, 0)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  Ty.$assignMove(getFunctionOrMethodResultType(D));
  if (!isNSStringType(new QualType(Ty), S.Context)
     && !isCFStringType(new QualType(Ty), S.Context)
     && (!Ty.$arrow().isPointerType()
     || !Ty.$arrow().getAs(PointerType.class).getPointeeType().$arrow().isCharType())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_format_attribute_result_not)), 
                  (NotNSStringTy ? $("string type") : $("NSString"))), 
              IdxExpr.getSourceRange()), getFunctionOrMethodParamRange(D, 0)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // We cannot use the Idx returned from checkFunctionOrMethodParameterIndex
  // because that has corrected for the implicit this parameter, and is zero-
  // based.  The attribute expects what the user wrote explicitly.
  APSInt Val/*J*/= new APSInt();
  IdxExpr.EvaluateAsInt(Val, S.Context);
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new FormatArgAttr(Attr.getRange(), S.Context, $ulong2int(Val.getZExtValue()), 
          Attr.getAttributeSpellingListIndex()));
}


/// getFormatAttrKind - Map from format attribute names to supported format
/// types.
//<editor-fold defaultstate="collapsed" desc="getFormatAttrKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2804,
 FQN="getFormatAttrKind", NM="_ZL17getFormatAttrKindN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL17getFormatAttrKindN4llvm9StringRefE")
//</editor-fold>
public static FormatAttrKind getFormatAttrKind(StringRef Format) {
  return new StringSwitch<FormatAttrKind>(/*NO_COPY*/Format).
      // Check for formats that get handled specially.
      Case(/*KEEP_STR*/"NSString", FormatAttrKind.NSStringFormat).
      Case(/*KEEP_STR*/"CFString", FormatAttrKind.CFStringFormat).
      Case(/*KEEP_STR*/"strftime", FormatAttrKind.StrftimeFormat).
      
      // Otherwise, check for supported formats.
      Cases(/*KEEP_STR*/"scanf", /*KEEP_STR*/"printf", /*KEEP_STR*/"printf0", /*KEEP_STR*/"strfmon", FormatAttrKind.SupportedFormat).
      Cases(/*KEEP_STR*/"cmn_err", /*KEEP_STR*/"vcmn_err", /*KEEP_STR*/"zcmn_err", FormatAttrKind.SupportedFormat).
      Case(/*KEEP_STR*/"kprintf", FormatAttrKind.SupportedFormat). // OpenBSD.
      Case(/*KEEP_STR*/"freebsd_kprintf", FormatAttrKind.SupportedFormat). // FreeBSD.
      Case(/*KEEP_STR*/"os_trace", FormatAttrKind.SupportedFormat).
      Cases(/*KEEP_STR*/"gcc_diag", /*KEEP_STR*/"gcc_cdiag", /*KEEP_STR*/"gcc_cxxdiag", /*KEEP_STR*/"gcc_tdiag", FormatAttrKind.IgnoredFormat).
      Default(FormatAttrKind.InvalidFormat);
}


/// Handle __attribute__((init_priority(priority))) attributes based on
/// http://gcc.gnu.org/onlinedocs/gcc/C_002b_002b-Attributes.html
//<editor-fold defaultstate="collapsed" desc="handleInitPriorityAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2824,
 FQN="handleInitPriorityAttr", NM="_ZL22handleInitPriorityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL22handleInitPriorityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleInitPriorityAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                      final /*const*/ AttributeList /*&*/ Attr) {
  if (!S.getLangOpts().CPlusPlus) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_ignored)), Attr.getName()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if ((S.getCurFunctionOrMethodDecl() != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.err_init_priority_object_attr)));
      Attr.setInvalid();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  QualType T = cast_VarDecl(D).getType();
  if ((S.Context.getAsArrayType(new QualType(T)) != null)) {
    T.$assignMove(S.Context.getBaseElementType(new QualType(T)));
  }
  if (!(T.$arrow().<RecordType>getAs$RecordType() != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.err_init_priority_object_attr)));
      Attr.setInvalid();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  Expr /*P*/ E = Attr.getArgAsExpr(0);
  uint$ref prioritynum = create_uint$ref();
  if (!checkUInt32Argument(S, Attr, E, prioritynum)) {
    Attr.setInvalid();
    return;
  }
  if ($less_uint(prioritynum.$deref(), 101) || $greater_uint(prioritynum.$deref(), 65535)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_outof_range)), 
                      E.getSourceRange()), Attr.getName()), 101), 65535));
      Attr.setInvalid();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new InitPriorityAttr(Attr.getRange(), S.Context, prioritynum.$deref(), 
          Attr.getAttributeSpellingListIndex()));
}


/// Handle __attribute__((format(type,idx,firstarg))) attributes based on
/// http://gcc.gnu.org/onlinedocs/gcc/Function-Attributes.html
//<editor-fold defaultstate="collapsed" desc="handleFormatAttr">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 optimized = Converted.Optimization.VALUE_TYPE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2886,
 FQN="handleFormatAttr", NM="_ZL16handleFormatAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL16handleFormatAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleFormatAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  if (!Attr.isArgIdent(0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_n_type)), 
                  Attr.getName()), 1), AttributeArgumentNType.AANT_ArgumentIdentifier));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // In C++ the implicit 'this' function parameter also counts, and they are
  // counted from one.
  boolean HasImplicitThisParam = isInstanceMethod(D);
  /*uint*/int NumArgs = getFunctionOrMethodNumParams(D) + (HasImplicitThisParam ? 1 : 0);
  
  IdentifierInfo /*P*/ II = Attr.getArgAsIdent(0).Ident;
  StringRef Format = II.getName();
  if (normalizeName(Format)) {
    // If we've modified the string name, we need a new identifier for it.
    /*JAVA: PERF*/char$ptr $data = Format.data();
    II = S.Context.Idents.get($data.$array(), $data.$index(), Format.size());
  }
  
  // Check for supported formats.
  FormatAttrKind Kind = getFormatAttrKind(new StringRef(Format));
  if (Kind == FormatAttrKind.IgnoredFormat) {
    return;
  }
  if (Kind == FormatAttrKind.InvalidFormat) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_type_not_supported)), 
              Attr.getName()), II.getName()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // checks for the 2nd argument
  Expr /*P*/ IdxExpr = Attr.getArgAsExpr(1);
  uint$ref Idx = create_uint$ref();
  if (!checkUInt32Argument(S, Attr, IdxExpr, Idx, 2)) {
    return;
  }
  if ($less_uint(Idx.$deref(), 1) || $greater_uint(Idx.$deref(), NumArgs)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_out_of_bounds)), 
                  Attr.getName()), 2), IdxExpr.getSourceRange()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // FIXME: Do we need to bounds check?
  /*uint*/int ArgIdx = Idx.$deref() - 1;
  if (HasImplicitThisParam) {
    if (ArgIdx == 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), 
                diag.err_format_attribute_implicit_this_format_string)), 
            IdxExpr.getSourceRange()));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    ArgIdx--;
  }
  
  // make sure the format string is really a string
  QualType Ty = getFunctionOrMethodParamType(D, ArgIdx);
  if (Kind == FormatAttrKind.CFStringFormat) {
    if (!isCFStringType(new QualType(Ty), S.Context)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_format_attribute_not)), 
                    /*KEEP_STR*/"a CFString"), IdxExpr.getSourceRange()), 
            getFunctionOrMethodParamRange(D, ArgIdx)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  } else if (Kind == FormatAttrKind.NSStringFormat) {
    // FIXME: do we need to check if the type is NSString*?  What are the
    // semantics?
    if (!isNSStringType(new QualType(Ty), S.Context)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_format_attribute_not)), 
                    /*KEEP_STR*/"an NSString"), IdxExpr.getSourceRange()), 
            getFunctionOrMethodParamRange(D, ArgIdx)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  } else if (!Ty.$arrow().isPointerType()
     || !Ty.$arrow().getAs(PointerType.class).getPointeeType().$arrow().isCharType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_format_attribute_not)), 
                  /*KEEP_STR*/"a string type"), IdxExpr.getSourceRange()), 
          getFunctionOrMethodParamRange(D, ArgIdx)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // check the 3rd argument
  Expr /*P*/ FirstArgExpr = Attr.getArgAsExpr(2);
  uint$ref FirstArg = create_uint$ref();
  if (!checkUInt32Argument(S, Attr, FirstArgExpr, FirstArg, 3)) {
    return;
  }
  
  // check if the function is variadic if the 3rd argument non-zero
  if (FirstArg.$deref() != 0) {
    if (isFunctionOrMethodVariadic(D)) {
      ++NumArgs; // +1 for ...
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(D.getLocation(), diag.err_format_attribute_requires_variadic)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // strftime requires FirstArg to be 0 because it doesn't read from any
  // variable the input is just the current time + the format string.
  if (Kind == FormatAttrKind.StrftimeFormat) {
    if (FirstArg.$deref() != 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_format_strftime_third_parameter)), 
            FirstArgExpr.getSourceRange()));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    // if 0 it disables parameter checking (to use with e.g. va_list)
  } else if (FirstArg.$deref() != 0 && FirstArg.$deref() != NumArgs) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_out_of_bounds)), 
                  Attr.getName()), 3), FirstArgExpr.getSourceRange()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  FormatAttr /*P*/ NewAttr = S.mergeFormatAttr(D, Attr.getRange(), II, 
      Idx.$deref(), FirstArg.$deref(), 
      Attr.getAttributeSpellingListIndex());
  if ((NewAttr != null)) {
    D.addAttr(NewAttr);
  }
}

//<editor-fold defaultstate="collapsed" desc="handleTransparentUnionAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3008,
 FQN="handleTransparentUnionAttr", NM="_ZL26handleTransparentUnionAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL26handleTransparentUnionAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleTransparentUnionAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                          final /*const*/ AttributeList /*&*/ Attr) {
  // Try to find the underlying union declaration.
  RecordDecl /*P*/ RD = null;
  TypedefNameDecl /*P*/ TD = dyn_cast_TypedefNameDecl(D);
  if ((TD != null) && TD.getUnderlyingType().$arrow().isUnionType()) {
    RD = TD.getUnderlyingType().$arrow().getAsUnionType().getDecl();
  } else {
    RD = dyn_cast_RecordDecl(D);
  }
  if (!(RD != null) || !RD.isUnion()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedUnion));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (!RD.isCompleteDefinition()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(Attr.getLoc(), 
          diag.warn_transparent_union_attribute_not_definition)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  specific_decl_iterator<FieldDecl> Field = RD.field_begin(), 
      FieldEnd = RD.field_end();
  if ($eq_specific_decl_iterator$SpecificDecl$C(Field, FieldEnd)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.warn_transparent_union_attribute_zero_fields)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  FieldDecl /*P*/ FirstField = Field.$star();
  QualType FirstType = FirstField.getType();
  if (FirstType.$arrow().hasFloatingRepresentation() || FirstType.$arrow().isVectorType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FirstField.getLocation(), 
                  diag.warn_transparent_union_attribute_floating)), 
              FirstType.$arrow().isVectorType()), FirstType));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  long/*uint64_t*/ FirstSize = S.Context.getTypeSize(new QualType(FirstType));
  long/*uint64_t*/ FirstAlign = $uint2ulong(S.Context.getTypeAlign(new QualType(FirstType)));
  for (; $noteq_specific_decl_iterator$SpecificDecl$C(Field, FieldEnd); Field.$preInc()) {
    QualType FieldType = Field.$arrow().getType();
    // FIXME: this isn't fully correct; we also need to test whether the
    // members of the union would all have the same calling convention as the
    // first member of the union. Checking just the size and alignment isn't
    // sufficient (consider structs passed on the stack instead of in registers
    // as an example).
    if (S.Context.getTypeSize(new QualType(FieldType)) != FirstSize
       || $greater_uint_ulong(S.Context.getTypeAlign(new QualType(FieldType)), FirstAlign)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Warn if we drop the attribute.
        boolean isSize = S.Context.getTypeSize(new QualType(FieldType)) != FirstSize;
        /*uint*/int FieldBits = $ullong2uint(isSize ? S.Context.getTypeSize(new QualType(FieldType)) : $uint2ullong(S.Context.getTypeAlign(new QualType(FieldType))));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Field.$arrow().getLocation(), 
                        diag.warn_transparent_union_attribute_field_size_align)), 
                    isSize), Field.$arrow().getDeclName()), FieldBits));
        /*uint*/int FirstBits = $ulong2uint(isSize ? FirstSize : FirstAlign);
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FirstField.getLocation(), 
                    diag.note_transparent_union_first_field_size_align)), 
                isSize), FirstBits));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  RD.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new TransparentUnionAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleAnnotateAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3077,
 FQN="handleAnnotateAttr", NM="_ZL18handleAnnotateAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL18handleAnnotateAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleAnnotateAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  // Make sure that there is a string literal as the annotation's single
  // argument.
  StringRef Str/*J*/= new StringRef();
  if (!S.checkStringLiteralArgumentAttr(Attr, 0, Str)) {
    return;
  }
  
  // Don't duplicate annotations that are already set.
  for (/*const*/ AnnotateAttr /*P*/ I : D.specific_attrs(AnnotateAttr.class)) {
    if ($eq_StringRef(I.getAnnotation(), /*NO_COPY*/Str)) {
      return;
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new AnnotateAttr(Attr.getRange(), S.Context, new StringRef(Str), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleAlignValueAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3095,
 FQN="handleAlignValueAttr", NM="_ZL20handleAlignValueAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL20handleAlignValueAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleAlignValueAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                    final /*const*/ AttributeList /*&*/ Attr) {
  S.AddAlignValueAttr(Attr.getRange(), D, Attr.getArgAsExpr(0), 
      Attr.getAttributeSpellingListIndex());
}

//<editor-fold defaultstate="collapsed" desc="handleAlignedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3146,
 FQN="handleAlignedAttr", NM="_ZL17handleAlignedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL17handleAlignedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleAlignedAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  // check the attribute arguments.
  if ($greater_uint(Attr.getNumArgs(), 1)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_number_arguments)), 
              Attr.getName()), 1));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (Attr.getNumArgs() == 0) {
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new AlignedAttr(Attr.getRange(), S.Context, 
            true, (Object/*void P*/ )null, Attr.getAttributeSpellingListIndex()));
    return;
  }
  
  Expr /*P*/ E = Attr.getArgAsExpr(0);
  if (Attr.isPackExpansion() && !E.containsUnexpandedParameterPack()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(Attr.getEllipsisLoc(), 
          diag.err_pack_expansion_without_parameter_packs)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (!Attr.isPackExpansion() && S.DiagnoseUnexpandedParameterPack(E)) {
    return;
  }
  if (E.isValueDependent()) {
    {
      /*const*/ TypedefNameDecl /*P*/ TND = dyn_cast_TypedefNameDecl(D);
      if ((TND != null)) {
        if (!TND.getUnderlyingType().$arrow().isDependentType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_alignment_dependent_typedef_name)), 
                E.getSourceRange()));
            return;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  
  S.AddAlignedAttr(Attr.getRange(), D, E, Attr.getAttributeSpellingListIndex(), 
      Attr.isPackExpansion());
}


/// parseModeAttrArg - Parses attribute mode string and returns parsed type
/// attribute.
//<editor-fold defaultstate="collapsed" desc="parseModeAttrArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3365,
 FQN="parseModeAttrArg", NM="_ZL16parseModeAttrArgRN5clang4SemaEN4llvm9StringRefERjRbS5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL16parseModeAttrArgRN5clang4SemaEN4llvm9StringRefERjRbS5_")
//</editor-fold>
public static void parseModeAttrArg(final Sema /*&*/ S, StringRef Str, final uint$ref/*uint &*/ DestWidth, 
                final bool$ref/*bool &*/ IntegerMode, final bool$ref/*bool &*/ ComplexMode) {
  IntegerMode.$set(true);
  ComplexMode.$set(false);
  switch (Str.size()) {
   case 2:
    switch (Str.$at(0)) {
     case 'Q':
      DestWidth.$set(8);
      break;
     case 'H':
      DestWidth.$set(16);
      break;
     case 'S':
      DestWidth.$set(32);
      break;
     case 'D':
      DestWidth.$set(64);
      break;
     case 'X':
      DestWidth.$set(96);
      break;
     case 'T':
      DestWidth.$set(128);
      break;
    }
    if (Str.$at(1) == $$F) {
      IntegerMode.$set(false);
    } else if (Str.$at(1) == $$C) {
      IntegerMode.$set(false);
      ComplexMode.$set(true);
    } else if (Str.$at(1) != $$I) {
      DestWidth.$set(0);
    }
    break;
   case 4:
    // FIXME: glibc uses 'word' to define register_t; this is narrower than a
    // pointer on PIC16 and other embedded platforms.
    if ($eq_StringRef(/*NO_COPY*/Str, /*STRINGREF_STR*/"word")) {
      DestWidth.$set(S.Context.getTargetInfo().getRegisterWidth());
    } else if ($eq_StringRef(/*NO_COPY*/Str, /*STRINGREF_STR*/"byte")) {
      DestWidth.$set(S.Context.getTargetInfo().getCharWidth());
    }
    break;
   case 7:
    if ($eq_StringRef(/*NO_COPY*/Str, /*STRINGREF_STR*/"pointer")) {
      DestWidth.$set($ulong2uint(S.Context.getTargetInfo().getPointerWidth(0)));
    }
    break;
   case 11:
    if ($eq_StringRef(/*NO_COPY*/Str, /*STRINGREF_STR*/"unwind_word")) {
      DestWidth.$set(S.Context.getTargetInfo().getUnwindWordWidth());
    }
    break;
  }
}


/// handleModeAttr - This attribute modifies the width of a decl with primitive
/// type.
///
/// Despite what would be logical, the mode attribute is a decl attribute, not a
/// type attribute: 'int ** __attribute((mode(HI))) *G;' tries to make 'G' be
/// HImode, not an intermediate pointer.
//<editor-fold defaultstate="collapsed" desc="handleModeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3425,
 FQN="handleModeAttr", NM="_ZL14handleModeAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL14handleModeAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleModeAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  // This attribute isn't documented, but glibc uses it.  It changes
  // the width of an int or unsigned int to the specified size.
  if (!Attr.isArgIdent(0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_type)), Attr.getName()), 
          AttributeArgumentNType.AANT_ArgumentIdentifier));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  IdentifierInfo /*P*/ Name = Attr.getArgAsIdent(0).Ident;
  
  S.AddModeAttr(Attr.getRange(), D, Name, Attr.getAttributeSpellingListIndex());
}

//<editor-fold defaultstate="collapsed" desc="handleNoDebugAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3581,
 FQN="handleNoDebugAttr", NM="_ZL17handleNoDebugAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL17handleNoDebugAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleNoDebugAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new NoDebugAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleAlwaysInlineAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3673,
 FQN="handleAlwaysInlineAttr", NM="_ZL22handleAlwaysInlineAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL22handleAlwaysInlineAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleAlwaysInlineAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                      final /*const*/ AttributeList /*&*/ Attr) {
  if (checkAttrMutualExclusion(NotTailCalledAttr.class, S, D, Attr.getRange(), 
      Attr.getName())) {
    return;
  }
  {
    
    AlwaysInlineAttr /*P*/ Inline = S.mergeAlwaysInlineAttr(D, Attr.getRange(), Attr.getName(), 
        Attr.getAttributeSpellingListIndex());
    if ((Inline != null)) {
      D.addAttr(Inline);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="handleMinSizeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3685,
 FQN="handleMinSizeAttr", NM="_ZL17handleMinSizeAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL17handleMinSizeAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleMinSizeAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  {
    MinSizeAttr /*P*/ MinSize = S.mergeMinSizeAttr(D, Attr.getRange(), Attr.getAttributeSpellingListIndex());
    if ((MinSize != null)) {
      D.addAttr(MinSize);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="handleOptimizeNoneAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3691,
 FQN="handleOptimizeNoneAttr", NM="_ZL22handleOptimizeNoneAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL22handleOptimizeNoneAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleOptimizeNoneAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                      final /*const*/ AttributeList /*&*/ Attr) {
  {
    OptimizeNoneAttr /*P*/ Optnone = S.mergeOptimizeNoneAttr(D, Attr.getRange(), Attr.getAttributeSpellingListIndex());
    if ((Optnone != null)) {
      D.addAttr(Optnone);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="handleGlobalAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3698,
 FQN="handleGlobalAttr", NM="_ZL16handleGlobalAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL16handleGlobalAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleGlobalAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  if (checkAttrMutualExclusion(CUDADeviceAttr.class, S, D, Attr.getRange(), 
      Attr.getName())
     || checkAttrMutualExclusion(CUDAHostAttr.class, S, D, Attr.getRange(), 
      Attr.getName())) {
    return;
  }
  FunctionDecl /*P*/ FD = cast_FunctionDecl(D);
  if (!FD.getReturnType().$arrow().isVoidType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SourceRange RTRange = FD.getReturnTypeSourceRange();
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FD.getTypeSpecStartLoc(), diag.err_kern_type_not_void_return)), 
              FD.getType()), 
          (RTRange.isValid() ? FixItHint.CreateReplacement(/*NO_COPY*/RTRange, new StringRef(/*KEEP_STR*/$void)) : new FixItHint())));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  {
    /*const*/ CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(FD);
    if ((Method != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        if (Method.isInstance()) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Method.getLocStart(), diag.err_kern_is_nonstatic_method)), 
              Method));
          return;
        }
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Method.getLocStart(), diag.warn_kern_is_method)), Method));
      } finally {
        $c$.$destroy();
      }
    }
  }
  // Only warn for "inline" when compiling for host, to cut down on noise.
  if (FD.isInlineSpecified() && !S.getLangOpts().CUDAIsDevice) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FD.getLocStart(), diag.warn_kern_is_inline)), FD));
    } finally {
      $c$.$destroy();
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new CUDAGlobalAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleGNUInlineAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3731,
 FQN="handleGNUInlineAttr", NM="_ZL19handleGNUInlineAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL19handleGNUInlineAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleGNUInlineAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  FunctionDecl /*P*/ Fn = cast_FunctionDecl(D);
  if (!Fn.isInlineSpecified()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.warn_gnu_inline_attribute_requires_inline)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new GNUInlineAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleCallConvAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3743,
 FQN="handleCallConvAttr", NM="_ZL18handleCallConvAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL18handleCallConvAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleCallConvAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  if (hasDeclarator(D)) {
    return;
  }
  
  // Diagnostic is emitted elsewhere: here we store the (valid) Attr
  // in the Decl node for syntactic reasoning, e.g., pretty-printing.
  type$ref<CallingConv> CC = create_type$ref();
  if (S.CheckCallingConvAttr(Attr, CC, /*FD*/ (/*const*/ FunctionDecl /*P*/ )null)) {
    return;
  }
  if (!isa_ObjCMethodDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunctionOrMethod));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  switch (Attr.getKind()) {
   case AT_FastCall:
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new FastCallAttr(Attr.getRange(), S.Context, 
            Attr.getAttributeSpellingListIndex()));
    return;
   case AT_StdCall:
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new StdCallAttr(Attr.getRange(), S.Context, 
            Attr.getAttributeSpellingListIndex()));
    return;
   case AT_ThisCall:
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ThisCallAttr(Attr.getRange(), S.Context, 
            Attr.getAttributeSpellingListIndex()));
    return;
   case AT_CDecl:
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new CDeclAttr(Attr.getRange(), S.Context, 
            Attr.getAttributeSpellingListIndex()));
    return;
   case AT_Pascal:
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new PascalAttr(Attr.getRange(), S.Context, 
            Attr.getAttributeSpellingListIndex()));
    return;
   case AT_SwiftCall:
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new SwiftCallAttr(Attr.getRange(), S.Context, 
            Attr.getAttributeSpellingListIndex()));
    return;
   case AT_VectorCall:
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new VectorCallAttr(Attr.getRange(), S.Context, 
            Attr.getAttributeSpellingListIndex()));
    return;
   case AT_MSABI:
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new MSABIAttr(Attr.getRange(), S.Context, 
            Attr.getAttributeSpellingListIndex()));
    return;
   case AT_SysVABI:
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new SysVABIAttr(Attr.getRange(), S.Context, 
            Attr.getAttributeSpellingListIndex()));
    return;
   case AT_Pcs:
    {
      PcsAttr.PCSType PCS;
      switch (CC.$deref()) {
       case CC_AAPCS:
        PCS = PcsAttr.PCSType.AAPCS;
        break;
       case CC_AAPCS_VFP:
        PCS = PcsAttr.PCSType.AAPCS_VFP;
        break;
       default:
        throw new llvm_unreachable("unexpected calling convention in pcs attribute");
      }
      
      D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new PcsAttr(Attr.getRange(), S.Context, PCS, 
              Attr.getAttributeSpellingListIndex()));
      return;
    }
   case AT_IntelOclBicc:
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new IntelOclBiccAttr(Attr.getRange(), S.Context, 
            Attr.getAttributeSpellingListIndex()));
    return;
   case AT_PreserveMost:
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new PreserveMostAttr(Attr.getRange(), S.Context, Attr.getAttributeSpellingListIndex()));
    return;
   case AT_PreserveAll:
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new PreserveAllAttr(Attr.getRange(), S.Context, Attr.getAttributeSpellingListIndex()));
    return;
   default:
    throw new llvm_unreachable("unexpected attribute kind");
  }
}


/// Pointer-like types in the default address space.
//<editor-fold defaultstate="collapsed" desc="isValidSwiftContextType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3918,
 FQN="isValidSwiftContextType", NM="_ZL23isValidSwiftContextTypeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL23isValidSwiftContextTypeN5clang8QualTypeE")
//</editor-fold>
public static boolean isValidSwiftContextType(QualType type) {
  if (!type.$arrow().hasPointerRepresentation()) {
    return type.$arrow().isDependentType();
  }
  return type.$arrow().getPointeeType().getAddressSpace() == 0;
}


/// Pointers and references in the default address space.
//<editor-fold defaultstate="collapsed" desc="isValidSwiftIndirectResultType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3925,
 FQN="isValidSwiftIndirectResultType", NM="_ZL30isValidSwiftIndirectResultTypeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL30isValidSwiftIndirectResultTypeN5clang8QualTypeE")
//</editor-fold>
public static boolean isValidSwiftIndirectResultType(QualType type) {
  {
    /*const*/ PointerType /*P*/ ptrType = type.$arrow().getAs(PointerType.class);
    if ((ptrType != null)) {
      type.$assignMove(ptrType.getPointeeType());
    } else {
      /*const*/ ReferenceType /*P*/ refType = type.$arrow().getAs(ReferenceType.class);
      if ((refType != null)) {
        type.$assignMove(refType.getPointeeType());
      } else {
        return type.$arrow().isDependentType();
      }
    }
  }
  return type.getAddressSpace() == 0;
}


/// Pointers and references to pointers in the default address space.
//<editor-fold defaultstate="collapsed" desc="isValidSwiftErrorResultType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3937,
 FQN="isValidSwiftErrorResultType", NM="_ZL27isValidSwiftErrorResultTypeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL27isValidSwiftErrorResultTypeN5clang8QualTypeE")
//</editor-fold>
public static boolean isValidSwiftErrorResultType(QualType type) {
  {
    /*const*/ PointerType /*P*/ ptrType = type.$arrow().getAs(PointerType.class);
    if ((ptrType != null)) {
      type.$assignMove(ptrType.getPointeeType());
    } else {
      /*const*/ ReferenceType /*P*/ refType = type.$arrow().getAs(ReferenceType.class);
      if ((refType != null)) {
        type.$assignMove(refType.getPointeeType());
      } else {
        return type.$arrow().isDependentType();
      }
    }
  }
  if (!type.getQualifiers().empty()) {
    return false;
  }
  return isValidSwiftContextType(new QualType(type));
}

//<editor-fold defaultstate="collapsed" desc="handleParameterABIAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3950,
 FQN="handleParameterABIAttr", NM="_ZL22handleParameterABIAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListENS_12ParameterABIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL22handleParameterABIAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListENS_12ParameterABIE")
//</editor-fold>
public static void handleParameterABIAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ attr, 
                      ParameterABI abi) {
  S.AddParameterABIAttr(attr.getRange(), D, abi, 
      attr.getAttributeSpellingListIndex());
}


// Checks whether an argument of launch_bounds attribute is
// acceptable, performs implicit conversion to Rvalue, and returns
// non-nullptr Expr result on success. Otherwise, it returns nullptr
// and may output an error.
//<editor-fold defaultstate="collapsed" desc="makeLaunchBoundsArgExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4047,
 FQN="makeLaunchBoundsArgExpr", NM="_ZL23makeLaunchBoundsArgExprRN5clang4SemaEPNS_4ExprERKNS_20CUDALaunchBoundsAttrEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL23makeLaunchBoundsArgExprRN5clang4SemaEPNS_4ExprERKNS_20CUDALaunchBoundsAttrEj")
//</editor-fold>
public static Expr /*P*/ makeLaunchBoundsArgExpr(final Sema /*&*/ S, Expr /*P*/ E, 
                       final /*const*/ CUDALaunchBoundsAttr /*&*/ Attr, 
                       /*const*//*uint*/int Idx) {
  if (S.DiagnoseUnexpandedParameterPack(E)) {
    return null;
  }
  
  // Accept template arguments for now as they depend on something else.
  // We'll get to check them when they eventually get instantiated.
  if (E.isValueDependent()) {
    return E;
  }
  
  APSInt I/*J*/= new APSInt(64);
  if (!E.isIntegerConstantExpr(I, S.Context)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getExprLoc(), diag.err_attribute_argument_n_type)), 
                      $AddrOf(Attr)), Idx), AttributeArgumentNType.AANT_ArgumentIntegerConstant), E.getSourceRange()));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  // Make sure we can fit it in 32 bits.
  if (!I.isIntN(32)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getExprLoc(), diag.err_ice_too_large)), I.__toString(10, false)), 
              32), /* Unsigned */ 1));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  if (I.$less(new APSInt(0))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getExprLoc(), diag.warn_attribute_argument_n_negative)), 
                  $AddrOf(Attr)), Idx), E.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
  
  // We may need to perform implicit conversion of the argument.
  InitializedEntity Entity = InitializedEntity.InitializeParameter(S.Context, S.Context.getConstType(S.Context.IntTy.$QualType()), /*consume*/ false);
  ActionResultTTrue<Expr /*P*/ > ValArg = S.PerformCopyInitialization(Entity, new SourceLocation(), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E));
  assert (!ValArg.isInvalid()) : "Unexpected PerformCopyInitialization() failure.";
  
  return ValArg.getAs(Expr.class);
}

//<editor-fold defaultstate="collapsed" desc="handleLaunchBoundsAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4102,
 FQN="handleLaunchBoundsAttr", NM="_ZL22handleLaunchBoundsAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL22handleLaunchBoundsAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleLaunchBoundsAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                      final /*const*/ AttributeList /*&*/ Attr) {
  if (!checkAttributeAtLeastNumArgs(S, Attr, 1)
     || !checkAttributeAtMostNumArgs(S, Attr, 2)) {
    return;
  }
  
  S.AddLaunchBoundsAttr(Attr.getRange(), D, Attr.getArgAsExpr(0), 
      $greater_uint(Attr.getNumArgs(), 1) ? Attr.getArgAsExpr(1) : (Expr /*P*/ )null, 
      Attr.getAttributeSpellingListIndex());
}

//<editor-fold defaultstate="collapsed" desc="handleArgumentWithTypeTagAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4113,
 FQN="handleArgumentWithTypeTagAttr", NM="_ZL29handleArgumentWithTypeTagAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL29handleArgumentWithTypeTagAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleArgumentWithTypeTagAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                             final /*const*/ AttributeList /*&*/ Attr) {
  if (!Attr.isArgIdent(0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_n_type)), 
                  Attr.getName()), /* arg num = */ 1), AttributeArgumentNType.AANT_ArgumentIdentifier));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (!checkAttributeNumArgs(S, Attr, 3)) {
    return;
  }
  
  IdentifierInfo /*P*/ ArgumentKind = Attr.getArgAsIdent(0).Ident;
  if (!isFunctionOrMethod(D) || !hasFunctionProto(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunctionOrMethod));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  ulong$ref ArgumentIdx = create_ulong$ref(0);
  if (!checkFunctionOrMethodParameterIndex(S, D, Attr, 2, Attr.getArgAsExpr(1), 
      ArgumentIdx)) {
    return;
  }
  
  ulong$ref TypeTagIdx = create_ulong$ref(0);
  if (!checkFunctionOrMethodParameterIndex(S, D, Attr, 3, Attr.getArgAsExpr(2), 
      TypeTagIdx)) {
    return;
  }
  
  boolean IsPointer = ($eq_StringRef(Attr.getName().getName(), /*STRINGREF_STR*/"pointer_with_type_tag"));
  if (IsPointer) {
    // Ensure that buffer has a pointer type.
    QualType BufferTy = getFunctionOrMethodParamType(D, $ulong2uint(ArgumentIdx.$deref()));
    if (!BufferTy.$arrow().isPointerType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_pointers_only)), 
                Attr.getName()), 0));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ArgumentWithTypeTagAttr(Attr.getRange(), S.Context, ArgumentKind, 
          $ulong2uint(ArgumentIdx.$deref()), $ulong2uint(TypeTagIdx.$deref()), IsPointer, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleTypeTagForDatatypeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4158,
 FQN="handleTypeTagForDatatypeAttr", NM="_ZL28handleTypeTagForDatatypeAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL28handleTypeTagForDatatypeAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleTypeTagForDatatypeAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                            final /*const*/ AttributeList /*&*/ Attr) {
  if (!Attr.isArgIdent(0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_n_type)), 
                  Attr.getName()), 1), AttributeArgumentNType.AANT_ArgumentIdentifier));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (!checkAttributeNumArgs(S, Attr, 1)) {
    return;
  }
  if (!isa_VarDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedVariable));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  IdentifierInfo /*P*/ PointerKind = Attr.getArgAsIdent(0).Ident;
  type$ptr<TypeSourceInfo /*P*/ > MatchingCTypeLoc = create_type$null$ptr();
  S.GetTypeFromParser(new OpaquePtr<QualType>(Attr.getMatchingCType()), MatchingCTypeLoc);
  assert ((MatchingCTypeLoc.$star() != null)) : "no type source info for attribute argument";
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new TypeTagForDatatypeAttr(Attr.getRange(), S.Context, PointerKind, 
          MatchingCTypeLoc.$star(), 
          Attr.getLayoutCompatible(), 
          Attr.getMustBeNull(), 
          Attr.getAttributeSpellingListIndex()));
}


//===----------------------------------------------------------------------===//
// Checker-specific attribute handlers.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="isValidSubjectOfNSReturnsRetainedAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4192,
 FQN="isValidSubjectOfNSReturnsRetainedAttribute", NM="_ZL42isValidSubjectOfNSReturnsRetainedAttributeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL42isValidSubjectOfNSReturnsRetainedAttributeN5clang8QualTypeE")
//</editor-fold>
public static boolean isValidSubjectOfNSReturnsRetainedAttribute(QualType type) {
  return type.$arrow().isDependentType()
     || type.$arrow().isObjCRetainableType();
}

//<editor-fold defaultstate="collapsed" desc="isValidSubjectOfNSAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4197,
 FQN="isValidSubjectOfNSAttribute", NM="_ZL27isValidSubjectOfNSAttributeRN5clang4SemaENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL27isValidSubjectOfNSAttributeRN5clang4SemaENS_8QualTypeE")
//</editor-fold>
public static boolean isValidSubjectOfNSAttribute(final Sema /*&*/ S, QualType type) {
  return type.$arrow().isDependentType()
     || type.$arrow().isObjCObjectPointerType()
     || S.Context.isObjCNSObjectType(new QualType(type));
}

//<editor-fold defaultstate="collapsed" desc="isValidSubjectOfCFAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4203,
 FQN="isValidSubjectOfCFAttribute", NM="_ZL27isValidSubjectOfCFAttributeRN5clang4SemaENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL27isValidSubjectOfCFAttributeRN5clang4SemaENS_8QualTypeE")
//</editor-fold>
public static boolean isValidSubjectOfCFAttribute(final Sema /*&*/ S, QualType type) {
  return type.$arrow().isDependentType()
     || type.$arrow().isPointerType()
     || isValidSubjectOfNSAttribute(S, new QualType(type));
}

//<editor-fold defaultstate="collapsed" desc="handleNSConsumedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4209,
 FQN="handleNSConsumedAttr", NM="_ZL20handleNSConsumedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL20handleNSConsumedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleNSConsumedAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  S.AddNSConsumedAttr(Attr.getRange(), D, Attr.getAttributeSpellingListIndex(), 
      Attr.getKind() == AttributeList.Kind.AT_NSConsumed, 
      /*template instantiation*/ false);
}

//<editor-fold defaultstate="collapsed" desc="handleNSReturnsRetainedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4251,
 FQN="handleNSReturnsRetainedAttr", NM="_ZL27handleNSReturnsRetainedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL27handleNSReturnsRetainedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleNSReturnsRetainedAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                           final /*const*/ AttributeList /*&*/ Attr) {
  QualType returnType/*J*/= new QualType();
  {
    
    ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(D);
    if ((MD != null)) {
      returnType.$assignMove(MD.getReturnType());
    } else if (S.getLangOpts().ObjCAutoRefCount && hasDeclarator(D)
       && (Attr.getKind() == AttributeList.Kind.AT_NSReturnsRetained)) {
      return; // ignore: was handled as a type attribute
    } else {
      ObjCPropertyDecl /*P*/ PD = dyn_cast_ObjCPropertyDecl(D);
      if ((PD != null)) {
        returnType.$assignMove(PD.getType());
      } else {
        FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
        if ((FD != null)) {
          returnType.$assignMove(FD.getReturnType());
        } else {
          ParmVarDecl /*P*/ Param = dyn_cast_ParmVarDecl(D);
          if ((Param != null)) {
            returnType.$assignMove(Param.getType().$arrow().getPointeeType());
            if (returnType.isNull()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getLocStart(), diag.warn_ns_attribute_wrong_parameter_type)), 
                            Attr.getName()), /*pointer-to-CF*/ 2), 
                    Attr.getRange()));
                return;
              } finally {
                $c$.$destroy();
              }
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              AttributeDeclKind ExpectedDeclKind;
              switch (Attr.getKind()) {
               default:
                throw new llvm_unreachable("invalid ownership attribute");
               case AT_NSReturnsRetained:
               case AT_NSReturnsAutoreleased:
               case AT_NSReturnsNotRetained:
                ExpectedDeclKind = AttributeDeclKind.ExpectedFunctionOrMethod;
                break;
               case AT_CFReturnsRetained:
               case AT_CFReturnsNotRetained:
                ExpectedDeclKind = AttributeDeclKind.ExpectedFunctionMethodOrParameter;
                break;
              }
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getLocStart(), diag.warn_attribute_wrong_decl_type)), 
                          Attr.getRange()), Attr.getName()), ExpectedDeclKind));
              return;
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
  }
  
  boolean typeOK;
  boolean cf;
  switch (Attr.getKind()) {
   default:
    throw new llvm_unreachable("invalid ownership attribute");
   case AT_NSReturnsRetained:
    typeOK = isValidSubjectOfNSReturnsRetainedAttribute(new QualType(returnType));
    cf = false;
    break;
   case AT_NSReturnsAutoreleased:
   case AT_NSReturnsNotRetained:
    typeOK = isValidSubjectOfNSAttribute(S, new QualType(returnType));
    cf = false;
    break;
   case AT_CFReturnsRetained:
   case AT_CFReturnsNotRetained:
    typeOK = isValidSubjectOfCFAttribute(S, new QualType(returnType));
    cf = true;
    break;
  }
  if (!typeOK) {
    if (isa_ParmVarDecl(D)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getLocStart(), diag.warn_ns_attribute_wrong_parameter_type)), 
                    Attr.getName()), /*pointer-to-CF*/ 2), 
            Attr.getRange()));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Needs to be kept in sync with warn_ns_attribute_wrong_return_type.
        /*enum ANONYMOUS_INT_CONSTANTS : unsigned int {*/
          final /*uint*/int Function = 0;
          final /*uint*/int Method = Function + 1;
          final /*uint*/int Property = Method + 1;
        /*}*//*Unnamed enum*//*uint*/int SubjectKind = Function;
        if (isa_ObjCMethodDecl(D)) {
          SubjectKind = Method;
        } else if (isa_ObjCPropertyDecl(D)) {
          SubjectKind = Property;
        }
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getLocStart(), diag.warn_ns_attribute_wrong_return_type)), 
                        Attr.getName()), SubjectKind), cf), 
            Attr.getRange()));
      } finally {
        $c$.$destroy();
      }
    }
    return;
  }
  switch (Attr.getKind()) {
   default:
    throw new llvm_unreachable("invalid ownership attribute");
   case AT_NSReturnsAutoreleased:
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new NSReturnsAutoreleasedAttr(Attr.getRange(), S.Context, Attr.getAttributeSpellingListIndex()));
    return;
   case AT_CFReturnsNotRetained:
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new CFReturnsNotRetainedAttr(Attr.getRange(), S.Context, Attr.getAttributeSpellingListIndex()));
    return;
   case AT_NSReturnsNotRetained:
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new NSReturnsNotRetainedAttr(Attr.getRange(), S.Context, Attr.getAttributeSpellingListIndex()));
    return;
   case AT_CFReturnsRetained:
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new CFReturnsRetainedAttr(Attr.getRange(), S.Context, Attr.getAttributeSpellingListIndex()));
    return;
   case AT_NSReturnsRetained:
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new NSReturnsRetainedAttr(Attr.getRange(), S.Context, Attr.getAttributeSpellingListIndex()));
    return;
  }
  /*JSKIP;*/
}

//<editor-fold defaultstate="collapsed" desc="handleObjCReturnsInnerPointerAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4363,
 FQN="handleObjCReturnsInnerPointerAttr", NM="_ZL33handleObjCReturnsInnerPointerAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL33handleObjCReturnsInnerPointerAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleObjCReturnsInnerPointerAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                                 final /*const*/ AttributeList /*&*/ attr) {
  /*const*/int EP_ObjCMethod = 1;
  /*const*/int EP_ObjCProperty = 2;
  
  SourceLocation loc = attr.getLoc();
  QualType resultType/*J*/= new QualType();
  if (isa_ObjCMethodDecl(D)) {
    resultType.$assignMove(cast_ObjCMethodDecl(D).getReturnType());
  } else {
    resultType.$assignMove(cast_ObjCPropertyDecl(D).getType());
  }
  if (!resultType.$arrow().isReferenceType()
     && (!resultType.$arrow().isPointerType() || resultType.$arrow().isObjCRetainableType())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getLocStart(), diag.warn_ns_attribute_wrong_return_type)), 
                      new SourceRange(/*NO_COPY*/loc)), 
                  attr.getName()), 
              (isa_ObjCMethodDecl(D) ? EP_ObjCMethod : EP_ObjCProperty)), 
          /*non-retainable pointer*/ 2));
      
      // Drop the attribute.
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ObjCReturnsInnerPointerAttr(attr.getRange(), S.Context, attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleObjCRequiresSuperAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4391,
 FQN="handleObjCRequiresSuperAttr", NM="_ZL27handleObjCRequiresSuperAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL27handleObjCRequiresSuperAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleObjCRequiresSuperAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                           final /*const*/ AttributeList /*&*/ attr) {
  ObjCMethodDecl /*P*/ method = cast_ObjCMethodDecl(D);
  
  DeclContext /*P*/ DC = method.getDeclContext();
  {
    /*const*/ ObjCProtocolDecl /*P*/ PDecl = dyn_cast_or_null_ObjCProtocolDecl(DC);
    if ((PDecl != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getLocStart(), diag.warn_objc_requires_super_protocol)), 
                attr.getName()), 0));
        $c$.clean($c$.track(S.Diag(PDecl.getLocation(), diag.note_protocol_decl)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (method.getMethodFamily() == ObjCMethodFamily.OMF_dealloc) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getLocStart(), diag.warn_objc_requires_super_protocol)), 
              attr.getName()), 1));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  method.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ObjCRequiresSuperAttr(attr.getRange(), S.Context, 
          attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleCFAuditedTransferAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4413,
 FQN="handleCFAuditedTransferAttr", NM="_ZL27handleCFAuditedTransferAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL27handleCFAuditedTransferAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleCFAuditedTransferAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                           final /*const*/ AttributeList /*&*/ Attr) {
  if (checkAttrMutualExclusion(CFUnknownTransferAttr.class, S, D, Attr.getRange(), 
      Attr.getName())) {
    return;
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new CFAuditedTransferAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleCFUnknownTransferAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4424,
 FQN="handleCFUnknownTransferAttr", NM="_ZL27handleCFUnknownTransferAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL27handleCFUnknownTransferAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleCFUnknownTransferAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                           final /*const*/ AttributeList /*&*/ Attr) {
  if (checkAttrMutualExclusion(CFAuditedTransferAttr.class, S, D, Attr.getRange(), 
      Attr.getName())) {
    return;
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new CFUnknownTransferAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleObjCBridgeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4435,
 FQN="handleObjCBridgeAttr", NM="_ZL20handleObjCBridgeAttrRN5clang4SemaEPNS_5ScopeEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL20handleObjCBridgeAttrRN5clang4SemaEPNS_5ScopeEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleObjCBridgeAttr(final Sema /*&*/ S, Scope /*P*/ Sc, Decl /*P*/ D, 
                    final /*const*/ AttributeList /*&*/ Attr) {
  IdentifierLoc /*P*/ Parm = Attr.isArgIdent(0) ? Attr.getArgAsIdent(0) : null;
  if (!(Parm != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getLocStart(), diag.err_objc_attr_not_id)), Attr.getName()), 0));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  {
    
    // Typedefs only allow objc_bridge(id) and have some additional checking.
    TypedefNameDecl /*P*/ TD = dyn_cast_TypedefNameDecl(D);
    if ((TD != null)) {
      if (!Parm.Ident.isStr(/*KEEP_STR*/"id")) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_objc_attr_typedef_not_id)), 
              Attr.getName()));
          return;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Only allow 'cv void *'.
      QualType T = TD.getUnderlyingType();
      if (!T.$arrow().isVoidPointerType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.err_objc_attr_typedef_not_void_pointer)));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ObjCBridgeAttr(Attr.getRange(), S.Context, Parm.Ident, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleObjCBridgeMutableAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4465,
 FQN="handleObjCBridgeMutableAttr", NM="_ZL27handleObjCBridgeMutableAttrRN5clang4SemaEPNS_5ScopeEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL27handleObjCBridgeMutableAttrRN5clang4SemaEPNS_5ScopeEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleObjCBridgeMutableAttr(final Sema /*&*/ S, Scope /*P*/ Sc, Decl /*P*/ D, 
                           final /*const*/ AttributeList /*&*/ Attr) {
  IdentifierLoc /*P*/ Parm = Attr.isArgIdent(0) ? Attr.getArgAsIdent(0) : null;
  if (!(Parm != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getLocStart(), diag.err_objc_attr_not_id)), Attr.getName()), 0));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ObjCBridgeMutableAttr(Attr.getRange(), S.Context, Parm.Ident, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleObjCBridgeRelatedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4479,
 FQN="handleObjCBridgeRelatedAttr", NM="_ZL27handleObjCBridgeRelatedAttrRN5clang4SemaEPNS_5ScopeEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL27handleObjCBridgeRelatedAttrRN5clang4SemaEPNS_5ScopeEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleObjCBridgeRelatedAttr(final Sema /*&*/ S, Scope /*P*/ Sc, Decl /*P*/ D, 
                           final /*const*/ AttributeList /*&*/ Attr) {
  IdentifierInfo /*P*/ RelatedClass = Attr.isArgIdent(0) ? Attr.getArgAsIdent(0).Ident : null;
  if (!(RelatedClass != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getLocStart(), diag.err_objc_attr_not_id)), Attr.getName()), 0));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  IdentifierInfo /*P*/ ClassMethod = (Attr.getArgAsIdent(1) != null) ? Attr.getArgAsIdent(1).Ident : null;
  IdentifierInfo /*P*/ InstanceMethod = (Attr.getArgAsIdent(2) != null) ? Attr.getArgAsIdent(2).Ident : null;
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ObjCBridgeRelatedAttr(Attr.getRange(), S.Context, RelatedClass, 
          ClassMethod, InstanceMethod, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleObjCDesignatedInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4497,
 FQN="handleObjCDesignatedInitializer", NM="_ZL31handleObjCDesignatedInitializerRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL31handleObjCDesignatedInitializerRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleObjCDesignatedInitializer(final Sema /*&*/ S, Decl /*P*/ D, 
                               final /*const*/ AttributeList /*&*/ Attr) {
  ObjCInterfaceDecl /*P*/ IFace;
  {
    ObjCCategoryDecl /*P*/ CatDecl = dyn_cast_ObjCCategoryDecl(D.getDeclContext());
    if ((CatDecl != null)) {
      IFace = CatDecl.getClassInterface();
    } else {
      IFace = cast_ObjCInterfaceDecl(D.getDeclContext());
    }
  }
  if (!(IFace != null)) {
    return;
  }
  
  IFace.setHasDesignatedInitializers();
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ObjCDesignatedInitializerAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleObjCRuntimeName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4515,
 FQN="handleObjCRuntimeName", NM="_ZL21handleObjCRuntimeNameRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL21handleObjCRuntimeNameRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleObjCRuntimeName(final Sema /*&*/ S, Decl /*P*/ D, 
                     final /*const*/ AttributeList /*&*/ Attr) {
  StringRef MetaDataName/*J*/= new StringRef();
  if (!S.checkStringLiteralArgumentAttr(Attr, 0, MetaDataName)) {
    return;
  }
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ObjCRuntimeNameAttr(Attr.getRange(), S.Context, 
          new StringRef(MetaDataName), 
          Attr.getAttributeSpellingListIndex()));
}


// When a user wants to use objc_boxable with a union or struct
// but they don't have access to the declaration (legacy/third-party code)
// then they can 'enable' this feature with a typedef:
// typedef struct __attribute((objc_boxable)) legacy_struct legacy_struct;
//<editor-fold defaultstate="collapsed" desc="handleObjCBoxable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4530,
 FQN="handleObjCBoxable", NM="_ZL17handleObjCBoxableRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL17handleObjCBoxableRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleObjCBoxable(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  boolean notify = false;
  
  RecordDecl /*P*/ RD = dyn_cast_RecordDecl(D);
  if ((RD != null) && (RD.getDefinition() != null)) {
    RD = RD.getDefinition();
    notify = true;
  }
  if ((RD != null)) {
    ObjCBoxableAttr /*P*/ BoxableAttr = /*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ObjCBoxableAttr(Attr.getRange(), S.Context, 
        Attr.getAttributeSpellingListIndex());
    RD.addAttr(BoxableAttr);
    if (notify) {
      {
        // we need to notify ASTReader/ASTWriter about
        // modification of existing declaration
        ASTMutationListener /*P*/ L = S.getASTMutationListener();
        if ((L != null)) {
          L.AddedAttributeToRecord(BoxableAttr, RD);
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="handleObjCOwnershipAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4553,
 FQN="handleObjCOwnershipAttr", NM="_ZL23handleObjCOwnershipAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL23handleObjCOwnershipAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleObjCOwnershipAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                       final /*const*/ AttributeList /*&*/ Attr) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (hasDeclarator(D)) {
      return;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getLocStart(), diag.err_attribute_wrong_decl_type)), 
                Attr.getRange()), Attr.getName()), AttributeDeclKind.ExpectedVariable));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="handleObjCPreciseLifetimeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4561,
 FQN="handleObjCPreciseLifetimeAttr", NM="_ZL29handleObjCPreciseLifetimeAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL29handleObjCPreciseLifetimeAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleObjCPreciseLifetimeAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                             final /*const*/ AttributeList /*&*/ Attr) {
  ValueDecl /*P*/ vd = cast_ValueDecl(D);
  QualType type = vd.getType();
  if (!type.$arrow().isDependentType()
     && !type.$arrow().isObjCLifetimeType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_objc_precise_lifetime_bad_type)), 
          type));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  Qualifiers.ObjCLifetime lifetime = type.getObjCLifetime();
  
  // If we have no lifetime yet, check the lifetime we're presumably
  // going to infer.
  if (lifetime == Qualifiers.ObjCLifetime.OCL_None && !type.$arrow().isDependentType()) {
    lifetime = type.$arrow().getObjCARCImplicitLifetime();
  }
  switch (lifetime) {
   case OCL_None:
    assert (type.$arrow().isDependentType()) : "didn't infer lifetime for non-dependent type?";
    break;
   case OCL_Weak: // meaningful
   case OCL_Strong: // meaningful
    break;
   case OCL_ExplicitNone:
   case OCL_Autoreleasing:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_objc_precise_lifetime_meaningless)), 
            (lifetime == Qualifiers.ObjCLifetime.OCL_Autoreleasing)));
        break;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ObjCPreciseLifetimeAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}


//===----------------------------------------------------------------------===//
// Microsoft specific attribute handlers.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="handleUuidAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4606,
 FQN="handleUuidAttr", NM="_ZL14handleUuidAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL14handleUuidAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleUuidAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  if (!S.LangOpts.CPlusPlus) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_not_supported_in_lang)), 
              Attr.getName()), LANG.C));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (!isa_CXXRecordDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedClass));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  StringRef StrRef/*J*/= new StringRef();
  type$ptr<SourceLocation> LiteralLoc/*J*/= create_type$ptr(new SourceLocation());
  if (!S.checkStringLiteralArgumentAttr(Attr, 0, StrRef, $AddrOf(LiteralLoc))) {
    return;
  }
  
  // GUID format is "XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX" or
  // "{XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX}", normalize to the former.
  if (StrRef.size() == 38 && StrRef.front() == $$LCURLY && StrRef.back() == $$RCURLY) {
    StrRef.$assignMove(StrRef.drop_front().drop_back());
  }
  
  // Validate GUID length.
  if (StrRef.size() != 36) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(new SourceLocation(LiteralLoc.$star()), diag.err_attribute_uuid_malformed_guid)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  for (/*uint*/int i = 0; $less_uint(i, 36); ++i) {
    if (i == 8 || i == 13 || i == 18 || i == 23) {
      if (StrRef.$at(i) != $$MINUS) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(new SourceLocation(LiteralLoc.$star()), diag.err_attribute_uuid_malformed_guid)));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    } else if (!isHexDigit(StrRef.$at(i))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(new SourceLocation(LiteralLoc.$star()), diag.err_attribute_uuid_malformed_guid)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new UuidAttr(Attr.getRange(), S.Context, new StringRef(StrRef), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleMSInheritanceAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4651,
 FQN="handleMSInheritanceAttr", NM="_ZL23handleMSInheritanceAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL23handleMSInheritanceAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleMSInheritanceAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  if (!S.LangOpts.CPlusPlus) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_not_supported_in_lang)), 
              Attr.getName()), LANG.C));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  MSInheritanceAttr /*P*/ IA = S.mergeMSInheritanceAttr(D, Attr.getRange(), /*BestCase=*/ true, 
      Attr.getAttributeSpellingListIndex(), 
      MSInheritanceAttr.Spelling.valueOf(Attr.getSemanticSpelling()));
  if ((IA != null)) {
    D.addAttr(IA);
    S.Consumer.AssignInheritanceModel(cast_CXXRecordDecl(D));
  }
}

//<editor-fold defaultstate="collapsed" desc="handleDeclspecThreadAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4667,
 FQN="handleDeclspecThreadAttr", NM="_ZL24handleDeclspecThreadAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL24handleDeclspecThreadAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleDeclspecThreadAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                        final /*const*/ AttributeList /*&*/ Attr) {
  VarDecl /*P*/ VD = cast_VarDecl(D);
  if (!S.Context.getTargetInfo().isTLSSupported()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.err_thread_unsupported)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (VD.getTSCSpec() != ThreadStorageClassSpecifier.TSCS_unspecified) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.err_declspec_thread_on_thread_variable)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (VD.hasLocalStorage()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_thread_non_global)), /*KEEP_STR*/"__declspec(thread)"));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  VD.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ThreadAttr(Attr.getRange(), S.Context, Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleAbiTagAttr">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*isPointerLike to std::unique*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4686,
 FQN="handleAbiTagAttr", NM="_ZL16handleAbiTagAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL16handleAbiTagAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleAbiTagAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  SmallVector<StringRef> Tags/*J*/= new SmallVector<StringRef>(4, new StringRef());
  for (/*uint*/int I = 0, E = Attr.getNumArgs(); I != E; ++I) {
    StringRef Tag/*J*/= new StringRef();
    if (!S.checkStringLiteralArgumentAttr(Attr, I, Tag)) {
      return;
    }
    Tags.push_back(Tag);
  }
  {
    
    /*const*/ NamespaceDecl /*P*/ NS = dyn_cast_NamespaceDecl(D);
    if ((NS != null)) {
      if (!NS.isInline()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attr_abi_tag_namespace)), 0));
          return;
        } finally {
          $c$.$destroy();
        }
      }
      if (NS.isAnonymousNamespace()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attr_abi_tag_namespace)), 1));
          return;
        } finally {
          $c$.$destroy();
        }
      }
      if (Attr.getNumArgs() == 0) {
        Tags.push_back(NS.getName());
      }
    } else if (!checkAttributeAtLeastNumArgs(S, Attr, 1)) {
      return;
    }
  }
  
  // Store tags sorted and without duplicates.
  std.sort(Tags.begin(), Tags.end());
  Tags.erase(std.unique(Tags.begin(), Tags.end(), false), Tags.end());
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new AbiTagAttr(Attr.getRange(), S.Context, Tags.data(), Tags.size(), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleARMInterruptAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4718,
 FQN="handleARMInterruptAttr", NM="_ZL22handleARMInterruptAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL22handleARMInterruptAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleARMInterruptAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                      final /*const*/ AttributeList /*&*/ Attr) {
  // Check the attribute arguments.
  if ($greater_uint(Attr.getNumArgs(), 1)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_too_many_arguments)), 
              Attr.getName()), 1));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  StringRef Str/*J*/= new StringRef();
  type$ptr<SourceLocation> ArgLoc/*J*/= create_type$ptr(new SourceLocation());
  if (Attr.getNumArgs() == 0) {
    Str.$assignMove(/*STRINGREF_STR*/$EMPTY);
  } else if (!S.checkStringLiteralArgumentAttr(Attr, 0, Str, $AddrOf(ArgLoc))) {
    return;
  }
  
  type$ref<ARMInterruptAttr.InterruptType> Kind = create_type$ref();
  if (!ARMInterruptAttr.ConvertStrToInterruptType(new StringRef(Str), Kind)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder_SourceLocation($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_type_not_supported)), 
                  Attr.getName()), Str), ArgLoc));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  /*uint*/int Index = Attr.getAttributeSpellingListIndex();
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ARMInterruptAttr(new SourceRange(Attr.getLoc()), S.Context, Kind.$deref(), Index));
}

//<editor-fold defaultstate="collapsed" desc="handleMSP430InterruptAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4747,
 FQN="handleMSP430InterruptAttr", NM="_ZL25handleMSP430InterruptAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL25handleMSP430InterruptAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleMSP430InterruptAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                         final /*const*/ AttributeList /*&*/ Attr) {
  if (!checkAttributeNumArgs(S, Attr, 1)) {
    return;
  }
  if (!Attr.isArgExpr(0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_type)), Attr.getName()), 
          AttributeArgumentNType.AANT_ArgumentIntegerConstant));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // FIXME: Check for decl - it should be void ()(void).
  Expr /*P*/ NumParamsExpr = ((/*static_cast*/Expr /*P*/ )(Attr.getArgAsExpr(0)));
  APSInt NumParams/*J*/= new APSInt(32);
  if (!NumParamsExpr.isIntegerConstantExpr(NumParams, S.Context)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_type)), 
                  Attr.getName()), AttributeArgumentNType.AANT_ArgumentIntegerConstant), 
          NumParamsExpr.getSourceRange()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  /*uint*/int Num = $ulong2uint(NumParams.getLimitedValue(255));
  if (((Num & 1) != 0) || $greater_uint(Num, 30)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_out_of_bounds)), 
                  Attr.getName()), (int)NumParams.getSExtValue()), 
          NumParamsExpr.getSourceRange()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new MSP430InterruptAttr(new SourceRange(Attr.getLoc()), S.Context, Num, 
          Attr.getAttributeSpellingListIndex()));
  D.addAttr(UsedAttr.CreateImplicit(S.Context));
}

//<editor-fold defaultstate="collapsed" desc="handleMipsInterruptAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4783,
 FQN="handleMipsInterruptAttr", NM="_ZL23handleMipsInterruptAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL23handleMipsInterruptAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleMipsInterruptAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                       final /*const*/ AttributeList /*&*/ Attr) {
  // Only one optional argument permitted.
  if ($greater_uint(Attr.getNumArgs(), 1)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_too_many_arguments)), 
              Attr.getName()), 1));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  StringRef Str/*J*/= new StringRef();
  type$ptr<SourceLocation> ArgLoc/*J*/= create_type$ptr(new SourceLocation());
  if (Attr.getNumArgs() == 0) {
    Str.$assignMove(/*STRINGREF_STR*/$EMPTY);
  } else if (!S.checkStringLiteralArgumentAttr(Attr, 0, Str, $AddrOf(ArgLoc))) {
    return;
  }
  
  // Semantic checks for a function with the 'interrupt' attribute for MIPS:
  // a) Must be a function.
  // b) Must have no parameters.
  // c) Must have the 'void' return type.
  // d) Cannot have the 'mips16' attribute, as that instruction set
  //    lacks the 'eret' instruction.
  // e) The attribute itself must either have no argument or one of the
  //    valid interrupt types, see [MipsInterruptDocs].
  if (!isFunctionOrMethod(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getLocation(), diag.warn_attribute_wrong_decl_type)), 
              /*KEEP_STR*/"'interrupt'"), AttributeDeclKind.ExpectedFunctionOrMethod));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (hasFunctionProto(D) && getFunctionOrMethodNumParams(D) != 0) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getLocation(), diag.warn_mips_interrupt_attribute)), 
          0));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (!getFunctionOrMethodResultType(D).$arrow().isVoidType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getLocation(), diag.warn_mips_interrupt_attribute)), 
          1));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (checkAttrMutualExclusion(Mips16Attr.class, S, D, Attr.getRange(), 
      Attr.getName())) {
    return;
  }
  
  type$ref<MipsInterruptAttr.InterruptType> Kind = create_type$ref();
  if (!MipsInterruptAttr.ConvertStrToInterruptType(new StringRef(Str), Kind)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_type_not_supported)), 
              Attr.getName()), $add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"'", Str.$string()), /*KEEP_STR*/"'")));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new MipsInterruptAttr(new SourceRange(Attr.getLoc()), S.Context, Kind.$deref(), Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleAnyX86InterruptAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4842,
 FQN="handleAnyX86InterruptAttr", NM="_ZL25handleAnyX86InterruptAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL25handleAnyX86InterruptAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleAnyX86InterruptAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                         final /*const*/ AttributeList /*&*/ Attr) {
  // Semantic checks for a function with the 'interrupt' attribute.
  // a) Must be a function.
  // b) Must have the 'void' return type.
  // c) Must take 1 or 2 arguments.
  // d) The 1st argument must be a pointer.
  // e) The 2nd argument (if any) must be an unsigned integer.
  if (!isFunctionOrMethod(D) || !hasFunctionProto(D) || isInstanceMethod(D)
     || CXXMethodDecl.isStaticOverloadedOperator(cast_NamedDecl(D).getDeclName().getCXXOverloadedOperator())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunctionWithProtoType));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  // Interrupt handler must have void return type.
  if (!getFunctionOrMethodResultType(D).$arrow().isVoidType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(getFunctionOrMethodResultSourceRange(D).getBegin(), 
                  diag.err_anyx86_interrupt_attribute)), 
              (S.Context.getTargetInfo().getTriple().getArch() == Triple.ArchType.x86 ? 0 : 1)), 
          0));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  // Interrupt handler must have 1 or 2 parameters.
  /*uint*/int NumParams = getFunctionOrMethodNumParams(D);
  if ($less_uint(NumParams, 1) || $greater_uint(NumParams, 2)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getLocStart(), diag.err_anyx86_interrupt_attribute)), 
              (S.Context.getTargetInfo().getTriple().getArch() == Triple.ArchType.x86 ? 0 : 1)), 
          1));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  // The first argument must be a pointer.
  if (!getFunctionOrMethodParamType(D, 0).$arrow().isPointerType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(getFunctionOrMethodParamRange(D, 0).getBegin(), 
                  diag.err_anyx86_interrupt_attribute)), 
              (S.Context.getTargetInfo().getTriple().getArch() == Triple.ArchType.x86 ? 0 : 1)), 
          2));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  // The second argument, if present, must be an unsigned integer.
  /*uint*/int TypeSize = S.Context.getTargetInfo().getTriple().getArch() == Triple.ArchType.x86_64 ? 64 : 32;
  if (NumParams == 2
     && (!getFunctionOrMethodParamType(D, 1).$arrow().isUnsignedIntegerType()
     || S.Context.getTypeSize(getFunctionOrMethodParamType(D, 1)) != $uint2ullong(TypeSize))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(getFunctionOrMethodParamRange(D, 1).getBegin(), 
                      diag.err_anyx86_interrupt_attribute)), 
                  (S.Context.getTargetInfo().getTriple().getArch() == Triple.ArchType.x86 ? 0 : 1)), 
              3), S.Context.getIntTypeForBitwidth(TypeSize, /*Signed=*/ /*false*/0)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new AnyX86InterruptAttr(new SourceRange(Attr.getLoc()), S.Context, Attr.getAttributeSpellingListIndex()));
  D.addAttr(UsedAttr.CreateImplicit(S.Context));
}

//<editor-fold defaultstate="collapsed" desc="handleInterruptAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4908,
 FQN="handleInterruptAttr", NM="_ZL19handleInterruptAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL19handleInterruptAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleInterruptAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  // Dispatch the interrupt attribute based on the current target.
  switch (S.Context.getTargetInfo().getTriple().getArch()) {
   case msp430:
    handleMSP430InterruptAttr(S, D, Attr);
    break;
   case mipsel:
   case mips:
    handleMipsInterruptAttr(S, D, Attr);
    break;
   case x86:
   case x86_64:
    handleAnyX86InterruptAttr(S, D, Attr);
    break;
   default:
    handleARMInterruptAttr(S, D, Attr);
    break;
  }
}

//<editor-fold defaultstate="collapsed" desc="handleAMDGPUNumVGPRAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4928,
 FQN="handleAMDGPUNumVGPRAttr", NM="_ZL23handleAMDGPUNumVGPRAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL23handleAMDGPUNumVGPRAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleAMDGPUNumVGPRAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                       final /*const*/ AttributeList /*&*/ Attr) {
  uint$ref NumRegs = create_uint$ref();
  Expr /*P*/ NumRegsExpr = ((/*static_cast*/Expr /*P*/ )(Attr.getArgAsExpr(0)));
  if (!checkUInt32Argument(S, Attr, NumRegsExpr, NumRegs)) {
    return;
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new AMDGPUNumVGPRAttr(new SourceRange(Attr.getLoc()), S.Context, 
          NumRegs.$deref(), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleAMDGPUNumSGPRAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4941,
 FQN="handleAMDGPUNumSGPRAttr", NM="_ZL23handleAMDGPUNumSGPRAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL23handleAMDGPUNumSGPRAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleAMDGPUNumSGPRAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                       final /*const*/ AttributeList /*&*/ Attr) {
  uint$ref NumRegs = create_uint$ref();
  Expr /*P*/ NumRegsExpr = ((/*static_cast*/Expr /*P*/ )(Attr.getArgAsExpr(0)));
  if (!checkUInt32Argument(S, Attr, NumRegsExpr, NumRegs)) {
    return;
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new AMDGPUNumSGPRAttr(new SourceRange(Attr.getLoc()), S.Context, 
          NumRegs.$deref(), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleX86ForceAlignArgPointerAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4954,
 FQN="handleX86ForceAlignArgPointerAttr", NM="_ZL33handleX86ForceAlignArgPointerAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL33handleX86ForceAlignArgPointerAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleX86ForceAlignArgPointerAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                                 final /*const*/ AttributeList /*&*/ Attr) {
  // If we try to apply it to a function pointer, don't warn, but don't
  // do anything, either. It doesn't matter anyway, because there's nothing
  // special about calling a force_align_arg_pointer function.
  ValueDecl /*P*/ VD = dyn_cast_ValueDecl(D);
  if ((VD != null) && VD.getType().$arrow().isFunctionPointerType()) {
    return;
  }
  // Also don't warn on function pointer typedefs.
  TypedefNameDecl /*P*/ TD = dyn_cast_TypedefNameDecl(D);
  if ((TD != null) && (TD.getUnderlyingType().$arrow().isFunctionPointerType()
     || TD.getUnderlyingType().$arrow().isFunctionType())) {
    return;
  }
  // Attribute can only be applied to function types.
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), /* function */ 0));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new X86ForceAlignArgPointerAttr(Attr.getRange(), S.Context, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleLayoutVersion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4979,
 FQN="handleLayoutVersion", NM="_ZL19handleLayoutVersionRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL19handleLayoutVersionRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleLayoutVersion(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  uint$ref Version = create_uint$ref();
  Expr /*P*/ VersionExpr = ((/*static_cast*/Expr /*P*/ )(Attr.getArgAsExpr(0)));
  if (!checkUInt32Argument(S, Attr, Attr.getArgAsExpr(0), Version)) {
    return;
  }
  
  // TODO: Investigate what happens with the next major version of MSVC.
  if (Version.$deref() != LangOptions.MSVCMajorVersion.MSVC2015.getValue()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_out_of_bounds)), 
                  Attr.getName()), Version), VersionExpr.getSourceRange()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new LayoutVersionAttr(Attr.getRange(), S.Context, Version.$deref(), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleDLLAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 5023,
 FQN="handleDLLAttr", NM="_ZL13handleDLLAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL13handleDLLAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleDLLAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ A) {
  if (isa_ClassTemplatePartialSpecializationDecl(D)
     && S.Context.getTargetInfo().getCXXABI().isMicrosoft()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(A.getRange().getBegin(), diag.warn_attribute_ignored)), 
          A.getName()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  {
    
    FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
    if ((FD != null)) {
      if (FD.isInlined() && A.getKind() == AttributeList.Kind.AT_DLLImport
         && !S.Context.getTargetInfo().getCXXABI().isMicrosoft()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // MinGW doesn't allow dllimport on inline functions.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(A.getRange().getBegin(), diag.warn_attribute_ignored_on_inline)), 
              A.getName()));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  {
    
    CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(D);
    if ((MD != null)) {
      if (S.Context.getTargetInfo().getCXXABI().isMicrosoft()
         && MD.getParent().isLambda()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(A.getRange().getBegin(), diag.err_attribute_dll_lambda)), A.getName()));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  /*uint*/int Index = A.getAttributeSpellingListIndex();
  Attr /*P*/ NewAttr = A.getKind() == AttributeList.Kind.AT_DLLExport ? (Attr /*P*/ )S.mergeDLLExportAttr(D, A.getRange(), Index) : (Attr /*P*/ )S.mergeDLLImportAttr(D, A.getRange(), Index);
  if ((NewAttr != null)) {
    D.addAttr(NewAttr);
  }
}

//<editor-fold defaultstate="collapsed" desc="handleCapabilityAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 5093,
 FQN="handleCapabilityAttr", NM="_ZL20handleCapabilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL20handleCapabilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleCapabilityAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  // The capability attributes take a single string parameter for the name of
  // the capability they represent. The lockable attribute does not take any
  // parameters. However, semantically, both attributes represent the same
  // concept, and so they use the same semantic attribute. Eventually, the
  // lockable attribute will be removed.
  //
  // For backward compatibility, any capability which has no specified string
  // literal will be considered a "mutex."
  StringRef N/*J*/= new StringRef(/*KEEP_STR*/"mutex");
  type$ptr<SourceLocation> LiteralLoc/*J*/= create_type$ptr(new SourceLocation());
  if (Attr.getKind() == AttributeList.Kind.AT_Capability
     && !S.checkStringLiteralArgumentAttr(Attr, 0, N, $AddrOf(LiteralLoc))) {
    return;
  }
  
  // Currently, there are only two names allowed for a capability: role and
  // mutex (case insensitive). Diagnose other capability names.
  if (!N.equals_lower(/*STRINGREF_STR*/"mutex") && !N.equals_lower(/*STRINGREF_STR*/"role")) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(LiteralLoc.$star()), diag.warn_invalid_capability_name)), N));
    } finally {
      $c$.$destroy();
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new CapabilityAttr(Attr.getRange(), S.Context, new StringRef(N), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleAssertCapabilityAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 5117,
 FQN="handleAssertCapabilityAttr", NM="_ZL26handleAssertCapabilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL26handleAssertCapabilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleAssertCapabilityAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                          final /*const*/ AttributeList /*&*/ Attr) {
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new AssertCapabilityAttr(Attr.getRange(), S.Context, 
          Attr.getArgAsExpr(0), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleAcquireCapabilityAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 5124,
 FQN="handleAcquireCapabilityAttr", NM="_ZL27handleAcquireCapabilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL27handleAcquireCapabilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleAcquireCapabilityAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                           final /*const*/ AttributeList /*&*/ Attr) {
  SmallVector<Expr /*P*/ > Args/*J*/= new SmallVector<Expr /*P*/ >(1, (Expr /*P*/ )null);
  if (!checkLockFunAttrCommon(S, D, Attr, Args)) {
    return;
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new AcquireCapabilityAttr(Attr.getRange(), 
          S.Context, 
          Args.data(), Args.size(), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleTryAcquireCapabilityAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 5136,
 FQN="handleTryAcquireCapabilityAttr", NM="_ZL30handleTryAcquireCapabilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL30handleTryAcquireCapabilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleTryAcquireCapabilityAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                              final /*const*/ AttributeList /*&*/ Attr) {
  SmallVector<Expr /*P*/ > Args/*J*/= new SmallVector<Expr /*P*/ >(2, (Expr /*P*/ )null);
  if (!checkTryLockFunAttrCommon(S, D, Attr, Args)) {
    return;
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new TryAcquireCapabilityAttr(Attr.getRange(), 
          S.Context, 
          Attr.getArgAsExpr(0), 
          Args.data(), 
          Args.size(), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleReleaseCapabilityAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 5150,
 FQN="handleReleaseCapabilityAttr", NM="_ZL27handleReleaseCapabilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL27handleReleaseCapabilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleReleaseCapabilityAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                           final /*const*/ AttributeList /*&*/ Attr) {
  // Check that all arguments are lockable objects.
  SmallVector<Expr /*P*/ > Args/*J*/= new SmallVector<Expr /*P*/ >(1, (Expr /*P*/ )null);
  checkAttrArgsAreCapabilityObjs(S, D, Attr, Args, 0, true);
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new ReleaseCapabilityAttr(Attr.getRange(), S.Context, Args.data(), Args.size(), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleRequiresCapabilityAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 5161,
 FQN="handleRequiresCapabilityAttr", NM="_ZL28handleRequiresCapabilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL28handleRequiresCapabilityAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleRequiresCapabilityAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                            final /*const*/ AttributeList /*&*/ Attr) {
  if (!checkAttributeAtLeastNumArgs(S, Attr, 1)) {
    return;
  }
  
  // check that all arguments are lockable objects
  SmallVector<Expr /*P*/ > Args/*J*/= new SmallVector<Expr /*P*/ >(1, (Expr /*P*/ )null);
  checkAttrArgsAreCapabilityObjs(S, D, Attr, Args);
  if (Args.empty()) {
    return;
  }
  
  RequiresCapabilityAttr /*P*/ RCA = /*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new RequiresCapabilityAttr(Attr.getRange(), S.Context, Args.data(), 
      Args.size(), Attr.getAttributeSpellingListIndex());
  
  D.addAttr(RCA);
}

//<editor-fold defaultstate="collapsed" desc="handleDeprecatedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 5179,
 FQN="handleDeprecatedAttr", NM="_ZL20handleDeprecatedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL20handleDeprecatedAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleDeprecatedAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  {
    NamespaceDecl /*P*/ NSD = dyn_cast_NamespaceDecl(D);
    if ((NSD != null)) {
      if (NSD.isAnonymousNamespace()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.warn_deprecated_anonymous_namespace)));
          // Do not want to attach the attribute to the namespace because that will
          // cause confusing diagnostic reports for uses of declarations within the
          // namespace.
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // Handle the cases where the attribute has a text message.
  StringRef Str/*J*/= new StringRef(), Replacement/*J*/= new StringRef();
  if (Attr.isArgExpr(0) && (Attr.getArgAsExpr(0) != null)
     && !S.checkStringLiteralArgumentAttr(Attr, 0, Str)) {
    return;
  }
  
  // Only support a single optional message for Declspec and CXX11.
  if (Attr.isDeclspecAttribute() || Attr.isCXX11Attribute()) {
    checkAttributeAtMostNumArgs(S, Attr, 1);
  } else if (Attr.isArgExpr(1) && (Attr.getArgAsExpr(1) != null)
     && !S.checkStringLiteralArgumentAttr(Attr, 1, Replacement)) {
    return;
  }
  if (!S.getLangOpts().CPlusPlus14) {
    if (Attr.isCXX11Attribute()
       && !(Attr.hasScope() && Attr.getScopeName().isStr(/*KEEP_STR*/"gnu"))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.ext_cxx14_attr)), Attr.getName()));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new DeprecatedAttr(Attr.getRange(), S.Context, new StringRef(Str), 
          new StringRef(Replacement), 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleNoSanitizeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 5213,
 FQN="handleNoSanitizeAttr", NM="_ZL20handleNoSanitizeAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL20handleNoSanitizeAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleNoSanitizeAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  std.vector<StringRef> Sanitizers = null;
  try {
    if (!checkAttributeAtLeastNumArgs(S, Attr, 1)) {
      return;
    }
    
    Sanitizers/*J*/= new std.vector<StringRef>(new StringRef());
    
    for (/*uint*/int I = 0, E = Attr.getNumArgs(); I != E; ++I) {
      StringRef SanitizerName/*J*/= new StringRef();
      type$ptr<SourceLocation> LiteralLoc/*J*/= create_type$ptr(new SourceLocation());
      if (!S.checkStringLiteralArgumentAttr(Attr, I, SanitizerName, $AddrOf(LiteralLoc))) {
        return;
      }
      if (parseSanitizerValue(new StringRef(SanitizerName), /*AllowGroups=*/ true) == 0) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(LiteralLoc.$star()), diag.warn_unknown_sanitizer_ignored)), SanitizerName));
        } finally {
          $c$.$destroy();
        }
      }
      
      Sanitizers.push_back_T$C$R(SanitizerName);
    }
    
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new NoSanitizeAttr(Attr.getRange(), S.Context, Sanitizers.data(), Sanitizers.size(), 
            Attr.getAttributeSpellingListIndex()));
  } finally {
    if (Sanitizers != null) { Sanitizers.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="handleNoSanitizeSpecificAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 5237,
 FQN="handleNoSanitizeSpecificAttr", NM="_ZL28handleNoSanitizeSpecificAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL28handleNoSanitizeSpecificAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleNoSanitizeSpecificAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                            final /*const*/ AttributeList /*&*/ Attr) {
  StringRef AttrName = Attr.getName().getName();
  normalizeName(AttrName);
  StringRef SanitizerName = new StringSwitchStringRef(/*NO_COPY*/AttrName).
      Case(/*KEEP_STR*/"no_address_safety_analysis", /*STRINGREF_STR*/"address").
      Case(/*KEEP_STR*/"no_sanitize_address", /*STRINGREF_STR*/"address").
      Case(/*KEEP_STR*/"no_sanitize_thread", /*STRINGREF_STR*/"thread").
      Case(/*KEEP_STR*/"no_sanitize_memory", /*STRINGREF_STR*/"memory").$T1();
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new NoSanitizeAttr(Attr.getRange(), S.Context, $AddrOf(create_type$ptr(SanitizerName)), 1, 
          Attr.getAttributeSpellingListIndex()));
}

//<editor-fold defaultstate="collapsed" desc="handleInternalLinkageAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 5252,
 FQN="handleInternalLinkageAttr", NM="_ZL25handleInternalLinkageAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL25handleInternalLinkageAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleInternalLinkageAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                         final /*const*/ AttributeList /*&*/ Attr) {
  {
    InternalLinkageAttr /*P*/ Internal = S.mergeInternalLinkageAttr(D, Attr.getRange(), Attr.getName(), 
        Attr.getAttributeSpellingListIndex());
    if ((Internal != null)) {
      D.addAttr(Internal);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="handleOpenCLNoSVMAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 5260,
 FQN="handleOpenCLNoSVMAttr", NM="_ZL21handleOpenCLNoSVMAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL21handleOpenCLNoSVMAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleOpenCLNoSVMAttr(final Sema /*&*/ S, Decl /*P*/ D, final /*const*/ AttributeList /*&*/ Attr) {
  if (S.LangOpts.OpenCLVersion != 200) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_requires_opencl_version)), 
                  Attr.getName()), /*KEEP_STR*/"2.0"), 0));
    } finally {
      $c$.$destroy();
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_opencl_attr_deprecated_ignored)), 
              Attr.getName()), /*KEEP_STR*/"2.0"));
    } finally {
      $c$.$destroy();
    }
  }
}


/// Handles semantic checking for features that are common to all attributes,
/// such as checking whether a parameter was properly specified, or the correct
/// number of arguments were passed, etc.
//<editor-fold defaultstate="collapsed" desc="handleCommonAttributeFeatures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 5272,
 FQN="handleCommonAttributeFeatures", NM="_ZL29handleCommonAttributeFeaturesRN5clang4SemaEPNS_5ScopeEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL29handleCommonAttributeFeaturesRN5clang4SemaEPNS_5ScopeEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static boolean handleCommonAttributeFeatures(final Sema /*&*/ S, Scope /*P*/ scope, Decl /*P*/ D, 
                             final /*const*/ AttributeList /*&*/ Attr) {
  // Several attributes carry different semantics than the parsing requires, so
  // those are opted out of the common handling.
  //
  // We also bail on unknown and ignored attributes because those are handled
  // as part of the target-specific handling logic.
  if (Attr.hasCustomParsing()
     || Attr.getKind() == AttributeList.Kind.UnknownAttribute) {
    return false;
  }
  
  // Check whether the attribute requires specific language extensions to be
  // enabled.
  if (!Attr.diagnoseLangOpts(S)) {
    return true;
  }
  if (Attr.getMinArgs() == Attr.getMaxArgs()) {
    // If there are no optional arguments, then checking for the argument count
    // is trivial.
    if (!checkAttributeNumArgs(S, Attr, Attr.getMinArgs())) {
      return true;
    }
  } else {
    // There are optional arguments, so checking is slightly more involved.
    if ((Attr.getMinArgs() != 0)
       && !checkAttributeAtLeastNumArgs(S, Attr, Attr.getMinArgs())) {
      return true;
    } else if (!Attr.hasVariadicArg() && (Attr.getMaxArgs() != 0)
       && !checkAttributeAtMostNumArgs(S, Attr, Attr.getMaxArgs())) {
      return true;
    }
  }
  
  // Check whether the attribute appertains to the given subject.
  if (!Attr.diagnoseAppertainsTo(S, D)) {
    return true;
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="handleOpenCLAccessAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 5310,
 FQN="handleOpenCLAccessAttr", NM="_ZL22handleOpenCLAccessAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL22handleOpenCLAccessAttrRN5clang4SemaEPNS_4DeclERKNS_13AttributeListE")
//</editor-fold>
public static void handleOpenCLAccessAttr(final Sema /*&*/ S, Decl /*P*/ D, 
                      final /*const*/ AttributeList /*&*/ Attr) {
  if (D.isInvalidDecl()) {
    return;
  }
  
  // Check if there is only one access qualifier.
  if (D.hasAttr(OpenCLAccessAttr.class)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_opencl_multiple_access_qualifiers)), 
          D.getSourceRange()));
      D.setInvalidDecl(true);
      return;
    } finally {
      $c$.$destroy();
    }
  }
  {
    
    // OpenCL v2.0 s6.6 - read_write can be used for image types to specify that an
    // image object can be read and written.
    // OpenCL v2.0 s6.13.6 - A kernel cannot read from and write to the same pipe
    // object. Using the read_write (or __read_write) qualifier with the pipe
    // qualifier is a compilation error.
    /*const*/ ParmVarDecl /*P*/ PDecl = dyn_cast_ParmVarDecl(D);
    if ((PDecl != null)) {
      /*const*/ Type /*P*/ DeclTy = PDecl.getType().getCanonicalType().getTypePtr();
      if (Attr.getName().getName().find(/*STRINGREF_STR*/$read_write.$star()) != StringRef.npos) {
        if ($less_uint(S.getLangOpts().OpenCLVersion, 200) || DeclTy.isPipeType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_opencl_invalid_read_write)), 
                        Attr.getName()), PDecl.getType()), DeclTy.isImageType()));
            D.setInvalidDecl(true);
            return;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new OpenCLAccessAttr(Attr.getRange(), S.Context, Attr.getAttributeSpellingListIndex()));
}


//===----------------------------------------------------------------------===//
// Top Level Sema Entry Points
//===----------------------------------------------------------------------===//

/// ProcessDeclAttribute - Apply the specific attribute to the specified decl if
/// the attribute applies to decls.  If the attribute is a type attribute, just
/// silently ignore it if a GNU attribute.
//<editor-fold defaultstate="collapsed" desc="ProcessDeclAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 5351,
 FQN="ProcessDeclAttribute", NM="_ZL20ProcessDeclAttributeRN5clang4SemaEPNS_5ScopeEPNS_4DeclERKNS_13AttributeListEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL20ProcessDeclAttributeRN5clang4SemaEPNS_5ScopeEPNS_4DeclERKNS_13AttributeListEb")
//</editor-fold>
public static void ProcessDeclAttribute(final Sema /*&*/ S, Scope /*P*/ scope, Decl /*P*/ D, 
                    final /*const*/ AttributeList /*&*/ Attr, 
                    boolean IncludeCXX11Attributes) {
  if (Attr.isInvalid() || Attr.getKind() == AttributeList.Kind.IgnoredAttribute) {
    return;
  }
  
  // Ignore C++11 attributes on declarator chunks: they appertain to the type
  // instead.
  if (Attr.isCXX11Attribute() && !IncludeCXX11Attributes) {
    return;
  }
  
  // Unknown attributes are automatically warned on. Target-specific attributes
  // which do not apply to the current target architecture are treated as
  // though they were unknown attributes.
  if (Attr.getKind() == AttributeList.Kind.UnknownAttribute
     || !Attr.existsInTarget(S.Context.getTargetInfo())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), Attr.isDeclspecAttribute() ? diag.warn_unhandled_ms_attribute_ignored : diag.warn_unknown_attribute_ignored)), 
          Attr.getName()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (handleCommonAttributeFeatures(S, scope, D, Attr)) {
    return;
  }
  switch (Attr.getKind()) {
   default:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        if (!Attr.isStmtAttr()) {
          // Type attributes are handled elsewhere; silently move on.
          assert (Attr.isTypeAttr()) : "Non-type attribute not handled";
          break;
        }
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_stmt_attribute_invalid_on_decl)), 
                Attr.getName()), D.getLocation()));
        break;
      } finally {
        $c$.$destroy();
      }
    }
   case AT_Interrupt:
    handleInterruptAttr(S, D, Attr);
    break;
   case AT_X86ForceAlignArgPointer:
    handleX86ForceAlignArgPointerAttr(S, D, Attr);
    break;
   case AT_DLLExport:
   case AT_DLLImport:
    handleDLLAttr(S, D, Attr);
    break;
   case AT_Mips16:
    handleSimpleAttributeWithExclusions/*<Mips16Attr, MipsInterruptAttr>*/(Mips16Attr.class, MipsInterruptAttr.class, S, D, 
        Attr);
    break;
   case AT_NoMips16:
    handleSimpleAttribute/*<NoMips16Attr>*/(NoMips16Attr.class, S, D, Attr);
    break;
   case AT_AMDGPUNumVGPR:
    handleAMDGPUNumVGPRAttr(S, D, Attr);
    break;
   case AT_AMDGPUNumSGPR:
    handleAMDGPUNumSGPRAttr(S, D, Attr);
    break;
   case AT_IBAction:
    handleSimpleAttribute/*<IBActionAttr>*/(IBActionAttr.class, S, D, Attr);
    break;
   case AT_IBOutlet:
    handleIBOutlet(S, D, Attr);
    break;
   case AT_IBOutletCollection:
    handleIBOutletCollection(S, D, Attr);
    break;
   case AT_IFunc:
    handleIFuncAttr(S, D, Attr);
    break;
   case AT_Alias:
    handleAliasAttr(S, D, Attr);
    break;
   case AT_Aligned:
    handleAlignedAttr(S, D, Attr);
    break;
   case AT_AlignValue:
    handleAlignValueAttr(S, D, Attr);
    break;
   case AT_AlwaysInline:
    handleAlwaysInlineAttr(S, D, Attr);
    break;
   case AT_AnalyzerNoReturn:
    handleAnalyzerNoReturnAttr(S, D, Attr);
    break;
   case AT_TLSModel:
    handleTLSModelAttr(S, D, Attr);
    break;
   case AT_Annotate:
    handleAnnotateAttr(S, D, Attr);
    break;
   case AT_Availability:
    handleAvailabilityAttr(S, D, Attr);
    break;
   case AT_CarriesDependency:
    handleDependencyAttr(S, scope, D, Attr);
    break;
   case AT_Common:
    handleCommonAttr(S, D, Attr);
    break;
   case AT_CUDAConstant:
    handleSimpleAttributeWithExclusions/*<CUDAConstantAttr, CUDASharedAttr>*/(CUDAConstantAttr.class, CUDASharedAttr.class, S, D, 
        Attr);
    break;
   case AT_PassObjectSize:
    handlePassObjectSizeAttr(S, D, Attr);
    break;
   case AT_Constructor:
    handleConstructorAttr(S, D, Attr);
    break;
   case AT_CXX11NoReturn:
    handleSimpleAttribute/*<CXX11NoReturnAttr>*/(CXX11NoReturnAttr.class, S, D, Attr);
    break;
   case AT_Deprecated:
    handleDeprecatedAttr(S, D, Attr);
    break;
   case AT_Destructor:
    handleDestructorAttr(S, D, Attr);
    break;
   case AT_EnableIf:
    handleEnableIfAttr(S, D, Attr);
    break;
   case AT_ExtVectorType:
    handleExtVectorTypeAttr(S, scope, D, Attr);
    break;
   case AT_MinSize:
    handleMinSizeAttr(S, D, Attr);
    break;
   case AT_OptimizeNone:
    handleOptimizeNoneAttr(S, D, Attr);
    break;
   case AT_FlagEnum:
    handleSimpleAttribute/*<FlagEnumAttr>*/(FlagEnumAttr.class, S, D, Attr);
    break;
   case AT_Flatten:
    handleSimpleAttribute/*<FlattenAttr>*/(FlattenAttr.class, S, D, Attr);
    break;
   case AT_Format:
    handleFormatAttr(S, D, Attr);
    break;
   case AT_FormatArg:
    handleFormatArgAttr(S, D, Attr);
    break;
   case AT_CUDAGlobal:
    handleGlobalAttr(S, D, Attr);
    break;
   case AT_CUDADevice:
    handleSimpleAttributeWithExclusions/*<CUDADeviceAttr, CUDAGlobalAttr>*/(CUDADeviceAttr.class, CUDAGlobalAttr.class, S, D, 
        Attr);
    break;
   case AT_CUDAHost:
    handleSimpleAttributeWithExclusions/*<CUDAHostAttr, CUDAGlobalAttr>*/(CUDAHostAttr.class, CUDAGlobalAttr.class, S, D, 
        Attr);
    break;
   case AT_GNUInline:
    handleGNUInlineAttr(S, D, Attr);
    break;
   case AT_CUDALaunchBounds:
    handleLaunchBoundsAttr(S, D, Attr);
    break;
   case AT_Restrict:
    handleRestrictAttr(S, D, Attr);
    break;
   case AT_MayAlias:
    handleSimpleAttribute/*<MayAliasAttr>*/(MayAliasAttr.class, S, D, Attr);
    break;
   case AT_Mode:
    handleModeAttr(S, D, Attr);
    break;
   case AT_NoAlias:
    handleSimpleAttribute/*<NoAliasAttr>*/(NoAliasAttr.class, S, D, Attr);
    break;
   case AT_NoCommon:
    handleSimpleAttribute/*<NoCommonAttr>*/(NoCommonAttr.class, S, D, Attr);
    break;
   case AT_NoSplitStack:
    handleSimpleAttribute/*<NoSplitStackAttr>*/(NoSplitStackAttr.class, S, D, Attr);
    break;
   case AT_NonNull:
    {
      ParmVarDecl /*P*/ PVD = dyn_cast_ParmVarDecl(D);
      if ((PVD != null)) {
        handleNonNullAttrParameter(S, PVD, Attr);
      } else {
        handleNonNullAttr(S, D, Attr);
      }
    }
    break;
   case AT_ReturnsNonNull:
    handleReturnsNonNullAttr(S, D, Attr);
    break;
   case AT_AssumeAligned:
    handleAssumeAlignedAttr(S, D, Attr);
    break;
   case AT_Overloadable:
    handleSimpleAttribute/*<OverloadableAttr>*/(OverloadableAttr.class, S, D, Attr);
    break;
   case AT_Ownership:
    handleOwnershipAttr(S, D, Attr);
    break;
   case AT_Cold:
    handleColdAttr(S, D, Attr);
    break;
   case AT_Hot:
    handleHotAttr(S, D, Attr);
    break;
   case AT_Naked:
    handleNakedAttr(S, D, Attr);
    break;
   case AT_NoReturn:
    handleNoReturnAttr(S, D, Attr);
    break;
   case AT_NoThrow:
    handleSimpleAttribute/*<NoThrowAttr>*/(NoThrowAttr.class, S, D, Attr);
    break;
   case AT_CUDAShared:
    handleSimpleAttributeWithExclusions/*<CUDASharedAttr, CUDAConstantAttr>*/(CUDASharedAttr.class, CUDAConstantAttr.class, S, D, 
        Attr);
    break;
   case AT_VecReturn:
    handleVecReturnAttr(S, D, Attr);
    break;
   case AT_ObjCOwnership:
    handleObjCOwnershipAttr(S, D, Attr);
    break;
   case AT_ObjCPreciseLifetime:
    handleObjCPreciseLifetimeAttr(S, D, Attr);
    break;
   case AT_ObjCReturnsInnerPointer:
    handleObjCReturnsInnerPointerAttr(S, D, Attr);
    break;
   case AT_ObjCRequiresSuper:
    handleObjCRequiresSuperAttr(S, D, Attr);
    break;
   case AT_ObjCBridge:
    handleObjCBridgeAttr(S, scope, D, Attr);
    break;
   case AT_ObjCBridgeMutable:
    handleObjCBridgeMutableAttr(S, scope, D, Attr);
    break;
   case AT_ObjCBridgeRelated:
    handleObjCBridgeRelatedAttr(S, scope, D, Attr);
    break;
   case AT_ObjCDesignatedInitializer:
    handleObjCDesignatedInitializer(S, D, Attr);
    break;
   case AT_ObjCRuntimeName:
    handleObjCRuntimeName(S, D, Attr);
    break;
   case AT_ObjCRuntimeVisible:
    handleSimpleAttribute/*<ObjCRuntimeVisibleAttr>*/(ObjCRuntimeVisibleAttr.class, S, D, Attr);
    break;
   case AT_ObjCBoxable:
    handleObjCBoxable(S, D, Attr);
    break;
   case AT_CFAuditedTransfer:
    handleCFAuditedTransferAttr(S, D, Attr);
    break;
   case AT_CFUnknownTransfer:
    handleCFUnknownTransferAttr(S, D, Attr);
    break;
   case AT_CFConsumed:
   case AT_NSConsumed:
    handleNSConsumedAttr(S, D, Attr);
    break;
   case AT_NSConsumesSelf:
    handleSimpleAttribute/*<NSConsumesSelfAttr>*/(NSConsumesSelfAttr.class, S, D, Attr);
    break;
   case AT_NSReturnsAutoreleased:
   case AT_NSReturnsNotRetained:
   case AT_CFReturnsNotRetained:
   case AT_NSReturnsRetained:
   case AT_CFReturnsRetained:
    handleNSReturnsRetainedAttr(S, D, Attr);
    break;
   case AT_WorkGroupSizeHint:
    handleWorkGroupSize/*<WorkGroupSizeHintAttr>*/(WorkGroupSizeHintAttr.class, S, D, Attr);
    break;
   case AT_ReqdWorkGroupSize:
    handleWorkGroupSize/*<ReqdWorkGroupSizeAttr>*/(ReqdWorkGroupSizeAttr.class, S, D, Attr);
    break;
   case AT_VecTypeHint:
    handleVecTypeHint(S, D, Attr);
    break;
   case AT_InitPriority:
    handleInitPriorityAttr(S, D, Attr);
    break;
   case AT_Packed:
    handlePackedAttr(S, D, Attr);
    break;
   case AT_Section:
    handleSectionAttr(S, D, Attr);
    break;
   case AT_Target:
    handleTargetAttr(S, D, Attr);
    break;
   case AT_Unavailable:
    handleAttrWithMessage/*<UnavailableAttr>*/(UnavailableAttr.class, S, D, Attr);
    break;
   case AT_ArcWeakrefUnavailable:
    handleSimpleAttribute/*<ArcWeakrefUnavailableAttr>*/(ArcWeakrefUnavailableAttr.class, S, D, Attr);
    break;
   case AT_ObjCRootClass:
    handleSimpleAttribute/*<ObjCRootClassAttr>*/(ObjCRootClassAttr.class, S, D, Attr);
    break;
   case AT_ObjCExplicitProtocolImpl:
    handleObjCSuppresProtocolAttr(S, D, Attr);
    break;
   case AT_ObjCRequiresPropertyDefs:
    handleSimpleAttribute/*<ObjCRequiresPropertyDefsAttr>*/(ObjCRequiresPropertyDefsAttr.class, S, D, Attr);
    break;
   case AT_Unused:
    handleUnusedAttr(S, D, Attr);
    break;
   case AT_ReturnsTwice:
    handleSimpleAttribute/*<ReturnsTwiceAttr>*/(ReturnsTwiceAttr.class, S, D, Attr);
    break;
   case AT_NotTailCalled:
    handleNotTailCalledAttr(S, D, Attr);
    break;
   case AT_DisableTailCalls:
    handleDisableTailCallsAttr(S, D, Attr);
    break;
   case AT_Used:
    handleUsedAttr(S, D, Attr);
    break;
   case AT_Visibility:
    handleVisibilityAttr(S, D, Attr, false);
    break;
   case AT_TypeVisibility:
    handleVisibilityAttr(S, D, Attr, true);
    break;
   case AT_WarnUnused:
    handleSimpleAttribute/*<WarnUnusedAttr>*/(WarnUnusedAttr.class, S, D, Attr);
    break;
   case AT_WarnUnusedResult:
    handleWarnUnusedResult(S, D, Attr);
    break;
   case AT_Weak:
    handleSimpleAttribute/*<WeakAttr>*/(WeakAttr.class, S, D, Attr);
    break;
   case AT_WeakRef:
    handleWeakRefAttr(S, D, Attr);
    break;
   case AT_WeakImport:
    handleWeakImportAttr(S, D, Attr);
    break;
   case AT_TransparentUnion:
    handleTransparentUnionAttr(S, D, Attr);
    break;
   case AT_ObjCException:
    handleSimpleAttribute/*<ObjCExceptionAttr>*/(ObjCExceptionAttr.class, S, D, Attr);
    break;
   case AT_ObjCMethodFamily:
    handleObjCMethodFamilyAttr(S, D, Attr);
    break;
   case AT_ObjCNSObject:
    handleObjCNSObject(S, D, Attr);
    break;
   case AT_ObjCIndependentClass:
    handleObjCIndependentClass(S, D, Attr);
    break;
   case AT_Blocks:
    handleBlocksAttr(S, D, Attr);
    break;
   case AT_Sentinel:
    handleSentinelAttr(S, D, Attr);
    break;
   case AT_Const:
    handleSimpleAttribute/*<ConstAttr>*/(ConstAttr.class, S, D, Attr);
    break;
   case AT_Pure:
    handleSimpleAttribute/*<PureAttr>*/(PureAttr.class, S, D, Attr);
    break;
   case AT_Cleanup:
    handleCleanupAttr(S, D, Attr);
    break;
   case AT_NoDebug:
    handleNoDebugAttr(S, D, Attr);
    break;
   case AT_NoDuplicate:
    handleSimpleAttribute/*<NoDuplicateAttr>*/(NoDuplicateAttr.class, S, D, Attr);
    break;
   case AT_NoInline:
    handleSimpleAttribute/*<NoInlineAttr>*/(NoInlineAttr.class, S, D, Attr);
    break;
   case AT_NoInstrumentFunction: // Interacts with -pg.
    handleSimpleAttribute/*<NoInstrumentFunctionAttr>*/(NoInstrumentFunctionAttr.class, S, D, Attr);
    break;
   case AT_StdCall:
   case AT_CDecl:
   case AT_FastCall:
   case AT_ThisCall:
   case AT_Pascal:
   case AT_SwiftCall:
   case AT_VectorCall:
   case AT_MSABI:
   case AT_SysVABI:
   case AT_Pcs:
   case AT_IntelOclBicc:
   case AT_PreserveMost:
   case AT_PreserveAll:
    handleCallConvAttr(S, D, Attr);
    break;
   case AT_OpenCLKernel:
    handleSimpleAttribute/*<OpenCLKernelAttr>*/(OpenCLKernelAttr.class, S, D, Attr);
    break;
   case AT_OpenCLAccess:
    handleOpenCLAccessAttr(S, D, Attr);
    break;
   case AT_OpenCLNoSVM:
    handleOpenCLNoSVMAttr(S, D, Attr);
    break;
   case AT_SwiftContext:
    handleParameterABIAttr(S, D, Attr, ParameterABI.SwiftContext);
    break;
   case AT_SwiftErrorResult:
    handleParameterABIAttr(S, D, Attr, ParameterABI.SwiftErrorResult);
    break;
   case AT_SwiftIndirectResult:
    handleParameterABIAttr(S, D, Attr, ParameterABI.SwiftIndirectResult);
    break;
   case AT_InternalLinkage:
    handleInternalLinkageAttr(S, D, Attr);
    break;
   case AT_LTOVisibilityPublic:
    handleSimpleAttribute/*<LTOVisibilityPublicAttr>*/(LTOVisibilityPublicAttr.class, S, D, Attr);
    break;
   case AT_EmptyBases:
    
    // Microsoft attributes:
    handleSimpleAttribute/*<EmptyBasesAttr>*/(EmptyBasesAttr.class, S, D, Attr);
    break;
   case AT_LayoutVersion:
    handleLayoutVersion(S, D, Attr);
    break;
   case AT_MSNoVTable:
    handleSimpleAttribute/*<MSNoVTableAttr>*/(MSNoVTableAttr.class, S, D, Attr);
    break;
   case AT_MSStruct:
    handleSimpleAttribute/*<MSStructAttr>*/(MSStructAttr.class, S, D, Attr);
    break;
   case AT_Uuid:
    handleUuidAttr(S, D, Attr);
    break;
   case AT_MSInheritance:
    handleMSInheritanceAttr(S, D, Attr);
    break;
   case AT_SelectAny:
    handleSimpleAttribute/*<SelectAnyAttr>*/(SelectAnyAttr.class, S, D, Attr);
    break;
   case AT_Thread:
    handleDeclspecThreadAttr(S, D, Attr);
    break;
   case AT_AbiTag:
    handleAbiTagAttr(S, D, Attr);
    break;
   case AT_AssertExclusiveLock:
    
    // Thread safety attributes:
    handleAssertExclusiveLockAttr(S, D, Attr);
    break;
   case AT_AssertSharedLock:
    handleAssertSharedLockAttr(S, D, Attr);
    break;
   case AT_GuardedVar:
    handleSimpleAttribute/*<GuardedVarAttr>*/(GuardedVarAttr.class, S, D, Attr);
    break;
   case AT_PtGuardedVar:
    handlePtGuardedVarAttr(S, D, Attr);
    break;
   case AT_ScopedLockable:
    handleSimpleAttribute/*<ScopedLockableAttr>*/(ScopedLockableAttr.class, S, D, Attr);
    break;
   case AT_NoSanitize:
    handleNoSanitizeAttr(S, D, Attr);
    break;
   case AT_NoSanitizeSpecific:
    handleNoSanitizeSpecificAttr(S, D, Attr);
    break;
   case AT_NoThreadSafetyAnalysis:
    handleSimpleAttribute/*<NoThreadSafetyAnalysisAttr>*/(NoThreadSafetyAnalysisAttr.class, S, D, Attr);
    break;
   case AT_GuardedBy:
    handleGuardedByAttr(S, D, Attr);
    break;
   case AT_PtGuardedBy:
    handlePtGuardedByAttr(S, D, Attr);
    break;
   case AT_ExclusiveTrylockFunction:
    handleExclusiveTrylockFunctionAttr(S, D, Attr);
    break;
   case AT_LockReturned:
    handleLockReturnedAttr(S, D, Attr);
    break;
   case AT_LocksExcluded:
    handleLocksExcludedAttr(S, D, Attr);
    break;
   case AT_SharedTrylockFunction:
    handleSharedTrylockFunctionAttr(S, D, Attr);
    break;
   case AT_AcquiredBefore:
    handleAcquiredBeforeAttr(S, D, Attr);
    break;
   case AT_AcquiredAfter:
    handleAcquiredAfterAttr(S, D, Attr);
    break;
   case AT_Capability:
   case AT_Lockable:
    
    // Capability analysis attributes.
    handleCapabilityAttr(S, D, Attr);
    break;
   case AT_RequiresCapability:
    handleRequiresCapabilityAttr(S, D, Attr);
    break;
   case AT_AssertCapability:
    handleAssertCapabilityAttr(S, D, Attr);
    break;
   case AT_AcquireCapability:
    handleAcquireCapabilityAttr(S, D, Attr);
    break;
   case AT_ReleaseCapability:
    handleReleaseCapabilityAttr(S, D, Attr);
    break;
   case AT_TryAcquireCapability:
    handleTryAcquireCapabilityAttr(S, D, Attr);
    break;
   case AT_Consumable:
    
    // Consumed analysis attributes.
    handleConsumableAttr(S, D, Attr);
    break;
   case AT_ConsumableAutoCast:
    handleSimpleAttribute/*<ConsumableAutoCastAttr>*/(ConsumableAutoCastAttr.class, S, D, Attr);
    break;
   case AT_ConsumableSetOnRead:
    handleSimpleAttribute/*<ConsumableSetOnReadAttr>*/(ConsumableSetOnReadAttr.class, S, D, Attr);
    break;
   case AT_CallableWhen:
    handleCallableWhenAttr(S, D, Attr);
    break;
   case AT_ParamTypestate:
    handleParamTypestateAttr(S, D, Attr);
    break;
   case AT_ReturnTypestate:
    handleReturnTypestateAttr(S, D, Attr);
    break;
   case AT_SetTypestate:
    handleSetTypestateAttr(S, D, Attr);
    break;
   case AT_TestTypestate:
    handleTestTypestateAttr(S, D, Attr);
    break;
   case AT_ArgumentWithTypeTag:
    
    // Type safety attributes.
    handleArgumentWithTypeTagAttr(S, D, Attr);
    break;
   case AT_TypeTagForDatatype:
    handleTypeTagForDatatypeAttr(S, D, Attr);
    break;
   case AT_RenderScriptKernel:
    handleSimpleAttribute/*<RenderScriptKernelAttr>*/(RenderScriptKernelAttr.class, S, D, Attr);
    break;
   case AT_XRayInstrument:
    // XRay attributes.
    handleSimpleAttribute/*<XRayInstrumentAttr>*/(XRayInstrumentAttr.class, S, D, Attr);
    break;
  }
}


/// checkUnusedDeclAttributes - Check a list of attributes to see if it
/// contains any decl attributes that we should warn about.
//<editor-fold defaultstate="collapsed" desc="checkUnusedDeclAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 5988,
 FQN="checkUnusedDeclAttributes", NM="_ZL25checkUnusedDeclAttributesRN5clang4SemaEPKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL25checkUnusedDeclAttributesRN5clang4SemaEPKNS_13AttributeListE")
//</editor-fold>
public static void checkUnusedDeclAttributes(final Sema /*&*/ S, /*const*/ AttributeList /*P*/ A) {
  for (; (A != null); A = A.getNext()) {
    // Only warn if the attribute is an unignored, non-type attribute.
    if (A.isUsedAsTypeAttr() || A.isInvalid()) {
      continue;
    }
    if (A.getKind() == AttributeList.Kind.IgnoredAttribute) {
      continue;
    }
    if (A.getKind() == AttributeList.Kind.UnknownAttribute) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(A.getLoc(), diag.warn_unknown_attribute_ignored)), 
                A.getName()), A.getRange()));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(A.getLoc(), diag.warn_attribute_not_on_decl)), 
                A.getName()), A.getRange()));
      } finally {
        $c$.$destroy();
      }
    }
  }
}


/// Is the given declaration allowed to use a forbidden type?
/// If so, it'll still be annotated with an attribute that makes it
/// illegal to actually use.
//<editor-fold defaultstate="collapsed" desc="isForbiddenTypeAllowed">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 6136,
 FQN="isForbiddenTypeAllowed", NM="_ZL22isForbiddenTypeAllowedRN5clang4SemaEPNS_4DeclERKNS_4sema17DelayedDiagnosticERNS_15UnavailableAttr14ImplicitReasonE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL22isForbiddenTypeAllowedRN5clang4SemaEPNS_4DeclERKNS_4sema17DelayedDiagnosticERNS_15UnavailableAttr14ImplicitReasonE")
//</editor-fold>
public static boolean isForbiddenTypeAllowed(final Sema /*&*/ S, Decl /*P*/ decl, 
                      final /*const*/ DelayedDiagnostic /*&*/ diagP, 
                      final type$ref<UnavailableAttr.ImplicitReason /*&*/> reason) {
  // Private ivars are always okay.  Unfortunately, people don't
  // always properly make their ivars private, even in system headers.
  // Plus we need to make fields okay, too.
  if (!isa_FieldDecl(decl) && !isa_ObjCPropertyDecl(decl)
     && !isa_FunctionDecl(decl)) {
    return false;
  }
  
  // Silently accept unsupported uses of __weak in both user and system
  // declarations when it's been disabled, for ease of integration with
  // -fno-objc-arc files.  We do have to take some care against attempts
  // to define such things;  for now, we've only done that for ivars
  // and properties.
  if ((isa_ObjCIvarDecl(decl) || isa_ObjCPropertyDecl(decl))) {
    if (diagP.getForbiddenTypeDiagnostic() == diag.err_arc_weak_disabled
       || diagP.getForbiddenTypeDiagnostic() == diag.err_arc_weak_no_runtime) {
      reason.$set(UnavailableAttr.ImplicitReason.IR_ForbiddenWeak);
      return true;
    }
  }
  
  // Allow all sorts of things in system headers.
  if (S.Context.getSourceManager().isInSystemHeader(decl.getLocation())) {
    // Currently, all the failures dealt with this way are due to ARC
    // restrictions.
    reason.$set(UnavailableAttr.ImplicitReason.IR_ARCForbiddenType);
    return true;
  }
  
  return false;
}


/// Handle a delayed forbidden-type diagnostic.
//<editor-fold defaultstate="collapsed" desc="handleDelayedForbiddenType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 6171,
 FQN="handleDelayedForbiddenType", NM="_ZL26handleDelayedForbiddenTypeRN5clang4SemaERNS_4sema17DelayedDiagnosticEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL26handleDelayedForbiddenTypeRN5clang4SemaERNS_4sema17DelayedDiagnosticEPNS_4DeclE")
//</editor-fold>
public static void handleDelayedForbiddenType(final Sema /*&*/ S, final DelayedDiagnostic /*&*/ diagP, 
                          Decl /*P*/ decl) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    type$ref<UnavailableAttr.ImplicitReason> reason = create_type$ref(UnavailableAttr.ImplicitReason.IR_None);
    if ((decl != null) && isForbiddenTypeAllowed(S, decl, diagP, reason)) {
      assert ((reason.$deref().getValue() != 0)) : "didn't set reason?";
      decl.addAttr(UnavailableAttr.CreateImplicit(S.Context, new StringRef(/*KEEP_STR*/$EMPTY), reason.$deref(), 
              new SourceRange(/*NO_COPY*/diagP.Loc)));
      return;
    }
    if (S.getLangOpts().ObjCAutoRefCount) {
      {
        /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(decl);
        if ((FD != null)) {
          // FIXME: we may want to suppress diagnostics for all
          // kind of forbidden type messages on unavailable functions. 
          if (FD.hasAttr(UnavailableAttr.class)
             && diagP.getForbiddenTypeDiagnostic()
             == diag.err_arc_array_param_no_ownership) {
            diagP.Triggered = true;
            return;
          }
        }
      }
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(diagP.Loc), diagP.getForbiddenTypeDiagnostic())), 
            diagP.getForbiddenTypeOperand()), diagP.getForbiddenTypeArgument()));
    diagP.Triggered = true;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="isDeclDeprecated">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 6197,
 FQN="isDeclDeprecated", NM="_ZL16isDeclDeprecatedPN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL16isDeclDeprecatedPN5clang4DeclE")
//</editor-fold>
public static boolean isDeclDeprecated(Decl /*P*/ D) {
  do {
    if (D.isDeprecated()) {
      return true;
    }
    {
      // A category implicitly has the availability of the interface.
      /*const*/ ObjCCategoryDecl /*P*/ CatD = dyn_cast_ObjCCategoryDecl(D);
      if ((CatD != null)) {
        {
          /*const*/ ObjCInterfaceDecl /*P*/ Interface = CatD.getClassInterface$Const();
          if ((Interface != null)) {
            return Interface.isDeprecated();
          }
        }
      }
    }
  } while (((D = cast_or_null_Decl(D.getDeclContext())) != null));
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isDeclUnavailable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 6209,
 FQN="isDeclUnavailable", NM="_ZL17isDeclUnavailablePN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL17isDeclUnavailablePN5clang4DeclE")
//</editor-fold>
public static boolean isDeclUnavailable(Decl /*P*/ D) {
  do {
    if (D.isUnavailable()) {
      return true;
    }
    {
      // A category implicitly has the availability of the interface.
      /*const*/ ObjCCategoryDecl /*P*/ CatD = dyn_cast_ObjCCategoryDecl(D);
      if ((CatD != null)) {
        {
          /*const*/ ObjCInterfaceDecl /*P*/ Interface = CatD.getClassInterface$Const();
          if ((Interface != null)) {
            return Interface.isUnavailable();
          }
        }
      }
    }
  } while (((D = cast_or_null_Decl(D.getDeclContext())) != null));
  return false;
}

//<editor-fold defaultstate="collapsed" desc="getAttrForPlatform">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 6221,
 FQN="getAttrForPlatform", NM="_ZL18getAttrForPlatformRN5clang10ASTContextEPKNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL18getAttrForPlatformRN5clang10ASTContextEPKNS_4DeclE")
//</editor-fold>
public static /*const*/ AvailabilityAttr /*P*/ getAttrForPlatform(final ASTContext /*&*/ Context, 
                  /*const*/ Decl /*P*/ D) {
  // Check each AvailabilityAttr to find the one for this platform.
  for (/*const*/ Attr /*P*/ A : D.attrs()) {
    {
      /*const*/ AvailabilityAttr /*P*/ Avail = dyn_cast_AvailabilityAttr(A);
      if ((Avail != null)) {
        // FIXME: this is copied from CheckAvailability. We should try to
        // de-duplicate.
        
        // Check if this is an App Extension "platform", and if so chop off
        // the suffix for matching with the actual platform.
        StringRef ActualPlatform = Avail.getPlatform().getName();
        StringRef RealizedPlatform = new StringRef(ActualPlatform);
        if (Context.getLangOpts().AppExt) {
          /*size_t*/int suffix = RealizedPlatform.rfind(/*STRINGREF_STR*/"_app_extension");
          if (suffix != StringRef.npos) {
            RealizedPlatform.$assignMove(RealizedPlatform.slice(0, suffix));
          }
        }
        
        StringRef TargetPlatform = Context.getTargetInfo().getPlatformName();
        
        // Match the platform name.
        if ($eq_StringRef(/*NO_COPY*/RealizedPlatform, /*NO_COPY*/TargetPlatform)) {
          return Avail;
        }
      }
    }
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="DoEmitAvailabilityWarning">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 6249,
 FQN="DoEmitAvailabilityWarning", NM="_ZL25DoEmitAvailabilityWarningRN5clang4SemaENS0_22AvailabilityDiagnosticEPNS_4DeclEPKNS_9NamedDeclEN4llvm9StringRefENS_14SourceLocationEPKNS_17ObjCInterfaceDeclEPKNS_16ObjCPropertyDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL25DoEmitAvailabilityWarningRN5clang4SemaENS0_22AvailabilityDiagnosticEPNS_4DeclEPKNS_9NamedDeclEN4llvm9StringRefENS_14SourceLocationEPKNS_17ObjCInterfaceDeclEPKNS_16ObjCPropertyDeclEb")
//</editor-fold>
public static void DoEmitAvailabilityWarning(final Sema /*&*/ S, Sema.AvailabilityDiagnostic K, 
                         Decl /*P*/ Ctx, /*const*/ NamedDecl /*P*/ D, 
                         StringRef Message, SourceLocation Loc, 
                         /*const*/ ObjCInterfaceDecl /*P*/ UnknownObjCClass, 
                         /*const*/ ObjCPropertyDecl /*P*/ ObjCProperty, 
                         boolean ObjCPropertyAccess) {
  // Diagnostics for deprecated or unavailable.
  /*uint*/final uint$ptr diagL = create_uint$ptr(0);
  /*uint*/int diag_message = 0, diag_fwdclass_message = 0;
  /*uint*/int diag_available_here = diag.note_availability_specified_here;
  
  // Matches 'diag::note_property_attribute' options.
  /*uint*/int property_note_select = 0;
  
  // Matches diag::note_availability_specified_here.
  /*uint*/int available_here_select_kind = 0;
  
  // Don't warn if our current context is deprecated or unavailable.
  switch (K) {
   case AD_Deprecation:
    if (isDeclDeprecated(Ctx) || isDeclUnavailable(Ctx)) {
      return;
    }
    diagL.$set(!ObjCPropertyAccess ? diag.warn_deprecated : diag.warn_property_method_deprecated);
    diag_message = diag.warn_deprecated_message;
    diag_fwdclass_message = diag.warn_deprecated_fwdclass_message;
    property_note_select = /* deprecated */ 0;
    available_here_select_kind = /* deprecated */ 2;
    break;
   case AD_Unavailable:
    if (isDeclUnavailable(Ctx)) {
      return;
    }
    diagL.$set(!ObjCPropertyAccess ? diag.err_unavailable : diag.err_property_method_unavailable);
    diag_message = diag.err_unavailable_message;
    diag_fwdclass_message = diag.warn_unavailable_fwdclass_message;
    property_note_select = /* unavailable */ 1;
    available_here_select_kind = /* unavailable */ 0;
    {
      
      UnavailableAttr /*P*/ attr = D.getAttr(UnavailableAttr.class);
      if ((attr != null)) {
        if (attr.isImplicit() && (attr.getImplicitReason().getValue() != 0)) {
          // Most of these failures are due to extra restrictions in ARC;
          // reflect that in the primary diagnostic when applicable.
          Void2Void flagARCError =  () ->
            {
              if (S.getLangOpts().ObjCAutoRefCount
                 && S.getSourceManager().isInSystemHeader(D.getLocation())) {
                diagL.$set(diag.err_unavailable_in_arc);
              }
            }
;
          switch (attr.getImplicitReason()) {
           case IR_None:
            break;
           case IR_ARCForbiddenType:
            flagARCError.$call();
            diag_available_here = diag.note_arc_forbidden_type;
            break;
           case IR_ForbiddenWeak:
            if (S.getLangOpts().ObjCWeakRuntime) {
              diag_available_here = diag.note_arc_weak_disabled;
            } else {
              diag_available_here = diag.note_arc_weak_no_runtime;
            }
            break;
           case IR_ARCForbiddenConversion:
            flagARCError.$call();
            diag_available_here = diag.note_performs_forbidden_arc_conversion;
            break;
           case IR_ARCInitReturnsUnrelated:
            flagARCError.$call();
            diag_available_here = diag.note_arc_init_returns_unrelated;
            break;
           case IR_ARCFieldWithOwnership:
            flagARCError.$call();
            diag_available_here = diag.note_arc_field_with_ownership;
            break;
          }
        }
      }
    }
    break;
   case AD_Partial:
    diagL.$set(diag.warn_partial_availability);
    diag_message = diag.warn_partial_message;
    diag_fwdclass_message = diag.warn_partial_fwdclass_message;
    property_note_select = /* partial */ 2;
    available_here_select_kind = /* partial */ 3;
    break;
  }
  
  CharSourceRange UseRange/*J*/= new CharSourceRange();
  StringRef Replacement/*J*/= new StringRef();
  if (K == Sema.AvailabilityDiagnostic.AD_Deprecation) {
    {
      DeprecatedAttr /*P*/ attr = D.getAttr(DeprecatedAttr.class);
      if ((attr != null)) {
        Replacement.$assignMove(attr.getReplacement());
      }
    }
    {
      /*const*/ AvailabilityAttr /*P*/ attr = getAttrForPlatform(S.Context, D);
      if ((attr != null)) {
        Replacement.$assignMove(attr.getReplacement());
      }
    }
    if (!Replacement.empty()) {
      UseRange.$assignMove(
          CharSourceRange.getCharRange(/*NO_COPY*/Loc, S.getLocForEndOfToken(new SourceLocation(Loc)))
      );
    }
  }
  if (!Message.empty()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag_message)), D), Message), 
          (UseRange.isValid() ? FixItHint.CreateReplacement(/*NO_COPY*/UseRange, /*NO_COPY*/Replacement) : new FixItHint())));
      if ((ObjCProperty != null)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(ObjCProperty.getLocation(), diag.note_property_attribute)), 
                ObjCProperty.getDeclName()), property_note_select));
      }
    } finally {
      $c$.$destroy();
    }
  } else if (!(UnknownObjCClass != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diagL.$star())), D), 
          (UseRange.isValid() ? FixItHint.CreateReplacement(/*NO_COPY*/UseRange, /*NO_COPY*/Replacement) : new FixItHint())));
      if ((ObjCProperty != null)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(ObjCProperty.getLocation(), diag.note_property_attribute)), 
                ObjCProperty.getDeclName()), property_note_select));
      }
    } finally {
      $c$.$destroy();
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag_fwdclass_message)), D), 
          (UseRange.isValid() ? FixItHint.CreateReplacement(/*NO_COPY*/UseRange, /*NO_COPY*/Replacement) : new FixItHint())));
      $c$.clean($c$.track(S.Diag(UnknownObjCClass.getLocation(), diag.note_forward_class)));
    } finally {
      $c$.$destroy();
    }
  }
  
  // The declaration can have multiple availability attributes, we are looking
  // at one of them.
  /*const*/ AvailabilityAttr /*P*/ A = getAttrForPlatform(S.Context, D);
  if ((A != null) && A.isInherited()) {
    for (/*const*/ Decl /*P*/ Redecl = D.getMostRecentDecl$Const(); (Redecl != null);
         Redecl = Redecl.getPreviousDecl$Const()) {
      /*const*/ AvailabilityAttr /*P*/ AForRedecl = getAttrForPlatform(S.Context, 
          Redecl);
      if ((AForRedecl != null) && !AForRedecl.isInherited()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // If D is a declaration with inherited attributes, the note should
          // point to the declaration with actual attributes.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Redecl.getLocation(), diag_available_here)), D), 
              available_here_select_kind));
          break;
        } finally {
          $c$.$destroy();
        }
      }
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getLocation(), diag_available_here)), 
              D), available_here_select_kind));
    } finally {
      $c$.$destroy();
    }
  }
  if (K == Sema.AvailabilityDiagnostic.AD_Partial) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.note_partial_availability_silence)), D));
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="handleDelayedAvailabilityCheck">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 6400,
 FQN="handleDelayedAvailabilityCheck", NM="_ZL30handleDelayedAvailabilityCheckRN5clang4SemaERNS_4sema17DelayedDiagnosticEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZL30handleDelayedAvailabilityCheckRN5clang4SemaERNS_4sema17DelayedDiagnosticEPNS_4DeclE")
//</editor-fold>
public static void handleDelayedAvailabilityCheck(final Sema /*&*/ S, final DelayedDiagnostic /*&*/ DD, 
                              Decl /*P*/ Ctx) {
  assert ($uchar2int(DD.Kind) == DelayedDiagnostic.DDKind.Deprecation.getValue() || $uchar2int(DD.Kind) == DelayedDiagnostic.DDKind.Unavailable.getValue());
  Sema.AvailabilityDiagnostic AD = $uchar2int(DD.Kind) == DelayedDiagnostic.DDKind.Deprecation.getValue() ? Sema.AvailabilityDiagnostic.AD_Deprecation : Sema.AvailabilityDiagnostic.AD_Unavailable;
  DD.Triggered = true;
  DoEmitAvailabilityWarning(S, AD, Ctx, DD.getDeprecationDecl(), DD.getDeprecationMessage(), new SourceLocation(DD.Loc), 
      DD.getUnknownObjCClass(), DD.getObjCProperty(), false);
}

} // END OF class SemaDeclAttrStatics
