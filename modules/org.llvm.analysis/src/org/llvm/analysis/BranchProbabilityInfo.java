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


/// \brief Analysis providing branch probability information.
///
/// This is a function analysis which provides information on the relative
/// probabilities of each "edge" in the function's CFG where such an edge is
/// defined by a pair (PredBlock and an index in the successors). The
/// probability of an edge from one block is always relative to the
/// probabilities of other edges from the block. The probabilites of all edges
/// from a block sum to exactly one (100%).
/// We use a pair (PredBlock and an index in the successors) to uniquely
/// identify an edge, since we can have multiple edges from Src to Dst.
/// As an example, we can have a switch which jumps to Dst with value 0 and
/// value 10.
//<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BranchProbabilityInfo.h", line = 43,
 FQN="llvm::BranchProbabilityInfo", NM="_ZN4llvm21BranchProbabilityInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfoE")
//</editor-fold>
public class BranchProbabilityInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::BranchProbabilityInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BranchProbabilityInfo.h", line = 45,
   FQN="llvm::BranchProbabilityInfo::BranchProbabilityInfo", NM="_ZN4llvm21BranchProbabilityInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfoC1Ev")
  //</editor-fold>
  public BranchProbabilityInfo() {
    // : Handles(), Probs(), PostDominatedByUnreachable(), PostDominatedByColdCall() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::BranchProbabilityInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BranchProbabilityInfo.h", line = 46,
   FQN="llvm::BranchProbabilityInfo::BranchProbabilityInfo", NM="_ZN4llvm21BranchProbabilityInfoC1ERKNS_8FunctionERKNS_8LoopInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfoC1ERKNS_8FunctionERKNS_8LoopInfoE")
  //</editor-fold>
  public BranchProbabilityInfo(final /*const*/ Function /*&*/ F, final /*const*/ LoopInfo /*&*/ LI) {
    // : Handles(), Probs(), PostDominatedByUnreachable(), PostDominatedByColdCall() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::BranchProbabilityInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BranchProbabilityInfo.h", line = 50,
   FQN="llvm::BranchProbabilityInfo::BranchProbabilityInfo", NM="_ZN4llvm21BranchProbabilityInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfoC1EOS0_")
  //</editor-fold>
  public BranchProbabilityInfo(JD$Move _dparam, final BranchProbabilityInfo /*&&*/Arg) {
    // : Handles(), Probs(std::move(Arg.Probs)), LastF(Arg.LastF), PostDominatedByUnreachable(std::move(Arg.PostDominatedByUnreachable)), PostDominatedByColdCall(std::move(Arg.PostDominatedByColdCall)) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BranchProbabilityInfo.h", line = 55,
   FQN="llvm::BranchProbabilityInfo::operator=", NM="_ZN4llvm21BranchProbabilityInfoaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfoaSEOS0_")
  //</editor-fold>
  public BranchProbabilityInfo /*&*/ $assignMove(final BranchProbabilityInfo /*&&*/RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 535,
   FQN="llvm::BranchProbabilityInfo::releaseMemory", NM="_ZN4llvm21BranchProbabilityInfo13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfo13releaseMemoryEv")
  //</editor-fold>
  public void releaseMemory() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 539,
   FQN="llvm::BranchProbabilityInfo::print", NM="_ZNK4llvm21BranchProbabilityInfo5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZNK4llvm21BranchProbabilityInfo5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Get an edge's probability, relative to other out-edges of the Src.
  ///
  /// This routine provides access to the fractional probability between zero
  /// (0%) and one (100%) of this edge executing, relative to other edges
  /// leaving the 'Src' block. The returned probability is never zero, and can
  /// only be one if the source block has only one successor.
  
  /// Get the raw edge probability for the edge. If can't find it, return a
  /// default probability 1/N where N is the number of successors. Here an edge is
  /// specified using PredBlock and an
  /// index to the successors.
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::getEdgeProbability">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 584,
   FQN="llvm::BranchProbabilityInfo::getEdgeProbability", NM="_ZNK4llvm21BranchProbabilityInfo18getEdgeProbabilityEPKNS_10BasicBlockEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZNK4llvm21BranchProbabilityInfo18getEdgeProbabilityEPKNS_10BasicBlockEj")
  //</editor-fold>
  public BranchProbability getEdgeProbability(/*const*/ BasicBlock /*P*/ Src, 
                    /*uint*/int IndexInSuccessors) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Get the probability of going from Src to Dst.
  ///
  /// It returns the sum of all probabilities for edges from Src to Dst.
  
  /// Get the raw edge probability calculated for the block pair. This returns the
  /// sum of all raw edge probabilities from Src to Dst.
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::getEdgeProbability">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 604,
   FQN="llvm::BranchProbabilityInfo::getEdgeProbability", NM="_ZNK4llvm21BranchProbabilityInfo18getEdgeProbabilityEPKNS_10BasicBlockES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZNK4llvm21BranchProbabilityInfo18getEdgeProbabilityEPKNS_10BasicBlockES3_")
  //</editor-fold>
  public BranchProbability getEdgeProbability(/*const*/ BasicBlock /*P*/ Src, 
                    /*const*/ BasicBlock /*P*/ Dst) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::getEdgeProbability">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 596,
   FQN="llvm::BranchProbabilityInfo::getEdgeProbability", NM="_ZNK4llvm21BranchProbabilityInfo18getEdgeProbabilityEPKNS_10BasicBlockENS_14TerminatorInst12SuccIteratorIPKS4_S2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZNK4llvm21BranchProbabilityInfo18getEdgeProbabilityEPKNS_10BasicBlockENS_14TerminatorInst12SuccIteratorIPKS4_S2_EE")
  //</editor-fold>
  public BranchProbability getEdgeProbability(/*const*/ BasicBlock /*P*/ Src, 
                    TerminatorInst.SuccIterator</*const*/ TerminatorInst /*P*/ , /*const*/ BasicBlock> Dst) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Test if an edge is hot relative to other out-edges of the Src.
  ///
  /// Check whether this edge out of the source block is 'hot'. We define hot
  /// as having a relative probability >= 80%.
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::isEdgeHot">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 552,
   FQN="llvm::BranchProbabilityInfo::isEdgeHot", NM="_ZNK4llvm21BranchProbabilityInfo9isEdgeHotEPKNS_10BasicBlockES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZNK4llvm21BranchProbabilityInfo9isEdgeHotEPKNS_10BasicBlockES3_")
  //</editor-fold>
  public boolean isEdgeHot(/*const*/ BasicBlock /*P*/ Src, /*const*/ BasicBlock /*P*/ Dst) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Retrieve the hot successor of a block if one exists.
  ///
  /// Given a basic block, look through its successors and if one exists for
  /// which \see isEdgeHot would return true, return that successor block.
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::getHotSucc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 559,
   FQN="llvm::BranchProbabilityInfo::getHotSucc", NM="_ZNK4llvm21BranchProbabilityInfo10getHotSuccEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZNK4llvm21BranchProbabilityInfo10getHotSuccEPKNS_10BasicBlockE")
  //</editor-fold>
  public /*const*/ BasicBlock /*P*/ getHotSucc(/*const*/ BasicBlock /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Print an edge's probability.
  ///
  /// Retrieves an edge's probability similarly to \see getEdgeProbability, but
  /// then prints that probability to the provided stream. That stream is then
  /// returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::printEdgeProbability">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 632,
   FQN="llvm::BranchProbabilityInfo::printEdgeProbability", NM="_ZNK4llvm21BranchProbabilityInfo20printEdgeProbabilityERNS_11raw_ostreamEPKNS_10BasicBlockES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZNK4llvm21BranchProbabilityInfo20printEdgeProbabilityERNS_11raw_ostreamEPKNS_10BasicBlockES5_")
  //</editor-fold>
  public raw_ostream /*&*/ printEdgeProbability(final raw_ostream /*&*/ OS, 
                      /*const*/ BasicBlock /*P*/ Src, 
                      /*const*/ BasicBlock /*P*/ Dst) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Set the raw edge probability for the given edge.
  ///
  /// This allows a pass to explicitly set the edge probability for an edge. It
  /// can be used when updating the CFG to update and preserve the branch
  /// probability information. Read the implementation of how these edge
  /// probabilities are calculated carefully before using!
  
  /// Set the edge probability for a given edge specified by PredBlock and an
  /// index to the successors.
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::setEdgeProbability">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 623,
   FQN="llvm::BranchProbabilityInfo::setEdgeProbability", NM="_ZN4llvm21BranchProbabilityInfo18setEdgeProbabilityEPKNS_10BasicBlockEjNS_17BranchProbabilityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfo18setEdgeProbabilityEPKNS_10BasicBlockEjNS_17BranchProbabilityE")
  //</editor-fold>
  public void setEdgeProbability(/*const*/ BasicBlock /*P*/ Src, 
                    /*uint*/int IndexInSuccessors, 
                    BranchProbability Prob) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::getBranchProbStackProtector">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BranchProbabilityInfo.h", line = 114,
   FQN="llvm::BranchProbabilityInfo::getBranchProbStackProtector", NM="_ZN4llvm21BranchProbabilityInfo27getBranchProbStackProtectorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfo27getBranchProbStackProtectorEb")
  //</editor-fold>
  public static BranchProbability getBranchProbStackProtector(boolean IsLikely) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::calculate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 653,
   FQN="llvm::BranchProbabilityInfo::calculate", NM="_ZN4llvm21BranchProbabilityInfo9calculateERKNS_8FunctionERKNS_8LoopInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfo9calculateERKNS_8FunctionERKNS_8LoopInfoE")
  //</editor-fold>
  public void calculate(final /*const*/ Function /*&*/ F, final /*const*/ LoopInfo /*&*/ LI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Forget analysis results for the given basic block.
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::eraseBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 645,
   FQN="llvm::BranchProbabilityInfo::eraseBlock", NM="_ZN4llvm21BranchProbabilityInfo10eraseBlockEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfo10eraseBlockEPKNS_10BasicBlockE")
  //</editor-fold>
  public void eraseBlock(/*const*/ BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BranchProbabilityInfo.h", line = 125,
   FQN="llvm::BranchProbabilityInfo::operator=", NM="_ZN4llvm21BranchProbabilityInfoaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfoaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ BranchProbabilityInfo /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::BranchProbabilityInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BranchProbabilityInfo.h", line = 126,
   FQN="llvm::BranchProbabilityInfo::BranchProbabilityInfo", NM="_ZN4llvm21BranchProbabilityInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfoC1ERKS0_")
  //</editor-fold>
  protected/*private*/ BranchProbabilityInfo(final /*const*/ BranchProbabilityInfo /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  // We need to store CallbackVH's in order to correctly handle basic block
  // removal.
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::BasicBlockCallbackVH">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BranchProbabilityInfo.h", line = 130,
   FQN="llvm::BranchProbabilityInfo::BasicBlockCallbackVH", NM="_ZN4llvm21BranchProbabilityInfo20BasicBlockCallbackVHE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfo20BasicBlockCallbackVHE")
  //</editor-fold>
  private static final class BasicBlockCallbackVH extends /*public*/ CallbackVH implements Destructors.ClassWithDestructor {
    private BranchProbabilityInfo /*P*/ BPI;
    //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::BasicBlockCallbackVH::deleted">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BranchProbabilityInfo.h", line = 132,
     FQN="llvm::BranchProbabilityInfo::BasicBlockCallbackVH::deleted", NM="_ZN4llvm21BranchProbabilityInfo20BasicBlockCallbackVH7deletedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfo20BasicBlockCallbackVH7deletedEv")
    //</editor-fold>
    @Override public/*private*/ void deleted()/* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::BasicBlockCallbackVH::BasicBlockCallbackVH">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BranchProbabilityInfo.h", line = 139,
     FQN="llvm::BranchProbabilityInfo::BasicBlockCallbackVH::BasicBlockCallbackVH", NM="_ZN4llvm21BranchProbabilityInfo20BasicBlockCallbackVHC1EPKNS_5ValueEPS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfo20BasicBlockCallbackVHC1EPKNS_5ValueEPS0_")
    //</editor-fold>
    public BasicBlockCallbackVH(/*const*/ Value /*P*/ V) {
      this(V, (BranchProbabilityInfo /*P*/ )null);
    }
    public BasicBlockCallbackVH(/*const*/ Value /*P*/ V, BranchProbabilityInfo /*P*/ BPI/*= null*/) {
      // : CallbackVH(const_cast<Value * >(V)), BPI(BPI) 
      super(((/*const_cast*/Value /*P*/ )(V)));
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::BasicBlockCallbackVH::BasicBlockCallbackVH">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BranchProbabilityInfo.h", line = 130,
     FQN="llvm::BranchProbabilityInfo::BasicBlockCallbackVH::BasicBlockCallbackVH", NM="_ZN4llvm21BranchProbabilityInfo20BasicBlockCallbackVHC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfo20BasicBlockCallbackVHC1EOS1_")
    //</editor-fold>
    public /*inline*/ BasicBlockCallbackVH(JD$Move _dparam, final BasicBlockCallbackVH /*&&*/$Prm0) {
      // : CallbackVH(static_cast<BasicBlockCallbackVH &&>()), BPI(static_cast<BasicBlockCallbackVH &&>().BPI) 
      super($Prm0);
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::BasicBlockCallbackVH::operator=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BranchProbabilityInfo.h", line = 130,
     FQN="llvm::BranchProbabilityInfo::BasicBlockCallbackVH::operator=", NM="_ZN4llvm21BranchProbabilityInfo20BasicBlockCallbackVHaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfo20BasicBlockCallbackVHaSERKS1_")
    //</editor-fold>
    public /*inline*/ BasicBlockCallbackVH /*&*/ $assign(final /*const*/ BasicBlockCallbackVH /*&*/ $Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::BasicBlockCallbackVH::operator=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BranchProbabilityInfo.h", line = 130,
     FQN="llvm::BranchProbabilityInfo::BasicBlockCallbackVH::operator=", NM="_ZN4llvm21BranchProbabilityInfo20BasicBlockCallbackVHaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfo20BasicBlockCallbackVHaSEOS1_")
    //</editor-fold>
    public /*inline*/ BasicBlockCallbackVH /*&*/ $assignMove(final BasicBlockCallbackVH /*&&*/$Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::BasicBlockCallbackVH::~BasicBlockCallbackVH">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BranchProbabilityInfo.h", line = 130,
     FQN="llvm::BranchProbabilityInfo::BasicBlockCallbackVH::~BasicBlockCallbackVH", NM="_ZN4llvm21BranchProbabilityInfo20BasicBlockCallbackVHD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfo20BasicBlockCallbackVHD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::BasicBlockCallbackVH::BasicBlockCallbackVH">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BranchProbabilityInfo.h", line = 130,
     FQN="llvm::BranchProbabilityInfo::BasicBlockCallbackVH::BasicBlockCallbackVH", NM="_ZN4llvm21BranchProbabilityInfo20BasicBlockCallbackVHC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfo20BasicBlockCallbackVHC1ERKS1_")
    //</editor-fold>
    public /*inline*/ BasicBlockCallbackVH(final /*const*/ BasicBlockCallbackVH /*&*/ $Prm0) {
      // : CallbackVH(), BPI(.BPI) 
      super($Prm0);
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "BPI=" + BPI // NOI18N
                + super.toString(); // NOI18N
    }
  };
  private DenseSet<BasicBlockCallbackVH/*, DenseMapInfoBaseT$P<Value>*/ > Handles;
  
  // Since we allow duplicate edges from one basic block to another, we use
  // a pair (PredBlock and an index in the successors) to specify an edge.
  // JAVA: typedef std::pair<const BasicBlock *, unsigned int> Edge
//  public final class Edge extends std.pairTypeUInt</*const*/ BasicBlock /*P*/ >{ };
  
  // Default weight value. Used when we don't have information about the edge.
  // TODO: DEFAULT_WEIGHT makes sense during static predication, when none of
  // the successors have a weight yet. But it doesn't make sense when providing
  // weight to an edge that may have siblings with non-zero weights. This can
  // be handled various ways, but it's probably fine for an edge with unknown
  // weight to just "inherit" the non-zero weight of an adjacent successor.
  private static /*const*//*uint32_t*/int DEFAULT_WEIGHT = 16;
  
  private DenseMap<std.pairTypeUInt</*const*/ BasicBlock /*P*/ >, BranchProbability> Probs;
  
  /// \brief Track the last function we run over for printing.
  private /*const*/ Function /*P*/ LastF;
  
  /// \brief Track the set of blocks directly succeeded by a returning block.
  private SmallPtrSet</*const*/ BasicBlock /*P*/ > PostDominatedByUnreachable;
  
  /// \brief Track the set of blocks that always lead to a cold call.
  private SmallPtrSet</*const*/ BasicBlock /*P*/ > PostDominatedByColdCall;
  
  
  /// \brief Calculate edge weights for successors lead to unreachable.
  ///
  /// Predict that a successor which leads necessarily to an
  /// unreachable-terminated block as extremely unlikely.
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::calcUnreachableHeuristics">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 115,
   FQN="llvm::BranchProbabilityInfo::calcUnreachableHeuristics", NM="_ZN4llvm21BranchProbabilityInfo25calcUnreachableHeuristicsEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfo25calcUnreachableHeuristicsEPKNS_10BasicBlockE")
  //</editor-fold>
  private boolean calcUnreachableHeuristics(/*const*/ BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Propagate existing explicit probabilities from either profile data or
  // 'expect' intrinsic processing.
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::calcMetadataWeights">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 182,
   FQN="llvm::BranchProbabilityInfo::calcMetadataWeights", NM="_ZN4llvm21BranchProbabilityInfo19calcMetadataWeightsEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfo19calcMetadataWeightsEPKNS_10BasicBlockE")
  //</editor-fold>
  private boolean calcMetadataWeights(/*const*/ BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Calculate edge weights for edges leading to cold blocks.
  ///
  /// A cold block is one post-dominated by  a block with a call to a
  /// cold function.  Those edges are unlikely to be taken, so we give
  /// them relatively low weight.
  ///
  /// Return true if we could compute the weights for cold edges.
  /// Return false, otherwise.
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::calcColdCallHeuristics">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 252,
   FQN="llvm::BranchProbabilityInfo::calcColdCallHeuristics", NM="_ZN4llvm21BranchProbabilityInfo22calcColdCallHeuristicsEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfo22calcColdCallHeuristicsEPKNS_10BasicBlockE")
  //</editor-fold>
  private boolean calcColdCallHeuristics(/*const*/ BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Calculate Edge Weights using "Pointer Heuristics". Predict a comparsion
  // between two pointer or pointer and NULL will fail.
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::calcPointerHeuristics">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 310,
   FQN="llvm::BranchProbabilityInfo::calcPointerHeuristics", NM="_ZN4llvm21BranchProbabilityInfo21calcPointerHeuristicsEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfo21calcPointerHeuristicsEPKNS_10BasicBlockE")
  //</editor-fold>
  private boolean calcPointerHeuristics(/*const*/ BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Calculate Edge Weights using "Loop Branch Heuristics". Predict backedges
  // as taken, exiting edges as not-taken.
  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::calcLoopBranchHeuristics">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 345,
   FQN="llvm::BranchProbabilityInfo::calcLoopBranchHeuristics", NM="_ZN4llvm21BranchProbabilityInfo24calcLoopBranchHeuristicsEPKNS_10BasicBlockERKNS_8LoopInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfo24calcLoopBranchHeuristicsEPKNS_10BasicBlockERKNS_8LoopInfoE")
  //</editor-fold>
  private boolean calcLoopBranchHeuristics(/*const*/ BasicBlock /*P*/ BB, 
                          final /*const*/ LoopInfo /*&*/ LI) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::calcZeroHeuristics">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 403,
   FQN="llvm::BranchProbabilityInfo::calcZeroHeuristics", NM="_ZN4llvm21BranchProbabilityInfo18calcZeroHeuristicsEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfo18calcZeroHeuristicsEPKNS_10BasicBlockE")
  //</editor-fold>
  private boolean calcZeroHeuristics(/*const*/ BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::calcFloatingPointHeuristics">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 486,
   FQN="llvm::BranchProbabilityInfo::calcFloatingPointHeuristics", NM="_ZN4llvm21BranchProbabilityInfo27calcFloatingPointHeuristicsEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfo27calcFloatingPointHeuristicsEPKNS_10BasicBlockE")
  //</editor-fold>
  private boolean calcFloatingPointHeuristics(/*const*/ BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::calcInvokeHeuristics">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 523,
   FQN="llvm::BranchProbabilityInfo::calcInvokeHeuristics", NM="_ZN4llvm21BranchProbabilityInfo20calcInvokeHeuristicsEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfo20calcInvokeHeuristicsEPKNS_10BasicBlockE")
  //</editor-fold>
  private boolean calcInvokeHeuristics(/*const*/ BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BranchProbabilityInfo::~BranchProbabilityInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BranchProbabilityInfo.h", line = 43,
   FQN="llvm::BranchProbabilityInfo::~BranchProbabilityInfo", NM="_ZN4llvm21BranchProbabilityInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm21BranchProbabilityInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Handles=" + Handles // NOI18N
              + ", Probs=" + Probs // NOI18N
              + ", LastF=" + LastF // NOI18N
              + ", PostDominatedByUnreachable=" + PostDominatedByUnreachable // NOI18N
              + ", PostDominatedByColdCall=" + PostDominatedByColdCall; // NOI18N
  }
}
