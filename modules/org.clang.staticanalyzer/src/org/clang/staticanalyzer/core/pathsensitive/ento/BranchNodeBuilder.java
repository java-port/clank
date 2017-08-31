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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


/// \brief BranchNodeBuilder is responsible for constructing the nodes
/// corresponding to the two branches of the if statement - true and false.
//<editor-fold defaultstate="collapsed" desc="clang::ento::BranchNodeBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 401,
 FQN="clang::ento::BranchNodeBuilder", NM="_ZN5clang4ento17BranchNodeBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento17BranchNodeBuilderE")
//</editor-fold>
public class BranchNodeBuilder extends /*public*/ NodeBuilder implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BranchNodeBuilder::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 670,
   FQN="clang::ento::BranchNodeBuilder::anchor", NM="_ZN5clang4ento17BranchNodeBuilder6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento17BranchNodeBuilder6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  private /*const*/ CFGBlock /*P*/ DstT;
  private /*const*/ CFGBlock /*P*/ DstF;
  
  private boolean InFeasibleTrue;
  private boolean InFeasibleFalse;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BranchNodeBuilder::BranchNodeBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 410,
   FQN="clang::ento::BranchNodeBuilder::BranchNodeBuilder", NM="_ZN5clang4ento17BranchNodeBuilderC1EPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetERKNS0_18NodeBuilderContextEPKNS_8CFGBlockESB_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento17BranchNodeBuilderC1EPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetERKNS0_18NodeBuilderContextEPKNS_8CFGBlockESB_")
  //</editor-fold>
  public BranchNodeBuilder(ExplodedNode /*P*/ SrcNode, final ExplodedNodeSet /*&*/ DstSet, 
      final /*const*/ NodeBuilderContext /*&*/ C, 
      /*const*/ CFGBlock /*P*/ dstT, /*const*/ CFGBlock /*P*/ dstF) {
    // : NodeBuilder(SrcNode, DstSet, C), DstT(dstT), DstF(dstF), InFeasibleTrue(!DstT), InFeasibleFalse(!DstF) 
    //START JInit
    super(SrcNode, DstSet, C);
    this.DstT = dstT;
    this.DstF = dstF;
    this.InFeasibleTrue = !(DstT != null);
    this.InFeasibleFalse = !(DstF != null);
    //END JInit
    // The branch node builder does not generate autotransitions.
    // If there are no successors it means that both branches are infeasible.
    takeNodes(SrcNode);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BranchNodeBuilder::BranchNodeBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 420,
   FQN="clang::ento::BranchNodeBuilder::BranchNodeBuilder", NM="_ZN5clang4ento17BranchNodeBuilderC1ERKNS0_15ExplodedNodeSetERS2_RKNS0_18NodeBuilderContextEPKNS_8CFGBlockESB_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento17BranchNodeBuilderC1ERKNS0_15ExplodedNodeSetERS2_RKNS0_18NodeBuilderContextEPKNS_8CFGBlockESB_")
  //</editor-fold>
  public BranchNodeBuilder(final /*const*/ ExplodedNodeSet /*&*/ SrcSet, final ExplodedNodeSet /*&*/ DstSet, 
      final /*const*/ NodeBuilderContext /*&*/ C, 
      /*const*/ CFGBlock /*P*/ dstT, /*const*/ CFGBlock /*P*/ dstF) {
    // : NodeBuilder(SrcSet, DstSet, C), DstT(dstT), DstF(dstF), InFeasibleTrue(!DstT), InFeasibleFalse(!DstF) 
    //START JInit
    super(SrcSet, DstSet, C);
    this.DstT = dstT;
    this.DstF = dstF;
    this.InFeasibleTrue = !(DstT != null);
    this.InFeasibleFalse = !(DstF != null);
    //END JInit
    takeNodes(SrcSet);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BranchNodeBuilder::generateNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 672,
   FQN="clang::ento::BranchNodeBuilder::generateNode", NM="_ZN5clang4ento17BranchNodeBuilder12generateNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEbPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento17BranchNodeBuilder12generateNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEbPNS0_12ExplodedNodeE")
  //</editor-fold>
  public ExplodedNode /*P*/ generateNode(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
              boolean branch, 
              ExplodedNode /*P*/ NodePred) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // If the branch has been marked infeasible we should not generate a node.
      if (!isFeasible(branch)) {
        return null;
      }
      
      ProgramPoint Loc = new ProgramPoint(JD$Move.INSTANCE, new BlockEdge(C.Block, branch ? DstT : DstF, 
              NodePred.getLocationContext()));
      ExplodedNode /*P*/ Succ = $c$.clean(generateNodeImpl(Loc, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), NodePred));
      return Succ;
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BranchNodeBuilder::getTargetBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 431,
   FQN="clang::ento::BranchNodeBuilder::getTargetBlock", NM="_ZNK5clang4ento17BranchNodeBuilder14getTargetBlockEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZNK5clang4ento17BranchNodeBuilder14getTargetBlockEb")
  //</editor-fold>
  public /*const*/ CFGBlock /*P*/ getTargetBlock(boolean branch) /*const*/ {
    return branch ? DstT : DstF;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BranchNodeBuilder::markInfeasible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 435,
   FQN="clang::ento::BranchNodeBuilder::markInfeasible", NM="_ZN5clang4ento17BranchNodeBuilder14markInfeasibleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento17BranchNodeBuilder14markInfeasibleEb")
  //</editor-fold>
  public void markInfeasible(boolean branch) {
    if (branch) {
      InFeasibleTrue = true;
    } else {
      InFeasibleFalse = true;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BranchNodeBuilder::isFeasible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 442,
   FQN="clang::ento::BranchNodeBuilder::isFeasible", NM="_ZN5clang4ento17BranchNodeBuilder10isFeasibleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento17BranchNodeBuilder10isFeasibleEb")
  //</editor-fold>
  public boolean isFeasible(boolean branch) {
    return branch ? !InFeasibleTrue : !InFeasibleFalse;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BranchNodeBuilder::~BranchNodeBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 401,
   FQN="clang::ento::BranchNodeBuilder::~BranchNodeBuilder", NM="_ZN5clang4ento17BranchNodeBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento17BranchNodeBuilderD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "DstT=" + DstT // NOI18N
              + ", DstF=" + DstF // NOI18N
              + ", InFeasibleTrue=" + InFeasibleTrue // NOI18N
              + ", InFeasibleFalse=" + InFeasibleFalse // NOI18N
              + super.toString(); // NOI18N
  }
}
