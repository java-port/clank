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
import org.clank.support.JavaDifferentiators.*;


/// \brief Structure to hold a use-list order.
//<editor-fold defaultstate="collapsed" desc="llvm::UseListOrder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/UseListOrder.h", line = 28,
 FQN="llvm::UseListOrder", NM="_ZN4llvm12UseListOrderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm12UseListOrderE")
//</editor-fold>
public class/*struct*/ UseListOrder implements NativeMoveable<UseListOrder>, Destructors.ClassWithDestructor {
  public /*const*/ Value /*P*/ V;
  public /*const*/ Function /*P*/ F;
  public std.vectorUInt/*uint*/ Shuffle;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::UseListOrder::UseListOrder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/UseListOrder.h", line = 33,
   FQN="llvm::UseListOrder::UseListOrder", NM="_ZN4llvm12UseListOrderC1EPKNS_5ValueEPKNS_8FunctionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm12UseListOrderC1EPKNS_5ValueEPKNS_8FunctionEj")
  //</editor-fold>
  public UseListOrder(/*const*/ Value /*P*/ V, /*const*/ Function /*P*/ F, /*size_t*/int ShuffleSize) {
    // : V(V), F(F), Shuffle(ShuffleSize) 
    //START JInit
    this.V = V;
    this.F = F;
    this.Shuffle = new std.vectorUInt/*uint*/(ShuffleSize);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::UseListOrder::UseListOrder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/UseListOrder.h", line = 36,
   FQN="llvm::UseListOrder::UseListOrder", NM="_ZN4llvm12UseListOrderC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm12UseListOrderC1Ev")
  //</editor-fold>
  public UseListOrder() {
    // : V(null), F(null), Shuffle() 
    //START JInit
    this.V = null;
    this.F = null;
    this.Shuffle = new std.vectorUInt/*uint*/();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::UseListOrder::UseListOrder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/UseListOrder.h", line = 37,
   FQN="llvm::UseListOrder::UseListOrder", NM="_ZN4llvm12UseListOrderC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm12UseListOrderC1EOS0_")
  //</editor-fold>
  public UseListOrder(JD$Move _dparam, final UseListOrder /*&&*/X) {
    // : V(X.V), F(X.F), Shuffle(std::move(X.Shuffle)) 
    //START JInit
    this.V = X.V;
    this.F = X.F;
    this.Shuffle = new std.vectorUInt/*uint*/(JD$Move.INSTANCE, std.move(X.Shuffle));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::UseListOrder::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/UseListOrder.h", line = 39,
   FQN="llvm::UseListOrder::operator=", NM="_ZN4llvm12UseListOrderaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm12UseListOrderaSEOS0_")
  //</editor-fold>
  public UseListOrder /*&*/ $assignMove(final UseListOrder /*&&*/X) {
    V = X.V;
    F = X.F;
    Shuffle.$assignMove(std.move(X.Shuffle));
    return /*Deref*/this;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::UseListOrder::UseListOrder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/UseListOrder.h", line = 47,
   FQN="llvm::UseListOrder::UseListOrder", NM="_ZN4llvm12UseListOrderC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm12UseListOrderC1ERKS0_")
  //</editor-fold>
  protected/*private*/ UseListOrder(final /*const*/ UseListOrder /*&*/ X) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::UseListOrder::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/UseListOrder.h", line = 48,
   FQN="llvm::UseListOrder::operator=", NM="_ZN4llvm12UseListOrderaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm12UseListOrderaSERKS0_")
  //</editor-fold>
  protected/*private*/ UseListOrder /*&*/ $assign(final /*const*/ UseListOrder /*&*/ X) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::UseListOrder::~UseListOrder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/UseListOrder.h", line = 28,
   FQN="llvm::UseListOrder::~UseListOrder", NM="_ZN4llvm12UseListOrderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm12UseListOrderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Shuffle.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public UseListOrder move() {
    return new UseListOrder(JD$Move.INSTANCE, this);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "V=" + V // NOI18N
              + ", F=" + F // NOI18N
              + ", Shuffle=" + Shuffle; // NOI18N
  }
}
