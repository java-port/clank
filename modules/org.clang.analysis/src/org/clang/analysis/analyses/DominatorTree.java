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

package org.clang.analysis.analyses;

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.basic.*;
import org.clang.analysis.*;
import org.clang.analysis.analyses.*;
import org.clang.analysis.llvm.GraphTraitsCFG$P;
import org.clang.analysis.llvm.GraphTraitsCFGBlock$P;
import org.clang.analysis.llvm.GraphTraitsInverse$CFGBlock$P;
import org.clank.java.std;


/// \brief Concrete subclass of DominatorTreeBase for Clang
/// This class implements the dominators tree functionality given a Clang CFG.
///
//<editor-fold defaultstate="collapsed" desc="clang::DominatorTree">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 38,
 FQN="clang::DominatorTree", NM="_ZN5clang13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZN5clang13DominatorTreeE")
//</editor-fold>
public class DominatorTree extends /*public*/ ManagedAnalysis implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::DominatorTree::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp", line = 14,
   FQN="clang::DominatorTree::anchor", NM="_ZN5clang13DominatorTree6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZN5clang13DominatorTree6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*public:*/
  public DominatorTreeBase<CFGBlock> /*P*/ DT;
  
  //<editor-fold defaultstate="collapsed" desc="clang::DominatorTree::DominatorTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 43,
   FQN="clang::DominatorTree::DominatorTree", NM="_ZN5clang13DominatorTreeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZN5clang13DominatorTreeC1Ev")
  //</editor-fold>
  public DominatorTree() {
    // : ManagedAnalysis() 
    //START JInit
    super();
    //END JInit
    DT = new DominatorTreeBase<CFGBlock>(GraphTraitsCFGBlock$P.$GTraits(), GraphTraitsInverse$CFGBlock$P.$GTraits(), 
            (CFGBlock A)->A.getParent(), (CFGBlock A)->A.getParent().front(), false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DominatorTree::~DominatorTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 47,
   FQN="clang::DominatorTree::~DominatorTree", NM="_ZN5clang13DominatorTreeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZN5clang13DominatorTreeD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    if (DT != null) { DT.$destroy();};
    super.$destroy();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DominatorTree::getBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 49,
   FQN="clang::DominatorTree::getBase", NM="_ZN5clang13DominatorTree7getBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZN5clang13DominatorTree7getBaseEv")
  //</editor-fold>
  public DominatorTreeBase<CFGBlock> /*&*/ getBase() {
    return $Deref(DT);
  }

  
  /// \brief This method returns the root CFGBlock of the dominators tree.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::DominatorTree::getRoot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 53,
   FQN="clang::DominatorTree::getRoot", NM="_ZNK5clang13DominatorTree7getRootEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZNK5clang13DominatorTree7getRootEv")
  //</editor-fold>
  public /*inline*/ CFGBlock /*P*/ getRoot() /*const*/ {
    return DT.getRoot();
  }

  
  /// \brief This method returns the root DomTreeNode, which is the wrapper
  /// for CFGBlock.
  //<editor-fold defaultstate="collapsed" desc="clang::DominatorTree::getRootNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 59,
   FQN="clang::DominatorTree::getRootNode", NM="_ZNK5clang13DominatorTree11getRootNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZNK5clang13DominatorTree11getRootNodeEv")
  //</editor-fold>
  public /*inline*/ DomTreeNodeBase<CFGBlock> /*P*/ getRootNode() /*const*/ {
    return DT.getRootNode();
  }

  
  /// \brief This method compares two dominator trees.
  /// The method returns false if the other dominator tree matches this
  /// dominator tree, otherwise returns true.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::DominatorTree::compare">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 67,
   FQN="clang::DominatorTree::compare", NM="_ZNK5clang13DominatorTree7compareERS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZNK5clang13DominatorTree7compareERS0_")
  //</editor-fold>
  public /*inline*/ boolean compare(final DominatorTree /*&*/ Other) /*const*/ {
    DomTreeNodeBase<CFGBlock> /*P*/ R = getRootNode();
    DomTreeNodeBase<CFGBlock> /*P*/ OtherR = Other.getRootNode();
    if (!(R != null) || !(OtherR != null) || R.getBlock() != OtherR.getBlock()) {
      return true;
    }
    if (DT.compare(Other.getBase())) {
      return true;
    }
    
    return false;
  }

  
  /// \brief This method builds the dominator tree for a given CFG
  /// The CFG information is passed via AnalysisDeclContext
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::DominatorTree::buildDominatorTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 83,
   FQN="clang::DominatorTree::buildDominatorTree", NM="_ZN5clang13DominatorTree18buildDominatorTreeERNS_19AnalysisDeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZN5clang13DominatorTree18buildDominatorTreeERNS_19AnalysisDeclContextE")
  //</editor-fold>
  public void buildDominatorTree(final AnalysisDeclContext /*&*/ AC) {
    cfg = AC.getCFG();
    DT.recalculate(GraphTraitsCFG$P.$GTraits(), $Deref(cfg));
  }

  
  /// \brief This method dumps immediate dominators for each block,
  /// mainly used for debug purposes.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::DominatorTree::dump">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 91,
   FQN="clang::DominatorTree::dump", NM="_ZN5clang13DominatorTree4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZN5clang13DominatorTree4dumpEv")
  //</editor-fold>
  public void dump() {
    dump(llvm.errs());
  }
  public void dump(raw_ostream OS) {
    OS.$out(/*KEEP_STR*/"Immediate dominance tree (Node#,IDom#):\n");
    for (type$ptr<CFGBlock> I = $tryClone(cfg.begin()), 
        /*P*/ E = $tryClone(cfg.end()); $noteq_ptr(I, E); I.$preInc()) {
      if ((DT.getNode(I.$star()).getIDom() != null)) {
        OS.$out(/*KEEP_STR*/$LPAREN).$out_uint((I.$star()).getBlockID()).$out(
            /*KEEP_STR*/$COMMA
        ).$out_uint(
            DT.getNode(I.$star()).getIDom().getBlock().getBlockID()
        ).$out(
            /*KEEP_STR*/")\n"
        );
      } else {
        OS.$out(/*KEEP_STR*/$LPAREN).$out_uint((I.$star()).getBlockID()).$out(
            /*KEEP_STR*/$COMMA
        ).$out_uint((I.$star()).getBlockID()).$out(/*KEEP_STR*/")\n");
      }
    }
  }

  
  /// \brief This method tests if one CFGBlock dominates the other.
  /// The method return true if A dominates B, false otherwise.
  /// Note a block always dominates itself.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::DominatorTree::dominates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 109,
   FQN="clang::DominatorTree::dominates", NM="_ZNK5clang13DominatorTree9dominatesEPKNS_8CFGBlockES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZNK5clang13DominatorTree9dominatesEPKNS_8CFGBlockES3_")
  //</editor-fold>
  public /*inline*/ boolean dominates(/*const*/ CFGBlock /*P*/ A, /*const*/ CFGBlock /*P*/ B) /*const*/ {
    return DT.dominates(A, B);
  }

  
  /// \brief This method tests if one CFGBlock properly dominates the other.
  /// The method return true if A properly dominates B, false otherwise.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::DominatorTree::properlyDominates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 116,
   FQN="clang::DominatorTree::properlyDominates", NM="_ZNK5clang13DominatorTree17properlyDominatesEPKNS_8CFGBlockES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZNK5clang13DominatorTree17properlyDominatesEPKNS_8CFGBlockES3_")
  //</editor-fold>
  public boolean properlyDominates(/*const*/ CFGBlock /*P*/ A, /*const*/ CFGBlock /*P*/ B) /*const*/ {
    return DT.properlyDominates(A, B);
  }

  
  /// \brief This method finds the nearest common dominator CFG block
  /// for CFG block A and B. If there is no such block then return NULL.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::DominatorTree::findNearestCommonDominator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 123,
   FQN="clang::DominatorTree::findNearestCommonDominator", NM="_ZN5clang13DominatorTree26findNearestCommonDominatorEPNS_8CFGBlockES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZN5clang13DominatorTree26findNearestCommonDominatorEPNS_8CFGBlockES2_")
  //</editor-fold>
  public /*inline*/ CFGBlock /*P*/ findNearestCommonDominator_CFGBlock$P(CFGBlock /*P*/ A, CFGBlock /*P*/ B) {
    return DT.findNearestCommonDominator_T$P(A, B);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DominatorTree::findNearestCommonDominator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 127,
   FQN="clang::DominatorTree::findNearestCommonDominator", NM="_ZN5clang13DominatorTree26findNearestCommonDominatorEPKNS_8CFGBlockES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZN5clang13DominatorTree26findNearestCommonDominatorEPKNS_8CFGBlockES3_")
  //</editor-fold>
  public /*inline*/ /*const*/ CFGBlock /*P*/ findNearestCommonDominator_CFGBlock$C$P(/*const*/ CFGBlock /*P*/ A, 
                                         /*const*/ CFGBlock /*P*/ B) {
    return DT.findNearestCommonDominator_T$C$P(A, B);
  }

  
  /// \brief This method is used to update the dominator
  /// tree information when a node's immediate dominator changes.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::DominatorTree::changeImmediateDominator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 135,
   FQN="clang::DominatorTree::changeImmediateDominator", NM="_ZN5clang13DominatorTree24changeImmediateDominatorEPNS_8CFGBlockES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZN5clang13DominatorTree24changeImmediateDominatorEPNS_8CFGBlockES2_")
  //</editor-fold>
  public /*inline*/ void changeImmediateDominator(CFGBlock /*P*/ N, CFGBlock /*P*/ NewIDom) {
    DT.changeImmediateDominator(N, NewIDom);
  }

  
  /// \brief This method tests if the given CFGBlock can be reachable from root.
  /// Returns true if reachable, false otherwise.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::DominatorTree::isReachableFromEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 142,
   FQN="clang::DominatorTree::isReachableFromEntry", NM="_ZN5clang13DominatorTree20isReachableFromEntryEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZN5clang13DominatorTree20isReachableFromEntryEPKNS_8CFGBlockE")
  //</editor-fold>
  public boolean isReachableFromEntry(/*const*/ CFGBlock /*P*/ A) {
    return DT.isReachableFromEntry(A);
  }

  
  /// \brief This method releases the memory held by the dominator tree.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::DominatorTree::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 148,
   FQN="clang::DominatorTree::releaseMemory", NM="_ZN5clang13DominatorTree13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZN5clang13DominatorTree13releaseMemoryEv")
  //</editor-fold>
  public /*virtual*/ void releaseMemory() {
    DT.releaseMemory();
  }

  
  /// \brief This method converts the dominator tree to human readable form.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::DominatorTree::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Dominators.h", line = 154,
   FQN="clang::DominatorTree::print", NM="_ZNK5clang13DominatorTree5printERN4llvm11raw_ostreamEPKNS1_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Dominators.cpp -nm=_ZNK5clang13DominatorTree5printERN4llvm11raw_ostreamEPKNS1_6ModuleE")
  //</editor-fold>
  public /*virtual*/ void print(final raw_ostream /*&*/ OS) /*const*/ {
    print(OS, (/*const*/ Module /*P*/ )null);
  }
  public /*virtual*/ void print(final raw_ostream /*&*/ OS, /*const*/ Module /*P*/ M/*= null*/) /*const*/ {
    DT.print(OS);
  }

/*private:*/
  private CFG /*P*/ cfg;
  
  @Override public String toString() {
    if (true) {
      std.string Buf = new std.string();
      raw_string_ostream OS = new raw_string_ostream(Buf);    
      dump(OS);
      OS.flush();      
      return Buf.toJavaString();
    }    
    return "" + "DT=" + DT // NOI18N
              + ", cfg=" + cfg // NOI18N
              + super.toString(); // NOI18N
  }
}
