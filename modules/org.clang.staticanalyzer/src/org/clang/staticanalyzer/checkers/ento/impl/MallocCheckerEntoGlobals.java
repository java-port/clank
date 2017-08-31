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
import org.clang.staticanalyzer.checkers.impl.*;
import org.clang.staticanalyzer.core.ento.*;


//<editor-fold defaultstate="collapsed" desc="static type MallocCheckerEntoGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN5clang4ento21registerMallocCheckerERNS0_14CheckerManagerE;_ZN5clang4ento24registerNewDeleteCheckerERNS0_14CheckerManagerE;_ZN5clang4ento29registerNewDeleteLeaksCheckerERNS0_14CheckerManagerE;_ZN5clang4ento36registerMismatchedDeallocatorCheckerERNS0_14CheckerManagerE; -static-type=MallocCheckerEntoGlobals -package=org.clang.staticanalyzer.checkers.ento.impl")
//</editor-fold>
public final class MallocCheckerEntoGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerMallocChecker">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2753,
 FQN="clang::ento::registerMallocChecker", NM="_ZN5clang4ento21registerMallocCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN5clang4ento21registerMallocCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerMallocChecker(final CheckerManager /*&*/ mgr) {
  CStringCheckerEntoStatics.registerCStringCheckerBasic(mgr);
  MallocChecker /*P*/ checker = mgr.<MallocChecker>registerChecker(MallocChecker.class);
  checker.IsOptimistic.$assign(/*KEEP_BOOL*/mgr.getAnalyzerOptions().getBooleanOption(new StringRef(/*KEEP_STR*/"Optimistic"), false, checker));
  checker.ChecksEnabled[MallocChecker.CheckKind.CK_MallocChecker.getValue()].$assign(/*KEEP_BOOL*/true);
  checker.CheckNames[MallocChecker.CheckKind.CK_MallocChecker.getValue()].$assignMove(mgr.getCurrentCheckName());
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerMismatchedDeallocatorChecker">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2755,
 FQN="clang::ento::registerMismatchedDeallocatorChecker", NM="_ZN5clang4ento36registerMismatchedDeallocatorCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN5clang4ento36registerMismatchedDeallocatorCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerMismatchedDeallocatorChecker(final CheckerManager /*&*/ mgr) {
  CStringCheckerEntoStatics.registerCStringCheckerBasic(mgr);
  MallocChecker /*P*/ checker = mgr.<MallocChecker>registerChecker(MallocChecker.class);
  checker.IsOptimistic.$assign(/*KEEP_BOOL*/mgr.getAnalyzerOptions().getBooleanOption(new StringRef(/*KEEP_STR*/"Optimistic"), false, checker));
  checker.ChecksEnabled[MallocChecker.CheckKind.CK_MismatchedDeallocatorChecker.getValue()].$assign(/*KEEP_BOOL*/true);
  checker.CheckNames[MallocChecker.CheckKind.CK_MismatchedDeallocatorChecker.getValue()].$assignMove(mgr.getCurrentCheckName());
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerNewDeleteChecker">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2754,
 FQN="clang::ento::registerNewDeleteChecker", NM="_ZN5clang4ento24registerNewDeleteCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN5clang4ento24registerNewDeleteCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerNewDeleteChecker(final CheckerManager /*&*/ mgr) {
  CStringCheckerEntoStatics.registerCStringCheckerBasic(mgr);
  MallocChecker /*P*/ checker = mgr.<MallocChecker>registerChecker(MallocChecker.class);
  checker.IsOptimistic.$assign(/*KEEP_BOOL*/mgr.getAnalyzerOptions().getBooleanOption(new StringRef(/*KEEP_STR*/"Optimistic"), false, checker));
  checker.ChecksEnabled[MallocChecker.CheckKind.CK_NewDeleteChecker.getValue()].$assign(/*KEEP_BOOL*/true);
  checker.CheckNames[MallocChecker.CheckKind.CK_NewDeleteChecker.getValue()].$assignMove(mgr.getCurrentCheckName());
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::registerNewDeleteLeaksChecker">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp", line = 2729,
 FQN="clang::ento::registerNewDeleteLeaksChecker", NM="_ZN5clang4ento29registerNewDeleteLeaksCheckerERNS0_14CheckerManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN5clang4ento29registerNewDeleteLeaksCheckerERNS0_14CheckerManagerE")
//</editor-fold>
public static void registerNewDeleteLeaksChecker(final CheckerManager /*&*/ mgr) {
  CStringCheckerEntoStatics.registerCStringCheckerBasic(mgr);
  MallocChecker /*P*/ checker = mgr.<MallocChecker>registerChecker(MallocChecker.class);
  checker.IsOptimistic.$assign(/*KEEP_BOOL*/mgr.getAnalyzerOptions().getBooleanOption(new StringRef(/*KEEP_STR*/"Optimistic"), false, checker));
  checker.ChecksEnabled[MallocChecker.CheckKind.CK_NewDeleteLeaksChecker.getValue()].$assign(/*KEEP_BOOL*/true);
  checker.CheckNames[MallocChecker.CheckKind.CK_NewDeleteLeaksChecker.getValue()].$assignMove(
      mgr.getCurrentCheckName()
  );
  // We currently treat NewDeleteLeaks checker as a subchecker of NewDelete
  // checker.
  if (!checker.ChecksEnabled[MallocChecker.CheckKind.CK_NewDeleteChecker.getValue()].$BoolRef()) {
    checker.ChecksEnabled[MallocChecker.CheckKind.CK_NewDeleteChecker.getValue()].$assign(/*KEEP_BOOL*/true);
  }
}

} // END OF class MallocCheckerEntoGlobals
