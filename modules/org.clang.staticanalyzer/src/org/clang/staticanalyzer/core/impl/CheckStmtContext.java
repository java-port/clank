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

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.impl.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerCheckerManagerFunctions.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckStmtContext">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 136,
 FQN="(anonymous namespace)::CheckStmtContext", NM="_ZN12_GLOBAL__N_116CheckStmtContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_116CheckStmtContextE")
//</editor-fold>
public class/*struct*/ CheckStmtContext extends BaseContext<Check$CheckStmtFunc> {
  /*typedef SmallVectorImpl<CheckerManager::CheckStmtFunc> CheckersTy*/
//  public final class CheckersTy extends SmallVectorImpl<Check$CheckStmtFunc>{ };
  public boolean IsPreVisit;
  public final /*const*/ SmallVectorImpl<Check$CheckStmtFunc> /*&*/ Checkers;
  public /*const*/ Stmt /*P*/ S;
  public final ExprEngine /*&*/ Eng;
  public boolean WasInlined;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckStmtContext::checkers_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 144,
   FQN="(anonymous namespace)::CheckStmtContext::checkers_begin", NM="_ZN12_GLOBAL__N_116CheckStmtContext14checkers_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_116CheckStmtContext14checkers_beginEv")
  //</editor-fold>
  public type$ptr</*const*/Check$CheckStmtFunc/*P*/ > checkers_begin() {
    return Checkers.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckStmtContext::checkers_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 145,
   FQN="(anonymous namespace)::CheckStmtContext::checkers_end", NM="_ZN12_GLOBAL__N_116CheckStmtContext12checkers_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_116CheckStmtContext12checkers_endEv")
  //</editor-fold>
  public type$ptr</*const*/Check$CheckStmtFunc/*P*/ > checkers_end() {
    return Checkers.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckStmtContext::CheckStmtContext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 147,
   FQN="(anonymous namespace)::CheckStmtContext::CheckStmtContext", NM="_ZN12_GLOBAL__N_116CheckStmtContextC1EbRKN4llvm15SmallVectorImplIN5clang4ento9CheckerFnIFvPKNS3_4StmtERNS4_14CheckerContextEEEEEES8_RNS4_10ExprEngineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_116CheckStmtContextC1EbRKN4llvm15SmallVectorImplIN5clang4ento9CheckerFnIFvPKNS3_4StmtERNS4_14CheckerContextEEEEEES8_RNS4_10ExprEngineEb")
  //</editor-fold>
  public CheckStmtContext(boolean isPreVisit, final /*const*/ SmallVectorImpl<Check$CheckStmtFunc> /*&*/ checkers, 
      /*const*/ Stmt /*P*/ s, final ExprEngine /*&*/ eng) {
    this(isPreVisit, checkers, 
      s, eng, false);
  }
  public CheckStmtContext(boolean isPreVisit, final /*const*/ SmallVectorImpl<Check$CheckStmtFunc> /*&*/ checkers, 
      /*const*/ Stmt /*P*/ s, final ExprEngine /*&*/ eng, boolean wasInlined/*= false*/) {
    // : IsPreVisit(isPreVisit), Checkers(checkers), S(s), Eng(eng), WasInlined(wasInlined) 
    //START JInit
    super(eng);
    this.IsPreVisit = isPreVisit;
    this./*&*/Checkers=/*&*/checkers;
    this.S = s;
    this./*&*/Eng=/*&*/eng;
    this.WasInlined = wasInlined;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckStmtContext::runChecker">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 152,
   FQN="(anonymous namespace)::CheckStmtContext::runChecker", NM="_ZN12_GLOBAL__N_116CheckStmtContext10runCheckerEN5clang4ento9CheckerFnIFvPKNS1_4StmtERNS2_14CheckerContextEEEERNS2_11NodeBuilderEPNS2_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_116CheckStmtContext10runCheckerEN5clang4ento9CheckerFnIFvPKNS1_4StmtERNS2_14CheckerContextEEEERNS2_11NodeBuilderEPNS2_12ExplodedNodeE")
  //</editor-fold>
  public void runChecker(Check$CheckStmtFunc checkFn, 
            final NodeBuilder /*&*/ Bldr, ExplodedNode /*P*/ Pred) {
    // FIXME: Remove respondsToCallback from CheckerContext;
    ProgramPoint.Kind K = IsPreVisit ? ProgramPoint.Kind.PreStmtKind : ProgramPoint.Kind.PostStmtKind;
    final /*const*/ ProgramPoint /*&*/ L = ProgramPoint.getProgramPoint(S, K, 
        Pred.getLocationContext(), checkFn.getChecker());
    CheckerContext C/*J*/= new CheckerContext(Bldr, Eng, Pred, L, WasInlined);
    checkFn.$call(checkFn.getChecker(), S, C);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckStmtContext::CheckStmtContext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 136,
   FQN="(anonymous namespace)::CheckStmtContext::CheckStmtContext", NM="_ZN12_GLOBAL__N_116CheckStmtContextC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_116CheckStmtContextC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CheckStmtContext(final /*const*/ CheckStmtContext /*&*/ $Prm0) {
    // : IsPreVisit(.IsPreVisit), Checkers(.Checkers), S(.S), Eng(.Eng), WasInlined(.WasInlined) 
    //START JInit
    super($Prm0.Eng);
    this.IsPreVisit = $Prm0.IsPreVisit;
    this./*&*/Checkers=/*&*/$Prm0.Checkers;
    this.S = $Prm0.S;
    this./*&*/Eng=/*&*/$Prm0.Eng;
    this.WasInlined = $Prm0.WasInlined;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "IsPreVisit=" + IsPreVisit // NOI18N
              + ", Checkers=" + Checkers // NOI18N
              + ", S=" + S // NOI18N
              + ", Eng=" + "[ExprEngine]" // NOI18N
              + ", WasInlined=" + WasInlined; // NOI18N
  }
}
