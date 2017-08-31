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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.ir.java.IPassFunction;
import static org.llvm.ir.java.IrRTTI.cast_CallInst;
import static org.llvm.pass.IrLlvmGlobals.$out_raw_ostream_Value$C;


/// \brief Printer pass for the \c AssumptionAnalysis results.
//<editor-fold defaultstate="collapsed" desc="llvm::AssumptionPrinterPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 115,
 FQN="llvm::AssumptionPrinterPass", NM="_ZN4llvm21AssumptionPrinterPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm21AssumptionPrinterPassE")
//</editor-fold>
public class AssumptionPrinterPass implements /*public*/ PassInfoMixin<AssumptionPrinterPass>, IPassFunction<PreservedAnalyses> {
  private final raw_ostream /*&*/ OS;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionPrinterPass::AssumptionPrinterPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 119,
   FQN="llvm::AssumptionPrinterPass::AssumptionPrinterPass", NM="_ZN4llvm21AssumptionPrinterPassC1ERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm21AssumptionPrinterPassC1ERNS_11raw_ostreamE")
  //</editor-fold>
  public /*explicit*/ AssumptionPrinterPass(final raw_ostream /*&*/ OS) {
    // : PassInfoMixin<AssumptionPrinterPass>(), OS(OS) 
    //START JInit
    $PassInfoMixin();
    this./*&*/OS=/*&*/OS;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionPrinterPass::run">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp", line = 79,
   FQN="llvm::AssumptionPrinterPass::run", NM="_ZN4llvm21AssumptionPrinterPass3runERNS_8FunctionERNS_15AnalysisManagerIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm21AssumptionPrinterPass3runERNS_8FunctionERNS_15AnalysisManagerIS1_EE")
  //</editor-fold>
  public PreservedAnalyses run(final Function /*&*/ F, 
     final AnalysisManager<Function> /*&*/ AM) {
    final AssumptionCache /*&*/ AC = AM.getResult(AssumptionAnalysis.class, F);
    
    OS.$out(/*KEEP_STR*/"Cached assumptions for function: ").$out(F.getName()).$out(/*KEEP_STR*/$LF);
    for (final WeakVH /*&*/ VH : AC.assumptions())  {
      if (((VH.$Value$P()) != null)) {
        $out_raw_ostream_Value$C(OS.$out(/*KEEP_STR*/"  "), $Deref(cast_CallInst(VH.$Value$P()).getArgOperand(0))).$out(/*KEEP_STR*/$LF);
      }
    }
    
    return PreservedAnalyses.all();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::AssumptionPrinterPass::AssumptionPrinterPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AssumptionCache.h", line = 115,
   FQN="llvm::AssumptionPrinterPass::AssumptionPrinterPass", NM="_ZN4llvm21AssumptionPrinterPassC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm21AssumptionPrinterPassC1EOS0_")
  //</editor-fold>
  public /*inline*/ AssumptionPrinterPass(JD$Move _dparam, final AssumptionPrinterPass /*&&*/$Prm0) {
    // : PassInfoMixin<AssumptionPrinterPass>(static_cast<AssumptionPrinterPass &&>()), OS(static_cast<AssumptionPrinterPass &&>().OS) 
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
