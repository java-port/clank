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
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.impl.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerCheckerManagerFunctions.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckBindContext">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 336,
 FQN="(anonymous namespace)::CheckBindContext", NM="_ZN12_GLOBAL__N_116CheckBindContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_116CheckBindContextE")
//</editor-fold>
public class/*struct*/ CheckBindContext extends BaseContext<Check$CheckBindFunc> {
  /*typedef std::vector<CheckerManager::CheckBindFunc> CheckersTy*/
//  public final class CheckersTy extends std.vector<Check$CheckBindFunc>{ };
  public final /*const*/std.vector<Check$CheckBindFunc> /*&*/ Checkers;
  public SVal Loc;
  public SVal Val;
  public /*const*/ Stmt /*P*/ S;
  public final ExprEngine /*&*/ Eng;
  public final /*const*/ ProgramPoint /*&*/ PP;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckBindContext::checkers_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 345,
   FQN="(anonymous namespace)::CheckBindContext::checkers_begin", NM="_ZN12_GLOBAL__N_116CheckBindContext14checkers_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_116CheckBindContext14checkers_beginEv")
  //</editor-fold>
  public std.vector.iterator</*const*/Check$CheckBindFunc/*P*/> checkers_begin() {
    return Checkers.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckBindContext::checkers_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 346,
   FQN="(anonymous namespace)::CheckBindContext::checkers_end", NM="_ZN12_GLOBAL__N_116CheckBindContext12checkers_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_116CheckBindContext12checkers_endEv")
  //</editor-fold>
  public std.vector.iterator</*const*/Check$CheckBindFunc/*P*/> checkers_end() {
    return Checkers.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckBindContext::CheckBindContext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 348,
   FQN="(anonymous namespace)::CheckBindContext::CheckBindContext", NM="_ZN12_GLOBAL__N_116CheckBindContextC1ERKSt6vectorIN5clang4ento9CheckerFnIFvRKNS3_4SValES7_PKNS2_4StmtERNS3_14CheckerContextEEEESaISE_EES5_S5_SA_RNS3_10ExprEngineERKNS2_12ProgramPointE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_116CheckBindContextC1ERKSt6vectorIN5clang4ento9CheckerFnIFvRKNS3_4SValES7_PKNS2_4StmtERNS3_14CheckerContextEEEESaISE_EES5_S5_SA_RNS3_10ExprEngineERKNS2_12ProgramPointE")
  //</editor-fold>
  public CheckBindContext(final /*const*/std.vector<Check$CheckBindFunc> /*&*/ checkers, 
      SVal loc, SVal val, /*const*/ Stmt /*P*/ s, final ExprEngine /*&*/ eng, 
      final /*const*/ ProgramPoint /*&*/ pp) {
    // : Checkers(checkers), Loc(loc), Val(val), S(s), Eng(eng), PP(pp) 
    //START JInit
    super(eng);
    this./*&*/Checkers=/*&*/checkers;
    this.Loc = new SVal(loc);
    this.Val = new SVal(val);
    this.S = s;
    this./*&*/Eng=/*&*/eng;
    this./*&*/PP=/*&*/pp;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckBindContext::runChecker">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 353,
   FQN="(anonymous namespace)::CheckBindContext::runChecker", NM="_ZN12_GLOBAL__N_116CheckBindContext10runCheckerEN5clang4ento9CheckerFnIFvRKNS2_4SValES6_PKNS1_4StmtERNS2_14CheckerContextEEEERNS2_11NodeBuilderEPNS2_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_116CheckBindContext10runCheckerEN5clang4ento9CheckerFnIFvRKNS2_4SValES6_PKNS1_4StmtERNS2_14CheckerContextEEEERNS2_11NodeBuilderEPNS2_12ExplodedNodeE")
  //</editor-fold>
  public void runChecker(Check$CheckBindFunc checkFn, 
            final NodeBuilder /*&*/ Bldr, ExplodedNode /*P*/ Pred) {
    final /*const*/ ProgramPoint /*&*/ L = PP.withTag(checkFn.getChecker());
    CheckerContext C/*J*/= new CheckerContext(Bldr, Eng, Pred, L);
    
    checkFn.$call(checkFn.getChecker(), Loc, Val, S, C);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckBindContext::CheckBindContext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 336,
   FQN="(anonymous namespace)::CheckBindContext::CheckBindContext", NM="_ZN12_GLOBAL__N_116CheckBindContextC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_116CheckBindContextC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CheckBindContext(final /*const*/ CheckBindContext /*&*/ $Prm0) {
    // : Checkers(.Checkers), Loc(.Loc), Val(.Val), S(.S), Eng(.Eng), PP(.PP) 
    //START JInit
    super($Prm0.Eng);
    this./*&*/Checkers=/*&*/$Prm0.Checkers;
    this.Loc = new SVal($Prm0.Loc);
    this.Val = new SVal($Prm0.Val);
    this.S = $Prm0.S;
    this./*&*/Eng=/*&*/$Prm0.Eng;
    this./*&*/PP=/*&*/$Prm0.PP;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Checkers=" + Checkers // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", Val=" + Val // NOI18N
              + ", S=" + S // NOI18N
              + ", Eng=" + "[ExprEngine]" // NOI18N
              + ", PP=" + PP; // NOI18N
  }
}
