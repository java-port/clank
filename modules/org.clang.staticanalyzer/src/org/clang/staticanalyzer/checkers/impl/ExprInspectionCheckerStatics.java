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
package org.clang.staticanalyzer.checkers.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


//<editor-fold defaultstate="collapsed" desc="static type ExprInspectionCheckerStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZL22getArgumentValueStringPKN5clang8CallExprERNS_4ento14CheckerContextE; -static-type=ExprInspectionCheckerStatics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class ExprInspectionCheckerStatics {

//<editor-fold defaultstate="collapsed" desc="getArgumentValueString">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp", line = 69,
 FQN="getArgumentValueString", NM="_ZL22getArgumentValueStringPKN5clang8CallExprERNS_4ento14CheckerContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZL22getArgumentValueStringPKN5clang8CallExprERNS_4ento14CheckerContextE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getArgumentValueString(/*const*/ CallExpr /*P*/ CE, 
                      final CheckerContext /*&*/ C) {
  IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
  IntrusiveRefCntPtr</*const*/ ProgramState> StTrue = null;
  IntrusiveRefCntPtr</*const*/ ProgramState> StFalse = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (CE.getNumArgs() == 0) {
      return $("Missing assertion argument");
    }
    
    ExplodedNode /*P*/ N = C.getPredecessor();
    /*const*/ LocationContext /*P*/ LC = N.getLocationContext();
    State = new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState());
    
    /*const*/ Expr /*P*/ Assertion = CE.getArg$Const(0);
    SVal AssertionVal = State.$arrow().getSVal(Assertion, LC);
    if (AssertionVal.isUndef$SVal()) {
      return $("UNDEFINED");
    }
    
    StTrue/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
    StFalse/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//    $c$.clean(std.tie(StTrue, StFalse).$assign(
//        $c$.track(State.$arrow().assume(AssertionVal.castAs(DefinedOrUnknownSVal.class)))
//    ));
    // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
    std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
            $c$.track(State.$arrow().assume(AssertionVal.castAs(DefinedOrUnknownSVal.class)));
    StTrue.$assign($assume.first);
    StFalse.$assign($assume.second);
    assert !$assume.first.$bool();
    assert !$assume.second.$bool();
    $c$.clean();

    if (StTrue.$bool()) {
      if (StFalse.$bool()) {
        return $("UNKNOWN");
      } else {
        return $("TRUE");
      }
    } else {
      if (StFalse.$bool()) {
        return $("FALSE");
      } else {
        throw new llvm_unreachable("Invalid constraint; neither true or false.");
      }
    }
  } finally {
    if (StFalse != null) { StFalse.$destroy(); }
    if (StTrue != null) { StTrue.$destroy(); }
    if (State != null) { State.$destroy(); }
    $c$.$destroy();
  }
}

} // END OF class ExprInspectionCheckerStatics
