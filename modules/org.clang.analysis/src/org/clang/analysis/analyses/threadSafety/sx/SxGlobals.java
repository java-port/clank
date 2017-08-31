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
package org.clang.analysis.analyses.threadSafety.sx;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.support.*;
import static org.clang.analysis.java.AnalysisRTTI.*;
import org.clang.analysis.analyses.threadSafety.til.*;


//<editor-fold defaultstate="collapsed" desc="static type SxGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety2sx16partiallyMatchesEPKNS0_3til5SExprES5_;_ZN5clang12threadSafety2sx6equalsEPKNS0_3til5SExprES5_;_ZN5clang12threadSafety2sx7matchesEPKNS0_3til5SExprES5_;_ZN5clang12threadSafety2sx8toStringEPKNS0_3til5SExprE; -static-type=SxGlobals -package=org.clang.analysis.analyses.threadSafety.sx")
//</editor-fold>
public final class SxGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::sx::equals">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 43,
 FQN="clang::threadSafety::sx::equals", NM="_ZN5clang12threadSafety2sx6equalsEPKNS0_3til5SExprES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety2sx6equalsEPKNS0_3til5SExprES5_")
//</editor-fold>
public static /*inline*/ boolean equals(/*const*/ SExpr /*P*/ E1, /*const*/ SExpr /*P*/ E2) {
  return EqualsComparator.compareExprs(E1, E2);
}

//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::sx::matches">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 47,
 FQN="clang::threadSafety::sx::matches", NM="_ZN5clang12threadSafety2sx7matchesEPKNS0_3til5SExprES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety2sx7matchesEPKNS0_3til5SExprES5_")
//</editor-fold>
public static /*inline*/ boolean matches(/*const*/ SExpr /*P*/ E1, /*const*/ SExpr /*P*/ E2) {
  // We treat a top-level wildcard as the "univsersal" lock.
  // It matches everything for the purpose of checking locks, but not
  // for unlocking them.
  if (isa_Wildcard(E1)) {
    return isa_Wildcard(E2);
  }
  if (isa_Wildcard(E2)) {
    return isa_Wildcard(E1);
  }
  
  return MatchComparator.compareExprs(E1, E2);
}

//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::sx::partiallyMatches">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 59,
 FQN="clang::threadSafety::sx::partiallyMatches", NM="_ZN5clang12threadSafety2sx16partiallyMatchesEPKNS0_3til5SExprES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety2sx16partiallyMatchesEPKNS0_3til5SExprES5_")
//</editor-fold>
public static /*inline*/ boolean partiallyMatches(/*const*/ SExpr /*P*/ E1, /*const*/ SExpr /*P*/ E2) {
  /*const*/ Project /*P*/ PE1 = dyn_cast_or_null_Project(E1);
  if (!(PE1 != null)) {
    return false;
  }
  /*const*/ Project /*P*/ PE2 = dyn_cast_or_null_Project(E2);
  if (!(PE2 != null)) {
    return false;
  }
  return PE1.clangDecl() == PE2.clangDecl();
}

//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::sx::toString">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 69,
 FQN="clang::threadSafety::sx::toString", NM="_ZN5clang12threadSafety2sx8toStringEPKNS0_3til5SExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZN5clang12threadSafety2sx8toStringEPKNS0_3til5SExprE")
//</editor-fold>
public static /*inline*/ std.string __toString(/*const*/ SExpr /*P*/ E) {
  // JAVA: in native std::stringstream is used here
  raw_string_ostream ss = null;
  try {
    ss/*J*/= new raw_string_ostream(new std.string());
    StdPrinter.print(E, ss);
    return ss.str();
  } finally {
    if (ss != null) { ss.$destroy(); }
  }
}

} // END OF class SxGlobals
