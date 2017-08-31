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

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import org.llvm.analysis.bfi_detail.*;
import org.llvm.analysis.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;


/// \brief Determine the iterated dominance frontier, given a set of defining
/// blocks, and optionally, a set of live-in blocks.
///
/// In turn, the results can be used to place phi nodes.
///
/// This algorithm is a linear time computation of Iterated Dominance Frontiers,
/// pruned using the live-in set.
/// By default, liveness is not used to prune the IDF computation.
/// The template parameters should be either BasicBlock* or Inverse<BasicBlock
/// *>, depending on if you want the forward or reverse IDF.
/*template <class NodeTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::IDFCalculator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IteratedDominanceFrontier.h", line = 45,
 FQN="llvm::IDFCalculator", NM="_ZN4llvm13IDFCalculatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IteratedDominanceFrontier.cpp -nm=_ZN4llvm13IDFCalculatorE")
//</editor-fold>
public class IDFCalculator</*class*/ NodeTy>  implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IDFCalculator::IDFCalculator<NodeTy>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IteratedDominanceFrontier.h", line = 49,
   FQN="llvm::IDFCalculator::IDFCalculator<NodeTy>", NM="_ZN4llvm13IDFCalculatorC1ERNS_17DominatorTreeBaseINS_10BasicBlockEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IteratedDominanceFrontier.cpp -nm=_ZN4llvm13IDFCalculatorC1ERNS_17DominatorTreeBaseINS_10BasicBlockEEE")
  //</editor-fold>
  public IDFCalculator(final DominatorTreeBase$BasicBlock /*&*/ DT) {
    // : DT(DT), useLiveIn(false) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Give the IDF calculator the set of blocks in which the value is
  /// defined.  This is equivalent to the set of starting blocks it should be
  /// calculating the IDF for (though later gets pruned based on liveness).
  ///
  /// Note: This set *must* live for the entire lifetime of the IDF calculator.
  //<editor-fold defaultstate="collapsed" desc="llvm::IDFCalculator::setDefiningBlocks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IteratedDominanceFrontier.h", line = 56,
   FQN="llvm::IDFCalculator::setDefiningBlocks", NM="_ZN4llvm13IDFCalculator17setDefiningBlocksERKNS_15SmallPtrSetImplIPNS_10BasicBlockEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IteratedDominanceFrontier.cpp -nm=_ZN4llvm13IDFCalculator17setDefiningBlocksERKNS_15SmallPtrSetImplIPNS_10BasicBlockEEE")
  //</editor-fold>
  public void setDefiningBlocks(final /*const*/ SmallPtrSetImpl<BasicBlock /*P*/ > /*&*/ Blocks) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Give the IDF calculator the set of blocks in which the value is
  /// live on entry to the block.   This is used to prune the IDF calculation to
  /// not include blocks where any phi insertion would be dead.
  ///
  /// Note: This set *must* live for the entire lifetime of the IDF calculator.
  //<editor-fold defaultstate="collapsed" desc="llvm::IDFCalculator::setLiveInBlocks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IteratedDominanceFrontier.h", line = 66,
   FQN="llvm::IDFCalculator::setLiveInBlocks", NM="_ZN4llvm13IDFCalculator15setLiveInBlocksERKNS_15SmallPtrSetImplIPNS_10BasicBlockEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IteratedDominanceFrontier.cpp -nm=_ZN4llvm13IDFCalculator15setLiveInBlocksERKNS_15SmallPtrSetImplIPNS_10BasicBlockEEE")
  //</editor-fold>
  public void setLiveInBlocks(final /*const*/ SmallPtrSetImpl<BasicBlock /*P*/ > /*&*/ Blocks) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Reset the live-in block set to be empty, and tell the IDF
  /// calculator to not use liveness anymore.
  //<editor-fold defaultstate="collapsed" desc="llvm::IDFCalculator::resetLiveInBlocks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IteratedDominanceFrontier.h", line = 73,
   FQN="llvm::IDFCalculator::resetLiveInBlocks", NM="_ZN4llvm13IDFCalculator17resetLiveInBlocksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IteratedDominanceFrontier.cpp -nm=_ZN4llvm13IDFCalculator17resetLiveInBlocksEv")
  //</editor-fold>
  public void resetLiveInBlocks() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Calculate iterated dominance frontiers
  ///
  /// This uses the linear-time phi algorithm based on DJ-graphs mentioned in
  /// the file-level comment.  It performs DF->IDF pruning using the live-in
  /// set, to avoid computing the IDF for blocks where an inserted PHI node
  /// would be dead.
  //<editor-fold defaultstate="collapsed" desc="llvm::IDFCalculator::calculate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IteratedDominanceFrontier.cpp", line = 20,
   FQN="llvm::IDFCalculator::calculate", NM="_ZN4llvm13IDFCalculator9calculateERNS_15SmallVectorImplIPNS_10BasicBlockEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IteratedDominanceFrontier.cpp -nm=_ZN4llvm13IDFCalculator9calculateERNS_15SmallVectorImplIPNS_10BasicBlockEEE")
  //</editor-fold>
  public void calculate(final SmallVectorImpl<BasicBlock /*P*/ > /*&*/ PHIBlocks) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private final DominatorTreeBase$BasicBlock /*&*/ DT;
  private boolean useLiveIn;
  private DenseMapTypeUInt<DomTreeNodeBase<BasicBlock> /*P*/> DomLevels;
  private /*const*/ SmallPtrSetImpl<BasicBlock /*P*/ > /*P*/ LiveInBlocks;
  private /*const*/ SmallPtrSetImpl<BasicBlock /*P*/ > /*P*/ DefBlocks;
  private SmallVector<BasicBlock /*P*/ > PHIBlocks;
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $destroy() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "DT=" + DT // NOI18N
              + ", useLiveIn=" + useLiveIn // NOI18N
              + ", DomLevels=" + DomLevels // NOI18N
              + ", LiveInBlocks=" + LiveInBlocks // NOI18N
              + ", DefBlocks=" + DefBlocks // NOI18N
              + ", PHIBlocks=" + PHIBlocks; // NOI18N
  }
}
