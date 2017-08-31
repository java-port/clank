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

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckLocationContext">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 289,
 FQN="(anonymous namespace)::CheckLocationContext", NM="_ZN12_GLOBAL__N_120CheckLocationContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_120CheckLocationContextE")
//</editor-fold>
public class/*struct*/ CheckLocationContext extends BaseContext<Check$CheckLocationFunc> {
  /*typedef std::vector<CheckerManager::CheckLocationFunc> CheckersTy*/
//  public final class CheckersTy extends std.vector<Check$CheckLocationFunc>{ };
  public final /*const*/std.vector<Check$CheckLocationFunc> /*&*/ Checkers;
  public SVal Loc;
  public boolean IsLoad;
  public /*const*/ Stmt /*P*/ NodeEx; /* Will become a CFGStmt */
  public /*const*/ Stmt /*P*/ BoundEx;
  public final ExprEngine /*&*/ Eng;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckLocationContext::checkers_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 298,
   FQN="(anonymous namespace)::CheckLocationContext::checkers_begin", NM="_ZN12_GLOBAL__N_120CheckLocationContext14checkers_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_120CheckLocationContext14checkers_beginEv")
  //</editor-fold>
  public std.vector.iterator</*const*/Check$CheckLocationFunc/*P*/> checkers_begin() {
    return Checkers.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckLocationContext::checkers_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 299,
   FQN="(anonymous namespace)::CheckLocationContext::checkers_end", NM="_ZN12_GLOBAL__N_120CheckLocationContext12checkers_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_120CheckLocationContext12checkers_endEv")
  //</editor-fold>
  public std.vector.iterator</*const*/Check$CheckLocationFunc/*P*/> checkers_end() {
    return Checkers.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckLocationContext::CheckLocationContext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 301,
   FQN="(anonymous namespace)::CheckLocationContext::CheckLocationContext", NM="_ZN12_GLOBAL__N_120CheckLocationContextC1ERKSt6vectorIN5clang4ento9CheckerFnIFvRKNS3_4SValEbPKNS2_4StmtERNS3_14CheckerContextEEEESaISE_EES5_bSA_SA_RNS3_10ExprEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_120CheckLocationContextC1ERKSt6vectorIN5clang4ento9CheckerFnIFvRKNS3_4SValEbPKNS2_4StmtERNS3_14CheckerContextEEEESaISE_EES5_bSA_SA_RNS3_10ExprEngineE")
  //</editor-fold>
  public CheckLocationContext(final /*const*/std.vector<Check$CheckLocationFunc> /*&*/ checkers, 
      SVal loc, boolean isLoad, /*const*/ Stmt /*P*/ NodeEx, 
      /*const*/ Stmt /*P*/ BoundEx, 
      final ExprEngine /*&*/ eng) {
    // : Checkers(checkers), Loc(loc), IsLoad(isLoad), NodeEx(NodeEx), BoundEx(BoundEx), Eng(eng) 
    //START JInit
    super(eng);
    this./*&*/Checkers=/*&*/checkers;
    this.Loc = new SVal(loc);
    this.IsLoad = isLoad;
    this.NodeEx = NodeEx;
    this.BoundEx = BoundEx;
    this./*&*/Eng=/*&*/eng;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckLocationContext::runChecker">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 308,
   FQN="(anonymous namespace)::CheckLocationContext::runChecker", NM="_ZN12_GLOBAL__N_120CheckLocationContext10runCheckerEN5clang4ento9CheckerFnIFvRKNS2_4SValEbPKNS1_4StmtERNS2_14CheckerContextEEEERNS2_11NodeBuilderEPNS2_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_120CheckLocationContext10runCheckerEN5clang4ento9CheckerFnIFvRKNS2_4SValEbPKNS1_4StmtERNS2_14CheckerContextEEEERNS2_11NodeBuilderEPNS2_12ExplodedNodeE")
  //</editor-fold>
  public void runChecker(Check$CheckLocationFunc checkFn, 
            final NodeBuilder /*&*/ Bldr, ExplodedNode /*P*/ Pred) {
    ProgramPoint.Kind K = IsLoad ? ProgramPoint.Kind.PreLoadKind : ProgramPoint.Kind.PreStoreKind;
    final /*const*/ ProgramPoint /*&*/ L = ProgramPoint.getProgramPoint(NodeEx, K, 
        Pred.getLocationContext(), 
        checkFn.getChecker());
    CheckerContext C/*J*/= new CheckerContext(Bldr, Eng, Pred, L);
    checkFn.$call(checkFn.getChecker(), Loc, /*KEEP_BOOL*/IsLoad, BoundEx, C);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckLocationContext::CheckLocationContext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 289,
   FQN="(anonymous namespace)::CheckLocationContext::CheckLocationContext", NM="_ZN12_GLOBAL__N_120CheckLocationContextC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_120CheckLocationContextC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CheckLocationContext(final /*const*/ CheckLocationContext /*&*/ $Prm0) {
    // : Checkers(.Checkers), Loc(.Loc), IsLoad(.IsLoad), NodeEx(.NodeEx), BoundEx(.BoundEx), Eng(.Eng) 
    //START JInit
    super($Prm0.Eng);
    this./*&*/Checkers=/*&*/$Prm0.Checkers;
    this.Loc = new SVal($Prm0.Loc);
    this.IsLoad = $Prm0.IsLoad;
    this.NodeEx = $Prm0.NodeEx;
    this.BoundEx = $Prm0.BoundEx;
    this./*&*/Eng=/*&*/$Prm0.Eng;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Checkers=" + Checkers // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", IsLoad=" + IsLoad // NOI18N
              + ", NodeEx=" + NodeEx // NOI18N
              + ", BoundEx=" + BoundEx // NOI18N
              + ", Eng=" + "[ExprEngine]"; // NOI18N
  }
}
