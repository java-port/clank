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
package org.clang.analysis.consumed.impl;

import org.clank.support.*;
import org.clang.ast.*;
import org.clang.analysis.impl.*;
import org.clang.analysis.analyses.consumed.*;
import static org.clang.analysis.impl.ConsumedStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type ConsumedStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumedL18splitVarStateForIfEPKNS_6IfStmtERKN12_GLOBAL__N_113VarTestResultEPNS0_16ConsumedStateMapES9_;_ZN5clang8consumedL19setStateForVarOrTmpEPNS0_16ConsumedStateMapERKNS0_15PropagationInfoENS0_13ConsumedStateE;_ZN5clang8consumedL23splitVarStateForIfBinOpERKNS0_15PropagationInfoEPNS0_16ConsumedStateMapES5_; -static-type=ConsumedStatics -package=org.clang.analysis.consumed.impl")
//</editor-fold>
public final class ConsumedStatics {

//<editor-fold defaultstate="collapsed" desc="clang::consumed::setStateForVarOrTmp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 444,
 FQN="clang::consumed::setStateForVarOrTmp", NM="_ZN5clang8consumedL19setStateForVarOrTmpEPNS0_16ConsumedStateMapERKNS0_15PropagationInfoENS0_13ConsumedStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumedL19setStateForVarOrTmpEPNS0_16ConsumedStateMapERKNS0_15PropagationInfoENS0_13ConsumedStateE")
//</editor-fold>
public static /*inline*/ void setStateForVarOrTmp(ConsumedStateMap /*P*/ StateMap, final /*const*/ PropagationInfo /*&*/ PInfo, 
                   ConsumedState State) {
  assert (PInfo.isVar() || PInfo.isTmp());
  if (PInfo.isVar()) {
    StateMap.setState(PInfo.getVar(), State);
  } else {
    StateMap.setState(PInfo.getTmp(), State);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::consumed::splitVarStateForIf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 955,
 FQN="clang::consumed::splitVarStateForIf", NM="_ZN5clang8consumedL18splitVarStateForIfEPKNS_6IfStmtERKN12_GLOBAL__N_113VarTestResultEPNS0_16ConsumedStateMapES9_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumedL18splitVarStateForIfEPKNS_6IfStmtERKN12_GLOBAL__N_113VarTestResultEPNS0_16ConsumedStateMapES9_")
//</editor-fold>
public static void splitVarStateForIf(/*const*/ IfStmt /*P*/ IfNode, final /*const*/ VarTestResult /*&*/ Test, 
                  ConsumedStateMap /*P*/ ThenStates, 
                  ConsumedStateMap /*P*/ ElseStates) {
  ConsumedState VarState = ThenStates.getState(Test.Var);
  if (VarState == ConsumedState.CS_Unknown) {
    ThenStates.setState(Test.Var, Test.TestsFor);
    ElseStates.setState(Test.Var, invertConsumedUnconsumed(Test.TestsFor));
  } else if (VarState == invertConsumedUnconsumed(Test.TestsFor)) {
    ThenStates.markUnreachable();
  } else if (VarState == Test.TestsFor) {
    ElseStates.markUnreachable();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::consumed::splitVarStateForIfBinOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 972,
 FQN="clang::consumed::splitVarStateForIfBinOp", NM="_ZN5clang8consumedL23splitVarStateForIfBinOpERKNS0_15PropagationInfoEPNS0_16ConsumedStateMapES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumedL23splitVarStateForIfBinOpERKNS0_15PropagationInfoEPNS0_16ConsumedStateMapES5_")
//</editor-fold>
public static void splitVarStateForIfBinOp(final /*const*/ PropagationInfo /*&*/ PInfo, 
                       ConsumedStateMap /*P*/ ThenStates, 
                       ConsumedStateMap /*P*/ ElseStates) {
  final /*const*/ VarTestResult /*&*/ LTest = PInfo.getLTest();
  final /*const*/ VarTestResult /*&*/ RTest = PInfo.getRTest();
  
  ConsumedState LState = (LTest.Var != null) ? ThenStates.getState(LTest.Var) : ConsumedState.CS_None;
  ConsumedState RState = (RTest.Var != null) ? ThenStates.getState(RTest.Var) : ConsumedState.CS_None;
  if ((LTest.Var != null)) {
    if (PInfo.testEffectiveOp() == EffectiveOp.EO_And) {
      if (LState == ConsumedState.CS_Unknown) {
        ThenStates.setState(LTest.Var, LTest.TestsFor);
      } else if (LState == invertConsumedUnconsumed(LTest.TestsFor)) {
        ThenStates.markUnreachable();
      } else if (LState == LTest.TestsFor && isKnownState(RState)) {
        if (RState == RTest.TestsFor) {
          ElseStates.markUnreachable();
        } else {
          ThenStates.markUnreachable();
        }
      }
    } else {
      if (LState == ConsumedState.CS_Unknown) {
        ElseStates.setState(LTest.Var, 
            invertConsumedUnconsumed(LTest.TestsFor));
      } else if (LState == LTest.TestsFor) {
        ElseStates.markUnreachable();
      } else if (LState == invertConsumedUnconsumed(LTest.TestsFor)
         && isKnownState(RState)) {
        if (RState == RTest.TestsFor) {
          ElseStates.markUnreachable();
        } else {
          ThenStates.markUnreachable();
        }
      }
    }
  }
  if ((RTest.Var != null)) {
    if (PInfo.testEffectiveOp() == EffectiveOp.EO_And) {
      if (RState == ConsumedState.CS_Unknown) {
        ThenStates.setState(RTest.Var, RTest.TestsFor);
      } else if (RState == invertConsumedUnconsumed(RTest.TestsFor)) {
        ThenStates.markUnreachable();
      }
    } else {
      if (RState == ConsumedState.CS_Unknown) {
        ElseStates.setState(RTest.Var, 
            invertConsumedUnconsumed(RTest.TestsFor));
      } else if (RState == RTest.TestsFor) {
        ElseStates.markUnreachable();
      }
    }
  }
}

} // END OF class ConsumedStatics
