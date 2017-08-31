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
package org.clang.analysis.impl;

import org.clank.support.*;
import static org.clang.analysis.java.AnalysisFunctionPointers.*;
import static org.clang.analysis.java.AnalysisRTTI.*;
import org.clang.analysis.analyses.threadSafety.lexpr.*;


//<editor-fold defaultstate="collapsed" desc="static type ThreadSafetyLogicalStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyLogical.cpp -nm=_ZL7impliesPKN5clang12threadSafety5lexpr5LExprEbS4_b; -static-type=ThreadSafetyLogicalStatics -package=org.clang.analysis.impl")
//</editor-fold>
public final class ThreadSafetyLogicalStatics {


// Implication.  We implement De Morgan's Laws by maintaining LNeg and RNeg
// to keep track of whether LHS and RHS are negated.
//<editor-fold defaultstate="collapsed" desc="implies">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyLogical.cpp", line = 20,
 FQN="implies", NM="_ZL7impliesPKN5clang12threadSafety5lexpr5LExprEbS4_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyLogical.cpp -nm=_ZL7impliesPKN5clang12threadSafety5lexpr5LExprEbS4_b")
//</editor-fold>
public static boolean implies(/*const*/ LExpr /*P*/ LHS, boolean LNeg, /*const*/ LExpr /*P*/ RHS, boolean RNeg) {
  // In comments below, we write => for implication.
  
  // Calculates the logical AND implication operator.
  boolean L$RNeg = RNeg ;
  LExpr /*P*/ L$RHS = RHS;
  boolean L$LNeg = LNeg;
  LExpr /*P*/ L$LHS = LHS;
  BinOp2Bool LeftAndOperator = /*[=, =L$LNeg(LNeg), =L$RHS(RHS), =L$RNeg(RNeg)]*/ (/*const*/ BinOp /*P*/ A) -> {
        return implies(A.left$Const(), L$LNeg, L$RHS, L$RNeg)
           && implies(A.right$Const(), L$LNeg, L$RHS, L$RNeg);
      };
  BinOp2Bool RightAndOperator = /*[=, =L$LHS(LHS), =L$LNeg(LNeg), =L$RNeg(RNeg)]*/ (/*const*/ BinOp /*P*/ A) -> {
        return implies(L$LHS, L$LNeg, A.left$Const(), L$RNeg)
           && implies(L$LHS, L$LNeg, A.right$Const(), L$RNeg);
      };
  
  // Calculates the logical OR implication operator.
  BinOp2Bool LeftOrOperator = /*[=, =L$LNeg(LNeg), =L$RHS(RHS), =L$RNeg(RNeg)]*/ (/*const*/ BinOp /*P*/ A) -> {
        return implies(A.left$Const(), L$LNeg, L$RHS, L$RNeg)
           || implies(A.right$Const(), L$LNeg, L$RHS, L$RNeg);
      };
  BinOp2Bool RightOrOperator = /*[=, =L$LHS(LHS), =L$LNeg(LNeg), =L$RNeg(RNeg)]*/ (/*const*/ BinOp /*P*/ A) -> {
        return implies(L$LHS, L$LNeg, A.left$Const(), L$RNeg)
           || implies(L$LHS, L$LNeg, A.right$Const(), L$RNeg);
      };
  
  // Recurse on right.
  switch (RHS.kind()) {
   case And:
    // When performing right recursion:
    //   C => A & B  [if]  C => A and C => B
    // When performing right recursion (negated):
    //   C => !(A & B)  [if]  C => !A | !B  [===]  C => !A or C => !B
    return RNeg ? RightOrOperator.$call(cast_And(RHS)) : RightAndOperator.$call(cast_And(RHS));
   case Or:
    // When performing right recursion:
    //   C => (A | B)  [if]  C => A or C => B
    // When performing right recursion (negated):
    //   C => !(A | B)  [if]  C => !A & !B  [===]  C => !A and C => !B
    return RNeg ? RightAndOperator.$call(cast_Or(RHS)) : RightOrOperator.$call(cast_Or(RHS));
   case Not:
    // Note that C => !A is very different from !(C => A). It would be incorrect
    // to return !implies(LHS, RHS).
    return implies(LHS, LNeg, cast_Not(RHS).exp$Const(), !RNeg);
   case Terminal:
    // After reaching the terminal, it's time to recurse on the left.
    break;
  }
  
  // RHS is now a terminal.  Recurse on Left.
  switch (LHS.kind()) {
   case And:
    // When performing left recursion:
    //   A & B => C  [if]  A => C or B => C
    // When performing left recursion (negated):
    //   !(A & B) => C  [if]  !A | !B => C  [===]  !A => C and !B => C
    return LNeg ? LeftAndOperator.$call(cast_And(LHS)) : LeftOrOperator.$call(cast_And(LHS));
   case Or:
    // When performing left recursion:
    //   A | B => C  [if]  A => C and B => C
    // When performing left recursion (negated):
    //   !(A | B) => C  [if]  !A & !B => C  [===]  !A => C or !B => C
    return LNeg ? LeftOrOperator.$call(cast_Or(LHS)) : LeftAndOperator.$call(cast_Or(LHS));
   case Not:
    // Note that A => !C is very different from !(A => C). It would be incorrect
    // to return !implies(LHS, RHS).
    return implies(cast_Not(LHS).exp$Const(), !LNeg, RHS, RNeg);
   case Terminal:
    // After reaching the terminal, it's time to perform identity comparisons.
    break;
  }
  
  // A => A
  // !A => !A
  if (LNeg != RNeg) {
    return false;
  }
  
  // FIXME -- this should compare SExprs for equality, not pointer equality.
  return cast_Terminal(LHS).expr$Const() == cast_Terminal(RHS).expr$Const();
}

} // END OF class ThreadSafetyLogicalStatics
