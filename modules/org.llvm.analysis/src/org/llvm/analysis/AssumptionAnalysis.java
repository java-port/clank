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
import org.clank.support.JavaDifferentiators.*;
import org.llvm.ir.*;


/// \brief A function analysis which provides an \c AssumptionCache.
///
/// This analysis is intended for use with the new pass manager and will vend
/// assumption caches for a given function.
//<editor-fold defaultstate="collapsed" desc="llvm::AssumptionAnalysis">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 96,
 FQN="llvm::AssumptionAnalysis", NM="_ZN4llvm18AssumptionAnalysisE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm18AssumptionAnalysisE")
//</editor-fold>
public class AssumptionAnalysis implements /*public*/ AnalysisInfoMixin<AssumptionAnalysis> {
  /*friend  AnalysisInfoMixin<AssumptionAnalysis>*/
  private static /*char*/byte PassID;
/*public:*/
  // JAVA: typedef AssumptionCache Result
//  public final class Result extends AssumptionCache{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionAnalysis::AssumptionAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 103,
   FQN="llvm::AssumptionAnalysis::AssumptionAnalysis", NM="_ZN4llvm18AssumptionAnalysisC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm18AssumptionAnalysisC1Ev")
  //</editor-fold>
  public AssumptionAnalysis() {
    // : AnalysisInfoMixin<AssumptionAnalysis>() 
    //START JInit
    $AnalysisInfoMixin();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionAnalysis::AssumptionAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 104,
   FQN="llvm::AssumptionAnalysis::AssumptionAnalysis", NM="_ZN4llvm18AssumptionAnalysisC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm18AssumptionAnalysisC1ERKS0_")
  //</editor-fold>
  public AssumptionAnalysis(final /*const*/ AssumptionAnalysis /*&*/ Arg) {
    // : AnalysisInfoMixin<AssumptionAnalysis>() 
    //START JInit
    $AnalysisInfoMixin();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionAnalysis::AssumptionAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 105,
   FQN="llvm::AssumptionAnalysis::AssumptionAnalysis", NM="_ZN4llvm18AssumptionAnalysisC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm18AssumptionAnalysisC1EOS0_")
  //</editor-fold>
  public AssumptionAnalysis(JD$Move _dparam, final AssumptionAnalysis /*&&*/Arg) {
    // : AnalysisInfoMixin<AssumptionAnalysis>() 
    //START JInit
    $AnalysisInfoMixin();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionAnalysis::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 106,
   FQN="llvm::AssumptionAnalysis::operator=", NM="_ZN4llvm18AssumptionAnalysisaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm18AssumptionAnalysisaSERKS0_")
  //</editor-fold>
  public AssumptionAnalysis /*&*/ $assign(final /*const*/ AssumptionAnalysis /*&*/ RHS) {
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionAnalysis::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 107,
   FQN="llvm::AssumptionAnalysis::operator=", NM="_ZN4llvm18AssumptionAnalysisaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm18AssumptionAnalysisaSEOS0_")
  //</editor-fold>
  public AssumptionAnalysis /*&*/ $assignMove(final AssumptionAnalysis /*&&*/RHS) {
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionAnalysis::run">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 109,
   FQN="llvm::AssumptionAnalysis::run", NM="_ZN4llvm18AssumptionAnalysis3runERNS_8FunctionERNS_15AnalysisManagerIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm18AssumptionAnalysis3runERNS_8FunctionERNS_15AnalysisManagerIS1_EE")
  //</editor-fold>
  public AssumptionCache run(final Function /*&*/ F, final AnalysisManager<Function> /*&*/ $Prm1) {
    return new AssumptionCache(F);
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
