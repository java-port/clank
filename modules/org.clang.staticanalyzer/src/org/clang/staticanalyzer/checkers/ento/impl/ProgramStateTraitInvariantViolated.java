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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


// We say "the nullability type invariant is violated" when a location with a
// non-null type contains NULL or a function with a non-null return type returns
// NULL. Violations of the nullability type invariant can be detected either
// directly (for example, when NULL is passed as an argument to a nonnull
// parameter) or indirectly (for example, when, inside a function, the
// programmer defensively checks whether a nonnull parameter contains NULL and
// finds that it does).
//
// As a matter of policy, the nullability checker typically warns on direct
// violations of the nullability invariant (although it uses various
// heuristics to suppress warnings in some cases) but will not warn if the
// invariant has already been violated along the path (either directly or
// indirectly). As a practical matter, this prevents the analyzer from
// (1) warning on defensive code paths where a nullability precondition is
// determined to have been violated, (2) warning additional times after an
// initial direct violation has been discovered, and (3) warning after a direct
// violation that has been implicitly or explicitly suppressed (for
// example, with a cast of NULL to _Nonnull). In essence, once an invariant
// violation is detected on a path, this checker will be esentially turned off
// for the rest of the analysis
//
// The analyzer takes this approach (rather than generating a sink node) to
// ensure coverage of defensive paths, which may be important for backwards
// compatibility in codebases that were developed without nullability in mind.
//<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateTrait<(anonymous)::InvariantViolated>">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 274,
 FQN="clang::ento::ProgramStateTrait<(anonymous)::InvariantViolated>", NM="_ZN5clang4ento17ProgramStateTraitIN12_GLOBAL__N_117InvariantViolatedEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN5clang4ento17ProgramStateTraitIN12_GLOBAL__N_117InvariantViolatedEEE")
//</editor-fold>
public class/*struct*/ ProgramStateTraitInvariantViolated extends /*public*/ ProgramStatePartialTraitBool {
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStateTrait<(anonymous)::InvariantViolated>::GDMIndex">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp", line = 274,
   FQN="clang::ento::ProgramStateTrait<(anonymous)::InvariantViolated>::GDMIndex", NM="_ZN5clang4ento17ProgramStateTraitIN12_GLOBAL__N_117InvariantViolatedEE8GDMIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NullabilityChecker.cpp -nm=_ZN5clang4ento17ProgramStateTraitIN12_GLOBAL__N_117InvariantViolatedEE8GDMIndexEv")
  //</editor-fold>
  public Object/*void P*/ GDMIndex() {
    final/*static*/ Object Index = GDMIndex$$.Index;
    return $AddrOf(Index);
  }
  private static final class GDMIndex$$ {
    static final/*static*/ Object Index = ProgramStateTraitInvariantViolated.class;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private ProgramStateTraitInvariantViolated() {}
  
  public static ProgramStateTraitInvariantViolated $Instance = new ProgramStateTraitInvariantViolated();

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
