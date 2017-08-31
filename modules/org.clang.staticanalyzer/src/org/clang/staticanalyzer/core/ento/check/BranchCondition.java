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
import org.clang.ast.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerCheckerManagerFunctions.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::check::BranchCondition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 270,
 FQN="clang::ento::check::BranchCondition", NM="_ZN5clang4ento5check15BranchConditionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp -nm=_ZN5clang4ento5check15BranchConditionE")
//</editor-fold>
public class BranchCondition implements CheckBase {
  /*template <typename CHECKER> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::check::BranchCondition::_checkBranchCondition">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 272,
   FQN="clang::ento::check::BranchCondition::_checkBranchCondition", NM="Tpl__ZN5clang4ento5check15BranchCondition21_checkBranchConditionEPvPKNS_4StmtERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp -nm=Tpl__ZN5clang4ento5check15BranchCondition21_checkBranchConditionEPvPKNS_4StmtERNS0_14CheckerContextE")
  //</editor-fold>
  private void _checkBranchCondition(CheckerBase/*void P*/ checker, /*const*/ Stmt /*P*/ Condition, 
                       final CheckerContext /*&*/ C) {
    ((/*const*/ BranchConditionChecker /*P*/ )checker).checkBranchCondition(Condition, C);
  }

/*public:*/
  /*template <typename CHECKER> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::check::BranchCondition::_register">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 279,
   FQN="clang::ento::check::BranchCondition::_register", NM="Tpl__ZN5clang4ento5check15BranchCondition9_registerEPT_RNS0_14CheckerManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp -nm=Tpl__ZN5clang4ento5check15BranchCondition9_registerEPT_RNS0_14CheckerManagerE")
  //</editor-fold>
  public void _register(CheckerBase /*P*/ checker, final CheckerManager /*&*/ mgr) {
    assert checker instanceof BranchConditionChecker : "forgot to add implement? " + checker.getClass();
    mgr._registerForBranchCondition(new Check$CheckBranchConditionFunc(){
      @Override
      public void $call(Object C, Stmt stm, CheckerContext cc) {
        _checkBranchCondition(checker, stm, cc);
      }

      @Override
      public CheckerBase getChecker() {
        return checker;
      }
    }//(checker, _checkBranchCondition<CHECKER>)
    );
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::check::BranchCondition::BranchCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 270,
   FQN="clang::ento::check::BranchCondition::BranchCondition", NM="_ZN5clang4ento5check15BranchConditionC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp -nm=_ZN5clang4ento5check15BranchConditionC1Ev")
  //</editor-fold>
  public /*inline*/ BranchCondition() {
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
