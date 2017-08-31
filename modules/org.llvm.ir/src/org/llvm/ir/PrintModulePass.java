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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;


/// \brief Pass for printing a Module as LLVM's text IR assembly.
///
/// Note: This pass is for use with the new pass manager. Use the create...Pass
/// functions above to create passes for use with the legacy pass manager.
//<editor-fold defaultstate="collapsed" desc="llvm::PrintModulePass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/IRPrintingPasses.h", line = 61,
 FQN="llvm::PrintModulePass", NM="_ZN4llvm15PrintModulePassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp -nm=_ZN4llvm15PrintModulePassE")
//</editor-fold>
public class PrintModulePass implements Destructors.ClassWithDestructor, IPass<PreservedAnalyses, Module> {
  private final raw_ostream /*&*/ OS;
  private std.string Banner;
  private boolean ShouldPreserveUseListOrder;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PrintModulePass::PrintModulePass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp", line = 23,
   FQN="llvm::PrintModulePass::PrintModulePass", NM="_ZN4llvm15PrintModulePassC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp -nm=_ZN4llvm15PrintModulePassC1Ev")
  //</editor-fold>
  public PrintModulePass() {
    // : OS(dbgs()), Banner()
    //START JInit
    this./*&*/OS=/*&*/dbgs();
    this.Banner = new std.string();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PrintModulePass::PrintModulePass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp", line = 24,
   FQN="llvm::PrintModulePass::PrintModulePass", NM="_ZN4llvm15PrintModulePassC1ERNS_11raw_ostreamERKSsb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp -nm=_ZN4llvm15PrintModulePassC1ERNS_11raw_ostreamERKSsb")
  //</editor-fold>
  public PrintModulePass(final raw_ostream /*&*/ OS) {
    this(OS, new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY),
      false);
  }
  public PrintModulePass(final raw_ostream /*&*/ OS, final /*const*/std.string/*&*/ Banner/*= ""*/) {
    this(OS, Banner,
      false);
  }
  public PrintModulePass(final raw_ostream /*&*/ OS, final /*const*/std.string/*&*/ Banner/*= ""*/,
      boolean ShouldPreserveUseListOrder/*= false*/) {
    // : OS(OS), Banner(Banner), ShouldPreserveUseListOrder(ShouldPreserveUseListOrder)
    //START JInit
    this./*&*/OS=/*&*/OS;
    this.Banner = new std.string(Banner);
    this.ShouldPreserveUseListOrder = ShouldPreserveUseListOrder;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PrintModulePass::run">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp", line = 29,
   FQN="llvm::PrintModulePass::run", NM="_ZN4llvm15PrintModulePass3runERNS_6ModuleERNS_15AnalysisManagerIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp -nm=_ZN4llvm15PrintModulePass3runERNS_6ModuleERNS_15AnalysisManagerIS1_EE")
  //</editor-fold>
  public PreservedAnalyses run(final Module /*&*/ M, final AnalysisManager<Module>/*&*/ $Prm1) {
    OS.$out(Banner);
    if (IrLlvmGlobals.isFunctionInPrintList(new StringRef(/*KEEP_STR*/$STAR))) {
      M.print(OS, (AssemblyAnnotationWriter /*P*/ )null, ShouldPreserveUseListOrder);
    } else {
      for (final /*const*/ Function /*&*/ F : M.functions())  {
        if (IrLlvmGlobals.isFunctionInPrintList(F.getName())) {
          F.print(OS);
        }
      }
    }
    return PreservedAnalyses.all();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PrintModulePass::name">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRPrintingPasses.h", line = 73,
   FQN="llvm::PrintModulePass::name", NM="_ZN4llvm15PrintModulePass4nameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp -nm=_ZN4llvm15PrintModulePass4nameEv")
  //</editor-fold>
  public StringRef name() {
    return new StringRef(/*KEEP_STR*/"PrintModulePass");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PrintModulePass::~PrintModulePass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRPrintingPasses.h", line = 61,
   FQN="llvm::PrintModulePass::~PrintModulePass", NM="_ZN4llvm15PrintModulePassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/IRPrintingPasses.cpp -nm=_ZN4llvm15PrintModulePassD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Banner.$destroy();
    //END JDestroy
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::PrintModulePass::PrintModulePass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/IRPrintingPasses.h", line = 61,
   FQN="llvm::PrintModulePass::PrintModulePass", NM="_ZN4llvm15PrintModulePassC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm15PrintModulePassC1EOS0_")
  //</editor-fold>
  public /*inline*/ PrintModulePass(JD$Move _dparam, final PrintModulePass /*&&*/$Prm0) {
    // : OS(static_cast<PrintModulePass &&>().OS), Banner(static_cast<PrintModulePass &&>().Banner), ShouldPreserveUseListOrder(static_cast<PrintModulePass &&>().ShouldPreserveUseListOrder)
    //START JInit
    this./*&*/OS=/*&*/$Prm0.OS;
    this.Banner = new std.string(JD$Move.INSTANCE, $Prm0.Banner);
    this.ShouldPreserveUseListOrder = $Prm0.ShouldPreserveUseListOrder;
    //END JInit
  }


  @Override public String toString() {
    return "" + "OS=" + OS // NOI18N
              + ", Banner=" + Banner // NOI18N
              + ", ShouldPreserveUseListOrder=" + ShouldPreserveUseListOrder; // NOI18N
  }
}
