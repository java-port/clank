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
import static org.clank.java.io.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
;
import org.clang.basic.*;
import org.clang.sema.impl.*;
import org.clang.basic.target.*;;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type AttrParsedAttrImplGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L11AttrInfoMapE;_ZN12_GLOBAL__N_1L11isGlobalVarEPKN5clang4DeclE;_ZN12_GLOBAL__N_1L11isSharedVarEPKN5clang4DeclE;_ZN12_GLOBAL__N_1L11isTargetx86ERKN5clang10TargetInfoE;_ZN12_GLOBAL__N_1L12isNonParmVarEPKN5clang4DeclE;_ZN12_GLOBAL__N_1L14isFunctionLikeEPKN5clang4DeclE;_ZN12_GLOBAL__N_1L17checkCUDALangOptsERN5clang4SemaERKNS0_13AttributeListE;_ZN12_GLOBAL__N_1L18isHasFunctionProtoEPKN5clang4DeclE;_ZN12_GLOBAL__N_1L18isTargetmipsmipselERKN5clang10TargetInfoE;_ZN12_GLOBAL__N_1L19checkOpenCLLangOptsERN5clang4SemaERKNS0_13AttributeListE;_ZN12_GLOBAL__N_1L19defaultAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L20checkHotAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L20isObjCInstanceMethodEPKN5clang4DeclE;_ZN12_GLOBAL__N_1L21UnusedAttrSpellingMapERKN5clang13AttributeListE;_ZN12_GLOBAL__N_1L21checkColdAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L21checkModeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L21checkWeakAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L22AlignedAttrSpellingMapERKN5clang13AttributeListE;_ZN12_GLOBAL__N_1L22SectionAttrSpellingMapERKN5clang13AttributeListE;_ZN12_GLOBAL__N_1L22checkAliasAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L22checkCPlusPlusLangOptsERN5clang4SemaERKNS0_13AttributeListE;_ZN12_GLOBAL__N_1L22checkIFuncAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L22checkNakedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L23LoopHintAttrSpellingMapERKN5clang13AttributeListE;_ZN12_GLOBAL__N_1L23RestrictAttrSpellingMapERKN5clang13AttributeListE;_ZN12_GLOBAL__N_1L23checkAbiTagAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L23checkCommonAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L23checkFormatAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L23checkMips16AppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L23checkTargetAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L23checkThreadAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L23checkUnusedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L23defaultDiagnoseLangOptsERN5clang4SemaERKNS0_13AttributeListE;_ZN12_GLOBAL__N_1L24OwnershipAttrSpellingMapERKN5clang13AttributeListE;_ZN12_GLOBAL__N_1L24checkCleanupAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L24checkFlattenAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L24checkMinSizeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L24checkNoAliasAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L24checkNoDebugAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L24checkNonNullAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L24checkSectionAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L24checkWeakRefAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L25CapabilityAttrSpellingMapERKN5clang13AttributeListE;_ZN12_GLOBAL__N_1L25checkCUDAHostAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L25checkEnableIfAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L25checkFlagEnumAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L25checkIBActionAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L25checkLockableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L25checkMSStructAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L25checkMicrosoftExtLangOptsERN5clang4SemaERKNS0_13AttributeListE;_ZN12_GLOBAL__N_1L25checkNoCommonAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L25checkNoInlineAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L25checkNoMips16AppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L25checkRenderScriptLangOptsERN5clang4SemaERKNS0_13AttributeListE;_ZN12_GLOBAL__N_1L25checkRestrictAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L25checkTLSModelAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L25defaultTargetRequirementsERKN5clang10TargetInfoE;_ZN12_GLOBAL__N_1L26checkDLLExportAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L26checkDLLImportAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L26checkFormatArgAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L26checkGNUInlineAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L26checkGuardedByAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L26checkOwnershipAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L26checkVecReturnAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L27AlwaysInlineAttrSpellingMapERKN5clang13AttributeListE;_ZN12_GLOBAL__N_1L27OpenCLAccessAttrSpellingMapERKN5clang13AttributeListE;_ZN12_GLOBAL__N_1L27checkAlignValueAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L27checkCFConsumedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L27checkCUDADeviceAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L27checkCUDAGlobalAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L27checkCUDASharedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L27checkCapabilityAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L27checkConsumableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L27checkDestructorAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L27checkEmptyBasesAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L27checkGuardedVarAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L27checkMSNoVTableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L27checkNSConsumedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L27checkNoSanitizeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L27checkObjCBridgeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L27checkWarnUnusedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L28MSInheritanceAttrSpellingMapERKN5clang13AttributeListE;_ZN12_GLOBAL__N_1L28checkConstructorAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L28checkNoDuplicateAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L28checkObjCBoxableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L28checkOpenCLNoSVMAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L28checkPtGuardedByAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L28checkVecTypeHintAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L29XRayInstrumentAttrSpellingMapERKN5clang13AttributeListE;_ZN12_GLOBAL__N_1L29checkAlwaysInlineAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L29checkCUDAConstantAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L29checkCallableWhenAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L29checkInitPriorityAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L29checkLockReturnedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L29checkNoSplitStackAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L29checkOpenCLAccessAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L29checkOpenCLKernelAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L29checkOptimizeNoneAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L29checkOverloadableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L29checkPtGuardedVarAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L29checkReturnsTwiceAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L29checkSetTypestateAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L29checkSwiftContextAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L29isObjCInterfaceDeclInitMethodEPKN5clang4DeclE;_ZN12_GLOBAL__N_1L30checkAMDGPUNumSGPRAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L30checkAMDGPUNumVGPRAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L30checkAcquiredAfterAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L30checkAssumeAlignedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L30checkCXX11NoReturnAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L30checkExtVectorTypeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L30checkLayoutVersionAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L30checkLocksExcludedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L30checkNotTailCalledAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L30checkObjCExceptionAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L30checkObjCRootClassAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L30checkTestTypestateAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L30isTargetx86x86_64armthumbWin32ERKN5clang10TargetInfoE;_ZN12_GLOBAL__N_1L31AssertCapabilityAttrSpellingMapERKN5clang13AttributeListE;_ZN12_GLOBAL__N_1L31WarnUnusedResultAttrSpellingMapERKN5clang13AttributeListE;_ZN12_GLOBAL__N_1L31checkAcquiredBeforeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L31checkNSConsumesSelfAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L31checkParamTypestateAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L31checkPassObjectSizeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L31checkReturnsNonNullAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L31checkScopedLockableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L31checkXRayInstrumentAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L32AcquireCapabilityAttrSpellingMapERKN5clang13AttributeListE;_ZN12_GLOBAL__N_1L32ReleaseCapabilityAttrSpellingMapERKN5clang13AttributeListE;_ZN12_GLOBAL__N_1L32checkInternalLinkageAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L32checkMicrosoftExtBorlandLangOptsERN5clang4SemaERKNS0_13AttributeListE;_ZN12_GLOBAL__N_1L32checkObjCRuntimeNameAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L32checkReturnTypestateAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L33RequiresCapabilityAttrSpellingMapERKN5clang13AttributeListE;_ZN12_GLOBAL__N_1L33checkAssertCapabilityAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L33checkAssertSharedLockAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L33checkCUDALaunchBoundsAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L33checkDisableTailCallsAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L33checkObjCMethodFamilyAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L33checkSwiftErrorResultAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L33checkWarnUnusedResultAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L34ArgumentWithTypeTagAttrSpellingMapERKN5clang13AttributeListE;_ZN12_GLOBAL__N_1L34checkAcquireCapabilityAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L34checkCFAuditedTransferAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L34checkCFUnknownTransferAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L34checkCUDAInvalidTargetAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L34checkCarriesDependencyAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L34checkObjCBridgeMutableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L34checkObjCBridgeRelatedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L34checkObjCRequiresSuperAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L34checkReleaseCapabilityAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L34checkReqdWorkGroupSizeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L34checkWorkGroupSizeHintAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L34isTargetx86x86_64armthumbMicrosoftERKN5clang10TargetInfoE;_ZN12_GLOBAL__N_1L35TryAcquireCapabilityAttrSpellingMapERKN5clang13AttributeListE;_ZN12_GLOBAL__N_1L35checkConsumableAutoCastAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L35checkNoSanitizeSpecificAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L35checkObjCRuntimeVisibleAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L35checkRenderScriptKernelAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L35checkRequiresCapabilityAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L36checkAssertExclusiveLockAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L36checkConsumableSetOnReadAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L36checkLTOVisibilityPublicAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L36checkObjCPreciseLifetimeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L36checkSwiftIndirectResultAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L37checkNoInstrumentFunctionAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L37checkTryAcquireCapabilityAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L38checkArcWeakrefUnavailableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L38checkSharedTrylockFunctionAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L38defaultSpellingIndexToSemanticSpellingERKN5clang13AttributeListE;_ZN12_GLOBAL__N_1L39checkNoThreadSafetyAnalysisAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L40checkObjCReturnsInnerPointerAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L41checkExclusiveTrylockFunctionAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L41checkObjCExplicitProtocolImplAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L41checkObjCRequiresPropertyDefsAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L41isTargetarmthumbx86x86_64msp430mipsmipselERKN5clang10TargetInfoE;_ZN12_GLOBAL__N_1L42checkObjCDesignatedInitializerAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE;_ZN12_GLOBAL__N_1L8isStructEPKN5clang4DeclE;_ZN12_GLOBAL__N_1L8isTLSVarEPKN5clang4DeclE; -static-type=AttrParsedAttrImplGlobals -package=org.clang.sema")
//</editor-fold>
public final class AttrParsedAttrImplGlobals {

/*===- TableGen'erated file -------------------------------------*- C++ -*-===*\
|*                                                                            *|
|* Parsed attribute helpers                                                   *|
|*                                                                            *|
|* Automatically generated file, do not edit!                                 *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::defaultAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 9,
 FQN="(anonymous namespace)::defaultAppertainsTo", NM="_ZN12_GLOBAL__N_1L19defaultAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L19defaultAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean defaultAppertainsTo(final Sema /*&*/ $Prm0, final /*const*/ AttributeList /*&*/ $Prm1, /*const*/ Decl /*P*/ $Prm2) {
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::defaultDiagnoseLangOpts">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 13,
 FQN="(anonymous namespace)::defaultDiagnoseLangOpts", NM="_ZN12_GLOBAL__N_1L23defaultDiagnoseLangOptsERN5clang4SemaERKNS0_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L23defaultDiagnoseLangOptsERN5clang4SemaERKNS0_13AttributeListE")
//</editor-fold>
public static boolean defaultDiagnoseLangOpts(final Sema /*&*/ $Prm0, final /*const*/ AttributeList /*&*/ $Prm1) {
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::defaultTargetRequirements">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 17,
 FQN="(anonymous namespace)::defaultTargetRequirements", NM="_ZN12_GLOBAL__N_1L25defaultTargetRequirementsERKN5clang10TargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L25defaultTargetRequirementsERKN5clang10TargetInfoE")
//</editor-fold>
public static boolean defaultTargetRequirements(final /*const*/ TargetInfo /*&*/ $Prm0) {
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::defaultSpellingIndexToSemanticSpelling">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 21,
 FQN="(anonymous namespace)::defaultSpellingIndexToSemanticSpelling", NM="_ZN12_GLOBAL__N_1L38defaultSpellingIndexToSemanticSpellingERKN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L38defaultSpellingIndexToSemanticSpellingERKN5clang13AttributeListE")
//</editor-fold>
public static /*uint*/int defaultSpellingIndexToSemanticSpelling(final /*const*/ AttributeList /*&*/ Attr) {
  return UINT_MAX;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkAMDGPUNumSGPRAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 25,
 FQN="(anonymous namespace)::checkAMDGPUNumSGPRAppertainsTo", NM="_ZN12_GLOBAL__N_1L30checkAMDGPUNumSGPRAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L30checkAMDGPUNumSGPRAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkAMDGPUNumSGPRAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedKernelFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkAMDGPUNumVGPRAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 34,
 FQN="(anonymous namespace)::checkAMDGPUNumVGPRAppertainsTo", NM="_ZN12_GLOBAL__N_1L30checkAMDGPUNumVGPRAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L30checkAMDGPUNumVGPRAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkAMDGPUNumVGPRAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedKernelFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isTargetarmthumbx86x86_64msp430mipsmipsel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 43,
 FQN="(anonymous namespace)::isTargetarmthumbx86x86_64msp430mipsmipsel", NM="_ZN12_GLOBAL__N_1L41isTargetarmthumbx86x86_64msp430mipsmipselERKN5clang10TargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L41isTargetarmthumbx86x86_64msp430mipsmipselERKN5clang10TargetInfoE")
//</editor-fold>
public static boolean isTargetarmthumbx86x86_64msp430mipsmipsel(final /*const*/ TargetInfo /*&*/ Target) {
  final /*const*/ Triple /*&*/ T = Target.getTriple();
  return (T.getArch() == Triple.ArchType.arm || T.getArch() == Triple.ArchType.thumb || T.getArch() == Triple.ArchType.x86 || T.getArch() == Triple.ArchType.x86_64 || T.getArch() == Triple.ArchType.msp430 || T.getArch() == Triple.ArchType.mips || T.getArch() == Triple.ArchType.mipsel);
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 48,
 FQN="(anonymous namespace)::isStruct", NM="_ZN12_GLOBAL__N_1L8isStructEPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L8isStructEPKN5clang4DeclE")
//</editor-fold>
public static boolean isStruct(/*const*/ Decl /*P*/ D) {
  {
    /*const*/ RecordDecl /*P*/ S = dyn_cast_RecordDecl(D);
    if ((S != null)) {
      return !S.isUnion();
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkAbiTagAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 54,
 FQN="(anonymous namespace)::checkAbiTagAppertainsTo", NM="_ZN12_GLOBAL__N_1L23checkAbiTagAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L23checkAbiTagAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkAbiTagAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isStruct(D) && !isa_VarDecl(D) && !isa_FunctionDecl(D) && !isa_NamespaceDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedStructClassVariableFunctionOrInlineNamespace));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkAcquireCapabilityAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 63,
 FQN="(anonymous namespace)::checkAcquireCapabilityAppertainsTo", NM="_ZN12_GLOBAL__N_1L34checkAcquireCapabilityAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L34checkAcquireCapabilityAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkAcquireCapabilityAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AcquireCapabilityAttrSpellingMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 72,
 FQN="(anonymous namespace)::AcquireCapabilityAttrSpellingMap", NM="_ZN12_GLOBAL__N_1L32AcquireCapabilityAttrSpellingMapERKN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L32AcquireCapabilityAttrSpellingMapERKN5clang13AttributeListE")
//</editor-fold>
public static /*uint*/int AcquireCapabilityAttrSpellingMap(final /*const*/ AttributeList /*&*/ Attr) {
  final class/*enum*/ Spelling {
    private static final /*uint*/int GNU_acquire_capability = 0;
    private static final /*uint*/int CXX11_clang_acquire_capability = 1;
    private static final /*uint*/int GNU_acquire_shared_capability = 2;
    private static final /*uint*/int CXX11_clang_acquire_shared_capability = 3;
    private static final /*uint*/int GNU_exclusive_lock_function = 4;
    private static final /*uint*/int GNU_shared_lock_function = 5;
  };
  
  /*uint*/int Idx = Attr.getAttributeSpellingListIndex();
  switch (Idx) {
   default:
    throw new llvm_unreachable("Unknown spelling list index");
   case 0:
    return Spelling.GNU_acquire_capability;
   case 1:
    return Spelling.CXX11_clang_acquire_capability;
   case 2:
    return Spelling.GNU_acquire_shared_capability;
   case 3:
    return Spelling.CXX11_clang_acquire_shared_capability;
   case 4:
    return Spelling.GNU_exclusive_lock_function;
   case 5:
    return Spelling.GNU_shared_lock_function;
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isSharedVar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 94,
 FQN="(anonymous namespace)::isSharedVar", NM="_ZN12_GLOBAL__N_1L11isSharedVarEPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L11isSharedVarEPKN5clang4DeclE")
//</editor-fold>
public static boolean isSharedVar(/*const*/ Decl /*P*/ D) {
  {
    /*const*/ VarDecl /*P*/ S = dyn_cast_VarDecl(D);
    if ((S != null)) {
      return S.hasGlobalStorage() && !(S.getTLSKind().getValue() != 0);
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkAcquiredAfterAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 100,
 FQN="(anonymous namespace)::checkAcquiredAfterAppertainsTo", NM="_ZN12_GLOBAL__N_1L30checkAcquiredAfterAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L30checkAcquiredAfterAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkAcquiredAfterAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FieldDecl(D) && !isSharedVar(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFieldOrGlobalVar));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkAcquiredBeforeAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 109,
 FQN="(anonymous namespace)::checkAcquiredBeforeAppertainsTo", NM="_ZN12_GLOBAL__N_1L31checkAcquiredBeforeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L31checkAcquiredBeforeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkAcquiredBeforeAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FieldDecl(D) && !isSharedVar(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFieldOrGlobalVar));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isGlobalVar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 118,
 FQN="(anonymous namespace)::isGlobalVar", NM="_ZN12_GLOBAL__N_1L11isGlobalVarEPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L11isGlobalVarEPKN5clang4DeclE")
//</editor-fold>
public static boolean isGlobalVar(/*const*/ Decl /*P*/ D) {
  {
    /*const*/ VarDecl /*P*/ S = dyn_cast_VarDecl(D);
    if ((S != null)) {
      return S.hasGlobalStorage();
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkAliasAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 124,
 FQN="(anonymous namespace)::checkAliasAppertainsTo", NM="_ZN12_GLOBAL__N_1L22checkAliasAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L22checkAliasAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkAliasAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D) && !isGlobalVar(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunctionGlobalVarMethodOrProperty));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkAlignValueAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 133,
 FQN="(anonymous namespace)::checkAlignValueAppertainsTo", NM="_ZN12_GLOBAL__N_1L27checkAlignValueAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L27checkAlignValueAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkAlignValueAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_VarDecl(D) && !isa_TypedefNameDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedVariableOrTypedef));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AlignedAttrSpellingMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 142,
 FQN="(anonymous namespace)::AlignedAttrSpellingMap", NM="_ZN12_GLOBAL__N_1L22AlignedAttrSpellingMapERKN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L22AlignedAttrSpellingMapERKN5clang13AttributeListE")
//</editor-fold>
public static /*uint*/int AlignedAttrSpellingMap(final /*const*/ AttributeList /*&*/ Attr) {
  final class/*enum*/ Spelling {
    private static final /*uint*/int GNU_aligned = 0;
    private static final /*uint*/int CXX11_gnu_aligned = 1;
    private static final /*uint*/int Declspec_align = 2;
    private static final /*uint*/int Keyword_alignas = 3;
    private static final /*uint*/int Keyword_Alignas = 4;
  };
  
  /*uint*/int Idx = Attr.getAttributeSpellingListIndex();
  switch (Idx) {
   default:
    throw new llvm_unreachable("Unknown spelling list index");
   case 0:
    return Spelling.GNU_aligned;
   case 1:
    return Spelling.CXX11_gnu_aligned;
   case 2:
    return Spelling.Declspec_align;
   case 3:
    return Spelling.Keyword_alignas;
   case 4:
    return Spelling.Keyword_Alignas;
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkAlwaysInlineAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 162,
 FQN="(anonymous namespace)::checkAlwaysInlineAppertainsTo", NM="_ZN12_GLOBAL__N_1L29checkAlwaysInlineAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L29checkAlwaysInlineAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkAlwaysInlineAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AlwaysInlineAttrSpellingMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 171,
 FQN="(anonymous namespace)::AlwaysInlineAttrSpellingMap", NM="_ZN12_GLOBAL__N_1L27AlwaysInlineAttrSpellingMapERKN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L27AlwaysInlineAttrSpellingMapERKN5clang13AttributeListE")
//</editor-fold>
public static /*uint*/int AlwaysInlineAttrSpellingMap(final /*const*/ AttributeList /*&*/ Attr) {
  final class/*enum*/ Spelling {
    private static final /*uint*/int GNU_always_inline = 0;
    private static final /*uint*/int CXX11_gnu_always_inline = 1;
    private static final /*uint*/int Keyword_forceinline = 2;
  };
  
  /*uint*/int Idx = Attr.getAttributeSpellingListIndex();
  switch (Idx) {
   default:
    throw new llvm_unreachable("Unknown spelling list index");
   case 0:
    return Spelling.GNU_always_inline;
   case 1:
    return Spelling.CXX11_gnu_always_inline;
   case 2:
    return Spelling.Keyword_forceinline;
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkArcWeakrefUnavailableAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 187,
 FQN="(anonymous namespace)::checkArcWeakrefUnavailableAppertainsTo", NM="_ZN12_GLOBAL__N_1L38checkArcWeakrefUnavailableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L38checkArcWeakrefUnavailableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkArcWeakrefUnavailableAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ObjCInterfaceDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedObjectiveCInterface));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ArgumentWithTypeTagAttrSpellingMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 196,
 FQN="(anonymous namespace)::ArgumentWithTypeTagAttrSpellingMap", NM="_ZN12_GLOBAL__N_1L34ArgumentWithTypeTagAttrSpellingMapERKN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L34ArgumentWithTypeTagAttrSpellingMapERKN5clang13AttributeListE")
//</editor-fold>
public static /*uint*/int ArgumentWithTypeTagAttrSpellingMap(final /*const*/ AttributeList /*&*/ Attr) {
  final class/*enum*/ Spelling {
    private static final /*uint*/int GNU_argument_with_type_tag = 0;
    private static final /*uint*/int GNU_pointer_with_type_tag = 1;
  };
  
  /*uint*/int Idx = Attr.getAttributeSpellingListIndex();
  switch (Idx) {
   default:
    throw new llvm_unreachable("Unknown spelling list index");
   case 0:
    return Spelling.GNU_argument_with_type_tag;
   case 1:
    return Spelling.GNU_pointer_with_type_tag;
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkAssertCapabilityAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 210,
 FQN="(anonymous namespace)::checkAssertCapabilityAppertainsTo", NM="_ZN12_GLOBAL__N_1L33checkAssertCapabilityAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L33checkAssertCapabilityAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkAssertCapabilityAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssertCapabilityAttrSpellingMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 219,
 FQN="(anonymous namespace)::AssertCapabilityAttrSpellingMap", NM="_ZN12_GLOBAL__N_1L31AssertCapabilityAttrSpellingMapERKN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L31AssertCapabilityAttrSpellingMapERKN5clang13AttributeListE")
//</editor-fold>
public static /*uint*/int AssertCapabilityAttrSpellingMap(final /*const*/ AttributeList /*&*/ Attr) {
  final class/*enum*/ Spelling {
    private static final /*uint*/int GNU_assert_capability = 0;
    private static final /*uint*/int CXX11_clang_assert_capability = 1;
    private static final /*uint*/int GNU_assert_shared_capability = 2;
    private static final /*uint*/int CXX11_clang_assert_shared_capability = 3;
  };
  
  /*uint*/int Idx = Attr.getAttributeSpellingListIndex();
  switch (Idx) {
   default:
    throw new llvm_unreachable("Unknown spelling list index");
   case 0:
    return Spelling.GNU_assert_capability;
   case 1:
    return Spelling.CXX11_clang_assert_capability;
   case 2:
    return Spelling.GNU_assert_shared_capability;
   case 3:
    return Spelling.CXX11_clang_assert_shared_capability;
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkAssertExclusiveLockAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 237,
 FQN="(anonymous namespace)::checkAssertExclusiveLockAppertainsTo", NM="_ZN12_GLOBAL__N_1L36checkAssertExclusiveLockAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L36checkAssertExclusiveLockAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkAssertExclusiveLockAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkAssertSharedLockAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 246,
 FQN="(anonymous namespace)::checkAssertSharedLockAppertainsTo", NM="_ZN12_GLOBAL__N_1L33checkAssertSharedLockAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L33checkAssertSharedLockAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkAssertSharedLockAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkAssumeAlignedAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 255,
 FQN="(anonymous namespace)::checkAssumeAlignedAppertainsTo", NM="_ZN12_GLOBAL__N_1L30checkAssumeAlignedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L30checkAssumeAlignedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkAssumeAlignedAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ObjCMethodDecl(D) && !isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunctionOrMethod));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkCFAuditedTransferAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 264,
 FQN="(anonymous namespace)::checkCFAuditedTransferAppertainsTo", NM="_ZN12_GLOBAL__N_1L34checkCFAuditedTransferAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L34checkCFAuditedTransferAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkCFAuditedTransferAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkCFConsumedAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 273,
 FQN="(anonymous namespace)::checkCFConsumedAppertainsTo", NM="_ZN12_GLOBAL__N_1L27checkCFConsumedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L27checkCFConsumedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkCFConsumedAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ParmVarDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedParameter));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkCFUnknownTransferAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 282,
 FQN="(anonymous namespace)::checkCFUnknownTransferAppertainsTo", NM="_ZN12_GLOBAL__N_1L34checkCFUnknownTransferAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L34checkCFUnknownTransferAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkCFUnknownTransferAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkCUDAConstantAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 291,
 FQN="(anonymous namespace)::checkCUDAConstantAppertainsTo", NM="_ZN12_GLOBAL__N_1L29checkCUDAConstantAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L29checkCUDAConstantAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkCUDAConstantAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_VarDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedVariable));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkCUDALangOpts">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 300,
 FQN="(anonymous namespace)::checkCUDALangOpts", NM="_ZN12_GLOBAL__N_1L17checkCUDALangOptsERN5clang4SemaERKNS0_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L17checkCUDALangOptsERN5clang4SemaERKNS0_13AttributeListE")
//</editor-fold>
public static boolean checkCUDALangOpts(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (S.LangOpts.CUDA) {
      return true;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_ignored)), Attr.getName()));
    return false;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkCUDADeviceAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 308,
 FQN="(anonymous namespace)::checkCUDADeviceAppertainsTo", NM="_ZN12_GLOBAL__N_1L27checkCUDADeviceAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L27checkCUDADeviceAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkCUDADeviceAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D) && !isa_VarDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedVariableOrFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkCUDAGlobalAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 317,
 FQN="(anonymous namespace)::checkCUDAGlobalAppertainsTo", NM="_ZN12_GLOBAL__N_1L27checkCUDAGlobalAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L27checkCUDAGlobalAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkCUDAGlobalAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkCUDAHostAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 326,
 FQN="(anonymous namespace)::checkCUDAHostAppertainsTo", NM="_ZN12_GLOBAL__N_1L25checkCUDAHostAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L25checkCUDAHostAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkCUDAHostAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkCUDAInvalidTargetAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 335,
 FQN="(anonymous namespace)::checkCUDAInvalidTargetAppertainsTo", NM="_ZN12_GLOBAL__N_1L34checkCUDAInvalidTargetAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L34checkCUDAInvalidTargetAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkCUDAInvalidTargetAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isFunctionLike">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 344,
 FQN="(anonymous namespace)::isFunctionLike", NM="_ZN12_GLOBAL__N_1L14isFunctionLikeEPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L14isFunctionLikeEPKN5clang4DeclE")
//</editor-fold>
public static boolean isFunctionLike(/*const*/ Decl /*P*/ D) {
  {
    /*const*/ Decl /*P*/ S = dyn_cast_Decl(D);
    if ((S != null)) {
      return S.getFunctionType(false) != null;
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkCUDALaunchBoundsAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 350,
 FQN="(anonymous namespace)::checkCUDALaunchBoundsAppertainsTo", NM="_ZN12_GLOBAL__N_1L33checkCUDALaunchBoundsAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L33checkCUDALaunchBoundsAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkCUDALaunchBoundsAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ObjCMethodDecl(D) && !isFunctionLike(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunctionOrMethod));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkCUDASharedAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 359,
 FQN="(anonymous namespace)::checkCUDASharedAppertainsTo", NM="_ZN12_GLOBAL__N_1L27checkCUDASharedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L27checkCUDASharedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkCUDASharedAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_VarDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedVariable));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkCXX11NoReturnAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 368,
 FQN="(anonymous namespace)::checkCXX11NoReturnAppertainsTo", NM="_ZN12_GLOBAL__N_1L30checkCXX11NoReturnAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L30checkCXX11NoReturnAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkCXX11NoReturnAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkCallableWhenAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 377,
 FQN="(anonymous namespace)::checkCallableWhenAppertainsTo", NM="_ZN12_GLOBAL__N_1L29checkCallableWhenAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L29checkCallableWhenAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkCallableWhenAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_CXXMethodDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedMethod));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkCapabilityAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 386,
 FQN="(anonymous namespace)::checkCapabilityAppertainsTo", NM="_ZN12_GLOBAL__N_1L27checkCapabilityAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L27checkCapabilityAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkCapabilityAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_RecordDecl(D) && !isa_TypedefNameDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedStructOrUnionOrTypedef));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CapabilityAttrSpellingMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 395,
 FQN="(anonymous namespace)::CapabilityAttrSpellingMap", NM="_ZN12_GLOBAL__N_1L25CapabilityAttrSpellingMapERKN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L25CapabilityAttrSpellingMapERKN5clang13AttributeListE")
//</editor-fold>
public static /*uint*/int CapabilityAttrSpellingMap(final /*const*/ AttributeList /*&*/ Attr) {
  final class/*enum*/ Spelling {
    private static final /*uint*/int GNU_capability = 0;
    private static final /*uint*/int CXX11_clang_capability = 1;
    private static final /*uint*/int GNU_shared_capability = 2;
    private static final /*uint*/int CXX11_clang_shared_capability = 3;
  };
  
  /*uint*/int Idx = Attr.getAttributeSpellingListIndex();
  switch (Idx) {
   default:
    throw new llvm_unreachable("Unknown spelling list index");
   case 0:
    return Spelling.GNU_capability;
   case 1:
    return Spelling.CXX11_clang_capability;
   case 2:
    return Spelling.GNU_shared_capability;
   case 3:
    return Spelling.CXX11_clang_shared_capability;
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkCarriesDependencyAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 413,
 FQN="(anonymous namespace)::checkCarriesDependencyAppertainsTo", NM="_ZN12_GLOBAL__N_1L34checkCarriesDependencyAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L34checkCarriesDependencyAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkCarriesDependencyAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ParmVarDecl(D) && !isa_ObjCMethodDecl(D) && !isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunctionMethodOrParameter));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkCleanupAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 422,
 FQN="(anonymous namespace)::checkCleanupAppertainsTo", NM="_ZN12_GLOBAL__N_1L24checkCleanupAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L24checkCleanupAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkCleanupAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_VarDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedVariable));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkColdAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 431,
 FQN="(anonymous namespace)::checkColdAppertainsTo", NM="_ZN12_GLOBAL__N_1L21checkColdAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L21checkColdAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkColdAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkCommonAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 440,
 FQN="(anonymous namespace)::checkCommonAppertainsTo", NM="_ZN12_GLOBAL__N_1L23checkCommonAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L23checkCommonAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkCommonAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_VarDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedVariable));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkConstructorAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 449,
 FQN="(anonymous namespace)::checkConstructorAppertainsTo", NM="_ZN12_GLOBAL__N_1L28checkConstructorAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L28checkConstructorAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkConstructorAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkConsumableAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 458,
 FQN="(anonymous namespace)::checkConsumableAppertainsTo", NM="_ZN12_GLOBAL__N_1L27checkConsumableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L27checkConsumableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkConsumableAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_CXXRecordDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedClass));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkConsumableAutoCastAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 467,
 FQN="(anonymous namespace)::checkConsumableAutoCastAppertainsTo", NM="_ZN12_GLOBAL__N_1L35checkConsumableAutoCastAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L35checkConsumableAutoCastAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkConsumableAutoCastAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_CXXRecordDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedClass));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkConsumableSetOnReadAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 476,
 FQN="(anonymous namespace)::checkConsumableSetOnReadAppertainsTo", NM="_ZN12_GLOBAL__N_1L36checkConsumableSetOnReadAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L36checkConsumableSetOnReadAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkConsumableSetOnReadAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_CXXRecordDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedClass));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkDLLExportAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 485,
 FQN="(anonymous namespace)::checkDLLExportAppertainsTo", NM="_ZN12_GLOBAL__N_1L26checkDLLExportAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L26checkDLLExportAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkDLLExportAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D) && !isa_VarDecl(D) && !isa_CXXRecordDecl(D) && !isa_ObjCInterfaceDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), (S.getLangOpts().CPlusPlus ? ((S.getLangOpts().ObjC1 || S.getLangOpts().ObjC2) ? AttributeDeclKind.ExpectedFunctionVariableClassOrObjCInterface : AttributeDeclKind.ExpectedFunctionVariableOrClass) : ((S.getLangOpts().ObjC1 || S.getLangOpts().ObjC2) ? AttributeDeclKind.ExpectedFunctionVariableOrObjCInterface : AttributeDeclKind.ExpectedVariableOrFunction))));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isTargetx86x86_64armthumbWin32">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 494,
 FQN="(anonymous namespace)::isTargetx86x86_64armthumbWin32", NM="_ZN12_GLOBAL__N_1L30isTargetx86x86_64armthumbWin32ERKN5clang10TargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L30isTargetx86x86_64armthumbWin32ERKN5clang10TargetInfoE")
//</editor-fold>
public static boolean isTargetx86x86_64armthumbWin32(final /*const*/ TargetInfo /*&*/ Target) {
  final /*const*/ Triple /*&*/ T = Target.getTriple();
  return (T.getArch() == Triple.ArchType.x86 || T.getArch() == Triple.ArchType.x86_64 || T.getArch() == Triple.ArchType.arm || T.getArch() == Triple.ArchType.thumb) && (T.getOS() == Triple.OSType.Win32);
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkDLLImportAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 499,
 FQN="(anonymous namespace)::checkDLLImportAppertainsTo", NM="_ZN12_GLOBAL__N_1L26checkDLLImportAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L26checkDLLImportAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkDLLImportAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D) && !isa_VarDecl(D) && !isa_CXXRecordDecl(D) && !isa_ObjCInterfaceDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), (S.getLangOpts().CPlusPlus ? ((S.getLangOpts().ObjC1 || S.getLangOpts().ObjC2) ? AttributeDeclKind.ExpectedFunctionVariableClassOrObjCInterface : AttributeDeclKind.ExpectedFunctionVariableOrClass) : ((S.getLangOpts().ObjC1 || S.getLangOpts().ObjC2) ? AttributeDeclKind.ExpectedFunctionVariableOrObjCInterface : AttributeDeclKind.ExpectedVariableOrFunction))));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkDestructorAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 508,
 FQN="(anonymous namespace)::checkDestructorAppertainsTo", NM="_ZN12_GLOBAL__N_1L27checkDestructorAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L27checkDestructorAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkDestructorAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkDisableTailCallsAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 517,
 FQN="(anonymous namespace)::checkDisableTailCallsAppertainsTo", NM="_ZN12_GLOBAL__N_1L33checkDisableTailCallsAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L33checkDisableTailCallsAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkDisableTailCallsAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D) && !isa_ObjCMethodDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunctionOrMethod));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkEmptyBasesAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 526,
 FQN="(anonymous namespace)::checkEmptyBasesAppertainsTo", NM="_ZN12_GLOBAL__N_1L27checkEmptyBasesAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L27checkEmptyBasesAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkEmptyBasesAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_CXXRecordDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedClass));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isTargetx86x86_64armthumbMicrosoft">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 535,
 FQN="(anonymous namespace)::isTargetx86x86_64armthumbMicrosoft", NM="_ZN12_GLOBAL__N_1L34isTargetx86x86_64armthumbMicrosoftERKN5clang10TargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L34isTargetx86x86_64armthumbMicrosoftERKN5clang10TargetInfoE")
//</editor-fold>
public static boolean isTargetx86x86_64armthumbMicrosoft(final /*const*/ TargetInfo /*&*/ Target) {
  final /*const*/ Triple /*&*/ T = Target.getTriple();
  return (T.getArch() == Triple.ArchType.x86 || T.getArch() == Triple.ArchType.x86_64 || T.getArch() == Triple.ArchType.arm || T.getArch() == Triple.ArchType.thumb) && (Target.getCXXABI().getKind() == TargetCXXABI.Kind.Microsoft);
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkEnableIfAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 540,
 FQN="(anonymous namespace)::checkEnableIfAppertainsTo", NM="_ZN12_GLOBAL__N_1L25checkEnableIfAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L25checkEnableIfAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkEnableIfAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkExclusiveTrylockFunctionAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 549,
 FQN="(anonymous namespace)::checkExclusiveTrylockFunctionAppertainsTo", NM="_ZN12_GLOBAL__N_1L41checkExclusiveTrylockFunctionAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L41checkExclusiveTrylockFunctionAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkExclusiveTrylockFunctionAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkExtVectorTypeAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 558,
 FQN="(anonymous namespace)::checkExtVectorTypeAppertainsTo", NM="_ZN12_GLOBAL__N_1L30checkExtVectorTypeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L30checkExtVectorTypeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkExtVectorTypeAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_TypedefNameDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedType));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkFlagEnumAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 567,
 FQN="(anonymous namespace)::checkFlagEnumAppertainsTo", NM="_ZN12_GLOBAL__N_1L25checkFlagEnumAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L25checkFlagEnumAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkFlagEnumAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_EnumDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedEnum));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkCPlusPlusLangOpts">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 576,
 FQN="(anonymous namespace)::checkCPlusPlusLangOpts", NM="_ZN12_GLOBAL__N_1L22checkCPlusPlusLangOptsERN5clang4SemaERKNS0_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L22checkCPlusPlusLangOptsERN5clang4SemaERKNS0_13AttributeListE")
//</editor-fold>
public static boolean checkCPlusPlusLangOpts(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (!S.LangOpts.CPlusPlus) {
      return true;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_ignored)), Attr.getName()));
    return false;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkFlattenAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 584,
 FQN="(anonymous namespace)::checkFlattenAppertainsTo", NM="_ZN12_GLOBAL__N_1L24checkFlattenAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L24checkFlattenAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkFlattenAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isHasFunctionProto">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 593,
 FQN="(anonymous namespace)::isHasFunctionProto", NM="_ZN12_GLOBAL__N_1L18isHasFunctionProtoEPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L18isHasFunctionProtoEPKN5clang4DeclE")
//</editor-fold>
public static boolean isHasFunctionProto(/*const*/ Decl /*P*/ D) {
  {
    /*const*/ Decl /*P*/ S = dyn_cast_Decl(D);
    if ((S != null)) {
      return (S.getFunctionType(true) != null
         && isa_FunctionProtoType(S.getFunctionType()))
         || isa_ObjCMethodDecl(S)
         || isa_BlockDecl(S);
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkFormatAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 602,
 FQN="(anonymous namespace)::checkFormatAppertainsTo", NM="_ZN12_GLOBAL__N_1L23checkFormatAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L23checkFormatAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkFormatAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ObjCMethodDecl(D) && !isa_BlockDecl(D) && !isHasFunctionProto(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunctionWithProtoType));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkFormatArgAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 611,
 FQN="(anonymous namespace)::checkFormatArgAppertainsTo", NM="_ZN12_GLOBAL__N_1L26checkFormatArgAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L26checkFormatArgAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkFormatArgAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ObjCMethodDecl(D) && !isHasFunctionProto(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunctionWithProtoType));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkGNUInlineAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 620,
 FQN="(anonymous namespace)::checkGNUInlineAppertainsTo", NM="_ZN12_GLOBAL__N_1L26checkGNUInlineAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L26checkGNUInlineAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkGNUInlineAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkGuardedByAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 629,
 FQN="(anonymous namespace)::checkGuardedByAppertainsTo", NM="_ZN12_GLOBAL__N_1L26checkGuardedByAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L26checkGuardedByAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkGuardedByAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FieldDecl(D) && !isSharedVar(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFieldOrGlobalVar));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkGuardedVarAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 638,
 FQN="(anonymous namespace)::checkGuardedVarAppertainsTo", NM="_ZN12_GLOBAL__N_1L27checkGuardedVarAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L27checkGuardedVarAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkGuardedVarAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FieldDecl(D) && !isSharedVar(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFieldOrGlobalVar));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkHotAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 647,
 FQN="(anonymous namespace)::checkHotAppertainsTo", NM="_ZN12_GLOBAL__N_1L20checkHotAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L20checkHotAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkHotAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isObjCInstanceMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 656,
 FQN="(anonymous namespace)::isObjCInstanceMethod", NM="_ZN12_GLOBAL__N_1L20isObjCInstanceMethodEPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L20isObjCInstanceMethodEPKN5clang4DeclE")
//</editor-fold>
public static boolean isObjCInstanceMethod(/*const*/ Decl /*P*/ D) {
  {
    /*const*/ ObjCMethodDecl /*P*/ S = dyn_cast_ObjCMethodDecl(D);
    if ((S != null)) {
      return S.isInstanceMethod();
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkIBActionAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 662,
 FQN="(anonymous namespace)::checkIBActionAppertainsTo", NM="_ZN12_GLOBAL__N_1L25checkIBActionAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L25checkIBActionAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkIBActionAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isObjCInstanceMethod(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedObjCInstanceMethod));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkIFuncAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 671,
 FQN="(anonymous namespace)::checkIFuncAppertainsTo", NM="_ZN12_GLOBAL__N_1L22checkIFuncAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L22checkIFuncAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkIFuncAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkInitPriorityAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 680,
 FQN="(anonymous namespace)::checkInitPriorityAppertainsTo", NM="_ZN12_GLOBAL__N_1L29checkInitPriorityAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L29checkInitPriorityAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkInitPriorityAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_VarDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedVariable));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkInternalLinkageAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 689,
 FQN="(anonymous namespace)::checkInternalLinkageAppertainsTo", NM="_ZN12_GLOBAL__N_1L32checkInternalLinkageAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L32checkInternalLinkageAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkInternalLinkageAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_VarDecl(D) && !isa_FunctionDecl(D) && !isa_CXXRecordDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), (S.getLangOpts().CPlusPlus ? AttributeDeclKind.ExpectedFunctionVariableOrClass : AttributeDeclKind.ExpectedVariableOrFunction)));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkLTOVisibilityPublicAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 698,
 FQN="(anonymous namespace)::checkLTOVisibilityPublicAppertainsTo", NM="_ZN12_GLOBAL__N_1L36checkLTOVisibilityPublicAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L36checkLTOVisibilityPublicAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkLTOVisibilityPublicAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_RecordDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), (S.getLangOpts().CPlusPlus ? AttributeDeclKind.ExpectedStructOrUnionOrClass : AttributeDeclKind.ExpectedStructOrUnion)));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkLayoutVersionAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 707,
 FQN="(anonymous namespace)::checkLayoutVersionAppertainsTo", NM="_ZN12_GLOBAL__N_1L30checkLayoutVersionAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L30checkLayoutVersionAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkLayoutVersionAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_CXXRecordDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedClass));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkLockReturnedAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 716,
 FQN="(anonymous namespace)::checkLockReturnedAppertainsTo", NM="_ZN12_GLOBAL__N_1L29checkLockReturnedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L29checkLockReturnedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkLockReturnedAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkLockableAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 725,
 FQN="(anonymous namespace)::checkLockableAppertainsTo", NM="_ZN12_GLOBAL__N_1L25checkLockableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L25checkLockableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkLockableAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_RecordDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), (S.getLangOpts().CPlusPlus ? AttributeDeclKind.ExpectedStructOrUnionOrClass : AttributeDeclKind.ExpectedStructOrUnion)));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkLocksExcludedAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 734,
 FQN="(anonymous namespace)::checkLocksExcludedAppertainsTo", NM="_ZN12_GLOBAL__N_1L30checkLocksExcludedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L30checkLocksExcludedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkLocksExcludedAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LoopHintAttrSpellingMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 743,
 FQN="(anonymous namespace)::LoopHintAttrSpellingMap", NM="_ZN12_GLOBAL__N_1L23LoopHintAttrSpellingMapERKN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L23LoopHintAttrSpellingMapERKN5clang13AttributeListE")
//</editor-fold>
public static /*uint*/int LoopHintAttrSpellingMap(final /*const*/ AttributeList /*&*/ Attr) {
  final class/*enum*/ Spelling {
    private static final /*uint*/int Pragma_clang_loop = 0;
    private static final /*uint*/int Pragma_unroll = 1;
    private static final /*uint*/int Pragma_nounroll = 2;
  };
  
  /*uint*/int Idx = Attr.getAttributeSpellingListIndex();
  switch (Idx) {
   default:
    throw new llvm_unreachable("Unknown spelling list index");
   case 0:
    return Spelling.Pragma_clang_loop;
   case 1:
    return Spelling.Pragma_unroll;
   case 2:
    return Spelling.Pragma_nounroll;
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkMicrosoftExtLangOpts">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 759,
 FQN="(anonymous namespace)::checkMicrosoftExtLangOpts", NM="_ZN12_GLOBAL__N_1L25checkMicrosoftExtLangOptsERN5clang4SemaERKNS0_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L25checkMicrosoftExtLangOptsERN5clang4SemaERKNS0_13AttributeListE")
//</editor-fold>
public static boolean checkMicrosoftExtLangOpts(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (S.LangOpts.MicrosoftExt) {
      return true;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_ignored)), Attr.getName()));
    return false;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSInheritanceAttrSpellingMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 767,
 FQN="(anonymous namespace)::MSInheritanceAttrSpellingMap", NM="_ZN12_GLOBAL__N_1L28MSInheritanceAttrSpellingMapERKN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L28MSInheritanceAttrSpellingMapERKN5clang13AttributeListE")
//</editor-fold>
public static /*uint*/int MSInheritanceAttrSpellingMap(final /*const*/ AttributeList /*&*/ Attr) {
  final class/*enum*/ Spelling {
    private static final /*uint*/int Keyword_single_inheritance = 0;
    private static final /*uint*/int Keyword_multiple_inheritance = 1;
    private static final /*uint*/int Keyword_virtual_inheritance = 2;
    private static final /*uint*/int Keyword_unspecified_inheritance = 3;
  };
  
  /*uint*/int Idx = Attr.getAttributeSpellingListIndex();
  switch (Idx) {
   default:
    throw new llvm_unreachable("Unknown spelling list index");
   case 0:
    return Spelling.Keyword_single_inheritance;
   case 1:
    return Spelling.Keyword_multiple_inheritance;
   case 2:
    return Spelling.Keyword_virtual_inheritance;
   case 3:
    return Spelling.Keyword_unspecified_inheritance;
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkMSNoVTableAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 785,
 FQN="(anonymous namespace)::checkMSNoVTableAppertainsTo", NM="_ZN12_GLOBAL__N_1L27checkMSNoVTableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L27checkMSNoVTableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkMSNoVTableAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_CXXRecordDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedClass));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkMSStructAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 794,
 FQN="(anonymous namespace)::checkMSStructAppertainsTo", NM="_ZN12_GLOBAL__N_1L25checkMSStructAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L25checkMSStructAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkMSStructAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_RecordDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), (S.getLangOpts().CPlusPlus ? AttributeDeclKind.ExpectedStructOrUnionOrClass : AttributeDeclKind.ExpectedStructOrUnion)));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkMinSizeAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 803,
 FQN="(anonymous namespace)::checkMinSizeAppertainsTo", NM="_ZN12_GLOBAL__N_1L24checkMinSizeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L24checkMinSizeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkMinSizeAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D) && !isa_ObjCMethodDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunctionOrMethod));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkMips16AppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 812,
 FQN="(anonymous namespace)::checkMips16AppertainsTo", NM="_ZN12_GLOBAL__N_1L23checkMips16AppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L23checkMips16AppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkMips16AppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isTargetmipsmipsel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 821,
 FQN="(anonymous namespace)::isTargetmipsmipsel", NM="_ZN12_GLOBAL__N_1L18isTargetmipsmipselERKN5clang10TargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L18isTargetmipsmipselERKN5clang10TargetInfoE")
//</editor-fold>
public static boolean isTargetmipsmipsel(final /*const*/ TargetInfo /*&*/ Target) {
  final /*const*/ Triple /*&*/ T = Target.getTriple();
  return (T.getArch() == Triple.ArchType.mips || T.getArch() == Triple.ArchType.mipsel);
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkModeAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 826,
 FQN="(anonymous namespace)::checkModeAppertainsTo", NM="_ZN12_GLOBAL__N_1L21checkModeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L21checkModeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkModeAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_VarDecl(D) && !isa_EnumDecl(D) && !isa_TypedefNameDecl(D) && !isa_FieldDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedVariableEnumFieldOrTypedef));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkNSConsumedAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 835,
 FQN="(anonymous namespace)::checkNSConsumedAppertainsTo", NM="_ZN12_GLOBAL__N_1L27checkNSConsumedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L27checkNSConsumedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkNSConsumedAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ParmVarDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedParameter));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkNSConsumesSelfAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 844,
 FQN="(anonymous namespace)::checkNSConsumesSelfAppertainsTo", NM="_ZN12_GLOBAL__N_1L31checkNSConsumesSelfAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L31checkNSConsumesSelfAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkNSConsumesSelfAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ObjCMethodDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedMethod));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkNakedAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 853,
 FQN="(anonymous namespace)::checkNakedAppertainsTo", NM="_ZN12_GLOBAL__N_1L22checkNakedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L22checkNakedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkNakedAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkNoAliasAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 862,
 FQN="(anonymous namespace)::checkNoAliasAppertainsTo", NM="_ZN12_GLOBAL__N_1L24checkNoAliasAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L24checkNoAliasAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkNoAliasAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkNoCommonAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 871,
 FQN="(anonymous namespace)::checkNoCommonAppertainsTo", NM="_ZN12_GLOBAL__N_1L25checkNoCommonAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L25checkNoCommonAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkNoCommonAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_VarDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedVariable));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isNonParmVar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 880,
 FQN="(anonymous namespace)::isNonParmVar", NM="_ZN12_GLOBAL__N_1L12isNonParmVarEPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L12isNonParmVarEPKN5clang4DeclE")
//</editor-fold>
public static boolean isNonParmVar(/*const*/ Decl /*P*/ D) {
  {
    /*const*/ VarDecl /*P*/ S = dyn_cast_VarDecl(D);
    if ((S != null)) {
      return S.getKind() != Decl.Kind.ParmVar;
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkNoDebugAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 886,
 FQN="(anonymous namespace)::checkNoDebugAppertainsTo", NM="_ZN12_GLOBAL__N_1L24checkNoDebugAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L24checkNoDebugAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkNoDebugAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isFunctionLike(D) && !isa_ObjCMethodDecl(D) && !isNonParmVar(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedVariableOrFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkNoDuplicateAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 895,
 FQN="(anonymous namespace)::checkNoDuplicateAppertainsTo", NM="_ZN12_GLOBAL__N_1L28checkNoDuplicateAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L28checkNoDuplicateAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkNoDuplicateAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkNoInlineAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 904,
 FQN="(anonymous namespace)::checkNoInlineAppertainsTo", NM="_ZN12_GLOBAL__N_1L25checkNoInlineAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L25checkNoInlineAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkNoInlineAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkNoInstrumentFunctionAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 913,
 FQN="(anonymous namespace)::checkNoInstrumentFunctionAppertainsTo", NM="_ZN12_GLOBAL__N_1L37checkNoInstrumentFunctionAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L37checkNoInstrumentFunctionAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkNoInstrumentFunctionAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkNoMips16AppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 922,
 FQN="(anonymous namespace)::checkNoMips16AppertainsTo", NM="_ZN12_GLOBAL__N_1L25checkNoMips16AppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L25checkNoMips16AppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkNoMips16AppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkNoSanitizeAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 931,
 FQN="(anonymous namespace)::checkNoSanitizeAppertainsTo", NM="_ZN12_GLOBAL__N_1L27checkNoSanitizeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L27checkNoSanitizeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkNoSanitizeAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D) && !isa_ObjCMethodDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunctionOrMethod));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkNoSanitizeSpecificAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 940,
 FQN="(anonymous namespace)::checkNoSanitizeSpecificAppertainsTo", NM="_ZN12_GLOBAL__N_1L35checkNoSanitizeSpecificAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L35checkNoSanitizeSpecificAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkNoSanitizeSpecificAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkNoSplitStackAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 949,
 FQN="(anonymous namespace)::checkNoSplitStackAppertainsTo", NM="_ZN12_GLOBAL__N_1L29checkNoSplitStackAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L29checkNoSplitStackAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkNoSplitStackAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkNoThreadSafetyAnalysisAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 958,
 FQN="(anonymous namespace)::checkNoThreadSafetyAnalysisAppertainsTo", NM="_ZN12_GLOBAL__N_1L39checkNoThreadSafetyAnalysisAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L39checkNoThreadSafetyAnalysisAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkNoThreadSafetyAnalysisAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkNonNullAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 967,
 FQN="(anonymous namespace)::checkNonNullAppertainsTo", NM="_ZN12_GLOBAL__N_1L24checkNonNullAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L24checkNonNullAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkNonNullAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ObjCMethodDecl(D) && !isHasFunctionProto(D) && !isa_ParmVarDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunctionMethodOrParameter));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkNotTailCalledAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 976,
 FQN="(anonymous namespace)::checkNotTailCalledAppertainsTo", NM="_ZN12_GLOBAL__N_1L30checkNotTailCalledAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L30checkNotTailCalledAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkNotTailCalledAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkObjCBoxableAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 985,
 FQN="(anonymous namespace)::checkObjCBoxableAppertainsTo", NM="_ZN12_GLOBAL__N_1L28checkObjCBoxableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L28checkObjCBoxableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkObjCBoxableAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_RecordDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedStructOrUnion));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkObjCBridgeAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 994,
 FQN="(anonymous namespace)::checkObjCBridgeAppertainsTo", NM="_ZN12_GLOBAL__N_1L27checkObjCBridgeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L27checkObjCBridgeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkObjCBridgeAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_RecordDecl(D) && !isa_TypedefNameDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedStructOrUnionOrTypedef));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkObjCBridgeMutableAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1003,
 FQN="(anonymous namespace)::checkObjCBridgeMutableAppertainsTo", NM="_ZN12_GLOBAL__N_1L34checkObjCBridgeMutableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L34checkObjCBridgeMutableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkObjCBridgeMutableAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_RecordDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), (S.getLangOpts().CPlusPlus ? AttributeDeclKind.ExpectedStructOrUnionOrClass : AttributeDeclKind.ExpectedStructOrUnion)));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkObjCBridgeRelatedAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1012,
 FQN="(anonymous namespace)::checkObjCBridgeRelatedAppertainsTo", NM="_ZN12_GLOBAL__N_1L34checkObjCBridgeRelatedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L34checkObjCBridgeRelatedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkObjCBridgeRelatedAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_RecordDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), (S.getLangOpts().CPlusPlus ? AttributeDeclKind.ExpectedStructOrUnionOrClass : AttributeDeclKind.ExpectedStructOrUnion)));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isObjCInterfaceDeclInitMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1021,
 FQN="(anonymous namespace)::isObjCInterfaceDeclInitMethod", NM="_ZN12_GLOBAL__N_1L29isObjCInterfaceDeclInitMethodEPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L29isObjCInterfaceDeclInitMethodEPKN5clang4DeclE")
//</editor-fold>
public static boolean isObjCInterfaceDeclInitMethod(/*const*/ Decl /*P*/ D) {
  {
    /*const*/ ObjCMethodDecl /*P*/ S = dyn_cast_ObjCMethodDecl(D);
    if ((S != null)) {
      return S.getMethodFamily() == ObjCMethodFamily.OMF_init
         && (isa_ObjCInterfaceDecl(S.getDeclContext$Const())
         || (isa_ObjCCategoryDecl(S.getDeclContext$Const())
         && cast_ObjCCategoryDecl(S.getDeclContext$Const()).IsClassExtension()));
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkObjCDesignatedInitializerAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1030,
 FQN="(anonymous namespace)::checkObjCDesignatedInitializerAppertainsTo", NM="_ZN12_GLOBAL__N_1L42checkObjCDesignatedInitializerAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L42checkObjCDesignatedInitializerAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkObjCDesignatedInitializerAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isObjCInterfaceDeclInitMethod(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedObjCInterfaceDeclInitMethod));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkObjCExceptionAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1039,
 FQN="(anonymous namespace)::checkObjCExceptionAppertainsTo", NM="_ZN12_GLOBAL__N_1L30checkObjCExceptionAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L30checkObjCExceptionAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkObjCExceptionAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ObjCInterfaceDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedObjectiveCInterface));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkObjCExplicitProtocolImplAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1048,
 FQN="(anonymous namespace)::checkObjCExplicitProtocolImplAppertainsTo", NM="_ZN12_GLOBAL__N_1L41checkObjCExplicitProtocolImplAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L41checkObjCExplicitProtocolImplAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkObjCExplicitProtocolImplAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ObjCProtocolDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedObjectiveCProtocol));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkObjCMethodFamilyAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1057,
 FQN="(anonymous namespace)::checkObjCMethodFamilyAppertainsTo", NM="_ZN12_GLOBAL__N_1L33checkObjCMethodFamilyAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L33checkObjCMethodFamilyAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkObjCMethodFamilyAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ObjCMethodDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedMethod));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkObjCPreciseLifetimeAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1066,
 FQN="(anonymous namespace)::checkObjCPreciseLifetimeAppertainsTo", NM="_ZN12_GLOBAL__N_1L36checkObjCPreciseLifetimeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L36checkObjCPreciseLifetimeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkObjCPreciseLifetimeAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_VarDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedVariable));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkObjCRequiresPropertyDefsAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1075,
 FQN="(anonymous namespace)::checkObjCRequiresPropertyDefsAppertainsTo", NM="_ZN12_GLOBAL__N_1L41checkObjCRequiresPropertyDefsAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L41checkObjCRequiresPropertyDefsAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkObjCRequiresPropertyDefsAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ObjCInterfaceDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedObjectiveCInterface));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkObjCRequiresSuperAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1084,
 FQN="(anonymous namespace)::checkObjCRequiresSuperAppertainsTo", NM="_ZN12_GLOBAL__N_1L34checkObjCRequiresSuperAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L34checkObjCRequiresSuperAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkObjCRequiresSuperAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ObjCMethodDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedMethod));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkObjCReturnsInnerPointerAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1093,
 FQN="(anonymous namespace)::checkObjCReturnsInnerPointerAppertainsTo", NM="_ZN12_GLOBAL__N_1L40checkObjCReturnsInnerPointerAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L40checkObjCReturnsInnerPointerAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkObjCReturnsInnerPointerAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ObjCMethodDecl(D) && !isa_ObjCPropertyDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedMethodOrProperty));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkObjCRootClassAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1102,
 FQN="(anonymous namespace)::checkObjCRootClassAppertainsTo", NM="_ZN12_GLOBAL__N_1L30checkObjCRootClassAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L30checkObjCRootClassAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkObjCRootClassAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ObjCInterfaceDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedObjectiveCInterface));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkObjCRuntimeNameAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1111,
 FQN="(anonymous namespace)::checkObjCRuntimeNameAppertainsTo", NM="_ZN12_GLOBAL__N_1L32checkObjCRuntimeNameAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L32checkObjCRuntimeNameAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkObjCRuntimeNameAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ObjCInterfaceDecl(D) && !isa_ObjCProtocolDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedObjectiveCInterfaceOrProtocol));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkObjCRuntimeVisibleAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1120,
 FQN="(anonymous namespace)::checkObjCRuntimeVisibleAppertainsTo", NM="_ZN12_GLOBAL__N_1L35checkObjCRuntimeVisibleAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L35checkObjCRuntimeVisibleAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkObjCRuntimeVisibleAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ObjCInterfaceDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedObjectiveCInterface));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkOpenCLAccessAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1129,
 FQN="(anonymous namespace)::checkOpenCLAccessAppertainsTo", NM="_ZN12_GLOBAL__N_1L29checkOpenCLAccessAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L29checkOpenCLAccessAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkOpenCLAccessAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ParmVarDecl(D) && !isa_TypedefNameDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedParameterOrTypedef));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenCLAccessAttrSpellingMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1138,
 FQN="(anonymous namespace)::OpenCLAccessAttrSpellingMap", NM="_ZN12_GLOBAL__N_1L27OpenCLAccessAttrSpellingMapERKN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L27OpenCLAccessAttrSpellingMapERKN5clang13AttributeListE")
//</editor-fold>
public static /*uint*/int OpenCLAccessAttrSpellingMap(final /*const*/ AttributeList /*&*/ Attr) {
  final class/*enum*/ Spelling {
    private static final /*uint*/int Keyword_read_only = 0;
    private static final /*uint*/int Keyword_write_only = 2;
    private static final /*uint*/int Keyword_read_write = 4;
  };
  
  /*uint*/int Idx = Attr.getAttributeSpellingListIndex();
  switch (Idx) {
   default:
    throw new llvm_unreachable("Unknown spelling list index");
   case 0:
    return Spelling.Keyword_read_only;
   case 1:
    return Spelling.Keyword_read_only;
   case 2:
    return Spelling.Keyword_write_only;
   case 3:
    return Spelling.Keyword_write_only;
   case 4:
    return Spelling.Keyword_read_write;
   case 5:
    return Spelling.Keyword_read_write;
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkOpenCLKernelAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1157,
 FQN="(anonymous namespace)::checkOpenCLKernelAppertainsTo", NM="_ZN12_GLOBAL__N_1L29checkOpenCLKernelAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L29checkOpenCLKernelAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkOpenCLKernelAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkOpenCLNoSVMAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1166,
 FQN="(anonymous namespace)::checkOpenCLNoSVMAppertainsTo", NM="_ZN12_GLOBAL__N_1L28checkOpenCLNoSVMAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L28checkOpenCLNoSVMAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkOpenCLNoSVMAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_VarDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedVariable));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkOpenCLLangOpts">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1175,
 FQN="(anonymous namespace)::checkOpenCLLangOpts", NM="_ZN12_GLOBAL__N_1L19checkOpenCLLangOptsERN5clang4SemaERKNS0_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L19checkOpenCLLangOptsERN5clang4SemaERKNS0_13AttributeListE")
//</editor-fold>
public static boolean checkOpenCLLangOpts(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (S.LangOpts.OpenCL) {
      return true;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_ignored)), Attr.getName()));
    return false;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkOptimizeNoneAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1183,
 FQN="(anonymous namespace)::checkOptimizeNoneAppertainsTo", NM="_ZN12_GLOBAL__N_1L29checkOptimizeNoneAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L29checkOptimizeNoneAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkOptimizeNoneAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D) && !isa_ObjCMethodDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunctionOrMethod));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkOverloadableAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1192,
 FQN="(anonymous namespace)::checkOverloadableAppertainsTo", NM="_ZN12_GLOBAL__N_1L29checkOverloadableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L29checkOverloadableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkOverloadableAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkOwnershipAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1201,
 FQN="(anonymous namespace)::checkOwnershipAppertainsTo", NM="_ZN12_GLOBAL__N_1L26checkOwnershipAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L26checkOwnershipAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkOwnershipAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isHasFunctionProto(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunctionWithProtoType));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OwnershipAttrSpellingMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1210,
 FQN="(anonymous namespace)::OwnershipAttrSpellingMap", NM="_ZN12_GLOBAL__N_1L24OwnershipAttrSpellingMapERKN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L24OwnershipAttrSpellingMapERKN5clang13AttributeListE")
//</editor-fold>
public static /*uint*/int OwnershipAttrSpellingMap(final /*const*/ AttributeList /*&*/ Attr) {
  final class/*enum*/ Spelling {
    private static final /*uint*/int GNU_ownership_holds = 0;
    private static final /*uint*/int GNU_ownership_returns = 1;
    private static final /*uint*/int GNU_ownership_takes = 2;
  };
  
  /*uint*/int Idx = Attr.getAttributeSpellingListIndex();
  switch (Idx) {
   default:
    throw new llvm_unreachable("Unknown spelling list index");
   case 0:
    return Spelling.GNU_ownership_holds;
   case 1:
    return Spelling.GNU_ownership_returns;
   case 2:
    return Spelling.GNU_ownership_takes;
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkParamTypestateAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1226,
 FQN="(anonymous namespace)::checkParamTypestateAppertainsTo", NM="_ZN12_GLOBAL__N_1L31checkParamTypestateAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L31checkParamTypestateAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkParamTypestateAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ParmVarDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedParameter));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkPassObjectSizeAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1235,
 FQN="(anonymous namespace)::checkPassObjectSizeAppertainsTo", NM="_ZN12_GLOBAL__N_1L31checkPassObjectSizeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L31checkPassObjectSizeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkPassObjectSizeAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ParmVarDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedParameter));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkPtGuardedByAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1244,
 FQN="(anonymous namespace)::checkPtGuardedByAppertainsTo", NM="_ZN12_GLOBAL__N_1L28checkPtGuardedByAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L28checkPtGuardedByAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkPtGuardedByAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FieldDecl(D) && !isSharedVar(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFieldOrGlobalVar));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkPtGuardedVarAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1253,
 FQN="(anonymous namespace)::checkPtGuardedVarAppertainsTo", NM="_ZN12_GLOBAL__N_1L29checkPtGuardedVarAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L29checkPtGuardedVarAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkPtGuardedVarAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FieldDecl(D) && !isSharedVar(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFieldOrGlobalVar));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkReleaseCapabilityAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1262,
 FQN="(anonymous namespace)::checkReleaseCapabilityAppertainsTo", NM="_ZN12_GLOBAL__N_1L34checkReleaseCapabilityAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L34checkReleaseCapabilityAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkReleaseCapabilityAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReleaseCapabilityAttrSpellingMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1271,
 FQN="(anonymous namespace)::ReleaseCapabilityAttrSpellingMap", NM="_ZN12_GLOBAL__N_1L32ReleaseCapabilityAttrSpellingMapERKN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L32ReleaseCapabilityAttrSpellingMapERKN5clang13AttributeListE")
//</editor-fold>
public static /*uint*/int ReleaseCapabilityAttrSpellingMap(final /*const*/ AttributeList /*&*/ Attr) {
  final class/*enum*/ Spelling {
    private static final /*uint*/int GNU_release_capability = 0;
    private static final /*uint*/int CXX11_clang_release_capability = 1;
    private static final /*uint*/int GNU_release_shared_capability = 2;
    private static final /*uint*/int CXX11_clang_release_shared_capability = 3;
    private static final /*uint*/int GNU_release_generic_capability = 4;
    private static final /*uint*/int CXX11_clang_release_generic_capability = 5;
    private static final /*uint*/int GNU_unlock_function = 6;
  };
  
  /*uint*/int Idx = Attr.getAttributeSpellingListIndex();
  switch (Idx) {
   default:
    throw new llvm_unreachable("Unknown spelling list index");
   case 0:
    return Spelling.GNU_release_capability;
   case 1:
    return Spelling.CXX11_clang_release_capability;
   case 2:
    return Spelling.GNU_release_shared_capability;
   case 3:
    return Spelling.CXX11_clang_release_shared_capability;
   case 4:
    return Spelling.GNU_release_generic_capability;
   case 5:
    return Spelling.CXX11_clang_release_generic_capability;
   case 6:
    return Spelling.GNU_unlock_function;
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkRenderScriptKernelAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1295,
 FQN="(anonymous namespace)::checkRenderScriptKernelAppertainsTo", NM="_ZN12_GLOBAL__N_1L35checkRenderScriptKernelAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L35checkRenderScriptKernelAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkRenderScriptKernelAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkRenderScriptLangOpts">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1304,
 FQN="(anonymous namespace)::checkRenderScriptLangOpts", NM="_ZN12_GLOBAL__N_1L25checkRenderScriptLangOptsERN5clang4SemaERKNS0_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L25checkRenderScriptLangOptsERN5clang4SemaERKNS0_13AttributeListE")
//</editor-fold>
public static boolean checkRenderScriptLangOpts(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (S.LangOpts.RenderScript) {
      return true;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_ignored)), Attr.getName()));
    return false;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkReqdWorkGroupSizeAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1312,
 FQN="(anonymous namespace)::checkReqdWorkGroupSizeAppertainsTo", NM="_ZN12_GLOBAL__N_1L34checkReqdWorkGroupSizeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L34checkReqdWorkGroupSizeAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkReqdWorkGroupSizeAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkRequiresCapabilityAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1321,
 FQN="(anonymous namespace)::checkRequiresCapabilityAppertainsTo", NM="_ZN12_GLOBAL__N_1L35checkRequiresCapabilityAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L35checkRequiresCapabilityAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkRequiresCapabilityAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RequiresCapabilityAttrSpellingMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1330,
 FQN="(anonymous namespace)::RequiresCapabilityAttrSpellingMap", NM="_ZN12_GLOBAL__N_1L33RequiresCapabilityAttrSpellingMapERKN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L33RequiresCapabilityAttrSpellingMapERKN5clang13AttributeListE")
//</editor-fold>
public static /*uint*/int RequiresCapabilityAttrSpellingMap(final /*const*/ AttributeList /*&*/ Attr) {
  final class/*enum*/ Spelling {
    private static final /*uint*/int GNU_requires_capability = 0;
    private static final /*uint*/int CXX11_clang_requires_capability = 1;
    private static final /*uint*/int GNU_exclusive_locks_required = 2;
    private static final /*uint*/int GNU_requires_shared_capability = 3;
    private static final /*uint*/int CXX11_clang_requires_shared_capability = 4;
    private static final /*uint*/int GNU_shared_locks_required = 5;
  };
  
  /*uint*/int Idx = Attr.getAttributeSpellingListIndex();
  switch (Idx) {
   default:
    throw new llvm_unreachable("Unknown spelling list index");
   case 0:
    return Spelling.GNU_requires_capability;
   case 1:
    return Spelling.CXX11_clang_requires_capability;
   case 2:
    return Spelling.GNU_exclusive_locks_required;
   case 3:
    return Spelling.GNU_requires_shared_capability;
   case 4:
    return Spelling.CXX11_clang_requires_shared_capability;
   case 5:
    return Spelling.GNU_shared_locks_required;
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkRestrictAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1352,
 FQN="(anonymous namespace)::checkRestrictAppertainsTo", NM="_ZN12_GLOBAL__N_1L25checkRestrictAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L25checkRestrictAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkRestrictAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RestrictAttrSpellingMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1361,
 FQN="(anonymous namespace)::RestrictAttrSpellingMap", NM="_ZN12_GLOBAL__N_1L23RestrictAttrSpellingMapERKN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L23RestrictAttrSpellingMapERKN5clang13AttributeListE")
//</editor-fold>
public static /*uint*/int RestrictAttrSpellingMap(final /*const*/ AttributeList /*&*/ Attr) {
  final class/*enum*/ Spelling {
    private static final /*uint*/int Declspec_restrict = 0;
    private static final /*uint*/int GNU_malloc = 1;
    private static final /*uint*/int CXX11_gnu_malloc = 2;
  };
  
  /*uint*/int Idx = Attr.getAttributeSpellingListIndex();
  switch (Idx) {
   default:
    throw new llvm_unreachable("Unknown spelling list index");
   case 0:
    return Spelling.Declspec_restrict;
   case 1:
    return Spelling.GNU_malloc;
   case 2:
    return Spelling.CXX11_gnu_malloc;
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkReturnTypestateAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1377,
 FQN="(anonymous namespace)::checkReturnTypestateAppertainsTo", NM="_ZN12_GLOBAL__N_1L32checkReturnTypestateAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L32checkReturnTypestateAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkReturnTypestateAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D) && !isa_ParmVarDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunctionMethodOrParameter));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkReturnsNonNullAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1386,
 FQN="(anonymous namespace)::checkReturnsNonNullAppertainsTo", NM="_ZN12_GLOBAL__N_1L31checkReturnsNonNullAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L31checkReturnsNonNullAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkReturnsNonNullAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ObjCMethodDecl(D) && !isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunctionOrMethod));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkReturnsTwiceAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1395,
 FQN="(anonymous namespace)::checkReturnsTwiceAppertainsTo", NM="_ZN12_GLOBAL__N_1L29checkReturnsTwiceAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L29checkReturnsTwiceAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkReturnsTwiceAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkScopedLockableAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1404,
 FQN="(anonymous namespace)::checkScopedLockableAppertainsTo", NM="_ZN12_GLOBAL__N_1L31checkScopedLockableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L31checkScopedLockableAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkScopedLockableAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_RecordDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), (S.getLangOpts().CPlusPlus ? AttributeDeclKind.ExpectedStructOrUnionOrClass : AttributeDeclKind.ExpectedStructOrUnion)));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkSectionAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1413,
 FQN="(anonymous namespace)::checkSectionAppertainsTo", NM="_ZN12_GLOBAL__N_1L24checkSectionAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L24checkSectionAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkSectionAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D) && !isGlobalVar(D) && !isa_ObjCMethodDecl(D) && !isa_ObjCPropertyDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunctionGlobalVarMethodOrProperty));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SectionAttrSpellingMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1422,
 FQN="(anonymous namespace)::SectionAttrSpellingMap", NM="_ZN12_GLOBAL__N_1L22SectionAttrSpellingMapERKN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L22SectionAttrSpellingMapERKN5clang13AttributeListE")
//</editor-fold>
public static /*uint*/int SectionAttrSpellingMap(final /*const*/ AttributeList /*&*/ Attr) {
  final class/*enum*/ Spelling {
    private static final /*uint*/int GNU_section = 0;
    private static final /*uint*/int CXX11_gnu_section = 1;
    private static final /*uint*/int Declspec_allocate = 2;
  };
  
  /*uint*/int Idx = Attr.getAttributeSpellingListIndex();
  switch (Idx) {
   default:
    throw new llvm_unreachable("Unknown spelling list index");
   case 0:
    return Spelling.GNU_section;
   case 1:
    return Spelling.CXX11_gnu_section;
   case 2:
    return Spelling.Declspec_allocate;
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkSetTypestateAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1438,
 FQN="(anonymous namespace)::checkSetTypestateAppertainsTo", NM="_ZN12_GLOBAL__N_1L29checkSetTypestateAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L29checkSetTypestateAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkSetTypestateAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_CXXMethodDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedMethod));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkSharedTrylockFunctionAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1447,
 FQN="(anonymous namespace)::checkSharedTrylockFunctionAppertainsTo", NM="_ZN12_GLOBAL__N_1L38checkSharedTrylockFunctionAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L38checkSharedTrylockFunctionAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkSharedTrylockFunctionAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkSwiftContextAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1456,
 FQN="(anonymous namespace)::checkSwiftContextAppertainsTo", NM="_ZN12_GLOBAL__N_1L29checkSwiftContextAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L29checkSwiftContextAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkSwiftContextAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ParmVarDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedParameter));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkSwiftErrorResultAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1465,
 FQN="(anonymous namespace)::checkSwiftErrorResultAppertainsTo", NM="_ZN12_GLOBAL__N_1L33checkSwiftErrorResultAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L33checkSwiftErrorResultAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkSwiftErrorResultAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ParmVarDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedParameter));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkSwiftIndirectResultAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1474,
 FQN="(anonymous namespace)::checkSwiftIndirectResultAppertainsTo", NM="_ZN12_GLOBAL__N_1L36checkSwiftIndirectResultAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L36checkSwiftIndirectResultAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkSwiftIndirectResultAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ParmVarDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedParameter));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isTLSVar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1483,
 FQN="(anonymous namespace)::isTLSVar", NM="_ZN12_GLOBAL__N_1L8isTLSVarEPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L8isTLSVarEPKN5clang4DeclE")
//</editor-fold>
public static boolean isTLSVar(/*const*/ Decl /*P*/ D) {
  {
    /*const*/ VarDecl /*P*/ S = dyn_cast_VarDecl(D);
    if ((S != null)) {
      return S.getTLSKind().getValue() != 0;
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkTLSModelAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1489,
 FQN="(anonymous namespace)::checkTLSModelAppertainsTo", NM="_ZN12_GLOBAL__N_1L25checkTLSModelAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L25checkTLSModelAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkTLSModelAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isTLSVar(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedTLSVar));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkTargetAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1498,
 FQN="(anonymous namespace)::checkTargetAppertainsTo", NM="_ZN12_GLOBAL__N_1L23checkTargetAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L23checkTargetAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkTargetAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkTestTypestateAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1507,
 FQN="(anonymous namespace)::checkTestTypestateAppertainsTo", NM="_ZN12_GLOBAL__N_1L30checkTestTypestateAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L30checkTestTypestateAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkTestTypestateAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_CXXMethodDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedMethod));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkThreadAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1516,
 FQN="(anonymous namespace)::checkThreadAppertainsTo", NM="_ZN12_GLOBAL__N_1L23checkThreadAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L23checkThreadAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkThreadAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_VarDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedVariable));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkTryAcquireCapabilityAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1525,
 FQN="(anonymous namespace)::checkTryAcquireCapabilityAppertainsTo", NM="_ZN12_GLOBAL__N_1L37checkTryAcquireCapabilityAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L37checkTryAcquireCapabilityAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkTryAcquireCapabilityAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TryAcquireCapabilityAttrSpellingMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1534,
 FQN="(anonymous namespace)::TryAcquireCapabilityAttrSpellingMap", NM="_ZN12_GLOBAL__N_1L35TryAcquireCapabilityAttrSpellingMapERKN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L35TryAcquireCapabilityAttrSpellingMapERKN5clang13AttributeListE")
//</editor-fold>
public static /*uint*/int TryAcquireCapabilityAttrSpellingMap(final /*const*/ AttributeList /*&*/ Attr) {
  final class/*enum*/ Spelling {
    private static final /*uint*/int GNU_try_acquire_capability = 0;
    private static final /*uint*/int CXX11_clang_try_acquire_capability = 1;
    private static final /*uint*/int GNU_try_acquire_shared_capability = 2;
    private static final /*uint*/int CXX11_clang_try_acquire_shared_capability = 3;
  };
  
  /*uint*/int Idx = Attr.getAttributeSpellingListIndex();
  switch (Idx) {
   default:
    throw new llvm_unreachable("Unknown spelling list index");
   case 0:
    return Spelling.GNU_try_acquire_capability;
   case 1:
    return Spelling.CXX11_clang_try_acquire_capability;
   case 2:
    return Spelling.GNU_try_acquire_shared_capability;
   case 3:
    return Spelling.CXX11_clang_try_acquire_shared_capability;
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkUnusedAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1552,
 FQN="(anonymous namespace)::checkUnusedAppertainsTo", NM="_ZN12_GLOBAL__N_1L23checkUnusedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L23checkUnusedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkUnusedAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_VarDecl(D) && !isa_ObjCIvarDecl(D) && !isa_TypeDecl(D) && !isa_EnumDecl(D) && !isa_EnumConstantDecl(D) && !isa_LabelDecl(D) && !isa_FieldDecl(D) && !isa_ObjCMethodDecl(D) && !isFunctionLike(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedForMaybeUnused));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnusedAttrSpellingMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1561,
 FQN="(anonymous namespace)::UnusedAttrSpellingMap", NM="_ZN12_GLOBAL__N_1L21UnusedAttrSpellingMapERKN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L21UnusedAttrSpellingMapERKN5clang13AttributeListE")
//</editor-fold>
public static /*uint*/int UnusedAttrSpellingMap(final /*const*/ AttributeList /*&*/ Attr) {
  final class/*enum*/ Spelling {
    private static final /*uint*/int CXX11_maybe_unused = 0;
    private static final /*uint*/int GNU_unused = 1;
    private static final /*uint*/int CXX11_gnu_unused = 2;
  };
  
  /*uint*/int Idx = Attr.getAttributeSpellingListIndex();
  switch (Idx) {
   default:
    throw new llvm_unreachable("Unknown spelling list index");
   case 0:
    return Spelling.CXX11_maybe_unused;
   case 1:
    return Spelling.GNU_unused;
   case 2:
    return Spelling.CXX11_gnu_unused;
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkMicrosoftExtBorlandLangOpts">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1577,
 FQN="(anonymous namespace)::checkMicrosoftExtBorlandLangOpts", NM="_ZN12_GLOBAL__N_1L32checkMicrosoftExtBorlandLangOptsERN5clang4SemaERKNS0_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L32checkMicrosoftExtBorlandLangOptsERN5clang4SemaERKNS0_13AttributeListE")
//</editor-fold>
public static boolean checkMicrosoftExtBorlandLangOpts(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (S.LangOpts.MicrosoftExt || S.LangOpts.Borland) {
      return true;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_ignored)), Attr.getName()));
    return false;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkVecReturnAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1585,
 FQN="(anonymous namespace)::checkVecReturnAppertainsTo", NM="_ZN12_GLOBAL__N_1L26checkVecReturnAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L26checkVecReturnAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkVecReturnAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_CXXRecordDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedClass));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkVecTypeHintAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1594,
 FQN="(anonymous namespace)::checkVecTypeHintAppertainsTo", NM="_ZN12_GLOBAL__N_1L28checkVecTypeHintAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L28checkVecTypeHintAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkVecTypeHintAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkWarnUnusedAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1603,
 FQN="(anonymous namespace)::checkWarnUnusedAppertainsTo", NM="_ZN12_GLOBAL__N_1L27checkWarnUnusedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L27checkWarnUnusedAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkWarnUnusedAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_RecordDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), (S.getLangOpts().CPlusPlus ? AttributeDeclKind.ExpectedStructOrUnionOrClass : AttributeDeclKind.ExpectedStructOrUnion)));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkWarnUnusedResultAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1612,
 FQN="(anonymous namespace)::checkWarnUnusedResultAppertainsTo", NM="_ZN12_GLOBAL__N_1L33checkWarnUnusedResultAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L33checkWarnUnusedResultAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkWarnUnusedResultAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_ObjCMethodDecl(D) && !isa_EnumDecl(D) && !isa_CXXRecordDecl(D) && !isFunctionLike(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunctionMethodEnumOrClass));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WarnUnusedResultAttrSpellingMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1621,
 FQN="(anonymous namespace)::WarnUnusedResultAttrSpellingMap", NM="_ZN12_GLOBAL__N_1L31WarnUnusedResultAttrSpellingMapERKN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L31WarnUnusedResultAttrSpellingMapERKN5clang13AttributeListE")
//</editor-fold>
public static /*uint*/int WarnUnusedResultAttrSpellingMap(final /*const*/ AttributeList /*&*/ Attr) {
  final class/*enum*/ Spelling {
    private static final /*uint*/int CXX11_nodiscard = 0;
    private static final /*uint*/int CXX11_clang_warn_unused_result = 1;
    private static final /*uint*/int GNU_warn_unused_result = 2;
    private static final /*uint*/int CXX11_gnu_warn_unused_result = 3;
  };
  
  /*uint*/int Idx = Attr.getAttributeSpellingListIndex();
  switch (Idx) {
   default:
    throw new llvm_unreachable("Unknown spelling list index");
   case 0:
    return Spelling.CXX11_nodiscard;
   case 1:
    return Spelling.CXX11_clang_warn_unused_result;
   case 2:
    return Spelling.GNU_warn_unused_result;
   case 3:
    return Spelling.CXX11_gnu_warn_unused_result;
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkWeakAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1639,
 FQN="(anonymous namespace)::checkWeakAppertainsTo", NM="_ZN12_GLOBAL__N_1L21checkWeakAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L21checkWeakAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkWeakAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_VarDecl(D) && !isa_FunctionDecl(D) && !isa_CXXRecordDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), (S.getLangOpts().CPlusPlus ? AttributeDeclKind.ExpectedFunctionVariableOrClass : AttributeDeclKind.ExpectedVariableOrFunction)));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkWeakRefAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1648,
 FQN="(anonymous namespace)::checkWeakRefAppertainsTo", NM="_ZN12_GLOBAL__N_1L24checkWeakRefAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L24checkWeakRefAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkWeakRefAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_VarDecl(D) && !isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedVariableOrFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkWorkGroupSizeHintAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1657,
 FQN="(anonymous namespace)::checkWorkGroupSizeHintAppertainsTo", NM="_ZN12_GLOBAL__N_1L34checkWorkGroupSizeHintAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L34checkWorkGroupSizeHintAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkWorkGroupSizeHintAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunction));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isTargetx86">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1666,
 FQN="(anonymous namespace)::isTargetx86", NM="_ZN12_GLOBAL__N_1L11isTargetx86ERKN5clang10TargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L11isTargetx86ERKN5clang10TargetInfoE")
//</editor-fold>
public static boolean isTargetx86(final /*const*/ TargetInfo /*&*/ Target) {
  final /*const*/ Triple /*&*/ T = Target.getTriple();
  return (T.getArch() == Triple.ArchType.x86);
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::checkXRayInstrumentAppertainsTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1671,
 FQN="(anonymous namespace)::checkXRayInstrumentAppertainsTo", NM="_ZN12_GLOBAL__N_1L31checkXRayInstrumentAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L31checkXRayInstrumentAppertainsToERN5clang4SemaERKNS0_13AttributeListEPKNS0_4DeclE")
//</editor-fold>
public static boolean checkXRayInstrumentAppertainsTo(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ Attr, /*const*/ Decl /*P*/ D) {
  if (!isa_CXXMethodDecl(D) && !isa_ObjCMethodDecl(D) && !isa_FunctionDecl(D)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_attribute_wrong_decl_type)), 
              Attr.getName()), AttributeDeclKind.ExpectedFunctionOrMethod));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::XRayInstrumentAttrSpellingMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1680,
 FQN="(anonymous namespace)::XRayInstrumentAttrSpellingMap", NM="_ZN12_GLOBAL__N_1L29XRayInstrumentAttrSpellingMapERKN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L29XRayInstrumentAttrSpellingMapERKN5clang13AttributeListE")
//</editor-fold>
public static /*uint*/int XRayInstrumentAttrSpellingMap(final /*const*/ AttributeList /*&*/ Attr) {
  final class/*enum*/ Spelling {
    private static final /*uint*/int GNU_xray_always_instrument = 0;
    private static final /*uint*/int CXX11_clang_xray_always_instrument = 1;
    private static final /*uint*/int GNU_xray_never_instrument = 2;
    private static final /*uint*/int CXX11_clang_xray_never_instrument = 3;
  };
  
  /*uint*/int Idx = Attr.getAttributeSpellingListIndex();
  switch (Idx) {
   default:
    throw new llvm_unreachable("Unknown spelling list index");
   case 0:
    return Spelling.GNU_xray_always_instrument;
   case 1:
    return Spelling.CXX11_clang_xray_always_instrument;
   case 2:
    return Spelling.GNU_xray_never_instrument;
   case 3:
    return Spelling.CXX11_clang_xray_never_instrument;
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AttrInfoMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrParsedAttrImpl.inc", line = 1698,
 FQN="(anonymous namespace)::AttrInfoMap", NM="_ZN12_GLOBAL__N_1L11AttrInfoMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN12_GLOBAL__N_1L11AttrInfoMapE")
//</editor-fold>
public static /*const*/ ParsedAttrInfo AttrInfoMap[/*208*/] = new /*const*/ ParsedAttrInfo [/*208*/] {
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkAMDGPUNumSGPRAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_AMDGPUNumSGPR
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkAMDGPUNumVGPRAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_AMDGPUNumVGPR
  new ParsedAttrInfo(0, 1, 1, 1, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::isTargetarmthumbx86x86_64msp430mipsmipsel, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Interrupt
  new ParsedAttrInfo(0, 15, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkAbiTagAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_AbiTag
  new ParsedAttrInfo(0, 15, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkAcquireCapabilityAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::AcquireCapabilityAttrSpellingMap),  // AT_AcquireCapability
  new ParsedAttrInfo(0, 15, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkAcquiredAfterAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_AcquiredAfter
  new ParsedAttrInfo(0, 15, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkAcquiredBeforeAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_AcquiredBefore
  new ParsedAttrInfo(1, 0, 0, 0, 1, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_AddressSpace
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkAliasAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Alias
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkAlignValueAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_AlignValue
  new ParsedAttrInfo(0, 1, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::AlignedAttrSpellingMap),  // AT_Aligned
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkAlwaysInlineAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::AlwaysInlineAttrSpellingMap),  // AT_AlwaysInline
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_AnalyzerNoReturn
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Annotate
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkArcWeakrefUnavailableAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ArcWeakrefUnavailable
  new ParsedAttrInfo(4, 0, 1, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::ArgumentWithTypeTagAttrSpellingMap),  // AT_ArgumentWithTypeTag
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkAssertCapabilityAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::AssertCapabilityAttrSpellingMap),  // AT_AssertCapability
  new ParsedAttrInfo(0, 15, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkAssertExclusiveLockAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_AssertExclusiveLock
  new ParsedAttrInfo(0, 15, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkAssertSharedLockAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_AssertSharedLock
  new ParsedAttrInfo(1, 1, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkAssumeAlignedAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_AssumeAligned
  new ParsedAttrInfo(8, 0, 1, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Availability
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Blocks
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_CDecl
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkCFAuditedTransferAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_CFAuditedTransfer
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkCFConsumedAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_CFConsumed
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_CFReturnsNotRetained
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_CFReturnsRetained
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkCFUnknownTransferAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_CFUnknownTransfer
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkCUDAConstantAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::checkCUDALangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_CUDAConstant
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkCUDADeviceAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::checkCUDALangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_CUDADevice
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkCUDAGlobalAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::checkCUDALangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_CUDAGlobal
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkCUDAHostAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::checkCUDALangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_CUDAHost
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkCUDAInvalidTargetAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::checkCUDALangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_CUDAInvalidTarget
  new ParsedAttrInfo(1, 1, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkCUDALaunchBoundsAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::checkCUDALangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_CUDALaunchBounds
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkCUDASharedAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::checkCUDALangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_CUDAShared
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkCXX11NoReturnAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_CXX11NoReturn
  new ParsedAttrInfo(0, 15, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkCallableWhenAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_CallableWhen
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkCapabilityAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::CapabilityAttrSpellingMap),  // AT_Capability
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkCarriesDependencyAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_CarriesDependency
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkCleanupAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Cleanup
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkColdAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Cold
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkCommonAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Common
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Const
  new ParsedAttrInfo(0, 1, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkConstructorAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Constructor
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkConsumableAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Consumable
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkConsumableAutoCastAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ConsumableAutoCast
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkConsumableSetOnReadAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ConsumableSetOnRead
  new ParsedAttrInfo(0, 0, 0, 1, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkDLLExportAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::isTargetx86x86_64armthumbWin32, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_DLLExport
  new ParsedAttrInfo(0, 0, 0, 1, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkDLLImportAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::isTargetx86x86_64armthumbWin32, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_DLLImport
  new ParsedAttrInfo(0, 2, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Deprecated
  new ParsedAttrInfo(0, 1, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkDestructorAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Destructor
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkDisableTailCallsAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_DisableTailCalls
  new ParsedAttrInfo(0, 0, 0, 1, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkEmptyBasesAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::isTargetx86x86_64armthumbMicrosoft, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_EmptyBases
  new ParsedAttrInfo(2, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkEnableIfAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_EnableIf
  new ParsedAttrInfo(1, 15, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkExclusiveTrylockFunctionAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ExclusiveTrylockFunction
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkExtVectorTypeAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ExtVectorType
  new ParsedAttrInfo(0, 0, 0, 0, 0, 1, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_FallThrough
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_FastCall
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkFlagEnumAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::checkCPlusPlusLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_FlagEnum
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkFlattenAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Flatten
  new ParsedAttrInfo(3, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkFormatAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Format
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkFormatArgAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_FormatArg
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkGNUInlineAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_GNUInline
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkGuardedByAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_GuardedBy
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkGuardedVarAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_GuardedVar
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkHotAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Hot
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkIBActionAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_IBAction
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_IBOutlet
  new ParsedAttrInfo(0, 1, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_IBOutletCollection
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkIFuncAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_IFunc
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkInitPriorityAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_InitPriority
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_IntelOclBicc
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkInternalLinkageAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_InternalLinkage
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkLTOVisibilityPublicAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_LTOVisibilityPublic
  new ParsedAttrInfo(1, 0, 0, 1, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkLayoutVersionAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::isTargetx86x86_64armthumbMicrosoft, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_LayoutVersion
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkLockReturnedAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_LockReturned
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkLockableAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Lockable
  new ParsedAttrInfo(0, 15, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkLocksExcludedAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_LocksExcluded
  new ParsedAttrInfo(3, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::LoopHintAttrSpellingMap),  // AT_LoopHint
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_MSABI
  new ParsedAttrInfo(0, 1, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::checkMicrosoftExtLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::MSInheritanceAttrSpellingMap),  // AT_MSInheritance
  new ParsedAttrInfo(0, 0, 0, 1, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkMSNoVTableAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::isTargetx86x86_64armthumbMicrosoft, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_MSNoVTable
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkMSStructAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_MSStruct
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_MayAlias
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkMinSizeAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_MinSize
  new ParsedAttrInfo(0, 0, 0, 1, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkMips16AppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::isTargetmipsmipsel, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Mips16
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkModeAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Mode
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkNSConsumedAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_NSConsumed
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkNSConsumesSelfAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_NSConsumesSelf
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_NSReturnsAutoreleased
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_NSReturnsNotRetained
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_NSReturnsRetained
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkNakedAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Naked
  new ParsedAttrInfo(1, 0, 0, 0, 1, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_NeonPolyVectorType
  new ParsedAttrInfo(1, 0, 0, 0, 1, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_NeonVectorType
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkNoAliasAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_NoAlias
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkNoCommonAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_NoCommon
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkNoDebugAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_NoDebug
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkNoDuplicateAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_NoDuplicate
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkNoInlineAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_NoInline
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkNoInstrumentFunctionAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_NoInstrumentFunction
  new ParsedAttrInfo(0, 0, 0, 1, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkNoMips16AppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::isTargetmipsmipsel, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_NoMips16
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_NoReturn
  new ParsedAttrInfo(0, 15, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkNoSanitizeAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_NoSanitize
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkNoSanitizeSpecificAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_NoSanitizeSpecific
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkNoSplitStackAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_NoSplitStack
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkNoThreadSafetyAnalysisAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_NoThreadSafetyAnalysis
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_NoThrow
  new ParsedAttrInfo(0, 15, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkNonNullAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_NonNull
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkNotTailCalledAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_NotTailCalled
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkObjCBoxableAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ObjCBoxable
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkObjCBridgeAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ObjCBridge
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkObjCBridgeMutableAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ObjCBridgeMutable
  new ParsedAttrInfo(1, 2, 1, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkObjCBridgeRelatedAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ObjCBridgeRelated
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkObjCDesignatedInitializerAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ObjCDesignatedInitializer
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkObjCExceptionAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ObjCException
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkObjCExplicitProtocolImplAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ObjCExplicitProtocolImpl
  new ParsedAttrInfo(1, 0, 0, 0, 1, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ObjCGC
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ObjCIndependentClass
  new ParsedAttrInfo(0, 0, 0, 0, 1, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ObjCKindOf
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkObjCMethodFamilyAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ObjCMethodFamily
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ObjCNSObject
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ObjCOwnership
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkObjCPreciseLifetimeAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ObjCPreciseLifetime
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkObjCRequiresPropertyDefsAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ObjCRequiresPropertyDefs
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkObjCRequiresSuperAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ObjCRequiresSuper
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkObjCReturnsInnerPointerAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ObjCReturnsInnerPointer
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkObjCRootClassAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ObjCRootClass
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkObjCRuntimeNameAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ObjCRuntimeName
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkObjCRuntimeVisibleAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ObjCRuntimeVisible
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkOpenCLAccessAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::OpenCLAccessAttrSpellingMap),  // AT_OpenCLAccess
  new ParsedAttrInfo(0, 0, 0, 0, 1, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_OpenCLConstantAddressSpace
  new ParsedAttrInfo(0, 0, 0, 0, 1, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_OpenCLGenericAddressSpace
  new ParsedAttrInfo(0, 0, 0, 0, 1, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_OpenCLGlobalAddressSpace
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkOpenCLKernelAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_OpenCLKernel
  new ParsedAttrInfo(0, 0, 0, 0, 1, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_OpenCLLocalAddressSpace
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkOpenCLNoSVMAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::checkOpenCLLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_OpenCLNoSVM
  new ParsedAttrInfo(0, 0, 0, 0, 1, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_OpenCLPrivateAddressSpace
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_OpenCLUnrollHint
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkOptimizeNoneAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_OptimizeNone
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkOverloadableAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Overloadable
  new ParsedAttrInfo(1, 15, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkOwnershipAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::OwnershipAttrSpellingMap),  // AT_Ownership
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Packed
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkParamTypestateAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ParamTypestate
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Pascal
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkPassObjectSizeAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_PassObjectSize
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Pcs
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_PreserveAll
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_PreserveMost
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkPtGuardedByAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_PtGuardedBy
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkPtGuardedVarAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_PtGuardedVar
  new ParsedAttrInfo(0, 0, 0, 0, 1, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Ptr32
  new ParsedAttrInfo(0, 0, 0, 0, 1, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Ptr64
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Pure
  new ParsedAttrInfo(1, 0, 0, 0, 1, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Regparm
  new ParsedAttrInfo(0, 15, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkReleaseCapabilityAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::ReleaseCapabilityAttrSpellingMap),  // AT_ReleaseCapability
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkRenderScriptKernelAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::checkRenderScriptLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_RenderScriptKernel
  new ParsedAttrInfo(3, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkReqdWorkGroupSizeAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ReqdWorkGroupSize
  new ParsedAttrInfo(0, 15, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkRequiresCapabilityAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::RequiresCapabilityAttrSpellingMap),  // AT_RequiresCapability
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkRestrictAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::RestrictAttrSpellingMap),  // AT_Restrict
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkReturnTypestateAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ReturnTypestate
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkReturnsNonNullAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ReturnsNonNull
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkReturnsTwiceAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ReturnsTwice
  new ParsedAttrInfo(0, 0, 0, 0, 1, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_SPtr
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkScopedLockableAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ScopedLockable
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkSectionAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::SectionAttrSpellingMap),  // AT_Section
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::checkMicrosoftExtLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_SelectAny
  new ParsedAttrInfo(0, 2, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Sentinel
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkSetTypestateAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_SetTypestate
  new ParsedAttrInfo(1, 15, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkSharedTrylockFunctionAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_SharedTrylockFunction
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_StdCall
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_SwiftCall
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkSwiftContextAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_SwiftContext
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkSwiftErrorResultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_SwiftErrorResult
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkSwiftIndirectResultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_SwiftIndirectResult
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_SysVABI
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkTLSModelAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_TLSModel
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkTargetAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Target
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkTestTypestateAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_TestTypestate
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_ThisCall
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkThreadAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::checkMicrosoftExtLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Thread
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_TransparentUnion
  new ParsedAttrInfo(1, 15, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkTryAcquireCapabilityAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::TryAcquireCapabilityAttrSpellingMap),  // AT_TryAcquireCapability
  new ParsedAttrInfo(0, 0, 0, 0, 1, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_TypeNonNull
  new ParsedAttrInfo(0, 0, 0, 0, 1, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_TypeNullUnspecified
  new ParsedAttrInfo(0, 0, 0, 0, 1, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_TypeNullable
  new ParsedAttrInfo(4, 0, 1, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_TypeTagForDatatype
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_TypeVisibility
  new ParsedAttrInfo(0, 0, 0, 0, 1, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_UPtr
  new ParsedAttrInfo(0, 2, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Unavailable
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkUnusedAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::UnusedAttrSpellingMap),  // AT_Unused
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Used
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::checkMicrosoftExtBorlandLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Uuid
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkVecReturnAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_VecReturn
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkVecTypeHintAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_VecTypeHint
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_VectorCall
  new ParsedAttrInfo(1, 0, 0, 0, 1, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_VectorSize
  new ParsedAttrInfo(1, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Visibility
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkWarnUnusedAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_WarnUnused
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkWarnUnusedResultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::WarnUnusedResultAttrSpellingMap),  // AT_WarnUnusedResult
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkWeakAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_Weak
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_WeakImport
  new ParsedAttrInfo(0, 1, 0, 0, 0, 0, 1, /*FunRef*/AttrParsedAttrImplGlobals::checkWeakRefAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_WeakRef
  new ParsedAttrInfo(3, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkWorkGroupSizeHintAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_WorkGroupSizeHint
  new ParsedAttrInfo(0, 0, 0, 1, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::defaultAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::isTargetx86, /*FunRef*/AttrParsedAttrImplGlobals::defaultSpellingIndexToSemanticSpelling),  // AT_X86ForceAlignArgPointer
  new ParsedAttrInfo(0, 0, 0, 0, 0, 0, 0, /*FunRef*/AttrParsedAttrImplGlobals::checkXRayInstrumentAppertainsTo, /*FunRef*/AttrParsedAttrImplGlobals::defaultDiagnoseLangOpts, /*FunRef*/AttrParsedAttrImplGlobals::defaultTargetRequirements, /*FunRef*/AttrParsedAttrImplGlobals::XRayInstrumentAttrSpellingMap) // AT_XRayInstrument
};
} // END OF class AttrParsedAttrImplGlobals
