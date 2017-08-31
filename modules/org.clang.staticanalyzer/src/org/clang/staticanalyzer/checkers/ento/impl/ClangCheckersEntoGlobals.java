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
package org.clang.staticanalyzer.checkers.ento.impl;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.ento.*;


//<editor-fold defaultstate="collapsed" desc="static type ClangCheckersEntoGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ClangCheckers.cpp -nm=_ZN5clang4ento23registerBuiltinCheckersERNS0_15CheckerRegistryE; -static-type=ClangCheckersEntoGlobals -package=org.clang.staticanalyzer.checkers.ento.impl")
//</editor-fold>
public final class ClangCheckersEntoGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerBuiltinCheckers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ClangCheckers.cpp", line = 26,
 FQN="clang::ento::registerBuiltinCheckers", NM="_ZN5clang4ento23registerBuiltinCheckersERNS0_15CheckerRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ClangCheckers.cpp -nm=_ZN5clang4ento23registerBuiltinCheckersERNS0_15CheckerRegistryE")
//</editor-fold>
public static void registerBuiltinCheckers(final CheckerRegistry /*&*/ registry) {
  registry.addChecker(/*FuncRef*/AnalyzerStatsCheckerEntoGlobals::registerAnalyzerStatsChecker, new StringRef(/*KEEP_STR*/"debug.Stats"), new StringRef(/*KEEP_STR*/"Emit warnings with analyzer statistics"));
  registry.addChecker(/*FuncRef*/ArrayBoundCheckerEntoGlobals::registerArrayBoundChecker, new StringRef(/*KEEP_STR*/"alpha.security.ArrayBound"), new StringRef(/*KEEP_STR*/"Warn about buffer overflows (older checker)"));
  registry.addChecker(/*FuncRef*/ArrayBoundCheckerV2EntoGlobals::registerArrayBoundCheckerV2, new StringRef(/*KEEP_STR*/"alpha.security.ArrayBoundV2"), new StringRef(/*KEEP_STR*/"Warn about buffer overflows (newer checker)"));
  registry.addChecker(/*FuncRef*/BoolAssignmentCheckerEntoGlobals::registerBoolAssignmentChecker, new StringRef(/*KEEP_STR*/"alpha.core.BoolAssignment"), new StringRef(/*KEEP_STR*/"Warn about assigning non-{0,1} values to Boolean variables"));
  registry.addChecker(/*FuncRef*/DebugCheckersEntoGlobals::registerBugHashDumper, new StringRef(/*KEEP_STR*/"debug.DumpBugHash"), new StringRef(/*KEEP_STR*/"Dump the bug hash for all statements."));
  registry.addChecker(/*FuncRef*/BuiltinFunctionCheckerEntoGlobals::registerBuiltinFunctionChecker, new StringRef(/*KEEP_STR*/"core.builtin.BuiltinFunctions"), new StringRef(/*KEEP_STR*/"Evaluate compiler builtin functions (e.g., alloca())"));
  registry.addChecker(/*FuncRef*/NSErrorCheckerEntoGlobals::registerCFErrorChecker, new StringRef(/*KEEP_STR*/"osx.coreFoundation.CFError"), new StringRef(/*KEEP_STR*/"Check usage of CFErrorRef* parameters"));
  registry.addChecker(/*FuncRef*/DebugCheckersEntoGlobals::registerCFGDumper, new StringRef(/*KEEP_STR*/"debug.DumpCFG"), new StringRef(/*KEEP_STR*/"Display Control-Flow Graphs"));
  registry.addChecker(/*FuncRef*/DebugCheckersEntoGlobals::registerCFGViewer, new StringRef(/*KEEP_STR*/"debug.ViewCFG"), new StringRef(/*KEEP_STR*/"View Control-Flow Graphs using GraphViz"));
  registry.addChecker(/*FuncRef*/BasicObjCFoundationChecksEntoGlobals::registerCFNumberCreateChecker, new StringRef(/*KEEP_STR*/"osx.coreFoundation.CFNumber"), new StringRef(/*KEEP_STR*/"Check for proper uses of CFNumberCreate"));
  registry.addChecker(/*FuncRef*/BasicObjCFoundationChecksEntoGlobals::registerCFRetainReleaseChecker, new StringRef(/*KEEP_STR*/"osx.coreFoundation.CFRetainRelease"), new StringRef(/*KEEP_STR*/"Check for null arguments to CFRetain/CFRelease/CFMakeCollectable"));
  registry.addChecker(/*FuncRef*/CStringCheckerEntoGlobals::registerCStringBufferOverlap, new StringRef(/*KEEP_STR*/"alpha.unix.cstring.BufferOverlap"), new StringRef(/*KEEP_STR*/"Checks for overlap in two buffer arguments"));
  registry.addChecker(/*FuncRef*/CStringCheckerEntoGlobals::registerCStringNotNullTerm, new StringRef(/*KEEP_STR*/"alpha.unix.cstring.NotNullTerminated"), new StringRef(/*KEEP_STR*/"Check for arguments which are not null-terminating strings"));
  registry.addChecker(/*FuncRef*/CStringCheckerEntoGlobals::registerCStringNullArg, new StringRef(/*KEEP_STR*/"unix.cstring.NullArg"), new StringRef(/*KEEP_STR*/"Check for null pointers being passed as arguments to C string functions"));
  registry.addChecker(/*FuncRef*/CStringCheckerEntoGlobals::registerCStringOutOfBounds, new StringRef(/*KEEP_STR*/"alpha.unix.cstring.OutOfBounds"), new StringRef(/*KEEP_STR*/"Check for out-of-bounds access in string functions"));
  registry.addChecker(/*FuncRef*/CStringSyntaxCheckerEntoGlobals::registerCStringSyntaxChecker, new StringRef(/*KEEP_STR*/"unix.cstring.BadSizeArg"), new StringRef(/*KEEP_STR*/"Check the size argument passed into C string functions for common erroneous patterns"));
  registry.addChecker(/*FuncRef*/CallAndMessageCheckerEntoGlobals::registerCallAndMessageChecker, new StringRef(/*KEEP_STR*/"core.CallAndMessage"), new StringRef(/*KEEP_STR*/"Check for logical errors for function calls and Objective-C message expressions (e.g., uninitialized arguments, null function pointers)"));
  registry.addChecker(/*FuncRef*/CallAndMessageCheckerEntoGlobals::registerCallAndMessageUnInitRefArg, new StringRef(/*KEEP_STR*/"alpha.core.CallAndMessageUnInitRefArg"), new StringRef(/*KEEP_STR*/"Check for logical errors for function calls and Objective-C message expressions (e.g., uninitialized arguments, null function pointers, and pointer to undefined variables)"));
  registry.addChecker(/*FuncRef*/TraversalCheckerEntoGlobals::registerCallDumper, new StringRef(/*KEEP_STR*/"debug.DumpCalls"), new StringRef(/*KEEP_STR*/"Print calls as they are traversed by the engine"));
  registry.addChecker(/*FuncRef*/DebugCheckersEntoGlobals::registerCallGraphDumper, new StringRef(/*KEEP_STR*/"debug.DumpCallGraph"), new StringRef(/*KEEP_STR*/"Display Call Graph"));
  registry.addChecker(/*FuncRef*/DebugCheckersEntoGlobals::registerCallGraphViewer, new StringRef(/*KEEP_STR*/"debug.ViewCallGraph"), new StringRef(/*KEEP_STR*/"View Call Graph using GraphViz"));
  registry.addChecker(/*FuncRef*/CastSizeCheckerEntoGlobals::registerCastSizeChecker, new StringRef(/*KEEP_STR*/"alpha.core.CastSize"), new StringRef(/*KEEP_STR*/"Check when casting a malloc'ed type T, whether the size is a multiple of the size of T"));
  registry.addChecker(/*FuncRef*/CastToStructCheckerEntoGlobals::registerCastToStructChecker, new StringRef(/*KEEP_STR*/"alpha.core.CastToStruct"), new StringRef(/*KEEP_STR*/"Check for cast from non-struct pointer to struct pointer"));
  registry.addChecker(/*FuncRef*/ChrootCheckerEntoGlobals::registerChrootChecker, new StringRef(/*KEEP_STR*/"alpha.unix.Chroot"), new StringRef(/*KEEP_STR*/"Check improper use of chroot"));
  registry.addChecker(/*FuncRef*/BasicObjCFoundationChecksEntoGlobals::registerClassReleaseChecker, new StringRef(/*KEEP_STR*/"osx.cocoa.ClassRelease"), new StringRef(/*KEEP_STR*/"Check for sending 'retain', 'release', or 'autorelease' directly to a Class"));
  registry.addChecker(/*FuncRef*/DebugCheckersEntoGlobals::registerConfigDumper, new StringRef(/*KEEP_STR*/"debug.ConfigDumper"), new StringRef(/*KEEP_STR*/"Dump config table"));
  registry.addChecker(/*FuncRef*/DeadStoresCheckerEntoGlobals::registerDeadStoresChecker, new StringRef(/*KEEP_STR*/"deadcode.DeadStores"), new StringRef(/*KEEP_STR*/"Check for values stored to variables that are never read afterwards"));
  registry.addChecker(/*FuncRef*/DereferenceCheckerEntoGlobals::registerDereferenceChecker, new StringRef(/*KEEP_STR*/"core.NullDereference"), new StringRef(/*KEEP_STR*/"Check for dereferences of null pointers"));
  registry.addChecker(/*FuncRef*/DirectIvarAssignmentEntoGlobals::registerDirectIvarAssignment, new StringRef(/*KEEP_STR*/"alpha.osx.cocoa.DirectIvarAssignment"), new StringRef(/*KEEP_STR*/"Check for direct assignments to instance variables"));
  registry.addChecker(/*FuncRef*/DirectIvarAssignmentEntoGlobals::registerDirectIvarAssignmentForAnnotatedFunctions, new StringRef(/*KEEP_STR*/"alpha.osx.cocoa.DirectIvarAssignmentForAnnotatedFunctions"), new StringRef(/*KEEP_STR*/"Check for direct assignments to instance variables in the methods annotated with objc_no_direct_instance_variable_assignment"));
  registry.addChecker(/*FuncRef*/DivZeroCheckerEntoGlobals::registerDivZeroChecker, new StringRef(/*KEEP_STR*/"core.DivideZero"), new StringRef(/*KEEP_STR*/"Check for division by zero"));
  registry.addChecker(/*FuncRef*/DebugCheckersEntoGlobals::registerDominatorsTreeDumper, new StringRef(/*KEEP_STR*/"debug.DumpDominators"), new StringRef(/*KEEP_STR*/"Print the dominance tree for a given CFG"));
  registry.addChecker(/*FuncRef*/DynamicTypeCheckerEntoGlobals::registerDynamicTypeChecker, new StringRef(/*KEEP_STR*/"alpha.core.DynamicTypeChecker"), new StringRef(/*KEEP_STR*/"Check for cases where the dynamic and the static type of an object are unrelated."));
  registry.addChecker(/*FuncRef*/DynamicTypePropagationEntoGlobals::registerDynamicTypePropagation, new StringRef(/*KEEP_STR*/"core.DynamicTypePropagation"), new StringRef(/*KEEP_STR*/"Generate dynamic type information"));
  registry.addChecker(/*FuncRef*/LocalizationCheckerEntoGlobals::registerEmptyLocalizationContextChecker, new StringRef(/*KEEP_STR*/"optin.osx.cocoa.localizability.EmptyLocalizationContextChecker"), new StringRef(/*KEEP_STR*/"Check that NSLocalizedString macros include a comment for context"));
  registry.addChecker(/*FuncRef*/DebugCheckersEntoGlobals::registerExplodedGraphViewer, new StringRef(/*KEEP_STR*/"debug.ViewExplodedGraph"), new StringRef(/*KEEP_STR*/"View Exploded Graphs using GraphViz"));
  registry.addChecker(/*FuncRef*/ExprInspectionCheckerEntoGlobals::registerExprInspectionChecker, new StringRef(/*KEEP_STR*/"debug.ExprInspection"), new StringRef(/*KEEP_STR*/"Check the analyzer's understanding of expressions"));
  registry.addChecker(/*FuncRef*/FixedAddressCheckerEntoGlobals::registerFixedAddressChecker, new StringRef(/*KEEP_STR*/"alpha.core.FixedAddr"), new StringRef(/*KEEP_STR*/"Check for assignment of a fixed address to a pointer"));
  registry.addChecker(/*FuncRef*/CheckSecuritySyntaxOnlyEntoGlobals::registerFloatLoopCounter, new StringRef(/*KEEP_STR*/"security.FloatLoopCounter"), new StringRef(/*KEEP_STR*/"Warn on using a floating point value as a loop counter (CERT: FLP30-C, FLP30-CPP)"));
  registry.addChecker(/*FuncRef*/GenericTaintCheckerEntoGlobals::registerGenericTaintChecker, new StringRef(/*KEEP_STR*/"alpha.security.taint.TaintPropagation"), new StringRef(/*KEEP_STR*/"Generate taint information used by other checkers"));
  registry.addChecker(/*FuncRef*/IdenticalExprCheckerEntoGlobals::registerIdenticalExprChecker, new StringRef(/*KEEP_STR*/"alpha.core.IdenticalExpr"), new StringRef(/*KEEP_STR*/"Warn about unintended use of identical expressions in operators"));
  registry.addChecker(/*FuncRef*/IvarInvalidationCheckerEntoGlobals::registerInstanceVariableInvalidation, new StringRef(/*KEEP_STR*/"alpha.osx.cocoa.InstanceVariableInvalidation"), new StringRef(/*KEEP_STR*/"Check that the invalidatable instance variables are invalidated in the methods annotated with objc_instance_variable_invalidator"));
  registry.addChecker(/*FuncRef*/LLVMConventionsCheckerEntoGlobals::registerLLVMConventionsChecker, new StringRef(/*KEEP_STR*/"llvm.Conventions"), new StringRef(/*KEEP_STR*/"Check code for LLVM codebase conventions"));
  registry.addChecker(/*FuncRef*/DebugCheckersEntoGlobals::registerLiveVariablesDumper, new StringRef(/*KEEP_STR*/"debug.DumpLiveVars"), new StringRef(/*KEEP_STR*/"Print results of live variable analysis"));
  registry.addChecker(/*FuncRef*/MPICheckerEntoGlobals::registerMPIChecker, new StringRef(/*KEEP_STR*/"optin.mpi.MPI-Checker"), new StringRef(/*KEEP_STR*/"Checks MPI code"));
  registry.addChecker(/*FuncRef*/MacOSKeychainAPICheckerEntoGlobals::registerMacOSKeychainAPIChecker, new StringRef(/*KEEP_STR*/"osx.SecKeychainAPI"), new StringRef(/*KEEP_STR*/"Check for proper uses of Secure Keychain APIs"));
  registry.addChecker(/*FuncRef*/MacOSXAPICheckerEntoGlobals::registerMacOSXAPIChecker, new StringRef(/*KEEP_STR*/"osx.API"), new StringRef(/*KEEP_STR*/"Check for proper uses of various Apple APIs"));
  registry.addChecker(/*FuncRef*/MallocCheckerEntoGlobals::registerMallocChecker, new StringRef(/*KEEP_STR*/"unix.Malloc"), new StringRef(/*KEEP_STR*/"Check for memory leaks, double free, and use-after-free problems. Traces memory managed by malloc()/free()."));
  registry.addChecker(/*FuncRef*/MallocOverflowSecurityCheckerEntoGlobals::registerMallocOverflowSecurityChecker, new StringRef(/*KEEP_STR*/"alpha.security.MallocOverflow"), new StringRef(/*KEEP_STR*/"Check for overflows in the arguments to malloc()"));
  registry.addChecker(/*FuncRef*/MallocSizeofCheckerEntoGlobals::registerMallocSizeofChecker, new StringRef(/*KEEP_STR*/"unix.MallocSizeof"), new StringRef(/*KEEP_STR*/"Check for dubious malloc arguments involving sizeof"));
  registry.addChecker(/*FuncRef*/MallocCheckerEntoGlobals::registerMismatchedDeallocatorChecker, new StringRef(/*KEEP_STR*/"unix.MismatchedDeallocator"), new StringRef(/*KEEP_STR*/"Check for mismatched deallocators."));
  registry.addChecker(/*FuncRef*/IvarInvalidationCheckerEntoGlobals::registerMissingInvalidationMethod, new StringRef(/*KEEP_STR*/"alpha.osx.cocoa.MissingInvalidationMethod"), new StringRef(/*KEEP_STR*/"Check that the invalidation methods are present in classes that contain invalidatable instance variables"));
  registry.addChecker(/*FuncRef*/NSAutoreleasePoolCheckerEntoGlobals::registerNSAutoreleasePoolChecker, new StringRef(/*KEEP_STR*/"osx.cocoa.NSAutoreleasePool"), new StringRef(/*KEEP_STR*/"Warn for suboptimal uses of NSAutoreleasePool in Objective-C GC mode"));
  registry.addChecker(/*FuncRef*/NSErrorCheckerEntoGlobals::registerNSErrorChecker, new StringRef(/*KEEP_STR*/"osx.cocoa.NSError"), new StringRef(/*KEEP_STR*/"Check usage of NSError** parameters"));
  registry.addChecker(/*FuncRef*/MallocCheckerEntoGlobals::registerNewDeleteChecker, new StringRef(/*KEEP_STR*/"cplusplus.NewDelete"), new StringRef(/*KEEP_STR*/"Check for double-free and use-after-free problems. Traces memory managed by new/delete."));
  registry.addChecker(/*FuncRef*/MallocCheckerEntoGlobals::registerNewDeleteLeaksChecker, new StringRef(/*KEEP_STR*/"cplusplus.NewDeleteLeaks"), new StringRef(/*KEEP_STR*/"Check for memory leaks. Traces memory managed by new/delete."));
  registry.addChecker(/*FuncRef*/BasicObjCFoundationChecksEntoGlobals::registerNilArgChecker, new StringRef(/*KEEP_STR*/"osx.cocoa.NilArg"), new StringRef(/*KEEP_STR*/"Check for prohibited nil arguments to ObjC method calls"));
  registry.addChecker(/*FuncRef*/NoReturnFunctionCheckerEntoGlobals::registerNoReturnFunctionChecker, new StringRef(/*KEEP_STR*/"core.builtin.NoReturnFunctions"), new StringRef(/*KEEP_STR*/"Evaluate \"panic\" functions that are known to not return to the caller"));
  registry.addChecker(/*FuncRef*/LocalizationCheckerEntoGlobals::registerNonLocalizedStringChecker, new StringRef(/*KEEP_STR*/"optin.osx.cocoa.localizability.NonLocalizedStringChecker"), new StringRef(/*KEEP_STR*/"Warns about uses of non-localized NSStrings passed to UI methods expecting localized NSStrings"));
  registry.addChecker(/*FuncRef*/NonNullParamCheckerEntoGlobals::registerNonNullParamChecker, new StringRef(/*KEEP_STR*/"core.NonNullParamChecker"), new StringRef(/*KEEP_STR*/"Check for null pointers passed as arguments to a function whose arguments are references or marked with the 'nonnull' attribute"));
  registry.addChecker(/*FuncRef*/NullabilityCheckerEntoGlobals::registerNullPassedToNonnullChecker, new StringRef(/*KEEP_STR*/"nullability.NullPassedToNonnull"), new StringRef(/*KEEP_STR*/"Warns when a null pointer is passed to a pointer which has a _Nonnull type."));
  registry.addChecker(/*FuncRef*/NullabilityCheckerEntoGlobals::registerNullReturnedFromNonnullChecker, new StringRef(/*KEEP_STR*/"nullability.NullReturnedFromNonnull"), new StringRef(/*KEEP_STR*/"Warns when a null pointer is returned from a function that has _Nonnull return type."));
  registry.addChecker(/*FuncRef*/NullabilityCheckerEntoGlobals::registerNullableDereferencedChecker, new StringRef(/*KEEP_STR*/"nullability.NullableDereferenced"), new StringRef(/*KEEP_STR*/"Warns when a nullable pointer is dereferenced."));
  registry.addChecker(/*FuncRef*/NullabilityCheckerEntoGlobals::registerNullablePassedToNonnullChecker, new StringRef(/*KEEP_STR*/"nullability.NullablePassedToNonnull"), new StringRef(/*KEEP_STR*/"Warns when a nullable pointer is passed to a pointer which has a _Nonnull type."));
  registry.addChecker(/*FuncRef*/NullabilityCheckerEntoGlobals::registerNullableReturnedFromNonnullChecker, new StringRef(/*KEEP_STR*/"nullability.NullablePassedToNonnull"), new StringRef(/*KEEP_STR*/"Warns when a nullable pointer is returned from a function that has _Nonnull return type."));
  registry.addChecker(/*FuncRef*/ObjCAtSyncCheckerEntoGlobals::registerObjCAtSyncChecker, new StringRef(/*KEEP_STR*/"osx.cocoa.AtSync"), new StringRef(/*KEEP_STR*/"Check for nil pointers used as mutexes for @synchronized"));
  registry.addChecker(/*FuncRef*/ObjCContainersASTCheckerEntoGlobals::registerObjCContainersASTChecker, new StringRef(/*KEEP_STR*/"osx.coreFoundation.containers.PointerSizedValues"), new StringRef(/*KEEP_STR*/"Warns if 'CFArray', 'CFDictionary', 'CFSet' are created with non-pointer-size values"));
  registry.addChecker(/*FuncRef*/ObjCContainersCheckerEntoGlobals::registerObjCContainersChecker, new StringRef(/*KEEP_STR*/"osx.coreFoundation.containers.OutOfBounds"), new StringRef(/*KEEP_STR*/"Checks for index out-of-bounds when using 'CFArray' API"));
  registry.addChecker(/*FuncRef*/CheckObjCDeallocEntoGlobals::registerObjCDeallocChecker, new StringRef(/*KEEP_STR*/"osx.cocoa.Dealloc"), new StringRef(/*KEEP_STR*/"Warn about Objective-C classes that lack a correct implementation of -dealloc"));
  registry.addChecker(/*FuncRef*/DynamicTypePropagationEntoGlobals::registerObjCGenericsChecker, new StringRef(/*KEEP_STR*/"osx.cocoa.ObjCGenerics"), new StringRef(/*KEEP_STR*/"Check for type errors when using Objective-C generics"));
  registry.addChecker(/*FuncRef*/BasicObjCFoundationChecksEntoGlobals::registerObjCLoopChecker, new StringRef(/*KEEP_STR*/"osx.cocoa.Loops"), new StringRef(/*KEEP_STR*/"Improved modeling of loops using Cocoa collection types"));
  registry.addChecker(/*FuncRef*/CheckObjCInstMethSignatureEntoGlobals::registerObjCMethSigsChecker, new StringRef(/*KEEP_STR*/"osx.cocoa.IncompatibleMethodTypes"), new StringRef(/*KEEP_STR*/"Warn about Objective-C method signatures with type incompatibilities"));
  registry.addChecker(/*FuncRef*/BasicObjCFoundationChecksEntoGlobals::registerObjCNonNilReturnValueChecker, new StringRef(/*KEEP_STR*/"osx.cocoa.NonNilReturnValue"), new StringRef(/*KEEP_STR*/"Model the APIs that are guaranteed to return a non-nil value"));
  registry.addChecker(/*FuncRef*/ObjCSelfInitCheckerEntoGlobals::registerObjCSelfInitChecker, new StringRef(/*KEEP_STR*/"osx.cocoa.SelfInit"), new StringRef(/*KEEP_STR*/"Check that 'self' is properly initialized inside an initializer method"));
  registry.addChecker(/*FuncRef*/ObjCMissingSuperCallCheckerEntoGlobals::registerObjCSuperCallChecker, new StringRef(/*KEEP_STR*/"osx.cocoa.MissingSuperCall"), new StringRef(/*KEEP_STR*/"Warn about Objective-C methods that lack a necessary call to super"));
  registry.addChecker(/*FuncRef*/ObjCSuperDeallocCheckerEntoGlobals::registerObjCSuperDeallocChecker, new StringRef(/*KEEP_STR*/"osx.cocoa.SuperDealloc"), new StringRef(/*KEEP_STR*/"Warn about improper use of '[super dealloc]' in Objective-C"));
  registry.addChecker(/*FuncRef*/ObjCUnusedIVarsCheckerEntoGlobals::registerObjCUnusedIvarsChecker, new StringRef(/*KEEP_STR*/"osx.cocoa.UnusedIvars"), new StringRef(/*KEEP_STR*/"Warn about private ivars that are never used"));
  registry.addChecker(/*FuncRef*/PaddingCheckerEntoGlobals::registerPaddingChecker, new StringRef(/*KEEP_STR*/"optin.performance.Padding"), new StringRef(/*KEEP_STR*/"Check for excessively padded structs."));
  registry.addChecker(/*FuncRef*/LocalizationCheckerEntoGlobals::registerPluralMisuseChecker, new StringRef(/*KEEP_STR*/"alpha.osx.cocoa.localizability.PluralMisuseChecker"), new StringRef(/*KEEP_STR*/"Warns against using one vs. many plural pattern in code when generating localized strings."));
  registry.addChecker(/*FuncRef*/PointerArithCheckerEntoGlobals::registerPointerArithChecker, new StringRef(/*KEEP_STR*/"alpha.core.PointerArithm"), new StringRef(/*KEEP_STR*/"Check for pointer arithmetic on locations other than array elements"));
  registry.addChecker(/*FuncRef*/PointerSubCheckerEntoGlobals::registerPointerSubChecker, new StringRef(/*KEEP_STR*/"alpha.core.PointerSub"), new StringRef(/*KEEP_STR*/"Check for pointer subtractions on two pointers pointing to different memory chunks"));
  registry.addChecker(/*FuncRef*/PthreadLockCheckerEntoGlobals::registerPthreadLockChecker, new StringRef(/*KEEP_STR*/"alpha.unix.PthreadLock"), new StringRef(/*KEEP_STR*/"Simple lock -> unlock checker"));
  registry.addChecker(/*FuncRef*/RetainCountCheckerEntoGlobals::registerRetainCountChecker, new StringRef(/*KEEP_STR*/"osx.cocoa.RetainCount"), new StringRef(/*KEEP_STR*/"Check for leaks and improper reference count management"));
  registry.addChecker(/*FuncRef*/ReturnPointerRangeCheckerEntoGlobals::registerReturnPointerRangeChecker, new StringRef(/*KEEP_STR*/"alpha.security.ReturnPtrRange"), new StringRef(/*KEEP_STR*/"Check for an out-of-bound pointer being returned to callers"));
  registry.addChecker(/*FuncRef*/ReturnUndefCheckerEntoGlobals::registerReturnUndefChecker, new StringRef(/*KEEP_STR*/"core.uninitialized.UndefReturn"), new StringRef(/*KEEP_STR*/"Check for uninitialized values being returned to the caller"));
  registry.addChecker(/*FuncRef*/SimpleStreamCheckerEntoGlobals::registerSimpleStreamChecker, new StringRef(/*KEEP_STR*/"alpha.unix.SimpleStream"), new StringRef(/*KEEP_STR*/"Check for misuses of stream APIs"));
  registry.addChecker(/*FuncRef*/CheckSizeofPointerEntoGlobals::registerSizeofPointerChecker, new StringRef(/*KEEP_STR*/"alpha.core.SizeofPtr"), new StringRef(/*KEEP_STR*/"Warn about unintended use of sizeof() on pointer expressions"));
  registry.addChecker(/*FuncRef*/StackAddrEscapeCheckerEntoGlobals::registerStackAddrEscapeChecker, new StringRef(/*KEEP_STR*/"core.StackAddressEscape"), new StringRef(/*KEEP_STR*/"Check that addresses to stack memory do not escape the function"));
  registry.addChecker(/*FuncRef*/StreamCheckerEntoGlobals::registerStreamChecker, new StringRef(/*KEEP_STR*/"alpha.unix.Stream"), new StringRef(/*KEEP_STR*/"Check stream handling functions"));
  registry.addChecker(/*FuncRef*/TaintTesterCheckerEntoGlobals::registerTaintTesterChecker, new StringRef(/*KEEP_STR*/"debug.TaintTest"), new StringRef(/*KEEP_STR*/"Mark tainted symbols as such."));
  registry.addChecker(/*FuncRef*/TestAfterDivZeroCheckerEntoGlobals::registerTestAfterDivZeroChecker, new StringRef(/*KEEP_STR*/"alpha.core.TestAfterDivZero"), new StringRef(/*KEEP_STR*/"Check for division by variable that is later compared against 0. Either the comparison is useless or there is division by zero."));
  registry.addChecker(/*FuncRef*/TraversalCheckerEntoGlobals::registerTraversalDumper, new StringRef(/*KEEP_STR*/"debug.DumpTraversal"), new StringRef(/*KEEP_STR*/"Print branch conditions as they are traversed by the engine"));
  registry.addChecker(/*FuncRef*/CheckSecuritySyntaxOnlyEntoGlobals::registerUncheckedReturn, new StringRef(/*KEEP_STR*/"security.insecureAPI.UncheckedReturn"), new StringRef(/*KEEP_STR*/"Warn on uses of functions whose return values must be always checked"));
  registry.addChecker(/*FuncRef*/UndefBranchCheckerEntoGlobals::registerUndefBranchChecker, new StringRef(/*KEEP_STR*/"core.uninitialized.Branch"), new StringRef(/*KEEP_STR*/"Check for uninitialized values used as branch conditions"));
  registry.addChecker(/*FuncRef*/UndefCapturedBlockVarCheckerEntoGlobals::registerUndefCapturedBlockVarChecker, new StringRef(/*KEEP_STR*/"core.uninitialized.CapturedBlockVariable"), new StringRef(/*KEEP_STR*/"Check for blocks that capture uninitialized values"));
  registry.addChecker(/*FuncRef*/UndefResultCheckerEntoGlobals::registerUndefResultChecker, new StringRef(/*KEEP_STR*/"core.UndefinedBinaryOperatorResult"), new StringRef(/*KEEP_STR*/"Check for undefined results of binary operators"));
  registry.addChecker(/*FuncRef*/UndefinedArraySubscriptCheckerEntoGlobals::registerUndefinedArraySubscriptChecker, new StringRef(/*KEEP_STR*/"core.uninitialized.ArraySubscript"), new StringRef(/*KEEP_STR*/"Check for uninitialized values used as array subscripts"));
  registry.addChecker(/*FuncRef*/UndefinedAssignmentCheckerEntoGlobals::registerUndefinedAssignmentChecker, new StringRef(/*KEEP_STR*/"core.uninitialized.Assign"), new StringRef(/*KEEP_STR*/"Check for assigning uninitialized values"));
  registry.addChecker(/*FuncRef*/UnixAPICheckerEntoGlobals::registerUnixAPIChecker, new StringRef(/*KEEP_STR*/"unix.API"), new StringRef(/*KEEP_STR*/"Check calls to various UNIX/Posix functions"));
  registry.addChecker(/*FuncRef*/UnreachableCodeCheckerEntoGlobals::registerUnreachableCodeChecker, new StringRef(/*KEEP_STR*/"alpha.deadcode.UnreachableCode"), new StringRef(/*KEEP_STR*/"Check unreachable code"));
  registry.addChecker(/*FuncRef*/VLASizeCheckerEntoGlobals::registerVLASizeChecker, new StringRef(/*KEEP_STR*/"core.VLASize"), new StringRef(/*KEEP_STR*/"Check for declarations of VLA of undefined or zero size"));
  registry.addChecker(/*FuncRef*/BasicObjCFoundationChecksEntoGlobals::registerVariadicMethodTypeChecker, new StringRef(/*KEEP_STR*/"osx.cocoa.VariadicMethodTypes"), new StringRef(/*KEEP_STR*/"Check for passing non-Objective-C types to variadic collection initialization methods that expect only Objective-C types"));
  registry.addChecker(/*FuncRef*/VforkCheckerEntoGlobals::registerVforkChecker, new StringRef(/*KEEP_STR*/"unix.Vfork"), new StringRef(/*KEEP_STR*/"Check for proper usage of vfork"));
  registry.addChecker(/*FuncRef*/VirtualCallCheckerEntoGlobals::registerVirtualCallChecker, new StringRef(/*KEEP_STR*/"alpha.cplusplus.VirtualCall"), new StringRef(/*KEEP_STR*/"Check virtual function calls during construction or destruction"));
  registry.addChecker(/*FuncRef*/CheckSecuritySyntaxOnlyEntoGlobals::registergetpw, new StringRef(/*KEEP_STR*/"security.insecureAPI.getpw"), new StringRef(/*KEEP_STR*/"Warn on uses of the 'getpw' function"));
  registry.addChecker(/*FuncRef*/CheckSecuritySyntaxOnlyEntoGlobals::registergets, new StringRef(/*KEEP_STR*/"security.insecureAPI.gets"), new StringRef(/*KEEP_STR*/"Warn on uses of the 'gets' function"));
  registry.addChecker(/*FuncRef*/CheckSecuritySyntaxOnlyEntoGlobals::registermkstemp, new StringRef(/*KEEP_STR*/"security.insecureAPI.mkstemp"), new StringRef(/*KEEP_STR*/"Warn when 'mkstemp' is passed fewer than 6 X's in the format string"));
  registry.addChecker(/*FuncRef*/CheckSecuritySyntaxOnlyEntoGlobals::registermktemp, new StringRef(/*KEEP_STR*/"security.insecureAPI.mktemp"), new StringRef(/*KEEP_STR*/"Warn on uses of the 'mktemp' function"));
  registry.addChecker(/*FuncRef*/CheckSecuritySyntaxOnlyEntoGlobals::registerrand, new StringRef(/*KEEP_STR*/"security.insecureAPI.rand"), new StringRef(/*KEEP_STR*/"Warn on uses of the 'rand', 'random', and related functions"));
  registry.addChecker(/*FuncRef*/CheckSecuritySyntaxOnlyEntoGlobals::registerstrcpy, new StringRef(/*KEEP_STR*/"security.insecureAPI.strcpy"), new StringRef(/*KEEP_STR*/"Warn on uses of the 'strcpy' and 'strcat' functions"));
  registry.addChecker(/*FuncRef*/CheckSecuritySyntaxOnlyEntoGlobals::registervfork, new StringRef(/*KEEP_STR*/"security.insecureAPI.vfork"), new StringRef(/*KEEP_STR*/"Warn on uses of the 'vfork' function"));
}

} // END OF class ClangCheckersEntoGlobals
