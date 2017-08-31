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

package org.clang.staticanalyzer.core.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.impl.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerCheckerManagerFunctions.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckBranchConditionContext">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 438,
 FQN="(anonymous namespace)::CheckBranchConditionContext", NM="_ZN12_GLOBAL__N_127CheckBranchConditionContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_127CheckBranchConditionContextE")
//</editor-fold>
public class/*struct*/ CheckBranchConditionContext extends BaseContext<Check$CheckBranchConditionFunc> {
  /*typedef std::vector<CheckerManager::CheckBranchConditionFunc> CheckersTy*/
//  public final class CheckersTy extends std.vector<Check$CheckBranchConditionFunc>{ };
  public final /*const*/std.vector<Check$CheckBranchConditionFunc> /*&*/ Checkers;
  public /*const*/ Stmt /*P*/ Condition;
  public final ExprEngine /*&*/ Eng;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckBranchConditionContext::checkers_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 444,
   FQN="(anonymous namespace)::CheckBranchConditionContext::checkers_begin", NM="_ZN12_GLOBAL__N_127CheckBranchConditionContext14checkers_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_127CheckBranchConditionContext14checkers_beginEv")
  //</editor-fold>
  public std.vector.iterator</*const*/Check$CheckBranchConditionFunc/*P*/> checkers_begin() {
    return Checkers.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckBranchConditionContext::checkers_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 445,
   FQN="(anonymous namespace)::CheckBranchConditionContext::checkers_end", NM="_ZN12_GLOBAL__N_127CheckBranchConditionContext12checkers_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_127CheckBranchConditionContext12checkers_endEv")
  //</editor-fold>
  public std.vector.iterator</*const*/Check$CheckBranchConditionFunc/*P*/> checkers_end() {
    return Checkers.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckBranchConditionContext::CheckBranchConditionContext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 447,
   FQN="(anonymous namespace)::CheckBranchConditionContext::CheckBranchConditionContext", NM="_ZN12_GLOBAL__N_127CheckBranchConditionContextC1ERKSt6vectorIN5clang4ento9CheckerFnIFvPKNS2_4StmtERNS3_14CheckerContextEEEESaISB_EES7_RNS3_10ExprEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_127CheckBranchConditionContextC1ERKSt6vectorIN5clang4ento9CheckerFnIFvPKNS2_4StmtERNS3_14CheckerContextEEEESaISB_EES7_RNS3_10ExprEngineE")
  //</editor-fold>
  public CheckBranchConditionContext(final /*const*/std.vector<Check$CheckBranchConditionFunc> /*&*/ checkers, 
      /*const*/ Stmt /*P*/ Cond, final ExprEngine /*&*/ eng) {
    // : Checkers(checkers), Condition(Cond), Eng(eng) 
    //START JInit
    super(eng);
    this./*&*/Checkers=/*&*/checkers;
    this.Condition = Cond;
    this./*&*/Eng=/*&*/eng;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckBranchConditionContext::runChecker">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 451,
   FQN="(anonymous namespace)::CheckBranchConditionContext::runChecker", NM="_ZN12_GLOBAL__N_127CheckBranchConditionContext10runCheckerEN5clang4ento9CheckerFnIFvPKNS1_4StmtERNS2_14CheckerContextEEEERNS2_11NodeBuilderEPNS2_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_127CheckBranchConditionContext10runCheckerEN5clang4ento9CheckerFnIFvPKNS1_4StmtERNS2_14CheckerContextEEEERNS2_11NodeBuilderEPNS2_12ExplodedNodeE")
  //</editor-fold>
  public void runChecker(Check$CheckBranchConditionFunc checkFn, 
            final NodeBuilder /*&*/ Bldr, ExplodedNode /*P*/ Pred) {
    ProgramPoint L = new ProgramPoint(JD$Move.INSTANCE, new PostCondition(Condition, Pred.getLocationContext(), 
            checkFn.getChecker()));
    CheckerContext C/*J*/= new CheckerContext(Bldr, Eng, Pred, L);
    checkFn.$call(checkFn.getChecker(),Condition, C);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckBranchConditionContext::CheckBranchConditionContext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 438,
   FQN="(anonymous namespace)::CheckBranchConditionContext::CheckBranchConditionContext", NM="_ZN12_GLOBAL__N_127CheckBranchConditionContextC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_127CheckBranchConditionContextC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CheckBranchConditionContext(final /*const*/ CheckBranchConditionContext /*&*/ $Prm0) {
    // : Checkers(.Checkers), Condition(.Condition), Eng(.Eng) 
    //START JInit
    super($Prm0.Eng);
    this./*&*/Checkers=/*&*/$Prm0.Checkers;
    this.Condition = $Prm0.Condition;
    this./*&*/Eng=/*&*/$Prm0.Eng;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Checkers=" + Checkers // NOI18N
              + ", Condition=" + Condition // NOI18N
              + ", Eng=" + "[ExprEngine]"; // NOI18N
  }
}
