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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.pass.*;


/// \brief Legacy analysis pass which computes a \c DominatorTree.
//<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeWrapperPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 230,
 FQN="llvm::DominatorTreeWrapperPass", NM="_ZN4llvm24DominatorTreeWrapperPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm24DominatorTreeWrapperPassE")
//</editor-fold>
public class DominatorTreeWrapperPass extends /*public*/ FunctionPass implements Destructors.ClassWithDestructor {
  private DominatorTree DT;
/*public:*/

  //===----------------------------------------------------------------------===//
  //  DominatorTreeWrapperPass Implementation
  //===----------------------------------------------------------------------===//
  //
  // The implementation details of the wrapper pass that holds a DominatorTree
  // suitable for use with the legacy pass manager.
  //
  //===----------------------------------------------------------------------===//
  public static final/*char*/Class<DominatorTreeWrapperPass> ID = DominatorTreeWrapperPass.class;

  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeWrapperPass::DominatorTreeWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 236,
   FQN="llvm::DominatorTreeWrapperPass::DominatorTreeWrapperPass", NM="_ZN4llvm24DominatorTreeWrapperPassC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm24DominatorTreeWrapperPassC1Ev")
  //</editor-fold>
  public DominatorTreeWrapperPass() {
    // : FunctionPass(ID), DT()
    //START JInit
    super(ID);
    this.DT = new DominatorTree();
    //END JInit
    IrLlvmGlobals.initializeDominatorTreeWrapperPassPass($Deref(PassRegistry.getPassRegistry()));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeWrapperPass::getDomTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 240,
   FQN="llvm::DominatorTreeWrapperPass::getDomTree", NM="_ZN4llvm24DominatorTreeWrapperPass10getDomTreeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm24DominatorTreeWrapperPass10getDomTreeEv")
  //</editor-fold>
  public DominatorTree /*&*/ getDomTree() {
    return DT;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeWrapperPass::getDomTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 241,
   FQN="llvm::DominatorTreeWrapperPass::getDomTree", NM="_ZNK4llvm24DominatorTreeWrapperPass10getDomTreeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZNK4llvm24DominatorTreeWrapperPass10getDomTreeEv")
  //</editor-fold>
  public /*const*/ DominatorTree /*&*/ getDomTree$Const() /*const*/ {
    return DT;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeWrapperPass::runOnFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Dominators.cpp", line = 342,
   FQN="llvm::DominatorTreeWrapperPass::runOnFunction", NM="_ZN4llvm24DominatorTreeWrapperPass13runOnFunctionERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm24DominatorTreeWrapperPass13runOnFunctionERNS_8FunctionE")
  //</editor-fold>
  @Override public boolean runOnFunction(final Function /*&*/ F)/* override*/ {
    DT.recalculate(GraphTraitsFunction$P.$GTraits(), F);
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeWrapperPass::verifyAnalysis">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Dominators.cpp", line = 347,
   FQN="llvm::DominatorTreeWrapperPass::verifyAnalysis", NM="_ZNK4llvm24DominatorTreeWrapperPass14verifyAnalysisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZNK4llvm24DominatorTreeWrapperPass14verifyAnalysisEv")
  //</editor-fold>
  @Override public void verifyAnalysis() /*const*//* override*/ {
    if (DominatorsStatics.VerifyDomInfo) {
      DT.verifyDomTree();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeWrapperPass::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 247,
   FQN="llvm::DominatorTreeWrapperPass::getAnalysisUsage", NM="_ZNK4llvm24DominatorTreeWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZNK4llvm24DominatorTreeWrapperPass16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    AU.setPreservesAll();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeWrapperPass::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 251,
   FQN="llvm::DominatorTreeWrapperPass::releaseMemory", NM="_ZN4llvm24DominatorTreeWrapperPass13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm24DominatorTreeWrapperPass13releaseMemoryEv")
  //</editor-fold>
  @Override public void releaseMemory()/* override*/ {
    DT.releaseMemory();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeWrapperPass::print">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Dominators.cpp", line = 352,
   FQN="llvm::DominatorTreeWrapperPass::print", NM="_ZNK4llvm24DominatorTreeWrapperPass5printERNS_11raw_ostreamEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZNK4llvm24DominatorTreeWrapperPass5printERNS_11raw_ostreamEPKNS_6ModuleE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*//* override*/ {
    print(OS, (/*const*/ Module /*P*/ )null);
  }
  @Override public void print(final raw_ostream /*&*/ OS, /*const*/ Module /*P*/ $Prm1/*= null*/) /*const*//* override*/ {
    DT.print(OS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeWrapperPass::~DominatorTreeWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 230,
   FQN="llvm::DominatorTreeWrapperPass::~DominatorTreeWrapperPass", NM="_ZN4llvm24DominatorTreeWrapperPassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm24DominatorTreeWrapperPassD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    DT.$destroy();
    super.$destroy();
    //END JDestroy
  }


  @Override public String toString() {
    return "" + "DT=" + DT // NOI18N
              + super.toString(); // NOI18N
  }
}
