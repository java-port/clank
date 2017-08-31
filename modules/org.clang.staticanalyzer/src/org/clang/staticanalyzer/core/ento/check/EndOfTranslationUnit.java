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
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerCheckerManagerFunctions.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::check::EndOfTranslationUnit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 63,
 FQN="clang::ento::check::EndOfTranslationUnit", NM="_ZN5clang4ento5check20EndOfTranslationUnitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN5clang4ento5check20EndOfTranslationUnitE")
//</editor-fold>
public class EndOfTranslationUnit implements CheckBase {
  /*template <typename CHECKER> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::check::EndOfTranslationUnit::_checkEndOfTranslationUnit">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 65,
   FQN="clang::ento::check::EndOfTranslationUnit::_checkEndOfTranslationUnit", NM="Tpl__ZN5clang4ento5check20EndOfTranslationUnit26_checkEndOfTranslationUnitEPvPKNS_19TranslationUnitDeclERNS0_15AnalysisManagerERNS0_11BugReporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=Tpl__ZN5clang4ento5check20EndOfTranslationUnit26_checkEndOfTranslationUnitEPvPKNS_19TranslationUnitDeclERNS0_15AnalysisManagerERNS0_11BugReporterE")
  //</editor-fold>
  private void _checkEndOfTranslationUnit(CheckerBase/*void P*/ checker, 
                            /*const*/ TranslationUnitDecl /*P*/ TU, 
                            final AnalysisManager /*&*/ mgr, 
                            final BugReporter /*&*/ BR) {
    ((/*const*/ EndOfTranslationUnitChecker /*P*/ )checker).checkEndOfTranslationUnit(TU, mgr, BR);
  }

/*public:*/
  /*template <typename CHECKER> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::check::EndOfTranslationUnit::_register">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 74,
   FQN="clang::ento::check::EndOfTranslationUnit::_register", NM="Tpl__ZN5clang4ento5check20EndOfTranslationUnit9_registerEPT_RNS0_14CheckerManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=Tpl__ZN5clang4ento5check20EndOfTranslationUnit9_registerEPT_RNS0_14CheckerManagerE")
  //</editor-fold>
  public void _register(CheckerBase /*P*/ checker, final CheckerManager /*&*/ mgr) {
    assert checker instanceof EndOfTranslationUnitChecker : "forgot to add implement? " + checker.getClass();
    mgr._registerForEndOfTranslationUnit(new Check$CheckEndOfTranslationUnit(){
      @Override
      public void $call(Object C, TranslationUnitDecl tu, AnalysisManager am, BugReporter br) {
        _checkEndOfTranslationUnit(checker, tu, am, br);
      }

      @Override
      public CheckerBase getChecker() {
        return checker;
      }
    }//(checker, _checkEndOfTranslationUnit<CHECKER>)
    );
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::check::EndOfTranslationUnit::EndOfTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 63,
   FQN="clang::ento::check::EndOfTranslationUnit::EndOfTranslationUnit", NM="_ZN5clang4ento5check20EndOfTranslationUnitC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DebugCheckers.cpp -nm=_ZN5clang4ento5check20EndOfTranslationUnitC1Ev")
  //</editor-fold>
  public /*inline*/ EndOfTranslationUnit() {
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
