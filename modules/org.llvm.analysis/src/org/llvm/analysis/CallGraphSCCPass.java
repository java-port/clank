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
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import org.llvm.analysis.impl.*;

//<editor-fold defaultstate="collapsed" desc="llvm::CallGraphSCCPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraphSCCPass.h", line = 35,
 FQN="llvm::CallGraphSCCPass", NM="_ZN4llvm16CallGraphSCCPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm16CallGraphSCCPassE")
//</editor-fold>
public abstract class CallGraphSCCPass extends /*public*/ Pass implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphSCCPass::CallGraphSCCPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraphSCCPass.h", line = 37,
   FQN="llvm::CallGraphSCCPass::CallGraphSCCPass", NM="_ZN4llvm16CallGraphSCCPassC1ERc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm16CallGraphSCCPassC1ERc")
  //</editor-fold>
  public /*explicit*/ CallGraphSCCPass(final Class<? extends CallGraphSCCPass>/*char &*/ pid) {
    // : Pass(PT_CallGraphSCC, pid)
    //START JInit
    super(PassKind.PT_CallGraphSCC, pid);
    //END JInit
  }


  /// createPrinterPass - Get a pass that prints the Module
  /// corresponding to a CallGraph.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphSCCPass::createPrinterPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp", line = 630,
   FQN="llvm::CallGraphSCCPass::createPrinterPass", NM="_ZNK4llvm16CallGraphSCCPass17createPrinterPassERNS_11raw_ostreamERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZNK4llvm16CallGraphSCCPass17createPrinterPassERNS_11raw_ostreamERKSs")
  //</editor-fold>
  @Override public Pass /*P*/ createPrinterPass(final raw_ostream /*&*/ O,
                   final /*const*/std.string/*&*/ Banner) /*const*//* override*/ {
    return new PrintCallGraphPass(Banner, O);
  }


  //JAVA: using llvm::Pass::doInitialization;
  //JAVA: using llvm::Pass::doFinalization;

  /// doInitialization - This method is called before the SCC's of the program
  /// has been processed, allowing the pass to do initialization as necessary.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphSCCPass::doInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraphSCCPass.h", line = 49,
   FQN="llvm::CallGraphSCCPass::doInitialization", NM="_ZN4llvm16CallGraphSCCPass16doInitializationERNS_9CallGraphE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm16CallGraphSCCPass16doInitializationERNS_9CallGraphE")
  //</editor-fold>
  public /*virtual*/ boolean doInitialization(final CallGraph /*&*/ CG) {
    return false;
  }


  /// runOnSCC - This method should be implemented by the subclass to perform
  /// whatever action is necessary for the specified SCC.  Note that
  /// non-recursive (or only self-recursive) functions will have an SCC size of
  /// 1, where recursive portions of the call graph will have SCC size > 1.
  ///
  /// SCC passes that add or delete functions to the SCC are required to update
  /// the SCC list, otherwise stale pointers may be dereferenced.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphSCCPass::runOnSCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraphSCCPass.h", line = 61,
   FQN="llvm::CallGraphSCCPass::runOnSCC", NM="_ZN4llvm16CallGraphSCCPass8runOnSCCERNS_12CallGraphSCCE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm16CallGraphSCCPass8runOnSCCERNS_12CallGraphSCCE")
  //</editor-fold>
  public abstract /*virtual*/ boolean runOnSCC(final CallGraphSCC /*&*/ SCC)/* = 0*/;


  /// doFinalization - This method is called after the SCC's of the program has
  /// been processed, allowing the pass to do final cleanup as necessary.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphSCCPass::doFinalization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraphSCCPass.h", line = 65,
   FQN="llvm::CallGraphSCCPass::doFinalization", NM="_ZN4llvm16CallGraphSCCPass14doFinalizationERNS_9CallGraphE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm16CallGraphSCCPass14doFinalizationERNS_9CallGraphE")
  //</editor-fold>
  public /*virtual*/ boolean doFinalization(final CallGraph /*&*/ CG) {
    return false;
  }


  /// Assign pass manager to manager this pass

  //===----------------------------------------------------------------------===//
  // CallGraphSCCPass Implementation
  //===----------------------------------------------------------------------===//

  /// Assign pass manager to manage this pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphSCCPass::assignPassManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp", line = 548,
   FQN="llvm::CallGraphSCCPass::assignPassManager", NM="_ZN4llvm16CallGraphSCCPass17assignPassManagerERNS_7PMStackENS_15PassManagerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm16CallGraphSCCPass17assignPassManagerERNS_7PMStackENS_15PassManagerTypeE")
  //</editor-fold>
  @Override public void assignPassManager(final PMStack /*&*/ PMS,
                   PassManagerType PreferredType)/* override*/ {
    // Find CGPassManager
    while (!PMS.empty()
       && PMS.top().getPassManagerType().getValue() > PassManagerType.PMT_CallGraphPassManager.getValue()) {
      PMS.pop();
    }
    assert (!PMS.empty()) : "Unable to handle Call Graph Pass";
    CGPassManager /*P*/ CGP;
    if (PMS.top().getPassManagerType() == PassManagerType.PMT_CallGraphPassManager) {
      CGP = (CGPassManager /*P*/ )PMS.top();
    } else {
      // Create new Call Graph SCC Pass Manager if it does not exist.
      assert (!PMS.empty()) : "Unable to create Call Graph Pass Manager";
      PMDataManager /*P*/ PMD = PMS.top();

      // [1] Create new Call Graph Pass Manager
      CGP = new CGPassManager();

      // [2] Set up new manager's top level manager
      PMTopLevelManager /*P*/ TPM = PMD.getTopLevelManager();
      TPM.addIndirectPassManager(CGP);

      // [3] Assign manager to manage this new manager. This may create
      // and push new managers into PMS
      Pass /*P*/ P = CGP;
      TPM.schedulePass(P);

      // [4] Push new manager into PMS
      PMS.push(CGP);
    }

    CGP.add(this);
  }


  ///  Return what kind of Pass Manager can manage this pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphSCCPass::getPotentialPassManagerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraphSCCPass.h", line = 73,
   FQN="llvm::CallGraphSCCPass::getPotentialPassManagerType", NM="_ZNK4llvm16CallGraphSCCPass27getPotentialPassManagerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZNK4llvm16CallGraphSCCPass27getPotentialPassManagerTypeEv")
  //</editor-fold>
  @Override public PassManagerType getPotentialPassManagerType() /*const*//* override*/ {
    return PassManagerType.PMT_CallGraphPassManager;
  }


  /// getAnalysisUsage - For this class, we declare that we require and preserve
  /// the call graph.  If the derived class implements this method, it should
  /// always explicitly call the implementation here.

  /// For this class, we declare that we require and preserve the call graph.
  /// If the derived class implements this method, it should
  /// always explicitly call the implementation here.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphSCCPass::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp", line = 587,
   FQN="llvm::CallGraphSCCPass::getAnalysisUsage", NM="_ZNK4llvm16CallGraphSCCPass16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZNK4llvm16CallGraphSCCPass16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    AU.<CallGraphWrapperPass>addRequired(CallGraphWrapperPass.class);
    AU.<CallGraphWrapperPass>addPreserved(CallGraphWrapperPass.class);
  }

/*protected:*/
  /// Optional passes call this function to check whether the pass should be
  /// skipped. This is the case when optimization bisect is over the limit.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphSCCPass::skipSCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp", line = 635,
   FQN="llvm::CallGraphSCCPass::skipSCC", NM="_ZNK4llvm16CallGraphSCCPass7skipSCCERNS_12CallGraphSCCE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZNK4llvm16CallGraphSCCPass7skipSCCERNS_12CallGraphSCCE")
  //</editor-fold>
  protected boolean skipSCC(final CallGraphSCC /*&*/ SCC) /*const*/ {
    return !SCC.getCallGraph().getModule().
        getContext().
        getOptBisect().
        shouldRunPass(this, SCC);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphSCCPass::~CallGraphSCCPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraphSCCPass.h", line = 35,
   FQN="llvm::CallGraphSCCPass::~CallGraphSCCPass", NM="_ZN4llvm16CallGraphSCCPassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraphSCCPass.cpp -nm=_ZN4llvm16CallGraphSCCPassD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
