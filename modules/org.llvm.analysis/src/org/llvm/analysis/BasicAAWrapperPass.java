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
import static org.clank.support.Native.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.impl.*;


/// Legacy wrapper pass to provide the BasicAAResult object.
//<editor-fold defaultstate="collapsed" desc="llvm::BasicAAWrapperPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BasicAliasAnalysis.h", line = 210,
 FQN="llvm::BasicAAWrapperPass", NM="_ZN4llvm18BasicAAWrapperPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm18BasicAAWrapperPassE")
//</editor-fold>
public class BasicAAWrapperPass extends /*public*/ FunctionPass implements Destructors.ClassWithDestructor {
  private std.unique_ptr<BasicAAResult> Result;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAWrapperPass::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 1685,
   FQN="llvm::BasicAAWrapperPass::anchor", NM="_ZN4llvm18BasicAAWrapperPass6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm18BasicAAWrapperPass6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*public:*/
  // JAVA: moved to extra/*public*/ static /*char*/byte ID = $int2char(0);
  
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAWrapperPass::BasicAAWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 1680,
   FQN="llvm::BasicAAWrapperPass::BasicAAWrapperPass", NM="_ZN4llvm18BasicAAWrapperPassC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm18BasicAAWrapperPassC1Ev")
  //</editor-fold>
  public BasicAAWrapperPass() {
    // : FunctionPass(ID), Result() 
    //START JInit
    super(ID);
    this.Result = new std.unique_ptr<BasicAAResult>();
    //END JInit
    BasicAliasAnalysisLlvmStatics.initializeBasicAAWrapperPassPass($Deref(PassRegistry.getPassRegistry()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAWrapperPass::getResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BasicAliasAnalysis.h", line = 220,
   FQN="llvm::BasicAAWrapperPass::getResult", NM="_ZN4llvm18BasicAAWrapperPass9getResultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm18BasicAAWrapperPass9getResultEv")
  //</editor-fold>
  public BasicAAResult /*&*/ getResult() {
    return Result.$star();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAWrapperPass::getResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BasicAliasAnalysis.h", line = 221,
   FQN="llvm::BasicAAWrapperPass::getResult", NM="_ZNK4llvm18BasicAAWrapperPass9getResultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZNK4llvm18BasicAAWrapperPass9getResultEv")
  //</editor-fold>
  public /*const*/ BasicAAResult /*&*/ getResult$Const() /*const*/ {
    return Result.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAWrapperPass::runOnFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 1699,
   FQN="llvm::BasicAAWrapperPass::runOnFunction", NM="_ZN4llvm18BasicAAWrapperPass13runOnFunctionERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm18BasicAAWrapperPass13runOnFunctionERNS_8FunctionE")
  //</editor-fold>
  @Override public boolean runOnFunction(final Function /*&*/ F)/* override*/ {
    final AssumptionCacheTracker /*&*/ ACT = this.<AssumptionCacheTracker>getAnalysis(AssumptionCacheTracker.class);
    final TargetLibraryInfoWrapperPass /*&*/ TLIWP = this.<TargetLibraryInfoWrapperPass>getAnalysis(TargetLibraryInfoWrapperPass.class);
    final DominatorTreeWrapperPass /*&*/ DTWP = this.<DominatorTreeWrapperPass>getAnalysis(DominatorTreeWrapperPass.class);
    LoopInfoWrapperPass /*P*/ LIWP = this.<LoopInfoWrapperPass>getAnalysisIfAvailable(LoopInfoWrapperPass.class);
    
    Result.reset(new BasicAAResult(F.getParent().getDataLayout(), TLIWP.getTLI(), 
            ACT.getAssumptionCache(F), $AddrOf(DTWP.getDomTree()), 
            (LIWP != null) ? $AddrOf(LIWP.getLoopInfo()) : (LoopInfo /*P*/ )null));
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAWrapperPass::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 1712,
   FQN="llvm::BasicAAWrapperPass::getAnalysisUsage", NM="_ZNK4llvm18BasicAAWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZNK4llvm18BasicAAWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    AU.setPreservesAll();
    AU.<AssumptionCacheTracker>addRequired(AssumptionCacheTracker.class);
    AU.<DominatorTreeWrapperPass>addRequired(DominatorTreeWrapperPass.class);
    AU.<TargetLibraryInfoWrapperPass>addRequired(TargetLibraryInfoWrapperPass.class);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicAAWrapperPass::~BasicAAWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BasicAliasAnalysis.h", line = 210,
   FQN="llvm::BasicAAWrapperPass::~BasicAAWrapperPass", NM="_ZN4llvm18BasicAAWrapperPassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm18BasicAAWrapperPassD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Result.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static final/*char*/Class<BasicAAWrapperPass> ID = BasicAAWrapperPass.class;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Result=" + Result // NOI18N
              + super.toString(); // NOI18N
  }
}
