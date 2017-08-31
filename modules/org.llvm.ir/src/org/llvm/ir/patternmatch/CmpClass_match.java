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
import static org.llvm.support.llvm.*;
import org.llvm.ir.*;
import org.llvm.ir.java.*;


//===----------------------------------------------------------------------===//
// Matchers for CmpInst classes
//
/*template <typename LHS_t, typename RHS_t, typename Class, typename PredicateTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::CmpClass_match">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 699,
 FQN="llvm::PatternMatch::CmpClass_match", NM="_ZN4llvm12PatternMatch14CmpClass_matchE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch14CmpClass_matchE")
//</editor-fold>
public class/*struct*/ CmpClass_match</*typename*/ LHS_t extends match<LHS_t>, /*typename*/ RHS_t extends match<RHS_t>, /*typename*/ ClassInst extends CmpInst, /*typename*/ PredicateTy>  implements match<CmpClass_match> {
  public final type$ref<PredicateTy /*&*/> Predicate;
  public LHS_t L;
  public RHS_t R;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::CmpClass_match::CmpClass_match<LHS_t, RHS_t, Class, PredicateTy>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 705,
   FQN="llvm::PatternMatch::CmpClass_match::CmpClass_match<LHS_t, RHS_t, Class, PredicateTy>", NM="_ZN4llvm12PatternMatch14CmpClass_matchC1ERT2_RKT_RKT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch14CmpClass_matchC1ERT2_RKT_RKT0_")
  //</editor-fold>
  public CmpClass_match(Class<ClassInst> cls, final type$ref<PredicateTy /*&*/> Pred, final /*const*/ LHS_t /*&*/ LHS, final /*const*/ RHS_t /*&*/ RHS) {
    // : Predicate(Pred), L(LHS), R(RHS) 
    //START JInit
    this.cls = cls;
    this./*&*/Predicate=/*&*//*ParenListExpr*/Pred;
    this.L = /*ParenListExpr*/$Clone(LHS);
    this.R = /*ParenListExpr*/$Clone(RHS);
    //END JInit
  }

  
  /*template <typename OpTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::CmpClass_match::match">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 708,
   FQN="llvm::PatternMatch::CmpClass_match::match", NM="Tpl__ZN4llvm12PatternMatch14CmpClass_match5matchEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch14CmpClass_match5matchEPT_")
  //</editor-fold>
  public </*typename*/ OpTy extends Value> boolean match(OpTy /*P*/ V) {
    {
      ClassInst /*P*/ I = dyn_cast(cls, V);
      if (I != null) {
        if (Native.$bool(L.match(I.getOperand(0))) && Native.$bool(R.match(I.getOperand(1)))) {
          Predicate.$set((PredicateTy)I.getPredicate());
          return true;
        }
      }
    }
    return false;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final Class<ClassInst> cls;
  
  public CmpClass_match(CmpClass_match<LHS_t, RHS_t, ClassInst, PredicateTy> other) {
    this.cls = other.cls;
    this./*&*/Predicate=/*&*//*ParenListExpr*/other.Predicate;
    this.L = /*ParenListExpr*/$Clone(other.L);
    this.R = /*ParenListExpr*/$Clone(other.R);
  }

  @Override
  public CmpClass_match clone() {
    return new CmpClass_match(this);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Predicate=" + Predicate // NOI18N
              + ", L=" + L // NOI18N
              + ", R=" + R; // NOI18N
  }
}
