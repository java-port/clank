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

package org.llvm.ir;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import org.llvm.ir.java.IPassFunction;
import org.llvm.support.*;


/// \brief Printer pass for the \c DominatorTree.
//<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreePrinterPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 215,
 FQN="llvm::DominatorTreePrinterPass", NM="_ZN4llvm24DominatorTreePrinterPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm24DominatorTreePrinterPassE")
//</editor-fold>
public class DominatorTreePrinterPass implements /*public*/ PassInfoMixin<DominatorTreePrinterPass>, IPassFunction<PreservedAnalyses> {
  private final raw_ostream /*&*/ OS;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreePrinterPass::DominatorTreePrinterPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Dominators.cpp", line = 312,
   FQN="llvm::DominatorTreePrinterPass::DominatorTreePrinterPass", NM="_ZN4llvm24DominatorTreePrinterPassC1ERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm24DominatorTreePrinterPassC1ERNS_11raw_ostreamE")
  //</editor-fold>
  public DominatorTreePrinterPass(final raw_ostream /*&*/ OS) {
    // : PassInfoMixin<DominatorTreePrinterPass>(), OS(OS)
    //START JInit
    super();
    this./*&*/OS=/*&*/OS;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreePrinterPass::run">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Dominators.cpp", line = 314,
   FQN="llvm::DominatorTreePrinterPass::run", NM="_ZN4llvm24DominatorTreePrinterPass3runERNS_8FunctionERNS_15AnalysisManagerIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm24DominatorTreePrinterPass3runERNS_8FunctionERNS_15AnalysisManagerIS1_EE")
  //</editor-fold>
  public PreservedAnalyses run(final Function /*&*/ F,
     final AnalysisManager<Function>/*&*/ AM) {
    OS.$out(/*KEEP_STR*/"DominatorTree for function: ").$out(F.getName()).$out(/*KEEP_STR*/$LF);
    AM.getResult(DominatorTreeAnalysis.class, F).print(OS);

    return PreservedAnalyses.all();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreePrinterPass::DominatorTreePrinterPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 215,
   FQN="llvm::DominatorTreePrinterPass::DominatorTreePrinterPass", NM="_ZN4llvm24DominatorTreePrinterPassC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm24DominatorTreePrinterPassC1EOS0_")
  //</editor-fold>
  public /*inline*/ DominatorTreePrinterPass(JD$Move _dparam, final DominatorTreePrinterPass /*&&*/$Prm0) {
    // : PassInfoMixin<DominatorTreePrinterPass>(static_cast<DominatorTreePrinterPass &&>()), OS(static_cast<DominatorTreePrinterPass &&>().OS)
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
