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
import org.clank.support.JavaDifferentiators.*;
import org.llvm.ir.*;
import org.llvm.ir.java.match;


/// \brief Match a specified Value*.
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::specificval_ty">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 314,
 FQN="llvm::PatternMatch::specificval_ty", NM="_ZN4llvm12PatternMatch14specificval_tyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm12PatternMatch14specificval_tyE")
//</editor-fold>
public class/*struct*/ specificval_ty implements match<specificval_ty> {
  public /*const*/ Value /*P*/ Val;
  //<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::specificval_ty::specificval_ty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 316,
   FQN="llvm::PatternMatch::specificval_ty::specificval_ty", NM="_ZN4llvm12PatternMatch14specificval_tyC1EPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm12PatternMatch14specificval_tyC1EPKNS_5ValueE")
  //</editor-fold>
  public specificval_ty(/*const*/ Value /*P*/ V) {
    // : Val(V) 
    //START JInit
    this.Val = V;
    //END JInit
  }

  
  /*template <typename ITy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::specificval_ty::match">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 318,
   FQN="llvm::PatternMatch::specificval_ty::match", NM="Tpl__ZN4llvm12PatternMatch14specificval_ty5matchEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=Tpl__ZN4llvm12PatternMatch14specificval_ty5matchEPT_")
  //</editor-fold>
  public </*typename*/ ITy extends Value> boolean match(ITy /*P*/ V) {
    return Native.$eq(V, Val);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::specificval_ty::specificval_ty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 314,
   FQN="llvm::PatternMatch::specificval_ty::specificval_ty", NM="_ZN4llvm12PatternMatch14specificval_tyC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm12PatternMatch14specificval_tyC1ERKS1_")
  //</editor-fold>
  public /*inline*/ specificval_ty(final /*const*/ specificval_ty /*&*/ $Prm0) {
    // : Val(.Val) 
    //START JInit
    this.Val = $Prm0.Val;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::specificval_ty::specificval_ty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 314,
   FQN="llvm::PatternMatch::specificval_ty::specificval_ty", NM="_ZN4llvm12PatternMatch14specificval_tyC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ValueTracking.cpp -nm=_ZN4llvm12PatternMatch14specificval_tyC1EOS1_")
  //</editor-fold>
  public /*inline*/ specificval_ty(JD$Move _dparam, final specificval_ty /*&&*/$Prm0) {
    // : Val(static_cast<specificval_ty &&>().Val) 
    //START JInit
    this.Val = $Prm0.Val;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public specificval_ty clone() {
    return new specificval_ty(this);
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Val=" + Val; // NOI18N
  }
}
