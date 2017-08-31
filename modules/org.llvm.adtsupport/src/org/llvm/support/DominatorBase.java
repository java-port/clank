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

package org.llvm.support;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;


/// \brief Base class that other, more interesting dominator analyses
/// inherit from.
/*template <class NodeT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::DominatorBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 35,
 FQN="llvm::DominatorBase", NM="_ZN4llvm13DominatorBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm13DominatorBaseE")
//</editor-fold>
public class DominatorBase</*class*/ NodeT>  {
/*protected:*/
  /*friend*/public final std.vector<NodeT /*P*/ > Roots;
  protected boolean IsPostDominators;
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorBase<NodeT>::DominatorBase">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 39,
   FQN="llvm::DominatorBase<NodeT>::DominatorBase", NM="_ZN4llvm13DominatorBaseINS_10BasicBlockEEC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm13DominatorBaseINS_10BasicBlockEEC1Eb")
  //</editor-fold>
  protected /*explicit*/ DominatorBase(boolean isPostDom) {
    // : Roots(), IsPostDominators(isPostDom) 
    //START JInit
    this.Roots = new std.vector<NodeT /*P*/ >((NodeT /*P*/ )null);
    this.IsPostDominators = isPostDom;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorBase<NodeT>::DominatorBase">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 41,
   FQN="llvm::DominatorBase<NodeT>::DominatorBase", NM="_ZN4llvm13DominatorBaseINS_10BasicBlockEEC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm13DominatorBaseINS_10BasicBlockEEC1EOS2_")
  //</editor-fold>
  protected DominatorBase(JD$Move _dparam, final DominatorBase<NodeT> /*&&*/Arg) {
    // : Roots(std::move(Arg.Roots)), IsPostDominators(std::move(Arg.IsPostDominators)) 
    //START JInit
    this.Roots = new std.vector<NodeT /*P*/ >(JD$Move.INSTANCE, std.move(Arg.Roots));
    this.IsPostDominators = std.move(Arg.IsPostDominators);
    //END JInit
    Arg.Roots.clear();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorBase<NodeT>::operator=">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 46,
   FQN="llvm::DominatorBase<NodeT>::operator=", NM="_ZN4llvm13DominatorBaseINS_10BasicBlockEEaSEOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm13DominatorBaseINS_10BasicBlockEEaSEOS2_")
  //</editor-fold>
  protected DominatorBase<NodeT> /*&*/ $assignMove(final DominatorBase<NodeT> /*&&*/RHS) {
    Roots.$assignMove(std.move(RHS.Roots));
    IsPostDominators = std.move(RHS.IsPostDominators);
    RHS.Roots.clear();
    return /*Deref*/this;
  }

/*public:*/
  /// getRoots - Return the root blocks of the current CFG.  This may include
  /// multiple blocks if we are computing post dominators.  For forward
  /// dominators, this will always be a single block (the entry node).
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorBase::getRoots">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 58,
   FQN="llvm::DominatorBase::getRoots", NM="_ZNK4llvm13DominatorBase8getRootsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZNK4llvm13DominatorBase8getRootsEv")
  //</editor-fold>
  public /*const*/ std.vector<NodeT /*P*/ > /*&*/ getRoots() /*const*/ {
    return Roots;
  }

  
  /// isPostDominator - Returns true if analysis based of postdoms
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorBase::isPostDominator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 62,
   FQN="llvm::DominatorBase::isPostDominator", NM="_ZNK4llvm13DominatorBase15isPostDominatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZNK4llvm13DominatorBase15isPostDominatorEv")
  //</editor-fold>
  public boolean isPostDominator() /*const*/ {
    return IsPostDominators;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected DominatorBase(DominatorBase $Prm0) {
    this.Roots = new std.vector<NodeT /*P*/ >((NodeT /*P*/ )null);
  }
  
  public void $destroy() {
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Roots=" + Roots // NOI18N
              + ", IsPostDominators=" + IsPostDominators; // NOI18N
  }
}
