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
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.impl.*;
import static org.llvm.analysis.impl.AliasAnalysisStatics.DisableBasicAA;


/// A wrapper pass to provide the legacy pass manager access to a suitably
/// prepared AAResults object.
//<editor-fold defaultstate="collapsed" desc="llvm::AAResultsWrapperPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 915,
 FQN="llvm::AAResultsWrapperPass", NM="_ZN4llvm20AAResultsWrapperPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm20AAResultsWrapperPassE")
//</editor-fold>
public class AAResultsWrapperPass extends /*public*/ FunctionPass implements Destructors.ClassWithDestructor {
  private std.unique_ptr<AAResults> AAR;
/*public:*/
  // JAVA: moved to extra/*public*/ static /*char*/byte ID = $int2char(0);
  
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResultsWrapperPass::AAResultsWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 550,
   FQN="llvm::AAResultsWrapperPass::AAResultsWrapperPass", NM="_ZN4llvm20AAResultsWrapperPassC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm20AAResultsWrapperPassC1Ev")
  //</editor-fold>
  public AAResultsWrapperPass() {
    // : FunctionPass(ID), AAR() 
    //START JInit
    super(ID);
    this.AAR = new std.unique_ptr<AAResults>();
    //END JInit
    AliasAnalysisLlvmStatics.initializeAAResultsWrapperPassPass($Deref(PassRegistry.getPassRegistry()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResultsWrapperPass::getAAResults">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 923,
   FQN="llvm::AAResultsWrapperPass::getAAResults", NM="_ZN4llvm20AAResultsWrapperPass12getAAResultsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm20AAResultsWrapperPass12getAAResultsEv")
  //</editor-fold>
  public AAResults /*&*/ getAAResults() {
    return AAR.$star();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AAResultsWrapperPass::getAAResults">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 924,
   FQN="llvm::AAResultsWrapperPass::getAAResults", NM="_ZNK4llvm20AAResultsWrapperPass12getAAResultsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZNK4llvm20AAResultsWrapperPass12getAAResultsEv")
  //</editor-fold>
  public /*const*/ AAResults /*&*/ getAAResults$Const() /*const*/ {
    return AAR.$star();
  }

  
  
  /// Run the wrapper pass to rebuild an aggregation over known AA passes.
  ///
  /// This is the legacy pass manager's interface to the new-style AA results
  /// aggregation object. Because this is somewhat shoe-horned into the legacy
  /// pass manager, we hard code all the specific alias analyses available into
  /// it. While the particular set enabled is configured via commandline flags,
  /// adding a new alias analysis to LLVM will require adding support for it to
  /// this list.
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResultsWrapperPass::runOnFunction">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 582,
   FQN="llvm::AAResultsWrapperPass::runOnFunction", NM="_ZN4llvm20AAResultsWrapperPass13runOnFunctionERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm20AAResultsWrapperPass13runOnFunctionERNS_8FunctionE")
  //</editor-fold>
  @Override public boolean runOnFunction(final Function /*&*/ F)/* override*/ {
    // NB! This *must* be reset before adding new AA results to the new
    // AAResults object because in the legacy pass manager, each instance
    // of these will refer to the *same* immutable analyses, registering and
    // unregistering themselves with them. We need to carefully tear down the
    // previous object first, in this case replacing it with an empty one, before
    // registering new results.
    AAR.reset(new AAResults(this.<TargetLibraryInfoWrapperPass>getAnalysis(TargetLibraryInfoWrapperPass.class).getTLI()));
    
    // BasicAA is always available for function analyses. Also, we add it first
    // so that it can trump TBAA results when it proves MustAlias.
    // FIXME: TBAA should have an explicit mode to support this and then we
    // should reconsider the ordering here.
    if (!DisableBasicAA.$T()) {
      AAR.$arrow().addAAResult(this.<BasicAAWrapperPass>getAnalysis(BasicAAWrapperPass.class).getResult());
    }
    {
      
      // Populate the results with the currently available AAs.
      ScopedNoAliasAAWrapperPass /*P*/ WrapperPass = this.<ScopedNoAliasAAWrapperPass>getAnalysisIfAvailable(ScopedNoAliasAAWrapperPass.class);
      if ((WrapperPass != null)) {
        AAR.$arrow().addAAResult(WrapperPass.getResult());
      }
    }
    {
      TypeBasedAAWrapperPass /*P*/ WrapperPass = this.<TypeBasedAAWrapperPass>getAnalysisIfAvailable(TypeBasedAAWrapperPass.class);
      if ((WrapperPass != null)) {
        AAR.$arrow().addAAResult(WrapperPass.getResult());
      }
    }
    {
      ObjCARCAAWrapperPass /*P*/ WrapperPass = this.<ObjCARCAAWrapperPass>getAnalysisIfAvailable(ObjCARCAAWrapperPass.class);
      if ((WrapperPass != null)) {
        AAR.$arrow().addAAResult(WrapperPass.getResult());
      }
    }
    {
      GlobalsAAWrapperPass /*P*/ WrapperPass = this.<GlobalsAAWrapperPass>getAnalysisIfAvailable(GlobalsAAWrapperPass.class);
      if ((WrapperPass != null)) {
        AAR.$arrow().addAAResult(WrapperPass.getResult());
      }
    }
    {
      SCEVAAWrapperPass /*P*/ WrapperPass = this.<SCEVAAWrapperPass>getAnalysisIfAvailable(SCEVAAWrapperPass.class);
      if ((WrapperPass != null)) {
        AAR.$arrow().addAAResult(WrapperPass.getResult());
      }
    }
    {
      CFLAndersAAWrapperPass /*P*/ WrapperPass = this.<CFLAndersAAWrapperPass>getAnalysisIfAvailable(CFLAndersAAWrapperPass.class);
      if ((WrapperPass != null)) {
        AAR.$arrow().addAAResult(WrapperPass.getResult());
      }
    }
    {
      CFLSteensAAWrapperPass /*P*/ WrapperPass = this.<CFLSteensAAWrapperPass>getAnalysisIfAvailable(CFLSteensAAWrapperPass.class);
      if ((WrapperPass != null)) {
        AAR.$arrow().addAAResult(WrapperPass.getResult());
      }
    }
    {
      
      // If available, run an external AA providing callback over the results as
      // well.
      ExternalAAWrapperPass /*P*/ WrapperPass = this.<ExternalAAWrapperPass>getAnalysisIfAvailable(ExternalAAWrapperPass.class);
      if ((WrapperPass != null)) {
        if (WrapperPass.CB != null) {
          WrapperPass.CB.$call(/*Deref*/this, F, AAR.$star());
        }
      }
    }
    
    // Analyses don't mutate the IR, so return false.
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AAResultsWrapperPass::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 626,
   FQN="llvm::AAResultsWrapperPass::getAnalysisUsage", NM="_ZNK4llvm20AAResultsWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZNK4llvm20AAResultsWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    AU.setPreservesAll();
    AU.<BasicAAWrapperPass>addRequired(BasicAAWrapperPass.class);
    AU.<TargetLibraryInfoWrapperPass>addRequired(TargetLibraryInfoWrapperPass.class);
    
    // We also need to mark all the alias analysis passes we will potentially
    // probe in runOnFunction as used here to ensure the legacy pass manager
    // preserves them. This hard coding of lists of alias analyses is specific to
    // the legacy pass manager.
    AU.<ScopedNoAliasAAWrapperPass>addUsedIfAvailable(ScopedNoAliasAAWrapperPass.class);
    AU.<TypeBasedAAWrapperPass>addUsedIfAvailable(TypeBasedAAWrapperPass.class);
    AU.<ObjCARCAAWrapperPass>addUsedIfAvailable(ObjCARCAAWrapperPass.class);
    AU.<GlobalsAAWrapperPass>addUsedIfAvailable(GlobalsAAWrapperPass.class);
    AU.<SCEVAAWrapperPass>addUsedIfAvailable(SCEVAAWrapperPass.class);
    AU.<CFLAndersAAWrapperPass>addUsedIfAvailable(CFLAndersAAWrapperPass.class);
    AU.<CFLSteensAAWrapperPass>addUsedIfAvailable(CFLSteensAAWrapperPass.class);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AAResultsWrapperPass::~AAResultsWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasAnalysis.h", line = 915,
   FQN="llvm::AAResultsWrapperPass::~AAResultsWrapperPass", NM="_ZN4llvm20AAResultsWrapperPassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm20AAResultsWrapperPassD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    AAR.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static final/*char*/Class<AAResultsWrapperPass> ID = AAResultsWrapperPass.class;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "AAR=" + AAR // NOI18N
              + super.toString(); // NOI18N
  }
}
