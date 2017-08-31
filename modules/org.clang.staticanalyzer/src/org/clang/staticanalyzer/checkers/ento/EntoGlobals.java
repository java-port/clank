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
package org.clang.staticanalyzer.checkers.ento;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.lex.*;
import org.clang.basic.*;
import org.clang.frontend.*;
import org.clang.frontend.staticanalyzer.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.frontend.ento.*;
import static org.clang.staticanalyzer.checkers.ento.EntoGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type EntoGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/AnalyzerStatsChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BoolAssignmentChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BuiltinFunctionChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastSizeChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastToStructChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCInstMethSignature.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSizeofPointer.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ClangCheckers.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DereferenceChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DivZeroChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/DynamicTypeMap.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/FixedAddressChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/HTMLDiagnostics.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IdenticalExprChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/LoopWidening.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSXAPIChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSAutoreleasePoolChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NoReturnFunctionChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NonNullParamChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCAtSyncChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersASTChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCUnusedIVarsChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerSubChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnPointerRangeChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnUndefChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SVals.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TaintTesterChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefBranchChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefCapturedBlockVarChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefResultChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefinedArraySubscriptChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefinedAssignmentChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnreachableCodeChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VLASizeChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp -nm=Tpl__ZN5clang4ento12containsStmtEPKNS_4StmtE;_ZN5clang4ento12containsEnumEPKNS_4StmtE;_ZN5clang4ento12registergetsERNS0_14CheckerManagerE;_ZN5clang4ento12registerrandERNS0_14CheckerManagerE;_ZN5clang4ento13containsMacroEPKNS_4StmtE;_ZN5clang4ento13registergetpwERNS0_14CheckerManagerE;_ZN5clang4ento13registervforkERNS0_14CheckerManagerE;_ZN5clang4ento14registermktempERNS0_14CheckerManagerE;_ZN5clang4ento14registerstrcpyERNS0_14CheckerManagerE;_ZN5clang4ento15parseAssignmentEPKNS_4StmtE;_ZN5clang4ento15registermkstempERNS0_14CheckerManagerE;_ZN5clang4ento16printCheckerHelpERN4llvm11raw_ostreamENS1_8ArrayRefISsEE;_ZN5clang4ento17registerCFGDumperERNS0_14CheckerManagerE;_ZN5clang4ento17registerCFGViewerERNS0_14CheckerManagerE;_ZN5clang4ento18ProgramStateRetainEPKNS0_12ProgramStateE;_ZN5clang4ento18getDynamicTypeInfoEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_9MemRegionE;_ZN5clang4ento18registerCallDumperERNS0_14CheckerManagerE;_ZN5clang4ento18registerMPICheckerERNS0_14CheckerManagerE;_ZN5clang4ento18setDynamicTypeInfoEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_9MemRegionENS0_15DynamicTypeInfoE;_ZN5clang4ento18setDynamicTypeInfoEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_9MemRegionENS_8QualTypeEb;_ZN5clang4ento19ProgramStateReleaseEPKNS0_12ProgramStateE;_ZN5clang4ento19containsStaticLocalEPKNS_4StmtE;_ZN5clang4ento19getWidenedLoopStateEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextEjPKNS_4StmtE;_ZN5clang4ento20createCheckerManagerERNS_15AnalyzerOptionsERKNS_11LangOptionsEN4llvm8ArrayRefISsEERNS_17DiagnosticsEngineE;_ZN5clang4ento20registerConfigDumperERNS0_14CheckerManagerE;_ZN5clang4ento20registerVforkCheckerERNS0_14CheckerManagerE;_ZN5clang4ento21registerBugHashDumperERNS0_14CheckerManagerE;_ZN5clang4ento21registerChrootCheckerERNS0_14CheckerManagerE;_ZN5clang4ento21registerMallocCheckerERNS0_14CheckerManagerE;_ZN5clang4ento21registerNilArgCheckerERNS0_14CheckerManagerE;_ZN5clang4ento21registerStreamCheckerERNS0_14CheckerManagerE;_ZN5clang4ento22CreateAnalysisConsumerERNS_16CompilerInstanceE;_ZN5clang4ento22registerCFErrorCheckerERNS0_14CheckerManagerE;_ZN5clang4ento22registerCStringNullArgERNS0_14CheckerManagerE;_ZN5clang4ento22registerDivZeroCheckerERNS0_14CheckerManagerE;_ZN5clang4ento22registerNSErrorCheckerERNS0_14CheckerManagerE;_ZN5clang4ento22registerPaddingCheckerERNS0_14CheckerManagerE;_ZN5clang4ento22registerUnixAPICheckerERNS0_14CheckerManagerE;_ZN5clang4ento22registerVLASizeCheckerERNS0_14CheckerManagerE;_ZN5clang4ento23containsBuiltinOffsetOfEPKNS_4StmtE;_ZN5clang4ento23createSimpleSValBuilderERN4llvm20BumpPtrAllocatorImplINS1_15MallocAllocatorELj4096ELj4096EEERNS_10ASTContextERNS0_19ProgramStateManagerE;_ZN5clang4ento23registerBuiltinCheckersERNS0_15CheckerRegistryE;_ZN5clang4ento23registerCallGraphDumperERNS0_14CheckerManagerE;_ZN5clang4ento23registerCallGraphViewerERNS0_14CheckerManagerE;_ZN5clang4ento23registerCastSizeCheckerERNS0_14CheckerManagerE;_ZN5clang4ento23registerObjCLoopCheckerERNS0_14CheckerManagerE;_ZN5clang4ento23registerTraversalDumperERNS0_14CheckerManagerE;_ZN5clang4ento23registerUncheckedReturnERNS0_14CheckerManagerE;_ZN5clang4ento24CreateRegionStoreManagerERNS0_19ProgramStateManagerE;_ZN5clang4ento24registerFloatLoopCounterERNS0_14CheckerManagerE;_ZN5clang4ento24registerMacOSXAPICheckerERNS0_14CheckerManagerE;_ZN5clang4ento24registerNewDeleteCheckerERNS0_14CheckerManagerE;_ZN5clang4ento25registerArrayBoundCheckerERNS0_14CheckerManagerE;_ZN5clang4ento25registerDeadStoresCheckerERNS0_14CheckerManagerE;_ZN5clang4ento25registerObjCAtSyncCheckerERNS0_14CheckerManagerE;_ZN5clang4ento25registerPointerSubCheckerERNS0_14CheckerManagerE;_ZN5clang4ento26registerCStringNotNullTermERNS0_14CheckerManagerE;_ZN5clang4ento26registerCStringOutOfBoundsERNS0_14CheckerManagerE;_ZN5clang4ento26registerDereferenceCheckerERNS0_14CheckerManagerE;_ZN5clang4ento26registerDynamicTypeCheckerERNS0_14CheckerManagerE;_ZN5clang4ento26registerObjCDeallocCheckerERNS0_14CheckerManagerE;_ZN5clang4ento26registerPthreadLockCheckerERNS0_14CheckerManagerE;_ZN5clang4ento26registerRetainCountCheckerERNS0_14CheckerManagerE;_ZN5clang4ento26registerReturnUndefCheckerERNS0_14CheckerManagerE;_ZN5clang4ento26registerTaintTesterCheckerERNS0_14CheckerManagerE;_ZN5clang4ento26registerUndefBranchCheckerERNS0_14CheckerManagerE;_ZN5clang4ento26registerUndefResultCheckerERNS0_14CheckerManagerE;_ZN5clang4ento26registerVirtualCallCheckerERNS0_14CheckerManagerE;_ZN5clang4ento27registerArrayBoundCheckerV2ERNS0_14CheckerManagerE;_ZN5clang4ento27registerCastToStructCheckerERNS0_14CheckerManagerE;_ZN5clang4ento27registerClassReleaseCheckerERNS0_14CheckerManagerE;_ZN5clang4ento27registerExplodedGraphViewerERNS0_14CheckerManagerE;_ZN5clang4ento27registerFixedAddressCheckerERNS0_14CheckerManagerE;_ZN5clang4ento27registerGenericTaintCheckerERNS0_14CheckerManagerE;_ZN5clang4ento27registerLiveVariablesDumperERNS0_14CheckerManagerE;_ZN5clang4ento27registerMallocSizeofCheckerERNS0_14CheckerManagerE;_ZN5clang4ento27registerNonNullParamCheckerERNS0_14CheckerManagerE;_ZN5clang4ento27registerObjCGenericsCheckerERNS0_14CheckerManagerE;_ZN5clang4ento27registerObjCMethSigsCheckerERNS0_14CheckerManagerE;_ZN5clang4ento27registerObjCSelfInitCheckerERNS0_14CheckerManagerE;_ZN5clang4ento27registerPluralMisuseCheckerERNS0_14CheckerManagerE;_ZN5clang4ento27registerPointerArithCheckerERNS0_14CheckerManagerE;_ZN5clang4ento27registerSimpleStreamCheckerERNS0_14CheckerManagerE;_ZN5clang4ento28CreateRangeConstraintManagerERNS0_19ProgramStateManagerEPNS0_9SubEngineE;_ZN5clang4ento28createHTMLDiagnosticConsumerERNS_15AnalyzerOptionsERSt6vectorIPNS0_22PathDiagnosticConsumerESaIS5_EERKSsRKNS_12PreprocessorE;_ZN5clang4ento28registerAnalyzerStatsCheckerERNS0_14CheckerManagerE;_ZN5clang4ento28registerCStringBufferOverlapERNS0_14CheckerManagerE;_ZN5clang4ento28registerCStringSyntaxCheckerERNS0_14CheckerManagerE;_ZN5clang4ento28registerDirectIvarAssignmentERNS0_14CheckerManagerE;_ZN5clang4ento28registerDominatorsTreeDumperERNS0_14CheckerManagerE;_ZN5clang4ento28registerIdenticalExprCheckerERNS0_14CheckerManagerE;_ZN5clang4ento28registerObjCSuperCallCheckerERNS0_14CheckerManagerE;_ZN5clang4ento28registerSizeofPointerCheckerERNS0_14CheckerManagerE;_ZN5clang4ento29createPlistDiagnosticConsumerERNS_15AnalyzerOptionsERSt6vectorIPNS0_22PathDiagnosticConsumerESaIS5_EERKSsRKNS_12PreprocessorE;_ZN5clang4ento29registerBoolAssignmentCheckerERNS0_14CheckerManagerE;_ZN5clang4ento29registerCFNumberCreateCheckerERNS0_14CheckerManagerE;_ZN5clang4ento29registerCallAndMessageCheckerERNS0_14CheckerManagerE;_ZN5clang4ento29registerExprInspectionCheckerERNS0_14CheckerManagerE;_ZN5clang4ento29registerNewDeleteLeaksCheckerERNS0_14CheckerManagerE;_ZN5clang4ento29registerObjCContainersCheckerERNS0_14CheckerManagerE;_ZN5clang4ento30registerBuiltinFunctionCheckerERNS0_14CheckerManagerE;_ZN5clang4ento30registerCFRetainReleaseCheckerERNS0_14CheckerManagerE;_ZN5clang4ento30registerDynamicTypePropagationERNS0_14CheckerManagerE;_ZN5clang4ento30registerLLVMConventionsCheckerERNS0_14CheckerManagerE;_ZN5clang4ento30registerObjCUnusedIvarsCheckerERNS0_14CheckerManagerE;_ZN5clang4ento30registerStackAddrEscapeCheckerERNS0_14CheckerManagerE;_ZN5clang4ento30registerUnreachableCodeCheckerERNS0_14CheckerManagerE;_ZN5clang4ento31registerMacOSKeychainAPICheckerERNS0_14CheckerManagerE;_ZN5clang4ento31registerNoReturnFunctionCheckerERNS0_14CheckerManagerE;_ZN5clang4ento31registerObjCSuperDeallocCheckerERNS0_14CheckerManagerE;_ZN5clang4ento31registerTestAfterDivZeroCheckerERNS0_14CheckerManagerE;_ZN5clang4ento32createTextPathDiagnosticConsumerERNS_15AnalyzerOptionsERSt6vectorIPNS0_22PathDiagnosticConsumerESaIS5_EERKSsRKNS_12PreprocessorE;_ZN5clang4ento32registerNSAutoreleasePoolCheckerERNS0_14CheckerManagerE;_ZN5clang4ento32registerObjCContainersASTCheckerERNS0_14CheckerManagerE;_ZN5clang4ento33createPlistHTMLDiagnosticConsumerERNS_15AnalyzerOptionsERSt6vectorIPNS0_22PathDiagnosticConsumerESaIS5_EERKSsRKNS_12PreprocessorE;_ZN5clang4ento33registerMissingInvalidationMethodERNS0_14CheckerManagerE;_ZN5clang4ento33registerNonLocalizedStringCheckerERNS0_14CheckerManagerE;_ZN5clang4ento33registerReturnPointerRangeCheckerERNS0_14CheckerManagerE;_ZN5clang4ento33registerVariadicMethodTypeCheckerERNS0_14CheckerManagerE;_ZN5clang4ento34CreateFieldsOnlyRegionStoreManagerERNS0_19ProgramStateManagerE;_ZN5clang4ento34registerCallAndMessageUnInitRefArgERNS0_14CheckerManagerE;_ZN5clang4ento34registerNullPassedToNonnullCheckerERNS0_14CheckerManagerE;_ZN5clang4ento34registerUndefinedAssignmentCheckerERNS0_14CheckerManagerE;_ZN5clang4ento35registerNullableDereferencedCheckerERNS0_14CheckerManagerE;_ZN5clang4ento36registerInstanceVariableInvalidationERNS0_14CheckerManagerE;_ZN5clang4ento36registerMismatchedDeallocatorCheckerERNS0_14CheckerManagerE;_ZN5clang4ento36registerObjCNonNilReturnValueCheckerERNS0_14CheckerManagerE;_ZN5clang4ento36registerUndefCapturedBlockVarCheckerERNS0_14CheckerManagerE;_ZN5clang4ento37registerMallocOverflowSecurityCheckerERNS0_14CheckerManagerE;_ZN5clang4ento38createPlistMultiFileDiagnosticConsumerERNS_15AnalyzerOptionsERSt6vectorIPNS0_22PathDiagnosticConsumerESaIS5_EERKSsRKNS_12PreprocessorE;_ZN5clang4ento38registerNullReturnedFromNonnullCheckerERNS0_14CheckerManagerE;_ZN5clang4ento38registerNullablePassedToNonnullCheckerERNS0_14CheckerManagerE;_ZN5clang4ento38registerUndefinedArraySubscriptCheckerERNS0_14CheckerManagerE;_ZN5clang4ento39registerEmptyLocalizationContextCheckerERNS0_14CheckerManagerE;_ZN5clang4ento42registerNullableReturnedFromNonnullCheckerERNS0_14CheckerManagerE;_ZN5clang4ento49registerDirectIvarAssignmentForAnnotatedFunctionsERNS0_14CheckerManagerE;_ZN5clang4entoL15TaintTagGenericE;_ZN5clang4entolsERN4llvm11raw_ostreamERKNS0_11CheckerBaseE; -static-type=EntoGlobals -package=org.clang.staticanalyzer.checkers.ento")
//</editor-fold>
public final class EntoGlobals {


/// CreateAnalysisConsumer - Creates an ASTConsumer to run various code
/// analysis passes.  (The set of analyses run is controlled by command-line
/// options.)

//===----------------------------------------------------------------------===//
// AnalysisConsumer creation.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::ento::CreateAnalysisConsumer">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 702,
 FQN="clang::ento::CreateAnalysisConsumer", NM="_ZN5clang4ento22CreateAnalysisConsumerERNS_16CompilerInstanceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento22CreateAnalysisConsumerERNS_16CompilerInstanceE")
//</editor-fold>
public static std.unique_ptr<AnalysisASTConsumer> CreateAnalysisConsumer(final CompilerInstance /*&*/ CI) {
  return /*delegate*/org.clang.staticanalyzer.frontend.ento.impl.AnalysisConsumerEntoGlobals.
    CreateAnalysisConsumer(CI);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::TaintTagGeneric">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/TaintTag.h", line = 23,
 FQN="clang::ento::TaintTagGeneric", NM="_ZN5clang4entoL15TaintTagGenericE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4entoL15TaintTagGenericE")
//</editor-fold>
public static /*const*//*uint*/int TaintTagGeneric = 0;
/// Increments the number of times this state is referenced.
//<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateRetain">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 28,
 FQN="clang::ento::ProgramStateRetain", NM="_ZN5clang4ento18ProgramStateRetainEPKNS0_12ProgramStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento18ProgramStateRetainEPKNS0_12ProgramStateE")
//</editor-fold>
public static void ProgramStateRetain(/*const*/ ProgramState /*P*/ state) {
  /*delegate*/org.clang.staticanalyzer.core.pathsensitive.ento.impl.ProgramStateEntoGlobals.
    ProgramStateRetain(state);
}


/// Decrement the number of times this state is referenced.
//<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateRelease">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 33,
 FQN="clang::ento::ProgramStateRelease", NM="_ZN5clang4ento19ProgramStateReleaseEPKNS0_12ProgramStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento19ProgramStateReleaseEPKNS0_12ProgramStateE")
//</editor-fold>
public static void ProgramStateRelease(/*const*/ ProgramState /*P*/ state) {
  /*delegate*/org.clang.staticanalyzer.core.pathsensitive.ento.impl.ProgramStateEntoGlobals.
    ProgramStateRelease(state);
}


//===----------------------------------------------------------------------===//
// Special PathDiagnosticConsumers.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::ento::createPlistHTMLDiagnosticConsumer">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 72,
 FQN="clang::ento::createPlistHTMLDiagnosticConsumer", NM="_ZN5clang4ento33createPlistHTMLDiagnosticConsumerERNS_15AnalyzerOptionsERSt6vectorIPNS0_22PathDiagnosticConsumerESaIS5_EERKSsRKNS_12PreprocessorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento33createPlistHTMLDiagnosticConsumerERNS_15AnalyzerOptionsERSt6vectorIPNS0_22PathDiagnosticConsumerESaIS5_EERKSsRKNS_12PreprocessorE")
//</editor-fold>
public static void createPlistHTMLDiagnosticConsumer(final AnalyzerOptions /*&*/ AnalyzerOpts, 
                                 final std.vector<PathDiagnosticConsumer /*P*/ > /*&*/ C, 
                                 final /*const*/std.string/*&*/ prefix, 
                                 final /*const*/ Preprocessor /*&*/ PP) {
  /*delegate*/org.clang.staticanalyzer.core.ento.impl.AnalysisConsumerEntoGlobals.
    createPlistHTMLDiagnosticConsumer(AnalyzerOpts, 
                                 C, 
                                 prefix, 
                                 PP);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::createTextPathDiagnosticConsumer">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp", line = 81,
 FQN="clang::ento::createTextPathDiagnosticConsumer", NM="_ZN5clang4ento32createTextPathDiagnosticConsumerERNS_15AnalyzerOptionsERSt6vectorIPNS0_22PathDiagnosticConsumerESaIS5_EERKSsRKNS_12PreprocessorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento32createTextPathDiagnosticConsumerERNS_15AnalyzerOptionsERSt6vectorIPNS0_22PathDiagnosticConsumerESaIS5_EERKSsRKNS_12PreprocessorE")
//</editor-fold>
public static void createTextPathDiagnosticConsumer(final AnalyzerOptions /*&*/ AnalyzerOpts, 
                                final std.vector<PathDiagnosticConsumer /*P*/ > /*&*/ C, 
                                final /*const*/std.string/*&*/ Prefix, 
                                final /*const*/ Preprocessor /*&*/ PP) {
  /*delegate*/org.clang.staticanalyzer.core.ento.impl.AnalysisConsumerEntoGlobals.
    createTextPathDiagnosticConsumer(AnalyzerOpts, 
                                C, 
                                Prefix, 
                                PP);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerAnalyzerStatsChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/AnalyzerStatsChecker.cpp", line = 138,
 FQN="clang::ento::registerAnalyzerStatsChecker", NM="_ZN5clang4ento28registerAnalyzerStatsCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/AnalyzerStatsChecker.cpp -nm=_ZN5clang4ento28registerAnalyzerStatsCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerAnalyzerStatsChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.AnalyzerStatsCheckerEntoGlobals.
    registerAnalyzerStatsChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerArrayBoundChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundChecker.cpp", line = 91,
 FQN="clang::ento::registerArrayBoundChecker", NM="_ZN5clang4ento25registerArrayBoundCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundChecker.cpp -nm=_ZN5clang4ento25registerArrayBoundCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerArrayBoundChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.ArrayBoundCheckerEntoGlobals.
    registerArrayBoundChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerArrayBoundCheckerV2">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp", line = 304,
 FQN="clang::ento::registerArrayBoundCheckerV2", NM="_ZN5clang4ento27registerArrayBoundCheckerV2ERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp -nm=_ZN5clang4ento27registerArrayBoundCheckerV2ERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerArrayBoundCheckerV2(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.ArrayBoundCheckerV2EntoGlobals.
    registerArrayBoundCheckerV2(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerCFNumberCreateChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 1275,
 FQN="clang::ento::registerCFNumberCreateChecker", NM="_ZN5clang4ento29registerCFNumberCreateCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN5clang4ento29registerCFNumberCreateCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerCFNumberCreateChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.BasicObjCFoundationChecksEntoGlobals.
    registerCFNumberCreateChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerCFRetainReleaseChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 1279,
 FQN="clang::ento::registerCFRetainReleaseChecker", NM="_ZN5clang4ento30registerCFRetainReleaseCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN5clang4ento30registerCFRetainReleaseCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerCFRetainReleaseChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.BasicObjCFoundationChecksEntoGlobals.
    registerCFRetainReleaseChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerClassReleaseChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 1283,
 FQN="clang::ento::registerClassReleaseChecker", NM="_ZN5clang4ento27registerClassReleaseCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN5clang4ento27registerClassReleaseCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerClassReleaseChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.BasicObjCFoundationChecksEntoGlobals.
    registerClassReleaseChecker(mgr);
}


//===----------------------------------------------------------------------===//
// Check registration.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::ento::registerNilArgChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 1271,
 FQN="clang::ento::registerNilArgChecker", NM="_ZN5clang4ento21registerNilArgCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN5clang4ento21registerNilArgCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerNilArgChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.BasicObjCFoundationChecksEntoGlobals.
    registerNilArgChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerObjCLoopChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 1291,
 FQN="clang::ento::registerObjCLoopChecker", NM="_ZN5clang4ento23registerObjCLoopCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN5clang4ento23registerObjCLoopCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerObjCLoopChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.BasicObjCFoundationChecksEntoGlobals.
    registerObjCLoopChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerObjCNonNilReturnValueChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 1295,
 FQN="clang::ento::registerObjCNonNilReturnValueChecker", NM="_ZN5clang4ento36registerObjCNonNilReturnValueCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN5clang4ento36registerObjCNonNilReturnValueCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerObjCNonNilReturnValueChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.BasicObjCFoundationChecksEntoGlobals.
    registerObjCNonNilReturnValueChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerVariadicMethodTypeChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 1287,
 FQN="clang::ento::registerVariadicMethodTypeChecker", NM="_ZN5clang4ento33registerVariadicMethodTypeCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN5clang4ento33registerVariadicMethodTypeCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerVariadicMethodTypeChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.BasicObjCFoundationChecksEntoGlobals.
    registerVariadicMethodTypeChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerBoolAssignmentChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BoolAssignmentChecker.cpp", line = 155,
 FQN="clang::ento::registerBoolAssignmentChecker", NM="_ZN5clang4ento29registerBoolAssignmentCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BoolAssignmentChecker.cpp -nm=_ZN5clang4ento29registerBoolAssignmentCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerBoolAssignmentChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.BoolAssignmentCheckerEntoGlobals.
    registerBoolAssignmentChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerBuiltinFunctionChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BuiltinFunctionChecker.cpp", line = 100,
 FQN="clang::ento::registerBuiltinFunctionChecker", NM="_ZN5clang4ento30registerBuiltinFunctionCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BuiltinFunctionChecker.cpp -nm=_ZN5clang4ento30registerBuiltinFunctionCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerBuiltinFunctionChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.BuiltinFunctionCheckerEntoGlobals.
    registerBuiltinFunctionChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerCStringBufferOverlap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 2221,
 FQN="clang::ento::registerCStringBufferOverlap", NM="_ZN5clang4ento28registerCStringBufferOverlapERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento28registerCStringBufferOverlapERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerCStringBufferOverlap(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.CStringCheckerEntoGlobals.
    registerCStringBufferOverlap(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerCStringNotNullTerm">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 2222,
 FQN="clang::ento::registerCStringNotNullTerm", NM="_ZN5clang4ento26registerCStringNotNullTermERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento26registerCStringNotNullTermERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerCStringNotNullTerm(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.CStringCheckerEntoGlobals.
    registerCStringNotNullTerm(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerCStringNullArg">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 2219,
 FQN="clang::ento::registerCStringNullArg", NM="_ZN5clang4ento22registerCStringNullArgERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento22registerCStringNullArgERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerCStringNullArg(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.CStringCheckerEntoGlobals.
    registerCStringNullArg(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerCStringOutOfBounds">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp", line = 2220,
 FQN="clang::ento::registerCStringOutOfBounds", NM="_ZN5clang4ento26registerCStringOutOfBoundsERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento26registerCStringOutOfBoundsERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerCStringOutOfBounds(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.CStringCheckerEntoGlobals.
    registerCStringOutOfBounds(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerCStringSyntaxChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp", line = 188,
 FQN="clang::ento::registerCStringSyntaxChecker", NM="_ZN5clang4ento28registerCStringSyntaxCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp -nm=_ZN5clang4ento28registerCStringSyntaxCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerCStringSyntaxChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.CStringSyntaxCheckerEntoGlobals.
    registerCStringSyntaxChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerCallAndMessageChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 598,
 FQN="clang::ento::registerCallAndMessageChecker", NM="_ZN5clang4ento29registerCallAndMessageCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZN5clang4ento29registerCallAndMessageCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerCallAndMessageChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.CallAndMessageCheckerEntoGlobals.
    registerCallAndMessageChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerCallAndMessageUnInitRefArg">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 597,
 FQN="clang::ento::registerCallAndMessageUnInitRefArg", NM="_ZN5clang4ento34registerCallAndMessageUnInitRefArgERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZN5clang4ento34registerCallAndMessageUnInitRefArgERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerCallAndMessageUnInitRefArg(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.CallAndMessageCheckerEntoGlobals.
    registerCallAndMessageUnInitRefArg(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerCastSizeChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastSizeChecker.cpp", line = 142,
 FQN="clang::ento::registerCastSizeChecker", NM="_ZN5clang4ento23registerCastSizeCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastSizeChecker.cpp -nm=_ZN5clang4ento23registerCastSizeCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerCastSizeChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.CastSizeCheckerEntoGlobals.
    registerCastSizeChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerCastToStructChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastToStructChecker.cpp", line = 73,
 FQN="clang::ento::registerCastToStructChecker", NM="_ZN5clang4ento27registerCastToStructCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastToStructChecker.cpp -nm=_ZN5clang4ento27registerCastToStructCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerCastToStructChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.CastToStructCheckerEntoGlobals.
    registerCastToStructChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerObjCDeallocChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp", line = 1062,
 FQN="clang::ento::registerObjCDeallocChecker", NM="_ZN5clang4ento26registerObjCDeallocCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCDealloc.cpp -nm=_ZN5clang4ento26registerObjCDeallocCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerObjCDeallocChecker(final CheckerManager /*&*/ Mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.CheckObjCDeallocEntoGlobals.
    registerObjCDeallocChecker(Mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerObjCMethSigsChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCInstMethSignature.cpp", line = 138,
 FQN="clang::ento::registerObjCMethSigsChecker", NM="_ZN5clang4ento27registerObjCMethSigsCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckObjCInstMethSignature.cpp -nm=_ZN5clang4ento27registerObjCMethSigsCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerObjCMethSigsChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.CheckObjCInstMethSignatureEntoGlobals.
    registerObjCMethSigsChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerFloatLoopCounter">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 775,
 FQN="clang::ento::registerFloatLoopCounter", NM="_ZN5clang4ento24registerFloatLoopCounterERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN5clang4ento24registerFloatLoopCounterERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerFloatLoopCounter(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.CheckSecuritySyntaxOnlyEntoGlobals.
    registerFloatLoopCounter(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerUncheckedReturn">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 776,
 FQN="clang::ento::registerUncheckedReturn", NM="_ZN5clang4ento23registerUncheckedReturnERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN5clang4ento23registerUncheckedReturnERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerUncheckedReturn(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.CheckSecuritySyntaxOnlyEntoGlobals.
    registerUncheckedReturn(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registergetpw">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 769,
 FQN="clang::ento::registergetpw", NM="_ZN5clang4ento13registergetpwERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN5clang4ento13registergetpwERNS0_14CheckerManagerE")
//</editor-fold>
public static void registergetpw(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.CheckSecuritySyntaxOnlyEntoGlobals.
    registergetpw(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registergets">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 768,
 FQN="clang::ento::registergets", NM="_ZN5clang4ento12registergetsERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN5clang4ento12registergetsERNS0_14CheckerManagerE")
//</editor-fold>
public static void registergets(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.CheckSecuritySyntaxOnlyEntoGlobals.
    registergets(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registermkstemp">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 770,
 FQN="clang::ento::registermkstemp", NM="_ZN5clang4ento15registermkstempERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN5clang4ento15registermkstempERNS0_14CheckerManagerE")
//</editor-fold>
public static void registermkstemp(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.CheckSecuritySyntaxOnlyEntoGlobals.
    registermkstemp(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registermktemp">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 771,
 FQN="clang::ento::registermktemp", NM="_ZN5clang4ento14registermktempERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN5clang4ento14registermktempERNS0_14CheckerManagerE")
//</editor-fold>
public static void registermktemp(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.CheckSecuritySyntaxOnlyEntoGlobals.
    registermktemp(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerrand">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 773,
 FQN="clang::ento::registerrand", NM="_ZN5clang4ento12registerrandERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN5clang4ento12registerrandERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerrand(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.CheckSecuritySyntaxOnlyEntoGlobals.
    registerrand(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerstrcpy">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 772,
 FQN="clang::ento::registerstrcpy", NM="_ZN5clang4ento14registerstrcpyERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN5clang4ento14registerstrcpyERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerstrcpy(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.CheckSecuritySyntaxOnlyEntoGlobals.
    registerstrcpy(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registervfork">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp", line = 774,
 FQN="clang::ento::registervfork", NM="_ZN5clang4ento13registervforkERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSecuritySyntaxOnly.cpp -nm=_ZN5clang4ento13registervforkERNS0_14CheckerManagerE")
//</editor-fold>
public static void registervfork(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.CheckSecuritySyntaxOnlyEntoGlobals.
    registervfork(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerSizeofPointerChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSizeofPointer.cpp", line = 91,
 FQN="clang::ento::registerSizeofPointerChecker", NM="_ZN5clang4ento28registerSizeofPointerCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSizeofPointer.cpp -nm=_ZN5clang4ento28registerSizeofPointerCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerSizeofPointerChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.CheckSizeofPointerEntoGlobals.
    registerSizeofPointerChecker(mgr);
}


/// Dump checker name to stream.
//<editor-fold defaultstate="collapsed" desc="clang::ento::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp", line = 34,
 FQN="clang::ento::operator<<", NM="_ZN5clang4entolsERN4llvm11raw_ostreamERKNS0_11CheckerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clang4entolsERN4llvm11raw_ostreamERKNS0_11CheckerBaseE")
//</editor-fold>
public static raw_ostream /*&*/ $out_raw_ostream_CheckerBase$C(final raw_ostream /*&*/ Out, 
                              final /*const*/ CheckerBase /*&*/ Checker) {
  return /*delegate*/org.clang.staticanalyzer.core.ento.impl.CheckerEntoGlobals.
    $out_raw_ostream_CheckerBase$C(Out, 
                              Checker);
}


// Recursively find any substatements containing macros
//<editor-fold defaultstate="collapsed" desc="clang::ento::containsMacro">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp", line = 19,
 FQN="clang::ento::containsMacro", NM="_ZN5clang4ento13containsMacroEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp -nm=_ZN5clang4ento13containsMacroEPKNS_4StmtE")
//</editor-fold>
public static boolean containsMacro(/*const*/ Stmt /*P*/ S) {
  return /*delegate*/org.clang.staticanalyzer.core.pathsensitive.ento.impl.CheckerHelpersEntoGlobals.
    containsMacro(S);
}


// Recursively find any substatements containing enum constants
//<editor-fold defaultstate="collapsed" desc="clang::ento::containsEnum">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp", line = 34,
 FQN="clang::ento::containsEnum", NM="_ZN5clang4ento12containsEnumEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp -nm=_ZN5clang4ento12containsEnumEPKNS_4StmtE")
//</editor-fold>
public static boolean containsEnum(/*const*/ Stmt /*P*/ S) {
  return /*delegate*/org.clang.staticanalyzer.core.pathsensitive.ento.impl.CheckerHelpersEntoGlobals.
    containsEnum(S);
}


// Recursively find any substatements containing static vars
//<editor-fold defaultstate="collapsed" desc="clang::ento::containsStaticLocal">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp", line = 48,
 FQN="clang::ento::containsStaticLocal", NM="_ZN5clang4ento19containsStaticLocalEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp -nm=_ZN5clang4ento19containsStaticLocalEPKNS_4StmtE")
//</editor-fold>
public static boolean containsStaticLocal(/*const*/ Stmt /*P*/ S) {
  return /*delegate*/org.clang.staticanalyzer.core.pathsensitive.ento.impl.CheckerHelpersEntoGlobals.
    containsStaticLocal(S);
}


// Recursively find any substatements containing __builtin_offsetof
//<editor-fold defaultstate="collapsed" desc="clang::ento::containsBuiltinOffsetOf">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp", line = 64,
 FQN="clang::ento::containsBuiltinOffsetOf", NM="_ZN5clang4ento23containsBuiltinOffsetOfEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp -nm=_ZN5clang4ento23containsBuiltinOffsetOfEPKNS_4StmtE")
//</editor-fold>
public static boolean containsBuiltinOffsetOf(/*const*/ Stmt /*P*/ S) {
  return /*delegate*/org.clang.staticanalyzer.core.pathsensitive.ento.impl.CheckerHelpersEntoGlobals.
    containsBuiltinOffsetOf(S);
}

/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ento::containsStmt">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CheckerHelpers.h", line = 31,
 FQN="clang::ento::containsStmt", NM="Tpl__ZN5clang4ento12containsStmtEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp -nm=Tpl__ZN5clang4ento12containsStmtEPKNS_4StmtE")
//</editor-fold>
public static </*class*/ T extends Stmt> boolean containsStmt(Class<T> clazz, /*const*/ Stmt /*P*/ S) {
  return /*delegate*/org.clang.staticanalyzer.core.pathsensitive.ento.impl.CheckerHelpersEntoGlobals.
    containsStmt(clazz, S);
}


// Extract lhs and rhs from assignment statement
//<editor-fold defaultstate="collapsed" desc="clang::ento::parseAssignment">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp", line = 76,
 FQN="clang::ento::parseAssignment", NM="_ZN5clang4ento15parseAssignmentEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerHelpers.cpp -nm=_ZN5clang4ento15parseAssignmentEPKNS_4StmtE")
//</editor-fold>
public static std.pairPtrPtr</*const*/ VarDecl /*P*/ , /*const*/ Expr /*P*/ > parseAssignment(/*const*/ Stmt /*P*/ S) {
  return /*delegate*/org.clang.staticanalyzer.core.pathsensitive.ento.impl.CheckerHelpersEntoGlobals.
    parseAssignment(S);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::createCheckerManager">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp", line = 104,
 FQN="clang::ento::createCheckerManager", NM="_ZN5clang4ento20createCheckerManagerERNS_15AnalyzerOptionsERKNS_11LangOptionsEN4llvm8ArrayRefISsEERNS_17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp -nm=_ZN5clang4ento20createCheckerManagerERNS_15AnalyzerOptionsERKNS_11LangOptionsEN4llvm8ArrayRefISsEERNS_17DiagnosticsEngineE")
//</editor-fold>
public static std.unique_ptr<CheckerManager> createCheckerManager(final AnalyzerOptions /*&*/ opts, final /*const*/ LangOptions /*&*/ langOpts, 
                    ArrayRef<std.string> plugins, 
                    final DiagnosticsEngine /*&*/ diags) {
  return /*delegate*/org.clang.staticanalyzer.frontend.ento.impl.CheckerRegistrationEntoGlobals.
    createCheckerManager(opts, langOpts, 
                    plugins, 
                    diags);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::printCheckerHelp">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp", line = 134,
 FQN="clang::ento::printCheckerHelp", NM="_ZN5clang4ento16printCheckerHelpERN4llvm11raw_ostreamENS1_8ArrayRefISsEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp -nm=_ZN5clang4ento16printCheckerHelpERN4llvm11raw_ostreamENS1_8ArrayRefISsEE")
//</editor-fold>
public static void printCheckerHelp(final raw_ostream /*&*/ out, ArrayRef<std.string> plugins) {
  /*delegate*/org.clang.staticanalyzer.frontend.ento.impl.CheckerRegistrationEntoGlobals.
    printCheckerHelp(out, plugins);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerChrootChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp", line = 154,
 FQN="clang::ento::registerChrootChecker", NM="_ZN5clang4ento21registerChrootCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp -nm=_ZN5clang4ento21registerChrootCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerChrootChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.ChrootCheckerEntoGlobals.
    registerChrootChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerBuiltinCheckers">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ClangCheckers.cpp", line = 26,
 FQN="clang::ento::registerBuiltinCheckers", NM="_ZN5clang4ento23registerBuiltinCheckersERNS0_15CheckerRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ClangCheckers.cpp -nm=_ZN5clang4ento23registerBuiltinCheckersERNS0_15CheckerRegistryE")
//</editor-fold>
public static void registerBuiltinCheckers(final CheckerRegistry /*&*/ registry) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.ClangCheckersEntoGlobals.
    registerBuiltinCheckers(registry);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerDeadStoresChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp", line = 479,
 FQN="clang::ento::registerDeadStoresChecker", NM="_ZN5clang4ento25registerDeadStoresCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN5clang4ento25registerDeadStoresCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerDeadStoresChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.DeadStoresCheckerEntoGlobals.
    registerDeadStoresChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerBugHashDumper">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp", line = 245,
 FQN="clang::ento::registerBugHashDumper", NM="_ZN5clang4ento21registerBugHashDumperERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN5clang4ento21registerBugHashDumperERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerBugHashDumper(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.DebugCheckersEntoGlobals.
    registerBugHashDumper(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerCFGDumper">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp", line = 114,
 FQN="clang::ento::registerCFGDumper", NM="_ZN5clang4ento17registerCFGDumperERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN5clang4ento17registerCFGDumperERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerCFGDumper(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.DebugCheckersEntoGlobals.
    registerCFGDumper(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerCFGViewer">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp", line = 88,
 FQN="clang::ento::registerCFGViewer", NM="_ZN5clang4ento17registerCFGViewerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN5clang4ento17registerCFGViewerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerCFGViewer(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.DebugCheckersEntoGlobals.
    registerCFGViewer(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerCallGraphDumper">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp", line = 154,
 FQN="clang::ento::registerCallGraphDumper", NM="_ZN5clang4ento23registerCallGraphDumperERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN5clang4ento23registerCallGraphDumperERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerCallGraphDumper(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.DebugCheckersEntoGlobals.
    registerCallGraphDumper(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerCallGraphViewer">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp", line = 134,
 FQN="clang::ento::registerCallGraphViewer", NM="_ZN5clang4ento23registerCallGraphViewerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN5clang4ento23registerCallGraphViewerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerCallGraphViewer(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.DebugCheckersEntoGlobals.
    registerCallGraphViewer(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerConfigDumper">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp", line = 193,
 FQN="clang::ento::registerConfigDumper", NM="_ZN5clang4ento20registerConfigDumperERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN5clang4ento20registerConfigDumperERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerConfigDumper(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.DebugCheckersEntoGlobals.
    registerConfigDumper(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerDominatorsTreeDumper">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp", line = 48,
 FQN="clang::ento::registerDominatorsTreeDumper", NM="_ZN5clang4ento28registerDominatorsTreeDumperERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN5clang4ento28registerDominatorsTreeDumperERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerDominatorsTreeDumper(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.DebugCheckersEntoGlobals.
    registerDominatorsTreeDumper(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerExplodedGraphViewer">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp", line = 212,
 FQN="clang::ento::registerExplodedGraphViewer", NM="_ZN5clang4ento27registerExplodedGraphViewerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN5clang4ento27registerExplodedGraphViewerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerExplodedGraphViewer(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.DebugCheckersEntoGlobals.
    registerExplodedGraphViewer(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerLiveVariablesDumper">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp", line = 68,
 FQN="clang::ento::registerLiveVariablesDumper", NM="_ZN5clang4ento27registerLiveVariablesDumperERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN5clang4ento27registerLiveVariablesDumperERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerLiveVariablesDumper(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.DebugCheckersEntoGlobals.
    registerLiveVariablesDumper(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerDereferenceChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DereferenceChecker.cpp", line = 299,
 FQN="clang::ento::registerDereferenceChecker", NM="_ZN5clang4ento26registerDereferenceCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DereferenceChecker.cpp -nm=_ZN5clang4ento26registerDereferenceCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerDereferenceChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.DereferenceCheckerEntoGlobals.
    registerDereferenceChecker(mgr);
}


// Register the checker that checks for direct accesses in all functions,
// except for the initialization and copy routines.
//<editor-fold defaultstate="collapsed" desc="clang::ento::registerDirectIvarAssignment">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp", line = 211,
 FQN="clang::ento::registerDirectIvarAssignment", NM="_ZN5clang4ento28registerDirectIvarAssignmentERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp -nm=_ZN5clang4ento28registerDirectIvarAssignmentERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerDirectIvarAssignment(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.DirectIvarAssignmentEntoGlobals.
    registerDirectIvarAssignment(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerDirectIvarAssignmentForAnnotatedFunctions">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp", line = 224,
 FQN="clang::ento::registerDirectIvarAssignmentForAnnotatedFunctions", NM="_ZN5clang4ento49registerDirectIvarAssignmentForAnnotatedFunctionsERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp -nm=_ZN5clang4ento49registerDirectIvarAssignmentForAnnotatedFunctionsERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerDirectIvarAssignmentForAnnotatedFunctions(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.DirectIvarAssignmentEntoGlobals.
    registerDirectIvarAssignmentForAnnotatedFunctions(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerDivZeroChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DivZeroChecker.cpp", line = 90,
 FQN="clang::ento::registerDivZeroChecker", NM="_ZN5clang4ento22registerDivZeroCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DivZeroChecker.cpp -nm=_ZN5clang4ento22registerDivZeroCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerDivZeroChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.DivZeroCheckerEntoGlobals.
    registerDivZeroChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerDynamicTypeChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp", line = 211,
 FQN="clang::ento::registerDynamicTypeChecker", NM="_ZN5clang4ento26registerDynamicTypeCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp -nm=_ZN5clang4ento26registerDynamicTypeCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerDynamicTypeChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.DynamicTypeCheckerEntoGlobals.
    registerDynamicTypeChecker(mgr);
}


/// \brief Set dynamic type information of the region; return the new state.
//<editor-fold defaultstate="collapsed" desc="clang::ento::setDynamicTypeInfo">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/DynamicTypeMap.h", line = 47,
 FQN="clang::ento::setDynamicTypeInfo", NM="_ZN5clang4ento18setDynamicTypeInfoEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_9MemRegionENS_8QualTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp -nm=_ZN5clang4ento18setDynamicTypeInfoEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_9MemRegionENS_8QualTypeEb")
//</editor-fold>
public static /*inline*/ IntrusiveRefCntPtr</*const*/ ProgramState> setDynamicTypeInfo(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                  /*const*/ MemRegion /*P*/ Reg, QualType NewTy) {
  return setDynamicTypeInfo(State, 
                  Reg, NewTy, 
                  true);
}
public static /*inline*/ IntrusiveRefCntPtr</*const*/ ProgramState> setDynamicTypeInfo(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                  /*const*/ MemRegion /*P*/ Reg, QualType NewTy, 
                  boolean CanBeSubClassed/*= true*/) {
  return /*delegate*/org.clang.staticanalyzer.core.pathsensitive.ento.impl.DynamicTypeMapEntoGlobals.
    setDynamicTypeInfo(State, 
                  Reg, NewTy, 
                  CanBeSubClassed);
}


/// \brief Get dynamic type information for a region.
//<editor-fold defaultstate="collapsed" desc="clang::ento::getDynamicTypeInfo">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/DynamicTypeMap.cpp", line = 21,
 FQN="clang::ento::getDynamicTypeInfo", NM="_ZN5clang4ento18getDynamicTypeInfoEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_9MemRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/DynamicTypeMap.cpp -nm=_ZN5clang4ento18getDynamicTypeInfoEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_9MemRegionE")
//</editor-fold>
public static DynamicTypeInfo getDynamicTypeInfo(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                  /*const*/ MemRegion /*P*/ Reg) {
  return /*delegate*/org.clang.staticanalyzer.core.pathsensitive.ento.impl.DynamicTypeMapEntoGlobals.
    getDynamicTypeInfo(State, 
                  Reg);
}


/// \brief Set dynamic type information of the region; return the new state.
//<editor-fold defaultstate="collapsed" desc="clang::ento::setDynamicTypeInfo">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/DynamicTypeMap.cpp", line = 42,
 FQN="clang::ento::setDynamicTypeInfo", NM="_ZN5clang4ento18setDynamicTypeInfoEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_9MemRegionENS0_15DynamicTypeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/DynamicTypeMap.cpp -nm=_ZN5clang4ento18setDynamicTypeInfoEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_9MemRegionENS0_15DynamicTypeInfoE")
//</editor-fold>
public static IntrusiveRefCntPtr</*const*/ ProgramState> setDynamicTypeInfo(IntrusiveRefCntPtr</*const*/ ProgramState> State, /*const*/ MemRegion /*P*/ Reg, 
                  DynamicTypeInfo NewTy) {
  return /*delegate*/org.clang.staticanalyzer.core.pathsensitive.ento.impl.DynamicTypeMapEntoGlobals.
    setDynamicTypeInfo(State, Reg, 
                  NewTy);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerDynamicTypePropagation">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 962,
 FQN="clang::ento::registerDynamicTypePropagation", NM="_ZN5clang4ento30registerDynamicTypePropagationERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZN5clang4ento30registerDynamicTypePropagationERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerDynamicTypePropagation(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.DynamicTypePropagationEntoGlobals.
    registerDynamicTypePropagation(mgr);
}


/// Register checkers.
//<editor-fold defaultstate="collapsed" desc="clang::ento::registerObjCGenericsChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 956,
 FQN="clang::ento::registerObjCGenericsChecker", NM="_ZN5clang4ento27registerObjCGenericsCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZN5clang4ento27registerObjCGenericsCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerObjCGenericsChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.DynamicTypePropagationEntoGlobals.
    registerObjCGenericsChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerExprInspectionChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp", line = 204,
 FQN="clang::ento::registerExprInspectionChecker", NM="_ZN5clang4ento29registerExprInspectionCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento29registerExprInspectionCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerExprInspectionChecker(final CheckerManager /*&*/ Mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.ExprInspectionCheckerEntoGlobals.
    registerExprInspectionChecker(Mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerFixedAddressChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/FixedAddressChecker.cpp", line = 66,
 FQN="clang::ento::registerFixedAddressChecker", NM="_ZN5clang4ento27registerFixedAddressCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/FixedAddressChecker.cpp -nm=_ZN5clang4ento27registerFixedAddressCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerFixedAddressChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.FixedAddressCheckerEntoGlobals.
    registerFixedAddressChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerGenericTaintChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 729,
 FQN="clang::ento::registerGenericTaintChecker", NM="_ZN5clang4ento27registerGenericTaintCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZN5clang4ento27registerGenericTaintCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerGenericTaintChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.GenericTaintCheckerEntoGlobals.
    registerGenericTaintChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::createHTMLDiagnosticConsumer">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/HTMLDiagnostics.cpp", line = 82,
 FQN="clang::ento::createHTMLDiagnosticConsumer", NM="_ZN5clang4ento28createHTMLDiagnosticConsumerERNS_15AnalyzerOptionsERSt6vectorIPNS0_22PathDiagnosticConsumerESaIS5_EERKSsRKNS_12PreprocessorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/HTMLDiagnostics.cpp -nm=_ZN5clang4ento28createHTMLDiagnosticConsumerERNS_15AnalyzerOptionsERSt6vectorIPNS0_22PathDiagnosticConsumerESaIS5_EERKSsRKNS_12PreprocessorE")
//</editor-fold>
public static void createHTMLDiagnosticConsumer(final AnalyzerOptions /*&*/ AnalyzerOpts, 
                            final std.vector<PathDiagnosticConsumer /*P*/ > /*&*/ C, 
                            final /*const*/std.string/*&*/ prefix, 
                            final /*const*/ Preprocessor /*&*/ PP) {
  /*delegate*/org.clang.staticanalyzer.core.ento.impl.HTMLDiagnosticsEntoGlobals.
    createHTMLDiagnosticConsumer(AnalyzerOpts, 
                            C, 
                            prefix, 
                            PP);
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::ento::registerIdenticalExprChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IdenticalExprChecker.cpp", line = 510,
 FQN="clang::ento::registerIdenticalExprChecker", NM="_ZN5clang4ento28registerIdenticalExprCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IdenticalExprChecker.cpp -nm=_ZN5clang4ento28registerIdenticalExprCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerIdenticalExprChecker(final CheckerManager /*&*/ Mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.IdenticalExprCheckerEntoGlobals.
    registerIdenticalExprChecker(Mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerInstanceVariableInvalidation">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 747,
 FQN="clang::ento::registerInstanceVariableInvalidation", NM="_ZN5clang4ento36registerInstanceVariableInvalidationERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN5clang4ento36registerInstanceVariableInvalidationERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerInstanceVariableInvalidation(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.IvarInvalidationCheckerEntoGlobals.
    registerInstanceVariableInvalidation(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerMissingInvalidationMethod">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 748,
 FQN="clang::ento::registerMissingInvalidationMethod", NM="_ZN5clang4ento33registerMissingInvalidationMethodERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN5clang4ento33registerMissingInvalidationMethodERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerMissingInvalidationMethod(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.IvarInvalidationCheckerEntoGlobals.
    registerMissingInvalidationMethod(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerLLVMConventionsChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 315,
 FQN="clang::ento::registerLLVMConventionsChecker", NM="_ZN5clang4ento30registerLLVMConventionsCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZN5clang4ento30registerLLVMConventionsCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerLLVMConventionsChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.LLVMConventionsCheckerEntoGlobals.
    registerLLVMConventionsChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerEmptyLocalizationContextChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 1294,
 FQN="clang::ento::registerEmptyLocalizationContextChecker", NM="_ZN5clang4ento39registerEmptyLocalizationContextCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN5clang4ento39registerEmptyLocalizationContextCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerEmptyLocalizationContextChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.LocalizationCheckerEntoGlobals.
    registerEmptyLocalizationContextChecker(mgr);
}


//===----------------------------------------------------------------------===//
// Checker registration.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::ento::registerNonLocalizedStringChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 1287,
 FQN="clang::ento::registerNonLocalizedStringChecker", NM="_ZN5clang4ento33registerNonLocalizedStringCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN5clang4ento33registerNonLocalizedStringCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerNonLocalizedStringChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.LocalizationCheckerEntoGlobals.
    registerNonLocalizedStringChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerPluralMisuseChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 1298,
 FQN="clang::ento::registerPluralMisuseChecker", NM="_ZN5clang4ento27registerPluralMisuseCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN5clang4ento27registerPluralMisuseCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerPluralMisuseChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.LocalizationCheckerEntoGlobals.
    registerPluralMisuseChecker(mgr);
}


/// \brief Get the states that result from widening the loop.
///
/// Widen the loop by invalidating anything that might be modified
/// by the loop body in any iteration.
//<editor-fold defaultstate="collapsed" desc="clang::ento::getWidenedLoopState">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/LoopWidening.cpp", line = 39,
 FQN="clang::ento::getWidenedLoopState", NM="_ZN5clang4ento19getWidenedLoopStateEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextEjPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/LoopWidening.cpp -nm=_ZN5clang4ento19getWidenedLoopStateEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextEjPKNS_4StmtE")
//</editor-fold>
public static IntrusiveRefCntPtr</*const*/ ProgramState> getWidenedLoopState(IntrusiveRefCntPtr</*const*/ ProgramState> PrevState, 
                   /*const*/ LocationContext /*P*/ LCtx, 
                   /*uint*/int BlockCount, /*const*/ Stmt /*P*/ LoopStmt) {
  return /*delegate*/org.clang.staticanalyzer.core.pathsensitive.ento.impl.LoopWideningEntoGlobals.
    getWidenedLoopState(PrevState, 
                   LCtx, 
                   BlockCount, LoopStmt);
}

// end of namespace: clang

// Registers the checker for static analysis.
//<editor-fold defaultstate="collapsed" desc="clang::ento::registerMPIChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp", line = 188,
 FQN="clang::ento::registerMPIChecker", NM="_ZN5clang4ento18registerMPICheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIChecker.cpp -nm=_ZN5clang4ento18registerMPICheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerMPIChecker(final CheckerManager /*&*/ MGR) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.MPICheckerEntoGlobals.
    registerMPIChecker(MGR);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerMacOSKeychainAPIChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp", line = 621,
 FQN="clang::ento::registerMacOSKeychainAPIChecker", NM="_ZN5clang4ento31registerMacOSKeychainAPICheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSKeychainAPIChecker.cpp -nm=_ZN5clang4ento31registerMacOSKeychainAPICheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerMacOSKeychainAPIChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.MacOSKeychainAPICheckerEntoGlobals.
    registerMacOSKeychainAPIChecker(mgr);
}


//===----------------------------------------------------------------------===//
// Registration.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::ento::registerMacOSXAPIChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSXAPIChecker.cpp", line = 126,
 FQN="clang::ento::registerMacOSXAPIChecker", NM="_ZN5clang4ento24registerMacOSXAPICheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MacOSXAPIChecker.cpp -nm=_ZN5clang4ento24registerMacOSXAPICheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerMacOSXAPIChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.MacOSXAPICheckerEntoGlobals.
    registerMacOSXAPIChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerMallocChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2753,
 FQN="clang::ento::registerMallocChecker", NM="_ZN5clang4ento21registerMallocCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN5clang4ento21registerMallocCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerMallocChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.MallocCheckerEntoGlobals.
    registerMallocChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerMismatchedDeallocatorChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2755,
 FQN="clang::ento::registerMismatchedDeallocatorChecker", NM="_ZN5clang4ento36registerMismatchedDeallocatorCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN5clang4ento36registerMismatchedDeallocatorCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerMismatchedDeallocatorChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.MallocCheckerEntoGlobals.
    registerMismatchedDeallocatorChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerNewDeleteChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2754,
 FQN="clang::ento::registerNewDeleteChecker", NM="_ZN5clang4ento24registerNewDeleteCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN5clang4ento24registerNewDeleteCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerNewDeleteChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.MallocCheckerEntoGlobals.
    registerNewDeleteChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerNewDeleteLeaksChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2729,
 FQN="clang::ento::registerNewDeleteLeaksChecker", NM="_ZN5clang4ento29registerNewDeleteLeaksCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN5clang4ento29registerNewDeleteLeaksCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerNewDeleteLeaksChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.MallocCheckerEntoGlobals.
    registerNewDeleteLeaksChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerMallocOverflowSecurityChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 334,
 FQN="clang::ento::registerMallocOverflowSecurityChecker", NM="_ZN5clang4ento37registerMallocOverflowSecurityCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZN5clang4ento37registerMallocOverflowSecurityCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerMallocOverflowSecurityChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.MallocOverflowSecurityCheckerEntoGlobals.
    registerMallocOverflowSecurityChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerMallocSizeofChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 250,
 FQN="clang::ento::registerMallocSizeofChecker", NM="_ZN5clang4ento27registerMallocSizeofCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN5clang4ento27registerMallocSizeofCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerMallocSizeofChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.MallocSizeofCheckerEntoGlobals.
    registerMallocSizeofChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerNSAutoreleasePoolChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSAutoreleasePoolChecker.cpp", line = 78,
 FQN="clang::ento::registerNSAutoreleasePoolChecker", NM="_ZN5clang4ento32registerNSAutoreleasePoolCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSAutoreleasePoolChecker.cpp -nm=_ZN5clang4ento32registerNSAutoreleasePoolCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerNSAutoreleasePoolChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.NSAutoreleasePoolCheckerEntoGlobals.
    registerNSAutoreleasePoolChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerCFErrorChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp", line = 319,
 FQN="clang::ento::registerCFErrorChecker", NM="_ZN5clang4ento22registerCFErrorCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp -nm=_ZN5clang4ento22registerCFErrorCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerCFErrorChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.NSErrorCheckerEntoGlobals.
    registerCFErrorChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerNSErrorChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp", line = 312,
 FQN="clang::ento::registerNSErrorChecker", NM="_ZN5clang4ento22registerNSErrorCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp -nm=_ZN5clang4ento22registerNSErrorCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerNSErrorChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.NSErrorCheckerEntoGlobals.
    registerNSErrorChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerNoReturnFunctionChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NoReturnFunctionChecker.cpp", line = 143,
 FQN="clang::ento::registerNoReturnFunctionChecker", NM="_ZN5clang4ento31registerNoReturnFunctionCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NoReturnFunctionChecker.cpp -nm=_ZN5clang4ento31registerNoReturnFunctionCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerNoReturnFunctionChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.NoReturnFunctionCheckerEntoGlobals.
    registerNoReturnFunctionChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerNonNullParamChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NonNullParamChecker.cpp", line = 221,
 FQN="clang::ento::registerNonNullParamChecker", NM="_ZN5clang4ento27registerNonNullParamCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NonNullParamChecker.cpp -nm=_ZN5clang4ento27registerNonNullParamCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerNonNullParamChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.NonNullParamCheckerEntoGlobals.
    registerNonNullParamChecker(mgr);
}


// The checks are likely to be turned on by default and it is possible to do
// them without tracking any nullability related information. As an optimization
// no nullability information will be tracked when only these two checks are
// enables.
//<editor-fold defaultstate="collapsed" desc="clang::ento::registerNullPassedToNonnullChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 1227,
 FQN="clang::ento::registerNullPassedToNonnullChecker", NM="_ZN5clang4ento34registerNullPassedToNonnullCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN5clang4ento34registerNullPassedToNonnullCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerNullPassedToNonnullChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.NullabilityCheckerEntoGlobals.
    registerNullPassedToNonnullChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerNullReturnedFromNonnullChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 1228,
 FQN="clang::ento::registerNullReturnedFromNonnullChecker", NM="_ZN5clang4ento38registerNullReturnedFromNonnullCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN5clang4ento38registerNullReturnedFromNonnullCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerNullReturnedFromNonnullChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.NullabilityCheckerEntoGlobals.
    registerNullReturnedFromNonnullChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerNullableDereferencedChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 1230,
 FQN="clang::ento::registerNullableDereferencedChecker", NM="_ZN5clang4ento35registerNullableDereferencedCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN5clang4ento35registerNullableDereferencedCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerNullableDereferencedChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.NullabilityCheckerEntoGlobals.
    registerNullableDereferencedChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerNullablePassedToNonnullChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 1231,
 FQN="clang::ento::registerNullablePassedToNonnullChecker", NM="_ZN5clang4ento38registerNullablePassedToNonnullCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN5clang4ento38registerNullablePassedToNonnullCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerNullablePassedToNonnullChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.NullabilityCheckerEntoGlobals.
    registerNullablePassedToNonnullChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerNullableReturnedFromNonnullChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 1232,
 FQN="clang::ento::registerNullableReturnedFromNonnullChecker", NM="_ZN5clang4ento42registerNullableReturnedFromNonnullCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN5clang4ento42registerNullableReturnedFromNonnullCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerNullableReturnedFromNonnullChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.NullabilityCheckerEntoGlobals.
    registerNullableReturnedFromNonnullChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerObjCAtSyncChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCAtSyncChecker.cpp", line = 91,
 FQN="clang::ento::registerObjCAtSyncChecker", NM="_ZN5clang4ento25registerObjCAtSyncCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCAtSyncChecker.cpp -nm=_ZN5clang4ento25registerObjCAtSyncCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerObjCAtSyncChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.ObjCAtSyncCheckerEntoGlobals.
    registerObjCAtSyncChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerObjCContainersASTChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersASTChecker.cpp", line = 172,
 FQN="clang::ento::registerObjCContainersASTChecker", NM="_ZN5clang4ento32registerObjCContainersASTCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersASTChecker.cpp -nm=_ZN5clang4ento32registerObjCContainersASTCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerObjCContainersASTChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.ObjCContainersASTCheckerEntoGlobals.
    registerObjCContainersASTChecker(mgr);
}


/// Register checker.
//<editor-fold defaultstate="collapsed" desc="clang::ento::registerObjCContainersChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp", line = 170,
 FQN="clang::ento::registerObjCContainersChecker", NM="_ZN5clang4ento29registerObjCContainersCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp -nm=_ZN5clang4ento29registerObjCContainersCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerObjCContainersChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.ObjCContainersCheckerEntoGlobals.
    registerObjCContainersChecker(mgr);
}


//===----------------------------------------------------------------------===//
// Check registration.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::ento::registerObjCSuperCallChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp", line = 221,
 FQN="clang::ento::registerObjCSuperCallChecker", NM="_ZN5clang4ento28registerObjCSuperCallCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp -nm=_ZN5clang4ento28registerObjCSuperCallCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerObjCSuperCallChecker(final CheckerManager /*&*/ Mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.ObjCMissingSuperCallCheckerEntoGlobals.
    registerObjCSuperCallChecker(Mgr);
}


//===----------------------------------------------------------------------===//
// Registration.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::ento::registerObjCSelfInitChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp", line = 437,
 FQN="clang::ento::registerObjCSelfInitChecker", NM="_ZN5clang4ento27registerObjCSelfInitCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSelfInitChecker.cpp -nm=_ZN5clang4ento27registerObjCSelfInitCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerObjCSelfInitChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.ObjCSelfInitCheckerEntoGlobals.
    registerObjCSelfInitChecker(mgr);
}


//===----------------------------------------------------------------------===//
// Checker Registration.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::ento::registerObjCSuperDeallocChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp", line = 289,
 FQN="clang::ento::registerObjCSuperDeallocChecker", NM="_ZN5clang4ento31registerObjCSuperDeallocCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCSuperDeallocChecker.cpp -nm=_ZN5clang4ento31registerObjCSuperDeallocCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerObjCSuperDeallocChecker(final CheckerManager /*&*/ Mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.ObjCSuperDeallocCheckerEntoGlobals.
    registerObjCSuperDeallocChecker(Mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerObjCUnusedIvarsChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCUnusedIVarsChecker.cpp", line = 186,
 FQN="clang::ento::registerObjCUnusedIvarsChecker", NM="_ZN5clang4ento30registerObjCUnusedIvarsCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCUnusedIVarsChecker.cpp -nm=_ZN5clang4ento30registerObjCUnusedIvarsCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerObjCUnusedIvarsChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.ObjCUnusedIVarsCheckerEntoGlobals.
    registerObjCUnusedIvarsChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerPaddingChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp", line = 312,
 FQN="clang::ento::registerPaddingChecker", NM="_ZN5clang4ento22registerPaddingCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PaddingChecker.cpp -nm=_ZN5clang4ento22registerPaddingCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerPaddingChecker(final CheckerManager /*&*/ Mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.PaddingCheckerEntoGlobals.
    registerPaddingChecker(Mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::createPlistDiagnosticConsumer">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp", line = 67,
 FQN="clang::ento::createPlistDiagnosticConsumer", NM="_ZN5clang4ento29createPlistDiagnosticConsumerERNS_15AnalyzerOptionsERSt6vectorIPNS0_22PathDiagnosticConsumerESaIS5_EERKSsRKNS_12PreprocessorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp -nm=_ZN5clang4ento29createPlistDiagnosticConsumerERNS_15AnalyzerOptionsERSt6vectorIPNS0_22PathDiagnosticConsumerESaIS5_EERKSsRKNS_12PreprocessorE")
//</editor-fold>
public static void createPlistDiagnosticConsumer(final AnalyzerOptions /*&*/ AnalyzerOpts, 
                             final std.vector<PathDiagnosticConsumer /*P*/ > /*&*/ C, 
                             final /*const*/std.string/*&*/ s, 
                             final /*const*/ Preprocessor /*&*/ PP) {
  /*delegate*/org.clang.staticanalyzer.core.ento.impl.PlistDiagnosticsEntoGlobals.
    createPlistDiagnosticConsumer(AnalyzerOpts, 
                             C, 
                             s, 
                             PP);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::createPlistMultiFileDiagnosticConsumer">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp", line = 75,
 FQN="clang::ento::createPlistMultiFileDiagnosticConsumer", NM="_ZN5clang4ento38createPlistMultiFileDiagnosticConsumerERNS_15AnalyzerOptionsERSt6vectorIPNS0_22PathDiagnosticConsumerESaIS5_EERKSsRKNS_12PreprocessorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp -nm=_ZN5clang4ento38createPlistMultiFileDiagnosticConsumerERNS_15AnalyzerOptionsERSt6vectorIPNS0_22PathDiagnosticConsumerESaIS5_EERKSsRKNS_12PreprocessorE")
//</editor-fold>
public static void createPlistMultiFileDiagnosticConsumer(final AnalyzerOptions /*&*/ AnalyzerOpts, 
                                      final std.vector<PathDiagnosticConsumer /*P*/ > /*&*/ C, 
                                      final /*const*/std.string/*&*/ s, 
                                      final /*const*/ Preprocessor /*&*/ PP) {
  /*delegate*/org.clang.staticanalyzer.core.ento.impl.PlistDiagnosticsEntoGlobals.
    createPlistMultiFileDiagnosticConsumer(AnalyzerOpts, 
                                      C, 
                                      s, 
                                      PP);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerPointerArithChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp", line = 342,
 FQN="clang::ento::registerPointerArithChecker", NM="_ZN5clang4ento27registerPointerArithCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerArithChecker.cpp -nm=_ZN5clang4ento27registerPointerArithCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerPointerArithChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.PointerArithCheckerEntoGlobals.
    registerPointerArithChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerPointerSubChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerSubChecker.cpp", line = 75,
 FQN="clang::ento::registerPointerSubChecker", NM="_ZN5clang4ento25registerPointerSubCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PointerSubChecker.cpp -nm=_ZN5clang4ento25registerPointerSubCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerPointerSubChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.PointerSubCheckerEntoGlobals.
    registerPointerSubChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerPthreadLockChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp", line = 332,
 FQN="clang::ento::registerPthreadLockChecker", NM="_ZN5clang4ento26registerPthreadLockCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/PthreadLockChecker.cpp -nm=_ZN5clang4ento26registerPthreadLockCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerPthreadLockChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.PthreadLockCheckerEntoGlobals.
    registerPthreadLockChecker(mgr);
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::ento::CreateRangeConstraintManager">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 362,
 FQN="clang::ento::CreateRangeConstraintManager", NM="_ZN5clang4ento28CreateRangeConstraintManagerERNS0_19ProgramStateManagerEPNS0_9SubEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN5clang4ento28CreateRangeConstraintManagerERNS0_19ProgramStateManagerEPNS0_9SubEngineE")
//</editor-fold>
public static std.unique_ptr<ConstraintManager> CreateRangeConstraintManager(final ProgramStateManager /*&*/ StMgr, SubEngine /*P*/ Eng) {
  return /*delegate*/org.clang.staticanalyzer.core.pathsensitive.ento.impl.RangeConstraintManagerEntoGlobals.
    CreateRangeConstraintManager(StMgr, Eng);
}


// FIXME: Do we need to pass ProgramStateManager anymore?
// end anonymous namespace

//===----------------------------------------------------------------------===//
// RegionStore creation.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::ento::CreateRegionStoreManager">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 608,
 FQN="clang::ento::CreateRegionStoreManager", NM="_ZN5clang4ento24CreateRegionStoreManagerERNS0_19ProgramStateManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN5clang4ento24CreateRegionStoreManagerERNS0_19ProgramStateManagerE")
//</editor-fold>
public static std.unique_ptr<StoreManager> CreateRegionStoreManager(final ProgramStateManager /*&*/ StMgr) {
  return /*delegate*/org.clang.staticanalyzer.core.pathsensitive.ento.impl.RegionStoreEntoGlobals.
    CreateRegionStoreManager(StMgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::CreateFieldsOnlyRegionStoreManager">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 614,
 FQN="clang::ento::CreateFieldsOnlyRegionStoreManager", NM="_ZN5clang4ento34CreateFieldsOnlyRegionStoreManagerERNS0_19ProgramStateManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN5clang4ento34CreateFieldsOnlyRegionStoreManagerERNS0_19ProgramStateManagerE")
//</editor-fold>
public static std.unique_ptr<StoreManager> CreateFieldsOnlyRegionStoreManager(final ProgramStateManager /*&*/ StMgr) {
  return /*delegate*/org.clang.staticanalyzer.core.pathsensitive.ento.impl.RegionStoreEntoGlobals.
    CreateFieldsOnlyRegionStoreManager(StMgr);
}


//===----------------------------------------------------------------------===//
// Checker registration.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::ento::registerRetainCountChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 3981,
 FQN="clang::ento::registerRetainCountChecker", NM="_ZN5clang4ento26registerRetainCountCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN5clang4ento26registerRetainCountCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerRetainCountChecker(final CheckerManager /*&*/ Mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.RetainCountCheckerEntoGlobals.
    registerRetainCountChecker(Mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerReturnPointerRangeChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnPointerRangeChecker.cpp", line = 90,
 FQN="clang::ento::registerReturnPointerRangeChecker", NM="_ZN5clang4ento33registerReturnPointerRangeCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnPointerRangeChecker.cpp -nm=_ZN5clang4ento33registerReturnPointerRangeCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerReturnPointerRangeChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.ReturnPointerRangeCheckerEntoGlobals.
    registerReturnPointerRangeChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerReturnUndefChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnUndefChecker.cpp", line = 121,
 FQN="clang::ento::registerReturnUndefChecker", NM="_ZN5clang4ento26registerReturnUndefCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnUndefChecker.cpp -nm=_ZN5clang4ento26registerReturnUndefCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerReturnUndefChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.ReturnUndefCheckerEntoGlobals.
    registerReturnUndefChecker(mgr);
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::ento::createSimpleSValBuilder">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp", line = 52,
 FQN="clang::ento::createSimpleSValBuilder", NM="_ZN5clang4ento23createSimpleSValBuilderERN4llvm20BumpPtrAllocatorImplINS1_15MallocAllocatorELj4096ELj4096EEERNS_10ASTContextERNS0_19ProgramStateManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp -nm=_ZN5clang4ento23createSimpleSValBuilderERN4llvm20BumpPtrAllocatorImplINS1_15MallocAllocatorELj4096ELj4096EEERNS_10ASTContextERNS0_19ProgramStateManagerE")
//</editor-fold>
public static SValBuilder /*P*/ createSimpleSValBuilder(final BumpPtrAllocatorImpl /*&*/ alloc, 
                       final ASTContext /*&*/ context, 
                       final ProgramStateManager /*&*/ stateMgr) {
  return /*delegate*/org.clang.staticanalyzer.core.pathsensitive.ento.impl.SimpleSValBuilderEntoGlobals.
    createSimpleSValBuilder(alloc, 
                       context, 
                       stateMgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerSimpleStreamChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp", line = 269,
 FQN="clang::ento::registerSimpleStreamChecker", NM="_ZN5clang4ento27registerSimpleStreamCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/SimpleStreamChecker.cpp -nm=_ZN5clang4ento27registerSimpleStreamCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerSimpleStreamChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.SimpleStreamCheckerEntoGlobals.
    registerSimpleStreamChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerStackAddrEscapeChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp", line = 256,
 FQN="clang::ento::registerStackAddrEscapeChecker", NM="_ZN5clang4ento30registerStackAddrEscapeCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp -nm=_ZN5clang4ento30registerStackAddrEscapeCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerStackAddrEscapeChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.StackAddrEscapeCheckerEntoGlobals.
    registerStackAddrEscapeChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerStreamChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp", line = 422,
 FQN="clang::ento::registerStreamChecker", NM="_ZN5clang4ento21registerStreamCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StreamChecker.cpp -nm=_ZN5clang4ento21registerStreamCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerStreamChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.StreamCheckerEntoGlobals.
    registerStreamChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerTaintTesterChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TaintTesterChecker.cpp", line = 60,
 FQN="clang::ento::registerTaintTesterChecker", NM="_ZN5clang4ento26registerTaintTesterCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TaintTesterChecker.cpp -nm=_ZN5clang4ento26registerTaintTesterCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerTaintTesterChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.TaintTesterCheckerEntoGlobals.
    registerTaintTesterChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerTestAfterDivZeroChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp", line = 263,
 FQN="clang::ento::registerTestAfterDivZeroChecker", NM="_ZN5clang4ento31registerTestAfterDivZeroCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TestAfterDivZeroChecker.cpp -nm=_ZN5clang4ento31registerTestAfterDivZeroCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerTestAfterDivZeroChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.TestAfterDivZeroCheckerEntoGlobals.
    registerTestAfterDivZeroChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerCallDumper">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp", line = 111,
 FQN="clang::ento::registerCallDumper", NM="_ZN5clang4ento18registerCallDumperERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp -nm=_ZN5clang4ento18registerCallDumperERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerCallDumper(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.TraversalCheckerEntoGlobals.
    registerCallDumper(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerTraversalDumper">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp", line = 63,
 FQN="clang::ento::registerTraversalDumper", NM="_ZN5clang4ento23registerTraversalDumperERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp -nm=_ZN5clang4ento23registerTraversalDumperERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerTraversalDumper(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.TraversalCheckerEntoGlobals.
    registerTraversalDumper(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerUndefBranchChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefBranchChecker.cpp", line = 109,
 FQN="clang::ento::registerUndefBranchChecker", NM="_ZN5clang4ento26registerUndefBranchCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefBranchChecker.cpp -nm=_ZN5clang4ento26registerUndefBranchCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerUndefBranchChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.UndefBranchCheckerEntoGlobals.
    registerUndefBranchChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerUndefCapturedBlockVarChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefCapturedBlockVarChecker.cpp", line = 102,
 FQN="clang::ento::registerUndefCapturedBlockVarChecker", NM="_ZN5clang4ento36registerUndefCapturedBlockVarCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefCapturedBlockVarChecker.cpp -nm=_ZN5clang4ento36registerUndefCapturedBlockVarCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerUndefCapturedBlockVarChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.UndefCapturedBlockVarCheckerEntoGlobals.
    registerUndefCapturedBlockVarChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerUndefResultChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefResultChecker.cpp", line = 99,
 FQN="clang::ento::registerUndefResultChecker", NM="_ZN5clang4ento26registerUndefResultCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefResultChecker.cpp -nm=_ZN5clang4ento26registerUndefResultCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerUndefResultChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.UndefResultCheckerEntoGlobals.
    registerUndefResultChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerUndefinedArraySubscriptChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefinedArraySubscriptChecker.cpp", line = 62,
 FQN="clang::ento::registerUndefinedArraySubscriptChecker", NM="_ZN5clang4ento38registerUndefinedArraySubscriptCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefinedArraySubscriptChecker.cpp -nm=_ZN5clang4ento38registerUndefinedArraySubscriptCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerUndefinedArraySubscriptChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.UndefinedArraySubscriptCheckerEntoGlobals.
    registerUndefinedArraySubscriptChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerUndefinedAssignmentChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefinedAssignmentChecker.cpp", line = 94,
 FQN="clang::ento::registerUndefinedAssignmentChecker", NM="_ZN5clang4ento34registerUndefinedAssignmentCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefinedAssignmentChecker.cpp -nm=_ZN5clang4ento34registerUndefinedAssignmentCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerUndefinedAssignmentChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.UndefinedAssignmentCheckerEntoGlobals.
    registerUndefinedAssignmentChecker(mgr);
}


//===----------------------------------------------------------------------===//
// Registration.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::ento::registerUnixAPIChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp", line = 380,
 FQN="clang::ento::registerUnixAPIChecker", NM="_ZN5clang4ento22registerUnixAPICheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp -nm=_ZN5clang4ento22registerUnixAPICheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerUnixAPIChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.UnixAPICheckerEntoGlobals.
    registerUnixAPIChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerUnreachableCodeChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnreachableCodeChecker.cpp", line = 246,
 FQN="clang::ento::registerUnreachableCodeChecker", NM="_ZN5clang4ento30registerUnreachableCodeCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnreachableCodeChecker.cpp -nm=_ZN5clang4ento30registerUnreachableCodeCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerUnreachableCodeChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.UnreachableCodeCheckerEntoGlobals.
    registerUnreachableCodeChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerVLASizeChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VLASizeChecker.cpp", line = 182,
 FQN="clang::ento::registerVLASizeChecker", NM="_ZN5clang4ento22registerVLASizeCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VLASizeChecker.cpp -nm=_ZN5clang4ento22registerVLASizeCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerVLASizeChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.VLASizeCheckerEntoGlobals.
    registerVLASizeChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerVforkChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp", line = 216,
 FQN="clang::ento::registerVforkChecker", NM="_ZN5clang4ento20registerVforkCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp -nm=_ZN5clang4ento20registerVforkCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerVforkChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.VforkCheckerEntoGlobals.
    registerVforkChecker(mgr);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerVirtualCallChecker">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp", line = 244,
 FQN="clang::ento::registerVirtualCallChecker", NM="_ZN5clang4ento26registerVirtualCallCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp -nm=_ZN5clang4ento26registerVirtualCallCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerVirtualCallChecker(final CheckerManager /*&*/ mgr) {
  /*delegate*/org.clang.staticanalyzer.checkers.ento.impl.VirtualCallCheckerEntoGlobals.
    registerVirtualCallChecker(mgr);
}

} // END OF class EntoGlobals
