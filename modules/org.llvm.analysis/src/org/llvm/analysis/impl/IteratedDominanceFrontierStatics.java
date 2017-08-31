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

package org.llvm.analysis.impl;

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
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type IteratedDominanceFrontierStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="IteratedDominanceFrontierStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IteratedDominanceFrontier.cpp -nm=_ZN4llvm13IDFCalculatorINS_7InverseIPNS_10BasicBlockEEEEE;_ZN4llvm13IDFCalculatorIPNS_10BasicBlockEEE; -static-type=IteratedDominanceFrontierStatics")
//</editor-fold>
public final class IteratedDominanceFrontierStatics {

//<editor-fold defaultstate="collapsed" desc="llvm::IDFCalculator<BasicBlock * >">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/IteratedDominanceFrontier.cpp", line = 102,
 FQN="llvm::IDFCalculator<BasicBlock * >", NM="_ZN4llvm13IDFCalculatorIPNS_10BasicBlockEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IteratedDominanceFrontier.cpp -nm=_ZN4llvm13IDFCalculatorIPNS_10BasicBlockEEE")
//</editor-fold>
public static class IDFCalculator implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IDFCalculator<BasicBlock * >::IDFCalculator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IteratedDominanceFrontier.h", line = 49,
   FQN="llvm::IDFCalculator<BasicBlock * >::IDFCalculator", NM="_ZN4llvm13IDFCalculatorIPNS_10BasicBlockEEC1ERNS_17DominatorTreeBaseIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IteratedDominanceFrontier.cpp -nm=_ZN4llvm13IDFCalculatorIPNS_10BasicBlockEEC1ERNS_17DominatorTreeBaseIS1_EE")
  //</editor-fold>
  public IDFCalculator(final DominatorTreeBase$BasicBlock /*&*/ DT) {
    // : DT(DT), useLiveIn(false), DomLevels(), PHIBlocks() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Give the IDF calculator the set of blocks in which the value is
  /// defined.  This is equivalent to the set of starting blocks it should be
  /// calculating the IDF for (though later gets pruned based on liveness).
  ///
  /// Note: This set *must* live for the entire lifetime of the IDF calculator.
  //<editor-fold defaultstate="collapsed" desc="llvm::IDFCalculator<BasicBlock * >::setDefiningBlocks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IteratedDominanceFrontier.h", line = 56,
   FQN="llvm::IDFCalculator<BasicBlock * >::setDefiningBlocks", NM="_ZN4llvm13IDFCalculatorIPNS_10BasicBlockEE17setDefiningBlocksERKNS_15SmallPtrSetImplIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IteratedDominanceFrontier.cpp -nm=_ZN4llvm13IDFCalculatorIPNS_10BasicBlockEE17setDefiningBlocksERKNS_15SmallPtrSetImplIS2_EE")
  //</editor-fold>
  public void setDefiningBlocks(final /*const*/ SmallPtrSetImpl<BasicBlock /*P*/ > /*&*/ Blocks) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Give the IDF calculator the set of blocks in which the value is
  /// live on entry to the block.   This is used to prune the IDF calculation to
  /// not include blocks where any phi insertion would be dead.
  ///
  /// Note: This set *must* live for the entire lifetime of the IDF calculator.
  //<editor-fold defaultstate="collapsed" desc="llvm::IDFCalculator<BasicBlock * >::setLiveInBlocks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IteratedDominanceFrontier.h", line = 66,
   FQN="llvm::IDFCalculator<BasicBlock * >::setLiveInBlocks", NM="_ZN4llvm13IDFCalculatorIPNS_10BasicBlockEE15setLiveInBlocksERKNS_15SmallPtrSetImplIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IteratedDominanceFrontier.cpp -nm=_ZN4llvm13IDFCalculatorIPNS_10BasicBlockEE15setLiveInBlocksERKNS_15SmallPtrSetImplIS2_EE")
  //</editor-fold>
  public void setLiveInBlocks(final /*const*/ SmallPtrSetImpl<BasicBlock /*P*/ > /*&*/ Blocks) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Reset the live-in block set to be empty, and tell the IDF
  /// calculator to not use liveness anymore.
  //<editor-fold defaultstate="collapsed" desc="llvm::IDFCalculator<BasicBlock * >::resetLiveInBlocks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IteratedDominanceFrontier.h", line = 73,
   FQN="llvm::IDFCalculator<BasicBlock * >::resetLiveInBlocks", NM="_ZN4llvm13IDFCalculatorIPNS_10BasicBlockEE17resetLiveInBlocksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IteratedDominanceFrontier.cpp -nm=_ZN4llvm13IDFCalculatorIPNS_10BasicBlockEE17resetLiveInBlocksEv")
  //</editor-fold>
  public void resetLiveInBlocks() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IDFCalculator<BasicBlock * >::calculate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IteratedDominanceFrontier.cpp", line = 21,
   FQN="llvm::IDFCalculator<BasicBlock * >::calculate", NM="_ZN4llvm13IDFCalculatorIPNS_10BasicBlockEE9calculateERNS_15SmallVectorImplIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IteratedDominanceFrontier.cpp -nm=_ZN4llvm13IDFCalculatorIPNS_10BasicBlockEE9calculateERNS_15SmallVectorImplIS2_EE")
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
  //<editor-fold defaultstate="collapsed" desc="llvm::IDFCalculator<BasicBlock * >::~IDFCalculator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IteratedDominanceFrontier.cpp", line = 102,
   FQN="llvm::IDFCalculator<BasicBlock * >::~IDFCalculator", NM="_ZN4llvm13IDFCalculatorIPNS_10BasicBlockEED0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IteratedDominanceFrontier.cpp -nm=_ZN4llvm13IDFCalculatorIPNS_10BasicBlockEED0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  @Override public String toString() {
    return "" + "DT=" + DT // NOI18N
              + ", useLiveIn=" + useLiveIn // NOI18N
              + ", DomLevels=" + DomLevels // NOI18N
              + ", LiveInBlocks=" + LiveInBlocks // NOI18N
              + ", DefBlocks=" + DefBlocks // NOI18N
              + ", PHIBlocks=" + PHIBlocks; // NOI18N
  }
}
} // END OF class IteratedDominanceFrontierStatics
