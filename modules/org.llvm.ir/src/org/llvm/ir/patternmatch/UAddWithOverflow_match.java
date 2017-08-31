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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.ir.*;
import org.llvm.ir.java.*;


//===----------------------------------------------------------------------===//
// Matchers for overflow check patterns: e.g. (a + b) u< a
//
/*template <typename LHS_t, typename RHS_t, typename Sum_t> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::UAddWithOverflow_match">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1113,
 FQN="llvm::PatternMatch::UAddWithOverflow_match", NM="_ZN4llvm12PatternMatch22UAddWithOverflow_matchE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch22UAddWithOverflow_matchE")
//</editor-fold>
public class/*struct*/ UAddWithOverflow_match</*typename*/ LHS_t extends match<LHS_t>, /*typename*/ RHS_t extends match<RHS_t>, /*typename*/ Sum_t extends match<Sum_t>>  implements match<UAddWithOverflow_match> {
  public LHS_t L;
  public RHS_t R;
  public Sum_t S;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::UAddWithOverflow_match::UAddWithOverflow_match<LHS_t, RHS_t, Sum_t>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1119,
   FQN="llvm::PatternMatch::UAddWithOverflow_match::UAddWithOverflow_match<LHS_t, RHS_t, Sum_t>", NM="_ZN4llvm12PatternMatch22UAddWithOverflow_matchC1ERKT_RKT0_RKT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch22UAddWithOverflow_matchC1ERKT_RKT0_RKT1_")
  //</editor-fold>
  public UAddWithOverflow_match(final /*const*/ LHS_t /*&*/ L, final /*const*/ RHS_t /*&*/ R, final /*const*/ Sum_t /*&*/ S) {
    // : L(L), R(R), S(S) 
    //START JInit
    this.L = /*ParenListExpr*/$Clone(L);
    this.R = /*ParenListExpr*/$Clone(R);
    this.S = /*ParenListExpr*/$Clone(S);
    //END JInit
  }

  
  /*template <typename OpTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::UAddWithOverflow_match::match">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1122,
   FQN="llvm::PatternMatch::UAddWithOverflow_match::match", NM="Tpl__ZN4llvm12PatternMatch22UAddWithOverflow_match5matchEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch22UAddWithOverflow_match5matchEPT_")
  //</editor-fold>
  public </*typename*/ OpTy extends Value> boolean match(OpTy /*P*/ V) {
    type$ref<Value /*P*/ > ICmpLHS = create_type$ref();
    type$ref<Value /*P*/ > ICmpRHS = create_type$ref();
    type$ref<ICmpInst.Predicate> Pred = create_type$ref();
    if (Native.$not(PatternMatchGlobals.m_ICmp(Pred, PatternMatchGlobals.m_Value(ICmpLHS), PatternMatchGlobals.m_Value(ICmpRHS)).match(V))) {
      return false;
    }
    
    type$ref<Value /*P*/ > AddLHS = create_type$ref();
    type$ref<Value /*P*/ > AddRHS = create_type$ref();
    BinaryOp_match AddExpr = PatternMatchGlobals.m_Add(PatternMatchGlobals.m_Value(AddLHS), PatternMatchGlobals.m_Value(AddRHS));
    
    // (a + b) u< a, (a + b) u< b
    if (Pred.$deref() == ICmpInst.Predicate.ICMP_ULT) {
      if (AddExpr.match(ICmpLHS.$deref()) && (ICmpRHS.$deref() == AddLHS.$deref() || ICmpRHS.$deref() == AddRHS.$deref())) {
        return Native.$bool(Native.$bool(L.match(AddLHS.$deref())) && Native.$bool(R.match(AddRHS.$deref()))) && Native.$bool(S.match(ICmpLHS.$deref()));
      }
    }
    
    // a >u (a + b), b >u (a + b)
    if (Pred.$deref() == ICmpInst.Predicate.ICMP_UGT) {
      if (AddExpr.match(ICmpRHS.$deref()) && (ICmpLHS.$deref() == AddLHS.$deref() || ICmpLHS.$deref() == AddRHS.$deref())) {
        return Native.$bool(Native.$bool(L.match(AddLHS.$deref())) && Native.$bool(R.match(AddRHS.$deref()))) && Native.$bool(S.match(ICmpRHS.$deref()));
      }
    }
    
    return false;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public UAddWithOverflow_match(UAddWithOverflow_match<LHS_t, RHS_t, Sum_t> other) {
    this.L = /*ParenListExpr*/$Clone(other.L);
    this.R = /*ParenListExpr*/$Clone(other.R);
    this.S = /*ParenListExpr*/$Clone(other.S);
  }

  @Override
  public UAddWithOverflow_match clone() {
    return new UAddWithOverflow_match(this);
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "L=" + L // NOI18N
              + ", R=" + R // NOI18N
              + ", S=" + S; // NOI18N
  }
}
