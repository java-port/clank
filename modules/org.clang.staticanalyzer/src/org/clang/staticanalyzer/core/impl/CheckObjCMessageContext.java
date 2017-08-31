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
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerCheckerManagerFunctions.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckObjCMessageContext">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 178,
 FQN="(anonymous namespace)::CheckObjCMessageContext", NM="_ZN12_GLOBAL__N_123CheckObjCMessageContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_123CheckObjCMessageContextE")
//</editor-fold>
public class/*struct*/ CheckObjCMessageContext extends BaseContext<Check$CheckObjCMessageFunc> {
  // JAVA: typedef std::vector<CheckerManager::CheckObjCMessageFunc> CheckersTy
//  public final class CheckersTy extends std.vector<Check$CheckObjCMessageFunc>{ };
  
  public ObjCMessageVisitKind Kind;
  public boolean WasInlined;
  public final /*const*/std.vector<Check$CheckObjCMessageFunc> /*&*/ Checkers;
  public final /*const*/ ObjCMethodCall /*&*/ Msg;
  public final ExprEngine /*&*/ Eng;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckObjCMessageContext::checkers_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 187,
   FQN="(anonymous namespace)::CheckObjCMessageContext::checkers_begin", NM="_ZN12_GLOBAL__N_123CheckObjCMessageContext14checkers_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_123CheckObjCMessageContext14checkers_beginEv")
  //</editor-fold>
  public std.vector.iterator</*const*/Check$CheckObjCMessageFunc/*P*/> checkers_begin() {
    return Checkers.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckObjCMessageContext::checkers_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 188,
   FQN="(anonymous namespace)::CheckObjCMessageContext::checkers_end", NM="_ZN12_GLOBAL__N_123CheckObjCMessageContext12checkers_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_123CheckObjCMessageContext12checkers_endEv")
  //</editor-fold>
  public std.vector.iterator</*const*/Check$CheckObjCMessageFunc/*P*/> checkers_end() {
    return Checkers.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckObjCMessageContext::CheckObjCMessageContext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 190,
   FQN="(anonymous namespace)::CheckObjCMessageContext::CheckObjCMessageContext", NM="_ZN12_GLOBAL__N_123CheckObjCMessageContextC1EN5clang4ento20ObjCMessageVisitKindERKSt6vectorINS2_9CheckerFnIFvRKNS2_14ObjCMethodCallERNS2_14CheckerContextEEEESaISC_EES8_RNS2_10ExprEngineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_123CheckObjCMessageContextC1EN5clang4ento20ObjCMessageVisitKindERKSt6vectorINS2_9CheckerFnIFvRKNS2_14ObjCMethodCallERNS2_14CheckerContextEEEESaISC_EES8_RNS2_10ExprEngineEb")
  //</editor-fold>
  public CheckObjCMessageContext(ObjCMessageVisitKind visitKind, 
      final /*const*/std.vector<Check$CheckObjCMessageFunc> /*&*/ checkers, 
      final /*const*/ ObjCMethodCall /*&*/ msg, final ExprEngine /*&*/ eng, 
      boolean wasInlined) {
    // : Kind(visitKind), WasInlined(wasInlined), Checkers(checkers), Msg(msg), Eng(eng) 
    //START JInit
    super(eng);
    this.Kind = visitKind;
    this.WasInlined = wasInlined;
    this./*&*/Checkers=/*&*/checkers;
    this./*&*/Msg=/*&*/msg;
    this./*&*/Eng=/*&*/eng;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckObjCMessageContext::runChecker">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 197,
   FQN="(anonymous namespace)::CheckObjCMessageContext::runChecker", NM="_ZN12_GLOBAL__N_123CheckObjCMessageContext10runCheckerEN5clang4ento9CheckerFnIFvRKNS2_14ObjCMethodCallERNS2_14CheckerContextEEEERNS2_11NodeBuilderEPNS2_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_123CheckObjCMessageContext10runCheckerEN5clang4ento9CheckerFnIFvRKNS2_14ObjCMethodCallERNS2_14CheckerContextEEEERNS2_11NodeBuilderEPNS2_12ExplodedNodeE")
  //</editor-fold>
  public void runChecker(Check$CheckObjCMessageFunc checkFn, 
            final NodeBuilder /*&*/ Bldr, ExplodedNode /*P*/ Pred) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      boolean IsPreVisit = false;/*JAVA: init*/
      switch (Kind) {
       case Pre:
        IsPreVisit = true;
        break;
       case MessageNil:
       case Post:
        IsPreVisit = false;
        break;
       default:
         assert false : "unexpected Kind " + Kind + ". What should be IsPreVisit value?";
      }
      
      final /*const*/ ProgramPoint /*&*/ L = Msg.getProgramPoint(IsPreVisit, checkFn.getChecker());
      CheckerContext C/*J*/= new CheckerContext(Bldr, Eng, Pred, L, WasInlined);
      
      checkFn.$call($c$.track(Msg.<ObjCMethodCall>cloneWithState$T(ObjCMethodCall.class, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(Pred.getState())))).$star(), C); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckObjCMessageContext::CheckObjCMessageContext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp", line = 178,
   FQN="(anonymous namespace)::CheckObjCMessageContext::CheckObjCMessageContext", NM="_ZN12_GLOBAL__N_123CheckObjCMessageContextC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN12_GLOBAL__N_123CheckObjCMessageContextC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CheckObjCMessageContext(final /*const*/ CheckObjCMessageContext /*&*/ $Prm0) {
    // : Kind(.Kind), WasInlined(.WasInlined), Checkers(.Checkers), Msg(.Msg), Eng(.Eng) 
    //START JInit
    super($Prm0.Eng);
    this.Kind = $Prm0.Kind;
    this.WasInlined = $Prm0.WasInlined;
    this./*&*/Checkers=/*&*/$Prm0.Checkers;
    this./*&*/Msg=/*&*/$Prm0.Msg;
    this./*&*/Eng=/*&*/$Prm0.Eng;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", WasInlined=" + WasInlined // NOI18N
              + ", Checkers=" + Checkers // NOI18N
              + ", Msg=" + Msg // NOI18N
              + ", Eng=" + "[ExprEngine]"; // NOI18N
  }
}
