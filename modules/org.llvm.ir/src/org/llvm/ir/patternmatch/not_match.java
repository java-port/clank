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
import static org.clank.support.Native.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.ir.java.*;


//===----------------------------------------------------------------------===//
// Matchers for unary operators
//
/*template <typename LHS_t> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::not_match">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 833,
 FQN="llvm::PatternMatch::not_match", NM="_ZN4llvm12PatternMatch9not_matchE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch9not_matchE")
//</editor-fold>
public class/*struct*/ not_match</*typename*/ LHS_t extends match<LHS_t>>  implements match<not_match> {
  public LHS_t L;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::not_match::not_match<LHS_t>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 836,
   FQN="llvm::PatternMatch::not_match::not_match<LHS_t>", NM="_ZN4llvm12PatternMatch9not_matchC1ERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch9not_matchC1ERKT_")
  //</editor-fold>
  public not_match(final /*const*/ LHS_t /*&*/ LHS) {
    // : L(LHS) 
    //START JInit
    this.L = /*ParenListExpr*/$Clone(LHS);
    //END JInit
  }

  
  /*template <typename OpTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::not_match::match">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 838,
   FQN="llvm::PatternMatch::not_match::match", NM="Tpl__ZN4llvm12PatternMatch9not_match5matchEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch9not_match5matchEPT_")
  //</editor-fold>
  public </*typename*/ OpTy extends Value> boolean match(OpTy /*P*/ V) {
    {
      Operator /*P*/ O = dyn_cast_Operator(V);
      if (O != null) {
        if (Native.$eq(O.getOpcode(), Instruction.BinaryOps.Xor)) {
          return matchIfNot(O.getOperand(0), O.getOperand(1));
        }
      }
    }
    return false;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::not_match::matchIfNot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 846,
   FQN="llvm::PatternMatch::not_match::matchIfNot", NM="_ZN4llvm12PatternMatch9not_match10matchIfNotEPNS_5ValueES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch9not_match10matchIfNotEPNS_5ValueES3_")
  //</editor-fold>
  private boolean matchIfNot(Value /*P*/ LHS, Value /*P*/ RHS) {
    return (isa_ConstantInt(RHS) || isa_ConstantDataVector(RHS)
      // FIXME: Remove CV.
       || isa_ConstantVector(RHS))
       && cast_Constant(RHS).isAllOnesValue() && L.match(LHS);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public not_match clone() {
    return new not_match(this);
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "L=" + L; // NOI18N
  }
}
