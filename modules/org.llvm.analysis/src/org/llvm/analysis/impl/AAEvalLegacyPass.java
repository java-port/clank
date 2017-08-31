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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import org.llvm.analysis.*;

//<editor-fold defaultstate="collapsed" desc="llvm::AAEvalLegacyPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 350,
 FQN="llvm::AAEvalLegacyPass", NM="_ZN4llvm16AAEvalLegacyPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZN4llvm16AAEvalLegacyPassE")
//</editor-fold>
public class AAEvalLegacyPass extends /*public*/ FunctionPass implements Destructors.ClassWithDestructor {
  private std.unique_ptr<AAEvaluator> P;
/*public:*/
  public static final/*char*/Class<AAEvalLegacyPass> ID = AAEvalLegacyPass.class; // Pass identification, replacement for typeid
  //<editor-fold defaultstate="collapsed" desc="llvm::AAEvalLegacyPass::AAEvalLegacyPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 355,
   FQN="llvm::AAEvalLegacyPass::AAEvalLegacyPass", NM="_ZN4llvm16AAEvalLegacyPassC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZN4llvm16AAEvalLegacyPassC1Ev")
  //</editor-fold>
  public AAEvalLegacyPass() {
    // : FunctionPass(ID), P() 
    //START JInit
    super(ID);
    this.P = new std.unique_ptr<AAEvaluator>();
    //END JInit
    AliasAnalysisEvaluatorLlvmStatics.initializeAAEvalLegacyPassPass($Deref(PassRegistry.getPassRegistry()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AAEvalLegacyPass::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 359,
   FQN="llvm::AAEvalLegacyPass::getAnalysisUsage", NM="_ZNK4llvm16AAEvalLegacyPass16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZNK4llvm16AAEvalLegacyPass16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    AU.<AAResultsWrapperPass>addRequired(AAResultsWrapperPass.class);
    AU.setPreservesAll();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AAEvalLegacyPass::doInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 364,
   FQN="llvm::AAEvalLegacyPass::doInitialization", NM="_ZN4llvm16AAEvalLegacyPass16doInitializationERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZN4llvm16AAEvalLegacyPass16doInitializationERNS_6ModuleE")
  //</editor-fold>
  @Override public boolean doInitialization(final Module /*&*/ M)/* override*/ {
    P.reset(new AAEvaluator());
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AAEvalLegacyPass::runOnFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 369,
   FQN="llvm::AAEvalLegacyPass::runOnFunction", NM="_ZN4llvm16AAEvalLegacyPass13runOnFunctionERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZN4llvm16AAEvalLegacyPass13runOnFunctionERNS_8FunctionE")
  //</editor-fold>
  @Override public boolean runOnFunction(final Function /*&*/ F)/* override*/ {
    P.$arrow().runInternal(F, this.<AAResultsWrapperPass>getAnalysis(AAResultsWrapperPass.class).getAAResults());
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AAEvalLegacyPass::doFinalization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 373,
   FQN="llvm::AAEvalLegacyPass::doFinalization", NM="_ZN4llvm16AAEvalLegacyPass14doFinalizationERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZN4llvm16AAEvalLegacyPass14doFinalizationERNS_6ModuleE")
  //</editor-fold>
  @Override public boolean doFinalization(final Module /*&*/ M)/* override*/ {
    P.reset();
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AAEvalLegacyPass::~AAEvalLegacyPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 350,
   FQN="llvm::AAEvalLegacyPass::~AAEvalLegacyPass", NM="_ZN4llvm16AAEvalLegacyPassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZN4llvm16AAEvalLegacyPassD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    P.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "P=" + P // NOI18N
              + super.toString(); // NOI18N
  }
}
