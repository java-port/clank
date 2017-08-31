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

package org.llvm.ir.patternmatch;

import org.clank.support.*;
import static org.clank.support.Native.$Clone;
import static org.llvm.support.llvm.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.ir.java.*;


//===----------------------------------------------------------------------===//
// Matchers for max/min idioms, eg: "select (sgt x, y), x, y" -> smax(x,y).
//
/*template <typename CmpInst_t, typename LHS_t, typename RHS_t, typename Pred_t> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::MaxMin_match">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 950,
 FQN="llvm::PatternMatch::MaxMin_match", NM="_ZN4llvm12PatternMatch12MaxMin_matchE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch12MaxMin_matchE")
//</editor-fold>
public class/*struct*/ MaxMin_match</*typename*/ CmpInst_t extends CmpInst, /*typename*/ LHS_t extends match<LHS_t>, /*typename*/ RHS_t extends match<RHS_t>, /*typename*/ Pred_t extends match_pred>  implements match<MaxMin_match> {
  public LHS_t L;
  public RHS_t R;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::MaxMin_match::MaxMin_match<CmpInst_t, LHS_t, RHS_t, Pred_t>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 955,
   FQN="llvm::PatternMatch::MaxMin_match::MaxMin_match<CmpInst_t, LHS_t, RHS_t, Pred_t>", NM="_ZN4llvm12PatternMatch12MaxMin_matchC1ERKT0_RKT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch12MaxMin_matchC1ERKT0_RKT1_")
  //</editor-fold>
  public MaxMin_match(Class<CmpInst_t> cls, final /*const*/ LHS_t /*&*/ LHS, final /*const*/ RHS_t /*&*/ RHS, Pred_t pred) {
    // : L(LHS), R(RHS) 
    //START JInit
    this.cls = cls;
    this.L = /*ParenListExpr*/$Clone(LHS);
    this.R = /*ParenListExpr*/$Clone(RHS);
    this.pred = pred;
    //END JInit
  }


  /*template <typename OpTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::MaxMin_match::match">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 957,
   FQN="llvm::PatternMatch::MaxMin_match::match", NM="Tpl__ZN4llvm12PatternMatch12MaxMin_match5matchEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch12MaxMin_match5matchEPT_")
  //</editor-fold>
  public </*typename*/ OpTy extends Value> boolean match(OpTy /*P*/ V) {
    // Look for "(x pred y) ? x : y" or "(x pred y) ? y : x".
    SelectInst /*P*/ SI = dyn_cast_SelectInst(V);
    if (Native.$not(SI)) {
      return false;
    }
    CmpInst_t /*P*/ Cmp = dyn_cast(cls, SI.getCondition());
    if (Native.$not(Cmp)) {
      return false;
    }
    // At this point we have a select conditioned on a comparison.  Check that
    // it is the values returned by the select that are being compared.
    Value /*P*/ TrueVal = SI.getTrueValue();
    Value /*P*/ FalseVal = SI.getFalseValue();
    Value /*P*/ LHS = Cmp.getOperand(0);
    Value /*P*/ RHS = Cmp.getOperand(1);
    if ((TrueVal != LHS || FalseVal != RHS)
       && (TrueVal != RHS || FalseVal != LHS)) {
      return false;
    }
     CmpInst_t.Predicate Pred = LHS == TrueVal ? Cmp.getPredicate() : Cmp.getSwappedPredicate();
    // Does "(x pred y) ? x : y" represent the desired max/min operation?
    if (Native.$not(pred.match(Pred))) {
      return false;
    }
    // It does!  Bind the operands.
    return Native.$bool(L.match(LHS)) && Native.$bool(R.match(RHS));
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final Class<CmpInst_t> cls;
  private final Pred_t pred;
  
  public MaxMin_match(MaxMin_match<CmpInst_t, LHS_t, RHS_t, Pred_t> other) {
    this.cls = other.cls;
    this.L = /*ParenListExpr*/$Clone(other.L);
    this.R = /*ParenListExpr*/$Clone(other.R);
    this.pred = other.pred;
  }

  @Override
  public MaxMin_match clone() {
    return new MaxMin_match(this);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "L=" + L // NOI18N
              + ", R=" + R; // NOI18N
  }
}
