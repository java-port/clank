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
import org.llvm.adt.Optional;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import org.llvm.analysis.impl.*;

//<editor-fold defaultstate="collapsed" desc="llvm::DemandedBitsWrapperPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DemandedBits.h", line = 71,
 FQN="llvm::DemandedBitsWrapperPass", NM="_ZN4llvm23DemandedBitsWrapperPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm23DemandedBitsWrapperPassE")
//</editor-fold>
public class DemandedBitsWrapperPass extends /*public*/ FunctionPass implements Destructors.ClassWithDestructor {
/*private:*/
  private /*mutable */Optional<DemandedBits> DB;
/*public:*/
  // JAVA: moved to extra/*public*/ static /*char*/byte ID = $int2char(0); // Pass identification, replacement for typeid
  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBitsWrapperPass::DemandedBitsWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp", line = 53,
   FQN="llvm::DemandedBitsWrapperPass::DemandedBitsWrapperPass", NM="_ZN4llvm23DemandedBitsWrapperPassC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm23DemandedBitsWrapperPassC1Ev")
  //</editor-fold>
  public DemandedBitsWrapperPass() {
    // : FunctionPass(ID), DB() 
    //START JInit
    super(ID);
    this.DB = new Optional<DemandedBits>();
    //END JInit
    DemandedBitsLlvmStatics.initializeDemandedBitsWrapperPassPass($Deref(PassRegistry.getPassRegistry()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBitsWrapperPass::runOnFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp", line = 250,
   FQN="llvm::DemandedBitsWrapperPass::runOnFunction", NM="_ZN4llvm23DemandedBitsWrapperPass13runOnFunctionERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm23DemandedBitsWrapperPass13runOnFunctionERNS_8FunctionE")
  //</editor-fold>
  @Override public boolean runOnFunction(final Function /*&*/ F)/* override*/ {
    final AssumptionCache /*&*/ AC = this.<AssumptionCacheTracker>getAnalysis(AssumptionCacheTracker.class).getAssumptionCache(F);
    final DominatorTree /*&*/ DT = this.<DominatorTreeWrapperPass>getAnalysis(DominatorTreeWrapperPass.class).getDomTree();
    DB.emplace(new DemandedBits(F, AC, DT));
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBitsWrapperPass::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp", line = 57,
   FQN="llvm::DemandedBitsWrapperPass::getAnalysisUsage", NM="_ZNK4llvm23DemandedBitsWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZNK4llvm23DemandedBitsWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    AU.setPreservesCFG();
    AU.<AssumptionCacheTracker>addRequired(AssumptionCacheTracker.class);
    AU.<DominatorTreeWrapperPass>addRequired(DominatorTreeWrapperPass.class);
    AU.setPreservesAll();
  }

  
  /// Clean up memory in between runs
  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBitsWrapperPass::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp", line = 257,
   FQN="llvm::DemandedBitsWrapperPass::releaseMemory", NM="_ZN4llvm23DemandedBitsWrapperPass13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm23DemandedBitsWrapperPass13releaseMemoryEv")
  //</editor-fold>
  @Override public void releaseMemory()/* override*/ {
    DB.reset();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBitsWrapperPass::getDemandedBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DemandedBits.h", line = 84,
   FQN="llvm::DemandedBitsWrapperPass::getDemandedBits", NM="_ZN4llvm23DemandedBitsWrapperPass15getDemandedBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm23DemandedBitsWrapperPass15getDemandedBitsEv")
  //</editor-fold>
  public DemandedBits /*&*/ getDemandedBits() {
    return DB.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBitsWrapperPass::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp", line = 64,
   FQN="llvm::DemandedBitsWrapperPass::print", NM="_ZNK4llvm23DemandedBitsWrapperPass5printERNS_11raw_ostreamEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZNK4llvm23DemandedBitsWrapperPass5printERNS_11raw_ostreamEPKNS_6ModuleE")
  //</editor-fold>
  @Override public void print(final raw_ostream /*&*/ OS, /*const*/ Module /*P*/ M) /*const*//* override*/ {
    DB.$arrow().print(OS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBitsWrapperPass::~DemandedBitsWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DemandedBits.h", line = 71,
   FQN="llvm::DemandedBitsWrapperPass::~DemandedBitsWrapperPass", NM="_ZN4llvm23DemandedBitsWrapperPassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm23DemandedBitsWrapperPassD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    DB.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static final/*char*/Class<DemandedBitsWrapperPass> ID = DemandedBitsWrapperPass.class; // Pass identification, replacement for typeid

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "DB=" + DB // NOI18N
              + super.toString(); // NOI18N
  }
}
