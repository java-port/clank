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

import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import org.llvm.analysis.impl.*;


/// \brief Legacy analysis pass which computes \c BlockFrequencyInfo.
//<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoWrapperPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfo.h", line = 109,
 FQN="llvm::BlockFrequencyInfoWrapperPass", NM="_ZN4llvm29BlockFrequencyInfoWrapperPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm29BlockFrequencyInfoWrapperPassE")
//</editor-fold>
public class BlockFrequencyInfoWrapperPass extends /*public*/ FunctionPass implements Destructors.ClassWithDestructor {
  private BlockFrequencyInfo BFI;
/*public:*/
  // JAVA: moved to extra/*public*/ static /*char*/byte ID = $int2char(0);
  
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoWrapperPass::BlockFrequencyInfoWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 223,
   FQN="llvm::BlockFrequencyInfoWrapperPass::BlockFrequencyInfoWrapperPass", NM="_ZN4llvm29BlockFrequencyInfoWrapperPassC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm29BlockFrequencyInfoWrapperPassC1Ev")
  //</editor-fold>
  public BlockFrequencyInfoWrapperPass() {
    // : FunctionPass(ID), BFI() 
    //START JInit
    super(ID);
    this.BFI = new BlockFrequencyInfo();
    //END JInit
    BlockFrequencyInfoLlvmStatics.initializeBlockFrequencyInfoWrapperPassPass($Deref(PassRegistry.getPassRegistry()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoWrapperPass::~BlockFrequencyInfoWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 228,
   FQN="llvm::BlockFrequencyInfoWrapperPass::~BlockFrequencyInfoWrapperPass", NM="_ZN4llvm29BlockFrequencyInfoWrapperPassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm29BlockFrequencyInfoWrapperPassD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    BFI.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoWrapperPass::getBFI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfo.h", line = 118,
   FQN="llvm::BlockFrequencyInfoWrapperPass::getBFI", NM="_ZN4llvm29BlockFrequencyInfoWrapperPass6getBFIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm29BlockFrequencyInfoWrapperPass6getBFIEv")
  //</editor-fold>
  public BlockFrequencyInfo /*&*/ getBFI() {
    return BFI;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoWrapperPass::getBFI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfo.h", line = 119,
   FQN="llvm::BlockFrequencyInfoWrapperPass::getBFI", NM="_ZNK4llvm29BlockFrequencyInfoWrapperPass6getBFIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm29BlockFrequencyInfoWrapperPass6getBFIEv")
  //</editor-fold>
  public /*const*/ BlockFrequencyInfo /*&*/ getBFI$Const() /*const*/ {
    return BFI;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoWrapperPass::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 235,
   FQN="llvm::BlockFrequencyInfoWrapperPass::getAnalysisUsage", NM="_ZNK4llvm29BlockFrequencyInfoWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm29BlockFrequencyInfoWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    AU.<BranchProbabilityInfoWrapperPass>addRequired(BranchProbabilityInfoWrapperPass.class);
    AU.<LoopInfoWrapperPass>addRequired(LoopInfoWrapperPass.class);
    AU.setPreservesAll();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoWrapperPass::runOnFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 243,
   FQN="llvm::BlockFrequencyInfoWrapperPass::runOnFunction", NM="_ZN4llvm29BlockFrequencyInfoWrapperPass13runOnFunctionERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm29BlockFrequencyInfoWrapperPass13runOnFunctionERNS_8FunctionE")
  //</editor-fold>
  @Override public boolean runOnFunction(final Function /*&*/ F)/* override*/ {
    final BranchProbabilityInfo /*&*/ BPI = this.<BranchProbabilityInfoWrapperPass>getAnalysis(BranchProbabilityInfoWrapperPass.class).getBPI();
    final LoopInfo /*&*/ LI = this.<LoopInfoWrapperPass>getAnalysis(LoopInfoWrapperPass.class).getLoopInfo();
    BFI.calculate(F, BPI, LI);
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoWrapperPass::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 241,
   FQN="llvm::BlockFrequencyInfoWrapperPass::releaseMemory", NM="_ZN4llvm29BlockFrequencyInfoWrapperPass13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm29BlockFrequencyInfoWrapperPass13releaseMemoryEv")
  //</editor-fold>
  @Override public void releaseMemory()/* override*/ {
    BFI.releaseMemory();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BlockFrequencyInfoWrapperPass::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 230,
   FQN="llvm::BlockFrequencyInfoWrapperPass::print", NM="_ZNK4llvm29BlockFrequencyInfoWrapperPass5printERNS_11raw_ostreamEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZNK4llvm29BlockFrequencyInfoWrapperPass5printERNS_11raw_ostreamEPKNS_6ModuleE")
  //</editor-fold>
  @Override public void print(final raw_ostream /*&*/ OS, 
       /*const*/ Module /*P*/ $Prm1) /*const*//* override*/ {
    BFI.print(OS);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static final/*char*/Class<BlockFrequencyInfoWrapperPass> ID = BlockFrequencyInfoWrapperPass.class;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BFI=" + BFI // NOI18N
              + super.toString(); // NOI18N
  }
}
