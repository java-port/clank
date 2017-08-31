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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
// BasicBlock pred_iterator definition
//===----------------------------------------------------------------------===//
/*template <class Ptr, class USE_iterator> TEMPLATE*/
// Predecessor Iterator
//<editor-fold defaultstate="collapsed" desc="llvm::PredIterator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 29,
 FQN="llvm::PredIterator", NM="_ZN4llvm12PredIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm12PredIteratorE")
//</editor-fold>
public class PredIterator</*class*/ Ptr extends Value, /*class*/ USE_iterator extends Value.user_iterator_impl<User>>  implements /*public*/ std.iterator<std.forward_iterator_tag, Ptr>, type$iterator<PredIterator, Ptr>, Native.NativeComparable {
  // JAVA: typedef std::iterator<std::forward_iterator_tag, Ptr, ptrdiff_t, Ptr *, Ptr *> super
//  public final class super extends std.iterator<std.forward_iterator_tag, Ptr>{ };
  // JAVA: typedef PredIterator<Ptr, USE_iterator> Self
//  public final class Self extends PredIterator<Ptr, USE_iterator>{ };
  private USE_iterator It;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::PredIterator::advancePastNonTerminators">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 37,
   FQN="llvm::PredIterator::advancePastNonTerminators", NM="_ZN4llvm12PredIterator25advancePastNonTerminatorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm12PredIterator25advancePastNonTerminatorsEv")
  //</editor-fold>
  private /*inline*/ void advancePastNonTerminators() {
    // Loop to ignore non-terminator uses (for example BlockAddresses).
    while (Native.$not(It.atEnd()) && Native.$not(isa_TerminatorInst($Deref(It)))) {
      It.$preInc();
    }
  }

/*public:*/
  // JAVA: typedef typename super::pointer pointer
//  public final class pointer extends  std.iterator.pointer<std.forward_iterator_tag, Ptr>{ };
  // JAVA: typedef typename super::reference reference
//  public final class reference extends Ptr{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::PredIterator::PredIterator<Ptr, USE_iterator>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 47,
   FQN="llvm::PredIterator::PredIterator<Ptr, USE_iterator>", NM="_ZN4llvm12PredIteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm12PredIteratorC1Ev")
  //</editor-fold>
  public PredIterator() {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PredIterator::PredIterator<Ptr, USE_iterator>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*found only one USE_iterator class, use new instance of concrete class instead of passing supplier*/,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 48,
   FQN="llvm::PredIterator::PredIterator<Ptr, USE_iterator>", NM="_ZN4llvm12PredIteratorC1EPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm12PredIteratorC1EPT_")
  //</editor-fold>
  public /*inline*/ /*explicit*/ PredIterator(Ptr /*P*/ bb) {
    // : It(bb->user_begin()) 
    //START JInit
    this.It = (USE_iterator) new Value.user_iterator_impl(bb.user_begin());
    //END JInit
    advancePastNonTerminators();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PredIterator::PredIterator<Ptr, USE_iterator>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*found only one USE_iterator class, use new instance of concrete class instead of passing supplier*/,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 51,
   FQN="llvm::PredIterator::PredIterator<Ptr, USE_iterator>", NM="_ZN4llvm12PredIteratorC1EPT_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm12PredIteratorC1EPT_b")
  //</editor-fold>
  public /*inline*/ PredIterator(Ptr /*P*/ bb, boolean $Prm1) {
    // : It(bb->user_end()) 
    //START JInit
    this.It = (USE_iterator) new Value.user_iterator_impl(bb.user_end());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PredIterator::operator==">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 53,
   FQN="llvm::PredIterator::operator==", NM="_ZNK4llvm12PredIteratoreqERKNS_12PredIteratorIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZNK4llvm12PredIteratoreqERKNS_12PredIteratorIT_T0_EE")
  //</editor-fold>
  public /*inline*/ boolean $eq(final /*const*/ PredIterator<Ptr, USE_iterator> /*&*/ x) /*const*/ {
    return Native.$eq_iter(It, x.It);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PredIterator::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 54,
   FQN="llvm::PredIterator::operator!=", NM="_ZNK4llvm12PredIteratorneERKNS_12PredIteratorIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZNK4llvm12PredIteratorneERKNS_12PredIteratorIT_T0_EE")
  //</editor-fold>
  public /*inline*/ boolean $noteq(final /*const*/ PredIterator<Ptr, USE_iterator> /*&*/ x) /*const*/ {
    return Native.$not($eq(x));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PredIterator::operator*">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 56,
   FQN="llvm::PredIterator::operator*", NM="_ZNK4llvm12PredIteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZNK4llvm12PredIteratordeEv")
  //</editor-fold>
  public /*inline*/ Ptr $star() /*const*/ {
    assert Native.$bool(Native.$not(It.atEnd())) : "pred_iterator out of range!";
    return (Ptr) cast_TerminatorInst(It.$star()).getParent();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PredIterator::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 60,
   FQN="llvm::PredIterator::operator->", NM="_ZNK4llvm12PredIteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZNK4llvm12PredIteratorptEv")
  //</editor-fold>
  public /*inline*/ Ptr /*P*/ $arrow() /*const*/ {
    return $AddrOf($star());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PredIterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 62,
   FQN="llvm::PredIterator::operator++", NM="_ZN4llvm12PredIteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm12PredIteratorppEv")
  //</editor-fold>
  public /*inline*/ PredIterator<Ptr, USE_iterator> /*&*/ $preInc() {
    // Preincrement
    assert Native.$bool(Native.$not(It.atEnd())) : "pred_iterator out of range!";
    It.$preInc();
    advancePastNonTerminators();
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PredIterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 68,
   FQN="llvm::PredIterator::operator++", NM="_ZN4llvm12PredIteratorppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZN4llvm12PredIteratorppEi")
  //</editor-fold>
  public /*inline*/ PredIterator<Ptr, USE_iterator> $postInc(int $Prm0) {
    // Postincrement
    PredIterator<Ptr, USE_iterator> tmp = new PredIterator(this);///*Deref*/this;
    /*Deref*/this.$preInc();
    return tmp;
  }

  
  /// getOperandNo - Return the operand number in the predecessor's
  /// terminator of the successor.
  //<editor-fold defaultstate="collapsed" desc="llvm::PredIterator::getOperandNo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 74,
   FQN="llvm::PredIterator::getOperandNo", NM="_ZNK4llvm12PredIterator12getOperandNoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZNK4llvm12PredIterator12getOperandNoEv")
  //</editor-fold>
  public /*uint*/int getOperandNo() /*const*/ {
    return It.getUse().getOperandNo();
  }

  
  /// getUse - Return the operand Use in the predecessor's terminator
  /// of the successor.
  //<editor-fold defaultstate="collapsed" desc="llvm::PredIterator::getUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 80,
   FQN="llvm::PredIterator::getUse", NM="_ZNK4llvm12PredIterator6getUseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFG.cpp -nm=_ZNK4llvm12PredIterator6getUseEv")
  //</editor-fold>
  public Use /*&*/ getUse() /*const*/ {
    return It.getUse();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public @Override PredIterator clone() {
    return new PredIterator(this);
  }

  public PredIterator(PredIterator other) {
    this.It = It;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "It=" + It // NOI18N
              + super.toString(); // NOI18N
  }
}
