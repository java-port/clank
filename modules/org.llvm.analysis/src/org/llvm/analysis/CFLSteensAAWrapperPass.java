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
import org.llvm.pass.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.impl.*;


/// Legacy wrapper pass to provide the CFLSteensAAResult object.
//<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAWrapperPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLSteensAliasAnalysis.h", line = 144,
 FQN="llvm::CFLSteensAAWrapperPass", NM="_ZN4llvm22CFLSteensAAWrapperPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm22CFLSteensAAWrapperPassE")
//</editor-fold>
public class CFLSteensAAWrapperPass extends /*public*/ ImmutablePass implements Destructors.ClassWithDestructor {
  private std.unique_ptr<CFLSteensAAResult> Result;
/*public:*/
  // JAVA: moved to extra/*public*/ static /*char*/byte ID = $int2char(0);
  
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAWrapperPass::CFLSteensAAWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 430,
   FQN="llvm::CFLSteensAAWrapperPass::CFLSteensAAWrapperPass", NM="_ZN4llvm22CFLSteensAAWrapperPassC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm22CFLSteensAAWrapperPassC1Ev")
  //</editor-fold>
  public CFLSteensAAWrapperPass() {
    // : ImmutablePass(ID), Result() 
    //START JInit
    super(ID);
    this.Result = new std.unique_ptr<CFLSteensAAResult>();
    //END JInit
    CFLSteensAliasAnalysisLlvmStatics.initializeCFLSteensAAWrapperPassPass($Deref(PassRegistry.getPassRegistry()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAWrapperPass::getResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLSteensAliasAnalysis.h", line = 152,
   FQN="llvm::CFLSteensAAWrapperPass::getResult", NM="_ZN4llvm22CFLSteensAAWrapperPass9getResultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm22CFLSteensAAWrapperPass9getResultEv")
  //</editor-fold>
  public CFLSteensAAResult /*&*/ getResult() {
    return Result.$star();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAWrapperPass::getResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLSteensAliasAnalysis.h", line = 153,
   FQN="llvm::CFLSteensAAWrapperPass::getResult", NM="_ZNK4llvm22CFLSteensAAWrapperPass9getResultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZNK4llvm22CFLSteensAAWrapperPass9getResultEv")
  //</editor-fold>
  public /*const*/ CFLSteensAAResult /*&*/ getResult$Const() /*const*/ {
    return Result.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAWrapperPass::initializePass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 434,
   FQN="llvm::CFLSteensAAWrapperPass::initializePass", NM="_ZN4llvm22CFLSteensAAWrapperPass14initializePassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm22CFLSteensAAWrapperPass14initializePassEv")
  //</editor-fold>
  @Override public void initializePass()/* override*/ {
    final TargetLibraryInfoWrapperPass /*&*/ TLIWP = this.<TargetLibraryInfoWrapperPass>getAnalysis(TargetLibraryInfoWrapperPass.class);
    Result.reset(new CFLSteensAAResult(TLIWP.getTLI()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAWrapperPass::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 439,
   FQN="llvm::CFLSteensAAWrapperPass::getAnalysisUsage", NM="_ZNK4llvm22CFLSteensAAWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZNK4llvm22CFLSteensAAWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    AU.setPreservesAll();
    AU.<TargetLibraryInfoWrapperPass>addRequired(TargetLibraryInfoWrapperPass.class);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CFLSteensAAWrapperPass::~CFLSteensAAWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLSteensAliasAnalysis.h", line = 144,
   FQN="llvm::CFLSteensAAWrapperPass::~CFLSteensAAWrapperPass", NM="_ZN4llvm22CFLSteensAAWrapperPassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm22CFLSteensAAWrapperPassD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Result.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static final/*char*/Class<CFLSteensAAWrapperPass> ID = CFLSteensAAWrapperPass.class;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Result=" + Result // NOI18N
              + super.toString(); // NOI18N
  }
}
