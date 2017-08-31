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
package org.clang.analysis.analyses.threadSafety.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.clang.analysis.*;
import org.clang.analysis.impl.*;
import org.clang.analysis.threadSafety.impl.*;
import org.clang.analysis.analyses.threadSafety.*;


//<editor-fold defaultstate="collapsed" desc="static type ThreadSafetyThreadSafetyGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety19threadSafetyCleanupEPNS0_9BeforeSetE;_ZN5clang12threadSafety23runThreadSafetyAnalysisERNS_19AnalysisDeclContextERNS0_19ThreadSafetyHandlerEPPNS0_9BeforeSetE;_ZN5clang12threadSafety25getLockKindFromAccessKindENS0_10AccessKindE; -static-type=ThreadSafetyThreadSafetyGlobals -package=org.clang.analysis.analyses.threadSafety.impl")
//</editor-fold>
public final class ThreadSafetyThreadSafetyGlobals {


/// \brief Check a function's CFG for thread-safety violations.
///
/// We traverse the blocks in the CFG, compute the set of mutexes that are held
/// at the end of each block, and issue warnings for thread safety violations.
/// Each block in the CFG is traversed exactly once.

/// \brief Check a function's CFG for thread-safety violations.
///
/// We traverse the blocks in the CFG, compute the set of mutexes that are held
/// at the end of each block, and issue warnings for thread safety violations.
/// Each block in the CFG is traversed exactly once.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::runThreadSafetyAnalysis">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 2385,
 FQN="clang::threadSafety::runThreadSafetyAnalysis", NM="_ZN5clang12threadSafety23runThreadSafetyAnalysisERNS_19AnalysisDeclContextERNS0_19ThreadSafetyHandlerEPPNS0_9BeforeSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety23runThreadSafetyAnalysisERNS_19AnalysisDeclContextERNS0_19ThreadSafetyHandlerEPPNS0_9BeforeSetE")
//</editor-fold>
public static void runThreadSafetyAnalysis(final AnalysisDeclContext /*&*/ AC, 
                       final ThreadSafetyHandler /*&*/ Handler, 
                       type$ptr<BeforeSet /*P*/ /*P*/> BSet) {
  ThreadSafetyAnalyzer Analyzer = null;
  try {
    if (!(BSet.$star() != null)) {
      BSet.$set(new BeforeSet());
    }
    Analyzer/*J*/= new ThreadSafetyAnalyzer(Handler, BSet.$star());
    Analyzer.runAnalysis(AC);
  } finally {
    if (Analyzer != null) { Analyzer.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::threadSafetyCleanup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 2394,
 FQN="clang::threadSafety::threadSafetyCleanup", NM="_ZN5clang12threadSafety19threadSafetyCleanupEPNS0_9BeforeSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety19threadSafetyCleanupEPNS0_9BeforeSetE")
//</editor-fold>
public static void threadSafetyCleanup(BeforeSet /*P*/ Cache) {
  if (Cache != null) { Cache.$destroy();};
}


/// \brief Helper function that returns a LockKind required for the given level
/// of access.

/// \brief Helper function that returns a LockKind required for the given level
/// of access.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::getLockKindFromAccessKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 2398,
 FQN="clang::threadSafety::getLockKindFromAccessKind", NM="_ZN5clang12threadSafety25getLockKindFromAccessKindENS0_10AccessKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety25getLockKindFromAccessKindENS0_10AccessKindE")
//</editor-fold>
public static LockKind getLockKindFromAccessKind(AccessKind AK) {
  switch (AK) {
   case AK_Read:
    return LockKind.LK_Shared;
   case AK_Written:
    return LockKind.LK_Exclusive;
  }
  throw new llvm_unreachable("Unknown AccessKind");
}

} // END OF class ThreadSafetyThreadSafetyGlobals
