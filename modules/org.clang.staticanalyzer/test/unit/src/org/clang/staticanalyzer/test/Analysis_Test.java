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

package org.clang.staticanalyzer.test;

import org.clang.tools.driver.test.DriverTestFileBase;
import org.junit.*;

/**
 * Collection of all test files from top test/Analysis folder
 * @author Vladimir Voskresensky
 */
public class Analysis_Test extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/Analysis/";
  public Analysis_Test() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->true, 
            "${SPUTNIK}/modules/org.clang.staticanalyzer/test/unit/src/org/clang/staticanalyzer/test/Analysis_Test.txt");
  }

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }  
  
  @Test
  public void test_CFContainers_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/CFContainers.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=osx.coreFoundation.containers.PointerSizedValues,osx.coreFoundation.containers.OutOfBounds' '-analyzer-store=region' -triple x86_64-apple-darwin -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/CFContainers.mm
    RUN("%clang_cc1 -analyze -analyzer-checker=osx.coreFoundation.containers.PointerSizedValues,osx.coreFoundation.containers.OutOfBounds -analyzer-store=region -triple x86_64-apple-darwin -verify %s");
  }

  @Test
  public void test_CFContainers_invalid_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/CFContainers-invalid.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=osx.coreFoundation.containers.PointerSizedValues' -triple x86_64-apple-darwin -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/CFContainers-invalid.c
    RUN("%clang_cc1 -analyze -analyzer-checker=osx.coreFoundation.containers.PointerSizedValues -triple x86_64-apple-darwin -verify %s");
  }

  @Test
  public void test_CFDateGC_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/CFDateGC.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.RetainCount' '-analyzer-store=region' '-analyzer-constraints=range' -verify -fobjc-gc ${LLVM_SRC}/llvm/tools/clang/test/Analysis/CFDateGC.m -Wno-implicit-function-declaration
    RUN("%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.RetainCount -analyzer-store=region -analyzer-constraints=range -verify -fobjc-gc %s  -Wno-implicit-function-declaration");
  }

  @Test
  public void test_CFNumber_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/CFNumber.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.coreFoundation.CFNumber,osx.cocoa.RetainCount' '-analyzer-store=region' '-analyzer-constraints=range' -verify -triple x86_64-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/Analysis/CFNumber.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,osx.coreFoundation.CFNumber,osx.cocoa.RetainCount -analyzer-store=region -analyzer-constraints=range -verify -triple x86_64-apple-darwin9 %s");
  }

  @Test
  public void test_CFRetainRelease_NSAssertionHandler_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/CFRetainRelease_NSAssertionHandler.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.RetainCount,alpha.core' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/CFRetainRelease_NSAssertionHandler.m '-analyzer-constraints=range' '-analyzer-store=region'
    RUN("%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.RetainCount,alpha.core -verify %s -analyzer-constraints=range -analyzer-store=region");
  }

  @Test
  public void test_CGColorSpace_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/CGColorSpace.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.RetainCount' '-analyzer-store=region' '-analyzer-constraints=range' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/CGColorSpace.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.RetainCount -analyzer-store=region -analyzer-constraints=range -verify %s");
  }

  @Test
  public void test_CheckNSError_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/CheckNSError.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.NSError,osx.coreFoundation.CFError' '-analyzer-store=region' '-analyzer-constraints=range' -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/CheckNSError.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.NSError,osx.coreFoundation.CFError -analyzer-store=region -analyzer-constraints=range -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_DeallocMissingRelease_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/DeallocMissingRelease.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=osx.cocoa.Dealloc' -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/DeallocMissingRelease.m
    RUN("%clang_cc1 -analyze -analyzer-checker=osx.cocoa.Dealloc -fblocks -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=osx.cocoa.Dealloc' -fblocks -triple x86_64-apple-darwin10 -fobjc-arc -fobjc-runtime-has-weak -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/DeallocMissingRelease.m
    RUN("%clang_cc1 -analyze -analyzer-checker=osx.cocoa.Dealloc -fblocks -triple x86_64-apple-darwin10 -fobjc-arc -fobjc-runtime-has-weak -verify %s");
  }

  @Test
  public void test_DeallocUseAfterFreeErrors_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/DeallocUseAfterFreeErrors.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.SuperDealloc,debug.ExprInspection' '-analyzer-output=text' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/DeallocUseAfterFreeErrors.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.SuperDealloc,debug.ExprInspection -analyzer-output=text -verify %s");
  }

  @Test
  public void test_DynamicTypePropagation_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/DynamicTypePropagation.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.ObjCGenerics' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/DynamicTypePropagation.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.ObjCGenerics -verify %s");
  }

  @Test
  public void test_MallocxMismatchedDeallocatorxNewDelete_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/Malloc+MismatchedDeallocator+NewDelete.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc,unix.MismatchedDeallocator,cplusplus.NewDelete' '-std=c++11' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/Malloc+MismatchedDeallocator+NewDelete.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix.Malloc,unix.MismatchedDeallocator,cplusplus.NewDelete -std=c++11 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc,unix.MismatchedDeallocator,cplusplus.NewDelete,cplusplus.NewDeleteLeaks' -DLEAKS '-std=c++11' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/Malloc+MismatchedDeallocator+NewDelete.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix.Malloc,unix.MismatchedDeallocator,cplusplus.NewDelete,cplusplus.NewDeleteLeaks -DLEAKS -std=c++11 -verify %s");
  }

  @Test
  public void test_MallocxMismatchedDeallocator_intersections_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/Malloc+MismatchedDeallocator_intersections.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc,unix.MismatchedDeallocator' -analyzer-store region '-std=c++11' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/Malloc+MismatchedDeallocator_intersections.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix.Malloc,unix.MismatchedDeallocator -analyzer-store region -std=c++11 -verify %s");
  }

  @Test
  public void test_MallocxNewDelete_intersections_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/Malloc+NewDelete_intersections.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc,cplusplus.NewDelete' '-std=c++11' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/Malloc+NewDelete_intersections.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix.Malloc,cplusplus.NewDelete -std=c++11 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc,cplusplus.NewDelete,cplusplus.NewDeleteLeaks' '-std=c++11' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/Malloc+NewDelete_intersections.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix.Malloc,cplusplus.NewDelete,cplusplus.NewDeleteLeaks -std=c++11 -verify %s");
  }

  @Test
  public void test_MemRegion_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/MemRegion.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=optin.mpi.MPI-Checker' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/MemRegion.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=optin.mpi.MPI-Checker -verify %s");
  }

  @Test
  public void test_MismatchedDeallocator_checker_test_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/MismatchedDeallocator-checker-test.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.MismatchedDeallocator' -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/MismatchedDeallocator-checker-test.mm
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,unix.MismatchedDeallocator -fblocks -verify %s");
  }

  @Test
  public void test_MismatchedDeallocator_path_notes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/MismatchedDeallocator-path-notes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.MismatchedDeallocator' '-analyzer-output=text' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/MismatchedDeallocator-path-notes.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix.MismatchedDeallocator -analyzer-output=text -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.MismatchedDeallocator' '-analyzer-output=plist' -analyzer-config 'path-diagnostics-alternate=false' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/MismatchedDeallocator-path-notes.cpp -o ${TEST_TEMP_DIR}/MismatchedDeallocator-path-notes.cpp.tmp.plist
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix.MismatchedDeallocator -analyzer-output=plist -analyzer-config path-diagnostics-alternate=false %s -o %t.plist");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/MismatchedDeallocator-path-notes.cpp.tmp.plist" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/MismatchedDeallocator-path-notes.cpp
    RUN("FileCheck --input-file=%t.plist %s");
  }

  @Test
  public void test_MissingDealloc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/MissingDealloc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=osx.cocoa.Dealloc' -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/MissingDealloc.m
    RUN("%clang_cc1 -analyze -analyzer-checker=osx.cocoa.Dealloc -fblocks -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=osx.cocoa.Dealloc' -fblocks -verify -triple x86_64-apple-darwin10 -fobjc-arc ${LLVM_SRC}/llvm/tools/clang/test/Analysis/MissingDealloc.m
    RUN("%clang_cc1 -analyze -analyzer-checker=osx.cocoa.Dealloc -fblocks -verify -triple x86_64-apple-darwin10 -fobjc-arc %s");
  }

  @Test
  public void test_NSContainers_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/NSContainers.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-objc-literal-conversion -analyze '-analyzer-checker=core,osx.cocoa.NonNilReturnValue,osx.cocoa.NilArg,osx.cocoa.Loops,debug.ExprInspection' -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/NSContainers.m
    RUN("%clang_cc1  -Wno-objc-literal-conversion -analyze -analyzer-checker=core,osx.cocoa.NonNilReturnValue,osx.cocoa.NilArg,osx.cocoa.Loops,debug.ExprInspection -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_NSPanel_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/NSPanel.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.RetainCount,alpha.core' '-analyzer-store=region' '-analyzer-constraints=range' -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/NSPanel.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.RetainCount,alpha.core -analyzer-store=region -analyzer-constraints=range -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_NSString_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/NSString.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -analyze '-analyzer-checker=core,osx.cocoa.NilArg,osx.cocoa.RetainCount,alpha.core' '-analyzer-store=region' '-analyzer-constraints=range' -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/NSString.m
    RUN("%clang_cc1 -triple i386-apple-darwin10 -analyze -analyzer-checker=core,osx.cocoa.NilArg,osx.cocoa.RetainCount,alpha.core -analyzer-store=region -analyzer-constraints=range -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -analyze '-analyzer-checker=core,osx.cocoa.NilArg,osx.cocoa.RetainCount,alpha.core' '-analyzer-store=region' '-analyzer-constraints=range' -analyzer-config 'mode=shallow' -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/NSString.m
    RUN("%clang_cc1 -triple i386-apple-darwin10 -analyze -analyzer-checker=core,osx.cocoa.NilArg,osx.cocoa.RetainCount,alpha.core -analyzer-store=region -analyzer-constraints=range -analyzer-config mode=shallow -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DTEST_64 -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core,osx.cocoa.NilArg,osx.cocoa.RetainCount,alpha.core' '-analyzer-store=region' '-analyzer-constraints=range' -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/NSString.m
    RUN("%clang_cc1 -DTEST_64 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core,osx.cocoa.NilArg,osx.cocoa.RetainCount,alpha.core -analyzer-store=region -analyzer-constraints=range -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DOSATOMIC_USE_INLINED -triple i386-apple-darwin10 -analyze '-analyzer-checker=core,osx.cocoa.NilArg,osx.cocoa.RetainCount,alpha.core' '-analyzer-store=region' '-analyzer-constraints=range' -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/NSString.m
    RUN("%clang_cc1 -DOSATOMIC_USE_INLINED -triple i386-apple-darwin10 -analyze -analyzer-checker=core,osx.cocoa.NilArg,osx.cocoa.RetainCount,alpha.core -analyzer-store=region -analyzer-constraints=range -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_NSWindow_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/NSWindow.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.RetainCount,alpha.core,deadcode.DeadStores' '-analyzer-store=region' '-analyzer-constraints=range' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/NSWindow.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.RetainCount,alpha.core,deadcode.DeadStores -analyzer-store=region -analyzer-constraints=range -verify %s");
  }

  @Test
  public void test_NewDeletexMismatchedDeallocator_intersections_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/NewDelete+MismatchedDeallocator_intersections.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,cplusplus.NewDelete,unix.MismatchedDeallocator' '-std=c++11' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/NewDelete+MismatchedDeallocator_intersections.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,cplusplus.NewDelete,unix.MismatchedDeallocator -std=c++11 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,cplusplus.NewDelete,cplusplus.NewDeleteLeaks,unix.MismatchedDeallocator' -DLEAKS '-std=c++11' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/NewDelete+MismatchedDeallocator_intersections.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,cplusplus.NewDelete,cplusplus.NewDeleteLeaks,unix.MismatchedDeallocator -DLEAKS -std=c++11 -verify %s");
  }

  @Test
  public void test_NewDelete_checker_test_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/NewDelete-checker-test.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,cplusplus.NewDelete' '-std=c++11' -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/NewDelete-checker-test.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,cplusplus.NewDelete -std=c++11 -fblocks -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,cplusplus.NewDeleteLeaks' -DLEAKS '-std=c++11' -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/NewDelete-checker-test.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,cplusplus.NewDeleteLeaks -DLEAKS -std=c++11 -fblocks -verify %s");
  }

  @Test
  public void test_NewDelete_custom_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/NewDelete-custom.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,cplusplus.NewDelete,unix.Malloc' '-std=c++11' -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/NewDelete-custom.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,cplusplus.NewDelete,unix.Malloc -std=c++11 -fblocks -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,cplusplus.NewDelete,cplusplus.NewDeleteLeaks,unix.Malloc' '-std=c++11' -DLEAKS -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/NewDelete-custom.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,cplusplus.NewDelete,cplusplus.NewDeleteLeaks,unix.Malloc -std=c++11 -DLEAKS -fblocks -verify %s");
  }

  @Test
  public void test_NewDelete_intersections_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/NewDelete-intersections.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,cplusplus.NewDelete' '-std=c++11' -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/NewDelete-intersections.mm
    RUN("%clang_cc1 -analyze -analyzer-checker=core,cplusplus.NewDelete -std=c++11 -fblocks -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,cplusplus.NewDelete,cplusplus.NewDeleteLeaks' '-std=c++11' -DLEAKS -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/NewDelete-intersections.mm
    RUN("%clang_cc1 -analyze -analyzer-checker=core,cplusplus.NewDelete,cplusplus.NewDeleteLeaks -std=c++11 -DLEAKS -fblocks -verify %s");
  }

  @Test
  public void test_NewDelete_path_notes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/NewDelete-path-notes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=cplusplus.NewDelete,unix.Malloc' '-analyzer-output=text' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/NewDelete-path-notes.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=cplusplus.NewDelete,unix.Malloc -analyzer-output=text -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=cplusplus.NewDelete,unix.Malloc' '-analyzer-output=plist' -analyzer-config 'path-diagnostics-alternate=false' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/NewDelete-path-notes.cpp -o ${TEST_TEMP_DIR}/NewDelete-path-notes.cpp.tmp.plist
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=cplusplus.NewDelete,unix.Malloc -analyzer-output=plist -analyzer-config path-diagnostics-alternate=false %s -o %t.plist");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/NewDelete-path-notes.cpp.tmp.plist" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/NewDelete-path-notes.cpp
    RUN(TestState.Failed, "FileCheck --input-file=%t.plist %s");
  }

  @Test
  public void test_NewDelete_variadic_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/NewDelete-variadic.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,cplusplus.NewDelete,cplusplus.NewDeleteLeaks,unix.Malloc' '-std=c++11' -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/NewDelete-variadic.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,cplusplus.NewDelete,cplusplus.NewDeleteLeaks,unix.Malloc -std=c++11 -fblocks -verify %s");
  }

  @Test
  public void test_NewDeleteLeaks_PR18394_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/NewDeleteLeaks-PR18394.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyzer-config 'graph-trim-interval=1' -analyzer-max-loop 1 -analyze '-analyzer-checker=core,cplusplus.NewDeleteLeaks' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/NewDeleteLeaks-PR18394.cpp
    RUN("%clang_cc1 -analyzer-config graph-trim-interval=1 -analyzer-max-loop 1 -analyze -analyzer-checker=core,cplusplus.NewDeleteLeaks -verify %s");
  }

  @Test
  public void test_NewDeleteLeaks_PR19102_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/NewDeleteLeaks-PR19102.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,cplusplus.NewDeleteLeaks' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/NewDeleteLeaks-PR19102.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,cplusplus.NewDeleteLeaks -verify %s");
  }

  @Test
  public void test_NoReturn_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/NoReturn.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/NoReturn.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core -verify %s");
  }

  @Test
  public void test_OSAtomic_mac_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/OSAtomic_mac.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -analyze '-analyzer-checker=core,osx' '-analyzer-store=region' -verify -fblocks -analyzer-opt-analyze-nested-blocks ${LLVM_SRC}/llvm/tools/clang/test/Analysis/OSAtomic_mac.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 -analyze -analyzer-checker=core,osx -analyzer-store=region -verify -fblocks   -analyzer-opt-analyze-nested-blocks %s");
  }

  @Test
  public void test_ObjCProperties_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/ObjCProperties.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core' '-analyzer-store=region' '-analyzer-constraints=range' -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/ObjCProperties.m -verify
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core -analyzer-store=region -analyzer-constraints=range -Wno-objc-root-class %s -verify");
  }

  @Test
  public void test_ObjCRetSigs_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/ObjCRetSigs.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core' '-analyzer-checker=osx.cocoa.IncompatibleMethodTypes' -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/ObjCRetSigs.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core -analyzer-checker=osx.cocoa.IncompatibleMethodTypes -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_PR12905_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/PR12905.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/PR12905.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core %s");
  }

  @Test
  public void test_PR24184_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/PR24184.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -analyze -analyzer-eagerly-assume -fcxx-exceptions '-analyzer-checker=core' '-analyzer-checker=alpha.core.PointerArithm,alpha.core.CastToStruct' -analyzer-max-loop 64 -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/PR24184.cpp
    RUN("%clang_cc1 -w -analyze -analyzer-eagerly-assume -fcxx-exceptions -analyzer-checker=core -analyzer-checker=alpha.core.PointerArithm,alpha.core.CastToStruct -analyzer-max-loop 64 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -analyze '-analyzer-checker=core' '-analyzer-checker=cplusplus' -fcxx-exceptions -analyzer-checker alpha.core.PointerArithm,alpha.core.CastToStruct -analyzer-max-loop 63 -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/PR24184.cpp
    RUN("%clang_cc1 -w -analyze -analyzer-checker=core -analyzer-checker=cplusplus -fcxx-exceptions -analyzer-checker alpha.core.PointerArithm,alpha.core.CastToStruct -analyzer-max-loop 63 -verify %s");
  }

  @Test
  public void test_PR2599_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/PR2599.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -analyze '-analyzer-checker=core,osx.cocoa.RetainCount,alpha.core' '-analyzer-constraints=range' '-analyzer-store=region' -fobjc-gc -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/PR2599.m
    RUN("%clang_cc1 -triple %itanium_abi_triple -analyze -analyzer-checker=core,osx.cocoa.RetainCount,alpha.core -analyzer-constraints=range -analyzer-store=region -fobjc-gc -verify %s");
  }

  @Test
  public void test_PR2978_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/PR2978.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core,osx.cocoa.Dealloc' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/PR2978.m -verify
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core,osx.cocoa.Dealloc %s -verify");
  }

  @Test
  public void test_PR3991_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/PR3991.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core' '-analyzer-store=region' '-analyzer-constraints=range' -verify -triple x86_64-apple-darwin9 -Wno-incomplete-implementation ${LLVM_SRC}/llvm/tools/clang/test/Analysis/PR3991.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core -analyzer-store=region -analyzer-constraints=range -verify -triple x86_64-apple-darwin9 -Wno-incomplete-implementation %s");
  }

  @Test
  public void test_PR7218_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/PR7218.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -analyzer-store region -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/PR7218.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-store region -verify %s");
  }

  @Test
  public void test_PR9741_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/PR9741.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -Wuninitialized -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/PR9741.cpp
    RUN("%clang_cc1 -std=c++11 -Wuninitialized -verify %s");
  }

  @Test
  public void test_additive_folding_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/additive-folding.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -verify '-analyzer-constraints=range' -Wno-tautological-compare ${LLVM_SRC}/llvm/tools/clang/test/Analysis/additive-folding.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -verify -analyzer-constraints=range -Wno-tautological-compare %s");
  }

  @Test
  public void test_additive_folding_range_constraints_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/additive-folding-range-constraints.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -verify '-analyzer-constraints=range' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/additive-folding-range-constraints.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -verify -analyzer-constraints=range %s");
  }

  @Test
  public void test_analyzeOneFunction_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/analyzeOneFunction.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyze-function="myMethodWithY:withX:"' '-analyzer-checker=core,osx.cocoa.RetainCount' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/analyzeOneFunction.m
    RUN("%clang_cc1 -analyze -analyze-function=\"myMethodWithY:withX:\" -analyzer-checker=core,osx.cocoa.RetainCount -analyzer-store=region -verify %s");
  }

  @Test
  public void test_analyze_display_progress_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/analyze_display_progress.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze -analyzer-display-progress ${LLVM_SRC}/llvm/tools/clang/test/Analysis/analyze_display_progress.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/analyze_display_progress.cpp
    RUN("%clang_cc1 -analyze -analyzer-display-progress %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_analyzer_checker_config_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/analyzer-checker-config.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc' -analyzer-config 'unix.mallo:Optimistic=true' 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/analyzer-checker-config.c
    RUN("not %clang_cc1 -analyze -analyzer-checker=core,unix.Malloc -analyzer-config unix.mallo:Optimistic=true 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc' -analyzer-config 'uni:Optimistic=true' 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/analyzer-checker-config.c
    RUN("not %clang_cc1 -analyze -analyzer-checker=core,unix.Malloc -analyzer-config uni:Optimistic=true 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc' -analyzer-config 'uni.:Optimistic=true' 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/analyzer-checker-config.c
    RUN("not %clang_cc1 -analyze -analyzer-checker=core,unix.Malloc -analyzer-config uni.:Optimistic=true 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc' -analyzer-config '..:Optimistic=true' 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/analyzer-checker-config.c
    RUN("not %clang_cc1 -analyze -analyzer-checker=core,unix.Malloc -analyzer-config ..:Optimistic=true 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc' -analyzer-config 'unix.:Optimistic=true' 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/analyzer-checker-config.c
    RUN("not %clang_cc1 -analyze -analyzer-checker=core,unix.Malloc -analyzer-config unix.:Optimistic=true 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc' -analyzer-config 'unrelated:Optimistic=true' 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/analyzer-checker-config.c
    RUN("not %clang_cc1 -analyze -analyzer-checker=core,unix.Malloc -analyzer-config unrelated:Optimistic=true 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc' -analyzer-config 'unix.Malloc:Optimistic=true'
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix.Malloc -analyzer-config unix.Malloc:Optimistic=true");
  }

  @Test
  public void test_analyzer_config_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/analyzer-config.c");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-darwin10 --analyze ${LLVM_SRC}/llvm/tools/clang/test/Analysis/analyzer-config.c -o /dev/null -Xclang '-analyzer-checker=debug.ConfigDumper' -Xclang -analyzer-max-loop -Xclang 34 > ${TEST_TEMP_DIR}/analyzer-config.c.tmp 2>&1
    RUN("%clang -target x86_64-apple-darwin10 --analyze %s -o /dev/null -Xclang -analyzer-checker=debug.ConfigDumper -Xclang -analyzer-max-loop -Xclang 34 > %t 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/analyzer-config.c.tmp" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/analyzer-config.c
    RUN("FileCheck --input-file=%t %s");
  }

  @Test
  public void test_analyzer_config_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/analyzer-config.cpp");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-darwin10 --analyze ${LLVM_SRC}/llvm/tools/clang/test/Analysis/analyzer-config.cpp -o /dev/null -Xclang '-analyzer-checker=debug.ConfigDumper' -Xclang -analyzer-max-loop -Xclang 34 > ${TEST_TEMP_DIR}/analyzer-config.cpp.tmp 2>&1
    RUN("%clang -target x86_64-apple-darwin10 --analyze %s -o /dev/null -Xclang -analyzer-checker=debug.ConfigDumper -Xclang -analyzer-max-loop -Xclang 34 > %t 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/analyzer-config.cpp.tmp" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/analyzer-config.cpp
    RUN("FileCheck --input-file=%t %s");
  }

  @Test
  public void test_analyzer_stats_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/analyzer-stats.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,deadcode.DeadStores,debug.Stats' -verify -Wno-unreachable-code -analyzer-opt-analyze-nested-blocks ${LLVM_SRC}/llvm/tools/clang/test/Analysis/analyzer-stats.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,deadcode.DeadStores,debug.Stats -verify -Wno-unreachable-code -analyzer-opt-analyze-nested-blocks %s");
  }

  @Test
  public void test_array_struct_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/array-struct.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core.CastToStruct' '-analyzer-store=region' '-analyzer-constraints=range' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/array-struct.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core.CastToStruct -analyzer-store=region -analyzer-constraints=range -verify %s");
  }

  @Test
  public void test_array_struct_region_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/array-struct-region.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core,debug.ExprInspection' '-analyzer-constraints=range' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/array-struct-region.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core,debug.ExprInspection -analyzer-constraints=range -verify %s");
  }

  @Test
  public void test_array_struct_region_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/array-struct-region.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core,debug.ExprInspection' -verify -x c ${LLVM_SRC}/llvm/tools/clang/test/Analysis/array-struct-region.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,alpha.core,debug.ExprInspection -verify -x c %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core,debug.ExprInspection' -verify -x c++ -analyzer-config 'c++-inlining=constructors' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/array-struct-region.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,alpha.core,debug.ExprInspection -verify -x c++ -analyzer-config c++-inlining=constructors %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core,debug.ExprInspection' -DINLINE -verify -x c ${LLVM_SRC}/llvm/tools/clang/test/Analysis/array-struct-region.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,alpha.core,debug.ExprInspection -DINLINE -verify -x c %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core,debug.ExprInspection' -DINLINE -verify -x c++ -analyzer-config 'c++-inlining=constructors' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/array-struct-region.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,alpha.core,debug.ExprInspection -DINLINE -verify -x c++ -analyzer-config c++-inlining=constructors %s");
  }

  @Test
  public void test_atomics_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/atomics.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/atomics.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -verify %s");
  }

  @Test
  public void test_auto_obj_dtors_cfg_output_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/auto-obj-dtors-cfg-output.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -analyze '-analyzer-checker=debug.DumpCFG' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/auto-obj-dtors-cfg-output.cpp > ${TEST_TEMP_DIR}/auto-obj-dtors-cfg-output.cpp.tmp 2>&1
    RUN(TestState.Failed, "%clang_cc1 -fcxx-exceptions -fexceptions -analyze -analyzer-checker=debug.DumpCFG %s > %t 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/auto-obj-dtors-cfg-output.cpp.tmp" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/auto-obj-dtors-cfg-output.cpp
    RUN(TestState.Failed, "FileCheck --input-file=%t %s");
  }

  @Test
  public void test_base_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/base-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -analyzer-config 'c++-inlining=constructors' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/base-init.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -analyzer-config c++-inlining=constructors -verify %s");
  }

  @Test
  public void test_bitwise_ops_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/bitwise-ops.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -triple x86_64-apple-darwin13 -Wno-shift-count-overflow -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/bitwise-ops.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -triple x86_64-apple-darwin13 -Wno-shift-count-overflow -verify %s");
  }

  @Test
  public void test_blocks_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/blocks.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core' '-analyzer-store=region' -fblocks -analyzer-opt-analyze-nested-blocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/blocks.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core -analyzer-store=region -fblocks -analyzer-opt-analyze-nested-blocks -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core' '-analyzer-store=region' -fblocks -analyzer-opt-analyze-nested-blocks -verify -x objective-c++ ${LLVM_SRC}/llvm/tools/clang/test/Analysis/blocks.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core -analyzer-store=region -fblocks -analyzer-opt-analyze-nested-blocks -verify -x objective-c++ %s");
  }

  @Test
  public void test_blocks_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/blocks.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core' -fblocks -analyzer-opt-analyze-nested-blocks -verify -x objective-c++ ${LLVM_SRC}/llvm/tools/clang/test/Analysis/blocks.mm
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core -fblocks -analyzer-opt-analyze-nested-blocks -verify -x objective-c++ %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -fsyntax-only -analyze '-analyzer-checker=core,debug.DumpCFG' -fblocks -analyzer-opt-analyze-nested-blocks ${LLVM_SRC}/llvm/tools/clang/test/Analysis/blocks.mm > ${TEST_TEMP_DIR}/blocks.mm.tmp 2>&1
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -analyze -analyzer-checker=core,debug.DumpCFG -fblocks -analyzer-opt-analyze-nested-blocks  %s > %t 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/blocks.mm.tmp" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/blocks.mm
    RUN("FileCheck --input-file=%t %s");
  }

  @Test
  public void test_blocks_no_inline_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/blocks-no-inline.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core,debug.ExprInspection' -analyzer-config 'ipa=none' -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/blocks-no-inline.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core,debug.ExprInspection -analyzer-config ipa=none -fblocks -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core,debug.ExprInspection' -analyzer-config 'ipa=none' -fblocks -verify -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Analysis/blocks-no-inline.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core,debug.ExprInspection -analyzer-config ipa=none -fblocks -verify -x c++ %s");
  }

  @Test
  public void test_bool_assignment_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/bool-assignment.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core.BoolAssignment' '-analyzer-store=region' -verify '-std=c99' '-Dbool=_Bool' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/bool-assignment.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core.BoolAssignment -analyzer-store=region -verify -std=c99 -Dbool=_Bool %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core.BoolAssignment' '-analyzer-store=region' -verify -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Analysis/bool-assignment.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core.BoolAssignment -analyzer-store=region -verify -x c++ %s");
  }

  @Test
  public void test_bstring_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/bstring.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.cstring,alpha.unix.cstring,debug.ExprInspection' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/bstring.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix.cstring,alpha.unix.cstring,debug.ExprInspection -analyzer-store=region -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze -DUSE_BUILTINS '-analyzer-checker=core,unix.cstring,alpha.unix.cstring,debug.ExprInspection' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/bstring.c
    RUN("%clang_cc1 -analyze -DUSE_BUILTINS -analyzer-checker=core,unix.cstring,alpha.unix.cstring,debug.ExprInspection -analyzer-store=region -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze -DVARIANT '-analyzer-checker=core,unix.cstring,alpha.unix.cstring,debug.ExprInspection' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/bstring.c
    RUN("%clang_cc1 -analyze -DVARIANT -analyzer-checker=core,unix.cstring,alpha.unix.cstring,debug.ExprInspection -analyzer-store=region -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze -DUSE_BUILTINS -DVARIANT '-analyzer-checker=core,unix.cstring,alpha.unix.cstring,debug.ExprInspection' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/bstring.c
    RUN("%clang_cc1 -analyze -DUSE_BUILTINS -DVARIANT -analyzer-checker=core,unix.cstring,alpha.unix.cstring,debug.ExprInspection -analyzer-store=region -verify %s");
  }

  @Test
  public void test_bstring_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/bstring.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.cstring,alpha.unix.cstring,debug.ExprInspection' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/bstring.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,unix.cstring,alpha.unix.cstring,debug.ExprInspection -analyzer-store=region -verify %s");
  }

  @Test
  public void test_bug_hash_test_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/bug_hash_test.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -analyze '-analyzer-checker=core,debug.DumpBugHash' '-analyzer-output=plist' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/bug_hash_test.cpp -o ${TEST_TEMP_DIR}/bug_hash_test.cpp.tmp.plist
    RUN("%clang_cc1 -std=c++11 -analyze -analyzer-checker=core,debug.DumpBugHash -analyzer-output=plist %s -o %t.plist");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/bug_hash_test.cpp.tmp.plist" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/bug_hash_test.cpp
    RUN("FileCheck --input-file=%t.plist %s");
  }

  @Test
  public void test_bug_hash_test_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/bug_hash_test.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -analyze '-analyzer-checker=core,debug.DumpBugHash' '-analyzer-output=plist' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/bug_hash_test.m -o ${TEST_TEMP_DIR}/bug_hash_test.m.tmp.plist
    RUN("%clang_cc1 -fblocks -analyze -analyzer-checker=core,debug.DumpBugHash -analyzer-output=plist %s -o %t.plist");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/bug_hash_test.m.tmp.plist" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/bug_hash_test.m
    RUN("FileCheck --input-file=%t.plist %s");
  }

  @Test
  public void test_builtin_functions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/builtin-functions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core,debug.ExprInspection' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/builtin-functions.cpp '-std=c++11' -verify
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core,debug.ExprInspection %s -std=c++11 -verify");
  }

  @Test
  public void test_builtin_signbit_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/builtin_signbit.cpp");
    // ${LLVM_SRC}/build/bin/clang -target powerpc-linux-gnu -emit-llvm -S -O0 ${LLVM_SRC}/llvm/tools/clang/test/Analysis/builtin_signbit.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/builtin_signbit.cpp '--check-prefix=CHECK-BE' '--check-prefix=CHECK'
    RUN(TestState.Failed, "%clang -target powerpc-linux-gnu     -emit-llvm -S -O0 %s -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK-BE --check-prefix=CHECK");
    // ${LLVM_SRC}/build/bin/clang -target powerpc64-linux-gnu -emit-llvm -S -O0 ${LLVM_SRC}/llvm/tools/clang/test/Analysis/builtin_signbit.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/builtin_signbit.cpp '--check-prefix=CHECK-BE' '--check-prefix=CHECK'
    RUN(TestState.Failed, "%clang -target powerpc64-linux-gnu   -emit-llvm -S -O0 %s -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK-BE --check-prefix=CHECK");
    // ${LLVM_SRC}/build/bin/clang -target powerpc64le-linux-gnu -emit-llvm -S -O0 ${LLVM_SRC}/llvm/tools/clang/test/Analysis/builtin_signbit.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/builtin_signbit.cpp '--check-prefix=CHECK-LE' '--check-prefix=CHECK'
    RUN(TestState.Failed, "%clang -target powerpc64le-linux-gnu -emit-llvm -S -O0 %s -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK-LE --check-prefix=CHECK");
  }

  @Test
  public void test_call_invalidation_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/call-invalidation.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/call-invalidation.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -verify %s");
  }

  @Test
  public void test_casts_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/casts.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -analyze '-analyzer-checker=core,alpha.core,debug.ExprInspection' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/casts.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 -analyze -analyzer-checker=core,alpha.core,debug.ExprInspection -analyzer-store=region -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -analyze '-analyzer-checker=core,alpha.core,debug.ExprInspection' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/casts.c
    RUN("%clang_cc1 -triple i386-apple-darwin9 -analyze -analyzer-checker=core,alpha.core,debug.ExprInspection -analyzer-store=region -verify %s");
  }

  @Test
  public void test_casts_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/casts.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/casts.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-store=region -verify %s");
  }

  @Test
  public void test_casts_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/casts.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/casts.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core -analyzer-store=region -verify %s");
  }

  @Test
  public void test_cfg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/cfg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=debug.DumpCFG' -triple x86_64-apple-darwin12 -analyzer-config 'cfg-temporary-dtors=true' '-std=c++11' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/cfg.cpp > ${TEST_TEMP_DIR}/cfg.cpp.tmp 2>&1
    RUN("%clang_cc1 -analyze -analyzer-checker=debug.DumpCFG -triple x86_64-apple-darwin12 -analyzer-config cfg-temporary-dtors=true -std=c++11 %s > %t 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/cfg.cpp.tmp" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/cfg.cpp
    RUN("FileCheck --input-file=%t %s");
  }

  @Test
  public void test_cfref_PR2519_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/cfref_PR2519.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.RetainCount,alpha.core' '-analyzer-store=region' '-analyzer-constraints=range' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/cfref_PR2519.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.RetainCount,alpha.core -analyzer-store=region -analyzer-constraints=range -verify %s");
  }

  @Test
  public void test_cfref_rdar6080742_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/cfref_rdar6080742.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core' '-analyzer-store=region' '-analyzer-constraints=range' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/cfref_rdar6080742.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core -analyzer-store=region -analyzer-constraints=range -verify %s");
  }

  @Test
  public void test_check_deserialization_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/check-deserialization.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/check-deserialization.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/Analysis/check-deserialization.cpp
    RUN("%clang_cc1 -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -error-on-deserialized-decl S1_method -include-pch ${TEST_TEMP_DIR}/check-deserialization.cpp.tmp -analyze '-analyzer-checker=core' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/check-deserialization.cpp
    RUN("%clang_cc1 -error-on-deserialized-decl S1_method -include-pch %t -analyze -analyzer-checker=core %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/check-deserialization.cpp.tmp -analyze '-analyzer-checker=core' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/check-deserialization.cpp
    RUN("%clang_cc1 -include-pch %t -analyze -analyzer-checker=core -verify %s");
  }

  @Test
  public void test_checker_plugins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/checker-plugins.c");
    // REQUIRES: plugins, examples
    if (!CHECK_REQUIRES("plugins, examples")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -load ${LLVM_SRC}/build/tools/clang/lib/SampleAnalyzerPlugin.so -analyze "-analyzer-checker='example.MainCallChecker'" -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/checker-plugins.c
    RUN(TestState.Failed, "%clang_cc1 -load %llvmshlibdir/SampleAnalyzerPlugin%pluginext -analyze -analyzer-checker='example.MainCallChecker' -verify %s");
  }

  @Test
  public void test_chroot_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/chroot.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=alpha.unix.Chroot' -analyzer-store region -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/chroot.c
    RUN("%clang_cc1 -analyze -analyzer-checker=alpha.unix.Chroot -analyzer-store region -verify %s");
  }

  @Test
  public void test_comparison_implicit_casts_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/comparison-implicit-casts.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.cstring,debug.ExprInspection' '-analyzer-constraints=range' -triple i386-apple-darwin9 -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/comparison-implicit-casts.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix.cstring,debug.ExprInspection -analyzer-constraints=range -triple i386-apple-darwin9 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.cstring,debug.ExprInspection' '-analyzer-constraints=range' -triple x86_64-apple-darwin9 -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/comparison-implicit-casts.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix.cstring,debug.ExprInspection -analyzer-constraints=range -triple x86_64-apple-darwin9 -verify %s");
  }

  @Test
  public void test_complex_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/complex.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-store=region' '-analyzer-constraints=range' -verify -Wno-unreachable-code -ffreestanding ${LLVM_SRC}/llvm/tools/clang/test/Analysis/complex.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-store=region -analyzer-constraints=range -verify -Wno-unreachable-code -ffreestanding %s");
  }

  @Test
  public void test_complex_init_list_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/complex-init-list.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=text' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/complex-init-list.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=text -verify %s");
  }

  @Test
  public void test_concrete_address_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/concrete-address.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/concrete-address.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core -analyzer-store=region -verify %s");
  }

  @Test
  public void test_conditional_operator_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/conditional-operator.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/conditional-operator.cpp '-analyzer-output=text' -verify
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection %s -analyzer-output=text -verify");
  }

  @Test
  public void test_conditional_path_notes_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/conditional-path-notes.c");
    // ${LLVM_SRC}/build/bin/clang --analyze ${LLVM_SRC}/llvm/tools/clang/test/Analysis/conditional-path-notes.c -Xanalyzer '-analyzer-output=text' -Xclang -verify
    RUN(TestState.Failed, "%clang --analyze %s -Xanalyzer -analyzer-output=text -Xclang -verify");
    // ${LLVM_SRC}/build/bin/clang --analyze ${LLVM_SRC}/llvm/tools/clang/test/Analysis/conditional-path-notes.c -Xanalyzer -analyzer-config -Xanalyzer 'path-diagnostics-alternate=false' -o ${TEST_TEMP_DIR}/conditional-path-notes.c.tmp
    RUN(TestState.Failed, "%clang --analyze %s -Xanalyzer -analyzer-config -Xanalyzer path-diagnostics-alternate=false -o %t");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/conditional-path-notes.c.tmp" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/conditional-path-notes.c
    RUN(TestState.Failed, "FileCheck --input-file=%t %s");
  }

  @Test
  public void test_const_method_call_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/const-method-call.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/const-method-call.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -verify %s");
  }

  @Test
  public void test_constant_folding_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/constant-folding.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/constant-folding.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -verify %s");
  }

  @Test
  public void test_coverage_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/coverage.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc' '-analyzer-store=region' -analyzer-max-loop 4 -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/coverage.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix.Malloc -analyzer-store=region -analyzer-max-loop 4 -verify %s");
  }

  @Test
  public void test_crash_trace_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/crash-trace.c");
    // REQUIRES: crash-recovery
    if (!CHECK_REQUIRES("crash-recovery")) {
      return;
    }
    // REQUIRES: shell, backtrace
    if (!CHECK_REQUIRES("shell, backtrace")) {
      return;
    }
    // --crash ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=debug.ExprInspection' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/crash-trace.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/crash-trace.c
    RUN(TestState.Failed, "not --crash %clang_cc1 -analyze -analyzer-checker=debug.ExprInspection %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cstring_syntax_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/cstring-syntax.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=unix.cstring.BadSizeArg' '-analyzer-store=region' -Wno-strncat-size -Wno-strlcpy-strlcat-size -Wno-sizeof-array-argument -Wno-sizeof-pointer-memaccess -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/cstring-syntax.c
    RUN("%clang_cc1 -analyze -analyzer-checker=unix.cstring.BadSizeArg -analyzer-store=region -Wno-strncat-size -Wno-strlcpy-strlcat-size -Wno-sizeof-array-argument -Wno-sizeof-pointer-memaccess -verify %s");
  }

  @Test
  public void test_cstring_syntax_cxx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/cstring-syntax-cxx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=unix.cstring.BadSizeArg' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/cstring-syntax-cxx.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=unix.cstring.BadSizeArg -analyzer-store=region -verify %s");
  }

  @Test
  public void test_ctor_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/ctor.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -fobjc-arc -analyzer-config 'c++-inlining=constructors' -Wno-null-dereference '-std=c++11' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/ctor.mm
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -fobjc-arc -analyzer-config c++-inlining=constructors -Wno-null-dereference -std=c++11 -verify %s");
  }

  @Test
  public void test_cxx_crashes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/cxx-crashes.cpp");
    // REQUIRES: LP64
    if (!CHECK_REQUIRES("LP64")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc,debug.ExprInspection' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/cxx-crashes.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix.Malloc,debug.ExprInspection -verify %s");
  }

  @Test
  public void test_cxx_for_range_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/cxx-for-range.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-std=c++11' '-analyzer-checker=core' -analyzer-config 'path-diagnostics-alternate=true' '-analyzer-output=plist-multi-file' -o ${TEST_TEMP_DIR}/cxx-for-range.cpp.tmp.plist -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/cxx-for-range.cpp
    RUN("%clang_cc1 -analyze -std=c++11 -analyzer-checker=core -analyzer-config path-diagnostics-alternate=true -analyzer-output=plist-multi-file -o %t.plist -verify %s");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/cxx-for-range.cpp.tmp.plist" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/cxx-for-range.cpp
    RUN(TestState.Failed, "FileCheck --input-file=%t.plist %s");
  }

  @Test
  public void test_cxx_for_range_cfg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/cxx-for-range-cfg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wall -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Analysis/cxx-for-range-cfg.cpp '-std=c++11' -verify
    RUN("%clang_cc1 -Wall -fsyntax-only %s -std=c++11 -verify");
  }

  @Test
  public void test_cxx_method_names_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/cxx-method-names.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix,osx,alpha.unix,alpha.security.taint' -analyzer-store region -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/cxx-method-names.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix,osx,alpha.unix,alpha.security.taint -analyzer-store region -verify %s");
  }

  @Test
  public void test_cxx11_crashes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/cxx11-crashes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-std=c++11' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/cxx11-crashes.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core -std=c++11 -verify %s");
  }

  @Test
  public void test_dead_stores_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/dead-stores.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wunused-variable -analyze '-analyzer-checker=core,deadcode.DeadStores' -fblocks -verify -Wno-unreachable-code -analyzer-opt-analyze-nested-blocks ${LLVM_SRC}/llvm/tools/clang/test/Analysis/dead-stores.c
    RUN(TestState.Failed, "%clang_cc1 -Wunused-variable -analyze -analyzer-checker=core,deadcode.DeadStores -fblocks -verify -Wno-unreachable-code -analyzer-opt-analyze-nested-blocks %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wunused-variable -analyze '-analyzer-checker=core,deadcode.DeadStores' '-analyzer-store=region' '-analyzer-constraints=range' -fblocks -verify -Wno-unreachable-code -analyzer-opt-analyze-nested-blocks ${LLVM_SRC}/llvm/tools/clang/test/Analysis/dead-stores.c
    RUN(TestState.Failed, "%clang_cc1 -Wunused-variable -analyze -analyzer-checker=core,deadcode.DeadStores -analyzer-store=region -analyzer-constraints=range -fblocks -verify -Wno-unreachable-code -analyzer-opt-analyze-nested-blocks %s");
  }

  @Test
  public void test_dead_stores_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/dead-stores.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fblocks '-std=c++11' -analyze '-analyzer-checker=deadcode.DeadStores' -verify -Wno-unreachable-code ${LLVM_SRC}/llvm/tools/clang/test/Analysis/dead-stores.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fblocks -std=c++11 -analyze -analyzer-checker=deadcode.DeadStores -verify -Wno-unreachable-code %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fblocks '-std=c++11' -analyze '-analyzer-store=region' '-analyzer-constraints=range' '-analyzer-checker=deadcode.DeadStores' -verify -Wno-unreachable-code ${LLVM_SRC}/llvm/tools/clang/test/Analysis/dead-stores.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fblocks -std=c++11 -analyze -analyzer-store=region -analyzer-constraints=range -analyzer-checker=deadcode.DeadStores -verify -Wno-unreachable-code %s");
  }

  @Test
  public void test_dead_stores_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/dead-stores.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core' '-analyzer-checker=deadcode.DeadStores,osx.cocoa.RetainCount' -fblocks -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/dead-stores.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core -analyzer-checker=deadcode.DeadStores,osx.cocoa.RetainCount -fblocks -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_debug_CallGraph_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/debug-CallGraph.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=debug.DumpCallGraph' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/debug-CallGraph.c -fblocks 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/debug-CallGraph.c
    RUN("%clang_cc1 -analyze -analyzer-checker=debug.DumpCallGraph %s -fblocks 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_default_analyze_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/default-analyze.m");
    // ${LLVM_SRC}/build/bin/clang --analyze ${LLVM_SRC}/llvm/tools/clang/test/Analysis/default-analyze.m -o ${TEST_TEMP_DIR}/default-analyze.m.tmp
    RUN("%clang --analyze %s -o %t");
  }

  @Test
  public void test_default_diagnostic_visitors_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/default-diagnostic-visitors.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core' '-analyzer-store=region' '-analyzer-output=text' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/default-diagnostic-visitors.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core -analyzer-store=region -analyzer-output=text -verify %s");
  }

  @Test
  public void test_delayed_template_parsing_crash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/delayed-template-parsing-crash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-std=c++11' -fdelayed-template-parsing -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/delayed-template-parsing-crash.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core -std=c++11 -fdelayed-template-parsing -verify %s");
  }

  @Test
  public void test_delegates_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/delegates.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.RetainCount' '-analyzer-store=region' -Wno-objc-root-class -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/delegates.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.RetainCount -analyzer-store=region -Wno-objc-root-class -verify %s");
  }

  @Test
  public void test_derived_to_base_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/derived-to-base.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/derived-to-base.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' '-DCONSTRUCTORS=1' -analyzer-config 'c++-inlining=constructors' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/derived-to-base.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -DCONSTRUCTORS=1 -analyzer-config c++-inlining=constructors -verify %s");
  }

  @Test
  public void test_designated_initializer_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/designated-initializer.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=debug.DumpCFG' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/designated-initializer.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/designated-initializer.c
    RUN("%clang_cc1 -analyze -analyzer-checker=debug.DumpCFG %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_disable_all_checks_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/disable-all-checks.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-store=region' -analyzer-disable-all-checks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/disable-all-checks.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-store=region -analyzer-disable-all-checks -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze -analyzer-disable-all-checks '-analyzer-checker=core' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/disable-all-checks.c
    RUN("%clang_cc1 -analyze -analyzer-disable-all-checks -analyzer-checker=core -analyzer-store=region -verify %s");
    // ${LLVM_SRC}/build/bin/clang --analyze -Xanalyzer -analyzer-disable-all-checks -Xclang -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/disable-all-checks.c
    RUN("%clang --analyze -Xanalyzer -analyzer-disable-all-checks -Xclang -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-store=region' -analyzer-disable-checker -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/disable-all-checks.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/disable-all-checks.c
    RUN("not %clang_cc1 -analyze -analyzer-checker=core -analyzer-store=region -analyzer-disable-checker -verify %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_div_zero_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/div-zero.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core.DivideZero' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/div-zero.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core.DivideZero -verify %s");
  }

  @Test
  public void test_division_by_zero_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/division-by-zero.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=unix.Malloc' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/division-by-zero.c
    RUN("%clang_cc1 -analyze -analyzer-checker=unix.Malloc %s");
  }

  @Test
  public void test_domtest_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/domtest.c");
    // rm -f ${TEST_TEMP_DIR}/domtest.c.tmp
    RUN(TestState.Failed, "rm -f %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=debug.DumpDominators' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/domtest.c > ${TEST_TEMP_DIR}/domtest.c.tmp 2>&1
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=debug.DumpDominators %s > %t 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/domtest.c.tmp" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/domtest.c
    RUN(TestState.Failed, "FileCheck --input-file=%t %s");
  }

  @Test
  public void test_dtor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/dtor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc,debug.ExprInspection,cplusplus' -analyzer-config 'c++-inlining=destructors,cfg-temporary-dtors=true' -Wno-null-dereference -Wno-inaccessible-base -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/dtor.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,unix.Malloc,debug.ExprInspection,cplusplus -analyzer-config c++-inlining=destructors,cfg-temporary-dtors=true -Wno-null-dereference -Wno-inaccessible-base -verify %s");
  }

  @Test
  public void test_dtor_cxx11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/dtor-cxx11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-std=c++11' '-analyzer-checker=core,unix.Malloc,debug.ExprInspection' -analyzer-config 'cfg-temporary-dtors=true' -Wno-null-dereference -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/dtor-cxx11.cpp
    RUN(TestState.SemanticErrors/*NPE in SVal::getAsLocSymbol*/, "%clang_cc1 -analyze -std=c++11 -analyzer-checker=core,unix.Malloc,debug.ExprInspection -analyzer-config cfg-temporary-dtors=true -Wno-null-dereference -verify %s");
  }

  @Test
  public void test_dtors_in_dtor_cfg_output_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/dtors-in-dtor-cfg-output.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=debug.DumpCFG' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/dtors-in-dtor-cfg-output.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/dtors-in-dtor-cfg-output.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=debug.DumpCFG %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_dynamic_cast_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/dynamic-cast.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -analyze '-analyzer-checker=core,debug.ExprInspection' -analyzer-config 'ipa=none' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/dynamic-cast.cpp
    RUN("%clang_cc1 -triple i386-apple-darwin10 -analyze -analyzer-checker=core,debug.ExprInspection -analyzer-config ipa=none -verify %s");
  }

  @Test
  public void test_dynamic_type_check_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/dynamic_type_check.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core.DynamicTypeChecker' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/dynamic_type_check.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core.DynamicTypeChecker -verify %s");
  }

  @Test
  public void test_edges_new_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/edges-new.mm");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-darwin10 --analyze -Xclang -analyzer-config -Xclang 'path-diagnostics-alternate=true' -Xclang '-analyzer-output=plist' -o ${TEST_TEMP_DIR}/edges-new.mm.tmp ${LLVM_SRC}/llvm/tools/clang/test/Analysis/edges-new.mm
    RUN(TestState.Failed, "%clang -target x86_64-apple-darwin10 --analyze -Xclang -analyzer-config -Xclang path-diagnostics-alternate=true -Xclang -analyzer-output=plist -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck --input-file ${TEST_TEMP_DIR}/edges-new.mm.tmp ${LLVM_SRC}/llvm/tools/clang/test/Analysis/edges-new.mm
    RUN(TestState.Failed, "FileCheck --input-file %t %s");
  }

  @Test
  public void test_elementtype_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/elementtype.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core' '-analyzer-store=region' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/elementtype.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core -analyzer-store=region %s");
  }

  @Test
  public void test_enum_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/enum.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-std=c++11' '-analyzer-checker=debug.ExprInspection' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/enum.cpp
    RUN("%clang_cc1 -analyze -std=c++11 -analyzer-checker=debug.ExprInspection %s");
  }

  @Test
  public void test_exceptions_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/exceptions.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze -fexceptions -fobjc-exceptions -fcxx-exceptions '-analyzer-checker=core,unix.Malloc,debug.ExprInspection' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/exceptions.mm
    RUN("%clang_cc1 -analyze -fexceptions -fobjc-exceptions -fcxx-exceptions -analyzer-checker=core,unix.Malloc,debug.ExprInspection -verify %s");
  }

  @Test
  public void test_exercise_ps_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/exercise-ps.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/exercise-ps.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core -analyzer-store=region -verify %s");
  }

  @Test
  public void test_explain_svals_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/explain-svals.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -analyze '-analyzer-checker=core.builtin,debug.ExprInspection,unix.cstring' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/explain-svals.cpp
    RUN("%clang_cc1 -triple i386-apple-darwin10 -analyze -analyzer-checker=core.builtin,debug.ExprInspection,unix.cstring -verify %s");
  }

  @Test
  public void test_fields_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/fields.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core,debug.ExprInspection' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/fields.c '-analyzer-store=region' -verify
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core,debug.ExprInspection %s -analyzer-store=region -verify");
  }

  @Test
  public void test_free_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/free.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-store=region' '-analyzer-checker=core,unix.Malloc' -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/free.c
    RUN("%clang_cc1 -analyze -analyzer-store=region -analyzer-checker=core,unix.Malloc -fblocks -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-store=region' '-analyzer-checker=core,unix.Malloc' -fblocks -verify -analyzer-config 'unix.Malloc:Optimistic=true' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/free.c
    RUN("%clang_cc1 -analyze -analyzer-store=region -analyzer-checker=core,unix.Malloc -fblocks -verify -analyzer-config unix.Malloc:Optimistic=true %s");
  }

  @Test
  public void test_func_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/func.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core,debug.ExprInspection' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/func.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core,debug.ExprInspection -analyzer-store=region -verify %s");
  }

  @Test
  public void test_generics_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/generics.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.ObjCGenerics,alpha.core.DynamicTypeChecker' -verify -Wno-objc-method-access ${LLVM_SRC}/llvm/tools/clang/test/Analysis/generics.m
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.ObjCGenerics,alpha.core.DynamicTypeChecker -verify -Wno-objc-method-access %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.ObjCGenerics,alpha.core.DynamicTypeChecker' -verify -Wno-objc-method-access ${LLVM_SRC}/llvm/tools/clang/test/Analysis/generics.m '-analyzer-output=plist' -o ${TEST_TEMP_DIR}/generics.m.tmp.plist
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.ObjCGenerics,alpha.core.DynamicTypeChecker -verify -Wno-objc-method-access %s -analyzer-output=plist -o %t.plist");
    // ${LLVM_SRC}/build/bin/FileCheck --input-file ${TEST_TEMP_DIR}/generics.m.tmp.plist ${LLVM_SRC}/llvm/tools/clang/test/Analysis/generics.m
    RUN(TestState.Failed, "FileCheck --input-file %t.plist %s");
  }

  @Test
  public void test_global_region_invalidation_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/global-region-invalidation.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze -disable-free -analyzer-eagerly-assume '-analyzer-checker=core,deadcode,alpha.security.taint,debug.TaintTest,debug.ExprInspection' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/global-region-invalidation.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -analyze -disable-free -analyzer-eagerly-assume -analyzer-checker=core,deadcode,alpha.security.taint,debug.TaintTest,debug.ExprInspection -verify %s");
  }

  @Test
  public void test_global_region_invalidation_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/global_region_invalidation.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core,debug.ExprInspection' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/global_region_invalidation.mm
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core,debug.ExprInspection -verify %s");
  }

  @Test
  public void test_html_diags_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/html-diags.c");
    // rm -fR ${TEST_TEMP_DIR}/dir
    RUN("rm -fR %T/dir");
    // mkdir ${TEST_TEMP_DIR}/dir
    RUN("mkdir %T/dir");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-output=html' '-analyzer-checker=core' -o ${TEST_TEMP_DIR}/dir ${LLVM_SRC}/llvm/tools/clang/test/Analysis/html-diags.c
    RUN("%clang_cc1 -analyze -analyzer-output=html -analyzer-checker=core -o %T/dir %s");
    // ls ${TEST_TEMP_DIR}/dir | grep report
    RUN("ls %T/dir")./*|*/
      I("grep report");
    // cd ${TEST_TEMP_DIR}/dir
    RUN("cd %T/dir");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-output=html' '-analyzer-checker=core' -o testrelative ${LLVM_SRC}/llvm/tools/clang/test/Analysis/html-diags.c
    RUN("%clang_cc1 -analyze -analyzer-output=html -analyzer-checker=core -o testrelative %s");
    // ls ${TEST_TEMP_DIR}/dir/testrelative | grep report
    RUN("ls %T/dir/testrelative")./*|*/
      I("grep report");
  }

  @Test
  public void test_html_diags_multifile_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/html-diags-multifile.c");
    // mkdir -p ${TEST_TEMP_DIR}/html-diags-multifile.c.tmp.dir
    RUN("mkdir -p %t.dir");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-output=html' '-analyzer-checker=core' -o ${TEST_TEMP_DIR}/html-diags-multifile.c.tmp.dir ${LLVM_SRC}/llvm/tools/clang/test/Analysis/html-diags-multifile.c
    RUN("%clang_cc1 -analyze -analyzer-output=html -analyzer-checker=core -o %t.dir %s");
    // ls ${TEST_TEMP_DIR}/html-diags-multifile.c.tmp.dir | not grep report
    RUN("ls %t.dir")./*|*/
      I("not grep report");
    // rm -fR ${TEST_TEMP_DIR}/html-diags-multifile.c.tmp.dir
    RUN("rm -fR %t.dir");
  }

  @Test
  public void test_identical_expressions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/identical-expressions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core.IdenticalExpr' -w -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/identical-expressions.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core.IdenticalExpr -w -verify %s");
  }

  @Test
  public void test_index_type_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/index-type.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core,alpha.security.ArrayBoundV2' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/index-type.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core,alpha.security.ArrayBoundV2 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -analyze '-analyzer-checker=core,alpha.security.ArrayBoundV2' -DM32 -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/index-type.c
    RUN("%clang_cc1 -triple i386-apple-darwin10 -analyze -analyzer-checker=core,alpha.security.ArrayBoundV2 -DM32 -verify %s");
  }

  @Test
  public void test_initializer_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/initializer.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc,debug.ExprInspection' -analyzer-config 'c++-inlining=constructors' '-std=c++11' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/initializer.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,unix.Malloc,debug.ExprInspection -analyzer-config c++-inlining=constructors -std=c++11 -verify %s");
  }

  @Test
  public void test_initializers_cfg_output_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/initializers-cfg-output.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -analyze '-analyzer-checker=debug.DumpCFG' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/initializers-cfg-output.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/initializers-cfg-output.cpp
    RUN("%clang_cc1 -std=c++11 -analyze -analyzer-checker=debug.DumpCFG %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_inline_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inline.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inline.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -verify %s");
  }

  @Test
  public void test_inline_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inline.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc,debug.ExprInspection' -analyzer-config 'ipa=inlining' -analyzer-config 'c++-allocator-inlining=true' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inline.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,unix.Malloc,debug.ExprInspection -analyzer-config ipa=inlining -analyzer-config c++-allocator-inlining=true -verify %s");
  }

  @Test
  public void test_inline_not_supported_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inline-not-supported.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -analyze '-analyzer-checker=core' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inline-not-supported.c
    RUN("%clang_cc1 -fblocks -analyze -analyzer-checker=core -verify %s");
  }

  @Test
  public void test_inline_plist_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inline-plist.c");
    // ${LLVM_SRC}/build/bin/clang --analyze ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inline-plist.c -fblocks -Xanalyzer '-analyzer-output=text' -Xanalyzer -analyzer-config -Xanalyzer 'suppress-null-return-paths=false' -Xclang -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inline-plist.c
    RUN(TestState.Failed, "%clang --analyze %s -fblocks -Xanalyzer -analyzer-output=text -Xanalyzer -analyzer-config -Xanalyzer suppress-null-return-paths=false -Xclang -verify %s");
    // ${LLVM_SRC}/build/bin/clang --analyze ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inline-plist.c -fblocks -Xanalyzer -analyzer-config -Xanalyzer 'suppress-null-return-paths=false' -Xanalyzer -analyzer-config -Xanalyzer 'path-diagnostics-alternate=false' -o ${TEST_TEMP_DIR}/inline-plist.c.tmp
    RUN(TestState.Failed, "%clang --analyze %s -fblocks -Xanalyzer -analyzer-config -Xanalyzer suppress-null-return-paths=false -Xanalyzer -analyzer-config -Xanalyzer path-diagnostics-alternate=false -o %t");
    // ${LLVM_SRC}/build/bin/FileCheck -input-file ${TEST_TEMP_DIR}/inline-plist.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inline-plist.c
    RUN(TestState.Failed, "FileCheck -input-file %t %s");
  }

  @Test
  public void test_inline_unique_reports_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inline-unique-reports.c");
    // ${LLVM_SRC}/build/bin/clang --analyze ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inline-unique-reports.c -Xanalyzer -analyzer-config -Xanalyzer 'path-diagnostics-alternate=false' -o ${TEST_TEMP_DIR}/inline-unique-reports.c.tmp > /dev/null 2>&1
    RUN(TestState.Failed, "%clang --analyze %s -Xanalyzer -analyzer-config -Xanalyzer path-diagnostics-alternate=false -o %t > /dev/null 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck -input-file ${TEST_TEMP_DIR}/inline-unique-reports.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inline-unique-reports.c
    RUN(TestState.Failed, "FileCheck -input-file %t %s");
  }

  @Test
  public void test_inline2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inline2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inline2.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core -verify %s");
  }

  @Test
  public void test_inline3_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inline3.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inline3.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core -verify %s");
  }

  @Test
  public void test_inline4_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inline4.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inline4.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core -verify %s");
  }

  @Test
  public void test_ivars_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/ivars.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' '-analyzer-store=region' -fblocks -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/ivars.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -analyzer-store=region -fblocks -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_keychainAPI_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/keychainAPI.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=osx.SecKeychainAPI' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/keychainAPI.m -verify
    RUN("%clang_cc1 -analyze -analyzer-checker=osx.SecKeychainAPI %s -verify");
  }

  @Test
  public void test_keychainAPI_diagnostic_visitor_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/keychainAPI-diagnostic-visitor.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=osx.SecKeychainAPI' '-analyzer-store=region' '-analyzer-output=text' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/keychainAPI-diagnostic-visitor.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=osx.SecKeychainAPI -analyzer-store=region -analyzer-output=text -verify %s");
  }

  @Test
  public void test_kmalloc_linux_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/kmalloc-linux.c");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-unknown-linux --analyze ${LLVM_SRC}/llvm/tools/clang/test/Analysis/kmalloc-linux.c
    RUN("%clang -target x86_64-unknown-linux --analyze %s");
  }

  @Test
  public void test_lambda_notes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/lambda-notes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -fsyntax-only -analyze '-analyzer-checker=core' -analyzer-config 'inline-lambdas=true' -analyzer-output plist -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/lambda-notes.cpp -o ${TEST_TEMP_DIR}/lambda-notes.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fsyntax-only -analyze -analyzer-checker=core -analyzer-config inline-lambdas=true -analyzer-output plist -verify %s -o %t");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/lambda-notes.cpp.tmp" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/lambda-notes.cpp
    RUN(TestState.Failed, "FileCheck --input-file=%t %s");
  }

  @Test
  public void test_lambdas_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/lambdas.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -fsyntax-only -analyze '-analyzer-checker=core,deadcode,debug.ExprInspection' -analyzer-config 'inline-lambdas=true' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/lambdas.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fsyntax-only -analyze -analyzer-checker=core,deadcode,debug.ExprInspection -analyzer-config inline-lambdas=true -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -fsyntax-only -analyze '-analyzer-checker=core,debug.DumpCFG' -analyzer-config 'inline-lambdas=true' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/lambdas.cpp > ${TEST_TEMP_DIR}/lambdas.cpp.tmp 2>&1
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fsyntax-only -analyze -analyzer-checker=core,debug.DumpCFG -analyzer-config inline-lambdas=true %s > %t 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/lambdas.cpp.tmp" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/lambdas.cpp
    RUN(TestState.Failed, "FileCheck --input-file=%t %s");
  }

  @Test
  public void test_lambdas_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/lambdas.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -fsyntax-only -fblocks -Wno-objc-root-class -analyze '-analyzer-checker=core,deadcode,debug.ExprInspection' -analyzer-config 'inline-lambdas=true' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/lambdas.mm
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fsyntax-only -fblocks -Wno-objc-root-class -analyze -analyzer-checker=core,deadcode,debug.ExprInspection -analyzer-config inline-lambdas=true -verify %s");
  }

  @Test
  public void test_lambdas_generalized_capture_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/lambdas-generalized-capture.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++14' -fsyntax-only -analyze '-analyzer-checker=core,deadcode,debug.ExprInspection' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/lambdas-generalized-capture.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++14 -fsyntax-only -analyze -analyzer-checker=core,deadcode,debug.ExprInspection -verify %s");
  }

  @Test
  public void test_live_variables_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/live-variables.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/live-variables.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core -verify %s");
  }

  @Test
  public void test_live_variables_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/live-variables.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -fobjc-arc -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/live-variables.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core -fobjc-arc -verify %s");
  }

  @Test
  public void test_localization_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/localization.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze -fblocks '-analyzer-store=region' '-analyzer-output=text' '-analyzer-checker=optin.osx.cocoa.localizability.NonLocalizedStringChecker' '-analyzer-checker=alpha.osx.cocoa.localizability.PluralMisuseChecker' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/localization.m
    RUN(TestState.Failed, "%clang_cc1 -analyze -fblocks -analyzer-store=region -analyzer-output=text -analyzer-checker=optin.osx.cocoa.localizability.NonLocalizedStringChecker -analyzer-checker=alpha.osx.cocoa.localizability.PluralMisuseChecker -verify  %s");
  }

  @Test
  public void test_localization_aggressive_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/localization-aggressive.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze -fblocks '-analyzer-store=region' '-analyzer-checker=optin.osx.cocoa.localizability.NonLocalizedStringChecker' '-analyzer-checker=optin.osx.cocoa.localizability.EmptyLocalizationContextChecker' -verify -analyzer-config 'AggressiveReport=true' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/localization-aggressive.m
    RUN("%clang_cc1 -analyze -fblocks -analyzer-store=region  -analyzer-checker=optin.osx.cocoa.localizability.NonLocalizedStringChecker -analyzer-checker=optin.osx.cocoa.localizability.EmptyLocalizationContextChecker -verify  -analyzer-config AggressiveReport=true %s");
  }

  @Test
  public void test_logical_ops_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/logical-ops.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-pointer-bool-conversion -analyze '-analyzer-checker=core,debug.ExprInspection' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/logical-ops.c
    RUN("%clang_cc1 -Wno-pointer-bool-conversion -analyze -analyzer-checker=core,debug.ExprInspection -verify %s");
  }

  @Test
  public void test_loop_widening_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/loop-widening.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc,debug.ExprInspection' -analyzer-max-loop 4 -analyzer-config 'widen-loops=true' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/loop-widening.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix.Malloc,debug.ExprInspection -analyzer-max-loop 4 -analyzer-config widen-loops=true -verify %s");
  }

  @Test
  public void test_lvalue_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/lvalue.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/lvalue.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-store=region -verify %s");
  }

  @Test
  public void test_malloc_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.deadcode.UnreachableCode,alpha.core.CastSize,unix.Malloc,debug.ExprInspection' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.deadcode.UnreachableCode,alpha.core.CastSize,unix.Malloc,debug.ExprInspection -analyzer-store=region -verify %s");
  }

  @Test
  public void test_malloc_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.deadcode.UnreachableCode,alpha.core.CastSize,unix.Malloc' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.deadcode.UnreachableCode,alpha.core.CastSize,unix.Malloc -analyzer-store=region -verify %s");
  }

  @Test
  public void test_malloc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc' '-analyzer-store=region' -verify -Wno-objc-root-class -fblocks ${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix.Malloc -analyzer-store=region -verify -Wno-objc-root-class -fblocks %s");
  }

  @Test
  public void test_malloc_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc' '-analyzer-store=region' -verify -fblocks ${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc.mm
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix.Malloc -analyzer-store=region -verify -fblocks %s");
  }

  @Test
  public void test_malloc_annotations_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc-annotations.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.deadcode.UnreachableCode,alpha.core.CastSize,unix.Malloc' '-analyzer-store=region' -verify -analyzer-config 'unix.Malloc:Optimistic=true' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc-annotations.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.deadcode.UnreachableCode,alpha.core.CastSize,unix.Malloc -analyzer-store=region -verify -analyzer-config unix.Malloc:Optimistic=true %s");
  }

  @Test
  public void test_malloc_interprocedural_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc-interprocedural.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=unix.Malloc' '-analyzer-inline-max-stack-depth=5' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc-interprocedural.c
    RUN("%clang_cc1 -analyze -analyzer-checker=unix.Malloc -analyzer-inline-max-stack-depth=5 -verify %s");
  }

  @Test
  public void test_malloc_overflow_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc-overflow.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=alpha.security.MallocOverflow' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc-overflow.c
    RUN("%clang_cc1 -analyze -analyzer-checker=alpha.security.MallocOverflow -verify %s");
  }

  @Test
  public void test_malloc_overflow_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc-overflow.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=alpha.security.MallocOverflow' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc-overflow.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=alpha.security.MallocOverflow -verify %s");
  }

  @Test
  public void test_malloc_overflow2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc-overflow2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -analyze '-analyzer-checker=alpha.security.MallocOverflow,unix' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc-overflow2.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -analyze -analyzer-checker=alpha.security.MallocOverflow,unix -verify %s");
  }

  @Test
  public void test_malloc_plist_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc-plist.c");
    // rm -f ${TEST_TEMP_DIR}/malloc-plist.c.tmp
    RUN("rm -f %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze -fblocks '-analyzer-checker=core,unix.Malloc' '-analyzer-output=plist' -analyzer-config 'path-diagnostics-alternate=false' -o ${TEST_TEMP_DIR}/malloc-plist.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc-plist.c
    RUN("%clang_cc1 -analyze -fblocks -analyzer-checker=core,unix.Malloc -analyzer-output=plist -analyzer-config path-diagnostics-alternate=false -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck -input-file ${TEST_TEMP_DIR}/malloc-plist.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc-plist.c
    RUN("FileCheck -input-file %t %s");
  }

  @Test
  public void test_malloc_protoype_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc-protoype.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -analyze '-analyzer-checker=core,unix.Malloc' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc-protoype.c
    RUN("%clang_cc1 -w -analyze -analyzer-checker=core,unix.Malloc -verify %s");
  }

  @Test
  public void test_malloc_sizeof_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc-sizeof.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=unix.MallocSizeof' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc-sizeof.c
    RUN("%clang_cc1 -analyze -analyzer-checker=unix.MallocSizeof -verify %s");
  }

  @Test
  public void test_malloc_sizeof_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc-sizeof.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=unix.MallocSizeof' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc-sizeof.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=unix.MallocSizeof -verify %s");
  }

  @Test
  public void test_malloc_three_arg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc-three-arg.c");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-unknown-freebsd --analyze ${LLVM_SRC}/llvm/tools/clang/test/Analysis/malloc-three-arg.c
    RUN("%clang -target x86_64-unknown-freebsd --analyze %s");
  }

  @Test
  public void test_member_expr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/member-expr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/member-expr.cpp -verify
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection %s -verify");
  }

  @Test
  public void test_method_arg_decay_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/method-arg-decay.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-analyzer-checker=core' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/method-arg-decay.m -Wno-incomplete-implementation
    RUN("%clang_cc1 -analyzer-checker=core -verify %s -Wno-incomplete-implementation");
  }

  @Test
  public void test_method_call_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/method-call.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -analyzer-config 'c++-inlining=constructors' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/method-call.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -analyzer-config c++-inlining=constructors -verify %s");
  }

  @Test
  public void test_method_call_intra_p_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/method-call-intra-p.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -analyzer-store region -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/method-call-intra-p.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-store region -verify %s");
  }

  @Test
  public void test_method_call_path_notes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/method-call-path-notes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=text' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/method-call-path-notes.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=text -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=plist-multi-file' -analyzer-config 'path-diagnostics-alternate=false' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/method-call-path-notes.cpp -o ${TEST_TEMP_DIR}/method-call-path-notes.cpp.tmp.plist
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=plist-multi-file -analyzer-config path-diagnostics-alternate=false %s -o %t.plist");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/method-call-path-notes.cpp.tmp.plist" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/method-call-path-notes.cpp
    RUN(TestState.Failed, "FileCheck --input-file=%t.plist %s");
  }

  @Test
  public void test_misc_ps_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze -disable-free -analyzer-eagerly-assume '-analyzer-checker=core,deadcode,debug.ExprInspection' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -analyze -disable-free -analyzer-eagerly-assume -analyzer-checker=core,deadcode,debug.ExprInspection -verify %s");
  }

  @Test
  public void test_misc_ps_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -analyze '-analyzer-checker=core,alpha.core,osx.cocoa.AtSync' '-analyzer-store=region' '-analyzer-constraints=range' -verify -fblocks -Wno-unreachable-code -Wno-null-dereference -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps.m
    RUN("%clang_cc1 -triple i386-apple-darwin10 -analyze -analyzer-checker=core,alpha.core,osx.cocoa.AtSync -analyzer-store=region -analyzer-constraints=range -verify -fblocks -Wno-unreachable-code -Wno-null-dereference -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core,alpha.core,osx.cocoa.AtSync' '-analyzer-store=region' '-analyzer-constraints=range' -verify -fblocks -Wno-unreachable-code -Wno-null-dereference -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core,alpha.core,osx.cocoa.AtSync -analyzer-store=region -analyzer-constraints=range -verify -fblocks -Wno-unreachable-code -Wno-null-dereference -Wno-objc-root-class %s");
  }

  @Test
  public void test_misc_ps_64_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-64.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -analyze '-analyzer-checker=core,alpha.core' '-analyzer-store=region' '-analyzer-constraints=range' -verify -fblocks ${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-64.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 -analyze -analyzer-checker=core,alpha.core -analyzer-store=region -analyzer-constraints=range -verify -fblocks %s");
  }

  @Test
  public void test_misc_ps_arm_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-arm.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-apple-ios0.0.0 -target-feature +neon -analyze '-analyzer-checker=core' '-analyzer-store=region' -verify -fblocks -analyzer-opt-analyze-nested-blocks -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-arm.m
    RUN("%clang_cc1 -triple thumbv7-apple-ios0.0.0 -target-feature +neon -analyze -analyzer-checker=core -analyzer-store=region -verify -fblocks -analyzer-opt-analyze-nested-blocks -Wno-objc-root-class %s");
  }

  @Test
  public void test_misc_ps_cxx0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-cxx0x.cpp");
    // ${LLVM_SRC}/build/bin/clang --analyze '-std=c++11' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-cxx0x.cpp -Xclang -verify -o /dev/null
    RUN("%clang --analyze -std=c++11 %s -Xclang -verify -o /dev/null");
  }

  @Test
  public void test_misc_ps_eager_assume_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-eager-assume.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core' '-analyzer-store=region' '-analyzer-constraints=range' -verify -fblocks ${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-eager-assume.m -analyzer-eagerly-assume
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core -analyzer-store=region -analyzer-constraints=range -verify -fblocks %s -analyzer-eagerly-assume");
  }

  @Test
  public void test_misc_ps_ranges_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-ranges.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core' '-analyzer-store=region' '-analyzer-constraints=range' -verify -fblocks ${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-ranges.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core -analyzer-store=region -analyzer-constraints=range -verify -fblocks %s");
  }

  @Test
  public void test_misc_ps_region_store_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-region-store.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -analyze '-analyzer-checker=core,alpha.core,debug.ExprInspection' '-analyzer-store=region' -verify -fblocks -analyzer-opt-analyze-nested-blocks ${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-region-store.cpp -fexceptions -fcxx-exceptions -Wno-tautological-undefined-compare
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -analyze -analyzer-checker=core,alpha.core,debug.ExprInspection -analyzer-store=region -verify -fblocks -analyzer-opt-analyze-nested-blocks %s -fexceptions -fcxx-exceptions -Wno-tautological-undefined-compare");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -analyze '-analyzer-checker=core,alpha.core,debug.ExprInspection' '-analyzer-store=region' -verify -fblocks -analyzer-opt-analyze-nested-blocks ${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-region-store.cpp -fexceptions -fcxx-exceptions -Wno-tautological-undefined-compare
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -analyze -analyzer-checker=core,alpha.core,debug.ExprInspection -analyzer-store=region -verify -fblocks -analyzer-opt-analyze-nested-blocks %s -fexceptions -fcxx-exceptions -Wno-tautological-undefined-compare");
  }

  @Test
  public void test_misc_ps_region_store_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-region-store.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -analyze '-analyzer-checker=core,alpha.core.CastToStruct,alpha.security.ReturnPtrRange,alpha.security.ArrayBound' '-analyzer-store=region' -verify -fblocks -analyzer-opt-analyze-nested-blocks -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-region-store.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -analyze -analyzer-checker=core,alpha.core.CastToStruct,alpha.security.ReturnPtrRange,alpha.security.ArrayBound -analyzer-store=region -verify -fblocks -analyzer-opt-analyze-nested-blocks -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -DTEST_64 -analyze '-analyzer-checker=core,alpha.core.CastToStruct,alpha.security.ReturnPtrRange,alpha.security.ArrayBound' '-analyzer-store=region' -verify -fblocks -analyzer-opt-analyze-nested-blocks -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-region-store.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -DTEST_64 -analyze -analyzer-checker=core,alpha.core.CastToStruct,alpha.security.ReturnPtrRange,alpha.security.ArrayBound -analyzer-store=region -verify -fblocks   -analyzer-opt-analyze-nested-blocks -Wno-objc-root-class %s");
  }

  @Test
  public void test_misc_ps_region_store_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-region-store.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -analyze '-analyzer-checker=core,alpha.core' '-analyzer-store=region' -verify -fblocks -analyzer-opt-analyze-nested-blocks ${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-region-store.mm
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -analyze -analyzer-checker=core,alpha.core -analyzer-store=region -verify -fblocks -analyzer-opt-analyze-nested-blocks %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -analyze '-analyzer-checker=core,alpha.core' '-analyzer-store=region' -verify -fblocks -analyzer-opt-analyze-nested-blocks ${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-region-store.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -analyze -analyzer-checker=core,alpha.core -analyzer-store=region -verify -fblocks   -analyzer-opt-analyze-nested-blocks %s");
  }

  @Test
  public void test_misc_ps_region_store_i386_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-region-store-i386.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -analyze '-analyzer-checker=core,alpha.core' '-analyzer-store=region' -verify -fblocks ${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-region-store-i386.m
    RUN("%clang_cc1 -triple i386-apple-darwin9 -analyze -analyzer-checker=core,alpha.core -analyzer-store=region -verify -fblocks %s");
  }

  @Test
  public void test_misc_ps_region_store_x86_64_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-region-store-x86_64.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -analyze '-analyzer-checker=core,alpha.core' '-analyzer-store=region' -verify -fblocks ${LLVM_SRC}/llvm/tools/clang/test/Analysis/misc-ps-region-store-x86_64.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 -analyze -analyzer-checker=core,alpha.core -analyzer-store=region -verify -fblocks %s");
  }

  @Test
  public void test_model_file_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/model-file.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -analyzer-config "faux-bodies=true,model-path=${LLVM_SRC}/llvm/tools/clang/test/Analysis/Inputs/Models" '-analyzer-output=plist-multi-file' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/model-file.cpp -o ${TEST_TEMP_DIR}/model-file.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-config faux-bodies=true,model-path=%S/Inputs/Models -analyzer-output=plist-multi-file -verify %s -o %t");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/model-file.cpp.tmp" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/model-file.cpp
    RUN(TestState.Failed, "FileCheck --input-file=%t %s");
  }

  @Test
  public void test_mpichecker_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/mpichecker.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=optin.mpi.MPI-Checker' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/mpichecker.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=optin.mpi.MPI-Checker -verify %s");
  }

  @Test
  public void test_mpicheckernotes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/mpicheckernotes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=optin.mpi.MPI-Checker' '-analyzer-output=text' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/mpicheckernotes.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=optin.mpi.MPI-Checker -analyzer-output=text -verify %s");
  }

  @Test
  public void test_new_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/new.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc,debug.ExprInspection' -analyzer-store region '-std=c++11' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/new.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,unix.Malloc,debug.ExprInspection -analyzer-store region -std=c++11 -verify %s");
  }

  @Test
  public void test_new_with_exceptions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/new-with-exceptions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -analyzer-store region '-std=c++11' -fexceptions -fcxx-exceptions -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/new-with-exceptions.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -analyzer-store region -std=c++11 -fexceptions -fcxx-exceptions -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -analyzer-store region '-std=c++11' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/new-with-exceptions.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -analyzer-store region -std=c++11 -verify %s");
  }

  @Test
  public void test_nil_receiver_undefined_larger_than_voidptr_ret_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/nil-receiver-undefined-larger-than-voidptr-ret.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin8 -analyze '-analyzer-checker=core,alpha.core' '-analyzer-constraints=range' '-analyzer-store=region' -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/nil-receiver-undefined-larger-than-voidptr-ret.m > ${TEST_TEMP_DIR}/nil-receiver-undefined-larger-than-voidptr-ret.m.tmp.1 2>&1
    RUN("%clang_cc1 -triple i386-apple-darwin8 -analyze -analyzer-checker=core,alpha.core -analyzer-constraints=range -analyzer-store=region -Wno-objc-root-class %s > %t.1 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck "-input-file=${TEST_TEMP_DIR}/nil-receiver-undefined-larger-than-voidptr-ret.m.tmp.1" '-check-prefix=CHECK-darwin8' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/nil-receiver-undefined-larger-than-voidptr-ret.m
    RUN("FileCheck -input-file=%t.1 -check-prefix=CHECK-darwin8 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -analyze '-analyzer-checker=core,alpha.core' '-analyzer-constraints=range' '-analyzer-store=region' -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/nil-receiver-undefined-larger-than-voidptr-ret.m > ${TEST_TEMP_DIR}/nil-receiver-undefined-larger-than-voidptr-ret.m.tmp.2 2>&1
    RUN("%clang_cc1 -triple i386-apple-darwin9 -analyze -analyzer-checker=core,alpha.core -analyzer-constraints=range -analyzer-store=region -Wno-objc-root-class %s > %t.2 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck "-input-file=${TEST_TEMP_DIR}/nil-receiver-undefined-larger-than-voidptr-ret.m.tmp.2" '-check-prefix=CHECK-darwin9' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/nil-receiver-undefined-larger-than-voidptr-ret.m
    RUN("FileCheck -input-file=%t.2 -check-prefix=CHECK-darwin9 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv6-apple-ios4.0 -analyze '-analyzer-checker=core,alpha.core' '-analyzer-constraints=range' '-analyzer-store=region' -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/nil-receiver-undefined-larger-than-voidptr-ret.m > ${TEST_TEMP_DIR}/nil-receiver-undefined-larger-than-voidptr-ret.m.tmp.3 2>&1
    RUN("%clang_cc1 -triple thumbv6-apple-ios4.0 -analyze -analyzer-checker=core,alpha.core -analyzer-constraints=range -analyzer-store=region -Wno-objc-root-class %s > %t.3 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck "-input-file=${TEST_TEMP_DIR}/nil-receiver-undefined-larger-than-voidptr-ret.m.tmp.3" '-check-prefix=CHECK-darwin9' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/nil-receiver-undefined-larger-than-voidptr-ret.m
    RUN("FileCheck -input-file=%t.3 -check-prefix=CHECK-darwin9 %s");
  }

  @Test
  public void test_nil_receiver_undefined_larger_than_voidptr_ret_region_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/nil-receiver-undefined-larger-than-voidptr-ret-region.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin8 -analyze '-analyzer-checker=core,alpha.core' '-analyzer-constraints=range' '-analyzer-store=region' -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/nil-receiver-undefined-larger-than-voidptr-ret-region.m
    RUN("%clang_cc1 -triple i386-apple-darwin8 -analyze -analyzer-checker=core,alpha.core -analyzer-constraints=range -analyzer-store=region -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_no_exit_cfg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/no-exit-cfg.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/no-exit-cfg.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core -analyzer-store=region -verify %s");
  }

  @Test
  public void test_no_outofbounds_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/no-outofbounds.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core,alpha.unix,alpha.security.ArrayBound' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/no-outofbounds.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core,alpha.unix,alpha.security.ArrayBound -analyzer-store=region -verify %s");
  }

  @Test
  public void test_no_unreachable_dtors_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/no-unreachable-dtors.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=debug.Stats' -verify -Wno-unreachable-code ${LLVM_SRC}/llvm/tools/clang/test/Analysis/no-unreachable-dtors.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=debug.Stats -verify -Wno-unreachable-code %s");
  }

  @Test
  public void test_nonnull_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/nonnull.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -w -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/nonnull.m
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -w -verify %s");
  }

  @Test
  public void test_null_deref_path_notes_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/null-deref-path-notes.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-store=region' '-analyzer-output=text' -fblocks -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/null-deref-path-notes.m
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-store=region -analyzer-output=text -fblocks -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-store=region' '-analyzer-output=plist-multi-file' -analyzer-config 'path-diagnostics-alternate=false' -fblocks -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/null-deref-path-notes.m -o ${TEST_TEMP_DIR}/null-deref-path-notes.m.tmp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-store=region -analyzer-output=plist-multi-file -analyzer-config path-diagnostics-alternate=false -fblocks -Wno-objc-root-class %s -o %t");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/null-deref-path-notes.m.tmp" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/null-deref-path-notes.m
    RUN(TestState.Failed, "FileCheck --input-file=%t %s");
  }

  @Test
  public void test_null_deref_ps_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/null-deref-ps.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -analyze '-analyzer-checker=core,deadcode,alpha.core' '-std=gnu99' '-analyzer-store=region' '-analyzer-constraints=range' '-analyzer-purge=none' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/null-deref-ps.c '-Wno-error=return-type'
    RUN("%clang_cc1 -triple i386-apple-darwin10 -analyze -analyzer-checker=core,deadcode,alpha.core -std=gnu99 -analyzer-store=region -analyzer-constraints=range -analyzer-purge=none -verify %s -Wno-error=return-type");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -analyze '-analyzer-checker=core,deadcode,alpha.core' '-std=gnu99' '-analyzer-store=region' '-analyzer-constraints=range' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/null-deref-ps.c '-Wno-error=return-type'
    RUN("%clang_cc1 -triple i386-apple-darwin10 -analyze -analyzer-checker=core,deadcode,alpha.core -std=gnu99 -analyzer-store=region -analyzer-constraints=range -verify %s -Wno-error=return-type");
  }

  @Test
  public void test_null_deref_ps_region_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/null-deref-ps-region.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core' '-std=gnu99' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/null-deref-ps-region.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core -std=gnu99 -analyzer-store=region -verify %s");
  }

  @Test
  public void test_nullability_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/nullability.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -analyze '-analyzer-checker=core,nullability' '-DNOSYSTEMHEADERS=0' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/nullability.mm
    RUN("%clang_cc1 -fblocks -analyze -analyzer-checker=core,nullability -DNOSYSTEMHEADERS=0 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -analyze '-analyzer-checker=core,nullability' -analyzer-config 'nullability:NoDiagnoseCallsToSystemHeaders=true' '-DNOSYSTEMHEADERS=1' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/nullability.mm
    RUN("%clang_cc1 -fblocks -analyze -analyzer-checker=core,nullability -analyzer-config nullability:NoDiagnoseCallsToSystemHeaders=true -DNOSYSTEMHEADERS=1 -verify %s");
  }

  @Test
  public void test_nullability_no_arc_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/nullability-no-arc.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,nullability' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/nullability-no-arc.mm
    RUN("%clang_cc1 -analyze -analyzer-checker=core,nullability -verify %s");
  }

  @Test
  public void test_nullability_nullonly_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/nullability_nullonly.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze -fobjc-arc '-analyzer-checker=core,nullability.NullPassedToNonnull,nullability.NullReturnedFromNonnull' '-DNOSYSTEMHEADERS=0' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/nullability_nullonly.mm
    RUN("%clang_cc1 -analyze -fobjc-arc -analyzer-checker=core,nullability.NullPassedToNonnull,nullability.NullReturnedFromNonnull -DNOSYSTEMHEADERS=0 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze -fobjc-arc '-analyzer-checker=core,nullability.NullPassedToNonnull,nullability.NullReturnedFromNonnull' -analyzer-config 'nullability:NoDiagnoseCallsToSystemHeaders=true' '-DNOSYSTEMHEADERS=1' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/nullability_nullonly.mm
    RUN("%clang_cc1 -analyze -fobjc-arc -analyzer-checker=core,nullability.NullPassedToNonnull,nullability.NullReturnedFromNonnull -analyzer-config nullability:NoDiagnoseCallsToSystemHeaders=true -DNOSYSTEMHEADERS=1 -verify %s");
  }

  @Test
  public void test_nullptr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/nullptr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -Wno-conversion-null -analyze '-analyzer-checker=core,debug.ExprInspection' -analyzer-store region -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/nullptr.cpp
    RUN("%clang_cc1 -std=c++11 -Wno-conversion-null -analyze -analyzer-checker=core,debug.ExprInspection -analyzer-store region -verify %s");
  }

  @Test
  public void test_objc_arc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-arc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core,osx.cocoa.RetainCount,deadcode' -verify -fblocks -analyzer-opt-analyze-nested-blocks -fobjc-arc -analyzer-config 'path-diagnostics-alternate=true' '-analyzer-output=plist-multi-file' -o ${TEST_TEMP_DIR}/objc-arc.m.tmp.plist ${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-arc.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core,osx.cocoa.RetainCount,deadcode -verify -fblocks -analyzer-opt-analyze-nested-blocks -fobjc-arc -analyzer-config path-diagnostics-alternate=true -analyzer-output=plist-multi-file -o %t.plist %s");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/objc-arc.m.tmp.plist" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-arc.m
    RUN(TestState.Failed, "FileCheck --input-file=%t.plist %s");
  }

  @Test
  public void test_objc_bool_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-bool.m");
    // ${LLVM_SRC}/build/bin/clang --analyze ${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-bool.m -o ${TEST_TEMP_DIR}/objc-bool.m.tmp -Xclang -verify
    RUN("%clang --analyze %s -o %t -Xclang -verify");
  }

  @Test
  public void test_objc_boxing_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-boxing.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-objc-literal-conversion -analyze '-analyzer-checker=core,unix.Malloc,osx.cocoa.NonNilReturnValue,debug.ExprInspection' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-boxing.m
    RUN("%clang_cc1 -Wno-objc-literal-conversion -analyze -analyzer-checker=core,unix.Malloc,osx.cocoa.NonNilReturnValue,debug.ExprInspection -analyzer-store=region -verify %s");
  }

  @Test
  public void test_objc_for_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-for.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.Loops,debug.ExprInspection' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-for.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.Loops,debug.ExprInspection -verify %s");
  }

  @Test
  public void test_objc_message_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-message.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' '-analyzer-store=region' -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-message.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -analyzer-store=region -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objc_method_coverage_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-method-coverage.m");
    // REQUIRES: asserts
    if (!CHECK_REQUIRES("asserts")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -analyzer-stats -fblocks ${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-method-coverage.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-method-coverage.m
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-stats -fblocks %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objc_properties_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-properties.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=alpha.osx.cocoa.DirectIvarAssignment' -verify -fblocks ${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-properties.m
    RUN("%clang_cc1 -analyze -analyzer-checker=alpha.osx.cocoa.DirectIvarAssignment -verify -fblocks %s");
  }

  @Test
  public void test_objc_radar17039661_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-radar17039661.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.RetainCount' -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-radar17039661.m
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.RetainCount -fblocks -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.RetainCount' -fblocks '-analyzer-output=plist-multi-file' -analyzer-config 'path-diagnostics-alternate=false' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-radar17039661.m -o ${TEST_TEMP_DIR}/objc-radar17039661.m.tmp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.RetainCount -fblocks -analyzer-output=plist-multi-file -analyzer-config path-diagnostics-alternate=false %s -o %t");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/objc-radar17039661.m.tmp" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-radar17039661.m
    RUN(TestState.Failed, "FileCheck --input-file=%t %s");
  }

  @Test
  public void test_objc_string_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-string.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -verify -Wno-objc-literal-conversion ${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-string.mm
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -verify -Wno-objc-literal-conversion %s");
  }

  @Test
  public void test_objc_subscript_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-subscript.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.RetainCount' '-analyzer-store=region' -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc-subscript.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.RetainCount -analyzer-store=region -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objc_invalidation_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc_invalidation.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.osx.cocoa.InstanceVariableInvalidation' -DRUN_IVAR_INVALIDATION -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc_invalidation.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.osx.cocoa.InstanceVariableInvalidation -DRUN_IVAR_INVALIDATION -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.osx.cocoa.MissingInvalidationMethod' -DRUN_MISSING_INVALIDATION_METHOD -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/objc_invalidation.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.osx.cocoa.MissingInvalidationMethod -DRUN_MISSING_INVALIDATION_METHOD -verify %s");
  }

  @Test
  public void test_operator_calls_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/operator-calls.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -analyze '-analyzer-checker=core,alpha.core,debug.ExprInspection' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/operator-calls.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -analyze -analyzer-checker=core,alpha.core,debug.ExprInspection -verify %s");
  }

  @Test
  public void test_out_of_bounds_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/out-of-bounds.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-array-bounds -analyze '-analyzer-checker=core,alpha.security.ArrayBoundV2' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/out-of-bounds.c
    RUN("%clang_cc1 -Wno-array-bounds -analyze -analyzer-checker=core,alpha.security.ArrayBoundV2 -verify %s");
  }

  @Test
  public void test_outofbound_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/outofbound.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-array-bounds -analyze '-analyzer-checker=core,unix,alpha.security.ArrayBound' '-analyzer-store=region' -verify -analyzer-config 'unix:Optimistic=true' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/outofbound.c
    RUN("%clang_cc1 -Wno-array-bounds -analyze -analyzer-checker=core,unix,alpha.security.ArrayBound -analyzer-store=region -verify -analyzer-config unix:Optimistic=true %s");
  }

  @Test
  public void test_outofbound_notwork_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/outofbound-notwork.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-array-bounds -analyze '-analyzer-checker=core,alpha.security.ArrayBound' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/outofbound-notwork.c
    RUN(TestState.Failed, "%clang_cc1 -Wno-array-bounds -analyze -analyzer-checker=core,alpha.security.ArrayBound -analyzer-store=region -verify %s");
  }

  @Test
  public void test_override_werror_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/override-werror.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core' -Werror ${LLVM_SRC}/llvm/tools/clang/test/Analysis/override-werror.c '-analyzer-store=region' -verify
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core -Werror %s -analyzer-store=region -verify");
  }

  @Test
  public void test_padding_c_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/padding_c.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=optin.performance' -analyzer-config 'optin.performance.Padding:AllowedPad=2' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/padding_c.c
    RUN("%clang_cc1 -analyze -analyzer-checker=optin.performance -analyzer-config optin.performance.Padding:AllowedPad=2 -verify %s");
  }

  @Test
  public void test_padding_cpp_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/padding_cpp.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++14' -analyze '-analyzer-checker=optin.performance' -analyzer-config 'optin.performance.Padding:AllowedPad=2' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/padding_cpp.cpp
    RUN("%clang_cc1 -std=c++14 -analyze -analyzer-checker=optin.performance -analyzer-config optin.performance.Padding:AllowedPad=2 -verify %s");
  }

  @Test
  public void test_padding_message_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/padding_message.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux '-std=c++14' -analyze '-analyzer-checker=optin.performance' -analyzer-config 'optin.performance.Padding:AllowedPad=2' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/padding_message.cpp
    RUN("%clang_cc1 -triple x86_64-unknown-linux -std=c++14 -analyze -analyzer-checker=optin.performance -analyzer-config optin.performance.Padding:AllowedPad=2 -verify %s");
  }

  @Test
  public void test_plist_html_macros_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/plist-html-macros.c");
    // REQUIRES: shell
    if (!CHECK_REQUIRES("shell")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/plist-html-macros.c
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -verify %s");
    // rm -rf ${TEST_TEMP_DIR}/plist-html-macros.c.tmp.dir
    RUN(TestState.Failed, "rm -rf %t.dir");
    // mkdir -p ${TEST_TEMP_DIR}/plist-html-macros.c.tmp.dir
    RUN(TestState.Failed, "mkdir -p %t.dir");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=plist-html' -o ${TEST_TEMP_DIR}/plist-html-macros.c.tmp.dir/index.plist ${LLVM_SRC}/llvm/tools/clang/test/Analysis/plist-html-macros.c
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=plist-html -o %t.dir/index.plist %s");
    // ls ${TEST_TEMP_DIR}/plist-html-macros.c.tmp.dir | grep \\.html | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "ls %t.dir")./*|*/
      I("grep \\\\.html")./*|*/
      I("count 1");
    // grep \\.html ${TEST_TEMP_DIR}/plist-html-macros.c.tmp.dir/index.plist | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "grep \\\\.html %t.dir/index.plist")./*|*/
      I("count 1");
  }

  @Test
  public void test_plist_macros_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/plist-macros.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix' -analyzer-eagerly-assume -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/plist-macros.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix -analyzer-eagerly-assume -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix' -analyzer-eagerly-assume '-analyzer-output=plist-multi-file' -analyzer-config 'path-diagnostics-alternate=ture' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/plist-macros.cpp -o ${TEST_TEMP_DIR}/plist-macros.cpp.tmp.plist
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,unix -analyzer-eagerly-assume -analyzer-output=plist-multi-file -analyzer-config path-diagnostics-alternate=ture %s -o %t.plist");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/plist-macros.cpp.tmp.plist" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/plist-macros.cpp
    RUN(TestState.Failed, "FileCheck --input-file=%t.plist %s");
  }

  @Test
  public void test_plist_output_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/plist-output.m");
    // ${LLVM_SRC}/build/bin/clang --analyze ${LLVM_SRC}/llvm/tools/clang/test/Analysis/plist-output.m -Xanalyzer '-analyzer-checker=osx.cocoa.RetainCount' -Xanalyzer -analyzer-config -Xanalyzer 'path-diagnostics-alternate=false' -Xanalyzer -analyzer-config -Xanalyzer 'path-diagnostics-alternate=false' -o ${TEST_TEMP_DIR}/plist-output.m.tmp.plist
    RUN(TestState.Failed, "%clang --analyze %s -Xanalyzer -analyzer-checker=osx.cocoa.RetainCount -Xanalyzer -analyzer-config -Xanalyzer path-diagnostics-alternate=false -Xanalyzer -analyzer-config -Xanalyzer path-diagnostics-alternate=false -o %t.plist");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/plist-output.m.tmp.plist" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/plist-output.m
    RUN(TestState.Failed, "FileCheck --input-file=%t.plist %s");
  }

  @Test
  public void test_plist_output_alternate_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/plist-output-alternate.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.RetainCount,alpha.core' -fblocks '-analyzer-output=plist' -analyzer-config 'path-diagnostics-alternate=false' -o ${TEST_TEMP_DIR}/plist-output-alternate.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/Analysis/plist-output-alternate.m
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.RetainCount,alpha.core -fblocks -analyzer-output=plist -analyzer-config path-diagnostics-alternate=false -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck --input-file ${TEST_TEMP_DIR}/plist-output-alternate.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/Analysis/plist-output-alternate.m
    RUN(TestState.Failed, "FileCheck --input-file %t %s");
  }

  @Test
  public void test_pointer_to_member_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/pointer-to-member.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/pointer-to-member.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -verify %s");
  }

  @Test
  public void test_pr22954_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/pr22954.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -analyze '-analyzer-checker=core,unix.Malloc,debug.ExprInspection' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/pr22954.c
    RUN("%clang_cc1 -triple x86_64-pc-linux-gnu -analyze -analyzer-checker=core,unix.Malloc,debug.ExprInspection -analyzer-store=region -verify %s");
  }

  @Test
  public void test_pr4209_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/pr4209.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -analyze '-analyzer-checker=core,alpha.core' '-analyzer-store=region' -Wno-incomplete-implementation -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/pr4209.m
    RUN("%clang_cc1 -triple i386-apple-darwin9 -analyze -analyzer-checker=core,alpha.core -analyzer-store=region -Wno-incomplete-implementation -verify %s");
  }

  @Test
  public void test_pr_2542_rdar_6793404_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/pr_2542_rdar_6793404.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.RetainCount,alpha.core' -pedantic '-analyzer-store=region' -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/pr_2542_rdar_6793404.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.RetainCount,alpha.core -pedantic -analyzer-store=region -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_pr_4164_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/pr_4164.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -analyze '-analyzer-checker=core,alpha.core' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/pr_4164.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 -analyze -analyzer-checker=core,alpha.core -analyzer-store=region -verify %s");
  }

  @Test
  public void test_properties_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/properties.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.RetainCount,osx.cocoa.Dealloc,debug.ExprInspection' '-analyzer-store=region' -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/properties.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.RetainCount,osx.cocoa.Dealloc,debug.ExprInspection -analyzer-store=region -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.RetainCount,osx.cocoa.Dealloc,debug.ExprInspection' '-analyzer-store=region' -verify -Wno-objc-root-class -fobjc-arc ${LLVM_SRC}/llvm/tools/clang/test/Analysis/properties.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.RetainCount,osx.cocoa.Dealloc,debug.ExprInspection -analyzer-store=region -verify -Wno-objc-root-class -fobjc-arc %s");
  }

  @Test
  public void test_properties_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/properties.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.RetainCount,debug.ExprInspection' '-analyzer-store=region' -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/properties.mm
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.RetainCount,debug.ExprInspection -analyzer-store=region -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.RetainCount,debug.ExprInspection' '-analyzer-store=region' -verify -Wno-objc-root-class -fobjc-arc ${LLVM_SRC}/llvm/tools/clang/test/Analysis/properties.mm
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.RetainCount,debug.ExprInspection -analyzer-store=region -verify -Wno-objc-root-class -fobjc-arc %s");
  }

  @Test
  public void test_pthreadlock_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/pthreadlock.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=alpha.unix.PthreadLock' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/pthreadlock.c
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=alpha.unix.PthreadLock -verify %s");
  }

  @Test
  public void test_ptr_arith_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/ptr-arith.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=alpha.core.FixedAddr,alpha.core.PointerArithm,alpha.core.PointerSub,debug.ExprInspection' '-analyzer-store=region' -verify -triple x86_64-apple-darwin9 -Wno-tautological-pointer-compare ${LLVM_SRC}/llvm/tools/clang/test/Analysis/ptr-arith.c
    RUN("%clang_cc1 -analyze -analyzer-checker=alpha.core.FixedAddr,alpha.core.PointerArithm,alpha.core.PointerSub,debug.ExprInspection -analyzer-store=region -verify -triple x86_64-apple-darwin9 -Wno-tautological-pointer-compare %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=alpha.core.FixedAddr,alpha.core.PointerArithm,alpha.core.PointerSub,debug.ExprInspection' '-analyzer-store=region' -verify -triple i686-apple-darwin9 -Wno-tautological-pointer-compare ${LLVM_SRC}/llvm/tools/clang/test/Analysis/ptr-arith.c
    RUN("%clang_cc1 -analyze -analyzer-checker=alpha.core.FixedAddr,alpha.core.PointerArithm,alpha.core.PointerSub,debug.ExprInspection -analyzer-store=region -verify -triple i686-apple-darwin9 -Wno-tautological-pointer-compare %s");
  }

  @Test
  public void test_ptr_arith_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/ptr-arith.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-unused-value '-std=c++14' -analyze '-analyzer-checker=core,debug.ExprInspection,alpha.core.PointerArithm' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/ptr-arith.cpp
    RUN("%clang_cc1 -Wno-unused-value -std=c++14 -analyze -analyzer-checker=core,debug.ExprInspection,alpha.core.PointerArithm -verify %s");
  }

  @Test
  public void test_qt_malloc_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/qt_malloc.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.deadcode.UnreachableCode,alpha.core.CastSize,unix.Malloc,cplusplus' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/qt_malloc.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.deadcode.UnreachableCode,alpha.core.CastSize,unix.Malloc,cplusplus -analyzer-store=region -verify %s");
  }

  @Test
  public void test_range_casts_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/range_casts.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -analyze '-analyzer-checker=core,debug.ExprInspection' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/range_casts.c
    RUN("%clang_cc1 -triple x86_64-pc-linux-gnu -analyze -analyzer-checker=core,debug.ExprInspection -analyzer-store=region -verify %s");
  }

  @Test
  public void test_rdar_6442306_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/rdar-6442306-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core' '-analyzer-disable-checker=alpha.core.PointerArithm' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/rdar-6442306-1.m '-analyzer-store=region' -verify
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core -analyzer-disable-checker=alpha.core.PointerArithm %s -analyzer-store=region -verify");
  }

  @Test
  public void test_rdar_6540084_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/rdar-6540084.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core' '-analyzer-checker=deadcode.DeadStores' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/rdar-6540084.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core -analyzer-checker=deadcode.DeadStores -verify %s");
  }

  @Test
  public void test_rdar_6541136_region_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/rdar-6541136-region.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -analyze '-analyzer-checker=core,alpha.security.ArrayBound' '-analyzer-store=region' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/rdar-6541136-region.c
    RUN("%clang_cc1 -verify -analyze -analyzer-checker=core,alpha.security.ArrayBound -analyzer-store=region %s");
  }

  @Test
  public void test_rdar_6562655_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/rdar-6562655.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.RetainCount,alpha.core' '-analyzer-constraints=range' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/rdar-6562655.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.RetainCount,alpha.core -analyzer-constraints=range -analyzer-store=region -verify %s");
  }

  @Test
  public void test_rdar_6600344_nil_receiver_undefined_struct_ret_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/rdar-6600344-nil-receiver-undefined-struct-ret.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core' '-analyzer-constraints=range' '-analyzer-store=region' -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/rdar-6600344-nil-receiver-undefined-struct-ret.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core -analyzer-constraints=range -analyzer-store=region -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_rdar_7168531_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/rdar-7168531.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core' -triple i386-apple-darwin10 '-fobjc-runtime=macosx-fragile-10.5' '-analyzer-store=region' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/rdar-7168531.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -analyzer-store=region %s");
  }

  @Test
  public void test_redefined_system_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/redefined_system.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=osx,unix,core,alpha.security.taint' -w -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/redefined_system.c
    RUN("%clang_cc1 -analyze -analyzer-checker=osx,unix,core,alpha.security.taint -w -verify %s");
  }

  @Test
  public void test_refcnt_naming_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/refcnt_naming.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.RetainCount,alpha.core' -analyzer-config 'ipa=none' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/refcnt_naming.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.RetainCount,alpha.core -analyzer-config ipa=none -analyzer-store=region -verify %s");
  }

  @Test
  public void test_reference_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/reference.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core,debug.ExprInspection' '-analyzer-store=region' '-analyzer-constraints=range' -verify -Wno-null-dereference -Wno-tautological-undefined-compare ${LLVM_SRC}/llvm/tools/clang/test/Analysis/reference.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core,debug.ExprInspection -analyzer-store=region -analyzer-constraints=range -verify -Wno-null-dereference -Wno-tautological-undefined-compare %s");
  }

  @Test
  public void test_reference_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/reference.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -verify -Wno-null-dereference ${LLVM_SRC}/llvm/tools/clang/test/Analysis/reference.mm
    RUN("%clang_cc1 -analyze -analyzer-checker=core -verify -Wno-null-dereference %s");
  }

  @Test
  public void test_region_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/region-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/region-1.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core -analyzer-store=region -verify %s");
  }

  @Test
  public void test_region_store_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/region-store.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix,debug.ExprInspection' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/region-store.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix,debug.ExprInspection -verify %s");
  }

  @Test
  public void test_region_store_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/region-store.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/region-store.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix -verify %s");
  }

  @Test
  public void test_reinterpret_cast_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/reinterpret-cast.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/reinterpret-cast.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -verify %s");
  }

  @Test
  public void test_retain_release_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release.m");
    // rm -f ${TEST_TEMP_DIR}/retain-release.m.tmp.objc.plist ${TEST_TEMP_DIR}/retain-release.m.tmp.objcpp.plist
    RUN(TestState.Failed, "rm -f %t.objc.plist %t.objcpp.plist");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core,osx.coreFoundation.CFRetainRelease,osx.cocoa.ClassRelease,osx.cocoa.RetainCount' '-analyzer-store=region' -fblocks -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release.m '-analyzer-output=plist' -o ${TEST_TEMP_DIR}/retain-release.m.tmp.objc.plist
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core,osx.coreFoundation.CFRetainRelease,osx.cocoa.ClassRelease,osx.cocoa.RetainCount -analyzer-store=region -fblocks -verify -Wno-objc-root-class %s -analyzer-output=plist -o %t.objc.plist");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core,osx.coreFoundation.CFRetainRelease,osx.cocoa.ClassRelease,osx.cocoa.RetainCount' '-analyzer-store=region' -fblocks -verify -x objective-c++ '-std=gnu++98' -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release.m '-analyzer-output=plist' -o ${TEST_TEMP_DIR}/retain-release.m.tmp.objcpp.plist
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core,osx.coreFoundation.CFRetainRelease,osx.cocoa.ClassRelease,osx.cocoa.RetainCount -analyzer-store=region -fblocks -verify -x objective-c++ -std=gnu++98 -Wno-objc-root-class %s -analyzer-output=plist -o %t.objcpp.plist");
  }

  @Test
  public void test_retain_release_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core,osx.coreFoundation.CFRetainRelease,osx.cocoa.ClassRelease,osx.cocoa.RetainCount' '-analyzer-store=region' -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core,osx.coreFoundation.CFRetainRelease,osx.cocoa.ClassRelease,osx.cocoa.RetainCount -analyzer-store=region -fblocks -verify %s");
  }

  @Test
  public void test_retain_release_cache_out_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release-cache-out.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze ${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release-cache-out.m '-analyzer-checker=core,osx.cocoa.RetainCount' -fblocks -verify
    RUN("%clang_cc1 -analyze %s -analyzer-checker=core,osx.cocoa.RetainCount -fblocks -verify");
  }

  @Test
  public void test_retain_release_cf_audited_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release-cf-audited.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core,osx.cocoa.RetainCount' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release-cf-audited.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core,osx.cocoa.RetainCount -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core,osx.cocoa.RetainCount' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release-cf-audited.m -x objective-c++
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core,osx.cocoa.RetainCount -verify %s -x objective-c++");
  }

  @Test
  public void test_retain_release_gc_only_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release-gc-only.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -analyze '-analyzer-checker=core,osx.cocoa.RetainCount,osx.cocoa.NSAutoreleasePool' '-analyzer-store=region' -fobjc-gc-only -fblocks -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release-gc-only.m
    RUN("%clang_cc1 -triple %itanium_abi_triple -analyze -analyzer-checker=core,osx.cocoa.RetainCount,osx.cocoa.NSAutoreleasePool -analyzer-store=region -fobjc-gc-only -fblocks -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_retain_release_inline_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release-inline.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core,osx.coreFoundation.CFRetainRelease,osx.cocoa.ClassRelease,osx.cocoa.RetainCount' -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release-inline.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core,osx.coreFoundation.CFRetainRelease,osx.cocoa.ClassRelease,osx.cocoa.RetainCount -fblocks -verify %s");
  }

  @Test
  public void test_retain_release_path_notes_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release-path-notes.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core,osx.coreFoundation.CFRetainRelease,osx.cocoa.ClassRelease,osx.cocoa.RetainCount' '-analyzer-store=region' '-analyzer-output=text' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release-path-notes.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core,osx.coreFoundation.CFRetainRelease,osx.cocoa.ClassRelease,osx.cocoa.RetainCount -analyzer-store=region -analyzer-output=text -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core,osx.coreFoundation.CFRetainRelease,osx.cocoa.ClassRelease,osx.cocoa.RetainCount' '-analyzer-store=region' '-analyzer-output=plist-multi-file' -analyzer-config 'path-diagnostics-alternate=false' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release-path-notes.m -o ${TEST_TEMP_DIR}/retain-release-path-notes.m.tmp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core,osx.coreFoundation.CFRetainRelease,osx.cocoa.ClassRelease,osx.cocoa.RetainCount -analyzer-store=region -analyzer-output=plist-multi-file -analyzer-config path-diagnostics-alternate=false %s -o %t");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/retain-release-path-notes.m.tmp" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release-path-notes.m
    RUN(TestState.Failed, "FileCheck --input-file=%t %s");
  }

  @Test
  public void test_retain_release_path_notes_gc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release-path-notes-gc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core,osx.coreFoundation.CFRetainRelease,osx.cocoa.ClassRelease,osx.cocoa.RetainCount' '-analyzer-store=region' -fobjc-gc-only '-analyzer-output=text' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release-path-notes-gc.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core,osx.coreFoundation.CFRetainRelease,osx.cocoa.ClassRelease,osx.cocoa.RetainCount -analyzer-store=region -fobjc-gc-only -analyzer-output=text -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core,osx.coreFoundation.CFRetainRelease,osx.cocoa.ClassRelease,osx.cocoa.RetainCount' '-analyzer-store=region' -fobjc-gc-only '-analyzer-output=plist-multi-file' -analyzer-config 'path-diagnostics-alternate=false' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release-path-notes-gc.m -o ${TEST_TEMP_DIR}/retain-release-path-notes-gc.m.tmp.plist
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core,osx.coreFoundation.CFRetainRelease,osx.cocoa.ClassRelease,osx.cocoa.RetainCount -analyzer-store=region -fobjc-gc-only -analyzer-output=plist-multi-file -analyzer-config path-diagnostics-alternate=false %s -o %t.plist");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/retain-release-path-notes-gc.m.tmp.plist" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release-path-notes-gc.m
    RUN("FileCheck --input-file=%t.plist %s");
  }

  @Test
  public void test_retain_release_region_store_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release-region-store.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -analyze '-analyzer-checker=core,osx.cocoa.RetainCount' '-analyzer-store=region' -analyzer-max-loop 6 -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/retain-release-region-store.m
    RUN("%clang_cc1 -triple %itanium_abi_triple -analyze -analyzer-checker=core,osx.cocoa.RetainCount -analyzer-store=region -analyzer-max-loop 6 -verify %s");
  }

  @Test
  public void test_return_ptr_range_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/return-ptr-range.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=alpha.security.ReturnPtrRange' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/return-ptr-range.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=alpha.security.ReturnPtrRange -verify %s");
  }

  @Test
  public void test_security_syntax_checks_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/security-syntax-checks.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -analyze '-analyzer-checker=security.insecureAPI,security.FloatLoopCounter' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/security-syntax-checks.m -verify
    RUN("%clang_cc1 -triple i386-apple-darwin10 -analyze -analyzer-checker=security.insecureAPI,security.FloatLoopCounter %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -analyze -DUSE_BUILTINS '-analyzer-checker=security.insecureAPI,security.FloatLoopCounter' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/security-syntax-checks.m -verify
    RUN("%clang_cc1 -triple i386-apple-darwin10 -analyze -DUSE_BUILTINS -analyzer-checker=security.insecureAPI,security.FloatLoopCounter %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -analyze -DVARIANT '-analyzer-checker=security.insecureAPI,security.FloatLoopCounter' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/security-syntax-checks.m -verify
    RUN("%clang_cc1 -triple i386-apple-darwin10 -analyze -DVARIANT -analyzer-checker=security.insecureAPI,security.FloatLoopCounter %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -analyze -DUSE_BUILTINS -DVARIANT '-analyzer-checker=security.insecureAPI,security.FloatLoopCounter' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/security-syntax-checks.m -verify
    RUN("%clang_cc1 -triple i386-apple-darwin10 -analyze -DUSE_BUILTINS -DVARIANT -analyzer-checker=security.insecureAPI,security.FloatLoopCounter %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-cloudabi -analyze '-analyzer-checker=security.insecureAPI,security.FloatLoopCounter' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/security-syntax-checks.m -verify
    RUN("%clang_cc1 -triple x86_64-unknown-cloudabi -analyze -analyzer-checker=security.insecureAPI,security.FloatLoopCounter %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-cloudabi -analyze -DUSE_BUILTINS '-analyzer-checker=security.insecureAPI,security.FloatLoopCounter' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/security-syntax-checks.m -verify
    RUN("%clang_cc1 -triple x86_64-unknown-cloudabi -analyze -DUSE_BUILTINS -analyzer-checker=security.insecureAPI,security.FloatLoopCounter %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-cloudabi -analyze -DVARIANT '-analyzer-checker=security.insecureAPI,security.FloatLoopCounter' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/security-syntax-checks.m -verify
    RUN("%clang_cc1 -triple x86_64-unknown-cloudabi -analyze -DVARIANT -analyzer-checker=security.insecureAPI,security.FloatLoopCounter %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-cloudabi -analyze -DUSE_BUILTINS -DVARIANT '-analyzer-checker=security.insecureAPI,security.FloatLoopCounter' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/security-syntax-checks.m -verify
    RUN("%clang_cc1 -triple x86_64-unknown-cloudabi -analyze -DUSE_BUILTINS -DVARIANT -analyzer-checker=security.insecureAPI,security.FloatLoopCounter %s -verify");
  }

  @Test
  public void test_security_syntax_checks_no_emit_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/security-syntax-checks-no-emit.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux-gnu -analyze '-analyzer-checker=security.insecureAPI,security.FloatLoopCounter' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/security-syntax-checks-no-emit.c -verify
    RUN("%clang_cc1 -triple i686-pc-linux-gnu -analyze -analyzer-checker=security.insecureAPI,security.FloatLoopCounter %s -verify");
  }

  @Test
  public void test_self_init_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/self-init.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=osx.cocoa.SelfInit' -analyzer-config 'ipa=dynamic' -fno-builtin ${LLVM_SRC}/llvm/tools/clang/test/Analysis/self-init.m -verify
    RUN("%clang_cc1 -analyze -analyzer-checker=osx.cocoa.SelfInit -analyzer-config ipa=dynamic -fno-builtin %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=osx.cocoa.SelfInit' -fno-builtin ${LLVM_SRC}/llvm/tools/clang/test/Analysis/self-init.m -verify
    RUN("%clang_cc1 -analyze -analyzer-checker=osx.cocoa.SelfInit -fno-builtin %s -verify");
  }

  @Test
  public void test_shallow_mode_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/shallow-mode.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -analyzer-config 'mode=shallow' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/shallow-mode.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -analyzer-config mode=shallow -verify %s");
  }

  @Test
  public void test_simple_stream_checks_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/simple-stream-checks.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.unix.SimpleStream' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/simple-stream-checks.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.unix.SimpleStream -verify %s");
  }

  @Test
  public void test_sizeofpointer_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/sizeofpointer.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=alpha.core.SizeofPtr' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/sizeofpointer.c
    RUN("%clang_cc1 -analyze -analyzer-checker=alpha.core.SizeofPtr -verify %s");
  }

  @Test
  public void test_stack_addr_ps_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/stack-addr-ps.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-store=region' -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/stack-addr-ps.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-store=region -fblocks -verify %s");
  }

  @Test
  public void test_stack_addr_ps_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/stack-addr-ps.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/stack-addr-ps.cpp -Wno-undefined-bool-conversion
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-store=region -verify %s -Wno-undefined-bool-conversion");
  }

  @Test
  public void test_stack_block_returned_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/stack-block-returned.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-store=region' -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/stack-block-returned.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-store=region -fblocks -verify %s");
  }

  @Test
  public void test_stackaddrleak_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/stackaddrleak.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -verify '-std=c99' '-Dbool=_Bool' -Wno-bool-conversion ${LLVM_SRC}/llvm/tools/clang/test/Analysis/stackaddrleak.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core -verify -std=c99 -Dbool=_Bool -Wno-bool-conversion %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -verify -x c++ -Wno-bool-conversion ${LLVM_SRC}/llvm/tools/clang/test/Analysis/stackaddrleak.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core -verify -x c++ -Wno-bool-conversion %s");
  }

  @Test
  public void test_static_local_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/static_local.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/static_local.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_stats_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/stats.c");
    // REQUIRES: asserts
    if (!CHECK_REQUIRES("asserts")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -analyzer-stats ${LLVM_SRC}/llvm/tools/clang/test/Analysis/stats.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/stats.c
    RUN(TestState.SemanticErrors/*fails when invoken with other passed tests. StatisticInfo destructor is not called here and exit code is 1*/, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-stats %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_stream_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/stream.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=alpha.unix.Stream' -analyzer-store region -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/stream.c
    RUN("%clang_cc1 -analyze -analyzer-checker=alpha.unix.Stream -analyzer-store region -verify %s");
  }

  @Test
  public void test_string_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/string.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.cstring,alpha.unix.cstring,debug.ExprInspection' '-analyzer-store=region' -Wno-null-dereference -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/string.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix.cstring,alpha.unix.cstring,debug.ExprInspection -analyzer-store=region -Wno-null-dereference -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze -DUSE_BUILTINS '-analyzer-checker=core,unix.cstring,alpha.unix.cstring,debug.ExprInspection' '-analyzer-store=region' -Wno-null-dereference -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/string.c
    RUN("%clang_cc1 -analyze -DUSE_BUILTINS -analyzer-checker=core,unix.cstring,alpha.unix.cstring,debug.ExprInspection -analyzer-store=region -Wno-null-dereference -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze -DVARIANT '-analyzer-checker=core,unix.cstring,alpha.unix.cstring,debug.ExprInspection' '-analyzer-store=region' -Wno-null-dereference -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/string.c
    RUN("%clang_cc1 -analyze -DVARIANT -analyzer-checker=core,unix.cstring,alpha.unix.cstring,debug.ExprInspection -analyzer-store=region -Wno-null-dereference -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze -DUSE_BUILTINS -DVARIANT '-analyzer-checker=alpha.security.taint,core,unix.cstring,alpha.unix.cstring,debug.ExprInspection' '-analyzer-store=region' -Wno-null-dereference -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/string.c
    RUN("%clang_cc1 -analyze -DUSE_BUILTINS -DVARIANT -analyzer-checker=alpha.security.taint,core,unix.cstring,alpha.unix.cstring,debug.ExprInspection -analyzer-store=region -Wno-null-dereference -verify %s");
  }

  @Test
  public void test_string_fail_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/string-fail.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.cstring,debug.ExprInspection' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/string-fail.c
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,unix.cstring,debug.ExprInspection -analyzer-store=region -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze -DUSE_BUILTINS '-analyzer-checker=core,unix.cstring,debug.ExprInspection' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/string-fail.c
    RUN(TestState.Failed, "%clang_cc1 -analyze -DUSE_BUILTINS -analyzer-checker=core,unix.cstring,debug.ExprInspection -analyzer-store=region -verify %s");
  }

  @Test
  public void test_superclass_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/superclass.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -analyze '-analyzer-checker=osx.cocoa.MissingSuperCall' -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/superclass.m
    RUN("%clang_cc1 -fblocks -analyze -analyzer-checker=osx.cocoa.MissingSuperCall -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_svalbuilder_logic_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/svalbuilder-logic.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/svalbuilder-logic.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix -verify %s");
  }

  @Test
  public void test_switch_case_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/switch-case.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/switch-case.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -verify %s");
  }

  @Test
  public void test_symbol_reaper_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/symbol-reaper.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=debug.ExprInspection' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/symbol-reaper.c
    RUN("%clang_cc1 -analyze -analyzer-checker=debug.ExprInspection -verify %s");
  }

  @Test
  public void test_taint_generic_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/taint-generic.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=alpha.security.taint,core,alpha.security.ArrayBoundV2' -Wno-format-security -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/taint-generic.c
    RUN("%clang_cc1  -analyze -analyzer-checker=alpha.security.taint,core,alpha.security.ArrayBoundV2 -Wno-format-security -verify %s");
  }

  @Test
  public void test_taint_tester_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/taint-tester.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-int-to-pointer-cast -analyze '-analyzer-checker=alpha.security.taint,debug.TaintTest' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/taint-tester.c -verify
    RUN("%clang_cc1 -Wno-int-to-pointer-cast -analyze -analyzer-checker=alpha.security.taint,debug.TaintTest %s -verify");
  }

  @Test
  public void test_taint_tester_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/taint-tester.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=alpha.security.taint,debug.TaintTest' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/taint-tester.cpp -verify
    RUN("%clang_cc1  -analyze -analyzer-checker=alpha.security.taint,debug.TaintTest %s -verify");
  }

  @Test
  public void test_taint_tester_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/taint-tester.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=alpha.security.taint,debug.TaintTest' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/taint-tester.m -verify
    RUN("%clang_cc1  -analyze -analyzer-checker=alpha.security.taint,debug.TaintTest %s -verify");
  }

  @Test
  public void test_temp_obj_dtors_cfg_output_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/temp-obj-dtors-cfg-output.cpp");
    // rm -f ${TEST_TEMP_DIR}/temp-obj-dtors-cfg-output.cpp.tmp
    RUN("rm -f %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=debug.DumpCFG' -analyzer-config 'cfg-temporary-dtors=true' '-std=c++98' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/temp-obj-dtors-cfg-output.cpp > ${TEST_TEMP_DIR}/temp-obj-dtors-cfg-output.cpp.tmp 2>&1
    RUN("%clang_cc1 -analyze -analyzer-checker=debug.DumpCFG -analyzer-config cfg-temporary-dtors=true -std=c++98 %s > %t 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/temp-obj-dtors-cfg-output.cpp.tmp" '-check-prefix=CXX98' '-check-prefix=CHECK' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/temp-obj-dtors-cfg-output.cpp
    RUN("FileCheck --input-file=%t -check-prefix=CXX98 -check-prefix=CHECK %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=debug.DumpCFG' -analyzer-config 'cfg-temporary-dtors=true' '-std=c++11' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/temp-obj-dtors-cfg-output.cpp > ${TEST_TEMP_DIR}/temp-obj-dtors-cfg-output.cpp.tmp 2>&1
    RUN("%clang_cc1 -analyze -analyzer-checker=debug.DumpCFG -analyzer-config cfg-temporary-dtors=true -std=c++11 %s > %t 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/temp-obj-dtors-cfg-output.cpp.tmp" '-check-prefix=CXX11' '-check-prefix=CHECK' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/temp-obj-dtors-cfg-output.cpp
    RUN("FileCheck --input-file=%t -check-prefix=CXX11 -check-prefix=CHECK %s");
  }

  @Test
  public void test_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/templates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/templates.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -fblocks -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -fblocks -analyzer-config 'c++-template-inlining=false' -DNO_INLINE -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/templates.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -fblocks -analyzer-config c++-template-inlining=false -DNO_INLINE -verify %s");
  }

  @Test
  public void test_temporaries_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/temporaries.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -verify -w '-std=c++03' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/temporaries.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -verify -w -std=c++03 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -verify -w '-std=c++11' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/temporaries.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -verify -w -std=c++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -DTEMPORARY_DTORS -verify -w -analyzer-config 'cfg-temporary-dtors=true' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/temporaries.cpp '-std=c++11'
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -DTEMPORARY_DTORS -verify -w -analyzer-config cfg-temporary-dtors=true %s -std=c++11");
  }

  @Test
  public void test_test_after_div_zero_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/test-after-div-zero.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c99' '-Dbool=_Bool' -analyze '-analyzer-checker=core,alpha.core.TestAfterDivZero' '-analyzer-output=text' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/test-after-div-zero.c
    RUN("%clang_cc1 -std=c99 -Dbool=_Bool -analyze -analyzer-checker=core,alpha.core.TestAfterDivZero -analyzer-output=text -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -analyze '-analyzer-checker=core,alpha.core.TestAfterDivZero' '-analyzer-output=text' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/test-after-div-zero.c
    RUN("%clang_cc1 -x c++ -analyze -analyzer-checker=core,alpha.core.TestAfterDivZero -analyzer-output=text -verify %s");
  }

  @Test
  public void test_test_include_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/test-include.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/test-include.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core -verify %s");
  }

  @Test
  public void test_test_include_cpp_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/test-include-cpp.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/test-include-cpp.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core -verify %s");
  }

  @Test
  public void test_test_objc_non_nil_return_value_checker_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/test-objc-non-nil-return-value-checker.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=osx.cocoa.NonNilReturnValue,debug.ExprInspection' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/test-objc-non-nil-return-value-checker.m
    RUN("%clang_cc1 -analyze -analyzer-checker=osx.cocoa.NonNilReturnValue,debug.ExprInspection -verify %s");
  }

  @Test
  public void test_test_variably_modified_types_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/test-variably-modified-types.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyze-function=testVariablyModifiedTypes' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/test-variably-modified-types.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyze-function=testVariablyModifiedTypes -verify %s");
  }

  @Test
  public void test_traversal_algorithm_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/traversal-algorithm.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=debug.DumpTraversal' -analyzer-max-loop 4 '-std=c++11' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/traversal-algorithm.mm | ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=DFS' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/traversal-algorithm.mm
    RUN("%clang_cc1 -analyze -analyzer-checker=debug.DumpTraversal -analyzer-max-loop 4 -std=c++11 %s")./*|*/
      I("FileCheck -check-prefix=DFS %s");
  }

  @Test
  public void test_traversal_begin_end_function_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/traversal-begin-end-function.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.DumpTraversal' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/traversal-begin-end-function.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/traversal-begin-end-function.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.DumpTraversal %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_traversal_path_unification_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/traversal-path-unification.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.DumpTraversal' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/traversal-path-unification.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/traversal-path-unification.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.DumpTraversal %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.DumpTraversal' -DUSE_EXPR ${LLVM_SRC}/llvm/tools/clang/test/Analysis/traversal-path-unification.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/traversal-path-unification.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.DumpTraversal -DUSE_EXPR %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ubigraph_viz_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/ubigraph-viz.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.API' -analyzer-viz-egraph-ubigraph -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/ubigraph-viz.cpp
    RUN(TestState.SemanticErrors/*can not find program ubiviz: UbigraphViz::~UbigraphViz*/, "%clang_cc1 -analyze -analyzer-checker=core,unix.API -analyzer-viz-egraph-ubigraph -verify %s");
  }

  @Test
  public void test_undef_buffers_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/undef-buffers.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix,core.uninitialized' '-analyzer-store=region' -verify -analyzer-config 'unix:Optimistic=true' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/undef-buffers.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix,core.uninitialized -analyzer-store=region -verify -analyzer-config unix:Optimistic=true %s");
  }

  @Test
  public void test_uninit_const_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/uninit-const.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=unix.Malloc,core,alpha.core.CallAndMessageUnInitRefArg' '-analyzer-output=text' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/uninit-const.c
    RUN("%clang_cc1 -analyze -analyzer-checker=unix.Malloc,core,alpha.core.CallAndMessageUnInitRefArg -analyzer-output=text -verify %s");
  }

  @Test
  public void test_uninit_const_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/uninit-const.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=cplusplus.NewDelete,core,alpha.core.CallAndMessageUnInitRefArg' '-analyzer-output=text' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/uninit-const.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=cplusplus.NewDelete,core,alpha.core.CallAndMessageUnInitRefArg -analyzer-output=text -verify %s");
  }

  @Test
  public void test_uninit_msg_expr_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/uninit-msg-expr.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-store=region' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/uninit-msg-expr.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-store=region -verify %s");
  }

  @Test
  public void test_uninit_ps_rdar6145427_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/uninit-ps-rdar6145427.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -verify '-analyzer-store=region' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/uninit-ps-rdar6145427.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core -verify -analyzer-store=region %s");
  }

  @Test
  public void test_uninit_sometimes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/uninit-sometimes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=gnu++11' -Wsometimes-uninitialized -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/uninit-sometimes.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=gnu++11 -Wsometimes-uninitialized -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=gnu++11' -Wsometimes-uninitialized -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/Analysis/uninit-sometimes.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/uninit-sometimes.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=gnu++11 -Wsometimes-uninitialized -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_uninit_vals_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/uninit-vals.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc,debug.ExprInspection' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/uninit-vals.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix.Malloc,debug.ExprInspection -verify %s");
  }

  @Test
  public void test_uninit_vals_ps_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/uninit-vals-ps.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-store=region' -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/uninit-vals-ps.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-store=region -fblocks -verify %s");
  }

  @Test
  public void test_uninit_vals_ps_region_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/uninit-vals-ps-region.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-store=region' '-analyzer-checker=core' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/uninit-vals-ps-region.m
    RUN("%clang_cc1 -analyze -analyzer-store=region -analyzer-checker=core -verify %s");
  }

  @Test
  public void test_unions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/unions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc,debug.ExprInspection' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/unions.cpp -verify
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix.Malloc,debug.ExprInspection %s -verify");
  }

  @Test
  public void test_unions_region_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/unions-region.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-store=region' '-analyzer-constraints=range' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/unions-region.m -verify
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-store=region -analyzer-constraints=range %s -verify");
  }

  @Test
  public void test_unix_api_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/unix-api.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.API' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/unix-api.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix.API -verify %s");
  }

  @Test
  public void test_unix_fns_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/unix-fns.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core,unix.API,osx.API' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/unix-fns.c '-analyzer-store=region' '-analyzer-output=plist' -analyzer-eagerly-assume -analyzer-config 'faux-bodies=true' -analyzer-config 'path-diagnostics-alternate=false' -fblocks -verify -o ${TEST_TEMP_DIR}/unix-fns.c.tmp.plist
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core,unix.API,osx.API %s -analyzer-store=region -analyzer-output=plist -analyzer-eagerly-assume -analyzer-config faux-bodies=true -analyzer-config path-diagnostics-alternate=false -fblocks -verify -o %t.plist");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/unix-fns.c.tmp.plist" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/unix-fns.c
    RUN(TestState.Failed, "FileCheck --input-file=%t.plist %s");
    // mkdir -p ${TEST_TEMP_DIR}/unix-fns.c.tmp.dir
    RUN(TestState.Failed, "mkdir -p %t.dir");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.API,osx.API' '-analyzer-output=html' -analyzer-config 'faux-bodies=true' -fblocks -o ${TEST_TEMP_DIR}/unix-fns.c.tmp.dir ${LLVM_SRC}/llvm/tools/clang/test/Analysis/unix-fns.c
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,unix.API,osx.API -analyzer-output=html -analyzer-config faux-bodies=true -fblocks -o %t.dir %s");
    // rm -fR ${TEST_TEMP_DIR}/unix-fns.c.tmp.dir
    RUN(TestState.Failed, "rm -fR %t.dir");
  }

  @Test
  public void test_unreachable_code_path_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/unreachable-code-path.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,deadcode.DeadStores,alpha.deadcode.UnreachableCode' -verify -analyzer-opt-analyze-nested-blocks -Wno-unused-value ${LLVM_SRC}/llvm/tools/clang/test/Analysis/unreachable-code-path.c
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,deadcode.DeadStores,alpha.deadcode.UnreachableCode -verify -analyzer-opt-analyze-nested-blocks -Wno-unused-value %s");
  }

  @Test
  public void test_unused_ivars_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/unused-ivars.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -analyze '-analyzer-checker=osx.cocoa.UnusedIvars' -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/unused-ivars.m
    RUN("%clang_cc1 -fblocks -analyze -analyzer-checker=osx.cocoa.UnusedIvars -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_variadic_method_types_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/variadic-method-types.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -analyze '-analyzer-checker=core,osx.cocoa.VariadicMethodTypes' '-analyzer-store=region' -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/variadic-method-types.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -analyze -analyzer-checker=core,osx.cocoa.VariadicMethodTypes -analyzer-store=region -fblocks -verify %s");
  }

  @Test
  public void test_vfork_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/vfork.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,security.insecureAPI.vfork,unix.Vfork' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/vfork.c
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,security.insecureAPI.vfork,unix.Vfork -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,security.insecureAPI.vfork,unix.Vfork' -verify -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Analysis/vfork.c
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,security.insecureAPI.vfork,unix.Vfork -verify -x c++ %s");
  }

  @Test
  public void test_virtualcall_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/virtualcall.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=alpha.cplusplus.VirtualCall' -analyzer-store region -verify '-std=c++11' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/virtualcall.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=alpha.cplusplus.VirtualCall -analyzer-store region -verify -std=c++11 %s");
  }

  @Test
  public void test_vla_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/vla.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/vla.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core -verify %s");
  }

  @Test
  public void test_weak_functions_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/weak-functions.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,alpha.core,debug.ExprInspection,unix.Malloc,unix.cstring,alpha.unix.cstring,unix.API,osx.API,osx.cocoa.RetainCount' -Wno-null-dereference -Wno-tautological-compare '-analyzer-store=region' -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/weak-functions.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,alpha.core,debug.ExprInspection,unix.Malloc,unix.cstring,alpha.unix.cstring,unix.API,osx.API,osx.cocoa.RetainCount -Wno-null-dereference -Wno-tautological-compare -analyzer-store=region -fblocks -verify %s");
  }

}
