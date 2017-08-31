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

package org.clang.staticanalyzer.core.ento.check;

import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerCheckerManagerFunctions.*;
import org.clang.staticanalyzer.java.*;
import static org.clank.support.Native.$createJavaCleaner;

//<editor-fold defaultstate="collapsed" desc="clang::ento::check::RegionChanges">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 316,
 FQN="clang::ento::check::RegionChanges", NM="_ZN5clang4ento5check13RegionChangesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento5check13RegionChangesE")
//</editor-fold>
public class RegionChanges implements CheckBase {
  /*template <typename CHECKER> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::check::RegionChanges::_checkRegionChanges">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 318,
   FQN="clang::ento::check::RegionChanges::_checkRegionChanges", NM="Tpl__ZN5clang4ento5check13RegionChanges19_checkRegionChangesEPvN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS4_8DenseSetIPKNS0_7SymExprENS4_12DenseMapInfoISC_EEEENS4_8ArrayRefIPKNS0_9MemRegionEEESM_PKNS0_9CallEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=Tpl__ZN5clang4ento5check13RegionChanges19_checkRegionChangesEPvN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS4_8DenseSetIPKNS0_7SymExprENS4_12DenseMapInfoISC_EEEENS4_8ArrayRefIPKNS0_9MemRegionEEESM_PKNS0_9CallEventE")
  //</editor-fold>
  private </*typename*/ CHECKER extends RegionChangesChecker> IntrusiveRefCntPtr</*const*/ ProgramState> _checkRegionChanges(CHECKER/*void P*/ checker, 
                     IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                     /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*P*/ invalidated, 
                     ArrayRef</*const*/ MemRegion /*P*/ > Explicits, 
                     ArrayRef</*const*/ MemRegion /*P*/ > Regions, 
                     /*const*/ CallEvent /*P*/ Call) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(((/*const*/ CHECKER /*P*/ )checker).checkRegionChanges($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), invalidated, 
          new ArrayRef</*const*/ MemRegion /*P*/ >(Explicits), new ArrayRef</*const*/ MemRegion /*P*/ >(Regions), Call));
    } finally {
      $c$.$destroy();
    }
  }

  /*template <typename CHECKER> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::check::RegionChanges::_wantsRegionChangeUpdate">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 329,
   FQN="clang::ento::check::RegionChanges::_wantsRegionChangeUpdate", NM="Tpl__ZN5clang4ento5check13RegionChanges24_wantsRegionChangeUpdateEPvN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=Tpl__ZN5clang4ento5check13RegionChanges24_wantsRegionChangeUpdateEPvN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
  //</editor-fold>
  private </*typename*/ CHECKER extends RegionChangesChecker> boolean _wantsRegionChangeUpdate(CHECKER/*void P*/ checker, 
                          IntrusiveRefCntPtr</*const*/ ProgramState> state) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(((/*const*/ CHECKER /*P*/ )checker).wantsRegionChangeUpdate($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      $c$.$destroy();
    }
  }

/*public:*/
  /*template <typename CHECKER> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::check::RegionChanges::_register">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 336,
   FQN="clang::ento::check::RegionChanges::_register", NM="Tpl__ZN5clang4ento5check13RegionChanges9_registerEPT_RNS0_14CheckerManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=Tpl__ZN5clang4ento5check13RegionChanges9_registerEPT_RNS0_14CheckerManagerE")
  //</editor-fold>
  public void _register(final CheckerBase /*P*/ checker, final CheckerManager /*&*/ mgr) {
    assert checker instanceof RegionChangesChecker : "forgot to add implement? " + checker.getClass();
    mgr._registerForRegionChanges(
            new Check$CheckRegionChangesFunc() {
              @Override
              public IntrusiveRefCntPtr $call(Object C, IntrusiveRefCntPtr state, DenseSet ses, ArrayRef mrs, ArrayRef mrs2, CallEvent call) {
                return _checkRegionChanges((RegionChangesChecker)checker, state, ses, mrs, mrs2, call);
              }

              @Override
              public CheckerBase getChecker() {
                return checker;
              }
            },
            new Check$WantsRegionChangeUpdateFunc() {
              @Override
              public boolean $call(Object C, IntrusiveRefCntPtr state) {
                return _wantsRegionChangeUpdate((RegionChangesChecker)checker, state);
              }

              @Override
              public CheckerBase getChecker() {
                return checker;
              }
            }
    );
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::check::RegionChanges::RegionChanges">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 316,
   FQN="clang::ento::check::RegionChanges::RegionChanges", NM="_ZN5clang4ento5check13RegionChangesC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringChecker.cpp -nm=_ZN5clang4ento5check13RegionChangesC1Ev")
  //</editor-fold>
  public /*inline*/ RegionChanges() {
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
