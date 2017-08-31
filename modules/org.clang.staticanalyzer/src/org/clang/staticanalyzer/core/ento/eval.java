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
package org.clang.staticanalyzer.core.ento;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerCheckerManagerFunctions.*;
import org.clang.staticanalyzer.java.*;
import static org.clank.support.Native.$createJavaCleaner;


//<editor-fold defaultstate="collapsed" desc="static type eval">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN5clang4ento4eval4CallE;_ZN5clang4ento4eval6AssumeE; -static-type=eval -package=org.clang.staticanalyzer.core.ento")
//</editor-fold>
public final class eval {

//<editor-fold defaultstate="collapsed" desc="clang::ento::eval::Assume">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 447,
 FQN="clang::ento::eval::Assume", NM="_ZN5clang4ento4eval6AssumeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp -nm=_ZN5clang4ento4eval6AssumeE")
//</editor-fold>
public static class Assume implements CheckBase {
  /*template <typename CHECKER> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::eval::Assume::_evalAssume">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*have not found instantiation, so done manually*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 449,
   FQN="clang::ento::eval::Assume::_evalAssume", NM="Tpl__ZN5clang4ento4eval6Assume11_evalAssumeEPvN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERKNS0_4SValEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp -nm=Tpl__ZN5clang4ento4eval6Assume11_evalAssumeEPvN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEERKNS0_4SValEb")
  //</editor-fold>
  private </*typename*/ CHECKER extends EvalAssumeChecker> IntrusiveRefCntPtr</*const*/ ProgramState> _evalAssume(CHECKER/*void P*/ checker, 
             IntrusiveRefCntPtr</*const*/ ProgramState> state, 
             final /*const*/ SVal /*&*/ cond, 
             boolean assumption) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(((/*const*/ CHECKER /*P*/ )checker).evalAssume($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), cond, assumption));
    } finally {
      $c$.$destroy();
    }
  }

/*public:*/
  /*template <typename CHECKER> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::eval::Assume::_register">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 458,
   FQN="clang::ento::eval::Assume::_register", NM="Tpl__ZN5clang4ento4eval6Assume9_registerEPT_RNS0_14CheckerManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp -nm=Tpl__ZN5clang4ento4eval6Assume9_registerEPT_RNS0_14CheckerManagerE")
  //</editor-fold>
  public void _register(CheckerBase /*P*/ checker, final CheckerManager /*&*/ mgr) {
    assert checker instanceof EvalAssumeChecker : "forgot to add implement? " + checker.getClass();
    mgr._registerForEvalAssume(new Check$EvalAssumeFunc(){
      @Override
      public IntrusiveRefCntPtr $call(Object C, IntrusiveRefCntPtr state, SVal sv, boolean b) {
        return _evalAssume((EvalAssumeChecker)checker, state, sv, b);
      }

      @Override
      public CheckerBase getChecker() {
        return checker;
      }
    });
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::eval::Assume::Assume">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 447,
   FQN="clang::ento::eval::Assume::Assume", NM="_ZN5clang4ento4eval6AssumeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocChecker.cpp -nm=_ZN5clang4ento4eval6AssumeC1Ev")
  //</editor-fold>
  public /*inline*/ Assume() {
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::ento::eval::Call">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 464,
 FQN="clang::ento::eval::Call", NM="_ZN5clang4ento4eval4CallE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp -nm=_ZN5clang4ento4eval4CallE")
//</editor-fold>
public static class Call implements CheckBase {
  /*template <typename CHECKER> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::eval::Call::_evalCall">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 466,
   FQN="clang::ento::eval::Call::_evalCall", NM="Tpl__ZN5clang4ento4eval4Call9_evalCallEPvPKNS_8CallExprERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp -nm=Tpl__ZN5clang4ento4eval4Call9_evalCallEPvPKNS_8CallExprERNS0_14CheckerContextE")
  //</editor-fold>
  private </*typename*/ CHECKER extends EvalCallChecker> boolean _evalCall(CHECKER/*void P*/ checker, /*const*/ CallExpr /*P*/ CE, final CheckerContext /*&*/ C) {
    return ((/*const*/ CHECKER /*P*/ )checker).evalCall(CE, C);
  }

/*public:*/
  /*template <typename CHECKER> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::eval::Call::_register">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 472,
   FQN="clang::ento::eval::Call::_register", NM="Tpl__ZN5clang4ento4eval4Call9_registerEPT_RNS0_14CheckerManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp -nm=Tpl__ZN5clang4ento4eval4Call9_registerEPT_RNS0_14CheckerManagerE")
  //</editor-fold>
  public void _register(CheckerBase /*P*/ checker, final CheckerManager /*&*/ mgr) {
    assert checker instanceof EvalCallChecker : "forgot to add implement? " + checker.getClass();
    mgr._registerForEvalCall(new Check$EvalCallFunc(){
      @Override
      public boolean $call(Object C, CallExpr call, CheckerContext cc) {
        return _evalCall((EvalCallChecker)checker, call, cc);
      }

      @Override
      public CheckerBase getChecker() {
        return checker;
      }
    });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::eval::Call::Call">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 464,
   FQN="clang::ento::eval::Call::Call", NM="_ZN5clang4ento4eval4CallC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp -nm=_ZN5clang4ento4eval4CallC1Ev")
  //</editor-fold>
  public /*inline*/ Call() {
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
} // END OF class eval
