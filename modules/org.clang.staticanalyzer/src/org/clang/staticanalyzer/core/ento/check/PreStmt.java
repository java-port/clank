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

import org.clang.staticanalyzer.java.CheckBase;
import org.clank.support.*;
import static org.llvm.support.llvm.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerCheckerManagerFunctions.*;
import org.clang.staticanalyzer.java.*;

/*template <typename STMT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ento::check::PreStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 81,
 FQN="clang::ento::check::PreStmt", NM="_ZN5clang4ento5check7PreStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clang4ento5check7PreStmtE")
//</editor-fold>
public class PreStmt</*typename*/ STMT extends Stmt> implements CheckBase {
  
  private final Class<STMT> cls;

  public PreStmt(Class<STMT> cls) {
    this.cls = cls;
  }
  
  /*template <typename CHECKER> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::check::PreStmt::_checkStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 84,
   FQN="clang::ento::check::PreStmt::_checkStmt", NM="Tpl__ZN5clang4ento5check7PreStmt10_checkStmtEPvPKNS_4StmtERNS0_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=Tpl__ZN5clang4ento5check7PreStmt10_checkStmtEPvPKNS_4StmtERNS0_14CheckerContextE")
  //</editor-fold>
  private void _checkStmt(PreStmtChecker/*void P*/ checker, /*const*/ Stmt /*P*/ S, final CheckerContext /*&*/ C) {
    ((/*const*/ PreStmtChecker /*P*/ )checker).$checkPreStmt(cast(cls, S), C);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::check::PreStmt::_handlesStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 88,
   FQN="clang::ento::check::PreStmt::_handlesStmt", NM="_ZN5clang4ento5check7PreStmt12_handlesStmtEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clang4ento5check7PreStmt12_handlesStmtEPKNS_4StmtE")
  //</editor-fold>
  private boolean _handlesStmt(/*const*/ Stmt /*P*/ S) {
    return isa(cls, S);
  }

/*public:*/
  /*template <typename CHECKER> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::check::PreStmt::_register">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 93,
   FQN="clang::ento::check::PreStmt::_register", NM="Tpl__ZN5clang4ento5check7PreStmt9_registerEPT_RNS0_14CheckerManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=Tpl__ZN5clang4ento5check7PreStmt9_registerEPT_RNS0_14CheckerManagerE")
  //</editor-fold>
  public void _register(final CheckerBase /*P*/ checker, final CheckerManager /*&*/ mgr) {
    assert checker instanceof PreStmtChecker : "forgot to add implement? " + checker.getClass();
    mgr._registerForPreStmt(
            new Check$CheckStmtFunc() {
              @Override public void $call(Object C, Stmt s, CheckerContext cc) {
                _checkStmt((PreStmtChecker) checker, s, cc);
              }
              @Override public CheckerBase getChecker() {
                return checker;
              }
            }, //checker, _checkStmt<CHECKER>),
            (Stmt S) -> _handlesStmt(S) ///*FuncRef*/PreStmt::_handlesStmt);
    );
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
