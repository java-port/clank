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
import org.clang.staticanalyzer.checkers.impl.*;
import org.clang.staticanalyzer.core.ento.*;


//<editor-fold defaultstate="collapsed" desc="static type NullabilityCheckerEntoGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN5clang4ento34registerNullPassedToNonnullCheckerERNS0_14CheckerManagerE;_ZN5clang4ento35registerNullableDereferencedCheckerERNS0_14CheckerManagerE;_ZN5clang4ento38registerNullReturnedFromNonnullCheckerERNS0_14CheckerManagerE;_ZN5clang4ento38registerNullablePassedToNonnullCheckerERNS0_14CheckerManagerE;_ZN5clang4ento42registerNullableReturnedFromNonnullCheckerERNS0_14CheckerManagerE; -static-type=NullabilityCheckerEntoGlobals -package=org.clang.staticanalyzer.checkers.ento.impl")
//</editor-fold>
public final class NullabilityCheckerEntoGlobals {


// The checks are likely to be turned on by default and it is possible to do
// them without tracking any nullability related information. As an optimization
// no nullability information will be tracked when only these two checks are
// enables.
//<editor-fold defaultstate="collapsed" desc="clang::ento::registerNullPassedToNonnullChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 1227,
 FQN="clang::ento::registerNullPassedToNonnullChecker", NM="_ZN5clang4ento34registerNullPassedToNonnullCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN5clang4ento34registerNullPassedToNonnullCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerNullPassedToNonnullChecker(final CheckerManager /*&*/ mgr) {
  NullabilityChecker /*P*/ checker = mgr.<NullabilityChecker>registerChecker(NullabilityChecker.class);
  checker.Filter.CheckNullPassedToNonnull.$assign(/*KEEP_BOOL*/true);
  checker.Filter.CheckNameNullPassedToNonnull.$assignMove(mgr.getCurrentCheckName());
  checker.NeedTracking.$assign(/*KEEP_BOOL*/checker.NeedTracking.$BoolRef() || false);
  checker.NoDiagnoseCallsToSystemHeaders.$assign(/*KEEP_BOOL*/checker.NoDiagnoseCallsToSystemHeaders.$BoolRef() || mgr.getAnalyzerOptions().getBooleanOption(new StringRef(/*KEEP_STR*/"NoDiagnoseCallsToSystemHeaders"), false, checker, true));
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerNullReturnedFromNonnullChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 1228,
 FQN="clang::ento::registerNullReturnedFromNonnullChecker", NM="_ZN5clang4ento38registerNullReturnedFromNonnullCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN5clang4ento38registerNullReturnedFromNonnullCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerNullReturnedFromNonnullChecker(final CheckerManager /*&*/ mgr) {
  NullabilityChecker /*P*/ checker = mgr.<NullabilityChecker>registerChecker(NullabilityChecker.class);
  checker.Filter.CheckNullReturnedFromNonnull.$assign(/*KEEP_BOOL*/true);
  checker.Filter.CheckNameNullReturnedFromNonnull.$assignMove(mgr.getCurrentCheckName());
  checker.NeedTracking.$assign(/*KEEP_BOOL*/checker.NeedTracking.$BoolRef() || false);
  checker.NoDiagnoseCallsToSystemHeaders.$assign(/*KEEP_BOOL*/checker.NoDiagnoseCallsToSystemHeaders.$BoolRef() || mgr.getAnalyzerOptions().getBooleanOption(new StringRef(/*KEEP_STR*/"NoDiagnoseCallsToSystemHeaders"), false, checker, true));
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerNullableDereferencedChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 1230,
 FQN="clang::ento::registerNullableDereferencedChecker", NM="_ZN5clang4ento35registerNullableDereferencedCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN5clang4ento35registerNullableDereferencedCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerNullableDereferencedChecker(final CheckerManager /*&*/ mgr) {
  NullabilityChecker /*P*/ checker = mgr.<NullabilityChecker>registerChecker(NullabilityChecker.class);
  checker.Filter.CheckNullableDereferenced.$assign(/*KEEP_BOOL*/true);
  checker.Filter.CheckNameNullableDereferenced.$assignMove(mgr.getCurrentCheckName());
  checker.NeedTracking.$assign(/*KEEP_BOOL*/checker.NeedTracking.$BoolRef() || true);
  checker.NoDiagnoseCallsToSystemHeaders.$assign(/*KEEP_BOOL*/checker.NoDiagnoseCallsToSystemHeaders.$BoolRef() || mgr.getAnalyzerOptions().getBooleanOption(new StringRef(/*KEEP_STR*/"NoDiagnoseCallsToSystemHeaders"), false, checker, true));
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerNullablePassedToNonnullChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 1231,
 FQN="clang::ento::registerNullablePassedToNonnullChecker", NM="_ZN5clang4ento38registerNullablePassedToNonnullCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN5clang4ento38registerNullablePassedToNonnullCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerNullablePassedToNonnullChecker(final CheckerManager /*&*/ mgr) {
  NullabilityChecker /*P*/ checker = mgr.<NullabilityChecker>registerChecker(NullabilityChecker.class);
  checker.Filter.CheckNullablePassedToNonnull.$assign(/*KEEP_BOOL*/true);
  checker.Filter.CheckNameNullablePassedToNonnull.$assignMove(mgr.getCurrentCheckName());
  checker.NeedTracking.$assign(/*KEEP_BOOL*/checker.NeedTracking.$BoolRef() || true);
  checker.NoDiagnoseCallsToSystemHeaders.$assign(/*KEEP_BOOL*/checker.NoDiagnoseCallsToSystemHeaders.$BoolRef() || mgr.getAnalyzerOptions().getBooleanOption(new StringRef(/*KEEP_STR*/"NoDiagnoseCallsToSystemHeaders"), false, checker, true));
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerNullableReturnedFromNonnullChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 1232,
 FQN="clang::ento::registerNullableReturnedFromNonnullChecker", NM="_ZN5clang4ento42registerNullableReturnedFromNonnullCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN5clang4ento42registerNullableReturnedFromNonnullCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerNullableReturnedFromNonnullChecker(final CheckerManager /*&*/ mgr) {
  NullabilityChecker /*P*/ checker = mgr.<NullabilityChecker>registerChecker(NullabilityChecker.class);
  checker.Filter.CheckNullableReturnedFromNonnull.$assign(/*KEEP_BOOL*/true);
  checker.Filter.CheckNameNullableReturnedFromNonnull.$assignMove(mgr.getCurrentCheckName());
  checker.NeedTracking.$assign(/*KEEP_BOOL*/checker.NeedTracking.$BoolRef() || true);
  checker.NoDiagnoseCallsToSystemHeaders.$assign(/*KEEP_BOOL*/checker.NoDiagnoseCallsToSystemHeaders.$BoolRef() || mgr.getAnalyzerOptions().getBooleanOption(new StringRef(/*KEEP_STR*/"NoDiagnoseCallsToSystemHeaders"), false, checker, true));
}

} // END OF class NullabilityCheckerEntoGlobals
