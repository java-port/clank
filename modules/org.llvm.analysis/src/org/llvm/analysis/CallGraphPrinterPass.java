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
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.ir.java.IPassModule;


/// \brief Printer pass for the \c CallGraphAnalysis results.
//<editor-fold defaultstate="collapsed" desc="llvm::CallGraphPrinterPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 313,
 FQN="llvm::CallGraphPrinterPass", NM="_ZN4llvm20CallGraphPrinterPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm20CallGraphPrinterPassE")
//</editor-fold>
public class CallGraphPrinterPass implements /*public*/ PassInfoMixin<CallGraphPrinterPass>, IPassModule<PreservedAnalyses> {
  private final raw_ostream /*&*/ OS;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphPrinterPass::CallGraphPrinterPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 317,
   FQN="llvm::CallGraphPrinterPass::CallGraphPrinterPass", NM="_ZN4llvm20CallGraphPrinterPassC1ERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm20CallGraphPrinterPassC1ERNS_11raw_ostreamE")
  //</editor-fold>
  public /*explicit*/ CallGraphPrinterPass(final raw_ostream /*&*/ OS) {
    // : PassInfoMixin<CallGraphPrinterPass>(), OS(OS) 
    //START JInit
    $PassInfoMixin();
    this./*&*/OS=/*&*/OS;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphPrinterPass::run">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 263,
   FQN="llvm::CallGraphPrinterPass::run", NM="_ZN4llvm20CallGraphPrinterPass3runERNS_6ModuleERNS_15AnalysisManagerIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm20CallGraphPrinterPass3runERNS_6ModuleERNS_15AnalysisManagerIS1_EE")
  //</editor-fold>
  public PreservedAnalyses run(final Module /*&*/ M, 
     final AnalysisManager<Module> /*&*/ AM) {
    AM.getResult(CallGraphAnalysis.class, M).print(OS);
    return PreservedAnalyses.all();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallGraphPrinterPass::CallGraphPrinterPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraph.h", line = 313,
   FQN="llvm::CallGraphPrinterPass::CallGraphPrinterPass", NM="_ZN4llvm20CallGraphPrinterPassC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm20CallGraphPrinterPassC1EOS0_")
  //</editor-fold>
  public /*inline*/ CallGraphPrinterPass(JD$Move _dparam, final CallGraphPrinterPass /*&&*/$Prm0) {
    // : PassInfoMixin<CallGraphPrinterPass>(static_cast<CallGraphPrinterPass &&>()), OS(static_cast<CallGraphPrinterPass &&>().OS) 
    //START JInit
    $PassInfoMixin(JD$Move.INSTANCE, $Prm0);
    this./*&*/OS=/*&*/$Prm0.OS;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "OS=" + OS // NOI18N
              + super.toString(); // NOI18N
  }
}
