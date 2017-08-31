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
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerCheckerManagerFunctions.*;
import org.clang.staticanalyzer.java.*;

// FIXME: This has all the same signatures as CheckObjCMessageContext.
// Is there a way we can merge the two?
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckCallContext">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 248,
 FQN="(anonymous namespace)::CheckCallContext", NM="_ZN12_GLOBAL__N_116CheckCallContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_116CheckCallContextE")
//</editor-fold>
public class/*struct*/ CheckCallContext extends BaseContext<Check$CheckCallFunc> {
  // JAVA: typedef std::vector<CheckerManager::CheckCallFunc> CheckersTy
//  public final class CheckersTy extends std.vector<Check$CheckCallFunc>{ };
  public boolean IsPreVisit;
  public boolean WasInlined;
  public final /*const*/std.vector<Check$CheckCallFunc> /*&*/ Checkers;
  public final /*const*/ CallEvent /*&*/ Call;
  public final ExprEngine /*&*/ Eng;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckCallContext::checkers_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 255,
   FQN="(anonymous namespace)::CheckCallContext::checkers_begin", NM="_ZN12_GLOBAL__N_116CheckCallContext14checkers_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_116CheckCallContext14checkers_beginEv")
  //</editor-fold>
  public std.vector.iterator</*const*/Check$CheckCallFunc/*P*/> checkers_begin() {
    return Checkers.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckCallContext::checkers_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 256,
   FQN="(anonymous namespace)::CheckCallContext::checkers_end", NM="_ZN12_GLOBAL__N_116CheckCallContext12checkers_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_116CheckCallContext12checkers_endEv")
  //</editor-fold>
  public std.vector.iterator</*const*/Check$CheckCallFunc/*P*/> checkers_end() {
    return Checkers.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckCallContext::CheckCallContext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 258,
   FQN="(anonymous namespace)::CheckCallContext::CheckCallContext", NM="_ZN12_GLOBAL__N_116CheckCallContextC1EbRKSt6vectorIN5clang4ento9CheckerFnIFvRKNS3_9CallEventERNS3_14CheckerContextEEEESaISB_EES7_RNS3_10ExprEngineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_116CheckCallContextC1EbRKSt6vectorIN5clang4ento9CheckerFnIFvRKNS3_9CallEventERNS3_14CheckerContextEEEESaISB_EES7_RNS3_10ExprEngineEb")
  //</editor-fold>
  public CheckCallContext(boolean isPreVisit, final /*const*/std.vector<Check$CheckCallFunc> /*&*/ checkers, 
      final /*const*/ CallEvent /*&*/ call, final ExprEngine /*&*/ eng, 
      boolean wasInlined) {
    // : IsPreVisit(isPreVisit), WasInlined(wasInlined), Checkers(checkers), Call(call), Eng(eng) 
    //START JInit
    super(eng);
    this.IsPreVisit = isPreVisit;
    this.WasInlined = wasInlined;
    this./*&*/Checkers=/*&*/checkers;
    this./*&*/Call=/*&*/call;
    this./*&*/Eng=/*&*/eng;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckCallContext::runChecker">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 264,
   FQN="(anonymous namespace)::CheckCallContext::runChecker", NM="_ZN12_GLOBAL__N_116CheckCallContext10runCheckerEN5clang4ento9CheckerFnIFvRKNS2_9CallEventERNS2_14CheckerContextEEEERNS2_11NodeBuilderEPNS2_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_116CheckCallContext10runCheckerEN5clang4ento9CheckerFnIFvRKNS2_9CallEventERNS2_14CheckerContextEEEERNS2_11NodeBuilderEPNS2_12ExplodedNodeE")
  //</editor-fold>
  public void runChecker(Check$CheckCallFunc checkFn, 
            final NodeBuilder /*&*/ Bldr, ExplodedNode /*P*/ Pred) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final /*const*/ ProgramPoint /*&*/ L = Call.getProgramPoint(IsPreVisit, checkFn.getChecker());
      CheckerContext C/*J*/= new CheckerContext(Bldr, Eng, Pred, L, WasInlined);
      
      checkFn.$call($c$.track(Call.cloneWithState($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState())))).$star(), C); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckCallContext::CheckCallContext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 248,
   FQN="(anonymous namespace)::CheckCallContext::CheckCallContext", NM="_ZN12_GLOBAL__N_116CheckCallContextC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_116CheckCallContextC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CheckCallContext(final /*const*/ CheckCallContext /*&*/ $Prm0) {
    // : IsPreVisit(.IsPreVisit), WasInlined(.WasInlined), Checkers(.Checkers), Call(.Call), Eng(.Eng) 
    //START JInit
    super($Prm0.Eng);
    this.IsPreVisit = $Prm0.IsPreVisit;
    this.WasInlined = $Prm0.WasInlined;
    this./*&*/Checkers=/*&*/$Prm0.Checkers;
    this./*&*/Call=/*&*/$Prm0.Call;
    this./*&*/Eng=/*&*/$Prm0.Eng;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "IsPreVisit=" + IsPreVisit // NOI18N
              + ", WasInlined=" + WasInlined // NOI18N
              + ", Checkers=" + Checkers // NOI18N
              + ", Call=" + Call // NOI18N
              + ", Eng=" + "[ExprEngine]"; // NOI18N
  }
}
